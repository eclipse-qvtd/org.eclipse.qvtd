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
package org.eclipse.qvtd.xtext.qvtimperative.serializer;

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
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.service.GrammarProvider;

/******* This file is 100% auto-generated - do not edit it *******/

/**
 * The QVTimperativeSerializationMetaData singleton provides the metadata to support a
 * model to text serialization of a parsed Xtext semantic model or to re-format an Xtext text node model.
 */
public class QVTimperativeSerializationMetaData extends AbstractSerializationMetaData
{
	/**
	 * The Provider supports injected creation of the QVTimperativeSerializationMetaData singleton.
	 */
	public static class Provider implements SerializationMetaData.Provider
	{
		private static @Nullable QVTimperativeSerializationMetaData INSTANCE = null;

		@Inject
		private GrammarProvider grammarProvider;

		@Override
		public synchronized @NonNull SerializationMetaData get() {
			// synchronized synchronizes the creation of this singleton.
			// It does not imply that the overall application is threadsafe.
			QVTimperativeSerializationMetaData instance = INSTANCE;
			if (instance == null) {
				assert grammarProvider != null;
				Grammar grammar = grammarProvider.getGrammar(Provider.class);
				assert grammar != null;
				INSTANCE = instance = new QVTimperativeSerializationMetaData(grammar);
			}
			return instance;
		}
	}

	private final @NonNull EClassValue @NonNull [] eClassValues = new @NonNull EClassValue[86];
	private final @NonNull EnumerationValue @NonNull [] enumerationValues = new @NonNull EnumerationValue[31];
	private final @NonNull GrammarRuleValue @NonNull [] grammarRuleValues = new @NonNull GrammarRuleValue[151];
	private final @NonNull GrammarRuleVector @NonNull [] grammarRuleVectors = new @NonNull GrammarRuleVector[81];
	private final @NonNull SerializationMatchStep @NonNull [] serializationMatchSteps = new @NonNull SerializationMatchStep[394];
	private final @NonNull SerializationMatchTerm @NonNull [] serializationMatchTerms = new @NonNull SerializationMatchTerm[323];
	private final @NonNull SerializationRule @NonNull [] serializationRules = new @NonNull SerializationRule[167];
	private final @NonNull SerializationSegment @NonNull [] @NonNull [] serializationSegments = new @NonNull SerializationSegment @NonNull [10] @NonNull [];
	private final @NonNull SerializationStep @NonNull [] serializationSteps = new @NonNull SerializationStep[340];
	private final @Nullable String @Nullable [] multipleLineCommentMidfixes = new @Nullable String[] {" *"};
	private final @NonNull String @Nullable [] multipleLineCommentPrefixes = new @NonNull String[] {"/*"};
	private final @NonNull String @Nullable [] multipleLineCommentSuffixes = new @NonNull String[] {"*/"};
	private final @NonNull String @Nullable [] singleLineCommentPrefixes = new @NonNull String[] {"--"};

	private QVTimperativeSerializationMetaData(@NonNull Grammar grammar) {
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
		return 170;
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
		return 169;
	}

	@Override
	protected int getLastGlobalSerializationStepLiteralIndex() {
		return 246;
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
		eClassValues[0] = new EClassValue(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS,
			createSerializationRules(
				134 /* AddStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'add' AddStatementCS::targetVariable=UnrestrictedName '+=' AddStatementCS::ownedExpression=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[1] = new EClassValue(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS,
			createSerializationRules(
				135 /* AppendParameterBindingCS-0: AppendParameterBindingCS::referredVariable=UnrestrictedName 'appendsTo' AppendParameterBindingCS::value=UnrestrictedName ';' */
			), null
		);
		eClassValues[2] = new EClassValue(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_CS,
			createSerializationRules(
				136 /* AppendParameterCS-0: 'append' NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[3] = new EClassValue(BaseCSPackage.Literals.ATTRIBUTE_CS,
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
		eClassValues[4] = new EClassValue(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS,
			createSerializationRules(
				17 /* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			), null
		);
		eClassValues[5] = new EClassValue(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS,
			createSerializationRules(
				137 /* BufferStatementCS-0: (BufferStatementCS::isStrict?='strict')[V0:?] 'buffer' (':' BufferStatementCS::firstPass=LOWER ('..' BufferStatementCS::lastPass=LOWER)[V2:?])[V1:?] NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V3:?] (':=' BufferStatementCS::ownedExpression=ExpCS)[V4:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[6] = new EClassValue(QVTimperativeCSPackage.Literals.CHECK_STATEMENT_CS,
			createSerializationRules(
				138 /* CheckStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'check' CheckStatementCS::ownedCondition=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.CHECK_STATEMENT_CS__OWNED_CONDITION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[7] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS,
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
		eClassValues[8] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS,
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
		eClassValues[9] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS,
			createSerializationRules(
				22 /* CollectionPatternCS-0: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' */,
				70 /* TypeExpCS-4: CollectionPatternCS::ownedType=CollectionTypeCS '{' (CollectionPatternCS::ownedParts+=PatternExpCS (',' CollectionPatternCS::ownedParts+=PatternExpCS)[V1:*] '++' CollectionPatternCS::restVariableName=Identifier)[V0:?] '}' (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS,
					29) /* PatternExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE,
					2) /* CollectionTypeCS */
			}
		);
		eClassValues[10] = new EClassValue(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS,
			createSerializationRules(
				23 /* CollectionTypeCS-0: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] */,
				67 /* TypeExpCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				74 /* TypeLiteralWithMultiplicityCS-1: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				131 /* TypedMultiplicityRefCS-2: CollectionTypeCS::name=CollectionTypeIdentifier ('(' CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS (CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS)[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE,
					64) /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */
			}
		);
		eClassValues[11] = new EClassValue(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS,
			createSerializationRules(
				88 /* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS,
					42) /* SimpleTargetElementCS */
			}
		);
		eClassValues[12] = new EClassValue(EssentialOCLCSPackage.Literals.CONTEXT_CS,
			createSerializationRules(
				35 /* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[13] = new EClassValue(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				24 /* CurlyBracketedClauseCS-0: '{' (CurlyBracketedClauseCS::ownedParts+=ShadowPartCS (',' CurlyBracketedClauseCS::ownedParts+=ShadowPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS,
					39) /* ShadowPartCS */
			}
		);
		eClassValues[14] = new EClassValue(BaseCSPackage.Literals.DATA_TYPE_CS,
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
		eClassValues[15] = new EClassValue(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS,
			createSerializationRules(
				139 /* DeclareStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (DeclareStatementCS::isCheck?='check')[V2:?] 'var' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V3:?] ':=' DeclareStatementCS::ownedExpression=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[16] = new EClassValue(QVTimperativeCSPackage.Literals.DIRECTION_CS,
			createSerializationRules(
				140 /* DirectionCS-0: (NamedElementCS::name=Identifier)[V0:?] ('imports' DirectionCS::imports+=UnrestrictedName (',' DirectionCS::imports+=UnrestrictedName)[V2:*])[V1:?] */
			), null
		);
		eClassValues[17] = new EClassValue(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS,
			createSerializationRules(
				141 /* EntryPointCS-0: (MappingCS::isStrict?='strict')[V0:?] 'entry' (':' EntryPointCS::targetName=UnrestrictedName)[V1:?] NamedElementCS::name=UnrestrictedName ('input' EntryPointCS::inputTypedModels+=UnrestrictedName (',' EntryPointCS::inputTypedModels+=UnrestrictedName)[V3:*])[V2:?] ('output' EntryPointCS::outputTypedModels+=UnrestrictedName (',' EntryPointCS::outputTypedModels+=UnrestrictedName)[V5:*])[V4:?] '{' (MappingCS::ownedParameters+=MappingParameterCS)[V6:*] (MappingCS::ownedStatements+=GuardStatementCS)[V7:*] (MappingCS::ownedStatements+=CommitStatementCS)[V8:*] (MappingCS::ownedStatements+=ControlStatementCS)[V9:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_PARAMETERS,
					41) /* AppendParameterCS|GuardParameterCS|MappingParameterCS|SimpleParameterCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_STATEMENTS,
					46) /* AddStatementCS|BufferStatementCS|CheckStatementCS|CommitStatementCS|ControlStatementCS|DeclareStatementCS|GuardStatementCS|MappingCallCS|MappingLoopCS|NewStatementCS|SetStatementCS|SpeculateStatementCS */
			}
		);
		eClassValues[18] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_CS,
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
					54) /* TemplateSignatureCS */
			}
		);
		eClassValues[19] = new EClassValue(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS,
			createSerializationRules(
				103 /* EnumerationLiteralCS-2: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				101 /* EnumerationLiteralCS-0: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] ';' */,
				104 /* EnumerationLiteralCS-3: NamedElementCS::name=EnumerationLiteralName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */,
				102 /* EnumerationLiteralCS-1: 'literal' NamedElementCS::name=UnrestrictedName ('=' EnumerationLiteralCS::value=SIGNED)[V0:?] '{' '}' */
			), null
		);
		eClassValues[20] = new EClassValue(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS,
			createSerializationRules(
				124 /* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				125 /* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[21] = new EClassValue(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS,
			createSerializationRules(
				142 /* GuardParameterBindingCS-0: (GuardParameterBindingCS::isCheck?='check')[V0:?] GuardParameterBindingCS::referredVariable=UnrestrictedName 'consumes' GuardParameterBindingCS::value=UnrestrictedName ';' */
			), null
		);
		eClassValues[22] = new EClassValue(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS,
			createSerializationRules(
				143 /* GuardParameterCS-0: 'guard' ':' GuardParameterCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ('success' GuardParameterCS::successProperty=UnrestrictedName)[V0:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[23] = new EClassValue(EssentialOCLCSPackage.Literals.IF_EXP_CS,
			createSerializationRules(
				27 /* IfExpCS-0: 'if' IfExpCS::ownedCondition=ExpCS|PatternExpCS 'then' IfExpCS::ownedThenExpression=ExpCS (IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS)[V0:*] 'else' IfExpCS::ownedElseExpression=ExpCS 'endif' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION,
					79) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS,
					6) /* ElseIfThenExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[24] = new EClassValue(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS,
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
		eClassValues[25] = new EClassValue(BaseCSPackage.Literals.IMPORT_CS,
			createSerializationRules(
				144 /* ImportCS-0: 'import' (NamedElementCS::name=Identifier ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS (ImportCS::isAll?='::' '*')[V1:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME,
					72) /* URIPathNameCS */
			}
		);
		eClassValues[26] = new EClassValue(EssentialOCLCSPackage.Literals.INFIX_EXP_CS,
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
		eClassValues[27] = new EClassValue(EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS,
			createSerializationRules(
				28 /* InvalidLiteralExpCS-0: 'invalid' */
			), null
		);
		eClassValues[28] = new EClassValue(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS,
			createSerializationRules(
				29 /* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[29] = new EClassValue(EssentialOCLCSPackage.Literals.LET_EXP_CS,
			createSerializationRules(
				30 /* LetExpCS-0: 'let' LetExpCS::ownedVariables+=LetVariableCS (',' LetExpCS::ownedVariables+=LetVariableCS)[V0:*] 'in' LetExpCS::ownedInExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES,
					12) /* LetVariableCS */
			}
		);
		eClassValues[30] = new EClassValue(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS,
			createSerializationRules(
				31 /* LetVariableCS-0: NamedElementCS::name=UnrestrictedName (LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V0:?] (':' VariableCS::ownedType=TypeExpCS)[V1:?] '=' VariableCS::ownedInitExpression=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					36) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[31] = new EClassValue(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS,
			createSerializationRules(
				145 /* LoopParameterBindingCS-0: (LoopParameterBindingCS::isCheck?='check')[V0:?] LoopParameterBindingCS::referredVariable=UnrestrictedName 'iterates' LoopParameterBindingCS::value=UnrestrictedName ';' */
			), null
		);
		eClassValues[32] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS,
			createSerializationRules(
				32 /* MapLiteralExpCS-0: MapLiteralExpCS::ownedType=MapTypeCS '{' (MapLiteralExpCS::ownedParts+=MapLiteralPartCS (',' MapLiteralExpCS::ownedParts+=MapLiteralPartCS)[V1:*])[V0:?] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS,
					13) /* MapLiteralPartCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE,
					14) /* MapTypeCS */
			}
		);
		eClassValues[33] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS,
			createSerializationRules(
				33 /* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS '<-' MapLiteralPartCS::ownedValue=ExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[34] = new EClassValue(EssentialOCLCSPackage.Literals.MAP_TYPE_CS,
			createSerializationRules(
				34 /* MapTypeCS-0: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] */,
				68 /* TypeExpCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				75 /* TypeLiteralWithMultiplicityCS-2: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */,
				132 /* TypedMultiplicityRefCS-3: MapTypeCS::name='Map' ('(' MapTypeCS::ownedKeyType=TypeExpCS ',' MapTypeCS::ownedValueType=TypeExpCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE,
					60) /* TypeExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[35] = new EClassValue(QVTimperativeCSPackage.Literals.MAPPING_CS,
			createSerializationRules(
				146 /* MappingCS-0: (MappingCS::isStrict?='strict')[V0:?] 'map' (':' MappingCS::firstPass=LOWER ('..' MappingCS::lastPass=LOWER)[V2:?])[V1:?] NamedElementCS::name=UnrestrictedName '{' (MappingCS::ownedParameters+=MappingParameterCS)[V3:*] (MappingCS::ownedStatements+=GuardStatementCS)[V4:*] (MappingCS::ownedStatements+=CommitStatementCS)[V5:*] (MappingCS::ownedStatements+=ControlStatementCS)[V6:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_PARAMETERS,
					41) /* AppendParameterCS|GuardParameterCS|MappingParameterCS|SimpleParameterCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_STATEMENTS,
					46) /* AddStatementCS|BufferStatementCS|CheckStatementCS|CommitStatementCS|ControlStatementCS|DeclareStatementCS|GuardStatementCS|MappingCallCS|MappingLoopCS|NewStatementCS|SetStatementCS|SpeculateStatementCS */
			}
		);
		eClassValues[36] = new EClassValue(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS,
			createSerializationRules(
				147 /* MappingCallCS-0: 'call' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */,
				148 /* MappingCallCS-1: MappingCallCS::isInstall?='install' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */,
				149 /* MappingCallCS-2: MappingCallCS::isInvoke?='invoke' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_BINDINGS,
					40) /* AppendParameterBindingCS|GuardParameterBindingCS|LoopParameterBindingCS|MappingParameterBindingCS|SimpleParameterBindingCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_PATH_NAME,
					28) /* PathNameCS */
			}
		);
		eClassValues[37] = new EClassValue(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS,
			createSerializationRules(
				151 /* MappingLoopCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'for' MappingLoopCS::ownedIterator=MappingIteratorCS 'in' MappingLoopCS::ownedInExpression=ExpCS '{' (MappingLoopCS::ownedMappingStatements+=ControlStatementCS)[V2:+] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_ITERATOR,
					16) /* MappingIteratorCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS,
					17) /* AddStatementCS|ControlStatementCS|MappingCallCS|MappingLoopCS */
			}
		);
		eClassValues[38] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS,
			createSerializationRules(
				1 /* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */,
				4 /* MultiplicityCS-2: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] ']' */,
				2 /* MultiplicityCS-0: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] '|?' ']' */,
				3 /* MultiplicityCS-1: '[' MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] MultiplicityCS::isNullFree?='|1' ']' */
			), null
		);
		eClassValues[39] = new EClassValue(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS,
			createSerializationRules(
				7 /* MultiplicityCS-5: '[' MultiplicityStringCS::stringBounds='*|+|?' ']' */,
				5 /* MultiplicityCS-3: '[' MultiplicityStringCS::stringBounds='*|+|?' '|?' ']' */,
				6 /* MultiplicityCS-4: '[' MultiplicityStringCS::stringBounds='*|+|?' MultiplicityCS::isNullFree?='|1' ']' */,
				8 /* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			), null
		);
		eClassValues[40] = new EClassValue(EssentialOCLCSPackage.Literals.NAME_EXP_CS,
			createSerializationRules(
				36 /* NameExpCS-0: AbstractNameExpCS::ownedPathName=PathNameCS (AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS)[V0:*] (AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS)[V1:?] (AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS)[V2:?] (AbstractNameExpCS::isPre?='@' 'pre')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					4) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE,
					36) /* RoundBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES,
					47) /* SquareBracketedClauseCS */
			}
		);
		eClassValues[41] = new EClassValue(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS,
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
					0) /* CoIteratorVariableCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION,
					78) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[42] = new EClassValue(EssentialOCLCSPackage.Literals.NESTED_EXP_CS,
			createSerializationRules(
				48 /* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[43] = new EClassValue(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS,
			createSerializationRules(
				152 /* NewStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (NewStatementCS::isContained?='contained')[V2:?] 'new' ':' NewStatementCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS (':=' NewStatementCS::ownedExpression=ExpCS)[V3:?] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[44] = new EClassValue(EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS,
			createSerializationRules(
				49 /* NullLiteralExpCS-0: 'null' */
			), null
		);
		eClassValues[45] = new EClassValue(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS,
			createSerializationRules(
				50 /* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			), null
		);
		eClassValues[46] = new EClassValue(BaseCSPackage.Literals.OPERATION_CS,
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
					69) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS,
					27) /* ParameterCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					54) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					67) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[47] = new EClassValue(QVTimperativeCSPackage.Literals.PARAM_DECLARATION_CS,
			createSerializationRules(
				153 /* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[48] = new EClassValue(BaseCSPackage.Literals.PARAMETER_CS,
			createSerializationRules(
				111 /* ParameterCS-0: NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypedMultiplicityRefCS)[V0:?] ('{' (TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique')[V2:+] '}')[V1:?] ('{' '}')[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					67) /* TypedMultiplicityRefCS */
			}
		);
		eClassValues[49] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_CS,
			createSerializationRules(
				0 /* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */,
				9 /* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */,
				79 /* URIFirstPathElementCS-1: PathElementCS::referredElement=UnrestrictedName */
			), null
		);
		eClassValues[50] = new EClassValue(BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS,
			createSerializationRules(
				78 /* URIFirstPathElementCS-0: PathElementCS::referredElement=URI */
			), null
		);
		eClassValues[51] = new EClassValue(BaseCSPackage.Literals.PATH_NAME_CS,
			createSerializationRules(
				10 /* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				59 /* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */,
				80 /* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */,
				159 /* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS,
					71) /* FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS */
			}
		);
		eClassValues[52] = new EClassValue(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS,
			createSerializationRules(
				51 /* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[53] = new EClassValue(EssentialOCLCSPackage.Literals.PREFIX_EXP_CS,
			createSerializationRules(
				52 /* PrefixedLetExpCS-1: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedLetExpCS */,
				53 /* PrefixedPrimaryExpCS-15: NamedElementCS::name=UnaryOperatorName OperatorExpCS::ownedRight=PrefixedPrimaryExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT,
					76) /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[54] = new EClassValue(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS,
			createSerializationRules(
				54 /* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */,
				66 /* TypeExpCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				73 /* TypeLiteralWithMultiplicityCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */,
				129 /* TypedMultiplicityRefCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */
			}
		);
		eClassValues[55] = new EClassValue(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS,
			createSerializationRules(
				154 /* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				155 /* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES,
					57) /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					34) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME,
					37) /* ScopeNameCS */
			}
		);
		eClassValues[56] = new EClassValue(QVTimperativeCSPackage.Literals.QUERY_CS,
			createSerializationRules(
				156 /* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				157 /* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				158 /* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS,
					26) /* ParamDeclarationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[57] = new EClassValue(BaseCSPackage.Literals.REFERENCE_CS,
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
		eClassValues[58] = new EClassValue(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				55 /* RoundBracketedClauseCS-0: '(' (RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS (RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[V1:*])[V0:?] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS,
					23) /* NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS */
			}
		);
		eClassValues[59] = new EClassValue(EssentialOCLCSPackage.Literals.SELF_EXP_CS,
			createSerializationRules(
				56 /* SelfExpCS-0: 'self' */
			), null
		);
		eClassValues[60] = new EClassValue(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS,
			createSerializationRules(
				160 /* SetStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (SetStatementCS::isNotify?='notify')[V2:?] 'set' SetStatementCS::referredVariable=UnrestrictedName '.' SetStatementCS::referredProperty=UnrestrictedName ':=' SetStatementCS::ownedExpression=ExpCS ';' */,
				161 /* SetStatementCS-1: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (SetStatementCS::isNotify?='notify')[V2:?] 'set' SetStatementCS::referredVariable=UnrestrictedName '.' SetStatementCS::referredProperty=UnrestrictedName SetStatementCS::isPartial?='+=' SetStatementCS::ownedExpression=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__OWNED_EXPRESSION,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[61] = new EClassValue(EssentialOCLCSPackage.Literals.SHADOW_PART_CS,
			createSerializationRules(
				58 /* ShadowPartCS-1: ShadowPartCS::ownedInitExpression=StringLiteralExpCS */,
				57 /* ShadowPartCS-0: ShadowPartCS::referredProperty=UnrestrictedName '=' ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION,
					79) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[62] = new EClassValue(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS,
			createSerializationRules(
				162 /* SimpleParameterBindingCS-0: (SimpleParameterBindingCS::isCheck?='check')[V0:?] SimpleParameterBindingCS::referredVariable=UnrestrictedName 'uses' SimpleParameterBindingCS::ownedValue=ExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__OWNED_VALUE,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[63] = new EClassValue(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_CS,
			createSerializationRules(
				163 /* SimpleParameterCS-0: 'in' ':' SimpleParameterCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[64] = new EClassValue(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS,
			createSerializationRules(
				118 /* SimpleTargetElementCS-0: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				120 /* SimpleTargetElementCS-2: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				122 /* SimpleTargetElementCS-4: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' SimpleTargetElementCS::iterates+=UnrestrictedName)[V0:?] ';' */,
				119 /* SimpleTargetElementCS-1: SimpleTargetElementCS::input?='input' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				121 /* SimpleTargetElementCS-3: SimpleTargetElementCS::output?='output' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */,
				123 /* SimpleTargetElementCS-5: SimpleTargetElementCS::via?='via' SimpleTargetElementCS::typedModel=UnrestrictedName ('iterates' '{' (SimpleTargetElementCS::iterates+=UnrestrictedName (',' SimpleTargetElementCS::iterates+=UnrestrictedName)[V2:*])[V1:?] '}')[V0:?] ';' */
			), null
		);
		eClassValues[65] = new EClassValue(QVTimperativeCSPackage.Literals.SPECULATE_STATEMENT_CS,
			createSerializationRules(
				164 /* SpeculateStatementCS-0: 'speculate' SpeculateStatementCS::ownedConditions+=ExpCS (',' SpeculateStatementCS::ownedConditions+=ExpCS)[V0:*] ';' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.SPECULATE_STATEMENT_CS__OWNED_CONDITIONS,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[66] = new EClassValue(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS,
			createSerializationRules(
				60 /* SquareBracketedClauseCS-0: '[' SquareBracketedClauseCS::ownedTerms+=ExpCS (',' SquareBracketedClauseCS::ownedTerms+=ExpCS)[V0:*] ']' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[67] = new EClassValue(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS,
			createSerializationRules(
				61 /* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			), null
		);
		eClassValues[68] = new EClassValue(BaseCSPackage.Literals.STRUCTURED_CLASS_CS,
			createSerializationRules(
				126 /* StructuredClassCS-0: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] ';' */,
				127 /* StructuredClassCS-1: (StructuredClassCS::isAbstract?='abstract')[V0:?] 'class' NamedElementCS::name=UnrestrictedName (TemplateableElementCS::ownedSignature=TemplateSignatureCS)[V1:?] ('extends' StructuredClassCS::ownedSuperTypes+=TypedRefCS (',' StructuredClassCS::ownedSuperTypes+=TypedRefCS)[V3:*])[V2:?] (':' ClassCS::instanceClassName=SINGLE_QUOTED_STRING)[V4:?] ('{' (StructuredClassCS::isInterface?='interface')[V6:?] '}')[V5:?] '{' (StructuredClassCS::ownedOperations+=OperationCS)[V7:*] (StructuredClassCS::ownedProperties+=StructuralFeatureCS)[V8:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS,
					25) /* OperationCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES,
					50) /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE,
					54) /* TemplateSignatureCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES,
					69) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[69] = new EClassValue(QVTbaseCSPackage.Literals.TARGET_CS,
			createSerializationRules(
				128 /* TargetCS-0: 'target' NamedElementCS::name=UnrestrictedName '{' (TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS,
					43) /* CompoundTargetElementCS|SimpleTargetElementCS */
			}
		);
		eClassValues[70] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_BINDING_CS,
			createSerializationRules(
				11 /* TemplateBindingCS-0: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS (',' TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS)[V0:*] (TemplateBindingCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS,
					53) /* TemplateParameterSubstitutionCS */
			}
		);
		eClassValues[71] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS,
			createSerializationRules(
				12 /* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER,
					80) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */
			}
		);
		eClassValues[72] = new EClassValue(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS,
			createSerializationRules(
				13 /* TemplateSignatureCS-0: '(' TemplateSignatureCS::ownedParameters+=TypeParameterCS (',' TemplateSignatureCS::ownedParameters+=TypeParameterCS)[V0:*] ')' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS,
					65) /* TypeParameterCS */
			}
		);
		eClassValues[73] = new EClassValue(QVTimperativeCSPackage.Literals.TOP_LEVEL_CS,
			createSerializationRules(
				165 /* TopLevelCS-0: (RootCS::ownedImports+=ImportCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS,
					11) /* ImportCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES,
					34) /* QualifiedPackageCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS,
					55) /* TransformationCS */
			}
		);
		eClassValues[74] = new EClassValue(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS,
			createSerializationRules(
				166 /* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnreservedName (':' TransformationCS::ownedContextType=TypeExpCS)[V1:?] '{' (TransformationCS::ownedDirections+=DirectionCS ';')[V2:*] (TransformationCS::ownedMappings+=EntryPointCS|MappingCS)[V3:*] (TransformationCS::ownedQueries+=QueryCS)[V4:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_CONTEXT_TYPE,
					60) /* TypeExpCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS,
					5) /* DirectionCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_MAPPINGS,
					15) /* EntryPointCS|MappingCS */,
				createEReference_TargetGrammarRuleVector(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME,
					37) /* ScopeNameCS */,
				createEReference_TargetGrammarRuleVector(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES,
					35) /* QueryCS */
			}
		);
		eClassValues[75] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS,
			createSerializationRules(
				62 /* TupleLiteralExpCS-0: 'Tuple' '{' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS (',' TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS)[V0:*] '}' */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS,
					58) /* TupleLiteralPartCS */
			}
		);
		eClassValues[76] = new EClassValue(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS,
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
		eClassValues[77] = new EClassValue(BaseCSPackage.Literals.TUPLE_PART_CS,
			createSerializationRules(
				64 /* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[78] = new EClassValue(BaseCSPackage.Literals.TUPLE_TYPE_CS,
			createSerializationRules(
				65 /* TupleTypeCS-0: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] */,
				71 /* TypeExpCS-5: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				76 /* TypeLiteralWithMultiplicityCS-3: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */,
				133 /* TypedMultiplicityRefCS-4: TupleTypeCS::name='Tuple' ('(' (TupleTypeCS::ownedParts+=TuplePartCS (',' TupleTypeCS::ownedParts+=TuplePartCS)[V2:*])[V1:?] ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V3:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS,
					59) /* TuplePartCS */
			}
		);
		eClassValues[79] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS,
			createSerializationRules(
				72 /* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE,
					63) /* TypeLiteralWithMultiplicityCS */
			}
		);
		eClassValues[80] = new EClassValue(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS,
			createSerializationRules(
				69 /* TypeExpCS-3: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V2:?] */,
				77 /* TypeNameExpCS-0: TypeNameExpCS::ownedPathName=PathNameCS (TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS ('{' TypeNameExpCS::ownedPatternGuard=ExpCS '}')[V1:?])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE,
					4) /* CurlyBracketedClauseCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME,
					28) /* PathNameCS */,
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD,
					77) /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */
			}
		);
		eClassValues[81] = new EClassValue(BaseCSPackage.Literals.TYPE_PARAMETER_CS,
			createSerializationRules(
				14 /* TypeParameterCS-0: NamedElementCS::name=UnrestrictedName ('extends' TypeParameterCS::ownedExtends+=TypedRefCS ('&&' TypeParameterCS::ownedExtends+=TypedRefCS)[V1:*])[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS,
					69) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
			}
		);
		eClassValues[82] = new EClassValue(BaseCSPackage.Literals.TYPED_TYPE_REF_CS,
			createSerializationRules(
				15 /* TypedTypeRefCS-0: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] */,
				130 /* TypedMultiplicityRefCS-1: TypedTypeRefCS::ownedPathName=PathNameCS ('(' TypedTypeRefCS::ownedBinding=TemplateBindingCS ')')[V0:?] (TypedRefCS::ownedMultiplicity=MultiplicityCS)[V1:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING,
					52) /* TemplateBindingCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY,
					20) /* MultiplicityCS */,
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME,
					28) /* PathNameCS */
			}
		);
		eClassValues[83] = new EClassValue(EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS,
			createSerializationRules(
				81 /* UnlimitedNaturalLiteralExpCS-0: '*' */
			), null
		);
		eClassValues[84] = new EClassValue(EssentialOCLCSPackage.Literals.VARIABLE_CS,
			createSerializationRules(
				18 /* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */,
				150 /* MappingIteratorCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE,
					60) /* TypeExpCS */
			}
		);
		eClassValues[85] = new EClassValue(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS,
			createSerializationRules(
				16 /* WildcardTypeRefCS-0: '?' ('extends' WildcardTypeRefCS::ownedExtends=TypedRefCS)[V0:?] */
			),
			new @NonNull EReference_TargetGrammarRuleVector [] {
				createEReference_TargetGrammarRuleVector(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS,
					69) /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */
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
		// 14: 'contained'
		enumerationValues[14] = new EnumerationValueSingle("contained");
		// 15: 'definition'
		enumerationValues[15] = new EnumerationValueSingle("definition");
		// 16: 'false|true'
		enumerationValues[16] = new EnumerationValueMultiple(new @NonNull String[]{"false", "true"});
		// 17: 'input'
		enumerationValues[17] = new EnumerationValueSingle("input");
		// 18: 'install'
		enumerationValues[18] = new EnumerationValueSingle("install");
		// 19: 'interface'
		enumerationValues[19] = new EnumerationValueSingle("interface");
		// 20: 'invoke'
		enumerationValues[20] = new EnumerationValueSingle("invoke");
		// 21: 'notify'
		enumerationValues[21] = new EnumerationValueSingle("notify");
		// 22: 'output'
		enumerationValues[22] = new EnumerationValueSingle("output");
		// 23: 'primitive'
		enumerationValues[23] = new EnumerationValueSingle("primitive");
		// 24: 'serializable'
		enumerationValues[24] = new EnumerationValueSingle("serializable");
		// 25: 'static'
		enumerationValues[25] = new EnumerationValueSingle("static");
		// 26: 'strict'
		enumerationValues[26] = new EnumerationValueSingle("strict");
		// 27: 'transient'
		enumerationValues[27] = new EnumerationValueSingle("transient");
		// 28: 'via'
		enumerationValues[28] = new EnumerationValueSingle("via");
		// 29: '|'
		enumerationValues[29] = new EnumerationValueSingle("|");
		// 30: '|1'
		enumerationValues[30] = new EnumerationValueSingle("|1");
	}

	/**
	 * Initialize the various serialization rules for each grammar rule.
	 */
	private void initGrammarRuleValues() {
		grammarRuleValues[0] = new TerminalRuleValue(0, "ANY_OTHER");
		grammarRuleValues[1] = createParserRuleValue(1, "AddStatementCS", -1,
			createSerializationRules(
				134	/* AddStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'add' AddStatementCS::targetVariable=UnrestrictedName '+=' AddStatementCS::ownedExpression=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "observe" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 7	/* "add" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* targetVariable=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "+=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[2] = createParserRuleValue(2, "AppendParameterBindingCS", -1,
			createSerializationRules(
				135	/* AppendParameterBindingCS-0: AppendParameterBindingCS::referredVariable=UnrestrictedName 'appendsTo' AppendParameterBindingCS::value=UnrestrictedName ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* referredVariable=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "appendsTo" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* value=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[3] = createParserRuleValue(3, "AppendParameterCS", -1,
			createSerializationRules(
				136	/* AppendParameterCS-0: 'append' NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "append" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[4] = createParserRuleValue(4, "AttributeCS", -1,
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
		grammarRuleValues[5] = new DataTypeRuleValue(5, "BinaryOperatorName");
		grammarRuleValues[6] = createParserRuleValue(6, "BooleanLiteralExpCS", -1,
			createSerializationRules(
				17	/* BooleanLiteralExpCS-0: BooleanLiteralExpCS::symbol='false|true' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* symbol="true" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* symbol="false" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[7] = createParserRuleValue(7, "BufferStatementCS", -1,
			createSerializationRules(
				137	/* BufferStatementCS-0: (BufferStatementCS::isStrict?='strict')[V0:?] 'buffer' (':' BufferStatementCS::firstPass=LOWER ('..' BufferStatementCS::lastPass=LOWER)[V2:?])[V1:?] NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V3:?] (':=' BufferStatementCS::ownedExpression=ExpCS)[V4:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isStrict?="strict"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "buffer" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* firstPass=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 7	/* lastPass=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[8] = createParserRuleValue(8, "CheckStatementCS", -1,
			createSerializationRules(
				138	/* CheckStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'check' CheckStatementCS::ownedCondition=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "observe" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 7	/* "check" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[9] = createParserRuleValue(9, "ClassCS", 51 /* ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS */,
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
		grammarRuleValues[10] = createParserRuleValue(10, "CoIteratorVariableCS", -1,
			createSerializationRules(
				18	/* CoIteratorVariableCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[11] = createParserRuleValue(11, "CollectionLiteralExpCS", -1,
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
		grammarRuleValues[12] = createParserRuleValue(12, "CollectionLiteralPartCS", -1,
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
		grammarRuleValues[13] = createParserRuleValue(13, "CollectionPatternCS", -1,
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
		grammarRuleValues[14] = createParserRuleValue(14, "CollectionTypeCS", -1,
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
		grammarRuleValues[15] = new DataTypeRuleValue(15, "CollectionTypeIdentifier");
		grammarRuleValues[16] = createParserRuleValue(16, "CommitStatementCS", 38 /* CommitStatementCS|NewStatementCS|SetStatementCS */,
			createSerializationRules(
				152	/* NewStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (NewStatementCS::isContained?='contained')[V2:?] 'new' ':' NewStatementCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS (':=' NewStatementCS::ownedExpression=ExpCS)[V3:?] ';' */,
				160	/* SetStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (SetStatementCS::isNotify?='notify')[V2:?] 'set' SetStatementCS::referredVariable=UnrestrictedName '.' SetStatementCS::referredProperty=UnrestrictedName ':=' SetStatementCS::ownedExpression=ExpCS ';' */,
				161	/* SetStatementCS-1: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (SetStatementCS::isNotify?='notify')[V2:?] 'set' SetStatementCS::referredVariable=UnrestrictedName '.' SetStatementCS::referredProperty=UnrestrictedName SetStatementCS::isPartial?='+=' SetStatementCS::ownedExpression=ExpCS ';' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* NewStatementCS : [value] | [value] */,
			(0 << 16) | 0	/* SetStatementCS : [value] | [value] */
		);
		grammarRuleValues[17] = createParserRuleValue(17, "CompoundTargetElementCS", -1,
			createSerializationRules(
				88	/* CompoundTargetElementCS-0: '{' (CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedTargetElements+=SimpleTargetElementCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */,
			(0 << 16) | 5	/* ";"? : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[18] = createParserRuleValue(18, "ControlStatementCS", 17 /* AddStatementCS|ControlStatementCS|MappingCallCS|MappingLoopCS */,
			createSerializationRules(
				134	/* AddStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'add' AddStatementCS::targetVariable=UnrestrictedName '+=' AddStatementCS::ownedExpression=ExpCS ';' */,
				147	/* MappingCallCS-0: 'call' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */,
				148	/* MappingCallCS-1: MappingCallCS::isInstall?='install' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */,
				149	/* MappingCallCS-2: MappingCallCS::isInvoke?='invoke' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */,
				151	/* MappingLoopCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'for' MappingLoopCS::ownedIterator=MappingIteratorCS 'in' MappingLoopCS::ownedInExpression=ExpCS '{' (MappingLoopCS::ownedMappingStatements+=ControlStatementCS)[V2:+] '}' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* AddStatementCS : [value] | [value] */,
			(0 << 16) | 0	/* MappingCallCS : [value] | [value] */,
			(0 << 16) | 0	/* MappingLoopCS : [value] | [value] */
		);
		grammarRuleValues[19] = createParserRuleValue(19, "CurlyBracketedClauseCS", -1,
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
		grammarRuleValues[20] = new TerminalRuleValue(20, "DOUBLE_QUOTED_STRING");
		grammarRuleValues[21] = createParserRuleValue(21, "DataTypeCS", -1,
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
		grammarRuleValues[22] = createParserRuleValue(22, "DeclareStatementCS", -1,
			createSerializationRules(
				139	/* DeclareStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (DeclareStatementCS::isCheck?='check')[V2:?] 'var' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V3:?] ':=' DeclareStatementCS::ownedExpression=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "observe" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 7	/* isCheck?="check"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "var" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 7	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[23] = createParserRuleValue(23, "DirectionCS", -1,
			createSerializationRules(
				140	/* DirectionCS-0: (NamedElementCS::name=Identifier)[V0:?] ('imports' DirectionCS::imports+=UnrestrictedName (',' DirectionCS::imports+=UnrestrictedName)[V2:*])[V1:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {DirectionCS} : [value] | [value] */,
			(0 << 16) | 7	/* name=Identifier? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "imports" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* imports+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* imports+=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[24] = new TerminalRuleValue(24, "ESCAPED_CHARACTER");
		grammarRuleValues[25] = new TerminalRuleValue(25, "ESCAPED_ID");
		grammarRuleValues[26] = createParserRuleValue(26, "ElseIfThenExpCS", -1,
			createSerializationRules(
				25	/* ElseIfThenExpCS-0: 'elseif' IfThenExpCS::ownedCondition=ExpCS 'then' IfThenExpCS::ownedThenExpression=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "elseif" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedCondition=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "then" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedThenExpression=ExpCS : [value] | [value] */
		);
		grammarRuleValues[27] = createParserRuleValue(27, "EntryPointCS", -1,
			createSerializationRules(
				141	/* EntryPointCS-0: (MappingCS::isStrict?='strict')[V0:?] 'entry' (':' EntryPointCS::targetName=UnrestrictedName)[V1:?] NamedElementCS::name=UnrestrictedName ('input' EntryPointCS::inputTypedModels+=UnrestrictedName (',' EntryPointCS::inputTypedModels+=UnrestrictedName)[V3:*])[V2:?] ('output' EntryPointCS::outputTypedModels+=UnrestrictedName (',' EntryPointCS::outputTypedModels+=UnrestrictedName)[V5:*])[V4:?] '{' (MappingCS::ownedParameters+=MappingParameterCS)[V6:*] (MappingCS::ownedStatements+=GuardStatementCS)[V7:*] (MappingCS::ownedStatements+=CommitStatementCS)[V8:*] (MappingCS::ownedStatements+=ControlStatementCS)[V9:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {EntryPointCS} : [value] | [value] */,
			(0 << 16) | 7	/* isStrict?="strict"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "entry" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* targetName=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "input" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* inputTypedModels+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* inputTypedModels+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "output" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* outputTypedModels+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 7	/* outputTypedModels+=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedParameters+=MappingParameterCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedStatements+=GuardStatementCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedStatements+=CommitStatementCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedStatements+=ControlStatementCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[28] = createParserRuleValue(28, "EnumerationCS", -1,
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
		grammarRuleValues[29] = createParserRuleValue(29, "EnumerationLiteralCS", -1,
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
		grammarRuleValues[30] = new DataTypeRuleValue(30, "EnumerationLiteralName");
		grammarRuleValues[31] = new DataTypeRuleValue(31, "EssentialOCLInfixOperatorName");
		grammarRuleValues[32] = new DataTypeRuleValue(32, "EssentialOCLNavigationOperatorName");
		grammarRuleValues[33] = new DataTypeRuleValue(33, "EssentialOCLReservedKeyword");
		grammarRuleValues[34] = new DataTypeRuleValue(34, "EssentialOCLUnaryOperatorName");
		grammarRuleValues[35] = new DataTypeRuleValue(35, "EssentialOCLUnreservedName");
		grammarRuleValues[36] = new DataTypeRuleValue(36, "EssentialOCLUnrestrictedName");
		grammarRuleValues[37] = createParserRuleValue(37, "ExpCS", 77 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[38] = createParserRuleValue(38, "FirstPathElementCS", -1,
			createSerializationRules(
				0	/* FirstPathElementCS-0: PathElementCS::referredElement=UnrestrictedName */
			),
			(0 << 16) | 7	/* referredElement=UnrestrictedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[39] = createParserRuleValue(39, "GuardParameterBindingCS", -1,
			createSerializationRules(
				142	/* GuardParameterBindingCS-0: (GuardParameterBindingCS::isCheck?='check')[V0:?] GuardParameterBindingCS::referredVariable=UnrestrictedName 'consumes' GuardParameterBindingCS::value=UnrestrictedName ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isCheck?="check"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredVariable=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "consumes" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* value=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[40] = createParserRuleValue(40, "GuardParameterCS", -1,
			createSerializationRules(
				143	/* GuardParameterCS-0: 'guard' ':' GuardParameterCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ('success' GuardParameterCS::successProperty=UnrestrictedName)[V0:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "guard" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredTypedModel=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "success" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* successProperty=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[41] = createParserRuleValue(41, "GuardStatementCS", 45 /* BufferStatementCS|CheckStatementCS|DeclareStatementCS|GuardStatementCS|SpeculateStatementCS */,
			createSerializationRules(
				137	/* BufferStatementCS-0: (BufferStatementCS::isStrict?='strict')[V0:?] 'buffer' (':' BufferStatementCS::firstPass=LOWER ('..' BufferStatementCS::lastPass=LOWER)[V2:?])[V1:?] NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V3:?] (':=' BufferStatementCS::ownedExpression=ExpCS)[V4:?] ';' */,
				138	/* CheckStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'check' CheckStatementCS::ownedCondition=ExpCS ';' */,
				139	/* DeclareStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (DeclareStatementCS::isCheck?='check')[V2:?] 'var' NamedElementCS::name=UnrestrictedName (':' TypedElementCS::ownedType=TypeExpCS)[V3:?] ':=' DeclareStatementCS::ownedExpression=ExpCS ';' */,
				164	/* SpeculateStatementCS-0: 'speculate' SpeculateStatementCS::ownedConditions+=ExpCS (',' SpeculateStatementCS::ownedConditions+=ExpCS)[V0:*] ';' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* BufferStatementCS : [value] | [value] */,
			(0 << 16) | 0	/* DeclareStatementCS : [value] | [value] */,
			(0 << 16) | 0	/* DeclareStatementCS : [value] | [value] */,
			(0 << 16) | 0	/* CheckStatementCS : [value] | [value] */,
			(0 << 16) | 0	/* SpeculateStatementCS : [value] | [value] */
		);
		grammarRuleValues[42] = new DataTypeRuleValue(42, "ID");
		grammarRuleValues[43] = new TerminalRuleValue(43, "INT");
		grammarRuleValues[44] = new DataTypeRuleValue(44, "Identifier");
		grammarRuleValues[45] = createParserRuleValue(45, "IfExpCS", -1,
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
		grammarRuleValues[46] = createParserRuleValue(46, "ImportCS", -1,
			createSerializationRules(
				144	/* ImportCS-0: 'import' (NamedElementCS::name=Identifier ':')[V0:?] ImportCS::ownedPathName=URIPathNameCS (ImportCS::isAll?='::' '*')[V1:?] ';' */
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
		grammarRuleValues[47] = new DataTypeRuleValue(47, "InfixOperatorName");
		grammarRuleValues[48] = createParserRuleValue(48, "InvalidLiteralExpCS", -1,
			createSerializationRules(
				28	/* InvalidLiteralExpCS-0: 'invalid' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {InvalidLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "invalid" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[49] = new TerminalRuleValue(49, "LETTER_CHARACTER");
		grammarRuleValues[50] = new DataTypeRuleValue(50, "LOWER");
		grammarRuleValues[51] = createParserRuleValue(51, "LambdaLiteralExpCS", -1,
			createSerializationRules(
				29	/* LambdaLiteralExpCS-0: 'Lambda' '{' LambdaLiteralExpCS::ownedExpressionCS=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "Lambda" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedExpressionCS=ExpCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[52] = createParserRuleValue(52, "LetExpCS", -1,
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
		grammarRuleValues[53] = createParserRuleValue(53, "LetVariableCS", -1,
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
		grammarRuleValues[54] = createParserRuleValue(54, "LoopParameterBindingCS", -1,
			createSerializationRules(
				145	/* LoopParameterBindingCS-0: (LoopParameterBindingCS::isCheck?='check')[V0:?] LoopParameterBindingCS::referredVariable=UnrestrictedName 'iterates' LoopParameterBindingCS::value=UnrestrictedName ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isCheck?="check"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredVariable=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "iterates" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* value=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[55] = new TerminalRuleValue(55, "ML_COMMENT");
		grammarRuleValues[56] = new TerminalRuleValue(56, "ML_SINGLE_QUOTED_STRING");
		grammarRuleValues[57] = createParserRuleValue(57, "MapLiteralExpCS", -1,
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
		grammarRuleValues[58] = createParserRuleValue(58, "MapLiteralPartCS", -1,
			createSerializationRules(
				33	/* MapLiteralPartCS-0: MapLiteralPartCS::ownedKey=ExpCS '<-' MapLiteralPartCS::ownedValue=ExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedKey=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* "<-" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValue=ExpCS : [value] | [value] */
		);
		grammarRuleValues[59] = createParserRuleValue(59, "MapTypeCS", -1,
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
		grammarRuleValues[60] = createParserRuleValue(60, "MappingCS", -1,
			createSerializationRules(
				146	/* MappingCS-0: (MappingCS::isStrict?='strict')[V0:?] 'map' (':' MappingCS::firstPass=LOWER ('..' MappingCS::lastPass=LOWER)[V2:?])[V1:?] NamedElementCS::name=UnrestrictedName '{' (MappingCS::ownedParameters+=MappingParameterCS)[V3:*] (MappingCS::ownedStatements+=GuardStatementCS)[V4:*] (MappingCS::ownedStatements+=CommitStatementCS)[V5:*] (MappingCS::ownedStatements+=ControlStatementCS)[V6:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {MappingCS} : [value] | [value] */,
			(0 << 16) | 7	/* isStrict?="strict"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "map" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* firstPass=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 7	/* lastPass=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedParameters+=MappingParameterCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedStatements+=GuardStatementCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedStatements+=CommitStatementCS* : [value] | [value] */,
			(0 << 16) | 0	/* ownedStatements+=ControlStatementCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[61] = createParserRuleValue(61, "MappingCallCS", -1,
			createSerializationRules(
				147	/* MappingCallCS-0: 'call' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */,
				148	/* MappingCallCS-1: MappingCallCS::isInstall?='install' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */,
				149	/* MappingCallCS-2: MappingCallCS::isInvoke?='invoke' MappingCallCS::ownedPathName=PathNameCS '{' (MappingCallCS::ownedBindings+=MappingParameterBindingCS)[V0:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {MappingCallCS} : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* "call" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* isInstall?="install" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* isInvoke?="invoke" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=PathNameCS : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedBindings+=MappingParameterBindingCS* : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[62] = createParserRuleValue(62, "MappingIteratorCS", -1,
			createSerializationRules(
				150	/* MappingIteratorCS-0: NamedElementCS::name=UnrestrictedName (':' VariableCS::ownedType=TypeExpCS)[V0:?] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[63] = createParserRuleValue(63, "MappingLoopCS", -1,
			createSerializationRules(
				151	/* MappingLoopCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] 'for' MappingLoopCS::ownedIterator=MappingIteratorCS 'in' MappingLoopCS::ownedInExpression=ExpCS '{' (MappingLoopCS::ownedMappingStatements+=ControlStatementCS)[V2:+] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "observe" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 7	/* "for" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedIterator=MappingIteratorCS : [value] | [value] */,
			(0 << 16) | 7	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedInExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* ownedMappingStatements+=ControlStatementCS+ : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[64] = createParserRuleValue(64, "MappingParameterBindingCS", 40 /* AppendParameterBindingCS|GuardParameterBindingCS|LoopParameterBindingCS|MappingParameterBindingCS|SimpleParameterBindingCS */,
			createSerializationRules(
				135	/* AppendParameterBindingCS-0: AppendParameterBindingCS::referredVariable=UnrestrictedName 'appendsTo' AppendParameterBindingCS::value=UnrestrictedName ';' */,
				142	/* GuardParameterBindingCS-0: (GuardParameterBindingCS::isCheck?='check')[V0:?] GuardParameterBindingCS::referredVariable=UnrestrictedName 'consumes' GuardParameterBindingCS::value=UnrestrictedName ';' */,
				145	/* LoopParameterBindingCS-0: (LoopParameterBindingCS::isCheck?='check')[V0:?] LoopParameterBindingCS::referredVariable=UnrestrictedName 'iterates' LoopParameterBindingCS::value=UnrestrictedName ';' */,
				162	/* SimpleParameterBindingCS-0: (SimpleParameterBindingCS::isCheck?='check')[V0:?] SimpleParameterBindingCS::referredVariable=UnrestrictedName 'uses' SimpleParameterBindingCS::ownedValue=ExpCS ';' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* AppendParameterBindingCS : [value] | [value] */,
			(0 << 16) | 0	/* GuardParameterBindingCS : [value] | [value] */,
			(0 << 16) | 0	/* LoopParameterBindingCS : [value] | [value] */,
			(0 << 16) | 0	/* SimpleParameterBindingCS : [value] | [value] */
		);
		grammarRuleValues[65] = createParserRuleValue(65, "MappingParameterCS", 41 /* AppendParameterCS|GuardParameterCS|MappingParameterCS|SimpleParameterCS */,
			createSerializationRules(
				136	/* AppendParameterCS-0: 'append' NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				143	/* GuardParameterCS-0: 'guard' ':' GuardParameterCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ('success' GuardParameterCS::successProperty=UnrestrictedName)[V0:?] ';' */,
				163	/* SimpleParameterCS-0: 'in' ':' SimpleParameterCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ';' */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* AppendParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* GuardParameterCS : [value] | [value] */,
			(0 << 16) | 0	/* SimpleParameterCS : [value] | [value] */
		);
		grammarRuleValues[66] = createParserRuleValue(66, "Model", -1,
			createSerializationRules(
				35	/* Model-0: ContextCS::ownedExpression=ExpCS */
			),
			(0 << 16) | 2	/* ownedExpression=ExpCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[67] = createParserRuleValue(67, "MultiplicityBoundsCS", -1,
			createSerializationRules(
				1	/* MultiplicityBoundsCS-0: MultiplicityBoundsCS::lowerBound=LOWER ('..' MultiplicityBoundsCS::upperBound=UPPER)[V0:?] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 7	/* lowerBound=LOWER : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 4	/* ".." : [value] | [no-space, value, no-space] */,
			(0 << 16) | 7	/* upperBound=UPPER : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[68] = createParserRuleValue(68, "MultiplicityCS", -1,
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
		grammarRuleValues[69] = createParserRuleValue(69, "MultiplicityStringCS", -1,
			createSerializationRules(
				8	/* MultiplicityStringCS-0: MultiplicityStringCS::stringBounds='*|+|?' */
			),
			(0 << 16) | 7	/* stringBounds=("*"|"+"|"?") : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[70] = new DataTypeRuleValue(70, "NUMBER_LITERAL");
		grammarRuleValues[71] = createParserRuleValue(71, "NameExpCS", -1,
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
		grammarRuleValues[72] = createParserRuleValue(72, "NavigatingArgCS", -1,
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
		grammarRuleValues[73] = createParserRuleValue(73, "NavigatingArgExpCS", 78 /* BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[74] = createParserRuleValue(74, "NavigatingBarArgCS", -1,
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
		grammarRuleValues[75] = createParserRuleValue(75, "NavigatingCommaArgCS", -1,
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
		grammarRuleValues[76] = createParserRuleValue(76, "NavigatingSemiArgCS", -1,
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
		grammarRuleValues[77] = new DataTypeRuleValue(77, "NavigationOperatorName");
		grammarRuleValues[78] = createParserRuleValue(78, "NestedExpCS", -1,
			createSerializationRules(
				48	/* NestedExpCS-0: '(' NestedExpCS::ownedExpression=ExpCS ')' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 4	/* "(" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 1	/* ")" : [value] | [no-space, value] */
		);
		grammarRuleValues[79] = createParserRuleValue(79, "NewStatementCS", -1,
			createSerializationRules(
				152	/* NewStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (NewStatementCS::isContained?='contained')[V2:?] 'new' ':' NewStatementCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS (':=' NewStatementCS::ownedExpression=ExpCS)[V3:?] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "observe" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 7	/* isContained?="contained"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "new" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredTypedModel=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[80] = createParserRuleValue(80, "NextPathElementCS", -1,
			createSerializationRules(
				9	/* NextPathElementCS-0: PathElementCS::referredElement=UnreservedName */
			),
			(0 << 16) | 7	/* referredElement=UnreservedName : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[81] = createParserRuleValue(81, "NullLiteralExpCS", -1,
			createSerializationRules(
				49	/* NullLiteralExpCS-0: 'null' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {NullLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "null" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[82] = createParserRuleValue(82, "NumberLiteralExpCS", -1,
			createSerializationRules(
				50	/* NumberLiteralExpCS-0: NumberLiteralExpCS::symbol=NUMBER_LITERAL */
			),
			(0 << 16) | 2	/* symbol=NUMBER_LITERAL : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[83] = createParserRuleValue(83, "OperationCS", -1,
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
		grammarRuleValues[84] = createParserRuleValue(84, "ParamDeclarationCS", -1,
			createSerializationRules(
				153	/* ParamDeclarationCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[85] = createParserRuleValue(85, "ParameterCS", -1,
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
		grammarRuleValues[86] = createParserRuleValue(86, "PathNameCS", -1,
			createSerializationRules(
				10	/* PathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[87] = createParserRuleValue(87, "PatternExpCS", -1,
			createSerializationRules(
				51	/* PatternExpCS-0: (PatternExpCS::patternVariableName=UnrestrictedName)[V0:?] ':' PatternExpCS::ownedPatternType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* patternVariableName=UnrestrictedName? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPatternType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[88] = createParserRuleValue(88, "PrefixedLetExpCS", 32 /* LetExpCS|PrefixedLetExpCS */,
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
		grammarRuleValues[89] = createParserRuleValue(89, "PrefixedPrimaryExpCS", 75 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[90] = createParserRuleValue(90, "PrimaryExpCS", 74 /* BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[91] = createParserRuleValue(91, "PrimitiveLiteralExpCS", 73 /* BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
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
		grammarRuleValues[92] = createParserRuleValue(92, "PrimitiveTypeCS", -1,
			createSerializationRules(
				54	/* PrimitiveTypeCS-0: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier */
			),
			(0 << 16) | 7	/* name=PrimitiveTypeIdentifier : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[93] = new DataTypeRuleValue(93, "PrimitiveTypeIdentifier");
		grammarRuleValues[94] = new DataTypeRuleValue(94, "QVTbaseUnrestrictedName");
		grammarRuleValues[95] = new DataTypeRuleValue(95, "QVTimperativeUnrestrictedName");
		grammarRuleValues[96] = createParserRuleValue(96, "QualifiedPackageCS", -1,
			createSerializationRules(
				154	/* QualifiedPackageCS-0: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] ';' */,
				155	/* QualifiedPackageCS-1: 'package' (QualifiedPackageCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnrestrictedName (':' PackageCS::nsPrefix=UnrestrictedName)[V1:?] ('=' PackageCS::nsURI=URI)[V2:?] '{' (PackageCS::ownedClasses+=ClassCS|TransformationCS)[V3:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V4:*] '}' */
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
		grammarRuleValues[97] = createParserRuleValue(97, "QueryCS", -1,
			createSerializationRules(
				156	/* QueryCS-0: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS ';' */,
				157	/* QueryCS-1: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS 'implementedby' JavaImplementationCS::implementation=SINGLE_QUOTED_STRING ';' */,
				158	/* QueryCS-2: (QueryCS::isTransient?='transient')[V0:?] 'query' NamedElementCS::name=UnrestrictedName '(' (QueryCS::ownedParameters+=ParamDeclarationCS (',' QueryCS::ownedParameters+=ParamDeclarationCS)[V2:*])[V1:?] ')' ':' TypedElementCS::ownedType=TypeExpCS '{' QueryCS::ownedExpression=ExpCS '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isTransient?="transient"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "query" : [value] | [soft-space, value, soft-space] */,
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
		grammarRuleValues[98] = createParserRuleValue(98, "ReferenceCS", -1,
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
		grammarRuleValues[99] = createParserRuleValue(99, "RoundBracketedClauseCS", -1,
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
		grammarRuleValues[100] = new DataTypeRuleValue(100, "SIGNED");
		grammarRuleValues[101] = new TerminalRuleValue(101, "SIMPLE_ID");
		grammarRuleValues[102] = new TerminalRuleValue(102, "SINGLE_QUOTED_STRING");
		grammarRuleValues[103] = new TerminalRuleValue(103, "SL_COMMENT");
		grammarRuleValues[104] = createParserRuleValue(104, "ScopeNameCS", -1,
			createSerializationRules(
				159	/* ScopeNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS '::' (PathNameCS::ownedPathElements+=NextPathElementCS '::')[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */
		);
		grammarRuleValues[105] = createParserRuleValue(105, "SelfExpCS", -1,
			createSerializationRules(
				56	/* SelfExpCS-0: 'self' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {SelfExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "self" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[106] = createParserRuleValue(106, "SetStatementCS", -1,
			createSerializationRules(
				160	/* SetStatementCS-0: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (SetStatementCS::isNotify?='notify')[V2:?] 'set' SetStatementCS::referredVariable=UnrestrictedName '.' SetStatementCS::referredProperty=UnrestrictedName ':=' SetStatementCS::ownedExpression=ExpCS ';' */,
				161	/* SetStatementCS-1: ('observe' ObservableStatementCS::observedProperties+=PathNameCS (',' ObservableStatementCS::observedProperties+=PathNameCS)[V1:*])[V0:?] (SetStatementCS::isNotify?='notify')[V2:?] 'set' SetStatementCS::referredVariable=UnrestrictedName '.' SetStatementCS::referredProperty=UnrestrictedName SetStatementCS::isPartial?='+=' SetStatementCS::ownedExpression=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* "observe" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* observedProperties+=PathNameCS : [value] | [value] */,
			(0 << 16) | 7	/* isNotify?="notify"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "set" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredVariable=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "." : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredProperty=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Alternatives : [value] | [value] */,
			(0 << 16) | 7	/* ":=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* isPartial?="+=" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[107] = createParserRuleValue(107, "ShadowPartCS", -1,
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
		grammarRuleValues[108] = createParserRuleValue(108, "SimpleParameterBindingCS", -1,
			createSerializationRules(
				162	/* SimpleParameterBindingCS-0: (SimpleParameterBindingCS::isCheck?='check')[V0:?] SimpleParameterBindingCS::referredVariable=UnrestrictedName 'uses' SimpleParameterBindingCS::ownedValue=ExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* isCheck?="check"? : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredVariable=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* "uses" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedValue=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[109] = createParserRuleValue(109, "SimpleParameterCS", -1,
			createSerializationRules(
				163	/* SimpleParameterCS-0: 'in' ':' SimpleParameterCS::referredTypedModel=UnrestrictedName NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "in" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* referredTypedModel=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[110] = createParserRuleValue(110, "SimplePathNameCS", -1,
			createSerializationRules(
				59	/* SimplePathNameCS-0: PathNameCS::ownedPathElements+=FirstPathElementCS */
			),
			(0 << 16) | 0	/* ownedPathElements+=FirstPathElementCS : [value] | [value] */
		);
		grammarRuleValues[111] = createParserRuleValue(111, "SimpleTargetElementCS", -1,
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
		grammarRuleValues[112] = createParserRuleValue(112, "SpecificationCS", -1,
			createSerializationRules(
				124	/* SpecificationCS-0: ExpSpecificationCS::ownedExpression=ExpCS */,
				125	/* SpecificationCS-1: SpecificationCS::exprString=UNQUOTED_STRING */
			),
			(0 << 16) | 2	/* Alternatives : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedExpression=ExpCS : [value] | [value] */,
			(0 << 16) | 7	/* exprString=UNQUOTED_STRING : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[113] = createParserRuleValue(113, "SpeculateStatementCS", -1,
			createSerializationRules(
				164	/* SpeculateStatementCS-0: 'speculate' SpeculateStatementCS::ownedConditions+=ExpCS (',' SpeculateStatementCS::ownedConditions+=ExpCS)[V0:*] ';' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "speculate" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedConditions+=ExpCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 6	/* "," : [value] | [no-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedConditions+=ExpCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */
		);
		grammarRuleValues[114] = createParserRuleValue(114, "SquareBracketedClauseCS", -1,
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
		grammarRuleValues[115] = new DataTypeRuleValue(115, "StringLiteral");
		grammarRuleValues[116] = createParserRuleValue(116, "StringLiteralExpCS", -1,
			createSerializationRules(
				61	/* StringLiteralExpCS-0: (StringLiteralExpCS::segments+=StringLiteral)[V0:+] */
			),
			(0 << 16) | 2	/* segments+=StringLiteral+ : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[117] = createParserRuleValue(117, "StructuralFeatureCS", 50 /* AttributeCS|ReferenceCS|StructuralFeatureCS */,
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
		grammarRuleValues[118] = createParserRuleValue(118, "StructuredClassCS", -1,
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
		grammarRuleValues[119] = createParserRuleValue(119, "TargetCS", -1,
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
		grammarRuleValues[120] = createParserRuleValue(120, "TemplateBindingCS", -1,
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
		grammarRuleValues[121] = createParserRuleValue(121, "TemplateParameterSubstitutionCS", -1,
			createSerializationRules(
				12	/* TemplateParameterSubstitutionCS-0: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS */
			),
			(0 << 16) | 2	/* ownedActualParameter=TypeRefCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[122] = createParserRuleValue(122, "TemplateSignatureCS", -1,
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
		grammarRuleValues[123] = createParserRuleValue(123, "TopLevelCS", -1,
			createSerializationRules(
				165	/* TopLevelCS-0: (RootCS::ownedImports+=ImportCS)[V0:*] (PackageOwnerCS::ownedPackages+=QualifiedPackageCS)[V1:*] (TopLevelCS::ownedTransformations+=TransformationCS)[V2:*] */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* ownedImports+=ImportCS* : [value] | [value] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedPackages+=QualifiedPackageCS : [value] | [value] */,
			(0 << 16) | 0	/* ownedTransformations+=TransformationCS : [value] | [value] */
		);
		grammarRuleValues[124] = createParserRuleValue(124, "TransformationCS", -1,
			createSerializationRules(
				166	/* TransformationCS-0: 'transformation' (AbstractTransformationCS::ownedPathName=ScopeNameCS)[V0:?] NamedElementCS::name=UnreservedName (':' TransformationCS::ownedContextType=TypeExpCS)[V1:?] '{' (TransformationCS::ownedDirections+=DirectionCS ';')[V2:*] (TransformationCS::ownedMappings+=EntryPointCS|MappingCS)[V3:*] (TransformationCS::ownedQueries+=QueryCS)[V4:*] '}' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* "transformation" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedPathName=ScopeNameCS? : [value] | [value] */,
			(0 << 16) | 7	/* name=UnreservedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* Group? : [value] | [value] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedContextType=TypeExpCS : [value] | [value] */,
			(0 << 16) | 9	/* "{" : [value] | [soft-space, value, push, soft-new-line] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 0	/* ownedDirections+=DirectionCS : [value] | [value] */,
			(0 << 16) | 5	/* ";" : [value] | [no-space, value, soft-new-line] */,
			(0 << 16) | 0	/* Alternatives* : [value] | [value] */,
			(0 << 16) | 0	/* ownedMappings+=(EntryPointCS|MappingCS) : [value] | [value] */,
			(0 << 16) | 0	/* ownedQueries+=QueryCS : [value] | [value] */,
			(0 << 16) | 8	/* "}" : [value] | [pop, soft-space, value, soft-new-line] */
		);
		grammarRuleValues[125] = createParserRuleValue(125, "TupleLiteralExpCS", -1,
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
		grammarRuleValues[126] = createParserRuleValue(126, "TupleLiteralPartCS", -1,
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
		grammarRuleValues[127] = createParserRuleValue(127, "TuplePartCS", -1,
			createSerializationRules(
				64	/* TuplePartCS-0: NamedElementCS::name=UnrestrictedName ':' TypedElementCS::ownedType=TypeExpCS */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 7	/* name=UnrestrictedName : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 7	/* ":" : [value] | [soft-space, value, soft-space] */,
			(0 << 16) | 0	/* ownedType=TypeExpCS : [value] | [value] */
		);
		grammarRuleValues[128] = createParserRuleValue(128, "TupleTypeCS", -1,
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
		grammarRuleValues[129] = createParserRuleValue(129, "TypeExpCS", -1,
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
		grammarRuleValues[130] = createParserRuleValue(130, "TypeExpWithoutMultiplicityCS", 64 /* CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
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
		grammarRuleValues[131] = createParserRuleValue(131, "TypeLiteralCS", 62 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS */,
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
		grammarRuleValues[132] = createParserRuleValue(132, "TypeLiteralExpCS", -1,
			createSerializationRules(
				72	/* TypeLiteralExpCS-0: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS */
			),
			(0 << 16) | 2	/* ownedType=TypeLiteralWithMultiplicityCS : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */
		);
		grammarRuleValues[133] = createParserRuleValue(133, "TypeLiteralWithMultiplicityCS", -1,
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
		grammarRuleValues[134] = createParserRuleValue(134, "TypeNameExpCS", -1,
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
		grammarRuleValues[135] = createParserRuleValue(135, "TypeParameterCS", -1,
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
		grammarRuleValues[136] = createParserRuleValue(136, "TypeRefCS", 80 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
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
		grammarRuleValues[137] = createParserRuleValue(137, "TypedMultiplicityRefCS", -1,
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
		grammarRuleValues[138] = createParserRuleValue(138, "TypedRefCS", 69 /* CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
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
		grammarRuleValues[139] = createParserRuleValue(139, "TypedTypeRefCS", -1,
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
		grammarRuleValues[140] = new TerminalRuleValue(140, "UNQUOTED_STRING");
		grammarRuleValues[141] = new DataTypeRuleValue(141, "UPPER");
		grammarRuleValues[142] = new DataTypeRuleValue(142, "URI");
		grammarRuleValues[143] = createParserRuleValue(143, "URIFirstPathElementCS", -1,
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
		grammarRuleValues[144] = createParserRuleValue(144, "URIPathNameCS", -1,
			createSerializationRules(
				80	/* URIPathNameCS-0: PathNameCS::ownedPathElements+=URIFirstPathElementCS ('::' PathNameCS::ownedPathElements+=NextPathElementCS)[V0:*] */
			),
			(0 << 16) | 0	/* Group : [value] | [value] */,
			(0 << 16) | 0	/* ownedPathElements+=URIFirstPathElementCS : [value] | [value] */,
			(0 << 16) | 0	/* Group* : [value] | [value] */,
			(0 << 16) | 4	/* "::" : [value] | [no-space, value, no-space] */,
			(0 << 16) | 0	/* ownedPathElements+=NextPathElementCS : [value] | [value] */
		);
		grammarRuleValues[145] = new DataTypeRuleValue(145, "UnaryOperatorName");
		grammarRuleValues[146] = createParserRuleValue(146, "UnlimitedNaturalLiteralExpCS", -1,
			createSerializationRules(
				81	/* UnlimitedNaturalLiteralExpCS-0: '*' */
			),
			(0 << 16) | 2	/* Group : [value] | [org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport, value] */,
			(0 << 16) | 0	/* {UnlimitedNaturalLiteralExpCS} : [value] | [value] */,
			(0 << 16) | 7	/* "*" : [value] | [soft-space, value, soft-space] */
		);
		grammarRuleValues[147] = new DataTypeRuleValue(147, "UnreservedName");
		grammarRuleValues[148] = new DataTypeRuleValue(148, "UnrestrictedName");
		grammarRuleValues[149] = new TerminalRuleValue(149, "WS");
		grammarRuleValues[150] = createParserRuleValue(150, "WildcardTypeRefCS", -1,
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
		// 0: CoIteratorVariableCS
		grammarRuleVectors[0] = new GrammarRuleVector(0x400L);
		// 1: CollectionLiteralPartCS
		grammarRuleVectors[1] = new GrammarRuleVector(0x1000L);
		// 2: CollectionTypeCS
		grammarRuleVectors[2] = new GrammarRuleVector(0x4000L);
		// 3: ControlStatementCS
		grammarRuleVectors[3] = new GrammarRuleVector(0x40000L);
		// 4: CurlyBracketedClauseCS
		grammarRuleVectors[4] = new GrammarRuleVector(0x80000L);
		// 5: DirectionCS
		grammarRuleVectors[5] = new GrammarRuleVector(0x800000L);
		// 6: ElseIfThenExpCS
		grammarRuleVectors[6] = new GrammarRuleVector(0x4000000L);
		// 7: EnumerationLiteralCS
		grammarRuleVectors[7] = new GrammarRuleVector(0x20000000L);
		// 8: ExpCS
		grammarRuleVectors[8] = new GrammarRuleVector(0x2000000000L);
		// 9: FirstPathElementCS
		grammarRuleVectors[9] = new GrammarRuleVector(0x4000000000L);
		// 10: CommitStatementCS|ControlStatementCS|GuardStatementCS
		grammarRuleVectors[10] = new GrammarRuleVector(0x20000050000L);
		// 11: ImportCS
		grammarRuleVectors[11] = new GrammarRuleVector(0x400000000000L);
		// 12: LetVariableCS
		grammarRuleVectors[12] = new GrammarRuleVector(0x20000000000000L);
		// 13: MapLiteralPartCS
		grammarRuleVectors[13] = new GrammarRuleVector(0x400000000000000L);
		// 14: MapTypeCS
		grammarRuleVectors[14] = new GrammarRuleVector(0x800000000000000L);
		// 15: EntryPointCS|MappingCS
		grammarRuleVectors[15] = new GrammarRuleVector(0x1000000008000000L);
		// 16: MappingIteratorCS
		grammarRuleVectors[16] = new GrammarRuleVector(0x4000000000000000L);
		// 17: AddStatementCS|ControlStatementCS|MappingCallCS|MappingLoopCS
		grammarRuleVectors[17] = new GrammarRuleVector(0xa000000000040002L);
		// 18: MappingParameterBindingCS
		grammarRuleVectors[18] = new GrammarRuleVector(0x0L,0x1L);
		// 19: MappingParameterCS
		grammarRuleVectors[19] = new GrammarRuleVector(0x0L,0x2L);
		// 20: MultiplicityCS
		grammarRuleVectors[20] = new GrammarRuleVector(0x0L,0x10L);
		// 21: NavigatingArgExpCS
		grammarRuleVectors[21] = new GrammarRuleVector(0x0L,0x200L);
		// 22: NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[22] = new GrammarRuleVector(0x0L,0x1c00L);
		// 23: NavigatingArgCS|NavigatingBarArgCS|NavigatingCommaArgCS|NavigatingSemiArgCS
		grammarRuleVectors[23] = new GrammarRuleVector(0x0L,0x1d00L);
		// 24: FirstPathElementCS|NextPathElementCS
		grammarRuleVectors[24] = new GrammarRuleVector(0x4000000000L,0x10000L);
		// 25: OperationCS
		grammarRuleVectors[25] = new GrammarRuleVector(0x0L,0x80000L);
		// 26: ParamDeclarationCS
		grammarRuleVectors[26] = new GrammarRuleVector(0x0L,0x100000L);
		// 27: ParameterCS
		grammarRuleVectors[27] = new GrammarRuleVector(0x0L,0x200000L);
		// 28: PathNameCS
		grammarRuleVectors[28] = new GrammarRuleVector(0x0L,0x400000L);
		// 29: PatternExpCS
		grammarRuleVectors[29] = new GrammarRuleVector(0x0L,0x800000L);
		// 30: ExpCS|PatternExpCS
		grammarRuleVectors[30] = new GrammarRuleVector(0x2000000000L,0x800000L);
		// 31: PrefixedLetExpCS
		grammarRuleVectors[31] = new GrammarRuleVector(0x0L,0x1000000L);
		// 32: LetExpCS|PrefixedLetExpCS
		grammarRuleVectors[32] = new GrammarRuleVector(0x10000000000000L,0x1000000L);
		// 33: PrefixedPrimaryExpCS
		grammarRuleVectors[33] = new GrammarRuleVector(0x0L,0x2000000L);
		// 34: QualifiedPackageCS
		grammarRuleVectors[34] = new GrammarRuleVector(0x0L,0x100000000L);
		// 35: QueryCS
		grammarRuleVectors[35] = new GrammarRuleVector(0x0L,0x200000000L);
		// 36: RoundBracketedClauseCS
		grammarRuleVectors[36] = new GrammarRuleVector(0x0L,0x800000000L);
		// 37: ScopeNameCS
		grammarRuleVectors[37] = new GrammarRuleVector(0x0L,0x10000000000L);
		// 38: CommitStatementCS|NewStatementCS|SetStatementCS
		grammarRuleVectors[38] = new GrammarRuleVector(0x10000L,0x40000008000L);
		// 39: ShadowPartCS
		grammarRuleVectors[39] = new GrammarRuleVector(0x0L,0x80000000000L);
		// 40: AppendParameterBindingCS|GuardParameterBindingCS|LoopParameterBindingCS|MappingParameterBindingCS|SimpleParameterBindingCS
		grammarRuleVectors[40] = new GrammarRuleVector(0x40008000000004L,0x100000000001L);
		// 41: AppendParameterCS|GuardParameterCS|MappingParameterCS|SimpleParameterCS
		grammarRuleVectors[41] = new GrammarRuleVector(0x10000000008L,0x200000000002L);
		// 42: SimpleTargetElementCS
		grammarRuleVectors[42] = new GrammarRuleVector(0x0L,0x800000000000L);
		// 43: CompoundTargetElementCS|SimpleTargetElementCS
		grammarRuleVectors[43] = new GrammarRuleVector(0x20000L,0x800000000000L);
		// 44: SpecificationCS
		grammarRuleVectors[44] = new GrammarRuleVector(0x0L,0x1000000000000L);
		// 45: BufferStatementCS|CheckStatementCS|DeclareStatementCS|GuardStatementCS|SpeculateStatementCS
		grammarRuleVectors[45] = new GrammarRuleVector(0x20000400180L,0x2000000000000L);
		// 46: AddStatementCS|BufferStatementCS|CheckStatementCS|CommitStatementCS|ControlStatementCS|DeclareStatementCS|GuardStatementCS|MappingCallCS|MappingLoopCS|NewStatementCS|SetStatementCS|SpeculateStatementCS
		grammarRuleVectors[46] = new GrammarRuleVector(0xa000020000450182L,0x2040000008000L);
		// 47: SquareBracketedClauseCS
		grammarRuleVectors[47] = new GrammarRuleVector(0x0L,0x4000000000000L);
		// 48: StringLiteralExpCS
		grammarRuleVectors[48] = new GrammarRuleVector(0x0L,0x10000000000000L);
		// 49: StructuralFeatureCS
		grammarRuleVectors[49] = new GrammarRuleVector(0x0L,0x20000000000000L);
		// 50: AttributeCS|ReferenceCS|StructuralFeatureCS
		grammarRuleVectors[50] = new GrammarRuleVector(0x10L,0x20000400000000L);
		// 51: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS
		grammarRuleVectors[51] = new GrammarRuleVector(0x10200200L,0x40000000000000L);
		// 52: TemplateBindingCS
		grammarRuleVectors[52] = new GrammarRuleVector(0x0L,0x100000000000000L);
		// 53: TemplateParameterSubstitutionCS
		grammarRuleVectors[53] = new GrammarRuleVector(0x0L,0x200000000000000L);
		// 54: TemplateSignatureCS
		grammarRuleVectors[54] = new GrammarRuleVector(0x0L,0x400000000000000L);
		// 55: TransformationCS
		grammarRuleVectors[55] = new GrammarRuleVector(0x0L,0x1000000000000000L);
		// 56: ClassCS|TransformationCS
		grammarRuleVectors[56] = new GrammarRuleVector(0x200L,0x1000000000000000L);
		// 57: ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS
		grammarRuleVectors[57] = new GrammarRuleVector(0x10200200L,0x1040000000000000L);
		// 58: TupleLiteralPartCS
		grammarRuleVectors[58] = new GrammarRuleVector(0x0L,0x4000000000000000L);
		// 59: TuplePartCS
		grammarRuleVectors[59] = new GrammarRuleVector(0x0L,0x8000000000000000L);
		// 60: TypeExpCS
		grammarRuleVectors[60] = new GrammarRuleVector(0x0L,0x0L,0x2L);
		// 61: TypeExpWithoutMultiplicityCS
		grammarRuleVectors[61] = new GrammarRuleVector(0x0L,0x0L,0x4L);
		// 62: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS
		grammarRuleVectors[62] = new GrammarRuleVector(0x800000000004000L,0x10000000L,0x9L);
		// 63: TypeLiteralWithMultiplicityCS
		grammarRuleVectors[63] = new GrammarRuleVector(0x0L,0x0L,0x20L);
		// 64: CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS
		grammarRuleVectors[64] = new GrammarRuleVector(0x800000000006000L,0x10000000L,0x4dL);
		// 65: TypeParameterCS
		grammarRuleVectors[65] = new GrammarRuleVector(0x0L,0x0L,0x80L);
		// 66: TypeRefCS
		grammarRuleVectors[66] = new GrammarRuleVector(0x0L,0x0L,0x100L);
		// 67: TypedMultiplicityRefCS
		grammarRuleVectors[67] = new GrammarRuleVector(0x0L,0x0L,0x200L);
		// 68: TypedRefCS
		grammarRuleVectors[68] = new GrammarRuleVector(0x0L,0x0L,0x400L);
		// 69: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS
		grammarRuleVectors[69] = new GrammarRuleVector(0x800000000004000L,0x10000000L,0xc09L);
		// 70: NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[70] = new GrammarRuleVector(0x0L,0x10000L,0x8000L);
		// 71: FirstPathElementCS|NextPathElementCS|URIFirstPathElementCS
		grammarRuleVectors[71] = new GrammarRuleVector(0x4000000000L,0x10000L,0x8000L);
		// 72: URIPathNameCS
		grammarRuleVectors[72] = new GrammarRuleVector(0x0L,0x0L,0x10000L);
		// 73: BooleanLiteralExpCS|InvalidLiteralExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimitiveLiteralExpCS|StringLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[73] = new GrammarRuleVector(0x1000000000040L,0x10000008060000L,0x40000L);
		// 74: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[74] = new GrammarRuleVector(0x209200000000840L,0x201002000c064080L,0x40010L);
		// 75: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[75] = new GrammarRuleVector(0x209200000000840L,0x201002000e064080L,0x40010L);
		// 76: BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[76] = new GrammarRuleVector(0x219200000000840L,0x201002000f064080L,0x40010L);
		// 77: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[77] = new GrammarRuleVector(0x219202000000840L,0x201002000f064080L,0x40010L);
		// 78: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[78] = new GrammarRuleVector(0x219202000000840L,0x201002000f064280L,0x40010L);
		// 79: BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS
		grammarRuleVectors[79] = new GrammarRuleVector(0x219202000000840L,0x201002000f864080L,0x40010L);
		// 80: CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS
		grammarRuleVectors[80] = new GrammarRuleVector(0x800000000004000L,0x10000000L,0x400d09L);
	}

	/**
	 * Initialize steps for the matching process.
	 */
	private void initMatchSteps() {
		// 0: assert (|AbstractNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[0] = createMatchStep_Assert(203);
		// 1: assert (|AddStatementCS::ownedExpression| - 1) == 0
		serializationMatchSteps[1] = createMatchStep_Assert(204);
		// 2: assert (|AddStatementCS::targetVariable| - 1) == 0
		serializationMatchSteps[2] = createMatchStep_Assert(205);
		// 3: assert (|AppendParameterBindingCS::referredVariable| - 1) == 0
		serializationMatchSteps[3] = createMatchStep_Assert(206);
		// 4: assert (|AppendParameterBindingCS::value| - 1) == 0
		serializationMatchSteps[4] = createMatchStep_Assert(207);
		// 5: assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0
		serializationMatchSteps[5] = createMatchStep_Assert(208);
		// 6: assert (|CheckStatementCS::ownedCondition| - 1) == 0
		serializationMatchSteps[6] = createMatchStep_Assert(209);
		// 7: assert (|CollectionLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[7] = createMatchStep_Assert(212);
		// 8: assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0
		serializationMatchSteps[8] = createMatchStep_Assert(213);
		// 9: assert (|CollectionPatternCS::ownedType| - 1) == 0
		serializationMatchSteps[9] = createMatchStep_Assert(215);
		// 10: assert (|CollectionTypeCS::name| - 1) == 0
		serializationMatchSteps[10] = createMatchStep_Assert(216);
		// 11: assert (|ContextCS::ownedExpression| - 1) == 0
		serializationMatchSteps[11] = createMatchStep_Assert(217);
		// 12: assert (|DeclareStatementCS::ownedExpression| - 1) == 0
		serializationMatchSteps[12] = createMatchStep_Assert(220);
		// 13: assert (|ExpSpecificationCS::ownedExpression| - 1) == 0
		serializationMatchSteps[13] = createMatchStep_Assert(223);
		// 14: assert (|GuardParameterBindingCS::referredVariable| - 1) == 0
		serializationMatchSteps[14] = createMatchStep_Assert(224);
		// 15: assert (|GuardParameterBindingCS::value| - 1) == 0
		serializationMatchSteps[15] = createMatchStep_Assert(225);
		// 16: assert (|GuardParameterCS::referredTypedModel| - 1) == 0
		serializationMatchSteps[16] = createMatchStep_Assert(226);
		// 17: assert (|IfExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[17] = createMatchStep_Assert(227);
		// 18: assert (|IfExpCS::ownedElseExpression| - 1) == 0
		serializationMatchSteps[18] = createMatchStep_Assert(228);
		// 19: assert (|IfExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[19] = createMatchStep_Assert(229);
		// 20: assert (|IfThenExpCS::ownedCondition| - 1) == 0
		serializationMatchSteps[20] = createMatchStep_Assert(230);
		// 21: assert (|IfThenExpCS::ownedThenExpression| - 1) == 0
		serializationMatchSteps[21] = createMatchStep_Assert(231);
		// 22: assert (|ImportCS::ownedPathName| - 1) == 0
		serializationMatchSteps[22] = createMatchStep_Assert(232);
		// 23: assert (|InfixExpCS::ownedLeft| - 1) == 0
		serializationMatchSteps[23] = createMatchStep_Assert(233);
		// 24: assert (|JavaImplementationCS::implementation| - 1) == 0
		serializationMatchSteps[24] = createMatchStep_Assert(234);
		// 25: assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0
		serializationMatchSteps[25] = createMatchStep_Assert(235);
		// 26: assert (|LetExpCS::ownedInExpression| - 1) == 0
		serializationMatchSteps[26] = createMatchStep_Assert(236);
		// 27: assert (|LoopParameterBindingCS::referredVariable| - 1) == 0
		serializationMatchSteps[27] = createMatchStep_Assert(238);
		// 28: assert (|LoopParameterBindingCS::value| - 1) == 0
		serializationMatchSteps[28] = createMatchStep_Assert(239);
		// 29: assert (|MapLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[29] = createMatchStep_Assert(242);
		// 30: assert (|MapLiteralPartCS::ownedKey| - 1) == 0
		serializationMatchSteps[30] = createMatchStep_Assert(243);
		// 31: assert (|MapLiteralPartCS::ownedValue| - 1) == 0
		serializationMatchSteps[31] = createMatchStep_Assert(244);
		// 32: assert (|MapTypeCS::name.'Map'| - 1) == 0
		serializationMatchSteps[32] = createMatchStep_Assert(245);
		// 33: assert (|MapTypeCS::ownedKeyType| - V0) == 0
		serializationMatchSteps[33] = createMatchStep_Assert(246);
		// 34: assert (|MappingCallCS::isInstall.'install'| - 1) == 0
		serializationMatchSteps[34] = createMatchStep_Assert(247);
		// 35: assert (|MappingCallCS::isInvoke.'invoke'| - 1) == 0
		serializationMatchSteps[35] = createMatchStep_Assert(248);
		// 36: assert (|MappingCallCS::ownedPathName| - 1) == 0
		serializationMatchSteps[36] = createMatchStep_Assert(249);
		// 37: assert (|MappingLoopCS::ownedInExpression| - 1) == 0
		serializationMatchSteps[37] = createMatchStep_Assert(250);
		// 38: assert (|MappingLoopCS::ownedIterator| - 1) == 0
		serializationMatchSteps[38] = createMatchStep_Assert(251);
		// 39: assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0
		serializationMatchSteps[39] = createMatchStep_Assert(252);
		// 40: assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0
		serializationMatchSteps[40] = createMatchStep_Assert(253);
		// 41: assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0
		serializationMatchSteps[41] = createMatchStep_Assert(254);
		// 42: assert (|NamedElementCS::name| - 1) == 0
		serializationMatchSteps[42] = createMatchStep_Assert(255);
		// 43: assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0
		serializationMatchSteps[43] = createMatchStep_Assert(256);
		// 44: assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[44] = createMatchStep_Assert(257);
		// 45: assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0
		serializationMatchSteps[45] = createMatchStep_Assert(258);
		// 46: assert (|NavigatingArgCS::ownedType| - 1) == 0
		serializationMatchSteps[46] = createMatchStep_Assert(259);
		// 47: assert (|NavigatingArgCS::prefix.','| - 1) == 0
		serializationMatchSteps[47] = createMatchStep_Assert(260);
		// 48: assert (|NavigatingArgCS::prefix.';'| - 1) == 0
		serializationMatchSteps[48] = createMatchStep_Assert(261);
		// 49: assert (|NavigatingArgCS::prefix.'|'| - 1) == 0
		serializationMatchSteps[49] = createMatchStep_Assert(262);
		// 50: assert (|NestedExpCS::ownedExpression| - 1) == 0
		serializationMatchSteps[50] = createMatchStep_Assert(263);
		// 51: assert (|NewStatementCS::referredTypedModel| - 1) == 0
		serializationMatchSteps[51] = createMatchStep_Assert(264);
		// 52: assert (|NumberLiteralExpCS::symbol| - 1) == 0
		serializationMatchSteps[52] = createMatchStep_Assert(265);
		// 53: assert (|OperatorExpCS::ownedRight| - 1) == 0
		serializationMatchSteps[53] = createMatchStep_Assert(273);
		// 54: assert (|PathElementCS::referredElement| - 1) == 0
		serializationMatchSteps[54] = createMatchStep_Assert(274);
		// 55: assert (|PathNameCS::ownedPathElements| - 1) == 0
		serializationMatchSteps[55] = createMatchStep_Assert(275);
		// 56: assert (|PatternExpCS::ownedPatternType| - 1) == 0
		serializationMatchSteps[56] = createMatchStep_Assert(276);
		// 57: assert (|PrimitiveTypeRefCS::name| - 1) == 0
		serializationMatchSteps[57] = createMatchStep_Assert(277);
		// 58: assert (|QueryCS::ownedExpression| - 1) == 0
		serializationMatchSteps[58] = createMatchStep_Assert(278);
		// 59: assert (|SetStatementCS::isPartial.'+='| - 1) == 0
		serializationMatchSteps[59] = createMatchStep_Assert(281);
		// 60: assert (|SetStatementCS::ownedExpression| - 1) == 0
		serializationMatchSteps[60] = createMatchStep_Assert(282);
		// 61: assert (|SetStatementCS::referredProperty| - 1) == 0
		serializationMatchSteps[61] = createMatchStep_Assert(283);
		// 62: assert (|SetStatementCS::referredVariable| - 1) == 0
		serializationMatchSteps[62] = createMatchStep_Assert(284);
		// 63: assert (|ShadowPartCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[63] = createMatchStep_Assert(285);
		// 64: assert (|ShadowPartCS::referredProperty| - 1) == 0
		serializationMatchSteps[64] = createMatchStep_Assert(286);
		// 65: assert (|SimpleParameterBindingCS::ownedValue| - 1) == 0
		serializationMatchSteps[65] = createMatchStep_Assert(287);
		// 66: assert (|SimpleParameterBindingCS::referredVariable| - 1) == 0
		serializationMatchSteps[66] = createMatchStep_Assert(288);
		// 67: assert (|SimpleParameterCS::referredTypedModel| - 1) == 0
		serializationMatchSteps[67] = createMatchStep_Assert(289);
		// 68: assert (|SimpleTargetElementCS::input.'input'| - 1) == 0
		serializationMatchSteps[68] = createMatchStep_Assert(290);
		// 69: assert (|SimpleTargetElementCS::output.'output'| - 1) == 0
		serializationMatchSteps[69] = createMatchStep_Assert(293);
		// 70: assert (|SimpleTargetElementCS::typedModel| - 1) == 0
		serializationMatchSteps[70] = createMatchStep_Assert(294);
		// 71: assert (|SimpleTargetElementCS::via.'via'| - 1) == 0
		serializationMatchSteps[71] = createMatchStep_Assert(295);
		// 72: assert (|SpecificationCS::exprString| - 1) == 0
		serializationMatchSteps[72] = createMatchStep_Assert(296);
		// 73: assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0
		serializationMatchSteps[73] = createMatchStep_Assert(304);
		// 74: assert (|TupleTypeCS::name.'Tuple'| - 1) == 0
		serializationMatchSteps[74] = createMatchStep_Assert(307);
		// 75: assert (|TypeLiteralExpCS::ownedType| - 1) == 0
		serializationMatchSteps[75] = createMatchStep_Assert(310);
		// 76: assert (|TypeNameExpCS::ownedPathName| - 1) == 0
		serializationMatchSteps[76] = createMatchStep_Assert(311);
		// 77: assert (|TypedElementCS::ownedType| - 1) == 0
		serializationMatchSteps[77] = createMatchStep_Assert(314);
		// 78: assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0
		serializationMatchSteps[78] = createMatchStep_Assert(319);
		// 79: assert (|TypedElementCS::qualifiers.'static'| - 1) == 0
		serializationMatchSteps[79] = createMatchStep_Assert(320);
		// 80: assert (|TypedTypeRefCS::ownedPathName| - 1) == 0
		serializationMatchSteps[80] = createMatchStep_Assert(321);
		// 81: assert (|VariableCS::ownedInitExpression| - 1) == 0
		serializationMatchSteps[81] = createMatchStep_Assert(322);
		// 82: assert |AbstractTransformationCS::ownedTargets| == 0
		serializationMatchSteps[82] = createMatchStep_Assert(9);
		// 83: assert |ClassCS::instanceClassName| == 0
		serializationMatchSteps[83] = createMatchStep_Assert(20);
		// 84: assert |ClassCS::ownedConstraints| == 0
		serializationMatchSteps[84] = createMatchStep_Assert(21);
		// 85: assert |CollectionLiteralPartCS::ownedLastExpression| == 0
		serializationMatchSteps[85] = createMatchStep_Assert(25);
		// 86: assert |CollectionPatternCS::ownedPatternGuard| == 0
		serializationMatchSteps[86] = createMatchStep_Assert(27);
		// 87: assert |CurlyBracketedClauseCS::value| == 0
		serializationMatchSteps[87] = createMatchStep_Assert(36);
		// 88: assert |DataTypeCS::isSerializable| == 0
		serializationMatchSteps[88] = createMatchStep_Assert(39);
		// 89: assert |EnumerationCS::isSerializable| == 0
		serializationMatchSteps[89] = createMatchStep_Assert(44);
		// 90: assert |EnumerationCS::ownedLiterals| == 0
		serializationMatchSteps[90] = createMatchStep_Assert(45);
		// 91: assert |EnumerationLiteralCS::literal| == 0
		serializationMatchSteps[91] = createMatchStep_Assert(46);
		// 92: assert |ExpSpecificationCS::ownedExpression| == 0
		serializationMatchSteps[92] = createMatchStep_Assert(48);
		// 93: assert |IfExpCS::isImplicit| == 0
		serializationMatchSteps[93] = createMatchStep_Assert(54);
		// 94: assert |JavaImplementationCS::implementation| == 0
		serializationMatchSteps[94] = createMatchStep_Assert(64);
		// 95: assert |LetExpCS::isImplicit| == 0
		serializationMatchSteps[95] = createMatchStep_Assert(66);
		// 96: assert |MappingCallCS::isInstall| == 0
		serializationMatchSteps[96] = createMatchStep_Assert(81);
		// 97: assert |MappingCallCS::isInvoke| == 0
		serializationMatchSteps[97] = createMatchStep_Assert(83);
		// 98: assert |ModelElementCS::ownedAnnotations| == 0
		serializationMatchSteps[98] = createMatchStep_Assert(89);
		// 99: assert |MultiplicityCS::isNullFree| == 0
		serializationMatchSteps[99] = createMatchStep_Assert(93);
		// 100: assert |NamedElementCS::name| == 0
		serializationMatchSteps[100] = createMatchStep_Assert(95);
		// 101: assert |NavigatingArgCS::ownedCoIterator| == 0
		serializationMatchSteps[101] = createMatchStep_Assert(96);
		// 102: assert |NavigatingArgCS::ownedInitExpression| == 0
		serializationMatchSteps[102] = createMatchStep_Assert(97);
		// 103: assert |NavigatingArgCS::ownedNameExpression| == 0
		serializationMatchSteps[103] = createMatchStep_Assert(98);
		// 104: assert |NavigatingArgCS::ownedType| == 0
		serializationMatchSteps[104] = createMatchStep_Assert(99);
		// 105: assert |NavigatingArgCS::prefix| == 0
		serializationMatchSteps[105] = createMatchStep_Assert(103);
		// 106: assert |OperationCS::ownedBodyExpressions| == 0
		serializationMatchSteps[106] = createMatchStep_Assert(110);
		// 107: assert |OperationCS::ownedPostconditions| == 0
		serializationMatchSteps[107] = createMatchStep_Assert(113);
		// 108: assert |OperationCS::ownedPreconditions| == 0
		serializationMatchSteps[108] = createMatchStep_Assert(114);
		// 109: assert |PackageCS::ownedClasses| == 0
		serializationMatchSteps[109] = createMatchStep_Assert(118);
		// 110: assert |PackageOwnerCS::ownedPackages| == 0
		serializationMatchSteps[110] = createMatchStep_Assert(119);
		// 111: assert |QueryCS::ownedExpression| == 0
		serializationMatchSteps[111] = createMatchStep_Assert(127);
		// 112: assert |ReferenceCS::ownedImplicitOpposites| == 0
		serializationMatchSteps[112] = createMatchStep_Assert(129);
		// 113: assert |ReferenceCS::referredKeys| == 0
		serializationMatchSteps[113] = createMatchStep_Assert(130);
		// 114: assert |RootCS::ownedImports| == 0
		serializationMatchSteps[114] = createMatchStep_Assert(132);
		// 115: assert |SelfExpCS::name| == 0
		serializationMatchSteps[115] = createMatchStep_Assert(133);
		// 116: assert |SetStatementCS::isPartial| == 0
		serializationMatchSteps[116] = createMatchStep_Assert(136);
		// 117: assert |ShadowPartCS::referredProperty| == 0
		serializationMatchSteps[117] = createMatchStep_Assert(141);
		// 118: assert |SimpleTargetElementCS::input| == 0
		serializationMatchSteps[118] = createMatchStep_Assert(147);
		// 119: assert |SimpleTargetElementCS::output| == 0
		serializationMatchSteps[119] = createMatchStep_Assert(150);
		// 120: assert |SimpleTargetElementCS::via| == 0
		serializationMatchSteps[120] = createMatchStep_Assert(153);
		// 121: assert |SpecificationCS::exprString| == 0
		serializationMatchSteps[121] = createMatchStep_Assert(154);
		// 122: assert |StructuralFeatureCS::ownedDefaultExpressions| == 0
		serializationMatchSteps[122] = createMatchStep_Assert(159);
		// 123: assert |StructuredClassCS::ownedMetaclass| == 0
		serializationMatchSteps[123] = createMatchStep_Assert(162);
		// 124: assert |StructuredClassCS::ownedOperations| == 0
		serializationMatchSteps[124] = createMatchStep_Assert(163);
		// 125: assert |StructuredClassCS::ownedProperties| == 0
		serializationMatchSteps[125] = createMatchStep_Assert(164);
		// 126: assert |TemplateableElementCS::ownedSignature| == 0
		serializationMatchSteps[126] = createMatchStep_Assert(171);
		// 127: assert |TypeLiteralExpCS::ownedPathName| == 0
		serializationMatchSteps[127] = createMatchStep_Assert(180);
		// 128: assert |TypedElementCS::isOptional| == 0
		serializationMatchSteps[128] = createMatchStep_Assert(186);
		// 129: assert |TypedElementCS::qualifiers| == 0
		serializationMatchSteps[129] = createMatchStep_Assert(194);
		// 130: assert |TypedRefCS::ownedMultiplicity| == 0
		serializationMatchSteps[130] = createMatchStep_Assert(195);
		// 131: assert |TypedTypeRefCS::isTypeof| == 0
		serializationMatchSteps[131] = createMatchStep_Assert(196);
		// 132: assert |VariableCS::ownedInitExpression| == 0
		serializationMatchSteps[132] = createMatchStep_Assert(199);
		// 133: assert |WildcardTypeRefCS::ownedSuper| == 0
		serializationMatchSteps[133] = createMatchStep_Assert(202);
		// 134: assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[134] = createMatchStep_Assign(0, 211);
		// 135: assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchSteps[135] = createMatchStep_Assign(0, 219);
		// 136: assign V0 = (|LetExpCS::ownedVariables| - 1)
		serializationMatchSteps[136] = createMatchStep_Assign(0, 237);
		// 137: assign V0 = (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchSteps[137] = createMatchStep_Assign(0, 241);
		// 138: assign V0 = (|ObservableStatementCS::observedProperties| > 0)
		serializationMatchSteps[138] = createMatchStep_Assign(0, 267);
		// 139: assign V0 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[139] = createMatchStep_Assign(0, 292);
		// 140: assign V0 = (|SpeculateStatementCS::ownedConditions| - 1)
		serializationMatchSteps[140] = createMatchStep_Assign(0, 297);
		// 141: assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchSteps[141] = createMatchStep_Assign(0, 298);
		// 142: assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchSteps[142] = createMatchStep_Assign(0, 303);
		// 143: assign V0 = (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchSteps[143] = createMatchStep_Assign(0, 305);
		// 144: assign V0 = (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[144] = createMatchStep_Assign(0, 306);
		// 145: assign V0 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[145] = createMatchStep_Assign(0, 309);
		// 146: assign V0 = (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchSteps[146] = createMatchStep_Assign(0, 313);
		// 147: assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses|
		serializationMatchSteps[147] = createMatchStep_Assign(0, 7);
		// 148: assign V0 = |AbstractTransformationCS::ownedPathName|
		serializationMatchSteps[148] = createMatchStep_Assign(0, 8);
		// 149: assign V0 = |BufferStatementCS::isStrict.'strict'|
		serializationMatchSteps[149] = createMatchStep_Assign(0, 16);
		// 150: assign V0 = |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchSteps[150] = createMatchStep_Assign(0, 25);
		// 151: assign V0 = |CollectionPatternCS::restVariableName|
		serializationMatchSteps[151] = createMatchStep_Assign(0, 29);
		// 152: assign V0 = |CollectionTypeCS::ownedType|
		serializationMatchSteps[152] = createMatchStep_Assign(0, 32);
		// 153: assign V0 = |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchSteps[153] = createMatchStep_Assign(0, 33);
		// 154: assign V0 = |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchSteps[154] = createMatchStep_Assign(0, 37);
		// 155: assign V0 = |EnumerationLiteralCS::value|
		serializationMatchSteps[155] = createMatchStep_Assign(0, 47);
		// 156: assign V0 = |GuardParameterBindingCS::isCheck.'check'|
		serializationMatchSteps[156] = createMatchStep_Assign(0, 49);
		// 157: assign V0 = |GuardParameterCS::successProperty|
		serializationMatchSteps[157] = createMatchStep_Assign(0, 53);
		// 158: assign V0 = |IfExpCS::ownedIfThenExpressions|
		serializationMatchSteps[158] = createMatchStep_Assign(0, 57);
		// 159: assign V0 = |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchSteps[159] = createMatchStep_Assign(0, 69);
		// 160: assign V0 = |LoopParameterBindingCS::isCheck.'check'|
		serializationMatchSteps[160] = createMatchStep_Assign(0, 70);
		// 161: assign V0 = |MapTypeCS::ownedValueType|
		serializationMatchSteps[161] = createMatchStep_Assign(0, 79);
		// 162: assign V0 = |MappingCallCS::ownedBindings|
		serializationMatchSteps[162] = createMatchStep_Assign(0, 84);
		// 163: assign V0 = |MultiplicityBoundsCS::upperBound|
		serializationMatchSteps[163] = createMatchStep_Assign(0, 91);
		// 164: assign V0 = |NamedElementCS::name|
		serializationMatchSteps[164] = createMatchStep_Assign(0, 95);
		// 165: assign V0 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[165] = createMatchStep_Assign(0, 96);
		// 166: assign V0 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[166] = createMatchStep_Assign(0, 97);
		// 167: assign V0 = |NavigatingArgCS::ownedType|
		serializationMatchSteps[167] = createMatchStep_Assign(0, 99);
		// 168: assign V0 = |PatternExpCS::patternVariableName|
		serializationMatchSteps[168] = createMatchStep_Assign(0, 123);
		// 169: assign V0 = |QualifiedPackageCS::ownedPathName|
		serializationMatchSteps[169] = createMatchStep_Assign(0, 125);
		// 170: assign V0 = |QueryCS::isTransient.'transient'|
		serializationMatchSteps[170] = createMatchStep_Assign(0, 126);
		// 171: assign V0 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[171] = createMatchStep_Assign(0, 131);
		// 172: assign V0 = |RootCS::ownedImports|
		serializationMatchSteps[172] = createMatchStep_Assign(0, 132);
		// 173: assign V0 = |SimpleParameterBindingCS::isCheck.'check'|
		serializationMatchSteps[173] = createMatchStep_Assign(0, 142);
		// 174: assign V0 = |SimpleTargetElementCS::iterates|
		serializationMatchSteps[174] = createMatchStep_Assign(0, 148);
		// 175: assign V0 = |StringLiteralExpCS::segments|
		serializationMatchSteps[175] = createMatchStep_Assign(0, 157);
		// 176: assign V0 = |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchSteps[176] = createMatchStep_Assign(0, 160);
		// 177: assign V0 = |TargetCS::ownedTargetElements|
		serializationMatchSteps[177] = createMatchStep_Assign(0, 166);
		// 178: assign V0 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[178] = createMatchStep_Assign(0, 171);
		// 179: assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[179] = createMatchStep_Assign(0, 182);
		// 180: assign V0 = |TypedElementCS::ownedType|
		serializationMatchSteps[180] = createMatchStep_Assign(0, 187);
		// 181: assign V0 = |TypedElementCS::qualifiers.'definition'|
		serializationMatchSteps[181] = createMatchStep_Assign(0, 192);
		// 182: assign V0 = |TypedElementCS::qualifiers.'static'|
		serializationMatchSteps[182] = createMatchStep_Assign(0, 193);
		// 183: assign V0 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[183] = createMatchStep_Assign(0, 195);
		// 184: assign V0 = |TypedTypeRefCS::ownedBinding|
		serializationMatchSteps[184] = createMatchStep_Assign(0, 197);
		// 185: assign V0 = |VariableCS::ownedType|
		serializationMatchSteps[185] = createMatchStep_Assign(0, 200);
		// 186: assign V0 = |WildcardTypeRefCS::ownedExtends|
		serializationMatchSteps[186] = createMatchStep_Assign(0, 201);
		// 187: assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[187] = createMatchStep_Assign(1, 210);
		// 188: assign V1 = (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchSteps[188] = createMatchStep_Assign(1, 214);
		// 189: assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchSteps[189] = createMatchStep_Assign(1, 218);
		// 190: assign V1 = (|DirectionCS::imports| > 0)
		serializationMatchSteps[190] = createMatchStep_Assign(1, 222);
		// 191: assign V1 = (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchSteps[191] = createMatchStep_Assign(1, 240);
		// 192: assign V1 = (|ObservableStatementCS::observedProperties| - 1)
		serializationMatchSteps[192] = createMatchStep_Assign(1, 266);
		// 193: assign V1 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[193] = createMatchStep_Assign(1, 272);
		// 194: assign V1 = (|QueryCS::ownedParameters| > 0)
		serializationMatchSteps[194] = createMatchStep_Assign(1, 280);
		// 195: assign V1 = (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchSteps[195] = createMatchStep_Assign(1, 292);
		// 196: assign V1 = (|TupleTypeCS::ownedParts| > 0)
		serializationMatchSteps[196] = createMatchStep_Assign(1, 309);
		// 197: assign V1 = (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchSteps[197] = createMatchStep_Assign(1, 312);
		// 198: assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchSteps[198] = createMatchStep_Assign(1, 318);
		// 199: assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause|
		serializationMatchSteps[199] = createMatchStep_Assign(1, 6);
		// 200: assign V1 = |BufferStatementCS::firstPass|
		serializationMatchSteps[200] = createMatchStep_Assign(1, 15);
		// 201: assign V1 = |ClassCS::instanceClassName|
		serializationMatchSteps[201] = createMatchStep_Assign(1, 20);
		// 202: assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchSteps[202] = createMatchStep_Assign(1, 31);
		// 203: assign V1 = |ImportCS::isAll.'::'|
		serializationMatchSteps[203] = createMatchStep_Assign(1, 61);
		// 204: assign V1 = |NavigatingArgCS::ownedCoIterator|
		serializationMatchSteps[204] = createMatchStep_Assign(1, 96);
		// 205: assign V1 = |NavigatingArgCS::ownedInitExpression|
		serializationMatchSteps[205] = createMatchStep_Assign(1, 97);
		// 206: assign V1 = |PackageCS::nsPrefix|
		serializationMatchSteps[206] = createMatchStep_Assign(1, 116);
		// 207: assign V1 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[207] = createMatchStep_Assign(1, 119);
		// 208: assign V1 = |ReferenceCS::referredOpposite|
		serializationMatchSteps[208] = createMatchStep_Assign(1, 131);
		// 209: assign V1 = |StructuralFeatureCS::default|
		serializationMatchSteps[209] = createMatchStep_Assign(1, 158);
		// 210: assign V1 = |TemplateBindingCS::ownedMultiplicity|
		serializationMatchSteps[210] = createMatchStep_Assign(1, 167);
		// 211: assign V1 = |TemplateableElementCS::ownedSignature|
		serializationMatchSteps[211] = createMatchStep_Assign(1, 171);
		// 212: assign V1 = |TransformationCS::ownedContextType|
		serializationMatchSteps[212] = createMatchStep_Assign(1, 173);
		// 213: assign V1 = |TypeNameExpCS::ownedPatternGuard|
		serializationMatchSteps[213] = createMatchStep_Assign(1, 184);
		// 214: assign V1 = |TypedElementCS::ownedType|
		serializationMatchSteps[214] = createMatchStep_Assign(1, 187);
		// 215: assign V1 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[215] = createMatchStep_Assign(1, 195);
		// 216: assign V1 = |VariableCS::ownedType|
		serializationMatchSteps[216] = createMatchStep_Assign(1, 200);
		// 217: assign V10 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[217] = createMatchStep_Assign(10, 110);
		// 218: assign V2 = (|DirectionCS::imports| - 1)
		serializationMatchSteps[218] = createMatchStep_Assign(2, 221);
		// 219: assign V2 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[219] = createMatchStep_Assign(2, 271);
		// 220: assign V2 = (|OperationCS::ownedParameters| > 0)
		serializationMatchSteps[220] = createMatchStep_Assign(2, 272);
		// 221: assign V2 = (|QueryCS::ownedParameters| - 1)
		serializationMatchSteps[221] = createMatchStep_Assign(2, 279);
		// 222: assign V2 = (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchSteps[222] = createMatchStep_Assign(2, 291);
		// 223: assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchSteps[223] = createMatchStep_Assign(2, 302);
		// 224: assign V2 = (|TupleTypeCS::ownedParts| - 1)
		serializationMatchSteps[224] = createMatchStep_Assign(2, 308);
		// 225: assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[225] = createMatchStep_Assign(2, 316);
		// 226: assign V2 = 0
		serializationMatchSteps[226] = createMatchStep_Assign(2, 0);
		// 227: assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause|
		serializationMatchSteps[227] = createMatchStep_Assign(2, 4);
		// 228: assign V2 = |BufferStatementCS::lastPass|
		serializationMatchSteps[228] = createMatchStep_Assign(2, 17);
		// 229: assign V2 = |ClassCS::instanceClassName|
		serializationMatchSteps[229] = createMatchStep_Assign(2, 20);
		// 230: assign V2 = |DeclareStatementCS::isCheck.'check'|
		serializationMatchSteps[230] = createMatchStep_Assign(2, 40);
		// 231: assign V2 = |EnumerationCS::isSerializable.'serializable'|
		serializationMatchSteps[231] = createMatchStep_Assign(2, 43);
		// 232: assign V2 = |MappingLoopCS::ownedMappingStatements|
		serializationMatchSteps[232] = createMatchStep_Assign(2, 88);
		// 233: assign V2 = |NewStatementCS::isContained.'contained'|
		serializationMatchSteps[233] = createMatchStep_Assign(2, 105);
		// 234: assign V2 = |PackageCS::nsURI|
		serializationMatchSteps[234] = createMatchStep_Assign(2, 117);
		// 235: assign V2 = |SetStatementCS::isNotify.'notify'|
		serializationMatchSteps[235] = createMatchStep_Assign(2, 134);
		// 236: assign V2 = |StructuralFeatureCS::default|
		serializationMatchSteps[236] = createMatchStep_Assign(2, 158);
		// 237: assign V2 = |TopLevelCS::ownedTransformations|
		serializationMatchSteps[237] = createMatchStep_Assign(2, 172);
		// 238: assign V2 = |TransformationCS::ownedDirections|
		serializationMatchSteps[238] = createMatchStep_Assign(2, 174);
		// 239: assign V2 = |TypedElementCS::ownedType|
		serializationMatchSteps[239] = createMatchStep_Assign(2, 187);
		// 240: assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchSteps[240] = createMatchStep_Assign(2, 191);
		// 241: assign V2 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[241] = createMatchStep_Assign(2, 195);
		// 242: assign V3 = (|OperationCS::ownedParameters| - 1)
		serializationMatchSteps[242] = createMatchStep_Assign(3, 271);
		// 243: assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchSteps[243] = createMatchStep_Assign(3, 301);
		// 244: assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[244] = createMatchStep_Assign(3, 315);
		// 245: assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[245] = createMatchStep_Assign(3, 316);
		// 246: assign V3 = 0
		serializationMatchSteps[246] = createMatchStep_Assign(3, 0);
		// 247: assign V3 = |AbstractNameExpCS::isPre.'@'|
		serializationMatchSteps[247] = createMatchStep_Assign(3, 3);
		// 248: assign V3 = |DataTypeCS::isSerializable.'serializable'|
		serializationMatchSteps[248] = createMatchStep_Assign(3, 38);
		// 249: assign V3 = |EnumerationCS::ownedLiterals|
		serializationMatchSteps[249] = createMatchStep_Assign(3, 45);
		// 250: assign V3 = |NewStatementCS::ownedExpression|
		serializationMatchSteps[250] = createMatchStep_Assign(3, 106);
		// 251: assign V3 = |PackageCS::ownedClasses|
		serializationMatchSteps[251] = createMatchStep_Assign(3, 118);
		// 252: assign V3 = |StructuralFeatureCS::default|
		serializationMatchSteps[252] = createMatchStep_Assign(3, 158);
		// 253: assign V3 = |TransformationCS::ownedMappings|
		serializationMatchSteps[253] = createMatchStep_Assign(3, 175);
		// 254: assign V3 = |TypedElementCS::ownedType|
		serializationMatchSteps[254] = createMatchStep_Assign(3, 187);
		// 255: assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[255] = createMatchStep_Assign(3, 189);
		// 256: assign V3 = |TypedRefCS::ownedMultiplicity|
		serializationMatchSteps[256] = createMatchStep_Assign(3, 195);
		// 257: assign V4 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[257] = createMatchStep_Assign(4, 270);
		// 258: assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchSteps[258] = createMatchStep_Assign(4, 315);
		// 259: assign V4 = |BufferStatementCS::ownedExpression|
		serializationMatchSteps[259] = createMatchStep_Assign(4, 18);
		// 260: assign V4 = |ClassCS::instanceClassName|
		serializationMatchSteps[260] = createMatchStep_Assign(4, 20);
		// 261: assign V4 = |PackageOwnerCS::ownedPackages|
		serializationMatchSteps[261] = createMatchStep_Assign(4, 119);
		// 262: assign V4 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[262] = createMatchStep_Assign(4, 159);
		// 263: assign V4 = |TransformationCS::ownedQueries|
		serializationMatchSteps[263] = createMatchStep_Assign(4, 176);
		// 264: assign V4 = |TypedElementCS::ownedType|
		serializationMatchSteps[264] = createMatchStep_Assign(4, 187);
		// 265: assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[265] = createMatchStep_Assign(4, 188);
		// 266: assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchSteps[266] = createMatchStep_Assign(4, 189);
		// 267: assign V5 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[267] = createMatchStep_Assign(5, 269);
		// 268: assign V5 = (|OperationCS::ownedExceptions| > 0)
		serializationMatchSteps[268] = createMatchStep_Assign(5, 270);
		// 269: assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[269] = createMatchStep_Assign(5, 299);
		// 270: assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchSteps[270] = createMatchStep_Assign(5, 300);
		// 271: assign V5 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[271] = createMatchStep_Assign(5, 159);
		// 272: assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchSteps[272] = createMatchStep_Assign(5, 188);
		// 273: assign V6 = (|OperationCS::ownedExceptions| - 1)
		serializationMatchSteps[273] = createMatchStep_Assign(6, 269);
		// 274: assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[274] = createMatchStep_Assign(6, 299);
		// 275: assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[275] = createMatchStep_Assign(6, 317);
		// 276: assign V6 = 0
		serializationMatchSteps[276] = createMatchStep_Assign(6, 0);
		// 277: assign V6 = |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchSteps[277] = createMatchStep_Assign(6, 159);
		// 278: assign V6 = |StructuredClassCS::isInterface.'interface'|
		serializationMatchSteps[278] = createMatchStep_Assign(6, 161);
		// 279: assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchSteps[279] = createMatchStep_Assign(7, 299);
		// 280: assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchSteps[280] = createMatchStep_Assign(7, 317);
		// 281: assign V7 = 0
		serializationMatchSteps[281] = createMatchStep_Assign(7, 0);
		// 282: assign V7 = |StructuredClassCS::ownedOperations|
		serializationMatchSteps[282] = createMatchStep_Assign(7, 163);
		// 283: assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[283] = createMatchStep_Assign(7, 190);
		// 284: assign V8 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[284] = createMatchStep_Assign(8, 268);
		// 285: assign V8 = 0
		serializationMatchSteps[285] = createMatchStep_Assign(8, 0);
		// 286: assign V8 = |StructuredClassCS::ownedProperties|
		serializationMatchSteps[286] = createMatchStep_Assign(8, 164);
		// 287: assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchSteps[287] = createMatchStep_Assign(8, 190);
		// 288: assign V9 = (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchSteps[288] = createMatchStep_Assign(9, 268);
		// 289: assign V9 = 0
		serializationMatchSteps[289] = createMatchStep_Assign(9, 0);
		// 290: assign V9 = |OperationCS::ownedBodyExpressions|
		serializationMatchSteps[290] = createMatchStep_Assign(9, 110);
		// 291: check-rule basecs::EnumerationCS.ownedLiterals : 29
		serializationMatchSteps[291] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/*EnumerationLiteralCS*/);
		// 292: check-rule basecs::ImportCS.ownedPathName : 144
		serializationMatchSteps[292] = createMatchStep_RuleCheck(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 72/*URIPathNameCS*/);
		// 293: check-rule basecs::OperationCS.ownedBodyExpressions : 112
		serializationMatchSteps[293] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/*SpecificationCS*/);
		// 294: check-rule basecs::OperationCS.ownedExceptions : 14|59|92|128|131|138|139
		serializationMatchSteps[294] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 69/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 295: check-rule basecs::OperationCS.ownedParameters : 85
		serializationMatchSteps[295] = createMatchStep_RuleCheck(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 27/*ParameterCS*/);
		// 296: check-rule basecs::PackageCS.ownedClasses : 9|21|28|118|124
		serializationMatchSteps[296] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 57/*ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS*/);
		// 297: check-rule basecs::PackageOwnerCS.ownedPackages : 96
		serializationMatchSteps[297] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 34/*QualifiedPackageCS*/);
		// 298: check-rule basecs::PathNameCS.ownedPathElements : 38
		serializationMatchSteps[298] = createMatchStep_RuleCheck(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 9/*FirstPathElementCS*/);
		// 299: check-rule basecs::RootCS.ownedImports : 46
		serializationMatchSteps[299] = createMatchStep_RuleCheck(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 11/*ImportCS*/);
		// 300: check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : 112
		serializationMatchSteps[300] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/*SpecificationCS*/);
		// 301: check-rule basecs::StructuredClassCS.ownedOperations : 83
		serializationMatchSteps[301] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 25/*OperationCS*/);
		// 302: check-rule basecs::StructuredClassCS.ownedProperties : 4|98|117
		serializationMatchSteps[302] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 50/*AttributeCS|ReferenceCS|StructuralFeatureCS*/);
		// 303: check-rule basecs::StructuredClassCS.ownedSuperTypes : 14|59|92|128|131|138|139
		serializationMatchSteps[303] = createMatchStep_RuleCheck(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 69/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 304: check-rule basecs::TemplateBindingCS.ownedMultiplicity : 68
		serializationMatchSteps[304] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 20/*MultiplicityCS*/);
		// 305: check-rule basecs::TemplateBindingCS.ownedSubstitutions : 121
		serializationMatchSteps[305] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 53/*TemplateParameterSubstitutionCS*/);
		// 306: check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : 14|59|92|128|131|136|138|139|150
		serializationMatchSteps[306] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 80/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS*/);
		// 307: check-rule basecs::TemplateSignatureCS.ownedParameters : 135
		serializationMatchSteps[307] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 65/*TypeParameterCS*/);
		// 308: check-rule basecs::TemplateableElementCS.ownedSignature : 122
		serializationMatchSteps[308] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/*TemplateSignatureCS*/);
		// 309: check-rule basecs::TupleTypeCS.ownedParts : 127
		serializationMatchSteps[309] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/*TuplePartCS*/);
		// 310: check-rule basecs::TypeParameterCS.ownedExtends : 14|59|92|128|131|138|139
		serializationMatchSteps[310] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 69/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 311: check-rule basecs::TypedElementCS.ownedType : 129
		serializationMatchSteps[311] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 312: check-rule basecs::TypedElementCS.ownedType : 137
		serializationMatchSteps[312] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/*TypedMultiplicityRefCS*/);
		// 313: check-rule basecs::TypedRefCS.ownedMultiplicity : 68
		serializationMatchSteps[313] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/*MultiplicityCS*/);
		// 314: check-rule basecs::TypedTypeRefCS.ownedBinding : 120
		serializationMatchSteps[314] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 52/*TemplateBindingCS*/);
		// 315: check-rule basecs::TypedTypeRefCS.ownedPathName : 86
		serializationMatchSteps[315] = createMatchStep_RuleCheck(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 28/*PathNameCS*/);
		// 316: check-rule basecs::WildcardTypeRefCS.ownedExtends : 14|59|92|128|131|138|139
		serializationMatchSteps[316] = createMatchStep_RuleCheck(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 69/*CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS*/);
		// 317: check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : 19
		serializationMatchSteps[317] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/*CurlyBracketedClauseCS*/);
		// 318: check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : 86
		serializationMatchSteps[318] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 28/*PathNameCS*/);
		// 319: check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : 99
		serializationMatchSteps[319] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 36/*RoundBracketedClauseCS*/);
		// 320: check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : 114
		serializationMatchSteps[320] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 47/*SquareBracketedClauseCS*/);
		// 321: check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : 12
		serializationMatchSteps[321] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 1/*CollectionLiteralPartCS*/);
		// 322: check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : 14
		serializationMatchSteps[322] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 2/*CollectionTypeCS*/);
		// 323: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[323] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 324: check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : 87
		serializationMatchSteps[324] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 29/*PatternExpCS*/);
		// 325: check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[325] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 326: check-rule essentialoclcs::CollectionPatternCS.ownedParts : 87
		serializationMatchSteps[326] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 29/*PatternExpCS*/);
		// 327: check-rule essentialoclcs::CollectionPatternCS.ownedType : 14
		serializationMatchSteps[327] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/*CollectionTypeCS*/);
		// 328: check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : 68
		serializationMatchSteps[328] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 20/*MultiplicityCS*/);
		// 329: check-rule essentialoclcs::CollectionTypeCS.ownedType : 13|14|59|92|128|130|131|134
		serializationMatchSteps[329] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 64/*CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS*/);
		// 330: check-rule essentialoclcs::ContextCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[330] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 331: check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : 107
		serializationMatchSteps[331] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 39/*ShadowPartCS*/);
		// 332: check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[332] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 333: check-rule essentialoclcs::IfExpCS.ownedCondition : 6|11|37|45|48|51|52|57|71|78|81|82|87|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[333] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 79/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 334: check-rule essentialoclcs::IfExpCS.ownedElseExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[334] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 335: check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : 26
		serializationMatchSteps[335] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 6/*ElseIfThenExpCS*/);
		// 336: check-rule essentialoclcs::IfExpCS.ownedThenExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[336] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 337: check-rule essentialoclcs::IfThenExpCS.ownedCondition : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[337] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 338: check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[338] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 339: check-rule essentialoclcs::InfixExpCS.ownedLeft : 6|11|45|48|51|57|71|78|81|82|89|90|91|105|116|125|132|146
		serializationMatchSteps[339] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 340: check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[340] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 341: check-rule essentialoclcs::LetExpCS.ownedInExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[341] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 342: check-rule essentialoclcs::LetExpCS.ownedVariables : 53
		serializationMatchSteps[342] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 12/*LetVariableCS*/);
		// 343: check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : 99
		serializationMatchSteps[343] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 36/*RoundBracketedClauseCS*/);
		// 344: check-rule essentialoclcs::MapLiteralExpCS.ownedParts : 58
		serializationMatchSteps[344] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 13/*MapLiteralPartCS*/);
		// 345: check-rule essentialoclcs::MapLiteralExpCS.ownedType : 59
		serializationMatchSteps[345] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 14/*MapTypeCS*/);
		// 346: check-rule essentialoclcs::MapLiteralPartCS.ownedKey : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[346] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 347: check-rule essentialoclcs::MapLiteralPartCS.ownedValue : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[347] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 348: check-rule essentialoclcs::MapTypeCS.ownedKeyType : 129
		serializationMatchSteps[348] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/*TypeExpCS*/);
		// 349: check-rule essentialoclcs::MapTypeCS.ownedValueType : 129
		serializationMatchSteps[349] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/*TypeExpCS*/);
		// 350: check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : 10
		serializationMatchSteps[350] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/*CoIteratorVariableCS*/);
		// 351: check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[351] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 352: check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : 6|11|37|45|48|51|52|57|71|73|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[352] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 78/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 353: check-rule essentialoclcs::NavigatingArgCS.ownedType : 129
		serializationMatchSteps[353] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 354: check-rule essentialoclcs::NestedExpCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[354] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 355: check-rule essentialoclcs::OperatorExpCS.ownedRight : 52|88
		serializationMatchSteps[355] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 32/*LetExpCS|PrefixedLetExpCS*/);
		// 356: check-rule essentialoclcs::OperatorExpCS.ownedRight : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[356] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 357: check-rule essentialoclcs::OperatorExpCS.ownedRight : 6|11|45|48|51|57|71|78|81|82|89|90|91|105|116|125|132|146
		serializationMatchSteps[357] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 75/*BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 358: check-rule essentialoclcs::PatternExpCS.ownedPatternType : 129
		serializationMatchSteps[358] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 60/*TypeExpCS*/);
		// 359: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 116
		serializationMatchSteps[359] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 48/*StringLiteralExpCS*/);
		// 360: check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : 6|11|37|45|48|51|52|57|71|78|81|82|87|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[360] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 79/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 361: check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[361] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 362: check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : 126
		serializationMatchSteps[362] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 58/*TupleLiteralPartCS*/);
		// 363: check-rule essentialoclcs::TypeLiteralExpCS.ownedType : 133
		serializationMatchSteps[363] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 63/*TypeLiteralWithMultiplicityCS*/);
		// 364: check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : 19
		serializationMatchSteps[364] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/*CurlyBracketedClauseCS*/);
		// 365: check-rule essentialoclcs::TypeNameExpCS.ownedPathName : 86
		serializationMatchSteps[365] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 28/*PathNameCS*/);
		// 366: check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[366] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 367: check-rule essentialoclcs::VariableCS.ownedInitExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[367] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 368: check-rule essentialoclcs::VariableCS.ownedType : 129
		serializationMatchSteps[368] = createMatchStep_RuleCheck(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/*TypeExpCS*/);
		// 369: check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : 104
		serializationMatchSteps[369] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 37/*ScopeNameCS*/);
		// 370: check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : 111
		serializationMatchSteps[370] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 42/*SimpleTargetElementCS*/);
		// 371: check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : 104
		serializationMatchSteps[371] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 37/*ScopeNameCS*/);
		// 372: check-rule qvtbasecs::TargetCS.ownedTargetElements : 17|111
		serializationMatchSteps[372] = createMatchStep_RuleCheck(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 43/*CompoundTargetElementCS|SimpleTargetElementCS*/);
		// 373: check-rule qvtimperativecs::AddStatementCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[373] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 374: check-rule qvtimperativecs::BufferStatementCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[374] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 375: check-rule qvtimperativecs::CheckStatementCS.ownedCondition : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[375] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.CHECK_STATEMENT_CS__OWNED_CONDITION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 376: check-rule qvtimperativecs::DeclareStatementCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[376] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 377: check-rule qvtimperativecs::MappingCallCS.ownedBindings : 2|39|54|64|108
		serializationMatchSteps[377] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_BINDINGS, 40/*AppendParameterBindingCS|GuardParameterBindingCS|LoopParameterBindingCS|MappingParameterBindingCS|SimpleParameterBindingCS*/);
		// 378: check-rule qvtimperativecs::MappingCallCS.ownedPathName : 86
		serializationMatchSteps[378] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_PATH_NAME, 28/*PathNameCS*/);
		// 379: check-rule qvtimperativecs::MappingLoopCS.ownedInExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[379] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 380: check-rule qvtimperativecs::MappingLoopCS.ownedIterator : 62
		serializationMatchSteps[380] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_ITERATOR, 16/*MappingIteratorCS*/);
		// 381: check-rule qvtimperativecs::MappingLoopCS.ownedMappingStatements : 1|18|61|63
		serializationMatchSteps[381] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS, 17/*AddStatementCS|ControlStatementCS|MappingCallCS|MappingLoopCS*/);
		// 382: check-rule qvtimperativecs::NewStatementCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[382] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 383: check-rule qvtimperativecs::ObservableStatementCS.observedProperties : 86
		serializationMatchSteps[383] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/*PathNameCS*/);
		// 384: check-rule qvtimperativecs::QueryCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[384] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 385: check-rule qvtimperativecs::QueryCS.ownedParameters : 84
		serializationMatchSteps[385] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 26/*ParamDeclarationCS*/);
		// 386: check-rule qvtimperativecs::SetStatementCS.ownedExpression : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[386] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__OWNED_EXPRESSION, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 387: check-rule qvtimperativecs::SimpleParameterBindingCS.ownedValue : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[387] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__OWNED_VALUE, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 388: check-rule qvtimperativecs::SpeculateStatementCS.ownedConditions : 6|11|37|45|48|51|52|57|71|78|81|82|88|89|90|91|105|116|125|132|146
		serializationMatchSteps[388] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.SPECULATE_STATEMENT_CS__OWNED_CONDITIONS, 77/*BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS*/);
		// 389: check-rule qvtimperativecs::TopLevelCS.ownedTransformations : 124
		serializationMatchSteps[389] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 55/*TransformationCS*/);
		// 390: check-rule qvtimperativecs::TransformationCS.ownedContextType : 129
		serializationMatchSteps[390] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_CONTEXT_TYPE, 60/*TypeExpCS*/);
		// 391: check-rule qvtimperativecs::TransformationCS.ownedDirections : 23
		serializationMatchSteps[391] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 5/*DirectionCS*/);
		// 392: check-rule qvtimperativecs::TransformationCS.ownedMappings : 27|60
		serializationMatchSteps[392] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_MAPPINGS, 15/*EntryPointCS|MappingCS*/);
		// 393: check-rule qvtimperativecs::TransformationCS.ownedQueries : 97
		serializationMatchSteps[393] = createMatchStep_RuleCheck(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES, 35/*QueryCS*/);
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
		serializationMatchTerms[3] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 9 /* '@' */);
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
		// 10: |AddStatementCS::ownedExpression|
		serializationMatchTerms[10] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__OWNED_EXPRESSION);
		// 11: |AddStatementCS::targetVariable|
		serializationMatchTerms[11] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__TARGET_VARIABLE);
		// 12: |AppendParameterBindingCS::referredVariable|
		serializationMatchTerms[12] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__REFERRED_VARIABLE);
		// 13: |AppendParameterBindingCS::value|
		serializationMatchTerms[13] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__VALUE);
		// 14: |BooleanLiteralExpCS::symbol.'false|true'|
		serializationMatchTerms[14] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 16 /* 'false|true' */);
		// 15: |BufferStatementCS::firstPass|
		serializationMatchTerms[15] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__FIRST_PASS);
		// 16: |BufferStatementCS::isStrict.'strict'|
		serializationMatchTerms[16] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__IS_STRICT, 26 /* 'strict' */);
		// 17: |BufferStatementCS::lastPass|
		serializationMatchTerms[17] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__LAST_PASS);
		// 18: |BufferStatementCS::ownedExpression|
		serializationMatchTerms[18] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__OWNED_EXPRESSION);
		// 19: |CheckStatementCS::ownedCondition|
		serializationMatchTerms[19] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.CHECK_STATEMENT_CS__OWNED_CONDITION);
		// 20: |ClassCS::instanceClassName|
		serializationMatchTerms[20] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME);
		// 21: |ClassCS::ownedConstraints|
		serializationMatchTerms[21] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.CLASS_CS__OWNED_CONSTRAINTS);
		// 22: |CollectionLiteralExpCS::ownedParts|
		serializationMatchTerms[22] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);
		// 23: |CollectionLiteralExpCS::ownedType|
		serializationMatchTerms[23] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE);
		// 24: |CollectionLiteralPartCS::ownedExpression|
		serializationMatchTerms[24] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION);
		// 25: |CollectionLiteralPartCS::ownedLastExpression|
		serializationMatchTerms[25] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION);
		// 26: |CollectionPatternCS::ownedParts|
		serializationMatchTerms[26] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS);
		// 27: |CollectionPatternCS::ownedPatternGuard|
		serializationMatchTerms[27] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PATTERN_GUARD);
		// 28: |CollectionPatternCS::ownedType|
		serializationMatchTerms[28] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE);
		// 29: |CollectionPatternCS::restVariableName|
		serializationMatchTerms[29] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME);
		// 30: |CollectionTypeCS::name|
		serializationMatchTerms[30] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME);
		// 31: |CollectionTypeCS::ownedCollectionMultiplicity|
		serializationMatchTerms[31] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY);
		// 32: |CollectionTypeCS::ownedType|
		serializationMatchTerms[32] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE);
		// 33: |CompoundTargetElementCS::ownedTargetElements|
		serializationMatchTerms[33] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS);
		// 34: |ContextCS::ownedExpression|
		serializationMatchTerms[34] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION);
		// 35: |CurlyBracketedClauseCS::ownedParts|
		serializationMatchTerms[35] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS);
		// 36: |CurlyBracketedClauseCS::value|
		serializationMatchTerms[36] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__VALUE);
		// 37: |DataTypeCS::isPrimitive.'primitive'|
		serializationMatchTerms[37] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 23 /* 'primitive' */);
		// 38: |DataTypeCS::isSerializable.'serializable'|
		serializationMatchTerms[38] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 24 /* 'serializable' */);
		// 39: |DataTypeCS::isSerializable|
		serializationMatchTerms[39] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE);
		// 40: |DeclareStatementCS::isCheck.'check'|
		serializationMatchTerms[40] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__IS_CHECK, 13 /* 'check' */);
		// 41: |DeclareStatementCS::ownedExpression|
		serializationMatchTerms[41] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__OWNED_EXPRESSION);
		// 42: |DirectionCS::imports|
		serializationMatchTerms[42] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.DIRECTION_CS__IMPORTS);
		// 43: |EnumerationCS::isSerializable.'serializable'|
		serializationMatchTerms[43] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 24 /* 'serializable' */);
		// 44: |EnumerationCS::isSerializable|
		serializationMatchTerms[44] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE);
		// 45: |EnumerationCS::ownedLiterals|
		serializationMatchTerms[45] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS);
		// 46: |EnumerationLiteralCS::literal|
		serializationMatchTerms[46] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__LITERAL);
		// 47: |EnumerationLiteralCS::value|
		serializationMatchTerms[47] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		// 48: |ExpSpecificationCS::ownedExpression|
		serializationMatchTerms[48] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION);
		// 49: |GuardParameterBindingCS::isCheck.'check'|
		serializationMatchTerms[49] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__IS_CHECK, 13 /* 'check' */);
		// 50: |GuardParameterBindingCS::referredVariable|
		serializationMatchTerms[50] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__REFERRED_VARIABLE);
		// 51: |GuardParameterBindingCS::value|
		serializationMatchTerms[51] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__VALUE);
		// 52: |GuardParameterCS::referredTypedModel|
		serializationMatchTerms[52] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL);
		// 53: |GuardParameterCS::successProperty|
		serializationMatchTerms[53] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__SUCCESS_PROPERTY);
		// 54: |IfExpCS::isImplicit|
		serializationMatchTerms[54] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__IS_IMPLICIT);
		// 55: |IfExpCS::ownedCondition|
		serializationMatchTerms[55] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION);
		// 56: |IfExpCS::ownedElseExpression|
		serializationMatchTerms[56] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION);
		// 57: |IfExpCS::ownedIfThenExpressions|
		serializationMatchTerms[57] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS);
		// 58: |IfExpCS::ownedThenExpression|
		serializationMatchTerms[58] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION);
		// 59: |IfThenExpCS::ownedCondition|
		serializationMatchTerms[59] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION);
		// 60: |IfThenExpCS::ownedThenExpression|
		serializationMatchTerms[60] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION);
		// 61: |ImportCS::isAll.'::'|
		serializationMatchTerms[61] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, 7 /* '::' */);
		// 62: |ImportCS::ownedPathName|
		serializationMatchTerms[62] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME);
		// 63: |InfixExpCS::ownedLeft|
		serializationMatchTerms[63] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT);
		// 64: |JavaImplementationCS::implementation|
		serializationMatchTerms[64] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION);
		// 65: |LambdaLiteralExpCS::ownedExpressionCS|
		serializationMatchTerms[65] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS);
		// 66: |LetExpCS::isImplicit|
		serializationMatchTerms[66] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__IS_IMPLICIT);
		// 67: |LetExpCS::ownedInExpression|
		serializationMatchTerms[67] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION);
		// 68: |LetExpCS::ownedVariables|
		serializationMatchTerms[68] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES);
		// 69: |LetVariableCS::ownedRoundBracketedClause|
		serializationMatchTerms[69] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE);
		// 70: |LoopParameterBindingCS::isCheck.'check'|
		serializationMatchTerms[70] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__IS_CHECK, 13 /* 'check' */);
		// 71: |LoopParameterBindingCS::referredVariable|
		serializationMatchTerms[71] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__REFERRED_VARIABLE);
		// 72: |LoopParameterBindingCS::value|
		serializationMatchTerms[72] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__VALUE);
		// 73: |MapLiteralExpCS::ownedParts|
		serializationMatchTerms[73] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS);
		// 74: |MapLiteralExpCS::ownedType|
		serializationMatchTerms[74] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE);
		// 75: |MapLiteralPartCS::ownedKey|
		serializationMatchTerms[75] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY);
		// 76: |MapLiteralPartCS::ownedValue|
		serializationMatchTerms[76] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE);
		// 77: |MapTypeCS::name.'Map'|
		serializationMatchTerms[77] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 10 /* 'Map' */);
		// 78: |MapTypeCS::ownedKeyType|
		serializationMatchTerms[78] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE);
		// 79: |MapTypeCS::ownedValueType|
		serializationMatchTerms[79] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE);
		// 80: |MappingCallCS::isInstall.'install'|
		serializationMatchTerms[80] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INSTALL, 18 /* 'install' */);
		// 81: |MappingCallCS::isInstall|
		serializationMatchTerms[81] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INSTALL);
		// 82: |MappingCallCS::isInvoke.'invoke'|
		serializationMatchTerms[82] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INVOKE, 20 /* 'invoke' */);
		// 83: |MappingCallCS::isInvoke|
		serializationMatchTerms[83] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INVOKE);
		// 84: |MappingCallCS::ownedBindings|
		serializationMatchTerms[84] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_BINDINGS);
		// 85: |MappingCallCS::ownedPathName|
		serializationMatchTerms[85] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_PATH_NAME);
		// 86: |MappingLoopCS::ownedInExpression|
		serializationMatchTerms[86] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION);
		// 87: |MappingLoopCS::ownedIterator|
		serializationMatchTerms[87] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_ITERATOR);
		// 88: |MappingLoopCS::ownedMappingStatements|
		serializationMatchTerms[88] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS);
		// 89: |ModelElementCS::ownedAnnotations|
		serializationMatchTerms[89] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS);
		// 90: |MultiplicityBoundsCS::lowerBound|
		serializationMatchTerms[90] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND);
		// 91: |MultiplicityBoundsCS::upperBound|
		serializationMatchTerms[91] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND);
		// 92: |MultiplicityCS::isNullFree.'|1'|
		serializationMatchTerms[92] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 30 /* '|1' */);
		// 93: |MultiplicityCS::isNullFree|
		serializationMatchTerms[93] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE);
		// 94: |MultiplicityStringCS::stringBounds.'*|+|?'|
		serializationMatchTerms[94] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 4 /* '*|+|?' */);
		// 95: |NamedElementCS::name|
		serializationMatchTerms[95] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME);
		// 96: |NavigatingArgCS::ownedCoIterator|
		serializationMatchTerms[96] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR);
		// 97: |NavigatingArgCS::ownedInitExpression|
		serializationMatchTerms[97] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION);
		// 98: |NavigatingArgCS::ownedNameExpression|
		serializationMatchTerms[98] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION);
		// 99: |NavigatingArgCS::ownedType|
		serializationMatchTerms[99] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE);
		// 100: |NavigatingArgCS::prefix.','|
		serializationMatchTerms[100] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ',' */);
		// 101: |NavigatingArgCS::prefix.';'|
		serializationMatchTerms[101] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 8 /* ';' */);
		// 102: |NavigatingArgCS::prefix.'|'|
		serializationMatchTerms[102] = createSerializationMatchTermEAttributeSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 29 /* '|' */);
		// 103: |NavigatingArgCS::prefix|
		serializationMatchTerms[103] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX);
		// 104: |NestedExpCS::ownedExpression|
		serializationMatchTerms[104] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION);
		// 105: |NewStatementCS::isContained.'contained'|
		serializationMatchTerms[105] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__IS_CONTAINED, 14 /* 'contained' */);
		// 106: |NewStatementCS::ownedExpression|
		serializationMatchTerms[106] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__OWNED_EXPRESSION);
		// 107: |NewStatementCS::referredTypedModel|
		serializationMatchTerms[107] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__REFERRED_TYPED_MODEL);
		// 108: |NumberLiteralExpCS::symbol|
		serializationMatchTerms[108] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL);
		// 109: |ObservableStatementCS::observedProperties|
		serializationMatchTerms[109] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES);
		// 110: |OperationCS::ownedBodyExpressions|
		serializationMatchTerms[110] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS);
		// 111: |OperationCS::ownedExceptions|
		serializationMatchTerms[111] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS);
		// 112: |OperationCS::ownedParameters|
		serializationMatchTerms[112] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS);
		// 113: |OperationCS::ownedPostconditions|
		serializationMatchTerms[113] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_POSTCONDITIONS);
		// 114: |OperationCS::ownedPreconditions|
		serializationMatchTerms[114] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.OPERATION_CS__OWNED_PRECONDITIONS);
		// 115: |OperatorExpCS::ownedRight|
		serializationMatchTerms[115] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT);
		// 116: |PackageCS::nsPrefix|
		serializationMatchTerms[116] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX);
		// 117: |PackageCS::nsURI|
		serializationMatchTerms[117] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__NS_URI);
		// 118: |PackageCS::ownedClasses|
		serializationMatchTerms[118] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES);
		// 119: |PackageOwnerCS::ownedPackages|
		serializationMatchTerms[119] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES);
		// 120: |PathElementCS::referredElement|
		serializationMatchTerms[120] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT);
		// 121: |PathNameCS::ownedPathElements|
		serializationMatchTerms[121] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS);
		// 122: |PatternExpCS::ownedPatternType|
		serializationMatchTerms[122] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE);
		// 123: |PatternExpCS::patternVariableName|
		serializationMatchTerms[123] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME);
		// 124: |PrimitiveTypeRefCS::name|
		serializationMatchTerms[124] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME);
		// 125: |QualifiedPackageCS::ownedPathName|
		serializationMatchTerms[125] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME);
		// 126: |QueryCS::isTransient.'transient'|
		serializationMatchTerms[126] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.QUERY_CS__IS_TRANSIENT, 27 /* 'transient' */);
		// 127: |QueryCS::ownedExpression|
		serializationMatchTerms[127] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION);
		// 128: |QueryCS::ownedParameters|
		serializationMatchTerms[128] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS);
		// 129: |ReferenceCS::ownedImplicitOpposites|
		serializationMatchTerms[129] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__OWNED_IMPLICIT_OPPOSITES);
		// 130: |ReferenceCS::referredKeys|
		serializationMatchTerms[130] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_KEYS);
		// 131: |ReferenceCS::referredOpposite|
		serializationMatchTerms[131] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE);
		// 132: |RootCS::ownedImports|
		serializationMatchTerms[132] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS);
		// 133: |SelfExpCS::name|
		serializationMatchTerms[133] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SELF_EXP_CS__NAME);
		// 134: |SetStatementCS::isNotify.'notify'|
		serializationMatchTerms[134] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_NOTIFY, 21 /* 'notify' */);
		// 135: |SetStatementCS::isPartial.'+='|
		serializationMatchTerms[135] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_PARTIAL, 5 /* '+=' */);
		// 136: |SetStatementCS::isPartial|
		serializationMatchTerms[136] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_PARTIAL);
		// 137: |SetStatementCS::ownedExpression|
		serializationMatchTerms[137] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__OWNED_EXPRESSION);
		// 138: |SetStatementCS::referredProperty|
		serializationMatchTerms[138] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_PROPERTY);
		// 139: |SetStatementCS::referredVariable|
		serializationMatchTerms[139] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_VARIABLE);
		// 140: |ShadowPartCS::ownedInitExpression|
		serializationMatchTerms[140] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION);
		// 141: |ShadowPartCS::referredProperty|
		serializationMatchTerms[141] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY);
		// 142: |SimpleParameterBindingCS::isCheck.'check'|
		serializationMatchTerms[142] = createSerializationMatchTermEAttributeSize(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__IS_CHECK, 13 /* 'check' */);
		// 143: |SimpleParameterBindingCS::ownedValue|
		serializationMatchTerms[143] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__OWNED_VALUE);
		// 144: |SimpleParameterBindingCS::referredVariable|
		serializationMatchTerms[144] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__REFERRED_VARIABLE);
		// 145: |SimpleParameterCS::referredTypedModel|
		serializationMatchTerms[145] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_CS__REFERRED_TYPED_MODEL);
		// 146: |SimpleTargetElementCS::input.'input'|
		serializationMatchTerms[146] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 17 /* 'input' */);
		// 147: |SimpleTargetElementCS::input|
		serializationMatchTerms[147] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT);
		// 148: |SimpleTargetElementCS::iterates|
		serializationMatchTerms[148] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES);
		// 149: |SimpleTargetElementCS::output.'output'|
		serializationMatchTerms[149] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 22 /* 'output' */);
		// 150: |SimpleTargetElementCS::output|
		serializationMatchTerms[150] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT);
		// 151: |SimpleTargetElementCS::typedModel|
		serializationMatchTerms[151] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL);
		// 152: |SimpleTargetElementCS::via.'via'|
		serializationMatchTerms[152] = createSerializationMatchTermEAttributeSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 28 /* 'via' */);
		// 153: |SimpleTargetElementCS::via|
		serializationMatchTerms[153] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA);
		// 154: |SpecificationCS::exprString|
		serializationMatchTerms[154] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING);
		// 155: |SpeculateStatementCS::ownedConditions|
		serializationMatchTerms[155] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.SPECULATE_STATEMENT_CS__OWNED_CONDITIONS);
		// 156: |SquareBracketedClauseCS::ownedTerms|
		serializationMatchTerms[156] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS);
		// 157: |StringLiteralExpCS::segments|
		serializationMatchTerms[157] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS);
		// 158: |StructuralFeatureCS::default|
		serializationMatchTerms[158] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT);
		// 159: |StructuralFeatureCS::ownedDefaultExpressions|
		serializationMatchTerms[159] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS);
		// 160: |StructuredClassCS::isAbstract.'abstract'|
		serializationMatchTerms[160] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 12 /* 'abstract' */);
		// 161: |StructuredClassCS::isInterface.'interface'|
		serializationMatchTerms[161] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 19 /* 'interface' */);
		// 162: |StructuredClassCS::ownedMetaclass|
		serializationMatchTerms[162] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_METACLASS);
		// 163: |StructuredClassCS::ownedOperations|
		serializationMatchTerms[163] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS);
		// 164: |StructuredClassCS::ownedProperties|
		serializationMatchTerms[164] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES);
		// 165: |StructuredClassCS::ownedSuperTypes|
		serializationMatchTerms[165] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES);
		// 166: |TargetCS::ownedTargetElements|
		serializationMatchTerms[166] = createSerializationMatchTermEStructuralFeatureSize(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS);
		// 167: |TemplateBindingCS::ownedMultiplicity|
		serializationMatchTerms[167] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY);
		// 168: |TemplateBindingCS::ownedSubstitutions|
		serializationMatchTerms[168] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS);
		// 169: |TemplateParameterSubstitutionCS::ownedActualParameter|
		serializationMatchTerms[169] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER);
		// 170: |TemplateSignatureCS::ownedParameters|
		serializationMatchTerms[170] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS);
		// 171: |TemplateableElementCS::ownedSignature|
		serializationMatchTerms[171] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE);
		// 172: |TopLevelCS::ownedTransformations|
		serializationMatchTerms[172] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);
		// 173: |TransformationCS::ownedContextType|
		serializationMatchTerms[173] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_CONTEXT_TYPE);
		// 174: |TransformationCS::ownedDirections|
		serializationMatchTerms[174] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS);
		// 175: |TransformationCS::ownedMappings|
		serializationMatchTerms[175] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_MAPPINGS);
		// 176: |TransformationCS::ownedQueries|
		serializationMatchTerms[176] = createSerializationMatchTermEStructuralFeatureSize(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES);
		// 177: |TupleLiteralExpCS::ownedParts|
		serializationMatchTerms[177] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS);
		// 178: |TupleTypeCS::name.'Tuple'|
		serializationMatchTerms[178] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 11 /* 'Tuple' */);
		// 179: |TupleTypeCS::ownedParts|
		serializationMatchTerms[179] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS);
		// 180: |TypeLiteralExpCS::ownedPathName|
		serializationMatchTerms[180] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_PATH_NAME);
		// 181: |TypeLiteralExpCS::ownedType|
		serializationMatchTerms[181] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE);
		// 182: |TypeNameExpCS::ownedCurlyBracketedClause|
		serializationMatchTerms[182] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE);
		// 183: |TypeNameExpCS::ownedPathName|
		serializationMatchTerms[183] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME);
		// 184: |TypeNameExpCS::ownedPatternGuard|
		serializationMatchTerms[184] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD);
		// 185: |TypeParameterCS::ownedExtends|
		serializationMatchTerms[185] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS);
		// 186: |TypedElementCS::isOptional|
		serializationMatchTerms[186] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__IS_OPTIONAL);
		// 187: |TypedElementCS::ownedType|
		serializationMatchTerms[187] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE);
		// 188: |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'|
		serializationMatchTerms[188] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */);
		// 189: |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'|
		serializationMatchTerms[189] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */);
		// 190: |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'|
		serializationMatchTerms[190] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */);
		// 191: |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'|
		serializationMatchTerms[191] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */);
		// 192: |TypedElementCS::qualifiers.'definition'|
		serializationMatchTerms[192] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 15 /* 'definition' */);
		// 193: |TypedElementCS::qualifiers.'static'|
		serializationMatchTerms[193] = createSerializationMatchTermEAttributeSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 25 /* 'static' */);
		// 194: |TypedElementCS::qualifiers|
		serializationMatchTerms[194] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS);
		// 195: |TypedRefCS::ownedMultiplicity|
		serializationMatchTerms[195] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY);
		// 196: |TypedTypeRefCS::isTypeof|
		serializationMatchTerms[196] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__IS_TYPEOF);
		// 197: |TypedTypeRefCS::ownedBinding|
		serializationMatchTerms[197] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING);
		// 198: |TypedTypeRefCS::ownedPathName|
		serializationMatchTerms[198] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME);
		// 199: |VariableCS::ownedInitExpression|
		serializationMatchTerms[199] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION);
		// 200: |VariableCS::ownedType|
		serializationMatchTerms[200] = createSerializationMatchTermEStructuralFeatureSize(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE);
		// 201: |WildcardTypeRefCS::ownedExtends|
		serializationMatchTerms[201] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS);
		// 202: |WildcardTypeRefCS::ownedSuper|
		serializationMatchTerms[202] = createSerializationMatchTermEStructuralFeatureSize(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_SUPER);
		// 203: (|AbstractNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[203] = createSerializationMatchTermSubtract(5, 1);
		// 204: (|AddStatementCS::ownedExpression| - 1)
		serializationMatchTerms[204] = createSerializationMatchTermSubtract(10, 1);
		// 205: (|AddStatementCS::targetVariable| - 1)
		serializationMatchTerms[205] = createSerializationMatchTermSubtract(11, 1);
		// 206: (|AppendParameterBindingCS::referredVariable| - 1)
		serializationMatchTerms[206] = createSerializationMatchTermSubtract(12, 1);
		// 207: (|AppendParameterBindingCS::value| - 1)
		serializationMatchTerms[207] = createSerializationMatchTermSubtract(13, 1);
		// 208: (|BooleanLiteralExpCS::symbol.'false|true'| - 1)
		serializationMatchTerms[208] = createSerializationMatchTermSubtract(14, 1);
		// 209: (|CheckStatementCS::ownedCondition| - 1)
		serializationMatchTerms[209] = createSerializationMatchTermSubtract(19, 1);
		// 210: (|CollectionLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[210] = createSerializationMatchTermSubtract(22, 1);
		// 211: (|CollectionLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[211] = createSerializationMatchTermGreaterThan(22, 0);
		// 212: (|CollectionLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[212] = createSerializationMatchTermSubtract(23, 1);
		// 213: (|CollectionLiteralPartCS::ownedExpression| - 1)
		serializationMatchTerms[213] = createSerializationMatchTermSubtract(24, 1);
		// 214: (|CollectionPatternCS::ownedParts| - 1)
		serializationMatchTerms[214] = createSerializationMatchTermSubtract(26, 1);
		// 215: (|CollectionPatternCS::ownedType| - 1)
		serializationMatchTerms[215] = createSerializationMatchTermSubtract(28, 1);
		// 216: (|CollectionTypeCS::name| - 1)
		serializationMatchTerms[216] = createSerializationMatchTermSubtract(30, 1);
		// 217: (|ContextCS::ownedExpression| - 1)
		serializationMatchTerms[217] = createSerializationMatchTermSubtract(34, 1);
		// 218: (|CurlyBracketedClauseCS::ownedParts| - 1)
		serializationMatchTerms[218] = createSerializationMatchTermSubtract(35, 1);
		// 219: (|CurlyBracketedClauseCS::ownedParts| > 0)
		serializationMatchTerms[219] = createSerializationMatchTermGreaterThan(35, 0);
		// 220: (|DeclareStatementCS::ownedExpression| - 1)
		serializationMatchTerms[220] = createSerializationMatchTermSubtract(41, 1);
		// 221: (|DirectionCS::imports| - 1)
		serializationMatchTerms[221] = createSerializationMatchTermSubtract(42, 1);
		// 222: (|DirectionCS::imports| > 0)
		serializationMatchTerms[222] = createSerializationMatchTermGreaterThan(42, 0);
		// 223: (|ExpSpecificationCS::ownedExpression| - 1)
		serializationMatchTerms[223] = createSerializationMatchTermSubtract(48, 1);
		// 224: (|GuardParameterBindingCS::referredVariable| - 1)
		serializationMatchTerms[224] = createSerializationMatchTermSubtract(50, 1);
		// 225: (|GuardParameterBindingCS::value| - 1)
		serializationMatchTerms[225] = createSerializationMatchTermSubtract(51, 1);
		// 226: (|GuardParameterCS::referredTypedModel| - 1)
		serializationMatchTerms[226] = createSerializationMatchTermSubtract(52, 1);
		// 227: (|IfExpCS::ownedCondition| - 1)
		serializationMatchTerms[227] = createSerializationMatchTermSubtract(55, 1);
		// 228: (|IfExpCS::ownedElseExpression| - 1)
		serializationMatchTerms[228] = createSerializationMatchTermSubtract(56, 1);
		// 229: (|IfExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[229] = createSerializationMatchTermSubtract(58, 1);
		// 230: (|IfThenExpCS::ownedCondition| - 1)
		serializationMatchTerms[230] = createSerializationMatchTermSubtract(59, 1);
		// 231: (|IfThenExpCS::ownedThenExpression| - 1)
		serializationMatchTerms[231] = createSerializationMatchTermSubtract(60, 1);
		// 232: (|ImportCS::ownedPathName| - 1)
		serializationMatchTerms[232] = createSerializationMatchTermSubtract(62, 1);
		// 233: (|InfixExpCS::ownedLeft| - 1)
		serializationMatchTerms[233] = createSerializationMatchTermSubtract(63, 1);
		// 234: (|JavaImplementationCS::implementation| - 1)
		serializationMatchTerms[234] = createSerializationMatchTermSubtract(64, 1);
		// 235: (|LambdaLiteralExpCS::ownedExpressionCS| - 1)
		serializationMatchTerms[235] = createSerializationMatchTermSubtract(65, 1);
		// 236: (|LetExpCS::ownedInExpression| - 1)
		serializationMatchTerms[236] = createSerializationMatchTermSubtract(67, 1);
		// 237: (|LetExpCS::ownedVariables| - 1)
		serializationMatchTerms[237] = createSerializationMatchTermSubtract(68, 1);
		// 238: (|LoopParameterBindingCS::referredVariable| - 1)
		serializationMatchTerms[238] = createSerializationMatchTermSubtract(71, 1);
		// 239: (|LoopParameterBindingCS::value| - 1)
		serializationMatchTerms[239] = createSerializationMatchTermSubtract(72, 1);
		// 240: (|MapLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[240] = createSerializationMatchTermSubtract(73, 1);
		// 241: (|MapLiteralExpCS::ownedParts| > 0)
		serializationMatchTerms[241] = createSerializationMatchTermGreaterThan(73, 0);
		// 242: (|MapLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[242] = createSerializationMatchTermSubtract(74, 1);
		// 243: (|MapLiteralPartCS::ownedKey| - 1)
		serializationMatchTerms[243] = createSerializationMatchTermSubtract(75, 1);
		// 244: (|MapLiteralPartCS::ownedValue| - 1)
		serializationMatchTerms[244] = createSerializationMatchTermSubtract(76, 1);
		// 245: (|MapTypeCS::name.'Map'| - 1)
		serializationMatchTerms[245] = createSerializationMatchTermSubtract(77, 1);
		// 246: (|MapTypeCS::ownedKeyType| - V0)
		serializationMatchTerms[246] = createSerializationMatchTermSubtract(78, 2);
		// 247: (|MappingCallCS::isInstall.'install'| - 1)
		serializationMatchTerms[247] = createSerializationMatchTermSubtract(80, 1);
		// 248: (|MappingCallCS::isInvoke.'invoke'| - 1)
		serializationMatchTerms[248] = createSerializationMatchTermSubtract(82, 1);
		// 249: (|MappingCallCS::ownedPathName| - 1)
		serializationMatchTerms[249] = createSerializationMatchTermSubtract(85, 1);
		// 250: (|MappingLoopCS::ownedInExpression| - 1)
		serializationMatchTerms[250] = createSerializationMatchTermSubtract(86, 1);
		// 251: (|MappingLoopCS::ownedIterator| - 1)
		serializationMatchTerms[251] = createSerializationMatchTermSubtract(87, 1);
		// 252: (|MultiplicityBoundsCS::lowerBound| - 1)
		serializationMatchTerms[252] = createSerializationMatchTermSubtract(90, 1);
		// 253: (|MultiplicityCS::isNullFree.'|1'| - 1)
		serializationMatchTerms[253] = createSerializationMatchTermSubtract(92, 1);
		// 254: (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1)
		serializationMatchTerms[254] = createSerializationMatchTermSubtract(94, 1);
		// 255: (|NamedElementCS::name| - 1)
		serializationMatchTerms[255] = createSerializationMatchTermSubtract(95, 1);
		// 256: (|NavigatingArgCS::ownedCoIterator| - 1)
		serializationMatchTerms[256] = createSerializationMatchTermSubtract(96, 1);
		// 257: (|NavigatingArgCS::ownedInitExpression| - 1)
		serializationMatchTerms[257] = createSerializationMatchTermSubtract(97, 1);
		// 258: (|NavigatingArgCS::ownedNameExpression| - 1)
		serializationMatchTerms[258] = createSerializationMatchTermSubtract(98, 1);
		// 259: (|NavigatingArgCS::ownedType| - 1)
		serializationMatchTerms[259] = createSerializationMatchTermSubtract(99, 1);
		// 260: (|NavigatingArgCS::prefix.','| - 1)
		serializationMatchTerms[260] = createSerializationMatchTermSubtract(100, 1);
		// 261: (|NavigatingArgCS::prefix.';'| - 1)
		serializationMatchTerms[261] = createSerializationMatchTermSubtract(101, 1);
		// 262: (|NavigatingArgCS::prefix.'|'| - 1)
		serializationMatchTerms[262] = createSerializationMatchTermSubtract(102, 1);
		// 263: (|NestedExpCS::ownedExpression| - 1)
		serializationMatchTerms[263] = createSerializationMatchTermSubtract(104, 1);
		// 264: (|NewStatementCS::referredTypedModel| - 1)
		serializationMatchTerms[264] = createSerializationMatchTermSubtract(107, 1);
		// 265: (|NumberLiteralExpCS::symbol| - 1)
		serializationMatchTerms[265] = createSerializationMatchTermSubtract(108, 1);
		// 266: (|ObservableStatementCS::observedProperties| - 1)
		serializationMatchTerms[266] = createSerializationMatchTermSubtract(109, 1);
		// 267: (|ObservableStatementCS::observedProperties| > 0)
		serializationMatchTerms[267] = createSerializationMatchTermGreaterThan(109, 0);
		// 268: (|OperationCS::ownedBodyExpressions| > 0)
		serializationMatchTerms[268] = createSerializationMatchTermGreaterThan(110, 0);
		// 269: (|OperationCS::ownedExceptions| - 1)
		serializationMatchTerms[269] = createSerializationMatchTermSubtract(111, 1);
		// 270: (|OperationCS::ownedExceptions| > 0)
		serializationMatchTerms[270] = createSerializationMatchTermGreaterThan(111, 0);
		// 271: (|OperationCS::ownedParameters| - 1)
		serializationMatchTerms[271] = createSerializationMatchTermSubtract(112, 1);
		// 272: (|OperationCS::ownedParameters| > 0)
		serializationMatchTerms[272] = createSerializationMatchTermGreaterThan(112, 0);
		// 273: (|OperatorExpCS::ownedRight| - 1)
		serializationMatchTerms[273] = createSerializationMatchTermSubtract(115, 1);
		// 274: (|PathElementCS::referredElement| - 1)
		serializationMatchTerms[274] = createSerializationMatchTermSubtract(120, 1);
		// 275: (|PathNameCS::ownedPathElements| - 1)
		serializationMatchTerms[275] = createSerializationMatchTermSubtract(121, 1);
		// 276: (|PatternExpCS::ownedPatternType| - 1)
		serializationMatchTerms[276] = createSerializationMatchTermSubtract(122, 1);
		// 277: (|PrimitiveTypeRefCS::name| - 1)
		serializationMatchTerms[277] = createSerializationMatchTermSubtract(124, 1);
		// 278: (|QueryCS::ownedExpression| - 1)
		serializationMatchTerms[278] = createSerializationMatchTermSubtract(127, 1);
		// 279: (|QueryCS::ownedParameters| - 1)
		serializationMatchTerms[279] = createSerializationMatchTermSubtract(128, 1);
		// 280: (|QueryCS::ownedParameters| > 0)
		serializationMatchTerms[280] = createSerializationMatchTermGreaterThan(128, 0);
		// 281: (|SetStatementCS::isPartial.'+='| - 1)
		serializationMatchTerms[281] = createSerializationMatchTermSubtract(135, 1);
		// 282: (|SetStatementCS::ownedExpression| - 1)
		serializationMatchTerms[282] = createSerializationMatchTermSubtract(137, 1);
		// 283: (|SetStatementCS::referredProperty| - 1)
		serializationMatchTerms[283] = createSerializationMatchTermSubtract(138, 1);
		// 284: (|SetStatementCS::referredVariable| - 1)
		serializationMatchTerms[284] = createSerializationMatchTermSubtract(139, 1);
		// 285: (|ShadowPartCS::ownedInitExpression| - 1)
		serializationMatchTerms[285] = createSerializationMatchTermSubtract(140, 1);
		// 286: (|ShadowPartCS::referredProperty| - 1)
		serializationMatchTerms[286] = createSerializationMatchTermSubtract(141, 1);
		// 287: (|SimpleParameterBindingCS::ownedValue| - 1)
		serializationMatchTerms[287] = createSerializationMatchTermSubtract(143, 1);
		// 288: (|SimpleParameterBindingCS::referredVariable| - 1)
		serializationMatchTerms[288] = createSerializationMatchTermSubtract(144, 1);
		// 289: (|SimpleParameterCS::referredTypedModel| - 1)
		serializationMatchTerms[289] = createSerializationMatchTermSubtract(145, 1);
		// 290: (|SimpleTargetElementCS::input.'input'| - 1)
		serializationMatchTerms[290] = createSerializationMatchTermSubtract(146, 1);
		// 291: (|SimpleTargetElementCS::iterates| - 1)
		serializationMatchTerms[291] = createSerializationMatchTermSubtract(148, 1);
		// 292: (|SimpleTargetElementCS::iterates| > 0)
		serializationMatchTerms[292] = createSerializationMatchTermGreaterThan(148, 0);
		// 293: (|SimpleTargetElementCS::output.'output'| - 1)
		serializationMatchTerms[293] = createSerializationMatchTermSubtract(149, 1);
		// 294: (|SimpleTargetElementCS::typedModel| - 1)
		serializationMatchTerms[294] = createSerializationMatchTermSubtract(151, 1);
		// 295: (|SimpleTargetElementCS::via.'via'| - 1)
		serializationMatchTerms[295] = createSerializationMatchTermSubtract(152, 1);
		// 296: (|SpecificationCS::exprString| - 1)
		serializationMatchTerms[296] = createSerializationMatchTermSubtract(154, 1);
		// 297: (|SpeculateStatementCS::ownedConditions| - 1)
		serializationMatchTerms[297] = createSerializationMatchTermSubtract(155, 1);
		// 298: (|SquareBracketedClauseCS::ownedTerms| - 1)
		serializationMatchTerms[298] = createSerializationMatchTermSubtract(156, 1);
		// 299: (|StructuralFeatureCS::ownedDefaultExpressions| > 0)
		serializationMatchTerms[299] = createSerializationMatchTermGreaterThan(159, 0);
		// 300: (|StructuredClassCS::isInterface.'interface'| > 0)
		serializationMatchTerms[300] = createSerializationMatchTermGreaterThan(161, 0);
		// 301: (|StructuredClassCS::ownedSuperTypes| - 1)
		serializationMatchTerms[301] = createSerializationMatchTermSubtract(165, 1);
		// 302: (|StructuredClassCS::ownedSuperTypes| > 0)
		serializationMatchTerms[302] = createSerializationMatchTermGreaterThan(165, 0);
		// 303: (|TemplateBindingCS::ownedSubstitutions| - 1)
		serializationMatchTerms[303] = createSerializationMatchTermSubtract(168, 1);
		// 304: (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1)
		serializationMatchTerms[304] = createSerializationMatchTermSubtract(169, 1);
		// 305: (|TemplateSignatureCS::ownedParameters| - 1)
		serializationMatchTerms[305] = createSerializationMatchTermSubtract(170, 1);
		// 306: (|TupleLiteralExpCS::ownedParts| - 1)
		serializationMatchTerms[306] = createSerializationMatchTermSubtract(177, 1);
		// 307: (|TupleTypeCS::name.'Tuple'| - 1)
		serializationMatchTerms[307] = createSerializationMatchTermSubtract(178, 1);
		// 308: (|TupleTypeCS::ownedParts| - 1)
		serializationMatchTerms[308] = createSerializationMatchTermSubtract(179, 1);
		// 309: (|TupleTypeCS::ownedParts| > 0)
		serializationMatchTerms[309] = createSerializationMatchTermGreaterThan(179, 0);
		// 310: (|TypeLiteralExpCS::ownedType| - 1)
		serializationMatchTerms[310] = createSerializationMatchTermSubtract(181, 1);
		// 311: (|TypeNameExpCS::ownedPathName| - 1)
		serializationMatchTerms[311] = createSerializationMatchTermSubtract(183, 1);
		// 312: (|TypeParameterCS::ownedExtends| - 1)
		serializationMatchTerms[312] = createSerializationMatchTermSubtract(185, 1);
		// 313: (|TypeParameterCS::ownedExtends| > 0)
		serializationMatchTerms[313] = createSerializationMatchTermGreaterThan(185, 0);
		// 314: (|TypedElementCS::ownedType| - 1)
		serializationMatchTerms[314] = createSerializationMatchTermSubtract(187, 1);
		// 315: (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[315] = createSerializationMatchTermGreaterThan(188, 0);
		// 316: (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0)
		serializationMatchTerms[316] = createSerializationMatchTermGreaterThan(189, 0);
		// 317: (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0)
		serializationMatchTerms[317] = createSerializationMatchTermGreaterThan(190, 0);
		// 318: (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0)
		serializationMatchTerms[318] = createSerializationMatchTermGreaterThan(191, 0);
		// 319: (|TypedElementCS::qualifiers.'definition'| - 1)
		serializationMatchTerms[319] = createSerializationMatchTermSubtract(192, 1);
		// 320: (|TypedElementCS::qualifiers.'static'| - 1)
		serializationMatchTerms[320] = createSerializationMatchTermSubtract(193, 1);
		// 321: (|TypedTypeRefCS::ownedPathName| - 1)
		serializationMatchTerms[321] = createSerializationMatchTermSubtract(198, 1);
		// 322: (|VariableCS::ownedInitExpression| - 1)
		serializationMatchTerms[322] = createSerializationMatchTermSubtract(199, 1);
	}

	/**
	 * Initialize the various serialization rules that serialize an EClass.
	 */
	private void initSerializationRules0() {
		// Base::FirstPathElementCS-0(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[0] = createSerializationRule("FirstPathElementCS-0", 38,
			createSerializationMatchSteps(
				54		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				339		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::MultiplicityBoundsCS-0(basecs::MultiplicityBoundsCS): { lowerBound=LOWER { ".." upperBound=UPPER }[?] }
		serializationRules[1] = createSerializationRule("MultiplicityBoundsCS-0", 67,
			createSerializationMatchSteps(
				99		/* assert |MultiplicityCS::isNullFree| == 0 */,
				163		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				39		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				32		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				181		/* '..' || no-space value no-space */,
				164		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-0(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "|?" "]" }
		serializationRules[2] = createSerializationRule("MultiplicityCS-0", 68,
			createSerializationMatchSteps(
				99		/* assert |MultiplicityCS::isNullFree| == 0 */,
				163		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				39		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				191		/* '[' || no-space value no-space */,
				32		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				181		/* '..' || no-space value no-space */,
				164		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				245		/* '|?' || no-space value no-space */,
				192		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-1(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } isNullFree?="|1" "]" }
		serializationRules[3] = createSerializationRule("MultiplicityCS-1", 68,
			createSerializationMatchSteps(
				40		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				163		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				39		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				191		/* '[' || no-space value no-space */,
				32		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				181		/* '..' || no-space value no-space */,
				164		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				20		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				192		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(30/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-2(basecs::MultiplicityBoundsCS): { "[" { lowerBound=LOWER { ".." upperBound=UPPER }[?] } "]" }
		serializationRules[4] = createSerializationRule("MultiplicityCS-2", 68,
			createSerializationMatchSteps(
				99		/* assert |MultiplicityCS::isNullFree| == 0 */,
				163		/* assign V0 = |MultiplicityBoundsCS::upperBound| */,
				39		/* assert (|MultiplicityBoundsCS::lowerBound| - 1) == 0 */
			),
			createSerializationSteps(
				191		/* '[' || no-space value no-space */,
				32		/* MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				181		/* '..' || no-space value no-space */,
				164		/* MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space */,
				192		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// Base::MultiplicityCS-3(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "|?" "]" }
		serializationRules[5] = createSerializationRule("MultiplicityCS-3", 68,
			createSerializationMatchSteps(
				99		/* assert |MultiplicityCS::isNullFree| == 0 */,
				41		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				191		/* '[' || no-space value no-space */,
				157		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				245		/* '|?' || no-space value no-space */,
				192		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-4(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} isNullFree?="|1" "]" }
		serializationRules[6] = createSerializationRule("MultiplicityCS-4", 68,
			createSerializationMatchSteps(
				40		/* assert (|MultiplicityCS::isNullFree.'|1'| - 1) == 0 */,
				41		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				191		/* '[' || no-space value no-space */,
				157		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				20		/* MultiplicityCS::isNullFree?='|1' || no-space value no-space */,
				192		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, false,
					(30/*'|1'*/ << 4) | 0 /*[1]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityCS-5(basecs::MultiplicityStringCS): { "[" stringBounds={'*|+|?'} "]" }
		serializationRules[7] = createSerializationRule("MultiplicityCS-5", 68,
			createSerializationMatchSteps(
				99		/* assert |MultiplicityCS::isNullFree| == 0 */,
				41		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				191		/* '[' || no-space value no-space */,
				157		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */,
				192		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::MultiplicityStringCS-0(basecs::MultiplicityStringCS): stringBounds={'*|+|?'}
		serializationRules[8] = createSerializationRule("MultiplicityStringCS-0", 69,
			createSerializationMatchSteps(
				99		/* assert |MultiplicityCS::isNullFree| == 0 */,
				41		/* assert (|MultiplicityStringCS::stringBounds.'*|+|?'| - 1) == 0 */
			),
			createSerializationSteps(
				157		/* MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, false,
					(4/*'*|+|?'*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::NextPathElementCS-0(basecs::PathElementCS): referredElement=UnreservedName
		serializationRules[9] = createSerializationRule("NextPathElementCS-0", 80,
			createSerializationMatchSteps(
				54		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				338		/* PathElementCS::referredElement=UnreservedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// Base::PathNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[10] = createSerializationRule("PathNameCS-0", 86,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				321		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				251		/* V00*2-steps || value */,
				183		/* '::' || no-space value no-space */,
				322		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 24/* FirstPathElementCS,NextPathElementCS */,
					(38/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(80/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TemplateBindingCS-0(basecs::TemplateBindingCS): { ownedSubstitutions+=TemplateParameterSubstitutionCS { "," ownedSubstitutions+=TemplateParameterSubstitutionCS }[*] ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[11] = createSerializationRule("TemplateBindingCS-0", 120,
			createSerializationMatchSteps(
				304		/* check-rule basecs::TemplateBindingCS.ownedMultiplicity : MultiplicityCS */,
				305		/* check-rule basecs::TemplateBindingCS.ownedSubstitutions : TemplateParameterSubstitutionCS */,
				210		/* assign V1 = |TemplateBindingCS::ownedMultiplicity| */,
				142		/* assign V0 = (|TemplateBindingCS::ownedSubstitutions| - 1) */
			),
			createSerializationSteps(
				121		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				251		/* V00*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				121		/* TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value */,
				258		/* V01*1-steps || value */,
				90		/* TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 53/* TemplateParameterSubstitutionCS */,
					(121/*TemplateParameterSubstitutionCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TemplateParameterSubstitutionCS-0(basecs::TemplateParameterSubstitutionCS): ownedActualParameter=TypeRefCS
		serializationRules[12] = createSerializationRule("TemplateParameterSubstitutionCS-0", 121,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				306		/* check-rule basecs::TemplateParameterSubstitutionCS.ownedActualParameter : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypeRefCS|TypedRefCS|TypedTypeRefCS|WildcardTypeRefCS */,
				73		/* assert (|TemplateParameterSubstitutionCS::ownedActualParameter| - 1) == 0 */
			),
			createSerializationSteps(
				42		/* TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 66/* TypeRefCS */,
					(136/*TypeRefCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::TemplateSignatureCS-0(basecs::TemplateSignatureCS): { "(" ownedParameters+=TypeParameterCS { "," ownedParameters+=TypeParameterCS }[*] ")" }
		serializationRules[13] = createSerializationRule("TemplateSignatureCS-0", 122,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				307		/* check-rule basecs::TemplateSignatureCS.ownedParameters : TypeParameterCS */,
				143		/* assign V0 = (|TemplateSignatureCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				173		/* '(' || no-space value no-space */,
				99		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				251		/* V00*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				99		/* TemplateSignatureCS::ownedParameters+=TypeParameterCS || value */,
				174		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 65/* TypeParameterCS */,
					(135/*TypeParameterCS*/ << 4) | 3 /*[+]*/
				)
			});
		// Base::TypeParameterCS-0(basecs::TypeParameterCS): { name=UnrestrictedName { "extends" ownedExtends+=TypedRefCS { "&&" ownedExtends+=TypedRefCS }[*] }[?] }
		serializationRules[14] = createSerializationRule("TypeParameterCS-0", 135,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				310		/* check-rule basecs::TypeParameterCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				146		/* assign V0 = (|TypeParameterCS::ownedExtends| > 0) */,
				197		/* assign V1 = (|TypeParameterCS::ownedExtends| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				210		/* 'extends' || soft-space value soft-space */,
				72		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */,
				261		/* V01*2-steps || value */,
				172		/* '&&' || soft-space value soft-space */,
				72		/* TypeParameterCS::ownedExtends+=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// Base::TypedTypeRefCS-0(basecs::TypedTypeRefCS): { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] }
		serializationRules[15] = createSerializationRule("TypedTypeRefCS-0", 139,
			createSerializationMatchSteps(
				131		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				130		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				314		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				315		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				184		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				80		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				112		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				252		/* V00*3-steps || value */,
				173		/* '(' || no-space value no-space */,
				43		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				174		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 52/* TemplateBindingCS */,
					(120/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// Base::WildcardTypeRefCS-0(basecs::WildcardTypeRefCS): { "?" { "extends" ownedExtends=TypedRefCS }[?] }
		serializationRules[16] = createSerializationRule("WildcardTypeRefCS-0", 150,
			createSerializationMatchSteps(
				133		/* assert |WildcardTypeRefCS::ownedSuper| == 0 */,
				316		/* check-rule basecs::WildcardTypeRefCS.ownedExtends : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				186		/* assign V0 = |WildcardTypeRefCS::ownedExtends| */
			),
			createSerializationSteps(
				188		/* '?' || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				210		/* 'extends' || soft-space value soft-space */,
				73		/* WildcardTypeRefCS::ownedExtends=TypedRefCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::BooleanLiteralExpCS-0(essentialoclcs::BooleanLiteralExpCS): symbol={'false|true'}
		serializationRules[17] = createSerializationRule("BooleanLiteralExpCS-0", 6,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				5		/* assert (|BooleanLiteralExpCS::symbol.'false|true'| - 1) == 0 */
			),
			createSerializationSteps(
				159		/* BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, false,
					(16/*'false|true'*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CoIteratorVariableCS-0(essentialoclcs::VariableCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] }
		serializationRules[18] = createSerializationRule("CoIteratorVariableCS-0", 10,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				132		/* assert |VariableCS::ownedInitExpression| == 0 */,
				368		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				185		/* assign V0 = |VariableCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				135		/* VariableCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralExpCS-0(essentialoclcs::CollectionLiteralExpCS): { ownedType=CollectionTypeCS "{" { ownedParts+=CollectionLiteralPartCS { "," ownedParts+=CollectionLiteralPartCS }[*] }[?] "}" }
		serializationRules[19] = createSerializationRule("CollectionLiteralExpCS-0", 11,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				321		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedParts : CollectionLiteralPartCS */,
				322		/* check-rule essentialoclcs::CollectionLiteralExpCS.ownedType : CollectionTypeCS */,
				7		/* assert (|CollectionLiteralExpCS::ownedType| - 1) == 0 */,
				134		/* assign V0 = (|CollectionLiteralExpCS::ownedParts| > 0) */,
				187		/* assign V1 = (|CollectionLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				129		/* CollectionLiteralExpCS::ownedType=CollectionTypeCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				253		/* V00*4-steps || value */,
				100		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				100		/* CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 1/* CollectionLiteralPartCS */,
					(12/*CollectionLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(14/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-0(essentialoclcs::CollectionLiteralPartCS): { ownedExpression=ExpCS { ".." ownedLastExpression=ExpCS }[?] }
		serializationRules[20] = createSerializationRule("CollectionLiteralPartCS-0", 12,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				323		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				325		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedLastExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				150		/* assign V0 = |CollectionLiteralPartCS::ownedLastExpression| */,
				8		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				62		/* CollectionLiteralPartCS::ownedExpression=ExpCS || value */,
				250		/* V00*2-steps || value */,
				181		/* '..' || no-space value no-space */,
				85		/* CollectionLiteralPartCS::ownedLastExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CollectionLiteralPartCS-1(essentialoclcs::CollectionLiteralPartCS): ownedExpression=PatternExpCS
		serializationRules[21] = createSerializationRule("CollectionLiteralPartCS-1", 12,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				85		/* assert |CollectionLiteralPartCS::ownedLastExpression| == 0 */,
				324		/* check-rule essentialoclcs::CollectionLiteralPartCS.ownedExpression : PatternExpCS */,
				8		/* assert (|CollectionLiteralPartCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				63		/* CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 29/* PatternExpCS */,
					(87/*PatternExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionPatternCS-0(essentialoclcs::CollectionPatternCS): { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" }
		serializationRules[22] = createSerializationRule("CollectionPatternCS-0", 13,
			createSerializationMatchSteps(
				130		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				86		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				326		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				327		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				151		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				188		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				9		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				130		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				255		/* V00*6-steps || value */,
				101		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				101		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				177		/* '++' || soft-space value soft-space */,
				155		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 29/* PatternExpCS */,
					(87/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(14/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::CollectionTypeCS-0(essentialoclcs::CollectionTypeCS): { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] }
		serializationRules[23] = createSerializationRule("CollectionTypeCS-0", 14,
			createSerializationMatchSteps(
				130		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				329		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				152		/* assign V0 = |CollectionTypeCS::ownedType| */,
				10		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				202		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				33		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				131		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				258		/* V01*1-steps || value */,
				48		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				174		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(130/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::CurlyBracketedClauseCS-0(essentialoclcs::CurlyBracketedClauseCS): { "{" { ownedParts+=ShadowPartCS { "," ownedParts+=ShadowPartCS }[*] }[?] "}" }
		serializationRules[24] = createSerializationRule("CurlyBracketedClauseCS-0", 19,
			createSerializationMatchSteps(
				87		/* assert |CurlyBracketedClauseCS::value| == 0 */,
				331		/* check-rule essentialoclcs::CurlyBracketedClauseCS.ownedParts : ShadowPartCS */,
				135		/* assign V0 = (|CurlyBracketedClauseCS::ownedParts| > 0) */,
				189		/* assign V1 = (|CurlyBracketedClauseCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				244		/* '{' || soft-space value push soft-new-line */,
				253		/* V00*4-steps || value */,
				102		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				102		/* CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 39/* ShadowPartCS */,
					(107/*ShadowPartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::ElseIfThenExpCS-0(essentialoclcs::IfThenExpCS): { "elseif" ownedCondition=ExpCS "then" ownedThenExpression=ExpCS }
		serializationRules[25] = createSerializationRule("ElseIfThenExpCS-0", 26,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				337		/* check-rule essentialoclcs::IfThenExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				338		/* check-rule essentialoclcs::IfThenExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				21		/* assert (|IfThenExpCS::ownedThenExpression| - 1) == 0 */,
				20		/* assert (|IfThenExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				206		/* 'elseif' || soft-space value soft-space */,
				51		/* IfThenExpCS::ownedCondition=ExpCS || value */,
				239		/* 'then' || soft-space value soft-space */,
				127		/* IfThenExpCS::ownedThenExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::ExpCS-18(essentialoclcs::InfixExpCS): { ownedLeft=PrefixedPrimaryExpCS { name=BinaryOperatorName ownedRight=ExpCS } }
		serializationRules[26] = createSerializationRule("ExpCS-18", 37,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				339		/* check-rule essentialoclcs::InfixExpCS.ownedLeft : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				356		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				53		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				23		/* assert (|InfixExpCS::ownedLeft| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				86		/* InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value */,
				317		/* NamedElementCS::name=BinaryOperatorName || soft-space value soft-space */,
				323		/* OperatorExpCS::ownedRight=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 33/* PrefixedPrimaryExpCS */,
					(89/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::IfExpCS-0(essentialoclcs::IfExpCS): { "if" ownedCondition=(ExpCS|PatternExpCS) "then" ownedThenExpression=ExpCS ownedIfThenExpressions+=ElseIfThenExpCS[*] "else" ownedElseExpression=ExpCS "endif" }
		serializationRules[27] = createSerializationRule("IfExpCS-0", 45,
			createSerializationMatchSteps(
				93		/* assert |IfExpCS::isImplicit| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				333		/* check-rule essentialoclcs::IfExpCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				334		/* check-rule essentialoclcs::IfExpCS.ownedElseExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				335		/* check-rule essentialoclcs::IfExpCS.ownedIfThenExpressions : ElseIfThenExpCS */,
				336		/* check-rule essentialoclcs::IfExpCS.ownedThenExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				18		/* assert (|IfExpCS::ownedElseExpression| - 1) == 0 */,
				158		/* assign V0 = |IfExpCS::ownedIfThenExpressions| */,
				19		/* assert (|IfExpCS::ownedThenExpression| - 1) == 0 */,
				17		/* assert (|IfExpCS::ownedCondition| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				213		/* 'if' || soft-space value soft-space */,
				50		/* IfExpCS::ownedCondition=ExpCS|PatternExpCS || value */,
				239		/* 'then' || soft-space value soft-space */,
				126		/* IfExpCS::ownedThenExpression=ExpCS || value */,
				248		/* V00*1-steps || value */,
				74		/* IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value */,
				205		/* 'else' || soft-space value soft-space */,
				58		/* IfExpCS::ownedElseExpression=ExpCS || value */,
				207		/* 'endif' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, 30/* ExpCS,PatternExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/,
					(87/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 6/* ElseIfThenExpCS */,
					(26/*ElseIfThenExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::InvalidLiteralExpCS-0(essentialoclcs::InvalidLiteralExpCS): "invalid"
		serializationRules[28] = createSerializationRule("InvalidLiteralExpCS-0", 48,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				220		/* 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::LambdaLiteralExpCS-0(essentialoclcs::LambdaLiteralExpCS): { "Lambda" "{" ownedExpressionCS=ExpCS "}" }
		serializationRules[29] = createSerializationRule("LambdaLiteralExpCS-0", 51,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				340		/* check-rule essentialoclcs::LambdaLiteralExpCS.ownedExpressionCS : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				25		/* assert (|LambdaLiteralExpCS::ownedExpressionCS| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				189		/* 'Lambda' || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				71		/* LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::LetExpCS-0(essentialoclcs::LetExpCS): { "let" ownedVariables+=LetVariableCS { "," ownedVariables+=LetVariableCS }[*] "in" ownedInExpression=ExpCS }
		serializationRules[30] = createSerializationRule("LetExpCS-0", 52,
			createSerializationMatchSteps(
				95		/* assert |LetExpCS::isImplicit| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				341		/* check-rule essentialoclcs::LetExpCS.ownedInExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				342		/* check-rule essentialoclcs::LetExpCS.ownedVariables : LetVariableCS */,
				26		/* assert (|LetExpCS::ownedInExpression| - 1) == 0 */,
				136		/* assign V0 = (|LetExpCS::ownedVariables| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				222		/* 'let' || soft-space value soft-space */,
				139		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				251		/* V00*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				139		/* LetExpCS::ownedVariables+=LetVariableCS || value */,
				217		/* 'in' || soft-space value soft-space */,
				76		/* LetExpCS::ownedInExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 12/* LetVariableCS */,
					(53/*LetVariableCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::LetVariableCS-0(essentialoclcs::LetVariableCS): { name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS[?] { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[31] = createSerializationRule("LetVariableCS-0", 53,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				367		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				343		/* check-rule essentialoclcs::LetVariableCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				368		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				81		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				216		/* assign V1 = |VariableCS::ownedType| */,
				159		/* assign V0 = |LetVariableCS::ownedRoundBracketedClause| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				118		/* LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				135		/* VariableCS::ownedType=TypeExpCS || value */,
				187		/* '=' || soft-space value soft-space */,
				81		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 36/* RoundBracketedClauseCS */,
					(99/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::MapLiteralExpCS-0(essentialoclcs::MapLiteralExpCS): { ownedType=MapTypeCS "{" { ownedParts+=MapLiteralPartCS { "," ownedParts+=MapLiteralPartCS }[*] }[?] "}" }
		serializationRules[32] = createSerializationRule("MapLiteralExpCS-0", 57,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				344		/* check-rule essentialoclcs::MapLiteralExpCS.ownedParts : MapLiteralPartCS */,
				345		/* check-rule essentialoclcs::MapLiteralExpCS.ownedType : MapTypeCS */,
				29		/* assert (|MapLiteralExpCS::ownedType| - 1) == 0 */,
				137		/* assign V0 = (|MapLiteralExpCS::ownedParts| > 0) */,
				191		/* assign V1 = (|MapLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				132		/* MapLiteralExpCS::ownedType=MapTypeCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				253		/* V00*4-steps || value */,
				103		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				103		/* MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 13/* MapLiteralPartCS */,
					(58/*MapLiteralPartCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 14/* MapTypeCS */,
					(59/*MapTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapLiteralPartCS-0(essentialoclcs::MapLiteralPartCS): { ownedKey=ExpCS "<-" ownedValue=ExpCS }
		serializationRules[33] = createSerializationRule("MapLiteralPartCS-0", 58,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				346		/* check-rule essentialoclcs::MapLiteralPartCS.ownedKey : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				347		/* check-rule essentialoclcs::MapLiteralPartCS.ownedValue : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				31		/* assert (|MapLiteralPartCS::ownedValue| - 1) == 0 */,
				30		/* assert (|MapLiteralPartCS::ownedKey| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				83		/* MapLiteralPartCS::ownedKey=ExpCS || value */,
				186		/* '<-' || soft-space value soft-space */,
				136		/* MapLiteralPartCS::ownedValue=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::MapTypeCS-0(essentialoclcs::MapTypeCS): { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] }
		serializationRules[34] = createSerializationRule("MapTypeCS-0", 59,
			createSerializationMatchSteps(
				130		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				348		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				349		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				161		/* assign V0 = |MapTypeCS::ownedValueType| */,
				33		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				32		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				34		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				84		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				179		/* ',' || no-space value soft-space */,
				138		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				174		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::Model-0(essentialoclcs::ContextCS): ownedExpression=ExpCS
		serializationRules[35] = createSerializationRule("Model-0", 66,
			createSerializationMatchSteps(
				100		/* assert |NamedElementCS::name| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				114		/* assert |RootCS::ownedImports| == 0 */,
				330		/* check-rule essentialoclcs::ContextCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				11		/* assert (|ContextCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				64		/* ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NameExpCS-0(essentialoclcs::NameExpCS): { ownedPathName=PathNameCS ownedSquareBracketedClauses+=SquareBracketedClauseCS[*] ownedRoundBracketedClause=RoundBracketedClauseCS[?] ownedCurlyBracketedClause=CurlyBracketedClauseCS[?] { isPre?="@" "pre" }[?] }
		serializationRules[36] = createSerializationRule("NameExpCS-0", 71,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				317		/* check-rule essentialoclcs::AbstractNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				318		/* check-rule essentialoclcs::AbstractNameExpCS.ownedPathName : PathNameCS */,
				319		/* check-rule essentialoclcs::AbstractNameExpCS.ownedRoundBracketedClause : RoundBracketedClauseCS */,
				320		/* check-rule essentialoclcs::AbstractNameExpCS.ownedSquareBracketedClauses : SquareBracketedClauseCS */,
				247		/* assign V3 = |AbstractNameExpCS::isPre.'@'| */,
				227		/* assign V2 = |AbstractNameExpCS::ownedCurlyBracketedClause| */,
				199		/* assign V1 = |AbstractNameExpCS::ownedRoundBracketedClause| */,
				147		/* assign V0 = |AbstractNameExpCS::ownedSquareBracketedClauses| */,
				0		/* assert (|AbstractNameExpCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				106		/* AbstractNameExpCS::ownedPathName=PathNameCS || value */,
				248		/* V00*1-steps || value */,
				120		/* AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value */,
				258		/* V01*1-steps || value */,
				117		/* AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value */,
				266		/* V02*1-steps || value */,
				54		/* AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				277		/* V03*2-steps || value */,
				22		/* AbstractNameExpCS::isPre?='@' || soft-space value soft-space */,
				231		/* 'pre' || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, false,
					(9/*'@'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(19/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 36/* RoundBracketedClauseCS */,
					(99/*RoundBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 47/* SquareBracketedClauseCS */,
					(114/*SquareBracketedClauseCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-0(essentialoclcs::NavigatingArgCS): { ":" ownedType=TypeExpCS }
		serializationRules[37] = createSerializationRule("NavigatingArgCS-0", 72,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				102		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				103		/* assert |NavigatingArgCS::ownedNameExpression| == 0 */,
				105		/* assert |NavigatingArgCS::prefix| == 0 */,
				353		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				46		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				182		/* ':' || soft-space value soft-space */,
				133		/* NavigatingArgCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-1(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "<-" ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[38] = createSerializationRule("NavigatingArgCS-1", 72,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				105		/* assert |NavigatingArgCS::prefix| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				353		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				205		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				165		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				46		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				182		/* ':' || soft-space value soft-space */,
				133		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				250		/* V00*2-steps || value */,
				186		/* '<-' || soft-space value soft-space */,
				47		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				260		/* V01*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(10/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-2(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { "<-" ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[39] = createSerializationRule("NavigatingArgCS-2", 72,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				104		/* assert |NavigatingArgCS::ownedType| == 0 */,
				105		/* assert |NavigatingArgCS::prefix| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				166		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				43		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				186		/* '<-' || soft-space value soft-space */,
				47		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				250		/* V00*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(10/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-3(essentialoclcs::NavigatingArgCS): { ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { "<-" ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[40] = createSerializationRule("NavigatingArgCS-3", 72,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				105		/* assert |NavigatingArgCS::prefix| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				353		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				44		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				204		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				167		/* assign V0 = |NavigatingArgCS::ownedType| */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				133		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				260		/* V01*2-steps || value */,
				186		/* '<-' || soft-space value soft-space */,
				47		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				217		/* 'in' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(10/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingArgCS-4(essentialoclcs::NavigatingArgCS): ownedNameExpression=NavigatingArgExpCS
		serializationRules[41] = createSerializationRule("NavigatingArgCS-4", 72,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				102		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				104		/* assert |NavigatingArgCS::ownedType| == 0 */,
				105		/* assert |NavigatingArgCS::prefix| == 0 */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */
			),
			createSerializationSteps(
				93		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingBarArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="|" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[42] = createSerializationRule("NavigatingBarArgCS-0", 74,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				353		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				167		/* assign V0 = |NavigatingArgCS::ownedType| */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				49		/* assert (|NavigatingArgCS::prefix.'|'| - 1) == 0 */,
				205		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				143		/* NavigatingArgCS::prefix='|' || soft-space value soft-space */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				254		/* V00*5-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				133		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				260		/* V01*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(29/*'|'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-0(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "<-" ownedCoIterator=CoIteratorVariableCS }[?] { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[43] = createSerializationRule("NavigatingCommaArgCS-0", 75,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				353		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				205		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */,
				165		/* assign V0 = |NavigatingArgCS::ownedCoIterator| */,
				46		/* assert (|NavigatingArgCS::ownedType| - 1) == 0 */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				47		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				142		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				182		/* ':' || soft-space value soft-space */,
				133		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				250		/* V00*2-steps || value */,
				186		/* '<-' || soft-space value soft-space */,
				47		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				260		/* V01*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(10/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-1(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { "<-" ownedCoIterator=CoIteratorVariableCS { "=" ownedInitExpression=ExpCS }[?] } }
		serializationRules[44] = createSerializationRule("NavigatingCommaArgCS-1", 75,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				104		/* assert |NavigatingArgCS::ownedType| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				166		/* assign V0 = |NavigatingArgCS::ownedInitExpression| */,
				43		/* assert (|NavigatingArgCS::ownedCoIterator| - 1) == 0 */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				47		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				142		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				186		/* '<-' || soft-space value soft-space */,
				47		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				250		/* V00*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(10/*CoIteratorVariableCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-2(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS { { ":" ownedType=TypeExpCS }[?] { "<-" ownedCoIterator=CoIteratorVariableCS }[?] "in" ownedInitExpression=ExpCS } }
		serializationRules[45] = createSerializationRule("NavigatingCommaArgCS-2", 75,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				350		/* check-rule essentialoclcs::NavigatingArgCS.ownedCoIterator : CoIteratorVariableCS */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				353		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				44		/* assert (|NavigatingArgCS::ownedInitExpression| - 1) == 0 */,
				204		/* assign V1 = |NavigatingArgCS::ownedCoIterator| */,
				167		/* assign V0 = |NavigatingArgCS::ownedType| */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				47		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				142		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				133		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				260		/* V01*2-steps || value */,
				186		/* '<-' || soft-space value soft-space */,
				47		/* NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value */,
				217		/* 'in' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 0/* CoIteratorVariableCS */,
					(10/*CoIteratorVariableCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NavigatingCommaArgCS-3(essentialoclcs::NavigatingArgCS): { prefix="," ownedNameExpression=NavigatingArgExpCS }
		serializationRules[46] = createSerializationRule("NavigatingCommaArgCS-3", 75,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				102		/* assert |NavigatingArgCS::ownedInitExpression| == 0 */,
				104		/* assert |NavigatingArgCS::ownedType| == 0 */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				47		/* assert (|NavigatingArgCS::prefix.','| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				142		/* NavigatingArgCS::prefix=',' || no-space value soft-space */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(6/*','*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NavigatingSemiArgCS-0(essentialoclcs::NavigatingArgCS): { prefix=";" ownedNameExpression=NavigatingArgExpCS { ":" ownedType=TypeExpCS { "=" ownedInitExpression=ExpCS }[?] }[?] }
		serializationRules[47] = createSerializationRule("NavigatingSemiArgCS-0", 76,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				101		/* assert |NavigatingArgCS::ownedCoIterator| == 0 */,
				351		/* check-rule essentialoclcs::NavigatingArgCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				352		/* check-rule essentialoclcs::NavigatingArgCS.ownedNameExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NavigatingArgExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				353		/* check-rule essentialoclcs::NavigatingArgCS.ownedType : TypeExpCS */,
				167		/* assign V0 = |NavigatingArgCS::ownedType| */,
				45		/* assert (|NavigatingArgCS::ownedNameExpression| - 1) == 0 */,
				48		/* assert (|NavigatingArgCS::prefix.';'| - 1) == 0 */,
				205		/* assign V1 = |NavigatingArgCS::ownedInitExpression| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				141		/* NavigatingArgCS::prefix=';' || no-space value soft-new-line */,
				92		/* NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value */,
				254		/* V00*5-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				133		/* NavigatingArgCS::ownedType=TypeExpCS || value */,
				260		/* V01*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				78		/* NavigatingArgCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, false,
					(8/*';'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 21/* NavigatingArgExpCS */,
					(73/*NavigatingArgExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::NestedExpCS-0(essentialoclcs::NestedExpCS): { "(" ownedExpression=ExpCS ")" }
		serializationRules[48] = createSerializationRule("NestedExpCS-0", 78,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				354		/* check-rule essentialoclcs::NestedExpCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				50		/* assert (|NestedExpCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				173		/* '(' || no-space value no-space */,
				67		/* NestedExpCS::ownedExpression=ExpCS || value */,
				174		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::NullLiteralExpCS-0(essentialoclcs::NullLiteralExpCS): "null"
		serializationRules[49] = createSerializationRule("NullLiteralExpCS-0", 81,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				226		/* 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::NumberLiteralExpCS-0(essentialoclcs::NumberLiteralExpCS): symbol=NUMBER_LITERAL
		serializationRules[50] = createSerializationRule("NumberLiteralExpCS-0", 82,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				52		/* assert (|NumberLiteralExpCS::symbol| - 1) == 0 */
			),
			createSerializationSteps(
				160		/* NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::PatternExpCS-0(essentialoclcs::PatternExpCS): { patternVariableName=UnrestrictedName[?] ":" ownedPatternType=TypeExpCS }
		serializationRules[51] = createSerializationRule("PatternExpCS-0", 87,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				358		/* check-rule essentialoclcs::PatternExpCS.ownedPatternType : TypeExpCS */,
				56		/* assert (|PatternExpCS::ownedPatternType| - 1) == 0 */,
				168		/* assign V0 = |PatternExpCS::patternVariableName| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				140		/* PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				114		/* PatternExpCS::ownedPatternType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedLetExpCS-1(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedLetExpCS }
		serializationRules[52] = createSerializationRule("PrefixedLetExpCS-1", 88,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				355		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : LetExpCS|PrefixedLetExpCS */,
				53		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				312		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				324		/* OperatorExpCS::ownedRight=PrefixedLetExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 31/* PrefixedLetExpCS */,
					(88/*PrefixedLetExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrefixedPrimaryExpCS-15(essentialoclcs::PrefixExpCS): { name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS }
		serializationRules[53] = createSerializationRule("PrefixedPrimaryExpCS-15", 89,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				357		/* check-rule essentialoclcs::OperatorExpCS.ownedRight : BooleanLiteralExpCS|CollectionLiteralExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				53		/* assert (|OperatorExpCS::ownedRight| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				312		/* NamedElementCS::name=UnaryOperatorName || soft-space value soft-space */,
				325		/* OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 33/* PrefixedPrimaryExpCS */,
					(89/*PrefixedPrimaryExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::PrimitiveTypeCS-0(basecs::PrimitiveTypeRefCS): name=PrimitiveTypeIdentifier
		serializationRules[54] = createSerializationRule("PrimitiveTypeCS-0", 92,
			createSerializationMatchSteps(
				130		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				57		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				35		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE)
			});
		// EssentialOCL::RoundBracketedClauseCS-0(essentialoclcs::RoundBracketedClauseCS): { "(" { ownedArguments+=NavigatingArgCS ownedArguments+=(NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS)[*] }[?] ")" }
		serializationRules[55] = createSerializationRule("RoundBracketedClauseCS-0", 99,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				173		/* '(' || no-space value no-space */,
				252		/* V00*3-steps || value */,
				318		/* RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value */,
				259		/* V01*1-steps || value */,
				319		/* RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value */,
				174		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 23/* NavigatingArgCS,NavigatingBarArgCS,NavigatingCommaArgCS,NavigatingSemiArgCS */,
					(72/*NavigatingArgCS*/ << 4) | 1 /*[?]*/,
					(74/*NavigatingBarArgCS*/ << 4) | 2 /*[*]*/,
					(75/*NavigatingCommaArgCS*/ << 4) | 2 /*[*]*/,
					(76/*NavigatingSemiArgCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::SelfExpCS-0(essentialoclcs::SelfExpCS): "self"
		serializationRules[56] = createSerializationRule("SelfExpCS-0", 105,
			createSerializationMatchSteps(
				115		/* assert |SelfExpCS::name| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				234		/* 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// EssentialOCL::ShadowPartCS-0(essentialoclcs::ShadowPartCS): { referredProperty=UnrestrictedName "=" ownedInitExpression=(ExpCS|PatternExpCS) }
		serializationRules[57] = createSerializationRule("ShadowPartCS-0", 107,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				360		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PatternExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				63		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */,
				64		/* assert (|ShadowPartCS::referredProperty| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				146		/* ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space */,
				187		/* '=' || soft-space value soft-space */,
				79		/* ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 30/* ExpCS,PatternExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/,
					(87/*PatternExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, -1
				)
			});
		// EssentialOCL::ShadowPartCS-1(essentialoclcs::ShadowPartCS): ownedInitExpression=StringLiteralExpCS
		serializationRules[58] = createSerializationRule("ShadowPartCS-1", 107,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				117		/* assert |ShadowPartCS::referredProperty| == 0 */,
				359		/* check-rule essentialoclcs::ShadowPartCS.ownedInitExpression : StringLiteralExpCS */,
				63		/* assert (|ShadowPartCS::ownedInitExpression| - 1) == 0 */
			),
			createSerializationSteps(
				80		/* ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 48/* StringLiteralExpCS */,
					(116/*StringLiteralExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SimplePathNameCS-0(basecs::PathNameCS): ownedPathElements+=FirstPathElementCS
		serializationRules[59] = createSerializationRule("SimplePathNameCS-0", 110,
			createSerializationMatchSteps(
				298		/* check-rule basecs::PathNameCS.ownedPathElements : FirstPathElementCS */,
				55		/* assert (|PathNameCS::ownedPathElements| - 1) == 0 */
			),
			createSerializationSteps(
				321		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 9/* FirstPathElementCS */,
					(38/*FirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::SquareBracketedClauseCS-0(essentialoclcs::SquareBracketedClauseCS): { "[" ownedTerms+=ExpCS { "," ownedTerms+=ExpCS }[*] "]" }
		serializationRules[60] = createSerializationRule("SquareBracketedClauseCS-0", 114,
			createSerializationMatchSteps(
				361		/* check-rule essentialoclcs::SquareBracketedClauseCS.ownedTerms : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				141		/* assign V0 = (|SquareBracketedClauseCS::ownedTerms| - 1) */
			),
			createSerializationSteps(
				191		/* '[' || no-space value no-space */,
				125		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				251		/* V00*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				125		/* SquareBracketedClauseCS::ownedTerms+=ExpCS || value */,
				192		/* ']' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::StringLiteralExpCS-0(essentialoclcs::StringLiteralExpCS): segments+=StringLiteral[+]
		serializationRules[61] = createSerializationRule("StringLiteralExpCS-0", 116,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				175		/* assign V0 = |StringLiteralExpCS::segments| */
			),
			createSerializationSteps(
				249		/* V00*1-steps || value */,
				156		/* StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, false, GrammarCardinality.ONE_OR_MORE)
			});
		// EssentialOCL::TupleLiteralExpCS-0(essentialoclcs::TupleLiteralExpCS): { "Tuple" "{" ownedParts+=TupleLiteralPartCS { "," ownedParts+=TupleLiteralPartCS }[*] "}" }
		serializationRules[62] = createSerializationRule("TupleLiteralExpCS-0", 125,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				362		/* check-rule essentialoclcs::TupleLiteralExpCS.ownedParts : TupleLiteralPartCS */,
				144		/* assign V0 = (|TupleLiteralExpCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				190		/* 'Tuple' || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				104		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				251		/* V00*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				104		/* TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 58/* TupleLiteralPartCS */,
					(126/*TupleLiteralPartCS*/ << 4) | 3 /*[+]*/
				)
			});
		// EssentialOCL::TupleLiteralPartCS-0(essentialoclcs::TupleLiteralPartCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] "=" ownedInitExpression=ExpCS }
		serializationRules[63] = createSerializationRule("TupleLiteralPartCS-0", 126,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				367		/* check-rule essentialoclcs::VariableCS.ownedInitExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				368		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				81		/* assert (|VariableCS::ownedInitExpression| - 1) == 0 */,
				185		/* assign V0 = |VariableCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				135		/* VariableCS::ownedType=TypeExpCS || value */,
				187		/* '=' || soft-space value soft-space */,
				81		/* VariableCS::ownedInitExpression=ExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
	}
	private void initSerializationRules1() {
		// EssentialOCL::TuplePartCS-0(basecs::TuplePartCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[64] = createSerializationRule("TuplePartCS-0", 127,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TupleTypeCS-0(basecs::TupleTypeCS): { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] }
		serializationRules[65] = createSerializationRule("TupleTypeCS-0", 128,
			createSerializationMatchSteps(
				130		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				309		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				74		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				145		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				196		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				224		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				36		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				256		/* V00*7-steps || value */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				174		/* ')' || no-space value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/* TuplePartCS */,
					(127/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeExpCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[66] = createSerializationRule("TypeExpCS-0", 129,
			createSerializationMatchSteps(
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				183		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				57		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				35		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[67] = createSerializationRule("TypeExpCS-1", 129,
			createSerializationMatchSteps(
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				329		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				241		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				152		/* assign V0 = |CollectionTypeCS::ownedType| */,
				10		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				202		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				33		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				131		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				258		/* V01*1-steps || value */,
				48		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				174		/* ')' || no-space value */,
				266		/* V02*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(130/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[68] = createSerializationRule("TypeExpCS-2", 129,
			createSerializationMatchSteps(
				348		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				349		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				215		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				161		/* assign V0 = |MapTypeCS::ownedValueType| */,
				33		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				32		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				34		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				84		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				179		/* ',' || no-space value soft-space */,
				138		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				174		/* ')' || no-space value */,
				258		/* V01*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-3(essentialoclcs::TypeNameExpCS): { { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[69] = createSerializationRule("TypeExpCS-3", 129,
			createSerializationMatchSteps(
				364		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				365		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				366		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				241		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				179		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				76		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				213		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				111		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				254		/* V00*5-steps || value */,
				55		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				262		/* V01*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				113		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */,
				266		/* V02*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(19/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeExpCS-4(essentialoclcs::CollectionPatternCS): { { ownedType=CollectionTypeCS "{" { ownedParts+=PatternExpCS { "," ownedParts+=PatternExpCS }[*] { "++" restVariableName=Identifier } }[?] "}" } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[70] = createSerializationRule("TypeExpCS-4", 129,
			createSerializationMatchSteps(
				86		/* assert |CollectionPatternCS::ownedPatternGuard| == 0 */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				326		/* check-rule essentialoclcs::CollectionPatternCS.ownedParts : PatternExpCS */,
				327		/* check-rule essentialoclcs::CollectionPatternCS.ownedType : CollectionTypeCS */,
				241		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				151		/* assign V0 = |CollectionPatternCS::restVariableName| */,
				188		/* assign V1 = (|CollectionPatternCS::ownedParts| - 1) */,
				9		/* assert (|CollectionPatternCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				130		/* CollectionPatternCS::ownedType=CollectionTypeCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				255		/* V00*6-steps || value */,
				101		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				101		/* CollectionPatternCS::ownedParts+=PatternExpCS || value */,
				177		/* '++' || soft-space value soft-space */,
				155		/* CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				266		/* V02*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 29/* PatternExpCS */,
					(87/*PatternExpCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 2/* CollectionTypeCS */,
					(14/*CollectionTypeCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeExpCS-5(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[71] = createSerializationRule("TypeExpCS-5", 129,
			createSerializationMatchSteps(
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				309		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				256		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				74		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				145		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				196		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				224		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				36		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				256		/* V00*7-steps || value */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				174		/* ')' || no-space value */,
				274		/* V03*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/* TuplePartCS */,
					(127/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeLiteralExpCS-0(essentialoclcs::TypeLiteralExpCS): ownedType=TypeLiteralWithMultiplicityCS
		serializationRules[72] = createSerializationRule("TypeLiteralExpCS-0", 132,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				127		/* assert |TypeLiteralExpCS::ownedPathName| == 0 */,
				363		/* check-rule essentialoclcs::TypeLiteralExpCS.ownedType : TypeLiteralWithMultiplicityCS */,
				75		/* assert (|TypeLiteralExpCS::ownedType| - 1) == 0 */
			),
			createSerializationSteps(
				134		/* TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 63/* TypeLiteralWithMultiplicityCS */,
					(133/*TypeLiteralWithMultiplicityCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[73] = createSerializationRule("TypeLiteralWithMultiplicityCS-0", 133,
			createSerializationMatchSteps(
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				183		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				57		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				35		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-1(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[74] = createSerializationRule("TypeLiteralWithMultiplicityCS-1", 133,
			createSerializationMatchSteps(
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				329		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				241		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				152		/* assign V0 = |CollectionTypeCS::ownedType| */,
				10		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				202		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				33		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				131		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				258		/* V01*1-steps || value */,
				48		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				174		/* ')' || no-space value */,
				266		/* V02*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(130/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-2(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[75] = createSerializationRule("TypeLiteralWithMultiplicityCS-2", 133,
			createSerializationMatchSteps(
				348		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				349		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				215		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				161		/* assign V0 = |MapTypeCS::ownedValueType| */,
				33		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				32		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				34		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				84		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				179		/* ',' || no-space value soft-space */,
				138		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				174		/* ')' || no-space value */,
				258		/* V01*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::TypeLiteralWithMultiplicityCS-3(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[76] = createSerializationRule("TypeLiteralWithMultiplicityCS-3", 133,
			createSerializationMatchSteps(
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				309		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				256		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				74		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				145		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				196		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				224		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				36		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				256		/* V00*7-steps || value */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				174		/* ')' || no-space value */,
				274		/* V03*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/* TuplePartCS */,
					(127/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// EssentialOCL::TypeNameExpCS-0(essentialoclcs::TypeNameExpCS): { ownedPathName=PathNameCS { ownedCurlyBracketedClause=CurlyBracketedClauseCS { "{" ownedPatternGuard=ExpCS "}" }[?] }[?] }
		serializationRules[77] = createSerializationRule("TypeNameExpCS-0", 134,
			createSerializationMatchSteps(
				130		/* assert |TypedRefCS::ownedMultiplicity| == 0 */,
				364		/* check-rule essentialoclcs::TypeNameExpCS.ownedCurlyBracketedClause : CurlyBracketedClauseCS */,
				365		/* check-rule essentialoclcs::TypeNameExpCS.ownedPathName : PathNameCS */,
				366		/* check-rule essentialoclcs::TypeNameExpCS.ownedPatternGuard : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				179		/* assign V0 = |TypeNameExpCS::ownedCurlyBracketedClause| */,
				76		/* assert (|TypeNameExpCS::ownedPathName| - 1) == 0 */,
				213		/* assign V1 = |TypeNameExpCS::ownedPatternGuard| */
			),
			createSerializationSteps(
				111		/* TypeNameExpCS::ownedPathName=PathNameCS || value */,
				254		/* V00*5-steps || value */,
				55		/* TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value */,
				262		/* V01*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				113		/* TypeNameExpCS::ownedPatternGuard=ExpCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 4/* CurlyBracketedClauseCS */,
					(19/*CurlyBracketedClauseCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// EssentialOCL::URIFirstPathElementCS-0(basecs::PathElementWithURICS): referredElement=URI
		serializationRules[78] = createSerializationRule("URIFirstPathElementCS-0", 143,
			createSerializationMatchSteps(
				54		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				337		/* PathElementCS::referredElement=URI || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIFirstPathElementCS-1(basecs::PathElementCS): referredElement=UnrestrictedName
		serializationRules[79] = createSerializationRule("URIFirstPathElementCS-1", 143,
			createSerializationMatchSteps(
				54		/* assert (|PathElementCS::referredElement| - 1) == 0 */
			),
			createSerializationSteps(
				339		/* PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, -1
				)
			});
		// EssentialOCL::URIPathNameCS-0(basecs::PathNameCS): { ownedPathElements+=URIFirstPathElementCS { "::" ownedPathElements+=NextPathElementCS }[*] }
		serializationRules[80] = createSerializationRule("URIPathNameCS-0", 144,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				320		/* PathNameCS::ownedPathElements+=URIFirstPathElementCS || value */,
				251		/* V00*2-steps || value */,
				183		/* '::' || no-space value no-space */,
				322		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 70/* NextPathElementCS,URIFirstPathElementCS */,
					(80/*NextPathElementCS*/ << 4) | 2 /*[*]*/,
					(143/*URIFirstPathElementCS*/ << 4) | 0 /*[1]*/
				)
			});
		// EssentialOCL::UnlimitedNaturalLiteralExpCS-0(essentialoclcs::UnlimitedNaturalLiteralExpCS): "*"
		serializationRules[81] = createSerializationRule("UnlimitedNaturalLiteralExpCS-0", 146,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */
			),
			createSerializationSteps(
				175		/* '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			null);
		// QVTbase::AttributeCS-0(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[82] = createSerializationRule("AttributeCS-0", 4,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				236		/* assign V2 = |StructuralFeatureCS::default| */,
				214		/* assign V1 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				182		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				78		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				245		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				266		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				196		/* 'attribute' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				282		/* V04*1-steps || value */,
				332		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(25/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-1(basecs::AttributeCS): { { qualifiers+="definition" qualifiers+="static"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[83] = createSerializationRule("AttributeCS-1", 4,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				300		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				236		/* assign V2 = |StructuralFeatureCS::default| */,
				214		/* assign V1 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				182		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				78		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				245		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				266		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				271		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				274		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				281		/* assign V7 = 0 */,
				285		/* assign V8 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				196		/* 'attribute' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				282		/* V04*1-steps || value */,
				332		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				293		/* V05*5-steps || value */,
				204		/* 'derivation' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				294		/* V06*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				303		/* V07*5-steps || value */,
				218		/* 'initial' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				304		/* V08*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(25/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-2(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[84] = createSerializationRule("AttributeCS-2", 4,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				236		/* assign V2 = |StructuralFeatureCS::default| */,
				214		/* assign V1 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				181		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				79		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				245		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				266		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				196		/* 'attribute' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				282		/* V04*1-steps || value */,
				332		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(25/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-3(basecs::AttributeCS): { { qualifiers+="static" qualifiers+="definition"[?] } "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[85] = createSerializationRule("AttributeCS-3", 4,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				300		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				236		/* assign V2 = |StructuralFeatureCS::default| */,
				214		/* assign V1 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				181		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				79		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				245		/* assign V3 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				266		/* assign V4 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				271		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				274		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				281		/* assign V7 = 0 */,
				285		/* assign V8 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				196		/* 'attribute' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				282		/* V04*1-steps || value */,
				332		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				293		/* V05*5-steps || value */,
				204		/* 'derivation' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				294		/* V06*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				303		/* V07*5-steps || value */,
				218		/* 'initial' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				304		/* V08*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(25/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-4(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[86] = createSerializationRule("AttributeCS-4", 4,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				209		/* assign V1 = |StructuralFeatureCS::default| */,
				180		/* assign V0 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				225		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				255		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				196		/* 'attribute' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				260		/* V01*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				272		/* V02*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				276		/* V03*1-steps || value */,
				332		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::AttributeCS-5(basecs::AttributeCS): { "attribute" name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[87] = createSerializationRule("AttributeCS-5", 4,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				300		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				209		/* assign V1 = |StructuralFeatureCS::default| */,
				180		/* assign V0 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				225		/* assign V2 = (|TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| > 0) */,
				255		/* assign V3 = |TypedElementCS::qualifiers.'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'| */,
				262		/* assign V4 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				269		/* assign V5 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				276		/* assign V6 = 0 */,
				281		/* assign V7 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				196		/* 'attribute' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				260		/* V01*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				272		/* V02*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				276		/* V03*1-steps || value */,
				332		/* TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				286		/* V04*5-steps || value */,
				204		/* 'derivation' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				287		/* V05*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				298		/* V06*5-steps || value */,
				218		/* 'initial' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				299		/* V07*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(1/*'!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::CompoundTargetElementCS-0(qvtbasecs::CompoundTargetElementCS): { "{" ownedTargetElements+=SimpleTargetElementCS[*] "}" }
		serializationRules[88] = createSerializationRule("CompoundTargetElementCS-0", 17,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				370		/* check-rule qvtbasecs::CompoundTargetElementCS.ownedTargetElements : SimpleTargetElementCS */,
				153		/* assign V0 = |CompoundTargetElementCS::ownedTargetElements| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				244		/* '{' || soft-space value push soft-new-line */,
				248		/* V00*1-steps || value */,
				123		/* CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 42/* SimpleTargetElementCS */,
					(111/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::DataTypeCS-0(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[89] = createSerializationRule("DataTypeCS-0", 21,
			createSerializationMatchSteps(
				88		/* assert |DataTypeCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				229		/* assign V2 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				154		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				246		/* assign V3 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				23		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				203		/* 'datatype' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				279		/* V03*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				170		/* '!serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(23/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-1(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" "}" } }
		serializationRules[90] = createSerializationRule("DataTypeCS-1", 21,
			createSerializationMatchSteps(
				88		/* assert |DataTypeCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				229		/* assign V2 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				154		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				246		/* assign V3 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				23		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				203		/* 'datatype' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				279		/* V03*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				170		/* '!serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(23/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-2(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[91] = createSerializationRule("DataTypeCS-2", 21,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				248		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				229		/* assign V2 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				154		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				23		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				203		/* 'datatype' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				279		/* V03*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				24		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(23/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(24/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-3(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" "}" } }
		serializationRules[92] = createSerializationRule("DataTypeCS-3", 21,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				248		/* assign V3 = |DataTypeCS::isSerializable.'serializable'| */,
				229		/* assign V2 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				154		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				23		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				203		/* 'datatype' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				279		/* V03*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				24		/* DataTypeCS::isSerializable?='serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(23/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, false,
					(24/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-4(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[93] = createSerializationRule("DataTypeCS-4", 21,
			createSerializationMatchSteps(
				88		/* assert |DataTypeCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				229		/* assign V2 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				154		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				246		/* assign V3 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				23		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				203		/* 'datatype' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				277		/* V03*2-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(23/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::DataTypeCS-5(basecs::DataTypeCS): { isPrimitive?="primitive"[?] "datatype" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" "}" } }
		serializationRules[94] = createSerializationRule("DataTypeCS-5", 21,
			createSerializationMatchSteps(
				88		/* assert |DataTypeCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				229		/* assign V2 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				154		/* assign V0 = |DataTypeCS::isPrimitive.'primitive'| */,
				246		/* assign V3 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				23		/* DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space */,
				203		/* 'datatype' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				277		/* V03*2-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, false,
					(23/*'primitive'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-0(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] ";" }
		serializationRules[95] = createSerializationRule("EnumerationCS-0", 28,
			createSerializationMatchSteps(
				89		/* assert |EnumerationCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				90		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				201		/* assign V1 = |ClassCS::instanceClassName| */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				226		/* assign V2 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				209		/* 'enum' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				271		/* V02*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				170		/* '!serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-1(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "!serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[96] = createSerializationRule("EnumerationCS-1", 28,
			createSerializationMatchSteps(
				89		/* assert |EnumerationCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				291		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				249		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				201		/* assign V1 = |ClassCS::instanceClassName| */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				226		/* assign V2 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				209		/* 'enum' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				271		/* V02*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				170		/* '!serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				275		/* V03*1-steps || value */,
				87		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(29/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-2(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] ";" }
		serializationRules[97] = createSerializationRule("EnumerationCS-2", 28,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				90		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				231		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				201		/* assign V1 = |ClassCS::instanceClassName| */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				209		/* 'enum' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				271		/* V02*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				25		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(24/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-3(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isSerializable?="serializable" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[98] = createSerializationRule("EnumerationCS-3", 28,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				291		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				249		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				231		/* assign V2 = |EnumerationCS::isSerializable.'serializable'| */,
				201		/* assign V1 = |ClassCS::instanceClassName| */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				209		/* 'enum' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				271		/* V02*3-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				25		/* EnumerationCS::isSerializable?='serializable' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				275		/* V03*1-steps || value */,
				87		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, false,
					(24/*'serializable'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(29/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-4(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] ";" }
		serializationRules[99] = createSerializationRule("EnumerationCS-4", 28,
			createSerializationMatchSteps(
				89		/* assert |EnumerationCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				90		/* assert |EnumerationCS::ownedLiterals| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				201		/* assign V1 = |ClassCS::instanceClassName| */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				226		/* assign V2 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				209		/* 'enum' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationCS-5(basecs::EnumerationCS): { "enum" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" "}" }[?] { "{" ownedLiterals+=EnumerationLiteralCS[*] "}" } }
		serializationRules[100] = createSerializationRule("EnumerationCS-5", 28,
			createSerializationMatchSteps(
				89		/* assert |EnumerationCS::isSerializable| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				291		/* check-rule basecs::EnumerationCS.ownedLiterals : EnumerationLiteralCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				249		/* assign V3 = |EnumerationCS::ownedLiterals| */,
				201		/* assign V1 = |ClassCS::instanceClassName| */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				226		/* assign V2 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				209		/* 'enum' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				275		/* V03*1-steps || value */,
				87		/* EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 7/* EnumerationLiteralCS */,
					(29/*EnumerationLiteralCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::EnumerationLiteralCS-0(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] ";" }
		serializationRules[101] = createSerializationRule("EnumerationLiteralCS-0", 29,
			createSerializationMatchSteps(
				91		/* assert |EnumerationLiteralCS::literal| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				155		/* assign V0 = |EnumerationLiteralCS::value| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				223		/* 'literal' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				166		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-1(basecs::EnumerationLiteralCS): { { "literal" name=UnrestrictedName } { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[102] = createSerializationRule("EnumerationLiteralCS-1", 29,
			createSerializationMatchSteps(
				91		/* assert |EnumerationLiteralCS::literal| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				155		/* assign V0 = |EnumerationLiteralCS::value| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				223		/* 'literal' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				166		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-2(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] ";" }
		serializationRules[103] = createSerializationRule("EnumerationLiteralCS-2", 29,
			createSerializationMatchSteps(
				91		/* assert |EnumerationLiteralCS::literal| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				155		/* assign V0 = |EnumerationLiteralCS::value| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				315		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				166		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::EnumerationLiteralCS-3(basecs::EnumerationLiteralCS): { name=EnumerationLiteralName { "=" value=SIGNED }[?] { "{" "}" } }
		serializationRules[104] = createSerializationRule("EnumerationLiteralCS-3", 29,
			createSerializationMatchSteps(
				91		/* assert |EnumerationLiteralCS::literal| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				155		/* assign V0 = |EnumerationLiteralCS::value| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				315		/* NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				166		/* EnumerationLiteralCS::value=SIGNED || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, false, GrammarCardinality.ZERO_OR_ONE)
			});
		// QVTbase::OperationCS-0(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[105] = createSerializationRule("OperationCS-0", 83,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				106		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				107		/* assert |OperationCS::ownedPostconditions| == 0 */,
				108		/* assert |OperationCS::ownedPreconditions| == 0 */,
				294		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				295		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				264		/* assign V4 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				182		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				78		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				268		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				273		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				220		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				242		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				280		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				287		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				228		/* 'operation' || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				272		/* V02*4-steps || value */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				278		/* V03*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				174		/* ')' || no-space value */,
				283		/* V04*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				292		/* V05*5-steps || value */,
				240		/* 'throws' || soft-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				296		/* V06*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				302		/* V07*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				306		/* V08*1-steps || value */,
				333		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(25/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 27/* ParameterCS */,
					(85/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-1(basecs::OperationCS): { { qualifiers+="definition" qualifiers+="static"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[106] = createSerializationRule("OperationCS-1", 83,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				107		/* assert |OperationCS::ownedPostconditions| == 0 */,
				108		/* assert |OperationCS::ownedPreconditions| == 0 */,
				293		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				294		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				295		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				264		/* assign V4 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				182		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				78		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				288		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				217		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				268		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				273		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				220		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				242		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				280		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				287		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				228		/* 'operation' || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				272		/* V02*4-steps || value */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				278		/* V03*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				174		/* ')' || no-space value */,
				283		/* V04*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				292		/* V05*5-steps || value */,
				240		/* 'throws' || soft-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				296		/* V06*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				302		/* V07*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				306		/* V08*1-steps || value */,
				333		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				310		/* V09*5-steps || value */,
				197		/* 'body' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				265		/* V10*1-steps || value */,
				45		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(25/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 27/* ParameterCS */,
					(85/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-2(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[107] = createSerializationRule("OperationCS-2", 83,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				106		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				107		/* assert |OperationCS::ownedPostconditions| == 0 */,
				108		/* assert |OperationCS::ownedPreconditions| == 0 */,
				294		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				295		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				264		/* assign V4 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				181		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				79		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				268		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				273		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				220		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				242		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				280		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				287		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				228		/* 'operation' || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				272		/* V02*4-steps || value */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				278		/* V03*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				174		/* ')' || no-space value */,
				283		/* V04*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				292		/* V05*5-steps || value */,
				240		/* 'throws' || soft-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				296		/* V06*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				302		/* V07*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				306		/* V08*1-steps || value */,
				333		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(25/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 27/* ParameterCS */,
					(85/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-3(basecs::OperationCS): { { qualifiers+="static" qualifiers+="definition"[?] } "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[108] = createSerializationRule("OperationCS-3", 83,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				107		/* assert |OperationCS::ownedPostconditions| == 0 */,
				108		/* assert |OperationCS::ownedPreconditions| == 0 */,
				293		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				294		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				295		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				264		/* assign V4 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				181		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				79		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				288		/* assign V9 = (|OperationCS::ownedBodyExpressions| > 0) */,
				217		/* assign V10 = |OperationCS::ownedBodyExpressions| */,
				268		/* assign V5 = (|OperationCS::ownedExceptions| > 0) */,
				273		/* assign V6 = (|OperationCS::ownedExceptions| - 1) */,
				220		/* assign V2 = (|OperationCS::ownedParameters| > 0) */,
				242		/* assign V3 = (|OperationCS::ownedParameters| - 1) */,
				280		/* assign V7 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				287		/* assign V8 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				228		/* 'operation' || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				272		/* V02*4-steps || value */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				278		/* V03*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				174		/* ')' || no-space value */,
				283		/* V04*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				292		/* V05*5-steps || value */,
				240		/* 'throws' || soft-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				296		/* V06*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				302		/* V07*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				306		/* V08*1-steps || value */,
				333		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				310		/* V09*5-steps || value */,
				197		/* 'body' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				265		/* V10*1-steps || value */,
				45		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(25/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 27/* ParameterCS */,
					(85/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-4(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] ";" }
		serializationRules[109] = createSerializationRule("OperationCS-4", 83,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				106		/* assert |OperationCS::ownedBodyExpressions| == 0 */,
				107		/* assert |OperationCS::ownedPostconditions| == 0 */,
				108		/* assert |OperationCS::ownedPreconditions| == 0 */,
				294		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				295		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				254		/* assign V3 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				275		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				283		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				257		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				267		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				193		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				219		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* 'operation' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				174		/* ')' || no-space value */,
				277		/* V03*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				285		/* V04*5-steps || value */,
				240		/* 'throws' || soft-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				290		/* V05*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				297		/* V06*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				301		/* V07*1-steps || value */,
				333		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 27/* ParameterCS */,
					(85/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::OperationCS-5(basecs::OperationCS): { "operation" ownedSignature=TemplateSignatureCS[?] name=UnrestrictedName "(" { ownedParameters+=ParameterCS { "," ownedParameters+=ParameterCS }[*] }[?] ")" { ":" ownedType=TypedMultiplicityRefCS }[?] { "throws" ownedExceptions+=TypedRefCS { "," ownedExceptions+=TypedRefCS }[*] }[?] { "{" { qualifiers+={'!derived|!ordered|!unique|derived|ordered|unique'} }[+] "}" }[?] { "{" { "body" ":" ownedBodyExpressions+=SpecificationCS[?] ";" }[*] "}" } }
		serializationRules[110] = createSerializationRule("OperationCS-5", 83,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				107		/* assert |OperationCS::ownedPostconditions| == 0 */,
				108		/* assert |OperationCS::ownedPreconditions| == 0 */,
				293		/* check-rule basecs::OperationCS.ownedBodyExpressions : SpecificationCS */,
				294		/* check-rule basecs::OperationCS.ownedExceptions : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				295		/* check-rule basecs::OperationCS.ownedParameters : ParameterCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				254		/* assign V3 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				178		/* assign V0 = |TemplateableElementCS::ownedSignature| */,
				284		/* assign V8 = (|OperationCS::ownedBodyExpressions| > 0) */,
				290		/* assign V9 = |OperationCS::ownedBodyExpressions| */,
				275		/* assign V6 = (|TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| > 0) */,
				283		/* assign V7 = |TypedElementCS::qualifiers.'!derived|!ordered|!unique|derived|ordered|unique'| */,
				257		/* assign V4 = (|OperationCS::ownedExceptions| > 0) */,
				267		/* assign V5 = (|OperationCS::ownedExceptions| - 1) */,
				193		/* assign V1 = (|OperationCS::ownedParameters| > 0) */,
				219		/* assign V2 = (|OperationCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				228		/* 'operation' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				97		/* OperationCS::ownedParameters+=ParameterCS || value */,
				174		/* ')' || no-space value */,
				277		/* V03*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				285		/* V04*5-steps || value */,
				240		/* 'throws' || soft-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				290		/* V05*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				59		/* OperationCS::ownedExceptions+=TypedRefCS || value */,
				297		/* V06*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				301		/* V07*1-steps || value */,
				333		/* TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				307		/* V08*5-steps || value */,
				197		/* 'body' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				308		/* V09*1-steps || value */,
				45		/* OperationCS::ownedBodyExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(2/*'!derived|!ordered|!unique|derived|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 27/* ParameterCS */,
					(85/*ParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ParameterCS-0(basecs::ParameterCS): { name=UnrestrictedName { ":" ownedType=TypedMultiplicityRefCS }[?] { "{" { qualifiers+={'!ordered|!unique|ordered|unique'} }[+] "}" }[?] { "{" "}" }[?] }
		serializationRules[111] = createSerializationRule("ParameterCS-0", 85,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				180		/* assign V0 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				198		/* assign V1 = (|TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| > 0) */,
				240		/* assign V2 = |TypedElementCS::qualifiers.'!ordered|!unique|ordered|unique'| */,
				246		/* assign V3 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				263		/* V01*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				268		/* V02*1-steps || value */,
				334		/* TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				277		/* V03*2-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(3/*'!ordered|!unique|ordered|unique'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::ReferenceCS-0(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[112] = createSerializationRule("ReferenceCS-0", 98,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				112		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				113		/* assert |ReferenceCS::referredKeys| == 0 */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				252		/* assign V3 = |StructuralFeatureCS::default| */,
				239		/* assign V2 = |TypedElementCS::ownedType| */,
				208		/* assign V1 = |ReferenceCS::referredOpposite| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				182		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				78		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				258		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				272		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				232		/* 'property' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				171		/* '#' || no-space value no-space */,
				144		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				277		/* V03*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				284		/* V04*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				289		/* V05*1-steps || value */,
				331		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(25/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-1(basecs::ReferenceCS): { { qualifiers+="definition" qualifiers+="static"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[113] = createSerializationRule("ReferenceCS-1", 98,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				113		/* assert |ReferenceCS::referredKeys| == 0 */,
				300		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				252		/* assign V3 = |StructuralFeatureCS::default| */,
				239		/* assign V2 = |TypedElementCS::ownedType| */,
				208		/* assign V1 = |ReferenceCS::referredOpposite| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				182		/* assign V0 = |TypedElementCS::qualifiers.'static'| */,
				78		/* assert (|TypedElementCS::qualifiers.'definition'| - 1) == 0 */,
				258		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				272		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				277		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				279		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				285		/* assign V8 = 0 */,
				289		/* assign V9 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				232		/* 'property' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				171		/* '#' || no-space value no-space */,
				144		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				277		/* V03*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				284		/* V04*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				289		/* V05*1-steps || value */,
				331		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				298		/* V06*5-steps || value */,
				204		/* 'derivation' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				299		/* V07*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				307		/* V08*5-steps || value */,
				218		/* 'initial' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				308		/* V09*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 0 /*[1]*/,
					(25/*'static'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-2(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[114] = createSerializationRule("ReferenceCS-2", 98,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				112		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				113		/* assert |ReferenceCS::referredKeys| == 0 */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				252		/* assign V3 = |StructuralFeatureCS::default| */,
				239		/* assign V2 = |TypedElementCS::ownedType| */,
				208		/* assign V1 = |ReferenceCS::referredOpposite| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				181		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				79		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				258		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				272		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				232		/* 'property' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				171		/* '#' || no-space value no-space */,
				144		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				277		/* V03*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				284		/* V04*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				289		/* V05*1-steps || value */,
				331		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(25/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-3(basecs::ReferenceCS): { { qualifiers+="static" qualifiers+="definition"[?] } "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[115] = createSerializationRule("ReferenceCS-3", 98,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				113		/* assert |ReferenceCS::referredKeys| == 0 */,
				300		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				252		/* assign V3 = |StructuralFeatureCS::default| */,
				239		/* assign V2 = |TypedElementCS::ownedType| */,
				208		/* assign V1 = |ReferenceCS::referredOpposite| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				181		/* assign V0 = |TypedElementCS::qualifiers.'definition'| */,
				79		/* assert (|TypedElementCS::qualifiers.'static'| - 1) == 0 */,
				258		/* assign V4 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				272		/* assign V5 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				277		/* assign V6 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				279		/* assign V7 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				285		/* assign V8 = 0 */,
				289		/* assign V9 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				336		/* TypedElementCS::qualifiers+='static' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				335		/* TypedElementCS::qualifiers+='definition' || soft-space value soft-space */,
				232		/* 'property' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				171		/* '#' || no-space value no-space */,
				144		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				277		/* V03*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				284		/* V04*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				289		/* V05*1-steps || value */,
				331		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				298		/* V06*5-steps || value */,
				204		/* 'derivation' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				299		/* V07*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				307		/* V08*5-steps || value */,
				218		/* 'initial' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				308		/* V09*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/,
					(15/*'definition'*/ << 4) | 1 /*[?]*/,
					(25/*'static'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-4(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] ";" }
		serializationRules[116] = createSerializationRule("ReferenceCS-4", 98,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				122		/* assert |StructuralFeatureCS::ownedDefaultExpressions| == 0 */,
				112		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				113		/* assert |ReferenceCS::referredKeys| == 0 */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				236		/* assign V2 = |StructuralFeatureCS::default| */,
				214		/* assign V1 = |TypedElementCS::ownedType| */,
				171		/* assign V0 = |ReferenceCS::referredOpposite| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				244		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				265		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				232		/* 'property' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				171		/* '#' || no-space value no-space */,
				144		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				282		/* V04*1-steps || value */,
				331		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::ReferenceCS-5(basecs::ReferenceCS): { "property" name=UnrestrictedName { "#" referredOpposite=UnrestrictedName }[?] { ":" ownedType=TypedMultiplicityRefCS }[?] { "=" default=SINGLE_QUOTED_STRING }[?] { "{" { qualifiers+={'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'} }[+] "}" }[?] { "{" { { "derivation" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] { "initial" ":" ownedDefaultExpressions+=SpecificationCS[?] ";" }[*] } "}" } }
		serializationRules[117] = createSerializationRule("ReferenceCS-5", 98,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				112		/* assert |ReferenceCS::ownedImplicitOpposites| == 0 */,
				113		/* assert |ReferenceCS::referredKeys| == 0 */,
				300		/* check-rule basecs::StructuralFeatureCS.ownedDefaultExpressions : SpecificationCS */,
				312		/* check-rule basecs::TypedElementCS.ownedType : TypedMultiplicityRefCS */,
				236		/* assign V2 = |StructuralFeatureCS::default| */,
				214		/* assign V1 = |TypedElementCS::ownedType| */,
				171		/* assign V0 = |ReferenceCS::referredOpposite| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				244		/* assign V3 = (|TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| > 0) */,
				265		/* assign V4 = |TypedElementCS::qualifiers.'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'| */,
				271		/* assign V5 = |StructuralFeatureCS::ownedDefaultExpressions| */,
				274		/* assign V6 = (|StructuralFeatureCS::ownedDefaultExpressions| > 0) */,
				281		/* assign V7 = 0 */,
				285		/* assign V8 = 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				232		/* 'property' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				171		/* '#' || no-space value no-space */,
				144		/* ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				330		/* TypedElementCS::ownedType=TypedMultiplicityRefCS || value */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				0		/* StructuralFeatureCS::default=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				280		/* V03*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				282		/* V04*1-steps || value */,
				331		/* TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				293		/* V05*5-steps || value */,
				204		/* 'derivation' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				294		/* V06*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				303		/* V07*5-steps || value */,
				218		/* 'initial' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				304		/* V08*1-steps || value */,
				56		/* StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, false,
					(0/*'!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile'*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 44/* SpecificationCS */,
					(112/*SpecificationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 67/* TypedMultiplicityRefCS */,
					(137/*TypedMultiplicityRefCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-0(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[118] = createSerializationRule("SimpleTargetElementCS-0", 111,
			createSerializationMatchSteps(
				119		/* assert |SimpleTargetElementCS::output| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				120		/* assert |SimpleTargetElementCS::via| == 0 */,
				174		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				70		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				68		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				6		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				163		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				221		/* 'iterates' || soft-space value soft-space */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(17/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-1(qvtbasecs::SimpleTargetElementCS): { input?="input" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[119] = createSerializationRule("SimpleTargetElementCS-1", 111,
			createSerializationMatchSteps(
				119		/* assert |SimpleTargetElementCS::output| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				120		/* assert |SimpleTargetElementCS::via| == 0 */,
				70		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				68		/* assert (|SimpleTargetElementCS::input.'input'| - 1) == 0 */,
				139		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				195		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				222		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				6		/* SimpleTargetElementCS::input?='input' || soft-space value soft-space */,
				163		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				257		/* V00*8-steps || value */,
				221		/* 'iterates' || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				263		/* V01*4-steps || value */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, false,
					(17/*'input'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-2(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[120] = createSerializationRule("SimpleTargetElementCS-2", 111,
			createSerializationMatchSteps(
				118		/* assert |SimpleTargetElementCS::input| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				120		/* assert |SimpleTargetElementCS::via| == 0 */,
				174		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				70		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				69		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				40		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				163		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				221		/* 'iterates' || soft-space value soft-space */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(22/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-3(qvtbasecs::SimpleTargetElementCS): { output?="output" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[121] = createSerializationRule("SimpleTargetElementCS-3", 111,
			createSerializationMatchSteps(
				118		/* assert |SimpleTargetElementCS::input| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				120		/* assert |SimpleTargetElementCS::via| == 0 */,
				70		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				69		/* assert (|SimpleTargetElementCS::output.'output'| - 1) == 0 */,
				139		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				195		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				222		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				40		/* SimpleTargetElementCS::output?='output' || soft-space value soft-space */,
				163		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				257		/* V00*8-steps || value */,
				221		/* 'iterates' || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				263		/* V01*4-steps || value */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, false,
					(22/*'output'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-4(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" iterates+=UnrestrictedName }[?] ";" }
		serializationRules[122] = createSerializationRule("SimpleTargetElementCS-4", 111,
			createSerializationMatchSteps(
				118		/* assert |SimpleTargetElementCS::input| == 0 */,
				119		/* assert |SimpleTargetElementCS::output| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				174		/* assign V0 = |SimpleTargetElementCS::iterates| */,
				70		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				71		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				169		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				163		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				221		/* 'iterates' || soft-space value soft-space */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(28/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SimpleTargetElementCS-5(qvtbasecs::SimpleTargetElementCS): { via?="via" typedModel=UnrestrictedName { "iterates" { "{" { iterates+=UnrestrictedName { "," iterates+=UnrestrictedName }[*] }[?] "}" } }[?] ";" }
		serializationRules[123] = createSerializationRule("SimpleTargetElementCS-5", 111,
			createSerializationMatchSteps(
				118		/* assert |SimpleTargetElementCS::input| == 0 */,
				119		/* assert |SimpleTargetElementCS::output| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				70		/* assert (|SimpleTargetElementCS::typedModel| - 1) == 0 */,
				71		/* assert (|SimpleTargetElementCS::via.'via'| - 1) == 0 */,
				139		/* assign V0 = (|SimpleTargetElementCS::iterates| > 0) */,
				195		/* assign V1 = (|SimpleTargetElementCS::iterates| > 0) */,
				222		/* assign V2 = (|SimpleTargetElementCS::iterates| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				169		/* SimpleTargetElementCS::via?='via' || soft-space value soft-space */,
				163		/* SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space */,
				257		/* V00*8-steps || value */,
				221		/* 'iterates' || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				263		/* V01*4-steps || value */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				29		/* SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, false,
					(28/*'via'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, -1
				),
				createSerializationReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, -1
				)
			});
		// QVTbase::SpecificationCS-0(essentialoclcs::ExpSpecificationCS): ownedExpression=ExpCS
		serializationRules[124] = createSerializationRule("SpecificationCS-0", 112,
			createSerializationMatchSteps(
				121		/* assert |SpecificationCS::exprString| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				332		/* check-rule essentialoclcs::ExpSpecificationCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				13		/* assert (|ExpSpecificationCS::ownedExpression| - 1) == 0 */
			),
			createSerializationSteps(
				66		/* ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::SpecificationCS-1(essentialoclcs::ExpSpecificationCS): exprString=UNQUOTED_STRING
		serializationRules[125] = createSerializationRule("SpecificationCS-1", 112,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				92		/* assert |ExpSpecificationCS::ownedExpression| == 0 */,
				72		/* assert (|SpecificationCS::exprString| - 1) == 0 */
			),
			createSerializationSteps(
				1		/* SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, true, GrammarCardinality.ONE)
			});
		// QVTbase::StructuredClassCS-0(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] ";" }
		serializationRules[126] = createSerializationRule("StructuredClassCS-0", 118,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				123		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				124		/* assert |StructuredClassCS::ownedOperations| == 0 */,
				125		/* assert |StructuredClassCS::ownedProperties| == 0 */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				303		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				260		/* assign V4 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				176		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				270		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				278		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				223		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				243		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				9		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				201		/* 'class' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				273		/* V02*5-steps || value */,
				210		/* 'extends' || soft-space value soft-space */,
				122		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				278		/* V03*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				122		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				283		/* V04*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				291		/* V05*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				294		/* V06*1-steps || value */,
				17		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				185		/* ';' || no-space value soft-new-line */
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
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::StructuredClassCS-1(basecs::StructuredClassCS): { isAbstract?="abstract"[?] "class" name=UnrestrictedName ownedSignature=TemplateSignatureCS[?] { "extends" ownedSuperTypes+=TypedRefCS { "," ownedSuperTypes+=TypedRefCS }[*] }[?] { ":" instanceClassName=SINGLE_QUOTED_STRING }[?] { "{" isInterface?="interface"[?] "}" }[?] { "{" { ownedOperations+=OperationCS[*] ownedProperties+=StructuralFeatureCS[*] } "}" } }
		serializationRules[127] = createSerializationRule("StructuredClassCS-1", 118,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				123		/* assert |StructuredClassCS::ownedMetaclass| == 0 */,
				301		/* check-rule basecs::StructuredClassCS.ownedOperations : OperationCS */,
				302		/* check-rule basecs::StructuredClassCS.ownedProperties : AttributeCS|ReferenceCS|StructuralFeatureCS */,
				308		/* check-rule basecs::TemplateableElementCS.ownedSignature : TemplateSignatureCS */,
				303		/* check-rule basecs::StructuredClassCS.ownedSuperTypes : CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeLiteralCS|TypedRefCS|TypedTypeRefCS */,
				286		/* assign V8 = |StructuredClassCS::ownedProperties| */,
				282		/* assign V7 = |StructuredClassCS::ownedOperations| */,
				260		/* assign V4 = |ClassCS::instanceClassName| */,
				211		/* assign V1 = |TemplateableElementCS::ownedSignature| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				176		/* assign V0 = |StructuredClassCS::isAbstract.'abstract'| */,
				270		/* assign V5 = (|StructuredClassCS::isInterface.'interface'| > 0) */,
				278		/* assign V6 = |StructuredClassCS::isInterface.'interface'| */,
				223		/* assign V2 = (|StructuredClassCS::ownedSuperTypes| > 0) */,
				243		/* assign V3 = (|StructuredClassCS::ownedSuperTypes| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				9		/* StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space */,
				201		/* 'class' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				258		/* V01*1-steps || value */,
				119		/* TemplateableElementCS::ownedSignature=TemplateSignatureCS || value */,
				273		/* V02*5-steps || value */,
				210		/* 'extends' || soft-space value soft-space */,
				122		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				278		/* V03*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				122		/* StructuredClassCS::ownedSuperTypes+=TypedRefCS || value */,
				283		/* V04*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				8		/* ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				291		/* V05*4-steps || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				294		/* V06*1-steps || value */,
				17		/* StructuredClassCS::isInterface?='interface' || soft-space value soft-space */,
				246		/* '}' || pop soft-space value soft-new-line */,
				244		/* '{' || soft-space value push soft-new-line */,
				300		/* V07*1-steps || value */,
				94		/* StructuredClassCS::ownedOperations+=OperationCS || value */,
				305		/* V08*1-steps || value */,
				115		/* StructuredClassCS::ownedProperties+=StructuralFeatureCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
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
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 25/* OperationCS */,
					(83/*OperationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 49/* StructuralFeatureCS */,
					(117/*StructuralFeatureCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 54/* TemplateSignatureCS */,
					(122/*TemplateSignatureCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 68/* TypedRefCS */,
					(138/*TypedRefCS*/ << 4) | 2 /*[*]*/
				)
			});
	}
	private void initSerializationRules2() {
		// QVTbase::TargetCS-0(qvtbasecs::TargetCS): { "target" name=UnrestrictedName "{" ownedTargetElements+=(SimpleTargetElementCS|CompoundTargetElementCS)[*] "}" }
		serializationRules[128] = createSerializationRule("TargetCS-0", 119,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				372		/* check-rule qvtbasecs::TargetCS.ownedTargetElements : CompoundTargetElementCS|SimpleTargetElementCS */,
				177		/* assign V0 = |TargetCS::ownedTargetElements| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				238		/* 'target' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				248		/* V00*1-steps || value */,
				124		/* TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, 43/* CompoundTargetElementCS,SimpleTargetElementCS */,
					(17/*CompoundTargetElementCS*/ << 4) | 2 /*[*]*/,
					(111/*SimpleTargetElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-0(basecs::PrimitiveTypeRefCS): { name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[129] = createSerializationRule("TypedMultiplicityRefCS-0", 137,
			createSerializationMatchSteps(
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				183		/* assign V0 = |TypedRefCS::ownedMultiplicity| */,
				57		/* assert (|PrimitiveTypeRefCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				35		/* PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-1(basecs::TypedTypeRefCS): { { ownedPathName=PathNameCS { "(" ownedBinding=TemplateBindingCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[130] = createSerializationRule("TypedMultiplicityRefCS-1", 137,
			createSerializationMatchSteps(
				131		/* assert |TypedTypeRefCS::isTypeof| == 0 */,
				314		/* check-rule basecs::TypedTypeRefCS.ownedBinding : TemplateBindingCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				315		/* check-rule basecs::TypedTypeRefCS.ownedPathName : PathNameCS */,
				215		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				184		/* assign V0 = |TypedTypeRefCS::ownedBinding| */,
				80		/* assert (|TypedTypeRefCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				112		/* TypedTypeRefCS::ownedPathName=PathNameCS || value */,
				252		/* V00*3-steps || value */,
				173		/* '(' || no-space value no-space */,
				43		/* TypedTypeRefCS::ownedBinding=TemplateBindingCS || value */,
				174		/* ')' || no-space value */,
				258		/* V01*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 52/* TemplateBindingCS */,
					(120/*TemplateBindingCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-2(essentialoclcs::CollectionTypeCS): { { name=CollectionTypeIdentifier { "(" ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[131] = createSerializationRule("TypedMultiplicityRefCS-2", 137,
			createSerializationMatchSteps(
				328		/* check-rule essentialoclcs::CollectionTypeCS.ownedCollectionMultiplicity : MultiplicityCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				329		/* check-rule essentialoclcs::CollectionTypeCS.ownedType : CollectionPatternCS|CollectionTypeCS|MapTypeCS|PrimitiveTypeCS|TupleTypeCS|TypeExpWithoutMultiplicityCS|TypeLiteralCS|TypeNameExpCS */,
				241		/* assign V2 = |TypedRefCS::ownedMultiplicity| */,
				152		/* assign V0 = |CollectionTypeCS::ownedType| */,
				10		/* assert (|CollectionTypeCS::name| - 1) == 0 */,
				202		/* assign V1 = |CollectionTypeCS::ownedCollectionMultiplicity| */
			),
			createSerializationSteps(
				33		/* CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				131		/* CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value */,
				258		/* V01*1-steps || value */,
				48		/* CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value */,
				174		/* ')' || no-space value */,
				266		/* V02*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 61/* TypeExpWithoutMultiplicityCS */,
					(130/*TypeExpWithoutMultiplicityCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-3(essentialoclcs::MapTypeCS): { { name="Map" { "(" ownedKeyType=TypeExpCS "," ownedValueType=TypeExpCS ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[132] = createSerializationRule("TypedMultiplicityRefCS-3", 137,
			createSerializationMatchSteps(
				348		/* check-rule essentialoclcs::MapTypeCS.ownedKeyType : TypeExpCS */,
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				349		/* check-rule essentialoclcs::MapTypeCS.ownedValueType : TypeExpCS */,
				215		/* assign V1 = |TypedRefCS::ownedMultiplicity| */,
				161		/* assign V0 = |MapTypeCS::ownedValueType| */,
				33		/* assert (|MapTypeCS::ownedKeyType| - V0) == 0 */,
				32		/* assert (|MapTypeCS::name.'Map'| - 1) == 0 */
			),
			createSerializationSteps(
				34		/* MapTypeCS::name='Map' || soft-space value soft-space */,
				254		/* V00*5-steps || value */,
				173		/* '(' || no-space value no-space */,
				84		/* MapTypeCS::ownedKeyType=TypeExpCS || value */,
				179		/* ',' || no-space value soft-space */,
				138		/* MapTypeCS::ownedValueType=TypeExpCS || value */,
				174		/* ')' || no-space value */,
				258		/* V01*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, false,
					(10/*'Map'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTbase::TypedMultiplicityRefCS-4(basecs::TupleTypeCS): { { name="Tuple" { "(" { ownedParts+=TuplePartCS { "," ownedParts+=TuplePartCS }[*] }[?] ")" }[?] } ownedMultiplicity=MultiplicityCS[?] }
		serializationRules[133] = createSerializationRule("TypedMultiplicityRefCS-4", 137,
			createSerializationMatchSteps(
				313		/* check-rule basecs::TypedRefCS.ownedMultiplicity : MultiplicityCS */,
				309		/* check-rule basecs::TupleTypeCS.ownedParts : TuplePartCS */,
				256		/* assign V3 = |TypedRefCS::ownedMultiplicity| */,
				74		/* assert (|TupleTypeCS::name.'Tuple'| - 1) == 0 */,
				145		/* assign V0 = (|TupleTypeCS::ownedParts| > 0) */,
				196		/* assign V1 = (|TupleTypeCS::ownedParts| > 0) */,
				224		/* assign V2 = (|TupleTypeCS::ownedParts| - 1) */
			),
			createSerializationSteps(
				36		/* TupleTypeCS::name='Tuple' || soft-space value soft-space */,
				256		/* V00*7-steps || value */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				105		/* TupleTypeCS::ownedParts+=TuplePartCS || value */,
				174		/* ')' || no-space value */,
				274		/* V03*1-steps || value */,
				91		/* TypedRefCS::ownedMultiplicity=MultiplicityCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, false,
					(11/*'Tuple'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 20/* MultiplicityCS */,
					(68/*MultiplicityCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 59/* TuplePartCS */,
					(127/*TuplePartCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTimperative::AddStatementCS-0(qvtimperativecs::AddStatementCS): { { "observe" observedProperties+=PathNameCS { "," observedProperties+=PathNameCS }[*] }[?] "add" targetVariable=UnrestrictedName "+=" ownedExpression=ExpCS ";" }
		serializationRules[134] = createSerializationRule("AddStatementCS-0", 1,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule qvtimperativecs::ObservableStatementCS.observedProperties : PathNameCS */,
				373		/* check-rule qvtimperativecs::AddStatementCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				1		/* assert (|AddStatementCS::ownedExpression| - 1) == 0 */,
				2		/* assert (|AddStatementCS::targetVariable| - 1) == 0 */,
				138		/* assign V0 = (|ObservableStatementCS::observedProperties| > 0) */,
				192		/* assign V1 = (|ObservableStatementCS::observedProperties| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				254		/* V00*5-steps || value */,
				227		/* 'observe' || soft-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				193		/* 'add' || soft-space value soft-space */,
				162		/* AddStatementCS::targetVariable=UnrestrictedName || soft-space value soft-space */,
				178		/* '+=' || soft-space value soft-space */,
				60		/* AddStatementCS::ownedExpression=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__TARGET_VARIABLE, -1
				)
			});
		// QVTimperative::AppendParameterBindingCS-0(qvtimperativecs::AppendParameterBindingCS): { referredVariable=UnrestrictedName "appendsTo" value=UnrestrictedName ";" }
		serializationRules[135] = createSerializationRule("AppendParameterBindingCS-0", 2,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				4		/* assert (|AppendParameterBindingCS::value| - 1) == 0 */,
				3		/* assert (|AppendParameterBindingCS::referredVariable| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				150		/* AppendParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space */,
				195		/* 'appendsTo' || soft-space value soft-space */,
				165		/* AppendParameterBindingCS::value=UnrestrictedName || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__REFERRED_VARIABLE, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__VALUE, -1
				)
			});
		// QVTimperative::AppendParameterCS-0(qvtimperativecs::AppendParameterCS): { "append" name=UnrestrictedName ":" ownedType=TypeExpCS ";" }
		serializationRules[136] = createSerializationRule("AppendParameterCS-0", 3,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				194		/* 'append' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::BufferStatementCS-0(qvtimperativecs::BufferStatementCS): { isStrict?="strict"[?] "buffer" { ":" firstPass=LOWER { ".." lastPass=LOWER }[?] }[?] name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] { ":=" ownedExpression=ExpCS }[?] ";" }
		serializationRules[137] = createSerializationRule("BufferStatementCS-0", 7,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				374		/* check-rule qvtimperativecs::BufferStatementCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				259		/* assign V4 = |BufferStatementCS::ownedExpression| */,
				254		/* assign V3 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				200		/* assign V1 = |BufferStatementCS::firstPass| */,
				149		/* assign V0 = |BufferStatementCS::isStrict.'strict'| */,
				228		/* assign V2 = |BufferStatementCS::lastPass| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				26		/* BufferStatementCS::isStrict?='strict' || soft-space value soft-space */,
				198		/* 'buffer' || soft-space value soft-space */,
				264		/* V01*5-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				2		/* BufferStatementCS::firstPass=LOWER || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				181		/* '..' || no-space value no-space */,
				30		/* BufferStatementCS::lastPass=LOWER || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				277		/* V03*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				283		/* V04*2-steps || value */,
				184		/* ':=' || soft-space value soft-space */,
				61		/* BufferStatementCS::ownedExpression=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__FIRST_PASS, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__IS_STRICT, false,
					(26/*'strict'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__LAST_PASS, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTimperative::CheckStatementCS-0(qvtimperativecs::CheckStatementCS): { { "observe" observedProperties+=PathNameCS { "," observedProperties+=PathNameCS }[*] }[?] "check" ownedCondition=ExpCS ";" }
		serializationRules[138] = createSerializationRule("CheckStatementCS-0", 8,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule qvtimperativecs::ObservableStatementCS.observedProperties : PathNameCS */,
				375		/* check-rule qvtimperativecs::CheckStatementCS.ownedCondition : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				6		/* assert (|CheckStatementCS::ownedCondition| - 1) == 0 */,
				138		/* assign V0 = (|ObservableStatementCS::observedProperties| > 0) */,
				192		/* assign V1 = (|ObservableStatementCS::observedProperties| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				254		/* V00*5-steps || value */,
				227		/* 'observe' || soft-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				200		/* 'check' || soft-space value soft-space */,
				49		/* CheckStatementCS::ownedCondition=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.CHECK_STATEMENT_CS__OWNED_CONDITION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::DeclareStatementCS-0(qvtimperativecs::DeclareStatementCS): { { "observe" observedProperties+=PathNameCS { "," observedProperties+=PathNameCS }[*] }[?] isCheck?="check"[?] "var" name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] ":=" ownedExpression=ExpCS ";" }
		serializationRules[139] = createSerializationRule("DeclareStatementCS-0", 22,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				383		/* check-rule qvtimperativecs::ObservableStatementCS.observedProperties : PathNameCS */,
				376		/* check-rule qvtimperativecs::DeclareStatementCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				12		/* assert (|DeclareStatementCS::ownedExpression| - 1) == 0 */,
				254		/* assign V3 = |TypedElementCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				230		/* assign V2 = |DeclareStatementCS::isCheck.'check'| */,
				138		/* assign V0 = (|ObservableStatementCS::observedProperties| > 0) */,
				192		/* assign V1 = (|ObservableStatementCS::observedProperties| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				254		/* V00*5-steps || value */,
				227		/* 'observe' || soft-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				266		/* V02*1-steps || value */,
				11		/* DeclareStatementCS::isCheck?='check' || soft-space value soft-space */,
				243		/* 'var' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				277		/* V03*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				184		/* ':=' || soft-space value soft-space */,
				65		/* DeclareStatementCS::ownedExpression=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__IS_CHECK, false,
					(13/*'check'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTimperative::DirectionCS-0(qvtimperativecs::DirectionCS): { name=Identifier[?] { "imports" imports+=UnrestrictedName { "," imports+=UnrestrictedName }[*] }[?] }
		serializationRules[140] = createSerializationRule("DirectionCS-0", 23,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				164		/* assign V0 = |NamedElementCS::name| */,
				190		/* assign V1 = (|DirectionCS::imports| > 0) */,
				218		/* assign V2 = (|DirectionCS::imports| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				316		/* NamedElementCS::name=Identifier || soft-space value soft-space */,
				264		/* V01*5-steps || value */,
				216		/* 'imports' || soft-space value soft-space */,
				5		/* DirectionCS::imports+=UnrestrictedName || soft-space value soft-space */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				5		/* DirectionCS::imports+=UnrestrictedName || soft-space value soft-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.DIRECTION_CS__IMPORTS, -1
				)
			});
		// QVTimperative::EntryPointCS-0(qvtimperativecs::EntryPointCS): { isStrict?="strict"[?] "entry" { ":" targetName=UnrestrictedName }[?] name=UnrestrictedName { "input" inputTypedModels+=UnrestrictedName { "," inputTypedModels+=UnrestrictedName }[*] }[?] { "output" outputTypedModels+=UnrestrictedName { "," outputTypedModels+=UnrestrictedName }[*] }[?] "{" ownedParameters+=MappingParameterCS[*] ownedStatements+=GuardStatementCS[*] ownedStatements+=CommitStatementCS[*] ownedStatements+=ControlStatementCS[*] "}" }
		serializationRules[141] = createSerializationRule("EntryPointCS-0", 27,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				27		/* MappingCS::isStrict?='strict' || soft-space value soft-space */,
				208		/* 'entry' || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				161		/* EntryPointCS::targetName=UnrestrictedName || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				273		/* V02*5-steps || value */,
				219		/* 'input' || soft-space value soft-space */,
				7		/* EntryPointCS::inputTypedModels+=UnrestrictedName || soft-space value soft-space */,
				278		/* V03*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				7		/* EntryPointCS::inputTypedModels+=UnrestrictedName || soft-space value soft-space */,
				285		/* V04*5-steps || value */,
				229		/* 'output' || soft-space value soft-space */,
				41		/* EntryPointCS::outputTypedModels+=UnrestrictedName || soft-space value soft-space */,
				290		/* V05*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				41		/* EntryPointCS::outputTypedModels+=UnrestrictedName || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				295		/* V06*1-steps || value */,
				96		/* MappingCS::ownedParameters+=MappingParameterCS || value */,
				300		/* V07*1-steps || value */,
				328		/* MappingCS::ownedStatements+=GuardStatementCS || value */,
				305		/* V08*1-steps || value */,
				326		/* MappingCS::ownedStatements+=CommitStatementCS || value */,
				309		/* V09*1-steps || value */,
				327		/* MappingCS::ownedStatements+=ControlStatementCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.MAPPING_CS__IS_STRICT, false,
					(26/*'strict'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__TARGET_NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__INPUT_TYPED_MODELS, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__OUTPUT_TYPED_MODELS, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_PARAMETERS, 19/* MappingParameterCS */,
					(65/*MappingParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_STATEMENTS, 10/* CommitStatementCS,ControlStatementCS,GuardStatementCS */,
					(16/*CommitStatementCS*/ << 4) | 2 /*[*]*/,
					(18/*ControlStatementCS*/ << 4) | 2 /*[*]*/,
					(41/*GuardStatementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTimperative::GuardParameterBindingCS-0(qvtimperativecs::GuardParameterBindingCS): { isCheck?="check"[?] referredVariable=UnrestrictedName "consumes" value=UnrestrictedName ";" }
		serializationRules[142] = createSerializationRule("GuardParameterBindingCS-0", 39,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				15		/* assert (|GuardParameterBindingCS::value| - 1) == 0 */,
				14		/* assert (|GuardParameterBindingCS::referredVariable| - 1) == 0 */,
				156		/* assign V0 = |GuardParameterBindingCS::isCheck.'check'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				12		/* GuardParameterBindingCS::isCheck?='check' || soft-space value soft-space */,
				151		/* GuardParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space */,
				202		/* 'consumes' || soft-space value soft-space */,
				167		/* GuardParameterBindingCS::value=UnrestrictedName || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__IS_CHECK, false,
					(13/*'check'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__REFERRED_VARIABLE, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__VALUE, -1
				)
			});
		// QVTimperative::GuardParameterCS-0(qvtimperativecs::GuardParameterCS): { "guard" ":" referredTypedModel=UnrestrictedName name=UnrestrictedName ":" ownedType=TypeExpCS { "success" successProperty=UnrestrictedName }[?] ";" }
		serializationRules[143] = createSerializationRule("GuardParameterCS-0", 40,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				157		/* assign V0 = |GuardParameterCS::successProperty| */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				16		/* assert (|GuardParameterCS::referredTypedModel| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				212		/* 'guard' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				147		/* GuardParameterCS::referredTypedModel=UnrestrictedName || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				250		/* V00*2-steps || value */,
				237		/* 'success' || soft-space value soft-space */,
				158		/* GuardParameterCS::successProperty=UnrestrictedName || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__SUCCESS_PROPERTY, -1
				)
			});
		// QVTimperative::ImportCS-0(basecs::ImportCS): { "import" { name=Identifier ":" }[?] ownedPathName=URIPathNameCS { isAll?="::" "*" }[?] ";" }
		serializationRules[144] = createSerializationRule("ImportCS-0", 46,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				292		/* check-rule basecs::ImportCS.ownedPathName : URIPathNameCS */,
				203		/* assign V1 = |ImportCS::isAll.'::'| */,
				22		/* assert (|ImportCS::ownedPathName| - 1) == 0 */,
				164		/* assign V0 = |NamedElementCS::name| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				215		/* 'import' || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				316		/* NamedElementCS::name=Identifier || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				108		/* ImportCS::ownedPathName=URIPathNameCS || value */,
				260		/* V01*2-steps || value */,
				10		/* ImportCS::isAll?='::' || no-space value no-space */,
				176		/* '*' || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, false,
					(7/*'::'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 72/* URIPathNameCS */,
					(144/*URIPathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::LoopParameterBindingCS-0(qvtimperativecs::LoopParameterBindingCS): { isCheck?="check"[?] referredVariable=UnrestrictedName "iterates" value=UnrestrictedName ";" }
		serializationRules[145] = createSerializationRule("LoopParameterBindingCS-0", 54,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				28		/* assert (|LoopParameterBindingCS::value| - 1) == 0 */,
				27		/* assert (|LoopParameterBindingCS::referredVariable| - 1) == 0 */,
				160		/* assign V0 = |LoopParameterBindingCS::isCheck.'check'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				13		/* LoopParameterBindingCS::isCheck?='check' || soft-space value soft-space */,
				152		/* LoopParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space */,
				221		/* 'iterates' || soft-space value soft-space */,
				168		/* LoopParameterBindingCS::value=UnrestrictedName || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__IS_CHECK, false,
					(13/*'check'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__REFERRED_VARIABLE, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__VALUE, -1
				)
			});
		// QVTimperative::MappingCS-0(qvtimperativecs::MappingCS): { isStrict?="strict"[?] "map" { ":" firstPass=LOWER { ".." lastPass=LOWER }[?] }[?] name=UnrestrictedName "{" ownedParameters+=MappingParameterCS[*] ownedStatements+=GuardStatementCS[*] ownedStatements+=CommitStatementCS[*] ownedStatements+=ControlStatementCS[*] "}" }
		serializationRules[146] = createSerializationRule("MappingCS-0", 60,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				27		/* MappingCS::isStrict?='strict' || soft-space value soft-space */,
				224		/* 'map' || soft-space value soft-space */,
				264		/* V01*5-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				3		/* MappingCS::firstPass=LOWER || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				181		/* '..' || no-space value no-space */,
				31		/* MappingCS::lastPass=LOWER || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				275		/* V03*1-steps || value */,
				96		/* MappingCS::ownedParameters+=MappingParameterCS || value */,
				281		/* V04*1-steps || value */,
				328		/* MappingCS::ownedStatements+=GuardStatementCS || value */,
				288		/* V05*1-steps || value */,
				326		/* MappingCS::ownedStatements+=CommitStatementCS || value */,
				295		/* V06*1-steps || value */,
				327		/* MappingCS::ownedStatements+=ControlStatementCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(QVTimperativeCSPackage.Literals.MAPPING_CS__FIRST_PASS, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.MAPPING_CS__IS_STRICT, false,
					(26/*'strict'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(QVTimperativeCSPackage.Literals.MAPPING_CS__LAST_PASS, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_PARAMETERS, 19/* MappingParameterCS */,
					(65/*MappingParameterCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_STATEMENTS, 10/* CommitStatementCS,ControlStatementCS,GuardStatementCS */,
					(16/*CommitStatementCS*/ << 4) | 2 /*[*]*/,
					(18/*ControlStatementCS*/ << 4) | 2 /*[*]*/,
					(41/*GuardStatementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTimperative::MappingCallCS-0(qvtimperativecs::MappingCallCS): { "call" ownedPathName=PathNameCS "{" ownedBindings+=MappingParameterBindingCS[*] "}" }
		serializationRules[147] = createSerializationRule("MappingCallCS-0", 61,
			createSerializationMatchSteps(
				96		/* assert |MappingCallCS::isInstall| == 0 */,
				97		/* assert |MappingCallCS::isInvoke| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				377		/* check-rule qvtimperativecs::MappingCallCS.ownedBindings : AppendParameterBindingCS|GuardParameterBindingCS|LoopParameterBindingCS|MappingParameterBindingCS|SimpleParameterBindingCS */,
				378		/* check-rule qvtimperativecs::MappingCallCS.ownedPathName : PathNameCS */,
				162		/* assign V0 = |MappingCallCS::ownedBindings| */,
				36		/* assert (|MappingCallCS::ownedPathName| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				199		/* 'call' || soft-space value soft-space */,
				109		/* MappingCallCS::ownedPathName=PathNameCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				248		/* V00*1-steps || value */,
				44		/* MappingCallCS::ownedBindings+=MappingParameterBindingCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_BINDINGS, 18/* MappingParameterBindingCS */,
					(64/*MappingParameterBindingCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::MappingCallCS-1(qvtimperativecs::MappingCallCS): { isInstall?="install" ownedPathName=PathNameCS "{" ownedBindings+=MappingParameterBindingCS[*] "}" }
		serializationRules[148] = createSerializationRule("MappingCallCS-1", 61,
			createSerializationMatchSteps(
				97		/* assert |MappingCallCS::isInvoke| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				377		/* check-rule qvtimperativecs::MappingCallCS.ownedBindings : AppendParameterBindingCS|GuardParameterBindingCS|LoopParameterBindingCS|MappingParameterBindingCS|SimpleParameterBindingCS */,
				378		/* check-rule qvtimperativecs::MappingCallCS.ownedPathName : PathNameCS */,
				162		/* assign V0 = |MappingCallCS::ownedBindings| */,
				36		/* assert (|MappingCallCS::ownedPathName| - 1) == 0 */,
				34		/* assert (|MappingCallCS::isInstall.'install'| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				16		/* MappingCallCS::isInstall?='install' || soft-space value soft-space */,
				109		/* MappingCallCS::ownedPathName=PathNameCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				248		/* V00*1-steps || value */,
				44		/* MappingCallCS::ownedBindings+=MappingParameterBindingCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INSTALL, false,
					(18/*'install'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_BINDINGS, 18/* MappingParameterBindingCS */,
					(64/*MappingParameterBindingCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::MappingCallCS-2(qvtimperativecs::MappingCallCS): { isInvoke?="invoke" ownedPathName=PathNameCS "{" ownedBindings+=MappingParameterBindingCS[*] "}" }
		serializationRules[149] = createSerializationRule("MappingCallCS-2", 61,
			createSerializationMatchSteps(
				96		/* assert |MappingCallCS::isInstall| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				377		/* check-rule qvtimperativecs::MappingCallCS.ownedBindings : AppendParameterBindingCS|GuardParameterBindingCS|LoopParameterBindingCS|MappingParameterBindingCS|SimpleParameterBindingCS */,
				378		/* check-rule qvtimperativecs::MappingCallCS.ownedPathName : PathNameCS */,
				162		/* assign V0 = |MappingCallCS::ownedBindings| */,
				36		/* assert (|MappingCallCS::ownedPathName| - 1) == 0 */,
				35		/* assert (|MappingCallCS::isInvoke.'invoke'| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				18		/* MappingCallCS::isInvoke?='invoke' || soft-space value soft-space */,
				109		/* MappingCallCS::ownedPathName=PathNameCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				248		/* V00*1-steps || value */,
				44		/* MappingCallCS::ownedBindings+=MappingParameterBindingCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INVOKE, false,
					(20/*'invoke'*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_BINDINGS, 18/* MappingParameterBindingCS */,
					(64/*MappingParameterBindingCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_PATH_NAME, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::MappingIteratorCS-0(essentialoclcs::VariableCS): { name=UnrestrictedName { ":" ownedType=TypeExpCS }[?] }
		serializationRules[150] = createSerializationRule("MappingIteratorCS-0", 62,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				132		/* assert |VariableCS::ownedInitExpression| == 0 */,
				368		/* check-rule essentialoclcs::VariableCS.ownedType : TypeExpCS */,
				185		/* assign V0 = |VariableCS::ownedType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				250		/* V00*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				135		/* VariableCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTimperative::MappingLoopCS-0(qvtimperativecs::MappingLoopCS): { { "observe" observedProperties+=PathNameCS { "," observedProperties+=PathNameCS }[*] }[?] "for" ownedIterator=MappingIteratorCS "in" ownedInExpression=ExpCS "{" ownedMappingStatements+=ControlStatementCS[+] "}" }
		serializationRules[151] = createSerializationRule("MappingLoopCS-0", 63,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule qvtimperativecs::ObservableStatementCS.observedProperties : PathNameCS */,
				379		/* check-rule qvtimperativecs::MappingLoopCS.ownedInExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				380		/* check-rule qvtimperativecs::MappingLoopCS.ownedIterator : MappingIteratorCS */,
				381		/* check-rule qvtimperativecs::MappingLoopCS.ownedMappingStatements : AddStatementCS|ControlStatementCS|MappingCallCS|MappingLoopCS */,
				232		/* assign V2 = |MappingLoopCS::ownedMappingStatements| */,
				37		/* assert (|MappingLoopCS::ownedInExpression| - 1) == 0 */,
				38		/* assert (|MappingLoopCS::ownedIterator| - 1) == 0 */,
				138		/* assign V0 = (|ObservableStatementCS::observedProperties| > 0) */,
				192		/* assign V1 = (|ObservableStatementCS::observedProperties| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				254		/* V00*5-steps || value */,
				227		/* 'observe' || soft-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				211		/* 'for' || soft-space value soft-space */,
				82		/* MappingLoopCS::ownedIterator=MappingIteratorCS || value */,
				217		/* 'in' || soft-space value soft-space */,
				77		/* MappingLoopCS::ownedInExpression=ExpCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				268		/* V02*1-steps || value */,
				88		/* MappingLoopCS::ownedMappingStatements+=ControlStatementCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_ITERATOR, 16/* MappingIteratorCS */,
					(62/*MappingIteratorCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS, 3/* ControlStatementCS */,
					(18/*ControlStatementCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTimperative::NewStatementCS-0(qvtimperativecs::NewStatementCS): { { "observe" observedProperties+=PathNameCS { "," observedProperties+=PathNameCS }[*] }[?] isContained?="contained"[?] "new" ":" referredTypedModel=UnrestrictedName name=UnrestrictedName ":" ownedType=TypeExpCS { ":=" ownedExpression=ExpCS }[?] ";" }
		serializationRules[152] = createSerializationRule("NewStatementCS-0", 79,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				383		/* check-rule qvtimperativecs::ObservableStatementCS.observedProperties : PathNameCS */,
				382		/* check-rule qvtimperativecs::NewStatementCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				250		/* assign V3 = |NewStatementCS::ownedExpression| */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				51		/* assert (|NewStatementCS::referredTypedModel| - 1) == 0 */,
				233		/* assign V2 = |NewStatementCS::isContained.'contained'| */,
				138		/* assign V0 = (|ObservableStatementCS::observedProperties| > 0) */,
				192		/* assign V1 = (|ObservableStatementCS::observedProperties| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				254		/* V00*5-steps || value */,
				227		/* 'observe' || soft-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				266		/* V02*1-steps || value */,
				15		/* NewStatementCS::isContained?='contained' || soft-space value soft-space */,
				225		/* 'new' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				148		/* NewStatementCS::referredTypedModel=UnrestrictedName || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				277		/* V03*2-steps || value */,
				184		/* ':=' || soft-space value soft-space */,
				68		/* NewStatementCS::ownedExpression=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__IS_CONTAINED, false,
					(14/*'contained'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__REFERRED_TYPED_MODEL, -1
				)
			});
		// QVTimperative::ParamDeclarationCS-0(qvtimperativecs::ParamDeclarationCS): { name=UnrestrictedName ":" ownedType=TypeExpCS }
		serializationRules[153] = createSerializationRule("ParamDeclarationCS-0", 84,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::QualifiedPackageCS-0(qvtbasecs::QualifiedPackageCS): { "package" ownedPathName=ScopeNameCS[?] name=UnrestrictedName { ":" nsPrefix=UnrestrictedName }[?] { "=" nsURI=URI }[?] ";" }
		serializationRules[154] = createSerializationRule("QualifiedPackageCS-0", 96,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				109		/* assert |PackageCS::ownedClasses| == 0 */,
				110		/* assert |PackageOwnerCS::ownedPackages| == 0 */,
				371		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				234		/* assign V2 = |PackageCS::nsURI| */,
				206		/* assign V1 = |PackageCS::nsPrefix| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				169		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				230		/* 'package' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				110		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				37		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				38		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 37/* ScopeNameCS */,
					(104/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTimperative::QualifiedPackageCS-1(qvtbasecs::QualifiedPackageCS): { "package" ownedPathName=ScopeNameCS[?] name=UnrestrictedName { ":" nsPrefix=UnrestrictedName }[?] { "=" nsURI=URI }[?] { "{" { ownedClasses+=(ClassCS|TransformationCS)[*] ownedPackages+=QualifiedPackageCS[*] } "}" } }
		serializationRules[155] = createSerializationRule("QualifiedPackageCS-1", 96,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				296		/* check-rule basecs::PackageCS.ownedClasses : ClassCS|DataTypeCS|EnumerationCS|StructuredClassCS|TransformationCS */,
				297		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				371		/* check-rule qvtbasecs::QualifiedPackageCS.ownedPathName : ScopeNameCS */,
				261		/* assign V4 = |PackageOwnerCS::ownedPackages| */,
				251		/* assign V3 = |PackageCS::ownedClasses| */,
				234		/* assign V2 = |PackageCS::nsURI| */,
				206		/* assign V1 = |PackageCS::nsPrefix| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				169		/* assign V0 = |QualifiedPackageCS::ownedPathName| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				230		/* 'package' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				110		/* QualifiedPackageCS::ownedPathName=ScopeNameCS || value */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				37		/* PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space */,
				269		/* V02*2-steps || value */,
				187		/* '=' || soft-space value soft-space */,
				38		/* PackageCS::nsURI=URI || soft-space value soft-space */,
				244		/* '{' || soft-space value push soft-new-line */,
				275		/* V03*1-steps || value */,
				46		/* PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line */,
				281		/* V04*1-steps || value */,
				95		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, false, GrammarCardinality.ZERO_OR_ONE),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, 56/* ClassCS,TransformationCS */,
					(9/*ClassCS*/ << 4) | 2 /*[*]*/,
					(124/*TransformationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 34/* QualifiedPackageCS */,
					(96/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 37/* ScopeNameCS */,
					(104/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				)
			});
		// QVTimperative::QueryCS-0(qvtimperativecs::QueryCS): { isTransient?="transient"[?] "query" name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS ";" }
		serializationRules[156] = createSerializationRule("QueryCS-0", 97,
			createSerializationMatchSteps(
				94		/* assert |JavaImplementationCS::implementation| == 0 */,
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				111		/* assert |QueryCS::ownedExpression| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				385		/* check-rule qvtimperativecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				170		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				194		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				221		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				28		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				233		/* 'query' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				98		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				98		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				174		/* ')' || no-space value */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(27/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 26/* ParamDeclarationCS */,
					(84/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::QueryCS-1(qvtimperativecs::QueryCS): { isTransient?="transient"[?] "query" name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "implementedby" implementation=SINGLE_QUOTED_STRING ";" } }
		serializationRules[157] = createSerializationRule("QueryCS-1", 97,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				111		/* assert |QueryCS::ownedExpression| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				385		/* check-rule qvtimperativecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				24		/* assert (|JavaImplementationCS::implementation| - 1) == 0 */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				170		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				194		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				221		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				28		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				233		/* 'query' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				98		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				98		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				174		/* ')' || no-space value */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				214		/* 'implementedby' || soft-space value soft-space */,
				4		/* JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(27/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 26/* ParamDeclarationCS */,
					(84/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::QueryCS-2(qvtimperativecs::QueryCS): { isTransient?="transient"[?] "query" name=UnrestrictedName "(" { ownedParameters+=ParamDeclarationCS { "," ownedParameters+=ParamDeclarationCS }[*] }[?] ")" ":" ownedType=TypeExpCS { "{" ownedExpression=ExpCS "}" } }
		serializationRules[158] = createSerializationRule("QueryCS-2", 97,
			createSerializationMatchSteps(
				94		/* assert |JavaImplementationCS::implementation| == 0 */,
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				384		/* check-rule qvtimperativecs::QueryCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				385		/* check-rule qvtimperativecs::QueryCS.ownedParameters : ParamDeclarationCS */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				58		/* assert (|QueryCS::ownedExpression| - 1) == 0 */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				170		/* assign V0 = |QueryCS::isTransient.'transient'| */,
				194		/* assign V1 = (|QueryCS::ownedParameters| > 0) */,
				221		/* assign V2 = (|QueryCS::ownedParameters| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				28		/* QueryCS::isTransient?='transient' || soft-space value soft-space */,
				233		/* 'query' || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				173		/* '(' || no-space value no-space */,
				263		/* V01*4-steps || value */,
				98		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				270		/* V02*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				98		/* QueryCS::ownedParameters+=ParamDeclarationCS || value */,
				174		/* ')' || no-space value */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				69		/* QueryCS::ownedExpression=ExpCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.QUERY_CS__IS_TRANSIENT, false,
					(27/*'transient'*/ << 4) | 1 /*[?]*/
				),
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 26/* ParamDeclarationCS */,
					(84/*ParamDeclarationCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				)
			});
		// QVTimperative::ScopeNameCS-0(basecs::PathNameCS): { ownedPathElements+=FirstPathElementCS "::" { ownedPathElements+=NextPathElementCS "::" }[*] }
		serializationRules[159] = createSerializationRule("ScopeNameCS-0", 104,
			null,	// run-time resolution using SerializationSteps
			createSerializationSteps(
				321		/* PathNameCS::ownedPathElements+=FirstPathElementCS || value */,
				183		/* '::' || no-space value no-space */,
				251		/* V00*2-steps || value */,
				322		/* PathNameCS::ownedPathElements+=NextPathElementCS || value */,
				183		/* '::' || no-space value no-space */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 24/* FirstPathElementCS,NextPathElementCS */,
					(38/*FirstPathElementCS*/ << 4) | 0 /*[1]*/,
					(80/*NextPathElementCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTimperative::SetStatementCS-0(qvtimperativecs::SetStatementCS): { { "observe" observedProperties+=PathNameCS { "," observedProperties+=PathNameCS }[*] }[?] isNotify?="notify"[?] "set" referredVariable=UnrestrictedName "." referredProperty=UnrestrictedName ":=" ownedExpression=ExpCS ";" }
		serializationRules[160] = createSerializationRule("SetStatementCS-0", 106,
			createSerializationMatchSteps(
				116		/* assert |SetStatementCS::isPartial| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule qvtimperativecs::ObservableStatementCS.observedProperties : PathNameCS */,
				386		/* check-rule qvtimperativecs::SetStatementCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				60		/* assert (|SetStatementCS::ownedExpression| - 1) == 0 */,
				61		/* assert (|SetStatementCS::referredProperty| - 1) == 0 */,
				62		/* assert (|SetStatementCS::referredVariable| - 1) == 0 */,
				235		/* assign V2 = |SetStatementCS::isNotify.'notify'| */,
				138		/* assign V0 = (|ObservableStatementCS::observedProperties| > 0) */,
				192		/* assign V1 = (|ObservableStatementCS::observedProperties| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				254		/* V00*5-steps || value */,
				227		/* 'observe' || soft-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				266		/* V02*1-steps || value */,
				19		/* SetStatementCS::isNotify?='notify' || soft-space value soft-space */,
				235		/* 'set' || soft-space value soft-space */,
				153		/* SetStatementCS::referredVariable=UnrestrictedName || soft-space value soft-space */,
				180		/* '.' || soft-space value soft-space */,
				145		/* SetStatementCS::referredProperty=UnrestrictedName || soft-space value soft-space */,
				184		/* ':=' || soft-space value soft-space */,
				70		/* SetStatementCS::ownedExpression=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_NOTIFY, false,
					(21/*'notify'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_PROPERTY, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_VARIABLE, -1
				)
			});
		// QVTimperative::SetStatementCS-1(qvtimperativecs::SetStatementCS): { { "observe" observedProperties+=PathNameCS { "," observedProperties+=PathNameCS }[*] }[?] isNotify?="notify"[?] "set" referredVariable=UnrestrictedName "." referredProperty=UnrestrictedName isPartial?="+=" ownedExpression=ExpCS ";" }
		serializationRules[161] = createSerializationRule("SetStatementCS-1", 106,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				383		/* check-rule qvtimperativecs::ObservableStatementCS.observedProperties : PathNameCS */,
				386		/* check-rule qvtimperativecs::SetStatementCS.ownedExpression : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				60		/* assert (|SetStatementCS::ownedExpression| - 1) == 0 */,
				59		/* assert (|SetStatementCS::isPartial.'+='| - 1) == 0 */,
				61		/* assert (|SetStatementCS::referredProperty| - 1) == 0 */,
				62		/* assert (|SetStatementCS::referredVariable| - 1) == 0 */,
				235		/* assign V2 = |SetStatementCS::isNotify.'notify'| */,
				138		/* assign V0 = (|ObservableStatementCS::observedProperties| > 0) */,
				192		/* assign V1 = (|ObservableStatementCS::observedProperties| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				254		/* V00*5-steps || value */,
				227		/* 'observe' || soft-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				261		/* V01*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				39		/* ObservableStatementCS::observedProperties+=PathNameCS || value */,
				266		/* V02*1-steps || value */,
				19		/* SetStatementCS::isNotify?='notify' || soft-space value soft-space */,
				235		/* 'set' || soft-space value soft-space */,
				153		/* SetStatementCS::referredVariable=UnrestrictedName || soft-space value soft-space */,
				180		/* '.' || soft-space value soft-space */,
				145		/* SetStatementCS::referredProperty=UnrestrictedName || soft-space value soft-space */,
				21		/* SetStatementCS::isPartial?='+=' || soft-space value soft-space */,
				70		/* SetStatementCS::ownedExpression=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_NOTIFY, false,
					(21/*'notify'*/ << 4) | 1 /*[?]*/
				),
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_PARTIAL, false,
					(5/*'+='*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 28/* PathNameCS */,
					(86/*PathNameCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__OWNED_EXPRESSION, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_PROPERTY, -1
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_VARIABLE, -1
				)
			});
		// QVTimperative::SimpleParameterBindingCS-0(qvtimperativecs::SimpleParameterBindingCS): { isCheck?="check"[?] referredVariable=UnrestrictedName "uses" ownedValue=ExpCS ";" }
		serializationRules[162] = createSerializationRule("SimpleParameterBindingCS-0", 108,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				387		/* check-rule qvtimperativecs::SimpleParameterBindingCS.ownedValue : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				65		/* assert (|SimpleParameterBindingCS::ownedValue| - 1) == 0 */,
				66		/* assert (|SimpleParameterBindingCS::referredVariable| - 1) == 0 */,
				173		/* assign V0 = |SimpleParameterBindingCS::isCheck.'check'| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				247		/* V00*1-steps || value */,
				14		/* SimpleParameterBindingCS::isCheck?='check' || soft-space value soft-space */,
				154		/* SimpleParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space */,
				242		/* 'uses' || soft-space value soft-space */,
				137		/* SimpleParameterBindingCS::ownedValue=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationEnumeratedAttribute(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__IS_CHECK, false,
					(13/*'check'*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__OWNED_VALUE, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__REFERRED_VARIABLE, -1
				)
			});
		// QVTimperative::SimpleParameterCS-0(qvtimperativecs::SimpleParameterCS): { "in" ":" referredTypedModel=UnrestrictedName name=UnrestrictedName ":" ownedType=TypeExpCS ";" }
		serializationRules[163] = createSerializationRule("SimpleParameterCS-0", 109,
			createSerializationMatchSteps(
				128		/* assert |TypedElementCS::isOptional| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				129		/* assert |TypedElementCS::qualifiers| == 0 */,
				311		/* check-rule basecs::TypedElementCS.ownedType : TypeExpCS */,
				77		/* assert (|TypedElementCS::ownedType| - 1) == 0 */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				67		/* assert (|SimpleParameterCS::referredTypedModel| - 1) == 0 */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				217		/* 'in' || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				149		/* SimpleParameterCS::referredTypedModel=UnrestrictedName || soft-space value soft-space */,
				314		/* NamedElementCS::name=UnrestrictedName || soft-space value soft-space */,
				182		/* ':' || soft-space value soft-space */,
				329		/* TypedElementCS::ownedType=TypeExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 0 /*[1]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_CS__REFERRED_TYPED_MODEL, -1
				)
			});
		// QVTimperative::SpeculateStatementCS-0(qvtimperativecs::SpeculateStatementCS): { "speculate" ownedConditions+=ExpCS { "," ownedConditions+=ExpCS }[*] ";" }
		serializationRules[164] = createSerializationRule("SpeculateStatementCS-0", 113,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				388		/* check-rule qvtimperativecs::SpeculateStatementCS.ownedConditions : BooleanLiteralExpCS|CollectionLiteralExpCS|ExpCS|IfExpCS|InvalidLiteralExpCS|LambdaLiteralExpCS|LetExpCS|MapLiteralExpCS|NameExpCS|NestedExpCS|NullLiteralExpCS|NumberLiteralExpCS|PrefixedLetExpCS|PrefixedPrimaryExpCS|PrimaryExpCS|PrimitiveLiteralExpCS|SelfExpCS|StringLiteralExpCS|TupleLiteralExpCS|TypeLiteralExpCS|UnlimitedNaturalLiteralExpCS */,
				140		/* assign V0 = (|SpeculateStatementCS::ownedConditions| - 1) */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				236		/* 'speculate' || soft-space value soft-space */,
				52		/* SpeculateStatementCS::ownedConditions+=ExpCS || value */,
				251		/* V00*2-steps || value */,
				179		/* ',' || no-space value soft-space */,
				52		/* SpeculateStatementCS::ownedConditions+=ExpCS || value */,
				185		/* ';' || no-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(QVTimperativeCSPackage.Literals.SPECULATE_STATEMENT_CS__OWNED_CONDITIONS, 8/* ExpCS */,
					(37/*ExpCS*/ << 4) | 3 /*[+]*/
				)
			});
		// QVTimperative::TopLevelCS-0(qvtimperativecs::TopLevelCS): { ownedImports+=ImportCS[*] { ownedPackages+=QualifiedPackageCS[*] ownedTransformations+=TransformationCS[*] } }
		serializationRules[165] = createSerializationRule("TopLevelCS-0", 123,
			createSerializationMatchSteps(
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				299		/* check-rule basecs::RootCS.ownedImports : ImportCS */,
				297		/* check-rule basecs::PackageOwnerCS.ownedPackages : QualifiedPackageCS */,
				389		/* check-rule qvtimperativecs::TopLevelCS.ownedTransformations : TransformationCS */,
				237		/* assign V2 = |TopLevelCS::ownedTransformations| */,
				207		/* assign V1 = |PackageOwnerCS::ownedPackages| */,
				172		/* assign V0 = |RootCS::ownedImports| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				248		/* V00*1-steps || value */,
				75		/* RootCS::ownedImports+=ImportCS || value */,
				259		/* V01*1-steps || value */,
				95		/* PackageOwnerCS::ownedPackages+=QualifiedPackageCS || value */,
				267		/* V02*1-steps || value */,
				128		/* TopLevelCS::ownedTransformations+=TransformationCS || value */
			),
			new @NonNull SerializationFeature [] {
				createSerializationReference(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 11/* ImportCS */,
					(46/*ImportCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 34/* QualifiedPackageCS */,
					(96/*QualifiedPackageCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 55/* TransformationCS */,
					(124/*TransformationCS*/ << 4) | 2 /*[*]*/
				)
			});
		// QVTimperative::TransformationCS-0(qvtimperativecs::TransformationCS): { "transformation" ownedPathName=ScopeNameCS[?] name=UnreservedName { ":" ownedContextType=TypeExpCS }[?] "{" { ownedDirections+=DirectionCS ";" }[*] { ownedMappings+=(EntryPointCS|MappingCS)[*] ownedQueries+=QueryCS[*] } "}" }
		serializationRules[166] = createSerializationRule("TransformationCS-0", 124,
			createSerializationMatchSteps(
				83		/* assert |ClassCS::instanceClassName| == 0 */,
				98		/* assert |ModelElementCS::ownedAnnotations| == 0 */,
				84		/* assert |ClassCS::ownedConstraints| == 0 */,
				126		/* assert |TemplateableElementCS::ownedSignature| == 0 */,
				82		/* assert |AbstractTransformationCS::ownedTargets| == 0 */,
				390		/* check-rule qvtimperativecs::TransformationCS.ownedContextType : TypeExpCS */,
				391		/* check-rule qvtimperativecs::TransformationCS.ownedDirections : DirectionCS */,
				392		/* check-rule qvtimperativecs::TransformationCS.ownedMappings : EntryPointCS|MappingCS */,
				369		/* check-rule qvtbasecs::AbstractTransformationCS.ownedPathName : ScopeNameCS */,
				393		/* check-rule qvtimperativecs::TransformationCS.ownedQueries : QueryCS */,
				263		/* assign V4 = |TransformationCS::ownedQueries| */,
				253		/* assign V3 = |TransformationCS::ownedMappings| */,
				238		/* assign V2 = |TransformationCS::ownedDirections| */,
				212		/* assign V1 = |TransformationCS::ownedContextType| */,
				42		/* assert (|NamedElementCS::name| - 1) == 0 */,
				148		/* assign V0 = |AbstractTransformationCS::ownedPathName| */
			),
			createSerializationSteps(
				311		/* wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value */,
				241		/* 'transformation' || soft-space value soft-space */,
				247		/* V00*1-steps || value */,
				107		/* AbstractTransformationCS::ownedPathName=ScopeNameCS || value */,
				313		/* NamedElementCS::name=UnreservedName || soft-space value soft-space */,
				260		/* V01*2-steps || value */,
				182		/* ':' || soft-space value soft-space */,
				53		/* TransformationCS::ownedContextType=TypeExpCS || value */,
				244		/* '{' || soft-space value push soft-new-line */,
				270		/* V02*2-steps || value */,
				57		/* TransformationCS::ownedDirections+=DirectionCS || value */,
				185		/* ';' || no-space value soft-new-line */,
				275		/* V03*1-steps || value */,
				89		/* TransformationCS::ownedMappings+=EntryPointCS|MappingCS || value */,
				281		/* V04*1-steps || value */,
				116		/* TransformationCS::ownedQueries+=QueryCS || value */,
				246		/* '}' || pop soft-space value soft-new-line */
			),
			new @NonNull SerializationFeature [] {
				createSerializationSimpleAttribute(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, true, GrammarCardinality.ONE),
				createSerializationReference(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_CONTEXT_TYPE, 60/* TypeExpCS */,
					(129/*TypeExpCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 5/* DirectionCS */,
					(23/*DirectionCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_MAPPINGS, 15/* EntryPointCS,MappingCS */,
					(27/*EntryPointCS*/ << 4) | 2 /*[*]*/,
					(60/*MappingCS*/ << 4) | 2 /*[*]*/
				),
				createSerializationReference(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 37/* ScopeNameCS */,
					(104/*ScopeNameCS*/ << 4) | 1 /*[?]*/
				),
				createSerializationReference(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES, 35/* QueryCS */,
					(97/*QueryCS*/ << 4) | 2 /*[*]*/
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
		serializationSteps[0] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT, 102 /*SINGLE_QUOTED_STRING*/, 7);
		// 1: SpecificationCS::exprString=UNQUOTED_STRING || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[1] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.SPECIFICATION_CS__EXPR_STRING, 140 /*UNQUOTED_STRING*/, 2);
		// 2: BufferStatementCS::firstPass=LOWER || soft-space value soft-space
		serializationSteps[2] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__FIRST_PASS, 50 /*LOWER*/, 7);
		// 3: MappingCS::firstPass=LOWER || soft-space value soft-space
		serializationSteps[3] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CS__FIRST_PASS, 50 /*LOWER*/, 7);
		// 4: JavaImplementationCS::implementation=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[4] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, getCrossReference(QVTbaseCSPackage.Literals.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION, "SINGLE_QUOTED_STRING"), 102, 7);
		// 5: DirectionCS::imports+=UnrestrictedName || soft-space value soft-space
		serializationSteps[5] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.DIRECTION_CS__IMPORTS, getCrossReference(QVTimperativeCSPackage.Literals.DIRECTION_CS__IMPORTS, "UnrestrictedName"), 148, 7);
		// 6: SimpleTargetElementCS::input?='input' || soft-space value soft-space
		serializationSteps[6] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__INPUT, 17 /* 'input' */, 7);
		// 7: EntryPointCS::inputTypedModels+=UnrestrictedName || soft-space value soft-space
		serializationSteps[7] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__INPUT_TYPED_MODELS, getCrossReference(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__INPUT_TYPED_MODELS, "UnrestrictedName"), 148, 7);
		// 8: ClassCS::instanceClassName=SINGLE_QUOTED_STRING || soft-space value soft-space
		serializationSteps[8] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.CLASS_CS__INSTANCE_CLASS_NAME, 102 /*SINGLE_QUOTED_STRING*/, 7);
		// 9: StructuredClassCS::isAbstract?='abstract' || soft-space value soft-space
		serializationSteps[9] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_ABSTRACT, 12 /* 'abstract' */, 7);
		// 10: ImportCS::isAll?='::' || no-space value no-space
		serializationSteps[10] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.IMPORT_CS__IS_ALL, 7 /* '::' */, 4);
		// 11: DeclareStatementCS::isCheck?='check' || soft-space value soft-space
		serializationSteps[11] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__IS_CHECK, 13 /* 'check' */, 7);
		// 12: GuardParameterBindingCS::isCheck?='check' || soft-space value soft-space
		serializationSteps[12] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__IS_CHECK, 13 /* 'check' */, 7);
		// 13: LoopParameterBindingCS::isCheck?='check' || soft-space value soft-space
		serializationSteps[13] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__IS_CHECK, 13 /* 'check' */, 7);
		// 14: SimpleParameterBindingCS::isCheck?='check' || soft-space value soft-space
		serializationSteps[14] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__IS_CHECK, 13 /* 'check' */, 7);
		// 15: NewStatementCS::isContained?='contained' || soft-space value soft-space
		serializationSteps[15] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__IS_CONTAINED, 14 /* 'contained' */, 7);
		// 16: MappingCallCS::isInstall?='install' || soft-space value soft-space
		serializationSteps[16] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INSTALL, 18 /* 'install' */, 7);
		// 17: StructuredClassCS::isInterface?='interface' || soft-space value soft-space
		serializationSteps[17] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__IS_INTERFACE, 19 /* 'interface' */, 7);
		// 18: MappingCallCS::isInvoke?='invoke' || soft-space value soft-space
		serializationSteps[18] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__IS_INVOKE, 20 /* 'invoke' */, 7);
		// 19: SetStatementCS::isNotify?='notify' || soft-space value soft-space
		serializationSteps[19] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_NOTIFY, 21 /* 'notify' */, 7);
		// 20: MultiplicityCS::isNullFree?='|1' || no-space value no-space
		serializationSteps[20] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_CS__IS_NULL_FREE, 30 /* '|1' */, 4);
		// 21: SetStatementCS::isPartial?='+=' || soft-space value soft-space
		serializationSteps[21] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__IS_PARTIAL, 5 /* '+=' */, 7);
		// 22: AbstractNameExpCS::isPre?='@' || soft-space value soft-space
		serializationSteps[22] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__IS_PRE, 9 /* '@' */, 7);
		// 23: DataTypeCS::isPrimitive?='primitive' || soft-space value soft-space
		serializationSteps[23] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_PRIMITIVE, 23 /* 'primitive' */, 7);
		// 24: DataTypeCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[24] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.DATA_TYPE_CS__IS_SERIALIZABLE, 24 /* 'serializable' */, 7);
		// 25: EnumerationCS::isSerializable?='serializable' || soft-space value soft-space
		serializationSteps[25] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.ENUMERATION_CS__IS_SERIALIZABLE, 24 /* 'serializable' */, 7);
		// 26: BufferStatementCS::isStrict?='strict' || soft-space value soft-space
		serializationSteps[26] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__IS_STRICT, 26 /* 'strict' */, 7);
		// 27: MappingCS::isStrict?='strict' || soft-space value soft-space
		serializationSteps[27] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.MAPPING_CS__IS_STRICT, 26 /* 'strict' */, 7);
		// 28: QueryCS::isTransient?='transient' || soft-space value soft-space
		serializationSteps[28] = createSerializationStepAssignKeyword(QVTimperativeCSPackage.Literals.QUERY_CS__IS_TRANSIENT, 27 /* 'transient' */, 7);
		// 29: SimpleTargetElementCS::iterates+=UnrestrictedName || soft-space value soft-space
		serializationSteps[29] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__ITERATES, "UnrestrictedName"), 148, 7);
		// 30: BufferStatementCS::lastPass=LOWER || soft-space value soft-space
		serializationSteps[30] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__LAST_PASS, 50 /*LOWER*/, 7);
		// 31: MappingCS::lastPass=LOWER || soft-space value soft-space
		serializationSteps[31] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CS__LAST_PASS, 50 /*LOWER*/, 7);
		// 32: MultiplicityBoundsCS::lowerBound=LOWER || soft-space value soft-space
		serializationSteps[32] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__LOWER_BOUND, 50 /*LOWER*/, 7);
		// 33: CollectionTypeCS::name=CollectionTypeIdentifier || soft-space value soft-space
		serializationSteps[33] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__NAME, 15 /*CollectionTypeIdentifier*/, 7);
		// 34: MapTypeCS::name='Map' || soft-space value soft-space
		serializationSteps[34] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__NAME, 10 /* 'Map' */, 7);
		// 35: PrimitiveTypeRefCS::name=PrimitiveTypeIdentifier || soft-space value soft-space
		serializationSteps[35] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME, 93 /*PrimitiveTypeIdentifier*/, 7);
		// 36: TupleTypeCS::name='Tuple' || soft-space value soft-space
		serializationSteps[36] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TUPLE_TYPE_CS__NAME, 11 /* 'Tuple' */, 7);
		// 37: PackageCS::nsPrefix=UnrestrictedName || soft-space value soft-space
		serializationSteps[37] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_PREFIX, 148 /*UnrestrictedName*/, 7);
		// 38: PackageCS::nsURI=URI || soft-space value soft-space
		serializationSteps[38] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_CS__NS_URI, 142 /*URI*/, 7);
		// 39: ObservableStatementCS::observedProperties+=PathNameCS || value
		serializationSteps[39] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES, 86 /*PathNameCS*/, 0);
		// 40: SimpleTargetElementCS::output?='output' || soft-space value soft-space
		serializationSteps[40] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__OUTPUT, 22 /* 'output' */, 7);
		// 41: EntryPointCS::outputTypedModels+=UnrestrictedName || soft-space value soft-space
		serializationSteps[41] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__OUTPUT_TYPED_MODELS, getCrossReference(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__OUTPUT_TYPED_MODELS, "UnrestrictedName"), 148, 7);
		// 42: TemplateParameterSubstitutionCS::ownedActualParameter=TypeRefCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[42] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER, 136 /*TypeRefCS*/, 2);
		// 43: TypedTypeRefCS::ownedBinding=TemplateBindingCS || value
		serializationSteps[43] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_BINDING, 120 /*TemplateBindingCS*/, 0);
		// 44: MappingCallCS::ownedBindings+=MappingParameterBindingCS || value
		serializationSteps[44] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_BINDINGS, 64 /*MappingParameterBindingCS*/, 0);
		// 45: OperationCS::ownedBodyExpressions+=SpecificationCS || value
		serializationSteps[45] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_BODY_EXPRESSIONS, 112 /*SpecificationCS*/, 0);
		// 46: PackageCS::ownedClasses+=ClassCS|TransformationCS || half-new-line value half-new-line
		serializationSteps[46] = createSerializationStepAssigns(BaseCSPackage.Literals.PACKAGE_CS__OWNED_CLASSES, -1, new int[] { 9/*ClassCS*/,124/*TransformationCS*/}, 3);
		// 47: NavigatingArgCS::ownedCoIterator=CoIteratorVariableCS || value
		serializationSteps[47] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_CO_ITERATOR, 10 /*CoIteratorVariableCS*/, 0);
		// 48: CollectionTypeCS::ownedCollectionMultiplicity=MultiplicityCS || value
		serializationSteps[48] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_COLLECTION_MULTIPLICITY, 68 /*MultiplicityCS*/, 0);
		// 49: CheckStatementCS::ownedCondition=ExpCS || value
		serializationSteps[49] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.CHECK_STATEMENT_CS__OWNED_CONDITION, 37 /*ExpCS*/, 0);
		// 50: IfExpCS::ownedCondition=ExpCS|PatternExpCS || value
		serializationSteps[50] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_CONDITION, -1, new int[] { 37/*ExpCS*/,87/*PatternExpCS*/}, 0);
		// 51: IfThenExpCS::ownedCondition=ExpCS || value
		serializationSteps[51] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION, 37 /*ExpCS*/, 0);
		// 52: SpeculateStatementCS::ownedConditions+=ExpCS || value
		serializationSteps[52] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.SPECULATE_STATEMENT_CS__OWNED_CONDITIONS, 37 /*ExpCS*/, 0);
		// 53: TransformationCS::ownedContextType=TypeExpCS || value
		serializationSteps[53] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_CONTEXT_TYPE, 129 /*TypeExpCS*/, 0);
		// 54: AbstractNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[54] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 19 /*CurlyBracketedClauseCS*/, 0);
		// 55: TypeNameExpCS::ownedCurlyBracketedClause=CurlyBracketedClauseCS || value
		serializationSteps[55] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_CURLY_BRACKETED_CLAUSE, 19 /*CurlyBracketedClauseCS*/, 0);
		// 56: StructuralFeatureCS::ownedDefaultExpressions+=SpecificationCS || value
		serializationSteps[56] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS__OWNED_DEFAULT_EXPRESSIONS, 112 /*SpecificationCS*/, 0);
		// 57: TransformationCS::ownedDirections+=DirectionCS || value
		serializationSteps[57] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_DIRECTIONS, 23 /*DirectionCS*/, 0);
		// 58: IfExpCS::ownedElseExpression=ExpCS || value
		serializationSteps[58] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_ELSE_EXPRESSION, 37 /*ExpCS*/, 0);
		// 59: OperationCS::ownedExceptions+=TypedRefCS || value
		serializationSteps[59] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_EXCEPTIONS, 138 /*TypedRefCS*/, 0);
		// 60: AddStatementCS::ownedExpression=ExpCS || value
		serializationSteps[60] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 61: BufferStatementCS::ownedExpression=ExpCS || value
		serializationSteps[61] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 62: CollectionLiteralPartCS::ownedExpression=ExpCS || value
		serializationSteps[62] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 63: CollectionLiteralPartCS::ownedExpression=PatternExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[63] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_EXPRESSION, 87 /*PatternExpCS*/, 2);
		// 64: ContextCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[64] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 2);
		// 65: DeclareStatementCS::ownedExpression=ExpCS || value
		serializationSteps[65] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 66: ExpSpecificationCS::ownedExpression=ExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[66] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 2);
		// 67: NestedExpCS::ownedExpression=ExpCS || value
		serializationSteps[67] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 68: NewStatementCS::ownedExpression=ExpCS || value
		serializationSteps[68] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 69: QueryCS::ownedExpression=ExpCS || value
		serializationSteps[69] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 70: SetStatementCS::ownedExpression=ExpCS || value
		serializationSteps[70] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__OWNED_EXPRESSION, 37 /*ExpCS*/, 0);
		// 71: LambdaLiteralExpCS::ownedExpressionCS=ExpCS || value
		serializationSteps[71] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS, 37 /*ExpCS*/, 0);
		// 72: TypeParameterCS::ownedExtends+=TypedRefCS || value
		serializationSteps[72] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPE_PARAMETER_CS__OWNED_EXTENDS, 138 /*TypedRefCS*/, 0);
		// 73: WildcardTypeRefCS::ownedExtends=TypedRefCS || value
		serializationSteps[73] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS__OWNED_EXTENDS, 138 /*TypedRefCS*/, 0);
		// 74: IfExpCS::ownedIfThenExpressions+=ElseIfThenExpCS || value
		serializationSteps[74] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS, 26 /*ElseIfThenExpCS*/, 0);
		// 75: RootCS::ownedImports+=ImportCS || value
		serializationSteps[75] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ROOT_CS__OWNED_IMPORTS, 46 /*ImportCS*/, 0);
		// 76: LetExpCS::ownedInExpression=ExpCS || value
		serializationSteps[76] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_IN_EXPRESSION, 37 /*ExpCS*/, 0);
		// 77: MappingLoopCS::ownedInExpression=ExpCS || value
		serializationSteps[77] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_IN_EXPRESSION, 37 /*ExpCS*/, 0);
		// 78: NavigatingArgCS::ownedInitExpression=ExpCS || value
		serializationSteps[78] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_INIT_EXPRESSION, 37 /*ExpCS*/, 0);
		// 79: ShadowPartCS::ownedInitExpression=ExpCS|PatternExpCS || value
		serializationSteps[79] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, -1, new int[] { 37/*ExpCS*/,87/*PatternExpCS*/}, 0);
		// 80: ShadowPartCS::ownedInitExpression=StringLiteralExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[80] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__OWNED_INIT_EXPRESSION, 116 /*StringLiteralExpCS*/, 2);
		// 81: VariableCS::ownedInitExpression=ExpCS || value
		serializationSteps[81] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_INIT_EXPRESSION, 37 /*ExpCS*/, 0);
		// 82: MappingLoopCS::ownedIterator=MappingIteratorCS || value
		serializationSteps[82] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_ITERATOR, 62 /*MappingIteratorCS*/, 0);
		// 83: MapLiteralPartCS::ownedKey=ExpCS || value
		serializationSteps[83] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY, 37 /*ExpCS*/, 0);
		// 84: MapTypeCS::ownedKeyType=TypeExpCS || value
		serializationSteps[84] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_KEY_TYPE, 129 /*TypeExpCS*/, 0);
		// 85: CollectionLiteralPartCS::ownedLastExpression=ExpCS || value
		serializationSteps[85] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS__OWNED_LAST_EXPRESSION, 37 /*ExpCS*/, 0);
		// 86: InfixExpCS::ownedLeft=PrefixedPrimaryExpCS || value
		serializationSteps[86] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT, 89 /*PrefixedPrimaryExpCS*/, 0);
		// 87: EnumerationCS::ownedLiterals+=EnumerationLiteralCS || value
		serializationSteps[87] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_CS__OWNED_LITERALS, 29 /*EnumerationLiteralCS*/, 0);
		// 88: MappingLoopCS::ownedMappingStatements+=ControlStatementCS || value
		serializationSteps[88] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS, 18 /*ControlStatementCS*/, 0);
		// 89: TransformationCS::ownedMappings+=EntryPointCS|MappingCS || value
		serializationSteps[89] = createSerializationStepAssigns(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_MAPPINGS, -1, new int[] { 27/*EntryPointCS*/,60/*MappingCS*/}, 0);
		// 90: TemplateBindingCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[90] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_MULTIPLICITY, 68 /*MultiplicityCS*/, 0);
		// 91: TypedRefCS::ownedMultiplicity=MultiplicityCS || value
		serializationSteps[91] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_REF_CS__OWNED_MULTIPLICITY, 68 /*MultiplicityCS*/, 0);
		// 92: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || value
		serializationSteps[92] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 73 /*NavigatingArgExpCS*/, 0);
		// 93: NavigatingArgCS::ownedNameExpression=NavigatingArgExpCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[93] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_NAME_EXPRESSION, 73 /*NavigatingArgExpCS*/, 2);
		// 94: StructuredClassCS::ownedOperations+=OperationCS || value
		serializationSteps[94] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_OPERATIONS, 83 /*OperationCS*/, 0);
		// 95: PackageOwnerCS::ownedPackages+=QualifiedPackageCS || value
		serializationSteps[95] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PACKAGE_OWNER_CS__OWNED_PACKAGES, 96 /*QualifiedPackageCS*/, 0);
		// 96: MappingCS::ownedParameters+=MappingParameterCS || value
		serializationSteps[96] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_PARAMETERS, 65 /*MappingParameterCS*/, 0);
		// 97: OperationCS::ownedParameters+=ParameterCS || value
		serializationSteps[97] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETERS, 85 /*ParameterCS*/, 0);
		// 98: QueryCS::ownedParameters+=ParamDeclarationCS || value
		serializationSteps[98] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.QUERY_CS__OWNED_PARAMETERS, 84 /*ParamDeclarationCS*/, 0);
		// 99: TemplateSignatureCS::ownedParameters+=TypeParameterCS || value
		serializationSteps[99] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS__OWNED_PARAMETERS, 135 /*TypeParameterCS*/, 0);
		// 100: CollectionLiteralExpCS::ownedParts+=CollectionLiteralPartCS || value
		serializationSteps[100] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS, 12 /*CollectionLiteralPartCS*/, 0);
		// 101: CollectionPatternCS::ownedParts+=PatternExpCS || value
		serializationSteps[101] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_PARTS, 87 /*PatternExpCS*/, 0);
		// 102: CurlyBracketedClauseCS::ownedParts+=ShadowPartCS || value
		serializationSteps[102] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS__OWNED_PARTS, 107 /*ShadowPartCS*/, 0);
		// 103: MapLiteralExpCS::ownedParts+=MapLiteralPartCS || value
		serializationSteps[103] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_PARTS, 58 /*MapLiteralPartCS*/, 0);
		// 104: TupleLiteralExpCS::ownedParts+=TupleLiteralPartCS || value
		serializationSteps[104] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS__OWNED_PARTS, 126 /*TupleLiteralPartCS*/, 0);
		// 105: TupleTypeCS::ownedParts+=TuplePartCS || value
		serializationSteps[105] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TUPLE_TYPE_CS__OWNED_PARTS, 127 /*TuplePartCS*/, 0);
		// 106: AbstractNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[106] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_PATH_NAME, 86 /*PathNameCS*/, 0);
		// 107: AbstractTransformationCS::ownedPathName=ScopeNameCS || value
		serializationSteps[107] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME, 104 /*ScopeNameCS*/, 0);
		// 108: ImportCS::ownedPathName=URIPathNameCS || value
		serializationSteps[108] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.IMPORT_CS__OWNED_PATH_NAME, 144 /*URIPathNameCS*/, 0);
		// 109: MappingCallCS::ownedPathName=PathNameCS || value
		serializationSteps[109] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CALL_CS__OWNED_PATH_NAME, 86 /*PathNameCS*/, 0);
		// 110: QualifiedPackageCS::ownedPathName=ScopeNameCS || value
		serializationSteps[110] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME, 104 /*ScopeNameCS*/, 0);
		// 111: TypeNameExpCS::ownedPathName=PathNameCS || value
		serializationSteps[111] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATH_NAME, 86 /*PathNameCS*/, 0);
		// 112: TypedTypeRefCS::ownedPathName=PathNameCS || value
		serializationSteps[112] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME, 86 /*PathNameCS*/, 0);
		// 113: TypeNameExpCS::ownedPatternGuard=ExpCS || value
		serializationSteps[113] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS__OWNED_PATTERN_GUARD, 37 /*ExpCS*/, 0);
		// 114: PatternExpCS::ownedPatternType=TypeExpCS || value
		serializationSteps[114] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__OWNED_PATTERN_TYPE, 129 /*TypeExpCS*/, 0);
		// 115: StructuredClassCS::ownedProperties+=StructuralFeatureCS || value
		serializationSteps[115] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_PROPERTIES, 117 /*StructuralFeatureCS*/, 0);
		// 116: TransformationCS::ownedQueries+=QueryCS || value
		serializationSteps[116] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.TRANSFORMATION_CS__OWNED_QUERIES, 97 /*QueryCS*/, 0);
		// 117: AbstractNameExpCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[117] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_ROUND_BRACKETED_CLAUSE, 99 /*RoundBracketedClauseCS*/, 0);
		// 118: LetVariableCS::ownedRoundBracketedClause=RoundBracketedClauseCS || value
		serializationSteps[118] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_VARIABLE_CS__OWNED_ROUND_BRACKETED_CLAUSE, 99 /*RoundBracketedClauseCS*/, 0);
		// 119: TemplateableElementCS::ownedSignature=TemplateSignatureCS || value
		serializationSteps[119] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATEABLE_ELEMENT_CS__OWNED_SIGNATURE, 122 /*TemplateSignatureCS*/, 0);
		// 120: AbstractNameExpCS::ownedSquareBracketedClauses+=SquareBracketedClauseCS || value
		serializationSteps[120] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ABSTRACT_NAME_EXP_CS__OWNED_SQUARE_BRACKETED_CLAUSES, 114 /*SquareBracketedClauseCS*/, 0);
		// 121: TemplateBindingCS::ownedSubstitutions+=TemplateParameterSubstitutionCS || value
		serializationSteps[121] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TEMPLATE_BINDING_CS__OWNED_SUBSTITUTIONS, 121 /*TemplateParameterSubstitutionCS*/, 0);
		// 122: StructuredClassCS::ownedSuperTypes+=TypedRefCS || value
		serializationSteps[122] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.STRUCTURED_CLASS_CS__OWNED_SUPER_TYPES, 138 /*TypedRefCS*/, 0);
		// 123: CompoundTargetElementCS::ownedTargetElements+=SimpleTargetElementCS || value
		serializationSteps[123] = createSerializationStepAssignedRuleCall(QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS, 111 /*SimpleTargetElementCS*/, 0);
		// 124: TargetCS::ownedTargetElements+=SimpleTargetElementCS|CompoundTargetElementCS || value
		serializationSteps[124] = createSerializationStepAssigns(QVTbaseCSPackage.Literals.TARGET_CS__OWNED_TARGET_ELEMENTS, -1, new int[] { 111/*SimpleTargetElementCS*/,17/*CompoundTargetElementCS*/}, 0);
		// 125: SquareBracketedClauseCS::ownedTerms+=ExpCS || value
		serializationSteps[125] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS__OWNED_TERMS, 37 /*ExpCS*/, 0);
		// 126: IfExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[126] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_EXP_CS__OWNED_THEN_EXPRESSION, 37 /*ExpCS*/, 0);
		// 127: IfThenExpCS::ownedThenExpression=ExpCS || value
		serializationSteps[127] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION, 37 /*ExpCS*/, 0);
		// 128: TopLevelCS::ownedTransformations+=TransformationCS || value
		serializationSteps[128] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.TOP_LEVEL_CS__OWNED_TRANSFORMATIONS, 124 /*TransformationCS*/, 0);
		// 129: CollectionLiteralExpCS::ownedType=CollectionTypeCS || value
		serializationSteps[129] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, 14 /*CollectionTypeCS*/, 0);
		// 130: CollectionPatternCS::ownedType=CollectionTypeCS || value
		serializationSteps[130] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__OWNED_TYPE, 14 /*CollectionTypeCS*/, 0);
		// 131: CollectionTypeCS::ownedType=TypeExpWithoutMultiplicityCS || value
		serializationSteps[131] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS__OWNED_TYPE, 130 /*TypeExpWithoutMultiplicityCS*/, 0);
		// 132: MapLiteralExpCS::ownedType=MapTypeCS || value
		serializationSteps[132] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS__OWNED_TYPE, 59 /*MapTypeCS*/, 0);
		// 133: NavigatingArgCS::ownedType=TypeExpCS || value
		serializationSteps[133] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__OWNED_TYPE, 129 /*TypeExpCS*/, 0);
		// 134: TypeLiteralExpCS::ownedType=TypeLiteralWithMultiplicityCS || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[134] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE, 133 /*TypeLiteralWithMultiplicityCS*/, 2);
		// 135: VariableCS::ownedType=TypeExpCS || value
		serializationSteps[135] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.VARIABLE_CS__OWNED_TYPE, 129 /*TypeExpCS*/, 0);
		// 136: MapLiteralPartCS::ownedValue=ExpCS || value
		serializationSteps[136] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE, 37 /*ExpCS*/, 0);
		// 137: SimpleParameterBindingCS::ownedValue=ExpCS || value
		serializationSteps[137] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__OWNED_VALUE, 37 /*ExpCS*/, 0);
		// 138: MapTypeCS::ownedValueType=TypeExpCS || value
		serializationSteps[138] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.MAP_TYPE_CS__OWNED_VALUE_TYPE, 129 /*TypeExpCS*/, 0);
		// 139: LetExpCS::ownedVariables+=LetVariableCS || value
		serializationSteps[139] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.LET_EXP_CS__OWNED_VARIABLES, 53 /*LetVariableCS*/, 0);
		// 140: PatternExpCS::patternVariableName=UnrestrictedName || soft-space value soft-space
		serializationSteps[140] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.PATTERN_EXP_CS__PATTERN_VARIABLE_NAME, 148 /*UnrestrictedName*/, 7);
		// 141: NavigatingArgCS::prefix=';' || no-space value soft-new-line
		serializationSteps[141] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 8 /* ';' */, 5);
		// 142: NavigatingArgCS::prefix=',' || no-space value soft-space
		serializationSteps[142] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 6 /* ',' */, 6);
		// 143: NavigatingArgCS::prefix='|' || soft-space value soft-space
		serializationSteps[143] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS__PREFIX, 29 /* '|' */, 7);
		// 144: ReferenceCS::referredOpposite=UnrestrictedName || soft-space value soft-space
		serializationSteps[144] = createSerializationStepCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, getCrossReference(BaseCSPackage.Literals.REFERENCE_CS__REFERRED_OPPOSITE, "UnrestrictedName"), 148, 7);
		// 145: SetStatementCS::referredProperty=UnrestrictedName || soft-space value soft-space
		serializationSteps[145] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_PROPERTY, getCrossReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_PROPERTY, "UnrestrictedName"), 148, 7);
		// 146: ShadowPartCS::referredProperty=UnrestrictedName || soft-space value soft-space
		serializationSteps[146] = createSerializationStepCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, getCrossReference(EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY, "UnrestrictedName"), 148, 7);
		// 147: GuardParameterCS::referredTypedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[147] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL, getCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL, "UnrestrictedName"), 148, 7);
		// 148: NewStatementCS::referredTypedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[148] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__REFERRED_TYPED_MODEL, getCrossReference(QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS__REFERRED_TYPED_MODEL, "UnrestrictedName"), 148, 7);
		// 149: SimpleParameterCS::referredTypedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[149] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_CS__REFERRED_TYPED_MODEL, getCrossReference(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_CS__REFERRED_TYPED_MODEL, "UnrestrictedName"), 148, 7);
		// 150: AppendParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space
		serializationSteps[150] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__REFERRED_VARIABLE, getCrossReference(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__REFERRED_VARIABLE, "UnrestrictedName"), 148, 7);
		// 151: GuardParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space
		serializationSteps[151] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__REFERRED_VARIABLE, getCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__REFERRED_VARIABLE, "UnrestrictedName"), 148, 7);
		// 152: LoopParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space
		serializationSteps[152] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__REFERRED_VARIABLE, getCrossReference(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__REFERRED_VARIABLE, "UnrestrictedName"), 148, 7);
		// 153: SetStatementCS::referredVariable=UnrestrictedName || soft-space value soft-space
		serializationSteps[153] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_VARIABLE, getCrossReference(QVTimperativeCSPackage.Literals.SET_STATEMENT_CS__REFERRED_VARIABLE, "UnrestrictedName"), 148, 7);
		// 154: SimpleParameterBindingCS::referredVariable=UnrestrictedName || soft-space value soft-space
		serializationSteps[154] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__REFERRED_VARIABLE, getCrossReference(QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS__REFERRED_VARIABLE, "UnrestrictedName"), 148, 7);
		// 155: CollectionPatternCS::restVariableName=Identifier || soft-space value soft-space
		serializationSteps[155] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS__REST_VARIABLE_NAME, 44 /*Identifier*/, 7);
		// 156: StringLiteralExpCS::segments+=StringLiteral || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[156] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS__SEGMENTS, 115 /*StringLiteral*/, 2);
		// 157: MultiplicityStringCS::stringBounds='*|+|?' || soft-space value soft-space
		serializationSteps[157] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.MULTIPLICITY_STRING_CS__STRING_BOUNDS, 4 /* '*|+|?' */, 7);
		// 158: GuardParameterCS::successProperty=UnrestrictedName || soft-space value soft-space
		serializationSteps[158] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__SUCCESS_PROPERTY, getCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS__SUCCESS_PROPERTY, "UnrestrictedName"), 148, 7);
		// 159: BooleanLiteralExpCS::symbol='false|true' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[159] = createSerializationStepAssignKeyword(EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS__SYMBOL, 16 /* 'false|true' */, 2);
		// 160: NumberLiteralExpCS::symbol=NUMBER_LITERAL || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[160] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL, 70 /*NUMBER_LITERAL*/, 2);
		// 161: EntryPointCS::targetName=UnrestrictedName || soft-space value soft-space
		serializationSteps[161] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.ENTRY_POINT_CS__TARGET_NAME, 148 /*UnrestrictedName*/, 7);
		// 162: AddStatementCS::targetVariable=UnrestrictedName || soft-space value soft-space
		serializationSteps[162] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__TARGET_VARIABLE, getCrossReference(QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS__TARGET_VARIABLE, "UnrestrictedName"), 148, 7);
		// 163: SimpleTargetElementCS::typedModel=UnrestrictedName || soft-space value soft-space
		serializationSteps[163] = createSerializationStepCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, getCrossReference(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL, "UnrestrictedName"), 148, 7);
		// 164: MultiplicityBoundsCS::upperBound=UPPER || soft-space value soft-space
		serializationSteps[164] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS__UPPER_BOUND, 141 /*UPPER*/, 7);
		// 165: AppendParameterBindingCS::value=UnrestrictedName || soft-space value soft-space
		serializationSteps[165] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__VALUE, getCrossReference(QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS__VALUE, "UnrestrictedName"), 148, 7);
		// 166: EnumerationLiteralCS::value=SIGNED || soft-space value soft-space
		serializationSteps[166] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.ENUMERATION_LITERAL_CS__VALUE, 100 /*SIGNED*/, 7);
		// 167: GuardParameterBindingCS::value=UnrestrictedName || soft-space value soft-space
		serializationSteps[167] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__VALUE, getCrossReference(QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS__VALUE, "UnrestrictedName"), 148, 7);
		// 168: LoopParameterBindingCS::value=UnrestrictedName || soft-space value soft-space
		serializationSteps[168] = createSerializationStepCrossReference(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__VALUE, getCrossReference(QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS__VALUE, "UnrestrictedName"), 148, 7);
		// 169: SimpleTargetElementCS::via?='via' || soft-space value soft-space
		serializationSteps[169] = createSerializationStepAssignKeyword(QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS__VIA, 28 /* 'via' */, 7);
		// 170: '!serializable' || soft-space value soft-space
		serializationSteps[170] = createSerializationStepKeyword("!serializable", 7);
		// 171: '#' || no-space value no-space
		serializationSteps[171] = createSerializationStepKeyword("#", 4);
		// 172: '&&' || soft-space value soft-space
		serializationSteps[172] = createSerializationStepKeyword("&&", 7);
		// 173: '(' || no-space value no-space
		serializationSteps[173] = createSerializationStepKeyword("(", 4);
		// 174: ')' || no-space value
		serializationSteps[174] = createSerializationStepKeyword(")", 1);
		// 175: '*' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[175] = createSerializationStepKeyword("*", 2);
		// 176: '*' || soft-space value soft-space
		serializationSteps[176] = createSerializationStepKeyword("*", 7);
		// 177: '++' || soft-space value soft-space
		serializationSteps[177] = createSerializationStepKeyword("++", 7);
		// 178: '+=' || soft-space value soft-space
		serializationSteps[178] = createSerializationStepKeyword("+=", 7);
		// 179: ',' || no-space value soft-space
		serializationSteps[179] = createSerializationStepKeyword(",", 6);
		// 180: '.' || soft-space value soft-space
		serializationSteps[180] = createSerializationStepKeyword(".", 7);
		// 181: '..' || no-space value no-space
		serializationSteps[181] = createSerializationStepKeyword("..", 4);
		// 182: ':' || soft-space value soft-space
		serializationSteps[182] = createSerializationStepKeyword(":", 7);
		// 183: '::' || no-space value no-space
		serializationSteps[183] = createSerializationStepKeyword("::", 4);
		// 184: ':=' || soft-space value soft-space
		serializationSteps[184] = createSerializationStepKeyword(":=", 7);
		// 185: ';' || no-space value soft-new-line
		serializationSteps[185] = createSerializationStepKeyword(";", 5);
		// 186: '<-' || soft-space value soft-space
		serializationSteps[186] = createSerializationStepKeyword("<-", 7);
		// 187: '=' || soft-space value soft-space
		serializationSteps[187] = createSerializationStepKeyword("=", 7);
		// 188: '?' || soft-space value soft-space
		serializationSteps[188] = createSerializationStepKeyword("?", 7);
		// 189: 'Lambda' || soft-space value soft-space
		serializationSteps[189] = createSerializationStepKeyword("Lambda", 7);
		// 190: 'Tuple' || soft-space value soft-space
		serializationSteps[190] = createSerializationStepKeyword("Tuple", 7);
		// 191: '[' || no-space value no-space
		serializationSteps[191] = createSerializationStepKeyword("[", 4);
		// 192: ']' || no-space value
		serializationSteps[192] = createSerializationStepKeyword("]", 1);
		// 193: 'add' || soft-space value soft-space
		serializationSteps[193] = createSerializationStepKeyword("add", 7);
		// 194: 'append' || soft-space value soft-space
		serializationSteps[194] = createSerializationStepKeyword("append", 7);
		// 195: 'appendsTo' || soft-space value soft-space
		serializationSteps[195] = createSerializationStepKeyword("appendsTo", 7);
		// 196: 'attribute' || soft-space value soft-space
		serializationSteps[196] = createSerializationStepKeyword("attribute", 7);
		// 197: 'body' || soft-space value soft-space
		serializationSteps[197] = createSerializationStepKeyword("body", 7);
		// 198: 'buffer' || soft-space value soft-space
		serializationSteps[198] = createSerializationStepKeyword("buffer", 7);
		// 199: 'call' || soft-space value soft-space
		serializationSteps[199] = createSerializationStepKeyword("call", 7);
		// 200: 'check' || soft-space value soft-space
		serializationSteps[200] = createSerializationStepKeyword("check", 7);
		// 201: 'class' || soft-space value soft-space
		serializationSteps[201] = createSerializationStepKeyword("class", 7);
		// 202: 'consumes' || soft-space value soft-space
		serializationSteps[202] = createSerializationStepKeyword("consumes", 7);
		// 203: 'datatype' || soft-space value soft-space
		serializationSteps[203] = createSerializationStepKeyword("datatype", 7);
		// 204: 'derivation' || soft-space value soft-space
		serializationSteps[204] = createSerializationStepKeyword("derivation", 7);
		// 205: 'else' || soft-space value soft-space
		serializationSteps[205] = createSerializationStepKeyword("else", 7);
		// 206: 'elseif' || soft-space value soft-space
		serializationSteps[206] = createSerializationStepKeyword("elseif", 7);
		// 207: 'endif' || soft-space value soft-space
		serializationSteps[207] = createSerializationStepKeyword("endif", 7);
		// 208: 'entry' || soft-space value soft-space
		serializationSteps[208] = createSerializationStepKeyword("entry", 7);
		// 209: 'enum' || soft-space value soft-space
		serializationSteps[209] = createSerializationStepKeyword("enum", 7);
		// 210: 'extends' || soft-space value soft-space
		serializationSteps[210] = createSerializationStepKeyword("extends", 7);
		// 211: 'for' || soft-space value soft-space
		serializationSteps[211] = createSerializationStepKeyword("for", 7);
		// 212: 'guard' || soft-space value soft-space
		serializationSteps[212] = createSerializationStepKeyword("guard", 7);
		// 213: 'if' || soft-space value soft-space
		serializationSteps[213] = createSerializationStepKeyword("if", 7);
		// 214: 'implementedby' || soft-space value soft-space
		serializationSteps[214] = createSerializationStepKeyword("implementedby", 7);
		// 215: 'import' || soft-space value soft-space
		serializationSteps[215] = createSerializationStepKeyword("import", 7);
		// 216: 'imports' || soft-space value soft-space
		serializationSteps[216] = createSerializationStepKeyword("imports", 7);
		// 217: 'in' || soft-space value soft-space
		serializationSteps[217] = createSerializationStepKeyword("in", 7);
		// 218: 'initial' || soft-space value soft-space
		serializationSteps[218] = createSerializationStepKeyword("initial", 7);
		// 219: 'input' || soft-space value soft-space
		serializationSteps[219] = createSerializationStepKeyword("input", 7);
		// 220: 'invalid' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[220] = createSerializationStepKeyword("invalid", 2);
		// 221: 'iterates' || soft-space value soft-space
		serializationSteps[221] = createSerializationStepKeyword("iterates", 7);
		// 222: 'let' || soft-space value soft-space
		serializationSteps[222] = createSerializationStepKeyword("let", 7);
		// 223: 'literal' || soft-space value soft-space
		serializationSteps[223] = createSerializationStepKeyword("literal", 7);
		// 224: 'map' || soft-space value soft-space
		serializationSteps[224] = createSerializationStepKeyword("map", 7);
		// 225: 'new' || soft-space value soft-space
		serializationSteps[225] = createSerializationStepKeyword("new", 7);
		// 226: 'null' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[226] = createSerializationStepKeyword("null", 2);
		// 227: 'observe' || soft-space value soft-space
		serializationSteps[227] = createSerializationStepKeyword("observe", 7);
		// 228: 'operation' || soft-space value soft-space
		serializationSteps[228] = createSerializationStepKeyword("operation", 7);
		// 229: 'output' || soft-space value soft-space
		serializationSteps[229] = createSerializationStepKeyword("output", 7);
		// 230: 'package' || soft-space value soft-space
		serializationSteps[230] = createSerializationStepKeyword("package", 7);
		// 231: 'pre' || soft-space value soft-space
		serializationSteps[231] = createSerializationStepKeyword("pre", 7);
		// 232: 'property' || soft-space value soft-space
		serializationSteps[232] = createSerializationStepKeyword("property", 7);
		// 233: 'query' || soft-space value soft-space
		serializationSteps[233] = createSerializationStepKeyword("query", 7);
		// 234: 'self' || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[234] = createSerializationStepKeyword("self", 2);
		// 235: 'set' || soft-space value soft-space
		serializationSteps[235] = createSerializationStepKeyword("set", 7);
		// 236: 'speculate' || soft-space value soft-space
		serializationSteps[236] = createSerializationStepKeyword("speculate", 7);
		// 237: 'success' || soft-space value soft-space
		serializationSteps[237] = createSerializationStepKeyword("success", 7);
		// 238: 'target' || soft-space value soft-space
		serializationSteps[238] = createSerializationStepKeyword("target", 7);
		// 239: 'then' || soft-space value soft-space
		serializationSteps[239] = createSerializationStepKeyword("then", 7);
		// 240: 'throws' || soft-space value soft-space
		serializationSteps[240] = createSerializationStepKeyword("throws", 7);
		// 241: 'transformation' || soft-space value soft-space
		serializationSteps[241] = createSerializationStepKeyword("transformation", 7);
		// 242: 'uses' || soft-space value soft-space
		serializationSteps[242] = createSerializationStepKeyword("uses", 7);
		// 243: 'var' || soft-space value soft-space
		serializationSteps[243] = createSerializationStepKeyword("var", 7);
		// 244: '{' || soft-space value push soft-new-line
		serializationSteps[244] = createSerializationStepKeyword("{", 9);
		// 245: '|?' || no-space value no-space
		serializationSteps[245] = createSerializationStepKeyword("|?", 4);
		// 246: '}' || pop soft-space value soft-new-line
		serializationSteps[246] = createSerializationStepKeyword("}", 8);
		// 247: V00*1-steps || value
		serializationSteps[247] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 1, 0);
		// 248: V00*1-steps || value
		serializationSteps[248] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 1, 0);
		// 249: V00*1-steps || value
		serializationSteps[249] = createSerializationStepSequence((0/*V0*/ << 4) | 3/*[+]*/, 1, 0);
		// 250: V00*2-steps || value
		serializationSteps[250] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 2, 0);
		// 251: V00*2-steps || value
		serializationSteps[251] = createSerializationStepSequence((0/*V0*/ << 4) | 2/*[*]*/, 2, 0);
		// 252: V00*3-steps || value
		serializationSteps[252] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 3, 0);
		// 253: V00*4-steps || value
		serializationSteps[253] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 4, 0);
		// 254: V00*5-steps || value
		serializationSteps[254] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 5, 0);
		// 255: V00*6-steps || value
		serializationSteps[255] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 6, 0);
		// 256: V00*7-steps || value
		serializationSteps[256] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 7, 0);
		// 257: V00*8-steps || value
		serializationSteps[257] = createSerializationStepSequence((0/*V0*/ << 4) | 1/*[?]*/, 8, 0);
		// 258: V01*1-steps || value
		serializationSteps[258] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 1, 0);
		// 259: V01*1-steps || value
		serializationSteps[259] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 1, 0);
		// 260: V01*2-steps || value
		serializationSteps[260] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 2, 0);
		// 261: V01*2-steps || value
		serializationSteps[261] = createSerializationStepSequence((1/*V1*/ << 4) | 2/*[*]*/, 2, 0);
		// 262: V01*3-steps || value
		serializationSteps[262] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 3, 0);
		// 263: V01*4-steps || value
		serializationSteps[263] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 4, 0);
		// 264: V01*5-steps || value
		serializationSteps[264] = createSerializationStepSequence((1/*V1*/ << 4) | 1/*[?]*/, 5, 0);
		// 265: V10*1-steps || value
		serializationSteps[265] = createSerializationStepSequence((10/*V10*/ << 4) | 1/*[?]*/, 1, 0);
		// 266: V02*1-steps || value
		serializationSteps[266] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 1, 0);
		// 267: V02*1-steps || value
		serializationSteps[267] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 1, 0);
		// 268: V02*1-steps || value
		serializationSteps[268] = createSerializationStepSequence((2/*V2*/ << 4) | 3/*[+]*/, 1, 0);
		// 269: V02*2-steps || value
		serializationSteps[269] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 2, 0);
		// 270: V02*2-steps || value
		serializationSteps[270] = createSerializationStepSequence((2/*V2*/ << 4) | 2/*[*]*/, 2, 0);
		// 271: V02*3-steps || value
		serializationSteps[271] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 3, 0);
		// 272: V02*4-steps || value
		serializationSteps[272] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 4, 0);
		// 273: V02*5-steps || value
		serializationSteps[273] = createSerializationStepSequence((2/*V2*/ << 4) | 1/*[?]*/, 5, 0);
		// 274: V03*1-steps || value
		serializationSteps[274] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 1, 0);
		// 275: V03*1-steps || value
		serializationSteps[275] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 1, 0);
		// 276: V03*1-steps || value
		serializationSteps[276] = createSerializationStepSequence((3/*V3*/ << 4) | 3/*[+]*/, 1, 0);
		// 277: V03*2-steps || value
		serializationSteps[277] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 2, 0);
		// 278: V03*2-steps || value
		serializationSteps[278] = createSerializationStepSequence((3/*V3*/ << 4) | 2/*[*]*/, 2, 0);
		// 279: V03*3-steps || value
		serializationSteps[279] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 3, 0);
		// 280: V03*4-steps || value
		serializationSteps[280] = createSerializationStepSequence((3/*V3*/ << 4) | 1/*[?]*/, 4, 0);
		// 281: V04*1-steps || value
		serializationSteps[281] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 1, 0);
		// 282: V04*1-steps || value
		serializationSteps[282] = createSerializationStepSequence((4/*V4*/ << 4) | 3/*[+]*/, 1, 0);
		// 283: V04*2-steps || value
		serializationSteps[283] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 2, 0);
		// 284: V04*4-steps || value
		serializationSteps[284] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 4, 0);
		// 285: V04*5-steps || value
		serializationSteps[285] = createSerializationStepSequence((4/*V4*/ << 4) | 1/*[?]*/, 5, 0);
		// 286: V04*5-steps || value
		serializationSteps[286] = createSerializationStepSequence((4/*V4*/ << 4) | 2/*[*]*/, 5, 0);
		// 287: V05*1-steps || value
		serializationSteps[287] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 1, 0);
		// 288: V05*1-steps || value
		serializationSteps[288] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 1, 0);
		// 289: V05*1-steps || value
		serializationSteps[289] = createSerializationStepSequence((5/*V5*/ << 4) | 3/*[+]*/, 1, 0);
		// 290: V05*2-steps || value
		serializationSteps[290] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 2, 0);
		// 291: V05*4-steps || value
		serializationSteps[291] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 4, 0);
		// 292: V05*5-steps || value
		serializationSteps[292] = createSerializationStepSequence((5/*V5*/ << 4) | 1/*[?]*/, 5, 0);
		// 293: V05*5-steps || value
		serializationSteps[293] = createSerializationStepSequence((5/*V5*/ << 4) | 2/*[*]*/, 5, 0);
		// 294: V06*1-steps || value
		serializationSteps[294] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 1, 0);
		// 295: V06*1-steps || value
		serializationSteps[295] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 1, 0);
		// 296: V06*2-steps || value
		serializationSteps[296] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 2, 0);
		// 297: V06*4-steps || value
		serializationSteps[297] = createSerializationStepSequence((6/*V6*/ << 4) | 1/*[?]*/, 4, 0);
		// 298: V06*5-steps || value
		serializationSteps[298] = createSerializationStepSequence((6/*V6*/ << 4) | 2/*[*]*/, 5, 0);
		// 299: V07*1-steps || value
		serializationSteps[299] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 1, 0);
		// 300: V07*1-steps || value
		serializationSteps[300] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 1, 0);
		// 301: V07*1-steps || value
		serializationSteps[301] = createSerializationStepSequence((7/*V7*/ << 4) | 3/*[+]*/, 1, 0);
		// 302: V07*4-steps || value
		serializationSteps[302] = createSerializationStepSequence((7/*V7*/ << 4) | 1/*[?]*/, 4, 0);
		// 303: V07*5-steps || value
		serializationSteps[303] = createSerializationStepSequence((7/*V7*/ << 4) | 2/*[*]*/, 5, 0);
		// 304: V08*1-steps || value
		serializationSteps[304] = createSerializationStepSequence((8/*V8*/ << 4) | 1/*[?]*/, 1, 0);
		// 305: V08*1-steps || value
		serializationSteps[305] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 1, 0);
		// 306: V08*1-steps || value
		serializationSteps[306] = createSerializationStepSequence((8/*V8*/ << 4) | 3/*[+]*/, 1, 0);
		// 307: V08*5-steps || value
		serializationSteps[307] = createSerializationStepSequence((8/*V8*/ << 4) | 2/*[*]*/, 5, 0);
		// 308: V09*1-steps || value
		serializationSteps[308] = createSerializationStepSequence((9/*V9*/ << 4) | 1/*[?]*/, 1, 0);
		// 309: V09*1-steps || value
		serializationSteps[309] = createSerializationStepSequence((9/*V9*/ << 4) | 2/*[*]*/, 1, 0);
		// 310: V09*5-steps || value
		serializationSteps[310] = createSerializationStepSequence((9/*V9*/ << 4) | 2/*[*]*/, 5, 0);
		// 311: wrapper || org.eclipse.ocl.xtext.base.serializer.BaseCommentSegmentSupport value
		serializationSteps[311] = createSerializationStepWrapper(2);
		// 312: NamedElementCS::name=UnaryOperatorName || soft-space value soft-space
		serializationSteps[312] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 145 /*UnaryOperatorName*/, 7);
		// 313: NamedElementCS::name=UnreservedName || soft-space value soft-space
		serializationSteps[313] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 147 /*UnreservedName*/, 7);
		// 314: NamedElementCS::name=UnrestrictedName || soft-space value soft-space
		serializationSteps[314] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 148 /*UnrestrictedName*/, 7);
		// 315: NamedElementCS::name=EnumerationLiteralName || soft-space value soft-space
		serializationSteps[315] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 30 /*EnumerationLiteralName*/, 7);
		// 316: NamedElementCS::name=Identifier || soft-space value soft-space
		serializationSteps[316] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 44 /*Identifier*/, 7);
		// 317: NamedElementCS::name=BinaryOperatorName || soft-space value soft-space
		serializationSteps[317] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME, 5 /*BinaryOperatorName*/, 7);
		// 318: RoundBracketedClauseCS::ownedArguments+=NavigatingArgCS || value
		serializationSteps[318] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, 72 /*NavigatingArgCS*/, 0);
		// 319: RoundBracketedClauseCS::ownedArguments+=NavigatingCommaArgCS|NavigatingSemiArgCS|NavigatingBarArgCS || value
		serializationSteps[319] = createSerializationStepAssigns(EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS__OWNED_ARGUMENTS, -1, new int[] { 75/*NavigatingCommaArgCS*/,76/*NavigatingSemiArgCS*/,74/*NavigatingBarArgCS*/}, 0);
		// 320: PathNameCS::ownedPathElements+=URIFirstPathElementCS || value
		serializationSteps[320] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 143 /*URIFirstPathElementCS*/, 0);
		// 321: PathNameCS::ownedPathElements+=FirstPathElementCS || value
		serializationSteps[321] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 38 /*FirstPathElementCS*/, 0);
		// 322: PathNameCS::ownedPathElements+=NextPathElementCS || value
		serializationSteps[322] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.PATH_NAME_CS__OWNED_PATH_ELEMENTS, 80 /*NextPathElementCS*/, 0);
		// 323: OperatorExpCS::ownedRight=ExpCS || value
		serializationSteps[323] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 37 /*ExpCS*/, 0);
		// 324: OperatorExpCS::ownedRight=PrefixedLetExpCS || value
		serializationSteps[324] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 88 /*PrefixedLetExpCS*/, 0);
		// 325: OperatorExpCS::ownedRight=PrefixedPrimaryExpCS || value
		serializationSteps[325] = createSerializationStepAssignedRuleCall(EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT, 89 /*PrefixedPrimaryExpCS*/, 0);
		// 326: MappingCS::ownedStatements+=CommitStatementCS || value
		serializationSteps[326] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_STATEMENTS, 16 /*CommitStatementCS*/, 0);
		// 327: MappingCS::ownedStatements+=ControlStatementCS || value
		serializationSteps[327] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_STATEMENTS, 18 /*ControlStatementCS*/, 0);
		// 328: MappingCS::ownedStatements+=GuardStatementCS || value
		serializationSteps[328] = createSerializationStepAssignedRuleCall(QVTimperativeCSPackage.Literals.MAPPING_CS__OWNED_STATEMENTS, 41 /*GuardStatementCS*/, 0);
		// 329: TypedElementCS::ownedType=TypeExpCS || value
		serializationSteps[329] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 129 /*TypeExpCS*/, 0);
		// 330: TypedElementCS::ownedType=TypedMultiplicityRefCS || value
		serializationSteps[330] = createSerializationStepAssignedRuleCall(BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE, 137 /*TypedMultiplicityRefCS*/, 0);
		// 331: TypedElementCS::qualifiers+='!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[331] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 0 /* '!composes|!derived|!ordered|!readonly|!resolve|!transient|!unique|!unsettable|!volatile|composes|derived|ordered|readonly|resolve|transient|unique|unsettable|volatile' */, 7);
		// 332: TypedElementCS::qualifiers+='!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' || soft-space value soft-space
		serializationSteps[332] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 1 /* '!derived|!id|!ordered|!readonly|!transient|!unique|!unsettable|!volatile|derived|id|ordered|readonly|transient|unique|unsettable|volatile' */, 7);
		// 333: TypedElementCS::qualifiers+='!derived|!ordered|!unique|derived|ordered|unique' || soft-space value soft-space
		serializationSteps[333] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 2 /* '!derived|!ordered|!unique|derived|ordered|unique' */, 7);
		// 334: TypedElementCS::qualifiers+='!ordered|!unique|ordered|unique' || soft-space value soft-space
		serializationSteps[334] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 3 /* '!ordered|!unique|ordered|unique' */, 7);
		// 335: TypedElementCS::qualifiers+='definition' || soft-space value soft-space
		serializationSteps[335] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 15 /* 'definition' */, 7);
		// 336: TypedElementCS::qualifiers+='static' || soft-space value soft-space
		serializationSteps[336] = createSerializationStepAssignKeyword(BaseCSPackage.Literals.TYPED_ELEMENT_CS__QUALIFIERS, 25 /* 'static' */, 7);
		// 337: PathElementCS::referredElement=URI || soft-space value soft-space
		serializationSteps[337] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "URI"), 142, 7);
		// 338: PathElementCS::referredElement=UnreservedName || soft-space value soft-space
		serializationSteps[338] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnreservedName"), 147, 7);
		// 339: PathElementCS::referredElement=UnrestrictedName || soft-space value soft-space
		serializationSteps[339] = createSerializationStepCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, getCrossReference(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, "UnrestrictedName"), 148, 7);
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
//	import QVTimperativeCSPackage;
//	import Grammar;
//	import GrammarProvider;
