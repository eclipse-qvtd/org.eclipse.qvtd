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
package org.eclipse.qvtd.xtext.qvtcorebase.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class QVTcoreBaseGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class BottomPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BottomPatternCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Alternatives cAlternatives_0_1 = (Alternatives)cGroup_0.eContents().get(1);
		private final Assignment cOwnedUnrealizedVariablesAssignment_0_1_0 = (Assignment)cAlternatives_0_1.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_0_1_0.eContents().get(0);
		private final Assignment cOwnedRealizedVariablesAssignment_0_1_1 = (Assignment)cAlternatives_0_1.eContents().get(1);
		private final RuleCall cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0 = (RuleCall)cOwnedRealizedVariablesAssignment_0_1_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Alternatives cAlternatives_0_2_1 = (Alternatives)cGroup_0_2.eContents().get(1);
		private final Assignment cOwnedUnrealizedVariablesAssignment_0_2_1_0 = (Assignment)cAlternatives_0_2_1.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_0_2_1_0.eContents().get(0);
		private final Assignment cOwnedRealizedVariablesAssignment_0_2_1_1 = (Assignment)cAlternatives_0_2_1.eContents().get(1);
		private final RuleCall cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0 = (RuleCall)cOwnedRealizedVariablesAssignment_0_2_1_1.eContents().get(0);
		private final Keyword cVerticalLineKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Assignment cOwnedConstraintsAssignment_0_4 = (Assignment)cGroup_0.eContents().get(4);
		private final RuleCall cOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0 = (RuleCall)cOwnedConstraintsAssignment_0_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_0_5 = (Keyword)cGroup_0.eContents().get(5);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cOwnedUnrealizedVariablesAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_1_1_0.eContents().get(0);
		private final Assignment cOwnedRealizedVariablesAssignment_1_1_1 = (Assignment)cAlternatives_1_1.eContents().get(1);
		private final RuleCall cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0 = (RuleCall)cOwnedRealizedVariablesAssignment_1_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Alternatives cAlternatives_1_2_1 = (Alternatives)cGroup_1_2.eContents().get(1);
		private final Assignment cOwnedUnrealizedVariablesAssignment_1_2_1_0 = (Assignment)cAlternatives_1_2_1.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_1_2_1_0.eContents().get(0);
		private final Assignment cOwnedRealizedVariablesAssignment_1_2_1_1 = (Assignment)cAlternatives_1_2_1.eContents().get(1);
		private final RuleCall cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0 = (RuleCall)cOwnedRealizedVariablesAssignment_1_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cLeftCurlyBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedConstraintsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0 = (RuleCall)cOwnedConstraintsAssignment_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Action cBottomPatternCSAction_3_0 = (Action)cGroup_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//// Bug 466385 explains the redundancy below
		// BottomPatternCS:
		//	"{" (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (","
		//	(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* "|"
		//	ownedConstraints+=PredicateOrAssignmentCS* "}" | "{" (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//	ownedRealizedVariables+=RealizedVariableCS) ("," (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//	ownedRealizedVariables+=RealizedVariableCS))* "}" | "{" ownedConstraints+=PredicateOrAssignmentCS+ "}" |
		//	{BottomPatternCS} "{" "}";
		@Override public ParserRule getRule() { return rule; }

		//"{" (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (","
		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* "|"
		//ownedConstraints+=PredicateOrAssignmentCS* "}" | "{" (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//ownedRealizedVariables+=RealizedVariableCS) ("," (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//ownedRealizedVariables+=RealizedVariableCS))* "}" | "{" ownedConstraints+=PredicateOrAssignmentCS+ "}" |
		//{BottomPatternCS} "{" "}"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"{" (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (","
		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* "|"
		//ownedConstraints+=PredicateOrAssignmentCS* "}"
		public Group getGroup_0() { return cGroup_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0_0() { return cLeftCurlyBracketKeyword_0_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_1_0() { return cOwnedUnrealizedVariablesAssignment_0_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_0_1_1() { return cOwnedRealizedVariablesAssignment_0_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0; }

		//("," (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//","
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS
		public Alternatives getAlternatives_0_2_1() { return cAlternatives_0_2_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_2_1_0() { return cOwnedUnrealizedVariablesAssignment_0_2_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_0_2_1_1() { return cOwnedRealizedVariablesAssignment_0_2_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0; }

		//"|"
		public Keyword getVerticalLineKeyword_0_3() { return cVerticalLineKeyword_0_3; }

		//ownedConstraints+=PredicateOrAssignmentCS*
		public Assignment getOwnedConstraintsAssignment_0_4() { return cOwnedConstraintsAssignment_0_4; }

		//PredicateOrAssignmentCS
		public RuleCall getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0() { return cOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_0_5() { return cRightCurlyBracketKeyword_0_5; }

		//"{" (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (","
		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* "}"
		public Group getGroup_1() { return cGroup_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1_0() { return cLeftCurlyBracketKeyword_1_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_1_0() { return cOwnedUnrealizedVariablesAssignment_1_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_1_1_1() { return cOwnedRealizedVariablesAssignment_1_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0; }

		//("," (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//","
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS
		public Alternatives getAlternatives_1_2_1() { return cAlternatives_1_2_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_2_1_0() { return cOwnedUnrealizedVariablesAssignment_1_2_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_1_2_1_1() { return cOwnedRealizedVariablesAssignment_1_2_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_1_3() { return cRightCurlyBracketKeyword_1_3; }

		//"{" ownedConstraints+=PredicateOrAssignmentCS+ "}"
		public Group getGroup_2() { return cGroup_2; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//ownedConstraints+=PredicateOrAssignmentCS+
		public Assignment getOwnedConstraintsAssignment_2_1() { return cOwnedConstraintsAssignment_2_1; }

		//PredicateOrAssignmentCS
		public RuleCall getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0() { return cOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_2_2() { return cRightCurlyBracketKeyword_2_2; }

		//{BottomPatternCS} "{" "}"
		public Group getGroup_3() { return cGroup_3; }

		//{BottomPatternCS}
		public Action getBottomPatternCSAction_3_0() { return cBottomPatternCSAction_3_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3_1() { return cLeftCurlyBracketKeyword_3_1; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3_2() { return cRightCurlyBracketKeyword_3_2; }
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
		
		//DirectionCS:
		//	{DirectionCS} name=UnrestrictedName? ("imports" imports+=[pivot::Package|UnrestrictedName] (","
		//	imports+=[pivot::Package|UnrestrictedName])*)? ("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] (","
		//	uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?;
		@Override public ParserRule getRule() { return rule; }

		//{DirectionCS} name=UnrestrictedName? ("imports" imports+=[pivot::Package|UnrestrictedName] (","
		//imports+=[pivot::Package|UnrestrictedName])*)? ("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] (","
		//uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?
		public Group getGroup() { return cGroup; }

		//{DirectionCS}
		public Action getDirectionCSAction_0() { return cDirectionCSAction_0; }

		//name=UnrestrictedName?
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

	public class GuardPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "GuardPatternCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_0_2_1.eContents().get(0);
		private final Keyword cVerticalLineKeyword_0_3 = (Keyword)cGroup_0.eContents().get(3);
		private final Assignment cOwnedPredicatesAssignment_0_4 = (Assignment)cGroup_0.eContents().get(4);
		private final RuleCall cOwnedPredicatesPredicateCSParserRuleCall_0_4_0 = (RuleCall)cOwnedPredicatesAssignment_0_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_5 = (Keyword)cGroup_0.eContents().get(5);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_1_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedPredicatesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedPredicatesPredicateCSParserRuleCall_2_1_0 = (RuleCall)cOwnedPredicatesAssignment_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Action cGuardPatternCSAction_3_0 = (Action)cGroup_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		////EnforcementOperationCS: ('creation'|'deletion') ExpCS ';';
		// // Bug 466385 explains the redundancy below
		//
		//GuardPatternCS:
		//	"(" ownedUnrealizedVariables+=GuardVariableCS ("," ownedUnrealizedVariables+=GuardVariableCS)* "|"
		//	ownedPredicates+=PredicateCS* ")" | "(" ownedUnrealizedVariables+=GuardVariableCS (","
		//	ownedUnrealizedVariables+=GuardVariableCS)* ")" | "(" ownedPredicates+=PredicateCS+ ")" | {GuardPatternCS} "(" ")";
		@Override public ParserRule getRule() { return rule; }

		//"(" ownedUnrealizedVariables+=GuardVariableCS ("," ownedUnrealizedVariables+=GuardVariableCS)* "|"
		//ownedPredicates+=PredicateCS* ")" | "(" ownedUnrealizedVariables+=GuardVariableCS (","
		//ownedUnrealizedVariables+=GuardVariableCS)* ")" | "(" ownedPredicates+=PredicateCS+ ")" | {GuardPatternCS} "(" ")"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"(" ownedUnrealizedVariables+=GuardVariableCS ("," ownedUnrealizedVariables+=GuardVariableCS)* "|"
		//ownedPredicates+=PredicateCS* ")"
		public Group getGroup_0() { return cGroup_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_1() { return cOwnedUnrealizedVariablesAssignment_0_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0; }

		//("," ownedUnrealizedVariables+=GuardVariableCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//","
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_2_1() { return cOwnedUnrealizedVariablesAssignment_0_2_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0; }

		//"|"
		public Keyword getVerticalLineKeyword_0_3() { return cVerticalLineKeyword_0_3; }

		//ownedPredicates+=PredicateCS*
		public Assignment getOwnedPredicatesAssignment_0_4() { return cOwnedPredicatesAssignment_0_4; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_0_4_0() { return cOwnedPredicatesPredicateCSParserRuleCall_0_4_0; }

		//")"
		public Keyword getRightParenthesisKeyword_0_5() { return cRightParenthesisKeyword_0_5; }

		//"(" ownedUnrealizedVariables+=GuardVariableCS ("," ownedUnrealizedVariables+=GuardVariableCS)* ")"
		public Group getGroup_1() { return cGroup_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_1() { return cOwnedUnrealizedVariablesAssignment_1_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0; }

		//("," ownedUnrealizedVariables+=GuardVariableCS)*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//","
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_2_1() { return cOwnedUnrealizedVariablesAssignment_1_2_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_3() { return cRightParenthesisKeyword_1_3; }

		//"(" ownedPredicates+=PredicateCS+ ")"
		public Group getGroup_2() { return cGroup_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//ownedPredicates+=PredicateCS+
		public Assignment getOwnedPredicatesAssignment_2_1() { return cOwnedPredicatesAssignment_2_1; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_2_1_0() { return cOwnedPredicatesPredicateCSParserRuleCall_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }

		//{GuardPatternCS} "(" ")"
		public Group getGroup_3() { return cGroup_3; }

		//{GuardPatternCS}
		public Action getGuardPatternCSAction_3_0() { return cGuardPatternCSAction_3_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_3_1() { return cLeftParenthesisKeyword_3_1; }

		//")"
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
	}

	public class GuardVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "GuardVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);
		
		////Variable := VariableName �:� TypeDeclaration
		// GuardVariableCS returns UnrealizedVariableCS:
		//	name=UnrestrictedName ":" ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ":" ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_0; }
	}

	public class ImportCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ImportCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNameURIPathNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cIsAllAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final Keyword cIsAllColonColonKeyword_3_0_0 = (Keyword)cIsAllAssignment_3_0.eContents().get(0);
		private final Keyword cAsteriskKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//ImportCS returns base::ImportCS:
		//	"import" (name=Identifier ":")? ownedPathName=URIPathNameCS (isAll?="::" "*")? ";";
		@Override public ParserRule getRule() { return rule; }

		//"import" (name=Identifier ":")? ownedPathName=URIPathNameCS (isAll?="::" "*")? ";"
		public Group getGroup() { return cGroup; }

		//"import"
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//(name=Identifier ":")?
		public Group getGroup_1() { return cGroup_1; }

		//name=Identifier
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_1_0_0() { return cNameIdentifierParserRuleCall_1_0_0; }

		//":"
		public Keyword getColonKeyword_1_1() { return cColonKeyword_1_1; }

		//ownedPathName=URIPathNameCS
		public Assignment getOwnedPathNameAssignment_2() { return cOwnedPathNameAssignment_2; }

		//URIPathNameCS
		public RuleCall getOwnedPathNameURIPathNameCSParserRuleCall_2_0() { return cOwnedPathNameURIPathNameCSParserRuleCall_2_0; }

		//(isAll?="::" "*")?
		public Group getGroup_3() { return cGroup_3; }

		//isAll?="::"
		public Assignment getIsAllAssignment_3_0() { return cIsAllAssignment_3_0; }

		//"::"
		public Keyword getIsAllColonColonKeyword_3_0_0() { return cIsAllColonColonKeyword_3_0_0; }

		//"*"
		public Keyword getAsteriskKeyword_3_1() { return cAsteriskKeyword_3_1; }

		//";"
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class NamedDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NamedDomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsCheckAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsCheckCheckKeyword_0_0 = (Keyword)cIsCheckAssignment_0.eContents().get(0);
		private final Assignment cIsEnforceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsEnforceEnforceKeyword_1_0 = (Keyword)cIsEnforceAssignment_1.eContents().get(0);
		private final Assignment cDirectionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cDirectionTypedModelCrossReference_2_0 = (CrossReference)cDirectionAssignment_2.eContents().get(0);
		private final RuleCall cDirectionTypedModelUnrestrictedNameParserRuleCall_2_0_1 = (RuleCall)cDirectionTypedModelCrossReference_2_0.eContents().get(1);
		private final Assignment cOwnedGuardPatternAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedGuardPatternGuardPatternCSParserRuleCall_3_0 = (RuleCall)cOwnedGuardPatternAssignment_3.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedBottomPatternBottomPatternCSParserRuleCall_4_0 = (RuleCall)cOwnedBottomPatternAssignment_4.eContents().get(0);
		
		//NamedDomainCS returns DomainCS:
		//	isCheck?="check"? isEnforce?="enforce"? direction=[qvtbase::TypedModel|UnrestrictedName]
		//	ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//isCheck?="check"? isEnforce?="enforce"? direction=[qvtbase::TypedModel|UnrestrictedName]
		//ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		public Group getGroup() { return cGroup; }

		//isCheck?="check"?
		public Assignment getIsCheckAssignment_0() { return cIsCheckAssignment_0; }

		//"check"
		public Keyword getIsCheckCheckKeyword_0_0() { return cIsCheckCheckKeyword_0_0; }

		//isEnforce?="enforce"?
		public Assignment getIsEnforceAssignment_1() { return cIsEnforceAssignment_1; }

		//"enforce"
		public Keyword getIsEnforceEnforceKeyword_1_0() { return cIsEnforceEnforceKeyword_1_0; }

		//direction=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getDirectionAssignment_2() { return cDirectionAssignment_2; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getDirectionTypedModelCrossReference_2_0() { return cDirectionTypedModelCrossReference_2_0; }

		//UnrestrictedName
		public RuleCall getDirectionTypedModelUnrestrictedNameParserRuleCall_2_0_1() { return cDirectionTypedModelUnrestrictedNameParserRuleCall_2_0_1; }

		//ownedGuardPattern=GuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_3() { return cOwnedGuardPatternAssignment_3; }

		//GuardPatternCS
		public RuleCall getOwnedGuardPatternGuardPatternCSParserRuleCall_3_0() { return cOwnedGuardPatternGuardPatternCSParserRuleCall_3_0; }

		//ownedBottomPattern=BottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_4() { return cOwnedBottomPatternAssignment_4; }

		//BottomPatternCS
		public RuleCall getOwnedBottomPatternBottomPatternCSParserRuleCall_4_0() { return cOwnedBottomPatternBottomPatternCSParserRuleCall_4_0; }
	}

	public class ParamDeclarationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ParamDeclarationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);
		
		//ParamDeclarationCS:
		//	name=UnrestrictedName ":" ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ":" ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_0; }
	}

	public class PredicateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PredicateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedConditionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedConditionExpCSParserRuleCall_0_0 = (RuleCall)cOwnedConditionAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//PredicateCS:
		//	ownedCondition=ExpCS ";";
		@Override public ParserRule getRule() { return rule; }

		//ownedCondition=ExpCS ";"
		public Group getGroup() { return cGroup; }

		//ownedCondition=ExpCS
		public Assignment getOwnedConditionAssignment_0() { return cOwnedConditionAssignment_0; }

		//ExpCS
		public RuleCall getOwnedConditionExpCSParserRuleCall_0_0() { return cOwnedConditionExpCSParserRuleCall_0_0; }

		//";"
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class PredicateOrAssignmentCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PredicateOrAssignmentCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsDefaultAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsDefaultDefaultKeyword_0_0 = (Keyword)cIsDefaultAssignment_0.eContents().get(0);
		private final Assignment cOwnedTargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedTargetExpCSParserRuleCall_1_0 = (RuleCall)cOwnedTargetAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonEqualsSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		////Constraint ::= Predicate | Assignment
		// //Predicate ::= BooleanOCLExpr
		//
		////Assignement ::= [�default�] SlotOwnerOCLExpr�.�PropertyName �:=� ValueOCLExpr
		// PredicateOrAssignmentCS:
		//	isDefault?="default"? ownedTarget=ExpCS (":=" ownedInitExpression=ExpCS)? ";";
		@Override public ParserRule getRule() { return rule; }

		//isDefault?="default"? ownedTarget=ExpCS (":=" ownedInitExpression=ExpCS)? ";"
		public Group getGroup() { return cGroup; }

		//isDefault?="default"?
		public Assignment getIsDefaultAssignment_0() { return cIsDefaultAssignment_0; }

		//"default"
		public Keyword getIsDefaultDefaultKeyword_0_0() { return cIsDefaultDefaultKeyword_0_0; }

		//ownedTarget=ExpCS
		public Assignment getOwnedTargetAssignment_1() { return cOwnedTargetAssignment_1; }

		//ExpCS
		public RuleCall getOwnedTargetExpCSParserRuleCall_1_0() { return cOwnedTargetExpCSParserRuleCall_1_0; }

		//(":=" ownedInitExpression=ExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//":="
		public Keyword getColonEqualsSignKeyword_2_0() { return cColonEqualsSignKeyword_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_1() { return cOwnedInitExpressionAssignment_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_1_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class QueryCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QueryCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cQueryKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNameScopeNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cOwnedParametersAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final RuleCall cOwnedParametersParamDeclarationCSParserRuleCall_4_0_0 = (RuleCall)cOwnedParametersAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0 = (RuleCall)cOwnedParametersAssignment_4_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cOwnedTypeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_7_0 = (RuleCall)cOwnedTypeAssignment_7.eContents().get(0);
		private final Alternatives cAlternatives_8 = (Alternatives)cGroup.eContents().get(8);
		private final Keyword cSemicolonKeyword_8_0 = (Keyword)cAlternatives_8.eContents().get(0);
		private final Group cGroup_8_1 = (Group)cAlternatives_8.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_8_1_0 = (Keyword)cGroup_8_1.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_8_1_1 = (Assignment)cGroup_8_1.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_8_1_1_0 = (RuleCall)cOwnedExpressionAssignment_8_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8_1_2 = (Keyword)cGroup_8_1.eContents().get(2);
		
		//QueryCS:
		//	"query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" (ownedParameters+=ParamDeclarationCS (","
		//	ownedParameters+=ParamDeclarationCS)*)? ")" ":" ownedType=TypeExpCS (";" | "{" ownedExpression=ExpCS "}");
		@Override public ParserRule getRule() { return rule; }

		//"query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" (ownedParameters+=ParamDeclarationCS (","
		//ownedParameters+=ParamDeclarationCS)*)? ")" ":" ownedType=TypeExpCS (";" | "{" ownedExpression=ExpCS "}")
		public Group getGroup() { return cGroup; }

		//"query"
		public Keyword getQueryKeyword_0() { return cQueryKeyword_0; }

		//ownedPathName=ScopeNameCS
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//ScopeNameCS
		public RuleCall getOwnedPathNameScopeNameCSParserRuleCall_1_0() { return cOwnedPathNameScopeNameCSParserRuleCall_1_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//(ownedParameters+=ParamDeclarationCS ("," ownedParameters+=ParamDeclarationCS)*)?
		public Group getGroup_4() { return cGroup_4; }

		//ownedParameters+=ParamDeclarationCS
		public Assignment getOwnedParametersAssignment_4_0() { return cOwnedParametersAssignment_4_0; }

		//ParamDeclarationCS
		public RuleCall getOwnedParametersParamDeclarationCSParserRuleCall_4_0_0() { return cOwnedParametersParamDeclarationCSParserRuleCall_4_0_0; }

		//("," ownedParameters+=ParamDeclarationCS)*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//","
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//ownedParameters+=ParamDeclarationCS
		public Assignment getOwnedParametersAssignment_4_1_1() { return cOwnedParametersAssignment_4_1_1; }

		//ParamDeclarationCS
		public RuleCall getOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0() { return cOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//":"
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_7() { return cOwnedTypeAssignment_7; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_7_0() { return cOwnedTypeTypeExpCSParserRuleCall_7_0; }

		//";" | "{" ownedExpression=ExpCS "}"
		public Alternatives getAlternatives_8() { return cAlternatives_8; }

		//";"
		public Keyword getSemicolonKeyword_8_0() { return cSemicolonKeyword_8_0; }

		//"{" ownedExpression=ExpCS "}"
		public Group getGroup_8_1() { return cGroup_8_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_8_1_0() { return cLeftCurlyBracketKeyword_8_1_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_8_1_1() { return cOwnedExpressionAssignment_8_1_1; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_8_1_1_0() { return cOwnedExpressionExpCSParserRuleCall_8_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_8_1_2() { return cRightCurlyBracketKeyword_8_1_2; }
	}

	public class ScopeNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ScopeNameCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathElementsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathElementsFirstPathElementCSParserRuleCall_0_0 = (RuleCall)cOwnedPathElementsAssignment_0.eContents().get(0);
		private final Keyword cColonColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedPathElementsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0 = (RuleCall)cOwnedPathElementsAssignment_2_0.eContents().get(0);
		private final Keyword cColonColonKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		
		////<query> ::= 'query' <PathNameCS> 
		// //            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
		//
		////      	  ':' <TypeCS>
		// //            (';' | '{' <OCLExpressionCS> '}')
		// ScopeNameCS returns base::PathNameCS:
		//	ownedPathElements+=FirstPathElementCS "::" (ownedPathElements+=NextPathElementCS "::")*;
		@Override public ParserRule getRule() { return rule; }

		//ownedPathElements+=FirstPathElementCS "::" (ownedPathElements+=NextPathElementCS "::")*
		public Group getGroup() { return cGroup; }

		//ownedPathElements+=FirstPathElementCS
		public Assignment getOwnedPathElementsAssignment_0() { return cOwnedPathElementsAssignment_0; }

		//FirstPathElementCS
		public RuleCall getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0() { return cOwnedPathElementsFirstPathElementCSParserRuleCall_0_0; }

		//"::"
		public Keyword getColonColonKeyword_1() { return cColonColonKeyword_1; }

		//(ownedPathElements+=NextPathElementCS "::")*
		public Group getGroup_2() { return cGroup_2; }

		//ownedPathElements+=NextPathElementCS
		public Assignment getOwnedPathElementsAssignment_2_0() { return cOwnedPathElementsAssignment_2_0; }

		//NextPathElementCS
		public RuleCall getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0() { return cOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0; }

		//"::"
		public Keyword getColonColonKeyword_2_1() { return cColonColonKeyword_2_1; }
	}

	public class TransformationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TransformationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTransformationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNameScopeNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnreservedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cOwnedDirectionsAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final RuleCall cOwnedDirectionsDirectionCSParserRuleCall_4_0_0 = (RuleCall)cOwnedDirectionsAssignment_4_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//TransformationCS:
		//	"transformation" ownedPathName=ScopeNameCS? name=UnreservedName "{" (ownedDirections+=DirectionCS ";")* "}";
		@Override public ParserRule getRule() { return rule; }

		//"transformation" ownedPathName=ScopeNameCS? name=UnreservedName "{" (ownedDirections+=DirectionCS ";")* "}"
		public Group getGroup() { return cGroup; }

		//"transformation"
		public Keyword getTransformationKeyword_0() { return cTransformationKeyword_0; }

		//ownedPathName=ScopeNameCS?
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//ScopeNameCS
		public RuleCall getOwnedPathNameScopeNameCSParserRuleCall_1_0() { return cOwnedPathNameScopeNameCSParserRuleCall_1_0; }

		//name=UnreservedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnreservedName
		public RuleCall getNameUnreservedNameParserRuleCall_2_0() { return cNameUnreservedNameParserRuleCall_2_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//(ownedDirections+=DirectionCS ";")*
		public Group getGroup_4() { return cGroup_4; }

		//ownedDirections+=DirectionCS
		public Assignment getOwnedDirectionsAssignment_4_0() { return cOwnedDirectionsAssignment_4_0; }

		//DirectionCS
		public RuleCall getOwnedDirectionsDirectionCSParserRuleCall_4_0_0() { return cOwnedDirectionsDirectionCSParserRuleCall_4_0_0; }

		//";"
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class UnrealizedVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnrealizedVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonEqualsSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_1.eContents().get(0);
		
		////Variable := VariableName �:� TypeDeclaration
		// UnrealizedVariableCS:
		//	name=UnrestrictedName (":" ownedType=TypeExpCS)? (":=" ownedInitExpression=ExpCS)?;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (":" ownedType=TypeExpCS)? (":=" ownedInitExpression=ExpCS)?
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

		//(":=" ownedInitExpression=ExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//":="
		public Keyword getColonEqualsSignKeyword_2_0() { return cColonEqualsSignKeyword_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_1() { return cOwnedInitExpressionAssignment_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_1_0; }
	}

	public class RealizedVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RealizedVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRealizeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_3_0 = (RuleCall)cOwnedTypeAssignment_3.eContents().get(0);
		
		////RealizedVariable := �realized� VariableName �:� TypeDeclaration
		// RealizedVariableCS:
		//	"realize" name=UnrestrictedName ":" ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//"realize" name=UnrestrictedName ":" ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//"realize"
		public Keyword getRealizeKeyword_0() { return cRealizeKeyword_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_3() { return cOwnedTypeAssignment_3; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_3_0() { return cOwnedTypeTypeExpCSParserRuleCall_3_0; }
	}

	public class UnnamedDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnnamedDomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDomainCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cOwnedGuardPatternAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedGuardPatternGuardPatternCSParserRuleCall_1_0 = (RuleCall)cOwnedGuardPatternAssignment_1.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedBottomPatternBottomPatternCSParserRuleCall_2_0 = (RuleCall)cOwnedBottomPatternAssignment_2.eContents().get(0);
		
		//UnnamedDomainCS returns DomainCS:
		//	{DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//{DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		public Group getGroup() { return cGroup; }

		//{DomainCS}
		public Action getDomainCSAction_0() { return cDomainCSAction_0; }

		//ownedGuardPattern=GuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_1() { return cOwnedGuardPatternAssignment_1; }

		//GuardPatternCS
		public RuleCall getOwnedGuardPatternGuardPatternCSParserRuleCall_1_0() { return cOwnedGuardPatternGuardPatternCSParserRuleCall_1_0; }

		//ownedBottomPattern=BottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_2() { return cOwnedBottomPatternAssignment_2; }

		//BottomPatternCS
		public RuleCall getOwnedBottomPatternBottomPatternCSParserRuleCall_2_0() { return cOwnedBottomPatternBottomPatternCSParserRuleCall_2_0; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cCheckKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cEnforceKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cImportKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cImportsKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cLibraryKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cMapKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cQueryKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cRealizeKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cRefinesKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cTransformationKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cUsesKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		
		////|	'where'
		// UnrestrictedName returns ecore::EString:
		//	EssentialOCLUnrestrictedName //|	'creation'
		// //|	'default'
		// //|	'deletion'
		// //|	'include'
		// | "check" | "enforce" |
		//	"import" | "imports" | "library" | "map" | "query" | "realize" | "refines" | "transformation" | "uses";
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName //|	'creation'
		// //|	'default'
		// //|	'deletion'
		// //|	'include'
		// | "check" | "enforce" |
		//"import" | "imports" | "library" | "map" | "query" | "realize" | "refines" | "transformation" | "uses"
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall_0() { return cEssentialOCLUnrestrictedNameParserRuleCall_0; }

		//"check"
		public Keyword getCheckKeyword_1() { return cCheckKeyword_1; }

		//"enforce"
		public Keyword getEnforceKeyword_2() { return cEnforceKeyword_2; }

		//"import"
		public Keyword getImportKeyword_3() { return cImportKeyword_3; }

		//"imports"
		public Keyword getImportsKeyword_4() { return cImportsKeyword_4; }

		//"library"
		public Keyword getLibraryKeyword_5() { return cLibraryKeyword_5; }

		//"map"
		public Keyword getMapKeyword_6() { return cMapKeyword_6; }

		//"query"
		public Keyword getQueryKeyword_7() { return cQueryKeyword_7; }

		//"realize"
		public Keyword getRealizeKeyword_8() { return cRealizeKeyword_8; }

		//"refines"
		public Keyword getRefinesKeyword_9() { return cRefinesKeyword_9; }

		//"transformation"
		public Keyword getTransformationKeyword_10() { return cTransformationKeyword_10; }

		//"uses"
		public Keyword getUsesKeyword_11() { return cUsesKeyword_11; }
	}
	
	
	private final BottomPatternCSElements pBottomPatternCS;
	private final DirectionCSElements pDirectionCS;
	private final GuardPatternCSElements pGuardPatternCS;
	private final GuardVariableCSElements pGuardVariableCS;
	private final ImportCSElements pImportCS;
	private final NamedDomainCSElements pNamedDomainCS;
	private final ParamDeclarationCSElements pParamDeclarationCS;
	private final PredicateCSElements pPredicateCS;
	private final PredicateOrAssignmentCSElements pPredicateOrAssignmentCS;
	private final QueryCSElements pQueryCS;
	private final ScopeNameCSElements pScopeNameCS;
	private final TransformationCSElements pTransformationCS;
	private final UnrealizedVariableCSElements pUnrealizedVariableCS;
	private final RealizedVariableCSElements pRealizedVariableCS;
	private final UnnamedDomainCSElements pUnnamedDomainCS;
	private final UnrestrictedNameElements pUnrestrictedName;
	
	private final Grammar grammar;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	@Inject
	public QVTcoreBaseGrammarAccess(GrammarProvider grammarProvider,
		EssentialOCLGrammarAccess gaEssentialOCL) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaEssentialOCL = gaEssentialOCL;
		this.pBottomPatternCS = new BottomPatternCSElements();
		this.pDirectionCS = new DirectionCSElements();
		this.pGuardPatternCS = new GuardPatternCSElements();
		this.pGuardVariableCS = new GuardVariableCSElements();
		this.pImportCS = new ImportCSElements();
		this.pNamedDomainCS = new NamedDomainCSElements();
		this.pParamDeclarationCS = new ParamDeclarationCSElements();
		this.pPredicateCS = new PredicateCSElements();
		this.pPredicateOrAssignmentCS = new PredicateOrAssignmentCSElements();
		this.pQueryCS = new QueryCSElements();
		this.pScopeNameCS = new ScopeNameCSElements();
		this.pTransformationCS = new TransformationCSElements();
		this.pUnrealizedVariableCS = new UnrealizedVariableCSElements();
		this.pRealizedVariableCS = new RealizedVariableCSElements();
		this.pUnnamedDomainCS = new UnnamedDomainCSElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.qvtd.xtext.qvtcorebase.QVTcoreBase".equals(grammar.getName())) {
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

	
	//// Bug 466385 explains the redundancy below
	// BottomPatternCS:
	//	"{" (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (","
	//	(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* "|"
	//	ownedConstraints+=PredicateOrAssignmentCS* "}" | "{" (ownedUnrealizedVariables+=UnrealizedVariableCS |
	//	ownedRealizedVariables+=RealizedVariableCS) ("," (ownedUnrealizedVariables+=UnrealizedVariableCS |
	//	ownedRealizedVariables+=RealizedVariableCS))* "}" | "{" ownedConstraints+=PredicateOrAssignmentCS+ "}" |
	//	{BottomPatternCS} "{" "}";
	public BottomPatternCSElements getBottomPatternCSAccess() {
		return pBottomPatternCS;
	}
	
	public ParserRule getBottomPatternCSRule() {
		return getBottomPatternCSAccess().getRule();
	}

	//DirectionCS:
	//	{DirectionCS} name=UnrestrictedName? ("imports" imports+=[pivot::Package|UnrestrictedName] (","
	//	imports+=[pivot::Package|UnrestrictedName])*)? ("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] (","
	//	uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?;
	public DirectionCSElements getDirectionCSAccess() {
		return pDirectionCS;
	}
	
	public ParserRule getDirectionCSRule() {
		return getDirectionCSAccess().getRule();
	}

	////EnforcementOperationCS: ('creation'|'deletion') ExpCS ';';
	// // Bug 466385 explains the redundancy below
	//
	//GuardPatternCS:
	//	"(" ownedUnrealizedVariables+=GuardVariableCS ("," ownedUnrealizedVariables+=GuardVariableCS)* "|"
	//	ownedPredicates+=PredicateCS* ")" | "(" ownedUnrealizedVariables+=GuardVariableCS (","
	//	ownedUnrealizedVariables+=GuardVariableCS)* ")" | "(" ownedPredicates+=PredicateCS+ ")" | {GuardPatternCS} "(" ")";
	public GuardPatternCSElements getGuardPatternCSAccess() {
		return pGuardPatternCS;
	}
	
	public ParserRule getGuardPatternCSRule() {
		return getGuardPatternCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	// GuardVariableCS returns UnrealizedVariableCS:
	//	name=UnrestrictedName ":" ownedType=TypeExpCS;
	public GuardVariableCSElements getGuardVariableCSAccess() {
		return pGuardVariableCS;
	}
	
	public ParserRule getGuardVariableCSRule() {
		return getGuardVariableCSAccess().getRule();
	}

	//ImportCS returns base::ImportCS:
	//	"import" (name=Identifier ":")? ownedPathName=URIPathNameCS (isAll?="::" "*")? ";";
	public ImportCSElements getImportCSAccess() {
		return pImportCS;
	}
	
	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	//NamedDomainCS returns DomainCS:
	//	isCheck?="check"? isEnforce?="enforce"? direction=[qvtbase::TypedModel|UnrestrictedName]
	//	ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
	public NamedDomainCSElements getNamedDomainCSAccess() {
		return pNamedDomainCS;
	}
	
	public ParserRule getNamedDomainCSRule() {
		return getNamedDomainCSAccess().getRule();
	}

	//ParamDeclarationCS:
	//	name=UnrestrictedName ":" ownedType=TypeExpCS;
	public ParamDeclarationCSElements getParamDeclarationCSAccess() {
		return pParamDeclarationCS;
	}
	
	public ParserRule getParamDeclarationCSRule() {
		return getParamDeclarationCSAccess().getRule();
	}

	//PredicateCS:
	//	ownedCondition=ExpCS ";";
	public PredicateCSElements getPredicateCSAccess() {
		return pPredicateCS;
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
	public PredicateOrAssignmentCSElements getPredicateOrAssignmentCSAccess() {
		return pPredicateOrAssignmentCS;
	}
	
	public ParserRule getPredicateOrAssignmentCSRule() {
		return getPredicateOrAssignmentCSAccess().getRule();
	}

	//QueryCS:
	//	"query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" (ownedParameters+=ParamDeclarationCS (","
	//	ownedParameters+=ParamDeclarationCS)*)? ")" ":" ownedType=TypeExpCS (";" | "{" ownedExpression=ExpCS "}");
	public QueryCSElements getQueryCSAccess() {
		return pQueryCS;
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
	public ScopeNameCSElements getScopeNameCSAccess() {
		return pScopeNameCS;
	}
	
	public ParserRule getScopeNameCSRule() {
		return getScopeNameCSAccess().getRule();
	}

	//TransformationCS:
	//	"transformation" ownedPathName=ScopeNameCS? name=UnreservedName "{" (ownedDirections+=DirectionCS ";")* "}";
	public TransformationCSElements getTransformationCSAccess() {
		return pTransformationCS;
	}
	
	public ParserRule getTransformationCSRule() {
		return getTransformationCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	// UnrealizedVariableCS:
	//	name=UnrestrictedName (":" ownedType=TypeExpCS)? (":=" ownedInitExpression=ExpCS)?;
	public UnrealizedVariableCSElements getUnrealizedVariableCSAccess() {
		return pUnrealizedVariableCS;
	}
	
	public ParserRule getUnrealizedVariableCSRule() {
		return getUnrealizedVariableCSAccess().getRule();
	}

	////RealizedVariable := �realized� VariableName �:� TypeDeclaration
	// RealizedVariableCS:
	//	"realize" name=UnrestrictedName ":" ownedType=TypeExpCS;
	public RealizedVariableCSElements getRealizedVariableCSAccess() {
		return pRealizedVariableCS;
	}
	
	public ParserRule getRealizedVariableCSRule() {
		return getRealizedVariableCSAccess().getRule();
	}

	//UnnamedDomainCS returns DomainCS:
	//	{DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
	public UnnamedDomainCSElements getUnnamedDomainCSAccess() {
		return pUnnamedDomainCS;
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
	public UnrestrictedNameElements getUnrestrictedNameAccess() {
		return pUnrestrictedName;
	}
	
	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	// Model returns ContextCS:
	//	ownedExpression=ExpCS;
	public EssentialOCLGrammarAccess.ModelElements getModelAccess() {
		return gaEssentialOCL.getModelAccess();
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLReservedKeyword:
	//	"and" | "else" | "endif" | "if" | "implies" | "in" | "let" | "not" | "or" | "then" | "xor";
	public EssentialOCLGrammarAccess.EssentialOCLReservedKeywordElements getEssentialOCLReservedKeywordAccess() {
		return gaEssentialOCL.getEssentialOCLReservedKeywordAccess();
	}
	
	public ParserRule getEssentialOCLReservedKeywordRule() {
		return getEssentialOCLReservedKeywordAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnaryOperatorName:
	//	"-" | "not";
	public EssentialOCLGrammarAccess.EssentialOCLUnaryOperatorNameElements getEssentialOCLUnaryOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnaryOperatorNameAccess();
	}
	
	public ParserRule getEssentialOCLUnaryOperatorNameRule() {
		return getEssentialOCLUnaryOperatorNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLInfixOperatorName:
	//	"*" | "/" | "+" | "-" | ">" | "<" | ">=" | "<=" | "=" | "<>" | "and" | "or" | "xor" | "implies";
	public EssentialOCLGrammarAccess.EssentialOCLInfixOperatorNameElements getEssentialOCLInfixOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLInfixOperatorNameAccess();
	}
	
	public ParserRule getEssentialOCLInfixOperatorNameRule() {
		return getEssentialOCLInfixOperatorNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLNavigationOperatorName:
	//	"." | "->" | "?." | "?->";
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

	//// Intended to be overrideable
	// InfixOperatorName:
	//	EssentialOCLInfixOperatorName;
	public EssentialOCLGrammarAccess.InfixOperatorNameElements getInfixOperatorNameAccess() {
		return gaEssentialOCL.getInfixOperatorNameAccess();
	}
	
	public ParserRule getInfixOperatorNameRule() {
		return getInfixOperatorNameAccess().getRule();
	}

	//// Intended to be overrideable
	// NavigationOperatorName:
	//	EssentialOCLNavigationOperatorName;
	public EssentialOCLGrammarAccess.NavigationOperatorNameElements getNavigationOperatorNameAccess() {
		return gaEssentialOCL.getNavigationOperatorNameAccess();
	}
	
	public ParserRule getNavigationOperatorNameRule() {
		return getNavigationOperatorNameAccess().getRule();
	}

	//// Intended to be overrideable
	// UnaryOperatorName:
	//	EssentialOCLUnaryOperatorName;
	public EssentialOCLGrammarAccess.UnaryOperatorNameElements getUnaryOperatorNameAccess() {
		return gaEssentialOCL.getUnaryOperatorNameAccess();
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
		return gaEssentialOCL.getEssentialOCLUnrestrictedNameAccess();
	}
	
	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnreservedName returns ecore::EString:
	//	UnrestrictedName | CollectionTypeIdentifier | PrimitiveTypeIdentifier | "Map" | "Tuple";
	public EssentialOCLGrammarAccess.EssentialOCLUnreservedNameElements getEssentialOCLUnreservedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnreservedNameAccess();
	}
	
	public ParserRule getEssentialOCLUnreservedNameRule() {
		return getEssentialOCLUnreservedNameAccess().getRule();
	}

	//// Intended to be overridden
	// UnreservedName returns ecore::EString:
	//	EssentialOCLUnreservedName;
	public EssentialOCLGrammarAccess.UnreservedNameElements getUnreservedNameAccess() {
		return gaEssentialOCL.getUnreservedNameAccess();
	}
	
	public ParserRule getUnreservedNameRule() {
		return getUnreservedNameAccess().getRule();
	}

	//URIPathNameCS returns base::PathNameCS:
	//	ownedPathElements+=URIFirstPathElementCS ("::" ownedPathElements+=NextPathElementCS)*;
	public EssentialOCLGrammarAccess.URIPathNameCSElements getURIPathNameCSAccess() {
		return gaEssentialOCL.getURIPathNameCSAccess();
	}
	
	public ParserRule getURIPathNameCSRule() {
		return getURIPathNameCSAccess().getRule();
	}

	//URIFirstPathElementCS returns base::PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS}
	//	referredElement=[pivot::Namespace|URI];
	public EssentialOCLGrammarAccess.URIFirstPathElementCSElements getURIFirstPathElementCSAccess() {
		return gaEssentialOCL.getURIFirstPathElementCSAccess();
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
		return gaEssentialOCL.getPrimitiveTypeIdentifierAccess();
	}
	
	public ParserRule getPrimitiveTypeIdentifierRule() {
		return getPrimitiveTypeIdentifierAccess().getRule();
	}

	//PrimitiveTypeCS returns base::PrimitiveTypeRefCS:
	//	name=PrimitiveTypeIdentifier;
	public EssentialOCLGrammarAccess.PrimitiveTypeCSElements getPrimitiveTypeCSAccess() {
		return gaEssentialOCL.getPrimitiveTypeCSAccess();
	}
	
	public ParserRule getPrimitiveTypeCSRule() {
		return getPrimitiveTypeCSAccess().getRule();
	}

	//CollectionTypeIdentifier returns ecore::EString:
	//	"Set" | "Bag" | "Sequence" | "Collection" | "OrderedSet";
	public EssentialOCLGrammarAccess.CollectionTypeIdentifierElements getCollectionTypeIdentifierAccess() {
		return gaEssentialOCL.getCollectionTypeIdentifierAccess();
	}
	
	public ParserRule getCollectionTypeIdentifierRule() {
		return getCollectionTypeIdentifierAccess().getRule();
	}

	//CollectionTypeCS:
	//	name=CollectionTypeIdentifier ("(" ownedType=TypeExpCS ")")?;
	public EssentialOCLGrammarAccess.CollectionTypeCSElements getCollectionTypeCSAccess() {
		return gaEssentialOCL.getCollectionTypeCSAccess();
	}
	
	public ParserRule getCollectionTypeCSRule() {
		return getCollectionTypeCSAccess().getRule();
	}

	//MapTypeCS:
	//	name="Map" ("(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")")?;
	public EssentialOCLGrammarAccess.MapTypeCSElements getMapTypeCSAccess() {
		return gaEssentialOCL.getMapTypeCSAccess();
	}
	
	public ParserRule getMapTypeCSRule() {
		return getMapTypeCSAccess().getRule();
	}

	//TupleTypeCS returns base::TupleTypeCS:
	//	name="Tuple" ("(" (ownedParts+=TuplePartCS ("," ownedParts+=TuplePartCS)*)? ")")?;
	public EssentialOCLGrammarAccess.TupleTypeCSElements getTupleTypeCSAccess() {
		return gaEssentialOCL.getTupleTypeCSAccess();
	}
	
	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	//TuplePartCS returns base::TuplePartCS:
	//	name=UnrestrictedName ":" ownedType=TypeExpCS;
	public EssentialOCLGrammarAccess.TuplePartCSElements getTuplePartCSAccess() {
		return gaEssentialOCL.getTuplePartCSAccess();
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
		return gaEssentialOCL.getCollectionLiteralExpCSAccess();
	}
	
	public ParserRule getCollectionLiteralExpCSRule() {
		return getCollectionLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralPartCS:
	//	ownedExpression=ExpCS (".." ownedLastExpression=ExpCS)? | ownedExpression=PatternExpCS;
	public EssentialOCLGrammarAccess.CollectionLiteralPartCSElements getCollectionLiteralPartCSAccess() {
		return gaEssentialOCL.getCollectionLiteralPartCSAccess();
	}
	
	public ParserRule getCollectionLiteralPartCSRule() {
		return getCollectionLiteralPartCSAccess().getRule();
	}

	//CollectionPatternCS:
	//	ownedType=CollectionTypeCS "{" (ownedParts+=PatternExpCS ("," ownedParts+=PatternExpCS)* ("++"
	//	restVariableName=Identifier))? "}";
	public EssentialOCLGrammarAccess.CollectionPatternCSElements getCollectionPatternCSAccess() {
		return gaEssentialOCL.getCollectionPatternCSAccess();
	}
	
	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//// PatternPartCS
	// ShadowPartCS:
	//	referredProperty=[pivot::Property|UnrestrictedName] "=" ownedInitExpression=(ExpCS | PatternExpCS);
	public EssentialOCLGrammarAccess.ShadowPartCSElements getShadowPartCSAccess() {
		return gaEssentialOCL.getShadowPartCSAccess();
	}
	
	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//	patternVariableName=UnrestrictedName? ":" ownedPatternType=TypeExpCS;
	public EssentialOCLGrammarAccess.PatternExpCSElements getPatternExpCSAccess() {
		return gaEssentialOCL.getPatternExpCSAccess();
	}
	
	public ParserRule getPatternExpCSRule() {
		return getPatternExpCSAccess().getRule();
	}

	//LambdaLiteralExpCS:
	//	"Lambda" "{" ownedExpressionCS=ExpCS "}";
	public EssentialOCLGrammarAccess.LambdaLiteralExpCSElements getLambdaLiteralExpCSAccess() {
		return gaEssentialOCL.getLambdaLiteralExpCSAccess();
	}
	
	public ParserRule getLambdaLiteralExpCSRule() {
		return getLambdaLiteralExpCSAccess().getRule();
	}

	//MapLiteralExpCS:
	//	ownedType=MapTypeCS "{" (ownedParts+=MapLiteralPartCS ("," ownedParts+=MapLiteralPartCS)*)? "}";
	public EssentialOCLGrammarAccess.MapLiteralExpCSElements getMapLiteralExpCSAccess() {
		return gaEssentialOCL.getMapLiteralExpCSAccess();
	}
	
	public ParserRule getMapLiteralExpCSRule() {
		return getMapLiteralExpCSAccess().getRule();
	}

	//MapLiteralPartCS:
	//	ownedKey=ExpCS "<-" ownedValue=ExpCS;
	public EssentialOCLGrammarAccess.MapLiteralPartCSElements getMapLiteralPartCSAccess() {
		return gaEssentialOCL.getMapLiteralPartCSAccess();
	}
	
	public ParserRule getMapLiteralPartCSRule() {
		return getMapLiteralPartCSAccess().getRule();
	}

	//PrimitiveLiteralExpCS:
	//	NumberLiteralExpCS | StringLiteralExpCS | BooleanLiteralExpCS | UnlimitedNaturalLiteralExpCS | InvalidLiteralExpCS |
	//	NullLiteralExpCS;
	public EssentialOCLGrammarAccess.PrimitiveLiteralExpCSElements getPrimitiveLiteralExpCSAccess() {
		return gaEssentialOCL.getPrimitiveLiteralExpCSAccess();
	}
	
	public ParserRule getPrimitiveLiteralExpCSRule() {
		return getPrimitiveLiteralExpCSAccess().getRule();
	}

	//TupleLiteralExpCS:
	//	"Tuple" "{" ownedParts+=TupleLiteralPartCS ("," ownedParts+=TupleLiteralPartCS)* "}";
	public EssentialOCLGrammarAccess.TupleLiteralExpCSElements getTupleLiteralExpCSAccess() {
		return gaEssentialOCL.getTupleLiteralExpCSAccess();
	}
	
	public ParserRule getTupleLiteralExpCSRule() {
		return getTupleLiteralExpCSAccess().getRule();
	}

	//TupleLiteralPartCS:
	//	name=UnrestrictedName (":" ownedType=TypeExpCS)? "=" ownedInitExpression=ExpCS;
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
	//	symbol="true" | symbol="false";
	public EssentialOCLGrammarAccess.BooleanLiteralExpCSElements getBooleanLiteralExpCSAccess() {
		return gaEssentialOCL.getBooleanLiteralExpCSAccess();
	}
	
	public ParserRule getBooleanLiteralExpCSRule() {
		return getBooleanLiteralExpCSAccess().getRule();
	}

	//UnlimitedNaturalLiteralExpCS:
	//	{UnlimitedNaturalLiteralExpCS} "*";
	public EssentialOCLGrammarAccess.UnlimitedNaturalLiteralExpCSElements getUnlimitedNaturalLiteralExpCSAccess() {
		return gaEssentialOCL.getUnlimitedNaturalLiteralExpCSAccess();
	}
	
	public ParserRule getUnlimitedNaturalLiteralExpCSRule() {
		return getUnlimitedNaturalLiteralExpCSAccess().getRule();
	}

	//InvalidLiteralExpCS:
	//	{InvalidLiteralExpCS} "invalid";
	public EssentialOCLGrammarAccess.InvalidLiteralExpCSElements getInvalidLiteralExpCSAccess() {
		return gaEssentialOCL.getInvalidLiteralExpCSAccess();
	}
	
	public ParserRule getInvalidLiteralExpCSRule() {
		return getInvalidLiteralExpCSAccess().getRule();
	}

	//NullLiteralExpCS:
	//	{NullLiteralExpCS} "null";
	public EssentialOCLGrammarAccess.NullLiteralExpCSElements getNullLiteralExpCSAccess() {
		return gaEssentialOCL.getNullLiteralExpCSAccess();
	}
	
	public ParserRule getNullLiteralExpCSRule() {
		return getNullLiteralExpCSAccess().getRule();
	}

	//TypeLiteralCS returns base::TypedRefCS:
	//	PrimitiveTypeCS | CollectionTypeCS | MapTypeCS | TupleTypeCS;
	public EssentialOCLGrammarAccess.TypeLiteralCSElements getTypeLiteralCSAccess() {
		return gaEssentialOCL.getTypeLiteralCSAccess();
	}
	
	public ParserRule getTypeLiteralCSRule() {
		return getTypeLiteralCSAccess().getRule();
	}

	//TypeLiteralWithMultiplicityCS returns base::TypedRefCS:
	//	TypeLiteralCS ownedMultiplicity=MultiplicityCS?;
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
	//	ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ("{" ownedPatternGuard=ExpCS "}")?)?;
	public EssentialOCLGrammarAccess.TypeNameExpCSElements getTypeNameExpCSAccess() {
		return gaEssentialOCL.getTypeNameExpCSAccess();
	}
	
	public ParserRule getTypeNameExpCSRule() {
		return getTypeNameExpCSAccess().getRule();
	}

	//TypeExpCS returns base::TypedRefCS:
	//	(TypeNameExpCS | TypeLiteralCS | CollectionPatternCS) ownedMultiplicity=MultiplicityCS?;
	public EssentialOCLGrammarAccess.TypeExpCSElements getTypeExpCSAccess() {
		return gaEssentialOCL.getTypeExpCSAccess();
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
		return gaEssentialOCL.getExpCSAccess();
	}
	
	public ParserRule getExpCSRule() {
		return getExpCSAccess().getRule();
	}

	/// * A prefixed let expression elaborates a let expression with zero or more unary prefix operators. * / PrefixedLetExpCS
	//returns ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS | LetExpCS;
	public EssentialOCLGrammarAccess.PrefixedLetExpCSElements getPrefixedLetExpCSAccess() {
		return gaEssentialOCL.getPrefixedLetExpCSAccess();
	}
	
	public ParserRule getPrefixedLetExpCSRule() {
		return getPrefixedLetExpCSAccess().getRule();
	}

	/// * A prefixed primary expression elaborates a primary expression with zero or more unary prefix operators. * /
	//PrefixedPrimaryExpCS returns ExpCS:
	//	{PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS | PrimaryExpCS;
	public EssentialOCLGrammarAccess.PrefixedPrimaryExpCSElements getPrefixedPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrefixedPrimaryExpCSAccess();
	}
	
	public ParserRule getPrefixedPrimaryExpCSRule() {
		return getPrefixedPrimaryExpCSAccess().getRule();
	}

	/// * A primary expression identifies the basic expressions from which more complex expressions may be constructed. * /
	//PrimaryExpCS returns ExpCS:
	//	NestedExpCS | IfExpCS | SelfExpCS | PrimitiveLiteralExpCS | TupleLiteralExpCS | MapLiteralExpCS |
	//	CollectionLiteralExpCS | LambdaLiteralExpCS | TypeLiteralExpCS | NameExpCS;
	public EssentialOCLGrammarAccess.PrimaryExpCSElements getPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrimaryExpCSAccess();
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
		return gaEssentialOCL.getNameExpCSAccess();
	}
	
	public ParserRule getNameExpCSRule() {
		return getNameExpCSAccess().getRule();
	}

	/// * A curly bracket clause is a generalized rule for the literal arguments of collections, maps, tuples and shadows.* /
	//CurlyBracketedClauseCS:
	//	{CurlyBracketedClauseCS} "{" ((ownedParts+=ShadowPartCS ("," ownedParts+=ShadowPartCS)*)? | value=StringLiteral) "}";
	public EssentialOCLGrammarAccess.CurlyBracketedClauseCSElements getCurlyBracketedClauseCSAccess() {
		return gaEssentialOCL.getCurlyBracketedClauseCSAccess();
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
		return gaEssentialOCL.getRoundBracketedClauseCSAccess();
	}
	
	public ParserRule getRoundBracketedClauseCSRule() {
		return getRoundBracketedClauseCSAccess().getRule();
	}

	/// * A square bracket clause is a generalized rule for association class qualifiers and roles.* / SquareBracketedClauseCS:
	//	"[" ownedTerms+=ExpCS ("," ownedTerms+=ExpCS)* "]";
	public EssentialOCLGrammarAccess.SquareBracketedClauseCSElements getSquareBracketedClauseCSAccess() {
		return gaEssentialOCL.getSquareBracketedClauseCSAccess();
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
		return gaEssentialOCL.getNavigatingArgCSAccess();
	}
	
	public ParserRule getNavigatingArgCSRule() {
		return getNavigatingArgCSAccess().getRule();
	}

	/// * A navigating bar argument is a generalized rule for a bar-prefixed argument in a round bracket clause. This is typically the body of an iteration. * /
	//// Type-less init is an illegal infix expression
	// NavigatingBarArgCS returns NavigatingArgCS:
	//	prefix="|" ownedNameExpression=NavigatingArgExpCS (":" ownedType=TypeExpCS ("=" ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingBarArgCSElements getNavigatingBarArgCSAccess() {
		return gaEssentialOCL.getNavigatingBarArgCSAccess();
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
		return gaEssentialOCL.getNavigatingCommaArgCSAccess();
	}
	
	public ParserRule getNavigatingCommaArgCSRule() {
		return getNavigatingCommaArgCSAccess().getRule();
	}

	/// * A navigating semi argument is a generalized rule for a semicolon prefixed argument in a round bracket clause. This is typically an iterate accumulator. * /
	//// Type-less init is an illegal infix expression
	// NavigatingSemiArgCS returns NavigatingArgCS:
	//	prefix=";" ownedNameExpression=NavigatingArgExpCS (":" ownedType=TypeExpCS ("=" ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingSemiArgCSElements getNavigatingSemiArgCSAccess() {
		return gaEssentialOCL.getNavigatingSemiArgCSAccess();
	}
	
	public ParserRule getNavigatingSemiArgCSRule() {
		return getNavigatingSemiArgCSAccess().getRule();
	}

	//// Intended to be overridden
	// //	'?'	-- defined by Complete OCL
	// NavigatingArgExpCS returns ExpCS:
	//	ExpCS;
	public EssentialOCLGrammarAccess.NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return gaEssentialOCL.getNavigatingArgExpCSAccess();
	}
	
	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//IfExpCS:
	//	"if" ownedCondition=(ExpCS | PatternExpCS) "then" ownedThenExpression=ExpCS //	ifThenExpressions+=IfThenExpCS
	//
	//	ownedIfThenExpressions+=ElseIfThenExpCS* "else" ownedElseExpression=ExpCS "endif";
	public EssentialOCLGrammarAccess.IfExpCSElements getIfExpCSAccess() {
		return gaEssentialOCL.getIfExpCSAccess();
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
		return gaEssentialOCL.getElseIfThenExpCSAccess();
	}
	
	public ParserRule getElseIfThenExpCSRule() {
		return getElseIfThenExpCSAccess().getRule();
	}

	//LetExpCS:
	//	"let" ownedVariables+=LetVariableCS ("," ownedVariables+=LetVariableCS)* "in" ownedInExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetExpCSElements getLetExpCSAccess() {
		return gaEssentialOCL.getLetExpCSAccess();
	}
	
	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS:
	//	name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (":" ownedType=TypeExpCS)? "="
	//	ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetVariableCSElements getLetVariableCSAccess() {
		return gaEssentialOCL.getLetVariableCSAccess();
	}
	
	public ParserRule getLetVariableCSRule() {
		return getLetVariableCSAccess().getRule();
	}

	//NestedExpCS:
	//	"(" ownedExpression=ExpCS ")";
	public EssentialOCLGrammarAccess.NestedExpCSElements getNestedExpCSAccess() {
		return gaEssentialOCL.getNestedExpCSAccess();
	}
	
	public ParserRule getNestedExpCSRule() {
		return getNestedExpCSAccess().getRule();
	}

	//SelfExpCS:
	//	{SelfExpCS} "self";
	public EssentialOCLGrammarAccess.SelfExpCSElements getSelfExpCSAccess() {
		return gaEssentialOCL.getSelfExpCSAccess();
	}
	
	public ParserRule getSelfExpCSRule() {
		return getSelfExpCSAccess().getRule();
	}

	//MultiplicityBoundsCS:
	//	lowerBound=LOWER (".." upperBound=UPPER)?;
	public BaseGrammarAccess.MultiplicityBoundsCSElements getMultiplicityBoundsCSAccess() {
		return gaEssentialOCL.getMultiplicityBoundsCSAccess();
	}
	
	public ParserRule getMultiplicityBoundsCSRule() {
		return getMultiplicityBoundsCSAccess().getRule();
	}

	//MultiplicityCS:
	//	"[" (MultiplicityBoundsCS | MultiplicityStringCS) ("|?" | isNullFree?="|1")? "]";
	public BaseGrammarAccess.MultiplicityCSElements getMultiplicityCSAccess() {
		return gaEssentialOCL.getMultiplicityCSAccess();
	}
	
	public ParserRule getMultiplicityCSRule() {
		return getMultiplicityCSAccess().getRule();
	}

	//MultiplicityStringCS:
	//	stringBounds=("*" | "+" | "?");
	public BaseGrammarAccess.MultiplicityStringCSElements getMultiplicityStringCSAccess() {
		return gaEssentialOCL.getMultiplicityStringCSAccess();
	}
	
	public ParserRule getMultiplicityStringCSRule() {
		return getMultiplicityStringCSAccess().getRule();
	}

	//PathNameCS:
	//	ownedPathElements+=FirstPathElementCS ("::" ownedPathElements+=NextPathElementCS)*;
	public BaseGrammarAccess.PathNameCSElements getPathNameCSAccess() {
		return gaEssentialOCL.getPathNameCSAccess();
	}
	
	public ParserRule getPathNameCSRule() {
		return getPathNameCSAccess().getRule();
	}

	//FirstPathElementCS returns PathElementCS:
	//	referredElement=[pivot::NamedElement|UnrestrictedName];
	public BaseGrammarAccess.FirstPathElementCSElements getFirstPathElementCSAccess() {
		return gaEssentialOCL.getFirstPathElementCSAccess();
	}
	
	public ParserRule getFirstPathElementCSRule() {
		return getFirstPathElementCSAccess().getRule();
	}

	//NextPathElementCS returns PathElementCS:
	//	referredElement=[pivot::NamedElement|UnreservedName];
	public BaseGrammarAccess.NextPathElementCSElements getNextPathElementCSAccess() {
		return gaEssentialOCL.getNextPathElementCSAccess();
	}
	
	public ParserRule getNextPathElementCSRule() {
		return getNextPathElementCSAccess().getRule();
	}

	//TemplateBindingCS:
	//	ownedSubstitutions+=TemplateParameterSubstitutionCS ("," ownedSubstitutions+=TemplateParameterSubstitutionCS)*
	//	ownedMultiplicity=MultiplicityCS?;
	public BaseGrammarAccess.TemplateBindingCSElements getTemplateBindingCSAccess() {
		return gaEssentialOCL.getTemplateBindingCSAccess();
	}
	
	public ParserRule getTemplateBindingCSRule() {
		return getTemplateBindingCSAccess().getRule();
	}

	//TemplateParameterSubstitutionCS:
	//	ownedActualParameter=TypeRefCS;
	public BaseGrammarAccess.TemplateParameterSubstitutionCSElements getTemplateParameterSubstitutionCSAccess() {
		return gaEssentialOCL.getTemplateParameterSubstitutionCSAccess();
	}
	
	public ParserRule getTemplateParameterSubstitutionCSRule() {
		return getTemplateParameterSubstitutionCSAccess().getRule();
	}

	//TemplateSignatureCS:
	//	"(" ownedParameters+=TypeParameterCS ("," ownedParameters+=TypeParameterCS)* ")";
	public BaseGrammarAccess.TemplateSignatureCSElements getTemplateSignatureCSAccess() {
		return gaEssentialOCL.getTemplateSignatureCSAccess();
	}
	
	public ParserRule getTemplateSignatureCSRule() {
		return getTemplateSignatureCSAccess().getRule();
	}

	//TypeParameterCS:
	//	name=UnrestrictedName ("extends" ownedExtends+=TypedRefCS ("&&" ownedExtends+=TypedRefCS)*)?;
	public BaseGrammarAccess.TypeParameterCSElements getTypeParameterCSAccess() {
		return gaEssentialOCL.getTypeParameterCSAccess();
	}
	
	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS:
	//	TypedRefCS | WildcardTypeRefCS;
	public BaseGrammarAccess.TypeRefCSElements getTypeRefCSAccess() {
		return gaEssentialOCL.getTypeRefCSAccess();
	}
	
	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//TypedRefCS:
	//	TypedTypeRefCS;
	public BaseGrammarAccess.TypedRefCSElements getTypedRefCSAccess() {
		return gaEssentialOCL.getTypedRefCSAccess();
	}
	
	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//TypedTypeRefCS:
	//	ownedPathName=PathNameCS ("(" ownedBinding=TemplateBindingCS ")")?;
	public BaseGrammarAccess.TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return gaEssentialOCL.getTypedTypeRefCSAccess();
	}
	
	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//WildcardTypeRefCS:
	//	{WildcardTypeRefCS} "?" ("extends" ownedExtends=TypedRefCS)?;
	public BaseGrammarAccess.WildcardTypeRefCSElements getWildcardTypeRefCSAccess() {
		return gaEssentialOCL.getWildcardTypeRefCSAccess();
	}
	
	public ParserRule getWildcardTypeRefCSRule() {
		return getWildcardTypeRefCSAccess().getRule();
	}

	//ID:
	//	SIMPLE_ID | ESCAPED_ID;
	public BaseGrammarAccess.IDElements getIDAccess() {
		return gaEssentialOCL.getIDAccess();
	}
	
	public ParserRule getIDRule() {
		return getIDAccess().getRule();
	}

	//Identifier:
	//	ID;
	public BaseGrammarAccess.IdentifierElements getIdentifierAccess() {
		return gaEssentialOCL.getIdentifierAccess();
	}
	
	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}

	/// * A lowerbounded integer is used to define the lowerbound of a collection multiplicity. The value may not be the unlimited value. * /
	//LOWER returns ecore::EInt:
	//	INT;
	public BaseGrammarAccess.LOWERElements getLOWERAccess() {
		return gaEssentialOCL.getLOWERAccess();
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
		return gaEssentialOCL.getNUMBER_LITERALAccess();
	}
	
	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//StringLiteral:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.StringLiteralElements getStringLiteralAccess() {
		return gaEssentialOCL.getStringLiteralAccess();
	}
	
	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}

	/// * An upperbounded integer is used to define the upperbound of a collection multiplicity. The value may be the unlimited value. * /
	//UPPER returns ecore::EInt:
	//	INT | "*";
	public BaseGrammarAccess.UPPERElements getUPPERAccess() {
		return gaEssentialOCL.getUPPERAccess();
	}
	
	public ParserRule getUPPERRule() {
		return getUPPERAccess().getRule();
	}

	//URI:
	//	SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.URIElements getURIAccess() {
		return gaEssentialOCL.getURIAccess();
	}
	
	public ParserRule getURIRule() {
		return getURIAccess().getRule();
	}

	//terminal fragment ESCAPED_CHARACTER:
	//	"\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\");
	public TerminalRule getESCAPED_CHARACTERRule() {
		return gaEssentialOCL.getESCAPED_CHARACTERRule();
	} 

	//terminal fragment LETTER_CHARACTER:
	//	"a".."z" | "A".."Z" | "_";
	public TerminalRule getLETTER_CHARACTERRule() {
		return gaEssentialOCL.getLETTER_CHARACTERRule();
	} 

	//terminal DOUBLE_QUOTED_STRING:
	//	"\"" (ESCAPED_CHARACTER | !("\\" | "\""))* "\"";
	public TerminalRule getDOUBLE_QUOTED_STRINGRule() {
		return gaEssentialOCL.getDOUBLE_QUOTED_STRINGRule();
	} 

	//terminal SINGLE_QUOTED_STRING:
	//	"\'" (ESCAPED_CHARACTER | !("\\" | "\'"))* "\'";
	public TerminalRule getSINGLE_QUOTED_STRINGRule() {
		return gaEssentialOCL.getSINGLE_QUOTED_STRINGRule();
	} 

	//terminal ML_SINGLE_QUOTED_STRING:
	//	"/\'"->"\'/";
	public TerminalRule getML_SINGLE_QUOTED_STRINGRule() {
		return gaEssentialOCL.getML_SINGLE_QUOTED_STRINGRule();
	} 

	//terminal SIMPLE_ID:
	//	LETTER_CHARACTER (LETTER_CHARACTER | "0".."9")*;
	public TerminalRule getSIMPLE_IDRule() {
		return gaEssentialOCL.getSIMPLE_IDRule();
	} 

	//terminal ESCAPED_ID:
	//	"_" SINGLE_QUOTED_STRING;
	public TerminalRule getESCAPED_IDRule() {
		return gaEssentialOCL.getESCAPED_IDRule();
	} 

	//// String to allow diverse re-use
	// // multiple leading zeroes occur as floating point fractional part
	// terminal INT:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaEssentialOCL.getINTRule();
	} 

	/// * A multi-line comment supports a comment that may span more than one line using familiar slash-star...star-slash comment delimiters * /
	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaEssentialOCL.getML_COMMENTRule();
	} 

	/// * A single-line comment supports a comment that terminates at the end of the line * / terminal SL_COMMENT:
	//	"--" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaEssentialOCL.getSL_COMMENTRule();
	} 

	/// * Whitespace may occur between any pair of tokens * / terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaEssentialOCL.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaEssentialOCL.getANY_OTHERRule();
	} 
}
