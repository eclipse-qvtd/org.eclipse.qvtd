package org.eclipse.qvtd.xtext.qvtrelation.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalQVTrelationParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_SINGLE_QUOTED_STRING", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'{'", "','", "'++'", "'}'", "'='", "';'", "'checkonly'", "'enforce'", "'replace'", "'domain'", "'implementedby'", "'default_values'", "'key'", "'opposite'", "'('", "')'", "'primitive'", "'query'", "'top'", "'default'", "'relation'", "'overrides'", "'::'", "'transformation'", "'extends'", "'import'", "'*'", "'when'", "'where'", "'library'", "'-'", "'not'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'Lambda'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'in'", "'|'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'|?'", "'|1'", "'?'", "'&&'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_DOUBLE_QUOTED_STRING=10;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_ESCAPED_ID=5;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_LETTER_CHARACTER=9;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int RULE_ESCAPED_CHARACTER=8;
    public static final int T__95=95;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=11;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int RULE_SIMPLE_ID=4;
    public static final int T__83=83;
    public static final int RULE_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalQVTrelationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQVTrelationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQVTrelationParser.tokenNames; }
    public String getGrammarFileName() { return "InternalQVTrelation.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private QVTrelationGrammarAccess grammarAccess;
     	
        public InternalQVTrelationParser(TokenStream input, QVTrelationGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TopLevelCS";	
       	}
       	
       	@Override
       	protected QVTrelationGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTopLevelCS"
    // InternalQVTrelation.g:80:1: entryRuleTopLevelCS returns [EObject current=null] : iv_ruleTopLevelCS= ruleTopLevelCS EOF ;
    public final EObject entryRuleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelCS = null;


        try {
            // InternalQVTrelation.g:81:2: (iv_ruleTopLevelCS= ruleTopLevelCS EOF )
            // InternalQVTrelation.g:82:2: iv_ruleTopLevelCS= ruleTopLevelCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopLevelCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTopLevelCS=ruleTopLevelCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopLevelCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:89:1: ruleTopLevelCS returns [EObject current=null] : ( ( (lv_ownedImports_0_0= ruleUnitCS ) )* ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )* ) ;
    public final EObject ruleTopLevelCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedImports_0_0 = null;

        EObject lv_ownedTransformations_1_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:92:28: ( ( ( (lv_ownedImports_0_0= ruleUnitCS ) )* ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )* ) )
            // InternalQVTrelation.g:93:1: ( ( (lv_ownedImports_0_0= ruleUnitCS ) )* ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )* )
            {
            // InternalQVTrelation.g:93:1: ( ( (lv_ownedImports_0_0= ruleUnitCS ) )* ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )* )
            // InternalQVTrelation.g:93:2: ( (lv_ownedImports_0_0= ruleUnitCS ) )* ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )*
            {
            // InternalQVTrelation.g:93:2: ( (lv_ownedImports_0_0= ruleUnitCS ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==42) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalQVTrelation.g:94:1: (lv_ownedImports_0_0= ruleUnitCS )
            	    {
            	    // InternalQVTrelation.g:94:1: (lv_ownedImports_0_0= ruleUnitCS )
            	    // InternalQVTrelation.g:95:3: lv_ownedImports_0_0= ruleUnitCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedImportsUnitCSParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_ownedImports_0_0=ruleUnitCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedImports",
            	              		lv_ownedImports_0_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnitCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalQVTrelation.g:111:3: ( (lv_ownedTransformations_1_0= ruleTransformationCS ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==40) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalQVTrelation.g:112:1: (lv_ownedTransformations_1_0= ruleTransformationCS )
            	    {
            	    // InternalQVTrelation.g:112:1: (lv_ownedTransformations_1_0= ruleTransformationCS )
            	    // InternalQVTrelation.g:113:3: lv_ownedTransformations_1_0= ruleTransformationCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsTransformationCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_ownedTransformations_1_0=ruleTransformationCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedTransformations",
            	              		lv_ownedTransformations_1_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TransformationCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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


    // $ANTLR start "entryRuleCollectionTemplateCS"
    // InternalQVTrelation.g:137:1: entryRuleCollectionTemplateCS returns [EObject current=null] : iv_ruleCollectionTemplateCS= ruleCollectionTemplateCS EOF ;
    public final EObject entryRuleCollectionTemplateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTemplateCS = null;


        try {
            // InternalQVTrelation.g:138:2: (iv_ruleCollectionTemplateCS= ruleCollectionTemplateCS EOF )
            // InternalQVTrelation.g:139:2: iv_ruleCollectionTemplateCS= ruleCollectionTemplateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTemplateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionTemplateCS=ruleCollectionTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTemplateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionTemplateCS"


    // $ANTLR start "ruleCollectionTemplateCS"
    // InternalQVTrelation.g:146:1: ruleCollectionTemplateCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleCollectionTypeCS ) ) otherlv_3= '{' ( ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) ) (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )* otherlv_7= '++' ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleCollectionTemplateCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedMemberIdentifiers_4_1 = null;

        EObject lv_ownedMemberIdentifiers_4_2 = null;

        EObject lv_ownedMemberIdentifiers_6_1 = null;

        EObject lv_ownedMemberIdentifiers_6_2 = null;

        EObject lv_ownedRestIdentifier_8_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:149:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleCollectionTypeCS ) ) otherlv_3= '{' ( ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) ) (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )* otherlv_7= '++' ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) ) )? otherlv_9= '}' ) )
            // InternalQVTrelation.g:150:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleCollectionTypeCS ) ) otherlv_3= '{' ( ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) ) (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )* otherlv_7= '++' ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) ) )? otherlv_9= '}' )
            {
            // InternalQVTrelation.g:150:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleCollectionTypeCS ) ) otherlv_3= '{' ( ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) ) (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )* otherlv_7= '++' ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) ) )? otherlv_9= '}' )
            // InternalQVTrelation.g:150:2: ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleCollectionTypeCS ) ) otherlv_3= '{' ( ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) ) (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )* otherlv_7= '++' ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) ) )? otherlv_9= '}'
            {
            // InternalQVTrelation.g:150:2: ( (lv_name_0_0= ruleUnrestrictedName ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_SIMPLE_ID && LA3_0<=RULE_ESCAPED_ID)||(LA3_0>=23 && LA3_0<=30)||(LA3_0>=33 && LA3_0<=38)||(LA3_0>=40 && LA3_0<=42)||(LA3_0>=44 && LA3_0<=46)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalQVTrelation.g:151:1: (lv_name_0_0= ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:151:1: (lv_name_0_0= ruleUnrestrictedName )
                    // InternalQVTrelation.g:152:3: lv_name_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTemplateCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_name_0_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTemplateCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionTemplateCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTrelation.g:172:1: ( (lv_ownedType_2_0= ruleCollectionTypeCS ) )
            // InternalQVTrelation.g:173:1: (lv_ownedType_2_0= ruleCollectionTypeCS )
            {
            // InternalQVTrelation.g:173:1: (lv_ownedType_2_0= ruleCollectionTypeCS )
            // InternalQVTrelation.g:174:3: lv_ownedType_2_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTemplateCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_ownedType_2_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionTemplateCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_2_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCollectionTemplateCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // InternalQVTrelation.g:194:1: ( ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) ) (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )* otherlv_7= '++' ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_SIMPLE_ID && LA7_0<=RULE_ESCAPED_ID)||LA7_0==16||(LA7_0>=23 && LA7_0<=30)||(LA7_0>=33 && LA7_0<=38)||(LA7_0>=40 && LA7_0<=42)||(LA7_0>=44 && LA7_0<=46)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalQVTrelation.g:194:2: ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) ) (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )* otherlv_7= '++' ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) )
                    {
                    // InternalQVTrelation.g:194:2: ( ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) ) )
                    // InternalQVTrelation.g:195:1: ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) )
                    {
                    // InternalQVTrelation.g:195:1: ( (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS ) )
                    // InternalQVTrelation.g:196:1: (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS )
                    {
                    // InternalQVTrelation.g:196:1: (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS )
                    int alt4=2;
                    alt4 = dfa4.predict(input);
                    switch (alt4) {
                        case 1 :
                            // InternalQVTrelation.g:197:3: lv_ownedMemberIdentifiers_4_1= ruleTemplateCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionTemplateCSAccess().getOwnedMemberIdentifiersTemplateCSParserRuleCall_4_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_ownedMemberIdentifiers_4_1=ruleTemplateCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCollectionTemplateCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedMemberIdentifiers",
                                      		lv_ownedMemberIdentifiers_4_1, 
                                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TemplateCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalQVTrelation.g:212:8: lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionTemplateCSAccess().getOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_0_0_1()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_ownedMemberIdentifiers_4_2=ruleElementTemplateCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCollectionTemplateCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedMemberIdentifiers",
                                      		lv_ownedMemberIdentifiers_4_2, 
                                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ElementTemplateCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalQVTrelation.g:230:2: (otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==18) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalQVTrelation.g:230:4: otherlv_5= ',' ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) )
                    	    {
                    	    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getCollectionTemplateCSAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:234:1: ( ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) ) )
                    	    // InternalQVTrelation.g:235:1: ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) )
                    	    {
                    	    // InternalQVTrelation.g:235:1: ( (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS ) )
                    	    // InternalQVTrelation.g:236:1: (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS )
                    	    {
                    	    // InternalQVTrelation.g:236:1: (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS )
                    	    int alt5=2;
                    	    alt5 = dfa5.predict(input);
                    	    switch (alt5) {
                    	        case 1 :
                    	            // InternalQVTrelation.g:237:3: lv_ownedMemberIdentifiers_6_1= ruleTemplateCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getCollectionTemplateCSAccess().getOwnedMemberIdentifiersTemplateCSParserRuleCall_4_1_1_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_9);
                    	            lv_ownedMemberIdentifiers_6_1=ruleTemplateCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getCollectionTemplateCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"ownedMemberIdentifiers",
                    	                      		lv_ownedMemberIdentifiers_6_1, 
                    	                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TemplateCS");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalQVTrelation.g:252:8: lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getCollectionTemplateCSAccess().getOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_1_1_0_1()); 
                    	              	    
                    	            }
                    	            pushFollow(FollowSets000.FOLLOW_9);
                    	            lv_ownedMemberIdentifiers_6_2=ruleElementTemplateCS();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getCollectionTemplateCSRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"ownedMemberIdentifiers",
                    	                      		lv_ownedMemberIdentifiers_6_2, 
                    	                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ElementTemplateCS");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getCollectionTemplateCSAccess().getPlusSignPlusSignKeyword_4_2());
                          
                    }
                    // InternalQVTrelation.g:274:1: ( (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS ) )
                    // InternalQVTrelation.g:275:1: (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS )
                    {
                    // InternalQVTrelation.g:275:1: (lv_ownedRestIdentifier_8_0= ruleElementTemplateCS )
                    // InternalQVTrelation.g:276:3: lv_ownedRestIdentifier_8_0= ruleElementTemplateCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTemplateCSAccess().getOwnedRestIdentifierElementTemplateCSParserRuleCall_4_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    lv_ownedRestIdentifier_8_0=ruleElementTemplateCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTemplateCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRestIdentifier",
                              		lv_ownedRestIdentifier_8_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ElementTemplateCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getCollectionTemplateCSAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionTemplateCS"


    // $ANTLR start "entryRuleDefaultValueCS"
    // InternalQVTrelation.g:304:1: entryRuleDefaultValueCS returns [EObject current=null] : iv_ruleDefaultValueCS= ruleDefaultValueCS EOF ;
    public final EObject entryRuleDefaultValueCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultValueCS = null;


        try {
            // InternalQVTrelation.g:305:2: (iv_ruleDefaultValueCS= ruleDefaultValueCS EOF )
            // InternalQVTrelation.g:306:2: iv_ruleDefaultValueCS= ruleDefaultValueCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultValueCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefaultValueCS=ruleDefaultValueCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultValueCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultValueCS"


    // $ANTLR start "ruleDefaultValueCS"
    // InternalQVTrelation.g:313:1: ruleDefaultValueCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_ownedInitExpression_2_0= ruleExpCS ) ) otherlv_3= ';' ) ;
    public final EObject ruleDefaultValueCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedInitExpression_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:316:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_ownedInitExpression_2_0= ruleExpCS ) ) otherlv_3= ';' ) )
            // InternalQVTrelation.g:317:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_ownedInitExpression_2_0= ruleExpCS ) ) otherlv_3= ';' )
            {
            // InternalQVTrelation.g:317:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_ownedInitExpression_2_0= ruleExpCS ) ) otherlv_3= ';' )
            // InternalQVTrelation.g:317:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_ownedInitExpression_2_0= ruleExpCS ) ) otherlv_3= ';'
            {
            // InternalQVTrelation.g:317:2: ( ( ruleUnrestrictedName ) )
            // InternalQVTrelation.g:318:1: ( ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:318:1: ( ruleUnrestrictedName )
            // InternalQVTrelation.g:319:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDefaultValueCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefaultValueCSAccess().getPropertyIdVariableCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_12);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDefaultValueCSAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalQVTrelation.g:339:1: ( (lv_ownedInitExpression_2_0= ruleExpCS ) )
            // InternalQVTrelation.g:340:1: (lv_ownedInitExpression_2_0= ruleExpCS )
            {
            // InternalQVTrelation.g:340:1: (lv_ownedInitExpression_2_0= ruleExpCS )
            // InternalQVTrelation.g:341:3: lv_ownedInitExpression_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDefaultValueCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_14);
            lv_ownedInitExpression_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDefaultValueCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_2_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDefaultValueCSAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultValueCS"


    // $ANTLR start "entryRuleDomainCS"
    // InternalQVTrelation.g:369:1: entryRuleDomainCS returns [EObject current=null] : iv_ruleDomainCS= ruleDomainCS EOF ;
    public final EObject entryRuleDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainCS = null;


        try {
            // InternalQVTrelation.g:370:2: (iv_ruleDomainCS= ruleDomainCS EOF )
            // InternalQVTrelation.g:371:2: iv_ruleDomainCS= ruleDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDomainCS=ruleDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:378:1: ruleDomainCS returns [EObject current=null] : ( ( ( (lv_isCheckonly_0_0= 'checkonly' ) ) | ( (lv_isEnforce_1_0= 'enforce' ) ) | otherlv_2= 'replace' )? otherlv_3= 'domain' ( ( ruleUnrestrictedName ) ) ( (lv_ownedPattern_5_0= ruleDomainPatternCS ) ) (otherlv_6= ',' ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) ) )* (otherlv_8= 'implementedby' ( (lv_implementedBy_9_0= ruleUnrestrictedName ) ) )? (otherlv_10= 'default_values' otherlv_11= '{' ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+ otherlv_13= '}' )? otherlv_14= ';' ) ;
    public final EObject ruleDomainCS() throws RecognitionException {
        EObject current = null;

        Token lv_isCheckonly_0_0=null;
        Token lv_isEnforce_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        EObject lv_ownedPattern_5_0 = null;

        EObject lv_ownedPattern_7_0 = null;

        AntlrDatatypeRuleToken lv_implementedBy_9_0 = null;

        EObject lv_ownedDefaultValues_12_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:381:28: ( ( ( ( (lv_isCheckonly_0_0= 'checkonly' ) ) | ( (lv_isEnforce_1_0= 'enforce' ) ) | otherlv_2= 'replace' )? otherlv_3= 'domain' ( ( ruleUnrestrictedName ) ) ( (lv_ownedPattern_5_0= ruleDomainPatternCS ) ) (otherlv_6= ',' ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) ) )* (otherlv_8= 'implementedby' ( (lv_implementedBy_9_0= ruleUnrestrictedName ) ) )? (otherlv_10= 'default_values' otherlv_11= '{' ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+ otherlv_13= '}' )? otherlv_14= ';' ) )
            // InternalQVTrelation.g:382:1: ( ( ( (lv_isCheckonly_0_0= 'checkonly' ) ) | ( (lv_isEnforce_1_0= 'enforce' ) ) | otherlv_2= 'replace' )? otherlv_3= 'domain' ( ( ruleUnrestrictedName ) ) ( (lv_ownedPattern_5_0= ruleDomainPatternCS ) ) (otherlv_6= ',' ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) ) )* (otherlv_8= 'implementedby' ( (lv_implementedBy_9_0= ruleUnrestrictedName ) ) )? (otherlv_10= 'default_values' otherlv_11= '{' ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+ otherlv_13= '}' )? otherlv_14= ';' )
            {
            // InternalQVTrelation.g:382:1: ( ( ( (lv_isCheckonly_0_0= 'checkonly' ) ) | ( (lv_isEnforce_1_0= 'enforce' ) ) | otherlv_2= 'replace' )? otherlv_3= 'domain' ( ( ruleUnrestrictedName ) ) ( (lv_ownedPattern_5_0= ruleDomainPatternCS ) ) (otherlv_6= ',' ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) ) )* (otherlv_8= 'implementedby' ( (lv_implementedBy_9_0= ruleUnrestrictedName ) ) )? (otherlv_10= 'default_values' otherlv_11= '{' ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+ otherlv_13= '}' )? otherlv_14= ';' )
            // InternalQVTrelation.g:382:2: ( ( (lv_isCheckonly_0_0= 'checkonly' ) ) | ( (lv_isEnforce_1_0= 'enforce' ) ) | otherlv_2= 'replace' )? otherlv_3= 'domain' ( ( ruleUnrestrictedName ) ) ( (lv_ownedPattern_5_0= ruleDomainPatternCS ) ) (otherlv_6= ',' ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) ) )* (otherlv_8= 'implementedby' ( (lv_implementedBy_9_0= ruleUnrestrictedName ) ) )? (otherlv_10= 'default_values' otherlv_11= '{' ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+ otherlv_13= '}' )? otherlv_14= ';'
            {
            // InternalQVTrelation.g:382:2: ( ( (lv_isCheckonly_0_0= 'checkonly' ) ) | ( (lv_isEnforce_1_0= 'enforce' ) ) | otherlv_2= 'replace' )?
            int alt8=4;
            switch ( input.LA(1) ) {
                case 23:
                    {
                    alt8=1;
                    }
                    break;
                case 24:
                    {
                    alt8=2;
                    }
                    break;
                case 25:
                    {
                    alt8=3;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // InternalQVTrelation.g:382:3: ( (lv_isCheckonly_0_0= 'checkonly' ) )
                    {
                    // InternalQVTrelation.g:382:3: ( (lv_isCheckonly_0_0= 'checkonly' ) )
                    // InternalQVTrelation.g:383:1: (lv_isCheckonly_0_0= 'checkonly' )
                    {
                    // InternalQVTrelation.g:383:1: (lv_isCheckonly_0_0= 'checkonly' )
                    // InternalQVTrelation.g:384:3: lv_isCheckonly_0_0= 'checkonly'
                    {
                    lv_isCheckonly_0_0=(Token)match(input,23,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isCheckonly_0_0, grammarAccess.getDomainCSAccess().getIsCheckonlyCheckonlyKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDomainCSRule());
                      	        }
                             		setWithLastConsumed(current, "isCheckonly", true, "checkonly");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:398:6: ( (lv_isEnforce_1_0= 'enforce' ) )
                    {
                    // InternalQVTrelation.g:398:6: ( (lv_isEnforce_1_0= 'enforce' ) )
                    // InternalQVTrelation.g:399:1: (lv_isEnforce_1_0= 'enforce' )
                    {
                    // InternalQVTrelation.g:399:1: (lv_isEnforce_1_0= 'enforce' )
                    // InternalQVTrelation.g:400:3: lv_isEnforce_1_0= 'enforce'
                    {
                    lv_isEnforce_1_0=(Token)match(input,24,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isEnforce_1_0, grammarAccess.getDomainCSAccess().getIsEnforceEnforceKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDomainCSRule());
                      	        }
                             		setWithLastConsumed(current, "isEnforce", true, "enforce");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:414:7: otherlv_2= 'replace'
                    {
                    otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDomainCSAccess().getReplaceKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_3=(Token)match(input,26,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDomainCSAccess().getDomainKeyword_1());
                  
            }
            // InternalQVTrelation.g:422:1: ( ( ruleUnrestrictedName ) )
            // InternalQVTrelation.g:423:1: ( ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:423:1: ( ruleUnrestrictedName )
            // InternalQVTrelation.g:424:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDomainCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDomainCSAccess().getModelIdTypedModelCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_10);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:440:2: ( (lv_ownedPattern_5_0= ruleDomainPatternCS ) )
            // InternalQVTrelation.g:441:1: (lv_ownedPattern_5_0= ruleDomainPatternCS )
            {
            // InternalQVTrelation.g:441:1: (lv_ownedPattern_5_0= ruleDomainPatternCS )
            // InternalQVTrelation.g:442:3: lv_ownedPattern_5_0= ruleDomainPatternCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDomainCSAccess().getOwnedPatternDomainPatternCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_17);
            lv_ownedPattern_5_0=ruleDomainPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDomainCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPattern",
                      		lv_ownedPattern_5_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.DomainPatternCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:458:2: (otherlv_6= ',' ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalQVTrelation.g:458:4: otherlv_6= ',' ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) )
            	    {
            	    otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getDomainCSAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // InternalQVTrelation.g:462:1: ( (lv_ownedPattern_7_0= ruleDomainPatternCS ) )
            	    // InternalQVTrelation.g:463:1: (lv_ownedPattern_7_0= ruleDomainPatternCS )
            	    {
            	    // InternalQVTrelation.g:463:1: (lv_ownedPattern_7_0= ruleDomainPatternCS )
            	    // InternalQVTrelation.g:464:3: lv_ownedPattern_7_0= ruleDomainPatternCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDomainCSAccess().getOwnedPatternDomainPatternCSParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    lv_ownedPattern_7_0=ruleDomainPatternCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDomainCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPattern",
            	              		lv_ownedPattern_7_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.DomainPatternCS");
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

            // InternalQVTrelation.g:480:4: (otherlv_8= 'implementedby' ( (lv_implementedBy_9_0= ruleUnrestrictedName ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalQVTrelation.g:480:6: otherlv_8= 'implementedby' ( (lv_implementedBy_9_0= ruleUnrestrictedName ) )
                    {
                    otherlv_8=(Token)match(input,27,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDomainCSAccess().getImplementedbyKeyword_5_0());
                          
                    }
                    // InternalQVTrelation.g:484:1: ( (lv_implementedBy_9_0= ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:485:1: (lv_implementedBy_9_0= ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:485:1: (lv_implementedBy_9_0= ruleUnrestrictedName )
                    // InternalQVTrelation.g:486:3: lv_implementedBy_9_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDomainCSAccess().getImplementedByUnrestrictedNameParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_implementedBy_9_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDomainCSRule());
                      	        }
                             		set(
                             			current, 
                             			"implementedBy",
                              		lv_implementedBy_9_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:502:4: (otherlv_10= 'default_values' otherlv_11= '{' ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+ otherlv_13= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalQVTrelation.g:502:6: otherlv_10= 'default_values' otherlv_11= '{' ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+ otherlv_13= '}'
                    {
                    otherlv_10=(Token)match(input,28,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getDomainCSAccess().getDefault_valuesKeyword_6_0());
                          
                    }
                    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDomainCSAccess().getLeftCurlyBracketKeyword_6_1());
                          
                    }
                    // InternalQVTrelation.g:510:1: ( (lv_ownedDefaultValues_12_0= ruleDefaultValueCS ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=RULE_SIMPLE_ID && LA11_0<=RULE_ESCAPED_ID)||(LA11_0>=23 && LA11_0<=30)||(LA11_0>=33 && LA11_0<=38)||(LA11_0>=40 && LA11_0<=42)||(LA11_0>=44 && LA11_0<=46)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalQVTrelation.g:511:1: (lv_ownedDefaultValues_12_0= ruleDefaultValueCS )
                    	    {
                    	    // InternalQVTrelation.g:511:1: (lv_ownedDefaultValues_12_0= ruleDefaultValueCS )
                    	    // InternalQVTrelation.g:512:3: lv_ownedDefaultValues_12_0= ruleDefaultValueCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDomainCSAccess().getOwnedDefaultValuesDefaultValueCSParserRuleCall_6_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    lv_ownedDefaultValues_12_0=ruleDefaultValueCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDomainCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedDefaultValues",
                    	              		lv_ownedDefaultValues_12_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.DefaultValueCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getDomainCSAccess().getRightCurlyBracketKeyword_6_3());
                          
                    }

                    }
                    break;

            }

            otherlv_14=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getDomainCSAccess().getSemicolonKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleDomainPatternCS"
    // InternalQVTrelation.g:544:1: entryRuleDomainPatternCS returns [EObject current=null] : iv_ruleDomainPatternCS= ruleDomainPatternCS EOF ;
    public final EObject entryRuleDomainPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainPatternCS = null;


        try {
            // InternalQVTrelation.g:545:2: (iv_ruleDomainPatternCS= ruleDomainPatternCS EOF )
            // InternalQVTrelation.g:546:2: iv_ruleDomainPatternCS= ruleDomainPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDomainPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDomainPatternCS=ruleDomainPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDomainPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainPatternCS"


    // $ANTLR start "ruleDomainPatternCS"
    // InternalQVTrelation.g:553:1: ruleDomainPatternCS returns [EObject current=null] : ( (lv_ownedTemplate_0_0= ruleTemplateCS ) ) ;
    public final EObject ruleDomainPatternCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedTemplate_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:556:28: ( ( (lv_ownedTemplate_0_0= ruleTemplateCS ) ) )
            // InternalQVTrelation.g:557:1: ( (lv_ownedTemplate_0_0= ruleTemplateCS ) )
            {
            // InternalQVTrelation.g:557:1: ( (lv_ownedTemplate_0_0= ruleTemplateCS ) )
            // InternalQVTrelation.g:558:1: (lv_ownedTemplate_0_0= ruleTemplateCS )
            {
            // InternalQVTrelation.g:558:1: (lv_ownedTemplate_0_0= ruleTemplateCS )
            // InternalQVTrelation.g:559:3: lv_ownedTemplate_0_0= ruleTemplateCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDomainPatternCSAccess().getOwnedTemplateTemplateCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedTemplate_0_0=ruleTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDomainPatternCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedTemplate",
                      		lv_ownedTemplate_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TemplateCS");
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
    // $ANTLR end "ruleDomainPatternCS"


    // $ANTLR start "entryRuleElementTemplateCS"
    // InternalQVTrelation.g:583:1: entryRuleElementTemplateCS returns [EObject current=null] : iv_ruleElementTemplateCS= ruleElementTemplateCS EOF ;
    public final EObject entryRuleElementTemplateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementTemplateCS = null;


        try {
            // InternalQVTrelation.g:584:2: (iv_ruleElementTemplateCS= ruleElementTemplateCS EOF )
            // InternalQVTrelation.g:585:2: iv_ruleElementTemplateCS= ruleElementTemplateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementTemplateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElementTemplateCS=ruleElementTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementTemplateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementTemplateCS"


    // $ANTLR start "ruleElementTemplateCS"
    // InternalQVTrelation.g:592:1: ruleElementTemplateCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleElementTemplateCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:595:28: ( ( ( ruleUnrestrictedName ) ) )
            // InternalQVTrelation.g:596:1: ( ( ruleUnrestrictedName ) )
            {
            // InternalQVTrelation.g:596:1: ( ( ruleUnrestrictedName ) )
            // InternalQVTrelation.g:597:1: ( ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:597:1: ( ruleUnrestrictedName )
            // InternalQVTrelation.g:598:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getElementTemplateCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElementTemplateCSAccess().getIdentifierVariableCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
    // $ANTLR end "ruleElementTemplateCS"


    // $ANTLR start "entryRuleKeyDeclCS"
    // InternalQVTrelation.g:622:1: entryRuleKeyDeclCS returns [EObject current=null] : iv_ruleKeyDeclCS= ruleKeyDeclCS EOF ;
    public final EObject entryRuleKeyDeclCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyDeclCS = null;


        try {
            // InternalQVTrelation.g:623:2: (iv_ruleKeyDeclCS= ruleKeyDeclCS EOF )
            // InternalQVTrelation.g:624:2: iv_ruleKeyDeclCS= ruleKeyDeclCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeyDeclCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeyDeclCS=ruleKeyDeclCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyDeclCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyDeclCS"


    // $ANTLR start "ruleKeyDeclCS"
    // InternalQVTrelation.g:631:1: ruleKeyDeclCS returns [EObject current=null] : (otherlv_0= 'key' ( (lv_ownedPathName_1_0= rulePathNameCS ) ) otherlv_2= '{' ( ( ( ruleUnrestrictedName ) ) | (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' ) ) (otherlv_8= ',' ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) ) )* otherlv_14= '}' otherlv_15= ';' ) ;
    public final EObject ruleKeyDeclCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_ownedPathName_1_0 = null;

        EObject lv_ownedOppositePropertyIds_6_0 = null;

        EObject lv_ownedOppositePropertyIds_12_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:634:28: ( (otherlv_0= 'key' ( (lv_ownedPathName_1_0= rulePathNameCS ) ) otherlv_2= '{' ( ( ( ruleUnrestrictedName ) ) | (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' ) ) (otherlv_8= ',' ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) ) )* otherlv_14= '}' otherlv_15= ';' ) )
            // InternalQVTrelation.g:635:1: (otherlv_0= 'key' ( (lv_ownedPathName_1_0= rulePathNameCS ) ) otherlv_2= '{' ( ( ( ruleUnrestrictedName ) ) | (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' ) ) (otherlv_8= ',' ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) ) )* otherlv_14= '}' otherlv_15= ';' )
            {
            // InternalQVTrelation.g:635:1: (otherlv_0= 'key' ( (lv_ownedPathName_1_0= rulePathNameCS ) ) otherlv_2= '{' ( ( ( ruleUnrestrictedName ) ) | (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' ) ) (otherlv_8= ',' ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) ) )* otherlv_14= '}' otherlv_15= ';' )
            // InternalQVTrelation.g:635:3: otherlv_0= 'key' ( (lv_ownedPathName_1_0= rulePathNameCS ) ) otherlv_2= '{' ( ( ( ruleUnrestrictedName ) ) | (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' ) ) (otherlv_8= ',' ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) ) )* otherlv_14= '}' otherlv_15= ';'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getKeyDeclCSAccess().getKeyKeyword_0());
                  
            }
            // InternalQVTrelation.g:639:1: ( (lv_ownedPathName_1_0= rulePathNameCS ) )
            // InternalQVTrelation.g:640:1: (lv_ownedPathName_1_0= rulePathNameCS )
            {
            // InternalQVTrelation.g:640:1: (lv_ownedPathName_1_0= rulePathNameCS )
            // InternalQVTrelation.g:641:3: lv_ownedPathName_1_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getKeyDeclCSAccess().getOwnedPathNamePathNameCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_ownedPathName_1_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getKeyDeclCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_1_0, 
                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getKeyDeclCSAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalQVTrelation.g:661:1: ( ( ( ruleUnrestrictedName ) ) | (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_SIMPLE_ID && LA13_0<=RULE_ESCAPED_ID)||(LA13_0>=23 && LA13_0<=29)||(LA13_0>=33 && LA13_0<=38)||(LA13_0>=40 && LA13_0<=42)||(LA13_0>=44 && LA13_0<=46)) ) {
                alt13=1;
            }
            else if ( (LA13_0==30) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==18||LA13_2==20) ) {
                    alt13=1;
                }
                else if ( (LA13_2==31) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalQVTrelation.g:661:2: ( ( ruleUnrestrictedName ) )
                    {
                    // InternalQVTrelation.g:661:2: ( ( ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:662:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:662:1: ( ruleUnrestrictedName )
                    // InternalQVTrelation.g:663:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getKeyDeclCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getKeyDeclCSAccess().getPropertyIdsPropertyCrossReference_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_21);
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
                    // InternalQVTrelation.g:680:6: (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' )
                    {
                    // InternalQVTrelation.g:680:6: (otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')' )
                    // InternalQVTrelation.g:680:8: otherlv_4= 'opposite' otherlv_5= '(' ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) ) otherlv_7= ')'
                    {
                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getKeyDeclCSAccess().getOppositeKeyword_3_1_0());
                          
                    }
                    otherlv_5=(Token)match(input,31,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getKeyDeclCSAccess().getLeftParenthesisKeyword_3_1_1());
                          
                    }
                    // InternalQVTrelation.g:688:1: ( (lv_ownedOppositePropertyIds_6_0= rulePathNameCS ) )
                    // InternalQVTrelation.g:689:1: (lv_ownedOppositePropertyIds_6_0= rulePathNameCS )
                    {
                    // InternalQVTrelation.g:689:1: (lv_ownedOppositePropertyIds_6_0= rulePathNameCS )
                    // InternalQVTrelation.g:690:3: lv_ownedOppositePropertyIds_6_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getKeyDeclCSAccess().getOwnedOppositePropertyIdsPathNameCSParserRuleCall_3_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_ownedOppositePropertyIds_6_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getKeyDeclCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedOppositePropertyIds",
                              		lv_ownedOppositePropertyIds_6_0, 
                              		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,32,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getKeyDeclCSAccess().getRightParenthesisKeyword_3_1_3());
                          
                    }

                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:710:3: (otherlv_8= ',' ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==18) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalQVTrelation.g:710:5: otherlv_8= ',' ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) )
            	    {
            	    otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getKeyDeclCSAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // InternalQVTrelation.g:714:1: ( ( ( ruleUnrestrictedName ) ) | (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' ) )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( ((LA14_0>=RULE_SIMPLE_ID && LA14_0<=RULE_ESCAPED_ID)||(LA14_0>=23 && LA14_0<=29)||(LA14_0>=33 && LA14_0<=38)||(LA14_0>=40 && LA14_0<=42)||(LA14_0>=44 && LA14_0<=46)) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==30) ) {
            	        int LA14_2 = input.LA(2);

            	        if ( (LA14_2==18||LA14_2==20) ) {
            	            alt14=1;
            	        }
            	        else if ( (LA14_2==31) ) {
            	            alt14=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return current;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 14, 2, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalQVTrelation.g:714:2: ( ( ruleUnrestrictedName ) )
            	            {
            	            // InternalQVTrelation.g:714:2: ( ( ruleUnrestrictedName ) )
            	            // InternalQVTrelation.g:715:1: ( ruleUnrestrictedName )
            	            {
            	            // InternalQVTrelation.g:715:1: ( ruleUnrestrictedName )
            	            // InternalQVTrelation.g:716:3: ruleUnrestrictedName
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              		  /* */ 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              			if (current==null) {
            	              	            current = createModelElement(grammarAccess.getKeyDeclCSRule());
            	              	        }
            	                      
            	            }
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getKeyDeclCSAccess().getPropertyIdsPropertyCrossReference_4_1_0_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_21);
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
            	            // InternalQVTrelation.g:733:6: (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' )
            	            {
            	            // InternalQVTrelation.g:733:6: (otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')' )
            	            // InternalQVTrelation.g:733:8: otherlv_10= 'opposite' otherlv_11= '(' ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) ) otherlv_13= ')'
            	            {
            	            otherlv_10=(Token)match(input,30,FollowSets000.FOLLOW_22); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getKeyDeclCSAccess().getOppositeKeyword_4_1_1_0());
            	                  
            	            }
            	            otherlv_11=(Token)match(input,31,FollowSets000.FOLLOW_20); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_11, grammarAccess.getKeyDeclCSAccess().getLeftParenthesisKeyword_4_1_1_1());
            	                  
            	            }
            	            // InternalQVTrelation.g:741:1: ( (lv_ownedOppositePropertyIds_12_0= rulePathNameCS ) )
            	            // InternalQVTrelation.g:742:1: (lv_ownedOppositePropertyIds_12_0= rulePathNameCS )
            	            {
            	            // InternalQVTrelation.g:742:1: (lv_ownedOppositePropertyIds_12_0= rulePathNameCS )
            	            // InternalQVTrelation.g:743:3: lv_ownedOppositePropertyIds_12_0= rulePathNameCS
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getKeyDeclCSAccess().getOwnedOppositePropertyIdsPathNameCSParserRuleCall_4_1_1_2_0()); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_23);
            	            lv_ownedOppositePropertyIds_12_0=rulePathNameCS();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getKeyDeclCSRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"ownedOppositePropertyIds",
            	                      		lv_ownedOppositePropertyIds_12_0, 
            	                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            otherlv_13=(Token)match(input,32,FollowSets000.FOLLOW_21); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_13, grammarAccess.getKeyDeclCSAccess().getRightParenthesisKeyword_4_1_1_3());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_14=(Token)match(input,20,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getKeyDeclCSAccess().getRightCurlyBracketKeyword_5());
                  
            }
            otherlv_15=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getKeyDeclCSAccess().getSemicolonKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyDeclCS"


    // $ANTLR start "entryRuleModelDeclCS"
    // InternalQVTrelation.g:779:1: entryRuleModelDeclCS returns [EObject current=null] : iv_ruleModelDeclCS= ruleModelDeclCS EOF ;
    public final EObject entryRuleModelDeclCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelDeclCS = null;


        try {
            // InternalQVTrelation.g:780:2: (iv_ruleModelDeclCS= ruleModelDeclCS EOF )
            // InternalQVTrelation.g:781:2: iv_ruleModelDeclCS= ruleModelDeclCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelDeclCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModelDeclCS=ruleModelDeclCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelDeclCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelDeclCS"


    // $ANTLR start "ruleModelDeclCS"
    // InternalQVTrelation.g:788:1: ruleModelDeclCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( ( ( ruleUnrestrictedName ) ) | (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' ) ) ) ;
    public final EObject ruleModelDeclCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:791:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( ( ( ruleUnrestrictedName ) ) | (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' ) ) ) )
            // InternalQVTrelation.g:792:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( ( ( ruleUnrestrictedName ) ) | (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' ) ) )
            {
            // InternalQVTrelation.g:792:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( ( ( ruleUnrestrictedName ) ) | (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' ) ) )
            // InternalQVTrelation.g:792:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( ( ( ruleUnrestrictedName ) ) | (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' ) )
            {
            // InternalQVTrelation.g:792:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:793:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:793:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:794:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelDeclCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModelDeclCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModelDeclCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTrelation.g:814:1: ( ( ( ruleUnrestrictedName ) ) | (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_SIMPLE_ID && LA17_0<=RULE_ESCAPED_ID)||(LA17_0>=23 && LA17_0<=30)||(LA17_0>=33 && LA17_0<=38)||(LA17_0>=40 && LA17_0<=42)||(LA17_0>=44 && LA17_0<=46)) ) {
                alt17=1;
            }
            else if ( (LA17_0==17) ) {
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
                    // InternalQVTrelation.g:814:2: ( ( ruleUnrestrictedName ) )
                    {
                    // InternalQVTrelation.g:814:2: ( ( ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:815:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:815:1: ( ruleUnrestrictedName )
                    // InternalQVTrelation.g:816:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModelDeclCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelDeclCSAccess().getMetamodelIdsNamespaceCrossReference_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:833:6: (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' )
                    {
                    // InternalQVTrelation.g:833:6: (otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}' )
                    // InternalQVTrelation.g:833:8: otherlv_3= '{' ( ( ruleUnrestrictedName ) ) (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )* otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getModelDeclCSAccess().getLeftCurlyBracketKeyword_2_1_0());
                          
                    }
                    // InternalQVTrelation.g:837:1: ( ( ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:838:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:838:1: ( ruleUnrestrictedName )
                    // InternalQVTrelation.g:839:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModelDeclCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModelDeclCSAccess().getMetamodelIdsNamespaceCrossReference_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_21);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:855:2: (otherlv_5= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==18) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalQVTrelation.g:855:4: otherlv_5= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getModelDeclCSAccess().getCommaKeyword_2_1_2_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:859:1: ( ( ruleUnrestrictedName ) )
                    	    // InternalQVTrelation.g:860:1: ( ruleUnrestrictedName )
                    	    {
                    	    // InternalQVTrelation.g:860:1: ( ruleUnrestrictedName )
                    	    // InternalQVTrelation.g:861:3: ruleUnrestrictedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModelDeclCSRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModelDeclCSAccess().getMetamodelIdsNamespaceCrossReference_2_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_21);
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
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getModelDeclCSAccess().getRightCurlyBracketKeyword_2_1_3());
                          
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
    // $ANTLR end "ruleModelDeclCS"


    // $ANTLR start "entryRuleObjectTemplateCS"
    // InternalQVTrelation.g:889:1: entryRuleObjectTemplateCS returns [EObject current=null] : iv_ruleObjectTemplateCS= ruleObjectTemplateCS EOF ;
    public final EObject entryRuleObjectTemplateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectTemplateCS = null;


        try {
            // InternalQVTrelation.g:890:2: (iv_ruleObjectTemplateCS= ruleObjectTemplateCS EOF )
            // InternalQVTrelation.g:891:2: iv_ruleObjectTemplateCS= ruleObjectTemplateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectTemplateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleObjectTemplateCS=ruleObjectTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectTemplateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectTemplateCS"


    // $ANTLR start "ruleObjectTemplateCS"
    // InternalQVTrelation.g:898:1: ruleObjectTemplateCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) otherlv_3= '{' ( ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) ) (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )* )? otherlv_7= '}' ) ;
    public final EObject ruleObjectTemplateCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedPropertyTemplates_4_0 = null;

        EObject lv_ownedPropertyTemplates_6_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:901:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) otherlv_3= '{' ( ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) ) (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )* )? otherlv_7= '}' ) )
            // InternalQVTrelation.g:902:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) otherlv_3= '{' ( ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) ) (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )* )? otherlv_7= '}' )
            {
            // InternalQVTrelation.g:902:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) otherlv_3= '{' ( ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) ) (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )* )? otherlv_7= '}' )
            // InternalQVTrelation.g:902:2: ( (lv_name_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) otherlv_3= '{' ( ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) ) (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )* )? otherlv_7= '}'
            {
            // InternalQVTrelation.g:902:2: ( (lv_name_0_0= ruleUnrestrictedName ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_SIMPLE_ID && LA18_0<=RULE_ESCAPED_ID)||(LA18_0>=23 && LA18_0<=30)||(LA18_0>=33 && LA18_0<=38)||(LA18_0>=40 && LA18_0<=42)||(LA18_0>=44 && LA18_0<=46)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalQVTrelation.g:903:1: (lv_name_0_0= ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:903:1: (lv_name_0_0= ruleUnrestrictedName )
                    // InternalQVTrelation.g:904:3: lv_name_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getObjectTemplateCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_name_0_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getObjectTemplateCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getObjectTemplateCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTrelation.g:924:1: ( (lv_ownedType_2_0= ruleTypedRefCS ) )
            // InternalQVTrelation.g:925:1: (lv_ownedType_2_0= ruleTypedRefCS )
            {
            // InternalQVTrelation.g:925:1: (lv_ownedType_2_0= ruleTypedRefCS )
            // InternalQVTrelation.g:926:3: lv_ownedType_2_0= ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getObjectTemplateCSAccess().getOwnedTypeTypedRefCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_ownedType_2_0=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getObjectTemplateCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_2_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getObjectTemplateCSAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // InternalQVTrelation.g:946:1: ( ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) ) (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_SIMPLE_ID && LA20_0<=RULE_ESCAPED_ID)||(LA20_0>=23 && LA20_0<=30)||(LA20_0>=33 && LA20_0<=38)||(LA20_0>=40 && LA20_0<=42)||(LA20_0>=44 && LA20_0<=46)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalQVTrelation.g:946:2: ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) ) (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )*
                    {
                    // InternalQVTrelation.g:946:2: ( (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS ) )
                    // InternalQVTrelation.g:947:1: (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS )
                    {
                    // InternalQVTrelation.g:947:1: (lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS )
                    // InternalQVTrelation.g:948:3: lv_ownedPropertyTemplates_4_0= rulePropertyTemplateCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getObjectTemplateCSAccess().getOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_ownedPropertyTemplates_4_0=rulePropertyTemplateCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getObjectTemplateCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedPropertyTemplates",
                              		lv_ownedPropertyTemplates_4_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PropertyTemplateCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:964:2: (otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==18) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalQVTrelation.g:964:4: otherlv_5= ',' ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) )
                    	    {
                    	    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getObjectTemplateCSAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:968:1: ( (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS ) )
                    	    // InternalQVTrelation.g:969:1: (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS )
                    	    {
                    	    // InternalQVTrelation.g:969:1: (lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS )
                    	    // InternalQVTrelation.g:970:3: lv_ownedPropertyTemplates_6_0= rulePropertyTemplateCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getObjectTemplateCSAccess().getOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_21);
                    	    lv_ownedPropertyTemplates_6_0=rulePropertyTemplateCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getObjectTemplateCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyTemplates",
                    	              		lv_ownedPropertyTemplates_6_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PropertyTemplateCS");
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

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getObjectTemplateCSAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectTemplateCS"


    // $ANTLR start "entryRuleParamDeclarationCS"
    // InternalQVTrelation.g:998:1: entryRuleParamDeclarationCS returns [EObject current=null] : iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF ;
    public final EObject entryRuleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamDeclarationCS = null;


        try {
            // InternalQVTrelation.g:999:2: (iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF )
            // InternalQVTrelation.g:1000:2: iv_ruleParamDeclarationCS= ruleParamDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParamDeclarationCS=ruleParamDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:1007:1: ruleParamDeclarationCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) ) ;
    public final EObject ruleParamDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1010:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) ) )
            // InternalQVTrelation.g:1011:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) )
            {
            // InternalQVTrelation.g:1011:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) ) )
            // InternalQVTrelation.g:1011:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedRefCS ) )
            {
            // InternalQVTrelation.g:1011:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:1012:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:1012:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:1013:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTrelation.g:1033:1: ( (lv_ownedType_2_0= ruleTypedRefCS ) )
            // InternalQVTrelation.g:1034:1: (lv_ownedType_2_0= ruleTypedRefCS )
            {
            // InternalQVTrelation.g:1034:1: (lv_ownedType_2_0= ruleTypedRefCS )
            // InternalQVTrelation.g:1035:3: lv_ownedType_2_0= ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypedRefCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedType_2_0=ruleTypedRefCS();

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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
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


    // $ANTLR start "entryRulePredicateCS"
    // InternalQVTrelation.g:1059:1: entryRulePredicateCS returns [EObject current=null] : iv_rulePredicateCS= rulePredicateCS EOF ;
    public final EObject entryRulePredicateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateCS = null;


        try {
            // InternalQVTrelation.g:1060:2: (iv_rulePredicateCS= rulePredicateCS EOF )
            // InternalQVTrelation.g:1061:2: iv_rulePredicateCS= rulePredicateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicateCS=rulePredicateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:1068:1: rulePredicateCS returns [EObject current=null] : ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' ) ;
    public final EObject rulePredicateCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedCondition_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1071:28: ( ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' ) )
            // InternalQVTrelation.g:1072:1: ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' )
            {
            // InternalQVTrelation.g:1072:1: ( ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';' )
            // InternalQVTrelation.g:1072:2: ( (lv_ownedCondition_0_0= ruleExpCS ) ) otherlv_1= ';'
            {
            // InternalQVTrelation.g:1072:2: ( (lv_ownedCondition_0_0= ruleExpCS ) )
            // InternalQVTrelation.g:1073:1: (lv_ownedCondition_0_0= ruleExpCS )
            {
            // InternalQVTrelation.g:1073:1: (lv_ownedCondition_0_0= ruleExpCS )
            // InternalQVTrelation.g:1074:3: lv_ownedCondition_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPredicateCSAccess().getOwnedConditionExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_14);
            lv_ownedCondition_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPredicateCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedCondition",
                      		lv_ownedCondition_0_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPredicateCSAccess().getSemicolonKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRulePrimitiveTypeDomainCS"
    // InternalQVTrelation.g:1102:1: entryRulePrimitiveTypeDomainCS returns [EObject current=null] : iv_rulePrimitiveTypeDomainCS= rulePrimitiveTypeDomainCS EOF ;
    public final EObject entryRulePrimitiveTypeDomainCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeDomainCS = null;


        try {
            // InternalQVTrelation.g:1103:2: (iv_rulePrimitiveTypeDomainCS= rulePrimitiveTypeDomainCS EOF )
            // InternalQVTrelation.g:1104:2: iv_rulePrimitiveTypeDomainCS= rulePrimitiveTypeDomainCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeDomainCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveTypeDomainCS=rulePrimitiveTypeDomainCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeDomainCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveTypeDomainCS"


    // $ANTLR start "rulePrimitiveTypeDomainCS"
    // InternalQVTrelation.g:1111:1: rulePrimitiveTypeDomainCS returns [EObject current=null] : (otherlv_0= 'primitive' otherlv_1= 'domain' ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) otherlv_5= ';' ) ;
    public final EObject rulePrimitiveTypeDomainCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedType_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1114:28: ( (otherlv_0= 'primitive' otherlv_1= 'domain' ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) otherlv_5= ';' ) )
            // InternalQVTrelation.g:1115:1: (otherlv_0= 'primitive' otherlv_1= 'domain' ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) otherlv_5= ';' )
            {
            // InternalQVTrelation.g:1115:1: (otherlv_0= 'primitive' otherlv_1= 'domain' ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) otherlv_5= ';' )
            // InternalQVTrelation.g:1115:3: otherlv_0= 'primitive' otherlv_1= 'domain' ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPrimitiveTypeDomainCSAccess().getPrimitiveKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeDomainCSAccess().getDomainKeyword_1());
                  
            }
            // InternalQVTrelation.g:1123:1: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:1124:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:1124:1: (lv_name_2_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:1125:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeDomainCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_2_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeDomainCSAccess().getColonKeyword_3());
                  
            }
            // InternalQVTrelation.g:1145:1: ( (lv_ownedType_4_0= ruleTypedRefCS ) )
            // InternalQVTrelation.g:1146:1: (lv_ownedType_4_0= ruleTypedRefCS )
            {
            // InternalQVTrelation.g:1146:1: (lv_ownedType_4_0= ruleTypedRefCS )
            // InternalQVTrelation.g:1147:3: lv_ownedType_4_0= ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeDomainCSAccess().getOwnedTypeTypedRefCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_14);
            lv_ownedType_4_0=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeDomainCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_4_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getPrimitiveTypeDomainCSAccess().getSemicolonKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveTypeDomainCS"


    // $ANTLR start "entryRulePropertyTemplateCS"
    // InternalQVTrelation.g:1175:1: entryRulePropertyTemplateCS returns [EObject current=null] : iv_rulePropertyTemplateCS= rulePropertyTemplateCS EOF ;
    public final EObject entryRulePropertyTemplateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyTemplateCS = null;


        try {
            // InternalQVTrelation.g:1176:2: (iv_rulePropertyTemplateCS= rulePropertyTemplateCS EOF )
            // InternalQVTrelation.g:1177:2: iv_rulePropertyTemplateCS= rulePropertyTemplateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyTemplateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyTemplateCS=rulePropertyTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyTemplateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyTemplateCS"


    // $ANTLR start "rulePropertyTemplateCS"
    // InternalQVTrelation.g:1184:1: rulePropertyTemplateCS returns [EObject current=null] : ( ( ( ( ruleUnrestrictedName ) ) | (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' ) ) otherlv_5= '=' ( (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS ) ) ) ;
    public final EObject rulePropertyTemplateCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_ownedOppositePropertyId_3_0 = null;

        EObject lv_ownedExpression_6_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1187:28: ( ( ( ( ( ruleUnrestrictedName ) ) | (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' ) ) otherlv_5= '=' ( (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS ) ) ) )
            // InternalQVTrelation.g:1188:1: ( ( ( ( ruleUnrestrictedName ) ) | (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' ) ) otherlv_5= '=' ( (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS ) ) )
            {
            // InternalQVTrelation.g:1188:1: ( ( ( ( ruleUnrestrictedName ) ) | (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' ) ) otherlv_5= '=' ( (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS ) ) )
            // InternalQVTrelation.g:1188:2: ( ( ( ruleUnrestrictedName ) ) | (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' ) ) otherlv_5= '=' ( (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS ) )
            {
            // InternalQVTrelation.g:1188:2: ( ( ( ruleUnrestrictedName ) ) | (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_SIMPLE_ID && LA21_0<=RULE_ESCAPED_ID)||(LA21_0>=23 && LA21_0<=29)||(LA21_0>=33 && LA21_0<=38)||(LA21_0>=40 && LA21_0<=42)||(LA21_0>=44 && LA21_0<=46)) ) {
                alt21=1;
            }
            else if ( (LA21_0==30) ) {
                int LA21_2 = input.LA(2);

                if ( (LA21_2==31) ) {
                    alt21=2;
                }
                else if ( (LA21_2==21) ) {
                    alt21=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalQVTrelation.g:1188:3: ( ( ruleUnrestrictedName ) )
                    {
                    // InternalQVTrelation.g:1188:3: ( ( ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:1189:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:1189:1: ( ruleUnrestrictedName )
                    // InternalQVTrelation.g:1190:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyTemplateCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyTemplateCSAccess().getPropertyIdPropertyCrossReference_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
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
                    // InternalQVTrelation.g:1207:6: (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' )
                    {
                    // InternalQVTrelation.g:1207:6: (otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')' )
                    // InternalQVTrelation.g:1207:8: otherlv_1= 'opposite' otherlv_2= '(' ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPropertyTemplateCSAccess().getOppositeKeyword_0_1_0());
                          
                    }
                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPropertyTemplateCSAccess().getLeftParenthesisKeyword_0_1_1());
                          
                    }
                    // InternalQVTrelation.g:1215:1: ( (lv_ownedOppositePropertyId_3_0= rulePathNameCS ) )
                    // InternalQVTrelation.g:1216:1: (lv_ownedOppositePropertyId_3_0= rulePathNameCS )
                    {
                    // InternalQVTrelation.g:1216:1: (lv_ownedOppositePropertyId_3_0= rulePathNameCS )
                    // InternalQVTrelation.g:1217:3: lv_ownedOppositePropertyId_3_0= rulePathNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyTemplateCSAccess().getOwnedOppositePropertyIdPathNameCSParserRuleCall_0_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_ownedOppositePropertyId_3_0=rulePathNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyTemplateCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedOppositePropertyId",
                              		lv_ownedOppositePropertyId_3_0, 
                              		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPropertyTemplateCSAccess().getRightParenthesisKeyword_0_1_3());
                          
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getPropertyTemplateCSAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalQVTrelation.g:1241:1: ( (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS ) )
            // InternalQVTrelation.g:1242:1: (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS )
            {
            // InternalQVTrelation.g:1242:1: (lv_ownedExpression_6_0= ruleExpCSOrTemplateCS )
            // InternalQVTrelation.g:1243:3: lv_ownedExpression_6_0= ruleExpCSOrTemplateCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyTemplateCSAccess().getOwnedExpressionExpCSOrTemplateCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedExpression_6_0=ruleExpCSOrTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyTemplateCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpression",
                      		lv_ownedExpression_6_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ExpCSOrTemplateCS");
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
    // $ANTLR end "rulePropertyTemplateCS"


    // $ANTLR start "entryRuleQueryCS"
    // InternalQVTrelation.g:1267:1: entryRuleQueryCS returns [EObject current=null] : iv_ruleQueryCS= ruleQueryCS EOF ;
    public final EObject entryRuleQueryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryCS = null;


        try {
            // InternalQVTrelation.g:1268:2: (iv_ruleQueryCS= ruleQueryCS EOF )
            // InternalQVTrelation.g:1269:2: iv_ruleQueryCS= ruleQueryCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueryCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQueryCS=ruleQueryCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueryCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:1276:1: ruleQueryCS returns [EObject current=null] : (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypedRefCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) ) ;
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

        EObject lv_ownedParameters_3_0 = null;

        EObject lv_ownedParameters_5_0 = null;

        EObject lv_ownedType_8_0 = null;

        EObject lv_ownedExpression_11_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1279:28: ( (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypedRefCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) ) )
            // InternalQVTrelation.g:1280:1: (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypedRefCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) )
            {
            // InternalQVTrelation.g:1280:1: (otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypedRefCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) ) )
            // InternalQVTrelation.g:1280:3: otherlv_0= 'query' ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= '(' ( ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypedRefCS ) ) (otherlv_9= ';' | (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
                  
            }
            // InternalQVTrelation.g:1284:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:1285:1: (lv_name_1_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:1285:1: (lv_name_1_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:1286:3: lv_name_1_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_22);
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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalQVTrelation.g:1306:1: ( ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_SIMPLE_ID && LA23_0<=RULE_ESCAPED_ID)||(LA23_0>=23 && LA23_0<=30)||(LA23_0>=33 && LA23_0<=38)||(LA23_0>=40 && LA23_0<=42)||(LA23_0>=44 && LA23_0<=46)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalQVTrelation.g:1306:2: ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) ) (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )*
                    {
                    // InternalQVTrelation.g:1306:2: ( (lv_ownedParameters_3_0= ruleParamDeclarationCS ) )
                    // InternalQVTrelation.g:1307:1: (lv_ownedParameters_3_0= ruleParamDeclarationCS )
                    {
                    // InternalQVTrelation.g:1307:1: (lv_ownedParameters_3_0= ruleParamDeclarationCS )
                    // InternalQVTrelation.g:1308:3: lv_ownedParameters_3_0= ruleParamDeclarationCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_27);
                    lv_ownedParameters_3_0=ruleParamDeclarationCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParameters",
                              		lv_ownedParameters_3_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ParamDeclarationCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:1324:2: (otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==18) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalQVTrelation.g:1324:4: otherlv_4= ',' ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getQueryCSAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:1328:1: ( (lv_ownedParameters_5_0= ruleParamDeclarationCS ) )
                    	    // InternalQVTrelation.g:1329:1: (lv_ownedParameters_5_0= ruleParamDeclarationCS )
                    	    {
                    	    // InternalQVTrelation.g:1329:1: (lv_ownedParameters_5_0= ruleParamDeclarationCS )
                    	    // InternalQVTrelation.g:1330:3: lv_ownedParameters_5_0= ruleParamDeclarationCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_27);
                    	    lv_ownedParameters_5_0=ruleParamDeclarationCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParameters",
                    	              		lv_ownedParameters_5_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ParamDeclarationCS");
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


                    }
                    break;

            }

            otherlv_6=(Token)match(input,32,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getColonKeyword_5());
                  
            }
            // InternalQVTrelation.g:1354:1: ( (lv_ownedType_8_0= ruleTypedRefCS ) )
            // InternalQVTrelation.g:1355:1: (lv_ownedType_8_0= ruleTypedRefCS )
            {
            // InternalQVTrelation.g:1355:1: (lv_ownedType_8_0= ruleTypedRefCS )
            // InternalQVTrelation.g:1356:3: lv_ownedType_8_0= ruleTypedRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypedRefCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_28);
            lv_ownedType_8_0=ruleTypedRefCS();

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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:1372:2: (otherlv_9= ';' | (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==22) ) {
                alt24=1;
            }
            else if ( (LA24_0==17) ) {
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
                    // InternalQVTrelation.g:1372:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getQueryCSAccess().getSemicolonKeyword_7_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:1377:6: (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' )
                    {
                    // InternalQVTrelation.g:1377:6: (otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}' )
                    // InternalQVTrelation.g:1377:8: otherlv_10= '{' ( (lv_ownedExpression_11_0= ruleExpCS ) ) otherlv_12= '}'
                    {
                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_7_1_0());
                          
                    }
                    // InternalQVTrelation.g:1381:1: ( (lv_ownedExpression_11_0= ruleExpCS ) )
                    // InternalQVTrelation.g:1382:1: (lv_ownedExpression_11_0= ruleExpCS )
                    {
                    // InternalQVTrelation.g:1382:1: (lv_ownedExpression_11_0= ruleExpCS )
                    // InternalQVTrelation.g:1383:3: lv_ownedExpression_11_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedExpressionExpCSParserRuleCall_7_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    lv_ownedExpression_11_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueryCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_11_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleRelationCS"
    // InternalQVTrelation.g:1411:1: entryRuleRelationCS returns [EObject current=null] : iv_ruleRelationCS= ruleRelationCS EOF ;
    public final EObject entryRuleRelationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationCS = null;


        try {
            // InternalQVTrelation.g:1412:2: (iv_ruleRelationCS= ruleRelationCS EOF )
            // InternalQVTrelation.g:1413:2: iv_ruleRelationCS= ruleRelationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationCS=ruleRelationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationCS"


    // $ANTLR start "ruleRelationCS"
    // InternalQVTrelation.g:1420:1: ruleRelationCS returns [EObject current=null] : ( ( (lv_isTop_0_0= 'top' ) )? ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'relation' ( (lv_name_3_0= ruleUnrestrictedName ) ) (otherlv_4= 'overrides' ( ( ruleUnrestrictedName ) ) )? otherlv_6= '{' ( (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS ) )* ( ( (lv_ownedDomains_8_0= ruleDomainCS ) ) | ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) ) )+ ( (lv_ownedWhen_10_0= ruleWhenCS ) )? ( (lv_ownedWhere_11_0= ruleWhereCS ) )? otherlv_12= '}' ) ;
    public final EObject ruleRelationCS() throws RecognitionException {
        EObject current = null;

        Token lv_isTop_0_0=null;
        Token lv_isDefault_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_ownedVarDeclarations_7_0 = null;

        EObject lv_ownedDomains_8_0 = null;

        EObject lv_ownedDomains_9_0 = null;

        EObject lv_ownedWhen_10_0 = null;

        EObject lv_ownedWhere_11_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1423:28: ( ( ( (lv_isTop_0_0= 'top' ) )? ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'relation' ( (lv_name_3_0= ruleUnrestrictedName ) ) (otherlv_4= 'overrides' ( ( ruleUnrestrictedName ) ) )? otherlv_6= '{' ( (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS ) )* ( ( (lv_ownedDomains_8_0= ruleDomainCS ) ) | ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) ) )+ ( (lv_ownedWhen_10_0= ruleWhenCS ) )? ( (lv_ownedWhere_11_0= ruleWhereCS ) )? otherlv_12= '}' ) )
            // InternalQVTrelation.g:1424:1: ( ( (lv_isTop_0_0= 'top' ) )? ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'relation' ( (lv_name_3_0= ruleUnrestrictedName ) ) (otherlv_4= 'overrides' ( ( ruleUnrestrictedName ) ) )? otherlv_6= '{' ( (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS ) )* ( ( (lv_ownedDomains_8_0= ruleDomainCS ) ) | ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) ) )+ ( (lv_ownedWhen_10_0= ruleWhenCS ) )? ( (lv_ownedWhere_11_0= ruleWhereCS ) )? otherlv_12= '}' )
            {
            // InternalQVTrelation.g:1424:1: ( ( (lv_isTop_0_0= 'top' ) )? ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'relation' ( (lv_name_3_0= ruleUnrestrictedName ) ) (otherlv_4= 'overrides' ( ( ruleUnrestrictedName ) ) )? otherlv_6= '{' ( (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS ) )* ( ( (lv_ownedDomains_8_0= ruleDomainCS ) ) | ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) ) )+ ( (lv_ownedWhen_10_0= ruleWhenCS ) )? ( (lv_ownedWhere_11_0= ruleWhereCS ) )? otherlv_12= '}' )
            // InternalQVTrelation.g:1424:2: ( (lv_isTop_0_0= 'top' ) )? ( (lv_isDefault_1_0= 'default' ) )? otherlv_2= 'relation' ( (lv_name_3_0= ruleUnrestrictedName ) ) (otherlv_4= 'overrides' ( ( ruleUnrestrictedName ) ) )? otherlv_6= '{' ( (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS ) )* ( ( (lv_ownedDomains_8_0= ruleDomainCS ) ) | ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) ) )+ ( (lv_ownedWhen_10_0= ruleWhenCS ) )? ( (lv_ownedWhere_11_0= ruleWhereCS ) )? otherlv_12= '}'
            {
            // InternalQVTrelation.g:1424:2: ( (lv_isTop_0_0= 'top' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalQVTrelation.g:1425:1: (lv_isTop_0_0= 'top' )
                    {
                    // InternalQVTrelation.g:1425:1: (lv_isTop_0_0= 'top' )
                    // InternalQVTrelation.g:1426:3: lv_isTop_0_0= 'top'
                    {
                    lv_isTop_0_0=(Token)match(input,35,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTop_0_0, grammarAccess.getRelationCSAccess().getIsTopTopKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRelationCSRule());
                      	        }
                             		setWithLastConsumed(current, "isTop", true, "top");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:1439:3: ( (lv_isDefault_1_0= 'default' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==36) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalQVTrelation.g:1440:1: (lv_isDefault_1_0= 'default' )
                    {
                    // InternalQVTrelation.g:1440:1: (lv_isDefault_1_0= 'default' )
                    // InternalQVTrelation.g:1441:3: lv_isDefault_1_0= 'default'
                    {
                    lv_isDefault_1_0=(Token)match(input,36,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isDefault_1_0, grammarAccess.getRelationCSAccess().getIsDefaultDefaultKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRelationCSRule());
                      	        }
                             		setWithLastConsumed(current, "isDefault", true, "default");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRelationCSAccess().getRelationKeyword_2());
                  
            }
            // InternalQVTrelation.g:1458:1: ( (lv_name_3_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:1459:1: (lv_name_3_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:1459:1: (lv_name_3_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:1460:3: lv_name_3_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_31);
            lv_name_3_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRelationCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:1476:2: (otherlv_4= 'overrides' ( ( ruleUnrestrictedName ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalQVTrelation.g:1476:4: otherlv_4= 'overrides' ( ( ruleUnrestrictedName ) )
                    {
                    otherlv_4=(Token)match(input,38,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRelationCSAccess().getOverridesKeyword_4_0());
                          
                    }
                    // InternalQVTrelation.g:1480:1: ( ( ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:1481:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:1481:1: ( ruleUnrestrictedName )
                    // InternalQVTrelation.g:1482:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRelationCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationCSAccess().getOverridesRelationCrossReference_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_7);
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

            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRelationCSAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // InternalQVTrelation.g:1502:1: ( (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS ) )*
            loop28:
            do {
                int alt28=2;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1==16||LA28_1==18||(LA28_1>=21 && LA28_1<=22)) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 24:
                    {
                    int LA28_2 = input.LA(2);

                    if ( (LA28_2==16||LA28_2==18||(LA28_2>=21 && LA28_2<=22)) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 25:
                    {
                    int LA28_3 = input.LA(2);

                    if ( (LA28_3==16||LA28_3==18||(LA28_3>=21 && LA28_3<=22)) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA28_4 = input.LA(2);

                    if ( (LA28_4==16||LA28_4==18||(LA28_4>=21 && LA28_4<=22)) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA28_5 = input.LA(2);

                    if ( (LA28_5==16||LA28_5==18||(LA28_5>=21 && LA28_5<=22)) ) {
                        alt28=1;
                    }


                    }
                    break;
                case RULE_SIMPLE_ID:
                case RULE_ESCAPED_ID:
                case 27:
                case 28:
                case 29:
                case 30:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 40:
                case 41:
                case 42:
                case 44:
                case 45:
                case 46:
                    {
                    alt28=1;
                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // InternalQVTrelation.g:1503:1: (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS )
            	    {
            	    // InternalQVTrelation.g:1503:1: (lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS )
            	    // InternalQVTrelation.g:1504:3: lv_ownedVarDeclarations_7_0= ruleVarDeclarationCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationCSAccess().getOwnedVarDeclarationsVarDeclarationCSParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_16);
            	    lv_ownedVarDeclarations_7_0=ruleVarDeclarationCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRelationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedVarDeclarations",
            	              		lv_ownedVarDeclarations_7_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.VarDeclarationCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // InternalQVTrelation.g:1520:3: ( ( (lv_ownedDomains_8_0= ruleDomainCS ) ) | ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=3;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=23 && LA29_0<=26)) ) {
                    alt29=1;
                }
                else if ( (LA29_0==33) ) {
                    alt29=2;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalQVTrelation.g:1520:4: ( (lv_ownedDomains_8_0= ruleDomainCS ) )
            	    {
            	    // InternalQVTrelation.g:1520:4: ( (lv_ownedDomains_8_0= ruleDomainCS ) )
            	    // InternalQVTrelation.g:1521:1: (lv_ownedDomains_8_0= ruleDomainCS )
            	    {
            	    // InternalQVTrelation.g:1521:1: (lv_ownedDomains_8_0= ruleDomainCS )
            	    // InternalQVTrelation.g:1522:3: lv_ownedDomains_8_0= ruleDomainCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationCSAccess().getOwnedDomainsDomainCSParserRuleCall_7_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_ownedDomains_8_0=ruleDomainCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRelationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedDomains",
            	              		lv_ownedDomains_8_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.DomainCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalQVTrelation.g:1539:6: ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) )
            	    {
            	    // InternalQVTrelation.g:1539:6: ( (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS ) )
            	    // InternalQVTrelation.g:1540:1: (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS )
            	    {
            	    // InternalQVTrelation.g:1540:1: (lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS )
            	    // InternalQVTrelation.g:1541:3: lv_ownedDomains_9_0= rulePrimitiveTypeDomainCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRelationCSAccess().getOwnedDomainsPrimitiveTypeDomainCSParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_ownedDomains_9_0=rulePrimitiveTypeDomainCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRelationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedDomains",
            	              		lv_ownedDomains_9_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PrimitiveTypeDomainCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            // InternalQVTrelation.g:1557:4: ( (lv_ownedWhen_10_0= ruleWhenCS ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalQVTrelation.g:1558:1: (lv_ownedWhen_10_0= ruleWhenCS )
                    {
                    // InternalQVTrelation.g:1558:1: (lv_ownedWhen_10_0= ruleWhenCS )
                    // InternalQVTrelation.g:1559:3: lv_ownedWhen_10_0= ruleWhenCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationCSAccess().getOwnedWhenWhenCSParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_32);
                    lv_ownedWhen_10_0=ruleWhenCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedWhen",
                              		lv_ownedWhen_10_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.WhenCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:1575:3: ( (lv_ownedWhere_11_0= ruleWhereCS ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==45) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalQVTrelation.g:1576:1: (lv_ownedWhere_11_0= ruleWhereCS )
                    {
                    // InternalQVTrelation.g:1576:1: (lv_ownedWhere_11_0= ruleWhereCS )
                    // InternalQVTrelation.g:1577:3: lv_ownedWhere_11_0= ruleWhereCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationCSAccess().getOwnedWhereWhereCSParserRuleCall_9_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    lv_ownedWhere_11_0=ruleWhereCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedWhere",
                              		lv_ownedWhere_11_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.WhereCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getRelationCSAccess().getRightCurlyBracketKeyword_10());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationCS"


    // $ANTLR start "entryRuleScopeNameCS"
    // InternalQVTrelation.g:1605:1: entryRuleScopeNameCS returns [EObject current=null] : iv_ruleScopeNameCS= ruleScopeNameCS EOF ;
    public final EObject entryRuleScopeNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeNameCS = null;


        try {
            // InternalQVTrelation.g:1606:2: (iv_ruleScopeNameCS= ruleScopeNameCS EOF )
            // InternalQVTrelation.g:1607:2: iv_ruleScopeNameCS= ruleScopeNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScopeNameCS=ruleScopeNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScopeNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:1614:1: ruleScopeNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) ;
    public final EObject ruleScopeNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1617:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* ) )
            // InternalQVTrelation.g:1618:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            {
            // InternalQVTrelation.g:1618:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )* )
            // InternalQVTrelation.g:1618:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) otherlv_1= '::' ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            {
            // InternalQVTrelation.g:1618:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // InternalQVTrelation.g:1619:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // InternalQVTrelation.g:1619:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // InternalQVTrelation.g:1620:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_33);
            lv_ownedPathElements_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPathElements",
                      		lv_ownedPathElements_0_0, 
                      		"org.eclipse.ocl.xtext.base.Base.FirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
                  
            }
            // InternalQVTrelation.g:1640:1: ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*
            loop32:
            do {
                int alt32=2;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // InternalQVTrelation.g:1640:2: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::'
            	    {
            	    // InternalQVTrelation.g:1640:2: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // InternalQVTrelation.g:1641:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // InternalQVTrelation.g:1641:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // InternalQVTrelation.g:1642:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_33);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPathElements",
            	              		lv_ownedPathElements_2_0, 
            	              		"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_34); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
            	          
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
    // $ANTLR end "ruleScopeNameCS"


    // $ANTLR start "entryRuleTemplateCS"
    // InternalQVTrelation.g:1670:1: entryRuleTemplateCS returns [EObject current=null] : iv_ruleTemplateCS= ruleTemplateCS EOF ;
    public final EObject entryRuleTemplateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateCS = null;


        try {
            // InternalQVTrelation.g:1671:2: (iv_ruleTemplateCS= ruleTemplateCS EOF )
            // InternalQVTrelation.g:1672:2: iv_ruleTemplateCS= ruleTemplateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTemplateCS=ruleTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateCS"


    // $ANTLR start "ruleTemplateCS"
    // InternalQVTrelation.g:1679:1: ruleTemplateCS returns [EObject current=null] : ( (this_CollectionTemplateCS_0= ruleCollectionTemplateCS | this_ObjectTemplateCS_1= ruleObjectTemplateCS ) (otherlv_2= '{' ( (lv_ownedGuardExpression_3_0= ruleExpCS ) ) otherlv_4= '}' )? ) ;
    public final EObject ruleTemplateCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_CollectionTemplateCS_0 = null;

        EObject this_ObjectTemplateCS_1 = null;

        EObject lv_ownedGuardExpression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1682:28: ( ( (this_CollectionTemplateCS_0= ruleCollectionTemplateCS | this_ObjectTemplateCS_1= ruleObjectTemplateCS ) (otherlv_2= '{' ( (lv_ownedGuardExpression_3_0= ruleExpCS ) ) otherlv_4= '}' )? ) )
            // InternalQVTrelation.g:1683:1: ( (this_CollectionTemplateCS_0= ruleCollectionTemplateCS | this_ObjectTemplateCS_1= ruleObjectTemplateCS ) (otherlv_2= '{' ( (lv_ownedGuardExpression_3_0= ruleExpCS ) ) otherlv_4= '}' )? )
            {
            // InternalQVTrelation.g:1683:1: ( (this_CollectionTemplateCS_0= ruleCollectionTemplateCS | this_ObjectTemplateCS_1= ruleObjectTemplateCS ) (otherlv_2= '{' ( (lv_ownedGuardExpression_3_0= ruleExpCS ) ) otherlv_4= '}' )? )
            // InternalQVTrelation.g:1683:2: (this_CollectionTemplateCS_0= ruleCollectionTemplateCS | this_ObjectTemplateCS_1= ruleObjectTemplateCS ) (otherlv_2= '{' ( (lv_ownedGuardExpression_3_0= ruleExpCS ) ) otherlv_4= '}' )?
            {
            // InternalQVTrelation.g:1683:2: (this_CollectionTemplateCS_0= ruleCollectionTemplateCS | this_ObjectTemplateCS_1= ruleObjectTemplateCS )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalQVTrelation.g:1684:2: this_CollectionTemplateCS_0= ruleCollectionTemplateCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTemplateCSAccess().getCollectionTemplateCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_35);
                    this_CollectionTemplateCS_0=ruleCollectionTemplateCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionTemplateCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:1697:2: this_ObjectTemplateCS_1= ruleObjectTemplateCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTemplateCSAccess().getObjectTemplateCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_35);
                    this_ObjectTemplateCS_1=ruleObjectTemplateCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ObjectTemplateCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // InternalQVTrelation.g:1708:2: (otherlv_2= '{' ( (lv_ownedGuardExpression_3_0= ruleExpCS ) ) otherlv_4= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==17) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalQVTrelation.g:1708:4: otherlv_2= '{' ( (lv_ownedGuardExpression_3_0= ruleExpCS ) ) otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTemplateCSAccess().getLeftCurlyBracketKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:1712:1: ( (lv_ownedGuardExpression_3_0= ruleExpCS ) )
                    // InternalQVTrelation.g:1713:1: (lv_ownedGuardExpression_3_0= ruleExpCS )
                    {
                    // InternalQVTrelation.g:1713:1: (lv_ownedGuardExpression_3_0= ruleExpCS )
                    // InternalQVTrelation.g:1714:3: lv_ownedGuardExpression_3_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTemplateCSAccess().getOwnedGuardExpressionExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    lv_ownedGuardExpression_3_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTemplateCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedGuardExpression",
                              		lv_ownedGuardExpression_3_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTemplateCSAccess().getRightCurlyBracketKeyword_1_2());
                          
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
    // $ANTLR end "ruleTemplateCS"


    // $ANTLR start "entryRuleTransformationCS"
    // InternalQVTrelation.g:1742:1: entryRuleTransformationCS returns [EObject current=null] : iv_ruleTransformationCS= ruleTransformationCS EOF ;
    public final EObject entryRuleTransformationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationCS = null;


        try {
            // InternalQVTrelation.g:1743:2: (iv_ruleTransformationCS= ruleTransformationCS EOF )
            // InternalQVTrelation.g:1744:2: iv_ruleTransformationCS= ruleTransformationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransformationCS=ruleTransformationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:1751:1: ruleTransformationCS returns [EObject current=null] : (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_ownedModelDecls_4_0= ruleModelDeclCS ) ) (otherlv_5= ',' ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) ) )* otherlv_7= ')' (otherlv_8= 'extends' ( ( ruleUnrestrictedName ) ) (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_12= '{' ( (lv_ownedKeyDecls_13_0= ruleKeyDeclCS ) )* ( ( (lv_ownedRelations_14_0= ruleRelationCS ) ) | ( (lv_ownedQueries_15_0= ruleQueryCS ) ) )* otherlv_16= '}' ) ;
    public final EObject ruleTransformationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_16=null;
        EObject lv_ownedPathName_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedModelDecls_4_0 = null;

        EObject lv_ownedModelDecls_6_0 = null;

        EObject lv_ownedKeyDecls_13_0 = null;

        EObject lv_ownedRelations_14_0 = null;

        EObject lv_ownedQueries_15_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1754:28: ( (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_ownedModelDecls_4_0= ruleModelDeclCS ) ) (otherlv_5= ',' ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) ) )* otherlv_7= ')' (otherlv_8= 'extends' ( ( ruleUnrestrictedName ) ) (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_12= '{' ( (lv_ownedKeyDecls_13_0= ruleKeyDeclCS ) )* ( ( (lv_ownedRelations_14_0= ruleRelationCS ) ) | ( (lv_ownedQueries_15_0= ruleQueryCS ) ) )* otherlv_16= '}' ) )
            // InternalQVTrelation.g:1755:1: (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_ownedModelDecls_4_0= ruleModelDeclCS ) ) (otherlv_5= ',' ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) ) )* otherlv_7= ')' (otherlv_8= 'extends' ( ( ruleUnrestrictedName ) ) (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_12= '{' ( (lv_ownedKeyDecls_13_0= ruleKeyDeclCS ) )* ( ( (lv_ownedRelations_14_0= ruleRelationCS ) ) | ( (lv_ownedQueries_15_0= ruleQueryCS ) ) )* otherlv_16= '}' )
            {
            // InternalQVTrelation.g:1755:1: (otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_ownedModelDecls_4_0= ruleModelDeclCS ) ) (otherlv_5= ',' ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) ) )* otherlv_7= ')' (otherlv_8= 'extends' ( ( ruleUnrestrictedName ) ) (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_12= '{' ( (lv_ownedKeyDecls_13_0= ruleKeyDeclCS ) )* ( ( (lv_ownedRelations_14_0= ruleRelationCS ) ) | ( (lv_ownedQueries_15_0= ruleQueryCS ) ) )* otherlv_16= '}' )
            // InternalQVTrelation.g:1755:3: otherlv_0= 'transformation' ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )? ( (lv_name_2_0= ruleUnrestrictedName ) ) otherlv_3= '(' ( (lv_ownedModelDecls_4_0= ruleModelDeclCS ) ) (otherlv_5= ',' ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) ) )* otherlv_7= ')' (otherlv_8= 'extends' ( ( ruleUnrestrictedName ) ) (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_12= '{' ( (lv_ownedKeyDecls_13_0= ruleKeyDeclCS ) )* ( ( (lv_ownedRelations_14_0= ruleRelationCS ) ) | ( (lv_ownedQueries_15_0= ruleQueryCS ) ) )* otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
                  
            }
            // InternalQVTrelation.g:1759:1: ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalQVTrelation.g:1760:1: (lv_ownedPathName_1_0= ruleScopeNameCS )
                    {
                    // InternalQVTrelation.g:1760:1: (lv_ownedPathName_1_0= ruleScopeNameCS )
                    // InternalQVTrelation.g:1761:3: lv_ownedPathName_1_0= ruleScopeNameCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_ownedPathName_1_0=ruleScopeNameCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedPathName",
                              		lv_ownedPathName_1_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ScopeNameCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:1777:3: ( (lv_name_2_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:1778:1: (lv_name_2_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:1778:1: (lv_name_2_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:1779:3: lv_name_2_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_22);
            lv_name_2_0=ruleUnrestrictedName();

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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,31,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getLeftParenthesisKeyword_3());
                  
            }
            // InternalQVTrelation.g:1799:1: ( (lv_ownedModelDecls_4_0= ruleModelDeclCS ) )
            // InternalQVTrelation.g:1800:1: (lv_ownedModelDecls_4_0= ruleModelDeclCS )
            {
            // InternalQVTrelation.g:1800:1: (lv_ownedModelDecls_4_0= ruleModelDeclCS )
            // InternalQVTrelation.g:1801:3: lv_ownedModelDecls_4_0= ruleModelDeclCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedModelDeclsModelDeclCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_27);
            lv_ownedModelDecls_4_0=ruleModelDeclCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedModelDecls",
                      		lv_ownedModelDecls_4_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ModelDeclCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:1817:2: (otherlv_5= ',' ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==18) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalQVTrelation.g:1817:4: otherlv_5= ',' ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // InternalQVTrelation.g:1821:1: ( (lv_ownedModelDecls_6_0= ruleModelDeclCS ) )
            	    // InternalQVTrelation.g:1822:1: (lv_ownedModelDecls_6_0= ruleModelDeclCS )
            	    {
            	    // InternalQVTrelation.g:1822:1: (lv_ownedModelDecls_6_0= ruleModelDeclCS )
            	    // InternalQVTrelation.g:1823:3: lv_ownedModelDecls_6_0= ruleModelDeclCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedModelDeclsModelDeclCSParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_27);
            	    lv_ownedModelDecls_6_0=ruleModelDeclCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedModelDecls",
            	              		lv_ownedModelDecls_6_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ModelDeclCS");
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

            otherlv_7=(Token)match(input,32,FollowSets000.FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getTransformationCSAccess().getRightParenthesisKeyword_6());
                  
            }
            // InternalQVTrelation.g:1843:1: (otherlv_8= 'extends' ( ( ruleUnrestrictedName ) ) (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==41) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalQVTrelation.g:1843:3: otherlv_8= 'extends' ( ( ruleUnrestrictedName ) ) (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )*
                    {
                    otherlv_8=(Token)match(input,41,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTransformationCSAccess().getExtendsKeyword_7_0());
                          
                    }
                    // InternalQVTrelation.g:1847:1: ( ( ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:1848:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:1848:1: ( ruleUnrestrictedName )
                    // InternalQVTrelation.g:1849:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getExtendsTransformationCrossReference_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_37);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:1865:2: (otherlv_10= ',' ( ( ruleUnrestrictedName ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==18) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalQVTrelation.g:1865:4: otherlv_10= ',' ( ( ruleUnrestrictedName ) )
                    	    {
                    	    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getTransformationCSAccess().getCommaKeyword_7_2_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:1869:1: ( ( ruleUnrestrictedName ) )
                    	    // InternalQVTrelation.g:1870:1: ( ruleUnrestrictedName )
                    	    {
                    	    // InternalQVTrelation.g:1870:1: ( ruleUnrestrictedName )
                    	    // InternalQVTrelation.g:1871:3: ruleUnrestrictedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getExtendsTransformationCrossReference_7_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_37);
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
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_8());
                  
            }
            // InternalQVTrelation.g:1891:1: ( (lv_ownedKeyDecls_13_0= ruleKeyDeclCS ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==29) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalQVTrelation.g:1892:1: (lv_ownedKeyDecls_13_0= ruleKeyDeclCS )
            	    {
            	    // InternalQVTrelation.g:1892:1: (lv_ownedKeyDecls_13_0= ruleKeyDeclCS )
            	    // InternalQVTrelation.g:1893:3: lv_ownedKeyDecls_13_0= ruleKeyDeclCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedKeyDeclsKeyDeclCSParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_38);
            	    lv_ownedKeyDecls_13_0=ruleKeyDeclCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedKeyDecls",
            	              		lv_ownedKeyDecls_13_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.KeyDeclCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            // InternalQVTrelation.g:1909:3: ( ( (lv_ownedRelations_14_0= ruleRelationCS ) ) | ( (lv_ownedQueries_15_0= ruleQueryCS ) ) )*
            loop40:
            do {
                int alt40=3;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=35 && LA40_0<=37)) ) {
                    alt40=1;
                }
                else if ( (LA40_0==34) ) {
                    alt40=2;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalQVTrelation.g:1909:4: ( (lv_ownedRelations_14_0= ruleRelationCS ) )
            	    {
            	    // InternalQVTrelation.g:1909:4: ( (lv_ownedRelations_14_0= ruleRelationCS ) )
            	    // InternalQVTrelation.g:1910:1: (lv_ownedRelations_14_0= ruleRelationCS )
            	    {
            	    // InternalQVTrelation.g:1910:1: (lv_ownedRelations_14_0= ruleRelationCS )
            	    // InternalQVTrelation.g:1911:3: lv_ownedRelations_14_0= ruleRelationCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedRelationsRelationCSParserRuleCall_10_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_39);
            	    lv_ownedRelations_14_0=ruleRelationCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedRelations",
            	              		lv_ownedRelations_14_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.RelationCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalQVTrelation.g:1928:6: ( (lv_ownedQueries_15_0= ruleQueryCS ) )
            	    {
            	    // InternalQVTrelation.g:1928:6: ( (lv_ownedQueries_15_0= ruleQueryCS ) )
            	    // InternalQVTrelation.g:1929:1: (lv_ownedQueries_15_0= ruleQueryCS )
            	    {
            	    // InternalQVTrelation.g:1929:1: (lv_ownedQueries_15_0= ruleQueryCS )
            	    // InternalQVTrelation.g:1930:3: lv_ownedQueries_15_0= ruleQueryCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedQueriesQueryCSParserRuleCall_10_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_39);
            	    lv_ownedQueries_15_0=ruleQueryCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedQueries",
            	              		lv_ownedQueries_15_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.QueryCS");
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

            otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getTransformationCSAccess().getRightCurlyBracketKeyword_11());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleUnitCS"
    // InternalQVTrelation.g:1958:1: entryRuleUnitCS returns [EObject current=null] : iv_ruleUnitCS= ruleUnitCS EOF ;
    public final EObject entryRuleUnitCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitCS = null;


        try {
            // InternalQVTrelation.g:1959:2: (iv_ruleUnitCS= ruleUnitCS EOF )
            // InternalQVTrelation.g:1960:2: iv_ruleUnitCS= ruleUnitCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnitCS=ruleUnitCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitCS"


    // $ANTLR start "ruleUnitCS"
    // InternalQVTrelation.g:1967:1: ruleUnitCS returns [EObject current=null] : (otherlv_0= 'import' ( ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) (otherlv_4= '::' ( (lv_isAll_5_0= '*' ) ) )? otherlv_6= ';' ) ;
    public final EObject ruleUnitCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_isAll_5_0=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedPathName_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:1970:28: ( (otherlv_0= 'import' ( ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) (otherlv_4= '::' ( (lv_isAll_5_0= '*' ) ) )? otherlv_6= ';' ) )
            // InternalQVTrelation.g:1971:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) (otherlv_4= '::' ( (lv_isAll_5_0= '*' ) ) )? otherlv_6= ';' )
            {
            // InternalQVTrelation.g:1971:1: (otherlv_0= 'import' ( ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) (otherlv_4= '::' ( (lv_isAll_5_0= '*' ) ) )? otherlv_6= ';' )
            // InternalQVTrelation.g:1971:3: otherlv_0= 'import' ( ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' )? ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) ) (otherlv_4= '::' ( (lv_isAll_5_0= '*' ) ) )? otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUnitCSAccess().getImportKeyword_0());
                  
            }
            // InternalQVTrelation.g:1975:1: ( ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' )?
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // InternalQVTrelation.g:1975:2: ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':'
                    {
                    // InternalQVTrelation.g:1975:2: ( (lv_name_1_0= ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:1976:1: (lv_name_1_0= ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:1976:1: (lv_name_1_0= ruleUnrestrictedName )
                    // InternalQVTrelation.g:1977:3: lv_name_1_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnitCSAccess().getNameUnrestrictedNameParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_name_1_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnitCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getUnitCSAccess().getColonKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // InternalQVTrelation.g:1997:3: ( (lv_ownedPathName_3_0= ruleURIPathNameCS ) )
            // InternalQVTrelation.g:1998:1: (lv_ownedPathName_3_0= ruleURIPathNameCS )
            {
            // InternalQVTrelation.g:1998:1: (lv_ownedPathName_3_0= ruleURIPathNameCS )
            // InternalQVTrelation.g:1999:3: lv_ownedPathName_3_0= ruleURIPathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnitCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_41);
            lv_ownedPathName_3_0=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnitCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_3_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIPathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:2015:2: (otherlv_4= '::' ( (lv_isAll_5_0= '*' ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==39) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalQVTrelation.g:2015:4: otherlv_4= '::' ( (lv_isAll_5_0= '*' ) )
                    {
                    otherlv_4=(Token)match(input,39,FollowSets000.FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getUnitCSAccess().getColonColonKeyword_3_0());
                          
                    }
                    // InternalQVTrelation.g:2019:1: ( (lv_isAll_5_0= '*' ) )
                    // InternalQVTrelation.g:2020:1: (lv_isAll_5_0= '*' )
                    {
                    // InternalQVTrelation.g:2020:1: (lv_isAll_5_0= '*' )
                    // InternalQVTrelation.g:2021:3: lv_isAll_5_0= '*'
                    {
                    lv_isAll_5_0=(Token)match(input,43,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isAll_5_0, grammarAccess.getUnitCSAccess().getIsAllAsteriskKeyword_3_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnitCSRule());
                      	        }
                             		setWithLastConsumed(current, "isAll", true, "*");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getUnitCSAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitCS"


    // $ANTLR start "entryRuleVarDeclarationCS"
    // InternalQVTrelation.g:2046:1: entryRuleVarDeclarationCS returns [EObject current=null] : iv_ruleVarDeclarationCS= ruleVarDeclarationCS EOF ;
    public final EObject entryRuleVarDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclarationCS = null;


        try {
            // InternalQVTrelation.g:2047:2: (iv_ruleVarDeclarationCS= ruleVarDeclarationCS EOF )
            // InternalQVTrelation.g:2048:2: iv_ruleVarDeclarationCS= ruleVarDeclarationCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarDeclarationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVarDeclarationCS=ruleVarDeclarationCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarDeclarationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDeclarationCS"


    // $ANTLR start "ruleVarDeclarationCS"
    // InternalQVTrelation.g:2055:1: ruleVarDeclarationCS returns [EObject current=null] : ( ( (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS ) ) (otherlv_1= ',' ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) ) )* (otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) )? (otherlv_5= '=' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )? otherlv_7= ';' ) ;
    public final EObject ruleVarDeclarationCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedVarDeclarationIds_0_0 = null;

        EObject lv_ownedVarDeclarationIds_2_0 = null;

        EObject lv_ownedType_4_0 = null;

        EObject lv_ownedInitExpression_6_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2058:28: ( ( ( (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS ) ) (otherlv_1= ',' ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) ) )* (otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) )? (otherlv_5= '=' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )? otherlv_7= ';' ) )
            // InternalQVTrelation.g:2059:1: ( ( (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS ) ) (otherlv_1= ',' ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) ) )* (otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) )? (otherlv_5= '=' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )? otherlv_7= ';' )
            {
            // InternalQVTrelation.g:2059:1: ( ( (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS ) ) (otherlv_1= ',' ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) ) )* (otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) )? (otherlv_5= '=' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )? otherlv_7= ';' )
            // InternalQVTrelation.g:2059:2: ( (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS ) ) (otherlv_1= ',' ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) ) )* (otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) )? (otherlv_5= '=' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )? otherlv_7= ';'
            {
            // InternalQVTrelation.g:2059:2: ( (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS ) )
            // InternalQVTrelation.g:2060:1: (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS )
            {
            // InternalQVTrelation.g:2060:1: (lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS )
            // InternalQVTrelation.g:2061:3: lv_ownedVarDeclarationIds_0_0= ruleVarDeclarationIdCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVarDeclarationCSAccess().getOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_43);
            lv_ownedVarDeclarationIds_0_0=ruleVarDeclarationIdCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVarDeclarationCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedVarDeclarationIds",
                      		lv_ownedVarDeclarationIds_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.VarDeclarationIdCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:2077:2: (otherlv_1= ',' ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==18) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalQVTrelation.g:2077:4: otherlv_1= ',' ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getVarDeclarationCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalQVTrelation.g:2081:1: ( (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS ) )
            	    // InternalQVTrelation.g:2082:1: (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS )
            	    {
            	    // InternalQVTrelation.g:2082:1: (lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS )
            	    // InternalQVTrelation.g:2083:3: lv_ownedVarDeclarationIds_2_0= ruleVarDeclarationIdCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVarDeclarationCSAccess().getOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_43);
            	    lv_ownedVarDeclarationIds_2_0=ruleVarDeclarationIdCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVarDeclarationCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedVarDeclarationIds",
            	              		lv_ownedVarDeclarationIds_2_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.VarDeclarationIdCS");
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

            // InternalQVTrelation.g:2099:4: (otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==16) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalQVTrelation.g:2099:6: otherlv_3= ':' ( (lv_ownedType_4_0= ruleTypedRefCS ) )
                    {
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVarDeclarationCSAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalQVTrelation.g:2103:1: ( (lv_ownedType_4_0= ruleTypedRefCS ) )
                    // InternalQVTrelation.g:2104:1: (lv_ownedType_4_0= ruleTypedRefCS )
                    {
                    // InternalQVTrelation.g:2104:1: (lv_ownedType_4_0= ruleTypedRefCS )
                    // InternalQVTrelation.g:2105:3: lv_ownedType_4_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarDeclarationCSAccess().getOwnedTypeTypedRefCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_44);
                    lv_ownedType_4_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarDeclarationCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_4_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:2121:4: (otherlv_5= '=' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==21) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalQVTrelation.g:2121:6: otherlv_5= '=' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                    {
                    otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getVarDeclarationCSAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalQVTrelation.g:2125:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                    // InternalQVTrelation.g:2126:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                    {
                    // InternalQVTrelation.g:2126:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                    // InternalQVTrelation.g:2127:3: lv_ownedInitExpression_6_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarDeclarationCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_ownedInitExpression_6_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarDeclarationCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_6_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getVarDeclarationCSAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDeclarationCS"


    // $ANTLR start "entryRuleVarDeclarationIdCS"
    // InternalQVTrelation.g:2155:1: entryRuleVarDeclarationIdCS returns [EObject current=null] : iv_ruleVarDeclarationIdCS= ruleVarDeclarationIdCS EOF ;
    public final EObject entryRuleVarDeclarationIdCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclarationIdCS = null;


        try {
            // InternalQVTrelation.g:2156:2: (iv_ruleVarDeclarationIdCS= ruleVarDeclarationIdCS EOF )
            // InternalQVTrelation.g:2157:2: iv_ruleVarDeclarationIdCS= ruleVarDeclarationIdCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarDeclarationIdCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVarDeclarationIdCS=ruleVarDeclarationIdCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarDeclarationIdCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDeclarationIdCS"


    // $ANTLR start "ruleVarDeclarationIdCS"
    // InternalQVTrelation.g:2164:1: ruleVarDeclarationIdCS returns [EObject current=null] : ( (lv_name_0_0= ruleUnrestrictedName ) ) ;
    public final EObject ruleVarDeclarationIdCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2167:28: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) )
            // InternalQVTrelation.g:2168:1: ( (lv_name_0_0= ruleUnrestrictedName ) )
            {
            // InternalQVTrelation.g:2168:1: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:2169:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:2169:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:2170:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVarDeclarationIdCSAccess().getNameUnrestrictedNameParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVarDeclarationIdCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
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
    // $ANTLR end "ruleVarDeclarationIdCS"


    // $ANTLR start "entryRuleWhenCS"
    // InternalQVTrelation.g:2194:1: entryRuleWhenCS returns [EObject current=null] : iv_ruleWhenCS= ruleWhenCS EOF ;
    public final EObject entryRuleWhenCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenCS = null;


        try {
            // InternalQVTrelation.g:2195:2: (iv_ruleWhenCS= ruleWhenCS EOF )
            // InternalQVTrelation.g:2196:2: iv_ruleWhenCS= ruleWhenCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhenCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWhenCS=ruleWhenCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhenCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhenCS"


    // $ANTLR start "ruleWhenCS"
    // InternalQVTrelation.g:2203:1: ruleWhenCS returns [EObject current=null] : ( () otherlv_1= 'when' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' ) ;
    public final EObject ruleWhenCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPredicates_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2206:28: ( ( () otherlv_1= 'when' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' ) )
            // InternalQVTrelation.g:2207:1: ( () otherlv_1= 'when' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' )
            {
            // InternalQVTrelation.g:2207:1: ( () otherlv_1= 'when' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' )
            // InternalQVTrelation.g:2207:2: () otherlv_1= 'when' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}'
            {
            // InternalQVTrelation.g:2207:2: ()
            // InternalQVTrelation.g:2208:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWhenCSAccess().getPatternCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,44,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWhenCSAccess().getWhenKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getWhenCSAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalQVTrelation.g:2224:1: ( (lv_ownedPredicates_3_0= rulePredicateCS ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=RULE_SIMPLE_ID && LA46_0<=RULE_SINGLE_QUOTED_STRING)||(LA46_0>=23 && LA46_0<=31)||(LA46_0>=33 && LA46_0<=38)||(LA46_0>=40 && LA46_0<=48)||(LA46_0>=64 && LA46_0<=78)||LA46_0==80||(LA46_0>=82 && LA46_0<=85)||LA46_0==92||(LA46_0>=97 && LA46_0<=98)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalQVTrelation.g:2225:1: (lv_ownedPredicates_3_0= rulePredicateCS )
            	    {
            	    // InternalQVTrelation.g:2225:1: (lv_ownedPredicates_3_0= rulePredicateCS )
            	    // InternalQVTrelation.g:2226:3: lv_ownedPredicates_3_0= rulePredicateCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getWhenCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_45);
            	    lv_ownedPredicates_3_0=rulePredicateCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getWhenCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPredicates",
            	              		lv_ownedPredicates_3_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PredicateCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getWhenCSAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhenCS"


    // $ANTLR start "entryRuleWhereCS"
    // InternalQVTrelation.g:2254:1: entryRuleWhereCS returns [EObject current=null] : iv_ruleWhereCS= ruleWhereCS EOF ;
    public final EObject entryRuleWhereCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereCS = null;


        try {
            // InternalQVTrelation.g:2255:2: (iv_ruleWhereCS= ruleWhereCS EOF )
            // InternalQVTrelation.g:2256:2: iv_ruleWhereCS= ruleWhereCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhereCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWhereCS=ruleWhereCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhereCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhereCS"


    // $ANTLR start "ruleWhereCS"
    // InternalQVTrelation.g:2263:1: ruleWhereCS returns [EObject current=null] : ( () otherlv_1= 'where' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' ) ;
    public final EObject ruleWhereCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPredicates_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2266:28: ( ( () otherlv_1= 'where' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' ) )
            // InternalQVTrelation.g:2267:1: ( () otherlv_1= 'where' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' )
            {
            // InternalQVTrelation.g:2267:1: ( () otherlv_1= 'where' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}' )
            // InternalQVTrelation.g:2267:2: () otherlv_1= 'where' otherlv_2= '{' ( (lv_ownedPredicates_3_0= rulePredicateCS ) )* otherlv_4= '}'
            {
            // InternalQVTrelation.g:2267:2: ()
            // InternalQVTrelation.g:2268:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWhereCSAccess().getPatternCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWhereCSAccess().getWhereKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getWhereCSAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalQVTrelation.g:2284:1: ( (lv_ownedPredicates_3_0= rulePredicateCS ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_SIMPLE_ID && LA47_0<=RULE_SINGLE_QUOTED_STRING)||(LA47_0>=23 && LA47_0<=31)||(LA47_0>=33 && LA47_0<=38)||(LA47_0>=40 && LA47_0<=48)||(LA47_0>=64 && LA47_0<=78)||LA47_0==80||(LA47_0>=82 && LA47_0<=85)||LA47_0==92||(LA47_0>=97 && LA47_0<=98)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalQVTrelation.g:2285:1: (lv_ownedPredicates_3_0= rulePredicateCS )
            	    {
            	    // InternalQVTrelation.g:2285:1: (lv_ownedPredicates_3_0= rulePredicateCS )
            	    // InternalQVTrelation.g:2286:3: lv_ownedPredicates_3_0= rulePredicateCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getWhereCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_45);
            	    lv_ownedPredicates_3_0=rulePredicateCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getWhereCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPredicates",
            	              		lv_ownedPredicates_3_0, 
            	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PredicateCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getWhereCSAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhereCS"


    // $ANTLR start "entryRuleExpCSOrTemplateCS"
    // InternalQVTrelation.g:2314:1: entryRuleExpCSOrTemplateCS returns [EObject current=null] : iv_ruleExpCSOrTemplateCS= ruleExpCSOrTemplateCS EOF ;
    public final EObject entryRuleExpCSOrTemplateCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCSOrTemplateCS = null;


        try {
            // InternalQVTrelation.g:2315:2: (iv_ruleExpCSOrTemplateCS= ruleExpCSOrTemplateCS EOF )
            // InternalQVTrelation.g:2316:2: iv_ruleExpCSOrTemplateCS= ruleExpCSOrTemplateCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSOrTemplateCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpCSOrTemplateCS=ruleExpCSOrTemplateCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCSOrTemplateCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpCSOrTemplateCS"


    // $ANTLR start "ruleExpCSOrTemplateCS"
    // InternalQVTrelation.g:2323:1: ruleExpCSOrTemplateCS returns [EObject current=null] : (this_ExpCS_0= ruleExpCS | this_TemplateCS_1= ruleTemplateCS ) ;
    public final EObject ruleExpCSOrTemplateCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;

        EObject this_TemplateCS_1 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2326:28: ( (this_ExpCS_0= ruleExpCS | this_TemplateCS_1= ruleTemplateCS ) )
            // InternalQVTrelation.g:2327:1: (this_ExpCS_0= ruleExpCS | this_TemplateCS_1= ruleTemplateCS )
            {
            // InternalQVTrelation.g:2327:1: (this_ExpCS_0= ruleExpCS | this_TemplateCS_1= ruleTemplateCS )
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // InternalQVTrelation.g:2328:2: this_ExpCS_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSOrTemplateCSAccess().getExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ExpCS_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:2341:2: this_TemplateCS_1= ruleTemplateCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSOrTemplateCSAccess().getTemplateCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TemplateCS_1=ruleTemplateCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TemplateCS_1; 
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
    // $ANTLR end "ruleExpCSOrTemplateCS"


    // $ANTLR start "entryRuleTypedTypeRefCS"
    // InternalQVTrelation.g:2360:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // InternalQVTrelation.g:2361:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // InternalQVTrelation.g:2362:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedTypeRefCS"


    // $ANTLR start "ruleTypedTypeRefCS"
    // InternalQVTrelation.g:2369:1: ruleTypedTypeRefCS returns [EObject current=null] : ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedPathName_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2372:28: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) )
            // InternalQVTrelation.g:2373:1: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            {
            // InternalQVTrelation.g:2373:1: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTrelation.g:2374:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTrelation.g:2374:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTrelation.g:2375:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_0_0, 
                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
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
    // $ANTLR end "ruleTypedTypeRefCS"


    // $ANTLR start "entryRuleTypedRefCS"
    // InternalQVTrelation.g:2399:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // InternalQVTrelation.g:2400:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // InternalQVTrelation.g:2401:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypedRefCS=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedRefCS"


    // $ANTLR start "ruleTypedRefCS"
    // InternalQVTrelation.g:2408:1: ruleTypedRefCS returns [EObject current=null] : ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) | (this_CollectionTypeCS_2= ruleCollectionTypeCS ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) | (this_TypedTypeRefCS_4= ruleTypedTypeRefCS ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) ) ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;

        EObject this_CollectionTypeCS_2 = null;

        EObject lv_ownedMultiplicity_3_0 = null;

        EObject this_TypedTypeRefCS_4 = null;

        EObject lv_ownedMultiplicity_5_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2411:28: ( ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) | (this_CollectionTypeCS_2= ruleCollectionTypeCS ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) | (this_TypedTypeRefCS_4= ruleTypedTypeRefCS ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) ) )
            // InternalQVTrelation.g:2412:1: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) | (this_CollectionTypeCS_2= ruleCollectionTypeCS ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) | (this_TypedTypeRefCS_4= ruleTypedTypeRefCS ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) )
            {
            // InternalQVTrelation.g:2412:1: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) | (this_CollectionTypeCS_2= ruleCollectionTypeCS ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) | (this_TypedTypeRefCS_4= ruleTypedTypeRefCS ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? ) )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt52=1;
                }
                break;
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
                {
                alt52=2;
                }
                break;
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
            case 44:
            case 45:
            case 46:
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
                    // InternalQVTrelation.g:2412:2: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
                    {
                    // InternalQVTrelation.g:2412:2: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
                    // InternalQVTrelation.g:2413:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypedRefCSAccess().getPrimitiveTypeCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveTypeCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalQVTrelation.g:2424:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==88) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalQVTrelation.g:2425:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                            {
                            // InternalQVTrelation.g:2425:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                            // InternalQVTrelation.g:2426:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypedRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypedRefCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_1_0, 
                                      		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:2443:6: (this_CollectionTypeCS_2= ruleCollectionTypeCS ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
                    {
                    // InternalQVTrelation.g:2443:6: (this_CollectionTypeCS_2= ruleCollectionTypeCS ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
                    // InternalQVTrelation.g:2444:2: this_CollectionTypeCS_2= ruleCollectionTypeCS ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypedRefCSAccess().getCollectionTypeCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    this_CollectionTypeCS_2=ruleCollectionTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionTypeCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalQVTrelation.g:2455:1: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==88) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalQVTrelation.g:2456:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                            {
                            // InternalQVTrelation.g:2456:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                            // InternalQVTrelation.g:2457:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypedRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypedRefCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_3_0, 
                                      		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:2474:6: (this_TypedTypeRefCS_4= ruleTypedTypeRefCS ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
                    {
                    // InternalQVTrelation.g:2474:6: (this_TypedTypeRefCS_4= ruleTypedTypeRefCS ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )? )
                    // InternalQVTrelation.g:2475:2: this_TypedTypeRefCS_4= ruleTypedTypeRefCS ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    this_TypedTypeRefCS_4=ruleTypedTypeRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypedTypeRefCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalQVTrelation.g:2486:1: ( (lv_ownedMultiplicity_5_0= ruleMultiplicityCS ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==88) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalQVTrelation.g:2487:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                            {
                            // InternalQVTrelation.g:2487:1: (lv_ownedMultiplicity_5_0= ruleMultiplicityCS )
                            // InternalQVTrelation.g:2488:3: lv_ownedMultiplicity_5_0= ruleMultiplicityCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypedRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedMultiplicity_5_0=ruleMultiplicityCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypedRefCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedMultiplicity",
                                      		lv_ownedMultiplicity_5_0, 
                                      		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
                              	        afterParserOrEnumRuleCall();
                              	    
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
    // $ANTLR end "ruleTypedRefCS"


    // $ANTLR start "entryRuleUnrestrictedName"
    // InternalQVTrelation.g:2512:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // InternalQVTrelation.g:2513:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // InternalQVTrelation.g:2514:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:2521:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'checkonly' | kw= 'default' | kw= 'default_values' | kw= 'domain' | kw= 'enforce' | kw= 'extends' | kw= 'implementedby' | kw= 'import' | kw= 'library' | kw= 'key' | kw= 'opposite' | kw= 'overrides' | kw= 'primitive' | kw= 'query' | kw= 'relation' | kw= 'replace' | kw= 'top' | kw= 'transformation' | kw= 'when' | kw= 'where' ) ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2524:28: ( (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'checkonly' | kw= 'default' | kw= 'default_values' | kw= 'domain' | kw= 'enforce' | kw= 'extends' | kw= 'implementedby' | kw= 'import' | kw= 'library' | kw= 'key' | kw= 'opposite' | kw= 'overrides' | kw= 'primitive' | kw= 'query' | kw= 'relation' | kw= 'replace' | kw= 'top' | kw= 'transformation' | kw= 'when' | kw= 'where' ) )
            // InternalQVTrelation.g:2525:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'checkonly' | kw= 'default' | kw= 'default_values' | kw= 'domain' | kw= 'enforce' | kw= 'extends' | kw= 'implementedby' | kw= 'import' | kw= 'library' | kw= 'key' | kw= 'opposite' | kw= 'overrides' | kw= 'primitive' | kw= 'query' | kw= 'relation' | kw= 'replace' | kw= 'top' | kw= 'transformation' | kw= 'when' | kw= 'where' )
            {
            // InternalQVTrelation.g:2525:1: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName | kw= 'checkonly' | kw= 'default' | kw= 'default_values' | kw= 'domain' | kw= 'enforce' | kw= 'extends' | kw= 'implementedby' | kw= 'import' | kw= 'library' | kw= 'key' | kw= 'opposite' | kw= 'overrides' | kw= 'primitive' | kw= 'query' | kw= 'relation' | kw= 'replace' | kw= 'top' | kw= 'transformation' | kw= 'when' | kw= 'where' )
            int alt53=21;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt53=1;
                }
                break;
            case 23:
                {
                alt53=2;
                }
                break;
            case 36:
                {
                alt53=3;
                }
                break;
            case 28:
                {
                alt53=4;
                }
                break;
            case 26:
                {
                alt53=5;
                }
                break;
            case 24:
                {
                alt53=6;
                }
                break;
            case 41:
                {
                alt53=7;
                }
                break;
            case 27:
                {
                alt53=8;
                }
                break;
            case 42:
                {
                alt53=9;
                }
                break;
            case 46:
                {
                alt53=10;
                }
                break;
            case 29:
                {
                alt53=11;
                }
                break;
            case 30:
                {
                alt53=12;
                }
                break;
            case 38:
                {
                alt53=13;
                }
                break;
            case 33:
                {
                alt53=14;
                }
                break;
            case 34:
                {
                alt53=15;
                }
                break;
            case 37:
                {
                alt53=16;
                }
                break;
            case 25:
                {
                alt53=17;
                }
                break;
            case 35:
                {
                alt53=18;
                }
                break;
            case 40:
                {
                alt53=19;
                }
                break;
            case 44:
                {
                alt53=20;
                }
                break;
            case 45:
                {
                alt53=21;
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
                    // InternalQVTrelation.g:2526:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:2538:2: kw= 'checkonly'
                    {
                    kw=(Token)match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckonlyKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:2545:2: kw= 'default'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getDefaultKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTrelation.g:2552:2: kw= 'default_values'
                    {
                    kw=(Token)match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getDefault_valuesKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTrelation.g:2559:2: kw= 'domain'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getDomainKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalQVTrelation.g:2566:2: kw= 'enforce'
                    {
                    kw=(Token)match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalQVTrelation.g:2573:2: kw= 'extends'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getExtendsKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalQVTrelation.g:2580:2: kw= 'implementedby'
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImplementedbyKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalQVTrelation.g:2587:2: kw= 'import'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalQVTrelation.g:2594:2: kw= 'library'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalQVTrelation.g:2601:2: kw= 'key'
                    {
                    kw=(Token)match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getKeyKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalQVTrelation.g:2608:2: kw= 'opposite'
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getOppositeKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalQVTrelation.g:2615:2: kw= 'overrides'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getOverridesKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalQVTrelation.g:2622:2: kw= 'primitive'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getPrimitiveKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalQVTrelation.g:2629:2: kw= 'query'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // InternalQVTrelation.g:2636:2: kw= 'relation'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRelationKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // InternalQVTrelation.g:2643:2: kw= 'replace'
                    {
                    kw=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getReplaceKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // InternalQVTrelation.g:2650:2: kw= 'top'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTopKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // InternalQVTrelation.g:2657:2: kw= 'transformation'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // InternalQVTrelation.g:2664:2: kw= 'when'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getWhenKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // InternalQVTrelation.g:2671:2: kw= 'where'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getWhereKeyword_20()); 
                          
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


    // $ANTLR start "entryRuleEssentialOCLUnaryOperatorName"
    // InternalQVTrelation.g:2688:1: entryRuleEssentialOCLUnaryOperatorName returns [String current=null] : iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF ;
    public final String entryRuleEssentialOCLUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnaryOperatorName = null;


        try {
            // InternalQVTrelation.g:2689:2: (iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF )
            // InternalQVTrelation.g:2690:2: iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLUnaryOperatorName=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnaryOperatorName"


    // $ANTLR start "ruleEssentialOCLUnaryOperatorName"
    // InternalQVTrelation.g:2697:1: ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2700:28: ( (kw= '-' | kw= 'not' ) )
            // InternalQVTrelation.g:2701:1: (kw= '-' | kw= 'not' )
            {
            // InternalQVTrelation.g:2701:1: (kw= '-' | kw= 'not' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==47) ) {
                alt54=1;
            }
            else if ( (LA54_0==48) ) {
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
                    // InternalQVTrelation.g:2702:2: kw= '-'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:2709:2: kw= 'not'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); 
                          
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
    // $ANTLR end "ruleEssentialOCLUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLInfixOperatorName"
    // InternalQVTrelation.g:2722:1: entryRuleEssentialOCLInfixOperatorName returns [String current=null] : iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF ;
    public final String entryRuleEssentialOCLInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperatorName = null;


        try {
            // InternalQVTrelation.g:2723:2: (iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF )
            // InternalQVTrelation.g:2724:2: iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLInfixOperatorName=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLInfixOperatorName"


    // $ANTLR start "ruleEssentialOCLInfixOperatorName"
    // InternalQVTrelation.g:2731:1: ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2734:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // InternalQVTrelation.g:2735:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // InternalQVTrelation.g:2735:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            int alt55=14;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt55=1;
                }
                break;
            case 49:
                {
                alt55=2;
                }
                break;
            case 50:
                {
                alt55=3;
                }
                break;
            case 47:
                {
                alt55=4;
                }
                break;
            case 51:
                {
                alt55=5;
                }
                break;
            case 52:
                {
                alt55=6;
                }
                break;
            case 53:
                {
                alt55=7;
                }
                break;
            case 54:
                {
                alt55=8;
                }
                break;
            case 21:
                {
                alt55=9;
                }
                break;
            case 55:
                {
                alt55=10;
                }
                break;
            case 56:
                {
                alt55=11;
                }
                break;
            case 57:
                {
                alt55=12;
                }
                break;
            case 58:
                {
                alt55=13;
                }
                break;
            case 59:
                {
                alt55=14;
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
                    // InternalQVTrelation.g:2736:2: kw= '*'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:2743:2: kw= '/'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:2750:2: kw= '+'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTrelation.g:2757:2: kw= '-'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTrelation.g:2764:2: kw= '>'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalQVTrelation.g:2771:2: kw= '<'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalQVTrelation.g:2778:2: kw= '>='
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalQVTrelation.g:2785:2: kw= '<='
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalQVTrelation.g:2792:2: kw= '='
                    {
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalQVTrelation.g:2799:2: kw= '<>'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalQVTrelation.g:2806:2: kw= 'and'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalQVTrelation.g:2813:2: kw= 'or'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalQVTrelation.g:2820:2: kw= 'xor'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalQVTrelation.g:2827:2: kw= 'implies'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_13()); 
                          
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
    // $ANTLR end "ruleEssentialOCLInfixOperatorName"


    // $ANTLR start "entryRuleEssentialOCLNavigationOperatorName"
    // InternalQVTrelation.g:2840:1: entryRuleEssentialOCLNavigationOperatorName returns [String current=null] : iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF ;
    public final String entryRuleEssentialOCLNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperatorName = null;


        try {
            // InternalQVTrelation.g:2841:2: (iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF )
            // InternalQVTrelation.g:2842:2: iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLNavigationOperatorName=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLNavigationOperatorName"


    // $ANTLR start "ruleEssentialOCLNavigationOperatorName"
    // InternalQVTrelation.g:2849:1: ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2852:28: ( (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) )
            // InternalQVTrelation.g:2853:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            {
            // InternalQVTrelation.g:2853:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            int alt56=4;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt56=1;
                }
                break;
            case 61:
                {
                alt56=2;
                }
                break;
            case 62:
                {
                alt56=3;
                }
                break;
            case 63:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalQVTrelation.g:2854:2: kw= '.'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:2861:2: kw= '->'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:2868:2: kw= '?.'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTrelation.g:2875:2: kw= '?->'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); 
                          
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
    // $ANTLR end "ruleEssentialOCLNavigationOperatorName"


    // $ANTLR start "entryRuleBinaryOperatorName"
    // InternalQVTrelation.g:2888:1: entryRuleBinaryOperatorName returns [String current=null] : iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF ;
    public final String entryRuleBinaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOperatorName = null;


        try {
            // InternalQVTrelation.g:2889:2: (iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF )
            // InternalQVTrelation.g:2890:2: iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBinaryOperatorName=ruleBinaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryOperatorName"


    // $ANTLR start "ruleBinaryOperatorName"
    // InternalQVTrelation.g:2897:1: ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_InfixOperatorName_0 = null;

        AntlrDatatypeRuleToken this_NavigationOperatorName_1 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2900:28: ( (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) )
            // InternalQVTrelation.g:2901:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            {
            // InternalQVTrelation.g:2901:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==21||LA57_0==43||LA57_0==47||(LA57_0>=49 && LA57_0<=59)) ) {
                alt57=1;
            }
            else if ( ((LA57_0>=60 && LA57_0<=63)) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalQVTrelation.g:2902:5: this_InfixOperatorName_0= ruleInfixOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_InfixOperatorName_0=ruleInfixOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_InfixOperatorName_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:2914:5: this_NavigationOperatorName_1= ruleNavigationOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NavigationOperatorName_1=ruleNavigationOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NavigationOperatorName_1);
                          
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
    // $ANTLR end "ruleBinaryOperatorName"


    // $ANTLR start "entryRuleInfixOperatorName"
    // InternalQVTrelation.g:2932:1: entryRuleInfixOperatorName returns [String current=null] : iv_ruleInfixOperatorName= ruleInfixOperatorName EOF ;
    public final String entryRuleInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperatorName = null;


        try {
            // InternalQVTrelation.g:2933:2: (iv_ruleInfixOperatorName= ruleInfixOperatorName EOF )
            // InternalQVTrelation.g:2934:2: iv_ruleInfixOperatorName= ruleInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInfixOperatorName=ruleInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOperatorName"


    // $ANTLR start "ruleInfixOperatorName"
    // InternalQVTrelation.g:2941:1: ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName ;
    public final AntlrDatatypeRuleToken ruleInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperatorName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2944:28: (this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName )
            // InternalQVTrelation.g:2946:5: this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLInfixOperatorName_0=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLInfixOperatorName_0);
                  
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
    // $ANTLR end "ruleInfixOperatorName"


    // $ANTLR start "entryRuleNavigationOperatorName"
    // InternalQVTrelation.g:2964:1: entryRuleNavigationOperatorName returns [String current=null] : iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF ;
    public final String entryRuleNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperatorName = null;


        try {
            // InternalQVTrelation.g:2965:2: (iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF )
            // InternalQVTrelation.g:2966:2: iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigationOperatorName=ruleNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOperatorName"


    // $ANTLR start "ruleNavigationOperatorName"
    // InternalQVTrelation.g:2973:1: ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName ;
    public final AntlrDatatypeRuleToken ruleNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperatorName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:2976:28: (this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName )
            // InternalQVTrelation.g:2978:5: this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLNavigationOperatorName_0=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLNavigationOperatorName_0);
                  
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
    // $ANTLR end "ruleNavigationOperatorName"


    // $ANTLR start "entryRuleUnaryOperatorName"
    // InternalQVTrelation.g:2996:1: entryRuleUnaryOperatorName returns [String current=null] : iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF ;
    public final String entryRuleUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperatorName = null;


        try {
            // InternalQVTrelation.g:2997:2: (iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF )
            // InternalQVTrelation.g:2998:2: iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryOperatorName=ruleUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperatorName"


    // $ANTLR start "ruleUnaryOperatorName"
    // InternalQVTrelation.g:3005:1: ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName ;
    public final AntlrDatatypeRuleToken ruleUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnaryOperatorName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3008:28: (this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName )
            // InternalQVTrelation.g:3010:5: this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_EssentialOCLUnaryOperatorName_0=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnaryOperatorName_0);
                  
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
    // $ANTLR end "ruleUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // InternalQVTrelation.g:3028:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // InternalQVTrelation.g:3029:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // InternalQVTrelation.g:3030:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3037:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3040:28: (this_Identifier_0= ruleIdentifier )
            // InternalQVTrelation.g:3042:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQVTrelation.g:3060:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // InternalQVTrelation.g:3061:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // InternalQVTrelation.g:3062:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3069:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3072:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) )
            // InternalQVTrelation.g:3073:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            {
            // InternalQVTrelation.g:3073:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            int alt58=5;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
            case 44:
            case 45:
            case 46:
                {
                alt58=1;
                }
                break;
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
                {
                alt58=2;
                }
                break;
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt58=3;
                }
                break;
            case 64:
                {
                alt58=4;
                }
                break;
            case 65:
                {
                alt58=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalQVTrelation.g:3074:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:3086:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:3098:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:3110:2: kw= 'Map'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTrelation.g:3117:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); 
                          
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
    // InternalQVTrelation.g:3130:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // InternalQVTrelation.g:3131:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // InternalQVTrelation.g:3132:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3139:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3142:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // InternalQVTrelation.g:3144:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "entryRuleURIPathNameCS"
    // InternalQVTrelation.g:3162:1: entryRuleURIPathNameCS returns [EObject current=null] : iv_ruleURIPathNameCS= ruleURIPathNameCS EOF ;
    public final EObject entryRuleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIPathNameCS = null;


        try {
            // InternalQVTrelation.g:3163:2: (iv_ruleURIPathNameCS= ruleURIPathNameCS EOF )
            // InternalQVTrelation.g:3164:2: iv_ruleURIPathNameCS= ruleURIPathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleURIPathNameCS=ruleURIPathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIPathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3171:1: ruleURIPathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject ruleURIPathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3174:28: ( ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // InternalQVTrelation.g:3175:1: ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // InternalQVTrelation.g:3175:1: ( ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // InternalQVTrelation.g:3175:2: ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // InternalQVTrelation.g:3175:2: ( (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS ) )
            // InternalQVTrelation.g:3176:1: (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS )
            {
            // InternalQVTrelation.g:3176:1: (lv_ownedPathElements_0_0= ruleURIFirstPathElementCS )
            // InternalQVTrelation.g:3177:3: lv_ownedPathElements_0_0= ruleURIFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_47);
            lv_ownedPathElements_0_0=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPathElements",
                      		lv_ownedPathElements_0_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIFirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:3193:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==39) ) {
                    int LA59_1 = input.LA(2);

                    if ( ((LA59_1>=RULE_SIMPLE_ID && LA59_1<=RULE_ESCAPED_ID)||(LA59_1>=23 && LA59_1<=30)||(LA59_1>=33 && LA59_1<=38)||(LA59_1>=40 && LA59_1<=42)||(LA59_1>=44 && LA59_1<=46)||(LA59_1>=64 && LA59_1<=78)) ) {
                        alt59=1;
                    }


                }


                switch (alt59) {
            	case 1 :
            	    // InternalQVTrelation.g:3193:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_48); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // InternalQVTrelation.g:3197:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // InternalQVTrelation.g:3198:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // InternalQVTrelation.g:3198:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // InternalQVTrelation.g:3199:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_47);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPathElements",
            	              		lv_ownedPathElements_2_0, 
            	              		"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
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


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // InternalQVTrelation.g:3223:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // InternalQVTrelation.g:3224:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // InternalQVTrelation.g:3225:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3232:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3235:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // InternalQVTrelation.g:3236:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // InternalQVTrelation.g:3236:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_SIMPLE_ID && LA60_0<=RULE_ESCAPED_ID)||(LA60_0>=23 && LA60_0<=30)||(LA60_0>=33 && LA60_0<=38)||(LA60_0>=40 && LA60_0<=42)||(LA60_0>=44 && LA60_0<=46)) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_SINGLE_QUOTED_STRING) ) {
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
                    // InternalQVTrelation.g:3236:2: ( ( ruleUnrestrictedName ) )
                    {
                    // InternalQVTrelation.g:3236:2: ( ( ruleUnrestrictedName ) )
                    // InternalQVTrelation.g:3237:1: ( ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:3237:1: ( ruleUnrestrictedName )
                    // InternalQVTrelation.g:3238:3: ruleUnrestrictedName
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
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:3255:6: ( () ( ( ruleURI ) ) )
                    {
                    // InternalQVTrelation.g:3255:6: ( () ( ( ruleURI ) ) )
                    // InternalQVTrelation.g:3255:7: () ( ( ruleURI ) )
                    {
                    // InternalQVTrelation.g:3255:7: ()
                    // InternalQVTrelation.g:3256:2: 
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

                    // InternalQVTrelation.g:3264:2: ( ( ruleURI ) )
                    // InternalQVTrelation.g:3265:1: ( ruleURI )
                    {
                    // InternalQVTrelation.g:3265:1: ( ruleURI )
                    // InternalQVTrelation.g:3266:3: ruleURI
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
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQVTrelation.g:3290:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // InternalQVTrelation.g:3291:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // InternalQVTrelation.g:3292:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3299:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3302:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // InternalQVTrelation.g:3303:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // InternalQVTrelation.g:3303:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt61=8;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt61=1;
                }
                break;
            case 67:
                {
                alt61=2;
                }
                break;
            case 68:
                {
                alt61=3;
                }
                break;
            case 69:
                {
                alt61=4;
                }
                break;
            case 70:
                {
                alt61=5;
                }
                break;
            case 71:
                {
                alt61=6;
                }
                break;
            case 72:
                {
                alt61=7;
                }
                break;
            case 73:
                {
                alt61=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalQVTrelation.g:3304:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:3311:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:3318:2: kw= 'Real'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTrelation.g:3325:2: kw= 'String'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTrelation.g:3332:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalQVTrelation.g:3339:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,71,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalQVTrelation.g:3346:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalQVTrelation.g:3353:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:3366:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // InternalQVTrelation.g:3367:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // InternalQVTrelation.g:3368:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3375:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3378:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // InternalQVTrelation.g:3379:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // InternalQVTrelation.g:3379:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // InternalQVTrelation.g:3380:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // InternalQVTrelation.g:3380:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // InternalQVTrelation.g:3381:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimitiveTypeIdentifier");
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
    // InternalQVTrelation.g:3405:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // InternalQVTrelation.g:3406:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // InternalQVTrelation.g:3407:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3414:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3417:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // InternalQVTrelation.g:3418:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // InternalQVTrelation.g:3418:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt62=5;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt62=1;
                }
                break;
            case 75:
                {
                alt62=2;
                }
                break;
            case 76:
                {
                alt62=3;
                }
                break;
            case 77:
                {
                alt62=4;
                }
                break;
            case 78:
                {
                alt62=5;
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
                    // InternalQVTrelation.g:3419:2: kw= 'Set'
                    {
                    kw=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:3426:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:3433:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,76,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTrelation.g:3440:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,77,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalQVTrelation.g:3447:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,78,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:3460:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // InternalQVTrelation.g:3461:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // InternalQVTrelation.g:3462:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3469:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3472:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // InternalQVTrelation.g:3473:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // InternalQVTrelation.g:3473:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // InternalQVTrelation.g:3473:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // InternalQVTrelation.g:3473:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // InternalQVTrelation.g:3474:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // InternalQVTrelation.g:3474:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // InternalQVTrelation.g:3475:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_49);
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
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeIdentifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:3491:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==31) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalQVTrelation.g:3491:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:3495:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:3496:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:3496:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:3497:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
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
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleMapTypeCS"
    // InternalQVTrelation.g:3525:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
    public final EObject entryRuleMapTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTypeCS = null;


        try {
            // InternalQVTrelation.g:3526:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
            // InternalQVTrelation.g:3527:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapTypeCS=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapTypeCS"


    // $ANTLR start "ruleMapTypeCS"
    // InternalQVTrelation.g:3534:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleMapTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedKeyType_2_0 = null;

        EObject lv_ownedValueType_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3537:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) )
            // InternalQVTrelation.g:3538:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            {
            // InternalQVTrelation.g:3538:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            // InternalQVTrelation.g:3538:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            {
            // InternalQVTrelation.g:3538:2: ( (lv_name_0_0= 'Map' ) )
            // InternalQVTrelation.g:3539:1: (lv_name_0_0= 'Map' )
            {
            // InternalQVTrelation.g:3539:1: (lv_name_0_0= 'Map' )
            // InternalQVTrelation.g:3540:3: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,64,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMapTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Map");
              	    
            }

            }


            }

            // InternalQVTrelation.g:3553:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==31) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalQVTrelation.g:3553:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:3557:1: ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:3558:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:3558:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:3559:3: lv_ownedKeyType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_50);
                    lv_ownedKeyType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedKeyType",
                              		lv_ownedKeyType_2_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
                          
                    }
                    // InternalQVTrelation.g:3579:1: ( (lv_ownedValueType_4_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:3580:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:3580:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:3581:3: lv_ownedValueType_4_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_ownedValueType_4_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedValueType",
                              		lv_ownedValueType_4_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4());
                          
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
    // $ANTLR end "ruleMapTypeCS"


    // $ANTLR start "entryRuleTupleTypeCS"
    // InternalQVTrelation.g:3609:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // InternalQVTrelation.g:3610:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // InternalQVTrelation.g:3611:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3618:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
            // InternalQVTrelation.g:3621:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // InternalQVTrelation.g:3622:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // InternalQVTrelation.g:3622:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // InternalQVTrelation.g:3622:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // InternalQVTrelation.g:3622:2: ( (lv_name_0_0= 'Tuple' ) )
            // InternalQVTrelation.g:3623:1: (lv_name_0_0= 'Tuple' )
            {
            // InternalQVTrelation.g:3623:1: (lv_name_0_0= 'Tuple' )
            // InternalQVTrelation.g:3624:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,65,FollowSets000.FOLLOW_49); if (state.failed) return current;
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

            // InternalQVTrelation.g:3637:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==31) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalQVTrelation.g:3637:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:3641:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( ((LA66_0>=RULE_SIMPLE_ID && LA66_0<=RULE_ESCAPED_ID)||(LA66_0>=23 && LA66_0<=30)||(LA66_0>=33 && LA66_0<=38)||(LA66_0>=40 && LA66_0<=42)||(LA66_0>=44 && LA66_0<=46)) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // InternalQVTrelation.g:3641:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // InternalQVTrelation.g:3641:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // InternalQVTrelation.g:3642:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // InternalQVTrelation.g:3642:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // InternalQVTrelation.g:3643:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_27);
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
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalQVTrelation.g:3659:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop65:
                            do {
                                int alt65=2;
                                int LA65_0 = input.LA(1);

                                if ( (LA65_0==18) ) {
                                    alt65=1;
                                }


                                switch (alt65) {
                            	case 1 :
                            	    // InternalQVTrelation.g:3659:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // InternalQVTrelation.g:3663:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // InternalQVTrelation.g:3664:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // InternalQVTrelation.g:3664:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // InternalQVTrelation.g:3665:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_27);
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
                            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

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

                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:3693:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // InternalQVTrelation.g:3694:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // InternalQVTrelation.g:3695:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3702:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3705:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTrelation.g:3706:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTrelation.g:3706:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTrelation.g:3706:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTrelation.g:3706:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:3707:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:3707:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:3708:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_5);
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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTrelation.g:3728:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // InternalQVTrelation.g:3729:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // InternalQVTrelation.g:3729:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // InternalQVTrelation.g:3730:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
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
    // InternalQVTrelation.g:3754:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:3755:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // InternalQVTrelation.g:3756:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3763:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
            // InternalQVTrelation.g:3766:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // InternalQVTrelation.g:3767:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // InternalQVTrelation.g:3767:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // InternalQVTrelation.g:3767:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // InternalQVTrelation.g:3767:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // InternalQVTrelation.g:3768:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // InternalQVTrelation.g:3768:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // InternalQVTrelation.g:3769:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_7);
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
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTrelation.g:3789:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_SIMPLE_ID && LA69_0<=RULE_SINGLE_QUOTED_STRING)||LA69_0==16||(LA69_0>=23 && LA69_0<=31)||(LA69_0>=33 && LA69_0<=38)||(LA69_0>=40 && LA69_0<=48)||(LA69_0>=64 && LA69_0<=78)||LA69_0==80||(LA69_0>=82 && LA69_0<=85)||LA69_0==92||(LA69_0>=97 && LA69_0<=98)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalQVTrelation.g:3789:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // InternalQVTrelation.g:3789:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // InternalQVTrelation.g:3790:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // InternalQVTrelation.g:3790:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // InternalQVTrelation.g:3791:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_21);
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
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:3807:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==18) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalQVTrelation.g:3807:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:3811:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // InternalQVTrelation.g:3812:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // InternalQVTrelation.g:3812:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // InternalQVTrelation.g:3813:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_21);
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
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
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


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:3841:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // InternalQVTrelation.g:3842:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // InternalQVTrelation.g:3843:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:3850:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedLastExpression_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3853:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
            // InternalQVTrelation.g:3854:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            {
            // InternalQVTrelation.g:3854:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            int alt71=2;
            alt71 = dfa71.predict(input);
            switch (alt71) {
                case 1 :
                    // InternalQVTrelation.g:3854:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTrelation.g:3854:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    // InternalQVTrelation.g:3854:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    {
                    // InternalQVTrelation.g:3854:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // InternalQVTrelation.g:3855:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // InternalQVTrelation.g:3855:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // InternalQVTrelation.g:3856:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_52);
                    lv_ownedExpression_0_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_0_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:3872:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==79) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // InternalQVTrelation.g:3872:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            {
                            otherlv_1=(Token)match(input,79,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
                                  
                            }
                            // InternalQVTrelation.g:3876:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            // InternalQVTrelation.g:3877:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            {
                            // InternalQVTrelation.g:3877:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            // InternalQVTrelation.g:3878:3: lv_ownedLastExpression_2_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedLastExpression_2_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedLastExpression",
                                      		lv_ownedLastExpression_2_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
                    // InternalQVTrelation.g:3895:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    {
                    // InternalQVTrelation.g:3895:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    // InternalQVTrelation.g:3896:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    {
                    // InternalQVTrelation.g:3896:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    // InternalQVTrelation.g:3897:3: lv_ownedExpression_3_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedExpression_3_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_3_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
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
    // $ANTLR end "ruleCollectionLiteralPartCS"


    // $ANTLR start "entryRuleCollectionPatternCS"
    // InternalQVTrelation.g:3921:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
    public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionPatternCS = null;


        try {
            // InternalQVTrelation.g:3922:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
            // InternalQVTrelation.g:3923:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCollectionPatternCS=ruleCollectionPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionPatternCS"


    // $ANTLR start "ruleCollectionPatternCS"
    // InternalQVTrelation.g:3930:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        AntlrDatatypeRuleToken lv_restVariableName_6_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:3933:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
            // InternalQVTrelation.g:3934:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            {
            // InternalQVTrelation.g:3934:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            // InternalQVTrelation.g:3934:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
            {
            // InternalQVTrelation.g:3934:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // InternalQVTrelation.g:3935:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // InternalQVTrelation.g:3935:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // InternalQVTrelation.g:3936:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTrelation.g:3956:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_SIMPLE_ID && LA73_0<=RULE_ESCAPED_ID)||LA73_0==16||(LA73_0>=23 && LA73_0<=30)||(LA73_0>=33 && LA73_0<=38)||(LA73_0>=40 && LA73_0<=42)||(LA73_0>=44 && LA73_0<=46)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalQVTrelation.g:3956:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    {
                    // InternalQVTrelation.g:3956:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
                    // InternalQVTrelation.g:3957:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    {
                    // InternalQVTrelation.g:3957:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    // InternalQVTrelation.g:3958:3: lv_ownedParts_2_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_ownedParts_2_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:3974:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==18) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalQVTrelation.g:3974:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:3978:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    // InternalQVTrelation.g:3979:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    {
                    	    // InternalQVTrelation.g:3979:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    // InternalQVTrelation.g:3980:3: lv_ownedParts_4_0= rulePatternExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_9);
                    	    lv_ownedParts_4_0=rulePatternExpCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
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

                    // InternalQVTrelation.g:3996:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    // InternalQVTrelation.g:3996:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
                          
                    }
                    // InternalQVTrelation.g:4000:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    // InternalQVTrelation.g:4001:1: (lv_restVariableName_6_0= ruleIdentifier )
                    {
                    // InternalQVTrelation.g:4001:1: (lv_restVariableName_6_0= ruleIdentifier )
                    // InternalQVTrelation.g:4002:3: lv_restVariableName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    lv_restVariableName_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		set(
                             			current, 
                             			"restVariableName",
                              		lv_restVariableName_6_0, 
                              		"org.eclipse.ocl.xtext.base.Base.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionPatternCS"


    // $ANTLR start "entryRuleShadowPartCS"
    // InternalQVTrelation.g:4030:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
    public final EObject entryRuleShadowPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowPartCS = null;


        try {
            // InternalQVTrelation.g:4031:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
            // InternalQVTrelation.g:4032:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShadowPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleShadowPartCS=ruleShadowPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShadowPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShadowPartCS"


    // $ANTLR start "ruleShadowPartCS"
    // InternalQVTrelation.g:4039:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) ;
    public final EObject ruleShadowPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedInitExpression_2_1 = null;

        EObject lv_ownedInitExpression_2_2 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4042:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) )
            // InternalQVTrelation.g:4043:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            {
            // InternalQVTrelation.g:4043:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            // InternalQVTrelation.g:4043:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            {
            // InternalQVTrelation.g:4043:2: ( ( ruleUnrestrictedName ) )
            // InternalQVTrelation.g:4044:1: ( ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:4044:1: ( ruleUnrestrictedName )
            // InternalQVTrelation.g:4045:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShadowPartCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_12);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalQVTrelation.g:4065:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            // InternalQVTrelation.g:4066:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            {
            // InternalQVTrelation.g:4066:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            // InternalQVTrelation.g:4067:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            {
            // InternalQVTrelation.g:4067:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            int alt74=2;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // InternalQVTrelation.g:4068:3: lv_ownedInitExpression_2_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedInitExpression_2_1=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_2_1, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:4083:8: lv_ownedInitExpression_2_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedInitExpression_2_2=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_2_2, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

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
    // $ANTLR end "ruleShadowPartCS"


    // $ANTLR start "entryRulePatternExpCS"
    // InternalQVTrelation.g:4109:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
    public final EObject entryRulePatternExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpCS = null;


        try {
            // InternalQVTrelation.g:4110:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
            // InternalQVTrelation.g:4111:2: iv_rulePatternExpCS= rulePatternExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePatternExpCS=rulePatternExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternExpCS"


    // $ANTLR start "rulePatternExpCS"
    // InternalQVTrelation.g:4118:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject rulePatternExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

        EObject lv_ownedPatternType_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4121:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
            // InternalQVTrelation.g:4122:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            {
            // InternalQVTrelation.g:4122:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            // InternalQVTrelation.g:4122:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            {
            // InternalQVTrelation.g:4122:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_SIMPLE_ID && LA75_0<=RULE_ESCAPED_ID)||(LA75_0>=23 && LA75_0<=30)||(LA75_0>=33 && LA75_0<=38)||(LA75_0>=40 && LA75_0<=42)||(LA75_0>=44 && LA75_0<=46)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalQVTrelation.g:4123:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    {
                    // InternalQVTrelation.g:4123:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    // InternalQVTrelation.g:4124:3: lv_patternVariableName_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_patternVariableName_0_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"patternVariableName",
                              		lv_patternVariableName_0_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
                  
            }
            // InternalQVTrelation.g:4144:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            // InternalQVTrelation.g:4145:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            {
            // InternalQVTrelation.g:4145:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            // InternalQVTrelation.g:4146:3: lv_ownedPatternType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedPatternType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPatternType",
                      		lv_ownedPatternType_2_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
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
    // $ANTLR end "rulePatternExpCS"


    // $ANTLR start "entryRuleLambdaLiteralExpCS"
    // InternalQVTrelation.g:4170:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
    public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4171:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
            // InternalQVTrelation.g:4172:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambdaLiteralExpCS"


    // $ANTLR start "ruleLambdaLiteralExpCS"
    // InternalQVTrelation.g:4179:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4182:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
            // InternalQVTrelation.g:4183:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            {
            // InternalQVTrelation.g:4183:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            // InternalQVTrelation.g:4183:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTrelation.g:4191:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
            // InternalQVTrelation.g:4192:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            {
            // InternalQVTrelation.g:4192:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            // InternalQVTrelation.g:4193:3: lv_ownedExpressionCS_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_11);
            lv_ownedExpressionCS_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpressionCS",
                      		lv_ownedExpressionCS_2_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLambdaLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralExpCS"
    // InternalQVTrelation.g:4221:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4222:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // InternalQVTrelation.g:4223:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteralExpCS"


    // $ANTLR start "ruleMapLiteralExpCS"
    // InternalQVTrelation.g:4230:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4233:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // InternalQVTrelation.g:4234:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // InternalQVTrelation.g:4234:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // InternalQVTrelation.g:4234:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // InternalQVTrelation.g:4234:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // InternalQVTrelation.g:4235:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // InternalQVTrelation.g:4235:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // InternalQVTrelation.g:4236:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_ownedType_0_0=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTrelation.g:4256:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=RULE_SIMPLE_ID && LA77_0<=RULE_SINGLE_QUOTED_STRING)||(LA77_0>=23 && LA77_0<=31)||(LA77_0>=33 && LA77_0<=38)||(LA77_0>=40 && LA77_0<=48)||(LA77_0>=64 && LA77_0<=78)||LA77_0==80||(LA77_0>=82 && LA77_0<=85)||LA77_0==92||(LA77_0>=97 && LA77_0<=98)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalQVTrelation.g:4256:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // InternalQVTrelation.g:4256:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // InternalQVTrelation.g:4257:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // InternalQVTrelation.g:4257:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // InternalQVTrelation.g:4258:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_ownedParts_2_0=ruleMapLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:4274:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==18) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalQVTrelation.g:4274:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:4278:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // InternalQVTrelation.g:4279:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // InternalQVTrelation.g:4279:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // InternalQVTrelation.g:4280:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_21);
                    	    lv_ownedParts_4_0=ruleMapLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
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


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralPartCS"
    // InternalQVTrelation.g:4308:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // InternalQVTrelation.g:4309:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // InternalQVTrelation.g:4310:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteralPartCS"


    // $ANTLR start "ruleMapLiteralPartCS"
    // InternalQVTrelation.g:4317:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4320:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // InternalQVTrelation.g:4321:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // InternalQVTrelation.g:4321:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // InternalQVTrelation.g:4321:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // InternalQVTrelation.g:4321:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // InternalQVTrelation.g:4322:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // InternalQVTrelation.g:4322:1: (lv_ownedKey_0_0= ruleExpCS )
            // InternalQVTrelation.g:4323:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_54);
            lv_ownedKey_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedKey",
                      		lv_ownedKey_0_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            // InternalQVTrelation.g:4343:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // InternalQVTrelation.g:4344:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // InternalQVTrelation.g:4344:1: (lv_ownedValue_2_0= ruleExpCS )
            // InternalQVTrelation.g:4345:3: lv_ownedValue_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedValue_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_2_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
    // $ANTLR end "ruleMapLiteralPartCS"


    // $ANTLR start "entryRulePrimitiveLiteralExpCS"
    // InternalQVTrelation.g:4369:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4370:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // InternalQVTrelation.g:4371:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4378:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
            // InternalQVTrelation.g:4381:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // InternalQVTrelation.g:4382:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // InternalQVTrelation.g:4382:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt78=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt78=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
                {
                alt78=2;
                }
                break;
            case 82:
            case 83:
                {
                alt78=3;
                }
                break;
            case 43:
                {
                alt78=4;
                }
                break;
            case 84:
                {
                alt78=5;
                }
                break;
            case 85:
                {
                alt78=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalQVTrelation.g:4383:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:4396:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:4409:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:4422:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:4435:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:4448:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQVTrelation.g:4467:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4468:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // InternalQVTrelation.g:4469:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4476:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
            // InternalQVTrelation.g:4479:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // InternalQVTrelation.g:4480:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // InternalQVTrelation.g:4480:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // InternalQVTrelation.g:4480:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,65,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTrelation.g:4488:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // InternalQVTrelation.g:4489:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // InternalQVTrelation.g:4489:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // InternalQVTrelation.g:4490:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_21);
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
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:4506:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==18) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalQVTrelation.g:4506:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalQVTrelation.g:4510:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // InternalQVTrelation.g:4511:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // InternalQVTrelation.g:4511:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // InternalQVTrelation.g:4512:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_21);
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
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
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

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:4540:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // InternalQVTrelation.g:4541:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // InternalQVTrelation.g:4542:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4549:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4552:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // InternalQVTrelation.g:4553:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // InternalQVTrelation.g:4553:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // InternalQVTrelation.g:4553:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // InternalQVTrelation.g:4553:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:4554:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:4554:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:4555:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_55);
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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:4571:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==16) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalQVTrelation.g:4571:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:4575:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:4576:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:4576:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:4577:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
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
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // InternalQVTrelation.g:4597:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // InternalQVTrelation.g:4598:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // InternalQVTrelation.g:4598:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // InternalQVTrelation.g:4599:3: lv_ownedInitExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedInitExpression_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_4_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
    // InternalQVTrelation.g:4623:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4624:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // InternalQVTrelation.g:4625:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4632:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4635:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // InternalQVTrelation.g:4636:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // InternalQVTrelation.g:4636:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // InternalQVTrelation.g:4637:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // InternalQVTrelation.g:4637:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // InternalQVTrelation.g:4638:3: lv_symbol_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_symbol_0_0=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"symbol",
                      		lv_symbol_0_0, 
                      		"org.eclipse.ocl.xtext.base.Base.NUMBER_LITERAL");
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
    // InternalQVTrelation.g:4662:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4663:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // InternalQVTrelation.g:4664:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4671:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4674:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // InternalQVTrelation.g:4675:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // InternalQVTrelation.g:4675:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt81=0;
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==RULE_SINGLE_QUOTED_STRING) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalQVTrelation.g:4676:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // InternalQVTrelation.g:4676:1: (lv_segments_0_0= ruleStringLiteral )
            	    // InternalQVTrelation.g:4677:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_56);
            	    lv_segments_0_0=ruleStringLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"segments",
            	              		lv_segments_0_0, 
            	              		"org.eclipse.ocl.xtext.base.Base.StringLiteral");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt81 >= 1 ) break loop81;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(81, input);
                        throw eee;
                }
                cnt81++;
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
    // InternalQVTrelation.g:4701:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4702:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // InternalQVTrelation.g:4703:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4710:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4713:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // InternalQVTrelation.g:4714:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // InternalQVTrelation.g:4714:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==82) ) {
                alt82=1;
            }
            else if ( (LA82_0==83) ) {
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
                    // InternalQVTrelation.g:4714:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // InternalQVTrelation.g:4714:2: ( (lv_symbol_0_0= 'true' ) )
                    // InternalQVTrelation.g:4715:1: (lv_symbol_0_0= 'true' )
                    {
                    // InternalQVTrelation.g:4715:1: (lv_symbol_0_0= 'true' )
                    // InternalQVTrelation.g:4716:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,82,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_0_0, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:4730:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // InternalQVTrelation.g:4730:6: ( (lv_symbol_1_0= 'false' ) )
                    // InternalQVTrelation.g:4731:1: (lv_symbol_1_0= 'false' )
                    {
                    // InternalQVTrelation.g:4731:1: (lv_symbol_1_0= 'false' )
                    // InternalQVTrelation.g:4732:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,83,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_1_0, "false");
                      	    
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
    // InternalQVTrelation.g:4753:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4754:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // InternalQVTrelation.g:4755:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4762:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4765:28: ( ( () otherlv_1= '*' ) )
            // InternalQVTrelation.g:4766:1: ( () otherlv_1= '*' )
            {
            // InternalQVTrelation.g:4766:1: ( () otherlv_1= '*' )
            // InternalQVTrelation.g:4766:2: () otherlv_1= '*'
            {
            // InternalQVTrelation.g:4766:2: ()
            // InternalQVTrelation.g:4767:2: 
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

            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:4787:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4788:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // InternalQVTrelation.g:4789:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4796:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4799:28: ( ( () otherlv_1= 'invalid' ) )
            // InternalQVTrelation.g:4800:1: ( () otherlv_1= 'invalid' )
            {
            // InternalQVTrelation.g:4800:1: ( () otherlv_1= 'invalid' )
            // InternalQVTrelation.g:4800:2: () otherlv_1= 'invalid'
            {
            // InternalQVTrelation.g:4800:2: ()
            // InternalQVTrelation.g:4801:2: 
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

            otherlv_1=(Token)match(input,84,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:4821:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4822:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // InternalQVTrelation.g:4823:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4830:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4833:28: ( ( () otherlv_1= 'null' ) )
            // InternalQVTrelation.g:4834:1: ( () otherlv_1= 'null' )
            {
            // InternalQVTrelation.g:4834:1: ( () otherlv_1= 'null' )
            // InternalQVTrelation.g:4834:2: () otherlv_1= 'null'
            {
            // InternalQVTrelation.g:4834:2: ()
            // InternalQVTrelation.g:4835:2: 
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

            otherlv_1=(Token)match(input,85,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:4855:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // InternalQVTrelation.g:4856:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // InternalQVTrelation.g:4857:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4864:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_MapTypeCS_2 = null;

        EObject this_TupleTypeCS_3 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4867:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) )
            // InternalQVTrelation.g:4868:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            {
            // InternalQVTrelation.g:4868:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
            int alt83=4;
            switch ( input.LA(1) ) {
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt83=1;
                }
                break;
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
                {
                alt83=2;
                }
                break;
            case 64:
                {
                alt83=3;
                }
                break;
            case 65:
                {
                alt83=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalQVTrelation.g:4869:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:4882:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:4895:2: this_MapTypeCS_2= ruleMapTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MapTypeCS_2=ruleMapTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MapTypeCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalQVTrelation.g:4908:2: this_TupleTypeCS_3= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TupleTypeCS_3=ruleTupleTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleTypeCS_3; 
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
    // InternalQVTrelation.g:4927:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // InternalQVTrelation.g:4928:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // InternalQVTrelation.g:4929:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4936:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4939:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTrelation.g:4940:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTrelation.g:4940:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            // InternalQVTrelation.g:4941:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_46);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalQVTrelation.g:4952:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==88) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalQVTrelation.g:4953:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    {
                    // InternalQVTrelation.g:4953:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    // InternalQVTrelation.g:4954:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_1_0, 
                              		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
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
    // InternalQVTrelation.g:4978:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // InternalQVTrelation.g:4979:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // InternalQVTrelation.g:4980:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:4987:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:4990:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // InternalQVTrelation.g:4991:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // InternalQVTrelation.g:4991:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // InternalQVTrelation.g:4992:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // InternalQVTrelation.g:4992:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // InternalQVTrelation.g:4993:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeLiteralWithMultiplicityCS");
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
    // InternalQVTrelation.g:5017:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // InternalQVTrelation.g:5018:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // InternalQVTrelation.g:5019:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5026:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedCurlyBracketedClause_1_0 = null;

        EObject lv_ownedPatternGuard_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5029:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) )
            // InternalQVTrelation.g:5030:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            {
            // InternalQVTrelation.g:5030:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            // InternalQVTrelation.g:5030:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            {
            // InternalQVTrelation.g:5030:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTrelation.g:5031:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTrelation.g:5031:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTrelation.g:5032:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_35);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_0_0, 
                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:5048:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==17) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalQVTrelation.g:5048:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    {
                    // InternalQVTrelation.g:5048:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
                    // InternalQVTrelation.g:5049:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    {
                    // InternalQVTrelation.g:5049:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    // InternalQVTrelation.g:5050:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_35);
                    lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_1_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:5066:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==17) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // InternalQVTrelation.g:5066:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                            {
                            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
                                  
                            }
                            // InternalQVTrelation.g:5070:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                            // InternalQVTrelation.g:5071:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            {
                            // InternalQVTrelation.g:5071:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            // InternalQVTrelation.g:5072:3: lv_ownedPatternGuard_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_11);
                            lv_ownedPatternGuard_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedPatternGuard",
                                      		lv_ownedPatternGuard_3_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
                                  
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
    // $ANTLR end "ruleTypeNameExpCS"


    // $ANTLR start "entryRuleTypeExpCS"
    // InternalQVTrelation.g:5100:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // InternalQVTrelation.g:5101:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // InternalQVTrelation.g:5102:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5109:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5112:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // InternalQVTrelation.g:5113:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // InternalQVTrelation.g:5113:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // InternalQVTrelation.g:5113:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // InternalQVTrelation.g:5113:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt87=3;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalQVTrelation.g:5114:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
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
                    // InternalQVTrelation.g:5127:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    this_TypeLiteralCS_1=ruleTypeLiteralCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalQVTrelation.g:5140:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    this_CollectionPatternCS_2=ruleCollectionPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionPatternCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // InternalQVTrelation.g:5151:2: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==88) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalQVTrelation.g:5152:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // InternalQVTrelation.g:5152:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // InternalQVTrelation.g:5153:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_3_0, 
                              		"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
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
    // InternalQVTrelation.g:5177:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // InternalQVTrelation.g:5178:2: (iv_ruleExpCS= ruleExpCS EOF )
            // InternalQVTrelation.g:5179:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5186:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5189:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // InternalQVTrelation.g:5190:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // InternalQVTrelation.g:5190:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt90=2;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // InternalQVTrelation.g:5190:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTrelation.g:5190:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // InternalQVTrelation.g:5191:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_57);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedPrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalQVTrelation.g:5202:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==21||LA89_0==43||LA89_0==47||(LA89_0>=49 && LA89_0<=63)) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalQVTrelation.g:5202:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // InternalQVTrelation.g:5202:2: ()
                            // InternalQVTrelation.g:5203:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalQVTrelation.g:5211:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // InternalQVTrelation.g:5212:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // InternalQVTrelation.g:5212:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // InternalQVTrelation.g:5213:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_13);
                            lv_name_2_0=ruleBinaryOperatorName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_2_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.BinaryOperatorName");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalQVTrelation.g:5229:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // InternalQVTrelation.g:5230:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // InternalQVTrelation.g:5230:1: (lv_ownedRight_3_0= ruleExpCS )
                            // InternalQVTrelation.g:5231:3: lv_ownedRight_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedRight_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedRight",
                                      		lv_ownedRight_3_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
                    // InternalQVTrelation.g:5249:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrefixedLetExpCS_4=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedLetExpCS_4; 
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


    // $ANTLR start "entryRulePrefixedLetExpCS"
    // InternalQVTrelation.g:5268:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // InternalQVTrelation.g:5269:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // InternalQVTrelation.g:5270:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedLetExpCS"


    // $ANTLR start "rulePrefixedLetExpCS"
    // InternalQVTrelation.g:5277:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5280:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // InternalQVTrelation.g:5281:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // InternalQVTrelation.g:5281:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( ((LA91_0>=47 && LA91_0<=48)) ) {
                alt91=1;
            }
            else if ( (LA91_0==97) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalQVTrelation.g:5281:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // InternalQVTrelation.g:5281:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // InternalQVTrelation.g:5281:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // InternalQVTrelation.g:5281:3: ()
                    // InternalQVTrelation.g:5282:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalQVTrelation.g:5290:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // InternalQVTrelation.g:5291:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // InternalQVTrelation.g:5291:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // InternalQVTrelation.g:5292:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:5308:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // InternalQVTrelation.g:5309:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // InternalQVTrelation.g:5309:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // InternalQVTrelation.g:5310:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedRight_2_0=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRight",
                              		lv_ownedRight_2_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedLetExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:5328:2: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // $ANTLR end "rulePrefixedLetExpCS"


    // $ANTLR start "entryRulePrefixedPrimaryExpCS"
    // InternalQVTrelation.g:5347:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // InternalQVTrelation.g:5348:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // InternalQVTrelation.g:5349:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedPrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedPrimaryExpCS"


    // $ANTLR start "rulePrefixedPrimaryExpCS"
    // InternalQVTrelation.g:5356:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5359:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // InternalQVTrelation.g:5360:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // InternalQVTrelation.g:5360:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=47 && LA92_0<=48)) ) {
                alt92=1;
            }
            else if ( ((LA92_0>=RULE_SIMPLE_ID && LA92_0<=RULE_SINGLE_QUOTED_STRING)||(LA92_0>=23 && LA92_0<=31)||(LA92_0>=33 && LA92_0<=38)||(LA92_0>=40 && LA92_0<=46)||(LA92_0>=64 && LA92_0<=78)||LA92_0==80||(LA92_0>=82 && LA92_0<=85)||LA92_0==92||LA92_0==98) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalQVTrelation.g:5360:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // InternalQVTrelation.g:5360:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // InternalQVTrelation.g:5360:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // InternalQVTrelation.g:5360:3: ()
                    // InternalQVTrelation.g:5361:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalQVTrelation.g:5369:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // InternalQVTrelation.g:5370:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // InternalQVTrelation.g:5370:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // InternalQVTrelation.g:5371:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_20);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:5387:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // InternalQVTrelation.g:5388:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // InternalQVTrelation.g:5388:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // InternalQVTrelation.g:5389:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedRight_2_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRight",
                              		lv_ownedRight_2_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedPrimaryExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:5407:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // $ANTLR end "rulePrefixedPrimaryExpCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // InternalQVTrelation.g:5426:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // InternalQVTrelation.g:5427:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // InternalQVTrelation.g:5428:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5435:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NestedExpCS_0 = null;

        EObject this_IfExpCS_1 = null;

        EObject this_SelfExpCS_2 = null;

        EObject this_PrimitiveLiteralExpCS_3 = null;

        EObject this_TupleLiteralExpCS_4 = null;

        EObject this_MapLiteralExpCS_5 = null;

        EObject this_CollectionLiteralExpCS_6 = null;

        EObject this_LambdaLiteralExpCS_7 = null;

        EObject this_TypeLiteralExpCS_8 = null;

        EObject this_NameExpCS_9 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5438:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
            // InternalQVTrelation.g:5439:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            {
            // InternalQVTrelation.g:5439:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
            int alt93=10;
            alt93 = dfa93.predict(input);
            switch (alt93) {
                case 1 :
                    // InternalQVTrelation.g:5440:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:5453:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:5466:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:5479:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:5492:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                    // InternalQVTrelation.g:5505:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MapLiteralExpCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalQVTrelation.g:5518:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionLiteralExpCS_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalQVTrelation.g:5531:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LambdaLiteralExpCS_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalQVTrelation.g:5544:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralExpCS_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalQVTrelation.g:5557:2: this_NameExpCS_9= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NameExpCS_9=ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameExpCS_9; 
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
    // InternalQVTrelation.g:5576:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // InternalQVTrelation.g:5577:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // InternalQVTrelation.g:5578:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5585:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_isPre_4_0=null;
        Token otherlv_5=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedSquareBracketedClauses_1_0 = null;

        EObject lv_ownedRoundBracketedClause_2_0 = null;

        EObject lv_ownedCurlyBracketedClause_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5588:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // InternalQVTrelation.g:5589:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // InternalQVTrelation.g:5589:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // InternalQVTrelation.g:5589:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // InternalQVTrelation.g:5589:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // InternalQVTrelation.g:5590:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // InternalQVTrelation.g:5590:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // InternalQVTrelation.g:5591:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_58);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_0_0, 
                      		"org.eclipse.ocl.xtext.base.Base.PathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:5607:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==88) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalQVTrelation.g:5608:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // InternalQVTrelation.g:5608:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // InternalQVTrelation.g:5609:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_58);
            	    lv_ownedSquareBracketedClauses_1_0=ruleSquareBracketedClauseCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSquareBracketedClauses",
            	              		lv_ownedSquareBracketedClauses_1_0, 
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.SquareBracketedClauseCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            // InternalQVTrelation.g:5625:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==31) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalQVTrelation.g:5626:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // InternalQVTrelation.g:5626:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // InternalQVTrelation.g:5627:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_59);
                    lv_ownedRoundBracketedClause_2_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_2_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:5643:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==17) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalQVTrelation.g:5644:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // InternalQVTrelation.g:5644:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // InternalQVTrelation.g:5645:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_60);
                    lv_ownedCurlyBracketedClause_3_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_3_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:5661:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==86) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalQVTrelation.g:5661:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // InternalQVTrelation.g:5661:4: ( (lv_isPre_4_0= '@' ) )
                    // InternalQVTrelation.g:5662:1: (lv_isPre_4_0= '@' )
                    {
                    // InternalQVTrelation.g:5662:1: (lv_isPre_4_0= '@' )
                    // InternalQVTrelation.g:5663:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,86,FollowSets000.FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isPre_4_0, grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "isPre", true, "@");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,87,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:5688:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // InternalQVTrelation.g:5689:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // InternalQVTrelation.g:5690:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5697:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) ;
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
            // InternalQVTrelation.g:5700:28: ( ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) )
            // InternalQVTrelation.g:5701:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            {
            // InternalQVTrelation.g:5701:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            // InternalQVTrelation.g:5701:2: () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}'
            {
            // InternalQVTrelation.g:5701:2: ()
            // InternalQVTrelation.g:5702:2: 
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

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalQVTrelation.g:5714:1: ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( ((LA100_0>=RULE_SIMPLE_ID && LA100_0<=RULE_ESCAPED_ID)||LA100_0==20||(LA100_0>=23 && LA100_0<=30)||(LA100_0>=33 && LA100_0<=38)||(LA100_0>=40 && LA100_0<=42)||(LA100_0>=44 && LA100_0<=46)) ) {
                alt100=1;
            }
            else if ( (LA100_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // InternalQVTrelation.g:5714:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    {
                    // InternalQVTrelation.g:5714:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( ((LA99_0>=RULE_SIMPLE_ID && LA99_0<=RULE_ESCAPED_ID)||(LA99_0>=23 && LA99_0<=30)||(LA99_0>=33 && LA99_0<=38)||(LA99_0>=40 && LA99_0<=42)||(LA99_0>=44 && LA99_0<=46)) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalQVTrelation.g:5714:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            {
                            // InternalQVTrelation.g:5714:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) )
                            // InternalQVTrelation.g:5715:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            {
                            // InternalQVTrelation.g:5715:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            // InternalQVTrelation.g:5716:3: lv_ownedParts_2_0= ruleShadowPartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_21);
                            lv_ownedParts_2_0=ruleShadowPartCS();

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
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalQVTrelation.g:5732:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            loop98:
                            do {
                                int alt98=2;
                                int LA98_0 = input.LA(1);

                                if ( (LA98_0==18) ) {
                                    alt98=1;
                                }


                                switch (alt98) {
                            	case 1 :
                            	    // InternalQVTrelation.g:5732:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_0_1_0());
                            	          
                            	    }
                            	    // InternalQVTrelation.g:5736:1: ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    // InternalQVTrelation.g:5737:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    {
                            	    // InternalQVTrelation.g:5737:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    // InternalQVTrelation.g:5738:3: lv_ownedParts_4_0= ruleShadowPartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_21);
                            	    lv_ownedParts_4_0=ruleShadowPartCS();

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
                            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop98;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:5755:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    {
                    // InternalQVTrelation.g:5755:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    // InternalQVTrelation.g:5756:1: (lv_value_5_0= ruleStringLiteral )
                    {
                    // InternalQVTrelation.g:5756:1: (lv_value_5_0= ruleStringLiteral )
                    // InternalQVTrelation.g:5757:3: lv_value_5_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
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
                              		"org.eclipse.ocl.xtext.base.Base.StringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:5785:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // InternalQVTrelation.g:5786:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // InternalQVTrelation.g:5787:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5794:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
    public final EObject ruleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_8=null;
        EObject lv_ownedArguments_2_0 = null;

        EObject lv_ownedArguments_3_0 = null;

        EObject lv_ownedArguments_4_0 = null;

        EObject lv_ownedArguments_5_0 = null;

        EObject lv_ownedArguments_6_0 = null;

        EObject lv_ownedArguments_7_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5797:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // InternalQVTrelation.g:5798:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // InternalQVTrelation.g:5798:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // InternalQVTrelation.g:5798:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // InternalQVTrelation.g:5798:2: ()
            // InternalQVTrelation.g:5799:2: 
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

            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalQVTrelation.g:5811:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( ((LA106_0>=RULE_SIMPLE_ID && LA106_0<=RULE_SINGLE_QUOTED_STRING)||LA106_0==16||(LA106_0>=23 && LA106_0<=31)||(LA106_0>=33 && LA106_0<=38)||(LA106_0>=40 && LA106_0<=48)||(LA106_0>=64 && LA106_0<=78)||LA106_0==80||(LA106_0>=82 && LA106_0<=85)||LA106_0==92||(LA106_0>=97 && LA106_0<=98)) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalQVTrelation.g:5811:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // InternalQVTrelation.g:5811:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // InternalQVTrelation.g:5812:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // InternalQVTrelation.g:5812:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // InternalQVTrelation.g:5813:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_64);
                    lv_ownedArguments_2_0=ruleNavigatingArgCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedArguments",
                              		lv_ownedArguments_2_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:5829:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==18) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // InternalQVTrelation.g:5830:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // InternalQVTrelation.g:5830:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // InternalQVTrelation.g:5831:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_64);
                    	    lv_ownedArguments_3_0=ruleNavigatingCommaArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_3_0, 
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop101;
                        }
                    } while (true);

                    // InternalQVTrelation.g:5847:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( (LA103_0==22) ) {
                        alt103=1;
                    }
                    switch (alt103) {
                        case 1 :
                            // InternalQVTrelation.g:5847:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // InternalQVTrelation.g:5847:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // InternalQVTrelation.g:5848:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // InternalQVTrelation.g:5848:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // InternalQVTrelation.g:5849:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_65);
                            lv_ownedArguments_4_0=ruleNavigatingSemiArgCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedArguments",
                                      		lv_ownedArguments_4_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingSemiArgCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalQVTrelation.g:5865:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop102:
                            do {
                                int alt102=2;
                                int LA102_0 = input.LA(1);

                                if ( (LA102_0==18) ) {
                                    alt102=1;
                                }


                                switch (alt102) {
                            	case 1 :
                            	    // InternalQVTrelation.g:5866:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // InternalQVTrelation.g:5866:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // InternalQVTrelation.g:5867:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_65);
                            	    lv_ownedArguments_5_0=ruleNavigatingCommaArgCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedArguments",
                            	              		lv_ownedArguments_5_0, 
                            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop102;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalQVTrelation.g:5883:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==91) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // InternalQVTrelation.g:5883:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // InternalQVTrelation.g:5883:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // InternalQVTrelation.g:5884:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // InternalQVTrelation.g:5884:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // InternalQVTrelation.g:5885:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_65);
                    	    lv_ownedArguments_6_0=ruleNavigatingBarArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_6_0, 
                    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingBarArgCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // InternalQVTrelation.g:5901:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop104:
                    	    do {
                    	        int alt104=2;
                    	        int LA104_0 = input.LA(1);

                    	        if ( (LA104_0==18) ) {
                    	            alt104=1;
                    	        }


                    	        switch (alt104) {
                    	    	case 1 :
                    	    	    // InternalQVTrelation.g:5902:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // InternalQVTrelation.g:5902:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // InternalQVTrelation.g:5903:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_65);
                    	    	    lv_ownedArguments_7_0=ruleNavigatingCommaArgCS();

                    	    	    state._fsp--;
                    	    	    if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {

                    	    	      	        if (current==null) {
                    	    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	    	      	        }
                    	    	             		add(
                    	    	             			current, 
                    	    	             			"ownedArguments",
                    	    	              		lv_ownedArguments_7_0, 
                    	    	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
                    	    	      	        afterParserOrEnumRuleCall();
                    	    	      	    
                    	    	    }

                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop104;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop105;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:5931:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // InternalQVTrelation.g:5932:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // InternalQVTrelation.g:5933:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:5940:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:5943:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // InternalQVTrelation.g:5944:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // InternalQVTrelation.g:5944:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // InternalQVTrelation.g:5944:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,88,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalQVTrelation.g:5948:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // InternalQVTrelation.g:5949:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // InternalQVTrelation.g:5949:1: (lv_ownedTerms_1_0= ruleExpCS )
            // InternalQVTrelation.g:5950:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_66);
            lv_ownedTerms_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedTerms",
                      		lv_ownedTerms_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:5966:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==18) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalQVTrelation.g:5966:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalQVTrelation.g:5970:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // InternalQVTrelation.g:5971:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // InternalQVTrelation.g:5971:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // InternalQVTrelation.g:5972:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_66);
            	    lv_ownedTerms_3_0=ruleExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedTerms",
            	              		lv_ownedTerms_3_0, 
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);

            otherlv_4=(Token)match(input,89,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:6000:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // InternalQVTrelation.g:6001:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // InternalQVTrelation.g:6002:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6009:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedNameExpression_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;

        EObject lv_ownedInitExpression_6_0 = null;

        EObject lv_ownedType_8_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6012:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) )
            // InternalQVTrelation.g:6013:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            {
            // InternalQVTrelation.g:6013:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( ((LA110_0>=RULE_SIMPLE_ID && LA110_0<=RULE_SINGLE_QUOTED_STRING)||(LA110_0>=23 && LA110_0<=31)||(LA110_0>=33 && LA110_0<=38)||(LA110_0>=40 && LA110_0<=48)||(LA110_0>=64 && LA110_0<=78)||LA110_0==80||(LA110_0>=82 && LA110_0<=85)||LA110_0==92||(LA110_0>=97 && LA110_0<=98)) ) {
                alt110=1;
            }
            else if ( (LA110_0==16) ) {
                alt110=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    // InternalQVTrelation.g:6013:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // InternalQVTrelation.g:6013:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // InternalQVTrelation.g:6013:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // InternalQVTrelation.g:6013:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // InternalQVTrelation.g:6014:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // InternalQVTrelation.g:6014:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // InternalQVTrelation.g:6015:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_67);
                    lv_ownedNameExpression_0_0=ruleNavigatingArgExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedNameExpression",
                              		lv_ownedNameExpression_0_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:6031:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt109=3;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==16) ) {
                        alt109=1;
                    }
                    else if ( (LA109_0==90) ) {
                        alt109=2;
                    }
                    switch (alt109) {
                        case 1 :
                            // InternalQVTrelation.g:6031:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // InternalQVTrelation.g:6031:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // InternalQVTrelation.g:6031:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
                                  
                            }
                            // InternalQVTrelation.g:6035:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                            // InternalQVTrelation.g:6036:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            {
                            // InternalQVTrelation.g:6036:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            // InternalQVTrelation.g:6037:3: lv_ownedType_2_0= ruleTypeExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_68);
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
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalQVTrelation.g:6053:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt108=2;
                            int LA108_0 = input.LA(1);

                            if ( (LA108_0==21) ) {
                                alt108=1;
                            }
                            switch (alt108) {
                                case 1 :
                                    // InternalQVTrelation.g:6053:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
                                          
                                    }
                                    // InternalQVTrelation.g:6057:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // InternalQVTrelation.g:6058:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // InternalQVTrelation.g:6058:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // InternalQVTrelation.g:6059:3: lv_ownedInitExpression_4_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_2);
                                    lv_ownedInitExpression_4_0=ruleExpCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"ownedInitExpression",
                                              		lv_ownedInitExpression_4_0, 
                                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
                            // InternalQVTrelation.g:6076:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // InternalQVTrelation.g:6076:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // InternalQVTrelation.g:6076:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,90,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
                                  
                            }
                            // InternalQVTrelation.g:6080:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // InternalQVTrelation.g:6081:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // InternalQVTrelation.g:6081:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // InternalQVTrelation.g:6082:3: lv_ownedInitExpression_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_6_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_6_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

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
                    // InternalQVTrelation.g:6099:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    {
                    // InternalQVTrelation.g:6099:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    // InternalQVTrelation.g:6099:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    {
                    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:6103:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:6104:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:6104:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:6105:3: lv_ownedType_8_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedType_8_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_8_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
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
    // $ANTLR end "ruleNavigatingArgCS"


    // $ANTLR start "entryRuleNavigatingBarArgCS"
    // InternalQVTrelation.g:6129:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // InternalQVTrelation.g:6130:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // InternalQVTrelation.g:6131:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6138:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6141:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // InternalQVTrelation.g:6142:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // InternalQVTrelation.g:6142:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // InternalQVTrelation.g:6142:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // InternalQVTrelation.g:6142:2: ( (lv_prefix_0_0= '|' ) )
            // InternalQVTrelation.g:6143:1: (lv_prefix_0_0= '|' )
            {
            // InternalQVTrelation.g:6143:1: (lv_prefix_0_0= '|' )
            // InternalQVTrelation.g:6144:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,91,FollowSets000.FOLLOW_13); if (state.failed) return current;
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

            // InternalQVTrelation.g:6157:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTrelation.g:6158:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTrelation.g:6158:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTrelation.g:6159:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_69);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:6175:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==16) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalQVTrelation.g:6175:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalQVTrelation.g:6179:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:6180:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:6180:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:6181:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:6197:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==21) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalQVTrelation.g:6197:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // InternalQVTrelation.g:6201:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTrelation.g:6202:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTrelation.g:6202:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTrelation.g:6203:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
    // InternalQVTrelation.g:6227:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // InternalQVTrelation.g:6228:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // InternalQVTrelation.g:6229:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6236:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
    public final EObject ruleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;

        EObject lv_ownedInitExpression_7_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6239:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // InternalQVTrelation.g:6240:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // InternalQVTrelation.g:6240:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // InternalQVTrelation.g:6240:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // InternalQVTrelation.g:6240:2: ( (lv_prefix_0_0= ',' ) )
            // InternalQVTrelation.g:6241:1: (lv_prefix_0_0= ',' )
            {
            // InternalQVTrelation.g:6241:1: (lv_prefix_0_0= ',' )
            // InternalQVTrelation.g:6242:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,18,FollowSets000.FOLLOW_13); if (state.failed) return current;
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

            // InternalQVTrelation.g:6255:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTrelation.g:6256:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTrelation.g:6256:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTrelation.g:6257:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_67);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:6273:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt114=3;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==16) ) {
                alt114=1;
            }
            else if ( (LA114_0==90) ) {
                alt114=2;
            }
            switch (alt114) {
                case 1 :
                    // InternalQVTrelation.g:6273:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // InternalQVTrelation.g:6273:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // InternalQVTrelation.g:6273:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
                          
                    }
                    // InternalQVTrelation.g:6277:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:6278:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:6278:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:6279:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:6295:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==21) ) {
                        alt113=1;
                    }
                    switch (alt113) {
                        case 1 :
                            // InternalQVTrelation.g:6295:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
                                  
                            }
                            // InternalQVTrelation.g:6299:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTrelation.g:6300:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTrelation.g:6300:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTrelation.g:6301:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
                    // InternalQVTrelation.g:6318:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // InternalQVTrelation.g:6318:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // InternalQVTrelation.g:6318:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,90,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
                          
                    }
                    // InternalQVTrelation.g:6322:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // InternalQVTrelation.g:6323:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // InternalQVTrelation.g:6323:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // InternalQVTrelation.g:6324:3: lv_ownedInitExpression_7_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedInitExpression_7_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_7_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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
    // InternalQVTrelation.g:6348:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // InternalQVTrelation.g:6349:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // InternalQVTrelation.g:6350:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6357:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6360:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // InternalQVTrelation.g:6361:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // InternalQVTrelation.g:6361:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // InternalQVTrelation.g:6361:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // InternalQVTrelation.g:6361:2: ( (lv_prefix_0_0= ';' ) )
            // InternalQVTrelation.g:6362:1: (lv_prefix_0_0= ';' )
            {
            // InternalQVTrelation.g:6362:1: (lv_prefix_0_0= ';' )
            // InternalQVTrelation.g:6363:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,22,FollowSets000.FOLLOW_13); if (state.failed) return current;
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

            // InternalQVTrelation.g:6376:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // InternalQVTrelation.g:6377:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // InternalQVTrelation.g:6377:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // InternalQVTrelation.g:6378:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_69);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:6394:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==16) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalQVTrelation.g:6394:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalQVTrelation.g:6398:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:6399:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:6399:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:6400:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:6416:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==21) ) {
                        alt115=1;
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalQVTrelation.g:6416:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // InternalQVTrelation.g:6420:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // InternalQVTrelation.g:6421:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // InternalQVTrelation.g:6421:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // InternalQVTrelation.g:6422:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
    // InternalQVTrelation.g:6446:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // InternalQVTrelation.g:6447:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // InternalQVTrelation.g:6448:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6455:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6458:28: (this_ExpCS_0= ruleExpCS )
            // InternalQVTrelation.g:6460:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQVTrelation.g:6479:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // InternalQVTrelation.g:6480:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // InternalQVTrelation.g:6481:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6488:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedCondition_1_1 = null;

        EObject lv_ownedCondition_1_2 = null;

        EObject lv_ownedThenExpression_3_0 = null;

        EObject lv_ownedIfThenExpressions_4_0 = null;

        EObject lv_ownedElseExpression_6_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6491:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // InternalQVTrelation.g:6492:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // InternalQVTrelation.g:6492:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // InternalQVTrelation.g:6492:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,92,FollowSets000.FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // InternalQVTrelation.g:6496:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // InternalQVTrelation.g:6497:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // InternalQVTrelation.g:6497:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // InternalQVTrelation.g:6498:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // InternalQVTrelation.g:6498:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt117=2;
            alt117 = dfa117.predict(input);
            switch (alt117) {
                case 1 :
                    // InternalQVTrelation.g:6499:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_70);
                    lv_ownedCondition_1_1=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCondition",
                              		lv_ownedCondition_1_1, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:6514:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_70);
                    lv_ownedCondition_1_2=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCondition",
                              		lv_ownedCondition_1_2, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_2=(Token)match(input,93,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // InternalQVTrelation.g:6536:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // InternalQVTrelation.g:6537:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // InternalQVTrelation.g:6537:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // InternalQVTrelation.g:6538:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_71);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:6554:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==96) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // InternalQVTrelation.g:6555:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // InternalQVTrelation.g:6555:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // InternalQVTrelation.g:6556:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_71);
            	    lv_ownedIfThenExpressions_4_0=ruleElseIfThenExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedIfThenExpressions",
            	              		lv_ownedIfThenExpressions_4_0, 
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ElseIfThenExpCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);

            otherlv_5=(Token)match(input,94,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
                  
            }
            // InternalQVTrelation.g:6576:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // InternalQVTrelation.g:6577:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // InternalQVTrelation.g:6577:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // InternalQVTrelation.g:6578:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_72);
            lv_ownedElseExpression_6_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedElseExpression",
                      		lv_ownedElseExpression_6_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,95,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getIfExpCSAccess().getEndifKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleElseIfThenExpCS"
    // InternalQVTrelation.g:6606:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // InternalQVTrelation.g:6607:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // InternalQVTrelation.g:6608:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfThenExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseIfThenExpCS"


    // $ANTLR start "ruleElseIfThenExpCS"
    // InternalQVTrelation.g:6615:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6618:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // InternalQVTrelation.g:6619:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // InternalQVTrelation.g:6619:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // InternalQVTrelation.g:6619:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,96,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
                  
            }
            // InternalQVTrelation.g:6623:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // InternalQVTrelation.g:6624:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // InternalQVTrelation.g:6624:1: (lv_ownedCondition_1_0= ruleExpCS )
            // InternalQVTrelation.g:6625:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_70);
            lv_ownedCondition_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedCondition",
                      		lv_ownedCondition_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,93,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
                  
            }
            // InternalQVTrelation.g:6645:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // InternalQVTrelation.g:6646:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // InternalQVTrelation.g:6646:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // InternalQVTrelation.g:6647:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
    // $ANTLR end "ruleElseIfThenExpCS"


    // $ANTLR start "entryRuleLetExpCS"
    // InternalQVTrelation.g:6671:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // InternalQVTrelation.g:6672:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // InternalQVTrelation.g:6673:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6680:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedVariables_1_0 = null;

        EObject lv_ownedVariables_3_0 = null;

        EObject lv_ownedInExpression_5_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6683:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // InternalQVTrelation.g:6684:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // InternalQVTrelation.g:6684:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // InternalQVTrelation.g:6684:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,97,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // InternalQVTrelation.g:6688:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // InternalQVTrelation.g:6689:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // InternalQVTrelation.g:6689:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // InternalQVTrelation.g:6690:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_73);
            lv_ownedVariables_1_0=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedVariables",
                      		lv_ownedVariables_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:6706:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==18) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // InternalQVTrelation.g:6706:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalQVTrelation.g:6710:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // InternalQVTrelation.g:6711:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // InternalQVTrelation.g:6711:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // InternalQVTrelation.g:6712:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_73);
            	    lv_ownedVariables_3_0=ruleLetVariableCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedVariables",
            	              		lv_ownedVariables_3_0, 
            	              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);

            otherlv_4=(Token)match(input,90,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // InternalQVTrelation.g:6732:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // InternalQVTrelation.g:6733:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // InternalQVTrelation.g:6733:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // InternalQVTrelation.g:6734:3: lv_ownedInExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedInExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInExpression",
                      		lv_ownedInExpression_5_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
    // InternalQVTrelation.g:6758:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // InternalQVTrelation.g:6759:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // InternalQVTrelation.g:6760:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6767:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedRoundBracketedClause_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6770:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // InternalQVTrelation.g:6771:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // InternalQVTrelation.g:6771:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // InternalQVTrelation.g:6771:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // InternalQVTrelation.g:6771:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:6772:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:6772:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:6773:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_74);
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
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:6789:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==31) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalQVTrelation.g:6790:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // InternalQVTrelation.g:6790:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // InternalQVTrelation.g:6791:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_55);
                    lv_ownedRoundBracketedClause_1_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_1_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalQVTrelation.g:6807:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==16) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalQVTrelation.g:6807:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
                          
                    }
                    // InternalQVTrelation.g:6811:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // InternalQVTrelation.g:6812:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // InternalQVTrelation.g:6812:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // InternalQVTrelation.g:6813:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalQVTrelation.g:6833:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // InternalQVTrelation.g:6834:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // InternalQVTrelation.g:6834:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // InternalQVTrelation.g:6835:3: lv_ownedInitExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedInitExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_5_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
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
    // InternalQVTrelation.g:6859:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // InternalQVTrelation.g:6860:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // InternalQVTrelation.g:6861:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6868:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6871:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // InternalQVTrelation.g:6872:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // InternalQVTrelation.g:6872:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // InternalQVTrelation.g:6872:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // InternalQVTrelation.g:6876:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // InternalQVTrelation.g:6877:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // InternalQVTrelation.g:6877:1: (lv_ownedExpression_1_0= ruleExpCS )
            // InternalQVTrelation.g:6878:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_23);
            lv_ownedExpression_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpression",
                      		lv_ownedExpression_1_0, 
                      		"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalQVTrelation.g:6906:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // InternalQVTrelation.g:6907:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // InternalQVTrelation.g:6908:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6915:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6918:28: ( ( () otherlv_1= 'self' ) )
            // InternalQVTrelation.g:6919:1: ( () otherlv_1= 'self' )
            {
            // InternalQVTrelation.g:6919:1: ( () otherlv_1= 'self' )
            // InternalQVTrelation.g:6919:2: () otherlv_1= 'self'
            {
            // InternalQVTrelation.g:6919:2: ()
            // InternalQVTrelation.g:6920:2: 
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

            otherlv_1=(Token)match(input,98,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // InternalQVTrelation.g:6940:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // InternalQVTrelation.g:6941:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // InternalQVTrelation.g:6942:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:6949:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:6952:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // InternalQVTrelation.g:6953:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // InternalQVTrelation.g:6953:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // InternalQVTrelation.g:6953:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // InternalQVTrelation.g:6953:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // InternalQVTrelation.g:6954:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // InternalQVTrelation.g:6954:1: (lv_lowerBound_0_0= ruleLOWER )
            // InternalQVTrelation.g:6955:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_52);
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
                      		"org.eclipse.ocl.xtext.base.Base.LOWER");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:6971:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==79) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalQVTrelation.g:6971:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,79,FollowSets000.FOLLOW_75); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:6975:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // InternalQVTrelation.g:6976:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // InternalQVTrelation.g:6976:1: (lv_upperBound_2_0= ruleUPPER )
                    // InternalQVTrelation.g:6977:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                              		"org.eclipse.ocl.xtext.base.Base.UPPER");
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
    // InternalQVTrelation.g:7001:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // InternalQVTrelation.g:7002:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // InternalQVTrelation.g:7003:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7010:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_isNullFree_4_0=null;
        Token otherlv_5=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7013:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // InternalQVTrelation.g:7014:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // InternalQVTrelation.g:7014:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // InternalQVTrelation.g:7014:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,88,FollowSets000.FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalQVTrelation.g:7018:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==RULE_INT) ) {
                alt123=1;
            }
            else if ( (LA123_0==43||LA123_0==50||LA123_0==101) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalQVTrelation.g:7019:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_77);
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
                    // InternalQVTrelation.g:7032:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_77);
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

            // InternalQVTrelation.g:7043:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt124=3;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==99) ) {
                alt124=1;
            }
            else if ( (LA124_0==100) ) {
                alt124=2;
            }
            switch (alt124) {
                case 1 :
                    // InternalQVTrelation.g:7043:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,99,FollowSets000.FOLLOW_78); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:7048:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // InternalQVTrelation.g:7048:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // InternalQVTrelation.g:7049:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // InternalQVTrelation.g:7049:1: (lv_isNullFree_4_0= '|1' )
                    // InternalQVTrelation.g:7050:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,100,FollowSets000.FOLLOW_78); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isNullFree_4_0, grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      	        }
                             		setWithLastConsumed(current, "isNullFree", true, "|1");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,89,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // InternalQVTrelation.g:7075:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // InternalQVTrelation.g:7076:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // InternalQVTrelation.g:7077:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7084:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7087:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // InternalQVTrelation.g:7088:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // InternalQVTrelation.g:7088:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // InternalQVTrelation.g:7089:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // InternalQVTrelation.g:7089:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // InternalQVTrelation.g:7090:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // InternalQVTrelation.g:7090:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt125=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt125=1;
                }
                break;
            case 50:
                {
                alt125=2;
                }
                break;
            case 101:
                {
                alt125=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // InternalQVTrelation.g:7091:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalQVTrelation.g:7103:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,50,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalQVTrelation.g:7115:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,101,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRulePathNameCS"
    // InternalQVTrelation.g:7138:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // InternalQVTrelation.g:7139:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // InternalQVTrelation.g:7140:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7147:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7150:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // InternalQVTrelation.g:7151:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // InternalQVTrelation.g:7151:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // InternalQVTrelation.g:7151:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // InternalQVTrelation.g:7151:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // InternalQVTrelation.g:7152:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // InternalQVTrelation.g:7152:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // InternalQVTrelation.g:7153:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_47);
            lv_ownedPathElements_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPathElements",
                      		lv_ownedPathElements_0_0, 
                      		"org.eclipse.ocl.xtext.base.Base.FirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:7169:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==39) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // InternalQVTrelation.g:7169:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_48); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // InternalQVTrelation.g:7173:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // InternalQVTrelation.g:7174:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // InternalQVTrelation.g:7174:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // InternalQVTrelation.g:7175:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_47);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPathElements",
            	              		lv_ownedPathElements_2_0, 
            	              		"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop126;
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
    // InternalQVTrelation.g:7199:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // InternalQVTrelation.g:7200:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // InternalQVTrelation.g:7201:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7208:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7211:28: ( ( ( ruleUnrestrictedName ) ) )
            // InternalQVTrelation.g:7212:1: ( ( ruleUnrestrictedName ) )
            {
            // InternalQVTrelation.g:7212:1: ( ( ruleUnrestrictedName ) )
            // InternalQVTrelation.g:7213:1: ( ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:7213:1: ( ruleUnrestrictedName )
            // InternalQVTrelation.g:7214:3: ruleUnrestrictedName
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
               
              	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalQVTrelation.g:7238:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // InternalQVTrelation.g:7239:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // InternalQVTrelation.g:7240:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7247:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7250:28: ( ( ( ruleUnreservedName ) ) )
            // InternalQVTrelation.g:7251:1: ( ( ruleUnreservedName ) )
            {
            // InternalQVTrelation.g:7251:1: ( ( ruleUnreservedName ) )
            // InternalQVTrelation.g:7252:1: ( ruleUnreservedName )
            {
            // InternalQVTrelation.g:7252:1: ( ruleUnreservedName )
            // InternalQVTrelation.g:7253:3: ruleUnreservedName
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
               
              	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
    // InternalQVTrelation.g:7279:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // InternalQVTrelation.g:7280:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // InternalQVTrelation.g:7281:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateParameterSubstitutionCS"


    // $ANTLR start "ruleTemplateParameterSubstitutionCS"
    // InternalQVTrelation.g:7288:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7291:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // InternalQVTrelation.g:7292:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // InternalQVTrelation.g:7292:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // InternalQVTrelation.g:7293:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // InternalQVTrelation.g:7293:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // InternalQVTrelation.g:7294:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedActualParameter_0_0=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateParameterSubstitutionCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedActualParameter",
                      		lv_ownedActualParameter_0_0, 
                      		"org.eclipse.ocl.xtext.base.Base.TypeRefCS");
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
    // $ANTLR end "ruleTemplateParameterSubstitutionCS"


    // $ANTLR start "entryRuleTypeParameterCS"
    // InternalQVTrelation.g:7320:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // InternalQVTrelation.g:7321:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // InternalQVTrelation.g:7322:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeParameterCS"


    // $ANTLR start "ruleTypeParameterCS"
    // InternalQVTrelation.g:7329:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7332:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) )
            // InternalQVTrelation.g:7333:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            {
            // InternalQVTrelation.g:7333:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            // InternalQVTrelation.g:7333:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            {
            // InternalQVTrelation.g:7333:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // InternalQVTrelation.g:7334:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // InternalQVTrelation.g:7334:1: (lv_name_0_0= ruleUnrestrictedName )
            // InternalQVTrelation.g:7335:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_79);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalQVTrelation.g:7351:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==41) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalQVTrelation.g:7351:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // InternalQVTrelation.g:7355:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // InternalQVTrelation.g:7356:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // InternalQVTrelation.g:7356:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // InternalQVTrelation.g:7357:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_80);
                    lv_ownedExtends_2_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedExtends",
                              		lv_ownedExtends_2_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalQVTrelation.g:7373:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==102) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // InternalQVTrelation.g:7373:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,102,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // InternalQVTrelation.g:7377:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // InternalQVTrelation.g:7378:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // InternalQVTrelation.g:7378:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // InternalQVTrelation.g:7379:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_80);
                    	    lv_ownedExtends_4_0=ruleTypedRefCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedExtends",
                    	              		lv_ownedExtends_4_0, 
                    	              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop127;
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
    // $ANTLR end "ruleTypeParameterCS"


    // $ANTLR start "entryRuleTypeRefCS"
    // InternalQVTrelation.g:7403:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // InternalQVTrelation.g:7404:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // InternalQVTrelation.g:7405:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRefCS"


    // $ANTLR start "ruleTypeRefCS"
    // InternalQVTrelation.g:7412:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7415:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // InternalQVTrelation.g:7416:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // InternalQVTrelation.g:7416:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( ((LA129_0>=RULE_SIMPLE_ID && LA129_0<=RULE_ESCAPED_ID)||(LA129_0>=23 && LA129_0<=30)||(LA129_0>=33 && LA129_0<=38)||(LA129_0>=40 && LA129_0<=42)||(LA129_0>=44 && LA129_0<=46)||(LA129_0>=66 && LA129_0<=78)) ) {
                alt129=1;
            }
            else if ( (LA129_0==101) ) {
                alt129=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }
            switch (alt129) {
                case 1 :
                    // InternalQVTrelation.g:7417:2: this_TypedRefCS_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypedRefCS_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypedRefCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:7430:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WildcardTypeRefCS_1=ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WildcardTypeRefCS_1; 
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
    // $ANTLR end "ruleTypeRefCS"


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // InternalQVTrelation.g:7449:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // InternalQVTrelation.g:7450:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // InternalQVTrelation.g:7451:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcardTypeRefCS"


    // $ANTLR start "ruleWildcardTypeRefCS"
    // InternalQVTrelation.g:7458:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7461:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) )
            // InternalQVTrelation.g:7462:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            {
            // InternalQVTrelation.g:7462:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            // InternalQVTrelation.g:7462:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            {
            // InternalQVTrelation.g:7462:2: ()
            // InternalQVTrelation.g:7463:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,101,FollowSets000.FOLLOW_79); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // InternalQVTrelation.g:7475:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==41) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalQVTrelation.g:7475:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // InternalQVTrelation.g:7479:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // InternalQVTrelation.g:7480:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // InternalQVTrelation.g:7480:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // InternalQVTrelation.g:7481:3: lv_ownedExtends_3_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ownedExtends_3_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExtends",
                              		lv_ownedExtends_3_0, 
                              		"org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
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
    // $ANTLR end "ruleWildcardTypeRefCS"


    // $ANTLR start "entryRuleID"
    // InternalQVTrelation.g:7505:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // InternalQVTrelation.g:7506:2: (iv_ruleID= ruleID EOF )
            // InternalQVTrelation.g:7507:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7514:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7517:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalQVTrelation.g:7518:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalQVTrelation.g:7518:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==RULE_SIMPLE_ID) ) {
                alt131=1;
            }
            else if ( (LA131_0==RULE_ESCAPED_ID) ) {
                alt131=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // InternalQVTrelation.g:7518:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:7526:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleIdentifier"
    // InternalQVTrelation.g:7541:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalQVTrelation.g:7542:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalQVTrelation.g:7543:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7550:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7553:28: (this_ID_0= ruleID )
            // InternalQVTrelation.g:7555:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
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


    // $ANTLR start "entryRuleLOWER"
    // InternalQVTrelation.g:7573:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // InternalQVTrelation.g:7574:2: (iv_ruleLOWER= ruleLOWER EOF )
            // InternalQVTrelation.g:7575:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7582:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7585:28: (this_INT_0= RULE_INT )
            // InternalQVTrelation.g:7586:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // InternalQVTrelation.g:7601:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // InternalQVTrelation.g:7602:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // InternalQVTrelation.g:7603:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7610:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7613:28: (this_INT_0= RULE_INT )
            // InternalQVTrelation.g:7614:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleStringLiteral"
    // InternalQVTrelation.g:7629:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // InternalQVTrelation.g:7630:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalQVTrelation.g:7631:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7638:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7641:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // InternalQVTrelation.g:7642:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleUPPER"
    // InternalQVTrelation.g:7657:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // InternalQVTrelation.g:7658:2: (iv_ruleUPPER= ruleUPPER EOF )
            // InternalQVTrelation.g:7659:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7666:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7669:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // InternalQVTrelation.g:7670:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // InternalQVTrelation.g:7670:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==RULE_INT) ) {
                alt132=1;
            }
            else if ( (LA132_0==43) ) {
                alt132=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    // InternalQVTrelation.g:7670:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalQVTrelation.g:7679:2: kw= '*'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleURI"
    // InternalQVTrelation.g:7692:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // InternalQVTrelation.g:7693:2: (iv_ruleURI= ruleURI EOF )
            // InternalQVTrelation.g:7694:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalQVTrelation.g:7701:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalQVTrelation.g:7704:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // InternalQVTrelation.g:7705:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred36_InternalQVTrelation
    public final void synpred36_InternalQVTrelation_fragment() throws RecognitionException {   
        EObject this_CollectionTemplateCS_0 = null;


        // InternalQVTrelation.g:1684:2: (this_CollectionTemplateCS_0= ruleCollectionTemplateCS )
        // InternalQVTrelation.g:1684:2: this_CollectionTemplateCS_0= ruleCollectionTemplateCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_CollectionTemplateCS_0=ruleCollectionTemplateCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalQVTrelation

    // $ANTLR start synpred144_InternalQVTrelation
    public final void synpred144_InternalQVTrelation_fragment() throws RecognitionException {   
        EObject this_TypeLiteralCS_1 = null;


        // InternalQVTrelation.g:5127:2: (this_TypeLiteralCS_1= ruleTypeLiteralCS )
        // InternalQVTrelation.g:5127:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TypeLiteralCS_1=ruleTypeLiteralCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred144_InternalQVTrelation

    // $ANTLR start synpred147_InternalQVTrelation
    public final void synpred147_InternalQVTrelation_fragment() throws RecognitionException {   
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // InternalQVTrelation.g:5190:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // InternalQVTrelation.g:5190:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // InternalQVTrelation.g:5190:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // InternalQVTrelation.g:5191:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_57);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // InternalQVTrelation.g:5202:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt152=2;
        int LA152_0 = input.LA(1);

        if ( (LA152_0==21||LA152_0==43||LA152_0==47||(LA152_0>=49 && LA152_0<=63)) ) {
            alt152=1;
        }
        switch (alt152) {
            case 1 :
                // InternalQVTrelation.g:5202:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // InternalQVTrelation.g:5202:2: ()
                // InternalQVTrelation.g:5203:2: 
                {
                if ( state.backtracking==0 ) {
                   
                  	  /* */ 
                  	
                }

                }

                // InternalQVTrelation.g:5211:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // InternalQVTrelation.g:5212:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // InternalQVTrelation.g:5212:1: (lv_name_2_0= ruleBinaryOperatorName )
                // InternalQVTrelation.g:5213:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_13);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalQVTrelation.g:5229:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // InternalQVTrelation.g:5230:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // InternalQVTrelation.g:5230:1: (lv_ownedRight_3_0= ruleExpCS )
                // InternalQVTrelation.g:5231:3: lv_ownedRight_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_ownedRight_3_0=ruleExpCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred147_InternalQVTrelation

    // $ANTLR start synpred154_InternalQVTrelation
    public final void synpred154_InternalQVTrelation_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // InternalQVTrelation.g:5492:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // InternalQVTrelation.g:5492:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred154_InternalQVTrelation

    // $ANTLR start synpred155_InternalQVTrelation
    public final void synpred155_InternalQVTrelation_fragment() throws RecognitionException {   
        EObject this_MapLiteralExpCS_5 = null;


        // InternalQVTrelation.g:5505:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // InternalQVTrelation.g:5505:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_InternalQVTrelation

    // $ANTLR start synpred156_InternalQVTrelation
    public final void synpred156_InternalQVTrelation_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_6 = null;


        // InternalQVTrelation.g:5518:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // InternalQVTrelation.g:5518:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred156_InternalQVTrelation

    // $ANTLR start synpred158_InternalQVTrelation
    public final void synpred158_InternalQVTrelation_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_8 = null;


        // InternalQVTrelation.g:5544:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
        // InternalQVTrelation.g:5544:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred158_InternalQVTrelation

    // Delegated rules

    public final boolean synpred154_InternalQVTrelation() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred154_InternalQVTrelation_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred156_InternalQVTrelation() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred156_InternalQVTrelation_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred144_InternalQVTrelation() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred144_InternalQVTrelation_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred158_InternalQVTrelation() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred158_InternalQVTrelation_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred155_InternalQVTrelation() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred155_InternalQVTrelation_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalQVTrelation() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalQVTrelation_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred147_InternalQVTrelation() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred147_InternalQVTrelation_fragment(); // can never throw exception
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
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA117 dfa117 = new DFA117(this);
    static final String dfa_1s = "\31\uffff";
    static final String dfa_2s = "\1\4\26\20\2\uffff";
    static final String dfa_3s = "\1\56\26\23\2\uffff";
    static final String dfa_4s = "\27\uffff\1\1\1\2";
    static final String dfa_5s = "\31\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\2\12\uffff\1\27\6\uffff\1\3\1\7\1\22\1\6\1\11\1\5\1\14\1\15\2\uffff\1\17\1\20\1\23\1\4\1\21\1\16\1\uffff\1\24\1\10\1\12\1\uffff\1\25\1\26\1\13",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "\1\27\1\uffff\2\30",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "196:1: (lv_ownedMemberIdentifiers_4_1= ruleTemplateCS | lv_ownedMemberIdentifiers_4_2= ruleElementTemplateCS )";
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "236:1: (lv_ownedMemberIdentifiers_6_1= ruleTemplateCS | lv_ownedMemberIdentifiers_6_2= ruleElementTemplateCS )";
        }
    }
    static final String dfa_7s = "\1\1\30\uffff";
    static final String dfa_8s = "\1\4\1\uffff\26\37\1\uffff";
    static final String dfa_9s = "\1\116\1\uffff\26\47\1\uffff";
    static final String dfa_10s = "\1\uffff\1\2\26\uffff\1\1";
    static final String[] dfa_11s = {
            "\1\2\1\3\21\uffff\1\4\1\10\1\23\1\7\1\12\1\6\1\15\1\16\2\uffff\1\20\1\21\1\24\1\5\1\22\1\17\1\uffff\1\25\1\11\1\13\1\uffff\1\26\1\27\1\14\21\uffff\17\30",
            "",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            "\1\1\7\uffff\1\30",
            ""
    };
    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[][] dfa_11 = unpackEncodedStringArray(dfa_11s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_1;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_5;
            this.transition = dfa_11;
        }
        public String getDescription() {
            return "()* loopback of 1640:1: ( ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) otherlv_3= '::' )*";
        }
    }
    static final String dfa_12s = "\32\uffff";
    static final String dfa_13s = "\1\4\27\0\2\uffff";
    static final String dfa_14s = "\1\56\27\0\2\uffff";
    static final String dfa_15s = "\30\uffff\1\1\1\2";
    static final String dfa_16s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\2\uffff}>";
    static final String[] dfa_17s = {
            "\1\1\1\2\12\uffff\1\27\6\uffff\1\3\1\7\1\22\1\6\1\11\1\5\1\14\1\15\2\uffff\1\17\1\20\1\23\1\4\1\21\1\16\1\uffff\1\24\1\10\1\12\1\uffff\1\25\1\26\1\13",
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

    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[][] dfa_17 = unpackEncodedStringArray(dfa_17s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_12;
            this.eof = dfa_12;
            this.min = dfa_13;
            this.max = dfa_14;
            this.accept = dfa_15;
            this.special = dfa_16;
            this.transition = dfa_17;
        }
        public String getDescription() {
            return "1683:2: (this_CollectionTemplateCS_0= ruleCollectionTemplateCS | this_ObjectTemplateCS_1= ruleObjectTemplateCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_2 = input.LA(1);

                         
                        int index33_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_3 = input.LA(1);

                         
                        int index33_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA33_4 = input.LA(1);

                         
                        int index33_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA33_5 = input.LA(1);

                         
                        int index33_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA33_6 = input.LA(1);

                         
                        int index33_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA33_7 = input.LA(1);

                         
                        int index33_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA33_8 = input.LA(1);

                         
                        int index33_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA33_9 = input.LA(1);

                         
                        int index33_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA33_10 = input.LA(1);

                         
                        int index33_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA33_11 = input.LA(1);

                         
                        int index33_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA33_12 = input.LA(1);

                         
                        int index33_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA33_13 = input.LA(1);

                         
                        int index33_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA33_14 = input.LA(1);

                         
                        int index33_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA33_15 = input.LA(1);

                         
                        int index33_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA33_16 = input.LA(1);

                         
                        int index33_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA33_17 = input.LA(1);

                         
                        int index33_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA33_18 = input.LA(1);

                         
                        int index33_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA33_19 = input.LA(1);

                         
                        int index33_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA33_20 = input.LA(1);

                         
                        int index33_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA33_21 = input.LA(1);

                         
                        int index33_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA33_22 = input.LA(1);

                         
                        int index33_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA33_23 = input.LA(1);

                         
                        int index33_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalQVTrelation()) ) {s = 24;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index33_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_18s = "\1\4\26\37\2\uffff";
    static final String dfa_19s = "\1\56\26\47\2\uffff";
    static final String[] dfa_20s = {
            "\1\1\1\2\21\uffff\1\3\1\7\1\22\1\6\1\11\1\5\1\14\1\15\2\uffff\1\17\1\20\1\23\1\4\1\21\1\16\1\uffff\1\24\1\10\1\12\1\uffff\1\25\1\26\1\13",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "\1\30\7\uffff\1\27",
            "",
            ""
    };
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final char[] dfa_19 = DFA.unpackEncodedStringToUnsignedChars(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_18;
            this.max = dfa_19;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "1759:1: ( (lv_ownedPathName_1_0= ruleScopeNameCS ) )?";
        }
    }
    static final String dfa_21s = "\27\uffff\1\2\1\1";
    static final String[] dfa_22s = {
            "\1\1\1\2\1\uffff\1\27\17\uffff\1\3\1\7\1\22\1\6\1\11\1\5\1\14\1\15\2\uffff\1\17\1\20\1\23\1\4\1\21\1\16\1\uffff\1\24\1\10\1\12\1\uffff\1\25\1\26\1\13",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "\1\30\5\uffff\1\27\20\uffff\1\27",
            "",
            ""
    };
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_19;
            this.accept = dfa_21;
            this.special = dfa_5;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "1975:1: ( ( (lv_name_1_0= ruleUnrestrictedName ) ) otherlv_2= ':' )?";
        }
    }
    static final String dfa_23s = "\2\uffff\26\1\1\uffff";
    static final String dfa_24s = "\1\4\1\uffff\26\20\1\uffff";
    static final String dfa_25s = "\1\142\1\uffff\26\130\1\uffff";
    static final String dfa_26s = "\1\uffff\1\1\26\uffff\1\2";
    static final String[] dfa_27s = {
            "\1\2\1\3\2\1\10\uffff\1\30\6\uffff\1\4\1\10\1\23\1\7\1\12\1\6\1\15\1\16\1\1\1\uffff\1\20\1\21\1\24\1\5\1\22\1\17\1\uffff\1\25\1\11\1\13\1\1\1\26\1\27\1\14\2\1\17\uffff\17\1\1\uffff\1\1\1\uffff\4\1\6\uffff\1\1\4\uffff\2\1",
            "",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1",
            ""
    };
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_1;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_5;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "2327:1: (this_ExpCS_0= ruleExpCS | this_TemplateCS_1= ruleTemplateCS )";
        }
    }
    static final String[] dfa_28s = {
            "\1\2\1\3\2\1\10\uffff\1\30\6\uffff\1\4\1\10\1\23\1\7\1\12\1\6\1\15\1\16\1\1\1\uffff\1\20\1\21\1\24\1\5\1\22\1\17\1\uffff\1\25\1\11\1\13\1\1\1\26\1\27\1\14\2\1\17\uffff\17\1\1\uffff\1\1\1\uffff\4\1\6\uffff\1\1\4\uffff\2\1",
            "",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            "\1\30\2\1\1\uffff\2\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\17\uffff\1\1\6\uffff\1\1\1\uffff\1\1",
            ""
    };
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = dfa_1;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_5;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "3854:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )";
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = dfa_1;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_5;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "4067:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )";
        }
    }
    static final String dfa_29s = "\47\uffff";
    static final String dfa_30s = "\1\4\36\uffff\5\0\3\uffff";
    static final String dfa_31s = "\1\116\36\uffff\5\0\3\uffff";
    static final String dfa_32s = "\1\uffff\1\1\25\uffff\1\2\16\uffff\1\3";
    static final String dfa_33s = "\37\uffff\1\0\1\1\1\2\1\3\1\4\3\uffff}>";
    static final String[] dfa_34s = {
            "\2\1\21\uffff\10\1\2\uffff\6\1\1\uffff\3\1\1\uffff\3\1\21\uffff\12\27\1\37\1\40\1\41\1\42\1\43",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_29;
            this.eof = dfa_29;
            this.min = dfa_30;
            this.max = dfa_31;
            this.accept = dfa_32;
            this.special = dfa_33;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "5113:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_31 = input.LA(1);

                         
                        int index87_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred144_InternalQVTrelation()) ) {s = 23;}

                        else if ( (true) ) {s = 38;}

                         
                        input.seek(index87_31);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA87_32 = input.LA(1);

                         
                        int index87_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred144_InternalQVTrelation()) ) {s = 23;}

                        else if ( (true) ) {s = 38;}

                         
                        input.seek(index87_32);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA87_33 = input.LA(1);

                         
                        int index87_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred144_InternalQVTrelation()) ) {s = 23;}

                        else if ( (true) ) {s = 38;}

                         
                        input.seek(index87_33);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA87_34 = input.LA(1);

                         
                        int index87_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred144_InternalQVTrelation()) ) {s = 23;}

                        else if ( (true) ) {s = 38;}

                         
                        input.seek(index87_34);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA87_35 = input.LA(1);

                         
                        int index87_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred144_InternalQVTrelation()) ) {s = 23;}

                        else if ( (true) ) {s = 38;}

                         
                        input.seek(index87_35);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_35s = "\64\uffff";
    static final String dfa_36s = "\1\4\2\0\61\uffff";
    static final String dfa_37s = "\1\142\2\0\61\uffff";
    static final String dfa_38s = "\3\uffff\1\1\57\uffff\1\2";
    static final String dfa_39s = "\1\uffff\1\0\1\1\61\uffff}>";
    static final String[] dfa_40s = {
            "\4\3\17\uffff\11\3\1\uffff\6\3\1\uffff\7\3\1\1\1\2\17\uffff\17\3\1\uffff\1\3\1\uffff\4\3\6\uffff\1\3\4\uffff\1\63\1\3",
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

    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "5190:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_1 = input.LA(1);

                         
                        int index90_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_InternalQVTrelation()) ) {s = 3;}

                        else if ( (true) ) {s = 51;}

                         
                        input.seek(index90_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_2 = input.LA(1);

                         
                        int index90_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_InternalQVTrelation()) ) {s = 3;}

                        else if ( (true) ) {s = 51;}

                         
                        input.seek(index90_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 90, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_41s = "\1\4\12\uffff\7\0\42\uffff";
    static final String dfa_42s = "\1\142\12\uffff\7\0\42\uffff";
    static final String dfa_43s = "\1\uffff\1\1\1\2\1\3\1\4\15\uffff\1\10\1\11\7\uffff\1\12\25\uffff\1\5\1\6\1\7";
    static final String dfa_44s = "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\42\uffff}>";
    static final String[] dfa_45s = {
            "\2\33\2\4\17\uffff\10\33\1\1\1\uffff\6\33\1\uffff\3\33\1\4\3\33\21\uffff\1\14\1\13\10\23\1\15\1\16\1\17\1\20\1\21\1\uffff\1\22\1\uffff\4\4\6\uffff\1\2\5\uffff\1\3",
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
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA93 extends DFA {

        public DFA93(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 93;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_44;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "5439:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA93_11 = input.LA(1);

                         
                        int index93_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_InternalQVTrelation()) ) {s = 49;}

                        else if ( (synpred158_InternalQVTrelation()) ) {s = 19;}

                         
                        input.seek(index93_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA93_12 = input.LA(1);

                         
                        int index93_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_InternalQVTrelation()) ) {s = 50;}

                        else if ( (synpred158_InternalQVTrelation()) ) {s = 19;}

                         
                        input.seek(index93_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA93_13 = input.LA(1);

                         
                        int index93_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_InternalQVTrelation()) ) {s = 51;}

                        else if ( (synpred158_InternalQVTrelation()) ) {s = 19;}

                         
                        input.seek(index93_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA93_14 = input.LA(1);

                         
                        int index93_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_InternalQVTrelation()) ) {s = 51;}

                        else if ( (synpred158_InternalQVTrelation()) ) {s = 19;}

                         
                        input.seek(index93_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA93_15 = input.LA(1);

                         
                        int index93_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_InternalQVTrelation()) ) {s = 51;}

                        else if ( (synpred158_InternalQVTrelation()) ) {s = 19;}

                         
                        input.seek(index93_15);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA93_16 = input.LA(1);

                         
                        int index93_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_InternalQVTrelation()) ) {s = 51;}

                        else if ( (synpred158_InternalQVTrelation()) ) {s = 19;}

                         
                        input.seek(index93_16);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA93_17 = input.LA(1);

                         
                        int index93_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_InternalQVTrelation()) ) {s = 51;}

                        else if ( (synpred158_InternalQVTrelation()) ) {s = 19;}

                         
                        input.seek(index93_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 93, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_46s = "\1\142\1\uffff\26\135\1\uffff";
    static final String[] dfa_47s = {
            "\1\2\1\3\2\1\10\uffff\1\30\6\uffff\1\4\1\10\1\23\1\7\1\12\1\6\1\15\1\16\1\1\1\uffff\1\20\1\21\1\24\1\5\1\22\1\17\1\uffff\1\25\1\11\1\13\1\1\1\26\1\27\1\14\2\1\17\uffff\17\1\1\uffff\1\1\1\uffff\4\1\6\uffff\1\1\4\uffff\2\1",
            "",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            "\1\30\1\1\3\uffff\1\1\11\uffff\1\1\7\uffff\1\1\3\uffff\1\1\3\uffff\1\1\1\uffff\17\1\26\uffff\1\1\1\uffff\1\1\4\uffff\1\1",
            ""
    };
    static final char[] dfa_46 = DFA.unpackEncodedStringToUnsignedChars(dfa_46s);
    static final short[][] dfa_47 = unpackEncodedStringArray(dfa_47s);

    class DFA117 extends DFA {

        public DFA117(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 117;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_24;
            this.max = dfa_46;
            this.accept = dfa_26;
            this.special = dfa_5;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "6498:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000050000000002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007C00L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000777E7F910030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000777E7F810030L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0001FF7EFF8000F0L,0x00000006103D7FFFL});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000777E7F800030L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000018440000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010400000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000777E7F900030L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0001FF7EFF8000F0L,0x00000004103D7FFFL});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000777E7F820030L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001FF7EFF8100F0L,0x00000006103D7FFFL});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000777F7F800030L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100040000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000420000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000003000000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000004000020000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000200000100000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000777E7F800032L,0x0000000000007FFFL});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020000020000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000003C20100000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000003C00100000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000777E7F8000B0L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008000400000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000650000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001FF7EFF9000F0L,0x00000006103D7FFFL});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000777E7F800030L,0x0000000000007FFFL});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001FF7EFF9100F0L,0x00000006103D7FFFL});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000210000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xFFFE880000200002L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000080020002L,0x0000000001400000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000020002L,0x0000000000400000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000777E7F9000B0L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0001FF7FFF8100F0L,0x00000006103D7FFFL});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000100440000L,0x0000000008000000L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000100040000L,0x0000000008000000L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000040000L,0x0000000002000000L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000010002L,0x0000000004000000L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000140000000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000040000L,0x0000000004000000L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000080210000L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000080000000040L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0004080000000040L,0x0000002000000000L});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000001802000000L});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    }


}