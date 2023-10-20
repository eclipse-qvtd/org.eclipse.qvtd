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
package org.eclipse.qvtd.xtext.qvtbase.serializer;

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
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.service.GrammarProvider;

/******* This file is 100% auto-generated - do not edit it *******/

/**
 * The QVTbaseSerializationMetaData singleton provides the metadata to support a
 * model to text serialization of a parsed Xtext semantic model or to re-format an Xtext text node model.
 */
public class QVTbaseSerializationMetaData extends AbstractSerializationMetaData
{
	/**
	 * The Provider supports injected creation of the QVTbaseSerializationMetaData singleton.
	 */
	public static class Provider implements SerializationMetaData.Provider
	{
		private static @Nullable QVTbaseSerializationMetaData INSTANCE = null;

		@Inject
		private GrammarProvider grammarProvider;

		@Override
		public synchronized @NonNull SerializationMetaData get() {
			// synchronized synchronizes the creation of this singleton.
			// It does not imply that the overall application is threadsafe.
			QVTbaseSerializationMetaData instance = INSTANCE;
			if (instance == null) {
				assert grammarProvider != null;
				Grammar grammar = grammarProvider.getGrammar(Provider.class);
				assert grammar != null;
				INSTANCE = instance = new QVTbaseSerializationMetaData(grammar);
			}
			return instance;
		}
	}

	private final @NonNull EClassValue @NonNull [] eClassValues = new @NonNull EClassValue[61];
	private final @NonNull EnumerationValue @NonNull [] enumerationValues = new @NonNull EnumerationValue[22];
	private final @NonNull GrammarRuleValue @NonNull [] grammarRuleValues = new @NonNull GrammarRuleValue[119];
	private final @NonNull GrammarRuleVector @NonNull [] grammarRuleVectors = new @NonNull GrammarRuleVector[60];
	private final @NonNull SerializationMatchStep @NonNull [] serializationMatchSteps = new @NonNull SerializationMatchStep[295];
	private final @NonNull SerializationMatchTerm @NonNull [] serializationMatchTerms = new @NonNull SerializationMatchTerm[227];
	private final @NonNull SerializationRule @NonNull [] serializationRules = new @NonNull SerializationRule[135];
	private final @NonNull SerializationSegment @NonNull [] @NonNull [] serializationSegments = new @NonNull SerializationSegment @NonNull [9] @NonNull [];
	private final @NonNull SerializationStep @NonNull [] serializationSteps = new @NonNull SerializationStep[233];
	private final @NonNull SubstringStep @NonNull [] substringSteps = new @NonNull SubstringStep[4];
	private final @Nullable String @Nullable [] multipleLineCommentMidfixes = new @Nullable String[] {" *"};
	private final @NonNull String @Nullable [] multipleLineCommentPrefixes = new @NonNull String[] {"/*"};
	private final @NonNull String @Nullable [] multipleLineCommentSuffixes = new @NonNull String[] {"*/"};
	private final @NonNull String @Nullable [] singleLineCommentPrefixes = new @NonNull String[] {"--"};

	private QVTbaseSerializationMetaData(@NonNull Grammar grammar) {
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
		return 104;
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
		return 103;
	}

