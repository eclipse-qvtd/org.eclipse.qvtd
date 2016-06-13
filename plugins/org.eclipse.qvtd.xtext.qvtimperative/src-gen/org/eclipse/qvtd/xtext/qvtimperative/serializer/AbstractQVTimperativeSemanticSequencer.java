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
package org.eclipse.qvtd.xtext.qvtimperative.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
import org.eclipse.qvtd.xtext.qvtcorebase.serializer.QVTcoreBaseSemanticSequencer;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;
import org.eclipse.qvtd.xtext.qvtimperativecs.ConnectionStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeRealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractQVTimperativeSemanticSequencer extends QVTcoreBaseSemanticSequencer {

	@Inject
	private QVTimperativeGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.ATTRIBUTE_CS:
				sequence_AttributeCS(context, (AttributeCS) semanticObject); 
				return; 
			case BaseCSPackage.DATA_TYPE_CS:
				sequence_DataTypeCS(context, (DataTypeCS) semanticObject); 
				return; 
			case BaseCSPackage.ENUMERATION_CS:
				sequence_EnumerationCS(context, (EnumerationCS) semanticObject); 
				return; 
			case BaseCSPackage.ENUMERATION_LITERAL_CS:
				sequence_EnumerationLiteralCS(context, (EnumerationLiteralCS) semanticObject); 
				return; 
			case BaseCSPackage.IMPORT_CS:
				sequence_ImportCS(context, (ImportCS) semanticObject); 
				return; 
			case BaseCSPackage.MULTIPLICITY_BOUNDS_CS:
				if (rule == grammarAccess.getMultiplicityBoundsCSRule()) {
					sequence_MultiplicityBoundsCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityBoundsCS_MultiplicityCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_STRING_CS:
				if (rule == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityCS_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiplicityStringCSRule()) {
					sequence_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.OPERATION_CS:
				sequence_OperationCS(context, (OperationCS) semanticObject); 
				return; 
			case BaseCSPackage.PARAMETER_CS:
				sequence_ParameterCS(context, (ParameterCS) semanticObject); 
				return; 
			case BaseCSPackage.PATH_ELEMENT_CS:
				if (rule == grammarAccess.getFirstPathElementCSRule()) {
					sequence_FirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNextPathElementCSRule()) {
					sequence_NextPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_WITH_URICS:
				sequence_URIFirstPathElementCS(context, (PathElementWithURICS) semanticObject); 
				return; 
			case BaseCSPackage.PATH_NAME_CS:
				if (rule == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getScopeNameCSRule()) {
					sequence_ScopeNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if (rule == grammarAccess.getPrimitiveTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_PrimitiveTypeCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_PrimitiveTypeCS_TypeExpCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.REFERENCE_CS:
				sequence_ReferenceCS(context, (ReferenceCS) semanticObject); 
				return; 
			case BaseCSPackage.STRUCTURED_CLASS_CS:
				sequence_StructuredClassCS(context, (StructuredClassCS) semanticObject); 
				return; 
			case BaseCSPackage.TEMPLATE_BINDING_CS:
				sequence_TemplateBindingCS(context, (TemplateBindingCS) semanticObject); 
				return; 
			case BaseCSPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
				sequence_TemplateParameterSubstitutionCS(context, (TemplateParameterSubstitutionCS) semanticObject); 
				return; 
			case BaseCSPackage.TEMPLATE_SIGNATURE_CS:
				sequence_TemplateSignatureCS(context, (TemplateSignatureCS) semanticObject); 
				return; 
			case BaseCSPackage.TUPLE_PART_CS:
				sequence_TuplePartCS(context, (TuplePartCS) semanticObject); 
				return; 
			case BaseCSPackage.TUPLE_TYPE_CS:
				if (rule == grammarAccess.getTupleTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_TupleTypeCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_TupleTypeCS_TypeExpCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TYPE_PARAMETER_CS:
				sequence_TypeParameterCS(context, (TypeParameterCS) semanticObject); 
				return; 
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TypedMultiplicityRefCS_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeRefCSRule()
						|| rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTypedTypeRefCSRule()) {
					sequence_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.WILDCARD_TYPE_REF_CS:
				sequence_WildcardTypeRefCS(context, (WildcardTypeRefCS) semanticObject); 
				return; 
			}
		else if (epackage == EssentialOCLCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case EssentialOCLCSPackage.BOOLEAN_LITERAL_EXP_CS:
				sequence_BooleanLiteralExpCS(context, (BooleanLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.COLLECTION_LITERAL_EXP_CS:
				sequence_CollectionLiteralExpCS(context, (CollectionLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS:
				sequence_CollectionLiteralPartCS(context, (CollectionLiteralPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.COLLECTION_PATTERN_CS:
				if (rule == grammarAccess.getCollectionPatternCSRule()) {
					sequence_CollectionPatternCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionPatternCS_TypeExpCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS:
				if (rule == grammarAccess.getCollectionTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_CollectionTypeCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionTypeCS_TypeExpCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CONTEXT_CS:
				sequence_Model(context, (ContextCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS:
				sequence_CurlyBracketedClauseCS(context, (CurlyBracketedClauseCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.EXP_SPECIFICATION_CS:
				sequence_SpecificationCS(context, (ExpSpecificationCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.IF_EXP_CS:
				sequence_IfExpCS(context, (IfExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.IF_THEN_EXP_CS:
				sequence_ElseIfThenExpCS(context, (IfThenExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.INFIX_EXP_CS:
				sequence_ExpCS(context, (InfixExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS:
				sequence_InvalidLiteralExpCS(context, (InvalidLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.LAMBDA_LITERAL_EXP_CS:
				sequence_LambdaLiteralExpCS(context, (LambdaLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.LET_EXP_CS:
				sequence_LetExpCS(context, (LetExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.LET_VARIABLE_CS:
				sequence_LetVariableCS(context, (LetVariableCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.MAP_LITERAL_EXP_CS:
				sequence_MapLiteralExpCS(context, (MapLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.MAP_LITERAL_PART_CS:
				sequence_MapLiteralPartCS(context, (MapLiteralPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.MAP_TYPE_CS:
				if (rule == grammarAccess.getMapTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()) {
					sequence_MapTypeCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_MapTypeCS_TypeExpCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(context, (MapTypeCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAME_EXP_CS:
				sequence_NameExpCS(context, (NameExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS:
				if (rule == grammarAccess.getNavigatingArgCSRule()) {
					sequence_NavigatingArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNavigatingBarArgCSRule()) {
					sequence_NavigatingBarArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNavigatingCommaArgCSRule()) {
					sequence_NavigatingCommaArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNavigatingSemiArgCSRule()) {
					sequence_NavigatingSemiArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NESTED_EXP_CS:
				sequence_NestedExpCS(context, (NestedExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.NULL_LITERAL_EXP_CS:
				sequence_NullLiteralExpCS(context, (NullLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.NUMBER_LITERAL_EXP_CS:
				sequence_NumberLiteralExpCS(context, (NumberLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.PATTERN_EXP_CS:
				sequence_PatternExpCS(context, (PatternExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.PREFIX_EXP_CS:
				if (rule == grammarAccess.getPrefixedLetExpCSRule()) {
					sequence_PrefixedLetExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpCSRule()
						|| rule == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0()
						|| rule == grammarAccess.getPrefixedPrimaryExpCSRule()) {
					sequence_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS:
				sequence_RoundBracketedClauseCS(context, (RoundBracketedClauseCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.SELF_EXP_CS:
				sequence_SelfExpCS(context, (SelfExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.SHADOW_PART_CS:
				sequence_ShadowPartCS(context, (ShadowPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS:
				sequence_SquareBracketedClauseCS(context, (SquareBracketedClauseCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.STRING_LITERAL_EXP_CS:
				sequence_StringLiteralExpCS(context, (StringLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TUPLE_LITERAL_EXP_CS:
				sequence_TupleLiteralExpCS(context, (TupleLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TUPLE_LITERAL_PART_CS:
				sequence_TupleLiteralPartCS(context, (TupleLiteralPartCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TYPE_LITERAL_EXP_CS:
				sequence_TypeLiteralExpCS(context, (TypeLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.TYPE_NAME_EXP_CS:
				if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_TypeExpCS_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeNameExpCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject); 
				return; 
			case EssentialOCLCSPackage.VARIABLE_CS:
				sequence_MappingIteratorCS(context, (VariableCS) semanticObject); 
				return; 
			}
		else if (epackage == QVTbaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case QVTbaseCSPackage.QUALIFIED_PACKAGE_CS:
				sequence_QualifiedPackageCS(context, (QualifiedPackageCS) semanticObject); 
				return; 
			}
		else if (epackage == QVTcoreBaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS:
				if (rule == grammarAccess.getBottomPatternCSRule()) {
					sequence_BottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMiddleBottomPatternCSRule()) {
					sequence_MiddleBottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSourceBottomPatternCSRule()) {
					sequence_SourceBottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTargetBottomPatternCSRule()) {
					sequence_TargetBottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.DIRECTION_CS:
				sequence_DirectionCS(context, (DirectionCS) semanticObject); 
				return; 
			case QVTcoreBaseCSPackage.DOMAIN_CS:
				if (rule == grammarAccess.getNamedDomainCSRule()) {
					sequence_NamedDomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedDomainCSRule()) {
					sequence_UnnamedDomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.GUARD_PATTERN_CS:
				if (rule == grammarAccess.getMiddleGuardPatternCSRule()
						|| rule == grammarAccess.getGuardPatternCSRule()) {
					sequence_GuardPatternCS(context, (GuardPatternCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSourceGuardPatternCSRule()) {
					sequence_SourceGuardPatternCS(context, (GuardPatternCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTargetGuardPatternCSRule()) {
					sequence_TargetGuardPatternCS(context, (GuardPatternCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.PARAM_DECLARATION_CS:
				sequence_ParamDeclarationCS(context, (ParamDeclarationCS) semanticObject); 
				return; 
			case QVTcoreBaseCSPackage.PREDICATE_CS:
				sequence_PredicateCS(context, (PredicateCS) semanticObject); 
				return; 
			case QVTcoreBaseCSPackage.PREDICATE_OR_ASSIGNMENT_CS:
				sequence_PredicateOrAssignmentCS(context, (PredicateOrAssignmentCS) semanticObject); 
				return; 
			case QVTcoreBaseCSPackage.QUERY_CS:
				sequence_QueryCS(context, (QueryCS) semanticObject); 
				return; 
			case QVTcoreBaseCSPackage.TRANSFORMATION_CS:
				sequence_TransformationCS(context, (TransformationCS) semanticObject); 
				return; 
			case QVTcoreBaseCSPackage.UNREALIZED_VARIABLE_CS:
				if (rule == grammarAccess.getGuardVariableCSRule()) {
					sequence_GuardVariableCS(context, (UnrealizedVariableCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnrealizedVariableCSRule()) {
					sequence_UnrealizedVariableCS(context, (UnrealizedVariableCS) semanticObject); 
					return; 
				}
				else break;
			}
		else if (epackage == QVTimperativeCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case QVTimperativeCSPackage.CONNECTION_STATEMENT_CS:
				sequence_ConnectionStatementCS(context, (ConnectionStatementCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS:
				if (rule == grammarAccess.getMiddleDomainCSRule()) {
					sequence_MiddleDomainCS(context, (ImperativeDomainCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSourceDomainCSRule()) {
					sequence_SourceDomainCS(context, (ImperativeDomainCS) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTargetDomainCSRule()) {
					sequence_TargetDomainCS(context, (ImperativeDomainCS) semanticObject); 
					return; 
				}
				else break;
			case QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS:
				sequence_ImperativePredicateOrAssignmentCS(context, (ImperativePredicateOrAssignmentCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.IMPERATIVE_REALIZED_VARIABLE_CS:
				sequence_RealizedVariableCS(context, (ImperativeRealizedVariableCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.MAPPING_CS:
				sequence_MappingCS(context, (MappingCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS:
				sequence_MappingCallBindingCS(context, (MappingCallBindingCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.MAPPING_CALL_CS:
				sequence_MappingCallCS(context, (MappingCallCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.MAPPING_LOOP_CS:
				sequence_MappingLoopCS(context, (MappingLoopCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.MAPPING_SEQUENCE_CS:
				sequence_MappingSequenceCS(context, (MappingSequenceCS) semanticObject); 
				return; 
			case QVTimperativeCSPackage.TOP_LEVEL_CS:
				sequence_TopLevelCS(context, (TopLevelCS) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ConnectionStatementCS returns ConnectionStatementCS
	 *     MappingStatementCS returns ConnectionStatementCS
	 *
	 * Constraint:
	 *     (targetVariable=[Variable|UnrestrictedName] ownedExpression=ExpCS)
	 */
	protected void sequence_ConnectionStatementCS(ISerializationContext context, ConnectionStatementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QVTimperativeCSPackage.Literals.CONNECTION_STATEMENT_CS__TARGET_VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTimperativeCSPackage.Literals.CONNECTION_STATEMENT_CS__TARGET_VARIABLE));
			if (transientValues.isValueTransient(semanticObject, QVTimperativeCSPackage.Literals.CONNECTION_STATEMENT_CS__OWNED_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTimperativeCSPackage.Literals.CONNECTION_STATEMENT_CS__OWNED_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConnectionStatementCSAccess().getTargetVariableVariableUnrestrictedNameParserRuleCall_0_0_1(), semanticObject.getTargetVariable());
		feeder.accept(grammarAccess.getConnectionStatementCSAccess().getOwnedExpressionExpCSParserRuleCall_2_0(), semanticObject.getOwnedExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DirectionCS returns DirectionCS
	 *
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         (imports+=[Package|UnrestrictedName] imports+=[Package|UnrestrictedName]*)? 
	 *         (uses+=[CoreDomain|UnrestrictedName] uses+=[CoreDomain|UnrestrictedName]*)?
	 *     )
	 */
	protected void sequence_DirectionCS(ISerializationContext context, DirectionCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ImperativePredicateOrAssignmentCS returns ImperativePredicateOrAssignmentCS
	 *
	 * Constraint:
	 *     (isDefault?='default'? ownedTarget=ExpCS (isAccumulate?='+='? ownedInitExpression=ExpCS)?)
	 */
	protected void sequence_ImperativePredicateOrAssignmentCS(ISerializationContext context, ImperativePredicateOrAssignmentCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MappingCS returns MappingCS
	 *
	 * Constraint:
	 *     (
	 *         isDefault?='default'? 
	 *         name=UnrestrictedName 
	 *         ownedInPathName=PathNameCS? 
	 *         (ownedUsesPathNames+=PathNameCS ownedUsesPathNames+=PathNameCS*)? 
	 *         ownedKeyExpression=ExpCS? 
	 *         (ownedDomains+=SourceDomainCS | ownedDomains+=TargetDomainCS)* 
	 *         ownedMiddle=MiddleDomainCS? 
	 *         ownedMappingSequence=MappingSequenceCS?
	 *     )
	 */
	protected void sequence_MappingCS(ISerializationContext context, MappingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MappingCallBindingCS returns MappingCallBindingCS
	 *
	 * Constraint:
	 *     (referredVariable=[Variable|UnrestrictedName] isPolled?='?='? ownedValue=ExpCS)
	 */
	protected void sequence_MappingCallBindingCS(ISerializationContext context, MappingCallBindingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MappingCallCS returns MappingCallCS
	 *     MappingStatementCS returns MappingCallCS
	 *
	 * Constraint:
	 *     (isInfinite?='infinite'? ownedPathName=PathNameCS ownedBindings+=MappingCallBindingCS*)
	 */
	protected void sequence_MappingCallCS(ISerializationContext context, MappingCallCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MappingIteratorCS returns VariableCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS?)
	 */
	protected void sequence_MappingIteratorCS(ISerializationContext context, VariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MappingLoopCS returns MappingLoopCS
	 *     MappingStatementCS returns MappingLoopCS
	 *
	 * Constraint:
	 *     (ownedIterator=MappingIteratorCS ownedInExpression=ExpCS ownedMappingSequence=MappingSequenceCS)
	 */
	protected void sequence_MappingLoopCS(ISerializationContext context, MappingLoopCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_ITERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_ITERATOR));
			if (transientValues.isValueTransient(semanticObject, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION));
			if (transientValues.isValueTransient(semanticObject, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMappingLoopCSAccess().getOwnedIteratorMappingIteratorCSParserRuleCall_1_0(), semanticObject.getOwnedIterator());
		feeder.accept(grammarAccess.getMappingLoopCSAccess().getOwnedInExpressionExpCSParserRuleCall_3_0(), semanticObject.getOwnedInExpression());
		feeder.accept(grammarAccess.getMappingLoopCSAccess().getOwnedMappingSequenceMappingSequenceCSParserRuleCall_5_0(), semanticObject.getOwnedMappingSequence());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MappingSequenceCS returns MappingSequenceCS
	 *
	 * Constraint:
	 *     ownedMappingStatements+=MappingStatementCS+
	 */
	protected void sequence_MappingSequenceCS(ISerializationContext context, MappingSequenceCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MiddleBottomPatternCS returns BottomPatternCS
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             ownedUnrealizedVariables+=UnrealizedVariableCS 
	 *             ownedUnrealizedVariables+=UnrealizedVariableCS* 
	 *             ownedConstraints+=ImperativePredicateOrAssignmentCS*
	 *         ) | 
	 *         (ownedUnrealizedVariables+=UnrealizedVariableCS ownedUnrealizedVariables+=UnrealizedVariableCS*) | 
	 *         ownedConstraints+=ImperativePredicateOrAssignmentCS+
	 *     )?
	 */
	protected void sequence_MiddleBottomPatternCS(ISerializationContext context, BottomPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MiddleDomainCS returns ImperativeDomainCS
	 *
	 * Constraint:
	 *     (
	 *         (checkedProperties+=PathNameCS checkedProperties+=PathNameCS*)? 
	 *         (enforcedProperties+=PathNameCS enforcedProperties+=PathNameCS*)? 
	 *         ownedGuardPattern=MiddleGuardPatternCS 
	 *         ownedBottomPattern=MiddleBottomPatternCS
	 *     )
	 */
	protected void sequence_MiddleDomainCS(ISerializationContext context, ImperativeDomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RealizedVariableCS returns ImperativeRealizedVariableCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS ownedInitExpression=ExpCS?)
	 */
	protected void sequence_RealizedVariableCS(ISerializationContext context, ImperativeRealizedVariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SourceBottomPatternCS returns BottomPatternCS
	 *
	 * Constraint:
	 *     (ownedUnrealizedVariables+=UnrealizedVariableCS ownedUnrealizedVariables+=UnrealizedVariableCS*)?
	 */
	protected void sequence_SourceBottomPatternCS(ISerializationContext context, BottomPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SourceDomainCS returns ImperativeDomainCS
	 *
	 * Constraint:
	 *     (
	 *         isCheck?='check' 
	 *         direction=[TypedModel|UnrestrictedName] 
	 *         (checkedProperties+=PathNameCS checkedProperties+=PathNameCS*)? 
	 *         (enforcedProperties+=PathNameCS enforcedProperties+=PathNameCS*)? 
	 *         ownedGuardPattern=SourceGuardPatternCS 
	 *         ownedBottomPattern=SourceBottomPatternCS
	 *     )
	 */
	protected void sequence_SourceDomainCS(ISerializationContext context, ImperativeDomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SourceGuardPatternCS returns GuardPatternCS
	 *
	 * Constraint:
	 *     (ownedUnrealizedVariables+=UnrealizedVariableCS ownedUnrealizedVariables+=UnrealizedVariableCS*)?
	 */
	protected void sequence_SourceGuardPatternCS(ISerializationContext context, GuardPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetBottomPatternCS returns BottomPatternCS
	 *
	 * Constraint:
	 *     (
	 *         (ownedRealizedVariables+=RealizedVariableCS | ownedUnrealizedVariables+=UnrealizedVariableCS) 
	 *         ownedRealizedVariables+=RealizedVariableCS? 
	 *         (ownedUnrealizedVariables+=UnrealizedVariableCS? ownedRealizedVariables+=RealizedVariableCS?)*
	 *     )?
	 */
	protected void sequence_TargetBottomPatternCS(ISerializationContext context, BottomPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetDomainCS returns ImperativeDomainCS
	 *
	 * Constraint:
	 *     (
	 *         isEnforce?='enforce' 
	 *         direction=[TypedModel|UnrestrictedName] 
	 *         (checkedProperties+=PathNameCS checkedProperties+=PathNameCS*)? 
	 *         (enforcedProperties+=PathNameCS enforcedProperties+=PathNameCS*)? 
	 *         ownedGuardPattern=TargetGuardPatternCS 
	 *         ownedBottomPattern=TargetBottomPatternCS
	 *     )
	 */
	protected void sequence_TargetDomainCS(ISerializationContext context, ImperativeDomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetGuardPatternCS returns GuardPatternCS
	 *
	 * Constraint:
	 *     (ownedUnrealizedVariables+=UnrealizedVariableCS ownedUnrealizedVariables+=UnrealizedVariableCS*)?
	 */
	protected void sequence_TargetGuardPatternCS(ISerializationContext context, GuardPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TopLevelCS returns TopLevelCS
	 *
	 * Constraint:
	 *     (
	 *         ownedImports+=ImportCS+ | 
	 *         (
	 *             ownedImports+=ImportCS+ 
	 *             (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS | ownedMappings+=MappingCS | ownedQueries+=QueryCS)+
	 *         )
	 *     )?
	 */
	protected void sequence_TopLevelCS(ISerializationContext context, TopLevelCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
