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
package org.eclipse.qvtd.xtext.qvtcore.services;

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
public class QVTcoreGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class TopLevelCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TopLevelCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedImportsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedImportsImportCSParserRuleCall_0_0 = (RuleCall)cOwnedImportsAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cOwnedMappingsAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cOwnedMappingsMappingCSParserRuleCall_1_0_0 = (RuleCall)cOwnedMappingsAssignment_1_0.eContents().get(0);
		private final Assignment cOwnedTransformationsAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cOwnedTransformationsTransformationCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTransformationsAssignment_1_1.eContents().get(0);
		private final Assignment cOwnedQueriesAssignment_1_2 = (Assignment)cAlternatives_1.eContents().get(2);
		private final RuleCall cOwnedQueriesQueryCSParserRuleCall_1_2_0 = (RuleCall)cOwnedQueriesAssignment_1_2.eContents().get(0);
		
		//TopLevelCS:
		//	ownedImports+=ImportCS* (ownedMappings+=MappingCS | ownedTransformations+=TransformationCS | ownedQueries+=QueryCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedImports+=ImportCS* (ownedMappings+=MappingCS | ownedTransformations+=TransformationCS | ownedQueries+=QueryCS)*
		public Group getGroup() { return cGroup; }

		//ownedImports+=ImportCS*
		public Assignment getOwnedImportsAssignment_0() { return cOwnedImportsAssignment_0; }

		//ImportCS
		public RuleCall getOwnedImportsImportCSParserRuleCall_0_0() { return cOwnedImportsImportCSParserRuleCall_0_0; }

		//(ownedMappings+=MappingCS | ownedTransformations+=TransformationCS | ownedQueries+=QueryCS)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//ownedMappings+=MappingCS
		public Assignment getOwnedMappingsAssignment_1_0() { return cOwnedMappingsAssignment_1_0; }

		//MappingCS
		public RuleCall getOwnedMappingsMappingCSParserRuleCall_1_0_0() { return cOwnedMappingsMappingCSParserRuleCall_1_0_0; }

		//ownedTransformations+=TransformationCS
		public Assignment getOwnedTransformationsAssignment_1_1() { return cOwnedTransformationsAssignment_1_1; }

		//TransformationCS
		public RuleCall getOwnedTransformationsTransformationCSParserRuleCall_1_1_0() { return cOwnedTransformationsTransformationCSParserRuleCall_1_1_0; }

		//ownedQueries+=QueryCS
		public Assignment getOwnedQueriesAssignment_1_2() { return cOwnedQueriesAssignment_1_2; }

		//QueryCS
		public RuleCall getOwnedQueriesQueryCSParserRuleCall_1_2_0() { return cOwnedQueriesQueryCSParserRuleCall_1_2_0; }
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
		//	{MappingCS} isDefault?="default"? "map" name=UnrestrictedName? ("in" ownedInPathName=PathNameCS)? ("refines"
		//	refines+=[qvtcore::Mapping|UnrestrictedName] ("," refines+=[qvtcore::Mapping|UnrestrictedName])*)? "{"
		//	ownedDomains+=NamedDomainCS* ("where" ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* "}";
		@Override public ParserRule getRule() { return rule; }

		//{MappingCS} isDefault?="default"? "map" name=UnrestrictedName? ("in" ownedInPathName=PathNameCS)? ("refines"
		//refines+=[qvtcore::Mapping|UnrestrictedName] ("," refines+=[qvtcore::Mapping|UnrestrictedName])*)? "{"
		//ownedDomains+=NamedDomainCS* ("where" ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* "}"
		public Group getGroup() { return cGroup; }

		//{MappingCS}
		public Action getMappingCSAction_0() { return cMappingCSAction_0; }

		//isDefault?="default"?
		public Assignment getIsDefaultAssignment_1() { return cIsDefaultAssignment_1; }

		//"default"
		public Keyword getIsDefaultDefaultKeyword_1_0() { return cIsDefaultDefaultKeyword_1_0; }

		//"map"
		public Keyword getMapKeyword_2() { return cMapKeyword_2; }

		//name=UnrestrictedName?
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

		//("refines" refines+=[qvtcore::Mapping|UnrestrictedName] ("," refines+=[qvtcore::Mapping|UnrestrictedName])*)?
		public Group getGroup_5() { return cGroup_5; }

		//"refines"
		public Keyword getRefinesKeyword_5_0() { return cRefinesKeyword_5_0; }

		//refines+=[qvtcore::Mapping|UnrestrictedName]
		public Assignment getRefinesAssignment_5_1() { return cRefinesAssignment_5_1; }

		//[qvtcore::Mapping|UnrestrictedName]
		public CrossReference getRefinesMappingCrossReference_5_1_0() { return cRefinesMappingCrossReference_5_1_0; }

		//UnrestrictedName
		public RuleCall getRefinesMappingUnrestrictedNameParserRuleCall_5_1_0_1() { return cRefinesMappingUnrestrictedNameParserRuleCall_5_1_0_1; }

		//("," refines+=[qvtcore::Mapping|UnrestrictedName])*
		public Group getGroup_5_2() { return cGroup_5_2; }

		//","
		public Keyword getCommaKeyword_5_2_0() { return cCommaKeyword_5_2_0; }

		//refines+=[qvtcore::Mapping|UnrestrictedName]
		public Assignment getRefinesAssignment_5_2_1() { return cRefinesAssignment_5_2_1; }

		//[qvtcore::Mapping|UnrestrictedName]
		public CrossReference getRefinesMappingCrossReference_5_2_1_0() { return cRefinesMappingCrossReference_5_2_1_0; }

		//UnrestrictedName
		public RuleCall getRefinesMappingUnrestrictedNameParserRuleCall_5_2_1_0_1() { return cRefinesMappingUnrestrictedNameParserRuleCall_5_2_1_0_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }

		//ownedDomains+=NamedDomainCS*
		public Assignment getOwnedDomainsAssignment_7() { return cOwnedDomainsAssignment_7; }

		//NamedDomainCS
		public RuleCall getOwnedDomainsNamedDomainCSParserRuleCall_7_0() { return cOwnedDomainsNamedDomainCSParserRuleCall_7_0; }

		//("where" ownedMiddle=UnnamedDomainCS)?
		public Group getGroup_8() { return cGroup_8; }

		//"where"
		public Keyword getWhereKeyword_8_0() { return cWhereKeyword_8_0; }

		//ownedMiddle=UnnamedDomainCS
		public Assignment getOwnedMiddleAssignment_8_1() { return cOwnedMiddleAssignment_8_1; }

		//UnnamedDomainCS
		public RuleCall getOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0() { return cOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0; }

		//ownedComposedMappings+=MappingCS*
		public Assignment getOwnedComposedMappingsAssignment_9() { return cOwnedComposedMappingsAssignment_9; }

		//MappingCS
		public RuleCall getOwnedComposedMappingsMappingCSParserRuleCall_9_0() { return cOwnedComposedMappingsMappingCSParserRuleCall_9_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}
	
	
	private final TopLevelCSElements pTopLevelCS;
	private final MappingCSElements pMappingCS;
	
	private final Grammar grammar;

	private final QVTcoreBaseGrammarAccess gaQVTcoreBase;

	@Inject
	public QVTcoreGrammarAccess(GrammarProvider grammarProvider,
		QVTcoreBaseGrammarAccess gaQVTcoreBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaQVTcoreBase = gaQVTcoreBase;
		this.pTopLevelCS = new TopLevelCSElements();
		this.pMappingCS = new MappingCSElements();
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
	

	public QVTcoreBaseGrammarAccess getQVTcoreBaseGrammarAccess() {
		return gaQVTcoreBase;
	}

	
	//TopLevelCS:
	//	ownedImports+=ImportCS* (ownedMappings+=MappingCS | ownedTransformations+=TransformationCS | ownedQueries+=QueryCS)*;
	public TopLevelCSElements getTopLevelCSAccess() {
		return pTopLevelCS;
	}
	
	public ParserRule getTopLevelCSRule() {
		return getTopLevelCSAccess().getRule();
	}

	//MappingCS:
	//	{MappingCS} isDefault?="default"? "map" name=UnrestrictedName? ("in" ownedInPathName=PathNameCS)? ("refines"
	//	refines+=[qvtcore::Mapping|UnrestrictedName] ("," refines+=[qvtcore::Mapping|UnrestrictedName])*)? "{"
	//	ownedDomains+=NamedDomainCS* ("where" ownedMiddle=UnnamedDomainCS)? ownedComposedMappings+=MappingCS* "}";
	public MappingCSElements getMappingCSAccess() {
		return pMappingCS;
	}
	
	public ParserRule getMappingCSRule() {
		return getMappingCSAccess().getRule();
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

	//DirectionCS:
	//	{DirectionCS} name=UnrestrictedName? ("imports" imports+=[pivot::Package|UnrestrictedName] (","
	//	imports+=[pivot::Package|UnrestrictedName])*)? ("uses" uses+=[qvtcorebase::CoreDomain|UnrestrictedName] (","
	//	uses+=[qvtcorebase::CoreDomain|UnrestrictedName])*)?;
	public QVTcoreBaseGrammarAccess.DirectionCSElements getDirectionCSAccess() {
		return gaQVTcoreBase.getDirectionCSAccess();
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
