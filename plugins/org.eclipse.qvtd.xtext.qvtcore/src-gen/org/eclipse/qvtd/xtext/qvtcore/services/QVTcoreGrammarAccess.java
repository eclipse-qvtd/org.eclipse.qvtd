/*******************************************************************************
 * Copyright (c) 2011, 2023 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class QVTcoreGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {

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
		//    ownedImports+=ImportCS*
		//    (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*
		//;
		@Override public ParserRule getRule() { return rule; }

		//ownedImports+=ImportCS*
		//(ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*
		public Group getGroup() { return cGroup; }

		//ownedImports+=ImportCS*
		public Assignment getOwnedImportsAssignment_0() { return cOwnedImportsAssignment_0; }

		//ImportCS
		public RuleCall getOwnedImportsImportCSParserRuleCall_0_0() { return cOwnedImportsImportCSParserRuleCall_0_0; }

		//(ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*
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

		//BottomPatternCS:        // Bug 466385 explains the redundancy below
		//    (
		//        '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		//        (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
		//        '|' ownedConstraints+=PredicateOrAssignmentCS* '}'
		//    ) | (
		//        '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		//        (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '}'
		//    ) | (
		//        '{' ownedConstraints+=PredicateOrAssignmentCS+ '}'
		//    ) | (
		//        {BottomPatternCS} '{' '}'
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }

		//    // Bug 466385 explains the redundancy below
		//(
		//    '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		//    (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
		//    '|' ownedConstraints+=PredicateOrAssignmentCS* '}'
		//) | (
		//    '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		//    (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '}'
		//) | (
		//    '{' ownedConstraints+=PredicateOrAssignmentCS+ '}'
		//) | (
		//    {BottomPatternCS} '{' '}'
		//)
		public Alternatives getAlternatives() { return cAlternatives; }

		//    // Bug 466385 explains the redundancy below
		//(
		//    '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		//    (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
		//    '|' ownedConstraints+=PredicateOrAssignmentCS* '}'
		//)
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

		//(
		//       '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
		//       (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '}'
		//   )
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

		//(
		//       '{' ownedConstraints+=PredicateOrAssignmentCS+ '}'
		//   )
		public Group getGroup_2() { return cGroup_2; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//ownedConstraints+=PredicateOrAssignmentCS+
		public Assignment getOwnedConstraintsAssignment_2_1() { return cOwnedConstraintsAssignment_2_1; }

		//PredicateOrAssignmentCS
		public RuleCall getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0() { return cOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_2() { return cRightCurlyBracketKeyword_2_2; }

		//(
		//       {BottomPatternCS} '{' '}'
		//   )
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
		private final RuleCall cNameIdentifierParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
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
		private final CrossReference cUsesTypedModelCrossReference_5_1_0 = (CrossReference)cUsesAssignment_5_1.eContents().get(0);
		private final RuleCall cUsesTypedModelUnrestrictedNameParserRuleCall_5_1_0_1 = (RuleCall)cUsesTypedModelCrossReference_5_1_0.eContents().get(1);
		private final Group cGroup_5_2 = (Group)cGroup_5.eContents().get(2);
		private final Keyword cCommaKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cUsesAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final CrossReference cUsesTypedModelCrossReference_5_2_1_0 = (CrossReference)cUsesAssignment_5_2_1.eContents().get(0);
		private final RuleCall cUsesTypedModelUnrestrictedNameParserRuleCall_5_2_1_0_1 = (RuleCall)cUsesTypedModelCrossReference_5_2_1_0.eContents().get(1);

		//DirectionCS: {DirectionCS} name=Identifier?
		//    'imports' imports+=[pivot::Package|UnrestrictedName] (',' imports+=[pivot::Package|UnrestrictedName])*
		//    ('uses' uses+=[qvtbase::TypedModel|UnrestrictedName] (',' uses+=[qvtbase::TypedModel|UnrestrictedName])*)?
		//;
		@Override public ParserRule getRule() { return rule; }

		//{DirectionCS} name=Identifier?
		//   'imports' imports+=[pivot::Package|UnrestrictedName] (',' imports+=[pivot::Package|UnrestrictedName])*
		//   ('uses' uses+=[qvtbase::TypedModel|UnrestrictedName] (',' uses+=[qvtbase::TypedModel|UnrestrictedName])*)?
		public Group getGroup() { return cGroup; }

		//{DirectionCS}
		public Action getDirectionCSAction_0() { return cDirectionCSAction_0; }

		//name=Identifier?
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//Identifier
		public RuleCall getNameIdentifierParserRuleCall_1_0() { return cNameIdentifierParserRuleCall_1_0; }

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

		//('uses' uses+=[qvtbase::TypedModel|UnrestrictedName] (',' uses+=[qvtbase::TypedModel|UnrestrictedName])*)?
		public Group getGroup_5() { return cGroup_5; }

		//'uses'
		public Keyword getUsesKeyword_5_0() { return cUsesKeyword_5_0; }

		//uses+=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getUsesAssignment_5_1() { return cUsesAssignment_5_1; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getUsesTypedModelCrossReference_5_1_0() { return cUsesTypedModelCrossReference_5_1_0; }

		//UnrestrictedName
		public RuleCall getUsesTypedModelUnrestrictedNameParserRuleCall_5_1_0_1() { return cUsesTypedModelUnrestrictedNameParserRuleCall_5_1_0_1; }

		//(',' uses+=[qvtbase::TypedModel|UnrestrictedName])*
		public Group getGroup_5_2() { return cGroup_5_2; }

		//','
		public Keyword getCommaKeyword_5_2_0() { return cCommaKeyword_5_2_0; }

		//uses+=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getUsesAssignment_5_2_1() { return cUsesAssignment_5_2_1; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getUsesTypedModelCrossReference_5_2_1_0() { return cUsesTypedModelCrossReference_5_2_1_0; }

		//UnrestrictedName
		public RuleCall getUsesTypedModelUnrestrictedNameParserRuleCall_5_2_1_0_1() { return cUsesTypedModelUnrestrictedNameParserRuleCall_5_2_1_0_1; }
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
		//GuardPatternCS:        // Bug 466385 explains the redundancy below
		//    (
		//        '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* '|' ownedPredicates+=PredicateCS* ')'
		//    ) | (
		//        '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* ')'
		//    ) | (
		//        '(' ownedPredicates+=PredicateCS+ ')'
		//    ) | (
		//        {GuardPatternCS} '(' ')'
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }

		//    // Bug 466385 explains the redundancy below
		//(
		//    '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* '|' ownedPredicates+=PredicateCS* ')'
		//) | (
		//    '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* ')'
		//) | (
		//    '(' ownedPredicates+=PredicateCS+ ')'
		//) | (
		//    {GuardPatternCS} '(' ')'
		//)
		public Alternatives getAlternatives() { return cAlternatives; }

		//    // Bug 466385 explains the redundancy below
		//(
		//    '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* '|' ownedPredicates+=PredicateCS* ')'
		//)
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

		//(
		//       '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* ')'
		//   )
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

		//(
		//       '(' ownedPredicates+=PredicateCS+ ')'
		//   )
		public Group getGroup_2() { return cGroup_2; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//ownedPredicates+=PredicateCS+
		public Assignment getOwnedPredicatesAssignment_2_1() { return cOwnedPredicatesAssignment_2_1; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_2_1_0() { return cOwnedPredicatesPredicateCSParserRuleCall_2_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }

		//(
		//       {GuardPatternCS} '(' ')'
		//   )
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
		//GuardVariableCS returns UnrealizedVariableCS: name=UnrestrictedName ':' ownedType=TypeExpCS;
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

		//ImportCS returns base::ImportCS:
		//    'import' (name=Identifier ':')? ownedPathName=URIPathNameCS (isAll?='::' '*')? ';';
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
		private final Assignment cIsAbstractAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsAbstractAbstractKeyword_1_0 = (Keyword)cIsAbstractAssignment_1.eContents().get(0);
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

		//MappingCS: {MappingCS} isAbstract?='abstract'? 'map' name=UnrestrictedName? ('in' ownedInPathName=PathNameCS)?
		//    ('refines' refines+=[qvtcore::Mapping|UnrestrictedName] (',' refines+=[qvtcore::Mapping|UnrestrictedName])*)?
		//    '{' ownedDomains+=NamedDomainCS* ('where' ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* '}';
		@Override public ParserRule getRule() { return rule; }

		//{MappingCS} isAbstract?='abstract'? 'map' name=UnrestrictedName? ('in' ownedInPathName=PathNameCS)?
		//   ('refines' refines+=[qvtcore::Mapping|UnrestrictedName] (',' refines+=[qvtcore::Mapping|UnrestrictedName])*)?
		//   '{' ownedDomains+=NamedDomainCS* ('where' ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* '}'
		public Group getGroup() { return cGroup; }

		//{MappingCS}
		public Action getMappingCSAction_0() { return cMappingCSAction_0; }

		//isAbstract?='abstract'?
		public Assignment getIsAbstractAssignment_1() { return cIsAbstractAssignment_1; }

		//'abstract'
		public Keyword getIsAbstractAbstractKeyword_1_0() { return cIsAbstractAbstractKeyword_1_0; }

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

		//NamedDomainCS returns DomainCS: isCheck?='check'? isEnforce?='enforce'? direction=[qvtbase::TypedModel|UnrestrictedName]
		//    ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
		@Override public ParserRule getRule() { return rule; }

		//isCheck?='check'? isEnforce?='enforce'? direction=[qvtbase::TypedModel|UnrestrictedName]
		//   ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
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

		//QualifiedPackageCS returns qvtbasecs::QualifiedPackageCS:
		//    'package' ownedPathName=ScopeNameCS? name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)?
		//    (('{'
		//        (/* ownedAnnotations+=AnnotationElementCS | */ ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))*
		//        '}')
		//    |';'
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }

		//'package' ownedPathName=ScopeNameCS? name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)?
		//(('{'
		//    (/* ownedAnnotations+=AnnotationElementCS | */ ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))*
		//    '}')
		//|';'
		//)
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

		//(('{'
		//    (/* ownedAnnotations+=AnnotationElementCS | */ ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))*
		//    '}')
		//|';'
		//)
		public Alternatives getAlternatives_5() { return cAlternatives_5; }

		//('{'
		//        (/* ownedAnnotations+=AnnotationElementCS | */ ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))*
		//        '}')
		public Group getGroup_5_0() { return cGroup_5_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0_0() { return cLeftCurlyBracketKeyword_5_0_0; }

		//(/* ownedAnnotations+=AnnotationElementCS | */ ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))*
		public Alternatives getAlternatives_5_0_1() { return cAlternatives_5_0_1; }

		///* ownedAnnotations+=AnnotationElementCS | */ ownedPackages+=QualifiedPackageCS
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

		//ParamDeclarationCS: name=UnrestrictedName ':' ownedType=TypeExpCS;
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

		//PredicateCS: ownedCondition=ExpCS ';';
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
		////Predicate ::= BooleanOCLExpr
		////Assignement ::= [�default�] SlotOwnerOCLExpr�.�PropertyName �:=� ValueOCLExpr
		//PredicateOrAssignmentCS: isDefault?='default'? ownedTarget=ExpCS ((':=' | isPartial?='+=') ownedInitExpression=ExpCS)? ';';
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
		private final Group cGroup_9_2 = (Group)cAlternatives_9.eContents().get(2);
		private final Keyword cImplementedbyKeyword_9_2_0 = (Keyword)cGroup_9_2.eContents().get(0);
		private final Assignment cImplementationAssignment_9_2_1 = (Assignment)cGroup_9_2.eContents().get(1);
		private final CrossReference cImplementationJavaClassCSCrossReference_9_2_1_0 = (CrossReference)cImplementationAssignment_9_2_1.eContents().get(0);
		private final RuleCall cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_9_2_1_0_1 = (RuleCall)cImplementationJavaClassCSCrossReference_9_2_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_9_2_2 = (Keyword)cGroup_9_2.eContents().get(2);

		//QueryCS: isTransient?='transient'? 'query' ownedPathName=ScopeNameCS name=UnrestrictedName
		//        '(' (ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)? ')'
		//        ':' ownedType=TypeExpCS
		//        (';' | ('{' ownedExpression=ExpCS '}') | ('implementedby' implementation=[qvtbasecs::JavaClassCS|SINGLE_QUOTED_STRING] ';'));
		@Override public ParserRule getRule() { return rule; }

		//isTransient?='transient'? 'query' ownedPathName=ScopeNameCS name=UnrestrictedName
		//       '(' (ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)? ')'
		//       ':' ownedType=TypeExpCS
		//       (';' | ('{' ownedExpression=ExpCS '}') | ('implementedby' implementation=[qvtbasecs::JavaClassCS|SINGLE_QUOTED_STRING] ';'))
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

		//(';' | ('{' ownedExpression=ExpCS '}') | ('implementedby' implementation=[qvtbasecs::JavaClassCS|SINGLE_QUOTED_STRING] ';'))
		public Alternatives getAlternatives_9() { return cAlternatives_9; }

		//';'
		public Keyword getSemicolonKeyword_9_0() { return cSemicolonKeyword_9_0; }

		//('{' ownedExpression=ExpCS '}')
		public Group getGroup_9_1() { return cGroup_9_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_9_1_0() { return cLeftCurlyBracketKeyword_9_1_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_9_1_1() { return cOwnedExpressionAssignment_9_1_1; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_9_1_1_0() { return cOwnedExpressionExpCSParserRuleCall_9_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_9_1_2() { return cRightCurlyBracketKeyword_9_1_2; }

		//('implementedby' implementation=[qvtbasecs::JavaClassCS|SINGLE_QUOTED_STRING] ';')
		public Group getGroup_9_2() { return cGroup_9_2; }

		//'implementedby'
		public Keyword getImplementedbyKeyword_9_2_0() { return cImplementedbyKeyword_9_2_0; }

		//implementation=[qvtbasecs::JavaClassCS|SINGLE_QUOTED_STRING]
		public Assignment getImplementationAssignment_9_2_1() { return cImplementationAssignment_9_2_1; }

		//[qvtbasecs::JavaClassCS|SINGLE_QUOTED_STRING]
		public CrossReference getImplementationJavaClassCSCrossReference_9_2_1_0() { return cImplementationJavaClassCSCrossReference_9_2_1_0; }

		//SINGLE_QUOTED_STRING
		public RuleCall getImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_9_2_1_0_1() { return cImplementationJavaClassCSSINGLE_QUOTED_STRINGTerminalRuleCall_9_2_1_0_1; }

		//';'
		public Keyword getSemicolonKeyword_9_2_2() { return cSemicolonKeyword_9_2_2; }
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
		////            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
		////            ':' <TypeCS>
		////            (';' | '{' <OCLExpressionCS> '}')
		//ScopeNameCS returns base::PathNameCS:
		//    ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*;
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
		private final Assignment cOwnedTargetsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedTargetsTargetCSParserRuleCall_5_0 = (RuleCall)cOwnedTargetsAssignment_5.eContents().get(0);
		private final Assignment cOwnedPropertiesAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedPropertiesStructuralFeatureCSParserRuleCall_6_0 = (RuleCall)cOwnedPropertiesAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);

		//TransformationCS:
		//    'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* ownedTargets+=TargetCS* ownedProperties+=StructuralFeatureCS* '}';
		@Override public ParserRule getRule() { return rule; }

		//'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* ownedTargets+=TargetCS* ownedProperties+=StructuralFeatureCS* '}'
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

		//ownedTargets+=TargetCS*
		public Assignment getOwnedTargetsAssignment_5() { return cOwnedTargetsAssignment_5; }

		//TargetCS
		public RuleCall getOwnedTargetsTargetCSParserRuleCall_5_0() { return cOwnedTargetsTargetCSParserRuleCall_5_0; }

		//ownedProperties+=StructuralFeatureCS*
		public Assignment getOwnedPropertiesAssignment_6() { return cOwnedPropertiesAssignment_6; }

		//StructuralFeatureCS
		public RuleCall getOwnedPropertiesStructuralFeatureCSParserRuleCall_6_0() { return cOwnedPropertiesStructuralFeatureCSParserRuleCall_6_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
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
		//UnrealizedVariableCS: name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)?;
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
		//RealizedVariableCS: 'realize' name=UnrestrictedName ':' ownedType=TypeExpCS;
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

		//UnnamedDomainCS returns DomainCS: {DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
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
		private final Keyword cAbstractKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cCheckKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cEnforceKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cImplementedbyKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cImportKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cImportsKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cInputKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cIteratesKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cMapKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cOutputKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cPackageKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cQueryKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cRealizeKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cRefinesKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cTargetKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cTransformationKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cTransientKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cUsesKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cViaKeyword_18 = (Keyword)cAlternatives.eContents().get(18);

		//QVTcoreUnrestrictedName:
		//    'abstract'
		//|    'check'
		//|    'enforce'
		//|    'implementedby'
		//|    'import'
		//|    'imports'
		//|    'input'
		//|    'iterates'
		//|    'map'
		//|    'output'
		//|    'package'
		//|    'query'
		//|    'realize'
		//|    'refines'
		//|    'target'
		//|    'transformation'
		//|    'transient'
		//|    'uses'
		//|    'via'
		////|    'where'
		//;
		@Override public ParserRule getRule() { return rule; }

		//    'abstract'
		//|    'check'
		//|    'enforce'
		//|    'implementedby'
		//|    'import'
		//|    'imports'
		//|    'input'
		//|    'iterates'
		//|    'map'
		//|    'output'
		//|    'package'
		//|    'query'
		//|    'realize'
		//|    'refines'
		//|    'target'
		//|    'transformation'
		//|    'transient'
		//|    'uses'
		//|    'via'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'abstract'
		public Keyword getAbstractKeyword_0() { return cAbstractKeyword_0; }

		//'check'
		public Keyword getCheckKeyword_1() { return cCheckKeyword_1; }

		//'enforce'
		public Keyword getEnforceKeyword_2() { return cEnforceKeyword_2; }

		//'implementedby'
		public Keyword getImplementedbyKeyword_3() { return cImplementedbyKeyword_3; }

		//'import'
		public Keyword getImportKeyword_4() { return cImportKeyword_4; }

		//'imports'
		public Keyword getImportsKeyword_5() { return cImportsKeyword_5; }

		//'input'
		public Keyword getInputKeyword_6() { return cInputKeyword_6; }

		//'iterates'
		public Keyword getIteratesKeyword_7() { return cIteratesKeyword_7; }

		//'map'
		public Keyword getMapKeyword_8() { return cMapKeyword_8; }

		//'output'
		public Keyword getOutputKeyword_9() { return cOutputKeyword_9; }

		//'package'
		public Keyword getPackageKeyword_10() { return cPackageKeyword_10; }

		//'query'
		public Keyword getQueryKeyword_11() { return cQueryKeyword_11; }

		//'realize'
		public Keyword getRealizeKeyword_12() { return cRealizeKeyword_12; }

		//'refines'
		public Keyword getRefinesKeyword_13() { return cRefinesKeyword_13; }

		//'target'
		public Keyword getTargetKeyword_14() { return cTargetKeyword_14; }

		//'transformation'
		public Keyword getTransformationKeyword_15() { return cTransformationKeyword_15; }

		//'transient'
		public Keyword getTransientKeyword_16() { return cTransientKeyword_16; }

		//'uses'
		public Keyword getUsesKeyword_17() { return cUsesKeyword_17; }

		//'via'
		public Keyword getViaKeyword_18() { return cViaKeyword_18; }
	}
	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtcore.QVTcore.UnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cQVTbaseUnrestrictedNameParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cQVTcoreUnrestrictedNameParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		////|    'creation'
		////|    'deletion'
		////|    'include'
		////|    'library'
		//UnrestrictedName returns ecore::EString:
		//    EssentialOCLUnrestrictedName
		//|   QVTbaseUnrestrictedName
		//|   QVTcoreUnrestrictedName
		//;
		@Override public ParserRule getRule() { return rule; }

		//    EssentialOCLUnrestrictedName
		//|   QVTbaseUnrestrictedName
		//|   QVTcoreUnrestrictedName
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
	//    ownedImports+=ImportCS*
	//    (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)*
	//;
	public TopLevelCSElements getTopLevelCSAccess() {
		return pTopLevelCS;
	}

	public ParserRule getTopLevelCSRule() {
		return getTopLevelCSAccess().getRule();
	}

	//BottomPatternCS:        // Bug 466385 explains the redundancy below
	//    (
	//        '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
	//        (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))*
	//        '|' ownedConstraints+=PredicateOrAssignmentCS* '}'
	//    ) | (
	//        '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS)
	//        (',' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedRealizedVariables+=RealizedVariableCS))* '}'
	//    ) | (
	//        '{' ownedConstraints+=PredicateOrAssignmentCS+ '}'
	//    ) | (
	//        {BottomPatternCS} '{' '}'
	//    )
	//;
	public BottomPatternCSElements getBottomPatternCSAccess() {
		return pBottomPatternCS;
	}

	public ParserRule getBottomPatternCSRule() {
		return getBottomPatternCSAccess().getRule();
	}

	//DirectionCS: {DirectionCS} name=Identifier?
	//    'imports' imports+=[pivot::Package|UnrestrictedName] (',' imports+=[pivot::Package|UnrestrictedName])*
	//    ('uses' uses+=[qvtbase::TypedModel|UnrestrictedName] (',' uses+=[qvtbase::TypedModel|UnrestrictedName])*)?
	//;
	public DirectionCSElements getDirectionCSAccess() {
		return pDirectionCS;
	}

	public ParserRule getDirectionCSRule() {
		return getDirectionCSAccess().getRule();
	}

	////EnforcementOperationCS: ('creation'|'deletion') ExpCS ';';
	//GuardPatternCS:        // Bug 466385 explains the redundancy below
	//    (
	//        '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* '|' ownedPredicates+=PredicateCS* ')'
	//    ) | (
	//        '(' ownedUnrealizedVariables+=GuardVariableCS (',' ownedUnrealizedVariables+=GuardVariableCS)* ')'
	//    ) | (
	//        '(' ownedPredicates+=PredicateCS+ ')'
	//    ) | (
	//        {GuardPatternCS} '(' ')'
	//    )
	//;
	public GuardPatternCSElements getGuardPatternCSAccess() {
		return pGuardPatternCS;
	}

	public ParserRule getGuardPatternCSRule() {
		return getGuardPatternCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	//GuardVariableCS returns UnrealizedVariableCS: name=UnrestrictedName ':' ownedType=TypeExpCS;
	public GuardVariableCSElements getGuardVariableCSAccess() {
		return pGuardVariableCS;
	}

	public ParserRule getGuardVariableCSRule() {
		return getGuardVariableCSAccess().getRule();
	}

	//ImportCS returns base::ImportCS:
	//    'import' (name=Identifier ':')? ownedPathName=URIPathNameCS (isAll?='::' '*')? ';';
	public ImportCSElements getImportCSAccess() {
		return pImportCS;
	}

	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	//MappingCS: {MappingCS} isAbstract?='abstract'? 'map' name=UnrestrictedName? ('in' ownedInPathName=PathNameCS)?
	//    ('refines' refines+=[qvtcore::Mapping|UnrestrictedName] (',' refines+=[qvtcore::Mapping|UnrestrictedName])*)?
	//    '{' ownedDomains+=NamedDomainCS* ('where' ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* '}';
	public MappingCSElements getMappingCSAccess() {
		return pMappingCS;
	}

	public ParserRule getMappingCSRule() {
		return getMappingCSAccess().getRule();
	}

	//NamedDomainCS returns DomainCS: isCheck?='check'? isEnforce?='enforce'? direction=[qvtbase::TypedModel|UnrestrictedName]
	//    ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
	public NamedDomainCSElements getNamedDomainCSAccess() {
		return pNamedDomainCS;
	}

	public ParserRule getNamedDomainCSRule() {
		return getNamedDomainCSAccess().getRule();
	}

	//QualifiedPackageCS returns qvtbasecs::QualifiedPackageCS:
	//    'package' ownedPathName=ScopeNameCS? name=UnrestrictedName (':' nsPrefix=UnrestrictedName)? ('=' nsURI=URI)?
	//    (('{'
	//        (/* ownedAnnotations+=AnnotationElementCS | */ ownedPackages+=QualifiedPackageCS | ownedClasses+=(ClassCS | TransformationCS))*
	//        '}')
	//    |';'
	//    )
	//;
	public QualifiedPackageCSElements getQualifiedPackageCSAccess() {
		return pQualifiedPackageCS;
	}

	public ParserRule getQualifiedPackageCSRule() {
		return getQualifiedPackageCSAccess().getRule();
	}

	//ParamDeclarationCS: name=UnrestrictedName ':' ownedType=TypeExpCS;
	public ParamDeclarationCSElements getParamDeclarationCSAccess() {
		return pParamDeclarationCS;
	}

	public ParserRule getParamDeclarationCSRule() {
		return getParamDeclarationCSAccess().getRule();
	}

	//PredicateCS: ownedCondition=ExpCS ';';
	public PredicateCSElements getPredicateCSAccess() {
		return pPredicateCS;
	}

	public ParserRule getPredicateCSRule() {
		return getPredicateCSAccess().getRule();
	}

	////Constraint ::= Predicate | Assignment
	////Predicate ::= BooleanOCLExpr
	////Assignement ::= [�default�] SlotOwnerOCLExpr�.�PropertyName �:=� ValueOCLExpr
	//PredicateOrAssignmentCS: isDefault?='default'? ownedTarget=ExpCS ((':=' | isPartial?='+=') ownedInitExpression=ExpCS)? ';';
	public PredicateOrAssignmentCSElements getPredicateOrAssignmentCSAccess() {
		return pPredicateOrAssignmentCS;
	}

	public ParserRule getPredicateOrAssignmentCSRule() {
		return getPredicateOrAssignmentCSAccess().getRule();
	}

	//QueryCS: isTransient?='transient'? 'query' ownedPathName=ScopeNameCS name=UnrestrictedName
	//        '(' (ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)? ')'
	//        ':' ownedType=TypeExpCS
	//        (';' | ('{' ownedExpression=ExpCS '}') | ('implementedby' implementation=[qvtbasecs::JavaClassCS|SINGLE_QUOTED_STRING] ';'));
	public QueryCSElements getQueryCSAccess() {
		return pQueryCS;
	}

	public ParserRule getQueryCSRule() {
		return getQueryCSAccess().getRule();
	}

	////<query> ::= 'query' <PathNameCS>
	////            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
	////            ':' <TypeCS>
	////            (';' | '{' <OCLExpressionCS> '}')
	//ScopeNameCS returns base::PathNameCS:
	//    ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*;
	public ScopeNameCSElements getScopeNameCSAccess() {
		return pScopeNameCS;
	}

	public ParserRule getScopeNameCSRule() {
		return getScopeNameCSAccess().getRule();
	}

	//TransformationCS:
	//    'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* ownedTargets+=TargetCS* ownedProperties+=StructuralFeatureCS* '}';
	public TransformationCSElements getTransformationCSAccess() {
		return pTransformationCS;
	}

	public ParserRule getTransformationCSRule() {
		return getTransformationCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	//UnrealizedVariableCS: name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)?;
	public UnrealizedVariableCSElements getUnrealizedVariableCSAccess() {
		return pUnrealizedVariableCS;
	}

	public ParserRule getUnrealizedVariableCSRule() {
		return getUnrealizedVariableCSAccess().getRule();
	}

	////RealizedVariable := �realized� VariableName �:� TypeDeclaration
	//RealizedVariableCS: 'realize' name=UnrestrictedName ':' ownedType=TypeExpCS;
	public RealizedVariableCSElements getRealizedVariableCSAccess() {
		return pRealizedVariableCS;
	}

	public ParserRule getRealizedVariableCSRule() {
		return getRealizedVariableCSAccess().getRule();
	}

	//UnnamedDomainCS returns DomainCS: {DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS;
	public UnnamedDomainCSElements getUnnamedDomainCSAccess() {
		return pUnnamedDomainCS;
	}

	public ParserRule getUnnamedDomainCSRule() {
		return getUnnamedDomainCSAccess().getRule();
	}

	//QVTcoreUnrestrictedName:
	//    'abstract'
	//|    'check'
	//|    'enforce'
	//|    'implementedby'
	//|    'import'
	//|    'imports'
	//|    'input'
	//|    'iterates'
	//|    'map'
	//|    'output'
	//|    'package'
	//|    'query'
	//|    'realize'
	//|    'refines'
	//|    'target'
	//|    'transformation'
	//|    'transient'
	//|    'uses'
	//|    'via'
	////|    'where'
	//;
	public QVTcoreUnrestrictedNameElements getQVTcoreUnrestrictedNameAccess() {
		return pQVTcoreUnrestrictedName;
	}

	public ParserRule getQVTcoreUnrestrictedNameRule() {
		return getQVTcoreUnrestrictedNameAccess().getRule();
	}

	////|    'creation'
	////|    'deletion'
	////|    'include'
	////|    'library'
	//UnrestrictedName returns ecore::EString:
	//    EssentialOCLUnrestrictedName
	//|   QVTbaseUnrestrictedName
	//|   QVTcoreUnrestrictedName
	//;
	public UnrestrictedNameElements getUnrestrictedNameAccess() {
		return pUnrestrictedName;
	}

	public ParserRule getUnrestrictedNameRule() {
		return getUnrestrictedNameAccess().getRule();
	}

	//AttributeCS returns base::AttributeCS:
	//    ((qualifiers+='static' (qualifiers+='definition')?) | (qualifiers+='definition' (qualifiers+='static')?))?
	//    'attribute' name=UnrestrictedName
	//    (':' ownedType=TypedMultiplicityRefCS)?
	//    ('=' default=SINGLE_QUOTED_STRING)?
	//    ('{'((qualifiers+='derived' | qualifiers+='!derived' |
	//          qualifiers+='id' | qualifiers+='!id' |
	//          qualifiers+='ordered' | qualifiers+='!ordered' |
	//          qualifiers+='readonly' | qualifiers+='!readonly' |
	//          qualifiers+='transient' | qualifiers+='!transient' |
	//          qualifiers+='unique' | qualifiers+='!unique' |
	//          qualifiers+='unsettable' | qualifiers+='!unsettable' |
	//          qualifiers+='volatile' | qualifiers+='!volatile'
	//        ) ','? )+
	//    '}')?
	//    (    ('{' (/*ownedAnnotations+=AnnotationElementCS
	//          |*/ ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';')
	//          | ('derivation' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';') )* '}')
	//    |    ';'
	//    )
	//;
	public QVTbaseGrammarAccess.AttributeCSElements getAttributeCSAccess() {
		return gaQVTbase.getAttributeCSAccess();
	}

	public ParserRule getAttributeCSRule() {
		return getAttributeCSAccess().getRule();
	}

	//ClassCS returns base::ClassCS:
	//    StructuredClassCS | DataTypeCS | EnumerationCS
	//;
	public QVTbaseGrammarAccess.ClassCSElements getClassCSAccess() {
		return gaQVTbase.getClassCSAccess();
	}

	public ParserRule getClassCSRule() {
		return getClassCSAccess().getRule();
	}

	//CompoundTargetElementCS: '{' ownedTargetElements+=SimpleTargetElementCS* '}' ';'? ;
	public QVTbaseGrammarAccess.CompoundTargetElementCSElements getCompoundTargetElementCSAccess() {
		return gaQVTbase.getCompoundTargetElementCSAccess();
	}

	public ParserRule getCompoundTargetElementCSRule() {
		return getCompoundTargetElementCSAccess().getRule();
	}

	//DataTypeCS returns base::DataTypeCS:
	//    isPrimitive ?= 'primitive'? 'datatype' name=UnrestrictedName
	//    (ownedSignature=TemplateSignatureCS)?
	//    (':' instanceClassName=SINGLE_QUOTED_STRING)?
	//    ('{' (isSerializable?='serializable' | '!serializable')? '}')?
	//    (    ('{' /*(ownedAnnotations+=AnnotationElementCS
	//            | ownedConstraints+=InvariantConstraintCS)* */ '}')
	//    |    ';'
	//    )
	//;
	public QVTbaseGrammarAccess.DataTypeCSElements getDataTypeCSAccess() {
		return gaQVTbase.getDataTypeCSAccess();
	}

	public ParserRule getDataTypeCSRule() {
		return getDataTypeCSAccess().getRule();
	}

	//EnumerationCS returns base::EnumerationCS:
	//    'enum' name=UnrestrictedName
	//    (ownedSignature=TemplateSignatureCS)?
	//    (':' instanceClassName=SINGLE_QUOTED_STRING)?
	//    ('{' (isSerializable?='serializable' | '!serializable')? '}')?
	//    (    ('{' (/*ownedAnnotations+=AnnotationElementCS
	//            |*/ ownedLiterals+=EnumerationLiteralCS
	//            /*| ownedConstraints+=InvariantConstraintCS*/)* '}')
	//    |     ';'
	//    )
	//;
	public QVTbaseGrammarAccess.EnumerationCSElements getEnumerationCSAccess() {
		return gaQVTbase.getEnumerationCSAccess();
	}

	public ParserRule getEnumerationCSRule() {
		return getEnumerationCSAccess().getRule();
	}

	//EnumerationLiteralCS returns base::EnumerationLiteralCS:
	//    (('literal' name=UnrestrictedName) | name=EnumerationLiteralName) ('=' value=SIGNED)?
	//    (('{' /*ownedAnnotations+=AnnotationElementCS* */ '}')
	//    |';'
	//    )
	//;
	public QVTbaseGrammarAccess.EnumerationLiteralCSElements getEnumerationLiteralCSAccess() {
		return gaQVTbase.getEnumerationLiteralCSAccess();
	}

	public ParserRule getEnumerationLiteralCSRule() {
		return getEnumerationLiteralCSAccess().getRule();
	}

	//OperationCS returns base::OperationCS:
	//    ((qualifiers+='static' (qualifiers+='definition')?) | (qualifiers+='definition' (qualifiers+='static')?))?
	//    'operation' (ownedSignature=TemplateSignatureCS)? name=UnrestrictedName
	//    '(' (ownedParameters+=ParameterCS (',' ownedParameters+=ParameterCS)*)? ')'
	//    (':' ownedType=TypedMultiplicityRefCS)?
	//    ('throws' ownedExceptions+=TypedRefCS (',' ownedExceptions+=TypedRefCS)*)?
	//    ('{'((qualifiers+='derived' | qualifiers+='!derived' |
	//          qualifiers+='ordered' | qualifiers+='!ordered' |
	//          qualifiers+='unique' | qualifiers+='!unique'
	//        ) ','? )+
	//    '}')?
	//    (    ('{' (/*ownedAnnotations+=AnnotationElementCS
	//            | ownedPreconditions+=PreconditionConstraintCS
	//            |*/ ('body' UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS? ';')
	//            /*| ownedPostconditions+=PostconditionConstraintCS */ )* '}')
	//    |    ';'
	//    )
	//;
	public QVTbaseGrammarAccess.OperationCSElements getOperationCSAccess() {
		return gaQVTbase.getOperationCSAccess();
	}

	public ParserRule getOperationCSRule() {
		return getOperationCSAccess().getRule();
	}

	//ParameterCS returns base::ParameterCS:
	//    name=UnrestrictedName
	//    (':' ownedType=TypedMultiplicityRefCS)?
	//    ('{'(( qualifiers+='ordered' | qualifiers+='!ordered' |
	//           qualifiers+='unique' | qualifiers+='!unique'
	//          ) ','?)+
	//     '}')?
	//    ('{' /*ownedAnnotations+=AnnotationElementCS* */ '}')?
	//;
	public QVTbaseGrammarAccess.ParameterCSElements getParameterCSAccess() {
		return gaQVTbase.getParameterCSAccess();
	}

	public ParserRule getParameterCSRule() {
		return getParameterCSAccess().getRule();
	}

	//ReferenceCS returns base::ReferenceCS:
	//    ((qualifiers+='static' (qualifiers+='definition')?) | (qualifiers+='definition' (qualifiers+='static')?))?
	//    'property' name=UnrestrictedName
	//    ('#' referredOpposite=[pivot::Property|UnrestrictedName])?
	//    (':' ownedType=TypedMultiplicityRefCS)?
	//    ('=' default=SINGLE_QUOTED_STRING)?
	//    ('{'((qualifiers+='composes' | qualifiers+='!composes' |
	//          qualifiers+='derived' | qualifiers+='!derived' |
	//          qualifiers+='ordered' | qualifiers+='!ordered' |
	//          qualifiers+='readonly' | qualifiers+='!readonly' |
	//          qualifiers+='resolve' | qualifiers+='!resolve' |
	//          qualifiers+='transient' | qualifiers+='!transient' |
	//          qualifiers+='unique' | qualifiers+='!unique' |
	//          qualifiers+='unsettable' | qualifiers+='!unsettable' |
	//          qualifiers+='volatile' | qualifiers+='!volatile'
	//        ) ','? )+
	//    '}')?
	//    (    ('{' (/*ownedAnnotations+=AnnotationElementCS
	//            | ('key' referredKeys+=[pivot::Property|UnrestrictedName] (',' referredKeys+=[pivot::Property|UnrestrictedName])* ';')
	//            |*/ ('initial' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';')
	//            | ('derivation' UnrestrictedName? ':' ownedDefaultExpressions+=SpecificationCS? ';') )* '}')
	//    |    ';'
	//    )
	//;
	public QVTbaseGrammarAccess.ReferenceCSElements getReferenceCSAccess() {
		return gaQVTbase.getReferenceCSAccess();
	}

	public ParserRule getReferenceCSRule() {
		return getReferenceCSAccess().getRule();
	}

	//SimpleTargetElementCS: (input?='input'|output?='output'|via?='via') typedModel=[qvtbase::TypedModel|UnrestrictedName]
	//    ('iterates' (iterates+=[qvtbase::TypedModel|UnrestrictedName]
	//        | ('{' (iterates+=[qvtbase::TypedModel|UnrestrictedName] (',' iterates+=[qvtbase::TypedModel|UnrestrictedName])*)? '}')))?
	//';';
	public QVTbaseGrammarAccess.SimpleTargetElementCSElements getSimpleTargetElementCSAccess() {
		return gaQVTbase.getSimpleTargetElementCSAccess();
	}

	public ParserRule getSimpleTargetElementCSRule() {
		return getSimpleTargetElementCSAccess().getRule();
	}

	//SpecificationCS returns essentialocl::ExpSpecificationCS:
	//    ownedExpression=ExpCS | exprString=UNQUOTED_STRING
	//;
	public QVTbaseGrammarAccess.SpecificationCSElements getSpecificationCSAccess() {
		return gaQVTbase.getSpecificationCSAccess();
	}

	public ParserRule getSpecificationCSRule() {
		return getSpecificationCSAccess().getRule();
	}

	//StructuredClassCS returns base::StructuredClassCS:
	//    isAbstract?='abstract'?
	//    'class' name=UnrestrictedName
	//    (ownedSignature=TemplateSignatureCS)?
	//    ('extends' ownedSuperTypes+=TypedRefCS (',' ownedSuperTypes+=TypedRefCS)*)?
	//    (':' instanceClassName=SINGLE_QUOTED_STRING)?
	//    ('{' isInterface?='interface'?
	//     '}')?
	//    (    ('{' (/*ownedAnnotations+=AnnotationElementCS
	//            |*/ ownedOperations+=OperationCS
	//            | ownedProperties+=StructuralFeatureCS
	//            /*| ownedConstraints+=InvariantConstraintCS*/)* '}')
	//    |    ';'
	//    )
	//;
	public QVTbaseGrammarAccess.StructuredClassCSElements getStructuredClassCSAccess() {
		return gaQVTbase.getStructuredClassCSAccess();
	}

	public ParserRule getStructuredClassCSRule() {
		return getStructuredClassCSAccess().getRule();
	}

	//TargetCS: 'target' name=UnrestrictedName '{' ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)* '}' ';'?;
	public QVTbaseGrammarAccess.TargetCSElements getTargetCSAccess() {
		return gaQVTbase.getTargetCSAccess();
	}

	public ParserRule getTargetCSRule() {
		return getTargetCSAccess().getRule();
	}

	//TypedMultiplicityRefCS returns base::TypedRefCS:
	//    TypedRefCS (ownedMultiplicity=MultiplicityCS)?
	//;
	public QVTbaseGrammarAccess.TypedMultiplicityRefCSElements getTypedMultiplicityRefCSAccess() {
		return gaQVTbase.getTypedMultiplicityRefCSAccess();
	}

	public ParserRule getTypedMultiplicityRefCSRule() {
		return getTypedMultiplicityRefCSAccess().getRule();
	}

	//TypedRefCS returns base::TypedRefCS:
	//    TypeLiteralCS | TypedTypeRefCS
	//;
	public QVTbaseGrammarAccess.TypedRefCSElements getTypedRefCSAccess() {
		return gaQVTbase.getTypedRefCSAccess();
	}

	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	//StructuralFeatureCS returns base::StructuralFeatureCS:
	//    AttributeCS | ReferenceCS
	//;
	public QVTbaseGrammarAccess.StructuralFeatureCSElements getStructuralFeatureCSAccess() {
		return gaQVTbase.getStructuralFeatureCSAccess();
	}

	public ParserRule getStructuralFeatureCSRule() {
		return getStructuralFeatureCSAccess().getRule();
	}

	//EnumerationLiteralName returns ecore::EString:
	//    EssentialOCLUnrestrictedName
	//;
	public QVTbaseGrammarAccess.EnumerationLiteralNameElements getEnumerationLiteralNameAccess() {
		return gaQVTbase.getEnumerationLiteralNameAccess();
	}

	public ParserRule getEnumerationLiteralNameRule() {
		return getEnumerationLiteralNameAccess().getRule();
	}

	//QVTbaseUnrestrictedName:
	//    'abstract'
	//|    'attribute'
	//|    'body'
	//|    'class'
	//|    'composes'
	//|    'datatype'
	//|    'definition'
	//|    'derived'
	//|    'derivation'
	//|    'enum'
	//|    'extends'
	//|    'id'
	//|    'initial'
	//|    'interface'
	//|    'literal'
	//|    'operation'
	//|    'ordered'
	//|    'primitive'
	//|    'property'
	//|    'readonly'
	//|    'resolve'
	//|    'serializable'
	//|    'static'
	//|    'throws'
	//|    'transient'
	//|    'unique'
	//|    'unsettable'
	//|    'volatile'
	//;
	public QVTbaseGrammarAccess.QVTbaseUnrestrictedNameElements getQVTbaseUnrestrictedNameAccess() {
		return gaQVTbase.getQVTbaseUnrestrictedNameAccess();
	}

	public ParserRule getQVTbaseUnrestrictedNameRule() {
		return getQVTbaseUnrestrictedNameAccess().getRule();
	}

	///*
	//|    'callable'
	//|    'import'
	//|    'key'
	//|    'library'
	//|    'module'
	//|    'package'
	//|    'postcondition'
	//|    'precondition'
	//|    'reference'
	//*/
	//SIGNED returns ecore::EInt:
	//    '-'? INT
	//;
	public QVTbaseGrammarAccess.SIGNEDElements getSIGNEDAccess() {
		return gaQVTbase.getSIGNEDAccess();
	}

	public ParserRule getSIGNEDRule() {
		return getSIGNEDAccess().getRule();
	}

	//terminal UNQUOTED_STRING:    // Never forward parsed; just provides a placeholder
	//    '£$%^£$%^'                //  for reverse serialisation of embedded OCL
	//;
	public TerminalRule getUNQUOTED_STRINGRule() {
		return gaQVTbase.getUNQUOTED_STRINGRule();
	}

	////generate essentialOCLCST "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST"
	//Model returns ContextCS:
	//    ownedExpression=ExpCS;
	public EssentialOCLGrammarAccess.ModelElements getModelAccess() {
		return gaEssentialOCL.getModelAccess();
	}

	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLReservedKeyword:
	//    'and'
	//    | 'and2'
	//    | 'else'
	//    | 'endif'
	//    | 'if'
	//    | 'implies'
	//    | 'implies2'
	//    | 'in'
	//    | 'let'
	//    | 'not'
	//    | 'not2'
	//    | 'or'
	//    | 'or2'
	//    | 'then'
	//    | 'with'
	//    | 'xor'
	//    | 'xor2';
	public EssentialOCLGrammarAccess.EssentialOCLReservedKeywordElements getEssentialOCLReservedKeywordAccess() {
		return gaEssentialOCL.getEssentialOCLReservedKeywordAccess();
	}

	public ParserRule getEssentialOCLReservedKeywordRule() {
		return getEssentialOCLReservedKeywordAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnaryOperatorName:
	//    '-' | 'not' | 'not2';
	public EssentialOCLGrammarAccess.EssentialOCLUnaryOperatorNameElements getEssentialOCLUnaryOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnaryOperatorNameAccess();
	}

	public ParserRule getEssentialOCLUnaryOperatorNameRule() {
		return getEssentialOCLUnaryOperatorNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLInfixOperatorName:
	//    '*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'and2' | 'implies' | 'implies2' | 'or' | 'or2' | 'xor' | 'xor2';
	public EssentialOCLGrammarAccess.EssentialOCLInfixOperatorNameElements getEssentialOCLInfixOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLInfixOperatorNameAccess();
	}

	public ParserRule getEssentialOCLInfixOperatorNameRule() {
		return getEssentialOCLInfixOperatorNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLNavigationOperatorName:
	//    '.' | '->' | '?.' | '?->';
	public EssentialOCLGrammarAccess.EssentialOCLNavigationOperatorNameElements getEssentialOCLNavigationOperatorNameAccess() {
		return gaEssentialOCL.getEssentialOCLNavigationOperatorNameAccess();
	}

	public ParserRule getEssentialOCLNavigationOperatorNameRule() {
		return getEssentialOCLNavigationOperatorNameAccess().getRule();
	}

	//BinaryOperatorName:
	//    InfixOperatorName | NavigationOperatorName;
	public EssentialOCLGrammarAccess.BinaryOperatorNameElements getBinaryOperatorNameAccess() {
		return gaEssentialOCL.getBinaryOperatorNameAccess();
	}

	public ParserRule getBinaryOperatorNameRule() {
		return getBinaryOperatorNameAccess().getRule();
	}

	//InfixOperatorName:             // Intended to be overrideable
	//    EssentialOCLInfixOperatorName;
	public EssentialOCLGrammarAccess.InfixOperatorNameElements getInfixOperatorNameAccess() {
		return gaEssentialOCL.getInfixOperatorNameAccess();
	}

	public ParserRule getInfixOperatorNameRule() {
		return getInfixOperatorNameAccess().getRule();
	}

	//NavigationOperatorName:     // Intended to be overrideable
	//    EssentialOCLNavigationOperatorName;
	public EssentialOCLGrammarAccess.NavigationOperatorNameElements getNavigationOperatorNameAccess() {
		return gaEssentialOCL.getNavigationOperatorNameAccess();
	}

	public ParserRule getNavigationOperatorNameRule() {
		return getNavigationOperatorNameAccess().getRule();
	}

	//UnaryOperatorName:             // Intended to be overrideable
	//    EssentialOCLUnaryOperatorName;
	public EssentialOCLGrammarAccess.UnaryOperatorNameElements getUnaryOperatorNameAccess() {
		return gaEssentialOCL.getUnaryOperatorNameAccess();
	}

	public ParserRule getUnaryOperatorNameRule() {
		return getUnaryOperatorNameAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Names
	////---------------------------------------------------------------------
	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnrestrictedName returns ecore::EString:
	//    Identifier;
	public EssentialOCLGrammarAccess.EssentialOCLUnrestrictedNameElements getEssentialOCLUnrestrictedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnrestrictedNameAccess();
	}

	public ParserRule getEssentialOCLUnrestrictedNameRule() {
		return getEssentialOCLUnrestrictedNameAccess().getRule();
	}

	///** <<<This is a join point for derived grammars - replace with a more disciplined grammar extensibility>>> */
	//EssentialOCLUnreservedName returns ecore::EString:
	//    UnrestrictedName
	//|    CollectionTypeIdentifier
	//|    PrimitiveTypeIdentifier
	//|    'Map'
	//|    'Tuple'
	//;
	public EssentialOCLGrammarAccess.EssentialOCLUnreservedNameElements getEssentialOCLUnreservedNameAccess() {
		return gaEssentialOCL.getEssentialOCLUnreservedNameAccess();
	}

	public ParserRule getEssentialOCLUnreservedNameRule() {
		return getEssentialOCLUnreservedNameAccess().getRule();
	}

	//@Override
	//UnreservedName returns ecore::EString: // Intended to be overridden
	//    EssentialOCLUnreservedName;
	public EssentialOCLGrammarAccess.UnreservedNameElements getUnreservedNameAccess() {
		return gaEssentialOCL.getUnreservedNameAccess();
	}

	public ParserRule getUnreservedNameRule() {
		return getUnreservedNameAccess().getRule();
	}

	//URIPathNameCS returns base::PathNameCS:
	//    ownedPathElements+=URIFirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public EssentialOCLGrammarAccess.URIPathNameCSElements getURIPathNameCSAccess() {
		return gaEssentialOCL.getURIPathNameCSAccess();
	}

	public ParserRule getURIPathNameCSRule() {
		return getURIPathNameCSAccess().getRule();
	}

	//URIFirstPathElementCS returns base::PathElementCS:
	//    referredElement=[pivot::NamedElement|UnrestrictedName] | {base::PathElementWithURICS} referredElement=[pivot::Namespace|URI];
	public EssentialOCLGrammarAccess.URIFirstPathElementCSElements getURIFirstPathElementCSAccess() {
		return gaEssentialOCL.getURIFirstPathElementCSAccess();
	}

	public ParserRule getURIFirstPathElementCSRule() {
		return getURIFirstPathElementCSAccess().getRule();
	}

	//SimplePathNameCS returns base::PathNameCS:
	//    ownedPathElements+=FirstPathElementCS;
	public EssentialOCLGrammarAccess.SimplePathNameCSElements getSimplePathNameCSAccess() {
		return gaEssentialOCL.getSimplePathNameCSAccess();
	}

	public ParserRule getSimplePathNameCSRule() {
		return getSimplePathNameCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Types
	////---------------------------------------------------------------------
	//PrimitiveTypeIdentifier:
	//    'Boolean'
	//    | 'Integer'
	//    | 'Real'
	//    | 'String'
	//    | 'UnlimitedNatural'
	//    | 'OclAny'
	//    | 'OclInvalid'
	//    | 'OclVoid';
	public EssentialOCLGrammarAccess.PrimitiveTypeIdentifierElements getPrimitiveTypeIdentifierAccess() {
		return gaEssentialOCL.getPrimitiveTypeIdentifierAccess();
	}

	public ParserRule getPrimitiveTypeIdentifierRule() {
		return getPrimitiveTypeIdentifierAccess().getRule();
	}

	//PrimitiveTypeCS returns base::PrimitiveTypeRefCS:
	//    name=PrimitiveTypeIdentifier;
	public EssentialOCLGrammarAccess.PrimitiveTypeCSElements getPrimitiveTypeCSAccess() {
		return gaEssentialOCL.getPrimitiveTypeCSAccess();
	}

	public ParserRule getPrimitiveTypeCSRule() {
		return getPrimitiveTypeCSAccess().getRule();
	}

	//CollectionTypeIdentifier returns ecore::EString:
	//    'Set'
	//    | 'Bag'
	//    | 'Sequence'
	//    | 'Collection'
	//    | 'OrderedSet';
	public EssentialOCLGrammarAccess.CollectionTypeIdentifierElements getCollectionTypeIdentifierAccess() {
		return gaEssentialOCL.getCollectionTypeIdentifierAccess();
	}

	public ParserRule getCollectionTypeIdentifierRule() {
		return getCollectionTypeIdentifierAccess().getRule();
	}

	//CollectionTypeCS returns CollectionTypeCS:
	//    name=CollectionTypeIdentifier ('(' ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS? ')')?;
	public EssentialOCLGrammarAccess.CollectionTypeCSElements getCollectionTypeCSAccess() {
		return gaEssentialOCL.getCollectionTypeCSAccess();
	}

	public ParserRule getCollectionTypeCSRule() {
		return getCollectionTypeCSAccess().getRule();
	}

	//MapTypeCS returns MapTypeCS:
	//    name='Map' ('(' ownedKeyType=TypeExpCS ',' ownedValueType=TypeExpCS ')')?;
	public EssentialOCLGrammarAccess.MapTypeCSElements getMapTypeCSAccess() {
		return gaEssentialOCL.getMapTypeCSAccess();
	}

	public ParserRule getMapTypeCSRule() {
		return getMapTypeCSAccess().getRule();
	}

	//TupleTypeCS returns base::TupleTypeCS:
	//    name='Tuple' ('(' (ownedParts+=TuplePartCS (',' ownedParts+=TuplePartCS)*)? ')')?;
	public EssentialOCLGrammarAccess.TupleTypeCSElements getTupleTypeCSAccess() {
		return gaEssentialOCL.getTupleTypeCSAccess();
	}

	public ParserRule getTupleTypeCSRule() {
		return getTupleTypeCSAccess().getRule();
	}

	//TuplePartCS returns base::TuplePartCS:
	//    name=UnrestrictedName ':' ownedType=TypeExpCS;
	public EssentialOCLGrammarAccess.TuplePartCSElements getTuplePartCSAccess() {
		return gaEssentialOCL.getTuplePartCSAccess();
	}

	public ParserRule getTuplePartCSRule() {
		return getTuplePartCSAccess().getRule();
	}

	////---------------------------------------------------------------------
	////  Literals
	////---------------------------------------------------------------------
	//CollectionLiteralExpCS returns CollectionLiteralExpCS:
	//    ownedType=CollectionTypeCS
	//    '{' (ownedParts+=CollectionLiteralPartCS
	//    (',' ownedParts+=CollectionLiteralPartCS)*)?
	//    '}';
	public EssentialOCLGrammarAccess.CollectionLiteralExpCSElements getCollectionLiteralExpCSAccess() {
		return gaEssentialOCL.getCollectionLiteralExpCSAccess();
	}

	public ParserRule getCollectionLiteralExpCSRule() {
		return getCollectionLiteralExpCSAccess().getRule();
	}

	//CollectionLiteralPartCS returns CollectionLiteralPartCS:
	//    (ownedExpression=ExpCS ('..' ownedLastExpression=ExpCS)?) | ownedExpression=PatternExpCS;
	public EssentialOCLGrammarAccess.CollectionLiteralPartCSElements getCollectionLiteralPartCSAccess() {
		return gaEssentialOCL.getCollectionLiteralPartCSAccess();
	}

	public ParserRule getCollectionLiteralPartCSRule() {
		return getCollectionLiteralPartCSAccess().getRule();
	}

	//CollectionPatternCS returns CollectionPatternCS:
	//    ownedType=CollectionTypeCS
	//    '{' (ownedParts+=PatternExpCS
	//    (',' ownedParts+=PatternExpCS)*
	//    ('++' restVariableName=Identifier))?
	//    '}';
	public EssentialOCLGrammarAccess.CollectionPatternCSElements getCollectionPatternCSAccess() {
		return gaEssentialOCL.getCollectionPatternCSAccess();
	}

	public ParserRule getCollectionPatternCSRule() {
		return getCollectionPatternCSAccess().getRule();
	}

	//ShadowPartCS returns ShadowPartCS:        // PatternPartCS
	//    (referredProperty=[pivot::Property|UnrestrictedName] '='ownedInitExpression=(ExpCS|PatternExpCS))
	//    | ownedInitExpression=StringLiteralExpCS;
	public EssentialOCLGrammarAccess.ShadowPartCSElements getShadowPartCSAccess() {
		return gaEssentialOCL.getShadowPartCSAccess();
	}

	public ParserRule getShadowPartCSRule() {
		return getShadowPartCSAccess().getRule();
	}

	//PatternExpCS:
	//    patternVariableName=UnrestrictedName? ':' ownedPatternType=TypeExpCS;
	public EssentialOCLGrammarAccess.PatternExpCSElements getPatternExpCSAccess() {
		return gaEssentialOCL.getPatternExpCSAccess();
	}

	public ParserRule getPatternExpCSRule() {
		return getPatternExpCSAccess().getRule();
	}

	//LambdaLiteralExpCS returns LambdaLiteralExpCS:
	//    'Lambda' '{' ownedExpressionCS=ExpCS '}';
	public EssentialOCLGrammarAccess.LambdaLiteralExpCSElements getLambdaLiteralExpCSAccess() {
		return gaEssentialOCL.getLambdaLiteralExpCSAccess();
	}

	public ParserRule getLambdaLiteralExpCSRule() {
		return getLambdaLiteralExpCSAccess().getRule();
	}

	//MapLiteralExpCS returns MapLiteralExpCS:
	//    ownedType=MapTypeCS '{' (ownedParts+=MapLiteralPartCS (',' ownedParts+=MapLiteralPartCS)*)? '}';
	public EssentialOCLGrammarAccess.MapLiteralExpCSElements getMapLiteralExpCSAccess() {
		return gaEssentialOCL.getMapLiteralExpCSAccess();
	}

	public ParserRule getMapLiteralExpCSRule() {
		return getMapLiteralExpCSAccess().getRule();
	}

	//MapLiteralPartCS returns MapLiteralPartCS:
	//    ownedKey=ExpCS ('with'|'<-') ownedValue=ExpCS;
	public EssentialOCLGrammarAccess.MapLiteralPartCSElements getMapLiteralPartCSAccess() {
		return gaEssentialOCL.getMapLiteralPartCSAccess();
	}

	public ParserRule getMapLiteralPartCSRule() {
		return getMapLiteralPartCSAccess().getRule();
	}

	//        // <- is deprecated see Bug 577614
	//PrimitiveLiteralExpCS returns PrimitiveLiteralExpCS:
	//    NumberLiteralExpCS
	//    | StringLiteralExpCS
	//    | BooleanLiteralExpCS
	//    | UnlimitedNaturalLiteralExpCS
	//    | InvalidLiteralExpCS
	//    | NullLiteralExpCS;
	public EssentialOCLGrammarAccess.PrimitiveLiteralExpCSElements getPrimitiveLiteralExpCSAccess() {
		return gaEssentialOCL.getPrimitiveLiteralExpCSAccess();
	}

	public ParserRule getPrimitiveLiteralExpCSRule() {
		return getPrimitiveLiteralExpCSAccess().getRule();
	}

	//TupleLiteralExpCS returns TupleLiteralExpCS:
	//    'Tuple' '{' ownedParts+=TupleLiteralPartCS (',' ownedParts+=TupleLiteralPartCS)* '}';
	public EssentialOCLGrammarAccess.TupleLiteralExpCSElements getTupleLiteralExpCSAccess() {
		return gaEssentialOCL.getTupleLiteralExpCSAccess();
	}

	public ParserRule getTupleLiteralExpCSRule() {
		return getTupleLiteralExpCSAccess().getRule();
	}

	//TupleLiteralPartCS returns TupleLiteralPartCS:
	//    name=UnrestrictedName (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.TupleLiteralPartCSElements getTupleLiteralPartCSAccess() {
		return gaEssentialOCL.getTupleLiteralPartCSAccess();
	}

	public ParserRule getTupleLiteralPartCSRule() {
		return getTupleLiteralPartCSAccess().getRule();
	}

	//NumberLiteralExpCS returns NumberLiteralExpCS:
	//    symbol=NUMBER_LITERAL;
	public EssentialOCLGrammarAccess.NumberLiteralExpCSElements getNumberLiteralExpCSAccess() {
		return gaEssentialOCL.getNumberLiteralExpCSAccess();
	}

	public ParserRule getNumberLiteralExpCSRule() {
		return getNumberLiteralExpCSAccess().getRule();
	}

	//StringLiteralExpCS returns StringLiteralExpCS:
	//    segments+=StringLiteral+;
	public EssentialOCLGrammarAccess.StringLiteralExpCSElements getStringLiteralExpCSAccess() {
		return gaEssentialOCL.getStringLiteralExpCSAccess();
	}

	public ParserRule getStringLiteralExpCSRule() {
		return getStringLiteralExpCSAccess().getRule();
	}

	//BooleanLiteralExpCS returns BooleanLiteralExpCS:
	//    symbol='true'
	//    | symbol='false';
	public EssentialOCLGrammarAccess.BooleanLiteralExpCSElements getBooleanLiteralExpCSAccess() {
		return gaEssentialOCL.getBooleanLiteralExpCSAccess();
	}

	public ParserRule getBooleanLiteralExpCSRule() {
		return getBooleanLiteralExpCSAccess().getRule();
	}

	//UnlimitedNaturalLiteralExpCS returns UnlimitedNaturalLiteralExpCS:
	//    {UnlimitedNaturalLiteralExpCS} '*';
	public EssentialOCLGrammarAccess.UnlimitedNaturalLiteralExpCSElements getUnlimitedNaturalLiteralExpCSAccess() {
		return gaEssentialOCL.getUnlimitedNaturalLiteralExpCSAccess();
	}

	public ParserRule getUnlimitedNaturalLiteralExpCSRule() {
		return getUnlimitedNaturalLiteralExpCSAccess().getRule();
	}

	//InvalidLiteralExpCS returns InvalidLiteralExpCS:
	//    {InvalidLiteralExpCS} 'invalid';
	public EssentialOCLGrammarAccess.InvalidLiteralExpCSElements getInvalidLiteralExpCSAccess() {
		return gaEssentialOCL.getInvalidLiteralExpCSAccess();
	}

	public ParserRule getInvalidLiteralExpCSRule() {
		return getInvalidLiteralExpCSAccess().getRule();
	}

	//NullLiteralExpCS returns NullLiteralExpCS:
	//    {NullLiteralExpCS} 'null';
	public EssentialOCLGrammarAccess.NullLiteralExpCSElements getNullLiteralExpCSAccess() {
		return gaEssentialOCL.getNullLiteralExpCSAccess();
	}

	public ParserRule getNullLiteralExpCSRule() {
		return getNullLiteralExpCSAccess().getRule();
	}

	//TypeLiteralCS returns base::TypedRefCS:
	//    PrimitiveTypeCS
	//    | CollectionTypeCS
	//    | MapTypeCS
	//    | TupleTypeCS;
	public EssentialOCLGrammarAccess.TypeLiteralCSElements getTypeLiteralCSAccess() {
		return gaEssentialOCL.getTypeLiteralCSAccess();
	}

	public ParserRule getTypeLiteralCSRule() {
		return getTypeLiteralCSAccess().getRule();
	}

	//TypeLiteralWithMultiplicityCS returns base::TypedRefCS:
	//    TypeLiteralCS ownedMultiplicity=MultiplicityCS?;
	public EssentialOCLGrammarAccess.TypeLiteralWithMultiplicityCSElements getTypeLiteralWithMultiplicityCSAccess() {
		return gaEssentialOCL.getTypeLiteralWithMultiplicityCSAccess();
	}

	public ParserRule getTypeLiteralWithMultiplicityCSRule() {
		return getTypeLiteralWithMultiplicityCSAccess().getRule();
	}

	//TypeLiteralExpCS returns TypeLiteralExpCS:
	//    ownedType=TypeLiteralWithMultiplicityCS;
	public EssentialOCLGrammarAccess.TypeLiteralExpCSElements getTypeLiteralExpCSAccess() {
		return gaEssentialOCL.getTypeLiteralExpCSAccess();
	}

	public ParserRule getTypeLiteralExpCSRule() {
		return getTypeLiteralExpCSAccess().getRule();
	}

	//TypeNameExpCS returns TypeNameExpCS:
	//    ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' ownedPatternGuard=ExpCS '}')?)?;
	public EssentialOCLGrammarAccess.TypeNameExpCSElements getTypeNameExpCSAccess() {
		return gaEssentialOCL.getTypeNameExpCSAccess();
	}

	public ParserRule getTypeNameExpCSRule() {
		return getTypeNameExpCSAccess().getRule();
	}

	//TypeExpWithoutMultiplicityCS returns base::TypedRefCS:
	//    (TypeNameExpCS | TypeLiteralCS | CollectionPatternCS);
	public EssentialOCLGrammarAccess.TypeExpWithoutMultiplicityCSElements getTypeExpWithoutMultiplicityCSAccess() {
		return gaEssentialOCL.getTypeExpWithoutMultiplicityCSAccess();
	}

	public ParserRule getTypeExpWithoutMultiplicityCSRule() {
		return getTypeExpWithoutMultiplicityCSAccess().getRule();
	}

	//TypeExpCS returns base::TypedRefCS:
	//    TypeExpWithoutMultiplicityCS ownedMultiplicity=MultiplicityCS?;
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
	///* An expression elaborates a prefixed expression with zero or more binary operator and expression suffixes.
	// * An optionally prefixed let expression is permitted except when suffixed with further expressions.*/
	//ExpCS returns ExpCS:
	////    ({InfixExpCS} ownedSource=PrefixedExpCS name=BinaryOperatorName ownedArgument=ExpCS)
	////|     PrefixedExpCS
	//// the above takes exponential or worse time for backtracking, below is fast
	//    (PrefixedPrimaryExpCS ({InfixExpCS.ownedLeft=current} name=BinaryOperatorName ownedRight=ExpCS)?)
	//|     PrefixedLetExpCS;
	public EssentialOCLGrammarAccess.ExpCSElements getExpCSAccess() {
		return gaEssentialOCL.getExpCSAccess();
	}

	public ParserRule getExpCSRule() {
		return getExpCSAccess().getRule();
	}

	///* A prefixed let expression elaborates a let expression with zero or more unary prefix operators. */
	//PrefixedLetExpCS returns ExpCS:
	//    ({PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedLetExpCS)
	//|     LetExpCS;
	public EssentialOCLGrammarAccess.PrefixedLetExpCSElements getPrefixedLetExpCSAccess() {
		return gaEssentialOCL.getPrefixedLetExpCSAccess();
	}

	public ParserRule getPrefixedLetExpCSRule() {
		return getPrefixedLetExpCSAccess().getRule();
	}

	///* A prefixed primary expression elaborates a primary expression with zero or more unary prefix operators. */
	//PrefixedPrimaryExpCS returns ExpCS:
	//    ({PrefixExpCS} name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS)
	//|     PrimaryExpCS;
	public EssentialOCLGrammarAccess.PrefixedPrimaryExpCSElements getPrefixedPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrefixedPrimaryExpCSAccess();
	}

	public ParserRule getPrefixedPrimaryExpCSRule() {
		return getPrefixedPrimaryExpCSAccess().getRule();
	}

	///* A primary expression identifies the basic expressions from which more complex expressions may be constructed. */
	//PrimaryExpCS returns ExpCS:
	//    NestedExpCS
	//|    IfExpCS
	//|     SelfExpCS
	//|     PrimitiveLiteralExpCS
	//|     TupleLiteralExpCS
	//|     MapLiteralExpCS
	//|     CollectionLiteralExpCS
	//|     LambdaLiteralExpCS
	//|     TypeLiteralExpCS
	//|     NameExpCS;
	public EssentialOCLGrammarAccess.PrimaryExpCSElements getPrimaryExpCSAccess() {
		return gaEssentialOCL.getPrimaryExpCSAccess();
	}

	public ParserRule getPrimaryExpCSRule() {
		return getPrimaryExpCSAccess().getRule();
	}

	///* A name expression is a generalised rule for expressions that start with a name and which may be followed by square, round or
	// * curly bracket clauses and optionally an @pre as well.*/
	//NameExpCS returns NameExpCS:
	//    ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS*
	//    ownedRoundBracketedClause=RoundBracketedClauseCS? ownedCurlyBracketedClause=CurlyBracketedClauseCS? (isPre?='@' 'pre')?;
	public EssentialOCLGrammarAccess.NameExpCSElements getNameExpCSAccess() {
		return gaEssentialOCL.getNameExpCSAccess();
	}

	public ParserRule getNameExpCSRule() {
		return getNameExpCSAccess().getRule();
	}

	///* A curly bracket clause is a generalized rule for the literal arguments of collections, maps, tuples and shadows.*/
	//CurlyBracketedClauseCS:
	//    {CurlyBracketedClauseCS} '{' ((ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*))? '}'
	//    ;
	public EssentialOCLGrammarAccess.CurlyBracketedClauseCSElements getCurlyBracketedClauseCSAccess() {
		return gaEssentialOCL.getCurlyBracketedClauseCSAccess();
	}

	public ParserRule getCurlyBracketedClauseCSRule() {
		return getCurlyBracketedClauseCSAccess().getRule();
	}

	///* A curly bracket clause is a generalized rule for template specialisations and operations arguments.*/
	//RoundBracketedClauseCS:
	//    {RoundBracketedClauseCS} '(' (ownedArguments+=NavigatingArgCS (ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS))*)? ')'
	//    ;
	public EssentialOCLGrammarAccess.RoundBracketedClauseCSElements getRoundBracketedClauseCSAccess() {
		return gaEssentialOCL.getRoundBracketedClauseCSAccess();
	}

	public ParserRule getRoundBracketedClauseCSRule() {
		return getRoundBracketedClauseCSAccess().getRule();
	}

	///* A square bracket clause is a generalized rule for association class qualifiers and roles.*/
	//SquareBracketedClauseCS:
	//    '[' ownedTerms+=ExpCS (',' ownedTerms+=ExpCS)* ']';
	public EssentialOCLGrammarAccess.SquareBracketedClauseCSElements getSquareBracketedClauseCSAccess() {
		return gaEssentialOCL.getSquareBracketedClauseCSAccess();
	}

	public ParserRule getSquareBracketedClauseCSRule() {
		return getSquareBracketedClauseCSAccess().getRule();
	}

	///* A navigating argument is a generalized rule for the first argument in a round bracket clause. This is typically the first operation
	// * parameter or an iterator. */
	//NavigatingArgCS returns NavigatingArgCS:
	//    (ownedNameExpression=NavigatingArgExpCS ((('with'|'<-') ownedCoIterator=CoIteratorVariableCS ('=' ownedInitExpression=ExpCS)?)
	//                                            |(':' ownedType=TypeExpCS (('with'|'<-') ownedCoIterator=CoIteratorVariableCS)? ('=' ownedInitExpression=ExpCS)?)
	//                                            | ((':' ownedType=TypeExpCS)? (('with'|'<-') ownedCoIterator=CoIteratorVariableCS)? 'in' ownedInitExpression=ExpCS)
	//                                            )?
	//    )
	//    | (':' ownedType=TypeExpCS);
	public EssentialOCLGrammarAccess.NavigatingArgCSElements getNavigatingArgCSAccess() {
		return gaEssentialOCL.getNavigatingArgCSAccess();
	}

	public ParserRule getNavigatingArgCSRule() {
		return getNavigatingArgCSAccess().getRule();
	}

	//    // Type-less init is an illegal infix expression
	///* A navigating bar argument is a generalized rule for a bar-prefixed argument in a round bracket clause. This is typically the body of an iteration. */
	//NavigatingBarArgCS returns NavigatingArgCS:
	//    prefix='|' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingBarArgCSElements getNavigatingBarArgCSAccess() {
		return gaEssentialOCL.getNavigatingBarArgCSAccess();
	}

	public ParserRule getNavigatingBarArgCSRule() {
		return getNavigatingBarArgCSAccess().getRule();
	}

	//    // Type-less init is an illegal infix expression
	///* A navigating comma argument is a generalized rule for non-first argument in a round bracket clause. These are typically non-first operation
	// * parameters or a second iterator. */
	//NavigatingCommaArgCS returns NavigatingArgCS:
	//    prefix=',' ownedNameExpression=NavigatingArgExpCS ((('with'|'<-') ownedCoIterator=CoIteratorVariableCS ('=' ownedInitExpression=ExpCS)?)
	//                                                      |(':' ownedType=TypeExpCS (('with'|'<-') ownedCoIterator=CoIteratorVariableCS)? ('=' ownedInitExpression=ExpCS)?)
	//                                                      | ((':' ownedType=TypeExpCS)? (('with'|'<-') ownedCoIterator=CoIteratorVariableCS)? 'in' ownedInitExpression=ExpCS)
	//                                                      )?;
	public EssentialOCLGrammarAccess.NavigatingCommaArgCSElements getNavigatingCommaArgCSAccess() {
		return gaEssentialOCL.getNavigatingCommaArgCSAccess();
	}

	public ParserRule getNavigatingCommaArgCSRule() {
		return getNavigatingCommaArgCSAccess().getRule();
	}

	//    // Type-less init is an illegal infix expression
	///* A navigating semi argument is a generalized rule for a semicolon prefixed argument in a round bracket clause. This is typically an iterate accumulator. */
	//NavigatingSemiArgCS returns NavigatingArgCS:
	//    prefix=';' ownedNameExpression=NavigatingArgExpCS (':' ownedType=TypeExpCS ('=' ownedInitExpression=ExpCS)?)?;
	public EssentialOCLGrammarAccess.NavigatingSemiArgCSElements getNavigatingSemiArgCSAccess() {
		return gaEssentialOCL.getNavigatingSemiArgCSAccess();
	}

	public ParserRule getNavigatingSemiArgCSRule() {
		return getNavigatingSemiArgCSAccess().getRule();
	}

	//    // Type-less init is an illegal infix expression
	//NavigatingArgExpCS returns ExpCS: // Intended to be overridden
	//    ExpCS
	//    //    '?'    -- defined by Complete OCL
	//;
	public EssentialOCLGrammarAccess.NavigatingArgExpCSElements getNavigatingArgExpCSAccess() {
		return gaEssentialOCL.getNavigatingArgExpCSAccess();
	}

	public ParserRule getNavigatingArgExpCSRule() {
		return getNavigatingArgExpCSAccess().getRule();
	}

	//CoIteratorVariableCS returns VariableCS:
	//    name=UnrestrictedName (':' ownedType=TypeExpCS)?;
	public EssentialOCLGrammarAccess.CoIteratorVariableCSElements getCoIteratorVariableCSAccess() {
		return gaEssentialOCL.getCoIteratorVariableCSAccess();
	}

	public ParserRule getCoIteratorVariableCSRule() {
		return getCoIteratorVariableCSAccess().getRule();
	}

	//IfExpCS returns IfExpCS:
	//    'if' ownedCondition=(ExpCS|PatternExpCS)
	//    'then' ownedThenExpression=ExpCS
	////    ifThenExpressions+=IfThenExpCS
	//    (ownedIfThenExpressions+=ElseIfThenExpCS)*
	//    'else' ownedElseExpression=ExpCS
	//    'endif';
	public EssentialOCLGrammarAccess.IfExpCSElements getIfExpCSAccess() {
		return gaEssentialOCL.getIfExpCSAccess();
	}

	public ParserRule getIfExpCSRule() {
		return getIfExpCSAccess().getRule();
	}

	////IfThenExpCS returns IfThenExpCS:
	////    'if' condition=ExpCS
	////    'then' thenExpression=ExpCS
	////;
	//ElseIfThenExpCS returns IfThenExpCS:
	//    'elseif' ownedCondition=ExpCS
	//    'then' ownedThenExpression=ExpCS
	//;
	public EssentialOCLGrammarAccess.ElseIfThenExpCSElements getElseIfThenExpCSAccess() {
		return gaEssentialOCL.getElseIfThenExpCSAccess();
	}

	public ParserRule getElseIfThenExpCSRule() {
		return getElseIfThenExpCSAccess().getRule();
	}

	//LetExpCS returns LetExpCS:
	//    'let' ownedVariables+=LetVariableCS (',' ownedVariables+=LetVariableCS)*
	//    'in' ownedInExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetExpCSElements getLetExpCSAccess() {
		return gaEssentialOCL.getLetExpCSAccess();
	}

	public ParserRule getLetExpCSRule() {
		return getLetExpCSAccess().getRule();
	}

	//LetVariableCS returns LetVariableCS:
	//    name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? (':' ownedType=TypeExpCS)? '=' ownedInitExpression=ExpCS;
	public EssentialOCLGrammarAccess.LetVariableCSElements getLetVariableCSAccess() {
		return gaEssentialOCL.getLetVariableCSAccess();
	}

	public ParserRule getLetVariableCSRule() {
		return getLetVariableCSAccess().getRule();
	}

	//NestedExpCS returns NestedExpCS:
	//    '(' ownedExpression=ExpCS ')';
	public EssentialOCLGrammarAccess.NestedExpCSElements getNestedExpCSAccess() {
		return gaEssentialOCL.getNestedExpCSAccess();
	}

	public ParserRule getNestedExpCSRule() {
		return getNestedExpCSAccess().getRule();
	}

	//SelfExpCS returns SelfExpCS:
	//    {SelfExpCS} 'self';
	public EssentialOCLGrammarAccess.SelfExpCSElements getSelfExpCSAccess() {
		return gaEssentialOCL.getSelfExpCSAccess();
	}

	public ParserRule getSelfExpCSRule() {
		return getSelfExpCSAccess().getRule();
	}

	//MultiplicityBoundsCS returns MultiplicityBoundsCS:
	//     lowerBound=LOWER ('..' upperBound=UPPER)?;
	public BaseGrammarAccess.MultiplicityBoundsCSElements getMultiplicityBoundsCSAccess() {
		return gaBase.getMultiplicityBoundsCSAccess();
	}

	public ParserRule getMultiplicityBoundsCSRule() {
		return getMultiplicityBoundsCSAccess().getRule();
	}

	//MultiplicityCS returns MultiplicityCS:
	//    '[' (MultiplicityBoundsCS | MultiplicityStringCS) ('|?' | isNullFree?='|1')? ']';
	public BaseGrammarAccess.MultiplicityCSElements getMultiplicityCSAccess() {
		return gaBase.getMultiplicityCSAccess();
	}

	public ParserRule getMultiplicityCSRule() {
		return getMultiplicityCSAccess().getRule();
	}

	//MultiplicityStringCS returns MultiplicityStringCS:
	//    stringBounds=('*'|'+'|'?');
	public BaseGrammarAccess.MultiplicityStringCSElements getMultiplicityStringCSAccess() {
		return gaBase.getMultiplicityStringCSAccess();
	}

	public ParserRule getMultiplicityStringCSRule() {
		return getMultiplicityStringCSAccess().getRule();
	}

	//PathNameCS returns PathNameCS:
	//    ownedPathElements+=FirstPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public BaseGrammarAccess.PathNameCSElements getPathNameCSAccess() {
		return gaBase.getPathNameCSAccess();
	}

	public ParserRule getPathNameCSRule() {
		return getPathNameCSAccess().getRule();
	}

	//UnreservedPathNameCS returns PathNameCS:
	//    ownedPathElements+=NextPathElementCS ('::' ownedPathElements+=NextPathElementCS)*;
	public BaseGrammarAccess.UnreservedPathNameCSElements getUnreservedPathNameCSAccess() {
		return gaBase.getUnreservedPathNameCSAccess();
	}

	public ParserRule getUnreservedPathNameCSRule() {
		return getUnreservedPathNameCSAccess().getRule();
	}

	//FirstPathElementCS returns PathElementCS:
	//    referredElement=[pivot::NamedElement|UnrestrictedName];
	public BaseGrammarAccess.FirstPathElementCSElements getFirstPathElementCSAccess() {
		return gaBase.getFirstPathElementCSAccess();
	}

	public ParserRule getFirstPathElementCSRule() {
		return getFirstPathElementCSAccess().getRule();
	}

	//NextPathElementCS returns PathElementCS:
	//    referredElement=[pivot::NamedElement|UnreservedName];
	public BaseGrammarAccess.NextPathElementCSElements getNextPathElementCSAccess() {
		return gaBase.getNextPathElementCSAccess();
	}

	public ParserRule getNextPathElementCSRule() {
		return getNextPathElementCSAccess().getRule();
	}

	//TemplateBindingCS returns TemplateBindingCS:
	//    ownedSubstitutions+=TemplateParameterSubstitutionCS (',' ownedSubstitutions+=TemplateParameterSubstitutionCS)* (ownedMultiplicity=MultiplicityCS)?
	//;
	public BaseGrammarAccess.TemplateBindingCSElements getTemplateBindingCSAccess() {
		return gaBase.getTemplateBindingCSAccess();
	}

	public ParserRule getTemplateBindingCSRule() {
		return getTemplateBindingCSAccess().getRule();
	}

	//TemplateParameterSubstitutionCS returns TemplateParameterSubstitutionCS:
	//    ownedActualParameter=TypeRefCS
	//;
	public BaseGrammarAccess.TemplateParameterSubstitutionCSElements getTemplateParameterSubstitutionCSAccess() {
		return gaBase.getTemplateParameterSubstitutionCSAccess();
	}

	public ParserRule getTemplateParameterSubstitutionCSRule() {
		return getTemplateParameterSubstitutionCSAccess().getRule();
	}

	//TemplateSignatureCS returns TemplateSignatureCS:
	//    '(' ownedParameters+=TypeParameterCS (',' ownedParameters+=TypeParameterCS)* ')'
	//;
	public BaseGrammarAccess.TemplateSignatureCSElements getTemplateSignatureCSAccess() {
		return gaBase.getTemplateSignatureCSAccess();
	}

	public ParserRule getTemplateSignatureCSRule() {
		return getTemplateSignatureCSAccess().getRule();
	}

	//TypeParameterCS returns TypeParameterCS:
	//    name=UnrestrictedName
	//    ('extends' ownedExtends+=TypedRefCS ('&&' ownedExtends+=TypedRefCS)*)?
	//;
	public BaseGrammarAccess.TypeParameterCSElements getTypeParameterCSAccess() {
		return gaBase.getTypeParameterCSAccess();
	}

	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS returns TypeRefCS:
	//    TypedRefCS | WildcardTypeRefCS
	//;
	public BaseGrammarAccess.TypeRefCSElements getTypeRefCSAccess() {
		return gaBase.getTypeRefCSAccess();
	}

	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//TypedTypeRefCS returns TypedTypeRefCS:
	//    ownedPathName=PathNameCS ('(' ownedBinding=TemplateBindingCS ')')?
	//;
	public BaseGrammarAccess.TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return gaBase.getTypedTypeRefCSAccess();
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//WildcardTypeRefCS returns WildcardTypeRefCS:
	//    {WildcardTypeRefCS} '?' ('extends' ownedExtends=TypedRefCS)?
	//;
	public BaseGrammarAccess.WildcardTypeRefCSElements getWildcardTypeRefCSAccess() {
		return gaBase.getWildcardTypeRefCSAccess();
	}

	public ParserRule getWildcardTypeRefCSRule() {
		return getWildcardTypeRefCSAccess().getRule();
	}

	//ID: SIMPLE_ID | ESCAPED_ID;
	public BaseGrammarAccess.IDElements getIDAccess() {
		return gaBase.getIDAccess();
	}

	public ParserRule getIDRule() {
		return getIDAccess().getRule();
	}

	//Identifier:
	//    ID;
	public BaseGrammarAccess.IdentifierElements getIdentifierAccess() {
		return gaBase.getIdentifierAccess();
	}

	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}

	///* A lowerbounded integer is used to define the lowerbound of a collection multiplicity. The value may not be the unlimited value. */
	//LOWER returns ecore::EInt:
	//    INT
	//;
	public BaseGrammarAccess.LOWERElements getLOWERAccess() {
		return gaBase.getLOWERAccess();
	}

	public ParserRule getLOWERRule() {
		return getLOWERAccess().getRule();
	}

	///* A number may be an integer or floating point value. The declaration here appears to be that for just an integer. This is to avoid
	// * lookahead conflicts in simple lexers between a dot within a floating point number and the dot-dot in a CollectionLiteralPartCS. A
	// * practical implementation should give high priority to a successful parse of INT ('.' INT)? (('e' | 'E') ('+' | '-')? INT)? than
	// * to the unsuccessful partial parse of INT '..'. The type of the INT terminal is String to allow the floating point syntax to be used.
	// */
	//NUMBER_LITERAL returns BigNumber: // Not terminal to allow parser backtracking to sort out "5..7"
	//    INT;
	public BaseGrammarAccess.NUMBER_LITERALElements getNUMBER_LITERALAccess() {
		return gaBase.getNUMBER_LITERALAccess();
	}

	public ParserRule getNUMBER_LITERALRule() {
		return getNUMBER_LITERALAccess().getRule();
	}

	// // EssentialOCLTokenSource pieces this together ('.' INT)? (('e' | 'E') ('+' | '-')? INT)?;
	//StringLiteral:
	//    SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.StringLiteralElements getStringLiteralAccess() {
		return gaBase.getStringLiteralAccess();
	}

	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}

	///* An upperbounded integer is used to define the upperbound of a collection multiplicity. The value may be the unlimited value. */
	//UPPER returns ecore::EInt:
	//    INT | '*'
	//;
	public BaseGrammarAccess.UPPERElements getUPPERAccess() {
		return gaBase.getUPPERAccess();
	}

	public ParserRule getUPPERRule() {
		return getUPPERAccess().getRule();
	}

	//URI:
	//    SINGLE_QUOTED_STRING;
	public BaseGrammarAccess.URIElements getURIAccess() {
		return gaBase.getURIAccess();
	}

	public ParserRule getURIRule() {
		return getURIAccess().getRule();
	}

	//terminal fragment ESCAPED_CHARACTER:
	//    '\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\');
	public TerminalRule getESCAPED_CHARACTERRule() {
		return gaBase.getESCAPED_CHARACTERRule();
	}

	//terminal fragment LETTER_CHARACTER:
	//    'a'..'z' | 'A'..'Z' | '_';
	public TerminalRule getLETTER_CHARACTERRule() {
		return gaBase.getLETTER_CHARACTERRule();
	}

	//terminal DOUBLE_QUOTED_STRING:
	//    '"' (ESCAPED_CHARACTER | !('\\' | '"'))* '"';
	public TerminalRule getDOUBLE_QUOTED_STRINGRule() {
		return gaBase.getDOUBLE_QUOTED_STRINGRule();
	}

	//terminal SINGLE_QUOTED_STRING:
	//    "'" (ESCAPED_CHARACTER | !('\\' | "'"))* "'";
	public TerminalRule getSINGLE_QUOTED_STRINGRule() {
		return gaBase.getSINGLE_QUOTED_STRINGRule();
	}

	//terminal ML_SINGLE_QUOTED_STRING:
	//    "/'"->"'/";
	public TerminalRule getML_SINGLE_QUOTED_STRINGRule() {
		return gaBase.getML_SINGLE_QUOTED_STRINGRule();
	}

	//terminal SIMPLE_ID:
	//    LETTER_CHARACTER (LETTER_CHARACTER | ('0'..'9'))*;
	public TerminalRule getSIMPLE_IDRule() {
		return gaBase.getSIMPLE_IDRule();
	}

	//terminal ESCAPED_ID:
	//    "_" SINGLE_QUOTED_STRING;
	public TerminalRule getESCAPED_IDRule() {
		return gaBase.getESCAPED_IDRule();
	}

	//terminal INT: // String to allow diverse re-use
	//    ('0'..'9')+;
	public TerminalRule getINTRule() {
		return gaBase.getINTRule();
	}

	//        // multiple leading zeroes occur as floating point fractional part
	///* A multi-line comment supports a comment that may span more than one line using familiar slash-star...star-slash comment delimiters */
	//terminal ML_COMMENT:
	//    '/*' ->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaBase.getML_COMMENTRule();
	}

	///* A single-line comment supports a comment that terminates at the end of the line */
	//terminal SL_COMMENT:
	//    '--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaBase.getSL_COMMENTRule();
	}

	///* Whitespace may occur between any pair of tokens */
	//terminal WS:
	//    (' ' | '\t' | '\r' | '\n')+;
	public TerminalRule getWSRule() {
		return gaBase.getWSRule();
	}

	//terminal ANY_OTHER:
	//    .;
	public TerminalRule getANY_OTHERRule() {
		return gaBase.getANY_OTHERRule();
	}
}
