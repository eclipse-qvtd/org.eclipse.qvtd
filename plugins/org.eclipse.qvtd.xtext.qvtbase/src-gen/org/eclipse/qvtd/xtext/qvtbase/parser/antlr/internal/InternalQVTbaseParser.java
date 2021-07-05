/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.parser.antlr.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;



import org.antlr.runtime.*;
/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalQVTbaseParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SINGLE_QUOTED_STRING", "RULE_UNQUOTED_STRING", "RULE_INT", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'static'", "'definition'", "'attribute'", "':'", "'='", "'{'", "'derived'", "'!derived'", "'id'", "'!id'", "'ordered'", "'!ordered'", "'readonly'", "'!readonly'", "'transient'", "'!transient'", "'unique'", "'!unique'", "'unsettable'", "'!unsettable'", "'volatile'", "'!volatile'", "','", "'}'", "'initial'", "';'", "'derivation'", "'primitive'", "'datatype'", "'serializable'", "'!serializable'", "'enum'", "'literal'", "'operation'", "'('", "')'", "'throws'", "'body'", "'property'", "'#'", "'composes'", "'!composes'", "'resolve'", "'!resolve'", "'input'", "'output'", "'via'", "'iterates'", "'abstract'", "'class'", "'extends'", "'interface'", "'-'", "'not'", "'not2'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'<>'", "'and'", "'and2'", "'implies'", "'implies2'", "'or'", "'or2'", "'xor'", "'xor2'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'..'", "'++'", "'Lambda'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'in'", "'|'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'|?'", "'|1'", "'?'", "'::'", "'&&'"
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
	public static final int T__132=132;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__131=131;
	public static final int T__130=130;
	public static final int RULE_INT=6;
	public static final int T__66=66;
	public static final int RULE_ML_COMMENT=13;
	public static final int T__67=67;
	public static final int T__129=129;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__62=62;
	public static final int T__126=126;
	public static final int T__63=63;
	public static final int T__125=125;
	public static final int T__64=64;
	public static final int T__128=128;
	public static final int T__65=65;
	public static final int T__127=127;
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
	public static final int RULE_SINGLE_QUOTED_STRING=4;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int RULE_DOUBLE_QUOTED_STRING=11;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int RULE_ESCAPED_ID=8;
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
	public static final int RULE_LETTER_CHARACTER=10;
	public static final int T__19=19;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__99=99;
	public static final int RULE_ESCAPED_CHARACTER=9;
	public static final int T__95=95;
	public static final int RULE_ML_SINGLE_QUOTED_STRING=12;
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
	public static final int T__122=122;
	public static final int T__70=70;
	public static final int T__121=121;
	public static final int T__71=71;
	public static final int T__124=124;
	public static final int T__72=72;
	public static final int T__123=123;
	public static final int T__120=120;
	public static final int RULE_UNQUOTED_STRING=5;
	public static final int RULE_SL_COMMENT=14;
	public static final int T__77=77;
	public static final int T__119=119;
	public static final int T__78=78;
	public static final int T__118=118;
	public static final int T__79=79;
	public static final int T__73=73;
	public static final int T__115=115;
	public static final int EOF=-1;
	public static final int T__74=74;
	public static final int T__114=114;
	public static final int T__75=75;
	public static final int T__117=117;
	public static final int T__76=76;
	public static final int T__116=116;
	public static final int T__80=80;
	public static final int T__111=111;
	public static final int T__81=81;
	public static final int T__110=110;
	public static final int T__82=82;
	public static final int T__113=113;
	public static final int RULE_SIMPLE_ID=7;
	public static final int T__83=83;
	public static final int T__112=112;
	public static final int RULE_WS=15;
	public static final int RULE_ANY_OTHER=16;
	public static final int T__88=88;
	public static final int T__108=108;
	public static final int T__89=89;
	public static final int T__107=107;
	public static final int T__109=109;
	public static final int T__84=84;
	public static final int T__104=104;
	public static final int T__85=85;
	public static final int T__103=103;
	public static final int T__86=86;
	public static final int T__106=106;
	public static final int T__87=87;
	public static final int T__105=105;

	// delegates
	// delegators


	public InternalQVTbaseParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalQVTbaseParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	@Override
	public String[] getTokenNames() { return InternalQVTbaseParser.tokenNames; }
	@Override
	public String getGrammarFileName() { return "InternalQVTbase.g"; }



	/*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
	 */

	private QVTbaseGrammarAccess grammarAccess;

	public InternalQVTbaseParser(TokenStream input, QVTbaseGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "AttributeCS";
	}

	@Override
	protected QVTbaseGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRuleAttributeCS"
	// InternalQVTbase.g:80:1: entryRuleAttributeCS returns [EObject current=null] : iv_ruleAttributeCS= ruleAttributeCS EOF ;
	public final EObject entryRuleAttributeCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleAttributeCS = null;


		try {
			// InternalQVTbase.g:81:2: (iv_ruleAttributeCS= ruleAttributeCS EOF )
			// InternalQVTbase.g:82:2: iv_ruleAttributeCS= ruleAttributeCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getAttributeCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleAttributeCS=ruleAttributeCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleAttributeCS;
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
	// $ANTLR end "entryRuleAttributeCS"


	// $ANTLR start "ruleAttributeCS"
	// InternalQVTbase.g:89:1: ruleAttributeCS returns [EObject current=null] : ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) ) ;
	public final EObject ruleAttributeCS() throws RecognitionException {
		EObject current = null;

		Token lv_qualifiers_0_0=null;
		Token lv_qualifiers_1_0=null;
		Token lv_qualifiers_2_0=null;
		Token lv_qualifiers_3_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token lv_default_9_0=null;
		Token otherlv_10=null;
		Token lv_qualifiers_11_0=null;
		Token lv_qualifiers_12_0=null;
		Token lv_qualifiers_13_0=null;
		Token lv_qualifiers_14_0=null;
		Token lv_qualifiers_15_0=null;
		Token lv_qualifiers_16_0=null;
		Token lv_qualifiers_17_0=null;
		Token lv_qualifiers_18_0=null;
		Token lv_qualifiers_19_0=null;
		Token lv_qualifiers_20_0=null;
		Token lv_qualifiers_21_0=null;
		Token lv_qualifiers_22_0=null;
		Token lv_qualifiers_23_0=null;
		Token lv_qualifiers_24_0=null;
		Token lv_qualifiers_25_0=null;
		Token lv_qualifiers_26_0=null;
		Token otherlv_27=null;
		Token otherlv_28=null;
		Token otherlv_29=null;
		Token otherlv_30=null;
		Token otherlv_32=null;
		Token otherlv_34=null;
		Token otherlv_35=null;
		Token otherlv_37=null;
		Token otherlv_39=null;
		Token otherlv_40=null;
		Token otherlv_41=null;
		AntlrDatatypeRuleToken lv_name_5_0 = null;

		EObject lv_ownedType_7_0 = null;

		EObject lv_ownedDefaultExpressions_33_0 = null;

		EObject lv_ownedDefaultExpressions_38_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:92:28: ( ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) ) )
			// InternalQVTbase.g:93:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) )
			{
				// InternalQVTbase.g:93:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' ) )
				// InternalQVTbase.g:93:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'attribute' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )? ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' )
				{
					// InternalQVTbase.g:93:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )?
					int alt3=3;
					int LA3_0 = input.LA(1);

					if ( (LA3_0==17) ) {
						alt3=1;
					}
					else if ( (LA3_0==18) ) {
						alt3=2;
					}
					switch (alt3) {
						case 1 :
							// InternalQVTbase.g:93:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
						{
							// InternalQVTbase.g:93:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
							// InternalQVTbase.g:93:4: ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )?
							{
								// InternalQVTbase.g:93:4: ( (lv_qualifiers_0_0= 'static' ) )
								// InternalQVTbase.g:94:1: (lv_qualifiers_0_0= 'static' )
								{
									// InternalQVTbase.g:94:1: (lv_qualifiers_0_0= 'static' )
									// InternalQVTbase.g:95:3: lv_qualifiers_0_0= 'static'
									{
										lv_qualifiers_0_0=(Token)match(input,17,FollowSets000.FOLLOW_3); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(lv_qualifiers_0_0, grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0());

										}
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElement(grammarAccess.getAttributeCSRule());
											}
											addWithLastConsumed(current, "qualifiers", lv_qualifiers_0_0, "static");

										}

									}


								}

								// InternalQVTbase.g:108:2: ( (lv_qualifiers_1_0= 'definition' ) )?
								int alt1=2;
								int LA1_0 = input.LA(1);

								if ( (LA1_0==18) ) {
									alt1=1;
								}
								switch (alt1) {
									case 1 :
										// InternalQVTbase.g:109:1: (lv_qualifiers_1_0= 'definition' )
									{
										// InternalQVTbase.g:109:1: (lv_qualifiers_1_0= 'definition' )
										// InternalQVTbase.g:110:3: lv_qualifiers_1_0= 'definition'
										{
											lv_qualifiers_1_0=(Token)match(input,18,FollowSets000.FOLLOW_4); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_qualifiers_1_0, grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getAttributeCSRule());
												}
												addWithLastConsumed(current, "qualifiers", lv_qualifiers_1_0, "definition");

											}

										}


									}
									break;

								}


							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:124:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
						{
							// InternalQVTbase.g:124:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
							// InternalQVTbase.g:124:7: ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )?
							{
								// InternalQVTbase.g:124:7: ( (lv_qualifiers_2_0= 'definition' ) )
								// InternalQVTbase.g:125:1: (lv_qualifiers_2_0= 'definition' )
								{
									// InternalQVTbase.g:125:1: (lv_qualifiers_2_0= 'definition' )
									// InternalQVTbase.g:126:3: lv_qualifiers_2_0= 'definition'
									{
										lv_qualifiers_2_0=(Token)match(input,18,FollowSets000.FOLLOW_5); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(lv_qualifiers_2_0, grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());

										}
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElement(grammarAccess.getAttributeCSRule());
											}
											addWithLastConsumed(current, "qualifiers", lv_qualifiers_2_0, "definition");

										}

									}


								}

								// InternalQVTbase.g:139:2: ( (lv_qualifiers_3_0= 'static' ) )?
								int alt2=2;
								int LA2_0 = input.LA(1);

								if ( (LA2_0==17) ) {
									alt2=1;
								}
								switch (alt2) {
									case 1 :
										// InternalQVTbase.g:140:1: (lv_qualifiers_3_0= 'static' )
									{
										// InternalQVTbase.g:140:1: (lv_qualifiers_3_0= 'static' )
										// InternalQVTbase.g:141:3: lv_qualifiers_3_0= 'static'
										{
											lv_qualifiers_3_0=(Token)match(input,17,FollowSets000.FOLLOW_4); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_qualifiers_3_0, grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getAttributeCSRule());
												}
												addWithLastConsumed(current, "qualifiers", lv_qualifiers_3_0, "static");

											}

										}


									}
									break;

								}


							}


						}
						break;

					}

					otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_4, grammarAccess.getAttributeCSAccess().getAttributeKeyword_1());

					}
					// InternalQVTbase.g:158:1: ( (lv_name_5_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:159:1: (lv_name_5_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:159:1: (lv_name_5_0= ruleUnrestrictedName )
						// InternalQVTbase.g:160:3: lv_name_5_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getAttributeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

							}
							pushFollow(FollowSets000.FOLLOW_7);
							lv_name_5_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getAttributeCSRule());
								}
								set(
									current,
									"name",
									lv_name_5_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:176:2: (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) ) )?
					int alt4=2;
					int LA4_0 = input.LA(1);

					if ( (LA4_0==20) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// InternalQVTbase.g:176:4: otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) )
						{
							otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_6, grammarAccess.getAttributeCSAccess().getColonKeyword_3_0());

							}
							// InternalQVTbase.g:180:1: ( (lv_ownedType_7_0= ruleTypedMultiplicityRefCS ) )
							// InternalQVTbase.g:181:1: (lv_ownedType_7_0= ruleTypedMultiplicityRefCS )
							{
								// InternalQVTbase.g:181:1: (lv_ownedType_7_0= ruleTypedMultiplicityRefCS )
								// InternalQVTbase.g:182:3: lv_ownedType_7_0= ruleTypedMultiplicityRefCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_9);
									lv_ownedType_7_0=ruleTypedMultiplicityRefCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getAttributeCSRule());
										}
										set(
											current,
											"ownedType",
											lv_ownedType_7_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:198:4: (otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) ) )?
					int alt5=2;
					int LA5_0 = input.LA(1);

					if ( (LA5_0==21) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// InternalQVTbase.g:198:6: otherlv_8= '=' ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) )
						{
							otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_10); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_8, grammarAccess.getAttributeCSAccess().getEqualsSignKeyword_4_0());

							}
							// InternalQVTbase.g:202:1: ( (lv_default_9_0= RULE_SINGLE_QUOTED_STRING ) )
							// InternalQVTbase.g:203:1: (lv_default_9_0= RULE_SINGLE_QUOTED_STRING )
							{
								// InternalQVTbase.g:203:1: (lv_default_9_0= RULE_SINGLE_QUOTED_STRING )
								// InternalQVTbase.g:204:3: lv_default_9_0= RULE_SINGLE_QUOTED_STRING
								{
									lv_default_9_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_11); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_default_9_0, grammarAccess.getAttributeCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getAttributeCSRule());
										}
										setWithLastConsumed(
											current,
											"default",
											lv_default_9_0,
											"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:220:4: (otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}' )?
					int alt9=2;
					int LA9_0 = input.LA(1);

					if ( (LA9_0==22) ) {
						int LA9_1 = input.LA(2);

						if ( ((LA9_1>=23 && LA9_1<=38)) ) {
							alt9=1;
						}
					}
					switch (alt9) {
						case 1 :
							// InternalQVTbase.g:220:6: otherlv_10= '{' ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+ otherlv_28= '}'
						{
							otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_10, grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_5_0());

							}
							// InternalQVTbase.g:224:1: ( ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )? )+
							int cnt8=0;
							loop8:
								do {
									int alt8=2;
									int LA8_0 = input.LA(1);

									if ( ((LA8_0>=23 && LA8_0<=38)) ) {
										alt8=1;
									}


									switch (alt8) {
										case 1 :
											// InternalQVTbase.g:224:2: ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) ) (otherlv_27= ',' )?
										{
											// InternalQVTbase.g:224:2: ( ( (lv_qualifiers_11_0= 'derived' ) ) | ( (lv_qualifiers_12_0= '!derived' ) ) | ( (lv_qualifiers_13_0= 'id' ) ) | ( (lv_qualifiers_14_0= '!id' ) ) | ( (lv_qualifiers_15_0= 'ordered' ) ) | ( (lv_qualifiers_16_0= '!ordered' ) ) | ( (lv_qualifiers_17_0= 'readonly' ) ) | ( (lv_qualifiers_18_0= '!readonly' ) ) | ( (lv_qualifiers_19_0= 'transient' ) ) | ( (lv_qualifiers_20_0= '!transient' ) ) | ( (lv_qualifiers_21_0= 'unique' ) ) | ( (lv_qualifiers_22_0= '!unique' ) ) | ( (lv_qualifiers_23_0= 'unsettable' ) ) | ( (lv_qualifiers_24_0= '!unsettable' ) ) | ( (lv_qualifiers_25_0= 'volatile' ) ) | ( (lv_qualifiers_26_0= '!volatile' ) ) )
											int alt6=16;
											switch ( input.LA(1) ) {
												case 23:
												{
													alt6=1;
												}
												break;
												case 24:
												{
													alt6=2;
												}
												break;
												case 25:
												{
													alt6=3;
												}
												break;
												case 26:
												{
													alt6=4;
												}
												break;
												case 27:
												{
													alt6=5;
												}
												break;
												case 28:
												{
													alt6=6;
												}
												break;
												case 29:
												{
													alt6=7;
												}
												break;
												case 30:
												{
													alt6=8;
												}
												break;
												case 31:
												{
													alt6=9;
												}
												break;
												case 32:
												{
													alt6=10;
												}
												break;
												case 33:
												{
													alt6=11;
												}
												break;
												case 34:
												{
													alt6=12;
												}
												break;
												case 35:
												{
													alt6=13;
												}
												break;
												case 36:
												{
													alt6=14;
												}
												break;
												case 37:
												{
													alt6=15;
												}
												break;
												case 38:
												{
													alt6=16;
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
													// InternalQVTbase.g:224:3: ( (lv_qualifiers_11_0= 'derived' ) )
												{
													// InternalQVTbase.g:224:3: ( (lv_qualifiers_11_0= 'derived' ) )
													// InternalQVTbase.g:225:1: (lv_qualifiers_11_0= 'derived' )
													{
														// InternalQVTbase.g:225:1: (lv_qualifiers_11_0= 'derived' )
														// InternalQVTbase.g:226:3: lv_qualifiers_11_0= 'derived'
														{
															lv_qualifiers_11_0=(Token)match(input,23,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_11_0, grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_11_0, "derived");

															}

														}


													}


												}
												break;
												case 2 :
													// InternalQVTbase.g:240:6: ( (lv_qualifiers_12_0= '!derived' ) )
												{
													// InternalQVTbase.g:240:6: ( (lv_qualifiers_12_0= '!derived' ) )
													// InternalQVTbase.g:241:1: (lv_qualifiers_12_0= '!derived' )
													{
														// InternalQVTbase.g:241:1: (lv_qualifiers_12_0= '!derived' )
														// InternalQVTbase.g:242:3: lv_qualifiers_12_0= '!derived'
														{
															lv_qualifiers_12_0=(Token)match(input,24,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_12_0, grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_12_0, "!derived");

															}

														}


													}


												}
												break;
												case 3 :
													// InternalQVTbase.g:256:6: ( (lv_qualifiers_13_0= 'id' ) )
												{
													// InternalQVTbase.g:256:6: ( (lv_qualifiers_13_0= 'id' ) )
													// InternalQVTbase.g:257:1: (lv_qualifiers_13_0= 'id' )
													{
														// InternalQVTbase.g:257:1: (lv_qualifiers_13_0= 'id' )
														// InternalQVTbase.g:258:3: lv_qualifiers_13_0= 'id'
														{
															lv_qualifiers_13_0=(Token)match(input,25,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_13_0, grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_13_0, "id");

															}

														}


													}


												}
												break;
												case 4 :
													// InternalQVTbase.g:272:6: ( (lv_qualifiers_14_0= '!id' ) )
												{
													// InternalQVTbase.g:272:6: ( (lv_qualifiers_14_0= '!id' ) )
													// InternalQVTbase.g:273:1: (lv_qualifiers_14_0= '!id' )
													{
														// InternalQVTbase.g:273:1: (lv_qualifiers_14_0= '!id' )
														// InternalQVTbase.g:274:3: lv_qualifiers_14_0= '!id'
														{
															lv_qualifiers_14_0=(Token)match(input,26,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_14_0, grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_14_0, "!id");

															}

														}


													}


												}
												break;
												case 5 :
													// InternalQVTbase.g:288:6: ( (lv_qualifiers_15_0= 'ordered' ) )
												{
													// InternalQVTbase.g:288:6: ( (lv_qualifiers_15_0= 'ordered' ) )
													// InternalQVTbase.g:289:1: (lv_qualifiers_15_0= 'ordered' )
													{
														// InternalQVTbase.g:289:1: (lv_qualifiers_15_0= 'ordered' )
														// InternalQVTbase.g:290:3: lv_qualifiers_15_0= 'ordered'
														{
															lv_qualifiers_15_0=(Token)match(input,27,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_15_0, grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_15_0, "ordered");

															}

														}


													}


												}
												break;
												case 6 :
													// InternalQVTbase.g:304:6: ( (lv_qualifiers_16_0= '!ordered' ) )
												{
													// InternalQVTbase.g:304:6: ( (lv_qualifiers_16_0= '!ordered' ) )
													// InternalQVTbase.g:305:1: (lv_qualifiers_16_0= '!ordered' )
													{
														// InternalQVTbase.g:305:1: (lv_qualifiers_16_0= '!ordered' )
														// InternalQVTbase.g:306:3: lv_qualifiers_16_0= '!ordered'
														{
															lv_qualifiers_16_0=(Token)match(input,28,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_16_0, grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_16_0, "!ordered");

															}

														}


													}


												}
												break;
												case 7 :
													// InternalQVTbase.g:320:6: ( (lv_qualifiers_17_0= 'readonly' ) )
												{
													// InternalQVTbase.g:320:6: ( (lv_qualifiers_17_0= 'readonly' ) )
													// InternalQVTbase.g:321:1: (lv_qualifiers_17_0= 'readonly' )
													{
														// InternalQVTbase.g:321:1: (lv_qualifiers_17_0= 'readonly' )
														// InternalQVTbase.g:322:3: lv_qualifiers_17_0= 'readonly'
														{
															lv_qualifiers_17_0=(Token)match(input,29,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_17_0, grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_17_0, "readonly");

															}

														}


													}


												}
												break;
												case 8 :
													// InternalQVTbase.g:336:6: ( (lv_qualifiers_18_0= '!readonly' ) )
												{
													// InternalQVTbase.g:336:6: ( (lv_qualifiers_18_0= '!readonly' ) )
													// InternalQVTbase.g:337:1: (lv_qualifiers_18_0= '!readonly' )
													{
														// InternalQVTbase.g:337:1: (lv_qualifiers_18_0= '!readonly' )
														// InternalQVTbase.g:338:3: lv_qualifiers_18_0= '!readonly'
														{
															lv_qualifiers_18_0=(Token)match(input,30,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_18_0, grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_18_0, "!readonly");

															}

														}


													}


												}
												break;
												case 9 :
													// InternalQVTbase.g:352:6: ( (lv_qualifiers_19_0= 'transient' ) )
												{
													// InternalQVTbase.g:352:6: ( (lv_qualifiers_19_0= 'transient' ) )
													// InternalQVTbase.g:353:1: (lv_qualifiers_19_0= 'transient' )
													{
														// InternalQVTbase.g:353:1: (lv_qualifiers_19_0= 'transient' )
														// InternalQVTbase.g:354:3: lv_qualifiers_19_0= 'transient'
														{
															lv_qualifiers_19_0=(Token)match(input,31,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_19_0, grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_19_0, "transient");

															}

														}


													}


												}
												break;
												case 10 :
													// InternalQVTbase.g:368:6: ( (lv_qualifiers_20_0= '!transient' ) )
												{
													// InternalQVTbase.g:368:6: ( (lv_qualifiers_20_0= '!transient' ) )
													// InternalQVTbase.g:369:1: (lv_qualifiers_20_0= '!transient' )
													{
														// InternalQVTbase.g:369:1: (lv_qualifiers_20_0= '!transient' )
														// InternalQVTbase.g:370:3: lv_qualifiers_20_0= '!transient'
														{
															lv_qualifiers_20_0=(Token)match(input,32,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_20_0, grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_20_0, "!transient");

															}

														}


													}


												}
												break;
												case 11 :
													// InternalQVTbase.g:384:6: ( (lv_qualifiers_21_0= 'unique' ) )
												{
													// InternalQVTbase.g:384:6: ( (lv_qualifiers_21_0= 'unique' ) )
													// InternalQVTbase.g:385:1: (lv_qualifiers_21_0= 'unique' )
													{
														// InternalQVTbase.g:385:1: (lv_qualifiers_21_0= 'unique' )
														// InternalQVTbase.g:386:3: lv_qualifiers_21_0= 'unique'
														{
															lv_qualifiers_21_0=(Token)match(input,33,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_21_0, grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_21_0, "unique");

															}

														}


													}


												}
												break;
												case 12 :
													// InternalQVTbase.g:400:6: ( (lv_qualifiers_22_0= '!unique' ) )
												{
													// InternalQVTbase.g:400:6: ( (lv_qualifiers_22_0= '!unique' ) )
													// InternalQVTbase.g:401:1: (lv_qualifiers_22_0= '!unique' )
													{
														// InternalQVTbase.g:401:1: (lv_qualifiers_22_0= '!unique' )
														// InternalQVTbase.g:402:3: lv_qualifiers_22_0= '!unique'
														{
															lv_qualifiers_22_0=(Token)match(input,34,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_22_0, grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_22_0, "!unique");

															}

														}


													}


												}
												break;
												case 13 :
													// InternalQVTbase.g:416:6: ( (lv_qualifiers_23_0= 'unsettable' ) )
												{
													// InternalQVTbase.g:416:6: ( (lv_qualifiers_23_0= 'unsettable' ) )
													// InternalQVTbase.g:417:1: (lv_qualifiers_23_0= 'unsettable' )
													{
														// InternalQVTbase.g:417:1: (lv_qualifiers_23_0= 'unsettable' )
														// InternalQVTbase.g:418:3: lv_qualifiers_23_0= 'unsettable'
														{
															lv_qualifiers_23_0=(Token)match(input,35,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_23_0, grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_23_0, "unsettable");

															}

														}


													}


												}
												break;
												case 14 :
													// InternalQVTbase.g:432:6: ( (lv_qualifiers_24_0= '!unsettable' ) )
												{
													// InternalQVTbase.g:432:6: ( (lv_qualifiers_24_0= '!unsettable' ) )
													// InternalQVTbase.g:433:1: (lv_qualifiers_24_0= '!unsettable' )
													{
														// InternalQVTbase.g:433:1: (lv_qualifiers_24_0= '!unsettable' )
														// InternalQVTbase.g:434:3: lv_qualifiers_24_0= '!unsettable'
														{
															lv_qualifiers_24_0=(Token)match(input,36,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_24_0, grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_24_0, "!unsettable");

															}

														}


													}


												}
												break;
												case 15 :
													// InternalQVTbase.g:448:6: ( (lv_qualifiers_25_0= 'volatile' ) )
												{
													// InternalQVTbase.g:448:6: ( (lv_qualifiers_25_0= 'volatile' ) )
													// InternalQVTbase.g:449:1: (lv_qualifiers_25_0= 'volatile' )
													{
														// InternalQVTbase.g:449:1: (lv_qualifiers_25_0= 'volatile' )
														// InternalQVTbase.g:450:3: lv_qualifiers_25_0= 'volatile'
														{
															lv_qualifiers_25_0=(Token)match(input,37,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_25_0, grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_25_0, "volatile");

															}

														}


													}


												}
												break;
												case 16 :
													// InternalQVTbase.g:464:6: ( (lv_qualifiers_26_0= '!volatile' ) )
												{
													// InternalQVTbase.g:464:6: ( (lv_qualifiers_26_0= '!volatile' ) )
													// InternalQVTbase.g:465:1: (lv_qualifiers_26_0= '!volatile' )
													{
														// InternalQVTbase.g:465:1: (lv_qualifiers_26_0= '!volatile' )
														// InternalQVTbase.g:466:3: lv_qualifiers_26_0= '!volatile'
														{
															lv_qualifiers_26_0=(Token)match(input,38,FollowSets000.FOLLOW_13); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_26_0, grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getAttributeCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_26_0, "!volatile");

															}

														}


													}


												}
												break;

											}

											// InternalQVTbase.g:479:3: (otherlv_27= ',' )?
											int alt7=2;
											int LA7_0 = input.LA(1);

											if ( (LA7_0==39) ) {
												alt7=1;
											}
											switch (alt7) {
												case 1 :
													// InternalQVTbase.g:479:5: otherlv_27= ','
													{
														otherlv_27=(Token)match(input,39,FollowSets000.FOLLOW_14); if (state.failed) return current;
														if ( state.backtracking==0 ) {

															newLeafNode(otherlv_27, grammarAccess.getAttributeCSAccess().getCommaKeyword_5_1_1());

														}

													}
													break;

											}


										}
										break;

										default :
											if ( cnt8 >= 1 ) break loop8;
											if (state.backtracking>0) {state.failed=true; return current;}
											EarlyExitException eee =
													new EarlyExitException(8, input);
											throw eee;
									}
									cnt8++;
								} while (true);

							otherlv_28=(Token)match(input,40,FollowSets000.FOLLOW_11); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_28, grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_5_2());

							}

						}
						break;

					}

					// InternalQVTbase.g:487:3: ( (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' ) | otherlv_41= ';' )
					int alt15=2;
					int LA15_0 = input.LA(1);

					if ( (LA15_0==22) ) {
						alt15=1;
					}
					else if ( (LA15_0==42) ) {
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
							// InternalQVTbase.g:487:4: (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' )
						{
							// InternalQVTbase.g:487:4: (otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}' )
							// InternalQVTbase.g:487:6: otherlv_29= '{' ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )* otherlv_40= '}'
							{
								otherlv_29=(Token)match(input,22,FollowSets000.FOLLOW_15); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_29, grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0());

								}
								// InternalQVTbase.g:491:1: ( (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' ) | (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' ) )*
								loop14:
									do {
										int alt14=3;
										int LA14_0 = input.LA(1);

										if ( (LA14_0==41) ) {
											alt14=1;
										}
										else if ( (LA14_0==43) ) {
											alt14=2;
										}


										switch (alt14) {
											case 1 :
												// InternalQVTbase.g:491:2: (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' )
											{
												// InternalQVTbase.g:491:2: (otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';' )
												// InternalQVTbase.g:491:4: otherlv_30= 'initial' ( ruleUnrestrictedName )? otherlv_32= ':' ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )? otherlv_34= ';'
												{
													otherlv_30=(Token)match(input,41,FollowSets000.FOLLOW_16); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_30, grammarAccess.getAttributeCSAccess().getInitialKeyword_6_0_1_0_0());

													}
													// InternalQVTbase.g:495:1: ( ruleUnrestrictedName )?
													int alt10=2;
													int LA10_0 = input.LA(1);

													if ( ((LA10_0>=RULE_SIMPLE_ID && LA10_0<=RULE_ESCAPED_ID)) ) {
														alt10=1;
													}
													switch (alt10) {
														case 1 :
															// InternalQVTbase.g:496:2: ruleUnrestrictedName
														{
															if ( state.backtracking==0 ) {

																/* */

															}
															if ( state.backtracking==0 ) {

																newCompositeNode(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_0_1());

															}
															pushFollow(FollowSets000.FOLLOW_17);
															ruleUnrestrictedName();

															state._fsp--;
															if (state.failed) return current;
															if ( state.backtracking==0 ) {

																afterParserOrEnumRuleCall();

															}

														}
														break;

													}

													otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_18); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_32, grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_0_2());

													}
													// InternalQVTbase.g:510:1: ( (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS ) )?
													int alt11=2;
													int LA11_0 = input.LA(1);

													if ( ((LA11_0>=RULE_SINGLE_QUOTED_STRING && LA11_0<=RULE_ESCAPED_ID)||LA11_0==51||(LA11_0>=69 && LA11_0<=72)||(LA11_0>=92 && LA11_0<=106)||LA11_0==109||(LA11_0>=111 && LA11_0<=114)||LA11_0==121||(LA11_0>=126 && LA11_0<=127)) ) {
														alt11=1;
													}
													switch (alt11) {
														case 1 :
															// InternalQVTbase.g:511:1: (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS )
														{
															// InternalQVTbase.g:511:1: (lv_ownedDefaultExpressions_33_0= ruleSpecificationCS )
															// InternalQVTbase.g:512:3: lv_ownedDefaultExpressions_33_0= ruleSpecificationCS
															{
																if ( state.backtracking==0 ) {

																	newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0());

																}
																pushFollow(FollowSets000.FOLLOW_19);
																lv_ownedDefaultExpressions_33_0=ruleSpecificationCS();

																state._fsp--;
																if (state.failed) return current;
																if ( state.backtracking==0 ) {

																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getAttributeCSRule());
																	}
																	add(
																		current,
																		"ownedDefaultExpressions",
																		lv_ownedDefaultExpressions_33_0,
																		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
																	afterParserOrEnumRuleCall();

																}

															}


														}
														break;

													}

													otherlv_34=(Token)match(input,42,FollowSets000.FOLLOW_15); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_34, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_0_4());

													}

												}


											}
											break;
											case 2 :
												// InternalQVTbase.g:533:6: (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' )
											{
												// InternalQVTbase.g:533:6: (otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';' )
												// InternalQVTbase.g:533:8: otherlv_35= 'derivation' ( ruleUnrestrictedName )? otherlv_37= ':' ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )? otherlv_39= ';'
												{
													otherlv_35=(Token)match(input,43,FollowSets000.FOLLOW_16); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_35, grammarAccess.getAttributeCSAccess().getDerivationKeyword_6_0_1_1_0());

													}
													// InternalQVTbase.g:537:1: ( ruleUnrestrictedName )?
													int alt12=2;
													int LA12_0 = input.LA(1);

													if ( ((LA12_0>=RULE_SIMPLE_ID && LA12_0<=RULE_ESCAPED_ID)) ) {
														alt12=1;
													}
													switch (alt12) {
														case 1 :
															// InternalQVTbase.g:538:2: ruleUnrestrictedName
														{
															if ( state.backtracking==0 ) {

																/* */

															}
															if ( state.backtracking==0 ) {

																newCompositeNode(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_1_1());

															}
															pushFollow(FollowSets000.FOLLOW_17);
															ruleUnrestrictedName();

															state._fsp--;
															if (state.failed) return current;
															if ( state.backtracking==0 ) {

																afterParserOrEnumRuleCall();

															}

														}
														break;

													}

													otherlv_37=(Token)match(input,20,FollowSets000.FOLLOW_18); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_37, grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_1_2());

													}
													// InternalQVTbase.g:552:1: ( (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS ) )?
													int alt13=2;
													int LA13_0 = input.LA(1);

													if ( ((LA13_0>=RULE_SINGLE_QUOTED_STRING && LA13_0<=RULE_ESCAPED_ID)||LA13_0==51||(LA13_0>=69 && LA13_0<=72)||(LA13_0>=92 && LA13_0<=106)||LA13_0==109||(LA13_0>=111 && LA13_0<=114)||LA13_0==121||(LA13_0>=126 && LA13_0<=127)) ) {
														alt13=1;
													}
													switch (alt13) {
														case 1 :
															// InternalQVTbase.g:553:1: (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS )
														{
															// InternalQVTbase.g:553:1: (lv_ownedDefaultExpressions_38_0= ruleSpecificationCS )
															// InternalQVTbase.g:554:3: lv_ownedDefaultExpressions_38_0= ruleSpecificationCS
															{
																if ( state.backtracking==0 ) {

																	newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0());

																}
																pushFollow(FollowSets000.FOLLOW_19);
																lv_ownedDefaultExpressions_38_0=ruleSpecificationCS();

																state._fsp--;
																if (state.failed) return current;
																if ( state.backtracking==0 ) {

																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getAttributeCSRule());
																	}
																	add(
																		current,
																		"ownedDefaultExpressions",
																		lv_ownedDefaultExpressions_38_0,
																		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
																	afterParserOrEnumRuleCall();

																}

															}


														}
														break;

													}

													otherlv_39=(Token)match(input,42,FollowSets000.FOLLOW_15); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_39, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_1_4());

													}

												}


											}
											break;

											default :
												break loop14;
										}
									} while (true);

								otherlv_40=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_40, grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2());

								}

							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:579:7: otherlv_41= ';'
						{
							otherlv_41=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_41, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_1());

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
	// $ANTLR end "ruleAttributeCS"


	// $ANTLR start "entryRuleCompoundTargetElementCS"
	// InternalQVTbase.g:593:1: entryRuleCompoundTargetElementCS returns [EObject current=null] : iv_ruleCompoundTargetElementCS= ruleCompoundTargetElementCS EOF ;
	public final EObject entryRuleCompoundTargetElementCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCompoundTargetElementCS = null;


		try {
			// InternalQVTbase.g:594:2: (iv_ruleCompoundTargetElementCS= ruleCompoundTargetElementCS EOF )
			// InternalQVTbase.g:595:2: iv_ruleCompoundTargetElementCS= ruleCompoundTargetElementCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getCompoundTargetElementCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleCompoundTargetElementCS=ruleCompoundTargetElementCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleCompoundTargetElementCS;
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
	// $ANTLR end "entryRuleCompoundTargetElementCS"


	// $ANTLR start "ruleCompoundTargetElementCS"
	// InternalQVTbase.g:602:1: ruleCompoundTargetElementCS returns [EObject current=null] : (otherlv_0= '{' ( (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS ) )* otherlv_2= '}' (otherlv_3= ';' )? ) ;
	public final EObject ruleCompoundTargetElementCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_2=null;
		Token otherlv_3=null;
		EObject lv_ownedTargetElements_1_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:605:28: ( (otherlv_0= '{' ( (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS ) )* otherlv_2= '}' (otherlv_3= ';' )? ) )
			// InternalQVTbase.g:606:1: (otherlv_0= '{' ( (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS ) )* otherlv_2= '}' (otherlv_3= ';' )? )
			{
				// InternalQVTbase.g:606:1: (otherlv_0= '{' ( (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS ) )* otherlv_2= '}' (otherlv_3= ';' )? )
				// InternalQVTbase.g:606:3: otherlv_0= '{' ( (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS ) )* otherlv_2= '}' (otherlv_3= ';' )?
				{
					otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_20); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getCompoundTargetElementCSAccess().getLeftCurlyBracketKeyword_0());

					}
					// InternalQVTbase.g:610:1: ( (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS ) )*
					loop16:
						do {
							int alt16=2;
							int LA16_0 = input.LA(1);

							if ( ((LA16_0>=61 && LA16_0<=63)) ) {
								alt16=1;
							}


							switch (alt16) {
								case 1 :
									// InternalQVTbase.g:611:1: (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS )
								{
									// InternalQVTbase.g:611:1: (lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS )
									// InternalQVTbase.g:612:3: lv_ownedTargetElements_1_0= ruleSimpleTargetElementCS
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getCompoundTargetElementCSAccess().getOwnedTargetElementsSimpleTargetElementCSParserRuleCall_1_0());

										}
										pushFollow(FollowSets000.FOLLOW_20);
										lv_ownedTargetElements_1_0=ruleSimpleTargetElementCS();

										state._fsp--;
										if (state.failed) return current;
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElementForParent(grammarAccess.getCompoundTargetElementCSRule());
											}
											add(
												current,
												"ownedTargetElements",
												lv_ownedTargetElements_1_0,
													"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SimpleTargetElementCS");
											afterParserOrEnumRuleCall();

										}

									}


								}
								break;

								default :
									break loop16;
							}
						} while (true);

					otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_21); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_2, grammarAccess.getCompoundTargetElementCSAccess().getRightCurlyBracketKeyword_2());

					}
					// InternalQVTbase.g:632:1: (otherlv_3= ';' )?
					int alt17=2;
					int LA17_0 = input.LA(1);

					if ( (LA17_0==42) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// InternalQVTbase.g:632:3: otherlv_3= ';'
						{
							otherlv_3=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_3, grammarAccess.getCompoundTargetElementCSAccess().getSemicolonKeyword_3());

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
	// $ANTLR end "ruleCompoundTargetElementCS"


	// $ANTLR start "entryRuleDataTypeCS"
	// InternalQVTbase.g:644:1: entryRuleDataTypeCS returns [EObject current=null] : iv_ruleDataTypeCS= ruleDataTypeCS EOF ;
	public final EObject entryRuleDataTypeCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleDataTypeCS = null;


		try {
			// InternalQVTbase.g:645:2: (iv_ruleDataTypeCS= ruleDataTypeCS EOF )
			// InternalQVTbase.g:646:2: iv_ruleDataTypeCS= ruleDataTypeCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getDataTypeCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleDataTypeCS=ruleDataTypeCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleDataTypeCS;
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
	// $ANTLR end "entryRuleDataTypeCS"


	// $ANTLR start "ruleDataTypeCS"
	// InternalQVTbase.g:653:1: ruleDataTypeCS returns [EObject current=null] : ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) ) ;
	public final EObject ruleDataTypeCS() throws RecognitionException {
		EObject current = null;

		Token lv_isPrimitive_0_0=null;
		Token otherlv_1=null;
		Token otherlv_4=null;
		Token lv_instanceClassName_5_0=null;
		Token otherlv_6=null;
		Token lv_isSerializable_7_0=null;
		Token otherlv_8=null;
		Token otherlv_9=null;
		Token otherlv_10=null;
		Token otherlv_11=null;
		Token otherlv_12=null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;

		EObject lv_ownedSignature_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:656:28: ( ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) ) )
			// InternalQVTbase.g:657:1: ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) )
			{
				// InternalQVTbase.g:657:1: ( ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' ) )
				// InternalQVTbase.g:657:2: ( (lv_isPrimitive_0_0= 'primitive' ) )? otherlv_1= 'datatype' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )? ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' )
				{
					// InternalQVTbase.g:657:2: ( (lv_isPrimitive_0_0= 'primitive' ) )?
					int alt18=2;
					int LA18_0 = input.LA(1);

					if ( (LA18_0==44) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// InternalQVTbase.g:658:1: (lv_isPrimitive_0_0= 'primitive' )
						{
							// InternalQVTbase.g:658:1: (lv_isPrimitive_0_0= 'primitive' )
							// InternalQVTbase.g:659:3: lv_isPrimitive_0_0= 'primitive'
							{
								lv_isPrimitive_0_0=(Token)match(input,44,FollowSets000.FOLLOW_22); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(lv_isPrimitive_0_0, grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0());

								}
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElement(grammarAccess.getDataTypeCSRule());
									}
									setWithLastConsumed(current, "isPrimitive", true, "primitive");

								}

							}


						}
						break;

					}

					otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getDataTypeCSAccess().getDatatypeKeyword_1());

					}
					// InternalQVTbase.g:676:1: ( (lv_name_2_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:677:1: (lv_name_2_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:677:1: (lv_name_2_0= ruleUnrestrictedName )
						// InternalQVTbase.g:678:3: lv_name_2_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getDataTypeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

							}
							pushFollow(FollowSets000.FOLLOW_23);
							lv_name_2_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getDataTypeCSRule());
								}
								set(
									current,
									"name",
									lv_name_2_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:694:2: ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )?
					int alt19=2;
					int LA19_0 = input.LA(1);

					if ( (LA19_0==51) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// InternalQVTbase.g:695:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
						{
							// InternalQVTbase.g:695:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
							// InternalQVTbase.g:696:3: lv_ownedSignature_3_0= ruleTemplateSignatureCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getDataTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());

								}
								pushFollow(FollowSets000.FOLLOW_24);
								lv_ownedSignature_3_0=ruleTemplateSignatureCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getDataTypeCSRule());
									}
									set(
										current,
										"ownedSignature",
										lv_ownedSignature_3_0,
										"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
									afterParserOrEnumRuleCall();

								}

							}


						}
						break;

					}

					// InternalQVTbase.g:712:3: (otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) ) )?
					int alt20=2;
					int LA20_0 = input.LA(1);

					if ( (LA20_0==20) ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// InternalQVTbase.g:712:5: otherlv_4= ':' ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) )
						{
							otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_10); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_4, grammarAccess.getDataTypeCSAccess().getColonKeyword_4_0());

							}
							// InternalQVTbase.g:716:1: ( (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING ) )
							// InternalQVTbase.g:717:1: (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING )
							{
								// InternalQVTbase.g:717:1: (lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING )
								// InternalQVTbase.g:718:3: lv_instanceClassName_5_0= RULE_SINGLE_QUOTED_STRING
								{
									lv_instanceClassName_5_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_11); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_instanceClassName_5_0, grammarAccess.getDataTypeCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getDataTypeCSRule());
										}
										setWithLastConsumed(
											current,
											"instanceClassName",
											lv_instanceClassName_5_0,
											"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:734:4: (otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}' )?
					int alt22=2;
					int LA22_0 = input.LA(1);

					if ( (LA22_0==22) ) {
						int LA22_1 = input.LA(2);

						if ( (LA22_1==40) ) {
							int LA22_3 = input.LA(3);

							if ( (LA22_3==22||LA22_3==42) ) {
								alt22=1;
							}
						}
						else if ( ((LA22_1>=46 && LA22_1<=47)) ) {
							alt22=1;
						}
					}
					switch (alt22) {
						case 1 :
							// InternalQVTbase.g:734:6: otherlv_6= '{' ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )? otherlv_9= '}'
						{
							otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_25); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_6, grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_5_0());

							}
							// InternalQVTbase.g:738:1: ( ( (lv_isSerializable_7_0= 'serializable' ) ) | otherlv_8= '!serializable' )?
							int alt21=3;
							int LA21_0 = input.LA(1);

							if ( (LA21_0==46) ) {
								alt21=1;
							}
							else if ( (LA21_0==47) ) {
								alt21=2;
							}
							switch (alt21) {
								case 1 :
									// InternalQVTbase.g:738:2: ( (lv_isSerializable_7_0= 'serializable' ) )
								{
									// InternalQVTbase.g:738:2: ( (lv_isSerializable_7_0= 'serializable' ) )
									// InternalQVTbase.g:739:1: (lv_isSerializable_7_0= 'serializable' )
									{
										// InternalQVTbase.g:739:1: (lv_isSerializable_7_0= 'serializable' )
										// InternalQVTbase.g:740:3: lv_isSerializable_7_0= 'serializable'
										{
											lv_isSerializable_7_0=(Token)match(input,46,FollowSets000.FOLLOW_26); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_isSerializable_7_0, grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getDataTypeCSRule());
												}
												setWithLastConsumed(current, "isSerializable", true, "serializable");

											}

										}


									}


								}
								break;
								case 2 :
									// InternalQVTbase.g:754:7: otherlv_8= '!serializable'
								{
									otherlv_8=(Token)match(input,47,FollowSets000.FOLLOW_26); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_8, grammarAccess.getDataTypeCSAccess().getSerializableKeyword_5_1_1());

									}

								}
								break;

							}

							otherlv_9=(Token)match(input,40,FollowSets000.FOLLOW_11); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_9, grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_5_2());

							}

						}
						break;

					}

					// InternalQVTbase.g:762:3: ( (otherlv_10= '{' otherlv_11= '}' ) | otherlv_12= ';' )
					int alt23=2;
					int LA23_0 = input.LA(1);

					if ( (LA23_0==22) ) {
						alt23=1;
					}
					else if ( (LA23_0==42) ) {
						alt23=2;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 23, 0, input);

						throw nvae;
					}
					switch (alt23) {
						case 1 :
							// InternalQVTbase.g:762:4: (otherlv_10= '{' otherlv_11= '}' )
						{
							// InternalQVTbase.g:762:4: (otherlv_10= '{' otherlv_11= '}' )
							// InternalQVTbase.g:762:6: otherlv_10= '{' otherlv_11= '}'
							{
								otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_26); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_10, grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0());

								}
								otherlv_11=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_11, grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_1());

								}

							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:771:7: otherlv_12= ';'
						{
							otherlv_12=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_12, grammarAccess.getDataTypeCSAccess().getSemicolonKeyword_6_1());

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
	// $ANTLR end "ruleDataTypeCS"


	// $ANTLR start "entryRuleEnumerationCS"
	// InternalQVTbase.g:783:1: entryRuleEnumerationCS returns [EObject current=null] : iv_ruleEnumerationCS= ruleEnumerationCS EOF ;
	public final EObject entryRuleEnumerationCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleEnumerationCS = null;


		try {
			// InternalQVTbase.g:784:2: (iv_ruleEnumerationCS= ruleEnumerationCS EOF )
			// InternalQVTbase.g:785:2: iv_ruleEnumerationCS= ruleEnumerationCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getEnumerationCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleEnumerationCS=ruleEnumerationCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleEnumerationCS;
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
	// $ANTLR end "entryRuleEnumerationCS"


	// $ANTLR start "ruleEnumerationCS"
	// InternalQVTbase.g:792:1: ruleEnumerationCS returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) ) ;
	public final EObject ruleEnumerationCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_3=null;
		Token lv_instanceClassName_4_0=null;
		Token otherlv_5=null;
		Token lv_isSerializable_6_0=null;
		Token otherlv_7=null;
		Token otherlv_8=null;
		Token otherlv_9=null;
		Token otherlv_11=null;
		Token otherlv_12=null;
		AntlrDatatypeRuleToken lv_name_1_0 = null;

		EObject lv_ownedSignature_2_0 = null;

		EObject lv_ownedLiterals_10_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:795:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) ) )
			// InternalQVTbase.g:796:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) )
			{
				// InternalQVTbase.g:796:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' ) )
				// InternalQVTbase.g:796:3: otherlv_0= 'enum' ( (lv_name_1_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )? (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )? ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' )
				{
					otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getEnumerationCSAccess().getEnumKeyword_0());

					}
					// InternalQVTbase.g:800:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:801:1: (lv_name_1_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:801:1: (lv_name_1_0= ruleUnrestrictedName )
						// InternalQVTbase.g:802:3: lv_name_1_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getEnumerationCSAccess().getNameUnrestrictedNameParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_23);
							lv_name_1_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:818:2: ( (lv_ownedSignature_2_0= ruleTemplateSignatureCS ) )?
					int alt24=2;
					int LA24_0 = input.LA(1);

					if ( (LA24_0==51) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// InternalQVTbase.g:819:1: (lv_ownedSignature_2_0= ruleTemplateSignatureCS )
						{
							// InternalQVTbase.g:819:1: (lv_ownedSignature_2_0= ruleTemplateSignatureCS )
							// InternalQVTbase.g:820:3: lv_ownedSignature_2_0= ruleTemplateSignatureCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getEnumerationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0());

								}
								pushFollow(FollowSets000.FOLLOW_24);
								lv_ownedSignature_2_0=ruleTemplateSignatureCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
									}
									set(
										current,
										"ownedSignature",
										lv_ownedSignature_2_0,
										"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
									afterParserOrEnumRuleCall();

								}

							}


						}
						break;

					}

					// InternalQVTbase.g:836:3: (otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) ) )?
					int alt25=2;
					int LA25_0 = input.LA(1);

					if ( (LA25_0==20) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// InternalQVTbase.g:836:5: otherlv_3= ':' ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) )
						{
							otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_10); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_3, grammarAccess.getEnumerationCSAccess().getColonKeyword_3_0());

							}
							// InternalQVTbase.g:840:1: ( (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING ) )
							// InternalQVTbase.g:841:1: (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING )
							{
								// InternalQVTbase.g:841:1: (lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING )
								// InternalQVTbase.g:842:3: lv_instanceClassName_4_0= RULE_SINGLE_QUOTED_STRING
								{
									lv_instanceClassName_4_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_11); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_instanceClassName_4_0, grammarAccess.getEnumerationCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getEnumerationCSRule());
										}
										setWithLastConsumed(
											current,
											"instanceClassName",
											lv_instanceClassName_4_0,
											"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:858:4: (otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}' )?
					int alt27=2;
					int LA27_0 = input.LA(1);

					if ( (LA27_0==22) ) {
						int LA27_1 = input.LA(2);

						if ( ((LA27_1>=46 && LA27_1<=47)) ) {
							alt27=1;
						}
						else if ( (LA27_1==40) ) {
							int LA27_4 = input.LA(3);

							if ( (LA27_4==22||LA27_4==42) ) {
								alt27=1;
							}
						}
					}
					switch (alt27) {
						case 1 :
							// InternalQVTbase.g:858:6: otherlv_5= '{' ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )? otherlv_8= '}'
						{
							otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_25); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_5, grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_4_0());

							}
							// InternalQVTbase.g:862:1: ( ( (lv_isSerializable_6_0= 'serializable' ) ) | otherlv_7= '!serializable' )?
							int alt26=3;
							int LA26_0 = input.LA(1);

							if ( (LA26_0==46) ) {
								alt26=1;
							}
							else if ( (LA26_0==47) ) {
								alt26=2;
							}
							switch (alt26) {
								case 1 :
									// InternalQVTbase.g:862:2: ( (lv_isSerializable_6_0= 'serializable' ) )
								{
									// InternalQVTbase.g:862:2: ( (lv_isSerializable_6_0= 'serializable' ) )
									// InternalQVTbase.g:863:1: (lv_isSerializable_6_0= 'serializable' )
									{
										// InternalQVTbase.g:863:1: (lv_isSerializable_6_0= 'serializable' )
										// InternalQVTbase.g:864:3: lv_isSerializable_6_0= 'serializable'
										{
											lv_isSerializable_6_0=(Token)match(input,46,FollowSets000.FOLLOW_26); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_isSerializable_6_0, grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getEnumerationCSRule());
												}
												setWithLastConsumed(current, "isSerializable", true, "serializable");

											}

										}


									}


								}
								break;
								case 2 :
									// InternalQVTbase.g:878:7: otherlv_7= '!serializable'
								{
									otherlv_7=(Token)match(input,47,FollowSets000.FOLLOW_26); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_7, grammarAccess.getEnumerationCSAccess().getSerializableKeyword_4_1_1());

									}

								}
								break;

							}

							otherlv_8=(Token)match(input,40,FollowSets000.FOLLOW_11); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_8, grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_4_2());

							}

						}
						break;

					}

					// InternalQVTbase.g:886:3: ( (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' ) | otherlv_12= ';' )
					int alt29=2;
					int LA29_0 = input.LA(1);

					if ( (LA29_0==22) ) {
						alt29=1;
					}
					else if ( (LA29_0==42) ) {
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
							// InternalQVTbase.g:886:4: (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' )
						{
							// InternalQVTbase.g:886:4: (otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}' )
							// InternalQVTbase.g:886:6: otherlv_9= '{' ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )* otherlv_11= '}'
							{
								otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_27); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_9, grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_5_0_0());

								}
								// InternalQVTbase.g:890:1: ( (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS ) )*
								loop28:
									do {
										int alt28=2;
										int LA28_0 = input.LA(1);

										if ( ((LA28_0>=RULE_SIMPLE_ID && LA28_0<=RULE_ESCAPED_ID)||LA28_0==49) ) {
											alt28=1;
										}


										switch (alt28) {
											case 1 :
												// InternalQVTbase.g:891:1: (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS )
											{
												// InternalQVTbase.g:891:1: (lv_ownedLiterals_10_0= ruleEnumerationLiteralCS )
												// InternalQVTbase.g:892:3: lv_ownedLiterals_10_0= ruleEnumerationLiteralCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_27);
													lv_ownedLiterals_10_0=ruleEnumerationLiteralCS();

													state._fsp--;
													if (state.failed) return current;
													if ( state.backtracking==0 ) {

														if (current==null) {
															current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
														}
														add(
															current,
															"ownedLiterals",
															lv_ownedLiterals_10_0,
															"org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralCS");
														afterParserOrEnumRuleCall();

													}

												}


											}
											break;

											default :
												break loop28;
										}
									} while (true);

								otherlv_11=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_11, grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_5_0_2());

								}

							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:913:7: otherlv_12= ';'
						{
							otherlv_12=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_12, grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_5_1());

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
	// $ANTLR end "ruleEnumerationCS"


	// $ANTLR start "entryRuleEnumerationLiteralCS"
	// InternalQVTbase.g:925:1: entryRuleEnumerationLiteralCS returns [EObject current=null] : iv_ruleEnumerationLiteralCS= ruleEnumerationLiteralCS EOF ;
	public final EObject entryRuleEnumerationLiteralCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleEnumerationLiteralCS = null;


		try {
			// InternalQVTbase.g:926:2: (iv_ruleEnumerationLiteralCS= ruleEnumerationLiteralCS EOF )
			// InternalQVTbase.g:927:2: iv_ruleEnumerationLiteralCS= ruleEnumerationLiteralCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getEnumerationLiteralCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleEnumerationLiteralCS=ruleEnumerationLiteralCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleEnumerationLiteralCS;
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
	// $ANTLR end "entryRuleEnumerationLiteralCS"


	// $ANTLR start "ruleEnumerationLiteralCS"
	// InternalQVTbase.g:934:1: ruleEnumerationLiteralCS returns [EObject current=null] : ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) ) ;
	public final EObject ruleEnumerationLiteralCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_6=null;
		Token otherlv_7=null;
		AntlrDatatypeRuleToken lv_name_1_0 = null;

		AntlrDatatypeRuleToken lv_name_2_0 = null;

		AntlrDatatypeRuleToken lv_value_4_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:937:28: ( ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) ) )
			// InternalQVTbase.g:938:1: ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) )
			{
				// InternalQVTbase.g:938:1: ( ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' ) )
				// InternalQVTbase.g:938:2: ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) ) (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )? ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' )
				{
					// InternalQVTbase.g:938:2: ( (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) ) | ( (lv_name_2_0= ruleEnumerationLiteralName ) ) )
					int alt30=2;
					int LA30_0 = input.LA(1);

					if ( (LA30_0==49) ) {
						alt30=1;
					}
					else if ( ((LA30_0>=RULE_SIMPLE_ID && LA30_0<=RULE_ESCAPED_ID)) ) {
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
							// InternalQVTbase.g:938:3: (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) )
						{
							// InternalQVTbase.g:938:3: (otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) ) )
							// InternalQVTbase.g:938:5: otherlv_0= 'literal' ( (lv_name_1_0= ruleUnrestrictedName ) )
							{
								otherlv_0=(Token)match(input,49,FollowSets000.FOLLOW_6); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_0, grammarAccess.getEnumerationLiteralCSAccess().getLiteralKeyword_0_0_0());

								}
								// InternalQVTbase.g:942:1: ( (lv_name_1_0= ruleUnrestrictedName ) )
								// InternalQVTbase.g:943:1: (lv_name_1_0= ruleUnrestrictedName )
								{
									// InternalQVTbase.g:943:1: (lv_name_1_0= ruleUnrestrictedName )
									// InternalQVTbase.g:944:3: lv_name_1_0= ruleUnrestrictedName
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_1_0());

										}
										pushFollow(FollowSets000.FOLLOW_9);
										lv_name_1_0=ruleUnrestrictedName();

										state._fsp--;
										if (state.failed) return current;
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
											}
											set(
												current,
												"name",
												lv_name_1_0,
												"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
											afterParserOrEnumRuleCall();

										}

									}


								}


							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:961:6: ( (lv_name_2_0= ruleEnumerationLiteralName ) )
						{
							// InternalQVTbase.g:961:6: ( (lv_name_2_0= ruleEnumerationLiteralName ) )
							// InternalQVTbase.g:962:1: (lv_name_2_0= ruleEnumerationLiteralName )
							{
								// InternalQVTbase.g:962:1: (lv_name_2_0= ruleEnumerationLiteralName )
								// InternalQVTbase.g:963:3: lv_name_2_0= ruleEnumerationLiteralName
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getNameEnumerationLiteralNameParserRuleCall_0_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_9);
									lv_name_2_0=ruleEnumerationLiteralName();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
										}
										set(
											current,
											"name",
											lv_name_2_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralName");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:979:3: (otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) ) )?
					int alt31=2;
					int LA31_0 = input.LA(1);

					if ( (LA31_0==21) ) {
						alt31=1;
					}
					switch (alt31) {
						case 1 :
							// InternalQVTbase.g:979:5: otherlv_3= '=' ( (lv_value_4_0= ruleSIGNED ) )
						{
							otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_28); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_3, grammarAccess.getEnumerationLiteralCSAccess().getEqualsSignKeyword_1_0());

							}
							// InternalQVTbase.g:983:1: ( (lv_value_4_0= ruleSIGNED ) )
							// InternalQVTbase.g:984:1: (lv_value_4_0= ruleSIGNED )
							{
								// InternalQVTbase.g:984:1: (lv_value_4_0= ruleSIGNED )
								// InternalQVTbase.g:985:3: lv_value_4_0= ruleSIGNED
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getValueSIGNEDParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_11);
									lv_value_4_0=ruleSIGNED();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
										}
										set(
											current,
											"value",
											lv_value_4_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SIGNED");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:1001:4: ( (otherlv_5= '{' otherlv_6= '}' ) | otherlv_7= ';' )
					int alt32=2;
					int LA32_0 = input.LA(1);

					if ( (LA32_0==22) ) {
						alt32=1;
					}
					else if ( (LA32_0==42) ) {
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
							// InternalQVTbase.g:1001:5: (otherlv_5= '{' otherlv_6= '}' )
						{
							// InternalQVTbase.g:1001:5: (otherlv_5= '{' otherlv_6= '}' )
							// InternalQVTbase.g:1001:7: otherlv_5= '{' otherlv_6= '}'
							{
								otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_26); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_5, grammarAccess.getEnumerationLiteralCSAccess().getLeftCurlyBracketKeyword_2_0_0());

								}
								otherlv_6=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_6, grammarAccess.getEnumerationLiteralCSAccess().getRightCurlyBracketKeyword_2_0_1());

								}

							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:1010:7: otherlv_7= ';'
						{
							otherlv_7=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_7, grammarAccess.getEnumerationLiteralCSAccess().getSemicolonKeyword_2_1());

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
	// $ANTLR end "ruleEnumerationLiteralCS"


	// $ANTLR start "entryRuleOperationCS"
	// InternalQVTbase.g:1022:1: entryRuleOperationCS returns [EObject current=null] : iv_ruleOperationCS= ruleOperationCS EOF ;
	public final EObject entryRuleOperationCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleOperationCS = null;


		try {
			// InternalQVTbase.g:1023:2: (iv_ruleOperationCS= ruleOperationCS EOF )
			// InternalQVTbase.g:1024:2: iv_ruleOperationCS= ruleOperationCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getOperationCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleOperationCS=ruleOperationCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleOperationCS;
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
	// $ANTLR end "entryRuleOperationCS"


	// $ANTLR start "ruleOperationCS"
	// InternalQVTbase.g:1031:1: ruleOperationCS returns [EObject current=null] : ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) ) ;
	public final EObject ruleOperationCS() throws RecognitionException {
		EObject current = null;

		Token lv_qualifiers_0_0=null;
		Token lv_qualifiers_1_0=null;
		Token lv_qualifiers_2_0=null;
		Token lv_qualifiers_3_0=null;
		Token otherlv_4=null;
		Token otherlv_7=null;
		Token otherlv_9=null;
		Token otherlv_11=null;
		Token otherlv_12=null;
		Token otherlv_14=null;
		Token otherlv_16=null;
		Token otherlv_18=null;
		Token lv_qualifiers_19_0=null;
		Token lv_qualifiers_20_0=null;
		Token lv_qualifiers_21_0=null;
		Token lv_qualifiers_22_0=null;
		Token lv_qualifiers_23_0=null;
		Token lv_qualifiers_24_0=null;
		Token otherlv_25=null;
		Token otherlv_26=null;
		Token otherlv_27=null;
		Token otherlv_28=null;
		Token otherlv_30=null;
		Token otherlv_32=null;
		Token otherlv_33=null;
		Token otherlv_34=null;
		EObject lv_ownedSignature_5_0 = null;

		AntlrDatatypeRuleToken lv_name_6_0 = null;

		EObject lv_ownedParameters_8_0 = null;

		EObject lv_ownedParameters_10_0 = null;

		EObject lv_ownedType_13_0 = null;

		EObject lv_ownedExceptions_15_0 = null;

		EObject lv_ownedExceptions_17_0 = null;

		EObject lv_ownedBodyExpressions_31_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:1034:28: ( ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) ) )
			// InternalQVTbase.g:1035:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) )
			{
				// InternalQVTbase.g:1035:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' ) )
				// InternalQVTbase.g:1035:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'operation' ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )? ( (lv_name_6_0= ruleUnrestrictedName ) ) otherlv_7= '(' ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )? otherlv_11= ')' (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )? (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )? ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' )
				{
					// InternalQVTbase.g:1035:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )?
					int alt35=3;
					int LA35_0 = input.LA(1);

					if ( (LA35_0==17) ) {
						alt35=1;
					}
					else if ( (LA35_0==18) ) {
						alt35=2;
					}
					switch (alt35) {
						case 1 :
							// InternalQVTbase.g:1035:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
						{
							// InternalQVTbase.g:1035:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
							// InternalQVTbase.g:1035:4: ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )?
							{
								// InternalQVTbase.g:1035:4: ( (lv_qualifiers_0_0= 'static' ) )
								// InternalQVTbase.g:1036:1: (lv_qualifiers_0_0= 'static' )
								{
									// InternalQVTbase.g:1036:1: (lv_qualifiers_0_0= 'static' )
									// InternalQVTbase.g:1037:3: lv_qualifiers_0_0= 'static'
									{
										lv_qualifiers_0_0=(Token)match(input,17,FollowSets000.FOLLOW_29); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(lv_qualifiers_0_0, grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0());

										}
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElement(grammarAccess.getOperationCSRule());
											}
											addWithLastConsumed(current, "qualifiers", lv_qualifiers_0_0, "static");

										}

									}


								}

								// InternalQVTbase.g:1050:2: ( (lv_qualifiers_1_0= 'definition' ) )?
								int alt33=2;
								int LA33_0 = input.LA(1);

								if ( (LA33_0==18) ) {
									alt33=1;
								}
								switch (alt33) {
									case 1 :
										// InternalQVTbase.g:1051:1: (lv_qualifiers_1_0= 'definition' )
									{
										// InternalQVTbase.g:1051:1: (lv_qualifiers_1_0= 'definition' )
										// InternalQVTbase.g:1052:3: lv_qualifiers_1_0= 'definition'
										{
											lv_qualifiers_1_0=(Token)match(input,18,FollowSets000.FOLLOW_30); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_qualifiers_1_0, grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getOperationCSRule());
												}
												addWithLastConsumed(current, "qualifiers", lv_qualifiers_1_0, "definition");

											}

										}


									}
									break;

								}


							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:1066:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
						{
							// InternalQVTbase.g:1066:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
							// InternalQVTbase.g:1066:7: ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )?
							{
								// InternalQVTbase.g:1066:7: ( (lv_qualifiers_2_0= 'definition' ) )
								// InternalQVTbase.g:1067:1: (lv_qualifiers_2_0= 'definition' )
								{
									// InternalQVTbase.g:1067:1: (lv_qualifiers_2_0= 'definition' )
									// InternalQVTbase.g:1068:3: lv_qualifiers_2_0= 'definition'
									{
										lv_qualifiers_2_0=(Token)match(input,18,FollowSets000.FOLLOW_31); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(lv_qualifiers_2_0, grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());

										}
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElement(grammarAccess.getOperationCSRule());
											}
											addWithLastConsumed(current, "qualifiers", lv_qualifiers_2_0, "definition");

										}

									}


								}

								// InternalQVTbase.g:1081:2: ( (lv_qualifiers_3_0= 'static' ) )?
								int alt34=2;
								int LA34_0 = input.LA(1);

								if ( (LA34_0==17) ) {
									alt34=1;
								}
								switch (alt34) {
									case 1 :
										// InternalQVTbase.g:1082:1: (lv_qualifiers_3_0= 'static' )
									{
										// InternalQVTbase.g:1082:1: (lv_qualifiers_3_0= 'static' )
										// InternalQVTbase.g:1083:3: lv_qualifiers_3_0= 'static'
										{
											lv_qualifiers_3_0=(Token)match(input,17,FollowSets000.FOLLOW_30); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_qualifiers_3_0, grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getOperationCSRule());
												}
												addWithLastConsumed(current, "qualifiers", lv_qualifiers_3_0, "static");

											}

										}


									}
									break;

								}


							}


						}
						break;

					}

					otherlv_4=(Token)match(input,50,FollowSets000.FOLLOW_32); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_4, grammarAccess.getOperationCSAccess().getOperationKeyword_1());

					}
					// InternalQVTbase.g:1100:1: ( (lv_ownedSignature_5_0= ruleTemplateSignatureCS ) )?
					int alt36=2;
					int LA36_0 = input.LA(1);

					if ( (LA36_0==51) ) {
						alt36=1;
					}
					switch (alt36) {
						case 1 :
							// InternalQVTbase.g:1101:1: (lv_ownedSignature_5_0= ruleTemplateSignatureCS )
						{
							// InternalQVTbase.g:1101:1: (lv_ownedSignature_5_0= ruleTemplateSignatureCS )
							// InternalQVTbase.g:1102:3: lv_ownedSignature_5_0= ruleTemplateSignatureCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0());

								}
								pushFollow(FollowSets000.FOLLOW_6);
								lv_ownedSignature_5_0=ruleTemplateSignatureCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getOperationCSRule());
									}
									set(
										current,
										"ownedSignature",
										lv_ownedSignature_5_0,
										"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
									afterParserOrEnumRuleCall();

								}

							}


						}
						break;

					}

					// InternalQVTbase.g:1118:3: ( (lv_name_6_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:1119:1: (lv_name_6_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:1119:1: (lv_name_6_0= ruleUnrestrictedName )
						// InternalQVTbase.g:1120:3: lv_name_6_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getOperationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0());

							}
							pushFollow(FollowSets000.FOLLOW_33);
							lv_name_6_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getOperationCSRule());
								}
								set(
									current,
									"name",
									lv_name_6_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_7=(Token)match(input,51,FollowSets000.FOLLOW_34); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_7, grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_4());

					}
					// InternalQVTbase.g:1140:1: ( ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )* )?
					int alt38=2;
					int LA38_0 = input.LA(1);

					if ( ((LA38_0>=RULE_SIMPLE_ID && LA38_0<=RULE_ESCAPED_ID)) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// InternalQVTbase.g:1140:2: ( (lv_ownedParameters_8_0= ruleParameterCS ) ) (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )*
						{
							// InternalQVTbase.g:1140:2: ( (lv_ownedParameters_8_0= ruleParameterCS ) )
							// InternalQVTbase.g:1141:1: (lv_ownedParameters_8_0= ruleParameterCS )
							{
								// InternalQVTbase.g:1141:1: (lv_ownedParameters_8_0= ruleParameterCS )
								// InternalQVTbase.g:1142:3: lv_ownedParameters_8_0= ruleParameterCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_35);
									lv_ownedParameters_8_0=ruleParameterCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getOperationCSRule());
										}
										add(
											current,
											"ownedParameters",
											lv_ownedParameters_8_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.ParameterCS");
										afterParserOrEnumRuleCall();

									}

								}


							}

							// InternalQVTbase.g:1158:2: (otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) ) )*
							loop37:
								do {
									int alt37=2;
									int LA37_0 = input.LA(1);

									if ( (LA37_0==39) ) {
										alt37=1;
									}


									switch (alt37) {
										case 1 :
											// InternalQVTbase.g:1158:4: otherlv_9= ',' ( (lv_ownedParameters_10_0= ruleParameterCS ) )
										{
											otherlv_9=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_9, grammarAccess.getOperationCSAccess().getCommaKeyword_5_1_0());

											}
											// InternalQVTbase.g:1162:1: ( (lv_ownedParameters_10_0= ruleParameterCS ) )
											// InternalQVTbase.g:1163:1: (lv_ownedParameters_10_0= ruleParameterCS )
											{
												// InternalQVTbase.g:1163:1: (lv_ownedParameters_10_0= ruleParameterCS )
												// InternalQVTbase.g:1164:3: lv_ownedParameters_10_0= ruleParameterCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_35);
													lv_ownedParameters_10_0=ruleParameterCS();

													state._fsp--;
													if (state.failed) return current;
													if ( state.backtracking==0 ) {

														if (current==null) {
															current = createModelElementForParent(grammarAccess.getOperationCSRule());
														}
														add(
															current,
															"ownedParameters",
															lv_ownedParameters_10_0,
															"org.eclipse.qvtd.xtext.qvtbase.QVTbase.ParameterCS");
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

					otherlv_11=(Token)match(input,52,FollowSets000.FOLLOW_36); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_11, grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_6());

					}
					// InternalQVTbase.g:1184:1: (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) ) )?
					int alt39=2;
					int LA39_0 = input.LA(1);

					if ( (LA39_0==20) ) {
						alt39=1;
					}
					switch (alt39) {
						case 1 :
							// InternalQVTbase.g:1184:3: otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) )
						{
							otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_12, grammarAccess.getOperationCSAccess().getColonKeyword_7_0());

							}
							// InternalQVTbase.g:1188:1: ( (lv_ownedType_13_0= ruleTypedMultiplicityRefCS ) )
							// InternalQVTbase.g:1189:1: (lv_ownedType_13_0= ruleTypedMultiplicityRefCS )
							{
								// InternalQVTbase.g:1189:1: (lv_ownedType_13_0= ruleTypedMultiplicityRefCS )
								// InternalQVTbase.g:1190:3: lv_ownedType_13_0= ruleTypedMultiplicityRefCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_37);
									lv_ownedType_13_0=ruleTypedMultiplicityRefCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getOperationCSRule());
										}
										set(
											current,
											"ownedType",
											lv_ownedType_13_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:1206:4: (otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )* )?
					int alt41=2;
					int LA41_0 = input.LA(1);

					if ( (LA41_0==53) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// InternalQVTbase.g:1206:6: otherlv_14= 'throws' ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) ) (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )*
						{
							otherlv_14=(Token)match(input,53,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_14, grammarAccess.getOperationCSAccess().getThrowsKeyword_8_0());

							}
							// InternalQVTbase.g:1210:1: ( (lv_ownedExceptions_15_0= ruleTypedRefCS ) )
							// InternalQVTbase.g:1211:1: (lv_ownedExceptions_15_0= ruleTypedRefCS )
							{
								// InternalQVTbase.g:1211:1: (lv_ownedExceptions_15_0= ruleTypedRefCS )
								// InternalQVTbase.g:1212:3: lv_ownedExceptions_15_0= ruleTypedRefCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_38);
									lv_ownedExceptions_15_0=ruleTypedRefCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getOperationCSRule());
										}
										add(
											current,
											"ownedExceptions",
											lv_ownedExceptions_15_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
										afterParserOrEnumRuleCall();

									}

								}


							}

							// InternalQVTbase.g:1228:2: (otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) ) )*
							loop40:
								do {
									int alt40=2;
									int LA40_0 = input.LA(1);

									if ( (LA40_0==39) ) {
										alt40=1;
									}


									switch (alt40) {
										case 1 :
											// InternalQVTbase.g:1228:4: otherlv_16= ',' ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) )
										{
											otherlv_16=(Token)match(input,39,FollowSets000.FOLLOW_8); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_16, grammarAccess.getOperationCSAccess().getCommaKeyword_8_2_0());

											}
											// InternalQVTbase.g:1232:1: ( (lv_ownedExceptions_17_0= ruleTypedRefCS ) )
											// InternalQVTbase.g:1233:1: (lv_ownedExceptions_17_0= ruleTypedRefCS )
											{
												// InternalQVTbase.g:1233:1: (lv_ownedExceptions_17_0= ruleTypedRefCS )
												// InternalQVTbase.g:1234:3: lv_ownedExceptions_17_0= ruleTypedRefCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_38);
													lv_ownedExceptions_17_0=ruleTypedRefCS();

													state._fsp--;
													if (state.failed) return current;
													if ( state.backtracking==0 ) {

														if (current==null) {
															current = createModelElementForParent(grammarAccess.getOperationCSRule());
														}
														add(
															current,
															"ownedExceptions",
															lv_ownedExceptions_17_0,
															"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
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


						}
						break;

					}

					// InternalQVTbase.g:1250:6: (otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}' )?
					int alt45=2;
					int LA45_0 = input.LA(1);

					if ( (LA45_0==22) ) {
						int LA45_1 = input.LA(2);

						if ( ((LA45_1>=23 && LA45_1<=24)||(LA45_1>=27 && LA45_1<=28)||(LA45_1>=33 && LA45_1<=34)) ) {
							alt45=1;
						}
					}
					switch (alt45) {
						case 1 :
							// InternalQVTbase.g:1250:8: otherlv_18= '{' ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+ otherlv_26= '}'
						{
							otherlv_18=(Token)match(input,22,FollowSets000.FOLLOW_39); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_18, grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0());

							}
							// InternalQVTbase.g:1254:1: ( ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )? )+
							int cnt44=0;
							loop44:
								do {
									int alt44=2;
									int LA44_0 = input.LA(1);

									if ( ((LA44_0>=23 && LA44_0<=24)||(LA44_0>=27 && LA44_0<=28)||(LA44_0>=33 && LA44_0<=34)) ) {
										alt44=1;
									}


									switch (alt44) {
										case 1 :
											// InternalQVTbase.g:1254:2: ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) ) (otherlv_25= ',' )?
										{
											// InternalQVTbase.g:1254:2: ( ( (lv_qualifiers_19_0= 'derived' ) ) | ( (lv_qualifiers_20_0= '!derived' ) ) | ( (lv_qualifiers_21_0= 'ordered' ) ) | ( (lv_qualifiers_22_0= '!ordered' ) ) | ( (lv_qualifiers_23_0= 'unique' ) ) | ( (lv_qualifiers_24_0= '!unique' ) ) )
											int alt42=6;
											switch ( input.LA(1) ) {
												case 23:
												{
													alt42=1;
												}
												break;
												case 24:
												{
													alt42=2;
												}
												break;
												case 27:
												{
													alt42=3;
												}
												break;
												case 28:
												{
													alt42=4;
												}
												break;
												case 33:
												{
													alt42=5;
												}
												break;
												case 34:
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
													// InternalQVTbase.g:1254:3: ( (lv_qualifiers_19_0= 'derived' ) )
												{
													// InternalQVTbase.g:1254:3: ( (lv_qualifiers_19_0= 'derived' ) )
													// InternalQVTbase.g:1255:1: (lv_qualifiers_19_0= 'derived' )
													{
														// InternalQVTbase.g:1255:1: (lv_qualifiers_19_0= 'derived' )
														// InternalQVTbase.g:1256:3: lv_qualifiers_19_0= 'derived'
														{
															lv_qualifiers_19_0=(Token)match(input,23,FollowSets000.FOLLOW_40); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_19_0, grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getOperationCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_19_0, "derived");

															}

														}


													}


												}
												break;
												case 2 :
													// InternalQVTbase.g:1270:6: ( (lv_qualifiers_20_0= '!derived' ) )
												{
													// InternalQVTbase.g:1270:6: ( (lv_qualifiers_20_0= '!derived' ) )
													// InternalQVTbase.g:1271:1: (lv_qualifiers_20_0= '!derived' )
													{
														// InternalQVTbase.g:1271:1: (lv_qualifiers_20_0= '!derived' )
														// InternalQVTbase.g:1272:3: lv_qualifiers_20_0= '!derived'
														{
															lv_qualifiers_20_0=(Token)match(input,24,FollowSets000.FOLLOW_40); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_20_0, grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getOperationCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_20_0, "!derived");

															}

														}


													}


												}
												break;
												case 3 :
													// InternalQVTbase.g:1286:6: ( (lv_qualifiers_21_0= 'ordered' ) )
												{
													// InternalQVTbase.g:1286:6: ( (lv_qualifiers_21_0= 'ordered' ) )
													// InternalQVTbase.g:1287:1: (lv_qualifiers_21_0= 'ordered' )
													{
														// InternalQVTbase.g:1287:1: (lv_qualifiers_21_0= 'ordered' )
														// InternalQVTbase.g:1288:3: lv_qualifiers_21_0= 'ordered'
														{
															lv_qualifiers_21_0=(Token)match(input,27,FollowSets000.FOLLOW_40); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_21_0, grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getOperationCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_21_0, "ordered");

															}

														}


													}


												}
												break;
												case 4 :
													// InternalQVTbase.g:1302:6: ( (lv_qualifiers_22_0= '!ordered' ) )
												{
													// InternalQVTbase.g:1302:6: ( (lv_qualifiers_22_0= '!ordered' ) )
													// InternalQVTbase.g:1303:1: (lv_qualifiers_22_0= '!ordered' )
													{
														// InternalQVTbase.g:1303:1: (lv_qualifiers_22_0= '!ordered' )
														// InternalQVTbase.g:1304:3: lv_qualifiers_22_0= '!ordered'
														{
															lv_qualifiers_22_0=(Token)match(input,28,FollowSets000.FOLLOW_40); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_22_0, grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getOperationCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_22_0, "!ordered");

															}

														}


													}


												}
												break;
												case 5 :
													// InternalQVTbase.g:1318:6: ( (lv_qualifiers_23_0= 'unique' ) )
												{
													// InternalQVTbase.g:1318:6: ( (lv_qualifiers_23_0= 'unique' ) )
													// InternalQVTbase.g:1319:1: (lv_qualifiers_23_0= 'unique' )
													{
														// InternalQVTbase.g:1319:1: (lv_qualifiers_23_0= 'unique' )
														// InternalQVTbase.g:1320:3: lv_qualifiers_23_0= 'unique'
														{
															lv_qualifiers_23_0=(Token)match(input,33,FollowSets000.FOLLOW_40); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_23_0, grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_4_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getOperationCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_23_0, "unique");

															}

														}


													}


												}
												break;
												case 6 :
													// InternalQVTbase.g:1334:6: ( (lv_qualifiers_24_0= '!unique' ) )
												{
													// InternalQVTbase.g:1334:6: ( (lv_qualifiers_24_0= '!unique' ) )
													// InternalQVTbase.g:1335:1: (lv_qualifiers_24_0= '!unique' )
													{
														// InternalQVTbase.g:1335:1: (lv_qualifiers_24_0= '!unique' )
														// InternalQVTbase.g:1336:3: lv_qualifiers_24_0= '!unique'
														{
															lv_qualifiers_24_0=(Token)match(input,34,FollowSets000.FOLLOW_40); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_24_0, grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_5_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getOperationCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_24_0, "!unique");

															}

														}


													}


												}
												break;

											}

											// InternalQVTbase.g:1349:3: (otherlv_25= ',' )?
											int alt43=2;
											int LA43_0 = input.LA(1);

											if ( (LA43_0==39) ) {
												alt43=1;
											}
											switch (alt43) {
												case 1 :
													// InternalQVTbase.g:1349:5: otherlv_25= ','
													{
														otherlv_25=(Token)match(input,39,FollowSets000.FOLLOW_41); if (state.failed) return current;
														if ( state.backtracking==0 ) {

															newLeafNode(otherlv_25, grammarAccess.getOperationCSAccess().getCommaKeyword_9_1_1());

														}

													}
													break;

											}


										}
										break;

										default :
											if ( cnt44 >= 1 ) break loop44;
											if (state.backtracking>0) {state.failed=true; return current;}
											EarlyExitException eee =
													new EarlyExitException(44, input);
											throw eee;
									}
									cnt44++;
								} while (true);

							otherlv_26=(Token)match(input,40,FollowSets000.FOLLOW_11); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_26, grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_9_2());

							}

						}
						break;

					}

					// InternalQVTbase.g:1357:3: ( (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' ) | otherlv_34= ';' )
					int alt49=2;
					int LA49_0 = input.LA(1);

					if ( (LA49_0==22) ) {
						alt49=1;
					}
					else if ( (LA49_0==42) ) {
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
							// InternalQVTbase.g:1357:4: (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' )
						{
							// InternalQVTbase.g:1357:4: (otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}' )
							// InternalQVTbase.g:1357:6: otherlv_27= '{' (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )* otherlv_33= '}'
							{
								otherlv_27=(Token)match(input,22,FollowSets000.FOLLOW_42); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_27, grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_10_0_0());

								}
								// InternalQVTbase.g:1361:1: (otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';' )*
								loop48:
									do {
										int alt48=2;
										int LA48_0 = input.LA(1);

										if ( (LA48_0==54) ) {
											alt48=1;
										}


										switch (alt48) {
											case 1 :
												// InternalQVTbase.g:1361:3: otherlv_28= 'body' ( ruleUnrestrictedName )? otherlv_30= ':' ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )? otherlv_32= ';'
											{
												otherlv_28=(Token)match(input,54,FollowSets000.FOLLOW_16); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_28, grammarAccess.getOperationCSAccess().getBodyKeyword_10_0_1_0());

												}
												// InternalQVTbase.g:1365:1: ( ruleUnrestrictedName )?
												int alt46=2;
												int LA46_0 = input.LA(1);

												if ( ((LA46_0>=RULE_SIMPLE_ID && LA46_0<=RULE_ESCAPED_ID)) ) {
													alt46=1;
												}
												switch (alt46) {
													case 1 :
														// InternalQVTbase.g:1366:2: ruleUnrestrictedName
													{
														if ( state.backtracking==0 ) {

															/* */

														}
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getOperationCSAccess().getUnrestrictedNameParserRuleCall_10_0_1_1());

														}
														pushFollow(FollowSets000.FOLLOW_17);
														ruleUnrestrictedName();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															afterParserOrEnumRuleCall();

														}

													}
													break;

												}

												otherlv_30=(Token)match(input,20,FollowSets000.FOLLOW_18); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_30, grammarAccess.getOperationCSAccess().getColonKeyword_10_0_1_2());

												}
												// InternalQVTbase.g:1380:1: ( (lv_ownedBodyExpressions_31_0= ruleSpecificationCS ) )?
												int alt47=2;
												int LA47_0 = input.LA(1);

												if ( ((LA47_0>=RULE_SINGLE_QUOTED_STRING && LA47_0<=RULE_ESCAPED_ID)||LA47_0==51||(LA47_0>=69 && LA47_0<=72)||(LA47_0>=92 && LA47_0<=106)||LA47_0==109||(LA47_0>=111 && LA47_0<=114)||LA47_0==121||(LA47_0>=126 && LA47_0<=127)) ) {
													alt47=1;
												}
												switch (alt47) {
													case 1 :
														// InternalQVTbase.g:1381:1: (lv_ownedBodyExpressions_31_0= ruleSpecificationCS )
													{
														// InternalQVTbase.g:1381:1: (lv_ownedBodyExpressions_31_0= ruleSpecificationCS )
														// InternalQVTbase.g:1382:3: lv_ownedBodyExpressions_31_0= ruleSpecificationCS
														{
															if ( state.backtracking==0 ) {

																newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0());

															}
															pushFollow(FollowSets000.FOLLOW_19);
															lv_ownedBodyExpressions_31_0=ruleSpecificationCS();

															state._fsp--;
															if (state.failed) return current;
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElementForParent(grammarAccess.getOperationCSRule());
																}
																add(
																	current,
																	"ownedBodyExpressions",
																	lv_ownedBodyExpressions_31_0,
																	"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
																afterParserOrEnumRuleCall();

															}

														}


													}
													break;

												}

												otherlv_32=(Token)match(input,42,FollowSets000.FOLLOW_42); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_32, grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_0_1_4());

												}

											}
											break;

											default :
												break loop48;
										}
									} while (true);

								otherlv_33=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_33, grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_10_0_2());

								}

							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:1407:7: otherlv_34= ';'
						{
							otherlv_34=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_34, grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_1());

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
	// $ANTLR end "ruleOperationCS"


	// $ANTLR start "entryRuleParameterCS"
	// InternalQVTbase.g:1419:1: entryRuleParameterCS returns [EObject current=null] : iv_ruleParameterCS= ruleParameterCS EOF ;
	public final EObject entryRuleParameterCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleParameterCS = null;


		try {
			// InternalQVTbase.g:1420:2: (iv_ruleParameterCS= ruleParameterCS EOF )
			// InternalQVTbase.g:1421:2: iv_ruleParameterCS= ruleParameterCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getParameterCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleParameterCS=ruleParameterCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleParameterCS;
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
	// $ANTLR end "entryRuleParameterCS"


	// $ANTLR start "ruleParameterCS"
	// InternalQVTbase.g:1428:1: ruleParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? ) ;
	public final EObject ruleParameterCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_3=null;
		Token lv_qualifiers_4_0=null;
		Token lv_qualifiers_5_0=null;
		Token lv_qualifiers_6_0=null;
		Token lv_qualifiers_7_0=null;
		Token otherlv_8=null;
		Token otherlv_9=null;
		Token otherlv_10=null;
		Token otherlv_11=null;
		AntlrDatatypeRuleToken lv_name_0_0 = null;

		EObject lv_ownedType_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:1431:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? ) )
			// InternalQVTbase.g:1432:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? )
			{
				// InternalQVTbase.g:1432:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )? )
				// InternalQVTbase.g:1432:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )? (otherlv_10= '{' otherlv_11= '}' )?
				{
					// InternalQVTbase.g:1432:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:1433:1: (lv_name_0_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:1433:1: (lv_name_0_0= ruleUnrestrictedName )
						// InternalQVTbase.g:1434:3: lv_name_0_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_43);
							lv_name_0_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getParameterCSRule());
								}
								set(
									current,
									"name",
									lv_name_0_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:1450:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) ) )?
					int alt50=2;
					int LA50_0 = input.LA(1);

					if ( (LA50_0==20) ) {
						alt50=1;
					}
					switch (alt50) {
						case 1 :
							// InternalQVTbase.g:1450:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) )
						{
							otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getParameterCSAccess().getColonKeyword_1_0());

							}
							// InternalQVTbase.g:1454:1: ( (lv_ownedType_2_0= ruleTypedMultiplicityRefCS ) )
							// InternalQVTbase.g:1455:1: (lv_ownedType_2_0= ruleTypedMultiplicityRefCS )
							{
								// InternalQVTbase.g:1455:1: (lv_ownedType_2_0= ruleTypedMultiplicityRefCS )
								// InternalQVTbase.g:1456:3: lv_ownedType_2_0= ruleTypedMultiplicityRefCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_44);
									lv_ownedType_2_0=ruleTypedMultiplicityRefCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getParameterCSRule());
										}
										set(
											current,
											"ownedType",
											lv_ownedType_2_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:1472:4: (otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}' )?
					int alt54=2;
					int LA54_0 = input.LA(1);

					if ( (LA54_0==22) ) {
						int LA54_1 = input.LA(2);

						if ( ((LA54_1>=27 && LA54_1<=28)||(LA54_1>=33 && LA54_1<=34)) ) {
							alt54=1;
						}
					}
					switch (alt54) {
						case 1 :
							// InternalQVTbase.g:1472:6: otherlv_3= '{' ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+ otherlv_9= '}'
						{
							otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_45); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_3, grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_2_0());

							}
							// InternalQVTbase.g:1476:1: ( ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )? )+
							int cnt53=0;
							loop53:
								do {
									int alt53=2;
									int LA53_0 = input.LA(1);

									if ( ((LA53_0>=27 && LA53_0<=28)||(LA53_0>=33 && LA53_0<=34)) ) {
										alt53=1;
									}


									switch (alt53) {
										case 1 :
											// InternalQVTbase.g:1476:2: ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) ) (otherlv_8= ',' )?
										{
											// InternalQVTbase.g:1476:2: ( ( (lv_qualifiers_4_0= 'ordered' ) ) | ( (lv_qualifiers_5_0= '!ordered' ) ) | ( (lv_qualifiers_6_0= 'unique' ) ) | ( (lv_qualifiers_7_0= '!unique' ) ) )
											int alt51=4;
											switch ( input.LA(1) ) {
												case 27:
												{
													alt51=1;
												}
												break;
												case 28:
												{
													alt51=2;
												}
												break;
												case 33:
												{
													alt51=3;
												}
												break;
												case 34:
												{
													alt51=4;
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
													// InternalQVTbase.g:1476:3: ( (lv_qualifiers_4_0= 'ordered' ) )
												{
													// InternalQVTbase.g:1476:3: ( (lv_qualifiers_4_0= 'ordered' ) )
													// InternalQVTbase.g:1477:1: (lv_qualifiers_4_0= 'ordered' )
													{
														// InternalQVTbase.g:1477:1: (lv_qualifiers_4_0= 'ordered' )
														// InternalQVTbase.g:1478:3: lv_qualifiers_4_0= 'ordered'
														{
															lv_qualifiers_4_0=(Token)match(input,27,FollowSets000.FOLLOW_46); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_4_0, grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getParameterCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_4_0, "ordered");

															}

														}


													}


												}
												break;
												case 2 :
													// InternalQVTbase.g:1492:6: ( (lv_qualifiers_5_0= '!ordered' ) )
												{
													// InternalQVTbase.g:1492:6: ( (lv_qualifiers_5_0= '!ordered' ) )
													// InternalQVTbase.g:1493:1: (lv_qualifiers_5_0= '!ordered' )
													{
														// InternalQVTbase.g:1493:1: (lv_qualifiers_5_0= '!ordered' )
														// InternalQVTbase.g:1494:3: lv_qualifiers_5_0= '!ordered'
														{
															lv_qualifiers_5_0=(Token)match(input,28,FollowSets000.FOLLOW_46); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_5_0, grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getParameterCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_5_0, "!ordered");

															}

														}


													}


												}
												break;
												case 3 :
													// InternalQVTbase.g:1508:6: ( (lv_qualifiers_6_0= 'unique' ) )
												{
													// InternalQVTbase.g:1508:6: ( (lv_qualifiers_6_0= 'unique' ) )
													// InternalQVTbase.g:1509:1: (lv_qualifiers_6_0= 'unique' )
													{
														// InternalQVTbase.g:1509:1: (lv_qualifiers_6_0= 'unique' )
														// InternalQVTbase.g:1510:3: lv_qualifiers_6_0= 'unique'
														{
															lv_qualifiers_6_0=(Token)match(input,33,FollowSets000.FOLLOW_46); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_6_0, grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getParameterCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_6_0, "unique");

															}

														}


													}


												}
												break;
												case 4 :
													// InternalQVTbase.g:1524:6: ( (lv_qualifiers_7_0= '!unique' ) )
												{
													// InternalQVTbase.g:1524:6: ( (lv_qualifiers_7_0= '!unique' ) )
													// InternalQVTbase.g:1525:1: (lv_qualifiers_7_0= '!unique' )
													{
														// InternalQVTbase.g:1525:1: (lv_qualifiers_7_0= '!unique' )
														// InternalQVTbase.g:1526:3: lv_qualifiers_7_0= '!unique'
														{
															lv_qualifiers_7_0=(Token)match(input,34,FollowSets000.FOLLOW_46); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_7_0, grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getParameterCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_7_0, "!unique");

															}

														}


													}


												}
												break;

											}

											// InternalQVTbase.g:1539:3: (otherlv_8= ',' )?
											int alt52=2;
											int LA52_0 = input.LA(1);

											if ( (LA52_0==39) ) {
												alt52=1;
											}
											switch (alt52) {
												case 1 :
													// InternalQVTbase.g:1539:5: otherlv_8= ','
													{
														otherlv_8=(Token)match(input,39,FollowSets000.FOLLOW_47); if (state.failed) return current;
														if ( state.backtracking==0 ) {

															newLeafNode(otherlv_8, grammarAccess.getParameterCSAccess().getCommaKeyword_2_1_1());

														}

													}
													break;

											}


										}
										break;

										default :
											if ( cnt53 >= 1 ) break loop53;
											if (state.backtracking>0) {state.failed=true; return current;}
											EarlyExitException eee =
													new EarlyExitException(53, input);
											throw eee;
									}
									cnt53++;
								} while (true);

							otherlv_9=(Token)match(input,40,FollowSets000.FOLLOW_44); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_9, grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_2_2());

							}

						}
						break;

					}

					// InternalQVTbase.g:1547:3: (otherlv_10= '{' otherlv_11= '}' )?
					int alt55=2;
					int LA55_0 = input.LA(1);

					if ( (LA55_0==22) ) {
						alt55=1;
					}
					switch (alt55) {
						case 1 :
							// InternalQVTbase.g:1547:5: otherlv_10= '{' otherlv_11= '}'
						{
							otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_26); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_10, grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_3_0());

							}
							otherlv_11=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_11, grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_3_1());

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
	// $ANTLR end "ruleParameterCS"


	// $ANTLR start "entryRuleReferenceCS"
	// InternalQVTbase.g:1563:1: entryRuleReferenceCS returns [EObject current=null] : iv_ruleReferenceCS= ruleReferenceCS EOF ;
	public final EObject entryRuleReferenceCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleReferenceCS = null;


		try {
			// InternalQVTbase.g:1564:2: (iv_ruleReferenceCS= ruleReferenceCS EOF )
			// InternalQVTbase.g:1565:2: iv_ruleReferenceCS= ruleReferenceCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getReferenceCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleReferenceCS=ruleReferenceCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleReferenceCS;
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
	// $ANTLR end "entryRuleReferenceCS"


	// $ANTLR start "ruleReferenceCS"
	// InternalQVTbase.g:1572:1: ruleReferenceCS returns [EObject current=null] : ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) ) ;
	public final EObject ruleReferenceCS() throws RecognitionException {
		EObject current = null;

		Token lv_qualifiers_0_0=null;
		Token lv_qualifiers_1_0=null;
		Token lv_qualifiers_2_0=null;
		Token lv_qualifiers_3_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		Token lv_default_11_0=null;
		Token otherlv_12=null;
		Token lv_qualifiers_13_0=null;
		Token lv_qualifiers_14_0=null;
		Token lv_qualifiers_15_0=null;
		Token lv_qualifiers_16_0=null;
		Token lv_qualifiers_17_0=null;
		Token lv_qualifiers_18_0=null;
		Token lv_qualifiers_19_0=null;
		Token lv_qualifiers_20_0=null;
		Token lv_qualifiers_21_0=null;
		Token lv_qualifiers_22_0=null;
		Token lv_qualifiers_23_0=null;
		Token lv_qualifiers_24_0=null;
		Token lv_qualifiers_25_0=null;
		Token lv_qualifiers_26_0=null;
		Token lv_qualifiers_27_0=null;
		Token lv_qualifiers_28_0=null;
		Token lv_qualifiers_29_0=null;
		Token lv_qualifiers_30_0=null;
		Token otherlv_31=null;
		Token otherlv_32=null;
		Token otherlv_33=null;
		Token otherlv_34=null;
		Token otherlv_36=null;
		Token otherlv_38=null;
		Token otherlv_39=null;
		Token otherlv_41=null;
		Token otherlv_43=null;
		Token otherlv_44=null;
		Token otherlv_45=null;
		AntlrDatatypeRuleToken lv_name_5_0 = null;

		EObject lv_ownedType_9_0 = null;

		EObject lv_ownedDefaultExpressions_37_0 = null;

		EObject lv_ownedDefaultExpressions_42_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:1575:28: ( ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) ) )
			// InternalQVTbase.g:1576:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) )
			{
				// InternalQVTbase.g:1576:1: ( ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' ) )
				// InternalQVTbase.g:1576:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )? otherlv_4= 'property' ( (lv_name_5_0= ruleUnrestrictedName ) ) (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )? (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )? (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )? ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' )
				{
					// InternalQVTbase.g:1576:2: ( ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? ) | ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? ) )?
					int alt58=3;
					int LA58_0 = input.LA(1);

					if ( (LA58_0==17) ) {
						alt58=1;
					}
					else if ( (LA58_0==18) ) {
						alt58=2;
					}
					switch (alt58) {
						case 1 :
							// InternalQVTbase.g:1576:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
						{
							// InternalQVTbase.g:1576:3: ( ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )? )
							// InternalQVTbase.g:1576:4: ( (lv_qualifiers_0_0= 'static' ) ) ( (lv_qualifiers_1_0= 'definition' ) )?
							{
								// InternalQVTbase.g:1576:4: ( (lv_qualifiers_0_0= 'static' ) )
								// InternalQVTbase.g:1577:1: (lv_qualifiers_0_0= 'static' )
								{
									// InternalQVTbase.g:1577:1: (lv_qualifiers_0_0= 'static' )
									// InternalQVTbase.g:1578:3: lv_qualifiers_0_0= 'static'
									{
										lv_qualifiers_0_0=(Token)match(input,17,FollowSets000.FOLLOW_48); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(lv_qualifiers_0_0, grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0());

										}
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElement(grammarAccess.getReferenceCSRule());
											}
											addWithLastConsumed(current, "qualifiers", lv_qualifiers_0_0, "static");

										}

									}


								}

								// InternalQVTbase.g:1591:2: ( (lv_qualifiers_1_0= 'definition' ) )?
								int alt56=2;
								int LA56_0 = input.LA(1);

								if ( (LA56_0==18) ) {
									alt56=1;
								}
								switch (alt56) {
									case 1 :
										// InternalQVTbase.g:1592:1: (lv_qualifiers_1_0= 'definition' )
									{
										// InternalQVTbase.g:1592:1: (lv_qualifiers_1_0= 'definition' )
										// InternalQVTbase.g:1593:3: lv_qualifiers_1_0= 'definition'
										{
											lv_qualifiers_1_0=(Token)match(input,18,FollowSets000.FOLLOW_49); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_qualifiers_1_0, grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getReferenceCSRule());
												}
												addWithLastConsumed(current, "qualifiers", lv_qualifiers_1_0, "definition");

											}

										}


									}
									break;

								}


							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:1607:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
						{
							// InternalQVTbase.g:1607:6: ( ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )? )
							// InternalQVTbase.g:1607:7: ( (lv_qualifiers_2_0= 'definition' ) ) ( (lv_qualifiers_3_0= 'static' ) )?
							{
								// InternalQVTbase.g:1607:7: ( (lv_qualifiers_2_0= 'definition' ) )
								// InternalQVTbase.g:1608:1: (lv_qualifiers_2_0= 'definition' )
								{
									// InternalQVTbase.g:1608:1: (lv_qualifiers_2_0= 'definition' )
									// InternalQVTbase.g:1609:3: lv_qualifiers_2_0= 'definition'
									{
										lv_qualifiers_2_0=(Token)match(input,18,FollowSets000.FOLLOW_50); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(lv_qualifiers_2_0, grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());

										}
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElement(grammarAccess.getReferenceCSRule());
											}
											addWithLastConsumed(current, "qualifiers", lv_qualifiers_2_0, "definition");

										}

									}


								}

								// InternalQVTbase.g:1622:2: ( (lv_qualifiers_3_0= 'static' ) )?
								int alt57=2;
								int LA57_0 = input.LA(1);

								if ( (LA57_0==17) ) {
									alt57=1;
								}
								switch (alt57) {
									case 1 :
										// InternalQVTbase.g:1623:1: (lv_qualifiers_3_0= 'static' )
									{
										// InternalQVTbase.g:1623:1: (lv_qualifiers_3_0= 'static' )
										// InternalQVTbase.g:1624:3: lv_qualifiers_3_0= 'static'
										{
											lv_qualifiers_3_0=(Token)match(input,17,FollowSets000.FOLLOW_49); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(lv_qualifiers_3_0, grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0());

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getReferenceCSRule());
												}
												addWithLastConsumed(current, "qualifiers", lv_qualifiers_3_0, "static");

											}

										}


									}
									break;

								}


							}


						}
						break;

					}

					otherlv_4=(Token)match(input,55,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_4, grammarAccess.getReferenceCSAccess().getPropertyKeyword_1());

					}
					// InternalQVTbase.g:1641:1: ( (lv_name_5_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:1642:1: (lv_name_5_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:1642:1: (lv_name_5_0= ruleUnrestrictedName )
						// InternalQVTbase.g:1643:3: lv_name_5_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getReferenceCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

							}
							pushFollow(FollowSets000.FOLLOW_51);
							lv_name_5_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getReferenceCSRule());
								}
								set(
									current,
									"name",
									lv_name_5_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:1659:2: (otherlv_6= '#' ( ( ruleUnrestrictedName ) ) )?
					int alt59=2;
					int LA59_0 = input.LA(1);

					if ( (LA59_0==56) ) {
						alt59=1;
					}
					switch (alt59) {
						case 1 :
							// InternalQVTbase.g:1659:4: otherlv_6= '#' ( ( ruleUnrestrictedName ) )
						{
							otherlv_6=(Token)match(input,56,FollowSets000.FOLLOW_6); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_6, grammarAccess.getReferenceCSAccess().getNumberSignKeyword_3_0());

							}
							// InternalQVTbase.g:1663:1: ( ( ruleUnrestrictedName ) )
							// InternalQVTbase.g:1664:1: ( ruleUnrestrictedName )
							{
								// InternalQVTbase.g:1664:1: ( ruleUnrestrictedName )
								// InternalQVTbase.g:1665:3: ruleUnrestrictedName
								{
									if ( state.backtracking==0 ) {

										/* */

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getReferenceCSRule());
										}

									}
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyCrossReference_3_1_0());

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

					// InternalQVTbase.g:1681:4: (otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) ) )?
					int alt60=2;
					int LA60_0 = input.LA(1);

					if ( (LA60_0==20) ) {
						alt60=1;
					}
					switch (alt60) {
						case 1 :
							// InternalQVTbase.g:1681:6: otherlv_8= ':' ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) )
						{
							otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_8, grammarAccess.getReferenceCSAccess().getColonKeyword_4_0());

							}
							// InternalQVTbase.g:1685:1: ( (lv_ownedType_9_0= ruleTypedMultiplicityRefCS ) )
							// InternalQVTbase.g:1686:1: (lv_ownedType_9_0= ruleTypedMultiplicityRefCS )
							{
								// InternalQVTbase.g:1686:1: (lv_ownedType_9_0= ruleTypedMultiplicityRefCS )
								// InternalQVTbase.g:1687:3: lv_ownedType_9_0= ruleTypedMultiplicityRefCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_9);
									lv_ownedType_9_0=ruleTypedMultiplicityRefCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getReferenceCSRule());
										}
										set(
											current,
											"ownedType",
											lv_ownedType_9_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:1703:4: (otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) ) )?
					int alt61=2;
					int LA61_0 = input.LA(1);

					if ( (LA61_0==21) ) {
						alt61=1;
					}
					switch (alt61) {
						case 1 :
							// InternalQVTbase.g:1703:6: otherlv_10= '=' ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) )
						{
							otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_10); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_10, grammarAccess.getReferenceCSAccess().getEqualsSignKeyword_5_0());

							}
							// InternalQVTbase.g:1707:1: ( (lv_default_11_0= RULE_SINGLE_QUOTED_STRING ) )
							// InternalQVTbase.g:1708:1: (lv_default_11_0= RULE_SINGLE_QUOTED_STRING )
							{
								// InternalQVTbase.g:1708:1: (lv_default_11_0= RULE_SINGLE_QUOTED_STRING )
								// InternalQVTbase.g:1709:3: lv_default_11_0= RULE_SINGLE_QUOTED_STRING
								{
									lv_default_11_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_11); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_default_11_0, grammarAccess.getReferenceCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getReferenceCSRule());
										}
										setWithLastConsumed(
											current,
											"default",
											lv_default_11_0,
											"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:1725:4: (otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}' )?
					int alt65=2;
					int LA65_0 = input.LA(1);

					if ( (LA65_0==22) ) {
						int LA65_1 = input.LA(2);

						if ( ((LA65_1>=23 && LA65_1<=24)||(LA65_1>=27 && LA65_1<=38)||(LA65_1>=57 && LA65_1<=60)) ) {
							alt65=1;
						}
					}
					switch (alt65) {
						case 1 :
							// InternalQVTbase.g:1725:6: otherlv_12= '{' ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+ otherlv_32= '}'
						{
							otherlv_12=(Token)match(input,22,FollowSets000.FOLLOW_52); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_12, grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_6_0());

							}
							// InternalQVTbase.g:1729:1: ( ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )? )+
							int cnt64=0;
							loop64:
								do {
									int alt64=2;
									int LA64_0 = input.LA(1);

									if ( ((LA64_0>=23 && LA64_0<=24)||(LA64_0>=27 && LA64_0<=38)||(LA64_0>=57 && LA64_0<=60)) ) {
										alt64=1;
									}


									switch (alt64) {
										case 1 :
											// InternalQVTbase.g:1729:2: ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) ) (otherlv_31= ',' )?
										{
											// InternalQVTbase.g:1729:2: ( ( (lv_qualifiers_13_0= 'composes' ) ) | ( (lv_qualifiers_14_0= '!composes' ) ) | ( (lv_qualifiers_15_0= 'derived' ) ) | ( (lv_qualifiers_16_0= '!derived' ) ) | ( (lv_qualifiers_17_0= 'ordered' ) ) | ( (lv_qualifiers_18_0= '!ordered' ) ) | ( (lv_qualifiers_19_0= 'readonly' ) ) | ( (lv_qualifiers_20_0= '!readonly' ) ) | ( (lv_qualifiers_21_0= 'resolve' ) ) | ( (lv_qualifiers_22_0= '!resolve' ) ) | ( (lv_qualifiers_23_0= 'transient' ) ) | ( (lv_qualifiers_24_0= '!transient' ) ) | ( (lv_qualifiers_25_0= 'unique' ) ) | ( (lv_qualifiers_26_0= '!unique' ) ) | ( (lv_qualifiers_27_0= 'unsettable' ) ) | ( (lv_qualifiers_28_0= '!unsettable' ) ) | ( (lv_qualifiers_29_0= 'volatile' ) ) | ( (lv_qualifiers_30_0= '!volatile' ) ) )
											int alt62=18;
											switch ( input.LA(1) ) {
												case 57:
												{
													alt62=1;
												}
												break;
												case 58:
												{
													alt62=2;
												}
												break;
												case 23:
												{
													alt62=3;
												}
												break;
												case 24:
												{
													alt62=4;
												}
												break;
												case 27:
												{
													alt62=5;
												}
												break;
												case 28:
												{
													alt62=6;
												}
												break;
												case 29:
												{
													alt62=7;
												}
												break;
												case 30:
												{
													alt62=8;
												}
												break;
												case 59:
												{
													alt62=9;
												}
												break;
												case 60:
												{
													alt62=10;
												}
												break;
												case 31:
												{
													alt62=11;
												}
												break;
												case 32:
												{
													alt62=12;
												}
												break;
												case 33:
												{
													alt62=13;
												}
												break;
												case 34:
												{
													alt62=14;
												}
												break;
												case 35:
												{
													alt62=15;
												}
												break;
												case 36:
												{
													alt62=16;
												}
												break;
												case 37:
												{
													alt62=17;
												}
												break;
												case 38:
												{
													alt62=18;
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
													// InternalQVTbase.g:1729:3: ( (lv_qualifiers_13_0= 'composes' ) )
												{
													// InternalQVTbase.g:1729:3: ( (lv_qualifiers_13_0= 'composes' ) )
													// InternalQVTbase.g:1730:1: (lv_qualifiers_13_0= 'composes' )
													{
														// InternalQVTbase.g:1730:1: (lv_qualifiers_13_0= 'composes' )
														// InternalQVTbase.g:1731:3: lv_qualifiers_13_0= 'composes'
														{
															lv_qualifiers_13_0=(Token)match(input,57,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_13_0, grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_13_0, "composes");

															}

														}


													}


												}
												break;
												case 2 :
													// InternalQVTbase.g:1745:6: ( (lv_qualifiers_14_0= '!composes' ) )
												{
													// InternalQVTbase.g:1745:6: ( (lv_qualifiers_14_0= '!composes' ) )
													// InternalQVTbase.g:1746:1: (lv_qualifiers_14_0= '!composes' )
													{
														// InternalQVTbase.g:1746:1: (lv_qualifiers_14_0= '!composes' )
														// InternalQVTbase.g:1747:3: lv_qualifiers_14_0= '!composes'
														{
															lv_qualifiers_14_0=(Token)match(input,58,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_14_0, grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_14_0, "!composes");

															}

														}


													}


												}
												break;
												case 3 :
													// InternalQVTbase.g:1761:6: ( (lv_qualifiers_15_0= 'derived' ) )
												{
													// InternalQVTbase.g:1761:6: ( (lv_qualifiers_15_0= 'derived' ) )
													// InternalQVTbase.g:1762:1: (lv_qualifiers_15_0= 'derived' )
													{
														// InternalQVTbase.g:1762:1: (lv_qualifiers_15_0= 'derived' )
														// InternalQVTbase.g:1763:3: lv_qualifiers_15_0= 'derived'
														{
															lv_qualifiers_15_0=(Token)match(input,23,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_15_0, grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_15_0, "derived");

															}

														}


													}


												}
												break;
												case 4 :
													// InternalQVTbase.g:1777:6: ( (lv_qualifiers_16_0= '!derived' ) )
												{
													// InternalQVTbase.g:1777:6: ( (lv_qualifiers_16_0= '!derived' ) )
													// InternalQVTbase.g:1778:1: (lv_qualifiers_16_0= '!derived' )
													{
														// InternalQVTbase.g:1778:1: (lv_qualifiers_16_0= '!derived' )
														// InternalQVTbase.g:1779:3: lv_qualifiers_16_0= '!derived'
														{
															lv_qualifiers_16_0=(Token)match(input,24,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_16_0, grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_16_0, "!derived");

															}

														}


													}


												}
												break;
												case 5 :
													// InternalQVTbase.g:1793:6: ( (lv_qualifiers_17_0= 'ordered' ) )
												{
													// InternalQVTbase.g:1793:6: ( (lv_qualifiers_17_0= 'ordered' ) )
													// InternalQVTbase.g:1794:1: (lv_qualifiers_17_0= 'ordered' )
													{
														// InternalQVTbase.g:1794:1: (lv_qualifiers_17_0= 'ordered' )
														// InternalQVTbase.g:1795:3: lv_qualifiers_17_0= 'ordered'
														{
															lv_qualifiers_17_0=(Token)match(input,27,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_17_0, grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_17_0, "ordered");

															}

														}


													}


												}
												break;
												case 6 :
													// InternalQVTbase.g:1809:6: ( (lv_qualifiers_18_0= '!ordered' ) )
												{
													// InternalQVTbase.g:1809:6: ( (lv_qualifiers_18_0= '!ordered' ) )
													// InternalQVTbase.g:1810:1: (lv_qualifiers_18_0= '!ordered' )
													{
														// InternalQVTbase.g:1810:1: (lv_qualifiers_18_0= '!ordered' )
														// InternalQVTbase.g:1811:3: lv_qualifiers_18_0= '!ordered'
														{
															lv_qualifiers_18_0=(Token)match(input,28,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_18_0, grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_18_0, "!ordered");

															}

														}


													}


												}
												break;
												case 7 :
													// InternalQVTbase.g:1825:6: ( (lv_qualifiers_19_0= 'readonly' ) )
												{
													// InternalQVTbase.g:1825:6: ( (lv_qualifiers_19_0= 'readonly' ) )
													// InternalQVTbase.g:1826:1: (lv_qualifiers_19_0= 'readonly' )
													{
														// InternalQVTbase.g:1826:1: (lv_qualifiers_19_0= 'readonly' )
														// InternalQVTbase.g:1827:3: lv_qualifiers_19_0= 'readonly'
														{
															lv_qualifiers_19_0=(Token)match(input,29,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_19_0, grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_19_0, "readonly");

															}

														}


													}


												}
												break;
												case 8 :
													// InternalQVTbase.g:1841:6: ( (lv_qualifiers_20_0= '!readonly' ) )
												{
													// InternalQVTbase.g:1841:6: ( (lv_qualifiers_20_0= '!readonly' ) )
													// InternalQVTbase.g:1842:1: (lv_qualifiers_20_0= '!readonly' )
													{
														// InternalQVTbase.g:1842:1: (lv_qualifiers_20_0= '!readonly' )
														// InternalQVTbase.g:1843:3: lv_qualifiers_20_0= '!readonly'
														{
															lv_qualifiers_20_0=(Token)match(input,30,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_20_0, grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_20_0, "!readonly");

															}

														}


													}


												}
												break;
												case 9 :
													// InternalQVTbase.g:1857:6: ( (lv_qualifiers_21_0= 'resolve' ) )
												{
													// InternalQVTbase.g:1857:6: ( (lv_qualifiers_21_0= 'resolve' ) )
													// InternalQVTbase.g:1858:1: (lv_qualifiers_21_0= 'resolve' )
													{
														// InternalQVTbase.g:1858:1: (lv_qualifiers_21_0= 'resolve' )
														// InternalQVTbase.g:1859:3: lv_qualifiers_21_0= 'resolve'
														{
															lv_qualifiers_21_0=(Token)match(input,59,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_21_0, grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_21_0, "resolve");

															}

														}


													}


												}
												break;
												case 10 :
													// InternalQVTbase.g:1873:6: ( (lv_qualifiers_22_0= '!resolve' ) )
												{
													// InternalQVTbase.g:1873:6: ( (lv_qualifiers_22_0= '!resolve' ) )
													// InternalQVTbase.g:1874:1: (lv_qualifiers_22_0= '!resolve' )
													{
														// InternalQVTbase.g:1874:1: (lv_qualifiers_22_0= '!resolve' )
														// InternalQVTbase.g:1875:3: lv_qualifiers_22_0= '!resolve'
														{
															lv_qualifiers_22_0=(Token)match(input,60,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_22_0, grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_22_0, "!resolve");

															}

														}


													}


												}
												break;
												case 11 :
													// InternalQVTbase.g:1889:6: ( (lv_qualifiers_23_0= 'transient' ) )
												{
													// InternalQVTbase.g:1889:6: ( (lv_qualifiers_23_0= 'transient' ) )
													// InternalQVTbase.g:1890:1: (lv_qualifiers_23_0= 'transient' )
													{
														// InternalQVTbase.g:1890:1: (lv_qualifiers_23_0= 'transient' )
														// InternalQVTbase.g:1891:3: lv_qualifiers_23_0= 'transient'
														{
															lv_qualifiers_23_0=(Token)match(input,31,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_23_0, grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_23_0, "transient");

															}

														}


													}


												}
												break;
												case 12 :
													// InternalQVTbase.g:1905:6: ( (lv_qualifiers_24_0= '!transient' ) )
												{
													// InternalQVTbase.g:1905:6: ( (lv_qualifiers_24_0= '!transient' ) )
													// InternalQVTbase.g:1906:1: (lv_qualifiers_24_0= '!transient' )
													{
														// InternalQVTbase.g:1906:1: (lv_qualifiers_24_0= '!transient' )
														// InternalQVTbase.g:1907:3: lv_qualifiers_24_0= '!transient'
														{
															lv_qualifiers_24_0=(Token)match(input,32,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_24_0, grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_24_0, "!transient");

															}

														}


													}


												}
												break;
												case 13 :
													// InternalQVTbase.g:1921:6: ( (lv_qualifiers_25_0= 'unique' ) )
												{
													// InternalQVTbase.g:1921:6: ( (lv_qualifiers_25_0= 'unique' ) )
													// InternalQVTbase.g:1922:1: (lv_qualifiers_25_0= 'unique' )
													{
														// InternalQVTbase.g:1922:1: (lv_qualifiers_25_0= 'unique' )
														// InternalQVTbase.g:1923:3: lv_qualifiers_25_0= 'unique'
														{
															lv_qualifiers_25_0=(Token)match(input,33,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_25_0, grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_25_0, "unique");

															}

														}


													}


												}
												break;
												case 14 :
													// InternalQVTbase.g:1937:6: ( (lv_qualifiers_26_0= '!unique' ) )
												{
													// InternalQVTbase.g:1937:6: ( (lv_qualifiers_26_0= '!unique' ) )
													// InternalQVTbase.g:1938:1: (lv_qualifiers_26_0= '!unique' )
													{
														// InternalQVTbase.g:1938:1: (lv_qualifiers_26_0= '!unique' )
														// InternalQVTbase.g:1939:3: lv_qualifiers_26_0= '!unique'
														{
															lv_qualifiers_26_0=(Token)match(input,34,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_26_0, grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_26_0, "!unique");

															}

														}


													}


												}
												break;
												case 15 :
													// InternalQVTbase.g:1953:6: ( (lv_qualifiers_27_0= 'unsettable' ) )
												{
													// InternalQVTbase.g:1953:6: ( (lv_qualifiers_27_0= 'unsettable' ) )
													// InternalQVTbase.g:1954:1: (lv_qualifiers_27_0= 'unsettable' )
													{
														// InternalQVTbase.g:1954:1: (lv_qualifiers_27_0= 'unsettable' )
														// InternalQVTbase.g:1955:3: lv_qualifiers_27_0= 'unsettable'
														{
															lv_qualifiers_27_0=(Token)match(input,35,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_27_0, grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_27_0, "unsettable");

															}

														}


													}


												}
												break;
												case 16 :
													// InternalQVTbase.g:1969:6: ( (lv_qualifiers_28_0= '!unsettable' ) )
												{
													// InternalQVTbase.g:1969:6: ( (lv_qualifiers_28_0= '!unsettable' ) )
													// InternalQVTbase.g:1970:1: (lv_qualifiers_28_0= '!unsettable' )
													{
														// InternalQVTbase.g:1970:1: (lv_qualifiers_28_0= '!unsettable' )
														// InternalQVTbase.g:1971:3: lv_qualifiers_28_0= '!unsettable'
														{
															lv_qualifiers_28_0=(Token)match(input,36,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_28_0, grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_28_0, "!unsettable");

															}

														}


													}


												}
												break;
												case 17 :
													// InternalQVTbase.g:1985:6: ( (lv_qualifiers_29_0= 'volatile' ) )
												{
													// InternalQVTbase.g:1985:6: ( (lv_qualifiers_29_0= 'volatile' ) )
													// InternalQVTbase.g:1986:1: (lv_qualifiers_29_0= 'volatile' )
													{
														// InternalQVTbase.g:1986:1: (lv_qualifiers_29_0= 'volatile' )
														// InternalQVTbase.g:1987:3: lv_qualifiers_29_0= 'volatile'
														{
															lv_qualifiers_29_0=(Token)match(input,37,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_29_0, grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_29_0, "volatile");

															}

														}


													}


												}
												break;
												case 18 :
													// InternalQVTbase.g:2001:6: ( (lv_qualifiers_30_0= '!volatile' ) )
												{
													// InternalQVTbase.g:2001:6: ( (lv_qualifiers_30_0= '!volatile' ) )
													// InternalQVTbase.g:2002:1: (lv_qualifiers_30_0= '!volatile' )
													{
														// InternalQVTbase.g:2002:1: (lv_qualifiers_30_0= '!volatile' )
														// InternalQVTbase.g:2003:3: lv_qualifiers_30_0= '!volatile'
														{
															lv_qualifiers_30_0=(Token)match(input,38,FollowSets000.FOLLOW_53); if (state.failed) return current;
															if ( state.backtracking==0 ) {

																newLeafNode(lv_qualifiers_30_0, grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0());

															}
															if ( state.backtracking==0 ) {

																if (current==null) {
																	current = createModelElement(grammarAccess.getReferenceCSRule());
																}
																addWithLastConsumed(current, "qualifiers", lv_qualifiers_30_0, "!volatile");

															}

														}


													}


												}
												break;

											}

											// InternalQVTbase.g:2016:3: (otherlv_31= ',' )?
											int alt63=2;
											int LA63_0 = input.LA(1);

											if ( (LA63_0==39) ) {
												alt63=1;
											}
											switch (alt63) {
												case 1 :
													// InternalQVTbase.g:2016:5: otherlv_31= ','
													{
														otherlv_31=(Token)match(input,39,FollowSets000.FOLLOW_54); if (state.failed) return current;
														if ( state.backtracking==0 ) {

															newLeafNode(otherlv_31, grammarAccess.getReferenceCSAccess().getCommaKeyword_6_1_1());

														}

													}
													break;

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

							otherlv_32=(Token)match(input,40,FollowSets000.FOLLOW_11); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_32, grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_6_2());

							}

						}
						break;

					}

					// InternalQVTbase.g:2024:3: ( (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' ) | otherlv_45= ';' )
					int alt71=2;
					int LA71_0 = input.LA(1);

					if ( (LA71_0==22) ) {
						alt71=1;
					}
					else if ( (LA71_0==42) ) {
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
							// InternalQVTbase.g:2024:4: (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' )
						{
							// InternalQVTbase.g:2024:4: (otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}' )
							// InternalQVTbase.g:2024:6: otherlv_33= '{' ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )* otherlv_44= '}'
							{
								otherlv_33=(Token)match(input,22,FollowSets000.FOLLOW_15); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_33, grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0());

								}
								// InternalQVTbase.g:2028:1: ( (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' ) | (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' ) )*
								loop70:
									do {
										int alt70=3;
										int LA70_0 = input.LA(1);

										if ( (LA70_0==41) ) {
											alt70=1;
										}
										else if ( (LA70_0==43) ) {
											alt70=2;
										}


										switch (alt70) {
											case 1 :
												// InternalQVTbase.g:2028:2: (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' )
											{
												// InternalQVTbase.g:2028:2: (otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';' )
												// InternalQVTbase.g:2028:4: otherlv_34= 'initial' ( ruleUnrestrictedName )? otherlv_36= ':' ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )? otherlv_38= ';'
												{
													otherlv_34=(Token)match(input,41,FollowSets000.FOLLOW_16); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_34, grammarAccess.getReferenceCSAccess().getInitialKeyword_7_0_1_0_0());

													}
													// InternalQVTbase.g:2032:1: ( ruleUnrestrictedName )?
													int alt66=2;
													int LA66_0 = input.LA(1);

													if ( ((LA66_0>=RULE_SIMPLE_ID && LA66_0<=RULE_ESCAPED_ID)) ) {
														alt66=1;
													}
													switch (alt66) {
														case 1 :
															// InternalQVTbase.g:2033:2: ruleUnrestrictedName
														{
															if ( state.backtracking==0 ) {

																/* */

															}
															if ( state.backtracking==0 ) {

																newCompositeNode(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_0_1());

															}
															pushFollow(FollowSets000.FOLLOW_17);
															ruleUnrestrictedName();

															state._fsp--;
															if (state.failed) return current;
															if ( state.backtracking==0 ) {

																afterParserOrEnumRuleCall();

															}

														}
														break;

													}

													otherlv_36=(Token)match(input,20,FollowSets000.FOLLOW_18); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_36, grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_0_2());

													}
													// InternalQVTbase.g:2047:1: ( (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS ) )?
													int alt67=2;
													int LA67_0 = input.LA(1);

													if ( ((LA67_0>=RULE_SINGLE_QUOTED_STRING && LA67_0<=RULE_ESCAPED_ID)||LA67_0==51||(LA67_0>=69 && LA67_0<=72)||(LA67_0>=92 && LA67_0<=106)||LA67_0==109||(LA67_0>=111 && LA67_0<=114)||LA67_0==121||(LA67_0>=126 && LA67_0<=127)) ) {
														alt67=1;
													}
													switch (alt67) {
														case 1 :
															// InternalQVTbase.g:2048:1: (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS )
														{
															// InternalQVTbase.g:2048:1: (lv_ownedDefaultExpressions_37_0= ruleSpecificationCS )
															// InternalQVTbase.g:2049:3: lv_ownedDefaultExpressions_37_0= ruleSpecificationCS
															{
																if ( state.backtracking==0 ) {

																	newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0());

																}
																pushFollow(FollowSets000.FOLLOW_19);
																lv_ownedDefaultExpressions_37_0=ruleSpecificationCS();

																state._fsp--;
																if (state.failed) return current;
																if ( state.backtracking==0 ) {

																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getReferenceCSRule());
																	}
																	add(
																		current,
																		"ownedDefaultExpressions",
																		lv_ownedDefaultExpressions_37_0,
																		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
																	afterParserOrEnumRuleCall();

																}

															}


														}
														break;

													}

													otherlv_38=(Token)match(input,42,FollowSets000.FOLLOW_15); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_38, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_0_4());

													}

												}


											}
											break;
											case 2 :
												// InternalQVTbase.g:2070:6: (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' )
											{
												// InternalQVTbase.g:2070:6: (otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';' )
												// InternalQVTbase.g:2070:8: otherlv_39= 'derivation' ( ruleUnrestrictedName )? otherlv_41= ':' ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )? otherlv_43= ';'
												{
													otherlv_39=(Token)match(input,43,FollowSets000.FOLLOW_16); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_39, grammarAccess.getReferenceCSAccess().getDerivationKeyword_7_0_1_1_0());

													}
													// InternalQVTbase.g:2074:1: ( ruleUnrestrictedName )?
													int alt68=2;
													int LA68_0 = input.LA(1);

													if ( ((LA68_0>=RULE_SIMPLE_ID && LA68_0<=RULE_ESCAPED_ID)) ) {
														alt68=1;
													}
													switch (alt68) {
														case 1 :
															// InternalQVTbase.g:2075:2: ruleUnrestrictedName
														{
															if ( state.backtracking==0 ) {

																/* */

															}
															if ( state.backtracking==0 ) {

																newCompositeNode(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_1_1());

															}
															pushFollow(FollowSets000.FOLLOW_17);
															ruleUnrestrictedName();

															state._fsp--;
															if (state.failed) return current;
															if ( state.backtracking==0 ) {

																afterParserOrEnumRuleCall();

															}

														}
														break;

													}

													otherlv_41=(Token)match(input,20,FollowSets000.FOLLOW_18); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_41, grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_1_2());

													}
													// InternalQVTbase.g:2089:1: ( (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS ) )?
													int alt69=2;
													int LA69_0 = input.LA(1);

													if ( ((LA69_0>=RULE_SINGLE_QUOTED_STRING && LA69_0<=RULE_ESCAPED_ID)||LA69_0==51||(LA69_0>=69 && LA69_0<=72)||(LA69_0>=92 && LA69_0<=106)||LA69_0==109||(LA69_0>=111 && LA69_0<=114)||LA69_0==121||(LA69_0>=126 && LA69_0<=127)) ) {
														alt69=1;
													}
													switch (alt69) {
														case 1 :
															// InternalQVTbase.g:2090:1: (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS )
														{
															// InternalQVTbase.g:2090:1: (lv_ownedDefaultExpressions_42_0= ruleSpecificationCS )
															// InternalQVTbase.g:2091:3: lv_ownedDefaultExpressions_42_0= ruleSpecificationCS
															{
																if ( state.backtracking==0 ) {

																	newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0());

																}
																pushFollow(FollowSets000.FOLLOW_19);
																lv_ownedDefaultExpressions_42_0=ruleSpecificationCS();

																state._fsp--;
																if (state.failed) return current;
																if ( state.backtracking==0 ) {

																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getReferenceCSRule());
																	}
																	add(
																		current,
																		"ownedDefaultExpressions",
																		lv_ownedDefaultExpressions_42_0,
																		"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
																	afterParserOrEnumRuleCall();

																}

															}


														}
														break;

													}

													otherlv_43=(Token)match(input,42,FollowSets000.FOLLOW_15); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_43, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_1_4());

													}

												}


											}
											break;

											default :
												break loop70;
										}
									} while (true);

								otherlv_44=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_44, grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2());

								}

							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:2116:7: otherlv_45= ';'
						{
							otherlv_45=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_45, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_1());

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
	// $ANTLR end "ruleReferenceCS"


	// $ANTLR start "entryRuleSimpleTargetElementCS"
	// InternalQVTbase.g:2128:1: entryRuleSimpleTargetElementCS returns [EObject current=null] : iv_ruleSimpleTargetElementCS= ruleSimpleTargetElementCS EOF ;
	public final EObject entryRuleSimpleTargetElementCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSimpleTargetElementCS = null;


		try {
			// InternalQVTbase.g:2129:2: (iv_ruleSimpleTargetElementCS= ruleSimpleTargetElementCS EOF )
			// InternalQVTbase.g:2130:2: iv_ruleSimpleTargetElementCS= ruleSimpleTargetElementCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getSimpleTargetElementCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleSimpleTargetElementCS=ruleSimpleTargetElementCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleSimpleTargetElementCS;
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
	// $ANTLR end "entryRuleSimpleTargetElementCS"


	// $ANTLR start "ruleSimpleTargetElementCS"
	// InternalQVTbase.g:2137:1: ruleSimpleTargetElementCS returns [EObject current=null] : ( ( ( (lv_input_0_0= 'input' ) ) | ( (lv_output_1_0= 'output' ) ) | ( (lv_via_2_0= 'via' ) ) ) ( ( ruleUnrestrictedName ) ) (otherlv_4= 'iterates' ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) ) )? otherlv_11= ';' ) ;
	public final EObject ruleSimpleTargetElementCS() throws RecognitionException {
		EObject current = null;

		Token lv_input_0_0=null;
		Token lv_output_1_0=null;
		Token lv_via_2_0=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		Token otherlv_11=null;

		enterRule();

		try {
			// InternalQVTbase.g:2140:28: ( ( ( ( (lv_input_0_0= 'input' ) ) | ( (lv_output_1_0= 'output' ) ) | ( (lv_via_2_0= 'via' ) ) ) ( ( ruleUnrestrictedName ) ) (otherlv_4= 'iterates' ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) ) )? otherlv_11= ';' ) )
			// InternalQVTbase.g:2141:1: ( ( ( (lv_input_0_0= 'input' ) ) | ( (lv_output_1_0= 'output' ) ) | ( (lv_via_2_0= 'via' ) ) ) ( ( ruleUnrestrictedName ) ) (otherlv_4= 'iterates' ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) ) )? otherlv_11= ';' )
			{
				// InternalQVTbase.g:2141:1: ( ( ( (lv_input_0_0= 'input' ) ) | ( (lv_output_1_0= 'output' ) ) | ( (lv_via_2_0= 'via' ) ) ) ( ( ruleUnrestrictedName ) ) (otherlv_4= 'iterates' ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) ) )? otherlv_11= ';' )
				// InternalQVTbase.g:2141:2: ( ( (lv_input_0_0= 'input' ) ) | ( (lv_output_1_0= 'output' ) ) | ( (lv_via_2_0= 'via' ) ) ) ( ( ruleUnrestrictedName ) ) (otherlv_4= 'iterates' ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) ) )? otherlv_11= ';'
				{
					// InternalQVTbase.g:2141:2: ( ( (lv_input_0_0= 'input' ) ) | ( (lv_output_1_0= 'output' ) ) | ( (lv_via_2_0= 'via' ) ) )
					int alt72=3;
					switch ( input.LA(1) ) {
						case 61:
						{
							alt72=1;
						}
						break;
						case 62:
						{
							alt72=2;
						}
						break;
						case 63:
						{
							alt72=3;
						}
						break;
						default:
							if (state.backtracking>0) {state.failed=true; return current;}
							NoViableAltException nvae =
									new NoViableAltException("", 72, 0, input);

							throw nvae;
					}

					switch (alt72) {
						case 1 :
							// InternalQVTbase.g:2141:3: ( (lv_input_0_0= 'input' ) )
						{
							// InternalQVTbase.g:2141:3: ( (lv_input_0_0= 'input' ) )
							// InternalQVTbase.g:2142:1: (lv_input_0_0= 'input' )
							{
								// InternalQVTbase.g:2142:1: (lv_input_0_0= 'input' )
								// InternalQVTbase.g:2143:3: lv_input_0_0= 'input'
								{
									lv_input_0_0=(Token)match(input,61,FollowSets000.FOLLOW_6); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_input_0_0, grammarAccess.getSimpleTargetElementCSAccess().getInputInputKeyword_0_0_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
										}
										setWithLastConsumed(current, "input", true, "input");

									}

								}


							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:2157:6: ( (lv_output_1_0= 'output' ) )
						{
							// InternalQVTbase.g:2157:6: ( (lv_output_1_0= 'output' ) )
							// InternalQVTbase.g:2158:1: (lv_output_1_0= 'output' )
							{
								// InternalQVTbase.g:2158:1: (lv_output_1_0= 'output' )
								// InternalQVTbase.g:2159:3: lv_output_1_0= 'output'
								{
									lv_output_1_0=(Token)match(input,62,FollowSets000.FOLLOW_6); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_output_1_0, grammarAccess.getSimpleTargetElementCSAccess().getOutputOutputKeyword_0_1_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
										}
										setWithLastConsumed(current, "output", true, "output");

									}

								}


							}


						}
						break;
						case 3 :
							// InternalQVTbase.g:2173:6: ( (lv_via_2_0= 'via' ) )
						{
							// InternalQVTbase.g:2173:6: ( (lv_via_2_0= 'via' ) )
							// InternalQVTbase.g:2174:1: (lv_via_2_0= 'via' )
							{
								// InternalQVTbase.g:2174:1: (lv_via_2_0= 'via' )
								// InternalQVTbase.g:2175:3: lv_via_2_0= 'via'
								{
									lv_via_2_0=(Token)match(input,63,FollowSets000.FOLLOW_6); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_via_2_0, grammarAccess.getSimpleTargetElementCSAccess().getViaViaKeyword_0_2_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
										}
										setWithLastConsumed(current, "via", true, "via");

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:2188:3: ( ( ruleUnrestrictedName ) )
					// InternalQVTbase.g:2189:1: ( ruleUnrestrictedName )
					{
						// InternalQVTbase.g:2189:1: ( ruleUnrestrictedName )
						// InternalQVTbase.g:2190:3: ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								/* */

							}
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
								}

							}
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getTypedModelTypedModelCrossReference_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_55);
							ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:2206:2: (otherlv_4= 'iterates' ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) ) )?
					int alt76=2;
					int LA76_0 = input.LA(1);

					if ( (LA76_0==64) ) {
						alt76=1;
					}
					switch (alt76) {
						case 1 :
							// InternalQVTbase.g:2206:4: otherlv_4= 'iterates' ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) )
						{
							otherlv_4=(Token)match(input,64,FollowSets000.FOLLOW_56); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_4, grammarAccess.getSimpleTargetElementCSAccess().getIteratesKeyword_2_0());

							}
							// InternalQVTbase.g:2210:1: ( ( ( ruleUnrestrictedName ) ) | (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' ) )
							int alt75=2;
							int LA75_0 = input.LA(1);

							if ( ((LA75_0>=RULE_SIMPLE_ID && LA75_0<=RULE_ESCAPED_ID)) ) {
								alt75=1;
							}
							else if ( (LA75_0==22) ) {
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
									// InternalQVTbase.g:2210:2: ( ( ruleUnrestrictedName ) )
								{
									// InternalQVTbase.g:2210:2: ( ( ruleUnrestrictedName ) )
									// InternalQVTbase.g:2211:1: ( ruleUnrestrictedName )
									{
										// InternalQVTbase.g:2211:1: ( ruleUnrestrictedName )
										// InternalQVTbase.g:2212:3: ruleUnrestrictedName
										{
											if ( state.backtracking==0 ) {

												/* */

											}
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
												}

											}
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getIteratesTypedModelCrossReference_2_1_0_0());

											}
											pushFollow(FollowSets000.FOLLOW_19);
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
									// InternalQVTbase.g:2229:6: (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' )
								{
									// InternalQVTbase.g:2229:6: (otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}' )
									// InternalQVTbase.g:2229:8: otherlv_6= '{' ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )? otherlv_10= '}'
									{
										otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_57); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_6, grammarAccess.getSimpleTargetElementCSAccess().getLeftCurlyBracketKeyword_2_1_1_0());

										}
										// InternalQVTbase.g:2233:1: ( ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )* )?
										int alt74=2;
										int LA74_0 = input.LA(1);

										if ( ((LA74_0>=RULE_SIMPLE_ID && LA74_0<=RULE_ESCAPED_ID)) ) {
											alt74=1;
										}
										switch (alt74) {
											case 1 :
												// InternalQVTbase.g:2233:2: ( ( ruleUnrestrictedName ) ) (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
											{
												// InternalQVTbase.g:2233:2: ( ( ruleUnrestrictedName ) )
												// InternalQVTbase.g:2234:1: ( ruleUnrestrictedName )
												{
													// InternalQVTbase.g:2234:1: ( ruleUnrestrictedName )
													// InternalQVTbase.g:2235:3: ruleUnrestrictedName
													{
														if ( state.backtracking==0 ) {

															/* */

														}
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
															}

														}
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getIteratesTypedModelCrossReference_2_1_1_1_0_0());

														}
														pushFollow(FollowSets000.FOLLOW_58);
														ruleUnrestrictedName();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															afterParserOrEnumRuleCall();

														}

													}


												}

												// InternalQVTbase.g:2251:2: (otherlv_8= ',' ( ( ruleUnrestrictedName ) ) )*
												loop73:
													do {
														int alt73=2;
														int LA73_0 = input.LA(1);

														if ( (LA73_0==39) ) {
															alt73=1;
														}


														switch (alt73) {
															case 1 :
																// InternalQVTbase.g:2251:4: otherlv_8= ',' ( ( ruleUnrestrictedName ) )
																{
																	otherlv_8=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
																	if ( state.backtracking==0 ) {

																		newLeafNode(otherlv_8, grammarAccess.getSimpleTargetElementCSAccess().getCommaKeyword_2_1_1_1_1_0());

																	}
																	// InternalQVTbase.g:2255:1: ( ( ruleUnrestrictedName ) )
																	// InternalQVTbase.g:2256:1: ( ruleUnrestrictedName )
																	{
																		// InternalQVTbase.g:2256:1: ( ruleUnrestrictedName )
																		// InternalQVTbase.g:2257:3: ruleUnrestrictedName
																		{
																			if ( state.backtracking==0 ) {

																				/* */

																			}
																			if ( state.backtracking==0 ) {

																				if (current==null) {
																					current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
																				}

																			}
																			if ( state.backtracking==0 ) {

																				newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getIteratesTypedModelCrossReference_2_1_1_1_1_1_0());

																			}
																			pushFollow(FollowSets000.FOLLOW_58);
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
																break loop73;
														}
													} while (true);


											}
											break;

										}

										otherlv_10=(Token)match(input,40,FollowSets000.FOLLOW_19); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_10, grammarAccess.getSimpleTargetElementCSAccess().getRightCurlyBracketKeyword_2_1_1_2());

										}

									}


								}
								break;

							}


						}
						break;

					}

					otherlv_11=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_11, grammarAccess.getSimpleTargetElementCSAccess().getSemicolonKeyword_3());

					}

				}


			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input,re);
			appendSkippedTokens();
		}
		finally {
		}
		return current;
	}
	// $ANTLR end "ruleSimpleTargetElementCS"


	// $ANTLR start "entryRuleSpecificationCS"
	// InternalQVTbase.g:2289:1: entryRuleSpecificationCS returns [EObject current=null] : iv_ruleSpecificationCS= ruleSpecificationCS EOF ;
	public final EObject entryRuleSpecificationCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSpecificationCS = null;


		try {
			// InternalQVTbase.g:2290:2: (iv_ruleSpecificationCS= ruleSpecificationCS EOF )
			// InternalQVTbase.g:2291:2: iv_ruleSpecificationCS= ruleSpecificationCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getSpecificationCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleSpecificationCS=ruleSpecificationCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleSpecificationCS;
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
	// $ANTLR end "entryRuleSpecificationCS"


	// $ANTLR start "ruleSpecificationCS"
	// InternalQVTbase.g:2298:1: ruleSpecificationCS returns [EObject current=null] : ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) ) ;
	public final EObject ruleSpecificationCS() throws RecognitionException {
		EObject current = null;

		Token lv_exprString_1_0=null;
		EObject lv_ownedExpression_0_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:2301:28: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) ) )
			// InternalQVTbase.g:2302:1: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) )
			{
				// InternalQVTbase.g:2302:1: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) )
				int alt77=2;
				int LA77_0 = input.LA(1);

				if ( (LA77_0==RULE_SINGLE_QUOTED_STRING||(LA77_0>=RULE_INT && LA77_0<=RULE_ESCAPED_ID)||LA77_0==51||(LA77_0>=69 && LA77_0<=72)||(LA77_0>=92 && LA77_0<=106)||LA77_0==109||(LA77_0>=111 && LA77_0<=114)||LA77_0==121||(LA77_0>=126 && LA77_0<=127)) ) {
					alt77=1;
				}
				else if ( (LA77_0==RULE_UNQUOTED_STRING) ) {
					alt77=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 77, 0, input);

					throw nvae;
				}
				switch (alt77) {
					case 1 :
						// InternalQVTbase.g:2302:2: ( (lv_ownedExpression_0_0= ruleExpCS ) )
					{
						// InternalQVTbase.g:2302:2: ( (lv_ownedExpression_0_0= ruleExpCS ) )
						// InternalQVTbase.g:2303:1: (lv_ownedExpression_0_0= ruleExpCS )
						{
							// InternalQVTbase.g:2303:1: (lv_ownedExpression_0_0= ruleExpCS )
							// InternalQVTbase.g:2304:3: lv_ownedExpression_0_0= ruleExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedExpression_0_0=ruleExpCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getSpecificationCSRule());
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


					}
					break;
					case 2 :
						// InternalQVTbase.g:2321:6: ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) )
					{
						// InternalQVTbase.g:2321:6: ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) )
						// InternalQVTbase.g:2322:1: (lv_exprString_1_0= RULE_UNQUOTED_STRING )
						{
							// InternalQVTbase.g:2322:1: (lv_exprString_1_0= RULE_UNQUOTED_STRING )
							// InternalQVTbase.g:2323:3: lv_exprString_1_0= RULE_UNQUOTED_STRING
							{
								lv_exprString_1_0=(Token)match(input,RULE_UNQUOTED_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(lv_exprString_1_0, grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0());

								}
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElement(grammarAccess.getSpecificationCSRule());
									}
									setWithLastConsumed(
										current,
										"exprString",
										lv_exprString_1_0,
										"org.eclipse.qvtd.xtext.qvtbase.QVTbase.UNQUOTED_STRING");

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
	// $ANTLR end "ruleSpecificationCS"


	// $ANTLR start "entryRuleStructuredClassCS"
	// InternalQVTbase.g:2347:1: entryRuleStructuredClassCS returns [EObject current=null] : iv_ruleStructuredClassCS= ruleStructuredClassCS EOF ;
	public final EObject entryRuleStructuredClassCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStructuredClassCS = null;


		try {
			// InternalQVTbase.g:2348:2: (iv_ruleStructuredClassCS= ruleStructuredClassCS EOF )
			// InternalQVTbase.g:2349:2: iv_ruleStructuredClassCS= ruleStructuredClassCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getStructuredClassCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleStructuredClassCS=ruleStructuredClassCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleStructuredClassCS;
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
	// $ANTLR end "entryRuleStructuredClassCS"


	// $ANTLR start "ruleStructuredClassCS"
	// InternalQVTbase.g:2356:1: ruleStructuredClassCS returns [EObject current=null] : ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) ;
	public final EObject ruleStructuredClassCS() throws RecognitionException {
		EObject current = null;

		Token lv_isAbstract_0_0=null;
		Token otherlv_1=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token lv_instanceClassName_9_0=null;
		Token otherlv_10=null;
		Token lv_isInterface_11_0=null;
		Token otherlv_12=null;
		Token otherlv_13=null;
		Token otherlv_16=null;
		Token otherlv_17=null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;

		EObject lv_ownedSignature_3_0 = null;

		EObject lv_ownedSuperTypes_5_0 = null;

		EObject lv_ownedSuperTypes_7_0 = null;

		EObject lv_ownedOperations_14_0 = null;

		EObject lv_ownedProperties_15_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:2359:28: ( ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) ) )
			// InternalQVTbase.g:2360:1: ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
			{
				// InternalQVTbase.g:2360:1: ( ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' ) )
				// InternalQVTbase.g:2360:2: ( (lv_isAbstract_0_0= 'abstract' ) )? otherlv_1= 'class' ( (lv_name_2_0= ruleUnrestrictedName ) ) ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )? (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )? (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )? (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )? ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' )
				{
					// InternalQVTbase.g:2360:2: ( (lv_isAbstract_0_0= 'abstract' ) )?
					int alt78=2;
					int LA78_0 = input.LA(1);

					if ( (LA78_0==65) ) {
						alt78=1;
					}
					switch (alt78) {
						case 1 :
							// InternalQVTbase.g:2361:1: (lv_isAbstract_0_0= 'abstract' )
						{
							// InternalQVTbase.g:2361:1: (lv_isAbstract_0_0= 'abstract' )
							// InternalQVTbase.g:2362:3: lv_isAbstract_0_0= 'abstract'
							{
								lv_isAbstract_0_0=(Token)match(input,65,FollowSets000.FOLLOW_59); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(lv_isAbstract_0_0, grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0());

								}
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElement(grammarAccess.getStructuredClassCSRule());
									}
									setWithLastConsumed(current, "isAbstract", true, "abstract");

								}

							}


						}
						break;

					}

					otherlv_1=(Token)match(input,66,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getStructuredClassCSAccess().getClassKeyword_1());

					}
					// InternalQVTbase.g:2379:1: ( (lv_name_2_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:2380:1: (lv_name_2_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:2380:1: (lv_name_2_0= ruleUnrestrictedName )
						// InternalQVTbase.g:2381:3: lv_name_2_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getStructuredClassCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());

							}
							pushFollow(FollowSets000.FOLLOW_60);
							lv_name_2_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
								}
								set(
									current,
									"name",
									lv_name_2_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:2397:2: ( (lv_ownedSignature_3_0= ruleTemplateSignatureCS ) )?
					int alt79=2;
					int LA79_0 = input.LA(1);

					if ( (LA79_0==51) ) {
						alt79=1;
					}
					switch (alt79) {
						case 1 :
							// InternalQVTbase.g:2398:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
						{
							// InternalQVTbase.g:2398:1: (lv_ownedSignature_3_0= ruleTemplateSignatureCS )
							// InternalQVTbase.g:2399:3: lv_ownedSignature_3_0= ruleTemplateSignatureCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());

								}
								pushFollow(FollowSets000.FOLLOW_61);
								lv_ownedSignature_3_0=ruleTemplateSignatureCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
									}
									set(
										current,
										"ownedSignature",
										lv_ownedSignature_3_0,
										"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
									afterParserOrEnumRuleCall();

								}

							}


						}
						break;

					}

					// InternalQVTbase.g:2415:3: (otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )* )?
					int alt81=2;
					int LA81_0 = input.LA(1);

					if ( (LA81_0==67) ) {
						alt81=1;
					}
					switch (alt81) {
						case 1 :
							// InternalQVTbase.g:2415:5: otherlv_4= 'extends' ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) ) (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )*
						{
							otherlv_4=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_4, grammarAccess.getStructuredClassCSAccess().getExtendsKeyword_4_0());

							}
							// InternalQVTbase.g:2419:1: ( (lv_ownedSuperTypes_5_0= ruleTypedRefCS ) )
							// InternalQVTbase.g:2420:1: (lv_ownedSuperTypes_5_0= ruleTypedRefCS )
							{
								// InternalQVTbase.g:2420:1: (lv_ownedSuperTypes_5_0= ruleTypedRefCS )
								// InternalQVTbase.g:2421:3: lv_ownedSuperTypes_5_0= ruleTypedRefCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_62);
									lv_ownedSuperTypes_5_0=ruleTypedRefCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
										}
										add(
											current,
											"ownedSuperTypes",
											lv_ownedSuperTypes_5_0,
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
										afterParserOrEnumRuleCall();

									}

								}


							}

							// InternalQVTbase.g:2437:2: (otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) ) )*
							loop80:
								do {
									int alt80=2;
									int LA80_0 = input.LA(1);

									if ( (LA80_0==39) ) {
										alt80=1;
									}


									switch (alt80) {
										case 1 :
											// InternalQVTbase.g:2437:4: otherlv_6= ',' ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) )
										{
											otherlv_6=(Token)match(input,39,FollowSets000.FOLLOW_8); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_6, grammarAccess.getStructuredClassCSAccess().getCommaKeyword_4_2_0());

											}
											// InternalQVTbase.g:2441:1: ( (lv_ownedSuperTypes_7_0= ruleTypedRefCS ) )
											// InternalQVTbase.g:2442:1: (lv_ownedSuperTypes_7_0= ruleTypedRefCS )
											{
												// InternalQVTbase.g:2442:1: (lv_ownedSuperTypes_7_0= ruleTypedRefCS )
												// InternalQVTbase.g:2443:3: lv_ownedSuperTypes_7_0= ruleTypedRefCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_62);
													lv_ownedSuperTypes_7_0=ruleTypedRefCS();

													state._fsp--;
													if (state.failed) return current;
													if ( state.backtracking==0 ) {

														if (current==null) {
															current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
														}
														add(
															current,
															"ownedSuperTypes",
															lv_ownedSuperTypes_7_0,
															"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
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
						break;

					}

					// InternalQVTbase.g:2459:6: (otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) ) )?
					int alt82=2;
					int LA82_0 = input.LA(1);

					if ( (LA82_0==20) ) {
						alt82=1;
					}
					switch (alt82) {
						case 1 :
							// InternalQVTbase.g:2459:8: otherlv_8= ':' ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) )
						{
							otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_10); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_8, grammarAccess.getStructuredClassCSAccess().getColonKeyword_5_0());

							}
							// InternalQVTbase.g:2463:1: ( (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING ) )
							// InternalQVTbase.g:2464:1: (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING )
							{
								// InternalQVTbase.g:2464:1: (lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING )
								// InternalQVTbase.g:2465:3: lv_instanceClassName_9_0= RULE_SINGLE_QUOTED_STRING
								{
									lv_instanceClassName_9_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_11); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(lv_instanceClassName_9_0, grammarAccess.getStructuredClassCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0());

									}
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElement(grammarAccess.getStructuredClassCSRule());
										}
										setWithLastConsumed(
											current,
											"instanceClassName",
											lv_instanceClassName_9_0,
											"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");

									}

								}


							}


						}
						break;

					}

					// InternalQVTbase.g:2481:4: (otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}' )?
					int alt84=2;
					int LA84_0 = input.LA(1);

					if ( (LA84_0==22) ) {
						int LA84_1 = input.LA(2);

						if ( (LA84_1==40) ) {
							int LA84_3 = input.LA(3);

							if ( (LA84_3==22||LA84_3==42) ) {
								alt84=1;
							}
						}
						else if ( (LA84_1==68) ) {
							alt84=1;
						}
					}
					switch (alt84) {
						case 1 :
							// InternalQVTbase.g:2481:6: otherlv_10= '{' ( (lv_isInterface_11_0= 'interface' ) )? otherlv_12= '}'
						{
							otherlv_10=(Token)match(input,22,FollowSets000.FOLLOW_63); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_10, grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_6_0());

							}
							// InternalQVTbase.g:2485:1: ( (lv_isInterface_11_0= 'interface' ) )?
							int alt83=2;
							int LA83_0 = input.LA(1);

							if ( (LA83_0==68) ) {
								alt83=1;
							}
							switch (alt83) {
								case 1 :
									// InternalQVTbase.g:2486:1: (lv_isInterface_11_0= 'interface' )
								{
									// InternalQVTbase.g:2486:1: (lv_isInterface_11_0= 'interface' )
									// InternalQVTbase.g:2487:3: lv_isInterface_11_0= 'interface'
									{
										lv_isInterface_11_0=(Token)match(input,68,FollowSets000.FOLLOW_26); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(lv_isInterface_11_0, grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0());

										}
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElement(grammarAccess.getStructuredClassCSRule());
											}
											setWithLastConsumed(current, "isInterface", true, "interface");

										}

									}


								}
								break;

							}

							otherlv_12=(Token)match(input,40,FollowSets000.FOLLOW_11); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_12, grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_6_2());

							}

						}
						break;

					}

					// InternalQVTbase.g:2504:3: ( (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' ) | otherlv_17= ';' )
					int alt86=2;
					int LA86_0 = input.LA(1);

					if ( (LA86_0==22) ) {
						alt86=1;
					}
					else if ( (LA86_0==42) ) {
						alt86=2;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 86, 0, input);

						throw nvae;
					}
					switch (alt86) {
						case 1 :
							// InternalQVTbase.g:2504:4: (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' )
						{
							// InternalQVTbase.g:2504:4: (otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}' )
							// InternalQVTbase.g:2504:6: otherlv_13= '{' ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )* otherlv_16= '}'
							{
								otherlv_13=(Token)match(input,22,FollowSets000.FOLLOW_64); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_13, grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_7_0_0());

								}
								// InternalQVTbase.g:2508:1: ( ( (lv_ownedOperations_14_0= ruleOperationCS ) ) | ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) ) )*
								loop85:
									do {
										int alt85=3;
										switch ( input.LA(1) ) {
											case 17:
											{
												switch ( input.LA(2) ) {
													case 18:
													{
														int LA85_6 = input.LA(3);

														if ( (LA85_6==50) ) {
															alt85=1;
														}
														else if ( (LA85_6==19||LA85_6==55) ) {
															alt85=2;
														}


													}
													break;
													case 50:
													{
														alt85=1;
													}
													break;
													case 19:
													case 55:
													{
														alt85=2;
													}
													break;

												}

											}
											break;
											case 18:
											{
												switch ( input.LA(2) ) {
													case 17:
													{
														int LA85_7 = input.LA(3);

														if ( (LA85_7==50) ) {
															alt85=1;
														}
														else if ( (LA85_7==19||LA85_7==55) ) {
															alt85=2;
														}


													}
													break;
													case 50:
													{
														alt85=1;
													}
													break;
													case 19:
													case 55:
													{
														alt85=2;
													}
													break;

												}

											}
											break;
											case 50:
											{
												alt85=1;
											}
											break;
											case 19:
											case 55:
											{
												alt85=2;
											}
											break;

										}

										switch (alt85) {
											case 1 :
												// InternalQVTbase.g:2508:2: ( (lv_ownedOperations_14_0= ruleOperationCS ) )
											{
												// InternalQVTbase.g:2508:2: ( (lv_ownedOperations_14_0= ruleOperationCS ) )
												// InternalQVTbase.g:2509:1: (lv_ownedOperations_14_0= ruleOperationCS )
												{
													// InternalQVTbase.g:2509:1: (lv_ownedOperations_14_0= ruleOperationCS )
													// InternalQVTbase.g:2510:3: lv_ownedOperations_14_0= ruleOperationCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0());

														}
														pushFollow(FollowSets000.FOLLOW_64);
														lv_ownedOperations_14_0=ruleOperationCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
															}
															add(
																current,
																"ownedOperations",
																lv_ownedOperations_14_0,
																"org.eclipse.qvtd.xtext.qvtbase.QVTbase.OperationCS");
															afterParserOrEnumRuleCall();

														}

													}


												}


											}
											break;
											case 2 :
												// InternalQVTbase.g:2527:6: ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) )
											{
												// InternalQVTbase.g:2527:6: ( (lv_ownedProperties_15_0= ruleStructuralFeatureCS ) )
												// InternalQVTbase.g:2528:1: (lv_ownedProperties_15_0= ruleStructuralFeatureCS )
												{
													// InternalQVTbase.g:2528:1: (lv_ownedProperties_15_0= ruleStructuralFeatureCS )
													// InternalQVTbase.g:2529:3: lv_ownedProperties_15_0= ruleStructuralFeatureCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0());

														}
														pushFollow(FollowSets000.FOLLOW_64);
														lv_ownedProperties_15_0=ruleStructuralFeatureCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
															}
															add(
																current,
																"ownedProperties",
																lv_ownedProperties_15_0,
																"org.eclipse.qvtd.xtext.qvtbase.QVTbase.StructuralFeatureCS");
															afterParserOrEnumRuleCall();

														}

													}


												}


											}
											break;

											default :
												break loop85;
										}
									} while (true);

								otherlv_16=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_16, grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_7_0_2());

								}

							}


						}
						break;
						case 2 :
							// InternalQVTbase.g:2550:7: otherlv_17= ';'
						{
							otherlv_17=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_17, grammarAccess.getStructuredClassCSAccess().getSemicolonKeyword_7_1());

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
	// $ANTLR end "ruleStructuredClassCS"


	// $ANTLR start "entryRuleTypedMultiplicityRefCS"
	// InternalQVTbase.g:2564:1: entryRuleTypedMultiplicityRefCS returns [EObject current=null] : iv_ruleTypedMultiplicityRefCS= ruleTypedMultiplicityRefCS EOF ;
	public final EObject entryRuleTypedMultiplicityRefCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypedMultiplicityRefCS = null;


		try {
			// InternalQVTbase.g:2565:2: (iv_ruleTypedMultiplicityRefCS= ruleTypedMultiplicityRefCS EOF )
			// InternalQVTbase.g:2566:2: iv_ruleTypedMultiplicityRefCS= ruleTypedMultiplicityRefCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getTypedMultiplicityRefCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleTypedMultiplicityRefCS=ruleTypedMultiplicityRefCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleTypedMultiplicityRefCS;
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
	// $ANTLR end "entryRuleTypedMultiplicityRefCS"


	// $ANTLR start "ruleTypedMultiplicityRefCS"
	// InternalQVTbase.g:2573:1: ruleTypedMultiplicityRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
	public final EObject ruleTypedMultiplicityRefCS() throws RecognitionException {
		EObject current = null;

		EObject this_TypedRefCS_0 = null;

		EObject lv_ownedMultiplicity_1_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:2576:28: ( (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
			// InternalQVTbase.g:2577:1: (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
			{
				// InternalQVTbase.g:2577:1: (this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
				// InternalQVTbase.g:2578:2: this_TypedRefCS_0= ruleTypedRefCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
				{
					if ( state.backtracking==0 ) {

						/* */

					}
					if ( state.backtracking==0 ) {

						newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedRefCSParserRuleCall_0());

					}
					pushFollow(FollowSets000.FOLLOW_65);
					this_TypedRefCS_0=ruleTypedRefCS();

					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {

						current = this_TypedRefCS_0;
						afterParserOrEnumRuleCall();

					}
					// InternalQVTbase.g:2589:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
					int alt87=2;
					int LA87_0 = input.LA(1);

					if ( (LA87_0==117) ) {
						alt87=1;
					}
					switch (alt87) {
						case 1 :
							// InternalQVTbase.g:2590:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
						{
							// InternalQVTbase.g:2590:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
							// InternalQVTbase.g:2591:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getTypedMultiplicityRefCSRule());
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
	// $ANTLR end "ruleTypedMultiplicityRefCS"


	// $ANTLR start "entryRuleTypedRefCS"
	// InternalQVTbase.g:2615:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
	public final EObject entryRuleTypedRefCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypedRefCS = null;


		try {
			// InternalQVTbase.g:2616:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
			// InternalQVTbase.g:2617:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
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
	// InternalQVTbase.g:2624:1: ruleTypedRefCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_TypedTypeRefCS_1= ruleTypedTypeRefCS ) ;
	public final EObject ruleTypedRefCS() throws RecognitionException {
		EObject current = null;

		EObject this_TypeLiteralCS_0 = null;

		EObject this_TypedTypeRefCS_1 = null;


		enterRule();

		try {
			// InternalQVTbase.g:2627:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_TypedTypeRefCS_1= ruleTypedTypeRefCS ) )
			// InternalQVTbase.g:2628:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_TypedTypeRefCS_1= ruleTypedTypeRefCS )
			{
				// InternalQVTbase.g:2628:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS | this_TypedTypeRefCS_1= ruleTypedTypeRefCS )
				int alt88=2;
				int LA88_0 = input.LA(1);

				if ( ((LA88_0>=92 && LA88_0<=106)) ) {
					alt88=1;
				}
				else if ( ((LA88_0>=RULE_SIMPLE_ID && LA88_0<=RULE_ESCAPED_ID)) ) {
					alt88=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 88, 0, input);

					throw nvae;
				}
				switch (alt88) {
					case 1 :
						// InternalQVTbase.g:2629:2: this_TypeLiteralCS_0= ruleTypeLiteralCS
					{
						if ( state.backtracking==0 ) {

							/* */

						}
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypeLiteralCSParserRuleCall_0());

						}
						pushFollow(FollowSets000.FOLLOW_2);
						this_TypeLiteralCS_0=ruleTypeLiteralCS();

						state._fsp--;
						if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current = this_TypeLiteralCS_0;
							afterParserOrEnumRuleCall();

						}

					}
					break;
					case 2 :
						// InternalQVTbase.g:2642:2: this_TypedTypeRefCS_1= ruleTypedTypeRefCS
					{
						if ( state.backtracking==0 ) {

							/* */

						}
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_1());

						}
						pushFollow(FollowSets000.FOLLOW_2);
						this_TypedTypeRefCS_1=ruleTypedTypeRefCS();

						state._fsp--;
						if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current = this_TypedTypeRefCS_1;
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
	// $ANTLR end "ruleTypedRefCS"


	// $ANTLR start "entryRuleStructuralFeatureCS"
	// InternalQVTbase.g:2661:1: entryRuleStructuralFeatureCS returns [EObject current=null] : iv_ruleStructuralFeatureCS= ruleStructuralFeatureCS EOF ;
	public final EObject entryRuleStructuralFeatureCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStructuralFeatureCS = null;


		try {
			// InternalQVTbase.g:2662:2: (iv_ruleStructuralFeatureCS= ruleStructuralFeatureCS EOF )
			// InternalQVTbase.g:2663:2: iv_ruleStructuralFeatureCS= ruleStructuralFeatureCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getStructuralFeatureCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleStructuralFeatureCS=ruleStructuralFeatureCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleStructuralFeatureCS;
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
	// $ANTLR end "entryRuleStructuralFeatureCS"


	// $ANTLR start "ruleStructuralFeatureCS"
	// InternalQVTbase.g:2670:1: ruleStructuralFeatureCS returns [EObject current=null] : (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS ) ;
	public final EObject ruleStructuralFeatureCS() throws RecognitionException {
		EObject current = null;

		EObject this_AttributeCS_0 = null;

		EObject this_ReferenceCS_1 = null;


		enterRule();

		try {
			// InternalQVTbase.g:2673:28: ( (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS ) )
			// InternalQVTbase.g:2674:1: (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS )
			{
				// InternalQVTbase.g:2674:1: (this_AttributeCS_0= ruleAttributeCS | this_ReferenceCS_1= ruleReferenceCS )
				int alt89=2;
				switch ( input.LA(1) ) {
					case 17:
					{
						switch ( input.LA(2) ) {
							case 18:
							{
								int LA89_5 = input.LA(3);

								if ( (LA89_5==55) ) {
									alt89=2;
								}
								else if ( (LA89_5==19) ) {
									alt89=1;
								}
								else {
									if (state.backtracking>0) {state.failed=true; return current;}
									NoViableAltException nvae =
											new NoViableAltException("", 89, 5, input);

									throw nvae;
								}
							}
							break;
							case 19:
							{
								alt89=1;
							}
							break;
							case 55:
							{
								alt89=2;
							}
							break;
							default:
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
										new NoViableAltException("", 89, 1, input);

								throw nvae;
						}

					}
					break;
					case 18:
					{
						switch ( input.LA(2) ) {
							case 17:
							{
								int LA89_6 = input.LA(3);

								if ( (LA89_6==19) ) {
									alt89=1;
								}
								else if ( (LA89_6==55) ) {
									alt89=2;
								}
								else {
									if (state.backtracking>0) {state.failed=true; return current;}
									NoViableAltException nvae =
											new NoViableAltException("", 89, 6, input);

									throw nvae;
								}
							}
							break;
							case 19:
							{
								alt89=1;
							}
							break;
							case 55:
							{
								alt89=2;
							}
							break;
							default:
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
										new NoViableAltException("", 89, 2, input);

								throw nvae;
						}

					}
					break;
					case 19:
					{
						alt89=1;
					}
					break;
					case 55:
					{
						alt89=2;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 89, 0, input);

						throw nvae;
				}

				switch (alt89) {
					case 1 :
						// InternalQVTbase.g:2675:2: this_AttributeCS_0= ruleAttributeCS
					{
						if ( state.backtracking==0 ) {

							/* */

						}
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getStructuralFeatureCSAccess().getAttributeCSParserRuleCall_0());

						}
						pushFollow(FollowSets000.FOLLOW_2);
						this_AttributeCS_0=ruleAttributeCS();

						state._fsp--;
						if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current = this_AttributeCS_0;
							afterParserOrEnumRuleCall();

						}

					}
					break;
					case 2 :
						// InternalQVTbase.g:2688:2: this_ReferenceCS_1= ruleReferenceCS
					{
						if ( state.backtracking==0 ) {

							/* */

						}
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getStructuralFeatureCSAccess().getReferenceCSParserRuleCall_1());

						}
						pushFollow(FollowSets000.FOLLOW_2);
						this_ReferenceCS_1=ruleReferenceCS();

						state._fsp--;
						if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current = this_ReferenceCS_1;
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
	// $ANTLR end "ruleStructuralFeatureCS"


	// $ANTLR start "entryRuleEnumerationLiteralName"
	// InternalQVTbase.g:2707:1: entryRuleEnumerationLiteralName returns [String current=null] : iv_ruleEnumerationLiteralName= ruleEnumerationLiteralName EOF ;
	public final String entryRuleEnumerationLiteralName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleEnumerationLiteralName = null;


		try {
			// InternalQVTbase.g:2708:2: (iv_ruleEnumerationLiteralName= ruleEnumerationLiteralName EOF )
			// InternalQVTbase.g:2709:2: iv_ruleEnumerationLiteralName= ruleEnumerationLiteralName EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getEnumerationLiteralNameRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleEnumerationLiteralName=ruleEnumerationLiteralName();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleEnumerationLiteralName.getText();
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
	// $ANTLR end "entryRuleEnumerationLiteralName"


	// $ANTLR start "ruleEnumerationLiteralName"
	// InternalQVTbase.g:2716:1: ruleEnumerationLiteralName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
	public final AntlrDatatypeRuleToken ruleEnumerationLiteralName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:2719:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
			// InternalQVTbase.g:2721:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
			{
				if ( state.backtracking==0 ) {

					newCompositeNode(grammarAccess.getEnumerationLiteralNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall());

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

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input,re);
			appendSkippedTokens();
		}
		finally {
		}
		return current;
	}
	// $ANTLR end "ruleEnumerationLiteralName"


	// $ANTLR start "entryRuleSIGNED"
	// InternalQVTbase.g:2741:1: entryRuleSIGNED returns [String current=null] : iv_ruleSIGNED= ruleSIGNED EOF ;
	public final String entryRuleSIGNED() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleSIGNED = null;


		try {
			// InternalQVTbase.g:2742:2: (iv_ruleSIGNED= ruleSIGNED EOF )
			// InternalQVTbase.g:2743:2: iv_ruleSIGNED= ruleSIGNED EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getSIGNEDRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleSIGNED=ruleSIGNED();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleSIGNED.getText();
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
	// $ANTLR end "entryRuleSIGNED"


	// $ANTLR start "ruleSIGNED"
	// InternalQVTbase.g:2750:1: ruleSIGNED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
	public final AntlrDatatypeRuleToken ruleSIGNED() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw=null;
		Token this_INT_1=null;

		enterRule();

		try {
			// InternalQVTbase.g:2753:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
			// InternalQVTbase.g:2754:1: ( (kw= '-' )? this_INT_1= RULE_INT )
			{
				// InternalQVTbase.g:2754:1: ( (kw= '-' )? this_INT_1= RULE_INT )
				// InternalQVTbase.g:2754:2: (kw= '-' )? this_INT_1= RULE_INT
				{
					// InternalQVTbase.g:2754:2: (kw= '-' )?
					int alt90=2;
					int LA90_0 = input.LA(1);

					if ( (LA90_0==69) ) {
						alt90=1;
					}
					switch (alt90) {
						case 1 :
							// InternalQVTbase.g:2755:2: kw= '-'
						{
							kw=(Token)match(input,69,FollowSets000.FOLLOW_66); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getSIGNEDAccess().getHyphenMinusKeyword_0());

							}

						}
						break;

					}

					this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						current.merge(this_INT_1);

					}
					if ( state.backtracking==0 ) {

						newLeafNode(this_INT_1, grammarAccess.getSIGNEDAccess().getINTTerminalRuleCall_1());

					}

				}


			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input,re);
			appendSkippedTokens();
		}
		finally {
		}
		return current;
	}
	// $ANTLR end "ruleSIGNED"


	// $ANTLR start "entryRuleEssentialOCLUnaryOperatorName"
	// InternalQVTbase.g:2779:1: entryRuleEssentialOCLUnaryOperatorName returns [String current=null] : iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF ;
	public final String entryRuleEssentialOCLUnaryOperatorName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleEssentialOCLUnaryOperatorName = null;


		try {
			// InternalQVTbase.g:2780:2: (iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF )
			// InternalQVTbase.g:2781:2: iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF
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
	// InternalQVTbase.g:2788:1: ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' | kw= 'not2' ) ;
	public final AntlrDatatypeRuleToken ruleEssentialOCLUnaryOperatorName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw=null;

		enterRule();

		try {
			// InternalQVTbase.g:2791:28: ( (kw= '-' | kw= 'not' | kw= 'not2' ) )
			// InternalQVTbase.g:2792:1: (kw= '-' | kw= 'not' | kw= 'not2' )
			{
				// InternalQVTbase.g:2792:1: (kw= '-' | kw= 'not' | kw= 'not2' )
				int alt91=3;
				switch ( input.LA(1) ) {
					case 69:
					{
						alt91=1;
					}
					break;
					case 70:
					{
						alt91=2;
					}
					break;
					case 71:
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
						// InternalQVTbase.g:2793:2: kw= '-'
					{
						kw=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0());

						}

					}
					break;
					case 2 :
						// InternalQVTbase.g:2800:2: kw= 'not'
					{
						kw=(Token)match(input,70,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1());

						}

					}
					break;
					case 3 :
						// InternalQVTbase.g:2807:2: kw= 'not2'
					{
						kw=(Token)match(input,71,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNot2Keyword_2());

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
	// InternalQVTbase.g:2820:1: entryRuleEssentialOCLInfixOperatorName returns [String current=null] : iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF ;
	public final String entryRuleEssentialOCLInfixOperatorName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperatorName = null;


		try {
			// InternalQVTbase.g:2821:2: (iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF )
			// InternalQVTbase.g:2822:2: iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF
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
	// InternalQVTbase.g:2829:1: ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'and2' | kw= 'implies' | kw= 'implies2' | kw= 'or' | kw= 'or2' | kw= 'xor' | kw= 'xor2' ) ;
	public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperatorName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw=null;

		enterRule();

		try {
			// InternalQVTbase.g:2832:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'and2' | kw= 'implies' | kw= 'implies2' | kw= 'or' | kw= 'or2' | kw= 'xor' | kw= 'xor2' ) )
			// InternalQVTbase.g:2833:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'and2' | kw= 'implies' | kw= 'implies2' | kw= 'or' | kw= 'or2' | kw= 'xor' | kw= 'xor2' )
			{
				// InternalQVTbase.g:2833:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'and2' | kw= 'implies' | kw= 'implies2' | kw= 'or' | kw= 'or2' | kw= 'xor' | kw= 'xor2' )
				int alt92=18;
				switch ( input.LA(1) ) {
					case 72:
					{
						alt92=1;
					}
					break;
					case 73:
					{
						alt92=2;
					}
					break;
					case 74:
					{
						alt92=3;
					}
					break;
					case 69:
					{
						alt92=4;
					}
					break;
					case 75:
					{
						alt92=5;
					}
					break;
					case 76:
					{
						alt92=6;
					}
					break;
					case 77:
					{
						alt92=7;
					}
					break;
					case 78:
					{
						alt92=8;
					}
					break;
					case 21:
					{
						alt92=9;
					}
					break;
					case 79:
					{
						alt92=10;
					}
					break;
					case 80:
					{
						alt92=11;
					}
					break;
					case 81:
					{
						alt92=12;
					}
					break;
					case 82:
					{
						alt92=13;
					}
					break;
					case 83:
					{
						alt92=14;
					}
					break;
					case 84:
					{
						alt92=15;
					}
					break;
					case 85:
					{
						alt92=16;
					}
					break;
					case 86:
					{
						alt92=17;
					}
					break;
					case 87:
					{
						alt92=18;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 92, 0, input);

						throw nvae;
				}

				switch (alt92) {
					case 1 :
						// InternalQVTbase.g:2834:2: kw= '*'
					{
						kw=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0());

						}

					}
					break;
					case 2 :
						// InternalQVTbase.g:2841:2: kw= '/'
					{
						kw=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1());

						}

					}
					break;
					case 3 :
						// InternalQVTbase.g:2848:2: kw= '+'
					{
						kw=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2());

						}

					}
					break;
					case 4 :
						// InternalQVTbase.g:2855:2: kw= '-'
					{
						kw=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3());

						}

					}
					break;
					case 5 :
						// InternalQVTbase.g:2862:2: kw= '>'
					{
						kw=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4());

						}

					}
					break;
					case 6 :
						// InternalQVTbase.g:2869:2: kw= '<'
					{
						kw=(Token)match(input,76,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5());

						}

					}
					break;
					case 7 :
						// InternalQVTbase.g:2876:2: kw= '>='
					{
						kw=(Token)match(input,77,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6());

						}

					}
					break;
					case 8 :
						// InternalQVTbase.g:2883:2: kw= '<='
					{
						kw=(Token)match(input,78,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7());

						}

					}
					break;
					case 9 :
						// InternalQVTbase.g:2890:2: kw= '='
					{
						kw=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8());

						}

					}
					break;
					case 10 :
						// InternalQVTbase.g:2897:2: kw= '<>'
					{
						kw=(Token)match(input,79,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9());

						}

					}
					break;
					case 11 :
						// InternalQVTbase.g:2904:2: kw= 'and'
					{
						kw=(Token)match(input,80,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10());

						}

					}
					break;
					case 12 :
						// InternalQVTbase.g:2911:2: kw= 'and2'
					{
						kw=(Token)match(input,81,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAnd2Keyword_11());

						}

					}
					break;
					case 13 :
						// InternalQVTbase.g:2918:2: kw= 'implies'
					{
						kw=(Token)match(input,82,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_12());

						}

					}
					break;
					case 14 :
						// InternalQVTbase.g:2925:2: kw= 'implies2'
					{
						kw=(Token)match(input,83,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImplies2Keyword_13());

						}

					}
					break;
					case 15 :
						// InternalQVTbase.g:2932:2: kw= 'or'
					{
						kw=(Token)match(input,84,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_14());

						}

					}
					break;
					case 16 :
						// InternalQVTbase.g:2939:2: kw= 'or2'
					{
						kw=(Token)match(input,85,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOr2Keyword_15());

						}

					}
					break;
					case 17 :
						// InternalQVTbase.g:2946:2: kw= 'xor'
					{
						kw=(Token)match(input,86,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_16());

						}

					}
					break;
					case 18 :
						// InternalQVTbase.g:2953:2: kw= 'xor2'
					{
						kw=(Token)match(input,87,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXor2Keyword_17());

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
	// InternalQVTbase.g:2966:1: entryRuleEssentialOCLNavigationOperatorName returns [String current=null] : iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF ;
	public final String entryRuleEssentialOCLNavigationOperatorName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperatorName = null;


		try {
			// InternalQVTbase.g:2967:2: (iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF )
			// InternalQVTbase.g:2968:2: iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF
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
	// InternalQVTbase.g:2975:1: ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) ;
	public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperatorName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw=null;

		enterRule();

		try {
			// InternalQVTbase.g:2978:28: ( (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) )
			// InternalQVTbase.g:2979:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
			{
				// InternalQVTbase.g:2979:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
				int alt93=4;
				switch ( input.LA(1) ) {
					case 88:
					{
						alt93=1;
					}
					break;
					case 89:
					{
						alt93=2;
					}
					break;
					case 90:
					{
						alt93=3;
					}
					break;
					case 91:
					{
						alt93=4;
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
						// InternalQVTbase.g:2980:2: kw= '.'
					{
						kw=(Token)match(input,88,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0());

						}

					}
					break;
					case 2 :
						// InternalQVTbase.g:2987:2: kw= '->'
					{
						kw=(Token)match(input,89,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1());

						}

					}
					break;
					case 3 :
						// InternalQVTbase.g:2994:2: kw= '?.'
					{
						kw=(Token)match(input,90,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2());

						}

					}
					break;
					case 4 :
						// InternalQVTbase.g:3001:2: kw= '?->'
					{
						kw=(Token)match(input,91,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:3014:1: entryRuleBinaryOperatorName returns [String current=null] : iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF ;
	public final String entryRuleBinaryOperatorName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleBinaryOperatorName = null;


		try {
			// InternalQVTbase.g:3015:2: (iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF )
			// InternalQVTbase.g:3016:2: iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF
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
	// InternalQVTbase.g:3023:1: ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) ;
	public final AntlrDatatypeRuleToken ruleBinaryOperatorName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_InfixOperatorName_0 = null;

		AntlrDatatypeRuleToken this_NavigationOperatorName_1 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3026:28: ( (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) )
			// InternalQVTbase.g:3027:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
			{
				// InternalQVTbase.g:3027:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
				int alt94=2;
				int LA94_0 = input.LA(1);

				if ( (LA94_0==21||LA94_0==69||(LA94_0>=72 && LA94_0<=87)) ) {
					alt94=1;
				}
				else if ( ((LA94_0>=88 && LA94_0<=91)) ) {
					alt94=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 94, 0, input);

					throw nvae;
				}
				switch (alt94) {
					case 1 :
						// InternalQVTbase.g:3028:5: this_InfixOperatorName_0= ruleInfixOperatorName
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
						// InternalQVTbase.g:3040:5: this_NavigationOperatorName_1= ruleNavigationOperatorName
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
	// InternalQVTbase.g:3058:1: entryRuleInfixOperatorName returns [String current=null] : iv_ruleInfixOperatorName= ruleInfixOperatorName EOF ;
	public final String entryRuleInfixOperatorName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleInfixOperatorName = null;


		try {
			// InternalQVTbase.g:3059:2: (iv_ruleInfixOperatorName= ruleInfixOperatorName EOF )
			// InternalQVTbase.g:3060:2: iv_ruleInfixOperatorName= ruleInfixOperatorName EOF
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
	// InternalQVTbase.g:3067:1: ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName ;
	public final AntlrDatatypeRuleToken ruleInfixOperatorName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_EssentialOCLInfixOperatorName_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3070:28: (this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName )
			// InternalQVTbase.g:3072:5: this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName
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
	// InternalQVTbase.g:3090:1: entryRuleNavigationOperatorName returns [String current=null] : iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF ;
	public final String entryRuleNavigationOperatorName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleNavigationOperatorName = null;


		try {
			// InternalQVTbase.g:3091:2: (iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF )
			// InternalQVTbase.g:3092:2: iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF
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
	// InternalQVTbase.g:3099:1: ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName ;
	public final AntlrDatatypeRuleToken ruleNavigationOperatorName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_EssentialOCLNavigationOperatorName_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3102:28: (this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName )
			// InternalQVTbase.g:3104:5: this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName
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
	// InternalQVTbase.g:3122:1: entryRuleUnaryOperatorName returns [String current=null] : iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF ;
	public final String entryRuleUnaryOperatorName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleUnaryOperatorName = null;


		try {
			// InternalQVTbase.g:3123:2: (iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF )
			// InternalQVTbase.g:3124:2: iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF
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
	// InternalQVTbase.g:3131:1: ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName ;
	public final AntlrDatatypeRuleToken ruleUnaryOperatorName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_EssentialOCLUnaryOperatorName_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3134:28: (this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName )
			// InternalQVTbase.g:3136:5: this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName
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
	// InternalQVTbase.g:3154:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
	public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


		try {
			// InternalQVTbase.g:3155:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
			// InternalQVTbase.g:3156:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
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
	// InternalQVTbase.g:3163:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
	public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_Identifier_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3166:28: (this_Identifier_0= ruleIdentifier )
			// InternalQVTbase.g:3168:5: this_Identifier_0= ruleIdentifier
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


	// $ANTLR start "entryRuleUnrestrictedName"
	// InternalQVTbase.g:3186:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
	public final String entryRuleUnrestrictedName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


		try {
			// InternalQVTbase.g:3187:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
			// InternalQVTbase.g:3188:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
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
	// InternalQVTbase.g:3195:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
	public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3198:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
			// InternalQVTbase.g:3200:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
			{
				if ( state.backtracking==0 ) {

					newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall());

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

			if ( state.backtracking==0 ) {
				leaveRule();
			}
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


	// $ANTLR start "entryRuleEssentialOCLUnreservedName"
	// InternalQVTbase.g:3218:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
	public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


		try {
			// InternalQVTbase.g:3219:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
			// InternalQVTbase.g:3220:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
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
	// InternalQVTbase.g:3227:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) ;
	public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw=null;
		AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

		AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

		AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3230:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) )
			// InternalQVTbase.g:3231:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
			{
				// InternalQVTbase.g:3231:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
				int alt95=5;
				switch ( input.LA(1) ) {
					case RULE_SIMPLE_ID:
					case RULE_ESCAPED_ID:
					{
						alt95=1;
					}
					break;
					case 102:
					case 103:
					case 104:
					case 105:
					case 106:
					{
						alt95=2;
					}
					break;
					case 94:
					case 95:
					case 96:
					case 97:
					case 98:
					case 99:
					case 100:
					case 101:
					{
						alt95=3;
					}
					break;
					case 92:
					{
						alt95=4;
					}
					break;
					case 93:
					{
						alt95=5;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 95, 0, input);

						throw nvae;
				}

				switch (alt95) {
					case 1 :
						// InternalQVTbase.g:3232:5: this_UnrestrictedName_0= ruleUnrestrictedName
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
						// InternalQVTbase.g:3244:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
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
						// InternalQVTbase.g:3256:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
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
						// InternalQVTbase.g:3268:2: kw= 'Map'
					{
						kw=(Token)match(input,92,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3());

						}

					}
					break;
					case 5 :
						// InternalQVTbase.g:3275:2: kw= 'Tuple'
					{
						kw=(Token)match(input,93,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:3288:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
	public final String entryRuleUnreservedName() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


		try {
			// InternalQVTbase.g:3289:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
			// InternalQVTbase.g:3290:2: iv_ruleUnreservedName= ruleUnreservedName EOF
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
	// InternalQVTbase.g:3297:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
	public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3300:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
			// InternalQVTbase.g:3302:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
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


	// $ANTLR start "entryRuleURIFirstPathElementCS"
	// InternalQVTbase.g:3322:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
	public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleURIFirstPathElementCS = null;


		try {
			// InternalQVTbase.g:3323:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
			// InternalQVTbase.g:3324:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
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
	// InternalQVTbase.g:3331:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
	public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
		EObject current = null;

		enterRule();

		try {
			// InternalQVTbase.g:3334:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
			// InternalQVTbase.g:3335:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
			{
				// InternalQVTbase.g:3335:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
				int alt96=2;
				int LA96_0 = input.LA(1);

				if ( ((LA96_0>=RULE_SIMPLE_ID && LA96_0<=RULE_ESCAPED_ID)) ) {
					alt96=1;
				}
				else if ( (LA96_0==RULE_SINGLE_QUOTED_STRING) ) {
					alt96=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 96, 0, input);

					throw nvae;
				}
				switch (alt96) {
					case 1 :
						// InternalQVTbase.g:3335:2: ( ( ruleUnrestrictedName ) )
					{
						// InternalQVTbase.g:3335:2: ( ( ruleUnrestrictedName ) )
						// InternalQVTbase.g:3336:1: ( ruleUnrestrictedName )
						{
							// InternalQVTbase.g:3336:1: ( ruleUnrestrictedName )
							// InternalQVTbase.g:3337:3: ruleUnrestrictedName
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
						// InternalQVTbase.g:3354:6: ( () ( ( ruleURI ) ) )
					{
						// InternalQVTbase.g:3354:6: ( () ( ( ruleURI ) ) )
						// InternalQVTbase.g:3354:7: () ( ( ruleURI ) )
						{
							// InternalQVTbase.g:3354:7: ()
							// InternalQVTbase.g:3355:2:
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

							// InternalQVTbase.g:3363:2: ( ( ruleURI ) )
							// InternalQVTbase.g:3364:1: ( ruleURI )
							{
								// InternalQVTbase.g:3364:1: ( ruleURI )
								// InternalQVTbase.g:3365:3: ruleURI
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
	// InternalQVTbase.g:3391:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
	public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


		try {
			// InternalQVTbase.g:3392:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
			// InternalQVTbase.g:3393:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
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
	// InternalQVTbase.g:3400:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
	public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw=null;

		enterRule();

		try {
			// InternalQVTbase.g:3403:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
			// InternalQVTbase.g:3404:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
			{
				// InternalQVTbase.g:3404:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
				int alt97=8;
				switch ( input.LA(1) ) {
					case 94:
					{
						alt97=1;
					}
					break;
					case 95:
					{
						alt97=2;
					}
					break;
					case 96:
					{
						alt97=3;
					}
					break;
					case 97:
					{
						alt97=4;
					}
					break;
					case 98:
					{
						alt97=5;
					}
					break;
					case 99:
					{
						alt97=6;
					}
					break;
					case 100:
					{
						alt97=7;
					}
					break;
					case 101:
					{
						alt97=8;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 97, 0, input);

						throw nvae;
				}

				switch (alt97) {
					case 1 :
						// InternalQVTbase.g:3405:2: kw= 'Boolean'
					{
						kw=(Token)match(input,94,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0());

						}

					}
					break;
					case 2 :
						// InternalQVTbase.g:3412:2: kw= 'Integer'
					{
						kw=(Token)match(input,95,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1());

						}

					}
					break;
					case 3 :
						// InternalQVTbase.g:3419:2: kw= 'Real'
					{
						kw=(Token)match(input,96,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2());

						}

					}
					break;
					case 4 :
						// InternalQVTbase.g:3426:2: kw= 'String'
					{
						kw=(Token)match(input,97,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3());

						}

					}
					break;
					case 5 :
						// InternalQVTbase.g:3433:2: kw= 'UnlimitedNatural'
					{
						kw=(Token)match(input,98,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4());

						}

					}
					break;
					case 6 :
						// InternalQVTbase.g:3440:2: kw= 'OclAny'
					{
						kw=(Token)match(input,99,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5());

						}

					}
					break;
					case 7 :
						// InternalQVTbase.g:3447:2: kw= 'OclInvalid'
					{
						kw=(Token)match(input,100,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6());

						}

					}
					break;
					case 8 :
						// InternalQVTbase.g:3454:2: kw= 'OclVoid'
					{
						kw=(Token)match(input,101,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:3467:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
	public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePrimitiveTypeCS = null;


		try {
			// InternalQVTbase.g:3468:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
			// InternalQVTbase.g:3469:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
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
	// InternalQVTbase.g:3476:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
	public final EObject rulePrimitiveTypeCS() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_0_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3479:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
			// InternalQVTbase.g:3480:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
			{
				// InternalQVTbase.g:3480:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
				// InternalQVTbase.g:3481:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
				{
					// InternalQVTbase.g:3481:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
					// InternalQVTbase.g:3482:3: lv_name_0_0= rulePrimitiveTypeIdentifier
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
	// InternalQVTbase.g:3506:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
	public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


		try {
			// InternalQVTbase.g:3507:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
			// InternalQVTbase.g:3508:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
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
	// InternalQVTbase.g:3515:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
	public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw=null;

		enterRule();

		try {
			// InternalQVTbase.g:3518:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
			// InternalQVTbase.g:3519:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
			{
				// InternalQVTbase.g:3519:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
				int alt98=5;
				switch ( input.LA(1) ) {
					case 102:
					{
						alt98=1;
					}
					break;
					case 103:
					{
						alt98=2;
					}
					break;
					case 104:
					{
						alt98=3;
					}
					break;
					case 105:
					{
						alt98=4;
					}
					break;
					case 106:
					{
						alt98=5;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 98, 0, input);

						throw nvae;
				}

				switch (alt98) {
					case 1 :
						// InternalQVTbase.g:3520:2: kw= 'Set'
					{
						kw=(Token)match(input,102,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0());

						}

					}
					break;
					case 2 :
						// InternalQVTbase.g:3527:2: kw= 'Bag'
					{
						kw=(Token)match(input,103,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1());

						}

					}
					break;
					case 3 :
						// InternalQVTbase.g:3534:2: kw= 'Sequence'
					{
						kw=(Token)match(input,104,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2());

						}

					}
					break;
					case 4 :
						// InternalQVTbase.g:3541:2: kw= 'Collection'
					{
						kw=(Token)match(input,105,FollowSets000.FOLLOW_2); if (state.failed) return current;
						if ( state.backtracking==0 ) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3());

						}

					}
					break;
					case 5 :
						// InternalQVTbase.g:3548:2: kw= 'OrderedSet'
					{
						kw=(Token)match(input,106,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:3561:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
	public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCollectionTypeCS = null;


		try {
			// InternalQVTbase.g:3562:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
			// InternalQVTbase.g:3563:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
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
	// InternalQVTbase.g:3570:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) ) ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )? otherlv_4= ')' )? ) ;
	public final EObject ruleCollectionTypeCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_4=null;
		AntlrDatatypeRuleToken lv_name_0_0 = null;

		EObject lv_ownedType_2_0 = null;

		EObject lv_ownedCollectionMultiplicity_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3573:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) ) ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )? otherlv_4= ')' )? ) )
			// InternalQVTbase.g:3574:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) ) ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )? otherlv_4= ')' )? )
			{
				// InternalQVTbase.g:3574:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) ) ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )? otherlv_4= ')' )? )
				// InternalQVTbase.g:3574:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) ) ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )? otherlv_4= ')' )?
				{
					// InternalQVTbase.g:3574:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
					// InternalQVTbase.g:3575:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
					{
						// InternalQVTbase.g:3575:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
						// InternalQVTbase.g:3576:3: lv_name_0_0= ruleCollectionTypeIdentifier
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_67);
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

					// InternalQVTbase.g:3592:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) ) ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )? otherlv_4= ')' )?
					int alt100=2;
					int LA100_0 = input.LA(1);

					if ( (LA100_0==51) ) {
						alt100=1;
					}
					switch (alt100) {
						case 1 :
							// InternalQVTbase.g:3592:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) ) ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )? otherlv_4= ')'
						{
							otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());

							}
							// InternalQVTbase.g:3596:1: ( (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS ) )
							// InternalQVTbase.g:3597:1: (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS )
							{
								// InternalQVTbase.g:3597:1: (lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS )
								// InternalQVTbase.g:3598:3: lv_ownedType_2_0= ruleTypeExpWithoutMultiplicityCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_68);
									lv_ownedType_2_0=ruleTypeExpWithoutMultiplicityCS();

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
											"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpWithoutMultiplicityCS");
										afterParserOrEnumRuleCall();

									}

								}


							}

							// InternalQVTbase.g:3614:2: ( (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS ) )?
							int alt99=2;
							int LA99_0 = input.LA(1);

							if ( (LA99_0==117) ) {
								alt99=1;
							}
							switch (alt99) {
								case 1 :
									// InternalQVTbase.g:3615:1: (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS )
								{
									// InternalQVTbase.g:3615:1: (lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS )
									// InternalQVTbase.g:3616:3: lv_ownedCollectionMultiplicity_3_0= ruleMultiplicityCS
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0());

										}
										pushFollow(FollowSets000.FOLLOW_69);
										lv_ownedCollectionMultiplicity_3_0=ruleMultiplicityCS();

										state._fsp--;
										if (state.failed) return current;
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
											}
											set(
												current,
												"ownedCollectionMultiplicity",
												lv_ownedCollectionMultiplicity_3_0,
												"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
											afterParserOrEnumRuleCall();

										}

									}


								}
								break;

							}

							otherlv_4=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_4, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_3());

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
	// InternalQVTbase.g:3644:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
	public final EObject entryRuleMapTypeCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMapTypeCS = null;


		try {
			// InternalQVTbase.g:3645:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
			// InternalQVTbase.g:3646:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
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
	// InternalQVTbase.g:3653:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) ;
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
			// InternalQVTbase.g:3656:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) )
			// InternalQVTbase.g:3657:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
			{
				// InternalQVTbase.g:3657:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
				// InternalQVTbase.g:3657:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
				{
					// InternalQVTbase.g:3657:2: ( (lv_name_0_0= 'Map' ) )
					// InternalQVTbase.g:3658:1: (lv_name_0_0= 'Map' )
					{
						// InternalQVTbase.g:3658:1: (lv_name_0_0= 'Map' )
						// InternalQVTbase.g:3659:3: lv_name_0_0= 'Map'
						{
							lv_name_0_0=(Token)match(input,92,FollowSets000.FOLLOW_67); if (state.failed) return current;
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

					// InternalQVTbase.g:3672:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
					int alt101=2;
					int LA101_0 = input.LA(1);

					if ( (LA101_0==51) ) {
						alt101=1;
					}
					switch (alt101) {
						case 1 :
							// InternalQVTbase.g:3672:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
						{
							otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());

							}
							// InternalQVTbase.g:3676:1: ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:3677:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:3677:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
								// InternalQVTbase.g:3678:3: lv_ownedKeyType_2_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_70);
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

							otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());

							}
							// InternalQVTbase.g:3698:1: ( (lv_ownedValueType_4_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:3699:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:3699:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
								// InternalQVTbase.g:3700:3: lv_ownedValueType_4_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0());

									}
									pushFollow(FollowSets000.FOLLOW_69);
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

							otherlv_5=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:3728:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
	public final EObject entryRuleTupleTypeCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTupleTypeCS = null;


		try {
			// InternalQVTbase.g:3729:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
			// InternalQVTbase.g:3730:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
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
	// InternalQVTbase.g:3737:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
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
			// InternalQVTbase.g:3740:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
			// InternalQVTbase.g:3741:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
			{
				// InternalQVTbase.g:3741:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
				// InternalQVTbase.g:3741:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
				{
					// InternalQVTbase.g:3741:2: ( (lv_name_0_0= 'Tuple' ) )
					// InternalQVTbase.g:3742:1: (lv_name_0_0= 'Tuple' )
					{
						// InternalQVTbase.g:3742:1: (lv_name_0_0= 'Tuple' )
						// InternalQVTbase.g:3743:3: lv_name_0_0= 'Tuple'
						{
							lv_name_0_0=(Token)match(input,93,FollowSets000.FOLLOW_67); if (state.failed) return current;
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

					// InternalQVTbase.g:3756:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
					int alt104=2;
					int LA104_0 = input.LA(1);

					if ( (LA104_0==51) ) {
						alt104=1;
					}
					switch (alt104) {
						case 1 :
							// InternalQVTbase.g:3756:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
						{
							otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_34); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());

							}
							// InternalQVTbase.g:3760:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
							int alt103=2;
							int LA103_0 = input.LA(1);

							if ( ((LA103_0>=RULE_SIMPLE_ID && LA103_0<=RULE_ESCAPED_ID)) ) {
								alt103=1;
							}
							switch (alt103) {
								case 1 :
									// InternalQVTbase.g:3760:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
								{
									// InternalQVTbase.g:3760:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
									// InternalQVTbase.g:3761:1: (lv_ownedParts_2_0= ruleTuplePartCS )
									{
										// InternalQVTbase.g:3761:1: (lv_ownedParts_2_0= ruleTuplePartCS )
										// InternalQVTbase.g:3762:3: lv_ownedParts_2_0= ruleTuplePartCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0());

											}
											pushFollow(FollowSets000.FOLLOW_35);
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

									// InternalQVTbase.g:3778:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
									loop102:
										do {
											int alt102=2;
											int LA102_0 = input.LA(1);

											if ( (LA102_0==39) ) {
												alt102=1;
											}


											switch (alt102) {
												case 1 :
													// InternalQVTbase.g:3778:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
												{
													otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
													if ( state.backtracking==0 ) {

														newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());

													}
													// InternalQVTbase.g:3782:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
													// InternalQVTbase.g:3783:1: (lv_ownedParts_4_0= ruleTuplePartCS )
													{
														// InternalQVTbase.g:3783:1: (lv_ownedParts_4_0= ruleTuplePartCS )
														// InternalQVTbase.g:3784:3: lv_ownedParts_4_0= ruleTuplePartCS
														{
															if ( state.backtracking==0 ) {

																newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0());

															}
															pushFollow(FollowSets000.FOLLOW_35);
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
													break loop102;
											}
										} while (true);


								}
								break;

							}

							otherlv_5=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:3812:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
	public final EObject entryRuleTuplePartCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTuplePartCS = null;


		try {
			// InternalQVTbase.g:3813:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
			// InternalQVTbase.g:3814:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
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
	// InternalQVTbase.g:3821:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
	public final EObject ruleTuplePartCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		AntlrDatatypeRuleToken lv_name_0_0 = null;

		EObject lv_ownedType_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3824:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
			// InternalQVTbase.g:3825:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
			{
				// InternalQVTbase.g:3825:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
				// InternalQVTbase.g:3825:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
				{
					// InternalQVTbase.g:3825:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:3826:1: (lv_name_0_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:3826:1: (lv_name_0_0= ruleUnrestrictedName )
						// InternalQVTbase.g:3827:3: lv_name_0_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_17);
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
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());

					}
					// InternalQVTbase.g:3847:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
					// InternalQVTbase.g:3848:1: (lv_ownedType_2_0= ruleTypeExpCS )
					{
						// InternalQVTbase.g:3848:1: (lv_ownedType_2_0= ruleTypeExpCS )
						// InternalQVTbase.g:3849:3: lv_ownedType_2_0= ruleTypeExpCS
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
	// InternalQVTbase.g:3873:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
	public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCollectionLiteralExpCS = null;


		try {
			// InternalQVTbase.g:3874:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
			// InternalQVTbase.g:3875:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
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
	// InternalQVTbase.g:3882:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
			// InternalQVTbase.g:3885:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
			// InternalQVTbase.g:3886:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
			{
				// InternalQVTbase.g:3886:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
				// InternalQVTbase.g:3886:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
				{
					// InternalQVTbase.g:3886:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
					// InternalQVTbase.g:3887:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
					{
						// InternalQVTbase.g:3887:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
						// InternalQVTbase.g:3888:3: lv_ownedType_0_0= ruleCollectionTypeCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_71);
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

					otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_72); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

					}
					// InternalQVTbase.g:3908:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
					int alt106=2;
					int LA106_0 = input.LA(1);

					if ( (LA106_0==RULE_SINGLE_QUOTED_STRING||(LA106_0>=RULE_INT && LA106_0<=RULE_ESCAPED_ID)||LA106_0==20||LA106_0==51||(LA106_0>=69 && LA106_0<=72)||(LA106_0>=92 && LA106_0<=106)||LA106_0==109||(LA106_0>=111 && LA106_0<=114)||LA106_0==121||(LA106_0>=126 && LA106_0<=127)) ) {
						alt106=1;
					}
					switch (alt106) {
						case 1 :
							// InternalQVTbase.g:3908:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
						{
							// InternalQVTbase.g:3908:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
							// InternalQVTbase.g:3909:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
							{
								// InternalQVTbase.g:3909:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
								// InternalQVTbase.g:3910:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_58);
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

							// InternalQVTbase.g:3926:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
							loop105:
								do {
									int alt105=2;
									int LA105_0 = input.LA(1);

									if ( (LA105_0==39) ) {
										alt105=1;
									}


									switch (alt105) {
										case 1 :
											// InternalQVTbase.g:3926:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
										{
											otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_73); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());

											}
											// InternalQVTbase.g:3930:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
											// InternalQVTbase.g:3931:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
											{
												// InternalQVTbase.g:3931:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
												// InternalQVTbase.g:3932:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_58);
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
											break loop105;
									}
								} while (true);


						}
						break;

					}

					otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:3960:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
	public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCollectionLiteralPartCS = null;


		try {
			// InternalQVTbase.g:3961:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
			// InternalQVTbase.g:3962:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
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
	// InternalQVTbase.g:3969:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
	public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		EObject lv_ownedExpression_0_0 = null;

		EObject lv_ownedLastExpression_2_0 = null;

		EObject lv_ownedExpression_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:3972:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
			// InternalQVTbase.g:3973:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
			{
				// InternalQVTbase.g:3973:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
				int alt108=2;
				switch ( input.LA(1) ) {
					case RULE_SINGLE_QUOTED_STRING:
					case RULE_INT:
					case 51:
					case 69:
					case 70:
					case 71:
					case 72:
					case 92:
					case 93:
					case 94:
					case 95:
					case 96:
					case 97:
					case 98:
					case 99:
					case 100:
					case 101:
					case 102:
					case 103:
					case 104:
					case 105:
					case 106:
					case 109:
					case 111:
					case 112:
					case 113:
					case 114:
					case 121:
					case 126:
					case 127:
					{
						alt108=1;
					}
					break;
					case RULE_SIMPLE_ID:
					{
						int LA108_2 = input.LA(2);

						if ( (LA108_2==EOF||(LA108_2>=21 && LA108_2<=22)||(LA108_2>=39 && LA108_2<=40)||LA108_2==51||LA108_2==69||(LA108_2>=72 && LA108_2<=91)||LA108_2==107||LA108_2==115||LA108_2==117||LA108_2==131) ) {
							alt108=1;
						}
						else if ( (LA108_2==20) ) {
							alt108=2;
						}
						else {
							if (state.backtracking>0) {state.failed=true; return current;}
							NoViableAltException nvae =
									new NoViableAltException("", 108, 2, input);

							throw nvae;
						}
					}
					break;
					case RULE_ESCAPED_ID:
					{
						int LA108_3 = input.LA(2);

						if ( (LA108_3==EOF||(LA108_3>=21 && LA108_3<=22)||(LA108_3>=39 && LA108_3<=40)||LA108_3==51||LA108_3==69||(LA108_3>=72 && LA108_3<=91)||LA108_3==107||LA108_3==115||LA108_3==117||LA108_3==131) ) {
							alt108=1;
						}
						else if ( (LA108_3==20) ) {
							alt108=2;
						}
						else {
							if (state.backtracking>0) {state.failed=true; return current;}
							NoViableAltException nvae =
									new NoViableAltException("", 108, 3, input);

							throw nvae;
						}
					}
					break;
					case 20:
					{
						alt108=2;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 108, 0, input);

						throw nvae;
				}

				switch (alt108) {
					case 1 :
						// InternalQVTbase.g:3973:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
					{
						// InternalQVTbase.g:3973:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
						// InternalQVTbase.g:3973:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
						{
							// InternalQVTbase.g:3973:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
							// InternalQVTbase.g:3974:1: (lv_ownedExpression_0_0= ruleExpCS )
							{
								// InternalQVTbase.g:3974:1: (lv_ownedExpression_0_0= ruleExpCS )
								// InternalQVTbase.g:3975:3: lv_ownedExpression_0_0= ruleExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_74);
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

							// InternalQVTbase.g:3991:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
							int alt107=2;
							int LA107_0 = input.LA(1);

							if ( (LA107_0==107) ) {
								alt107=1;
							}
							switch (alt107) {
								case 1 :
									// InternalQVTbase.g:3991:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
								{
									otherlv_1=(Token)match(input,107,FollowSets000.FOLLOW_75); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());

									}
									// InternalQVTbase.g:3995:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
									// InternalQVTbase.g:3996:1: (lv_ownedLastExpression_2_0= ruleExpCS )
									{
										// InternalQVTbase.g:3996:1: (lv_ownedLastExpression_2_0= ruleExpCS )
										// InternalQVTbase.g:3997:3: lv_ownedLastExpression_2_0= ruleExpCS
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
						// InternalQVTbase.g:4014:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
					{
						// InternalQVTbase.g:4014:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
						// InternalQVTbase.g:4015:1: (lv_ownedExpression_3_0= rulePatternExpCS )
						{
							// InternalQVTbase.g:4015:1: (lv_ownedExpression_3_0= rulePatternExpCS )
							// InternalQVTbase.g:4016:3: lv_ownedExpression_3_0= rulePatternExpCS
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
	// InternalQVTbase.g:4040:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
	public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCollectionPatternCS = null;


		try {
			// InternalQVTbase.g:4041:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
			// InternalQVTbase.g:4042:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
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
	// InternalQVTbase.g:4049:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
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
			// InternalQVTbase.g:4052:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
			// InternalQVTbase.g:4053:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
			{
				// InternalQVTbase.g:4053:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
				// InternalQVTbase.g:4053:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
				{
					// InternalQVTbase.g:4053:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
					// InternalQVTbase.g:4054:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
					{
						// InternalQVTbase.g:4054:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
						// InternalQVTbase.g:4055:3: lv_ownedType_0_0= ruleCollectionTypeCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_71);
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

					otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_72); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());

					}
					// InternalQVTbase.g:4075:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
					int alt110=2;
					int LA110_0 = input.LA(1);

					if ( ((LA110_0>=RULE_SIMPLE_ID && LA110_0<=RULE_ESCAPED_ID)||LA110_0==20) ) {
						alt110=1;
					}
					switch (alt110) {
						case 1 :
							// InternalQVTbase.g:4075:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
						{
							// InternalQVTbase.g:4075:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
							// InternalQVTbase.g:4076:1: (lv_ownedParts_2_0= rulePatternExpCS )
							{
								// InternalQVTbase.g:4076:1: (lv_ownedParts_2_0= rulePatternExpCS )
								// InternalQVTbase.g:4077:3: lv_ownedParts_2_0= rulePatternExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_76);
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

							// InternalQVTbase.g:4093:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
							loop109:
								do {
									int alt109=2;
									int LA109_0 = input.LA(1);

									if ( (LA109_0==39) ) {
										alt109=1;
									}


									switch (alt109) {
										case 1 :
											// InternalQVTbase.g:4093:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
										{
											otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_73); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());

											}
											// InternalQVTbase.g:4097:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
											// InternalQVTbase.g:4098:1: (lv_ownedParts_4_0= rulePatternExpCS )
											{
												// InternalQVTbase.g:4098:1: (lv_ownedParts_4_0= rulePatternExpCS )
												// InternalQVTbase.g:4099:3: lv_ownedParts_4_0= rulePatternExpCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_76);
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
											break loop109;
									}
								} while (true);

							// InternalQVTbase.g:4115:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
							// InternalQVTbase.g:4115:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
							{
								otherlv_5=(Token)match(input,108,FollowSets000.FOLLOW_6); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());

								}
								// InternalQVTbase.g:4119:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
								// InternalQVTbase.g:4120:1: (lv_restVariableName_6_0= ruleIdentifier )
								{
									// InternalQVTbase.g:4120:1: (lv_restVariableName_6_0= ruleIdentifier )
									// InternalQVTbase.g:4121:3: lv_restVariableName_6_0= ruleIdentifier
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0());

										}
										pushFollow(FollowSets000.FOLLOW_26);
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

					otherlv_7=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4149:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
	public final EObject entryRuleShadowPartCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleShadowPartCS = null;


		try {
			// InternalQVTbase.g:4150:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
			// InternalQVTbase.g:4151:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
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
	// InternalQVTbase.g:4158:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) ) ;
	public final EObject ruleShadowPartCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		EObject lv_ownedInitExpression_2_1 = null;

		EObject lv_ownedInitExpression_2_2 = null;

		EObject lv_ownedInitExpression_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:4161:28: ( ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) ) )
			// InternalQVTbase.g:4162:1: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) )
			{
				// InternalQVTbase.g:4162:1: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) | ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) ) )
				int alt112=2;
				int LA112_0 = input.LA(1);

				if ( ((LA112_0>=RULE_SIMPLE_ID && LA112_0<=RULE_ESCAPED_ID)) ) {
					alt112=1;
				}
				else if ( (LA112_0==RULE_SINGLE_QUOTED_STRING) ) {
					alt112=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 112, 0, input);

					throw nvae;
				}
				switch (alt112) {
					case 1 :
						// InternalQVTbase.g:4162:2: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
					{
						// InternalQVTbase.g:4162:2: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
						// InternalQVTbase.g:4162:3: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
						{
							// InternalQVTbase.g:4162:3: ( ( ruleUnrestrictedName ) )
							// InternalQVTbase.g:4163:1: ( ruleUnrestrictedName )
							{
								// InternalQVTbase.g:4163:1: ( ruleUnrestrictedName )
								// InternalQVTbase.g:4164:3: ruleUnrestrictedName
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

										newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_77);
									ruleUnrestrictedName();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										afterParserOrEnumRuleCall();

									}

								}


							}

							otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_73); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1());

							}
							// InternalQVTbase.g:4184:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
							// InternalQVTbase.g:4185:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
							{
								// InternalQVTbase.g:4185:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
								// InternalQVTbase.g:4186:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
								{
									// InternalQVTbase.g:4186:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
									int alt111=2;
									switch ( input.LA(1) ) {
										case RULE_SINGLE_QUOTED_STRING:
										case RULE_INT:
										case 51:
										case 69:
										case 70:
										case 71:
										case 72:
										case 92:
										case 93:
										case 94:
										case 95:
										case 96:
										case 97:
										case 98:
										case 99:
										case 100:
										case 101:
										case 102:
										case 103:
										case 104:
										case 105:
										case 106:
										case 109:
										case 111:
										case 112:
										case 113:
										case 114:
										case 121:
										case 126:
										case 127:
										{
											alt111=1;
										}
										break;
										case RULE_SIMPLE_ID:
										{
											int LA111_2 = input.LA(2);

											if ( (LA111_2==EOF||(LA111_2>=21 && LA111_2<=22)||(LA111_2>=39 && LA111_2<=40)||LA111_2==51||LA111_2==69||(LA111_2>=72 && LA111_2<=91)||LA111_2==115||LA111_2==117||LA111_2==131) ) {
												alt111=1;
											}
											else if ( (LA111_2==20) ) {
												alt111=2;
											}
											else {
												if (state.backtracking>0) {state.failed=true; return current;}
												NoViableAltException nvae =
														new NoViableAltException("", 111, 2, input);

												throw nvae;
											}
										}
										break;
										case RULE_ESCAPED_ID:
										{
											int LA111_3 = input.LA(2);

											if ( (LA111_3==20) ) {
												alt111=2;
											}
											else if ( (LA111_3==EOF||(LA111_3>=21 && LA111_3<=22)||(LA111_3>=39 && LA111_3<=40)||LA111_3==51||LA111_3==69||(LA111_3>=72 && LA111_3<=91)||LA111_3==115||LA111_3==117||LA111_3==131) ) {
												alt111=1;
											}
											else {
												if (state.backtracking>0) {state.failed=true; return current;}
												NoViableAltException nvae =
														new NoViableAltException("", 111, 3, input);

												throw nvae;
											}
										}
										break;
										case 20:
										{
											alt111=2;
										}
										break;
										default:
											if (state.backtracking>0) {state.failed=true; return current;}
											NoViableAltException nvae =
													new NoViableAltException("", 111, 0, input);

											throw nvae;
									}

									switch (alt111) {
										case 1 :
											// InternalQVTbase.g:4187:3: lv_ownedInitExpression_2_1= ruleExpCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0());

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
											// InternalQVTbase.g:4202:8: lv_ownedInitExpression_2_2= rulePatternExpCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1());

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
					break;
					case 2 :
						// InternalQVTbase.g:4221:6: ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) )
					{
						// InternalQVTbase.g:4221:6: ( (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS ) )
						// InternalQVTbase.g:4222:1: (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS )
						{
							// InternalQVTbase.g:4222:1: (lv_ownedInitExpression_3_0= ruleStringLiteralExpCS )
							// InternalQVTbase.g:4223:3: lv_ownedInitExpression_3_0= ruleStringLiteralExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedInitExpression_3_0=ruleStringLiteralExpCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
									}
									set(
										current,
										"ownedInitExpression",
										lv_ownedInitExpression_3_0,
										"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.StringLiteralExpCS");
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
	// $ANTLR end "ruleShadowPartCS"


	// $ANTLR start "entryRulePatternExpCS"
	// InternalQVTbase.g:4247:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
	public final EObject entryRulePatternExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePatternExpCS = null;


		try {
			// InternalQVTbase.g:4248:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
			// InternalQVTbase.g:4249:2: iv_rulePatternExpCS= rulePatternExpCS EOF
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
	// InternalQVTbase.g:4256:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
	public final EObject rulePatternExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

		EObject lv_ownedPatternType_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:4259:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
			// InternalQVTbase.g:4260:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
			{
				// InternalQVTbase.g:4260:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
				// InternalQVTbase.g:4260:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
				{
					// InternalQVTbase.g:4260:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
					int alt113=2;
					int LA113_0 = input.LA(1);

					if ( ((LA113_0>=RULE_SIMPLE_ID && LA113_0<=RULE_ESCAPED_ID)) ) {
						alt113=1;
					}
					switch (alt113) {
						case 1 :
							// InternalQVTbase.g:4261:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
						{
							// InternalQVTbase.g:4261:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
							// InternalQVTbase.g:4262:3: lv_patternVariableName_0_0= ruleUnrestrictedName
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0());

								}
								pushFollow(FollowSets000.FOLLOW_17);
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
										"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
									afterParserOrEnumRuleCall();

								}

							}


						}
						break;

					}

					otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());

					}
					// InternalQVTbase.g:4282:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
					// InternalQVTbase.g:4283:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
					{
						// InternalQVTbase.g:4283:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
						// InternalQVTbase.g:4284:3: lv_ownedPatternType_2_0= ruleTypeExpCS
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
	// InternalQVTbase.g:4308:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
	public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLambdaLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4309:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
			// InternalQVTbase.g:4310:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
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
	// InternalQVTbase.g:4317:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
	public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_ownedExpressionCS_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:4320:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
			// InternalQVTbase.g:4321:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
			{
				// InternalQVTbase.g:4321:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
				// InternalQVTbase.g:4321:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
				{
					otherlv_0=(Token)match(input,109,FollowSets000.FOLLOW_71); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());

					}
					otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

					}
					// InternalQVTbase.g:4329:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
					// InternalQVTbase.g:4330:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
					{
						// InternalQVTbase.g:4330:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
						// InternalQVTbase.g:4331:3: lv_ownedExpressionCS_2_0= ruleExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0());

							}
							pushFollow(FollowSets000.FOLLOW_26);
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

					otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4359:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
	public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMapLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4360:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
			// InternalQVTbase.g:4361:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
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
	// InternalQVTbase.g:4368:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
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
			// InternalQVTbase.g:4371:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
			// InternalQVTbase.g:4372:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
			{
				// InternalQVTbase.g:4372:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
				// InternalQVTbase.g:4372:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
				{
					// InternalQVTbase.g:4372:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
					// InternalQVTbase.g:4373:1: (lv_ownedType_0_0= ruleMapTypeCS )
					{
						// InternalQVTbase.g:4373:1: (lv_ownedType_0_0= ruleMapTypeCS )
						// InternalQVTbase.g:4374:3: lv_ownedType_0_0= ruleMapTypeCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_71);
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

					otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_78); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

					}
					// InternalQVTbase.g:4394:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
					int alt115=2;
					int LA115_0 = input.LA(1);

					if ( (LA115_0==RULE_SINGLE_QUOTED_STRING||(LA115_0>=RULE_INT && LA115_0<=RULE_ESCAPED_ID)||LA115_0==51||(LA115_0>=69 && LA115_0<=72)||(LA115_0>=92 && LA115_0<=106)||LA115_0==109||(LA115_0>=111 && LA115_0<=114)||LA115_0==121||(LA115_0>=126 && LA115_0<=127)) ) {
						alt115=1;
					}
					switch (alt115) {
						case 1 :
							// InternalQVTbase.g:4394:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
						{
							// InternalQVTbase.g:4394:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
							// InternalQVTbase.g:4395:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
							{
								// InternalQVTbase.g:4395:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
								// InternalQVTbase.g:4396:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_58);
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

							// InternalQVTbase.g:4412:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
							loop114:
								do {
									int alt114=2;
									int LA114_0 = input.LA(1);

									if ( (LA114_0==39) ) {
										alt114=1;
									}


									switch (alt114) {
										case 1 :
											// InternalQVTbase.g:4412:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
										{
											otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_75); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());

											}
											// InternalQVTbase.g:4416:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
											// InternalQVTbase.g:4417:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
											{
												// InternalQVTbase.g:4417:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
												// InternalQVTbase.g:4418:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_58);
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
											break loop114;
									}
								} while (true);


						}
						break;

					}

					otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4446:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
	public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMapLiteralPartCS = null;


		try {
			// InternalQVTbase.g:4447:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
			// InternalQVTbase.g:4448:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
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
	// InternalQVTbase.g:4455:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
	public final EObject ruleMapLiteralPartCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		EObject lv_ownedKey_0_0 = null;

		EObject lv_ownedValue_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:4458:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
			// InternalQVTbase.g:4459:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
			{
				// InternalQVTbase.g:4459:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
				// InternalQVTbase.g:4459:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
				{
					// InternalQVTbase.g:4459:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
					// InternalQVTbase.g:4460:1: (lv_ownedKey_0_0= ruleExpCS )
					{
						// InternalQVTbase.g:4460:1: (lv_ownedKey_0_0= ruleExpCS )
						// InternalQVTbase.g:4461:3: lv_ownedKey_0_0= ruleExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_79);
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

					otherlv_1=(Token)match(input,110,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());

					}
					// InternalQVTbase.g:4481:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
					// InternalQVTbase.g:4482:1: (lv_ownedValue_2_0= ruleExpCS )
					{
						// InternalQVTbase.g:4482:1: (lv_ownedValue_2_0= ruleExpCS )
						// InternalQVTbase.g:4483:3: lv_ownedValue_2_0= ruleExpCS
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
	// InternalQVTbase.g:4507:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
	public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePrimitiveLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4508:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
			// InternalQVTbase.g:4509:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
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
	// InternalQVTbase.g:4516:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
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
			// InternalQVTbase.g:4519:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
			// InternalQVTbase.g:4520:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
			{
				// InternalQVTbase.g:4520:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
				int alt116=6;
				switch ( input.LA(1) ) {
					case RULE_INT:
					{
						alt116=1;
					}
					break;
					case RULE_SINGLE_QUOTED_STRING:
					{
						alt116=2;
					}
					break;
					case 111:
					case 112:
					{
						alt116=3;
					}
					break;
					case 72:
					{
						alt116=4;
					}
					break;
					case 113:
					{
						alt116=5;
					}
					break;
					case 114:
					{
						alt116=6;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 116, 0, input);

						throw nvae;
				}

				switch (alt116) {
					case 1 :
						// InternalQVTbase.g:4521:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
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
						// InternalQVTbase.g:4534:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
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
						// InternalQVTbase.g:4547:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
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
						// InternalQVTbase.g:4560:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
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
						// InternalQVTbase.g:4573:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
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
						// InternalQVTbase.g:4586:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
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
	// InternalQVTbase.g:4605:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
	public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTupleLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4606:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
			// InternalQVTbase.g:4607:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
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
	// InternalQVTbase.g:4614:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
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
			// InternalQVTbase.g:4617:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
			// InternalQVTbase.g:4618:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
			{
				// InternalQVTbase.g:4618:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
				// InternalQVTbase.g:4618:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
				{
					otherlv_0=(Token)match(input,93,FollowSets000.FOLLOW_71); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());

					}
					otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());

					}
					// InternalQVTbase.g:4626:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
					// InternalQVTbase.g:4627:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
					{
						// InternalQVTbase.g:4627:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
						// InternalQVTbase.g:4628:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0());

							}
							pushFollow(FollowSets000.FOLLOW_58);
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

					// InternalQVTbase.g:4644:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
					loop117:
						do {
							int alt117=2;
							int LA117_0 = input.LA(1);

							if ( (LA117_0==39) ) {
								alt117=1;
							}


							switch (alt117) {
								case 1 :
									// InternalQVTbase.g:4644:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
								{
									otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());

									}
									// InternalQVTbase.g:4648:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
									// InternalQVTbase.g:4649:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
									{
										// InternalQVTbase.g:4649:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
										// InternalQVTbase.g:4650:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_58);
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
									break loop117;
							}
						} while (true);

					otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4678:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
	public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTupleLiteralPartCS = null;


		try {
			// InternalQVTbase.g:4679:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
			// InternalQVTbase.g:4680:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
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
	// InternalQVTbase.g:4687:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
	public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_3=null;
		AntlrDatatypeRuleToken lv_name_0_0 = null;

		EObject lv_ownedType_2_0 = null;

		EObject lv_ownedInitExpression_4_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:4690:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
			// InternalQVTbase.g:4691:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
			{
				// InternalQVTbase.g:4691:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
				// InternalQVTbase.g:4691:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
				{
					// InternalQVTbase.g:4691:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:4692:1: (lv_name_0_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:4692:1: (lv_name_0_0= ruleUnrestrictedName )
						// InternalQVTbase.g:4693:3: lv_name_0_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_80);
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
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:4709:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
					int alt118=2;
					int LA118_0 = input.LA(1);

					if ( (LA118_0==20) ) {
						alt118=1;
					}
					switch (alt118) {
						case 1 :
							// InternalQVTbase.g:4709:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
						{
							otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());

							}
							// InternalQVTbase.g:4713:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:4714:1: (lv_ownedType_2_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:4714:1: (lv_ownedType_2_0= ruleTypeExpCS )
								// InternalQVTbase.g:4715:3: lv_ownedType_2_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_77);
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

					otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());

					}
					// InternalQVTbase.g:4735:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
					// InternalQVTbase.g:4736:1: (lv_ownedInitExpression_4_0= ruleExpCS )
					{
						// InternalQVTbase.g:4736:1: (lv_ownedInitExpression_4_0= ruleExpCS )
						// InternalQVTbase.g:4737:3: lv_ownedInitExpression_4_0= ruleExpCS
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
	// InternalQVTbase.g:4761:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
	public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNumberLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4762:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
			// InternalQVTbase.g:4763:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
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
	// InternalQVTbase.g:4770:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
	public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_symbol_0_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:4773:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
			// InternalQVTbase.g:4774:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
			{
				// InternalQVTbase.g:4774:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
				// InternalQVTbase.g:4775:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
				{
					// InternalQVTbase.g:4775:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
					// InternalQVTbase.g:4776:3: lv_symbol_0_0= ruleNUMBER_LITERAL
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
	// InternalQVTbase.g:4800:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
	public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStringLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4801:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
			// InternalQVTbase.g:4802:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
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
	// InternalQVTbase.g:4809:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
	public final EObject ruleStringLiteralExpCS() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_segments_0_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:4812:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
			// InternalQVTbase.g:4813:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
			{
				// InternalQVTbase.g:4813:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
				int cnt119=0;
				loop119:
					do {
						int alt119=2;
						int LA119_0 = input.LA(1);

						if ( (LA119_0==RULE_SINGLE_QUOTED_STRING) ) {
							alt119=1;
						}


						switch (alt119) {
							case 1 :
								// InternalQVTbase.g:4814:1: (lv_segments_0_0= ruleStringLiteral )
							{
								// InternalQVTbase.g:4814:1: (lv_segments_0_0= ruleStringLiteral )
								// InternalQVTbase.g:4815:3: lv_segments_0_0= ruleStringLiteral
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0());

									}
									pushFollow(FollowSets000.FOLLOW_81);
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
								if ( cnt119 >= 1 ) break loop119;
								if (state.backtracking>0) {state.failed=true; return current;}
								EarlyExitException eee =
										new EarlyExitException(119, input);
								throw eee;
						}
						cnt119++;
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
	// InternalQVTbase.g:4839:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
	public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleBooleanLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4840:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
			// InternalQVTbase.g:4841:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
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
	// InternalQVTbase.g:4848:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
	public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
		EObject current = null;

		Token lv_symbol_0_0=null;
		Token lv_symbol_1_0=null;

		enterRule();

		try {
			// InternalQVTbase.g:4851:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
			// InternalQVTbase.g:4852:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
			{
				// InternalQVTbase.g:4852:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
				int alt120=2;
				int LA120_0 = input.LA(1);

				if ( (LA120_0==111) ) {
					alt120=1;
				}
				else if ( (LA120_0==112) ) {
					alt120=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 120, 0, input);

					throw nvae;
				}
				switch (alt120) {
					case 1 :
						// InternalQVTbase.g:4852:2: ( (lv_symbol_0_0= 'true' ) )
					{
						// InternalQVTbase.g:4852:2: ( (lv_symbol_0_0= 'true' ) )
						// InternalQVTbase.g:4853:1: (lv_symbol_0_0= 'true' )
						{
							// InternalQVTbase.g:4853:1: (lv_symbol_0_0= 'true' )
							// InternalQVTbase.g:4854:3: lv_symbol_0_0= 'true'
							{
								lv_symbol_0_0=(Token)match(input,111,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
						// InternalQVTbase.g:4868:6: ( (lv_symbol_1_0= 'false' ) )
					{
						// InternalQVTbase.g:4868:6: ( (lv_symbol_1_0= 'false' ) )
						// InternalQVTbase.g:4869:1: (lv_symbol_1_0= 'false' )
						{
							// InternalQVTbase.g:4869:1: (lv_symbol_1_0= 'false' )
							// InternalQVTbase.g:4870:3: lv_symbol_1_0= 'false'
							{
								lv_symbol_1_0=(Token)match(input,112,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4891:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
	public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4892:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
			// InternalQVTbase.g:4893:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
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
	// InternalQVTbase.g:4900:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
	public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;

		enterRule();

		try {
			// InternalQVTbase.g:4903:28: ( ( () otherlv_1= '*' ) )
			// InternalQVTbase.g:4904:1: ( () otherlv_1= '*' )
			{
				// InternalQVTbase.g:4904:1: ( () otherlv_1= '*' )
				// InternalQVTbase.g:4904:2: () otherlv_1= '*'
				{
					// InternalQVTbase.g:4904:2: ()
					// InternalQVTbase.g:4905:2:
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

					otherlv_1=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4925:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
	public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleInvalidLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4926:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
			// InternalQVTbase.g:4927:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
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
	// InternalQVTbase.g:4934:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
	public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;

		enterRule();

		try {
			// InternalQVTbase.g:4937:28: ( ( () otherlv_1= 'invalid' ) )
			// InternalQVTbase.g:4938:1: ( () otherlv_1= 'invalid' )
			{
				// InternalQVTbase.g:4938:1: ( () otherlv_1= 'invalid' )
				// InternalQVTbase.g:4938:2: () otherlv_1= 'invalid'
				{
					// InternalQVTbase.g:4938:2: ()
					// InternalQVTbase.g:4939:2:
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

					otherlv_1=(Token)match(input,113,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4959:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
	public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNullLiteralExpCS = null;


		try {
			// InternalQVTbase.g:4960:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
			// InternalQVTbase.g:4961:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
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
	// InternalQVTbase.g:4968:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
	public final EObject ruleNullLiteralExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;

		enterRule();

		try {
			// InternalQVTbase.g:4971:28: ( ( () otherlv_1= 'null' ) )
			// InternalQVTbase.g:4972:1: ( () otherlv_1= 'null' )
			{
				// InternalQVTbase.g:4972:1: ( () otherlv_1= 'null' )
				// InternalQVTbase.g:4972:2: () otherlv_1= 'null'
				{
					// InternalQVTbase.g:4972:2: ()
					// InternalQVTbase.g:4973:2:
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

					otherlv_1=(Token)match(input,114,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:4993:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
	public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeLiteralCS = null;


		try {
			// InternalQVTbase.g:4994:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
			// InternalQVTbase.g:4995:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
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
	// InternalQVTbase.g:5002:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) ;
	public final EObject ruleTypeLiteralCS() throws RecognitionException {
		EObject current = null;

		EObject this_PrimitiveTypeCS_0 = null;

		EObject this_CollectionTypeCS_1 = null;

		EObject this_MapTypeCS_2 = null;

		EObject this_TupleTypeCS_3 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5005:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS ) )
			// InternalQVTbase.g:5006:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
			{
				// InternalQVTbase.g:5006:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS )
				int alt121=4;
				switch ( input.LA(1) ) {
					case 94:
					case 95:
					case 96:
					case 97:
					case 98:
					case 99:
					case 100:
					case 101:
					{
						alt121=1;
					}
					break;
					case 102:
					case 103:
					case 104:
					case 105:
					case 106:
					{
						alt121=2;
					}
					break;
					case 92:
					{
						alt121=3;
					}
					break;
					case 93:
					{
						alt121=4;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 121, 0, input);

						throw nvae;
				}

				switch (alt121) {
					case 1 :
						// InternalQVTbase.g:5007:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
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
						// InternalQVTbase.g:5020:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
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
						// InternalQVTbase.g:5033:2: this_MapTypeCS_2= ruleMapTypeCS
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
						// InternalQVTbase.g:5046:2: this_TupleTypeCS_3= ruleTupleTypeCS
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
	// InternalQVTbase.g:5065:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
	public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


		try {
			// InternalQVTbase.g:5066:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
			// InternalQVTbase.g:5067:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
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
	// InternalQVTbase.g:5074:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
	public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
		EObject current = null;

		EObject this_TypeLiteralCS_0 = null;

		EObject lv_ownedMultiplicity_1_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5077:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
			// InternalQVTbase.g:5078:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
			{
				// InternalQVTbase.g:5078:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
				// InternalQVTbase.g:5079:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
				{
					if ( state.backtracking==0 ) {

						/* */

					}
					if ( state.backtracking==0 ) {

						newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0());

					}
					pushFollow(FollowSets000.FOLLOW_65);
					this_TypeLiteralCS_0=ruleTypeLiteralCS();

					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {

						current = this_TypeLiteralCS_0;
						afterParserOrEnumRuleCall();

					}
					// InternalQVTbase.g:5090:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
					int alt122=2;
					int LA122_0 = input.LA(1);

					if ( (LA122_0==117) ) {
						alt122=1;
					}
					switch (alt122) {
						case 1 :
							// InternalQVTbase.g:5091:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
						{
							// InternalQVTbase.g:5091:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
							// InternalQVTbase.g:5092:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
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
	// InternalQVTbase.g:5116:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
	public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeLiteralExpCS = null;


		try {
			// InternalQVTbase.g:5117:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
			// InternalQVTbase.g:5118:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
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
	// InternalQVTbase.g:5125:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
	public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
		EObject current = null;

		EObject lv_ownedType_0_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5128:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
			// InternalQVTbase.g:5129:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
			{
				// InternalQVTbase.g:5129:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
				// InternalQVTbase.g:5130:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
				{
					// InternalQVTbase.g:5130:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
					// InternalQVTbase.g:5131:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
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
	// InternalQVTbase.g:5155:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
	public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeNameExpCS = null;


		try {
			// InternalQVTbase.g:5156:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
			// InternalQVTbase.g:5157:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
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
	// InternalQVTbase.g:5164:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) ;
	public final EObject ruleTypeNameExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_ownedPathName_0_0 = null;

		EObject lv_ownedCurlyBracketedClause_1_0 = null;

		EObject lv_ownedPatternGuard_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5167:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) )
			// InternalQVTbase.g:5168:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
			{
				// InternalQVTbase.g:5168:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
				// InternalQVTbase.g:5168:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
				{
					// InternalQVTbase.g:5168:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
					// InternalQVTbase.g:5169:1: (lv_ownedPathName_0_0= rulePathNameCS )
					{
						// InternalQVTbase.g:5169:1: (lv_ownedPathName_0_0= rulePathNameCS )
						// InternalQVTbase.g:5170:3: lv_ownedPathName_0_0= rulePathNameCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_44);
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

					// InternalQVTbase.g:5186:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
					int alt124=2;
					int LA124_0 = input.LA(1);

					if ( (LA124_0==22) ) {
						alt124=1;
					}
					switch (alt124) {
						case 1 :
							// InternalQVTbase.g:5186:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
						{
							// InternalQVTbase.g:5186:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
							// InternalQVTbase.g:5187:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
							{
								// InternalQVTbase.g:5187:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
								// InternalQVTbase.g:5188:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_44);
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

							// InternalQVTbase.g:5204:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
							int alt123=2;
							int LA123_0 = input.LA(1);

							if ( (LA123_0==22) ) {
								alt123=1;
							}
							switch (alt123) {
								case 1 :
									// InternalQVTbase.g:5204:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
								{
									otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_75); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());

									}
									// InternalQVTbase.g:5208:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
									// InternalQVTbase.g:5209:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
									{
										// InternalQVTbase.g:5209:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
										// InternalQVTbase.g:5210:3: lv_ownedPatternGuard_3_0= ruleExpCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_26);
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

									otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
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


	// $ANTLR start "entryRuleTypeExpWithoutMultiplicityCS"
	// InternalQVTbase.g:5238:1: entryRuleTypeExpWithoutMultiplicityCS returns [EObject current=null] : iv_ruleTypeExpWithoutMultiplicityCS= ruleTypeExpWithoutMultiplicityCS EOF ;
	public final EObject entryRuleTypeExpWithoutMultiplicityCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeExpWithoutMultiplicityCS = null;


		try {
			// InternalQVTbase.g:5239:2: (iv_ruleTypeExpWithoutMultiplicityCS= ruleTypeExpWithoutMultiplicityCS EOF )
			// InternalQVTbase.g:5240:2: iv_ruleTypeExpWithoutMultiplicityCS= ruleTypeExpWithoutMultiplicityCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleTypeExpWithoutMultiplicityCS=ruleTypeExpWithoutMultiplicityCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleTypeExpWithoutMultiplicityCS;
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
	// $ANTLR end "entryRuleTypeExpWithoutMultiplicityCS"


	// $ANTLR start "ruleTypeExpWithoutMultiplicityCS"
	// InternalQVTbase.g:5247:1: ruleTypeExpWithoutMultiplicityCS returns [EObject current=null] : (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ;
	public final EObject ruleTypeExpWithoutMultiplicityCS() throws RecognitionException {
		EObject current = null;

		EObject this_TypeNameExpCS_0 = null;

		EObject this_TypeLiteralCS_1 = null;

		EObject this_CollectionPatternCS_2 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5250:28: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) )
			// InternalQVTbase.g:5251:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
			{
				// InternalQVTbase.g:5251:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
				int alt125=3;
				alt125 = dfa125.predict(input);
				switch (alt125) {
					case 1 :
						// InternalQVTbase.g:5252:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
					{
						if ( state.backtracking==0 ) {

							/* */

						}
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeNameExpCSParserRuleCall_0());

						}
						pushFollow(FollowSets000.FOLLOW_2);
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
						// InternalQVTbase.g:5265:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
					{
						if ( state.backtracking==0 ) {

							/* */

						}
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_1());

						}
						pushFollow(FollowSets000.FOLLOW_2);
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
						// InternalQVTbase.g:5278:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
					{
						if ( state.backtracking==0 ) {

							/* */

						}
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getCollectionPatternCSParserRuleCall_2());

						}
						pushFollow(FollowSets000.FOLLOW_2);
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


			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input,re);
			appendSkippedTokens();
		}
		finally {
		}
		return current;
	}
	// $ANTLR end "ruleTypeExpWithoutMultiplicityCS"


	// $ANTLR start "entryRuleTypeExpCS"
	// InternalQVTbase.g:5297:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
	public final EObject entryRuleTypeExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeExpCS = null;


		try {
			// InternalQVTbase.g:5298:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
			// InternalQVTbase.g:5299:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
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
	// InternalQVTbase.g:5306:1: ruleTypeExpCS returns [EObject current=null] : (this_TypeExpWithoutMultiplicityCS_0= ruleTypeExpWithoutMultiplicityCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
	public final EObject ruleTypeExpCS() throws RecognitionException {
		EObject current = null;

		EObject this_TypeExpWithoutMultiplicityCS_0 = null;

		EObject lv_ownedMultiplicity_1_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5309:28: ( (this_TypeExpWithoutMultiplicityCS_0= ruleTypeExpWithoutMultiplicityCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
			// InternalQVTbase.g:5310:1: (this_TypeExpWithoutMultiplicityCS_0= ruleTypeExpWithoutMultiplicityCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
			{
				// InternalQVTbase.g:5310:1: (this_TypeExpWithoutMultiplicityCS_0= ruleTypeExpWithoutMultiplicityCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
				// InternalQVTbase.g:5311:2: this_TypeExpWithoutMultiplicityCS_0= ruleTypeExpWithoutMultiplicityCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
				{
					if ( state.backtracking==0 ) {

						/* */

					}
					if ( state.backtracking==0 ) {

						newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeExpWithoutMultiplicityCSParserRuleCall_0());

					}
					pushFollow(FollowSets000.FOLLOW_65);
					this_TypeExpWithoutMultiplicityCS_0=ruleTypeExpWithoutMultiplicityCS();

					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {

						current = this_TypeExpWithoutMultiplicityCS_0;
						afterParserOrEnumRuleCall();

					}
					// InternalQVTbase.g:5322:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
					int alt126=2;
					int LA126_0 = input.LA(1);

					if ( (LA126_0==117) ) {
						alt126=1;
					}
					switch (alt126) {
						case 1 :
							// InternalQVTbase.g:5323:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
						{
							// InternalQVTbase.g:5323:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
							// InternalQVTbase.g:5324:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
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
	// $ANTLR end "ruleTypeExpCS"


	// $ANTLR start "entryRuleExpCS"
	// InternalQVTbase.g:5348:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
	public final EObject entryRuleExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleExpCS = null;


		try {
			// InternalQVTbase.g:5349:2: (iv_ruleExpCS= ruleExpCS EOF )
			// InternalQVTbase.g:5350:2: iv_ruleExpCS= ruleExpCS EOF
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
	// InternalQVTbase.g:5357:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
	public final EObject ruleExpCS() throws RecognitionException {
		EObject current = null;

		EObject this_PrefixedPrimaryExpCS_0 = null;

		AntlrDatatypeRuleToken lv_name_2_0 = null;

		EObject lv_ownedRight_3_0 = null;

		EObject this_PrefixedLetExpCS_4 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5360:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
			// InternalQVTbase.g:5361:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
			{
				// InternalQVTbase.g:5361:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
				int alt128=2;
				alt128 = dfa128.predict(input);
				switch (alt128) {
					case 1 :
						// InternalQVTbase.g:5361:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
					{
						// InternalQVTbase.g:5361:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
						// InternalQVTbase.g:5362:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
						{
							if ( state.backtracking==0 ) {

								/* */

							}
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_82);
							this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								current = this_PrefixedPrimaryExpCS_0;
								afterParserOrEnumRuleCall();

							}
							// InternalQVTbase.g:5373:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
							int alt127=2;
							int LA127_0 = input.LA(1);

							if ( (LA127_0==21||LA127_0==69||(LA127_0>=72 && LA127_0<=91)) ) {
								alt127=1;
							}
							switch (alt127) {
								case 1 :
									// InternalQVTbase.g:5373:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
								{
									// InternalQVTbase.g:5373:2: ()
									// InternalQVTbase.g:5374:2:
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

									// InternalQVTbase.g:5382:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
									// InternalQVTbase.g:5383:1: (lv_name_2_0= ruleBinaryOperatorName )
									{
										// InternalQVTbase.g:5383:1: (lv_name_2_0= ruleBinaryOperatorName )
										// InternalQVTbase.g:5384:3: lv_name_2_0= ruleBinaryOperatorName
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_75);
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

									// InternalQVTbase.g:5400:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
									// InternalQVTbase.g:5401:1: (lv_ownedRight_3_0= ruleExpCS )
									{
										// InternalQVTbase.g:5401:1: (lv_ownedRight_3_0= ruleExpCS )
										// InternalQVTbase.g:5402:3: lv_ownedRight_3_0= ruleExpCS
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
						// InternalQVTbase.g:5420:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
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
	// InternalQVTbase.g:5439:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
	public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePrefixedLetExpCS = null;


		try {
			// InternalQVTbase.g:5440:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
			// InternalQVTbase.g:5441:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
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
	// InternalQVTbase.g:5448:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
	public final EObject rulePrefixedLetExpCS() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_1_0 = null;

		EObject lv_ownedRight_2_0 = null;

		EObject this_LetExpCS_3 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5451:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
			// InternalQVTbase.g:5452:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
			{
				// InternalQVTbase.g:5452:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
				int alt129=2;
				int LA129_0 = input.LA(1);

				if ( ((LA129_0>=69 && LA129_0<=71)) ) {
					alt129=1;
				}
				else if ( (LA129_0==126) ) {
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
						// InternalQVTbase.g:5452:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
					{
						// InternalQVTbase.g:5452:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
						// InternalQVTbase.g:5452:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
						{
							// InternalQVTbase.g:5452:3: ()
							// InternalQVTbase.g:5453:2:
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

							// InternalQVTbase.g:5461:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
							// InternalQVTbase.g:5462:1: (lv_name_1_0= ruleUnaryOperatorName )
							{
								// InternalQVTbase.g:5462:1: (lv_name_1_0= ruleUnaryOperatorName )
								// InternalQVTbase.g:5463:3: lv_name_1_0= ruleUnaryOperatorName
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_75);
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

							// InternalQVTbase.g:5479:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
							// InternalQVTbase.g:5480:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
							{
								// InternalQVTbase.g:5480:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
								// InternalQVTbase.g:5481:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
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
						// InternalQVTbase.g:5499:2: this_LetExpCS_3= ruleLetExpCS
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
	// InternalQVTbase.g:5518:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
	public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePrefixedPrimaryExpCS = null;


		try {
			// InternalQVTbase.g:5519:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
			// InternalQVTbase.g:5520:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
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
	// InternalQVTbase.g:5527:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
	public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_1_0 = null;

		EObject lv_ownedRight_2_0 = null;

		EObject this_PrimaryExpCS_3 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5530:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
			// InternalQVTbase.g:5531:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
			{
				// InternalQVTbase.g:5531:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
				int alt130=2;
				int LA130_0 = input.LA(1);

				if ( ((LA130_0>=69 && LA130_0<=71)) ) {
					alt130=1;
				}
				else if ( (LA130_0==RULE_SINGLE_QUOTED_STRING||(LA130_0>=RULE_INT && LA130_0<=RULE_ESCAPED_ID)||LA130_0==51||LA130_0==72||(LA130_0>=92 && LA130_0<=106)||LA130_0==109||(LA130_0>=111 && LA130_0<=114)||LA130_0==121||LA130_0==127) ) {
					alt130=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 130, 0, input);

					throw nvae;
				}
				switch (alt130) {
					case 1 :
						// InternalQVTbase.g:5531:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
					{
						// InternalQVTbase.g:5531:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
						// InternalQVTbase.g:5531:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
						{
							// InternalQVTbase.g:5531:3: ()
							// InternalQVTbase.g:5532:2:
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

							// InternalQVTbase.g:5540:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
							// InternalQVTbase.g:5541:1: (lv_name_1_0= ruleUnaryOperatorName )
							{
								// InternalQVTbase.g:5541:1: (lv_name_1_0= ruleUnaryOperatorName )
								// InternalQVTbase.g:5542:3: lv_name_1_0= ruleUnaryOperatorName
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_83);
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

							// InternalQVTbase.g:5558:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
							// InternalQVTbase.g:5559:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
							{
								// InternalQVTbase.g:5559:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
								// InternalQVTbase.g:5560:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
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
						// InternalQVTbase.g:5578:2: this_PrimaryExpCS_3= rulePrimaryExpCS
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
	// InternalQVTbase.g:5597:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
	public final EObject entryRulePrimaryExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePrimaryExpCS = null;


		try {
			// InternalQVTbase.g:5598:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
			// InternalQVTbase.g:5599:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
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
	// InternalQVTbase.g:5606:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) ;
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
			// InternalQVTbase.g:5609:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS ) )
			// InternalQVTbase.g:5610:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
			{
				// InternalQVTbase.g:5610:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )
				int alt131=10;
				alt131 = dfa131.predict(input);
				switch (alt131) {
					case 1 :
						// InternalQVTbase.g:5611:2: this_NestedExpCS_0= ruleNestedExpCS
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
						// InternalQVTbase.g:5624:2: this_IfExpCS_1= ruleIfExpCS
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
						// InternalQVTbase.g:5637:2: this_SelfExpCS_2= ruleSelfExpCS
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
						// InternalQVTbase.g:5650:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
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
						// InternalQVTbase.g:5663:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
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
						// InternalQVTbase.g:5676:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
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
						// InternalQVTbase.g:5689:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
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
						// InternalQVTbase.g:5702:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
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
						// InternalQVTbase.g:5715:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
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
						// InternalQVTbase.g:5728:2: this_NameExpCS_9= ruleNameExpCS
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
	// InternalQVTbase.g:5747:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
	public final EObject entryRuleNameExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNameExpCS = null;


		try {
			// InternalQVTbase.g:5748:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
			// InternalQVTbase.g:5749:2: iv_ruleNameExpCS= ruleNameExpCS EOF
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
	// InternalQVTbase.g:5756:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
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
			// InternalQVTbase.g:5759:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
			// InternalQVTbase.g:5760:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
			{
				// InternalQVTbase.g:5760:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
				// InternalQVTbase.g:5760:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
				{
					// InternalQVTbase.g:5760:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
					// InternalQVTbase.g:5761:1: (lv_ownedPathName_0_0= rulePathNameCS )
					{
						// InternalQVTbase.g:5761:1: (lv_ownedPathName_0_0= rulePathNameCS )
						// InternalQVTbase.g:5762:3: lv_ownedPathName_0_0= rulePathNameCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_84);
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

					// InternalQVTbase.g:5778:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
					loop132:
						do {
							int alt132=2;
							int LA132_0 = input.LA(1);

							if ( (LA132_0==117) ) {
								alt132=1;
							}


							switch (alt132) {
								case 1 :
									// InternalQVTbase.g:5779:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
								{
									// InternalQVTbase.g:5779:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
									// InternalQVTbase.g:5780:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0());

										}
										pushFollow(FollowSets000.FOLLOW_84);
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
									break loop132;
							}
						} while (true);

					// InternalQVTbase.g:5796:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
					int alt133=2;
					int LA133_0 = input.LA(1);

					if ( (LA133_0==51) ) {
						alt133=1;
					}
					switch (alt133) {
						case 1 :
							// InternalQVTbase.g:5797:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
						{
							// InternalQVTbase.g:5797:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
							// InternalQVTbase.g:5798:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0());

								}
								pushFollow(FollowSets000.FOLLOW_85);
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

					// InternalQVTbase.g:5814:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
					int alt134=2;
					int LA134_0 = input.LA(1);

					if ( (LA134_0==22) ) {
						alt134=1;
					}
					switch (alt134) {
						case 1 :
							// InternalQVTbase.g:5815:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
						{
							// InternalQVTbase.g:5815:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
							// InternalQVTbase.g:5816:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0());

								}
								pushFollow(FollowSets000.FOLLOW_86);
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

					// InternalQVTbase.g:5832:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
					int alt135=2;
					int LA135_0 = input.LA(1);

					if ( (LA135_0==115) ) {
						alt135=1;
					}
					switch (alt135) {
						case 1 :
							// InternalQVTbase.g:5832:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
						{
							// InternalQVTbase.g:5832:4: ( (lv_isPre_4_0= '@' ) )
							// InternalQVTbase.g:5833:1: (lv_isPre_4_0= '@' )
							{
								// InternalQVTbase.g:5833:1: (lv_isPre_4_0= '@' )
								// InternalQVTbase.g:5834:3: lv_isPre_4_0= '@'
								{
									lv_isPre_4_0=(Token)match(input,115,FollowSets000.FOLLOW_87); if (state.failed) return current;
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

							otherlv_5=(Token)match(input,116,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:5859:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
	public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCurlyBracketedClauseCS = null;


		try {
			// InternalQVTbase.g:5860:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
			// InternalQVTbase.g:5861:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
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
	// InternalQVTbase.g:5868:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' ) ;
	public final EObject ruleCurlyBracketedClauseCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		EObject lv_ownedParts_2_0 = null;

		EObject lv_ownedParts_4_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5871:28: ( ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' ) )
			// InternalQVTbase.g:5872:1: ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' )
			{
				// InternalQVTbase.g:5872:1: ( () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}' )
				// InternalQVTbase.g:5872:2: () otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? otherlv_5= '}'
				{
					// InternalQVTbase.g:5872:2: ()
					// InternalQVTbase.g:5873:2:
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

					otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_88); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());

					}
					// InternalQVTbase.g:5885:1: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
					int alt137=2;
					int LA137_0 = input.LA(1);

					if ( (LA137_0==RULE_SINGLE_QUOTED_STRING||(LA137_0>=RULE_SIMPLE_ID && LA137_0<=RULE_ESCAPED_ID)) ) {
						alt137=1;
					}
					switch (alt137) {
						case 1 :
							// InternalQVTbase.g:5885:2: ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
						{
							// InternalQVTbase.g:5885:2: ( (lv_ownedParts_2_0= ruleShadowPartCS ) )
							// InternalQVTbase.g:5886:1: (lv_ownedParts_2_0= ruleShadowPartCS )
							{
								// InternalQVTbase.g:5886:1: (lv_ownedParts_2_0= ruleShadowPartCS )
								// InternalQVTbase.g:5887:3: lv_ownedParts_2_0= ruleShadowPartCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_58);
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

							// InternalQVTbase.g:5903:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
							loop136:
								do {
									int alt136=2;
									int LA136_0 = input.LA(1);

									if ( (LA136_0==39) ) {
										alt136=1;
									}


									switch (alt136) {
										case 1 :
											// InternalQVTbase.g:5903:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
										{
											otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_89); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0());

											}
											// InternalQVTbase.g:5907:1: ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
											// InternalQVTbase.g:5908:1: (lv_ownedParts_4_0= ruleShadowPartCS )
											{
												// InternalQVTbase.g:5908:1: (lv_ownedParts_4_0= ruleShadowPartCS )
												// InternalQVTbase.g:5909:3: lv_ownedParts_4_0= ruleShadowPartCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_58);
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
											break loop136;
									}
								} while (true);


						}
						break;

					}

					otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_5, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());

					}

				}


			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
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
	// InternalQVTbase.g:5937:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
	public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleRoundBracketedClauseCS = null;


		try {
			// InternalQVTbase.g:5938:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
			// InternalQVTbase.g:5939:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
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
	// InternalQVTbase.g:5946:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )* )? otherlv_4= ')' ) ;
	public final EObject ruleRoundBracketedClauseCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_4=null;
		EObject lv_ownedArguments_2_0 = null;

		EObject lv_ownedArguments_3_1 = null;

		EObject lv_ownedArguments_3_2 = null;

		EObject lv_ownedArguments_3_3 = null;


		enterRule();

		try {
			// InternalQVTbase.g:5949:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )* )? otherlv_4= ')' ) )
			// InternalQVTbase.g:5950:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )* )? otherlv_4= ')' )
			{
				// InternalQVTbase.g:5950:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )* )? otherlv_4= ')' )
				// InternalQVTbase.g:5950:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )* )? otherlv_4= ')'
				{
					// InternalQVTbase.g:5950:2: ()
					// InternalQVTbase.g:5951:2:
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

					otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_90); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());

					}
					// InternalQVTbase.g:5963:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )* )?
					int alt140=2;
					int LA140_0 = input.LA(1);

					if ( (LA140_0==RULE_SINGLE_QUOTED_STRING||(LA140_0>=RULE_INT && LA140_0<=RULE_ESCAPED_ID)||LA140_0==20||LA140_0==51||(LA140_0>=69 && LA140_0<=72)||(LA140_0>=92 && LA140_0<=106)||LA140_0==109||(LA140_0>=111 && LA140_0<=114)||LA140_0==121||(LA140_0>=126 && LA140_0<=127)) ) {
						alt140=1;
					}
					switch (alt140) {
						case 1 :
							// InternalQVTbase.g:5963:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )*
						{
							// InternalQVTbase.g:5963:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
							// InternalQVTbase.g:5964:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
							{
								// InternalQVTbase.g:5964:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
								// InternalQVTbase.g:5965:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_91);
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

							// InternalQVTbase.g:5981:2: ( ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) ) )*
							loop139:
								do {
									int alt139=2;
									int LA139_0 = input.LA(1);

									if ( (LA139_0==39||LA139_0==42||LA139_0==120) ) {
										alt139=1;
									}


									switch (alt139) {
										case 1 :
											// InternalQVTbase.g:5982:1: ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) )
										{
											// InternalQVTbase.g:5982:1: ( (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS ) )
											// InternalQVTbase.g:5983:1: (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS )
											{
												// InternalQVTbase.g:5983:1: (lv_ownedArguments_3_1= ruleNavigatingCommaArgCS | lv_ownedArguments_3_2= ruleNavigatingSemiArgCS | lv_ownedArguments_3_3= ruleNavigatingBarArgCS )
												int alt138=3;
												switch ( input.LA(1) ) {
													case 39:
													{
														alt138=1;
													}
													break;
													case 42:
													{
														alt138=2;
													}
													break;
													case 120:
													{
														alt138=3;
													}
													break;
													default:
														if (state.backtracking>0) {state.failed=true; return current;}
														NoViableAltException nvae =
																new NoViableAltException("", 138, 0, input);

														throw nvae;
												}

												switch (alt138) {
													case 1 :
														// InternalQVTbase.g:5984:3: lv_ownedArguments_3_1= ruleNavigatingCommaArgCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0());

														}
														pushFollow(FollowSets000.FOLLOW_91);
														lv_ownedArguments_3_1=ruleNavigatingCommaArgCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
															}
															add(
																current,
																"ownedArguments",
																lv_ownedArguments_3_1,
																"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
															afterParserOrEnumRuleCall();

														}

													}
													break;
													case 2 :
														// InternalQVTbase.g:5999:8: lv_ownedArguments_3_2= ruleNavigatingSemiArgCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1());

														}
														pushFollow(FollowSets000.FOLLOW_91);
														lv_ownedArguments_3_2=ruleNavigatingSemiArgCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
															}
															add(
																current,
																"ownedArguments",
																lv_ownedArguments_3_2,
																"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingSemiArgCS");
															afterParserOrEnumRuleCall();

														}

													}
													break;
													case 3 :
														// InternalQVTbase.g:6014:8: lv_ownedArguments_3_3= ruleNavigatingBarArgCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2());

														}
														pushFollow(FollowSets000.FOLLOW_91);
														lv_ownedArguments_3_3=ruleNavigatingBarArgCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
															}
															add(
																current,
																"ownedArguments",
																lv_ownedArguments_3_3,
																"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingBarArgCS");
															afterParserOrEnumRuleCall();

														}

													}
													break;

												}


											}


										}
										break;

										default :
											break loop139;
									}
								} while (true);


						}
						break;

					}

					otherlv_4=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_4, grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3());

					}

				}


			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
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
	// InternalQVTbase.g:6044:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
	public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSquareBracketedClauseCS = null;


		try {
			// InternalQVTbase.g:6045:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
			// InternalQVTbase.g:6046:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
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
	// InternalQVTbase.g:6053:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
	public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_ownedTerms_1_0 = null;

		EObject lv_ownedTerms_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:6056:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
			// InternalQVTbase.g:6057:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
			{
				// InternalQVTbase.g:6057:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
				// InternalQVTbase.g:6057:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
				{
					otherlv_0=(Token)match(input,117,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());

					}
					// InternalQVTbase.g:6061:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
					// InternalQVTbase.g:6062:1: (lv_ownedTerms_1_0= ruleExpCS )
					{
						// InternalQVTbase.g:6062:1: (lv_ownedTerms_1_0= ruleExpCS )
						// InternalQVTbase.g:6063:3: lv_ownedTerms_1_0= ruleExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_92);
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

					// InternalQVTbase.g:6079:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
					loop141:
						do {
							int alt141=2;
							int LA141_0 = input.LA(1);

							if ( (LA141_0==39) ) {
								alt141=1;
							}


							switch (alt141) {
								case 1 :
									// InternalQVTbase.g:6079:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
								{
									otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_75); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());

									}
									// InternalQVTbase.g:6083:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
									// InternalQVTbase.g:6084:1: (lv_ownedTerms_3_0= ruleExpCS )
									{
										// InternalQVTbase.g:6084:1: (lv_ownedTerms_3_0= ruleExpCS )
										// InternalQVTbase.g:6085:3: lv_ownedTerms_3_0= ruleExpCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_92);
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
									break loop141;
							}
						} while (true);

					otherlv_4=(Token)match(input,118,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:6113:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
	public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNavigatingArgCS = null;


		try {
			// InternalQVTbase.g:6114:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
			// InternalQVTbase.g:6115:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
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
	// InternalQVTbase.g:6122:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )? ) | (otherlv_17= ':' ( (lv_ownedType_18_0= ruleTypeExpCS ) ) ) ) ;
	public final EObject ruleNavigatingArgCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_9=null;
		Token otherlv_11=null;
		Token otherlv_13=null;
		Token otherlv_15=null;
		Token otherlv_17=null;
		EObject lv_ownedNameExpression_0_0 = null;

		EObject lv_ownedCoIterator_2_0 = null;

		EObject lv_ownedInitExpression_4_0 = null;

		EObject lv_ownedType_6_0 = null;

		EObject lv_ownedCoIterator_8_0 = null;

		EObject lv_ownedInitExpression_10_0 = null;

		EObject lv_ownedType_12_0 = null;

		EObject lv_ownedCoIterator_14_0 = null;

		EObject lv_ownedInitExpression_16_0 = null;

		EObject lv_ownedType_18_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:6125:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )? ) | (otherlv_17= ':' ( (lv_ownedType_18_0= ruleTypeExpCS ) ) ) ) )
			// InternalQVTbase.g:6126:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )? ) | (otherlv_17= ':' ( (lv_ownedType_18_0= ruleTypeExpCS ) ) ) )
			{
				// InternalQVTbase.g:6126:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )? ) | (otherlv_17= ':' ( (lv_ownedType_18_0= ruleTypeExpCS ) ) ) )
				int alt148=2;
				int LA148_0 = input.LA(1);

				if ( (LA148_0==RULE_SINGLE_QUOTED_STRING||(LA148_0>=RULE_INT && LA148_0<=RULE_ESCAPED_ID)||LA148_0==51||(LA148_0>=69 && LA148_0<=72)||(LA148_0>=92 && LA148_0<=106)||LA148_0==109||(LA148_0>=111 && LA148_0<=114)||LA148_0==121||(LA148_0>=126 && LA148_0<=127)) ) {
					alt148=1;
				}
				else if ( (LA148_0==20) ) {
					alt148=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 148, 0, input);

					throw nvae;
				}
				switch (alt148) {
					case 1 :
						// InternalQVTbase.g:6126:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )? )
					{
						// InternalQVTbase.g:6126:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )? )
						// InternalQVTbase.g:6126:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )?
						{
							// InternalQVTbase.g:6126:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
							// InternalQVTbase.g:6127:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
							{
								// InternalQVTbase.g:6127:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
								// InternalQVTbase.g:6128:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_93);
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

							// InternalQVTbase.g:6144:2: ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )?
							int alt147=4;
							alt147 = dfa147.predict(input);
							switch (alt147) {
								case 1 :
									// InternalQVTbase.g:6144:3: (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
								{
									// InternalQVTbase.g:6144:3: (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
									// InternalQVTbase.g:6144:5: otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
									{
										otherlv_1=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_0_0());

										}
										// InternalQVTbase.g:6148:1: ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) )
										// InternalQVTbase.g:6149:1: (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS )
										{
											// InternalQVTbase.g:6149:1: (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS )
											// InternalQVTbase.g:6150:3: lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS
											{
												if ( state.backtracking==0 ) {

													newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0());

												}
												pushFollow(FollowSets000.FOLLOW_94);
												lv_ownedCoIterator_2_0=ruleCoIteratorVariableCS();

												state._fsp--;
												if (state.failed) return current;
												if ( state.backtracking==0 ) {

													if (current==null) {
														current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
													}
													set(
														current,
														"ownedCoIterator",
														lv_ownedCoIterator_2_0,
														"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
													afterParserOrEnumRuleCall();

												}

											}


										}

										// InternalQVTbase.g:6166:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
										int alt142=2;
										int LA142_0 = input.LA(1);

										if ( (LA142_0==21) ) {
											alt142=1;
										}
										switch (alt142) {
											case 1 :
												// InternalQVTbase.g:6166:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
											{
												otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());

												}
												// InternalQVTbase.g:6170:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
												// InternalQVTbase.g:6171:1: (lv_ownedInitExpression_4_0= ruleExpCS )
												{
													// InternalQVTbase.g:6171:1: (lv_ownedInitExpression_4_0= ruleExpCS )
													// InternalQVTbase.g:6172:3: lv_ownedInitExpression_4_0= ruleExpCS
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
									// InternalQVTbase.g:6189:6: (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? )
								{
									// InternalQVTbase.g:6189:6: (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? )
									// InternalQVTbase.g:6189:8: otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )?
									{
										otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_1_0());

										}
										// InternalQVTbase.g:6193:1: ( (lv_ownedType_6_0= ruleTypeExpCS ) )
										// InternalQVTbase.g:6194:1: (lv_ownedType_6_0= ruleTypeExpCS )
										{
											// InternalQVTbase.g:6194:1: (lv_ownedType_6_0= ruleTypeExpCS )
											// InternalQVTbase.g:6195:3: lv_ownedType_6_0= ruleTypeExpCS
											{
												if ( state.backtracking==0 ) {

													newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0());

												}
												pushFollow(FollowSets000.FOLLOW_95);
												lv_ownedType_6_0=ruleTypeExpCS();

												state._fsp--;
												if (state.failed) return current;
												if ( state.backtracking==0 ) {

													if (current==null) {
														current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
													}
													set(
														current,
														"ownedType",
														lv_ownedType_6_0,
														"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
													afterParserOrEnumRuleCall();

												}

											}


										}

										// InternalQVTbase.g:6211:2: (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )?
										int alt143=2;
										int LA143_0 = input.LA(1);

										if ( (LA143_0==110) ) {
											alt143=1;
										}
										switch (alt143) {
											case 1 :
												// InternalQVTbase.g:6211:4: otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) )
											{
												otherlv_7=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_1_2_0());

												}
												// InternalQVTbase.g:6215:1: ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) )
												// InternalQVTbase.g:6216:1: (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS )
												{
													// InternalQVTbase.g:6216:1: (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS )
													// InternalQVTbase.g:6217:3: lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0());

														}
														pushFollow(FollowSets000.FOLLOW_94);
														lv_ownedCoIterator_8_0=ruleCoIteratorVariableCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
															}
															set(
																current,
																"ownedCoIterator",
																lv_ownedCoIterator_8_0,
																"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
															afterParserOrEnumRuleCall();

														}

													}


												}


											}
											break;

										}

										// InternalQVTbase.g:6233:4: (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )?
										int alt144=2;
										int LA144_0 = input.LA(1);

										if ( (LA144_0==21) ) {
											alt144=1;
										}
										switch (alt144) {
											case 1 :
												// InternalQVTbase.g:6233:6: otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) )
											{
												otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_9, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_1_3_0());

												}
												// InternalQVTbase.g:6237:1: ( (lv_ownedInitExpression_10_0= ruleExpCS ) )
												// InternalQVTbase.g:6238:1: (lv_ownedInitExpression_10_0= ruleExpCS )
												{
													// InternalQVTbase.g:6238:1: (lv_ownedInitExpression_10_0= ruleExpCS )
													// InternalQVTbase.g:6239:3: lv_ownedInitExpression_10_0= ruleExpCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0());

														}
														pushFollow(FollowSets000.FOLLOW_2);
														lv_ownedInitExpression_10_0=ruleExpCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
															}
															set(
																current,
																"ownedInitExpression",
																lv_ownedInitExpression_10_0,
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
								case 3 :
									// InternalQVTbase.g:6256:6: ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) )
								{
									// InternalQVTbase.g:6256:6: ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) )
									// InternalQVTbase.g:6256:7: (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) )
									{
										// InternalQVTbase.g:6256:7: (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )?
										int alt145=2;
										int LA145_0 = input.LA(1);

										if ( (LA145_0==20) ) {
											alt145=1;
										}
										switch (alt145) {
											case 1 :
												// InternalQVTbase.g:6256:9: otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) )
											{
												otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_11, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_2_0_0());

												}
												// InternalQVTbase.g:6260:1: ( (lv_ownedType_12_0= ruleTypeExpCS ) )
												// InternalQVTbase.g:6261:1: (lv_ownedType_12_0= ruleTypeExpCS )
												{
													// InternalQVTbase.g:6261:1: (lv_ownedType_12_0= ruleTypeExpCS )
													// InternalQVTbase.g:6262:3: lv_ownedType_12_0= ruleTypeExpCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0());

														}
														pushFollow(FollowSets000.FOLLOW_96);
														lv_ownedType_12_0=ruleTypeExpCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
															}
															set(
																current,
																"ownedType",
																lv_ownedType_12_0,
																"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
															afterParserOrEnumRuleCall();

														}

													}


												}


											}
											break;

										}

										// InternalQVTbase.g:6278:4: (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )?
										int alt146=2;
										int LA146_0 = input.LA(1);

										if ( (LA146_0==110) ) {
											alt146=1;
										}
										switch (alt146) {
											case 1 :
												// InternalQVTbase.g:6278:6: otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) )
											{
												otherlv_13=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return current;
												if ( state.backtracking==0 ) {

													newLeafNode(otherlv_13, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_2_1_0());

												}
												// InternalQVTbase.g:6282:1: ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) )
												// InternalQVTbase.g:6283:1: (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS )
												{
													// InternalQVTbase.g:6283:1: (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS )
													// InternalQVTbase.g:6284:3: lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS
													{
														if ( state.backtracking==0 ) {

															newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0());

														}
														pushFollow(FollowSets000.FOLLOW_97);
														lv_ownedCoIterator_14_0=ruleCoIteratorVariableCS();

														state._fsp--;
														if (state.failed) return current;
														if ( state.backtracking==0 ) {

															if (current==null) {
																current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
															}
															set(
																current,
																"ownedCoIterator",
																lv_ownedCoIterator_14_0,
																"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
															afterParserOrEnumRuleCall();

														}

													}


												}


											}
											break;

										}

										otherlv_15=(Token)match(input,119,FollowSets000.FOLLOW_75); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_15, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_2_2());

										}
										// InternalQVTbase.g:6304:1: ( (lv_ownedInitExpression_16_0= ruleExpCS ) )
										// InternalQVTbase.g:6305:1: (lv_ownedInitExpression_16_0= ruleExpCS )
										{
											// InternalQVTbase.g:6305:1: (lv_ownedInitExpression_16_0= ruleExpCS )
											// InternalQVTbase.g:6306:3: lv_ownedInitExpression_16_0= ruleExpCS
											{
												if ( state.backtracking==0 ) {

													newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0());

												}
												pushFollow(FollowSets000.FOLLOW_2);
												lv_ownedInitExpression_16_0=ruleExpCS();

												state._fsp--;
												if (state.failed) return current;
												if ( state.backtracking==0 ) {

													if (current==null) {
														current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
													}
													set(
														current,
														"ownedInitExpression",
														lv_ownedInitExpression_16_0,
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
						// InternalQVTbase.g:6323:6: (otherlv_17= ':' ( (lv_ownedType_18_0= ruleTypeExpCS ) ) )
					{
						// InternalQVTbase.g:6323:6: (otherlv_17= ':' ( (lv_ownedType_18_0= ruleTypeExpCS ) ) )
						// InternalQVTbase.g:6323:8: otherlv_17= ':' ( (lv_ownedType_18_0= ruleTypeExpCS ) )
						{
							otherlv_17=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_17, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());

							}
							// InternalQVTbase.g:6327:1: ( (lv_ownedType_18_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:6328:1: (lv_ownedType_18_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:6328:1: (lv_ownedType_18_0= ruleTypeExpCS )
								// InternalQVTbase.g:6329:3: lv_ownedType_18_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_2);
									lv_ownedType_18_0=ruleTypeExpCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
										}
										set(
											current,
											"ownedType",
											lv_ownedType_18_0,
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
	// InternalQVTbase.g:6353:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
	public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNavigatingBarArgCS = null;


		try {
			// InternalQVTbase.g:6354:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
			// InternalQVTbase.g:6355:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
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
	// InternalQVTbase.g:6362:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
			// InternalQVTbase.g:6365:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
			// InternalQVTbase.g:6366:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
			{
				// InternalQVTbase.g:6366:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
				// InternalQVTbase.g:6366:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
				{
					// InternalQVTbase.g:6366:2: ( (lv_prefix_0_0= '|' ) )
					// InternalQVTbase.g:6367:1: (lv_prefix_0_0= '|' )
					{
						// InternalQVTbase.g:6367:1: (lv_prefix_0_0= '|' )
						// InternalQVTbase.g:6368:3: lv_prefix_0_0= '|'
						{
							lv_prefix_0_0=(Token)match(input,120,FollowSets000.FOLLOW_75); if (state.failed) return current;
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

					// InternalQVTbase.g:6381:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
					// InternalQVTbase.g:6382:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
					{
						// InternalQVTbase.g:6382:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
						// InternalQVTbase.g:6383:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_98);
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

					// InternalQVTbase.g:6399:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
					int alt150=2;
					int LA150_0 = input.LA(1);

					if ( (LA150_0==20) ) {
						alt150=1;
					}
					switch (alt150) {
						case 1 :
							// InternalQVTbase.g:6399:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
						{
							otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());

							}
							// InternalQVTbase.g:6403:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:6404:1: (lv_ownedType_3_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:6404:1: (lv_ownedType_3_0= ruleTypeExpCS )
								// InternalQVTbase.g:6405:3: lv_ownedType_3_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_94);
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

							// InternalQVTbase.g:6421:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
							int alt149=2;
							int LA149_0 = input.LA(1);

							if ( (LA149_0==21) ) {
								alt149=1;
							}
							switch (alt149) {
								case 1 :
									// InternalQVTbase.g:6421:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
								{
									otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());

									}
									// InternalQVTbase.g:6425:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
									// InternalQVTbase.g:6426:1: (lv_ownedInitExpression_5_0= ruleExpCS )
									{
										// InternalQVTbase.g:6426:1: (lv_ownedInitExpression_5_0= ruleExpCS )
										// InternalQVTbase.g:6427:3: lv_ownedInitExpression_5_0= ruleExpCS
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
	// InternalQVTbase.g:6451:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
	public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNavigatingCommaArgCS = null;


		try {
			// InternalQVTbase.g:6452:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
			// InternalQVTbase.g:6453:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
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
	// InternalQVTbase.g:6460:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) | ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )? ) ;
	public final EObject ruleNavigatingCommaArgCS() throws RecognitionException {
		EObject current = null;

		Token lv_prefix_0_0=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		Token otherlv_14=null;
		Token otherlv_16=null;
		EObject lv_ownedNameExpression_1_0 = null;

		EObject lv_ownedCoIterator_3_0 = null;

		EObject lv_ownedInitExpression_5_0 = null;

		EObject lv_ownedType_7_0 = null;

		EObject lv_ownedCoIterator_9_0 = null;

		EObject lv_ownedInitExpression_11_0 = null;

		EObject lv_ownedType_13_0 = null;

		EObject lv_ownedCoIterator_15_0 = null;

		EObject lv_ownedInitExpression_17_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:6463:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) | ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )? ) )
			// InternalQVTbase.g:6464:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) | ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )? )
			{
				// InternalQVTbase.g:6464:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) | ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )? )
				// InternalQVTbase.g:6464:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) | ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )?
				{
					// InternalQVTbase.g:6464:2: ( (lv_prefix_0_0= ',' ) )
					// InternalQVTbase.g:6465:1: (lv_prefix_0_0= ',' )
					{
						// InternalQVTbase.g:6465:1: (lv_prefix_0_0= ',' )
						// InternalQVTbase.g:6466:3: lv_prefix_0_0= ','
						{
							lv_prefix_0_0=(Token)match(input,39,FollowSets000.FOLLOW_75); if (state.failed) return current;
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

					// InternalQVTbase.g:6479:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
					// InternalQVTbase.g:6480:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
					{
						// InternalQVTbase.g:6480:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
						// InternalQVTbase.g:6481:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_93);
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

					// InternalQVTbase.g:6497:2: ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) | ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )?
					int alt156=4;
					alt156 = dfa156.predict(input);
					switch (alt156) {
						case 1 :
							// InternalQVTbase.g:6497:3: (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
						{
							// InternalQVTbase.g:6497:3: (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
							// InternalQVTbase.g:6497:5: otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
							{
								otherlv_2=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_0_0());

								}
								// InternalQVTbase.g:6501:1: ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) )
								// InternalQVTbase.g:6502:1: (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS )
								{
									// InternalQVTbase.g:6502:1: (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS )
									// InternalQVTbase.g:6503:3: lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0());

										}
										pushFollow(FollowSets000.FOLLOW_94);
										lv_ownedCoIterator_3_0=ruleCoIteratorVariableCS();

										state._fsp--;
										if (state.failed) return current;
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
											}
											set(
												current,
												"ownedCoIterator",
												lv_ownedCoIterator_3_0,
												"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
											afterParserOrEnumRuleCall();

										}

									}


								}

								// InternalQVTbase.g:6519:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
								int alt151=2;
								int LA151_0 = input.LA(1);

								if ( (LA151_0==21) ) {
									alt151=1;
								}
								switch (alt151) {
									case 1 :
										// InternalQVTbase.g:6519:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
									{
										otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());

										}
										// InternalQVTbase.g:6523:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
										// InternalQVTbase.g:6524:1: (lv_ownedInitExpression_5_0= ruleExpCS )
										{
											// InternalQVTbase.g:6524:1: (lv_ownedInitExpression_5_0= ruleExpCS )
											// InternalQVTbase.g:6525:3: lv_ownedInitExpression_5_0= ruleExpCS
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
							// InternalQVTbase.g:6542:6: (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? )
						{
							// InternalQVTbase.g:6542:6: (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? )
							// InternalQVTbase.g:6542:8: otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )?
							{
								otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_1_0());

								}
								// InternalQVTbase.g:6546:1: ( (lv_ownedType_7_0= ruleTypeExpCS ) )
								// InternalQVTbase.g:6547:1: (lv_ownedType_7_0= ruleTypeExpCS )
								{
									// InternalQVTbase.g:6547:1: (lv_ownedType_7_0= ruleTypeExpCS )
									// InternalQVTbase.g:6548:3: lv_ownedType_7_0= ruleTypeExpCS
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_1_0());

										}
										pushFollow(FollowSets000.FOLLOW_95);
										lv_ownedType_7_0=ruleTypeExpCS();

										state._fsp--;
										if (state.failed) return current;
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
											}
											set(
												current,
												"ownedType",
												lv_ownedType_7_0,
												"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
											afterParserOrEnumRuleCall();

										}

									}


								}

								// InternalQVTbase.g:6564:2: (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )?
								int alt152=2;
								int LA152_0 = input.LA(1);

								if ( (LA152_0==110) ) {
									alt152=1;
								}
								switch (alt152) {
									case 1 :
										// InternalQVTbase.g:6564:4: otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) )
									{
										otherlv_8=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_8, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_1_2_0());

										}
										// InternalQVTbase.g:6568:1: ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) )
										// InternalQVTbase.g:6569:1: (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS )
										{
											// InternalQVTbase.g:6569:1: (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS )
											// InternalQVTbase.g:6570:3: lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS
											{
												if ( state.backtracking==0 ) {

													newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0());

												}
												pushFollow(FollowSets000.FOLLOW_94);
												lv_ownedCoIterator_9_0=ruleCoIteratorVariableCS();

												state._fsp--;
												if (state.failed) return current;
												if ( state.backtracking==0 ) {

													if (current==null) {
														current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
													}
													set(
														current,
														"ownedCoIterator",
														lv_ownedCoIterator_9_0,
														"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
													afterParserOrEnumRuleCall();

												}

											}


										}


									}
									break;

								}

								// InternalQVTbase.g:6586:4: (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )?
								int alt153=2;
								int LA153_0 = input.LA(1);

								if ( (LA153_0==21) ) {
									alt153=1;
								}
								switch (alt153) {
									case 1 :
										// InternalQVTbase.g:6586:6: otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) )
									{
										otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_10, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_1_3_0());

										}
										// InternalQVTbase.g:6590:1: ( (lv_ownedInitExpression_11_0= ruleExpCS ) )
										// InternalQVTbase.g:6591:1: (lv_ownedInitExpression_11_0= ruleExpCS )
										{
											// InternalQVTbase.g:6591:1: (lv_ownedInitExpression_11_0= ruleExpCS )
											// InternalQVTbase.g:6592:3: lv_ownedInitExpression_11_0= ruleExpCS
											{
												if ( state.backtracking==0 ) {

													newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0());

												}
												pushFollow(FollowSets000.FOLLOW_2);
												lv_ownedInitExpression_11_0=ruleExpCS();

												state._fsp--;
												if (state.failed) return current;
												if ( state.backtracking==0 ) {

													if (current==null) {
														current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
													}
													set(
														current,
														"ownedInitExpression",
														lv_ownedInitExpression_11_0,
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
						case 3 :
							// InternalQVTbase.g:6609:6: ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) )
						{
							// InternalQVTbase.g:6609:6: ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) )
							// InternalQVTbase.g:6609:7: (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) )
							{
								// InternalQVTbase.g:6609:7: (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )?
								int alt154=2;
								int LA154_0 = input.LA(1);

								if ( (LA154_0==20) ) {
									alt154=1;
								}
								switch (alt154) {
									case 1 :
										// InternalQVTbase.g:6609:9: otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) )
									{
										otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_12, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_2_0_0());

										}
										// InternalQVTbase.g:6613:1: ( (lv_ownedType_13_0= ruleTypeExpCS ) )
										// InternalQVTbase.g:6614:1: (lv_ownedType_13_0= ruleTypeExpCS )
										{
											// InternalQVTbase.g:6614:1: (lv_ownedType_13_0= ruleTypeExpCS )
											// InternalQVTbase.g:6615:3: lv_ownedType_13_0= ruleTypeExpCS
											{
												if ( state.backtracking==0 ) {

													newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0());

												}
												pushFollow(FollowSets000.FOLLOW_96);
												lv_ownedType_13_0=ruleTypeExpCS();

												state._fsp--;
												if (state.failed) return current;
												if ( state.backtracking==0 ) {

													if (current==null) {
														current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
													}
													set(
														current,
														"ownedType",
														lv_ownedType_13_0,
														"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
													afterParserOrEnumRuleCall();

												}

											}


										}


									}
									break;

								}

								// InternalQVTbase.g:6631:4: (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )?
								int alt155=2;
								int LA155_0 = input.LA(1);

								if ( (LA155_0==110) ) {
									alt155=1;
								}
								switch (alt155) {
									case 1 :
										// InternalQVTbase.g:6631:6: otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) )
									{
										otherlv_14=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return current;
										if ( state.backtracking==0 ) {

											newLeafNode(otherlv_14, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_2_1_0());

										}
										// InternalQVTbase.g:6635:1: ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) )
										// InternalQVTbase.g:6636:1: (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS )
										{
											// InternalQVTbase.g:6636:1: (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS )
											// InternalQVTbase.g:6637:3: lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS
											{
												if ( state.backtracking==0 ) {

													newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0());

												}
												pushFollow(FollowSets000.FOLLOW_97);
												lv_ownedCoIterator_15_0=ruleCoIteratorVariableCS();

												state._fsp--;
												if (state.failed) return current;
												if ( state.backtracking==0 ) {

													if (current==null) {
														current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
													}
													set(
														current,
														"ownedCoIterator",
														lv_ownedCoIterator_15_0,
														"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
													afterParserOrEnumRuleCall();

												}

											}


										}


									}
									break;

								}

								otherlv_16=(Token)match(input,119,FollowSets000.FOLLOW_75); if (state.failed) return current;
								if ( state.backtracking==0 ) {

									newLeafNode(otherlv_16, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_2_2());

								}
								// InternalQVTbase.g:6657:1: ( (lv_ownedInitExpression_17_0= ruleExpCS ) )
								// InternalQVTbase.g:6658:1: (lv_ownedInitExpression_17_0= ruleExpCS )
								{
									// InternalQVTbase.g:6658:1: (lv_ownedInitExpression_17_0= ruleExpCS )
									// InternalQVTbase.g:6659:3: lv_ownedInitExpression_17_0= ruleExpCS
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_3_0());

										}
										pushFollow(FollowSets000.FOLLOW_2);
										lv_ownedInitExpression_17_0=ruleExpCS();

										state._fsp--;
										if (state.failed) return current;
										if ( state.backtracking==0 ) {

											if (current==null) {
												current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
											}
											set(
												current,
												"ownedInitExpression",
												lv_ownedInitExpression_17_0,
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
	// InternalQVTbase.g:6683:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
	public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNavigatingSemiArgCS = null;


		try {
			// InternalQVTbase.g:6684:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
			// InternalQVTbase.g:6685:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
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
	// InternalQVTbase.g:6692:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
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
			// InternalQVTbase.g:6695:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
			// InternalQVTbase.g:6696:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
			{
				// InternalQVTbase.g:6696:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
				// InternalQVTbase.g:6696:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
				{
					// InternalQVTbase.g:6696:2: ( (lv_prefix_0_0= ';' ) )
					// InternalQVTbase.g:6697:1: (lv_prefix_0_0= ';' )
					{
						// InternalQVTbase.g:6697:1: (lv_prefix_0_0= ';' )
						// InternalQVTbase.g:6698:3: lv_prefix_0_0= ';'
						{
							lv_prefix_0_0=(Token)match(input,42,FollowSets000.FOLLOW_75); if (state.failed) return current;
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

					// InternalQVTbase.g:6711:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
					// InternalQVTbase.g:6712:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
					{
						// InternalQVTbase.g:6712:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
						// InternalQVTbase.g:6713:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_98);
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

					// InternalQVTbase.g:6729:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
					int alt158=2;
					int LA158_0 = input.LA(1);

					if ( (LA158_0==20) ) {
						alt158=1;
					}
					switch (alt158) {
						case 1 :
							// InternalQVTbase.g:6729:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
						{
							otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());

							}
							// InternalQVTbase.g:6733:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:6734:1: (lv_ownedType_3_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:6734:1: (lv_ownedType_3_0= ruleTypeExpCS )
								// InternalQVTbase.g:6735:3: lv_ownedType_3_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_94);
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

							// InternalQVTbase.g:6751:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
							int alt157=2;
							int LA157_0 = input.LA(1);

							if ( (LA157_0==21) ) {
								alt157=1;
							}
							switch (alt157) {
								case 1 :
									// InternalQVTbase.g:6751:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
								{
									otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());

									}
									// InternalQVTbase.g:6755:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
									// InternalQVTbase.g:6756:1: (lv_ownedInitExpression_5_0= ruleExpCS )
									{
										// InternalQVTbase.g:6756:1: (lv_ownedInitExpression_5_0= ruleExpCS )
										// InternalQVTbase.g:6757:3: lv_ownedInitExpression_5_0= ruleExpCS
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
	// InternalQVTbase.g:6781:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
	public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNavigatingArgExpCS = null;


		try {
			// InternalQVTbase.g:6782:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
			// InternalQVTbase.g:6783:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
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
	// InternalQVTbase.g:6790:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
	public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
		EObject current = null;

		EObject this_ExpCS_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:6793:28: (this_ExpCS_0= ruleExpCS )
			// InternalQVTbase.g:6795:2: this_ExpCS_0= ruleExpCS
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


	// $ANTLR start "entryRuleCoIteratorVariableCS"
	// InternalQVTbase.g:6814:1: entryRuleCoIteratorVariableCS returns [EObject current=null] : iv_ruleCoIteratorVariableCS= ruleCoIteratorVariableCS EOF ;
	public final EObject entryRuleCoIteratorVariableCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCoIteratorVariableCS = null;


		try {
			// InternalQVTbase.g:6815:2: (iv_ruleCoIteratorVariableCS= ruleCoIteratorVariableCS EOF )
			// InternalQVTbase.g:6816:2: iv_ruleCoIteratorVariableCS= ruleCoIteratorVariableCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getCoIteratorVariableCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleCoIteratorVariableCS=ruleCoIteratorVariableCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleCoIteratorVariableCS;
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
	// $ANTLR end "entryRuleCoIteratorVariableCS"


	// $ANTLR start "ruleCoIteratorVariableCS"
	// InternalQVTbase.g:6823:1: ruleCoIteratorVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? ) ;
	public final EObject ruleCoIteratorVariableCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		AntlrDatatypeRuleToken lv_name_0_0 = null;

		EObject lv_ownedType_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:6826:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? ) )
			// InternalQVTbase.g:6827:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? )
			{
				// InternalQVTbase.g:6827:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? )
				// InternalQVTbase.g:6827:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
				{
					// InternalQVTbase.g:6827:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:6828:1: (lv_name_0_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:6828:1: (lv_name_0_0= ruleUnrestrictedName )
						// InternalQVTbase.g:6829:3: lv_name_0_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getCoIteratorVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_98);
							lv_name_0_0=ruleUnrestrictedName();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getCoIteratorVariableCSRule());
								}
								set(
									current,
									"name",
									lv_name_0_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:6845:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
					int alt159=2;
					int LA159_0 = input.LA(1);

					if ( (LA159_0==20) ) {
						alt159=1;
					}
					switch (alt159) {
						case 1 :
							// InternalQVTbase.g:6845:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
						{
							otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getCoIteratorVariableCSAccess().getColonKeyword_1_0());

							}
							// InternalQVTbase.g:6849:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:6850:1: (lv_ownedType_2_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:6850:1: (lv_ownedType_2_0= ruleTypeExpCS )
								// InternalQVTbase.g:6851:3: lv_ownedType_2_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_2);
									lv_ownedType_2_0=ruleTypeExpCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getCoIteratorVariableCSRule());
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


				}


			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input,re);
			appendSkippedTokens();
		}
		finally {
		}
		return current;
	}
	// $ANTLR end "ruleCoIteratorVariableCS"


	// $ANTLR start "entryRuleIfExpCS"
	// InternalQVTbase.g:6875:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
	public final EObject entryRuleIfExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleIfExpCS = null;


		try {
			// InternalQVTbase.g:6876:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
			// InternalQVTbase.g:6877:2: iv_ruleIfExpCS= ruleIfExpCS EOF
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
	// InternalQVTbase.g:6884:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
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
			// InternalQVTbase.g:6887:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
			// InternalQVTbase.g:6888:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
			{
				// InternalQVTbase.g:6888:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
				// InternalQVTbase.g:6888:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
				{
					otherlv_0=(Token)match(input,121,FollowSets000.FOLLOW_73); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());

					}
					// InternalQVTbase.g:6892:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
					// InternalQVTbase.g:6893:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
					{
						// InternalQVTbase.g:6893:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
						// InternalQVTbase.g:6894:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
						{
							// InternalQVTbase.g:6894:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
							int alt160=2;
							switch ( input.LA(1) ) {
								case RULE_SINGLE_QUOTED_STRING:
								case RULE_INT:
								case 51:
								case 69:
								case 70:
								case 71:
								case 72:
								case 92:
								case 93:
								case 94:
								case 95:
								case 96:
								case 97:
								case 98:
								case 99:
								case 100:
								case 101:
								case 102:
								case 103:
								case 104:
								case 105:
								case 106:
								case 109:
								case 111:
								case 112:
								case 113:
								case 114:
								case 121:
								case 126:
								case 127:
								{
									alt160=1;
								}
								break;
								case RULE_SIMPLE_ID:
								{
									int LA160_2 = input.LA(2);

									if ( (LA160_2==20) ) {
										alt160=2;
									}
									else if ( ((LA160_2>=21 && LA160_2<=22)||LA160_2==51||LA160_2==69||(LA160_2>=72 && LA160_2<=91)||LA160_2==115||LA160_2==117||LA160_2==122||LA160_2==131) ) {
										alt160=1;
									}
									else {
										if (state.backtracking>0) {state.failed=true; return current;}
										NoViableAltException nvae =
												new NoViableAltException("", 160, 2, input);

										throw nvae;
									}
								}
								break;
								case RULE_ESCAPED_ID:
								{
									int LA160_3 = input.LA(2);

									if ( ((LA160_3>=21 && LA160_3<=22)||LA160_3==51||LA160_3==69||(LA160_3>=72 && LA160_3<=91)||LA160_3==115||LA160_3==117||LA160_3==122||LA160_3==131) ) {
										alt160=1;
									}
									else if ( (LA160_3==20) ) {
										alt160=2;
									}
									else {
										if (state.backtracking>0) {state.failed=true; return current;}
										NoViableAltException nvae =
												new NoViableAltException("", 160, 3, input);

										throw nvae;
									}
								}
								break;
								case 20:
								{
									alt160=2;
								}
								break;
								default:
									if (state.backtracking>0) {state.failed=true; return current;}
									NoViableAltException nvae =
											new NoViableAltException("", 160, 0, input);

									throw nvae;
							}

							switch (alt160) {
								case 1 :
									// InternalQVTbase.g:6895:3: lv_ownedCondition_1_1= ruleExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0());

									}
									pushFollow(FollowSets000.FOLLOW_99);
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
									// InternalQVTbase.g:6910:8: lv_ownedCondition_1_2= rulePatternExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1());

									}
									pushFollow(FollowSets000.FOLLOW_99);
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

					otherlv_2=(Token)match(input,122,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());

					}
					// InternalQVTbase.g:6932:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
					// InternalQVTbase.g:6933:1: (lv_ownedThenExpression_3_0= ruleExpCS )
					{
						// InternalQVTbase.g:6933:1: (lv_ownedThenExpression_3_0= ruleExpCS )
						// InternalQVTbase.g:6934:3: lv_ownedThenExpression_3_0= ruleExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0());

							}
							pushFollow(FollowSets000.FOLLOW_100);
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

					// InternalQVTbase.g:6950:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
					loop161:
						do {
							int alt161=2;
							int LA161_0 = input.LA(1);

							if ( (LA161_0==125) ) {
								alt161=1;
							}


							switch (alt161) {
								case 1 :
									// InternalQVTbase.g:6951:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
								{
									// InternalQVTbase.g:6951:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
									// InternalQVTbase.g:6952:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
									{
										if ( state.backtracking==0 ) {

											newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0());

										}
										pushFollow(FollowSets000.FOLLOW_100);
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
									break loop161;
							}
						} while (true);

					otherlv_5=(Token)match(input,123,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());

					}
					// InternalQVTbase.g:6972:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
					// InternalQVTbase.g:6973:1: (lv_ownedElseExpression_6_0= ruleExpCS )
					{
						// InternalQVTbase.g:6973:1: (lv_ownedElseExpression_6_0= ruleExpCS )
						// InternalQVTbase.g:6974:3: lv_ownedElseExpression_6_0= ruleExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0());

							}
							pushFollow(FollowSets000.FOLLOW_101);
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

					otherlv_7=(Token)match(input,124,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:7002:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
	public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleElseIfThenExpCS = null;


		try {
			// InternalQVTbase.g:7003:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
			// InternalQVTbase.g:7004:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
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
	// InternalQVTbase.g:7011:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
	public final EObject ruleElseIfThenExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_2=null;
		EObject lv_ownedCondition_1_0 = null;

		EObject lv_ownedThenExpression_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7014:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
			// InternalQVTbase.g:7015:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
			{
				// InternalQVTbase.g:7015:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
				// InternalQVTbase.g:7015:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
				{
					otherlv_0=(Token)match(input,125,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());

					}
					// InternalQVTbase.g:7019:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
					// InternalQVTbase.g:7020:1: (lv_ownedCondition_1_0= ruleExpCS )
					{
						// InternalQVTbase.g:7020:1: (lv_ownedCondition_1_0= ruleExpCS )
						// InternalQVTbase.g:7021:3: lv_ownedCondition_1_0= ruleExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_99);
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

					otherlv_2=(Token)match(input,122,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());

					}
					// InternalQVTbase.g:7041:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
					// InternalQVTbase.g:7042:1: (lv_ownedThenExpression_3_0= ruleExpCS )
					{
						// InternalQVTbase.g:7042:1: (lv_ownedThenExpression_3_0= ruleExpCS )
						// InternalQVTbase.g:7043:3: lv_ownedThenExpression_3_0= ruleExpCS
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
	// InternalQVTbase.g:7067:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
	public final EObject entryRuleLetExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLetExpCS = null;


		try {
			// InternalQVTbase.g:7068:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
			// InternalQVTbase.g:7069:2: iv_ruleLetExpCS= ruleLetExpCS EOF
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
	// InternalQVTbase.g:7076:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
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
			// InternalQVTbase.g:7079:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
			// InternalQVTbase.g:7080:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
			{
				// InternalQVTbase.g:7080:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
				// InternalQVTbase.g:7080:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
				{
					otherlv_0=(Token)match(input,126,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());

					}
					// InternalQVTbase.g:7084:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
					// InternalQVTbase.g:7085:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
					{
						// InternalQVTbase.g:7085:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
						// InternalQVTbase.g:7086:3: lv_ownedVariables_1_0= ruleLetVariableCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_102);
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

					// InternalQVTbase.g:7102:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
					loop162:
						do {
							int alt162=2;
							int LA162_0 = input.LA(1);

							if ( (LA162_0==39) ) {
								alt162=1;
							}


							switch (alt162) {
								case 1 :
									// InternalQVTbase.g:7102:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
								{
									otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());

									}
									// InternalQVTbase.g:7106:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
									// InternalQVTbase.g:7107:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
									{
										// InternalQVTbase.g:7107:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
										// InternalQVTbase.g:7108:3: lv_ownedVariables_3_0= ruleLetVariableCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_102);
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
									break loop162;
							}
						} while (true);

					otherlv_4=(Token)match(input,119,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());

					}
					// InternalQVTbase.g:7128:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
					// InternalQVTbase.g:7129:1: (lv_ownedInExpression_5_0= ruleExpCS )
					{
						// InternalQVTbase.g:7129:1: (lv_ownedInExpression_5_0= ruleExpCS )
						// InternalQVTbase.g:7130:3: lv_ownedInExpression_5_0= ruleExpCS
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
	// InternalQVTbase.g:7154:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
	public final EObject entryRuleLetVariableCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleLetVariableCS = null;


		try {
			// InternalQVTbase.g:7155:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
			// InternalQVTbase.g:7156:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
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
	// InternalQVTbase.g:7163:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
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
			// InternalQVTbase.g:7166:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
			// InternalQVTbase.g:7167:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
			{
				// InternalQVTbase.g:7167:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
				// InternalQVTbase.g:7167:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
				{
					// InternalQVTbase.g:7167:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:7168:1: (lv_name_0_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:7168:1: (lv_name_0_0= ruleUnrestrictedName )
						// InternalQVTbase.g:7169:3: lv_name_0_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_103);
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
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:7185:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
					int alt163=2;
					int LA163_0 = input.LA(1);

					if ( (LA163_0==51) ) {
						alt163=1;
					}
					switch (alt163) {
						case 1 :
							// InternalQVTbase.g:7186:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
						{
							// InternalQVTbase.g:7186:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
							// InternalQVTbase.g:7187:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_80);
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

					// InternalQVTbase.g:7203:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
					int alt164=2;
					int LA164_0 = input.LA(1);

					if ( (LA164_0==20) ) {
						alt164=1;
					}
					switch (alt164) {
						case 1 :
							// InternalQVTbase.g:7203:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
						{
							otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());

							}
							// InternalQVTbase.g:7207:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
							// InternalQVTbase.g:7208:1: (lv_ownedType_3_0= ruleTypeExpCS )
							{
								// InternalQVTbase.g:7208:1: (lv_ownedType_3_0= ruleTypeExpCS )
								// InternalQVTbase.g:7209:3: lv_ownedType_3_0= ruleTypeExpCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_77);
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

					otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());

					}
					// InternalQVTbase.g:7229:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
					// InternalQVTbase.g:7230:1: (lv_ownedInitExpression_5_0= ruleExpCS )
					{
						// InternalQVTbase.g:7230:1: (lv_ownedInitExpression_5_0= ruleExpCS )
						// InternalQVTbase.g:7231:3: lv_ownedInitExpression_5_0= ruleExpCS
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
	// InternalQVTbase.g:7255:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
	public final EObject entryRuleNestedExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNestedExpCS = null;


		try {
			// InternalQVTbase.g:7256:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
			// InternalQVTbase.g:7257:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
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
	// InternalQVTbase.g:7264:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
	public final EObject ruleNestedExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_2=null;
		EObject lv_ownedExpression_1_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7267:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
			// InternalQVTbase.g:7268:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
			{
				// InternalQVTbase.g:7268:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
				// InternalQVTbase.g:7268:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
				{
					otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());

					}
					// InternalQVTbase.g:7272:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
					// InternalQVTbase.g:7273:1: (lv_ownedExpression_1_0= ruleExpCS )
					{
						// InternalQVTbase.g:7273:1: (lv_ownedExpression_1_0= ruleExpCS )
						// InternalQVTbase.g:7274:3: lv_ownedExpression_1_0= ruleExpCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_69);
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

					otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:7302:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
	public final EObject entryRuleSelfExpCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSelfExpCS = null;


		try {
			// InternalQVTbase.g:7303:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
			// InternalQVTbase.g:7304:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
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
	// InternalQVTbase.g:7311:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
	public final EObject ruleSelfExpCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;

		enterRule();

		try {
			// InternalQVTbase.g:7314:28: ( ( () otherlv_1= 'self' ) )
			// InternalQVTbase.g:7315:1: ( () otherlv_1= 'self' )
			{
				// InternalQVTbase.g:7315:1: ( () otherlv_1= 'self' )
				// InternalQVTbase.g:7315:2: () otherlv_1= 'self'
				{
					// InternalQVTbase.g:7315:2: ()
					// InternalQVTbase.g:7316:2:
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

					otherlv_1=(Token)match(input,127,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:7336:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
	public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMultiplicityBoundsCS = null;


		try {
			// InternalQVTbase.g:7337:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
			// InternalQVTbase.g:7338:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
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
	// InternalQVTbase.g:7345:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
	public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

		AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7348:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
			// InternalQVTbase.g:7349:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
			{
				// InternalQVTbase.g:7349:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
				// InternalQVTbase.g:7349:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
				{
					// InternalQVTbase.g:7349:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
					// InternalQVTbase.g:7350:1: (lv_lowerBound_0_0= ruleLOWER )
					{
						// InternalQVTbase.g:7350:1: (lv_lowerBound_0_0= ruleLOWER )
						// InternalQVTbase.g:7351:3: lv_lowerBound_0_0= ruleLOWER
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_74);
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

					// InternalQVTbase.g:7367:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
					int alt165=2;
					int LA165_0 = input.LA(1);

					if ( (LA165_0==107) ) {
						alt165=1;
					}
					switch (alt165) {
						case 1 :
							// InternalQVTbase.g:7367:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
						{
							otherlv_1=(Token)match(input,107,FollowSets000.FOLLOW_104); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());

							}
							// InternalQVTbase.g:7371:1: ( (lv_upperBound_2_0= ruleUPPER ) )
							// InternalQVTbase.g:7372:1: (lv_upperBound_2_0= ruleUPPER )
							{
								// InternalQVTbase.g:7372:1: (lv_upperBound_2_0= ruleUPPER )
								// InternalQVTbase.g:7373:3: lv_upperBound_2_0= ruleUPPER
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
	// InternalQVTbase.g:7397:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
	public final EObject entryRuleMultiplicityCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMultiplicityCS = null;


		try {
			// InternalQVTbase.g:7398:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
			// InternalQVTbase.g:7399:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
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
	// InternalQVTbase.g:7406:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
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
			// InternalQVTbase.g:7409:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
			// InternalQVTbase.g:7410:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
			{
				// InternalQVTbase.g:7410:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
				// InternalQVTbase.g:7410:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
				{
					otherlv_0=(Token)match(input,117,FollowSets000.FOLLOW_105); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());

					}
					// InternalQVTbase.g:7414:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
					int alt166=2;
					int LA166_0 = input.LA(1);

					if ( (LA166_0==RULE_INT) ) {
						alt166=1;
					}
					else if ( (LA166_0==72||LA166_0==74||LA166_0==130) ) {
						alt166=2;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
								new NoViableAltException("", 166, 0, input);

						throw nvae;
					}
					switch (alt166) {
						case 1 :
							// InternalQVTbase.g:7415:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
						{
							if ( state.backtracking==0 ) {

								/* */

							}
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_106);
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
							// InternalQVTbase.g:7428:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
						{
							if ( state.backtracking==0 ) {

								/* */

							}
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1());

							}
							pushFollow(FollowSets000.FOLLOW_106);
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

					// InternalQVTbase.g:7439:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
					int alt167=3;
					int LA167_0 = input.LA(1);

					if ( (LA167_0==128) ) {
						alt167=1;
					}
					else if ( (LA167_0==129) ) {
						alt167=2;
					}
					switch (alt167) {
						case 1 :
							// InternalQVTbase.g:7439:4: otherlv_3= '|?'
						{
							otherlv_3=(Token)match(input,128,FollowSets000.FOLLOW_107); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());

							}

						}
						break;
						case 2 :
							// InternalQVTbase.g:7444:6: ( (lv_isNullFree_4_0= '|1' ) )
						{
							// InternalQVTbase.g:7444:6: ( (lv_isNullFree_4_0= '|1' ) )
							// InternalQVTbase.g:7445:1: (lv_isNullFree_4_0= '|1' )
							{
								// InternalQVTbase.g:7445:1: (lv_isNullFree_4_0= '|1' )
								// InternalQVTbase.g:7446:3: lv_isNullFree_4_0= '|1'
								{
									lv_isNullFree_4_0=(Token)match(input,129,FollowSets000.FOLLOW_107); if (state.failed) return current;
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

					otherlv_5=(Token)match(input,118,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:7471:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
	public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleMultiplicityStringCS = null;


		try {
			// InternalQVTbase.g:7472:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
			// InternalQVTbase.g:7473:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
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
	// InternalQVTbase.g:7480:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
	public final EObject ruleMultiplicityStringCS() throws RecognitionException {
		EObject current = null;

		Token lv_stringBounds_0_1=null;
		Token lv_stringBounds_0_2=null;
		Token lv_stringBounds_0_3=null;

		enterRule();

		try {
			// InternalQVTbase.g:7483:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
			// InternalQVTbase.g:7484:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
			{
				// InternalQVTbase.g:7484:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
				// InternalQVTbase.g:7485:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
				{
					// InternalQVTbase.g:7485:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
					// InternalQVTbase.g:7486:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
					{
						// InternalQVTbase.g:7486:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
						int alt168=3;
						switch ( input.LA(1) ) {
							case 72:
							{
								alt168=1;
							}
							break;
							case 74:
							{
								alt168=2;
							}
							break;
							case 130:
							{
								alt168=3;
							}
							break;
							default:
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
										new NoViableAltException("", 168, 0, input);

								throw nvae;
						}

						switch (alt168) {
							case 1 :
								// InternalQVTbase.g:7487:3: lv_stringBounds_0_1= '*'
							{
								lv_stringBounds_0_1=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
								// InternalQVTbase.g:7499:8: lv_stringBounds_0_2= '+'
							{
								lv_stringBounds_0_2=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
								// InternalQVTbase.g:7511:8: lv_stringBounds_0_3= '?'
							{
								lv_stringBounds_0_3=(Token)match(input,130,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:7534:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
	public final EObject entryRulePathNameCS() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePathNameCS = null;


		try {
			// InternalQVTbase.g:7535:2: (iv_rulePathNameCS= rulePathNameCS EOF )
			// InternalQVTbase.g:7536:2: iv_rulePathNameCS= rulePathNameCS EOF
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
	// InternalQVTbase.g:7543:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
	public final EObject rulePathNameCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		EObject lv_ownedPathElements_0_0 = null;

		EObject lv_ownedPathElements_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7546:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
			// InternalQVTbase.g:7547:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
			{
				// InternalQVTbase.g:7547:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
				// InternalQVTbase.g:7547:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
				{
					// InternalQVTbase.g:7547:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
					// InternalQVTbase.g:7548:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
					{
						// InternalQVTbase.g:7548:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
						// InternalQVTbase.g:7549:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_108);
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

					// InternalQVTbase.g:7565:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
					loop169:
						do {
							int alt169=2;
							int LA169_0 = input.LA(1);

							if ( (LA169_0==131) ) {
								alt169=1;
							}


							switch (alt169) {
								case 1 :
									// InternalQVTbase.g:7565:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
								{
									otherlv_1=(Token)match(input,131,FollowSets000.FOLLOW_8); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());

									}
									// InternalQVTbase.g:7569:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
									// InternalQVTbase.g:7570:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
									{
										// InternalQVTbase.g:7570:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
										// InternalQVTbase.g:7571:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_108);
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
									break loop169;
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
	// InternalQVTbase.g:7597:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
	public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleFirstPathElementCS = null;


		try {
			// InternalQVTbase.g:7598:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
			// InternalQVTbase.g:7599:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
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
	// InternalQVTbase.g:7606:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
	public final EObject ruleFirstPathElementCS() throws RecognitionException {
		EObject current = null;

		enterRule();

		try {
			// InternalQVTbase.g:7609:28: ( ( ( ruleUnrestrictedName ) ) )
			// InternalQVTbase.g:7610:1: ( ( ruleUnrestrictedName ) )
			{
				// InternalQVTbase.g:7610:1: ( ( ruleUnrestrictedName ) )
				// InternalQVTbase.g:7611:1: ( ruleUnrestrictedName )
				{
					// InternalQVTbase.g:7611:1: ( ruleUnrestrictedName )
					// InternalQVTbase.g:7612:3: ruleUnrestrictedName
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
	// InternalQVTbase.g:7636:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
	public final EObject entryRuleNextPathElementCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNextPathElementCS = null;


		try {
			// InternalQVTbase.g:7637:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
			// InternalQVTbase.g:7638:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
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
	// InternalQVTbase.g:7645:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
	public final EObject ruleNextPathElementCS() throws RecognitionException {
		EObject current = null;

		enterRule();

		try {
			// InternalQVTbase.g:7648:28: ( ( ( ruleUnreservedName ) ) )
			// InternalQVTbase.g:7649:1: ( ( ruleUnreservedName ) )
			{
				// InternalQVTbase.g:7649:1: ( ( ruleUnreservedName ) )
				// InternalQVTbase.g:7650:1: ( ruleUnreservedName )
				{
					// InternalQVTbase.g:7650:1: ( ruleUnreservedName )
					// InternalQVTbase.g:7651:3: ruleUnreservedName
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


	// $ANTLR start "entryRuleTemplateBindingCS"
	// InternalQVTbase.g:7675:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
	public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTemplateBindingCS = null;


		try {
			// InternalQVTbase.g:7676:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
			// InternalQVTbase.g:7677:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getTemplateBindingCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleTemplateBindingCS;
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
	// $ANTLR end "entryRuleTemplateBindingCS"


	// $ANTLR start "ruleTemplateBindingCS"
	// InternalQVTbase.g:7684:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
	public final EObject ruleTemplateBindingCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		EObject lv_ownedSubstitutions_0_0 = null;

		EObject lv_ownedSubstitutions_2_0 = null;

		EObject lv_ownedMultiplicity_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7687:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
			// InternalQVTbase.g:7688:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
			{
				// InternalQVTbase.g:7688:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
				// InternalQVTbase.g:7688:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
				{
					// InternalQVTbase.g:7688:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
					// InternalQVTbase.g:7689:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
					{
						// InternalQVTbase.g:7689:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
						// InternalQVTbase.g:7690:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_109);
							lv_ownedSubstitutions_0_0=ruleTemplateParameterSubstitutionCS();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
								}
								add(
									current,
									"ownedSubstitutions",
									lv_ownedSubstitutions_0_0,
										"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:7706:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
					loop170:
						do {
							int alt170=2;
							int LA170_0 = input.LA(1);

							if ( (LA170_0==39) ) {
								alt170=1;
							}


							switch (alt170) {
								case 1 :
									// InternalQVTbase.g:7706:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
								{
									otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_110); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());

									}
									// InternalQVTbase.g:7710:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
									// InternalQVTbase.g:7711:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
									{
										// InternalQVTbase.g:7711:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
										// InternalQVTbase.g:7712:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_109);
											lv_ownedSubstitutions_2_0=ruleTemplateParameterSubstitutionCS();

											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
												}
												add(
													current,
													"ownedSubstitutions",
													lv_ownedSubstitutions_2_0,
														"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
												afterParserOrEnumRuleCall();

											}

										}


									}


								}
								break;

								default :
									break loop170;
							}
						} while (true);

					// InternalQVTbase.g:7728:4: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
					int alt171=2;
					int LA171_0 = input.LA(1);

					if ( (LA171_0==117) ) {
						alt171=1;
					}
					switch (alt171) {
						case 1 :
							// InternalQVTbase.g:7729:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
						{
							// InternalQVTbase.g:7729:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
							// InternalQVTbase.g:7730:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

								state._fsp--;
								if (state.failed) return current;
								if ( state.backtracking==0 ) {

									if (current==null) {
										current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
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
	// $ANTLR end "ruleTemplateBindingCS"


	// $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
	// InternalQVTbase.g:7754:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
	public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTemplateParameterSubstitutionCS = null;


		try {
			// InternalQVTbase.g:7755:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
			// InternalQVTbase.g:7756:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
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
	// InternalQVTbase.g:7763:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
	public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
		EObject current = null;

		EObject lv_ownedActualParameter_0_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7766:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
			// InternalQVTbase.g:7767:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
			{
				// InternalQVTbase.g:7767:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
				// InternalQVTbase.g:7768:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
				{
					// InternalQVTbase.g:7768:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
					// InternalQVTbase.g:7769:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
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


	// $ANTLR start "entryRuleTemplateSignatureCS"
	// InternalQVTbase.g:7793:1: entryRuleTemplateSignatureCS returns [EObject current=null] : iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF ;
	public final EObject entryRuleTemplateSignatureCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTemplateSignatureCS = null;


		try {
			// InternalQVTbase.g:7794:2: (iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF )
			// InternalQVTbase.g:7795:2: iv_ruleTemplateSignatureCS= ruleTemplateSignatureCS EOF
			{
				if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getTemplateSignatureCSRule());
				}
				pushFollow(FollowSets000.FOLLOW_1);
				iv_ruleTemplateSignatureCS=ruleTemplateSignatureCS();

				state._fsp--;
				if (state.failed) return current;
				if ( state.backtracking==0 ) {
					current =iv_ruleTemplateSignatureCS;
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
	// $ANTLR end "entryRuleTemplateSignatureCS"


	// $ANTLR start "ruleTemplateSignatureCS"
	// InternalQVTbase.g:7802:1: ruleTemplateSignatureCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' ) ;
	public final EObject ruleTemplateSignatureCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_0=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_ownedParameters_1_0 = null;

		EObject lv_ownedParameters_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7805:28: ( (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' ) )
			// InternalQVTbase.g:7806:1: (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' )
			{
				// InternalQVTbase.g:7806:1: (otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')' )
				// InternalQVTbase.g:7806:3: otherlv_0= '(' ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) ) (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )* otherlv_4= ')'
				{
					otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_0, grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0());

					}
					// InternalQVTbase.g:7810:1: ( (lv_ownedParameters_1_0= ruleTypeParameterCS ) )
					// InternalQVTbase.g:7811:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
					{
						// InternalQVTbase.g:7811:1: (lv_ownedParameters_1_0= ruleTypeParameterCS )
						// InternalQVTbase.g:7812:3: lv_ownedParameters_1_0= ruleTypeParameterCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0());

							}
							pushFollow(FollowSets000.FOLLOW_35);
							lv_ownedParameters_1_0=ruleTypeParameterCS();

							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {

								if (current==null) {
									current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
								}
								add(
									current,
									"ownedParameters",
									lv_ownedParameters_1_0,
									"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:7828:2: (otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) ) )*
					loop172:
						do {
							int alt172=2;
							int LA172_0 = input.LA(1);

							if ( (LA172_0==39) ) {
								alt172=1;
							}


							switch (alt172) {
								case 1 :
									// InternalQVTbase.g:7828:4: otherlv_2= ',' ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
								{
									otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_6); if (state.failed) return current;
									if ( state.backtracking==0 ) {

										newLeafNode(otherlv_2, grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0());

									}
									// InternalQVTbase.g:7832:1: ( (lv_ownedParameters_3_0= ruleTypeParameterCS ) )
									// InternalQVTbase.g:7833:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
									{
										// InternalQVTbase.g:7833:1: (lv_ownedParameters_3_0= ruleTypeParameterCS )
										// InternalQVTbase.g:7834:3: lv_ownedParameters_3_0= ruleTypeParameterCS
										{
											if ( state.backtracking==0 ) {

												newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0());

											}
											pushFollow(FollowSets000.FOLLOW_35);
											lv_ownedParameters_3_0=ruleTypeParameterCS();

											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {

												if (current==null) {
													current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
												}
												add(
													current,
													"ownedParameters",
													lv_ownedParameters_3_0,
														"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
												afterParserOrEnumRuleCall();

											}

										}


									}


								}
								break;

								default :
									break loop172;
							}
						} while (true);

					otherlv_4=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_4, grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3());

					}

				}


			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input,re);
			appendSkippedTokens();
		}
		finally {
		}
		return current;
	}
	// $ANTLR end "ruleTemplateSignatureCS"


	// $ANTLR start "entryRuleTypeParameterCS"
	// InternalQVTbase.g:7862:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
	public final EObject entryRuleTypeParameterCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeParameterCS = null;


		try {
			// InternalQVTbase.g:7863:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
			// InternalQVTbase.g:7864:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
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
	// InternalQVTbase.g:7871:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) ;
	public final EObject ruleTypeParameterCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_3=null;
		AntlrDatatypeRuleToken lv_name_0_0 = null;

		EObject lv_ownedExtends_2_0 = null;

		EObject lv_ownedExtends_4_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7874:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) )
			// InternalQVTbase.g:7875:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
			{
				// InternalQVTbase.g:7875:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
				// InternalQVTbase.g:7875:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
				{
					// InternalQVTbase.g:7875:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
					// InternalQVTbase.g:7876:1: (lv_name_0_0= ruleUnrestrictedName )
					{
						// InternalQVTbase.g:7876:1: (lv_name_0_0= ruleUnrestrictedName )
						// InternalQVTbase.g:7877:3: lv_name_0_0= ruleUnrestrictedName
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_111);
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
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnrestrictedName");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// InternalQVTbase.g:7893:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
					int alt174=2;
					int LA174_0 = input.LA(1);

					if ( (LA174_0==67) ) {
						alt174=1;
					}
					switch (alt174) {
						case 1 :
							// InternalQVTbase.g:7893:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
						{
							otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());

							}
							// InternalQVTbase.g:7897:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
							// InternalQVTbase.g:7898:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
							{
								// InternalQVTbase.g:7898:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
								// InternalQVTbase.g:7899:3: lv_ownedExtends_2_0= ruleTypedRefCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_112);
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
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
										afterParserOrEnumRuleCall();

									}

								}


							}

							// InternalQVTbase.g:7915:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
							loop173:
								do {
									int alt173=2;
									int LA173_0 = input.LA(1);

									if ( (LA173_0==132) ) {
										alt173=1;
									}


									switch (alt173) {
										case 1 :
											// InternalQVTbase.g:7915:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
										{
											otherlv_3=(Token)match(input,132,FollowSets000.FOLLOW_8); if (state.failed) return current;
											if ( state.backtracking==0 ) {

												newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());

											}
											// InternalQVTbase.g:7919:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
											// InternalQVTbase.g:7920:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
											{
												// InternalQVTbase.g:7920:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
												// InternalQVTbase.g:7921:3: lv_ownedExtends_4_0= ruleTypedRefCS
												{
													if ( state.backtracking==0 ) {

														newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0());

													}
													pushFollow(FollowSets000.FOLLOW_112);
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
															"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
														afterParserOrEnumRuleCall();

													}

												}


											}


										}
										break;

										default :
											break loop173;
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
	// InternalQVTbase.g:7945:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
	public final EObject entryRuleTypeRefCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypeRefCS = null;


		try {
			// InternalQVTbase.g:7946:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
			// InternalQVTbase.g:7947:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
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
	// InternalQVTbase.g:7954:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
	public final EObject ruleTypeRefCS() throws RecognitionException {
		EObject current = null;

		EObject this_TypedRefCS_0 = null;

		EObject this_WildcardTypeRefCS_1 = null;


		enterRule();

		try {
			// InternalQVTbase.g:7957:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
			// InternalQVTbase.g:7958:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
			{
				// InternalQVTbase.g:7958:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
				int alt175=2;
				int LA175_0 = input.LA(1);

				if ( ((LA175_0>=RULE_SIMPLE_ID && LA175_0<=RULE_ESCAPED_ID)||(LA175_0>=92 && LA175_0<=106)) ) {
					alt175=1;
				}
				else if ( (LA175_0==130) ) {
					alt175=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 175, 0, input);

					throw nvae;
				}
				switch (alt175) {
					case 1 :
						// InternalQVTbase.g:7959:2: this_TypedRefCS_0= ruleTypedRefCS
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
						// InternalQVTbase.g:7972:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
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


	// $ANTLR start "entryRuleTypedTypeRefCS"
	// InternalQVTbase.g:7991:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
	public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleTypedTypeRefCS = null;


		try {
			// InternalQVTbase.g:7992:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
			// InternalQVTbase.g:7993:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
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
	// InternalQVTbase.g:8000:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
	public final EObject ruleTypedTypeRefCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_ownedPathName_0_0 = null;

		EObject lv_ownedBinding_2_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:8003:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
			// InternalQVTbase.g:8004:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
			{
				// InternalQVTbase.g:8004:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
				// InternalQVTbase.g:8004:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
				{
					// InternalQVTbase.g:8004:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
					// InternalQVTbase.g:8005:1: (lv_ownedPathName_0_0= rulePathNameCS )
					{
						// InternalQVTbase.g:8005:1: (lv_ownedPathName_0_0= rulePathNameCS )
						// InternalQVTbase.g:8006:3: lv_ownedPathName_0_0= rulePathNameCS
						{
							if ( state.backtracking==0 ) {

								newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());

							}
							pushFollow(FollowSets000.FOLLOW_67);
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

					// InternalQVTbase.g:8022:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
					int alt176=2;
					int LA176_0 = input.LA(1);

					if ( (LA176_0==51) ) {
						alt176=1;
					}
					switch (alt176) {
						case 1 :
							// InternalQVTbase.g:8022:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
						{
							otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_110); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());

							}
							// InternalQVTbase.g:8026:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
							// InternalQVTbase.g:8027:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
							{
								// InternalQVTbase.g:8027:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
								// InternalQVTbase.g:8028:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
								{
									if ( state.backtracking==0 ) {

										newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0());

									}
									pushFollow(FollowSets000.FOLLOW_69);
									lv_ownedBinding_2_0=ruleTemplateBindingCS();

									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {

										if (current==null) {
											current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
										}
										set(
											current,
											"ownedBinding",
											lv_ownedBinding_2_0,
											"org.eclipse.ocl.xtext.base.Base.TemplateBindingCS");
										afterParserOrEnumRuleCall();

									}

								}


							}

							otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());

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
	// $ANTLR end "ruleTypedTypeRefCS"


	// $ANTLR start "entryRuleWildcardTypeRefCS"
	// InternalQVTbase.g:8056:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
	public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleWildcardTypeRefCS = null;


		try {
			// InternalQVTbase.g:8057:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
			// InternalQVTbase.g:8058:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
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
	// InternalQVTbase.g:8065:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) ;
	public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
		EObject current = null;

		Token otherlv_1=null;
		Token otherlv_2=null;
		EObject lv_ownedExtends_3_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:8068:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) )
			// InternalQVTbase.g:8069:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
			{
				// InternalQVTbase.g:8069:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
				// InternalQVTbase.g:8069:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
				{
					// InternalQVTbase.g:8069:2: ()
					// InternalQVTbase.g:8070:2:
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

					otherlv_1=(Token)match(input,130,FollowSets000.FOLLOW_111); if (state.failed) return current;
					if ( state.backtracking==0 ) {

						newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());

					}
					// InternalQVTbase.g:8082:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
					int alt177=2;
					int LA177_0 = input.LA(1);

					if ( (LA177_0==67) ) {
						alt177=1;
					}
					switch (alt177) {
						case 1 :
							// InternalQVTbase.g:8082:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
						{
							otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {

								newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());

							}
							// InternalQVTbase.g:8086:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
							// InternalQVTbase.g:8087:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
							{
								// InternalQVTbase.g:8087:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
								// InternalQVTbase.g:8088:3: lv_ownedExtends_3_0= ruleTypedRefCS
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
											"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
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
	// InternalQVTbase.g:8112:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
	public final String entryRuleID() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleID = null;


		try {
			// InternalQVTbase.g:8113:2: (iv_ruleID= ruleID EOF )
			// InternalQVTbase.g:8114:2: iv_ruleID= ruleID EOF
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
	// InternalQVTbase.g:8121:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
	public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_SIMPLE_ID_0=null;
		Token this_ESCAPED_ID_1=null;

		enterRule();

		try {
			// InternalQVTbase.g:8124:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
			// InternalQVTbase.g:8125:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
			{
				// InternalQVTbase.g:8125:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
				int alt178=2;
				int LA178_0 = input.LA(1);

				if ( (LA178_0==RULE_SIMPLE_ID) ) {
					alt178=1;
				}
				else if ( (LA178_0==RULE_ESCAPED_ID) ) {
					alt178=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 178, 0, input);

					throw nvae;
				}
				switch (alt178) {
					case 1 :
						// InternalQVTbase.g:8125:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
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
						// InternalQVTbase.g:8133:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
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
	// InternalQVTbase.g:8148:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
	public final String entryRuleIdentifier() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleIdentifier = null;


		try {
			// InternalQVTbase.g:8149:2: (iv_ruleIdentifier= ruleIdentifier EOF )
			// InternalQVTbase.g:8150:2: iv_ruleIdentifier= ruleIdentifier EOF
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
	// InternalQVTbase.g:8157:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
	public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_ID_0 = null;


		enterRule();

		try {
			// InternalQVTbase.g:8160:28: (this_ID_0= ruleID )
			// InternalQVTbase.g:8162:5: this_ID_0= ruleID
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
	// InternalQVTbase.g:8180:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
	public final String entryRuleLOWER() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleLOWER = null;


		try {
			// InternalQVTbase.g:8181:2: (iv_ruleLOWER= ruleLOWER EOF )
			// InternalQVTbase.g:8182:2: iv_ruleLOWER= ruleLOWER EOF
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
	// InternalQVTbase.g:8189:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
	public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_INT_0=null;

		enterRule();

		try {
			// InternalQVTbase.g:8192:28: (this_INT_0= RULE_INT )
			// InternalQVTbase.g:8193:5: this_INT_0= RULE_INT
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
	// InternalQVTbase.g:8208:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
	public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


		try {
			// InternalQVTbase.g:8209:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
			// InternalQVTbase.g:8210:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
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
	// InternalQVTbase.g:8217:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
	public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_INT_0=null;

		enterRule();

		try {
			// InternalQVTbase.g:8220:28: (this_INT_0= RULE_INT )
			// InternalQVTbase.g:8221:5: this_INT_0= RULE_INT
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
	// InternalQVTbase.g:8236:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
	public final String entryRuleStringLiteral() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


		try {
			// InternalQVTbase.g:8237:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
			// InternalQVTbase.g:8238:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
	// InternalQVTbase.g:8245:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
	public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_SINGLE_QUOTED_STRING_0=null;

		enterRule();

		try {
			// InternalQVTbase.g:8248:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
			// InternalQVTbase.g:8249:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
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
	// InternalQVTbase.g:8264:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
	public final String entryRuleUPPER() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleUPPER = null;


		try {
			// InternalQVTbase.g:8265:2: (iv_ruleUPPER= ruleUPPER EOF )
			// InternalQVTbase.g:8266:2: iv_ruleUPPER= ruleUPPER EOF
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
	// InternalQVTbase.g:8273:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_INT_0=null;
		Token kw=null;

		enterRule();

		try {
			// InternalQVTbase.g:8276:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
			// InternalQVTbase.g:8277:1: (this_INT_0= RULE_INT | kw= '*' )
			{
				// InternalQVTbase.g:8277:1: (this_INT_0= RULE_INT | kw= '*' )
				int alt179=2;
				int LA179_0 = input.LA(1);

				if ( (LA179_0==RULE_INT) ) {
					alt179=1;
				}
				else if ( (LA179_0==72) ) {
					alt179=2;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					NoViableAltException nvae =
							new NoViableAltException("", 179, 0, input);

					throw nvae;
				}
				switch (alt179) {
					case 1 :
						// InternalQVTbase.g:8277:6: this_INT_0= RULE_INT
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
						// InternalQVTbase.g:8286:2: kw= '*'
					{
						kw=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
	// InternalQVTbase.g:8299:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
	public final String entryRuleURI() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleURI = null;


		try {
			// InternalQVTbase.g:8300:2: (iv_ruleURI= ruleURI EOF )
			// InternalQVTbase.g:8301:2: iv_ruleURI= ruleURI EOF
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
	// InternalQVTbase.g:8308:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
	public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_SINGLE_QUOTED_STRING_0=null;

		enterRule();

		try {
			// InternalQVTbase.g:8311:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
			// InternalQVTbase.g:8312:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
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

	// $ANTLR start synpred208_InternalQVTbase
	public final void synpred208_InternalQVTbase_fragment() throws RecognitionException {
		EObject this_TypeLiteralCS_1 = null;


		// InternalQVTbase.g:5265:2: (this_TypeLiteralCS_1= ruleTypeLiteralCS )
		// InternalQVTbase.g:5265:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
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
	// $ANTLR end synpred208_InternalQVTbase

	// $ANTLR start synpred211_InternalQVTbase
	public final void synpred211_InternalQVTbase_fragment() throws RecognitionException {
		EObject this_PrefixedPrimaryExpCS_0 = null;

		AntlrDatatypeRuleToken lv_name_2_0 = null;

		EObject lv_ownedRight_3_0 = null;


		// InternalQVTbase.g:5361:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
		// InternalQVTbase.g:5361:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
		{
			// InternalQVTbase.g:5361:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
			// InternalQVTbase.g:5362:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
			{
				if ( state.backtracking==0 ) {

					/* */

				}
				pushFollow(FollowSets000.FOLLOW_82);
				this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

				state._fsp--;
				if (state.failed) return ;
				// InternalQVTbase.g:5373:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
				int alt251=2;
				int LA251_0 = input.LA(1);

				if ( (LA251_0==21||LA251_0==69||(LA251_0>=72 && LA251_0<=91)) ) {
					alt251=1;
				}
				switch (alt251) {
					case 1 :
						// InternalQVTbase.g:5373:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
					{
						// InternalQVTbase.g:5373:2: ()
						// InternalQVTbase.g:5374:2:
						{
							if ( state.backtracking==0 ) {

								/* */

							}

						}

						// InternalQVTbase.g:5382:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
						// InternalQVTbase.g:5383:1: (lv_name_2_0= ruleBinaryOperatorName )
						{
							// InternalQVTbase.g:5383:1: (lv_name_2_0= ruleBinaryOperatorName )
							// InternalQVTbase.g:5384:3: lv_name_2_0= ruleBinaryOperatorName
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_75);
								lv_name_2_0=ruleBinaryOperatorName();

								state._fsp--;
								if (state.failed) return ;

							}


						}

						// InternalQVTbase.g:5400:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
						// InternalQVTbase.g:5401:1: (lv_ownedRight_3_0= ruleExpCS )
						{
							// InternalQVTbase.g:5401:1: (lv_ownedRight_3_0= ruleExpCS )
							// InternalQVTbase.g:5402:3: lv_ownedRight_3_0= ruleExpCS
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
	// $ANTLR end synpred211_InternalQVTbase

	// $ANTLR start synpred218_InternalQVTbase
	public final void synpred218_InternalQVTbase_fragment() throws RecognitionException {
		EObject this_TupleLiteralExpCS_4 = null;


		// InternalQVTbase.g:5663:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
		// InternalQVTbase.g:5663:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
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
	// $ANTLR end synpred218_InternalQVTbase

	// $ANTLR start synpred219_InternalQVTbase
	public final void synpred219_InternalQVTbase_fragment() throws RecognitionException {
		EObject this_MapLiteralExpCS_5 = null;


		// InternalQVTbase.g:5676:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
		// InternalQVTbase.g:5676:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
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
	// $ANTLR end synpred219_InternalQVTbase

	// $ANTLR start synpred220_InternalQVTbase
	public final void synpred220_InternalQVTbase_fragment() throws RecognitionException {
		EObject this_CollectionLiteralExpCS_6 = null;


		// InternalQVTbase.g:5689:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
		// InternalQVTbase.g:5689:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
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
	// $ANTLR end synpred220_InternalQVTbase

	// $ANTLR start synpred222_InternalQVTbase
	public final void synpred222_InternalQVTbase_fragment() throws RecognitionException {
		EObject this_TypeLiteralExpCS_8 = null;


		// InternalQVTbase.g:5715:2: (this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS )
		// InternalQVTbase.g:5715:2: this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS
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
	// $ANTLR end synpred222_InternalQVTbase

	// $ANTLR start synpred235_InternalQVTbase
	public final void synpred235_InternalQVTbase_fragment() throws RecognitionException {
		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_ownedCoIterator_2_0 = null;

		EObject lv_ownedInitExpression_4_0 = null;


		// InternalQVTbase.g:6144:3: ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) )
		// InternalQVTbase.g:6144:3: (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
		{
			// InternalQVTbase.g:6144:3: (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
			// InternalQVTbase.g:6144:5: otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
			{
				otherlv_1=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return ;
				// InternalQVTbase.g:6148:1: ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) )
				// InternalQVTbase.g:6149:1: (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS )
				{
					// InternalQVTbase.g:6149:1: (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS )
					// InternalQVTbase.g:6150:3: lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS
					{
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0());

						}
						pushFollow(FollowSets000.FOLLOW_94);
						lv_ownedCoIterator_2_0=ruleCoIteratorVariableCS();

						state._fsp--;
						if (state.failed) return ;

					}


				}

				// InternalQVTbase.g:6166:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
				int alt256=2;
				int LA256_0 = input.LA(1);

				if ( (LA256_0==21) ) {
					alt256=1;
				}
				switch (alt256) {
					case 1 :
						// InternalQVTbase.g:6166:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
					{
						otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return ;
						// InternalQVTbase.g:6170:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
						// InternalQVTbase.g:6171:1: (lv_ownedInitExpression_4_0= ruleExpCS )
						{
							// InternalQVTbase.g:6171:1: (lv_ownedInitExpression_4_0= ruleExpCS )
							// InternalQVTbase.g:6172:3: lv_ownedInitExpression_4_0= ruleExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedInitExpression_4_0=ruleExpCS();

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
	// $ANTLR end synpred235_InternalQVTbase

	// $ANTLR start synpred238_InternalQVTbase
	public final void synpred238_InternalQVTbase_fragment() throws RecognitionException {
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_9=null;
		EObject lv_ownedType_6_0 = null;

		EObject lv_ownedCoIterator_8_0 = null;

		EObject lv_ownedInitExpression_10_0 = null;


		// InternalQVTbase.g:6189:6: ( (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) )
		// InternalQVTbase.g:6189:6: (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? )
		{
			// InternalQVTbase.g:6189:6: (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? )
			// InternalQVTbase.g:6189:8: otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )?
			{
				otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
				// InternalQVTbase.g:6193:1: ( (lv_ownedType_6_0= ruleTypeExpCS ) )
				// InternalQVTbase.g:6194:1: (lv_ownedType_6_0= ruleTypeExpCS )
				{
					// InternalQVTbase.g:6194:1: (lv_ownedType_6_0= ruleTypeExpCS )
					// InternalQVTbase.g:6195:3: lv_ownedType_6_0= ruleTypeExpCS
					{
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0());

						}
						pushFollow(FollowSets000.FOLLOW_95);
						lv_ownedType_6_0=ruleTypeExpCS();

						state._fsp--;
						if (state.failed) return ;

					}


				}

				// InternalQVTbase.g:6211:2: (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )?
				int alt257=2;
				int LA257_0 = input.LA(1);

				if ( (LA257_0==110) ) {
					alt257=1;
				}
				switch (alt257) {
					case 1 :
						// InternalQVTbase.g:6211:4: otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) )
					{
						otherlv_7=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return ;
						// InternalQVTbase.g:6215:1: ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) )
						// InternalQVTbase.g:6216:1: (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS )
						{
							// InternalQVTbase.g:6216:1: (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS )
							// InternalQVTbase.g:6217:3: lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_94);
								lv_ownedCoIterator_8_0=ruleCoIteratorVariableCS();

								state._fsp--;
								if (state.failed) return ;

							}


						}


					}
					break;

				}

				// InternalQVTbase.g:6233:4: (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )?
				int alt258=2;
				int LA258_0 = input.LA(1);

				if ( (LA258_0==21) ) {
					alt258=1;
				}
				switch (alt258) {
					case 1 :
						// InternalQVTbase.g:6233:6: otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) )
					{
						otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return ;
						// InternalQVTbase.g:6237:1: ( (lv_ownedInitExpression_10_0= ruleExpCS ) )
						// InternalQVTbase.g:6238:1: (lv_ownedInitExpression_10_0= ruleExpCS )
						{
							// InternalQVTbase.g:6238:1: (lv_ownedInitExpression_10_0= ruleExpCS )
							// InternalQVTbase.g:6239:3: lv_ownedInitExpression_10_0= ruleExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedInitExpression_10_0=ruleExpCS();

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
	// $ANTLR end synpred238_InternalQVTbase

	// $ANTLR start synpred241_InternalQVTbase
	public final void synpred241_InternalQVTbase_fragment() throws RecognitionException {
		Token otherlv_11=null;
		Token otherlv_13=null;
		Token otherlv_15=null;
		EObject lv_ownedType_12_0 = null;

		EObject lv_ownedCoIterator_14_0 = null;

		EObject lv_ownedInitExpression_16_0 = null;


		// InternalQVTbase.g:6256:6: ( ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )
		// InternalQVTbase.g:6256:6: ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) )
		{
			// InternalQVTbase.g:6256:6: ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) )
			// InternalQVTbase.g:6256:7: (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) )
			{
				// InternalQVTbase.g:6256:7: (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )?
				int alt259=2;
				int LA259_0 = input.LA(1);

				if ( (LA259_0==20) ) {
					alt259=1;
				}
				switch (alt259) {
					case 1 :
						// InternalQVTbase.g:6256:9: otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) )
					{
						otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
						// InternalQVTbase.g:6260:1: ( (lv_ownedType_12_0= ruleTypeExpCS ) )
						// InternalQVTbase.g:6261:1: (lv_ownedType_12_0= ruleTypeExpCS )
						{
							// InternalQVTbase.g:6261:1: (lv_ownedType_12_0= ruleTypeExpCS )
							// InternalQVTbase.g:6262:3: lv_ownedType_12_0= ruleTypeExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_96);
								lv_ownedType_12_0=ruleTypeExpCS();

								state._fsp--;
								if (state.failed) return ;

							}


						}


					}
					break;

				}

				// InternalQVTbase.g:6278:4: (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )?
				int alt260=2;
				int LA260_0 = input.LA(1);

				if ( (LA260_0==110) ) {
					alt260=1;
				}
				switch (alt260) {
					case 1 :
						// InternalQVTbase.g:6278:6: otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) )
					{
						otherlv_13=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return ;
						// InternalQVTbase.g:6282:1: ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) )
						// InternalQVTbase.g:6283:1: (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS )
						{
							// InternalQVTbase.g:6283:1: (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS )
							// InternalQVTbase.g:6284:3: lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_97);
								lv_ownedCoIterator_14_0=ruleCoIteratorVariableCS();

								state._fsp--;
								if (state.failed) return ;

							}


						}


					}
					break;

				}

				otherlv_15=(Token)match(input,119,FollowSets000.FOLLOW_75); if (state.failed) return ;
				// InternalQVTbase.g:6304:1: ( (lv_ownedInitExpression_16_0= ruleExpCS ) )
				// InternalQVTbase.g:6305:1: (lv_ownedInitExpression_16_0= ruleExpCS )
				{
					// InternalQVTbase.g:6305:1: (lv_ownedInitExpression_16_0= ruleExpCS )
					// InternalQVTbase.g:6306:3: lv_ownedInitExpression_16_0= ruleExpCS
					{
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0());

						}
						pushFollow(FollowSets000.FOLLOW_2);
						lv_ownedInitExpression_16_0=ruleExpCS();

						state._fsp--;
						if (state.failed) return ;

					}


				}


			}


		}
	}
	// $ANTLR end synpred241_InternalQVTbase

	// $ANTLR start synpred246_InternalQVTbase
	public final void synpred246_InternalQVTbase_fragment() throws RecognitionException {
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_ownedCoIterator_3_0 = null;

		EObject lv_ownedInitExpression_5_0 = null;


		// InternalQVTbase.g:6497:3: ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) )
		// InternalQVTbase.g:6497:3: (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
		{
			// InternalQVTbase.g:6497:3: (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
			// InternalQVTbase.g:6497:5: otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
			{
				otherlv_2=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return ;
				// InternalQVTbase.g:6501:1: ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) )
				// InternalQVTbase.g:6502:1: (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS )
				{
					// InternalQVTbase.g:6502:1: (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS )
					// InternalQVTbase.g:6503:3: lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS
					{
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0());

						}
						pushFollow(FollowSets000.FOLLOW_94);
						lv_ownedCoIterator_3_0=ruleCoIteratorVariableCS();

						state._fsp--;
						if (state.failed) return ;

					}


				}

				// InternalQVTbase.g:6519:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
				int alt268=2;
				int LA268_0 = input.LA(1);

				if ( (LA268_0==21) ) {
					alt268=1;
				}
				switch (alt268) {
					case 1 :
						// InternalQVTbase.g:6519:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
					{
						otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return ;
						// InternalQVTbase.g:6523:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
						// InternalQVTbase.g:6524:1: (lv_ownedInitExpression_5_0= ruleExpCS )
						{
							// InternalQVTbase.g:6524:1: (lv_ownedInitExpression_5_0= ruleExpCS )
							// InternalQVTbase.g:6525:3: lv_ownedInitExpression_5_0= ruleExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedInitExpression_5_0=ruleExpCS();

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
	// $ANTLR end synpred246_InternalQVTbase

	// $ANTLR start synpred249_InternalQVTbase
	public final void synpred249_InternalQVTbase_fragment() throws RecognitionException {
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		EObject lv_ownedType_7_0 = null;

		EObject lv_ownedCoIterator_9_0 = null;

		EObject lv_ownedInitExpression_11_0 = null;


		// InternalQVTbase.g:6542:6: ( (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) )
		// InternalQVTbase.g:6542:6: (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? )
		{
			// InternalQVTbase.g:6542:6: (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? )
			// InternalQVTbase.g:6542:8: otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )?
			{
				otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
				// InternalQVTbase.g:6546:1: ( (lv_ownedType_7_0= ruleTypeExpCS ) )
				// InternalQVTbase.g:6547:1: (lv_ownedType_7_0= ruleTypeExpCS )
				{
					// InternalQVTbase.g:6547:1: (lv_ownedType_7_0= ruleTypeExpCS )
					// InternalQVTbase.g:6548:3: lv_ownedType_7_0= ruleTypeExpCS
					{
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_1_0());

						}
						pushFollow(FollowSets000.FOLLOW_95);
						lv_ownedType_7_0=ruleTypeExpCS();

						state._fsp--;
						if (state.failed) return ;

					}


				}

				// InternalQVTbase.g:6564:2: (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )?
				int alt269=2;
				int LA269_0 = input.LA(1);

				if ( (LA269_0==110) ) {
					alt269=1;
				}
				switch (alt269) {
					case 1 :
						// InternalQVTbase.g:6564:4: otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) )
					{
						otherlv_8=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return ;
						// InternalQVTbase.g:6568:1: ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) )
						// InternalQVTbase.g:6569:1: (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS )
						{
							// InternalQVTbase.g:6569:1: (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS )
							// InternalQVTbase.g:6570:3: lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_94);
								lv_ownedCoIterator_9_0=ruleCoIteratorVariableCS();

								state._fsp--;
								if (state.failed) return ;

							}


						}


					}
					break;

				}

				// InternalQVTbase.g:6586:4: (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )?
				int alt270=2;
				int LA270_0 = input.LA(1);

				if ( (LA270_0==21) ) {
					alt270=1;
				}
				switch (alt270) {
					case 1 :
						// InternalQVTbase.g:6586:6: otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) )
					{
						otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_75); if (state.failed) return ;
						// InternalQVTbase.g:6590:1: ( (lv_ownedInitExpression_11_0= ruleExpCS ) )
						// InternalQVTbase.g:6591:1: (lv_ownedInitExpression_11_0= ruleExpCS )
						{
							// InternalQVTbase.g:6591:1: (lv_ownedInitExpression_11_0= ruleExpCS )
							// InternalQVTbase.g:6592:3: lv_ownedInitExpression_11_0= ruleExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_2);
								lv_ownedInitExpression_11_0=ruleExpCS();

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
	// $ANTLR end synpred249_InternalQVTbase

	// $ANTLR start synpred252_InternalQVTbase
	public final void synpred252_InternalQVTbase_fragment() throws RecognitionException {
		Token otherlv_12=null;
		Token otherlv_14=null;
		Token otherlv_16=null;
		EObject lv_ownedType_13_0 = null;

		EObject lv_ownedCoIterator_15_0 = null;

		EObject lv_ownedInitExpression_17_0 = null;


		// InternalQVTbase.g:6609:6: ( ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )
		// InternalQVTbase.g:6609:6: ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) )
		{
			// InternalQVTbase.g:6609:6: ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) )
			// InternalQVTbase.g:6609:7: (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) )
			{
				// InternalQVTbase.g:6609:7: (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )?
				int alt271=2;
				int LA271_0 = input.LA(1);

				if ( (LA271_0==20) ) {
					alt271=1;
				}
				switch (alt271) {
					case 1 :
						// InternalQVTbase.g:6609:9: otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) )
					{
						otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_8); if (state.failed) return ;
						// InternalQVTbase.g:6613:1: ( (lv_ownedType_13_0= ruleTypeExpCS ) )
						// InternalQVTbase.g:6614:1: (lv_ownedType_13_0= ruleTypeExpCS )
						{
							// InternalQVTbase.g:6614:1: (lv_ownedType_13_0= ruleTypeExpCS )
							// InternalQVTbase.g:6615:3: lv_ownedType_13_0= ruleTypeExpCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_96);
								lv_ownedType_13_0=ruleTypeExpCS();

								state._fsp--;
								if (state.failed) return ;

							}


						}


					}
					break;

				}

				// InternalQVTbase.g:6631:4: (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )?
				int alt272=2;
				int LA272_0 = input.LA(1);

				if ( (LA272_0==110) ) {
					alt272=1;
				}
				switch (alt272) {
					case 1 :
						// InternalQVTbase.g:6631:6: otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) )
					{
						otherlv_14=(Token)match(input,110,FollowSets000.FOLLOW_6); if (state.failed) return ;
						// InternalQVTbase.g:6635:1: ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) )
						// InternalQVTbase.g:6636:1: (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS )
						{
							// InternalQVTbase.g:6636:1: (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS )
							// InternalQVTbase.g:6637:3: lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS
							{
								if ( state.backtracking==0 ) {

									newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0());

								}
								pushFollow(FollowSets000.FOLLOW_97);
								lv_ownedCoIterator_15_0=ruleCoIteratorVariableCS();

								state._fsp--;
								if (state.failed) return ;

							}


						}


					}
					break;

				}

				otherlv_16=(Token)match(input,119,FollowSets000.FOLLOW_75); if (state.failed) return ;
				// InternalQVTbase.g:6657:1: ( (lv_ownedInitExpression_17_0= ruleExpCS ) )
				// InternalQVTbase.g:6658:1: (lv_ownedInitExpression_17_0= ruleExpCS )
				{
					// InternalQVTbase.g:6658:1: (lv_ownedInitExpression_17_0= ruleExpCS )
					// InternalQVTbase.g:6659:3: lv_ownedInitExpression_17_0= ruleExpCS
					{
						if ( state.backtracking==0 ) {

							newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_3_0());

						}
						pushFollow(FollowSets000.FOLLOW_2);
						lv_ownedInitExpression_17_0=ruleExpCS();

						state._fsp--;
						if (state.failed) return ;

					}


				}


			}


		}
	}
	// $ANTLR end synpred252_InternalQVTbase

	// Delegated rules

	public final boolean synpred219_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred219_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred246_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred246_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred252_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred252_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred220_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred220_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred241_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred241_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred249_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred249_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred211_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred211_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred208_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred208_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred238_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred238_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred235_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred235_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred218_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred218_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred222_InternalQVTbase() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred222_InternalQVTbase_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA125 dfa125 = new DFA125(this);
	protected DFA128 dfa128 = new DFA128(this);
	protected DFA131 dfa131 = new DFA131(this);
	protected DFA147 dfa147 = new DFA147(this);
	protected DFA156 dfa156 = new DFA156(this);
	static final String dfa_1s = "\23\uffff";
	static final String dfa_2s = "\1\7\12\uffff\5\0\3\uffff";
	static final String dfa_3s = "\1\152\12\uffff\5\0\3\uffff";
	static final String dfa_4s = "\1\uffff\1\1\1\uffff\1\2\16\uffff\1\3";
	static final String dfa_5s = "\13\uffff\1\0\1\1\1\2\1\3\1\4\3\uffff}>";
	static final String[] dfa_6s = {
		"\2\1\123\uffff\12\3\1\13\1\14\1\15\1\16\1\17",
		"",
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

	static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
	static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
	static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
	static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
	static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
	static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

	class DFA125 extends DFA {

		public DFA125(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 125;
			this.eot = dfa_1;
			this.eof = dfa_1;
			this.min = dfa_2;
			this.max = dfa_3;
			this.accept = dfa_4;
			this.special = dfa_5;
			this.transition = dfa_6;
		}
		@Override
		public String getDescription() {
			return "5251:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
				case 0 :
					int LA125_11 = input.LA(1);


					int index125_11 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred208_InternalQVTbase()) ) {s = 3;}

					else if ( (true) ) {s = 18;}


					input.seek(index125_11);
					if ( s>=0 ) return s;
					break;
				case 1 :
					int LA125_12 = input.LA(1);


					int index125_12 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred208_InternalQVTbase()) ) {s = 3;}

					else if ( (true) ) {s = 18;}


					input.seek(index125_12);
					if ( s>=0 ) return s;
					break;
				case 2 :
					int LA125_13 = input.LA(1);


					int index125_13 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred208_InternalQVTbase()) ) {s = 3;}

					else if ( (true) ) {s = 18;}


					input.seek(index125_13);
					if ( s>=0 ) return s;
					break;
				case 3 :
					int LA125_14 = input.LA(1);


					int index125_14 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred208_InternalQVTbase()) ) {s = 3;}

					else if ( (true) ) {s = 18;}


					input.seek(index125_14);
					if ( s>=0 ) return s;
					break;
				case 4 :
					int LA125_15 = input.LA(1);


					int index125_15 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred208_InternalQVTbase()) ) {s = 3;}

					else if ( (true) ) {s = 18;}


					input.seek(index125_15);
					if ( s>=0 ) return s;
					break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 125, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_7s = "\41\uffff";
	static final String dfa_8s = "\1\4\3\0\35\uffff";
	static final String dfa_9s = "\1\177\3\0\35\uffff";
	static final String dfa_10s = "\4\uffff\1\1\33\uffff\1\2";
	static final String dfa_11s = "\1\uffff\1\0\1\1\1\2\35\uffff}>";
	static final String[] dfa_12s = {
		"\1\4\1\uffff\3\4\52\uffff\1\4\21\uffff\1\1\1\2\1\3\1\4\23\uffff\17\4\2\uffff\1\4\1\uffff\4\4\6\uffff\1\4\4\uffff\1\40\1\4",
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
		""
	};

	static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
	static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
	static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
	static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
	static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
	static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

	class DFA128 extends DFA {

		public DFA128(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 128;
			this.eot = dfa_7;
			this.eof = dfa_7;
			this.min = dfa_8;
			this.max = dfa_9;
			this.accept = dfa_10;
			this.special = dfa_11;
			this.transition = dfa_12;
		}
		@Override
		public String getDescription() {
			return "5361:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
				case 0 :
					int LA128_1 = input.LA(1);


					int index128_1 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred211_InternalQVTbase()) ) {s = 4;}

					else if ( (true) ) {s = 32;}


					input.seek(index128_1);
					if ( s>=0 ) return s;
					break;
				case 1 :
					int LA128_2 = input.LA(1);


					int index128_2 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred211_InternalQVTbase()) ) {s = 4;}

					else if ( (true) ) {s = 32;}


					input.seek(index128_2);
					if ( s>=0 ) return s;
					break;
				case 2 :
					int LA128_3 = input.LA(1);


					int index128_3 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred211_InternalQVTbase()) ) {s = 4;}

					else if ( (true) ) {s = 32;}


					input.seek(index128_3);
					if ( s>=0 ) return s;
					break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 128, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_13s = "\40\uffff";
	static final String dfa_14s = "\1\4\12\uffff\7\0\16\uffff";
	static final String dfa_15s = "\1\177\12\uffff\7\0\16\uffff";
	static final String dfa_16s = "\1\uffff\1\1\1\2\1\3\1\4\15\uffff\1\10\1\11\7\uffff\1\12\1\uffff\1\5\1\6\1\7";
	static final String dfa_17s = "\13\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\16\uffff}>";
	static final String[] dfa_18s = {
		"\1\4\1\uffff\1\4\2\33\52\uffff\1\1\24\uffff\1\4\23\uffff\1\14\1\13\10\23\1\15\1\16\1\17\1\20\1\21\2\uffff\1\22\1\uffff\4\4\6\uffff\1\2\5\uffff\1\3",
		"",
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
		""
	};

	static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
	static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
	static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
	static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
	static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
	static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

	class DFA131 extends DFA {

		public DFA131(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 131;
			this.eot = dfa_13;
			this.eof = dfa_13;
			this.min = dfa_14;
			this.max = dfa_15;
			this.accept = dfa_16;
			this.special = dfa_17;
			this.transition = dfa_18;
		}
		@Override
		public String getDescription() {
			return "5610:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_TypeLiteralExpCS_8= ruleTypeLiteralExpCS | this_NameExpCS_9= ruleNameExpCS )";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
				case 0 :
					int LA131_11 = input.LA(1);


					int index131_11 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred218_InternalQVTbase()) ) {s = 29;}

					else if ( (synpred222_InternalQVTbase()) ) {s = 19;}


					input.seek(index131_11);
					if ( s>=0 ) return s;
					break;
				case 1 :
					int LA131_12 = input.LA(1);


					int index131_12 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred219_InternalQVTbase()) ) {s = 30;}

					else if ( (synpred222_InternalQVTbase()) ) {s = 19;}


					input.seek(index131_12);
					if ( s>=0 ) return s;
					break;
				case 2 :
					int LA131_13 = input.LA(1);


					int index131_13 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred220_InternalQVTbase()) ) {s = 31;}

					else if ( (synpred222_InternalQVTbase()) ) {s = 19;}


					input.seek(index131_13);
					if ( s>=0 ) return s;
					break;
				case 3 :
					int LA131_14 = input.LA(1);


					int index131_14 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred220_InternalQVTbase()) ) {s = 31;}

					else if ( (synpred222_InternalQVTbase()) ) {s = 19;}


					input.seek(index131_14);
					if ( s>=0 ) return s;
					break;
				case 4 :
					int LA131_15 = input.LA(1);


					int index131_15 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred220_InternalQVTbase()) ) {s = 31;}

					else if ( (synpred222_InternalQVTbase()) ) {s = 19;}


					input.seek(index131_15);
					if ( s>=0 ) return s;
					break;
				case 5 :
					int LA131_16 = input.LA(1);


					int index131_16 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred220_InternalQVTbase()) ) {s = 31;}

					else if ( (synpred222_InternalQVTbase()) ) {s = 19;}


					input.seek(index131_16);
					if ( s>=0 ) return s;
					break;
				case 6 :
					int LA131_17 = input.LA(1);


					int index131_17 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred220_InternalQVTbase()) ) {s = 31;}

					else if ( (synpred222_InternalQVTbase()) ) {s = 19;}


					input.seek(index131_17);
					if ( s>=0 ) return s;
					break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 131, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_19s = "\13\uffff";
	static final String dfa_20s = "\1\4\12\uffff";
	static final String dfa_21s = "\1\24\2\0\10\uffff";
	static final String dfa_22s = "\1\170\2\0\10\uffff";
	static final String dfa_23s = "\3\uffff\1\3\1\4\4\uffff\1\1\1\2";
	static final String dfa_24s = "\1\uffff\1\0\1\1\10\uffff}>";
	static final String[] dfa_25s = {
		"\1\2\22\uffff\1\4\2\uffff\1\4\11\uffff\1\4\71\uffff\1\1\10\uffff\1\3\1\4",
		"\1\uffff",
		"\1\uffff",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		""
	};

	static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
	static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
	static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
	static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
	static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
	static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
	static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

	class DFA147 extends DFA {

		public DFA147(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 147;
			this.eot = dfa_19;
			this.eof = dfa_20;
			this.min = dfa_21;
			this.max = dfa_22;
			this.accept = dfa_23;
			this.special = dfa_24;
			this.transition = dfa_25;
		}
		@Override
		public String getDescription() {
			return "6144:2: ( (otherlv_1= '<-' ( (lv_ownedCoIterator_2_0= ruleCoIteratorVariableCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) (otherlv_7= '<-' ( (lv_ownedCoIterator_8_0= ruleCoIteratorVariableCS ) ) )? (otherlv_9= '=' ( (lv_ownedInitExpression_10_0= ruleExpCS ) ) )? ) | ( (otherlv_11= ':' ( (lv_ownedType_12_0= ruleTypeExpCS ) ) )? (otherlv_13= '<-' ( (lv_ownedCoIterator_14_0= ruleCoIteratorVariableCS ) ) )? otherlv_15= 'in' ( (lv_ownedInitExpression_16_0= ruleExpCS ) ) ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
				case 0 :
					int LA147_1 = input.LA(1);


					int index147_1 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred235_InternalQVTbase()) ) {s = 9;}

					else if ( (synpred241_InternalQVTbase()) ) {s = 3;}


					input.seek(index147_1);
					if ( s>=0 ) return s;
					break;
				case 1 :
					int LA147_2 = input.LA(1);


					int index147_2 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred238_InternalQVTbase()) ) {s = 10;}

					else if ( (synpred241_InternalQVTbase()) ) {s = 3;}


					input.seek(index147_2);
					if ( s>=0 ) return s;
					break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 147, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	class DFA156 extends DFA {

		public DFA156(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 156;
			this.eot = dfa_19;
			this.eof = dfa_20;
			this.min = dfa_21;
			this.max = dfa_22;
			this.accept = dfa_23;
			this.special = dfa_24;
			this.transition = dfa_25;
		}
		@Override
		public String getDescription() {
			return "6497:2: ( (otherlv_2= '<-' ( (lv_ownedCoIterator_3_0= ruleCoIteratorVariableCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= ':' ( (lv_ownedType_7_0= ruleTypeExpCS ) ) (otherlv_8= '<-' ( (lv_ownedCoIterator_9_0= ruleCoIteratorVariableCS ) ) )? (otherlv_10= '=' ( (lv_ownedInitExpression_11_0= ruleExpCS ) ) )? ) | ( (otherlv_12= ':' ( (lv_ownedType_13_0= ruleTypeExpCS ) ) )? (otherlv_14= '<-' ( (lv_ownedCoIterator_15_0= ruleCoIteratorVariableCS ) ) )? otherlv_16= 'in' ( (lv_ownedInitExpression_17_0= ruleExpCS ) ) ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
				case 0 :
					int LA156_1 = input.LA(1);


					int index156_1 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred246_InternalQVTbase()) ) {s = 9;}

					else if ( (synpred252_InternalQVTbase()) ) {s = 3;}


					input.seek(index156_1);
					if ( s>=0 ) return s;
					break;
				case 1 :
					int LA156_2 = input.LA(1);


					int index156_2 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred249_InternalQVTbase()) ) {s = 10;}

					else if ( (synpred252_InternalQVTbase()) ) {s = 3;}


					input.seek(index156_2);
					if ( s>=0 ) return s;
					break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 156, _s, input);
			error(nvae);
			throw nvae;
		}
	}



	private static class FollowSets000 {
		public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
		public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
		public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000C0000L});
		public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000080000L});
		public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000A0000L});
		public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000180L});
		public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000040000700000L});
		public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000180L,0x000007FFF0000000L});
		public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000040000600000L});
		public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
		public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000040000400000L});
		public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000007FFF800000L});
		public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000001FFFF800000L});
		public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000017FFF800000L});
		public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000B0000000000L});
		public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100180L});
		public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
		public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00080400000001F0L,0xC207A7FFF00001E0L});
		public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000040000000000L});
		public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xE000010000000000L});
		public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000040000000002L});
		public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000200000000000L});
		public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0008040000500000L});
		public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000040000500000L});
		public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000C10000000000L});
		public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000010000000000L});
		public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0002010000000180L});
		public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000020L});
		public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0004000000040000L});
		public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0004000000000000L});
		public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0004000000020000L});
		public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0008000000000180L});
		public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0008000000000000L});
		public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0010000000000180L});
		public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0010008000000000L});
		public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0020040000500000L});
		public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0020040000400000L});
		public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000048000400000L});
		public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000619800000L});
		public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000018619800000L});
		public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000010619800000L});
		public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040010000000000L});
		public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000500002L});
		public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000400002L});
		public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000618000000L});
		public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000018618000000L});
		public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000010618000000L});
		public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0080000000040000L});
		public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0080000000000000L});
		public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0080000000020000L});
		public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0100040000700000L});
		public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x1E00007FF9800000L});
		public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x1E0001FFF9800000L});
		public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x1E00017FF9800000L});
		public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000001L});
		public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000400180L});
		public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000010000000180L});
		public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000018000000000L});
		public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
		public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0008040000500000L,0x0000000000000008L});
		public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000040000500000L,0x0000000000000008L});
		public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000048000500000L});
		public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000010L});
		public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x00840100000E0000L});
		public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
		public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000040L});
		public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0008000000000002L});
		public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0010000000000000L,0x0020000000000000L});
		public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0010000000000000L});
		public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000008000000000L});
		public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000400000L});
		public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x00080100001001D0L,0xC207A7FFF00001E0L});
		public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x00080000001001D0L,0xC207A7FFF00001E0L});
		public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
		public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x00080000000001D0L,0xC207A7FFF00001E0L});
		public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000008000000000L,0x0000100000000000L});
		public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000200000L});
		public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x00080100000001D0L,0xC207A7FFF00001E0L});
		public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
		public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000300000L});
		public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000012L});
		public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000200002L,0x000000000FFFFF20L});
		public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x00080000000001D0L,0x8207A7FFF00001E0L});
		public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0008000000400002L,0x0028000000000000L});
		public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000400002L,0x0008000000000000L});
		public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
		public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
		public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000010000000190L});
		public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000190L});
		public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x00180000001001D0L,0xC207A7FFF00001E0L});
		public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0010048000000000L,0x0100000000000000L});
		public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000008000000000L,0x0040000000000000L});
		public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000100002L,0x0080400000000000L});
		public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000200002L});
		public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000200002L,0x0000400000000000L});
		public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0080400000000000L});
		public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
		public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000100002L});
		public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
		public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x2800000000000000L});
		public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
		public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000008000000000L,0x0080000000000000L});
		public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0008000000300000L});
		public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000100L});
		public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000500L,0x0000000000000004L});
		public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000000003L});
		public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
		public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
		public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000008000000002L,0x0020000000000000L});
		public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000180L,0x000007FFF0000000L,0x0000000000000004L});
		public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
		public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
	}


}