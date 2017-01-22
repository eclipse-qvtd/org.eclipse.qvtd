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
package org.eclipse.qvtd.xtext.qvtcore.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class QVTcoreGrammarAccess extends AbstractGrammarElementFinder {


	public class TopLevelCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.TopLevelCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedImportsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedImportsImportCSParserRuleCall_0_0 = (RuleCall)cOwnedImportsAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cOwnedPackagesAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0 = (RuleCall)cOwnedPackagesAssignment_1_0.eContents().get(0);
		private final Assignment cOwnedTransformationsAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cOwnedTransformationsTransformationCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTransformationsAssignment_1_1.eContents().get(0);
		private final Assignment cOwnedMappingsAssignment_1_2 = (Assignment)cAlternatives_1.eContents().get(2);
		private final RuleCall cOwnedMappingsMappingCSParserRuleCall_1_2_0 = (RuleCall)cOwnedMappingsAssignment_1_2.eContents().get(0);
		private final Assignment cOwnedQueriesAssignment_1_3 = (Assignment)cAlternatives_1.eContents().get(3);
		private final RuleCall cOwnedQueriesQueryCSParserRuleCall_1_3_0 = (RuleCall)cOwnedQueriesAssignment_1_3.eContents().get(0);

		//TopLevelCS:
		//	ownedImports+=ImportCS* (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS |
		//	ownedMappings+=MappingCS | ownedQueries+=QueryCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedImports+=ImportCS* (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS |
		//ownedMappings+=MappingCS | ownedQueries+=QueryCS)*
		public Group getGroup() { return cGroup; }

		//ownedImports+=ImportCS*
		public Assignment getOwnedImportsAssignment_0() { return cOwnedImportsAssignment_0; }

		//ImportCS
		public RuleCall getOwnedImportsImportCSParserRuleCall_0_0() { return cOwnedImportsImportCSParserRuleCall_0_0; }

		//(ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS | ownedMappings+=MappingCS |
		//ownedQueries+=QueryCS)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//ownedPackages+=QualifiedPackageCS
		public Assignment getOwnedPackagesAssignment_1_0() { return cOwnedPackagesAssignment_1_0; }

		//QualifiedPackageCS
		public RuleCall getOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0() { return cOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0; }

		//ownedTransformations+=TransformationCS
		public Assignment getOwnedTransformationsAssignment_1_1() { return cOwnedTransformationsAssignment_1_1; }

		//TransformationCS
		public RuleCall getOwnedTransformationsTransformationCSParserRuleCall_1_1_0() { return cOwnedTransformationsTransformationCSParserRuleCall_1_1_0; }

		//ownedMappings+=MappingCS
		public Assignment getOwnedMappingsAssignment_1_2() { return cOwnedMappingsAssignment_1_2; }

		//MappingCS
		public RuleCall getOwnedMappingsMappingCSParserRuleCall_1_2_0() { return cOwnedMappingsMappingCSParserRuleCall_1_2_0; }

		//ownedQueries+=QueryCS
		public Assignment getOwnedQueriesAssignment_1_3() { return cOwnedQueriesAssignment_1_3; }

		//QueryCS
		public RuleCall getOwnedQueriesQueryCSParserRuleCall_1_3_0() { return cOwnedQueriesQueryCSParserRuleCall_1_3_0; }
	}

	public class BottomPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.BottomPatternCS");
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

		//BottomPatternCS:
		//	'{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (','
		//	(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '|'
		//	ownedConstraints+=PredicateOrAssignmentCS* '}' | '{' (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//	ownedRealizedVariables+=RealizedVariableCS) (',' (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//	ownedRealizedVariables+=RealizedVariableCS))* '}' | '{' ownedConstraints+=PredicateOrAssignmentCS+ '}' |
		//	{BottomPatternCS} '{' '}';
		@Override public ParserRule getRule() { return rule; }

		//// Bug 466385 explains the redundancy below
		// '{' (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//ownedRealizedVariables+=RealizedVariableCS) (',' (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//ownedRealizedVariables+=RealizedVariableCS))* '|' ownedConstraints+=PredicateOrAssignmentCS* '}' | '{'
		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (','
		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '}' | '{'
		//ownedConstraints+=PredicateOrAssignmentCS+ '}' | {BottomPatternCS} '{' '}'
		public Alternatives getAlternatives() { return cAlternatives; }

		//// Bug 466385 explains the redundancy below
		// '{' (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//ownedRealizedVariables+=RealizedVariableCS) (',' (ownedUnrealizedVariables+=UnrealizedVariableCS |
		//ownedRealizedVariables+=RealizedVariableCS))* '|' ownedConstraints+=PredicateOrAssignmentCS* '}'
		public Group getGroup_0() { return cGroup_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_0_0() { return cLeftCurlyBracketKeyword_0_0; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_1_0() { return cOwnedUnrealizedVariablesAssignment_0_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_0_1_1() { return cOwnedRealizedVariablesAssignment_0_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0; }

		//(',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		public Alternatives getAlternatives_0_2_1() { return cAlternatives_0_2_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_2_1_0() { return cOwnedUnrealizedVariablesAssignment_0_2_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_0_2_1_1() { return cOwnedRealizedVariablesAssignment_0_2_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0; }

		//'|'
		public Keyword getVerticalLineKeyword_0_3() { return cVerticalLineKeyword_0_3; }

		//ownedConstraints+=PredicateOrAssignmentCS*
		public Assignment getOwnedConstraintsAssignment_0_4() { return cOwnedConstraintsAssignment_0_4; }

		//PredicateOrAssignmentCS
		public RuleCall getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0() { return cOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_0_5() { return cRightCurlyBracketKeyword_0_5; }

		//'{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (','
		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '}'
		public Group getGroup_1() { return cGroup_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1_0() { return cLeftCurlyBracketKeyword_1_0; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_1_0() { return cOwnedUnrealizedVariablesAssignment_1_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_1_1_1() { return cOwnedRealizedVariablesAssignment_1_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0; }

		//(',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//','
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		public Alternatives getAlternatives_1_2_1() { return cAlternatives_1_2_1; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_2_1_0() { return cOwnedUnrealizedVariablesAssignment_1_2_1_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0; }

		//ownedRealizedVariables+=RealizedVariableCS
		public Assignment getOwnedRealizedVariablesAssignment_1_2_1_1() { return cOwnedRealizedVariablesAssignment_1_2_1_1; }

		//RealizedVariableCS
		public RuleCall getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0() { return cOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_1_3() { return cRightCurlyBracketKeyword_1_3; }

		//'{' ownedConstraints+=PredicateOrAssignmentCS+ '}'
		public Group getGroup_2() { return cGroup_2; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//ownedConstraints+=PredicateOrAssignmentCS+
		public Assignment getOwnedConstraintsAssignment_2_1() { return cOwnedConstraintsAssignment_2_1; }

		//PredicateOrAssignmentCS
		public RuleCall getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0() { return cOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_2() { return cRightCurlyBracketKeyword_2_2; }

		//{BottomPatternCS} '{' '}'
		public Group getGroup_3() { return cGroup_3; }

		//{BottomPatternCS}
		public Action getBottomPatternCSAction_3_0() { return cBottomPatternCSAction_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3_1() { return cLeftCurlyBracketKeyword_3_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3_2() { return cRightCurlyBracketKeyword_3_2; }
	}

	public class DirectionCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.DirectionCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDirectionCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cImportsKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cImportsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cImportsPackageCrossReference_3_0 = (CrossReference)cImportsAssignment_3.eContents().get(0);
		private final RuleCall cImportsPackageUnrestrictedNameParserRuleCall_3_0_1 = (RuleCall)cImportsPackageCrossReference_3_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cImportsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cImportsPackageCrossReference_4_1_0 = (CrossReference)cImportsAssignment_4_1.eContents().get(0);
		private final RuleCall cImportsPackageUnrestrictedNameParserRuleCall_4_1_0_1 = (RuleCall)cImportsPackageCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cUsesKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cUsesAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final CrossReference cUsesCoreDomainCrossReference_5_1_0 = (CrossReference)cUsesAssignment_5_1.eContents().get(0);
		private final RuleCall cUsesCoreDomainUnrestrictedNameParserRuleCall_5_1_0_1 = (RuleCall)cUsesCoreDomainCrossReference_5_1_0.eContents().get(1);
		private final Group cGroup_5_2 = (Group)cGroup_5.eContents().get(2);
		private final Keyword cCommaKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cUsesAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final CrossReference cUsesCoreDomainCrossReference_5_2_1_0 = (CrossReference)cUsesAssignment_5_2_1.eContents().get(0);
		private final RuleCall cUsesCoreDomainUnrestrictedNameParserRuleCall_5_2_1_0_1 = (RuleCall)cUsesCoreDomainCrossReference_5_2_1_0.eContents().get(1);

		//DirectionCS:
		//	{DirectionCS} name=UnrestrictedName? 'imports' imports+=[pivot::Package|UnrestrictedName] (','
		//	imports+=[pivot::Package|UnrestrictedName])* ('uses' uses+=[qvtcore::CoreDomain|UnrestrictedName] (','
		//	uses+=[qvtcore::CoreDomain|UnrestrictedName])*)?;
		@Override public ParserRule getRule() { return rule; }

		//{DirectionCS} name=UnrestrictedName? 'imports' imports+=[pivot::Package|UnrestrictedName] (','
		//imports+=[pivot::Package|UnrestrictedName])* ('uses' uses+=[qvtcore::CoreDomain|UnrestrictedName] (','
		//uses+=[qvtcore::CoreDomain|UnrestrictedName])*)?
		public Group getGroup() { return cGroup; }

		//{DirectionCS}
		public Action getDirectionCSAction_0() { return cDirectionCSAction_0; }

		//name=UnrestrictedName?
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//'imports'
		public Keyword getImportsKeyword_2() { return cImportsKeyword_2; }

		//imports+=[pivot::Package|UnrestrictedName]
		public Assignment getImportsAssignment_3() { return cImportsAssignment_3; }

		//[pivot::Package|UnrestrictedName]
		public CrossReference getImportsPackageCrossReference_3_0() { return cImportsPackageCrossReference_3_0; }

		//UnrestrictedName
		public RuleCall getImportsPackageUnrestrictedNameParserRuleCall_3_0_1() { return cImportsPackageUnrestrictedNameParserRuleCall_3_0_1; }

		//(',' imports+=[pivot::Package|UnrestrictedName])*
		public Group getGroup_4() { return cGroup_4; }

		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//imports+=[pivot::Package|UnrestrictedName]
		public Assignment getImportsAssignment_4_1() { return cImportsAssignment_4_1; }

		//[pivot::Package|UnrestrictedName]
		public CrossReference getImportsPackageCrossReference_4_1_0() { return cImportsPackageCrossReference_4_1_0; }

		//UnrestrictedName
		public RuleCall getImportsPackageUnrestrictedNameParserRuleCall_4_1_0_1() { return cImportsPackageUnrestrictedNameParserRuleCall_4_1_0_1; }

		//('uses' uses+=[qvtcore::CoreDomain|UnrestrictedName] (',' uses+=[qvtcore::CoreDomain|UnrestrictedName])*)?
		public Group getGroup_5() { return cGroup_5; }

		//'uses'
		public Keyword getUsesKeyword_5_0() { return cUsesKeyword_5_0; }

		//uses+=[qvtcore::CoreDomain|UnrestrictedName]
		public Assignment getUsesAssignment_5_1() { return cUsesAssignment_5_1; }

		//[qvtcore::CoreDomain|UnrestrictedName]
		public CrossReference getUsesCoreDomainCrossReference_5_1_0() { return cUsesCoreDomainCrossReference_5_1_0; }

		//UnrestrictedName
		public RuleCall getUsesCoreDomainUnrestrictedNameParserRuleCall_5_1_0_1() { return cUsesCoreDomainUnrestrictedNameParserRuleCall_5_1_0_1; }

		//(',' uses+=[qvtcore::CoreDomain|UnrestrictedName])*
		public Group getGroup_5_2() { return cGroup_5_2; }

		//','
		public Keyword getCommaKeyword_5_2_0() { return cCommaKeyword_5_2_0; }

		//uses+=[qvtcore::CoreDomain|UnrestrictedName]
		public Assignment getUsesAssignment_5_2_1() { return cUsesAssignment_5_2_1; }

		//[qvtcore::CoreDomain|UnrestrictedName]
		public CrossReference getUsesCoreDomainCrossReference_5_2_1_0() { return cUsesCoreDomainCrossReference_5_2_1_0; }

		//UnrestrictedName
		public RuleCall getUsesCoreDomainUnrestrictedNameParserRuleCall_5_2_1_0_1() { return cUsesCoreDomainUnrestrictedNameParserRuleCall_5_2_1_0_1; }
	}

	public class GuardPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.GuardPatternCS");
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
		// GuardPatternCS:
		//	'(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* '|'
		//	ownedPredicates+=PredicateCS* ')' | '(' ownedUnrealizedVariables+=GuardVariableCS (','
		//	ownedUnrealizedVariables+=GuardVariableCS)* ')' | '(' ownedPredicates+=PredicateCS+ ')' | {GuardPatternCS} '(' ')';
		@Override public ParserRule getRule() { return rule; }

		//// Bug 466385 explains the redundancy below
		// '(' ownedUnrealizedVariables+=GuardVariableCS (','
		//ownedUnrealizedVariables+=GuardVariableCS)* '|' ownedPredicates+=PredicateCS* ')' | '('
		//ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* ')' | '('
		//ownedPredicates+=PredicateCS+ ')' | {GuardPatternCS} '(' ')'
		public Alternatives getAlternatives() { return cAlternatives; }

		//// Bug 466385 explains the redundancy below
		// '(' ownedUnrealizedVariables+=GuardVariableCS (','
		//ownedUnrealizedVariables+=GuardVariableCS)* '|' ownedPredicates+=PredicateCS* ')'
		public Group getGroup_0() { return cGroup_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_1() { return cOwnedUnrealizedVariablesAssignment_0_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0; }

		//(',' ownedUnrealizedVariables+=GuardVariableCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_0_2_1() { return cOwnedUnrealizedVariablesAssignment_0_2_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0; }

		//'|'
		public Keyword getVerticalLineKeyword_0_3() { return cVerticalLineKeyword_0_3; }

		//ownedPredicates+=PredicateCS*
		public Assignment getOwnedPredicatesAssignment_0_4() { return cOwnedPredicatesAssignment_0_4; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_0_4_0() { return cOwnedPredicatesPredicateCSParserRuleCall_0_4_0; }

		//')'
		public Keyword getRightParenthesisKeyword_0_5() { return cRightParenthesisKeyword_0_5; }

		//'(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* ')'
		public Group getGroup_1() { return cGroup_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_1() { return cOwnedUnrealizedVariablesAssignment_1_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0; }

		//(',' ownedUnrealizedVariables+=GuardVariableCS)*
		public Group getGroup_1_2() { return cGroup_1_2; }

		//','
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_1_2_1() { return cOwnedUnrealizedVariablesAssignment_1_2_1; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_1_3() { return cRightParenthesisKeyword_1_3; }

		//'(' ownedPredicates+=PredicateCS+ ')'
		public Group getGroup_2() { return cGroup_2; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//ownedPredicates+=PredicateCS+
		public Assignment getOwnedPredicatesAssignment_2_1() { return cOwnedPredicatesAssignment_2_1; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_2_1_0() { return cOwnedPredicatesPredicateCSParserRuleCall_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }

		//{GuardPatternCS} '(' ')'
		public Group getGroup_3() { return cGroup_3; }

		//{GuardPatternCS}
		public Action getGuardPatternCSAction_3_0() { return cGuardPatternCSAction_3_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_3_1() { return cLeftParenthesisKeyword_3_1; }

		//')'
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
	}

	public class GuardVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.GuardVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		////Variable := VariableName �:� TypeDeclaration
		// GuardVariableCS UnrealizedVariableCS:
		//	name=UnrestrictedName ':' ownedType=TypeExpCS
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ':' ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_0; }
	}

	public class ImportCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.ImportCS");
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

		//ImportCS base::ImportCS:
		//	'import' (name=Identifier ':')? ownedPathName=URIPathNameCS (isAll?='::' '*')? ';'
		@Override public ParserRule getRule() { return rule; }

		//'import' (name=Identifier ':')? ownedPathName=URIPathNameCS (isAll?='::' '*')? ';'
		public Group getGroup() { return cGroup; }

		//'import'
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//(name=Identifier ':')?
		public Group getGroup_1() { return cGroup_1; }

		//name=Identifier
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_1_0_0() { return cNameIdentifierParserRuleCall_1_0_0; }

		//':'
		public Keyword getColonKeyword_1_1() { return cColonKeyword_1_1; }

		//ownedPathName=URIPathNameCS
		public Assignment getOwnedPathNameAssignment_2() { return cOwnedPathNameAssignment_2; }

		//URIPathNameCS
		public RuleCall getOwnedPathNameURIPathNameCSParserRuleCall_2_0() { return cOwnedPathNameURIPathNameCSParserRuleCall_2_0; }

		//(isAll?='::' '*')?
		public Group getGroup_3() { return cGroup_3; }

		//isAll?='::'
		public Assignment getIsAllAssignment_3_0() { return cIsAllAssignment_3_0; }

		//'::'
		public Keyword getIsAllColonColonKeyword_3_0_0() { return cIsAllColonColonKeyword_3_0_0; }

		//'*'
		public Keyword getAsteriskKeyword_3_1() { return cAsteriskKeyword_3_1; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class MappingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.MappingCS");
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
		private final Keyword cRefinesKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cRefinesAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final CrossReference cRefinesMappingCrossReference_5_1_0 = (CrossReference)cRefinesAssignment_5_1.eContents().get(0);
		private final RuleCall cRefinesMappingUnrestrictedNameParserRuleCall_5_1_0_1 = (RuleCall)cRefinesMappingCrossReference_5_1_0.eContents().get(1);
		private final Group cGroup_5_2 = (Group)cGroup_5.eContents().get(2);
		private final Keyword cCommaKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cRefinesAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final CrossReference cRefinesMappingCrossReference_5_2_1_0 = (CrossReference)cRefinesAssignment_5_2_1.eContents().get(0);
		private final RuleCall cRefinesMappingUnrestrictedNameParserRuleCall_5_2_1_0_1 = (RuleCall)cRefinesMappingCrossReference_5_2_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cOwnedDomainsAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedDomainsNamedDomainCSParserRuleCall_7_0 = (RuleCall)cOwnedDomainsAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cWhereKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cOwnedMiddleAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0 = (RuleCall)cOwnedMiddleAssignment_8_1.eContents().get(0);
		private final Assignment cOwnedComposedMappingsAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cOwnedComposedMappingsMappingCSParserRuleCall_9_0 = (RuleCall)cOwnedComposedMappingsAssignment_9.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);

		//MappingCS:
		//	{MappingCS} isDefault?='default'? 'map' name=UnrestrictedName? ('in' ownedInPathName=PathNameCS)? ('refines'
		//	refines+=[qvtcore::Mapping|UnrestrictedName] (',' refines+=[qvtcore::Mapping|UnrestrictedName])*)? '{'
		//	ownedDomains+=NamedDomainCS* ('where' ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* '}';
		@Override public ParserRule getRule() { return rule; }

		//{MappingCS} isDefault?='default'? 'map' name=UnrestrictedName? ('in' ownedInPathName=PathNameCS)? ('refines'
		//refines+=[qvtcore::Mapping|UnrestrictedName] (',' refines+=[qvtcore::Mapping|UnrestrictedName])*)? '{'
		//ownedDomains+=NamedDomainCS* ('where' ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* '}'
		public Group getGroup() { return cGroup; }

		//{MappingCS}
		public Action getMappingCSAction_0() { return cMappingCSAction_0; }

		//isDefault?='default'?
		public Assignment getIsDefaultAssignment_1() { return cIsDefaultAssignment_1; }

		//'default'
		public Keyword getIsDefaultDefaultKeyword_1_0() { return cIsDefaultDefaultKeyword_1_0; }

		//'map'
		public Keyword getMapKeyword_2() { return cMapKeyword_2; }

		//name=UnrestrictedName?
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

		//('in' ownedInPathName=PathNameCS)?
		public Group getGroup_4() { return cGroup_4; }

		//'in'
		public Keyword getInKeyword_4_0() { return cInKeyword_4_0; }

		//ownedInPathName=PathNameCS
		public Assignment getOwnedInPathNameAssignment_4_1() { return cOwnedInPathNameAssignment_4_1; }

		//PathNameCS
		public RuleCall getOwnedInPathNamePathNameCSParserRuleCall_4_1_0() { return cOwnedInPathNamePathNameCSParserRuleCall_4_1_0; }

		//('refines' refines+=[qvtcore::Mapping|UnrestrictedName] (',' refines+=[qvtcore::Mapping|UnrestrictedName])*)?
		public Group getGroup_5() { return cGroup_5; }

		//'refines'
		public Keyword getRefinesKeyword_5_0() { return cRefinesKeyword_5_0; }

		//refines+=[qvtcore::Mapping|UnrestrictedName]
		public Assignment getRefinesAssignment_5_1() { return cRefinesAssignment_5_1; }

		//[qvtcore::Mapping|UnrestrictedName]
		public CrossReference getRefinesMappingCrossReference_5_1_0() { return cRefinesMappingCrossReference_5_1_0; }

		//UnrestrictedName
		public RuleCall getRefinesMappingUnrestrictedNameParserRuleCall_5_1_0_1() { return cRefinesMappingUnrestrictedNameParserRuleCall_5_1_0_1; }

		//(',' refines+=[qvtcore::Mapping|UnrestrictedName])*
		public Group getGroup_5_2() { return cGroup_5_2; }

		//','
		public Keyword getCommaKeyword_5_2_0() { return cCommaKeyword_5_2_0; }

		//refines+=[qvtcore::Mapping|UnrestrictedName]
		public Assignment getRefinesAssignment_5_2_1() { return cRefinesAssignment_5_2_1; }

		//[qvtcore::Mapping|UnrestrictedName]
		public CrossReference getRefinesMappingCrossReference_5_2_1_0() { return cRefinesMappingCrossReference_5_2_1_0; }

		//UnrestrictedName
		public RuleCall getRefinesMappingUnrestrictedNameParserRuleCall_5_2_1_0_1() { return cRefinesMappingUnrestrictedNameParserRuleCall_5_2_1_0_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }

		//ownedDomains+=NamedDomainCS*
		public Assignment getOwnedDomainsAssignment_7() { return cOwnedDomainsAssignment_7; }

		//NamedDomainCS
		public RuleCall getOwnedDomainsNamedDomainCSParserRuleCall_7_0() { return cOwnedDomainsNamedDomainCSParserRuleCall_7_0; }

		//('where' ownedMiddle=UnnamedDomainCS)?
		public Group getGroup_8() { return cGroup_8; }

		//'where'
		public Keyword getWhereKeyword_8_0() { return cWhereKeyword_8_0; }

		//ownedMiddle=UnnamedDomainCS
		public Assignment getOwnedMiddleAssignment_8_1() { return cOwnedMiddleAssignment_8_1; }

		//UnnamedDomainCS
		public RuleCall getOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0() { return cOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0; }

		//ownedComposedMappings+=MappingCS*
		public Assignment getOwnedComposedMappingsAssignment_9() { return cOwnedComposedMappingsAssignment_9; }

		//MappingCS
		public RuleCall getOwnedComposedMappingsMappingCSParserRuleCall_9_0() { return cOwnedComposedMappingsMappingCSParserRuleCall_9_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}

	public class NamedDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.NamedDomainCS");
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

		//NamedDomainCS DomainCS:
		//	isCheck?='check'? isEnforce?='enforce'? direction=[qvtbase::TypedModel|UnrestrictedName]
		//	ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		@Override public ParserRule getRule() { return rule; }

		//isCheck?='check'? isEnforce?='enforce'? direction=[qvtbase::TypedModel|UnrestrictedName]
		//ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		public Group getGroup() { return cGroup; }

		//isCheck?='check'?
		public Assignment getIsCheckAssignment_0() { return cIsCheckAssignment_0; }

		//'check'
		public Keyword getIsCheckCheckKeyword_0_0() { return cIsCheckCheckKeyword_0_0; }

		//isEnforce?='enforce'?
		public Assignment getIsEnforceAssignment_1() { return cIsEnforceAssignment_1; }

		//'enforce'
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

	public class QualifiedPackageCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.QualifiedPackageCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNameScopeNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cNsPrefixAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cNsPrefixUnrestrictedNameParserRuleCall_3_1_0 = (RuleCall)cNsPrefixAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cEqualsSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cNsURIAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cNsURIURIParserRuleCall_4_1_0 = (RuleCall)cNsURIAssignment_4_1.eContents().get(0);
		private final Alternatives cAlternatives_5 = (Alternatives)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cAlternatives_5.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Alternatives cAlternatives_5_0_1 = (Alternatives)cGroup_5_0.eContents().get(1);
		private final Assignment cOwnedPackagesAssignment_5_0_1_0 = (Assignment)cAlternatives_5_0_1.eContents().get(0);
		private final RuleCall cOwnedPackagesQualifiedPackageCSParserRuleCall_5_0_1_0_0 = (RuleCall)cOwnedPackagesAssignment_5_0_1_0.eContents().get(0);
		private final Assignment cOwnedClassesAssignment_5_0_1_1 = (Assignment)cAlternatives_5_0_1.eContents().get(1);
		private final Alternatives cOwnedClassesAlternatives_5_0_1_1_0 = (Alternatives)cOwnedClassesAssignment_5_0_1_1.eContents().get(0);
		private final RuleCall cOwnedClassesClassCSParserRuleCall_5_0_1_1_0_0 = (RuleCall)cOwnedClassesAlternatives_5_0_1_1_0.eContents().get(0);
		private final RuleCall cOwnedClassesTransformationCSParserRuleCall_5_0_1_1_0_1 = (RuleCall)cOwnedClassesAlternatives_5_0_1_1_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_5_0_2 = (Keyword)cGroup_5_0.eContents().get(2);
		private final Keyword cSemicolonKeyword_5_1 = (Keyword)cAlternatives_5.eContents().get(1);

		//QualifiedPackageCS qvtbasecs::QualifiedPackageCS:
		//	'package' ownedPathName=ScopeNameCS? name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)? ('{'
		//	(ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))* '}' | ';')
		@Override public ParserRule getRule() { return rule; }

		//'package' ownedPathName=ScopeNameCS? name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)? ('{'
		//(ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))* '}' | ';')
		public Group getGroup() { return cGroup; }

		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }

		//ownedPathName=ScopeNameCS?
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//ScopeNameCS
		public RuleCall getOwnedPathNameScopeNameCSParserRuleCall_1_0() { return cOwnedPathNameScopeNameCSParserRuleCall_1_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//(':' nsPrefix=UnrestrictedName)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//nsPrefix=UnrestrictedName
		public Assignment getNsPrefixAssignment_3_1() { return cNsPrefixAssignment_3_1; }

		//UnrestrictedName
		public RuleCall getNsPrefixUnrestrictedNameParserRuleCall_3_1_0() { return cNsPrefixUnrestrictedNameParserRuleCall_3_1_0; }

		//('=' nsURI=URI)?
		public Group getGroup_4() { return cGroup_4; }

		//'='
		public Keyword getEqualsSignKeyword_4_0() { return cEqualsSignKeyword_4_0; }

		//nsURI=URI
		public Assignment getNsURIAssignment_4_1() { return cNsURIAssignment_4_1; }

		//URI
		public RuleCall getNsURIURIParserRuleCall_4_1_0() { return cNsURIURIParserRuleCall_4_1_0; }

		//('{' (ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))* '}' | ';')
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//'{' (ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))* '}'
		public Group getGroup_5_0() { return cGroup_5_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0_0() { return cLeftCurlyBracketKeyword_5_0_0; }

		//(ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))*
		public Alternatives getAlternatives_5_0_1() { return cAlternatives_5_0_1; }

		/// * ownedAnnotations+=AnnotationElementCS | * / ownedPackages+=QualifiedPackageCS
		public Assignment getOwnedPackagesAssignment_5_0_1_0() { return cOwnedPackagesAssignment_5_0_1_0; }

		//QualifiedPackageCS
		public RuleCall getOwnedPackagesQualifiedPackageCSParserRuleCall_5_0_1_0_0() { return cOwnedPackagesQualifiedPackageCSParserRuleCall_5_0_1_0_0; }

		//ownedClasses+=(ClassCS | TransformationCS)
		public Assignment getOwnedClassesAssignment_5_0_1_1() { return cOwnedClassesAssignment_5_0_1_1; }

		//(ClassCS | TransformationCS)
		public Alternatives getOwnedClassesAlternatives_5_0_1_1_0() { return cOwnedClassesAlternatives_5_0_1_1_0; }

		//ClassCS
		public RuleCall getOwnedClassesClassCSParserRuleCall_5_0_1_1_0_0() { return cOwnedClassesClassCSParserRuleCall_5_0_1_1_0_0; }

		//TransformationCS
		public RuleCall getOwnedClassesTransformationCSParserRuleCall_5_0_1_1_0_1() { return cOwnedClassesTransformationCSParserRuleCall_5_0_1_1_0_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5_0_2() { return cRightCurlyBracketKeyword_5_0_2; }

		//';'
		public Keyword getSemicolonKeyword_5_1() { return cSemicolonKeyword_5_1; }
	}

	public class ParamDeclarationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.ParamDeclarationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//ParamDeclarationCS:
		//	name=UnrestrictedName ':' ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ':' ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_0; }
	}

	public class PredicateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.PredicateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedConditionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedConditionExpCSParserRuleCall_0_0 = (RuleCall)cOwnedConditionAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);

		//PredicateCS:
		//	ownedCondition=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//ownedCondition=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//ownedCondition=ExpCS
		public Assignment getOwnedConditionAssignment_0() { return cOwnedConditionAssignment_0; }

		//ExpCS
		public RuleCall getOwnedConditionExpCSParserRuleCall_0_0() { return cOwnedConditionExpCSParserRuleCall_0_0; }

		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}

	public class PredicateOrAssignmentCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.PredicateOrAssignmentCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsDefaultAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsDefaultDefaultKeyword_0_0 = (Keyword)cIsDefaultAssignment_0.eContents().get(0);
		private final Assignment cOwnedTargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedTargetExpCSParserRuleCall_1_0 = (RuleCall)cOwnedTargetAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_2_0 = (Alternatives)cGroup_2.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_2_0_0 = (Keyword)cAlternatives_2_0.eContents().get(0);
		private final Assignment cIsPartialAssignment_2_0_1 = (Assignment)cAlternatives_2_0.eContents().get(1);
		private final Keyword cIsPartialPlusSignEqualsSignKeyword_2_0_1_0 = (Keyword)cIsPartialAssignment_2_0_1.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);

		////Constraint ::= Predicate | Assignment
		// //Predicate ::= BooleanOCLExpr
		//
		////Assignement ::= [�default�] SlotOwnerOCLExpr�.�PropertyName �:=� ValueOCLExpr
		// PredicateOrAssignmentCS:
		//	isDefault?='default'? ownedTarget=ExpCS ((':=' | isPartial?='+=') ownedInitExpression=ExpCS)? ';';
		@Override public ParserRule getRule() { return rule; }

		//isDefault?='default'? ownedTarget=ExpCS ((':=' | isPartial?='+=') ownedInitExpression=ExpCS)? ';'
		public Group getGroup() { return cGroup; }

		//isDefault?='default'?
		public Assignment getIsDefaultAssignment_0() { return cIsDefaultAssignment_0; }

		//'default'
		public Keyword getIsDefaultDefaultKeyword_0_0() { return cIsDefaultDefaultKeyword_0_0; }

		//ownedTarget=ExpCS
		public Assignment getOwnedTargetAssignment_1() { return cOwnedTargetAssignment_1; }

		//ExpCS
		public RuleCall getOwnedTargetExpCSParserRuleCall_1_0() { return cOwnedTargetExpCSParserRuleCall_1_0; }

		//((':=' | isPartial?='+=') ownedInitExpression=ExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//(':=' | isPartial?='+=')
		public Alternatives getAlternatives_2_0() { return cAlternatives_2_0; }

		//':='
		public Keyword getColonEqualsSignKeyword_2_0_0() { return cColonEqualsSignKeyword_2_0_0; }

		//isPartial?='+='
		public Assignment getIsPartialAssignment_2_0_1() { return cIsPartialAssignment_2_0_1; }

		//'+='
		public Keyword getIsPartialPlusSignEqualsSignKeyword_2_0_1_0() { return cIsPartialPlusSignEqualsSignKeyword_2_0_1_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_1() { return cOwnedInitExpressionAssignment_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_1_0; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class QueryCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.QueryCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsTransientAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsTransientTransientKeyword_0_0 = (Keyword)cIsTransientAssignment_0.eContents().get(0);
		private final Keyword cQueryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNameScopeNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cOwnedParametersAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cOwnedParametersParamDeclarationCSParserRuleCall_5_0_0 = (RuleCall)cOwnedParametersAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cCommaKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cOwnedParametersAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final RuleCall cOwnedParametersParamDeclarationCSParserRuleCall_5_1_1_0 = (RuleCall)cOwnedParametersAssignment_5_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cColonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cOwnedTypeAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_8_0 = (RuleCall)cOwnedTypeAssignment_8.eContents().get(0);
		private final Alternatives cAlternatives_9 = (Alternatives)cGroup.eContents().get(9);
		private final Keyword cSemicolonKeyword_9_0 = (Keyword)cAlternatives_9.eContents().get(0);
		private final Group cGroup_9_1 = (Group)cAlternatives_9.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_9_1_0 = (Keyword)cGroup_9_1.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_9_1_1 = (Assignment)cGroup_9_1.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_9_1_1_0 = (RuleCall)cOwnedExpressionAssignment_9_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9_1_2 = (Keyword)cGroup_9_1.eContents().get(2);

		//QueryCS:
		//	isTransient?='transient'? 'query' ownedPathName=ScopeNameCS name=UnrestrictedName '('
		//	(ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)? ')' ':' ownedType=TypeExpCS (';' |
		//	'{' ownedExpression=ExpCS '}');
		@Override public ParserRule getRule() { return rule; }

		//isTransient?='transient'? 'query' ownedPathName=ScopeNameCS name=UnrestrictedName '('
		//(ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)? ')' ':' ownedType=TypeExpCS (';' |
		//'{' ownedExpression=ExpCS '}')
		public Group getGroup() { return cGroup; }

		//isTransient?='transient'?
		public Assignment getIsTransientAssignment_0() { return cIsTransientAssignment_0; }

		//'transient'
		public Keyword getIsTransientTransientKeyword_0_0() { return cIsTransientTransientKeyword_0_0; }

		//'query'
		public Keyword getQueryKeyword_1() { return cQueryKeyword_1; }

		//ownedPathName=ScopeNameCS
		public Assignment getOwnedPathNameAssignment_2() { return cOwnedPathNameAssignment_2; }

		//ScopeNameCS
		public RuleCall getOwnedPathNameScopeNameCSParserRuleCall_2_0() { return cOwnedPathNameScopeNameCSParserRuleCall_2_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }

		//(ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)?
		public Group getGroup_5() { return cGroup_5; }

		//ownedParameters+=ParamDeclarationCS
		public Assignment getOwnedParametersAssignment_5_0() { return cOwnedParametersAssignment_5_0; }

		//ParamDeclarationCS
		public RuleCall getOwnedParametersParamDeclarationCSParserRuleCall_5_0_0() { return cOwnedParametersParamDeclarationCSParserRuleCall_5_0_0; }

		//(',' ownedParameters+=ParamDeclarationCS)*
		public Group getGroup_5_1() { return cGroup_5_1; }

		//','
		public Keyword getCommaKeyword_5_1_0() { return cCommaKeyword_5_1_0; }

		//ownedParameters+=ParamDeclarationCS
		public Assignment getOwnedParametersAssignment_5_1_1() { return cOwnedParametersAssignment_5_1_1; }

		//ParamDeclarationCS
		public RuleCall getOwnedParametersParamDeclarationCSParserRuleCall_5_1_1_0() { return cOwnedParametersParamDeclarationCSParserRuleCall_5_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }

		//':'
		public Keyword getColonKeyword_7() { return cColonKeyword_7; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_8() { return cOwnedTypeAssignment_8; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_8_0() { return cOwnedTypeTypeExpCSParserRuleCall_8_0; }

		//(';' | '{' ownedExpression=ExpCS '}')
		public Alternatives getAlternatives_9() { return cAlternatives_9; }

		//';'
		public Keyword getSemicolonKeyword_9_0() { return cSemicolonKeyword_9_0; }

		//'{' ownedExpression=ExpCS '}'
		public Group getGroup_9_1() { return cGroup_9_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_9_1_0() { return cLeftCurlyBracketKeyword_9_1_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_9_1_1() { return cOwnedExpressionAssignment_9_1_1; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_9_1_1_0() { return cOwnedExpressionExpCSParserRuleCall_9_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_9_1_2() { return cRightCurlyBracketKeyword_9_1_2; }
	}

	public class ScopeNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.ScopeNameCS");
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
		// ScopeNameCS base::PathNameCS:
		//	ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*
		@Override public ParserRule getRule() { return rule; }

		//ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*
		public Group getGroup() { return cGroup; }

		//ownedPathElements+=FirstPathElementCS
		public Assignment getOwnedPathElementsAssignment_0() { return cOwnedPathElementsAssignment_0; }

		//FirstPathElementCS
		public RuleCall getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0() { return cOwnedPathElementsFirstPathElementCSParserRuleCall_0_0; }

		//'::'
		public Keyword getColonColonKeyword_1() { return cColonColonKeyword_1; }

		//(ownedPathElements+=NextPathElementCS '::')*
		public Group getGroup_2() { return cGroup_2; }

		//ownedPathElements+=NextPathElementCS
		public Assignment getOwnedPathElementsAssignment_2_0() { return cOwnedPathElementsAssignment_2_0; }

		//NextPathElementCS
		public RuleCall getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0() { return cOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0; }

		//'::'
		public Keyword getColonColonKeyword_2_1() { return cColonColonKeyword_2_1; }
	}

	public class TransformationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.TransformationCS");
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
		//	'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* '}';
		@Override public ParserRule getRule() { return rule; }

		//'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* '}'
		public Group getGroup() { return cGroup; }

		//'transformation'
		public Keyword getTransformationKeyword_0() { return cTransformationKeyword_0; }

		//ownedPathName=ScopeNameCS?
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//ScopeNameCS
		public RuleCall getOwnedPathNameScopeNameCSParserRuleCall_1_0() { return cOwnedPathNameScopeNameCSParserRuleCall_1_0; }

		//name=UnreservedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnreservedName
		public RuleCall getNameUnreservedNameParserRuleCall_2_0() { return cNameUnreservedNameParserRuleCall_2_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//(ownedDirections+=DirectionCS ';')*
		public Group getGroup_4() { return cGroup_4; }

		//ownedDirections+=DirectionCS
		public Assignment getOwnedDirectionsAssignment_4_0() { return cOwnedDirectionsAssignment_4_0; }

		//DirectionCS
		public RuleCall getOwnedDirectionsDirectionCSParserRuleCall_4_0_0() { return cOwnedDirectionsDirectionCSParserRuleCall_4_0_0; }

		//';'
		public Keyword getSemicolonKeyword_4_1() { return cSemicolonKeyword_4_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class UnrealizedVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.UnrealizedVariableCS");
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
		//	name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)?;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)?
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_1_1() { return cOwnedTypeAssignment_1_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_1_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_1_1_0; }

		//(':=' ownedInitExpression=ExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//':='
		public Keyword getColonEqualsSignKeyword_2_0() { return cColonEqualsSignKeyword_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_1() { return cOwnedInitExpressionAssignment_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_1_0; }
	}

	public class RealizedVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.RealizedVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRealizeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_3_0 = (RuleCall)cOwnedTypeAssignment_3.eContents().get(0);

		////RealizedVariable := �realized� VariableName �:� TypeDeclaration
		// RealizedVariableCS:
		//	'realize' name=UnrestrictedName ':' ownedType=TypeExpCS;
		@Override public ParserRule getRule() { return rule; }

		//'realize' name=UnrestrictedName ':' ownedType=TypeExpCS
		public Group getGroup() { return cGroup; }

		//'realize'
		public Keyword getRealizeKeyword_0() { return cRealizeKeyword_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_3() { return cOwnedTypeAssignment_3; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_3_0() { return cOwnedTypeTypeExpCSParserRuleCall_3_0; }
	}

	public class UnnamedDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.UnnamedDomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDomainCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cOwnedGuardPatternAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedGuardPatternGuardPatternCSParserRuleCall_1_0 = (RuleCall)cOwnedGuardPatternAssignment_1.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedBottomPatternBottomPatternCSParserRuleCall_2_0 = (RuleCall)cOwnedBottomPatternAssignment_2.eContents().get(0);

		//UnnamedDomainCS DomainCS:
		//	{DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
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

	public class QVTcoreUnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.QVTcoreUnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cCheckKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cEnforceKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cImportKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cImportsKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cMapKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cPackageKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cQueryKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cRealizeKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cRefinesKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cTransformationKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cTransientKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cUsesKeyword_11 = (Keyword)cAlternatives.eContents().get(11);

		//QVTcoreUnrestrictedName:
		//	'check' //|	'default'
		// | 'enforce' | 'import' | 'imports' | 'map' | 'package' | 'query' | 'realize' | 'refines' |
		//	'transformation' | 'transient' | 'uses' //|	'where'
		//;
		@Override public ParserRule getRule() { return rule; }

		//'check' //|	'default'
		// | 'enforce' | 'import' | 'imports' | 'map' | 'package' | 'query' | 'realize' | 'refines' |
		//'transformation' | 'transient' | 'uses'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'check'
		public Keyword getCheckKeyword_0() { return cCheckKeyword_0; }

		//'enforce'
		public Keyword getEnforceKeyword_1() { return cEnforceKeyword_1; }

		//'import'
		public Keyword getImportKeyword_2() { return cImportKeyword_2; }

		//'imports'
		public Keyword getImportsKeyword_3() { return cImportsKeyword_3; }

		//'map'
		public Keyword getMapKeyword_4() { return cMapKeyword_4; }

		//'package'
		public Keyword getPackageKeyword_5() { return cPackageKeyword_5; }

		//'query'
		public Keyword getQueryKeyword_6() { return cQueryKeyword_6; }

		//'realize'
		public Keyword getRealizeKeyword_7() { return cRealizeKeyword_7; }

		//'refines'
		public Keyword getRefinesKeyword_8() { return cRefinesKeyword_8; }

		//'transformation'
		public Keyword getTransformationKeyword_9() { return cTransformationKeyword_9; }

		//'transient'
		public Keyword getTransientKeyword_10() { return cTransientKeyword_10; }

		//'uses'
		public Keyword getUsesKeyword_11() { return cUsesKeyword_11; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.UnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cQVTbaseUnrestrictedNameParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cQVTcoreUnrestrictedNameParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		////|	'creation'
		// //|	'deletion'
		// //|	'include'
		// //|	'library'
		// UnrestrictedName:
		//	EssentialOCLUnrestrictedName | QVTbaseUnrestrictedName | QVTcoreUnrestrictedName;
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName | QVTbaseUnrestrictedName | QVTcoreUnrestrictedName
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall_0() { return cEssentialOCLUnrestrictedNameParserRuleCall_0; }

		//QVTbaseUnrestrictedName
		public RuleCall getQVTbaseUnrestrictedNameParserRuleCall_1() { return cQVTbaseUnrestrictedNameParserRuleCall_1; }

		//QVTcoreUnrestrictedName
		public RuleCall getQVTcoreUnrestrictedNameParserRuleCall_2() { return cQVTcoreUnrestrictedNameParserRuleCall_2; }
	}


	private final TopLevelCSElements pTopLevelCS;
	private final BottomPatternCSElements pBottomPatternCS;
	private final DirectionCSElements pDirectionCS;
	private final GuardPatternCSElements pGuardPatternCS;
	private final GuardVariableCSElements pGuardVariableCS;
	private final ImportCSElements pImportCS;
	private final MappingCSElements pMappingCS;
	private final NamedDomainCSElements pNamedDomainCS;
	private final QualifiedPackageCSElements pQualifiedPackageCS;
	private final ParamDeclarationCSElements pParamDeclarationCS;
	private final PredicateCSElements pPredicateCS;
	private final PredicateOrAssignmentCSElements pPredicateOrAssignmentCS;
	private final QueryCSElements pQueryCS;
	private final ScopeNameCSElements pScopeNameCS;
	private final TransformationCSElements pTransformationCS;
	private final UnrealizedVariableCSElements pUnrealizedVariableCS;
	private final RealizedVariableCSElements pRealizedVariableCS;
	private final UnnamedDomainCSElements pUnnamedDomainCS;
	private final QVTcoreUnrestrictedNameElements pQVTcoreUnrestrictedName;
	private final UnrestrictedNameElements pUnrestrictedName;

	private final Grammar grammar;

	private final QVTbaseGrammarAccess gaQVTbase;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	private final BaseGrammarAccess gaBase;

	@Inject
	public QVTcoreGrammarAccess(GrammarProvider grammarProvider,
		QVTbaseGrammarAccess gaQVTbase,
		EssentialOCLGrammarAccess gaEssentialOCL,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaQVTbase = gaQVTbase;
		this.gaEssentialOCL = gaEssentialOCL;
		this.gaBase = gaBase;
		this.pTopLevelCS = new TopLevelCSElements();
		this.pBottomPatternCS = new BottomPatternCSElements();
		this.pDirectionCS = new DirectionCSElements();
		this.pGuardPatternCS = new GuardPatternCSElements();
		this.pGuardVariableCS = new GuardVariableCSElements();
		this.pImportCS = new ImportCSElements();
		this.pMappingCS = new MappingCSElements();
		this.pNamedDomainCS = new NamedDomainCSElements();
		this.pQualifiedPackageCS = new QualifiedPackageCSElements();
		this.pParamDeclarationCS = new ParamDeclarationCSElements();
		this.pPredicateCS = new PredicateCSElements();
		this.pPredicateOrAssignmentCS = new PredicateOrAssignmentCSElements();
		this.pQueryCS = new QueryCSElements();
		this.pScopeNameCS = new ScopeNameCSElements();
		this.pTransformationCS = new TransformationCSElements();
		this.pUnrealizedVariableCS = new UnrealizedVariableCSElements();
		this.pRealizedVariableCS = new RealizedVariableCSElements();
		this.pUnnamedDomainCS = new UnnamedDomainCSElements();
		this.pQVTcoreUnrestrictedName = new QVTcoreUnrestrictedNameElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.qvtd.xtext.qvtcore.QVTcore".equals(grammar.getName())) {
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


	public QVTbaseGrammarAccess getQVTbaseGrammarAccess() {
		return gaQVTbase;
	}

	public EssentialOCLGrammarAccess getEssentialOCLGrammarAccess() {
		return gaEssentialOCL;
	}

	public BaseGrammarAccess getBaseGrammarAccess() {
		return gaBase;
	}


	//TopLevelCS:
	//	ownedImports+=ImportCS* (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS |
	//	ownedMappings+=MappingCS | ownedQueries+=QueryCS)*;
	public TopLevelCSElements getTopLevelCSAccess() {
		return pTopLevelCS;
	}

	public ParserRule getTopLevelCSRule() {
		return getTopLevelCSAccess().getRule();
	}

	//BottomPatternCS:
	//	'{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS) (','
	//	(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '|'
	//	ownedConstraints+=PredicateOrAssignmentCS* '}' | '{' (ownedUnrealizedVariables+=UnrealizedVariableCS |
	//	ownedRealizedVariables+=RealizedVariableCS) (',' (ownedUnrealizedVariables+=UnrealizedVariableCS |
	//	ownedRealizedVariables+=RealizedVariableCS))* '}' | '{' ownedConstraints+=PredicateOrAssignmentCS+ '}' |
	//	{BottomPatternCS} '{' '}';
	public BottomPatternCSElements getBottomPatternCSAccess() {
		return pBottomPatternCS;
	}

	public ParserRule getBottomPatternCSRule() {
		return getBottomPatternCSAccess().getRule();
	}

	//DirectionCS:
	//	{DirectionCS} name=UnrestrictedName? 'imports' imports+=[pivot::Package|UnrestrictedName] (','
	//	imports+=[pivot::Package|UnrestrictedName])* ('uses' uses+=[qvtcore::CoreDomain|UnrestrictedName] (','
	//	uses+=[qvtcore::CoreDomain|UnrestrictedName])*)?;
	public DirectionCSElements getDirectionCSAccess() {
		return pDirectionCS;
	}

	public ParserRule getDirectionCSRule() {
		return getDirectionCSAccess().getRule();
	}

	////EnforcementOperationCS: ('creation'|'deletion') ExpCS ';';
	// GuardPatternCS:
	//	'(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* '|'
	//	ownedPredicates+=PredicateCS* ')' | '(' ownedUnrealizedVariables+=GuardVariableCS (','
	//	ownedUnrealizedVariables+=GuardVariableCS)* ')' | '(' ownedPredicates+=PredicateCS+ ')' | {GuardPatternCS} '(' ')';
	public GuardPatternCSElements getGuardPatternCSAccess() {
		return pGuardPatternCS;
	}

	public ParserRule getGuardPatternCSRule() {
		return getGuardPatternCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	// GuardVariableCS UnrealizedVariableCS:
	//	name=UnrestrictedName ':' ownedType=TypeExpCS
	public GuardVariableCSElements getGuardVariableCSAccess() {
		return pGuardVariableCS;
	}

	public ParserRule getGuardVariableCSRule() {
		return getGuardVariableCSAccess().getRule();
	}

	//ImportCS base::ImportCS:
	//	'import' (name=Identifier ':')? ownedPathName=URIPathNameCS (isAll?='::' '*')? ';'
	public ImportCSElements getImportCSAccess() {
		return pImportCS;
	}

	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	//MappingCS:
	//	{MappingCS} isDefault?='default'? 'map' name=UnrestrictedName? ('in' ownedInPathName=PathNameCS)? ('refines'
	//	refines+=[qvtcore::Mapping|UnrestrictedName] (',' refines+=[qvtcore::Mapping|UnrestrictedName])*)? '{'
	//	ownedDomains+=NamedDomainCS* ('where' ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* '}';
	public MappingCSElements getMappingCSAccess() {
		return pMappingCS;
	}

	public ParserRule getMappingCSRule() {
		return getMappingCSAccess().getRule();
	}

	//NamedDomainCS DomainCS:
	//	isCheck?='check'? isEnforce?='enforce'? direction=[qvtbase::TypedModel|UnrestrictedName]
	//	ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
	public NamedDomainCSElements getNamedDomainCSAccess() {
		return pNamedDomainCS;
	}

	public ParserRule getNamedDomainCSRule() {
		return getNamedDomainCSAccess().getRule();
	}

	//QualifiedPackageCS qvtbasecs::QualifiedPackageCS:
	//	'package' ownedPathName=ScopeNameCS? name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)? ('{'
	//	(ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))* '}' | ';')
	public QualifiedPackageCSElements getQualifiedPackageCSAccess() {
		return pQualifiedPackageCS;
	}

	public ParserRule getQualifiedPackageCSRule() {
		return getQualifiedPackageCSAccess().getRule();
	}

	//ParamDeclarationCS:
	//	name=UnrestrictedName ':' ownedType=TypeExpCS;
	public ParamDeclarationCSElements getParamDeclarationCSAccess() {
		return pParamDeclarationCS;
	}

	public ParserRule getParamDeclarationCSRule() {
		return getParamDeclarationCSAccess().getRule();
	}

	//PredicateCS:
	//	ownedCondition=ExpCS ';';
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
	//	isDefault?='default'? ownedTarget=ExpCS ((':=' | isPartial?='+=') ownedInitExpression=ExpCS)? ';';
	public PredicateOrAssignmentCSElements getPredicateOrAssignmentCSAccess() {
		return pPredicateOrAssignmentCS;
	}

	public ParserRule getPredicateOrAssignmentCSRule() {
		return getPredicateOrAssignmentCSAccess().getRule();
	}

	//QueryCS:
	//	isTransient?='transient'? 'query' ownedPathName=ScopeNameCS name=UnrestrictedName '('
	//	(ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)? ')' ':' ownedType=TypeExpCS (';' |
	//	'{' ownedExpression=ExpCS '}');
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
	// ScopeNameCS base::PathNameCS:
	//	ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*
	public ScopeNameCSElements getScopeNameCSAccess() {
		return pScopeNameCS;
	}

	public ParserRule getScopeNameCSRule() {
		return getScopeNameCSAccess().getRule();
	}

	//TransformationCS:
	//	'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* '}';
	public TransformationCSElements getTransformationCSAccess() {
		return pTransformationCS;
	}

	public ParserRule getTransformationCSRule() {
		return getTransformationCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	// UnrealizedVariableCS:
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)?;
	public UnrealizedVariableCSElements getUnrealizedVariableCSAccess() {
		return pUnrealizedVariableCS;
	}

	public ParserRule getUnrealizedVariableCSRule() {
		return getUnrealizedVariableCSAccess().getRule();
	}

	////RealizedVariable := �realized� VariableName �:� TypeDeclaration
	// RealizedVariableCS:
	//	'realize' name=UnrestrictedName ':' ownedType=TypeExpCS;
	public RealizedVariableCSElements getRealizedVariableCSAccess() {
		return pRealizedVariableCS;
	}

	public ParserRule getRealizedVariableCSRule() {
		return getRealizedVariableCSAccess().getRule();
	}

	//UnnamedDomainCS DomainCS:
	//	{DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
	public UnnamedDomainCSElements getUnnamedDomainCSAccess() {
		return pUnnamedDomainCS;
	}

	public ParserRule getUnnamedDomainCSRule() {
		return getUnnamedDomainCSAccess().getRule();
	}

	//QVTcoreUnrestrictedName:
	//	'check' //|	'default'
	// | 'enforce' | 'import' | 'imports' | 'map' | 'package' | 'query' | 'realize' | 'refines' |
	//	'transformation' | 'transient' | 'uses' //|	'where'
	//;
	public QVTcoreUnrestrictedNameElements getQVTcoreUnrestrictedNameAccess() {
		return pQVTcoreUnrestrictedName;
	}

	public ParserRule getQVTcoreUnrestrictedNameRule() {
		return getQVTcoreUnrestrictedNameAccess().getRule();
	}

	////|	'creation'
	// //|	'deletion'
	// //|	'include'
	// //|	'library'
	// UnrestrictedName:
	//	EssentialOCLUnrestrictedName | QVTbaseUnrestrictedName | QVTcoreUnrestrictedName;
	public UnrestrictedNameElements getUnrestrictedNameAccess() {
		return pUnrestrictedName;
	}

	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	//AttributeCS base::AttributeCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)? 'attribute'
	//	name=super::UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{'
	//	((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='id' | qualifiers+='!id' | qualifiers+='ordered' |
	//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='transient' |
	//	qualifiers+='!transient' | qualifiers+='unique' | qualifiers+='!unique' | qualifiers+='unsettable' |
	//	qualifiers+='!unsettable' | qualifiers+='volatile' | qualifiers+='!volatile') ','?)+ '}')? ('{' ('initial'
	//	super::UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' super::UnrestrictedName?
	//	':' ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
	public QVTbaseGrammarAccess.AttributeCSElements getAttributeCSAccess() {
		return gaQVTbase.getAttributeCSAccess();
	}

	public ParserRule getAttributeCSRule() {
		return getAttributeCSAccess().getRule();
	}

	//ClassCS base::ClassCS:
	//	StructuredClassCS | DataTypeCS | EnumerationCS
	public QVTbaseGrammarAccess.ClassCSElements getClassCSAccess() {
		return gaQVTbase.getClassCSAccess();
	}

	public ParserRule getClassCSRule() {
		return getClassCSAccess().getRule();
	}

	//DataTypeCS base::DataTypeCS:
	//	isPrimitive?='primitive'? 'datatype' name=super::UnrestrictedName ownedSignature=TemplateSignatureCS? (':'
	//	instanceClassName=SINGLE_QUOTED_STRING)? ('{' (isSerializable?='serializable' | '!serializable')? '}')? ('{'
	//	/ *(ownedAnnotations+=AnnotationElementCS
	//	        | ownedConstraints+=InvariantConstraintCS)* * / '}' | ';')
	public QVTbaseGrammarAccess.DataTypeCSElements getDataTypeCSAccess() {
		return gaQVTbase.getDataTypeCSAccess();
	}

	public ParserRule getDataTypeCSRule() {
		return getDataTypeCSAccess().getRule();
	}

	//EnumerationCS base::EnumerationCS:
	//	'enum' name=super::UnrestrictedName ownedSignature=TemplateSignatureCS? (':' instanceClassName=SINGLE_QUOTED_STRING)?
	//	('{' (isSerializable?='serializable' | '!serializable')? '}')? ('{' ownedLiterals+=EnumerationLiteralCS
	//	/ *| ownedConstraints+=InvariantConstraintCS* / * '}' | ';')
	public QVTbaseGrammarAccess.EnumerationCSElements getEnumerationCSAccess() {
		return gaQVTbase.getEnumerationCSAccess();
	}

	public ParserRule getEnumerationCSRule() {
		return getEnumerationCSAccess().getRule();
	}

	//EnumerationLiteralCS base::EnumerationLiteralCS:
	//	('literal' name=super::UnrestrictedName | name=EnumerationLiteralName) ('=' value=SIGNED)? ('{'
	//	/ *ownedAnnotations+=AnnotationElementCS* * / '}' | ';')
	public QVTbaseGrammarAccess.EnumerationLiteralCSElements getEnumerationLiteralCSAccess() {
		return gaQVTbase.getEnumerationLiteralCSAccess();
	}

	public ParserRule getEnumerationLiteralCSRule() {
		return getEnumerationLiteralCSAccess().getRule();
	}

	//OperationCS base::OperationCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)? 'operation'
	//	ownedSignature=TemplateSignatureCS? name=super::UnrestrictedName '(' (ownedParameters+=ParameterCS (','
	//	ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)? ('throws' ownedExceptions+=TypedRefCS
	//	(',' ownedExceptions+=TypedRefCS)*)? ('{' ((qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' |
	//	qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+ '}')? ('{' ('body'
	//	super::UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';')* '}' | ';')
	public QVTbaseGrammarAccess.OperationCSElements getOperationCSAccess() {
		return gaQVTbase.getOperationCSAccess();
	}

	public ParserRule getOperationCSRule() {
		return getOperationCSAccess().getRule();
	}

	//ParameterCS base::ParameterCS:
	//	name=super::UnrestrictedName (':' ownedType=TypedMultiplicityRefCS)? ('{' ((qualifiers+='ordered' |
	//	qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique') ','?)+ '}')? ('{'
	//	/ *ownedAnnotations+=AnnotationElementCS* * / '}')?
	public QVTbaseGrammarAccess.ParameterCSElements getParameterCSAccess() {
		return gaQVTbase.getParameterCSAccess();
	}

	public ParserRule getParameterCSRule() {
		return getParameterCSAccess().getRule();
	}

	//ReferenceCS base::ReferenceCS:
	//	(qualifiers+='static' qualifiers+='definition'? | qualifiers+='definition' qualifiers+='static'?)? 'property'
	//	name=super::UnrestrictedName ('#' referredOpposite=[pivot::Property|super::UnrestrictedName])? (':'
	//	ownedType=TypedMultiplicityRefCS)? ('=' default=SINGLE_QUOTED_STRING)? ('{' ((qualifiers+='composes' |
	//	qualifiers+='!composes' | qualifiers+='derived' | qualifiers+='!derived' | qualifiers+='ordered' |
	//	qualifiers+='!ordered' | qualifiers+='readonly' | qualifiers+='!readonly' | qualifiers+='resolve' |
	//	qualifiers+='!resolve' | qualifiers+='transient' | qualifiers+='!transient' | qualifiers+='unique' |
	//	qualifiers+='!unique' | qualifiers+='unsettable' | qualifiers+='!unsettable' | qualifiers+='volatile' |
	//	qualifiers+='!volatile') ','?)+ '}')? ('{' ('initial' super::UnrestrictedName? ':'
	//	ownedDefaultExpressions+=SpecificationCS? ';' | 'derivation' super::UnrestrictedName? ':'
	//	ownedDefaultExpressions+=SpecificationCS? ';')* '}' | ';')
	public QVTbaseGrammarAccess.ReferenceCSElements getReferenceCSAccess() {
		return gaQVTbase.getReferenceCSAccess();
	}

	public ParserRule getReferenceCSRule() {
		return getReferenceCSAccess().getRule();
	}

	//SpecificationCS essentialocl::ExpSpecificationCS:
	//	ownedExpression=ExpCS | exprString=UNQUOTED_STRING
	public QVTbaseGrammarAccess.SpecificationCSElements getSpecificationCSAccess() {
		return gaQVTbase.getSpecificationCSAccess();
	}

	public ParserRule getSpecificationCSRule() {
		return getSpecificationCSAccess().getRule();
	}

	//StructuredClassCS base::StructuredClassCS:
	//	isAbstract?='abstract'? 'class' name=super::UnrestrictedName ownedSignature=TemplateSignatureCS? ('extends'
	//	ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)? (':' instanceClassName=SINGLE_QUOTED_STRING)? ('{'
	//	isInterface?='interface'? '}')? ('{' (ownedOperations+=OperationCS | ownedProperties+=StructuralFeatureCS
	//	/ *| ownedConstraints+=InvariantConstraintCS* /)* '}' | ';')
	public QVTbaseGrammarAccess.StructuredClassCSElements getStructuredClassCSAccess() {
		return gaQVTbase.getStructuredClassCSAccess();
	}

	public ParserRule getStructuredClassCSRule() {
		return getStructuredClassCSAccess().getRule();
	}

	//TypedMultiplicityRefCS base::TypedRefCS:
	//	TypedRefCS ownedMultiplicity=MultiplicityCS?
	public QVTbaseGrammarAccess.TypedMultiplicityRefCSElements getTypedMultiplicityRefCSAccess() {
		return gaQVTbase.getTypedMultiplicityRefCSAccess();
	}

	public ParserRule getTypedMultiplicityRefCSRule() {
		return getTypedMultiplicityRefCSAccess().getRule();
	}

	//StructuralFeatureCS base::StructuralFeatureCS:
	//	AttributeCS | ReferenceCS
	public QVTbaseGrammarAccess.StructuralFeatureCSElements getStructuralFeatureCSAccess() {
		return gaQVTbase.getStructuralFeatureCSAccess();
	}

	public ParserRule getStructuralFeatureCSRule() {
		return getStructuralFeatureCSAccess().getRule();
	}

	//EnumerationLiteralName:
	//	EssentialOCLUnrestrictedName;
	public QVTbaseGrammarAccess.EnumerationLiteralNameElements getEnumerationLiteralNameAccess() {
		return gaQVTbase.getEnumerationLiteralNameAccess();
	}

	public ParserRule getEnumerationLiteralNameRule() {
		return getEnumerationLiteralNameAccess().getRule();
	}

	//QVTbaseUnrestrictedName:
	//	'abstract' | 'attribute' | 'body' | 'class' | 'composes' | 'datatype' | 'definition' | 'derived' | 'derivation' |
	//	'enum' | 'extends' | 'id' | 'initial' | 'interface' | 'literal' | 'operation' | 'ordered' | 'primitive' | 'property'
	//	| 'readonly' | 'resolve' | 'serializable' | 'static' | 'throws' | 'transient' | 'unique' | 'unsettable' | 'volatile';
	public QVTbaseGrammarAccess.QVTbaseUnrestrictedNameElements getQVTbaseUnrestrictedNameAccess() {
		return gaQVTbase.getQVTbaseUnrestrictedNameAccess();
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
	// * /
	//SIGNED ecore::EInt:
	//	'-'? INT
	public QVTbaseGrammarAccess.SIGNEDElements getSIGNEDAccess() {
		return gaQVTbase.getSIGNEDAccess();
	}

	public ParserRule getSIGNEDRule() {
		return getSIGNEDAccess().getRule();
	}

	//terminal UNQUOTED_STRING: // Never forward parsed; just provides a placeholder
	// '£$%^£$%^'
	//	//  for reverse serialisation of embedded OCL
	//;
	public TerminalRule getUNQUOTED_STRINGRule() {
		return gaQVTbase.getUNQUOTED_STRINGRule();
	}

	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	// Model ContextCS:
	//	ownedExpression=ExpCS
	public EssentialOCLGrammarAccess.ModelElements getModelAccess() {
		return gaEssentialOCL.getModelAccess();
	}

	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLReservedKeyword:
	//	'and' | 'else' | 'endif' | 'if' | 'implies' | 'in' | 'let' | 'not' | 'or' | 'then' | 'xor';
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
	// //  Names
	//
	////---------------------------------------------------------------------
	//
	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnrestrictedName:
	//	Identifier;
	public EssentialOCLGrammarAccess.EssentialOCLUnrestrictedNameElements getEssentialOCLUnrestrictedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnrestrictedNameAccess();
	}

	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	/// ** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> * /
	//EssentialOCLUnreservedName:
	//	super::UnrestrictedName | CollectionTypeIdentifier | PrimitiveTypeIdentifier | 'Map' | 'Tuple';
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
	//	referredElement=[pivot::NamedElement|super::UnrestrictedName] | {base::PathElementWithURICS}
	//	referredElement=[pivot::Namespace|URI]
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
	//	'Boolean' | 'Integer' | 'Real' | 'String' | 'UnlimitedNatural' | 'OclAny' | 'OclInvalid' | 'OclVoid';
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
	//	'Set' | 'Bag' | 'Sequence' | 'Collection' | 'OrderedSet';
	public EssentialOCLGrammarAccess.CollectionTypeIdentifierElements getCollectionTypeIdentifierAccess() {
		return gaEssentialOCL.getCollectionTypeIdentifierAccess();
	}

	public ParserRule getCollectionTypeIdentifierRule() {
		return getCollectionTypeIdentifierAccess().getRule();
	}

	//CollectionTypeCS:
	//	name=CollectionTypeIdentifier ('(' ownedType=TypeExpCS ')')?;
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
	//	name=super::UnrestrictedName ':' ownedType=TypeExpCS
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
	//	ownedType=CollectionTypeCS '{' (ownedParts+=CollectionLiteralPartCS (',' ownedParts+=CollectionLiteralPartCS)*)? '}';
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
	//	ownedType=CollectionTypeCS '{' (ownedParts+=PatternExpCS (',' ownedParts+=PatternExpCS)* ('++'
	//	restVariableName=Identifier))? '}';
	public EssentialOCLGrammarAccess.CollectionPatternCSElements getCollectionPatternCSAccess() {
		return gaEssentialOCL.getCollectionPatternCSAccess();
	}

	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//ShadowPartCS:
	//	referredProperty=[pivot::Property|super::UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS) |
	//	ownedInitExpression=StringLiteralExpCS;
	public EssentialOCLGrammarAccess.ShadowPartCSElements getShadowPartCSAccess() {
		return gaEssentialOCL.getShadowPartCSAccess();
	}

	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//	patternVariableName=super::UnrestrictedName? ':' ownedPatternType=TypeExpCS;
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
	//	NumberLiteralExpCS | StringLiteralExpCS | BooleanLiteralExpCS | UnlimitedNaturalLiteralExpCS | InvalidLiteralExpCS |
	//	NullLiteralExpCS;
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
	//	name=super::UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
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
	//	symbol='true' | symbol='false';
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
	//	PrimitiveTypeCS | CollectionTypeCS | MapTypeCS | TupleTypeCS
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

	//TypeExpCS base::TypedRefCS:
	//	(TypeNameExpCS | TypeLiteralCS | CollectionPatternCS) ownedMultiplicity=MultiplicityCS?
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
	//	NestedExpCS | IfExpCS | SelfExpCS | PrimitiveLiteralExpCS | TupleLiteralExpCS | MapLiteralExpCS |
	//	CollectionLiteralExpCS | LambdaLiteralExpCS | TypeLiteralExpCS | NameExpCS
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
	// * parameter or an iterator. * /
	//NavigatingArgCS:
	//	ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)? | 'in'
	//	ownedInitExpression=ExpCS)? | ':' ownedType=TypeExpCS;
	public EssentialOCLGrammarAccess.NavigatingArgCSElements getNavigatingArgCSAccess() {
		return gaEssentialOCL.getNavigatingArgCSAccess();
	}

	public ParserRule getNavigatingArgCSRule() {
		return getNavigatingArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
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
	//
	/// * A navigating comma argument is a generalized rule for non-first argument in a round bracket clause. These are typically non-first operation
	// * parameters or a second iterator. * /
	//NavigatingCommaArgCS NavigatingArgCS:
	//	prefix=',' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)? | 'in'
	//	ownedInitExpression=ExpCS)?
	public EssentialOCLGrammarAccess.NavigatingCommaArgCSElements getNavigatingCommaArgCSAccess() {
		return gaEssentialOCL.getNavigatingCommaArgCSAccess();
	}

	public ParserRule getNavigatingCommaArgCSRule() {
		return getNavigatingCommaArgCSAccess().getRule();
	}

	//// Type-less init is an illegal infix expression
	//
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
	// NavigatingArgExpCS ExpCS:
	//	ExpCS
	public EssentialOCLGrammarAccess.NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return gaEssentialOCL.getNavigatingArgExpCSAccess();
	}

	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//IfExpCS:
	//	'if' ownedCondition=(ExpCS | PatternExpCS) 'then' ownedThenExpression=ExpCS //	ifThenExpressions+=IfThenExpCS
	//
	//	ownedIfThenExpressions+=ElseIfThenExpCS* 'else' ownedElseExpression=ExpCS 'endif';
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
	//IfThenExpCS:
	//	'elseif' ownedCondition=ExpCS 'then' ownedThenExpression=ExpCS
	public EssentialOCLGrammarAccess.ElseIfThenExpCSElements getElseIfThenExpCSAccess() {
		return gaEssentialOCL.getElseIfThenExpCSAccess();
	}

	public ParserRule getElseIfThenExpCSRule() {
		return getElseIfThenExpCSAccess().getRule();
	}

	//LetExpCS:
	//	'let' ownedVariables+=LetVariableCS (',' ownedVariables+=LetVariableCS)* 'in' ownedInExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetExpCSElements getLetExpCSAccess() {
		return gaEssentialOCL.getLetExpCSAccess();
	}

	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS:
	//	name=super::UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '='
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
	// * /
	//NUMBER_LITERAL BigNumber:
	//	INT
	public BaseGrammarAccess.NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return gaBase.getNUMBER_LITERALAccess();
	}

	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	//// EssentialOCLTokenSource pieces this together ('.' INT)? (('e' | 'E') ('+' | '-')? INT)?;
	// StringLiteral:
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
