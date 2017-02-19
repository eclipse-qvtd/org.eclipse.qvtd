/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class QVTbaseGrammarAccess extends AbstractGrammarElementFinder {


	public class AttributeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.AttributeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final Keyword cQualifiersStaticKeyword_0_0_0_0 = (Keyword)cQualifiersAssignment_0_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final Keyword cQualifiersDefinitionKeyword_0_0_1_0 = (Keyword)cQualifiersAssignment_0_0_1.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cQualifiersAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final Keyword cQualifiersDefinitionKeyword_0_1_0_0 = (Keyword)cQualifiersAssignment_0_1_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final Keyword cQualifiersStaticKeyword_0_1_1_0 = (Keyword)cQualifiersAssignment_0_1_1.eContents().get(0);
		private final Keyword cAttributeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0 = (RuleCall)cOwnedTypeAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cDefaultAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0 = (RuleCall)cDefaultAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Alternatives cAlternatives_5_1_0 = (Alternatives)cGroup_5_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_0 = (Assignment)cAlternatives_5_1_0.eContents().get(0);
		private final Keyword cQualifiersDerivedKeyword_5_1_0_0_0 = (Keyword)cQualifiersAssignment_5_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_1 = (Assignment)cAlternatives_5_1_0.eContents().get(1);
		private final Keyword cQualifiersDerivedKeyword_5_1_0_1_0 = (Keyword)cQualifiersAssignment_5_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_2 = (Assignment)cAlternatives_5_1_0.eContents().get(2);
		private final Keyword cQualifiersIdKeyword_5_1_0_2_0 = (Keyword)cQualifiersAssignment_5_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_3 = (Assignment)cAlternatives_5_1_0.eContents().get(3);
		private final Keyword cQualifiersIdKeyword_5_1_0_3_0 = (Keyword)cQualifiersAssignment_5_1_0_3.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_4 = (Assignment)cAlternatives_5_1_0.eContents().get(4);
		private final Keyword cQualifiersOrderedKeyword_5_1_0_4_0 = (Keyword)cQualifiersAssignment_5_1_0_4.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_5 = (Assignment)cAlternatives_5_1_0.eContents().get(5);
		private final Keyword cQualifiersOrderedKeyword_5_1_0_5_0 = (Keyword)cQualifiersAssignment_5_1_0_5.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_6 = (Assignment)cAlternatives_5_1_0.eContents().get(6);
		private final Keyword cQualifiersReadonlyKeyword_5_1_0_6_0 = (Keyword)cQualifiersAssignment_5_1_0_6.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_7 = (Assignment)cAlternatives_5_1_0.eContents().get(7);
		private final Keyword cQualifiersReadonlyKeyword_5_1_0_7_0 = (Keyword)cQualifiersAssignment_5_1_0_7.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_8 = (Assignment)cAlternatives_5_1_0.eContents().get(8);
		private final Keyword cQualifiersTransientKeyword_5_1_0_8_0 = (Keyword)cQualifiersAssignment_5_1_0_8.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_9 = (Assignment)cAlternatives_5_1_0.eContents().get(9);
		private final Keyword cQualifiersTransientKeyword_5_1_0_9_0 = (Keyword)cQualifiersAssignment_5_1_0_9.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_10 = (Assignment)cAlternatives_5_1_0.eContents().get(10);
		private final Keyword cQualifiersUniqueKeyword_5_1_0_10_0 = (Keyword)cQualifiersAssignment_5_1_0_10.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_11 = (Assignment)cAlternatives_5_1_0.eContents().get(11);
		private final Keyword cQualifiersUniqueKeyword_5_1_0_11_0 = (Keyword)cQualifiersAssignment_5_1_0_11.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_12 = (Assignment)cAlternatives_5_1_0.eContents().get(12);
		private final Keyword cQualifiersUnsettableKeyword_5_1_0_12_0 = (Keyword)cQualifiersAssignment_5_1_0_12.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_13 = (Assignment)cAlternatives_5_1_0.eContents().get(13);
		private final Keyword cQualifiersUnsettableKeyword_5_1_0_13_0 = (Keyword)cQualifiersAssignment_5_1_0_13.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_14 = (Assignment)cAlternatives_5_1_0.eContents().get(14);
		private final Keyword cQualifiersVolatileKeyword_5_1_0_14_0 = (Keyword)cQualifiersAssignment_5_1_0_14.eContents().get(0);
		private final Assignment cQualifiersAssignment_5_1_0_15 = (Assignment)cAlternatives_5_1_0.eContents().get(15);
		private final Keyword cQualifiersVolatileKeyword_5_1_0_15_0 = (Keyword)cQualifiersAssignment_5_1_0_15.eContents().get(0);
		private final Keyword cCommaKeyword_5_1_1 = (Keyword)cGroup_5_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Group cGroup_6_0 = (Group)cAlternatives_6.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6_0_0 = (Keyword)cGroup_6_0.eContents().get(0);
		private final Alternatives cAlternatives_6_0_1 = (Alternatives)cGroup_6_0.eContents().get(1);
		private final Group cGroup_6_0_1_0 = (Group)cAlternatives_6_0_1.eContents().get(0);
		private final Keyword cInitialKeyword_6_0_1_0_0 = (Keyword)cGroup_6_0_1_0.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_6_0_1_0_1 = (RuleCall)cGroup_6_0_1_0.eContents().get(1);
		private final Keyword cColonKeyword_6_0_1_0_2 = (Keyword)cGroup_6_0_1_0.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_6_0_1_0_3 = (Assignment)cGroup_6_0_1_0.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_6_0_1_0_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_6_0_1_0_4 = (Keyword)cGroup_6_0_1_0.eContents().get(4);
		private final Group cGroup_6_0_1_1 = (Group)cAlternatives_6_0_1.eContents().get(1);
		private final Keyword cDerivationKeyword_6_0_1_1_0 = (Keyword)cGroup_6_0_1_1.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_6_0_1_1_1 = (RuleCall)cGroup_6_0_1_1.eContents().get(1);
		private final Keyword cColonKeyword_6_0_1_1_2 = (Keyword)cGroup_6_0_1_1.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_6_0_1_1_3 = (Assignment)cGroup_6_0_1_1.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_6_0_1_1_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_6_0_1_1_4 = (Keyword)cGroup_6_0_1_1.eContents().get(4);
		private final Keyword cRightCurlyBracketKeyword_6_0_2 = (Keyword)cGroup_6_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_6_1 = (Keyword)cAlternatives_6.eContents().get(1);

		//AttributeCS base::AttributeCS:
		//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//	'attribute' name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{'
		//	((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' |
		//	qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
		//	qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		//	'}')? ('{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation'
		//	UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)? 'attribute'
		//name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{'
		//((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' |
		//qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
		//qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+ '}')? ('{' ('initial'
		//UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		public Group getGroup() { return cGroup; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//qualifiers+='static' qualifiers+='definition'?
		public Group getGroup_0_0() { return cGroup_0_0; }

		//qualifiers+='static'
		public Assignment getQualifiersAssignment_0_0_0() { return cQualifiersAssignment_0_0_0; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_0_0_0() { return cQualifiersStaticKeyword_0_0_0_0; }

		//qualifiers+='definition'?
		public Assignment getQualifiersAssignment_0_0_1() { return cQualifiersAssignment_0_0_1; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_0_1_0() { return cQualifiersDefinitionKeyword_0_0_1_0; }

		//qualifiers+='definition' qualifiers+='static'?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//qualifiers+='definition'
		public Assignment getQualifiersAssignment_0_1_0() { return cQualifiersAssignment_0_1_0; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_1_0_0() { return cQualifiersDefinitionKeyword_0_1_0_0; }

		//qualifiers+='static'?
		public Assignment getQualifiersAssignment_0_1_1() { return cQualifiersAssignment_0_1_1; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_1_1_0() { return cQualifiersStaticKeyword_0_1_1_0; }

		//'attribute'
		public Keyword getAttributeKeyword_1() { return cAttributeKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_3_1() { return cOwnedTypeAssignment_3_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0; }

		//('=' default=SINGLE_QUOTED_STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//'='
		public Keyword getEqualsSignKeyword_4_0() { return cEqualsSignKeyword_4_0; }

		//default=SINGLE_QUOTED_STRING
		public Assignment getDefaultAssignment_4_1() { return cDefaultAssignment_4_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0() { return cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0; }

		//('{' ((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' |
		//qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
		//qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+ '}')?
		public Group getGroup_5() { return cGroup_5; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0() { return cLeftCurlyBracketKeyword_5_0; }

		//((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' |
		//qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
		//qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		public Group getGroup_5_1() { return cGroup_5_1; }

		//(qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' |
		//qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
		//qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile')
		public Alternatives getAlternatives_5_1_0() { return cAlternatives_5_1_0; }

		//qualifiers+='derived'
		public Assignment getQualifiersAssignment_5_1_0_0() { return cQualifiersAssignment_5_1_0_0; }

		//'derived'
		public Keyword getQualifiersDerivedKeyword_5_1_0_0_0() { return cQualifiersDerivedKeyword_5_1_0_0_0; }

		//qualifiers+='!derived'
		public Assignment getQualifiersAssignment_5_1_0_1() { return cQualifiersAssignment_5_1_0_1; }

		//'!derived'
		public Keyword getQualifiersDerivedKeyword_5_1_0_1_0() { return cQualifiersDerivedKeyword_5_1_0_1_0; }

		//qualifiers+='id'
		public Assignment getQualifiersAssignment_5_1_0_2() { return cQualifiersAssignment_5_1_0_2; }

		//'id'
		public Keyword getQualifiersIdKeyword_5_1_0_2_0() { return cQualifiersIdKeyword_5_1_0_2_0; }

		//qualifiers+='!id'
		public Assignment getQualifiersAssignment_5_1_0_3() { return cQualifiersAssignment_5_1_0_3; }

		//'!id'
		public Keyword getQualifiersIdKeyword_5_1_0_3_0() { return cQualifiersIdKeyword_5_1_0_3_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_5_1_0_4() { return cQualifiersAssignment_5_1_0_4; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_5_1_0_4_0() { return cQualifiersOrderedKeyword_5_1_0_4_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_5_1_0_5() { return cQualifiersAssignment_5_1_0_5; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_5_1_0_5_0() { return cQualifiersOrderedKeyword_5_1_0_5_0; }

		//qualifiers+='readonly'
		public Assignment getQualifiersAssignment_5_1_0_6() { return cQualifiersAssignment_5_1_0_6; }

		//'readonly'
		public Keyword getQualifiersReadonlyKeyword_5_1_0_6_0() { return cQualifiersReadonlyKeyword_5_1_0_6_0; }

		//qualifiers+='!readonly'
		public Assignment getQualifiersAssignment_5_1_0_7() { return cQualifiersAssignment_5_1_0_7; }

		//'!readonly'
		public Keyword getQualifiersReadonlyKeyword_5_1_0_7_0() { return cQualifiersReadonlyKeyword_5_1_0_7_0; }

		//qualifiers+='transient'
		public Assignment getQualifiersAssignment_5_1_0_8() { return cQualifiersAssignment_5_1_0_8; }

		//'transient'
		public Keyword getQualifiersTransientKeyword_5_1_0_8_0() { return cQualifiersTransientKeyword_5_1_0_8_0; }

		//qualifiers+='!transient'
		public Assignment getQualifiersAssignment_5_1_0_9() { return cQualifiersAssignment_5_1_0_9; }

		//'!transient'
		public Keyword getQualifiersTransientKeyword_5_1_0_9_0() { return cQualifiersTransientKeyword_5_1_0_9_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_5_1_0_10() { return cQualifiersAssignment_5_1_0_10; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_5_1_0_10_0() { return cQualifiersUniqueKeyword_5_1_0_10_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_5_1_0_11() { return cQualifiersAssignment_5_1_0_11; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_5_1_0_11_0() { return cQualifiersUniqueKeyword_5_1_0_11_0; }

		//qualifiers+='unsettable'
		public Assignment getQualifiersAssignment_5_1_0_12() { return cQualifiersAssignment_5_1_0_12; }

		//'unsettable'
		public Keyword getQualifiersUnsettableKeyword_5_1_0_12_0() { return cQualifiersUnsettableKeyword_5_1_0_12_0; }

		//qualifiers+='!unsettable'
		public Assignment getQualifiersAssignment_5_1_0_13() { return cQualifiersAssignment_5_1_0_13; }

		//'!unsettable'
		public Keyword getQualifiersUnsettableKeyword_5_1_0_13_0() { return cQualifiersUnsettableKeyword_5_1_0_13_0; }

		//qualifiers+='volatile'
		public Assignment getQualifiersAssignment_5_1_0_14() { return cQualifiersAssignment_5_1_0_14; }

		//'volatile'
		public Keyword getQualifiersVolatileKeyword_5_1_0_14_0() { return cQualifiersVolatileKeyword_5_1_0_14_0; }

		//qualifiers+='!volatile'
		public Assignment getQualifiersAssignment_5_1_0_15() { return cQualifiersAssignment_5_1_0_15; }

		//'!volatile'
		public Keyword getQualifiersVolatileKeyword_5_1_0_15_0() { return cQualifiersVolatileKeyword_5_1_0_15_0; }

		//','?
		public Keyword getCommaKeyword_5_1_1() { return cCommaKeyword_5_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_2() { return cRightCurlyBracketKeyword_5_2; }

		//('{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		public Alternatives getAlternatives_6() { return cAlternatives_6; }

		//'{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}'
		public Group getGroup_6_0() { return cGroup_6_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0_0() { return cLeftCurlyBracketKeyword_6_0_0; }

		//('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')*
		public Alternatives getAlternatives_6_0_1() { return cAlternatives_6_0_1; }

		/// *ownedAnnotations+=AnnotationElementCS
		//	      |* / 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_6_0_1_0() { return cGroup_6_0_1_0; }

		//'initial'
		public Keyword getInitialKeyword_6_0_1_0_0() { return cInitialKeyword_6_0_1_0_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_6_0_1_0_1() { return cUnrestrictedNameParserRuleCall_6_0_1_0_1; }

		//':'
		public Keyword getColonKeyword_6_0_1_0_2() { return cColonKeyword_6_0_1_0_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_6_0_1_0_3() { return cOwnedDefaultExpressionsAssignment_6_0_1_0_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0; }

		//';'
		public Keyword getSemicolonKeyword_6_0_1_0_4() { return cSemicolonKeyword_6_0_1_0_4; }

		//'derivation' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_6_0_1_1() { return cGroup_6_0_1_1; }

		//'derivation'
		public Keyword getDerivationKeyword_6_0_1_1_0() { return cDerivationKeyword_6_0_1_1_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_6_0_1_1_1() { return cUnrestrictedNameParserRuleCall_6_0_1_1_1; }

		//':'
		public Keyword getColonKeyword_6_0_1_1_2() { return cColonKeyword_6_0_1_1_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_6_0_1_1_3() { return cOwnedDefaultExpressionsAssignment_6_0_1_1_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0; }

		//';'
		public Keyword getSemicolonKeyword_6_0_1_1_4() { return cSemicolonKeyword_6_0_1_1_4; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_0_2() { return cRightCurlyBracketKeyword_6_0_2; }

		//';'
		public Keyword getSemicolonKeyword_6_1() { return cSemicolonKeyword_6_1; }
	}

	public class ClassCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.ClassCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cStructuredClassCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDataTypeCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEnumerationCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//ClassCS base::ClassCS:
		//	StructuredClassCS | DataTypeCS | EnumerationCS
		@Override public ParserRule getRule() { return rule; }

		//StructuredClassCS | DataTypeCS | EnumerationCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//StructuredClassCS
		public RuleCall getStructuredClassCSParserRuleCall_0() { return cStructuredClassCSParserRuleCall_0; }

		//DataTypeCS
		public RuleCall getDataTypeCSParserRuleCall_1() { return cDataTypeCSParserRuleCall_1; }

		//EnumerationCS
		public RuleCall getEnumerationCSParserRuleCall_2() { return cEnumerationCSParserRuleCall_2; }
	}

	public class DataTypeCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.DataTypeCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsPrimitiveAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsPrimitivePrimitiveKeyword_0_0 = (Keyword)cIsPrimitiveAssignment_0.eContents().get(0);
		private final Keyword cDatatypeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0 = (RuleCall)cOwnedSignatureAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cInstanceClassNameAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0 = (RuleCall)cInstanceClassNameAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Alternatives cAlternatives_5_1 = (Alternatives)cGroup_5.eContents().get(1);
		private final Assignment cIsSerializableAssignment_5_1_0 = (Assignment)cAlternatives_5_1.eContents().get(0);
		private final Keyword cIsSerializableSerializableKeyword_5_1_0_0 = (Keyword)cIsSerializableAssignment_5_1_0.eContents().get(0);
		private final Keyword cSerializableKeyword_5_1_1 = (Keyword)cAlternatives_5_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Group cGroup_6_0 = (Group)cAlternatives_6.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6_0_0 = (Keyword)cGroup_6_0.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6_0_1 = (Keyword)cGroup_6_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_6_1 = (Keyword)cAlternatives_6.eContents().get(1);

		//DataTypeCS base::DataTypeCS:
		//	isPrimitive?='primitive'? 'datatype' name=UnrestrictedName
		//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable'
		//	| '!serializable')? '}')? ('{' / *(ownedAnnotations+=AnnotationElementCS
		//	        | ownedConstraints+=InvariantConstraintCS)* * / '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//isPrimitive?='primitive'? 'datatype' name=UnrestrictedName ownedSignature=TemplateSignatureCS? (':'
		//instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable' | '!serializable')? '}')? ('{' / *(ownedAnnotations+=AnnotationElementCS
		//	        | ownedConstraints+=InvariantConstraintCS)* * / '}' | ';')
		public Group getGroup() { return cGroup; }

		//isPrimitive?='primitive'?
		public Assignment getIsPrimitiveAssignment_0() { return cIsPrimitiveAssignment_0; }

		//'primitive'
		public Keyword getIsPrimitivePrimitiveKeyword_0_0() { return cIsPrimitivePrimitiveKeyword_0_0; }

		//'datatype'
		public Keyword getDatatypeKeyword_1() { return cDatatypeKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_3() { return cOwnedSignatureAssignment_3; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0; }

		//(':' instanceClassName=SINGLE_QUOTED_STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//':'
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//instanceClassName=SINGLE_QUOTED_STRING
		public Assignment getInstanceClassNameAssignment_4_1() { return cInstanceClassNameAssignment_4_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0() { return cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0; }

		//('{' (isSerializable?='serializable' | '!serializable')? '}')?
		public Group getGroup_5() { return cGroup_5; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0() { return cLeftCurlyBracketKeyword_5_0; }

		//(isSerializable?='serializable' | '!serializable')?
		public Alternatives getAlternatives_5_1() { return cAlternatives_5_1; }

		//isSerializable?='serializable'
		public Assignment getIsSerializableAssignment_5_1_0() { return cIsSerializableAssignment_5_1_0; }

		//'serializable'
		public Keyword getIsSerializableSerializableKeyword_5_1_0_0() { return cIsSerializableSerializableKeyword_5_1_0_0; }

		//'!serializable'
		public Keyword getSerializableKeyword_5_1_1() { return cSerializableKeyword_5_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_2() { return cRightCurlyBracketKeyword_5_2; }

		//('{' / *(ownedAnnotations+=AnnotationElementCS
		//	        | ownedConstraints+=InvariantConstraintCS)* * / '}' | ';')
		public Alternatives getAlternatives_6() { return cAlternatives_6; }

		//'{' / *(ownedAnnotations+=AnnotationElementCS
		//	        | ownedConstraints+=InvariantConstraintCS)* * / '}'
		public Group getGroup_6_0() { return cGroup_6_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0_0() { return cLeftCurlyBracketKeyword_6_0_0; }

		/// *(ownedAnnotations+=AnnotationElementCS
		//	        | ownedConstraints+=InvariantConstraintCS)* * / '}'
		public Keyword getRightCurlyBracketKeyword_6_0_1() { return cRightCurlyBracketKeyword_6_0_1; }

		//';'
		public Keyword getSemicolonKeyword_6_1() { return cSemicolonKeyword_6_1; }
	}

	public class EnumerationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEnumKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0 = (RuleCall)cOwnedSignatureAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cInstanceClassNameAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0 = (RuleCall)cInstanceClassNameAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cIsSerializableAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final Keyword cIsSerializableSerializableKeyword_4_1_0_0 = (Keyword)cIsSerializableAssignment_4_1_0.eContents().get(0);
		private final Keyword cSerializableKeyword_4_1_1 = (Keyword)cAlternatives_4_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cAlternatives_5.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Assignment cOwnedLiteralsAssignment_5_0_1 = (Assignment)cGroup_5_0.eContents().get(1);
		private final RuleCall cOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0 = (RuleCall)cOwnedLiteralsAssignment_5_0_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5_0_2 = (Keyword)cGroup_5_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_5_1 = (Keyword)cAlternatives_5.eContents().get(1);

		//EnumerationCS base::EnumerationCS:
		//	'enum' name=UnrestrictedName
		//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable'
		//	| '!serializable')? '}')? ('{' ownedLiterals+=EnumerationLiteralCS
		//	/ *| ownedConstraints+=InvariantConstraintCS* / * '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//'enum' name=UnrestrictedName ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{'
		//(isSerializable?='serializable' | '!serializable')? '}')? ('{' ownedLiterals+=EnumerationLiteralCS
		/// *| ownedConstraints+=InvariantConstraintCS* / * '}' | ';')
		public Group getGroup() { return cGroup; }

		//'enum'
		public Keyword getEnumKeyword_0() { return cEnumKeyword_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_2() { return cOwnedSignatureAssignment_2; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0; }

		//(':' instanceClassName=SINGLE_QUOTED_STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//instanceClassName=SINGLE_QUOTED_STRING
		public Assignment getInstanceClassNameAssignment_3_1() { return cInstanceClassNameAssignment_3_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0() { return cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0; }

		//('{' (isSerializable?='serializable' | '!serializable')? '}')?
		public Group getGroup_4() { return cGroup_4; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4_0() { return cLeftCurlyBracketKeyword_4_0; }

		//(isSerializable?='serializable' | '!serializable')?
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }

		//isSerializable?='serializable'
		public Assignment getIsSerializableAssignment_4_1_0() { return cIsSerializableAssignment_4_1_0; }

		//'serializable'
		public Keyword getIsSerializableSerializableKeyword_4_1_0_0() { return cIsSerializableSerializableKeyword_4_1_0_0; }

		//'!serializable'
		public Keyword getSerializableKeyword_4_1_1() { return cSerializableKeyword_4_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4_2() { return cRightCurlyBracketKeyword_4_2; }

		//('{' ownedLiterals+=EnumerationLiteralCS / *| ownedConstraints+=InvariantConstraintCS* / * '}' | ';')
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//'{' ownedLiterals+=EnumerationLiteralCS / *| ownedConstraints+=InvariantConstraintCS* / * '}'
		public Group getGroup_5_0() { return cGroup_5_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0_0() { return cLeftCurlyBracketKeyword_5_0_0; }

		//ownedLiterals+=EnumerationLiteralCS / *| ownedConstraints+=InvariantConstraintCS* / *
		public Assignment getOwnedLiteralsAssignment_5_0_1() { return cOwnedLiteralsAssignment_5_0_1; }

		//EnumerationLiteralCS
		public RuleCall getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0() { return cOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_0_2() { return cRightCurlyBracketKeyword_5_0_2; }

		//';'
		public Keyword getSemicolonKeyword_5_1() { return cSemicolonKeyword_5_1; }
	}

	public class EnumerationLiteralCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Keyword cLiteralKeyword_0_0_0 = (Keyword)cGroup_0_0.eContents().get(0);
		private final Assignment cNameAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0_1_0 = (RuleCall)cNameAssignment_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final RuleCall cNameEnumerationLiteralNameParserRuleCall_0_1_0 = (RuleCall)cNameAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cValueAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cValueSIGNEDParserRuleCall_1_1_0 = (RuleCall)cValueAssignment_1_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2_0_0 = (Keyword)cGroup_2_0.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_0_1 = (Keyword)cGroup_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_2_1 = (Keyword)cAlternatives_2.eContents().get(1);

		//EnumerationLiteralCS base::EnumerationLiteralCS:
		//	('literal' name=UnrestrictedName | name=EnumerationLiteralName) ('=' value=SIGNED)? ('{'
		//	/ *ownedAnnotations+=AnnotationElementCS* * / '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//('literal' name=UnrestrictedName | name=EnumerationLiteralName) ('=' value=SIGNED)? ('{'
		/// *ownedAnnotations+=AnnotationElementCS* * / '}' | ';')
		public Group getGroup() { return cGroup; }

		//('literal' name=UnrestrictedName | name=EnumerationLiteralName)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'literal' name=UnrestrictedName
		public Group getGroup_0_0() { return cGroup_0_0; }

		//'literal'
		public Keyword getLiteralKeyword_0_0_0() { return cLiteralKeyword_0_0_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0_0_1() { return cNameAssignment_0_0_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0_1_0() { return cNameUnrestrictedNameParserRuleCall_0_0_1_0; }

		//name=EnumerationLiteralName
		public Assignment getNameAssignment_0_1() { return cNameAssignment_0_1; }

		//EnumerationLiteralName
		public RuleCall getNameEnumerationLiteralNameParserRuleCall_0_1_0() { return cNameEnumerationLiteralNameParserRuleCall_0_1_0; }

		//('=' value=SIGNED)?
		public Group getGroup_1() { return cGroup_1; }

		//'='
		public Keyword getEqualsSignKeyword_1_0() { return cEqualsSignKeyword_1_0; }

		//value=SIGNED
		public Assignment getValueAssignment_1_1() { return cValueAssignment_1_1; }

		//SIGNED
		public RuleCall getValueSIGNEDParserRuleCall_1_1_0() { return cValueSIGNEDParserRuleCall_1_1_0; }

		//('{' / *ownedAnnotations+=AnnotationElementCS* * / '}' | ';')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//'{' / *ownedAnnotations+=AnnotationElementCS* * / '}'
		public Group getGroup_2_0() { return cGroup_2_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0_0() { return cLeftCurlyBracketKeyword_2_0_0; }

		/// *ownedAnnotations+=AnnotationElementCS* * / '}'
		public Keyword getRightCurlyBracketKeyword_2_0_1() { return cRightCurlyBracketKeyword_2_0_1; }

		//';'
		public Keyword getSemicolonKeyword_2_1() { return cSemicolonKeyword_2_1; }
	}

	public class OperationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.OperationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final Keyword cQualifiersStaticKeyword_0_0_0_0 = (Keyword)cQualifiersAssignment_0_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final Keyword cQualifiersDefinitionKeyword_0_0_1_0 = (Keyword)cQualifiersAssignment_0_0_1.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cQualifiersAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final Keyword cQualifiersDefinitionKeyword_0_1_0_0 = (Keyword)cQualifiersAssignment_0_1_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final Keyword cQualifiersStaticKeyword_0_1_1_0 = (Keyword)cQualifiersAssignment_0_1_1.eContents().get(0);
		private final Keyword cOperationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedSignatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0 = (RuleCall)cOwnedSignatureAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cOwnedParametersAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_5_0_0 = (RuleCall)cOwnedParametersAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cCommaKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final RuleCall cOwnedParametersParameterCSParserRuleCall_5_1_1_0 = (RuleCall)cOwnedParametersAssignment_5_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cColonKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0 = (RuleCall)cOwnedTypeAssignment_7_1.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cThrowsKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cOwnedExceptionsAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cOwnedExceptionsTypedRefCSParserRuleCall_8_1_0 = (RuleCall)cOwnedExceptionsAssignment_8_1.eContents().get(0);
		private final Group cGroup_8_2 = (Group)cGroup_8.eContents().get(2);
		private final Keyword cCommaKeyword_8_2_0 = (Keyword)cGroup_8_2.eContents().get(0);
		private final Assignment cOwnedExceptionsAssignment_8_2_1 = (Assignment)cGroup_8_2.eContents().get(1);
		private final RuleCall cOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0 = (RuleCall)cOwnedExceptionsAssignment_8_2_1.eContents().get(0);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cLeftCurlyBracketKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Group cGroup_9_1 = (Group)cGroup_9.eContents().get(1);
		private final Alternatives cAlternatives_9_1_0 = (Alternatives)cGroup_9_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_0 = (Assignment)cAlternatives_9_1_0.eContents().get(0);
		private final Keyword cQualifiersDerivedKeyword_9_1_0_0_0 = (Keyword)cQualifiersAssignment_9_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_1 = (Assignment)cAlternatives_9_1_0.eContents().get(1);
		private final Keyword cQualifiersDerivedKeyword_9_1_0_1_0 = (Keyword)cQualifiersAssignment_9_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_2 = (Assignment)cAlternatives_9_1_0.eContents().get(2);
		private final Keyword cQualifiersOrderedKeyword_9_1_0_2_0 = (Keyword)cQualifiersAssignment_9_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_3 = (Assignment)cAlternatives_9_1_0.eContents().get(3);
		private final Keyword cQualifiersOrderedKeyword_9_1_0_3_0 = (Keyword)cQualifiersAssignment_9_1_0_3.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_4 = (Assignment)cAlternatives_9_1_0.eContents().get(4);
		private final Keyword cQualifiersUniqueKeyword_9_1_0_4_0 = (Keyword)cQualifiersAssignment_9_1_0_4.eContents().get(0);
		private final Assignment cQualifiersAssignment_9_1_0_5 = (Assignment)cAlternatives_9_1_0.eContents().get(5);
		private final Keyword cQualifiersUniqueKeyword_9_1_0_5_0 = (Keyword)cQualifiersAssignment_9_1_0_5.eContents().get(0);
		private final Keyword cCommaKeyword_9_1_1 = (Keyword)cGroup_9_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_9_2 = (Keyword)cGroup_9.eContents().get(2);
		private final Alternatives cAlternatives_10 = (Alternatives)cGroup.eContents().get(10);
		private final Group cGroup_10_0 = (Group)cAlternatives_10.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_10_0_0 = (Keyword)cGroup_10_0.eContents().get(0);
		private final Group cGroup_10_0_1 = (Group)cGroup_10_0.eContents().get(1);
		private final Keyword cBodyKeyword_10_0_1_0 = (Keyword)cGroup_10_0_1.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_10_0_1_1 = (RuleCall)cGroup_10_0_1.eContents().get(1);
		private final Keyword cColonKeyword_10_0_1_2 = (Keyword)cGroup_10_0_1.eContents().get(2);
		private final Assignment cOwnedBodyExpressionsAssignment_10_0_1_3 = (Assignment)cGroup_10_0_1.eContents().get(3);
		private final RuleCall cOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0 = (RuleCall)cOwnedBodyExpressionsAssignment_10_0_1_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_10_0_1_4 = (Keyword)cGroup_10_0_1.eContents().get(4);
		private final Keyword cRightCurlyBracketKeyword_10_0_2 = (Keyword)cGroup_10_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_10_1 = (Keyword)cAlternatives_10.eContents().get(1);

		//OperationCS base::OperationCS:
		//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//	'operation' ownedSignature=TemplateSignatureCS? name=UnrestrictedName
		//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)?
		//	('throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)? ('{' ((qualifiers+='derived' |
		//	qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' |
		//	qualifiers+='!unique') ','?)+
		//	'}')? ('{' ('body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';')* '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)? 'operation'
		//ownedSignature=TemplateSignatureCS? name=UnrestrictedName '(' (ownedParameters+=ParameterCS (','
		//ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)? ('throws' ownedExceptions+=TypedRefCS (','
		//ownedExceptions+=TypedRefCS)*)? ('{' ((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+ '}')? ('{' ('body' UnrestrictedName? ':'
		//ownedBodyExpressions+=SpecificationCS? ';')* '}' | ';')
		public Group getGroup() { return cGroup; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//qualifiers+='static' qualifiers+='definition'?
		public Group getGroup_0_0() { return cGroup_0_0; }

		//qualifiers+='static'
		public Assignment getQualifiersAssignment_0_0_0() { return cQualifiersAssignment_0_0_0; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_0_0_0() { return cQualifiersStaticKeyword_0_0_0_0; }

		//qualifiers+='definition'?
		public Assignment getQualifiersAssignment_0_0_1() { return cQualifiersAssignment_0_0_1; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_0_1_0() { return cQualifiersDefinitionKeyword_0_0_1_0; }

		//qualifiers+='definition' qualifiers+='static'?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//qualifiers+='definition'
		public Assignment getQualifiersAssignment_0_1_0() { return cQualifiersAssignment_0_1_0; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_1_0_0() { return cQualifiersDefinitionKeyword_0_1_0_0; }

		//qualifiers+='static'?
		public Assignment getQualifiersAssignment_0_1_1() { return cQualifiersAssignment_0_1_1; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_1_1_0() { return cQualifiersStaticKeyword_0_1_1_0; }

		//'operation'
		public Keyword getOperationKeyword_1() { return cOperationKeyword_1; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_2() { return cOwnedSignatureAssignment_2; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_2_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }

		//(ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)?
		public Group getGroup_5() { return cGroup_5; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_5_0() { return cOwnedParametersAssignment_5_0; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_5_0_0() { return cOwnedParametersParameterCSParserRuleCall_5_0_0; }

		//(',' ownedParameters+=ParameterCS)*
		public Group getGroup_5_1() { return cGroup_5_1; }

		//','
		public Keyword getCommaKeyword_5_1_0() { return cCommaKeyword_5_1_0; }

		//ownedParameters+=ParameterCS
		public Assignment getOwnedParametersAssignment_5_1_1() { return cOwnedParametersAssignment_5_1_1; }

		//ParameterCS
		public RuleCall getOwnedParametersParameterCSParserRuleCall_5_1_1_0() { return cOwnedParametersParameterCSParserRuleCall_5_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_7() { return cGroup_7; }

		//':'
		public Keyword getColonKeyword_7_0() { return cColonKeyword_7_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_7_1() { return cOwnedTypeAssignment_7_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0; }

		//('throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)?
		public Group getGroup_8() { return cGroup_8; }

		//'throws'
		public Keyword getThrowsKeyword_8_0() { return cThrowsKeyword_8_0; }

		//ownedExceptions+=TypedRefCS
		public Assignment getOwnedExceptionsAssignment_8_1() { return cOwnedExceptionsAssignment_8_1; }

		//TypedRefCS
		public RuleCall getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0() { return cOwnedExceptionsTypedRefCSParserRuleCall_8_1_0; }

		//(',' ownedExceptions+=TypedRefCS)*
		public Group getGroup_8_2() { return cGroup_8_2; }

		//','
		public Keyword getCommaKeyword_8_2_0() { return cCommaKeyword_8_2_0; }

		//ownedExceptions+=TypedRefCS
		public Assignment getOwnedExceptionsAssignment_8_2_1() { return cOwnedExceptionsAssignment_8_2_1; }

		//TypedRefCS
		public RuleCall getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0() { return cOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0; }

		//('{' ((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' |
		//qualifiers+='unique' | qualifiers+='!unique') ','?)+ '}')?
		public Group getGroup_9() { return cGroup_9; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_9_0() { return cLeftCurlyBracketKeyword_9_0; }

		//((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique'
		//| qualifiers+='!unique') ','?)+
		public Group getGroup_9_1() { return cGroup_9_1; }

		//(qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique'
		//| qualifiers+='!unique')
		public Alternatives getAlternatives_9_1_0() { return cAlternatives_9_1_0; }

		//qualifiers+='derived'
		public Assignment getQualifiersAssignment_9_1_0_0() { return cQualifiersAssignment_9_1_0_0; }

		//'derived'
		public Keyword getQualifiersDerivedKeyword_9_1_0_0_0() { return cQualifiersDerivedKeyword_9_1_0_0_0; }

		//qualifiers+='!derived'
		public Assignment getQualifiersAssignment_9_1_0_1() { return cQualifiersAssignment_9_1_0_1; }

		//'!derived'
		public Keyword getQualifiersDerivedKeyword_9_1_0_1_0() { return cQualifiersDerivedKeyword_9_1_0_1_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_9_1_0_2() { return cQualifiersAssignment_9_1_0_2; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_9_1_0_2_0() { return cQualifiersOrderedKeyword_9_1_0_2_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_9_1_0_3() { return cQualifiersAssignment_9_1_0_3; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_9_1_0_3_0() { return cQualifiersOrderedKeyword_9_1_0_3_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_9_1_0_4() { return cQualifiersAssignment_9_1_0_4; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_9_1_0_4_0() { return cQualifiersUniqueKeyword_9_1_0_4_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_9_1_0_5() { return cQualifiersAssignment_9_1_0_5; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_9_1_0_5_0() { return cQualifiersUniqueKeyword_9_1_0_5_0; }

		//','?
		public Keyword getCommaKeyword_9_1_1() { return cCommaKeyword_9_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_9_2() { return cRightCurlyBracketKeyword_9_2; }

		//('{' ('body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';')* '}' | ';')
		public Alternatives getAlternatives_10() { return cAlternatives_10; }

		//'{' ('body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';')* '}'
		public Group getGroup_10_0() { return cGroup_10_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_10_0_0() { return cLeftCurlyBracketKeyword_10_0_0; }

		//('body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';')*
		public Group getGroup_10_0_1() { return cGroup_10_0_1; }

		//'body'
		public Keyword getBodyKeyword_10_0_1_0() { return cBodyKeyword_10_0_1_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_10_0_1_1() { return cUnrestrictedNameParserRuleCall_10_0_1_1; }

		//':'
		public Keyword getColonKeyword_10_0_1_2() { return cColonKeyword_10_0_1_2; }

		//ownedBodyExpressions+=SpecificationCS?
		public Assignment getOwnedBodyExpressionsAssignment_10_0_1_3() { return cOwnedBodyExpressionsAssignment_10_0_1_3; }

		//SpecificationCS
		public RuleCall getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0() { return cOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0; }

		//';'
		public Keyword getSemicolonKeyword_10_0_1_4() { return cSemicolonKeyword_10_0_1_4; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_10_0_2() { return cRightCurlyBracketKeyword_10_0_2; }

		//';'
		public Keyword getSemicolonKeyword_10_1() { return cSemicolonKeyword_10_1; }
	}

	public class ParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.ParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Alternatives cAlternatives_2_1_0 = (Alternatives)cGroup_2_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_0 = (Assignment)cAlternatives_2_1_0.eContents().get(0);
		private final Keyword cQualifiersOrderedKeyword_2_1_0_0_0 = (Keyword)cQualifiersAssignment_2_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_1 = (Assignment)cAlternatives_2_1_0.eContents().get(1);
		private final Keyword cQualifiersOrderedKeyword_2_1_0_1_0 = (Keyword)cQualifiersAssignment_2_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_2 = (Assignment)cAlternatives_2_1_0.eContents().get(2);
		private final Keyword cQualifiersUniqueKeyword_2_1_0_2_0 = (Keyword)cQualifiersAssignment_2_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_2_1_0_3 = (Assignment)cAlternatives_2_1_0.eContents().get(3);
		private final Keyword cQualifiersUniqueKeyword_2_1_0_3_0 = (Keyword)cQualifiersAssignment_2_1_0_3.eContents().get(0);
		private final Keyword cCommaKeyword_2_1_1 = (Keyword)cGroup_2_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);

		//ParameterCS base::ParameterCS:
		//	name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' |
		//	qualifiers+='unique' | qualifiers+='!unique') ','?)+
		//	'}')? ('{' / *ownedAnnotations+=AnnotationElementCS* * / '}')?
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' |
		//qualifiers+='unique' | qualifiers+='!unique') ','?)+ '}')? ('{' / *ownedAnnotations+=AnnotationElementCS* * / '}')?
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0; }

		//('{' ((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+ '}')?
		public Group getGroup_2() { return cGroup_2; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//((qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+
		public Group getGroup_2_1() { return cGroup_2_1; }

		//(qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique')
		public Alternatives getAlternatives_2_1_0() { return cAlternatives_2_1_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_2_1_0_0() { return cQualifiersAssignment_2_1_0_0; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_2_1_0_0_0() { return cQualifiersOrderedKeyword_2_1_0_0_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_2_1_0_1() { return cQualifiersAssignment_2_1_0_1; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_2_1_0_1_0() { return cQualifiersOrderedKeyword_2_1_0_1_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_2_1_0_2() { return cQualifiersAssignment_2_1_0_2; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_2_1_0_2_0() { return cQualifiersUniqueKeyword_2_1_0_2_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_2_1_0_3() { return cQualifiersAssignment_2_1_0_3; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_2_1_0_3_0() { return cQualifiersUniqueKeyword_2_1_0_3_0; }

		//','?
		public Keyword getCommaKeyword_2_1_1() { return cCommaKeyword_2_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_2() { return cRightCurlyBracketKeyword_2_2; }

		//('{' / *ownedAnnotations+=AnnotationElementCS* * / '}')?
		public Group getGroup_3() { return cGroup_3; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3_0() { return cLeftCurlyBracketKeyword_3_0; }

		/// *ownedAnnotations+=AnnotationElementCS* * / '}'
		public Keyword getRightCurlyBracketKeyword_3_1() { return cRightCurlyBracketKeyword_3_1; }
	}

	public class ReferenceCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.ReferenceCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final Keyword cQualifiersStaticKeyword_0_0_0_0 = (Keyword)cQualifiersAssignment_0_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final Keyword cQualifiersDefinitionKeyword_0_0_1_0 = (Keyword)cQualifiersAssignment_0_0_1.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Assignment cQualifiersAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final Keyword cQualifiersDefinitionKeyword_0_1_0_0 = (Keyword)cQualifiersAssignment_0_1_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final Keyword cQualifiersStaticKeyword_0_1_1_0 = (Keyword)cQualifiersAssignment_0_1_1.eContents().get(0);
		private final Keyword cPropertyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cNumberSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cReferredOppositeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cReferredOppositePropertyCrossReference_3_1_0 = (CrossReference)cReferredOppositeAssignment_3_1.eContents().get(0);
		private final RuleCall cReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1 = (RuleCall)cReferredOppositePropertyCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0 = (RuleCall)cOwnedTypeAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cEqualsSignKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cDefaultAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0 = (RuleCall)cDefaultAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cLeftCurlyBracketKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Group cGroup_6_1 = (Group)cGroup_6.eContents().get(1);
		private final Alternatives cAlternatives_6_1_0 = (Alternatives)cGroup_6_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_0 = (Assignment)cAlternatives_6_1_0.eContents().get(0);
		private final Keyword cQualifiersComposesKeyword_6_1_0_0_0 = (Keyword)cQualifiersAssignment_6_1_0_0.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_1 = (Assignment)cAlternatives_6_1_0.eContents().get(1);
		private final Keyword cQualifiersComposesKeyword_6_1_0_1_0 = (Keyword)cQualifiersAssignment_6_1_0_1.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_2 = (Assignment)cAlternatives_6_1_0.eContents().get(2);
		private final Keyword cQualifiersDerivedKeyword_6_1_0_2_0 = (Keyword)cQualifiersAssignment_6_1_0_2.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_3 = (Assignment)cAlternatives_6_1_0.eContents().get(3);
		private final Keyword cQualifiersDerivedKeyword_6_1_0_3_0 = (Keyword)cQualifiersAssignment_6_1_0_3.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_4 = (Assignment)cAlternatives_6_1_0.eContents().get(4);
		private final Keyword cQualifiersOrderedKeyword_6_1_0_4_0 = (Keyword)cQualifiersAssignment_6_1_0_4.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_5 = (Assignment)cAlternatives_6_1_0.eContents().get(5);
		private final Keyword cQualifiersOrderedKeyword_6_1_0_5_0 = (Keyword)cQualifiersAssignment_6_1_0_5.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_6 = (Assignment)cAlternatives_6_1_0.eContents().get(6);
		private final Keyword cQualifiersReadonlyKeyword_6_1_0_6_0 = (Keyword)cQualifiersAssignment_6_1_0_6.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_7 = (Assignment)cAlternatives_6_1_0.eContents().get(7);
		private final Keyword cQualifiersReadonlyKeyword_6_1_0_7_0 = (Keyword)cQualifiersAssignment_6_1_0_7.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_8 = (Assignment)cAlternatives_6_1_0.eContents().get(8);
		private final Keyword cQualifiersResolveKeyword_6_1_0_8_0 = (Keyword)cQualifiersAssignment_6_1_0_8.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_9 = (Assignment)cAlternatives_6_1_0.eContents().get(9);
		private final Keyword cQualifiersResolveKeyword_6_1_0_9_0 = (Keyword)cQualifiersAssignment_6_1_0_9.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_10 = (Assignment)cAlternatives_6_1_0.eContents().get(10);
		private final Keyword cQualifiersTransientKeyword_6_1_0_10_0 = (Keyword)cQualifiersAssignment_6_1_0_10.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_11 = (Assignment)cAlternatives_6_1_0.eContents().get(11);
		private final Keyword cQualifiersTransientKeyword_6_1_0_11_0 = (Keyword)cQualifiersAssignment_6_1_0_11.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_12 = (Assignment)cAlternatives_6_1_0.eContents().get(12);
		private final Keyword cQualifiersUniqueKeyword_6_1_0_12_0 = (Keyword)cQualifiersAssignment_6_1_0_12.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_13 = (Assignment)cAlternatives_6_1_0.eContents().get(13);
		private final Keyword cQualifiersUniqueKeyword_6_1_0_13_0 = (Keyword)cQualifiersAssignment_6_1_0_13.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_14 = (Assignment)cAlternatives_6_1_0.eContents().get(14);
		private final Keyword cQualifiersUnsettableKeyword_6_1_0_14_0 = (Keyword)cQualifiersAssignment_6_1_0_14.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_15 = (Assignment)cAlternatives_6_1_0.eContents().get(15);
		private final Keyword cQualifiersUnsettableKeyword_6_1_0_15_0 = (Keyword)cQualifiersAssignment_6_1_0_15.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_16 = (Assignment)cAlternatives_6_1_0.eContents().get(16);
		private final Keyword cQualifiersVolatileKeyword_6_1_0_16_0 = (Keyword)cQualifiersAssignment_6_1_0_16.eContents().get(0);
		private final Assignment cQualifiersAssignment_6_1_0_17 = (Assignment)cAlternatives_6_1_0.eContents().get(17);
		private final Keyword cQualifiersVolatileKeyword_6_1_0_17_0 = (Keyword)cQualifiersAssignment_6_1_0_17.eContents().get(0);
		private final Keyword cCommaKeyword_6_1_1 = (Keyword)cGroup_6_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Group cGroup_7_0 = (Group)cAlternatives_7.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_7_0_0 = (Keyword)cGroup_7_0.eContents().get(0);
		private final Alternatives cAlternatives_7_0_1 = (Alternatives)cGroup_7_0.eContents().get(1);
		private final Group cGroup_7_0_1_0 = (Group)cAlternatives_7_0_1.eContents().get(0);
		private final Keyword cInitialKeyword_7_0_1_0_0 = (Keyword)cGroup_7_0_1_0.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_7_0_1_0_1 = (RuleCall)cGroup_7_0_1_0.eContents().get(1);
		private final Keyword cColonKeyword_7_0_1_0_2 = (Keyword)cGroup_7_0_1_0.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_7_0_1_0_3 = (Assignment)cGroup_7_0_1_0.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_7_0_1_0_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_7_0_1_0_4 = (Keyword)cGroup_7_0_1_0.eContents().get(4);
		private final Group cGroup_7_0_1_1 = (Group)cAlternatives_7_0_1.eContents().get(1);
		private final Keyword cDerivationKeyword_7_0_1_1_0 = (Keyword)cGroup_7_0_1_1.eContents().get(0);
		private final RuleCall cUnrestrictedNameParserRuleCall_7_0_1_1_1 = (RuleCall)cGroup_7_0_1_1.eContents().get(1);
		private final Keyword cColonKeyword_7_0_1_1_2 = (Keyword)cGroup_7_0_1_1.eContents().get(2);
		private final Assignment cOwnedDefaultExpressionsAssignment_7_0_1_1_3 = (Assignment)cGroup_7_0_1_1.eContents().get(3);
		private final RuleCall cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0 = (RuleCall)cOwnedDefaultExpressionsAssignment_7_0_1_1_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_7_0_1_1_4 = (Keyword)cGroup_7_0_1_1.eContents().get(4);
		private final Keyword cRightCurlyBracketKeyword_7_0_2 = (Keyword)cGroup_7_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_7_1 = (Keyword)cAlternatives_7.eContents().get(1);

		//ReferenceCS base::ReferenceCS:
		//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		//	'property' name=UnrestrictedName ('#' referredOpposite=[pivot::Property|UnrestrictedName])? (':'
		//	ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' ((qualifiers+='composes' |
		//	qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' |
		//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' |
		//	qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' | qualifiers+='unique' |
		//	qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' | qualifiers+='volatile' |
		//	qualifiers+='!volatile') ','?)+
		//	'}')? ('{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation'
		//	UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)? 'property'
		//name=UnrestrictedName ('#' referredOpposite=[pivot::Property|UnrestrictedName])? (':'
		//ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' ((qualifiers+='composes' |
		//qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' |
		//qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' |
		//qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' | qualifiers+='unique' |
		//qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' | qualifiers+='volatile' |
		//qualifiers+='!volatile') ','?)+ '}')? ('{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS?
		//';' | 'derivation' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		public Group getGroup() { return cGroup; }

		//(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//qualifiers+='static' qualifiers+='definition'?
		public Group getGroup_0_0() { return cGroup_0_0; }

		//qualifiers+='static'
		public Assignment getQualifiersAssignment_0_0_0() { return cQualifiersAssignment_0_0_0; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_0_0_0() { return cQualifiersStaticKeyword_0_0_0_0; }

		//qualifiers+='definition'?
		public Assignment getQualifiersAssignment_0_0_1() { return cQualifiersAssignment_0_0_1; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_0_1_0() { return cQualifiersDefinitionKeyword_0_0_1_0; }

		//qualifiers+='definition' qualifiers+='static'?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//qualifiers+='definition'
		public Assignment getQualifiersAssignment_0_1_0() { return cQualifiersAssignment_0_1_0; }

		//'definition'
		public Keyword getQualifiersDefinitionKeyword_0_1_0_0() { return cQualifiersDefinitionKeyword_0_1_0_0; }

		//qualifiers+='static'?
		public Assignment getQualifiersAssignment_0_1_1() { return cQualifiersAssignment_0_1_1; }

		//'static'
		public Keyword getQualifiersStaticKeyword_0_1_1_0() { return cQualifiersStaticKeyword_0_1_1_0; }

		//'property'
		public Keyword getPropertyKeyword_1() { return cPropertyKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//('#' referredOpposite=[pivot::Property|UnrestrictedName])?
		public Group getGroup_3() { return cGroup_3; }

		//'#'
		public Keyword getNumberSignKeyword_3_0() { return cNumberSignKeyword_3_0; }

		//referredOpposite=[pivot::Property|UnrestrictedName]
		public Assignment getReferredOppositeAssignment_3_1() { return cReferredOppositeAssignment_3_1; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getReferredOppositePropertyCrossReference_3_1_0() { return cReferredOppositePropertyCrossReference_3_1_0; }

		//UnrestrictedName
		public RuleCall getReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1() { return cReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1; }

		//(':' ownedType=TypedMultiplicityRefCS)?
		public Group getGroup_4() { return cGroup_4; }

		//':'
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//ownedType=TypedMultiplicityRefCS
		public Assignment getOwnedTypeAssignment_4_1() { return cOwnedTypeAssignment_4_1; }

		//TypedMultiplicityRefCS
		public RuleCall getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0() { return cOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0; }

		//('=' default=SINGLE_QUOTED_STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//'='
		public Keyword getEqualsSignKeyword_5_0() { return cEqualsSignKeyword_5_0; }

		//default=SINGLE_QUOTED_STRING
		public Assignment getDefaultAssignment_5_1() { return cDefaultAssignment_5_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0() { return cDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0; }

		//('{' ((qualifiers+='composes' | qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' |
		//qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' |
		//qualifiers+='resolve' | qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' |
		//qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//qualifiers+='volatile' | qualifiers+='!volatile') ','?)+ '}')?
		public Group getGroup_6() { return cGroup_6; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0() { return cLeftCurlyBracketKeyword_6_0; }

		//((qualifiers+='composes' | qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' |
		//qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' |
		//qualifiers+='resolve' | qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' |
		//qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
		public Group getGroup_6_1() { return cGroup_6_1; }

		//(qualifiers+='composes' | qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' |
		//qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' |
		//qualifiers+='resolve' | qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' |
		//qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' |
		//qualifiers+='volatile' | qualifiers+='!volatile')
		public Alternatives getAlternatives_6_1_0() { return cAlternatives_6_1_0; }

		//qualifiers+='composes'
		public Assignment getQualifiersAssignment_6_1_0_0() { return cQualifiersAssignment_6_1_0_0; }

		//'composes'
		public Keyword getQualifiersComposesKeyword_6_1_0_0_0() { return cQualifiersComposesKeyword_6_1_0_0_0; }

		//qualifiers+='!composes'
		public Assignment getQualifiersAssignment_6_1_0_1() { return cQualifiersAssignment_6_1_0_1; }

		//'!composes'
		public Keyword getQualifiersComposesKeyword_6_1_0_1_0() { return cQualifiersComposesKeyword_6_1_0_1_0; }

		//qualifiers+='derived'
		public Assignment getQualifiersAssignment_6_1_0_2() { return cQualifiersAssignment_6_1_0_2; }

		//'derived'
		public Keyword getQualifiersDerivedKeyword_6_1_0_2_0() { return cQualifiersDerivedKeyword_6_1_0_2_0; }

		//qualifiers+='!derived'
		public Assignment getQualifiersAssignment_6_1_0_3() { return cQualifiersAssignment_6_1_0_3; }

		//'!derived'
		public Keyword getQualifiersDerivedKeyword_6_1_0_3_0() { return cQualifiersDerivedKeyword_6_1_0_3_0; }

		//qualifiers+='ordered'
		public Assignment getQualifiersAssignment_6_1_0_4() { return cQualifiersAssignment_6_1_0_4; }

		//'ordered'
		public Keyword getQualifiersOrderedKeyword_6_1_0_4_0() { return cQualifiersOrderedKeyword_6_1_0_4_0; }

		//qualifiers+='!ordered'
		public Assignment getQualifiersAssignment_6_1_0_5() { return cQualifiersAssignment_6_1_0_5; }

		//'!ordered'
		public Keyword getQualifiersOrderedKeyword_6_1_0_5_0() { return cQualifiersOrderedKeyword_6_1_0_5_0; }

		//qualifiers+='readonly'
		public Assignment getQualifiersAssignment_6_1_0_6() { return cQualifiersAssignment_6_1_0_6; }

		//'readonly'
		public Keyword getQualifiersReadonlyKeyword_6_1_0_6_0() { return cQualifiersReadonlyKeyword_6_1_0_6_0; }

		//qualifiers+='!readonly'
		public Assignment getQualifiersAssignment_6_1_0_7() { return cQualifiersAssignment_6_1_0_7; }

		//'!readonly'
		public Keyword getQualifiersReadonlyKeyword_6_1_0_7_0() { return cQualifiersReadonlyKeyword_6_1_0_7_0; }

		//qualifiers+='resolve'
		public Assignment getQualifiersAssignment_6_1_0_8() { return cQualifiersAssignment_6_1_0_8; }

		//'resolve'
		public Keyword getQualifiersResolveKeyword_6_1_0_8_0() { return cQualifiersResolveKeyword_6_1_0_8_0; }

		//qualifiers+='!resolve'
		public Assignment getQualifiersAssignment_6_1_0_9() { return cQualifiersAssignment_6_1_0_9; }

		//'!resolve'
		public Keyword getQualifiersResolveKeyword_6_1_0_9_0() { return cQualifiersResolveKeyword_6_1_0_9_0; }

		//qualifiers+='transient'
		public Assignment getQualifiersAssignment_6_1_0_10() { return cQualifiersAssignment_6_1_0_10; }

		//'transient'
		public Keyword getQualifiersTransientKeyword_6_1_0_10_0() { return cQualifiersTransientKeyword_6_1_0_10_0; }

		//qualifiers+='!transient'
		public Assignment getQualifiersAssignment_6_1_0_11() { return cQualifiersAssignment_6_1_0_11; }

		//'!transient'
		public Keyword getQualifiersTransientKeyword_6_1_0_11_0() { return cQualifiersTransientKeyword_6_1_0_11_0; }

		//qualifiers+='unique'
		public Assignment getQualifiersAssignment_6_1_0_12() { return cQualifiersAssignment_6_1_0_12; }

		//'unique'
		public Keyword getQualifiersUniqueKeyword_6_1_0_12_0() { return cQualifiersUniqueKeyword_6_1_0_12_0; }

		//qualifiers+='!unique'
		public Assignment getQualifiersAssignment_6_1_0_13() { return cQualifiersAssignment_6_1_0_13; }

		//'!unique'
		public Keyword getQualifiersUniqueKeyword_6_1_0_13_0() { return cQualifiersUniqueKeyword_6_1_0_13_0; }

		//qualifiers+='unsettable'
		public Assignment getQualifiersAssignment_6_1_0_14() { return cQualifiersAssignment_6_1_0_14; }

		//'unsettable'
		public Keyword getQualifiersUnsettableKeyword_6_1_0_14_0() { return cQualifiersUnsettableKeyword_6_1_0_14_0; }

		//qualifiers+='!unsettable'
		public Assignment getQualifiersAssignment_6_1_0_15() { return cQualifiersAssignment_6_1_0_15; }

		//'!unsettable'
		public Keyword getQualifiersUnsettableKeyword_6_1_0_15_0() { return cQualifiersUnsettableKeyword_6_1_0_15_0; }

		//qualifiers+='volatile'
		public Assignment getQualifiersAssignment_6_1_0_16() { return cQualifiersAssignment_6_1_0_16; }

		//'volatile'
		public Keyword getQualifiersVolatileKeyword_6_1_0_16_0() { return cQualifiersVolatileKeyword_6_1_0_16_0; }

		//qualifiers+='!volatile'
		public Assignment getQualifiersAssignment_6_1_0_17() { return cQualifiersAssignment_6_1_0_17; }

		//'!volatile'
		public Keyword getQualifiersVolatileKeyword_6_1_0_17_0() { return cQualifiersVolatileKeyword_6_1_0_17_0; }

		//','?
		public Keyword getCommaKeyword_6_1_1() { return cCommaKeyword_6_1_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_2() { return cRightCurlyBracketKeyword_6_2; }

		//('{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
		public Alternatives getAlternatives_7() { return cAlternatives_7; }

		//'{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')* '}'
		public Group getGroup_7_0() { return cGroup_7_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_7_0_0() { return cLeftCurlyBracketKeyword_7_0_0; }

		//('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' UnrestrictedName? ':'
		//ownedDefaultExpressions+=SpecificationCS? ';')*
		public Alternatives getAlternatives_7_0_1() { return cAlternatives_7_0_1; }

		/// *ownedAnnotations+=AnnotationElementCS
		//			| ('key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';')
		//	        |* / 'initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_7_0_1_0() { return cGroup_7_0_1_0; }

		//'initial'
		public Keyword getInitialKeyword_7_0_1_0_0() { return cInitialKeyword_7_0_1_0_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_7_0_1_0_1() { return cUnrestrictedNameParserRuleCall_7_0_1_0_1; }

		//':'
		public Keyword getColonKeyword_7_0_1_0_2() { return cColonKeyword_7_0_1_0_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_7_0_1_0_3() { return cOwnedDefaultExpressionsAssignment_7_0_1_0_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0; }

		//';'
		public Keyword getSemicolonKeyword_7_0_1_0_4() { return cSemicolonKeyword_7_0_1_0_4; }

		//'derivation' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';'
		public Group getGroup_7_0_1_1() { return cGroup_7_0_1_1; }

		//'derivation'
		public Keyword getDerivationKeyword_7_0_1_1_0() { return cDerivationKeyword_7_0_1_1_0; }

		//UnrestrictedName?
		public RuleCall getUnrestrictedNameParserRuleCall_7_0_1_1_1() { return cUnrestrictedNameParserRuleCall_7_0_1_1_1; }

		//':'
		public Keyword getColonKeyword_7_0_1_1_2() { return cColonKeyword_7_0_1_1_2; }

		//ownedDefaultExpressions+=SpecificationCS?
		public Assignment getOwnedDefaultExpressionsAssignment_7_0_1_1_3() { return cOwnedDefaultExpressionsAssignment_7_0_1_1_3; }

		//SpecificationCS
		public RuleCall getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0() { return cOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0; }

		//';'
		public Keyword getSemicolonKeyword_7_0_1_1_4() { return cSemicolonKeyword_7_0_1_1_4; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7_0_2() { return cRightCurlyBracketKeyword_7_0_2; }

		//';'
		public Keyword getSemicolonKeyword_7_1() { return cSemicolonKeyword_7_1; }
	}

	public class SpecificationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cOwnedExpressionAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_0_0 = (RuleCall)cOwnedExpressionAssignment_0.eContents().get(0);
		private final Assignment cExprStringAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cExprStringUNQUOTED_STRINGTerminalRuleCall_1_0 = (RuleCall)cExprStringAssignment_1.eContents().get(0);

		//SpecificationCS essentialocl::ExpSpecificationCS:
		//	ownedExpression=ExpCS | exprString=UNQUOTED_STRING
		@Override public ParserRule getRule() { return rule; }

		//ownedExpression=ExpCS | exprString=UNQUOTED_STRING
		public Alternatives getAlternatives() { return cAlternatives; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_0() { return cOwnedExpressionAssignment_0; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_0_0() { return cOwnedExpressionExpCSParserRuleCall_0_0; }

		//exprString=UNQUOTED_STRING
		public Assignment getExprStringAssignment_1() { return cExprStringAssignment_1; }

		//UNQUOTED_STRING
		public RuleCall getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0() { return cExprStringUNQUOTED_STRINGTerminalRuleCall_1_0; }
	}

	public class StructuredClassCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.StructuredClassCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsAbstractAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsAbstractAbstractKeyword_0_0 = (Keyword)cIsAbstractAssignment_0.eContents().get(0);
		private final Keyword cClassKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cOwnedSignatureAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0 = (RuleCall)cOwnedSignatureAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cExtendsKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedSuperTypesAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0 = (RuleCall)cOwnedSuperTypesAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cOwnedSuperTypesAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0 = (RuleCall)cOwnedSuperTypesAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cInstanceClassNameAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0 = (RuleCall)cInstanceClassNameAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cLeftCurlyBracketKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cIsInterfaceAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final Keyword cIsInterfaceInterfaceKeyword_6_1_0 = (Keyword)cIsInterfaceAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Group cGroup_7_0 = (Group)cAlternatives_7.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_7_0_0 = (Keyword)cGroup_7_0.eContents().get(0);
		private final Alternatives cAlternatives_7_0_1 = (Alternatives)cGroup_7_0.eContents().get(1);
		private final Assignment cOwnedOperationsAssignment_7_0_1_0 = (Assignment)cAlternatives_7_0_1.eContents().get(0);
		private final RuleCall cOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0 = (RuleCall)cOwnedOperationsAssignment_7_0_1_0.eContents().get(0);
		private final Assignment cOwnedPropertiesAssignment_7_0_1_1 = (Assignment)cAlternatives_7_0_1.eContents().get(1);
		private final RuleCall cOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0 = (RuleCall)cOwnedPropertiesAssignment_7_0_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7_0_2 = (Keyword)cGroup_7_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_7_1 = (Keyword)cAlternatives_7.eContents().get(1);

		//StructuredClassCS base::StructuredClassCS:
		//	isAbstract?='abstract'?
		//	'class' name=UnrestrictedName
		//	ownedSignature=TemplateSignatureCS? ('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? (':'
		//	instanceClassName=SINGLE_QUOTED_STRING)? ('{' isInterface?='interface'?
		//	'}')? ('{' (ownedOperations+=OperationCS
		//	| ownedProperties+=StructuralFeatureCS
		//	/ *| ownedConstraints+=InvariantConstraintCS* /)* '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//isAbstract?='abstract'? 'class' name=UnrestrictedName ownedSignature=TemplateSignatureCS? ('extends'
		//ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{'
		//isInterface?='interface'? '}')? ('{' (ownedOperations+=OperationCS | ownedProperties+=StructuralFeatureCS
		/// *| ownedConstraints+=InvariantConstraintCS* /)* '}' | ';')
		public Group getGroup() { return cGroup; }

		//isAbstract?='abstract'?
		public Assignment getIsAbstractAssignment_0() { return cIsAbstractAssignment_0; }

		//'abstract'
		public Keyword getIsAbstractAbstractKeyword_0_0() { return cIsAbstractAbstractKeyword_0_0; }

		//'class'
		public Keyword getClassKeyword_1() { return cClassKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//ownedSignature=TemplateSignatureCS?
		public Assignment getOwnedSignatureAssignment_3() { return cOwnedSignatureAssignment_3; }

		//TemplateSignatureCS
		public RuleCall getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0() { return cOwnedSignatureTemplateSignatureCSParserRuleCall_3_0; }

		//('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)?
		public Group getGroup_4() { return cGroup_4; }

		//'extends'
		public Keyword getExtendsKeyword_4_0() { return cExtendsKeyword_4_0; }

		//ownedSuperTypes+=TypedRefCS
		public Assignment getOwnedSuperTypesAssignment_4_1() { return cOwnedSuperTypesAssignment_4_1; }

		//TypedRefCS
		public RuleCall getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0() { return cOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0; }

		//(',' ownedSuperTypes+=TypedRefCS)*
		public Group getGroup_4_2() { return cGroup_4_2; }

		//','
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//ownedSuperTypes+=TypedRefCS
		public Assignment getOwnedSuperTypesAssignment_4_2_1() { return cOwnedSuperTypesAssignment_4_2_1; }

		//TypedRefCS
		public RuleCall getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0() { return cOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0; }

		//(':' instanceClassName=SINGLE_QUOTED_STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//':'
		public Keyword getColonKeyword_5_0() { return cColonKeyword_5_0; }

		//instanceClassName=SINGLE_QUOTED_STRING
		public Assignment getInstanceClassNameAssignment_5_1() { return cInstanceClassNameAssignment_5_1; }

		//SINGLE_QUOTED_STRING
		public RuleCall getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0() { return cInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0; }

		//('{' isInterface?='interface'? '}')?
		public Group getGroup_6() { return cGroup_6; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_0() { return cLeftCurlyBracketKeyword_6_0; }

		//isInterface?='interface'?
		public Assignment getIsInterfaceAssignment_6_1() { return cIsInterfaceAssignment_6_1; }

		//'interface'
		public Keyword getIsInterfaceInterfaceKeyword_6_1_0() { return cIsInterfaceInterfaceKeyword_6_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_2() { return cRightCurlyBracketKeyword_6_2; }

		//('{' (ownedOperations+=OperationCS | ownedProperties+=StructuralFeatureCS
		/// *| ownedConstraints+=InvariantConstraintCS* /)* '}' | ';')
		public Alternatives getAlternatives_7() { return cAlternatives_7; }

		//'{' (ownedOperations+=OperationCS | ownedProperties+=StructuralFeatureCS / *| ownedConstraints+=InvariantConstraintCS* /)*
		//'}'
		public Group getGroup_7_0() { return cGroup_7_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_7_0_0() { return cLeftCurlyBracketKeyword_7_0_0; }

		//(ownedOperations+=OperationCS | ownedProperties+=StructuralFeatureCS / *| ownedConstraints+=InvariantConstraintCS* /)*
		public Alternatives getAlternatives_7_0_1() { return cAlternatives_7_0_1; }

		/// *ownedAnnotations+=AnnotationElementCS
		//	        |* / ownedOperations+=OperationCS
		public Assignment getOwnedOperationsAssignment_7_0_1_0() { return cOwnedOperationsAssignment_7_0_1_0; }

		//OperationCS
		public RuleCall getOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0() { return cOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0; }

		//ownedProperties+=StructuralFeatureCS
		public Assignment getOwnedPropertiesAssignment_7_0_1_1() { return cOwnedPropertiesAssignment_7_0_1_1; }

		//StructuralFeatureCS
		public RuleCall getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0() { return cOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7_0_2() { return cRightCurlyBracketKeyword_7_0_2; }

		//';'
		public Keyword getSemicolonKeyword_7_1() { return cSemicolonKeyword_7_1; }
	}

	public class TypedMultiplicityRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTypedRefCSParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0 = (RuleCall)cOwnedMultiplicityAssignment_1.eContents().get(0);

		//TypedMultiplicityRefCS base::TypedRefCS:
		//	TypedRefCS ownedMultiplicity=MultiplicityCS?
		@Override public ParserRule getRule() { return rule; }

		//TypedRefCS ownedMultiplicity=MultiplicityCS?
		public Group getGroup() { return cGroup; }

		//TypedRefCS
		public RuleCall getTypedRefCSParserRuleCall_0() { return cTypedRefCSParserRuleCall_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_1() { return cOwnedMultiplicityAssignment_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_1_0; }
	}

	public class StructuralFeatureCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.StructuralFeatureCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAttributeCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReferenceCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//StructuralFeatureCS base::StructuralFeatureCS:
		//	AttributeCS | ReferenceCS
		@Override public ParserRule getRule() { return rule; }

		//AttributeCS | ReferenceCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//AttributeCS
		public RuleCall getAttributeCSParserRuleCall_0() { return cAttributeCSParserRuleCall_0; }

		//ReferenceCS
		public RuleCall getReferenceCSParserRuleCall_1() { return cReferenceCSParserRuleCall_1; }
	}

	public class EnumerationLiteralNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralName");
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall = (RuleCall)rule.eContents().get(1);

		//EnumerationLiteralName:
		//	EssentialOCLUnrestrictedName;
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall() { return cEssentialOCLUnrestrictedNameParserRuleCall; }
	}

	public class QVTbaseUnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.QVTbaseUnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAbstractKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAttributeKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cBodyKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cClassKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cComposesKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cDatatypeKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cDefinitionKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cDerivedKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cDerivationKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cEnumKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cExtendsKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cIdKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cInitialKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cInterfaceKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cLiteralKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cOperationKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cOrderedKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cPrimitiveKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cPropertyKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cReadonlyKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cResolveKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		private final Keyword cSerializableKeyword_21 = (Keyword)cAlternatives.eContents().get(21);
		private final Keyword cStaticKeyword_22 = (Keyword)cAlternatives.eContents().get(22);
		private final Keyword cThrowsKeyword_23 = (Keyword)cAlternatives.eContents().get(23);
		private final Keyword cTransientKeyword_24 = (Keyword)cAlternatives.eContents().get(24);
		private final Keyword cUniqueKeyword_25 = (Keyword)cAlternatives.eContents().get(25);
		private final Keyword cUnsettableKeyword_26 = (Keyword)cAlternatives.eContents().get(26);
		private final Keyword cVolatileKeyword_27 = (Keyword)cAlternatives.eContents().get(27);

		//QVTbaseUnrestrictedName:
		//	'abstract'
		//	| 'attribute'
		//	| 'body'
		//	| 'class'
		//	| 'composes'
		//	| 'datatype'
		//	| 'definition'
		//	| 'derived'
		//	| 'derivation'
		//	| 'enum'
		//	| 'extends'
		//	| 'id'
		//	| 'initial'
		//	| 'interface'
		//	| 'literal'
		//	| 'operation'
		//	| 'ordered'
		//	| 'primitive'
		//	| 'property'
		//	| 'readonly'
		//	| 'resolve'
		//	| 'serializable'
		//	| 'static'
		//	| 'throws'
		//	| 'transient'
		//	| 'unique'
		//	| 'unsettable'
		//	| 'volatile';
		@Override public ParserRule getRule() { return rule; }

		//'abstract' | 'attribute' | 'body' | 'class' | 'composes' | 'datatype' | 'definition' | 'derived' | 'derivation' | 'enum'
		//| 'extends' | 'id' | 'initial' | 'interface' | 'literal' | 'operation' | 'ordered' | 'primitive' | 'property' |
		//'readonly' | 'resolve' | 'serializable' | 'static' | 'throws' | 'transient' | 'unique' | 'unsettable' | 'volatile'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'abstract'
		public Keyword getAbstractKeyword_0() { return cAbstractKeyword_0; }

		//'attribute'
		public Keyword getAttributeKeyword_1() { return cAttributeKeyword_1; }

		//'body'
		public Keyword getBodyKeyword_2() { return cBodyKeyword_2; }

		//'class'
		public Keyword getClassKeyword_3() { return cClassKeyword_3; }

		//'composes'
		public Keyword getComposesKeyword_4() { return cComposesKeyword_4; }

		//'datatype'
		public Keyword getDatatypeKeyword_5() { return cDatatypeKeyword_5; }

		//'definition'
		public Keyword getDefinitionKeyword_6() { return cDefinitionKeyword_6; }

		//'derived'
		public Keyword getDerivedKeyword_7() { return cDerivedKeyword_7; }

		//'derivation'
		public Keyword getDerivationKeyword_8() { return cDerivationKeyword_8; }

		//'enum'
		public Keyword getEnumKeyword_9() { return cEnumKeyword_9; }

		//'extends'
		public Keyword getExtendsKeyword_10() { return cExtendsKeyword_10; }

		//'id'
		public Keyword getIdKeyword_11() { return cIdKeyword_11; }

		//'initial'
		public Keyword getInitialKeyword_12() { return cInitialKeyword_12; }

		//'interface'
		public Keyword getInterfaceKeyword_13() { return cInterfaceKeyword_13; }

		//'literal'
		public Keyword getLiteralKeyword_14() { return cLiteralKeyword_14; }

		//'operation'
		public Keyword getOperationKeyword_15() { return cOperationKeyword_15; }

		//'ordered'
		public Keyword getOrderedKeyword_16() { return cOrderedKeyword_16; }

		//'primitive'
		public Keyword getPrimitiveKeyword_17() { return cPrimitiveKeyword_17; }

		//'property'
		public Keyword getPropertyKeyword_18() { return cPropertyKeyword_18; }

		//'readonly'
		public Keyword getReadonlyKeyword_19() { return cReadonlyKeyword_19; }

		//'resolve'
		public Keyword getResolveKeyword_20() { return cResolveKeyword_20; }

		//'serializable'
		public Keyword getSerializableKeyword_21() { return cSerializableKeyword_21; }

		//'static'
		public Keyword getStaticKeyword_22() { return cStaticKeyword_22; }

		//'throws'
		public Keyword getThrowsKeyword_23() { return cThrowsKeyword_23; }

		//'transient'
		public Keyword getTransientKeyword_24() { return cTransientKeyword_24; }

		//'unique'
		public Keyword getUniqueKeyword_25() { return cUniqueKeyword_25; }

		//'unsettable'
		public Keyword getUnsettableKeyword_26() { return cUnsettableKeyword_26; }

		//'volatile'
		public Keyword getVolatileKeyword_27() { return cVolatileKeyword_27; }
	}

	public class SIGNEDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.SIGNED");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);

		/// *
		//|	'callable'
		//|	'import'
		//|	'key'
		//|	'library'
		//|	'module'
		//|	'package'
		//|	'postcondition'
		//|	'precondition'
		//|	'reference'
		// * / SIGNED ecore::EInt:
		//	'-'? INT
		@Override public ParserRule getRule() { return rule; }

		//'-'? INT
		public Group getGroup() { return cGroup; }

		//'-'?
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
	}


	private final AttributeCSElements pAttributeCS;
	private final ClassCSElements pClassCS;
	private final DataTypeCSElements pDataTypeCS;
	private final EnumerationCSElements pEnumerationCS;
	private final EnumerationLiteralCSElements pEnumerationLiteralCS;
	private final OperationCSElements pOperationCS;
	private final ParameterCSElements pParameterCS;
	private final ReferenceCSElements pReferenceCS;
	private final SpecificationCSElements pSpecificationCS;
	private final StructuredClassCSElements pStructuredClassCS;
	private final TypedMultiplicityRefCSElements pTypedMultiplicityRefCS;
	private final StructuralFeatureCSElements pStructuralFeatureCS;
	private final EnumerationLiteralNameElements pEnumerationLiteralName;
	private final QVTbaseUnrestrictedNameElements pQVTbaseUnrestrictedName;
	private final SIGNEDElements pSIGNED;
	private final TerminalRule tUNQUOTED_STRING;

	private final Grammar grammar;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	private final BaseGrammarAccess gaBase;

	@Inject
	public QVTbaseGrammarAccess(GrammarProvider grammarProvider,
		EssentialOCLGrammarAccess gaEssentialOCL,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaEssentialOCL = gaEssentialOCL;
		this.gaBase = gaBase;
		this.pAttributeCS = new AttributeCSElements();
		this.pClassCS = new ClassCSElements();
		this.pDataTypeCS = new DataTypeCSElements();
		this.pEnumerationCS = new EnumerationCSElements();
		this.pEnumerationLiteralCS = new EnumerationLiteralCSElements();
		this.pOperationCS = new OperationCSElements();
		this.pParameterCS = new ParameterCSElements();
		this.pReferenceCS = new ReferenceCSElements();
		this.pSpecificationCS = new SpecificationCSElements();
		this.pStructuredClassCS = new StructuredClassCSElements();
		this.pTypedMultiplicityRefCS = new TypedMultiplicityRefCSElements();
		this.pStructuralFeatureCS = new StructuralFeatureCSElements();
		this.pEnumerationLiteralName = new EnumerationLiteralNameElements();
		this.pQVTbaseUnrestrictedName = new QVTbaseUnrestrictedNameElements();
		this.pSIGNED = new SIGNEDElements();
		this.tUNQUOTED_STRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtbase.QVTbase.UNQUOTED_STRING");
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.qvtd.xtext.qvtbase.QVTbase".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}

	@Override
	public Grammar getGrammar() {
		return grammar;
	}


	public EssentialOCLGrammarAccess getEssentialOCLGrammarAccess() {
		return gaEssentialOCL;
	}

	public BaseGrammarAccess getBaseGrammarAccess() {
		return gaBase;
	}


	//AttributeCS base::AttributeCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
	//	'attribute' name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{'
	//	((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
	//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' |
	//	qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
	//	qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+
	//	'}')? ('{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation'
	//	UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
	public AttributeCSElements getAttributeCSAccess() {
		return pAttributeCS;
	}

	public ParserRule getAttributeCSRule() {
		return getAttributeCSAccess().getRule();
	}

	//ClassCS base::ClassCS:
	//	StructuredClassCS | DataTypeCS | EnumerationCS
	public ClassCSElements getClassCSAccess() {
		return pClassCS;
	}

	public ParserRule getClassCSRule() {
		return getClassCSAccess().getRule();
	}

	//DataTypeCS base::DataTypeCS:
	//	isPrimitive?='primitive'? 'datatype' name=UnrestrictedName
	//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable'
	//	| '!serializable')? '}')? ('{' / *(ownedAnnotations+=AnnotationElementCS
	//	        | ownedConstraints+=InvariantConstraintCS)* * / '}' | ';')
	public DataTypeCSElements getDataTypeCSAccess() {
		return pDataTypeCS;
	}

	public ParserRule getDataTypeCSRule() {
		return getDataTypeCSAccess().getRule();
	}

	//EnumerationCS base::EnumerationCS:
	//	'enum' name=UnrestrictedName
	//	ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable'
	//	| '!serializable')? '}')? ('{' ownedLiterals+=EnumerationLiteralCS
	//	/ *| ownedConstraints+=InvariantConstraintCS* / * '}' | ';')
	public EnumerationCSElements getEnumerationCSAccess() {
		return pEnumerationCS;
	}

	public ParserRule getEnumerationCSRule() {
		return getEnumerationCSAccess().getRule();
	}

	//EnumerationLiteralCS base::EnumerationLiteralCS:
	//	('literal' name=UnrestrictedName | name=EnumerationLiteralName) ('=' value=SIGNED)? ('{'
	//	/ *ownedAnnotations+=AnnotationElementCS* * / '}' | ';')
	public EnumerationLiteralCSElements getEnumerationLiteralCSAccess() {
		return pEnumerationLiteralCS;
	}

	public ParserRule getEnumerationLiteralCSRule() {
		return getEnumerationLiteralCSAccess().getRule();
	}

	//OperationCS base::OperationCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
	//	'operation' ownedSignature=TemplateSignatureCS? name=UnrestrictedName
	//	'(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)?
	//	('throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)? ('{' ((qualifiers+='derived' |
	//	qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' |
	//	qualifiers+='!unique') ','?)+
	//	'}')? ('{' ('body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';')* '}' | ';')
	public OperationCSElements getOperationCSAccess() {
		return pOperationCS;
	}

	public ParserRule getOperationCSRule() {
		return getOperationCSAccess().getRule();
	}

	//ParameterCS base::ParameterCS:
	//	name=UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('{' ((qualifiers+='ordered' | qualifiers+='!ordered' |
	//	qualifiers+='unique' | qualifiers+='!unique') ','?)+
	//	'}')? ('{' / *ownedAnnotations+=AnnotationElementCS* * / '}')?
	public ParameterCSElements getParameterCSAccess() {
		return pParameterCS;
	}

	public ParserRule getParameterCSRule() {
		return getParameterCSAccess().getRule();
	}

	//ReferenceCS base::ReferenceCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)?
	//	'property' name=UnrestrictedName ('#' referredOpposite=[pivot::Property|UnrestrictedName])? (':'
	//	ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' ((qualifiers+='composes' |
	//	qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' |
	//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' |
	//	qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' | qualifiers+='unique' |
	//	qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' | qualifiers+='volatile' |
	//	qualifiers+='!volatile') ','?)+
	//	'}')? ('{' ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation'
	//	UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
	public ReferenceCSElements getReferenceCSAccess() {
		return pReferenceCS;
	}

	public ParserRule getReferenceCSRule() {
		return getReferenceCSAccess().getRule();
	}

	//SpecificationCS essentialocl::ExpSpecificationCS:
	//	ownedExpression=ExpCS | exprString=UNQUOTED_STRING
	public SpecificationCSElements getSpecificationCSAccess() {
		return pSpecificationCS;
	}

	public ParserRule getSpecificationCSRule() {
		return getSpecificationCSAccess().getRule();
	}

	//StructuredClassCS base::StructuredClassCS:
	//	isAbstract?='abstract'?
	//	'class' name=UnrestrictedName
	//	ownedSignature=TemplateSignatureCS? ('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? (':'
	//	instanceClassName=SINGLE_QUOTED_STRING)? ('{' isInterface?='interface'?
	//	'}')? ('{' (ownedOperations+=OperationCS
	//	| ownedProperties+=StructuralFeatureCS
	//	/ *| ownedConstraints+=InvariantConstraintCS* /)* '}' | ';')
	public StructuredClassCSElements getStructuredClassCSAccess() {
		return pStructuredClassCS;
	}

	public ParserRule getStructuredClassCSRule() {
		return getStructuredClassCSAccess().getRule();
	}

	//TypedMultiplicityRefCS base::TypedRefCS:
	//	TypedRefCS ownedMultiplicity=MultiplicityCS?
	public TypedMultiplicityRefCSElements getTypedMultiplicityRefCSAccess() {
		return pTypedMultiplicityRefCS;
	}

	public ParserRule getTypedMultiplicityRefCSRule() {
		return getTypedMultiplicityRefCSAccess().getRule();
	}

	//StructuralFeatureCS base::StructuralFeatureCS:
	//	AttributeCS | ReferenceCS
	public StructuralFeatureCSElements getStructuralFeatureCSAccess() {
		return pStructuralFeatureCS;
	}

	public ParserRule getStructuralFeatureCSRule() {
		return getStructuralFeatureCSAccess().getRule();
	}

	//EnumerationLiteralName:
	//	EssentialOCLUnrestrictedName;
	public EnumerationLiteralNameElements getEnumerationLiteralNameAccess() {
		return pEnumerationLiteralName;
	}

	public ParserRule getEnumerationLiteralNameRule() {
		return getEnumerationLiteralNameAccess().getRule();
	}

	//QVTbaseUnrestrictedName:
	//	'abstract'
	//	| 'attribute'
	//	| 'body'
	//	| 'class'
	//	| 'composes'
	//	| 'datatype'
	//	| 'definition'
	//	| 'derived'
	//	| 'derivation'
	//	| 'enum'
	//	| 'extends'
	//	| 'id'
	//	| 'initial'
	//	| 'interface'
	//	| 'literal'
	//	| 'operation'
	//	| 'ordered'
	//	| 'primitive'
	//	| 'property'
	//	| 'readonly'
	//	| 'resolve'
	//	| 'serializable'
	//	| 'static'
	//	| 'throws'
	//	| 'transient'
	//	| 'unique'
	//	| 'unsettable'
	//	| 'volatile';
	public QVTbaseUnrestrictedNameElements getQVTbaseUnrestrictedNameAccess() {
		return pQVTbaseUnrestrictedName;
	}

	public ParserRule getQVTbaseUnrestrictedNameRule() {
		return getQVTbaseUnrestrictedNameAccess().getRule();
	}

	/// *
	//|	'callable'
	//|	'import'
	//|	'key'
	//|	'library'
	//|	'module'
	//|	'package'
	//|	'postcondition'
	//|	'precondition'
	//|	'reference'
	// * / SIGNED ecore::EInt:
	//	'-'? INT
	public SIGNEDElements getSIGNEDAccess() {
		return pSIGNED;
	}

	public ParserRule getSIGNEDRule() {
		return getSIGNEDAccess().getRule();
	}

	//terminal UNQUOTED_STRING: // Never forward parsed; just provides a placeholder
	//	'£$%^£$%^' //  for reverse serialisation of embedded OCL
	//;
	public TerminalRule getUNQUOTED_STRINGRule() {
		return tUNQUOTED_STRING;
	}

	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	//Model ContextCS:
	//	ownedExpression=ExpCS
	public EssentialOCLGrammarAccess.ModelElements getModelAccess() {
		return gaEssentialOCL.getModelAccess();
	}

	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLReservedKeyword:
	//	'and'
	//	| 'else'
	//	| 'endif'
	//	| 'if'
	//	| 'implies'
	//	| 'in'
	//	| 'let'
	//	| 'not'
	//	| 'or'
	//	| 'then'
	//	| 'xor';
	public EssentialOCLGrammarAccess.EssentialOCLReservedKeywordElements getEssentialOCLReservedKeywordAccess() {
		return gaEssentialOCL.getEssentialOCLReservedKeywordAccess();
	}

	public ParserRule getEssentialOCLReservedKeywordRule() {
		return getEssentialOCLReservedKeywordAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnaryOperatorName:
	//	'-' | 'not';
	public EssentialOCLGrammarAccess.EssentialOCLUnaryOperatorNameElements getEssentialOCLUnaryOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnaryOperatorNameAccess();
	}

	public ParserRule getEssentialOCLUnaryOperatorNameRule() {
		return getEssentialOCLUnaryOperatorNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLInfixOperatorName:
	//	'*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'or' | 'xor' | 'implies';
	public EssentialOCLGrammarAccess.EssentialOCLInfixOperatorNameElements getEssentialOCLInfixOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLInfixOperatorNameAccess();
	}

	public ParserRule getEssentialOCLInfixOperatorNameRule() {
		return getEssentialOCLInfixOperatorNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLNavigationOperatorName:
	//	'.' | '->' | '?.' | '?->';
	public EssentialOCLGrammarAccess.EssentialOCLNavigationOperatorNameElements getEssentialOCLNavigationOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLNavigationOperatorNameAccess();
	}

	public ParserRule getEssentialOCLNavigationOperatorNameRule() {
		return getEssentialOCLNavigationOperatorNameAccess().getRule();
	}

	//BinaryOperatorName:
	//	InfixOperatorName | NavigationOperatorName;
	public EssentialOCLGrammarAccess.BinaryOperatorNameElements getBinaryOperatorNameAccess() {
		return gaEssentialOCL.getBinaryOperatorNameAccess();
	}

	public ParserRule getBinaryOperatorNameRule() {
		return getBinaryOperatorNameAccess().getRule();
	}

	//InfixOperatorName:
	//	EssentialOCLInfixOperatorName;
	public EssentialOCLGrammarAccess.InfixOperatorNameElements getInfixOperatorNameAccess() {
		return gaEssentialOCL.getInfixOperatorNameAccess();
	}

	public ParserRule getInfixOperatorNameRule() {
		return getInfixOperatorNameAccess().getRule();
	}

	//NavigationOperatorName:
	//	EssentialOCLNavigationOperatorName;
	public EssentialOCLGrammarAccess.NavigationOperatorNameElements getNavigationOperatorNameAccess() {
		return gaEssentialOCL.getNavigationOperatorNameAccess();
	}

	public ParserRule getNavigationOperatorNameRule() {
		return getNavigationOperatorNameAccess().getRule();
	}

	//UnaryOperatorName:
	//	EssentialOCLUnaryOperatorName;
	public EssentialOCLGrammarAccess.UnaryOperatorNameElements getUnaryOperatorNameAccess() {
		return gaEssentialOCL.getUnaryOperatorNameAccess();
	}

	public ParserRule getUnaryOperatorNameRule() {
		return getUnaryOperatorNameAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Names
	////---------------------------------------------------------------------
	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnrestrictedName:
	//	Identifier;
	public EssentialOCLGrammarAccess.EssentialOCLUnrestrictedNameElements getEssentialOCLUnrestrictedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnrestrictedNameAccess();
	}

	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	//UnrestrictedName:
	//	EssentialOCLUnrestrictedName;
	public EssentialOCLGrammarAccess.UnrestrictedNameElements getUnrestrictedNameAccess() {
		return gaEssentialOCL.getUnrestrictedNameAccess();
	}

	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnreservedName:
	//	UnrestrictedName
	//	| CollectionTypeIdentifier
	//	| PrimitiveTypeIdentifier
	//	| 'Map'
	//	| 'Tuple';
	public EssentialOCLGrammarAccess.EssentialOCLUnreservedNameElements getEssentialOCLUnreservedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnreservedNameAccess();
	}

	public ParserRule getEssentialOCLUnreservedNameRule() {
		return getEssentialOCLUnreservedNameAccess().getRule();
	}

	//UnreservedName:
	//	EssentialOCLUnreservedName;
	public EssentialOCLGrammarAccess.UnreservedNameElements getUnreservedNameAccess() {
		return gaEssentialOCL.getUnreservedNameAccess();
	}

	public ParserRule getUnreservedNameRule() {
		return getUnreservedNameAccess().getRule();
	}

	//URIPathNameCS base::PathNameCS:
	//	ownedPathElements+=URIFirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*
	public EssentialOCLGrammarAccess.URIPathNameCSElements getURIPathNameCSAccess() {
		return gaEssentialOCL.getURIPathNameCSAccess();
	}

	public ParserRule getURIPathNameCSRule() {
		return getURIPathNameCSAccess().getRule();
	}

	//URIFirstPathElementCS base::PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS}
	//	referredElement=[pivot::Namespace|URI]
	public EssentialOCLGrammarAccess.URIFirstPathElementCSElements getURIFirstPathElementCSAccess() {
		return gaEssentialOCL.getURIFirstPathElementCSAccess();
	}

	public ParserRule getURIFirstPathElementCSRule() {
		return getURIFirstPathElementCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Types
	////---------------------------------------------------------------------
	//PrimitiveTypeIdentifier:
	//	'Boolean'
	//	| 'Integer'
	//	| 'Real'
	//	| 'String'
	//	| 'UnlimitedNatural'
	//	| 'OclAny'
	//	| 'OclInvalid'
	//	| 'OclVoid';
	public EssentialOCLGrammarAccess.PrimitiveTypeIdentifierElements getPrimitiveTypeIdentifierAccess() {
		return gaEssentialOCL.getPrimitiveTypeIdentifierAccess();
	}

	public ParserRule getPrimitiveTypeIdentifierRule() {
		return getPrimitiveTypeIdentifierAccess().getRule();
	}

	//PrimitiveTypeCS base::PrimitiveTypeRefCS:
	//	name=PrimitiveTypeIdentifier
	public EssentialOCLGrammarAccess.PrimitiveTypeCSElements getPrimitiveTypeCSAccess() {
		return gaEssentialOCL.getPrimitiveTypeCSAccess();
	}

	public ParserRule getPrimitiveTypeCSRule() {
		return getPrimitiveTypeCSAccess().getRule();
	}

	//CollectionTypeIdentifier:
	//	'Set'
	//	| 'Bag'
	//	| 'Sequence'
	//	| 'Collection'
	//	| 'OrderedSet';
	public EssentialOCLGrammarAccess.CollectionTypeIdentifierElements getCollectionTypeIdentifierAccess() {
		return gaEssentialOCL.getCollectionTypeIdentifierAccess();
	}

	public ParserRule getCollectionTypeIdentifierRule() {
		return getCollectionTypeIdentifierAccess().getRule();
	}

	//CollectionTypeCS:
	//	name=CollectionTypeIdentifier ('(' ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS?
	//	')')?;
	public EssentialOCLGrammarAccess.CollectionTypeCSElements getCollectionTypeCSAccess() {
		return gaEssentialOCL.getCollectionTypeCSAccess();
	}

	public ParserRule getCollectionTypeCSRule() {
		return getCollectionTypeCSAccess().getRule();
	}

	//MapTypeCS:
	//	name='Map' ('(' ownedKeyType=TypeExpCS ',' ownedValueType=TypeExpCS ')')?;
	public EssentialOCLGrammarAccess.MapTypeCSElements getMapTypeCSAccess() {
		return gaEssentialOCL.getMapTypeCSAccess();
	}

	public ParserRule getMapTypeCSRule() {
		return getMapTypeCSAccess().getRule();
	}

	//TupleTypeCS base::TupleTypeCS:
	//	name='Tuple' ('(' (ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)? ')')?
	public EssentialOCLGrammarAccess.TupleTypeCSElements getTupleTypeCSAccess() {
		return gaEssentialOCL.getTupleTypeCSAccess();
	}

	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	//TuplePartCS base::TuplePartCS:
	//	name=UnrestrictedName ':' ownedType=TypeExpCS
	public EssentialOCLGrammarAccess.TuplePartCSElements getTuplePartCSAccess() {
		return gaEssentialOCL.getTuplePartCSAccess();
	}

	public ParserRule getTuplePartCSRule() {
		return getTuplePartCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Literals
	////---------------------------------------------------------------------
	//CollectionLiteralExpCS:
	//	ownedType=CollectionTypeCS
	//	'{' (ownedParts+=CollectionLiteralPartCS (',' ownedParts+=CollectionLiteralPartCS)*)?
	//	'}';
	public EssentialOCLGrammarAccess.CollectionLiteralExpCSElements getCollectionLiteralExpCSAccess() {
		return gaEssentialOCL.getCollectionLiteralExpCSAccess();
	}

	public ParserRule getCollectionLiteralExpCSRule() {
		return getCollectionLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralPartCS:
	//	ownedExpression=ExpCS ('..' ownedLastExpression=ExpCS)? | ownedExpression=PatternExpCS;
	public EssentialOCLGrammarAccess.CollectionLiteralPartCSElements getCollectionLiteralPartCSAccess() {
		return gaEssentialOCL.getCollectionLiteralPartCSAccess();
	}

	public ParserRule getCollectionLiteralPartCSRule() {
		return getCollectionLiteralPartCSAccess().getRule();
	}

	//CollectionPatternCS:
	//	ownedType=CollectionTypeCS
	//	'{' (ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++' restVariableName=Identifier))?
	//	'}';
	public EssentialOCLGrammarAccess.CollectionPatternCSElements getCollectionPatternCSAccess() {
		return gaEssentialOCL.getCollectionPatternCSAccess();
	}

	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//ShadowPartCS:
	//	referredProperty=[pivot::Property|UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS) |
	//	ownedInitExpression=StringLiteralExpCS;
	public EssentialOCLGrammarAccess.ShadowPartCSElements getShadowPartCSAccess() {
		return gaEssentialOCL.getShadowPartCSAccess();
	}

	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//	patternVariableName=UnrestrictedName? ':' ownedPatternType=TypeExpCS;
	public EssentialOCLGrammarAccess.PatternExpCSElements getPatternExpCSAccess() {
		return gaEssentialOCL.getPatternExpCSAccess();
	}

	public ParserRule getPatternExpCSRule() {
		return getPatternExpCSAccess().getRule();
	}

	//LambdaLiteralExpCS:
	//	'Lambda' '{' ownedExpressionCS=ExpCS '}';
	public EssentialOCLGrammarAccess.LambdaLiteralExpCSElements getLambdaLiteralExpCSAccess() {
		return gaEssentialOCL.getLambdaLiteralExpCSAccess();
	}

	public ParserRule getLambdaLiteralExpCSRule() {
		return getLambdaLiteralExpCSAccess().getRule();
	}

	//MapLiteralExpCS:
	//	ownedType=MapTypeCS '{' (ownedParts+=MapLiteralPartCS (',' ownedParts+=MapLiteralPartCS)*)? '}';
	public EssentialOCLGrammarAccess.MapLiteralExpCSElements getMapLiteralExpCSAccess() {
		return gaEssentialOCL.getMapLiteralExpCSAccess();
	}

	public ParserRule getMapLiteralExpCSRule() {
		return getMapLiteralExpCSAccess().getRule();
	}

	//MapLiteralPartCS:
	//	ownedKey=ExpCS '<-' ownedValue=ExpCS;
	public EssentialOCLGrammarAccess.MapLiteralPartCSElements getMapLiteralPartCSAccess() {
		return gaEssentialOCL.getMapLiteralPartCSAccess();
	}

	public ParserRule getMapLiteralPartCSRule() {
		return getMapLiteralPartCSAccess().getRule();
	}

	//PrimitiveLiteralExpCS:
	//	NumberLiteralExpCS
	//	| StringLiteralExpCS
	//	| BooleanLiteralExpCS
	//	| UnlimitedNaturalLiteralExpCS
	//	| InvalidLiteralExpCS
	//	| NullLiteralExpCS;
	public EssentialOCLGrammarAccess.PrimitiveLiteralExpCSElements getPrimitiveLiteralExpCSAccess() {
		return gaEssentialOCL.getPrimitiveLiteralExpCSAccess();
	}

	public ParserRule getPrimitiveLiteralExpCSRule() {
		return getPrimitiveLiteralExpCSAccess().getRule();
	}

	//TupleLiteralExpCS:
	//	'Tuple' '{' ownedParts+=TupleLiteralPartCS (',' ownedParts+=TupleLiteralPartCS)* '}';
	public EssentialOCLGrammarAccess.TupleLiteralExpCSElements getTupleLiteralExpCSAccess() {
		return gaEssentialOCL.getTupleLiteralExpCSAccess();
	}

	public ParserRule getTupleLiteralExpCSRule() {
		return getTupleLiteralExpCSAccess().getRule();
	}

	//TupleLiteralPartCS:
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.TupleLiteralPartCSElements getTupleLiteralPartCSAccess() {
		return gaEssentialOCL.getTupleLiteralPartCSAccess();
	}

	public ParserRule getTupleLiteralPartCSRule() {
		return getTupleLiteralPartCSAccess().getRule();
	}

	//NumberLiteralExpCS:
	//	symbol=NUMBER_LITERAL;
	public EssentialOCLGrammarAccess.NumberLiteralExpCSElements getNumberLiteralExpCSAccess() {
		return gaEssentialOCL.getNumberLiteralExpCSAccess();
	}

	public ParserRule getNumberLiteralExpCSRule() {
		return getNumberLiteralExpCSAccess().getRule();
	}

	//StringLiteralExpCS:
	//	segments+=StringLiteral+;
	public EssentialOCLGrammarAccess.StringLiteralExpCSElements getStringLiteralExpCSAccess() {
		return gaEssentialOCL.getStringLiteralExpCSAccess();
	}

	public ParserRule getStringLiteralExpCSRule() {
		return getStringLiteralExpCSAccess().getRule();
	}

	//BooleanLiteralExpCS:
	//	symbol='true'
	//	| symbol='false';
	public EssentialOCLGrammarAccess.BooleanLiteralExpCSElements getBooleanLiteralExpCSAccess() {
		return gaEssentialOCL.getBooleanLiteralExpCSAccess();
	}

	public ParserRule getBooleanLiteralExpCSRule() {
		return getBooleanLiteralExpCSAccess().getRule();
	}

	//UnlimitedNaturalLiteralExpCS:
	//	{UnlimitedNaturalLiteralExpCS} '*';
	public EssentialOCLGrammarAccess.UnlimitedNaturalLiteralExpCSElements getUnlimitedNaturalLiteralExpCSAccess() {
		return gaEssentialOCL.getUnlimitedNaturalLiteralExpCSAccess();
	}

	public ParserRule getUnlimitedNaturalLiteralExpCSRule() {
		return getUnlimitedNaturalLiteralExpCSAccess().getRule();
	}

	//InvalidLiteralExpCS:
	//	{InvalidLiteralExpCS} 'invalid';
	public EssentialOCLGrammarAccess.InvalidLiteralExpCSElements getInvalidLiteralExpCSAccess() {
		return gaEssentialOCL.getInvalidLiteralExpCSAccess();
	}

	public ParserRule getInvalidLiteralExpCSRule() {
		return getInvalidLiteralExpCSAccess().getRule();
	}

	//NullLiteralExpCS:
	//	{NullLiteralExpCS} 'null';
	public EssentialOCLGrammarAccess.NullLiteralExpCSElements getNullLiteralExpCSAccess() {
		return gaEssentialOCL.getNullLiteralExpCSAccess();
	}

	public ParserRule getNullLiteralExpCSRule() {
		return getNullLiteralExpCSAccess().getRule();
	}

	//TypeLiteralCS base::TypedRefCS:
	//	PrimitiveTypeCS
	//	| CollectionTypeCS
	//	| MapTypeCS
	//	| TupleTypeCS
	public EssentialOCLGrammarAccess.TypeLiteralCSElements getTypeLiteralCSAccess() {
		return gaEssentialOCL.getTypeLiteralCSAccess();
	}

	public ParserRule getTypeLiteralCSRule() {
		return getTypeLiteralCSAccess().getRule();
	}

	//TypeLiteralWithMultiplicityCS base::TypedRefCS:
	//	TypeLiteralCS ownedMultiplicity=MultiplicityCS?
	public EssentialOCLGrammarAccess.TypeLiteralWithMultiplicityCSElements getTypeLiteralWithMultiplicityCSAccess() {
		return gaEssentialOCL.getTypeLiteralWithMultiplicityCSAccess();
	}

	public ParserRule getTypeLiteralWithMultiplicityCSRule() {
		return getTypeLiteralWithMultiplicityCSAccess().getRule();
	}

	//TypeLiteralExpCS:
	//	ownedType=TypeLiteralWithMultiplicityCS;
	public EssentialOCLGrammarAccess.TypeLiteralExpCSElements getTypeLiteralExpCSAccess() {
		return gaEssentialOCL.getTypeLiteralExpCSAccess();
	}

	public ParserRule getTypeLiteralExpCSRule() {
		return getTypeLiteralExpCSAccess().getRule();
	}

	//TypeNameExpCS:
	//	ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' ownedPatternGuard=ExpCS '}')?)?;
	public EssentialOCLGrammarAccess.TypeNameExpCSElements getTypeNameExpCSAccess() {
		return gaEssentialOCL.getTypeNameExpCSAccess();
	}

	public ParserRule getTypeNameExpCSRule() {
		return getTypeNameExpCSAccess().getRule();
	}

	//TypeExpWithoutMultiplicityCS base::TypedRefCS:
	//	TypeNameExpCS | TypeLiteralCS | CollectionPatternCS
	public EssentialOCLGrammarAccess.TypeExpWithoutMultiplicityCSElements getTypeExpWithoutMultiplicityCSAccess() {
		return gaEssentialOCL.getTypeExpWithoutMultiplicityCSAccess();
	}

	public ParserRule getTypeExpWithoutMultiplicityCSRule() {
		return getTypeExpWithoutMultiplicityCSAccess().getRule();
	}

	//TypeExpCS base::TypedRefCS:
	//	TypeExpWithoutMultiplicityCS ownedMultiplicity=MultiplicityCS?
	public EssentialOCLGrammarAccess.TypeExpCSElements getTypeExpCSAccess() {
		return gaEssentialOCL.getTypeExpCSAccess();
	}

	public ParserRule getTypeExpCSRule() {
		return getTypeExpCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Expressions
	////---------------------------------------------------------------------
	//// An ExpCS permits a LetExpCS only in the final term to ensure
	////  that let is right associative, whereas infix operators are left associative.
	////   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4
	//// is
	////   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
	/// * An expression elaborates a prefixed expression with zero or more binary operator and expression suffixes.
	// * An optionally prefixed let expression is permitted except when suffixed with further expressions.* / ExpCS:
	//	PrefixedPrimaryExpCS ({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)? | PrefixedLetExpCS;
	public EssentialOCLGrammarAccess.ExpCSElements getExpCSAccess() {
		return gaEssentialOCL.getExpCSAccess();
	}

	public ParserRule getExpCSRule() {
		return getExpCSAccess().getRule();
	}

	/// * A prefixed let expression elaborates a let expression with zero or more unary prefix operators. * / PrefixedLetExpCS
	//ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS | LetExpCS
	public EssentialOCLGrammarAccess.PrefixedLetExpCSElements getPrefixedLetExpCSAccess() {
		return gaEssentialOCL.getPrefixedLetExpCSAccess();
	}

	public ParserRule getPrefixedLetExpCSRule() {
		return getPrefixedLetExpCSAccess().getRule();
	}

	/// * A prefixed primary expression elaborates a primary expression with zero or more unary prefix operators. * /
	//PrefixedPrimaryExpCS ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS | PrimaryExpCS
	public EssentialOCLGrammarAccess.PrefixedPrimaryExpCSElements getPrefixedPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrefixedPrimaryExpCSAccess();
	}

	public ParserRule getPrefixedPrimaryExpCSRule() {
		return getPrefixedPrimaryExpCSAccess().getRule();
	}

	/// * A primary expression identifies the basic expressions from which more complex expressions may be constructed. * /
	//PrimaryExpCS ExpCS:
	//	NestedExpCS
	//	| IfExpCS
	//	| SelfExpCS
	//	| PrimitiveLiteralExpCS
	//	| TupleLiteralExpCS
	//	| MapLiteralExpCS
	//	| CollectionLiteralExpCS
	//	| LambdaLiteralExpCS
	//	| TypeLiteralExpCS
	//	| NameExpCS
	public EssentialOCLGrammarAccess.PrimaryExpCSElements getPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrimaryExpCSAccess();
	}

	public ParserRule getPrimaryExpCSRule() {
		return getPrimaryExpCSAccess().getRule();
	}

	/// * A name expression is a generalised rule for expressions that start with a name and which may be followed by square, round or
	// * curly bracket clauses and optionally an @pre as well.* / NameExpCS:
	//	ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS*
	//	ownedRoundBracketedClause=RoundBracketedClauseCS? ownedCurlyBracketedClause=CurlyBracketedClauseCS? (isPre?='@'
	//	'pre')?;
	public EssentialOCLGrammarAccess.NameExpCSElements getNameExpCSAccess() {
		return gaEssentialOCL.getNameExpCSAccess();
	}

	public ParserRule getNameExpCSRule() {
		return getNameExpCSAccess().getRule();
	}

	/// * A curly bracket clause is a generalized rule for the literal arguments of collections, maps, tuples and shadows.* /
	//CurlyBracketedClauseCS:
	//	{CurlyBracketedClauseCS} '{' (ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*)? '}';
	public EssentialOCLGrammarAccess.CurlyBracketedClauseCSElements getCurlyBracketedClauseCSAccess() {
		return gaEssentialOCL.getCurlyBracketedClauseCSAccess();
	}

	public ParserRule getCurlyBracketedClauseCSRule() {
		return getCurlyBracketedClauseCSAccess().getRule();
	}

	/// * A curly bracket clause is a generalized rule for template specialisations and operations arguments.* /
	//RoundBracketedClauseCS:
	//	{RoundBracketedClauseCS} '(' (ownedArguments+=NavigatingArgCS ownedArguments+=NavigatingCommaArgCS*
	//	(ownedArguments+=NavigatingSemiArgCS ownedArguments+=NavigatingCommaArgCS*)? (ownedArguments+=NavigatingBarArgCS
	//	ownedArguments+=NavigatingCommaArgCS*)*)? ')';
	public EssentialOCLGrammarAccess.RoundBracketedClauseCSElements getRoundBracketedClauseCSAccess() {
		return gaEssentialOCL.getRoundBracketedClauseCSAccess();
	}

	public ParserRule getRoundBracketedClauseCSRule() {
		return getRoundBracketedClauseCSAccess().getRule();
	}

	/// * A square bracket clause is a generalized rule for association class qualifiers and roles.* / SquareBracketedClauseCS:
	//	'[' ownedTerms+=ExpCS (',' ownedTerms+=ExpCS)* ']';
	public EssentialOCLGrammarAccess.SquareBracketedClauseCSElements getSquareBracketedClauseCSAccess() {
		return gaEssentialOCL.getSquareBracketedClauseCSAccess();
	}

	public ParserRule getSquareBracketedClauseCSRule() {
		return getSquareBracketedClauseCSAccess().getRule();
	}

	/// * A navigating argument is a generalized rule for the first argument in a round bracket clause. This is typically the first operation
	// * parameter or an iterator. * / NavigatingArgCS:
	//	ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)? | 'in'
	//	ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS;
	public EssentialOCLGrammarAccess.NavigatingArgCSElements getNavigatingArgCSAccess() {
		return gaEssentialOCL.getNavigatingArgCSAccess();
	}

	public ParserRule getNavigatingArgCSRule() {
		return getNavigatingArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	/// * A navigating bar argument is a generalized rule for a bar-prefixed argument in a round bracket clause. This is typically the body of an iteration. * /
	//NavigatingBarArgCS NavigatingArgCS:
	//	prefix='|' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
	public EssentialOCLGrammarAccess.NavigatingBarArgCSElements getNavigatingBarArgCSAccess() {
		return gaEssentialOCL.getNavigatingBarArgCSAccess();
	}

	public ParserRule getNavigatingBarArgCSRule() {
		return getNavigatingBarArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	/// * A navigating comma argument is a generalized rule for non-first argument in a round bracket clause. These are typically non-first operation
	// * parameters or a second iterator. * / NavigatingCommaArgCS NavigatingArgCS:
	//	prefix=',' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)? | 'in'
	//	ownedInitExpression=ExpCS)?
	public EssentialOCLGrammarAccess.NavigatingCommaArgCSElements getNavigatingCommaArgCSAccess() {
		return gaEssentialOCL.getNavigatingCommaArgCSAccess();
	}

	public ParserRule getNavigatingCommaArgCSRule() {
		return getNavigatingCommaArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	/// * A navigating semi argument is a generalized rule for a semicolon prefixed argument in a round bracket clause. This is typically an iterate accumulator. * /
	//NavigatingSemiArgCS NavigatingArgCS:
	//	prefix=';' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?
	public EssentialOCLGrammarAccess.NavigatingSemiArgCSElements getNavigatingSemiArgCSAccess() {
		return gaEssentialOCL.getNavigatingSemiArgCSAccess();
	}

	public ParserRule getNavigatingSemiArgCSRule() {
		return getNavigatingSemiArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//NavigatingArgExpCS ExpCS:
	//	ExpCS
	public EssentialOCLGrammarAccess.NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return gaEssentialOCL.getNavigatingArgExpCSAccess();
	}

	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//IfExpCS:
	//	'if' ownedCondition=(ExpCS | PatternExpCS)
	//	'then' ownedThenExpression=ExpCS
	//	//	ifThenExpressions+=IfThenExpCS
	//	ownedIfThenExpressions+=ElseIfThenExpCS*
	//	'else' ownedElseExpression=ExpCS
	//	'endif';
	public EssentialOCLGrammarAccess.IfExpCSElements getIfExpCSAccess() {
		return gaEssentialOCL.getIfExpCSAccess();
	}

	public ParserRule getIfExpCSRule() {
		return getIfExpCSAccess().getRule();
	}

	////IfThenExpCS returns IfThenExpCS:
	////	'if' condition=ExpCS
	////	'then' thenExpression=ExpCS
	////;
	//ElseIfThenExpCS IfThenExpCS:
	//	'elseif' ownedCondition=ExpCS
	//	'then' ownedThenExpression=ExpCS
	public EssentialOCLGrammarAccess.ElseIfThenExpCSElements getElseIfThenExpCSAccess() {
		return gaEssentialOCL.getElseIfThenExpCSAccess();
	}

	public ParserRule getElseIfThenExpCSRule() {
		return getElseIfThenExpCSAccess().getRule();
	}

	//LetExpCS:
	//	'let' ownedVariables+=LetVariableCS (',' ownedVariables+=LetVariableCS)*
	//	'in' ownedInExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetExpCSElements getLetExpCSAccess() {
		return gaEssentialOCL.getLetExpCSAccess();
	}

	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS:
	//	name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '='
	//	ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetVariableCSElements getLetVariableCSAccess() {
		return gaEssentialOCL.getLetVariableCSAccess();
	}

	public ParserRule getLetVariableCSRule() {
		return getLetVariableCSAccess().getRule();
	}

	//NestedExpCS:
	//	'(' ownedExpression=ExpCS ')';
	public EssentialOCLGrammarAccess.NestedExpCSElements getNestedExpCSAccess() {
		return gaEssentialOCL.getNestedExpCSAccess();
	}

	public ParserRule getNestedExpCSRule() {
		return getNestedExpCSAccess().getRule();
	}

	//SelfExpCS:
	//	{SelfExpCS} 'self';
	public EssentialOCLGrammarAccess.SelfExpCSElements getSelfExpCSAccess() {
		return gaEssentialOCL.getSelfExpCSAccess();
	}

	public ParserRule getSelfExpCSRule() {
		return getSelfExpCSAccess().getRule();
	}

	//MultiplicityBoundsCS:
	//	lowerBound=LOWER ('..' upperBound=UPPER)?;
	public BaseGrammarAccess.MultiplicityBoundsCSElements getMultiplicityBoundsCSAccess() {
		return gaBase.getMultiplicityBoundsCSAccess();
	}

	public ParserRule getMultiplicityBoundsCSRule() {
		return getMultiplicityBoundsCSAccess().getRule();
	}

	//MultiplicityCS:
	//	'[' (MultiplicityBoundsCS | MultiplicityStringCS) ('|?' | isNullFree?='|1')? ']';
	public BaseGrammarAccess.MultiplicityCSElements getMultiplicityCSAccess() {
		return gaBase.getMultiplicityCSAccess();
	}

	public ParserRule getMultiplicityCSRule() {
		return getMultiplicityCSAccess().getRule();
	}

	//MultiplicityStringCS:
	//	stringBounds=('*' | '+' | '?');
	public BaseGrammarAccess.MultiplicityStringCSElements getMultiplicityStringCSAccess() {
		return gaBase.getMultiplicityStringCSAccess();
	}

	public ParserRule getMultiplicityStringCSRule() {
		return getMultiplicityStringCSAccess().getRule();
	}

	//PathNameCS:
	//	ownedPathElements+=FirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public BaseGrammarAccess.PathNameCSElements getPathNameCSAccess() {
		return gaBase.getPathNameCSAccess();
	}

	public ParserRule getPathNameCSRule() {
		return getPathNameCSAccess().getRule();
	}

	//FirstPathElementCS PathElementCS:
	//	referredElement=[pivot::NamedElement|super::UnrestrictedName]
	public BaseGrammarAccess.FirstPathElementCSElements getFirstPathElementCSAccess() {
		return gaBase.getFirstPathElementCSAccess();
	}

	public ParserRule getFirstPathElementCSRule() {
		return getFirstPathElementCSAccess().getRule();
	}

	//NextPathElementCS PathElementCS:
	//	referredElement=[pivot::NamedElement|super::UnreservedName]
	public BaseGrammarAccess.NextPathElementCSElements getNextPathElementCSAccess() {
		return gaBase.getNextPathElementCSAccess();
	}

	public ParserRule getNextPathElementCSRule() {
		return getNextPathElementCSAccess().getRule();
	}

	//TemplateBindingCS:
	//	ownedSubstitutions+=TemplateParameterSubstitutionCS (',' ownedSubstitutions+=TemplateParameterSubstitutionCS)*
	//	ownedMultiplicity=MultiplicityCS?;
	public BaseGrammarAccess.TemplateBindingCSElements getTemplateBindingCSAccess() {
		return gaBase.getTemplateBindingCSAccess();
	}

	public ParserRule getTemplateBindingCSRule() {
		return getTemplateBindingCSAccess().getRule();
	}

	//TemplateParameterSubstitutionCS:
	//	ownedActualParameter=TypeRefCS;
	public BaseGrammarAccess.TemplateParameterSubstitutionCSElements getTemplateParameterSubstitutionCSAccess() {
		return gaBase.getTemplateParameterSubstitutionCSAccess();
	}

	public ParserRule getTemplateParameterSubstitutionCSRule() {
		return getTemplateParameterSubstitutionCSAccess().getRule();
	}

	//TemplateSignatureCS:
	//	'(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')';
	public BaseGrammarAccess.TemplateSignatureCSElements getTemplateSignatureCSAccess() {
		return gaBase.getTemplateSignatureCSAccess();
	}

	public ParserRule getTemplateSignatureCSRule() {
		return getTemplateSignatureCSAccess().getRule();
	}

	//TypeParameterCS:
	//	name=super::UnrestrictedName ('extends' ownedExtends+=TypedRefCS ('&&' ownedExtends+=TypedRefCS)*)?;
	public BaseGrammarAccess.TypeParameterCSElements getTypeParameterCSAccess() {
		return gaBase.getTypeParameterCSAccess();
	}

	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS:
	//	TypedRefCS | WildcardTypeRefCS;
	public BaseGrammarAccess.TypeRefCSElements getTypeRefCSAccess() {
		return gaBase.getTypeRefCSAccess();
	}

	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//TypedRefCS:
	//	TypedTypeRefCS;
	public BaseGrammarAccess.TypedRefCSElements getTypedRefCSAccess() {
		return gaBase.getTypedRefCSAccess();
	}

	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//TypedTypeRefCS:
	//	ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')')?;
	public BaseGrammarAccess.TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return gaBase.getTypedTypeRefCSAccess();
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//WildcardTypeRefCS:
	//	{WildcardTypeRefCS} '?' ('extends' ownedExtends=TypedRefCS)?;
	public BaseGrammarAccess.WildcardTypeRefCSElements getWildcardTypeRefCSAccess() {
		return gaBase.getWildcardTypeRefCSAccess();
	}

	public ParserRule getWildcardTypeRefCSRule() {
		return getWildcardTypeRefCSAccess().getRule();
	}

	//ID:
	//	SIMPLE_ID | ESCAPED_ID;
	public BaseGrammarAccess.IDElements getIDAccess() {
		return gaBase.getIDAccess();
	}

	public ParserRule getIDRule() {
		return getIDAccess().getRule();
	}

	//Identifier:
	//	ID;
	public BaseGrammarAccess.IdentifierElements getIdentifierAccess() {
		return gaBase.getIdentifierAccess();
	}

	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}

	/// * A lowerbounded integer is used to define the lowerbound of a collection multiplicity. The value may not be the unlimited value. * /
	//LOWER ecore::EInt:
	//	INT
	public BaseGrammarAccess.LOWERElements getLOWERAccess() {
		return gaBase.getLOWERAccess();
	}

	public ParserRule getLOWERRule() {
		return getLOWERAccess().getRule();
	}

	/// * A number may be an integer or floating point value. The declaration here appears to be that for just an integer. This is to avoid
	// * lookahead conflicts in simple lexers between a dot within a floating point number and the dot-dot in a CollectionLiteralPartCS. A
	// * practical implementation should give high priority to a successful parse of INT ('.' INT)? (('e' | 'E') ('+' | '-')? INT)? than
	// * to the unsuccessful partial parse of INT '..'. The type of the INT terminal is String to allow the floating point syntax to be used.
	// * / NUMBER_LITERAL BigNumber:
	//	INT
	public BaseGrammarAccess.NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return gaBase.getNUMBER_LITERALAccess();
	}

	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//// EssentialOCLTokenSource pieces this together ('.' INT)? (('e' | 'E') ('+' | '-')? INT)?;
	//StringLiteral:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.StringLiteralElements getStringLiteralAccess() {
		return gaBase.getStringLiteralAccess();
	}

	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}

	/// * An upperbounded integer is used to define the upperbound of a collection multiplicity. The value may be the unlimited value. * /
	//UPPER ecore::EInt:
	//	INT | '*'
	public BaseGrammarAccess.UPPERElements getUPPERAccess() {
		return gaBase.getUPPERAccess();
	}

	public ParserRule getUPPERRule() {
		return getUPPERAccess().getRule();
	}

	//URI:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.URIElements getURIAccess() {
		return gaBase.getURIAccess();
	}

	public ParserRule getURIRule() {
		return getURIAccess().getRule();
	}

	//terminal fragment ESCAPED_CHARACTER:
	//	'\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\');
	public TerminalRule getESCAPED_CHARACTERRule() {
		return gaBase.getESCAPED_CHARACTERRule();
	}

	//terminal fragment LETTER_CHARACTER:
	//	'a'..'z' | 'A'..'Z' | '_';
	public TerminalRule getLETTER_CHARACTERRule() {
		return gaBase.getLETTER_CHARACTERRule();
	}

	//terminal DOUBLE_QUOTED_STRING:
	//	'"' (ESCAPED_CHARACTER | !('\\' | '"'))* '"';
	public TerminalRule getDOUBLE_QUOTED_STRINGRule() {
		return gaBase.getDOUBLE_QUOTED_STRINGRule();
	}

	//terminal SINGLE_QUOTED_STRING:
	//	"'" (ESCAPED_CHARACTER | !('\\' | "'"))* "'";
	public TerminalRule getSINGLE_QUOTED_STRINGRule() {
		return gaBase.getSINGLE_QUOTED_STRINGRule();
	}

	//terminal ML_SINGLE_QUOTED_STRING:
	//	"/'"->"'/";
	public TerminalRule getML_SINGLE_QUOTED_STRINGRule() {
		return gaBase.getML_SINGLE_QUOTED_STRINGRule();
	}

	//terminal SIMPLE_ID:
	//	LETTER_CHARACTER (LETTER_CHARACTER | '0'..'9')*;
	public TerminalRule getSIMPLE_IDRule() {
		return gaBase.getSIMPLE_IDRule();
	}

	//terminal ESCAPED_ID:
	//	"_" SINGLE_QUOTED_STRING;
	public TerminalRule getESCAPED_IDRule() {
		return gaBase.getESCAPED_IDRule();
	}

	//terminal INT:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaBase.getINTRule();
	}

	//terminal ML_COMMENT:
	//	'/ *'->'* /';
	public TerminalRule getML_COMMENTRule() {
		return gaBase.getML_COMMENTRule();
	}

	//terminal SL_COMMENT:
	//	'--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaBase.getSL_COMMENTRule();
	}

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaBase.getWSRule();
	}

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaBase.getANY_OTHERRule();
	}
}