	@Override
	protected int getLastGlobalSerializationStepLiteralIndex() {
		return 150;
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
				87 /* AttributeCS-4: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] ';' */,
				83 /* AttributeCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				85 /* AttributeCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				88 /* AttributeCS-5: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V5:?] ';')[V4:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] '}' */,
				84 /* AttributeCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				86 /* AttributeCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS,
					29) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					47) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[1] = new EClassValue(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS,
			createSerializationRules(
				18 /* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			), null
		);
		eClassValues[2] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS,
			createSerializationRules(
				20 /* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
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
				22 /* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */,
				21 /* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION,
					58) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[4] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS,
			createSerializationRules(
				23 /* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */,
				71 /* TypeExpCS-4: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS,
					20) /* PatternExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE,
					2) /* CollectionTypeCS */
			}
		);
		eClassValues[5] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS,
			createSerializationRules(
				24 /* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				68 /* TypeExpCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				75 /* TypeLiteralWithMultiplicityCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				132 /* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE,
					44) /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */
			}
		);
		eClassValues[6] = new EClassValue(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS,
			createSerializationRules(
				89 /* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS,
					27) /* SimpleTargetElementCS */
			}
		);
		eClassValues[7] = new EClassValue(EssentialOCLCSPackage.Literals.CONTEXT_CS,
			createSerializationRules(
				36 /* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[8] = new EClassValue(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				25 /* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS,
					26) /* ShadowPartCS */
			}
		);
		eClassValues[9] = new EClassValue(BaseCSPackage.Literals.DATA_TYPE_CS,
			createSerializationRules(
				94 /* DataTypeCS-4: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] ';' */,
				90 /* DataTypeCS-0: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] ';' */,
				92 /* DataTypeCS-2: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] ';' */,
				95 /* DataTypeCS-5: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] '{' '}' */,
				91 /* DataTypeCS-1: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] '{' '}' */,
				93 /* DataTypeCS-3: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] '{' '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					37) /* TemplateSignatureCS */
			}
		);
		eClassValues[10] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_CS,
			createSerializationRules(
				100 /* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				96 /* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				98 /* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				101 /* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				97 /* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				99 /* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS,
					5) /* EnumerationLiteralCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					37) /* TemplateSignatureCS */
			}
		);
		eClassValues[11] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS,
			createSerializationRules(
				104 /* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				102 /* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				105 /* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				103 /* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			), null
		);
		eClassValues[12] = new EClassValue(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS,
			createSerializationRules(
				125 /* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				126 /* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[13] = new EClassValue(EssentialOCLCSPackage.Literals.IF_EXP_CS,
			createSerializationRules(
				28 /* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION,
					58) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS,
					4) /* ElseIfThenExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[14] = new EClassValue(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS,
			createSerializationRules(
				26 /* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[15] = new EClassValue(EssentialOCLCSPackage.Literals.INFIX_EXP_CS,
			createSerializationRules(
				27 /* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT,
					54) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[16] = new EClassValue(EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS,
			createSerializationRules(
				29 /* InvalidLiteralExpCS-0: 'invalid' */
			), null
		);
		eClassValues[17] = new EClassValue(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS,
			createSerializationRules(
				30 /* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[18] = new EClassValue(EssentialOCLCSPackage.Literals.LET_EXP_CS,
			createSerializationRules(
				31 /* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES,
					8) /* LetVariableCS */
			}
		);
		eClassValues[19] = new EClassValue(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS,
			createSerializationRules(
				32 /* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					25) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					40) /* TypeExpCS */
			}
		);
		eClassValues[20] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS,
			createSerializationRules(
				33 /* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS,
					9) /* MapLiteralPartCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE,
					10) /* MapTypeCS */
			}
		);
		eClassValues[21] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS,
			createSerializationRules(
				34 /* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS 'with' MapLiteralPartCS::ownedValue=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[22] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_TYPE_CS,
			createSerializationRules(
				35 /* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				69 /* TypeExpCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				76 /* TypeLiteralWithMultiplicityCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				133 /* TypedMultiplicityRefCS-3: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE,
					40) /* TypeExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE,
					40) /* TypeExpCS */
			}
		);
		eClassValues[23] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS,
			createSerializationRules(
				1 /* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */,
				4 /* MultiplicityCS-2: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] ']' */,
				2 /* MultiplicityCS-0: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] '|?' ']' */,
				3 /* MultiplicityCS-1: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] MultiplicityCS::isNullFree?='|1' ']' */
			), null
		);
		eClassValues[24] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS,
			createSerializationRules(
				7 /* MultiplicityCS-5: '[' MultiplicityStringCS::stringBounds='*|+|?' ']' */,
				5 /* MultiplicityCS-3: '[' MultiplicityStringCS::stringBounds='*|+|?' '|?' ']' */,
				6 /* MultiplicityCS-4: '[' MultiplicityStringCS::stringBounds='*|+|?' MultiplicityCS::isNullFree?='|1' ']' */,
				8 /* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			), null
		);
		eClassValues[25] = new EClassValue(EssentialOCLCSPackage.Literals.NAME_EXP_CS,
			createSerializationRules(
				37 /* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					3) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME,
					19) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					25) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES,
					30) /* SquareBracketedClauseCS */
			}
		);
		eClassValues[26] = new EClassValue(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS,
			createSerializationRules(
				42 /* NavigatingArgCS-4: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */,
				38 /* NavigatingArgCS-0: ':' NavigatingArgCS::ownedType=TypeExpCS */,
				41 /* NavigatingArgCS-3: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				39 /* NavigatingArgCS-1: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				40 /* NavigatingArgCS-2: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				43 /* NavigatingBarArgCS-0: NavigatingArgCS::prefix='|' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */,
				47 /* NavigatingCommaArgCS-3: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */,
				46 /* NavigatingCommaArgCS-2: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				44 /* NavigatingCommaArgCS-0: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				45 /* NavigatingCommaArgCS-1: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				48 /* NavigatingSemiArgCS-0: NavigatingArgCS::prefix=';' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR,
					0) /* CoIteratorVariableCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION,
					57) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE,
					40) /* TypeExpCS */
			}
		);
		eClassValues[27] = new EClassValue(EssentialOCLCSPackage.Literals.NESTED_EXP_CS,
			createSerializationRules(
				49 /* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[28] = new EClassValue(EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS,
			createSerializationRules(
				50 /* NullLiteralExpCS-0: 'null' */
			), null
		);
		eClassValues[29] = new EClassValue(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS,
			createSerializationRules(
				51 /* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			), null
		);
		eClassValues[30] = new EClassValue(BaseCSPackage.Literals.OPERATION_CS,
			createSerializationRules(
				110 /* OperationCS-4: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] ';' */,
				106 /* OperationCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				108 /* OperationCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				111 /* OperationCS-5: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				107 /* OperationCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */,
				109 /* OperationCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS,
					29) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS,
					49) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS,
					18) /* ParameterCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					37) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					47) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[31] = new EClassValue(BaseCSPackage.Literals.PARAMETER_CS,
			createSerializationRules(
				112 /* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					47) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[32] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_CS,
			createSerializationRules(
				0 /* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */,
				9 /* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */,
				80 /* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			), null
		);
		eClassValues[33] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS,
			createSerializationRules(
				79 /* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */
			), null
		);
		eClassValues[34] = new EClassValue(BaseCSPackage.Literals.PATH_NAME_CS,
			createSerializationRules(
				10 /* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				16 /* UnreservedPathNameCS-0: PathNameCS::ownedPathElements+=NextPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				60 /* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */,
				81 /* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS,
					51) /* FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS */
			}
		);
		eClassValues[35] = new EClassValue(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS,
			createSerializationRules(
				52 /* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE,
					40) /* TypeExpCS */
			}
		);
		eClassValues[36] = new EClassValue(EssentialOCLCSPackage.Literals.PREFIX_EXP_CS,
			createSerializationRules(
				53 /* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				54 /* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					55) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[37] = new EClassValue(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS,
			createSerializationRules(
				55 /* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				67 /* TypeExpCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				74 /* TypeLiteralWithMultiplicityCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				130 /* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */
			}
		);
		eClassValues[38] = new EClassValue(BaseCSPackage.Literals.REFERENCE_CS,
			createSerializationRules(
				117 /* ReferenceCS-4: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				113 /* ReferenceCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				115 /* ReferenceCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				118 /* ReferenceCS-5: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				114 /* ReferenceCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				116 /* ReferenceCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS,
					29) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					47) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[39] = new EClassValue(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				56 /* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS,
					14) /* NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS */
			}
		);
		eClassValues[40] = new EClassValue(EssentialOCLCSPackage.Literals.SELF_EXP_CS,
			createSerializationRules(
				57 /* SelfExpCS-0: 'self' */
			), null
		);
		eClassValues[41] = new EClassValue(EssentialOCLCSPackage.Literals.SHADOW_PART_CS,
			createSerializationRules(
				59 /* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */,
				58 /* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION,
					58) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[42] = new EClassValue(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS,
			createSerializationRules(
				119 /* SimpleTargetElementCS-0: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				121 /* SimpleTargetElementCS-2: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				123 /* SimpleTargetElementCS-4: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				120 /* SimpleTargetElementCS-1: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				122 /* SimpleTargetElementCS-3: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				124 /* SimpleTargetElementCS-5: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */
			), null
		);
		eClassValues[43] = new EClassValue(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				61 /* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[44] = new EClassValue(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS,
			createSerializationRules(
				62 /* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			), null
		);
		eClassValues[45] = new EClassValue(BaseCSPackage.Literals.STRUCTURED_CLASS_CS,
			createSerializationRules(
				127 /* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				128 /* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS,
					17) /* OperationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES,
					33) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					37) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES,
					49) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[46] = new EClassValue(QVTbaseCSPackage.Literals.TARGET_CS,
			createSerializationRules(
				129 /* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS,
					28) /* CompoundTargetElementCS|SimpleTargetElementCS */
			}
		);
		eClassValues[47] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_BINDING_CS,
			createSerializationRules(
				11 /* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS,
					36) /* TemplateParameterSubstitutionCS */
			}
		);
		eClassValues[48] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS,
			createSerializationRules(
				12 /* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER,
					59) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */
			}
		);
		eClassValues[49] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS,
			createSerializationRules(
				13 /* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS,
					45) /* TypeParameterCS */
			}
		);
		eClassValues[50] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS,
			createSerializationRules(
				63 /* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS,
					38) /* TupleLiteralPartCS */
			}
		);
		eClassValues[51] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS,
			createSerializationRules(
				64 /* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					40) /* TypeExpCS */
			}
		);
		eClassValues[52] = new EClassValue(BaseCSPackage.Literals.TUPLE_PART_CS,
			createSerializationRules(
				65 /* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					40) /* TypeExpCS */
			}
		);
		eClassValues[53] = new EClassValue(BaseCSPackage.Literals.TUPLE_TYPE_CS,
			createSerializationRules(
				66 /* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				72 /* TypeExpCS-5: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				77 /* TypeLiteralWithMultiplicityCS-3: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				134 /* TypedMultiplicityRefCS-4: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS,
					39) /* TuplePartCS */
			}
		);
		eClassValues[54] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS,
			createSerializationRules(
				73 /* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE,
					43) /* TypeLiteralWithMultiplicityCS */
			}
		);
		eClassValues[55] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS,
			createSerializationRules(
				70 /* TypeExpCS-3: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				78 /* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					3) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME,
					19) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD,
					56) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[56] = new EClassValue(BaseCSPackage.Literals.TYPE_PARAMETER_CS,
			createSerializationRules(
				14 /* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS,
					49) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[57] = new EClassValue(BaseCSPackage.Literals.TYPED_TYPE_REF_CS,
			createSerializationRules(
				15 /* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */,
				131 /* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING,
					35) /* TemplateBindingCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					11) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME,
					19) /* PathNameCS */
			}
		);
		eClassValues[58] = new EClassValue(EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS,
			createSerializationRules(
				82 /* UnlimitedNaturalLiteralExpCS-0: '*' */
			), null
		);
		eClassValues[59] = new EClassValue(EssentialOCLCSPackage.Literals.VARIABLE_CS,
			createSerializationRules(
				19 /* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					40) /* TypeExpCS */
			}
		);
		eClassValues[60] = new EClassValue(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS,
			createSerializationRules(
				17 /* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS,
					49) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
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
		// 4: '*|+|?'
		enumerationValues[4] = new EnumerationValueMultiple(new @NonNull String[]{"*", "+", "?"});
		// 5: ','
		enumerationValues[5] = new EnumerationValueSingle(",");
		// 6: ';'
		enumerationValues[6] = new EnumerationValueSingle(";");
		// 7: '@'
		enumerationValues[7] = new EnumerationValueSingle("@");
		// 8: 'Map'
		enumerationValues[8] = new EnumerationValueSingle("Map");
		// 9: 'Tuple'
		enumerationValues[9] = new EnumerationValueSingle("Tuple");
		// 10: 'abstract'
		enumerationValues[10] = new EnumerationValueSingle("abstract");
		// 11: 'definition'
		enumerationValues[11] = new EnumerationValueSingle("definition");
		// 12: 'false|true'
		enumerationValues[12] = new EnumerationValueMultiple(new @NonNull String[]{"false", "true"});
		// 13: 'input'
		enumerationValues[13] = new EnumerationValueSingle("input");
		// 14: 'interface'
		enumerationValues[14] = new EnumerationValueSingle("interface");
		// 15: 'output'
		enumerationValues[15] = new EnumerationValueSingle("output");
		// 16: 'primitive'
		enumerationValues[16] = new EnumerationValueSingle("primitive");
		// 17: 'serializable'
		enumerationValues[17] = new EnumerationValueSingle("serializable");
		// 18: 'static'
		enumerationValues[18] = new EnumerationValueSingle("static");
		// 19: 'via'
		enumerationValues[19] = new EnumerationValueSingle("via");
		// 20: '|'
		enumerationValues[20] = new EnumerationValueSingle("|");
		// 21: '|1'
		enumerationValues[21] = new EnumerationValueSingle("|1");
	}

	/**
	 * Initialize the various serialization rules for each grammar rule.
	 */
	private void initGrammarRuleValues() {
		grammarRuleValues[0] = new TerminalRuleValue(0, "ANY_OTHER");
		grammarRuleValues[1] = createParserRuleValue(1, "AttributeCS", -1,
			createSerializationRules(
				83	/* AttributeCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				84	/* AttributeCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				85	/* AttributeCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				86	/* AttributeCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				87	/* AttributeCS-4: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] ';' */,
				88	/* AttributeCS-5: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V5:?] ';')[V4:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "attribute" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[2] = createDataTypeRuleValue(2, "BinaryOperatorName", 6 /* [soft-space, value, soft-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[3] = createParserRuleValue(3, "BooleanLiteralExpCS", -1,
			createSerializationRules(
				18	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* symbol="true" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* symbol="false" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[4] = createParserRuleValue(4, "ClassCS", 34 /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS */,
			createSerializationRules(
				90	/* DataTypeCS-0: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] ';' */,
				91	/* DataTypeCS-1: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] '{' '}' */,
				92	/* DataTypeCS-2: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] ';' */,
				93	/* DataTypeCS-3: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] '{' '}' */,
				94	/* DataTypeCS-4: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] ';' */,
				95	/* DataTypeCS-5: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] '{' '}' */,
				96	/* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				97	/* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				98	/* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				99	/* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				100	/* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				101	/* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				127	/* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				128	/* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* StructuredClassCS : [value] | [value] */,
			(0 << 16) | 0	/* DataTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* EnumerationCS : [value] | [value] */
		);
		grammarRuleValues[5] = createParserRuleValue(5, "CoIteratorVariableCS", -1,
			createSerializationRules(
				19	/* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[6] = createParserRuleValue(6, "CollectionLiteralExpCS", -1,
			createSerializationRules(
				20	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[7] = createParserRuleValue(7, "CollectionLiteralPartCS", -1,
			createSerializationRules(
				21	/* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */,
				22	/* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 3	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedLastExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=PatternExpCS : [value] | [value] */
		);
		grammarRuleValues[8] = createParserRuleValue(8, "CollectionPatternCS", -1,
			createSerializationRules(
				23	/* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "++" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* restVariableName=Identifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[9] = createParserRuleValue(9, "CollectionTypeCS", -1,
			createSerializationRules(
				24	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* name=CollectionTypeIdentifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpWithoutMultiplicityCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedCollectionMultiplicity=MultiplicityCS? : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[10] = createDataTypeRuleValue(10, "CollectionTypeIdentifier", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[11] = createParserRuleValue(11, "CompoundTargetElementCS", -1,
			createSerializationRules(
				89	/* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=SimpleTargetElementCS* : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[12] = createParserRuleValue(12, "CurlyBracketedClauseCS", -1,
			createSerializationRules(
				25	/* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {CurlyBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[13] = new TerminalRuleValue(13, "DOUBLE_QUOTED_STRING");
		grammarRuleValues[14] = createParserRuleValue(14, "DataTypeCS", -1,
			createSerializationRules(
				90	/* DataTypeCS-0: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] ';' */,
				91	/* DataTypeCS-1: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] '{' '}' */,
				92	/* DataTypeCS-2: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] ';' */,
				93	/* DataTypeCS-3: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] '{' '}' */,
				94	/* DataTypeCS-4: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] ';' */,
				95	/* DataTypeCS-5: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] '{' '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* isPrimitive?="primitive"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "datatype" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 6	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[15] = new TerminalRuleValue(15, "ESCAPED_CHARACTER");
		grammarRuleValues[16] = new TerminalRuleValue(16, "ESCAPED_ID");
		grammarRuleValues[17] = createParserRuleValue(17, "ElseIfThenExpCS", -1,
			createSerializationRules(
				26	/* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "elseif" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 6	/* "then" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[18] = createParserRuleValue(18, "EnumerationCS", -1,
			createSerializationRules(
				96	/* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				97	/* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				98	/* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				99	/* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				100	/* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				101	/* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "enum" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 6	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedLiterals+=EnumerationLiteralCS* : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[19] = createParserRuleValue(19, "EnumerationLiteralCS", -1,
			createSerializationRules(
				102	/* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				103	/* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				104	/* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				105	/* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "literal" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=EnumerationLiteralName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* value=SIGNED : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[20] = createDataTypeRuleValue(20, "EnumerationLiteralName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[21] = createDataTypeRuleValue(21, "EssentialOCLInfixOperatorName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[22] = createDataTypeRuleValue(22, "EssentialOCLNavigationOperatorName", 3 /* [no-space, value, no-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[23] = createDataTypeRuleValue(23, "EssentialOCLReservedKeyword", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[24] = createDataTypeRuleValue(24, "EssentialOCLUnaryOperatorName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[25] = createDataTypeRuleValue(25, "EssentialOCLUnreservedName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[26] = createDataTypeRuleValue(26, "EssentialOCLUnrestrictedName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[27] = createParserRuleValue(27, "ExpCS", 56 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				18	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				20	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				27	/* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */,
				28	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				29	/* InvalidLiteralExpCS-0: 'invalid' */,
				30	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				31	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				33	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				37	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				49	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				50	/* NullLiteralExpCS-0: 'null' */,
				51	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				53	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				54	/* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */,
				57	/* SelfExpCS-0: 'self' */,
				62	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				63	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				73	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				82	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* PrefixedPrimaryExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* {InfixExpCS} : [value] | [value] */,
			(0 << 16) | 6	/* name=BinaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrefixedLetExpCS : [value] | [value] */
		);
		grammarRuleValues[28] = createParserRuleValue(28, "FirstPathElementCS", -1,
			createSerializationRules(
				0	/* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 6	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[29] = createDataTypeRuleValue(29, "ID", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[30] = new TerminalRuleValue(30, "INT");
		grammarRuleValues[31] = createDataTypeRuleValue(31, "Identifier", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[32] = createParserRuleValue(32, "IfExpCS", -1,
			createSerializationRules(
				28	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "if" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 6	/* "then" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedIfThenExpressions+=ElseIfThenExpCS* : [value] | [value] */,
			(0 << 16) | 6	/* "else" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedElseExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 6	/* "endif" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[33] = createDataTypeRuleValue(33, "InfixOperatorName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[34] = createParserRuleValue(34, "InvalidLiteralExpCS", -1,
			createSerializationRules(
				29	/* InvalidLiteralExpCS-0: 'invalid' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {InvalidLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 6	/* "invalid" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[35] = new TerminalRuleValue(35, "LETTER_CHARACTER");
		grammarRuleValues[36] = createDataTypeRuleValue(36, "LOWER", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[37] = createParserRuleValue(37, "LambdaLiteralExpCS", -1,
			createSerializationRules(
				30	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "Lambda" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpressionCS=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[38] = createParserRuleValue(38, "LetExpCS", -1,
			createSerializationRules(
				31	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "let" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 6	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[39] = createParserRuleValue(39, "LetVariableCS", -1,
			createSerializationRules(
				32	/* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[40] = new TerminalRuleValue(40, "ML_COMMENT");
		grammarRuleValues[41] = new TerminalRuleValue(41, "ML_SINGLE_QUOTED_STRING");
		grammarRuleValues[42] = createParserRuleValue(42, "MapLiteralExpCS", -1,
			createSerializationRules(
				33	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=MapTypeCS : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[43] = createParserRuleValue(43, "MapLiteralPartCS", -1,
			createSerializationRules(
				34	/* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS 'with' MapLiteralPartCS::ownedValue=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedKey=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValue=ExpCS : [value] | [value] */
		);
		grammarRuleValues[44] = createParserRuleValue(44, "MapTypeCS", -1,
			createSerializationRules(
				35	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* name="Map" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedKeyType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValueType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[45] = createParserRuleValue(45, "Model", -1,
			createSerializationRules(
				36	/* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			(0 << 16) | 2	/* ownedExpression=ExpCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[46] = createParserRuleValue(46, "MultiplicityBoundsCS", -1,
			createSerializationRules(
				1	/* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* lowerBound=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 3	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 6	/* upperBound=UPPER : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[47] = createParserRuleValue(47, "MultiplicityCS", -1,
			createSerializationRules(
				2	/* MultiplicityCS-0: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] '|?' ']' */,
				3	/* MultiplicityCS-1: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] MultiplicityCS::isNullFree?='|1' ']' */,
				4	/* MultiplicityCS-2: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] ']' */,
				5	/* MultiplicityCS-3: '[' MultiplicityStringCS::stringBounds='*|+|?' '|?' ']' */,
				6	/* MultiplicityCS-4: '[' MultiplicityStringCS::stringBounds='*|+|?' MultiplicityCS::isNullFree?='|1' ']' */,
				7	/* MultiplicityCS-5: '[' MultiplicityStringCS::stringBounds='*|+|?' ']' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 3	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityBoundsCS : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityStringCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 3	/* "|?" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 6	/* isNullFree?="|1" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[48] = createParserRuleValue(48, "MultiplicityStringCS", -1,
			createSerializationRules(
				8	/* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			),
			(0 << 16) | 6	/* stringBounds=("*"|"+"|"?") : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[49] = createDataTypeRuleValue(49, "NUMBER_LITERAL", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[50] = createParserRuleValue(50, "NameExpCS", -1,
			createSerializationRules(
				37	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedSquareBracketedClauses+=SquareBracketedClauseCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* isPre?="@" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "pre" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[51] = createParserRuleValue(51, "NavigatingArgCS", -1,
			createSerializationRules(
				38	/* NavigatingArgCS-0: ':' NavigatingArgCS::ownedType=TypeExpCS */,
				39	/* NavigatingArgCS-1: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				40	/* NavigatingArgCS-2: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				41	/* NavigatingArgCS-3: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				42	/* NavigatingArgCS-4: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 6	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[52] = createParserRuleValue(52, "NavigatingArgExpCS", 57 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				18	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				20	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				27	/* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */,
				28	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				29	/* InvalidLiteralExpCS-0: 'invalid' */,
				30	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				31	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				33	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				37	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				49	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				50	/* NullLiteralExpCS-0: 'null' */,
				51	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				53	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				54	/* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */,
				57	/* SelfExpCS-0: 'self' */,
				62	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				63	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				73	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				82	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* ExpCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[53] = createParserRuleValue(53, "NavigatingBarArgCS", -1,
			createSerializationRules(
				43	/* NavigatingBarArgCS-0: NavigatingArgCS::prefix='|' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* prefix="|" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[54] = createParserRuleValue(54, "NavigatingCommaArgCS", -1,
			createSerializationRules(
				44	/* NavigatingCommaArgCS-0: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				45	/* NavigatingCommaArgCS-1: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				46	/* NavigatingCommaArgCS-2: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				47	/* NavigatingCommaArgCS-3: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* prefix="," : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 6	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[55] = createParserRuleValue(55, "NavigatingSemiArgCS", -1,
			createSerializationRules(
				48	/* NavigatingSemiArgCS-0: NavigatingArgCS::prefix=';' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* prefix=";" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[56] = createDataTypeRuleValue(56, "NavigationOperatorName", 6 /* [soft-space, value, soft-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[57] = createParserRuleValue(57, "NestedExpCS", -1,
			createSerializationRules(
				49	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[58] = createParserRuleValue(58, "NextPathElementCS", -1,
			createSerializationRules(
				9	/* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */
			),
			(0 << 16) | 6	/* referredElement=UnreservedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[59] = createParserRuleValue(59, "NullLiteralExpCS", -1,
			createSerializationRules(
				50	/* NullLiteralExpCS-0: 'null' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {NullLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 6	/* "null" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[60] = createParserRuleValue(60, "NumberLiteralExpCS", -1,
			createSerializationRules(
				51	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			),
			(0 << 16) | 2	/* symbol=NUMBER_LITERAL : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[61] = createParserRuleValue(61, "OperationCS", -1,
			createSerializationRules(
				106	/* OperationCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				107	/* OperationCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */,
				108	/* OperationCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] ';' */,
				109	/* OperationCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V3:*])[V2:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V4:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V6:*])[V5:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V8:+] '}')[V7:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V10:?] ';')[V9:*] '}' */,
				110	/* OperationCS-4: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] ';' */,
				111	/* OperationCS-5: 'operation' (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] NamedElementCS::name=UnrestrictedName '(' (OperationCS::ownedParameters+=ParameterCS (',' OperationCS::ownedParameters+=ParameterCS)[V2:*])[V1:?] ')' (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V3:?] ('throws' OperationCS::ownedExceptions+=TypedRefCS (',' OperationCS::ownedExceptions+=TypedRefCS)[V5:*])[V4:?] ('{' (TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique')[V7:+] '}')[V6:?] '{' ('body' ':' (OperationCS::ownedBodyExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "operation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "throws" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "body" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedBodyExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[62] = createParserRuleValue(62, "ParameterCS", -1,
			createSerializationRules(
				112	/* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[63] = createParserRuleValue(63, "PathNameCS", -1,
			createSerializationRules(
				10	/* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 3	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[64] = createParserRuleValue(64, "PatternExpCS", -1,
			createSerializationRules(
				52	/* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* patternVariableName=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatternType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[65] = createParserRuleValue(65, "PrefixedLetExpCS", 23 /* LetExpCS|PrefixedLetExpCS */,
			createSerializationRules(
				31	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				53	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PrefixExpCS} : [value] | [value] */,
			(0 << 16) | 6	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedLetExpCS : [value] | [value] */,
			(0 << 16) | 0	/* LetExpCS : [value] | [value] */
		);
		grammarRuleValues[66] = createParserRuleValue(66, "PrefixedPrimaryExpCS", 54 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				18	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				20	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				28	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				29	/* InvalidLiteralExpCS-0: 'invalid' */,
				30	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				33	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				37	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				49	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				50	/* NullLiteralExpCS-0: 'null' */,
				51	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				54	/* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */,
				57	/* SelfExpCS-0: 'self' */,
				62	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				63	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				73	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				82	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PrefixExpCS} : [value] | [value] */,
			(0 << 16) | 6	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedPrimaryExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrimaryExpCS : [value] | [value] */
		);
		grammarRuleValues[67] = createParserRuleValue(67, "PrimaryExpCS", 53 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				18	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				20	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */,
				28	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */,
				29	/* InvalidLiteralExpCS-0: 'invalid' */,
				30	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */,
				33	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */,
				37	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */,
				49	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */,
				50	/* NullLiteralExpCS-0: 'null' */,
				51	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				57	/* SelfExpCS-0: 'self' */,
				62	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				63	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */,
				73	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */,
				82	/* UnlimitedNaturalLiteralExpCS-0: '*' */
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
		grammarRuleValues[68] = createParserRuleValue(68, "PrimitiveLiteralExpCS", 52 /* BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
			createSerializationRules(
				18	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */,
				29	/* InvalidLiteralExpCS-0: 'invalid' */,
				50	/* NullLiteralExpCS-0: 'null' */,
				51	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */,
				62	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */,
				82	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* NumberLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* StringLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* BooleanLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* UnlimitedNaturalLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* InvalidLiteralExpCS : [value] | [value] */,
			(0 << 16) | 0	/* NullLiteralExpCS : [value] | [value] */
		);
		grammarRuleValues[69] = createParserRuleValue(69, "PrimitiveTypeCS", -1,
			createSerializationRules(
				55	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */
			),
			(0 << 16) | 6	/* name=PrimitiveTypeIdentifier : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[70] = createDataTypeRuleValue(70, "PrimitiveTypeIdentifier", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[71] = createDataTypeRuleValue(71, "QVTbaseUnrestrictedName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[72] = createParserRuleValue(72, "ReferenceCS", -1,
			createSerializationRules(
				113	/* ReferenceCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				114	/* ReferenceCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				115	/* ReferenceCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				116	/* ReferenceCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				117	/* ReferenceCS-4: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				118	/* ReferenceCS-5: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "property" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 3	/* "#" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 6	/* referredOpposite=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* qualifiers+="composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[73] = createParserRuleValue(73, "RoundBracketedClauseCS", -1,
			createSerializationRules(
				56	/* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {RoundBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=NavigatingArgCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)* : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[74] = createDataTypeRuleValue(74, "SIGNED", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[75] = new TerminalRuleValue(75, "SIMPLE_ID");
		grammarRuleValues[76] = new TerminalRuleValue(76, "SINGLE_QUOTED_STRING");
		grammarRuleValues[77] = new TerminalRuleValue(77, "SL_COMMENT");
		grammarRuleValues[78] = createParserRuleValue(78, "SelfExpCS", -1,
			createSerializationRules(
				57	/* SelfExpCS-0: 'self' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {SelfExpCS} : [value] | [value] */,
			(0 << 16) | 6	/* "self" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[79] = createParserRuleValue(79, "ShadowPartCS", -1,
			createSerializationRules(
				58	/* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */,
				59	/* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* referredProperty=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 0	/* ownedInitExpression=StringLiteralExpCS : [value] | [value] */
		);
		grammarRuleValues[80] = createParserRuleValue(80, "SimplePathNameCS", -1,
			createSerializationRules(
				60	/* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */
			),
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */
		);
		grammarRuleValues[81] = createParserRuleValue(81, "SimpleTargetElementCS", -1,
			createSerializationRules(
				119	/* SimpleTargetElementCS-0: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				120	/* SimpleTargetElementCS-1: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				121	/* SimpleTargetElementCS-2: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				122	/* SimpleTargetElementCS-3: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				123	/* SimpleTargetElementCS-4: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				124	/* SimpleTargetElementCS-5: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* input?="input" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* output?="output" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* via?="via" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* typedModel=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "iterates" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 6	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[82] = createParserRuleValue(82, "SpecificationCS", -1,
			createSerializationRules(
				125	/* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				126	/* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 6	/* exprString=UNQUOTED_STRING : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[83] = createParserRuleValue(83, "SquareBracketedClauseCS", -1,
			createSerializationRules(
				61	/* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 3	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[84] = createDataTypeRuleValue(84, "StringLiteral", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[85] = createParserRuleValue(85, "StringLiteralExpCS", -1,
			createSerializationRules(
				62	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			),
			(0 << 16) | 2	/* segments+=StringLiteral+ : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[86] = createParserRuleValue(86, "StructuralFeatureCS", 33 /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
			createSerializationRules(
				83	/* AttributeCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				84	/* AttributeCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				85	/* AttributeCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				86	/* AttributeCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */,
				87	/* AttributeCS-4: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] ';' */,
				88	/* AttributeCS-5: 'attribute' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V1:?] ('{' (TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile')[V3:+] '}')[V2:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V5:?] ';')[V4:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] '}' */,
				113	/* ReferenceCS-0: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				114	/* ReferenceCS-1: TypedElementCS::qualifiers+='definition' (TypedElementCS::qualifiers+='static')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				115	/* ReferenceCS-2: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] ';' */,
				116	/* ReferenceCS-3: TypedElementCS::qualifiers+='static' (TypedElementCS::qualifiers+='definition')[V0:?] 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V1:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V2:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V3:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V5:+] '}')[V4:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V7:?] ';')[V6:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V9:?] ';')[V8:*] '}' */,
				117	/* ReferenceCS-4: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] ';' */,
				118	/* ReferenceCS-5: 'property' NamedElementCS::name=UnrestrictedName ('#' ReferenceCS::referredOpposite=UnrestrictedName)[V0:?] (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V1:?] ('=' StructuralFeatureCS::default=SINGLE_QUOTED_STRING)[V2:?] ('{' (TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile')[V4:+] '}')[V3:?] '{' ('derivation' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V6:?] ';')[V5:*] ('initial' ':' (StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS)[V8:?] ';')[V7:*] '}' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* AttributeCS : [value] | [value] */,
			(0 << 16) | 0	/* ReferenceCS : [value] | [value] */
		);
		grammarRuleValues[87] = createParserRuleValue(87, "StructuredClassCS", -1,
			createSerializationRules(
				127	/* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				128	/* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* isAbstract?="abstract"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* "class" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 6	/* isInterface?="interface"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedOperations+=OperationCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedProperties+=StructuralFeatureCS : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[88] = createParserRuleValue(88, "TargetCS", -1,
			createSerializationRules(
				129	/* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "target" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)* : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 4	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[89] = createParserRuleValue(89, "TemplateBindingCS", -1,
			createSerializationRules(
				11	/* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedSubstitutions+=TemplateParameterSubstitutionCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSubstitutions+=TemplateParameterSubstitutionCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[90] = createParserRuleValue(90, "TemplateParameterSubstitutionCS", -1,
			createSerializationRules(
				12	/* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			(0 << 16) | 2	/* ownedActualParameter=TypeRefCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[91] = createParserRuleValue(91, "TemplateSignatureCS", -1,
			createSerializationRules(
				13	/* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[92] = createParserRuleValue(92, "TupleLiteralExpCS", -1,
			createSerializationRules(
				63	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* "Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[93] = createParserRuleValue(93, "TupleLiteralPartCS", -1,
			createSerializationRules(
				64	/* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 6	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[94] = createParserRuleValue(94, "TuplePartCS", -1,
			createSerializationRules(
				65	/* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[95] = createParserRuleValue(95, "TupleTypeCS", -1,
			createSerializationRules(
				66	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 6	/* name="Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 5	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[96] = createParserRuleValue(96, "TypeExpCS", -1,
			createSerializationRules(
				67	/* TypeExpCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				68	/* TypeExpCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				69	/* TypeExpCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				70	/* TypeExpCS-3: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				71	/* TypeExpCS-4: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				72	/* TypeExpCS-5: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypeExpWithoutMultiplicityCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[97] = createParserRuleValue(97, "TypeExpWithoutMultiplicityCS", 44 /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
			createSerializationRules(
				23	/* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */,
				24	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				35	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				55	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				66	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				78	/* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* TypeNameExpCS : [value] | [value] */,
			(0 << 16) | 0	/* TypeLiteralCS : [value] | [value] */,
			(0 << 16) | 0	/* CollectionPatternCS : [value] | [value] */
		);
		grammarRuleValues[98] = createParserRuleValue(98, "TypeLiteralCS", 42 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS */,
			createSerializationRules(
				24	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				35	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				55	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				66	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* PrimitiveTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* MapTypeCS : [value] | [value] */,
			(0 << 16) | 0	/* TupleTypeCS : [value] | [value] */
		);
		grammarRuleValues[99] = createParserRuleValue(99, "TypeLiteralExpCS", -1,
			createSerializationRules(
				73	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			(0 << 16) | 2	/* ownedType=TypeLiteralWithMultiplicityCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[100] = createParserRuleValue(100, "TypeLiteralWithMultiplicityCS", -1,
			createSerializationRules(
				74	/* TypeLiteralWithMultiplicityCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				75	/* TypeLiteralWithMultiplicityCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				76	/* TypeLiteralWithMultiplicityCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				77	/* TypeLiteralWithMultiplicityCS-3: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypeLiteralCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[101] = createParserRuleValue(101, "TypeNameExpCS", -1,
			createSerializationRules(
				78	/* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 8	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedPatternGuard=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[102] = createParserRuleValue(102, "TypeParameterCS", -1,
			createSerializationRules(
				14	/* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 6	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "&&" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */
		);
		grammarRuleValues[103] = createParserRuleValue(103, "TypeRefCS", 59 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
			createSerializationRules(
				24	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				35	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				55	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				66	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				15	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */,
				17	/* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* WildcardTypeRefCS : [value] | [value] */
		);
		grammarRuleValues[104] = createParserRuleValue(104, "TypedMultiplicityRefCS", -1,
			createSerializationRules(
				130	/* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				131	/* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				132	/* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				133	/* TypedMultiplicityRefCS-3: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				134	/* TypedMultiplicityRefCS-4: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[105] = createParserRuleValue(105, "TypedRefCS", 49 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
			createSerializationRules(
				24	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				35	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				55	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				66	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				15	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* TypeLiteralCS : [value] | [value] */,
			(0 << 16) | 0	/* TypedTypeRefCS : [value] | [value] */
		);
		grammarRuleValues[106] = createParserRuleValue(106, "TypedTypeRefCS", -1,
			createSerializationRules(
				15	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 3	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedBinding=TemplateBindingCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[107] = new TerminalRuleValue(107, "UNQUOTED_STRING");
		grammarRuleValues[108] = createDataTypeRuleValue(108, "UPPER", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[109] = createDataTypeRuleValue(109, "URI", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[110] = createParserRuleValue(110, "URIFirstPathElementCS", -1,
			createSerializationRules(
				79	/* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */,
				80	/* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 6	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PathElementWithURICS} : [value] | [value] */,
			(0 << 16) | 6	/* referredElement=URI : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[111] = createParserRuleValue(111, "URIPathNameCS", -1,
			createSerializationRules(
				81	/* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=URIFirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 3	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[112] = createDataTypeRuleValue(112, "UnaryOperatorName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[113] = createParserRuleValue(113, "UnlimitedNaturalLiteralExpCS", -1,
			createSerializationRules(
				82	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {UnlimitedNaturalLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 6	/* "*" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[114] = createDataTypeRuleValue(114, "UnreservedName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[115] = createParserRuleValue(115, "UnreservedPathNameCS", -1,
			createSerializationRules(
				16	/* UnreservedPathNameCS-0: PathNameCS::ownedPathElements+=NextPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 3	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[116] = createDataTypeRuleValue(116, "UnrestrictedName", 6 /* [soft-space, value, soft-space] */);
		grammarRuleValues[117] = new TerminalRuleValue(117, "WS");
		grammarRuleValues[118] = createParserRuleValue(118, "WildcardTypeRefCS", -1,
			createSerializationRules(
				17	/* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {WildcardTypeRefCS} : [value] | [value] */,
			(0 << 16) | 6	/* "?" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 6	/* "extends" : [value] | [soft-space, value, soft-space] */,
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
		grammarRuleVectors[2] = new GrammarRuleVector(0x200L);
		// 3: CurlyBracketedClauseCS
		grammarRuleVectors[3] = new GrammarRuleVector(0x1000L);
		// 4: ElseIfThenExpCS
		grammarRuleVectors[4] = new GrammarRuleVector(0x20000L);
		// 5: EnumerationLiteralCS
		grammarRuleVectors[5] = new GrammarRuleVector(0x80000L);
		// 6: ExpCS
		grammarRuleVectors[6] = new GrammarRuleVector(0x8000000L);
		// 7: FirstPathElementCS
		grammarRuleVectors[7] = new GrammarRuleVector(0x10000000L);
		// 8: LetVariableCS
		grammarRuleVectors[8] = new GrammarRuleVector(0x8000000000L);
		// 9: MapLiteralPartCS
		grammarRuleVectors[9] = new GrammarRuleVector(0x80000000000L);
		// 10: MapTypeCS
		grammarRuleVectors[10] = new GrammarRuleVector(0x100000000000L);
		// 11: MultiplicityCS
		grammarRuleVectors[11] = new GrammarRuleVector(0x800000000000L);
		// 12: NavigatingArgExpCS
		grammarRuleVectors[12] = new GrammarRuleVector(0x10000000000000L);
		// 13: NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[13] = new GrammarRuleVector(0xe0000000000000L);
		// 14: NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[14] = new GrammarRuleVector(0xe8000000000000L);
		// 15: NextPathElementCS
		grammarRuleVectors[15] = new GrammarRuleVector(0x400000000000000L);
		// 16: FirstPathElementCS|NextPathElementCS
		grammarRuleVectors[16] = new GrammarRuleVector(0x400000010000000L);
		// 17: OperationCS
		grammarRuleVectors[17] = new GrammarRuleVector(0x2000000000000000L);
		// 18: ParameterCS
		grammarRuleVectors[18] = new GrammarRuleVector(0x4000000000000000L);
		// 19: PathNameCS
		grammarRuleVectors[19] = new GrammarRuleVector(0x8000000000000000L);
		// 20: PatternExpCS
		grammarRuleVectors[20] = new GrammarRuleVector(0x0L,0x1L);
		// 21: ExpCS|PatternExpCS
		grammarRuleVectors[21] = new GrammarRuleVector(0x8000000L,0x1L);
		// 22: PrefixedLetExpCS
		grammarRuleVectors[22] = new GrammarRuleVector(0x0L,0x2L);
		// 23: LetExpCS|PrefixedLetExpCS
		grammarRuleVectors[23] = new GrammarRuleVector(0x4000000000L,0x2L);
		// 24: PrefixedPrimaryExpCS
		grammarRuleVectors[24] = new GrammarRuleVector(0x0L,0x4L);
		// 25: RoundBracketedClauseCS
		grammarRuleVectors[25] = new GrammarRuleVector(0x0L,0x200L);
		// 26: ShadowPartCS
		grammarRuleVectors[26] = new GrammarRuleVector(0x0L,0x8000L);
		// 27: SimpleTargetElementCS
		grammarRuleVectors[27] = new GrammarRuleVector(0x0L,0x20000L);
		// 28: CompoundTargetElementCS|SimpleTargetElementCS
		grammarRuleVectors[28] = new GrammarRuleVector(0x800L,0x20000L);
		// 29: SpecificationCS
		grammarRuleVectors[29] = new GrammarRuleVector(0x0L,0x40000L);
		// 30: SquareBracketedClauseCS
		grammarRuleVectors[30] = new GrammarRuleVector(0x0L,0x80000L);
		// 31: StringLiteralExpCS
		grammarRuleVectors[31] = new GrammarRuleVector(0x0L,0x200000L);
		// 32: StructuralFeatureCS
		grammarRuleVectors[32] = new GrammarRuleVector(0x0L,0x400000L);
		// 33: AttributeCS|ReferenceCS|StructuralFeatureCS
		grammarRuleVectors[33] = new GrammarRuleVector(0x2L,0x400100L);
		// 34: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS
		grammarRuleVectors[34] = new GrammarRuleVector(0x44010L,0x800000L);
		// 35: TemplateBindingCS
		grammarRuleVectors[35] = new GrammarRuleVector(0x0L,0x2000000L);
		// 36: TemplateParameterSubstitutionCS
		grammarRuleVectors[36] = new GrammarRuleVector(0x0L,0x4000000L);
		// 37: TemplateSignatureCS
		grammarRuleVectors[37] = new GrammarRuleVector(0x0L,0x8000000L);
		// 38: TupleLiteralPartCS
		grammarRuleVectors[38] = new GrammarRuleVector(0x0L,0x20000000L);
		// 39: TuplePartCS
		grammarRuleVectors[39] = new GrammarRuleVector(0x0L,0x40000000L);
		// 40: TypeExpCS
		grammarRuleVectors[40] = new GrammarRuleVector(0x0L,0x100000000L);
		// 41: TypeExpWithoutMultiplicityCS
		grammarRuleVectors[41] = new GrammarRuleVector(0x0L,0x200000000L);
		// 42: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS
		grammarRuleVectors[42] = new GrammarRuleVector(0x100000000200L,0x480000020L);
		// 43: TypeLiteralWithMultiplicityCS
		grammarRuleVectors[43] = new GrammarRuleVector(0x0L,0x1000000000L);
		// 44: CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS
		grammarRuleVectors[44] = new GrammarRuleVector(0x100000000300L,0x2680000020L);
		// 45: TypeParameterCS
		grammarRuleVectors[45] = new GrammarRuleVector(0x0L,0x4000000000L);
		// 46: TypeRefCS
		grammarRuleVectors[46] = new GrammarRuleVector(0x0L,0x8000000000L);
		// 47: TypedMultiplicityRefCS
		grammarRuleVectors[47] = new GrammarRuleVector(0x0L,0x10000000000L);
		// 48: TypedRefCS
		grammarRuleVectors[48] = new GrammarRuleVector(0x0L,0x20000000000L);
		// 49: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS
		grammarRuleVectors[49] = new GrammarRuleVector(0x100000000200L,0x60480000020L);
		// 50: NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[50] = new GrammarRuleVector(0x400000000000000L,0x400000000000L);
		// 51: FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[51] = new GrammarRuleVector(0x400000010000000L,0x400000000000L);
		// 52: BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[52] = new GrammarRuleVector(0x1800000400000008L,0x2000000200010L);
		// 53: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[53] = new GrammarRuleVector(0x1a04042500000048L,0x2000810204018L);
		// 54: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[54] = new GrammarRuleVector(0x1a04042500000048L,0x200081020401cL);
		// 55: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[55] = new GrammarRuleVector(0x1a04046500000048L,0x200081020401eL);
		// 56: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[56] = new GrammarRuleVector(0x1a04046508000048L,0x200081020401eL);
		// 57: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[57] = new GrammarRuleVector(0x1a14046508000048L,0x200081020401eL);
		// 58: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[58] = new GrammarRuleVector(0x1a04046508000048L,0x200081020401fL);
		// 59: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS
		grammarRuleVectors[59] = new GrammarRuleVector(0x100000000200L,0x40068480000020L);
	}

	/**
	 * Initialize steps for the matching process.
	 */
	private void initMatchSteps() {
		// 0: assert (|AbstractNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[0] = createMatchStep_Assert(141);
		// 1: assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0
		serializationMatchSteps[1] = createMatchStep_Assert(142);
		// 2: assert (|CollectionLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[2] = createMatchStep_Assert(145);
		// 3: assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0
		serializationMatchSteps[3] = createMatchStep_Assert(146);
		// 4: assert (|CollectionPatternCS::ownedType| - 1) == 0
		serializationMatchSteps[4] = createMatchStep_Assert(148);
		// 5: assert (|CollectionTypeCS::name| - 1) == 0
		serializationMatchSteps[5] = createMatchStep_Assert(149);
		// 6: assert (|ContextCS::ownedExpression| - 1) == 0
		serializationMatchSteps[6] = createMatchStep_Assert(150);
		// 7: assert (|ExpSpecificationCS::ownedExpression| - 1) == 0
		serializationMatchSteps[7] = createMatchStep_Assert(153);
		// 8: assert (|IfExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[8] = createMatchStep_Assert(154);
		// 9: assert (|IfExpCS::ownedElseExpression| - 1) == 0
		serializationMatchSteps[9] = createMatchStep_Assert(155);
		// 10: assert (|IfExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[10] = createMatchStep_Assert(156);
		// 11: assert (|IfThenExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[11] = createMatchStep_Assert(157);
		// 12: assert (|IfThenExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[12] = createMatchStep_Assert(158);
		// 13: assert (|InfixExpCS::ownedLeft| - 1) == 0
		serializationMatchSteps[13] = createMatchStep_Assert(159);
		// 14: assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0
		serializationMatchSteps[14] = createMatchStep_Assert(160);
		// 15: assert (|LetExpCS::ownedInExpression| - 1) == 0
		serializationMatchSteps[15] = createMatchStep_Assert(161);
		// 16: assert (|MapLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[16] = createMatchStep_Assert(165);
		// 17: assert (|MapLiteralPartCS::ownedKey| - 1) == 0
		serializationMatchSteps[17] = createMatchStep_Assert(166);
		// 18: assert (|MapLiteralPartCS::ownedValue| - 1) == 0
		serializationMatchSteps[18] = createMatchStep_Assert(167);
		// 19: assert (|MapTypeCS::name.'Map'| - 1) == 0
		serializationMatchSteps[19] = createMatchStep_Assert(168);
		// 20: assert (|MapTypeCS::ownedKeyType| - V0) == 0
		serializationMatchSteps[20] = createMatchStep_Assert(169);
		// 21: assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0
		serializationMatchSteps[21] = createMatchStep_Assert(170);
		// 22: assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0
		serializationMatchSteps[22] = createMatchStep_Assert(171);
		// 23: assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0
		serializationMatchSteps[23] = createMatchStep_Assert(172);
		// 24: assert (|NamedElementCS::name| - 1) == 0
		serializationMatchSteps[24] = createMatchStep_Assert(173);
		// 25: assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0
		serializationMatchSteps[25] = createMatchStep_Assert(174);
		// 26: assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[26] = createMatchStep_Assert(175);
		// 27: assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0
		serializationMatchSteps[27] = createMatchStep_Assert(176);
		// 28: assert (|NavigatingArgCS::ownedType| - 1) == 0
		serializationMatchSteps[28] = createMatchStep_Assert(177);
		// 29: assert (|NavigatingArgCS::prefix.','| - 1) == 0
		serializationMatchSteps[29] = createMatchStep_Assert(178);
		// 30: assert (|NavigatingArgCS::prefix.';'| - 1) == 0
		serializationMatchSteps[30] = createMatchStep_Assert(179);
		// 31: assert (|NavigatingArgCS::prefix.'|'| - 1) == 0
		serializationMatchSteps[31] = createMatchStep_Assert(180);
		// 32: assert (|NestedExpCS::ownedExpression| - 1) == 0
		serializationMatchSteps[32] = createMatchStep_Assert(181);
		// 33: assert (|NumberLiteralExpCS::symbol| - 1) == 0
		serializationMatchSteps[33] = createMatchStep_Assert(182);
		// 34: assert (|OperatorExpCS::ownedRight| - 1) == 0
		serializationMatchSteps[34] = createMatchStep_Assert(188);
		// 35: assert (|PathElementCS::referredElement| - 1) == 0
		serializationMatchSteps[35] = createMatchStep_Assert(189);
		// 36: assert (|PathNameCS::ownedPathElements| - 1) == 0
		serializationMatchSteps[36] = createMatchStep_Assert(190);
		// 37: assert (|PatternExpCS::ownedPatternType| - 1) == 0
		serializationMatchSteps[37] = createMatchStep_Assert(191);
		// 38: assert (|PrimitiveTypeRefCS::name| - 1) == 0
		serializationMatchSteps[38] = createMatchStep_Assert(192);
		// 39: assert (|ShadowPartCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[39] = createMatchStep_Assert(193);
		// 40: assert (|ShadowPartCS::referredProperty| - 1) == 0
		serializationMatchSteps[40] = createMatchStep_Assert(194);
		// 41: assert (|SimpleTargetElementCS::input.'input'| - 1) == 0
		serializationMatchSteps[41] = createMatchStep_Assert(195);
		// 42: assert (|SimpleTargetElementCS::output.'output'| - 1) == 0
		serializationMatchSteps[42] = createMatchStep_Assert(198);
		// 43: assert (|SimpleTargetElementCS::typedModel| - 1) == 0
		serializationMatchSteps[43] = createMatchStep_Assert(199);
		// 44: assert (|SimpleTargetElementCS::via.'via'| - 1) == 0
		serializationMatchSteps[44] = createMatchStep_Assert(200);
		// 45: assert (|SpecificationCS::exprString| - 1) == 0
		serializationMatchSteps[45] = createMatchStep_Assert(201);
		// 46: assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0
		serializationMatchSteps[46] = createMatchStep_Assert(208);
		// 47: assert (|TupleTypeCS::name.'Tuple'| - 1) == 0
		serializationMatchSteps[47] = createMatchStep_Assert(211);
		// 48: assert (|TypeLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[48] = createMatchStep_Assert(214);
		// 49: assert (|TypeNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[49] = createMatchStep_Assert(215);
		// 50: assert (|TypedElementCS::ownedType| - 1) == 0
		serializationMatchSteps[50] = createMatchStep_Assert(218);
		// 51: assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0
		serializationMatchSteps[51] = createMatchStep_Assert(223);
		// 52: assert (|TypedElementCS::qualifiers.'static'| - 1) == 0
		serializationMatchSteps[52] = createMatchStep_Assert(224);
		// 53: assert (|TypedTypeRefCS::ownedPathName| - 1) == 0
		serializationMatchSteps[53] = createMatchStep_Assert(225);
		// 54: assert (|VariableCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[54] = createMatchStep_Assert(226);
		// 55: assert |ClassCS::ownedConstraints| == 0
		serializationMatchSteps[55] = createMatchStep_Assert(10);
		// 56: assert |CollectionLiteralPartCS::ownedLastExpression| == 0
		serializationMatchSteps[56] = createMatchStep_Assert(14);
		// 57: assert |CollectionPatternCS::ownedPatternGuard| == 0
		serializationMatchSteps[57] = createMatchStep_Assert(16);
		// 58: assert |CurlyBracketedClauseCS::value| == 0
		serializationMatchSteps[58] = createMatchStep_Assert(25);
		// 59: assert |DataTypeCS::isSerializable| == 0
		serializationMatchSteps[59] = createMatchStep_Assert(28);
		// 60: assert |EnumerationCS::isSerializable| == 0
		serializationMatchSteps[60] = createMatchStep_Assert(30);
		// 61: assert |EnumerationCS::ownedLiterals| == 0
		serializationMatchSteps[61] = createMatchStep_Assert(31);
		// 62: assert |EnumerationLiteralCS::literal| == 0
		serializationMatchSteps[62] = createMatchStep_Assert(32);
		// 63: assert |ExpSpecificationCS::ownedExpression| == 0
		serializationMatchSteps[63] = createMatchStep_Assert(34);
		// 64: assert |IfExpCS::isImplicit| == 0
		serializationMatchSteps[64] = createMatchStep_Assert(35);
		// 65: assert |LetExpCS::isImplicit| == 0
		serializationMatchSteps[65] = createMatchStep_Assert(44);
		// 66: assert |ModelElementCS::ownedAnnotations| == 0
		serializationMatchSteps[66] = createMatchStep_Assert(55);
		// 67: assert |MultiplicityCS::isNullFree| == 0
		serializationMatchSteps[67] = createMatchStep_Assert(59);
		// 68: assert |NamedElementCS::name| == 0
		serializationMatchSteps[68] = createMatchStep_Assert(61);
		// 69: assert |NavigatingArgCS::ownedCoIterator| == 0
		serializationMatchSteps[69] = createMatchStep_Assert(62);
		// 70: assert |NavigatingArgCS::ownedInitExpression| == 0
		serializationMatchSteps[70] = createMatchStep_Assert(63);
		// 71: assert |NavigatingArgCS::ownedNameExpression| == 0
		serializationMatchSteps[71] = createMatchStep_Assert(64);
		// 72: assert |NavigatingArgCS::ownedType| == 0
		serializationMatchSteps[72] = createMatchStep_Assert(65);
		// 73: assert |NavigatingArgCS::prefix| == 0
		serializationMatchSteps[73] = createMatchStep_Assert(69);
		// 74: assert |OperationCS::ownedBodyExpressions| == 0
		serializationMatchSteps[74] = createMatchStep_Assert(72);
		// 75: assert |OperationCS::ownedPostconditions| == 0
		serializationMatchSteps[75] = createMatchStep_Assert(75);
		// 76: assert |OperationCS::ownedPreconditions| == 0
		serializationMatchSteps[76] = createMatchStep_Assert(76);
		// 77: assert |ReferenceCS::ownedImplicitOpposites| == 0
		serializationMatchSteps[77] = createMatchStep_Assert(83);
		// 78: assert |ReferenceCS::referredKeys| == 0
		serializationMatchSteps[78] = createMatchStep_Assert(84);
		// 79: assert |RootCS::ownedImports| == 0
		serializationMatchSteps[79] = createMatchStep_Assert(86);
		// 80: assert |SelfExpCS::name| == 0
		serializationMatchSteps[80] = createMatchStep_Assert(87);
		// 81: assert |ShadowPartCS::referredProperty| == 0
		serializationMatchSteps[81] = createMatchStep_Assert(89);
		// 82: assert |SimpleTargetElementCS::input| == 0
		serializationMatchSteps[82] = createMatchStep_Assert(91);
		// 83: assert |SimpleTargetElementCS::output| == 0
		serializationMatchSteps[83] = createMatchStep_Assert(94);
		// 84: assert |SimpleTargetElementCS::via| == 0
		serializationMatchSteps[84] = createMatchStep_Assert(97);
		// 85: assert |SpecificationCS::exprString| == 0
		serializationMatchSteps[85] = createMatchStep_Assert(98);
		// 86: assert |StructuralFeatureCS::ownedDefaultExpressions| == 0
		serializationMatchSteps[86] = createMatchStep_Assert(102);
		// 87: assert |StructuredClassCS::ownedMetaclass| == 0
		serializationMatchSteps[87] = createMatchStep_Assert(105);
		// 88: assert |StructuredClassCS::ownedOperations| == 0
		serializationMatchSteps[88] = createMatchStep_Assert(106);
		// 89: assert |StructuredClassCS::ownedProperties| == 0
		serializationMatchSteps[89] = createMatchStep_Assert(107);
		// 90: assert |TypeLiteralExpCS::ownedPathName| == 0
		serializationMatchSteps[90] = createMatchStep_Assert(118);
		// 91: assert |TypedElementCS::isOptional| == 0
		serializationMatchSteps[91] = createMatchStep_Assert(124);
		// 92: assert |TypedElementCS::qualifiers| == 0
		serializationMatchSteps[92] = createMatchStep_Assert(132);
		// 93: assert |TypedRefCS::ownedMultiplicity| == 0
		serializationMatchSteps[93] = createMatchStep_Assert(133);
		// 94: assert |TypedTypeRefCS::isTypeof| == 0
		serializationMatchSteps[94] = createMatchStep_Assert(134);
		// 95: assert |VariableCS::ownedInitExpression| == 0
		serializationMatchSteps[95] = createMatchStep_Assert(137);
		// 96: assert |WildcardTypeRefCS::ownedSuper| == 0
		serializationMatchSteps[96] = createMatchStep_Assert(140);
		// 97: assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[97] = createMatchStep_Assign(0, 144);
		// 98: assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchSteps[98] = createMatchStep_Assign(0, 152);
		// 99: assign V0 = (|LetExpCS::ownedVariables| - 1)
		serializationMatchSteps[99] = createMatchStep_Assign(0, 162);
		// 100: assign V0 = (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[100] = createMatchStep_Assign(0, 164);
		// 101: assign V0 = (|PathNameCS::ownedPathElements| - 1)
		serializationMatchSteps[101] = createMatchStep_Assign(0, 190);
		// 102: assign V0 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[102] = createMatchStep_Assign(0, 197);
		// 103: assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchSteps[103] = createMatchStep_Assign(0, 202);
		// 104: assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchSteps[104] = createMatchStep_Assign(0, 207);
		// 105: assign V0 = (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchSteps[105] = createMatchStep_Assign(0, 209);
		// 106: assign V0 = (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[106] = createMatchStep_Assign(0, 210);
		// 107: assign V0 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[107] = createMatchStep_Assign(0, 213);
		// 108: assign V0 = (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchSteps[108] = createMatchStep_Assign(0, 217);
		// 109: assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchSteps[109] = createMatchStep_Assign(0, 7);
		// 110: assign V0 = |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchSteps[110] = createMatchStep_Assign(0, 14);
		// 111: assign V0 = |CollectionPatternCS::restVariableName|
		serializationMatchSteps[111] = createMatchStep_Assign(0, 18);
		// 112: assign V0 = |CollectionTypeCS::ownedType|
		serializationMatchSteps[112] = createMatchStep_Assign(0, 21);
		// 113: assign V0 = |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchSteps[113] = createMatchStep_Assign(0, 22);
		// 114: assign V0 = |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchSteps[114] = createMatchStep_Assign(0, 26);
		// 115: assign V0 = |EnumerationLiteralCS::value|
		serializationMatchSteps[115] = createMatchStep_Assign(0, 33);
		// 116: assign V0 = |IfExpCS::ownedIfThenExpressions|
		serializationMatchSteps[116] = createMatchStep_Assign(0, 38);
		// 117: assign V0 = |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchSteps[117] = createMatchStep_Assign(0, 47);
		// 118: assign V0 = |MapTypeCS::ownedValueType|
		serializationMatchSteps[118] = createMatchStep_Assign(0, 54);
		// 119: assign V0 = |MultiplicityBoundsCS::upperBound|
		serializationMatchSteps[119] = createMatchStep_Assign(0, 57);
		// 120: assign V0 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[120] = createMatchStep_Assign(0, 62);
		// 121: assign V0 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[121] = createMatchStep_Assign(0, 63);
		// 122: assign V0 = |NavigatingArgCS::ownedType|
		serializationMatchSteps[122] = createMatchStep_Assign(0, 65);
		// 123: assign V0 = |PatternExpCS::patternVariableName|
		serializationMatchSteps[123] = createMatchStep_Assign(0, 81);
		// 124: assign V0 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[124] = createMatchStep_Assign(0, 85);
		// 125: assign V0 = |SimpleTargetElementCS::iterates|
		serializationMatchSteps[125] = createMatchStep_Assign(0, 92);
		// 126: assign V0 = |StringLiteralExpCS::segments|
		serializationMatchSteps[126] = createMatchStep_Assign(0, 100);
		// 127: assign V0 = |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchSteps[127] = createMatchStep_Assign(0, 103);
		// 128: assign V0 = |TargetCS::ownedTargetElements|
		serializationMatchSteps[128] = createMatchStep_Assign(0, 109);
		// 129: assign V0 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[129] = createMatchStep_Assign(0, 114);
		// 130: assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[130] = createMatchStep_Assign(0, 120);
		// 131: assign V0 = |TypedElementCS::ownedType|
		serializationMatchSteps[131] = createMatchStep_Assign(0, 125);
		// 132: assign V0 = |TypedElementCS::qualifiers.'definition'|
		serializationMatchSteps[132] = createMatchStep_Assign(0, 130);
		// 133: assign V0 = |TypedElementCS::qualifiers.'static'|
		serializationMatchSteps[133] = createMatchStep_Assign(0, 131);
		// 134: assign V0 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[134] = createMatchStep_Assign(0, 133);
		// 135: assign V0 = |TypedTypeRefCS::ownedBinding|
		serializationMatchSteps[135] = createMatchStep_Assign(0, 135);
		// 136: assign V0 = |VariableCS::ownedType|
		serializationMatchSteps[136] = createMatchStep_Assign(0, 138);
		// 137: assign V0 = |WildcardTypeRefCS::ownedExtends|
		serializationMatchSteps[137] = createMatchStep_Assign(0, 139);
		// 138: assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[138] = createMatchStep_Assign(1, 143);
		// 139: assign V1 = (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchSteps[139] = createMatchStep_Assign(1, 147);
		// 140: assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchSteps[140] = createMatchStep_Assign(1, 151);
		// 141: assign V1 = (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[141] = createMatchStep_Assign(1, 163);
		// 142: assign V1 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[142] = createMatchStep_Assign(1, 187);
		// 143: assign V1 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[143] = createMatchStep_Assign(1, 197);
		// 144: assign V1 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[144] = createMatchStep_Assign(1, 213);
		// 145: assign V1 = (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchSteps[145] = createMatchStep_Assign(1, 216);
		// 146: assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchSteps[146] = createMatchStep_Assign(1, 222);
		// 147: assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchSteps[147] = createMatchStep_Assign(1, 6);
		// 148: assign V1 = |ClassCS::instanceClassName|
		serializationMatchSteps[148] = createMatchStep_Assign(1, 9);
		// 149: assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchSteps[149] = createMatchStep_Assign(1, 20);
		// 150: assign V1 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[150] = createMatchStep_Assign(1, 62);
		// 151: assign V1 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[151] = createMatchStep_Assign(1, 63);
		// 152: assign V1 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[152] = createMatchStep_Assign(1, 85);
		// 153: assign V1 = |StructuralFeatureCS::default|
		serializationMatchSteps[153] = createMatchStep_Assign(1, 101);
		// 154: assign V1 = |TemplateBindingCS::ownedMultiplicity|
		serializationMatchSteps[154] = createMatchStep_Assign(1, 110);
		// 155: assign V1 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[155] = createMatchStep_Assign(1, 114);
		// 156: assign V1 = |TypeNameExpCS::ownedPatternGuard|
		serializationMatchSteps[156] = createMatchStep_Assign(1, 122);
		// 157: assign V1 = |TypedElementCS::ownedType|
		serializationMatchSteps[157] = createMatchStep_Assign(1, 125);
		// 158: assign V1 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[158] = createMatchStep_Assign(1, 133);
		// 159: assign V1 = |VariableCS::ownedType|
		serializationMatchSteps[159] = createMatchStep_Assign(1, 138);
		// 160: assign V10 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[160] = createMatchStep_Assign(10, 72);
		// 161: assign V2 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[161] = createMatchStep_Assign(2, 186);
		// 162: assign V2 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[162] = createMatchStep_Assign(2, 187);
		// 163: assign V2 = (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchSteps[163] = createMatchStep_Assign(2, 196);
		// 164: assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchSteps[164] = createMatchStep_Assign(2, 206);
		// 165: assign V2 = (|TupleTypeCS::ownedParts| - 1)
		serializationMatchSteps[165] = createMatchStep_Assign(2, 212);
		// 166: assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[166] = createMatchStep_Assign(2, 220);
		// 167: assign V2 = 0
		serializationMatchSteps[167] = createMatchStep_Assign(2, 0);
		// 168: assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[168] = createMatchStep_Assign(2, 4);
		// 169: assign V2 = |ClassCS::instanceClassName|
		serializationMatchSteps[169] = createMatchStep_Assign(2, 9);
		// 170: assign V2 = |EnumerationCS::isSerializable.'serializable'|
		serializationMatchSteps[170] = createMatchStep_Assign(2, 29);
		// 171: assign V2 = |StructuralFeatureCS::default|
		serializationMatchSteps[171] = createMatchStep_Assign(2, 101);
		// 172: assign V2 = |TypedElementCS::ownedType|
		serializationMatchSteps[172] = createMatchStep_Assign(2, 125);
		// 173: assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchSteps[173] = createMatchStep_Assign(2, 129);
		// 174: assign V2 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[174] = createMatchStep_Assign(2, 133);
		// 175: assign V3 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[175] = createMatchStep_Assign(3, 186);
		// 176: assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchSteps[176] = createMatchStep_Assign(3, 205);
		// 177: assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[177] = createMatchStep_Assign(3, 219);
		// 178: assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[178] = createMatchStep_Assign(3, 220);
		// 179: assign V3 = 0
		serializationMatchSteps[179] = createMatchStep_Assign(3, 0);
		// 180: assign V3 = |AbstractNameExpCS::isPre.'@'|
		serializationMatchSteps[180] = createMatchStep_Assign(3, 3);
		// 181: assign V3 = |DataTypeCS::isSerializable.'serializable'|
		serializationMatchSteps[181] = createMatchStep_Assign(3, 27);
		// 182: assign V3 = |EnumerationCS::ownedLiterals|
		serializationMatchSteps[182] = createMatchStep_Assign(3, 31);
		// 183: assign V3 = |StructuralFeatureCS::default|
		serializationMatchSteps[183] = createMatchStep_Assign(3, 101);
		// 184: assign V3 = |TypedElementCS::ownedType|
		serializationMatchSteps[184] = createMatchStep_Assign(3, 125);
		// 185: assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[185] = createMatchStep_Assign(3, 127);
		// 186: assign V3 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[186] = createMatchStep_Assign(3, 133);
		// 187: assign V4 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[187] = createMatchStep_Assign(4, 185);
		// 188: assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[188] = createMatchStep_Assign(4, 219);
		// 189: assign V4 = |ClassCS::instanceClassName|
		serializationMatchSteps[189] = createMatchStep_Assign(4, 9);
		// 190: assign V4 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[190] = createMatchStep_Assign(4, 102);
		// 191: assign V4 = |TypedElementCS::ownedType|
		serializationMatchSteps[191] = createMatchStep_Assign(4, 125);
		// 192: assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[192] = createMatchStep_Assign(4, 126);
		// 193: assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[193] = createMatchStep_Assign(4, 127);
		// 194: assign V5 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[194] = createMatchStep_Assign(5, 184);
		// 195: assign V5 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[195] = createMatchStep_Assign(5, 185);
		// 196: assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[196] = createMatchStep_Assign(5, 203);
		// 197: assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchSteps[197] = createMatchStep_Assign(5, 204);
		// 198: assign V5 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[198] = createMatchStep_Assign(5, 102);
		// 199: assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[199] = createMatchStep_Assign(5, 126);
		// 200: assign V6 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[200] = createMatchStep_Assign(6, 184);
		// 201: assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[201] = createMatchStep_Assign(6, 203);
		// 202: assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[202] = createMatchStep_Assign(6, 221);
		// 203: assign V6 = 0
		serializationMatchSteps[203] = createMatchStep_Assign(6, 0);
		// 204: assign V6 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[204] = createMatchStep_Assign(6, 102);
		// 205: assign V6 = |StructuredClassCS::isInterface.'interface'|
		serializationMatchSteps[205] = createMatchStep_Assign(6, 104);
		// 206: assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[206] = createMatchStep_Assign(7, 203);
		// 207: assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[207] = createMatchStep_Assign(7, 221);
		// 208: assign V7 = 0
		serializationMatchSteps[208] = createMatchStep_Assign(7, 0);
		// 209: assign V7 = |StructuredClassCS::ownedOperations|
		serializationMatchSteps[209] = createMatchStep_Assign(7, 106);
		// 210: assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[210] = createMatchStep_Assign(7, 128);
		// 211: assign V8 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[211] = createMatchStep_Assign(8, 183);
		// 212: assign V8 = 0
		serializationMatchSteps[212] = createMatchStep_Assign(8, 0);
		// 213: assign V8 = |StructuredClassCS::ownedProperties|
		serializationMatchSteps[213] = createMatchStep_Assign(8, 107);
		// 214: assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[214] = createMatchStep_Assign(8, 128);
		// 215: assign V9 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[215] = createMatchStep_Assign(9, 183);
		// 216: assign V9 = 0
		serializationMatchSteps[216] = createMatchStep_Assign(9, 0);
		// 217: assign V9 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[217] = createMatchStep_Assign(9, 72);
		// 218: check-rule basecs::EnumerationCS.ownedLiterals : 19
		serializationMatchSteps[218] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 5/*EnumerationLiteralCS*/);
		// 219: check-rule basecs::OperationCS.ownedBodyExpressions : 82
		serializationMatchSteps[219] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 29/*SpecificationCS*/);
		// 220: check-rule basecs::OperationCS.ownedExceptions : 9|44|69|95|98|105|106
		serializationMatchSteps[220] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 49/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 221: check-rule basecs::OperationCS.ownedParameters : 62
		serializationMatchSteps[221] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 18/*ParameterCS*/);
		// 222: check-rule basecs::PathNameCS.ownedPathElements : 28
		serializationMatchSteps[222] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 7/*FirstPathElementCS*/);
		// 223: check-rule basecs::PathNameCS.ownedPathElements : 58
		serializationMatchSteps[223] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 15/*NextPathElementCS*/);
		// 224: check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : 82
		serializationMatchSteps[224] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 29/*SpecificationCS*/);
		// 225: check-rule basecs::StructuredClassCS.ownedOperations : 61
		serializationMatchSteps[225] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 17/*OperationCS*/);
		// 226: check-rule basecs::StructuredClassCS.ownedProperties : 1|72|86
		serializationMatchSteps[226] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 33/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 227: check-rule basecs::StructuredClassCS.ownedSuperTypes : 9|44|69|95|98|105|106
		serializationMatchSteps[227] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 49/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 228: check-rule basecs::TemplateBindingCS.ownedMultiplicity : 47
		serializationMatchSteps[228] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 11/*MultiplicityCS*/);
		// 229: check-rule basecs::TemplateBindingCS.ownedSubstitutions : 90
		serializationMatchSteps[229] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 36/*TemplateParameterSubstitutionCS*/);
		// 230: check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : 9|44|69|95|98|103|105|106|118
		serializationMatchSteps[230] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 59/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS*/);
		// 231: check-rule basecs::TemplateSignatureCS.ownedParameters : 102
		serializationMatchSteps[231] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 45/*TypeParameterCS*/);
		// 232: check-rule basecs::TemplateableElementCS.ownedSignature : 91
		serializationMatchSteps[232] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/*TemplateSignatureCS*/);
		// 233: check-rule basecs::TupleTypeCS.ownedParts : 94
		serializationMatchSteps[233] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 39/*TuplePartCS*/);
		// 234: check-rule basecs::TypeParameterCS.ownedExtends : 9|44|69|95|98|105|106
		serializationMatchSteps[234] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 49/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 235: check-rule basecs::TypedElementCS.ownedType : 104
		serializationMatchSteps[235] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/*TypedMultiplicityRefCS*/);
		// 236: check-rule basecs::TypedElementCS.ownedType : 96
		serializationMatchSteps[236] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 40/*TypeExpCS*/);
		// 237: check-rule basecs::TypedRefCS.ownedMultiplicity : 47
		serializationMatchSteps[237] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/*MultiplicityCS*/);
		// 238: check-rule basecs::TypedTypeRefCS.ownedBinding : 89
		serializationMatchSteps[238] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 35/*TemplateBindingCS*/);
		// 239: check-rule basecs::TypedTypeRefCS.ownedPathName : 63
		serializationMatchSteps[239] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 19/*PathNameCS*/);
		// 240: check-rule basecs::WildcardTypeRefCS.ownedExtends : 9|44|69|95|98|105|106
		serializationMatchSteps[240] = createMatchStep_RuleCheck(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 49/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 241: check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : 12
		serializationMatchSteps[241] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/*CurlyBracketedClauseCS*/);
		// 242: check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : 63
		serializationMatchSteps[242] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 19/*PathNameCS*/);
		// 243: check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : 73
		serializationMatchSteps[243] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 25/*RoundBracketedClauseCS*/);
		// 244: check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : 83
		serializationMatchSteps[244] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 30/*SquareBracketedClauseCS*/);
		// 245: check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : 7
		serializationMatchSteps[245] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 1/*CollectionLiteralPartCS*/);
		// 246: check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : 9
		serializationMatchSteps[246] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 2/*CollectionTypeCS*/);
		// 247: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[247] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 248: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 64
		serializationMatchSteps[248] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 20/*PatternExpCS*/);
		// 249: check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[249] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 250: check-rule essentialoclcs::CollectionPatternCS.ownedParts : 64
		serializationMatchSteps[250] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 20/*PatternExpCS*/);
		// 251: check-rule essentialoclcs::CollectionPatternCS.ownedType : 9
		serializationMatchSteps[251] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/*CollectionTypeCS*/);
		// 252: check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : 47
		serializationMatchSteps[252] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 11/*MultiplicityCS*/);
		// 253: check-rule essentialoclcs::CollectionTypeCS.ownedType : 8|9|44|69|95|97|98|101
		serializationMatchSteps[253] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 44/*CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS*/);
		// 254: check-rule essentialoclcs::ContextCS.ownedExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[254] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 255: check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : 79
		serializationMatchSteps[255] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 26/*ShadowPartCS*/);
		// 256: check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[256] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 257: check-rule essentialoclcs::IfExpCS.ownedCondition : 3|6|27|32|34|37|38|42|50|57|59|60|64|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[257] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 58/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 258: check-rule essentialoclcs::IfExpCS.ownedElseExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[258] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 259: check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : 17
		serializationMatchSteps[259] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 4/*ElseIfThenExpCS*/);
		// 260: check-rule essentialoclcs::IfExpCS.ownedThenExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[260] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 261: check-rule essentialoclcs::IfThenExpCS.ownedCondition : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[261] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 262: check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[262] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 263: check-rule essentialoclcs::InfixExpCS.ownedLeft : 3|6|32|34|37|42|50|57|59|60|66|67|68|78|85|92|99|113
		serializationMatchSteps[263] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 54/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 264: check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[264] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 265: check-rule essentialoclcs::LetExpCS.ownedInExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[265] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 266: check-rule essentialoclcs::LetExpCS.ownedVariables : 39
		serializationMatchSteps[266] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 8/*LetVariableCS*/);
		// 267: check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : 73
		serializationMatchSteps[267] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 25/*RoundBracketedClauseCS*/);
		// 268: check-rule essentialoclcs::MapLiteralExpCS.ownedParts : 43
		serializationMatchSteps[268] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 9/*MapLiteralPartCS*/);
		// 269: check-rule essentialoclcs::MapLiteralExpCS.ownedType : 44
		serializationMatchSteps[269] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 10/*MapTypeCS*/);
		// 270: check-rule essentialoclcs::MapLiteralPartCS.ownedKey : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[270] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 271: check-rule essentialoclcs::MapLiteralPartCS.ownedValue : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[271] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 272: check-rule essentialoclcs::MapTypeCS.ownedKeyType : 96
		serializationMatchSteps[272] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 40/*TypeExpCS*/);
		// 273: check-rule essentialoclcs::MapTypeCS.ownedValueType : 96
		serializationMatchSteps[273] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 40/*TypeExpCS*/);
		// 274: check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : 5
		serializationMatchSteps[274] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/*CoIteratorVariableCS*/);
		// 275: check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[275] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 276: check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : 3|6|27|32|34|37|38|42|50|52|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[276] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 57/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 277: check-rule essentialoclcs::NavigatingArgCS.ownedType : 96
		serializationMatchSteps[277] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/*TypeExpCS*/);
		// 278: check-rule essentialoclcs::NestedExpCS.ownedExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[278] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 279: check-rule essentialoclcs::OperatorExpCS.ownedRight : 38|65
		serializationMatchSteps[279] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 23/*LetExpCS|PrefixedLetExpCS*/);
		// 280: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[280] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 281: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|6|32|34|37|42|50|57|59|60|66|67|68|78|85|92|99|113
		serializationMatchSteps[281] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 54/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 282: check-rule essentialoclcs::PatternExpCS.ownedPatternType : 96
		serializationMatchSteps[282] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 40/*TypeExpCS*/);
		// 283: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 3|6|27|32|34|37|38|42|50|57|59|60|64|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[283] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 58/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 284: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 85
		serializationMatchSteps[284] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 31/*StringLiteralExpCS*/);
		// 285: check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[285] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 286: check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : 93
		serializationMatchSteps[286] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 38/*TupleLiteralPartCS*/);
		// 287: check-rule essentialoclcs::TypeLiteralExpCS.ownedType : 100
		serializationMatchSteps[287] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 43/*TypeLiteralWithMultiplicityCS*/);
		// 288: check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : 12
		serializationMatchSteps[288] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/*CurlyBracketedClauseCS*/);
		// 289: check-rule essentialoclcs::TypeNameExpCS.ownedPathName : 63
		serializationMatchSteps[289] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 19/*PathNameCS*/);
		// 290: check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[290] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 291: check-rule essentialoclcs::VariableCS.ownedInitExpression : 3|6|27|32|34|37|38|42|50|57|59|60|65|66|67|68|78|85|92|99|113
		serializationMatchSteps[291] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 56/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 292: check-rule essentialoclcs::VariableCS.ownedType : 96
		serializationMatchSteps[292] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 40/*TypeExpCS*/);
		// 293: check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : 81
		serializationMatchSteps[293] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 27/*SimpleTargetElementCS*/);
		// 294: check-rule qvtbasecs::TargetCS.ownedTargetElements : 11|81
		serializationMatchSteps[294] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 28/*CompoundTargetElementCS|SimpleTargetElementCS*/);
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
		serializationMatchTerms[3] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 7 /* '@' */);
		// 4: |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchTerms[4] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		// 5: |AbstractNameExpCS::ownedPathName|
		serializationMatchTerms[5] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME);
		// 6: |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchTerms[6] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		// 7: |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchTerms[7] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES);
		// 8: |BooleanLiteralExpCS::symbol.'false|true'|
		serializationMatchTerms[8] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 12 /* 'false|true' */);
		// 9: |ClassCS::instanceClassName|
		serializationMatchTerms[9] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME);
		// 10: |ClassCS::ownedConstraints|
		serializationMatchTerms[10] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__OWNED_CONSTRAINTS);
		// 11: |CollectionLiteralExpCS::ownedParts|
		serializationMatchTerms[11] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);
		// 12: |CollectionLiteralExpCS::ownedType|
		serializationMatchTerms[12] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE);
		// 13: |CollectionLiteralPartCS::ownedExpression|
		serializationMatchTerms[13] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION);
		// 14: |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchTerms[14] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION);
		// 15: |CollectionPatternCS::ownedParts|
		serializationMatchTerms[15] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS);
		// 16: |CollectionPatternCS::ownedPatternGuard|
		serializationMatchTerms[16] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD);
		// 17: |CollectionPatternCS::ownedType|
		serializationMatchTerms[17] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE);
		// 18: |CollectionPatternCS::restVariableName|
		serializationMatchTerms[18] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME);
		// 19: |CollectionTypeCS::name|
		serializationMatchTerms[19] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME);
		// 20: |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchTerms[20] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY);
		// 21: |CollectionTypeCS::ownedType|
		serializationMatchTerms[21] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE);
		// 22: |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchTerms[22] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS);
		// 23: |ContextCS::ownedExpression|
		serializationMatchTerms[23] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION);
		// 24: |CurlyBracketedClauseCS::ownedParts|
		serializationMatchTerms[24] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS);
		// 25: |CurlyBracketedClauseCS::value|
		serializationMatchTerms[25] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__VALUE);
		// 26: |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchTerms[26] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 16 /* 'primitive' */);
		// 27: |DataTypeCS::isSerializable.'serializable'|
		serializationMatchTerms[27] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 17 /* 'serializable' */);
		// 28: |DataTypeCS::isSerializable|
		serializationMatchTerms[28] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE);
		// 29: |EnumerationCS::isSerializable.'serializable'|
		serializationMatchTerms[29] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 17 /* 'serializable' */);
		// 30: |EnumerationCS::isSerializable|
		serializationMatchTerms[30] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE);
		// 31: |EnumerationCS::ownedLiterals|
		serializationMatchTerms[31] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS);
		// 32: |EnumerationLiteralCS::literal|
		serializationMatchTerms[32] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__LITERAL);
		// 33: |EnumerationLiteralCS::value|
		serializationMatchTerms[33] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		// 34: |ExpSpecificationCS::ownedExpression|
		serializationMatchTerms[34] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION);
		// 35: |IfExpCS::isImplicit|
		serializationMatchTerms[35] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__IS_IMPLICIT);
		// 36: |IfExpCS::ownedCondition|
		serializationMatchTerms[36] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION);
		// 37: |IfExpCS::ownedElseExpression|
		serializationMatchTerms[37] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION);
		// 38: |IfExpCS::ownedIfThenExpressions|
		serializationMatchTerms[38] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS);
		// 39: |IfExpCS::ownedThenExpression|
		serializationMatchTerms[39] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION);
		// 40: |IfThenExpCS::ownedCondition|
		serializationMatchTerms[40] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION);
		// 41: |IfThenExpCS::ownedThenExpression|
		serializationMatchTerms[41] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION);
		// 42: |InfixExpCS::ownedLeft|
		serializationMatchTerms[42] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT);
		// 43: |LambdaLiteralExpCS::ownedExpressionCS|
		serializationMatchTerms[43] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS);
		// 44: |LetExpCS::isImplicit|
		serializationMatchTerms[44] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__IS_IMPLICIT);
		// 45: |LetExpCS::ownedInExpression|
		serializationMatchTerms[45] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION);
		// 46: |LetExpCS::ownedVariables|
		serializationMatchTerms[46] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES);
		// 47: |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchTerms[47] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		// 48: |MapLiteralExpCS::ownedParts|
		serializationMatchTerms[48] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS);
		// 49: |MapLiteralExpCS::ownedType|
		serializationMatchTerms[49] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE);
		// 50: |MapLiteralPartCS::ownedKey|
		serializationMatchTerms[50] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY);
		// 51: |MapLiteralPartCS::ownedValue|
		serializationMatchTerms[51] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE);
		// 52: |MapTypeCS::name.'Map'|
		serializationMatchTerms[52] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 8 /* 'Map' */);
		// 53: |MapTypeCS::ownedKeyType|
		serializationMatchTerms[53] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE);
		// 54: |MapTypeCS::ownedValueType|
		serializationMatchTerms[54] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE);
		// 55: |ModelElementCS::ownedAnnotations|
		serializationMatchTerms[55] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS);
		// 56: |MultiplicityBoundsCS::lowerBound|
		serializationMatchTerms[56] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND);
		// 57: |MultiplicityBoundsCS::upperBound|
		serializationMatchTerms[57] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND);
		// 58: |MultiplicityCS::isNullFree.'|1'|
		serializationMatchTerms[58] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 21 /* '|1' */);
		// 59: |MultiplicityCS::isNullFree|
		serializationMatchTerms[59] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE);
		// 60: |MultiplicityStringCS::stringBounds.'*|+|?'|
		serializationMatchTerms[60] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 4 /* '*|+|?' */);
		// 61: |NamedElementCS::name|
		serializationMatchTerms[61] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME);
		// 62: |NavigatingArgCS::ownedCoIterator|
		serializationMatchTerms[62] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR);
		// 63: |NavigatingArgCS::ownedInitExpression|
		serializationMatchTerms[63] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION);
		// 64: |NavigatingArgCS::ownedNameExpression|
		serializationMatchTerms[64] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION);
		// 65: |NavigatingArgCS::ownedType|
		serializationMatchTerms[65] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE);
		// 66: |NavigatingArgCS::prefix.','|
		serializationMatchTerms[66] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 5 /* ',' */);
		// 67: |NavigatingArgCS::prefix.';'|
		serializationMatchTerms[67] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ';' */);
		// 68: |NavigatingArgCS::prefix.'|'|
		serializationMatchTerms[68] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 20 /* '|' */);
		// 69: |NavigatingArgCS::prefix|
		serializationMatchTerms[69] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX);
		// 70: |NestedExpCS::ownedExpression|
		serializationMatchTerms[70] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION);
		// 71: |NumberLiteralExpCS::symbol|
		serializationMatchTerms[71] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL);
		// 72: |OperationCS::ownedBodyExpressions|
		serializationMatchTerms[72] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS);
		// 73: |OperationCS::ownedExceptions|
		serializationMatchTerms[73] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS);
		// 74: |OperationCS::ownedParameters|
		serializationMatchTerms[74] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS);
		// 75: |OperationCS::ownedPostconditions|
		serializationMatchTerms[75] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_POSTCONDITIONS);
		// 76: |OperationCS::ownedPreconditions|
		serializationMatchTerms[76] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PRECONDITIONS);
		// 77: |OperatorExpCS::ownedRight|
		serializationMatchTerms[77] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT);
		// 78: |PathElementCS::referredElement|
		serializationMatchTerms[78] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT);
		// 79: |PathNameCS::ownedPathElements|
		serializationMatchTerms[79] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS);
		// 80: |PatternExpCS::ownedPatternType|
		serializationMatchTerms[80] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE);
		// 81: |PatternExpCS::patternVariableName|
		serializationMatchTerms[81] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME);
		// 82: |PrimitiveTypeRefCS::name|
		serializationMatchTerms[82] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME);
		// 83: |ReferenceCS::ownedImplicitOpposites|
		serializationMatchTerms[83] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__OWNED_IMPLICIT_OPPOSITES);
		// 84: |ReferenceCS::referredKeys|
		serializationMatchTerms[84] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_KEYS);
		// 85: |ReferenceCS::referredOpposite|
		serializationMatchTerms[85] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE);
		// 86: |RootCS::ownedImports|
		serializationMatchTerms[86] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS);
		// 87: |SelfExpCS::name|
		serializationMatchTerms[87] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SELF_EXP_CS__NAME);
		// 88: |ShadowPartCS::ownedInitExpression|
		serializationMatchTerms[88] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION);
		// 89: |ShadowPartCS::referredProperty|
		serializationMatchTerms[89] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY);
		// 90: |SimpleTargetElementCS::input.'input'|
		serializationMatchTerms[90] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 13 /* 'input' */);
		// 91: |SimpleTargetElementCS::input|
		serializationMatchTerms[91] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT);
		// 92: |SimpleTargetElementCS::iterates|
		serializationMatchTerms[92] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES);
		// 93: |SimpleTargetElementCS::output.'output'|
		serializationMatchTerms[93] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 15 /* 'output' */);
		// 94: |SimpleTargetElementCS::output|
		serializationMatchTerms[94] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT);
		// 95: |SimpleTargetElementCS::typedModel|
		serializationMatchTerms[95] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL);
		// 96: |SimpleTargetElementCS::via.'via'|
		serializationMatchTerms[96] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 19 /* 'via' */);
		// 97: |SimpleTargetElementCS::via|
		serializationMatchTerms[97] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA);
		// 98: |SpecificationCS::exprString|
		serializationMatchTerms[98] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING);
		// 99: |SquareBracketedClauseCS::ownedTerms|
		serializationMatchTerms[99] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS);
		// 100: |StringLiteralExpCS::segments|
		serializationMatchTerms[100] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS);
		// 101: |StructuralFeatureCS::default|
		serializationMatchTerms[101] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT);
		// 102: |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchTerms[102] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS);
		// 103: |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchTerms[103] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 10 /* 'abstract' */);
		// 104: |StructuredClassCS::isInterface.'interface'|
		serializationMatchTerms[104] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 14 /* 'interface' */);
		// 105: |StructuredClassCS::ownedMetaclass|
		serializationMatchTerms[105] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_METACLASS);
		// 106: |StructuredClassCS::ownedOperations|
		serializationMatchTerms[106] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS);
		// 107: |StructuredClassCS::ownedProperties|
		serializationMatchTerms[107] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES);
		// 108: |StructuredClassCS::ownedSuperTypes|
		serializationMatchTerms[108] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES);
		// 109: |TargetCS::ownedTargetElements|
		serializationMatchTerms[109] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS);
		// 110: |TemplateBindingCS::ownedMultiplicity|
		serializationMatchTerms[110] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY);
		// 111: |TemplateBindingCS::ownedSubstitutions|
		serializationMatchTerms[111] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS);
		// 112: |TemplateParameterSubstitutionCS::ownedActualParameter|
		serializationMatchTerms[112] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER);
		// 113: |TemplateSignatureCS::ownedParameters|
		serializationMatchTerms[113] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS);
		// 114: |TemplateableElementCS::ownedSignature|
		serializationMatchTerms[114] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE);
		// 115: |TupleLiteralExpCS::ownedParts|
		serializationMatchTerms[115] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS);
		// 116: |TupleTypeCS::name.'Tuple'|
		serializationMatchTerms[116] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 9 /* 'Tuple' */);
		// 117: |TupleTypeCS::ownedParts|
		serializationMatchTerms[117] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS);
		// 118: |TypeLiteralExpCS::ownedPathName|
		serializationMatchTerms[118] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_PATH_NAME);
		// 119: |TypeLiteralExpCS::ownedType|
		serializationMatchTerms[119] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE);
		// 120: |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchTerms[120] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		// 121: |TypeNameExpCS::ownedPathName|
		serializationMatchTerms[121] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME);
		// 122: |TypeNameExpCS::ownedPatternGuard|
		serializationMatchTerms[122] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD);
		// 123: |TypeParameterCS::ownedExtends|
		serializationMatchTerms[123] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS);
		// 124: |TypedElementCS::isOptional|
		serializationMatchTerms[124] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__IS_OPTIONAL);
		// 125: |TypedElementCS::ownedType|
		serializationMatchTerms[125] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE);
		// 126: |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchTerms[126] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */);
		// 127: |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchTerms[127] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */);
		// 128: |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchTerms[128] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */);
		// 129: |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchTerms[129] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */);
		// 130: |TypedElementCS::qualifiers.'definition'|
		serializationMatchTerms[130] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 11 /* 'definition' */);
		// 131: |TypedElementCS::qualifiers.'static'|
		serializationMatchTerms[131] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 18 /* 'static' */);
		// 132: |TypedElementCS::qualifiers|
		serializationMatchTerms[132] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS);
		// 133: |TypedRefCS::ownedMultiplicity|
		serializationMatchTerms[133] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY);
		// 134: |TypedTypeRefCS::isTypeof|
		serializationMatchTerms[134] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__IS_TYPEOF);
		// 135: |TypedTypeRefCS::ownedBinding|
		serializationMatchTerms[135] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING);
		// 136: |TypedTypeRefCS::ownedPathName|
		serializationMatchTerms[136] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME);
		// 137: |VariableCS::ownedInitExpression|
		serializationMatchTerms[137] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION);
		// 138: |VariableCS::ownedType|
		serializationMatchTerms[138] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE);
		// 139: |WildcardTypeRefCS::ownedExtends|
		serializationMatchTerms[139] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS);
		// 140: |WildcardTypeRefCS::ownedSuper|
		serializationMatchTerms[140] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_SUPER);
		// 141: (|AbstractNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[141] = createSerializationMatchTermSubtract(5, 1);
		// 142: (|BooleanLiteralExpCS::symbol.'false|true'| - 1)
		serializationMatchTerms[142] = createSerializationMatchTermSubtract(8, 1);
		// 143: (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[143] = createSerializationMatchTermSubtract(11, 1);
		// 144: (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[144] = createSerializationMatchTermGreaterThan(11, 0);
		// 145: (|CollectionLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[145] = createSerializationMatchTermSubtract(12, 1);
		// 146: (|CollectionLiteralPartCS::ownedExpression| - 1)
		serializationMatchTerms[146] = createSerializationMatchTermSubtract(13, 1);
		// 147: (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchTerms[147] = createSerializationMatchTermSubtract(15, 1);
		// 148: (|CollectionPatternCS::ownedType| - 1)
		serializationMatchTerms[148] = createSerializationMatchTermSubtract(17, 1);
		// 149: (|CollectionTypeCS::name| - 1)
		serializationMatchTerms[149] = createSerializationMatchTermSubtract(19, 1);
		// 150: (|ContextCS::ownedExpression| - 1)
		serializationMatchTerms[150] = createSerializationMatchTermSubtract(23, 1);
		// 151: (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchTerms[151] = createSerializationMatchTermSubtract(24, 1);
		// 152: (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchTerms[152] = createSerializationMatchTermGreaterThan(24, 0);
		// 153: (|ExpSpecificationCS::ownedExpression| - 1)
		serializationMatchTerms[153] = createSerializationMatchTermSubtract(34, 1);
		// 154: (|IfExpCS::ownedCondition| - 1)
		serializationMatchTerms[154] = createSerializationMatchTermSubtract(36, 1);
		// 155: (|IfExpCS::ownedElseExpression| - 1)
		serializationMatchTerms[155] = createSerializationMatchTermSubtract(37, 1);
		// 156: (|IfExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[156] = createSerializationMatchTermSubtract(39, 1);
		// 157: (|IfThenExpCS::ownedCondition| - 1)
		serializationMatchTerms[157] = createSerializationMatchTermSubtract(40, 1);
		// 158: (|IfThenExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[158] = createSerializationMatchTermSubtract(41, 1);
		// 159: (|InfixExpCS::ownedLeft| - 1)
		serializationMatchTerms[159] = createSerializationMatchTermSubtract(42, 1);
		// 160: (|LambdaLiteralExpCS::ownedExpressionCS| - 1)
		serializationMatchTerms[160] = createSerializationMatchTermSubtract(43, 1);
		// 161: (|LetExpCS::ownedInExpression| - 1)
		serializationMatchTerms[161] = createSerializationMatchTermSubtract(45, 1);
		// 162: (|LetExpCS::ownedVariables| - 1)
		serializationMatchTerms[162] = createSerializationMatchTermSubtract(46, 1);
		// 163: (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[163] = createSerializationMatchTermSubtract(48, 1);
		// 164: (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[164] = createSerializationMatchTermGreaterThan(48, 0);
		// 165: (|MapLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[165] = createSerializationMatchTermSubtract(49, 1);
		// 166: (|MapLiteralPartCS::ownedKey| - 1)
		serializationMatchTerms[166] = createSerializationMatchTermSubtract(50, 1);
		// 167: (|MapLiteralPartCS::ownedValue| - 1)
		serializationMatchTerms[167] = createSerializationMatchTermSubtract(51, 1);
		// 168: (|MapTypeCS::name.'Map'| - 1)
		serializationMatchTerms[168] = createSerializationMatchTermSubtract(52, 1);
		// 169: (|MapTypeCS::ownedKeyType| - V0)
		serializationMatchTerms[169] = createSerializationMatchTermSubtract(53, 2);
		// 170: (|MultiplicityBoundsCS::lowerBound| - 1)
		serializationMatchTerms[170] = createSerializationMatchTermSubtract(56, 1);
		// 171: (|MultiplicityCS::isNullFree.'|1'| - 1)
		serializationMatchTerms[171] = createSerializationMatchTermSubtract(58, 1);
		// 172: (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1)
		serializationMatchTerms[172] = createSerializationMatchTermSubtract(60, 1);
		// 173: (|NamedElementCS::name| - 1)
		serializationMatchTerms[173] = createSerializationMatchTermSubtract(61, 1);
		// 174: (|NavigatingArgCS::ownedCoIterator| - 1)
		serializationMatchTerms[174] = createSerializationMatchTermSubtract(62, 1);
		// 175: (|NavigatingArgCS::ownedInitExpression| - 1)
		serializationMatchTerms[175] = createSerializationMatchTermSubtract(63, 1);
		// 176: (|NavigatingArgCS::ownedNameExpression| - 1)
		serializationMatchTerms[176] = createSerializationMatchTermSubtract(64, 1);
		// 177: (|NavigatingArgCS::ownedType| - 1)
		serializationMatchTerms[177] = createSerializationMatchTermSubtract(65, 1);
		// 178: (|NavigatingArgCS::prefix.','| - 1)
		serializationMatchTerms[178] = createSerializationMatchTermSubtract(66, 1);
		// 179: (|NavigatingArgCS::prefix.';'| - 1)
		serializationMatchTerms[179] = createSerializationMatchTermSubtract(67, 1);
		// 180: (|NavigatingArgCS::prefix.'|'| - 1)
		serializationMatchTerms[180] = createSerializationMatchTermSubtract(68, 1);
		// 181: (|NestedExpCS::ownedExpression| - 1)
		serializationMatchTerms[181] = createSerializationMatchTermSubtract(70, 1);
		// 182: (|NumberLiteralExpCS::symbol| - 1)
		serializationMatchTerms[182] = createSerializationMatchTermSubtract(71, 1);
		// 183: (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchTerms[183] = createSerializationMatchTermGreaterThan(72, 0);
		// 184: (|OperationCS::ownedExceptions| - 1)
		serializationMatchTerms[184] = createSerializationMatchTermSubtract(73, 1);
		// 185: (|OperationCS::ownedExceptions| > 0)
		serializationMatchTerms[185] = createSerializationMatchTermGreaterThan(73, 0);
		// 186: (|OperationCS::ownedParameters| - 1)
		serializationMatchTerms[186] = createSerializationMatchTermSubtract(74, 1);
		// 187: (|OperationCS::ownedParameters| > 0)
		serializationMatchTerms[187] = createSerializationMatchTermGreaterThan(74, 0);
		// 188: (|OperatorExpCS::ownedRight| - 1)
		serializationMatchTerms[188] = createSerializationMatchTermSubtract(77, 1);
		// 189: (|PathElementCS::referredElement| - 1)
		serializationMatchTerms[189] = createSerializationMatchTermSubtract(78, 1);
		// 190: (|PathNameCS::ownedPathElements| - 1)
		serializationMatchTerms[190] = createSerializationMatchTermSubtract(79, 1);
		// 191: (|PatternExpCS::ownedPatternType| - 1)
		serializationMatchTerms[191] = createSerializationMatchTermSubtract(80, 1);
		// 192: (|PrimitiveTypeRefCS::name| - 1)
		serializationMatchTerms[192] = createSerializationMatchTermSubtract(82, 1);
		// 193: (|ShadowPartCS::ownedInitExpression| - 1)
		serializationMatchTerms[193] = createSerializationMatchTermSubtract(88, 1);
		// 194: (|ShadowPartCS::referredProperty| - 1)
		serializationMatchTerms[194] = createSerializationMatchTermSubtract(89, 1);
		// 195: (|SimpleTargetElementCS::input.'input'| - 1)
		serializationMatchTerms[195] = createSerializationMatchTermSubtract(90, 1);
		// 196: (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchTerms[196] = createSerializationMatchTermSubtract(92, 1);
		// 197: (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchTerms[197] = createSerializationMatchTermGreaterThan(92, 0);
		// 198: (|SimpleTargetElementCS::output.'output'| - 1)
		serializationMatchTerms[198] = createSerializationMatchTermSubtract(93, 1);
		// 199: (|SimpleTargetElementCS::typedModel| - 1)
		serializationMatchTerms[199] = createSerializationMatchTermSubtract(95, 1);
		// 200: (|SimpleTargetElementCS::via.'via'| - 1)
		serializationMatchTerms[200] = createSerializationMatchTermSubtract(96, 1);
		// 201: (|SpecificationCS::exprString| - 1)
		serializationMatchTerms[201] = createSerializationMatchTermSubtract(98, 1);
		// 202: (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchTerms[202] = createSerializationMatchTermSubtract(99, 1);
		// 203: (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchTerms[203] = createSerializationMatchTermGreaterThan(102, 0);
		// 204: (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchTerms[204] = createSerializationMatchTermGreaterThan(104, 0);
		// 205: (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchTerms[205] = createSerializationMatchTermSubtract(108, 1);
		// 206: (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchTerms[206] = createSerializationMatchTermGreaterThan(108, 0);
		// 207: (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchTerms[207] = createSerializationMatchTermSubtract(111, 1);
		// 208: (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1)
		serializationMatchTerms[208] = createSerializationMatchTermSubtract(112, 1);
		// 209: (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchTerms[209] = createSerializationMatchTermSubtract(113, 1);
		// 210: (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[210] = createSerializationMatchTermSubtract(115, 1);
		// 211: (|TupleTypeCS::name.'Tuple'| - 1)
		serializationMatchTerms[211] = createSerializationMatchTermSubtract(116, 1);
		// 212: (|TupleTypeCS::ownedParts| - 1)
		serializationMatchTerms[212] = createSerializationMatchTermSubtract(117, 1);
		// 213: (|TupleTypeCS::ownedParts| > 0)
		serializationMatchTerms[213] = createSerializationMatchTermGreaterThan(117, 0);
		// 214: (|TypeLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[214] = createSerializationMatchTermSubtract(119, 1);
		// 215: (|TypeNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[215] = createSerializationMatchTermSubtract(121, 1);
		// 216: (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchTerms[216] = createSerializationMatchTermSubtract(123, 1);
		// 217: (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchTerms[217] = createSerializationMatchTermGreaterThan(123, 0);
		// 218: (|TypedElementCS::ownedType| - 1)
		serializationMatchTerms[218] = createSerializationMatchTermSubtract(125, 1);
		// 219: (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[219] = createSerializationMatchTermGreaterThan(126, 0);
		// 220: (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[220] = createSerializationMatchTermGreaterThan(127, 0);
		// 221: (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchTerms[221] = createSerializationMatchTermGreaterThan(128, 0);
		// 222: (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchTerms[222] = createSerializationMatchTermGreaterThan(129, 0);
		// 223: (|TypedElementCS::qualifiers.'definition'| - 1)
		serializationMatchTerms[223] = createSerializationMatchTermSubtract(130, 1);
		// 224: (|TypedElementCS::qualifiers.'static'| - 1)
		serializationMatchTerms[224] = createSerializationMatchTermSubtract(131, 1);
		// 225: (|TypedTypeRefCS::ownedPathName| - 1)
		serializationMatchTerms[225] = createSerializationMatchTermSubtract(136, 1);
		// 226: (|VariableCS::ownedInitExpression| - 1)
		serializationMatchTerms[226] = createSerializationMatchTermSubtract(137, 1);
	}

	/**
	 * Initialize the various serialization rules that serialize an EClass.
	 */
	private void initSerializationRules0() {
		// Base::FirstPathElementCS-0(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[0] = createSerializationRule("FirstPathElementCS-0", 28,
			createSerializationMatchSteps(
				35		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				232		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::MultiplicityBoundsCS-0(basecs::MultiplicityBoundsCS): { lowerBound=LOWER { ".." upperBound=UPPER }[?] }
		serializationRules[1] = createSerializationRule("MultiplicityBoundsCS-0", 46,
			createSerializationMatchSteps(
				67		/* assert |MultiplicityCS::isNullFree| == 0 */,
				119		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				21		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				12		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				112		/* '..' || no-space value no-space */,
				101		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-0(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "|?" "]" }
		serializationRules[2] = createSerializationRule("MultiplicityCS-0", 47,
			createSerializationMatchSteps(
				67		/* assert |MultiplicityCS::isNullFree| == 0 */,
				119		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				21		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* '[' || no-space value no-space */,
				12		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				112		/* '..' || no-space value no-space */,
				101		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				149		/* '|?' || no-space value no-space */,
				121		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-1(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } isNullFree?="|1" "]" }
		serializationRules[3] = createSerializationRule("MultiplicityCS-1", 47,
			createSerializationMatchSteps(
				22		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				119		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				21		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* '[' || no-space value no-space */,
				12		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				112		/* '..' || no-space value no-space */,
				101		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				6		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				121		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(21/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-2(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "]" }
		serializationRules[4] = createSerializationRule("MultiplicityCS-2", 47,
			createSerializationMatchSteps(
				67		/* assert |MultiplicityCS::isNullFree| == 0 */,
				119		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				21		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* '[' || no-space value no-space */,
				12		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				112		/* '..' || no-space value no-space */,
				101		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				121		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-3(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "|?" "]" }
		serializationRules[5] = createSerializationRule("MultiplicityCS-3", 47,
			createSerializationMatchSteps(
				67		/* assert |MultiplicityCS::isNullFree| == 0 */,
				23		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* '[' || no-space value no-space */,
				97		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				149		/* '|?' || no-space value no-space */,
				121		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-4(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} isNullFree?="|1" "]" }
		serializationRules[6] = createSerializationRule("MultiplicityCS-4", 47,
			createSerializationMatchSteps(
				22		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				23		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* '[' || no-space value no-space */,
				97		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				6		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				121		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(21/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-5(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "]" }
		serializationRules[7] = createSerializationRule("MultiplicityCS-5", 47,
			createSerializationMatchSteps(
				67		/* assert |MultiplicityCS::isNullFree| == 0 */,
				23		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* '[' || no-space value no-space */,
				97		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				121		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityStringCS-0(basecs::MultiplicityStringCS): stringBounds={'*|+|?'}
		serializationRules[8] = createSerializationRule("MultiplicityStringCS-0", 48,
			createSerializationMatchSteps(
				67		/* assert |MultiplicityCS::isNullFree| == 0 */,
				23		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				97		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::NextPathElementCS-0(basecs::PathElementCS): referredElement=UnreservedName
		serializationRules[9] = createSerializationRule("NextPathElementCS-0", 58,
			createSerializationMatchSteps(
				35		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				231		/* PathElementCS::referredElement=UnreservedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::PathNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[10] = createSerializationRule("PathNameCS-0", 63,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				217		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				155		/* V00*2-steps || value */,
				114		/* '::' || no-space value no-space */,
				218		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 16/* FirstPathElementCS,NextPathElementCS */,
					(28/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(58/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TemplateBindingCS-0(basecs::TemplateBindingCS): { ownedSubstitutions+=TemplateParameterSubstitutionCS { "," ownedSubstitutions+=TemplateParameterSubstitutionCS }[*] ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[11] = createSerializationRule("TemplateBindingCS-0", 89,
			createSerializationMatchSteps(
				228		/* check-rule basecs::TemplateBindingCS.ownedMultiplicity : MultiplicityCS */,
				229		/* check-rule basecs::TemplateBindingCS.ownedSubstitutions : TemplateParameterSubstitutionCS */,
				154		/* assign V1 = |TemplateBindingCS::ownedMultiplicity| */,
				104		/* assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1) */
			),
			createSerializationSteps(
				72		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				155		/* V00*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				72		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				162		/* V01*1-steps || value */,
				49		/* TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 36/* TemplateParameterSubstitutionCS */,
					(90/*TemplateParameterSubstitutionCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TemplateParameterSubstitutionCS-0(basecs::TemplateParameterSubstitutionCS): ownedActualParameter=TypeRefCS
		serializationRules[12] = createSerializationRule("TemplateParameterSubstitutionCS-0", 90,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				230		/* check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
				46		/* assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0 */
			),
			createSerializationSteps(
				18		/* TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 46/* TypeRefCS */,
					(103/*TypeRefCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::TemplateSignatureCS-0(basecs::TemplateSignatureCS): { "(" ownedParameters+=TypeParameterCS { "," ownedParameters+=TypeParameterCS }[*] ")" }
		serializationRules[13] = createSerializationRule("TemplateSignatureCS-0", 91,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				231		/* check-rule basecs::TemplateSignatureCS.ownedParameters : TypeParameterCS */,
				105		/* assign V0 = (|TemplateSignatureCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				107		/* '(' || no-space value no-space */,
				55		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				155		/* V00*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				55		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				108		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 45/* TypeParameterCS */,
					(102/*TypeParameterCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TypeParameterCS-0(basecs::TypeParameterCS): { name=UnrestrictedName { "extends" ownedExtends+=TypedRefCS { "&&" ownedExtends+=TypedRefCS }[*] }[?] }
		serializationRules[14] = createSerializationRule("TypeParameterCS-0", 102,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				234		/* check-rule basecs::TypeParameterCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				108		/* assign V0 = (|TypeParameterCS::ownedExtends| > 0) */,
				145		/* assign V1 = (|TypeParameterCS::ownedExtends| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				131		/* 'extends' || soft-space value soft-space */,
				36		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */,
				165		/* V01*2-steps || value */,
				106		/* '&&' || soft-space value soft-space */,
				36		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TypedTypeRefCS-0(basecs::TypedTypeRefCS): { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] }
		serializationRules[15] = createSerializationRule("TypedTypeRefCS-0", 106,
			createSerializationMatchSteps(
				94		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				93		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				238		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				239		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				135		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				53		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				64		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				156		/* V00*3-steps || value */,
				107		/* '(' || no-space value no-space */,
				19		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				108		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 35/* TemplateBindingCS */,
					(89/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 19/* PathNameCS */,
					(63/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::UnreservedPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=NextPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[16] = createSerializationRule("UnreservedPathNameCS-0", 115,
			createSerializationMatchSteps(
				223		/* check-rule basecs::PathNameCS.ownedPathElements : NextPathElementCS */,
				101		/* assign V0 = (|PathNameCS::ownedPathElements| - 1) */
			),
			createSerializationSteps(
				218		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */,
				155		/* V00*2-steps || value */,
				114		/* '::' || no-space value no-space */,
				218		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 15/* NextPathElementCS */,
					(58/*NextPathElementCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::WildcardTypeRefCS-0(basecs::WildcardTypeRefCS): { "?" { "extends" ownedExtends=TypedRefCS }[?] }
		serializationRules[17] = createSerializationRule("WildcardTypeRefCS-0", 118,
			createSerializationMatchSteps(
				96		/* assert |WildcardTypeRefCS::ownedSuper| == 0 */,
				240		/* check-rule basecs::WildcardTypeRefCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				137		/* assign V0 = |WildcardTypeRefCS::ownedExtends| */
			),
			createSerializationSteps(
				117		/* '?' || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				131		/* 'extends' || soft-space value soft-space */,
				37		/* WildcardTypeRefCS::ownedExtends=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::BooleanLiteralExpCS-0(essentialoclcs::BooleanLiteralExpCS): symbol={'false|true'}
		serializationRules[18] = createSerializationRule("BooleanLiteralExpCS-0", 3,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				1		/* assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0 */
			),
			createSerializationSteps(
				98		/* BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, false,
					(12/*'false|true'*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CoIteratorVariableCS-0(essentialoclcs::VariableCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] }
		serializationRules[19] = createSerializationRule("CoIteratorVariableCS-0", 5,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				95		/* assert |VariableCS::ownedInitExpression| == 0 */,
				292		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				136		/* assign V0 = |VariableCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				85		/* VariableCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralExpCS-0(essentialoclcs::CollectionLiteralExpCS): { ownedType=CollectionTypeCS "{" { ownedParts+=CollectionLiteralPartCS { "," ownedParts+=CollectionLiteralPartCS }[*] }[?] "}" }
		serializationRules[20] = createSerializationRule("CollectionLiteralExpCS-0", 6,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				245		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : CollectionLiteralPartCS */,
				246		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : CollectionTypeCS */,
				2		/* assert (|CollectionLiteralExpCS::ownedType| - 1) == 0 */,
				97		/* assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0) */,
				138		/* assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				79		/* CollectionLiteralExpCS::ownedType=CollectionTypeCS || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				157		/* V00*4-steps || value */,
				56		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				165		/* V01*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				56		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 1/* CollectionLiteralPartCS */,
					(7/*CollectionLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(9/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-0(essentialoclcs::CollectionLiteralPartCS): { ownedExpression=ExpCS { ".." ownedLastExpression=ExpCS }[?] }
		serializationRules[21] = createSerializationRule("CollectionLiteralPartCS-0", 7,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				247		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				249		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				110		/* assign V0 = |CollectionLiteralPartCS::ownedLastExpression| */,
				3		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				30		/* CollectionLiteralPartCS::ownedExpression=ExpCS || value */,
				154		/* V00*2-steps || value */,
				112		/* '..' || no-space value no-space */,
				46		/* CollectionLiteralPartCS::ownedLastExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-1(essentialoclcs::CollectionLiteralPartCS): ownedExpression=PatternExpCS
		serializationRules[22] = createSerializationRule("CollectionLiteralPartCS-1", 7,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				56		/* assert |CollectionLiteralPartCS::ownedLastExpression| == 0 */,
				248		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : PatternExpCS */,
				3		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				31		/* CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 20/* PatternExpCS */,
					(64/*PatternExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionPatternCS-0(essentialoclcs::CollectionPatternCS): { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" }
		serializationRules[23] = createSerializationRule("CollectionPatternCS-0", 8,
			createSerializationMatchSteps(
				93		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				57		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				250		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				251		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				111		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				139		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				4		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				80		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				159		/* V00*6-steps || value */,
				57		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				165		/* V01*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				57		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				110		/* '++' || soft-space value soft-space */,
				95		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 20/* PatternExpCS */,
					(64/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(9/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionTypeCS-0(essentialoclcs::CollectionTypeCS): { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] }
		serializationRules[24] = createSerializationRule("CollectionTypeCS-0", 9,
			createSerializationMatchSteps(
				93		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				252		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				253		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				112		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				149		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				13		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				81		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				162		/* V01*1-steps || value */,
				22		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				108		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 41/* TypeExpWithoutMultiplicityCS */,
					(97/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CurlyBracketedClauseCS-0(essentialoclcs::CurlyBracketedClauseCS): { "{" { ownedParts+=ShadowPartCS { "," ownedParts+=ShadowPartCS }[*] }[?] "}" }
		serializationRules[25] = createSerializationRule("CurlyBracketedClauseCS-0", 12,
			createSerializationMatchSteps(
				58		/* assert |CurlyBracketedClauseCS::value| == 0 */,
				255		/* check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : ShadowPartCS */,
				98		/* assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0) */,
				140		/* assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				148		/* '{' || soft-space value push soft-new-line */,
				157		/* V00*4-steps || value */,
				58		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				165		/* V01*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				58		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 26/* ShadowPartCS */,
					(79/*ShadowPartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::ElseIfThenExpCS-0(essentialoclcs::IfThenExpCS): { "elseif" ownedCondition=ExpCS "then" ownedThenExpression=ExpCS }
		serializationRules[26] = createSerializationRule("ElseIfThenExpCS-0", 17,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				261		/* check-rule essentialoclcs::IfThenExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				262		/* check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				12		/* assert (|IfThenExpCS::ownedThenExpression| - 1) == 0 */,
				11		/* assert (|IfThenExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				128		/* 'elseif' || soft-space value soft-space */,
				24		/* IfThenExpCS::ownedCondition=ExpCS || value */,
				145		/* 'then' || soft-space value soft-space */,
				78		/* IfThenExpCS::ownedThenExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::ExpCS-18(essentialoclcs::InfixExpCS): { ownedLeft=PrefixedPrimaryExpCS { name=BinaryOperatorName ownedRight=ExpCS } }
		serializationRules[27] = createSerializationRule("ExpCS-18", 27,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				263		/* check-rule essentialoclcs::InfixExpCS.ownedLeft : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				280		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				34		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				13		/* assert (|InfixExpCS::ownedLeft| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				47		/* InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value */,
				212		/* NamedElementCS::name=BinaryOperatorName || soft-space value soft-space */,
				219		/* OperatorExpCS::ownedRight=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 24/* PrefixedPrimaryExpCS */,
					(66/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::IfExpCS-0(essentialoclcs::IfExpCS): { "if" ownedCondition=(ExpCS|PatternExpCS) "then" ownedThenExpression=ExpCS ownedIfThenExpressions+=ElseIfThenExpCS[*] "else" ownedElseExpression=ExpCS "endif" }
		serializationRules[28] = createSerializationRule("IfExpCS-0", 32,
			createSerializationMatchSteps(
				64		/* assert |IfExpCS::isImplicit| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				257		/* check-rule essentialoclcs::IfExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				258		/* check-rule essentialoclcs::IfExpCS.ownedElseExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				259		/* check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : ElseIfThenExpCS */,
				260		/* check-rule essentialoclcs::IfExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				9		/* assert (|IfExpCS::ownedElseExpression| - 1) == 0 */,
				116		/* assign V0 = |IfExpCS::ownedIfThenExpressions| */,
				10		/* assert (|IfExpCS::ownedThenExpression| - 1) == 0 */,
				8		/* assert (|IfExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				132		/* 'if' || soft-space value soft-space */,
				23		/* IfExpCS::ownedCondition=ExpCS|PatternExpCS || value */,
				145		/* 'then' || soft-space value soft-space */,
				77		/* IfExpCS::ownedThenExpression=ExpCS || value */,
				152		/* V00*1-steps || value */,
				38		/* IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value */,
				127		/* 'else' || soft-space value soft-space */,
				28		/* IfExpCS::ownedElseExpression=ExpCS || value */,
				129		/* 'endif' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 21/* ExpCS,PatternExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/,
					(64/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 4/* ElseIfThenExpCS */,
					(17/*ElseIfThenExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::InvalidLiteralExpCS-0(essentialoclcs::InvalidLiteralExpCS): "invalid"
		serializationRules[29] = createSerializationRule("InvalidLiteralExpCS-0", 34,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				135		/* 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::LambdaLiteralExpCS-0(essentialoclcs::LambdaLiteralExpCS): { "Lambda" "{" ownedExpressionCS=ExpCS "}" }
		serializationRules[30] = createSerializationRule("LambdaLiteralExpCS-0", 37,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				264		/* check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				14		/* assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				118		/* 'Lambda' || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				35		/* LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::LetExpCS-0(essentialoclcs::LetExpCS): { "let" ownedVariables+=LetVariableCS { "," ownedVariables+=LetVariableCS }[*] "in" ownedInExpression=ExpCS }
		serializationRules[31] = createSerializationRule("LetExpCS-0", 38,
			createSerializationMatchSteps(
				65		/* assert |LetExpCS::isImplicit| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				265		/* check-rule essentialoclcs::LetExpCS.ownedInExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				266		/* check-rule essentialoclcs::LetExpCS.ownedVariables : LetVariableCS */,
				15		/* assert (|LetExpCS::ownedInExpression| - 1) == 0 */,
				99		/* assign V0 = (|LetExpCS::ownedVariables| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				137		/* 'let' || soft-space value soft-space */,
				88		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				155		/* V00*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				88		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				133		/* 'in' || soft-space value soft-space */,
				39		/* LetExpCS::ownedInExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 8/* LetVariableCS */,
					(39/*LetVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::LetVariableCS-0(essentialoclcs::LetVariableCS): { name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS[?] { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[32] = createSerializationRule("LetVariableCS-0", 39,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				291		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				267		/* check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				292		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				54		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				159		/* assign V1 = |VariableCS::ownedType| */,
				117		/* assign V0 = |LetVariableCS::ownedRoundBracketedClause| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				69		/* LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				85		/* VariableCS::ownedType=TypeExpCS || value */,
				116		/* '=' || soft-space value soft-space */,
				43		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 25/* RoundBracketedClauseCS */,
					(73/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::MapLiteralExpCS-0(essentialoclcs::MapLiteralExpCS): { ownedType=MapTypeCS "{" { ownedParts+=MapLiteralPartCS { "," ownedParts+=MapLiteralPartCS }[*] }[?] "}" }
		serializationRules[33] = createSerializationRule("MapLiteralExpCS-0", 42,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				268		/* check-rule essentialoclcs::MapLiteralExpCS.ownedParts : MapLiteralPartCS */,
				269		/* check-rule essentialoclcs::MapLiteralExpCS.ownedType : MapTypeCS */,
				16		/* assert (|MapLiteralExpCS::ownedType| - 1) == 0 */,
				100		/* assign V0 = (|MapLiteralExpCS::ownedParts| > 0) */,
				141		/* assign V1 = (|MapLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				82		/* MapLiteralExpCS::ownedType=MapTypeCS || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				157		/* V00*4-steps || value */,
				59		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				165		/* V01*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				59		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 9/* MapLiteralPartCS */,
					(43/*MapLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 10/* MapTypeCS */,
					(44/*MapTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapLiteralPartCS-0(essentialoclcs::MapLiteralPartCS): { ownedKey=ExpCS {"with"|"<-"} ownedValue=ExpCS }
		serializationRules[34] = createSerializationRule("MapLiteralPartCS-0", 43,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				270		/* check-rule essentialoclcs::MapLiteralPartCS.ownedKey : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				271		/* check-rule essentialoclcs::MapLiteralPartCS.ownedValue : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				18		/* assert (|MapLiteralPartCS::ownedValue| - 1) == 0 */,
				17		/* assert (|MapLiteralPartCS::ownedKey| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				44		/* MapLiteralPartCS::ownedKey=ExpCS || value */,
				147		/* 'with' || value */,
				86		/* MapLiteralPartCS::ownedValue=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapTypeCS-0(essentialoclcs::MapTypeCS): { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] }
		serializationRules[35] = createSerializationRule("MapTypeCS-0", 44,
			createSerializationMatchSteps(
				93		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				272		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				273		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				118		/* assign V0 = |MapTypeCS::ownedValueType| */,
				20		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				19		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				14		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				45		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				111		/* ',' || no-space value soft-space */,
				87		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				108		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(8/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::Model-0(essentialoclcs::ContextCS): ownedExpression=ExpCS
		serializationRules[36] = createSerializationRule("Model-0", 45,
			createSerializationMatchSteps(
				68		/* assert |NamedElementCS::name| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				79		/* assert |RootCS::ownedImports| == 0 */,
				254		/* check-rule essentialoclcs::ContextCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				6		/* assert (|ContextCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				32		/* ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NameExpCS-0(essentialoclcs::NameExpCS): { ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS[*] ownedRoundBracketedClause=RoundBracketedClauseCS[?] ownedCurlyBracketedClause=CurlyBracketedClauseCS[?] { isPre?="@" "pre" }[?] }
		serializationRules[37] = createSerializationRule("NameExpCS-0", 50,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				241		/* check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				242		/* check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : PathNameCS */,
				243		/* check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				244		/* check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : SquareBracketedClauseCS */,
				180		/* assign V3 = |AbstractNameExpCS::isPre.'@'| */,
				168		/* assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause| */,
				147		/* assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause| */,
				109		/* assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses| */,
				0		/* assert (|AbstractNameExpCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				62		/* AbstractNameExpCS::ownedPathName=PathNameCS || value */,
				152		/* V00*1-steps || value */,
				71		/* AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value */,
				162		/* V01*1-steps || value */,
				68		/* AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				169		/* V02*1-steps || value */,
				25		/* AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				179		/* V03*2-steps || value */,
				7		/* AbstractNameExpCS::isPre?='@' || soft-space value soft-space */,
				141		/* 'pre' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, false,
					(7/*'@'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/* CurlyBracketedClauseCS */,
					(12/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 19/* PathNameCS */,
					(63/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 25/* RoundBracketedClauseCS */,
					(73/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 30/* SquareBracketedClauseCS */,
					(83/*SquareBracketedClauseCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-0(essentialoclcs::NavigatingArgCS): { ":" ownedType=TypeExpCS }
		serializationRules[38] = createSerializationRule("NavigatingArgCS-0", 51,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				69		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				70		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				71		/* assert |NavigatingArgCS::ownedNameExpression| == 0 */,
				73		/* assert |NavigatingArgCS::prefix| == 0 */,
				277		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				28		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				113		/* ':' || soft-space value soft-space */,
				83		/* NavigatingArgCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-1(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[39] = createSerializationRule("NavigatingArgCS-1", 51,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				73		/* assert |NavigatingArgCS::prefix| == 0 */,
				274		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				277		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				151		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				120		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				28		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				113		/* ':' || soft-space value soft-space */,
				83		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				154		/* V00*2-steps || value */,
				147		/* 'with' || value */,
				21		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				164		/* V01*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-2(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[40] = createSerializationRule("NavigatingArgCS-2", 51,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				73		/* assert |NavigatingArgCS::prefix| == 0 */,
				274		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				277		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				26		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				150		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				122		/* assign V0 = |NavigatingArgCS::ownedType| */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				154		/* V00*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				83		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				164		/* V01*2-steps || value */,
				147		/* 'with' || value */,
				21		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				133		/* 'in' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-3(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[41] = createSerializationRule("NavigatingArgCS-3", 51,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				72		/* assert |NavigatingArgCS::ownedType| == 0 */,
				73		/* assert |NavigatingArgCS::prefix| == 0 */,
				274		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				121		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				25		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				147		/* 'with' || value */,
				21		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				154		/* V00*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-4(essentialoclcs::NavigatingArgCS): ownedNameExpression=NavigatingArgExpCS
		serializationRules[42] = createSerializationRule("NavigatingArgCS-4", 51,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				69		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				70		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				72		/* assert |NavigatingArgCS::ownedType| == 0 */,
				73		/* assert |NavigatingArgCS::prefix| == 0 */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				52		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingBarArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="|" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[43] = createSerializationRule("NavigatingBarArgCS-0", 53,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				69		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				277		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				122		/* assign V0 = |NavigatingArgCS::ownedType| */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				31		/* assert (|NavigatingArgCS::prefix.'|'| - 1) == 0 */,
				151		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				92		/* NavigatingArgCS::prefix='|' || soft-space value soft-space */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				158		/* V00*5-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				83		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				164		/* V01*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(20/*'|'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[44] = createSerializationRule("NavigatingCommaArgCS-0", 54,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				274		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				277		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				151		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				120		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				28		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				29		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				91		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				113		/* ':' || soft-space value soft-space */,
				83		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				154		/* V00*2-steps || value */,
				147		/* 'with' || value */,
				21		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				164		/* V01*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(5/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-1(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[45] = createSerializationRule("NavigatingCommaArgCS-1", 54,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				274		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				277		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				26		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				150		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				122		/* assign V0 = |NavigatingArgCS::ownedType| */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				29		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				91		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				154		/* V00*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				83		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				164		/* V01*2-steps || value */,
				147		/* 'with' || value */,
				21		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				133		/* 'in' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(5/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-2(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[46] = createSerializationRule("NavigatingCommaArgCS-2", 54,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				72		/* assert |NavigatingArgCS::ownedType| == 0 */,
				274		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				121		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				25		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				29		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				91		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				147		/* 'with' || value */,
				21		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				154		/* V00*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(5/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(5/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-3(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS }
		serializationRules[47] = createSerializationRule("NavigatingCommaArgCS-3", 54,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				69		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				70		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				72		/* assert |NavigatingArgCS::ownedType| == 0 */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				29		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				91		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(5/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingSemiArgCS-0(essentialoclcs::NavigatingArgCS): { prefix=";" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[48] = createSerializationRule("NavigatingSemiArgCS-0", 55,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				69		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				275		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				276		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				277		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				122		/* assign V0 = |NavigatingArgCS::ownedType| */,
				27		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				30		/* assert (|NavigatingArgCS::prefix.';'| - 1) == 0 */,
				151		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				90		/* NavigatingArgCS::prefix=';' || no-space value soft-new-line */,
				51		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				158		/* V00*5-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				83		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				164		/* V01*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				40		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*';'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 12/* NavigatingArgExpCS */,
					(52/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NestedExpCS-0(essentialoclcs::NestedExpCS): { "(" ownedExpression=ExpCS ")" }
		serializationRules[49] = createSerializationRule("NestedExpCS-0", 57,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				278		/* check-rule essentialoclcs::NestedExpCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				32		/* assert (|NestedExpCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				107		/* '(' || no-space value no-space */,
				34		/* NestedExpCS::ownedExpression=ExpCS || value */,
				108		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NullLiteralExpCS-0(essentialoclcs::NullLiteralExpCS): "null"
		serializationRules[50] = createSerializationRule("NullLiteralExpCS-0", 59,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				139		/* 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::NumberLiteralExpCS-0(essentialoclcs::NumberLiteralExpCS): symbol=NUMBER_LITERAL
		serializationRules[51] = createSerializationRule("NumberLiteralExpCS-0", 60,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				33		/* assert (|NumberLiteralExpCS::symbol| - 1) == 0 */
			),
			createSerializationSteps(
				99		/* NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::PatternExpCS-0(essentialoclcs::PatternExpCS): { patternVariableName=UnrestrictedName[?] ":" ownedPatternType=TypeExpCS }
		serializationRules[52] = createSerializationRule("PatternExpCS-0", 64,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				282		/* check-rule essentialoclcs::PatternExpCS.ownedPatternType : TypeExpCS */,
				37		/* assert (|PatternExpCS::ownedPatternType| - 1) == 0 */,
				123		/* assign V0 = |PatternExpCS::patternVariableName| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				89		/* PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				66		/* PatternExpCS::ownedPatternType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedLetExpCS-1(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedLetExpCS }
		serializationRules[53] = createSerializationRule("PrefixedLetExpCS-1", 65,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				279		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : LetExpCS|PrefixedLetExpCS */,
				34		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				210		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				220		/* OperatorExpCS::ownedRight=PrefixedLetExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 22/* PrefixedLetExpCS */,
					(65/*PrefixedLetExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedPrimaryExpCS-15(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS }
		serializationRules[54] = createSerializationRule("PrefixedPrimaryExpCS-15", 66,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				281		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				34		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				210		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				221		/* OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 24/* PrefixedPrimaryExpCS */,
					(66/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrimitiveTypeCS-0(basecs::PrimitiveTypeRefCS): name=PrimitiveTypeIdentifier
		serializationRules[55] = createSerializationRule("PrimitiveTypeCS-0", 69,
			createSerializationMatchSteps(
				93		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				38		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				15		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::RoundBracketedClauseCS-0(essentialoclcs::RoundBracketedClauseCS): { "(" { ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[*] }[?] ")" }
		serializationRules[56] = createSerializationRule("RoundBracketedClauseCS-0", 73,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				107		/* '(' || no-space value no-space */,
				156		/* V00*3-steps || value */,
				214		/* RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value */,
				163		/* V01*1-steps || value */,
				215		/* RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value */,
				108		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 14/* NavigatingArgCS,NavigatingBarArgCS,NavigatingCommaArgCS,NavigatingSemiArgCS */,
					(51/*NavigatingArgCS*/ << 4) | 1 /*[?]*/,
					(53/*NavigatingBarArgCS*/ << 4) | 2 /*[*]*/,
					(54/*NavigatingCommaArgCS*/ << 4) | 2 /*[*]*/,
					(55/*NavigatingSemiArgCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::SelfExpCS-0(essentialoclcs::SelfExpCS): "self"
		serializationRules[57] = createSerializationRule("SelfExpCS-0", 78,
			createSerializationMatchSteps(
				80		/* assert |SelfExpCS::name| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				143		/* 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::ShadowPartCS-0(essentialoclcs::ShadowPartCS): { referredProperty=UnrestrictedName "=" ownedInitExpression=(ExpCS|PatternExpCS) }
		serializationRules[58] = createSerializationRule("ShadowPartCS-0", 79,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				283		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				39		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */,
				40		/* assert (|ShadowPartCS::referredProperty| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				94		/* ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space */,
				116		/* '=' || soft-space value soft-space */,
				41		/* ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 21/* ExpCS,PatternExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/,
					(64/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, -1
				)
			});
		// EssentialOCL::ShadowPartCS-1(essentialoclcs::ShadowPartCS): ownedInitExpression=StringLiteralExpCS
		serializationRules[59] = createSerializationRule("ShadowPartCS-1", 79,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				81		/* assert |ShadowPartCS::referredProperty| == 0 */,
				284		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : StringLiteralExpCS */,
				39		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */
			),
			createSerializationSteps(
				42		/* ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 31/* StringLiteralExpCS */,
					(85/*StringLiteralExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SimplePathNameCS-0(basecs::PathNameCS): ownedPathElements+=FirstPathElementCS
		serializationRules[60] = createSerializationRule("SimplePathNameCS-0", 80,
			createSerializationMatchSteps(
				222		/* check-rule basecs::PathNameCS.ownedPathElements : FirstPathElementCS */,
				36		/* assert (|PathNameCS::ownedPathElements| - 1) == 0 */
			),
			createSerializationSteps(
				217		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 7/* FirstPathElementCS */,
					(28/*FirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SquareBracketedClauseCS-0(essentialoclcs::SquareBracketedClauseCS): { "[" ownedTerms+=ExpCS { "," ownedTerms+=ExpCS }[*] "]" }
		serializationRules[61] = createSerializationRule("SquareBracketedClauseCS-0", 83,
			createSerializationMatchSteps(
				285		/* check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				103		/* assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1) */
			),
			createSerializationSteps(
				120		/* '[' || no-space value no-space */,
				76		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				155		/* V00*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				76		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				121		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::StringLiteralExpCS-0(essentialoclcs::StringLiteralExpCS): segments+=StringLiteral[+]
		serializationRules[62] = createSerializationRule("StringLiteralExpCS-0", 85,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				126		/* assign V0 = |StringLiteralExpCS::segments| */
			),
			createSerializationSteps(
				153		/* V00*1-steps || value */,
				96		/* StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, false, GrammarCardinality.ONE_OR_MORE)
			});
		// EssentialOCL::TupleLiteralExpCS-0(essentialoclcs::TupleLiteralExpCS): { "Tuple" "{" ownedParts+=TupleLiteralPartCS { "," ownedParts+=TupleLiteralPartCS }[*] "}" }
		serializationRules[63] = createSerializationRule("TupleLiteralExpCS-0", 92,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				286		/* check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : TupleLiteralPartCS */,
				106		/* assign V0 = (|TupleLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				119		/* 'Tuple' || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				60		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				155		/* V00*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				60		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 38/* TupleLiteralPartCS */,
					(93/*TupleLiteralPartCS*/ << 4) | 3 /*[+]*/
				)
			});
	}
	private void initSerializationRules1() {
		// EssentialOCL::TupleLiteralPartCS-0(essentialoclcs::TupleLiteralPartCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[64] = createSerializationRule("TupleLiteralPartCS-0", 93,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				291		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				292		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				54		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				136		/* assign V0 = |VariableCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				85		/* VariableCS::ownedType=TypeExpCS || value */,
				116		/* '=' || soft-space value soft-space */,
				43		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TuplePartCS-0(basecs::TuplePartCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[65] = createSerializationRule("TuplePartCS-0", 94,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				92		/* assert |TypedElementCS::qualifiers| == 0 */,
				236		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				50		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				223		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TupleTypeCS-0(basecs::TupleTypeCS): { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] }
		serializationRules[66] = createSerializationRule("TupleTypeCS-0", 95,
			createSerializationMatchSteps(
				93		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				233		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				47		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				107		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				144		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				165		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				16		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				160		/* V00*7-steps || value */,
				107		/* '(' || no-space value no-space */,
				167		/* V01*4-steps || value */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				108		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(9/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 39/* TuplePartCS */,
					(94/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeExpCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[67] = createSerializationRule("TypeExpCS-0", 96,
			createSerializationMatchSteps(
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				134		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				38		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				15		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[68] = createSerializationRule("TypeExpCS-1", 96,
			createSerializationMatchSteps(
				252		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				253		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				174		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				112		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				149		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				13		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				81		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				162		/* V01*1-steps || value */,
				22		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				108		/* ')' || no-space value */,
				169		/* V02*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 41/* TypeExpWithoutMultiplicityCS */,
					(97/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[69] = createSerializationRule("TypeExpCS-2", 96,
			createSerializationMatchSteps(
				272		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				273		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				158		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				118		/* assign V0 = |MapTypeCS::ownedValueType| */,
				20		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				19		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				14		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				45		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				111		/* ',' || no-space value soft-space */,
				87		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				108		/* ')' || no-space value */,
				162		/* V01*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(8/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-3(essentialoclcs::TypeNameExpCS): { { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[70] = createSerializationRule("TypeExpCS-3", 96,
			createSerializationMatchSteps(
				288		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				289		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				290		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				174		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				130		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				49		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				156		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				63		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				158		/* V00*5-steps || value */,
				26		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				166		/* V01*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				65		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */,
				169		/* V02*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/* CurlyBracketedClauseCS */,
					(12/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 19/* PathNameCS */,
					(63/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-4(essentialoclcs::CollectionPatternCS): { { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[71] = createSerializationRule("TypeExpCS-4", 96,
			createSerializationMatchSteps(
				57		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				250		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				251		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				174		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				111		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				139		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				4		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				80		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				159		/* V00*6-steps || value */,
				57		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				165		/* V01*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				57		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				110		/* '++' || soft-space value soft-space */,
				95		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				169		/* V02*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 20/* PatternExpCS */,
					(64/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(9/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeExpCS-5(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[72] = createSerializationRule("TypeExpCS-5", 96,
			createSerializationMatchSteps(
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				233		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				186		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				47		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				107		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				144		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				165		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				16		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				160		/* V00*7-steps || value */,
				107		/* '(' || no-space value no-space */,
				167		/* V01*4-steps || value */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				108		/* ')' || no-space value */,
				176		/* V03*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(9/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 39/* TuplePartCS */,
					(94/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeLiteralExpCS-0(essentialoclcs::TypeLiteralExpCS): ownedType=TypeLiteralWithMultiplicityCS
		serializationRules[73] = createSerializationRule("TypeLiteralExpCS-0", 99,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |TypeLiteralExpCS::ownedPathName| == 0 */,
				287		/* check-rule essentialoclcs::TypeLiteralExpCS.ownedType : TypeLiteralWithMultiplicityCS */,
				48		/* assert (|TypeLiteralExpCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				84		/* TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 43/* TypeLiteralWithMultiplicityCS */,
					(100/*TypeLiteralWithMultiplicityCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[74] = createSerializationRule("TypeLiteralWithMultiplicityCS-0", 100,
			createSerializationMatchSteps(
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				134		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				38		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				15		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[75] = createSerializationRule("TypeLiteralWithMultiplicityCS-1", 100,
			createSerializationMatchSteps(
				252		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				253		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				174		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				112		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				149		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				13		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				81		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				162		/* V01*1-steps || value */,
				22		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				108		/* ')' || no-space value */,
				169		/* V02*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 41/* TypeExpWithoutMultiplicityCS */,
					(97/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[76] = createSerializationRule("TypeLiteralWithMultiplicityCS-2", 100,
			createSerializationMatchSteps(
				272		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				273		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				158		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				118		/* assign V0 = |MapTypeCS::ownedValueType| */,
				20		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				19		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				14		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				45		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				111		/* ',' || no-space value soft-space */,
				87		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				108		/* ')' || no-space value */,
				162		/* V01*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(8/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-3(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[77] = createSerializationRule("TypeLiteralWithMultiplicityCS-3", 100,
			createSerializationMatchSteps(
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				233		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				186		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				47		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				107		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				144		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				165		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				16		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				160		/* V00*7-steps || value */,
				107		/* '(' || no-space value no-space */,
				167		/* V01*4-steps || value */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				108		/* ')' || no-space value */,
				176		/* V03*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(9/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 39/* TuplePartCS */,
					(94/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeNameExpCS-0(essentialoclcs::TypeNameExpCS): { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] }
		serializationRules[78] = createSerializationRule("TypeNameExpCS-0", 101,
			createSerializationMatchSteps(
				93		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				288		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				289		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				290		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				130		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				49		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				156		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				63		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				158		/* V00*5-steps || value */,
				26		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				166		/* V01*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				65		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 3/* CurlyBracketedClauseCS */,
					(12/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 19/* PathNameCS */,
					(63/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::URIFirstPathElementCS-0(basecs::PathElementWithURICS): referredElement=URI
		serializationRules[79] = createSerializationRule("URIFirstPathElementCS-0", 110,
			createSerializationMatchSteps(
				35		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				230		/* PathElementCS::referredElement=URI || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIFirstPathElementCS-1(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[80] = createSerializationRule("URIFirstPathElementCS-1", 110,
			createSerializationMatchSteps(
				35		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				232		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=URIFirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[81] = createSerializationRule("URIPathNameCS-0", 111,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				216		/* PathNameCS::ownedPathElements+=URIFirstPathElementCS || value */,
				155		/* V00*2-steps || value */,
				114		/* '::' || no-space value no-space */,
				218		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 50/* NextPathElementCS,URIFirstPathElementCS */,
					(58/*NextPathElementCS*/ << 4) | 2 /*[*]*/,
					(110/*URIFirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::UnlimitedNaturalLiteralExpCS-0(essentialoclcs::UnlimitedNaturalLiteralExpCS): "*"
		serializationRules[82] = createSerializationRule("UnlimitedNaturalLiteralExpCS-0", 113,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				109		/* '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// QVTbase::AttributeCS-0(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[83] = createSerializationRule("AttributeCS-0", 1,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				86		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				171		/* assign V2 = |StructuralFeatureCS::default| */,
				157		/* assign V1 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				133		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				51		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				178		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				193		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				122		/* 'attribute' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				171		/* V02*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				182		/* V03*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				183		/* V04*1-steps || value */,
				225		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 0 /*[1]*/,
					(18/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-1(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[84] = createSerializationRule("AttributeCS-1", 1,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				224		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				171		/* assign V2 = |StructuralFeatureCS::default| */,
				157		/* assign V1 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				133		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				51		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				178		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				193		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				198		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				201		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				208		/* assign V7 = 0 */,
				212		/* assign V8 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				122		/* 'attribute' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				171		/* V02*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				182		/* V03*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				183		/* V04*1-steps || value */,
				225		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				193		/* V05*5-steps || value */,
				126		/* 'derivation' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				194		/* V06*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				202		/* V07*5-steps || value */,
				134		/* 'initial' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				203		/* V08*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 0 /*[1]*/,
					(18/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-2(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[85] = createSerializationRule("AttributeCS-2", 1,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				86		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				171		/* assign V2 = |StructuralFeatureCS::default| */,
				157		/* assign V1 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				132		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				52		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				178		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				193		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				122		/* 'attribute' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				171		/* V02*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				182		/* V03*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				183		/* V04*1-steps || value */,
				225		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 1 /*[?]*/,
					(18/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-3(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[86] = createSerializationRule("AttributeCS-3", 1,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				224		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				171		/* assign V2 = |StructuralFeatureCS::default| */,
				157		/* assign V1 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				132		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				52		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				178		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				193		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				198		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				201		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				208		/* assign V7 = 0 */,
				212		/* assign V8 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				122		/* 'attribute' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				171		/* V02*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				182		/* V03*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				183		/* V04*1-steps || value */,
				225		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				193		/* V05*5-steps || value */,
				126		/* 'derivation' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				194		/* V06*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				202		/* V07*5-steps || value */,
				134		/* 'initial' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				203		/* V08*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 1 /*[?]*/,
					(18/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-4(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[87] = createSerializationRule("AttributeCS-4", 1,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				86		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				153		/* assign V1 = |StructuralFeatureCS::default| */,
				131		/* assign V0 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				166		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				185		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				122		/* 'attribute' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				164		/* V01*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				174		/* V02*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				178		/* V03*1-steps || value */,
				225		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-5(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[88] = createSerializationRule("AttributeCS-5", 1,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				224		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				153		/* assign V1 = |StructuralFeatureCS::default| */,
				131		/* assign V0 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				166		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				185		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				190		/* assign V4 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				196		/* assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				203		/* assign V6 = 0 */,
				208		/* assign V7 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				122		/* 'attribute' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				164		/* V01*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				174		/* V02*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				178		/* V03*1-steps || value */,
				225		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				187		/* V04*5-steps || value */,
				126		/* 'derivation' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				188		/* V05*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				197		/* V06*5-steps || value */,
				134		/* 'initial' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				198		/* V07*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::CompoundTargetElementCS-0(qvtbasecs::CompoundTargetElementCS): { "{" ownedTargetElements+=SimpleTargetElementCS[*] "}" }
		serializationRules[89] = createSerializationRule("CompoundTargetElementCS-0", 11,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				293		/* check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : SimpleTargetElementCS */,
				113		/* assign V0 = |CompoundTargetElementCS::ownedTargetElements| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				148		/* '{' || soft-space value push soft-new-line */,
				152		/* V00*1-steps || value */,
				74		/* CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 27/* SimpleTargetElementCS */,
					(81/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::DataTypeCS-0(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[90] = createSerializationRule("DataTypeCS-0", 14,
			createSerializationMatchSteps(
				59		/* assert |DataTypeCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				169		/* assign V2 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				114		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				179		/* assign V3 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				8		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				125		/* 'datatype' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				181		/* V03*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				104		/* '!serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(16/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-1(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" "}" } }
		serializationRules[91] = createSerializationRule("DataTypeCS-1", 14,
			createSerializationMatchSteps(
				59		/* assert |DataTypeCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				169		/* assign V2 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				114		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				179		/* assign V3 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				8		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				125		/* 'datatype' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				181		/* V03*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				104		/* '!serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(16/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-2(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[92] = createSerializationRule("DataTypeCS-2", 14,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				181		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				169		/* assign V2 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				114		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				8		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				125		/* 'datatype' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				181		/* V03*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				9		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(16/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(17/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-3(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" "}" } }
		serializationRules[93] = createSerializationRule("DataTypeCS-3", 14,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				181		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				169		/* assign V2 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				114		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				8		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				125		/* 'datatype' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				181		/* V03*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				9		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(16/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(17/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-4(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[94] = createSerializationRule("DataTypeCS-4", 14,
			createSerializationMatchSteps(
				59		/* assert |DataTypeCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				169		/* assign V2 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				114		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				179		/* assign V3 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				8		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				125		/* 'datatype' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				179		/* V03*2-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(16/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-5(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" "}" } }
		serializationRules[95] = createSerializationRule("DataTypeCS-5", 14,
			createSerializationMatchSteps(
				59		/* assert |DataTypeCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				169		/* assign V2 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				114		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				179		/* assign V3 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				8		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				125		/* 'datatype' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				179		/* V03*2-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(16/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-0(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[96] = createSerializationRule("EnumerationCS-0", 18,
			createSerializationMatchSteps(
				60		/* assert |EnumerationCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				61		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				148		/* assign V1 = |ClassCS::instanceClassName| */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				167		/* assign V2 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				130		/* 'enum' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				173		/* V02*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				104		/* '!serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-1(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[97] = createSerializationRule("EnumerationCS-1", 18,
			createSerializationMatchSteps(
				60		/* assert |EnumerationCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				218		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				182		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				148		/* assign V1 = |ClassCS::instanceClassName| */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				167		/* assign V2 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				130		/* 'enum' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				173		/* V02*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				104		/* '!serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				177		/* V03*1-steps || value */,
				48		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 5/* EnumerationLiteralCS */,
					(19/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-2(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[98] = createSerializationRule("EnumerationCS-2", 18,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				61		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				170		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				148		/* assign V1 = |ClassCS::instanceClassName| */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				130		/* 'enum' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				173		/* V02*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				10		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(17/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-3(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[99] = createSerializationRule("EnumerationCS-3", 18,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				218		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				182		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				170		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				148		/* assign V1 = |ClassCS::instanceClassName| */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				130		/* 'enum' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				173		/* V02*3-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				10		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				177		/* V03*1-steps || value */,
				48		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(17/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 5/* EnumerationLiteralCS */,
					(19/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-4(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[100] = createSerializationRule("EnumerationCS-4", 18,
			createSerializationMatchSteps(
				60		/* assert |EnumerationCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				61		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				148		/* assign V1 = |ClassCS::instanceClassName| */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				167		/* assign V2 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				130		/* 'enum' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				171		/* V02*2-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-5(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[101] = createSerializationRule("EnumerationCS-5", 18,
			createSerializationMatchSteps(
				60		/* assert |EnumerationCS::isSerializable| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				218		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				182		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				148		/* assign V1 = |ClassCS::instanceClassName| */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				167		/* assign V2 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				130		/* 'enum' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				171		/* V02*2-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				177		/* V03*1-steps || value */,
				48		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 5/* EnumerationLiteralCS */,
					(19/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationLiteralCS-0(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] ";" }
		serializationRules[102] = createSerializationRule("EnumerationLiteralCS-0", 19,
			createSerializationMatchSteps(
				62		/* assert |EnumerationLiteralCS::literal| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				115		/* assign V0 = |EnumerationLiteralCS::value| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				138		/* 'literal' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				102		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-1(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[103] = createSerializationRule("EnumerationLiteralCS-1", 19,
			createSerializationMatchSteps(
				62		/* assert |EnumerationLiteralCS::literal| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				115		/* assign V0 = |EnumerationLiteralCS::value| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				138		/* 'literal' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				102		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-2(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] ";" }
		serializationRules[104] = createSerializationRule("EnumerationLiteralCS-2", 19,
			createSerializationMatchSteps(
				62		/* assert |EnumerationLiteralCS::literal| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				115		/* assign V0 = |EnumerationLiteralCS::value| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				213		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				102		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-3(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[105] = createSerializationRule("EnumerationLiteralCS-3", 19,
			createSerializationMatchSteps(
				62		/* assert |EnumerationLiteralCS::literal| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				115		/* assign V0 = |EnumerationLiteralCS::value| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				213		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				102		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::OperationCS-0(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[106] = createSerializationRule("OperationCS-0", 61,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				74		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				75		/* assert |OperationCS::ownedPostconditions| == 0 */,
				76		/* assert |OperationCS::ownedPreconditions| == 0 */,
				220		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				221		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				191		/* assign V4 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				133		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				51		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				195		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				200		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				162		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				175		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				207		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				214		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				140		/* 'operation' || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				107		/* '(' || no-space value no-space */,
				174		/* V02*4-steps || value */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				180		/* V03*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				108		/* ')' || no-space value */,
				184		/* V04*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				192		/* V05*5-steps || value */,
				146		/* 'throws' || soft-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				195		/* V06*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				201		/* V07*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				205		/* V08*1-steps || value */,
				226		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 0 /*[1]*/,
					(18/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 18/* ParameterCS */,
					(62/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-1(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[107] = createSerializationRule("OperationCS-1", 61,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |OperationCS::ownedPostconditions| == 0 */,
				76		/* assert |OperationCS::ownedPreconditions| == 0 */,
				219		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				220		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				221		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				191		/* assign V4 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				133		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				51		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				215		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				160		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				195		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				200		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				162		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				175		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				207		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				214		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				140		/* 'operation' || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				107		/* '(' || no-space value no-space */,
				174		/* V02*4-steps || value */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				180		/* V03*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				108		/* ')' || no-space value */,
				184		/* V04*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				192		/* V05*5-steps || value */,
				146		/* 'throws' || soft-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				195		/* V06*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				201		/* V07*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				205		/* V08*1-steps || value */,
				226		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				208		/* V09*5-steps || value */,
				123		/* 'body' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				168		/* V10*1-steps || value */,
				20		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 0 /*[1]*/,
					(18/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 18/* ParameterCS */,
					(62/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-2(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[108] = createSerializationRule("OperationCS-2", 61,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				74		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				75		/* assert |OperationCS::ownedPostconditions| == 0 */,
				76		/* assert |OperationCS::ownedPreconditions| == 0 */,
				220		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				221		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				191		/* assign V4 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				132		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				52		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				195		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				200		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				162		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				175		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				207		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				214		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				140		/* 'operation' || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				107		/* '(' || no-space value no-space */,
				174		/* V02*4-steps || value */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				180		/* V03*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				108		/* ')' || no-space value */,
				184		/* V04*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				192		/* V05*5-steps || value */,
				146		/* 'throws' || soft-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				195		/* V06*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				201		/* V07*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				205		/* V08*1-steps || value */,
				226		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 1 /*[?]*/,
					(18/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 18/* ParameterCS */,
					(62/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-3(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[109] = createSerializationRule("OperationCS-3", 61,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |OperationCS::ownedPostconditions| == 0 */,
				76		/* assert |OperationCS::ownedPreconditions| == 0 */,
				219		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				220		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				221		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				191		/* assign V4 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				132		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				52		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				215		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				160		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				195		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				200		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				162		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				175		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				207		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				214		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				140		/* 'operation' || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				107		/* '(' || no-space value no-space */,
				174		/* V02*4-steps || value */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				180		/* V03*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				108		/* ')' || no-space value */,
				184		/* V04*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				192		/* V05*5-steps || value */,
				146		/* 'throws' || soft-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				195		/* V06*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				201		/* V07*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				205		/* V08*1-steps || value */,
				226		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				208		/* V09*5-steps || value */,
				123		/* 'body' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				168		/* V10*1-steps || value */,
				20		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 1 /*[?]*/,
					(18/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 18/* ParameterCS */,
					(62/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-4(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[110] = createSerializationRule("OperationCS-4", 61,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				74		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				75		/* assert |OperationCS::ownedPostconditions| == 0 */,
				76		/* assert |OperationCS::ownedPreconditions| == 0 */,
				220		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				221		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				184		/* assign V3 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				202		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				210		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				187		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				194		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				142		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				161		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				140		/* 'operation' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				107		/* '(' || no-space value no-space */,
				167		/* V01*4-steps || value */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				108		/* ')' || no-space value */,
				179		/* V03*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				186		/* V04*5-steps || value */,
				146		/* 'throws' || soft-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				190		/* V05*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				196		/* V06*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				200		/* V07*1-steps || value */,
				226		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 18/* ParameterCS */,
					(62/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-5(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[111] = createSerializationRule("OperationCS-5", 61,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				75		/* assert |OperationCS::ownedPostconditions| == 0 */,
				76		/* assert |OperationCS::ownedPreconditions| == 0 */,
				219		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				220		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				221		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				184		/* assign V3 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				129		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				211		/* assign V8 = (|OperationCS::ownedBodyExpressions| > 0) */,
				217		/* assign V9 = |OperationCS::ownedBodyExpressions| */,
				202		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				210		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				187		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				194		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				142		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				161		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				140		/* 'operation' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				107		/* '(' || no-space value no-space */,
				167		/* V01*4-steps || value */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				54		/* OperationCS::ownedParameters+=ParameterCS || value */,
				108		/* ')' || no-space value */,
				179		/* V03*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				186		/* V04*5-steps || value */,
				146		/* 'throws' || soft-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				190		/* V05*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				29		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				196		/* V06*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				200		/* V07*1-steps || value */,
				226		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				206		/* V08*5-steps || value */,
				123		/* 'body' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				207		/* V09*1-steps || value */,
				20		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 18/* ParameterCS */,
					(62/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ParameterCS-0(basecs::ParameterCS): { name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "{" { qualifiers+={'!ordered|!unique|ordered|unique'} }[+] "}" }[?] { "{" "}" }[?] }
		serializationRules[112] = createSerializationRule("ParameterCS-0", 62,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				131		/* assign V0 = |TypedElementCS::ownedType| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0) */,
				173		/* assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| */,
				179		/* assign V3 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				167		/* V01*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				170		/* V02*1-steps || value */,
				227		/* TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				179		/* V03*2-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(3/*'!ordered|!unique|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ReferenceCS-0(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[113] = createSerializationRule("ReferenceCS-0", 72,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				86		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				77		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				78		/* assert |ReferenceCS::referredKeys| == 0 */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				183		/* assign V3 = |StructuralFeatureCS::default| */,
				172		/* assign V2 = |TypedElementCS::ownedType| */,
				152		/* assign V1 = |ReferenceCS::referredOpposite| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				133		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				51		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				188		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				199		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				142		/* 'property' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				105		/* '#' || no-space value no-space */,
				93		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				179		/* V03*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				185		/* V04*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				189		/* V05*1-steps || value */,
				224		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 0 /*[1]*/,
					(18/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-1(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[114] = createSerializationRule("ReferenceCS-1", 72,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				77		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				78		/* assert |ReferenceCS::referredKeys| == 0 */,
				224		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				183		/* assign V3 = |StructuralFeatureCS::default| */,
				172		/* assign V2 = |TypedElementCS::ownedType| */,
				152		/* assign V1 = |ReferenceCS::referredOpposite| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				133		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				51		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				188		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				199		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				204		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				206		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				212		/* assign V8 = 0 */,
				216		/* assign V9 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				142		/* 'property' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				105		/* '#' || no-space value no-space */,
				93		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				179		/* V03*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				185		/* V04*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				189		/* V05*1-steps || value */,
				224		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				197		/* V06*5-steps || value */,
				126		/* 'derivation' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				198		/* V07*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				206		/* V08*5-steps || value */,
				134		/* 'initial' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				207		/* V09*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 0 /*[1]*/,
					(18/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-2(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[115] = createSerializationRule("ReferenceCS-2", 72,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				86		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				77		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				78		/* assert |ReferenceCS::referredKeys| == 0 */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				183		/* assign V3 = |StructuralFeatureCS::default| */,
				172		/* assign V2 = |TypedElementCS::ownedType| */,
				152		/* assign V1 = |ReferenceCS::referredOpposite| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				132		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				52		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				188		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				199		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				142		/* 'property' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				105		/* '#' || no-space value no-space */,
				93		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				179		/* V03*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				185		/* V04*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				189		/* V05*1-steps || value */,
				224		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 1 /*[?]*/,
					(18/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-3(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[116] = createSerializationRule("ReferenceCS-3", 72,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				77		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				78		/* assert |ReferenceCS::referredKeys| == 0 */,
				224		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				183		/* assign V3 = |StructuralFeatureCS::default| */,
				172		/* assign V2 = |TypedElementCS::ownedType| */,
				152		/* assign V1 = |ReferenceCS::referredOpposite| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				132		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				52		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				188		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				199		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				204		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				206		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				212		/* assign V8 = 0 */,
				216		/* assign V9 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				229		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				228		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				142		/* 'property' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				105		/* '#' || no-space value no-space */,
				93		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				171		/* V02*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				179		/* V03*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				185		/* V04*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				189		/* V05*1-steps || value */,
				224		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				197		/* V06*5-steps || value */,
				126		/* 'derivation' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				198		/* V07*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				206		/* V08*5-steps || value */,
				134		/* 'initial' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				207		/* V09*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(11/*'definition'*/ << 4) | 1 /*[?]*/,
					(18/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-4(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[117] = createSerializationRule("ReferenceCS-4", 72,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				86		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				77		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				78		/* assert |ReferenceCS::referredKeys| == 0 */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				171		/* assign V2 = |StructuralFeatureCS::default| */,
				157		/* assign V1 = |TypedElementCS::ownedType| */,
				124		/* assign V0 = |ReferenceCS::referredOpposite| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				177		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				192		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				142		/* 'property' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				105		/* '#' || no-space value no-space */,
				93		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				171		/* V02*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				182		/* V03*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				183		/* V04*1-steps || value */,
				224		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-5(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[118] = createSerializationRule("ReferenceCS-5", 72,
			createSerializationMatchSteps(
				91		/* assert |TypedElementCS::isOptional| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				77		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				78		/* assert |ReferenceCS::referredKeys| == 0 */,
				224		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				235		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				171		/* assign V2 = |StructuralFeatureCS::default| */,
				157		/* assign V1 = |TypedElementCS::ownedType| */,
				124		/* assign V0 = |ReferenceCS::referredOpposite| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				177		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				192		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				198		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				201		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				208		/* assign V7 = 0 */,
				212		/* assign V8 = 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				142		/* 'property' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				105		/* '#' || no-space value no-space */,
				93		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				164		/* V01*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				222		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				171		/* V02*2-steps || value */,
				116		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				182		/* V03*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				183		/* V04*1-steps || value */,
				224		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				193		/* V05*5-steps || value */,
				126		/* 'derivation' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				194		/* V06*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				202		/* V07*5-steps || value */,
				134		/* 'initial' || soft-space value soft-space */,
				113		/* ':' || soft-space value soft-space */,
				203		/* V08*1-steps || value */,
				27		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				115		/* ';' || no-space value soft-new-line */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 29/* SpecificationCS */,
					(82/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 47/* TypedMultiplicityRefCS */,
					(104/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-0(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[119] = createSerializationRule("SimpleTargetElementCS-0", 81,
			createSerializationMatchSteps(
				83		/* assert |SimpleTargetElementCS::output| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |SimpleTargetElementCS::via| == 0 */,
				125		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				43		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				41		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				2		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				100		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				136		/* 'iterates' || soft-space value soft-space */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(13/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-1(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[120] = createSerializationRule("SimpleTargetElementCS-1", 81,
			createSerializationMatchSteps(
				83		/* assert |SimpleTargetElementCS::output| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |SimpleTargetElementCS::via| == 0 */,
				43		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				41		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */,
				102		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				143		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				163		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				2		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				100		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				161		/* V00*8-steps || value */,
				136		/* 'iterates' || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				167		/* V01*4-steps || value */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(13/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-2(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[121] = createSerializationRule("SimpleTargetElementCS-2", 81,
			createSerializationMatchSteps(
				82		/* assert |SimpleTargetElementCS::input| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |SimpleTargetElementCS::via| == 0 */,
				125		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				43		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				42		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				17		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				100		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				136		/* 'iterates' || soft-space value soft-space */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(15/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-3(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[122] = createSerializationRule("SimpleTargetElementCS-3", 81,
			createSerializationMatchSteps(
				82		/* assert |SimpleTargetElementCS::input| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |SimpleTargetElementCS::via| == 0 */,
				43		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				42		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */,
				102		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				143		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				163		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				17		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				100		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				161		/* V00*8-steps || value */,
				136		/* 'iterates' || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				167		/* V01*4-steps || value */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(15/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-4(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[123] = createSerializationRule("SimpleTargetElementCS-4", 81,
			createSerializationMatchSteps(
				82		/* assert |SimpleTargetElementCS::input| == 0 */,
				83		/* assert |SimpleTargetElementCS::output| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				125		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				43		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				44		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				103		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				100		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				154		/* V00*2-steps || value */,
				136		/* 'iterates' || soft-space value soft-space */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(19/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-5(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[124] = createSerializationRule("SimpleTargetElementCS-5", 81,
			createSerializationMatchSteps(
				82		/* assert |SimpleTargetElementCS::input| == 0 */,
				83		/* assert |SimpleTargetElementCS::output| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				43		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				44		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */,
				102		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				143		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				163		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				103		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				100		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				161		/* V00*8-steps || value */,
				136		/* 'iterates' || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				167		/* V01*4-steps || value */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				11		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(19/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SpecificationCS-0(essentialoclcs::ExpSpecificationCS): ownedExpression=ExpCS
		serializationRules[125] = createSerializationRule("SpecificationCS-0", 82,
			createSerializationMatchSteps(
				85		/* assert |SpecificationCS::exprString| == 0 */,
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				256		/* check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				7		/* assert (|ExpSpecificationCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				33		/* ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 6/* ExpCS */,
					(27/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::SpecificationCS-1(essentialoclcs::ExpSpecificationCS): exprString=UNQUOTED_STRING
		serializationRules[126] = createSerializationRule("SpecificationCS-1", 82,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				63		/* assert |ExpSpecificationCS::ownedExpression| == 0 */,
				45		/* assert (|SpecificationCS::exprString| - 1) == 0 */
			),
			createSerializationSteps(
				1		/* SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, true, GrammarCardinality.ONE)
			});
		// QVTbase::StructuredClassCS-0(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] ";" }
		serializationRules[127] = createSerializationRule("StructuredClassCS-0", 87,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				87		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				88		/* assert |StructuredClassCS::ownedOperations| == 0 */,
				89		/* assert |StructuredClassCS::ownedProperties| == 0 */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				227		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				189		/* assign V4 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				127		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				197		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				205		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				164		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				176		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				4		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				124		/* 'class' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				175		/* V02*5-steps || value */,
				131		/* 'extends' || soft-space value soft-space */,
				73		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				180		/* V03*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				73		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				184		/* V04*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				191		/* V05*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				194		/* V06*1-steps || value */,
				5		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				115		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, false,
					(10/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, false,
					(14/*'interface'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
	}
	private void initSerializationRules2() {
		// QVTbase::StructuredClassCS-1(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] { "{" { ownedOperations+=OperationCS[*] ownedProperties+=StructuralFeatureCS[*] } "}" } }
		serializationRules[128] = createSerializationRule("StructuredClassCS-1", 87,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert |ClassCS::ownedConstraints| == 0 */,
				87		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				225		/* check-rule basecs::StructuredClassCS.ownedOperations : OperationCS */,
				226		/* check-rule basecs::StructuredClassCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				232		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				227		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				213		/* assign V8 = |StructuredClassCS::ownedProperties| */,
				209		/* assign V7 = |StructuredClassCS::ownedOperations| */,
				189		/* assign V4 = |ClassCS::instanceClassName| */,
				155		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */,
				127		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				197		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				205		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				164		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				176		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* V00*1-steps || value */,
				4		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				124		/* 'class' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* V01*1-steps || value */,
				70		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				175		/* V02*5-steps || value */,
				131		/* 'extends' || soft-space value soft-space */,
				73		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				180		/* V03*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				73		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				184		/* V04*2-steps || value */,
				113		/* ':' || soft-space value soft-space */,
				3		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				191		/* V05*4-steps || value */,
				148		/* '{' || soft-space value push soft-new-line */,
				194		/* V06*1-steps || value */,
				5		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				150		/* '}' || pop soft-space value soft-new-line */,
				148		/* '{' || soft-space value push soft-new-line */,
				199		/* V07*1-steps || value */,
				53		/* StructuredClassCS::ownedOperations+=OperationCS || value */,
				204		/* V08*1-steps || value */,
				67		/* StructuredClassCS::ownedProperties+=StructuralFeatureCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, false,
					(10/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, false,
					(14/*'interface'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 17/* OperationCS */,
					(61/*OperationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 32/* StructuralFeatureCS */,
					(86/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 37/* TemplateSignatureCS */,
					(91/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 48/* TypedRefCS */,
					(105/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::TargetCS-0(qvtbasecs::TargetCS): { "target" name=UnrestrictedName "{" ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)[*] "}" }
		serializationRules[129] = createSerializationRule("TargetCS-0", 88,
			createSerializationMatchSteps(
				66		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				294		/* check-rule qvtbasecs::TargetCS.ownedTargetElements : CompoundTargetElementCS|SimpleTargetElementCS */,
				128		/* assign V0 = |TargetCS::ownedTargetElements| */,
				24		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				209		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				144		/* 'target' || soft-space value soft-space */,
				211		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				148		/* '{' || soft-space value push soft-new-line */,
				152		/* V00*1-steps || value */,
				75		/* TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value */,
				150		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 28/* CompoundTargetElementCS,SimpleTargetElementCS */,
					(11/*CompoundTargetElementCS*/ << 4) | 2 /*[*]*/,
					(81/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[130] = createSerializationRule("TypedMultiplicityRefCS-0", 104,
			createSerializationMatchSteps(
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				134		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				38		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				15		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				151		/* V00*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-1(basecs::TypedTypeRefCS): { { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[131] = createSerializationRule("TypedMultiplicityRefCS-1", 104,
			createSerializationMatchSteps(
				94		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				238		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				239		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				158		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				135		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				53		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				64		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				156		/* V00*3-steps || value */,
				107		/* '(' || no-space value no-space */,
				19		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				108		/* ')' || no-space value */,
				162		/* V01*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 35/* TemplateBindingCS */,
					(89/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 19/* PathNameCS */,
					(63/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-2(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[132] = createSerializationRule("TypedMultiplicityRefCS-2", 104,
			createSerializationMatchSteps(
				252		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				253		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				174		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				112		/* assign V0 = |CollectionTypeCS::ownedType| */,
				5		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				149		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				13		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				81		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				162		/* V01*1-steps || value */,
				22		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				108		/* ')' || no-space value */,
				169		/* V02*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 41/* TypeExpWithoutMultiplicityCS */,
					(97/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-3(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[133] = createSerializationRule("TypedMultiplicityRefCS-3", 104,
			createSerializationMatchSteps(
				272		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				273		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				158		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				118		/* assign V0 = |MapTypeCS::ownedValueType| */,
				20		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				19		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				14		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				158		/* V00*5-steps || value */,
				107		/* '(' || no-space value no-space */,
				45		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				111		/* ',' || no-space value soft-space */,
				87		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				108		/* ')' || no-space value */,
				162		/* V01*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(8/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 40/* TypeExpCS */,
					(96/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-4(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[134] = createSerializationRule("TypedMultiplicityRefCS-4", 104,
			createSerializationMatchSteps(
				237		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				233		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				186		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				47		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				107		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				144		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				165		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				16		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				160		/* V00*7-steps || value */,
				107		/* '(' || no-space value no-space */,
				167		/* V01*4-steps || value */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				172		/* V02*2-steps || value */,
				111		/* ',' || no-space value soft-space */,
				61		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				108		/* ')' || no-space value */,
				176		/* V03*1-steps || value */,
				50		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(9/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 11/* MultiplicityCS */,
					(47/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 39/* TuplePartCS */,
					(94/*TuplePartCS*/ << 4) | 2 /*[*]*/
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
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[4] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[5] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[6] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[7] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[8] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
	}

	/**
	 * Initialize the various serialization steps used to serialize a serialization rule.
	 */
	private void initSerializationSteps() {
		// 0: StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[0] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, 76 /*SINGLE_QUOTED_STRING*/, 6);
		// 1: SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[1] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, 107 /*UNQUOTED_STRING*/, 2);
		// 2: SimpleTargetElementCS::input?='input' || soft-space value soft-space
		serializationSteps[2] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 13 /* 'input' */, 6);
		// 3: ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[3] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, 76 /*SINGLE_QUOTED_STRING*/, 6);
		// 4: StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[4] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 10 /* 'abstract' */, 6);
		// 5: StructuredClassCS::isInterface?='interface' || soft-space value soft-space
		serializationSteps[5] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 14 /* 'interface' */, 6);
		// 6: MultiplicityCS::isNullFree?='|1' || no-space value no-space
		serializationSteps[6] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 21 /* '|1' */, 3);
		// 7: AbstractNameExpCS::isPre?='@' || soft-space value soft-space
		serializationSteps[7] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 7 /* '@' */, 6);
		// 8: DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space
		serializationSteps[8] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 16 /* 'primitive' */, 6);
		// 9: DataTypeCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[9] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 17 /* 'serializable' */, 6);
		// 10: EnumerationCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[10] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 17 /* 'serializable' */, 6);
		// 11: SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space
		serializationSteps[11] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, "UnrestrictedName"), 116, 6);
		// 12: MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space
		serializationSteps[12] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, 36 /*LOWER*/, 6);
		// 13: CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space
		serializationSteps[13] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, 10 /*CollectionTypeIdentifier*/, 6);
		// 14: MapTypeCS::name='Map' || soft-space value soft-space
		serializationSteps[14] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 8 /* 'Map' */, 6);
		// 15: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space
		serializationSteps[15] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, 70 /*PrimitiveTypeIdentifier*/, 6);
		// 16: TupleTypeCS::name='Tuple' || soft-space value soft-space
		serializationSteps[16] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 9 /* 'Tuple' */, 6);
		// 17: SimpleTargetElementCS::output?='output' || soft-space value soft-space
		serializationSteps[17] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 15 /* 'output' */, 6);
		// 18: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[18] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 103 /*TypeRefCS*/, 2);
		// 19: TypedTypeRefCS::ownedBinding=TemplateBindingCS || value
		serializationSteps[19] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 89 /*TemplateBindingCS*/, 0);
		// 20: OperationCS::ownedBodyExpressions+=SpecificationCS || value
		serializationSteps[20] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 82 /*SpecificationCS*/, 0);
		// 21: NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value
		serializationSteps[21] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 5 /*CoIteratorVariableCS*/, 0);
		// 22: CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value
		serializationSteps[22] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 47 /*MultiplicityCS*/, 0);
		// 23: IfExpCS::ownedCondition=ExpCS|PatternExpCS || value
		serializationSteps[23] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, -1, new int[] { 27/*ExpCS*/,64/*PatternExpCS*/}, 0);
		// 24: IfThenExpCS::ownedCondition=ExpCS || value
		serializationSteps[24] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 27 /*ExpCS*/, 0);
		// 25: AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[25] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 12 /*CurlyBracketedClauseCS*/, 0);
		// 26: TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[26] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 12 /*CurlyBracketedClauseCS*/, 0);
		// 27: StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value
		serializationSteps[27] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 82 /*SpecificationCS*/, 0);
		// 28: IfExpCS::ownedElseExpression=ExpCS || value
		serializationSteps[28] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 27 /*ExpCS*/, 0);
		// 29: OperationCS::ownedExceptions+=TypedRefCS || value
		serializationSteps[29] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 105 /*TypedRefCS*/, 0);
		// 30: CollectionLiteralPartCS::ownedExpression=ExpCS || value
		serializationSteps[30] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 27 /*ExpCS*/, 0);
		// 31: CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[31] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 64 /*PatternExpCS*/, 2);
		// 32: ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[32] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 27 /*ExpCS*/, 2);
		// 33: ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[33] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 27 /*ExpCS*/, 2);
		// 34: NestedExpCS::ownedExpression=ExpCS || value
		serializationSteps[34] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 27 /*ExpCS*/, 0);
		// 35: LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value
		serializationSteps[35] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 27 /*ExpCS*/, 0);
		// 36: TypeParameterCS::ownedExtends+=TypedRefCS || value
		serializationSteps[36] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 105 /*TypedRefCS*/, 0);
		// 37: WildcardTypeRefCS::ownedExtends=TypedRefCS || value
		serializationSteps[37] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 105 /*TypedRefCS*/, 0);
		// 38: IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value
		serializationSteps[38] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 17 /*ElseIfThenExpCS*/, 0);
		// 39: LetExpCS::ownedInExpression=ExpCS || value
		serializationSteps[39] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 27 /*ExpCS*/, 0);
		// 40: NavigatingArgCS::ownedInitExpression=ExpCS || value
		serializationSteps[40] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 27 /*ExpCS*/, 0);
		// 41: ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value
		serializationSteps[41] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, -1, new int[] { 27/*ExpCS*/,64/*PatternExpCS*/}, 0);
		// 42: ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[42] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 85 /*StringLiteralExpCS*/, 2);
		// 43: VariableCS::ownedInitExpression=ExpCS || value
		serializationSteps[43] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 27 /*ExpCS*/, 0);
		// 44: MapLiteralPartCS::ownedKey=ExpCS || value
		serializationSteps[44] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 27 /*ExpCS*/, 0);
		// 45: MapTypeCS::ownedKeyType=TypeExpCS || value
		serializationSteps[45] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 96 /*TypeExpCS*/, 0);
		// 46: CollectionLiteralPartCS::ownedLastExpression=ExpCS || value
		serializationSteps[46] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 27 /*ExpCS*/, 0);
		// 47: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value
		serializationSteps[47] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 66 /*PrefixedPrimaryExpCS*/, 0);
		// 48: EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value
		serializationSteps[48] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 19 /*EnumerationLiteralCS*/, 0);
		// 49: TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[49] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 47 /*MultiplicityCS*/, 0);
		// 50: TypedRefCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[50] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 47 /*MultiplicityCS*/, 0);
		// 51: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value
		serializationSteps[51] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 52 /*NavigatingArgExpCS*/, 0);
		// 52: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[52] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 52 /*NavigatingArgExpCS*/, 2);
		// 53: StructuredClassCS::ownedOperations+=OperationCS || value
		serializationSteps[53] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 61 /*OperationCS*/, 0);
		// 54: OperationCS::ownedParameters+=ParameterCS || value
		serializationSteps[54] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 62 /*ParameterCS*/, 0);
		// 55: TemplateSignatureCS::ownedParameters+=TypeParameterCS || value
		serializationSteps[55] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 102 /*TypeParameterCS*/, 0);
		// 56: CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value
		serializationSteps[56] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 7 /*CollectionLiteralPartCS*/, 0);
		// 57: CollectionPatternCS::ownedParts+=PatternExpCS || value
		serializationSteps[57] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 64 /*PatternExpCS*/, 0);
		// 58: CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value
		serializationSteps[58] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 79 /*ShadowPartCS*/, 0);
		// 59: MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value
		serializationSteps[59] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 43 /*MapLiteralPartCS*/, 0);
		// 60: TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value
		serializationSteps[60] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 93 /*TupleLiteralPartCS*/, 0);
		// 61: TupleTypeCS::ownedParts+=TuplePartCS || value
		serializationSteps[61] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 94 /*TuplePartCS*/, 0);
		// 62: AbstractNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[62] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 63 /*PathNameCS*/, 0);
		// 63: TypeNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[63] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 63 /*PathNameCS*/, 0);
		// 64: TypedTypeRefCS::ownedPathName=PathNameCS || value
		serializationSteps[64] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 63 /*PathNameCS*/, 0);
		// 65: TypeNameExpCS::ownedPatternGuard=ExpCS || value
		serializationSteps[65] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 27 /*ExpCS*/, 0);
		// 66: PatternExpCS::ownedPatternType=TypeExpCS || value
		serializationSteps[66] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 96 /*TypeExpCS*/, 0);
		// 67: StructuredClassCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[67] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 86 /*StructuralFeatureCS*/, 0);
		// 68: AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[68] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 73 /*RoundBracketedClauseCS*/, 0);
		// 69: LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[69] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 73 /*RoundBracketedClauseCS*/, 0);
		// 70: TemplateableElementCS::ownedSignature=TemplateSignatureCS || value
		serializationSteps[70] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 91 /*TemplateSignatureCS*/, 0);
		// 71: AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value
		serializationSteps[71] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 83 /*SquareBracketedClauseCS*/, 0);
		// 72: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value
		serializationSteps[72] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 90 /*TemplateParameterSubstitutionCS*/, 0);
		// 73: StructuredClassCS::ownedSuperTypes+=TypedRefCS || value
		serializationSteps[73] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 105 /*TypedRefCS*/, 0);
		// 74: CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value
		serializationSteps[74] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 81 /*SimpleTargetElementCS*/, 0);
		// 75: TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value
		serializationSteps[75] = createSerializationStepAssigns(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, -1, new int[] { 81/*SimpleTargetElementCS*/,11/*CompoundTargetElementCS*/}, 0);
		// 76: SquareBracketedClauseCS::ownedTerms+=ExpCS || value
		serializationSteps[76] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 27 /*ExpCS*/, 0);
		// 77: IfExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[77] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 27 /*ExpCS*/, 0);
		// 78: IfThenExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[78] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 27 /*ExpCS*/, 0);
		// 79: CollectionLiteralExpCS::ownedType=CollectionTypeCS || value
		serializationSteps[79] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 9 /*CollectionTypeCS*/, 0);
		// 80: CollectionPatternCS::ownedType=CollectionTypeCS || value
		serializationSteps[80] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 9 /*CollectionTypeCS*/, 0);
		// 81: CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value
		serializationSteps[81] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 97 /*TypeExpWithoutMultiplicityCS*/, 0);
		// 82: MapLiteralExpCS::ownedType=MapTypeCS || value
		serializationSteps[82] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 44 /*MapTypeCS*/, 0);
		// 83: NavigatingArgCS::ownedType=TypeExpCS || value
		serializationSteps[83] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 96 /*TypeExpCS*/, 0);
		// 84: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[84] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 100 /*TypeLiteralWithMultiplicityCS*/, 2);
		// 85: VariableCS::ownedType=TypeExpCS || value
		serializationSteps[85] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 96 /*TypeExpCS*/, 0);
		// 86: MapLiteralPartCS::ownedValue=ExpCS || value
		serializationSteps[86] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 27 /*ExpCS*/, 0);
		// 87: MapTypeCS::ownedValueType=TypeExpCS || value
		serializationSteps[87] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 96 /*TypeExpCS*/, 0);
		// 88: LetExpCS::ownedVariables+=LetVariableCS || value
		serializationSteps[88] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 39 /*LetVariableCS*/, 0);
		// 89: PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space
		serializationSteps[89] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, 116 /*UnrestrictedName*/, 6);
		// 90: NavigatingArgCS::prefix=';' || no-space value soft-new-line
		serializationSteps[90] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ';' */, 4);
		// 91: NavigatingArgCS::prefix=',' || no-space value soft-space
		serializationSteps[91] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 5 /* ',' */, 5);
		// 92: NavigatingArgCS::prefix='|' || soft-space value soft-space
		serializationSteps[92] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 20 /* '|' */, 6);
		// 93: ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space
		serializationSteps[93] = createSerializationStepCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, getCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, "UnrestrictedName"), 116, 6);
		// 94: ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space
		serializationSteps[94] = createSerializationStepCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, getCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, "UnrestrictedName"), 116, 6);
		// 95: CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space
		serializationSteps[95] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, 31 /*Identifier*/, 6);
		// 96: StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[96] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, 84 /*StringLiteral*/, 2);
		// 97: MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space
		serializationSteps[97] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 4 /* '*|+|?' */, 6);
		// 98: BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[98] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 12 /* 'false|true' */, 2);
		// 99: NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[99] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, 49 /*NUMBER_LITERAL*/, 2);
		// 100: SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[100] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, "UnrestrictedName"), 116, 6);
		// 101: MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space
		serializationSteps[101] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, 108 /*UPPER*/, 6);
		// 102: EnumerationLiteralCS::value=SIGNED || soft-space value soft-space
		serializationSteps[102] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, 74 /*SIGNED*/, 6);
		// 103: SimpleTargetElementCS::via?='via' || soft-space value soft-space
		serializationSteps[103] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 19 /* 'via' */, 6);
		// 104: '!serializable' || soft-space value soft-space
		serializationSteps[104] = createSerializationStepKeyword("!serializable", 6);
		// 105: '#' || no-space value no-space
		serializationSteps[105] = createSerializationStepKeyword("#", 3);
		// 106: '&&' || soft-space value soft-space
		serializationSteps[106] = createSerializationStepKeyword("&&", 6);
		// 107: '(' || no-space value no-space
		serializationSteps[107] = createSerializationStepKeyword("(", 3);
		// 108: ')' || no-space value
		serializationSteps[108] = createSerializationStepKeyword(")", 1);
		// 109: '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[109] = createSerializationStepKeyword("*", 2);
		// 110: '++' || soft-space value soft-space
		serializationSteps[110] = createSerializationStepKeyword("++", 6);
		// 111: ',' || no-space value soft-space
		serializationSteps[111] = createSerializationStepKeyword(",", 5);
		// 112: '..' || no-space value no-space
		serializationSteps[112] = createSerializationStepKeyword("..", 3);
		// 113: ':' || soft-space value soft-space
		serializationSteps[113] = createSerializationStepKeyword(":", 6);
		// 114: '::' || no-space value no-space
		serializationSteps[114] = createSerializationStepKeyword("::", 3);
		// 115: ';' || no-space value soft-new-line
		serializationSteps[115] = createSerializationStepKeyword(";", 4);
		// 116: '=' || soft-space value soft-space
		serializationSteps[116] = createSerializationStepKeyword("=", 6);
		// 117: '?' || soft-space value soft-space
		serializationSteps[117] = createSerializationStepKeyword("?", 6);
		// 118: 'Lambda' || soft-space value soft-space
		serializationSteps[118] = createSerializationStepKeyword("Lambda", 6);
		// 119: 'Tuple' || soft-space value soft-space
		serializationSteps[119] = createSerializationStepKeyword("Tuple", 6);
		// 120: '[' || no-space value no-space
		serializationSteps[120] = createSerializationStepKeyword("[", 3);
		// 121: ']' || no-space value
		serializationSteps[121] = createSerializationStepKeyword("]", 1);
		// 122: 'attribute' || soft-space value soft-space
		serializationSteps[122] = createSerializationStepKeyword("attribute", 6);
		// 123: 'body' || soft-space value soft-space
		serializationSteps[123] = createSerializationStepKeyword("body", 6);
		// 124: 'class' || soft-space value soft-space
		serializationSteps[124] = createSerializationStepKeyword("class", 6);
		// 125: 'datatype' || soft-space value soft-space
		serializationSteps[125] = createSerializationStepKeyword("datatype", 6);
		// 126: 'derivation' || soft-space value soft-space
		serializationSteps[126] = createSerializationStepKeyword("derivation", 6);
		// 127: 'else' || soft-space value soft-space
		serializationSteps[127] = createSerializationStepKeyword("else", 6);
		// 128: 'elseif' || soft-space value soft-space
		serializationSteps[128] = createSerializationStepKeyword("elseif", 6);
		// 129: 'endif' || soft-space value soft-space
		serializationSteps[129] = createSerializationStepKeyword("endif", 6);
		// 130: 'enum' || soft-space value soft-space
		serializationSteps[130] = createSerializationStepKeyword("enum", 6);
		// 131: 'extends' || soft-space value soft-space
		serializationSteps[131] = createSerializationStepKeyword("extends", 6);
		// 132: 'if' || soft-space value soft-space
		serializationSteps[132] = createSerializationStepKeyword("if", 6);
		// 133: 'in' || soft-space value soft-space
		serializationSteps[133] = createSerializationStepKeyword("in", 6);
		// 134: 'initial' || soft-space value soft-space
		serializationSteps[134] = createSerializationStepKeyword("initial", 6);
		// 135: 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[135] = createSerializationStepKeyword("invalid", 2);
		// 136: 'iterates' || soft-space value soft-space
		serializationSteps[136] = createSerializationStepKeyword("iterates", 6);
		// 137: 'let' || soft-space value soft-space
		serializationSteps[137] = createSerializationStepKeyword("let", 6);
		// 138: 'literal' || soft-space value soft-space
		serializationSteps[138] = createSerializationStepKeyword("literal", 6);
		// 139: 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[139] = createSerializationStepKeyword("null", 2);
		// 140: 'operation' || soft-space value soft-space
		serializationSteps[140] = createSerializationStepKeyword("operation", 6);
		// 141: 'pre' || soft-space value soft-space
		serializationSteps[141] = createSerializationStepKeyword("pre", 6);
		// 142: 'property' || soft-space value soft-space
		serializationSteps[142] = createSerializationStepKeyword("property", 6);
		// 143: 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[143] = createSerializationStepKeyword("self", 2);
		// 144: 'target' || soft-space value soft-space
		serializationSteps[144] = createSerializationStepKeyword("target", 6);
		// 145: 'then' || soft-space value soft-space
		serializationSteps[145] = createSerializationStepKeyword("then", 6);
		// 146: 'throws' || soft-space value soft-space
		serializationSteps[146] = createSerializationStepKeyword("throws", 6);
		// 147: 'with' || value
		serializationSteps[147] = createSerializationStepKeyword("with", 0);
		// 148: '{' || soft-space value push soft-new-line
		serializationSteps[148] = createSerializationStepKeyword("{", 8);
		// 149: '|?' || no-space value no-space
		serializationSteps[149] = createSerializationStepKeyword("|?", 3);
		// 150: '}' || pop soft-space value soft-new-line
		serializationSteps[150] = createSerializationStepKeyword("}", 7);
		// 151: V00*1-steps || value
		serializationSteps[151] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 1, 0);
		// 152: V00*1-steps || value
		serializationSteps[152] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 1, 0);
		// 153: V00*1-steps || value
		serializationSteps[153] = createSerializationStepSequence((0/*V0*/ << 4) | 3/*[+]*/, 1, 0);
		// 154: V00*2-steps || value
		serializationSteps[154] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 2, 0);
		// 155: V00*2-steps || value
		serializationSteps[155] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 2, 0);
		// 156: V00*3-steps || value
		serializationSteps[156] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 3, 0);
		// 157: V00*4-steps || value
		serializationSteps[157] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 4, 0);
		// 158: V00*5-steps || value
		serializationSteps[158] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 5, 0);
		// 159: V00*6-steps || value
		serializationSteps[159] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 6, 0);
		// 160: V00*7-steps || value
		serializationSteps[160] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 7, 0);
		// 161: V00*8-steps || value
		serializationSteps[161] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 8, 0);
		// 162: V01*1-steps || value
		serializationSteps[162] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 1, 0);
		// 163: V01*1-steps || value
		serializationSteps[163] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 1, 0);
		// 164: V01*2-steps || value
		serializationSteps[164] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 2, 0);
		// 165: V01*2-steps || value
		serializationSteps[165] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 2, 0);
		// 166: V01*3-steps || value
		serializationSteps[166] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 3, 0);
		// 167: V01*4-steps || value
		serializationSteps[167] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 4, 0);
		// 168: V10*1-steps || value
		serializationSteps[168] = createSerializationStepSequence((10/*V10*/ << 4) | 1/*[?]*/, 1, 0);
		// 169: V02*1-steps || value
		serializationSteps[169] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 1, 0);
		// 170: V02*1-steps || value
		serializationSteps[170] = createSerializationStepSequence((2/*V2*/ << 4) | 3/*[+]*/, 1, 0);
		// 171: V02*2-steps || value
		serializationSteps[171] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 2, 0);
		// 172: V02*2-steps || value
		serializationSteps[172] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 2, 0);
		// 173: V02*3-steps || value
		serializationSteps[173] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 3, 0);
		// 174: V02*4-steps || value
		serializationSteps[174] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 4, 0);
		// 175: V02*5-steps || value
		serializationSteps[175] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 5, 0);
		// 176: V03*1-steps || value
		serializationSteps[176] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 1, 0);
		// 177: V03*1-steps || value
		serializationSteps[177] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 1, 0);
		// 178: V03*1-steps || value
		serializationSteps[178] = createSerializationStepSequence((3/*V3*/ << 4) | 3/*[+]*/, 1, 0);
		// 179: V03*2-steps || value
		serializationSteps[179] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 2, 0);
		// 180: V03*2-steps || value
		serializationSteps[180] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 2, 0);
		// 181: V03*3-steps || value
		serializationSteps[181] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 3, 0);
		// 182: V03*4-steps || value
		serializationSteps[182] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 4, 0);
		// 183: V04*1-steps || value
		serializationSteps[183] = createSerializationStepSequence((4/*V4*/ << 4) | 3/*[+]*/, 1, 0);
		// 184: V04*2-steps || value
		serializationSteps[184] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 2, 0);
		// 185: V04*4-steps || value
		serializationSteps[185] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 4, 0);
		// 186: V04*5-steps || value
		serializationSteps[186] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 5, 0);
		// 187: V04*5-steps || value
		serializationSteps[187] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 5, 0);
		// 188: V05*1-steps || value
		serializationSteps[188] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 1, 0);
		// 189: V05*1-steps || value
		serializationSteps[189] = createSerializationStepSequence((5/*V5*/ << 4) | 3/*[+]*/, 1, 0);
		// 190: V05*2-steps || value
		serializationSteps[190] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 2, 0);
		// 191: V05*4-steps || value
		serializationSteps[191] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 4, 0);
		// 192: V05*5-steps || value
		serializationSteps[192] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 5, 0);
		// 193: V05*5-steps || value
		serializationSteps[193] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 5, 0);
		// 194: V06*1-steps || value
		serializationSteps[194] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 1, 0);
		// 195: V06*2-steps || value
		serializationSteps[195] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 2, 0);
		// 196: V06*4-steps || value
		serializationSteps[196] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 4, 0);
		// 197: V06*5-steps || value
		serializationSteps[197] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 5, 0);
		// 198: V07*1-steps || value
		serializationSteps[198] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 1, 0);
		// 199: V07*1-steps || value
		serializationSteps[199] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 1, 0);
		// 200: V07*1-steps || value
		serializationSteps[200] = createSerializationStepSequence((7/*V7*/ << 4) | 3/*[+]*/, 1, 0);
		// 201: V07*4-steps || value
		serializationSteps[201] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 4, 0);
		// 202: V07*5-steps || value
		serializationSteps[202] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 5, 0);
		// 203: V08*1-steps || value
		serializationSteps[203] = createSerializationStepSequence((8/*V8*/ << 4) | 1/*[?]*/, 1, 0);
		// 204: V08*1-steps || value
		serializationSteps[204] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 1, 0);
		// 205: V08*1-steps || value
		serializationSteps[205] = createSerializationStepSequence((8/*V8*/ << 4) | 3/*[+]*/, 1, 0);
		// 206: V08*5-steps || value
		serializationSteps[206] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 5, 0);
		// 207: V09*1-steps || value
		serializationSteps[207] = createSerializationStepSequence((9/*V9*/ << 4) | 1/*[?]*/, 1, 0);
		// 208: V09*5-steps || value
		serializationSteps[208] = createSerializationStepSequence((9/*V9*/ << 4) | 2/*[*]*/, 5, 0);
		// 209: wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[209] = createSerializationStepWrapper(2);
		// 210: NamedElementCS::name=UnaryOperatorName || soft-space value soft-space
		serializationSteps[210] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 112 /*UnaryOperatorName*/, 6);
		// 211: NamedElementCS::name=UnrestrictedName || soft-space value soft-space
		serializationSteps[211] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 116 /*UnrestrictedName*/, 6);
		// 212: NamedElementCS::name=BinaryOperatorName || soft-space value soft-space
		serializationSteps[212] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 2 /*BinaryOperatorName*/, 6);
		// 213: NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space
		serializationSteps[213] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 20 /*EnumerationLiteralName*/, 6);
		// 214: RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value
		serializationSteps[214] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 51 /*NavigatingArgCS*/, 0);
		// 215: RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value
		serializationSteps[215] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, -1, new int[] { 54/*NavigatingCommaArgCS*/,55/*NavigatingSemiArgCS*/,53/*NavigatingBarArgCS*/}, 0);
		// 216: PathNameCS::ownedPathElements+=URIFirstPathElementCS || value
		serializationSteps[216] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 110 /*URIFirstPathElementCS*/, 0);
		// 217: PathNameCS::ownedPathElements+=FirstPathElementCS || value
		serializationSteps[217] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 28 /*FirstPathElementCS*/, 0);
		// 218: PathNameCS::ownedPathElements+=NextPathElementCS || value
		serializationSteps[218] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 58 /*NextPathElementCS*/, 0);
		// 219: OperatorExpCS::ownedRight=ExpCS || value
		serializationSteps[219] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 27 /*ExpCS*/, 0);
		// 220: OperatorExpCS::ownedRight=PrefixedLetExpCS || value
		serializationSteps[220] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 65 /*PrefixedLetExpCS*/, 0);
		// 221: OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value
		serializationSteps[221] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 66 /*PrefixedPrimaryExpCS*/, 0);
		// 222: TypedElementCS::ownedType=TypedMultiplicityRefCS || value
		serializationSteps[222] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 104 /*TypedMultiplicityRefCS*/, 0);
		// 223: TypedElementCS::ownedType=TypeExpCS || value
		serializationSteps[223] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 96 /*TypeExpCS*/, 0);
		// 224: TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[224] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */, 6);
		// 225: TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[225] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */, 6);
		// 226: TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space
		serializationSteps[226] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */, 6);
		// 227: TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space
		serializationSteps[227] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */, 6);
		// 228: TypedElementCS::qualifiers+='definition' || soft-space value soft-space
		serializationSteps[228] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 11 /* 'definition' */, 6);
		// 229: TypedElementCS::qualifiers+='static' || soft-space value soft-space
		serializationSteps[229] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 18 /* 'static' */, 6);
		// 230: PathElementCS::referredElement=URI || soft-space value soft-space
		serializationSteps[230] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "URI"), 109, 6);
		// 231: PathElementCS::referredElement=UnreservedName || soft-space value soft-space
		serializationSteps[231] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnreservedName"), 114, 6);
		// 232: PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space
		serializationSteps[232] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnrestrictedName"), 116, 6);
	}

	/**
	 * Initialize the various serialization steps used to serialize a serialization rule.
	 */
	private void initSubstringSteps() {
		// 0: '->' : [no-space, value, no-space]
		substringSteps[0] = createSubstringStep("->", 3 /* no-space, value, no-space */);
		// 1: '.' : [no-space, value, no-space]
		substringSteps[1] = createSubstringStep(".", 3 /* no-space, value, no-space */);
		// 2: '?->' : [no-space, value, no-space]
		substringSteps[2] = createSubstringStep("?->", 3 /* no-space, value, no-space */);
		// 3: '?.' : [no-space, value, no-space]
		substringSteps[3] = createSubstringStep("?.", 3 /* no-space, value, no-space */);
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
//	import Grammar;
//	import GrammarProvider;
