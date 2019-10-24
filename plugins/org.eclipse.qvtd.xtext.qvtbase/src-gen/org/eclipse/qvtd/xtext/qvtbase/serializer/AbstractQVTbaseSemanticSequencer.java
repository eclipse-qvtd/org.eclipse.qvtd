/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.basecs.AttributeCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.EnumerationCS;
import org.eclipse.ocl.xtext.basecs.EnumerationLiteralCS;
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
import org.eclipse.ocl.xtext.essentialocl.serializer.EssentialOCLSemanticSequencer;
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
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;
import org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS;
import org.eclipse.qvtd.xtext.qvtbasecs.TargetCS;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;

@SuppressWarnings("all")
public abstract class AbstractQVTbaseSemanticSequencer extends EssentialOCLSemanticSequencer {

	@Inject
	private QVTbaseGrammarAccess grammarAccess;

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
				else if (rule == grammarAccess.getSimplePathNameCSRule()) {
					sequence_SimplePathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getPrimitiveTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
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
					sequence_PrimitiveTypeCS_TypedMultiplicityRefCS(context, (PrimitiveTypeRefCS) semanticObject);
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
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTupleTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
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
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TupleTypeCS_TypedMultiplicityRefCS(context, (TupleTypeCS) semanticObject);
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
				else if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()
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
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getCollectionTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
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
					sequence_CollectionTypeCS_TypedMultiplicityRefCS(context, (CollectionTypeCS) semanticObject);
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
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getMapTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
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
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_MapTypeCS_TypedMultiplicityRefCS(context, (MapTypeCS) semanticObject);
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
				else if (rule == grammarAccess.getTypeNameExpCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.VARIABLE_CS:
				sequence_CoIteratorVariableCS(context, (VariableCS) semanticObject);
				return;
			}
		else if (epackage == QVTbaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case QVTbaseCSPackage.COMPOUND_TARGET_ELEMENT_CS:
				sequence_CompoundTargetElementCS(context, (CompoundTargetElementCS) semanticObject);
				return;
			case QVTbaseCSPackage.SIMPLE_TARGET_ELEMENT_CS:
				sequence_SimpleTargetElementCS(context, (SimpleTargetElementCS) semanticObject);
				return;
			case QVTbaseCSPackage.TARGET_CS:
				sequence_TargetCS(context, (TargetCS) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 *     AttributeCS returns AttributeCS
	 *     StructuralFeatureCS returns AttributeCS
	 *
	 * Constraint:
	 *     (
	 *         ((qualifiers+='static' qualifiers+='definition'?) | (qualifiers+='definition' qualifiers+='static'?))?
	 *         name=UnrestrictedName
	 *         ownedType=TypedMultiplicityRefCS?
	 *         default=SINGLE_QUOTED_STRING?
	 *         (
	 *             qualifiers+='derived' |
	 *             qualifiers+='!derived' |
	 *             qualifiers+='id' |
	 *             qualifiers+='!id' |
	 *             qualifiers+='ordered' |
	 *             qualifiers+='!ordered' |
	 *             qualifiers+='readonly' |
	 *             qualifiers+='!readonly' |
	 *             qualifiers+='transient' |
	 *             qualifiers+='!transient' |
	 *             qualifiers+='unique' |
	 *             qualifiers+='!unique' |
	 *             qualifiers+='unsettable' |
	 *             qualifiers+='!unsettable' |
	 *             qualifiers+='volatile' |
	 *             qualifiers+='!volatile'
	 *         )*
	 *         ownedDefaultExpressions+=SpecificationCS?
	 *         (ownedDefaultExpressions+=SpecificationCS? ownedDefaultExpressions+=SpecificationCS?)*
	 *     )
	 */
	protected void sequence_AttributeCS(ISerializationContext context, AttributeCS semanticObject) {
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
	 *     )
	 */
	protected void sequence_CollectionTypeCS_TypedMultiplicityRefCS(ISerializationContext context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     CompoundTargetElementCS returns CompoundTargetElementCS
	 *
	 * Constraint:
	 *     ownedTargetElements+=SimpleTargetElementCS+
	 */
	protected void sequence_CompoundTargetElementCS(ISerializationContext context, CompoundTargetElementCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ClassCS returns DataTypeCS
	 *     DataTypeCS returns DataTypeCS
	 *
	 * Constraint:
	 *     (
	 *         isPrimitive?='primitive'?
	 *         name=UnrestrictedName
	 *         ownedSignature=TemplateSignatureCS?
	 *         instanceClassName=SINGLE_QUOTED_STRING?
	 *         isSerializable?='serializable'?
	 *     )
	 */
	protected void sequence_DataTypeCS(ISerializationContext context, DataTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ClassCS returns EnumerationCS
	 *     EnumerationCS returns EnumerationCS
	 *
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName
	 *         ownedSignature=TemplateSignatureCS?
	 *         instanceClassName=SINGLE_QUOTED_STRING?
	 *         isSerializable?='serializable'?
	 *         ownedLiterals+=EnumerationLiteralCS*
	 *     )
	 */
	protected void sequence_EnumerationCS(ISerializationContext context, EnumerationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     EnumerationLiteralCS returns EnumerationLiteralCS
	 *
	 * Constraint:
	 *     ((name=UnrestrictedName | name=EnumerationLiteralName) value=SIGNED?)
	 */
	protected void sequence_EnumerationLiteralCS(ISerializationContext context, EnumerationLiteralCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedMultiplicityRefCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_MapTypeCS_TypedMultiplicityRefCS(ISerializationContext context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     OperationCS returns OperationCS
	 *
	 * Constraint:
	 *     (
	 *         ((qualifiers+='static' qualifiers+='definition'?) | (qualifiers+='definition' qualifiers+='static'?))?
	 *         ownedSignature=TemplateSignatureCS?
	 *         name=UnrestrictedName
	 *         (ownedParameters+=ParameterCS ownedParameters+=ParameterCS*)?
	 *         ownedType=TypedMultiplicityRefCS?
	 *         (ownedExceptions+=TypedRefCS ownedExceptions+=TypedRefCS*)?
	 *         (
	 *             qualifiers+='derived' |
	 *             qualifiers+='!derived' |
	 *             qualifiers+='ordered' |
	 *             qualifiers+='!ordered' |
	 *             qualifiers+='unique' |
	 *             qualifiers+='!unique'
	 *         )*
	 *         ownedBodyExpressions+=SpecificationCS*
	 *     )
	 */
	protected void sequence_OperationCS(ISerializationContext context, OperationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ParameterCS returns ParameterCS
	 *
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName
	 *         ownedType=TypedMultiplicityRefCS?
	 *         (qualifiers+='ordered' | qualifiers+='!ordered' | qualifiers+='unique' | qualifiers+='!unique')*
	 *     )
	 */
	protected void sequence_ParameterCS(ISerializationContext context, ParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedMultiplicityRefCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypedMultiplicityRefCS(ISerializationContext context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ReferenceCS returns ReferenceCS
	 *     StructuralFeatureCS returns ReferenceCS
	 *
	 * Constraint:
	 *     (
	 *         ((qualifiers+='static' qualifiers+='definition'?) | (qualifiers+='definition' qualifiers+='static'?))?
	 *         name=UnrestrictedName
	 *         referredOpposite=[Property|UnrestrictedName]?
	 *         ownedType=TypedMultiplicityRefCS?
	 *         default=SINGLE_QUOTED_STRING?
	 *         (
	 *             qualifiers+='composes' |
	 *             qualifiers+='!composes' |
	 *             qualifiers+='derived' |
	 *             qualifiers+='!derived' |
	 *             qualifiers+='ordered' |
	 *             qualifiers+='!ordered' |
	 *             qualifiers+='readonly' |
	 *             qualifiers+='!readonly' |
	 *             qualifiers+='resolve' |
	 *             qualifiers+='!resolve' |
	 *             qualifiers+='transient' |
	 *             qualifiers+='!transient' |
	 *             qualifiers+='unique' |
	 *             qualifiers+='!unique' |
	 *             qualifiers+='unsettable' |
	 *             qualifiers+='!unsettable' |
	 *             qualifiers+='volatile' |
	 *             qualifiers+='!volatile'
	 *         )*
	 *         ownedDefaultExpressions+=SpecificationCS?
	 *         (ownedDefaultExpressions+=SpecificationCS? ownedDefaultExpressions+=SpecificationCS?)*
	 *     )
	 */
	protected void sequence_ReferenceCS(ISerializationContext context, ReferenceCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     SimpleTargetElementCS returns SimpleTargetElementCS
	 *
	 * Constraint:
	 *     (
	 *         (input?='input' | output?='output' | via?='via')
	 *         typedModel=[TypedModel|UnrestrictedName]
	 *         (iterates+=[TypedModel|UnrestrictedName] | (iterates+=[TypedModel|UnrestrictedName] iterates+=[TypedModel|UnrestrictedName]*))?
	 *     )
	 */
	protected void sequence_SimpleTargetElementCS(ISerializationContext context, SimpleTargetElementCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     SpecificationCS returns ExpSpecificationCS
	 *
	 * Constraint:
	 *     (ownedExpression=ExpCS | exprString=UNQUOTED_STRING)
	 */
	protected void sequence_SpecificationCS(ISerializationContext context, ExpSpecificationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     ClassCS returns StructuredClassCS
	 *     StructuredClassCS returns StructuredClassCS
	 *
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'?
	 *         name=UnrestrictedName
	 *         ownedSignature=TemplateSignatureCS?
	 *         (ownedSuperTypes+=TypedRefCS ownedSuperTypes+=TypedRefCS*)?
	 *         instanceClassName=SINGLE_QUOTED_STRING?
	 *         isInterface?='interface'?
	 *         (ownedOperations+=OperationCS | ownedProperties+=StructuralFeatureCS)*
	 *     )
	 */
	protected void sequence_StructuredClassCS(ISerializationContext context, StructuredClassCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TargetCS returns TargetCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName (ownedTargetElements+=SimpleTargetElementCS | ownedTargetElements+=CompoundTargetElementCS)*)
	 */
	protected void sequence_TargetCS(ISerializationContext context, TargetCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedMultiplicityRefCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypedMultiplicityRefCS(ISerializationContext context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 *     TypedMultiplicityRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS ownedBinding=TemplateBindingCS? ownedMultiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypedMultiplicityRefCS_TypedTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
