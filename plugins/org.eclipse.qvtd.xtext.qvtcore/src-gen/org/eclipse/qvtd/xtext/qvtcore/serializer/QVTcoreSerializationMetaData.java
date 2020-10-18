/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtcore.serializer;

import com.google.inject.Inject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.AbstractSerializationMetaData;
import org.eclipse.ocl.examples.xtext.serializer.DataTypeRuleValue;
import org.eclipse.ocl.examples.xtext.serializer.EClassValue;
import org.eclipse.ocl.examples.xtext.serializer.EClassValue.EReference_TargetGrammarRuleVector;
import org.eclipse.ocl.examples.xtext.serializer.EnumerationValue;
import org.eclipse.ocl.examples.xtext.serializer.EnumerationValue.EnumerationValueMultiple;
import org.eclipse.ocl.examples.xtext.serializer.EnumerationValue.EnumerationValueSingle;
import org.eclipse.ocl.examples.xtext.serializer.GrammarCardinality;
import org.eclipse.ocl.examples.xtext.serializer.GrammarRuleValue;
import org.eclipse.ocl.examples.xtext.serializer.GrammarRuleVector;
import org.eclipse.ocl.examples.xtext.serializer.SerializationMatchStep;
import org.eclipse.ocl.examples.xtext.serializer.SerializationMatchTerm;
import org.eclipse.ocl.examples.xtext.serializer.SerializationMetaData;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule;
import org.eclipse.ocl.examples.xtext.serializer.SerializationRule.SerializationFeature;
import org.eclipse.ocl.examples.xtext.serializer.SerializationSegment;
import org.eclipse.ocl.examples.xtext.serializer.SerializationSegment.CustomSerializationSegment;
import org.eclipse.ocl.examples.xtext.serializer.SerializationStep;
import org.eclipse.ocl.examples.xtext.serializer.TerminalRuleValue;
import org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.service.GrammarProvider;

/******* This file is 100% auto-generated - do not edit it *******/

/**
 * The QVTcoreSerializationMetaData singleton provides the metadata to support a
 * model to text serialization of a parsed Xtext semantic model or to re-format an Xtext text node model.
 */
public class QVTcoreSerializationMetaData extends AbstractSerializationMetaData
{
	/**
	 * The Provider supports injected creation of the QVTcoreSerializationMetaData singleton.
	 */
	public static class Provider implements SerializationMetaData.Provider
	{
		private static @Nullable QVTcoreSerializationMetaData INSTANCE = null;

		@Inject
		private GrammarProvider grammarProvider;

		@Override
		public synchronized @NonNull SerializationMetaData get() {
			// synchronized synchronizes the creation of this singleton.
			// It does not imply that the overall application is threadsafe.
			QVTcoreSerializationMetaData instance = INSTANCE;
			if (instance == null) {
				assert grammarProvider != null;
				Grammar grammar = grammarProvider.getGrammar(Provider.class);
				assert grammar != null;
				INSTANCE = instance = new QVTcoreSerializationMetaData(grammar);
			}
			return instance;
		}
	}

	private final @NonNull EClassValue @NonNull [] eClassValues = new @NonNull EClassValue[76];
	private final @NonNull EnumerationValue @NonNull [] enumerationValues = new @NonNull EnumerationValue[28];
	private final @NonNull GrammarRuleValue @NonNull [] grammarRuleValues = new @NonNull GrammarRuleValue[137];
	private final @NonNull GrammarRuleVector @NonNull [] grammarRuleVectors = new @NonNull GrammarRuleVector[80];
	private final @NonNull SerializationMatchStep @NonNull [] serializationMatchSteps = new @NonNull SerializationMatchStep[394];
	private final @NonNull SerializationMatchTerm @NonNull [] serializationMatchTerms = new @NonNull SerializationMatchTerm[293];
	private final @NonNull SerializationRule @NonNull [] serializationRules = new @NonNull SerializationRule[168];
	private final @NonNull SerializationSegment @NonNull [] @NonNull [] serializationSegments = new @NonNull SerializationSegment @NonNull [10] @NonNull [];
	private final @NonNull SerializationStep @NonNull [] serializationSteps = new @NonNull SerializationStep[299];
	private final @Nullable String @Nullable [] multipleLineCommentMidfixes = new @Nullable String[] {" *"};
	private final @NonNull String @Nullable [] multipleLineCommentPrefixes = new @NonNull String[] {"/*"};
	private final @NonNull String @Nullable [] multipleLineCommentSuffixes = new @NonNull String[] {"*/"};
	private final @NonNull String @Nullable [] singleLineCommentPrefixes = new @NonNull String[] {"--"};

	private QVTcoreSerializationMetaData(@NonNull Grammar grammar) {
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
		return 146;
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
		return 145;
	}

