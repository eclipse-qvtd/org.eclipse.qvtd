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
package org.eclipse.qvtd.xtext.qvtimperative.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class QVTimperativeGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class TopLevelCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TopLevelCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedImportsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedImportsImportCSParserRuleCall_0_0 = (RuleCall)cOwnedImportsAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cOwnedTransformationsAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cOwnedTransformationsTransformationCSParserRuleCall_1_0_0 = (RuleCall)cOwnedTransformationsAssignment_1_0.eContents().get(0);
		private final Assignment cOwnedMappingsAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cOwnedMappingsMappingCSParserRuleCall_1_1_0 = (RuleCall)cOwnedMappingsAssignment_1_1.eContents().get(0);
		private final Assignment cOwnedQueriesAssignment_1_2 = (Assignment)cAlternatives_1.eContents().get(2);
		private final RuleCall cOwnedQueriesQueryCSParserRuleCall_1_2_0 = (RuleCall)cOwnedQueriesAssignment_1_2.eContents().get(0);
		
		//TopLevelCS:
		//	ownedImports+=ImportCS* (ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedImports+=ImportCS* (ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*
		public Group getGroup() { return cGroup; }

		//ownedImports+=ImportCS*
		public Assignment getOwnedImportsAssignment_0() { return cOwnedImportsAssignment_0; }

		//ImportCS
		public RuleCall getOwnedImportsImportCSParserRuleCall_0_0() { return cOwnedImportsImportCSParserRuleCall_0_0; }

		//(ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//ownedTransformations+=TransformationCS
		public Assignment getOwnedTransformationsAssignment_1_0() { return cOwnedTransformationsAssignment_1_0; }

		//TransformationCS
		public RuleCall getOwnedTransformationsTransformationCSParserRuleCall_1_0_0() { return cOwnedTransformationsTransformationCSParserRuleCall_1_0_0; }

		//ownedMappings+=MappingCS
		public Assignment getOwnedMappingsAssignment_1_1() { return cOwnedMappingsAssignment_1_1; }

		//MappingCS
		public RuleCall getOwnedMappingsMappingCSParserRuleCall_1_1_0() { return cOwnedMappingsMappingCSParserRuleCall_1_1_0; }

		//ownedQueries+=QueryCS
		public Assignment getOwnedQueriesAssignment_1_2() { return cOwnedQueriesAssignment_1_2; }

		//QueryCS
		public RuleCall getOwnedQueriesQueryCSParserRuleCall_1_2_0() { return cOwnedQueriesQueryCSParserRuleCall_1_2_0; }
	}

	public class DirectionCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DirectionCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDirectionCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cImportsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cImportsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cImportsPackageCrossReference_2_1_0 = (CrossReference)cImportsAssignment_2_1.eContents().get(0);
		private final RuleCall cImportsPackageUnrestrictedNameParserRuleCall_2_1_0_1 = (RuleCall)cImportsPackageCrossReference_2_1_0.eContents().get(1);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cImportsAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final CrossReference cImportsPackageCrossReference_2_2_1_0 = (CrossReference)cImportsAssignment_2_2_1.eContents().get(0);
		private final RuleCall cImportsPackageUnrestrictedNameParserRuleCall_2_2_1_0_1 = (RuleCall)cImportsPackageCrossReference_2_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cUsesKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cUsesAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cUsesCoreDomainCrossReference_3_1_0 = (CrossReference)cUsesAssignment_3_1.eContents().get(0);
		private final RuleCall cUsesCoreDomainUnrestrictedNameParserRuleCall_3_1_0_1 = (RuleCall)cUsesCoreDomainCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cUsesAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final CrossReference cUsesCoreDomainCrossReference_3_2_1_0 = (CrossReference)cUsesAssignment_3_2_1.eContents().get(0);
		private final RuleCall cUsesCoreDomainUnrestrictedNameParserRuleCall_3_2_1_0_1 = (RuleCall)cUsesCoreDomainCrossReference_3_2_1_0.eContents().get(1);
		
		//DirectionCS returns qvtcorebasecs::DirectionCS:
		//	{qvtcorebasecs::DirectionCS} name=UnrestrictedName ("imports" imports+=[pivot::Package|UnrestrictedName] (","
		//	imports+=[pivot::Package|UnrestrictedName])*)? ("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] (","
		//	uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?;
		@Override public ParserRule getRule() { return rule; }

		//{qvtcorebasecs::DirectionCS} name=UnrestrictedName ("imports" imports+=[pivot::Package|UnrestrictedName] (","
		//imports+=[pivot::Package|UnrestrictedName])*)? ("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] (","
		//uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?
		public Group getGroup() { return cGroup; }

		//{qvtcorebasecs::DirectionCS}
		public Action getDirectionCSAction_0() { return cDirectionCSAction_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//("imports" imports+=[pivot::Package|UnrestrictedName] ("," imports+=[pivot::Package|UnrestrictedName])*)?
		public Group getGroup_2() { return cGroup_2; }

		//"imports"
		public Keyword getImportsKeyword_2_0() { return cImportsKeyword_2_0; }

		//imports+=[pivot::Package|UnrestrictedName]
		public Assignment getImportsAssignment_2_1() { return cImportsAssignment_2_1; }

		//[pivot::Package|UnrestrictedName]
		public CrossReference getImportsPackageCrossReference_2_1_0() { return cImportsPackageCrossReference_2_1_0; }

		//UnrestrictedName
		public RuleCall getImportsPackageUnrestrictedNameParserRuleCall_2_1_0_1() { return cImportsPackageUnrestrictedNameParserRuleCall_2_1_0_1; }

		//("," imports+=[pivot::Package|UnrestrictedName])*
		public Group getGroup_2_2() { return cGroup_2_2; }

		//","
		public Keyword getCommaKeyword_2_2_0() { return cCommaKeyword_2_2_0; }

		//imports+=[pivot::Package|UnrestrictedName]
		public Assignment getImportsAssignment_2_2_1() { return cImportsAssignment_2_2_1; }

		//[pivot::Package|UnrestrictedName]
		public CrossReference getImportsPackageCrossReference_2_2_1_0() { return cImportsPackageCrossReference_2_2_1_0; }

		//UnrestrictedName
		public RuleCall getImportsPackageUnrestrictedNameParserRuleCall_2_2_1_0_1() { return cImportsPackageUnrestrictedNameParserRuleCall_2_2_1_0_1; }

		//("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] ("," uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?
		public Group getGroup_3() { return cGroup_3; }

		//"uses"
		public Keyword getUsesKeyword_3_0() { return cUsesKeyword_3_0; }

		//uses+=[qvtcorebase::CoreDomain|UnrestrictedName]
		public Assignment getUsesAssignment_3_1() { return cUsesAssignment_3_1; }

		//[qvtcorebase::CoreDomain|UnrestrictedName]
		public CrossReference getUsesCoreDomainCrossReference_3_1_0() { return cUsesCoreDomainCrossReference_3_1_0; }

		//UnrestrictedName
		public RuleCall getUsesCoreDomainUnrestrictedNameParserRuleCall_3_1_0_1() { return cUsesCoreDomainUnrestrictedNameParserRuleCall_3_1_0_1; }

		//("," uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*
		public Group getGroup_3_2() { return cGroup_3_2; }

		//","
		public Keyword getCommaKeyword_3_2_0() { return cCommaKeyword_3_2_0; }

		//uses+=[qvtcorebase::CoreDomain|UnrestrictedName]
		public Assignment getUsesAssignment_3_2_1() { return cUsesAssignment_3_2_1; }

		//[qvtcorebase::CoreDomain|UnrestrictedName]
		public CrossReference getUsesCoreDomainCrossReference_3_2_1_0() { return cUsesCoreDomainCrossReference_3_2_1_0; }

		//UnrestrictedName
		public RuleCall getUsesCoreDomainUnrestrictedNameParserRuleCall_3_2_1_0_1() { return cUsesCoreDomainUnrestrictedNameParserRuleCall_3_2_1_0_1; }
	}

	public class MappingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMappingCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cIsDefaultAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsDefaultDefaultKeyword_1_0 = (Keyword)cIsDefaultAssignment_1.eContents().get(0);
		private final Keyword cMapKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cInKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedInPathNameAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedInPathNamePathNameCSParserRuleCall_4_1_0 = (RuleCall)cOwnedInPathNameAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cUsesKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cOwnedUsesPathNamesAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOwnedUsesPathNamesPathNameCSParserRuleCall_5_1_0 = (RuleCall)cOwnedUsesPathNamesAssignment_5_1.eContents().get(0);
		private final Group cGroup_5_2 = (Group)cGroup_5.eContents().get(2);
		private final Keyword cCommaKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cOwnedUsesPathNamesAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final RuleCall cOwnedUsesPathNamesPathNameCSParserRuleCall_5_2_1_0 = (RuleCall)cOwnedUsesPathNamesAssignment_5_2_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cOwnedDomainsAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final Alternatives cOwnedDomainsAlternatives_7_0 = (Alternatives)cOwnedDomainsAssignment_7.eContents().get(0);
		private final RuleCall cOwnedDomainsSourceDomainCSParserRuleCall_7_0_0 = (RuleCall)cOwnedDomainsAlternatives_7_0.eContents().get(0);
		private final RuleCall cOwnedDomainsTargetDomainCSParserRuleCall_7_0_1 = (RuleCall)cOwnedDomainsAlternatives_7_0.eContents().get(1);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cWhereKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cOwnedMiddleAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cOwnedMiddleMiddleDomainCSParserRuleCall_8_1_0 = (RuleCall)cOwnedMiddleAssignment_8_1.eContents().get(0);
		private final Assignment cOwnedMappingSequenceAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cOwnedMappingSequenceMappingSequenceCSParserRuleCall_9_0 = (RuleCall)cOwnedMappingSequenceAssignment_9.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);
		
		//MappingCS:
		//	{MappingCS} isDefault?="default"? "map" name=UnrestrictedName ("in" ownedInPathName=PathNameCS)? ("uses"
		//	ownedUsesPathNames+=PathNameCS ("," ownedUsesPathNames+=PathNameCS)*)? "{" ownedDomains+=(SourceDomainCS |
		//	TargetDomainCS)* ("where" ownedMiddle=MiddleDomainCS)? ownedMappingSequence=MappingSequenceCS? "}";
		@Override public ParserRule getRule() { return rule; }

		//{MappingCS} isDefault?="default"? "map" name=UnrestrictedName ("in" ownedInPathName=PathNameCS)? ("uses"
		//ownedUsesPathNames+=PathNameCS ("," ownedUsesPathNames+=PathNameCS)*)? "{" ownedDomains+=(SourceDomainCS |
		//TargetDomainCS)* ("where" ownedMiddle=MiddleDomainCS)? ownedMappingSequence=MappingSequenceCS? "}"
		public Group getGroup() { return cGroup; }

		//{MappingCS}
		public Action getMappingCSAction_0() { return cMappingCSAction_0; }

		//isDefault?="default"?
		public Assignment getIsDefaultAssignment_1() { return cIsDefaultAssignment_1; }

		//"default"
		public Keyword getIsDefaultDefaultKeyword_1_0() { return cIsDefaultDefaultKeyword_1_0; }

		//"map"
		public Keyword getMapKeyword_2() { return cMapKeyword_2; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

		//("in" ownedInPathName=PathNameCS)?
		public Group getGroup_4() { return cGroup_4; }

		//"in"
		public Keyword getInKeyword_4_0() { return cInKeyword_4_0; }

		//ownedInPathName=PathNameCS
		public Assignment getOwnedInPathNameAssignment_4_1() { return cOwnedInPathNameAssignment_4_1; }

		//PathNameCS
		public RuleCall getOwnedInPathNamePathNameCSParserRuleCall_4_1_0() { return cOwnedInPathNamePathNameCSParserRuleCall_4_1_0; }

		//("uses" ownedUsesPathNames+=PathNameCS ("," ownedUsesPathNames+=PathNameCS)*)?
		public Group getGroup_5() { return cGroup_5; }

		//"uses"
		public Keyword getUsesKeyword_5_0() { return cUsesKeyword_5_0; }

		//ownedUsesPathNames+=PathNameCS
		public Assignment getOwnedUsesPathNamesAssignment_5_1() { return cOwnedUsesPathNamesAssignment_5_1; }

		//PathNameCS
		public RuleCall getOwnedUsesPathNamesPathNameCSParserRuleCall_5_1_0() { return cOwnedUsesPathNamesPathNameCSParserRuleCall_5_1_0; }

		//("," ownedUsesPathNames+=PathNameCS)*
		public Group getGroup_5_2() { return cGroup_5_2; }

		//","
		public Keyword getCommaKeyword_5_2_0() { return cCommaKeyword_5_2_0; }

		//ownedUsesPathNames+=PathNameCS
		public Assignment getOwnedUsesPathNamesAssignment_5_2_1() { return cOwnedUsesPathNamesAssignment_5_2_1; }

		//PathNameCS
		public RuleCall getOwnedUsesPathNamesPathNameCSParserRuleCall_5_2_1_0() { return cOwnedUsesPathNamesPathNameCSParserRuleCall_5_2_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }

		//ownedDomains+=(SourceDomainCS | TargetDomainCS)*
		public Assignment getOwnedDomainsAssignment_7() { return cOwnedDomainsAssignment_7; }

		//SourceDomainCS | TargetDomainCS
		public Alternatives getOwnedDomainsAlternatives_7_0() { return cOwnedDomainsAlternatives_7_0; }

		//SourceDomainCS
		public RuleCall getOwnedDomainsSourceDomainCSParserRuleCall_7_0_0() { return cOwnedDomainsSourceDomainCSParserRuleCall_7_0_0; }

		//TargetDomainCS
		public RuleCall getOwnedDomainsTargetDomainCSParserRuleCall_7_0_1() { return cOwnedDomainsTargetDomainCSParserRuleCall_7_0_1; }

		//("where" ownedMiddle=MiddleDomainCS)?
		public Group getGroup_8() { return cGroup_8; }

		//"where"
		public Keyword getWhereKeyword_8_0() { return cWhereKeyword_8_0; }

		//ownedMiddle=MiddleDomainCS
		public Assignment getOwnedMiddleAssignment_8_1() { return cOwnedMiddleAssignment_8_1; }

		//MiddleDomainCS
		public RuleCall getOwnedMiddleMiddleDomainCSParserRuleCall_8_1_0() { return cOwnedMiddleMiddleDomainCSParserRuleCall_8_1_0; }

		//ownedMappingSequence=MappingSequenceCS?
		public Assignment getOwnedMappingSequenceAssignment_9() { return cOwnedMappingSequenceAssignment_9; }

		//MappingSequenceCS
		public RuleCall getOwnedMappingSequenceMappingSequenceCSParserRuleCall_9_0() { return cOwnedMappingSequenceMappingSequenceCSParserRuleCall_9_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}

	public class MappingCallCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingCallCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMappingCallCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cIsInfiniteAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsInfiniteInfiniteKeyword_1_0 = (Keyword)cIsInfiniteAssignment_1.eContents().get(0);
		private final Keyword cCallKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedPathNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_3_0 = (RuleCall)cOwnedPathNameAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedBindingsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedBindingsMappingCallBindingCSParserRuleCall_5_0 = (RuleCall)cOwnedBindingsAssignment_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//MappingCallCS:
		//	{MappingCallCS} isInfinite?="infinite"? "call" ownedPathName=PathNameCS "{" ownedBindings+=MappingCallBindingCS* "}";
		@Override public ParserRule getRule() { return rule; }

		//{MappingCallCS} isInfinite?="infinite"? "call" ownedPathName=PathNameCS "{" ownedBindings+=MappingCallBindingCS* "}"
		public Group getGroup() { return cGroup; }

		//{MappingCallCS}
		public Action getMappingCallCSAction_0() { return cMappingCallCSAction_0; }

		//isInfinite?="infinite"?
		public Assignment getIsInfiniteAssignment_1() { return cIsInfiniteAssignment_1; }

		//"infinite"
		public Keyword getIsInfiniteInfiniteKeyword_1_0() { return cIsInfiniteInfiniteKeyword_1_0; }

		//"call"
		public Keyword getCallKeyword_2() { return cCallKeyword_2; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_3() { return cOwnedPathNameAssignment_3; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_3_0() { return cOwnedPathNamePathNameCSParserRuleCall_3_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//ownedBindings+=MappingCallBindingCS*
		public Assignment getOwnedBindingsAssignment_5() { return cOwnedBindingsAssignment_5; }

		//MappingCallBindingCS
		public RuleCall getOwnedBindingsMappingCallBindingCSParserRuleCall_5_0() { return cOwnedBindingsMappingCallBindingCSParserRuleCall_5_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class MappingCallBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingCallBindingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cReferredVariableAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cReferredVariableVariableCrossReference_0_0 = (CrossReference)cReferredVariableAssignment_0.eContents().get(0);
		private final RuleCall cReferredVariableVariableUnrestrictedNameParserRuleCall_0_0_1 = (RuleCall)cReferredVariableVariableCrossReference_0_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cColonEqualsSignKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cIsPolledAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cIsPolledQuestionMarkEqualsSignKeyword_1_1_0 = (Keyword)cIsPolledAssignment_1_1.eContents().get(0);
		private final Assignment cOwnedValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedValueExpCSParserRuleCall_2_0 = (RuleCall)cOwnedValueAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//MappingCallBindingCS:
		//	referredVariable=[pivot::Variable|UnrestrictedName] (":=" | isPolled?="?=") ownedValue=ExpCS ";";
		@Override public ParserRule getRule() { return rule; }

		//referredVariable=[pivot::Variable|UnrestrictedName] (":=" | isPolled?="?=") ownedValue=ExpCS ";"
		public Group getGroup() { return cGroup; }

		//referredVariable=[pivot::Variable|UnrestrictedName]
		public Assignment getReferredVariableAssignment_0() { return cReferredVariableAssignment_0; }

		//[pivot::Variable|UnrestrictedName]
		public CrossReference getReferredVariableVariableCrossReference_0_0() { return cReferredVariableVariableCrossReference_0_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableVariableUnrestrictedNameParserRuleCall_0_0_1() { return cReferredVariableVariableUnrestrictedNameParserRuleCall_0_0_1; }

		//":=" | isPolled?="?="
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//":="
		public Keyword getColonEqualsSignKeyword_1_0() { return cColonEqualsSignKeyword_1_0; }

		//isPolled?="?="
		public Assignment getIsPolledAssignment_1_1() { return cIsPolledAssignment_1_1; }

		//"?="
		public Keyword getIsPolledQuestionMarkEqualsSignKeyword_1_1_0() { return cIsPolledQuestionMarkEqualsSignKeyword_1_1_0; }

		//ownedValue=ExpCS
		public Assignment getOwnedValueAssignment_2() { return cOwnedValueAssignment_2; }

		//ExpCS
		public RuleCall getOwnedValueExpCSParserRuleCall_2_0() { return cOwnedValueExpCSParserRuleCall_2_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class MappingLoopCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingLoopCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cForKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedIteratorAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedIteratorMappingIteratorCSParserRuleCall_1_0 = (RuleCall)cOwnedIteratorAssignment_1.eContents().get(0);
		private final Keyword cInKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedInExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedInExpressionExpCSParserRuleCall_3_0 = (RuleCall)cOwnedInExpressionAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedMappingSequenceAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedMappingSequenceMappingSequenceCSParserRuleCall_5_0 = (RuleCall)cOwnedMappingSequenceAssignment_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//MappingLoopCS:
		//	"for" ownedIterator=MappingIteratorCS "in" ownedInExpression=ExpCS "{" ownedMappingSequence=MappingSequenceCS "}";
		@Override public ParserRule getRule() { return rule; }

		//"for" ownedIterator=MappingIteratorCS "in" ownedInExpression=ExpCS "{" ownedMappingSequence=MappingSequenceCS "}"
		public Group getGroup() { return cGroup; }

		//"for"
		public Keyword getForKeyword_0() { return cForKeyword_0; }

		//ownedIterator=MappingIteratorCS
		public Assignment getOwnedIteratorAssignment_1() { return cOwnedIteratorAssignment_1; }

		//MappingIteratorCS
		public RuleCall getOwnedIteratorMappingIteratorCSParserRuleCall_1_0() { return cOwnedIteratorMappingIteratorCSParserRuleCall_1_0; }

		//"in"
		public Keyword getInKeyword_2() { return cInKeyword_2; }

		//ownedInExpression=ExpCS
		public Assignment getOwnedInExpressionAssignment_3() { return cOwnedInExpressionAssignment_3; }

		//ExpCS
		public RuleCall getOwnedInExpressionExpCSParserRuleCall_3_0() { return cOwnedInExpressionExpCSParserRuleCall_3_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//ownedMappingSequence=MappingSequenceCS
		public Assignment getOwnedMappingSequenceAssignment_5() { return cOwnedMappingSequenceAssignment_5; }

		//MappingSequenceCS
		public RuleCall getOwnedMappingSequenceMappingSequenceCSParserRuleCall_5_0() { return cOwnedMappingSequenceMappingSequenceCSParserRuleCall_5_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class MappingIteratorCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingIteratorCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);
		
		//MappingIteratorCS returns essentialocl::VariableCS:
		//	name=UnrestrictedName (":" ownedType=TypeExpCS)?;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (":" ownedType=TypeExpCS)?
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//(":" ownedType=TypeExpCS)?
		public Group getGroup_1() { return cGroup_1; }

		//":"
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_1_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_1_1_0; }
	}

	public class MappingSequenceCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingSequenceCS");
		private final Assignment cOwnedMappingStatementsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedMappingStatementsMappingStatementCSParserRuleCall_0 = (RuleCall)cOwnedMappingStatementsAssignment.eContents().get(0);
		
		//MappingSequenceCS:
		//	ownedMappingStatements+=MappingStatementCS+;
		@Override public ParserRule getRule() { return rule; }

		//ownedMappingStatements+=MappingStatementCS+
		public Assignment getOwnedMappingStatementsAssignment() { return cOwnedMappingStatementsAssignment; }

		//MappingStatementCS
		public RuleCall getOwnedMappingStatementsMappingStatementCSParserRuleCall_0() { return cOwnedMappingStatementsMappingStatementCSParserRuleCall_0; }
	}

	public class MappingStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MappingStatementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cMappingCallCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cMappingLoopCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//MappingStatementCS:
		//	MappingCallCS | MappingLoopCS;
		@Override public ParserRule getRule() { return rule; }

		//MappingCallCS | MappingLoopCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//MappingCallCS
		public RuleCall getMappingCallCSParserRuleCall_0() { return cMappingCallCSParserRuleCall_0; }

		//MappingLoopCS
		public RuleCall getMappingLoopCSParserRuleCall_1() { return cMappingLoopCSParserRuleCall_1; }
	}

	public class ImperativePredicateOrAssignmentCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ImperativePredicateOrAssignmentCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsDefaultAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsDefaultDefaultKeyword_0_0 = (Keyword)cIsDefaultAssignment_0.eContents().get(0);
		private final Assignment cOwnedTargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedTargetExpCSParserRuleCall_1_0 = (RuleCall)cOwnedTargetAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_2_0 = (Alternatives)cGroup_2.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_2_0_0 = (Keyword)cAlternatives_2_0.eContents().get(0);
		private final Assignment cIsAccumulateAssignment_2_0_1 = (Assignment)cAlternatives_2_0.eContents().get(1);
		private final Keyword cIsAccumulatePlusSignEqualsSignKeyword_2_0_1_0 = (Keyword)cIsAccumulateAssignment_2_0_1.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ImperativePredicateOrAssignmentCS:
		//	isDefault?="default"? ownedTarget=ExpCS ((":=" | isAccumulate?="+=") ownedInitExpression=ExpCS)? ";";
		@Override public ParserRule getRule() { return rule; }

		//isDefault?="default"? ownedTarget=ExpCS ((":=" | isAccumulate?="+=") ownedInitExpression=ExpCS)? ";"
		public Group getGroup() { return cGroup; }

		//isDefault?="default"?
		public Assignment getIsDefaultAssignment_0() { return cIsDefaultAssignment_0; }

		//"default"
		public Keyword getIsDefaultDefaultKeyword_0_0() { return cIsDefaultDefaultKeyword_0_0; }

		//ownedTarget=ExpCS
		public Assignment getOwnedTargetAssignment_1() { return cOwnedTargetAssignment_1; }

		//ExpCS
		public RuleCall getOwnedTargetExpCSParserRuleCall_1_0() { return cOwnedTargetExpCSParserRuleCall_1_0; }

		//((":=" | isAccumulate?="+=") ownedInitExpression=ExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//":=" | isAccumulate?="+="
		public Alternatives getAlternatives_2_0() { return cAlternatives_2_0; }

		//":="
		public Keyword getColonEqualsSignKeyword_2_0_0() { return cColonEqualsSignKeyword_2_0_0; }

		//isAccumulate?="+="
		public Assignment getIsAccumulateAssignment_2_0_1() { return cIsAccumulateAssignment_2_0_1; }

		//"+="
		public Keyword getIsAccumulatePlusSignEqualsSignKeyword_2_0_1_0() { return cIsAccumulatePlusSignEqualsSignKeyword_2_0_1_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_1() { return cOwnedInitExpressionAssignment_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_1_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class SourceDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SourceDomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsCheckAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsCheckCheckKeyword_0_0 = (Keyword)cIsCheckAssignment_0.eContents().get(0);
		private final Assignment cDirectionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cDirectionTypedModelCrossReference_1_0 = (CrossReference)cDirectionAssignment_1.eContents().get(0);
		private final RuleCall cDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1 = (RuleCall)cDirectionTypedModelCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCheckKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cCheckedPropertiesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0 = (RuleCall)cCheckedPropertiesAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_2_1_2 = (Group)cGroup_2_1.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_2_0 = (Keyword)cGroup_2_1_2.eContents().get(0);
		private final Assignment cCheckedPropertiesAssignment_2_1_2_1 = (Assignment)cGroup_2_1_2.eContents().get(1);
		private final RuleCall cCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0 = (RuleCall)cCheckedPropertiesAssignment_2_1_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cEnforceKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cEnforcedPropertiesAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0 = (RuleCall)cEnforcedPropertiesAssignment_2_2_1.eContents().get(0);
		private final Group cGroup_2_2_2 = (Group)cGroup_2_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_2_0 = (Keyword)cGroup_2_2_2.eContents().get(0);
		private final Assignment cEnforcedPropertiesAssignment_2_2_2_1 = (Assignment)cGroup_2_2_2.eContents().get(1);
		private final RuleCall cEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0 = (RuleCall)cEnforcedPropertiesAssignment_2_2_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		private final Assignment cOwnedGuardPatternAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedGuardPatternSourceGuardPatternCSParserRuleCall_3_0 = (RuleCall)cOwnedGuardPatternAssignment_3.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedBottomPatternSourceBottomPatternCSParserRuleCall_4_0 = (RuleCall)cOwnedBottomPatternAssignment_4.eContents().get(0);
		
		//SourceDomainCS returns ImperativeDomainCS:
		//	isCheck?="check" direction=[qvtbase::TypedModel|UnrestrictedName] ("{" ("check" checkedProperties+=PathNameCS (","
		//	checkedProperties+=PathNameCS)*)? ("enforce" enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)?
		//	"}")? ownedGuardPattern=SourceGuardPatternCS ownedBottomPattern=SourceBottomPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//isCheck?="check" direction=[qvtbase::TypedModel|UnrestrictedName] ("{" ("check" checkedProperties+=PathNameCS (","
		//checkedProperties+=PathNameCS)*)? ("enforce" enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)?
		//"}")? ownedGuardPattern=SourceGuardPatternCS ownedBottomPattern=SourceBottomPatternCS
		public Group getGroup() { return cGroup; }

		//isCheck?="check"
		public Assignment getIsCheckAssignment_0() { return cIsCheckAssignment_0; }

		//"check"
		public Keyword getIsCheckCheckKeyword_0_0() { return cIsCheckCheckKeyword_0_0; }

		//direction=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getDirectionAssignment_1() { return cDirectionAssignment_1; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getDirectionTypedModelCrossReference_1_0() { return cDirectionTypedModelCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1() { return cDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1; }

		//("{" ("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)? ("enforce"
		//enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)? "}")?
		public Group getGroup_2() { return cGroup_2; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//"check"
		public Keyword getCheckKeyword_2_1_0() { return cCheckKeyword_2_1_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_1() { return cCheckedPropertiesAssignment_2_1_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0; }

		//("," checkedProperties+=PathNameCS)*
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//","
		public Keyword getCommaKeyword_2_1_2_0() { return cCommaKeyword_2_1_2_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_2_1() { return cCheckedPropertiesAssignment_2_1_2_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0; }

		//("enforce" enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)?
		public Group getGroup_2_2() { return cGroup_2_2; }

		//"enforce"
		public Keyword getEnforceKeyword_2_2_0() { return cEnforceKeyword_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_1() { return cEnforcedPropertiesAssignment_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0; }

		//("," enforcedProperties+=PathNameCS)*
		public Group getGroup_2_2_2() { return cGroup_2_2_2; }

		//","
		public Keyword getCommaKeyword_2_2_2_0() { return cCommaKeyword_2_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_2_1() { return cEnforcedPropertiesAssignment_2_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2_3() { return cRightCurlyBracketKeyword_2_3; }

		//ownedGuardPattern=SourceGuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_3() { return cOwnedGuardPatternAssignment_3; }

		//SourceGuardPatternCS
		public RuleCall getOwnedGuardPatternSourceGuardPatternCSParserRuleCall_3_0() { return cOwnedGuardPatternSourceGuardPatternCSParserRuleCall_3_0; }

		//ownedBottomPattern=SourceBottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_4() { return cOwnedBottomPatternAssignment_4; }

		//SourceBottomPatternCS
		public RuleCall getOwnedBottomPatternSourceBottomPatternCSParserRuleCall_4_0() { return cOwnedBottomPatternSourceBottomPatternCSParserRuleCall_4_0; }
	}

	public class SourceBottomPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SourceBottomPatternCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBottomPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//SourceBottomPatternCS returns qvtcorebasecs::BottomPatternCS:
		//	{qvtcorebasecs::BottomPatternCS} "{" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//	ownedUnrealizedVariables+=UnrealizedVariableCS)*)? "}";
		@Override public ParserRule getRule() { return rule; }

		//{qvtcorebasecs::BottomPatternCS} "{" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//ownedUnrealizedVariables+=UnrealizedVariableCS)*)? "}"
		public Group getGroup() { return cGroup; }

		//{qvtcorebasecs::BottomPatternCS}
		public Action getBottomPatternCSAction_0() { return cBottomPatternCSAction_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_0() { return cOwnedUnrealizedVariablesAssignment_2_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0; }

		//("," ownedUnrealizedVariables+=UnrealizedVariableCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_1_1() { return cOwnedUnrealizedVariablesAssignment_2_1_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class SourceGuardPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SourceGuardPatternCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cGuardPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//SourceGuardPatternCS returns qvtcorebasecs::GuardPatternCS:
		//	{qvtcorebasecs::GuardPatternCS} "(" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//	ownedUnrealizedVariables+=UnrealizedVariableCS)*)? ")";
		@Override public ParserRule getRule() { return rule; }

		//{qvtcorebasecs::GuardPatternCS} "(" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//ownedUnrealizedVariables+=UnrealizedVariableCS)*)? ")"
		public Group getGroup() { return cGroup; }

		//{qvtcorebasecs::GuardPatternCS}
		public Action getGuardPatternCSAction_0() { return cGuardPatternCSAction_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_0() { return cOwnedUnrealizedVariablesAssignment_2_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0; }

		//("," ownedUnrealizedVariables+=UnrealizedVariableCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_1_1() { return cOwnedUnrealizedVariablesAssignment_2_1_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class MiddleDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MiddleDomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Keyword cCheckKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Assignment cCheckedPropertiesAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cCheckedPropertiesPathNameCSParserRuleCall_0_1_1_0 = (RuleCall)cCheckedPropertiesAssignment_0_1_1.eContents().get(0);
		private final Group cGroup_0_1_2 = (Group)cGroup_0_1.eContents().get(2);
		private final Keyword cCommaKeyword_0_1_2_0 = (Keyword)cGroup_0_1_2.eContents().get(0);
		private final Assignment cCheckedPropertiesAssignment_0_1_2_1 = (Assignment)cGroup_0_1_2.eContents().get(1);
		private final RuleCall cCheckedPropertiesPathNameCSParserRuleCall_0_1_2_1_0 = (RuleCall)cCheckedPropertiesAssignment_0_1_2_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cEnforceKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cEnforcedPropertiesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cEnforcedPropertiesPathNameCSParserRuleCall_0_2_1_0 = (RuleCall)cEnforcedPropertiesAssignment_0_2_1.eContents().get(0);
		private final Group cGroup_0_2_2 = (Group)cGroup_0_2.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_2_0 = (Keyword)cGroup_0_2_2.eContents().get(0);
		private final Assignment cEnforcedPropertiesAssignment_0_2_2_1 = (Assignment)cGroup_0_2_2.eContents().get(1);
		private final RuleCall cEnforcedPropertiesPathNameCSParserRuleCall_0_2_2_1_0 = (RuleCall)cEnforcedPropertiesAssignment_0_2_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Assignment cOwnedGuardPatternAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedGuardPatternMiddleGuardPatternCSParserRuleCall_1_0 = (RuleCall)cOwnedGuardPatternAssignment_1.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedBottomPatternMiddleBottomPatternCSParserRuleCall_2_0 = (RuleCall)cOwnedBottomPatternAssignment_2.eContents().get(0);
		
		//MiddleDomainCS returns ImperativeDomainCS:
		//	("{" ("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)? ("enforce"
		//	enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)? "}")? ownedGuardPattern=MiddleGuardPatternCS
		//	ownedBottomPattern=MiddleBottomPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//("{" ("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)? ("enforce"
		//enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)? "}")? ownedGuardPattern=MiddleGuardPatternCS
		//ownedBottomPattern=MiddleBottomPatternCS
		public Group getGroup() { return cGroup; }

		//("{" ("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)? ("enforce"
		//enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)? "}")?
		public Group getGroup_0() { return cGroup_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0_0() { return cLeftCurlyBracketKeyword_0_0; }

		//("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//"check"
		public Keyword getCheckKeyword_0_1_0() { return cCheckKeyword_0_1_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_0_1_1() { return cCheckedPropertiesAssignment_0_1_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_0_1_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_0_1_1_0; }

		//("," checkedProperties+=PathNameCS)*
		public Group getGroup_0_1_2() { return cGroup_0_1_2; }

		//","
		public Keyword getCommaKeyword_0_1_2_0() { return cCommaKeyword_0_1_2_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_0_1_2_1() { return cCheckedPropertiesAssignment_0_1_2_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_0_1_2_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_0_1_2_1_0; }

		//("enforce" enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)?
		public Group getGroup_0_2() { return cGroup_0_2; }

		//"enforce"
		public Keyword getEnforceKeyword_0_2_0() { return cEnforceKeyword_0_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_0_2_1() { return cEnforcedPropertiesAssignment_0_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_0_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_0_2_1_0; }

		//("," enforcedProperties+=PathNameCS)*
		public Group getGroup_0_2_2() { return cGroup_0_2_2; }

		//","
		public Keyword getCommaKeyword_0_2_2_0() { return cCommaKeyword_0_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_0_2_2_1() { return cEnforcedPropertiesAssignment_0_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_0_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_0_2_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_0_3() { return cRightCurlyBracketKeyword_0_3; }

		//ownedGuardPattern=MiddleGuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_1() { return cOwnedGuardPatternAssignment_1; }

		//MiddleGuardPatternCS
		public RuleCall getOwnedGuardPatternMiddleGuardPatternCSParserRuleCall_1_0() { return cOwnedGuardPatternMiddleGuardPatternCSParserRuleCall_1_0; }

		//ownedBottomPattern=MiddleBottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_2() { return cOwnedBottomPatternAssignment_2; }

		//MiddleBottomPatternCS
		public RuleCall getOwnedBottomPatternMiddleBottomPatternCSParserRuleCall_2_0() { return cOwnedBottomPatternMiddleBottomPatternCSParserRuleCall_2_0; }
	}

	public class MiddleBottomPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MiddleBottomPatternCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_0_2_1.eContents().get(0);
		private final Keyword cVerticalLineKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Assignment cOwnedConstraintsAssignment_0_4 = (Assignment)cGroup_0.eContents().get(4);
		private final RuleCall cOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_0_4_0 = (RuleCall)cOwnedConstraintsAssignment_0_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_0_5 = (Keyword)cGroup_0.eContents().get(5);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_1_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedConstraintsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_2_1_0 = (RuleCall)cOwnedConstraintsAssignment_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Action cBottomPatternCSAction_3_0 = (Action)cGroup_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//// Bug 466385 explains the redundancy below
		// MiddleBottomPatternCS returns qvtcorebasecs::BottomPatternCS:
		//	"{" ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)* "|"
		//	ownedConstraints+=ImperativePredicateOrAssignmentCS* "}" | "{" ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//	ownedUnrealizedVariables+=UnrealizedVariableCS)* "}" | "{" ownedConstraints+=ImperativePredicateOrAssignmentCS+ "}" |
		//	{qvtcorebasecs::BottomPatternCS} "{" "}";
		@Override public ParserRule getRule() { return rule; }

		//"{" ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)* "|"
		//ownedConstraints+=ImperativePredicateOrAssignmentCS* "}" | "{" ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//ownedUnrealizedVariables+=UnrealizedVariableCS)* "}" | "{" ownedConstraints+=ImperativePredicateOrAssignmentCS+ "}" |
		//{qvtcorebasecs::BottomPatternCS} "{" "}"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"{" ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)* "|"
		//ownedConstraints+=ImperativePredicateOrAssignmentCS* "}"
		public Group getGroup_0() { return cGroup_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0_0() { return cLeftCurlyBracketKeyword_0_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_1() { return cOwnedUnrealizedVariablesAssignment_0_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0; }

		//("," ownedUnrealizedVariables+=UnrealizedVariableCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//","
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_2_1() { return cOwnedUnrealizedVariablesAssignment_0_2_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0; }

		//"|"
		public Keyword getVerticalLineKeyword_0_3() { return cVerticalLineKeyword_0_3; }

		//ownedConstraints+=ImperativePredicateOrAssignmentCS*
		public Assignment getOwnedConstraintsAssignment_0_4() { return cOwnedConstraintsAssignment_0_4; }

		//ImperativePredicateOrAssignmentCS
		public RuleCall getOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_0_4_0() { return cOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_0_4_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_0_5() { return cRightCurlyBracketKeyword_0_5; }

		//"{" ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)* "}"
		public Group getGroup_1() { return cGroup_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1_0() { return cLeftCurlyBracketKeyword_1_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_1() { return cOwnedUnrealizedVariablesAssignment_1_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0; }

		//("," ownedUnrealizedVariables+=UnrealizedVariableCS)*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//","
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_2_1() { return cOwnedUnrealizedVariablesAssignment_1_2_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_1_3() { return cRightCurlyBracketKeyword_1_3; }

		//"{" ownedConstraints+=ImperativePredicateOrAssignmentCS+ "}"
		public Group getGroup_2() { return cGroup_2; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//ownedConstraints+=ImperativePredicateOrAssignmentCS+
		public Assignment getOwnedConstraintsAssignment_2_1() { return cOwnedConstraintsAssignment_2_1; }

		//ImperativePredicateOrAssignmentCS
		public RuleCall getOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_2_1_0() { return cOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2_2() { return cRightCurlyBracketKeyword_2_2; }

		//{qvtcorebasecs::BottomPatternCS} "{" "}"
		public Group getGroup_3() { return cGroup_3; }

		//{qvtcorebasecs::BottomPatternCS}
		public Action getBottomPatternCSAction_3_0() { return cBottomPatternCSAction_3_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3_1() { return cLeftCurlyBracketKeyword_3_1; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3_2() { return cRightCurlyBracketKeyword_3_2; }
	}

	public class MiddleGuardPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MiddleGuardPatternCS");
		private final RuleCall cGuardPatternCSParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//MiddleGuardPatternCS returns qvtcorebasecs::GuardPatternCS:
		//	GuardPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//GuardPatternCS
		public RuleCall getGuardPatternCSParserRuleCall() { return cGuardPatternCSParserRuleCall; }
	}

	public class TargetDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TargetDomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsEnforceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsEnforceEnforceKeyword_0_0 = (Keyword)cIsEnforceAssignment_0.eContents().get(0);
		private final Assignment cDirectionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cDirectionTypedModelCrossReference_1_0 = (CrossReference)cDirectionAssignment_1.eContents().get(0);
		private final RuleCall cDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1 = (RuleCall)cDirectionTypedModelCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCheckKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cCheckedPropertiesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0 = (RuleCall)cCheckedPropertiesAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_2_1_2 = (Group)cGroup_2_1.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_2_0 = (Keyword)cGroup_2_1_2.eContents().get(0);
		private final Assignment cCheckedPropertiesAssignment_2_1_2_1 = (Assignment)cGroup_2_1_2.eContents().get(1);
		private final RuleCall cCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0 = (RuleCall)cCheckedPropertiesAssignment_2_1_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cEnforceKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cEnforcedPropertiesAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0 = (RuleCall)cEnforcedPropertiesAssignment_2_2_1.eContents().get(0);
		private final Group cGroup_2_2_2 = (Group)cGroup_2_2.eContents().get(2);
		private final Keyword cCommaKeyword_2_2_2_0 = (Keyword)cGroup_2_2_2.eContents().get(0);
		private final Assignment cEnforcedPropertiesAssignment_2_2_2_1 = (Assignment)cGroup_2_2_2.eContents().get(1);
		private final RuleCall cEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0 = (RuleCall)cEnforcedPropertiesAssignment_2_2_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_3 = (Keyword)cGroup_2.eContents().get(3);
		private final Assignment cOwnedGuardPatternAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedGuardPatternTargetGuardPatternCSParserRuleCall_3_0 = (RuleCall)cOwnedGuardPatternAssignment_3.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedBottomPatternTargetBottomPatternCSParserRuleCall_4_0 = (RuleCall)cOwnedBottomPatternAssignment_4.eContents().get(0);
		
		//TargetDomainCS returns ImperativeDomainCS:
		//	isEnforce?="enforce" direction=[qvtbase::TypedModel|UnrestrictedName] ("{" ("check" checkedProperties+=PathNameCS
		//	("," checkedProperties+=PathNameCS)*)? ("enforce" enforcedProperties+=PathNameCS (","
		//	enforcedProperties+=PathNameCS)*)? "}")? ownedGuardPattern=TargetGuardPatternCS
		//	ownedBottomPattern=TargetBottomPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//isEnforce?="enforce" direction=[qvtbase::TypedModel|UnrestrictedName] ("{" ("check" checkedProperties+=PathNameCS (","
		//checkedProperties+=PathNameCS)*)? ("enforce" enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)?
		//"}")? ownedGuardPattern=TargetGuardPatternCS ownedBottomPattern=TargetBottomPatternCS
		public Group getGroup() { return cGroup; }

		//isEnforce?="enforce"
		public Assignment getIsEnforceAssignment_0() { return cIsEnforceAssignment_0; }

		//"enforce"
		public Keyword getIsEnforceEnforceKeyword_0_0() { return cIsEnforceEnforceKeyword_0_0; }

		//direction=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getDirectionAssignment_1() { return cDirectionAssignment_1; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getDirectionTypedModelCrossReference_1_0() { return cDirectionTypedModelCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1() { return cDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1; }

		//("{" ("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)? ("enforce"
		//enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)? "}")?
		public Group getGroup_2() { return cGroup_2; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//"check"
		public Keyword getCheckKeyword_2_1_0() { return cCheckKeyword_2_1_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_1() { return cCheckedPropertiesAssignment_2_1_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0; }

		//("," checkedProperties+=PathNameCS)*
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//","
		public Keyword getCommaKeyword_2_1_2_0() { return cCommaKeyword_2_1_2_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_2_1() { return cCheckedPropertiesAssignment_2_1_2_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0; }

		//("enforce" enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)?
		public Group getGroup_2_2() { return cGroup_2_2; }

		//"enforce"
		public Keyword getEnforceKeyword_2_2_0() { return cEnforceKeyword_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_1() { return cEnforcedPropertiesAssignment_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0; }

		//("," enforcedProperties+=PathNameCS)*
		public Group getGroup_2_2_2() { return cGroup_2_2_2; }

		//","
		public Keyword getCommaKeyword_2_2_2_0() { return cCommaKeyword_2_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_2_1() { return cEnforcedPropertiesAssignment_2_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2_3() { return cRightCurlyBracketKeyword_2_3; }

		//ownedGuardPattern=TargetGuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_3() { return cOwnedGuardPatternAssignment_3; }

		//TargetGuardPatternCS
		public RuleCall getOwnedGuardPatternTargetGuardPatternCSParserRuleCall_3_0() { return cOwnedGuardPatternTargetGuardPatternCSParserRuleCall_3_0; }

		//ownedBottomPattern=TargetBottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_4() { return cOwnedBottomPatternAssignment_4; }

		//TargetBottomPatternCS
		public RuleCall getOwnedBottomPatternTargetBottomPatternCSParserRuleCall_4_0() { return cOwnedBottomPatternTargetBottomPatternCSParserRuleCall_4_0; }
	}

	public class TargetBottomPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TargetBottomPatternCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBottomPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_2_0 = (Alternatives)cGroup_2.eContents().get(0);
		private final Assignment cOwnedRealizedVariablesAssignment_2_0_0 = (Assignment)cAlternatives_2_0.eContents().get(0);
		private final RuleCall cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_0_0_0 = (RuleCall)cOwnedRealizedVariablesAssignment_2_0_0.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_0_1 = (Assignment)cAlternatives_2_0.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_0_1.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Alternatives cAlternatives_2_1_1 = (Alternatives)cGroup_2_1.eContents().get(1);
		private final Assignment cOwnedRealizedVariablesAssignment_2_1_1_0 = (Assignment)cAlternatives_2_1_1.eContents().get(0);
		private final RuleCall cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_1_1_0_0 = (RuleCall)cOwnedRealizedVariablesAssignment_2_1_1_0.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_1_1_1 = (Assignment)cAlternatives_2_1_1.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_1_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//TargetBottomPatternCS returns qvtcorebasecs::BottomPatternCS:
		//	{qvtcorebasecs::BottomPatternCS} "{" ((ownedRealizedVariables+=RealizedVariableCS |
		//	ownedUnrealizedVariables+=UnrealizedVariableCS) ("," (ownedRealizedVariables+=RealizedVariableCS |
		//	ownedUnrealizedVariables+=UnrealizedVariableCS))*)? "}";
		@Override public ParserRule getRule() { return rule; }

		//{qvtcorebasecs::BottomPatternCS} "{" ((ownedRealizedVariables+=RealizedVariableCS |
		//ownedUnrealizedVariables+=UnrealizedVariableCS) ("," (ownedRealizedVariables+=RealizedVariableCS |
		//ownedUnrealizedVariables+=UnrealizedVariableCS))*)? "}"
		public Group getGroup() { return cGroup; }

		//{qvtcorebasecs::BottomPatternCS}
		public Action getBottomPatternCSAction_0() { return cBottomPatternCSAction_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//((ownedRealizedVariables+=RealizedVariableCS | ownedUnrealizedVariables+=UnrealizedVariableCS) (","
		//(ownedRealizedVariables+=RealizedVariableCS | ownedUnrealizedVariables+=UnrealizedVariableCS))*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedRealizedVariables+=RealizedVariableCS | ownedUnrealizedVariables+=UnrealizedVariableCS
		public Alternatives getAlternatives_2_0() { return cAlternatives_2_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_2_0_0() { return cOwnedRealizedVariablesAssignment_2_0_0; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_0_0_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_0_0_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_0_1() { return cOwnedUnrealizedVariablesAssignment_2_0_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_1_0; }

		//("," (ownedRealizedVariables+=RealizedVariableCS | ownedUnrealizedVariables+=UnrealizedVariableCS))*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedRealizedVariables+=RealizedVariableCS | ownedUnrealizedVariables+=UnrealizedVariableCS
		public Alternatives getAlternatives_2_1_1() { return cAlternatives_2_1_1; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_2_1_1_0() { return cOwnedRealizedVariablesAssignment_2_1_1_0; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_1_1_0_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_1_1_0_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_1_1_1() { return cOwnedUnrealizedVariablesAssignment_2_1_1_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class TargetGuardPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TargetGuardPatternCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cGuardPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//TargetGuardPatternCS returns qvtcorebasecs::GuardPatternCS:
		//	{qvtcorebasecs::GuardPatternCS} "(" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//	ownedUnrealizedVariables+=UnrealizedVariableCS)*)? ")";
		@Override public ParserRule getRule() { return rule; }

		//{qvtcorebasecs::GuardPatternCS} "(" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
		//ownedUnrealizedVariables+=UnrealizedVariableCS)*)? ")"
		public Group getGroup() { return cGroup; }

		//{qvtcorebasecs::GuardPatternCS}
		public Action getGuardPatternCSAction_0() { return cGuardPatternCSAction_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_0() { return cOwnedUnrealizedVariablesAssignment_2_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0; }

		//("," ownedUnrealizedVariables+=UnrealizedVariableCS)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_1_1() { return cOwnedUnrealizedVariablesAssignment_2_1_1; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}
	
	
	private final TopLevelCSElements pTopLevelCS;
	private final DirectionCSElements pDirectionCS;
	private final MappingCSElements pMappingCS;
	private final MappingCallCSElements pMappingCallCS;
	private final MappingCallBindingCSElements pMappingCallBindingCS;
	private final MappingLoopCSElements pMappingLoopCS;
	private final MappingIteratorCSElements pMappingIteratorCS;
	private final MappingSequenceCSElements pMappingSequenceCS;
	private final MappingStatementCSElements pMappingStatementCS;
	private final ImperativePredicateOrAssignmentCSElements pImperativePredicateOrAssignmentCS;
	private final SourceDomainCSElements pSourceDomainCS;
	private final SourceBottomPatternCSElements pSourceBottomPatternCS;
	private final SourceGuardPatternCSElements pSourceGuardPatternCS;
	private final MiddleDomainCSElements pMiddleDomainCS;
	private final MiddleBottomPatternCSElements pMiddleBottomPatternCS;
	private final MiddleGuardPatternCSElements pMiddleGuardPatternCS;
	private final TargetDomainCSElements pTargetDomainCS;
	private final TargetBottomPatternCSElements pTargetBottomPatternCS;
	private final TargetGuardPatternCSElements pTargetGuardPatternCS;
	
	private final Grammar grammar;

	private final QVTcoreBaseGrammarAccess gaQVTcoreBase;

	@Inject
	public QVTimperativeGrammarAccess(GrammarProvider grammarProvider,
		QVTcoreBaseGrammarAccess gaQVTcoreBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaQVTcoreBase = gaQVTcoreBase;
		this.pTopLevelCS = new TopLevelCSElements();
		this.pDirectionCS = new DirectionCSElements();
		this.pMappingCS = new MappingCSElements();
		this.pMappingCallCS = new MappingCallCSElements();
		this.pMappingCallBindingCS = new MappingCallBindingCSElements();
		this.pMappingLoopCS = new MappingLoopCSElements();
		this.pMappingIteratorCS = new MappingIteratorCSElements();
		this.pMappingSequenceCS = new MappingSequenceCSElements();
		this.pMappingStatementCS = new MappingStatementCSElements();
		this.pImperativePredicateOrAssignmentCS = new ImperativePredicateOrAssignmentCSElements();
		this.pSourceDomainCS = new SourceDomainCSElements();
		this.pSourceBottomPatternCS = new SourceBottomPatternCSElements();
		this.pSourceGuardPatternCS = new SourceGuardPatternCSElements();
		this.pMiddleDomainCS = new MiddleDomainCSElements();
		this.pMiddleBottomPatternCS = new MiddleBottomPatternCSElements();
		this.pMiddleGuardPatternCS = new MiddleGuardPatternCSElements();
		this.pTargetDomainCS = new TargetDomainCSElements();
		this.pTargetBottomPatternCS = new TargetBottomPatternCSElements();
		this.pTargetGuardPatternCS = new TargetGuardPatternCSElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.qvtd.xtext.qvtimperative.QVTimperative".equals(grammar.getName())) {
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
	

	public QVTcoreBaseGrammarAccess getQVTcoreBaseGrammarAccess() {
		return gaQVTcoreBase;
	}

	
	//TopLevelCS:
	//	ownedImports+=ImportCS* (ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*;
	public TopLevelCSElements getTopLevelCSAccess() {
		return pTopLevelCS;
	}
	
	public ParserRule getTopLevelCSRule() {
		return getTopLevelCSAccess().getRule();
	}

	//DirectionCS returns qvtcorebasecs::DirectionCS:
	//	{qvtcorebasecs::DirectionCS} name=UnrestrictedName ("imports" imports+=[pivot::Package|UnrestrictedName] (","
	//	imports+=[pivot::Package|UnrestrictedName])*)? ("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] (","
	//	uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?;
	public DirectionCSElements getDirectionCSAccess() {
		return pDirectionCS;
	}
	
	public ParserRule getDirectionCSRule() {
		return getDirectionCSAccess().getRule();
	}

	//MappingCS:
	//	{MappingCS} isDefault?="default"? "map" name=UnrestrictedName ("in" ownedInPathName=PathNameCS)? ("uses"
	//	ownedUsesPathNames+=PathNameCS ("," ownedUsesPathNames+=PathNameCS)*)? "{" ownedDomains+=(SourceDomainCS |
	//	TargetDomainCS)* ("where" ownedMiddle=MiddleDomainCS)? ownedMappingSequence=MappingSequenceCS? "}";
	public MappingCSElements getMappingCSAccess() {
		return pMappingCS;
	}
	
	public ParserRule getMappingCSRule() {
		return getMappingCSAccess().getRule();
	}

	//MappingCallCS:
	//	{MappingCallCS} isInfinite?="infinite"? "call" ownedPathName=PathNameCS "{" ownedBindings+=MappingCallBindingCS* "}";
	public MappingCallCSElements getMappingCallCSAccess() {
		return pMappingCallCS;
	}
	
	public ParserRule getMappingCallCSRule() {
		return getMappingCallCSAccess().getRule();
	}

	//MappingCallBindingCS:
	//	referredVariable=[pivot::Variable|UnrestrictedName] (":=" | isPolled?="?=") ownedValue=ExpCS ";";
	public MappingCallBindingCSElements getMappingCallBindingCSAccess() {
		return pMappingCallBindingCS;
	}
	
	public ParserRule getMappingCallBindingCSRule() {
		return getMappingCallBindingCSAccess().getRule();
	}

	//MappingLoopCS:
	//	"for" ownedIterator=MappingIteratorCS "in" ownedInExpression=ExpCS "{" ownedMappingSequence=MappingSequenceCS "}";
	public MappingLoopCSElements getMappingLoopCSAccess() {
		return pMappingLoopCS;
	}
	
	public ParserRule getMappingLoopCSRule() {
		return getMappingLoopCSAccess().getRule();
	}

	//MappingIteratorCS returns essentialocl::VariableCS:
	//	name=UnrestrictedName (":" ownedType=TypeExpCS)?;
	public MappingIteratorCSElements getMappingIteratorCSAccess() {
		return pMappingIteratorCS;
	}
	
	public ParserRule getMappingIteratorCSRule() {
		return getMappingIteratorCSAccess().getRule();
	}

	//MappingSequenceCS:
	//	ownedMappingStatements+=MappingStatementCS+;
	public MappingSequenceCSElements getMappingSequenceCSAccess() {
		return pMappingSequenceCS;
	}
	
	public ParserRule getMappingSequenceCSRule() {
		return getMappingSequenceCSAccess().getRule();
	}

	//MappingStatementCS:
	//	MappingCallCS | MappingLoopCS;
	public MappingStatementCSElements getMappingStatementCSAccess() {
		return pMappingStatementCS;
	}
	
	public ParserRule getMappingStatementCSRule() {
		return getMappingStatementCSAccess().getRule();
	}

	//ImperativePredicateOrAssignmentCS:
	//	isDefault?="default"? ownedTarget=ExpCS ((":=" | isAccumulate?="+=") ownedInitExpression=ExpCS)? ";";
	public ImperativePredicateOrAssignmentCSElements getImperativePredicateOrAssignmentCSAccess() {
		return pImperativePredicateOrAssignmentCS;
	}
	
	public ParserRule getImperativePredicateOrAssignmentCSRule() {
		return getImperativePredicateOrAssignmentCSAccess().getRule();
	}

	//SourceDomainCS returns ImperativeDomainCS:
	//	isCheck?="check" direction=[qvtbase::TypedModel|UnrestrictedName] ("{" ("check" checkedProperties+=PathNameCS (","
	//	checkedProperties+=PathNameCS)*)? ("enforce" enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)?
	//	"}")? ownedGuardPattern=SourceGuardPatternCS ownedBottomPattern=SourceBottomPatternCS;
	public SourceDomainCSElements getSourceDomainCSAccess() {
		return pSourceDomainCS;
	}
	
	public ParserRule getSourceDomainCSRule() {
		return getSourceDomainCSAccess().getRule();
	}

	//SourceBottomPatternCS returns qvtcorebasecs::BottomPatternCS:
	//	{qvtcorebasecs::BottomPatternCS} "{" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
	//	ownedUnrealizedVariables+=UnrealizedVariableCS)*)? "}";
	public SourceBottomPatternCSElements getSourceBottomPatternCSAccess() {
		return pSourceBottomPatternCS;
	}
	
	public ParserRule getSourceBottomPatternCSRule() {
		return getSourceBottomPatternCSAccess().getRule();
	}

	//SourceGuardPatternCS returns qvtcorebasecs::GuardPatternCS:
	//	{qvtcorebasecs::GuardPatternCS} "(" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
	//	ownedUnrealizedVariables+=UnrealizedVariableCS)*)? ")";
	public SourceGuardPatternCSElements getSourceGuardPatternCSAccess() {
		return pSourceGuardPatternCS;
	}
	
	public ParserRule getSourceGuardPatternCSRule() {
		return getSourceGuardPatternCSAccess().getRule();
	}

	//MiddleDomainCS returns ImperativeDomainCS:
	//	("{" ("check" checkedProperties+=PathNameCS ("," checkedProperties+=PathNameCS)*)? ("enforce"
	//	enforcedProperties+=PathNameCS ("," enforcedProperties+=PathNameCS)*)? "}")? ownedGuardPattern=MiddleGuardPatternCS
	//	ownedBottomPattern=MiddleBottomPatternCS;
	public MiddleDomainCSElements getMiddleDomainCSAccess() {
		return pMiddleDomainCS;
	}
	
	public ParserRule getMiddleDomainCSRule() {
		return getMiddleDomainCSAccess().getRule();
	}

	//// Bug 466385 explains the redundancy below
	// MiddleBottomPatternCS returns qvtcorebasecs::BottomPatternCS:
	//	"{" ownedUnrealizedVariables+=UnrealizedVariableCS ("," ownedUnrealizedVariables+=UnrealizedVariableCS)* "|"
	//	ownedConstraints+=ImperativePredicateOrAssignmentCS* "}" | "{" ownedUnrealizedVariables+=UnrealizedVariableCS (","
	//	ownedUnrealizedVariables+=UnrealizedVariableCS)* "}" | "{" ownedConstraints+=ImperativePredicateOrAssignmentCS+ "}" |
	//	{qvtcorebasecs::BottomPatternCS} "{" "}";
	public MiddleBottomPatternCSElements getMiddleBottomPatternCSAccess() {
		return pMiddleBottomPatternCS;
	}
	
	public ParserRule getMiddleBottomPatternCSRule() {
		return getMiddleBottomPatternCSAccess().getRule();
	}

	//MiddleGuardPatternCS returns qvtcorebasecs::GuardPatternCS:
	//	GuardPatternCS;
	public MiddleGuardPatternCSElements getMiddleGuardPatternCSAccess() {
		return pMiddleGuardPatternCS;
	}
	
	public ParserRule getMiddleGuardPatternCSRule() {
		return getMiddleGuardPatternCSAccess().getRule();
	}

	//TargetDomainCS returns ImperativeDomainCS:
	//	isEnforce?="enforce" direction=[qvtbase::TypedModel|UnrestrictedName] ("{" ("check" checkedProperties+=PathNameCS
	//	("," checkedProperties+=PathNameCS)*)? ("enforce" enforcedProperties+=PathNameCS (","
	//	enforcedProperties+=PathNameCS)*)? "}")? ownedGuardPattern=TargetGuardPatternCS
	//	ownedBottomPattern=TargetBottomPatternCS;
	public TargetDomainCSElements getTargetDomainCSAccess() {
		return pTargetDomainCS;
	}
	
	public ParserRule getTargetDomainCSRule() {
		return getTargetDomainCSAccess().getRule();
	}

	//TargetBottomPatternCS returns qvtcorebasecs::BottomPatternCS:
	//	{qvtcorebasecs::BottomPatternCS} "{" ((ownedRealizedVariables+=RealizedVariableCS |
	//	ownedUnrealizedVariables+=UnrealizedVariableCS) ("," (ownedRealizedVariables+=RealizedVariableCS |
	//	ownedUnrealizedVariables+=UnrealizedVariableCS))*)? "}";
	public TargetBottomPatternCSElements getTargetBottomPatternCSAccess() {
		return pTargetBottomPatternCS;
	}
	
	public ParserRule getTargetBottomPatternCSRule() {
		return getTargetBottomPatternCSAccess().getRule();
	}

	//TargetGuardPatternCS returns qvtcorebasecs::GuardPatternCS:
	//	{qvtcorebasecs::GuardPatternCS} "(" (ownedUnrealizedVariables+=UnrealizedVariableCS (","
	//	ownedUnrealizedVariables+=UnrealizedVariableCS)*)? ")";
	public TargetGuardPatternCSElements getTargetGuardPatternCSAccess() {
		return pTargetGuardPatternCS;
	}
	
	public ParserRule getTargetGuardPatternCSRule() {
		return getTargetGuardPatternCSAccess().getRule();
	}

	//// Bug 466385 explains the redundancy below
	// BottomPatternCS:
	//	"{" (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (","
	//	(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* "|"
	//	ownedConstraints+=PredicateOrAssignmentCS* "}" | "{" (ownedUnrealizedVariables+=UnrealizedVariableCS |
	//	ownedRealizedVariables+=RealizedVariableCS) ("," (ownedUnrealizedVariables+=UnrealizedVariableCS |
	//	ownedRealizedVariables+=RealizedVariableCS))* "}" | "{" ownedConstraints+=PredicateOrAssignmentCS+ "}" |
	//	{BottomPatternCS} "{" "}";
	public QVTcoreBaseGrammarAccess.BottomPatternCSElements getBottomPatternCSAccess() {
		return gaQVTcoreBase.getBottomPatternCSAccess();
	}
	
	public ParserRule getBottomPatternCSRule() {
		return getBottomPatternCSAccess().getRule();
	}

	////EnforcementOperationCS: ('creation'|'deletion') ExpCS ';';
	// // Bug 466385 explains the redundancy below
	//
	//GuardPatternCS:
	//	"(" ownedUnrealizedVariables+=GuardVariableCS ("," ownedUnrealizedVariables+=GuardVariableCS)* "|"
	//	ownedPredicates+=PredicateCS* ")" | "(" ownedUnrealizedVariables+=GuardVariableCS (","
	//	ownedUnrealizedVariables+=GuardVariableCS)* ")" | "(" ownedPredicates+=PredicateCS+ ")" | {GuardPatternCS} "(" ")";
	public QVTcoreBaseGrammarAccess.GuardPatternCSElements getGuardPatternCSAccess() {
		return gaQVTcoreBase.getGuardPatternCSAccess();
	}
	
	public ParserRule getGuardPatternCSRule() {
		return getGuardPatternCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	// GuardVariableCS returns UnrealizedVariableCS:
	//	name=UnrestrictedName ":" ownedType=TypeExpCS;
	public QVTcoreBaseGrammarAccess.GuardVariableCSElements getGuardVariableCSAccess() {
		return gaQVTcoreBase.getGuardVariableCSAccess();
	}
	
	public ParserRule getGuardVariableCSRule() {
		return getGuardVariableCSAccess().getRule();
	}

	//ImportCS returns base::ImportCS:
	//	"import" (name=Identifier ":")? ownedPathName=URIPathNameCS (isAll?="::" "*")? ";";
	public QVTcoreBaseGrammarAccess.ImportCSElements getImportCSAccess() {
		return gaQVTcoreBase.getImportCSAccess();
	}
	
	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	//NamedDomainCS returns DomainCS:
	//	isCheck?="check"? isEnforce?="enforce"? direction=[qvtbase::TypedModel|UnrestrictedName]
	//	ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
	public QVTcoreBaseGrammarAccess.NamedDomainCSElements getNamedDomainCSAccess() {
		return gaQVTcoreBase.getNamedDomainCSAccess();
	}
	
	public ParserRule getNamedDomainCSRule() {
		return getNamedDomainCSAccess().getRule();
	}

	//ParamDeclarationCS:
	//	name=UnrestrictedName ":" ownedType=TypeExpCS;
	public QVTcoreBaseGrammarAccess.ParamDeclarationCSElements getParamDeclarationCSAccess() {
		return gaQVTcoreBase.getParamDeclarationCSAccess();
	}
	
	public ParserRule getParamDeclarationCSRule() {
		return getParamDeclarationCSAccess().getRule();
	}

	//PredicateCS:
	//	ownedCondition=ExpCS ";";
	public QVTcoreBaseGrammarAccess.PredicateCSElements getPredicateCSAccess() {
		return gaQVTcoreBase.getPredicateCSAccess();
	}
	
	public ParserRule getPredicateCSRule() {
		return getPredicateCSAccess().getRule();
	}

	////Constraint ::= Predicate | Assignment
	// //Predicate ::= BooleanOCLExpr
	//
	////Assignement ::= [�default�] SlotOwnerOCLExpr�.�PropertyName �:=� ValueOCLExpr
	// PredicateOrAssignmentCS:
	//	isDefault?="default"? ownedTarget=ExpCS (":=" ownedInitExpression=ExpCS)? ";";
	public QVTcoreBaseGrammarAccess.PredicateOrAssignmentCSElements getPredicateOrAssignmentCSAccess() {
		return gaQVTcoreBase.getPredicateOrAssignmentCSAccess();
	}
	
	public ParserRule getPredicateOrAssignmentCSRule() {
		return getPredicateOrAssignmentCSAccess().getRule();
	}

	//QueryCS:
	//	"query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" (ownedParameters+=ParamDeclarationCS (","
	//	ownedParameters+=ParamDeclarationCS)*)? ")" ":" ownedType=TypeExpCS (";" | "{" ownedExpression=ExpCS "}");
	public QVTcoreBaseGrammarAccess.QueryCSElements getQueryCSAccess() {
		return gaQVTcoreBase.getQueryCSAccess();
	}
	
	public ParserRule getQueryCSRule() {
		return getQueryCSAccess().getRule();
	}

	////<query> ::= 'query' <PathNameCS> 
	// //            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
	//
	////      	  ':' <TypeCS>
	// //            (';' | '{' <OCLExpressionCS> '}')
	// ScopeNameCS returns base::PathNameCS:
	//	ownedPathElements+=FirstPathElementCS "::" (ownedPathElements+=NextPathElementCS "::")*;
	public QVTcoreBaseGrammarAccess.ScopeNameCSElements getScopeNameCSAccess() {
		return gaQVTcoreBase.getScopeNameCSAccess();
	}
	
	public ParserRule getScopeNameCSRule() {
		return getScopeNameCSAccess().getRule();
	}

	//TransformationCS:
	//	"transformation" ownedPathName=ScopeNameCS? name=UnreservedName "{" (ownedDirections+=DirectionCS ";")* "}";
	public QVTcoreBaseGrammarAccess.TransformationCSElements getTransformationCSAccess() {
		return gaQVTcoreBase.getTransformationCSAccess();
	}
	
	public ParserRule getTransformationCSRule() {
		return getTransformationCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	// UnrealizedVariableCS:
	//	name=UnrestrictedName (":" ownedType=TypeExpCS)? (":=" ownedInitExpression=ExpCS)?;
	public QVTcoreBaseGrammarAccess.UnrealizedVariableCSElements getUnrealizedVariableCSAccess() {
		return gaQVTcoreBase.getUnrealizedVariableCSAccess();
	}
	
	public ParserRule getUnrealizedVariableCSRule() {
		return getUnrealizedVariableCSAccess().getRule();
	}

	////RealizedVariable := �realized� VariableName �:� TypeDeclaration
	// RealizedVariableCS:
	//	"realize" name=UnrestrictedName ":" ownedType=TypeExpCS;
	public QVTcoreBaseGrammarAccess.RealizedVariableCSElements getRealizedVariableCSAccess() {
		return gaQVTcoreBase.getRealizedVariableCSAccess();
	}
	
	public ParserRule getRealizedVariableCSRule() {
		return getRealizedVariableCSAccess().getRule();
	}

	//UnnamedDomainCS returns DomainCS:
	//	{DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
	public QVTcoreBaseGrammarAccess.UnnamedDomainCSElements getUnnamedDomainCSAccess() {
		return gaQVTcoreBase.getUnnamedDomainCSAccess();
	}
	
	public ParserRule getUnnamedDomainCSRule() {
		return getUnnamedDomainCSAccess().getRule();
	}

	////|	'where'
	// UnrestrictedName returns ecore::EString:
	//	EssentialOCLUnrestrictedName //|	'creation'
	// //|	'default'
	// //|	'deletion'
	// //|	'include'
	// | "check" | "enforce" |
	//	"import" | "imports" | "library" | "map" | "query" | "realize" | "refines" | "transformation" | "uses";
	public QVTcoreBaseGrammarAccess.UnrestrictedNameElements getUnrestrictedNameAccess() {
		return gaQVTcoreBase.getUnrestrictedNameAccess();
	}
	
	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	// Model returns ContextCS:
	//	ownedExpression=ExpCS;
	public EssentialOCLGrammarAccess.ModelElements getModelAccess() {
		return gaQVTcoreBase.getModelAccess();
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLReservedKeyword:
	//	"and" | "else" | "endif" | "if" | "implies" | "in" | "let" | "not" | "or" | "then" | "xor";
	public EssentialOCLGrammarAccess.EssentialOCLReservedKeywordElements getEssentialOCLReservedKeywordAccess() {
		return gaQVTcoreBase.getEssentialOCLReservedKeywordAccess();
	}
	
	public ParserRule getEssentialOCLReservedKeywordRule() {
		return getEssentialOCLReservedKeywordAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnaryOperatorName:
	//	"-" | "not";
	public EssentialOCLGrammarAccess.EssentialOCLUnaryOperatorNameElements getEssentialOCLUnaryOperatorNameAccess() {
		return gaQVTcoreBase.getEssentialOCLUnaryOperatorNameAccess();
	}
	
	public ParserRule getEssentialOCLUnaryOperatorNameRule() {
		return getEssentialOCLUnaryOperatorNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLInfixOperatorName:
	//	"*" | "/" | "+" | "-" | ">" | "<" | ">=" | "<=" | "=" | "<>" | "and" | "or" | "xor" | "implies";
	public EssentialOCLGrammarAccess.EssentialOCLInfixOperatorNameElements getEssentialOCLInfixOperatorNameAccess() {
		return gaQVTcoreBase.getEssentialOCLInfixOperatorNameAccess();
	}
	
	public ParserRule getEssentialOCLInfixOperatorNameRule() {
		return getEssentialOCLInfixOperatorNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLNavigationOperatorName:
	//	"." | "->" | "?." | "?->";
	public EssentialOCLGrammarAccess.EssentialOCLNavigationOperatorNameElements getEssentialOCLNavigationOperatorNameAccess() {
		return gaQVTcoreBase.getEssentialOCLNavigationOperatorNameAccess();
	}
	
	public ParserRule getEssentialOCLNavigationOperatorNameRule() {
		return getEssentialOCLNavigationOperatorNameAccess().getRule();
	}

	//BinaryOperatorName:
	//	InfixOperatorName | NavigationOperatorName;
	public EssentialOCLGrammarAccess.BinaryOperatorNameElements getBinaryOperatorNameAccess() {
		return gaQVTcoreBase.getBinaryOperatorNameAccess();
	}
	
	public ParserRule getBinaryOperatorNameRule() {
		return getBinaryOperatorNameAccess().getRule();
	}

	//// Intended to be overrideable
	// InfixOperatorName:
	//	EssentialOCLInfixOperatorName;
	public EssentialOCLGrammarAccess.InfixOperatorNameElements getInfixOperatorNameAccess() {
		return gaQVTcoreBase.getInfixOperatorNameAccess();
	}
	
	public ParserRule getInfixOperatorNameRule() {
		return getInfixOperatorNameAccess().getRule();
	}

	//// Intended to be overrideable
	// NavigationOperatorName:
	//	EssentialOCLNavigationOperatorName;
	public EssentialOCLGrammarAccess.NavigationOperatorNameElements getNavigationOperatorNameAccess() {
		return gaQVTcoreBase.getNavigationOperatorNameAccess();
	}
	
	public ParserRule getNavigationOperatorNameRule() {
		return getNavigationOperatorNameAccess().getRule();
	}

	//// Intended to be overrideable
	// UnaryOperatorName:
	//	EssentialOCLUnaryOperatorName;
	public EssentialOCLGrammarAccess.UnaryOperatorNameElements getUnaryOperatorNameAccess() {
		return gaQVTcoreBase.getUnaryOperatorNameAccess();
	}
	
	public ParserRule getUnaryOperatorNameRule() {
		return getUnaryOperatorNameAccess().getRule();
	}

	////---------------------------------------------------------------------
	// //  Names
	//
	////---------------------------------------------------------------------
	//
	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnrestrictedName returns ecore::EString:
	//	Identifier;
	public EssentialOCLGrammarAccess.EssentialOCLUnrestrictedNameElements getEssentialOCLUnrestrictedNameAccess() {
		return gaQVTcoreBase.getEssentialOCLUnrestrictedNameAccess();
	}
	
	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnreservedName returns ecore::EString:
	//	UnrestrictedName | CollectionTypeIdentifier | PrimitiveTypeIdentifier | "Map" | "Tuple";
	public EssentialOCLGrammarAccess.EssentialOCLUnreservedNameElements getEssentialOCLUnreservedNameAccess() {
		return gaQVTcoreBase.getEssentialOCLUnreservedNameAccess();
	}
	
	public ParserRule getEssentialOCLUnreservedNameRule() {
		return getEssentialOCLUnreservedNameAccess().getRule();
	}

	//// Intended to be overridden
	// UnreservedName returns ecore::EString:
	//	EssentialOCLUnreservedName;
	public EssentialOCLGrammarAccess.UnreservedNameElements getUnreservedNameAccess() {
		return gaQVTcoreBase.getUnreservedNameAccess();
	}
	
	public ParserRule getUnreservedNameRule() {
		return getUnreservedNameAccess().getRule();
	}

	//URIPathNameCS returns base::PathNameCS:
	//	ownedPathElements+=URIFirstPathElementCS ("::" ownedPathElements+=NextPathElementCS)*;
	public EssentialOCLGrammarAccess.URIPathNameCSElements getURIPathNameCSAccess() {
		return gaQVTcoreBase.getURIPathNameCSAccess();
	}
	
	public ParserRule getURIPathNameCSRule() {
		return getURIPathNameCSAccess().getRule();
	}

	//URIFirstPathElementCS returns base::PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS}
	//	referredElement=[pivot::Namespace|URI];
	public EssentialOCLGrammarAccess.URIFirstPathElementCSElements getURIFirstPathElementCSAccess() {
		return gaQVTcoreBase.getURIFirstPathElementCSAccess();
	}
	
	public ParserRule getURIFirstPathElementCSRule() {
		return getURIFirstPathElementCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	// //  Types
	//
	////---------------------------------------------------------------------
	// PrimitiveTypeIdentifier:
	//	"Boolean" | "Integer" | "Real" | "String" | "UnlimitedNatural" | "OclAny" | "OclInvalid" | "OclVoid";
	public EssentialOCLGrammarAccess.PrimitiveTypeIdentifierElements getPrimitiveTypeIdentifierAccess() {
		return gaQVTcoreBase.getPrimitiveTypeIdentifierAccess();
	}
	
	public ParserRule getPrimitiveTypeIdentifierRule() {
		return getPrimitiveTypeIdentifierAccess().getRule();
	}

	//PrimitiveTypeCS returns base::PrimitiveTypeRefCS:
	//	name=PrimitiveTypeIdentifier;
	public EssentialOCLGrammarAccess.PrimitiveTypeCSElements getPrimitiveTypeCSAccess() {
		return gaQVTcoreBase.getPrimitiveTypeCSAccess();
	}
	
	public ParserRule getPrimitiveTypeCSRule() {
		return getPrimitiveTypeCSAccess().getRule();
	}

	//CollectionTypeIdentifier returns ecore::EString:
	//	"Set" | "Bag" | "Sequence" | "Collection" | "OrderedSet";
	public EssentialOCLGrammarAccess.CollectionTypeIdentifierElements getCollectionTypeIdentifierAccess() {
		return gaQVTcoreBase.getCollectionTypeIdentifierAccess();
	}
	
	public ParserRule getCollectionTypeIdentifierRule() {
		return getCollectionTypeIdentifierAccess().getRule();
	}

	//CollectionTypeCS:
	//	name=CollectionTypeIdentifier ("(" ownedType=TypeExpCS ")")?;
	public EssentialOCLGrammarAccess.CollectionTypeCSElements getCollectionTypeCSAccess() {
		return gaQVTcoreBase.getCollectionTypeCSAccess();
	}
	
	public ParserRule getCollectionTypeCSRule() {
		return getCollectionTypeCSAccess().getRule();
	}

	//MapTypeCS:
	//	name="Map" ("(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")")?;
	public EssentialOCLGrammarAccess.MapTypeCSElements getMapTypeCSAccess() {
		return gaQVTcoreBase.getMapTypeCSAccess();
	}
	
	public ParserRule getMapTypeCSRule() {
		return getMapTypeCSAccess().getRule();
	}

	//TupleTypeCS returns base::TupleTypeCS:
	//	name="Tuple" ("(" (ownedParts+=TuplePartCS ("," ownedParts+=TuplePartCS)*)? ")")?;
	public EssentialOCLGrammarAccess.TupleTypeCSElements getTupleTypeCSAccess() {
		return gaQVTcoreBase.getTupleTypeCSAccess();
	}
	
	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	//TuplePartCS returns base::TuplePartCS:
	//	name=UnrestrictedName ":" ownedType=TypeExpCS;
	public EssentialOCLGrammarAccess.TuplePartCSElements getTuplePartCSAccess() {
		return gaQVTcoreBase.getTuplePartCSAccess();
	}
	
	public ParserRule getTuplePartCSRule() {
		return getTuplePartCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	// //  Literals
	//
	////---------------------------------------------------------------------
	// CollectionLiteralExpCS:
	//	ownedType=CollectionTypeCS "{" (ownedParts+=CollectionLiteralPartCS ("," ownedParts+=CollectionLiteralPartCS)*)? "}";
	public EssentialOCLGrammarAccess.CollectionLiteralExpCSElements getCollectionLiteralExpCSAccess() {
		return gaQVTcoreBase.getCollectionLiteralExpCSAccess();
	}
	
	public ParserRule getCollectionLiteralExpCSRule() {
		return getCollectionLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralPartCS:
	//	ownedExpression=ExpCS (".." ownedLastExpression=ExpCS)? | ownedExpression=PatternExpCS;
	public EssentialOCLGrammarAccess.CollectionLiteralPartCSElements getCollectionLiteralPartCSAccess() {
		return gaQVTcoreBase.getCollectionLiteralPartCSAccess();
	}
	
	public ParserRule getCollectionLiteralPartCSRule() {
		return getCollectionLiteralPartCSAccess().getRule();
	}

	//CollectionPatternCS:
	//	ownedType=CollectionTypeCS "{" (ownedParts+=PatternExpCS ("," ownedParts+=PatternExpCS)* ("++"
	//	restVariableName=Identifier))? "}";
	public EssentialOCLGrammarAccess.CollectionPatternCSElements getCollectionPatternCSAccess() {
		return gaQVTcoreBase.getCollectionPatternCSAccess();
	}
	
	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//// PatternPartCS
	// ShadowPartCS:
	//	referredProperty=[pivot::Property|UnrestrictedName] "=" ownedInitExpression=(ExpCS | PatternExpCS);
	public EssentialOCLGrammarAccess.ShadowPartCSElements getShadowPartCSAccess() {
		return gaQVTcoreBase.getShadowPartCSAccess();
	}
	
	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//	patternVariableName=UnrestrictedName? ":" ownedPatternType=TypeExpCS;
	public EssentialOCLGrammarAccess.PatternExpCSElements getPatternExpCSAccess() {
		return gaQVTcoreBase.getPatternExpCSAccess();
	}
	
	public ParserRule getPatternExpCSRule() {
		return getPatternExpCSAccess().getRule();
	}

	//LambdaLiteralExpCS:
	//	"Lambda" "{" ownedExpressionCS=ExpCS "}";
	public EssentialOCLGrammarAccess.LambdaLiteralExpCSElements getLambdaLiteralExpCSAccess() {
		return gaQVTcoreBase.getLambdaLiteralExpCSAccess();
	}
	
	public ParserRule getLambdaLiteralExpCSRule() {
		return getLambdaLiteralExpCSAccess().getRule();
	}

	//MapLiteralExpCS:
	//	ownedType=MapTypeCS "{" (ownedParts+=MapLiteralPartCS ("," ownedParts+=MapLiteralPartCS)*)? "}";
	public EssentialOCLGrammarAccess.MapLiteralExpCSElements getMapLiteralExpCSAccess() {
		return gaQVTcoreBase.getMapLiteralExpCSAccess();
	}
	
	public ParserRule getMapLiteralExpCSRule() {
		return getMapLiteralExpCSAccess().getRule();
	}

	//MapLiteralPartCS:
	//	ownedKey=ExpCS "<-" ownedValue=ExpCS;
	public EssentialOCLGrammarAccess.MapLiteralPartCSElements getMapLiteralPartCSAccess() {
		return gaQVTcoreBase.getMapLiteralPartCSAccess();
	}
	
	public ParserRule getMapLiteralPartCSRule() {
		return getMapLiteralPartCSAccess().getRule();
	}

	//PrimitiveLiteralExpCS:
	//	NumberLiteralExpCS | StringLiteralExpCS | BooleanLiteralExpCS | UnlimitedNaturalLiteralExpCS | InvalidLiteralExpCS |
	//	NullLiteralExpCS;
	public EssentialOCLGrammarAccess.PrimitiveLiteralExpCSElements getPrimitiveLiteralExpCSAccess() {
		return gaQVTcoreBase.getPrimitiveLiteralExpCSAccess();
	}
	
	public ParserRule getPrimitiveLiteralExpCSRule() {
		return getPrimitiveLiteralExpCSAccess().getRule();
	}

	//TupleLiteralExpCS:
	//	"Tuple" "{" ownedParts+=TupleLiteralPartCS ("," ownedParts+=TupleLiteralPartCS)* "}";
	public EssentialOCLGrammarAccess.TupleLiteralExpCSElements getTupleLiteralExpCSAccess() {
		return gaQVTcoreBase.getTupleLiteralExpCSAccess();
	}
	
	public ParserRule getTupleLiteralExpCSRule() {
		return getTupleLiteralExpCSAccess().getRule();
	}

	//TupleLiteralPartCS:
	//	name=UnrestrictedName (":" ownedType=TypeExpCS)? "=" ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.TupleLiteralPartCSElements getTupleLiteralPartCSAccess() {
		return gaQVTcoreBase.getTupleLiteralPartCSAccess();
	}
	
	public ParserRule getTupleLiteralPartCSRule() {
		return getTupleLiteralPartCSAccess().getRule();
	}

	//NumberLiteralExpCS:
	//	symbol=NUMBER_LITERAL;
	public EssentialOCLGrammarAccess.NumberLiteralExpCSElements getNumberLiteralExpCSAccess() {
		return gaQVTcoreBase.getNumberLiteralExpCSAccess();
	}
	
	public ParserRule getNumberLiteralExpCSRule() {
		return getNumberLiteralExpCSAccess().getRule();
	}

	//StringLiteralExpCS:
	//	segments+=StringLiteral+;
	public EssentialOCLGrammarAccess.StringLiteralExpCSElements getStringLiteralExpCSAccess() {
		return gaQVTcoreBase.getStringLiteralExpCSAccess();
	}
	
	public ParserRule getStringLiteralExpCSRule() {
		return getStringLiteralExpCSAccess().getRule();
	}

	//BooleanLiteralExpCS:
	//	symbol="true" | symbol="false";
	public EssentialOCLGrammarAccess.BooleanLiteralExpCSElements getBooleanLiteralExpCSAccess() {
		return gaQVTcoreBase.getBooleanLiteralExpCSAccess();
	}
	
	public ParserRule getBooleanLiteralExpCSRule() {
		return getBooleanLiteralExpCSAccess().getRule();
	}

	//UnlimitedNaturalLiteralExpCS:
	//	{UnlimitedNaturalLiteralExpCS} "*";
	public EssentialOCLGrammarAccess.UnlimitedNaturalLiteralExpCSElements getUnlimitedNaturalLiteralExpCSAccess() {
		return gaQVTcoreBase.getUnlimitedNaturalLiteralExpCSAccess();
	}
	
	public ParserRule getUnlimitedNaturalLiteralExpCSRule() {
		return getUnlimitedNaturalLiteralExpCSAccess().getRule();
	}

	//InvalidLiteralExpCS:
	//	{InvalidLiteralExpCS} "invalid";
	public EssentialOCLGrammarAccess.InvalidLiteralExpCSElements getInvalidLiteralExpCSAccess() {
		return gaQVTcoreBase.getInvalidLiteralExpCSAccess();
	}
	
	public ParserRule getInvalidLiteralExpCSRule() {
		return getInvalidLiteralExpCSAccess().getRule();
	}

	//NullLiteralExpCS:
	//	{NullLiteralExpCS} "null";
	public EssentialOCLGrammarAccess.NullLiteralExpCSElements getNullLiteralExpCSAccess() {
		return gaQVTcoreBase.getNullLiteralExpCSAccess();
	}
	
	public ParserRule getNullLiteralExpCSRule() {
		return getNullLiteralExpCSAccess().getRule();
	}

	//TypeLiteralCS returns base::TypedRefCS:
	//	PrimitiveTypeCS | CollectionTypeCS | MapTypeCS | TupleTypeCS;
	public EssentialOCLGrammarAccess.TypeLiteralCSElements getTypeLiteralCSAccess() {
		return gaQVTcoreBase.getTypeLiteralCSAccess();
	}
	
	public ParserRule getTypeLiteralCSRule() {
		return getTypeLiteralCSAccess().getRule();
	}

	//TypeLiteralWithMultiplicityCS returns base::TypedRefCS:
	//	TypeLiteralCS ownedMultiplicity=MultiplicityCS?;
	public EssentialOCLGrammarAccess.TypeLiteralWithMultiplicityCSElements getTypeLiteralWithMultiplicityCSAccess() {
		return gaQVTcoreBase.getTypeLiteralWithMultiplicityCSAccess();
	}
	
	public ParserRule getTypeLiteralWithMultiplicityCSRule() {
		return getTypeLiteralWithMultiplicityCSAccess().getRule();
	}

	//TypeLiteralExpCS:
	//	ownedType=TypeLiteralWithMultiplicityCS;
	public EssentialOCLGrammarAccess.TypeLiteralExpCSElements getTypeLiteralExpCSAccess() {
		return gaQVTcoreBase.getTypeLiteralExpCSAccess();
	}
	
	public ParserRule getTypeLiteralExpCSRule() {
		return getTypeLiteralExpCSAccess().getRule();
	}

	//TypeNameExpCS:
	//	ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ("{" ownedPatternGuard=ExpCS "}")?)?;
	public EssentialOCLGrammarAccess.TypeNameExpCSElements getTypeNameExpCSAccess() {
		return gaQVTcoreBase.getTypeNameExpCSAccess();
	}
	
	public ParserRule getTypeNameExpCSRule() {
		return getTypeNameExpCSAccess().getRule();
	}

	//TypeExpCS returns base::TypedRefCS:
	//	(TypeNameExpCS | TypeLiteralCS | CollectionPatternCS) ownedMultiplicity=MultiplicityCS?;
	public EssentialOCLGrammarAccess.TypeExpCSElements getTypeExpCSAccess() {
		return gaQVTcoreBase.getTypeExpCSAccess();
	}
	
	public ParserRule getTypeExpCSRule() {
		return getTypeExpCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	// //  Expressions
	//
	////---------------------------------------------------------------------
	//
	//// An ExpCS permits a LetExpCS only in the final term to ensure
	//
	////  that let is right associative, whereas infix operators are left associative.
	//
	////   a = 64 / 16 / let b : Integer in 8 / let c : Integer in 4 
	// // is
	//
	////   a = (64 / 16) / (let b : Integer in 8 / (let c : Integer in 4 ))
	//
	/// * An expression elaborates a prefixed expression with zero or more binary operator and expression suffixes.
	// * An optionally prefixed let expression is permitted except when suffixed with further expressions.* /
	//ExpCS:
	//	PrefixedPrimaryExpCS ({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)?
	//	//	({InfixExpCS} ownedSource=PrefixedExpCS name=BinaryOperatorName ownedArgument=ExpCS)
	// //| 	PrefixedExpCS
	//
	//	// the above takes exponential or worse time for backtracking, below is fast
	// | PrefixedLetExpCS;
	public EssentialOCLGrammarAccess.ExpCSElements getExpCSAccess() {
		return gaQVTcoreBase.getExpCSAccess();
	}
	
	public ParserRule getExpCSRule() {
		return getExpCSAccess().getRule();
	}

	/// * A prefixed let expression elaborates a let expression with zero or more unary prefix operators. * / PrefixedLetExpCS
	//returns ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS | LetExpCS;
	public EssentialOCLGrammarAccess.PrefixedLetExpCSElements getPrefixedLetExpCSAccess() {
		return gaQVTcoreBase.getPrefixedLetExpCSAccess();
	}
	
	public ParserRule getPrefixedLetExpCSRule() {
		return getPrefixedLetExpCSAccess().getRule();
	}

	/// * A prefixed primary expression elaborates a primary expression with zero or more unary prefix operators. * /
	//PrefixedPrimaryExpCS returns ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS | PrimaryExpCS;
	public EssentialOCLGrammarAccess.PrefixedPrimaryExpCSElements getPrefixedPrimaryExpCSAccess() {
		return gaQVTcoreBase.getPrefixedPrimaryExpCSAccess();
	}
	
	public ParserRule getPrefixedPrimaryExpCSRule() {
		return getPrefixedPrimaryExpCSAccess().getRule();
	}

	/// * A primary expression identifies the basic expressions from which more complex expressions may be constructed. * /
	//PrimaryExpCS returns ExpCS:
	//	NestedExpCS | IfExpCS | SelfExpCS | PrimitiveLiteralExpCS | TupleLiteralExpCS | MapLiteralExpCS |
	//	CollectionLiteralExpCS | LambdaLiteralExpCS | TypeLiteralExpCS | NameExpCS;
	public EssentialOCLGrammarAccess.PrimaryExpCSElements getPrimaryExpCSAccess() {
		return gaQVTcoreBase.getPrimaryExpCSAccess();
	}
	
	public ParserRule getPrimaryExpCSRule() {
		return getPrimaryExpCSAccess().getRule();
	}

	/// * A name expression is a generalised rule for expressions that start with a name and which may be followed by square, round or
	// * curly bracket clauses and optionally an @pre as well.* /
	//NameExpCS:
	//	ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS*
	//	ownedRoundBracketedClause=RoundBracketedClauseCS? ownedCurlyBracketedClause=CurlyBracketedClauseCS? (isPre?="@"
	//	"pre")?;
	public EssentialOCLGrammarAccess.NameExpCSElements getNameExpCSAccess() {
		return gaQVTcoreBase.getNameExpCSAccess();
	}
	
	public ParserRule getNameExpCSRule() {
		return getNameExpCSAccess().getRule();
	}

	/// * A curly bracket clause is a generalized rule for the literal arguments of collections, maps, tuples and shadows.* /
	//CurlyBracketedClauseCS:
	//	{CurlyBracketedClauseCS} "{" ((ownedParts+=ShadowPartCS ("," ownedParts+=ShadowPartCS)*)? | value=StringLiteral) "}";
	public EssentialOCLGrammarAccess.CurlyBracketedClauseCSElements getCurlyBracketedClauseCSAccess() {
		return gaQVTcoreBase.getCurlyBracketedClauseCSAccess();
	}
	
	public ParserRule getCurlyBracketedClauseCSRule() {
		return getCurlyBracketedClauseCSAccess().getRule();
	}

	/// * A curly bracket clause is a generalized rule for template specialisations and operations arguments.* /
	//RoundBracketedClauseCS:
	//	{RoundBracketedClauseCS} "(" (ownedArguments+=NavigatingArgCS ownedArguments+=NavigatingCommaArgCS*
	//	(ownedArguments+=NavigatingSemiArgCS ownedArguments+=NavigatingCommaArgCS*)? (ownedArguments+=NavigatingBarArgCS
	//	ownedArguments+=NavigatingCommaArgCS*)*)? ")";
	public EssentialOCLGrammarAccess.RoundBracketedClauseCSElements getRoundBracketedClauseCSAccess() {
		return gaQVTcoreBase.getRoundBracketedClauseCSAccess();
	}
	
	public ParserRule getRoundBracketedClauseCSRule() {
		return getRoundBracketedClauseCSAccess().getRule();
	}

	/// * A square bracket clause is a generalized rule for association class qualifiers and roles.* / SquareBracketedClauseCS:
	//	"[" ownedTerms+=ExpCS ("," ownedTerms+=ExpCS)* "]";
	public EssentialOCLGrammarAccess.SquareBracketedClauseCSElements getSquareBracketedClauseCSAccess() {
		return gaQVTcoreBase.getSquareBracketedClauseCSAccess();
	}
	
	public ParserRule getSquareBracketedClauseCSRule() {
		return getSquareBracketedClauseCSAccess().getRule();
	}

	/// * A navigating argument is a generalized rule for the first argument in a round bracket clause. This is typically the first operation
	// * parameter or an iterator. * /
	//// Type-less init is an illegal infix expression
	// NavigatingArgCS:
	//	ownedNameExpression=NavigatingArgExpCS (":" ownedType=TypeExpCS ("=" ownedInitExpression=ExpCS)? | "in"
	//	ownedInitExpression=ExpCS)? | ":" ownedType=TypeExpCS;
	public EssentialOCLGrammarAccess.NavigatingArgCSElements getNavigatingArgCSAccess() {
		return gaQVTcoreBase.getNavigatingArgCSAccess();
	}
	
	public ParserRule getNavigatingArgCSRule() {
		return getNavigatingArgCSAccess().getRule();
	}

	/// * A navigating bar argument is a generalized rule for a bar-prefixed argument in a round bracket clause. This is typically the body of an iteration. * /
	//// Type-less init is an illegal infix expression
	// NavigatingBarArgCS returns NavigatingArgCS:
	//	prefix="|" ownedNameExpression=NavigatingArgExpCS (":" ownedType=TypeExpCS ("=" ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingBarArgCSElements getNavigatingBarArgCSAccess() {
		return gaQVTcoreBase.getNavigatingBarArgCSAccess();
	}
	
	public ParserRule getNavigatingBarArgCSRule() {
		return getNavigatingBarArgCSAccess().getRule();
	}

	/// * A navigating comma argument is a generalized rule for non-first argument in a round bracket clause. These are typically non-first operation
	// * parameters or a second iterator. * /
	//// Type-less init is an illegal infix expression
	// NavigatingCommaArgCS returns NavigatingArgCS:
	//	prefix="," ownedNameExpression=NavigatingArgExpCS (":" ownedType=TypeExpCS ("=" ownedInitExpression=ExpCS)? | "in"
	//	ownedInitExpression=ExpCS)?;
	public EssentialOCLGrammarAccess.NavigatingCommaArgCSElements getNavigatingCommaArgCSAccess() {
		return gaQVTcoreBase.getNavigatingCommaArgCSAccess();
	}
	
	public ParserRule getNavigatingCommaArgCSRule() {
		return getNavigatingCommaArgCSAccess().getRule();
	}

	/// * A navigating semi argument is a generalized rule for a semicolon prefixed argument in a round bracket clause. This is typically an iterate accumulator. * /
	//// Type-less init is an illegal infix expression
	// NavigatingSemiArgCS returns NavigatingArgCS:
	//	prefix=";" ownedNameExpression=NavigatingArgExpCS (":" ownedType=TypeExpCS ("=" ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingSemiArgCSElements getNavigatingSemiArgCSAccess() {
		return gaQVTcoreBase.getNavigatingSemiArgCSAccess();
	}
	
	public ParserRule getNavigatingSemiArgCSRule() {
		return getNavigatingSemiArgCSAccess().getRule();
	}

	//// Intended to be overridden
	// //	'?'	-- defined by Complete OCL
	// NavigatingArgExpCS returns ExpCS:
	//	ExpCS;
	public EssentialOCLGrammarAccess.NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return gaQVTcoreBase.getNavigatingArgExpCSAccess();
	}
	
	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//IfExpCS:
	//	"if" ownedCondition=(ExpCS | PatternExpCS) "then" ownedThenExpression=ExpCS //	ifThenExpressions+=IfThenExpCS
	//
	//	ownedIfThenExpressions+=ElseIfThenExpCS* "else" ownedElseExpression=ExpCS "endif";
	public EssentialOCLGrammarAccess.IfExpCSElements getIfExpCSAccess() {
		return gaQVTcoreBase.getIfExpCSAccess();
	}
	
	public ParserRule getIfExpCSRule() {
		return getIfExpCSAccess().getRule();
	}

	////IfThenExpCS returns IfThenExpCS:
	// //	'if' condition=ExpCS
	// //	'then' thenExpression=ExpCS
	// //;
	// ElseIfThenExpCS
	//returns IfThenExpCS:
	//	"elseif" ownedCondition=ExpCS "then" ownedThenExpression=ExpCS;
	public EssentialOCLGrammarAccess.ElseIfThenExpCSElements getElseIfThenExpCSAccess() {
		return gaQVTcoreBase.getElseIfThenExpCSAccess();
	}
	
	public ParserRule getElseIfThenExpCSRule() {
		return getElseIfThenExpCSAccess().getRule();
	}

	//LetExpCS:
	//	"let" ownedVariables+=LetVariableCS ("," ownedVariables+=LetVariableCS)* "in" ownedInExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetExpCSElements getLetExpCSAccess() {
		return gaQVTcoreBase.getLetExpCSAccess();
	}
	
	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS:
	//	name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (":" ownedType=TypeExpCS)? "="
	//	ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetVariableCSElements getLetVariableCSAccess() {
		return gaQVTcoreBase.getLetVariableCSAccess();
	}
	
	public ParserRule getLetVariableCSRule() {
		return getLetVariableCSAccess().getRule();
	}

	//NestedExpCS:
	//	"(" ownedExpression=ExpCS ")";
	public EssentialOCLGrammarAccess.NestedExpCSElements getNestedExpCSAccess() {
		return gaQVTcoreBase.getNestedExpCSAccess();
	}
	
	public ParserRule getNestedExpCSRule() {
		return getNestedExpCSAccess().getRule();
	}

	//SelfExpCS:
	//	{SelfExpCS} "self";
	public EssentialOCLGrammarAccess.SelfExpCSElements getSelfExpCSAccess() {
		return gaQVTcoreBase.getSelfExpCSAccess();
	}
	
	public ParserRule getSelfExpCSRule() {
		return getSelfExpCSAccess().getRule();
	}

	//MultiplicityBoundsCS:
	//	lowerBound=LOWER (".." upperBound=UPPER)?;
	public BaseGrammarAccess.MultiplicityBoundsCSElements getMultiplicityBoundsCSAccess() {
		return gaQVTcoreBase.getMultiplicityBoundsCSAccess();
	}
	
	public ParserRule getMultiplicityBoundsCSRule() {
		return getMultiplicityBoundsCSAccess().getRule();
	}

	//MultiplicityCS:
	//	"[" (MultiplicityBoundsCS | MultiplicityStringCS) ("|?" | isNullFree?="|1")? "]";
	public BaseGrammarAccess.MultiplicityCSElements getMultiplicityCSAccess() {
		return gaQVTcoreBase.getMultiplicityCSAccess();
	}
	
	public ParserRule getMultiplicityCSRule() {
		return getMultiplicityCSAccess().getRule();
	}

	//MultiplicityStringCS:
	//	stringBounds=("*" | "+" | "?");
	public BaseGrammarAccess.MultiplicityStringCSElements getMultiplicityStringCSAccess() {
		return gaQVTcoreBase.getMultiplicityStringCSAccess();
	}
	
	public ParserRule getMultiplicityStringCSRule() {
		return getMultiplicityStringCSAccess().getRule();
	}

	//PathNameCS:
	//	ownedPathElements+=FirstPathElementCS ("::" ownedPathElements+=NextPathElementCS)*;
	public BaseGrammarAccess.PathNameCSElements getPathNameCSAccess() {
		return gaQVTcoreBase.getPathNameCSAccess();
	}
	
	public ParserRule getPathNameCSRule() {
		return getPathNameCSAccess().getRule();
	}

	//FirstPathElementCS returns PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName];
	public BaseGrammarAccess.FirstPathElementCSElements getFirstPathElementCSAccess() {
		return gaQVTcoreBase.getFirstPathElementCSAccess();
	}
	
	public ParserRule getFirstPathElementCSRule() {
		return getFirstPathElementCSAccess().getRule();
	}

	//NextPathElementCS returns PathElementCS:
	//	referredElement=[pivot::NamedElement|UnreservedName];
	public BaseGrammarAccess.NextPathElementCSElements getNextPathElementCSAccess() {
		return gaQVTcoreBase.getNextPathElementCSAccess();
	}
	
	public ParserRule getNextPathElementCSRule() {
		return getNextPathElementCSAccess().getRule();
	}

	//TemplateBindingCS:
	//	ownedSubstitutions+=TemplateParameterSubstitutionCS ("," ownedSubstitutions+=TemplateParameterSubstitutionCS)*
	//	ownedMultiplicity=MultiplicityCS?;
	public BaseGrammarAccess.TemplateBindingCSElements getTemplateBindingCSAccess() {
		return gaQVTcoreBase.getTemplateBindingCSAccess();
	}
	
	public ParserRule getTemplateBindingCSRule() {
		return getTemplateBindingCSAccess().getRule();
	}

	//TemplateParameterSubstitutionCS:
	//	ownedActualParameter=TypeRefCS;
	public BaseGrammarAccess.TemplateParameterSubstitutionCSElements getTemplateParameterSubstitutionCSAccess() {
		return gaQVTcoreBase.getTemplateParameterSubstitutionCSAccess();
	}
	
	public ParserRule getTemplateParameterSubstitutionCSRule() {
		return getTemplateParameterSubstitutionCSAccess().getRule();
	}

	//TemplateSignatureCS:
	//	"(" ownedParameters+=TypeParameterCS ("," ownedParameters+=TypeParameterCS)* ")";
	public BaseGrammarAccess.TemplateSignatureCSElements getTemplateSignatureCSAccess() {
		return gaQVTcoreBase.getTemplateSignatureCSAccess();
	}
	
	public ParserRule getTemplateSignatureCSRule() {
		return getTemplateSignatureCSAccess().getRule();
	}

	//TypeParameterCS:
	//	name=UnrestrictedName ("extends" ownedExtends+=TypedRefCS ("&&" ownedExtends+=TypedRefCS)*)?;
	public BaseGrammarAccess.TypeParameterCSElements getTypeParameterCSAccess() {
		return gaQVTcoreBase.getTypeParameterCSAccess();
	}
	
	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS:
	//	TypedRefCS | WildcardTypeRefCS;
	public BaseGrammarAccess.TypeRefCSElements getTypeRefCSAccess() {
		return gaQVTcoreBase.getTypeRefCSAccess();
	}
	
	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//TypedRefCS:
	//	TypedTypeRefCS;
	public BaseGrammarAccess.TypedRefCSElements getTypedRefCSAccess() {
		return gaQVTcoreBase.getTypedRefCSAccess();
	}
	
	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//TypedTypeRefCS:
	//	ownedPathName=PathNameCS ("(" ownedBinding=TemplateBindingCS ")")?;
	public BaseGrammarAccess.TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return gaQVTcoreBase.getTypedTypeRefCSAccess();
	}
	
	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//WildcardTypeRefCS:
	//	{WildcardTypeRefCS} "?" ("extends" ownedExtends=TypedRefCS)?;
	public BaseGrammarAccess.WildcardTypeRefCSElements getWildcardTypeRefCSAccess() {
		return gaQVTcoreBase.getWildcardTypeRefCSAccess();
	}
	
	public ParserRule getWildcardTypeRefCSRule() {
		return getWildcardTypeRefCSAccess().getRule();
	}

	//ID:
	//	SIMPLE_ID | ESCAPED_ID;
	public BaseGrammarAccess.IDElements getIDAccess() {
		return gaQVTcoreBase.getIDAccess();
	}
	
	public ParserRule getIDRule() {
		return getIDAccess().getRule();
	}

	//Identifier:
	//	ID;
	public BaseGrammarAccess.IdentifierElements getIdentifierAccess() {
		return gaQVTcoreBase.getIdentifierAccess();
	}
	
	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}

	/// * A lowerbounded integer is used to define the lowerbound of a collection multiplicity. The value may not be the unlimited value. * /
	//LOWER returns ecore::EInt:
	//	INT;
	public BaseGrammarAccess.LOWERElements getLOWERAccess() {
		return gaQVTcoreBase.getLOWERAccess();
	}
	
	public ParserRule getLOWERRule() {
		return getLOWERAccess().getRule();
	}

	/// * A number may be an integer or floating point value. The declaration here appears to be that for just an integer. This is to avoid
	// * lookahead conflicts in simple lexers between a dot within a floating point number and the dot-dot in a CollectionLiteralPartCS. A
	// * practical implementation should give high priority to a successful parse of INT ('.' INT)? (('e' | 'E') ('+' | '-')? INT)? than
	// * to the unsuccessful partial parse of INT '..'. The type of the INT terminal is String to allow the floating point syntax to be used.
	// * /
	//// Not terminal to allow parser backtracking to sort out "5..7"
	//
	//// EssentialOCLTokenSource pieces this together ('.' INT)? (('e' | 'E') ('+' | '-')? INT)?;
	// NUMBER_LITERAL returns
	//BigNumber:
	//	INT;
	public BaseGrammarAccess.NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return gaQVTcoreBase.getNUMBER_LITERALAccess();
	}
	
	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//StringLiteral:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.StringLiteralElements getStringLiteralAccess() {
		return gaQVTcoreBase.getStringLiteralAccess();
	}
	
	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}

	/// * An upperbounded integer is used to define the upperbound of a collection multiplicity. The value may be the unlimited value. * /
	//UPPER returns ecore::EInt:
	//	INT | "*";
	public BaseGrammarAccess.UPPERElements getUPPERAccess() {
		return gaQVTcoreBase.getUPPERAccess();
	}
	
	public ParserRule getUPPERRule() {
		return getUPPERAccess().getRule();
	}

	//URI:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.URIElements getURIAccess() {
		return gaQVTcoreBase.getURIAccess();
	}
	
	public ParserRule getURIRule() {
		return getURIAccess().getRule();
	}

	//terminal fragment ESCAPED_CHARACTER:
	//	"\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\");
	public TerminalRule getESCAPED_CHARACTERRule() {
		return gaQVTcoreBase.getESCAPED_CHARACTERRule();
	} 

	//terminal fragment LETTER_CHARACTER:
	//	"a".."z" | "A".."Z" | "_";
	public TerminalRule getLETTER_CHARACTERRule() {
		return gaQVTcoreBase.getLETTER_CHARACTERRule();
	} 

	//terminal DOUBLE_QUOTED_STRING:
	//	"\"" (ESCAPED_CHARACTER | !("\\" | "\""))* "\"";
	public TerminalRule getDOUBLE_QUOTED_STRINGRule() {
		return gaQVTcoreBase.getDOUBLE_QUOTED_STRINGRule();
	} 

	//terminal SINGLE_QUOTED_STRING:
	//	"\'" (ESCAPED_CHARACTER | !("\\" | "\'"))* "\'";
	public TerminalRule getSINGLE_QUOTED_STRINGRule() {
		return gaQVTcoreBase.getSINGLE_QUOTED_STRINGRule();
	} 

	//terminal ML_SINGLE_QUOTED_STRING:
	//	"/\'"->"\'/";
	public TerminalRule getML_SINGLE_QUOTED_STRINGRule() {
		return gaQVTcoreBase.getML_SINGLE_QUOTED_STRINGRule();
	} 

	//terminal SIMPLE_ID:
	//	LETTER_CHARACTER (LETTER_CHARACTER | "0".."9")*;
	public TerminalRule getSIMPLE_IDRule() {
		return gaQVTcoreBase.getSIMPLE_IDRule();
	} 

	//terminal ESCAPED_ID:
	//	"_" SINGLE_QUOTED_STRING;
	public TerminalRule getESCAPED_IDRule() {
		return gaQVTcoreBase.getESCAPED_IDRule();
	} 

	//// String to allow diverse re-use
	// // multiple leading zeroes occur as floating point fractional part
	// terminal INT:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaQVTcoreBase.getINTRule();
	} 

	/// * A multi-line comment supports a comment that may span more than one line using familiar slash-star...star-slash comment delimiters * /
	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaQVTcoreBase.getML_COMMENTRule();
	} 

	/// * A single-line comment supports a comment that terminates at the end of the line * / terminal SL_COMMENT:
	//	"--" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaQVTcoreBase.getSL_COMMENTRule();
	} 

	/// * Whitespace may occur between any pair of tokens * / terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaQVTcoreBase.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaQVTcoreBase.getANY_OTHERRule();
	} 
}
