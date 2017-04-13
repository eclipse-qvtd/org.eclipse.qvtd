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
package org.eclipse.qvtd.xtext.qvtrelation.serializer;

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
import org.eclipse.qvtd.xtext.qvtbase.serializer.QVTbaseSemanticSequencer;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess;
import org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractQVTrelationSemanticSequencer extends QVTbaseSemanticSequencer {

	@Inject
	private QVTrelationGrammarAccess grammarAccess;

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
				sequence_UnitCS(context, (ImportCS) semanticObject);
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
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
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
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_PrimitiveTypeCS_TypedMultiplicityRefCS_TypedRefCS(context, (PrimitiveTypeRefCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
					sequence_PrimitiveTypeCS_TypedRefCS(context, (PrimitiveTypeRefCS) semanticObject);
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
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
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
					sequence_TypedMultiplicityRefCS_TypedRefCS_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
					sequence_TypedRefCS_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedTypeRefCSRule()) {
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
				if (rule == grammarAccess.getCollectionPatternCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
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
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
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
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_CollectionTypeCS_TypedMultiplicityRefCS_TypedRefCS(context, (CollectionTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
					sequence_CollectionTypeCS_TypedRefCS(context, (CollectionTypeCS) semanticObject);
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
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
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
				else if (rule == grammarAccess.getExpCSOrTemplateCSRule()
						|| rule == grammarAccess.getExpCSRule()
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
				else if (rule == grammarAccess.getTypeNameExpCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject);
				return;
			}
		else if (epackage == QVTbaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case QVTbaseCSPackage.QUALIFIED_PACKAGE_CS:
				sequence_QualifiedPackageCS(context, (QualifiedPackageCS) semanticObject);
				return;
			}
		else if (epackage == QVTrelationCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS:
				if (rule == grammarAccess.getCollectionTemplateCSRule()) {
					sequence_CollectionTemplateCS(context, (CollectionTemplateCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTemplateCSRule()
						|| rule == grammarAccess.getExpCSOrTemplateCSRule()) {
					sequence_CollectionTemplateCS_TemplateCS(context, (CollectionTemplateCS) semanticObject);
					return;
				}
				else break;
			case QVTrelationCSPackage.DEFAULT_VALUE_CS:
				sequence_DefaultValueCS(context, (DefaultValueCS) semanticObject);
				return;
			case QVTrelationCSPackage.DOMAIN_CS:
				sequence_DomainCS(context, (DomainCS) semanticObject);
				return;
			case QVTrelationCSPackage.DOMAIN_PATTERN_CS:
				sequence_DomainPatternCS(context, (DomainPatternCS) semanticObject);
				return;
			case QVTrelationCSPackage.ELEMENT_TEMPLATE_CS:
				sequence_ElementTemplateCS(context, (ElementTemplateCS) semanticObject);
				return;
			case QVTrelationCSPackage.KEY_DECL_CS:
				sequence_KeyDeclCS(context, (KeyDeclCS) semanticObject);
				return;
			case QVTrelationCSPackage.MODEL_DECL_CS:
				sequence_ModelDeclCS(context, (ModelDeclCS) semanticObject);
				return;
			case QVTrelationCSPackage.OBJECT_TEMPLATE_CS:
				if (rule == grammarAccess.getObjectTemplateCSRule()) {
					sequence_ObjectTemplateCS(context, (ObjectTemplateCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTemplateCSRule()
						|| rule == grammarAccess.getExpCSOrTemplateCSRule()) {
					sequence_ObjectTemplateCS_TemplateCS(context, (ObjectTemplateCS) semanticObject);
					return;
				}
				else break;
			case QVTrelationCSPackage.PARAM_DECLARATION_CS:
				sequence_ParamDeclarationCS(context, (ParamDeclarationCS) semanticObject);
				return;
			case QVTrelationCSPackage.PATTERN_CS:
				if (rule == grammarAccess.getWhenCSRule()) {
					sequence_WhenCS(context, (PatternCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getWhereCSRule()) {
					sequence_WhereCS(context, (PatternCS) semanticObject);
					return;
				}
				else break;
			case QVTrelationCSPackage.PREDICATE_CS:
				sequence_PredicateCS(context, (PredicateCS) semanticObject);
				return;
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS:
				sequence_PrimitiveTypeDomainCS(context, (PrimitiveTypeDomainCS) semanticObject);
				return;
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_PATTERN_CS:
				sequence_PrimitiveTypeDomainPatternCS(context, (PrimitiveTypeDomainPatternCS) semanticObject);
				return;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS:
				sequence_PropertyTemplateCS(context, (PropertyTemplateCS) semanticObject);
				return;
			case QVTrelationCSPackage.QUERY_CS:
				sequence_QueryCS(context, (QueryCS) semanticObject);
				return;
			case QVTrelationCSPackage.RELATION_CS:
				sequence_RelationCS(context, (RelationCS) semanticObject);
				return;
			case QVTrelationCSPackage.TOP_LEVEL_CS:
				sequence_TopLevelCS(context, (TopLevelCS) semanticObject);
				return;
			case QVTrelationCSPackage.TRANSFORMATION_CS:
				sequence_TransformationCS(context, (TransformationCS) semanticObject);
				return;
			case QVTrelationCSPackage.VAR_DECLARATION_CS:
				sequence_VarDeclarationCS(context, (VarDeclarationCS) semanticObject);
				return;
			case QVTrelationCSPackage.VAR_DECLARATION_ID_CS:
				sequence_VarDeclarationIdCS(context, (VarDeclarationIdCS) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 *     CollectionTemplateCS returns CollectionTemplateCS
	 *
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName?
	 *         ownedType=CollectionTypeCS
	 *         (
	 *             (ownedMemberIdentifiers+=TemplateCS | ownedMemberIdentifiers+=ElementTemplateCS)
	 *             ownedMemberIdentifiers+=TemplateCS?
	 *             (ownedMemberIdentifiers+=ElementTemplateCS? ownedMemberIdentifiers+=TemplateCS?)*
	 *             ownedRestIdentifier=ElementTemplateCS
	 *         )?
	 *     )
	 */
	protected void sequence_CollectionTemplateCS(ISerializationContext context, CollectionTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TemplateCS returns CollectionTemplateCS
	 *     ExpCSOrTemplateCS returns CollectionTemplateCS
	 *
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName?
	 *         ownedType=CollectionTypeCS
	 *         (
	 *             (ownedMemberIdentifiers+=TemplateCS | ownedMemberIdentifiers+=ElementTemplateCS)
	 *             ownedMemberIdentifiers+=TemplateCS?
	 *             (ownedMemberIdentifiers+=ElementTemplateCS? ownedMemberIdentifiers+=TemplateCS?)*
	 *             ownedRestIdentifier=ElementTemplateCS
	 *         )?
	 *         ownedGuardExpression=ExpCS?
	 *     )
	 */
	protected void sequence_CollectionTemplateCS_TemplateCS(ISerializationContext context, CollectionTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedMultiplicityRefCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (
	 *         name=CollectionTypeIdentifier
	 *         (ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS?)?
	 *         ownedMultiplicity=MultiplicityCS?
	 *         ownedMultiplicity=MultiplicityCS?
	 *     )
	 */
	protected void sequence_CollectionTypeCS_TypedMultiplicityRefCS_TypedRefCS(ISerializationContext context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedRefCS returns CollectionTypeCS
	 *     TypeRefCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (
	 *         name=CollectionTypeIdentifier
	 *         (ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS?)?
	 *         ownedMultiplicity=MultiplicityCS?
	 *     )
	 */
	protected void sequence_CollectionTypeCS_TypedRefCS(ISerializationContext context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     DefaultValueCS returns DefaultValueCS
	 *
	 * Constraint:
	 *     (propertyId=[SharedVariable|UnrestrictedName] ownedInitExpression=ExpCS)
	 */
	protected void sequence_DefaultValueCS(ISerializationContext context, DefaultValueCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__PROPERTY_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__PROPERTY_ID));
			if (transientValues.isValueTransient(semanticObject, QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDefaultValueCSAccess().getPropertyIdSharedVariableUnrestrictedNameParserRuleCall_0_0_1(), semanticObject.getPropertyId());
		feeder.accept(grammarAccess.getDefaultValueCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0(), semanticObject.getOwnedInitExpression());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     DomainCS returns DomainCS
	 *
	 * Constraint:
	 *     (
	 *         (isCheckonly?='checkonly' | isEnforce?='enforce')?
	 *         modelId=[TypedModel|UnrestrictedName]
	 *         ownedPatterns+=DomainPatternCS
	 *         ownedPatterns+=DomainPatternCS*
	 *         implementedBy=UnrestrictedName?
	 *         ownedDefaultValues+=DefaultValueCS*
	 *     )
	 */
	protected void sequence_DomainCS(ISerializationContext context, DomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     DomainPatternCS returns DomainPatternCS
	 *
	 * Constraint:
	 *     ownedTemplate=TemplateCS
	 */
	protected void sequence_DomainPatternCS(ISerializationContext context, DomainPatternCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS__OWNED_TEMPLATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS__OWNED_TEMPLATE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDomainPatternCSAccess().getOwnedTemplateTemplateCSParserRuleCall_0(), semanticObject.getOwnedTemplate());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     ElementTemplateCS returns ElementTemplateCS
	 *
	 * Constraint:
	 *     identifier=[SharedVariable|UnrestrictedName]
	 */
	protected void sequence_ElementTemplateCS(ISerializationContext context, ElementTemplateCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS__IDENTIFIER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS__IDENTIFIER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getElementTemplateCSAccess().getIdentifierSharedVariableUnrestrictedNameParserRuleCall_0_1(), semanticObject.getIdentifier());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     KeyDeclCS returns KeyDeclCS
	 *
	 * Constraint:
	 *     (
	 *         ownedPathName=PathNameCS
	 *         (propertyIds+=[Property|UnrestrictedName] | ownedOppositePropertyIds+=PathNameCS)
	 *         propertyIds+=[Property|UnrestrictedName]?
	 *         (ownedOppositePropertyIds+=PathNameCS? propertyIds+=[Property|UnrestrictedName]?)*
	 *     )
	 */
	protected void sequence_KeyDeclCS(ISerializationContext context, KeyDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ModelDeclCS returns ModelDeclCS
	 *
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName
	 *         (metamodelIds+=[Namespace|UnrestrictedName] | (metamodelIds+=[Namespace|UnrestrictedName] metamodelIds+=[Namespace|UnrestrictedName]*))
	 *         (dependsOn+=[TypedModel|UnrestrictedName] dependsOn+=[TypedModel|UnrestrictedName]*)?
	 *     )
	 */
	protected void sequence_ModelDeclCS(ISerializationContext context, ModelDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ObjectTemplateCS returns ObjectTemplateCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName? ownedType=TypedRefCS (ownedPropertyTemplates+=PropertyTemplateCS ownedPropertyTemplates+=PropertyTemplateCS*)?)
	 */
	protected void sequence_ObjectTemplateCS(ISerializationContext context, ObjectTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TemplateCS returns ObjectTemplateCS
	 *     ExpCSOrTemplateCS returns ObjectTemplateCS
	 *
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName?
	 *         ownedType=TypedRefCS
	 *         (ownedPropertyTemplates+=PropertyTemplateCS ownedPropertyTemplates+=PropertyTemplateCS*)?
	 *         ownedGuardExpression=ExpCS?
	 *     )
	 */
	protected void sequence_ObjectTemplateCS_TemplateCS(ISerializationContext context, ObjectTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ParamDeclarationCS returns ParamDeclarationCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS)
	 */
	protected void sequence_ParamDeclarationCS(ISerializationContext context, ParamDeclarationCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     PredicateCS returns PredicateCS
	 *
	 * Constraint:
	 *     ownedCondition=ExpCS
	 */
	protected void sequence_PredicateCS(ISerializationContext context, PredicateCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, QVTrelationCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTrelationCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPredicateCSAccess().getOwnedConditionExpCSParserRuleCall_0_0(), semanticObject.getOwnedCondition());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     TypedMultiplicityRefCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypedMultiplicityRefCS_TypedRefCS(ISerializationContext context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedRefCS returns PrimitiveTypeRefCS
	 *     TypeRefCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypedRefCS(ISerializationContext context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     PrimitiveTypeDomainCS returns PrimitiveTypeDomainCS
	 *
	 * Constraint:
	 *     (ownedPatterns+=PrimitiveTypeDomainPatternCS ownedPatterns+=PrimitiveTypeDomainPatternCS*)
	 */
	protected void sequence_PrimitiveTypeDomainCS(ISerializationContext context, PrimitiveTypeDomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     PrimitiveTypeDomainPatternCS returns PrimitiveTypeDomainPatternCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS)
	 */
	protected void sequence_PrimitiveTypeDomainPatternCS(ISerializationContext context, PrimitiveTypeDomainPatternCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimitiveTypeDomainPatternCSAccess().getNameUnrestrictedNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPrimitiveTypeDomainPatternCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     PropertyTemplateCS returns PropertyTemplateCS
	 *
	 * Constraint:
	 *     ((propertyId=[Property|UnrestrictedName] | ownedOppositePropertyId=PathNameCS) ownedExpression=ExpCSOrTemplateCS)
	 */
	protected void sequence_PropertyTemplateCS(ISerializationContext context, PropertyTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     QualifiedPackageCS returns QualifiedPackageCS
	 *
	 * Constraint:
	 *     (
	 *         ownedPathName=ScopeNameCS?
	 *         name=UnrestrictedName
	 *         nsPrefix=UnrestrictedName?
	 *         nsURI=URI?
	 *         (ownedPackages+=QualifiedPackageCS | ownedClasses+=ClassCS | ownedClasses+=TransformationCS)*
	 *     )
	 */
	protected void sequence_QualifiedPackageCS(ISerializationContext context, QualifiedPackageCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     QueryCS returns QueryCS
	 *
	 * Constraint:
	 *     (
	 *         isTransient?='transient'?
	 *         name=UnrestrictedName
	 *         (ownedParameters+=ParamDeclarationCS ownedParameters+=ParamDeclarationCS*)?
	 *         ownedType=TypeExpCS
	 *         ownedExpression=ExpCS?
	 *     )
	 */
	protected void sequence_QueryCS(ISerializationContext context, QueryCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     RelationCS returns RelationCS
	 *
	 * Constraint:
	 *     (
	 *         isTop?='top'?
	 *         isAbstract?='abstract'?
	 *         name=UnrestrictedName
	 *         overrides=[Relation|UnrestrictedName]?
	 *         ownedVarDeclarations+=VarDeclarationCS*
	 *         (ownedDomains+=DomainCS | ownedDomains+=PrimitiveTypeDomainCS)+
	 *         ownedWhen=WhenCS?
	 *         ownedWhere=WhereCS?
	 *     )
	 */
	protected void sequence_RelationCS(ISerializationContext context, RelationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ScopeNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     (ownedPathElements+=FirstPathElementCS ownedPathElements+=NextPathElementCS*)
	 */
	protected void sequence_ScopeNameCS(ISerializationContext context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TopLevelCS returns TopLevelCS
	 *
	 * Constraint:
	 *     (ownedImports+=UnitCS+ | (ownedImports+=UnitCS+ (ownedPackages+=QualifiedPackageCS | ownedTransformations+=TransformationCS)+))?
	 */
	protected void sequence_TopLevelCS(ISerializationContext context, TopLevelCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TransformationCS returns TransformationCS
	 *
	 * Constraint:
	 *     (
	 *         ownedPathName=ScopeNameCS?
	 *         name=UnrestrictedName
	 *         ownedModelDecls+=ModelDeclCS
	 *         ownedModelDecls+=ModelDeclCS*
	 *         (extends+=[Transformation|UnrestrictedName] extends+=[Transformation|UnrestrictedName]*)?
	 *         ownedKeyDecls+=KeyDeclCS*
	 *         (ownedRelations+=RelationCS | ownedQueries+=QueryCS)*
	 *     )
	 */
	protected void sequence_TransformationCS(ISerializationContext context, TransformationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedMultiplicityRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS ownedMultiplicity=MultiplicityCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypedMultiplicityRefCS_TypedRefCS_TypedTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedRefCS returns TypedTypeRefCS
	 *     TypeRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypedRefCS_TypedTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedTypeRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     ownedPathName=PathNameCS
	 */
	protected void sequence_TypedTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0(), semanticObject.getOwnedPathName());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     UnitCS returns ImportCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName? ownedPathName=URIPathNameCS isAll?='*'?)
	 */
	protected void sequence_UnitCS(ISerializationContext context, ImportCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     VarDeclarationCS returns VarDeclarationCS
	 *
	 * Constraint:
	 *     (ownedVarDeclarationIds+=VarDeclarationIdCS ownedVarDeclarationIds+=VarDeclarationIdCS* ownedType=TypeExpCS? ownedInitExpression=ExpCS?)
	 */
	protected void sequence_VarDeclarationCS(ISerializationContext context, VarDeclarationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     VarDeclarationIdCS returns VarDeclarationIdCS
	 *
	 * Constraint:
	 *     name=UnrestrictedName
	 */
	protected void sequence_VarDeclarationIdCS(ISerializationContext context, VarDeclarationIdCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarDeclarationIdCSAccess().getNameUnrestrictedNameParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}


	/**
	 * Contexts:
	 *     WhenCS returns PatternCS
	 *
	 * Constraint:
	 *     ownedPredicates+=PredicateCS*
	 */
	protected void sequence_WhenCS(ISerializationContext context, PatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     WhereCS returns PatternCS
	 *
	 * Constraint:
	 *     ownedPredicates+=PredicateCS*
	 */
	protected void sequence_WhereCS(ISerializationContext context, PatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
