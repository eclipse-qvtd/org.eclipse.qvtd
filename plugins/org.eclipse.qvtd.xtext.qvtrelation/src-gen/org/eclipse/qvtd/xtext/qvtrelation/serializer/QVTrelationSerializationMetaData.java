/*******************************************************************************
 * Copyright (c) 2011, 2024 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtrelation.serializer;

import com.google.inject.Inject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.serializer.AbstractSerializationMetaData;
import org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport;
import org.eclipse.ocl.xtext.base.serializer.EClassValue;
import org.eclipse.ocl.xtext.base.serializer.EClassValue.EReference_TargetGrammarRuleVector;
import org.eclipse.ocl.xtext.base.serializer.EnumerationValue;
import org.eclipse.ocl.xtext.base.serializer.EnumerationValue.EnumerationValueMultiple;
import org.eclipse.ocl.xtext.base.serializer.EnumerationValue.EnumerationValueSingle;
import org.eclipse.ocl.xtext.base.serializer.GrammarCardinality;
import org.eclipse.ocl.xtext.base.serializer.GrammarRuleValue;
import org.eclipse.ocl.xtext.base.serializer.GrammarRuleVector;
import org.eclipse.ocl.xtext.base.serializer.SerializationMatchStep;
import org.eclipse.ocl.xtext.base.serializer.SerializationMatchTerm;
import org.eclipse.ocl.xtext.base.serializer.SerializationMetaData;
import org.eclipse.ocl.xtext.base.serializer.SerializationRule;
import org.eclipse.ocl.xtext.base.serializer.SerializationRule.SerializationFeature;
import org.eclipse.ocl.xtext.base.serializer.SerializationSegment;
import org.eclipse.ocl.xtext.base.serializer.SerializationSegment.CustomSerializationSegment;
import org.eclipse.ocl.xtext.base.serializer.SerializationStep;
import org.eclipse.ocl.xtext.base.serializer.SubstringStep;
import org.eclipse.ocl.xtext.base.serializer.TerminalRuleValue;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.service.GrammarProvider;

/******* This file is 100% auto-generated - do not edit it *******/

/**
 * The QVTrelationSerializationMetaData singleton provides the metadata to support a
 * model to text serialization of a parsed Xtext semantic model or to re-format an Xtext text node model.
 */
public class QVTrelationSerializationMetaData extends AbstractSerializationMetaData
{
	/**
	 * The Provider supports injected creation of the QVTrelationSerializationMetaData singleton.
	 */
	public static class Provider implements SerializationMetaData.Provider
	{
		private static @Nullable QVTrelationSerializationMetaData INSTANCE = null;

		@Inject
		private GrammarProvider grammarProvider;

		@Override
		public synchronized @NonNull SerializationMetaData get() {
			// synchronized synchronizes the creation of this singleton.
			// It does not imply that the overall application is threadsafe.
			QVTrelationSerializationMetaData instance = INSTANCE;
			if (instance == null) {
				assert grammarProvider != null;
				Grammar grammar = grammarProvider.getGrammar(Provider.class);
				assert grammar != null;
				INSTANCE = instance = new QVTrelationSerializationMetaData(grammar);
			}
			return instance;
		}
	}

	private final @NonNull EClassValue @NonNull [] eClassValues = new @NonNull EClassValue[83];
	private final @NonNull EnumerationValue @NonNull [] enumerationValues = new @NonNull EnumerationValue[27];
	private final @NonNull GrammarRuleValue @NonNull [] grammarRuleValues = new @NonNull GrammarRuleValue[146];
	private final @NonNull GrammarRuleVector @NonNull [] grammarRuleVectors = new @NonNull GrammarRuleVector[86];
	private final @NonNull SerializationMatchStep @NonNull [] serializationMatchSteps = new @NonNull SerializationMatchStep[440];
	private final @NonNull SerializationMatchTerm @NonNull [] serializationMatchTerms = new @NonNull SerializationMatchTerm[325];
	private final @NonNull SerializationRule @NonNull [] serializationRules = new @NonNull SerializationRule[179];
	private final @NonNull SerializationSegment @NonNull [] @NonNull [] serializationSegments = new @NonNull SerializationSegment @NonNull [29] @NonNull [];
	private final @NonNull SerializationStep @NonNull [] serializationSteps = new @NonNull SerializationStep[344];
	private final @NonNull SubstringStep @NonNull [] substringSteps = new @NonNull SubstringStep[10];
	private final @Nullable String @Nullable [] multipleLineCommentMidfixes = new @Nullable String[] {" *"};
	private final @NonNull String @Nullable [] multipleLineCommentPrefixes = new @NonNull String[] {"/*"};
	private final @NonNull String @Nullable [] multipleLineCommentSuffixes = new @NonNull String[] {"*/"};
	private final @NonNull String @Nullable [] singleLineCommentPrefixes = new @NonNull String[] {"--"};

	private QVTrelationSerializationMetaData(@NonNull Grammar grammar) {
		super(grammar);
		initGrammarRuleVectors();
		initEnumerationValues();
		initMatchTerms();
		initMatchSteps();
		initSerializationSegments();
		initSerializationSteps();
		initSerializationRules0();
		initSerializationRules1();
		initSerializationRules2();
		initSubstringSteps();
		initGrammarRuleValues();
		initEClassValues();
	}

	@Override
	public @NonNull EClassValue @NonNull [] getEClassValues() {
		return eClassValues;
	}

	@Override
	public @NonNull EnumerationValue @NonNull [] getEnumerationValues() {
		return enumerationValues;
	}

	@Override
	protected int getFirstGlobalSerializationStepAssignmentIndex() {
		return 0;
	}

	@Override
	protected int getFirstGlobalSerializationStepLiteralIndex() {
		return 161;
	}

	@Override
	public @NonNull GrammarRuleValue @NonNull [] getGrammarRuleValues() {
		return grammarRuleValues;
	}

	@Override
	public @NonNull GrammarRuleVector @NonNull [] getGrammarRuleVectors() {
		return grammarRuleVectors;
	}

	@Override
	protected int getLastGlobalSerializationStepAssignmentIndex() {
		return 160;
	}

	@Override
	protected int getLastGlobalSerializationStepLiteralIndex() {
		return 239;
	}

	@Override
	public @Nullable String @Nullable [] getMultipleLineCommentMidfixes() {
		return multipleLineCommentMidfixes;
	}

	@Override
	public @NonNull String @Nullable [] getMultipleLineCommentPrefixes() {
		return multipleLineCommentPrefixes;
	}

	@Override
	public @NonNull String @Nullable [] getMultipleLineCommentSuffixes() {
		return multipleLineCommentSuffixes;
	}

	@Override
	public @NonNull SerializationMatchStep @NonNull [] getSerializationMatchSteps() {
		return serializationMatchSteps;
	}

	@Override
	public @NonNull SerializationMatchTerm @NonNull [] getSerializationMatchTerms() {
		return serializationMatchTerms;
	}

	@Override
	public @NonNull SerializationRule @NonNull [] getSerializationRules() {
		return serializationRules;
	}

	@Override
	public @NonNull SerializationSegment @NonNull [] @NonNull [] getSerializationSegments() {
		return serializationSegments;
	}

	@Override
	public @NonNull SerializationStep @NonNull [] getSerializationSteps() {
		return serializationSteps;
	}

	@Override
	public @NonNull String @Nullable [] getSingleLineCommentPrefixes() {
		return singleLineCommentPrefixes;
	}

	@Override
	public @NonNull SubstringStep @NonNull [] getSubstringSteps() {
		return substringSteps;
	}

	/**
	 * Initialize configuration for each EClassifier that may be serialized.
	 */
	private void initEClassValues() {
		eClassValues[0] = new EClassValue(BaseCSPackage.Literals.ATTRIBUTE_CS,
			createSerializationRules(
				86 /* AttributeCS-4: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] ';' */,
				82 /* AttributeCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				84 /* AttributeCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				87 /* AttributeCS-5: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V5:?] ';')[V4:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] '}' */,
				83 /* AttributeCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				85 /* AttributeCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS,
					44) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					67) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[1] = new EClassValue(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS,
			createSerializationRules(
				17 /* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			), null
		);
		eClassValues[2] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS,
			createSerializationRules(
				19 /* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS,
					1) /* CollectionLiteralPartCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE,
					2) /* CollectionTypeCS */
			}
		);
		eClassValues[3] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS,
			createSerializationRules(
				21 /* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */,
				20 /* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION,
					79) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[4] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS,
			createSerializationRules(
				22 /* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */,
				70 /* TypeExpCS-4: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS,
					27) /* PatternExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE,
					2) /* CollectionTypeCS */
			}
		);
		eClassValues[5] = new EClassValue(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS,
			createSerializationRules(
				132 /* CollectionTemplateCS-0: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=CollectionTypeCS ('{' (CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS (',' CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS)[V3:*] '++' CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS)[V2:?] '}')[V1:?] */,
				166 /* TemplateCS-0: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=CollectionTypeCS ('{' (CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS (',' CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS)[V3:*] '++' CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS)[V2:?] '}')[V1:?] ('{' TemplateCS::ownedGuardExpression=ExpCS '}')[V4:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TEMPLATE_CS__OWNED_GUARD_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS,
					52) /* ElementTemplateCS|TemplateCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER,
					6) /* ElementTemplateCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE,
					2) /* CollectionTypeCS */
			}
		);
		eClassValues[6] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS,
			createSerializationRules(
				172 /* TypedRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				23 /* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				67 /* TypeExpCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				74 /* TypeLiteralWithMultiplicityCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				131 /* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE,
					64) /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */
			}
		);
		eClassValues[7] = new EClassValue(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS,
			createSerializationRules(
				88 /* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS,
					42) /* SimpleTargetElementCS */
			}
		);
		eClassValues[8] = new EClassValue(EssentialOCLCSPackage.Literals.CONTEXT_CS,
			createSerializationRules(
				35 /* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[9] = new EClassValue(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				24 /* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS,
					41) /* ShadowPartCS */
			}
		);
		eClassValues[10] = new EClassValue(BaseCSPackage.Literals.DATA_TYPE_CS,
			createSerializationRules(
				93 /* DataTypeCS-4: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] ';' */,
				89 /* DataTypeCS-0: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] ';' */,
				91 /* DataTypeCS-2: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] ';' */,
				94 /* DataTypeCS-5: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] '{' '}' */,
				90 /* DataTypeCS-1: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] '{' '}' */,
				92 /* DataTypeCS-3: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] '{' '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					54) /* TemplateSignatureCS */
			}
		);
		eClassValues[11] = new EClassValue(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS,
			createSerializationRules(
				133 /* DefaultValueCS-0: DefaultValueCS::propertyId=UnrestrictedName '=' DefaultValueCS::ownedInitExpression=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[12] = new EClassValue(QVTrelationCSPackage.Literals.DOMAIN_CS,
			createSerializationRules(
				137 /* DomainCS-3: 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */,
				134 /* DomainCS-0: 'replace' 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */,
				135 /* DomainCS-1: DomainCS::isCheckonly?='checkonly' 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */,
				136 /* DomainCS-2: DomainCS::isEnforce?='enforce' 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES,
					4) /* DefaultValueCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS,
					5) /* DomainPatternCS */
			}
		);
		eClassValues[13] = new EClassValue(QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS,
			createSerializationRules(
				138 /* DomainPatternCS-0: DomainPatternCS::ownedTemplate=TemplateCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS__OWNED_TEMPLATE,
					51) /* TemplateCS */
			}
		);
		eClassValues[14] = new EClassValue(QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS,
			createSerializationRules(
				139 /* ElementTemplateCS-0: ElementTemplateCS::identifier=UnrestrictedName */
			), null
		);
		eClassValues[15] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_CS,
			createSerializationRules(
				99 /* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				95 /* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				97 /* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				100 /* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				96 /* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				98 /* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS,
					8) /* EnumerationLiteralCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					54) /* TemplateSignatureCS */
			}
		);
		eClassValues[16] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS,
			createSerializationRules(
				103 /* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				101 /* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				104 /* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				102 /* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			), null
		);
		eClassValues[17] = new EClassValue(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS,
			createSerializationRules(
				124 /* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				125 /* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[18] = new EClassValue(EssentialOCLCSPackage.Literals.IF_EXP_CS,
			createSerializationRules(
				27 /* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION,
					79) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS,
					7) /* ElseIfThenExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[19] = new EClassValue(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS,
			createSerializationRules(
				25 /* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[20] = new EClassValue(BaseCSPackage.Literals.IMPORT_CS,
			createSerializationRules(
				174 /* UnitCS-0: 'import' (NamedElementCS::name=UnrestrictedName ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS ('::' ImportCS::isAll?='*')[V1:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME,
					71) /* URIPathNameCS */
			}
		);
		eClassValues[21] = new EClassValue(EssentialOCLCSPackage.Literals.INFIX_EXP_CS,
			createSerializationRules(
				26 /* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[22] = new EClassValue(EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS,
			createSerializationRules(
				28 /* InvalidLiteralExpCS-0: 'invalid' */
			), null
		);
		eClassValues[23] = new EClassValue(QVTrelationCSPackage.Literals.KEY_DECL_CS,
			createSerializationRules(
				140 /* KeyDeclCS-0: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' KeyDeclCS::propertyIds+=UnrestrictedName (',' KeyDeclCS::propertyIds+=UnrestrictedName)[V0:*] '}' ';' */,
				142 /* KeyDeclCS-2: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')' (',' KeyDeclCS::propertyIds+=UnrestrictedName)[V0:*] '}' ';' */,
				141 /* KeyDeclCS-1: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' KeyDeclCS::propertyIds+=UnrestrictedName (',' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')')[V0:*] '}' ';' */,
				143 /* KeyDeclCS-3: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')' (',' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')')[V0:*] '}' ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS,
					26) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME,
					26) /* PathNameCS */
			}
		);
		eClassValues[24] = new EClassValue(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS,
			createSerializationRules(
				29 /* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[25] = new EClassValue(EssentialOCLCSPackage.Literals.LET_EXP_CS,
			createSerializationRules(
				30 /* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES,
					13) /* LetVariableCS */
			}
		);
		eClassValues[26] = new EClassValue(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS,
			createSerializationRules(
				31 /* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					39) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[27] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS,
			createSerializationRules(
				32 /* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS,
					14) /* MapLiteralPartCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE,
					15) /* MapTypeCS */
			}
		);
		eClassValues[28] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS,
			createSerializationRules(
				33 /* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS 'with' MapLiteralPartCS::ownedValue=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[29] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_TYPE_CS,
			createSerializationRules(
				34 /* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				68 /* TypeExpCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				75 /* TypeLiteralWithMultiplicityCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE,
					60) /* TypeExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[30] = new EClassValue(QVTrelationCSPackage.Literals.MODEL_DECL_CS,
			createSerializationRules(
				144 /* ModelDeclCS-0: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V0:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V1:?] */,
				148 /* ModelDeclCS-4: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V1:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V2:?] */,
				145 /* ModelDeclCS-1: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V0:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V3:*])[V2:?] ('}')[1])[V1:?] */,
				146 /* ModelDeclCS-2: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V2:*])[V1:?] ('}')[1])[V0:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V3:?] */,
				149 /* ModelDeclCS-5: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V1:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V4:*])[V3:?] ('}')[1])[V2:?] */,
				150 /* ModelDeclCS-6: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V3:*])[V2:?] ('}')[1])[V1:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V4:?] */,
				147 /* ModelDeclCS-3: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V2:*])[V1:?] ('}')[1])[V0:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V5:*])[V4:?] ('}')[1])[V3:?] */,
				151 /* ModelDeclCS-7: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V3:*])[V2:?] ('}')[1])[V1:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V6:*])[V5:?] ('}')[1])[V4:?] */
			), null
		);
		eClassValues[31] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS,
			createSerializationRules(
				1 /* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */,
				4 /* MultiplicityCS-2: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] ']' */,
				2 /* MultiplicityCS-0: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] '|?' ']' */,
				3 /* MultiplicityCS-1: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] MultiplicityCS::isNullFree?='|1' ']' */
			), null
		);
		eClassValues[32] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS,
			createSerializationRules(
				7 /* MultiplicityCS-5: '[' MultiplicityStringCS::stringBounds='*|+|?' ']' */,
				5 /* MultiplicityCS-3: '[' MultiplicityStringCS::stringBounds='*|+|?' '|?' ']' */,
				6 /* MultiplicityCS-4: '[' MultiplicityStringCS::stringBounds='*|+|?' MultiplicityCS::isNullFree?='|1' ']' */,
				8 /* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			), null
		);
		eClassValues[33] = new EClassValue(EssentialOCLCSPackage.Literals.NAME_EXP_CS,
			createSerializationRules(
				36 /* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					3) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME,
					26) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					39) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES,
					45) /* SquareBracketedClauseCS */
			}
		);
		eClassValues[34] = new EClassValue(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS,
			createSerializationRules(
				41 /* NavigatingArgCS-4: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */,
				37 /* NavigatingArgCS-0: ':' NavigatingArgCS::ownedType=TypeExpCS */,
				40 /* NavigatingArgCS-3: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				38 /* NavigatingArgCS-1: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				39 /* NavigatingArgCS-2: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				42 /* NavigatingBarArgCS-0: NavigatingArgCS::prefix='|' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */,
				46 /* NavigatingCommaArgCS-3: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */,
				45 /* NavigatingCommaArgCS-2: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				43 /* NavigatingCommaArgCS-0: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				44 /* NavigatingCommaArgCS-1: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				47 /* NavigatingSemiArgCS-0: NavigatingArgCS::prefix=';' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR,
					0) /* CoIteratorVariableCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION,
					78) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[35] = new EClassValue(EssentialOCLCSPackage.Literals.NESTED_EXP_CS,
			createSerializationRules(
				48 /* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[36] = new EClassValue(EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS,
			createSerializationRules(
				49 /* NullLiteralExpCS-0: 'null' */
			), null
		);
		eClassValues[37] = new EClassValue(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS,
			createSerializationRules(
				50 /* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			), null
		);
		eClassValues[38] = new EClassValue(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS,
			createSerializationRules(
				167 /* TemplateCS-1: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=TypedRefCS ('{' (ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS (',' ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS)[V3:*])[V2:?] '}')[V1:?] ('{' TemplateCS::ownedGuardExpression=ExpCS '}')[V4:?] */,
				152 /* ObjectTemplateCS-0: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=TypedRefCS ('{' (ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS (',' ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS)[V3:*])[V2:?] '}')[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TEMPLATE_CS__OWNED_GUARD_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES,
					35) /* PropertyTemplateCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE,
					68) /* TypedRefCS */
			}
		);
		eClassValues[39] = new EClassValue(BaseCSPackage.Literals.OPERATION_CS,
			createSerializationRules(
				109 /* OperationCS-4: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] ';' */,
				105 /* OperationCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				107 /* OperationCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				110 /* OperationCS-5: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				106 /* OperationCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */,
				108 /* OperationCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS,
					44) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS,
					68) /* TypedRefCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS,
					25) /* ParameterCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					54) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					67) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[40] = new EClassValue(QVTrelationCSPackage.Literals.PARAM_DECLARATION_CS,
			createSerializationRules(
				153 /* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[41] = new EClassValue(BaseCSPackage.Literals.PARAMETER_CS,
			createSerializationRules(
				111 /* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					67) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[42] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_CS,
			createSerializationRules(
				0 /* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */,
				9 /* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */,
				79 /* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			), null
		);
		eClassValues[43] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS,
			createSerializationRules(
				78 /* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */
			), null
		);
		eClassValues[44] = new EClassValue(BaseCSPackage.Literals.PATH_NAME_CS,
			createSerializationRules(
				10 /* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				15 /* UnreservedPathNameCS-0: PathNameCS::ownedPathElements+=NextPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				59 /* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */,
				80 /* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				165 /* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS,
					70) /* FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS */
			}
		);
		eClassValues[45] = new EClassValue(QVTrelationCSPackage.Literals.PATTERN_CS,
			createSerializationRules(
				177 /* WhenCS-0: 'when' '{' (PatternCS::ownedPredicates+=PredicateCS)[V0:*] '}' */,
				178 /* WhereCS-0: 'where' '{' (PatternCS::ownedPredicates+=PredicateCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.PATTERN_CS__OWNED_PREDICATES,
					29) /* PredicateCS */
			}
		);
		eClassValues[46] = new EClassValue(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS,
			createSerializationRules(
				51 /* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[47] = new EClassValue(QVTrelationCSPackage.Literals.PREDICATE_CS,
			createSerializationRules(
				154 /* PredicateCS-0: PredicateCS::ownedCondition=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[48] = new EClassValue(EssentialOCLCSPackage.Literals.PREFIX_EXP_CS,
			createSerializationRules(
				52 /* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				53 /* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					76) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[49] = new EClassValue(QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS,
			createSerializationRules(
				155 /* PrimitiveTypeDomainCS-0: 'primitive' 'domain' PrimitiveTypeDomainCS::ownedPatterns+=PrimitiveTypeDomainPatternCS (',' PrimitiveTypeDomainCS::ownedPatterns+=PrimitiveTypeDomainPatternCS)[V0:*] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS,
					34) /* PrimitiveTypeDomainPatternCS */
			}
		);
		eClassValues[50] = new EClassValue(QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_PATTERN_CS,
			createSerializationRules(
				156 /* PrimitiveTypeDomainPatternCS-0: NamedElementCS::name=UnrestrictedName ':' TemplateVariableCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[51] = new EClassValue(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS,
			createSerializationRules(
				170 /* TypedRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				54 /* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				66 /* TypeExpCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				73 /* TypeLiteralWithMultiplicityCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				129 /* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */
			}
		);
		eClassValues[52] = new EClassValue(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS,
			createSerializationRules(
				157 /* PropertyTemplateCS-0: PropertyTemplateCS::propertyId=UnrestrictedName '=' PropertyTemplateCS::ownedExpression=ExpCSOrTemplateCS */,
				158 /* PropertyTemplateCS-1: 'opposite' '(' PropertyTemplateCS::ownedOppositePropertyId=PathNameCS ')' '=' PropertyTemplateCS::ownedExpression=ExpCSOrTemplateCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION,
					80) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|ExpCSOrTemplateCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TemplateCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID,
					26) /* PathNameCS */
			}
		);
		eClassValues[53] = new EClassValue(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS,
			createSerializationRules(
				159 /* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				160 /* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES,
					57) /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					36) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME,
					40) /* ScopeNameCS */
			}
		);
		eClassValues[54] = new EClassValue(QVTrelationCSPackage.Literals.QUERY_CS,
			createSerializationRules(
				161 /* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				162 /* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				163 /* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS,
					24) /* ParamDeclarationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[55] = new EClassValue(BaseCSPackage.Literals.REFERENCE_CS,
			createSerializationRules(
				116 /* ReferenceCS-4: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				112 /* ReferenceCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				114 /* ReferenceCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				117 /* ReferenceCS-5: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				113 /* ReferenceCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				115 /* ReferenceCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS,
					44) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					67) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[56] = new EClassValue(QVTrelationCSPackage.Literals.RELATION_CS,
			createSerializationRules(
				164 /* RelationCS-0: (RelationCS::isTop?='top')[V0:?] (RelationCS::isAbstract?='abstract')[V1:?] 'relation' NamedElementCS::name=UnrestrictedName ('overrides' RelationCS::overridden=UnrestrictedName)[V2:?] '{' (RelationCS::ownedVarDeclarations+=VarDeclarationCS)[V3:*] (RelationCS::ownedDomains+=DomainCS|PrimitiveTypeDomainCS)[V4:+] (RelationCS::ownedWhen=WhenCS)[V5:?] (RelationCS::ownedWhere=WhereCS)[V6:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_DOMAINS,
					33) /* DomainCS|PrimitiveTypeDomainCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_VAR_DECLARATIONS,
					81) /* VarDeclarationCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHEN,
					83) /* WhenCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHERE,
					84) /* WhereCS */
			}
		);
		eClassValues[57] = new EClassValue(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				55 /* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS,
					20) /* NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS */
			}
		);
		eClassValues[58] = new EClassValue(EssentialOCLCSPackage.Literals.SELF_EXP_CS,
			createSerializationRules(
				56 /* SelfExpCS-0: 'self' */
			), null
		);
		eClassValues[59] = new EClassValue(EssentialOCLCSPackage.Literals.SHADOW_PART_CS,
			createSerializationRules(
				58 /* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */,
				57 /* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION,
					79) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[60] = new EClassValue(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS,
			createSerializationRules(
				118 /* SimpleTargetElementCS-0: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				120 /* SimpleTargetElementCS-2: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				122 /* SimpleTargetElementCS-4: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				119 /* SimpleTargetElementCS-1: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				121 /* SimpleTargetElementCS-3: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				123 /* SimpleTargetElementCS-5: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */
			), null
		);
		eClassValues[61] = new EClassValue(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				60 /* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[62] = new EClassValue(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS,
			createSerializationRules(
				61 /* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			), null
		);
		eClassValues[63] = new EClassValue(BaseCSPackage.Literals.STRUCTURED_CLASS_CS,
			createSerializationRules(
				126 /* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				127 /* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS,
					23) /* OperationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES,
					48) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					54) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES,
					68) /* TypedRefCS */
			}
		);
		eClassValues[64] = new EClassValue(QVTbaseCSPackage.Literals.TARGET_CS,
			createSerializationRules(
				128 /* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS,
					43) /* CompoundTargetElementCS|SimpleTargetElementCS */
			}
		);
		eClassValues[65] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_BINDING_CS,
			createSerializationRules(
				11 /* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS,
					53) /* TemplateParameterSubstitutionCS */
			}
		);
		eClassValues[66] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS,
			createSerializationRules(
				12 /* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER,
					85) /* TypeRefCS|TypedRefCS|WildcardTypeRefCS */
			}
		);
		eClassValues[67] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS,
			createSerializationRules(
				13 /* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS,
					65) /* TypeParameterCS */
			}
		);
		eClassValues[68] = new EClassValue(QVTrelationCSPackage.Literals.TOP_LEVEL_CS,
			createSerializationRules(
				168 /* TopLevelCS-0: (RootCS::ownedImports+=UnitCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS,
					72) /* UnitCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					36) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS,
					55) /* TransformationCS */
			}
		);
		eClassValues[69] = new EClassValue(QVTrelationCSPackage.Literals.TRANSFORMATION_CS,
			createSerializationRules(
				169 /* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' TransformationCS::ownedModelDecls+=ModelDeclCS (',' TransformationCS::ownedModelDecls+=ModelDeclCS)[V1:*] ')' ('extends' TransformationCS::extends+=UnrestrictedName (',' TransformationCS::extends+=UnrestrictedName)[V3:*])[V2:?] '{' (AbstractTransformationCS::ownedTargets+=TargetCS)[V4:*] (TransformationCS::ownedKeyDecls+=KeyDeclCS)[V5:*] (TransformationCS::ownedRelations+=RelationCS)[V6:*] (TransformationCS::ownedQueries+=QueryCS)[V7:*] (TransformationCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_KEY_DECLS,
					12) /* KeyDeclCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_MODEL_DECLS,
					16) /* ModelDeclCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME,
					40) /* ScopeNameCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES,
					48) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES,
					37) /* QueryCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_RELATIONS,
					38) /* RelationCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS,
					50) /* TargetCS */
			}
		);
		eClassValues[70] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS,
			createSerializationRules(
				62 /* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS,
					58) /* TupleLiteralPartCS */
			}
		);
		eClassValues[71] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS,
			createSerializationRules(
				63 /* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[72] = new EClassValue(BaseCSPackage.Literals.TUPLE_PART_CS,
			createSerializationRules(
				64 /* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[73] = new EClassValue(BaseCSPackage.Literals.TUPLE_TYPE_CS,
			createSerializationRules(
				65 /* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				71 /* TypeExpCS-5: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				76 /* TypeLiteralWithMultiplicityCS-3: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS,
					59) /* TuplePartCS */
			}
		);
		eClassValues[74] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS,
			createSerializationRules(
				72 /* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE,
					63) /* TypeLiteralWithMultiplicityCS */
			}
		);
		eClassValues[75] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS,
			createSerializationRules(
				69 /* TypeExpCS-3: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				77 /* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					3) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME,
					26) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[76] = new EClassValue(BaseCSPackage.Literals.TYPE_PARAMETER_CS,
			createSerializationRules(
				14 /* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS,
					68) /* TypedRefCS */
			}
		);
		eClassValues[77] = new EClassValue(BaseCSPackage.Literals.TYPED_TYPE_REF_CS,
			createSerializationRules(
				171 /* TypedRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				130 /* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				173 /* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME,
					26) /* PathNameCS */
			}
		);
		eClassValues[78] = new EClassValue(EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS,
			createSerializationRules(
				81 /* UnlimitedNaturalLiteralExpCS-0: '*' */
			), null
		);
		eClassValues[79] = new EClassValue(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS,
			createSerializationRules(
				175 /* VarDeclarationCS-0: VarDeclarationCS::ownedVarDeclarationIds+=VarDeclarationIdCS (',' VarDeclarationCS::ownedVarDeclarationIds+=VarDeclarationIdCS)[V0:*] (':' VarDeclarationCS::ownedType=TypeExpCS)[V1:?] ('=' VarDeclarationCS::ownedInitExpression=ExpCS)[V2:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_TYPE,
					60) /* TypeExpCS */,
				createEReference_TargetGrammarRuleVector(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS,
					82) /* VarDeclarationIdCS */
			}
		);
		eClassValues[80] = new EClassValue(QVTrelationCSPackage.Literals.VAR_DECLARATION_ID_CS,
			createSerializationRules(
				176 /* VarDeclarationIdCS-0: NamedElementCS::name=UnrestrictedName */
			), null
		);
		eClassValues[81] = new EClassValue(EssentialOCLCSPackage.Literals.VARIABLE_CS,
			createSerializationRules(
				18 /* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[82] = new EClassValue(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS,
			createSerializationRules(
				16 /* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS,
					68) /* TypedRefCS */
			}
		);
	}

	/**
	 * Initialize string combinations used by assigned String EAttributes.
	 */
	private void initEnumerationValues() {
		// 0: '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'
		enumerationValues[0] = new EnumerationValueMultiple(new @NonNull String[]{"!composes", "!derived", "!ordered", "!readonly", "!resolve", "!transient", "!unique", "!unsettable", "!volatile", "composes", "derived", "ordered", "readonly", "resolve", "transient", "unique", "unsettable", "volatile"});
		// 1: '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'
		enumerationValues[1] = new EnumerationValueMultiple(new @NonNull String[]{"!derived", "!id", "!ordered", "!readonly", "!transient", "!unique", "!unsettable", "!volatile", "derived", "id", "ordered", "readonly", "transient", "unique", "unsettable", "volatile"});
		// 2: '!derived|!ordered|!unique|derived|ordered|unique'
		enumerationValues[2] = new EnumerationValueMultiple(new @NonNull String[]{"!derived", "!ordered", "!unique", "derived", "ordered", "unique"});
		// 3: '!ordered|!unique|ordered|unique'
		enumerationValues[3] = new EnumerationValueMultiple(new @NonNull String[]{"!ordered", "!unique", "ordered", "unique"});
		// 4: '*'
		enumerationValues[4] = new EnumerationValueSingle("*");
		// 5: '*|+|?'
		enumerationValues[5] = new EnumerationValueMultiple(new @NonNull String[]{"*", "+", "?"});
		// 6: ','
		enumerationValues[6] = new EnumerationValueSingle(",");
		// 7: ';'
		enumerationValues[7] = new EnumerationValueSingle(";");
		// 8: '@'
		enumerationValues[8] = new EnumerationValueSingle("@");
		// 9: 'Map'
		enumerationValues[9] = new EnumerationValueSingle("Map");
		// 10: 'Tuple'
		enumerationValues[10] = new EnumerationValueSingle("Tuple");
		// 11: 'abstract'
		enumerationValues[11] = new EnumerationValueSingle("abstract");
		// 12: 'checkonly'
		enumerationValues[12] = new EnumerationValueSingle("checkonly");
		// 13: 'definition'
		enumerationValues[13] = new EnumerationValueSingle("definition");
		// 14: 'enforce'
		enumerationValues[14] = new EnumerationValueSingle("enforce");
		// 15: 'false|true'
		enumerationValues[15] = new EnumerationValueMultiple(new @NonNull String[]{"false", "true"});
		// 16: 'input'
		enumerationValues[16] = new EnumerationValueSingle("input");
		// 17: 'interface'
		enumerationValues[17] = new EnumerationValueSingle("interface");
		// 18: 'output'
		enumerationValues[18] = new EnumerationValueSingle("output");
		// 19: 'primitive'
		enumerationValues[19] = new EnumerationValueSingle("primitive");
		// 20: 'serializable'
		enumerationValues[20] = new EnumerationValueSingle("serializable");
		// 21: 'static'
		enumerationValues[21] = new EnumerationValueSingle("static");
		// 22: 'top'
		enumerationValues[22] = new EnumerationValueSingle("top");
		// 23: 'transient'
		enumerationValues[23] = new EnumerationValueSingle("transient");
		// 24: 'via'
		enumerationValues[24] = new EnumerationValueSingle("via");
		// 25: '|'
		enumerationValues[25] = new EnumerationValueSingle("|");
		// 26: '|1'
		enumerationValues[26] = new EnumerationValueSingle("|1");
	}

	/**
	 * Initialize the various serialization rules for each grammar rule.
	 */
	private void initGrammarRuleValues() {
		grammarRuleValues[0] = new TerminalRuleValue(0, "ANY_OTHER");
		grammarRuleValues[1] = createParserRuleValue(1, "AttributeCS", -1,
			createSerializationRules(
				82	/* AttributeCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				83	/* AttributeCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				84	/* AttributeCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				85	/* AttributeCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				86	/* AttributeCS-4: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] ';' */,
				87	/* AttributeCS-5: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V5:?] ';')[V4:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "attribute" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[2] = createDataTypeRuleValue(2, "BinaryOperatorName", 14 /* [soft-space, value, soft-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[3] = createParserRuleValue(3, "BooleanLiteralExpCS", -1,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* symbol="true" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* symbol="false" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[4] = createParserRuleValue(4, "ClassCS", 49 /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS */,
			createSerializationRules(
				89	/* DataTypeCS-0: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] ';' */,
				90	/* DataTypeCS-1: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] '{' '}' */,
				91	/* DataTypeCS-2: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] ';' */,
				92	/* DataTypeCS-3: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] '{' '}' */,
				93	/* DataTypeCS-4: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] ';' */,
				94	/* DataTypeCS-5: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] '{' '}' */,
				95	/* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				96	/* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				97	/* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				98	/* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				99	/* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				100	/* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				126	/* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				127	/* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* StructuredClassCS : [value] | [value] */,
			(0 << 16) | 0	/* DataTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* EnumerationCS : [value] | [value] */
		);
		grammarRuleValues[5] = createParserRuleValue(5, "CoIteratorVariableCS", -1,
			createSerializationRules(
				18	/* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[6] = createParserRuleValue(6, "CollectionLiteralExpCS", -1,
			createSerializationRules(
				19	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[7] = createParserRuleValue(7, "CollectionLiteralPartCS", -1,
			createSerializationRules(
				20	/* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */,
				21	/* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedLastExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=PatternExpCS : [value] | [value] */
		);
		grammarRuleValues[8] = createParserRuleValue(8, "CollectionPatternCS", -1,
			createSerializationRules(
				22	/* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "++" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* restVariableName=Identifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[9] = createParserRuleValue(9, "CollectionTemplateCS", -1,
			createSerializationRules(
				132	/* CollectionTemplateCS-0: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=CollectionTypeCS ('{' (CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS (',' CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS)[V3:*] '++' CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS)[V2:?] '}')[V1:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedMemberIdentifiers+=(TemplateCS|ElementTemplateCS) : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedMemberIdentifiers+=(TemplateCS|ElementTemplateCS) : [value] | [value] */,
			(0 << 16) | 14	/* "++" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRestIdentifier=ElementTemplateCS : [value] | [value] */,
			(0 << 16) | 10	/* "}" : [value] | [soft-new-line, pop, value] */
		);
		grammarRuleValues[10] = createParserRuleValue(10, "CollectionTypeCS", -1,
			createSerializationRules(
				23	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* name=CollectionTypeIdentifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpWithoutMultiplicityCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedCollectionMultiplicity=MultiplicityCS? : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[11] = createDataTypeRuleValue(11, "CollectionTypeIdentifier", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[12] = createParserRuleValue(12, "CompoundTargetElementCS", -1,
			createSerializationRules(
				88	/* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=SimpleTargetElementCS* : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[13] = createParserRuleValue(13, "CurlyBracketedClauseCS", -1,
			createSerializationRules(
				24	/* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {CurlyBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[14] = new TerminalRuleValue(14, "DOUBLE_QUOTED_STRING");
		grammarRuleValues[15] = createParserRuleValue(15, "DataTypeCS", -1,
			createSerializationRules(
				89	/* DataTypeCS-0: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] ';' */,
				90	/* DataTypeCS-1: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] '{' '}' */,
				91	/* DataTypeCS-2: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] ';' */,
				92	/* DataTypeCS-3: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] '{' '}' */,
				93	/* DataTypeCS-4: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] ';' */,
				94	/* DataTypeCS-5: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] '{' '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* isPrimitive?="primitive"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "datatype" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 14	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[16] = createParserRuleValue(16, "DefaultValueCS", -1,
			createSerializationRules(
				133	/* DefaultValueCS-0: DefaultValueCS::propertyId=UnrestrictedName '=' DefaultValueCS::ownedInitExpression=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* propertyId=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[17] = createParserRuleValue(17, "DomainCS", -1,
			createSerializationRules(
				134	/* DomainCS-0: 'replace' 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */,
				135	/* DomainCS-1: DomainCS::isCheckonly?='checkonly' 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */,
				136	/* DomainCS-2: DomainCS::isEnforce?='enforce' 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */,
				137	/* DomainCS-3: 'domain' DomainCS::modelId=UnrestrictedName (DomainCS::ownedPatterns+=DomainPatternCS (',' DomainCS::ownedPatterns+=DomainPatternCS)[V1:*])[V0:?] ('implementedby' DomainCS::implementedBy=UnrestrictedName)[V2:?] ('default_values' '{' (DomainCS::ownedDefaultValues+=DefaultValueCS)[V4:+] '}')[V3:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 14	/* isCheckonly?="checkonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* isEnforce?="enforce" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "replace" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "domain" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* modelId=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedPatterns+=DomainPatternCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatterns+=DomainPatternCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "implementedby" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* implementedBy=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "default_values" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedDefaultValues+=DefaultValueCS+ : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 15	/* ";" : [value] | [no-space, value, soft-new-line, half-new-line] */
		);
		grammarRuleValues[18] = createParserRuleValue(18, "DomainPatternCS", -1,
			createSerializationRules(
				138	/* DomainPatternCS-0: DomainPatternCS::ownedTemplate=TemplateCS */
			),
			(0 << 16) | 2	/* ownedTemplate=TemplateCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[19] = new TerminalRuleValue(19, "ESCAPED_CHARACTER");
		grammarRuleValues[20] = new TerminalRuleValue(20, "ESCAPED_ID");
		grammarRuleValues[21] = createParserRuleValue(21, "ElementTemplateCS", -1,
			createSerializationRules(
				139	/* ElementTemplateCS-0: ElementTemplateCS::identifier=UnrestrictedName */
			),
			(0 << 16) | 2	/* identifier=UnrestrictedName : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[22] = createParserRuleValue(22, "ElseIfThenExpCS", -1,
			createSerializationRules(
				25	/* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 28	/* "elseif" : [value] | [soft-new-line, pop, soft-space, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 17	/* "then" : [value] | [pop, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[23] = createParserRuleValue(23, "EnumerationCS", -1,
			createSerializationRules(
				95	/* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				96	/* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				97	/* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				98	/* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				99	/* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				100	/* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "enum" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 14	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedLiterals+=EnumerationLiteralCS* : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[24] = createParserRuleValue(24, "EnumerationLiteralCS", -1,
			createSerializationRules(
				101	/* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				102	/* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				103	/* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				104	/* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "literal" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=EnumerationLiteralName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* value=SIGNED : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[25] = createDataTypeRuleValue(25, "EnumerationLiteralName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[26] = createDataTypeRuleValue(26, "EssentialOCLInfixOperatorName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[27] = createDataTypeRuleValue(27, "EssentialOCLNavigationOperatorName", 6 /* [no-space, value, no-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[28] = createDataTypeRuleValue(28, "EssentialOCLReservedKeyword", 14 /* [soft-space, value, soft-space] */,
			4	/* 'else' : [soft-new-line, pop, value, push, soft-space] */,
			5	/* 'endif' : [soft-new-line, pop, value, soft-space] */,
			6	/* 'if' : [soft-new-line, value, push, soft-space] */,
			7	/* 'in' : [soft-space, pop, value, soft-new-line] */,
			8	/* 'let' : [soft-space, value, push] */,
			9	/* 'then' : [pop, soft-space, value, push, soft-space] */);
		grammarRuleValues[29] = createDataTypeRuleValue(29, "EssentialOCLUnaryOperatorName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[30] = createDataTypeRuleValue(30, "EssentialOCLUnreservedName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[31] = createDataTypeRuleValue(31, "EssentialOCLUnrestrictedName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[32] = createParserRuleValue(32, "ExpCS", 77 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				19	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				26	/* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */,
				27	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				28	/* InvalidLiteralExpCS-0: 'invalid' */,
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				30	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				32	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				36	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				49	/* NullLiteralExpCS-0: 'null' */,
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				52	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				53	/* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */,
				56	/* SelfExpCS-0: 'self' */,
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				62	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* PrefixedPrimaryExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* {InfixExpCS} : [value] | [value] */,
			(0 << 16) | 14	/* name=BinaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrefixedLetExpCS : [value] | [value] */
		);
		grammarRuleValues[33] = createParserRuleValue(33, "ExpCSOrTemplateCS", 80 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|ExpCSOrTemplateCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TemplateCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				19	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				26	/* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */,
				27	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				28	/* InvalidLiteralExpCS-0: 'invalid' */,
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				30	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				32	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				36	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				49	/* NullLiteralExpCS-0: 'null' */,
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				52	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				53	/* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */,
				56	/* SelfExpCS-0: 'self' */,
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				166	/* TemplateCS-0: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=CollectionTypeCS ('{' (CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS (',' CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS)[V3:*] '++' CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS)[V2:?] '}')[V1:?] ('{' TemplateCS::ownedGuardExpression=ExpCS '}')[V4:?] */,
				167	/* TemplateCS-1: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=TypedRefCS ('{' (ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS (',' ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS)[V3:*])[V2:?] '}')[V1:?] ('{' TemplateCS::ownedGuardExpression=ExpCS '}')[V4:?] */,
				62	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* TemplateCS : [value] | [value] */
		);
		grammarRuleValues[34] = createParserRuleValue(34, "FirstPathElementCS", -1,
			createSerializationRules(
				0	/* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 14	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[35] = createDataTypeRuleValue(35, "ID", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[36] = new TerminalRuleValue(36, "INT");
		grammarRuleValues[37] = createDataTypeRuleValue(37, "Identifier", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[38] = createParserRuleValue(38, "IfExpCS", -1,
			createSerializationRules(
				27	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 21	/* "if" : [value] | [soft-new-line, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 26	/* "then" : [value] | [pop, soft-space, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedIfThenExpressions+=ElseIfThenExpCS* : [value] | [value] */,
			(0 << 16) | 27	/* "else" : [value] | [soft-new-line, pop, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedElseExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 19	/* "endif" : [value] | [soft-new-line, pop, value, soft-space] */
		);
		grammarRuleValues[39] = createDataTypeRuleValue(39, "InfixOperatorName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[40] = createParserRuleValue(40, "InvalidLiteralExpCS", -1,
			createSerializationRules(
				28	/* InvalidLiteralExpCS-0: 'invalid' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {InvalidLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 14	/* "invalid" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[41] = createParserRuleValue(41, "KeyDeclCS", -1,
			createSerializationRules(
				140	/* KeyDeclCS-0: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' KeyDeclCS::propertyIds+=UnrestrictedName (',' KeyDeclCS::propertyIds+=UnrestrictedName)[V0:*] '}' ';' */,
				141	/* KeyDeclCS-1: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' KeyDeclCS::propertyIds+=UnrestrictedName (',' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')')[V0:*] '}' ';' */,
				142	/* KeyDeclCS-2: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')' (',' KeyDeclCS::propertyIds+=UnrestrictedName)[V0:*] '}' ';' */,
				143	/* KeyDeclCS-3: 'key' KeyDeclCS::ownedPathName=PathNameCS '{' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')' (',' 'opposite' '(' KeyDeclCS::ownedOppositePropertyIds+=PathNameCS ')')[V0:*] '}' ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "key" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* propertyIds+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "opposite" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedOppositePropertyIds+=PathNameCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* propertyIds+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "opposite" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedOppositePropertyIds+=PathNameCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[42] = new TerminalRuleValue(42, "LETTER_CHARACTER");
		grammarRuleValues[43] = createDataTypeRuleValue(43, "LOWER", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[44] = createParserRuleValue(44, "LambdaLiteralExpCS", -1,
			createSerializationRules(
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "Lambda" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpressionCS=ExpCS : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[45] = createParserRuleValue(45, "LetExpCS", -1,
			createSerializationRules(
				30	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "let" : [value] | [soft-space, value, push] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 22	/* "in" : [value] | [soft-space, pop, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedInExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[46] = createParserRuleValue(46, "LetVariableCS", -1,
			createSerializationRules(
				31	/* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[47] = new TerminalRuleValue(47, "ML_COMMENT");
		grammarRuleValues[48] = new TerminalRuleValue(48, "ML_SINGLE_QUOTED_STRING");
		grammarRuleValues[49] = createParserRuleValue(49, "MapLiteralExpCS", -1,
			createSerializationRules(
				32	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=MapTypeCS : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[50] = createParserRuleValue(50, "MapLiteralPartCS", -1,
			createSerializationRules(
				33	/* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS 'with' MapLiteralPartCS::ownedValue=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedKey=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValue=ExpCS : [value] | [value] */
		);
		grammarRuleValues[51] = createParserRuleValue(51, "MapTypeCS", -1,
			createSerializationRules(
				34	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* name="Map" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedKeyType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValueType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[52] = createParserRuleValue(52, "Model", -1,
			createSerializationRules(
				35	/* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			(0 << 16) | 2	/* ownedExpression=ExpCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[53] = createParserRuleValue(53, "ModelDeclCS", -1,
			createSerializationRules(
				144	/* ModelDeclCS-0: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V0:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V1:?] */,
				145	/* ModelDeclCS-1: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V0:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V3:*])[V2:?] ('}')[1])[V1:?] */,
				146	/* ModelDeclCS-2: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V2:*])[V1:?] ('}')[1])[V0:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V3:?] */,
				147	/* ModelDeclCS-3: NamedElementCS::name=UnrestrictedName ':' ModelDeclCS::metamodelIds+=UnrestrictedName ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V2:*])[V1:?] ('}')[1])[V0:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V5:*])[V4:?] ('}')[1])[V3:?] */,
				148	/* ModelDeclCS-4: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V1:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V2:?] */,
				149	/* ModelDeclCS-5: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ModelDeclCS::dependsOn+=UnrestrictedName)[V1:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V4:*])[V3:?] ('}')[1])[V2:?] */,
				150	/* ModelDeclCS-6: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V3:*])[V2:?] ('}')[1])[V1:?] ('iterates' ModelDeclCS::iterates+=UnrestrictedName)[V4:?] */,
				151	/* ModelDeclCS-7: NamedElementCS::name=UnrestrictedName ':' ('{')[1] ModelDeclCS::metamodelIds+=UnrestrictedName (',' ModelDeclCS::metamodelIds+=UnrestrictedName)[V0:*] ('}')[1] ('dependsOn' ('{')[1] (ModelDeclCS::dependsOn+=UnrestrictedName (',' ModelDeclCS::dependsOn+=UnrestrictedName)[V3:*])[V2:?] ('}')[1])[V1:?] ('iterates' ('{')[1] (ModelDeclCS::iterates+=UnrestrictedName (',' ModelDeclCS::iterates+=UnrestrictedName)[V6:*])[V5:?] ('}')[1])[V4:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* ":" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* metamodelIds+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(12 << 16) | 0	/* "{" : [soft-space, value, no-space] | [value] */,
			(0 << 16) | 14	/* metamodelIds+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* metamodelIds+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(1 << 16) | 0	/* "}" : [no-space, value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "dependsOn" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* dependsOn+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(12 << 16) | 0	/* "{" : [soft-space, value, no-space] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* dependsOn+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* dependsOn+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(1 << 16) | 0	/* "}" : [no-space, value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "iterates" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(12 << 16) | 0	/* "{" : [soft-space, value, no-space] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(1 << 16) | 0	/* "}" : [no-space, value] | [value] */
		);
		grammarRuleValues[54] = createParserRuleValue(54, "MultiplicityBoundsCS", -1,
			createSerializationRules(
				1	/* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* lowerBound=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 14	/* upperBound=UPPER : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[55] = createParserRuleValue(55, "MultiplicityCS", -1,
			createSerializationRules(
				2	/* MultiplicityCS-0: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] '|?' ']' */,
				3	/* MultiplicityCS-1: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] MultiplicityCS::isNullFree?='|1' ']' */,
				4	/* MultiplicityCS-2: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] ']' */,
				5	/* MultiplicityCS-3: '[' MultiplicityStringCS::stringBounds='*|+|?' '|?' ']' */,
				6	/* MultiplicityCS-4: '[' MultiplicityStringCS::stringBounds='*|+|?' MultiplicityCS::isNullFree?='|1' ']' */,
				7	/* MultiplicityCS-5: '[' MultiplicityStringCS::stringBounds='*|+|?' ']' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityBoundsCS : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityStringCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 6	/* "|?" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 6	/* isNullFree?="|1" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[56] = createParserRuleValue(56, "MultiplicityStringCS", -1,
			createSerializationRules(
				8	/* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			),
			(0 << 16) | 14	/* stringBounds=("*"|"+"|"?") : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[57] = createDataTypeRuleValue(57, "NUMBER_LITERAL", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[58] = createParserRuleValue(58, "NameExpCS", -1,
			createSerializationRules(
				36	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedSquareBracketedClauses+=SquareBracketedClauseCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* isPre?="@" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "pre" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[59] = createParserRuleValue(59, "NavigatingArgCS", -1,
			createSerializationRules(
				37	/* NavigatingArgCS-0: ':' NavigatingArgCS::ownedType=TypeExpCS */,
				38	/* NavigatingArgCS-1: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				39	/* NavigatingArgCS-2: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				40	/* NavigatingArgCS-3: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				41	/* NavigatingArgCS-4: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 14	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[60] = createParserRuleValue(60, "NavigatingArgExpCS", 78 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				19	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				26	/* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */,
				27	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				28	/* InvalidLiteralExpCS-0: 'invalid' */,
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				30	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				32	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				36	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				49	/* NullLiteralExpCS-0: 'null' */,
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				52	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				53	/* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */,
				56	/* SelfExpCS-0: 'self' */,
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				62	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* ExpCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[61] = createParserRuleValue(61, "NavigatingBarArgCS", -1,
			createSerializationRules(
				42	/* NavigatingBarArgCS-0: NavigatingArgCS::prefix='|' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* prefix="|" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[62] = createParserRuleValue(62, "NavigatingCommaArgCS", -1,
			createSerializationRules(
				43	/* NavigatingCommaArgCS-0: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				44	/* NavigatingCommaArgCS-1: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				45	/* NavigatingCommaArgCS-2: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				46	/* NavigatingCommaArgCS-3: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 8	/* prefix="," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 14	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[63] = createParserRuleValue(63, "NavigatingSemiArgCS", -1,
			createSerializationRules(
				47	/* NavigatingSemiArgCS-0: NavigatingArgCS::prefix=';' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* prefix=";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[64] = createDataTypeRuleValue(64, "NavigationOperatorName", 14 /* [soft-space, value, soft-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[65] = createParserRuleValue(65, "NestedExpCS", -1,
			createSerializationRules(
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 4	/* "(" : [value] | [value, no-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[66] = createParserRuleValue(66, "NextPathElementCS", -1,
			createSerializationRules(
				9	/* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */
			),
			(0 << 16) | 14	/* referredElement=UnreservedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[67] = createParserRuleValue(67, "NullLiteralExpCS", -1,
			createSerializationRules(
				49	/* NullLiteralExpCS-0: 'null' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {NullLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 14	/* "null" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[68] = createParserRuleValue(68, "NumberLiteralExpCS", -1,
			createSerializationRules(
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			),
			(0 << 16) | 2	/* symbol=NUMBER_LITERAL : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[69] = createParserRuleValue(69, "ObjectTemplateCS", -1,
			createSerializationRules(
				152	/* ObjectTemplateCS-0: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=TypedRefCS ('{' (ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS (',' ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS)[V3:*])[V2:?] '}')[V1:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 23	/* "{" : [value] | [soft-space, value, push, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 11	/* ownedPropertyTemplates+=PropertyTemplateCS : [value] | [soft-new-line, value, half-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 7	/* "," : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 11	/* ownedPropertyTemplates+=PropertyTemplateCS : [value] | [soft-new-line, value, half-new-line] */,
			(0 << 16) | 25	/* "}" : [value] | [half-new-line, no-space, pop, value, soft-space] */
		);
		grammarRuleValues[70] = createParserRuleValue(70, "OperationCS", -1,
			createSerializationRules(
				105	/* OperationCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				106	/* OperationCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */,
				107	/* OperationCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				108	/* OperationCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */,
				109	/* OperationCS-4: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] ';' */,
				110	/* OperationCS-5: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "operation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "throws" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 14	/* "body" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedBodyExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[71] = createParserRuleValue(71, "ParamDeclarationCS", -1,
			createSerializationRules(
				153	/* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[72] = createParserRuleValue(72, "ParameterCS", -1,
			createSerializationRules(
				111	/* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[73] = createParserRuleValue(73, "PathNameCS", -1,
			createSerializationRules(
				10	/* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[74] = createParserRuleValue(74, "PatternExpCS", -1,
			createSerializationRules(
				51	/* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* patternVariableName=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatternType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[75] = createParserRuleValue(75, "PredicateCS", -1,
			createSerializationRules(
				154	/* PredicateCS-0: PredicateCS::ownedCondition=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[76] = createParserRuleValue(76, "PrefixedLetExpCS", 31 /* LetExpCS|PrefixedLetExpCS */,
			createSerializationRules(
				30	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				52	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PrefixExpCS} : [value] | [value] */,
			(0 << 16) | 14	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedLetExpCS : [value] | [value] */,
			(0 << 16) | 0	/* LetExpCS : [value] | [value] */
		);
		grammarRuleValues[77] = createParserRuleValue(77, "PrefixedPrimaryExpCS", 75 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				19	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				27	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				28	/* InvalidLiteralExpCS-0: 'invalid' */,
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				32	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				36	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				49	/* NullLiteralExpCS-0: 'null' */,
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				53	/* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */,
				56	/* SelfExpCS-0: 'self' */,
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				62	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PrefixExpCS} : [value] | [value] */,
			(0 << 16) | 14	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedPrimaryExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrimaryExpCS : [value] | [value] */
		);
		grammarRuleValues[78] = createParserRuleValue(78, "PrimaryExpCS", 74 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				19	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				27	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				28	/* InvalidLiteralExpCS-0: 'invalid' */,
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				32	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				36	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				49	/* NullLiteralExpCS-0: 'null' */,
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				56	/* SelfExpCS-0: 'self' */,
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				62	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* NestedExpCS : [value] | [value] */,
			(0 << 16) | 0	/* IfExpCS : [value] | [value] */,
			(0 << 16) | 0	/* SelfExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrimitiveLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* TupleLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* MapLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* CollectionLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* LambdaLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* TypeLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* NameExpCS : [value] | [value] */
		);
		grammarRuleValues[79] = createParserRuleValue(79, "PrimitiveLiteralExpCS", 73 /* BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				28	/* InvalidLiteralExpCS-0: 'invalid' */,
				49	/* NullLiteralExpCS-0: 'null' */,
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* NumberLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* StringLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* BooleanLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* UnlimitedNaturalLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* InvalidLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* NullLiteralExpCS : [value] | [value] */
		);
		grammarRuleValues[80] = createParserRuleValue(80, "PrimitiveTypeCS", -1,
			createSerializationRules(
				54	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */
			),
			(0 << 16) | 14	/* name=PrimitiveTypeIdentifier : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[81] = createParserRuleValue(81, "PrimitiveTypeDomainCS", -1,
			createSerializationRules(
				155	/* PrimitiveTypeDomainCS-0: 'primitive' 'domain' PrimitiveTypeDomainCS::ownedPatterns+=PrimitiveTypeDomainPatternCS (',' PrimitiveTypeDomainCS::ownedPatterns+=PrimitiveTypeDomainPatternCS)[V0:*] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "primitive" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "domain" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatterns+=PrimitiveTypeDomainPatternCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatterns+=PrimitiveTypeDomainPatternCS : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[82] = createParserRuleValue(82, "PrimitiveTypeDomainPatternCS", -1,
			createSerializationRules(
				156	/* PrimitiveTypeDomainPatternCS-0: NamedElementCS::name=UnrestrictedName ':' TemplateVariableCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[83] = createDataTypeRuleValue(83, "PrimitiveTypeIdentifier", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[84] = createParserRuleValue(84, "PropertyTemplateCS", -1,
			createSerializationRules(
				157	/* PropertyTemplateCS-0: PropertyTemplateCS::propertyId=UnrestrictedName '=' PropertyTemplateCS::ownedExpression=ExpCSOrTemplateCS */,
				158	/* PropertyTemplateCS-1: 'opposite' '(' PropertyTemplateCS::ownedOppositePropertyId=PathNameCS ')' '=' PropertyTemplateCS::ownedExpression=ExpCSOrTemplateCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* propertyId=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "opposite" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedOppositePropertyId=PathNameCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCSOrTemplateCS : [value] | [value] */
		);
		grammarRuleValues[85] = createDataTypeRuleValue(85, "QVTbaseUnrestrictedName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[86] = createDataTypeRuleValue(86, "QVTrelationUnrestrictedName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[87] = createParserRuleValue(87, "QualifiedPackageCS", -1,
			createSerializationRules(
				159	/* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				160	/* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "package" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS? : [value] | [value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* nsPrefix=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* nsURI=URI : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 5	/* ownedPackages+=QualifiedPackageCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 5	/* ownedClasses+=(ClassCS|TransformationCS) : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[88] = createParserRuleValue(88, "QueryCS", -1,
			createSerializationRules(
				161	/* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				162	/* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				163	/* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* isTransient?="transient"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "query" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParameters+=ParamDeclarationCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=ParamDeclarationCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 20	/* "{" : [value] | [soft-new-line, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 18	/* "}" : [value] | [soft-new-line, pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "implementedby" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* implementation=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[89] = createParserRuleValue(89, "ReferenceCS", -1,
			createSerializationRules(
				112	/* ReferenceCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				113	/* ReferenceCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				114	/* ReferenceCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				115	/* ReferenceCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				116	/* ReferenceCS-4: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				117	/* ReferenceCS-5: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "property" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "#" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 14	/* referredOpposite=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* qualifiers+="composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[90] = createParserRuleValue(90, "RelationCS", -1,
			createSerializationRules(
				164	/* RelationCS-0: (RelationCS::isTop?='top')[V0:?] (RelationCS::isAbstract?='abstract')[V1:?] 'relation' NamedElementCS::name=UnrestrictedName ('overrides' RelationCS::overridden=UnrestrictedName)[V2:?] '{' (RelationCS::ownedVarDeclarations+=VarDeclarationCS)[V3:*] (RelationCS::ownedDomains+=DomainCS|PrimitiveTypeDomainCS)[V4:+] (RelationCS::ownedWhen=WhenCS)[V5:?] (RelationCS::ownedWhere=WhereCS)[V6:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* isTop?="top"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* isAbstract?="abstract"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "relation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "overrides" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* overridden=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 20	/* "{" : [value] | [soft-new-line, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedVarDeclarations+=VarDeclarationCS* : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives+ : [value] | [value] */,
			(0 << 16) | 0	/* ownedDomains+=DomainCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedDomains+=PrimitiveTypeDomainCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedWhen=WhenCS? : [value] | [value] */,
			(0 << 16) | 0	/* ownedWhere=WhereCS? : [value] | [value] */,
			(0 << 16) | 9	/* "}" : [value] | [pop, value, soft-new-line] */
		);
		grammarRuleValues[91] = createParserRuleValue(91, "RoundBracketedClauseCS", -1,
			createSerializationRules(
				55	/* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {RoundBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=NavigatingArgCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)* : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[92] = createDataTypeRuleValue(92, "SIGNED", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[93] = new TerminalRuleValue(93, "SIMPLE_ID");
		grammarRuleValues[94] = new TerminalRuleValue(94, "SINGLE_QUOTED_STRING");
		grammarRuleValues[95] = new TerminalRuleValue(95, "SL_COMMENT");
		grammarRuleValues[96] = createParserRuleValue(96, "ScopeNameCS", -1,
			createSerializationRules(
				165	/* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 6	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */,
			(0 << 16) | 6	/* "::" : [value] | [no-space, value, no-space] */
		);
		grammarRuleValues[97] = createParserRuleValue(97, "SelfExpCS", -1,
			createSerializationRules(
				56	/* SelfExpCS-0: 'self' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {SelfExpCS} : [value] | [value] */,
			(0 << 16) | 14	/* "self" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[98] = createParserRuleValue(98, "ShadowPartCS", -1,
			createSerializationRules(
				57	/* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */,
				58	/* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* referredProperty=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 0	/* ownedInitExpression=StringLiteralExpCS : [value] | [value] */
		);
		grammarRuleValues[99] = createParserRuleValue(99, "SimplePathNameCS", -1,
			createSerializationRules(
				59	/* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */
			),
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */
		);
		grammarRuleValues[100] = createParserRuleValue(100, "SimpleTargetElementCS", -1,
			createSerializationRules(
				118	/* SimpleTargetElementCS-0: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				119	/* SimpleTargetElementCS-1: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				120	/* SimpleTargetElementCS-2: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				121	/* SimpleTargetElementCS-3: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				122	/* SimpleTargetElementCS-4: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				123	/* SimpleTargetElementCS-5: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* input?="input" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* output?="output" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* via?="via" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* typedModel=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "iterates" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[101] = createParserRuleValue(101, "SpecificationCS", -1,
			createSerializationRules(
				124	/* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				125	/* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 14	/* exprString=UNQUOTED_STRING : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[102] = createParserRuleValue(102, "SquareBracketedClauseCS", -1,
			createSerializationRules(
				60	/* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[103] = createDataTypeRuleValue(103, "StringLiteral", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[104] = createParserRuleValue(104, "StringLiteralExpCS", -1,
			createSerializationRules(
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			),
			(0 << 16) | 2	/* segments+=StringLiteral+ : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[105] = createParserRuleValue(105, "StructuralFeatureCS", 48 /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
			createSerializationRules(
				82	/* AttributeCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				83	/* AttributeCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				84	/* AttributeCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				85	/* AttributeCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				86	/* AttributeCS-4: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] ';' */,
				87	/* AttributeCS-5: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V5:?] ';')[V4:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] '}' */,
				112	/* ReferenceCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				113	/* ReferenceCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				114	/* ReferenceCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				115	/* ReferenceCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				116	/* ReferenceCS-4: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				117	/* ReferenceCS-5: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* AttributeCS : [value] | [value] */,
			(0 << 16) | 0	/* ReferenceCS : [value] | [value] */
		);
		grammarRuleValues[106] = createParserRuleValue(106, "StructuredClassCS", -1,
			createSerializationRules(
				126	/* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				127	/* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* isAbstract?="abstract"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "class" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 14	/* isInterface?="interface"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedOperations+=OperationCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedProperties+=StructuralFeatureCS : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[107] = createParserRuleValue(107, "TargetCS", -1,
			createSerializationRules(
				128	/* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "target" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)* : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 7	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[108] = createParserRuleValue(108, "TemplateBindingCS", -1,
			createSerializationRules(
				11	/* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedSubstitutions+=TemplateParameterSubstitutionCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSubstitutions+=TemplateParameterSubstitutionCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[109] = createParserRuleValue(109, "TemplateCS", -1,
			createSerializationRules(
				166	/* TemplateCS-0: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=CollectionTypeCS ('{' (CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS (',' CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS)[V3:*] '++' CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS)[V2:?] '}')[V1:?] ('{' TemplateCS::ownedGuardExpression=ExpCS '}')[V4:?] */,
				167	/* TemplateCS-1: (NamedElementCS::name=UnrestrictedName)[V0:?] ':' TemplateVariableCS::ownedType=TypedRefCS ('{' (ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS (',' ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS)[V3:*])[V2:?] '}')[V1:?] ('{' TemplateCS::ownedGuardExpression=ExpCS '}')[V4:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* CollectionTemplateCS : [value] | [value] */,
			(0 << 16) | 0	/* ObjectTemplateCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedGuardExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 19	/* "}" : [value] | [soft-new-line, pop, value, soft-space] */
		);
		grammarRuleValues[110] = createParserRuleValue(110, "TemplateParameterSubstitutionCS", -1,
			createSerializationRules(
				12	/* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			(0 << 16) | 2	/* ownedActualParameter=TypeRefCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[111] = createParserRuleValue(111, "TemplateSignatureCS", -1,
			createSerializationRules(
				13	/* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[112] = createParserRuleValue(112, "TopLevelCS", -1,
			createSerializationRules(
				168	/* TopLevelCS-0: (RootCS::ownedImports+=UnitCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(3 << 16) | 0	/* ownedImports+=UnitCS* : [value, half-new-line] | [value] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 5	/* ownedPackages+=QualifiedPackageCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 5	/* ownedTransformations+=TransformationCS : [value] | [half-new-line, value, half-new-line] */
		);
		grammarRuleValues[113] = createParserRuleValue(113, "TransformationCS", -1,
			createSerializationRules(
				169	/* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' TransformationCS::ownedModelDecls+=ModelDeclCS (',' TransformationCS::ownedModelDecls+=ModelDeclCS)[V1:*] ')' ('extends' TransformationCS::extends+=UnrestrictedName (',' TransformationCS::extends+=UnrestrictedName)[V3:*])[V2:?] '{' (AbstractTransformationCS::ownedTargets+=TargetCS)[V4:*] (TransformationCS::ownedKeyDecls+=KeyDeclCS)[V5:*] (TransformationCS::ownedRelations+=RelationCS)[V6:*] (TransformationCS::ownedQueries+=QueryCS)[V7:*] (TransformationCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "transformation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS? : [value] | [value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedModelDecls+=ModelDeclCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedModelDecls+=ModelDeclCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* extends+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* extends+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 20	/* "{" : [value] | [soft-new-line, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargets+=TargetCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedKeyDecls+=KeyDeclCS* : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 5	/* ownedRelations+=RelationCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 5	/* ownedQueries+=QueryCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 0	/* ownedProperties+=StructuralFeatureCS : [value] | [value] */,
			(0 << 16) | 9	/* "}" : [value] | [pop, value, soft-new-line] */
		);
		grammarRuleValues[114] = createParserRuleValue(114, "TupleLiteralExpCS", -1,
			createSerializationRules(
				62	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 7	/* "," : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[115] = createParserRuleValue(115, "TupleLiteralPartCS", -1,
			createSerializationRules(
				63	/* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[116] = createParserRuleValue(116, "TuplePartCS", -1,
			createSerializationRules(
				64	/* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[117] = createParserRuleValue(117, "TupleTypeCS", -1,
			createSerializationRules(
				65	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 14	/* name="Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[118] = createParserRuleValue(118, "TypeExpCS", -1,
			createSerializationRules(
				66	/* TypeExpCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				67	/* TypeExpCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				68	/* TypeExpCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				69	/* TypeExpCS-3: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				70	/* TypeExpCS-4: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				71	/* TypeExpCS-5: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypeExpWithoutMultiplicityCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[119] = createParserRuleValue(119, "TypeExpWithoutMultiplicityCS", 64 /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
			createSerializationRules(
				22	/* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */,
				23	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				34	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				54	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				65	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				77	/* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* TypeNameExpCS : [value] | [value] */,
			(0 << 16) | 0	/* TypeLiteralCS : [value] | [value] */,
			(0 << 16) | 0	/* CollectionPatternCS : [value] | [value] */
		);
		grammarRuleValues[120] = createParserRuleValue(120, "TypeLiteralCS", 62 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS */,
			createSerializationRules(
				23	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				34	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				54	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				65	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* PrimitiveTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* MapTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* TupleTypeCS : [value] | [value] */
		);
		grammarRuleValues[121] = createParserRuleValue(121, "TypeLiteralExpCS", -1,
			createSerializationRules(
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			(0 << 16) | 2	/* ownedType=TypeLiteralWithMultiplicityCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[122] = createParserRuleValue(122, "TypeLiteralWithMultiplicityCS", -1,
			createSerializationRules(
				73	/* TypeLiteralWithMultiplicityCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				74	/* TypeLiteralWithMultiplicityCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				75	/* TypeLiteralWithMultiplicityCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				76	/* TypeLiteralWithMultiplicityCS-3: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypeLiteralCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[123] = createParserRuleValue(123, "TypeNameExpCS", -1,
			createSerializationRules(
				77	/* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedPatternGuard=ExpCS : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[124] = createParserRuleValue(124, "TypeParameterCS", -1,
			createSerializationRules(
				14	/* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 14	/* "&&" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */
		);
		grammarRuleValues[125] = createParserRuleValue(125, "TypeRefCS", 85 /* TypeRefCS|TypedRefCS|WildcardTypeRefCS */,
			createSerializationRules(
				170	/* TypedRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				171	/* TypedRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				172	/* TypedRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				16	/* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* WildcardTypeRefCS : [value] | [value] */
		);
		grammarRuleValues[126] = createParserRuleValue(126, "TypedMultiplicityRefCS", -1,
			createSerializationRules(
				129	/* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				130	/* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				131	/* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[127] = createParserRuleValue(127, "TypedRefCS", -1,
			createSerializationRules(
				170	/* TypedRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				171	/* TypedRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				172	/* TypedRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* PrimitiveTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypedTypeRefCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[128] = createParserRuleValue(128, "TypedTypeRefCS", -1,
			createSerializationRules(
				173	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS */
			),
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */
		);
		grammarRuleValues[129] = new TerminalRuleValue(129, "UNQUOTED_STRING");
		grammarRuleValues[130] = createDataTypeRuleValue(130, "UPPER", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[131] = createDataTypeRuleValue(131, "URI", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[132] = createParserRuleValue(132, "URIFirstPathElementCS", -1,
			createSerializationRules(
				78	/* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */,
				79	/* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 14	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PathElementWithURICS} : [value] | [value] */,
			(0 << 16) | 14	/* referredElement=URI : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[133] = createParserRuleValue(133, "URIPathNameCS", -1,
			createSerializationRules(
				80	/* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=URIFirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[134] = createDataTypeRuleValue(134, "UnaryOperatorName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[135] = createParserRuleValue(135, "UnitCS", -1,
			createSerializationRules(
				174	/* UnitCS-0: 'import' (NamedElementCS::name=UnrestrictedName ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS ('::' ImportCS::isAll?='*')[V1:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 14	/* "import" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=URIPathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 14	/* isAll?="*" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[136] = createParserRuleValue(136, "UnlimitedNaturalLiteralExpCS", -1,
			createSerializationRules(
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {UnlimitedNaturalLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 14	/* "*" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[137] = createDataTypeRuleValue(137, "UnreservedName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[138] = createParserRuleValue(138, "UnreservedPathNameCS", -1,
			createSerializationRules(
				15	/* UnreservedPathNameCS-0: PathNameCS::ownedPathElements+=NextPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[139] = createDataTypeRuleValue(139, "UnrestrictedName", 14 /* [soft-space, value, soft-space] */);
		grammarRuleValues[140] = createParserRuleValue(140, "VarDeclarationCS", -1,
			createSerializationRules(
				175	/* VarDeclarationCS-0: VarDeclarationCS::ownedVarDeclarationIds+=VarDeclarationIdCS (',' VarDeclarationCS::ownedVarDeclarationIds+=VarDeclarationIdCS)[V0:*] (':' VarDeclarationCS::ownedType=TypeExpCS)[V1:?] ('=' VarDeclarationCS::ownedInitExpression=ExpCS)[V2:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedVarDeclarationIds+=VarDeclarationIdCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedVarDeclarationIds+=VarDeclarationIdCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[141] = createParserRuleValue(141, "VarDeclarationIdCS", -1,
			createSerializationRules(
				176	/* VarDeclarationIdCS-0: NamedElementCS::name=UnrestrictedName */
			),
			(0 << 16) | 2	/* name=UnrestrictedName : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[142] = new TerminalRuleValue(142, "WS");
		grammarRuleValues[143] = createParserRuleValue(143, "WhenCS", -1,
			createSerializationRules(
				177	/* WhenCS-0: 'when' '{' (PatternCS::ownedPredicates+=PredicateCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {PatternCS} : [value] | [value] */,
			(0 << 16) | 14	/* "when" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedPredicates+=PredicateCS* : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[144] = createParserRuleValue(144, "WhereCS", -1,
			createSerializationRules(
				178	/* WhereCS-0: 'where' '{' (PatternCS::ownedPredicates+=PredicateCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {PatternCS} : [value] | [value] */,
			(0 << 16) | 14	/* "where" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 24	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedPredicates+=PredicateCS* : [value] | [value] */,
			(0 << 16) | 16	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[145] = createParserRuleValue(145, "WildcardTypeRefCS", -1,
			createSerializationRules(
				16	/* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {WildcardTypeRefCS} : [value] | [value] */,
			(0 << 16) | 14	/* "?" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 14	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends=TypedRefCS : [value] | [value] */
		);
	}

	/**
	 * Initialize bit vectors of useful grammar rule combinations.
	 */
	private void initGrammarRuleVectors() {
		// 0: CoIteratorVariableCS
		grammarRuleVectors[0] = new GrammarRuleVector(0x20L);
		// 1: CollectionLiteralPartCS
		grammarRuleVectors[1] = new GrammarRuleVector(0x80L);
		// 2: CollectionTypeCS
		grammarRuleVectors[2] = new GrammarRuleVector(0x400L);
		// 3: CurlyBracketedClauseCS
		grammarRuleVectors[3] = new GrammarRuleVector(0x2000L);
		// 4: DefaultValueCS
		grammarRuleVectors[4] = new GrammarRuleVector(0x10000L);
		// 5: DomainPatternCS
		grammarRuleVectors[5] = new GrammarRuleVector(0x40000L);
		// 6: ElementTemplateCS
		grammarRuleVectors[6] = new GrammarRuleVector(0x200000L);
		// 7: ElseIfThenExpCS
		grammarRuleVectors[7] = new GrammarRuleVector(0x400000L);
		// 8: EnumerationLiteralCS
		grammarRuleVectors[8] = new GrammarRuleVector(0x1000000L);
		// 9: ExpCS
		grammarRuleVectors[9] = new GrammarRuleVector(0x100000000L);
		// 10: ExpCSOrTemplateCS
		grammarRuleVectors[10] = new GrammarRuleVector(0x200000000L);
		// 11: FirstPathElementCS
		grammarRuleVectors[11] = new GrammarRuleVector(0x400000000L);
		// 12: KeyDeclCS
		grammarRuleVectors[12] = new GrammarRuleVector(0x20000000000L);
		// 13: LetVariableCS
		grammarRuleVectors[13] = new GrammarRuleVector(0x400000000000L);
		// 14: MapLiteralPartCS
		grammarRuleVectors[14] = new GrammarRuleVector(0x4000000000000L);
		// 15: MapTypeCS
		grammarRuleVectors[15] = new GrammarRuleVector(0x8000000000000L);
		// 16: ModelDeclCS
		grammarRuleVectors[16] = new GrammarRuleVector(0x20000000000000L);
		// 17: MultiplicityCS
		grammarRuleVectors[17] = new GrammarRuleVector(0x80000000000000L);
		// 18: NavigatingArgExpCS
		grammarRuleVectors[18] = new GrammarRuleVector(0x1000000000000000L);
		// 19: NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[19] = new GrammarRuleVector(0xe000000000000000L);
		// 20: NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[20] = new GrammarRuleVector(0xe800000000000000L);
		// 21: NextPathElementCS
		grammarRuleVectors[21] = new GrammarRuleVector(0x0L,0x4L);
		// 22: FirstPathElementCS|NextPathElementCS
		grammarRuleVectors[22] = new GrammarRuleVector(0x400000000L,0x4L);
		// 23: OperationCS
		grammarRuleVectors[23] = new GrammarRuleVector(0x0L,0x40L);
		// 24: ParamDeclarationCS
		grammarRuleVectors[24] = new GrammarRuleVector(0x0L,0x80L);
		// 25: ParameterCS
		grammarRuleVectors[25] = new GrammarRuleVector(0x0L,0x100L);
		// 26: PathNameCS
		grammarRuleVectors[26] = new GrammarRuleVector(0x0L,0x200L);
		// 27: PatternExpCS
		grammarRuleVectors[27] = new GrammarRuleVector(0x0L,0x400L);
		// 28: ExpCS|PatternExpCS
		grammarRuleVectors[28] = new GrammarRuleVector(0x100000000L,0x400L);
		// 29: PredicateCS
		grammarRuleVectors[29] = new GrammarRuleVector(0x0L,0x800L);
		// 30: PrefixedLetExpCS
		grammarRuleVectors[30] = new GrammarRuleVector(0x0L,0x1000L);
		// 31: LetExpCS|PrefixedLetExpCS
		grammarRuleVectors[31] = new GrammarRuleVector(0x200000000000L,0x1000L);
		// 32: PrefixedPrimaryExpCS
		grammarRuleVectors[32] = new GrammarRuleVector(0x0L,0x2000L);
		// 33: DomainCS|PrimitiveTypeDomainCS
		grammarRuleVectors[33] = new GrammarRuleVector(0x20000L,0x20000L);
		// 34: PrimitiveTypeDomainPatternCS
		grammarRuleVectors[34] = new GrammarRuleVector(0x0L,0x40000L);
		// 35: PropertyTemplateCS
		grammarRuleVectors[35] = new GrammarRuleVector(0x0L,0x100000L);
		// 36: QualifiedPackageCS
		grammarRuleVectors[36] = new GrammarRuleVector(0x0L,0x800000L);
		// 37: QueryCS
		grammarRuleVectors[37] = new GrammarRuleVector(0x0L,0x1000000L);
		// 38: RelationCS
		grammarRuleVectors[38] = new GrammarRuleVector(0x0L,0x4000000L);
		// 39: RoundBracketedClauseCS
		grammarRuleVectors[39] = new GrammarRuleVector(0x0L,0x8000000L);
		// 40: ScopeNameCS
		grammarRuleVectors[40] = new GrammarRuleVector(0x0L,0x100000000L);
		// 41: ShadowPartCS
		grammarRuleVectors[41] = new GrammarRuleVector(0x0L,0x400000000L);
		// 42: SimpleTargetElementCS
		grammarRuleVectors[42] = new GrammarRuleVector(0x0L,0x1000000000L);
		// 43: CompoundTargetElementCS|SimpleTargetElementCS
		grammarRuleVectors[43] = new GrammarRuleVector(0x1000L,0x1000000000L);
		// 44: SpecificationCS
		grammarRuleVectors[44] = new GrammarRuleVector(0x0L,0x2000000000L);
		// 45: SquareBracketedClauseCS
		grammarRuleVectors[45] = new GrammarRuleVector(0x0L,0x4000000000L);
		// 46: StringLiteralExpCS
		grammarRuleVectors[46] = new GrammarRuleVector(0x0L,0x10000000000L);
		// 47: StructuralFeatureCS
		grammarRuleVectors[47] = new GrammarRuleVector(0x0L,0x20000000000L);
		// 48: AttributeCS|ReferenceCS|StructuralFeatureCS
		grammarRuleVectors[48] = new GrammarRuleVector(0x2L,0x20002000000L);
		// 49: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS
		grammarRuleVectors[49] = new GrammarRuleVector(0x808010L,0x40000000000L);
		// 50: TargetCS
		grammarRuleVectors[50] = new GrammarRuleVector(0x0L,0x80000000000L);
		// 51: TemplateCS
		grammarRuleVectors[51] = new GrammarRuleVector(0x0L,0x200000000000L);
		// 52: ElementTemplateCS|TemplateCS
		grammarRuleVectors[52] = new GrammarRuleVector(0x200000L,0x200000000000L);
		// 53: TemplateParameterSubstitutionCS
		grammarRuleVectors[53] = new GrammarRuleVector(0x0L,0x400000000000L);
		// 54: TemplateSignatureCS
		grammarRuleVectors[54] = new GrammarRuleVector(0x0L,0x800000000000L);
		// 55: TransformationCS
		grammarRuleVectors[55] = new GrammarRuleVector(0x0L,0x2000000000000L);
		// 56: ClassCS|TransformationCS
		grammarRuleVectors[56] = new GrammarRuleVector(0x10L,0x2000000000000L);
		// 57: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS
		grammarRuleVectors[57] = new GrammarRuleVector(0x808010L,0x2040000000000L);
		// 58: TupleLiteralPartCS
		grammarRuleVectors[58] = new GrammarRuleVector(0x0L,0x8000000000000L);
		// 59: TuplePartCS
		grammarRuleVectors[59] = new GrammarRuleVector(0x0L,0x10000000000000L);
		// 60: TypeExpCS
		grammarRuleVectors[60] = new GrammarRuleVector(0x0L,0x40000000000000L);
		// 61: TypeExpWithoutMultiplicityCS
		grammarRuleVectors[61] = new GrammarRuleVector(0x0L,0x80000000000000L);
		// 62: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS
		grammarRuleVectors[62] = new GrammarRuleVector(0x8000000000400L,0x120000000010000L);
		// 63: TypeLiteralWithMultiplicityCS
		grammarRuleVectors[63] = new GrammarRuleVector(0x0L,0x400000000000000L);
		// 64: CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS
		grammarRuleVectors[64] = new GrammarRuleVector(0x8000000000500L,0x9a0000000010000L);
		// 65: TypeParameterCS
		grammarRuleVectors[65] = new GrammarRuleVector(0x0L,0x1000000000000000L);
		// 66: TypeRefCS
		grammarRuleVectors[66] = new GrammarRuleVector(0x0L,0x2000000000000000L);
		// 67: TypedMultiplicityRefCS
		grammarRuleVectors[67] = new GrammarRuleVector(0x0L,0x4000000000000000L);
		// 68: TypedRefCS
		grammarRuleVectors[68] = new GrammarRuleVector(0x0L,0x8000000000000000L);
		// 69: NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[69] = new GrammarRuleVector(0x0L,0x4L,0x10L);
		// 70: FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[70] = new GrammarRuleVector(0x400000000L,0x4L,0x10L);
		// 71: URIPathNameCS
		grammarRuleVectors[71] = new GrammarRuleVector(0x0L,0x0L,0x20L);
		// 72: UnitCS
		grammarRuleVectors[72] = new GrammarRuleVector(0x0L,0x0L,0x80L);
		// 73: BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[73] = new GrammarRuleVector(0x10000000008L,0x10000008018L,0x100L);
		// 74: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[74] = new GrammarRuleVector(0x402114000000048L,0x20401020000c01aL,0x100L);
		// 75: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[75] = new GrammarRuleVector(0x402114000000048L,0x20401020000e01aL,0x100L);
		// 76: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[76] = new GrammarRuleVector(0x402314000000048L,0x20401020000f01aL,0x100L);
		// 77: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[77] = new GrammarRuleVector(0x402314100000048L,0x20401020000f01aL,0x100L);
		// 78: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[78] = new GrammarRuleVector(0x1402314100000048L,0x20401020000f01aL,0x100L);
		// 79: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[79] = new GrammarRuleVector(0x402314100000048L,0x20401020000f41aL,0x100L);
		// 80: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|ExpCSOrTemplateCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TemplateCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[80] = new GrammarRuleVector(0x402314300000048L,0x20421020000f01aL,0x100L);
		// 81: VarDeclarationCS
		grammarRuleVectors[81] = new GrammarRuleVector(0x0L,0x0L,0x1000L);
		// 82: VarDeclarationIdCS
		grammarRuleVectors[82] = new GrammarRuleVector(0x0L,0x0L,0x2000L);
		// 83: WhenCS
		grammarRuleVectors[83] = new GrammarRuleVector(0x0L,0x0L,0x8000L);
		// 84: WhereCS
		grammarRuleVectors[84] = new GrammarRuleVector(0x0L,0x0L,0x10000L);
		// 85: TypeRefCS|TypedRefCS|WildcardTypeRefCS
		grammarRuleVectors[85] = new GrammarRuleVector(0x0L,0xa000000000000000L,0x20000L);
	}

	/**
	 * Initialize steps for the matching process.
	 */
	private void initMatchSteps() {
		// 0: assert (|AbstractNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[0] = createMatchStep_Assert(202);
		// 1: assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0
		serializationMatchSteps[1] = createMatchStep_Assert(203);
		// 2: assert (|CollectionLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[2] = createMatchStep_Assert(206);
		// 3: assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0
		serializationMatchSteps[3] = createMatchStep_Assert(207);
		// 4: assert (|CollectionPatternCS::ownedType| - 1) == 0
		serializationMatchSteps[4] = createMatchStep_Assert(209);
		// 5: assert (|CollectionTypeCS::name| - 1) == 0
		serializationMatchSteps[5] = createMatchStep_Assert(212);
		// 6: assert (|ContextCS::ownedExpression| - 1) == 0
		serializationMatchSteps[6] = createMatchStep_Assert(213);
		// 7: assert (|DefaultValueCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[7] = createMatchStep_Assert(216);
		// 8: assert (|DefaultValueCS::propertyId| - 1) == 0
		serializationMatchSteps[8] = createMatchStep_Assert(217);
		// 9: assert (|DomainCS::isCheckonly.'checkonly'| - 1) == 0
		serializationMatchSteps[9] = createMatchStep_Assert(218);
		// 10: assert (|DomainCS::isEnforce.'enforce'| - 1) == 0
		serializationMatchSteps[10] = createMatchStep_Assert(219);
		// 11: assert (|DomainCS::modelId| - 1) == 0
		serializationMatchSteps[11] = createMatchStep_Assert(220);
		// 12: assert (|DomainPatternCS::ownedTemplate| - 1) == 0
		serializationMatchSteps[12] = createMatchStep_Assert(224);
		// 13: assert (|ElementTemplateCS::identifier| - 1) == 0
		serializationMatchSteps[13] = createMatchStep_Assert(225);
		// 14: assert (|ExpSpecificationCS::ownedExpression| - 1) == 0
		serializationMatchSteps[14] = createMatchStep_Assert(226);
		// 15: assert (|IfExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[15] = createMatchStep_Assert(227);
		// 16: assert (|IfExpCS::ownedElseExpression| - 1) == 0
		serializationMatchSteps[16] = createMatchStep_Assert(228);
		// 17: assert (|IfExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[17] = createMatchStep_Assert(229);
		// 18: assert (|IfThenExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[18] = createMatchStep_Assert(230);
		// 19: assert (|IfThenExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[19] = createMatchStep_Assert(231);
		// 20: assert (|ImportCS::ownedPathName| - 1) == 0
		serializationMatchSteps[20] = createMatchStep_Assert(232);
		// 21: assert (|InfixExpCS::ownedLeft| - 1) == 0
		serializationMatchSteps[21] = createMatchStep_Assert(233);
		// 22: assert (|JavaImplementationCS::implementation| - 1) == 0
		serializationMatchSteps[22] = createMatchStep_Assert(234);
		// 23: assert (|KeyDeclCS::ownedOppositePropertyIds| - 1) == 0
		serializationMatchSteps[23] = createMatchStep_Assert(235);
		// 24: assert (|KeyDeclCS::ownedPathName| - 1) == 0
		serializationMatchSteps[24] = createMatchStep_Assert(236);
		// 25: assert (|KeyDeclCS::propertyIds| - 1) == 0
		serializationMatchSteps[25] = createMatchStep_Assert(237);
		// 26: assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0
		serializationMatchSteps[26] = createMatchStep_Assert(238);
		// 27: assert (|LetExpCS::ownedInExpression| - 1) == 0
		serializationMatchSteps[27] = createMatchStep_Assert(239);
		// 28: assert (|MapLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[28] = createMatchStep_Assert(243);
		// 29: assert (|MapLiteralPartCS::ownedKey| - 1) == 0
		serializationMatchSteps[29] = createMatchStep_Assert(244);
		// 30: assert (|MapLiteralPartCS::ownedValue| - 1) == 0
		serializationMatchSteps[30] = createMatchStep_Assert(245);
		// 31: assert (|MapTypeCS::name.'Map'| - 1) == 0
		serializationMatchSteps[31] = createMatchStep_Assert(246);
		// 32: assert (|MapTypeCS::ownedKeyType| - V0) == 0
		serializationMatchSteps[32] = createMatchStep_Assert(247);
		// 33: assert (|ModelDeclCS::metamodelIds| - 1) == 0
		serializationMatchSteps[33] = createMatchStep_Assert(252);
		// 34: assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0
		serializationMatchSteps[34] = createMatchStep_Assert(253);
		// 35: assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0
		serializationMatchSteps[35] = createMatchStep_Assert(254);
		// 36: assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0
		serializationMatchSteps[36] = createMatchStep_Assert(255);
		// 37: assert (|NamedElementCS::name| - 1) == 0
		serializationMatchSteps[37] = createMatchStep_Assert(256);
		// 38: assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0
		serializationMatchSteps[38] = createMatchStep_Assert(257);
		// 39: assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[39] = createMatchStep_Assert(258);
		// 40: assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0
		serializationMatchSteps[40] = createMatchStep_Assert(259);
		// 41: assert (|NavigatingArgCS::ownedType| - 1) == 0
		serializationMatchSteps[41] = createMatchStep_Assert(260);
		// 42: assert (|NavigatingArgCS::prefix.','| - 1) == 0
		serializationMatchSteps[42] = createMatchStep_Assert(261);
		// 43: assert (|NavigatingArgCS::prefix.';'| - 1) == 0
		serializationMatchSteps[43] = createMatchStep_Assert(262);
		// 44: assert (|NavigatingArgCS::prefix.'|'| - 1) == 0
		serializationMatchSteps[44] = createMatchStep_Assert(263);
		// 45: assert (|NestedExpCS::ownedExpression| - 1) == 0
		serializationMatchSteps[45] = createMatchStep_Assert(264);
		// 46: assert (|NumberLiteralExpCS::symbol| - 1) == 0
		serializationMatchSteps[46] = createMatchStep_Assert(265);
		// 47: assert (|OperatorExpCS::ownedRight| - 1) == 0
		serializationMatchSteps[47] = createMatchStep_Assert(273);
		// 48: assert (|PathElementCS::referredElement| - 1) == 0
		serializationMatchSteps[48] = createMatchStep_Assert(274);
		// 49: assert (|PathNameCS::ownedPathElements| - 1) == 0
		serializationMatchSteps[49] = createMatchStep_Assert(275);
		// 50: assert (|PatternExpCS::ownedPatternType| - 1) == 0
		serializationMatchSteps[50] = createMatchStep_Assert(276);
		// 51: assert (|PredicateCS::ownedCondition| - 1) == 0
		serializationMatchSteps[51] = createMatchStep_Assert(277);
		// 52: assert (|PrimitiveTypeRefCS::name| - 1) == 0
		serializationMatchSteps[52] = createMatchStep_Assert(279);
		// 53: assert (|PropertyTemplateCS::ownedExpression| - 1) == 0
		serializationMatchSteps[53] = createMatchStep_Assert(280);
		// 54: assert (|PropertyTemplateCS::ownedOppositePropertyId| - 1) == 0
		serializationMatchSteps[54] = createMatchStep_Assert(281);
		// 55: assert (|PropertyTemplateCS::propertyId| - 1) == 0
		serializationMatchSteps[55] = createMatchStep_Assert(282);
		// 56: assert (|QueryCS::ownedExpression| - 1) == 0
		serializationMatchSteps[56] = createMatchStep_Assert(283);
		// 57: assert (|ShadowPartCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[57] = createMatchStep_Assert(286);
		// 58: assert (|ShadowPartCS::referredProperty| - 1) == 0
		serializationMatchSteps[58] = createMatchStep_Assert(287);
		// 59: assert (|SimpleTargetElementCS::input.'input'| - 1) == 0
		serializationMatchSteps[59] = createMatchStep_Assert(288);
		// 60: assert (|SimpleTargetElementCS::output.'output'| - 1) == 0
		serializationMatchSteps[60] = createMatchStep_Assert(291);
		// 61: assert (|SimpleTargetElementCS::typedModel| - 1) == 0
		serializationMatchSteps[61] = createMatchStep_Assert(292);
		// 62: assert (|SimpleTargetElementCS::via.'via'| - 1) == 0
		serializationMatchSteps[62] = createMatchStep_Assert(293);
		// 63: assert (|SpecificationCS::exprString| - 1) == 0
		serializationMatchSteps[63] = createMatchStep_Assert(294);
		// 64: assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0
		serializationMatchSteps[64] = createMatchStep_Assert(301);
		// 65: assert (|TemplateVariableCS::ownedType| - 1) == 0
		serializationMatchSteps[65] = createMatchStep_Assert(303);
		// 66: assert (|TupleTypeCS::name.'Tuple'| - 1) == 0
		serializationMatchSteps[66] = createMatchStep_Assert(308);
		// 67: assert (|TypeLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[67] = createMatchStep_Assert(311);
		// 68: assert (|TypeNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[68] = createMatchStep_Assert(312);
		// 69: assert (|TypedElementCS::ownedType| - 1) == 0
		serializationMatchSteps[69] = createMatchStep_Assert(315);
		// 70: assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0
		serializationMatchSteps[70] = createMatchStep_Assert(320);
		// 71: assert (|TypedElementCS::qualifiers.'static'| - 1) == 0
		serializationMatchSteps[71] = createMatchStep_Assert(321);
		// 72: assert (|TypedTypeRefCS::ownedPathName| - 1) == 0
		serializationMatchSteps[72] = createMatchStep_Assert(322);
		// 73: assert (|VariableCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[73] = createMatchStep_Assert(324);
		// 74: assert |ClassCS::instanceClassName| == 0
		serializationMatchSteps[74] = createMatchStep_Assert(11);
		// 75: assert |ClassCS::ownedConstraints| == 0
		serializationMatchSteps[75] = createMatchStep_Assert(12);
		// 76: assert |CollectionLiteralPartCS::ownedLastExpression| == 0
		serializationMatchSteps[76] = createMatchStep_Assert(16);
		// 77: assert |CollectionPatternCS::ownedPatternGuard| == 0
		serializationMatchSteps[77] = createMatchStep_Assert(18);
		// 78: assert |CurlyBracketedClauseCS::value| == 0
		serializationMatchSteps[78] = createMatchStep_Assert(29);
		// 79: assert |DataTypeCS::isSerializable| == 0
		serializationMatchSteps[79] = createMatchStep_Assert(32);
		// 80: assert |DomainCS::isCheckonly| == 0
		serializationMatchSteps[80] = createMatchStep_Assert(37);
		// 81: assert |DomainCS::isEnforce| == 0
		serializationMatchSteps[81] = createMatchStep_Assert(39);
		// 82: assert |DomainCS::isReplace| == 0
		serializationMatchSteps[82] = createMatchStep_Assert(40);
		// 83: assert |DomainCS::ownedImplementedBy| == 0
		serializationMatchSteps[83] = createMatchStep_Assert(43);
		// 84: assert |EnumerationCS::isSerializable| == 0
		serializationMatchSteps[84] = createMatchStep_Assert(48);
		// 85: assert |EnumerationCS::ownedLiterals| == 0
		serializationMatchSteps[85] = createMatchStep_Assert(49);
		// 86: assert |EnumerationLiteralCS::literal| == 0
		serializationMatchSteps[86] = createMatchStep_Assert(50);
		// 87: assert |ExpSpecificationCS::ownedExpression| == 0
		serializationMatchSteps[87] = createMatchStep_Assert(52);
		// 88: assert |IfExpCS::isImplicit| == 0
		serializationMatchSteps[88] = createMatchStep_Assert(53);
		// 89: assert |JavaImplementationCS::implementation| == 0
		serializationMatchSteps[89] = createMatchStep_Assert(63);
		// 90: assert |KeyDeclCS::ownedOppositePropertyIds| == 0
		serializationMatchSteps[90] = createMatchStep_Assert(64);
		// 91: assert |KeyDeclCS::propertyIds| == 0
		serializationMatchSteps[91] = createMatchStep_Assert(66);
		// 92: assert |LetExpCS::isImplicit| == 0
		serializationMatchSteps[92] = createMatchStep_Assert(68);
		// 93: assert |ModelElementCS::ownedAnnotations| == 0
		serializationMatchSteps[93] = createMatchStep_Assert(82);
		// 94: assert |MultiplicityCS::isNullFree| == 0
		serializationMatchSteps[94] = createMatchStep_Assert(86);
		// 95: assert |NamedElementCS::name| == 0
		serializationMatchSteps[95] = createMatchStep_Assert(88);
		// 96: assert |NavigatingArgCS::ownedCoIterator| == 0
		serializationMatchSteps[96] = createMatchStep_Assert(89);
		// 97: assert |NavigatingArgCS::ownedInitExpression| == 0
		serializationMatchSteps[97] = createMatchStep_Assert(90);
		// 98: assert |NavigatingArgCS::ownedNameExpression| == 0
		serializationMatchSteps[98] = createMatchStep_Assert(91);
		// 99: assert |NavigatingArgCS::ownedType| == 0
		serializationMatchSteps[99] = createMatchStep_Assert(92);
		// 100: assert |NavigatingArgCS::prefix| == 0
		serializationMatchSteps[100] = createMatchStep_Assert(96);
		// 101: assert |OperationCS::ownedBodyExpressions| == 0
		serializationMatchSteps[101] = createMatchStep_Assert(100);
		// 102: assert |OperationCS::ownedPostconditions| == 0
		serializationMatchSteps[102] = createMatchStep_Assert(103);
		// 103: assert |OperationCS::ownedPreconditions| == 0
		serializationMatchSteps[103] = createMatchStep_Assert(104);
		// 104: assert |PackageCS::ownedClasses| == 0
		serializationMatchSteps[104] = createMatchStep_Assert(108);
		// 105: assert |PackageOwnerCS::ownedPackages| == 0
		serializationMatchSteps[105] = createMatchStep_Assert(109);
		// 106: assert |PropertyTemplateCS::ownedOppositePropertyId| == 0
		serializationMatchSteps[106] = createMatchStep_Assert(119);
		// 107: assert |PropertyTemplateCS::propertyId| == 0
		serializationMatchSteps[107] = createMatchStep_Assert(120);
		// 108: assert |QueryCS::ownedExpression| == 0
		serializationMatchSteps[108] = createMatchStep_Assert(123);
		// 109: assert |ReferenceCS::ownedImplicitOpposites| == 0
		serializationMatchSteps[109] = createMatchStep_Assert(125);
		// 110: assert |ReferenceCS::referredKeys| == 0
		serializationMatchSteps[110] = createMatchStep_Assert(126);
		// 111: assert |RootCS::ownedImports| == 0
		serializationMatchSteps[111] = createMatchStep_Assert(135);
		// 112: assert |SelfExpCS::name| == 0
		serializationMatchSteps[112] = createMatchStep_Assert(136);
		// 113: assert |ShadowPartCS::referredProperty| == 0
		serializationMatchSteps[113] = createMatchStep_Assert(138);
		// 114: assert |SimpleTargetElementCS::input| == 0
		serializationMatchSteps[114] = createMatchStep_Assert(140);
		// 115: assert |SimpleTargetElementCS::output| == 0
		serializationMatchSteps[115] = createMatchStep_Assert(143);
		// 116: assert |SimpleTargetElementCS::via| == 0
		serializationMatchSteps[116] = createMatchStep_Assert(146);
		// 117: assert |SpecificationCS::exprString| == 0
		serializationMatchSteps[117] = createMatchStep_Assert(147);
		// 118: assert |StructuralFeatureCS::ownedDefaultExpressions| == 0
		serializationMatchSteps[118] = createMatchStep_Assert(151);
		// 119: assert |StructuredClassCS::ownedMetaclass| == 0
		serializationMatchSteps[119] = createMatchStep_Assert(154);
		// 120: assert |StructuredClassCS::ownedOperations| == 0
		serializationMatchSteps[120] = createMatchStep_Assert(155);
		// 121: assert |StructuredClassCS::ownedProperties| == 0
		serializationMatchSteps[121] = createMatchStep_Assert(156);
		// 122: assert |TemplateCS::ownedGuardExpression| == 0
		serializationMatchSteps[122] = createMatchStep_Assert(161);
		// 123: assert |TemplateVariableCS::ownedType| == 0
		serializationMatchSteps[123] = createMatchStep_Assert(164);
		// 124: assert |TemplateableElementCS::ownedSignature| == 0
		serializationMatchSteps[124] = createMatchStep_Assert(165);
		// 125: assert |TypeLiteralExpCS::ownedPathName| == 0
		serializationMatchSteps[125] = createMatchStep_Assert(176);
		// 126: assert |TypedElementCS::isOptional| == 0
		serializationMatchSteps[126] = createMatchStep_Assert(182);
		// 127: assert |TypedElementCS::qualifiers| == 0
		serializationMatchSteps[127] = createMatchStep_Assert(190);
		// 128: assert |TypedRefCS::ownedMultiplicity| == 0
		serializationMatchSteps[128] = createMatchStep_Assert(191);
		// 129: assert |TypedTypeRefCS::isTypeof| == 0
		serializationMatchSteps[129] = createMatchStep_Assert(192);
		// 130: assert |TypedTypeRefCS::ownedBinding| == 0
		serializationMatchSteps[130] = createMatchStep_Assert(193);
		// 131: assert |VariableCS::ownedInitExpression| == 0
		serializationMatchSteps[131] = createMatchStep_Assert(198);
		// 132: assert |WildcardTypeRefCS::ownedSuper| == 0
		serializationMatchSteps[132] = createMatchStep_Assert(201);
		// 133: assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[133] = createMatchStep_Assign(0, 205);
		// 134: assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchSteps[134] = createMatchStep_Assign(0, 215);
		// 135: assign V0 = (|DomainCS::ownedPatterns| > 0)
		serializationMatchSteps[135] = createMatchStep_Assign(0, 223);
		// 136: assign V0 = (|KeyDeclCS::ownedOppositePropertyIds| - 1)
		serializationMatchSteps[136] = createMatchStep_Assign(0, 235);
		// 137: assign V0 = (|KeyDeclCS::propertyIds| - 1)
		serializationMatchSteps[137] = createMatchStep_Assign(0, 237);
		// 138: assign V0 = (|LetExpCS::ownedVariables| - 1)
		serializationMatchSteps[138] = createMatchStep_Assign(0, 240);
		// 139: assign V0 = (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[139] = createMatchStep_Assign(0, 242);
		// 140: assign V0 = (|ModelDeclCS::dependsOn| > 0)
		serializationMatchSteps[140] = createMatchStep_Assign(0, 249);
		// 141: assign V0 = (|ModelDeclCS::metamodelIds| - 1)
		serializationMatchSteps[141] = createMatchStep_Assign(0, 252);
		// 142: assign V0 = (|PathNameCS::ownedPathElements| - 1)
		serializationMatchSteps[142] = createMatchStep_Assign(0, 275);
		// 143: assign V0 = (|PrimitiveTypeDomainCS::ownedPatterns| - 1)
		serializationMatchSteps[143] = createMatchStep_Assign(0, 278);
		// 144: assign V0 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[144] = createMatchStep_Assign(0, 290);
		// 145: assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchSteps[145] = createMatchStep_Assign(0, 295);
		// 146: assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchSteps[146] = createMatchStep_Assign(0, 300);
		// 147: assign V0 = (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchSteps[147] = createMatchStep_Assign(0, 302);
		// 148: assign V0 = (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[148] = createMatchStep_Assign(0, 307);
		// 149: assign V0 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[149] = createMatchStep_Assign(0, 310);
		// 150: assign V0 = (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchSteps[150] = createMatchStep_Assign(0, 314);
		// 151: assign V0 = (|VarDeclarationCS::ownedVarDeclarationIds| - 1)
		serializationMatchSteps[151] = createMatchStep_Assign(0, 323);
		// 152: assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchSteps[152] = createMatchStep_Assign(0, 7);
		// 153: assign V0 = |AbstractTransformationCS::ownedPathName|
		serializationMatchSteps[153] = createMatchStep_Assign(0, 8);
		// 154: assign V0 = |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchSteps[154] = createMatchStep_Assign(0, 16);
		// 155: assign V0 = |CollectionPatternCS::restVariableName|
		serializationMatchSteps[155] = createMatchStep_Assign(0, 20);
		// 156: assign V0 = |CollectionTypeCS::ownedType|
		serializationMatchSteps[156] = createMatchStep_Assign(0, 25);
		// 157: assign V0 = |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchSteps[157] = createMatchStep_Assign(0, 26);
		// 158: assign V0 = |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchSteps[158] = createMatchStep_Assign(0, 30);
		// 159: assign V0 = |EnumerationLiteralCS::value|
		serializationMatchSteps[159] = createMatchStep_Assign(0, 51);
		// 160: assign V0 = |IfExpCS::ownedIfThenExpressions|
		serializationMatchSteps[160] = createMatchStep_Assign(0, 56);
		// 161: assign V0 = |KeyDeclCS::ownedOppositePropertyIds|
		serializationMatchSteps[161] = createMatchStep_Assign(0, 64);
		// 162: assign V0 = |KeyDeclCS::propertyIds|
		serializationMatchSteps[162] = createMatchStep_Assign(0, 66);
		// 163: assign V0 = |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchSteps[163] = createMatchStep_Assign(0, 71);
		// 164: assign V0 = |MapTypeCS::ownedValueType|
		serializationMatchSteps[164] = createMatchStep_Assign(0, 78);
		// 165: assign V0 = |ModelDeclCS::dependsOn|
		serializationMatchSteps[165] = createMatchStep_Assign(0, 79);
		// 166: assign V0 = |MultiplicityBoundsCS::upperBound|
		serializationMatchSteps[166] = createMatchStep_Assign(0, 84);
		// 167: assign V0 = |NamedElementCS::name|
		serializationMatchSteps[167] = createMatchStep_Assign(0, 88);
		// 168: assign V0 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[168] = createMatchStep_Assign(0, 89);
		// 169: assign V0 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[169] = createMatchStep_Assign(0, 90);
		// 170: assign V0 = |NavigatingArgCS::ownedType|
		serializationMatchSteps[170] = createMatchStep_Assign(0, 92);
		// 171: assign V0 = |PatternCS::ownedPredicates|
		serializationMatchSteps[171] = createMatchStep_Assign(0, 112);
		// 172: assign V0 = |PatternExpCS::patternVariableName|
		serializationMatchSteps[172] = createMatchStep_Assign(0, 114);
		// 173: assign V0 = |QualifiedPackageCS::ownedPathName|
		serializationMatchSteps[173] = createMatchStep_Assign(0, 121);
		// 174: assign V0 = |QueryCS::isTransient.'transient'|
		serializationMatchSteps[174] = createMatchStep_Assign(0, 122);
		// 175: assign V0 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[175] = createMatchStep_Assign(0, 127);
		// 176: assign V0 = |RelationCS::isTop.'top'|
		serializationMatchSteps[176] = createMatchStep_Assign(0, 129);
		// 177: assign V0 = |RootCS::ownedImports|
		serializationMatchSteps[177] = createMatchStep_Assign(0, 135);
		// 178: assign V0 = |SimpleTargetElementCS::iterates|
		serializationMatchSteps[178] = createMatchStep_Assign(0, 141);
		// 179: assign V0 = |StringLiteralExpCS::segments|
		serializationMatchSteps[179] = createMatchStep_Assign(0, 149);
		// 180: assign V0 = |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchSteps[180] = createMatchStep_Assign(0, 152);
		// 181: assign V0 = |TargetCS::ownedTargetElements|
		serializationMatchSteps[181] = createMatchStep_Assign(0, 158);
		// 182: assign V0 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[182] = createMatchStep_Assign(0, 165);
		// 183: assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[183] = createMatchStep_Assign(0, 178);
		// 184: assign V0 = |TypedElementCS::ownedType|
		serializationMatchSteps[184] = createMatchStep_Assign(0, 183);
		// 185: assign V0 = |TypedElementCS::qualifiers.'definition'|
		serializationMatchSteps[185] = createMatchStep_Assign(0, 188);
		// 186: assign V0 = |TypedElementCS::qualifiers.'static'|
		serializationMatchSteps[186] = createMatchStep_Assign(0, 189);
		// 187: assign V0 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[187] = createMatchStep_Assign(0, 191);
		// 188: assign V0 = |VariableCS::ownedType|
		serializationMatchSteps[188] = createMatchStep_Assign(0, 199);
		// 189: assign V0 = |WildcardTypeRefCS::ownedExtends|
		serializationMatchSteps[189] = createMatchStep_Assign(0, 200);
		// 190: assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[190] = createMatchStep_Assign(1, 204);
		// 191: assign V1 = (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchSteps[191] = createMatchStep_Assign(1, 208);
		// 192: assign V1 = (|CollectionTemplateCS::ownedRestIdentifier| > 0)
		serializationMatchSteps[192] = createMatchStep_Assign(1, 211);
		// 193: assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchSteps[193] = createMatchStep_Assign(1, 214);
		// 194: assign V1 = (|DomainCS::ownedPatterns| - 1)
		serializationMatchSteps[194] = createMatchStep_Assign(1, 222);
		// 195: assign V1 = (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[195] = createMatchStep_Assign(1, 241);
		// 196: assign V1 = (|ModelDeclCS::dependsOn| > 0)
		serializationMatchSteps[196] = createMatchStep_Assign(1, 249);
		// 197: assign V1 = (|ModelDeclCS::iterates| > 0)
		serializationMatchSteps[197] = createMatchStep_Assign(1, 251);
		// 198: assign V1 = (|ObjectTemplateCS::ownedPropertyTemplates| > 0)
		serializationMatchSteps[198] = createMatchStep_Assign(1, 267);
		// 199: assign V1 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[199] = createMatchStep_Assign(1, 272);
		// 200: assign V1 = (|QueryCS::ownedParameters| > 0)
		serializationMatchSteps[200] = createMatchStep_Assign(1, 285);
		// 201: assign V1 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[201] = createMatchStep_Assign(1, 290);
		// 202: assign V1 = (|TransformationCS::ownedModelDecls| - 1)
		serializationMatchSteps[202] = createMatchStep_Assign(1, 306);
		// 203: assign V1 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[203] = createMatchStep_Assign(1, 310);
		// 204: assign V1 = (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchSteps[204] = createMatchStep_Assign(1, 313);
		// 205: assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchSteps[205] = createMatchStep_Assign(1, 319);
		// 206: assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchSteps[206] = createMatchStep_Assign(1, 6);
		// 207: assign V1 = |ClassCS::instanceClassName|
		serializationMatchSteps[207] = createMatchStep_Assign(1, 11);
		// 208: assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchSteps[208] = createMatchStep_Assign(1, 24);
		// 209: assign V1 = |ImportCS::isAll.'*'|
		serializationMatchSteps[209] = createMatchStep_Assign(1, 60);
		// 210: assign V1 = |ModelDeclCS::dependsOn|
		serializationMatchSteps[210] = createMatchStep_Assign(1, 79);
		// 211: assign V1 = |ModelDeclCS::iterates|
		serializationMatchSteps[211] = createMatchStep_Assign(1, 80);
		// 212: assign V1 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[212] = createMatchStep_Assign(1, 89);
		// 213: assign V1 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[213] = createMatchStep_Assign(1, 90);
		// 214: assign V1 = |PackageCS::nsPrefix|
		serializationMatchSteps[214] = createMatchStep_Assign(1, 106);
		// 215: assign V1 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[215] = createMatchStep_Assign(1, 109);
		// 216: assign V1 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[216] = createMatchStep_Assign(1, 127);
		// 217: assign V1 = |RelationCS::isAbstract.'abstract'|
		serializationMatchSteps[217] = createMatchStep_Assign(1, 128);
		// 218: assign V1 = |StructuralFeatureCS::default|
		serializationMatchSteps[218] = createMatchStep_Assign(1, 150);
		// 219: assign V1 = |TemplateBindingCS::ownedMultiplicity|
		serializationMatchSteps[219] = createMatchStep_Assign(1, 159);
		// 220: assign V1 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[220] = createMatchStep_Assign(1, 165);
		// 221: assign V1 = |TypeNameExpCS::ownedPatternGuard|
		serializationMatchSteps[221] = createMatchStep_Assign(1, 180);
		// 222: assign V1 = |TypedElementCS::ownedType|
		serializationMatchSteps[222] = createMatchStep_Assign(1, 183);
		// 223: assign V1 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[223] = createMatchStep_Assign(1, 191);
		// 224: assign V1 = |VarDeclarationCS::ownedType|
		serializationMatchSteps[224] = createMatchStep_Assign(1, 196);
		// 225: assign V1 = |VariableCS::ownedType|
		serializationMatchSteps[225] = createMatchStep_Assign(1, 199);
		// 226: assign V10 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[226] = createMatchStep_Assign(10, 100);
		// 227: assign V2 = (|ModelDeclCS::dependsOn| - 1)
		serializationMatchSteps[227] = createMatchStep_Assign(2, 248);
		// 228: assign V2 = (|ModelDeclCS::dependsOn| > 0)
		serializationMatchSteps[228] = createMatchStep_Assign(2, 249);
		// 229: assign V2 = (|ModelDeclCS::iterates| > 0)
		serializationMatchSteps[229] = createMatchStep_Assign(2, 251);
		// 230: assign V2 = (|ObjectTemplateCS::ownedPropertyTemplates| > 0)
		serializationMatchSteps[230] = createMatchStep_Assign(2, 267);
		// 231: assign V2 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[231] = createMatchStep_Assign(2, 271);
		// 232: assign V2 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[232] = createMatchStep_Assign(2, 272);
		// 233: assign V2 = (|QueryCS::ownedParameters| - 1)
		serializationMatchSteps[233] = createMatchStep_Assign(2, 284);
		// 234: assign V2 = (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchSteps[234] = createMatchStep_Assign(2, 289);
		// 235: assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchSteps[235] = createMatchStep_Assign(2, 299);
		// 236: assign V2 = (|TransformationCS::extends| > 0)
		serializationMatchSteps[236] = createMatchStep_Assign(2, 305);
		// 237: assign V2 = (|TupleTypeCS::ownedParts| - 1)
		serializationMatchSteps[237] = createMatchStep_Assign(2, 309);
		// 238: assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[238] = createMatchStep_Assign(2, 317);
		// 239: assign V2 = 0
		serializationMatchSteps[239] = createMatchStep_Assign(2, 0);
		// 240: assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[240] = createMatchStep_Assign(2, 4);
		// 241: assign V2 = |ClassCS::instanceClassName|
		serializationMatchSteps[241] = createMatchStep_Assign(2, 11);
		// 242: assign V2 = |CollectionTemplateCS::ownedRestIdentifier|
		serializationMatchSteps[242] = createMatchStep_Assign(2, 22);
		// 243: assign V2 = |DomainCS::implementedBy|
		serializationMatchSteps[243] = createMatchStep_Assign(2, 35);
		// 244: assign V2 = |EnumerationCS::isSerializable.'serializable'|
		serializationMatchSteps[244] = createMatchStep_Assign(2, 47);
		// 245: assign V2 = |ModelDeclCS::iterates|
		serializationMatchSteps[245] = createMatchStep_Assign(2, 80);
		// 246: assign V2 = |PackageCS::nsURI|
		serializationMatchSteps[246] = createMatchStep_Assign(2, 107);
		// 247: assign V2 = |RelationCS::overridden|
		serializationMatchSteps[247] = createMatchStep_Assign(2, 130);
		// 248: assign V2 = |StructuralFeatureCS::default|
		serializationMatchSteps[248] = createMatchStep_Assign(2, 150);
		// 249: assign V2 = |TopLevelCS::ownedTransformations|
		serializationMatchSteps[249] = createMatchStep_Assign(2, 166);
		// 250: assign V2 = |TypedElementCS::ownedType|
		serializationMatchSteps[250] = createMatchStep_Assign(2, 183);
		// 251: assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchSteps[251] = createMatchStep_Assign(2, 187);
		// 252: assign V2 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[252] = createMatchStep_Assign(2, 191);
		// 253: assign V2 = |VarDeclarationCS::ownedInitExpression|
		serializationMatchSteps[253] = createMatchStep_Assign(2, 195);
		// 254: assign V3 = (|CollectionTemplateCS::ownedMemberIdentifiers| - 1)
		serializationMatchSteps[254] = createMatchStep_Assign(3, 210);
		// 255: assign V3 = (|DomainCS::ownedDefaultValues| > 0)
		serializationMatchSteps[255] = createMatchStep_Assign(3, 221);
		// 256: assign V3 = (|ModelDeclCS::dependsOn| - 1)
		serializationMatchSteps[256] = createMatchStep_Assign(3, 248);
		// 257: assign V3 = (|ModelDeclCS::iterates| - 1)
		serializationMatchSteps[257] = createMatchStep_Assign(3, 250);
		// 258: assign V3 = (|ModelDeclCS::iterates| > 0)
		serializationMatchSteps[258] = createMatchStep_Assign(3, 251);
		// 259: assign V3 = (|ObjectTemplateCS::ownedPropertyTemplates| - 1)
		serializationMatchSteps[259] = createMatchStep_Assign(3, 266);
		// 260: assign V3 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[260] = createMatchStep_Assign(3, 271);
		// 261: assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchSteps[261] = createMatchStep_Assign(3, 298);
		// 262: assign V3 = (|TransformationCS::extends| - 1)
		serializationMatchSteps[262] = createMatchStep_Assign(3, 304);
		// 263: assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[263] = createMatchStep_Assign(3, 316);
		// 264: assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[264] = createMatchStep_Assign(3, 317);
		// 265: assign V3 = 0
		serializationMatchSteps[265] = createMatchStep_Assign(3, 0);
		// 266: assign V3 = |AbstractNameExpCS::isPre.'@'|
		serializationMatchSteps[266] = createMatchStep_Assign(3, 3);
		// 267: assign V3 = |DataTypeCS::isSerializable.'serializable'|
		serializationMatchSteps[267] = createMatchStep_Assign(3, 31);
		// 268: assign V3 = |EnumerationCS::ownedLiterals|
		serializationMatchSteps[268] = createMatchStep_Assign(3, 49);
		// 269: assign V3 = |ModelDeclCS::iterates|
		serializationMatchSteps[269] = createMatchStep_Assign(3, 80);
		// 270: assign V3 = |PackageCS::ownedClasses|
		serializationMatchSteps[270] = createMatchStep_Assign(3, 108);
		// 271: assign V3 = |RelationCS::ownedVarDeclarations|
		serializationMatchSteps[271] = createMatchStep_Assign(3, 132);
		// 272: assign V3 = |StructuralFeatureCS::default|
		serializationMatchSteps[272] = createMatchStep_Assign(3, 150);
		// 273: assign V3 = |TypedElementCS::ownedType|
		serializationMatchSteps[273] = createMatchStep_Assign(3, 183);
		// 274: assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[274] = createMatchStep_Assign(3, 185);
		// 275: assign V3 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[275] = createMatchStep_Assign(3, 191);
		// 276: assign V4 = (|ModelDeclCS::iterates| - 1)
		serializationMatchSteps[276] = createMatchStep_Assign(4, 250);
		// 277: assign V4 = (|ModelDeclCS::iterates| > 0)
		serializationMatchSteps[277] = createMatchStep_Assign(4, 251);
		// 278: assign V4 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[278] = createMatchStep_Assign(4, 270);
		// 279: assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[279] = createMatchStep_Assign(4, 316);
		// 280: assign V4 = |AbstractTransformationCS::ownedTargets|
		serializationMatchSteps[280] = createMatchStep_Assign(4, 9);
		// 281: assign V4 = |ClassCS::instanceClassName|
		serializationMatchSteps[281] = createMatchStep_Assign(4, 11);
		// 282: assign V4 = |DomainCS::ownedDefaultValues|
		serializationMatchSteps[282] = createMatchStep_Assign(4, 42);
		// 283: assign V4 = |ModelDeclCS::iterates|
		serializationMatchSteps[283] = createMatchStep_Assign(4, 80);
		// 284: assign V4 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[284] = createMatchStep_Assign(4, 109);
		// 285: assign V4 = |RelationCS::ownedDomains|
		serializationMatchSteps[285] = createMatchStep_Assign(4, 131);
		// 286: assign V4 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[286] = createMatchStep_Assign(4, 151);
		// 287: assign V4 = |TemplateCS::ownedGuardExpression|
		serializationMatchSteps[287] = createMatchStep_Assign(4, 161);
		// 288: assign V4 = |TypedElementCS::ownedType|
		serializationMatchSteps[288] = createMatchStep_Assign(4, 183);
		// 289: assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[289] = createMatchStep_Assign(4, 184);
		// 290: assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[290] = createMatchStep_Assign(4, 185);
		// 291: assign V5 = (|ModelDeclCS::iterates| - 1)
		serializationMatchSteps[291] = createMatchStep_Assign(5, 250);
		// 292: assign V5 = (|ModelDeclCS::iterates| > 0)
		serializationMatchSteps[292] = createMatchStep_Assign(5, 251);
		// 293: assign V5 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[293] = createMatchStep_Assign(5, 269);
		// 294: assign V5 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[294] = createMatchStep_Assign(5, 270);
		// 295: assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[295] = createMatchStep_Assign(5, 296);
		// 296: assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchSteps[296] = createMatchStep_Assign(5, 297);
		// 297: assign V5 = |RelationCS::ownedWhen|
		serializationMatchSteps[297] = createMatchStep_Assign(5, 133);
		// 298: assign V5 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[298] = createMatchStep_Assign(5, 151);
		// 299: assign V5 = |TransformationCS::ownedKeyDecls|
		serializationMatchSteps[299] = createMatchStep_Assign(5, 168);
		// 300: assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[300] = createMatchStep_Assign(5, 184);
		// 301: assign V6 = (|ModelDeclCS::iterates| - 1)
		serializationMatchSteps[301] = createMatchStep_Assign(6, 250);
		// 302: assign V6 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[302] = createMatchStep_Assign(6, 269);
		// 303: assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[303] = createMatchStep_Assign(6, 296);
		// 304: assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[304] = createMatchStep_Assign(6, 318);
		// 305: assign V6 = 0
		serializationMatchSteps[305] = createMatchStep_Assign(6, 0);
		// 306: assign V6 = |RelationCS::ownedWhere|
		serializationMatchSteps[306] = createMatchStep_Assign(6, 134);
		// 307: assign V6 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[307] = createMatchStep_Assign(6, 151);
		// 308: assign V6 = |StructuredClassCS::isInterface.'interface'|
		serializationMatchSteps[308] = createMatchStep_Assign(6, 153);
		// 309: assign V6 = |TransformationCS::ownedRelations|
		serializationMatchSteps[309] = createMatchStep_Assign(6, 172);
		// 310: assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[310] = createMatchStep_Assign(7, 296);
		// 311: assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[311] = createMatchStep_Assign(7, 318);
		// 312: assign V7 = 0
		serializationMatchSteps[312] = createMatchStep_Assign(7, 0);
		// 313: assign V7 = |StructuredClassCS::ownedOperations|
		serializationMatchSteps[313] = createMatchStep_Assign(7, 155);
		// 314: assign V7 = |TransformationCS::ownedQueries|
		serializationMatchSteps[314] = createMatchStep_Assign(7, 171);
		// 315: assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[315] = createMatchStep_Assign(7, 186);
		// 316: assign V8 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[316] = createMatchStep_Assign(8, 268);
		// 317: assign V8 = 0
		serializationMatchSteps[317] = createMatchStep_Assign(8, 0);
		// 318: assign V8 = |StructuredClassCS::ownedProperties|
		serializationMatchSteps[318] = createMatchStep_Assign(8, 156);
		// 319: assign V8 = |TransformationCS::ownedProperties|
		serializationMatchSteps[319] = createMatchStep_Assign(8, 170);
		// 320: assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[320] = createMatchStep_Assign(8, 186);
		// 321: assign V9 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[321] = createMatchStep_Assign(9, 268);
		// 322: assign V9 = 0
		serializationMatchSteps[322] = createMatchStep_Assign(9, 0);
		// 323: assign V9 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[323] = createMatchStep_Assign(9, 100);
		// 324: check-rule basecs::EnumerationCS.ownedLiterals : 24
		serializationMatchSteps[324] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 8/*EnumerationLiteralCS*/);
		// 325: check-rule basecs::ImportCS.ownedPathName : 133
		serializationMatchSteps[325] = createMatchStep_RuleCheck(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 71/*URIPathNameCS*/);
		// 326: check-rule basecs::OperationCS.ownedBodyExpressions : 101
		serializationMatchSteps[326] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/*SpecificationCS*/);
		// 327: check-rule basecs::OperationCS.ownedExceptions : 127
		serializationMatchSteps[327] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/*TypedRefCS*/);
		// 328: check-rule basecs::OperationCS.ownedParameters : 72
		serializationMatchSteps[328] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/*ParameterCS*/);
		// 329: check-rule basecs::PackageCS.ownedClasses : 4|15|23|106|113
		serializationMatchSteps[329] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 57/*ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS*/);
		// 330: check-rule basecs::PackageOwnerCS.ownedPackages : 87
		serializationMatchSteps[330] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 36/*QualifiedPackageCS*/);
		// 331: check-rule basecs::PathNameCS.ownedPathElements : 34
		serializationMatchSteps[331] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 11/*FirstPathElementCS*/);
		// 332: check-rule basecs::PathNameCS.ownedPathElements : 66
		serializationMatchSteps[332] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 21/*NextPathElementCS*/);
		// 333: check-rule basecs::RootCS.ownedImports : 135
		serializationMatchSteps[333] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 72/*UnitCS*/);
		// 334: check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : 101
		serializationMatchSteps[334] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/*SpecificationCS*/);
		// 335: check-rule basecs::StructuredClassCS.ownedOperations : 70
		serializationMatchSteps[335] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 23/*OperationCS*/);
		// 336: check-rule basecs::StructuredClassCS.ownedProperties : 1|89|105
		serializationMatchSteps[336] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 48/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 337: check-rule basecs::StructuredClassCS.ownedSuperTypes : 127
		serializationMatchSteps[337] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 68/*TypedRefCS*/);
		// 338: check-rule basecs::TemplateBindingCS.ownedMultiplicity : 55
		serializationMatchSteps[338] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 339: check-rule basecs::TemplateBindingCS.ownedSubstitutions : 110
		serializationMatchSteps[339] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 53/*TemplateParameterSubstitutionCS*/);
		// 340: check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : 125|127|145
		serializationMatchSteps[340] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 85/*TypeRefCS|TypedRefCS|WildcardTypeRefCS*/);
		// 341: check-rule basecs::TemplateSignatureCS.ownedParameters : 124
		serializationMatchSteps[341] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 65/*TypeParameterCS*/);
		// 342: check-rule basecs::TemplateableElementCS.ownedSignature : 111
		serializationMatchSteps[342] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/*TemplateSignatureCS*/);
		// 343: check-rule basecs::TupleTypeCS.ownedParts : 116
		serializationMatchSteps[343] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/*TuplePartCS*/);
		// 344: check-rule basecs::TypeParameterCS.ownedExtends : 127
		serializationMatchSteps[344] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 68/*TypedRefCS*/);
		// 345: check-rule basecs::TypedElementCS.ownedType : 118
		serializationMatchSteps[345] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 346: check-rule basecs::TypedElementCS.ownedType : 126
		serializationMatchSteps[346] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/*TypedMultiplicityRefCS*/);
		// 347: check-rule basecs::TypedRefCS.ownedMultiplicity : 55
		serializationMatchSteps[347] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 348: check-rule basecs::TypedTypeRefCS.ownedPathName : 73
		serializationMatchSteps[348] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 26/*PathNameCS*/);
		// 349: check-rule basecs::WildcardTypeRefCS.ownedExtends : 127
		serializationMatchSteps[349] = createMatchStep_RuleCheck(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 68/*TypedRefCS*/);
		// 350: check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : 13
		serializationMatchSteps[350] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/*CurlyBracketedClauseCS*/);
		// 351: check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : 73
		serializationMatchSteps[351] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 26/*PathNameCS*/);
		// 352: check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : 91
		serializationMatchSteps[352] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 39/*RoundBracketedClauseCS*/);
		// 353: check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : 102
		serializationMatchSteps[353] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 45/*SquareBracketedClauseCS*/);
		// 354: check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : 7
		serializationMatchSteps[354] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 1/*CollectionLiteralPartCS*/);
		// 355: check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : 10
		serializationMatchSteps[355] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 2/*CollectionTypeCS*/);
		// 356: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[356] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 357: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 74
		serializationMatchSteps[357] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 27/*PatternExpCS*/);
		// 358: check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[358] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 359: check-rule essentialoclcs::CollectionPatternCS.ownedParts : 74
		serializationMatchSteps[359] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 27/*PatternExpCS*/);
		// 360: check-rule essentialoclcs::CollectionPatternCS.ownedType : 10
		serializationMatchSteps[360] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/*CollectionTypeCS*/);
		// 361: check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : 55
		serializationMatchSteps[361] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 362: check-rule essentialoclcs::CollectionTypeCS.ownedType : 8|10|51|80|117|119|120|123
		serializationMatchSteps[362] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 64/*CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS*/);
		// 363: check-rule essentialoclcs::ContextCS.ownedExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[363] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 364: check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : 98
		serializationMatchSteps[364] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 41/*ShadowPartCS*/);
		// 365: check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[365] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 366: check-rule essentialoclcs::IfExpCS.ownedCondition : 3|6|32|38|40|44|45|49|58|65|67|68|74|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[366] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 79/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 367: check-rule essentialoclcs::IfExpCS.ownedElseExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[367] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 368: check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : 22
		serializationMatchSteps[368] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 7/*ElseIfThenExpCS*/);
		// 369: check-rule essentialoclcs::IfExpCS.ownedThenExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[369] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 370: check-rule essentialoclcs::IfThenExpCS.ownedCondition : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[370] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 371: check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[371] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 372: check-rule essentialoclcs::InfixExpCS.ownedLeft : 3|6|38|40|44|49|58|65|67|68|77|78|79|97|104|114|121|136
		serializationMatchSteps[372] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 373: check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[373] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 374: check-rule essentialoclcs::LetExpCS.ownedInExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[374] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 375: check-rule essentialoclcs::LetExpCS.ownedVariables : 46
		serializationMatchSteps[375] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 13/*LetVariableCS*/);
		// 376: check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : 91
		serializationMatchSteps[376] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 39/*RoundBracketedClauseCS*/);
		// 377: check-rule essentialoclcs::MapLiteralExpCS.ownedParts : 50
		serializationMatchSteps[377] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 14/*MapLiteralPartCS*/);
		// 378: check-rule essentialoclcs::MapLiteralExpCS.ownedType : 51
		serializationMatchSteps[378] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 15/*MapTypeCS*/);
		// 379: check-rule essentialoclcs::MapLiteralPartCS.ownedKey : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[379] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 380: check-rule essentialoclcs::MapLiteralPartCS.ownedValue : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[380] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 381: check-rule essentialoclcs::MapTypeCS.ownedKeyType : 118
		serializationMatchSteps[381] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/*TypeExpCS*/);
		// 382: check-rule essentialoclcs::MapTypeCS.ownedValueType : 118
		serializationMatchSteps[382] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/*TypeExpCS*/);
		// 383: check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : 5
		serializationMatchSteps[383] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/*CoIteratorVariableCS*/);
		// 384: check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[384] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 385: check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : 3|6|32|38|40|44|45|49|58|60|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[385] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 78/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 386: check-rule essentialoclcs::NavigatingArgCS.ownedType : 118
		serializationMatchSteps[386] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 387: check-rule essentialoclcs::NestedExpCS.ownedExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[387] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 388: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[388] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 389: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|6|38|40|44|49|58|65|67|68|77|78|79|97|104|114|121|136
		serializationMatchSteps[389] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 390: check-rule essentialoclcs::OperatorExpCS.ownedRight : 45|76
		serializationMatchSteps[390] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 31/*LetExpCS|PrefixedLetExpCS*/);
		// 391: check-rule essentialoclcs::PatternExpCS.ownedPatternType : 118
		serializationMatchSteps[391] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 60/*TypeExpCS*/);
		// 392: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 104
		serializationMatchSteps[392] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 46/*StringLiteralExpCS*/);
		// 393: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 3|6|32|38|40|44|45|49|58|65|67|68|74|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[393] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 79/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 394: check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[394] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 395: check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : 115
		serializationMatchSteps[395] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 58/*TupleLiteralPartCS*/);
		// 396: check-rule essentialoclcs::TypeLiteralExpCS.ownedType : 122
		serializationMatchSteps[396] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 63/*TypeLiteralWithMultiplicityCS*/);
		// 397: check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : 13
		serializationMatchSteps[397] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/*CurlyBracketedClauseCS*/);
		// 398: check-rule essentialoclcs::TypeNameExpCS.ownedPathName : 73
		serializationMatchSteps[398] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 26/*PathNameCS*/);
		// 399: check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[399] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 400: check-rule essentialoclcs::VariableCS.ownedInitExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[400] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 401: check-rule essentialoclcs::VariableCS.ownedType : 118
		serializationMatchSteps[401] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 402: check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : 96
		serializationMatchSteps[402] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 40/*ScopeNameCS*/);
		// 403: check-rule qvtbasecs::AbstractTransformationCS.ownedTargets : 107
		serializationMatchSteps[403] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 50/*TargetCS*/);
		// 404: check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : 100
		serializationMatchSteps[404] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 42/*SimpleTargetElementCS*/);
		// 405: check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : 96
		serializationMatchSteps[405] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 40/*ScopeNameCS*/);
		// 406: check-rule qvtbasecs::TargetCS.ownedTargetElements : 12|100
		serializationMatchSteps[406] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 43/*CompoundTargetElementCS|SimpleTargetElementCS*/);
		// 407: check-rule qvtrelationcs::CollectionTemplateCS.ownedMemberIdentifiers : 21|109
		serializationMatchSteps[407] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS, 52/*ElementTemplateCS|TemplateCS*/);
		// 408: check-rule qvtrelationcs::CollectionTemplateCS.ownedRestIdentifier : 21
		serializationMatchSteps[408] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER, 6/*ElementTemplateCS*/);
		// 409: check-rule qvtrelationcs::DefaultValueCS.ownedInitExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[409] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 410: check-rule qvtrelationcs::DomainCS.ownedDefaultValues : 16
		serializationMatchSteps[410] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES, 4/*DefaultValueCS*/);
		// 411: check-rule qvtrelationcs::DomainCS.ownedPatterns : 18
		serializationMatchSteps[411] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS, 5/*DomainPatternCS*/);
		// 412: check-rule qvtrelationcs::DomainPatternCS.ownedTemplate : 109
		serializationMatchSteps[412] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS__OWNED_TEMPLATE, 51/*TemplateCS*/);
		// 413: check-rule qvtrelationcs::KeyDeclCS.ownedOppositePropertyIds : 73
		serializationMatchSteps[413] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS, 26/*PathNameCS*/);
		// 414: check-rule qvtrelationcs::KeyDeclCS.ownedPathName : 73
		serializationMatchSteps[414] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME, 26/*PathNameCS*/);
		// 415: check-rule qvtrelationcs::ObjectTemplateCS.ownedPropertyTemplates : 84
		serializationMatchSteps[415] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES, 35/*PropertyTemplateCS*/);
		// 416: check-rule qvtrelationcs::PatternCS.ownedPredicates : 75
		serializationMatchSteps[416] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.PATTERN_CS__OWNED_PREDICATES, 29/*PredicateCS*/);
		// 417: check-rule qvtrelationcs::PredicateCS.ownedCondition : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[417] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 418: check-rule qvtrelationcs::PrimitiveTypeDomainCS.ownedPatterns : 82
		serializationMatchSteps[418] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS, 34/*PrimitiveTypeDomainPatternCS*/);
		// 419: check-rule qvtrelationcs::PropertyTemplateCS.ownedExpression : 3|6|32|33|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|109|114|121|136
		serializationMatchSteps[419] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, 80/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|ExpCSOrTemplateCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TemplateCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 420: check-rule qvtrelationcs::PropertyTemplateCS.ownedOppositePropertyId : 73
		serializationMatchSteps[420] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID, 26/*PathNameCS*/);
		// 421: check-rule qvtrelationcs::QueryCS.ownedExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[421] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 422: check-rule qvtrelationcs::QueryCS.ownedParameters : 71
		serializationMatchSteps[422] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/*ParamDeclarationCS*/);
		// 423: check-rule qvtrelationcs::RelationCS.ownedDomains : 17|81
		serializationMatchSteps[423] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_DOMAINS, 33/*DomainCS|PrimitiveTypeDomainCS*/);
		// 424: check-rule qvtrelationcs::RelationCS.ownedVarDeclarations : 140
		serializationMatchSteps[424] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_VAR_DECLARATIONS, 81/*VarDeclarationCS*/);
		// 425: check-rule qvtrelationcs::RelationCS.ownedWhen : 143
		serializationMatchSteps[425] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHEN, 83/*WhenCS*/);
		// 426: check-rule qvtrelationcs::RelationCS.ownedWhere : 144
		serializationMatchSteps[426] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHERE, 84/*WhereCS*/);
		// 427: check-rule qvtrelationcs::TemplateCS.ownedGuardExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[427] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TEMPLATE_CS__OWNED_GUARD_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 428: check-rule qvtrelationcs::TemplateVariableCS.ownedType : 10
		serializationMatchSteps[428] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 2/*CollectionTypeCS*/);
		// 429: check-rule qvtrelationcs::TemplateVariableCS.ownedType : 118
		serializationMatchSteps[429] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 430: check-rule qvtrelationcs::TemplateVariableCS.ownedType : 127
		serializationMatchSteps[430] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 68/*TypedRefCS*/);
		// 431: check-rule qvtrelationcs::TopLevelCS.ownedTransformations : 113
		serializationMatchSteps[431] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 55/*TransformationCS*/);
		// 432: check-rule qvtrelationcs::TransformationCS.ownedKeyDecls : 41
		serializationMatchSteps[432] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_KEY_DECLS, 12/*KeyDeclCS*/);
		// 433: check-rule qvtrelationcs::TransformationCS.ownedModelDecls : 53
		serializationMatchSteps[433] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_MODEL_DECLS, 16/*ModelDeclCS*/);
		// 434: check-rule qvtrelationcs::TransformationCS.ownedProperties : 1|89|105
		serializationMatchSteps[434] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 48/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 435: check-rule qvtrelationcs::TransformationCS.ownedQueries : 88
		serializationMatchSteps[435] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES, 37/*QueryCS*/);
		// 436: check-rule qvtrelationcs::TransformationCS.ownedRelations : 90
		serializationMatchSteps[436] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_RELATIONS, 38/*RelationCS*/);
		// 437: check-rule qvtrelationcs::VarDeclarationCS.ownedInitExpression : 3|6|32|38|40|44|45|49|58|65|67|68|76|77|78|79|97|104|114|121|136
		serializationMatchSteps[437] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_INIT_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 438: check-rule qvtrelationcs::VarDeclarationCS.ownedType : 118
		serializationMatchSteps[438] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 439: check-rule qvtrelationcs::VarDeclarationCS.ownedVarDeclarationIds : 141
		serializationMatchSteps[439] = createMatchStep_RuleCheck(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS, 82/*VarDeclarationIdCS*/);
	}

	/**
	 * Initialize expression terms used during the matching process.
	 */
	private void initMatchTerms() {
		// 0: 0
		serializationMatchTerms[0] = createSerializationMatchTermInteger(0);
		// 1: 1
		serializationMatchTerms[1] = createSerializationMatchTermInteger(1);
		// 2: V0
		serializationMatchTerms[2] = createSerializationMatchTermVariable(0);
		// 3: |AbstractNameExpCS::isPre.'@'|
		serializationMatchTerms[3] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 8 /* '@' */);
		// 4: |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchTerms[4] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		// 5: |AbstractNameExpCS::ownedPathName|
		serializationMatchTerms[5] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME);
		// 6: |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchTerms[6] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		// 7: |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchTerms[7] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES);
		// 8: |AbstractTransformationCS::ownedPathName|
		serializationMatchTerms[8] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME);
		// 9: |AbstractTransformationCS::ownedTargets|
		serializationMatchTerms[9] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS);
		// 10: |BooleanLiteralExpCS::symbol.'false|true'|
		serializationMatchTerms[10] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 15 /* 'false|true' */);
		// 11: |ClassCS::instanceClassName|
		serializationMatchTerms[11] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME);
		// 12: |ClassCS::ownedConstraints|
		serializationMatchTerms[12] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__OWNED_CONSTRAINTS);
		// 13: |CollectionLiteralExpCS::ownedParts|
		serializationMatchTerms[13] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);
		// 14: |CollectionLiteralExpCS::ownedType|
		serializationMatchTerms[14] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE);
		// 15: |CollectionLiteralPartCS::ownedExpression|
		serializationMatchTerms[15] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION);
		// 16: |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchTerms[16] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION);
		// 17: |CollectionPatternCS::ownedParts|
		serializationMatchTerms[17] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS);
		// 18: |CollectionPatternCS::ownedPatternGuard|
		serializationMatchTerms[18] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD);
		// 19: |CollectionPatternCS::ownedType|
		serializationMatchTerms[19] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE);
		// 20: |CollectionPatternCS::restVariableName|
		serializationMatchTerms[20] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME);
		// 21: |CollectionTemplateCS::ownedMemberIdentifiers|
		serializationMatchTerms[21] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS);
		// 22: |CollectionTemplateCS::ownedRestIdentifier|
		serializationMatchTerms[22] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER);
		// 23: |CollectionTypeCS::name|
		serializationMatchTerms[23] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME);
		// 24: |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchTerms[24] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY);
		// 25: |CollectionTypeCS::ownedType|
		serializationMatchTerms[25] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE);
		// 26: |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchTerms[26] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS);
		// 27: |ContextCS::ownedExpression|
		serializationMatchTerms[27] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION);
		// 28: |CurlyBracketedClauseCS::ownedParts|
		serializationMatchTerms[28] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS);
		// 29: |CurlyBracketedClauseCS::value|
		serializationMatchTerms[29] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__VALUE);
		// 30: |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchTerms[30] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 19 /* 'primitive' */);
		// 31: |DataTypeCS::isSerializable.'serializable'|
		serializationMatchTerms[31] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 20 /* 'serializable' */);
		// 32: |DataTypeCS::isSerializable|
		serializationMatchTerms[32] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE);
		// 33: |DefaultValueCS::ownedInitExpression|
		serializationMatchTerms[33] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION);
		// 34: |DefaultValueCS::propertyId|
		serializationMatchTerms[34] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__PROPERTY_ID);
		// 35: |DomainCS::implementedBy|
		serializationMatchTerms[35] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__IMPLEMENTED_BY);
		// 36: |DomainCS::isCheckonly.'checkonly'|
		serializationMatchTerms[36] = createSerializationMatchTermEAttributeSize(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_CHECKONLY, 12 /* 'checkonly' */);
		// 37: |DomainCS::isCheckonly|
		serializationMatchTerms[37] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_CHECKONLY);
		// 38: |DomainCS::isEnforce.'enforce'|
		serializationMatchTerms[38] = createSerializationMatchTermEAttributeSize(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_ENFORCE, 14 /* 'enforce' */);
		// 39: |DomainCS::isEnforce|
		serializationMatchTerms[39] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_ENFORCE);
		// 40: |DomainCS::isReplace|
		serializationMatchTerms[40] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_REPLACE);
		// 41: |DomainCS::modelId|
		serializationMatchTerms[41] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__MODEL_ID);
		// 42: |DomainCS::ownedDefaultValues|
		serializationMatchTerms[42] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES);
		// 43: |DomainCS::ownedImplementedBy|
		serializationMatchTerms[43] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_IMPLEMENTED_BY);
		// 44: |DomainCS::ownedPatterns|
		serializationMatchTerms[44] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS);
		// 45: |DomainPatternCS::ownedTemplate|
		serializationMatchTerms[45] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS__OWNED_TEMPLATE);
		// 46: |ElementTemplateCS::identifier|
		serializationMatchTerms[46] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS__IDENTIFIER);
		// 47: |EnumerationCS::isSerializable.'serializable'|
		serializationMatchTerms[47] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 20 /* 'serializable' */);
		// 48: |EnumerationCS::isSerializable|
		serializationMatchTerms[48] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE);
		// 49: |EnumerationCS::ownedLiterals|
		serializationMatchTerms[49] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS);
		// 50: |EnumerationLiteralCS::literal|
		serializationMatchTerms[50] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__LITERAL);
		// 51: |EnumerationLiteralCS::value|
		serializationMatchTerms[51] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		// 52: |ExpSpecificationCS::ownedExpression|
		serializationMatchTerms[52] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION);
		// 53: |IfExpCS::isImplicit|
		serializationMatchTerms[53] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__IS_IMPLICIT);
		// 54: |IfExpCS::ownedCondition|
		serializationMatchTerms[54] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION);
		// 55: |IfExpCS::ownedElseExpression|
		serializationMatchTerms[55] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION);
		// 56: |IfExpCS::ownedIfThenExpressions|
		serializationMatchTerms[56] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS);
		// 57: |IfExpCS::ownedThenExpression|
		serializationMatchTerms[57] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION);
		// 58: |IfThenExpCS::ownedCondition|
		serializationMatchTerms[58] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION);
		// 59: |IfThenExpCS::ownedThenExpression|
		serializationMatchTerms[59] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION);
		// 60: |ImportCS::isAll.'*'|
		serializationMatchTerms[60] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, 4 /* '*' */);
		// 61: |ImportCS::ownedPathName|
		serializationMatchTerms[61] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME);
		// 62: |InfixExpCS::ownedLeft|
		serializationMatchTerms[62] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT);
		// 63: |JavaImplementationCS::implementation|
		serializationMatchTerms[63] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION);
		// 64: |KeyDeclCS::ownedOppositePropertyIds|
		serializationMatchTerms[64] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS);
		// 65: |KeyDeclCS::ownedPathName|
		serializationMatchTerms[65] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME);
		// 66: |KeyDeclCS::propertyIds|
		serializationMatchTerms[66] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.KEY_DECL_CS__PROPERTY_IDS);
		// 67: |LambdaLiteralExpCS::ownedExpressionCS|
		serializationMatchTerms[67] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS);
		// 68: |LetExpCS::isImplicit|
		serializationMatchTerms[68] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__IS_IMPLICIT);
		// 69: |LetExpCS::ownedInExpression|
		serializationMatchTerms[69] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION);
		// 70: |LetExpCS::ownedVariables|
		serializationMatchTerms[70] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES);
		// 71: |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchTerms[71] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		// 72: |MapLiteralExpCS::ownedParts|
		serializationMatchTerms[72] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS);
		// 73: |MapLiteralExpCS::ownedType|
		serializationMatchTerms[73] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE);
		// 74: |MapLiteralPartCS::ownedKey|
		serializationMatchTerms[74] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY);
		// 75: |MapLiteralPartCS::ownedValue|
		serializationMatchTerms[75] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE);
		// 76: |MapTypeCS::name.'Map'|
		serializationMatchTerms[76] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 9 /* 'Map' */);
		// 77: |MapTypeCS::ownedKeyType|
		serializationMatchTerms[77] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE);
		// 78: |MapTypeCS::ownedValueType|
		serializationMatchTerms[78] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE);
		// 79: |ModelDeclCS::dependsOn|
		serializationMatchTerms[79] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON);
		// 80: |ModelDeclCS::iterates|
		serializationMatchTerms[80] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES);
		// 81: |ModelDeclCS::metamodelIds|
		serializationMatchTerms[81] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS);
		// 82: |ModelElementCS::ownedAnnotations|
		serializationMatchTerms[82] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS);
		// 83: |MultiplicityBoundsCS::lowerBound|
		serializationMatchTerms[83] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND);
		// 84: |MultiplicityBoundsCS::upperBound|
		serializationMatchTerms[84] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND);
		// 85: |MultiplicityCS::isNullFree.'|1'|
		serializationMatchTerms[85] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 26 /* '|1' */);
		// 86: |MultiplicityCS::isNullFree|
		serializationMatchTerms[86] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE);
		// 87: |MultiplicityStringCS::stringBounds.'*|+|?'|
		serializationMatchTerms[87] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 5 /* '*|+|?' */);
		// 88: |NamedElementCS::name|
		serializationMatchTerms[88] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME);
		// 89: |NavigatingArgCS::ownedCoIterator|
		serializationMatchTerms[89] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR);
		// 90: |NavigatingArgCS::ownedInitExpression|
		serializationMatchTerms[90] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION);
		// 91: |NavigatingArgCS::ownedNameExpression|
		serializationMatchTerms[91] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION);
		// 92: |NavigatingArgCS::ownedType|
		serializationMatchTerms[92] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE);
		// 93: |NavigatingArgCS::prefix.','|
		serializationMatchTerms[93] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ',' */);
		// 94: |NavigatingArgCS::prefix.';'|
		serializationMatchTerms[94] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 7 /* ';' */);
		// 95: |NavigatingArgCS::prefix.'|'|
		serializationMatchTerms[95] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 25 /* '|' */);
		// 96: |NavigatingArgCS::prefix|
		serializationMatchTerms[96] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX);
		// 97: |NestedExpCS::ownedExpression|
		serializationMatchTerms[97] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION);
		// 98: |NumberLiteralExpCS::symbol|
		serializationMatchTerms[98] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL);
		// 99: |ObjectTemplateCS::ownedPropertyTemplates|
		serializationMatchTerms[99] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES);
		// 100: |OperationCS::ownedBodyExpressions|
		serializationMatchTerms[100] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS);
		// 101: |OperationCS::ownedExceptions|
		serializationMatchTerms[101] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS);
		// 102: |OperationCS::ownedParameters|
		serializationMatchTerms[102] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS);
		// 103: |OperationCS::ownedPostconditions|
		serializationMatchTerms[103] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_POSTCONDITIONS);
		// 104: |OperationCS::ownedPreconditions|
		serializationMatchTerms[104] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PRECONDITIONS);
		// 105: |OperatorExpCS::ownedRight|
		serializationMatchTerms[105] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT);
		// 106: |PackageCS::nsPrefix|
		serializationMatchTerms[106] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX);
		// 107: |PackageCS::nsURI|
		serializationMatchTerms[107] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__NS_URI);
		// 108: |PackageCS::ownedClasses|
		serializationMatchTerms[108] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES);
		// 109: |PackageOwnerCS::ownedPackages|
		serializationMatchTerms[109] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES);
		// 110: |PathElementCS::referredElement|
		serializationMatchTerms[110] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT);
		// 111: |PathNameCS::ownedPathElements|
		serializationMatchTerms[111] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS);
		// 112: |PatternCS::ownedPredicates|
		serializationMatchTerms[112] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.PATTERN_CS__OWNED_PREDICATES);
		// 113: |PatternExpCS::ownedPatternType|
		serializationMatchTerms[113] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE);
		// 114: |PatternExpCS::patternVariableName|
		serializationMatchTerms[114] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME);
		// 115: |PredicateCS::ownedCondition|
		serializationMatchTerms[115] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION);
		// 116: |PrimitiveTypeDomainCS::ownedPatterns|
		serializationMatchTerms[116] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS);
		// 117: |PrimitiveTypeRefCS::name|
		serializationMatchTerms[117] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME);
		// 118: |PropertyTemplateCS::ownedExpression|
		serializationMatchTerms[118] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION);
		// 119: |PropertyTemplateCS::ownedOppositePropertyId|
		serializationMatchTerms[119] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID);
		// 120: |PropertyTemplateCS::propertyId|
		serializationMatchTerms[120] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__PROPERTY_ID);
		// 121: |QualifiedPackageCS::ownedPathName|
		serializationMatchTerms[121] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME);
		// 122: |QueryCS::isTransient.'transient'|
		serializationMatchTerms[122] = createSerializationMatchTermEAttributeSize(QVTrelationCSPackage.Literals.QUERY_CS__IS_TRANSIENT, 23 /* 'transient' */);
		// 123: |QueryCS::ownedExpression|
		serializationMatchTerms[123] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION);
		// 124: |QueryCS::ownedParameters|
		serializationMatchTerms[124] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS);
		// 125: |ReferenceCS::ownedImplicitOpposites|
		serializationMatchTerms[125] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__OWNED_IMPLICIT_OPPOSITES);
		// 126: |ReferenceCS::referredKeys|
		serializationMatchTerms[126] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_KEYS);
		// 127: |ReferenceCS::referredOpposite|
		serializationMatchTerms[127] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE);
		// 128: |RelationCS::isAbstract.'abstract'|
		serializationMatchTerms[128] = createSerializationMatchTermEAttributeSize(QVTrelationCSPackage.Literals.RELATION_CS__IS_ABSTRACT, 11 /* 'abstract' */);
		// 129: |RelationCS::isTop.'top'|
		serializationMatchTerms[129] = createSerializationMatchTermEAttributeSize(QVTrelationCSPackage.Literals.RELATION_CS__IS_TOP, 22 /* 'top' */);
		// 130: |RelationCS::overridden|
		serializationMatchTerms[130] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.RELATION_CS__OVERRIDDEN);
		// 131: |RelationCS::ownedDomains|
		serializationMatchTerms[131] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_DOMAINS);
		// 132: |RelationCS::ownedVarDeclarations|
		serializationMatchTerms[132] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_VAR_DECLARATIONS);
		// 133: |RelationCS::ownedWhen|
		serializationMatchTerms[133] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHEN);
		// 134: |RelationCS::ownedWhere|
		serializationMatchTerms[134] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHERE);
		// 135: |RootCS::ownedImports|
		serializationMatchTerms[135] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS);
		// 136: |SelfExpCS::name|
		serializationMatchTerms[136] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SELF_EXP_CS__NAME);
		// 137: |ShadowPartCS::ownedInitExpression|
		serializationMatchTerms[137] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION);
		// 138: |ShadowPartCS::referredProperty|
		serializationMatchTerms[138] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY);
		// 139: |SimpleTargetElementCS::input.'input'|
		serializationMatchTerms[139] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 16 /* 'input' */);
		// 140: |SimpleTargetElementCS::input|
		serializationMatchTerms[140] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT);
		// 141: |SimpleTargetElementCS::iterates|
		serializationMatchTerms[141] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES);
		// 142: |SimpleTargetElementCS::output.'output'|
		serializationMatchTerms[142] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 18 /* 'output' */);
		// 143: |SimpleTargetElementCS::output|
		serializationMatchTerms[143] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT);
		// 144: |SimpleTargetElementCS::typedModel|
		serializationMatchTerms[144] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL);
		// 145: |SimpleTargetElementCS::via.'via'|
		serializationMatchTerms[145] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 24 /* 'via' */);
		// 146: |SimpleTargetElementCS::via|
		serializationMatchTerms[146] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA);
		// 147: |SpecificationCS::exprString|
		serializationMatchTerms[147] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING);
		// 148: |SquareBracketedClauseCS::ownedTerms|
		serializationMatchTerms[148] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS);
		// 149: |StringLiteralExpCS::segments|
		serializationMatchTerms[149] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS);
		// 150: |StructuralFeatureCS::default|
		serializationMatchTerms[150] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT);
		// 151: |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchTerms[151] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS);
		// 152: |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchTerms[152] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 11 /* 'abstract' */);
		// 153: |StructuredClassCS::isInterface.'interface'|
		serializationMatchTerms[153] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 17 /* 'interface' */);
		// 154: |StructuredClassCS::ownedMetaclass|
		serializationMatchTerms[154] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_METACLASS);
		// 155: |StructuredClassCS::ownedOperations|
		serializationMatchTerms[155] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS);
		// 156: |StructuredClassCS::ownedProperties|
		serializationMatchTerms[156] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES);
		// 157: |StructuredClassCS::ownedSuperTypes|
		serializationMatchTerms[157] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES);
		// 158: |TargetCS::ownedTargetElements|
		serializationMatchTerms[158] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS);
		// 159: |TemplateBindingCS::ownedMultiplicity|
		serializationMatchTerms[159] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY);
		// 160: |TemplateBindingCS::ownedSubstitutions|
		serializationMatchTerms[160] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS);
		// 161: |TemplateCS::ownedGuardExpression|
		serializationMatchTerms[161] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TEMPLATE_CS__OWNED_GUARD_EXPRESSION);
		// 162: |TemplateParameterSubstitutionCS::ownedActualParameter|
		serializationMatchTerms[162] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER);
		// 163: |TemplateSignatureCS::ownedParameters|
		serializationMatchTerms[163] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS);
		// 164: |TemplateVariableCS::ownedType|
		serializationMatchTerms[164] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE);
		// 165: |TemplateableElementCS::ownedSignature|
		serializationMatchTerms[165] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE);
		// 166: |TopLevelCS::ownedTransformations|
		serializationMatchTerms[166] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);
		// 167: |TransformationCS::extends|
		serializationMatchTerms[167] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__EXTENDS);
		// 168: |TransformationCS::ownedKeyDecls|
		serializationMatchTerms[168] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_KEY_DECLS);
		// 169: |TransformationCS::ownedModelDecls|
		serializationMatchTerms[169] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_MODEL_DECLS);
		// 170: |TransformationCS::ownedProperties|
		serializationMatchTerms[170] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES);
		// 171: |TransformationCS::ownedQueries|
		serializationMatchTerms[171] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES);
		// 172: |TransformationCS::ownedRelations|
		serializationMatchTerms[172] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_RELATIONS);
		// 173: |TupleLiteralExpCS::ownedParts|
		serializationMatchTerms[173] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS);
		// 174: |TupleTypeCS::name.'Tuple'|
		serializationMatchTerms[174] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 10 /* 'Tuple' */);
		// 175: |TupleTypeCS::ownedParts|
		serializationMatchTerms[175] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS);
		// 176: |TypeLiteralExpCS::ownedPathName|
		serializationMatchTerms[176] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_PATH_NAME);
		// 177: |TypeLiteralExpCS::ownedType|
		serializationMatchTerms[177] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE);
		// 178: |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchTerms[178] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		// 179: |TypeNameExpCS::ownedPathName|
		serializationMatchTerms[179] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME);
		// 180: |TypeNameExpCS::ownedPatternGuard|
		serializationMatchTerms[180] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD);
		// 181: |TypeParameterCS::ownedExtends|
		serializationMatchTerms[181] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS);
		// 182: |TypedElementCS::isOptional|
		serializationMatchTerms[182] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__IS_OPTIONAL);
		// 183: |TypedElementCS::ownedType|
		serializationMatchTerms[183] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE);
		// 184: |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchTerms[184] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */);
		// 185: |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchTerms[185] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */);
		// 186: |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchTerms[186] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */);
		// 187: |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchTerms[187] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */);
		// 188: |TypedElementCS::qualifiers.'definition'|
		serializationMatchTerms[188] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 13 /* 'definition' */);
		// 189: |TypedElementCS::qualifiers.'static'|
		serializationMatchTerms[189] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 21 /* 'static' */);
		// 190: |TypedElementCS::qualifiers|
		serializationMatchTerms[190] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS);
		// 191: |TypedRefCS::ownedMultiplicity|
		serializationMatchTerms[191] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY);
		// 192: |TypedTypeRefCS::isTypeof|
		serializationMatchTerms[192] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__IS_TYPEOF);
		// 193: |TypedTypeRefCS::ownedBinding|
		serializationMatchTerms[193] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING);
		// 194: |TypedTypeRefCS::ownedPathName|
		serializationMatchTerms[194] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME);
		// 195: |VarDeclarationCS::ownedInitExpression|
		serializationMatchTerms[195] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_INIT_EXPRESSION);
		// 196: |VarDeclarationCS::ownedType|
		serializationMatchTerms[196] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_TYPE);
		// 197: |VarDeclarationCS::ownedVarDeclarationIds|
		serializationMatchTerms[197] = createSerializationMatchTermEStructuralFeatureSize(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS);
		// 198: |VariableCS::ownedInitExpression|
		serializationMatchTerms[198] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION);
		// 199: |VariableCS::ownedType|
		serializationMatchTerms[199] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE);
		// 200: |WildcardTypeRefCS::ownedExtends|
		serializationMatchTerms[200] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS);
		// 201: |WildcardTypeRefCS::ownedSuper|
		serializationMatchTerms[201] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_SUPER);
		// 202: (|AbstractNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[202] = createSerializationMatchTermSubtract(5, 1);
		// 203: (|BooleanLiteralExpCS::symbol.'false|true'| - 1)
		serializationMatchTerms[203] = createSerializationMatchTermSubtract(10, 1);
		// 204: (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[204] = createSerializationMatchTermSubtract(13, 1);
		// 205: (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[205] = createSerializationMatchTermGreaterThan(13, 0);
		// 206: (|CollectionLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[206] = createSerializationMatchTermSubtract(14, 1);
		// 207: (|CollectionLiteralPartCS::ownedExpression| - 1)
		serializationMatchTerms[207] = createSerializationMatchTermSubtract(15, 1);
		// 208: (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchTerms[208] = createSerializationMatchTermSubtract(17, 1);
		// 209: (|CollectionPatternCS::ownedType| - 1)
		serializationMatchTerms[209] = createSerializationMatchTermSubtract(19, 1);
		// 210: (|CollectionTemplateCS::ownedMemberIdentifiers| - 1)
		serializationMatchTerms[210] = createSerializationMatchTermSubtract(21, 1);
		// 211: (|CollectionTemplateCS::ownedRestIdentifier| > 0)
		serializationMatchTerms[211] = createSerializationMatchTermGreaterThan(22, 0);
		// 212: (|CollectionTypeCS::name| - 1)
		serializationMatchTerms[212] = createSerializationMatchTermSubtract(23, 1);
		// 213: (|ContextCS::ownedExpression| - 1)
		serializationMatchTerms[213] = createSerializationMatchTermSubtract(27, 1);
		// 214: (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchTerms[214] = createSerializationMatchTermSubtract(28, 1);
		// 215: (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchTerms[215] = createSerializationMatchTermGreaterThan(28, 0);
		// 216: (|DefaultValueCS::ownedInitExpression| - 1)
		serializationMatchTerms[216] = createSerializationMatchTermSubtract(33, 1);
		// 217: (|DefaultValueCS::propertyId| - 1)
		serializationMatchTerms[217] = createSerializationMatchTermSubtract(34, 1);
		// 218: (|DomainCS::isCheckonly.'checkonly'| - 1)
		serializationMatchTerms[218] = createSerializationMatchTermSubtract(36, 1);
		// 219: (|DomainCS::isEnforce.'enforce'| - 1)
		serializationMatchTerms[219] = createSerializationMatchTermSubtract(38, 1);
		// 220: (|DomainCS::modelId| - 1)
		serializationMatchTerms[220] = createSerializationMatchTermSubtract(41, 1);
		// 221: (|DomainCS::ownedDefaultValues| > 0)
		serializationMatchTerms[221] = createSerializationMatchTermGreaterThan(42, 0);
		// 222: (|DomainCS::ownedPatterns| - 1)
		serializationMatchTerms[222] = createSerializationMatchTermSubtract(44, 1);
		// 223: (|DomainCS::ownedPatterns| > 0)
		serializationMatchTerms[223] = createSerializationMatchTermGreaterThan(44, 0);
		// 224: (|DomainPatternCS::ownedTemplate| - 1)
		serializationMatchTerms[224] = createSerializationMatchTermSubtract(45, 1);
		// 225: (|ElementTemplateCS::identifier| - 1)
		serializationMatchTerms[225] = createSerializationMatchTermSubtract(46, 1);
		// 226: (|ExpSpecificationCS::ownedExpression| - 1)
		serializationMatchTerms[226] = createSerializationMatchTermSubtract(52, 1);
		// 227: (|IfExpCS::ownedCondition| - 1)
		serializationMatchTerms[227] = createSerializationMatchTermSubtract(54, 1);
		// 228: (|IfExpCS::ownedElseExpression| - 1)
		serializationMatchTerms[228] = createSerializationMatchTermSubtract(55, 1);
		// 229: (|IfExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[229] = createSerializationMatchTermSubtract(57, 1);
		// 230: (|IfThenExpCS::ownedCondition| - 1)
		serializationMatchTerms[230] = createSerializationMatchTermSubtract(58, 1);
		// 231: (|IfThenExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[231] = createSerializationMatchTermSubtract(59, 1);
		// 232: (|ImportCS::ownedPathName| - 1)
		serializationMatchTerms[232] = createSerializationMatchTermSubtract(61, 1);
		// 233: (|InfixExpCS::ownedLeft| - 1)
		serializationMatchTerms[233] = createSerializationMatchTermSubtract(62, 1);
		// 234: (|JavaImplementationCS::implementation| - 1)
		serializationMatchTerms[234] = createSerializationMatchTermSubtract(63, 1);
		// 235: (|KeyDeclCS::ownedOppositePropertyIds| - 1)
		serializationMatchTerms[235] = createSerializationMatchTermSubtract(64, 1);
		// 236: (|KeyDeclCS::ownedPathName| - 1)
		serializationMatchTerms[236] = createSerializationMatchTermSubtract(65, 1);
		// 237: (|KeyDeclCS::propertyIds| - 1)
		serializationMatchTerms[237] = createSerializationMatchTermSubtract(66, 1);
		// 238: (|LambdaLiteralExpCS::ownedExpressionCS| - 1)
		serializationMatchTerms[238] = createSerializationMatchTermSubtract(67, 1);
		// 239: (|LetExpCS::ownedInExpression| - 1)
		serializationMatchTerms[239] = createSerializationMatchTermSubtract(69, 1);
		// 240: (|LetExpCS::ownedVariables| - 1)
		serializationMatchTerms[240] = createSerializationMatchTermSubtract(70, 1);
		// 241: (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[241] = createSerializationMatchTermSubtract(72, 1);
		// 242: (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[242] = createSerializationMatchTermGreaterThan(72, 0);
		// 243: (|MapLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[243] = createSerializationMatchTermSubtract(73, 1);
		// 244: (|MapLiteralPartCS::ownedKey| - 1)
		serializationMatchTerms[244] = createSerializationMatchTermSubtract(74, 1);
		// 245: (|MapLiteralPartCS::ownedValue| - 1)
		serializationMatchTerms[245] = createSerializationMatchTermSubtract(75, 1);
		// 246: (|MapTypeCS::name.'Map'| - 1)
		serializationMatchTerms[246] = createSerializationMatchTermSubtract(76, 1);
		// 247: (|MapTypeCS::ownedKeyType| - V0)
		serializationMatchTerms[247] = createSerializationMatchTermSubtract(77, 2);
		// 248: (|ModelDeclCS::dependsOn| - 1)
		serializationMatchTerms[248] = createSerializationMatchTermSubtract(79, 1);
		// 249: (|ModelDeclCS::dependsOn| > 0)
		serializationMatchTerms[249] = createSerializationMatchTermGreaterThan(79, 0);
		// 250: (|ModelDeclCS::iterates| - 1)
		serializationMatchTerms[250] = createSerializationMatchTermSubtract(80, 1);
		// 251: (|ModelDeclCS::iterates| > 0)
		serializationMatchTerms[251] = createSerializationMatchTermGreaterThan(80, 0);
		// 252: (|ModelDeclCS::metamodelIds| - 1)
		serializationMatchTerms[252] = createSerializationMatchTermSubtract(81, 1);
		// 253: (|MultiplicityBoundsCS::lowerBound| - 1)
		serializationMatchTerms[253] = createSerializationMatchTermSubtract(83, 1);
		// 254: (|MultiplicityCS::isNullFree.'|1'| - 1)
		serializationMatchTerms[254] = createSerializationMatchTermSubtract(85, 1);
		// 255: (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1)
		serializationMatchTerms[255] = createSerializationMatchTermSubtract(87, 1);
		// 256: (|NamedElementCS::name| - 1)
		serializationMatchTerms[256] = createSerializationMatchTermSubtract(88, 1);
		// 257: (|NavigatingArgCS::ownedCoIterator| - 1)
		serializationMatchTerms[257] = createSerializationMatchTermSubtract(89, 1);
		// 258: (|NavigatingArgCS::ownedInitExpression| - 1)
		serializationMatchTerms[258] = createSerializationMatchTermSubtract(90, 1);
		// 259: (|NavigatingArgCS::ownedNameExpression| - 1)
		serializationMatchTerms[259] = createSerializationMatchTermSubtract(91, 1);
		// 260: (|NavigatingArgCS::ownedType| - 1)
		serializationMatchTerms[260] = createSerializationMatchTermSubtract(92, 1);
		// 261: (|NavigatingArgCS::prefix.','| - 1)
		serializationMatchTerms[261] = createSerializationMatchTermSubtract(93, 1);
		// 262: (|NavigatingArgCS::prefix.';'| - 1)
		serializationMatchTerms[262] = createSerializationMatchTermSubtract(94, 1);
		// 263: (|NavigatingArgCS::prefix.'|'| - 1)
		serializationMatchTerms[263] = createSerializationMatchTermSubtract(95, 1);
		// 264: (|NestedExpCS::ownedExpression| - 1)
		serializationMatchTerms[264] = createSerializationMatchTermSubtract(97, 1);
		// 265: (|NumberLiteralExpCS::symbol| - 1)
		serializationMatchTerms[265] = createSerializationMatchTermSubtract(98, 1);
		// 266: (|ObjectTemplateCS::ownedPropertyTemplates| - 1)
		serializationMatchTerms[266] = createSerializationMatchTermSubtract(99, 1);
		// 267: (|ObjectTemplateCS::ownedPropertyTemplates| > 0)
		serializationMatchTerms[267] = createSerializationMatchTermGreaterThan(99, 0);
		// 268: (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchTerms[268] = createSerializationMatchTermGreaterThan(100, 0);
		// 269: (|OperationCS::ownedExceptions| - 1)
		serializationMatchTerms[269] = createSerializationMatchTermSubtract(101, 1);
		// 270: (|OperationCS::ownedExceptions| > 0)
		serializationMatchTerms[270] = createSerializationMatchTermGreaterThan(101, 0);
		// 271: (|OperationCS::ownedParameters| - 1)
		serializationMatchTerms[271] = createSerializationMatchTermSubtract(102, 1);
		// 272: (|OperationCS::ownedParameters| > 0)
		serializationMatchTerms[272] = createSerializationMatchTermGreaterThan(102, 0);
		// 273: (|OperatorExpCS::ownedRight| - 1)
		serializationMatchTerms[273] = createSerializationMatchTermSubtract(105, 1);
		// 274: (|PathElementCS::referredElement| - 1)
		serializationMatchTerms[274] = createSerializationMatchTermSubtract(110, 1);
		// 275: (|PathNameCS::ownedPathElements| - 1)
		serializationMatchTerms[275] = createSerializationMatchTermSubtract(111, 1);
		// 276: (|PatternExpCS::ownedPatternType| - 1)
		serializationMatchTerms[276] = createSerializationMatchTermSubtract(113, 1);
		// 277: (|PredicateCS::ownedCondition| - 1)
		serializationMatchTerms[277] = createSerializationMatchTermSubtract(115, 1);
		// 278: (|PrimitiveTypeDomainCS::ownedPatterns| - 1)
		serializationMatchTerms[278] = createSerializationMatchTermSubtract(116, 1);
		// 279: (|PrimitiveTypeRefCS::name| - 1)
		serializationMatchTerms[279] = createSerializationMatchTermSubtract(117, 1);
		// 280: (|PropertyTemplateCS::ownedExpression| - 1)
		serializationMatchTerms[280] = createSerializationMatchTermSubtract(118, 1);
		// 281: (|PropertyTemplateCS::ownedOppositePropertyId| - 1)
		serializationMatchTerms[281] = createSerializationMatchTermSubtract(119, 1);
		// 282: (|PropertyTemplateCS::propertyId| - 1)
		serializationMatchTerms[282] = createSerializationMatchTermSubtract(120, 1);
		// 283: (|QueryCS::ownedExpression| - 1)
		serializationMatchTerms[283] = createSerializationMatchTermSubtract(123, 1);
		// 284: (|QueryCS::ownedParameters| - 1)
		serializationMatchTerms[284] = createSerializationMatchTermSubtract(124, 1);
		// 285: (|QueryCS::ownedParameters| > 0)
		serializationMatchTerms[285] = createSerializationMatchTermGreaterThan(124, 0);
		// 286: (|ShadowPartCS::ownedInitExpression| - 1)
		serializationMatchTerms[286] = createSerializationMatchTermSubtract(137, 1);
		// 287: (|ShadowPartCS::referredProperty| - 1)
		serializationMatchTerms[287] = createSerializationMatchTermSubtract(138, 1);
		// 288: (|SimpleTargetElementCS::input.'input'| - 1)
		serializationMatchTerms[288] = createSerializationMatchTermSubtract(139, 1);
		// 289: (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchTerms[289] = createSerializationMatchTermSubtract(141, 1);
		// 290: (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchTerms[290] = createSerializationMatchTermGreaterThan(141, 0);
		// 291: (|SimpleTargetElementCS::output.'output'| - 1)
		serializationMatchTerms[291] = createSerializationMatchTermSubtract(142, 1);
		// 292: (|SimpleTargetElementCS::typedModel| - 1)
		serializationMatchTerms[292] = createSerializationMatchTermSubtract(144, 1);
		// 293: (|SimpleTargetElementCS::via.'via'| - 1)
		serializationMatchTerms[293] = createSerializationMatchTermSubtract(145, 1);
		// 294: (|SpecificationCS::exprString| - 1)
		serializationMatchTerms[294] = createSerializationMatchTermSubtract(147, 1);
		// 295: (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchTerms[295] = createSerializationMatchTermSubtract(148, 1);
		// 296: (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchTerms[296] = createSerializationMatchTermGreaterThan(151, 0);
		// 297: (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchTerms[297] = createSerializationMatchTermGreaterThan(153, 0);
		// 298: (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchTerms[298] = createSerializationMatchTermSubtract(157, 1);
		// 299: (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchTerms[299] = createSerializationMatchTermGreaterThan(157, 0);
		// 300: (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchTerms[300] = createSerializationMatchTermSubtract(160, 1);
		// 301: (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1)
		serializationMatchTerms[301] = createSerializationMatchTermSubtract(162, 1);
		// 302: (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchTerms[302] = createSerializationMatchTermSubtract(163, 1);
		// 303: (|TemplateVariableCS::ownedType| - 1)
		serializationMatchTerms[303] = createSerializationMatchTermSubtract(164, 1);
		// 304: (|TransformationCS::extends| - 1)
		serializationMatchTerms[304] = createSerializationMatchTermSubtract(167, 1);
		// 305: (|TransformationCS::extends| > 0)
		serializationMatchTerms[305] = createSerializationMatchTermGreaterThan(167, 0);
		// 306: (|TransformationCS::ownedModelDecls| - 1)
		serializationMatchTerms[306] = createSerializationMatchTermSubtract(169, 1);
		// 307: (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[307] = createSerializationMatchTermSubtract(173, 1);
		// 308: (|TupleTypeCS::name.'Tuple'| - 1)
		serializationMatchTerms[308] = createSerializationMatchTermSubtract(174, 1);
		// 309: (|TupleTypeCS::ownedParts| - 1)
		serializationMatchTerms[309] = createSerializationMatchTermSubtract(175, 1);
		// 310: (|TupleTypeCS::ownedParts| > 0)
		serializationMatchTerms[310] = createSerializationMatchTermGreaterThan(175, 0);
		// 311: (|TypeLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[311] = createSerializationMatchTermSubtract(177, 1);
		// 312: (|TypeNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[312] = createSerializationMatchTermSubtract(179, 1);
		// 313: (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchTerms[313] = createSerializationMatchTermSubtract(181, 1);
		// 314: (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchTerms[314] = createSerializationMatchTermGreaterThan(181, 0);
		// 315: (|TypedElementCS::ownedType| - 1)
		serializationMatchTerms[315] = createSerializationMatchTermSubtract(183, 1);
		// 316: (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[316] = createSerializationMatchTermGreaterThan(184, 0);
		// 317: (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[317] = createSerializationMatchTermGreaterThan(185, 0);
		// 318: (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchTerms[318] = createSerializationMatchTermGreaterThan(186, 0);
		// 319: (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchTerms[319] = createSerializationMatchTermGreaterThan(187, 0);
		// 320: (|TypedElementCS::qualifiers.'definition'| - 1)
		serializationMatchTerms[320] = createSerializationMatchTermSubtract(188, 1);
		// 321: (|TypedElementCS::qualifiers.'static'| - 1)
		serializationMatchTerms[321] = createSerializationMatchTermSubtract(189, 1);
		// 322: (|TypedTypeRefCS::ownedPathName| - 1)
		serializationMatchTerms[322] = createSerializationMatchTermSubtract(194, 1);
		// 323: (|VarDeclarationCS::ownedVarDeclarationIds| - 1)
		serializationMatchTerms[323] = createSerializationMatchTermSubtract(197, 1);
		// 324: (|VariableCS::ownedInitExpression| - 1)
		serializationMatchTerms[324] = createSerializationMatchTermSubtract(198, 1);
	}

	/**
	 * Initialize the various serialization rules that serialize an EClass.
	 */
	private void initSerializationRules0() {
		// Base::FirstPathElementCS-0(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[0] = createSerializationRule("FirstPathElementCS-0", 34,
			createSerializationMatchSteps(
				48		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				343		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::MultiplicityBoundsCS-0(basecs::MultiplicityBoundsCS): { lowerBound=LOWER { ".." upperBound=UPPER }[?] }
		serializationRules[1] = createSerializationRule("MultiplicityBoundsCS-0", 54,
			createSerializationMatchSteps(
				94		/* assert |MultiplicityCS::isNullFree| == 0 */,
				166		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				34		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				171		/* '..' || no-space value no-space */,
				158		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-0(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "|?" "]" }
		serializationRules[2] = createSerializationRule("MultiplicityCS-0", 55,
			createSerializationMatchSteps(
				94		/* assert |MultiplicityCS::isNullFree| == 0 */,
				166		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				34		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				181		/* '[' || no-space value no-space */,
				24		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				171		/* '..' || no-space value no-space */,
				158		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				232		/* '|?' || no-space value no-space */,
				182		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-1(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } isNullFree?="|1" "]" }
		serializationRules[3] = createSerializationRule("MultiplicityCS-1", 55,
			createSerializationMatchSteps(
				35		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				166		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				34		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				181		/* '[' || no-space value no-space */,
				24		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				171		/* '..' || no-space value no-space */,
				158		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				15		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				182		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(26/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-2(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "]" }
		serializationRules[4] = createSerializationRule("MultiplicityCS-2", 55,
			createSerializationMatchSteps(
				94		/* assert |MultiplicityCS::isNullFree| == 0 */,
				166		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				34		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				181		/* '[' || no-space value no-space */,
				24		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				171		/* '..' || no-space value no-space */,
				158		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				182		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-3(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "|?" "]" }
		serializationRules[5] = createSerializationRule("MultiplicityCS-3", 55,
			createSerializationMatchSteps(
				94		/* assert |MultiplicityCS::isNullFree| == 0 */,
				36		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				181		/* '[' || no-space value no-space */,
				154		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				232		/* '|?' || no-space value no-space */,
				182		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(5/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-4(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} isNullFree?="|1" "]" }
		serializationRules[6] = createSerializationRule("MultiplicityCS-4", 55,
			createSerializationMatchSteps(
				35		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				36		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				181		/* '[' || no-space value no-space */,
				154		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				15		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				182		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(26/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(5/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-5(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "]" }
		serializationRules[7] = createSerializationRule("MultiplicityCS-5", 55,
			createSerializationMatchSteps(
				94		/* assert |MultiplicityCS::isNullFree| == 0 */,
				36		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				181		/* '[' || no-space value no-space */,
				154		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				182		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(5/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityStringCS-0(basecs::MultiplicityStringCS): stringBounds={'*|+|?'}
		serializationRules[8] = createSerializationRule("MultiplicityStringCS-0", 56,
			createSerializationMatchSteps(
				94		/* assert |MultiplicityCS::isNullFree| == 0 */,
				36		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				154		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(5/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::NextPathElementCS-0(basecs::PathElementCS): referredElement=UnreservedName
		serializationRules[9] = createSerializationRule("NextPathElementCS-0", 66,
			createSerializationMatchSteps(
				48		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				342		/* PathElementCS::referredElement=UnreservedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::PathNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[10] = createSerializationRule("PathNameCS-0", 73,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				325		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				248		/* V00*2-steps || value */,
				174		/* '::' || no-space value no-space */,
				326		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 22/* FirstPathElementCS,NextPathElementCS */,
					(34/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(66/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TemplateBindingCS-0(basecs::TemplateBindingCS): { ownedSubstitutions+=TemplateParameterSubstitutionCS { "," ownedSubstitutions+=TemplateParameterSubstitutionCS }[*] ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[11] = createSerializationRule("TemplateBindingCS-0", 108,
			createSerializationMatchSteps(
				338		/* check-rule basecs::TemplateBindingCS.ownedMultiplicity : MultiplicityCS */,
				339		/* check-rule basecs::TemplateBindingCS.ownedSubstitutions : TemplateParameterSubstitutionCS */,
				219		/* assign V1 = |TemplateBindingCS::ownedMultiplicity| */,
				146		/* assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1) */
			),
			createSerializationSteps(
				118		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				118		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				256		/* V01*1-steps || value */,
				79		/* TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 53/* TemplateParameterSubstitutionCS */,
					(110/*TemplateParameterSubstitutionCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TemplateParameterSubstitutionCS-0(basecs::TemplateParameterSubstitutionCS): ownedActualParameter=TypeRefCS
		serializationRules[12] = createSerializationRule("TemplateParameterSubstitutionCS-0", 110,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				340		/* check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : TypeRefCS|TypedRefCS|WildcardTypeRefCS */,
				64		/* assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0 */
			),
			createSerializationSteps(
				36		/* TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 66/* TypeRefCS */,
					(125/*TypeRefCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::TemplateSignatureCS-0(basecs::TemplateSignatureCS): { "(" ownedParameters+=TypeParameterCS { "," ownedParameters+=TypeParameterCS }[*] ")" }
		serializationRules[13] = createSerializationRule("TemplateSignatureCS-0", 111,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				341		/* check-rule basecs::TemplateSignatureCS.ownedParameters : TypeParameterCS */,
				147		/* assign V0 = (|TemplateSignatureCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				165		/* '(' || no-space value no-space */,
				89		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				89		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				166		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 65/* TypeParameterCS */,
					(124/*TypeParameterCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TypeParameterCS-0(basecs::TypeParameterCS): { name=UnrestrictedName { "extends" ownedExtends+=TypedRefCS { "&&" ownedExtends+=TypedRefCS }[*] }[?] }
		serializationRules[14] = createSerializationRule("TypeParameterCS-0", 124,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				344		/* check-rule basecs::TypeParameterCS.ownedExtends : TypedRefCS */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				150		/* assign V0 = (|TypeParameterCS::ownedExtends| > 0) */,
				204		/* assign V1 = (|TypeParameterCS::ownedExtends| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				195		/* 'extends' || soft-space value soft-space */,
				59		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */,
				260		/* V01*2-steps || value */,
				163		/* '&&' || soft-space value soft-space */,
				59		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::UnreservedPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=NextPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[15] = createSerializationRule("UnreservedPathNameCS-0", 138,
			createSerializationMatchSteps(
				332		/* check-rule basecs::PathNameCS.ownedPathElements : NextPathElementCS */,
				142		/* assign V0 = (|PathNameCS::ownedPathElements| - 1) */
			),
			createSerializationSteps(
				326		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */,
				248		/* V00*2-steps || value */,
				174		/* '::' || no-space value no-space */,
				326		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 21/* NextPathElementCS */,
					(66/*NextPathElementCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::WildcardTypeRefCS-0(basecs::WildcardTypeRefCS): { "?" { "extends" ownedExtends=TypedRefCS }[?] }
		serializationRules[16] = createSerializationRule("WildcardTypeRefCS-0", 145,
			createSerializationMatchSteps(
				132		/* assert |WildcardTypeRefCS::ownedSuper| == 0 */,
				349		/* check-rule basecs::WildcardTypeRefCS.ownedExtends : TypedRefCS */,
				189		/* assign V0 = |WildcardTypeRefCS::ownedExtends| */
			),
			createSerializationSteps(
				178		/* '?' || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				195		/* 'extends' || soft-space value soft-space */,
				60		/* WildcardTypeRefCS::ownedExtends=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::BooleanLiteralExpCS-0(essentialoclcs::BooleanLiteralExpCS): symbol={'false|true'}
		serializationRules[17] = createSerializationRule("BooleanLiteralExpCS-0", 3,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				1		/* assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0 */
			),
			createSerializationSteps(
				155		/* BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, false,
					(15/*'false|true'*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CoIteratorVariableCS-0(essentialoclcs::VariableCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] }
		serializationRules[18] = createSerializationRule("CoIteratorVariableCS-0", 5,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				131		/* assert |VariableCS::ownedInitExpression| == 0 */,
				401		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				188		/* assign V0 = |VariableCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				135		/* VariableCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralExpCS-0(essentialoclcs::CollectionLiteralExpCS): { ownedType=CollectionTypeCS "{" { ownedParts+=CollectionLiteralPartCS { "," ownedParts+=CollectionLiteralPartCS }[*] }[?] "}" }
		serializationRules[19] = createSerializationRule("CollectionLiteralExpCS-0", 6,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				354		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : CollectionLiteralPartCS */,
				355		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : CollectionTypeCS */,
				2		/* assert (|CollectionLiteralExpCS::ownedType| - 1) == 0 */,
				133		/* assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0) */,
				190		/* assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				128		/* CollectionLiteralExpCS::ownedType=CollectionTypeCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				250		/* V00*4-steps || value */,
				90		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				90		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 1/* CollectionLiteralPartCS */,
					(7/*CollectionLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-0(essentialoclcs::CollectionLiteralPartCS): { ownedExpression=ExpCS { ".." ownedLastExpression=ExpCS }[?] }
		serializationRules[20] = createSerializationRule("CollectionLiteralPartCS-0", 7,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				356		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				358		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				154		/* assign V0 = |CollectionLiteralPartCS::ownedLastExpression| */,
				3		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				51		/* CollectionLiteralPartCS::ownedExpression=ExpCS || value */,
				247		/* V00*2-steps || value */,
				171		/* '..' || no-space value no-space */,
				74		/* CollectionLiteralPartCS::ownedLastExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-1(essentialoclcs::CollectionLiteralPartCS): ownedExpression=PatternExpCS
		serializationRules[21] = createSerializationRule("CollectionLiteralPartCS-1", 7,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				76		/* assert |CollectionLiteralPartCS::ownedLastExpression| == 0 */,
				357		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : PatternExpCS */,
				3		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				52		/* CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 27/* PatternExpCS */,
					(74/*PatternExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionPatternCS-0(essentialoclcs::CollectionPatternCS): { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" }
		serializationRules[22] = createSerializationRule("CollectionPatternCS-0", 8,
			createSerializationMatchSteps(
				128		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				77		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				359		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				360		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				155		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				191		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				4		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				129		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				253		/* V00*6-steps || value */,
				91		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				91		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				168		/* '++' || soft-space value soft-space */,
				152		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 27/* PatternExpCS */,
					(74/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionTypeCS-0(essentialoclcs::CollectionTypeCS): { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] }
		serializationRules[23] = createSerializationRule("CollectionTypeCS-0", 10,
			createSerializationMatchSteps(
				128		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				361		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				362		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				156		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				208		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				27		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				130		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				256		/* V01*1-steps || value */,
				40		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				166		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(119/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CurlyBracketedClauseCS-0(essentialoclcs::CurlyBracketedClauseCS): { "{" { ownedParts+=ShadowPartCS { "," ownedParts+=ShadowPartCS }[*] }[?] "}" }
		serializationRules[24] = createSerializationRule("CurlyBracketedClauseCS-0", 13,
			createSerializationMatchSteps(
				78		/* assert |CurlyBracketedClauseCS::value| == 0 */,
				364		/* check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : ShadowPartCS */,
				134		/* assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0) */,
				193		/* assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				231		/* '{' || soft-space value push soft-new-line */,
				250		/* V00*4-steps || value */,
				92		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				92		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 41/* ShadowPartCS */,
					(98/*ShadowPartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::ElseIfThenExpCS-0(essentialoclcs::IfThenExpCS): { "elseif" ownedCondition=ExpCS "then" ownedThenExpression=ExpCS }
		serializationRules[25] = createSerializationRule("ElseIfThenExpCS-0", 22,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				370		/* check-rule essentialoclcs::IfThenExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				371		/* check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				19		/* assert (|IfThenExpCS::ownedThenExpression| - 1) == 0 */,
				18		/* assert (|IfThenExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				192		/* 'elseif' || soft-new-line pop soft-space value push soft-space */,
				42		/* IfThenExpCS::ownedCondition=ExpCS || value */,
				220		/* 'then' || pop value push soft-space */,
				126		/* IfThenExpCS::ownedThenExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::ExpCS-18(essentialoclcs::InfixExpCS): { ownedLeft=PrefixedPrimaryExpCS { name=BinaryOperatorName ownedRight=ExpCS } }
		serializationRules[26] = createSerializationRule("ExpCS-18", 32,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				372		/* check-rule essentialoclcs::InfixExpCS.ownedLeft : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				388		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				47		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				21		/* assert (|InfixExpCS::ownedLeft| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				75		/* InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value */,
				320		/* NamedElementCS::name=BinaryOperatorName || soft-space value soft-space */,
				327		/* OperatorExpCS::ownedRight=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 32/* PrefixedPrimaryExpCS */,
					(77/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::IfExpCS-0(essentialoclcs::IfExpCS): { "if" ownedCondition=(ExpCS|PatternExpCS) "then" ownedThenExpression=ExpCS ownedIfThenExpressions+=ElseIfThenExpCS[*] "else" ownedElseExpression=ExpCS "endif" }
		serializationRules[27] = createSerializationRule("IfExpCS-0", 38,
			createSerializationMatchSteps(
				88		/* assert |IfExpCS::isImplicit| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				366		/* check-rule essentialoclcs::IfExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				367		/* check-rule essentialoclcs::IfExpCS.ownedElseExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				368		/* check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : ElseIfThenExpCS */,
				369		/* check-rule essentialoclcs::IfExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				16		/* assert (|IfExpCS::ownedElseExpression| - 1) == 0 */,
				160		/* assign V0 = |IfExpCS::ownedIfThenExpressions| */,
				17		/* assert (|IfExpCS::ownedThenExpression| - 1) == 0 */,
				15		/* assert (|IfExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				196		/* 'if' || soft-new-line value push soft-space */,
				41		/* IfExpCS::ownedCondition=ExpCS|PatternExpCS || value */,
				221		/* 'then' || pop soft-space value push soft-space */,
				125		/* IfExpCS::ownedThenExpression=ExpCS || value */,
				243		/* V00*1-steps || value */,
				62		/* IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value */,
				191		/* 'else' || soft-new-line pop value push soft-space */,
				49		/* IfExpCS::ownedElseExpression=ExpCS || value */,
				193		/* 'endif' || soft-new-line pop value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 28/* ExpCS,PatternExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/,
					(74/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 7/* ElseIfThenExpCS */,
					(22/*ElseIfThenExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::InvalidLiteralExpCS-0(essentialoclcs::InvalidLiteralExpCS): "invalid"
		serializationRules[28] = createSerializationRule("InvalidLiteralExpCS-0", 40,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				202		/* 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::LambdaLiteralExpCS-0(essentialoclcs::LambdaLiteralExpCS): { "Lambda" "{" ownedExpressionCS=ExpCS "}" }
		serializationRules[29] = createSerializationRule("LambdaLiteralExpCS-0", 44,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				373		/* check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				26		/* assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				179		/* 'Lambda' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				58		/* LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::LetExpCS-0(essentialoclcs::LetExpCS): { "let" ownedVariables+=LetVariableCS { "," ownedVariables+=LetVariableCS }[*] "in" ownedInExpression=ExpCS }
		serializationRules[30] = createSerializationRule("LetExpCS-0", 45,
			createSerializationMatchSteps(
				92		/* assert |LetExpCS::isImplicit| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				374		/* check-rule essentialoclcs::LetExpCS.ownedInExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				375		/* check-rule essentialoclcs::LetExpCS.ownedVariables : LetVariableCS */,
				27		/* assert (|LetExpCS::ownedInExpression| - 1) == 0 */,
				138		/* assign V0 = (|LetExpCS::ownedVariables| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				205		/* 'let' || soft-space value push */,
				140		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				140		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				200		/* 'in' || soft-space pop value soft-new-line */,
				64		/* LetExpCS::ownedInExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 13/* LetVariableCS */,
					(46/*LetVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::LetVariableCS-0(essentialoclcs::LetVariableCS): { name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS[?] { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[31] = createSerializationRule("LetVariableCS-0", 46,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				400		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				376		/* check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				401		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				73		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				225		/* assign V1 = |VariableCS::ownedType| */,
				163		/* assign V0 = |LetVariableCS::ownedRoundBracketedClause| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				115		/* LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				135		/* VariableCS::ownedType=TypeExpCS || value */,
				177		/* '=' || soft-space value soft-space */,
				70		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 39/* RoundBracketedClauseCS */,
					(91/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::MapLiteralExpCS-0(essentialoclcs::MapLiteralExpCS): { ownedType=MapTypeCS "{" { ownedParts+=MapLiteralPartCS { "," ownedParts+=MapLiteralPartCS }[*] }[?] "}" }
		serializationRules[32] = createSerializationRule("MapLiteralExpCS-0", 49,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				377		/* check-rule essentialoclcs::MapLiteralExpCS.ownedParts : MapLiteralPartCS */,
				378		/* check-rule essentialoclcs::MapLiteralExpCS.ownedType : MapTypeCS */,
				28		/* assert (|MapLiteralExpCS::ownedType| - 1) == 0 */,
				139		/* assign V0 = (|MapLiteralExpCS::ownedParts| > 0) */,
				195		/* assign V1 = (|MapLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				131		/* MapLiteralExpCS::ownedType=MapTypeCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				250		/* V00*4-steps || value */,
				93		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				93		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 14/* MapLiteralPartCS */,
					(50/*MapLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 15/* MapTypeCS */,
					(51/*MapTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapLiteralPartCS-0(essentialoclcs::MapLiteralPartCS): { ownedKey=ExpCS {"with"|"<-"} ownedValue=ExpCS }
		serializationRules[33] = createSerializationRule("MapLiteralPartCS-0", 50,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				379		/* check-rule essentialoclcs::MapLiteralPartCS.ownedKey : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				380		/* check-rule essentialoclcs::MapLiteralPartCS.ownedValue : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				30		/* assert (|MapLiteralPartCS::ownedValue| - 1) == 0 */,
				29		/* assert (|MapLiteralPartCS::ownedKey| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				71		/* MapLiteralPartCS::ownedKey=ExpCS || value */,
				226		/* 'with' || value */,
				136		/* MapLiteralPartCS::ownedValue=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapTypeCS-0(essentialoclcs::MapTypeCS): { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] }
		serializationRules[34] = createSerializationRule("MapTypeCS-0", 51,
			createSerializationMatchSteps(
				128		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				381		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				382		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				164		/* assign V0 = |MapTypeCS::ownedValueType| */,
				32		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				31		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				28		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				73		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				170		/* ',' || no-space value soft-space */,
				137		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				166		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(9/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::Model-0(essentialoclcs::ContextCS): ownedExpression=ExpCS
		serializationRules[35] = createSerializationRule("Model-0", 52,
			createSerializationMatchSteps(
				95		/* assert |NamedElementCS::name| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				111		/* assert |RootCS::ownedImports| == 0 */,
				363		/* check-rule essentialoclcs::ContextCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				6		/* assert (|ContextCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				53		/* ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NameExpCS-0(essentialoclcs::NameExpCS): { ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS[*] ownedRoundBracketedClause=RoundBracketedClauseCS[?] ownedCurlyBracketedClause=CurlyBracketedClauseCS[?] { isPre?="@" "pre" }[?] }
		serializationRules[36] = createSerializationRule("NameExpCS-0", 58,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				350		/* check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				351		/* check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : PathNameCS */,
				352		/* check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				353		/* check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : SquareBracketedClauseCS */,
				266		/* assign V3 = |AbstractNameExpCS::isPre.'@'| */,
				240		/* assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause| */,
				206		/* assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause| */,
				152		/* assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses| */,
				0		/* assert (|AbstractNameExpCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				96		/* AbstractNameExpCS::ownedPathName=PathNameCS || value */,
				243		/* V00*1-steps || value */,
				117		/* AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value */,
				256		/* V01*1-steps || value */,
				114		/* AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				266		/* V02*1-steps || value */,
				44		/* AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				280		/* V03*2-steps || value */,
				16		/* AbstractNameExpCS::isPre?='@' || soft-space value soft-space */,
				212		/* 'pre' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, false,
					(8/*'@'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 39/* RoundBracketedClauseCS */,
					(91/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 45/* SquareBracketedClauseCS */,
					(102/*SquareBracketedClauseCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-0(essentialoclcs::NavigatingArgCS): { ":" ownedType=TypeExpCS }
		serializationRules[37] = createSerializationRule("NavigatingArgCS-0", 59,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				97		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				98		/* assert |NavigatingArgCS::ownedNameExpression| == 0 */,
				100		/* assert |NavigatingArgCS::prefix| == 0 */,
				386		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				41		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				172		/* ':' || soft-space value soft-space */,
				132		/* NavigatingArgCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-1(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[38] = createSerializationRule("NavigatingArgCS-1", 59,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				100		/* assert |NavigatingArgCS::prefix| == 0 */,
				383		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				213		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				168		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				41		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				172		/* ':' || soft-space value soft-space */,
				132		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				247		/* V00*2-steps || value */,
				226		/* 'with' || value */,
				39		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				259		/* V01*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-2(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[39] = createSerializationRule("NavigatingArgCS-2", 59,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				100		/* assert |NavigatingArgCS::prefix| == 0 */,
				383		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				39		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				212		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				170		/* assign V0 = |NavigatingArgCS::ownedType| */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				247		/* V00*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				132		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				259		/* V01*2-steps || value */,
				226		/* 'with' || value */,
				39		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				199		/* 'in' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-3(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[40] = createSerializationRule("NavigatingArgCS-3", 59,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				99		/* assert |NavigatingArgCS::ownedType| == 0 */,
				100		/* assert |NavigatingArgCS::prefix| == 0 */,
				383		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				169		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				38		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				226		/* 'with' || value */,
				39		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				247		/* V00*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-4(essentialoclcs::NavigatingArgCS): ownedNameExpression=NavigatingArgExpCS
		serializationRules[41] = createSerializationRule("NavigatingArgCS-4", 59,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				97		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				99		/* assert |NavigatingArgCS::ownedType| == 0 */,
				100		/* assert |NavigatingArgCS::prefix| == 0 */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				82		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingBarArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="|" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[42] = createSerializationRule("NavigatingBarArgCS-0", 61,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				170		/* assign V0 = |NavigatingArgCS::ownedType| */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				44		/* assert (|NavigatingArgCS::prefix.'|'| - 1) == 0 */,
				213		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				144		/* NavigatingArgCS::prefix='|' || soft-space value soft-space */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				251		/* V00*5-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				132		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				259		/* V01*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(25/*'|'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[43] = createSerializationRule("NavigatingCommaArgCS-0", 62,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				213		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				168		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				41		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				42		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				146		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				172		/* ':' || soft-space value soft-space */,
				132		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				247		/* V00*2-steps || value */,
				226		/* 'with' || value */,
				39		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				259		/* V01*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-1(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[44] = createSerializationRule("NavigatingCommaArgCS-1", 62,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				39		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				212		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				170		/* assign V0 = |NavigatingArgCS::ownedType| */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				42		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				146		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				247		/* V00*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				132		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				259		/* V01*2-steps || value */,
				226		/* 'with' || value */,
				39		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				199		/* 'in' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-2(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[45] = createSerializationRule("NavigatingCommaArgCS-2", 62,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				99		/* assert |NavigatingArgCS::ownedType| == 0 */,
				383		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				169		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				38		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				42		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				146		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				226		/* 'with' || value */,
				39		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				247		/* V00*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-3(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS }
		serializationRules[46] = createSerializationRule("NavigatingCommaArgCS-3", 62,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				97		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				99		/* assert |NavigatingArgCS::ownedType| == 0 */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				42		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				146		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingSemiArgCS-0(essentialoclcs::NavigatingArgCS): { prefix=";" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[47] = createSerializationRule("NavigatingSemiArgCS-0", 63,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				384		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				170		/* assign V0 = |NavigatingArgCS::ownedType| */,
				40		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				43		/* assert (|NavigatingArgCS::prefix.';'| - 1) == 0 */,
				213		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				145		/* NavigatingArgCS::prefix=';' || no-space value soft-new-line */,
				81		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				251		/* V00*5-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				132		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				259		/* V01*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				66		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(7/*';'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 18/* NavigatingArgExpCS */,
					(60/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NestedExpCS-0(essentialoclcs::NestedExpCS): { "(" ownedExpression=ExpCS ")" }
		serializationRules[48] = createSerializationRule("NestedExpCS-0", 65,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				387		/* check-rule essentialoclcs::NestedExpCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				45		/* assert (|NestedExpCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				164		/* '(' || value no-space */,
				55		/* NestedExpCS::ownedExpression=ExpCS || value */,
				166		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NullLiteralExpCS-0(essentialoclcs::NullLiteralExpCS): "null"
		serializationRules[49] = createSerializationRule("NullLiteralExpCS-0", 67,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				207		/* 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::NumberLiteralExpCS-0(essentialoclcs::NumberLiteralExpCS): symbol=NUMBER_LITERAL
		serializationRules[50] = createSerializationRule("NumberLiteralExpCS-0", 68,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				46		/* assert (|NumberLiteralExpCS::symbol| - 1) == 0 */
			),
			createSerializationSteps(
				156		/* NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::PatternExpCS-0(essentialoclcs::PatternExpCS): { patternVariableName=UnrestrictedName[?] ":" ownedPatternType=TypeExpCS }
		serializationRules[51] = createSerializationRule("PatternExpCS-0", 74,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				391		/* check-rule essentialoclcs::PatternExpCS.ownedPatternType : TypeExpCS */,
				50		/* assert (|PatternExpCS::ownedPatternType| - 1) == 0 */,
				172		/* assign V0 = |PatternExpCS::patternVariableName| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				143		/* PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				104		/* PatternExpCS::ownedPatternType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedLetExpCS-1(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedLetExpCS }
		serializationRules[52] = createSerializationRule("PrefixedLetExpCS-1", 76,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				390		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : LetExpCS|PrefixedLetExpCS */,
				47		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				318		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				328		/* OperatorExpCS::ownedRight=PrefixedLetExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 30/* PrefixedLetExpCS */,
					(76/*PrefixedLetExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedPrimaryExpCS-15(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS }
		serializationRules[53] = createSerializationRule("PrefixedPrimaryExpCS-15", 77,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				389		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				47		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				318		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				329		/* OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 32/* PrefixedPrimaryExpCS */,
					(77/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrimitiveTypeCS-0(basecs::PrimitiveTypeRefCS): name=PrimitiveTypeIdentifier
		serializationRules[54] = createSerializationRule("PrimitiveTypeCS-0", 80,
			createSerializationMatchSteps(
				128		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				52		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				30		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::RoundBracketedClauseCS-0(essentialoclcs::RoundBracketedClauseCS): { "(" { ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[*] }[?] ")" }
		serializationRules[55] = createSerializationRule("RoundBracketedClauseCS-0", 91,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				165		/* '(' || no-space value no-space */,
				249		/* V00*3-steps || value */,
				322		/* RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value */,
				257		/* V01*1-steps || value */,
				323		/* RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value */,
				166		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 20/* NavigatingArgCS,NavigatingBarArgCS,NavigatingCommaArgCS,NavigatingSemiArgCS */,
					(59/*NavigatingArgCS*/ << 4) | 1 /*[?]*/,
					(61/*NavigatingBarArgCS*/ << 4) | 2 /*[*]*/,
					(62/*NavigatingCommaArgCS*/ << 4) | 2 /*[*]*/,
					(63/*NavigatingSemiArgCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::SelfExpCS-0(essentialoclcs::SelfExpCS): "self"
		serializationRules[56] = createSerializationRule("SelfExpCS-0", 97,
			createSerializationMatchSteps(
				112		/* assert |SelfExpCS::name| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				218		/* 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::ShadowPartCS-0(essentialoclcs::ShadowPartCS): { referredProperty=UnrestrictedName "=" ownedInitExpression=(ExpCS|PatternExpCS) }
		serializationRules[57] = createSerializationRule("ShadowPartCS-0", 98,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				393		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				57		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */,
				58		/* assert (|ShadowPartCS::referredProperty| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space */,
				177		/* '=' || soft-space value soft-space */,
				67		/* ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 28/* ExpCS,PatternExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/,
					(74/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, -1
				)
			});
		// EssentialOCL::ShadowPartCS-1(essentialoclcs::ShadowPartCS): ownedInitExpression=StringLiteralExpCS
		serializationRules[58] = createSerializationRule("ShadowPartCS-1", 98,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				113		/* assert |ShadowPartCS::referredProperty| == 0 */,
				392		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : StringLiteralExpCS */,
				57		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */
			),
			createSerializationSteps(
				68		/* ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 46/* StringLiteralExpCS */,
					(104/*StringLiteralExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SimplePathNameCS-0(basecs::PathNameCS): ownedPathElements+=FirstPathElementCS
		serializationRules[59] = createSerializationRule("SimplePathNameCS-0", 99,
			createSerializationMatchSteps(
				331		/* check-rule basecs::PathNameCS.ownedPathElements : FirstPathElementCS */,
				49		/* assert (|PathNameCS::ownedPathElements| - 1) == 0 */
			),
			createSerializationSteps(
				325		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 11/* FirstPathElementCS */,
					(34/*FirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SquareBracketedClauseCS-0(essentialoclcs::SquareBracketedClauseCS): { "[" ownedTerms+=ExpCS { "," ownedTerms+=ExpCS }[*] "]" }
		serializationRules[60] = createSerializationRule("SquareBracketedClauseCS-0", 102,
			createSerializationMatchSteps(
				394		/* check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				145		/* assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1) */
			),
			createSerializationSteps(
				181		/* '[' || no-space value no-space */,
				124		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				124		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				182		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::StringLiteralExpCS-0(essentialoclcs::StringLiteralExpCS): segments+=StringLiteral[+]
		serializationRules[61] = createSerializationRule("StringLiteralExpCS-0", 104,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				179		/* assign V0 = |StringLiteralExpCS::segments| */
			),
			createSerializationSteps(
				245		/* V00*1-steps || value */,
				153		/* StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, false, GrammarCardinality.ONE_OR_MORE)
			});
		// EssentialOCL::TupleLiteralExpCS-0(essentialoclcs::TupleLiteralExpCS): { "Tuple" "{" ownedParts+=TupleLiteralPartCS { "," ownedParts+=TupleLiteralPartCS }[*] "}" }
		serializationRules[62] = createSerializationRule("TupleLiteralExpCS-0", 114,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				395		/* check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : TupleLiteralPartCS */,
				148		/* assign V0 = (|TupleLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				180		/* 'Tuple' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				94		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				248		/* V00*2-steps || value */,
				169		/* ',' || no-space value soft-new-line */,
				94		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 58/* TupleLiteralPartCS */,
					(115/*TupleLiteralPartCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::TupleLiteralPartCS-0(essentialoclcs::TupleLiteralPartCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[63] = createSerializationRule("TupleLiteralPartCS-0", 115,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				400		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				401		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				73		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				188		/* assign V0 = |VariableCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				135		/* VariableCS::ownedType=TypeExpCS || value */,
				177		/* '=' || soft-space value soft-space */,
				70		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
	}
	private void initSerializationRules1() {
		// EssentialOCL::TuplePartCS-0(basecs::TuplePartCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[64] = createSerializationRule("TuplePartCS-0", 116,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				127		/* assert |TypedElementCS::qualifiers| == 0 */,
				345		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				69		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				333		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TupleTypeCS-0(basecs::TupleTypeCS): { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] }
		serializationRules[65] = createSerializationRule("TupleTypeCS-0", 117,
			createSerializationMatchSteps(
				128		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				343		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				66		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				149		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				203		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				237		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				31		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				254		/* V00*7-steps || value */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				95		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				95		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				166		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(10/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/* TuplePartCS */,
					(116/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeExpCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[66] = createSerializationRule("TypeExpCS-0", 118,
			createSerializationMatchSteps(
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				187		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				52		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				30		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[67] = createSerializationRule("TypeExpCS-1", 118,
			createSerializationMatchSteps(
				361		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				362		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				252		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				156		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				208		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				27		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				130		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				256		/* V01*1-steps || value */,
				40		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				166		/* ')' || no-space value */,
				266		/* V02*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(119/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[68] = createSerializationRule("TypeExpCS-2", 118,
			createSerializationMatchSteps(
				381		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				382		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				223		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				164		/* assign V0 = |MapTypeCS::ownedValueType| */,
				32		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				31		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				28		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				73		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				170		/* ',' || no-space value soft-space */,
				137		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				166		/* ')' || no-space value */,
				256		/* V01*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(9/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-3(essentialoclcs::TypeNameExpCS): { { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[69] = createSerializationRule("TypeExpCS-3", 118,
			createSerializationMatchSteps(
				397		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				398		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				399		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				252		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				183		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				68		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				221		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				101		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				251		/* V00*5-steps || value */,
				45		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				261		/* V01*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				103		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				266		/* V02*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-4(essentialoclcs::CollectionPatternCS): { { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[70] = createSerializationRule("TypeExpCS-4", 118,
			createSerializationMatchSteps(
				77		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				359		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				360		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				252		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				155		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				191		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				4		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				129		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				253		/* V00*6-steps || value */,
				91		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				91		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				168		/* '++' || soft-space value soft-space */,
				152		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				266		/* V02*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 27/* PatternExpCS */,
					(74/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeExpCS-5(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[71] = createSerializationRule("TypeExpCS-5", 118,
			createSerializationMatchSteps(
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				343		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				275		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				66		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				149		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				203		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				237		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				31		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				254		/* V00*7-steps || value */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				95		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				95		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				166		/* ')' || no-space value */,
				276		/* V03*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(10/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/* TuplePartCS */,
					(116/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeLiteralExpCS-0(essentialoclcs::TypeLiteralExpCS): ownedType=TypeLiteralWithMultiplicityCS
		serializationRules[72] = createSerializationRule("TypeLiteralExpCS-0", 121,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				125		/* assert |TypeLiteralExpCS::ownedPathName| == 0 */,
				396		/* check-rule essentialoclcs::TypeLiteralExpCS.ownedType : TypeLiteralWithMultiplicityCS */,
				67		/* assert (|TypeLiteralExpCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				133		/* TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 63/* TypeLiteralWithMultiplicityCS */,
					(122/*TypeLiteralWithMultiplicityCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[73] = createSerializationRule("TypeLiteralWithMultiplicityCS-0", 122,
			createSerializationMatchSteps(
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				187		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				52		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				30		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[74] = createSerializationRule("TypeLiteralWithMultiplicityCS-1", 122,
			createSerializationMatchSteps(
				361		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				362		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				252		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				156		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				208		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				27		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				130		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				256		/* V01*1-steps || value */,
				40		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				166		/* ')' || no-space value */,
				266		/* V02*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(119/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[75] = createSerializationRule("TypeLiteralWithMultiplicityCS-2", 122,
			createSerializationMatchSteps(
				381		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				382		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				223		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				164		/* assign V0 = |MapTypeCS::ownedValueType| */,
				32		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				31		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				28		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				73		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				170		/* ',' || no-space value soft-space */,
				137		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				166		/* ')' || no-space value */,
				256		/* V01*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(9/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-3(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[76] = createSerializationRule("TypeLiteralWithMultiplicityCS-3", 122,
			createSerializationMatchSteps(
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				343		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				275		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				66		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				149		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				203		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				237		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				31		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				254		/* V00*7-steps || value */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				95		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				95		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				166		/* ')' || no-space value */,
				276		/* V03*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(10/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/* TuplePartCS */,
					(116/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeNameExpCS-0(essentialoclcs::TypeNameExpCS): { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] }
		serializationRules[77] = createSerializationRule("TypeNameExpCS-0", 123,
			createSerializationMatchSteps(
				128		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				397		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				398		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				399		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				183		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				68		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				221		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				101		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				251		/* V00*5-steps || value */,
				45		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				261		/* V01*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				103		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::URIFirstPathElementCS-0(basecs::PathElementWithURICS): referredElement=URI
		serializationRules[78] = createSerializationRule("URIFirstPathElementCS-0", 132,
			createSerializationMatchSteps(
				48		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				341		/* PathElementCS::referredElement=URI || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIFirstPathElementCS-1(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[79] = createSerializationRule("URIFirstPathElementCS-1", 132,
			createSerializationMatchSteps(
				48		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				343		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=URIFirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[80] = createSerializationRule("URIPathNameCS-0", 133,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				324		/* PathNameCS::ownedPathElements+=URIFirstPathElementCS || value */,
				248		/* V00*2-steps || value */,
				174		/* '::' || no-space value no-space */,
				326		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 69/* NextPathElementCS,URIFirstPathElementCS */,
					(66/*NextPathElementCS*/ << 4) | 2 /*[*]*/,
					(132/*URIFirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::UnlimitedNaturalLiteralExpCS-0(essentialoclcs::UnlimitedNaturalLiteralExpCS): "*"
		serializationRules[81] = createSerializationRule("UnlimitedNaturalLiteralExpCS-0", 136,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				167		/* '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// QVTbase::AttributeCS-0(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[82] = createSerializationRule("AttributeCS-0", 1,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				118		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V2 = |StructuralFeatureCS::default| */,
				222		/* assign V1 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				186		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				70		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				264		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				290		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				183		/* 'attribute' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				283		/* V03*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 0 /*[1]*/,
					(21/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-1(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[83] = createSerializationRule("AttributeCS-1", 1,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				334		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V2 = |StructuralFeatureCS::default| */,
				222		/* assign V1 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				186		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				70		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				264		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				290		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				298		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				303		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				312		/* assign V7 = 0 */,
				317		/* assign V8 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				183		/* 'attribute' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				283		/* V03*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				300		/* V05*5-steps || value */,
				189		/* 'derivation' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				301		/* V06*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				310		/* V07*5-steps || value */,
				201		/* 'initial' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				311		/* V08*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 0 /*[1]*/,
					(21/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-2(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[84] = createSerializationRule("AttributeCS-2", 1,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				118		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V2 = |StructuralFeatureCS::default| */,
				222		/* assign V1 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				185		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				71		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				264		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				290		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				183		/* 'attribute' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				283		/* V03*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 1 /*[?]*/,
					(21/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-3(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[85] = createSerializationRule("AttributeCS-3", 1,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				334		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V2 = |StructuralFeatureCS::default| */,
				222		/* assign V1 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				185		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				71		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				264		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				290		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				298		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				303		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				312		/* assign V7 = 0 */,
				317		/* assign V8 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				183		/* 'attribute' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				283		/* V03*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				300		/* V05*5-steps || value */,
				189		/* 'derivation' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				301		/* V06*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				310		/* V07*5-steps || value */,
				201		/* 'initial' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				311		/* V08*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 1 /*[?]*/,
					(21/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-4(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[86] = createSerializationRule("AttributeCS-4", 1,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				118		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				218		/* assign V1 = |StructuralFeatureCS::default| */,
				184		/* assign V0 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				238		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				274		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				183		/* 'attribute' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				259		/* V01*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				273		/* V02*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				278		/* V03*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-5(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[87] = createSerializationRule("AttributeCS-5", 1,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				334		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				218		/* assign V1 = |StructuralFeatureCS::default| */,
				184		/* assign V0 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				238		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				274		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				286		/* assign V4 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				295		/* assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				305		/* assign V6 = 0 */,
				312		/* assign V7 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				183		/* 'attribute' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				259		/* V01*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				273		/* V02*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				278		/* V03*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				293		/* V04*5-steps || value */,
				189		/* 'derivation' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				294		/* V05*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				305		/* V06*5-steps || value */,
				201		/* 'initial' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				306		/* V07*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::CompoundTargetElementCS-0(qvtbasecs::CompoundTargetElementCS): { "{" ownedTargetElements+=SimpleTargetElementCS[*] "}" }
		serializationRules[88] = createSerializationRule("CompoundTargetElementCS-0", 12,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				404		/* check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : SimpleTargetElementCS */,
				157		/* assign V0 = |CompoundTargetElementCS::ownedTargetElements| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				231		/* '{' || soft-space value push soft-new-line */,
				243		/* V00*1-steps || value */,
				120		/* CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 42/* SimpleTargetElementCS */,
					(100/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::DataTypeCS-0(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[89] = createSerializationRule("DataTypeCS-0", 15,
			createSerializationMatchSteps(
				79		/* assert |DataTypeCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				241		/* assign V2 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				158		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				265		/* assign V3 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				186		/* 'datatype' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				282		/* V03*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				161		/* '!serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(19/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-1(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" "}" } }
		serializationRules[90] = createSerializationRule("DataTypeCS-1", 15,
			createSerializationMatchSteps(
				79		/* assert |DataTypeCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				241		/* assign V2 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				158		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				265		/* assign V3 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				186		/* 'datatype' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				282		/* V03*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				161		/* '!serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(19/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-2(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[91] = createSerializationRule("DataTypeCS-2", 15,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				267		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				241		/* assign V2 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				158		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				186		/* 'datatype' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				282		/* V03*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				18		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(19/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(20/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-3(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" "}" } }
		serializationRules[92] = createSerializationRule("DataTypeCS-3", 15,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				267		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				241		/* assign V2 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				158		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				186		/* 'datatype' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				282		/* V03*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				18		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(19/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(20/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-4(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[93] = createSerializationRule("DataTypeCS-4", 15,
			createSerializationMatchSteps(
				79		/* assert |DataTypeCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				241		/* assign V2 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				158		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				265		/* assign V3 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				186		/* 'datatype' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*2-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(19/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-5(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" "}" } }
		serializationRules[94] = createSerializationRule("DataTypeCS-5", 15,
			createSerializationMatchSteps(
				79		/* assert |DataTypeCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				241		/* assign V2 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				158		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				265		/* assign V3 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				186		/* 'datatype' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*2-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(19/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-0(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[95] = createSerializationRule("EnumerationCS-0", 23,
			createSerializationMatchSteps(
				84		/* assert |EnumerationCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				85		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				207		/* assign V1 = |ClassCS::instanceClassName| */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				239		/* assign V2 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'enum' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				272		/* V02*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				161		/* '!serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-1(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[96] = createSerializationRule("EnumerationCS-1", 23,
			createSerializationMatchSteps(
				84		/* assert |EnumerationCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				324		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				268		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				207		/* assign V1 = |ClassCS::instanceClassName| */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				239		/* assign V2 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'enum' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				272		/* V02*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				161		/* '!serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				277		/* V03*1-steps || value */,
				76		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 8/* EnumerationLiteralCS */,
					(24/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-2(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[97] = createSerializationRule("EnumerationCS-2", 23,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				85		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				244		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				207		/* assign V1 = |ClassCS::instanceClassName| */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'enum' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				272		/* V02*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				19		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(20/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-3(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[98] = createSerializationRule("EnumerationCS-3", 23,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				324		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				268		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				244		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				207		/* assign V1 = |ClassCS::instanceClassName| */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'enum' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				272		/* V02*3-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				19		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				277		/* V03*1-steps || value */,
				76		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(20/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 8/* EnumerationLiteralCS */,
					(24/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-4(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[99] = createSerializationRule("EnumerationCS-4", 23,
			createSerializationMatchSteps(
				84		/* assert |EnumerationCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				85		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				207		/* assign V1 = |ClassCS::instanceClassName| */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				239		/* assign V2 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'enum' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-5(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[100] = createSerializationRule("EnumerationCS-5", 23,
			createSerializationMatchSteps(
				84		/* assert |EnumerationCS::isSerializable| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				324		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				268		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				207		/* assign V1 = |ClassCS::instanceClassName| */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				239		/* assign V2 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'enum' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				277		/* V03*1-steps || value */,
				76		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 8/* EnumerationLiteralCS */,
					(24/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationLiteralCS-0(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] ";" }
		serializationRules[101] = createSerializationRule("EnumerationLiteralCS-0", 24,
			createSerializationMatchSteps(
				86		/* assert |EnumerationLiteralCS::literal| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				159		/* assign V0 = |EnumerationLiteralCS::value| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				206		/* 'literal' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				159		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-1(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[102] = createSerializationRule("EnumerationLiteralCS-1", 24,
			createSerializationMatchSteps(
				86		/* assert |EnumerationLiteralCS::literal| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				159		/* assign V0 = |EnumerationLiteralCS::value| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				206		/* 'literal' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				159		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-2(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] ";" }
		serializationRules[103] = createSerializationRule("EnumerationLiteralCS-2", 24,
			createSerializationMatchSteps(
				86		/* assert |EnumerationLiteralCS::literal| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				159		/* assign V0 = |EnumerationLiteralCS::value| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				321		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				159		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-3(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[104] = createSerializationRule("EnumerationLiteralCS-3", 24,
			createSerializationMatchSteps(
				86		/* assert |EnumerationLiteralCS::literal| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				159		/* assign V0 = |EnumerationLiteralCS::value| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				321		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				159		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::OperationCS-0(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[105] = createSerializationRule("OperationCS-0", 70,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				102		/* assert |OperationCS::ownedPostconditions| == 0 */,
				103		/* assert |OperationCS::ownedPreconditions| == 0 */,
				327		/* check-rule basecs::OperationCS.ownedExceptions : TypedRefCS */,
				328		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				288		/* assign V4 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				186		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				70		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				294		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				302		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				232		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				260		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				311		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				320		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				208		/* 'operation' || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				273		/* V02*4-steps || value */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				166		/* ')' || no-space value */,
				288		/* V04*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				299		/* V05*5-steps || value */,
				222		/* 'throws' || soft-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				303		/* V06*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				309		/* V07*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				313		/* V08*1-steps || value */,
				337		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 0 /*[1]*/,
					(21/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(72/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-1(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[106] = createSerializationRule("OperationCS-1", 70,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				102		/* assert |OperationCS::ownedPostconditions| == 0 */,
				103		/* assert |OperationCS::ownedPreconditions| == 0 */,
				326		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				327		/* check-rule basecs::OperationCS.ownedExceptions : TypedRefCS */,
				328		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				288		/* assign V4 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				186		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				70		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				321		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				226		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				294		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				302		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				232		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				260		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				311		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				320		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				208		/* 'operation' || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				273		/* V02*4-steps || value */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				166		/* ')' || no-space value */,
				288		/* V04*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				299		/* V05*5-steps || value */,
				222		/* 'throws' || soft-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				303		/* V06*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				309		/* V07*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				313		/* V08*1-steps || value */,
				337		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				316		/* V09*5-steps || value */,
				184		/* 'body' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				265		/* V10*1-steps || value */,
				37		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 0 /*[1]*/,
					(21/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(72/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-2(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[107] = createSerializationRule("OperationCS-2", 70,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				102		/* assert |OperationCS::ownedPostconditions| == 0 */,
				103		/* assert |OperationCS::ownedPreconditions| == 0 */,
				327		/* check-rule basecs::OperationCS.ownedExceptions : TypedRefCS */,
				328		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				288		/* assign V4 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				185		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				71		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				294		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				302		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				232		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				260		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				311		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				320		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				208		/* 'operation' || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				273		/* V02*4-steps || value */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				166		/* ')' || no-space value */,
				288		/* V04*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				299		/* V05*5-steps || value */,
				222		/* 'throws' || soft-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				303		/* V06*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				309		/* V07*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				313		/* V08*1-steps || value */,
				337		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 1 /*[?]*/,
					(21/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(72/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-3(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[108] = createSerializationRule("OperationCS-3", 70,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				102		/* assert |OperationCS::ownedPostconditions| == 0 */,
				103		/* assert |OperationCS::ownedPreconditions| == 0 */,
				326		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				327		/* check-rule basecs::OperationCS.ownedExceptions : TypedRefCS */,
				328		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				288		/* assign V4 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				185		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				71		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				321		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				226		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				294		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				302		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				232		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				260		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				311		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				320		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				208		/* 'operation' || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				273		/* V02*4-steps || value */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				166		/* ')' || no-space value */,
				288		/* V04*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				299		/* V05*5-steps || value */,
				222		/* 'throws' || soft-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				303		/* V06*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				309		/* V07*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				313		/* V08*1-steps || value */,
				337		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				316		/* V09*5-steps || value */,
				184		/* 'body' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				265		/* V10*1-steps || value */,
				37		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 1 /*[?]*/,
					(21/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(72/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-4(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[109] = createSerializationRule("OperationCS-4", 70,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				102		/* assert |OperationCS::ownedPostconditions| == 0 */,
				103		/* assert |OperationCS::ownedPreconditions| == 0 */,
				327		/* check-rule basecs::OperationCS.ownedExceptions : TypedRefCS */,
				328		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				273		/* assign V3 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				304		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				315		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				278		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				293		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				199		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				231		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				208		/* 'operation' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				166		/* ')' || no-space value */,
				280		/* V03*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				292		/* V04*5-steps || value */,
				222		/* 'throws' || soft-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				297		/* V05*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				304		/* V06*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				308		/* V07*1-steps || value */,
				337		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(72/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-5(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[110] = createSerializationRule("OperationCS-5", 70,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				102		/* assert |OperationCS::ownedPostconditions| == 0 */,
				103		/* assert |OperationCS::ownedPreconditions| == 0 */,
				326		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				327		/* check-rule basecs::OperationCS.ownedExceptions : TypedRefCS */,
				328		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				273		/* assign V3 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				182		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				316		/* assign V8 = (|OperationCS::ownedBodyExpressions| > 0) */,
				323		/* assign V9 = |OperationCS::ownedBodyExpressions| */,
				304		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				315		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				278		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				293		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				199		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				231		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				208		/* 'operation' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				87		/* OperationCS::ownedParameters+=ParameterCS || value */,
				166		/* ')' || no-space value */,
				280		/* V03*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				292		/* V04*5-steps || value */,
				222		/* 'throws' || soft-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				297		/* V05*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				50		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				304		/* V06*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				308		/* V07*1-steps || value */,
				337		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				314		/* V08*5-steps || value */,
				184		/* 'body' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				315		/* V09*1-steps || value */,
				37		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(72/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ParameterCS-0(basecs::ParameterCS): { name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "{" { qualifiers+={'!ordered|!unique|ordered|unique'} }[+] "}" }[?] { "{" "}" }[?] }
		serializationRules[111] = createSerializationRule("ParameterCS-0", 72,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				184		/* assign V0 = |TypedElementCS::ownedType| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				205		/* assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0) */,
				251		/* assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| */,
				265		/* assign V3 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				262		/* V01*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				268		/* V02*1-steps || value */,
				338		/* TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				280		/* V03*2-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(3/*'!ordered|!unique|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ReferenceCS-0(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[112] = createSerializationRule("ReferenceCS-0", 89,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				118		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				109		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				110		/* assert |ReferenceCS::referredKeys| == 0 */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				272		/* assign V3 = |StructuralFeatureCS::default| */,
				250		/* assign V2 = |TypedElementCS::ownedType| */,
				216		/* assign V1 = |ReferenceCS::referredOpposite| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				186		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				70		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				279		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				300		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				214		/* 'property' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				162		/* '#' || no-space value no-space */,
				150		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				280		/* V03*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				291		/* V04*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				296		/* V05*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 0 /*[1]*/,
					(21/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-1(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[113] = createSerializationRule("ReferenceCS-1", 89,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				109		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				110		/* assert |ReferenceCS::referredKeys| == 0 */,
				334		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				272		/* assign V3 = |StructuralFeatureCS::default| */,
				250		/* assign V2 = |TypedElementCS::ownedType| */,
				216		/* assign V1 = |ReferenceCS::referredOpposite| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				186		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				70		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				279		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				300		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				307		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				310		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				317		/* assign V8 = 0 */,
				322		/* assign V9 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				214		/* 'property' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				162		/* '#' || no-space value no-space */,
				150		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				280		/* V03*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				291		/* V04*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				296		/* V05*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				305		/* V06*5-steps || value */,
				189		/* 'derivation' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				306		/* V07*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				314		/* V08*5-steps || value */,
				201		/* 'initial' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				315		/* V09*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 0 /*[1]*/,
					(21/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-2(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[114] = createSerializationRule("ReferenceCS-2", 89,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				118		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				109		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				110		/* assert |ReferenceCS::referredKeys| == 0 */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				272		/* assign V3 = |StructuralFeatureCS::default| */,
				250		/* assign V2 = |TypedElementCS::ownedType| */,
				216		/* assign V1 = |ReferenceCS::referredOpposite| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				185		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				71		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				279		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				300		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				214		/* 'property' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				162		/* '#' || no-space value no-space */,
				150		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				280		/* V03*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				291		/* V04*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				296		/* V05*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 1 /*[?]*/,
					(21/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-3(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[115] = createSerializationRule("ReferenceCS-3", 89,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				109		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				110		/* assert |ReferenceCS::referredKeys| == 0 */,
				334		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				272		/* assign V3 = |StructuralFeatureCS::default| */,
				250		/* assign V2 = |TypedElementCS::ownedType| */,
				216		/* assign V1 = |ReferenceCS::referredOpposite| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				185		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				71		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				279		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				300		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				307		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				310		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				317		/* assign V8 = 0 */,
				322		/* assign V9 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				340		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				339		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				214		/* 'property' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				162		/* '#' || no-space value no-space */,
				150		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				280		/* V03*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				291		/* V04*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				296		/* V05*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				305		/* V06*5-steps || value */,
				189		/* 'derivation' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				306		/* V07*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				314		/* V08*5-steps || value */,
				201		/* 'initial' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				315		/* V09*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(13/*'definition'*/ << 4) | 1 /*[?]*/,
					(21/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-4(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[116] = createSerializationRule("ReferenceCS-4", 89,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				118		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				109		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				110		/* assert |ReferenceCS::referredKeys| == 0 */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V2 = |StructuralFeatureCS::default| */,
				222		/* assign V1 = |TypedElementCS::ownedType| */,
				175		/* assign V0 = |ReferenceCS::referredOpposite| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				263		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				289		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				214		/* 'property' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				162		/* '#' || no-space value no-space */,
				150		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				283		/* V03*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-5(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[117] = createSerializationRule("ReferenceCS-5", 89,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				109		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				110		/* assert |ReferenceCS::referredKeys| == 0 */,
				334		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				346		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V2 = |StructuralFeatureCS::default| */,
				222		/* assign V1 = |TypedElementCS::ownedType| */,
				175		/* assign V0 = |ReferenceCS::referredOpposite| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				263		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				289		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				298		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				303		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				312		/* assign V7 = 0 */,
				317		/* assign V8 = 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				214		/* 'property' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				162		/* '#' || no-space value no-space */,
				150		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				334		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				283		/* V03*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				300		/* V05*5-steps || value */,
				189		/* 'derivation' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				301		/* V06*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				310		/* V07*5-steps || value */,
				201		/* 'initial' || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				311		/* V08*1-steps || value */,
				46		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				176		/* ';' || no-space value soft-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(101/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(126/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-0(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[118] = createSerializationRule("SimpleTargetElementCS-0", 100,
			createSerializationMatchSteps(
				115		/* assert |SimpleTargetElementCS::output| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				116		/* assert |SimpleTargetElementCS::via| == 0 */,
				178		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				61		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				59		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				7		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				157		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(16/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-1(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[119] = createSerializationRule("SimpleTargetElementCS-1", 100,
			createSerializationMatchSteps(
				115		/* assert |SimpleTargetElementCS::output| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				116		/* assert |SimpleTargetElementCS::via| == 0 */,
				61		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				59		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */,
				144		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				201		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				234		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				7		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				157		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				255		/* V00*8-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				262		/* V01*4-steps || value */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(16/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-2(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[120] = createSerializationRule("SimpleTargetElementCS-2", 100,
			createSerializationMatchSteps(
				114		/* assert |SimpleTargetElementCS::input| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				116		/* assert |SimpleTargetElementCS::via| == 0 */,
				178		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				61		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				60		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				34		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				157		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(18/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-3(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[121] = createSerializationRule("SimpleTargetElementCS-3", 100,
			createSerializationMatchSteps(
				114		/* assert |SimpleTargetElementCS::input| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				116		/* assert |SimpleTargetElementCS::via| == 0 */,
				61		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				60		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */,
				144		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				201		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				234		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				34		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				157		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				255		/* V00*8-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				262		/* V01*4-steps || value */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(18/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-4(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[122] = createSerializationRule("SimpleTargetElementCS-4", 100,
			createSerializationMatchSteps(
				114		/* assert |SimpleTargetElementCS::input| == 0 */,
				115		/* assert |SimpleTargetElementCS::output| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				178		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				61		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				62		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				160		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				157		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(24/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-5(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[123] = createSerializationRule("SimpleTargetElementCS-5", 100,
			createSerializationMatchSteps(
				114		/* assert |SimpleTargetElementCS::input| == 0 */,
				115		/* assert |SimpleTargetElementCS::output| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				61		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				62		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */,
				144		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				201		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				234		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				160		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				157		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				255		/* V00*8-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				262		/* V01*4-steps || value */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				23		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(24/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SpecificationCS-0(essentialoclcs::ExpSpecificationCS): ownedExpression=ExpCS
		serializationRules[124] = createSerializationRule("SpecificationCS-0", 101,
			createSerializationMatchSteps(
				117		/* assert |SpecificationCS::exprString| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				365		/* check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				14		/* assert (|ExpSpecificationCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				54		/* ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::SpecificationCS-1(essentialoclcs::ExpSpecificationCS): exprString=UNQUOTED_STRING
		serializationRules[125] = createSerializationRule("SpecificationCS-1", 101,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				87		/* assert |ExpSpecificationCS::ownedExpression| == 0 */,
				63		/* assert (|SpecificationCS::exprString| - 1) == 0 */
			),
			createSerializationSteps(
				2		/* SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, true, GrammarCardinality.ONE)
			});
		// QVTbase::StructuredClassCS-0(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] ";" }
		serializationRules[126] = createSerializationRule("StructuredClassCS-0", 106,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				119		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				120		/* assert |StructuredClassCS::ownedOperations| == 0 */,
				121		/* assert |StructuredClassCS::ownedProperties| == 0 */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				337		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : TypedRefCS */,
				281		/* assign V4 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				180		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				296		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				308		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				235		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				261		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				10		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				185		/* 'class' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* V02*5-steps || value */,
				195		/* 'extends' || soft-space value soft-space */,
				119		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				119		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				288		/* V04*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				298		/* V05*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				301		/* V06*1-steps || value */,
				14		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, false,
					(11/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, false,
					(17/*'interface'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::StructuredClassCS-1(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] { "{" { ownedOperations+=OperationCS[*] ownedProperties+=StructuralFeatureCS[*] } "}" } }
		serializationRules[127] = createSerializationRule("StructuredClassCS-1", 106,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				119		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				335		/* check-rule basecs::StructuredClassCS.ownedOperations : OperationCS */,
				336		/* check-rule basecs::StructuredClassCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				342		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				337		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : TypedRefCS */,
				318		/* assign V8 = |StructuredClassCS::ownedProperties| */,
				313		/* assign V7 = |StructuredClassCS::ownedOperations| */,
				281		/* assign V4 = |ClassCS::instanceClassName| */,
				220		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				180		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				296		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				308		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				235		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				261		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				10		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				185		/* 'class' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				116		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* V02*5-steps || value */,
				195		/* 'extends' || soft-space value soft-space */,
				119		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				119		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				288		/* V04*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				298		/* V05*4-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				301		/* V06*1-steps || value */,
				14		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				231		/* '{' || soft-space value push soft-new-line */,
				307		/* V07*1-steps || value */,
				83		/* StructuredClassCS::ownedOperations+=OperationCS || value */,
				312		/* V08*1-steps || value */,
				108		/* StructuredClassCS::ownedProperties+=StructuralFeatureCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, false,
					(11/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, false,
					(17/*'interface'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 23/* OperationCS */,
					(70/*OperationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 47/* StructuralFeatureCS */,
					(105/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(111/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
	}
	private void initSerializationRules2() {
		// QVTbase::TargetCS-0(qvtbasecs::TargetCS): { "target" name=UnrestrictedName "{" ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)[*] "}" }
		serializationRules[128] = createSerializationRule("TargetCS-0", 107,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				406		/* check-rule qvtbasecs::TargetCS.ownedTargetElements : CompoundTargetElementCS|SimpleTargetElementCS */,
				181		/* assign V0 = |TargetCS::ownedTargetElements| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* 'target' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				243		/* V00*1-steps || value */,
				121		/* TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 43/* CompoundTargetElementCS,SimpleTargetElementCS */,
					(12/*CompoundTargetElementCS*/ << 4) | 2 /*[*]*/,
					(100/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-0(basecs::PrimitiveTypeRefCS): { { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[129] = createSerializationRule("TypedMultiplicityRefCS-0", 126,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				30		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */,
				256		/* V01*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-1(basecs::TypedTypeRefCS): { { ownedPathName=PathNameCS ownedMultiplicity=MultiplicityCS[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[130] = createSerializationRule("TypedMultiplicityRefCS-1", 126,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				102		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				242		/* V00*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */,
				256		/* V01*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-2(essentialoclcs::CollectionTypeCS): { { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[131] = createSerializationRule("TypedMultiplicityRefCS-2", 126,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				27		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				130		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				256		/* V01*1-steps || value */,
				40		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				166		/* ')' || no-space value */,
				266		/* V02*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */,
				276		/* V03*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(119/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTrelation::CollectionTemplateCS-0(qvtrelationcs::CollectionTemplateCS): { name=UnrestrictedName[?] ":" ownedType=CollectionTypeCS { "{" { ownedMemberIdentifiers+=(TemplateCS|ElementTemplateCS) { "," ownedMemberIdentifiers+=(TemplateCS|ElementTemplateCS) }[*] "++" ownedRestIdentifier=ElementTemplateCS }[?] "}" }[?] }
		serializationRules[132] = createSerializationRule("CollectionTemplateCS-0", 9,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |TemplateCS::ownedGuardExpression| == 0 */,
				407		/* check-rule qvtrelationcs::CollectionTemplateCS.ownedMemberIdentifiers : ElementTemplateCS|TemplateCS */,
				408		/* check-rule qvtrelationcs::CollectionTemplateCS.ownedRestIdentifier : ElementTemplateCS */,
				428		/* check-rule qvtrelationcs::TemplateVariableCS.ownedType : CollectionTypeCS */,
				65		/* assert (|TemplateVariableCS::ownedType| - 1) == 0 */,
				167		/* assign V0 = |NamedElementCS::name| */,
				192		/* assign V1 = (|CollectionTemplateCS::ownedRestIdentifier| > 0) */,
				242		/* assign V2 = |CollectionTemplateCS::ownedRestIdentifier| */,
				254		/* assign V3 = (|CollectionTemplateCS::ownedMemberIdentifiers| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				330		/* TemplateVariableCS::ownedType=CollectionTypeCS || value */,
				264		/* V01*9-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				275		/* V02*6-steps || value */,
				77		/* CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				77		/* CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS || value */,
				168		/* '++' || soft-space value soft-space */,
				113		/* CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS || value */,
				234		/* '}' || soft-new-line pop value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS, 52/* ElementTemplateCS,TemplateCS */,
					(21/*ElementTemplateCS*/ << 4) | 2 /*[*]*/,
					(109/*TemplateCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER, 6/* ElementTemplateCS */,
					(21/*ElementTemplateCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::DefaultValueCS-0(qvtrelationcs::DefaultValueCS): { propertyId=UnrestrictedName "=" ownedInitExpression=ExpCS ";" }
		serializationRules[133] = createSerializationRule("DefaultValueCS-0", 16,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				409		/* check-rule qvtrelationcs::DefaultValueCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				7		/* assert (|DefaultValueCS::ownedInitExpression| - 1) == 0 */,
				8		/* assert (|DefaultValueCS::propertyId| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				147		/* DefaultValueCS::propertyId=UnrestrictedName || soft-space value soft-space */,
				177		/* '=' || soft-space value soft-space */,
				65		/* DefaultValueCS::ownedInitExpression=ExpCS || value */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__PROPERTY_ID, -1
				)
			});
		// QVTrelation::DomainCS-0(qvtrelationcs::DomainCS): { "replace" "domain" modelId=UnrestrictedName { ownedPatterns+=DomainPatternCS { "," ownedPatterns+=DomainPatternCS }[*] }[?] { "implementedby" implementedBy=UnrestrictedName }[?] { "default_values" "{" ownedDefaultValues+=DefaultValueCS[+] "}" }[?] ";" }
		serializationRules[134] = createSerializationRule("DomainCS-0", 17,
			createSerializationMatchSteps(
				80		/* assert |DomainCS::isCheckonly| == 0 */,
				81		/* assert |DomainCS::isEnforce| == 0 */,
				82		/* assert |DomainCS::isReplace| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |DomainCS::ownedImplementedBy| == 0 */,
				410		/* check-rule qvtrelationcs::DomainCS.ownedDefaultValues : DefaultValueCS */,
				411		/* check-rule qvtrelationcs::DomainCS.ownedPatterns : DomainPatternCS */,
				243		/* assign V2 = |DomainCS::implementedBy| */,
				11		/* assert (|DomainCS::modelId| - 1) == 0 */,
				255		/* assign V3 = (|DomainCS::ownedDefaultValues| > 0) */,
				282		/* assign V4 = |DomainCS::ownedDefaultValues| */,
				135		/* assign V0 = (|DomainCS::ownedPatterns| > 0) */,
				194		/* assign V1 = (|DomainCS::ownedPatterns| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				217		/* 'replace' || soft-space value soft-space */,
				190		/* 'domain' || soft-space value soft-space */,
				26		/* DomainCS::modelId=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*4-steps || value */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				270		/* V02*2-steps || value */,
				197		/* 'implementedby' || soft-space value soft-space */,
				6		/* DomainCS::implementedBy=UnrestrictedName || soft-space value soft-space */,
				284		/* V03*5-steps || value */,
				187		/* 'default_values' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				47		/* DomainCS::ownedDefaultValues+=DefaultValueCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				175		/* ';' || no-space value soft-new-line half-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(QVTrelationCSPackage.Literals.DOMAIN_CS__IMPLEMENTED_BY, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__MODEL_ID, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES, 4/* DefaultValueCS */,
					(16/*DefaultValueCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS, 5/* DomainPatternCS */,
					(18/*DomainPatternCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::DomainCS-1(qvtrelationcs::DomainCS): { isCheckonly?="checkonly" "domain" modelId=UnrestrictedName { ownedPatterns+=DomainPatternCS { "," ownedPatterns+=DomainPatternCS }[*] }[?] { "implementedby" implementedBy=UnrestrictedName }[?] { "default_values" "{" ownedDefaultValues+=DefaultValueCS[+] "}" }[?] ";" }
		serializationRules[135] = createSerializationRule("DomainCS-1", 17,
			createSerializationMatchSteps(
				81		/* assert |DomainCS::isEnforce| == 0 */,
				82		/* assert |DomainCS::isReplace| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |DomainCS::ownedImplementedBy| == 0 */,
				410		/* check-rule qvtrelationcs::DomainCS.ownedDefaultValues : DefaultValueCS */,
				411		/* check-rule qvtrelationcs::DomainCS.ownedPatterns : DomainPatternCS */,
				243		/* assign V2 = |DomainCS::implementedBy| */,
				11		/* assert (|DomainCS::modelId| - 1) == 0 */,
				9		/* assert (|DomainCS::isCheckonly.'checkonly'| - 1) == 0 */,
				255		/* assign V3 = (|DomainCS::ownedDefaultValues| > 0) */,
				282		/* assign V4 = |DomainCS::ownedDefaultValues| */,
				135		/* assign V0 = (|DomainCS::ownedPatterns| > 0) */,
				194		/* assign V1 = (|DomainCS::ownedPatterns| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				12		/* DomainCS::isCheckonly?='checkonly' || soft-space value soft-space */,
				190		/* 'domain' || soft-space value soft-space */,
				26		/* DomainCS::modelId=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*4-steps || value */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				270		/* V02*2-steps || value */,
				197		/* 'implementedby' || soft-space value soft-space */,
				6		/* DomainCS::implementedBy=UnrestrictedName || soft-space value soft-space */,
				284		/* V03*5-steps || value */,
				187		/* 'default_values' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				47		/* DomainCS::ownedDefaultValues+=DefaultValueCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				175		/* ';' || no-space value soft-new-line half-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(QVTrelationCSPackage.Literals.DOMAIN_CS__IMPLEMENTED_BY, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_CHECKONLY, false,
					(12/*'checkonly'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__MODEL_ID, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES, 4/* DefaultValueCS */,
					(16/*DefaultValueCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS, 5/* DomainPatternCS */,
					(18/*DomainPatternCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::DomainCS-2(qvtrelationcs::DomainCS): { isEnforce?="enforce" "domain" modelId=UnrestrictedName { ownedPatterns+=DomainPatternCS { "," ownedPatterns+=DomainPatternCS }[*] }[?] { "implementedby" implementedBy=UnrestrictedName }[?] { "default_values" "{" ownedDefaultValues+=DefaultValueCS[+] "}" }[?] ";" }
		serializationRules[136] = createSerializationRule("DomainCS-2", 17,
			createSerializationMatchSteps(
				80		/* assert |DomainCS::isCheckonly| == 0 */,
				82		/* assert |DomainCS::isReplace| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |DomainCS::ownedImplementedBy| == 0 */,
				410		/* check-rule qvtrelationcs::DomainCS.ownedDefaultValues : DefaultValueCS */,
				411		/* check-rule qvtrelationcs::DomainCS.ownedPatterns : DomainPatternCS */,
				243		/* assign V2 = |DomainCS::implementedBy| */,
				11		/* assert (|DomainCS::modelId| - 1) == 0 */,
				10		/* assert (|DomainCS::isEnforce.'enforce'| - 1) == 0 */,
				255		/* assign V3 = (|DomainCS::ownedDefaultValues| > 0) */,
				282		/* assign V4 = |DomainCS::ownedDefaultValues| */,
				135		/* assign V0 = (|DomainCS::ownedPatterns| > 0) */,
				194		/* assign V1 = (|DomainCS::ownedPatterns| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				13		/* DomainCS::isEnforce?='enforce' || soft-space value soft-space */,
				190		/* 'domain' || soft-space value soft-space */,
				26		/* DomainCS::modelId=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*4-steps || value */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				270		/* V02*2-steps || value */,
				197		/* 'implementedby' || soft-space value soft-space */,
				6		/* DomainCS::implementedBy=UnrestrictedName || soft-space value soft-space */,
				284		/* V03*5-steps || value */,
				187		/* 'default_values' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				47		/* DomainCS::ownedDefaultValues+=DefaultValueCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				175		/* ';' || no-space value soft-new-line half-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(QVTrelationCSPackage.Literals.DOMAIN_CS__IMPLEMENTED_BY, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_ENFORCE, false,
					(14/*'enforce'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__MODEL_ID, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES, 4/* DefaultValueCS */,
					(16/*DefaultValueCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS, 5/* DomainPatternCS */,
					(18/*DomainPatternCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::DomainCS-3(qvtrelationcs::DomainCS): { "domain" modelId=UnrestrictedName { ownedPatterns+=DomainPatternCS { "," ownedPatterns+=DomainPatternCS }[*] }[?] { "implementedby" implementedBy=UnrestrictedName }[?] { "default_values" "{" ownedDefaultValues+=DefaultValueCS[+] "}" }[?] ";" }
		serializationRules[137] = createSerializationRule("DomainCS-3", 17,
			createSerializationMatchSteps(
				80		/* assert |DomainCS::isCheckonly| == 0 */,
				81		/* assert |DomainCS::isEnforce| == 0 */,
				82		/* assert |DomainCS::isReplace| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |DomainCS::ownedImplementedBy| == 0 */,
				410		/* check-rule qvtrelationcs::DomainCS.ownedDefaultValues : DefaultValueCS */,
				411		/* check-rule qvtrelationcs::DomainCS.ownedPatterns : DomainPatternCS */,
				243		/* assign V2 = |DomainCS::implementedBy| */,
				11		/* assert (|DomainCS::modelId| - 1) == 0 */,
				255		/* assign V3 = (|DomainCS::ownedDefaultValues| > 0) */,
				282		/* assign V4 = |DomainCS::ownedDefaultValues| */,
				135		/* assign V0 = (|DomainCS::ownedPatterns| > 0) */,
				194		/* assign V1 = (|DomainCS::ownedPatterns| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				190		/* 'domain' || soft-space value soft-space */,
				26		/* DomainCS::modelId=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*4-steps || value */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				105		/* DomainCS::ownedPatterns+=DomainPatternCS || value */,
				270		/* V02*2-steps || value */,
				197		/* 'implementedby' || soft-space value soft-space */,
				6		/* DomainCS::implementedBy=UnrestrictedName || soft-space value soft-space */,
				284		/* V03*5-steps || value */,
				187		/* 'default_values' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*1-steps || value */,
				47		/* DomainCS::ownedDefaultValues+=DefaultValueCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				175		/* ';' || no-space value soft-new-line half-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(QVTrelationCSPackage.Literals.DOMAIN_CS__IMPLEMENTED_BY, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__MODEL_ID, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES, 4/* DefaultValueCS */,
					(16/*DefaultValueCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS, 5/* DomainPatternCS */,
					(18/*DomainPatternCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::DomainPatternCS-0(qvtrelationcs::DomainPatternCS): ownedTemplate=TemplateCS
		serializationRules[138] = createSerializationRule("DomainPatternCS-0", 18,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				412		/* check-rule qvtrelationcs::DomainPatternCS.ownedTemplate : TemplateCS */,
				12		/* assert (|DomainPatternCS::ownedTemplate| - 1) == 0 */
			),
			createSerializationSteps(
				123		/* DomainPatternCS::ownedTemplate=TemplateCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS__OWNED_TEMPLATE, 51/* TemplateCS */,
					(109/*TemplateCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::ElementTemplateCS-0(qvtrelationcs::ElementTemplateCS): identifier=UnrestrictedName
		serializationRules[139] = createSerializationRule("ElementTemplateCS-0", 21,
			createSerializationMatchSteps(
				95		/* assert |NamedElementCS::name| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				123		/* assert |TemplateVariableCS::ownedType| == 0 */,
				13		/* assert (|ElementTemplateCS::identifier| - 1) == 0 */
			),
			createSerializationSteps(
				4		/* ElementTemplateCS::identifier=UnrestrictedName || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS__IDENTIFIER, -1
				)
			});
		// QVTrelation::KeyDeclCS-0(qvtrelationcs::KeyDeclCS): { "key" ownedPathName=PathNameCS "{" propertyIds+=UnrestrictedName { "," propertyIds+=UnrestrictedName }[*] "}" ";" }
		serializationRules[140] = createSerializationRule("KeyDeclCS-0", 41,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |KeyDeclCS::ownedOppositePropertyIds| == 0 */,
				414		/* check-rule qvtrelationcs::KeyDeclCS.ownedPathName : PathNameCS */,
				137		/* assign V0 = (|KeyDeclCS::propertyIds| - 1) */,
				24		/* assert (|KeyDeclCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				204		/* 'key' || soft-space value soft-space */,
				99		/* KeyDeclCS::ownedPathName=PathNameCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				149		/* KeyDeclCS::propertyIds+=UnrestrictedName || soft-space value soft-space */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				149		/* KeyDeclCS::propertyIds+=UnrestrictedName || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__PROPERTY_IDS, -1
				)
			});
		// QVTrelation::KeyDeclCS-1(qvtrelationcs::KeyDeclCS): { "key" ownedPathName=PathNameCS "{" propertyIds+=UnrestrictedName { "," { "opposite" "(" ownedOppositePropertyIds+=PathNameCS ")" } }[*] "}" ";" }
		serializationRules[141] = createSerializationRule("KeyDeclCS-1", 41,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				413		/* check-rule qvtrelationcs::KeyDeclCS.ownedOppositePropertyIds : PathNameCS */,
				414		/* check-rule qvtrelationcs::KeyDeclCS.ownedPathName : PathNameCS */,
				161		/* assign V0 = |KeyDeclCS::ownedOppositePropertyIds| */,
				25		/* assert (|KeyDeclCS::propertyIds| - 1) == 0 */,
				24		/* assert (|KeyDeclCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				204		/* 'key' || soft-space value soft-space */,
				99		/* KeyDeclCS::ownedPathName=PathNameCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				149		/* KeyDeclCS::propertyIds+=UnrestrictedName || soft-space value soft-space */,
				252		/* V00*5-steps || value */,
				170		/* ',' || no-space value soft-space */,
				209		/* 'opposite' || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				85		/* KeyDeclCS::ownedOppositePropertyIds+=PathNameCS || value */,
				166		/* ')' || no-space value */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__PROPERTY_IDS, -1
				)
			});
		// QVTrelation::KeyDeclCS-2(qvtrelationcs::KeyDeclCS): { "key" ownedPathName=PathNameCS "{" { "opposite" "(" ownedOppositePropertyIds+=PathNameCS ")" } { "," propertyIds+=UnrestrictedName }[*] "}" ";" }
		serializationRules[142] = createSerializationRule("KeyDeclCS-2", 41,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				413		/* check-rule qvtrelationcs::KeyDeclCS.ownedOppositePropertyIds : PathNameCS */,
				414		/* check-rule qvtrelationcs::KeyDeclCS.ownedPathName : PathNameCS */,
				162		/* assign V0 = |KeyDeclCS::propertyIds| */,
				23		/* assert (|KeyDeclCS::ownedOppositePropertyIds| - 1) == 0 */,
				24		/* assert (|KeyDeclCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				204		/* 'key' || soft-space value soft-space */,
				99		/* KeyDeclCS::ownedPathName=PathNameCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				209		/* 'opposite' || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				85		/* KeyDeclCS::ownedOppositePropertyIds+=PathNameCS || value */,
				166		/* ')' || no-space value */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				149		/* KeyDeclCS::propertyIds+=UnrestrictedName || soft-space value soft-space */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__PROPERTY_IDS, -1
				)
			});
		// QVTrelation::KeyDeclCS-3(qvtrelationcs::KeyDeclCS): { "key" ownedPathName=PathNameCS "{" { "opposite" "(" ownedOppositePropertyIds+=PathNameCS ")" } { "," { "opposite" "(" ownedOppositePropertyIds+=PathNameCS ")" } }[*] "}" ";" }
		serializationRules[143] = createSerializationRule("KeyDeclCS-3", 41,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				91		/* assert |KeyDeclCS::propertyIds| == 0 */,
				413		/* check-rule qvtrelationcs::KeyDeclCS.ownedOppositePropertyIds : PathNameCS */,
				414		/* check-rule qvtrelationcs::KeyDeclCS.ownedPathName : PathNameCS */,
				136		/* assign V0 = (|KeyDeclCS::ownedOppositePropertyIds| - 1) */,
				24		/* assert (|KeyDeclCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				204		/* 'key' || soft-space value soft-space */,
				99		/* KeyDeclCS::ownedPathName=PathNameCS || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				209		/* 'opposite' || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				85		/* KeyDeclCS::ownedOppositePropertyIds+=PathNameCS || value */,
				166		/* ')' || no-space value */,
				252		/* V00*5-steps || value */,
				170		/* ',' || no-space value soft-space */,
				209		/* 'opposite' || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				85		/* KeyDeclCS::ownedOppositePropertyIds+=PathNameCS || value */,
				166		/* ')' || no-space value */,
				235		/* '}' || pop soft-new-line value soft-new-line */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 3 /*[+]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::ModelDeclCS-0(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" metamodelIds+=UnrestrictedName { "dependsOn" dependsOn+=UnrestrictedName }[?] { "iterates" iterates+=UnrestrictedName }[?] }
		serializationRules[144] = createSerializationRule("ModelDeclCS-0", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				211		/* assign V1 = |ModelDeclCS::iterates| */,
				165		/* assign V0 = |ModelDeclCS::dependsOn| */,
				33		/* assert (|ModelDeclCS::metamodelIds| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ModelDeclCS-1(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" metamodelIds+=UnrestrictedName { "dependsOn" dependsOn+=UnrestrictedName }[?] { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] }
		serializationRules[145] = createSerializationRule("ModelDeclCS-1", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				165		/* assign V0 = |ModelDeclCS::dependsOn| */,
				33		/* assert (|ModelDeclCS::metamodelIds| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				197		/* assign V1 = (|ModelDeclCS::iterates| > 0) */,
				229		/* assign V2 = (|ModelDeclCS::iterates| > 0) */,
				257		/* assign V3 = (|ModelDeclCS::iterates| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*10-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				273		/* V02*4-steps || value */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ModelDeclCS-2(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" metamodelIds+=UnrestrictedName { "dependsOn" { "{" { dependsOn+=UnrestrictedName { "," dependsOn+=UnrestrictedName }[*] }[?] "}" } }[?] { "iterates" iterates+=UnrestrictedName }[?] }
		serializationRules[146] = createSerializationRule("ModelDeclCS-2", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				269		/* assign V3 = |ModelDeclCS::iterates| */,
				33		/* assert (|ModelDeclCS::metamodelIds| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				140		/* assign V0 = (|ModelDeclCS::dependsOn| > 0) */,
				196		/* assign V1 = (|ModelDeclCS::dependsOn| > 0) */,
				227		/* assign V2 = (|ModelDeclCS::dependsOn| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				246		/* V00*10-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				262		/* V01*4-steps || value */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				280		/* V03*2-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ModelDeclCS-3(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" metamodelIds+=UnrestrictedName { "dependsOn" { "{" { dependsOn+=UnrestrictedName { "," dependsOn+=UnrestrictedName }[*] }[?] "}" } }[?] { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] }
		serializationRules[147] = createSerializationRule("ModelDeclCS-3", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				33		/* assert (|ModelDeclCS::metamodelIds| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				258		/* assign V3 = (|ModelDeclCS::iterates| > 0) */,
				277		/* assign V4 = (|ModelDeclCS::iterates| > 0) */,
				291		/* assign V5 = (|ModelDeclCS::iterates| - 1) */,
				140		/* assign V0 = (|ModelDeclCS::dependsOn| > 0) */,
				196		/* assign V1 = (|ModelDeclCS::dependsOn| > 0) */,
				227		/* assign V2 = (|ModelDeclCS::dependsOn| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				246		/* V00*10-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				262		/* V01*4-steps || value */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				279		/* V03*10-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				291		/* V04*4-steps || value */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				297		/* V05*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ModelDeclCS-4(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" { "{" metamodelIds+=UnrestrictedName { "," metamodelIds+=UnrestrictedName }[*] "}" } { "dependsOn" dependsOn+=UnrestrictedName }[?] { "iterates" iterates+=UnrestrictedName }[?] }
		serializationRules[148] = createSerializationRule("ModelDeclCS-4", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				245		/* assign V2 = |ModelDeclCS::iterates| */,
				210		/* assign V1 = |ModelDeclCS::dependsOn| */,
				141		/* assign V0 = (|ModelDeclCS::metamodelIds| - 1) */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				259		/* V01*2-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ModelDeclCS-5(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" { "{" metamodelIds+=UnrestrictedName { "," metamodelIds+=UnrestrictedName }[*] "}" } { "dependsOn" dependsOn+=UnrestrictedName }[?] { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] }
		serializationRules[149] = createSerializationRule("ModelDeclCS-5", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				210		/* assign V1 = |ModelDeclCS::dependsOn| */,
				141		/* assign V0 = (|ModelDeclCS::metamodelIds| - 1) */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				229		/* assign V2 = (|ModelDeclCS::iterates| > 0) */,
				258		/* assign V3 = (|ModelDeclCS::iterates| > 0) */,
				276		/* assign V4 = (|ModelDeclCS::iterates| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				259		/* V01*2-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				269		/* V02*10-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				283		/* V03*4-steps || value */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				289		/* V04*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ModelDeclCS-6(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" { "{" metamodelIds+=UnrestrictedName { "," metamodelIds+=UnrestrictedName }[*] "}" } { "dependsOn" { "{" { dependsOn+=UnrestrictedName { "," dependsOn+=UnrestrictedName }[*] }[?] "}" } }[?] { "iterates" iterates+=UnrestrictedName }[?] }
		serializationRules[150] = createSerializationRule("ModelDeclCS-6", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				283		/* assign V4 = |ModelDeclCS::iterates| */,
				141		/* assign V0 = (|ModelDeclCS::metamodelIds| - 1) */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				196		/* assign V1 = (|ModelDeclCS::dependsOn| > 0) */,
				228		/* assign V2 = (|ModelDeclCS::dependsOn| > 0) */,
				256		/* assign V3 = (|ModelDeclCS::dependsOn| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				258		/* V01*10-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				273		/* V02*4-steps || value */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				288		/* V04*2-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ModelDeclCS-7(qvtrelationcs::ModelDeclCS): { name=UnrestrictedName ":" { "{" metamodelIds+=UnrestrictedName { "," metamodelIds+=UnrestrictedName }[*] "}" } { "dependsOn" { "{" { dependsOn+=UnrestrictedName { "," dependsOn+=UnrestrictedName }[*] }[?] "}" } }[?] { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] }
		serializationRules[151] = createSerializationRule("ModelDeclCS-7", 53,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				141		/* assign V0 = (|ModelDeclCS::metamodelIds| - 1) */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				277		/* assign V4 = (|ModelDeclCS::iterates| > 0) */,
				292		/* assign V5 = (|ModelDeclCS::iterates| > 0) */,
				301		/* assign V6 = (|ModelDeclCS::iterates| - 1) */,
				196		/* assign V1 = (|ModelDeclCS::dependsOn| > 0) */,
				228		/* assign V2 = (|ModelDeclCS::dependsOn| > 0) */,
				256		/* assign V3 = (|ModelDeclCS::dependsOn| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* ':' || no-space value no-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				25		/* ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				258		/* V01*10-steps || value */,
				188		/* 'dependsOn' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				273		/* V02*4-steps || value */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				1		/* ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */,
				287		/* V04*10-steps || value */,
				203		/* 'iterates' || soft-space value soft-space */,
				241		/* 1*1-steps || soft-space value no-space */,
				227		/* '{' || value */,
				298		/* V05*4-steps || value */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				303		/* V06*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				22		/* ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				240		/* 1*1-steps || no-space value */,
				233		/* '}' || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, -1
				)
			});
		// QVTrelation::ObjectTemplateCS-0(qvtrelationcs::ObjectTemplateCS): { name=UnrestrictedName[?] ":" ownedType=TypedRefCS { "{" { ownedPropertyTemplates+=PropertyTemplateCS { "," ownedPropertyTemplates+=PropertyTemplateCS }[*] }[?] "}" }[?] }
		serializationRules[152] = createSerializationRule("ObjectTemplateCS-0", 69,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |TemplateCS::ownedGuardExpression| == 0 */,
				415		/* check-rule qvtrelationcs::ObjectTemplateCS.ownedPropertyTemplates : PropertyTemplateCS */,
				430		/* check-rule qvtrelationcs::TemplateVariableCS.ownedType : TypedRefCS */,
				65		/* assert (|TemplateVariableCS::ownedType| - 1) == 0 */,
				167		/* assign V0 = |NamedElementCS::name| */,
				198		/* assign V1 = (|ObjectTemplateCS::ownedPropertyTemplates| > 0) */,
				230		/* assign V2 = (|ObjectTemplateCS::ownedPropertyTemplates| > 0) */,
				259		/* assign V3 = (|ObjectTemplateCS::ownedPropertyTemplates| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				332		/* TemplateVariableCS::ownedType=TypedRefCS || value */,
				263		/* V01*7-steps || value */,
				230		/* '{' || soft-space value push no-space */,
				273		/* V02*4-steps || value */,
				110		/* ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS || soft-new-line value half-new-line */,
				281		/* V03*2-steps || value */,
				169		/* ',' || no-space value soft-new-line */,
				110		/* ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS || soft-new-line value half-new-line */,
				237		/* '}' || half-new-line no-space pop value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES, 35/* PropertyTemplateCS */,
					(84/*PropertyTemplateCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::ParamDeclarationCS-0(qvtrelationcs::ParamDeclarationCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[153] = createSerializationRule("ParamDeclarationCS-0", 71,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				127		/* assert |TypedElementCS::qualifiers| == 0 */,
				345		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				69		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				333		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::PredicateCS-0(qvtrelationcs::PredicateCS): { ownedCondition=ExpCS ";" }
		serializationRules[154] = createSerializationRule("PredicateCS-0", 75,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				417		/* check-rule qvtrelationcs::PredicateCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				51		/* assert (|PredicateCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				43		/* PredicateCS::ownedCondition=ExpCS || value */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::PrimitiveTypeDomainCS-0(qvtrelationcs::PrimitiveTypeDomainCS): { "primitive" "domain" ownedPatterns+=PrimitiveTypeDomainPatternCS { "," ownedPatterns+=PrimitiveTypeDomainPatternCS }[*] ";" }
		serializationRules[155] = createSerializationRule("PrimitiveTypeDomainCS-0", 81,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				418		/* check-rule qvtrelationcs::PrimitiveTypeDomainCS.ownedPatterns : PrimitiveTypeDomainPatternCS */,
				143		/* assign V0 = (|PrimitiveTypeDomainCS::ownedPatterns| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				213		/* 'primitive' || soft-space value soft-space */,
				190		/* 'domain' || soft-space value soft-space */,
				106		/* PrimitiveTypeDomainCS::ownedPatterns+=PrimitiveTypeDomainPatternCS || value */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				106		/* PrimitiveTypeDomainCS::ownedPatterns+=PrimitiveTypeDomainPatternCS || value */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS, 34/* PrimitiveTypeDomainPatternCS */,
					(82/*PrimitiveTypeDomainPatternCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTrelation::PrimitiveTypeDomainPatternCS-0(qvtrelationcs::PrimitiveTypeDomainPatternCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[156] = createSerializationRule("PrimitiveTypeDomainPatternCS-0", 82,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				429		/* check-rule qvtrelationcs::TemplateVariableCS.ownedType : TypeExpCS */,
				65		/* assert (|TemplateVariableCS::ownedType| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				331		/* TemplateVariableCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::PropertyTemplateCS-0(qvtrelationcs::PropertyTemplateCS): { propertyId=UnrestrictedName "=" ownedExpression=ExpCSOrTemplateCS }
		serializationRules[157] = createSerializationRule("PropertyTemplateCS-0", 84,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				106		/* assert |PropertyTemplateCS::ownedOppositePropertyId| == 0 */,
				419		/* check-rule qvtrelationcs::PropertyTemplateCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|ExpCSOrTemplateCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TemplateCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				53		/* assert (|PropertyTemplateCS::ownedExpression| - 1) == 0 */,
				55		/* assert (|PropertyTemplateCS::propertyId| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				148		/* PropertyTemplateCS::propertyId=UnrestrictedName || soft-space value soft-space */,
				177		/* '=' || soft-space value soft-space */,
				56		/* PropertyTemplateCS::ownedExpression=ExpCSOrTemplateCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, 10/* ExpCSOrTemplateCS */,
					(33/*ExpCSOrTemplateCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__PROPERTY_ID, -1
				)
			});
		// QVTrelation::PropertyTemplateCS-1(qvtrelationcs::PropertyTemplateCS): { { "opposite" "(" ownedOppositePropertyId=PathNameCS ")" } "=" ownedExpression=ExpCSOrTemplateCS }
		serializationRules[158] = createSerializationRule("PropertyTemplateCS-1", 84,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				107		/* assert |PropertyTemplateCS::propertyId| == 0 */,
				419		/* check-rule qvtrelationcs::PropertyTemplateCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|ExpCSOrTemplateCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TemplateCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				420		/* check-rule qvtrelationcs::PropertyTemplateCS.ownedOppositePropertyId : PathNameCS */,
				53		/* assert (|PropertyTemplateCS::ownedExpression| - 1) == 0 */,
				54		/* assert (|PropertyTemplateCS::ownedOppositePropertyId| - 1) == 0 */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				209		/* 'opposite' || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				84		/* PropertyTemplateCS::ownedOppositePropertyId=PathNameCS || value */,
				166		/* ')' || no-space value */,
				177		/* '=' || soft-space value soft-space */,
				56		/* PropertyTemplateCS::ownedExpression=ExpCSOrTemplateCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, 10/* ExpCSOrTemplateCS */,
					(33/*ExpCSOrTemplateCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::QualifiedPackageCS-0(qvtbasecs::QualifiedPackageCS): { "package" ownedPathName=ScopeNameCS[?] name=UnrestrictedName { ":" nsPrefix=UnrestrictedName }[?] { "=" nsURI=URI }[?] ";" }
		serializationRules[159] = createSerializationRule("QualifiedPackageCS-0", 87,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				104		/* assert |PackageCS::ownedClasses| == 0 */,
				105		/* assert |PackageOwnerCS::ownedPackages| == 0 */,
				405		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				246		/* assign V2 = |PackageCS::nsURI| */,
				214		/* assign V1 = |PackageCS::nsPrefix| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				173		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* 'package' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				100		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				32		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				33		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 40/* ScopeNameCS */,
					(96/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTrelation::QualifiedPackageCS-1(qvtbasecs::QualifiedPackageCS): { "package" ownedPathName=ScopeNameCS[?] name=UnrestrictedName { ":" nsPrefix=UnrestrictedName }[?] { "=" nsURI=URI }[?] { "{" { ownedClasses+=(ClassCS|TransformationCS)[*] ownedPackages+=QualifiedPackageCS[*] } "}" } }
		serializationRules[160] = createSerializationRule("QualifiedPackageCS-1", 87,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				329		/* check-rule basecs::PackageCS.ownedClasses : ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				330		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				405		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				284		/* assign V4 = |PackageOwnerCS::ownedPackages| */,
				270		/* assign V3 = |PackageCS::ownedClasses| */,
				246		/* assign V2 = |PackageCS::nsURI| */,
				214		/* assign V1 = |PackageCS::nsPrefix| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				173		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* 'package' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				100		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				32		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				33		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				277		/* V03*1-steps || value */,
				38		/* PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line */,
				285		/* V04*1-steps || value */,
				86		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || half-new-line value half-new-line */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 56/* ClassCS,TransformationCS */,
					(4/*ClassCS*/ << 4) | 2 /*[*]*/,
					(113/*TransformationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 36/* QualifiedPackageCS */,
					(87/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 40/* ScopeNameCS */,
					(96/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTrelation::QueryCS-0(qvtrelationcs::QueryCS): { isTransient?="transient"[?] "query" name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS ";" }
		serializationRules[161] = createSerializationRule("QueryCS-0", 88,
			createSerializationMatchSteps(
				89		/* assert |JavaImplementationCS::implementation| == 0 */,
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				108		/* assert |QueryCS::ownedExpression| == 0 */,
				127		/* assert |TypedElementCS::qualifiers| == 0 */,
				422		/* check-rule qvtrelationcs::QueryCS.ownedParameters : ParamDeclarationCS */,
				345		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				69		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				200		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				233		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				21		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				215		/* 'query' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				88		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				88		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				166		/* ')' || no-space value */,
				172		/* ':' || soft-space value soft-space */,
				333		/* TypedElementCS::ownedType=TypeExpCS || value */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTrelationCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(23/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/* ParamDeclarationCS */,
					(71/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::QueryCS-1(qvtrelationcs::QueryCS): { isTransient?="transient"[?] "query" name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "implementedby" implementation=SINGLE_QUOTED_STRING ";" } }
		serializationRules[162] = createSerializationRule("QueryCS-1", 88,
			createSerializationMatchSteps(
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				108		/* assert |QueryCS::ownedExpression| == 0 */,
				127		/* assert |TypedElementCS::qualifiers| == 0 */,
				422		/* check-rule qvtrelationcs::QueryCS.ownedParameters : ParamDeclarationCS */,
				345		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				22		/* assert (|JavaImplementationCS::implementation| - 1) == 0 */,
				69		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				200		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				233		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				21		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				215		/* 'query' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				88		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				88		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				166		/* ')' || no-space value */,
				172		/* ':' || soft-space value soft-space */,
				333		/* TypedElementCS::ownedType=TypeExpCS || value */,
				197		/* 'implementedby' || soft-space value soft-space */,
				5		/* JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTrelationCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(23/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/* ParamDeclarationCS */,
					(71/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::QueryCS-2(qvtrelationcs::QueryCS): { isTransient?="transient"[?] "query" name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "{" ownedExpression=ExpCS "}" } }
		serializationRules[163] = createSerializationRule("QueryCS-2", 88,
			createSerializationMatchSteps(
				89		/* assert |JavaImplementationCS::implementation| == 0 */,
				126		/* assert |TypedElementCS::isOptional| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				127		/* assert |TypedElementCS::qualifiers| == 0 */,
				421		/* check-rule qvtrelationcs::QueryCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				422		/* check-rule qvtrelationcs::QueryCS.ownedParameters : ParamDeclarationCS */,
				345		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				56		/* assert (|QueryCS::ownedExpression| - 1) == 0 */,
				69		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				200		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				233		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				21		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				215		/* 'query' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				262		/* V01*4-steps || value */,
				88		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				271		/* V02*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				88		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				166		/* ')' || no-space value */,
				172		/* ':' || soft-space value soft-space */,
				333		/* TypedElementCS::ownedType=TypeExpCS || value */,
				229		/* '{' || soft-new-line value push soft-new-line */,
				57		/* QueryCS::ownedExpression=ExpCS || value */,
				236		/* '}' || soft-new-line pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTrelationCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(23/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/* ParamDeclarationCS */,
					(71/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::RelationCS-0(qvtrelationcs::RelationCS): { isTop?="top"[?] isAbstract?="abstract"[?] "relation" name=UnrestrictedName { "overrides" overridden=UnrestrictedName }[?] "{" ownedVarDeclarations+=VarDeclarationCS[*] ownedDomains+=(DomainCS|PrimitiveTypeDomainCS)[+] ownedWhen=WhenCS[?] ownedWhere=WhereCS[?] "}" }
		serializationRules[164] = createSerializationRule("RelationCS-0", 90,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				423		/* check-rule qvtrelationcs::RelationCS.ownedDomains : DomainCS|PrimitiveTypeDomainCS */,
				424		/* check-rule qvtrelationcs::RelationCS.ownedVarDeclarations : VarDeclarationCS */,
				425		/* check-rule qvtrelationcs::RelationCS.ownedWhen : WhenCS */,
				426		/* check-rule qvtrelationcs::RelationCS.ownedWhere : WhereCS */,
				306		/* assign V6 = |RelationCS::ownedWhere| */,
				297		/* assign V5 = |RelationCS::ownedWhen| */,
				285		/* assign V4 = |RelationCS::ownedDomains| */,
				271		/* assign V3 = |RelationCS::ownedVarDeclarations| */,
				247		/* assign V2 = |RelationCS::overridden| */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				217		/* assign V1 = |RelationCS::isAbstract.'abstract'| */,
				176		/* assign V0 = |RelationCS::isTop.'top'| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				20		/* RelationCS::isTop?='top' || soft-space value soft-space */,
				256		/* V01*1-steps || value */,
				9		/* RelationCS::isAbstract?='abstract' || soft-space value soft-space */,
				216		/* 'relation' || soft-space value soft-space */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				210		/* 'overrides' || soft-space value soft-space */,
				35		/* RelationCS::overridden=UnrestrictedName || soft-space value soft-space */,
				229		/* '{' || soft-new-line value push soft-new-line */,
				277		/* V03*1-steps || value */,
				139		/* RelationCS::ownedVarDeclarations+=VarDeclarationCS || value */,
				286		/* V04*1-steps || value */,
				48		/* RelationCS::ownedDomains+=DomainCS|PrimitiveTypeDomainCS || value */,
				294		/* V05*1-steps || value */,
				141		/* RelationCS::ownedWhen=WhenCS || value */,
				301		/* V06*1-steps || value */,
				142		/* RelationCS::ownedWhere=WhereCS || value */,
				239		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTrelationCSPackage.Literals.RELATION_CS__IS_ABSTRACT, false,
					(11/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(QVTrelationCSPackage.Literals.RELATION_CS__IS_TOP, false,
					(22/*'top'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.RELATION_CS__OVERRIDDEN, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_DOMAINS, 33/* DomainCS,PrimitiveTypeDomainCS */,
					(17/*DomainCS*/ << 4) | 3 /*[+]*/,
					(81/*PrimitiveTypeDomainCS*/ << 4) | 3 /*[+]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_VAR_DECLARATIONS, 81/* VarDeclarationCS */,
					(140/*VarDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHEN, 83/* WhenCS */,
					(143/*WhenCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHERE, 84/* WhereCS */,
					(144/*WhereCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTrelation::ScopeNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS "::" { ownedPathElements+=NextPathElementCS "::" }[*] }
		serializationRules[165] = createSerializationRule("ScopeNameCS-0", 96,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				325		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				174		/* '::' || no-space value no-space */,
				248		/* V00*2-steps || value */,
				326		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */,
				174		/* '::' || no-space value no-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 22/* FirstPathElementCS,NextPathElementCS */,
					(34/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(66/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::TemplateCS-0(qvtrelationcs::CollectionTemplateCS): { { name=UnrestrictedName[?] ":" ownedType=CollectionTypeCS { "{" { ownedMemberIdentifiers+=(TemplateCS|ElementTemplateCS) { "," ownedMemberIdentifiers+=(TemplateCS|ElementTemplateCS) }[*] "++" ownedRestIdentifier=ElementTemplateCS }[?] "}" }[?] } { "{" ownedGuardExpression=ExpCS "}" }[?] }
		serializationRules[166] = createSerializationRule("TemplateCS-0", 109,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				427		/* check-rule qvtrelationcs::TemplateCS.ownedGuardExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				407		/* check-rule qvtrelationcs::CollectionTemplateCS.ownedMemberIdentifiers : ElementTemplateCS|TemplateCS */,
				408		/* check-rule qvtrelationcs::CollectionTemplateCS.ownedRestIdentifier : ElementTemplateCS */,
				428		/* check-rule qvtrelationcs::TemplateVariableCS.ownedType : CollectionTypeCS */,
				287		/* assign V4 = |TemplateCS::ownedGuardExpression| */,
				65		/* assert (|TemplateVariableCS::ownedType| - 1) == 0 */,
				167		/* assign V0 = |NamedElementCS::name| */,
				192		/* assign V1 = (|CollectionTemplateCS::ownedRestIdentifier| > 0) */,
				242		/* assign V2 = |CollectionTemplateCS::ownedRestIdentifier| */,
				254		/* assign V3 = (|CollectionTemplateCS::ownedMemberIdentifiers| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				330		/* TemplateVariableCS::ownedType=CollectionTypeCS || value */,
				264		/* V01*9-steps || value */,
				231		/* '{' || soft-space value push soft-new-line */,
				275		/* V02*6-steps || value */,
				77		/* CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS || value */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				77		/* CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS || value */,
				168		/* '++' || soft-space value soft-space */,
				113		/* CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS || value */,
				234		/* '}' || soft-new-line pop value */,
				290		/* V04*3-steps || value */,
				228		/* '{' || soft-space value no-space */,
				61		/* TemplateCS::ownedGuardExpression=ExpCS || value */,
				238		/* '}' || no-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.TEMPLATE_CS__OWNED_GUARD_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS, 52/* ElementTemplateCS,TemplateCS */,
					(21/*ElementTemplateCS*/ << 4) | 2 /*[*]*/,
					(109/*TemplateCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER, 6/* ElementTemplateCS */,
					(21/*ElementTemplateCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::TemplateCS-1(qvtrelationcs::ObjectTemplateCS): { { name=UnrestrictedName[?] ":" ownedType=TypedRefCS { "{" { ownedPropertyTemplates+=PropertyTemplateCS { "," ownedPropertyTemplates+=PropertyTemplateCS }[*] }[?] "}" }[?] } { "{" ownedGuardExpression=ExpCS "}" }[?] }
		serializationRules[167] = createSerializationRule("TemplateCS-1", 109,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				427		/* check-rule qvtrelationcs::TemplateCS.ownedGuardExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				415		/* check-rule qvtrelationcs::ObjectTemplateCS.ownedPropertyTemplates : PropertyTemplateCS */,
				430		/* check-rule qvtrelationcs::TemplateVariableCS.ownedType : TypedRefCS */,
				287		/* assign V4 = |TemplateCS::ownedGuardExpression| */,
				65		/* assert (|TemplateVariableCS::ownedType| - 1) == 0 */,
				167		/* assign V0 = |NamedElementCS::name| */,
				198		/* assign V1 = (|ObjectTemplateCS::ownedPropertyTemplates| > 0) */,
				230		/* assign V2 = (|ObjectTemplateCS::ownedPropertyTemplates| > 0) */,
				259		/* assign V3 = (|ObjectTemplateCS::ownedPropertyTemplates| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				242		/* V00*1-steps || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				332		/* TemplateVariableCS::ownedType=TypedRefCS || value */,
				263		/* V01*7-steps || value */,
				230		/* '{' || soft-space value push no-space */,
				273		/* V02*4-steps || value */,
				110		/* ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS || soft-new-line value half-new-line */,
				281		/* V03*2-steps || value */,
				169		/* ',' || no-space value soft-new-line */,
				110		/* ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS || soft-new-line value half-new-line */,
				237		/* '}' || half-new-line no-space pop value soft-space */,
				290		/* V04*3-steps || value */,
				230		/* '{' || soft-space value push no-space */,
				61		/* TemplateCS::ownedGuardExpression=ExpCS || value */,
				237		/* '}' || half-new-line no-space pop value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.TEMPLATE_CS__OWNED_GUARD_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES, 35/* PropertyTemplateCS */,
					(84/*PropertyTemplateCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 68/* TypedRefCS */,
					(127/*TypedRefCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::TopLevelCS-0(qvtrelationcs::TopLevelCS): { ownedImports+=UnitCS[*] { ownedPackages+=QualifiedPackageCS[*] ownedTransformations+=TransformationCS[*] } }
		serializationRules[168] = createSerializationRule("TopLevelCS-0", 112,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				333		/* check-rule basecs::RootCS.ownedImports : UnitCS */,
				330		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				431		/* check-rule qvtrelationcs::TopLevelCS.ownedTransformations : TransformationCS */,
				249		/* assign V2 = |TopLevelCS::ownedTransformations| */,
				215		/* assign V1 = |PackageOwnerCS::ownedPackages| */,
				177		/* assign V0 = |RootCS::ownedImports| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				244		/* V00*1-steps || value half-new-line */,
				63		/* RootCS::ownedImports+=UnitCS || value */,
				257		/* V01*1-steps || value */,
				86		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || half-new-line value half-new-line */,
				267		/* V02*1-steps || value */,
				127		/* TopLevelCS::ownedTransformations+=TransformationCS || half-new-line value half-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 72/* UnitCS */,
					(135/*UnitCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 36/* QualifiedPackageCS */,
					(87/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 55/* TransformationCS */,
					(113/*TransformationCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::TransformationCS-0(qvtrelationcs::TransformationCS): { "transformation" ownedPathName=ScopeNameCS[?] name=UnrestrictedName "(" ownedModelDecls+=ModelDeclCS { "," ownedModelDecls+=ModelDeclCS }[*] ")" { "extends" extends+=UnrestrictedName { "," extends+=UnrestrictedName }[*] }[?] "{" ownedTargets+=TargetCS[*] ownedKeyDecls+=KeyDeclCS[*] { ownedRelations+=RelationCS[*] ownedQueries+=QueryCS[*] ownedProperties+=StructuralFeatureCS[*] } "}" }
		serializationRules[169] = createSerializationRule("TransformationCS-0", 113,
			createSerializationMatchSteps(
				74		/* assert |ClassCS::instanceClassName| == 0 */,
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |ClassCS::ownedConstraints| == 0 */,
				124		/* assert |TemplateableElementCS::ownedSignature| == 0 */,
				432		/* check-rule qvtrelationcs::TransformationCS.ownedKeyDecls : KeyDeclCS */,
				433		/* check-rule qvtrelationcs::TransformationCS.ownedModelDecls : ModelDeclCS */,
				402		/* check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : ScopeNameCS */,
				434		/* check-rule qvtrelationcs::TransformationCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				435		/* check-rule qvtrelationcs::TransformationCS.ownedQueries : QueryCS */,
				436		/* check-rule qvtrelationcs::TransformationCS.ownedRelations : RelationCS */,
				403		/* check-rule qvtbasecs::AbstractTransformationCS.ownedTargets : TargetCS */,
				319		/* assign V8 = |TransformationCS::ownedProperties| */,
				314		/* assign V7 = |TransformationCS::ownedQueries| */,
				309		/* assign V6 = |TransformationCS::ownedRelations| */,
				299		/* assign V5 = |TransformationCS::ownedKeyDecls| */,
				280		/* assign V4 = |AbstractTransformationCS::ownedTargets| */,
				202		/* assign V1 = (|TransformationCS::ownedModelDecls| - 1) */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */,
				153		/* assign V0 = |AbstractTransformationCS::ownedPathName| */,
				236		/* assign V2 = (|TransformationCS::extends| > 0) */,
				262		/* assign V3 = (|TransformationCS::extends| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				223		/* 'transformation' || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				97		/* AbstractTransformationCS::ownedPathName=ScopeNameCS || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				165		/* '(' || no-space value no-space */,
				78		/* TransformationCS::ownedModelDecls+=ModelDeclCS || value */,
				260		/* V01*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				78		/* TransformationCS::ownedModelDecls+=ModelDeclCS || value */,
				166		/* ')' || no-space value */,
				274		/* V02*5-steps || value */,
				195		/* 'extends' || soft-space value soft-space */,
				3		/* TransformationCS::extends+=UnrestrictedName || soft-space value soft-space */,
				281		/* V03*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				3		/* TransformationCS::extends+=UnrestrictedName || soft-space value soft-space */,
				229		/* '{' || soft-new-line value push soft-new-line */,
				285		/* V04*1-steps || value */,
				122		/* AbstractTransformationCS::ownedTargets+=TargetCS || value */,
				295		/* V05*1-steps || value */,
				72		/* TransformationCS::ownedKeyDecls+=KeyDeclCS || value */,
				302		/* V06*1-steps || value */,
				112		/* TransformationCS::ownedRelations+=RelationCS || half-new-line value half-new-line */,
				307		/* V07*1-steps || value */,
				111		/* TransformationCS::ownedQueries+=QueryCS || half-new-line value half-new-line */,
				312		/* V08*1-steps || value */,
				109		/* TransformationCS::ownedProperties+=StructuralFeatureCS || value */,
				239		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__EXTENDS, -1
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_KEY_DECLS, 12/* KeyDeclCS */,
					(41/*KeyDeclCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_MODEL_DECLS, 16/* ModelDeclCS */,
					(53/*ModelDeclCS*/ << 4) | 3 /*[+]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 40/* ScopeNameCS */,
					(96/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 47/* StructuralFeatureCS */,
					(105/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES, 37/* QueryCS */,
					(88/*QueryCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_RELATIONS, 38/* RelationCS */,
					(90/*RelationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 50/* TargetCS */,
					(107/*TargetCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::TypedRefCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[170] = createSerializationRule("TypedRefCS-0", 127,
			createSerializationMatchSteps(
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				187		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				52		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				30		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				242		/* V00*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTrelation::TypedRefCS-1(basecs::TypedTypeRefCS): { ownedPathName=PathNameCS ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[171] = createSerializationRule("TypedRefCS-1", 127,
			createSerializationMatchSteps(
				129		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				130		/* assert |TypedTypeRefCS::ownedBinding| == 0 */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				348		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				187		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				72		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				102		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				242		/* V00*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::TypedRefCS-2(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[172] = createSerializationRule("TypedRefCS-2", 127,
			createSerializationMatchSteps(
				361		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				347		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				362		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				252		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				156		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				208		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				27		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				251		/* V00*5-steps || value */,
				165		/* '(' || no-space value no-space */,
				130		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				256		/* V01*1-steps || value */,
				40		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				166		/* ')' || no-space value */,
				266		/* V02*1-steps || value */,
				80		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(55/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(119/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTrelation::TypedTypeRefCS-0(basecs::TypedTypeRefCS): ownedPathName=PathNameCS
		serializationRules[173] = createSerializationRule("TypedTypeRefCS-0", 128,
			createSerializationMatchSteps(
				129		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				130		/* assert |TypedTypeRefCS::ownedBinding| == 0 */,
				128		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				348		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				72		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				102		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(73/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::UnitCS-0(basecs::ImportCS): { "import" { name=UnrestrictedName ":" }[?] ownedPathName=URIPathNameCS { "::" isAll?="*" }[?] ";" }
		serializationRules[174] = createSerializationRule("UnitCS-0", 135,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				325		/* check-rule basecs::ImportCS.ownedPathName : URIPathNameCS */,
				209		/* assign V1 = |ImportCS::isAll.'*'| */,
				20		/* assert (|ImportCS::ownedPathName| - 1) == 0 */,
				167		/* assign V0 = |NamedElementCS::name| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				198		/* 'import' || soft-space value soft-space */,
				247		/* V00*2-steps || value */,
				319		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				172		/* ':' || soft-space value soft-space */,
				98		/* ImportCS::ownedPathName=URIPathNameCS || value */,
				259		/* V01*2-steps || value */,
				174		/* '::' || no-space value no-space */,
				11		/* ImportCS::isAll?='*' || soft-space value soft-space */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, false,
					(4/*'*'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 71/* URIPathNameCS */,
					(133/*URIPathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTrelation::VarDeclarationCS-0(qvtrelationcs::VarDeclarationCS): { ownedVarDeclarationIds+=VarDeclarationIdCS { "," ownedVarDeclarationIds+=VarDeclarationIdCS }[*] { ":" ownedType=TypeExpCS }[?] { "=" ownedInitExpression=ExpCS }[?] ";" }
		serializationRules[175] = createSerializationRule("VarDeclarationCS-0", 140,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				437		/* check-rule qvtrelationcs::VarDeclarationCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				438		/* check-rule qvtrelationcs::VarDeclarationCS.ownedType : TypeExpCS */,
				439		/* check-rule qvtrelationcs::VarDeclarationCS.ownedVarDeclarationIds : VarDeclarationIdCS */,
				253		/* assign V2 = |VarDeclarationCS::ownedInitExpression| */,
				224		/* assign V1 = |VarDeclarationCS::ownedType| */,
				151		/* assign V0 = (|VarDeclarationCS::ownedVarDeclarationIds| - 1) */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				138		/* VarDeclarationCS::ownedVarDeclarationIds+=VarDeclarationIdCS || value */,
				248		/* V00*2-steps || value */,
				170		/* ',' || no-space value soft-space */,
				138		/* VarDeclarationCS::ownedVarDeclarationIds+=VarDeclarationIdCS || value */,
				259		/* V01*2-steps || value */,
				172		/* ':' || soft-space value soft-space */,
				134		/* VarDeclarationCS::ownedType=TypeExpCS || value */,
				270		/* V02*2-steps || value */,
				177		/* '=' || soft-space value soft-space */,
				69		/* VarDeclarationCS::ownedInitExpression=ExpCS || value */,
				176		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_INIT_EXPRESSION, 9/* ExpCS */,
					(32/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(118/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS, 82/* VarDeclarationIdCS */,
					(141/*VarDeclarationIdCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTrelation::VarDeclarationIdCS-0(qvtrelationcs::VarDeclarationIdCS): name=UnrestrictedName
		serializationRules[176] = createSerializationRule("VarDeclarationIdCS-0", 141,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				37		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				29		/* NamedElementCS::name=UnrestrictedName || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE)
			});
		// QVTrelation::WhenCS-0(qvtrelationcs::PatternCS): { "when" "{" ownedPredicates+=PredicateCS[*] "}" }
		serializationRules[177] = createSerializationRule("WhenCS-0", 143,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				416		/* check-rule qvtrelationcs::PatternCS.ownedPredicates : PredicateCS */,
				171		/* assign V0 = |PatternCS::ownedPredicates| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				224		/* 'when' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				243		/* V00*1-steps || value */,
				107		/* PatternCS::ownedPredicates+=PredicateCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.PATTERN_CS__OWNED_PREDICATES, 29/* PredicateCS */,
					(75/*PredicateCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTrelation::WhereCS-0(qvtrelationcs::PatternCS): { "where" "{" ownedPredicates+=PredicateCS[*] "}" }
		serializationRules[178] = createSerializationRule("WhereCS-0", 144,
			createSerializationMatchSteps(
				93		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				416		/* check-rule qvtrelationcs::PatternCS.ownedPredicates : PredicateCS */,
				171		/* assign V0 = |PatternCS::ownedPredicates| */
			),
			createSerializationSteps(
				317		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				225		/* 'where' || soft-space value soft-space */,
				231		/* '{' || soft-space value push soft-new-line */,
				243		/* V00*1-steps || value */,
				107		/* PatternCS::ownedPredicates+=PredicateCS || value */,
				235		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTrelationCSPackage.Literals.PATTERN_CS__OWNED_PREDICATES, 29/* PredicateCS */,
					(75/*PredicateCS*/ << 4) | 2 /*[*]*/
				)
			});
	}

	/**
	 * Initialize the various string segment sequences that may be used to serialize a serialization term.
	 */
	private void initSerializationSegments() {
		serializationSegments[0] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.VALUE /* value */
		};
		serializationSegments[1] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */
		};
		serializationSegments[2] = new @NonNull SerializationSegment @NonNull [] {
			new CustomSerializationSegment(BaseCommentSegmentSupport.class) /* org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport */,
			SerializationSegment.VALUE /* value */
		};
		serializationSegments[3] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.VALUE /* value */,
			SerializationSegment.HALF_NEW_LINE /* half-new-line */
		};
		serializationSegments[4] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.VALUE /* value */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[5] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.HALF_NEW_LINE /* half-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.HALF_NEW_LINE /* half-new-line */
		};
		serializationSegments[6] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[7] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[8] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[9] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[10] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */
		};
		serializationSegments[11] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.HALF_NEW_LINE /* half-new-line */
		};
		serializationSegments[12] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[13] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */
		};
		serializationSegments[14] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[15] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.HALF_NEW_LINE /* half-new-line */
		};
		serializationSegments[16] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[17] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[18] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[19] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[20] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[21] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[22] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[23] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[24] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[25] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.HALF_NEW_LINE /* half-new-line */,
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[26] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[27] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[28] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
	}

	/**
	 * Initialize the various serialization steps used to serialize a serialization rule.
	 */
	private void initSerializationSteps() {
		// 0: StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[0] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, 94 /*SINGLE_QUOTED_STRING*/, 14);
		// 1: ModelDeclCS::dependsOn+=UnrestrictedName || soft-space value soft-space
		serializationSteps[1] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, getCrossReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__DEPENDS_ON, "UnrestrictedName"), 139, 14);
		// 2: SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[2] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, 129 /*UNQUOTED_STRING*/, 2);
		// 3: TransformationCS::extends+=UnrestrictedName || soft-space value soft-space
		serializationSteps[3] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__EXTENDS, getCrossReference(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__EXTENDS, "UnrestrictedName"), 139, 14);
		// 4: ElementTemplateCS::identifier=UnrestrictedName || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[4] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS__IDENTIFIER, getCrossReference(QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS__IDENTIFIER, "UnrestrictedName"), 139, 2);
		// 5: JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[5] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, getCrossReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, "SINGLE_QUOTED_STRING"), 94, 14);
		// 6: DomainCS::implementedBy=UnrestrictedName || soft-space value soft-space
		serializationSteps[6] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.DOMAIN_CS__IMPLEMENTED_BY, 139 /*UnrestrictedName*/, 14);
		// 7: SimpleTargetElementCS::input?='input' || soft-space value soft-space
		serializationSteps[7] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 16 /* 'input' */, 14);
		// 8: ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[8] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, 94 /*SINGLE_QUOTED_STRING*/, 14);
		// 9: RelationCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[9] = createSerializationStepAssignKeyword(QVTrelationCSPackage.Literals.RELATION_CS__IS_ABSTRACT, 11 /* 'abstract' */, 14);
		// 10: StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[10] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 11 /* 'abstract' */, 14);
		// 11: ImportCS::isAll?='*' || soft-space value soft-space
		serializationSteps[11] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, 4 /* '*' */, 14);
		// 12: DomainCS::isCheckonly?='checkonly' || soft-space value soft-space
		serializationSteps[12] = createSerializationStepAssignKeyword(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_CHECKONLY, 12 /* 'checkonly' */, 14);
		// 13: DomainCS::isEnforce?='enforce' || soft-space value soft-space
		serializationSteps[13] = createSerializationStepAssignKeyword(QVTrelationCSPackage.Literals.DOMAIN_CS__IS_ENFORCE, 14 /* 'enforce' */, 14);
		// 14: StructuredClassCS::isInterface?='interface' || soft-space value soft-space
		serializationSteps[14] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 17 /* 'interface' */, 14);
		// 15: MultiplicityCS::isNullFree?='|1' || no-space value no-space
		serializationSteps[15] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 26 /* '|1' */, 6);
		// 16: AbstractNameExpCS::isPre?='@' || soft-space value soft-space
		serializationSteps[16] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 8 /* '@' */, 14);
		// 17: DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space
		serializationSteps[17] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 19 /* 'primitive' */, 14);
		// 18: DataTypeCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[18] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 20 /* 'serializable' */, 14);
		// 19: EnumerationCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[19] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 20 /* 'serializable' */, 14);
		// 20: RelationCS::isTop?='top' || soft-space value soft-space
		serializationSteps[20] = createSerializationStepAssignKeyword(QVTrelationCSPackage.Literals.RELATION_CS__IS_TOP, 22 /* 'top' */, 14);
		// 21: QueryCS::isTransient?='transient' || soft-space value soft-space
		serializationSteps[21] = createSerializationStepAssignKeyword(QVTrelationCSPackage.Literals.QUERY_CS__IS_TRANSIENT, 23 /* 'transient' */, 14);
		// 22: ModelDeclCS::iterates+=UnrestrictedName || soft-space value soft-space
		serializationSteps[22] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, getCrossReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__ITERATES, "UnrestrictedName"), 139, 14);
		// 23: SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space
		serializationSteps[23] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, "UnrestrictedName"), 139, 14);
		// 24: MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space
		serializationSteps[24] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, 43 /*LOWER*/, 14);
		// 25: ModelDeclCS::metamodelIds+=UnrestrictedName || soft-space value soft-space
		serializationSteps[25] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, getCrossReference(QVTrelationCSPackage.Literals.MODEL_DECL_CS__METAMODEL_IDS, "UnrestrictedName"), 139, 14);
		// 26: DomainCS::modelId=UnrestrictedName || soft-space value soft-space
		serializationSteps[26] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.DOMAIN_CS__MODEL_ID, getCrossReference(QVTrelationCSPackage.Literals.DOMAIN_CS__MODEL_ID, "UnrestrictedName"), 139, 14);
		// 27: CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space
		serializationSteps[27] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, 11 /*CollectionTypeIdentifier*/, 14);
		// 28: MapTypeCS::name='Map' || soft-space value soft-space
		serializationSteps[28] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 9 /* 'Map' */, 14);
		// 29: NamedElementCS::name=UnrestrictedName || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[29] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 139 /*UnrestrictedName*/, 2);
		// 30: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space
		serializationSteps[30] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, 83 /*PrimitiveTypeIdentifier*/, 14);
		// 31: TupleTypeCS::name='Tuple' || soft-space value soft-space
		serializationSteps[31] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 10 /* 'Tuple' */, 14);
		// 32: PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space
		serializationSteps[32] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, 139 /*UnrestrictedName*/, 14);
		// 33: PackageCS::nsURI=URI || soft-space value soft-space
		serializationSteps[33] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, 131 /*URI*/, 14);
		// 34: SimpleTargetElementCS::output?='output' || soft-space value soft-space
		serializationSteps[34] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 18 /* 'output' */, 14);
		// 35: RelationCS::overridden=UnrestrictedName || soft-space value soft-space
		serializationSteps[35] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.RELATION_CS__OVERRIDDEN, getCrossReference(QVTrelationCSPackage.Literals.RELATION_CS__OVERRIDDEN, "UnrestrictedName"), 139, 14);
		// 36: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[36] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 125 /*TypeRefCS*/, 2);
		// 37: OperationCS::ownedBodyExpressions+=SpecificationCS || value
		serializationSteps[37] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 101 /*SpecificationCS*/, 0);
		// 38: PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line
		serializationSteps[38] = createSerializationStepAssigns(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, -1, new int[] { 4/*ClassCS*/,113/*TransformationCS*/}, 5);
		// 39: NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value
		serializationSteps[39] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 5 /*CoIteratorVariableCS*/, 0);
		// 40: CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value
		serializationSteps[40] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 55 /*MultiplicityCS*/, 0);
		// 41: IfExpCS::ownedCondition=ExpCS|PatternExpCS || value
		serializationSteps[41] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, -1, new int[] { 32/*ExpCS*/,74/*PatternExpCS*/}, 0);
		// 42: IfThenExpCS::ownedCondition=ExpCS || value
		serializationSteps[42] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 32 /*ExpCS*/, 0);
		// 43: PredicateCS::ownedCondition=ExpCS || value
		serializationSteps[43] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 32 /*ExpCS*/, 0);
		// 44: AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[44] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 13 /*CurlyBracketedClauseCS*/, 0);
		// 45: TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[45] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 13 /*CurlyBracketedClauseCS*/, 0);
		// 46: StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value
		serializationSteps[46] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 101 /*SpecificationCS*/, 0);
		// 47: DomainCS::ownedDefaultValues+=DefaultValueCS || value
		serializationSteps[47] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_DEFAULT_VALUES, 16 /*DefaultValueCS*/, 0);
		// 48: RelationCS::ownedDomains+=DomainCS|PrimitiveTypeDomainCS || value
		serializationSteps[48] = createSerializationStepAssigns(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_DOMAINS, -1, new int[] { 17/*DomainCS*/,81/*PrimitiveTypeDomainCS*/}, 0);
		// 49: IfExpCS::ownedElseExpression=ExpCS || value
		serializationSteps[49] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 32 /*ExpCS*/, 0);
		// 50: OperationCS::ownedExceptions+=TypedRefCS || value
		serializationSteps[50] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 127 /*TypedRefCS*/, 0);
		// 51: CollectionLiteralPartCS::ownedExpression=ExpCS || value
		serializationSteps[51] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 32 /*ExpCS*/, 0);
		// 52: CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[52] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 74 /*PatternExpCS*/, 2);
		// 53: ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[53] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 32 /*ExpCS*/, 2);
		// 54: ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[54] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 32 /*ExpCS*/, 2);
		// 55: NestedExpCS::ownedExpression=ExpCS || value
		serializationSteps[55] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 32 /*ExpCS*/, 0);
		// 56: PropertyTemplateCS::ownedExpression=ExpCSOrTemplateCS || value
		serializationSteps[56] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION, 33 /*ExpCSOrTemplateCS*/, 0);
		// 57: QueryCS::ownedExpression=ExpCS || value
		serializationSteps[57] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 32 /*ExpCS*/, 0);
		// 58: LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value
		serializationSteps[58] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 32 /*ExpCS*/, 0);
		// 59: TypeParameterCS::ownedExtends+=TypedRefCS || value
		serializationSteps[59] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 127 /*TypedRefCS*/, 0);
		// 60: WildcardTypeRefCS::ownedExtends=TypedRefCS || value
		serializationSteps[60] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 127 /*TypedRefCS*/, 0);
		// 61: TemplateCS::ownedGuardExpression=ExpCS || value
		serializationSteps[61] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TEMPLATE_CS__OWNED_GUARD_EXPRESSION, 32 /*ExpCS*/, 0);
		// 62: IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value
		serializationSteps[62] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 22 /*ElseIfThenExpCS*/, 0);
		// 63: RootCS::ownedImports+=UnitCS || value
		serializationSteps[63] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 135 /*UnitCS*/, 0);
		// 64: LetExpCS::ownedInExpression=ExpCS || value
		serializationSteps[64] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 32 /*ExpCS*/, 0);
		// 65: DefaultValueCS::ownedInitExpression=ExpCS || value
		serializationSteps[65] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION, 32 /*ExpCS*/, 0);
		// 66: NavigatingArgCS::ownedInitExpression=ExpCS || value
		serializationSteps[66] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 32 /*ExpCS*/, 0);
		// 67: ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value
		serializationSteps[67] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, -1, new int[] { 32/*ExpCS*/,74/*PatternExpCS*/}, 0);
		// 68: ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[68] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 104 /*StringLiteralExpCS*/, 2);
		// 69: VarDeclarationCS::ownedInitExpression=ExpCS || value
		serializationSteps[69] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_INIT_EXPRESSION, 32 /*ExpCS*/, 0);
		// 70: VariableCS::ownedInitExpression=ExpCS || value
		serializationSteps[70] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 32 /*ExpCS*/, 0);
		// 71: MapLiteralPartCS::ownedKey=ExpCS || value
		serializationSteps[71] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 32 /*ExpCS*/, 0);
		// 72: TransformationCS::ownedKeyDecls+=KeyDeclCS || value
		serializationSteps[72] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_KEY_DECLS, 41 /*KeyDeclCS*/, 0);
		// 73: MapTypeCS::ownedKeyType=TypeExpCS || value
		serializationSteps[73] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 118 /*TypeExpCS*/, 0);
		// 74: CollectionLiteralPartCS::ownedLastExpression=ExpCS || value
		serializationSteps[74] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 32 /*ExpCS*/, 0);
		// 75: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value
		serializationSteps[75] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 77 /*PrefixedPrimaryExpCS*/, 0);
		// 76: EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value
		serializationSteps[76] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 24 /*EnumerationLiteralCS*/, 0);
		// 77: CollectionTemplateCS::ownedMemberIdentifiers+=TemplateCS|ElementTemplateCS || value
		serializationSteps[77] = createSerializationStepAssigns(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS, -1, new int[] { 109/*TemplateCS*/,21/*ElementTemplateCS*/}, 0);
		// 78: TransformationCS::ownedModelDecls+=ModelDeclCS || value
		serializationSteps[78] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_MODEL_DECLS, 53 /*ModelDeclCS*/, 0);
		// 79: TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[79] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 55 /*MultiplicityCS*/, 0);
		// 80: TypedRefCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[80] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 55 /*MultiplicityCS*/, 0);
		// 81: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value
		serializationSteps[81] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 60 /*NavigatingArgExpCS*/, 0);
		// 82: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[82] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 60 /*NavigatingArgExpCS*/, 2);
		// 83: StructuredClassCS::ownedOperations+=OperationCS || value
		serializationSteps[83] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 70 /*OperationCS*/, 0);
		// 84: PropertyTemplateCS::ownedOppositePropertyId=PathNameCS || value
		serializationSteps[84] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID, 73 /*PathNameCS*/, 0);
		// 85: KeyDeclCS::ownedOppositePropertyIds+=PathNameCS || value
		serializationSteps[85] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS, 73 /*PathNameCS*/, 0);
		// 86: PackageOwnerCS::ownedPackages+=QualifiedPackageCS || half-new-line value half-new-line
		serializationSteps[86] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 87 /*QualifiedPackageCS*/, 5);
		// 87: OperationCS::ownedParameters+=ParameterCS || value
		serializationSteps[87] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 72 /*ParameterCS*/, 0);
		// 88: QueryCS::ownedParameters+=ParamDeclarationCS || value
		serializationSteps[88] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 71 /*ParamDeclarationCS*/, 0);
		// 89: TemplateSignatureCS::ownedParameters+=TypeParameterCS || value
		serializationSteps[89] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 124 /*TypeParameterCS*/, 0);
		// 90: CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value
		serializationSteps[90] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 7 /*CollectionLiteralPartCS*/, 0);
		// 91: CollectionPatternCS::ownedParts+=PatternExpCS || value
		serializationSteps[91] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 74 /*PatternExpCS*/, 0);
		// 92: CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value
		serializationSteps[92] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 98 /*ShadowPartCS*/, 0);
		// 93: MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value
		serializationSteps[93] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 50 /*MapLiteralPartCS*/, 0);
		// 94: TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value
		serializationSteps[94] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 115 /*TupleLiteralPartCS*/, 0);
		// 95: TupleTypeCS::ownedParts+=TuplePartCS || value
		serializationSteps[95] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 116 /*TuplePartCS*/, 0);
		// 96: AbstractNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[96] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 73 /*PathNameCS*/, 0);
		// 97: AbstractTransformationCS::ownedPathName=ScopeNameCS || value
		serializationSteps[97] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 96 /*ScopeNameCS*/, 0);
		// 98: ImportCS::ownedPathName=URIPathNameCS || value
		serializationSteps[98] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 133 /*URIPathNameCS*/, 0);
		// 99: KeyDeclCS::ownedPathName=PathNameCS || value
		serializationSteps[99] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.KEY_DECL_CS__OWNED_PATH_NAME, 73 /*PathNameCS*/, 0);
		// 100: QualifiedPackageCS::ownedPathName=ScopeNameCS || value
		serializationSteps[100] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 96 /*ScopeNameCS*/, 0);
		// 101: TypeNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[101] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 73 /*PathNameCS*/, 0);
		// 102: TypedTypeRefCS::ownedPathName=PathNameCS || value
		serializationSteps[102] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 73 /*PathNameCS*/, 0);
		// 103: TypeNameExpCS::ownedPatternGuard=ExpCS || value
		serializationSteps[103] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 32 /*ExpCS*/, 0);
		// 104: PatternExpCS::ownedPatternType=TypeExpCS || value
		serializationSteps[104] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 118 /*TypeExpCS*/, 0);
		// 105: DomainCS::ownedPatterns+=DomainPatternCS || value
		serializationSteps[105] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.DOMAIN_CS__OWNED_PATTERNS, 18 /*DomainPatternCS*/, 0);
		// 106: PrimitiveTypeDomainCS::ownedPatterns+=PrimitiveTypeDomainPatternCS || value
		serializationSteps[106] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS, 82 /*PrimitiveTypeDomainPatternCS*/, 0);
		// 107: PatternCS::ownedPredicates+=PredicateCS || value
		serializationSteps[107] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.PATTERN_CS__OWNED_PREDICATES, 75 /*PredicateCS*/, 0);
		// 108: StructuredClassCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[108] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 105 /*StructuralFeatureCS*/, 0);
		// 109: TransformationCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[109] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 105 /*StructuralFeatureCS*/, 0);
		// 110: ObjectTemplateCS::ownedPropertyTemplates+=PropertyTemplateCS || soft-new-line value half-new-line
		serializationSteps[110] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES, 84 /*PropertyTemplateCS*/, 11);
		// 111: TransformationCS::ownedQueries+=QueryCS || half-new-line value half-new-line
		serializationSteps[111] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES, 88 /*QueryCS*/, 5);
		// 112: TransformationCS::ownedRelations+=RelationCS || half-new-line value half-new-line
		serializationSteps[112] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TRANSFORMATION_CS__OWNED_RELATIONS, 90 /*RelationCS*/, 5);
		// 113: CollectionTemplateCS::ownedRestIdentifier=ElementTemplateCS || value
		serializationSteps[113] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER, 21 /*ElementTemplateCS*/, 0);
		// 114: AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[114] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 91 /*RoundBracketedClauseCS*/, 0);
		// 115: LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[115] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 91 /*RoundBracketedClauseCS*/, 0);
		// 116: TemplateableElementCS::ownedSignature=TemplateSignatureCS || value
		serializationSteps[116] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 111 /*TemplateSignatureCS*/, 0);
		// 117: AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value
		serializationSteps[117] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 102 /*SquareBracketedClauseCS*/, 0);
		// 118: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value
		serializationSteps[118] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 110 /*TemplateParameterSubstitutionCS*/, 0);
		// 119: StructuredClassCS::ownedSuperTypes+=TypedRefCS || value
		serializationSteps[119] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 127 /*TypedRefCS*/, 0);
		// 120: CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value
		serializationSteps[120] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 100 /*SimpleTargetElementCS*/, 0);
		// 121: TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value
		serializationSteps[121] = createSerializationStepAssigns(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, -1, new int[] { 100/*SimpleTargetElementCS*/,12/*CompoundTargetElementCS*/}, 0);
		// 122: AbstractTransformationCS::ownedTargets+=TargetCS || value
		serializationSteps[122] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 107 /*TargetCS*/, 0);
		// 123: DomainPatternCS::ownedTemplate=TemplateCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[123] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS__OWNED_TEMPLATE, 109 /*TemplateCS*/, 2);
		// 124: SquareBracketedClauseCS::ownedTerms+=ExpCS || value
		serializationSteps[124] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 32 /*ExpCS*/, 0);
		// 125: IfExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[125] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 32 /*ExpCS*/, 0);
		// 126: IfThenExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[126] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 32 /*ExpCS*/, 0);
		// 127: TopLevelCS::ownedTransformations+=TransformationCS || half-new-line value half-new-line
		serializationSteps[127] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 113 /*TransformationCS*/, 5);
		// 128: CollectionLiteralExpCS::ownedType=CollectionTypeCS || value
		serializationSteps[128] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 10 /*CollectionTypeCS*/, 0);
		// 129: CollectionPatternCS::ownedType=CollectionTypeCS || value
		serializationSteps[129] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 10 /*CollectionTypeCS*/, 0);
		// 130: CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value
		serializationSteps[130] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 119 /*TypeExpWithoutMultiplicityCS*/, 0);
		// 131: MapLiteralExpCS::ownedType=MapTypeCS || value
		serializationSteps[131] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 51 /*MapTypeCS*/, 0);
		// 132: NavigatingArgCS::ownedType=TypeExpCS || value
		serializationSteps[132] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 118 /*TypeExpCS*/, 0);
		// 133: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[133] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 122 /*TypeLiteralWithMultiplicityCS*/, 2);
		// 134: VarDeclarationCS::ownedType=TypeExpCS || value
		serializationSteps[134] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_TYPE, 118 /*TypeExpCS*/, 0);
		// 135: VariableCS::ownedType=TypeExpCS || value
		serializationSteps[135] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 118 /*TypeExpCS*/, 0);
		// 136: MapLiteralPartCS::ownedValue=ExpCS || value
		serializationSteps[136] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 32 /*ExpCS*/, 0);
		// 137: MapTypeCS::ownedValueType=TypeExpCS || value
		serializationSteps[137] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 118 /*TypeExpCS*/, 0);
		// 138: VarDeclarationCS::ownedVarDeclarationIds+=VarDeclarationIdCS || value
		serializationSteps[138] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS, 141 /*VarDeclarationIdCS*/, 0);
		// 139: RelationCS::ownedVarDeclarations+=VarDeclarationCS || value
		serializationSteps[139] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_VAR_DECLARATIONS, 140 /*VarDeclarationCS*/, 0);
		// 140: LetExpCS::ownedVariables+=LetVariableCS || value
		serializationSteps[140] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 46 /*LetVariableCS*/, 0);
		// 141: RelationCS::ownedWhen=WhenCS || value
		serializationSteps[141] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHEN, 143 /*WhenCS*/, 0);
		// 142: RelationCS::ownedWhere=WhereCS || value
		serializationSteps[142] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.RELATION_CS__OWNED_WHERE, 144 /*WhereCS*/, 0);
		// 143: PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space
		serializationSteps[143] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, 139 /*UnrestrictedName*/, 14);
		// 144: NavigatingArgCS::prefix='|' || soft-space value soft-space
		serializationSteps[144] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 25 /* '|' */, 14);
		// 145: NavigatingArgCS::prefix=';' || no-space value soft-new-line
		serializationSteps[145] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 7 /* ';' */, 7);
		// 146: NavigatingArgCS::prefix=',' || no-space value soft-space
		serializationSteps[146] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ',' */, 8);
		// 147: DefaultValueCS::propertyId=UnrestrictedName || soft-space value soft-space
		serializationSteps[147] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__PROPERTY_ID, getCrossReference(QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS__PROPERTY_ID, "UnrestrictedName"), 139, 14);
		// 148: PropertyTemplateCS::propertyId=UnrestrictedName || soft-space value soft-space
		serializationSteps[148] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__PROPERTY_ID, getCrossReference(QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS__PROPERTY_ID, "UnrestrictedName"), 139, 14);
		// 149: KeyDeclCS::propertyIds+=UnrestrictedName || soft-space value soft-space
		serializationSteps[149] = createSerializationStepCrossReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__PROPERTY_IDS, getCrossReference(QVTrelationCSPackage.Literals.KEY_DECL_CS__PROPERTY_IDS, "UnrestrictedName"), 139, 14);
		// 150: ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space
		serializationSteps[150] = createSerializationStepCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, getCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, "UnrestrictedName"), 139, 14);
		// 151: ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space
		serializationSteps[151] = createSerializationStepCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, getCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, "UnrestrictedName"), 139, 14);
		// 152: CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space
		serializationSteps[152] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, 37 /*Identifier*/, 14);
		// 153: StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[153] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, 103 /*StringLiteral*/, 2);
		// 154: MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space
		serializationSteps[154] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 5 /* '*|+|?' */, 14);
		// 155: BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[155] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 15 /* 'false|true' */, 2);
		// 156: NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[156] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, 57 /*NUMBER_LITERAL*/, 2);
		// 157: SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[157] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, "UnrestrictedName"), 139, 14);
		// 158: MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space
		serializationSteps[158] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, 130 /*UPPER*/, 14);
		// 159: EnumerationLiteralCS::value=SIGNED || soft-space value soft-space
		serializationSteps[159] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, 92 /*SIGNED*/, 14);
		// 160: SimpleTargetElementCS::via?='via' || soft-space value soft-space
		serializationSteps[160] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 24 /* 'via' */, 14);
		// 161: '!serializable' || soft-space value soft-space
		serializationSteps[161] = createSerializationStepKeyword("!serializable", 14);
		// 162: '#' || no-space value no-space
		serializationSteps[162] = createSerializationStepKeyword("#", 6);
		// 163: '&&' || soft-space value soft-space
		serializationSteps[163] = createSerializationStepKeyword("&&", 14);
		// 164: '(' || value no-space
		serializationSteps[164] = createSerializationStepKeyword("(", 4);
		// 165: '(' || no-space value no-space
		serializationSteps[165] = createSerializationStepKeyword("(", 6);
		// 166: ')' || no-space value
		serializationSteps[166] = createSerializationStepKeyword(")", 1);
		// 167: '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[167] = createSerializationStepKeyword("*", 2);
		// 168: '++' || soft-space value soft-space
		serializationSteps[168] = createSerializationStepKeyword("++", 14);
		// 169: ',' || no-space value soft-new-line
		serializationSteps[169] = createSerializationStepKeyword(",", 7);
		// 170: ',' || no-space value soft-space
		serializationSteps[170] = createSerializationStepKeyword(",", 8);
		// 171: '..' || no-space value no-space
		serializationSteps[171] = createSerializationStepKeyword("..", 6);
		// 172: ':' || soft-space value soft-space
		serializationSteps[172] = createSerializationStepKeyword(":", 14);
		// 173: ':' || no-space value no-space
		serializationSteps[173] = createSerializationStepKeyword(":", 6);
		// 174: '::' || no-space value no-space
		serializationSteps[174] = createSerializationStepKeyword("::", 6);
		// 175: ';' || no-space value soft-new-line half-new-line
		serializationSteps[175] = createSerializationStepKeyword(";", 15);
		// 176: ';' || no-space value soft-new-line
		serializationSteps[176] = createSerializationStepKeyword(";", 7);
		// 177: '=' || soft-space value soft-space
		serializationSteps[177] = createSerializationStepKeyword("=", 14);
		// 178: '?' || soft-space value soft-space
		serializationSteps[178] = createSerializationStepKeyword("?", 14);
		// 179: 'Lambda' || soft-space value soft-space
		serializationSteps[179] = createSerializationStepKeyword("Lambda", 14);
		// 180: 'Tuple' || soft-space value soft-space
		serializationSteps[180] = createSerializationStepKeyword("Tuple", 14);
		// 181: '[' || no-space value no-space
		serializationSteps[181] = createSerializationStepKeyword("[", 6);
		// 182: ']' || no-space value
		serializationSteps[182] = createSerializationStepKeyword("]", 1);
		// 183: 'attribute' || soft-space value soft-space
		serializationSteps[183] = createSerializationStepKeyword("attribute", 14);
		// 184: 'body' || soft-space value soft-space
		serializationSteps[184] = createSerializationStepKeyword("body", 14);
		// 185: 'class' || soft-space value soft-space
		serializationSteps[185] = createSerializationStepKeyword("class", 14);
		// 186: 'datatype' || soft-space value soft-space
		serializationSteps[186] = createSerializationStepKeyword("datatype", 14);
		// 187: 'default_values' || soft-space value soft-space
		serializationSteps[187] = createSerializationStepKeyword("default_values", 14);
		// 188: 'dependsOn' || soft-space value soft-space
		serializationSteps[188] = createSerializationStepKeyword("dependsOn", 14);
		// 189: 'derivation' || soft-space value soft-space
		serializationSteps[189] = createSerializationStepKeyword("derivation", 14);
		// 190: 'domain' || soft-space value soft-space
		serializationSteps[190] = createSerializationStepKeyword("domain", 14);
		// 191: 'else' || soft-new-line pop value push soft-space
		serializationSteps[191] = createSerializationStepKeyword("else", 27);
		// 192: 'elseif' || soft-new-line pop soft-space value push soft-space
		serializationSteps[192] = createSerializationStepKeyword("elseif", 28);
		// 193: 'endif' || soft-new-line pop value soft-space
		serializationSteps[193] = createSerializationStepKeyword("endif", 19);
		// 194: 'enum' || soft-space value soft-space
		serializationSteps[194] = createSerializationStepKeyword("enum", 14);
		// 195: 'extends' || soft-space value soft-space
		serializationSteps[195] = createSerializationStepKeyword("extends", 14);
		// 196: 'if' || soft-new-line value push soft-space
		serializationSteps[196] = createSerializationStepKeyword("if", 21);
		// 197: 'implementedby' || soft-space value soft-space
		serializationSteps[197] = createSerializationStepKeyword("implementedby", 14);
		// 198: 'import' || soft-space value soft-space
		serializationSteps[198] = createSerializationStepKeyword("import", 14);
		// 199: 'in' || soft-space value soft-space
		serializationSteps[199] = createSerializationStepKeyword("in", 14);
		// 200: 'in' || soft-space pop value soft-new-line
		serializationSteps[200] = createSerializationStepKeyword("in", 22);
		// 201: 'initial' || soft-space value soft-space
		serializationSteps[201] = createSerializationStepKeyword("initial", 14);
		// 202: 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[202] = createSerializationStepKeyword("invalid", 2);
		// 203: 'iterates' || soft-space value soft-space
		serializationSteps[203] = createSerializationStepKeyword("iterates", 14);
		// 204: 'key' || soft-space value soft-space
		serializationSteps[204] = createSerializationStepKeyword("key", 14);
		// 205: 'let' || soft-space value push
		serializationSteps[205] = createSerializationStepKeyword("let", 13);
		// 206: 'literal' || soft-space value soft-space
		serializationSteps[206] = createSerializationStepKeyword("literal", 14);
		// 207: 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[207] = createSerializationStepKeyword("null", 2);
		// 208: 'operation' || soft-space value soft-space
		serializationSteps[208] = createSerializationStepKeyword("operation", 14);
		// 209: 'opposite' || soft-space value soft-space
		serializationSteps[209] = createSerializationStepKeyword("opposite", 14);
		// 210: 'overrides' || soft-space value soft-space
		serializationSteps[210] = createSerializationStepKeyword("overrides", 14);
		// 211: 'package' || soft-space value soft-space
		serializationSteps[211] = createSerializationStepKeyword("package", 14);
		// 212: 'pre' || soft-space value soft-space
		serializationSteps[212] = createSerializationStepKeyword("pre", 14);
		// 213: 'primitive' || soft-space value soft-space
		serializationSteps[213] = createSerializationStepKeyword("primitive", 14);
		// 214: 'property' || soft-space value soft-space
		serializationSteps[214] = createSerializationStepKeyword("property", 14);
		// 215: 'query' || soft-space value soft-space
		serializationSteps[215] = createSerializationStepKeyword("query", 14);
		// 216: 'relation' || soft-space value soft-space
		serializationSteps[216] = createSerializationStepKeyword("relation", 14);
		// 217: 'replace' || soft-space value soft-space
		serializationSteps[217] = createSerializationStepKeyword("replace", 14);
		// 218: 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[218] = createSerializationStepKeyword("self", 2);
		// 219: 'target' || soft-space value soft-space
		serializationSteps[219] = createSerializationStepKeyword("target", 14);
		// 220: 'then' || pop value push soft-space
		serializationSteps[220] = createSerializationStepKeyword("then", 17);
		// 221: 'then' || pop soft-space value push soft-space
		serializationSteps[221] = createSerializationStepKeyword("then", 26);
		// 222: 'throws' || soft-space value soft-space
		serializationSteps[222] = createSerializationStepKeyword("throws", 14);
		// 223: 'transformation' || soft-space value soft-space
		serializationSteps[223] = createSerializationStepKeyword("transformation", 14);
		// 224: 'when' || soft-space value soft-space
		serializationSteps[224] = createSerializationStepKeyword("when", 14);
		// 225: 'where' || soft-space value soft-space
		serializationSteps[225] = createSerializationStepKeyword("where", 14);
		// 226: 'with' || value
		serializationSteps[226] = createSerializationStepKeyword("with", 0);
		// 227: '{' || value
		serializationSteps[227] = createSerializationStepKeyword("{", 0);
		// 228: '{' || soft-space value no-space
		serializationSteps[228] = createSerializationStepKeyword("{", 12);
		// 229: '{' || soft-new-line value push soft-new-line
		serializationSteps[229] = createSerializationStepKeyword("{", 20);
		// 230: '{' || soft-space value push no-space
		serializationSteps[230] = createSerializationStepKeyword("{", 23);
		// 231: '{' || soft-space value push soft-new-line
		serializationSteps[231] = createSerializationStepKeyword("{", 24);
		// 232: '|?' || no-space value no-space
		serializationSteps[232] = createSerializationStepKeyword("|?", 6);
		// 233: '}' || value
		serializationSteps[233] = createSerializationStepKeyword("}", 0);
		// 234: '}' || soft-new-line pop value
		serializationSteps[234] = createSerializationStepKeyword("}", 10);
		// 235: '}' || pop soft-new-line value soft-new-line
		serializationSteps[235] = createSerializationStepKeyword("}", 16);
		// 236: '}' || soft-new-line pop value soft-new-line
		serializationSteps[236] = createSerializationStepKeyword("}", 18);
		// 237: '}' || half-new-line no-space pop value soft-space
		serializationSteps[237] = createSerializationStepKeyword("}", 25);
		// 238: '}' || no-space value soft-space
		serializationSteps[238] = createSerializationStepKeyword("}", 8);
		// 239: '}' || pop value soft-new-line
		serializationSteps[239] = createSerializationStepKeyword("}", 9);
		// 240: 1*1-steps || no-space value
		serializationSteps[240] = createSerializationStepSequence((-1/*V-1*/ << 4) | 0/*[1]*/, 1, 1);
		// 241: 1*1-steps || soft-space value no-space
		serializationSteps[241] = createSerializationStepSequence((-1/*V-1*/ << 4) | 0/*[1]*/, 1, 12);
		// 242: V00*1-steps || value
		serializationSteps[242] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 1, 0);
		// 243: V00*1-steps || value
		serializationSteps[243] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 1, 0);
		// 244: V00*1-steps || value half-new-line
		serializationSteps[244] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 1, 3);
		// 245: V00*1-steps || value
		serializationSteps[245] = createSerializationStepSequence((0/*V0*/ << 4) | 3/*[+]*/, 1, 0);
		// 246: V00*10-steps || value
		serializationSteps[246] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 10, 0);
		// 247: V00*2-steps || value
		serializationSteps[247] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 2, 0);
		// 248: V00*2-steps || value
		serializationSteps[248] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 2, 0);
		// 249: V00*3-steps || value
		serializationSteps[249] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 3, 0);
		// 250: V00*4-steps || value
		serializationSteps[250] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 4, 0);
		// 251: V00*5-steps || value
		serializationSteps[251] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 5, 0);
		// 252: V00*5-steps || value
		serializationSteps[252] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 5, 0);
		// 253: V00*6-steps || value
		serializationSteps[253] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 6, 0);
		// 254: V00*7-steps || value
		serializationSteps[254] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 7, 0);
		// 255: V00*8-steps || value
		serializationSteps[255] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 8, 0);
		// 256: V01*1-steps || value
		serializationSteps[256] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 1, 0);
		// 257: V01*1-steps || value
		serializationSteps[257] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 1, 0);
		// 258: V01*10-steps || value
		serializationSteps[258] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 10, 0);
		// 259: V01*2-steps || value
		serializationSteps[259] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 2, 0);
		// 260: V01*2-steps || value
		serializationSteps[260] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 2, 0);
		// 261: V01*3-steps || value
		serializationSteps[261] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 3, 0);
		// 262: V01*4-steps || value
		serializationSteps[262] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 4, 0);
		// 263: V01*7-steps || value
		serializationSteps[263] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 7, 0);
		// 264: V01*9-steps || value
		serializationSteps[264] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 9, 0);
		// 265: V10*1-steps || value
		serializationSteps[265] = createSerializationStepSequence((10/*V10*/ << 4) | 1/*[?]*/, 1, 0);
		// 266: V02*1-steps || value
		serializationSteps[266] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 1, 0);
		// 267: V02*1-steps || value
		serializationSteps[267] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 1, 0);
		// 268: V02*1-steps || value
		serializationSteps[268] = createSerializationStepSequence((2/*V2*/ << 4) | 3/*[+]*/, 1, 0);
		// 269: V02*10-steps || value
		serializationSteps[269] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 10, 0);
		// 270: V02*2-steps || value
		serializationSteps[270] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 2, 0);
		// 271: V02*2-steps || value
		serializationSteps[271] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 2, 0);
		// 272: V02*3-steps || value
		serializationSteps[272] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 3, 0);
		// 273: V02*4-steps || value
		serializationSteps[273] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 4, 0);
		// 274: V02*5-steps || value
		serializationSteps[274] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 5, 0);
		// 275: V02*6-steps || value
		serializationSteps[275] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 6, 0);
		// 276: V03*1-steps || value
		serializationSteps[276] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 1, 0);
		// 277: V03*1-steps || value
		serializationSteps[277] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 1, 0);
		// 278: V03*1-steps || value
		serializationSteps[278] = createSerializationStepSequence((3/*V3*/ << 4) | 3/*[+]*/, 1, 0);
		// 279: V03*10-steps || value
		serializationSteps[279] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 10, 0);
		// 280: V03*2-steps || value
		serializationSteps[280] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 2, 0);
		// 281: V03*2-steps || value
		serializationSteps[281] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 2, 0);
		// 282: V03*3-steps || value
		serializationSteps[282] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 3, 0);
		// 283: V03*4-steps || value
		serializationSteps[283] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 4, 0);
		// 284: V03*5-steps || value
		serializationSteps[284] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 5, 0);
		// 285: V04*1-steps || value
		serializationSteps[285] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 1, 0);
		// 286: V04*1-steps || value
		serializationSteps[286] = createSerializationStepSequence((4/*V4*/ << 4) | 3/*[+]*/, 1, 0);
		// 287: V04*10-steps || value
		serializationSteps[287] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 10, 0);
		// 288: V04*2-steps || value
		serializationSteps[288] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 2, 0);
		// 289: V04*2-steps || value
		serializationSteps[289] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 2, 0);
		// 290: V04*3-steps || value
		serializationSteps[290] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 3, 0);
		// 291: V04*4-steps || value
		serializationSteps[291] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 4, 0);
		// 292: V04*5-steps || value
		serializationSteps[292] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 5, 0);
		// 293: V04*5-steps || value
		serializationSteps[293] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 5, 0);
		// 294: V05*1-steps || value
		serializationSteps[294] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 1, 0);
		// 295: V05*1-steps || value
		serializationSteps[295] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 1, 0);
		// 296: V05*1-steps || value
		serializationSteps[296] = createSerializationStepSequence((5/*V5*/ << 4) | 3/*[+]*/, 1, 0);
		// 297: V05*2-steps || value
		serializationSteps[297] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 2, 0);
		// 298: V05*4-steps || value
		serializationSteps[298] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 4, 0);
		// 299: V05*5-steps || value
		serializationSteps[299] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 5, 0);
		// 300: V05*5-steps || value
		serializationSteps[300] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 5, 0);
		// 301: V06*1-steps || value
		serializationSteps[301] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 1, 0);
		// 302: V06*1-steps || value
		serializationSteps[302] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 1, 0);
		// 303: V06*2-steps || value
		serializationSteps[303] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 2, 0);
		// 304: V06*4-steps || value
		serializationSteps[304] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 4, 0);
		// 305: V06*5-steps || value
		serializationSteps[305] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 5, 0);
		// 306: V07*1-steps || value
		serializationSteps[306] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 1, 0);
		// 307: V07*1-steps || value
		serializationSteps[307] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 1, 0);
		// 308: V07*1-steps || value
		serializationSteps[308] = createSerializationStepSequence((7/*V7*/ << 4) | 3/*[+]*/, 1, 0);
		// 309: V07*4-steps || value
		serializationSteps[309] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 4, 0);
		// 310: V07*5-steps || value
		serializationSteps[310] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 5, 0);
		// 311: V08*1-steps || value
		serializationSteps[311] = createSerializationStepSequence((8/*V8*/ << 4) | 1/*[?]*/, 1, 0);
		// 312: V08*1-steps || value
		serializationSteps[312] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 1, 0);
		// 313: V08*1-steps || value
		serializationSteps[313] = createSerializationStepSequence((8/*V8*/ << 4) | 3/*[+]*/, 1, 0);
		// 314: V08*5-steps || value
		serializationSteps[314] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 5, 0);
		// 315: V09*1-steps || value
		serializationSteps[315] = createSerializationStepSequence((9/*V9*/ << 4) | 1/*[?]*/, 1, 0);
		// 316: V09*5-steps || value
		serializationSteps[316] = createSerializationStepSequence((9/*V9*/ << 4) | 2/*[*]*/, 5, 0);
		// 317: wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[317] = createSerializationStepWrapper(2);
		// 318: NamedElementCS::name=UnaryOperatorName || soft-space value soft-space
		serializationSteps[318] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 134 /*UnaryOperatorName*/, 14);
		// 319: NamedElementCS::name=UnrestrictedName || soft-space value soft-space
		serializationSteps[319] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 139 /*UnrestrictedName*/, 14);
		// 320: NamedElementCS::name=BinaryOperatorName || soft-space value soft-space
		serializationSteps[320] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 2 /*BinaryOperatorName*/, 14);
		// 321: NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space
		serializationSteps[321] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 25 /*EnumerationLiteralName*/, 14);
		// 322: RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value
		serializationSteps[322] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 59 /*NavigatingArgCS*/, 0);
		// 323: RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value
		serializationSteps[323] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, -1, new int[] { 62/*NavigatingCommaArgCS*/,63/*NavigatingSemiArgCS*/,61/*NavigatingBarArgCS*/}, 0);
		// 324: PathNameCS::ownedPathElements+=URIFirstPathElementCS || value
		serializationSteps[324] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 132 /*URIFirstPathElementCS*/, 0);
		// 325: PathNameCS::ownedPathElements+=FirstPathElementCS || value
		serializationSteps[325] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 34 /*FirstPathElementCS*/, 0);
		// 326: PathNameCS::ownedPathElements+=NextPathElementCS || value
		serializationSteps[326] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 66 /*NextPathElementCS*/, 0);
		// 327: OperatorExpCS::ownedRight=ExpCS || value
		serializationSteps[327] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 32 /*ExpCS*/, 0);
		// 328: OperatorExpCS::ownedRight=PrefixedLetExpCS || value
		serializationSteps[328] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 76 /*PrefixedLetExpCS*/, 0);
		// 329: OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value
		serializationSteps[329] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 77 /*PrefixedPrimaryExpCS*/, 0);
		// 330: TemplateVariableCS::ownedType=CollectionTypeCS || value
		serializationSteps[330] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 10 /*CollectionTypeCS*/, 0);
		// 331: TemplateVariableCS::ownedType=TypeExpCS || value
		serializationSteps[331] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 118 /*TypeExpCS*/, 0);
		// 332: TemplateVariableCS::ownedType=TypedRefCS || value
		serializationSteps[332] = createSerializationStepAssignedRuleCall(QVTrelationCSPackage.Literals.TEMPLATE_VARIABLE_CS__OWNED_TYPE, 127 /*TypedRefCS*/, 0);
		// 333: TypedElementCS::ownedType=TypeExpCS || value
		serializationSteps[333] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 118 /*TypeExpCS*/, 0);
		// 334: TypedElementCS::ownedType=TypedMultiplicityRefCS || value
		serializationSteps[334] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 126 /*TypedMultiplicityRefCS*/, 0);
		// 335: TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[335] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */, 14);
		// 336: TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[336] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */, 14);
		// 337: TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space
		serializationSteps[337] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */, 14);
		// 338: TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space
		serializationSteps[338] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */, 14);
		// 339: TypedElementCS::qualifiers+='definition' || soft-space value soft-space
		serializationSteps[339] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 13 /* 'definition' */, 14);
		// 340: TypedElementCS::qualifiers+='static' || soft-space value soft-space
		serializationSteps[340] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 21 /* 'static' */, 14);
		// 341: PathElementCS::referredElement=URI || soft-space value soft-space
		serializationSteps[341] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "URI"), 131, 14);
		// 342: PathElementCS::referredElement=UnreservedName || soft-space value soft-space
		serializationSteps[342] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnreservedName"), 137, 14);
		// 343: PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space
		serializationSteps[343] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnrestrictedName"), 139, 14);
	}

	/**
	 * Initialize the various serialization steps used to serialize a serialization rule.
	 */
	private void initSubstringSteps() {
		// 0: '->' : [no-space, value, no-space]
		substringSteps[0] = createSubstringStep("->", 6 /* no-space, value, no-space */);
		// 1: '.' : [no-space, value, no-space]
		substringSteps[1] = createSubstringStep(".", 6 /* no-space, value, no-space */);
		// 2: '?->' : [no-space, value, no-space]
		substringSteps[2] = createSubstringStep("?->", 6 /* no-space, value, no-space */);
		// 3: '?.' : [no-space, value, no-space]
		substringSteps[3] = createSubstringStep("?.", 6 /* no-space, value, no-space */);
		// 4: 'else' : [soft-new-line, pop, value, push, soft-space]
		substringSteps[4] = createSubstringStep("else", 27 /* soft-new-line, pop, value, push, soft-space */);
		// 5: 'endif' : [soft-new-line, pop, value, soft-space]
		substringSteps[5] = createSubstringStep("endif", 19 /* soft-new-line, pop, value, soft-space */);
		// 6: 'if' : [soft-new-line, value, push, soft-space]
		substringSteps[6] = createSubstringStep("if", 21 /* soft-new-line, value, push, soft-space */);
		// 7: 'in' : [soft-space, pop, value, soft-new-line]
		substringSteps[7] = createSubstringStep("in", 22 /* soft-space, pop, value, soft-new-line */);
		// 8: 'let' : [soft-space, value, push]
		substringSteps[8] = createSubstringStep("let", 13 /* soft-space, value, push */);
		// 9: 'then' : [pop, soft-space, value, push, soft-space]
		substringSteps[9] = createSubstringStep("then", 26 /* pop, soft-space, value, push, soft-space */);
	}
}

//	Commented imports ensure the Xtend synthesis provides a true import allowing unqualified annotated usage
//	import Inject;
//	import NonNull;
//	import Nullable;
//	import BaseCommentSegmentSupport;
//	import EClassValue;
//	import EReference_TargetGrammarRuleVector;
//	import EnumerationValue;
//	import EnumerationValueMultiple;
//	import EnumerationValueSingle;
//	import GrammarCardinality;
//	import GrammarRuleValue;
//	import GrammarRuleVector;
//	import SerializationMatchStep;
//	import SerializationMatchTerm;
//	import SerializationMetaData;
//	import SerializationRule;
//	import SerializationFeature;
//	import SerializationSegment;
//	import CustomSerializationSegment;
//	import SerializationStep;
//	import SubstringStep;
//	import TerminalRuleValue;
//	import BaseCSPackage;
//	import EssentialOCLCSPackage;
//	import QVTbaseCSPackage;
//	import QVTrelationCSPackage;
//	import Grammar;
//	import GrammarProvider;