	@Override
	protected int getLastGlobalSerializationStepLiteralIndex() {
		return 206;
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

	/**
	 * Initialize configuration for each EClass that may be serialized.
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
					42) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					64) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[1] = new EClassValue(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS,
			createSerializationRules(
				17 /* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			), null
		);
		eClassValues[2] = new EClassValue(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS,
			createSerializationRules(
				134 /* BottomPatternCS-0: '{' '}' */,
				135 /* BottomPatternCS-1: '{' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V0:+] '}' */,
				140 /* BottomPatternCS-6: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				141 /* BottomPatternCS-7: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */,
				142 /* BottomPatternCS-8: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				143 /* BottomPatternCS-9: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */,
				136 /* BottomPatternCS-2: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				137 /* BottomPatternCS-3: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				138 /* BottomPatternCS-4: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				139 /* BottomPatternCS-5: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS,
					30) /* PredicateOrAssignmentCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES,
					36) /* RealizedVariableCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES,
					78) /* UnrealizedVariableCS */
			}
		);
		eClassValues[3] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS,
			createSerializationRules(
				19 /* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS,
					2) /* CollectionLiteralPartCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE,
					3) /* CollectionTypeCS */
			}
		);
		eClassValues[4] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS,
			createSerializationRules(
				21 /* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */,
				20 /* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION,
					76) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[5] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS,
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
					3) /* CollectionTypeCS */
			}
		);
		eClassValues[6] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS,
			createSerializationRules(
				23 /* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				67 /* TypeExpCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				74 /* TypeLiteralWithMultiplicityCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				131 /* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE,
					61) /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */
			}
		);
		eClassValues[7] = new EClassValue(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS,
			createSerializationRules(
				88 /* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS,
					40) /* SimpleTargetElementCS */
			}
		);
		eClassValues[8] = new EClassValue(EssentialOCLCSPackage.Literals.CONTEXT_CS,
			createSerializationRules(
				35 /* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[9] = new EClassValue(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				24 /* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS,
					39) /* ShadowPartCS */
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
					51) /* TemplateSignatureCS */
			}
		);
		eClassValues[11] = new EClassValue(QVTcoreCSPackage.Literals.DIRECTION_CS,
			createSerializationRules(
				144 /* DirectionCS-0: (NamedElementCS::name=Identifier)[V0:?] 'imports' DirectionCS::imports+=UnrestrictedName (',' DirectionCS::imports+=UnrestrictedName)[V1:*] ('uses' DirectionCS::uses+=UnrestrictedName (',' DirectionCS::uses+=UnrestrictedName)[V3:*])[V2:?] */
			), null
		);
		eClassValues[12] = new EClassValue(QVTcoreCSPackage.Literals.DOMAIN_CS,
			createSerializationRules(
				152 /* NamedDomainCS-0: (DomainCS::isCheck?='check')[V0:?] (DomainCS::isEnforce?='enforce')[V1:?] DomainCS::direction=UnrestrictedName AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */,
				166 /* UnnamedDomainCS-0: AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN,
					0) /* BottomPatternCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.AREA_CS__OWNED_GUARD_PATTERN,
					10) /* GuardPatternCS */
			}
		);
		eClassValues[13] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_CS,
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
					7) /* EnumerationLiteralCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					51) /* TemplateSignatureCS */
			}
		);
		eClassValues[14] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS,
			createSerializationRules(
				103 /* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				101 /* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				104 /* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				102 /* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			), null
		);
		eClassValues[15] = new EClassValue(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS,
			createSerializationRules(
				124 /* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				125 /* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[16] = new EClassValue(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS,
			createSerializationRules(
				145 /* GuardPatternCS-0: '(' ')' */,
				146 /* GuardPatternCS-1: '(' (GuardPatternCS::ownedPredicates+=PredicateCS)[V0:+] ')' */,
				147 /* GuardPatternCS-2: '(' PatternCS::ownedUnrealizedVariables+=GuardVariableCS (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] ')' */,
				148 /* GuardPatternCS-3: '(' PatternCS::ownedUnrealizedVariables+=GuardVariableCS (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] '|' (GuardPatternCS::ownedPredicates+=PredicateCS)[V1:*] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES,
					29) /* PredicateCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES,
					11) /* GuardVariableCS */
			}
		);
		eClassValues[17] = new EClassValue(EssentialOCLCSPackage.Literals.IF_EXP_CS,
			createSerializationRules(
				27 /* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION,
					76) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS,
					6) /* ElseIfThenExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[18] = new EClassValue(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS,
			createSerializationRules(
				25 /* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[19] = new EClassValue(BaseCSPackage.Literals.IMPORT_CS,
			createSerializationRules(
				150 /* ImportCS-0: 'import' (NamedElementCS::name=Identifier ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS (ImportCS::isAll?='::' '*')[V1:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME,
					69) /* URIPathNameCS */
			}
		);
		eClassValues[20] = new EClassValue(EssentialOCLCSPackage.Literals.INFIX_EXP_CS,
			createSerializationRules(
				26 /* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT,
					72) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[21] = new EClassValue(EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS,
			createSerializationRules(
				28 /* InvalidLiteralExpCS-0: 'invalid' */
			), null
		);
		eClassValues[22] = new EClassValue(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS,
			createSerializationRules(
				29 /* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[23] = new EClassValue(EssentialOCLCSPackage.Literals.LET_EXP_CS,
			createSerializationRules(
				30 /* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES,
					13) /* LetVariableCS */
			}
		);
		eClassValues[24] = new EClassValue(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS,
			createSerializationRules(
				31 /* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					37) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[25] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS,
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
		eClassValues[26] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS,
			createSerializationRules(
				33 /* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS '<-' MapLiteralPartCS::ownedValue=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[27] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_TYPE_CS,
			createSerializationRules(
				34 /* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				68 /* TypeExpCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				75 /* TypeLiteralWithMultiplicityCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				132 /* TypedMultiplicityRefCS-3: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE,
					57) /* TypeExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[28] = new EClassValue(QVTcoreCSPackage.Literals.MAPPING_CS,
			createSerializationRules(
				151 /* MappingCS-0: (MappingCS::isAbstract?='abstract')[V0:?] 'map' (NamedElementCS::name=UnrestrictedName)[V1:?] ('in' MappingCS::ownedInPathName=PathNameCS)[V2:?] ('refines' MappingCS::refines+=UnrestrictedName (',' MappingCS::refines+=UnrestrictedName)[V4:*])[V3:?] '{' (MappingCS::ownedDomains+=NamedDomainCS)[V5:*] ('where' MappingCS::ownedMiddle=UnnamedDomainCS)[V6:?] (MappingCS::ownedComposedMappings+=MappingCS)[V7:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_COMPOSED_MAPPINGS,
					16) /* MappingCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_DOMAINS,
					18) /* NamedDomainCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME,
					26) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE,
					77) /* UnnamedDomainCS */
			}
		);
		eClassValues[29] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS,
			createSerializationRules(
				1 /* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */,
				4 /* MultiplicityCS-2: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] ']' */,
				2 /* MultiplicityCS-0: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] '|?' ']' */,
				3 /* MultiplicityCS-1: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] MultiplicityCS::isNullFree?='|1' ']' */
			), null
		);
		eClassValues[30] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS,
			createSerializationRules(
				7 /* MultiplicityCS-5: '[' MultiplicityStringCS::stringBounds='*|+|?' ']' */,
				5 /* MultiplicityCS-3: '[' MultiplicityStringCS::stringBounds='*|+|?' '|?' ']' */,
				6 /* MultiplicityCS-4: '[' MultiplicityStringCS::stringBounds='*|+|?' MultiplicityCS::isNullFree?='|1' ']' */,
				8 /* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			), null
		);
		eClassValues[31] = new EClassValue(EssentialOCLCSPackage.Literals.NAME_EXP_CS,
			createSerializationRules(
				36 /* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					4) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME,
					26) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					37) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES,
					43) /* SquareBracketedClauseCS */
			}
		);
		eClassValues[32] = new EClassValue(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS,
			createSerializationRules(
				41 /* NavigatingArgCS-4: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */,
				37 /* NavigatingArgCS-0: ':' NavigatingArgCS::ownedType=TypeExpCS */,
				39 /* NavigatingArgCS-2: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS '<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				38 /* NavigatingArgCS-1: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				40 /* NavigatingArgCS-3: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				42 /* NavigatingBarArgCS-0: NavigatingArgCS::prefix='|' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */,
				46 /* NavigatingCommaArgCS-3: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */,
				44 /* NavigatingCommaArgCS-1: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS '<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				43 /* NavigatingCommaArgCS-0: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				45 /* NavigatingCommaArgCS-2: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				47 /* NavigatingSemiArgCS-0: NavigatingArgCS::prefix=';' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR,
					1) /* CoIteratorVariableCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[33] = new EClassValue(EssentialOCLCSPackage.Literals.NESTED_EXP_CS,
			createSerializationRules(
				48 /* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[34] = new EClassValue(EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS,
			createSerializationRules(
				49 /* NullLiteralExpCS-0: 'null' */
			), null
		);
		eClassValues[35] = new EClassValue(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS,
			createSerializationRules(
				50 /* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			), null
		);
		eClassValues[36] = new EClassValue(BaseCSPackage.Literals.OPERATION_CS,
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
					42) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS,
					66) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS,
					25) /* ParameterCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					51) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					64) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[37] = new EClassValue(QVTcoreCSPackage.Literals.PARAM_DECLARATION_CS,
			createSerializationRules(
				153 /* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[38] = new EClassValue(BaseCSPackage.Literals.PARAMETER_CS,
			createSerializationRules(
				111 /* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					64) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[39] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_CS,
			createSerializationRules(
				0 /* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */,
				9 /* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */,
				79 /* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			), null
		);
		eClassValues[40] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS,
			createSerializationRules(
				78 /* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */
			), null
		);
		eClassValues[41] = new EClassValue(BaseCSPackage.Literals.PATH_NAME_CS,
			createSerializationRules(
				10 /* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				59 /* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */,
				80 /* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				163 /* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS,
					68) /* FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS */
			}
		);
		eClassValues[42] = new EClassValue(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS,
			createSerializationRules(
				51 /* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[43] = new EClassValue(QVTcoreCSPackage.Literals.PREDICATE_CS,
			createSerializationRules(
				154 /* PredicateCS-0: PredicateCS::ownedCondition=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[44] = new EClassValue(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS,
			createSerializationRules(
				155 /* PredicateOrAssignmentCS-0: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (':=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */,
				156 /* PredicateOrAssignmentCS-1: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (PredicateOrAssignmentCS::isPartial?='+=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[45] = new EClassValue(EssentialOCLCSPackage.Literals.PREFIX_EXP_CS,
			createSerializationRules(
				52 /* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				53 /* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					73) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[46] = new EClassValue(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS,
			createSerializationRules(
				54 /* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				66 /* TypeExpCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				73 /* TypeLiteralWithMultiplicityCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				129 /* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */
			}
		);
		eClassValues[47] = new EClassValue(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS,
			createSerializationRules(
				157 /* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				158 /* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES,
					54) /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					34) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME,
					38) /* ScopeNameCS */
			}
		);
		eClassValues[48] = new EClassValue(QVTcoreCSPackage.Literals.QUERY_CS,
			createSerializationRules(
				159 /* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				160 /* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				161 /* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS,
					24) /* ParamDeclarationCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME,
					38) /* ScopeNameCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[49] = new EClassValue(QVTcoreCSPackage.Literals.REALIZED_VARIABLE_CS,
			createSerializationRules(
				162 /* RealizedVariableCS-0: 'realize' NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[50] = new EClassValue(BaseCSPackage.Literals.REFERENCE_CS,
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
					42) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					64) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[51] = new EClassValue(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				55 /* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS,
					21) /* NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS */
			}
		);
		eClassValues[52] = new EClassValue(EssentialOCLCSPackage.Literals.SELF_EXP_CS,
			createSerializationRules(
				56 /* SelfExpCS-0: 'self' */
			), null
		);
		eClassValues[53] = new EClassValue(EssentialOCLCSPackage.Literals.SHADOW_PART_CS,
			createSerializationRules(
				58 /* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */,
				57 /* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION,
					76) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[54] = new EClassValue(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS,
			createSerializationRules(
				118 /* SimpleTargetElementCS-0: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				120 /* SimpleTargetElementCS-2: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				122 /* SimpleTargetElementCS-4: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				119 /* SimpleTargetElementCS-1: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				121 /* SimpleTargetElementCS-3: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				123 /* SimpleTargetElementCS-5: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */
			), null
		);
		eClassValues[55] = new EClassValue(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				60 /* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[56] = new EClassValue(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS,
			createSerializationRules(
				61 /* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			), null
		);
		eClassValues[57] = new EClassValue(BaseCSPackage.Literals.STRUCTURED_CLASS_CS,
			createSerializationRules(
				126 /* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				127 /* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS,
					23) /* OperationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES,
					46) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					51) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES,
					66) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[58] = new EClassValue(QVTbaseCSPackage.Literals.TARGET_CS,
			createSerializationRules(
				128 /* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS,
					41) /* CompoundTargetElementCS|SimpleTargetElementCS */
			}
		);
		eClassValues[59] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_BINDING_CS,
			createSerializationRules(
				11 /* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS,
					50) /* TemplateParameterSubstitutionCS */
			}
		);
		eClassValues[60] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS,
			createSerializationRules(
				12 /* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER,
					79) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */
			}
		);
		eClassValues[61] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS,
			createSerializationRules(
				13 /* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS,
					62) /* TypeParameterCS */
			}
		);
		eClassValues[62] = new EClassValue(QVTcoreCSPackage.Literals.TOP_LEVEL_CS,
			createSerializationRules(
				164 /* TopLevelCS-0: (RootCS::ownedImports+=ImportCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] (TopLevelCS::ownedMappings+=MappingCS)[V3:*] (TopLevelCS::ownedQueries+=QueryCS)[V4:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS,
					12) /* ImportCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS,
					16) /* MappingCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					34) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES,
					35) /* QueryCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS,
					52) /* TransformationCS */
			}
		);
		eClassValues[63] = new EClassValue(QVTcoreCSPackage.Literals.TRANSFORMATION_CS,
			createSerializationRules(
				165 /* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnreservedName '{' (TransformationCS::ownedDirections+=DirectionCS ';')[V1:*] (AbstractTransformationCS::ownedTargets+=TargetCS)[V2:*] (TransformationCS::ownedProperties+=StructuralFeatureCS)[V3:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS,
					5) /* DirectionCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME,
					38) /* ScopeNameCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES,
					46) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS,
					48) /* TargetCS */
			}
		);
		eClassValues[64] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS,
			createSerializationRules(
				62 /* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS,
					55) /* TupleLiteralPartCS */
			}
		);
		eClassValues[65] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS,
			createSerializationRules(
				63 /* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[66] = new EClassValue(BaseCSPackage.Literals.TUPLE_PART_CS,
			createSerializationRules(
				64 /* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[67] = new EClassValue(BaseCSPackage.Literals.TUPLE_TYPE_CS,
			createSerializationRules(
				65 /* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				71 /* TypeExpCS-5: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				76 /* TypeLiteralWithMultiplicityCS-3: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				133 /* TypedMultiplicityRefCS-4: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS,
					56) /* TuplePartCS */
			}
		);
		eClassValues[68] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS,
			createSerializationRules(
				72 /* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE,
					60) /* TypeLiteralWithMultiplicityCS */
			}
		);
		eClassValues[69] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS,
			createSerializationRules(
				69 /* TypeExpCS-3: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				77 /* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					4) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME,
					26) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[70] = new EClassValue(BaseCSPackage.Literals.TYPE_PARAMETER_CS,
			createSerializationRules(
				14 /* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS,
					66) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[71] = new EClassValue(BaseCSPackage.Literals.TYPED_TYPE_REF_CS,
			createSerializationRules(
				15 /* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */,
				130 /* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING,
					49) /* TemplateBindingCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME,
					26) /* PathNameCS */
			}
		);
		eClassValues[72] = new EClassValue(EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS,
			createSerializationRules(
				81 /* UnlimitedNaturalLiteralExpCS-0: '*' */
			), null
		);
		eClassValues[73] = new EClassValue(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS,
			createSerializationRules(
				149 /* GuardVariableCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */,
				167 /* UnrealizedVariableCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V0:?] (':=' UnrealizedVariableCS::ownedInitExpression=ExpCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[74] = new EClassValue(EssentialOCLCSPackage.Literals.VARIABLE_CS,
			createSerializationRules(
				18 /* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					57) /* TypeExpCS */
			}
		);
		eClassValues[75] = new EClassValue(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS,
			createSerializationRules(
				16 /* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS,
					66) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
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
		// 5: '+='
		enumerationValues[5] = new EnumerationValueSingle("+=");
		// 6: ','
		enumerationValues[6] = new EnumerationValueSingle(",");
		// 7: '::'
		enumerationValues[7] = new EnumerationValueSingle("::");
		// 8: ';'
		enumerationValues[8] = new EnumerationValueSingle(";");
		// 9: '@'
		enumerationValues[9] = new EnumerationValueSingle("@");
		// 10: 'Map'
		enumerationValues[10] = new EnumerationValueSingle("Map");
		// 11: 'Tuple'
		enumerationValues[11] = new EnumerationValueSingle("Tuple");
		// 12: 'abstract'
		enumerationValues[12] = new EnumerationValueSingle("abstract");
		// 13: 'check'
		enumerationValues[13] = new EnumerationValueSingle("check");
		// 14: 'default'
		enumerationValues[14] = new EnumerationValueSingle("default");
		// 15: 'definition'
		enumerationValues[15] = new EnumerationValueSingle("definition");
		// 16: 'enforce'
		enumerationValues[16] = new EnumerationValueSingle("enforce");
		// 17: 'false|true'
		enumerationValues[17] = new EnumerationValueMultiple(new @NonNull String[]{"false", "true"});
		// 18: 'input'
		enumerationValues[18] = new EnumerationValueSingle("input");
		// 19: 'interface'
		enumerationValues[19] = new EnumerationValueSingle("interface");
		// 20: 'output'
		enumerationValues[20] = new EnumerationValueSingle("output");
		// 21: 'primitive'
		enumerationValues[21] = new EnumerationValueSingle("primitive");
		// 22: 'serializable'
		enumerationValues[22] = new EnumerationValueSingle("serializable");
		// 23: 'static'
		enumerationValues[23] = new EnumerationValueSingle("static");
		// 24: 'transient'
		enumerationValues[24] = new EnumerationValueSingle("transient");
		// 25: 'via'
		enumerationValues[25] = new EnumerationValueSingle("via");
		// 26: '|'
		enumerationValues[26] = new EnumerationValueSingle("|");
		// 27: '|1'
		enumerationValues[27] = new EnumerationValueSingle("|1");
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
			(0 << 16) | 7	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "attribute" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[2] = new DataTypeRuleValue(2, "BinaryOperatorName");
		grammarRuleValues[3] = createParserRuleValue(3, "BooleanLiteralExpCS", -1,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* symbol="true" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* symbol="false" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[4] = createParserRuleValue(4, "BottomPatternCS", -1,
			createSerializationRules(
				134	/* BottomPatternCS-0: '{' '}' */,
				135	/* BottomPatternCS-1: '{' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V0:+] '}' */,
				136	/* BottomPatternCS-2: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				137	/* BottomPatternCS-3: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				138	/* BottomPatternCS-4: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				139	/* BottomPatternCS-5: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				140	/* BottomPatternCS-6: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				141	/* BottomPatternCS-7: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */,
				142	/* BottomPatternCS-8: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				143	/* BottomPatternCS-9: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [value] */,
			(0 << 16) | 7	/* "|" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedConstraints+=PredicateOrAssignmentCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedConstraints+=PredicateOrAssignmentCS+ : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {BottomPatternCS} : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[5] = createParserRuleValue(5, "ClassCS", 47 /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS */,
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
		grammarRuleValues[6] = createParserRuleValue(6, "CoIteratorVariableCS", -1,
			createSerializationRules(
				18	/* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[7] = createParserRuleValue(7, "CollectionLiteralExpCS", -1,
			createSerializationRules(
				19	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[8] = createParserRuleValue(8, "CollectionLiteralPartCS", -1,
			createSerializationRules(
				20	/* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */,
				21	/* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedLastExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=PatternExpCS : [value] | [value] */
		);
		grammarRuleValues[9] = createParserRuleValue(9, "CollectionPatternCS", -1,
			createSerializationRules(
				22	/* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "++" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* restVariableName=Identifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[10] = createParserRuleValue(10, "CollectionTypeCS", -1,
			createSerializationRules(
				23	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* name=CollectionTypeIdentifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpWithoutMultiplicityCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedCollectionMultiplicity=MultiplicityCS? : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[11] = new DataTypeRuleValue(11, "CollectionTypeIdentifier");
		grammarRuleValues[12] = createParserRuleValue(12, "CompoundTargetElementCS", -1,
			createSerializationRules(
				88	/* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=SimpleTargetElementCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[13] = createParserRuleValue(13, "CurlyBracketedClauseCS", -1,
			createSerializationRules(
				24	/* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {CurlyBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
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
			(0 << 16) | 7	/* isPrimitive?="primitive"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "datatype" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 7	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[16] = createParserRuleValue(16, "DirectionCS", -1,
			createSerializationRules(
				144	/* DirectionCS-0: (NamedElementCS::name=Identifier)[V0:?] 'imports' DirectionCS::imports+=UnrestrictedName (',' DirectionCS::imports+=UnrestrictedName)[V1:*] ('uses' DirectionCS::uses+=UnrestrictedName (',' DirectionCS::uses+=UnrestrictedName)[V3:*])[V2:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {DirectionCS} : [value] | [value] */,
			(0 << 16) | 7	/* name=Identifier? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "imports" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* imports+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* imports+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "uses" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* uses+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* uses+=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[17] = new TerminalRuleValue(17, "ESCAPED_CHARACTER");
		grammarRuleValues[18] = new TerminalRuleValue(18, "ESCAPED_ID");
		grammarRuleValues[19] = createParserRuleValue(19, "ElseIfThenExpCS", -1,
			createSerializationRules(
				25	/* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "elseif" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "then" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[20] = createParserRuleValue(20, "EnumerationCS", -1,
			createSerializationRules(
				95	/* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				96	/* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				97	/* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				98	/* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				99	/* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				100	/* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "enum" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 7	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedLiterals+=EnumerationLiteralCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[21] = createParserRuleValue(21, "EnumerationLiteralCS", -1,
			createSerializationRules(
				101	/* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				102	/* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				103	/* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				104	/* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "literal" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=EnumerationLiteralName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* value=SIGNED : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[22] = new DataTypeRuleValue(22, "EnumerationLiteralName");
		grammarRuleValues[23] = new DataTypeRuleValue(23, "EssentialOCLInfixOperatorName");
		grammarRuleValues[24] = new DataTypeRuleValue(24, "EssentialOCLNavigationOperatorName");
		grammarRuleValues[25] = new DataTypeRuleValue(25, "EssentialOCLReservedKeyword");
		grammarRuleValues[26] = new DataTypeRuleValue(26, "EssentialOCLUnaryOperatorName");
		grammarRuleValues[27] = new DataTypeRuleValue(27, "EssentialOCLUnreservedName");
		grammarRuleValues[28] = new DataTypeRuleValue(28, "EssentialOCLUnrestrictedName");
		grammarRuleValues[29] = createParserRuleValue(29, "ExpCS", 74 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
			(0 << 16) | 7	/* name=BinaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrefixedLetExpCS : [value] | [value] */
		);
		grammarRuleValues[30] = createParserRuleValue(30, "FirstPathElementCS", -1,
			createSerializationRules(
				0	/* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 7	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[31] = createParserRuleValue(31, "GuardPatternCS", -1,
			createSerializationRules(
				145	/* GuardPatternCS-0: '(' ')' */,
				146	/* GuardPatternCS-1: '(' (GuardPatternCS::ownedPredicates+=PredicateCS)[V0:+] ')' */,
				147	/* GuardPatternCS-2: '(' PatternCS::ownedUnrealizedVariables+=GuardVariableCS (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] ')' */,
				148	/* GuardPatternCS-3: '(' PatternCS::ownedUnrealizedVariables+=GuardVariableCS (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] '|' (GuardPatternCS::ownedPredicates+=PredicateCS)[V1:*] ')' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=GuardVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=GuardVariableCS : [value] | [value] */,
			(0 << 16) | 7	/* "|" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPredicates+=PredicateCS* : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=GuardVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=GuardVariableCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPredicates+=PredicateCS+ : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {GuardPatternCS} : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[32] = createParserRuleValue(32, "GuardVariableCS", -1,
			createSerializationRules(
				149	/* GuardVariableCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[33] = new DataTypeRuleValue(33, "ID");
		grammarRuleValues[34] = new TerminalRuleValue(34, "INT");
		grammarRuleValues[35] = new DataTypeRuleValue(35, "Identifier");
		grammarRuleValues[36] = createParserRuleValue(36, "IfExpCS", -1,
			createSerializationRules(
				27	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "if" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 7	/* "then" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedIfThenExpressions+=ElseIfThenExpCS* : [value] | [value] */,
			(0 << 16) | 7	/* "else" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedElseExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "endif" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[37] = createParserRuleValue(37, "ImportCS", -1,
			createSerializationRules(
				150	/* ImportCS-0: 'import' (NamedElementCS::name=Identifier ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS (ImportCS::isAll?='::' '*')[V1:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "import" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* name=Identifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=URIPathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* isAll?="::" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "*" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[38] = new DataTypeRuleValue(38, "InfixOperatorName");
		grammarRuleValues[39] = createParserRuleValue(39, "InvalidLiteralExpCS", -1,
			createSerializationRules(
				28	/* InvalidLiteralExpCS-0: 'invalid' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {InvalidLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "invalid" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[40] = new TerminalRuleValue(40, "LETTER_CHARACTER");
		grammarRuleValues[41] = new DataTypeRuleValue(41, "LOWER");
		grammarRuleValues[42] = createParserRuleValue(42, "LambdaLiteralExpCS", -1,
			createSerializationRules(
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "Lambda" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpressionCS=ExpCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[43] = createParserRuleValue(43, "LetExpCS", -1,
			createSerializationRules(
				30	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "let" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 7	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[44] = createParserRuleValue(44, "LetVariableCS", -1,
			createSerializationRules(
				31	/* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[45] = new TerminalRuleValue(45, "ML_COMMENT");
		grammarRuleValues[46] = new TerminalRuleValue(46, "ML_SINGLE_QUOTED_STRING");
		grammarRuleValues[47] = createParserRuleValue(47, "MapLiteralExpCS", -1,
			createSerializationRules(
				32	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=MapTypeCS : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[48] = createParserRuleValue(48, "MapLiteralPartCS", -1,
			createSerializationRules(
				33	/* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS '<-' MapLiteralPartCS::ownedValue=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedKey=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValue=ExpCS : [value] | [value] */
		);
		grammarRuleValues[49] = createParserRuleValue(49, "MapTypeCS", -1,
			createSerializationRules(
				34	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* name="Map" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedKeyType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValueType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[50] = createParserRuleValue(50, "MappingCS", -1,
			createSerializationRules(
				151	/* MappingCS-0: (MappingCS::isAbstract?='abstract')[V0:?] 'map' (NamedElementCS::name=UnrestrictedName)[V1:?] ('in' MappingCS::ownedInPathName=PathNameCS)[V2:?] ('refines' MappingCS::refines+=UnrestrictedName (',' MappingCS::refines+=UnrestrictedName)[V4:*])[V3:?] '{' (MappingCS::ownedDomains+=NamedDomainCS)[V5:*] ('where' MappingCS::ownedMiddle=UnnamedDomainCS)[V6:?] (MappingCS::ownedComposedMappings+=MappingCS)[V7:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {MappingCS} : [value] | [value] */,
			(0 << 16) | 7	/* isAbstract?="abstract"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "map" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "refines" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* refines+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* refines+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedDomains+=NamedDomainCS* : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "where" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedMiddle=UnnamedDomainCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedComposedMappings+=MappingCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[51] = createParserRuleValue(51, "Model", -1,
			createSerializationRules(
				35	/* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			(0 << 16) | 2	/* ownedExpression=ExpCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[52] = createParserRuleValue(52, "MultiplicityBoundsCS", -1,
			createSerializationRules(
				1	/* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* lowerBound=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 7	/* upperBound=UPPER : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[53] = createParserRuleValue(53, "MultiplicityCS", -1,
			createSerializationRules(
				2	/* MultiplicityCS-0: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] '|?' ']' */,
				3	/* MultiplicityCS-1: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] MultiplicityCS::isNullFree?='|1' ']' */,
				4	/* MultiplicityCS-2: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] ']' */,
				5	/* MultiplicityCS-3: '[' MultiplicityStringCS::stringBounds='*|+|?' '|?' ']' */,
				6	/* MultiplicityCS-4: '[' MultiplicityStringCS::stringBounds='*|+|?' MultiplicityCS::isNullFree?='|1' ']' */,
				7	/* MultiplicityCS-5: '[' MultiplicityStringCS::stringBounds='*|+|?' ']' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 4	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityBoundsCS : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityStringCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 4	/* "|?" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 7	/* isNullFree?="|1" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[54] = createParserRuleValue(54, "MultiplicityStringCS", -1,
			createSerializationRules(
				8	/* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			),
			(0 << 16) | 7	/* stringBounds=("*"|"+"|"?") : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[55] = new DataTypeRuleValue(55, "NUMBER_LITERAL");
		grammarRuleValues[56] = createParserRuleValue(56, "NameExpCS", -1,
			createSerializationRules(
				36	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedSquareBracketedClauses+=SquareBracketedClauseCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* isPre?="@" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "pre" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[57] = createParserRuleValue(57, "NamedDomainCS", -1,
			createSerializationRules(
				152	/* NamedDomainCS-0: (DomainCS::isCheck?='check')[V0:?] (DomainCS::isEnforce?='enforce')[V1:?] DomainCS::direction=UnrestrictedName AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isCheck?="check"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* isEnforce?="enforce"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* direction=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedGuardPattern=GuardPatternCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedBottomPattern=BottomPatternCS : [value] | [value] */
		);
		grammarRuleValues[58] = createParserRuleValue(58, "NavigatingArgCS", -1,
			createSerializationRules(
				37	/* NavigatingArgCS-0: ':' NavigatingArgCS::ownedType=TypeExpCS */,
				38	/* NavigatingArgCS-1: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				39	/* NavigatingArgCS-2: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS '<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				40	/* NavigatingArgCS-3: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				41	/* NavigatingArgCS-4: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 7	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[59] = createParserRuleValue(59, "NavigatingArgExpCS", 75 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[60] = createParserRuleValue(60, "NavigatingBarArgCS", -1,
			createSerializationRules(
				42	/* NavigatingBarArgCS-0: NavigatingArgCS::prefix='|' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* prefix="|" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[61] = createParserRuleValue(61, "NavigatingCommaArgCS", -1,
			createSerializationRules(
				43	/* NavigatingCommaArgCS-0: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				44	/* NavigatingCommaArgCS-1: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS '<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				45	/* NavigatingCommaArgCS-2: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('<-' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				46	/* NavigatingCommaArgCS-3: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* prefix="," : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 7	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[62] = createParserRuleValue(62, "NavigatingSemiArgCS", -1,
			createSerializationRules(
				47	/* NavigatingSemiArgCS-0: NavigatingArgCS::prefix=';' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* prefix=";" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[63] = new DataTypeRuleValue(63, "NavigationOperatorName");
		grammarRuleValues[64] = createParserRuleValue(64, "NestedExpCS", -1,
			createSerializationRules(
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[65] = createParserRuleValue(65, "NextPathElementCS", -1,
			createSerializationRules(
				9	/* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */
			),
			(0 << 16) | 7	/* referredElement=UnreservedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[66] = createParserRuleValue(66, "NullLiteralExpCS", -1,
			createSerializationRules(
				49	/* NullLiteralExpCS-0: 'null' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {NullLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "null" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[67] = createParserRuleValue(67, "NumberLiteralExpCS", -1,
			createSerializationRules(
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			),
			(0 << 16) | 2	/* symbol=NUMBER_LITERAL : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[68] = createParserRuleValue(68, "OperationCS", -1,
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
			(0 << 16) | 7	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "operation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "throws" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 7	/* "body" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedBodyExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[69] = createParserRuleValue(69, "ParamDeclarationCS", -1,
			createSerializationRules(
				153	/* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[70] = createParserRuleValue(70, "ParameterCS", -1,
			createSerializationRules(
				111	/* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[71] = createParserRuleValue(71, "PathNameCS", -1,
			createSerializationRules(
				10	/* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[72] = createParserRuleValue(72, "PatternExpCS", -1,
			createSerializationRules(
				51	/* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* patternVariableName=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatternType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[73] = createParserRuleValue(73, "PredicateCS", -1,
			createSerializationRules(
				154	/* PredicateCS-0: PredicateCS::ownedCondition=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[74] = createParserRuleValue(74, "PredicateOrAssignmentCS", -1,
			createSerializationRules(
				155	/* PredicateOrAssignmentCS-0: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (':=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */,
				156	/* PredicateOrAssignmentCS-1: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (PredicateOrAssignmentCS::isPartial?='+=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isDefault?="default"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedTarget=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* isPartial?="+=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[75] = createParserRuleValue(75, "PrefixedLetExpCS", 32 /* LetExpCS|PrefixedLetExpCS */,
			createSerializationRules(
				30	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				52	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PrefixExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedLetExpCS : [value] | [value] */,
			(0 << 16) | 0	/* LetExpCS : [value] | [value] */
		);
		grammarRuleValues[76] = createParserRuleValue(76, "PrefixedPrimaryExpCS", 72 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
			(0 << 16) | 7	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedPrimaryExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrimaryExpCS : [value] | [value] */
		);
		grammarRuleValues[77] = createParserRuleValue(77, "PrimaryExpCS", 71 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[78] = createParserRuleValue(78, "PrimitiveLiteralExpCS", 70 /* BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[79] = createParserRuleValue(79, "PrimitiveTypeCS", -1,
			createSerializationRules(
				54	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */
			),
			(0 << 16) | 7	/* name=PrimitiveTypeIdentifier : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[80] = new DataTypeRuleValue(80, "PrimitiveTypeIdentifier");
		grammarRuleValues[81] = new DataTypeRuleValue(81, "QVTbaseUnrestrictedName");
		grammarRuleValues[82] = new DataTypeRuleValue(82, "QVTcoreUnrestrictedName");
		grammarRuleValues[83] = createParserRuleValue(83, "QualifiedPackageCS", -1,
			createSerializationRules(
				157	/* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				158	/* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "package" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS? : [value] | [value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* nsPrefix=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* nsURI=URI : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedPackages+=QualifiedPackageCS : [value] | [value] */,
			(0 << 16) | 3	/* ownedClasses+=(ClassCS|TransformationCS) : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[84] = createParserRuleValue(84, "QueryCS", -1,
			createSerializationRules(
				159	/* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				160	/* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				161	/* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isTransient?="transient"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "query" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS : [value] | [value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParameters+=ParamDeclarationCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=ParamDeclarationCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "implementedby" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* implementation=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[85] = createParserRuleValue(85, "RealizedVariableCS", -1,
			createSerializationRules(
				162	/* RealizedVariableCS-0: 'realize' NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "realize" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[86] = createParserRuleValue(86, "ReferenceCS", -1,
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
			(0 << 16) | 7	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "property" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* "#" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 7	/* referredOpposite=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* qualifiers+="composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 6	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[87] = createParserRuleValue(87, "RoundBracketedClauseCS", -1,
			createSerializationRules(
				55	/* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {RoundBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=NavigatingArgCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)* : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[88] = new DataTypeRuleValue(88, "SIGNED");
		grammarRuleValues[89] = new TerminalRuleValue(89, "SIMPLE_ID");
		grammarRuleValues[90] = new TerminalRuleValue(90, "SINGLE_QUOTED_STRING");
		grammarRuleValues[91] = new TerminalRuleValue(91, "SL_COMMENT");
		grammarRuleValues[92] = createParserRuleValue(92, "ScopeNameCS", -1,
			createSerializationRules(
				163	/* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */
		);
		grammarRuleValues[93] = createParserRuleValue(93, "SelfExpCS", -1,
			createSerializationRules(
				56	/* SelfExpCS-0: 'self' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {SelfExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "self" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[94] = createParserRuleValue(94, "ShadowPartCS", -1,
			createSerializationRules(
				57	/* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */,
				58	/* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* referredProperty=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 0	/* ownedInitExpression=StringLiteralExpCS : [value] | [value] */
		);
		grammarRuleValues[95] = createParserRuleValue(95, "SimplePathNameCS", -1,
			createSerializationRules(
				59	/* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */
			),
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */
		);
		grammarRuleValues[96] = createParserRuleValue(96, "SimpleTargetElementCS", -1,
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
			(0 << 16) | 7	/* input?="input" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* output?="output" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* via?="via" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* typedModel=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "iterates" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[97] = createParserRuleValue(97, "SpecificationCS", -1,
			createSerializationRules(
				124	/* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				125	/* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* exprString=UNQUOTED_STRING : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[98] = createParserRuleValue(98, "SquareBracketedClauseCS", -1,
			createSerializationRules(
				60	/* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 4	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[99] = new DataTypeRuleValue(99, "StringLiteral");
		grammarRuleValues[100] = createParserRuleValue(100, "StringLiteralExpCS", -1,
			createSerializationRules(
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			),
			(0 << 16) | 2	/* segments+=StringLiteral+ : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[101] = createParserRuleValue(101, "StructuralFeatureCS", 46 /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
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
		grammarRuleValues[102] = createParserRuleValue(102, "StructuredClassCS", -1,
			createSerializationRules(
				126	/* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				127	/* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isAbstract?="abstract"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "class" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 7	/* isInterface?="interface"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedOperations+=OperationCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedProperties+=StructuralFeatureCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[103] = createParserRuleValue(103, "TargetCS", -1,
			createSerializationRules(
				128	/* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "target" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[104] = createParserRuleValue(104, "TemplateBindingCS", -1,
			createSerializationRules(
				11	/* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedSubstitutions+=TemplateParameterSubstitutionCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSubstitutions+=TemplateParameterSubstitutionCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[105] = createParserRuleValue(105, "TemplateParameterSubstitutionCS", -1,
			createSerializationRules(
				12	/* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			(0 << 16) | 2	/* ownedActualParameter=TypeRefCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[106] = createParserRuleValue(106, "TemplateSignatureCS", -1,
			createSerializationRules(
				13	/* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[107] = createParserRuleValue(107, "TopLevelCS", -1,
			createSerializationRules(
				164	/* TopLevelCS-0: (RootCS::ownedImports+=ImportCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] (TopLevelCS::ownedMappings+=MappingCS)[V3:*] (TopLevelCS::ownedQueries+=QueryCS)[V4:*] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedImports+=ImportCS* : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedPackages+=QualifiedPackageCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedTransformations+=TransformationCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMappings+=MappingCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedQueries+=QueryCS : [value] | [value] */
		);
		grammarRuleValues[108] = createParserRuleValue(108, "TransformationCS", -1,
			createSerializationRules(
				165	/* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnreservedName '{' (TransformationCS::ownedDirections+=DirectionCS ';')[V1:*] (AbstractTransformationCS::ownedTargets+=TargetCS)[V2:*] (TransformationCS::ownedProperties+=StructuralFeatureCS)[V3:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "transformation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS? : [value] | [value] */,
			(0 << 16) | 7	/* name=UnreservedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 0	/* ownedDirections+=DirectionCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargets+=TargetCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedProperties+=StructuralFeatureCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[109] = createParserRuleValue(109, "TupleLiteralExpCS", -1,
			createSerializationRules(
				62	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[110] = createParserRuleValue(110, "TupleLiteralPartCS", -1,
			createSerializationRules(
				63	/* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[111] = createParserRuleValue(111, "TuplePartCS", -1,
			createSerializationRules(
				64	/* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[112] = createParserRuleValue(112, "TupleTypeCS", -1,
			createSerializationRules(
				65	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* name="Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[113] = createParserRuleValue(113, "TypeExpCS", -1,
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
		grammarRuleValues[114] = createParserRuleValue(114, "TypeExpWithoutMultiplicityCS", 61 /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
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
		grammarRuleValues[115] = createParserRuleValue(115, "TypeLiteralCS", 59 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS */,
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
		grammarRuleValues[116] = createParserRuleValue(116, "TypeLiteralExpCS", -1,
			createSerializationRules(
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			(0 << 16) | 2	/* ownedType=TypeLiteralWithMultiplicityCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[117] = createParserRuleValue(117, "TypeLiteralWithMultiplicityCS", -1,
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
		grammarRuleValues[118] = createParserRuleValue(118, "TypeNameExpCS", -1,
			createSerializationRules(
				77	/* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedPatternGuard=ExpCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[119] = createParserRuleValue(119, "TypeParameterCS", -1,
			createSerializationRules(
				14	/* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 7	/* "&&" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */
		);
		grammarRuleValues[120] = createParserRuleValue(120, "TypeRefCS", 79 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
			createSerializationRules(
				23	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				34	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				54	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				65	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				15	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */,
				16	/* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* WildcardTypeRefCS : [value] | [value] */
		);
		grammarRuleValues[121] = createParserRuleValue(121, "TypedMultiplicityRefCS", -1,
			createSerializationRules(
				129	/* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				130	/* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				131	/* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				132	/* TypedMultiplicityRefCS-3: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				133	/* TypedMultiplicityRefCS-4: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedMultiplicity=MultiplicityCS? : [value] | [value] */
		);
		grammarRuleValues[122] = createParserRuleValue(122, "TypedRefCS", 66 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
			createSerializationRules(
				23	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				34	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				54	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				65	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				15	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* TypeLiteralCS : [value] | [value] */,
			(0 << 16) | 0	/* TypedTypeRefCS : [value] | [value] */
		);
		grammarRuleValues[123] = createParserRuleValue(123, "TypedTypeRefCS", -1,
			createSerializationRules(
				15	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedBinding=TemplateBindingCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[124] = new TerminalRuleValue(124, "UNQUOTED_STRING");
		grammarRuleValues[125] = new DataTypeRuleValue(125, "UPPER");
		grammarRuleValues[126] = new DataTypeRuleValue(126, "URI");
		grammarRuleValues[127] = createParserRuleValue(127, "URIFirstPathElementCS", -1,
			createSerializationRules(
				78	/* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */,
				79	/* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PathElementWithURICS} : [value] | [value] */,
			(0 << 16) | 7	/* referredElement=URI : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[128] = createParserRuleValue(128, "URIPathNameCS", -1,
			createSerializationRules(
				80	/* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=URIFirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[129] = new DataTypeRuleValue(129, "UnaryOperatorName");
		grammarRuleValues[130] = createParserRuleValue(130, "UnlimitedNaturalLiteralExpCS", -1,
			createSerializationRules(
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {UnlimitedNaturalLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "*" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[131] = createParserRuleValue(131, "UnnamedDomainCS", -1,
			createSerializationRules(
				166	/* UnnamedDomainCS-0: AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {DomainCS} : [value] | [value] */,
			(0 << 16) | 0	/* ownedGuardPattern=GuardPatternCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedBottomPattern=BottomPatternCS : [value] | [value] */
		);
		grammarRuleValues[132] = createParserRuleValue(132, "UnrealizedVariableCS", -1,
			createSerializationRules(
				167	/* UnrealizedVariableCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V0:?] (':=' UnrealizedVariableCS::ownedInitExpression=ExpCS)[V1:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[133] = new DataTypeRuleValue(133, "UnreservedName");
		grammarRuleValues[134] = new DataTypeRuleValue(134, "UnrestrictedName");
		grammarRuleValues[135] = new TerminalRuleValue(135, "WS");
		grammarRuleValues[136] = createParserRuleValue(136, "WildcardTypeRefCS", -1,
			createSerializationRules(
				16	/* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {WildcardTypeRefCS} : [value] | [value] */,
			(0 << 16) | 7	/* "?" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends=TypedRefCS : [value] | [value] */
		);
	}

	/**
	 * Initialize bit vectors of useful grammar rule combinations.
	 */
	private void initGrammarRuleVectors() {
		// 0: BottomPatternCS
		grammarRuleVectors[0] = new GrammarRuleVector(0x10L);
		// 1: CoIteratorVariableCS
		grammarRuleVectors[1] = new GrammarRuleVector(0x40L);
		// 2: CollectionLiteralPartCS
		grammarRuleVectors[2] = new GrammarRuleVector(0x100L);
		// 3: CollectionTypeCS
		grammarRuleVectors[3] = new GrammarRuleVector(0x400L);
		// 4: CurlyBracketedClauseCS
		grammarRuleVectors[4] = new GrammarRuleVector(0x2000L);
		// 5: DirectionCS
		grammarRuleVectors[5] = new GrammarRuleVector(0x10000L);
		// 6: ElseIfThenExpCS
		grammarRuleVectors[6] = new GrammarRuleVector(0x80000L);
		// 7: EnumerationLiteralCS
		grammarRuleVectors[7] = new GrammarRuleVector(0x200000L);
		// 8: ExpCS
		grammarRuleVectors[8] = new GrammarRuleVector(0x20000000L);
		// 9: FirstPathElementCS
		grammarRuleVectors[9] = new GrammarRuleVector(0x40000000L);
		// 10: GuardPatternCS
		grammarRuleVectors[10] = new GrammarRuleVector(0x80000000L);
		// 11: GuardVariableCS
		grammarRuleVectors[11] = new GrammarRuleVector(0x100000000L);
		// 12: ImportCS
		grammarRuleVectors[12] = new GrammarRuleVector(0x2000000000L);
		// 13: LetVariableCS
		grammarRuleVectors[13] = new GrammarRuleVector(0x100000000000L);
		// 14: MapLiteralPartCS
		grammarRuleVectors[14] = new GrammarRuleVector(0x1000000000000L);
		// 15: MapTypeCS
		grammarRuleVectors[15] = new GrammarRuleVector(0x2000000000000L);
		// 16: MappingCS
		grammarRuleVectors[16] = new GrammarRuleVector(0x4000000000000L);
		// 17: MultiplicityCS
		grammarRuleVectors[17] = new GrammarRuleVector(0x20000000000000L);
		// 18: NamedDomainCS
		grammarRuleVectors[18] = new GrammarRuleVector(0x200000000000000L);
		// 19: NavigatingArgExpCS
		grammarRuleVectors[19] = new GrammarRuleVector(0x800000000000000L);
		// 20: NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[20] = new GrammarRuleVector(0x7000000000000000L);
		// 21: NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[21] = new GrammarRuleVector(0x7400000000000000L);
		// 22: FirstPathElementCS|NextPathElementCS
		grammarRuleVectors[22] = new GrammarRuleVector(0x40000000L,0x2L);
		// 23: OperationCS
		grammarRuleVectors[23] = new GrammarRuleVector(0x0L,0x10L);
		// 24: ParamDeclarationCS
		grammarRuleVectors[24] = new GrammarRuleVector(0x0L,0x20L);
		// 25: ParameterCS
		grammarRuleVectors[25] = new GrammarRuleVector(0x0L,0x40L);
		// 26: PathNameCS
		grammarRuleVectors[26] = new GrammarRuleVector(0x0L,0x80L);
		// 27: PatternExpCS
		grammarRuleVectors[27] = new GrammarRuleVector(0x0L,0x100L);
		// 28: ExpCS|PatternExpCS
		grammarRuleVectors[28] = new GrammarRuleVector(0x20000000L,0x100L);
		// 29: PredicateCS
		grammarRuleVectors[29] = new GrammarRuleVector(0x0L,0x200L);
		// 30: PredicateOrAssignmentCS
		grammarRuleVectors[30] = new GrammarRuleVector(0x0L,0x400L);
		// 31: PrefixedLetExpCS
		grammarRuleVectors[31] = new GrammarRuleVector(0x0L,0x800L);
		// 32: LetExpCS|PrefixedLetExpCS
		grammarRuleVectors[32] = new GrammarRuleVector(0x80000000000L,0x800L);
		// 33: PrefixedPrimaryExpCS
		grammarRuleVectors[33] = new GrammarRuleVector(0x0L,0x1000L);
		// 34: QualifiedPackageCS
		grammarRuleVectors[34] = new GrammarRuleVector(0x0L,0x80000L);
		// 35: QueryCS
		grammarRuleVectors[35] = new GrammarRuleVector(0x0L,0x100000L);
		// 36: RealizedVariableCS
		grammarRuleVectors[36] = new GrammarRuleVector(0x0L,0x200000L);
		// 37: RoundBracketedClauseCS
		grammarRuleVectors[37] = new GrammarRuleVector(0x0L,0x800000L);
		// 38: ScopeNameCS
		grammarRuleVectors[38] = new GrammarRuleVector(0x0L,0x10000000L);
		// 39: ShadowPartCS
		grammarRuleVectors[39] = new GrammarRuleVector(0x0L,0x40000000L);
		// 40: SimpleTargetElementCS
		grammarRuleVectors[40] = new GrammarRuleVector(0x0L,0x100000000L);
		// 41: CompoundTargetElementCS|SimpleTargetElementCS
		grammarRuleVectors[41] = new GrammarRuleVector(0x1000L,0x100000000L);
		// 42: SpecificationCS
		grammarRuleVectors[42] = new GrammarRuleVector(0x0L,0x200000000L);
		// 43: SquareBracketedClauseCS
		grammarRuleVectors[43] = new GrammarRuleVector(0x0L,0x400000000L);
		// 44: StringLiteralExpCS
		grammarRuleVectors[44] = new GrammarRuleVector(0x0L,0x1000000000L);
		// 45: StructuralFeatureCS
		grammarRuleVectors[45] = new GrammarRuleVector(0x0L,0x2000000000L);
		// 46: AttributeCS|ReferenceCS|StructuralFeatureCS
		grammarRuleVectors[46] = new GrammarRuleVector(0x2L,0x2000400000L);
		// 47: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS
		grammarRuleVectors[47] = new GrammarRuleVector(0x108020L,0x4000000000L);
		// 48: TargetCS
		grammarRuleVectors[48] = new GrammarRuleVector(0x0L,0x8000000000L);
		// 49: TemplateBindingCS
		grammarRuleVectors[49] = new GrammarRuleVector(0x0L,0x10000000000L);
		// 50: TemplateParameterSubstitutionCS
		grammarRuleVectors[50] = new GrammarRuleVector(0x0L,0x20000000000L);
		// 51: TemplateSignatureCS
		grammarRuleVectors[51] = new GrammarRuleVector(0x0L,0x40000000000L);
		// 52: TransformationCS
		grammarRuleVectors[52] = new GrammarRuleVector(0x0L,0x100000000000L);
		// 53: ClassCS|TransformationCS
		grammarRuleVectors[53] = new GrammarRuleVector(0x20L,0x100000000000L);
		// 54: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS
		grammarRuleVectors[54] = new GrammarRuleVector(0x108020L,0x104000000000L);
		// 55: TupleLiteralPartCS
		grammarRuleVectors[55] = new GrammarRuleVector(0x0L,0x400000000000L);
		// 56: TuplePartCS
		grammarRuleVectors[56] = new GrammarRuleVector(0x0L,0x800000000000L);
		// 57: TypeExpCS
		grammarRuleVectors[57] = new GrammarRuleVector(0x0L,0x2000000000000L);
		// 58: TypeExpWithoutMultiplicityCS
		grammarRuleVectors[58] = new GrammarRuleVector(0x0L,0x4000000000000L);
		// 59: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS
		grammarRuleVectors[59] = new GrammarRuleVector(0x2000000000400L,0x9000000008000L);
		// 60: TypeLiteralWithMultiplicityCS
		grammarRuleVectors[60] = new GrammarRuleVector(0x0L,0x20000000000000L);
		// 61: CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS
		grammarRuleVectors[61] = new GrammarRuleVector(0x2000000000600L,0x4d000000008000L);
		// 62: TypeParameterCS
		grammarRuleVectors[62] = new GrammarRuleVector(0x0L,0x80000000000000L);
		// 63: TypeRefCS
		grammarRuleVectors[63] = new GrammarRuleVector(0x0L,0x100000000000000L);
		// 64: TypedMultiplicityRefCS
		grammarRuleVectors[64] = new GrammarRuleVector(0x0L,0x200000000000000L);
		// 65: TypedRefCS
		grammarRuleVectors[65] = new GrammarRuleVector(0x0L,0x400000000000000L);
		// 66: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS
		grammarRuleVectors[66] = new GrammarRuleVector(0x2000000000400L,0xc09000000008000L);
		// 67: NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[67] = new GrammarRuleVector(0x0L,0x8000000000000002L);
		// 68: FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[68] = new GrammarRuleVector(0x40000000L,0x8000000000000002L);
		// 69: URIPathNameCS
		grammarRuleVectors[69] = new GrammarRuleVector(0x0L,0x0L,0x1L);
		// 70: BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[70] = new GrammarRuleVector(0x8000000008L,0x100000400cL,0x4L);
		// 71: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[71] = new GrammarRuleVector(0x100849000000088L,0x1020102000600dL,0x4L);
		// 72: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[72] = new GrammarRuleVector(0x100849000000088L,0x1020102000700dL,0x4L);
		// 73: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[73] = new GrammarRuleVector(0x1008c9000000088L,0x1020102000780dL,0x4L);
		// 74: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[74] = new GrammarRuleVector(0x1008c9020000088L,0x1020102000780dL,0x4L);
		// 75: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[75] = new GrammarRuleVector(0x9008c9020000088L,0x1020102000780dL,0x4L);
		// 76: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[76] = new GrammarRuleVector(0x1008c9020000088L,0x1020102000790dL,0x4L);
		// 77: UnnamedDomainCS
		grammarRuleVectors[77] = new GrammarRuleVector(0x0L,0x0L,0x8L);
		// 78: UnrealizedVariableCS
		grammarRuleVectors[78] = new GrammarRuleVector(0x0L,0x0L,0x10L);
		// 79: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS
		grammarRuleVectors[79] = new GrammarRuleVector(0x2000000000400L,0xd09000000008000L,0x100L);
	}

	/**
	 * Initialize steps for the matching process.
	 */
	private void initMatchSteps() {
		// 0: assert (|AbstractNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[0] = createMatchStep_Assert(188);
		// 1: assert (|AreaCS::ownedBottomPattern| - 1) == 0
		serializationMatchSteps[1] = createMatchStep_Assert(189);
		// 2: assert (|AreaCS::ownedGuardPattern| - 1) == 0
		serializationMatchSteps[2] = createMatchStep_Assert(190);
		// 3: assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0
		serializationMatchSteps[3] = createMatchStep_Assert(191);
		// 4: assert (|BottomPatternCS::ownedRealizedVariables| - 1) == 0
		serializationMatchSteps[4] = createMatchStep_Assert(192);
		// 5: assert (|CollectionLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[5] = createMatchStep_Assert(195);
		// 6: assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0
		serializationMatchSteps[6] = createMatchStep_Assert(196);
		// 7: assert (|CollectionPatternCS::ownedType| - 1) == 0
		serializationMatchSteps[7] = createMatchStep_Assert(198);
		// 8: assert (|CollectionTypeCS::name| - 1) == 0
		serializationMatchSteps[8] = createMatchStep_Assert(199);
		// 9: assert (|ContextCS::ownedExpression| - 1) == 0
		serializationMatchSteps[9] = createMatchStep_Assert(200);
		// 10: assert (|DomainCS::direction| - 1) == 0
		serializationMatchSteps[10] = createMatchStep_Assert(206);
		// 11: assert (|ExpSpecificationCS::ownedExpression| - 1) == 0
		serializationMatchSteps[11] = createMatchStep_Assert(207);
		// 12: assert (|IfExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[12] = createMatchStep_Assert(208);
		// 13: assert (|IfExpCS::ownedElseExpression| - 1) == 0
		serializationMatchSteps[13] = createMatchStep_Assert(209);
		// 14: assert (|IfExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[14] = createMatchStep_Assert(210);
		// 15: assert (|IfThenExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[15] = createMatchStep_Assert(211);
		// 16: assert (|IfThenExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[16] = createMatchStep_Assert(212);
		// 17: assert (|ImportCS::ownedPathName| - 1) == 0
		serializationMatchSteps[17] = createMatchStep_Assert(213);
		// 18: assert (|InfixExpCS::ownedLeft| - 1) == 0
		serializationMatchSteps[18] = createMatchStep_Assert(214);
		// 19: assert (|JavaImplementationCS::implementation| - 1) == 0
		serializationMatchSteps[19] = createMatchStep_Assert(215);
		// 20: assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0
		serializationMatchSteps[20] = createMatchStep_Assert(216);
		// 21: assert (|LetExpCS::ownedInExpression| - 1) == 0
		serializationMatchSteps[21] = createMatchStep_Assert(217);
		// 22: assert (|MapLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[22] = createMatchStep_Assert(221);
		// 23: assert (|MapLiteralPartCS::ownedKey| - 1) == 0
		serializationMatchSteps[23] = createMatchStep_Assert(222);
		// 24: assert (|MapLiteralPartCS::ownedValue| - 1) == 0
		serializationMatchSteps[24] = createMatchStep_Assert(223);
		// 25: assert (|MapTypeCS::name.'Map'| - 1) == 0
		serializationMatchSteps[25] = createMatchStep_Assert(224);
		// 26: assert (|MapTypeCS::ownedKeyType| - V0) == 0
		serializationMatchSteps[26] = createMatchStep_Assert(225);
		// 27: assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0
		serializationMatchSteps[27] = createMatchStep_Assert(228);
		// 28: assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0
		serializationMatchSteps[28] = createMatchStep_Assert(229);
		// 29: assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0
		serializationMatchSteps[29] = createMatchStep_Assert(230);
		// 30: assert (|NamedElementCS::name| - 1) == 0
		serializationMatchSteps[30] = createMatchStep_Assert(231);
		// 31: assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0
		serializationMatchSteps[31] = createMatchStep_Assert(232);
		// 32: assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[32] = createMatchStep_Assert(233);
		// 33: assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0
		serializationMatchSteps[33] = createMatchStep_Assert(234);
		// 34: assert (|NavigatingArgCS::ownedType| - 1) == 0
		serializationMatchSteps[34] = createMatchStep_Assert(235);
		// 35: assert (|NavigatingArgCS::prefix.','| - 1) == 0
		serializationMatchSteps[35] = createMatchStep_Assert(236);
		// 36: assert (|NavigatingArgCS::prefix.';'| - 1) == 0
		serializationMatchSteps[36] = createMatchStep_Assert(237);
		// 37: assert (|NavigatingArgCS::prefix.'|'| - 1) == 0
		serializationMatchSteps[37] = createMatchStep_Assert(238);
		// 38: assert (|NestedExpCS::ownedExpression| - 1) == 0
		serializationMatchSteps[38] = createMatchStep_Assert(239);
		// 39: assert (|NumberLiteralExpCS::symbol| - 1) == 0
		serializationMatchSteps[39] = createMatchStep_Assert(240);
		// 40: assert (|OperatorExpCS::ownedRight| - 1) == 0
		serializationMatchSteps[40] = createMatchStep_Assert(246);
		// 41: assert (|PathElementCS::referredElement| - 1) == 0
		serializationMatchSteps[41] = createMatchStep_Assert(247);
		// 42: assert (|PathNameCS::ownedPathElements| - 1) == 0
		serializationMatchSteps[42] = createMatchStep_Assert(248);
		// 43: assert (|PatternCS::ownedUnrealizedVariables| - 1) == 0
		serializationMatchSteps[43] = createMatchStep_Assert(249);
		// 44: assert (|PatternExpCS::ownedPatternType| - 1) == 0
		serializationMatchSteps[44] = createMatchStep_Assert(250);
		// 45: assert (|PredicateCS::ownedCondition| - 1) == 0
		serializationMatchSteps[45] = createMatchStep_Assert(251);
		// 46: assert (|PredicateOrAssignmentCS::isPartial.'+='| - V1) == 0
		serializationMatchSteps[46] = createMatchStep_Assert(252);
		// 47: assert (|PredicateOrAssignmentCS::ownedTarget| - 1) == 0
		serializationMatchSteps[47] = createMatchStep_Assert(253);
		// 48: assert (|PrimitiveTypeRefCS::name| - 1) == 0
		serializationMatchSteps[48] = createMatchStep_Assert(254);
		// 49: assert (|QueryCS::ownedExpression| - 1) == 0
		serializationMatchSteps[49] = createMatchStep_Assert(255);
		// 50: assert (|QueryCS::ownedPathName| - 1) == 0
		serializationMatchSteps[50] = createMatchStep_Assert(258);
		// 51: assert (|ShadowPartCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[51] = createMatchStep_Assert(259);
		// 52: assert (|ShadowPartCS::referredProperty| - 1) == 0
		serializationMatchSteps[52] = createMatchStep_Assert(260);
		// 53: assert (|SimpleTargetElementCS::input.'input'| - 1) == 0
		serializationMatchSteps[53] = createMatchStep_Assert(261);
		// 54: assert (|SimpleTargetElementCS::output.'output'| - 1) == 0
		serializationMatchSteps[54] = createMatchStep_Assert(264);
		// 55: assert (|SimpleTargetElementCS::typedModel| - 1) == 0
		serializationMatchSteps[55] = createMatchStep_Assert(265);
		// 56: assert (|SimpleTargetElementCS::via.'via'| - 1) == 0
		serializationMatchSteps[56] = createMatchStep_Assert(266);
		// 57: assert (|SpecificationCS::exprString| - 1) == 0
		serializationMatchSteps[57] = createMatchStep_Assert(267);
		// 58: assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0
		serializationMatchSteps[58] = createMatchStep_Assert(274);
		// 59: assert (|TupleTypeCS::name.'Tuple'| - 1) == 0
		serializationMatchSteps[59] = createMatchStep_Assert(277);
		// 60: assert (|TypeLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[60] = createMatchStep_Assert(280);
		// 61: assert (|TypeNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[61] = createMatchStep_Assert(281);
		// 62: assert (|TypedElementCS::ownedType| - 1) == 0
		serializationMatchSteps[62] = createMatchStep_Assert(284);
		// 63: assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0
		serializationMatchSteps[63] = createMatchStep_Assert(289);
		// 64: assert (|TypedElementCS::qualifiers.'static'| - 1) == 0
		serializationMatchSteps[64] = createMatchStep_Assert(290);
		// 65: assert (|TypedTypeRefCS::ownedPathName| - 1) == 0
		serializationMatchSteps[65] = createMatchStep_Assert(291);
		// 66: assert (|VariableCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[66] = createMatchStep_Assert(292);
		// 67: assert |BottomPatternCS::ownedConstraints| == 0
		serializationMatchSteps[67] = createMatchStep_Assert(14);
		// 68: assert |BottomPatternCS::ownedEnforcementOperations| == 0
		serializationMatchSteps[68] = createMatchStep_Assert(15);
		// 69: assert |BottomPatternCS::ownedRealizedVariables| == 0
		serializationMatchSteps[69] = createMatchStep_Assert(16);
		// 70: assert |ClassCS::instanceClassName| == 0
		serializationMatchSteps[70] = createMatchStep_Assert(17);
		// 71: assert |ClassCS::ownedConstraints| == 0
		serializationMatchSteps[71] = createMatchStep_Assert(18);
		// 72: assert |CollectionLiteralPartCS::ownedLastExpression| == 0
		serializationMatchSteps[72] = createMatchStep_Assert(22);
		// 73: assert |CollectionPatternCS::ownedPatternGuard| == 0
		serializationMatchSteps[73] = createMatchStep_Assert(24);
		// 74: assert |CurlyBracketedClauseCS::value| == 0
		serializationMatchSteps[74] = createMatchStep_Assert(33);
		// 75: assert |DataTypeCS::isSerializable| == 0
		serializationMatchSteps[75] = createMatchStep_Assert(36);
		// 76: assert |DomainCS::direction| == 0
		serializationMatchSteps[76] = createMatchStep_Assert(39);
		// 77: assert |DomainCS::isCheck| == 0
		serializationMatchSteps[77] = createMatchStep_Assert(41);
		// 78: assert |DomainCS::isEnforce| == 0
		serializationMatchSteps[78] = createMatchStep_Assert(43);
		// 79: assert |EnumerationCS::isSerializable| == 0
		serializationMatchSteps[79] = createMatchStep_Assert(45);
		// 80: assert |EnumerationCS::ownedLiterals| == 0
		serializationMatchSteps[80] = createMatchStep_Assert(46);
		// 81: assert |EnumerationLiteralCS::literal| == 0
		serializationMatchSteps[81] = createMatchStep_Assert(47);
		// 82: assert |ExpSpecificationCS::ownedExpression| == 0
		serializationMatchSteps[82] = createMatchStep_Assert(49);
		// 83: assert |GuardPatternCS::ownedPredicates| == 0
		serializationMatchSteps[83] = createMatchStep_Assert(50);
		// 84: assert |IfExpCS::isImplicit| == 0
		serializationMatchSteps[84] = createMatchStep_Assert(51);
		// 85: assert |JavaImplementationCS::implementation| == 0
		serializationMatchSteps[85] = createMatchStep_Assert(61);
		// 86: assert |LetExpCS::isImplicit| == 0
		serializationMatchSteps[86] = createMatchStep_Assert(63);
		// 87: assert |ModelElementCS::ownedAnnotations| == 0
		serializationMatchSteps[87] = createMatchStep_Assert(80);
		// 88: assert |MultiplicityCS::isNullFree| == 0
		serializationMatchSteps[88] = createMatchStep_Assert(84);
		// 89: assert |NamedElementCS::name| == 0
		serializationMatchSteps[89] = createMatchStep_Assert(86);
		// 90: assert |NavigatingArgCS::ownedCoIterator| == 0
		serializationMatchSteps[90] = createMatchStep_Assert(87);
		// 91: assert |NavigatingArgCS::ownedInitExpression| == 0
		serializationMatchSteps[91] = createMatchStep_Assert(88);
		// 92: assert |NavigatingArgCS::ownedNameExpression| == 0
		serializationMatchSteps[92] = createMatchStep_Assert(89);
		// 93: assert |NavigatingArgCS::ownedType| == 0
		serializationMatchSteps[93] = createMatchStep_Assert(90);
		// 94: assert |NavigatingArgCS::prefix| == 0
		serializationMatchSteps[94] = createMatchStep_Assert(94);
		// 95: assert |OperationCS::ownedBodyExpressions| == 0
		serializationMatchSteps[95] = createMatchStep_Assert(97);
		// 96: assert |OperationCS::ownedPostconditions| == 0
		serializationMatchSteps[96] = createMatchStep_Assert(100);
		// 97: assert |OperationCS::ownedPreconditions| == 0
		serializationMatchSteps[97] = createMatchStep_Assert(101);
		// 98: assert |PackageCS::ownedClasses| == 0
		serializationMatchSteps[98] = createMatchStep_Assert(105);
		// 99: assert |PackageOwnerCS::ownedPackages| == 0
		serializationMatchSteps[99] = createMatchStep_Assert(106);
		// 100: assert |PatternCS::ownedUnrealizedVariables| == 0
		serializationMatchSteps[100] = createMatchStep_Assert(109);
		// 101: assert |PredicateOrAssignmentCS::isPartial| == 0
		serializationMatchSteps[101] = createMatchStep_Assert(115);
		// 102: assert |QueryCS::ownedExpression| == 0
		serializationMatchSteps[102] = createMatchStep_Assert(121);
		// 103: assert |ReferenceCS::ownedImplicitOpposites| == 0
		serializationMatchSteps[103] = createMatchStep_Assert(124);
		// 104: assert |ReferenceCS::referredKeys| == 0
		serializationMatchSteps[104] = createMatchStep_Assert(125);
		// 105: assert |RootCS::ownedImports| == 0
		serializationMatchSteps[105] = createMatchStep_Assert(127);
		// 106: assert |SelfExpCS::name| == 0
		serializationMatchSteps[106] = createMatchStep_Assert(128);
		// 107: assert |ShadowPartCS::referredProperty| == 0
		serializationMatchSteps[107] = createMatchStep_Assert(130);
		// 108: assert |SimpleTargetElementCS::input| == 0
		serializationMatchSteps[108] = createMatchStep_Assert(132);
		// 109: assert |SimpleTargetElementCS::output| == 0
		serializationMatchSteps[109] = createMatchStep_Assert(135);
		// 110: assert |SimpleTargetElementCS::via| == 0
		serializationMatchSteps[110] = createMatchStep_Assert(138);
		// 111: assert |SpecificationCS::exprString| == 0
		serializationMatchSteps[111] = createMatchStep_Assert(139);
		// 112: assert |StructuralFeatureCS::ownedDefaultExpressions| == 0
		serializationMatchSteps[112] = createMatchStep_Assert(143);
		// 113: assert |StructuredClassCS::ownedMetaclass| == 0
		serializationMatchSteps[113] = createMatchStep_Assert(146);
		// 114: assert |StructuredClassCS::ownedOperations| == 0
		serializationMatchSteps[114] = createMatchStep_Assert(147);
		// 115: assert |StructuredClassCS::ownedProperties| == 0
		serializationMatchSteps[115] = createMatchStep_Assert(148);
		// 116: assert |TemplateableElementCS::ownedSignature| == 0
		serializationMatchSteps[116] = createMatchStep_Assert(155);
		// 117: assert |TypeLiteralExpCS::ownedPathName| == 0
		serializationMatchSteps[117] = createMatchStep_Assert(164);
		// 118: assert |TypedElementCS::isOptional| == 0
		serializationMatchSteps[118] = createMatchStep_Assert(170);
		// 119: assert |TypedElementCS::qualifiers| == 0
		serializationMatchSteps[119] = createMatchStep_Assert(178);
		// 120: assert |TypedRefCS::ownedMultiplicity| == 0
		serializationMatchSteps[120] = createMatchStep_Assert(179);
		// 121: assert |TypedTypeRefCS::isTypeof| == 0
		serializationMatchSteps[121] = createMatchStep_Assert(180);
		// 122: assert |UnrealizedVariableCS::ownedInitExpression| == 0
		serializationMatchSteps[122] = createMatchStep_Assert(183);
		// 123: assert |VariableCS::ownedInitExpression| == 0
		serializationMatchSteps[123] = createMatchStep_Assert(184);
		// 124: assert |WildcardTypeRefCS::ownedSuper| == 0
		serializationMatchSteps[124] = createMatchStep_Assert(187);
		// 125: assign V0 = (|BottomPatternCS::ownedRealizedVariables| - 1)
		serializationMatchSteps[125] = createMatchStep_Assign(0, 192);
		// 126: assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[126] = createMatchStep_Assign(0, 194);
		// 127: assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchSteps[127] = createMatchStep_Assign(0, 202);
		// 128: assign V0 = (|LetExpCS::ownedVariables| - 1)
		serializationMatchSteps[128] = createMatchStep_Assign(0, 218);
		// 129: assign V0 = (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[129] = createMatchStep_Assign(0, 220);
		// 130: assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1)
		serializationMatchSteps[130] = createMatchStep_Assign(0, 249);
		// 131: assign V0 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[131] = createMatchStep_Assign(0, 263);
		// 132: assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchSteps[132] = createMatchStep_Assign(0, 268);
		// 133: assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchSteps[133] = createMatchStep_Assign(0, 273);
		// 134: assign V0 = (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchSteps[134] = createMatchStep_Assign(0, 275);
		// 135: assign V0 = (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[135] = createMatchStep_Assign(0, 276);
		// 136: assign V0 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[136] = createMatchStep_Assign(0, 279);
		// 137: assign V0 = (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchSteps[137] = createMatchStep_Assign(0, 283);
		// 138: assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchSteps[138] = createMatchStep_Assign(0, 8);
		// 139: assign V0 = |AbstractTransformationCS::ownedPathName|
		serializationMatchSteps[139] = createMatchStep_Assign(0, 9);
		// 140: assign V0 = |BottomPatternCS::ownedConstraints|
		serializationMatchSteps[140] = createMatchStep_Assign(0, 14);
		// 141: assign V0 = |BottomPatternCS::ownedRealizedVariables|
		serializationMatchSteps[141] = createMatchStep_Assign(0, 16);
		// 142: assign V0 = |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchSteps[142] = createMatchStep_Assign(0, 22);
		// 143: assign V0 = |CollectionPatternCS::restVariableName|
		serializationMatchSteps[143] = createMatchStep_Assign(0, 26);
		// 144: assign V0 = |CollectionTypeCS::ownedType|
		serializationMatchSteps[144] = createMatchStep_Assign(0, 29);
		// 145: assign V0 = |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchSteps[145] = createMatchStep_Assign(0, 30);
		// 146: assign V0 = |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchSteps[146] = createMatchStep_Assign(0, 34);
		// 147: assign V0 = |DomainCS::isCheck.'check'|
		serializationMatchSteps[147] = createMatchStep_Assign(0, 40);
		// 148: assign V0 = |EnumerationLiteralCS::value|
		serializationMatchSteps[148] = createMatchStep_Assign(0, 48);
		// 149: assign V0 = |GuardPatternCS::ownedPredicates|
		serializationMatchSteps[149] = createMatchStep_Assign(0, 50);
		// 150: assign V0 = |IfExpCS::ownedIfThenExpressions|
		serializationMatchSteps[150] = createMatchStep_Assign(0, 54);
		// 151: assign V0 = |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchSteps[151] = createMatchStep_Assign(0, 66);
		// 152: assign V0 = |MapTypeCS::ownedValueType|
		serializationMatchSteps[152] = createMatchStep_Assign(0, 73);
		// 153: assign V0 = |MappingCS::isAbstract.'abstract'|
		serializationMatchSteps[153] = createMatchStep_Assign(0, 74);
		// 154: assign V0 = |MultiplicityBoundsCS::upperBound|
		serializationMatchSteps[154] = createMatchStep_Assign(0, 82);
		// 155: assign V0 = |NamedElementCS::name|
		serializationMatchSteps[155] = createMatchStep_Assign(0, 86);
		// 156: assign V0 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[156] = createMatchStep_Assign(0, 87);
		// 157: assign V0 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[157] = createMatchStep_Assign(0, 88);
		// 158: assign V0 = |NavigatingArgCS::ownedType|
		serializationMatchSteps[158] = createMatchStep_Assign(0, 90);
		// 159: assign V0 = |PatternCS::ownedUnrealizedVariables|
		serializationMatchSteps[159] = createMatchStep_Assign(0, 109);
		// 160: assign V0 = |PatternExpCS::patternVariableName|
		serializationMatchSteps[160] = createMatchStep_Assign(0, 111);
		// 161: assign V0 = |PredicateOrAssignmentCS::isDefault.'default'|
		serializationMatchSteps[161] = createMatchStep_Assign(0, 113);
		// 162: assign V0 = |QualifiedPackageCS::ownedPathName|
		serializationMatchSteps[162] = createMatchStep_Assign(0, 119);
		// 163: assign V0 = |QueryCS::isTransient.'transient'|
		serializationMatchSteps[163] = createMatchStep_Assign(0, 120);
		// 164: assign V0 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[164] = createMatchStep_Assign(0, 126);
		// 165: assign V0 = |RootCS::ownedImports|
		serializationMatchSteps[165] = createMatchStep_Assign(0, 127);
		// 166: assign V0 = |SimpleTargetElementCS::iterates|
		serializationMatchSteps[166] = createMatchStep_Assign(0, 133);
		// 167: assign V0 = |StringLiteralExpCS::segments|
		serializationMatchSteps[167] = createMatchStep_Assign(0, 141);
		// 168: assign V0 = |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchSteps[168] = createMatchStep_Assign(0, 144);
		// 169: assign V0 = |TargetCS::ownedTargetElements|
		serializationMatchSteps[169] = createMatchStep_Assign(0, 150);
		// 170: assign V0 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[170] = createMatchStep_Assign(0, 155);
		// 171: assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[171] = createMatchStep_Assign(0, 166);
		// 172: assign V0 = |TypedElementCS::ownedType|
		serializationMatchSteps[172] = createMatchStep_Assign(0, 171);
		// 173: assign V0 = |TypedElementCS::qualifiers.'definition'|
		serializationMatchSteps[173] = createMatchStep_Assign(0, 176);
		// 174: assign V0 = |TypedElementCS::qualifiers.'static'|
		serializationMatchSteps[174] = createMatchStep_Assign(0, 177);
		// 175: assign V0 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[175] = createMatchStep_Assign(0, 179);
		// 176: assign V0 = |TypedTypeRefCS::ownedBinding|
		serializationMatchSteps[176] = createMatchStep_Assign(0, 181);
		// 177: assign V0 = |VariableCS::ownedType|
		serializationMatchSteps[177] = createMatchStep_Assign(0, 185);
		// 178: assign V0 = |WildcardTypeRefCS::ownedExtends|
		serializationMatchSteps[178] = createMatchStep_Assign(0, 186);
		// 179: assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[179] = createMatchStep_Assign(1, 193);
		// 180: assign V1 = (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchSteps[180] = createMatchStep_Assign(1, 197);
		// 181: assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchSteps[181] = createMatchStep_Assign(1, 201);
		// 182: assign V1 = (|DirectionCS::imports| - 1)
		serializationMatchSteps[182] = createMatchStep_Assign(1, 203);
		// 183: assign V1 = (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[183] = createMatchStep_Assign(1, 219);
		// 184: assign V1 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[184] = createMatchStep_Assign(1, 245);
		// 185: assign V1 = (|QueryCS::ownedParameters| > 0)
		serializationMatchSteps[185] = createMatchStep_Assign(1, 257);
		// 186: assign V1 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[186] = createMatchStep_Assign(1, 263);
		// 187: assign V1 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[187] = createMatchStep_Assign(1, 279);
		// 188: assign V1 = (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchSteps[188] = createMatchStep_Assign(1, 282);
		// 189: assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchSteps[189] = createMatchStep_Assign(1, 288);
		// 190: assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchSteps[190] = createMatchStep_Assign(1, 7);
		// 191: assign V1 = |BottomPatternCS::ownedConstraints|
		serializationMatchSteps[191] = createMatchStep_Assign(1, 14);
		// 192: assign V1 = |ClassCS::instanceClassName|
		serializationMatchSteps[192] = createMatchStep_Assign(1, 17);
		// 193: assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchSteps[193] = createMatchStep_Assign(1, 28);
		// 194: assign V1 = |DomainCS::isEnforce.'enforce'|
		serializationMatchSteps[194] = createMatchStep_Assign(1, 42);
		// 195: assign V1 = |GuardPatternCS::ownedPredicates|
		serializationMatchSteps[195] = createMatchStep_Assign(1, 50);
		// 196: assign V1 = |ImportCS::isAll.'::'|
		serializationMatchSteps[196] = createMatchStep_Assign(1, 58);
		// 197: assign V1 = |NamedElementCS::name|
		serializationMatchSteps[197] = createMatchStep_Assign(1, 86);
		// 198: assign V1 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[198] = createMatchStep_Assign(1, 87);
		// 199: assign V1 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[199] = createMatchStep_Assign(1, 88);
		// 200: assign V1 = |PackageCS::nsPrefix|
		serializationMatchSteps[200] = createMatchStep_Assign(1, 103);
		// 201: assign V1 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[201] = createMatchStep_Assign(1, 106);
		// 202: assign V1 = |PredicateOrAssignmentCS::ownedInitExpression|
		serializationMatchSteps[202] = createMatchStep_Assign(1, 116);
		// 203: assign V1 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[203] = createMatchStep_Assign(1, 126);
		// 204: assign V1 = |StructuralFeatureCS::default|
		serializationMatchSteps[204] = createMatchStep_Assign(1, 142);
		// 205: assign V1 = |TemplateBindingCS::ownedMultiplicity|
		serializationMatchSteps[205] = createMatchStep_Assign(1, 151);
		// 206: assign V1 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[206] = createMatchStep_Assign(1, 155);
		// 207: assign V1 = |TransformationCS::ownedDirections|
		serializationMatchSteps[207] = createMatchStep_Assign(1, 159);
		// 208: assign V1 = |TypeNameExpCS::ownedPatternGuard|
		serializationMatchSteps[208] = createMatchStep_Assign(1, 168);
		// 209: assign V1 = |TypedElementCS::ownedType|
		serializationMatchSteps[209] = createMatchStep_Assign(1, 171);
		// 210: assign V1 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[210] = createMatchStep_Assign(1, 179);
		// 211: assign V1 = |UnrealizedVariableCS::ownedInitExpression|
		serializationMatchSteps[211] = createMatchStep_Assign(1, 183);
		// 212: assign V1 = |VariableCS::ownedType|
		serializationMatchSteps[212] = createMatchStep_Assign(1, 185);
		// 213: assign V10 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[213] = createMatchStep_Assign(10, 97);
		// 214: assign V2 = (|DirectionCS::uses| > 0)
		serializationMatchSteps[214] = createMatchStep_Assign(2, 205);
		// 215: assign V2 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[215] = createMatchStep_Assign(2, 244);
		// 216: assign V2 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[216] = createMatchStep_Assign(2, 245);
		// 217: assign V2 = (|QueryCS::ownedParameters| - 1)
		serializationMatchSteps[217] = createMatchStep_Assign(2, 256);
		// 218: assign V2 = (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchSteps[218] = createMatchStep_Assign(2, 262);
		// 219: assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchSteps[219] = createMatchStep_Assign(2, 272);
		// 220: assign V2 = (|TupleTypeCS::ownedParts| - 1)
		serializationMatchSteps[220] = createMatchStep_Assign(2, 278);
		// 221: assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[221] = createMatchStep_Assign(2, 286);
		// 222: assign V2 = 0
		serializationMatchSteps[222] = createMatchStep_Assign(2, 0);
		// 223: assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[223] = createMatchStep_Assign(2, 5);
		// 224: assign V2 = |AbstractTransformationCS::ownedTargets|
		serializationMatchSteps[224] = createMatchStep_Assign(2, 10);
		// 225: assign V2 = |ClassCS::instanceClassName|
		serializationMatchSteps[225] = createMatchStep_Assign(2, 17);
		// 226: assign V2 = |EnumerationCS::isSerializable.'serializable'|
		serializationMatchSteps[226] = createMatchStep_Assign(2, 44);
		// 227: assign V2 = |MappingCS::ownedInPathName|
		serializationMatchSteps[227] = createMatchStep_Assign(2, 77);
		// 228: assign V2 = |PackageCS::nsURI|
		serializationMatchSteps[228] = createMatchStep_Assign(2, 104);
		// 229: assign V2 = |StructuralFeatureCS::default|
		serializationMatchSteps[229] = createMatchStep_Assign(2, 142);
		// 230: assign V2 = |TopLevelCS::ownedTransformations|
		serializationMatchSteps[230] = createMatchStep_Assign(2, 158);
		// 231: assign V2 = |TypedElementCS::ownedType|
		serializationMatchSteps[231] = createMatchStep_Assign(2, 171);
		// 232: assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchSteps[232] = createMatchStep_Assign(2, 175);
		// 233: assign V2 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[233] = createMatchStep_Assign(2, 179);
		// 234: assign V3 = (|DirectionCS::uses| - 1)
		serializationMatchSteps[234] = createMatchStep_Assign(3, 204);
		// 235: assign V3 = (|MappingCS::refines| > 0)
		serializationMatchSteps[235] = createMatchStep_Assign(3, 227);
		// 236: assign V3 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[236] = createMatchStep_Assign(3, 244);
		// 237: assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchSteps[237] = createMatchStep_Assign(3, 271);
		// 238: assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[238] = createMatchStep_Assign(3, 285);
		// 239: assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[239] = createMatchStep_Assign(3, 286);
		// 240: assign V3 = 0
		serializationMatchSteps[240] = createMatchStep_Assign(3, 0);
		// 241: assign V3 = |AbstractNameExpCS::isPre.'@'|
		serializationMatchSteps[241] = createMatchStep_Assign(3, 4);
		// 242: assign V3 = |DataTypeCS::isSerializable.'serializable'|
		serializationMatchSteps[242] = createMatchStep_Assign(3, 35);
		// 243: assign V3 = |EnumerationCS::ownedLiterals|
		serializationMatchSteps[243] = createMatchStep_Assign(3, 46);
		// 244: assign V3 = |PackageCS::ownedClasses|
		serializationMatchSteps[244] = createMatchStep_Assign(3, 105);
		// 245: assign V3 = |StructuralFeatureCS::default|
		serializationMatchSteps[245] = createMatchStep_Assign(3, 142);
		// 246: assign V3 = |TopLevelCS::ownedMappings|
		serializationMatchSteps[246] = createMatchStep_Assign(3, 156);
		// 247: assign V3 = |TransformationCS::ownedProperties|
		serializationMatchSteps[247] = createMatchStep_Assign(3, 160);
		// 248: assign V3 = |TypedElementCS::ownedType|
		serializationMatchSteps[248] = createMatchStep_Assign(3, 171);
		// 249: assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[249] = createMatchStep_Assign(3, 173);
		// 250: assign V3 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[250] = createMatchStep_Assign(3, 179);
		// 251: assign V4 = (|MappingCS::refines| - 1)
		serializationMatchSteps[251] = createMatchStep_Assign(4, 226);
		// 252: assign V4 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[252] = createMatchStep_Assign(4, 243);
		// 253: assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[253] = createMatchStep_Assign(4, 285);
		// 254: assign V4 = |ClassCS::instanceClassName|
		serializationMatchSteps[254] = createMatchStep_Assign(4, 17);
		// 255: assign V4 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[255] = createMatchStep_Assign(4, 106);
		// 256: assign V4 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[256] = createMatchStep_Assign(4, 143);
		// 257: assign V4 = |TopLevelCS::ownedQueries|
		serializationMatchSteps[257] = createMatchStep_Assign(4, 157);
		// 258: assign V4 = |TypedElementCS::ownedType|
		serializationMatchSteps[258] = createMatchStep_Assign(4, 171);
		// 259: assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[259] = createMatchStep_Assign(4, 172);
		// 260: assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[260] = createMatchStep_Assign(4, 173);
		// 261: assign V5 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[261] = createMatchStep_Assign(5, 242);
		// 262: assign V5 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[262] = createMatchStep_Assign(5, 243);
		// 263: assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[263] = createMatchStep_Assign(5, 269);
		// 264: assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchSteps[264] = createMatchStep_Assign(5, 270);
		// 265: assign V5 = |MappingCS::ownedDomains|
		serializationMatchSteps[265] = createMatchStep_Assign(5, 76);
		// 266: assign V5 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[266] = createMatchStep_Assign(5, 143);
		// 267: assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[267] = createMatchStep_Assign(5, 172);
		// 268: assign V6 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[268] = createMatchStep_Assign(6, 242);
		// 269: assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[269] = createMatchStep_Assign(6, 269);
		// 270: assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[270] = createMatchStep_Assign(6, 287);
		// 271: assign V6 = 0
		serializationMatchSteps[271] = createMatchStep_Assign(6, 0);
		// 272: assign V6 = |MappingCS::ownedMiddle|
		serializationMatchSteps[272] = createMatchStep_Assign(6, 78);
		// 273: assign V6 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[273] = createMatchStep_Assign(6, 143);
		// 274: assign V6 = |StructuredClassCS::isInterface.'interface'|
		serializationMatchSteps[274] = createMatchStep_Assign(6, 145);
		// 275: assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[275] = createMatchStep_Assign(7, 269);
		// 276: assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[276] = createMatchStep_Assign(7, 287);
		// 277: assign V7 = 0
		serializationMatchSteps[277] = createMatchStep_Assign(7, 0);
		// 278: assign V7 = |MappingCS::ownedComposedMappings|
		serializationMatchSteps[278] = createMatchStep_Assign(7, 75);
		// 279: assign V7 = |StructuredClassCS::ownedOperations|
		serializationMatchSteps[279] = createMatchStep_Assign(7, 147);
		// 280: assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[280] = createMatchStep_Assign(7, 174);
		// 281: assign V8 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[281] = createMatchStep_Assign(8, 241);
		// 282: assign V8 = 0
		serializationMatchSteps[282] = createMatchStep_Assign(8, 0);
		// 283: assign V8 = |StructuredClassCS::ownedProperties|
		serializationMatchSteps[283] = createMatchStep_Assign(8, 148);
		// 284: assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[284] = createMatchStep_Assign(8, 174);
		// 285: assign V9 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[285] = createMatchStep_Assign(9, 241);
		// 286: assign V9 = 0
		serializationMatchSteps[286] = createMatchStep_Assign(9, 0);
		// 287: assign V9 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[287] = createMatchStep_Assign(9, 97);
		// 288: check-rule basecs::EnumerationCS.ownedLiterals : 21
		serializationMatchSteps[288] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/*EnumerationLiteralCS*/);
		// 289: check-rule basecs::ImportCS.ownedPathName : 128
		serializationMatchSteps[289] = createMatchStep_RuleCheck(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 69/*URIPathNameCS*/);
		// 290: check-rule basecs::OperationCS.ownedBodyExpressions : 97
		serializationMatchSteps[290] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 42/*SpecificationCS*/);
		// 291: check-rule basecs::OperationCS.ownedExceptions : 10|49|79|112|115|122|123
		serializationMatchSteps[291] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 66/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 292: check-rule basecs::OperationCS.ownedParameters : 70
		serializationMatchSteps[292] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/*ParameterCS*/);
		// 293: check-rule basecs::PackageCS.ownedClasses : 5|15|20|102|108
		serializationMatchSteps[293] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 54/*ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS*/);
		// 294: check-rule basecs::PackageOwnerCS.ownedPackages : 83
		serializationMatchSteps[294] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 34/*QualifiedPackageCS*/);
		// 295: check-rule basecs::PathNameCS.ownedPathElements : 30
		serializationMatchSteps[295] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 9/*FirstPathElementCS*/);
		// 296: check-rule basecs::RootCS.ownedImports : 37
		serializationMatchSteps[296] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 12/*ImportCS*/);
		// 297: check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : 97
		serializationMatchSteps[297] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 42/*SpecificationCS*/);
		// 298: check-rule basecs::StructuredClassCS.ownedOperations : 68
		serializationMatchSteps[298] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 23/*OperationCS*/);
		// 299: check-rule basecs::StructuredClassCS.ownedProperties : 1|86|101
		serializationMatchSteps[299] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 46/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 300: check-rule basecs::StructuredClassCS.ownedSuperTypes : 10|49|79|112|115|122|123
		serializationMatchSteps[300] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 66/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 301: check-rule basecs::TemplateBindingCS.ownedMultiplicity : 53
		serializationMatchSteps[301] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 302: check-rule basecs::TemplateBindingCS.ownedSubstitutions : 105
		serializationMatchSteps[302] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 50/*TemplateParameterSubstitutionCS*/);
		// 303: check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : 10|49|79|112|115|120|122|123|136
		serializationMatchSteps[303] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 79/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS*/);
		// 304: check-rule basecs::TemplateSignatureCS.ownedParameters : 119
		serializationMatchSteps[304] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 62/*TypeParameterCS*/);
		// 305: check-rule basecs::TemplateableElementCS.ownedSignature : 106
		serializationMatchSteps[305] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/*TemplateSignatureCS*/);
		// 306: check-rule basecs::TupleTypeCS.ownedParts : 111
		serializationMatchSteps[306] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 56/*TuplePartCS*/);
		// 307: check-rule basecs::TypeParameterCS.ownedExtends : 10|49|79|112|115|122|123
		serializationMatchSteps[307] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 66/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 308: check-rule basecs::TypedElementCS.ownedType : 113
		serializationMatchSteps[308] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/*TypeExpCS*/);
		// 309: check-rule basecs::TypedElementCS.ownedType : 121
		serializationMatchSteps[309] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/*TypedMultiplicityRefCS*/);
		// 310: check-rule basecs::TypedRefCS.ownedMultiplicity : 53
		serializationMatchSteps[310] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 311: check-rule basecs::TypedTypeRefCS.ownedBinding : 104
		serializationMatchSteps[311] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 49/*TemplateBindingCS*/);
		// 312: check-rule basecs::TypedTypeRefCS.ownedPathName : 71
		serializationMatchSteps[312] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 26/*PathNameCS*/);
		// 313: check-rule basecs::WildcardTypeRefCS.ownedExtends : 10|49|79|112|115|122|123
		serializationMatchSteps[313] = createMatchStep_RuleCheck(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 66/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 314: check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : 13
		serializationMatchSteps[314] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/*CurlyBracketedClauseCS*/);
		// 315: check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : 71
		serializationMatchSteps[315] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 26/*PathNameCS*/);
		// 316: check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : 87
		serializationMatchSteps[316] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 37/*RoundBracketedClauseCS*/);
		// 317: check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : 98
		serializationMatchSteps[317] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 43/*SquareBracketedClauseCS*/);
		// 318: check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : 8
		serializationMatchSteps[318] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 2/*CollectionLiteralPartCS*/);
		// 319: check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : 10
		serializationMatchSteps[319] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 3/*CollectionTypeCS*/);
		// 320: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[320] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 321: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 72
		serializationMatchSteps[321] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 27/*PatternExpCS*/);
		// 322: check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[322] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 323: check-rule essentialoclcs::CollectionPatternCS.ownedParts : 72
		serializationMatchSteps[323] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 27/*PatternExpCS*/);
		// 324: check-rule essentialoclcs::CollectionPatternCS.ownedType : 10
		serializationMatchSteps[324] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 3/*CollectionTypeCS*/);
		// 325: check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : 53
		serializationMatchSteps[325] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 326: check-rule essentialoclcs::CollectionTypeCS.ownedType : 9|10|49|79|112|114|115|118
		serializationMatchSteps[326] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/*CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS*/);
		// 327: check-rule essentialoclcs::ContextCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[327] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 328: check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : 94
		serializationMatchSteps[328] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 39/*ShadowPartCS*/);
		// 329: check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[329] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 330: check-rule essentialoclcs::IfExpCS.ownedCondition : 3|7|29|36|39|42|43|47|56|64|66|67|72|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[330] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 76/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 331: check-rule essentialoclcs::IfExpCS.ownedElseExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[331] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 332: check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : 19
		serializationMatchSteps[332] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 6/*ElseIfThenExpCS*/);
		// 333: check-rule essentialoclcs::IfExpCS.ownedThenExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[333] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 334: check-rule essentialoclcs::IfThenExpCS.ownedCondition : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[334] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 335: check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[335] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 336: check-rule essentialoclcs::InfixExpCS.ownedLeft : 3|7|36|39|42|47|56|64|66|67|76|77|78|93|100|109|116|130
		serializationMatchSteps[336] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 72/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 337: check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[337] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 338: check-rule essentialoclcs::LetExpCS.ownedInExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[338] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 339: check-rule essentialoclcs::LetExpCS.ownedVariables : 44
		serializationMatchSteps[339] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 13/*LetVariableCS*/);
		// 340: check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : 87
		serializationMatchSteps[340] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 37/*RoundBracketedClauseCS*/);
		// 341: check-rule essentialoclcs::MapLiteralExpCS.ownedParts : 48
		serializationMatchSteps[341] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 14/*MapLiteralPartCS*/);
		// 342: check-rule essentialoclcs::MapLiteralExpCS.ownedType : 49
		serializationMatchSteps[342] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 15/*MapTypeCS*/);
		// 343: check-rule essentialoclcs::MapLiteralPartCS.ownedKey : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[343] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 344: check-rule essentialoclcs::MapLiteralPartCS.ownedValue : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[344] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 345: check-rule essentialoclcs::MapTypeCS.ownedKeyType : 113
		serializationMatchSteps[345] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 57/*TypeExpCS*/);
		// 346: check-rule essentialoclcs::MapTypeCS.ownedValueType : 113
		serializationMatchSteps[346] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 57/*TypeExpCS*/);
		// 347: check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : 6
		serializationMatchSteps[347] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/*CoIteratorVariableCS*/);
		// 348: check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[348] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 349: check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : 3|7|29|36|39|42|43|47|56|59|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[349] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 350: check-rule essentialoclcs::NavigatingArgCS.ownedType : 113
		serializationMatchSteps[350] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/*TypeExpCS*/);
		// 351: check-rule essentialoclcs::NestedExpCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[351] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 352: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[352] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 353: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|7|36|39|42|47|56|64|66|67|76|77|78|93|100|109|116|130
		serializationMatchSteps[353] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 72/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 354: check-rule essentialoclcs::OperatorExpCS.ownedRight : 43|75
		serializationMatchSteps[354] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 32/*LetExpCS|PrefixedLetExpCS*/);
		// 355: check-rule essentialoclcs::PatternExpCS.ownedPatternType : 113
		serializationMatchSteps[355] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 57/*TypeExpCS*/);
		// 356: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 100
		serializationMatchSteps[356] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 44/*StringLiteralExpCS*/);
		// 357: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|72|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[357] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 76/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 358: check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[358] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 359: check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : 110
		serializationMatchSteps[359] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 55/*TupleLiteralPartCS*/);
		// 360: check-rule essentialoclcs::TypeLiteralExpCS.ownedType : 117
		serializationMatchSteps[360] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 60/*TypeLiteralWithMultiplicityCS*/);
		// 361: check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : 13
		serializationMatchSteps[361] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/*CurlyBracketedClauseCS*/);
		// 362: check-rule essentialoclcs::TypeNameExpCS.ownedPathName : 71
		serializationMatchSteps[362] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 26/*PathNameCS*/);
		// 363: check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[363] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 364: check-rule essentialoclcs::VariableCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[364] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 365: check-rule essentialoclcs::VariableCS.ownedType : 113
		serializationMatchSteps[365] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 57/*TypeExpCS*/);
		// 366: check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : 92
		serializationMatchSteps[366] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 38/*ScopeNameCS*/);
		// 367: check-rule qvtbasecs::AbstractTransformationCS.ownedTargets : 103
		serializationMatchSteps[367] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 48/*TargetCS*/);
		// 368: check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : 96
		serializationMatchSteps[368] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 40/*SimpleTargetElementCS*/);
		// 369: check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : 92
		serializationMatchSteps[369] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 38/*ScopeNameCS*/);
		// 370: check-rule qvtbasecs::TargetCS.ownedTargetElements : 12|96
		serializationMatchSteps[370] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 41/*CompoundTargetElementCS|SimpleTargetElementCS*/);
		// 371: check-rule qvtcorecs::AreaCS.ownedBottomPattern : 4
		serializationMatchSteps[371] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN, 0/*BottomPatternCS*/);
		// 372: check-rule qvtcorecs::AreaCS.ownedGuardPattern : 31
		serializationMatchSteps[372] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.AREA_CS__OWNED_GUARD_PATTERN, 10/*GuardPatternCS*/);
		// 373: check-rule qvtcorecs::BottomPatternCS.ownedConstraints : 74
		serializationMatchSteps[373] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 30/*PredicateOrAssignmentCS*/);
		// 374: check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : 85
		serializationMatchSteps[374] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 36/*RealizedVariableCS*/);
		// 375: check-rule qvtcorecs::GuardPatternCS.ownedPredicates : 73
		serializationMatchSteps[375] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 29/*PredicateCS*/);
		// 376: check-rule qvtcorecs::MappingCS.ownedComposedMappings : 50
		serializationMatchSteps[376] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_COMPOSED_MAPPINGS, 16/*MappingCS*/);
		// 377: check-rule qvtcorecs::MappingCS.ownedDomains : 57
		serializationMatchSteps[377] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_DOMAINS, 18/*NamedDomainCS*/);
		// 378: check-rule qvtcorecs::MappingCS.ownedInPathName : 71
		serializationMatchSteps[378] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME, 26/*PathNameCS*/);
		// 379: check-rule qvtcorecs::MappingCS.ownedMiddle : 131
		serializationMatchSteps[379] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE, 77/*UnnamedDomainCS*/);
		// 380: check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : 132
		serializationMatchSteps[380] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 78/*UnrealizedVariableCS*/);
		// 381: check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : 32
		serializationMatchSteps[381] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 11/*GuardVariableCS*/);
		// 382: check-rule qvtcorecs::PredicateCS.ownedCondition : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[382] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 383: check-rule qvtcorecs::PredicateOrAssignmentCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[383] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 384: check-rule qvtcorecs::PredicateOrAssignmentCS.ownedTarget : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[384] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 385: check-rule qvtcorecs::QueryCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[385] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 386: check-rule qvtcorecs::QueryCS.ownedParameters : 69
		serializationMatchSteps[386] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/*ParamDeclarationCS*/);
		// 387: check-rule qvtcorecs::QueryCS.ownedPathName : 92
		serializationMatchSteps[387] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 38/*ScopeNameCS*/);
		// 388: check-rule qvtcorecs::TopLevelCS.ownedMappings : 50
		serializationMatchSteps[388] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS, 16/*MappingCS*/);
		// 389: check-rule qvtcorecs::TopLevelCS.ownedQueries : 84
		serializationMatchSteps[389] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES, 35/*QueryCS*/);
		// 390: check-rule qvtcorecs::TopLevelCS.ownedTransformations : 108
		serializationMatchSteps[390] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 52/*TransformationCS*/);
		// 391: check-rule qvtcorecs::TransformationCS.ownedDirections : 16
		serializationMatchSteps[391] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 5/*DirectionCS*/);
		// 392: check-rule qvtcorecs::TransformationCS.ownedProperties : 1|86|101
		serializationMatchSteps[392] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 46/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 393: check-rule qvtcorecs::UnrealizedVariableCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[393] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION, 74/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
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
		// 3: V1
		serializationMatchTerms[3] = createSerializationMatchTermVariable(1);
		// 4: |AbstractNameExpCS::isPre.'@'|
		serializationMatchTerms[4] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 9 /* '@' */);
		// 5: |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchTerms[5] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		// 6: |AbstractNameExpCS::ownedPathName|
		serializationMatchTerms[6] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME);
		// 7: |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchTerms[7] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		// 8: |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchTerms[8] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES);
		// 9: |AbstractTransformationCS::ownedPathName|
		serializationMatchTerms[9] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME);
		// 10: |AbstractTransformationCS::ownedTargets|
		serializationMatchTerms[10] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS);
		// 11: |AreaCS::ownedBottomPattern|
		serializationMatchTerms[11] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN);
		// 12: |AreaCS::ownedGuardPattern|
		serializationMatchTerms[12] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.AREA_CS__OWNED_GUARD_PATTERN);
		// 13: |BooleanLiteralExpCS::symbol.'false|true'|
		serializationMatchTerms[13] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 17 /* 'false|true' */);
		// 14: |BottomPatternCS::ownedConstraints|
		serializationMatchTerms[14] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS);
		// 15: |BottomPatternCS::ownedEnforcementOperations|
		serializationMatchTerms[15] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_ENFORCEMENT_OPERATIONS);
		// 16: |BottomPatternCS::ownedRealizedVariables|
		serializationMatchTerms[16] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES);
		// 17: |ClassCS::instanceClassName|
		serializationMatchTerms[17] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME);
		// 18: |ClassCS::ownedConstraints|
		serializationMatchTerms[18] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__OWNED_CONSTRAINTS);
		// 19: |CollectionLiteralExpCS::ownedParts|
		serializationMatchTerms[19] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);
		// 20: |CollectionLiteralExpCS::ownedType|
		serializationMatchTerms[20] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE);
		// 21: |CollectionLiteralPartCS::ownedExpression|
		serializationMatchTerms[21] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION);
		// 22: |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchTerms[22] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION);
		// 23: |CollectionPatternCS::ownedParts|
		serializationMatchTerms[23] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS);
		// 24: |CollectionPatternCS::ownedPatternGuard|
		serializationMatchTerms[24] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD);
		// 25: |CollectionPatternCS::ownedType|
		serializationMatchTerms[25] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE);
		// 26: |CollectionPatternCS::restVariableName|
		serializationMatchTerms[26] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME);
		// 27: |CollectionTypeCS::name|
		serializationMatchTerms[27] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME);
		// 28: |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchTerms[28] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY);
		// 29: |CollectionTypeCS::ownedType|
		serializationMatchTerms[29] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE);
		// 30: |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchTerms[30] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS);
		// 31: |ContextCS::ownedExpression|
		serializationMatchTerms[31] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION);
		// 32: |CurlyBracketedClauseCS::ownedParts|
		serializationMatchTerms[32] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS);
		// 33: |CurlyBracketedClauseCS::value|
		serializationMatchTerms[33] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__VALUE);
		// 34: |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchTerms[34] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 21 /* 'primitive' */);
		// 35: |DataTypeCS::isSerializable.'serializable'|
		serializationMatchTerms[35] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 22 /* 'serializable' */);
		// 36: |DataTypeCS::isSerializable|
		serializationMatchTerms[36] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE);
		// 37: |DirectionCS::imports|
		serializationMatchTerms[37] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.DIRECTION_CS__IMPORTS);
		// 38: |DirectionCS::uses|
		serializationMatchTerms[38] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.DIRECTION_CS__USES);
		// 39: |DomainCS::direction|
		serializationMatchTerms[39] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.DOMAIN_CS__DIRECTION);
		// 40: |DomainCS::isCheck.'check'|
		serializationMatchTerms[40] = createSerializationMatchTermEAttributeSize(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_CHECK, 13 /* 'check' */);
		// 41: |DomainCS::isCheck|
		serializationMatchTerms[41] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_CHECK);
		// 42: |DomainCS::isEnforce.'enforce'|
		serializationMatchTerms[42] = createSerializationMatchTermEAttributeSize(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_ENFORCE, 16 /* 'enforce' */);
		// 43: |DomainCS::isEnforce|
		serializationMatchTerms[43] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_ENFORCE);
		// 44: |EnumerationCS::isSerializable.'serializable'|
		serializationMatchTerms[44] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 22 /* 'serializable' */);
		// 45: |EnumerationCS::isSerializable|
		serializationMatchTerms[45] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE);
		// 46: |EnumerationCS::ownedLiterals|
		serializationMatchTerms[46] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS);
		// 47: |EnumerationLiteralCS::literal|
		serializationMatchTerms[47] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__LITERAL);
		// 48: |EnumerationLiteralCS::value|
		serializationMatchTerms[48] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		// 49: |ExpSpecificationCS::ownedExpression|
		serializationMatchTerms[49] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION);
		// 50: |GuardPatternCS::ownedPredicates|
		serializationMatchTerms[50] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES);
		// 51: |IfExpCS::isImplicit|
		serializationMatchTerms[51] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__IS_IMPLICIT);
		// 52: |IfExpCS::ownedCondition|
		serializationMatchTerms[52] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION);
		// 53: |IfExpCS::ownedElseExpression|
		serializationMatchTerms[53] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION);
		// 54: |IfExpCS::ownedIfThenExpressions|
		serializationMatchTerms[54] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS);
		// 55: |IfExpCS::ownedThenExpression|
		serializationMatchTerms[55] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION);
		// 56: |IfThenExpCS::ownedCondition|
		serializationMatchTerms[56] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION);
		// 57: |IfThenExpCS::ownedThenExpression|
		serializationMatchTerms[57] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION);
		// 58: |ImportCS::isAll.'::'|
		serializationMatchTerms[58] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, 7 /* '::' */);
		// 59: |ImportCS::ownedPathName|
		serializationMatchTerms[59] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME);
		// 60: |InfixExpCS::ownedLeft|
		serializationMatchTerms[60] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT);
		// 61: |JavaImplementationCS::implementation|
		serializationMatchTerms[61] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION);
		// 62: |LambdaLiteralExpCS::ownedExpressionCS|
		serializationMatchTerms[62] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS);
		// 63: |LetExpCS::isImplicit|
		serializationMatchTerms[63] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__IS_IMPLICIT);
		// 64: |LetExpCS::ownedInExpression|
		serializationMatchTerms[64] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION);
		// 65: |LetExpCS::ownedVariables|
		serializationMatchTerms[65] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES);
		// 66: |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchTerms[66] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		// 67: |MapLiteralExpCS::ownedParts|
		serializationMatchTerms[67] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS);
		// 68: |MapLiteralExpCS::ownedType|
		serializationMatchTerms[68] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE);
		// 69: |MapLiteralPartCS::ownedKey|
		serializationMatchTerms[69] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY);
		// 70: |MapLiteralPartCS::ownedValue|
		serializationMatchTerms[70] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE);
		// 71: |MapTypeCS::name.'Map'|
		serializationMatchTerms[71] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 10 /* 'Map' */);
		// 72: |MapTypeCS::ownedKeyType|
		serializationMatchTerms[72] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE);
		// 73: |MapTypeCS::ownedValueType|
		serializationMatchTerms[73] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE);
		// 74: |MappingCS::isAbstract.'abstract'|
		serializationMatchTerms[74] = createSerializationMatchTermEAttributeSize(QVTcoreCSPackage.Literals.MAPPING_CS__IS_ABSTRACT, 12 /* 'abstract' */);
		// 75: |MappingCS::ownedComposedMappings|
		serializationMatchTerms[75] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_COMPOSED_MAPPINGS);
		// 76: |MappingCS::ownedDomains|
		serializationMatchTerms[76] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_DOMAINS);
		// 77: |MappingCS::ownedInPathName|
		serializationMatchTerms[77] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME);
		// 78: |MappingCS::ownedMiddle|
		serializationMatchTerms[78] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE);
		// 79: |MappingCS::refines|
		serializationMatchTerms[79] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.MAPPING_CS__REFINES);
		// 80: |ModelElementCS::ownedAnnotations|
		serializationMatchTerms[80] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS);
		// 81: |MultiplicityBoundsCS::lowerBound|
		serializationMatchTerms[81] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND);
		// 82: |MultiplicityBoundsCS::upperBound|
		serializationMatchTerms[82] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND);
		// 83: |MultiplicityCS::isNullFree.'|1'|
		serializationMatchTerms[83] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 27 /* '|1' */);
		// 84: |MultiplicityCS::isNullFree|
		serializationMatchTerms[84] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE);
		// 85: |MultiplicityStringCS::stringBounds.'*|+|?'|
		serializationMatchTerms[85] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 4 /* '*|+|?' */);
		// 86: |NamedElementCS::name|
		serializationMatchTerms[86] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME);
		// 87: |NavigatingArgCS::ownedCoIterator|
		serializationMatchTerms[87] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR);
		// 88: |NavigatingArgCS::ownedInitExpression|
		serializationMatchTerms[88] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION);
		// 89: |NavigatingArgCS::ownedNameExpression|
		serializationMatchTerms[89] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION);
		// 90: |NavigatingArgCS::ownedType|
		serializationMatchTerms[90] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE);
		// 91: |NavigatingArgCS::prefix.','|
		serializationMatchTerms[91] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ',' */);
		// 92: |NavigatingArgCS::prefix.';'|
		serializationMatchTerms[92] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 8 /* ';' */);
		// 93: |NavigatingArgCS::prefix.'|'|
		serializationMatchTerms[93] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 26 /* '|' */);
		// 94: |NavigatingArgCS::prefix|
		serializationMatchTerms[94] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX);
		// 95: |NestedExpCS::ownedExpression|
		serializationMatchTerms[95] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION);
		// 96: |NumberLiteralExpCS::symbol|
		serializationMatchTerms[96] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL);
		// 97: |OperationCS::ownedBodyExpressions|
		serializationMatchTerms[97] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS);
		// 98: |OperationCS::ownedExceptions|
		serializationMatchTerms[98] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS);
		// 99: |OperationCS::ownedParameters|
		serializationMatchTerms[99] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS);
		// 100: |OperationCS::ownedPostconditions|
		serializationMatchTerms[100] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_POSTCONDITIONS);
		// 101: |OperationCS::ownedPreconditions|
		serializationMatchTerms[101] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PRECONDITIONS);
		// 102: |OperatorExpCS::ownedRight|
		serializationMatchTerms[102] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT);
		// 103: |PackageCS::nsPrefix|
		serializationMatchTerms[103] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX);
		// 104: |PackageCS::nsURI|
		serializationMatchTerms[104] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__NS_URI);
		// 105: |PackageCS::ownedClasses|
		serializationMatchTerms[105] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES);
		// 106: |PackageOwnerCS::ownedPackages|
		serializationMatchTerms[106] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES);
		// 107: |PathElementCS::referredElement|
		serializationMatchTerms[107] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT);
		// 108: |PathNameCS::ownedPathElements|
		serializationMatchTerms[108] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS);
		// 109: |PatternCS::ownedUnrealizedVariables|
		serializationMatchTerms[109] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES);
		// 110: |PatternExpCS::ownedPatternType|
		serializationMatchTerms[110] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE);
		// 111: |PatternExpCS::patternVariableName|
		serializationMatchTerms[111] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME);
		// 112: |PredicateCS::ownedCondition|
		serializationMatchTerms[112] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION);
		// 113: |PredicateOrAssignmentCS::isDefault.'default'|
		serializationMatchTerms[113] = createSerializationMatchTermEAttributeSize(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT, 14 /* 'default' */);
		// 114: |PredicateOrAssignmentCS::isPartial.'+='|
		serializationMatchTerms[114] = createSerializationMatchTermEAttributeSize(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL, 5 /* '+=' */);
		// 115: |PredicateOrAssignmentCS::isPartial|
		serializationMatchTerms[115] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL);
		// 116: |PredicateOrAssignmentCS::ownedInitExpression|
		serializationMatchTerms[116] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION);
		// 117: |PredicateOrAssignmentCS::ownedTarget|
		serializationMatchTerms[117] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET);
		// 118: |PrimitiveTypeRefCS::name|
		serializationMatchTerms[118] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME);
		// 119: |QualifiedPackageCS::ownedPathName|
		serializationMatchTerms[119] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME);
		// 120: |QueryCS::isTransient.'transient'|
		serializationMatchTerms[120] = createSerializationMatchTermEAttributeSize(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, 24 /* 'transient' */);
		// 121: |QueryCS::ownedExpression|
		serializationMatchTerms[121] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION);
		// 122: |QueryCS::ownedParameters|
		serializationMatchTerms[122] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS);
		// 123: |QueryCS::ownedPathName|
		serializationMatchTerms[123] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME);
		// 124: |ReferenceCS::ownedImplicitOpposites|
		serializationMatchTerms[124] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__OWNED_IMPLICIT_OPPOSITES);
		// 125: |ReferenceCS::referredKeys|
		serializationMatchTerms[125] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_KEYS);
		// 126: |ReferenceCS::referredOpposite|
		serializationMatchTerms[126] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE);
		// 127: |RootCS::ownedImports|
		serializationMatchTerms[127] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS);
		// 128: |SelfExpCS::name|
		serializationMatchTerms[128] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SELF_EXP_CS__NAME);
		// 129: |ShadowPartCS::ownedInitExpression|
		serializationMatchTerms[129] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION);
		// 130: |ShadowPartCS::referredProperty|
		serializationMatchTerms[130] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY);
		// 131: |SimpleTargetElementCS::input.'input'|
		serializationMatchTerms[131] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 18 /* 'input' */);
		// 132: |SimpleTargetElementCS::input|
		serializationMatchTerms[132] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT);
		// 133: |SimpleTargetElementCS::iterates|
		serializationMatchTerms[133] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES);
		// 134: |SimpleTargetElementCS::output.'output'|
		serializationMatchTerms[134] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 20 /* 'output' */);
		// 135: |SimpleTargetElementCS::output|
		serializationMatchTerms[135] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT);
		// 136: |SimpleTargetElementCS::typedModel|
		serializationMatchTerms[136] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL);
		// 137: |SimpleTargetElementCS::via.'via'|
		serializationMatchTerms[137] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 25 /* 'via' */);
		// 138: |SimpleTargetElementCS::via|
		serializationMatchTerms[138] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA);
		// 139: |SpecificationCS::exprString|
		serializationMatchTerms[139] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING);
		// 140: |SquareBracketedClauseCS::ownedTerms|
		serializationMatchTerms[140] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS);
		// 141: |StringLiteralExpCS::segments|
		serializationMatchTerms[141] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS);
		// 142: |StructuralFeatureCS::default|
		serializationMatchTerms[142] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT);
		// 143: |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchTerms[143] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS);
		// 144: |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchTerms[144] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 12 /* 'abstract' */);
		// 145: |StructuredClassCS::isInterface.'interface'|
		serializationMatchTerms[145] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 19 /* 'interface' */);
		// 146: |StructuredClassCS::ownedMetaclass|
		serializationMatchTerms[146] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_METACLASS);
		// 147: |StructuredClassCS::ownedOperations|
		serializationMatchTerms[147] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS);
		// 148: |StructuredClassCS::ownedProperties|
		serializationMatchTerms[148] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES);
		// 149: |StructuredClassCS::ownedSuperTypes|
		serializationMatchTerms[149] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES);
		// 150: |TargetCS::ownedTargetElements|
		serializationMatchTerms[150] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS);
		// 151: |TemplateBindingCS::ownedMultiplicity|
		serializationMatchTerms[151] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY);
		// 152: |TemplateBindingCS::ownedSubstitutions|
		serializationMatchTerms[152] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS);
		// 153: |TemplateParameterSubstitutionCS::ownedActualParameter|
		serializationMatchTerms[153] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER);
		// 154: |TemplateSignatureCS::ownedParameters|
		serializationMatchTerms[154] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS);
		// 155: |TemplateableElementCS::ownedSignature|
		serializationMatchTerms[155] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE);
		// 156: |TopLevelCS::ownedMappings|
		serializationMatchTerms[156] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS);
		// 157: |TopLevelCS::ownedQueries|
		serializationMatchTerms[157] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES);
		// 158: |TopLevelCS::ownedTransformations|
		serializationMatchTerms[158] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);
		// 159: |TransformationCS::ownedDirections|
		serializationMatchTerms[159] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS);
		// 160: |TransformationCS::ownedProperties|
		serializationMatchTerms[160] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES);
		// 161: |TupleLiteralExpCS::ownedParts|
		serializationMatchTerms[161] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS);
		// 162: |TupleTypeCS::name.'Tuple'|
		serializationMatchTerms[162] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 11 /* 'Tuple' */);
		// 163: |TupleTypeCS::ownedParts|
		serializationMatchTerms[163] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS);
		// 164: |TypeLiteralExpCS::ownedPathName|
		serializationMatchTerms[164] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_PATH_NAME);
		// 165: |TypeLiteralExpCS::ownedType|
		serializationMatchTerms[165] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE);
		// 166: |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchTerms[166] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		// 167: |TypeNameExpCS::ownedPathName|
		serializationMatchTerms[167] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME);
		// 168: |TypeNameExpCS::ownedPatternGuard|
		serializationMatchTerms[168] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD);
		// 169: |TypeParameterCS::ownedExtends|
		serializationMatchTerms[169] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS);
		// 170: |TypedElementCS::isOptional|
		serializationMatchTerms[170] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__IS_OPTIONAL);
		// 171: |TypedElementCS::ownedType|
		serializationMatchTerms[171] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE);
		// 172: |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchTerms[172] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */);
		// 173: |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchTerms[173] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */);
		// 174: |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchTerms[174] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */);
		// 175: |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchTerms[175] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */);
		// 176: |TypedElementCS::qualifiers.'definition'|
		serializationMatchTerms[176] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 15 /* 'definition' */);
		// 177: |TypedElementCS::qualifiers.'static'|
		serializationMatchTerms[177] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 23 /* 'static' */);
		// 178: |TypedElementCS::qualifiers|
		serializationMatchTerms[178] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS);
		// 179: |TypedRefCS::ownedMultiplicity|
		serializationMatchTerms[179] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY);
		// 180: |TypedTypeRefCS::isTypeof|
		serializationMatchTerms[180] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__IS_TYPEOF);
		// 181: |TypedTypeRefCS::ownedBinding|
		serializationMatchTerms[181] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING);
		// 182: |TypedTypeRefCS::ownedPathName|
		serializationMatchTerms[182] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME);
		// 183: |UnrealizedVariableCS::ownedInitExpression|
		serializationMatchTerms[183] = createSerializationMatchTermEStructuralFeatureSize(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION);
		// 184: |VariableCS::ownedInitExpression|
		serializationMatchTerms[184] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION);
		// 185: |VariableCS::ownedType|
		serializationMatchTerms[185] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE);
		// 186: |WildcardTypeRefCS::ownedExtends|
		serializationMatchTerms[186] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS);
		// 187: |WildcardTypeRefCS::ownedSuper|
		serializationMatchTerms[187] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_SUPER);
		// 188: (|AbstractNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[188] = createSerializationMatchTermSubtract(6, 1);
		// 189: (|AreaCS::ownedBottomPattern| - 1)
		serializationMatchTerms[189] = createSerializationMatchTermSubtract(11, 1);
		// 190: (|AreaCS::ownedGuardPattern| - 1)
		serializationMatchTerms[190] = createSerializationMatchTermSubtract(12, 1);
		// 191: (|BooleanLiteralExpCS::symbol.'false|true'| - 1)
		serializationMatchTerms[191] = createSerializationMatchTermSubtract(13, 1);
		// 192: (|BottomPatternCS::ownedRealizedVariables| - 1)
		serializationMatchTerms[192] = createSerializationMatchTermSubtract(16, 1);
		// 193: (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[193] = createSerializationMatchTermSubtract(19, 1);
		// 194: (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[194] = createSerializationMatchTermGreaterThan(19, 0);
		// 195: (|CollectionLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[195] = createSerializationMatchTermSubtract(20, 1);
		// 196: (|CollectionLiteralPartCS::ownedExpression| - 1)
		serializationMatchTerms[196] = createSerializationMatchTermSubtract(21, 1);
		// 197: (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchTerms[197] = createSerializationMatchTermSubtract(23, 1);
		// 198: (|CollectionPatternCS::ownedType| - 1)
		serializationMatchTerms[198] = createSerializationMatchTermSubtract(25, 1);
		// 199: (|CollectionTypeCS::name| - 1)
		serializationMatchTerms[199] = createSerializationMatchTermSubtract(27, 1);
		// 200: (|ContextCS::ownedExpression| - 1)
		serializationMatchTerms[200] = createSerializationMatchTermSubtract(31, 1);
		// 201: (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchTerms[201] = createSerializationMatchTermSubtract(32, 1);
		// 202: (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchTerms[202] = createSerializationMatchTermGreaterThan(32, 0);
		// 203: (|DirectionCS::imports| - 1)
		serializationMatchTerms[203] = createSerializationMatchTermSubtract(37, 1);
		// 204: (|DirectionCS::uses| - 1)
		serializationMatchTerms[204] = createSerializationMatchTermSubtract(38, 1);
		// 205: (|DirectionCS::uses| > 0)
		serializationMatchTerms[205] = createSerializationMatchTermGreaterThan(38, 0);
		// 206: (|DomainCS::direction| - 1)
		serializationMatchTerms[206] = createSerializationMatchTermSubtract(39, 1);
		// 207: (|ExpSpecificationCS::ownedExpression| - 1)
		serializationMatchTerms[207] = createSerializationMatchTermSubtract(49, 1);
		// 208: (|IfExpCS::ownedCondition| - 1)
		serializationMatchTerms[208] = createSerializationMatchTermSubtract(52, 1);
		// 209: (|IfExpCS::ownedElseExpression| - 1)
		serializationMatchTerms[209] = createSerializationMatchTermSubtract(53, 1);
		// 210: (|IfExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[210] = createSerializationMatchTermSubtract(55, 1);
		// 211: (|IfThenExpCS::ownedCondition| - 1)
		serializationMatchTerms[211] = createSerializationMatchTermSubtract(56, 1);
		// 212: (|IfThenExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[212] = createSerializationMatchTermSubtract(57, 1);
		// 213: (|ImportCS::ownedPathName| - 1)
		serializationMatchTerms[213] = createSerializationMatchTermSubtract(59, 1);
		// 214: (|InfixExpCS::ownedLeft| - 1)
		serializationMatchTerms[214] = createSerializationMatchTermSubtract(60, 1);
		// 215: (|JavaImplementationCS::implementation| - 1)
		serializationMatchTerms[215] = createSerializationMatchTermSubtract(61, 1);
		// 216: (|LambdaLiteralExpCS::ownedExpressionCS| - 1)
		serializationMatchTerms[216] = createSerializationMatchTermSubtract(62, 1);
		// 217: (|LetExpCS::ownedInExpression| - 1)
		serializationMatchTerms[217] = createSerializationMatchTermSubtract(64, 1);
		// 218: (|LetExpCS::ownedVariables| - 1)
		serializationMatchTerms[218] = createSerializationMatchTermSubtract(65, 1);
		// 219: (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[219] = createSerializationMatchTermSubtract(67, 1);
		// 220: (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[220] = createSerializationMatchTermGreaterThan(67, 0);
		// 221: (|MapLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[221] = createSerializationMatchTermSubtract(68, 1);
		// 222: (|MapLiteralPartCS::ownedKey| - 1)
		serializationMatchTerms[222] = createSerializationMatchTermSubtract(69, 1);
		// 223: (|MapLiteralPartCS::ownedValue| - 1)
		serializationMatchTerms[223] = createSerializationMatchTermSubtract(70, 1);
		// 224: (|MapTypeCS::name.'Map'| - 1)
		serializationMatchTerms[224] = createSerializationMatchTermSubtract(71, 1);
		// 225: (|MapTypeCS::ownedKeyType| - V0)
		serializationMatchTerms[225] = createSerializationMatchTermSubtract(72, 2);
		// 226: (|MappingCS::refines| - 1)
		serializationMatchTerms[226] = createSerializationMatchTermSubtract(79, 1);
		// 227: (|MappingCS::refines| > 0)
		serializationMatchTerms[227] = createSerializationMatchTermGreaterThan(79, 0);
		// 228: (|MultiplicityBoundsCS::lowerBound| - 1)
		serializationMatchTerms[228] = createSerializationMatchTermSubtract(81, 1);
		// 229: (|MultiplicityCS::isNullFree.'|1'| - 1)
		serializationMatchTerms[229] = createSerializationMatchTermSubtract(83, 1);
		// 230: (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1)
		serializationMatchTerms[230] = createSerializationMatchTermSubtract(85, 1);
		// 231: (|NamedElementCS::name| - 1)
		serializationMatchTerms[231] = createSerializationMatchTermSubtract(86, 1);
		// 232: (|NavigatingArgCS::ownedCoIterator| - 1)
		serializationMatchTerms[232] = createSerializationMatchTermSubtract(87, 1);
		// 233: (|NavigatingArgCS::ownedInitExpression| - 1)
		serializationMatchTerms[233] = createSerializationMatchTermSubtract(88, 1);
		// 234: (|NavigatingArgCS::ownedNameExpression| - 1)
		serializationMatchTerms[234] = createSerializationMatchTermSubtract(89, 1);
		// 235: (|NavigatingArgCS::ownedType| - 1)
		serializationMatchTerms[235] = createSerializationMatchTermSubtract(90, 1);
		// 236: (|NavigatingArgCS::prefix.','| - 1)
		serializationMatchTerms[236] = createSerializationMatchTermSubtract(91, 1);
		// 237: (|NavigatingArgCS::prefix.';'| - 1)
		serializationMatchTerms[237] = createSerializationMatchTermSubtract(92, 1);
		// 238: (|NavigatingArgCS::prefix.'|'| - 1)
		serializationMatchTerms[238] = createSerializationMatchTermSubtract(93, 1);
		// 239: (|NestedExpCS::ownedExpression| - 1)
		serializationMatchTerms[239] = createSerializationMatchTermSubtract(95, 1);
		// 240: (|NumberLiteralExpCS::symbol| - 1)
		serializationMatchTerms[240] = createSerializationMatchTermSubtract(96, 1);
		// 241: (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchTerms[241] = createSerializationMatchTermGreaterThan(97, 0);
		// 242: (|OperationCS::ownedExceptions| - 1)
		serializationMatchTerms[242] = createSerializationMatchTermSubtract(98, 1);
		// 243: (|OperationCS::ownedExceptions| > 0)
		serializationMatchTerms[243] = createSerializationMatchTermGreaterThan(98, 0);
		// 244: (|OperationCS::ownedParameters| - 1)
		serializationMatchTerms[244] = createSerializationMatchTermSubtract(99, 1);
		// 245: (|OperationCS::ownedParameters| > 0)
		serializationMatchTerms[245] = createSerializationMatchTermGreaterThan(99, 0);
		// 246: (|OperatorExpCS::ownedRight| - 1)
		serializationMatchTerms[246] = createSerializationMatchTermSubtract(102, 1);
		// 247: (|PathElementCS::referredElement| - 1)
		serializationMatchTerms[247] = createSerializationMatchTermSubtract(107, 1);
		// 248: (|PathNameCS::ownedPathElements| - 1)
		serializationMatchTerms[248] = createSerializationMatchTermSubtract(108, 1);
		// 249: (|PatternCS::ownedUnrealizedVariables| - 1)
		serializationMatchTerms[249] = createSerializationMatchTermSubtract(109, 1);
		// 250: (|PatternExpCS::ownedPatternType| - 1)
		serializationMatchTerms[250] = createSerializationMatchTermSubtract(110, 1);
		// 251: (|PredicateCS::ownedCondition| - 1)
		serializationMatchTerms[251] = createSerializationMatchTermSubtract(112, 1);
		// 252: (|PredicateOrAssignmentCS::isPartial.'+='| - V1)
		serializationMatchTerms[252] = createSerializationMatchTermSubtract(114, 3);
		// 253: (|PredicateOrAssignmentCS::ownedTarget| - 1)
		serializationMatchTerms[253] = createSerializationMatchTermSubtract(117, 1);
		// 254: (|PrimitiveTypeRefCS::name| - 1)
		serializationMatchTerms[254] = createSerializationMatchTermSubtract(118, 1);
		// 255: (|QueryCS::ownedExpression| - 1)
		serializationMatchTerms[255] = createSerializationMatchTermSubtract(121, 1);
		// 256: (|QueryCS::ownedParameters| - 1)
		serializationMatchTerms[256] = createSerializationMatchTermSubtract(122, 1);
		// 257: (|QueryCS::ownedParameters| > 0)
		serializationMatchTerms[257] = createSerializationMatchTermGreaterThan(122, 0);
		// 258: (|QueryCS::ownedPathName| - 1)
		serializationMatchTerms[258] = createSerializationMatchTermSubtract(123, 1);
		// 259: (|ShadowPartCS::ownedInitExpression| - 1)
		serializationMatchTerms[259] = createSerializationMatchTermSubtract(129, 1);
		// 260: (|ShadowPartCS::referredProperty| - 1)
		serializationMatchTerms[260] = createSerializationMatchTermSubtract(130, 1);
		// 261: (|SimpleTargetElementCS::input.'input'| - 1)
		serializationMatchTerms[261] = createSerializationMatchTermSubtract(131, 1);
		// 262: (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchTerms[262] = createSerializationMatchTermSubtract(133, 1);
		// 263: (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchTerms[263] = createSerializationMatchTermGreaterThan(133, 0);
		// 264: (|SimpleTargetElementCS::output.'output'| - 1)
		serializationMatchTerms[264] = createSerializationMatchTermSubtract(134, 1);
		// 265: (|SimpleTargetElementCS::typedModel| - 1)
		serializationMatchTerms[265] = createSerializationMatchTermSubtract(136, 1);
		// 266: (|SimpleTargetElementCS::via.'via'| - 1)
		serializationMatchTerms[266] = createSerializationMatchTermSubtract(137, 1);
		// 267: (|SpecificationCS::exprString| - 1)
		serializationMatchTerms[267] = createSerializationMatchTermSubtract(139, 1);
		// 268: (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchTerms[268] = createSerializationMatchTermSubtract(140, 1);
		// 269: (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchTerms[269] = createSerializationMatchTermGreaterThan(143, 0);
		// 270: (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchTerms[270] = createSerializationMatchTermGreaterThan(145, 0);
		// 271: (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchTerms[271] = createSerializationMatchTermSubtract(149, 1);
		// 272: (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchTerms[272] = createSerializationMatchTermGreaterThan(149, 0);
		// 273: (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchTerms[273] = createSerializationMatchTermSubtract(152, 1);
		// 274: (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1)
		serializationMatchTerms[274] = createSerializationMatchTermSubtract(153, 1);
		// 275: (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchTerms[275] = createSerializationMatchTermSubtract(154, 1);
		// 276: (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[276] = createSerializationMatchTermSubtract(161, 1);
		// 277: (|TupleTypeCS::name.'Tuple'| - 1)
		serializationMatchTerms[277] = createSerializationMatchTermSubtract(162, 1);
		// 278: (|TupleTypeCS::ownedParts| - 1)
		serializationMatchTerms[278] = createSerializationMatchTermSubtract(163, 1);
		// 279: (|TupleTypeCS::ownedParts| > 0)
		serializationMatchTerms[279] = createSerializationMatchTermGreaterThan(163, 0);
		// 280: (|TypeLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[280] = createSerializationMatchTermSubtract(165, 1);
		// 281: (|TypeNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[281] = createSerializationMatchTermSubtract(167, 1);
		// 282: (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchTerms[282] = createSerializationMatchTermSubtract(169, 1);
		// 283: (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchTerms[283] = createSerializationMatchTermGreaterThan(169, 0);
		// 284: (|TypedElementCS::ownedType| - 1)
		serializationMatchTerms[284] = createSerializationMatchTermSubtract(171, 1);
		// 285: (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[285] = createSerializationMatchTermGreaterThan(172, 0);
		// 286: (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[286] = createSerializationMatchTermGreaterThan(173, 0);
		// 287: (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchTerms[287] = createSerializationMatchTermGreaterThan(174, 0);
		// 288: (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchTerms[288] = createSerializationMatchTermGreaterThan(175, 0);
		// 289: (|TypedElementCS::qualifiers.'definition'| - 1)
		serializationMatchTerms[289] = createSerializationMatchTermSubtract(176, 1);
		// 290: (|TypedElementCS::qualifiers.'static'| - 1)
		serializationMatchTerms[290] = createSerializationMatchTermSubtract(177, 1);
		// 291: (|TypedTypeRefCS::ownedPathName| - 1)
		serializationMatchTerms[291] = createSerializationMatchTermSubtract(182, 1);
		// 292: (|VariableCS::ownedInitExpression| - 1)
		serializationMatchTerms[292] = createSerializationMatchTermSubtract(184, 1);
	}

	/**
	 * Initialize the various serialization rules that serialize an EClass.
	 */
	private void initSerializationRules0() {
		// Base::FirstPathElementCS-0(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[0] = createSerializationRule("FirstPathElementCS-0", 30,
			createSerializationMatchSteps(
				41		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				298		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::MultiplicityBoundsCS-0(basecs::MultiplicityBoundsCS): { lowerBound=LOWER { ".." upperBound=UPPER }[?] }
		serializationRules[1] = createSerializationRule("MultiplicityBoundsCS-0", 52,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				154		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				155		/* '..' || no-space value no-space */,
				142		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-0(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "|?" "]" }
		serializationRules[2] = createSerializationRule("MultiplicityCS-0", 53,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				154		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				165		/* '[' || no-space value no-space */,
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				155		/* '..' || no-space value no-space */,
				142		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				205		/* '|?' || no-space value no-space */,
				166		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-1(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } isNullFree?="|1" "]" }
		serializationRules[3] = createSerializationRule("MultiplicityCS-1", 53,
			createSerializationMatchSteps(
				28		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				154		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				165		/* '[' || no-space value no-space */,
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				155		/* '..' || no-space value no-space */,
				142		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				14		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				166		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(27/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-2(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "]" }
		serializationRules[4] = createSerializationRule("MultiplicityCS-2", 53,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				154		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				165		/* '[' || no-space value no-space */,
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				155		/* '..' || no-space value no-space */,
				142		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				166		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-3(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "|?" "]" }
		serializationRules[5] = createSerializationRule("MultiplicityCS-3", 53,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				29		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				165		/* '[' || no-space value no-space */,
				138		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				205		/* '|?' || no-space value no-space */,
				166		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-4(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} isNullFree?="|1" "]" }
		serializationRules[6] = createSerializationRule("MultiplicityCS-4", 53,
			createSerializationMatchSteps(
				28		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				29		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				165		/* '[' || no-space value no-space */,
				138		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				14		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				166		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(27/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-5(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "]" }
		serializationRules[7] = createSerializationRule("MultiplicityCS-5", 53,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				29		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				165		/* '[' || no-space value no-space */,
				138		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				166		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityStringCS-0(basecs::MultiplicityStringCS): stringBounds={'*|+|?'}
		serializationRules[8] = createSerializationRule("MultiplicityStringCS-0", 54,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				29		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				138		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::NextPathElementCS-0(basecs::PathElementCS): referredElement=UnreservedName
		serializationRules[9] = createSerializationRule("NextPathElementCS-0", 65,
			createSerializationMatchSteps(
				41		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				297		/* PathElementCS::referredElement=UnreservedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::PathNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[10] = createSerializationRule("PathNameCS-0", 71,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				281		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				211		/* V00*2-steps || value */,
				157		/* '::' || no-space value no-space */,
				282		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 22/* FirstPathElementCS,NextPathElementCS */,
					(30/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(65/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TemplateBindingCS-0(basecs::TemplateBindingCS): { ownedSubstitutions+=TemplateParameterSubstitutionCS { "," ownedSubstitutions+=TemplateParameterSubstitutionCS }[*] ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[11] = createSerializationRule("TemplateBindingCS-0", 104,
			createSerializationMatchSteps(
				301		/* check-rule basecs::TemplateBindingCS.ownedMultiplicity : MultiplicityCS */,
				302		/* check-rule basecs::TemplateBindingCS.ownedSubstitutions : TemplateParameterSubstitutionCS */,
				205		/* assign V1 = |TemplateBindingCS::ownedMultiplicity| */,
				133		/* assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1) */
			),
			createSerializationSteps(
				109		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				109		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				218		/* V01*1-steps || value */,
				76		/* TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 50/* TemplateParameterSubstitutionCS */,
					(105/*TemplateParameterSubstitutionCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TemplateParameterSubstitutionCS-0(basecs::TemplateParameterSubstitutionCS): ownedActualParameter=TypeRefCS
		serializationRules[12] = createSerializationRule("TemplateParameterSubstitutionCS-0", 105,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				303		/* check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
				58		/* assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0 */
			),
			createSerializationSteps(
				30		/* TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 63/* TypeRefCS */,
					(120/*TypeRefCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::TemplateSignatureCS-0(basecs::TemplateSignatureCS): { "(" ownedParameters+=TypeParameterCS { "," ownedParameters+=TypeParameterCS }[*] ")" }
		serializationRules[13] = createSerializationRule("TemplateSignatureCS-0", 106,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				304		/* check-rule basecs::TemplateSignatureCS.ownedParameters : TypeParameterCS */,
				134		/* assign V0 = (|TemplateSignatureCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				149		/* '(' || no-space value no-space */,
				84		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				84		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 62/* TypeParameterCS */,
					(119/*TypeParameterCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TypeParameterCS-0(basecs::TypeParameterCS): { name=UnrestrictedName { "extends" ownedExtends+=TypedRefCS { "&&" ownedExtends+=TypedRefCS }[*] }[?] }
		serializationRules[14] = createSerializationRule("TypeParameterCS-0", 119,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				307		/* check-rule basecs::TypeParameterCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				137		/* assign V0 = (|TypeParameterCS::ownedExtends| > 0) */,
				188		/* assign V1 = (|TypeParameterCS::ownedExtends| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				176		/* 'extends' || soft-space value soft-space */,
				56		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */,
				221		/* V01*2-steps || value */,
				148		/* '&&' || soft-space value soft-space */,
				56		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TypedTypeRefCS-0(basecs::TypedTypeRefCS): { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] }
		serializationRules[15] = createSerializationRule("TypedTypeRefCS-0", 123,
			createSerializationMatchSteps(
				121		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				311		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				312		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				176		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				65		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				97		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				212		/* V00*3-steps || value */,
				149		/* '(' || no-space value no-space */,
				31		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 49/* TemplateBindingCS */,
					(104/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::WildcardTypeRefCS-0(basecs::WildcardTypeRefCS): { "?" { "extends" ownedExtends=TypedRefCS }[?] }
		serializationRules[16] = createSerializationRule("WildcardTypeRefCS-0", 136,
			createSerializationMatchSteps(
				124		/* assert |WildcardTypeRefCS::ownedSuper| == 0 */,
				313		/* check-rule basecs::WildcardTypeRefCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				178		/* assign V0 = |WildcardTypeRefCS::ownedExtends| */
			),
			createSerializationSteps(
				162		/* '?' || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				176		/* 'extends' || soft-space value soft-space */,
				57		/* WildcardTypeRefCS::ownedExtends=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::BooleanLiteralExpCS-0(essentialoclcs::BooleanLiteralExpCS): symbol={'false|true'}
		serializationRules[17] = createSerializationRule("BooleanLiteralExpCS-0", 3,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				3		/* assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0 */
			),
			createSerializationSteps(
				139		/* BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, false,
					(17/*'false|true'*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CoIteratorVariableCS-0(essentialoclcs::VariableCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] }
		serializationRules[18] = createSerializationRule("CoIteratorVariableCS-0", 6,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				123		/* assert |VariableCS::ownedInitExpression| == 0 */,
				365		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				177		/* assign V0 = |VariableCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				125		/* VariableCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralExpCS-0(essentialoclcs::CollectionLiteralExpCS): { ownedType=CollectionTypeCS "{" { ownedParts+=CollectionLiteralPartCS { "," ownedParts+=CollectionLiteralPartCS }[*] }[?] "}" }
		serializationRules[19] = createSerializationRule("CollectionLiteralExpCS-0", 7,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				318		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : CollectionLiteralPartCS */,
				319		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : CollectionTypeCS */,
				5		/* assert (|CollectionLiteralExpCS::ownedType| - 1) == 0 */,
				126		/* assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0) */,
				179		/* assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				119		/* CollectionLiteralExpCS::ownedType=CollectionTypeCS || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				213		/* V00*4-steps || value */,
				85		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				221		/* V01*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				85		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 2/* CollectionLiteralPartCS */,
					(8/*CollectionLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 3/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-0(essentialoclcs::CollectionLiteralPartCS): { ownedExpression=ExpCS { ".." ownedLastExpression=ExpCS }[?] }
		serializationRules[20] = createSerializationRule("CollectionLiteralPartCS-0", 8,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				320		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				322		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				142		/* assign V0 = |CollectionLiteralPartCS::ownedLastExpression| */,
				6		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				49		/* CollectionLiteralPartCS::ownedExpression=ExpCS || value */,
				210		/* V00*2-steps || value */,
				155		/* '..' || no-space value no-space */,
				71		/* CollectionLiteralPartCS::ownedLastExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-1(essentialoclcs::CollectionLiteralPartCS): ownedExpression=PatternExpCS
		serializationRules[21] = createSerializationRule("CollectionLiteralPartCS-1", 8,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				72		/* assert |CollectionLiteralPartCS::ownedLastExpression| == 0 */,
				321		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : PatternExpCS */,
				6		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				50		/* CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 27/* PatternExpCS */,
					(72/*PatternExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionPatternCS-0(essentialoclcs::CollectionPatternCS): { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" }
		serializationRules[22] = createSerializationRule("CollectionPatternCS-0", 9,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				73		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				323		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				324		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				143		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				180		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				7		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				215		/* V00*6-steps || value */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				221		/* V01*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				153		/* '++' || soft-space value soft-space */,
				136		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 27/* PatternExpCS */,
					(72/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 3/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionTypeCS-0(essentialoclcs::CollectionTypeCS): { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] }
		serializationRules[23] = createSerializationRule("CollectionTypeCS-0", 10,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				325		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				326		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				144		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				193		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				121		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				218		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 58/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CurlyBracketedClauseCS-0(essentialoclcs::CurlyBracketedClauseCS): { "{" { ownedParts+=ShadowPartCS { "," ownedParts+=ShadowPartCS }[*] }[?] "}" }
		serializationRules[24] = createSerializationRule("CurlyBracketedClauseCS-0", 13,
			createSerializationMatchSteps(
				74		/* assert |CurlyBracketedClauseCS::value| == 0 */,
				328		/* check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : ShadowPartCS */,
				127		/* assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0) */,
				181		/* assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				203		/* '{' || soft-space value push soft-new-line */,
				213		/* V00*4-steps || value */,
				87		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				221		/* V01*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				87		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 39/* ShadowPartCS */,
					(94/*ShadowPartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::ElseIfThenExpCS-0(essentialoclcs::IfThenExpCS): { "elseif" ownedCondition=ExpCS "then" ownedThenExpression=ExpCS }
		serializationRules[25] = createSerializationRule("ElseIfThenExpCS-0", 19,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				334		/* check-rule essentialoclcs::IfThenExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				335		/* check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				16		/* assert (|IfThenExpCS::ownedThenExpression| - 1) == 0 */,
				15		/* assert (|IfThenExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				173		/* 'elseif' || soft-space value soft-space */,
				39		/* IfThenExpCS::ownedCondition=ExpCS || value */,
				198		/* 'then' || soft-space value soft-space */,
				117		/* IfThenExpCS::ownedThenExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::ExpCS-18(essentialoclcs::InfixExpCS): { ownedLeft=PrefixedPrimaryExpCS { name=BinaryOperatorName ownedRight=ExpCS } }
		serializationRules[26] = createSerializationRule("ExpCS-18", 29,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				336		/* check-rule essentialoclcs::InfixExpCS.ownedLeft : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				40		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				18		/* assert (|InfixExpCS::ownedLeft| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				72		/* InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value */,
				275		/* NamedElementCS::name=BinaryOperatorName || soft-space value soft-space */,
				283		/* OperatorExpCS::ownedRight=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 33/* PrefixedPrimaryExpCS */,
					(76/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::IfExpCS-0(essentialoclcs::IfExpCS): { "if" ownedCondition=(ExpCS|PatternExpCS) "then" ownedThenExpression=ExpCS ownedIfThenExpressions+=ElseIfThenExpCS[*] "else" ownedElseExpression=ExpCS "endif" }
		serializationRules[27] = createSerializationRule("IfExpCS-0", 36,
			createSerializationMatchSteps(
				84		/* assert |IfExpCS::isImplicit| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				330		/* check-rule essentialoclcs::IfExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				331		/* check-rule essentialoclcs::IfExpCS.ownedElseExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				332		/* check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : ElseIfThenExpCS */,
				333		/* check-rule essentialoclcs::IfExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				13		/* assert (|IfExpCS::ownedElseExpression| - 1) == 0 */,
				150		/* assign V0 = |IfExpCS::ownedIfThenExpressions| */,
				14		/* assert (|IfExpCS::ownedThenExpression| - 1) == 0 */,
				12		/* assert (|IfExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				177		/* 'if' || soft-space value soft-space */,
				38		/* IfExpCS::ownedCondition=ExpCS|PatternExpCS || value */,
				198		/* 'then' || soft-space value soft-space */,
				116		/* IfExpCS::ownedThenExpression=ExpCS || value */,
				208		/* V00*1-steps || value */,
				59		/* IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value */,
				172		/* 'else' || soft-space value soft-space */,
				47		/* IfExpCS::ownedElseExpression=ExpCS || value */,
				174		/* 'endif' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 28/* ExpCS,PatternExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/,
					(72/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 6/* ElseIfThenExpCS */,
					(19/*ElseIfThenExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::InvalidLiteralExpCS-0(essentialoclcs::InvalidLiteralExpCS): "invalid"
		serializationRules[28] = createSerializationRule("InvalidLiteralExpCS-0", 39,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				183		/* 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::LambdaLiteralExpCS-0(essentialoclcs::LambdaLiteralExpCS): { "Lambda" "{" ownedExpressionCS=ExpCS "}" }
		serializationRules[29] = createSerializationRule("LambdaLiteralExpCS-0", 42,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				337		/* check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				20		/* assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				163		/* 'Lambda' || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				55		/* LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::LetExpCS-0(essentialoclcs::LetExpCS): { "let" ownedVariables+=LetVariableCS { "," ownedVariables+=LetVariableCS }[*] "in" ownedInExpression=ExpCS }
		serializationRules[30] = createSerializationRule("LetExpCS-0", 43,
			createSerializationMatchSteps(
				86		/* assert |LetExpCS::isImplicit| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				338		/* check-rule essentialoclcs::LetExpCS.ownedInExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				339		/* check-rule essentialoclcs::LetExpCS.ownedVariables : LetVariableCS */,
				21		/* assert (|LetExpCS::ownedInExpression| - 1) == 0 */,
				128		/* assign V0 = (|LetExpCS::ownedVariables| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				185		/* 'let' || soft-space value soft-space */,
				128		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				128		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				181		/* 'in' || soft-space value soft-space */,
				61		/* LetExpCS::ownedInExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 13/* LetVariableCS */,
					(44/*LetVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::LetVariableCS-0(essentialoclcs::LetVariableCS): { name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS[?] { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[31] = createSerializationRule("LetVariableCS-0", 44,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				364		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				340		/* check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				365		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				66		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				212		/* assign V1 = |VariableCS::ownedType| */,
				151		/* assign V0 = |LetVariableCS::ownedRoundBracketedClause| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				106		/* LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				125		/* VariableCS::ownedType=TypeExpCS || value */,
				161		/* '=' || soft-space value soft-space */,
				68		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 37/* RoundBracketedClauseCS */,
					(87/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::MapLiteralExpCS-0(essentialoclcs::MapLiteralExpCS): { ownedType=MapTypeCS "{" { ownedParts+=MapLiteralPartCS { "," ownedParts+=MapLiteralPartCS }[*] }[?] "}" }
		serializationRules[32] = createSerializationRule("MapLiteralExpCS-0", 47,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				341		/* check-rule essentialoclcs::MapLiteralExpCS.ownedParts : MapLiteralPartCS */,
				342		/* check-rule essentialoclcs::MapLiteralExpCS.ownedType : MapTypeCS */,
				22		/* assert (|MapLiteralExpCS::ownedType| - 1) == 0 */,
				129		/* assign V0 = (|MapLiteralExpCS::ownedParts| > 0) */,
				183		/* assign V1 = (|MapLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				122		/* MapLiteralExpCS::ownedType=MapTypeCS || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				213		/* V00*4-steps || value */,
				88		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				221		/* V01*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				88		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 14/* MapLiteralPartCS */,
					(48/*MapLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 15/* MapTypeCS */,
					(49/*MapTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapLiteralPartCS-0(essentialoclcs::MapLiteralPartCS): { ownedKey=ExpCS "<-" ownedValue=ExpCS }
		serializationRules[33] = createSerializationRule("MapLiteralPartCS-0", 48,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				343		/* check-rule essentialoclcs::MapLiteralPartCS.ownedKey : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				344		/* check-rule essentialoclcs::MapLiteralPartCS.ownedValue : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				24		/* assert (|MapLiteralPartCS::ownedValue| - 1) == 0 */,
				23		/* assert (|MapLiteralPartCS::ownedKey| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				69		/* MapLiteralPartCS::ownedKey=ExpCS || value */,
				160		/* '<-' || soft-space value soft-space */,
				126		/* MapLiteralPartCS::ownedValue=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapTypeCS-0(essentialoclcs::MapTypeCS): { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] }
		serializationRules[34] = createSerializationRule("MapTypeCS-0", 49,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				345		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				346		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				152		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				154		/* ',' || no-space value soft-space */,
				127		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::Model-0(essentialoclcs::ContextCS): ownedExpression=ExpCS
		serializationRules[35] = createSerializationRule("Model-0", 51,
			createSerializationMatchSteps(
				89		/* assert |NamedElementCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				105		/* assert |RootCS::ownedImports| == 0 */,
				327		/* check-rule essentialoclcs::ContextCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				9		/* assert (|ContextCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				51		/* ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NameExpCS-0(essentialoclcs::NameExpCS): { ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS[*] ownedRoundBracketedClause=RoundBracketedClauseCS[?] ownedCurlyBracketedClause=CurlyBracketedClauseCS[?] { isPre?="@" "pre" }[?] }
		serializationRules[36] = createSerializationRule("NameExpCS-0", 56,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				314		/* check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				315		/* check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : PathNameCS */,
				316		/* check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				317		/* check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : SquareBracketedClauseCS */,
				241		/* assign V3 = |AbstractNameExpCS::isPre.'@'| */,
				223		/* assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause| */,
				190		/* assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause| */,
				138		/* assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses| */,
				0		/* assert (|AbstractNameExpCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				91		/* AbstractNameExpCS::ownedPathName=PathNameCS || value */,
				208		/* V00*1-steps || value */,
				108		/* AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value */,
				218		/* V01*1-steps || value */,
				105		/* AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				225		/* V02*1-steps || value */,
				42		/* AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				236		/* V03*2-steps || value */,
				16		/* AbstractNameExpCS::isPre?='@' || soft-space value soft-space */,
				191		/* 'pre' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, false,
					(9/*'@'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 37/* RoundBracketedClauseCS */,
					(87/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 43/* SquareBracketedClauseCS */,
					(98/*SquareBracketedClauseCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-0(essentialoclcs::NavigatingArgCS): { ":" ownedType=TypeExpCS }
		serializationRules[37] = createSerializationRule("NavigatingArgCS-0", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				91		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				92		/* assert |NavigatingArgCS::ownedNameExpression| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				34		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				156		/* ':' || soft-space value soft-space */,
				123		/* NavigatingArgCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-1(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "<-" ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[38] = createSerializationRule("NavigatingArgCS-1", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				347		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				199		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				156		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				34		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				156		/* ':' || soft-space value soft-space */,
				123		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				210		/* V00*2-steps || value */,
				160		/* '<-' || soft-space value soft-space */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				220		/* V01*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/* CoIteratorVariableCS */,
					(6/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-2(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { "<-" ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[39] = createSerializationRule("NavigatingArgCS-2", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				347		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				157		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				31		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				160		/* '<-' || soft-space value soft-space */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				210		/* V00*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/* CoIteratorVariableCS */,
					(6/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-3(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { "<-" ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[40] = createSerializationRule("NavigatingArgCS-3", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				347		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				32		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				198		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				158		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				123		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				220		/* V01*2-steps || value */,
				160		/* '<-' || soft-space value soft-space */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				181		/* 'in' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/* CoIteratorVariableCS */,
					(6/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-4(essentialoclcs::NavigatingArgCS): ownedNameExpression=NavigatingArgExpCS
		serializationRules[41] = createSerializationRule("NavigatingArgCS-4", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				91		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				79		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingBarArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="|" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[42] = createSerializationRule("NavigatingBarArgCS-0", 60,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				158		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				37		/* assert (|NavigatingArgCS::prefix.'|'| - 1) == 0 */,
				199		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				132		/* NavigatingArgCS::prefix='|' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				214		/* V00*5-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				123		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				220		/* V01*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(26/*'|'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "<-" ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[43] = createSerializationRule("NavigatingCommaArgCS-0", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				347		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				199		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				156		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				34		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				131		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				156		/* ':' || soft-space value soft-space */,
				123		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				210		/* V00*2-steps || value */,
				160		/* '<-' || soft-space value soft-space */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				220		/* V01*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/* CoIteratorVariableCS */,
					(6/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-1(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { "<-" ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[44] = createSerializationRule("NavigatingCommaArgCS-1", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				347		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				157		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				31		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				131		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				160		/* '<-' || soft-space value soft-space */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				210		/* V00*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/* CoIteratorVariableCS */,
					(6/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-2(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { "<-" ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[45] = createSerializationRule("NavigatingCommaArgCS-2", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				347		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				32		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				198		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				158		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				131		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				123		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				220		/* V01*2-steps || value */,
				160		/* '<-' || soft-space value soft-space */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				181		/* 'in' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/* CoIteratorVariableCS */,
					(6/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-3(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS }
		serializationRules[46] = createSerializationRule("NavigatingCommaArgCS-3", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				91		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				131		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingSemiArgCS-0(essentialoclcs::NavigatingArgCS): { prefix=";" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[47] = createSerializationRule("NavigatingSemiArgCS-0", 62,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				348		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				158		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				36		/* assert (|NavigatingArgCS::prefix.';'| - 1) == 0 */,
				199		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				130		/* NavigatingArgCS::prefix=';' || no-space value soft-new-line */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				214		/* V00*5-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				123		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				220		/* V01*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				63		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(8/*';'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 19/* NavigatingArgExpCS */,
					(59/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NestedExpCS-0(essentialoclcs::NestedExpCS): { "(" ownedExpression=ExpCS ")" }
		serializationRules[48] = createSerializationRule("NestedExpCS-0", 64,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				351		/* check-rule essentialoclcs::NestedExpCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				38		/* assert (|NestedExpCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				149		/* '(' || no-space value no-space */,
				53		/* NestedExpCS::ownedExpression=ExpCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NullLiteralExpCS-0(essentialoclcs::NullLiteralExpCS): "null"
		serializationRules[49] = createSerializationRule("NullLiteralExpCS-0", 66,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				188		/* 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::NumberLiteralExpCS-0(essentialoclcs::NumberLiteralExpCS): symbol=NUMBER_LITERAL
		serializationRules[50] = createSerializationRule("NumberLiteralExpCS-0", 67,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				39		/* assert (|NumberLiteralExpCS::symbol| - 1) == 0 */
			),
			createSerializationSteps(
				140		/* NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::PatternExpCS-0(essentialoclcs::PatternExpCS): { patternVariableName=UnrestrictedName[?] ":" ownedPatternType=TypeExpCS }
		serializationRules[51] = createSerializationRule("PatternExpCS-0", 72,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				355		/* check-rule essentialoclcs::PatternExpCS.ownedPatternType : TypeExpCS */,
				44		/* assert (|PatternExpCS::ownedPatternType| - 1) == 0 */,
				160		/* assign V0 = |PatternExpCS::patternVariableName| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				129		/* PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				99		/* PatternExpCS::ownedPatternType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedLetExpCS-1(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedLetExpCS }
		serializationRules[52] = createSerializationRule("PrefixedLetExpCS-1", 75,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				354		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : LetExpCS|PrefixedLetExpCS */,
				40		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				272		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				284		/* OperatorExpCS::ownedRight=PrefixedLetExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 31/* PrefixedLetExpCS */,
					(75/*PrefixedLetExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedPrimaryExpCS-15(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS }
		serializationRules[53] = createSerializationRule("PrefixedPrimaryExpCS-15", 76,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				353		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				40		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				272		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				285		/* OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 33/* PrefixedPrimaryExpCS */,
					(76/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrimitiveTypeCS-0(basecs::PrimitiveTypeRefCS): name=PrimitiveTypeIdentifier
		serializationRules[54] = createSerializationRule("PrimitiveTypeCS-0", 79,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				48		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				25		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::RoundBracketedClauseCS-0(essentialoclcs::RoundBracketedClauseCS): { "(" { ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[*] }[?] ")" }
		serializationRules[55] = createSerializationRule("RoundBracketedClauseCS-0", 87,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				149		/* '(' || no-space value no-space */,
				212		/* V00*3-steps || value */,
				278		/* RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value */,
				219		/* V01*1-steps || value */,
				279		/* RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 21/* NavigatingArgCS,NavigatingBarArgCS,NavigatingCommaArgCS,NavigatingSemiArgCS */,
					(58/*NavigatingArgCS*/ << 4) | 1 /*[?]*/,
					(60/*NavigatingBarArgCS*/ << 4) | 2 /*[*]*/,
					(61/*NavigatingCommaArgCS*/ << 4) | 2 /*[*]*/,
					(62/*NavigatingSemiArgCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::SelfExpCS-0(essentialoclcs::SelfExpCS): "self"
		serializationRules[56] = createSerializationRule("SelfExpCS-0", 93,
			createSerializationMatchSteps(
				106		/* assert |SelfExpCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				196		/* 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::ShadowPartCS-0(essentialoclcs::ShadowPartCS): { referredProperty=UnrestrictedName "=" ownedInitExpression=(ExpCS|PatternExpCS) }
		serializationRules[57] = createSerializationRule("ShadowPartCS-0", 94,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				357		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				51		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */,
				52		/* assert (|ShadowPartCS::referredProperty| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				134		/* ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space */,
				161		/* '=' || soft-space value soft-space */,
				65		/* ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 28/* ExpCS,PatternExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/,
					(72/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, -1
				)
			});
		// EssentialOCL::ShadowPartCS-1(essentialoclcs::ShadowPartCS): ownedInitExpression=StringLiteralExpCS
		serializationRules[58] = createSerializationRule("ShadowPartCS-1", 94,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				107		/* assert |ShadowPartCS::referredProperty| == 0 */,
				356		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : StringLiteralExpCS */,
				51		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */
			),
			createSerializationSteps(
				66		/* ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 44/* StringLiteralExpCS */,
					(100/*StringLiteralExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SimplePathNameCS-0(basecs::PathNameCS): ownedPathElements+=FirstPathElementCS
		serializationRules[59] = createSerializationRule("SimplePathNameCS-0", 95,
			createSerializationMatchSteps(
				295		/* check-rule basecs::PathNameCS.ownedPathElements : FirstPathElementCS */,
				42		/* assert (|PathNameCS::ownedPathElements| - 1) == 0 */
			),
			createSerializationSteps(
				281		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 9/* FirstPathElementCS */,
					(30/*FirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SquareBracketedClauseCS-0(essentialoclcs::SquareBracketedClauseCS): { "[" ownedTerms+=ExpCS { "," ownedTerms+=ExpCS }[*] "]" }
		serializationRules[60] = createSerializationRule("SquareBracketedClauseCS-0", 98,
			createSerializationMatchSteps(
				358		/* check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				132		/* assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1) */
			),
			createSerializationSteps(
				165		/* '[' || no-space value no-space */,
				115		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				115		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				166		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::StringLiteralExpCS-0(essentialoclcs::StringLiteralExpCS): segments+=StringLiteral[+]
		serializationRules[61] = createSerializationRule("StringLiteralExpCS-0", 100,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				167		/* assign V0 = |StringLiteralExpCS::segments| */
			),
			createSerializationSteps(
				209		/* V00*1-steps || value */,
				137		/* StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, false, GrammarCardinality.ONE_OR_MORE)
			});
		// EssentialOCL::TupleLiteralExpCS-0(essentialoclcs::TupleLiteralExpCS): { "Tuple" "{" ownedParts+=TupleLiteralPartCS { "," ownedParts+=TupleLiteralPartCS }[*] "}" }
		serializationRules[62] = createSerializationRule("TupleLiteralExpCS-0", 109,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				359		/* check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : TupleLiteralPartCS */,
				135		/* assign V0 = (|TupleLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				164		/* 'Tuple' || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				89		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				89		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 55/* TupleLiteralPartCS */,
					(110/*TupleLiteralPartCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::TupleLiteralPartCS-0(essentialoclcs::TupleLiteralPartCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[63] = createSerializationRule("TupleLiteralPartCS-0", 110,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				364		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				365		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				66		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				177		/* assign V0 = |VariableCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				125		/* VariableCS::ownedType=TypeExpCS || value */,
				161		/* '=' || soft-space value soft-space */,
				68		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
	}
	private void initSerializationRules1() {
		// EssentialOCL::TuplePartCS-0(basecs::TuplePartCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[64] = createSerializationRule("TuplePartCS-0", 111,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TupleTypeCS-0(basecs::TupleTypeCS): { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] }
		serializationRules[65] = createSerializationRule("TupleTypeCS-0", 112,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				306		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				136		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				187		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				220		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				216		/* V00*7-steps || value */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 56/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeExpCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[66] = createSerializationRule("TypeExpCS-0", 113,
			createSerializationMatchSteps(
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				175		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				48		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				25		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[67] = createSerializationRule("TypeExpCS-1", 113,
			createSerializationMatchSteps(
				325		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				326		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				233		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				144		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				193		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				121		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				218		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				150		/* ')' || no-space value */,
				225		/* V02*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 58/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[68] = createSerializationRule("TypeExpCS-2", 113,
			createSerializationMatchSteps(
				345		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				346		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				210		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				152		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				154		/* ',' || no-space value soft-space */,
				127		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				150		/* ')' || no-space value */,
				218		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-3(essentialoclcs::TypeNameExpCS): { { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[69] = createSerializationRule("TypeExpCS-3", 113,
			createSerializationMatchSteps(
				361		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				362		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				363		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				233		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				171		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				61		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				208		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				96		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				214		/* V00*5-steps || value */,
				43		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				222		/* V01*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				98		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */,
				225		/* V02*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-4(essentialoclcs::CollectionPatternCS): { { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[70] = createSerializationRule("TypeExpCS-4", 113,
			createSerializationMatchSteps(
				73		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				323		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				324		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				233		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				143		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				180		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				7		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				120		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				215		/* V00*6-steps || value */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				221		/* V01*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				153		/* '++' || soft-space value soft-space */,
				136		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				225		/* V02*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 27/* PatternExpCS */,
					(72/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 3/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeExpCS-5(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[71] = createSerializationRule("TypeExpCS-5", 113,
			createSerializationMatchSteps(
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				306		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				250		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				136		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				187		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				220		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				216		/* V00*7-steps || value */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				150		/* ')' || no-space value */,
				233		/* V03*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 56/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeLiteralExpCS-0(essentialoclcs::TypeLiteralExpCS): ownedType=TypeLiteralWithMultiplicityCS
		serializationRules[72] = createSerializationRule("TypeLiteralExpCS-0", 116,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				117		/* assert |TypeLiteralExpCS::ownedPathName| == 0 */,
				360		/* check-rule essentialoclcs::TypeLiteralExpCS.ownedType : TypeLiteralWithMultiplicityCS */,
				60		/* assert (|TypeLiteralExpCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				124		/* TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 60/* TypeLiteralWithMultiplicityCS */,
					(117/*TypeLiteralWithMultiplicityCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[73] = createSerializationRule("TypeLiteralWithMultiplicityCS-0", 117,
			createSerializationMatchSteps(
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				175		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				48		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				25		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[74] = createSerializationRule("TypeLiteralWithMultiplicityCS-1", 117,
			createSerializationMatchSteps(
				325		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				326		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				233		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				144		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				193		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				121		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				218		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				150		/* ')' || no-space value */,
				225		/* V02*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 58/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[75] = createSerializationRule("TypeLiteralWithMultiplicityCS-2", 117,
			createSerializationMatchSteps(
				345		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				346		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				210		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				152		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				154		/* ',' || no-space value soft-space */,
				127		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				150		/* ')' || no-space value */,
				218		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-3(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[76] = createSerializationRule("TypeLiteralWithMultiplicityCS-3", 117,
			createSerializationMatchSteps(
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				306		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				250		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				136		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				187		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				220		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				216		/* V00*7-steps || value */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				150		/* ')' || no-space value */,
				233		/* V03*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 56/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeNameExpCS-0(essentialoclcs::TypeNameExpCS): { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] }
		serializationRules[77] = createSerializationRule("TypeNameExpCS-0", 118,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				361		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				362		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				363		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				171		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				61		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				208		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				96		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				214		/* V00*5-steps || value */,
				43		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				222		/* V01*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				98		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::URIFirstPathElementCS-0(basecs::PathElementWithURICS): referredElement=URI
		serializationRules[78] = createSerializationRule("URIFirstPathElementCS-0", 127,
			createSerializationMatchSteps(
				41		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				296		/* PathElementCS::referredElement=URI || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIFirstPathElementCS-1(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[79] = createSerializationRule("URIFirstPathElementCS-1", 127,
			createSerializationMatchSteps(
				41		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				298		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=URIFirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[80] = createSerializationRule("URIPathNameCS-0", 128,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				280		/* PathNameCS::ownedPathElements+=URIFirstPathElementCS || value */,
				211		/* V00*2-steps || value */,
				157		/* '::' || no-space value no-space */,
				282		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 67/* NextPathElementCS,URIFirstPathElementCS */,
					(65/*NextPathElementCS*/ << 4) | 2 /*[*]*/,
					(127/*URIFirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::UnlimitedNaturalLiteralExpCS-0(essentialoclcs::UnlimitedNaturalLiteralExpCS): "*"
		serializationRules[81] = createSerializationRule("UnlimitedNaturalLiteralExpCS-0", 130,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				151		/* '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// QVTbase::AttributeCS-0(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[82] = createSerializationRule("AttributeCS-0", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				229		/* assign V2 = |StructuralFeatureCS::default| */,
				209		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				239		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				260		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				167		/* 'attribute' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				239		/* V03*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				242		/* V04*1-steps || value */,
				291		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-1(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[83] = createSerializationRule("AttributeCS-1", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				297		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				229		/* assign V2 = |StructuralFeatureCS::default| */,
				209		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				239		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				260		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				266		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				269		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				277		/* assign V7 = 0 */,
				282		/* assign V8 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				167		/* 'attribute' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				239		/* V03*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				242		/* V04*1-steps || value */,
				291		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				254		/* V05*5-steps || value */,
				171		/* 'derivation' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				255		/* V06*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				264		/* V07*5-steps || value */,
				182		/* 'initial' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				265		/* V08*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-2(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[84] = createSerializationRule("AttributeCS-2", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				229		/* assign V2 = |StructuralFeatureCS::default| */,
				209		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				173		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				239		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				260		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				167		/* 'attribute' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				239		/* V03*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				242		/* V04*1-steps || value */,
				291		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-3(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[85] = createSerializationRule("AttributeCS-3", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				297		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				229		/* assign V2 = |StructuralFeatureCS::default| */,
				209		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				173		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				239		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				260		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				266		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				269		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				277		/* assign V7 = 0 */,
				282		/* assign V8 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				167		/* 'attribute' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				239		/* V03*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				242		/* V04*1-steps || value */,
				291		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				254		/* V05*5-steps || value */,
				171		/* 'derivation' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				255		/* V06*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				264		/* V07*5-steps || value */,
				182		/* 'initial' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				265		/* V08*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-4(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[86] = createSerializationRule("AttributeCS-4", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				204		/* assign V1 = |StructuralFeatureCS::default| */,
				172		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				221		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				249		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				167		/* 'attribute' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				220		/* V01*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				231		/* V02*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				235		/* V03*1-steps || value */,
				291		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-5(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[87] = createSerializationRule("AttributeCS-5", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				297		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				204		/* assign V1 = |StructuralFeatureCS::default| */,
				172		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				221		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				249		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				256		/* assign V4 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				263		/* assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				271		/* assign V6 = 0 */,
				277		/* assign V7 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				167		/* 'attribute' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				220		/* V01*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				231		/* V02*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				235		/* V03*1-steps || value */,
				291		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				247		/* V04*5-steps || value */,
				171		/* 'derivation' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				248		/* V05*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				259		/* V06*5-steps || value */,
				182		/* 'initial' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				260		/* V07*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::CompoundTargetElementCS-0(qvtbasecs::CompoundTargetElementCS): { "{" ownedTargetElements+=SimpleTargetElementCS[*] "}" }
		serializationRules[88] = createSerializationRule("CompoundTargetElementCS-0", 12,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				368		/* check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : SimpleTargetElementCS */,
				145		/* assign V0 = |CompoundTargetElementCS::ownedTargetElements| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				208		/* V00*1-steps || value */,
				112		/* CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 40/* SimpleTargetElementCS */,
					(96/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::DataTypeCS-0(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[89] = createSerializationRule("DataTypeCS-0", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				225		/* assign V2 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				240		/* assign V3 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				170		/* 'datatype' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				238		/* V03*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				146		/* '!serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-1(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" "}" } }
		serializationRules[90] = createSerializationRule("DataTypeCS-1", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				225		/* assign V2 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				240		/* assign V3 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				170		/* 'datatype' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				238		/* V03*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				146		/* '!serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-2(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[91] = createSerializationRule("DataTypeCS-2", 15,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				242		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				225		/* assign V2 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				170		/* 'datatype' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				238		/* V03*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				18		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(22/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-3(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" "}" } }
		serializationRules[92] = createSerializationRule("DataTypeCS-3", 15,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				242		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				225		/* assign V2 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				170		/* 'datatype' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				238		/* V03*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				18		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(22/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-4(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[93] = createSerializationRule("DataTypeCS-4", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				225		/* assign V2 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				240		/* assign V3 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				170		/* 'datatype' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				236		/* V03*2-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-5(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" "}" } }
		serializationRules[94] = createSerializationRule("DataTypeCS-5", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				225		/* assign V2 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				240		/* assign V3 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				170		/* 'datatype' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				236		/* V03*2-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-0(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[95] = createSerializationRule("EnumerationCS-0", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				80		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				192		/* assign V1 = |ClassCS::instanceClassName| */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				222		/* assign V2 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				175		/* 'enum' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				230		/* V02*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				146		/* '!serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-1(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[96] = createSerializationRule("EnumerationCS-1", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				288		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				243		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				192		/* assign V1 = |ClassCS::instanceClassName| */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				222		/* assign V2 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				175		/* 'enum' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				230		/* V02*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				146		/* '!serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				234		/* V03*1-steps || value */,
				73		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(21/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-2(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[97] = createSerializationRule("EnumerationCS-2", 20,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				80		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				226		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				192		/* assign V1 = |ClassCS::instanceClassName| */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				175		/* 'enum' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				230		/* V02*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				19		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(22/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-3(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[98] = createSerializationRule("EnumerationCS-3", 20,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				288		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				243		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				226		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				192		/* assign V1 = |ClassCS::instanceClassName| */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				175		/* 'enum' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				230		/* V02*3-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				19		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				234		/* V03*1-steps || value */,
				73		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(22/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(21/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-4(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[99] = createSerializationRule("EnumerationCS-4", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				80		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				192		/* assign V1 = |ClassCS::instanceClassName| */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				222		/* assign V2 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				175		/* 'enum' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-5(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[100] = createSerializationRule("EnumerationCS-5", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				288		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				243		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				192		/* assign V1 = |ClassCS::instanceClassName| */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				222		/* assign V2 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				175		/* 'enum' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				234		/* V03*1-steps || value */,
				73		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(21/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationLiteralCS-0(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] ";" }
		serializationRules[101] = createSerializationRule("EnumerationLiteralCS-0", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				148		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				186		/* 'literal' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				144		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-1(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[102] = createSerializationRule("EnumerationLiteralCS-1", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				148		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				186		/* 'literal' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				144		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-2(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] ";" }
		serializationRules[103] = createSerializationRule("EnumerationLiteralCS-2", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				148		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				276		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				144		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-3(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[104] = createSerializationRule("EnumerationLiteralCS-3", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				148		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				276		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				144		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::OperationCS-0(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[105] = createSerializationRule("OperationCS-0", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				95		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				291		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				292		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				258		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				262		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				268		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				216		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				236		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				276		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				284		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				189		/* 'operation' || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				231		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				237		/* V03*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				150		/* ')' || no-space value */,
				243		/* V04*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				253		/* V05*5-steps || value */,
				199		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				257		/* V06*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				263		/* V07*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				267		/* V08*1-steps || value */,
				292		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-1(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[106] = createSerializationRule("OperationCS-1", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				290		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				291		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				292		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				258		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				285		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				213		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				262		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				268		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				216		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				236		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				276		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				284		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				189		/* 'operation' || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				231		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				237		/* V03*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				150		/* ')' || no-space value */,
				243		/* V04*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				253		/* V05*5-steps || value */,
				199		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				257		/* V06*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				263		/* V07*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				267		/* V08*1-steps || value */,
				292		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				270		/* V09*5-steps || value */,
				168		/* 'body' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				224		/* V10*1-steps || value */,
				32		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-2(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[107] = createSerializationRule("OperationCS-2", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				95		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				291		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				292		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				258		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				173		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				262		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				268		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				216		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				236		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				276		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				284		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				189		/* 'operation' || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				231		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				237		/* V03*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				150		/* ')' || no-space value */,
				243		/* V04*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				253		/* V05*5-steps || value */,
				199		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				257		/* V06*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				263		/* V07*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				267		/* V08*1-steps || value */,
				292		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-3(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[108] = createSerializationRule("OperationCS-3", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				290		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				291		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				292		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				258		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				173		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				285		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				213		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				262		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				268		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				216		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				236		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				276		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				284		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				189		/* 'operation' || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				231		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				237		/* V03*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				150		/* ')' || no-space value */,
				243		/* V04*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				253		/* V05*5-steps || value */,
				199		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				257		/* V06*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				263		/* V07*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				267		/* V08*1-steps || value */,
				292		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				270		/* V09*5-steps || value */,
				168		/* 'body' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				224		/* V10*1-steps || value */,
				32		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-4(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[109] = createSerializationRule("OperationCS-4", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				95		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				291		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				292		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V3 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				270		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				280		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				252		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				261		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				184		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				215		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				189		/* 'operation' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				150		/* ')' || no-space value */,
				236		/* V03*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				246		/* V04*5-steps || value */,
				199		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				251		/* V05*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				258		/* V06*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				262		/* V07*1-steps || value */,
				292		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-5(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[110] = createSerializationRule("OperationCS-5", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				290		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				291		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				292		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				248		/* assign V3 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				170		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				281		/* assign V8 = (|OperationCS::ownedBodyExpressions| > 0) */,
				287		/* assign V9 = |OperationCS::ownedBodyExpressions| */,
				270		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				280		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				252		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				261		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				184		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				215		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				189		/* 'operation' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				150		/* ')' || no-space value */,
				236		/* V03*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				246		/* V04*5-steps || value */,
				199		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				251		/* V05*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				258		/* V06*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				262		/* V07*1-steps || value */,
				292		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				268		/* V08*5-steps || value */,
				168		/* 'body' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				269		/* V09*1-steps || value */,
				32		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 25/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ParameterCS-0(basecs::ParameterCS): { name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "{" { qualifiers+={'!ordered|!unique|ordered|unique'} }[+] "}" }[?] { "{" "}" }[?] }
		serializationRules[111] = createSerializationRule("ParameterCS-0", 70,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				172		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				189		/* assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0) */,
				232		/* assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| */,
				240		/* assign V3 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				223		/* V01*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				227		/* V02*1-steps || value */,
				293		/* TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				236		/* V03*2-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(3/*'!ordered|!unique|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ReferenceCS-0(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[112] = createSerializationRule("ReferenceCS-0", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				245		/* assign V3 = |StructuralFeatureCS::default| */,
				231		/* assign V2 = |TypedElementCS::ownedType| */,
				203		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				253		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				267		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				192		/* 'property' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				147		/* '#' || no-space value no-space */,
				133		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				236		/* V03*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				245		/* V04*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				250		/* V05*1-steps || value */,
				290		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-1(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[113] = createSerializationRule("ReferenceCS-1", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				297		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				245		/* assign V3 = |StructuralFeatureCS::default| */,
				231		/* assign V2 = |TypedElementCS::ownedType| */,
				203		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				253		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				267		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				273		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				275		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				282		/* assign V8 = 0 */,
				286		/* assign V9 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				192		/* 'property' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				147		/* '#' || no-space value no-space */,
				133		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				236		/* V03*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				245		/* V04*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				250		/* V05*1-steps || value */,
				290		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				259		/* V06*5-steps || value */,
				171		/* 'derivation' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				260		/* V07*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				268		/* V08*5-steps || value */,
				182		/* 'initial' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				269		/* V09*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-2(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[114] = createSerializationRule("ReferenceCS-2", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				245		/* assign V3 = |StructuralFeatureCS::default| */,
				231		/* assign V2 = |TypedElementCS::ownedType| */,
				203		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				173		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				253		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				267		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				192		/* 'property' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				147		/* '#' || no-space value no-space */,
				133		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				236		/* V03*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				245		/* V04*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				250		/* V05*1-steps || value */,
				290		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-3(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[115] = createSerializationRule("ReferenceCS-3", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				297		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				245		/* assign V3 = |StructuralFeatureCS::default| */,
				231		/* assign V2 = |TypedElementCS::ownedType| */,
				203		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				173		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				253		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				267		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				273		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				275		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				282		/* assign V8 = 0 */,
				286		/* assign V9 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				295		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				294		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				192		/* 'property' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				147		/* '#' || no-space value no-space */,
				133		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				236		/* V03*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				245		/* V04*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				250		/* V05*1-steps || value */,
				290		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				259		/* V06*5-steps || value */,
				171		/* 'derivation' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				260		/* V07*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				268		/* V08*5-steps || value */,
				182		/* 'initial' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				269		/* V09*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-4(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[116] = createSerializationRule("ReferenceCS-4", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				229		/* assign V2 = |StructuralFeatureCS::default| */,
				209		/* assign V1 = |TypedElementCS::ownedType| */,
				164		/* assign V0 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				238		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				259		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				192		/* 'property' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				147		/* '#' || no-space value no-space */,
				133		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				239		/* V03*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				242		/* V04*1-steps || value */,
				290		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-5(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[117] = createSerializationRule("ReferenceCS-5", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				297		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				309		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				229		/* assign V2 = |StructuralFeatureCS::default| */,
				209		/* assign V1 = |TypedElementCS::ownedType| */,
				164		/* assign V0 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				238		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				259		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				266		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				269		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				277		/* assign V7 = 0 */,
				282		/* assign V8 = 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				192		/* 'property' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				147		/* '#' || no-space value no-space */,
				133		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				287		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				239		/* V03*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				242		/* V04*1-steps || value */,
				290		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				254		/* V05*5-steps || value */,
				171		/* 'derivation' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				255		/* V06*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				264		/* V07*5-steps || value */,
				182		/* 'initial' || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				265		/* V08*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 42/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 64/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-0(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[118] = createSerializationRule("SimpleTargetElementCS-0", 96,
			createSerializationMatchSteps(
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				166		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				53		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				5		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				141		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				184		/* 'iterates' || soft-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(18/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-1(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[119] = createSerializationRule("SimpleTargetElementCS-1", 96,
			createSerializationMatchSteps(
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				53		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */,
				131		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				186		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				218		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				5		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				141		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				217		/* V00*8-steps || value */,
				184		/* 'iterates' || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				223		/* V01*4-steps || value */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(18/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-2(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[120] = createSerializationRule("SimpleTargetElementCS-2", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				166		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				54		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				29		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				141		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				184		/* 'iterates' || soft-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(20/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-3(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[121] = createSerializationRule("SimpleTargetElementCS-3", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				54		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */,
				131		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				186		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				218		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				29		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				141		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				217		/* V00*8-steps || value */,
				184		/* 'iterates' || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				223		/* V01*4-steps || value */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(20/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-4(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[122] = createSerializationRule("SimpleTargetElementCS-4", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				166		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				56		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				145		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				141		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				184		/* 'iterates' || soft-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(25/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-5(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[123] = createSerializationRule("SimpleTargetElementCS-5", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				56		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */,
				131		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				186		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				218		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				145		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				141		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				217		/* V00*8-steps || value */,
				184		/* 'iterates' || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				223		/* V01*4-steps || value */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(25/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SpecificationCS-0(essentialoclcs::ExpSpecificationCS): ownedExpression=ExpCS
		serializationRules[124] = createSerializationRule("SpecificationCS-0", 97,
			createSerializationMatchSteps(
				111		/* assert |SpecificationCS::exprString| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				329		/* check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				11		/* assert (|ExpSpecificationCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				52		/* ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::SpecificationCS-1(essentialoclcs::ExpSpecificationCS): exprString=UNQUOTED_STRING
		serializationRules[125] = createSerializationRule("SpecificationCS-1", 97,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				82		/* assert |ExpSpecificationCS::ownedExpression| == 0 */,
				57		/* assert (|SpecificationCS::exprString| - 1) == 0 */
			),
			createSerializationSteps(
				2		/* SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, true, GrammarCardinality.ONE)
			});
		// QVTbase::StructuredClassCS-0(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] ";" }
		serializationRules[126] = createSerializationRule("StructuredClassCS-0", 102,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				113		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				114		/* assert |StructuredClassCS::ownedOperations| == 0 */,
				115		/* assert |StructuredClassCS::ownedProperties| == 0 */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				300		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				254		/* assign V4 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				168		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				264		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				274		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				219		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				237		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				8		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				169		/* 'class' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				232		/* V02*5-steps || value */,
				176		/* 'extends' || soft-space value soft-space */,
				110		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				237		/* V03*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				110		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				243		/* V04*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V05*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				255		/* V06*1-steps || value */,
				13		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, false,
					(12/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, false,
					(19/*'interface'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::StructuredClassCS-1(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] { "{" { ownedOperations+=OperationCS[*] ownedProperties+=StructuralFeatureCS[*] } "}" } }
		serializationRules[127] = createSerializationRule("StructuredClassCS-1", 102,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				113		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				298		/* check-rule basecs::StructuredClassCS.ownedOperations : OperationCS */,
				299		/* check-rule basecs::StructuredClassCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				305		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				300		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				283		/* assign V8 = |StructuredClassCS::ownedProperties| */,
				279		/* assign V7 = |StructuredClassCS::ownedOperations| */,
				254		/* assign V4 = |ClassCS::instanceClassName| */,
				206		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				168		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				264		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				274		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				219		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				237		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				8		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				169		/* 'class' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				107		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				232		/* V02*5-steps || value */,
				176		/* 'extends' || soft-space value soft-space */,
				110		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				237		/* V03*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				110		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				243		/* V04*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V05*4-steps || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				255		/* V06*1-steps || value */,
				13		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				206		/* '}' || pop soft-space value soft-new-line */,
				203		/* '{' || soft-space value push soft-new-line */,
				261		/* V07*1-steps || value */,
				80		/* StructuredClassCS::ownedOperations+=OperationCS || value */,
				266		/* V08*1-steps || value */,
				101		/* StructuredClassCS::ownedProperties+=StructuralFeatureCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, false,
					(12/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, false,
					(19/*'interface'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 23/* OperationCS */,
					(68/*OperationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 45/* StructuralFeatureCS */,
					(101/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 51/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 65/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
	}
	private void initSerializationRules2() {
		// QVTbase::TargetCS-0(qvtbasecs::TargetCS): { "target" name=UnrestrictedName "{" ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)[*] "}" }
		serializationRules[128] = createSerializationRule("TargetCS-0", 103,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				370		/* check-rule qvtbasecs::TargetCS.ownedTargetElements : CompoundTargetElementCS|SimpleTargetElementCS */,
				169		/* assign V0 = |TargetCS::ownedTargetElements| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				197		/* 'target' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				208		/* V00*1-steps || value */,
				113		/* TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 41/* CompoundTargetElementCS,SimpleTargetElementCS */,
					(12/*CompoundTargetElementCS*/ << 4) | 2 /*[*]*/,
					(96/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[129] = createSerializationRule("TypedMultiplicityRefCS-0", 121,
			createSerializationMatchSteps(
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				175		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				48		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				25		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-1(basecs::TypedTypeRefCS): { { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[130] = createSerializationRule("TypedMultiplicityRefCS-1", 121,
			createSerializationMatchSteps(
				121		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				311		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				312		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				210		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				176		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				65		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				97		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				212		/* V00*3-steps || value */,
				149		/* '(' || no-space value no-space */,
				31		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				150		/* ')' || no-space value */,
				218		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 49/* TemplateBindingCS */,
					(104/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 26/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-2(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[131] = createSerializationRule("TypedMultiplicityRefCS-2", 121,
			createSerializationMatchSteps(
				325		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				326		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				233		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				144		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				193		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				121		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				218		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				150		/* ')' || no-space value */,
				225		/* V02*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 58/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-3(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[132] = createSerializationRule("TypedMultiplicityRefCS-3", 121,
			createSerializationMatchSteps(
				345		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				346		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				210		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				152		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				214		/* V00*5-steps || value */,
				149		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				154		/* ',' || no-space value soft-space */,
				127		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				150		/* ')' || no-space value */,
				218		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-4(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[133] = createSerializationRule("TypedMultiplicityRefCS-4", 121,
			createSerializationMatchSteps(
				310		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				306		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				250		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				136		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				187		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				220		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				216		/* V00*7-steps || value */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				150		/* ')' || no-space value */,
				233		/* V03*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 56/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::BottomPatternCS-0(qvtcorecs::BottomPatternCS): { "{" "}" }
		serializationRules[134] = createSerializationRule("BottomPatternCS-0", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			null);
		// QVTcore::BottomPatternCS-1(qvtcorecs::BottomPatternCS): { "{" ownedConstraints+=PredicateOrAssignmentCS[+] "}" }
		serializationRules[135] = createSerializationRule("BottomPatternCS-1", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				373		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				140		/* assign V0 = |BottomPatternCS::ownedConstraints| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				209		/* V00*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 30/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-2(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[136] = createSerializationRule("BottomPatternCS-2", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				373		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				380		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				191		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				130		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				204		/* '|' || soft-space value soft-space */,
				219		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 30/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 78/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-3(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[137] = createSerializationRule("BottomPatternCS-3", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				373		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				374		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				380		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				191		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				141		/* assign V0 = |BottomPatternCS::ownedRealizedVariables| */,
				43		/* assert (|PatternCS::ownedUnrealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				204		/* '|' || soft-space value soft-space */,
				219		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 30/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 36/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 78/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::BottomPatternCS-4(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[138] = createSerializationRule("BottomPatternCS-4", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				373		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				374		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				380		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				191		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				159		/* assign V0 = |PatternCS::ownedUnrealizedVariables| */,
				4		/* assert (|BottomPatternCS::ownedRealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				204		/* '|' || soft-space value soft-space */,
				219		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 30/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 36/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 78/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::BottomPatternCS-5(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[139] = createSerializationRule("BottomPatternCS-5", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				373		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				374		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				191		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				125		/* assign V0 = (|BottomPatternCS::ownedRealizedVariables| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				204		/* '|' || soft-space value soft-space */,
				219		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 30/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 36/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-6(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "}" }
		serializationRules[140] = createSerializationRule("BottomPatternCS-6", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				380		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				130		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 78/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-7(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "}" }
		serializationRules[141] = createSerializationRule("BottomPatternCS-7", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				374		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				380		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				141		/* assign V0 = |BottomPatternCS::ownedRealizedVariables| */,
				43		/* assert (|PatternCS::ownedUnrealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 36/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 78/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::BottomPatternCS-8(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "}" }
		serializationRules[142] = createSerializationRule("BottomPatternCS-8", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				374		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				380		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				159		/* assign V0 = |PatternCS::ownedUnrealizedVariables| */,
				4		/* assert (|BottomPatternCS::ownedRealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				288		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 36/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 78/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::BottomPatternCS-9(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "}" }
		serializationRules[143] = createSerializationRule("BottomPatternCS-9", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				374		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				125		/* assign V0 = (|BottomPatternCS::ownedRealizedVariables| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* '{' || soft-space value push soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 36/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::DirectionCS-0(qvtcorecs::DirectionCS): { name=Identifier[?] "imports" imports+=UnrestrictedName { "," imports+=UnrestrictedName }[*] { "uses" uses+=UnrestrictedName { "," uses+=UnrestrictedName }[*] }[?] }
		serializationRules[144] = createSerializationRule("DirectionCS-0", 16,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				182		/* assign V1 = (|DirectionCS::imports| - 1) */,
				155		/* assign V0 = |NamedElementCS::name| */,
				214		/* assign V2 = (|DirectionCS::uses| > 0) */,
				234		/* assign V3 = (|DirectionCS::uses| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				277		/* NamedElementCS::name=Identifier || soft-space value soft-space */,
				180		/* 'imports' || soft-space value soft-space */,
				4		/* DirectionCS::imports+=UnrestrictedName || soft-space value soft-space */,
				221		/* V01*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				4		/* DirectionCS::imports+=UnrestrictedName || soft-space value soft-space */,
				232		/* V02*5-steps || value */,
				201		/* 'uses' || soft-space value soft-space */,
				143		/* DirectionCS::uses+=UnrestrictedName || soft-space value soft-space */,
				237		/* V03*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				143		/* DirectionCS::uses+=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.DIRECTION_CS__IMPORTS, -1
				),
				createSerializationReference(QVTcoreCSPackage.Literals.DIRECTION_CS__USES, -1
				)
			});
		// QVTcore::GuardPatternCS-0(qvtcorecs::GuardPatternCS): { "(" ")" }
		serializationRules[145] = createSerializationRule("GuardPatternCS-0", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |GuardPatternCS::ownedPredicates| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				149		/* '(' || no-space value no-space */,
				150		/* ')' || no-space value */
			),
			null);
		// QVTcore::GuardPatternCS-1(qvtcorecs::GuardPatternCS): { "(" ownedPredicates+=PredicateCS[+] ")" }
		serializationRules[146] = createSerializationRule("GuardPatternCS-1", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				375		/* check-rule qvtcorecs::GuardPatternCS.ownedPredicates : PredicateCS */,
				149		/* assign V0 = |GuardPatternCS::ownedPredicates| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				149		/* '(' || no-space value no-space */,
				209		/* V00*1-steps || value */,
				100		/* GuardPatternCS::ownedPredicates+=PredicateCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 29/* PredicateCS */,
					(73/*PredicateCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::GuardPatternCS-2(qvtcorecs::GuardPatternCS): { "(" ownedUnrealizedVariables+=GuardVariableCS { "," ownedUnrealizedVariables+=GuardVariableCS }[*] ")" }
		serializationRules[147] = createSerializationRule("GuardPatternCS-2", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |GuardPatternCS::ownedPredicates| == 0 */,
				381		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : GuardVariableCS */,
				130		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				149		/* '(' || no-space value no-space */,
				289		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				289		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 11/* GuardVariableCS */,
					(32/*GuardVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::GuardPatternCS-3(qvtcorecs::GuardPatternCS): { "(" ownedUnrealizedVariables+=GuardVariableCS { "," ownedUnrealizedVariables+=GuardVariableCS }[*] "|" ownedPredicates+=PredicateCS[*] ")" }
		serializationRules[148] = createSerializationRule("GuardPatternCS-3", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				375		/* check-rule qvtcorecs::GuardPatternCS.ownedPredicates : PredicateCS */,
				381		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : GuardVariableCS */,
				195		/* assign V1 = |GuardPatternCS::ownedPredicates| */,
				130		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				149		/* '(' || no-space value no-space */,
				289		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value */,
				211		/* V00*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				289		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value */,
				204		/* '|' || soft-space value soft-space */,
				219		/* V01*1-steps || value */,
				100		/* GuardPatternCS::ownedPredicates+=PredicateCS || value */,
				150		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 29/* PredicateCS */,
					(73/*PredicateCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 11/* GuardVariableCS */,
					(32/*GuardVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::GuardVariableCS-0(qvtcorecs::UnrealizedVariableCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[149] = createSerializationRule("GuardVariableCS-0", 32,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |UnrealizedVariableCS::ownedInitExpression| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::ImportCS-0(basecs::ImportCS): { "import" { name=Identifier ":" }[?] ownedPathName=URIPathNameCS { isAll?="::" "*" }[?] ";" }
		serializationRules[150] = createSerializationRule("ImportCS-0", 37,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				289		/* check-rule basecs::ImportCS.ownedPathName : URIPathNameCS */,
				196		/* assign V1 = |ImportCS::isAll.'::'| */,
				17		/* assert (|ImportCS::ownedPathName| - 1) == 0 */,
				155		/* assign V0 = |NamedElementCS::name| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				179		/* 'import' || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				277		/* NamedElementCS::name=Identifier || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				93		/* ImportCS::ownedPathName=URIPathNameCS || value */,
				220		/* V01*2-steps || value */,
				9		/* ImportCS::isAll?='::' || no-space value no-space */,
				152		/* '*' || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, false,
					(7/*'::'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 69/* URIPathNameCS */,
					(128/*URIPathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::MappingCS-0(qvtcorecs::MappingCS): { isAbstract?="abstract"[?] "map" name=UnrestrictedName[?] { "in" ownedInPathName=PathNameCS }[?] { "refines" refines+=UnrestrictedName { "," refines+=UnrestrictedName }[*] }[?] "{" ownedDomains+=NamedDomainCS[*] { "where" ownedMiddle=UnnamedDomainCS }[?] ownedComposedMappings+=MappingCS[*] "}" }
		serializationRules[151] = createSerializationRule("MappingCS-0", 50,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				376		/* check-rule qvtcorecs::MappingCS.ownedComposedMappings : MappingCS */,
				377		/* check-rule qvtcorecs::MappingCS.ownedDomains : NamedDomainCS */,
				378		/* check-rule qvtcorecs::MappingCS.ownedInPathName : PathNameCS */,
				379		/* check-rule qvtcorecs::MappingCS.ownedMiddle : UnnamedDomainCS */,
				278		/* assign V7 = |MappingCS::ownedComposedMappings| */,
				272		/* assign V6 = |MappingCS::ownedMiddle| */,
				265		/* assign V5 = |MappingCS::ownedDomains| */,
				227		/* assign V2 = |MappingCS::ownedInPathName| */,
				197		/* assign V1 = |NamedElementCS::name| */,
				153		/* assign V0 = |MappingCS::isAbstract.'abstract'| */,
				235		/* assign V3 = (|MappingCS::refines| > 0) */,
				251		/* assign V4 = (|MappingCS::refines| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				7		/* MappingCS::isAbstract?='abstract' || soft-space value soft-space */,
				187		/* 'map' || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				181		/* 'in' || soft-space value soft-space */,
				62		/* MappingCS::ownedInPathName=PathNameCS || value */,
				240		/* V03*5-steps || value */,
				195		/* 'refines' || soft-space value soft-space */,
				135		/* MappingCS::refines+=UnrestrictedName || soft-space value soft-space */,
				244		/* V04*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				135		/* MappingCS::refines+=UnrestrictedName || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				249		/* V05*1-steps || value */,
				46		/* MappingCS::ownedDomains+=NamedDomainCS || value */,
				256		/* V06*2-steps || value */,
				202		/* 'where' || soft-space value soft-space */,
				75		/* MappingCS::ownedMiddle=UnnamedDomainCS || value */,
				261		/* V07*1-steps || value */,
				37		/* MappingCS::ownedComposedMappings+=MappingCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.MAPPING_CS__IS_ABSTRACT, false,
					(12/*'abstract'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_COMPOSED_MAPPINGS, 16/* MappingCS */,
					(50/*MappingCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_DOMAINS, 18/* NamedDomainCS */,
					(57/*NamedDomainCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME, 26/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE, 77/* UnnamedDomainCS */,
					(131/*UnnamedDomainCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__REFINES, -1
				)
			});
		// QVTcore::NamedDomainCS-0(qvtcorecs::DomainCS): { isCheck?="check"[?] isEnforce?="enforce"[?] direction=UnrestrictedName ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS }
		serializationRules[152] = createSerializationRule("NamedDomainCS-0", 57,
			createSerializationMatchSteps(
				89		/* assert |NamedElementCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				371		/* check-rule qvtcorecs::AreaCS.ownedBottomPattern : BottomPatternCS */,
				372		/* check-rule qvtcorecs::AreaCS.ownedGuardPattern : GuardPatternCS */,
				1		/* assert (|AreaCS::ownedBottomPattern| - 1) == 0 */,
				2		/* assert (|AreaCS::ownedGuardPattern| - 1) == 0 */,
				10		/* assert (|DomainCS::direction| - 1) == 0 */,
				194		/* assign V1 = |DomainCS::isEnforce.'enforce'| */,
				147		/* assign V0 = |DomainCS::isCheck.'check'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				10		/* DomainCS::isCheck?='check' || soft-space value soft-space */,
				218		/* V01*1-steps || value */,
				12		/* DomainCS::isEnforce?='enforce' || soft-space value soft-space */,
				1		/* DomainCS::direction=UnrestrictedName || soft-space value soft-space */,
				58		/* AreaCS::ownedGuardPattern=GuardPatternCS || value */,
				33		/* AreaCS::ownedBottomPattern=BottomPatternCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_CHECK, false,
					(13/*'check'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_ENFORCE, false,
					(16/*'enforce'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.DOMAIN_CS__DIRECTION, -1
				),
				createSerializationReference(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN, 0/* BottomPatternCS */,
					(4/*BottomPatternCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.AREA_CS__OWNED_GUARD_PATTERN, 10/* GuardPatternCS */,
					(31/*GuardPatternCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::ParamDeclarationCS-0(qvtcorecs::ParamDeclarationCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[153] = createSerializationRule("ParamDeclarationCS-0", 69,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::PredicateCS-0(qvtcorecs::PredicateCS): { ownedCondition=ExpCS ";" }
		serializationRules[154] = createSerializationRule("PredicateCS-0", 73,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				382		/* check-rule qvtcorecs::PredicateCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				45		/* assert (|PredicateCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				40		/* PredicateCS::ownedCondition=ExpCS || value */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::PredicateOrAssignmentCS-0(qvtcorecs::PredicateOrAssignmentCS): { isDefault?="default"[?] ownedTarget=ExpCS { ":=" ownedInitExpression=ExpCS }[?] ";" }
		serializationRules[155] = createSerializationRule("PredicateOrAssignmentCS-0", 74,
			createSerializationMatchSteps(
				101		/* assert |PredicateOrAssignmentCS::isPartial| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				384		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedTarget : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				202		/* assign V1 = |PredicateOrAssignmentCS::ownedInitExpression| */,
				47		/* assert (|PredicateOrAssignmentCS::ownedTarget| - 1) == 0 */,
				161		/* assign V0 = |PredicateOrAssignmentCS::isDefault.'default'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				11		/* PredicateOrAssignmentCS::isDefault?='default' || soft-space value soft-space */,
				111		/* PredicateOrAssignmentCS::ownedTarget=ExpCS || value */,
				220		/* V01*2-steps || value */,
				158		/* ':=' || soft-space value soft-space */,
				64		/* PredicateOrAssignmentCS::ownedInitExpression=ExpCS || value */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT, false,
					(14/*'default'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::PredicateOrAssignmentCS-1(qvtcorecs::PredicateOrAssignmentCS): { isDefault?="default"[?] ownedTarget=ExpCS { isPartial?="+=" ownedInitExpression=ExpCS }[?] ";" }
		serializationRules[156] = createSerializationRule("PredicateOrAssignmentCS-1", 74,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				384		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedTarget : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				202		/* assign V1 = |PredicateOrAssignmentCS::ownedInitExpression| */,
				46		/* assert (|PredicateOrAssignmentCS::isPartial.'+='| - V1) == 0 */,
				47		/* assert (|PredicateOrAssignmentCS::ownedTarget| - 1) == 0 */,
				161		/* assign V0 = |PredicateOrAssignmentCS::isDefault.'default'| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				11		/* PredicateOrAssignmentCS::isDefault?='default' || soft-space value soft-space */,
				111		/* PredicateOrAssignmentCS::ownedTarget=ExpCS || value */,
				220		/* V01*2-steps || value */,
				15		/* PredicateOrAssignmentCS::isPartial?='+=' || soft-space value soft-space */,
				64		/* PredicateOrAssignmentCS::ownedInitExpression=ExpCS || value */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT, false,
					(14/*'default'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL, false,
					(5/*'+='*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::QualifiedPackageCS-0(qvtbasecs::QualifiedPackageCS): { "package" ownedPathName=ScopeNameCS[?] name=UnrestrictedName { ":" nsPrefix=UnrestrictedName }[?] { "=" nsURI=URI }[?] ";" }
		serializationRules[157] = createSerializationRule("QualifiedPackageCS-0", 83,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				98		/* assert |PackageCS::ownedClasses| == 0 */,
				99		/* assert |PackageOwnerCS::ownedPackages| == 0 */,
				369		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				228		/* assign V2 = |PackageCS::nsURI| */,
				200		/* assign V1 = |PackageCS::nsPrefix| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				162		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				190		/* 'package' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				94		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				27		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				28		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 38/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTcore::QualifiedPackageCS-1(qvtbasecs::QualifiedPackageCS): { "package" ownedPathName=ScopeNameCS[?] name=UnrestrictedName { ":" nsPrefix=UnrestrictedName }[?] { "=" nsURI=URI }[?] { "{" { ownedClasses+=(ClassCS|TransformationCS)[*] ownedPackages+=QualifiedPackageCS[*] } "}" } }
		serializationRules[158] = createSerializationRule("QualifiedPackageCS-1", 83,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				293		/* check-rule basecs::PackageCS.ownedClasses : ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				294		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				369		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				255		/* assign V4 = |PackageOwnerCS::ownedPackages| */,
				244		/* assign V3 = |PackageCS::ownedClasses| */,
				228		/* assign V2 = |PackageCS::nsURI| */,
				200		/* assign V1 = |PackageCS::nsPrefix| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				162		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				190		/* 'package' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				94		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				220		/* V01*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				27		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				228		/* V02*2-steps || value */,
				161		/* '=' || soft-space value soft-space */,
				28		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				234		/* V03*1-steps || value */,
				34		/* PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line */,
				241		/* V04*1-steps || value */,
				81		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 53/* ClassCS,TransformationCS */,
					(5/*ClassCS*/ << 4) | 2 /*[*]*/,
					(108/*TransformationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 34/* QualifiedPackageCS */,
					(83/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 38/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTcore::QueryCS-0(qvtcorecs::QueryCS): { isTransient?="transient"[?] "query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS ";" }
		serializationRules[159] = createSerializationRule("QueryCS-0", 84,
			createSerializationMatchSteps(
				85		/* assert |JavaImplementationCS::implementation| == 0 */,
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				102		/* assert |QueryCS::ownedExpression| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				386		/* check-rule qvtcorecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				387		/* check-rule qvtcorecs::QueryCS.ownedPathName : ScopeNameCS */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				50		/* assert (|QueryCS::ownedPathName| - 1) == 0 */,
				163		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				185		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				217		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				20		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				193		/* 'query' || soft-space value soft-space */,
				95		/* QueryCS::ownedPathName=ScopeNameCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				150		/* ')' || no-space value */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(24/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/* ParamDeclarationCS */,
					(69/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 38/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::QueryCS-1(qvtcorecs::QueryCS): { isTransient?="transient"[?] "query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "implementedby" implementation=SINGLE_QUOTED_STRING ";" } }
		serializationRules[160] = createSerializationRule("QueryCS-1", 84,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				102		/* assert |QueryCS::ownedExpression| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				386		/* check-rule qvtcorecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				387		/* check-rule qvtcorecs::QueryCS.ownedPathName : ScopeNameCS */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				19		/* assert (|JavaImplementationCS::implementation| - 1) == 0 */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				50		/* assert (|QueryCS::ownedPathName| - 1) == 0 */,
				163		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				185		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				217		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				20		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				193		/* 'query' || soft-space value soft-space */,
				95		/* QueryCS::ownedPathName=ScopeNameCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				150		/* ')' || no-space value */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */,
				178		/* 'implementedby' || soft-space value soft-space */,
				3		/* JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				159		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(24/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, -1
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/* ParamDeclarationCS */,
					(69/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 38/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::QueryCS-2(qvtcorecs::QueryCS): { isTransient?="transient"[?] "query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "{" ownedExpression=ExpCS "}" } }
		serializationRules[161] = createSerializationRule("QueryCS-2", 84,
			createSerializationMatchSteps(
				85		/* assert |JavaImplementationCS::implementation| == 0 */,
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				385		/* check-rule qvtcorecs::QueryCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule qvtcorecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				387		/* check-rule qvtcorecs::QueryCS.ownedPathName : ScopeNameCS */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				49		/* assert (|QueryCS::ownedExpression| - 1) == 0 */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				50		/* assert (|QueryCS::ownedPathName| - 1) == 0 */,
				163		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				185		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				217		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* V00*1-steps || value */,
				20		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				193		/* 'query' || soft-space value soft-space */,
				95		/* QueryCS::ownedPathName=ScopeNameCS || value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				149		/* '(' || no-space value no-space */,
				223		/* V01*4-steps || value */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				229		/* V02*2-steps || value */,
				154		/* ',' || no-space value soft-space */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				150		/* ')' || no-space value */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */,
				203		/* '{' || soft-space value push soft-new-line */,
				54		/* QueryCS::ownedExpression=ExpCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(24/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 24/* ParamDeclarationCS */,
					(69/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 38/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::RealizedVariableCS-0(qvtcorecs::RealizedVariableCS): { "realize" name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[162] = createSerializationRule("RealizedVariableCS-0", 85,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'realize' || soft-space value soft-space */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::ScopeNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS "::" { ownedPathElements+=NextPathElementCS "::" }[*] }
		serializationRules[163] = createSerializationRule("ScopeNameCS-0", 92,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				281		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				157		/* '::' || no-space value no-space */,
				211		/* V00*2-steps || value */,
				282		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */,
				157		/* '::' || no-space value no-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 22/* FirstPathElementCS,NextPathElementCS */,
					(30/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(65/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::TopLevelCS-0(qvtcorecs::TopLevelCS): { ownedImports+=ImportCS[*] { ownedPackages+=QualifiedPackageCS[*] ownedTransformations+=TransformationCS[*] ownedMappings+=MappingCS[*] ownedQueries+=QueryCS[*] } }
		serializationRules[164] = createSerializationRule("TopLevelCS-0", 107,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				296		/* check-rule basecs::RootCS.ownedImports : ImportCS */,
				388		/* check-rule qvtcorecs::TopLevelCS.ownedMappings : MappingCS */,
				294		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				389		/* check-rule qvtcorecs::TopLevelCS.ownedQueries : QueryCS */,
				390		/* check-rule qvtcorecs::TopLevelCS.ownedTransformations : TransformationCS */,
				257		/* assign V4 = |TopLevelCS::ownedQueries| */,
				246		/* assign V3 = |TopLevelCS::ownedMappings| */,
				230		/* assign V2 = |TopLevelCS::ownedTransformations| */,
				201		/* assign V1 = |PackageOwnerCS::ownedPackages| */,
				165		/* assign V0 = |RootCS::ownedImports| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				208		/* V00*1-steps || value */,
				60		/* RootCS::ownedImports+=ImportCS || value */,
				219		/* V01*1-steps || value */,
				81		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || value */,
				226		/* V02*1-steps || value */,
				118		/* TopLevelCS::ownedTransformations+=TransformationCS || value */,
				234		/* V03*1-steps || value */,
				74		/* TopLevelCS::ownedMappings+=MappingCS || value */,
				241		/* V04*1-steps || value */,
				103		/* TopLevelCS::ownedQueries+=QueryCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 12/* ImportCS */,
					(37/*ImportCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS, 16/* MappingCS */,
					(50/*MappingCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 34/* QualifiedPackageCS */,
					(83/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES, 35/* QueryCS */,
					(84/*QueryCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 52/* TransformationCS */,
					(108/*TransformationCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::TransformationCS-0(qvtcorecs::TransformationCS): { "transformation" ownedPathName=ScopeNameCS[?] name=UnreservedName "{" { ownedDirections+=DirectionCS ";" }[*] ownedTargets+=TargetCS[*] ownedProperties+=StructuralFeatureCS[*] "}" }
		serializationRules[165] = createSerializationRule("TransformationCS-0", 108,
			createSerializationMatchSteps(
				70		/* assert |ClassCS::instanceClassName| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				116		/* assert |TemplateableElementCS::ownedSignature| == 0 */,
				391		/* check-rule qvtcorecs::TransformationCS.ownedDirections : DirectionCS */,
				366		/* check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : ScopeNameCS */,
				392		/* check-rule qvtcorecs::TransformationCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				367		/* check-rule qvtbasecs::AbstractTransformationCS.ownedTargets : TargetCS */,
				247		/* assign V3 = |TransformationCS::ownedProperties| */,
				224		/* assign V2 = |AbstractTransformationCS::ownedTargets| */,
				207		/* assign V1 = |TransformationCS::ownedDirections| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				139		/* assign V0 = |AbstractTransformationCS::ownedPathName| */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				200		/* 'transformation' || soft-space value soft-space */,
				207		/* V00*1-steps || value */,
				92		/* AbstractTransformationCS::ownedPathName=ScopeNameCS || value */,
				273		/* NamedElementCS::name=UnreservedName || soft-space value soft-space */,
				203		/* '{' || soft-space value push soft-new-line */,
				221		/* V01*2-steps || value */,
				45		/* TransformationCS::ownedDirections+=DirectionCS || value */,
				159		/* ';' || no-space value soft-new-line */,
				226		/* V02*1-steps || value */,
				114		/* AbstractTransformationCS::ownedTargets+=TargetCS || value */,
				234		/* V03*1-steps || value */,
				102		/* TransformationCS::ownedProperties+=StructuralFeatureCS || value */,
				206		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 5/* DirectionCS */,
					(16/*DirectionCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 38/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 45/* StructuralFeatureCS */,
					(101/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 48/* TargetCS */,
					(103/*TargetCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::UnnamedDomainCS-0(qvtcorecs::DomainCS): { ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS }
		serializationRules[166] = createSerializationRule("UnnamedDomainCS-0", 131,
			createSerializationMatchSteps(
				76		/* assert |DomainCS::direction| == 0 */,
				77		/* assert |DomainCS::isCheck| == 0 */,
				78		/* assert |DomainCS::isEnforce| == 0 */,
				89		/* assert |NamedElementCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				371		/* check-rule qvtcorecs::AreaCS.ownedBottomPattern : BottomPatternCS */,
				372		/* check-rule qvtcorecs::AreaCS.ownedGuardPattern : GuardPatternCS */,
				1		/* assert (|AreaCS::ownedBottomPattern| - 1) == 0 */,
				2		/* assert (|AreaCS::ownedGuardPattern| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				58		/* AreaCS::ownedGuardPattern=GuardPatternCS || value */,
				33		/* AreaCS::ownedBottomPattern=BottomPatternCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN, 0/* BottomPatternCS */,
					(4/*BottomPatternCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.AREA_CS__OWNED_GUARD_PATTERN, 10/* GuardPatternCS */,
					(31/*GuardPatternCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::UnrealizedVariableCS-0(qvtcorecs::UnrealizedVariableCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] { ":=" ownedInitExpression=ExpCS }[?] }
		serializationRules[167] = createSerializationRule("UnrealizedVariableCS-0", 132,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				393		/* check-rule qvtcorecs::UnrealizedVariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				308		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				211		/* assign V1 = |UnrealizedVariableCS::ownedInitExpression| */,
				172		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				271		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				274		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				210		/* V00*2-steps || value */,
				156		/* ':' || soft-space value soft-space */,
				286		/* TypedElementCS::ownedType=TypeExpCS || value */,
				220		/* V01*2-steps || value */,
				158		/* ':=' || soft-space value soft-space */,
				67		/* UnrealizedVariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 57/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
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
			SerializationSegment.HALF_NEW_LINE /* half-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.HALF_NEW_LINE /* half-new-line */
		};
		serializationSegments[4] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[5] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[6] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[7] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[8] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[9] = new @NonNull SerializationSegment @NonNull [] {
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
		serializationSteps[0] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, 90 /*SINGLE_QUOTED_STRING*/, 7);
		// 1: DomainCS::direction=UnrestrictedName || soft-space value soft-space
		serializationSteps[1] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.DOMAIN_CS__DIRECTION, getCrossReference(QVTcoreCSPackage.Literals.DOMAIN_CS__DIRECTION, "UnrestrictedName"), 134, 7);
		// 2: SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[2] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, 124 /*UNQUOTED_STRING*/, 2);
		// 3: JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[3] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, getCrossReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, "SINGLE_QUOTED_STRING"), 90, 7);
		// 4: DirectionCS::imports+=UnrestrictedName || soft-space value soft-space
		serializationSteps[4] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__IMPORTS, getCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__IMPORTS, "UnrestrictedName"), 134, 7);
		// 5: SimpleTargetElementCS::input?='input' || soft-space value soft-space
		serializationSteps[5] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 18 /* 'input' */, 7);
		// 6: ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[6] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, 90 /*SINGLE_QUOTED_STRING*/, 7);
		// 7: MappingCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[7] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.MAPPING_CS__IS_ABSTRACT, 12 /* 'abstract' */, 7);
		// 8: StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[8] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 12 /* 'abstract' */, 7);
		// 9: ImportCS::isAll?='::' || no-space value no-space
		serializationSteps[9] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, 7 /* '::' */, 4);
		// 10: DomainCS::isCheck?='check' || soft-space value soft-space
		serializationSteps[10] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_CHECK, 13 /* 'check' */, 7);
		// 11: PredicateOrAssignmentCS::isDefault?='default' || soft-space value soft-space
		serializationSteps[11] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT, 14 /* 'default' */, 7);
		// 12: DomainCS::isEnforce?='enforce' || soft-space value soft-space
		serializationSteps[12] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_ENFORCE, 16 /* 'enforce' */, 7);
		// 13: StructuredClassCS::isInterface?='interface' || soft-space value soft-space
		serializationSteps[13] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 19 /* 'interface' */, 7);
		// 14: MultiplicityCS::isNullFree?='|1' || no-space value no-space
		serializationSteps[14] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 27 /* '|1' */, 4);
		// 15: PredicateOrAssignmentCS::isPartial?='+=' || soft-space value soft-space
		serializationSteps[15] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL, 5 /* '+=' */, 7);
		// 16: AbstractNameExpCS::isPre?='@' || soft-space value soft-space
		serializationSteps[16] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 9 /* '@' */, 7);
		// 17: DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space
		serializationSteps[17] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 21 /* 'primitive' */, 7);
		// 18: DataTypeCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[18] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 22 /* 'serializable' */, 7);
		// 19: EnumerationCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[19] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 22 /* 'serializable' */, 7);
		// 20: QueryCS::isTransient?='transient' || soft-space value soft-space
		serializationSteps[20] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, 24 /* 'transient' */, 7);
		// 21: SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space
		serializationSteps[21] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, "UnrestrictedName"), 134, 7);
		// 22: MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space
		serializationSteps[22] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, 41 /*LOWER*/, 7);
		// 23: CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space
		serializationSteps[23] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, 11 /*CollectionTypeIdentifier*/, 7);
		// 24: MapTypeCS::name='Map' || soft-space value soft-space
		serializationSteps[24] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 10 /* 'Map' */, 7);
		// 25: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space
		serializationSteps[25] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, 80 /*PrimitiveTypeIdentifier*/, 7);
		// 26: TupleTypeCS::name='Tuple' || soft-space value soft-space
		serializationSteps[26] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 11 /* 'Tuple' */, 7);
		// 27: PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space
		serializationSteps[27] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, 134 /*UnrestrictedName*/, 7);
		// 28: PackageCS::nsURI=URI || soft-space value soft-space
		serializationSteps[28] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, 126 /*URI*/, 7);
		// 29: SimpleTargetElementCS::output?='output' || soft-space value soft-space
		serializationSteps[29] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 20 /* 'output' */, 7);
		// 30: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[30] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 120 /*TypeRefCS*/, 2);
		// 31: TypedTypeRefCS::ownedBinding=TemplateBindingCS || value
		serializationSteps[31] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 104 /*TemplateBindingCS*/, 0);
		// 32: OperationCS::ownedBodyExpressions+=SpecificationCS || value
		serializationSteps[32] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 97 /*SpecificationCS*/, 0);
		// 33: AreaCS::ownedBottomPattern=BottomPatternCS || value
		serializationSteps[33] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN, 4 /*BottomPatternCS*/, 0);
		// 34: PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line
		serializationSteps[34] = createSerializationStepAssigns(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, -1, new int[] { 5/*ClassCS*/,108/*TransformationCS*/}, 3);
		// 35: NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value
		serializationSteps[35] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 6 /*CoIteratorVariableCS*/, 0);
		// 36: CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value
		serializationSteps[36] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 53 /*MultiplicityCS*/, 0);
		// 37: MappingCS::ownedComposedMappings+=MappingCS || value
		serializationSteps[37] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_COMPOSED_MAPPINGS, 50 /*MappingCS*/, 0);
		// 38: IfExpCS::ownedCondition=ExpCS|PatternExpCS || value
		serializationSteps[38] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, -1, new int[] { 29/*ExpCS*/,72/*PatternExpCS*/}, 0);
		// 39: IfThenExpCS::ownedCondition=ExpCS || value
		serializationSteps[39] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 29 /*ExpCS*/, 0);
		// 40: PredicateCS::ownedCondition=ExpCS || value
		serializationSteps[40] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 29 /*ExpCS*/, 0);
		// 41: BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || value
		serializationSteps[41] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 74 /*PredicateOrAssignmentCS*/, 0);
		// 42: AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[42] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 13 /*CurlyBracketedClauseCS*/, 0);
		// 43: TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[43] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 13 /*CurlyBracketedClauseCS*/, 0);
		// 44: StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value
		serializationSteps[44] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 97 /*SpecificationCS*/, 0);
		// 45: TransformationCS::ownedDirections+=DirectionCS || value
		serializationSteps[45] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 16 /*DirectionCS*/, 0);
		// 46: MappingCS::ownedDomains+=NamedDomainCS || value
		serializationSteps[46] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_DOMAINS, 57 /*NamedDomainCS*/, 0);
		// 47: IfExpCS::ownedElseExpression=ExpCS || value
		serializationSteps[47] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 29 /*ExpCS*/, 0);
		// 48: OperationCS::ownedExceptions+=TypedRefCS || value
		serializationSteps[48] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 122 /*TypedRefCS*/, 0);
		// 49: CollectionLiteralPartCS::ownedExpression=ExpCS || value
		serializationSteps[49] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 29 /*ExpCS*/, 0);
		// 50: CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[50] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 72 /*PatternExpCS*/, 2);
		// 51: ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[51] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 29 /*ExpCS*/, 2);
		// 52: ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[52] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 29 /*ExpCS*/, 2);
		// 53: NestedExpCS::ownedExpression=ExpCS || value
		serializationSteps[53] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 29 /*ExpCS*/, 0);
		// 54: QueryCS::ownedExpression=ExpCS || value
		serializationSteps[54] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 29 /*ExpCS*/, 0);
		// 55: LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value
		serializationSteps[55] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 29 /*ExpCS*/, 0);
		// 56: TypeParameterCS::ownedExtends+=TypedRefCS || value
		serializationSteps[56] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 122 /*TypedRefCS*/, 0);
		// 57: WildcardTypeRefCS::ownedExtends=TypedRefCS || value
		serializationSteps[57] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 122 /*TypedRefCS*/, 0);
		// 58: AreaCS::ownedGuardPattern=GuardPatternCS || value
		serializationSteps[58] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.AREA_CS__OWNED_GUARD_PATTERN, 31 /*GuardPatternCS*/, 0);
		// 59: IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value
		serializationSteps[59] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 19 /*ElseIfThenExpCS*/, 0);
		// 60: RootCS::ownedImports+=ImportCS || value
		serializationSteps[60] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 37 /*ImportCS*/, 0);
		// 61: LetExpCS::ownedInExpression=ExpCS || value
		serializationSteps[61] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 29 /*ExpCS*/, 0);
		// 62: MappingCS::ownedInPathName=PathNameCS || value
		serializationSteps[62] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME, 71 /*PathNameCS*/, 0);
		// 63: NavigatingArgCS::ownedInitExpression=ExpCS || value
		serializationSteps[63] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 29 /*ExpCS*/, 0);
		// 64: PredicateOrAssignmentCS::ownedInitExpression=ExpCS || value
		serializationSteps[64] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, 29 /*ExpCS*/, 0);
		// 65: ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value
		serializationSteps[65] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, -1, new int[] { 29/*ExpCS*/,72/*PatternExpCS*/}, 0);
		// 66: ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[66] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 100 /*StringLiteralExpCS*/, 2);
		// 67: UnrealizedVariableCS::ownedInitExpression=ExpCS || value
		serializationSteps[67] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION, 29 /*ExpCS*/, 0);
		// 68: VariableCS::ownedInitExpression=ExpCS || value
		serializationSteps[68] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 29 /*ExpCS*/, 0);
		// 69: MapLiteralPartCS::ownedKey=ExpCS || value
		serializationSteps[69] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 29 /*ExpCS*/, 0);
		// 70: MapTypeCS::ownedKeyType=TypeExpCS || value
		serializationSteps[70] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 113 /*TypeExpCS*/, 0);
		// 71: CollectionLiteralPartCS::ownedLastExpression=ExpCS || value
		serializationSteps[71] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 29 /*ExpCS*/, 0);
		// 72: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value
		serializationSteps[72] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 76 /*PrefixedPrimaryExpCS*/, 0);
		// 73: EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value
		serializationSteps[73] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 21 /*EnumerationLiteralCS*/, 0);
		// 74: TopLevelCS::ownedMappings+=MappingCS || value
		serializationSteps[74] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS, 50 /*MappingCS*/, 0);
		// 75: MappingCS::ownedMiddle=UnnamedDomainCS || value
		serializationSteps[75] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE, 131 /*UnnamedDomainCS*/, 0);
		// 76: TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[76] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 53 /*MultiplicityCS*/, 0);
		// 77: TypedRefCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[77] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 53 /*MultiplicityCS*/, 0);
		// 78: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value
		serializationSteps[78] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 59 /*NavigatingArgExpCS*/, 0);
		// 79: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[79] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 59 /*NavigatingArgExpCS*/, 2);
		// 80: StructuredClassCS::ownedOperations+=OperationCS || value
		serializationSteps[80] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 68 /*OperationCS*/, 0);
		// 81: PackageOwnerCS::ownedPackages+=QualifiedPackageCS || value
		serializationSteps[81] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 83 /*QualifiedPackageCS*/, 0);
		// 82: OperationCS::ownedParameters+=ParameterCS || value
		serializationSteps[82] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 70 /*ParameterCS*/, 0);
		// 83: QueryCS::ownedParameters+=ParamDeclarationCS || value
		serializationSteps[83] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 69 /*ParamDeclarationCS*/, 0);
		// 84: TemplateSignatureCS::ownedParameters+=TypeParameterCS || value
		serializationSteps[84] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 119 /*TypeParameterCS*/, 0);
		// 85: CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value
		serializationSteps[85] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 8 /*CollectionLiteralPartCS*/, 0);
		// 86: CollectionPatternCS::ownedParts+=PatternExpCS || value
		serializationSteps[86] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 72 /*PatternExpCS*/, 0);
		// 87: CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value
		serializationSteps[87] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 94 /*ShadowPartCS*/, 0);
		// 88: MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value
		serializationSteps[88] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 48 /*MapLiteralPartCS*/, 0);
		// 89: TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value
		serializationSteps[89] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 110 /*TupleLiteralPartCS*/, 0);
		// 90: TupleTypeCS::ownedParts+=TuplePartCS || value
		serializationSteps[90] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 111 /*TuplePartCS*/, 0);
		// 91: AbstractNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[91] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 71 /*PathNameCS*/, 0);
		// 92: AbstractTransformationCS::ownedPathName=ScopeNameCS || value
		serializationSteps[92] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 92 /*ScopeNameCS*/, 0);
		// 93: ImportCS::ownedPathName=URIPathNameCS || value
		serializationSteps[93] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 128 /*URIPathNameCS*/, 0);
		// 94: QualifiedPackageCS::ownedPathName=ScopeNameCS || value
		serializationSteps[94] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 92 /*ScopeNameCS*/, 0);
		// 95: QueryCS::ownedPathName=ScopeNameCS || value
		serializationSteps[95] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 92 /*ScopeNameCS*/, 0);
		// 96: TypeNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[96] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 71 /*PathNameCS*/, 0);
		// 97: TypedTypeRefCS::ownedPathName=PathNameCS || value
		serializationSteps[97] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 71 /*PathNameCS*/, 0);
		// 98: TypeNameExpCS::ownedPatternGuard=ExpCS || value
		serializationSteps[98] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 29 /*ExpCS*/, 0);
		// 99: PatternExpCS::ownedPatternType=TypeExpCS || value
		serializationSteps[99] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 113 /*TypeExpCS*/, 0);
		// 100: GuardPatternCS::ownedPredicates+=PredicateCS || value
		serializationSteps[100] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 73 /*PredicateCS*/, 0);
		// 101: StructuredClassCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[101] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 101 /*StructuralFeatureCS*/, 0);
		// 102: TransformationCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[102] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 101 /*StructuralFeatureCS*/, 0);
		// 103: TopLevelCS::ownedQueries+=QueryCS || value
		serializationSteps[103] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES, 84 /*QueryCS*/, 0);
		// 104: BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value
		serializationSteps[104] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 85 /*RealizedVariableCS*/, 0);
		// 105: AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[105] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 87 /*RoundBracketedClauseCS*/, 0);
		// 106: LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[106] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 87 /*RoundBracketedClauseCS*/, 0);
		// 107: TemplateableElementCS::ownedSignature=TemplateSignatureCS || value
		serializationSteps[107] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 106 /*TemplateSignatureCS*/, 0);
		// 108: AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value
		serializationSteps[108] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 98 /*SquareBracketedClauseCS*/, 0);
		// 109: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value
		serializationSteps[109] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 105 /*TemplateParameterSubstitutionCS*/, 0);
		// 110: StructuredClassCS::ownedSuperTypes+=TypedRefCS || value
		serializationSteps[110] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 122 /*TypedRefCS*/, 0);
		// 111: PredicateOrAssignmentCS::ownedTarget=ExpCS || value
		serializationSteps[111] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, 29 /*ExpCS*/, 0);
		// 112: CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value
		serializationSteps[112] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 96 /*SimpleTargetElementCS*/, 0);
		// 113: TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value
		serializationSteps[113] = createSerializationStepAssigns(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, -1, new int[] { 96/*SimpleTargetElementCS*/,12/*CompoundTargetElementCS*/}, 0);
		// 114: AbstractTransformationCS::ownedTargets+=TargetCS || value
		serializationSteps[114] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 103 /*TargetCS*/, 0);
		// 115: SquareBracketedClauseCS::ownedTerms+=ExpCS || value
		serializationSteps[115] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 29 /*ExpCS*/, 0);
		// 116: IfExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[116] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 29 /*ExpCS*/, 0);
		// 117: IfThenExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[117] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 29 /*ExpCS*/, 0);
		// 118: TopLevelCS::ownedTransformations+=TransformationCS || value
		serializationSteps[118] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 108 /*TransformationCS*/, 0);
		// 119: CollectionLiteralExpCS::ownedType=CollectionTypeCS || value
		serializationSteps[119] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 10 /*CollectionTypeCS*/, 0);
		// 120: CollectionPatternCS::ownedType=CollectionTypeCS || value
		serializationSteps[120] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 10 /*CollectionTypeCS*/, 0);
		// 121: CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value
		serializationSteps[121] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 114 /*TypeExpWithoutMultiplicityCS*/, 0);
		// 122: MapLiteralExpCS::ownedType=MapTypeCS || value
		serializationSteps[122] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 49 /*MapTypeCS*/, 0);
		// 123: NavigatingArgCS::ownedType=TypeExpCS || value
		serializationSteps[123] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 113 /*TypeExpCS*/, 0);
		// 124: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[124] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 117 /*TypeLiteralWithMultiplicityCS*/, 2);
		// 125: VariableCS::ownedType=TypeExpCS || value
		serializationSteps[125] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 113 /*TypeExpCS*/, 0);
		// 126: MapLiteralPartCS::ownedValue=ExpCS || value
		serializationSteps[126] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 29 /*ExpCS*/, 0);
		// 127: MapTypeCS::ownedValueType=TypeExpCS || value
		serializationSteps[127] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 113 /*TypeExpCS*/, 0);
		// 128: LetExpCS::ownedVariables+=LetVariableCS || value
		serializationSteps[128] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 44 /*LetVariableCS*/, 0);
		// 129: PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space
		serializationSteps[129] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, 134 /*UnrestrictedName*/, 7);
		// 130: NavigatingArgCS::prefix=';' || no-space value soft-new-line
		serializationSteps[130] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 8 /* ';' */, 5);
		// 131: NavigatingArgCS::prefix=',' || no-space value soft-space
		serializationSteps[131] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ',' */, 6);
		// 132: NavigatingArgCS::prefix='|' || soft-space value soft-space
		serializationSteps[132] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 26 /* '|' */, 7);
		// 133: ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space
		serializationSteps[133] = createSerializationStepCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, getCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, "UnrestrictedName"), 134, 7);
		// 134: ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space
		serializationSteps[134] = createSerializationStepCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, getCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, "UnrestrictedName"), 134, 7);
		// 135: MappingCS::refines+=UnrestrictedName || soft-space value soft-space
		serializationSteps[135] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.MAPPING_CS__REFINES, getCrossReference(QVTcoreCSPackage.Literals.MAPPING_CS__REFINES, "UnrestrictedName"), 134, 7);
		// 136: CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space
		serializationSteps[136] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, 35 /*Identifier*/, 7);
		// 137: StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[137] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, 99 /*StringLiteral*/, 2);
		// 138: MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space
		serializationSteps[138] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 4 /* '*|+|?' */, 7);
		// 139: BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[139] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 17 /* 'false|true' */, 2);
		// 140: NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[140] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, 55 /*NUMBER_LITERAL*/, 2);
		// 141: SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[141] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, "UnrestrictedName"), 134, 7);
		// 142: MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space
		serializationSteps[142] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, 125 /*UPPER*/, 7);
		// 143: DirectionCS::uses+=UnrestrictedName || soft-space value soft-space
		serializationSteps[143] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__USES, getCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__USES, "UnrestrictedName"), 134, 7);
		// 144: EnumerationLiteralCS::value=SIGNED || soft-space value soft-space
		serializationSteps[144] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, 88 /*SIGNED*/, 7);
		// 145: SimpleTargetElementCS::via?='via' || soft-space value soft-space
		serializationSteps[145] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 25 /* 'via' */, 7);
		// 146: '!serializable' || soft-space value soft-space
		serializationSteps[146] = createSerializationStepKeyword("!serializable", 7);
		// 147: '#' || no-space value no-space
		serializationSteps[147] = createSerializationStepKeyword("#", 4);
		// 148: '&&' || soft-space value soft-space
		serializationSteps[148] = createSerializationStepKeyword("&&", 7);
		// 149: '(' || no-space value no-space
		serializationSteps[149] = createSerializationStepKeyword("(", 4);
		// 150: ')' || no-space value
		serializationSteps[150] = createSerializationStepKeyword(")", 1);
		// 151: '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[151] = createSerializationStepKeyword("*", 2);
		// 152: '*' || soft-space value soft-space
		serializationSteps[152] = createSerializationStepKeyword("*", 7);
		// 153: '++' || soft-space value soft-space
		serializationSteps[153] = createSerializationStepKeyword("++", 7);
		// 154: ',' || no-space value soft-space
		serializationSteps[154] = createSerializationStepKeyword(",", 6);
		// 155: '..' || no-space value no-space
		serializationSteps[155] = createSerializationStepKeyword("..", 4);
		// 156: ':' || soft-space value soft-space
		serializationSteps[156] = createSerializationStepKeyword(":", 7);
		// 157: '::' || no-space value no-space
		serializationSteps[157] = createSerializationStepKeyword("::", 4);
		// 158: ':=' || soft-space value soft-space
		serializationSteps[158] = createSerializationStepKeyword(":=", 7);
		// 159: ';' || no-space value soft-new-line
		serializationSteps[159] = createSerializationStepKeyword(";", 5);
		// 160: '<-' || soft-space value soft-space
		serializationSteps[160] = createSerializationStepKeyword("<-", 7);
		// 161: '=' || soft-space value soft-space
		serializationSteps[161] = createSerializationStepKeyword("=", 7);
		// 162: '?' || soft-space value soft-space
		serializationSteps[162] = createSerializationStepKeyword("?", 7);
		// 163: 'Lambda' || soft-space value soft-space
		serializationSteps[163] = createSerializationStepKeyword("Lambda", 7);
		// 164: 'Tuple' || soft-space value soft-space
		serializationSteps[164] = createSerializationStepKeyword("Tuple", 7);
		// 165: '[' || no-space value no-space
		serializationSteps[165] = createSerializationStepKeyword("[", 4);
		// 166: ']' || no-space value
		serializationSteps[166] = createSerializationStepKeyword("]", 1);
		// 167: 'attribute' || soft-space value soft-space
		serializationSteps[167] = createSerializationStepKeyword("attribute", 7);
		// 168: 'body' || soft-space value soft-space
		serializationSteps[168] = createSerializationStepKeyword("body", 7);
		// 169: 'class' || soft-space value soft-space
		serializationSteps[169] = createSerializationStepKeyword("class", 7);
		// 170: 'datatype' || soft-space value soft-space
		serializationSteps[170] = createSerializationStepKeyword("datatype", 7);
		// 171: 'derivation' || soft-space value soft-space
		serializationSteps[171] = createSerializationStepKeyword("derivation", 7);
		// 172: 'else' || soft-space value soft-space
		serializationSteps[172] = createSerializationStepKeyword("else", 7);
		// 173: 'elseif' || soft-space value soft-space
		serializationSteps[173] = createSerializationStepKeyword("elseif", 7);
		// 174: 'endif' || soft-space value soft-space
		serializationSteps[174] = createSerializationStepKeyword("endif", 7);
		// 175: 'enum' || soft-space value soft-space
		serializationSteps[175] = createSerializationStepKeyword("enum", 7);
		// 176: 'extends' || soft-space value soft-space
		serializationSteps[176] = createSerializationStepKeyword("extends", 7);
		// 177: 'if' || soft-space value soft-space
		serializationSteps[177] = createSerializationStepKeyword("if", 7);
		// 178: 'implementedby' || soft-space value soft-space
		serializationSteps[178] = createSerializationStepKeyword("implementedby", 7);
		// 179: 'import' || soft-space value soft-space
		serializationSteps[179] = createSerializationStepKeyword("import", 7);
		// 180: 'imports' || soft-space value soft-space
		serializationSteps[180] = createSerializationStepKeyword("imports", 7);
		// 181: 'in' || soft-space value soft-space
		serializationSteps[181] = createSerializationStepKeyword("in", 7);
		// 182: 'initial' || soft-space value soft-space
		serializationSteps[182] = createSerializationStepKeyword("initial", 7);
		// 183: 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[183] = createSerializationStepKeyword("invalid", 2);
		// 184: 'iterates' || soft-space value soft-space
		serializationSteps[184] = createSerializationStepKeyword("iterates", 7);
		// 185: 'let' || soft-space value soft-space
		serializationSteps[185] = createSerializationStepKeyword("let", 7);
		// 186: 'literal' || soft-space value soft-space
		serializationSteps[186] = createSerializationStepKeyword("literal", 7);
		// 187: 'map' || soft-space value soft-space
		serializationSteps[187] = createSerializationStepKeyword("map", 7);
		// 188: 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[188] = createSerializationStepKeyword("null", 2);
		// 189: 'operation' || soft-space value soft-space
		serializationSteps[189] = createSerializationStepKeyword("operation", 7);
		// 190: 'package' || soft-space value soft-space
		serializationSteps[190] = createSerializationStepKeyword("package", 7);
		// 191: 'pre' || soft-space value soft-space
		serializationSteps[191] = createSerializationStepKeyword("pre", 7);
		// 192: 'property' || soft-space value soft-space
		serializationSteps[192] = createSerializationStepKeyword("property", 7);
		// 193: 'query' || soft-space value soft-space
		serializationSteps[193] = createSerializationStepKeyword("query", 7);
		// 194: 'realize' || soft-space value soft-space
		serializationSteps[194] = createSerializationStepKeyword("realize", 7);
		// 195: 'refines' || soft-space value soft-space
		serializationSteps[195] = createSerializationStepKeyword("refines", 7);
		// 196: 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[196] = createSerializationStepKeyword("self", 2);
		// 197: 'target' || soft-space value soft-space
		serializationSteps[197] = createSerializationStepKeyword("target", 7);
		// 198: 'then' || soft-space value soft-space
		serializationSteps[198] = createSerializationStepKeyword("then", 7);
		// 199: 'throws' || soft-space value soft-space
		serializationSteps[199] = createSerializationStepKeyword("throws", 7);
		// 200: 'transformation' || soft-space value soft-space
		serializationSteps[200] = createSerializationStepKeyword("transformation", 7);
		// 201: 'uses' || soft-space value soft-space
		serializationSteps[201] = createSerializationStepKeyword("uses", 7);
		// 202: 'where' || soft-space value soft-space
		serializationSteps[202] = createSerializationStepKeyword("where", 7);
		// 203: '{' || soft-space value push soft-new-line
		serializationSteps[203] = createSerializationStepKeyword("{", 9);
		// 204: '|' || soft-space value soft-space
		serializationSteps[204] = createSerializationStepKeyword("|", 7);
		// 205: '|?' || no-space value no-space
		serializationSteps[205] = createSerializationStepKeyword("|?", 4);
		// 206: '}' || pop soft-space value soft-new-line
		serializationSteps[206] = createSerializationStepKeyword("}", 8);
		// 207: V00*1-steps || value
		serializationSteps[207] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 1, 0);
		// 208: V00*1-steps || value
		serializationSteps[208] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 1, 0);
		// 209: V00*1-steps || value
		serializationSteps[209] = createSerializationStepSequence((0/*V0*/ << 4) | 3/*[+]*/, 1, 0);
		// 210: V00*2-steps || value
		serializationSteps[210] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 2, 0);
		// 211: V00*2-steps || value
		serializationSteps[211] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 2, 0);
		// 212: V00*3-steps || value
		serializationSteps[212] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 3, 0);
		// 213: V00*4-steps || value
		serializationSteps[213] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 4, 0);
		// 214: V00*5-steps || value
		serializationSteps[214] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 5, 0);
		// 215: V00*6-steps || value
		serializationSteps[215] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 6, 0);
		// 216: V00*7-steps || value
		serializationSteps[216] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 7, 0);
		// 217: V00*8-steps || value
		serializationSteps[217] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 8, 0);
		// 218: V01*1-steps || value
		serializationSteps[218] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 1, 0);
		// 219: V01*1-steps || value
		serializationSteps[219] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 1, 0);
		// 220: V01*2-steps || value
		serializationSteps[220] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 2, 0);
		// 221: V01*2-steps || value
		serializationSteps[221] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 2, 0);
		// 222: V01*3-steps || value
		serializationSteps[222] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 3, 0);
		// 223: V01*4-steps || value
		serializationSteps[223] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 4, 0);
		// 224: V10*1-steps || value
		serializationSteps[224] = createSerializationStepSequence((10/*V10*/ << 4) | 1/*[?]*/, 1, 0);
		// 225: V02*1-steps || value
		serializationSteps[225] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 1, 0);
		// 226: V02*1-steps || value
		serializationSteps[226] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 1, 0);
		// 227: V02*1-steps || value
		serializationSteps[227] = createSerializationStepSequence((2/*V2*/ << 4) | 3/*[+]*/, 1, 0);
		// 228: V02*2-steps || value
		serializationSteps[228] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 2, 0);
		// 229: V02*2-steps || value
		serializationSteps[229] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 2, 0);
		// 230: V02*3-steps || value
		serializationSteps[230] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 3, 0);
		// 231: V02*4-steps || value
		serializationSteps[231] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 4, 0);
		// 232: V02*5-steps || value
		serializationSteps[232] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 5, 0);
		// 233: V03*1-steps || value
		serializationSteps[233] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 1, 0);
		// 234: V03*1-steps || value
		serializationSteps[234] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 1, 0);
		// 235: V03*1-steps || value
		serializationSteps[235] = createSerializationStepSequence((3/*V3*/ << 4) | 3/*[+]*/, 1, 0);
		// 236: V03*2-steps || value
		serializationSteps[236] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 2, 0);
		// 237: V03*2-steps || value
		serializationSteps[237] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 2, 0);
		// 238: V03*3-steps || value
		serializationSteps[238] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 3, 0);
		// 239: V03*4-steps || value
		serializationSteps[239] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 4, 0);
		// 240: V03*5-steps || value
		serializationSteps[240] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 5, 0);
		// 241: V04*1-steps || value
		serializationSteps[241] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 1, 0);
		// 242: V04*1-steps || value
		serializationSteps[242] = createSerializationStepSequence((4/*V4*/ << 4) | 3/*[+]*/, 1, 0);
		// 243: V04*2-steps || value
		serializationSteps[243] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 2, 0);
		// 244: V04*2-steps || value
		serializationSteps[244] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 2, 0);
		// 245: V04*4-steps || value
		serializationSteps[245] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 4, 0);
		// 246: V04*5-steps || value
		serializationSteps[246] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 5, 0);
		// 247: V04*5-steps || value
		serializationSteps[247] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 5, 0);
		// 248: V05*1-steps || value
		serializationSteps[248] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 1, 0);
		// 249: V05*1-steps || value
		serializationSteps[249] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 1, 0);
		// 250: V05*1-steps || value
		serializationSteps[250] = createSerializationStepSequence((5/*V5*/ << 4) | 3/*[+]*/, 1, 0);
		// 251: V05*2-steps || value
		serializationSteps[251] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 2, 0);
		// 252: V05*4-steps || value
		serializationSteps[252] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 4, 0);
		// 253: V05*5-steps || value
		serializationSteps[253] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 5, 0);
		// 254: V05*5-steps || value
		serializationSteps[254] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 5, 0);
		// 255: V06*1-steps || value
		serializationSteps[255] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 1, 0);
		// 256: V06*2-steps || value
		serializationSteps[256] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 2, 0);
		// 257: V06*2-steps || value
		serializationSteps[257] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 2, 0);
		// 258: V06*4-steps || value
		serializationSteps[258] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 4, 0);
		// 259: V06*5-steps || value
		serializationSteps[259] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 5, 0);
		// 260: V07*1-steps || value
		serializationSteps[260] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 1, 0);
		// 261: V07*1-steps || value
		serializationSteps[261] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 1, 0);
		// 262: V07*1-steps || value
		serializationSteps[262] = createSerializationStepSequence((7/*V7*/ << 4) | 3/*[+]*/, 1, 0);
		// 263: V07*4-steps || value
		serializationSteps[263] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 4, 0);
		// 264: V07*5-steps || value
		serializationSteps[264] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 5, 0);
		// 265: V08*1-steps || value
		serializationSteps[265] = createSerializationStepSequence((8/*V8*/ << 4) | 1/*[?]*/, 1, 0);
		// 266: V08*1-steps || value
		serializationSteps[266] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 1, 0);
		// 267: V08*1-steps || value
		serializationSteps[267] = createSerializationStepSequence((8/*V8*/ << 4) | 3/*[+]*/, 1, 0);
		// 268: V08*5-steps || value
		serializationSteps[268] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 5, 0);
		// 269: V09*1-steps || value
		serializationSteps[269] = createSerializationStepSequence((9/*V9*/ << 4) | 1/*[?]*/, 1, 0);
		// 270: V09*5-steps || value
		serializationSteps[270] = createSerializationStepSequence((9/*V9*/ << 4) | 2/*[*]*/, 5, 0);
		// 271: wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[271] = createSerializationStepWrapper(2);
		// 272: NamedElementCS::name=UnaryOperatorName || soft-space value soft-space
		serializationSteps[272] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 129 /*UnaryOperatorName*/, 7);
		// 273: NamedElementCS::name=UnreservedName || soft-space value soft-space
		serializationSteps[273] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 133 /*UnreservedName*/, 7);
		// 274: NamedElementCS::name=UnrestrictedName || soft-space value soft-space
		serializationSteps[274] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 134 /*UnrestrictedName*/, 7);
		// 275: NamedElementCS::name=BinaryOperatorName || soft-space value soft-space
		serializationSteps[275] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 2 /*BinaryOperatorName*/, 7);
		// 276: NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space
		serializationSteps[276] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 22 /*EnumerationLiteralName*/, 7);
		// 277: NamedElementCS::name=Identifier || soft-space value soft-space
		serializationSteps[277] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 35 /*Identifier*/, 7);
		// 278: RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value
		serializationSteps[278] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 58 /*NavigatingArgCS*/, 0);
		// 279: RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value
		serializationSteps[279] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, -1, new int[] { 61/*NavigatingCommaArgCS*/,62/*NavigatingSemiArgCS*/,60/*NavigatingBarArgCS*/}, 0);
		// 280: PathNameCS::ownedPathElements+=URIFirstPathElementCS || value
		serializationSteps[280] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 127 /*URIFirstPathElementCS*/, 0);
		// 281: PathNameCS::ownedPathElements+=FirstPathElementCS || value
		serializationSteps[281] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 30 /*FirstPathElementCS*/, 0);
		// 282: PathNameCS::ownedPathElements+=NextPathElementCS || value
		serializationSteps[282] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 65 /*NextPathElementCS*/, 0);
		// 283: OperatorExpCS::ownedRight=ExpCS || value
		serializationSteps[283] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 29 /*ExpCS*/, 0);
		// 284: OperatorExpCS::ownedRight=PrefixedLetExpCS || value
		serializationSteps[284] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 75 /*PrefixedLetExpCS*/, 0);
		// 285: OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value
		serializationSteps[285] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 76 /*PrefixedPrimaryExpCS*/, 0);
		// 286: TypedElementCS::ownedType=TypeExpCS || value
		serializationSteps[286] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 113 /*TypeExpCS*/, 0);
		// 287: TypedElementCS::ownedType=TypedMultiplicityRefCS || value
		serializationSteps[287] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 121 /*TypedMultiplicityRefCS*/, 0);
		// 288: PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value
		serializationSteps[288] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 132 /*UnrealizedVariableCS*/, 0);
		// 289: PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value
		serializationSteps[289] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 32 /*GuardVariableCS*/, 0);
		// 290: TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[290] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */, 7);
		// 291: TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[291] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */, 7);
		// 292: TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space
		serializationSteps[292] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */, 7);
		// 293: TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space
		serializationSteps[293] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */, 7);
		// 294: TypedElementCS::qualifiers+='definition' || soft-space value soft-space
		serializationSteps[294] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 15 /* 'definition' */, 7);
		// 295: TypedElementCS::qualifiers+='static' || soft-space value soft-space
		serializationSteps[295] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 23 /* 'static' */, 7);
		// 296: PathElementCS::referredElement=URI || soft-space value soft-space
		serializationSteps[296] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "URI"), 126, 7);
		// 297: PathElementCS::referredElement=UnreservedName || soft-space value soft-space
		serializationSteps[297] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnreservedName"), 133, 7);
		// 298: PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space
		serializationSteps[298] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnrestrictedName"), 134, 7);
	}
}

//	Commented imports ensure Xtend provides a true import allowing unqualified annotated usage
//	import Inject;
//	import NonNull;
//	import Nullable;
//	import DataTypeRuleValue;
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
//	import TerminalRuleValue;
//	import BaseCommentSegmentSupport;
//	import BaseCSPackage;
//	import EssentialOCLCSPackage;
//	import QVTbaseCSPackage;
//	import QVTcoreCSPackage;
//	import Grammar;
//	import GrammarProvider;
