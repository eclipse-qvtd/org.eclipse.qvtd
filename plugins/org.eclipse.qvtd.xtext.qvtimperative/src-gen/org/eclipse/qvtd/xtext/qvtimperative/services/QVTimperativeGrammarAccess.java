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

import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;

@Singleton
public class QVTimperativeGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class TopLevelCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.TopLevelCS");
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

	public class AddStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.AddStatementCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAddKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTargetVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTargetVariableVariableCrossReference_1_0 = (CrossReference)cTargetVariableAssignment_1.eContents().get(0);
		private final RuleCall cTargetVariableVariableUnrestrictedNameParserRuleCall_1_0_1 = (RuleCall)cTargetVariableVariableCrossReference_1_0.eContents().get(1);
		private final Keyword cPlusSignEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_3_0 = (RuleCall)cOwnedExpressionAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//AddStatementCS:
		//	'add' targetVariable=[pivot::Variable|UnrestrictedName] '+=' ownedExpression=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'add' targetVariable=[pivot::Variable|UnrestrictedName] '+=' ownedExpression=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//'add'
		public Keyword getAddKeyword_0() { return cAddKeyword_0; }

		//targetVariable=[pivot::Variable|UnrestrictedName]
		public Assignment getTargetVariableAssignment_1() { return cTargetVariableAssignment_1; }

		//[pivot::Variable|UnrestrictedName]
		public CrossReference getTargetVariableVariableCrossReference_1_0() { return cTargetVariableVariableCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getTargetVariableVariableUnrestrictedNameParserRuleCall_1_0_1() { return cTargetVariableVariableUnrestrictedNameParserRuleCall_1_0_1; }

		//'+='
		public Keyword getPlusSignEqualsSignKeyword_2() { return cPlusSignEqualsSignKeyword_2; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_3() { return cOwnedExpressionAssignment_3; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_3_0() { return cOwnedExpressionExpCSParserRuleCall_3_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class BottomPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.BottomPatternCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBottomPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_0.eContents().get(0);
		private final Assignment cOwnedConstraintsAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cOwnedConstraintsConstraintCSParserRuleCall_2_1_0 = (RuleCall)cOwnedConstraintsAssignment_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//BottomPatternCS:
		//	{BottomPatternCS} '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedConstraints+=ConstraintCS)* '}';
		@Override public ParserRule getRule() { return rule; }

		//{BottomPatternCS} '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedConstraints+=ConstraintCS)* '}'
		public Group getGroup() { return cGroup; }

		//{BottomPatternCS}
		public Action getBottomPatternCSAction_0() { return cBottomPatternCSAction_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(ownedUnrealizedVariables+=UnrealizedVariableCS | ownedConstraints+=ConstraintCS)*
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//ownedUnrealizedVariables+=UnrealizedVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_0() { return cOwnedUnrealizedVariablesAssignment_2_0; }

		//UnrealizedVariableCS
		public RuleCall getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0() { return cOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0; }

		//ownedConstraints+=ConstraintCS
		public Assignment getOwnedConstraintsAssignment_2_1() { return cOwnedConstraintsAssignment_2_1; }

		//ConstraintCS
		public RuleCall getOwnedConstraintsConstraintCSParserRuleCall_2_1_0() { return cOwnedConstraintsConstraintCSParserRuleCall_2_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class BottomStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.BottomStatementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNewStatementCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSetStatementCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//BottomStatementCS StatementCS:
		//	NewStatementCS | SetStatementCS
		@Override public ParserRule getRule() { return rule; }

		//NewStatementCS | SetStatementCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//NewStatementCS
		public RuleCall getNewStatementCSParserRuleCall_0() { return cNewStatementCSParserRuleCall_0; }

		//SetStatementCS
		public RuleCall getSetStatementCSParserRuleCall_1() { return cSetStatementCSParserRuleCall_1; }
	}

	public class ConstraintCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ConstraintCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCheckKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedTargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedTargetExpCSParserRuleCall_1_0 = (RuleCall)cOwnedTargetAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonEqualsSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedInitExpressionAssignment_2_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ConstraintCS PredicateOrAssignmentCS:
		//	'check' ownedTarget=ExpCS (':=' ownedInitExpression=ExpCS)? ';'
		@Override public ParserRule getRule() { return rule; }

		//'check' ownedTarget=ExpCS (':=' ownedInitExpression=ExpCS)? ';'
		public Group getGroup() { return cGroup; }

		//'check'
		public Keyword getCheckKeyword_0() { return cCheckKeyword_0; }

		//ownedTarget=ExpCS
		public Assignment getOwnedTargetAssignment_1() { return cOwnedTargetAssignment_1; }

		//ExpCS
		public RuleCall getOwnedTargetExpCSParserRuleCall_1_0() { return cOwnedTargetExpCSParserRuleCall_1_0; }

		//(':=' ownedInitExpression=ExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//':='
		public Keyword getColonEqualsSignKeyword_2_0() { return cColonEqualsSignKeyword_2_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2_1() { return cOwnedInitExpressionAssignment_2_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_1_0; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class ControlStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ControlStatementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAddStatementCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cMappingCallCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cMappingLoopCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//ControlStatementCS MappingStatementCS:
		//	AddStatementCS | MappingCallCS | MappingLoopCS
		@Override public ParserRule getRule() { return rule; }

		//AddStatementCS | MappingCallCS | MappingLoopCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//AddStatementCS
		public RuleCall getAddStatementCSParserRuleCall_0() { return cAddStatementCSParserRuleCall_0; }

		//MappingCallCS
		public RuleCall getMappingCallCSParserRuleCall_1() { return cMappingCallCSParserRuleCall_1; }

		//MappingLoopCS
		public RuleCall getMappingLoopCSParserRuleCall_2() { return cMappingLoopCSParserRuleCall_2; }
	}

	public class DirectionCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.DirectionCS");
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
		private final CrossReference cUsesImperativeDomainCrossReference_5_1_0 = (CrossReference)cUsesAssignment_5_1.eContents().get(0);
		private final RuleCall cUsesImperativeDomainUnrestrictedNameParserRuleCall_5_1_0_1 = (RuleCall)cUsesImperativeDomainCrossReference_5_1_0.eContents().get(1);
		private final Group cGroup_5_2 = (Group)cGroup_5.eContents().get(2);
		private final Keyword cCommaKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cUsesAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final CrossReference cUsesImperativeDomainCrossReference_5_2_1_0 = (CrossReference)cUsesAssignment_5_2_1.eContents().get(0);
		private final RuleCall cUsesImperativeDomainUnrestrictedNameParserRuleCall_5_2_1_0_1 = (RuleCall)cUsesImperativeDomainCrossReference_5_2_1_0.eContents().get(1);
		
		//DirectionCS:
		//	{DirectionCS} name=UnrestrictedName? 'imports' imports+=[pivot::Package|UnrestrictedName] (','
		//	imports+=[pivot::Package|UnrestrictedName])* ('uses' uses+=[qvtimperative::ImperativeDomain|UnrestrictedName] (','
		//	uses+=[qvtimperative::ImperativeDomain|UnrestrictedName])*)?;
		@Override public ParserRule getRule() { return rule; }

		//{DirectionCS} name=UnrestrictedName? 'imports' imports+=[pivot::Package|UnrestrictedName] (','
		//imports+=[pivot::Package|UnrestrictedName])* ('uses' uses+=[qvtimperative::ImperativeDomain|UnrestrictedName] (','
		//uses+=[qvtimperative::ImperativeDomain|UnrestrictedName])*)?
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

		//('uses' uses+=[qvtimperative::ImperativeDomain|UnrestrictedName] (','
		//uses+=[qvtimperative::ImperativeDomain|UnrestrictedName])*)?
		public Group getGroup_5() { return cGroup_5; }

		//'uses'
		public Keyword getUsesKeyword_5_0() { return cUsesKeyword_5_0; }

		//uses+=[qvtimperative::ImperativeDomain|UnrestrictedName]
		public Assignment getUsesAssignment_5_1() { return cUsesAssignment_5_1; }

		//[qvtimperative::ImperativeDomain|UnrestrictedName]
		public CrossReference getUsesImperativeDomainCrossReference_5_1_0() { return cUsesImperativeDomainCrossReference_5_1_0; }

		//UnrestrictedName
		public RuleCall getUsesImperativeDomainUnrestrictedNameParserRuleCall_5_1_0_1() { return cUsesImperativeDomainUnrestrictedNameParserRuleCall_5_1_0_1; }

		//(',' uses+=[qvtimperative::ImperativeDomain|UnrestrictedName])*
		public Group getGroup_5_2() { return cGroup_5_2; }

		//','
		public Keyword getCommaKeyword_5_2_0() { return cCommaKeyword_5_2_0; }

		//uses+=[qvtimperative::ImperativeDomain|UnrestrictedName]
		public Assignment getUsesAssignment_5_2_1() { return cUsesAssignment_5_2_1; }

		//[qvtimperative::ImperativeDomain|UnrestrictedName]
		public CrossReference getUsesImperativeDomainCrossReference_5_2_1_0() { return cUsesImperativeDomainCrossReference_5_2_1_0; }

		//UnrestrictedName
		public RuleCall getUsesImperativeDomainUnrestrictedNameParserRuleCall_5_2_1_0_1() { return cUsesImperativeDomainUnrestrictedNameParserRuleCall_5_2_1_0_1; }
	}

	public class GuardPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.GuardPatternCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cGuardPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_2_0_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_0.eContents().get(0);
		private final Assignment cOwnedUnrealizedVariablesAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cOwnedUnrealizedVariablesVariablePredicateCSParserRuleCall_2_1_0 = (RuleCall)cOwnedUnrealizedVariablesAssignment_2_1.eContents().get(0);
		private final Assignment cOwnedPredicatesAssignment_2_2 = (Assignment)cAlternatives_2.eContents().get(2);
		private final RuleCall cOwnedPredicatesPredicateCSParserRuleCall_2_2_0 = (RuleCall)cOwnedPredicatesAssignment_2_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//GuardPatternCS:
		//	{GuardPatternCS} '(' (ownedUnrealizedVariables+=GuardVariableCS | ownedUnrealizedVariables+=VariablePredicateCS |
		//	ownedPredicates+=PredicateCS)* ')';
		@Override public ParserRule getRule() { return rule; }

		//{GuardPatternCS} '(' (ownedUnrealizedVariables+=GuardVariableCS | ownedUnrealizedVariables+=VariablePredicateCS |
		//ownedPredicates+=PredicateCS)* ')'
		public Group getGroup() { return cGroup; }

		//{GuardPatternCS}
		public Action getGuardPatternCSAction_0() { return cGuardPatternCSAction_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(ownedUnrealizedVariables+=GuardVariableCS | ownedUnrealizedVariables+=VariablePredicateCS |
		//ownedPredicates+=PredicateCS)*
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//ownedUnrealizedVariables+=GuardVariableCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_0() { return cOwnedUnrealizedVariablesAssignment_2_0; }

		//GuardVariableCS
		public RuleCall getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_2_0_0() { return cOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_2_0_0; }

		//ownedUnrealizedVariables+=VariablePredicateCS
		public Assignment getOwnedUnrealizedVariablesAssignment_2_1() { return cOwnedUnrealizedVariablesAssignment_2_1; }

		//VariablePredicateCS
		public RuleCall getOwnedUnrealizedVariablesVariablePredicateCSParserRuleCall_2_1_0() { return cOwnedUnrealizedVariablesVariablePredicateCSParserRuleCall_2_1_0; }

		//ownedPredicates+=PredicateCS
		public Assignment getOwnedPredicatesAssignment_2_2() { return cOwnedPredicatesAssignment_2_2; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_2_2_0() { return cOwnedPredicatesPredicateCSParserRuleCall_2_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class GuardVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.GuardVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cInKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Assignment cIsConnectionAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cIsConnectionInoutKeyword_0_1_0 = (Keyword)cIsConnectionAssignment_0_1.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_3_0 = (RuleCall)cOwnedTypeAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		////Variable := VariableName �:� TypeDeclaration
		// GuardVariableCS UnrealizedVariableCS:
		//	('in' | isConnection?='inout') name=UnrestrictedName ':' ownedType=TypeExpCS ';'
		@Override public ParserRule getRule() { return rule; }

		//('in' | isConnection?='inout') name=UnrestrictedName ':' ownedType=TypeExpCS ';'
		public Group getGroup() { return cGroup; }

		//('in' | isConnection?='inout')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'in'
		public Keyword getInKeyword_0_0() { return cInKeyword_0_0; }

		//isConnection?='inout'
		public Assignment getIsConnectionAssignment_0_1() { return cIsConnectionAssignment_0_1; }

		//'inout'
		public Keyword getIsConnectionInoutKeyword_0_1_0() { return cIsConnectionInoutKeyword_0_1_0; }

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

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class ImportCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ImportCS");
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMappingCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cMapKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cInKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedInPathNameAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedInPathNamePathNameCSParserRuleCall_3_1_0 = (RuleCall)cOwnedInPathNameAssignment_3_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedDomainsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final Alternatives cOwnedDomainsAlternatives_5_0 = (Alternatives)cOwnedDomainsAssignment_5.eContents().get(0);
		private final RuleCall cOwnedDomainsSourceDomainCSParserRuleCall_5_0_0 = (RuleCall)cOwnedDomainsAlternatives_5_0.eContents().get(0);
		private final RuleCall cOwnedDomainsTargetDomainCSParserRuleCall_5_0_1 = (RuleCall)cOwnedDomainsAlternatives_5_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cWhereKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cOwnedMiddleAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cOwnedMiddleMiddleDomainCSParserRuleCall_6_1_0 = (RuleCall)cOwnedMiddleAssignment_6_1.eContents().get(0);
		private final Assignment cOwnedStatementsAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedStatementsBottomStatementCSParserRuleCall_7_0 = (RuleCall)cOwnedStatementsAssignment_7.eContents().get(0);
		private final Assignment cOwnedStatementsAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cOwnedStatementsControlStatementCSParserRuleCall_8_0 = (RuleCall)cOwnedStatementsAssignment_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//MappingCS:
		//	{MappingCS} 'map' name=UnrestrictedName ('in' ownedInPathName=PathNameCS)? '{' ownedDomains+=(SourceDomainCS |
		//	TargetDomainCS)* ('where' ownedMiddle=MiddleDomainCS)? ownedStatements+=BottomStatementCS*
		//	ownedStatements+=ControlStatementCS* '}';
		@Override public ParserRule getRule() { return rule; }

		//{MappingCS} 'map' name=UnrestrictedName ('in' ownedInPathName=PathNameCS)? '{' ownedDomains+=(SourceDomainCS |
		//TargetDomainCS)* ('where' ownedMiddle=MiddleDomainCS)? ownedStatements+=BottomStatementCS*
		//ownedStatements+=ControlStatementCS* '}'
		public Group getGroup() { return cGroup; }

		//{MappingCS}
		public Action getMappingCSAction_0() { return cMappingCSAction_0; }

		//'map'
		public Keyword getMapKeyword_1() { return cMapKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//('in' ownedInPathName=PathNameCS)?
		public Group getGroup_3() { return cGroup_3; }

		//'in'
		public Keyword getInKeyword_3_0() { return cInKeyword_3_0; }

		//ownedInPathName=PathNameCS
		public Assignment getOwnedInPathNameAssignment_3_1() { return cOwnedInPathNameAssignment_3_1; }

		//PathNameCS
		public RuleCall getOwnedInPathNamePathNameCSParserRuleCall_3_1_0() { return cOwnedInPathNamePathNameCSParserRuleCall_3_1_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//ownedDomains+=(SourceDomainCS | TargetDomainCS)*
		public Assignment getOwnedDomainsAssignment_5() { return cOwnedDomainsAssignment_5; }

		//(SourceDomainCS | TargetDomainCS)
		public Alternatives getOwnedDomainsAlternatives_5_0() { return cOwnedDomainsAlternatives_5_0; }

		//SourceDomainCS
		public RuleCall getOwnedDomainsSourceDomainCSParserRuleCall_5_0_0() { return cOwnedDomainsSourceDomainCSParserRuleCall_5_0_0; }

		//TargetDomainCS
		public RuleCall getOwnedDomainsTargetDomainCSParserRuleCall_5_0_1() { return cOwnedDomainsTargetDomainCSParserRuleCall_5_0_1; }

		//('where' ownedMiddle=MiddleDomainCS)?
		public Group getGroup_6() { return cGroup_6; }

		//'where'
		public Keyword getWhereKeyword_6_0() { return cWhereKeyword_6_0; }

		//ownedMiddle=MiddleDomainCS
		public Assignment getOwnedMiddleAssignment_6_1() { return cOwnedMiddleAssignment_6_1; }

		//MiddleDomainCS
		public RuleCall getOwnedMiddleMiddleDomainCSParserRuleCall_6_1_0() { return cOwnedMiddleMiddleDomainCSParserRuleCall_6_1_0; }

		//ownedStatements+=BottomStatementCS*
		public Assignment getOwnedStatementsAssignment_7() { return cOwnedStatementsAssignment_7; }

		//BottomStatementCS
		public RuleCall getOwnedStatementsBottomStatementCSParserRuleCall_7_0() { return cOwnedStatementsBottomStatementCSParserRuleCall_7_0; }

		//ownedStatements+=ControlStatementCS*
		public Assignment getOwnedStatementsAssignment_8() { return cOwnedStatementsAssignment_8; }

		//ControlStatementCS
		public RuleCall getOwnedStatementsControlStatementCSParserRuleCall_8_0() { return cOwnedStatementsControlStatementCSParserRuleCall_8_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}

	public class MappingCallCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingCallCS");
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
		//	{MappingCallCS} isInfinite?='infinite'? 'call' ownedPathName=PathNameCS '{' ownedBindings+=MappingCallBindingCS* '}';
		@Override public ParserRule getRule() { return rule; }

		//{MappingCallCS} isInfinite?='infinite'? 'call' ownedPathName=PathNameCS '{' ownedBindings+=MappingCallBindingCS* '}'
		public Group getGroup() { return cGroup; }

		//{MappingCallCS}
		public Action getMappingCallCSAction_0() { return cMappingCallCSAction_0; }

		//isInfinite?='infinite'?
		public Assignment getIsInfiniteAssignment_1() { return cIsInfiniteAssignment_1; }

		//'infinite'
		public Keyword getIsInfiniteInfiniteKeyword_1_0() { return cIsInfiniteInfiniteKeyword_1_0; }

		//'call'
		public Keyword getCallKeyword_2() { return cCallKeyword_2; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_3() { return cOwnedPathNameAssignment_3; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_3_0() { return cOwnedPathNamePathNameCSParserRuleCall_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//ownedBindings+=MappingCallBindingCS*
		public Assignment getOwnedBindingsAssignment_5() { return cOwnedBindingsAssignment_5; }

		//MappingCallBindingCS
		public RuleCall getOwnedBindingsMappingCallBindingCSParserRuleCall_5_0() { return cOwnedBindingsMappingCallBindingCSParserRuleCall_5_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class MappingCallBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingCallBindingCS");
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
		//	referredVariable=[pivot::Variable|UnrestrictedName] (':=' | isPolled?='?=') ownedValue=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//referredVariable=[pivot::Variable|UnrestrictedName] (':=' | isPolled?='?=') ownedValue=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//referredVariable=[pivot::Variable|UnrestrictedName]
		public Assignment getReferredVariableAssignment_0() { return cReferredVariableAssignment_0; }

		//[pivot::Variable|UnrestrictedName]
		public CrossReference getReferredVariableVariableCrossReference_0_0() { return cReferredVariableVariableCrossReference_0_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableVariableUnrestrictedNameParserRuleCall_0_0_1() { return cReferredVariableVariableUnrestrictedNameParserRuleCall_0_0_1; }

		//(':=' | isPolled?='?=')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//':='
		public Keyword getColonEqualsSignKeyword_1_0() { return cColonEqualsSignKeyword_1_0; }

		//isPolled?='?='
		public Assignment getIsPolledAssignment_1_1() { return cIsPolledAssignment_1_1; }

		//'?='
		public Keyword getIsPolledQuestionMarkEqualsSignKeyword_1_1_0() { return cIsPolledQuestionMarkEqualsSignKeyword_1_1_0; }

		//ownedValue=ExpCS
		public Assignment getOwnedValueAssignment_2() { return cOwnedValueAssignment_2; }

		//ExpCS
		public RuleCall getOwnedValueExpCSParserRuleCall_2_0() { return cOwnedValueExpCSParserRuleCall_2_0; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class MappingLoopCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingLoopCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cForKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedIteratorAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedIteratorMappingIteratorCSParserRuleCall_1_0 = (RuleCall)cOwnedIteratorAssignment_1.eContents().get(0);
		private final Keyword cInKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedInExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedInExpressionExpCSParserRuleCall_3_0 = (RuleCall)cOwnedInExpressionAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedMappingStatementsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedMappingStatementsControlStatementCSParserRuleCall_5_0 = (RuleCall)cOwnedMappingStatementsAssignment_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//MappingLoopCS:
		//	'for' ownedIterator=MappingIteratorCS 'in' ownedInExpression=ExpCS '{' ownedMappingStatements+=ControlStatementCS+
		//	'}';
		@Override public ParserRule getRule() { return rule; }

		//'for' ownedIterator=MappingIteratorCS 'in' ownedInExpression=ExpCS '{' ownedMappingStatements+=ControlStatementCS+ '}'
		public Group getGroup() { return cGroup; }

		//'for'
		public Keyword getForKeyword_0() { return cForKeyword_0; }

		//ownedIterator=MappingIteratorCS
		public Assignment getOwnedIteratorAssignment_1() { return cOwnedIteratorAssignment_1; }

		//MappingIteratorCS
		public RuleCall getOwnedIteratorMappingIteratorCSParserRuleCall_1_0() { return cOwnedIteratorMappingIteratorCSParserRuleCall_1_0; }

		//'in'
		public Keyword getInKeyword_2() { return cInKeyword_2; }

		//ownedInExpression=ExpCS
		public Assignment getOwnedInExpressionAssignment_3() { return cOwnedInExpressionAssignment_3; }

		//ExpCS
		public RuleCall getOwnedInExpressionExpCSParserRuleCall_3_0() { return cOwnedInExpressionExpCSParserRuleCall_3_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//ownedMappingStatements+=ControlStatementCS+
		public Assignment getOwnedMappingStatementsAssignment_5() { return cOwnedMappingStatementsAssignment_5; }

		//ControlStatementCS
		public RuleCall getOwnedMappingStatementsControlStatementCSParserRuleCall_5_0() { return cOwnedMappingStatementsControlStatementCSParserRuleCall_5_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class MappingIteratorCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingIteratorCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTypeAssignment_1_1.eContents().get(0);
		
		//MappingIteratorCS essentialocl::VariableCS:
		//	name=UnrestrictedName (':' ownedType=TypeExpCS)?
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName (':' ownedType=TypeExpCS)?
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
	}

	public class MiddleDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MiddleDomainCS");
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
		private final RuleCall cOwnedGuardPatternGuardPatternCSParserRuleCall_1_0 = (RuleCall)cOwnedGuardPatternAssignment_1.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedBottomPatternBottomPatternCSParserRuleCall_2_0 = (RuleCall)cOwnedBottomPatternAssignment_2.eContents().get(0);
		
		//MiddleDomainCS DomainCS:
		//	('{' ('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)? ('enforce'
		//	enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)? '}')? ownedGuardPattern=GuardPatternCS
		//	ownedBottomPattern=BottomPatternCS
		@Override public ParserRule getRule() { return rule; }

		//('{' ('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)? ('enforce'
		//enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)? '}')? ownedGuardPattern=GuardPatternCS
		//ownedBottomPattern=BottomPatternCS
		public Group getGroup() { return cGroup; }

		//('{' ('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)? ('enforce'
		//enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)? '}')?
		public Group getGroup_0() { return cGroup_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_0_0() { return cLeftCurlyBracketKeyword_0_0; }

		//('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//'check'
		public Keyword getCheckKeyword_0_1_0() { return cCheckKeyword_0_1_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_0_1_1() { return cCheckedPropertiesAssignment_0_1_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_0_1_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_0_1_1_0; }

		//(',' checkedProperties+=PathNameCS)*
		public Group getGroup_0_1_2() { return cGroup_0_1_2; }

		//','
		public Keyword getCommaKeyword_0_1_2_0() { return cCommaKeyword_0_1_2_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_0_1_2_1() { return cCheckedPropertiesAssignment_0_1_2_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_0_1_2_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_0_1_2_1_0; }

		//('enforce' enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)?
		public Group getGroup_0_2() { return cGroup_0_2; }

		//'enforce'
		public Keyword getEnforceKeyword_0_2_0() { return cEnforceKeyword_0_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_0_2_1() { return cEnforcedPropertiesAssignment_0_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_0_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_0_2_1_0; }

		//(',' enforcedProperties+=PathNameCS)*
		public Group getGroup_0_2_2() { return cGroup_0_2_2; }

		//','
		public Keyword getCommaKeyword_0_2_2_0() { return cCommaKeyword_0_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_0_2_2_1() { return cEnforcedPropertiesAssignment_0_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_0_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_0_2_2_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_0_3() { return cRightCurlyBracketKeyword_0_3; }

		//ownedGuardPattern=GuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_1() { return cOwnedGuardPatternAssignment_1; }

		//GuardPatternCS
		public RuleCall getOwnedGuardPatternGuardPatternCSParserRuleCall_1_0() { return cOwnedGuardPatternGuardPatternCSParserRuleCall_1_0; }

		//ownedBottomPattern=BottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_2() { return cOwnedBottomPatternAssignment_2; }

		//BottomPatternCS
		public RuleCall getOwnedBottomPatternBottomPatternCSParserRuleCall_2_0() { return cOwnedBottomPatternBottomPatternCSParserRuleCall_2_0; }
	}

	public class NamedDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.NamedDomainCS");
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.QualifiedPackageCS");
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ParamDeclarationCS");
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.PredicateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCheckKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedConditionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedConditionExpCSParserRuleCall_1_0 = (RuleCall)cOwnedConditionAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//PredicateCS:
		//	'check' ownedCondition=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'check' ownedCondition=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//'check'
		public Keyword getCheckKeyword_0() { return cCheckKeyword_0; }

		//ownedCondition=ExpCS
		public Assignment getOwnedConditionAssignment_1() { return cOwnedConditionAssignment_1; }

		//ExpCS
		public RuleCall getOwnedConditionExpCSParserRuleCall_1_0() { return cOwnedConditionExpCSParserRuleCall_1_0; }

		//';'
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}

	public class QueryCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.QueryCS");
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

	public class NewStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.NewStatementCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNewKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReferredTypedModelAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cReferredTypedModelTypedModelCrossReference_2_0 = (CrossReference)cReferredTypedModelAssignment_2.eContents().get(0);
		private final RuleCall cReferredTypedModelTypedModelUnrestrictedNameParserRuleCall_2_0_1 = (RuleCall)cReferredTypedModelTypedModelCrossReference_2_0.eContents().get(1);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedTypeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_5_0 = (RuleCall)cOwnedTypeAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cColonEqualsSignKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_6_1_0 = (RuleCall)cOwnedInitExpressionAssignment_6_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//NewStatementCS:
		//	'new' ':' referredTypedModel=[qvtbase::TypedModel|UnrestrictedName] name=UnrestrictedName ':' ownedType=TypeExpCS
		//	(':=' ownedInitExpression=ExpCS)? ';';
		@Override public ParserRule getRule() { return rule; }

		//'new' ':' referredTypedModel=[qvtbase::TypedModel|UnrestrictedName] name=UnrestrictedName ':' ownedType=TypeExpCS (':='
		//ownedInitExpression=ExpCS)? ';'
		public Group getGroup() { return cGroup; }

		//'new'
		public Keyword getNewKeyword_0() { return cNewKeyword_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//referredTypedModel=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getReferredTypedModelAssignment_2() { return cReferredTypedModelAssignment_2; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getReferredTypedModelTypedModelCrossReference_2_0() { return cReferredTypedModelTypedModelCrossReference_2_0; }

		//UnrestrictedName
		public RuleCall getReferredTypedModelTypedModelUnrestrictedNameParserRuleCall_2_0_1() { return cReferredTypedModelTypedModelUnrestrictedNameParserRuleCall_2_0_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

		//':'
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_5() { return cOwnedTypeAssignment_5; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_5_0() { return cOwnedTypeTypeExpCSParserRuleCall_5_0; }

		//(':=' ownedInitExpression=ExpCS)?
		public Group getGroup_6() { return cGroup_6; }

		//':='
		public Keyword getColonEqualsSignKeyword_6_0() { return cColonEqualsSignKeyword_6_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_6_1() { return cOwnedInitExpressionAssignment_6_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_6_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_6_1_0; }

		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}

	public class ScopeNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ScopeNameCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedPathElementsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedPathElementsFirstPathElementCSParserRuleCall_0_0 = (RuleCall)cOwnedPathElementsAssignment_0.eContents().get(0);
		private final Keyword cColonColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedPathElementsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0 = (RuleCall)cOwnedPathElementsAssignment_2_0.eContents().get(0);
		private final Keyword cColonColonKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		
		//ScopeNameCS base::PathNameCS:
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

	public class SetStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.SetStatementCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cReferredVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cReferredVariableVariableCrossReference_1_0 = (CrossReference)cReferredVariableAssignment_1.eContents().get(0);
		private final RuleCall cReferredVariableVariableUnrestrictedNameParserRuleCall_1_0_1 = (RuleCall)cReferredVariableVariableCrossReference_1_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cReferredPropertyAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cReferredPropertyPropertyCrossReference_3_0 = (CrossReference)cReferredPropertyAssignment_3.eContents().get(0);
		private final RuleCall cReferredPropertyPropertyUnrestrictedNameParserRuleCall_3_0_1 = (RuleCall)cReferredPropertyPropertyCrossReference_3_0.eContents().get(1);
		private final Keyword cColonEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedInitExpressionAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_5_0 = (RuleCall)cOwnedInitExpressionAssignment_5.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//SetStatementCS:
		//	'set' referredVariable=[pivot::Variable|UnrestrictedName] '.' referredProperty=[pivot::Property|UnrestrictedName]
		//	':=' ownedInitExpression=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'set' referredVariable=[pivot::Variable|UnrestrictedName] '.' referredProperty=[pivot::Property|UnrestrictedName] ':='
		//ownedInitExpression=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//'set'
		public Keyword getSetKeyword_0() { return cSetKeyword_0; }

		//referredVariable=[pivot::Variable|UnrestrictedName]
		public Assignment getReferredVariableAssignment_1() { return cReferredVariableAssignment_1; }

		//[pivot::Variable|UnrestrictedName]
		public CrossReference getReferredVariableVariableCrossReference_1_0() { return cReferredVariableVariableCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableVariableUnrestrictedNameParserRuleCall_1_0_1() { return cReferredVariableVariableUnrestrictedNameParserRuleCall_1_0_1; }

		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//referredProperty=[pivot::Property|UnrestrictedName]
		public Assignment getReferredPropertyAssignment_3() { return cReferredPropertyAssignment_3; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getReferredPropertyPropertyCrossReference_3_0() { return cReferredPropertyPropertyCrossReference_3_0; }

		//UnrestrictedName
		public RuleCall getReferredPropertyPropertyUnrestrictedNameParserRuleCall_3_0_1() { return cReferredPropertyPropertyUnrestrictedNameParserRuleCall_3_0_1; }

		//':='
		public Keyword getColonEqualsSignKeyword_4() { return cColonEqualsSignKeyword_4; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_5() { return cOwnedInitExpressionAssignment_5; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_5_0() { return cOwnedInitExpressionExpCSParserRuleCall_5_0; }

		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}

	public class SourceDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.SourceDomainCS");
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
		private final RuleCall cOwnedGuardPatternGuardPatternCSParserRuleCall_3_0 = (RuleCall)cOwnedGuardPatternAssignment_3.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedBottomPatternBottomPatternCSParserRuleCall_4_0 = (RuleCall)cOwnedBottomPatternAssignment_4.eContents().get(0);
		
		//SourceDomainCS DomainCS:
		//	isCheck?='check' direction=[qvtbase::TypedModel|UnrestrictedName] ('{' ('check' checkedProperties+=PathNameCS (','
		//	checkedProperties+=PathNameCS)*)? ('enforce' enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)?
		//	'}')? ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		@Override public ParserRule getRule() { return rule; }

		//isCheck?='check' direction=[qvtbase::TypedModel|UnrestrictedName] ('{' ('check' checkedProperties+=PathNameCS (','
		//checkedProperties+=PathNameCS)*)? ('enforce' enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)?
		//'}')? ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		public Group getGroup() { return cGroup; }

		//isCheck?='check'
		public Assignment getIsCheckAssignment_0() { return cIsCheckAssignment_0; }

		//'check'
		public Keyword getIsCheckCheckKeyword_0_0() { return cIsCheckCheckKeyword_0_0; }

		//direction=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getDirectionAssignment_1() { return cDirectionAssignment_1; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getDirectionTypedModelCrossReference_1_0() { return cDirectionTypedModelCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1() { return cDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1; }

		//('{' ('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)? ('enforce'
		//enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)? '}')?
		public Group getGroup_2() { return cGroup_2; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//'check'
		public Keyword getCheckKeyword_2_1_0() { return cCheckKeyword_2_1_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_1() { return cCheckedPropertiesAssignment_2_1_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0; }

		//(',' checkedProperties+=PathNameCS)*
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//','
		public Keyword getCommaKeyword_2_1_2_0() { return cCommaKeyword_2_1_2_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_2_1() { return cCheckedPropertiesAssignment_2_1_2_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0; }

		//('enforce' enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)?
		public Group getGroup_2_2() { return cGroup_2_2; }

		//'enforce'
		public Keyword getEnforceKeyword_2_2_0() { return cEnforceKeyword_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_1() { return cEnforcedPropertiesAssignment_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0; }

		//(',' enforcedProperties+=PathNameCS)*
		public Group getGroup_2_2_2() { return cGroup_2_2_2; }

		//','
		public Keyword getCommaKeyword_2_2_2_0() { return cCommaKeyword_2_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_2_1() { return cEnforcedPropertiesAssignment_2_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_3() { return cRightCurlyBracketKeyword_2_3; }

		//ownedGuardPattern=GuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_3() { return cOwnedGuardPatternAssignment_3; }

		//GuardPatternCS
		public RuleCall getOwnedGuardPatternGuardPatternCSParserRuleCall_3_0() { return cOwnedGuardPatternGuardPatternCSParserRuleCall_3_0; }

		//ownedBottomPattern=BottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_4() { return cOwnedBottomPatternAssignment_4; }

		//BottomPatternCS
		public RuleCall getOwnedBottomPatternBottomPatternCSParserRuleCall_4_0() { return cOwnedBottomPatternBottomPatternCSParserRuleCall_4_0; }
	}

	public class StatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.StatementCS");
		private final RuleCall cControlStatementCSParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//StatementCS:
		//	ControlStatementCS;
		@Override public ParserRule getRule() { return rule; }

		//ControlStatementCS
		public RuleCall getControlStatementCSParserRuleCall() { return cControlStatementCSParserRuleCall; }
	}

	public class TransformationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.TransformationCS");
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

	public class TargetDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.TargetDomainCS");
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
		private final RuleCall cOwnedGuardPatternGuardPatternCSParserRuleCall_3_0 = (RuleCall)cOwnedGuardPatternAssignment_3.eContents().get(0);
		private final Assignment cOwnedBottomPatternAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedBottomPatternBottomPatternCSParserRuleCall_4_0 = (RuleCall)cOwnedBottomPatternAssignment_4.eContents().get(0);
		
		//TargetDomainCS DomainCS:
		//	isEnforce?='enforce' direction=[qvtbase::TypedModel|UnrestrictedName] ('{' ('check' checkedProperties+=PathNameCS
		//	(',' checkedProperties+=PathNameCS)*)? ('enforce' enforcedProperties+=PathNameCS (','
		//	enforcedProperties+=PathNameCS)*)? '}')? ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		@Override public ParserRule getRule() { return rule; }

		//isEnforce?='enforce' direction=[qvtbase::TypedModel|UnrestrictedName] ('{' ('check' checkedProperties+=PathNameCS (','
		//checkedProperties+=PathNameCS)*)? ('enforce' enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)?
		//'}')? ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
		public Group getGroup() { return cGroup; }

		//isEnforce?='enforce'
		public Assignment getIsEnforceAssignment_0() { return cIsEnforceAssignment_0; }

		//'enforce'
		public Keyword getIsEnforceEnforceKeyword_0_0() { return cIsEnforceEnforceKeyword_0_0; }

		//direction=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getDirectionAssignment_1() { return cDirectionAssignment_1; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getDirectionTypedModelCrossReference_1_0() { return cDirectionTypedModelCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1() { return cDirectionTypedModelUnrestrictedNameParserRuleCall_1_0_1; }

		//('{' ('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)? ('enforce'
		//enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)? '}')?
		public Group getGroup_2() { return cGroup_2; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_0() { return cLeftCurlyBracketKeyword_2_0; }

		//('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//'check'
		public Keyword getCheckKeyword_2_1_0() { return cCheckKeyword_2_1_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_1() { return cCheckedPropertiesAssignment_2_1_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0; }

		//(',' checkedProperties+=PathNameCS)*
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//','
		public Keyword getCommaKeyword_2_1_2_0() { return cCommaKeyword_2_1_2_0; }

		//checkedProperties+=PathNameCS
		public Assignment getCheckedPropertiesAssignment_2_1_2_1() { return cCheckedPropertiesAssignment_2_1_2_1; }

		//PathNameCS
		public RuleCall getCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0() { return cCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0; }

		//('enforce' enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)?
		public Group getGroup_2_2() { return cGroup_2_2; }

		//'enforce'
		public Keyword getEnforceKeyword_2_2_0() { return cEnforceKeyword_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_1() { return cEnforcedPropertiesAssignment_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0; }

		//(',' enforcedProperties+=PathNameCS)*
		public Group getGroup_2_2_2() { return cGroup_2_2_2; }

		//','
		public Keyword getCommaKeyword_2_2_2_0() { return cCommaKeyword_2_2_2_0; }

		//enforcedProperties+=PathNameCS
		public Assignment getEnforcedPropertiesAssignment_2_2_2_1() { return cEnforcedPropertiesAssignment_2_2_2_1; }

		//PathNameCS
		public RuleCall getEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0() { return cEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_3() { return cRightCurlyBracketKeyword_2_3; }

		//ownedGuardPattern=GuardPatternCS
		public Assignment getOwnedGuardPatternAssignment_3() { return cOwnedGuardPatternAssignment_3; }

		//GuardPatternCS
		public RuleCall getOwnedGuardPatternGuardPatternCSParserRuleCall_3_0() { return cOwnedGuardPatternGuardPatternCSParserRuleCall_3_0; }

		//ownedBottomPattern=BottomPatternCS
		public Assignment getOwnedBottomPatternAssignment_4() { return cOwnedBottomPatternAssignment_4; }

		//BottomPatternCS
		public RuleCall getOwnedBottomPatternBottomPatternCSParserRuleCall_4_0() { return cOwnedBottomPatternBottomPatternCSParserRuleCall_4_0; }
	}

	public class UnnamedDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnnamedDomainCS");
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

	public class UnrealizedVariableCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrealizedVariableCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cVarKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Assignment cIsConnectionAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cIsConnectionOutKeyword_0_1_0 = (Keyword)cIsConnectionAssignment_0_1.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedTypeAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonEqualsSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_3_1_0 = (RuleCall)cOwnedInitExpressionAssignment_3_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//UnrealizedVariableCS:
		//	('var' | isConnection?='out') name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)? ';';
		@Override public ParserRule getRule() { return rule; }

		//('var' | isConnection?='out') name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)? ';'
		public Group getGroup() { return cGroup; }

		//('var' | isConnection?='out')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'var'
		public Keyword getVarKeyword_0_0() { return cVarKeyword_0_0; }

		//isConnection?='out'
		public Assignment getIsConnectionAssignment_0_1() { return cIsConnectionAssignment_0_1; }

		//'out'
		public Keyword getIsConnectionOutKeyword_0_1_0() { return cIsConnectionOutKeyword_0_1_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2_1() { return cOwnedTypeAssignment_2_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_1_0; }

		//(':=' ownedInitExpression=ExpCS)?
		public Group getGroup_3() { return cGroup_3; }

		//':='
		public Keyword getColonEqualsSignKeyword_3_0() { return cColonEqualsSignKeyword_3_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_3_1() { return cOwnedInitExpressionAssignment_3_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_3_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_3_1_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class VariablePredicateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.VariablePredicateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInvarKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_2_1_0 = (RuleCall)cOwnedTypeAssignment_2_1.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedInitExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_4_0 = (RuleCall)cOwnedInitExpressionAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//VariablePredicateCS UnrealizedVariableCS:
		//	'invar' name=UnrestrictedName (':' ownedType=TypeExpCS)? ':=' ownedInitExpression=ExpCS ';'
		@Override public ParserRule getRule() { return rule; }

		//'invar' name=UnrestrictedName (':' ownedType=TypeExpCS)? ':=' ownedInitExpression=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//'invar'
		public Keyword getInvarKeyword_0() { return cInvarKeyword_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0() { return cNameUnrestrictedNameParserRuleCall_1_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_2_1() { return cOwnedTypeAssignment_2_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_2_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_2_1_0; }

		//':='
		public Keyword getColonEqualsSignKeyword_3() { return cColonEqualsSignKeyword_3; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_4() { return cOwnedInitExpressionAssignment_4; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_4_0() { return cOwnedInitExpressionExpCSParserRuleCall_4_0; }

		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
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
		
		//UnrestrictedName:
		//	EssentialOCLUnrestrictedName | 'check' | 'enforce' | 'import' | 'imports' //|	'include'
		// | 'library' | 'map' |
		//	'query' | 'realize' | 'refines' | 'transformation' | 'uses' //|	'where'
		//;
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName | 'check' | 'enforce' | 'import' | 'imports' //|	'include'
		// | 'library' | 'map' | 'query' |
		//'realize' | 'refines' | 'transformation' | 'uses'
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall_0() { return cEssentialOCLUnrestrictedNameParserRuleCall_0; }

		//'check'
		public Keyword getCheckKeyword_1() { return cCheckKeyword_1; }

		//'enforce'
		public Keyword getEnforceKeyword_2() { return cEnforceKeyword_2; }

		//'import'
		public Keyword getImportKeyword_3() { return cImportKeyword_3; }

		//'imports'
		public Keyword getImportsKeyword_4() { return cImportsKeyword_4; }

		//'library'
		public Keyword getLibraryKeyword_5() { return cLibraryKeyword_5; }

		//'map'
		public Keyword getMapKeyword_6() { return cMapKeyword_6; }

		//'query'
		public Keyword getQueryKeyword_7() { return cQueryKeyword_7; }

		//'realize'
		public Keyword getRealizeKeyword_8() { return cRealizeKeyword_8; }

		//'refines'
		public Keyword getRefinesKeyword_9() { return cRefinesKeyword_9; }

		//'transformation'
		public Keyword getTransformationKeyword_10() { return cTransformationKeyword_10; }

		//'uses'
		public Keyword getUsesKeyword_11() { return cUsesKeyword_11; }
	}
	
	
	private final TopLevelCSElements pTopLevelCS;
	private final AddStatementCSElements pAddStatementCS;
	private final BottomPatternCSElements pBottomPatternCS;
	private final BottomStatementCSElements pBottomStatementCS;
	private final ConstraintCSElements pConstraintCS;
	private final ControlStatementCSElements pControlStatementCS;
	private final DirectionCSElements pDirectionCS;
	private final GuardPatternCSElements pGuardPatternCS;
	private final GuardVariableCSElements pGuardVariableCS;
	private final ImportCSElements pImportCS;
	private final MappingCSElements pMappingCS;
	private final MappingCallCSElements pMappingCallCS;
	private final MappingCallBindingCSElements pMappingCallBindingCS;
	private final MappingLoopCSElements pMappingLoopCS;
	private final MappingIteratorCSElements pMappingIteratorCS;
	private final MiddleDomainCSElements pMiddleDomainCS;
	private final NamedDomainCSElements pNamedDomainCS;
	private final QualifiedPackageCSElements pQualifiedPackageCS;
	private final ParamDeclarationCSElements pParamDeclarationCS;
	private final PredicateCSElements pPredicateCS;
	private final QueryCSElements pQueryCS;
	private final NewStatementCSElements pNewStatementCS;
	private final ScopeNameCSElements pScopeNameCS;
	private final SetStatementCSElements pSetStatementCS;
	private final SourceDomainCSElements pSourceDomainCS;
	private final StatementCSElements pStatementCS;
	private final TransformationCSElements pTransformationCS;
	private final TargetDomainCSElements pTargetDomainCS;
	private final UnnamedDomainCSElements pUnnamedDomainCS;
	private final UnrealizedVariableCSElements pUnrealizedVariableCS;
	private final VariablePredicateCSElements pVariablePredicateCS;
	private final UnrestrictedNameElements pUnrestrictedName;
	
	private final Grammar grammar;

	private final QVTbaseGrammarAccess gaQVTbase;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	private final BaseGrammarAccess gaBase;

	@Inject
	public QVTimperativeGrammarAccess(GrammarProvider grammarProvider,
		QVTbaseGrammarAccess gaQVTbase,
		EssentialOCLGrammarAccess gaEssentialOCL,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaQVTbase = gaQVTbase;
		this.gaEssentialOCL = gaEssentialOCL;
		this.gaBase = gaBase;
		this.pTopLevelCS = new TopLevelCSElements();
		this.pAddStatementCS = new AddStatementCSElements();
		this.pBottomPatternCS = new BottomPatternCSElements();
		this.pBottomStatementCS = new BottomStatementCSElements();
		this.pConstraintCS = new ConstraintCSElements();
		this.pControlStatementCS = new ControlStatementCSElements();
		this.pDirectionCS = new DirectionCSElements();
		this.pGuardPatternCS = new GuardPatternCSElements();
		this.pGuardVariableCS = new GuardVariableCSElements();
		this.pImportCS = new ImportCSElements();
		this.pMappingCS = new MappingCSElements();
		this.pMappingCallCS = new MappingCallCSElements();
		this.pMappingCallBindingCS = new MappingCallBindingCSElements();
		this.pMappingLoopCS = new MappingLoopCSElements();
		this.pMappingIteratorCS = new MappingIteratorCSElements();
		this.pMiddleDomainCS = new MiddleDomainCSElements();
		this.pNamedDomainCS = new NamedDomainCSElements();
		this.pQualifiedPackageCS = new QualifiedPackageCSElements();
		this.pParamDeclarationCS = new ParamDeclarationCSElements();
		this.pPredicateCS = new PredicateCSElements();
		this.pQueryCS = new QueryCSElements();
		this.pNewStatementCS = new NewStatementCSElements();
		this.pScopeNameCS = new ScopeNameCSElements();
		this.pSetStatementCS = new SetStatementCSElements();
		this.pSourceDomainCS = new SourceDomainCSElements();
		this.pStatementCS = new StatementCSElements();
		this.pTransformationCS = new TransformationCSElements();
		this.pTargetDomainCS = new TargetDomainCSElements();
		this.pUnnamedDomainCS = new UnnamedDomainCSElements();
		this.pUnrealizedVariableCS = new UnrealizedVariableCSElements();
		this.pVariablePredicateCS = new VariablePredicateCSElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
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

	//AddStatementCS:
	//	'add' targetVariable=[pivot::Variable|UnrestrictedName] '+=' ownedExpression=ExpCS ';';
	public AddStatementCSElements getAddStatementCSAccess() {
		return pAddStatementCS;
	}
	
	public ParserRule getAddStatementCSRule() {
		return getAddStatementCSAccess().getRule();
	}

	//BottomPatternCS:
	//	{BottomPatternCS} '{' (ownedUnrealizedVariables+=UnrealizedVariableCS | ownedConstraints+=ConstraintCS)* '}';
	public BottomPatternCSElements getBottomPatternCSAccess() {
		return pBottomPatternCS;
	}
	
	public ParserRule getBottomPatternCSRule() {
		return getBottomPatternCSAccess().getRule();
	}

	//BottomStatementCS StatementCS:
	//	NewStatementCS | SetStatementCS
	public BottomStatementCSElements getBottomStatementCSAccess() {
		return pBottomStatementCS;
	}
	
	public ParserRule getBottomStatementCSRule() {
		return getBottomStatementCSAccess().getRule();
	}

	//ConstraintCS PredicateOrAssignmentCS:
	//	'check' ownedTarget=ExpCS (':=' ownedInitExpression=ExpCS)? ';'
	public ConstraintCSElements getConstraintCSAccess() {
		return pConstraintCS;
	}
	
	public ParserRule getConstraintCSRule() {
		return getConstraintCSAccess().getRule();
	}

	//ControlStatementCS MappingStatementCS:
	//	AddStatementCS | MappingCallCS | MappingLoopCS
	public ControlStatementCSElements getControlStatementCSAccess() {
		return pControlStatementCS;
	}
	
	public ParserRule getControlStatementCSRule() {
		return getControlStatementCSAccess().getRule();
	}

	//DirectionCS:
	//	{DirectionCS} name=UnrestrictedName? 'imports' imports+=[pivot::Package|UnrestrictedName] (','
	//	imports+=[pivot::Package|UnrestrictedName])* ('uses' uses+=[qvtimperative::ImperativeDomain|UnrestrictedName] (','
	//	uses+=[qvtimperative::ImperativeDomain|UnrestrictedName])*)?;
	public DirectionCSElements getDirectionCSAccess() {
		return pDirectionCS;
	}
	
	public ParserRule getDirectionCSRule() {
		return getDirectionCSAccess().getRule();
	}

	//GuardPatternCS:
	//	{GuardPatternCS} '(' (ownedUnrealizedVariables+=GuardVariableCS | ownedUnrealizedVariables+=VariablePredicateCS |
	//	ownedPredicates+=PredicateCS)* ')';
	public GuardPatternCSElements getGuardPatternCSAccess() {
		return pGuardPatternCS;
	}
	
	public ParserRule getGuardPatternCSRule() {
		return getGuardPatternCSAccess().getRule();
	}

	////Variable := VariableName �:� TypeDeclaration
	// GuardVariableCS UnrealizedVariableCS:
	//	('in' | isConnection?='inout') name=UnrestrictedName ':' ownedType=TypeExpCS ';'
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
	//	{MappingCS} 'map' name=UnrestrictedName ('in' ownedInPathName=PathNameCS)? '{' ownedDomains+=(SourceDomainCS |
	//	TargetDomainCS)* ('where' ownedMiddle=MiddleDomainCS)? ownedStatements+=BottomStatementCS*
	//	ownedStatements+=ControlStatementCS* '}';
	public MappingCSElements getMappingCSAccess() {
		return pMappingCS;
	}
	
	public ParserRule getMappingCSRule() {
		return getMappingCSAccess().getRule();
	}

	//MappingCallCS:
	//	{MappingCallCS} isInfinite?='infinite'? 'call' ownedPathName=PathNameCS '{' ownedBindings+=MappingCallBindingCS* '}';
	public MappingCallCSElements getMappingCallCSAccess() {
		return pMappingCallCS;
	}
	
	public ParserRule getMappingCallCSRule() {
		return getMappingCallCSAccess().getRule();
	}

	//MappingCallBindingCS:
	//	referredVariable=[pivot::Variable|UnrestrictedName] (':=' | isPolled?='?=') ownedValue=ExpCS ';';
	public MappingCallBindingCSElements getMappingCallBindingCSAccess() {
		return pMappingCallBindingCS;
	}
	
	public ParserRule getMappingCallBindingCSRule() {
		return getMappingCallBindingCSAccess().getRule();
	}

	//MappingLoopCS:
	//	'for' ownedIterator=MappingIteratorCS 'in' ownedInExpression=ExpCS '{' ownedMappingStatements+=ControlStatementCS+
	//	'}';
	public MappingLoopCSElements getMappingLoopCSAccess() {
		return pMappingLoopCS;
	}
	
	public ParserRule getMappingLoopCSRule() {
		return getMappingLoopCSAccess().getRule();
	}

	//MappingIteratorCS essentialocl::VariableCS:
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)?
	public MappingIteratorCSElements getMappingIteratorCSAccess() {
		return pMappingIteratorCS;
	}
	
	public ParserRule getMappingIteratorCSRule() {
		return getMappingIteratorCSAccess().getRule();
	}

	//MiddleDomainCS DomainCS:
	//	('{' ('check' checkedProperties+=PathNameCS (',' checkedProperties+=PathNameCS)*)? ('enforce'
	//	enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)? '}')? ownedGuardPattern=GuardPatternCS
	//	ownedBottomPattern=BottomPatternCS
	public MiddleDomainCSElements getMiddleDomainCSAccess() {
		return pMiddleDomainCS;
	}
	
	public ParserRule getMiddleDomainCSRule() {
		return getMiddleDomainCSAccess().getRule();
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
	//	'check' ownedCondition=ExpCS ';';
	public PredicateCSElements getPredicateCSAccess() {
		return pPredicateCS;
	}
	
	public ParserRule getPredicateCSRule() {
		return getPredicateCSAccess().getRule();
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

	//NewStatementCS:
	//	'new' ':' referredTypedModel=[qvtbase::TypedModel|UnrestrictedName] name=UnrestrictedName ':' ownedType=TypeExpCS
	//	(':=' ownedInitExpression=ExpCS)? ';';
	public NewStatementCSElements getNewStatementCSAccess() {
		return pNewStatementCS;
	}
	
	public ParserRule getNewStatementCSRule() {
		return getNewStatementCSAccess().getRule();
	}

	//ScopeNameCS base::PathNameCS:
	//	ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*
	public ScopeNameCSElements getScopeNameCSAccess() {
		return pScopeNameCS;
	}
	
	public ParserRule getScopeNameCSRule() {
		return getScopeNameCSAccess().getRule();
	}

	//SetStatementCS:
	//	'set' referredVariable=[pivot::Variable|UnrestrictedName] '.' referredProperty=[pivot::Property|UnrestrictedName]
	//	':=' ownedInitExpression=ExpCS ';';
	public SetStatementCSElements getSetStatementCSAccess() {
		return pSetStatementCS;
	}
	
	public ParserRule getSetStatementCSRule() {
		return getSetStatementCSAccess().getRule();
	}

	//SourceDomainCS DomainCS:
	//	isCheck?='check' direction=[qvtbase::TypedModel|UnrestrictedName] ('{' ('check' checkedProperties+=PathNameCS (','
	//	checkedProperties+=PathNameCS)*)? ('enforce' enforcedProperties+=PathNameCS (',' enforcedProperties+=PathNameCS)*)?
	//	'}')? ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
	public SourceDomainCSElements getSourceDomainCSAccess() {
		return pSourceDomainCS;
	}
	
	public ParserRule getSourceDomainCSRule() {
		return getSourceDomainCSAccess().getRule();
	}

	//StatementCS:
	//	ControlStatementCS;
	public StatementCSElements getStatementCSAccess() {
		return pStatementCS;
	}
	
	public ParserRule getStatementCSRule() {
		return getStatementCSAccess().getRule();
	}

	//TransformationCS:
	//	'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* '}';
	public TransformationCSElements getTransformationCSAccess() {
		return pTransformationCS;
	}
	
	public ParserRule getTransformationCSRule() {
		return getTransformationCSAccess().getRule();
	}

	//TargetDomainCS DomainCS:
	//	isEnforce?='enforce' direction=[qvtbase::TypedModel|UnrestrictedName] ('{' ('check' checkedProperties+=PathNameCS
	//	(',' checkedProperties+=PathNameCS)*)? ('enforce' enforcedProperties+=PathNameCS (','
	//	enforcedProperties+=PathNameCS)*)? '}')? ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
	public TargetDomainCSElements getTargetDomainCSAccess() {
		return pTargetDomainCS;
	}
	
	public ParserRule getTargetDomainCSRule() {
		return getTargetDomainCSAccess().getRule();
	}

	//UnnamedDomainCS DomainCS:
	//	{DomainCS} ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS
	public UnnamedDomainCSElements getUnnamedDomainCSAccess() {
		return pUnnamedDomainCS;
	}
	
	public ParserRule getUnnamedDomainCSRule() {
		return getUnnamedDomainCSAccess().getRule();
	}

	//UnrealizedVariableCS:
	//	('var' | isConnection?='out') name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedInitExpression=ExpCS)? ';';
	public UnrealizedVariableCSElements getUnrealizedVariableCSAccess() {
		return pUnrealizedVariableCS;
	}
	
	public ParserRule getUnrealizedVariableCSRule() {
		return getUnrealizedVariableCSAccess().getRule();
	}

	//VariablePredicateCS UnrealizedVariableCS:
	//	'invar' name=UnrestrictedName (':' ownedType=TypeExpCS)? ':=' ownedInitExpression=ExpCS ';'
	public VariablePredicateCSElements getVariablePredicateCSAccess() {
		return pVariablePredicateCS;
	}
	
	public ParserRule getVariablePredicateCSRule() {
		return getVariablePredicateCSAccess().getRule();
	}

	//UnrestrictedName:
	//	EssentialOCLUnrestrictedName | 'check' | 'enforce' | 'import' | 'imports' //|	'include'
	// | 'library' | 'map' |
	//	'query' | 'realize' | 'refines' | 'transformation' | 'uses' //|	'where'
	//;
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
	//	EssentialOCLUnrestrictedName
	//	/ *|	'abstract'
	//|	'attribute'
	//|	'body'
	//|	'callable'
	//|	'class'
	//|	'composes'
	//|	'datatype'
	//|	'definition'
	//|	'derivation'
	//|	'derived'
	//|	'enum'
	//|	'extends'
	//|	'id'
	//|	'import'
	//|	'initial'
	//|	'interface'
	//|	'key'
	//|	'library'
	//|	'module'
	//|	'operation'
	//|	'ordered'
	//|	'package'
	//|	'postcondition'
	//|	'precondition'
	//|	'primitive'
	//|	'property'
	//|	'readonly'
	//|	'reference'
	//|	'resolve'
	//|	'static'
	//|	'throws'
	//|	'transient'
	//|	'unique'
	//|	'unsettable'
	//|	'volatile' * /;
	public QVTbaseGrammarAccess.EnumerationLiteralNameElements getEnumerationLiteralNameAccess() {
		return gaQVTbase.getEnumerationLiteralNameAccess();
	}
	
	public ParserRule getEnumerationLiteralNameRule() {
		return getEnumerationLiteralNameAccess().getRule();
	}

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
	//	referredProperty=[pivot::Property|super::UnrestrictedName] '=' ownedInitExpression=(ExpCS | PatternExpCS);
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
	//	{CurlyBracketedClauseCS} '{' ((ownedParts+=ShadowPartCS (',' ownedParts+=ShadowPartCS)*)? | value=StringLiteral) '}';
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
