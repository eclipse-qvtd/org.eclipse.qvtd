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
package org.eclipse.qvtd.xtext.qvtcore.serializer;

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
	private final @NonNull GrammarRuleValue @NonNull [] grammarRuleValues = new @NonNull GrammarRuleValue[138];
	private final @NonNull GrammarRuleVector @NonNull [] grammarRuleVectors = new @NonNull GrammarRuleVector[81];
	private final @NonNull SerializationMatchStep @NonNull [] serializationMatchSteps = new @NonNull SerializationMatchStep[396];
	private final @NonNull SerializationMatchTerm @NonNull [] serializationMatchTerms = new @NonNull SerializationMatchTerm[293];
	private final @NonNull SerializationRule @NonNull [] serializationRules = new @NonNull SerializationRule[169];
	private final @NonNull SerializationSegment @NonNull [] @NonNull [] serializationSegments = new @NonNull SerializationSegment @NonNull [26] @NonNull [];
	private final @NonNull SerializationStep @NonNull [] serializationSteps = new @NonNull SerializationStep[314];
	private final @NonNull SubstringStep @NonNull [] substringSteps = new @NonNull SubstringStep[10];
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
		return 147;
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
		return 146;
	}

	@Override
	protected int getLastGlobalSerializationStepLiteralIndex() {
		return 217;
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
					43) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					65) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[1] = new EClassValue(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS,
			createSerializationRules(
				18 /* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			), null
		);
		eClassValues[2] = new EClassValue(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS,
			createSerializationRules(
				135 /* BottomPatternCS-0: '{' '}' */,
				136 /* BottomPatternCS-1: '{' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V0:+] '}' */,
				141 /* BottomPatternCS-6: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				142 /* BottomPatternCS-7: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */,
				143 /* BottomPatternCS-8: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				144 /* BottomPatternCS-9: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */,
				137 /* BottomPatternCS-2: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				138 /* BottomPatternCS-3: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				139 /* BottomPatternCS-4: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				140 /* BottomPatternCS-5: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS,
					31) /* PredicateOrAssignmentCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES,
					37) /* RealizedVariableCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES,
					79) /* UnrealizedVariableCS */
			}
		);
		eClassValues[3] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS,
			createSerializationRules(
				20 /* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
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
				22 /* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */,
				21 /* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[5] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS,
			createSerializationRules(
				23 /* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */,
				71 /* TypeExpCS-4: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS,
					28) /* PatternExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE,
					3) /* CollectionTypeCS */
			}
		);
		eClassValues[6] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS,
			createSerializationRules(
				24 /* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				68 /* TypeExpCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				75 /* TypeLiteralWithMultiplicityCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				132 /* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE,
					62) /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */
			}
		);
		eClassValues[7] = new EClassValue(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS,
			createSerializationRules(
				89 /* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS,
					41) /* SimpleTargetElementCS */
			}
		);
		eClassValues[8] = new EClassValue(EssentialOCLCSPackage.Literals.CONTEXT_CS,
			createSerializationRules(
				36 /* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[9] = new EClassValue(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				25 /* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS,
					40) /* ShadowPartCS */
			}
		);
		eClassValues[10] = new EClassValue(BaseCSPackage.Literals.DATA_TYPE_CS,
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
					52) /* TemplateSignatureCS */
			}
		);
		eClassValues[11] = new EClassValue(QVTcoreCSPackage.Literals.DIRECTION_CS,
			createSerializationRules(
				145 /* DirectionCS-0: (NamedElementCS::name=Identifier)[V0:?] 'imports' DirectionCS::imports+=UnrestrictedName (',' DirectionCS::imports+=UnrestrictedName)[V1:*] ('uses' DirectionCS::uses+=UnrestrictedName (',' DirectionCS::uses+=UnrestrictedName)[V3:*])[V2:?] */
			), null
		);
		eClassValues[12] = new EClassValue(QVTcoreCSPackage.Literals.DOMAIN_CS,
			createSerializationRules(
				153 /* NamedDomainCS-0: (DomainCS::isCheck?='check')[V0:?] (DomainCS::isEnforce?='enforce')[V1:?] DomainCS::direction=UnrestrictedName AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */,
				167 /* UnnamedDomainCS-0: AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */
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
				100 /* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				96 /* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				98 /* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				101 /* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				97 /* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				99 /* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS,
					7) /* EnumerationLiteralCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					52) /* TemplateSignatureCS */
			}
		);
		eClassValues[14] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS,
			createSerializationRules(
				104 /* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				102 /* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				105 /* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				103 /* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			), null
		);
		eClassValues[15] = new EClassValue(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS,
			createSerializationRules(
				125 /* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				126 /* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[16] = new EClassValue(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS,
			createSerializationRules(
				146 /* GuardPatternCS-0: '(' ')' */,
				147 /* GuardPatternCS-1: '(' (GuardPatternCS::ownedPredicates+=PredicateCS)[V0:+] ')' */,
				148 /* GuardPatternCS-2: '(' PatternCS::ownedUnrealizedVariables+=GuardVariableCS (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] ')' */,
				149 /* GuardPatternCS-3: '(' (PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[1] (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] '|' (GuardPatternCS::ownedPredicates+=PredicateCS)[V1:*] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES,
					30) /* PredicateCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES,
					11) /* GuardVariableCS */
			}
		);
		eClassValues[17] = new EClassValue(EssentialOCLCSPackage.Literals.IF_EXP_CS,
			createSerializationRules(
				28 /* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS,
					6) /* ElseIfThenExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[18] = new EClassValue(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS,
			createSerializationRules(
				26 /* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[19] = new EClassValue(BaseCSPackage.Literals.IMPORT_CS,
			createSerializationRules(
				151 /* ImportCS-0: 'import' (NamedElementCS::name=Identifier ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS (ImportCS::isAll?='::' '*')[V1:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME,
					70) /* URIPathNameCS */
			}
		);
		eClassValues[20] = new EClassValue(EssentialOCLCSPackage.Literals.INFIX_EXP_CS,
			createSerializationRules(
				27 /* ExpCS-18: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS NamedElementCS::name=BinaryOperatorName OperatorExpCS::ownedRight=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT,
					73) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[21] = new EClassValue(EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS,
			createSerializationRules(
				29 /* InvalidLiteralExpCS-0: 'invalid' */
			), null
		);
		eClassValues[22] = new EClassValue(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS,
			createSerializationRules(
				30 /* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[23] = new EClassValue(EssentialOCLCSPackage.Literals.LET_EXP_CS,
			createSerializationRules(
				31 /* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES,
					13) /* LetVariableCS */
			}
		);
		eClassValues[24] = new EClassValue(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS,
			createSerializationRules(
				32 /* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					38) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[25] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS,
			createSerializationRules(
				33 /* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
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
				34 /* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS 'with' MapLiteralPartCS::ownedValue=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[27] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_TYPE_CS,
			createSerializationRules(
				35 /* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				69 /* TypeExpCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				76 /* TypeLiteralWithMultiplicityCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				133 /* TypedMultiplicityRefCS-3: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE,
					58) /* TypeExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[28] = new EClassValue(QVTcoreCSPackage.Literals.MAPPING_CS,
			createSerializationRules(
				152 /* MappingCS-0: (MappingCS::isAbstract?='abstract')[V0:?] 'map' (NamedElementCS::name=UnrestrictedName)[V1:?] ('in' MappingCS::ownedInPathName=PathNameCS)[V2:?] ('refines' MappingCS::refines+=UnrestrictedName (',' MappingCS::refines+=UnrestrictedName)[V4:*])[V3:?] '{' (MappingCS::ownedDomains+=NamedDomainCS)[V5:*] ('where' MappingCS::ownedMiddle=UnnamedDomainCS)[V6:?] (MappingCS::ownedComposedMappings+=MappingCS)[V7:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_COMPOSED_MAPPINGS,
					16) /* MappingCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_DOMAINS,
					18) /* NamedDomainCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME,
					27) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE,
					78) /* UnnamedDomainCS */
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
				37 /* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					4) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME,
					27) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					38) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES,
					44) /* SquareBracketedClauseCS */
			}
		);
		eClassValues[32] = new EClassValue(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS,
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
					1) /* CoIteratorVariableCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION,
					76) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[33] = new EClassValue(EssentialOCLCSPackage.Literals.NESTED_EXP_CS,
			createSerializationRules(
				49 /* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[34] = new EClassValue(EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS,
			createSerializationRules(
				50 /* NullLiteralExpCS-0: 'null' */
			), null
		);
		eClassValues[35] = new EClassValue(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS,
			createSerializationRules(
				51 /* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			), null
		);
		eClassValues[36] = new EClassValue(BaseCSPackage.Literals.OPERATION_CS,
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
					43) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS,
					67) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS,
					26) /* ParameterCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					52) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					65) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[37] = new EClassValue(QVTcoreCSPackage.Literals.PARAM_DECLARATION_CS,
			createSerializationRules(
				154 /* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[38] = new EClassValue(BaseCSPackage.Literals.PARAMETER_CS,
			createSerializationRules(
				112 /* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					65) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[39] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_CS,
			createSerializationRules(
				0 /* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */,
				9 /* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */,
				80 /* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			), null
		);
		eClassValues[40] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS,
			createSerializationRules(
				79 /* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */
			), null
		);
		eClassValues[41] = new EClassValue(BaseCSPackage.Literals.PATH_NAME_CS,
			createSerializationRules(
				10 /* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				16 /* UnreservedPathNameCS-0: PathNameCS::ownedPathElements+=NextPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				60 /* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */,
				81 /* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				164 /* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS,
					69) /* FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS */
			}
		);
		eClassValues[42] = new EClassValue(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS,
			createSerializationRules(
				52 /* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[43] = new EClassValue(QVTcoreCSPackage.Literals.PREDICATE_CS,
			createSerializationRules(
				155 /* PredicateCS-0: PredicateCS::ownedCondition=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[44] = new EClassValue(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS,
			createSerializationRules(
				156 /* PredicateOrAssignmentCS-0: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (':=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */,
				157 /* PredicateOrAssignmentCS-1: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (PredicateOrAssignmentCS::isPartial?='+=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[45] = new EClassValue(EssentialOCLCSPackage.Literals.PREFIX_EXP_CS,
			createSerializationRules(
				53 /* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				54 /* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					74) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[46] = new EClassValue(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS,
			createSerializationRules(
				55 /* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				67 /* TypeExpCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				74 /* TypeLiteralWithMultiplicityCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				130 /* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */
			}
		);
		eClassValues[47] = new EClassValue(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS,
			createSerializationRules(
				158 /* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				159 /* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES,
					55) /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					35) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME,
					39) /* ScopeNameCS */
			}
		);
		eClassValues[48] = new EClassValue(QVTcoreCSPackage.Literals.QUERY_CS,
			createSerializationRules(
				160 /* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				161 /* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				162 /* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS,
					25) /* ParamDeclarationCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME,
					39) /* ScopeNameCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[49] = new EClassValue(QVTcoreCSPackage.Literals.REALIZED_VARIABLE_CS,
			createSerializationRules(
				163 /* RealizedVariableCS-0: 'realize' NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[50] = new EClassValue(BaseCSPackage.Literals.REFERENCE_CS,
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
					43) /* SpecificationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					65) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[51] = new EClassValue(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				56 /* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS,
					21) /* NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS */
			}
		);
		eClassValues[52] = new EClassValue(EssentialOCLCSPackage.Literals.SELF_EXP_CS,
			createSerializationRules(
				57 /* SelfExpCS-0: 'self' */
			), null
		);
		eClassValues[53] = new EClassValue(EssentialOCLCSPackage.Literals.SHADOW_PART_CS,
			createSerializationRules(
				59 /* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */,
				58 /* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[54] = new EClassValue(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS,
			createSerializationRules(
				119 /* SimpleTargetElementCS-0: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				121 /* SimpleTargetElementCS-2: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				123 /* SimpleTargetElementCS-4: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				120 /* SimpleTargetElementCS-1: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				122 /* SimpleTargetElementCS-3: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				124 /* SimpleTargetElementCS-5: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */
			), null
		);
		eClassValues[55] = new EClassValue(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				61 /* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[56] = new EClassValue(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS,
			createSerializationRules(
				62 /* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			), null
		);
		eClassValues[57] = new EClassValue(BaseCSPackage.Literals.STRUCTURED_CLASS_CS,
			createSerializationRules(
				127 /* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				128 /* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS,
					24) /* OperationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES,
					47) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					52) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES,
					67) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[58] = new EClassValue(QVTbaseCSPackage.Literals.TARGET_CS,
			createSerializationRules(
				129 /* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS,
					42) /* CompoundTargetElementCS|SimpleTargetElementCS */
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
					51) /* TemplateParameterSubstitutionCS */
			}
		);
		eClassValues[60] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS,
			createSerializationRules(
				12 /* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER,
					80) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */
			}
		);
		eClassValues[61] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS,
			createSerializationRules(
				13 /* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS,
					63) /* TypeParameterCS */
			}
		);
		eClassValues[62] = new EClassValue(QVTcoreCSPackage.Literals.TOP_LEVEL_CS,
			createSerializationRules(
				165 /* TopLevelCS-0: (RootCS::ownedImports+=ImportCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] (TopLevelCS::ownedMappings+=MappingCS)[V3:*] (TopLevelCS::ownedQueries+=QueryCS)[V4:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS,
					12) /* ImportCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS,
					16) /* MappingCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					35) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES,
					36) /* QueryCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS,
					53) /* TransformationCS */
			}
		);
		eClassValues[63] = new EClassValue(QVTcoreCSPackage.Literals.TRANSFORMATION_CS,
			createSerializationRules(
				166 /* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnreservedName '{' (TransformationCS::ownedDirections+=DirectionCS ';')[V1:*] (AbstractTransformationCS::ownedTargets+=TargetCS)[V2:*] (TransformationCS::ownedProperties+=StructuralFeatureCS)[V3:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS,
					5) /* DirectionCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME,
					39) /* ScopeNameCS */,
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES,
					47) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS,
					49) /* TargetCS */
			}
		);
		eClassValues[64] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS,
			createSerializationRules(
				63 /* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS,
					56) /* TupleLiteralPartCS */
			}
		);
		eClassValues[65] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS,
			createSerializationRules(
				64 /* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[66] = new EClassValue(BaseCSPackage.Literals.TUPLE_PART_CS,
			createSerializationRules(
				65 /* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[67] = new EClassValue(BaseCSPackage.Literals.TUPLE_TYPE_CS,
			createSerializationRules(
				66 /* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				72 /* TypeExpCS-5: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				77 /* TypeLiteralWithMultiplicityCS-3: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				134 /* TypedMultiplicityRefCS-4: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS,
					57) /* TuplePartCS */
			}
		);
		eClassValues[68] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS,
			createSerializationRules(
				73 /* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE,
					61) /* TypeLiteralWithMultiplicityCS */
			}
		);
		eClassValues[69] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS,
			createSerializationRules(
				70 /* TypeExpCS-3: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				78 /* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					4) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME,
					27) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[70] = new EClassValue(BaseCSPackage.Literals.TYPE_PARAMETER_CS,
			createSerializationRules(
				14 /* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS,
					67) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[71] = new EClassValue(BaseCSPackage.Literals.TYPED_TYPE_REF_CS,
			createSerializationRules(
				15 /* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */,
				131 /* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING,
					50) /* TemplateBindingCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					17) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME,
					27) /* PathNameCS */
			}
		);
		eClassValues[72] = new EClassValue(EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS,
			createSerializationRules(
				82 /* UnlimitedNaturalLiteralExpCS-0: '*' */
			), null
		);
		eClassValues[73] = new EClassValue(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS,
			createSerializationRules(
				150 /* GuardVariableCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */,
				168 /* UnrealizedVariableCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V0:?] (':=' UnrealizedVariableCS::ownedInitExpression=ExpCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION,
					75) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[74] = new EClassValue(EssentialOCLCSPackage.Literals.VARIABLE_CS,
			createSerializationRules(
				19 /* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					58) /* TypeExpCS */
			}
		);
		eClassValues[75] = new EClassValue(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS,
			createSerializationRules(
				17 /* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS,
					67) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
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
			(0 << 16) | 13	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "attribute" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!id" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[2] = createDataTypeRuleValue(2, "BinaryOperatorName", 13 /* [soft-space, value, soft-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[3] = createParserRuleValue(3, "BooleanLiteralExpCS", -1,
			createSerializationRules(
				18	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* symbol="true" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* symbol="false" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[4] = createParserRuleValue(4, "BottomPatternCS", -1,
			createSerializationRules(
				135	/* BottomPatternCS-0: '{' '}' */,
				136	/* BottomPatternCS-1: '{' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V0:+] '}' */,
				137	/* BottomPatternCS-2: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				138	/* BottomPatternCS-3: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				139	/* BottomPatternCS-4: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				140	/* BottomPatternCS-5: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '|' (BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS)[V1:*] '}' */,
				141	/* BottomPatternCS-6: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				142	/* BottomPatternCS-7: '{' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */,
				143	/* BottomPatternCS-8: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS)[V0:*] '}' */,
				144	/* BottomPatternCS-9: '{' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS (',' BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 19	/* "{" : [value] | [soft-new-line, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [value] */,
			(0 << 16) | 16	/* "|" : [value] | [soft-new-line, pop, value, push] */,
			(0 << 16) | 3	/* ownedConstraints+=PredicateOrAssignmentCS* : [value] | [soft-new-line, value] */,
			(0 << 16) | 10	/* "}" : [value] | [pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 11	/* "{" : [value] | [soft-new-line, value, push] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 3	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [soft-new-line, value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=UnrealizedVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedRealizedVariables+=RealizedVariableCS : [value] | [value] */,
			(0 << 16) | 10	/* "}" : [value] | [pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 11	/* "{" : [value] | [soft-new-line, value, push] */,
			(0 << 16) | 3	/* ownedConstraints+=PredicateOrAssignmentCS+ : [value] | [soft-new-line, value] */,
			(0 << 16) | 10	/* "}" : [value] | [pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {BottomPatternCS} : [value] | [value] */,
			(0 << 16) | 11	/* "{" : [value] | [soft-new-line, value, push] */,
			(0 << 16) | 10	/* "}" : [value] | [pop, value, soft-new-line] */
		);
		grammarRuleValues[5] = createParserRuleValue(5, "ClassCS", 48 /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS */,
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
		grammarRuleValues[6] = createParserRuleValue(6, "CoIteratorVariableCS", -1,
			createSerializationRules(
				19	/* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[7] = createParserRuleValue(7, "CollectionLiteralExpCS", -1,
			createSerializationRules(
				20	/* CollectionLiteralExpCS-0: CollectionLiteralExpCS::ownedType=CollectionTypeCS '{' (CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS (',' CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=CollectionLiteralPartCS : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[8] = createParserRuleValue(8, "CollectionLiteralPartCS", -1,
			createSerializationRules(
				21	/* CollectionLiteralPartCS-0: CollectionLiteralPartCS::ownedExpression=ExpCS ('..' CollectionLiteralPartCS::ownedLastExpression=ExpCS)[V0:?] */,
				22	/* CollectionLiteralPartCS-1: CollectionLiteralPartCS::ownedExpression=PatternExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedLastExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedExpression=PatternExpCS : [value] | [value] */
		);
		grammarRuleValues[9] = createParserRuleValue(9, "CollectionPatternCS", -1,
			createSerializationRules(
				23	/* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedType=CollectionTypeCS : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=PatternExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* "++" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* restVariableName=Identifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[10] = createParserRuleValue(10, "CollectionTypeCS", -1,
			createSerializationRules(
				24	/* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* name=CollectionTypeIdentifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpWithoutMultiplicityCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedCollectionMultiplicity=MultiplicityCS? : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[11] = createDataTypeRuleValue(11, "CollectionTypeIdentifier", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[12] = createParserRuleValue(12, "CompoundTargetElementCS", -1,
			createSerializationRules(
				89	/* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=SimpleTargetElementCS* : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[13] = createParserRuleValue(13, "CurlyBracketedClauseCS", -1,
			createSerializationRules(
				25	/* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {CurlyBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=ShadowPartCS : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[14] = new TerminalRuleValue(14, "DOUBLE_QUOTED_STRING");
		grammarRuleValues[15] = createParserRuleValue(15, "DataTypeCS", -1,
			createSerializationRules(
				90	/* DataTypeCS-0: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] ';' */,
				91	/* DataTypeCS-1: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '!serializable' '}')[V3:?] '{' '}' */,
				92	/* DataTypeCS-2: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] ';' */,
				93	/* DataTypeCS-3: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' DataTypeCS::isSerializable?='serializable' '}')[V3:?] '{' '}' */,
				94	/* DataTypeCS-4: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] ';' */,
				95	/* DataTypeCS-5: (DataTypeCS::isPrimitive?='primitive')[V0:?] 'datatype' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V2:?] ('{' '}')[V3:?] '{' '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* isPrimitive?="primitive"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "datatype" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 13	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[16] = createParserRuleValue(16, "DirectionCS", -1,
			createSerializationRules(
				145	/* DirectionCS-0: (NamedElementCS::name=Identifier)[V0:?] 'imports' DirectionCS::imports+=UnrestrictedName (',' DirectionCS::imports+=UnrestrictedName)[V1:*] ('uses' DirectionCS::uses+=UnrestrictedName (',' DirectionCS::uses+=UnrestrictedName)[V3:*])[V2:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {DirectionCS} : [value] | [value] */,
			(0 << 16) | 13	/* name=Identifier? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "imports" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* imports+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 13	/* imports+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "uses" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* uses+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 13	/* uses+=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[17] = new TerminalRuleValue(17, "ESCAPED_CHARACTER");
		grammarRuleValues[18] = new TerminalRuleValue(18, "ESCAPED_ID");
		grammarRuleValues[19] = createParserRuleValue(19, "ElseIfThenExpCS", -1,
			createSerializationRules(
				26	/* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 25	/* "elseif" : [value] | [soft-new-line, pop, soft-space, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 15	/* "then" : [value] | [pop, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[20] = createParserRuleValue(20, "EnumerationCS", -1,
			createSerializationRules(
				96	/* EnumerationCS-0: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] ';' */,
				97	/* EnumerationCS-1: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '!serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				98	/* EnumerationCS-2: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] ';' */,
				99	/* EnumerationCS-3: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' EnumerationCS::isSerializable?='serializable' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */,
				100	/* EnumerationCS-4: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] ';' */,
				101	/* EnumerationCS-5: 'enum' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V0:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V1:?] ('{' '}')[V2:?] '{' (EnumerationCS::ownedLiterals+=EnumerationLiteralCS)[V3:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "enum" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 13	/* isSerializable?="serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "!serializable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedLiterals+=EnumerationLiteralCS* : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[21] = createParserRuleValue(21, "EnumerationLiteralCS", -1,
			createSerializationRules(
				102	/* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				103	/* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				104	/* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				105	/* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* "literal" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=EnumerationLiteralName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* value=SIGNED : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[22] = createDataTypeRuleValue(22, "EnumerationLiteralName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[23] = createDataTypeRuleValue(23, "EssentialOCLInfixOperatorName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[24] = createDataTypeRuleValue(24, "EssentialOCLNavigationOperatorName", 7 /* [no-space, value, no-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[25] = createDataTypeRuleValue(25, "EssentialOCLReservedKeyword", 13 /* [soft-space, value, soft-space] */,
			4	/* 'else' : [soft-new-line, pop, value, push, soft-space] */,
			5	/* 'endif' : [soft-new-line, pop, value, soft-space] */,
			6	/* 'if' : [soft-new-line, value, push, soft-space] */,
			7	/* 'in' : [soft-space, pop, value, soft-new-line] */,
			8	/* 'let' : [soft-space, value, push] */,
			9	/* 'then' : [pop, soft-space, value, push, soft-space] */);
		grammarRuleValues[26] = createDataTypeRuleValue(26, "EssentialOCLUnaryOperatorName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[27] = createDataTypeRuleValue(27, "EssentialOCLUnreservedName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[28] = createDataTypeRuleValue(28, "EssentialOCLUnrestrictedName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[29] = createParserRuleValue(29, "ExpCS", 75 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
			(0 << 16) | 13	/* name=BinaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrefixedLetExpCS : [value] | [value] */
		);
		grammarRuleValues[30] = createParserRuleValue(30, "FirstPathElementCS", -1,
			createSerializationRules(
				0	/* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 13	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[31] = createParserRuleValue(31, "GuardPatternCS", -1,
			createSerializationRules(
				146	/* GuardPatternCS-0: '(' ')' */,
				147	/* GuardPatternCS-1: '(' (GuardPatternCS::ownedPredicates+=PredicateCS)[V0:+] ')' */,
				148	/* GuardPatternCS-2: '(' PatternCS::ownedUnrealizedVariables+=GuardVariableCS (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] ')' */,
				149	/* GuardPatternCS-3: '(' (PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[1] (',' PatternCS::ownedUnrealizedVariables+=GuardVariableCS)[V0:*] '|' (GuardPatternCS::ownedPredicates+=PredicateCS)[V1:*] ')' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 11	/* "(" : [value] | [soft-new-line, value, push] */,
			(3 << 16) | 0	/* ownedUnrealizedVariables+=GuardVariableCS : [soft-new-line, value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedUnrealizedVariables+=GuardVariableCS : [value] | [value] */,
			(0 << 16) | 16	/* "|" : [value] | [soft-new-line, pop, value, push] */,
			(0 << 16) | 3	/* ownedPredicates+=PredicateCS* : [value] | [soft-new-line, value] */,
			(0 << 16) | 10	/* ")" : [value] | [pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 11	/* "(" : [value] | [soft-new-line, value, push] */,
			(0 << 16) | 3	/* ownedUnrealizedVariables+=GuardVariableCS : [value] | [soft-new-line, value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 3	/* ownedUnrealizedVariables+=GuardVariableCS : [value] | [soft-new-line, value] */,
			(0 << 16) | 17	/* ")" : [value] | [soft-new-line, pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 11	/* "(" : [value] | [soft-new-line, value, push] */,
			(0 << 16) | 3	/* ownedPredicates+=PredicateCS+ : [value] | [soft-new-line, value] */,
			(0 << 16) | 10	/* ")" : [value] | [pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {GuardPatternCS} : [value] | [value] */,
			(0 << 16) | 11	/* "(" : [value] | [soft-new-line, value, push] */,
			(0 << 16) | 10	/* ")" : [value] | [pop, value, soft-new-line] */
		);
		grammarRuleValues[32] = createParserRuleValue(32, "GuardVariableCS", -1,
			createSerializationRules(
				150	/* GuardVariableCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[33] = createDataTypeRuleValue(33, "ID", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[34] = new TerminalRuleValue(34, "INT");
		grammarRuleValues[35] = createDataTypeRuleValue(35, "Identifier", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[36] = createParserRuleValue(36, "IfExpCS", -1,
			createSerializationRules(
				28	/* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 20	/* "if" : [value] | [soft-new-line, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 23	/* "then" : [value] | [pop, soft-space, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedIfThenExpressions+=ElseIfThenExpCS* : [value] | [value] */,
			(0 << 16) | 24	/* "else" : [value] | [soft-new-line, pop, value, push, soft-space] */,
			(0 << 16) | 0	/* ownedElseExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 18	/* "endif" : [value] | [soft-new-line, pop, value, soft-space] */
		);
		grammarRuleValues[37] = createParserRuleValue(37, "ImportCS", -1,
			createSerializationRules(
				151	/* ImportCS-0: 'import' (NamedElementCS::name=Identifier ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS (ImportCS::isAll?='::' '*')[V1:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "import" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* name=Identifier : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=URIPathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* isAll?="::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 13	/* "*" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[38] = createDataTypeRuleValue(38, "InfixOperatorName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[39] = createParserRuleValue(39, "InvalidLiteralExpCS", -1,
			createSerializationRules(
				29	/* InvalidLiteralExpCS-0: 'invalid' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {InvalidLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 13	/* "invalid" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[40] = new TerminalRuleValue(40, "LETTER_CHARACTER");
		grammarRuleValues[41] = createDataTypeRuleValue(41, "LOWER", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[42] = createParserRuleValue(42, "LambdaLiteralExpCS", -1,
			createSerializationRules(
				30	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "Lambda" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpressionCS=ExpCS : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[43] = createParserRuleValue(43, "LetExpCS", -1,
			createSerializationRules(
				31	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 12	/* "let" : [value] | [soft-space, value, push] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedVariables+=LetVariableCS : [value] | [value] */,
			(0 << 16) | 21	/* "in" : [value] | [soft-space, pop, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedInExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[44] = createParserRuleValue(44, "LetVariableCS", -1,
			createSerializationRules(
				32	/* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[45] = new TerminalRuleValue(45, "ML_COMMENT");
		grammarRuleValues[46] = new TerminalRuleValue(46, "ML_SINGLE_QUOTED_STRING");
		grammarRuleValues[47] = createParserRuleValue(47, "MapLiteralExpCS", -1,
			createSerializationRules(
				33	/* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedType=MapTypeCS : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=MapLiteralPartCS : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[48] = createParserRuleValue(48, "MapLiteralPartCS", -1,
			createSerializationRules(
				34	/* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS 'with' MapLiteralPartCS::ownedValue=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedKey=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValue=ExpCS : [value] | [value] */
		);
		grammarRuleValues[49] = createParserRuleValue(49, "MapTypeCS", -1,
			createSerializationRules(
				35	/* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* name="Map" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedKeyType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValueType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[50] = createParserRuleValue(50, "MappingCS", -1,
			createSerializationRules(
				152	/* MappingCS-0: (MappingCS::isAbstract?='abstract')[V0:?] 'map' (NamedElementCS::name=UnrestrictedName)[V1:?] ('in' MappingCS::ownedInPathName=PathNameCS)[V2:?] ('refines' MappingCS::refines+=UnrestrictedName (',' MappingCS::refines+=UnrestrictedName)[V4:*])[V3:?] '{' (MappingCS::ownedDomains+=NamedDomainCS)[V5:*] ('where' MappingCS::ownedMiddle=UnnamedDomainCS)[V6:?] (MappingCS::ownedComposedMappings+=MappingCS)[V7:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {MappingCS} : [value] | [value] */,
			(0 << 16) | 13	/* isAbstract?="abstract"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "map" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "refines" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* refines+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 13	/* refines+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedDomains+=NamedDomainCS* : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "where" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedMiddle=UnnamedDomainCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedComposedMappings+=MappingCS* : [value] | [value] */,
			(0 << 16) | 10	/* "}" : [value] | [pop, value, soft-new-line] */
		);
		grammarRuleValues[51] = createParserRuleValue(51, "Model", -1,
			createSerializationRules(
				36	/* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			(0 << 16) | 2	/* ownedExpression=ExpCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[52] = createParserRuleValue(52, "MultiplicityBoundsCS", -1,
			createSerializationRules(
				1	/* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* lowerBound=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 13	/* upperBound=UPPER : [value] | [soft-space, value, soft-space] */
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
			(0 << 16) | 7	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityBoundsCS : [value] | [value] */,
			(0 << 16) | 0	/* MultiplicityStringCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 7	/* "|?" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 7	/* isNullFree?="|1" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[54] = createParserRuleValue(54, "MultiplicityStringCS", -1,
			createSerializationRules(
				8	/* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			),
			(0 << 16) | 13	/* stringBounds=("*"|"+"|"?") : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[55] = createDataTypeRuleValue(55, "NUMBER_LITERAL", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[56] = createParserRuleValue(56, "NameExpCS", -1,
			createSerializationRules(
				37	/* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedSquareBracketedClauses+=SquareBracketedClauseCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedRoundBracketedClause=RoundBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* isPre?="@" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "pre" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[57] = createParserRuleValue(57, "NamedDomainCS", -1,
			createSerializationRules(
				153	/* NamedDomainCS-0: (DomainCS::isCheck?='check')[V0:?] (DomainCS::isEnforce?='enforce')[V1:?] DomainCS::direction=UnrestrictedName AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* isCheck?="check"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* isEnforce?="enforce"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* direction=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedGuardPattern=GuardPatternCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedBottomPattern=BottomPatternCS : [value] | [value] */
		);
		grammarRuleValues[58] = createParserRuleValue(58, "NavigatingArgCS", -1,
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
			(0 << 16) | 13	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 13	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[59] = createParserRuleValue(59, "NavigatingArgExpCS", 76 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[60] = createParserRuleValue(60, "NavigatingBarArgCS", -1,
			createSerializationRules(
				43	/* NavigatingBarArgCS-0: NavigatingArgCS::prefix='|' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* prefix="|" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[61] = createParserRuleValue(61, "NavigatingCommaArgCS", -1,
			createSerializationRules(
				44	/* NavigatingCommaArgCS-0: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS ':' NavigatingArgCS::ownedType=TypeExpCS ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V0:?] ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?] */,
				45	/* NavigatingCommaArgCS-1: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS)[V0:?] ('with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS)[V1:?] 'in' NavigatingArgCS::ownedInitExpression=ExpCS */,
				46	/* NavigatingCommaArgCS-2: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS 'with' NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V0:?] */,
				47	/* NavigatingCommaArgCS-3: NavigatingArgCS::prefix=',' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 9	/* prefix="," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives? : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* "with" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCoIterator=CoIteratorVariableCS : [value] | [value] */,
			(0 << 16) | 13	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[62] = createParserRuleValue(62, "NavigatingSemiArgCS", -1,
			createSerializationRules(
				48	/* NavigatingSemiArgCS-0: NavigatingArgCS::prefix=';' NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS (':' NavigatingArgCS::ownedType=TypeExpCS ('=' NavigatingArgCS::ownedInitExpression=ExpCS)[V1:?])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 8	/* prefix=";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedNameExpression=NavigatingArgExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[63] = createDataTypeRuleValue(63, "NavigationOperatorName", 13 /* [soft-space, value, soft-space] */,
			0	/* '->' : [no-space, value, no-space] */,
			1	/* '.' : [no-space, value, no-space] */,
			2	/* '?->' : [no-space, value, no-space] */,
			3	/* '?.' : [no-space, value, no-space] */);
		grammarRuleValues[64] = createParserRuleValue(64, "NestedExpCS", -1,
			createSerializationRules(
				49	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 5	/* "(" : [value] | [value, no-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[65] = createParserRuleValue(65, "NextPathElementCS", -1,
			createSerializationRules(
				9	/* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */
			),
			(0 << 16) | 13	/* referredElement=UnreservedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[66] = createParserRuleValue(66, "NullLiteralExpCS", -1,
			createSerializationRules(
				50	/* NullLiteralExpCS-0: 'null' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {NullLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 13	/* "null" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[67] = createParserRuleValue(67, "NumberLiteralExpCS", -1,
			createSerializationRules(
				51	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			),
			(0 << 16) | 2	/* symbol=NUMBER_LITERAL : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[68] = createParserRuleValue(68, "OperationCS", -1,
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
			(0 << 16) | 13	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "operation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=ParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "throws" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExceptions+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 13	/* "body" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedBodyExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[69] = createParserRuleValue(69, "ParamDeclarationCS", -1,
			createSerializationRules(
				154	/* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[70] = createParserRuleValue(70, "ParameterCS", -1,
			createSerializationRules(
				112	/* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[71] = createParserRuleValue(71, "PathNameCS", -1,
			createSerializationRules(
				10	/* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 7	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[72] = createParserRuleValue(72, "PatternExpCS", -1,
			createSerializationRules(
				52	/* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* patternVariableName=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatternType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[73] = createParserRuleValue(73, "PredicateCS", -1,
			createSerializationRules(
				155	/* PredicateCS-0: PredicateCS::ownedCondition=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[74] = createParserRuleValue(74, "PredicateOrAssignmentCS", -1,
			createSerializationRules(
				156	/* PredicateOrAssignmentCS-0: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (':=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */,
				157	/* PredicateOrAssignmentCS-1: (PredicateOrAssignmentCS::isDefault?='default')[V0:?] PredicateOrAssignmentCS::ownedTarget=ExpCS (PredicateOrAssignmentCS::isPartial?='+=' PredicateOrAssignmentCS::ownedInitExpression=ExpCS)[V1:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* isDefault?="default"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedTarget=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* isPartial?="+=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[75] = createParserRuleValue(75, "PrefixedLetExpCS", 33 /* LetExpCS|PrefixedLetExpCS */,
			createSerializationRules(
				31	/* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */,
				53	/* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PrefixExpCS} : [value] | [value] */,
			(0 << 16) | 13	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedLetExpCS : [value] | [value] */,
			(0 << 16) | 0	/* LetExpCS : [value] | [value] */
		);
		grammarRuleValues[76] = createParserRuleValue(76, "PrefixedPrimaryExpCS", 73 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
			(0 << 16) | 13	/* name=UnaryOperatorName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedRight=PrefixedPrimaryExpCS : [value] | [value] */,
			(0 << 16) | 0	/* PrimaryExpCS : [value] | [value] */
		);
		grammarRuleValues[77] = createParserRuleValue(77, "PrimaryExpCS", 72 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[78] = createParserRuleValue(78, "PrimitiveLiteralExpCS", 71 /* BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[79] = createParserRuleValue(79, "PrimitiveTypeCS", -1,
			createSerializationRules(
				55	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */
			),
			(0 << 16) | 13	/* name=PrimitiveTypeIdentifier : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[80] = createDataTypeRuleValue(80, "PrimitiveTypeIdentifier", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[81] = createDataTypeRuleValue(81, "QVTbaseUnrestrictedName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[82] = createDataTypeRuleValue(82, "QVTcoreUnrestrictedName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[83] = createParserRuleValue(83, "QualifiedPackageCS", -1,
			createSerializationRules(
				158	/* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				159	/* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "package" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS? : [value] | [value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* nsPrefix=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* nsURI=URI : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 6	/* ownedPackages+=QualifiedPackageCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 6	/* ownedClasses+=(ClassCS|TransformationCS) : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[84] = createParserRuleValue(84, "QueryCS", -1,
			createSerializationRules(
				160	/* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				161	/* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				162	/* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' QueryCS::ownedPathName=ScopeNameCS NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* isTransient?="transient"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "query" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS : [value] | [value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParameters+=ParamDeclarationCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=ParamDeclarationCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 10	/* "}" : [value] | [pop, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* "implementedby" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* implementation=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[85] = createParserRuleValue(85, "RealizedVariableCS", -1,
			createSerializationRules(
				163	/* RealizedVariableCS-0: 'realize' NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "realize" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[86] = createParserRuleValue(86, "ReferenceCS", -1,
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
			(0 << 16) | 13	/* qualifiers+="static" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="definition"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* qualifiers+="definition" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="static"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "property" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "#" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 13	/* referredOpposite=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypedMultiplicityRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* default=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group+ : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* qualifiers+="composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!composes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!derived" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!ordered" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!readonly" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!resolve" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!transient" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!unique" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!unsettable" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* qualifiers+="!volatile" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* ","? : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* "initial" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* "derivation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* UnrestrictedName? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedDefaultExpressions+=SpecificationCS? : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[87] = createParserRuleValue(87, "RoundBracketedClauseCS", -1,
			createSerializationRules(
				56	/* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {RoundBracketedClauseCS} : [value] | [value] */,
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=NavigatingArgCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)* : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[88] = createDataTypeRuleValue(88, "SIGNED", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[89] = new TerminalRuleValue(89, "SIMPLE_ID");
		grammarRuleValues[90] = new TerminalRuleValue(90, "SINGLE_QUOTED_STRING");
		grammarRuleValues[91] = new TerminalRuleValue(91, "SL_COMMENT");
		grammarRuleValues[92] = createParserRuleValue(92, "ScopeNameCS", -1,
			createSerializationRules(
				164	/* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 7	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */,
			(0 << 16) | 7	/* "::" : [value] | [no-space, value, no-space] */
		);
		grammarRuleValues[93] = createParserRuleValue(93, "SelfExpCS", -1,
			createSerializationRules(
				57	/* SelfExpCS-0: 'self' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {SelfExpCS} : [value] | [value] */,
			(0 << 16) | 13	/* "self" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[94] = createParserRuleValue(94, "ShadowPartCS", -1,
			createSerializationRules(
				58	/* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */,
				59	/* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* referredProperty=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=(ExpCS|PatternExpCS) : [value] | [value] */,
			(0 << 16) | 0	/* ownedInitExpression=StringLiteralExpCS : [value] | [value] */
		);
		grammarRuleValues[95] = createParserRuleValue(95, "SimplePathNameCS", -1,
			createSerializationRules(
				60	/* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */
			),
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */
		);
		grammarRuleValues[96] = createParserRuleValue(96, "SimpleTargetElementCS", -1,
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
			(0 << 16) | 13	/* input?="input" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* output?="output" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* via?="via" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* typedModel=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "iterates" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 13	/* iterates+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[97] = createParserRuleValue(97, "SpecificationCS", -1,
			createSerializationRules(
				125	/* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				126	/* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 13	/* exprString=UNQUOTED_STRING : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[98] = createParserRuleValue(98, "SquareBracketedClauseCS", -1,
			createSerializationRules(
				61	/* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* "[" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedTerms+=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* "]" : [value] | [no-space, value] */
		);
		grammarRuleValues[99] = createDataTypeRuleValue(99, "StringLiteral", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[100] = createParserRuleValue(100, "StringLiteralExpCS", -1,
			createSerializationRules(
				62	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			),
			(0 << 16) | 2	/* segments+=StringLiteral+ : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[101] = createParserRuleValue(101, "StructuralFeatureCS", 47 /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
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
		grammarRuleValues[102] = createParserRuleValue(102, "StructuredClassCS", -1,
			createSerializationRules(
				127	/* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				128	/* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* isAbstract?="abstract"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* "class" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSignature=TemplateSignatureCS? : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedSuperTypes+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* instanceClassName=SINGLE_QUOTED_STRING : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 13	/* isInterface?="interface"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedOperations+=OperationCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedProperties+=StructuralFeatureCS : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[103] = createParserRuleValue(103, "TargetCS", -1,
			createSerializationRules(
				129	/* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "target" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)* : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */,
			(0 << 16) | 8	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[104] = createParserRuleValue(104, "TemplateBindingCS", -1,
			createSerializationRules(
				11	/* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedSubstitutions+=TemplateParameterSubstitutionCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
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
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParameters+=TypeParameterCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[107] = createParserRuleValue(107, "TopLevelCS", -1,
			createSerializationRules(
				165	/* TopLevelCS-0: (RootCS::ownedImports+=ImportCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] (TopLevelCS::ownedMappings+=MappingCS)[V3:*] (TopLevelCS::ownedQueries+=QueryCS)[V4:*] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(4 << 16) | 0	/* ownedImports+=ImportCS* : [value, half-new-line] | [value] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 6	/* ownedPackages+=QualifiedPackageCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 6	/* ownedTransformations+=TransformationCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 6	/* ownedMappings+=MappingCS : [value] | [half-new-line, value, half-new-line] */,
			(0 << 16) | 6	/* ownedQueries+=QueryCS : [value] | [half-new-line, value, half-new-line] */
		);
		grammarRuleValues[108] = createParserRuleValue(108, "TransformationCS", -1,
			createSerializationRules(
				166	/* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnreservedName '{' (TransformationCS::ownedDirections+=DirectionCS ';')[V1:*] (AbstractTransformationCS::ownedTargets+=TargetCS)[V2:*] (TransformationCS::ownedProperties+=StructuralFeatureCS)[V3:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "transformation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS? : [value] | [value] */,
			(0 << 16) | 13	/* name=UnreservedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 0	/* ownedDirections+=DirectionCS : [value] | [value] */,
			(0 << 16) | 8	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargets+=TargetCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedProperties+=StructuralFeatureCS* : [value] | [value] */,
			(0 << 16) | 10	/* "}" : [value] | [pop, value, soft-new-line] */
		);
		grammarRuleValues[109] = createParserRuleValue(109, "TupleLiteralExpCS", -1,
			createSerializationRules(
				63	/* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* "Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 8	/* "," : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* ownedParts+=TupleLiteralPartCS : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[110] = createParserRuleValue(110, "TupleLiteralPartCS", -1,
			createSerializationRules(
				64	/* TupleLiteralPartCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 13	/* "=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[111] = createParserRuleValue(111, "TuplePartCS", -1,
			createSerializationRules(
				65	/* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[112] = createParserRuleValue(112, "TupleTypeCS", -1,
			createSerializationRules(
				66	/* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 13	/* name="Tuple" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 9	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedParts+=TuplePartCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[113] = createParserRuleValue(113, "TypeExpCS", -1,
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
		grammarRuleValues[114] = createParserRuleValue(114, "TypeExpWithoutMultiplicityCS", 62 /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
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
		grammarRuleValues[115] = createParserRuleValue(115, "TypeLiteralCS", 60 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS */,
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
		grammarRuleValues[116] = createParserRuleValue(116, "TypeLiteralExpCS", -1,
			createSerializationRules(
				73	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			(0 << 16) | 2	/* ownedType=TypeLiteralWithMultiplicityCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[117] = createParserRuleValue(117, "TypeLiteralWithMultiplicityCS", -1,
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
		grammarRuleValues[118] = createParserRuleValue(118, "TypeNameExpCS", -1,
			createSerializationRules(
				78	/* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 0	/* ownedCurlyBracketedClause=CurlyBracketedClauseCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 22	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedPatternGuard=ExpCS : [value] | [value] */,
			(0 << 16) | 14	/* "}" : [value] | [pop, soft-new-line, value, soft-new-line] */
		);
		grammarRuleValues[119] = createParserRuleValue(119, "TypeParameterCS", -1,
			createSerializationRules(
				14	/* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "extends" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 13	/* "&&" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExtends+=TypedRefCS : [value] | [value] */
		);
		grammarRuleValues[120] = createParserRuleValue(120, "TypeRefCS", 80 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
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
		grammarRuleValues[121] = createParserRuleValue(121, "TypedMultiplicityRefCS", -1,
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
		grammarRuleValues[122] = createParserRuleValue(122, "TypedRefCS", 67 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
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
		grammarRuleValues[123] = createParserRuleValue(123, "TypedTypeRefCS", -1,
			createSerializationRules(
				15	/* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedBinding=TemplateBindingCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[124] = new TerminalRuleValue(124, "UNQUOTED_STRING");
		grammarRuleValues[125] = createDataTypeRuleValue(125, "UPPER", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[126] = createDataTypeRuleValue(126, "URI", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[127] = createParserRuleValue(127, "URIFirstPathElementCS", -1,
			createSerializationRules(
				79	/* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */,
				80	/* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 13	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {PathElementWithURICS} : [value] | [value] */,
			(0 << 16) | 13	/* referredElement=URI : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[128] = createParserRuleValue(128, "URIPathNameCS", -1,
			createSerializationRules(
				81	/* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=URIFirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 7	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[129] = createDataTypeRuleValue(129, "UnaryOperatorName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[130] = createParserRuleValue(130, "UnlimitedNaturalLiteralExpCS", -1,
			createSerializationRules(
				82	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {UnlimitedNaturalLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 13	/* "*" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[131] = createParserRuleValue(131, "UnnamedDomainCS", -1,
			createSerializationRules(
				167	/* UnnamedDomainCS-0: AreaCS::ownedGuardPattern=GuardPatternCS AreaCS::ownedBottomPattern=BottomPatternCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {DomainCS} : [value] | [value] */,
			(0 << 16) | 0	/* ownedGuardPattern=GuardPatternCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedBottomPattern=BottomPatternCS : [value] | [value] */
		);
		grammarRuleValues[132] = createParserRuleValue(132, "UnrealizedVariableCS", -1,
			createSerializationRules(
				168	/* UnrealizedVariableCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V0:?] (':=' UnrealizedVariableCS::ownedInitExpression=ExpCS)[V1:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 13	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInitExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[133] = createDataTypeRuleValue(133, "UnreservedName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[134] = createParserRuleValue(134, "UnreservedPathNameCS", -1,
			createSerializationRules(
				16	/* UnreservedPathNameCS-0: PathNameCS::ownedPathElements+=NextPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 7	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[135] = createDataTypeRuleValue(135, "UnrestrictedName", 13 /* [soft-space, value, soft-space] */);
		grammarRuleValues[136] = new TerminalRuleValue(136, "WS");
		grammarRuleValues[137] = createParserRuleValue(137, "WildcardTypeRefCS", -1,
			createSerializationRules(
				17	/* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* {WildcardTypeRefCS} : [value] | [value] */,
			(0 << 16) | 13	/* "?" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 13	/* "extends" : [value] | [soft-space, value, soft-space] */,
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
		// 22: NextPathElementCS
		grammarRuleVectors[22] = new GrammarRuleVector(0x0L,0x2L);
		// 23: FirstPathElementCS|NextPathElementCS
		grammarRuleVectors[23] = new GrammarRuleVector(0x40000000L,0x2L);
		// 24: OperationCS
		grammarRuleVectors[24] = new GrammarRuleVector(0x0L,0x10L);
		// 25: ParamDeclarationCS
		grammarRuleVectors[25] = new GrammarRuleVector(0x0L,0x20L);
		// 26: ParameterCS
		grammarRuleVectors[26] = new GrammarRuleVector(0x0L,0x40L);
		// 27: PathNameCS
		grammarRuleVectors[27] = new GrammarRuleVector(0x0L,0x80L);
		// 28: PatternExpCS
		grammarRuleVectors[28] = new GrammarRuleVector(0x0L,0x100L);
		// 29: ExpCS|PatternExpCS
		grammarRuleVectors[29] = new GrammarRuleVector(0x20000000L,0x100L);
		// 30: PredicateCS
		grammarRuleVectors[30] = new GrammarRuleVector(0x0L,0x200L);
		// 31: PredicateOrAssignmentCS
		grammarRuleVectors[31] = new GrammarRuleVector(0x0L,0x400L);
		// 32: PrefixedLetExpCS
		grammarRuleVectors[32] = new GrammarRuleVector(0x0L,0x800L);
		// 33: LetExpCS|PrefixedLetExpCS
		grammarRuleVectors[33] = new GrammarRuleVector(0x80000000000L,0x800L);
		// 34: PrefixedPrimaryExpCS
		grammarRuleVectors[34] = new GrammarRuleVector(0x0L,0x1000L);
		// 35: QualifiedPackageCS
		grammarRuleVectors[35] = new GrammarRuleVector(0x0L,0x80000L);
		// 36: QueryCS
		grammarRuleVectors[36] = new GrammarRuleVector(0x0L,0x100000L);
		// 37: RealizedVariableCS
		grammarRuleVectors[37] = new GrammarRuleVector(0x0L,0x200000L);
		// 38: RoundBracketedClauseCS
		grammarRuleVectors[38] = new GrammarRuleVector(0x0L,0x800000L);
		// 39: ScopeNameCS
		grammarRuleVectors[39] = new GrammarRuleVector(0x0L,0x10000000L);
		// 40: ShadowPartCS
		grammarRuleVectors[40] = new GrammarRuleVector(0x0L,0x40000000L);
		// 41: SimpleTargetElementCS
		grammarRuleVectors[41] = new GrammarRuleVector(0x0L,0x100000000L);
		// 42: CompoundTargetElementCS|SimpleTargetElementCS
		grammarRuleVectors[42] = new GrammarRuleVector(0x1000L,0x100000000L);
		// 43: SpecificationCS
		grammarRuleVectors[43] = new GrammarRuleVector(0x0L,0x200000000L);
		// 44: SquareBracketedClauseCS
		grammarRuleVectors[44] = new GrammarRuleVector(0x0L,0x400000000L);
		// 45: StringLiteralExpCS
		grammarRuleVectors[45] = new GrammarRuleVector(0x0L,0x1000000000L);
		// 46: StructuralFeatureCS
		grammarRuleVectors[46] = new GrammarRuleVector(0x0L,0x2000000000L);
		// 47: AttributeCS|ReferenceCS|StructuralFeatureCS
		grammarRuleVectors[47] = new GrammarRuleVector(0x2L,0x2000400000L);
		// 48: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS
		grammarRuleVectors[48] = new GrammarRuleVector(0x108020L,0x4000000000L);
		// 49: TargetCS
		grammarRuleVectors[49] = new GrammarRuleVector(0x0L,0x8000000000L);
		// 50: TemplateBindingCS
		grammarRuleVectors[50] = new GrammarRuleVector(0x0L,0x10000000000L);
		// 51: TemplateParameterSubstitutionCS
		grammarRuleVectors[51] = new GrammarRuleVector(0x0L,0x20000000000L);
		// 52: TemplateSignatureCS
		grammarRuleVectors[52] = new GrammarRuleVector(0x0L,0x40000000000L);
		// 53: TransformationCS
		grammarRuleVectors[53] = new GrammarRuleVector(0x0L,0x100000000000L);
		// 54: ClassCS|TransformationCS
		grammarRuleVectors[54] = new GrammarRuleVector(0x20L,0x100000000000L);
		// 55: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS
		grammarRuleVectors[55] = new GrammarRuleVector(0x108020L,0x104000000000L);
		// 56: TupleLiteralPartCS
		grammarRuleVectors[56] = new GrammarRuleVector(0x0L,0x400000000000L);
		// 57: TuplePartCS
		grammarRuleVectors[57] = new GrammarRuleVector(0x0L,0x800000000000L);
		// 58: TypeExpCS
		grammarRuleVectors[58] = new GrammarRuleVector(0x0L,0x2000000000000L);
		// 59: TypeExpWithoutMultiplicityCS
		grammarRuleVectors[59] = new GrammarRuleVector(0x0L,0x4000000000000L);
		// 60: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS
		grammarRuleVectors[60] = new GrammarRuleVector(0x2000000000400L,0x9000000008000L);
		// 61: TypeLiteralWithMultiplicityCS
		grammarRuleVectors[61] = new GrammarRuleVector(0x0L,0x20000000000000L);
		// 62: CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS
		grammarRuleVectors[62] = new GrammarRuleVector(0x2000000000600L,0x4d000000008000L);
		// 63: TypeParameterCS
		grammarRuleVectors[63] = new GrammarRuleVector(0x0L,0x80000000000000L);
		// 64: TypeRefCS
		grammarRuleVectors[64] = new GrammarRuleVector(0x0L,0x100000000000000L);
		// 65: TypedMultiplicityRefCS
		grammarRuleVectors[65] = new GrammarRuleVector(0x0L,0x200000000000000L);
		// 66: TypedRefCS
		grammarRuleVectors[66] = new GrammarRuleVector(0x0L,0x400000000000000L);
		// 67: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS
		grammarRuleVectors[67] = new GrammarRuleVector(0x2000000000400L,0xc09000000008000L);
		// 68: NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[68] = new GrammarRuleVector(0x0L,0x8000000000000002L);
		// 69: FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[69] = new GrammarRuleVector(0x40000000L,0x8000000000000002L);
		// 70: URIPathNameCS
		grammarRuleVectors[70] = new GrammarRuleVector(0x0L,0x0L,0x1L);
		// 71: BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[71] = new GrammarRuleVector(0x8000000008L,0x100000400cL,0x4L);
		// 72: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[72] = new GrammarRuleVector(0x100849000000088L,0x1020102000600dL,0x4L);
		// 73: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[73] = new GrammarRuleVector(0x100849000000088L,0x1020102000700dL,0x4L);
		// 74: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[74] = new GrammarRuleVector(0x1008c9000000088L,0x1020102000780dL,0x4L);
		// 75: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[75] = new GrammarRuleVector(0x1008c9020000088L,0x1020102000780dL,0x4L);
		// 76: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[76] = new GrammarRuleVector(0x9008c9020000088L,0x1020102000780dL,0x4L);
		// 77: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[77] = new GrammarRuleVector(0x1008c9020000088L,0x1020102000790dL,0x4L);
		// 78: UnnamedDomainCS
		grammarRuleVectors[78] = new GrammarRuleVector(0x0L,0x0L,0x8L);
		// 79: UnrealizedVariableCS
		grammarRuleVectors[79] = new GrammarRuleVector(0x0L,0x0L,0x10L);
		// 80: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS
		grammarRuleVectors[80] = new GrammarRuleVector(0x2000000000400L,0xd09000000008000L,0x200L);
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
		// 130: assign V0 = (|PathNameCS::ownedPathElements| - 1)
		serializationMatchSteps[130] = createMatchStep_Assign(0, 248);
		// 131: assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1)
		serializationMatchSteps[131] = createMatchStep_Assign(0, 249);
		// 132: assign V0 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[132] = createMatchStep_Assign(0, 263);
		// 133: assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchSteps[133] = createMatchStep_Assign(0, 268);
		// 134: assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchSteps[134] = createMatchStep_Assign(0, 273);
		// 135: assign V0 = (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchSteps[135] = createMatchStep_Assign(0, 275);
		// 136: assign V0 = (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[136] = createMatchStep_Assign(0, 276);
		// 137: assign V0 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[137] = createMatchStep_Assign(0, 279);
		// 138: assign V0 = (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchSteps[138] = createMatchStep_Assign(0, 283);
		// 139: assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchSteps[139] = createMatchStep_Assign(0, 8);
		// 140: assign V0 = |AbstractTransformationCS::ownedPathName|
		serializationMatchSteps[140] = createMatchStep_Assign(0, 9);
		// 141: assign V0 = |BottomPatternCS::ownedConstraints|
		serializationMatchSteps[141] = createMatchStep_Assign(0, 14);
		// 142: assign V0 = |BottomPatternCS::ownedRealizedVariables|
		serializationMatchSteps[142] = createMatchStep_Assign(0, 16);
		// 143: assign V0 = |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchSteps[143] = createMatchStep_Assign(0, 22);
		// 144: assign V0 = |CollectionPatternCS::restVariableName|
		serializationMatchSteps[144] = createMatchStep_Assign(0, 26);
		// 145: assign V0 = |CollectionTypeCS::ownedType|
		serializationMatchSteps[145] = createMatchStep_Assign(0, 29);
		// 146: assign V0 = |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchSteps[146] = createMatchStep_Assign(0, 30);
		// 147: assign V0 = |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchSteps[147] = createMatchStep_Assign(0, 34);
		// 148: assign V0 = |DomainCS::isCheck.'check'|
		serializationMatchSteps[148] = createMatchStep_Assign(0, 40);
		// 149: assign V0 = |EnumerationLiteralCS::value|
		serializationMatchSteps[149] = createMatchStep_Assign(0, 48);
		// 150: assign V0 = |GuardPatternCS::ownedPredicates|
		serializationMatchSteps[150] = createMatchStep_Assign(0, 50);
		// 151: assign V0 = |IfExpCS::ownedIfThenExpressions|
		serializationMatchSteps[151] = createMatchStep_Assign(0, 54);
		// 152: assign V0 = |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchSteps[152] = createMatchStep_Assign(0, 66);
		// 153: assign V0 = |MapTypeCS::ownedValueType|
		serializationMatchSteps[153] = createMatchStep_Assign(0, 73);
		// 154: assign V0 = |MappingCS::isAbstract.'abstract'|
		serializationMatchSteps[154] = createMatchStep_Assign(0, 74);
		// 155: assign V0 = |MultiplicityBoundsCS::upperBound|
		serializationMatchSteps[155] = createMatchStep_Assign(0, 82);
		// 156: assign V0 = |NamedElementCS::name|
		serializationMatchSteps[156] = createMatchStep_Assign(0, 86);
		// 157: assign V0 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[157] = createMatchStep_Assign(0, 87);
		// 158: assign V0 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[158] = createMatchStep_Assign(0, 88);
		// 159: assign V0 = |NavigatingArgCS::ownedType|
		serializationMatchSteps[159] = createMatchStep_Assign(0, 90);
		// 160: assign V0 = |PatternCS::ownedUnrealizedVariables|
		serializationMatchSteps[160] = createMatchStep_Assign(0, 109);
		// 161: assign V0 = |PatternExpCS::patternVariableName|
		serializationMatchSteps[161] = createMatchStep_Assign(0, 111);
		// 162: assign V0 = |PredicateOrAssignmentCS::isDefault.'default'|
		serializationMatchSteps[162] = createMatchStep_Assign(0, 113);
		// 163: assign V0 = |QualifiedPackageCS::ownedPathName|
		serializationMatchSteps[163] = createMatchStep_Assign(0, 119);
		// 164: assign V0 = |QueryCS::isTransient.'transient'|
		serializationMatchSteps[164] = createMatchStep_Assign(0, 120);
		// 165: assign V0 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[165] = createMatchStep_Assign(0, 126);
		// 166: assign V0 = |RootCS::ownedImports|
		serializationMatchSteps[166] = createMatchStep_Assign(0, 127);
		// 167: assign V0 = |SimpleTargetElementCS::iterates|
		serializationMatchSteps[167] = createMatchStep_Assign(0, 133);
		// 168: assign V0 = |StringLiteralExpCS::segments|
		serializationMatchSteps[168] = createMatchStep_Assign(0, 141);
		// 169: assign V0 = |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchSteps[169] = createMatchStep_Assign(0, 144);
		// 170: assign V0 = |TargetCS::ownedTargetElements|
		serializationMatchSteps[170] = createMatchStep_Assign(0, 150);
		// 171: assign V0 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[171] = createMatchStep_Assign(0, 155);
		// 172: assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[172] = createMatchStep_Assign(0, 166);
		// 173: assign V0 = |TypedElementCS::ownedType|
		serializationMatchSteps[173] = createMatchStep_Assign(0, 171);
		// 174: assign V0 = |TypedElementCS::qualifiers.'definition'|
		serializationMatchSteps[174] = createMatchStep_Assign(0, 176);
		// 175: assign V0 = |TypedElementCS::qualifiers.'static'|
		serializationMatchSteps[175] = createMatchStep_Assign(0, 177);
		// 176: assign V0 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[176] = createMatchStep_Assign(0, 179);
		// 177: assign V0 = |TypedTypeRefCS::ownedBinding|
		serializationMatchSteps[177] = createMatchStep_Assign(0, 181);
		// 178: assign V0 = |VariableCS::ownedType|
		serializationMatchSteps[178] = createMatchStep_Assign(0, 185);
		// 179: assign V0 = |WildcardTypeRefCS::ownedExtends|
		serializationMatchSteps[179] = createMatchStep_Assign(0, 186);
		// 180: assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[180] = createMatchStep_Assign(1, 193);
		// 181: assign V1 = (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchSteps[181] = createMatchStep_Assign(1, 197);
		// 182: assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchSteps[182] = createMatchStep_Assign(1, 201);
		// 183: assign V1 = (|DirectionCS::imports| - 1)
		serializationMatchSteps[183] = createMatchStep_Assign(1, 203);
		// 184: assign V1 = (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[184] = createMatchStep_Assign(1, 219);
		// 185: assign V1 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[185] = createMatchStep_Assign(1, 245);
		// 186: assign V1 = (|QueryCS::ownedParameters| > 0)
		serializationMatchSteps[186] = createMatchStep_Assign(1, 257);
		// 187: assign V1 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[187] = createMatchStep_Assign(1, 263);
		// 188: assign V1 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[188] = createMatchStep_Assign(1, 279);
		// 189: assign V1 = (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchSteps[189] = createMatchStep_Assign(1, 282);
		// 190: assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchSteps[190] = createMatchStep_Assign(1, 288);
		// 191: assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchSteps[191] = createMatchStep_Assign(1, 7);
		// 192: assign V1 = |BottomPatternCS::ownedConstraints|
		serializationMatchSteps[192] = createMatchStep_Assign(1, 14);
		// 193: assign V1 = |ClassCS::instanceClassName|
		serializationMatchSteps[193] = createMatchStep_Assign(1, 17);
		// 194: assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchSteps[194] = createMatchStep_Assign(1, 28);
		// 195: assign V1 = |DomainCS::isEnforce.'enforce'|
		serializationMatchSteps[195] = createMatchStep_Assign(1, 42);
		// 196: assign V1 = |GuardPatternCS::ownedPredicates|
		serializationMatchSteps[196] = createMatchStep_Assign(1, 50);
		// 197: assign V1 = |ImportCS::isAll.'::'|
		serializationMatchSteps[197] = createMatchStep_Assign(1, 58);
		// 198: assign V1 = |NamedElementCS::name|
		serializationMatchSteps[198] = createMatchStep_Assign(1, 86);
		// 199: assign V1 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[199] = createMatchStep_Assign(1, 87);
		// 200: assign V1 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[200] = createMatchStep_Assign(1, 88);
		// 201: assign V1 = |PackageCS::nsPrefix|
		serializationMatchSteps[201] = createMatchStep_Assign(1, 103);
		// 202: assign V1 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[202] = createMatchStep_Assign(1, 106);
		// 203: assign V1 = |PredicateOrAssignmentCS::ownedInitExpression|
		serializationMatchSteps[203] = createMatchStep_Assign(1, 116);
		// 204: assign V1 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[204] = createMatchStep_Assign(1, 126);
		// 205: assign V1 = |StructuralFeatureCS::default|
		serializationMatchSteps[205] = createMatchStep_Assign(1, 142);
		// 206: assign V1 = |TemplateBindingCS::ownedMultiplicity|
		serializationMatchSteps[206] = createMatchStep_Assign(1, 151);
		// 207: assign V1 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[207] = createMatchStep_Assign(1, 155);
		// 208: assign V1 = |TransformationCS::ownedDirections|
		serializationMatchSteps[208] = createMatchStep_Assign(1, 159);
		// 209: assign V1 = |TypeNameExpCS::ownedPatternGuard|
		serializationMatchSteps[209] = createMatchStep_Assign(1, 168);
		// 210: assign V1 = |TypedElementCS::ownedType|
		serializationMatchSteps[210] = createMatchStep_Assign(1, 171);
		// 211: assign V1 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[211] = createMatchStep_Assign(1, 179);
		// 212: assign V1 = |UnrealizedVariableCS::ownedInitExpression|
		serializationMatchSteps[212] = createMatchStep_Assign(1, 183);
		// 213: assign V1 = |VariableCS::ownedType|
		serializationMatchSteps[213] = createMatchStep_Assign(1, 185);
		// 214: assign V10 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[214] = createMatchStep_Assign(10, 97);
		// 215: assign V2 = (|DirectionCS::uses| > 0)
		serializationMatchSteps[215] = createMatchStep_Assign(2, 205);
		// 216: assign V2 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[216] = createMatchStep_Assign(2, 244);
		// 217: assign V2 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[217] = createMatchStep_Assign(2, 245);
		// 218: assign V2 = (|QueryCS::ownedParameters| - 1)
		serializationMatchSteps[218] = createMatchStep_Assign(2, 256);
		// 219: assign V2 = (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchSteps[219] = createMatchStep_Assign(2, 262);
		// 220: assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchSteps[220] = createMatchStep_Assign(2, 272);
		// 221: assign V2 = (|TupleTypeCS::ownedParts| - 1)
		serializationMatchSteps[221] = createMatchStep_Assign(2, 278);
		// 222: assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[222] = createMatchStep_Assign(2, 286);
		// 223: assign V2 = 0
		serializationMatchSteps[223] = createMatchStep_Assign(2, 0);
		// 224: assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[224] = createMatchStep_Assign(2, 5);
		// 225: assign V2 = |AbstractTransformationCS::ownedTargets|
		serializationMatchSteps[225] = createMatchStep_Assign(2, 10);
		// 226: assign V2 = |ClassCS::instanceClassName|
		serializationMatchSteps[226] = createMatchStep_Assign(2, 17);
		// 227: assign V2 = |EnumerationCS::isSerializable.'serializable'|
		serializationMatchSteps[227] = createMatchStep_Assign(2, 44);
		// 228: assign V2 = |MappingCS::ownedInPathName|
		serializationMatchSteps[228] = createMatchStep_Assign(2, 77);
		// 229: assign V2 = |PackageCS::nsURI|
		serializationMatchSteps[229] = createMatchStep_Assign(2, 104);
		// 230: assign V2 = |StructuralFeatureCS::default|
		serializationMatchSteps[230] = createMatchStep_Assign(2, 142);
		// 231: assign V2 = |TopLevelCS::ownedTransformations|
		serializationMatchSteps[231] = createMatchStep_Assign(2, 158);
		// 232: assign V2 = |TypedElementCS::ownedType|
		serializationMatchSteps[232] = createMatchStep_Assign(2, 171);
		// 233: assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchSteps[233] = createMatchStep_Assign(2, 175);
		// 234: assign V2 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[234] = createMatchStep_Assign(2, 179);
		// 235: assign V3 = (|DirectionCS::uses| - 1)
		serializationMatchSteps[235] = createMatchStep_Assign(3, 204);
		// 236: assign V3 = (|MappingCS::refines| > 0)
		serializationMatchSteps[236] = createMatchStep_Assign(3, 227);
		// 237: assign V3 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[237] = createMatchStep_Assign(3, 244);
		// 238: assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchSteps[238] = createMatchStep_Assign(3, 271);
		// 239: assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[239] = createMatchStep_Assign(3, 285);
		// 240: assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[240] = createMatchStep_Assign(3, 286);
		// 241: assign V3 = 0
		serializationMatchSteps[241] = createMatchStep_Assign(3, 0);
		// 242: assign V3 = |AbstractNameExpCS::isPre.'@'|
		serializationMatchSteps[242] = createMatchStep_Assign(3, 4);
		// 243: assign V3 = |DataTypeCS::isSerializable.'serializable'|
		serializationMatchSteps[243] = createMatchStep_Assign(3, 35);
		// 244: assign V3 = |EnumerationCS::ownedLiterals|
		serializationMatchSteps[244] = createMatchStep_Assign(3, 46);
		// 245: assign V3 = |PackageCS::ownedClasses|
		serializationMatchSteps[245] = createMatchStep_Assign(3, 105);
		// 246: assign V3 = |StructuralFeatureCS::default|
		serializationMatchSteps[246] = createMatchStep_Assign(3, 142);
		// 247: assign V3 = |TopLevelCS::ownedMappings|
		serializationMatchSteps[247] = createMatchStep_Assign(3, 156);
		// 248: assign V3 = |TransformationCS::ownedProperties|
		serializationMatchSteps[248] = createMatchStep_Assign(3, 160);
		// 249: assign V3 = |TypedElementCS::ownedType|
		serializationMatchSteps[249] = createMatchStep_Assign(3, 171);
		// 250: assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[250] = createMatchStep_Assign(3, 173);
		// 251: assign V3 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[251] = createMatchStep_Assign(3, 179);
		// 252: assign V4 = (|MappingCS::refines| - 1)
		serializationMatchSteps[252] = createMatchStep_Assign(4, 226);
		// 253: assign V4 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[253] = createMatchStep_Assign(4, 243);
		// 254: assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[254] = createMatchStep_Assign(4, 285);
		// 255: assign V4 = |ClassCS::instanceClassName|
		serializationMatchSteps[255] = createMatchStep_Assign(4, 17);
		// 256: assign V4 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[256] = createMatchStep_Assign(4, 106);
		// 257: assign V4 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[257] = createMatchStep_Assign(4, 143);
		// 258: assign V4 = |TopLevelCS::ownedQueries|
		serializationMatchSteps[258] = createMatchStep_Assign(4, 157);
		// 259: assign V4 = |TypedElementCS::ownedType|
		serializationMatchSteps[259] = createMatchStep_Assign(4, 171);
		// 260: assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[260] = createMatchStep_Assign(4, 172);
		// 261: assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[261] = createMatchStep_Assign(4, 173);
		// 262: assign V5 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[262] = createMatchStep_Assign(5, 242);
		// 263: assign V5 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[263] = createMatchStep_Assign(5, 243);
		// 264: assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[264] = createMatchStep_Assign(5, 269);
		// 265: assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchSteps[265] = createMatchStep_Assign(5, 270);
		// 266: assign V5 = |MappingCS::ownedDomains|
		serializationMatchSteps[266] = createMatchStep_Assign(5, 76);
		// 267: assign V5 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[267] = createMatchStep_Assign(5, 143);
		// 268: assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[268] = createMatchStep_Assign(5, 172);
		// 269: assign V6 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[269] = createMatchStep_Assign(6, 242);
		// 270: assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[270] = createMatchStep_Assign(6, 269);
		// 271: assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[271] = createMatchStep_Assign(6, 287);
		// 272: assign V6 = 0
		serializationMatchSteps[272] = createMatchStep_Assign(6, 0);
		// 273: assign V6 = |MappingCS::ownedMiddle|
		serializationMatchSteps[273] = createMatchStep_Assign(6, 78);
		// 274: assign V6 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[274] = createMatchStep_Assign(6, 143);
		// 275: assign V6 = |StructuredClassCS::isInterface.'interface'|
		serializationMatchSteps[275] = createMatchStep_Assign(6, 145);
		// 276: assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[276] = createMatchStep_Assign(7, 269);
		// 277: assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[277] = createMatchStep_Assign(7, 287);
		// 278: assign V7 = 0
		serializationMatchSteps[278] = createMatchStep_Assign(7, 0);
		// 279: assign V7 = |MappingCS::ownedComposedMappings|
		serializationMatchSteps[279] = createMatchStep_Assign(7, 75);
		// 280: assign V7 = |StructuredClassCS::ownedOperations|
		serializationMatchSteps[280] = createMatchStep_Assign(7, 147);
		// 281: assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[281] = createMatchStep_Assign(7, 174);
		// 282: assign V8 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[282] = createMatchStep_Assign(8, 241);
		// 283: assign V8 = 0
		serializationMatchSteps[283] = createMatchStep_Assign(8, 0);
		// 284: assign V8 = |StructuredClassCS::ownedProperties|
		serializationMatchSteps[284] = createMatchStep_Assign(8, 148);
		// 285: assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[285] = createMatchStep_Assign(8, 174);
		// 286: assign V9 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[286] = createMatchStep_Assign(9, 241);
		// 287: assign V9 = 0
		serializationMatchSteps[287] = createMatchStep_Assign(9, 0);
		// 288: assign V9 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[288] = createMatchStep_Assign(9, 97);
		// 289: check-rule basecs::EnumerationCS.ownedLiterals : 21
		serializationMatchSteps[289] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/*EnumerationLiteralCS*/);
		// 290: check-rule basecs::ImportCS.ownedPathName : 128
		serializationMatchSteps[290] = createMatchStep_RuleCheck(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 70/*URIPathNameCS*/);
		// 291: check-rule basecs::OperationCS.ownedBodyExpressions : 97
		serializationMatchSteps[291] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 43/*SpecificationCS*/);
		// 292: check-rule basecs::OperationCS.ownedExceptions : 10|49|79|112|115|122|123
		serializationMatchSteps[292] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 67/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 293: check-rule basecs::OperationCS.ownedParameters : 70
		serializationMatchSteps[293] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 26/*ParameterCS*/);
		// 294: check-rule basecs::PackageCS.ownedClasses : 5|15|20|102|108
		serializationMatchSteps[294] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 55/*ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS*/);
		// 295: check-rule basecs::PackageOwnerCS.ownedPackages : 83
		serializationMatchSteps[295] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 35/*QualifiedPackageCS*/);
		// 296: check-rule basecs::PathNameCS.ownedPathElements : 30
		serializationMatchSteps[296] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 9/*FirstPathElementCS*/);
		// 297: check-rule basecs::PathNameCS.ownedPathElements : 65
		serializationMatchSteps[297] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 22/*NextPathElementCS*/);
		// 298: check-rule basecs::RootCS.ownedImports : 37
		serializationMatchSteps[298] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 12/*ImportCS*/);
		// 299: check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : 97
		serializationMatchSteps[299] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 43/*SpecificationCS*/);
		// 300: check-rule basecs::StructuredClassCS.ownedOperations : 68
		serializationMatchSteps[300] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 24/*OperationCS*/);
		// 301: check-rule basecs::StructuredClassCS.ownedProperties : 1|86|101
		serializationMatchSteps[301] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 47/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 302: check-rule basecs::StructuredClassCS.ownedSuperTypes : 10|49|79|112|115|122|123
		serializationMatchSteps[302] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 67/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 303: check-rule basecs::TemplateBindingCS.ownedMultiplicity : 53
		serializationMatchSteps[303] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 304: check-rule basecs::TemplateBindingCS.ownedSubstitutions : 105
		serializationMatchSteps[304] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 51/*TemplateParameterSubstitutionCS*/);
		// 305: check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : 10|49|79|112|115|120|122|123|137
		serializationMatchSteps[305] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 80/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS*/);
		// 306: check-rule basecs::TemplateSignatureCS.ownedParameters : 119
		serializationMatchSteps[306] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 63/*TypeParameterCS*/);
		// 307: check-rule basecs::TemplateableElementCS.ownedSignature : 106
		serializationMatchSteps[307] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/*TemplateSignatureCS*/);
		// 308: check-rule basecs::TupleTypeCS.ownedParts : 111
		serializationMatchSteps[308] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 57/*TuplePartCS*/);
		// 309: check-rule basecs::TypeParameterCS.ownedExtends : 10|49|79|112|115|122|123
		serializationMatchSteps[309] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 67/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 310: check-rule basecs::TypedElementCS.ownedType : 113
		serializationMatchSteps[310] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/*TypeExpCS*/);
		// 311: check-rule basecs::TypedElementCS.ownedType : 121
		serializationMatchSteps[311] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/*TypedMultiplicityRefCS*/);
		// 312: check-rule basecs::TypedRefCS.ownedMultiplicity : 53
		serializationMatchSteps[312] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 313: check-rule basecs::TypedTypeRefCS.ownedBinding : 104
		serializationMatchSteps[313] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 50/*TemplateBindingCS*/);
		// 314: check-rule basecs::TypedTypeRefCS.ownedPathName : 71
		serializationMatchSteps[314] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 27/*PathNameCS*/);
		// 315: check-rule basecs::WildcardTypeRefCS.ownedExtends : 10|49|79|112|115|122|123
		serializationMatchSteps[315] = createMatchStep_RuleCheck(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 67/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 316: check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : 13
		serializationMatchSteps[316] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/*CurlyBracketedClauseCS*/);
		// 317: check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : 71
		serializationMatchSteps[317] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 27/*PathNameCS*/);
		// 318: check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : 87
		serializationMatchSteps[318] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 38/*RoundBracketedClauseCS*/);
		// 319: check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : 98
		serializationMatchSteps[319] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 44/*SquareBracketedClauseCS*/);
		// 320: check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : 8
		serializationMatchSteps[320] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 2/*CollectionLiteralPartCS*/);
		// 321: check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : 10
		serializationMatchSteps[321] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 3/*CollectionTypeCS*/);
		// 322: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[322] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 323: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 72
		serializationMatchSteps[323] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 28/*PatternExpCS*/);
		// 324: check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[324] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 325: check-rule essentialoclcs::CollectionPatternCS.ownedParts : 72
		serializationMatchSteps[325] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 28/*PatternExpCS*/);
		// 326: check-rule essentialoclcs::CollectionPatternCS.ownedType : 10
		serializationMatchSteps[326] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 3/*CollectionTypeCS*/);
		// 327: check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : 53
		serializationMatchSteps[327] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/*MultiplicityCS*/);
		// 328: check-rule essentialoclcs::CollectionTypeCS.ownedType : 9|10|49|79|112|114|115|118
		serializationMatchSteps[328] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 62/*CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS*/);
		// 329: check-rule essentialoclcs::ContextCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[329] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 330: check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : 94
		serializationMatchSteps[330] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 40/*ShadowPartCS*/);
		// 331: check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[331] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 332: check-rule essentialoclcs::IfExpCS.ownedCondition : 3|7|29|36|39|42|43|47|56|64|66|67|72|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[332] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 333: check-rule essentialoclcs::IfExpCS.ownedElseExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[333] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 334: check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : 19
		serializationMatchSteps[334] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 6/*ElseIfThenExpCS*/);
		// 335: check-rule essentialoclcs::IfExpCS.ownedThenExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[335] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 336: check-rule essentialoclcs::IfThenExpCS.ownedCondition : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[336] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 337: check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[337] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 338: check-rule essentialoclcs::InfixExpCS.ownedLeft : 3|7|36|39|42|47|56|64|66|67|76|77|78|93|100|109|116|130
		serializationMatchSteps[338] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 73/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 339: check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[339] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 340: check-rule essentialoclcs::LetExpCS.ownedInExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[340] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 341: check-rule essentialoclcs::LetExpCS.ownedVariables : 44
		serializationMatchSteps[341] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 13/*LetVariableCS*/);
		// 342: check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : 87
		serializationMatchSteps[342] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 38/*RoundBracketedClauseCS*/);
		// 343: check-rule essentialoclcs::MapLiteralExpCS.ownedParts : 48
		serializationMatchSteps[343] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 14/*MapLiteralPartCS*/);
		// 344: check-rule essentialoclcs::MapLiteralExpCS.ownedType : 49
		serializationMatchSteps[344] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 15/*MapTypeCS*/);
		// 345: check-rule essentialoclcs::MapLiteralPartCS.ownedKey : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[345] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 346: check-rule essentialoclcs::MapLiteralPartCS.ownedValue : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[346] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 347: check-rule essentialoclcs::MapTypeCS.ownedKeyType : 113
		serializationMatchSteps[347] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 58/*TypeExpCS*/);
		// 348: check-rule essentialoclcs::MapTypeCS.ownedValueType : 113
		serializationMatchSteps[348] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 58/*TypeExpCS*/);
		// 349: check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : 6
		serializationMatchSteps[349] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 1/*CoIteratorVariableCS*/);
		// 350: check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[350] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 351: check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : 3|7|29|36|39|42|43|47|56|59|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[351] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 76/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 352: check-rule essentialoclcs::NavigatingArgCS.ownedType : 113
		serializationMatchSteps[352] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/*TypeExpCS*/);
		// 353: check-rule essentialoclcs::NestedExpCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[353] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 354: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[354] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 355: check-rule essentialoclcs::OperatorExpCS.ownedRight : 3|7|36|39|42|47|56|64|66|67|76|77|78|93|100|109|116|130
		serializationMatchSteps[355] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 73/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 356: check-rule essentialoclcs::OperatorExpCS.ownedRight : 43|75
		serializationMatchSteps[356] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 33/*LetExpCS|PrefixedLetExpCS*/);
		// 357: check-rule essentialoclcs::PatternExpCS.ownedPatternType : 113
		serializationMatchSteps[357] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 58/*TypeExpCS*/);
		// 358: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 100
		serializationMatchSteps[358] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 45/*StringLiteralExpCS*/);
		// 359: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|72|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[359] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 360: check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[360] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 361: check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : 110
		serializationMatchSteps[361] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 56/*TupleLiteralPartCS*/);
		// 362: check-rule essentialoclcs::TypeLiteralExpCS.ownedType : 117
		serializationMatchSteps[362] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 61/*TypeLiteralWithMultiplicityCS*/);
		// 363: check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : 13
		serializationMatchSteps[363] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/*CurlyBracketedClauseCS*/);
		// 364: check-rule essentialoclcs::TypeNameExpCS.ownedPathName : 71
		serializationMatchSteps[364] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 27/*PathNameCS*/);
		// 365: check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[365] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 366: check-rule essentialoclcs::VariableCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[366] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 367: check-rule essentialoclcs::VariableCS.ownedType : 113
		serializationMatchSteps[367] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 58/*TypeExpCS*/);
		// 368: check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : 92
		serializationMatchSteps[368] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 39/*ScopeNameCS*/);
		// 369: check-rule qvtbasecs::AbstractTransformationCS.ownedTargets : 103
		serializationMatchSteps[369] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 49/*TargetCS*/);
		// 370: check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : 96
		serializationMatchSteps[370] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 41/*SimpleTargetElementCS*/);
		// 371: check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : 92
		serializationMatchSteps[371] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 39/*ScopeNameCS*/);
		// 372: check-rule qvtbasecs::TargetCS.ownedTargetElements : 12|96
		serializationMatchSteps[372] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 42/*CompoundTargetElementCS|SimpleTargetElementCS*/);
		// 373: check-rule qvtcorecs::AreaCS.ownedBottomPattern : 4
		serializationMatchSteps[373] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN, 0/*BottomPatternCS*/);
		// 374: check-rule qvtcorecs::AreaCS.ownedGuardPattern : 31
		serializationMatchSteps[374] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.AREA_CS__OWNED_GUARD_PATTERN, 10/*GuardPatternCS*/);
		// 375: check-rule qvtcorecs::BottomPatternCS.ownedConstraints : 74
		serializationMatchSteps[375] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 31/*PredicateOrAssignmentCS*/);
		// 376: check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : 85
		serializationMatchSteps[376] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 37/*RealizedVariableCS*/);
		// 377: check-rule qvtcorecs::GuardPatternCS.ownedPredicates : 73
		serializationMatchSteps[377] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 30/*PredicateCS*/);
		// 378: check-rule qvtcorecs::MappingCS.ownedComposedMappings : 50
		serializationMatchSteps[378] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_COMPOSED_MAPPINGS, 16/*MappingCS*/);
		// 379: check-rule qvtcorecs::MappingCS.ownedDomains : 57
		serializationMatchSteps[379] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_DOMAINS, 18/*NamedDomainCS*/);
		// 380: check-rule qvtcorecs::MappingCS.ownedInPathName : 71
		serializationMatchSteps[380] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME, 27/*PathNameCS*/);
		// 381: check-rule qvtcorecs::MappingCS.ownedMiddle : 131
		serializationMatchSteps[381] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE, 78/*UnnamedDomainCS*/);
		// 382: check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : 132
		serializationMatchSteps[382] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 79/*UnrealizedVariableCS*/);
		// 383: check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : 32
		serializationMatchSteps[383] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 11/*GuardVariableCS*/);
		// 384: check-rule qvtcorecs::PredicateCS.ownedCondition : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[384] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 385: check-rule qvtcorecs::PredicateOrAssignmentCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[385] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 386: check-rule qvtcorecs::PredicateOrAssignmentCS.ownedTarget : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[386] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 387: check-rule qvtcorecs::QueryCS.ownedExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[387] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 388: check-rule qvtcorecs::QueryCS.ownedParameters : 69
		serializationMatchSteps[388] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 25/*ParamDeclarationCS*/);
		// 389: check-rule qvtcorecs::QueryCS.ownedPathName : 92
		serializationMatchSteps[389] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 39/*ScopeNameCS*/);
		// 390: check-rule qvtcorecs::TopLevelCS.ownedMappings : 50
		serializationMatchSteps[390] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS, 16/*MappingCS*/);
		// 391: check-rule qvtcorecs::TopLevelCS.ownedQueries : 84
		serializationMatchSteps[391] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES, 36/*QueryCS*/);
		// 392: check-rule qvtcorecs::TopLevelCS.ownedTransformations : 108
		serializationMatchSteps[392] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 53/*TransformationCS*/);
		// 393: check-rule qvtcorecs::TransformationCS.ownedDirections : 16
		serializationMatchSteps[393] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 5/*DirectionCS*/);
		// 394: check-rule qvtcorecs::TransformationCS.ownedProperties : 1|86|101
		serializationMatchSteps[394] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 47/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 395: check-rule qvtcorecs::UnrealizedVariableCS.ownedInitExpression : 3|7|29|36|39|42|43|47|56|64|66|67|75|76|77|78|93|100|109|116|130
		serializationMatchSteps[395] = createMatchStep_RuleCheck(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
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
		serializationMatchTerms[61] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION);
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
				313		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::MultiplicityBoundsCS-0(basecs::MultiplicityBoundsCS): { lowerBound=LOWER { ".." upperBound=UPPER }[?] }
		serializationRules[1] = createSerializationRule("MultiplicityBoundsCS-0", 52,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				155		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				161		/* '..' || no-space value no-space */,
				143		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-0(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "|?" "]" }
		serializationRules[2] = createSerializationRule("MultiplicityCS-0", 53,
			createSerializationMatchSteps(
				88		/* assert |MultiplicityCS::isNullFree| == 0 */,
				155		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				170		/* '[' || no-space value no-space */,
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				161		/* '..' || no-space value no-space */,
				143		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				215		/* '|?' || no-space value no-space */,
				171		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-1(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } isNullFree?="|1" "]" }
		serializationRules[3] = createSerializationRule("MultiplicityCS-1", 53,
			createSerializationMatchSteps(
				28		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				155		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				170		/* '[' || no-space value no-space */,
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				161		/* '..' || no-space value no-space */,
				143		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				14		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				171		/* ']' || no-space value */
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
				155		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				27		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				170		/* '[' || no-space value no-space */,
				22		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				161		/* '..' || no-space value no-space */,
				143		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				171		/* ']' || no-space value */
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
				170		/* '[' || no-space value no-space */,
				139		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				215		/* '|?' || no-space value no-space */,
				171		/* ']' || no-space value */
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
				170		/* '[' || no-space value no-space */,
				139		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				14		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				171		/* ']' || no-space value */
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
				170		/* '[' || no-space value no-space */,
				139		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				171		/* ']' || no-space value */
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
				139		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */
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
				312		/* PathElementCS::referredElement=UnreservedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::PathNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[10] = createSerializationRule("PathNameCS-0", 71,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				294		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				224		/* V00*2-steps || value */,
				163		/* '::' || no-space value no-space */,
				295		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 23/* FirstPathElementCS,NextPathElementCS */,
					(30/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(65/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TemplateBindingCS-0(basecs::TemplateBindingCS): { ownedSubstitutions+=TemplateParameterSubstitutionCS { "," ownedSubstitutions+=TemplateParameterSubstitutionCS }[*] ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[11] = createSerializationRule("TemplateBindingCS-0", 104,
			createSerializationMatchSteps(
				303		/* check-rule basecs::TemplateBindingCS.ownedMultiplicity : MultiplicityCS */,
				304		/* check-rule basecs::TemplateBindingCS.ownedSubstitutions : TemplateParameterSubstitutionCS */,
				206		/* assign V1 = |TemplateBindingCS::ownedMultiplicity| */,
				134		/* assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1) */
			),
			createSerializationSteps(
				110		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				224		/* V00*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				110		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				231		/* V01*1-steps || value */,
				76		/* TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 51/* TemplateParameterSubstitutionCS */,
					(105/*TemplateParameterSubstitutionCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TemplateParameterSubstitutionCS-0(basecs::TemplateParameterSubstitutionCS): ownedActualParameter=TypeRefCS
		serializationRules[12] = createSerializationRule("TemplateParameterSubstitutionCS-0", 105,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				305		/* check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
				58		/* assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0 */
			),
			createSerializationSteps(
				30		/* TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 64/* TypeRefCS */,
					(120/*TypeRefCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::TemplateSignatureCS-0(basecs::TemplateSignatureCS): { "(" ownedParameters+=TypeParameterCS { "," ownedParameters+=TypeParameterCS }[*] ")" }
		serializationRules[13] = createSerializationRule("TemplateSignatureCS-0", 106,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				306		/* check-rule basecs::TemplateSignatureCS.ownedParameters : TypeParameterCS */,
				135		/* assign V0 = (|TemplateSignatureCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				152		/* '(' || no-space value no-space */,
				84		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				224		/* V00*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				84		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				153		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 63/* TypeParameterCS */,
					(119/*TypeParameterCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TypeParameterCS-0(basecs::TypeParameterCS): { name=UnrestrictedName { "extends" ownedExtends+=TypedRefCS { "&&" ownedExtends+=TypedRefCS }[*] }[?] }
		serializationRules[14] = createSerializationRule("TypeParameterCS-0", 119,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				309		/* check-rule basecs::TypeParameterCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				138		/* assign V0 = (|TypeParameterCS::ownedExtends| > 0) */,
				189		/* assign V1 = (|TypeParameterCS::ownedExtends| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				181		/* 'extends' || soft-space value soft-space */,
				56		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */,
				234		/* V01*2-steps || value */,
				149		/* '&&' || soft-space value soft-space */,
				56		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TypedTypeRefCS-0(basecs::TypedTypeRefCS): { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] }
		serializationRules[15] = createSerializationRule("TypedTypeRefCS-0", 123,
			createSerializationMatchSteps(
				121		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				313		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				314		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				177		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				65		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				97		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				225		/* V00*3-steps || value */,
				152		/* '(' || no-space value no-space */,
				31		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				153		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 50/* TemplateBindingCS */,
					(104/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 27/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::UnreservedPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=NextPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[16] = createSerializationRule("UnreservedPathNameCS-0", 134,
			createSerializationMatchSteps(
				297		/* check-rule basecs::PathNameCS.ownedPathElements : NextPathElementCS */,
				130		/* assign V0 = (|PathNameCS::ownedPathElements| - 1) */
			),
			createSerializationSteps(
				295		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */,
				224		/* V00*2-steps || value */,
				163		/* '::' || no-space value no-space */,
				295		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 22/* NextPathElementCS */,
					(65/*NextPathElementCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::WildcardTypeRefCS-0(basecs::WildcardTypeRefCS): { "?" { "extends" ownedExtends=TypedRefCS }[?] }
		serializationRules[17] = createSerializationRule("WildcardTypeRefCS-0", 137,
			createSerializationMatchSteps(
				124		/* assert |WildcardTypeRefCS::ownedSuper| == 0 */,
				315		/* check-rule basecs::WildcardTypeRefCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				179		/* assign V0 = |WildcardTypeRefCS::ownedExtends| */
			),
			createSerializationSteps(
				167		/* '?' || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				181		/* 'extends' || soft-space value soft-space */,
				57		/* WildcardTypeRefCS::ownedExtends=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::BooleanLiteralExpCS-0(essentialoclcs::BooleanLiteralExpCS): symbol={'false|true'}
		serializationRules[18] = createSerializationRule("BooleanLiteralExpCS-0", 3,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				3		/* assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0 */
			),
			createSerializationSteps(
				140		/* BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, false,
					(17/*'false|true'*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CoIteratorVariableCS-0(essentialoclcs::VariableCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] }
		serializationRules[19] = createSerializationRule("CoIteratorVariableCS-0", 6,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				123		/* assert |VariableCS::ownedInitExpression| == 0 */,
				367		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				178		/* assign V0 = |VariableCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				126		/* VariableCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralExpCS-0(essentialoclcs::CollectionLiteralExpCS): { ownedType=CollectionTypeCS "{" { ownedParts+=CollectionLiteralPartCS { "," ownedParts+=CollectionLiteralPartCS }[*] }[?] "}" }
		serializationRules[20] = createSerializationRule("CollectionLiteralExpCS-0", 7,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				320		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : CollectionLiteralPartCS */,
				321		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : CollectionTypeCS */,
				5		/* assert (|CollectionLiteralExpCS::ownedType| - 1) == 0 */,
				126		/* assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0) */,
				180		/* assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				120		/* CollectionLiteralExpCS::ownedType=CollectionTypeCS || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				226		/* V00*4-steps || value */,
				85		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				234		/* V01*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				85		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
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
		serializationRules[21] = createSerializationRule("CollectionLiteralPartCS-0", 8,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				322		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				324		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				143		/* assign V0 = |CollectionLiteralPartCS::ownedLastExpression| */,
				6		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				49		/* CollectionLiteralPartCS::ownedExpression=ExpCS || value */,
				223		/* V00*2-steps || value */,
				161		/* '..' || no-space value no-space */,
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
		serializationRules[22] = createSerializationRule("CollectionLiteralPartCS-1", 8,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				72		/* assert |CollectionLiteralPartCS::ownedLastExpression| == 0 */,
				323		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : PatternExpCS */,
				6		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				50		/* CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 28/* PatternExpCS */,
					(72/*PatternExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionPatternCS-0(essentialoclcs::CollectionPatternCS): { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" }
		serializationRules[23] = createSerializationRule("CollectionPatternCS-0", 9,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				73		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				325		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				326		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				144		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				181		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				7		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				121		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				228		/* V00*6-steps || value */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				234		/* V01*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				158		/* '++' || soft-space value soft-space */,
				137		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 28/* PatternExpCS */,
					(72/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 3/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionTypeCS-0(essentialoclcs::CollectionTypeCS): { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] }
		serializationRules[24] = createSerializationRule("CollectionTypeCS-0", 10,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				327		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				145		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				194		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				122		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				231		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				153		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 59/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CurlyBracketedClauseCS-0(essentialoclcs::CurlyBracketedClauseCS): { "{" { ownedParts+=ShadowPartCS { "," ownedParts+=ShadowPartCS }[*] }[?] "}" }
		serializationRules[25] = createSerializationRule("CurlyBracketedClauseCS-0", 13,
			createSerializationMatchSteps(
				74		/* assert |CurlyBracketedClauseCS::value| == 0 */,
				330		/* check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : ShadowPartCS */,
				127		/* assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0) */,
				182		/* assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				213		/* '{' || soft-space value push soft-new-line */,
				226		/* V00*4-steps || value */,
				87		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				234		/* V01*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				87		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 40/* ShadowPartCS */,
					(94/*ShadowPartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::ElseIfThenExpCS-0(essentialoclcs::IfThenExpCS): { "elseif" ownedCondition=ExpCS "then" ownedThenExpression=ExpCS }
		serializationRules[26] = createSerializationRule("ElseIfThenExpCS-0", 19,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				336		/* check-rule essentialoclcs::IfThenExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				337		/* check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				16		/* assert (|IfThenExpCS::ownedThenExpression| - 1) == 0 */,
				15		/* assert (|IfThenExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				178		/* 'elseif' || soft-new-line pop soft-space value push soft-space */,
				39		/* IfThenExpCS::ownedCondition=ExpCS || value */,
				204		/* 'then' || pop value push soft-space */,
				118		/* IfThenExpCS::ownedThenExpression=ExpCS || value */
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
		serializationRules[27] = createSerializationRule("ExpCS-18", 29,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				338		/* check-rule essentialoclcs::InfixExpCS.ownedLeft : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				354		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				40		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				18		/* assert (|InfixExpCS::ownedLeft| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				72		/* InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value */,
				288		/* NamedElementCS::name=BinaryOperatorName || soft-space value soft-space */,
				296		/* OperatorExpCS::ownedRight=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 34/* PrefixedPrimaryExpCS */,
					(76/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::IfExpCS-0(essentialoclcs::IfExpCS): { "if" ownedCondition=(ExpCS|PatternExpCS) "then" ownedThenExpression=ExpCS ownedIfThenExpressions+=ElseIfThenExpCS[*] "else" ownedElseExpression=ExpCS "endif" }
		serializationRules[28] = createSerializationRule("IfExpCS-0", 36,
			createSerializationMatchSteps(
				84		/* assert |IfExpCS::isImplicit| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				332		/* check-rule essentialoclcs::IfExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				333		/* check-rule essentialoclcs::IfExpCS.ownedElseExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				334		/* check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : ElseIfThenExpCS */,
				335		/* check-rule essentialoclcs::IfExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				13		/* assert (|IfExpCS::ownedElseExpression| - 1) == 0 */,
				151		/* assign V0 = |IfExpCS::ownedIfThenExpressions| */,
				14		/* assert (|IfExpCS::ownedThenExpression| - 1) == 0 */,
				12		/* assert (|IfExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				182		/* 'if' || soft-new-line value push soft-space */,
				38		/* IfExpCS::ownedCondition=ExpCS|PatternExpCS || value */,
				205		/* 'then' || pop soft-space value push soft-space */,
				117		/* IfExpCS::ownedThenExpression=ExpCS || value */,
				220		/* V00*1-steps || value */,
				59		/* IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value */,
				177		/* 'else' || soft-new-line pop value push soft-space */,
				47		/* IfExpCS::ownedElseExpression=ExpCS || value */,
				179		/* 'endif' || soft-new-line pop value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 29/* ExpCS,PatternExpCS */,
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
		serializationRules[29] = createSerializationRule("InvalidLiteralExpCS-0", 39,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				189		/* 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::LambdaLiteralExpCS-0(essentialoclcs::LambdaLiteralExpCS): { "Lambda" "{" ownedExpressionCS=ExpCS "}" }
		serializationRules[30] = createSerializationRule("LambdaLiteralExpCS-0", 42,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				339		/* check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				20		/* assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				168		/* 'Lambda' || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				55		/* LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::LetExpCS-0(essentialoclcs::LetExpCS): { "let" ownedVariables+=LetVariableCS { "," ownedVariables+=LetVariableCS }[*] "in" ownedInExpression=ExpCS }
		serializationRules[31] = createSerializationRule("LetExpCS-0", 43,
			createSerializationMatchSteps(
				86		/* assert |LetExpCS::isImplicit| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				340		/* check-rule essentialoclcs::LetExpCS.ownedInExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				341		/* check-rule essentialoclcs::LetExpCS.ownedVariables : LetVariableCS */,
				21		/* assert (|LetExpCS::ownedInExpression| - 1) == 0 */,
				128		/* assign V0 = (|LetExpCS::ownedVariables| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				191		/* 'let' || soft-space value push */,
				129		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				224		/* V00*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				129		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				187		/* 'in' || soft-space pop value soft-new-line */,
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
		serializationRules[32] = createSerializationRule("LetVariableCS-0", 44,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				366		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				342		/* check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				367		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				66		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				213		/* assign V1 = |VariableCS::ownedType| */,
				152		/* assign V0 = |LetVariableCS::ownedRoundBracketedClause| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				107		/* LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				126		/* VariableCS::ownedType=TypeExpCS || value */,
				166		/* '=' || soft-space value soft-space */,
				68		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 38/* RoundBracketedClauseCS */,
					(87/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::MapLiteralExpCS-0(essentialoclcs::MapLiteralExpCS): { ownedType=MapTypeCS "{" { ownedParts+=MapLiteralPartCS { "," ownedParts+=MapLiteralPartCS }[*] }[?] "}" }
		serializationRules[33] = createSerializationRule("MapLiteralExpCS-0", 47,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				343		/* check-rule essentialoclcs::MapLiteralExpCS.ownedParts : MapLiteralPartCS */,
				344		/* check-rule essentialoclcs::MapLiteralExpCS.ownedType : MapTypeCS */,
				22		/* assert (|MapLiteralExpCS::ownedType| - 1) == 0 */,
				129		/* assign V0 = (|MapLiteralExpCS::ownedParts| > 0) */,
				184		/* assign V1 = (|MapLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				123		/* MapLiteralExpCS::ownedType=MapTypeCS || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				226		/* V00*4-steps || value */,
				88		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				234		/* V01*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				88		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 14/* MapLiteralPartCS */,
					(48/*MapLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 15/* MapTypeCS */,
					(49/*MapTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapLiteralPartCS-0(essentialoclcs::MapLiteralPartCS): { ownedKey=ExpCS {"with"|"<-"} ownedValue=ExpCS }
		serializationRules[34] = createSerializationRule("MapLiteralPartCS-0", 48,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				345		/* check-rule essentialoclcs::MapLiteralPartCS.ownedKey : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				346		/* check-rule essentialoclcs::MapLiteralPartCS.ownedValue : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				24		/* assert (|MapLiteralPartCS::ownedValue| - 1) == 0 */,
				23		/* assert (|MapLiteralPartCS::ownedKey| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				69		/* MapLiteralPartCS::ownedKey=ExpCS || value */,
				210		/* 'with' || value */,
				127		/* MapLiteralPartCS::ownedValue=ExpCS || value */
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
		serializationRules[35] = createSerializationRule("MapTypeCS-0", 49,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				347		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				348		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				153		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				160		/* ',' || no-space value soft-space */,
				128		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				153		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::Model-0(essentialoclcs::ContextCS): ownedExpression=ExpCS
		serializationRules[36] = createSerializationRule("Model-0", 51,
			createSerializationMatchSteps(
				89		/* assert |NamedElementCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				105		/* assert |RootCS::ownedImports| == 0 */,
				329		/* check-rule essentialoclcs::ContextCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		serializationRules[37] = createSerializationRule("NameExpCS-0", 56,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				316		/* check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				317		/* check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : PathNameCS */,
				318		/* check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				319		/* check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : SquareBracketedClauseCS */,
				242		/* assign V3 = |AbstractNameExpCS::isPre.'@'| */,
				224		/* assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause| */,
				191		/* assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause| */,
				139		/* assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses| */,
				0		/* assert (|AbstractNameExpCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				91		/* AbstractNameExpCS::ownedPathName=PathNameCS || value */,
				220		/* V00*1-steps || value */,
				109		/* AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value */,
				231		/* V01*1-steps || value */,
				106		/* AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				238		/* V02*1-steps || value */,
				42		/* AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				249		/* V03*2-steps || value */,
				16		/* AbstractNameExpCS::isPre?='@' || soft-space value soft-space */,
				197		/* 'pre' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, false,
					(9/*'@'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 27/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 38/* RoundBracketedClauseCS */,
					(87/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 44/* SquareBracketedClauseCS */,
					(98/*SquareBracketedClauseCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-0(essentialoclcs::NavigatingArgCS): { ":" ownedType=TypeExpCS }
		serializationRules[38] = createSerializationRule("NavigatingArgCS-0", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				91		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				92		/* assert |NavigatingArgCS::ownedNameExpression| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				34		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				162		/* ':' || soft-space value soft-space */,
				124		/* NavigatingArgCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-1(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[39] = createSerializationRule("NavigatingArgCS-1", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				200		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				157		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				34		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				162		/* ':' || soft-space value soft-space */,
				124		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				223		/* V00*2-steps || value */,
				210		/* 'with' || value */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				233		/* V01*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-2(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[40] = createSerializationRule("NavigatingArgCS-2", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				32		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				199		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				159		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				124		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				233		/* V01*2-steps || value */,
				210		/* 'with' || value */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				186		/* 'in' || soft-space value soft-space */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-3(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[41] = createSerializationRule("NavigatingArgCS-3", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				158		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				31		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				210		/* 'with' || value */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				223		/* V00*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
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
		// EssentialOCL::NavigatingArgCS-4(essentialoclcs::NavigatingArgCS): ownedNameExpression=NavigatingArgExpCS
		serializationRules[42] = createSerializationRule("NavigatingArgCS-4", 58,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				91		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				94		/* assert |NavigatingArgCS::prefix| == 0 */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		serializationRules[43] = createSerializationRule("NavigatingBarArgCS-0", 60,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				159		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				37		/* assert (|NavigatingArgCS::prefix.'|'| - 1) == 0 */,
				200		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				131		/* NavigatingArgCS::prefix='|' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				227		/* V00*5-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				124		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				233		/* V01*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[44] = createSerializationRule("NavigatingCommaArgCS-0", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				200		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				157		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				34		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				133		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				162		/* ':' || soft-space value soft-space */,
				124		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				223		/* V00*2-steps || value */,
				210		/* 'with' || value */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				233		/* V01*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-1(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[45] = createSerializationRule("NavigatingCommaArgCS-1", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				32		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				199		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				159		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				133		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				124		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				233		/* V01*2-steps || value */,
				210		/* 'with' || value */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				186		/* 'in' || soft-space value soft-space */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-2(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { {"with"|"<-"} ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[46] = createSerializationRule("NavigatingCommaArgCS-2", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				349		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				158		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				31		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				133		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				210		/* 'with' || value */,
				35		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				223		/* V00*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
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
		// EssentialOCL::NavigatingCommaArgCS-3(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS }
		serializationRules[47] = createSerializationRule("NavigatingCommaArgCS-3", 61,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				91		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				93		/* assert |NavigatingArgCS::ownedType| == 0 */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				35		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				133		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
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
		serializationRules[48] = createSerializationRule("NavigatingSemiArgCS-0", 62,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				90		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				159		/* assign V0 = |NavigatingArgCS::ownedType| */,
				33		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				36		/* assert (|NavigatingArgCS::prefix.';'| - 1) == 0 */,
				200		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				132		/* NavigatingArgCS::prefix=';' || no-space value soft-new-line */,
				78		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				227		/* V00*5-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				124		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				233		/* V01*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NestedExpCS-0(essentialoclcs::NestedExpCS): { "(" ownedExpression=ExpCS ")" }
		serializationRules[49] = createSerializationRule("NestedExpCS-0", 64,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				353		/* check-rule essentialoclcs::NestedExpCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				38		/* assert (|NestedExpCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				151		/* '(' || value no-space */,
				53		/* NestedExpCS::ownedExpression=ExpCS || value */,
				153		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NullLiteralExpCS-0(essentialoclcs::NullLiteralExpCS): "null"
		serializationRules[50] = createSerializationRule("NullLiteralExpCS-0", 66,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				194		/* 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::NumberLiteralExpCS-0(essentialoclcs::NumberLiteralExpCS): symbol=NUMBER_LITERAL
		serializationRules[51] = createSerializationRule("NumberLiteralExpCS-0", 67,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				39		/* assert (|NumberLiteralExpCS::symbol| - 1) == 0 */
			),
			createSerializationSteps(
				141		/* NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::PatternExpCS-0(essentialoclcs::PatternExpCS): { patternVariableName=UnrestrictedName[?] ":" ownedPatternType=TypeExpCS }
		serializationRules[52] = createSerializationRule("PatternExpCS-0", 72,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				357		/* check-rule essentialoclcs::PatternExpCS.ownedPatternType : TypeExpCS */,
				44		/* assert (|PatternExpCS::ownedPatternType| - 1) == 0 */,
				161		/* assign V0 = |PatternExpCS::patternVariableName| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				130		/* PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				99		/* PatternExpCS::ownedPatternType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedLetExpCS-1(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedLetExpCS }
		serializationRules[53] = createSerializationRule("PrefixedLetExpCS-1", 75,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				356		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : LetExpCS|PrefixedLetExpCS */,
				40		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				285		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				297		/* OperatorExpCS::ownedRight=PrefixedLetExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 32/* PrefixedLetExpCS */,
					(75/*PrefixedLetExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedPrimaryExpCS-15(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS }
		serializationRules[54] = createSerializationRule("PrefixedPrimaryExpCS-15", 76,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				355		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				40		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				285		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				298		/* OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 34/* PrefixedPrimaryExpCS */,
					(76/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrimitiveTypeCS-0(basecs::PrimitiveTypeRefCS): name=PrimitiveTypeIdentifier
		serializationRules[55] = createSerializationRule("PrimitiveTypeCS-0", 79,
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
		serializationRules[56] = createSerializationRule("RoundBracketedClauseCS-0", 87,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				152		/* '(' || no-space value no-space */,
				225		/* V00*3-steps || value */,
				291		/* RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value */,
				232		/* V01*1-steps || value */,
				292		/* RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value */,
				153		/* ')' || no-space value */
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
		serializationRules[57] = createSerializationRule("SelfExpCS-0", 93,
			createSerializationMatchSteps(
				106		/* assert |SelfExpCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				202		/* 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::ShadowPartCS-0(essentialoclcs::ShadowPartCS): { referredProperty=UnrestrictedName "=" ownedInitExpression=(ExpCS|PatternExpCS) }
		serializationRules[58] = createSerializationRule("ShadowPartCS-0", 94,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				359		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				51		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */,
				52		/* assert (|ShadowPartCS::referredProperty| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				135		/* ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space */,
				166		/* '=' || soft-space value soft-space */,
				65		/* ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 29/* ExpCS,PatternExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/,
					(72/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, -1
				)
			});
		// EssentialOCL::ShadowPartCS-1(essentialoclcs::ShadowPartCS): ownedInitExpression=StringLiteralExpCS
		serializationRules[59] = createSerializationRule("ShadowPartCS-1", 94,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				107		/* assert |ShadowPartCS::referredProperty| == 0 */,
				358		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : StringLiteralExpCS */,
				51		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */
			),
			createSerializationSteps(
				66		/* ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 45/* StringLiteralExpCS */,
					(100/*StringLiteralExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SimplePathNameCS-0(basecs::PathNameCS): ownedPathElements+=FirstPathElementCS
		serializationRules[60] = createSerializationRule("SimplePathNameCS-0", 95,
			createSerializationMatchSteps(
				296		/* check-rule basecs::PathNameCS.ownedPathElements : FirstPathElementCS */,
				42		/* assert (|PathNameCS::ownedPathElements| - 1) == 0 */
			),
			createSerializationSteps(
				294		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 9/* FirstPathElementCS */,
					(30/*FirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SquareBracketedClauseCS-0(essentialoclcs::SquareBracketedClauseCS): { "[" ownedTerms+=ExpCS { "," ownedTerms+=ExpCS }[*] "]" }
		serializationRules[61] = createSerializationRule("SquareBracketedClauseCS-0", 98,
			createSerializationMatchSteps(
				360		/* check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				133		/* assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1) */
			),
			createSerializationSteps(
				170		/* '[' || no-space value no-space */,
				116		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				224		/* V00*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				116		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				171		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::StringLiteralExpCS-0(essentialoclcs::StringLiteralExpCS): segments+=StringLiteral[+]
		serializationRules[62] = createSerializationRule("StringLiteralExpCS-0", 100,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				168		/* assign V0 = |StringLiteralExpCS::segments| */
			),
			createSerializationSteps(
				222		/* V00*1-steps || value */,
				138		/* StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, false, GrammarCardinality.ONE_OR_MORE)
			});
		// EssentialOCL::TupleLiteralExpCS-0(essentialoclcs::TupleLiteralExpCS): { "Tuple" "{" ownedParts+=TupleLiteralPartCS { "," ownedParts+=TupleLiteralPartCS }[*] "}" }
		serializationRules[63] = createSerializationRule("TupleLiteralExpCS-0", 109,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				361		/* check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : TupleLiteralPartCS */,
				136		/* assign V0 = (|TupleLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				169		/* 'Tuple' || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				89		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				89		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 56/* TupleLiteralPartCS */,
					(110/*TupleLiteralPartCS*/ << 4) | 3 /*[+]*/
				)
			});
	}
	private void initSerializationRules1() {
		// EssentialOCL::TupleLiteralPartCS-0(essentialoclcs::TupleLiteralPartCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[64] = createSerializationRule("TupleLiteralPartCS-0", 110,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				366		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				367		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				66		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				178		/* assign V0 = |VariableCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				126		/* VariableCS::ownedType=TypeExpCS || value */,
				166		/* '=' || soft-space value soft-space */,
				68		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TuplePartCS-0(basecs::TuplePartCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[65] = createSerializationRule("TuplePartCS-0", 111,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TupleTypeCS-0(basecs::TupleTypeCS): { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] }
		serializationRules[66] = createSerializationRule("TupleTypeCS-0", 112,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				308		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				137		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				188		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				221		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				229		/* V00*7-steps || value */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				153		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 57/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeExpCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[67] = createSerializationRule("TypeExpCS-0", 113,
			createSerializationMatchSteps(
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				176		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				48		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				25		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[68] = createSerializationRule("TypeExpCS-1", 113,
			createSerializationMatchSteps(
				327		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				234		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				145		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				194		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				122		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				231		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				153		/* ')' || no-space value */,
				238		/* V02*1-steps || value */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 59/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[69] = createSerializationRule("TypeExpCS-2", 113,
			createSerializationMatchSteps(
				347		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				348		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				211		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				153		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				160		/* ',' || no-space value soft-space */,
				128		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				153		/* ')' || no-space value */,
				231		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-3(essentialoclcs::TypeNameExpCS): { { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[70] = createSerializationRule("TypeExpCS-3", 113,
			createSerializationMatchSteps(
				363		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				364		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				365		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				234		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				172		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				61		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				209		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				96		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				227		/* V00*5-steps || value */,
				43		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				235		/* V01*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				98		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				238		/* V02*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 27/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-4(essentialoclcs::CollectionPatternCS): { { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[71] = createSerializationRule("TypeExpCS-4", 113,
			createSerializationMatchSteps(
				73		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				325		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				326		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				234		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				144		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				181		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				7		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				121		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				228		/* V00*6-steps || value */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				234		/* V01*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				86		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				158		/* '++' || soft-space value soft-space */,
				137		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				238		/* V02*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 28/* PatternExpCS */,
					(72/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 3/* CollectionTypeCS */,
					(10/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeExpCS-5(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[72] = createSerializationRule("TypeExpCS-5", 113,
			createSerializationMatchSteps(
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				308		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				251		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				137		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				188		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				221		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				229		/* V00*7-steps || value */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				153		/* ')' || no-space value */,
				246		/* V03*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 57/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeLiteralExpCS-0(essentialoclcs::TypeLiteralExpCS): ownedType=TypeLiteralWithMultiplicityCS
		serializationRules[73] = createSerializationRule("TypeLiteralExpCS-0", 116,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				117		/* assert |TypeLiteralExpCS::ownedPathName| == 0 */,
				362		/* check-rule essentialoclcs::TypeLiteralExpCS.ownedType : TypeLiteralWithMultiplicityCS */,
				60		/* assert (|TypeLiteralExpCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				125		/* TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 61/* TypeLiteralWithMultiplicityCS */,
					(117/*TypeLiteralWithMultiplicityCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[74] = createSerializationRule("TypeLiteralWithMultiplicityCS-0", 117,
			createSerializationMatchSteps(
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				176		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				48		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				25		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[75] = createSerializationRule("TypeLiteralWithMultiplicityCS-1", 117,
			createSerializationMatchSteps(
				327		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				234		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				145		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				194		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				122		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				231		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				153		/* ')' || no-space value */,
				238		/* V02*1-steps || value */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 59/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[76] = createSerializationRule("TypeLiteralWithMultiplicityCS-2", 117,
			createSerializationMatchSteps(
				347		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				348		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				211		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				153		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				160		/* ',' || no-space value soft-space */,
				128		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				153		/* ')' || no-space value */,
				231		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-3(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[77] = createSerializationRule("TypeLiteralWithMultiplicityCS-3", 117,
			createSerializationMatchSteps(
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				308		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				251		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				137		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				188		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				221		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				229		/* V00*7-steps || value */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				153		/* ')' || no-space value */,
				246		/* V03*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 57/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeNameExpCS-0(essentialoclcs::TypeNameExpCS): { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] }
		serializationRules[78] = createSerializationRule("TypeNameExpCS-0", 118,
			createSerializationMatchSteps(
				120		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				363		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				364		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				365		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				172		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				61		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				209		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				96		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				227		/* V00*5-steps || value */,
				43		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				235		/* V01*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				98		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(13/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 27/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::URIFirstPathElementCS-0(basecs::PathElementWithURICS): referredElement=URI
		serializationRules[79] = createSerializationRule("URIFirstPathElementCS-0", 127,
			createSerializationMatchSteps(
				41		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* PathElementCS::referredElement=URI || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIFirstPathElementCS-1(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[80] = createSerializationRule("URIFirstPathElementCS-1", 127,
			createSerializationMatchSteps(
				41		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				313		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=URIFirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[81] = createSerializationRule("URIPathNameCS-0", 128,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				293		/* PathNameCS::ownedPathElements+=URIFirstPathElementCS || value */,
				224		/* V00*2-steps || value */,
				163		/* '::' || no-space value no-space */,
				295		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 68/* NextPathElementCS,URIFirstPathElementCS */,
					(65/*NextPathElementCS*/ << 4) | 2 /*[*]*/,
					(127/*URIFirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::UnlimitedNaturalLiteralExpCS-0(essentialoclcs::UnlimitedNaturalLiteralExpCS): "*"
		serializationRules[82] = createSerializationRule("UnlimitedNaturalLiteralExpCS-0", 130,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				157		/* '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// QVTbase::AttributeCS-0(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[83] = createSerializationRule("AttributeCS-0", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				230		/* assign V2 = |StructuralFeatureCS::default| */,
				210		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				175		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				240		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				261		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				172		/* 'attribute' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V03*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				255		/* V04*1-steps || value */,
				306		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-1(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[84] = createSerializationRule("AttributeCS-1", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				299		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				230		/* assign V2 = |StructuralFeatureCS::default| */,
				210		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				175		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				240		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				261		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				267		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				270		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				278		/* assign V7 = 0 */,
				283		/* assign V8 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				172		/* 'attribute' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V03*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				255		/* V04*1-steps || value */,
				306		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				267		/* V05*5-steps || value */,
				176		/* 'derivation' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				268		/* V06*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				277		/* V07*5-steps || value */,
				188		/* 'initial' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				278		/* V08*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-2(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[85] = createSerializationRule("AttributeCS-2", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				230		/* assign V2 = |StructuralFeatureCS::default| */,
				210		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				240		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				261		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				172		/* 'attribute' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V03*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				255		/* V04*1-steps || value */,
				306		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-3(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[86] = createSerializationRule("AttributeCS-3", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				299		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				230		/* assign V2 = |StructuralFeatureCS::default| */,
				210		/* assign V1 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				240		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				261		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				267		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				270		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				278		/* assign V7 = 0 */,
				283		/* assign V8 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				172		/* 'attribute' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V03*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				255		/* V04*1-steps || value */,
				306		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				267		/* V05*5-steps || value */,
				176		/* 'derivation' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				268		/* V06*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				277		/* V07*5-steps || value */,
				188		/* 'initial' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				278		/* V08*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-4(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[87] = createSerializationRule("AttributeCS-4", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				205		/* assign V1 = |StructuralFeatureCS::default| */,
				173		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				222		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				250		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				172		/* 'attribute' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				233		/* V01*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				244		/* V02*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				248		/* V03*1-steps || value */,
				306		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-5(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[88] = createSerializationRule("AttributeCS-5", 1,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				299		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				205		/* assign V1 = |StructuralFeatureCS::default| */,
				173		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				222		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				250		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				257		/* assign V4 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				264		/* assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				272		/* assign V6 = 0 */,
				278		/* assign V7 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				172		/* 'attribute' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				233		/* V01*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				244		/* V02*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				248		/* V03*1-steps || value */,
				306		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				260		/* V04*5-steps || value */,
				176		/* 'derivation' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				261		/* V05*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				272		/* V06*5-steps || value */,
				188		/* 'initial' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				273		/* V07*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::CompoundTargetElementCS-0(qvtbasecs::CompoundTargetElementCS): { "{" ownedTargetElements+=SimpleTargetElementCS[*] "}" }
		serializationRules[89] = createSerializationRule("CompoundTargetElementCS-0", 12,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				370		/* check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : SimpleTargetElementCS */,
				146		/* assign V0 = |CompoundTargetElementCS::ownedTargetElements| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				213		/* '{' || soft-space value push soft-new-line */,
				220		/* V00*1-steps || value */,
				113		/* CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 41/* SimpleTargetElementCS */,
					(96/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::DataTypeCS-0(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[90] = createSerializationRule("DataTypeCS-0", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				226		/* assign V2 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				147		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				241		/* assign V3 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				175		/* 'datatype' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				251		/* V03*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				147		/* '!serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-1(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" "}" } }
		serializationRules[91] = createSerializationRule("DataTypeCS-1", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				226		/* assign V2 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				147		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				241		/* assign V3 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				175		/* 'datatype' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				251		/* V03*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				147		/* '!serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-2(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[92] = createSerializationRule("DataTypeCS-2", 15,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				243		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				226		/* assign V2 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				147		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				175		/* 'datatype' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				251		/* V03*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				18		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
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
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-3(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" "}" } }
		serializationRules[93] = createSerializationRule("DataTypeCS-3", 15,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				243		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				226		/* assign V2 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				147		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				175		/* 'datatype' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				251		/* V03*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				18		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
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
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-4(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[94] = createSerializationRule("DataTypeCS-4", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				226		/* assign V2 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				147		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				241		/* assign V3 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				175		/* 'datatype' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				249		/* V03*2-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-5(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" "}" } }
		serializationRules[95] = createSerializationRule("DataTypeCS-5", 15,
			createSerializationMatchSteps(
				75		/* assert |DataTypeCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				226		/* assign V2 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				147		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				241		/* assign V3 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				17		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				175		/* 'datatype' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				249		/* V03*2-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(21/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-0(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[96] = createSerializationRule("EnumerationCS-0", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				80		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				193		/* assign V1 = |ClassCS::instanceClassName| */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				223		/* assign V2 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				180		/* 'enum' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				243		/* V02*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				147		/* '!serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-1(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[97] = createSerializationRule("EnumerationCS-1", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				289		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				244		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				193		/* assign V1 = |ClassCS::instanceClassName| */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				223		/* assign V2 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				180		/* 'enum' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				243		/* V02*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				147		/* '!serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				247		/* V03*1-steps || value */,
				73		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(21/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-2(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[98] = createSerializationRule("EnumerationCS-2", 20,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				80		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				227		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				193		/* assign V1 = |ClassCS::instanceClassName| */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				180		/* 'enum' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				243		/* V02*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				19		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(22/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-3(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[99] = createSerializationRule("EnumerationCS-3", 20,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				289		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				244		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				227		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				193		/* assign V1 = |ClassCS::instanceClassName| */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				180		/* 'enum' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				243		/* V02*3-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				19		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				247		/* V03*1-steps || value */,
				73		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
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
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-4(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[100] = createSerializationRule("EnumerationCS-4", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				80		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				193		/* assign V1 = |ClassCS::instanceClassName| */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				223		/* assign V2 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				180		/* 'enum' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-5(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[101] = createSerializationRule("EnumerationCS-5", 20,
			createSerializationMatchSteps(
				79		/* assert |EnumerationCS::isSerializable| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				289		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				244		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				193		/* assign V1 = |ClassCS::instanceClassName| */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				223		/* assign V2 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				180		/* 'enum' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				247		/* V03*1-steps || value */,
				73		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(21/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationLiteralCS-0(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] ";" }
		serializationRules[102] = createSerializationRule("EnumerationLiteralCS-0", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				149		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				192		/* 'literal' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				145		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-1(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[103] = createSerializationRule("EnumerationLiteralCS-1", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				149		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				192		/* 'literal' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				145		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-2(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] ";" }
		serializationRules[104] = createSerializationRule("EnumerationLiteralCS-2", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				149		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				289		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				145		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-3(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[105] = createSerializationRule("EnumerationLiteralCS-3", 21,
			createSerializationMatchSteps(
				81		/* assert |EnumerationLiteralCS::literal| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				149		/* assign V0 = |EnumerationLiteralCS::value| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				289		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				145		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::OperationCS-0(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[106] = createSerializationRule("OperationCS-0", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				95		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				292		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				293		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				259		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				175		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				263		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				269		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				217		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				237		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				277		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				285		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				195		/* 'operation' || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				244		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				250		/* V03*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				153		/* ')' || no-space value */,
				256		/* V04*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				266		/* V05*5-steps || value */,
				206		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				270		/* V06*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				276		/* V07*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				280		/* V08*1-steps || value */,
				307		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 26/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-1(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[107] = createSerializationRule("OperationCS-1", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				291		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				292		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				293		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				259		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				175		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				286		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				214		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				263		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				269		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				217		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				237		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				277		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				285		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				195		/* 'operation' || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				244		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				250		/* V03*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				153		/* ')' || no-space value */,
				256		/* V04*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				266		/* V05*5-steps || value */,
				206		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				270		/* V06*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				276		/* V07*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				280		/* V08*1-steps || value */,
				307		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				283		/* V09*5-steps || value */,
				173		/* 'body' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				237		/* V10*1-steps || value */,
				32		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 26/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-2(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[108] = createSerializationRule("OperationCS-2", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				95		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				292		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				293		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				259		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				263		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				269		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				217		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				237		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				277		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				285		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				195		/* 'operation' || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				244		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				250		/* V03*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				153		/* ')' || no-space value */,
				256		/* V04*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				266		/* V05*5-steps || value */,
				206		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				270		/* V06*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				276		/* V07*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				280		/* V08*1-steps || value */,
				307		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 26/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-3(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[109] = createSerializationRule("OperationCS-3", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				291		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				292		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				293		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				259		/* assign V4 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				286		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				214		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				263		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				269		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				217		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				237		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				277		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				285		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				195		/* 'operation' || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				244		/* V02*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				250		/* V03*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				153		/* ')' || no-space value */,
				256		/* V04*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				266		/* V05*5-steps || value */,
				206		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				270		/* V06*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				276		/* V07*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				280		/* V08*1-steps || value */,
				307		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				283		/* V09*5-steps || value */,
				173		/* 'body' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				237		/* V10*1-steps || value */,
				32		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 26/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-4(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[110] = createSerializationRule("OperationCS-4", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				95		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				292		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				293		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				249		/* assign V3 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				271		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				281		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				253		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				262		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				185		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				216		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				195		/* 'operation' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				153		/* ')' || no-space value */,
				249		/* V03*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				259		/* V04*5-steps || value */,
				206		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				264		/* V05*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				271		/* V06*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				275		/* V07*1-steps || value */,
				307		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 26/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-5(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[111] = createSerializationRule("OperationCS-5", 68,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				96		/* assert |OperationCS::ownedPostconditions| == 0 */,
				97		/* assert |OperationCS::ownedPreconditions| == 0 */,
				291		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				292		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				293		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				249		/* assign V3 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				171		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				282		/* assign V8 = (|OperationCS::ownedBodyExpressions| > 0) */,
				288		/* assign V9 = |OperationCS::ownedBodyExpressions| */,
				271		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				281		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				253		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				262		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				185		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				216		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				195		/* 'operation' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				82		/* OperationCS::ownedParameters+=ParameterCS || value */,
				153		/* ')' || no-space value */,
				249		/* V03*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				259		/* V04*5-steps || value */,
				206		/* 'throws' || soft-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				264		/* V05*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				48		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				271		/* V06*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				275		/* V07*1-steps || value */,
				307		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				281		/* V08*5-steps || value */,
				173		/* 'body' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				282		/* V09*1-steps || value */,
				32		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 26/* ParameterCS */,
					(70/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ParameterCS-0(basecs::ParameterCS): { name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "{" { qualifiers+={'!ordered|!unique|ordered|unique'} }[+] "}" }[?] { "{" "}" }[?] }
		serializationRules[112] = createSerializationRule("ParameterCS-0", 70,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				173		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				190		/* assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0) */,
				233		/* assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| */,
				241		/* assign V3 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				236		/* V01*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				240		/* V02*1-steps || value */,
				308		/* TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				249		/* V03*2-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(3/*'!ordered|!unique|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ReferenceCS-0(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[113] = createSerializationRule("ReferenceCS-0", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				246		/* assign V3 = |StructuralFeatureCS::default| */,
				232		/* assign V2 = |TypedElementCS::ownedType| */,
				204		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				175		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				254		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				268		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				198		/* 'property' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				148		/* '#' || no-space value no-space */,
				134		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				249		/* V03*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				258		/* V04*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				263		/* V05*1-steps || value */,
				305		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-1(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[114] = createSerializationRule("ReferenceCS-1", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				299		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				246		/* assign V3 = |StructuralFeatureCS::default| */,
				232		/* assign V2 = |TypedElementCS::ownedType| */,
				204		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				175		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				63		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				254		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				268		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				274		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				276		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				283		/* assign V8 = 0 */,
				287		/* assign V9 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				198		/* 'property' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				148		/* '#' || no-space value no-space */,
				134		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				249		/* V03*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				258		/* V04*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				263		/* V05*1-steps || value */,
				305		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				272		/* V06*5-steps || value */,
				176		/* 'derivation' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				273		/* V07*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				281		/* V08*5-steps || value */,
				188		/* 'initial' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				282		/* V09*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(23/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-2(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[115] = createSerializationRule("ReferenceCS-2", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				246		/* assign V3 = |StructuralFeatureCS::default| */,
				232		/* assign V2 = |TypedElementCS::ownedType| */,
				204		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				254		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				268		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				198		/* 'property' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				148		/* '#' || no-space value no-space */,
				134		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				249		/* V03*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				258		/* V04*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				263		/* V05*1-steps || value */,
				305		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-3(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[116] = createSerializationRule("ReferenceCS-3", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				299		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				246		/* assign V3 = |StructuralFeatureCS::default| */,
				232		/* assign V2 = |TypedElementCS::ownedType| */,
				204		/* assign V1 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				174		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				64		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				254		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				268		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				274		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				276		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				283		/* assign V8 = 0 */,
				287		/* assign V9 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				310		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				309		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				198		/* 'property' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				148		/* '#' || no-space value no-space */,
				134		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				249		/* V03*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				258		/* V04*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				263		/* V05*1-steps || value */,
				305		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				272		/* V06*5-steps || value */,
				176		/* 'derivation' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				273		/* V07*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				281		/* V08*5-steps || value */,
				188		/* 'initial' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				282		/* V09*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(23/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-4(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[117] = createSerializationRule("ReferenceCS-4", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				230		/* assign V2 = |StructuralFeatureCS::default| */,
				210		/* assign V1 = |TypedElementCS::ownedType| */,
				165		/* assign V0 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				239		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				260		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				198		/* 'property' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				148		/* '#' || no-space value no-space */,
				134		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V03*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				255		/* V04*1-steps || value */,
				305		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-5(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[118] = createSerializationRule("ReferenceCS-5", 86,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				103		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				104		/* assert |ReferenceCS::referredKeys| == 0 */,
				299		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				230		/* assign V2 = |StructuralFeatureCS::default| */,
				210		/* assign V1 = |TypedElementCS::ownedType| */,
				165		/* assign V0 = |ReferenceCS::referredOpposite| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				239		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				260		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				267		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				270		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				278		/* assign V7 = 0 */,
				283		/* assign V8 = 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				198		/* 'property' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				148		/* '#' || no-space value no-space */,
				134		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				300		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				252		/* V03*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				255		/* V04*1-steps || value */,
				305		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				267		/* V05*5-steps || value */,
				176		/* 'derivation' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				268		/* V06*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				277		/* V07*5-steps || value */,
				188		/* 'initial' || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				278		/* V08*1-steps || value */,
				44		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 43/* SpecificationCS */,
					(97/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 65/* TypedMultiplicityRefCS */,
					(121/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-0(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[119] = createSerializationRule("SimpleTargetElementCS-0", 96,
			createSerializationMatchSteps(
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				167		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				53		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				5		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				142		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				190		/* 'iterates' || soft-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[120] = createSerializationRule("SimpleTargetElementCS-1", 96,
			createSerializationMatchSteps(
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				53		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */,
				132		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				187		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				219		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				5		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				142		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				230		/* V00*8-steps || value */,
				190		/* 'iterates' || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				236		/* V01*4-steps || value */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[121] = createSerializationRule("SimpleTargetElementCS-2", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				167		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				54		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				29		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				142		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				190		/* 'iterates' || soft-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[122] = createSerializationRule("SimpleTargetElementCS-3", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				110		/* assert |SimpleTargetElementCS::via| == 0 */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				54		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */,
				132		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				187		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				219		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				29		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				142		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				230		/* V00*8-steps || value */,
				190		/* 'iterates' || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				236		/* V01*4-steps || value */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[123] = createSerializationRule("SimpleTargetElementCS-4", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				167		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				56		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				146		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				142		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				190		/* 'iterates' || soft-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[124] = createSerializationRule("SimpleTargetElementCS-5", 96,
			createSerializationMatchSteps(
				108		/* assert |SimpleTargetElementCS::input| == 0 */,
				109		/* assert |SimpleTargetElementCS::output| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				55		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				56		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */,
				132		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				187		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				219		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				146		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				142		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				230		/* V00*8-steps || value */,
				190		/* 'iterates' || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				236		/* V01*4-steps || value */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				21		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[125] = createSerializationRule("SpecificationCS-0", 97,
			createSerializationMatchSteps(
				111		/* assert |SpecificationCS::exprString| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				331		/* check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		serializationRules[126] = createSerializationRule("SpecificationCS-1", 97,
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
		serializationRules[127] = createSerializationRule("StructuredClassCS-0", 102,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				113		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				114		/* assert |StructuredClassCS::ownedOperations| == 0 */,
				115		/* assert |StructuredClassCS::ownedProperties| == 0 */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				302		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				255		/* assign V4 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				169		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				265		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				275		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				220		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				238		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				8		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				174		/* 'class' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				245		/* V02*5-steps || value */,
				181		/* 'extends' || soft-space value soft-space */,
				111		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				250		/* V03*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				111		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				256		/* V04*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				265		/* V05*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				268		/* V06*1-steps || value */,
				13		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				165		/* ';' || no-space value soft-new-line */
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
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
	}
	private void initSerializationRules2() {
		// QVTbase::StructuredClassCS-1(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] { "{" { ownedOperations+=OperationCS[*] ownedProperties+=StructuralFeatureCS[*] } "}" } }
		serializationRules[128] = createSerializationRule("StructuredClassCS-1", 102,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				113		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				300		/* check-rule basecs::StructuredClassCS.ownedOperations : OperationCS */,
				301		/* check-rule basecs::StructuredClassCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				307		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				302		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				284		/* assign V8 = |StructuredClassCS::ownedProperties| */,
				280		/* assign V7 = |StructuredClassCS::ownedOperations| */,
				255		/* assign V4 = |ClassCS::instanceClassName| */,
				207		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				169		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				265		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				275		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				220		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				238		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				8		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				174		/* 'class' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				108		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				245		/* V02*5-steps || value */,
				181		/* 'extends' || soft-space value soft-space */,
				111		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				250		/* V03*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				111		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				256		/* V04*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				6		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				265		/* V05*4-steps || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				268		/* V06*1-steps || value */,
				13		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				217		/* '}' || pop soft-new-line value soft-new-line */,
				213		/* '{' || soft-space value push soft-new-line */,
				274		/* V07*1-steps || value */,
				80		/* StructuredClassCS::ownedOperations+=OperationCS || value */,
				279		/* V08*1-steps || value */,
				101		/* StructuredClassCS::ownedProperties+=StructuralFeatureCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
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
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 24/* OperationCS */,
					(68/*OperationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 46/* StructuralFeatureCS */,
					(101/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 52/* TemplateSignatureCS */,
					(106/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 66/* TypedRefCS */,
					(122/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::TargetCS-0(qvtbasecs::TargetCS): { "target" name=UnrestrictedName "{" ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)[*] "}" }
		serializationRules[129] = createSerializationRule("TargetCS-0", 103,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				372		/* check-rule qvtbasecs::TargetCS.ownedTargetElements : CompoundTargetElementCS|SimpleTargetElementCS */,
				170		/* assign V0 = |TargetCS::ownedTargetElements| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				203		/* 'target' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				220		/* V00*1-steps || value */,
				114		/* TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 42/* CompoundTargetElementCS,SimpleTargetElementCS */,
					(12/*CompoundTargetElementCS*/ << 4) | 2 /*[*]*/,
					(96/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[130] = createSerializationRule("TypedMultiplicityRefCS-0", 121,
			createSerializationMatchSteps(
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				176		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				48		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				25		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-1(basecs::TypedTypeRefCS): { { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[131] = createSerializationRule("TypedMultiplicityRefCS-1", 121,
			createSerializationMatchSteps(
				121		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				313		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				314		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				211		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				177		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				65		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				97		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				225		/* V00*3-steps || value */,
				152		/* '(' || no-space value no-space */,
				31		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				153		/* ')' || no-space value */,
				231		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 50/* TemplateBindingCS */,
					(104/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 27/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-2(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[132] = createSerializationRule("TypedMultiplicityRefCS-2", 121,
			createSerializationMatchSteps(
				327		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				234		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				145		/* assign V0 = |CollectionTypeCS::ownedType| */,
				8		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				194		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				23		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				122		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				231		/* V01*1-steps || value */,
				36		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				153		/* ')' || no-space value */,
				238		/* V02*1-steps || value */,
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
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 59/* TypeExpWithoutMultiplicityCS */,
					(114/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-3(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[133] = createSerializationRule("TypedMultiplicityRefCS-3", 121,
			createSerializationMatchSteps(
				347		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				348		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				211		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				153		/* assign V0 = |MapTypeCS::ownedValueType| */,
				26		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				25		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				24		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				227		/* V00*5-steps || value */,
				152		/* '(' || no-space value no-space */,
				70		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				160		/* ',' || no-space value soft-space */,
				128		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				153		/* ')' || no-space value */,
				231		/* V01*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-4(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[134] = createSerializationRule("TypedMultiplicityRefCS-4", 121,
			createSerializationMatchSteps(
				312		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				308		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				251		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				59		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				137		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				188		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				221		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				26		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				229		/* V00*7-steps || value */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				90		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				153		/* ')' || no-space value */,
				246		/* V03*1-steps || value */,
				77		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 17/* MultiplicityCS */,
					(53/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 57/* TuplePartCS */,
					(111/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::BottomPatternCS-0(qvtcorecs::BottomPatternCS): { "{" "}" }
		serializationRules[135] = createSerializationRule("BottomPatternCS-0", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* '{' || soft-new-line value push */,
				216		/* '}' || pop value soft-new-line */
			),
			null);
		// QVTcore::BottomPatternCS-1(qvtcorecs::BottomPatternCS): { "{" ownedConstraints+=PredicateOrAssignmentCS[+] "}" }
		serializationRules[136] = createSerializationRule("BottomPatternCS-1", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				375		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				141		/* assign V0 = |BottomPatternCS::ownedConstraints| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* '{' || soft-new-line value push */,
				222		/* V00*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || soft-new-line value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 31/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-2(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[137] = createSerializationRule("BottomPatternCS-2", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				375		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				382		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				192		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				131		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				212		/* '{' || soft-new-line value push soft-new-line */,
				301		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				301		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				214		/* '|' || soft-new-line pop value push */,
				232		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || soft-new-line value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 31/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 79/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-3(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[138] = createSerializationRule("BottomPatternCS-3", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				375		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				376		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				382		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				192		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				142		/* assign V0 = |BottomPatternCS::ownedRealizedVariables| */,
				43		/* assert (|PatternCS::ownedUnrealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				212		/* '{' || soft-new-line value push soft-new-line */,
				301		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				214		/* '|' || soft-new-line pop value push */,
				232		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || soft-new-line value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 31/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 37/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 79/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::BottomPatternCS-4(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[139] = createSerializationRule("BottomPatternCS-4", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				375		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				376		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				382		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				192		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				160		/* assign V0 = |PatternCS::ownedUnrealizedVariables| */,
				4		/* assert (|BottomPatternCS::ownedRealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				212		/* '{' || soft-new-line value push soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				301		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				214		/* '|' || soft-new-line pop value push */,
				232		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || soft-new-line value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 31/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 37/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 79/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::BottomPatternCS-5(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "|" ownedConstraints+=PredicateOrAssignmentCS[*] "}" }
		serializationRules[140] = createSerializationRule("BottomPatternCS-5", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				375		/* check-rule qvtcorecs::BottomPatternCS.ownedConstraints : PredicateOrAssignmentCS */,
				376		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				192		/* assign V1 = |BottomPatternCS::ownedConstraints| */,
				125		/* assign V0 = (|BottomPatternCS::ownedRealizedVariables| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				212		/* '{' || soft-new-line value push soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				214		/* '|' || soft-new-line pop value push */,
				232		/* V01*1-steps || value */,
				41		/* BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || soft-new-line value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 31/* PredicateOrAssignmentCS */,
					(74/*PredicateOrAssignmentCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 37/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-6(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "}" }
		serializationRules[141] = createSerializationRule("BottomPatternCS-6", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				69		/* assert |BottomPatternCS::ownedRealizedVariables| == 0 */,
				382		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				131		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* '{' || soft-new-line value push */,
				303		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || soft-new-line value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				301		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 79/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::BottomPatternCS-7(qvtcorecs::BottomPatternCS): { "{" ownedUnrealizedVariables+=UnrealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "}" }
		serializationRules[142] = createSerializationRule("BottomPatternCS-7", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				376		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				382		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				142		/* assign V0 = |BottomPatternCS::ownedRealizedVariables| */,
				43		/* assert (|PatternCS::ownedUnrealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* '{' || soft-new-line value push */,
				301		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				105		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || soft-new-line value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 37/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 79/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::BottomPatternCS-8(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedUnrealizedVariables+=UnrealizedVariableCS }[*] "}" }
		serializationRules[143] = createSerializationRule("BottomPatternCS-8", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				376		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				382		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : UnrealizedVariableCS */,
				160		/* assign V0 = |PatternCS::ownedUnrealizedVariables| */,
				4		/* assert (|BottomPatternCS::ownedRealizedVariables| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* '{' || soft-new-line value push */,
				105		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || soft-new-line value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				301		/* PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 37/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 79/* UnrealizedVariableCS */,
					(132/*UnrealizedVariableCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::BottomPatternCS-9(qvtcorecs::BottomPatternCS): { "{" ownedRealizedVariables+=RealizedVariableCS { "," ownedRealizedVariables+=RealizedVariableCS }[*] "}" }
		serializationRules[144] = createSerializationRule("BottomPatternCS-9", 4,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				67		/* assert |BottomPatternCS::ownedConstraints| == 0 */,
				68		/* assert |BottomPatternCS::ownedEnforcementOperations| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				376		/* check-rule qvtcorecs::BottomPatternCS.ownedRealizedVariables : RealizedVariableCS */,
				125		/* assign V0 = (|BottomPatternCS::ownedRealizedVariables| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				211		/* '{' || soft-new-line value push */,
				105		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || soft-new-line value */,
				224		/* V00*2-steps || value */,
				159		/* ',' || no-space value soft-new-line */,
				104		/* BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 37/* RealizedVariableCS */,
					(85/*RealizedVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::DirectionCS-0(qvtcorecs::DirectionCS): { name=Identifier[?] "imports" imports+=UnrestrictedName { "," imports+=UnrestrictedName }[*] { "uses" uses+=UnrestrictedName { "," uses+=UnrestrictedName }[*] }[?] }
		serializationRules[145] = createSerializationRule("DirectionCS-0", 16,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				183		/* assign V1 = (|DirectionCS::imports| - 1) */,
				156		/* assign V0 = |NamedElementCS::name| */,
				215		/* assign V2 = (|DirectionCS::uses| > 0) */,
				235		/* assign V3 = (|DirectionCS::uses| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				290		/* NamedElementCS::name=Identifier || soft-space value soft-space */,
				185		/* 'imports' || soft-space value soft-space */,
				4		/* DirectionCS::imports+=UnrestrictedName || soft-space value soft-space */,
				234		/* V01*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				4		/* DirectionCS::imports+=UnrestrictedName || soft-space value soft-space */,
				245		/* V02*5-steps || value */,
				208		/* 'uses' || soft-space value soft-space */,
				144		/* DirectionCS::uses+=UnrestrictedName || soft-space value soft-space */,
				250		/* V03*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				144		/* DirectionCS::uses+=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.DIRECTION_CS__IMPORTS, -1
				),
				createSerializationReference(QVTcoreCSPackage.Literals.DIRECTION_CS__USES, -1
				)
			});
		// QVTcore::GuardPatternCS-0(qvtcorecs::GuardPatternCS): { "(" ")" }
		serializationRules[146] = createSerializationRule("GuardPatternCS-0", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |GuardPatternCS::ownedPredicates| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				150		/* '(' || soft-new-line value push */,
				154		/* ')' || pop value soft-new-line */
			),
			null);
		// QVTcore::GuardPatternCS-1(qvtcorecs::GuardPatternCS): { "(" ownedPredicates+=PredicateCS[+] ")" }
		serializationRules[147] = createSerializationRule("GuardPatternCS-1", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				100		/* assert |PatternCS::ownedUnrealizedVariables| == 0 */,
				377		/* check-rule qvtcorecs::GuardPatternCS.ownedPredicates : PredicateCS */,
				150		/* assign V0 = |GuardPatternCS::ownedPredicates| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				150		/* '(' || soft-new-line value push */,
				222		/* V00*1-steps || value */,
				100		/* GuardPatternCS::ownedPredicates+=PredicateCS || soft-new-line value */,
				154		/* ')' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 30/* PredicateCS */,
					(73/*PredicateCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::GuardPatternCS-2(qvtcorecs::GuardPatternCS): { "(" ownedUnrealizedVariables+=GuardVariableCS { "," ownedUnrealizedVariables+=GuardVariableCS }[*] ")" }
		serializationRules[148] = createSerializationRule("GuardPatternCS-2", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				83		/* assert |GuardPatternCS::ownedPredicates| == 0 */,
				383		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : GuardVariableCS */,
				131		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				150		/* '(' || soft-new-line value push */,
				304		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || soft-new-line value */,
				224		/* V00*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				304		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || soft-new-line value */,
				155		/* ')' || soft-new-line pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 11/* GuardVariableCS */,
					(32/*GuardVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::GuardPatternCS-3(qvtcorecs::GuardPatternCS): { "(" ownedUnrealizedVariables+=GuardVariableCS { "," ownedUnrealizedVariables+=GuardVariableCS }[*] "|" ownedPredicates+=PredicateCS[*] ")" }
		serializationRules[149] = createSerializationRule("GuardPatternCS-3", 31,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				377		/* check-rule qvtcorecs::GuardPatternCS.ownedPredicates : PredicateCS */,
				383		/* check-rule qvtcorecs::PatternCS.ownedUnrealizedVariables : GuardVariableCS */,
				196		/* assign V1 = |GuardPatternCS::ownedPredicates| */,
				131		/* assign V0 = (|PatternCS::ownedUnrealizedVariables| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				150		/* '(' || soft-new-line value push */,
				218		/* 1*1-steps || soft-new-line value */,
				302		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value */,
				224		/* V00*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				302		/* PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value */,
				214		/* '|' || soft-new-line pop value push */,
				232		/* V01*1-steps || value */,
				100		/* GuardPatternCS::ownedPredicates+=PredicateCS || soft-new-line value */,
				154		/* ')' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 30/* PredicateCS */,
					(73/*PredicateCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 11/* GuardVariableCS */,
					(32/*GuardVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTcore::GuardVariableCS-0(qvtcorecs::UnrealizedVariableCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[150] = createSerializationRule("GuardVariableCS-0", 32,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |UnrealizedVariableCS::ownedInitExpression| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::ImportCS-0(basecs::ImportCS): { "import" { name=Identifier ":" }[?] ownedPathName=URIPathNameCS { isAll?="::" "*" }[?] ";" }
		serializationRules[151] = createSerializationRule("ImportCS-0", 37,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				290		/* check-rule basecs::ImportCS.ownedPathName : URIPathNameCS */,
				197		/* assign V1 = |ImportCS::isAll.'::'| */,
				17		/* assert (|ImportCS::ownedPathName| - 1) == 0 */,
				156		/* assign V0 = |NamedElementCS::name| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				184		/* 'import' || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				290		/* NamedElementCS::name=Identifier || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				93		/* ImportCS::ownedPathName=URIPathNameCS || value */,
				233		/* V01*2-steps || value */,
				9		/* ImportCS::isAll?='::' || no-space value no-space */,
				156		/* '*' || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, false,
					(7/*'::'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 70/* URIPathNameCS */,
					(128/*URIPathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::MappingCS-0(qvtcorecs::MappingCS): { isAbstract?="abstract"[?] "map" name=UnrestrictedName[?] { "in" ownedInPathName=PathNameCS }[?] { "refines" refines+=UnrestrictedName { "," refines+=UnrestrictedName }[*] }[?] "{" ownedDomains+=NamedDomainCS[*] { "where" ownedMiddle=UnnamedDomainCS }[?] ownedComposedMappings+=MappingCS[*] "}" }
		serializationRules[152] = createSerializationRule("MappingCS-0", 50,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				378		/* check-rule qvtcorecs::MappingCS.ownedComposedMappings : MappingCS */,
				379		/* check-rule qvtcorecs::MappingCS.ownedDomains : NamedDomainCS */,
				380		/* check-rule qvtcorecs::MappingCS.ownedInPathName : PathNameCS */,
				381		/* check-rule qvtcorecs::MappingCS.ownedMiddle : UnnamedDomainCS */,
				279		/* assign V7 = |MappingCS::ownedComposedMappings| */,
				273		/* assign V6 = |MappingCS::ownedMiddle| */,
				266		/* assign V5 = |MappingCS::ownedDomains| */,
				228		/* assign V2 = |MappingCS::ownedInPathName| */,
				198		/* assign V1 = |NamedElementCS::name| */,
				154		/* assign V0 = |MappingCS::isAbstract.'abstract'| */,
				236		/* assign V3 = (|MappingCS::refines| > 0) */,
				252		/* assign V4 = (|MappingCS::refines| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				7		/* MappingCS::isAbstract?='abstract' || soft-space value soft-space */,
				193		/* 'map' || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				186		/* 'in' || soft-space value soft-space */,
				62		/* MappingCS::ownedInPathName=PathNameCS || value */,
				253		/* V03*5-steps || value */,
				201		/* 'refines' || soft-space value soft-space */,
				136		/* MappingCS::refines+=UnrestrictedName || soft-space value soft-space */,
				257		/* V04*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				136		/* MappingCS::refines+=UnrestrictedName || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				262		/* V05*1-steps || value */,
				46		/* MappingCS::ownedDomains+=NamedDomainCS || value */,
				269		/* V06*2-steps || value */,
				209		/* 'where' || soft-space value soft-space */,
				75		/* MappingCS::ownedMiddle=UnnamedDomainCS || value */,
				274		/* V07*1-steps || value */,
				37		/* MappingCS::ownedComposedMappings+=MappingCS || value */,
				216		/* '}' || pop value soft-new-line */
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
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_IN_PATH_NAME, 27/* PathNameCS */,
					(71/*PathNameCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__OWNED_MIDDLE, 78/* UnnamedDomainCS */,
					(131/*UnnamedDomainCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.MAPPING_CS__REFINES, -1
				)
			});
		// QVTcore::NamedDomainCS-0(qvtcorecs::DomainCS): { isCheck?="check"[?] isEnforce?="enforce"[?] direction=UnrestrictedName ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS }
		serializationRules[153] = createSerializationRule("NamedDomainCS-0", 57,
			createSerializationMatchSteps(
				89		/* assert |NamedElementCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				373		/* check-rule qvtcorecs::AreaCS.ownedBottomPattern : BottomPatternCS */,
				374		/* check-rule qvtcorecs::AreaCS.ownedGuardPattern : GuardPatternCS */,
				1		/* assert (|AreaCS::ownedBottomPattern| - 1) == 0 */,
				2		/* assert (|AreaCS::ownedGuardPattern| - 1) == 0 */,
				10		/* assert (|DomainCS::direction| - 1) == 0 */,
				195		/* assign V1 = |DomainCS::isEnforce.'enforce'| */,
				148		/* assign V0 = |DomainCS::isCheck.'check'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				10		/* DomainCS::isCheck?='check' || soft-space value soft-space */,
				231		/* V01*1-steps || value */,
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
		serializationRules[154] = createSerializationRule("ParamDeclarationCS-0", 69,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::PredicateCS-0(qvtcorecs::PredicateCS): { ownedCondition=ExpCS ";" }
		serializationRules[155] = createSerializationRule("PredicateCS-0", 73,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				384		/* check-rule qvtcorecs::PredicateCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				45		/* assert (|PredicateCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				40		/* PredicateCS::ownedCondition=ExpCS || value */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTcoreCSPackage.Literals.PREDICATE_CS__OWNED_CONDITION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::PredicateOrAssignmentCS-0(qvtcorecs::PredicateOrAssignmentCS): { isDefault?="default"[?] ownedTarget=ExpCS { ":=" ownedInitExpression=ExpCS }[?] ";" }
		serializationRules[156] = createSerializationRule("PredicateOrAssignmentCS-0", 74,
			createSerializationMatchSteps(
				101		/* assert |PredicateOrAssignmentCS::isPartial| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				385		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedTarget : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				203		/* assign V1 = |PredicateOrAssignmentCS::ownedInitExpression| */,
				47		/* assert (|PredicateOrAssignmentCS::ownedTarget| - 1) == 0 */,
				162		/* assign V0 = |PredicateOrAssignmentCS::isDefault.'default'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				11		/* PredicateOrAssignmentCS::isDefault?='default' || soft-space value soft-space */,
				112		/* PredicateOrAssignmentCS::ownedTarget=ExpCS || value */,
				233		/* V01*2-steps || value */,
				164		/* ':=' || soft-space value soft-space */,
				64		/* PredicateOrAssignmentCS::ownedInitExpression=ExpCS || value */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[157] = createSerializationRule("PredicateOrAssignmentCS-1", 74,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				385		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				386		/* check-rule qvtcorecs::PredicateOrAssignmentCS.ownedTarget : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				203		/* assign V1 = |PredicateOrAssignmentCS::ownedInitExpression| */,
				46		/* assert (|PredicateOrAssignmentCS::isPartial.'+='| - V1) == 0 */,
				47		/* assert (|PredicateOrAssignmentCS::ownedTarget| - 1) == 0 */,
				162		/* assign V0 = |PredicateOrAssignmentCS::isDefault.'default'| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				11		/* PredicateOrAssignmentCS::isDefault?='default' || soft-space value soft-space */,
				112		/* PredicateOrAssignmentCS::ownedTarget=ExpCS || value */,
				233		/* V01*2-steps || value */,
				15		/* PredicateOrAssignmentCS::isPartial?='+=' || soft-space value soft-space */,
				64		/* PredicateOrAssignmentCS::ownedInitExpression=ExpCS || value */,
				165		/* ';' || no-space value soft-new-line */
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
		serializationRules[158] = createSerializationRule("QualifiedPackageCS-0", 83,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				98		/* assert |PackageCS::ownedClasses| == 0 */,
				99		/* assert |PackageOwnerCS::ownedPackages| == 0 */,
				371		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				229		/* assign V2 = |PackageCS::nsURI| */,
				201		/* assign V1 = |PackageCS::nsPrefix| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				163		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				196		/* 'package' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				94		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				27		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				28		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 39/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTcore::QualifiedPackageCS-1(qvtbasecs::QualifiedPackageCS): { "package" ownedPathName=ScopeNameCS[?] name=UnrestrictedName { ":" nsPrefix=UnrestrictedName }[?] { "=" nsURI=URI }[?] { "{" { ownedClasses+=(ClassCS|TransformationCS)[*] ownedPackages+=QualifiedPackageCS[*] } "}" } }
		serializationRules[159] = createSerializationRule("QualifiedPackageCS-1", 83,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				294		/* check-rule basecs::PackageCS.ownedClasses : ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				295		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				371		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				256		/* assign V4 = |PackageOwnerCS::ownedPackages| */,
				245		/* assign V3 = |PackageCS::ownedClasses| */,
				229		/* assign V2 = |PackageCS::nsURI| */,
				201		/* assign V1 = |PackageCS::nsPrefix| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				163		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				196		/* 'package' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				94		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				233		/* V01*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				27		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				241		/* V02*2-steps || value */,
				166		/* '=' || soft-space value soft-space */,
				28		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				247		/* V03*1-steps || value */,
				34		/* PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line */,
				254		/* V04*1-steps || value */,
				81		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || half-new-line value half-new-line */,
				217		/* '}' || pop soft-new-line value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 54/* ClassCS,TransformationCS */,
					(5/*ClassCS*/ << 4) | 2 /*[*]*/,
					(108/*TransformationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 35/* QualifiedPackageCS */,
					(83/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 39/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTcore::QueryCS-0(qvtcorecs::QueryCS): { isTransient?="transient"[?] "query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS ";" }
		serializationRules[160] = createSerializationRule("QueryCS-0", 84,
			createSerializationMatchSteps(
				85		/* assert |JavaImplementationCS::implementation| == 0 */,
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				102		/* assert |QueryCS::ownedExpression| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				388		/* check-rule qvtcorecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				389		/* check-rule qvtcorecs::QueryCS.ownedPathName : ScopeNameCS */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				50		/* assert (|QueryCS::ownedPathName| - 1) == 0 */,
				164		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				186		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				218		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				20		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				199		/* 'query' || soft-space value soft-space */,
				95		/* QueryCS::ownedPathName=ScopeNameCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				153		/* ')' || no-space value */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(24/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 25/* ParamDeclarationCS */,
					(69/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 39/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::QueryCS-1(qvtcorecs::QueryCS): { isTransient?="transient"[?] "query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "implementedby" implementation=SINGLE_QUOTED_STRING ";" } }
		serializationRules[161] = createSerializationRule("QueryCS-1", 84,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				102		/* assert |QueryCS::ownedExpression| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				388		/* check-rule qvtcorecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				389		/* check-rule qvtcorecs::QueryCS.ownedPathName : ScopeNameCS */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				19		/* assert (|JavaImplementationCS::implementation| - 1) == 0 */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				50		/* assert (|QueryCS::ownedPathName| - 1) == 0 */,
				164		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				186		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				218		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				20		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				199		/* 'query' || soft-space value soft-space */,
				95		/* QueryCS::ownedPathName=ScopeNameCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				153		/* ')' || no-space value */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */,
				183		/* 'implementedby' || soft-space value soft-space */,
				3		/* JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				165		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(24/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, -1
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 25/* ParamDeclarationCS */,
					(69/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 39/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::QueryCS-2(qvtcorecs::QueryCS): { isTransient?="transient"[?] "query" ownedPathName=ScopeNameCS name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "{" ownedExpression=ExpCS "}" } }
		serializationRules[162] = createSerializationRule("QueryCS-2", 84,
			createSerializationMatchSteps(
				85		/* assert |JavaImplementationCS::implementation| == 0 */,
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				387		/* check-rule qvtcorecs::QueryCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				388		/* check-rule qvtcorecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				389		/* check-rule qvtcorecs::QueryCS.ownedPathName : ScopeNameCS */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				49		/* assert (|QueryCS::ownedExpression| - 1) == 0 */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				50		/* assert (|QueryCS::ownedPathName| - 1) == 0 */,
				164		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				186		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				218		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				219		/* V00*1-steps || value */,
				20		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				199		/* 'query' || soft-space value soft-space */,
				95		/* QueryCS::ownedPathName=ScopeNameCS || value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				152		/* '(' || no-space value no-space */,
				236		/* V01*4-steps || value */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				242		/* V02*2-steps || value */,
				160		/* ',' || no-space value soft-space */,
				83		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				153		/* ')' || no-space value */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */,
				213		/* '{' || soft-space value push soft-new-line */,
				54		/* QueryCS::ownedExpression=ExpCS || value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(24/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 25/* ParamDeclarationCS */,
					(69/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.QUERY_CS__OWNED_PATH_NAME, 39/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::RealizedVariableCS-0(qvtcorecs::RealizedVariableCS): { "realize" name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[163] = createSerializationRule("RealizedVariableCS-0", 85,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				62		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				200		/* 'realize' || soft-space value soft-space */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
					(113/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTcore::ScopeNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS "::" { ownedPathElements+=NextPathElementCS "::" }[*] }
		serializationRules[164] = createSerializationRule("ScopeNameCS-0", 92,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				294		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				163		/* '::' || no-space value no-space */,
				224		/* V00*2-steps || value */,
				295		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */,
				163		/* '::' || no-space value no-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 23/* FirstPathElementCS,NextPathElementCS */,
					(30/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(65/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::TopLevelCS-0(qvtcorecs::TopLevelCS): { ownedImports+=ImportCS[*] { ownedPackages+=QualifiedPackageCS[*] ownedTransformations+=TransformationCS[*] ownedMappings+=MappingCS[*] ownedQueries+=QueryCS[*] } }
		serializationRules[165] = createSerializationRule("TopLevelCS-0", 107,
			createSerializationMatchSteps(
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				298		/* check-rule basecs::RootCS.ownedImports : ImportCS */,
				390		/* check-rule qvtcorecs::TopLevelCS.ownedMappings : MappingCS */,
				295		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				391		/* check-rule qvtcorecs::TopLevelCS.ownedQueries : QueryCS */,
				392		/* check-rule qvtcorecs::TopLevelCS.ownedTransformations : TransformationCS */,
				258		/* assign V4 = |TopLevelCS::ownedQueries| */,
				247		/* assign V3 = |TopLevelCS::ownedMappings| */,
				231		/* assign V2 = |TopLevelCS::ownedTransformations| */,
				202		/* assign V1 = |PackageOwnerCS::ownedPackages| */,
				166		/* assign V0 = |RootCS::ownedImports| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				221		/* V00*1-steps || value half-new-line */,
				60		/* RootCS::ownedImports+=ImportCS || value */,
				232		/* V01*1-steps || value */,
				81		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || half-new-line value half-new-line */,
				239		/* V02*1-steps || value */,
				119		/* TopLevelCS::ownedTransformations+=TransformationCS || half-new-line value half-new-line */,
				247		/* V03*1-steps || value */,
				74		/* TopLevelCS::ownedMappings+=MappingCS || half-new-line value half-new-line */,
				254		/* V04*1-steps || value */,
				103		/* TopLevelCS::ownedQueries+=QueryCS || half-new-line value half-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 12/* ImportCS */,
					(37/*ImportCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS, 16/* MappingCS */,
					(50/*MappingCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 35/* QualifiedPackageCS */,
					(83/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES, 36/* QueryCS */,
					(84/*QueryCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 53/* TransformationCS */,
					(108/*TransformationCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::TransformationCS-0(qvtcorecs::TransformationCS): { "transformation" ownedPathName=ScopeNameCS[?] name=UnreservedName "{" { ownedDirections+=DirectionCS ";" }[*] ownedTargets+=TargetCS[*] ownedProperties+=StructuralFeatureCS[*] "}" }
		serializationRules[166] = createSerializationRule("TransformationCS-0", 108,
			createSerializationMatchSteps(
				70		/* assert |ClassCS::instanceClassName| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				71		/* assert |ClassCS::ownedConstraints| == 0 */,
				116		/* assert |TemplateableElementCS::ownedSignature| == 0 */,
				393		/* check-rule qvtcorecs::TransformationCS.ownedDirections : DirectionCS */,
				368		/* check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : ScopeNameCS */,
				394		/* check-rule qvtcorecs::TransformationCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				369		/* check-rule qvtbasecs::AbstractTransformationCS.ownedTargets : TargetCS */,
				248		/* assign V3 = |TransformationCS::ownedProperties| */,
				225		/* assign V2 = |AbstractTransformationCS::ownedTargets| */,
				208		/* assign V1 = |TransformationCS::ownedDirections| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */,
				140		/* assign V0 = |AbstractTransformationCS::ownedPathName| */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				207		/* 'transformation' || soft-space value soft-space */,
				219		/* V00*1-steps || value */,
				92		/* AbstractTransformationCS::ownedPathName=ScopeNameCS || value */,
				286		/* NamedElementCS::name=UnreservedName || soft-space value soft-space */,
				213		/* '{' || soft-space value push soft-new-line */,
				234		/* V01*2-steps || value */,
				45		/* TransformationCS::ownedDirections+=DirectionCS || value */,
				165		/* ';' || no-space value soft-new-line */,
				239		/* V02*1-steps || value */,
				115		/* AbstractTransformationCS::ownedTargets+=TargetCS || value */,
				247		/* V03*1-steps || value */,
				102		/* TransformationCS::ownedProperties+=StructuralFeatureCS || value */,
				216		/* '}' || pop value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 5/* DirectionCS */,
					(16/*DirectionCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 39/* ScopeNameCS */,
					(92/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 46/* StructuralFeatureCS */,
					(101/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 49/* TargetCS */,
					(103/*TargetCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTcore::UnnamedDomainCS-0(qvtcorecs::DomainCS): { ownedGuardPattern=GuardPatternCS ownedBottomPattern=BottomPatternCS }
		serializationRules[167] = createSerializationRule("UnnamedDomainCS-0", 131,
			createSerializationMatchSteps(
				76		/* assert |DomainCS::direction| == 0 */,
				77		/* assert |DomainCS::isCheck| == 0 */,
				78		/* assert |DomainCS::isEnforce| == 0 */,
				89		/* assert |NamedElementCS::name| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				373		/* check-rule qvtcorecs::AreaCS.ownedBottomPattern : BottomPatternCS */,
				374		/* check-rule qvtcorecs::AreaCS.ownedGuardPattern : GuardPatternCS */,
				1		/* assert (|AreaCS::ownedBottomPattern| - 1) == 0 */,
				2		/* assert (|AreaCS::ownedGuardPattern| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
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
		serializationRules[168] = createSerializationRule("UnrealizedVariableCS-0", 132,
			createSerializationMatchSteps(
				118		/* assert |TypedElementCS::isOptional| == 0 */,
				87		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				119		/* assert |TypedElementCS::qualifiers| == 0 */,
				395		/* check-rule qvtcorecs::UnrealizedVariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				310		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				212		/* assign V1 = |UnrealizedVariableCS::ownedInitExpression| */,
				173		/* assign V0 = |TypedElementCS::ownedType| */,
				30		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				284		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				287		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				223		/* V00*2-steps || value */,
				162		/* ':' || soft-space value soft-space */,
				299		/* TypedElementCS::ownedType=TypeExpCS || value */,
				233		/* V01*2-steps || value */,
				164		/* ':=' || soft-space value soft-space */,
				67		/* UnrealizedVariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTcoreCSPackage.Literals.UNREALIZED_VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(29/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 58/* TypeExpCS */,
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
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */
		};
		serializationSegments[4] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.VALUE /* value */,
			SerializationSegment.HALF_NEW_LINE /* half-new-line */
		};
		serializationSegments[5] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.VALUE /* value */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[6] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.HALF_NEW_LINE /* half-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.HALF_NEW_LINE /* half-new-line */
		};
		serializationSegments[7] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.NO_SPACE /* no-space */
		};
		serializationSegments[8] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[9] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.NO_SPACE /* no-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[10] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[11] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */
		};
		serializationSegments[12] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */
		};
		serializationSegments[13] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[14] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[15] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[16] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */
		};
		serializationSegments[17] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[18] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[19] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[20] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[21] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[22] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */
		};
		serializationSegments[23] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.POP /* pop */,
			SerializationSegment.SOFT_SPACE /* soft-space */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[24] = new @NonNull SerializationSegment @NonNull [] {
			SerializationSegment.SOFT_NEW_LINE /* soft-new-line */,
			SerializationSegment.POP /* pop */,
			SerializationSegment.VALUE /* value */,
			SerializationSegment.PUSH /* push */,
			SerializationSegment.SOFT_SPACE /* soft-space */
		};
		serializationSegments[25] = new @NonNull SerializationSegment @NonNull [] {
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
		serializationSteps[0] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, 90 /*SINGLE_QUOTED_STRING*/, 13);
		// 1: DomainCS::direction=UnrestrictedName || soft-space value soft-space
		serializationSteps[1] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.DOMAIN_CS__DIRECTION, getCrossReference(QVTcoreCSPackage.Literals.DOMAIN_CS__DIRECTION, "UnrestrictedName"), 135, 13);
		// 2: SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[2] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, 124 /*UNQUOTED_STRING*/, 2);
		// 3: JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[3] = createSerializationStepCrossReference(BaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, getCrossReference(BaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, "SINGLE_QUOTED_STRING"), 90, 13);
		// 4: DirectionCS::imports+=UnrestrictedName || soft-space value soft-space
		serializationSteps[4] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__IMPORTS, getCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__IMPORTS, "UnrestrictedName"), 135, 13);
		// 5: SimpleTargetElementCS::input?='input' || soft-space value soft-space
		serializationSteps[5] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 18 /* 'input' */, 13);
		// 6: ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[6] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, 90 /*SINGLE_QUOTED_STRING*/, 13);
		// 7: MappingCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[7] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.MAPPING_CS__IS_ABSTRACT, 12 /* 'abstract' */, 13);
		// 8: StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[8] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 12 /* 'abstract' */, 13);
		// 9: ImportCS::isAll?='::' || no-space value no-space
		serializationSteps[9] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, 7 /* '::' */, 7);
		// 10: DomainCS::isCheck?='check' || soft-space value soft-space
		serializationSteps[10] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_CHECK, 13 /* 'check' */, 13);
		// 11: PredicateOrAssignmentCS::isDefault?='default' || soft-space value soft-space
		serializationSteps[11] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT, 14 /* 'default' */, 13);
		// 12: DomainCS::isEnforce?='enforce' || soft-space value soft-space
		serializationSteps[12] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.DOMAIN_CS__IS_ENFORCE, 16 /* 'enforce' */, 13);
		// 13: StructuredClassCS::isInterface?='interface' || soft-space value soft-space
		serializationSteps[13] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 19 /* 'interface' */, 13);
		// 14: MultiplicityCS::isNullFree?='|1' || no-space value no-space
		serializationSteps[14] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 27 /* '|1' */, 7);
		// 15: PredicateOrAssignmentCS::isPartial?='+=' || soft-space value soft-space
		serializationSteps[15] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL, 5 /* '+=' */, 13);
		// 16: AbstractNameExpCS::isPre?='@' || soft-space value soft-space
		serializationSteps[16] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 9 /* '@' */, 13);
		// 17: DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space
		serializationSteps[17] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 21 /* 'primitive' */, 13);
		// 18: DataTypeCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[18] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 22 /* 'serializable' */, 13);
		// 19: EnumerationCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[19] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 22 /* 'serializable' */, 13);
		// 20: QueryCS::isTransient?='transient' || soft-space value soft-space
		serializationSteps[20] = createSerializationStepAssignKeyword(QVTcoreCSPackage.Literals.QUERY_CS__IS_TRANSIENT, 24 /* 'transient' */, 13);
		// 21: SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space
		serializationSteps[21] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, "UnrestrictedName"), 135, 13);
		// 22: MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space
		serializationSteps[22] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, 41 /*LOWER*/, 13);
		// 23: CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space
		serializationSteps[23] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, 11 /*CollectionTypeIdentifier*/, 13);
		// 24: MapTypeCS::name='Map' || soft-space value soft-space
		serializationSteps[24] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 10 /* 'Map' */, 13);
		// 25: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space
		serializationSteps[25] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, 80 /*PrimitiveTypeIdentifier*/, 13);
		// 26: TupleTypeCS::name='Tuple' || soft-space value soft-space
		serializationSteps[26] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 11 /* 'Tuple' */, 13);
		// 27: PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space
		serializationSteps[27] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, 135 /*UnrestrictedName*/, 13);
		// 28: PackageCS::nsURI=URI || soft-space value soft-space
		serializationSteps[28] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, 126 /*URI*/, 13);
		// 29: SimpleTargetElementCS::output?='output' || soft-space value soft-space
		serializationSteps[29] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 20 /* 'output' */, 13);
		// 30: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[30] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 120 /*TypeRefCS*/, 2);
		// 31: TypedTypeRefCS::ownedBinding=TemplateBindingCS || value
		serializationSteps[31] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 104 /*TemplateBindingCS*/, 0);
		// 32: OperationCS::ownedBodyExpressions+=SpecificationCS || value
		serializationSteps[32] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 97 /*SpecificationCS*/, 0);
		// 33: AreaCS::ownedBottomPattern=BottomPatternCS || value
		serializationSteps[33] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.AREA_CS__OWNED_BOTTOM_PATTERN, 4 /*BottomPatternCS*/, 0);
		// 34: PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line
		serializationSteps[34] = createSerializationStepAssigns(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, -1, new int[] { 5/*ClassCS*/,108/*TransformationCS*/}, 6);
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
		// 41: BottomPatternCS::ownedConstraints+=PredicateOrAssignmentCS || soft-new-line value
		serializationSteps[41] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_CONSTRAINTS, 74 /*PredicateOrAssignmentCS*/, 3);
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
		// 74: TopLevelCS::ownedMappings+=MappingCS || half-new-line value half-new-line
		serializationSteps[74] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_MAPPINGS, 50 /*MappingCS*/, 6);
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
		// 81: PackageOwnerCS::ownedPackages+=QualifiedPackageCS || half-new-line value half-new-line
		serializationSteps[81] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 83 /*QualifiedPackageCS*/, 6);
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
		// 100: GuardPatternCS::ownedPredicates+=PredicateCS || soft-new-line value
		serializationSteps[100] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.GUARD_PATTERN_CS__OWNED_PREDICATES, 73 /*PredicateCS*/, 3);
		// 101: StructuredClassCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[101] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 101 /*StructuralFeatureCS*/, 0);
		// 102: TransformationCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[102] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TRANSFORMATION_CS__OWNED_PROPERTIES, 101 /*StructuralFeatureCS*/, 0);
		// 103: TopLevelCS::ownedQueries+=QueryCS || half-new-line value half-new-line
		serializationSteps[103] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_QUERIES, 84 /*QueryCS*/, 6);
		// 104: BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || value
		serializationSteps[104] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 85 /*RealizedVariableCS*/, 0);
		// 105: BottomPatternCS::ownedRealizedVariables+=RealizedVariableCS || soft-new-line value
		serializationSteps[105] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.BOTTOM_PATTERN_CS__OWNED_REALIZED_VARIABLES, 85 /*RealizedVariableCS*/, 3);
		// 106: AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[106] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 87 /*RoundBracketedClauseCS*/, 0);
		// 107: LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[107] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 87 /*RoundBracketedClauseCS*/, 0);
		// 108: TemplateableElementCS::ownedSignature=TemplateSignatureCS || value
		serializationSteps[108] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 106 /*TemplateSignatureCS*/, 0);
		// 109: AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value
		serializationSteps[109] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 98 /*SquareBracketedClauseCS*/, 0);
		// 110: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value
		serializationSteps[110] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 105 /*TemplateParameterSubstitutionCS*/, 0);
		// 111: StructuredClassCS::ownedSuperTypes+=TypedRefCS || value
		serializationSteps[111] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 122 /*TypedRefCS*/, 0);
		// 112: PredicateOrAssignmentCS::ownedTarget=ExpCS || value
		serializationSteps[112] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, 29 /*ExpCS*/, 0);
		// 113: CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value
		serializationSteps[113] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 96 /*SimpleTargetElementCS*/, 0);
		// 114: TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value
		serializationSteps[114] = createSerializationStepAssigns(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, -1, new int[] { 96/*SimpleTargetElementCS*/,12/*CompoundTargetElementCS*/}, 0);
		// 115: AbstractTransformationCS::ownedTargets+=TargetCS || value
		serializationSteps[115] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS, 103 /*TargetCS*/, 0);
		// 116: SquareBracketedClauseCS::ownedTerms+=ExpCS || value
		serializationSteps[116] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 29 /*ExpCS*/, 0);
		// 117: IfExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[117] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 29 /*ExpCS*/, 0);
		// 118: IfThenExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[118] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 29 /*ExpCS*/, 0);
		// 119: TopLevelCS::ownedTransformations+=TransformationCS || half-new-line value half-new-line
		serializationSteps[119] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 108 /*TransformationCS*/, 6);
		// 120: CollectionLiteralExpCS::ownedType=CollectionTypeCS || value
		serializationSteps[120] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 10 /*CollectionTypeCS*/, 0);
		// 121: CollectionPatternCS::ownedType=CollectionTypeCS || value
		serializationSteps[121] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 10 /*CollectionTypeCS*/, 0);
		// 122: CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value
		serializationSteps[122] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 114 /*TypeExpWithoutMultiplicityCS*/, 0);
		// 123: MapLiteralExpCS::ownedType=MapTypeCS || value
		serializationSteps[123] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 49 /*MapTypeCS*/, 0);
		// 124: NavigatingArgCS::ownedType=TypeExpCS || value
		serializationSteps[124] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 113 /*TypeExpCS*/, 0);
		// 125: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[125] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 117 /*TypeLiteralWithMultiplicityCS*/, 2);
		// 126: VariableCS::ownedType=TypeExpCS || value
		serializationSteps[126] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 113 /*TypeExpCS*/, 0);
		// 127: MapLiteralPartCS::ownedValue=ExpCS || value
		serializationSteps[127] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 29 /*ExpCS*/, 0);
		// 128: MapTypeCS::ownedValueType=TypeExpCS || value
		serializationSteps[128] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 113 /*TypeExpCS*/, 0);
		// 129: LetExpCS::ownedVariables+=LetVariableCS || value
		serializationSteps[129] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 44 /*LetVariableCS*/, 0);
		// 130: PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space
		serializationSteps[130] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, 135 /*UnrestrictedName*/, 13);
		// 131: NavigatingArgCS::prefix='|' || soft-space value soft-space
		serializationSteps[131] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 26 /* '|' */, 13);
		// 132: NavigatingArgCS::prefix=';' || no-space value soft-new-line
		serializationSteps[132] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 8 /* ';' */, 8);
		// 133: NavigatingArgCS::prefix=',' || no-space value soft-space
		serializationSteps[133] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ',' */, 9);
		// 134: ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space
		serializationSteps[134] = createSerializationStepCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, getCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, "UnrestrictedName"), 135, 13);
		// 135: ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space
		serializationSteps[135] = createSerializationStepCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, getCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, "UnrestrictedName"), 135, 13);
		// 136: MappingCS::refines+=UnrestrictedName || soft-space value soft-space
		serializationSteps[136] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.MAPPING_CS__REFINES, getCrossReference(QVTcoreCSPackage.Literals.MAPPING_CS__REFINES, "UnrestrictedName"), 135, 13);
		// 137: CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space
		serializationSteps[137] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, 35 /*Identifier*/, 13);
		// 138: StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[138] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, 99 /*StringLiteral*/, 2);
		// 139: MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space
		serializationSteps[139] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 4 /* '*|+|?' */, 13);
		// 140: BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[140] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 17 /* 'false|true' */, 2);
		// 141: NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[141] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, 55 /*NUMBER_LITERAL*/, 2);
		// 142: SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[142] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, "UnrestrictedName"), 135, 13);
		// 143: MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space
		serializationSteps[143] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, 125 /*UPPER*/, 13);
		// 144: DirectionCS::uses+=UnrestrictedName || soft-space value soft-space
		serializationSteps[144] = createSerializationStepCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__USES, getCrossReference(QVTcoreCSPackage.Literals.DIRECTION_CS__USES, "UnrestrictedName"), 135, 13);
		// 145: EnumerationLiteralCS::value=SIGNED || soft-space value soft-space
		serializationSteps[145] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, 88 /*SIGNED*/, 13);
		// 146: SimpleTargetElementCS::via?='via' || soft-space value soft-space
		serializationSteps[146] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 25 /* 'via' */, 13);
		// 147: '!serializable' || soft-space value soft-space
		serializationSteps[147] = createSerializationStepKeyword("!serializable", 13);
		// 148: '#' || no-space value no-space
		serializationSteps[148] = createSerializationStepKeyword("#", 7);
		// 149: '&&' || soft-space value soft-space
		serializationSteps[149] = createSerializationStepKeyword("&&", 13);
		// 150: '(' || soft-new-line value push
		serializationSteps[150] = createSerializationStepKeyword("(", 11);
		// 151: '(' || value no-space
		serializationSteps[151] = createSerializationStepKeyword("(", 5);
		// 152: '(' || no-space value no-space
		serializationSteps[152] = createSerializationStepKeyword("(", 7);
		// 153: ')' || no-space value
		serializationSteps[153] = createSerializationStepKeyword(")", 1);
		// 154: ')' || pop value soft-new-line
		serializationSteps[154] = createSerializationStepKeyword(")", 10);
		// 155: ')' || soft-new-line pop value soft-new-line
		serializationSteps[155] = createSerializationStepKeyword(")", 17);
		// 156: '*' || soft-space value soft-space
		serializationSteps[156] = createSerializationStepKeyword("*", 13);
		// 157: '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[157] = createSerializationStepKeyword("*", 2);
		// 158: '++' || soft-space value soft-space
		serializationSteps[158] = createSerializationStepKeyword("++", 13);
		// 159: ',' || no-space value soft-new-line
		serializationSteps[159] = createSerializationStepKeyword(",", 8);
		// 160: ',' || no-space value soft-space
		serializationSteps[160] = createSerializationStepKeyword(",", 9);
		// 161: '..' || no-space value no-space
		serializationSteps[161] = createSerializationStepKeyword("..", 7);
		// 162: ':' || soft-space value soft-space
		serializationSteps[162] = createSerializationStepKeyword(":", 13);
		// 163: '::' || no-space value no-space
		serializationSteps[163] = createSerializationStepKeyword("::", 7);
		// 164: ':=' || soft-space value soft-space
		serializationSteps[164] = createSerializationStepKeyword(":=", 13);
		// 165: ';' || no-space value soft-new-line
		serializationSteps[165] = createSerializationStepKeyword(";", 8);
		// 166: '=' || soft-space value soft-space
		serializationSteps[166] = createSerializationStepKeyword("=", 13);
		// 167: '?' || soft-space value soft-space
		serializationSteps[167] = createSerializationStepKeyword("?", 13);
		// 168: 'Lambda' || soft-space value soft-space
		serializationSteps[168] = createSerializationStepKeyword("Lambda", 13);
		// 169: 'Tuple' || soft-space value soft-space
		serializationSteps[169] = createSerializationStepKeyword("Tuple", 13);
		// 170: '[' || no-space value no-space
		serializationSteps[170] = createSerializationStepKeyword("[", 7);
		// 171: ']' || no-space value
		serializationSteps[171] = createSerializationStepKeyword("]", 1);
		// 172: 'attribute' || soft-space value soft-space
		serializationSteps[172] = createSerializationStepKeyword("attribute", 13);
		// 173: 'body' || soft-space value soft-space
		serializationSteps[173] = createSerializationStepKeyword("body", 13);
		// 174: 'class' || soft-space value soft-space
		serializationSteps[174] = createSerializationStepKeyword("class", 13);
		// 175: 'datatype' || soft-space value soft-space
		serializationSteps[175] = createSerializationStepKeyword("datatype", 13);
		// 176: 'derivation' || soft-space value soft-space
		serializationSteps[176] = createSerializationStepKeyword("derivation", 13);
		// 177: 'else' || soft-new-line pop value push soft-space
		serializationSteps[177] = createSerializationStepKeyword("else", 24);
		// 178: 'elseif' || soft-new-line pop soft-space value push soft-space
		serializationSteps[178] = createSerializationStepKeyword("elseif", 25);
		// 179: 'endif' || soft-new-line pop value soft-space
		serializationSteps[179] = createSerializationStepKeyword("endif", 18);
		// 180: 'enum' || soft-space value soft-space
		serializationSteps[180] = createSerializationStepKeyword("enum", 13);
		// 181: 'extends' || soft-space value soft-space
		serializationSteps[181] = createSerializationStepKeyword("extends", 13);
		// 182: 'if' || soft-new-line value push soft-space
		serializationSteps[182] = createSerializationStepKeyword("if", 20);
		// 183: 'implementedby' || soft-space value soft-space
		serializationSteps[183] = createSerializationStepKeyword("implementedby", 13);
		// 184: 'import' || soft-space value soft-space
		serializationSteps[184] = createSerializationStepKeyword("import", 13);
		// 185: 'imports' || soft-space value soft-space
		serializationSteps[185] = createSerializationStepKeyword("imports", 13);
		// 186: 'in' || soft-space value soft-space
		serializationSteps[186] = createSerializationStepKeyword("in", 13);
		// 187: 'in' || soft-space pop value soft-new-line
		serializationSteps[187] = createSerializationStepKeyword("in", 21);
		// 188: 'initial' || soft-space value soft-space
		serializationSteps[188] = createSerializationStepKeyword("initial", 13);
		// 189: 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[189] = createSerializationStepKeyword("invalid", 2);
		// 190: 'iterates' || soft-space value soft-space
		serializationSteps[190] = createSerializationStepKeyword("iterates", 13);
		// 191: 'let' || soft-space value push
		serializationSteps[191] = createSerializationStepKeyword("let", 12);
		// 192: 'literal' || soft-space value soft-space
		serializationSteps[192] = createSerializationStepKeyword("literal", 13);
		// 193: 'map' || soft-space value soft-space
		serializationSteps[193] = createSerializationStepKeyword("map", 13);
		// 194: 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[194] = createSerializationStepKeyword("null", 2);
		// 195: 'operation' || soft-space value soft-space
		serializationSteps[195] = createSerializationStepKeyword("operation", 13);
		// 196: 'package' || soft-space value soft-space
		serializationSteps[196] = createSerializationStepKeyword("package", 13);
		// 197: 'pre' || soft-space value soft-space
		serializationSteps[197] = createSerializationStepKeyword("pre", 13);
		// 198: 'property' || soft-space value soft-space
		serializationSteps[198] = createSerializationStepKeyword("property", 13);
		// 199: 'query' || soft-space value soft-space
		serializationSteps[199] = createSerializationStepKeyword("query", 13);
		// 200: 'realize' || soft-space value soft-space
		serializationSteps[200] = createSerializationStepKeyword("realize", 13);
		// 201: 'refines' || soft-space value soft-space
		serializationSteps[201] = createSerializationStepKeyword("refines", 13);
		// 202: 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[202] = createSerializationStepKeyword("self", 2);
		// 203: 'target' || soft-space value soft-space
		serializationSteps[203] = createSerializationStepKeyword("target", 13);
		// 204: 'then' || pop value push soft-space
		serializationSteps[204] = createSerializationStepKeyword("then", 15);
		// 205: 'then' || pop soft-space value push soft-space
		serializationSteps[205] = createSerializationStepKeyword("then", 23);
		// 206: 'throws' || soft-space value soft-space
		serializationSteps[206] = createSerializationStepKeyword("throws", 13);
		// 207: 'transformation' || soft-space value soft-space
		serializationSteps[207] = createSerializationStepKeyword("transformation", 13);
		// 208: 'uses' || soft-space value soft-space
		serializationSteps[208] = createSerializationStepKeyword("uses", 13);
		// 209: 'where' || soft-space value soft-space
		serializationSteps[209] = createSerializationStepKeyword("where", 13);
		// 210: 'with' || value
		serializationSteps[210] = createSerializationStepKeyword("with", 0);
		// 211: '{' || soft-new-line value push
		serializationSteps[211] = createSerializationStepKeyword("{", 11);
		// 212: '{' || soft-new-line value push soft-new-line
		serializationSteps[212] = createSerializationStepKeyword("{", 19);
		// 213: '{' || soft-space value push soft-new-line
		serializationSteps[213] = createSerializationStepKeyword("{", 22);
		// 214: '|' || soft-new-line pop value push
		serializationSteps[214] = createSerializationStepKeyword("|", 16);
		// 215: '|?' || no-space value no-space
		serializationSteps[215] = createSerializationStepKeyword("|?", 7);
		// 216: '}' || pop value soft-new-line
		serializationSteps[216] = createSerializationStepKeyword("}", 10);
		// 217: '}' || pop soft-new-line value soft-new-line
		serializationSteps[217] = createSerializationStepKeyword("}", 14);
		// 218: 1*1-steps || soft-new-line value
		serializationSteps[218] = createSerializationStepSequence((-1/*V-1*/ << 4) | 0/*[1]*/, 1, 3);
		// 219: V00*1-steps || value
		serializationSteps[219] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 1, 0);
		// 220: V00*1-steps || value
		serializationSteps[220] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 1, 0);
		// 221: V00*1-steps || value half-new-line
		serializationSteps[221] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 1, 4);
		// 222: V00*1-steps || value
		serializationSteps[222] = createSerializationStepSequence((0/*V0*/ << 4) | 3/*[+]*/, 1, 0);
		// 223: V00*2-steps || value
		serializationSteps[223] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 2, 0);
		// 224: V00*2-steps || value
		serializationSteps[224] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 2, 0);
		// 225: V00*3-steps || value
		serializationSteps[225] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 3, 0);
		// 226: V00*4-steps || value
		serializationSteps[226] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 4, 0);
		// 227: V00*5-steps || value
		serializationSteps[227] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 5, 0);
		// 228: V00*6-steps || value
		serializationSteps[228] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 6, 0);
		// 229: V00*7-steps || value
		serializationSteps[229] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 7, 0);
		// 230: V00*8-steps || value
		serializationSteps[230] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 8, 0);
		// 231: V01*1-steps || value
		serializationSteps[231] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 1, 0);
		// 232: V01*1-steps || value
		serializationSteps[232] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 1, 0);
		// 233: V01*2-steps || value
		serializationSteps[233] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 2, 0);
		// 234: V01*2-steps || value
		serializationSteps[234] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 2, 0);
		// 235: V01*3-steps || value
		serializationSteps[235] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 3, 0);
		// 236: V01*4-steps || value
		serializationSteps[236] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 4, 0);
		// 237: V10*1-steps || value
		serializationSteps[237] = createSerializationStepSequence((10/*V10*/ << 4) | 1/*[?]*/, 1, 0);
		// 238: V02*1-steps || value
		serializationSteps[238] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 1, 0);
		// 239: V02*1-steps || value
		serializationSteps[239] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 1, 0);
		// 240: V02*1-steps || value
		serializationSteps[240] = createSerializationStepSequence((2/*V2*/ << 4) | 3/*[+]*/, 1, 0);
		// 241: V02*2-steps || value
		serializationSteps[241] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 2, 0);
		// 242: V02*2-steps || value
		serializationSteps[242] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 2, 0);
		// 243: V02*3-steps || value
		serializationSteps[243] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 3, 0);
		// 244: V02*4-steps || value
		serializationSteps[244] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 4, 0);
		// 245: V02*5-steps || value
		serializationSteps[245] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 5, 0);
		// 246: V03*1-steps || value
		serializationSteps[246] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 1, 0);
		// 247: V03*1-steps || value
		serializationSteps[247] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 1, 0);
		// 248: V03*1-steps || value
		serializationSteps[248] = createSerializationStepSequence((3/*V3*/ << 4) | 3/*[+]*/, 1, 0);
		// 249: V03*2-steps || value
		serializationSteps[249] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 2, 0);
		// 250: V03*2-steps || value
		serializationSteps[250] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 2, 0);
		// 251: V03*3-steps || value
		serializationSteps[251] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 3, 0);
		// 252: V03*4-steps || value
		serializationSteps[252] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 4, 0);
		// 253: V03*5-steps || value
		serializationSteps[253] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 5, 0);
		// 254: V04*1-steps || value
		serializationSteps[254] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 1, 0);
		// 255: V04*1-steps || value
		serializationSteps[255] = createSerializationStepSequence((4/*V4*/ << 4) | 3/*[+]*/, 1, 0);
		// 256: V04*2-steps || value
		serializationSteps[256] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 2, 0);
		// 257: V04*2-steps || value
		serializationSteps[257] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 2, 0);
		// 258: V04*4-steps || value
		serializationSteps[258] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 4, 0);
		// 259: V04*5-steps || value
		serializationSteps[259] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 5, 0);
		// 260: V04*5-steps || value
		serializationSteps[260] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 5, 0);
		// 261: V05*1-steps || value
		serializationSteps[261] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 1, 0);
		// 262: V05*1-steps || value
		serializationSteps[262] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 1, 0);
		// 263: V05*1-steps || value
		serializationSteps[263] = createSerializationStepSequence((5/*V5*/ << 4) | 3/*[+]*/, 1, 0);
		// 264: V05*2-steps || value
		serializationSteps[264] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 2, 0);
		// 265: V05*4-steps || value
		serializationSteps[265] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 4, 0);
		// 266: V05*5-steps || value
		serializationSteps[266] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 5, 0);
		// 267: V05*5-steps || value
		serializationSteps[267] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 5, 0);
		// 268: V06*1-steps || value
		serializationSteps[268] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 1, 0);
		// 269: V06*2-steps || value
		serializationSteps[269] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 2, 0);
		// 270: V06*2-steps || value
		serializationSteps[270] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 2, 0);
		// 271: V06*4-steps || value
		serializationSteps[271] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 4, 0);
		// 272: V06*5-steps || value
		serializationSteps[272] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 5, 0);
		// 273: V07*1-steps || value
		serializationSteps[273] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 1, 0);
		// 274: V07*1-steps || value
		serializationSteps[274] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 1, 0);
		// 275: V07*1-steps || value
		serializationSteps[275] = createSerializationStepSequence((7/*V7*/ << 4) | 3/*[+]*/, 1, 0);
		// 276: V07*4-steps || value
		serializationSteps[276] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 4, 0);
		// 277: V07*5-steps || value
		serializationSteps[277] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 5, 0);
		// 278: V08*1-steps || value
		serializationSteps[278] = createSerializationStepSequence((8/*V8*/ << 4) | 1/*[?]*/, 1, 0);
		// 279: V08*1-steps || value
		serializationSteps[279] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 1, 0);
		// 280: V08*1-steps || value
		serializationSteps[280] = createSerializationStepSequence((8/*V8*/ << 4) | 3/*[+]*/, 1, 0);
		// 281: V08*5-steps || value
		serializationSteps[281] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 5, 0);
		// 282: V09*1-steps || value
		serializationSteps[282] = createSerializationStepSequence((9/*V9*/ << 4) | 1/*[?]*/, 1, 0);
		// 283: V09*5-steps || value
		serializationSteps[283] = createSerializationStepSequence((9/*V9*/ << 4) | 2/*[*]*/, 5, 0);
		// 284: wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[284] = createSerializationStepWrapper(2);
		// 285: NamedElementCS::name=UnaryOperatorName || soft-space value soft-space
		serializationSteps[285] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 129 /*UnaryOperatorName*/, 13);
		// 286: NamedElementCS::name=UnreservedName || soft-space value soft-space
		serializationSteps[286] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 133 /*UnreservedName*/, 13);
		// 287: NamedElementCS::name=UnrestrictedName || soft-space value soft-space
		serializationSteps[287] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 135 /*UnrestrictedName*/, 13);
		// 288: NamedElementCS::name=BinaryOperatorName || soft-space value soft-space
		serializationSteps[288] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 2 /*BinaryOperatorName*/, 13);
		// 289: NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space
		serializationSteps[289] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 22 /*EnumerationLiteralName*/, 13);
		// 290: NamedElementCS::name=Identifier || soft-space value soft-space
		serializationSteps[290] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 35 /*Identifier*/, 13);
		// 291: RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value
		serializationSteps[291] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 58 /*NavigatingArgCS*/, 0);
		// 292: RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value
		serializationSteps[292] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, -1, new int[] { 61/*NavigatingCommaArgCS*/,62/*NavigatingSemiArgCS*/,60/*NavigatingBarArgCS*/}, 0);
		// 293: PathNameCS::ownedPathElements+=URIFirstPathElementCS || value
		serializationSteps[293] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 127 /*URIFirstPathElementCS*/, 0);
		// 294: PathNameCS::ownedPathElements+=FirstPathElementCS || value
		serializationSteps[294] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 30 /*FirstPathElementCS*/, 0);
		// 295: PathNameCS::ownedPathElements+=NextPathElementCS || value
		serializationSteps[295] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 65 /*NextPathElementCS*/, 0);
		// 296: OperatorExpCS::ownedRight=ExpCS || value
		serializationSteps[296] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 29 /*ExpCS*/, 0);
		// 297: OperatorExpCS::ownedRight=PrefixedLetExpCS || value
		serializationSteps[297] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 75 /*PrefixedLetExpCS*/, 0);
		// 298: OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value
		serializationSteps[298] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 76 /*PrefixedPrimaryExpCS*/, 0);
		// 299: TypedElementCS::ownedType=TypeExpCS || value
		serializationSteps[299] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 113 /*TypeExpCS*/, 0);
		// 300: TypedElementCS::ownedType=TypedMultiplicityRefCS || value
		serializationSteps[300] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 121 /*TypedMultiplicityRefCS*/, 0);
		// 301: PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || value
		serializationSteps[301] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 132 /*UnrealizedVariableCS*/, 0);
		// 302: PatternCS::ownedUnrealizedVariables+=GuardVariableCS || value
		serializationSteps[302] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 32 /*GuardVariableCS*/, 0);
		// 303: PatternCS::ownedUnrealizedVariables+=UnrealizedVariableCS || soft-new-line value
		serializationSteps[303] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 132 /*UnrealizedVariableCS*/, 3);
		// 304: PatternCS::ownedUnrealizedVariables+=GuardVariableCS || soft-new-line value
		serializationSteps[304] = createSerializationStepAssignedRuleCall(QVTcoreCSPackage.Literals.PATTERN_CS__OWNED_UNREALIZED_VARIABLES, 32 /*GuardVariableCS*/, 3);
		// 305: TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[305] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */, 13);
		// 306: TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[306] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */, 13);
		// 307: TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space
		serializationSteps[307] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */, 13);
		// 308: TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space
		serializationSteps[308] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */, 13);
		// 309: TypedElementCS::qualifiers+='definition' || soft-space value soft-space
		serializationSteps[309] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 15 /* 'definition' */, 13);
		// 310: TypedElementCS::qualifiers+='static' || soft-space value soft-space
		serializationSteps[310] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 23 /* 'static' */, 13);
		// 311: PathElementCS::referredElement=URI || soft-space value soft-space
		serializationSteps[311] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "URI"), 126, 13);
		// 312: PathElementCS::referredElement=UnreservedName || soft-space value soft-space
		serializationSteps[312] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnreservedName"), 133, 13);
		// 313: PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space
		serializationSteps[313] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnrestrictedName"), 135, 13);
	}

	/**
	 * Initialize the various serialization steps used to serialize a serialization rule.
	 */
	private void initSubstringSteps() {
		// 0: '->' : [no-space, value, no-space]
		substringSteps[0] = createSubstringStep("->", 7 /* no-space, value, no-space */);
		// 1: '.' : [no-space, value, no-space]
		substringSteps[1] = createSubstringStep(".", 7 /* no-space, value, no-space */);
		// 2: '?->' : [no-space, value, no-space]
		substringSteps[2] = createSubstringStep("?->", 7 /* no-space, value, no-space */);
		// 3: '?.' : [no-space, value, no-space]
		substringSteps[3] = createSubstringStep("?.", 7 /* no-space, value, no-space */);
		// 4: 'else' : [soft-new-line, pop, value, push, soft-space]
		substringSteps[4] = createSubstringStep("else", 24 /* soft-new-line, pop, value, push, soft-space */);
		// 5: 'endif' : [soft-new-line, pop, value, soft-space]
		substringSteps[5] = createSubstringStep("endif", 18 /* soft-new-line, pop, value, soft-space */);
		// 6: 'if' : [soft-new-line, value, push, soft-space]
		substringSteps[6] = createSubstringStep("if", 20 /* soft-new-line, value, push, soft-space */);
		// 7: 'in' : [soft-space, pop, value, soft-new-line]
		substringSteps[7] = createSubstringStep("in", 21 /* soft-space, pop, value, soft-new-line */);
		// 8: 'let' : [soft-space, value, push]
		substringSteps[8] = createSubstringStep("let", 12 /* soft-space, value, push */);
		// 9: 'then' : [pop, soft-space, value, push, soft-space]
		substringSteps[9] = createSubstringStep("then", 23 /* pop, soft-space, value, push, soft-space */);
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
//	import QVTcoreCSPackage;
//	import Grammar;
//	import GrammarProvider;
