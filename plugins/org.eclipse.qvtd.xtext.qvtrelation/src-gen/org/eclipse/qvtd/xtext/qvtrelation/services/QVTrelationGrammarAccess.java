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
package org.eclipse.qvtd.xtext.qvtrelation.services;

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
public class QVTrelationGrammarAccess extends AbstractGrammarElementFinder {


	public class TopLevelCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TopLevelCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedImportsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedImportsUnitCSParserRuleCall_0_0 = (RuleCall)cOwnedImportsAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cOwnedPackagesAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0 = (RuleCall)cOwnedPackagesAssignment_1_0.eContents().get(0);
		private final Assignment cOwnedTransformationsAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cOwnedTransformationsTransformationCSParserRuleCall_1_1_0 = (RuleCall)cOwnedTransformationsAssignment_1_1.eContents().get(0);

		//TopLevelCS:
		//	ownedImports+=UnitCS* (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS)*;
		@Override public ParserRule getRule() { return rule; }

		//ownedImports+=UnitCS* (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS)*
		public Group getGroup() { return cGroup; }

		//ownedImports+=UnitCS*
		public Assignment getOwnedImportsAssignment_0() { return cOwnedImportsAssignment_0; }

		//UnitCS
		public RuleCall getOwnedImportsUnitCSParserRuleCall_0_0() { return cOwnedImportsUnitCSParserRuleCall_0_0; }

		//(ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//ownedPackages+=QualifiedPackageCS
		public Assignment getOwnedPackagesAssignment_1_0() { return cOwnedPackagesAssignment_1_0; }

		//QualifiedPackageCS
		public RuleCall getOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0() { return cOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0; }

		//ownedTransformations+=TransformationCS
		public Assignment getOwnedTransformationsAssignment_1_1() { return cOwnedTransformationsAssignment_1_1; }

