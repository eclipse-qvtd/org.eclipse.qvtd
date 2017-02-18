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
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cObserveKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_1_0 = (RuleCall)cObservedPropertiesAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0 = (RuleCall)cObservedPropertiesAssignment_0_2_1.eContents().get(0);
		private final Keyword cAddKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTargetVariableAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cTargetVariableConnectionVariableCrossReference_2_0 = (CrossReference)cTargetVariableAssignment_2.eContents().get(0);
		private final RuleCall cTargetVariableConnectionVariableUnrestrictedNameParserRuleCall_2_0_1 = (RuleCall)cTargetVariableConnectionVariableCrossReference_2_0.eContents().get(1);
		private final Keyword cPlusSignEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_4_0 = (RuleCall)cOwnedExpressionAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//AddStatementCS:
		//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? 'add'
		//	targetVariable=[qvtimperative::ConnectionVariable|UnrestrictedName] '+=' ownedExpression=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? 'add'
		//targetVariable=[qvtimperative::ConnectionVariable|UnrestrictedName] '+=' ownedExpression=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)?
		public Group getGroup_0() { return cGroup_0; }

		//'observe'
		public Keyword getObserveKeyword_0_0() { return cObserveKeyword_0_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_1() { return cObservedPropertiesAssignment_0_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_1_0; }

		//(',' observedProperties+=PathNameCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_2_1() { return cObservedPropertiesAssignment_0_2_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0; }

		//'add'
		public Keyword getAddKeyword_1() { return cAddKeyword_1; }

		//targetVariable=[qvtimperative::ConnectionVariable|UnrestrictedName]
		public Assignment getTargetVariableAssignment_2() { return cTargetVariableAssignment_2; }

		//[qvtimperative::ConnectionVariable|UnrestrictedName]
		public CrossReference getTargetVariableConnectionVariableCrossReference_2_0() { return cTargetVariableConnectionVariableCrossReference_2_0; }

		//UnrestrictedName
		public RuleCall getTargetVariableConnectionVariableUnrestrictedNameParserRuleCall_2_0_1() { return cTargetVariableConnectionVariableUnrestrictedNameParserRuleCall_2_0_1; }

		//'+='
		public Keyword getPlusSignEqualsSignKeyword_3() { return cPlusSignEqualsSignKeyword_3; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_4() { return cOwnedExpressionAssignment_4; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_4_0() { return cOwnedExpressionExpCSParserRuleCall_4_0; }

		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}

	public class AppendParameterBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.AppendParameterBindingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cReferredVariableAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cReferredVariableAppendParameterCrossReference_0_0 = (CrossReference)cReferredVariableAssignment_0.eContents().get(0);
		private final RuleCall cReferredVariableAppendParameterUnrestrictedNameParserRuleCall_0_0_1 = (RuleCall)cReferredVariableAppendParameterCrossReference_0_0.eContents().get(1);
		private final Keyword cAppendsToKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cValueConnectionVariableCrossReference_2_0 = (CrossReference)cValueAssignment_2.eContents().get(0);
		private final RuleCall cValueConnectionVariableUnrestrictedNameParserRuleCall_2_0_1 = (RuleCall)cValueConnectionVariableCrossReference_2_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//AppendParameterBindingCS:
		//	referredVariable=[qvtimperative::AppendParameter|UnrestrictedName] 'appendsTo'
		//	value=[qvtimperative::ConnectionVariable|UnrestrictedName] ';';
		@Override public ParserRule getRule() { return rule; }

		//referredVariable=[qvtimperative::AppendParameter|UnrestrictedName] 'appendsTo'
		//value=[qvtimperative::ConnectionVariable|UnrestrictedName] ';'
		public Group getGroup() { return cGroup; }

		//referredVariable=[qvtimperative::AppendParameter|UnrestrictedName]
		public Assignment getReferredVariableAssignment_0() { return cReferredVariableAssignment_0; }

		//[qvtimperative::AppendParameter|UnrestrictedName]
		public CrossReference getReferredVariableAppendParameterCrossReference_0_0() { return cReferredVariableAppendParameterCrossReference_0_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableAppendParameterUnrestrictedNameParserRuleCall_0_0_1() { return cReferredVariableAppendParameterUnrestrictedNameParserRuleCall_0_0_1; }

		//'appendsTo'
		public Keyword getAppendsToKeyword_1() { return cAppendsToKeyword_1; }

		//value=[qvtimperative::ConnectionVariable|UnrestrictedName]
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//[qvtimperative::ConnectionVariable|UnrestrictedName]
		public CrossReference getValueConnectionVariableCrossReference_2_0() { return cValueConnectionVariableCrossReference_2_0; }

		//UnrestrictedName
		public RuleCall getValueConnectionVariableUnrestrictedNameParserRuleCall_2_0_1() { return cValueConnectionVariableUnrestrictedNameParserRuleCall_2_0_1; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class AppendParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.AppendParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAppendKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_3_0 = (RuleCall)cOwnedTypeAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//AppendParameterCS:
		//	'append' name=UnrestrictedName ':' ownedType=TypeExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'append' name=UnrestrictedName ':' ownedType=TypeExpCS ';'
		public Group getGroup() { return cGroup; }

		//'append'
		public Keyword getAppendKeyword_0() { return cAppendKeyword_0; }

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

	public class BufferStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.BufferStatementCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsStrictAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsStrictStrictKeyword_0_0 = (Keyword)cIsStrictAssignment_0.eContents().get(0);
		private final Keyword cBufferKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_3_1_0 = (RuleCall)cOwnedTypeAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonEqualsSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_4_1_0 = (RuleCall)cOwnedExpressionAssignment_4_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//BufferStatementCS:
		//	isStrict?='strict'? 'buffer' name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedExpression=ExpCS)? ';';
		@Override public ParserRule getRule() { return rule; }

		//isStrict?='strict'? 'buffer' name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedExpression=ExpCS)? ';'
		public Group getGroup() { return cGroup; }

		//isStrict?='strict'?
		public Assignment getIsStrictAssignment_0() { return cIsStrictAssignment_0; }

		//'strict'
		public Keyword getIsStrictStrictKeyword_0_0() { return cIsStrictStrictKeyword_0_0; }

		//'buffer'
		public Keyword getBufferKeyword_1() { return cBufferKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_3_1() { return cOwnedTypeAssignment_3_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_3_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_3_1_0; }

		//(':=' ownedExpression=ExpCS)?
		public Group getGroup_4() { return cGroup_4; }

		//':='
		public Keyword getColonEqualsSignKeyword_4_0() { return cColonEqualsSignKeyword_4_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_4_1() { return cOwnedExpressionAssignment_4_1; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_4_1_0() { return cOwnedExpressionExpCSParserRuleCall_4_1_0; }

		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}

	public class CommitStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.CommitStatementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNewStatementCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSetStatementCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		//CommitStatementCS StatementCS:
		//	NewStatementCS | SetStatementCS
		@Override public ParserRule getRule() { return rule; }

		//NewStatementCS | SetStatementCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//NewStatementCS
		public RuleCall getNewStatementCSParserRuleCall_0() { return cNewStatementCSParserRuleCall_0; }

		//SetStatementCS
		public RuleCall getSetStatementCSParserRuleCall_1() { return cSetStatementCSParserRuleCall_1; }
	}

	public class CheckStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.CheckStatementCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCheckKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedConditionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedConditionExpCSParserRuleCall_1_0 = (RuleCall)cOwnedConditionAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);

		//CheckStatementCS:
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

	public class DeclareStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.DeclareStatementCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cObserveKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_1_0 = (RuleCall)cObservedPropertiesAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0 = (RuleCall)cObservedPropertiesAssignment_0_2_1.eContents().get(0);
		private final Assignment cIsCheckAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsCheckCheckKeyword_1_0 = (Keyword)cIsCheckAssignment_1.eContents().get(0);
		private final Keyword cVarKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_4_1_0 = (RuleCall)cOwnedTypeAssignment_4_1.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cOwnedExpressionAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_6_0 = (RuleCall)cOwnedExpressionAssignment_6.eContents().get(0);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);

		//DeclareStatementCS:
		//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isCheck?='check'? 'var'
		//	name=UnrestrictedName (':' ownedType=TypeExpCS)? ':=' ownedExpression=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isCheck?='check'? 'var'
		//name=UnrestrictedName (':' ownedType=TypeExpCS)? ':=' ownedExpression=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)?
		public Group getGroup_0() { return cGroup_0; }

		//'observe'
		public Keyword getObserveKeyword_0_0() { return cObserveKeyword_0_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_1() { return cObservedPropertiesAssignment_0_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_1_0; }

		//(',' observedProperties+=PathNameCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_2_1() { return cObservedPropertiesAssignment_0_2_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0; }

		//isCheck?='check'?
		public Assignment getIsCheckAssignment_1() { return cIsCheckAssignment_1; }

		//'check'
		public Keyword getIsCheckCheckKeyword_1_0() { return cIsCheckCheckKeyword_1_0; }

		//'var'
		public Keyword getVarKeyword_2() { return cVarKeyword_2; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

		//(':' ownedType=TypeExpCS)?
		public Group getGroup_4() { return cGroup_4; }

		//':'
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_4_1() { return cOwnedTypeAssignment_4_1; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_4_1_0() { return cOwnedTypeTypeExpCSParserRuleCall_4_1_0; }

		//':='
		public Keyword getColonEqualsSignKeyword_5() { return cColonEqualsSignKeyword_5; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_6() { return cOwnedExpressionAssignment_6; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_6_0() { return cOwnedExpressionExpCSParserRuleCall_6_0; }

		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}

	public class DirectionCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.DirectionCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDirectionCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cIsCheckedAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cIsCheckedCheckKeyword_1_0_0 = (Keyword)cIsCheckedAssignment_1_0.eContents().get(0);
		private final Assignment cIsEnforcedAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cIsEnforcedEnforceKeyword_1_1_0 = (Keyword)cIsEnforcedAssignment_1_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cImportsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cImportsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cImportsPackageCrossReference_3_1_0 = (CrossReference)cImportsAssignment_3_1.eContents().get(0);
		private final RuleCall cImportsPackageUnrestrictedNameParserRuleCall_3_1_0_1 = (RuleCall)cImportsPackageCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cImportsAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final CrossReference cImportsPackageCrossReference_3_2_1_0 = (CrossReference)cImportsAssignment_3_2_1.eContents().get(0);
		private final RuleCall cImportsPackageUnrestrictedNameParserRuleCall_3_2_1_0_1 = (RuleCall)cImportsPackageCrossReference_3_2_1_0.eContents().get(1);

		//DirectionCS:
		//	{DirectionCS} (isChecked?='check' | isEnforced?='enforce')? name=UnrestrictedName? ('imports'
		//	imports+=[pivot::Package|UnrestrictedName] (',' imports+=[pivot::Package|UnrestrictedName])*)?;
		@Override public ParserRule getRule() { return rule; }

		//{DirectionCS} (isChecked?='check' | isEnforced?='enforce')? name=UnrestrictedName? ('imports'
		//imports+=[pivot::Package|UnrestrictedName] (',' imports+=[pivot::Package|UnrestrictedName])*)?
		public Group getGroup() { return cGroup; }

		//{DirectionCS}
		public Action getDirectionCSAction_0() { return cDirectionCSAction_0; }

		//(isChecked?='check' | isEnforced?='enforce')?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//isChecked?='check'
		public Assignment getIsCheckedAssignment_1_0() { return cIsCheckedAssignment_1_0; }

		//'check'
		public Keyword getIsCheckedCheckKeyword_1_0_0() { return cIsCheckedCheckKeyword_1_0_0; }

		//isEnforced?='enforce'
		public Assignment getIsEnforcedAssignment_1_1() { return cIsEnforcedAssignment_1_1; }

		//'enforce'
		public Keyword getIsEnforcedEnforceKeyword_1_1_0() { return cIsEnforcedEnforceKeyword_1_1_0; }

		//name=UnrestrictedName?
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//('imports' imports+=[pivot::Package|UnrestrictedName] (',' imports+=[pivot::Package|UnrestrictedName])*)?
		public Group getGroup_3() { return cGroup_3; }

		//'imports'
		public Keyword getImportsKeyword_3_0() { return cImportsKeyword_3_0; }

		//imports+=[pivot::Package|UnrestrictedName]
		public Assignment getImportsAssignment_3_1() { return cImportsAssignment_3_1; }

		//[pivot::Package|UnrestrictedName]
		public CrossReference getImportsPackageCrossReference_3_1_0() { return cImportsPackageCrossReference_3_1_0; }

		//UnrestrictedName
		public RuleCall getImportsPackageUnrestrictedNameParserRuleCall_3_1_0_1() { return cImportsPackageUnrestrictedNameParserRuleCall_3_1_0_1; }

		//(',' imports+=[pivot::Package|UnrestrictedName])*
		public Group getGroup_3_2() { return cGroup_3_2; }

		//','
		public Keyword getCommaKeyword_3_2_0() { return cCommaKeyword_3_2_0; }

		//imports+=[pivot::Package|UnrestrictedName]
		public Assignment getImportsAssignment_3_2_1() { return cImportsAssignment_3_2_1; }

		//[pivot::Package|UnrestrictedName]
		public CrossReference getImportsPackageCrossReference_3_2_1_0() { return cImportsPackageCrossReference_3_2_1_0; }

		//UnrestrictedName
		public RuleCall getImportsPackageUnrestrictedNameParserRuleCall_3_2_1_0_1() { return cImportsPackageUnrestrictedNameParserRuleCall_3_2_1_0_1; }
	}

	public class GuardParameterBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.GuardParameterBindingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsCheckAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsCheckCheckKeyword_0_0 = (Keyword)cIsCheckAssignment_0.eContents().get(0);
		private final Assignment cReferredVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cReferredVariableGuardParameterCrossReference_1_0 = (CrossReference)cReferredVariableAssignment_1.eContents().get(0);
		private final RuleCall cReferredVariableGuardParameterUnrestrictedNameParserRuleCall_1_0_1 = (RuleCall)cReferredVariableGuardParameterCrossReference_1_0.eContents().get(1);
		private final Keyword cConsumesKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cValueConnectionVariableCrossReference_3_0 = (CrossReference)cValueAssignment_3.eContents().get(0);
		private final RuleCall cValueConnectionVariableUnrestrictedNameParserRuleCall_3_0_1 = (RuleCall)cValueConnectionVariableCrossReference_3_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//GuardParameterBindingCS:
		//	isCheck?='check'? referredVariable=[qvtimperative::GuardParameter|UnrestrictedName] 'consumes'
		//	value=[qvtimperative::ConnectionVariable|UnrestrictedName] ';';
		@Override public ParserRule getRule() { return rule; }

		//isCheck?='check'? referredVariable=[qvtimperative::GuardParameter|UnrestrictedName] 'consumes'
		//value=[qvtimperative::ConnectionVariable|UnrestrictedName] ';'
		public Group getGroup() { return cGroup; }

		//isCheck?='check'?
		public Assignment getIsCheckAssignment_0() { return cIsCheckAssignment_0; }

		//'check'
		public Keyword getIsCheckCheckKeyword_0_0() { return cIsCheckCheckKeyword_0_0; }

		//referredVariable=[qvtimperative::GuardParameter|UnrestrictedName]
		public Assignment getReferredVariableAssignment_1() { return cReferredVariableAssignment_1; }

		//[qvtimperative::GuardParameter|UnrestrictedName]
		public CrossReference getReferredVariableGuardParameterCrossReference_1_0() { return cReferredVariableGuardParameterCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableGuardParameterUnrestrictedNameParserRuleCall_1_0_1() { return cReferredVariableGuardParameterUnrestrictedNameParserRuleCall_1_0_1; }

		//'consumes'
		public Keyword getConsumesKeyword_2() { return cConsumesKeyword_2; }

		//value=[qvtimperative::ConnectionVariable|UnrestrictedName]
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//[qvtimperative::ConnectionVariable|UnrestrictedName]
		public CrossReference getValueConnectionVariableCrossReference_3_0() { return cValueConnectionVariableCrossReference_3_0; }

		//UnrestrictedName
		public RuleCall getValueConnectionVariableUnrestrictedNameParserRuleCall_3_0_1() { return cValueConnectionVariableUnrestrictedNameParserRuleCall_3_0_1; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class GuardParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.GuardParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cGuardKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReferredTypedModelAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cReferredTypedModelImperativeTypedModelCrossReference_2_0 = (CrossReference)cReferredTypedModelAssignment_2.eContents().get(0);
		private final RuleCall cReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_2_0_1 = (RuleCall)cReferredTypedModelImperativeTypedModelCrossReference_2_0.eContents().get(1);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedTypeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_5_0 = (RuleCall)cOwnedTypeAssignment_5.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);

		//GuardParameterCS:
		//	'guard' ':' referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
		//	ownedType=TypeExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'guard' ':' referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
		//ownedType=TypeExpCS ';'
		public Group getGroup() { return cGroup; }

		//'guard'
		public Keyword getGuardKeyword_0() { return cGuardKeyword_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName]
		public Assignment getReferredTypedModelAssignment_2() { return cReferredTypedModelAssignment_2; }

		//[qvtimperative::ImperativeTypedModel|UnrestrictedName]
		public CrossReference getReferredTypedModelImperativeTypedModelCrossReference_2_0() { return cReferredTypedModelImperativeTypedModelCrossReference_2_0; }

		//UnrestrictedName
		public RuleCall getReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_2_0_1() { return cReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_2_0_1; }

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

		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}

	public class GuardStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.GuardStatementCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBufferStatementCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDeclareStatementCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cDeclareStatementCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cCheckStatementCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);

		//GuardStatementCS StatementCS:
		//	BufferStatementCS | DeclareStatementCS | DeclareStatementCS | CheckStatementCS
		@Override public ParserRule getRule() { return rule; }

		//BufferStatementCS | DeclareStatementCS | DeclareStatementCS | CheckStatementCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//BufferStatementCS
		public RuleCall getBufferStatementCSParserRuleCall_0() { return cBufferStatementCSParserRuleCall_0; }

		//DeclareStatementCS
		public RuleCall getDeclareStatementCSParserRuleCall_1() { return cDeclareStatementCSParserRuleCall_1; }

		//DeclareStatementCS
		public RuleCall getDeclareStatementCSParserRuleCall_2() { return cDeclareStatementCSParserRuleCall_2; }

		//CheckStatementCS
		public RuleCall getCheckStatementCSParserRuleCall_3() { return cCheckStatementCSParserRuleCall_3; }
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

	public class LoopParameterBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.LoopParameterBindingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsCheckAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsCheckCheckKeyword_0_0 = (Keyword)cIsCheckAssignment_0.eContents().get(0);
		private final Assignment cReferredVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cReferredVariableGuardParameterCrossReference_1_0 = (CrossReference)cReferredVariableAssignment_1.eContents().get(0);
		private final RuleCall cReferredVariableGuardParameterUnrestrictedNameParserRuleCall_1_0_1 = (RuleCall)cReferredVariableGuardParameterCrossReference_1_0.eContents().get(1);
		private final Keyword cIteratesKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cValueLoopVariableCrossReference_3_0 = (CrossReference)cValueAssignment_3.eContents().get(0);
		private final RuleCall cValueLoopVariableUnrestrictedNameParserRuleCall_3_0_1 = (RuleCall)cValueLoopVariableCrossReference_3_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//LoopParameterBindingCS:
		//	isCheck?='check'? referredVariable=[qvtimperative::GuardParameter|UnrestrictedName] 'iterates'
		//	value=[qvtimperative::LoopVariable|UnrestrictedName] ';';
		@Override public ParserRule getRule() { return rule; }

		//isCheck?='check'? referredVariable=[qvtimperative::GuardParameter|UnrestrictedName] 'iterates'
		//value=[qvtimperative::LoopVariable|UnrestrictedName] ';'
		public Group getGroup() { return cGroup; }

		//isCheck?='check'?
		public Assignment getIsCheckAssignment_0() { return cIsCheckAssignment_0; }

		//'check'
		public Keyword getIsCheckCheckKeyword_0_0() { return cIsCheckCheckKeyword_0_0; }

		//referredVariable=[qvtimperative::GuardParameter|UnrestrictedName]
		public Assignment getReferredVariableAssignment_1() { return cReferredVariableAssignment_1; }

		//[qvtimperative::GuardParameter|UnrestrictedName]
		public CrossReference getReferredVariableGuardParameterCrossReference_1_0() { return cReferredVariableGuardParameterCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableGuardParameterUnrestrictedNameParserRuleCall_1_0_1() { return cReferredVariableGuardParameterUnrestrictedNameParserRuleCall_1_0_1; }

		//'iterates'
		public Keyword getIteratesKeyword_2() { return cIteratesKeyword_2; }

		//value=[qvtimperative::LoopVariable|UnrestrictedName]
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//[qvtimperative::LoopVariable|UnrestrictedName]
		public CrossReference getValueLoopVariableCrossReference_3_0() { return cValueLoopVariableCrossReference_3_0; }

		//UnrestrictedName
		public RuleCall getValueLoopVariableUnrestrictedNameParserRuleCall_3_0_1() { return cValueLoopVariableUnrestrictedNameParserRuleCall_3_0_1; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class MappingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMappingCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cIsStrictAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsStrictStrictKeyword_1_0 = (Keyword)cIsStrictAssignment_1.eContents().get(0);
		private final Keyword cMapKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cInKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedInPathNameAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedInPathNamePathNameCSParserRuleCall_4_1_0 = (RuleCall)cOwnedInPathNameAssignment_4_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cOwnedParametersAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedParametersMappingParameterCSParserRuleCall_6_0 = (RuleCall)cOwnedParametersAssignment_6.eContents().get(0);
		private final Assignment cOwnedStatementsAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedStatementsGuardStatementCSParserRuleCall_7_0 = (RuleCall)cOwnedStatementsAssignment_7.eContents().get(0);
		private final Assignment cOwnedStatementsAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cOwnedStatementsCommitStatementCSParserRuleCall_8_0 = (RuleCall)cOwnedStatementsAssignment_8.eContents().get(0);
		private final Assignment cOwnedStatementsAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cOwnedStatementsControlStatementCSParserRuleCall_9_0 = (RuleCall)cOwnedStatementsAssignment_9.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);

		//MappingCS:
		//	{MappingCS} isStrict?='strict'? 'map' name=UnrestrictedName ('in' ownedInPathName=PathNameCS)? '{'
		//	ownedParameters+=MappingParameterCS* ownedStatements+=GuardStatementCS* ownedStatements+=CommitStatementCS*
		//	ownedStatements+=ControlStatementCS* '}';
		@Override public ParserRule getRule() { return rule; }

		//{MappingCS} isStrict?='strict'? 'map' name=UnrestrictedName ('in' ownedInPathName=PathNameCS)? '{'
		//ownedParameters+=MappingParameterCS* ownedStatements+=GuardStatementCS* ownedStatements+=CommitStatementCS*
		//ownedStatements+=ControlStatementCS* '}'
		public Group getGroup() { return cGroup; }

		//{MappingCS}
		public Action getMappingCSAction_0() { return cMappingCSAction_0; }

		//isStrict?='strict'?
		public Assignment getIsStrictAssignment_1() { return cIsStrictAssignment_1; }

		//'strict'
		public Keyword getIsStrictStrictKeyword_1_0() { return cIsStrictStrictKeyword_1_0; }

		//'map'
		public Keyword getMapKeyword_2() { return cMapKeyword_2; }

		//name=UnrestrictedName
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

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }

		//ownedParameters+=MappingParameterCS*
		public Assignment getOwnedParametersAssignment_6() { return cOwnedParametersAssignment_6; }

		//MappingParameterCS
		public RuleCall getOwnedParametersMappingParameterCSParserRuleCall_6_0() { return cOwnedParametersMappingParameterCSParserRuleCall_6_0; }

		//ownedStatements+=GuardStatementCS*
		public Assignment getOwnedStatementsAssignment_7() { return cOwnedStatementsAssignment_7; }

		//GuardStatementCS
		public RuleCall getOwnedStatementsGuardStatementCSParserRuleCall_7_0() { return cOwnedStatementsGuardStatementCSParserRuleCall_7_0; }

		//ownedStatements+=CommitStatementCS*
		public Assignment getOwnedStatementsAssignment_8() { return cOwnedStatementsAssignment_8; }

		//CommitStatementCS
		public RuleCall getOwnedStatementsCommitStatementCSParserRuleCall_8_0() { return cOwnedStatementsCommitStatementCSParserRuleCall_8_0; }

		//ownedStatements+=ControlStatementCS*
		public Assignment getOwnedStatementsAssignment_9() { return cOwnedStatementsAssignment_9; }

		//ControlStatementCS
		public RuleCall getOwnedStatementsControlStatementCSParserRuleCall_9_0() { return cOwnedStatementsControlStatementCSParserRuleCall_9_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}

	public class MappingCallCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingCallCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMappingCallCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cCallKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cIsInstallAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cIsInstallInstallKeyword_1_1_0 = (Keyword)cIsInstallAssignment_1_1.eContents().get(0);
		private final Assignment cIsInvokeAssignment_1_2 = (Assignment)cAlternatives_1.eContents().get(2);
		private final Keyword cIsInvokeInvokeKeyword_1_2_0 = (Keyword)cIsInvokeAssignment_1_2.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedBindingsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedBindingsMappingParameterBindingCSParserRuleCall_4_0 = (RuleCall)cOwnedBindingsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//MappingCallCS:
		//	{MappingCallCS} ('call' | isInstall?='install' | isInvoke?='invoke') ownedPathName=PathNameCS '{'
		//	ownedBindings+=MappingParameterBindingCS* '}';
		@Override public ParserRule getRule() { return rule; }

		//{MappingCallCS} ('call' | isInstall?='install' | isInvoke?='invoke') ownedPathName=PathNameCS '{'
		//ownedBindings+=MappingParameterBindingCS* '}'
		public Group getGroup() { return cGroup; }

		//{MappingCallCS}
		public Action getMappingCallCSAction_0() { return cMappingCallCSAction_0; }

		//('call' | isInstall?='install' | isInvoke?='invoke')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//'call'
		public Keyword getCallKeyword_1_0() { return cCallKeyword_1_0; }

		//isInstall?='install'
		public Assignment getIsInstallAssignment_1_1() { return cIsInstallAssignment_1_1; }

		//'install'
		public Keyword getIsInstallInstallKeyword_1_1_0() { return cIsInstallInstallKeyword_1_1_0; }

		//isInvoke?='invoke'
		public Assignment getIsInvokeAssignment_1_2() { return cIsInvokeAssignment_1_2; }

		//'invoke'
		public Keyword getIsInvokeInvokeKeyword_1_2_0() { return cIsInvokeInvokeKeyword_1_2_0; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_2() { return cOwnedPathNameAssignment_2; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_2_0() { return cOwnedPathNamePathNameCSParserRuleCall_2_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//ownedBindings+=MappingParameterBindingCS*
		public Assignment getOwnedBindingsAssignment_4() { return cOwnedBindingsAssignment_4; }

		//MappingParameterBindingCS
		public RuleCall getOwnedBindingsMappingParameterBindingCSParserRuleCall_4_0() { return cOwnedBindingsMappingParameterBindingCSParserRuleCall_4_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class MappingLoopCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingLoopCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cObserveKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_1_0 = (RuleCall)cObservedPropertiesAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0 = (RuleCall)cObservedPropertiesAssignment_0_2_1.eContents().get(0);
		private final Keyword cForKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedIteratorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedIteratorMappingIteratorCSParserRuleCall_2_0 = (RuleCall)cOwnedIteratorAssignment_2.eContents().get(0);
		private final Keyword cInKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedInExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedInExpressionExpCSParserRuleCall_4_0 = (RuleCall)cOwnedInExpressionAssignment_4.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cOwnedMappingStatementsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedMappingStatementsControlStatementCSParserRuleCall_6_0 = (RuleCall)cOwnedMappingStatementsAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);

		//MappingLoopCS:
		//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? 'for'
		//	ownedIterator=MappingIteratorCS 'in' ownedInExpression=ExpCS '{' ownedMappingStatements+=ControlStatementCS+ '}';
		@Override public ParserRule getRule() { return rule; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? 'for' ownedIterator=MappingIteratorCS
		//'in' ownedInExpression=ExpCS '{' ownedMappingStatements+=ControlStatementCS+ '}'
		public Group getGroup() { return cGroup; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)?
		public Group getGroup_0() { return cGroup_0; }

		//'observe'
		public Keyword getObserveKeyword_0_0() { return cObserveKeyword_0_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_1() { return cObservedPropertiesAssignment_0_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_1_0; }

		//(',' observedProperties+=PathNameCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_2_1() { return cObservedPropertiesAssignment_0_2_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0; }

		//'for'
		public Keyword getForKeyword_1() { return cForKeyword_1; }

		//ownedIterator=MappingIteratorCS
		public Assignment getOwnedIteratorAssignment_2() { return cOwnedIteratorAssignment_2; }

		//MappingIteratorCS
		public RuleCall getOwnedIteratorMappingIteratorCSParserRuleCall_2_0() { return cOwnedIteratorMappingIteratorCSParserRuleCall_2_0; }

		//'in'
		public Keyword getInKeyword_3() { return cInKeyword_3; }

		//ownedInExpression=ExpCS
		public Assignment getOwnedInExpressionAssignment_4() { return cOwnedInExpressionAssignment_4; }

		//ExpCS
		public RuleCall getOwnedInExpressionExpCSParserRuleCall_4_0() { return cOwnedInExpressionExpCSParserRuleCall_4_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }

		//ownedMappingStatements+=ControlStatementCS+
		public Assignment getOwnedMappingStatementsAssignment_6() { return cOwnedMappingStatementsAssignment_6; }

		//ControlStatementCS
		public RuleCall getOwnedMappingStatementsControlStatementCSParserRuleCall_6_0() { return cOwnedMappingStatementsControlStatementCSParserRuleCall_6_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
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

	public class MappingParameterBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingParameterBindingCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAppendParameterBindingCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cGuardParameterBindingCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLoopParameterBindingCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cSimpleParameterBindingCSParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);

		//MappingParameterBindingCS:
		//	AppendParameterBindingCS | GuardParameterBindingCS | LoopParameterBindingCS | SimpleParameterBindingCS;
		@Override public ParserRule getRule() { return rule; }

		//AppendParameterBindingCS | GuardParameterBindingCS | LoopParameterBindingCS | SimpleParameterBindingCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//AppendParameterBindingCS
		public RuleCall getAppendParameterBindingCSParserRuleCall_0() { return cAppendParameterBindingCSParserRuleCall_0; }

		//GuardParameterBindingCS
		public RuleCall getGuardParameterBindingCSParserRuleCall_1() { return cGuardParameterBindingCSParserRuleCall_1; }

		//LoopParameterBindingCS
		public RuleCall getLoopParameterBindingCSParserRuleCall_2() { return cLoopParameterBindingCSParserRuleCall_2; }

		//SimpleParameterBindingCS
		public RuleCall getSimpleParameterBindingCSParserRuleCall_3() { return cSimpleParameterBindingCSParserRuleCall_3; }
	}

	public class MappingParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingParameterCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAppendParameterCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cGuardParameterCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSimpleParameterCSParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//MappingParameterCS:
		//	AppendParameterCS | GuardParameterCS | SimpleParameterCS;
		@Override public ParserRule getRule() { return rule; }

		//AppendParameterCS | GuardParameterCS | SimpleParameterCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//AppendParameterCS
		public RuleCall getAppendParameterCSParserRuleCall_0() { return cAppendParameterCSParserRuleCall_0; }

		//GuardParameterCS
		public RuleCall getGuardParameterCSParserRuleCall_1() { return cGuardParameterCSParserRuleCall_1; }

		//SimpleParameterCS
		public RuleCall getSimpleParameterCSParserRuleCall_2() { return cSimpleParameterCSParserRuleCall_2; }
	}

	public class NewStatementCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.NewStatementCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cObserveKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_1_0 = (RuleCall)cObservedPropertiesAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0 = (RuleCall)cObservedPropertiesAssignment_0_2_1.eContents().get(0);
		private final Assignment cIsContainedAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsContainedContainedKeyword_1_0 = (Keyword)cIsContainedAssignment_1.eContents().get(0);
		private final Keyword cNewKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cReferredTypedModelAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cReferredTypedModelImperativeTypedModelCrossReference_4_0 = (CrossReference)cReferredTypedModelAssignment_4.eContents().get(0);
		private final RuleCall cReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_4_0_1 = (RuleCall)cReferredTypedModelImperativeTypedModelCrossReference_4_0.eContents().get(1);
		private final Assignment cNameAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_5_0 = (RuleCall)cNameAssignment_5.eContents().get(0);
		private final Keyword cColonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cOwnedTypeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_7_0 = (RuleCall)cOwnedTypeAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cColonEqualsSignKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_8_1_0 = (RuleCall)cOwnedExpressionAssignment_8_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_9 = (Keyword)cGroup.eContents().get(9);

		//NewStatementCS:
		//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isContained?='contained'? 'new' ':'
		//	referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
		//	ownedType=TypeExpCS (':=' ownedExpression=ExpCS)? ';';
		@Override public ParserRule getRule() { return rule; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isContained?='contained'? 'new' ':'
		//referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
		//ownedType=TypeExpCS (':=' ownedExpression=ExpCS)? ';'
		public Group getGroup() { return cGroup; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)?
		public Group getGroup_0() { return cGroup_0; }

		//'observe'
		public Keyword getObserveKeyword_0_0() { return cObserveKeyword_0_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_1() { return cObservedPropertiesAssignment_0_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_1_0; }

		//(',' observedProperties+=PathNameCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_2_1() { return cObservedPropertiesAssignment_0_2_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0; }

		//isContained?='contained'?
		public Assignment getIsContainedAssignment_1() { return cIsContainedAssignment_1; }

		//'contained'
		public Keyword getIsContainedContainedKeyword_1_0() { return cIsContainedContainedKeyword_1_0; }

		//'new'
		public Keyword getNewKeyword_2() { return cNewKeyword_2; }

		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName]
		public Assignment getReferredTypedModelAssignment_4() { return cReferredTypedModelAssignment_4; }

		//[qvtimperative::ImperativeTypedModel|UnrestrictedName]
		public CrossReference getReferredTypedModelImperativeTypedModelCrossReference_4_0() { return cReferredTypedModelImperativeTypedModelCrossReference_4_0; }

		//UnrestrictedName
		public RuleCall getReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_4_0_1() { return cReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_4_0_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_5() { return cNameAssignment_5; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_5_0() { return cNameUnrestrictedNameParserRuleCall_5_0; }

		//':'
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }

		//ownedType=TypeExpCS
		public Assignment getOwnedTypeAssignment_7() { return cOwnedTypeAssignment_7; }

		//TypeExpCS
		public RuleCall getOwnedTypeTypeExpCSParserRuleCall_7_0() { return cOwnedTypeTypeExpCSParserRuleCall_7_0; }

		//(':=' ownedExpression=ExpCS)?
		public Group getGroup_8() { return cGroup_8; }

		//':='
		public Keyword getColonEqualsSignKeyword_8_0() { return cColonEqualsSignKeyword_8_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_8_1() { return cOwnedExpressionAssignment_8_1; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_8_1_0() { return cOwnedExpressionExpCSParserRuleCall_8_1_0; }

		//';'
		public Keyword getSemicolonKeyword_9() { return cSemicolonKeyword_9; }
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
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cObserveKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_1_0 = (RuleCall)cObservedPropertiesAssignment_0_1.eContents().get(0);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cCommaKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cObservedPropertiesAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final RuleCall cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0 = (RuleCall)cObservedPropertiesAssignment_0_2_1.eContents().get(0);
		private final Assignment cIsNotifyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsNotifyNotifyKeyword_1_0 = (Keyword)cIsNotifyAssignment_1.eContents().get(0);
		private final Keyword cSetKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cReferredVariableAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cReferredVariableVariableDeclarationCrossReference_3_0 = (CrossReference)cReferredVariableAssignment_3.eContents().get(0);
		private final RuleCall cReferredVariableVariableDeclarationUnrestrictedNameParserRuleCall_3_0_1 = (RuleCall)cReferredVariableVariableDeclarationCrossReference_3_0.eContents().get(1);
		private final Keyword cFullStopKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cReferredPropertyAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cReferredPropertyPropertyCrossReference_5_0 = (CrossReference)cReferredPropertyAssignment_5.eContents().get(0);
		private final RuleCall cReferredPropertyPropertyUnrestrictedNameParserRuleCall_5_0_1 = (RuleCall)cReferredPropertyPropertyCrossReference_5_0.eContents().get(1);
		private final Alternatives cAlternatives_6 = (Alternatives)cGroup.eContents().get(6);
		private final Keyword cColonEqualsSignKeyword_6_0 = (Keyword)cAlternatives_6.eContents().get(0);
		private final Assignment cIsPartialAssignment_6_1 = (Assignment)cAlternatives_6.eContents().get(1);
		private final Keyword cIsPartialPlusSignEqualsSignKeyword_6_1_0 = (Keyword)cIsPartialAssignment_6_1.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_7_0 = (RuleCall)cOwnedExpressionAssignment_7.eContents().get(0);
		private final Keyword cSemicolonKeyword_8 = (Keyword)cGroup.eContents().get(8);

		//SetStatementCS:
		//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isNotify?='notify'? 'set'
		//	referredVariable=[pivot::VariableDeclaration|UnrestrictedName] '.'
		//	referredProperty=[pivot::Property|UnrestrictedName] (':=' | isPartial?='+=') ownedExpression=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isNotify?='notify'? 'set'
		//referredVariable=[pivot::VariableDeclaration|UnrestrictedName] '.' referredProperty=[pivot::Property|UnrestrictedName]
		//(':=' | isPartial?='+=') ownedExpression=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)?
		public Group getGroup_0() { return cGroup_0; }

		//'observe'
		public Keyword getObserveKeyword_0_0() { return cObserveKeyword_0_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_1() { return cObservedPropertiesAssignment_0_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_1_0; }

		//(',' observedProperties+=PathNameCS)*
		public Group getGroup_0_2() { return cGroup_0_2; }

		//','
		public Keyword getCommaKeyword_0_2_0() { return cCommaKeyword_0_2_0; }

		//observedProperties+=PathNameCS
		public Assignment getObservedPropertiesAssignment_0_2_1() { return cObservedPropertiesAssignment_0_2_1; }

		//PathNameCS
		public RuleCall getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0() { return cObservedPropertiesPathNameCSParserRuleCall_0_2_1_0; }

		//isNotify?='notify'?
		public Assignment getIsNotifyAssignment_1() { return cIsNotifyAssignment_1; }

		//'notify'
		public Keyword getIsNotifyNotifyKeyword_1_0() { return cIsNotifyNotifyKeyword_1_0; }

		//'set'
		public Keyword getSetKeyword_2() { return cSetKeyword_2; }

		//referredVariable=[pivot::VariableDeclaration|UnrestrictedName]
		public Assignment getReferredVariableAssignment_3() { return cReferredVariableAssignment_3; }

		//[pivot::VariableDeclaration|UnrestrictedName]
		public CrossReference getReferredVariableVariableDeclarationCrossReference_3_0() { return cReferredVariableVariableDeclarationCrossReference_3_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableVariableDeclarationUnrestrictedNameParserRuleCall_3_0_1() { return cReferredVariableVariableDeclarationUnrestrictedNameParserRuleCall_3_0_1; }

		//'.'
		public Keyword getFullStopKeyword_4() { return cFullStopKeyword_4; }

		//referredProperty=[pivot::Property|UnrestrictedName]
		public Assignment getReferredPropertyAssignment_5() { return cReferredPropertyAssignment_5; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getReferredPropertyPropertyCrossReference_5_0() { return cReferredPropertyPropertyCrossReference_5_0; }

		//UnrestrictedName
		public RuleCall getReferredPropertyPropertyUnrestrictedNameParserRuleCall_5_0_1() { return cReferredPropertyPropertyUnrestrictedNameParserRuleCall_5_0_1; }

		//(':=' | isPartial?='+=')
		public Alternatives getAlternatives_6() { return cAlternatives_6; }

		//':='
		public Keyword getColonEqualsSignKeyword_6_0() { return cColonEqualsSignKeyword_6_0; }

		//isPartial?='+='
		public Assignment getIsPartialAssignment_6_1() { return cIsPartialAssignment_6_1; }

		//'+='
		public Keyword getIsPartialPlusSignEqualsSignKeyword_6_1_0() { return cIsPartialPlusSignEqualsSignKeyword_6_1_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_7() { return cOwnedExpressionAssignment_7; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_7_0() { return cOwnedExpressionExpCSParserRuleCall_7_0; }

		//';'
		public Keyword getSemicolonKeyword_8() { return cSemicolonKeyword_8; }
	}

	public class SimpleParameterBindingCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.SimpleParameterBindingCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsCheckAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsCheckCheckKeyword_0_0 = (Keyword)cIsCheckAssignment_0.eContents().get(0);
		private final Assignment cReferredVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cReferredVariableSimpleParameterCrossReference_1_0 = (CrossReference)cReferredVariableAssignment_1.eContents().get(0);
		private final RuleCall cReferredVariableSimpleParameterUnrestrictedNameParserRuleCall_1_0_1 = (RuleCall)cReferredVariableSimpleParameterCrossReference_1_0.eContents().get(1);
		private final Keyword cUsesKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedValueExpCSParserRuleCall_3_0 = (RuleCall)cOwnedValueAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//SimpleParameterBindingCS:
		//	isCheck?='check'? referredVariable=[qvtimperative::SimpleParameter|UnrestrictedName] 'uses' ownedValue=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//isCheck?='check'? referredVariable=[qvtimperative::SimpleParameter|UnrestrictedName] 'uses' ownedValue=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//isCheck?='check'?
		public Assignment getIsCheckAssignment_0() { return cIsCheckAssignment_0; }

		//'check'
		public Keyword getIsCheckCheckKeyword_0_0() { return cIsCheckCheckKeyword_0_0; }

		//referredVariable=[qvtimperative::SimpleParameter|UnrestrictedName]
		public Assignment getReferredVariableAssignment_1() { return cReferredVariableAssignment_1; }

		//[qvtimperative::SimpleParameter|UnrestrictedName]
		public CrossReference getReferredVariableSimpleParameterCrossReference_1_0() { return cReferredVariableSimpleParameterCrossReference_1_0; }

		//UnrestrictedName
		public RuleCall getReferredVariableSimpleParameterUnrestrictedNameParserRuleCall_1_0_1() { return cReferredVariableSimpleParameterUnrestrictedNameParserRuleCall_1_0_1; }

		//'uses'
		public Keyword getUsesKeyword_2() { return cUsesKeyword_2; }

		//ownedValue=ExpCS
		public Assignment getOwnedValueAssignment_3() { return cOwnedValueAssignment_3; }

		//ExpCS
		public RuleCall getOwnedValueExpCSParserRuleCall_3_0() { return cOwnedValueExpCSParserRuleCall_3_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class SimpleParameterCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.SimpleParameterCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReferredTypedModelAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cReferredTypedModelImperativeTypedModelCrossReference_2_0 = (CrossReference)cReferredTypedModelAssignment_2.eContents().get(0);
		private final RuleCall cReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_2_0_1 = (RuleCall)cReferredTypedModelImperativeTypedModelCrossReference_2_0.eContents().get(1);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cOwnedTypeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cOwnedTypeTypeExpCSParserRuleCall_5_0 = (RuleCall)cOwnedTypeAssignment_5.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);

		//SimpleParameterCS:
		//	'in' ':' referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
		//	ownedType=TypeExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'in' ':' referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
		//ownedType=TypeExpCS ';'
		public Group getGroup() { return cGroup; }

		//'in'
		public Keyword getInKeyword_0() { return cInKeyword_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName]
		public Assignment getReferredTypedModelAssignment_2() { return cReferredTypedModelAssignment_2; }

		//[qvtimperative::ImperativeTypedModel|UnrestrictedName]
		public CrossReference getReferredTypedModelImperativeTypedModelCrossReference_2_0() { return cReferredTypedModelImperativeTypedModelCrossReference_2_0; }

		//UnrestrictedName
		public RuleCall getReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_2_0_1() { return cReferredTypedModelImperativeTypedModelUnrestrictedNameParserRuleCall_2_0_1; }

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

		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
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

	public class QVTimperativeUnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.QVTimperativeUnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAddKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAppendKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cAppendsToKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cBufferKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cCallKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cCheckKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cContainedKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cEnforceKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cForKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cImportsKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cInstallKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cInvokeKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cIteratesKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cMapKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cNewKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cNotifyKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cObserveKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cPackageKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cQueryKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cSetKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cStrictKeyword_20 = (Keyword)cAlternatives.eContents().get(20);
		private final Keyword cTransformationKeyword_21 = (Keyword)cAlternatives.eContents().get(21);
		private final Keyword cTransientKeyword_22 = (Keyword)cAlternatives.eContents().get(22);
		private final Keyword cUsesKeyword_23 = (Keyword)cAlternatives.eContents().get(23);
		private final Keyword cVarKeyword_24 = (Keyword)cAlternatives.eContents().get(24);

		//QVTimperativeUnrestrictedName:
		//	'add' | 'append' | 'appendsTo' | 'buffer' | 'call' | 'check' | 'contained' | 'enforce' | 'for' | 'imports' //|	'in'
		//
		//	| 'install' | 'invoke' | 'iterates' | 'map' | 'new' | 'notify' | 'observe' | 'package' | 'query' | 'set' | 'strict' |
		//	'transformation' | 'transient' | 'uses' | 'var';
		@Override public ParserRule getRule() { return rule; }

		//'add' | 'append' | 'appendsTo' | 'buffer' | 'call' | 'check' | 'contained' | 'enforce' | 'for' | 'imports' //|	'in'
		// |
		//'install' | 'invoke' | 'iterates' | 'map' | 'new' | 'notify' | 'observe' | 'package' | 'query' | 'set' | 'strict' |
		//'transformation' | 'transient' | 'uses' | 'var'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'add'
		public Keyword getAddKeyword_0() { return cAddKeyword_0; }

		//'append'
		public Keyword getAppendKeyword_1() { return cAppendKeyword_1; }

		//'appendsTo'
		public Keyword getAppendsToKeyword_2() { return cAppendsToKeyword_2; }

		//'buffer'
		public Keyword getBufferKeyword_3() { return cBufferKeyword_3; }

		//'call'
		public Keyword getCallKeyword_4() { return cCallKeyword_4; }

		//'check'
		public Keyword getCheckKeyword_5() { return cCheckKeyword_5; }

		//'contained'
		public Keyword getContainedKeyword_6() { return cContainedKeyword_6; }

		//'enforce'
		public Keyword getEnforceKeyword_7() { return cEnforceKeyword_7; }

		//'for'
		public Keyword getForKeyword_8() { return cForKeyword_8; }

		//'imports'
		public Keyword getImportsKeyword_9() { return cImportsKeyword_9; }

		//'install'
		public Keyword getInstallKeyword_10() { return cInstallKeyword_10; }

		//'invoke'
		public Keyword getInvokeKeyword_11() { return cInvokeKeyword_11; }

		//'iterates'
		public Keyword getIteratesKeyword_12() { return cIteratesKeyword_12; }

		//'map'
		public Keyword getMapKeyword_13() { return cMapKeyword_13; }

		//'new'
		public Keyword getNewKeyword_14() { return cNewKeyword_14; }

		//'notify'
		public Keyword getNotifyKeyword_15() { return cNotifyKeyword_15; }

		//'observe'
		public Keyword getObserveKeyword_16() { return cObserveKeyword_16; }

		//'package'
		public Keyword getPackageKeyword_17() { return cPackageKeyword_17; }

		//'query'
		public Keyword getQueryKeyword_18() { return cQueryKeyword_18; }

		//'set'
		public Keyword getSetKeyword_19() { return cSetKeyword_19; }

		//'strict'
		public Keyword getStrictKeyword_20() { return cStrictKeyword_20; }

		//'transformation'
		public Keyword getTransformationKeyword_21() { return cTransformationKeyword_21; }

		//'transient'
		public Keyword getTransientKeyword_22() { return cTransientKeyword_22; }

		//'uses'
		public Keyword getUsesKeyword_23() { return cUsesKeyword_23; }

		//'var'
		public Keyword getVarKeyword_24() { return cVarKeyword_24; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cQVTbaseUnrestrictedNameParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cQVTimperativeUnrestrictedNameParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//UnrestrictedName:
		//	EssentialOCLUnrestrictedName | QVTbaseUnrestrictedName | QVTimperativeUnrestrictedName;
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName | QVTbaseUnrestrictedName | QVTimperativeUnrestrictedName
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall_0() { return cEssentialOCLUnrestrictedNameParserRuleCall_0; }

		//QVTbaseUnrestrictedName
		public RuleCall getQVTbaseUnrestrictedNameParserRuleCall_1() { return cQVTbaseUnrestrictedNameParserRuleCall_1; }

		//QVTimperativeUnrestrictedName
		public RuleCall getQVTimperativeUnrestrictedNameParserRuleCall_2() { return cQVTimperativeUnrestrictedNameParserRuleCall_2; }
	}


	private final TopLevelCSElements pTopLevelCS;
	private final AddStatementCSElements pAddStatementCS;
	private final AppendParameterBindingCSElements pAppendParameterBindingCS;
	private final AppendParameterCSElements pAppendParameterCS;
	private final BufferStatementCSElements pBufferStatementCS;
	private final CommitStatementCSElements pCommitStatementCS;
	private final CheckStatementCSElements pCheckStatementCS;
	private final ControlStatementCSElements pControlStatementCS;
	private final DeclareStatementCSElements pDeclareStatementCS;
	private final DirectionCSElements pDirectionCS;
	private final GuardParameterBindingCSElements pGuardParameterBindingCS;
	private final GuardParameterCSElements pGuardParameterCS;
	private final GuardStatementCSElements pGuardStatementCS;
	private final ImportCSElements pImportCS;
	private final LoopParameterBindingCSElements pLoopParameterBindingCS;
	private final MappingCSElements pMappingCS;
	private final MappingCallCSElements pMappingCallCS;
	private final MappingLoopCSElements pMappingLoopCS;
	private final MappingIteratorCSElements pMappingIteratorCS;
	private final MappingParameterBindingCSElements pMappingParameterBindingCS;
	private final MappingParameterCSElements pMappingParameterCS;
	private final NewStatementCSElements pNewStatementCS;
	private final ParamDeclarationCSElements pParamDeclarationCS;
	private final QualifiedPackageCSElements pQualifiedPackageCS;
	private final QueryCSElements pQueryCS;
	private final ScopeNameCSElements pScopeNameCS;
	private final SetStatementCSElements pSetStatementCS;
	private final SimpleParameterBindingCSElements pSimpleParameterBindingCS;
	private final SimpleParameterCSElements pSimpleParameterCS;
	private final TransformationCSElements pTransformationCS;
	private final QVTimperativeUnrestrictedNameElements pQVTimperativeUnrestrictedName;
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
		this.pAppendParameterBindingCS = new AppendParameterBindingCSElements();
		this.pAppendParameterCS = new AppendParameterCSElements();
		this.pBufferStatementCS = new BufferStatementCSElements();
		this.pCommitStatementCS = new CommitStatementCSElements();
		this.pCheckStatementCS = new CheckStatementCSElements();
		this.pControlStatementCS = new ControlStatementCSElements();
		this.pDeclareStatementCS = new DeclareStatementCSElements();
		this.pDirectionCS = new DirectionCSElements();
		this.pGuardParameterBindingCS = new GuardParameterBindingCSElements();
		this.pGuardParameterCS = new GuardParameterCSElements();
		this.pGuardStatementCS = new GuardStatementCSElements();
		this.pImportCS = new ImportCSElements();
		this.pLoopParameterBindingCS = new LoopParameterBindingCSElements();
		this.pMappingCS = new MappingCSElements();
		this.pMappingCallCS = new MappingCallCSElements();
		this.pMappingLoopCS = new MappingLoopCSElements();
		this.pMappingIteratorCS = new MappingIteratorCSElements();
		this.pMappingParameterBindingCS = new MappingParameterBindingCSElements();
		this.pMappingParameterCS = new MappingParameterCSElements();
		this.pNewStatementCS = new NewStatementCSElements();
		this.pParamDeclarationCS = new ParamDeclarationCSElements();
		this.pQualifiedPackageCS = new QualifiedPackageCSElements();
		this.pQueryCS = new QueryCSElements();
		this.pScopeNameCS = new ScopeNameCSElements();
		this.pSetStatementCS = new SetStatementCSElements();
		this.pSimpleParameterBindingCS = new SimpleParameterBindingCSElements();
		this.pSimpleParameterCS = new SimpleParameterCSElements();
		this.pTransformationCS = new TransformationCSElements();
		this.pQVTimperativeUnrestrictedName = new QVTimperativeUnrestrictedNameElements();
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
	//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? 'add'
	//	targetVariable=[qvtimperative::ConnectionVariable|UnrestrictedName] '+=' ownedExpression=ExpCS ';';
	public AddStatementCSElements getAddStatementCSAccess() {
		return pAddStatementCS;
	}

	public ParserRule getAddStatementCSRule() {
		return getAddStatementCSAccess().getRule();
	}

	//AppendParameterBindingCS:
	//	referredVariable=[qvtimperative::AppendParameter|UnrestrictedName] 'appendsTo'
	//	value=[qvtimperative::ConnectionVariable|UnrestrictedName] ';';
	public AppendParameterBindingCSElements getAppendParameterBindingCSAccess() {
		return pAppendParameterBindingCS;
	}

	public ParserRule getAppendParameterBindingCSRule() {
		return getAppendParameterBindingCSAccess().getRule();
	}

	//AppendParameterCS:
	//	'append' name=UnrestrictedName ':' ownedType=TypeExpCS ';';
	public AppendParameterCSElements getAppendParameterCSAccess() {
		return pAppendParameterCS;
	}

	public ParserRule getAppendParameterCSRule() {
		return getAppendParameterCSAccess().getRule();
	}

	//BufferStatementCS:
	//	isStrict?='strict'? 'buffer' name=UnrestrictedName (':' ownedType=TypeExpCS)? (':=' ownedExpression=ExpCS)? ';';
	public BufferStatementCSElements getBufferStatementCSAccess() {
		return pBufferStatementCS;
	}

	public ParserRule getBufferStatementCSRule() {
		return getBufferStatementCSAccess().getRule();
	}

	//CommitStatementCS StatementCS:
	//	NewStatementCS | SetStatementCS
	public CommitStatementCSElements getCommitStatementCSAccess() {
		return pCommitStatementCS;
	}

	public ParserRule getCommitStatementCSRule() {
		return getCommitStatementCSAccess().getRule();
	}

	//CheckStatementCS:
	//	'check' ownedCondition=ExpCS ';';
	public CheckStatementCSElements getCheckStatementCSAccess() {
		return pCheckStatementCS;
	}

	public ParserRule getCheckStatementCSRule() {
		return getCheckStatementCSAccess().getRule();
	}

	//ControlStatementCS MappingStatementCS:
	//	AddStatementCS | MappingCallCS | MappingLoopCS
	public ControlStatementCSElements getControlStatementCSAccess() {
		return pControlStatementCS;
	}

	public ParserRule getControlStatementCSRule() {
		return getControlStatementCSAccess().getRule();
	}

	//DeclareStatementCS:
	//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isCheck?='check'? 'var'
	//	name=UnrestrictedName (':' ownedType=TypeExpCS)? ':=' ownedExpression=ExpCS ';';
	public DeclareStatementCSElements getDeclareStatementCSAccess() {
		return pDeclareStatementCS;
	}

	public ParserRule getDeclareStatementCSRule() {
		return getDeclareStatementCSAccess().getRule();
	}

	//DirectionCS:
	//	{DirectionCS} (isChecked?='check' | isEnforced?='enforce')? name=UnrestrictedName? ('imports'
	//	imports+=[pivot::Package|UnrestrictedName] (',' imports+=[pivot::Package|UnrestrictedName])*)?;
	public DirectionCSElements getDirectionCSAccess() {
		return pDirectionCS;
	}

	public ParserRule getDirectionCSRule() {
		return getDirectionCSAccess().getRule();
	}

	//GuardParameterBindingCS:
	//	isCheck?='check'? referredVariable=[qvtimperative::GuardParameter|UnrestrictedName] 'consumes'
	//	value=[qvtimperative::ConnectionVariable|UnrestrictedName] ';';
	public GuardParameterBindingCSElements getGuardParameterBindingCSAccess() {
		return pGuardParameterBindingCS;
	}

	public ParserRule getGuardParameterBindingCSRule() {
		return getGuardParameterBindingCSAccess().getRule();
	}

	//GuardParameterCS:
	//	'guard' ':' referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
	//	ownedType=TypeExpCS ';';
	public GuardParameterCSElements getGuardParameterCSAccess() {
		return pGuardParameterCS;
	}

	public ParserRule getGuardParameterCSRule() {
		return getGuardParameterCSAccess().getRule();
	}

	//GuardStatementCS StatementCS:
	//	BufferStatementCS | DeclareStatementCS | DeclareStatementCS | CheckStatementCS
	public GuardStatementCSElements getGuardStatementCSAccess() {
		return pGuardStatementCS;
	}

	public ParserRule getGuardStatementCSRule() {
		return getGuardStatementCSAccess().getRule();
	}

	//ImportCS base::ImportCS:
	//	'import' (name=Identifier ':')? ownedPathName=URIPathNameCS (isAll?='::' '*')? ';'
	public ImportCSElements getImportCSAccess() {
		return pImportCS;
	}

	public ParserRule getImportCSRule() {
		return getImportCSAccess().getRule();
	}

	//LoopParameterBindingCS:
	//	isCheck?='check'? referredVariable=[qvtimperative::GuardParameter|UnrestrictedName] 'iterates'
	//	value=[qvtimperative::LoopVariable|UnrestrictedName] ';';
	public LoopParameterBindingCSElements getLoopParameterBindingCSAccess() {
		return pLoopParameterBindingCS;
	}

	public ParserRule getLoopParameterBindingCSRule() {
		return getLoopParameterBindingCSAccess().getRule();
	}

	//MappingCS:
	//	{MappingCS} isStrict?='strict'? 'map' name=UnrestrictedName ('in' ownedInPathName=PathNameCS)? '{'
	//	ownedParameters+=MappingParameterCS* ownedStatements+=GuardStatementCS* ownedStatements+=CommitStatementCS*
	//	ownedStatements+=ControlStatementCS* '}';
	public MappingCSElements getMappingCSAccess() {
		return pMappingCS;
	}

	public ParserRule getMappingCSRule() {
		return getMappingCSAccess().getRule();
	}

	//MappingCallCS:
	//	{MappingCallCS} ('call' | isInstall?='install' | isInvoke?='invoke') ownedPathName=PathNameCS '{'
	//	ownedBindings+=MappingParameterBindingCS* '}';
	public MappingCallCSElements getMappingCallCSAccess() {
		return pMappingCallCS;
	}

	public ParserRule getMappingCallCSRule() {
		return getMappingCallCSAccess().getRule();
	}

	//MappingLoopCS:
	//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? 'for'
	//	ownedIterator=MappingIteratorCS 'in' ownedInExpression=ExpCS '{' ownedMappingStatements+=ControlStatementCS+ '}';
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

	//MappingParameterBindingCS:
	//	AppendParameterBindingCS | GuardParameterBindingCS | LoopParameterBindingCS | SimpleParameterBindingCS;
	public MappingParameterBindingCSElements getMappingParameterBindingCSAccess() {
		return pMappingParameterBindingCS;
	}

	public ParserRule getMappingParameterBindingCSRule() {
		return getMappingParameterBindingCSAccess().getRule();
	}

	//MappingParameterCS:
	//	AppendParameterCS | GuardParameterCS | SimpleParameterCS;
	public MappingParameterCSElements getMappingParameterCSAccess() {
		return pMappingParameterCS;
	}

	public ParserRule getMappingParameterCSRule() {
		return getMappingParameterCSAccess().getRule();
	}

	//NewStatementCS:
	//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isContained?='contained'? 'new' ':'
	//	referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
	//	ownedType=TypeExpCS (':=' ownedExpression=ExpCS)? ';';
	public NewStatementCSElements getNewStatementCSAccess() {
		return pNewStatementCS;
	}

	public ParserRule getNewStatementCSRule() {
		return getNewStatementCSAccess().getRule();
	}

	//ParamDeclarationCS:
	//	name=UnrestrictedName ':' ownedType=TypeExpCS;
	public ParamDeclarationCSElements getParamDeclarationCSAccess() {
		return pParamDeclarationCS;
	}

	public ParserRule getParamDeclarationCSRule() {
		return getParamDeclarationCSAccess().getRule();
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

	//ScopeNameCS base::PathNameCS:
	//	ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*
	public ScopeNameCSElements getScopeNameCSAccess() {
		return pScopeNameCS;
	}

	public ParserRule getScopeNameCSRule() {
		return getScopeNameCSAccess().getRule();
	}

	//SetStatementCS:
	//	('observe' observedProperties+=PathNameCS (',' observedProperties+=PathNameCS)*)? isNotify?='notify'? 'set'
	//	referredVariable=[pivot::VariableDeclaration|UnrestrictedName] '.'
	//	referredProperty=[pivot::Property|UnrestrictedName] (':=' | isPartial?='+=') ownedExpression=ExpCS ';';
	public SetStatementCSElements getSetStatementCSAccess() {
		return pSetStatementCS;
	}

	public ParserRule getSetStatementCSRule() {
		return getSetStatementCSAccess().getRule();
	}

	//SimpleParameterBindingCS:
	//	isCheck?='check'? referredVariable=[qvtimperative::SimpleParameter|UnrestrictedName] 'uses' ownedValue=ExpCS ';';
	public SimpleParameterBindingCSElements getSimpleParameterBindingCSAccess() {
		return pSimpleParameterBindingCS;
	}

	public ParserRule getSimpleParameterBindingCSRule() {
		return getSimpleParameterBindingCSAccess().getRule();
	}

	//SimpleParameterCS:
	//	'in' ':' referredTypedModel=[qvtimperative::ImperativeTypedModel|UnrestrictedName] name=UnrestrictedName ':'
	//	ownedType=TypeExpCS ';';
	public SimpleParameterCSElements getSimpleParameterCSAccess() {
		return pSimpleParameterCS;
	}

	public ParserRule getSimpleParameterCSRule() {
		return getSimpleParameterCSAccess().getRule();
	}

	//TransformationCS:
	//	'transformation' ownedPathName=ScopeNameCS? name=UnreservedName '{' (ownedDirections+=DirectionCS ';')* '}';
	public TransformationCSElements getTransformationCSAccess() {
		return pTransformationCS;
	}

	public ParserRule getTransformationCSRule() {
		return getTransformationCSAccess().getRule();
	}

	//QVTimperativeUnrestrictedName:
	//	'add' | 'append' | 'appendsTo' | 'buffer' | 'call' | 'check' | 'contained' | 'enforce' | 'for' | 'imports' //|	'in'
	//
	//	| 'install' | 'invoke' | 'iterates' | 'map' | 'new' | 'notify' | 'observe' | 'package' | 'query' | 'set' | 'strict' |
	//	'transformation' | 'transient' | 'uses' | 'var';
	public QVTimperativeUnrestrictedNameElements getQVTimperativeUnrestrictedNameAccess() {
		return pQVTimperativeUnrestrictedName;
	}

	public ParserRule getQVTimperativeUnrestrictedNameRule() {
		return getQVTimperativeUnrestrictedNameAccess().getRule();
	}

	//UnrestrictedName:
	//	EssentialOCLUnrestrictedName | QVTbaseUnrestrictedName | QVTimperativeUnrestrictedName;
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