		//TransformationCS
		public RuleCall getOwnedTransformationsTransformationCSParserRuleCall_1_1_0() { return cOwnedTransformationsTransformationCSParserRuleCall_1_1_0; }
	}

	public class QualifiedPackageCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.QualifiedPackageCS");
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

	public class CollectionTemplateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.CollectionTemplateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeCollectionTypeCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cOwnedMemberIdentifiersAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final Alternatives cOwnedMemberIdentifiersAlternatives_4_0_0 = (Alternatives)cOwnedMemberIdentifiersAssignment_4_0.eContents().get(0);
		private final RuleCall cOwnedMemberIdentifiersTemplateCSParserRuleCall_4_0_0_0 = (RuleCall)cOwnedMemberIdentifiersAlternatives_4_0_0.eContents().get(0);
		private final RuleCall cOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_0_0_1 = (RuleCall)cOwnedMemberIdentifiersAlternatives_4_0_0.eContents().get(1);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cOwnedMemberIdentifiersAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final Alternatives cOwnedMemberIdentifiersAlternatives_4_1_1_0 = (Alternatives)cOwnedMemberIdentifiersAssignment_4_1_1.eContents().get(0);
		private final RuleCall cOwnedMemberIdentifiersTemplateCSParserRuleCall_4_1_1_0_0 = (RuleCall)cOwnedMemberIdentifiersAlternatives_4_1_1_0.eContents().get(0);
		private final RuleCall cOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_1_1_0_1 = (RuleCall)cOwnedMemberIdentifiersAlternatives_4_1_1_0.eContents().get(1);
		private final Keyword cPlusSignPlusSignKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Assignment cOwnedRestIdentifierAssignment_4_3 = (Assignment)cGroup_4.eContents().get(3);
		private final RuleCall cOwnedRestIdentifierElementTemplateCSParserRuleCall_4_3_0 = (RuleCall)cOwnedRestIdentifierAssignment_4_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		////UnitCS: identifier+=[pivot::Element|UnrestrictedName] ('.' identifier+=[pivot::Element|UnrestrictedName])*;
		//
		//CollectionTemplateCS:
		//	name=UnrestrictedName? ':' ownedType=CollectionTypeCS '{' (ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS)
		//	(',' ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS))* '++' ownedRestIdentifier=ElementTemplateCS)? '}';
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName? ':' ownedType=CollectionTypeCS '{' (ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS) (','
		//ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS))* '++' ownedRestIdentifier=ElementTemplateCS)? '}'
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName?
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=CollectionTypeCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//CollectionTypeCS
		public RuleCall getOwnedTypeCollectionTypeCSParserRuleCall_2_0() { return cOwnedTypeCollectionTypeCSParserRuleCall_2_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//(ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS) (',' ownedMemberIdentifiers+=(TemplateCS |
		//ElementTemplateCS))* '++' ownedRestIdentifier=ElementTemplateCS)?
		public Group getGroup_4() { return cGroup_4; }

		//ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS)
		public Assignment getOwnedMemberIdentifiersAssignment_4_0() { return cOwnedMemberIdentifiersAssignment_4_0; }

		//(TemplateCS | ElementTemplateCS)
		public Alternatives getOwnedMemberIdentifiersAlternatives_4_0_0() { return cOwnedMemberIdentifiersAlternatives_4_0_0; }

		//TemplateCS
		public RuleCall getOwnedMemberIdentifiersTemplateCSParserRuleCall_4_0_0_0() { return cOwnedMemberIdentifiersTemplateCSParserRuleCall_4_0_0_0; }

		//ElementTemplateCS
		public RuleCall getOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_0_0_1() { return cOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_0_0_1; }

		//(',' ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS))*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS)
		public Assignment getOwnedMemberIdentifiersAssignment_4_1_1() { return cOwnedMemberIdentifiersAssignment_4_1_1; }

		//(TemplateCS | ElementTemplateCS)
		public Alternatives getOwnedMemberIdentifiersAlternatives_4_1_1_0() { return cOwnedMemberIdentifiersAlternatives_4_1_1_0; }

		//TemplateCS
		public RuleCall getOwnedMemberIdentifiersTemplateCSParserRuleCall_4_1_1_0_0() { return cOwnedMemberIdentifiersTemplateCSParserRuleCall_4_1_1_0_0; }

		//ElementTemplateCS
		public RuleCall getOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_1_1_0_1() { return cOwnedMemberIdentifiersElementTemplateCSParserRuleCall_4_1_1_0_1; }

		//'++'
		public Keyword getPlusSignPlusSignKeyword_4_2() { return cPlusSignPlusSignKeyword_4_2; }

		//ownedRestIdentifier=ElementTemplateCS
		public Assignment getOwnedRestIdentifierAssignment_4_3() { return cOwnedRestIdentifierAssignment_4_3; }

		//ElementTemplateCS
		public RuleCall getOwnedRestIdentifierElementTemplateCSParserRuleCall_4_3_0() { return cOwnedRestIdentifierElementTemplateCSParserRuleCall_4_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class DefaultValueCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.DefaultValueCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyIdAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyIdSharedVariableCrossReference_0_0 = (CrossReference)cPropertyIdAssignment_0.eContents().get(0);
		private final RuleCall cPropertyIdSharedVariableUnrestrictedNameParserRuleCall_0_0_1 = (RuleCall)cPropertyIdSharedVariableCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedInitExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_2_0 = (RuleCall)cOwnedInitExpressionAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);

		//DefaultValueCS:
		//	propertyId=[qvtrelation::SharedVariable|UnrestrictedName] '=' ownedInitExpression=ExpCS ';';
		@Override public ParserRule getRule() { return rule; }

		//propertyId=[qvtrelation::SharedVariable|UnrestrictedName] '=' ownedInitExpression=ExpCS ';'
		public Group getGroup() { return cGroup; }

		//propertyId=[qvtrelation::SharedVariable|UnrestrictedName]
		public Assignment getPropertyIdAssignment_0() { return cPropertyIdAssignment_0; }

		//[qvtrelation::SharedVariable|UnrestrictedName]
		public CrossReference getPropertyIdSharedVariableCrossReference_0_0() { return cPropertyIdSharedVariableCrossReference_0_0; }

		//UnrestrictedName
		public RuleCall getPropertyIdSharedVariableUnrestrictedNameParserRuleCall_0_0_1() { return cPropertyIdSharedVariableUnrestrictedNameParserRuleCall_0_0_1; }

		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_2() { return cOwnedInitExpressionAssignment_2; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_2_0() { return cOwnedInitExpressionExpCSParserRuleCall_2_0; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class DomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.DomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cIsCheckonlyAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cIsCheckonlyCheckonlyKeyword_0_0_0 = (Keyword)cIsCheckonlyAssignment_0_0.eContents().get(0);
		private final Assignment cIsEnforceAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cIsEnforceEnforceKeyword_0_1_0 = (Keyword)cIsEnforceAssignment_0_1.eContents().get(0);
		private final Keyword cReplaceKeyword_0_2 = (Keyword)cAlternatives_0.eContents().get(2);
		private final Keyword cDomainKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cModelIdAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cModelIdTypedModelCrossReference_2_0 = (CrossReference)cModelIdAssignment_2.eContents().get(0);
		private final RuleCall cModelIdTypedModelUnrestrictedNameParserRuleCall_2_0_1 = (RuleCall)cModelIdTypedModelCrossReference_2_0.eContents().get(1);
		private final Assignment cOwnedPatternAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedPatternDomainPatternCSParserRuleCall_3_0 = (RuleCall)cOwnedPatternAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedPatternAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedPatternDomainPatternCSParserRuleCall_4_1_0 = (RuleCall)cOwnedPatternAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cImplementedbyKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cImplementedByAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cImplementedByUnrestrictedNameParserRuleCall_5_1_0 = (RuleCall)cImplementedByAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cDefault_valuesKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6_1 = (Keyword)cGroup_6.eContents().get(1);
		private final Assignment cOwnedDefaultValuesAssignment_6_2 = (Assignment)cGroup_6.eContents().get(2);
		private final RuleCall cOwnedDefaultValuesDefaultValueCSParserRuleCall_6_2_0 = (RuleCall)cOwnedDefaultValuesAssignment_6_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6_3 = (Keyword)cGroup_6.eContents().get(3);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);

		//DomainCS:
		//	(isCheckonly?='checkonly' | isEnforce?='enforce' | 'replace')? 'domain'
		//	modelId=[qvtbase::TypedModel|UnrestrictedName] ownedPattern+=DomainPatternCS (',' ownedPattern+=DomainPatternCS)*
		//	('implementedby' implementedBy=UnrestrictedName)? ('default_values' '{' ownedDefaultValues+=DefaultValueCS+ '}')?
		//	';';
		@Override public ParserRule getRule() { return rule; }

		//(isCheckonly?='checkonly' | isEnforce?='enforce' | 'replace')? 'domain' modelId=[qvtbase::TypedModel|UnrestrictedName]
		//ownedPattern+=DomainPatternCS (',' ownedPattern+=DomainPatternCS)* ('implementedby' implementedBy=UnrestrictedName)?
		//('default_values' '{' ownedDefaultValues+=DefaultValueCS+ '}')? ';'
		public Group getGroup() { return cGroup; }

		//(isCheckonly?='checkonly' | isEnforce?='enforce' | 'replace')?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//isCheckonly?='checkonly'
		public Assignment getIsCheckonlyAssignment_0_0() { return cIsCheckonlyAssignment_0_0; }

		//'checkonly'
		public Keyword getIsCheckonlyCheckonlyKeyword_0_0_0() { return cIsCheckonlyCheckonlyKeyword_0_0_0; }

		//isEnforce?='enforce'
		public Assignment getIsEnforceAssignment_0_1() { return cIsEnforceAssignment_0_1; }

		//'enforce'
		public Keyword getIsEnforceEnforceKeyword_0_1_0() { return cIsEnforceEnforceKeyword_0_1_0; }

		//'replace'
		public Keyword getReplaceKeyword_0_2() { return cReplaceKeyword_0_2; }

		//'domain'
		public Keyword getDomainKeyword_1() { return cDomainKeyword_1; }

		//modelId=[qvtbase::TypedModel|UnrestrictedName]
		public Assignment getModelIdAssignment_2() { return cModelIdAssignment_2; }

		//[qvtbase::TypedModel|UnrestrictedName]
		public CrossReference getModelIdTypedModelCrossReference_2_0() { return cModelIdTypedModelCrossReference_2_0; }

		//UnrestrictedName
		public RuleCall getModelIdTypedModelUnrestrictedNameParserRuleCall_2_0_1() { return cModelIdTypedModelUnrestrictedNameParserRuleCall_2_0_1; }

		//ownedPattern+=DomainPatternCS
		public Assignment getOwnedPatternAssignment_3() { return cOwnedPatternAssignment_3; }

		//DomainPatternCS
		public RuleCall getOwnedPatternDomainPatternCSParserRuleCall_3_0() { return cOwnedPatternDomainPatternCSParserRuleCall_3_0; }

		//(',' ownedPattern+=DomainPatternCS)*
		public Group getGroup_4() { return cGroup_4; }

		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//ownedPattern+=DomainPatternCS
		public Assignment getOwnedPatternAssignment_4_1() { return cOwnedPatternAssignment_4_1; }

		//DomainPatternCS
		public RuleCall getOwnedPatternDomainPatternCSParserRuleCall_4_1_0() { return cOwnedPatternDomainPatternCSParserRuleCall_4_1_0; }

		//('implementedby' implementedBy=UnrestrictedName)?
		public Group getGroup_5() { return cGroup_5; }

		//'implementedby'
		public Keyword getImplementedbyKeyword_5_0() { return cImplementedbyKeyword_5_0; }

		//implementedBy=UnrestrictedName
		public Assignment getImplementedByAssignment_5_1() { return cImplementedByAssignment_5_1; }

		//UnrestrictedName
		public RuleCall getImplementedByUnrestrictedNameParserRuleCall_5_1_0() { return cImplementedByUnrestrictedNameParserRuleCall_5_1_0; }

		//('default_values' '{' ownedDefaultValues+=DefaultValueCS+ '}')?
		public Group getGroup_6() { return cGroup_6; }

		//'default_values'
		public Keyword getDefault_valuesKeyword_6_0() { return cDefault_valuesKeyword_6_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_6_1() { return cLeftCurlyBracketKeyword_6_1; }

		//ownedDefaultValues+=DefaultValueCS+
		public Assignment getOwnedDefaultValuesAssignment_6_2() { return cOwnedDefaultValuesAssignment_6_2; }

		//DefaultValueCS
		public RuleCall getOwnedDefaultValuesDefaultValueCSParserRuleCall_6_2_0() { return cOwnedDefaultValuesDefaultValueCSParserRuleCall_6_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6_3() { return cRightCurlyBracketKeyword_6_3; }

		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}

	public class DomainPatternCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.DomainPatternCS");
		private final Assignment cOwnedTemplateAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedTemplateTemplateCSParserRuleCall_0 = (RuleCall)cOwnedTemplateAssignment.eContents().get(0);

		//DomainPatternCS:
		//	ownedTemplate=TemplateCS;
		@Override public ParserRule getRule() { return rule; }

		//ownedTemplate=TemplateCS
		public Assignment getOwnedTemplateAssignment() { return cOwnedTemplateAssignment; }

		//TemplateCS
		public RuleCall getOwnedTemplateTemplateCSParserRuleCall_0() { return cOwnedTemplateTemplateCSParserRuleCall_0; }
	}

	public class ElementTemplateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ElementTemplateCS");
		private final Assignment cIdentifierAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cIdentifierSharedVariableCrossReference_0 = (CrossReference)cIdentifierAssignment.eContents().get(0);
		private final RuleCall cIdentifierSharedVariableUnrestrictedNameParserRuleCall_0_1 = (RuleCall)cIdentifierSharedVariableCrossReference_0.eContents().get(1);

		//ElementTemplateCS:
		//	identifier=[qvtrelation::SharedVariable|UnrestrictedName];
		@Override public ParserRule getRule() { return rule; }

		//identifier=[qvtrelation::SharedVariable|UnrestrictedName]
		public Assignment getIdentifierAssignment() { return cIdentifierAssignment; }

		//[qvtrelation::SharedVariable|UnrestrictedName]
		public CrossReference getIdentifierSharedVariableCrossReference_0() { return cIdentifierSharedVariableCrossReference_0; }

		//UnrestrictedName
		public RuleCall getIdentifierSharedVariableUnrestrictedNameParserRuleCall_0_1() { return cIdentifierSharedVariableUnrestrictedNameParserRuleCall_0_1; }
	}

	public class KeyDeclCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.KeyDeclCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cKeyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cPropertyIdsAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final CrossReference cPropertyIdsPropertyCrossReference_3_0_0 = (CrossReference)cPropertyIdsAssignment_3_0.eContents().get(0);
		private final RuleCall cPropertyIdsPropertyUnrestrictedNameParserRuleCall_3_0_0_1 = (RuleCall)cPropertyIdsPropertyCrossReference_3_0_0.eContents().get(1);
		private final Group cGroup_3_1 = (Group)cAlternatives_3.eContents().get(1);
		private final Keyword cOppositeKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3_1_1 = (Keyword)cGroup_3_1.eContents().get(1);
		private final Assignment cOwnedOppositePropertyIdsAssignment_3_1_2 = (Assignment)cGroup_3_1.eContents().get(2);
		private final RuleCall cOwnedOppositePropertyIdsPathNameCSParserRuleCall_3_1_2_0 = (RuleCall)cOwnedOppositePropertyIdsAssignment_3_1_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_1_3 = (Keyword)cGroup_3_1.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cPropertyIdsAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final CrossReference cPropertyIdsPropertyCrossReference_4_1_0_0 = (CrossReference)cPropertyIdsAssignment_4_1_0.eContents().get(0);
		private final RuleCall cPropertyIdsPropertyUnrestrictedNameParserRuleCall_4_1_0_0_1 = (RuleCall)cPropertyIdsPropertyCrossReference_4_1_0_0.eContents().get(1);
		private final Group cGroup_4_1_1 = (Group)cAlternatives_4_1.eContents().get(1);
		private final Keyword cOppositeKeyword_4_1_1_0 = (Keyword)cGroup_4_1_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_4_1_1_1 = (Keyword)cGroup_4_1_1.eContents().get(1);
		private final Assignment cOwnedOppositePropertyIdsAssignment_4_1_1_2 = (Assignment)cGroup_4_1_1.eContents().get(2);
		private final RuleCall cOwnedOppositePropertyIdsPathNameCSParserRuleCall_4_1_1_2_0 = (RuleCall)cOwnedOppositePropertyIdsAssignment_4_1_1_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_1_1_3 = (Keyword)cGroup_4_1_1.eContents().get(3);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);

		//KeyDeclCS:
		//	'key' ownedPathName=PathNameCS '{' (propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '('
		//	ownedOppositePropertyIds+=PathNameCS ')') (',' (propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '('
		//	ownedOppositePropertyIds+=PathNameCS ')'))* '}' ';';
		@Override public ParserRule getRule() { return rule; }

		//'key' ownedPathName=PathNameCS '{' (propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '('
		//ownedOppositePropertyIds+=PathNameCS ')') (',' (propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '('
		//ownedOppositePropertyIds+=PathNameCS ')'))* '}' ';'
		public Group getGroup() { return cGroup; }

		//'key'
		public Keyword getKeyKeyword_0() { return cKeyKeyword_0; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_1_0() { return cOwnedPathNamePathNameCSParserRuleCall_1_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//(propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '(' ownedOppositePropertyIds+=PathNameCS ')')
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//propertyIds+=[pivot::Property|UnrestrictedName]
		public Assignment getPropertyIdsAssignment_3_0() { return cPropertyIdsAssignment_3_0; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getPropertyIdsPropertyCrossReference_3_0_0() { return cPropertyIdsPropertyCrossReference_3_0_0; }

		//UnrestrictedName
		public RuleCall getPropertyIdsPropertyUnrestrictedNameParserRuleCall_3_0_0_1() { return cPropertyIdsPropertyUnrestrictedNameParserRuleCall_3_0_0_1; }

		//'opposite' '(' ownedOppositePropertyIds+=PathNameCS ')'
		public Group getGroup_3_1() { return cGroup_3_1; }

		//'opposite'
		public Keyword getOppositeKeyword_3_1_0() { return cOppositeKeyword_3_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_3_1_1() { return cLeftParenthesisKeyword_3_1_1; }

		//ownedOppositePropertyIds+=PathNameCS
		public Assignment getOwnedOppositePropertyIdsAssignment_3_1_2() { return cOwnedOppositePropertyIdsAssignment_3_1_2; }

		//PathNameCS
		public RuleCall getOwnedOppositePropertyIdsPathNameCSParserRuleCall_3_1_2_0() { return cOwnedOppositePropertyIdsPathNameCSParserRuleCall_3_1_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3_1_3() { return cRightParenthesisKeyword_3_1_3; }

		//(',' (propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '(' ownedOppositePropertyIds+=PathNameCS ')'))*
		public Group getGroup_4() { return cGroup_4; }

		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//(propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '(' ownedOppositePropertyIds+=PathNameCS ')')
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }

		//propertyIds+=[pivot::Property|UnrestrictedName]
		public Assignment getPropertyIdsAssignment_4_1_0() { return cPropertyIdsAssignment_4_1_0; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getPropertyIdsPropertyCrossReference_4_1_0_0() { return cPropertyIdsPropertyCrossReference_4_1_0_0; }

		//UnrestrictedName
		public RuleCall getPropertyIdsPropertyUnrestrictedNameParserRuleCall_4_1_0_0_1() { return cPropertyIdsPropertyUnrestrictedNameParserRuleCall_4_1_0_0_1; }

		//'opposite' '(' ownedOppositePropertyIds+=PathNameCS ')'
		public Group getGroup_4_1_1() { return cGroup_4_1_1; }

		//'opposite'
		public Keyword getOppositeKeyword_4_1_1_0() { return cOppositeKeyword_4_1_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_4_1_1_1() { return cLeftParenthesisKeyword_4_1_1_1; }

		//ownedOppositePropertyIds+=PathNameCS
		public Assignment getOwnedOppositePropertyIdsAssignment_4_1_1_2() { return cOwnedOppositePropertyIdsAssignment_4_1_1_2; }

		//PathNameCS
		public RuleCall getOwnedOppositePropertyIdsPathNameCSParserRuleCall_4_1_1_2_0() { return cOwnedOppositePropertyIdsPathNameCSParserRuleCall_4_1_1_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_4_1_1_3() { return cRightParenthesisKeyword_4_1_1_3; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }

		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}

	public class ModelDeclCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ModelDeclCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cMetamodelIdsAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final CrossReference cMetamodelIdsNamespaceCrossReference_2_0_0 = (CrossReference)cMetamodelIdsAssignment_2_0.eContents().get(0);
		private final RuleCall cMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_0_0_1 = (RuleCall)cMetamodelIdsNamespaceCrossReference_2_0_0.eContents().get(1);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cMetamodelIdsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final CrossReference cMetamodelIdsNamespaceCrossReference_2_1_1_0 = (CrossReference)cMetamodelIdsAssignment_2_1_1.eContents().get(0);
		private final RuleCall cMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_1_1_0_1 = (RuleCall)cMetamodelIdsNamespaceCrossReference_2_1_1_0.eContents().get(1);
		private final Group cGroup_2_1_2 = (Group)cGroup_2_1.eContents().get(2);
		private final Keyword cCommaKeyword_2_1_2_0 = (Keyword)cGroup_2_1_2.eContents().get(0);
		private final Assignment cMetamodelIdsAssignment_2_1_2_1 = (Assignment)cGroup_2_1_2.eContents().get(1);
		private final CrossReference cMetamodelIdsNamespaceCrossReference_2_1_2_1_0 = (CrossReference)cMetamodelIdsAssignment_2_1_2_1.eContents().get(0);
		private final RuleCall cMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_1_2_1_0_1 = (RuleCall)cMetamodelIdsNamespaceCrossReference_2_1_2_1_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_2_1_3 = (Keyword)cGroup_2_1.eContents().get(3);

		//ModelDeclCS:
		//	name=UnrestrictedName ':' (metamodelIds+=[pivot::Namespace|UnrestrictedName] | '{'
		//	metamodelIds+=[pivot::Namespace|UnrestrictedName] (',' metamodelIds+=[pivot::Namespace|UnrestrictedName])* '}');
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ':' (metamodelIds+=[pivot::Namespace|UnrestrictedName] | '{'
		//metamodelIds+=[pivot::Namespace|UnrestrictedName] (',' metamodelIds+=[pivot::Namespace|UnrestrictedName])* '}')
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//(metamodelIds+=[pivot::Namespace|UnrestrictedName] | '{' metamodelIds+=[pivot::Namespace|UnrestrictedName] (','
		//metamodelIds+=[pivot::Namespace|UnrestrictedName])* '}')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//metamodelIds+=[pivot::Namespace|UnrestrictedName]
		public Assignment getMetamodelIdsAssignment_2_0() { return cMetamodelIdsAssignment_2_0; }

		//[pivot::Namespace|UnrestrictedName]
		public CrossReference getMetamodelIdsNamespaceCrossReference_2_0_0() { return cMetamodelIdsNamespaceCrossReference_2_0_0; }

		//UnrestrictedName
		public RuleCall getMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_0_0_1() { return cMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_0_0_1; }

		//'{' metamodelIds+=[pivot::Namespace|UnrestrictedName] (',' metamodelIds+=[pivot::Namespace|UnrestrictedName])* '}'
		public Group getGroup_2_1() { return cGroup_2_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2_1_0() { return cLeftCurlyBracketKeyword_2_1_0; }

		//metamodelIds+=[pivot::Namespace|UnrestrictedName]
		public Assignment getMetamodelIdsAssignment_2_1_1() { return cMetamodelIdsAssignment_2_1_1; }

		//[pivot::Namespace|UnrestrictedName]
		public CrossReference getMetamodelIdsNamespaceCrossReference_2_1_1_0() { return cMetamodelIdsNamespaceCrossReference_2_1_1_0; }

		//UnrestrictedName
		public RuleCall getMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_1_1_0_1() { return cMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_1_1_0_1; }

		//(',' metamodelIds+=[pivot::Namespace|UnrestrictedName])*
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//','
		public Keyword getCommaKeyword_2_1_2_0() { return cCommaKeyword_2_1_2_0; }

		//metamodelIds+=[pivot::Namespace|UnrestrictedName]
		public Assignment getMetamodelIdsAssignment_2_1_2_1() { return cMetamodelIdsAssignment_2_1_2_1; }

		//[pivot::Namespace|UnrestrictedName]
		public CrossReference getMetamodelIdsNamespaceCrossReference_2_1_2_1_0() { return cMetamodelIdsNamespaceCrossReference_2_1_2_1_0; }

		//UnrestrictedName
		public RuleCall getMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_1_2_1_0_1() { return cMetamodelIdsNamespaceUnrestrictedNameParserRuleCall_2_1_2_1_0_1; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_2_1_3() { return cRightCurlyBracketKeyword_2_1_3; }
	}

	public class ObjectTemplateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ObjectTemplateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypedRefCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cOwnedPropertyTemplatesAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final RuleCall cOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_0_0 = (RuleCall)cOwnedPropertyTemplatesAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cOwnedPropertyTemplatesAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_1_1_0 = (RuleCall)cOwnedPropertyTemplatesAssignment_4_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//ObjectTemplateCS:
		//	name=UnrestrictedName? ':' ownedType=TypedRefCS '{' (ownedPropertyTemplates+=PropertyTemplateCS (','
		//	ownedPropertyTemplates+=PropertyTemplateCS)*)? '}';
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName? ':' ownedType=TypedRefCS '{' (ownedPropertyTemplates+=PropertyTemplateCS (','
		//ownedPropertyTemplates+=PropertyTemplateCS)*)? '}'
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName?
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypedRefCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypedRefCS
		public RuleCall getOwnedTypeTypedRefCSParserRuleCall_2_0() { return cOwnedTypeTypedRefCSParserRuleCall_2_0; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }

		//(ownedPropertyTemplates+=PropertyTemplateCS (',' ownedPropertyTemplates+=PropertyTemplateCS)*)?
		public Group getGroup_4() { return cGroup_4; }

		//ownedPropertyTemplates+=PropertyTemplateCS
		public Assignment getOwnedPropertyTemplatesAssignment_4_0() { return cOwnedPropertyTemplatesAssignment_4_0; }

		//PropertyTemplateCS
		public RuleCall getOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_0_0() { return cOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_0_0; }

		//(',' ownedPropertyTemplates+=PropertyTemplateCS)*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//ownedPropertyTemplates+=PropertyTemplateCS
		public Assignment getOwnedPropertyTemplatesAssignment_4_1_1() { return cOwnedPropertyTemplatesAssignment_4_1_1; }

		//PropertyTemplateCS
		public RuleCall getOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_1_1_0() { return cOwnedPropertyTemplatesPropertyTemplateCSParserRuleCall_4_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class ParamDeclarationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ParamDeclarationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedTypeTypedRefCSParserRuleCall_2_0 = (RuleCall)cOwnedTypeAssignment_2.eContents().get(0);

		//ParamDeclarationCS:
		//	name=UnrestrictedName ':' ownedType=TypedRefCS;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName ':' ownedType=TypedRefCS
		public Group getGroup() { return cGroup; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0_0() { return cNameUnrestrictedNameParserRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//ownedType=TypedRefCS
		public Assignment getOwnedTypeAssignment_2() { return cOwnedTypeAssignment_2; }

		//TypedRefCS
		public RuleCall getOwnedTypeTypedRefCSParserRuleCall_2_0() { return cOwnedTypeTypedRefCSParserRuleCall_2_0; }
	}

	public class PredicateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PredicateCS");
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

	public class PrimitiveTypeDomainCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PrimitiveTypeDomainCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPrimitiveKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cDomainKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedTypeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedTypeTypedRefCSParserRuleCall_4_0 = (RuleCall)cOwnedTypeAssignment_4.eContents().get(0);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);

		//PrimitiveTypeDomainCS:
		//	'primitive' 'domain' name=UnrestrictedName ':' ownedType=TypedRefCS ';';
		@Override public ParserRule getRule() { return rule; }

		//'primitive' 'domain' name=UnrestrictedName ':' ownedType=TypedRefCS ';'
		public Group getGroup() { return cGroup; }

		//'primitive'
		public Keyword getPrimitiveKeyword_0() { return cPrimitiveKeyword_0; }

		//'domain'
		public Keyword getDomainKeyword_1() { return cDomainKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//ownedType=TypedRefCS
		public Assignment getOwnedTypeAssignment_4() { return cOwnedTypeAssignment_4; }

		//TypedRefCS
		public RuleCall getOwnedTypeTypedRefCSParserRuleCall_4_0() { return cOwnedTypeTypedRefCSParserRuleCall_4_0; }

		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}

	public class PropertyTemplateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.PropertyTemplateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cPropertyIdAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final CrossReference cPropertyIdPropertyCrossReference_0_0_0 = (CrossReference)cPropertyIdAssignment_0_0.eContents().get(0);
		private final RuleCall cPropertyIdPropertyUnrestrictedNameParserRuleCall_0_0_0_1 = (RuleCall)cPropertyIdPropertyCrossReference_0_0_0.eContents().get(1);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Keyword cOppositeKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_1_1 = (Keyword)cGroup_0_1.eContents().get(1);
		private final Assignment cOwnedOppositePropertyIdAssignment_0_1_2 = (Assignment)cGroup_0_1.eContents().get(2);
		private final RuleCall cOwnedOppositePropertyIdPathNameCSParserRuleCall_0_1_2_0 = (RuleCall)cOwnedOppositePropertyIdAssignment_0_1_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_1_3 = (Keyword)cGroup_0_1.eContents().get(3);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedExpressionExpCSOrTemplateCSParserRuleCall_2_0 = (RuleCall)cOwnedExpressionAssignment_2.eContents().get(0);

		//PropertyTemplateCS:
		//	(propertyId=[pivot::Property|UnrestrictedName] | 'opposite' '(' ownedOppositePropertyId=PathNameCS ')') '='
		//	ownedExpression=ExpCSOrTemplateCS;
		@Override public ParserRule getRule() { return rule; }

		//(propertyId=[pivot::Property|UnrestrictedName] | 'opposite' '(' ownedOppositePropertyId=PathNameCS ')') '='
		//ownedExpression=ExpCSOrTemplateCS
		public Group getGroup() { return cGroup; }

		//(propertyId=[pivot::Property|UnrestrictedName] | 'opposite' '(' ownedOppositePropertyId=PathNameCS ')')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//propertyId=[pivot::Property|UnrestrictedName]
		public Assignment getPropertyIdAssignment_0_0() { return cPropertyIdAssignment_0_0; }

		//[pivot::Property|UnrestrictedName]
		public CrossReference getPropertyIdPropertyCrossReference_0_0_0() { return cPropertyIdPropertyCrossReference_0_0_0; }

		//UnrestrictedName
		public RuleCall getPropertyIdPropertyUnrestrictedNameParserRuleCall_0_0_0_1() { return cPropertyIdPropertyUnrestrictedNameParserRuleCall_0_0_0_1; }

		//'opposite' '(' ownedOppositePropertyId=PathNameCS ')'
		public Group getGroup_0_1() { return cGroup_0_1; }

		//'opposite'
		public Keyword getOppositeKeyword_0_1_0() { return cOppositeKeyword_0_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_0_1_1() { return cLeftParenthesisKeyword_0_1_1; }

		//ownedOppositePropertyId=PathNameCS
		public Assignment getOwnedOppositePropertyIdAssignment_0_1_2() { return cOwnedOppositePropertyIdAssignment_0_1_2; }

		//PathNameCS
		public RuleCall getOwnedOppositePropertyIdPathNameCSParserRuleCall_0_1_2_0() { return cOwnedOppositePropertyIdPathNameCSParserRuleCall_0_1_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_0_1_3() { return cRightParenthesisKeyword_0_1_3; }

		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//ownedExpression=ExpCSOrTemplateCS
		public Assignment getOwnedExpressionAssignment_2() { return cOwnedExpressionAssignment_2; }

		//ExpCSOrTemplateCS
		public RuleCall getOwnedExpressionExpCSOrTemplateCSParserRuleCall_2_0() { return cOwnedExpressionExpCSOrTemplateCSParserRuleCall_2_0; }
	}

	public class QueryCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.QueryCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsTransientAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsTransientTransientKeyword_0_0 = (Keyword)cIsTransientAssignment_0.eContents().get(0);
		private final Keyword cQueryKeyword_1 = (Keyword)cGroup.eContents().get(1);
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
		private final RuleCall cOwnedTypeTypedRefCSParserRuleCall_7_0 = (RuleCall)cOwnedTypeAssignment_7.eContents().get(0);
		private final Alternatives cAlternatives_8 = (Alternatives)cGroup.eContents().get(8);
		private final Keyword cSemicolonKeyword_8_0 = (Keyword)cAlternatives_8.eContents().get(0);
		private final Group cGroup_8_1 = (Group)cAlternatives_8.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_8_1_0 = (Keyword)cGroup_8_1.eContents().get(0);
		private final Assignment cOwnedExpressionAssignment_8_1_1 = (Assignment)cGroup_8_1.eContents().get(1);
		private final RuleCall cOwnedExpressionExpCSParserRuleCall_8_1_1_0 = (RuleCall)cOwnedExpressionAssignment_8_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8_1_2 = (Keyword)cGroup_8_1.eContents().get(2);

		//QueryCS:
		//	isTransient?='transient'? 'query' name=UnrestrictedName '(' (ownedParameters+=ParamDeclarationCS (','
		//	ownedParameters+=ParamDeclarationCS)*)? ')' ':' ownedType=TypedRefCS (';' | '{' ownedExpression=ExpCS '}');
		@Override public ParserRule getRule() { return rule; }

		//isTransient?='transient'? 'query' name=UnrestrictedName '(' (ownedParameters+=ParamDeclarationCS (','
		//ownedParameters+=ParamDeclarationCS)*)? ')' ':' ownedType=TypedRefCS (';' | '{' ownedExpression=ExpCS '}')
		public Group getGroup() { return cGroup; }

		//isTransient?='transient'?
		public Assignment getIsTransientAssignment_0() { return cIsTransientAssignment_0; }

		//'transient'
		public Keyword getIsTransientTransientKeyword_0_0() { return cIsTransientTransientKeyword_0_0; }

		//'query'
		public Keyword getQueryKeyword_1() { return cQueryKeyword_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//(ownedParameters+=ParamDeclarationCS (',' ownedParameters+=ParamDeclarationCS)*)?
		public Group getGroup_4() { return cGroup_4; }

		//ownedParameters+=ParamDeclarationCS
		public Assignment getOwnedParametersAssignment_4_0() { return cOwnedParametersAssignment_4_0; }

		//ParamDeclarationCS
		public RuleCall getOwnedParametersParamDeclarationCSParserRuleCall_4_0_0() { return cOwnedParametersParamDeclarationCSParserRuleCall_4_0_0; }

		//(',' ownedParameters+=ParamDeclarationCS)*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//ownedParameters+=ParamDeclarationCS
		public Assignment getOwnedParametersAssignment_4_1_1() { return cOwnedParametersAssignment_4_1_1; }

		//ParamDeclarationCS
		public RuleCall getOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0() { return cOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//':'
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }

		//ownedType=TypedRefCS
		public Assignment getOwnedTypeAssignment_7() { return cOwnedTypeAssignment_7; }

		//TypedRefCS
		public RuleCall getOwnedTypeTypedRefCSParserRuleCall_7_0() { return cOwnedTypeTypedRefCSParserRuleCall_7_0; }

		//(';' | '{' ownedExpression=ExpCS '}')
		public Alternatives getAlternatives_8() { return cAlternatives_8; }

		//';'
		public Keyword getSemicolonKeyword_8_0() { return cSemicolonKeyword_8_0; }

		//'{' ownedExpression=ExpCS '}'
		public Group getGroup_8_1() { return cGroup_8_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_8_1_0() { return cLeftCurlyBracketKeyword_8_1_0; }

		//ownedExpression=ExpCS
		public Assignment getOwnedExpressionAssignment_8_1_1() { return cOwnedExpressionAssignment_8_1_1; }

		//ExpCS
		public RuleCall getOwnedExpressionExpCSParserRuleCall_8_1_1_0() { return cOwnedExpressionExpCSParserRuleCall_8_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_8_1_2() { return cRightCurlyBracketKeyword_8_1_2; }
	}

	public class RelationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.RelationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsTopAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsTopTopKeyword_0_0 = (Keyword)cIsTopAssignment_0.eContents().get(0);
		private final Assignment cIsDefaultAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsDefaultDefaultKeyword_1_0 = (Keyword)cIsDefaultAssignment_1.eContents().get(0);
		private final Keyword cRelationKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cOverridesKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOverridesAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cOverridesRelationCrossReference_4_1_0 = (CrossReference)cOverridesAssignment_4_1.eContents().get(0);
		private final RuleCall cOverridesRelationUnrestrictedNameParserRuleCall_4_1_0_1 = (RuleCall)cOverridesRelationCrossReference_4_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cOwnedVarDeclarationsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedVarDeclarationsVarDeclarationCSParserRuleCall_6_0 = (RuleCall)cOwnedVarDeclarationsAssignment_6.eContents().get(0);
		private final Alternatives cAlternatives_7 = (Alternatives)cGroup.eContents().get(7);
		private final Assignment cOwnedDomainsAssignment_7_0 = (Assignment)cAlternatives_7.eContents().get(0);
		private final RuleCall cOwnedDomainsDomainCSParserRuleCall_7_0_0 = (RuleCall)cOwnedDomainsAssignment_7_0.eContents().get(0);
		private final Assignment cOwnedDomainsAssignment_7_1 = (Assignment)cAlternatives_7.eContents().get(1);
		private final RuleCall cOwnedDomainsPrimitiveTypeDomainCSParserRuleCall_7_1_0 = (RuleCall)cOwnedDomainsAssignment_7_1.eContents().get(0);
		private final Assignment cOwnedWhenAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cOwnedWhenWhenCSParserRuleCall_8_0 = (RuleCall)cOwnedWhenAssignment_8.eContents().get(0);
		private final Assignment cOwnedWhereAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cOwnedWhereWhereCSParserRuleCall_9_0 = (RuleCall)cOwnedWhereAssignment_9.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);

		//RelationCS:
		//	isTop?='top'? isDefault?='default'? 'relation' name=UnrestrictedName ('overrides'
		//	overrides=[qvtrelation::Relation|UnrestrictedName])? '{' ownedVarDeclarations+=VarDeclarationCS*
		//	(ownedDomains+=DomainCS | ownedDomains+=PrimitiveTypeDomainCS)+ ownedWhen=WhenCS? ownedWhere=WhereCS? '}';
		@Override public ParserRule getRule() { return rule; }

		//isTop?='top'? isDefault?='default'? 'relation' name=UnrestrictedName ('overrides'
		//overrides=[qvtrelation::Relation|UnrestrictedName])? '{' ownedVarDeclarations+=VarDeclarationCS*
		//(ownedDomains+=DomainCS | ownedDomains+=PrimitiveTypeDomainCS)+ ownedWhen=WhenCS? ownedWhere=WhereCS? '}'
		public Group getGroup() { return cGroup; }

		//isTop?='top'?
		public Assignment getIsTopAssignment_0() { return cIsTopAssignment_0; }

		//'top'
		public Keyword getIsTopTopKeyword_0_0() { return cIsTopTopKeyword_0_0; }

		//isDefault?='default'?
		public Assignment getIsDefaultAssignment_1() { return cIsDefaultAssignment_1; }

		//'default'
		public Keyword getIsDefaultDefaultKeyword_1_0() { return cIsDefaultDefaultKeyword_1_0; }

		//'relation'
		public Keyword getRelationKeyword_2() { return cRelationKeyword_2; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_3_0() { return cNameUnrestrictedNameParserRuleCall_3_0; }

		//('overrides' overrides=[qvtrelation::Relation|UnrestrictedName])?
		public Group getGroup_4() { return cGroup_4; }

		//'overrides'
		public Keyword getOverridesKeyword_4_0() { return cOverridesKeyword_4_0; }

		//overrides=[qvtrelation::Relation|UnrestrictedName]
		public Assignment getOverridesAssignment_4_1() { return cOverridesAssignment_4_1; }

		//[qvtrelation::Relation|UnrestrictedName]
		public CrossReference getOverridesRelationCrossReference_4_1_0() { return cOverridesRelationCrossReference_4_1_0; }

		//UnrestrictedName
		public RuleCall getOverridesRelationUnrestrictedNameParserRuleCall_4_1_0_1() { return cOverridesRelationUnrestrictedNameParserRuleCall_4_1_0_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }

		//ownedVarDeclarations+=VarDeclarationCS*
		public Assignment getOwnedVarDeclarationsAssignment_6() { return cOwnedVarDeclarationsAssignment_6; }

		//VarDeclarationCS
		public RuleCall getOwnedVarDeclarationsVarDeclarationCSParserRuleCall_6_0() { return cOwnedVarDeclarationsVarDeclarationCSParserRuleCall_6_0; }

		//(ownedDomains+=DomainCS | ownedDomains+=PrimitiveTypeDomainCS)+
		public Alternatives getAlternatives_7() { return cAlternatives_7; }

		//ownedDomains+=DomainCS
		public Assignment getOwnedDomainsAssignment_7_0() { return cOwnedDomainsAssignment_7_0; }

		//DomainCS
		public RuleCall getOwnedDomainsDomainCSParserRuleCall_7_0_0() { return cOwnedDomainsDomainCSParserRuleCall_7_0_0; }

		//ownedDomains+=PrimitiveTypeDomainCS
		public Assignment getOwnedDomainsAssignment_7_1() { return cOwnedDomainsAssignment_7_1; }

		//PrimitiveTypeDomainCS
		public RuleCall getOwnedDomainsPrimitiveTypeDomainCSParserRuleCall_7_1_0() { return cOwnedDomainsPrimitiveTypeDomainCSParserRuleCall_7_1_0; }

		//ownedWhen=WhenCS?
		public Assignment getOwnedWhenAssignment_8() { return cOwnedWhenAssignment_8; }

		//WhenCS
		public RuleCall getOwnedWhenWhenCSParserRuleCall_8_0() { return cOwnedWhenWhenCSParserRuleCall_8_0; }

		//ownedWhere=WhereCS?
		public Assignment getOwnedWhereAssignment_9() { return cOwnedWhereAssignment_9; }

		//WhereCS
		public RuleCall getOwnedWhereWhereCSParserRuleCall_9_0() { return cOwnedWhereWhereCSParserRuleCall_9_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}

	public class ScopeNameCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ScopeNameCS");
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

	public class TemplateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TemplateCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cCollectionTemplateCSParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cObjectTemplateCSParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedGuardExpressionAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedGuardExpressionExpCSParserRuleCall_1_1_0 = (RuleCall)cOwnedGuardExpressionAssignment_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);

		//TemplateCS:
		//	(CollectionTemplateCS | ObjectTemplateCS) ('{' ownedGuardExpression=ExpCS '}')?;
		@Override public ParserRule getRule() { return rule; }

		//(CollectionTemplateCS | ObjectTemplateCS) ('{' ownedGuardExpression=ExpCS '}')?
		public Group getGroup() { return cGroup; }

		//(CollectionTemplateCS | ObjectTemplateCS)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//CollectionTemplateCS
		public RuleCall getCollectionTemplateCSParserRuleCall_0_0() { return cCollectionTemplateCSParserRuleCall_0_0; }

		//ObjectTemplateCS
		public RuleCall getObjectTemplateCSParserRuleCall_0_1() { return cObjectTemplateCSParserRuleCall_0_1; }

		//('{' ownedGuardExpression=ExpCS '}')?
		public Group getGroup_1() { return cGroup_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_1_0() { return cLeftCurlyBracketKeyword_1_0; }

		//ownedGuardExpression=ExpCS
		public Assignment getOwnedGuardExpressionAssignment_1_1() { return cOwnedGuardExpressionAssignment_1_1; }

		//ExpCS
		public RuleCall getOwnedGuardExpressionExpCSParserRuleCall_1_1_0() { return cOwnedGuardExpressionExpCSParserRuleCall_1_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_1_2() { return cRightCurlyBracketKeyword_1_2; }
	}

	public class TransformationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TransformationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTransformationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedPathNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPathNameScopeNameCSParserRuleCall_1_0 = (RuleCall)cOwnedPathNameAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedModelDeclsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedModelDeclsModelDeclCSParserRuleCall_4_0 = (RuleCall)cOwnedModelDeclsAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCommaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cOwnedModelDeclsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cOwnedModelDeclsModelDeclCSParserRuleCall_5_1_0 = (RuleCall)cOwnedModelDeclsAssignment_5_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cExtendsKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cExtendsAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final CrossReference cExtendsTransformationCrossReference_7_1_0 = (CrossReference)cExtendsAssignment_7_1.eContents().get(0);
		private final RuleCall cExtendsTransformationUnrestrictedNameParserRuleCall_7_1_0_1 = (RuleCall)cExtendsTransformationCrossReference_7_1_0.eContents().get(1);
		private final Group cGroup_7_2 = (Group)cGroup_7.eContents().get(2);
		private final Keyword cCommaKeyword_7_2_0 = (Keyword)cGroup_7_2.eContents().get(0);
		private final Assignment cExtendsAssignment_7_2_1 = (Assignment)cGroup_7_2.eContents().get(1);
		private final CrossReference cExtendsTransformationCrossReference_7_2_1_0 = (CrossReference)cExtendsAssignment_7_2_1.eContents().get(0);
		private final RuleCall cExtendsTransformationUnrestrictedNameParserRuleCall_7_2_1_0_1 = (RuleCall)cExtendsTransformationCrossReference_7_2_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cOwnedKeyDeclsAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cOwnedKeyDeclsKeyDeclCSParserRuleCall_9_0 = (RuleCall)cOwnedKeyDeclsAssignment_9.eContents().get(0);
		private final Alternatives cAlternatives_10 = (Alternatives)cGroup.eContents().get(10);
		private final Assignment cOwnedRelationsAssignment_10_0 = (Assignment)cAlternatives_10.eContents().get(0);
		private final RuleCall cOwnedRelationsRelationCSParserRuleCall_10_0_0 = (RuleCall)cOwnedRelationsAssignment_10_0.eContents().get(0);
		private final Assignment cOwnedQueriesAssignment_10_1 = (Assignment)cAlternatives_10.eContents().get(1);
		private final RuleCall cOwnedQueriesQueryCSParserRuleCall_10_1_0 = (RuleCall)cOwnedQueriesAssignment_10_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_11 = (Keyword)cGroup.eContents().get(11);

		//TransformationCS:
		//	'transformation' ownedPathName=ScopeNameCS? name=UnrestrictedName '(' ownedModelDecls+=ModelDeclCS (','
		//	ownedModelDecls+=ModelDeclCS)* ')' ('extends' extends+=[qvtbase::Transformation|UnrestrictedName] (','
		//	extends+=[qvtbase::Transformation|UnrestrictedName])*)? '{' ownedKeyDecls+=KeyDeclCS* (ownedRelations+=RelationCS |
		//	ownedQueries+=QueryCS)* '}';
		@Override public ParserRule getRule() { return rule; }

		//'transformation' ownedPathName=ScopeNameCS? name=UnrestrictedName '(' ownedModelDecls+=ModelDeclCS (','
		//ownedModelDecls+=ModelDeclCS)* ')' ('extends' extends+=[qvtbase::Transformation|UnrestrictedName] (','
		//extends+=[qvtbase::Transformation|UnrestrictedName])*)? '{' ownedKeyDecls+=KeyDeclCS* (ownedRelations+=RelationCS |
		//ownedQueries+=QueryCS)* '}'
		public Group getGroup() { return cGroup; }

		//'transformation'
		public Keyword getTransformationKeyword_0() { return cTransformationKeyword_0; }

		//ownedPathName=ScopeNameCS?
		public Assignment getOwnedPathNameAssignment_1() { return cOwnedPathNameAssignment_1; }

		//ScopeNameCS
		public RuleCall getOwnedPathNameScopeNameCSParserRuleCall_1_0() { return cOwnedPathNameScopeNameCSParserRuleCall_1_0; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_2_0() { return cNameUnrestrictedNameParserRuleCall_2_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//ownedModelDecls+=ModelDeclCS
		public Assignment getOwnedModelDeclsAssignment_4() { return cOwnedModelDeclsAssignment_4; }

		//ModelDeclCS
		public RuleCall getOwnedModelDeclsModelDeclCSParserRuleCall_4_0() { return cOwnedModelDeclsModelDeclCSParserRuleCall_4_0; }

		//(',' ownedModelDecls+=ModelDeclCS)*
		public Group getGroup_5() { return cGroup_5; }

		//','
		public Keyword getCommaKeyword_5_0() { return cCommaKeyword_5_0; }

		//ownedModelDecls+=ModelDeclCS
		public Assignment getOwnedModelDeclsAssignment_5_1() { return cOwnedModelDeclsAssignment_5_1; }

		//ModelDeclCS
		public RuleCall getOwnedModelDeclsModelDeclCSParserRuleCall_5_1_0() { return cOwnedModelDeclsModelDeclCSParserRuleCall_5_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }

		//('extends' extends+=[qvtbase::Transformation|UnrestrictedName] (','
		//extends+=[qvtbase::Transformation|UnrestrictedName])*)?
		public Group getGroup_7() { return cGroup_7; }

		//'extends'
		public Keyword getExtendsKeyword_7_0() { return cExtendsKeyword_7_0; }

		//extends+=[qvtbase::Transformation|UnrestrictedName]
		public Assignment getExtendsAssignment_7_1() { return cExtendsAssignment_7_1; }

		//[qvtbase::Transformation|UnrestrictedName]
		public CrossReference getExtendsTransformationCrossReference_7_1_0() { return cExtendsTransformationCrossReference_7_1_0; }

		//UnrestrictedName
		public RuleCall getExtendsTransformationUnrestrictedNameParserRuleCall_7_1_0_1() { return cExtendsTransformationUnrestrictedNameParserRuleCall_7_1_0_1; }

		//(',' extends+=[qvtbase::Transformation|UnrestrictedName])*
		public Group getGroup_7_2() { return cGroup_7_2; }

		//','
		public Keyword getCommaKeyword_7_2_0() { return cCommaKeyword_7_2_0; }

		//extends+=[qvtbase::Transformation|UnrestrictedName]
		public Assignment getExtendsAssignment_7_2_1() { return cExtendsAssignment_7_2_1; }

		//[qvtbase::Transformation|UnrestrictedName]
		public CrossReference getExtendsTransformationCrossReference_7_2_1_0() { return cExtendsTransformationCrossReference_7_2_1_0; }

		//UnrestrictedName
		public RuleCall getExtendsTransformationUnrestrictedNameParserRuleCall_7_2_1_0_1() { return cExtendsTransformationUnrestrictedNameParserRuleCall_7_2_1_0_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_8() { return cLeftCurlyBracketKeyword_8; }

		//ownedKeyDecls+=KeyDeclCS*
		public Assignment getOwnedKeyDeclsAssignment_9() { return cOwnedKeyDeclsAssignment_9; }

		//KeyDeclCS
		public RuleCall getOwnedKeyDeclsKeyDeclCSParserRuleCall_9_0() { return cOwnedKeyDeclsKeyDeclCSParserRuleCall_9_0; }

		//(ownedRelations+=RelationCS | ownedQueries+=QueryCS)*
		public Alternatives getAlternatives_10() { return cAlternatives_10; }

		//ownedRelations+=RelationCS
		public Assignment getOwnedRelationsAssignment_10_0() { return cOwnedRelationsAssignment_10_0; }

		//RelationCS
		public RuleCall getOwnedRelationsRelationCSParserRuleCall_10_0_0() { return cOwnedRelationsRelationCSParserRuleCall_10_0_0; }

		//ownedQueries+=QueryCS
		public Assignment getOwnedQueriesAssignment_10_1() { return cOwnedQueriesAssignment_10_1; }

		//QueryCS
		public RuleCall getOwnedQueriesQueryCSParserRuleCall_10_1_0() { return cOwnedQueriesQueryCSParserRuleCall_10_1_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_11() { return cRightCurlyBracketKeyword_11; }
	}

	public class UnitCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnitCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_1_0_0 = (RuleCall)cNameAssignment_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOwnedPathNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedPathNameURIPathNameCSParserRuleCall_2_0 = (RuleCall)cOwnedPathNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cIsAllAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final Keyword cIsAllAsteriskKeyword_3_1_0 = (Keyword)cIsAllAssignment_3_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//UnitCS base::ImportCS:
		//	'import' (name=UnrestrictedName ':')? ownedPathName=URIPathNameCS ('::' isAll?='*')? ';'
		@Override public ParserRule getRule() { return rule; }

		//'import' (name=UnrestrictedName ':')? ownedPathName=URIPathNameCS ('::' isAll?='*')? ';'
		public Group getGroup() { return cGroup; }

		//'import'
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }

		//(name=UnrestrictedName ':')?
		public Group getGroup_1() { return cGroup_1; }

		//name=UnrestrictedName
		public Assignment getNameAssignment_1_0() { return cNameAssignment_1_0; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_1_0_0() { return cNameUnrestrictedNameParserRuleCall_1_0_0; }

		//':'
		public Keyword getColonKeyword_1_1() { return cColonKeyword_1_1; }

		//ownedPathName=URIPathNameCS
		public Assignment getOwnedPathNameAssignment_2() { return cOwnedPathNameAssignment_2; }

		//URIPathNameCS
		public RuleCall getOwnedPathNameURIPathNameCSParserRuleCall_2_0() { return cOwnedPathNameURIPathNameCSParserRuleCall_2_0; }

		//('::' isAll?='*')?
		public Group getGroup_3() { return cGroup_3; }

		//'::'
		public Keyword getColonColonKeyword_3_0() { return cColonColonKeyword_3_0; }

		//isAll?='*'
		public Assignment getIsAllAssignment_3_1() { return cIsAllAssignment_3_1; }

		//'*'
		public Keyword getIsAllAsteriskKeyword_3_1_0() { return cIsAllAsteriskKeyword_3_1_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class VarDeclarationCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.VarDeclarationCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedVarDeclarationIdsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_0_0 = (RuleCall)cOwnedVarDeclarationIdsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cOwnedVarDeclarationIdsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_1_1_0 = (RuleCall)cOwnedVarDeclarationIdsAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cOwnedTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedTypeTypedRefCSParserRuleCall_2_1_0 = (RuleCall)cOwnedTypeAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cOwnedInitExpressionAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cOwnedInitExpressionExpCSParserRuleCall_3_1_0 = (RuleCall)cOwnedInitExpressionAssignment_3_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//VarDeclarationCS:
		//	ownedVarDeclarationIds+=VarDeclarationIdCS (',' ownedVarDeclarationIds+=VarDeclarationIdCS)* (':'
		//	ownedType=TypedRefCS)? ('=' ownedInitExpression=ExpCS)? ';';
		@Override public ParserRule getRule() { return rule; }

		//ownedVarDeclarationIds+=VarDeclarationIdCS (',' ownedVarDeclarationIds+=VarDeclarationIdCS)* (':' ownedType=TypedRefCS)?
		//('=' ownedInitExpression=ExpCS)? ';'
		public Group getGroup() { return cGroup; }

		//ownedVarDeclarationIds+=VarDeclarationIdCS
		public Assignment getOwnedVarDeclarationIdsAssignment_0() { return cOwnedVarDeclarationIdsAssignment_0; }

		//VarDeclarationIdCS
		public RuleCall getOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_0_0() { return cOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_0_0; }

		//(',' ownedVarDeclarationIds+=VarDeclarationIdCS)*
		public Group getGroup_1() { return cGroup_1; }

		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//ownedVarDeclarationIds+=VarDeclarationIdCS
		public Assignment getOwnedVarDeclarationIdsAssignment_1_1() { return cOwnedVarDeclarationIdsAssignment_1_1; }

		//VarDeclarationIdCS
		public RuleCall getOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_1_1_0() { return cOwnedVarDeclarationIdsVarDeclarationIdCSParserRuleCall_1_1_0; }

		//(':' ownedType=TypedRefCS)?
		public Group getGroup_2() { return cGroup_2; }

		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//ownedType=TypedRefCS
		public Assignment getOwnedTypeAssignment_2_1() { return cOwnedTypeAssignment_2_1; }

		//TypedRefCS
		public RuleCall getOwnedTypeTypedRefCSParserRuleCall_2_1_0() { return cOwnedTypeTypedRefCSParserRuleCall_2_1_0; }

		//('=' ownedInitExpression=ExpCS)?
		public Group getGroup_3() { return cGroup_3; }

		//'='
		public Keyword getEqualsSignKeyword_3_0() { return cEqualsSignKeyword_3_0; }

		//ownedInitExpression=ExpCS
		public Assignment getOwnedInitExpressionAssignment_3_1() { return cOwnedInitExpressionAssignment_3_1; }

		//ExpCS
		public RuleCall getOwnedInitExpressionExpCSParserRuleCall_3_1_0() { return cOwnedInitExpressionExpCSParserRuleCall_3_1_0; }

		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class VarDeclarationIdCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.VarDeclarationIdCS");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameUnrestrictedNameParserRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);

		//VarDeclarationIdCS:
		//	name=UnrestrictedName;
		@Override public ParserRule getRule() { return rule; }

		//name=UnrestrictedName
		public Assignment getNameAssignment() { return cNameAssignment; }

		//UnrestrictedName
		public RuleCall getNameUnrestrictedNameParserRuleCall_0() { return cNameUnrestrictedNameParserRuleCall_0; }
	}

	public class WhenCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.WhenCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cWhenKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedPredicatesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedPredicatesPredicateCSParserRuleCall_3_0 = (RuleCall)cOwnedPredicatesAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//WhenCS PatternCS:
		//	{PatternCS} 'when' '{' ownedPredicates+=PredicateCS* '}'
		@Override public ParserRule getRule() { return rule; }

		//{PatternCS} 'when' '{' ownedPredicates+=PredicateCS* '}'
		public Group getGroup() { return cGroup; }

		//{PatternCS}
		public Action getPatternCSAction_0() { return cPatternCSAction_0; }

		//'when'
		public Keyword getWhenKeyword_1() { return cWhenKeyword_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//ownedPredicates+=PredicateCS*
		public Assignment getOwnedPredicatesAssignment_3() { return cOwnedPredicatesAssignment_3; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_3_0() { return cOwnedPredicatesPredicateCSParserRuleCall_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class WhereCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.WhereCS");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPatternCSAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cWhereKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedPredicatesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedPredicatesPredicateCSParserRuleCall_3_0 = (RuleCall)cOwnedPredicatesAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);

		//WhereCS PatternCS:
		//	{PatternCS} 'where' '{' ownedPredicates+=PredicateCS* '}'
		@Override public ParserRule getRule() { return rule; }

		//{PatternCS} 'where' '{' ownedPredicates+=PredicateCS* '}'
		public Group getGroup() { return cGroup; }

		//{PatternCS}
		public Action getPatternCSAction_0() { return cPatternCSAction_0; }

		//'where'
		public Keyword getWhereKeyword_1() { return cWhereKeyword_1; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//ownedPredicates+=PredicateCS*
		public Assignment getOwnedPredicatesAssignment_3() { return cOwnedPredicatesAssignment_3; }

		//PredicateCS
		public RuleCall getOwnedPredicatesPredicateCSParserRuleCall_3_0() { return cOwnedPredicatesPredicateCSParserRuleCall_3_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class ExpCSOrTemplateCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.ExpCSOrTemplateCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cExpCSParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTemplateCSParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);

		////<OCLExpressionCS> ::= <PropertyCallExpCS>
		// //                    | <VariableExpCS>
		//
		////                    | <LiteralExpCS>
		// //                    | <LetExpCS>
		// //                    | <IfExpCS>
		//
		////                    | '(' <OCLExpressionCS> ')'
		// //                    | <template>
		//
		////	notNameExpressionCS -> templateCS
		// ExpCSOrTemplateCS essentialocl::ExpCS:
		//	ExpCS | TemplateCS
		@Override public ParserRule getRule() { return rule; }

		//ExpCS | TemplateCS
		public Alternatives getAlternatives() { return cAlternatives; }

		//ExpCS
		public RuleCall getExpCSParserRuleCall_0() { return cExpCSParserRuleCall_0; }

		//TemplateCS
		public RuleCall getTemplateCSParserRuleCall_1() { return cTemplateCSParserRuleCall_1; }
	}

	public class TypedTypeRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedTypeRefCS");
		private final Assignment cOwnedPathNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedPathNamePathNameCSParserRuleCall_0 = (RuleCall)cOwnedPathNameAssignment.eContents().get(0);

		//TypedTypeRefCS base::TypedTypeRefCS:
		//	ownedPathName=PathNameCS
		@Override public ParserRule getRule() { return rule; }

		//ownedPathName=PathNameCS
		public Assignment getOwnedPathNameAssignment() { return cOwnedPathNameAssignment; }

		//PathNameCS
		public RuleCall getOwnedPathNamePathNameCSParserRuleCall_0() { return cOwnedPathNamePathNameCSParserRuleCall_0; }
	}

	public class TypedRefCSElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.TypedRefCS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cPrimitiveTypeCSParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_0_1_0 = (RuleCall)cOwnedMultiplicityAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final RuleCall cCollectionTypeCSParserRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_1_1_0 = (RuleCall)cOwnedMultiplicityAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final RuleCall cTypedTypeRefCSParserRuleCall_2_0 = (RuleCall)cGroup_2.eContents().get(0);
		private final Assignment cOwnedMultiplicityAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cOwnedMultiplicityMultiplicityCSParserRuleCall_2_1_0 = (RuleCall)cOwnedMultiplicityAssignment_2_1.eContents().get(0);

		//TypedRefCS base::TypedRefCS:
		//	PrimitiveTypeCS ownedMultiplicity=MultiplicityCS? | CollectionTypeCS ownedMultiplicity=MultiplicityCS? |
		//	TypedTypeRefCS ownedMultiplicity=MultiplicityCS?
		@Override public ParserRule getRule() { return rule; }

		//PrimitiveTypeCS ownedMultiplicity=MultiplicityCS? | CollectionTypeCS ownedMultiplicity=MultiplicityCS? | TypedTypeRefCS
		//ownedMultiplicity=MultiplicityCS?
		public Alternatives getAlternatives() { return cAlternatives; }

		//PrimitiveTypeCS ownedMultiplicity=MultiplicityCS?
		public Group getGroup_0() { return cGroup_0; }

		//PrimitiveTypeCS
		public RuleCall getPrimitiveTypeCSParserRuleCall_0_0() { return cPrimitiveTypeCSParserRuleCall_0_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_0_1() { return cOwnedMultiplicityAssignment_0_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_0_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_0_1_0; }

		//CollectionTypeCS ownedMultiplicity=MultiplicityCS?
		public Group getGroup_1() { return cGroup_1; }

		//CollectionTypeCS
		public RuleCall getCollectionTypeCSParserRuleCall_1_0() { return cCollectionTypeCSParserRuleCall_1_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_1_1() { return cOwnedMultiplicityAssignment_1_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_1_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_1_1_0; }

		//TypedTypeRefCS ownedMultiplicity=MultiplicityCS?
		public Group getGroup_2() { return cGroup_2; }

		//TypedTypeRefCS
		public RuleCall getTypedTypeRefCSParserRuleCall_2_0() { return cTypedTypeRefCSParserRuleCall_2_0; }

		//ownedMultiplicity=MultiplicityCS?
		public Assignment getOwnedMultiplicityAssignment_2_1() { return cOwnedMultiplicityAssignment_2_1; }

		//MultiplicityCS
		public RuleCall getOwnedMultiplicityMultiplicityCSParserRuleCall_2_1_0() { return cOwnedMultiplicityMultiplicityCSParserRuleCall_2_1_0; }
	}

	public class UnrestrictedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation.UnrestrictedName");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEssentialOCLUnrestrictedNameParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cCheckonlyKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cDefaultKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cDefault_valuesKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cDomainKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cEnforceKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cExtendsKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cImplementedbyKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cImportKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		private final Keyword cLibraryKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Keyword cKeyKeyword_10 = (Keyword)cAlternatives.eContents().get(10);
		private final Keyword cOppositeKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Keyword cOverridesKeyword_12 = (Keyword)cAlternatives.eContents().get(12);
		private final Keyword cPrimitiveKeyword_13 = (Keyword)cAlternatives.eContents().get(13);
		private final Keyword cQueryKeyword_14 = (Keyword)cAlternatives.eContents().get(14);
		private final Keyword cRelationKeyword_15 = (Keyword)cAlternatives.eContents().get(15);
		private final Keyword cReplaceKeyword_16 = (Keyword)cAlternatives.eContents().get(16);
		private final Keyword cTopKeyword_17 = (Keyword)cAlternatives.eContents().get(17);
		private final Keyword cTransformationKeyword_18 = (Keyword)cAlternatives.eContents().get(18);
		private final Keyword cWhenKeyword_19 = (Keyword)cAlternatives.eContents().get(19);
		private final Keyword cWhereKeyword_20 = (Keyword)cAlternatives.eContents().get(20);

		////ExpCS returns essentialocl::ExpCS:
		// //	InfixedExpCS
		// //|	TemplateCS;
		// UnrestrictedName:
		//	EssentialOCLUnrestrictedName | 'checkonly' | 'default' | 'default_values' | 'domain' | 'enforce' | 'extends' |
		//	'implementedby' | 'import' | 'library' | 'key' | 'opposite' | 'overrides' | 'primitive' | 'query' | 'relation' |
		//	'replace' | 'top' | 'transformation' | 'when' | 'where';
		@Override public ParserRule getRule() { return rule; }

		//EssentialOCLUnrestrictedName | 'checkonly' | 'default' | 'default_values' | 'domain' | 'enforce' | 'extends' |
		//'implementedby' | 'import' | 'library' | 'key' | 'opposite' | 'overrides' | 'primitive' | 'query' | 'relation' |
		//'replace' | 'top' | 'transformation' | 'when' | 'where'
		public Alternatives getAlternatives() { return cAlternatives; }

		//EssentialOCLUnrestrictedName
		public RuleCall getEssentialOCLUnrestrictedNameParserRuleCall_0() { return cEssentialOCLUnrestrictedNameParserRuleCall_0; }

		//'checkonly'
		public Keyword getCheckonlyKeyword_1() { return cCheckonlyKeyword_1; }

		//'default'
		public Keyword getDefaultKeyword_2() { return cDefaultKeyword_2; }

		//'default_values'
		public Keyword getDefault_valuesKeyword_3() { return cDefault_valuesKeyword_3; }

		//'domain'
		public Keyword getDomainKeyword_4() { return cDomainKeyword_4; }

		//'enforce'
		public Keyword getEnforceKeyword_5() { return cEnforceKeyword_5; }

		//'extends'
		public Keyword getExtendsKeyword_6() { return cExtendsKeyword_6; }

		//'implementedby'
		public Keyword getImplementedbyKeyword_7() { return cImplementedbyKeyword_7; }

		//'import'
		public Keyword getImportKeyword_8() { return cImportKeyword_8; }

		//'library'
		public Keyword getLibraryKeyword_9() { return cLibraryKeyword_9; }

		//'key'
		public Keyword getKeyKeyword_10() { return cKeyKeyword_10; }

		//'opposite'
		public Keyword getOppositeKeyword_11() { return cOppositeKeyword_11; }

		//'overrides'
		public Keyword getOverridesKeyword_12() { return cOverridesKeyword_12; }

		//'primitive'
		public Keyword getPrimitiveKeyword_13() { return cPrimitiveKeyword_13; }

		//'query'
		public Keyword getQueryKeyword_14() { return cQueryKeyword_14; }

		//'relation'
		public Keyword getRelationKeyword_15() { return cRelationKeyword_15; }

		//'replace'
		public Keyword getReplaceKeyword_16() { return cReplaceKeyword_16; }

		//'top'
		public Keyword getTopKeyword_17() { return cTopKeyword_17; }

		//'transformation'
		public Keyword getTransformationKeyword_18() { return cTransformationKeyword_18; }

		//'when'
		public Keyword getWhenKeyword_19() { return cWhenKeyword_19; }

		//'where'
		public Keyword getWhereKeyword_20() { return cWhereKeyword_20; }
	}


	private final TopLevelCSElements pTopLevelCS;
	private final QualifiedPackageCSElements pQualifiedPackageCS;
	private final CollectionTemplateCSElements pCollectionTemplateCS;
	private final DefaultValueCSElements pDefaultValueCS;
	private final DomainCSElements pDomainCS;
	private final DomainPatternCSElements pDomainPatternCS;
	private final ElementTemplateCSElements pElementTemplateCS;
	private final KeyDeclCSElements pKeyDeclCS;
	private final ModelDeclCSElements pModelDeclCS;
	private final ObjectTemplateCSElements pObjectTemplateCS;
	private final ParamDeclarationCSElements pParamDeclarationCS;
	private final PredicateCSElements pPredicateCS;
	private final PrimitiveTypeDomainCSElements pPrimitiveTypeDomainCS;
	private final PropertyTemplateCSElements pPropertyTemplateCS;
	private final QueryCSElements pQueryCS;
	private final RelationCSElements pRelationCS;
	private final ScopeNameCSElements pScopeNameCS;
	private final TemplateCSElements pTemplateCS;
	private final TransformationCSElements pTransformationCS;
	private final UnitCSElements pUnitCS;
	private final VarDeclarationCSElements pVarDeclarationCS;
	private final VarDeclarationIdCSElements pVarDeclarationIdCS;
	private final WhenCSElements pWhenCS;
	private final WhereCSElements pWhereCS;
	private final ExpCSOrTemplateCSElements pExpCSOrTemplateCS;
	private final TypedTypeRefCSElements pTypedTypeRefCS;
	private final TypedRefCSElements pTypedRefCS;
	private final UnrestrictedNameElements pUnrestrictedName;

	private final Grammar grammar;

	private final QVTbaseGrammarAccess gaQVTbase;

	private final EssentialOCLGrammarAccess gaEssentialOCL;

	private final BaseGrammarAccess gaBase;

	@Inject
	public QVTrelationGrammarAccess(GrammarProvider grammarProvider,
		QVTbaseGrammarAccess gaQVTbase,
		EssentialOCLGrammarAccess gaEssentialOCL,
		BaseGrammarAccess gaBase) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaQVTbase = gaQVTbase;
		this.gaEssentialOCL = gaEssentialOCL;
		this.gaBase = gaBase;
		this.pTopLevelCS = new TopLevelCSElements();
		this.pQualifiedPackageCS = new QualifiedPackageCSElements();
		this.pCollectionTemplateCS = new CollectionTemplateCSElements();
		this.pDefaultValueCS = new DefaultValueCSElements();
		this.pDomainCS = new DomainCSElements();
		this.pDomainPatternCS = new DomainPatternCSElements();
		this.pElementTemplateCS = new ElementTemplateCSElements();
		this.pKeyDeclCS = new KeyDeclCSElements();
		this.pModelDeclCS = new ModelDeclCSElements();
		this.pObjectTemplateCS = new ObjectTemplateCSElements();
		this.pParamDeclarationCS = new ParamDeclarationCSElements();
		this.pPredicateCS = new PredicateCSElements();
		this.pPrimitiveTypeDomainCS = new PrimitiveTypeDomainCSElements();
		this.pPropertyTemplateCS = new PropertyTemplateCSElements();
		this.pQueryCS = new QueryCSElements();
		this.pRelationCS = new RelationCSElements();
		this.pScopeNameCS = new ScopeNameCSElements();
		this.pTemplateCS = new TemplateCSElements();
		this.pTransformationCS = new TransformationCSElements();
		this.pUnitCS = new UnitCSElements();
		this.pVarDeclarationCS = new VarDeclarationCSElements();
		this.pVarDeclarationIdCS = new VarDeclarationIdCSElements();
		this.pWhenCS = new WhenCSElements();
		this.pWhereCS = new WhereCSElements();
		this.pExpCSOrTemplateCS = new ExpCSOrTemplateCSElements();
		this.pTypedTypeRefCS = new TypedTypeRefCSElements();
		this.pTypedRefCS = new TypedRefCSElements();
		this.pUnrestrictedName = new UnrestrictedNameElements();
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.qvtd.xtext.qvtrelation.QVTrelation".equals(grammar.getName())) {
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
	//	ownedImports+=UnitCS* (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS)*;
	public TopLevelCSElements getTopLevelCSAccess() {
		return pTopLevelCS;
	}

	public ParserRule getTopLevelCSRule() {
		return getTopLevelCSAccess().getRule();
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

	////UnitCS: identifier+=[pivot::Element|UnrestrictedName] ('.' identifier+=[pivot::Element|UnrestrictedName])*;
	//
	//CollectionTemplateCS:
	//	name=UnrestrictedName? ':' ownedType=CollectionTypeCS '{' (ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS)
	//	(',' ownedMemberIdentifiers+=(TemplateCS | ElementTemplateCS))* '++' ownedRestIdentifier=ElementTemplateCS)? '}';
	public CollectionTemplateCSElements getCollectionTemplateCSAccess() {
		return pCollectionTemplateCS;
	}

	public ParserRule getCollectionTemplateCSRule() {
		return getCollectionTemplateCSAccess().getRule();
	}

	//DefaultValueCS:
	//	propertyId=[qvtrelation::SharedVariable|UnrestrictedName] '=' ownedInitExpression=ExpCS ';';
	public DefaultValueCSElements getDefaultValueCSAccess() {
		return pDefaultValueCS;
	}

	public ParserRule getDefaultValueCSRule() {
		return getDefaultValueCSAccess().getRule();
	}

	//DomainCS:
	//	(isCheckonly?='checkonly' | isEnforce?='enforce' | 'replace')? 'domain'
	//	modelId=[qvtbase::TypedModel|UnrestrictedName] ownedPattern+=DomainPatternCS (',' ownedPattern+=DomainPatternCS)*
	//	('implementedby' implementedBy=UnrestrictedName)? ('default_values' '{' ownedDefaultValues+=DefaultValueCS+ '}')?
	//	';';
	public DomainCSElements getDomainCSAccess() {
		return pDomainCS;
	}

	public ParserRule getDomainCSRule() {
		return getDomainCSAccess().getRule();
	}

	//DomainPatternCS:
	//	ownedTemplate=TemplateCS;
	public DomainPatternCSElements getDomainPatternCSAccess() {
		return pDomainPatternCS;
	}

	public ParserRule getDomainPatternCSRule() {
		return getDomainPatternCSAccess().getRule();
	}

	//ElementTemplateCS:
	//	identifier=[qvtrelation::SharedVariable|UnrestrictedName];
	public ElementTemplateCSElements getElementTemplateCSAccess() {
		return pElementTemplateCS;
	}

	public ParserRule getElementTemplateCSRule() {
		return getElementTemplateCSAccess().getRule();
	}

	//KeyDeclCS:
	//	'key' ownedPathName=PathNameCS '{' (propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '('
	//	ownedOppositePropertyIds+=PathNameCS ')') (',' (propertyIds+=[pivot::Property|UnrestrictedName] | 'opposite' '('
	//	ownedOppositePropertyIds+=PathNameCS ')'))* '}' ';';
	public KeyDeclCSElements getKeyDeclCSAccess() {
		return pKeyDeclCS;
	}

	public ParserRule getKeyDeclCSRule() {
		return getKeyDeclCSAccess().getRule();
	}

	//ModelDeclCS:
	//	name=UnrestrictedName ':' (metamodelIds+=[pivot::Namespace|UnrestrictedName] | '{'
	//	metamodelIds+=[pivot::Namespace|UnrestrictedName] (',' metamodelIds+=[pivot::Namespace|UnrestrictedName])* '}');
	public ModelDeclCSElements getModelDeclCSAccess() {
		return pModelDeclCS;
	}

	public ParserRule getModelDeclCSRule() {
		return getModelDeclCSAccess().getRule();
	}

	//ObjectTemplateCS:
	//	name=UnrestrictedName? ':' ownedType=TypedRefCS '{' (ownedPropertyTemplates+=PropertyTemplateCS (','
	//	ownedPropertyTemplates+=PropertyTemplateCS)*)? '}';
	public ObjectTemplateCSElements getObjectTemplateCSAccess() {
		return pObjectTemplateCS;
	}

	public ParserRule getObjectTemplateCSRule() {
		return getObjectTemplateCSAccess().getRule();
	}

	//ParamDeclarationCS:
	//	name=UnrestrictedName ':' ownedType=TypedRefCS;
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

	//PrimitiveTypeDomainCS:
	//	'primitive' 'domain' name=UnrestrictedName ':' ownedType=TypedRefCS ';';
	public PrimitiveTypeDomainCSElements getPrimitiveTypeDomainCSAccess() {
		return pPrimitiveTypeDomainCS;
	}

	public ParserRule getPrimitiveTypeDomainCSRule() {
		return getPrimitiveTypeDomainCSAccess().getRule();
	}

	//PropertyTemplateCS:
	//	(propertyId=[pivot::Property|UnrestrictedName] | 'opposite' '(' ownedOppositePropertyId=PathNameCS ')') '='
	//	ownedExpression=ExpCSOrTemplateCS;
	public PropertyTemplateCSElements getPropertyTemplateCSAccess() {
		return pPropertyTemplateCS;
	}

	public ParserRule getPropertyTemplateCSRule() {
		return getPropertyTemplateCSAccess().getRule();
	}

	//QueryCS:
	//	isTransient?='transient'? 'query' name=UnrestrictedName '(' (ownedParameters+=ParamDeclarationCS (','
	//	ownedParameters+=ParamDeclarationCS)*)? ')' ':' ownedType=TypedRefCS (';' | '{' ownedExpression=ExpCS '}');
	public QueryCSElements getQueryCSAccess() {
		return pQueryCS;
	}

	public ParserRule getQueryCSRule() {
		return getQueryCSAccess().getRule();
	}

	//RelationCS:
	//	isTop?='top'? isDefault?='default'? 'relation' name=UnrestrictedName ('overrides'
	//	overrides=[qvtrelation::Relation|UnrestrictedName])? '{' ownedVarDeclarations+=VarDeclarationCS*
	//	(ownedDomains+=DomainCS | ownedDomains+=PrimitiveTypeDomainCS)+ ownedWhen=WhenCS? ownedWhere=WhereCS? '}';
	public RelationCSElements getRelationCSAccess() {
		return pRelationCS;
	}

	public ParserRule getRelationCSRule() {
		return getRelationCSAccess().getRule();
	}

	//ScopeNameCS base::PathNameCS:
	//	ownedPathElements+=FirstPathElementCS '::' (ownedPathElements+=NextPathElementCS '::')*
	public ScopeNameCSElements getScopeNameCSAccess() {
		return pScopeNameCS;
	}

	public ParserRule getScopeNameCSRule() {
		return getScopeNameCSAccess().getRule();
	}

	//TemplateCS:
	//	(CollectionTemplateCS | ObjectTemplateCS) ('{' ownedGuardExpression=ExpCS '}')?;
	public TemplateCSElements getTemplateCSAccess() {
		return pTemplateCS;
	}

	public ParserRule getTemplateCSRule() {
		return getTemplateCSAccess().getRule();
	}

	//TransformationCS:
	//	'transformation' ownedPathName=ScopeNameCS? name=UnrestrictedName '(' ownedModelDecls+=ModelDeclCS (','
	//	ownedModelDecls+=ModelDeclCS)* ')' ('extends' extends+=[qvtbase::Transformation|UnrestrictedName] (','
	//	extends+=[qvtbase::Transformation|UnrestrictedName])*)? '{' ownedKeyDecls+=KeyDeclCS* (ownedRelations+=RelationCS |
	//	ownedQueries+=QueryCS)* '}';
	public TransformationCSElements getTransformationCSAccess() {
		return pTransformationCS;
	}

	public ParserRule getTransformationCSRule() {
		return getTransformationCSAccess().getRule();
	}

	//UnitCS base::ImportCS:
	//	'import' (name=UnrestrictedName ':')? ownedPathName=URIPathNameCS ('::' isAll?='*')? ';'
	public UnitCSElements getUnitCSAccess() {
		return pUnitCS;
	}

	public ParserRule getUnitCSRule() {
		return getUnitCSAccess().getRule();
	}

	//VarDeclarationCS:
	//	ownedVarDeclarationIds+=VarDeclarationIdCS (',' ownedVarDeclarationIds+=VarDeclarationIdCS)* (':'
	//	ownedType=TypedRefCS)? ('=' ownedInitExpression=ExpCS)? ';';
	public VarDeclarationCSElements getVarDeclarationCSAccess() {
		return pVarDeclarationCS;
	}

	public ParserRule getVarDeclarationCSRule() {
		return getVarDeclarationCSAccess().getRule();
	}

	//VarDeclarationIdCS:
	//	name=UnrestrictedName;
	public VarDeclarationIdCSElements getVarDeclarationIdCSAccess() {
		return pVarDeclarationIdCS;
	}

	public ParserRule getVarDeclarationIdCSRule() {
		return getVarDeclarationIdCSAccess().getRule();
	}

	//WhenCS PatternCS:
	//	{PatternCS} 'when' '{' ownedPredicates+=PredicateCS* '}'
	public WhenCSElements getWhenCSAccess() {
		return pWhenCS;
	}

	public ParserRule getWhenCSRule() {
		return getWhenCSAccess().getRule();
	}

	//WhereCS PatternCS:
	//	{PatternCS} 'where' '{' ownedPredicates+=PredicateCS* '}'
	public WhereCSElements getWhereCSAccess() {
		return pWhereCS;
	}

	public ParserRule getWhereCSRule() {
		return getWhereCSAccess().getRule();
	}

	////<OCLExpressionCS> ::= <PropertyCallExpCS>
	// //                    | <VariableExpCS>
	//
	////                    | <LiteralExpCS>
	// //                    | <LetExpCS>
	// //                    | <IfExpCS>
	//
	////                    | '(' <OCLExpressionCS> ')'
	// //                    | <template>
	//
	////	notNameExpressionCS -> templateCS
	// ExpCSOrTemplateCS essentialocl::ExpCS:
	//	ExpCS | TemplateCS
	public ExpCSOrTemplateCSElements getExpCSOrTemplateCSAccess() {
		return pExpCSOrTemplateCS;
	}

	public ParserRule getExpCSOrTemplateCSRule() {
		return getExpCSOrTemplateCSAccess().getRule();
	}

	//TypedTypeRefCS base::TypedTypeRefCS:
	//	ownedPathName=PathNameCS
	public TypedTypeRefCSElements getTypedTypeRefCSAccess() {
		return pTypedTypeRefCS;
	}

	public ParserRule getTypedTypeRefCSRule() {
		return getTypedTypeRefCSAccess().getRule();
	}

	//TypedRefCS base::TypedRefCS:
	//	PrimitiveTypeCS ownedMultiplicity=MultiplicityCS? | CollectionTypeCS ownedMultiplicity=MultiplicityCS? |
	//	TypedTypeRefCS ownedMultiplicity=MultiplicityCS?
	public TypedRefCSElements getTypedRefCSAccess() {
		return pTypedRefCS;
	}

	public ParserRule getTypedRefCSRule() {
		return getTypedRefCSAccess().getRule();
	}

	////ExpCS returns essentialocl::ExpCS:
	// //	InfixedExpCS
	// //|	TemplateCS;
	// UnrestrictedName:
	//	EssentialOCLUnrestrictedName | 'checkonly' | 'default' | 'default_values' | 'domain' | 'enforce' | 'extends' |
	//	'implementedby' | 'import' | 'library' | 'key' | 'opposite' | 'overrides' | 'primitive' | 'query' | 'relation' |
	//	'replace' | 'top' | 'transformation' | 'when' | 'where';
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
	//	ownedParameters+=ParameterCS)*)? ')' (':' ownedType=TypedMultiplicityRefCS)? ('throws'
	//	ownedExceptions+=super::TypedRefCS (',' ownedExceptions+=super::TypedRefCS)*)? ('{' ((qualifiers+='derived' |
	//	qualifiers+='!derived' | qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' |
	//	qualifiers+='!unique') ','?)+ '}')? ('{' ('body' super::UnrestrictedName? ':' ownedBodyExpressions+=SpecificationCS?
	//	';')* '}' | ';')
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
	//	ownedSuperTypes+=super::TypedRefCS (',' ownedSuperTypes+=super::TypedRefCS)*)? (':'
	//	instanceClassName=SINGLE_QUOTED_STRING)? ('{' isInterface?='interface'? '}')? ('{' (ownedOperations+=OperationCS |
	//	ownedProperties+=StructuralFeatureCS / *| ownedConstraints+=InvariantConstraintCS* /)* '}' | ';')
	public QVTbaseGrammarAccess.StructuredClassCSElements getStructuredClassCSAccess() {
		return gaQVTbase.getStructuredClassCSAccess();
	}

	public ParserRule getStructuredClassCSRule() {
		return getStructuredClassCSAccess().getRule();
	}

	//TypedMultiplicityRefCS base::TypedRefCS:
	//	super::TypedRefCS ownedMultiplicity=MultiplicityCS?
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
	//	name=super::UnrestrictedName ('extends' ownedExtends+=super::TypedRefCS ('&&' ownedExtends+=super::TypedRefCS)*)?;
	public BaseGrammarAccess.TypeParameterCSElements getTypeParameterCSAccess() {
		return gaBase.getTypeParameterCSAccess();
	}

	public ParserRule getTypeParameterCSRule() {
		return getTypeParameterCSAccess().getRule();
	}

	//TypeRefCS:
	//	super::TypedRefCS | WildcardTypeRefCS;
	public BaseGrammarAccess.TypeRefCSElements getTypeRefCSAccess() {
		return gaBase.getTypeRefCSAccess();
	}

	public ParserRule getTypeRefCSRule() {
		return getTypeRefCSAccess().getRule();
	}

	//WildcardTypeRefCS:
	//	{WildcardTypeRefCS} '?' ('extends' ownedExtends=super::TypedRefCS)?;
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
