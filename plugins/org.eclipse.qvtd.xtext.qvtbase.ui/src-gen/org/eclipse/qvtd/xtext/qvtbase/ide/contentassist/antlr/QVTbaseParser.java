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
package org.eclipse.qvtd.xtext.qvtbase.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.qvtd.xtext.qvtbase.ide.contentassist.antlr.internal.InternalQVTbaseParser;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class QVTbaseParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {

		private final Map<AbstractElement, String> mappings;

		@Inject
		public NameMappings(QVTbaseGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}

		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}

		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, QVTbaseGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAttributeCSAccess().getAlternatives_0(), "rule__AttributeCS__Alternatives_0");
			builder.put(grammarAccess.getAttributeCSAccess().getAlternatives_5_1_0(), "rule__AttributeCS__Alternatives_5_1_0");
			builder.put(grammarAccess.getAttributeCSAccess().getAlternatives_6(), "rule__AttributeCS__Alternatives_6");
			builder.put(grammarAccess.getAttributeCSAccess().getAlternatives_6_0_1(), "rule__AttributeCS__Alternatives_6_0_1");
			builder.put(grammarAccess.getClassCSAccess().getAlternatives(), "rule__ClassCS__Alternatives");
			builder.put(grammarAccess.getDataTypeCSAccess().getAlternatives_5_1(), "rule__DataTypeCS__Alternatives_5_1");
			builder.put(grammarAccess.getDataTypeCSAccess().getAlternatives_6(), "rule__DataTypeCS__Alternatives_6");
			builder.put(grammarAccess.getEnumerationCSAccess().getAlternatives_4_1(), "rule__EnumerationCS__Alternatives_4_1");
			builder.put(grammarAccess.getEnumerationCSAccess().getAlternatives_5(), "rule__EnumerationCS__Alternatives_5");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_0(), "rule__EnumerationLiteralCS__Alternatives_0");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_2(), "rule__EnumerationLiteralCS__Alternatives_2");
			builder.put(grammarAccess.getOperationCSAccess().getAlternatives_0(), "rule__OperationCS__Alternatives_0");
			builder.put(grammarAccess.getOperationCSAccess().getAlternatives_9_1_0(), "rule__OperationCS__Alternatives_9_1_0");
			builder.put(grammarAccess.getOperationCSAccess().getAlternatives_10(), "rule__OperationCS__Alternatives_10");
			builder.put(grammarAccess.getParameterCSAccess().getAlternatives_2_1_0(), "rule__ParameterCS__Alternatives_2_1_0");
			builder.put(grammarAccess.getReferenceCSAccess().getAlternatives_0(), "rule__ReferenceCS__Alternatives_0");
			builder.put(grammarAccess.getReferenceCSAccess().getAlternatives_6_1_0(), "rule__ReferenceCS__Alternatives_6_1_0");
			builder.put(grammarAccess.getReferenceCSAccess().getAlternatives_7(), "rule__ReferenceCS__Alternatives_7");
			builder.put(grammarAccess.getReferenceCSAccess().getAlternatives_7_0_1(), "rule__ReferenceCS__Alternatives_7_0_1");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getAlternatives_0(), "rule__SimpleTargetElementCS__Alternatives_0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getAlternatives_2_1(), "rule__SimpleTargetElementCS__Alternatives_2_1");
			builder.put(grammarAccess.getSpecificationCSAccess().getAlternatives(), "rule__SpecificationCS__Alternatives");
			builder.put(grammarAccess.getStructuredClassCSAccess().getAlternatives_7(), "rule__StructuredClassCS__Alternatives_7");
			builder.put(grammarAccess.getStructuredClassCSAccess().getAlternatives_7_0_1(), "rule__StructuredClassCS__Alternatives_7_0_1");
			builder.put(grammarAccess.getTargetCSAccess().getOwnedTargetElementsAlternatives_3_0(), "rule__TargetCS__OwnedTargetElementsAlternatives_3_0");
			builder.put(grammarAccess.getTypedRefCSAccess().getAlternatives(), "rule__TypedRefCS__Alternatives");
			builder.put(grammarAccess.getStructuralFeatureCSAccess().getAlternatives(), "rule__StructuralFeatureCS__Alternatives");
			builder.put(grammarAccess.getQVTbaseUnrestrictedNameAccess().getAlternatives(), "rule__QVTbaseUnrestrictedName__Alternatives");
			builder.put(grammarAccess.getEssentialOCLReservedKeywordAccess().getAlternatives(), "rule__EssentialOCLReservedKeyword__Alternatives");
			builder.put(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getAlternatives(), "rule__EssentialOCLUnaryOperatorName__Alternatives");
			builder.put(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAlternatives(), "rule__EssentialOCLInfixOperatorName__Alternatives");
			builder.put(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getAlternatives(), "rule__EssentialOCLNavigationOperatorName__Alternatives");
			builder.put(grammarAccess.getBinaryOperatorNameAccess().getAlternatives(), "rule__BinaryOperatorName__Alternatives");
			builder.put(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives(), "rule__EssentialOCLUnreservedName__Alternatives");
			builder.put(grammarAccess.getURIFirstPathElementCSAccess().getAlternatives(), "rule__URIFirstPathElementCS__Alternatives");
			builder.put(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives(), "rule__PrimitiveTypeIdentifier__Alternatives");
			builder.put(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives(), "rule__CollectionTypeIdentifier__Alternatives");
			builder.put(grammarAccess.getCollectionLiteralPartCSAccess().getAlternatives(), "rule__CollectionLiteralPartCS__Alternatives");
			builder.put(grammarAccess.getShadowPartCSAccess().getAlternatives(), "rule__ShadowPartCS__Alternatives");
			builder.put(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAlternatives_0_2_0(), "rule__ShadowPartCS__OwnedInitExpressionAlternatives_0_2_0");
			builder.put(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives(), "rule__PrimitiveLiteralExpCS__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives(), "rule__BooleanLiteralExpCS__Alternatives");
			builder.put(grammarAccess.getTypeLiteralCSAccess().getAlternatives(), "rule__TypeLiteralCS__Alternatives");
			builder.put(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getAlternatives(), "rule__TypeExpWithoutMultiplicityCS__Alternatives");
			builder.put(grammarAccess.getExpCSAccess().getAlternatives(), "rule__ExpCS__Alternatives");
			builder.put(grammarAccess.getPrefixedLetExpCSAccess().getAlternatives(), "rule__PrefixedLetExpCS__Alternatives");
			builder.put(grammarAccess.getPrefixedPrimaryExpCSAccess().getAlternatives(), "rule__PrefixedPrimaryExpCS__Alternatives");
			builder.put(grammarAccess.getPrimaryExpCSAccess().getAlternatives(), "rule__PrimaryExpCS__Alternatives");
			builder.put(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAlternatives_2_1_0(), "rule__RoundBracketedClauseCS__OwnedArgumentsAlternatives_2_1_0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getAlternatives(), "rule__NavigatingArgCS__Alternatives");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1(), "rule__NavigatingArgCS__Alternatives_0_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2(), "rule__NavigatingCommaArgCS__Alternatives_2");
			builder.put(grammarAccess.getIfExpCSAccess().getOwnedConditionAlternatives_1_0(), "rule__IfExpCS__OwnedConditionAlternatives_1_0");
			builder.put(grammarAccess.getMultiplicityCSAccess().getAlternatives_1(), "rule__MultiplicityCS__Alternatives_1");
			builder.put(grammarAccess.getMultiplicityCSAccess().getAlternatives_2(), "rule__MultiplicityCS__Alternatives_2");
			builder.put(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0(), "rule__MultiplicityStringCS__StringBoundsAlternatives_0");
			builder.put(grammarAccess.getTypeRefCSAccess().getAlternatives(), "rule__TypeRefCS__Alternatives");
			builder.put(grammarAccess.getIDAccess().getAlternatives(), "rule__ID__Alternatives");
			builder.put(grammarAccess.getUPPERAccess().getAlternatives(), "rule__UPPER__Alternatives");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup(), "rule__AttributeCS__Group__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_0_0(), "rule__AttributeCS__Group_0_0__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_0_1(), "rule__AttributeCS__Group_0_1__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_3(), "rule__AttributeCS__Group_3__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_4(), "rule__AttributeCS__Group_4__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_5(), "rule__AttributeCS__Group_5__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_5_1(), "rule__AttributeCS__Group_5_1__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_6_0(), "rule__AttributeCS__Group_6_0__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_0(), "rule__AttributeCS__Group_6_0_1_0__0");
			builder.put(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_1(), "rule__AttributeCS__Group_6_0_1_1__0");
			builder.put(grammarAccess.getCompoundTargetElementCSAccess().getGroup(), "rule__CompoundTargetElementCS__Group__0");
			builder.put(grammarAccess.getDataTypeCSAccess().getGroup(), "rule__DataTypeCS__Group__0");
			builder.put(grammarAccess.getDataTypeCSAccess().getGroup_4(), "rule__DataTypeCS__Group_4__0");
			builder.put(grammarAccess.getDataTypeCSAccess().getGroup_5(), "rule__DataTypeCS__Group_5__0");
			builder.put(grammarAccess.getDataTypeCSAccess().getGroup_6_0(), "rule__DataTypeCS__Group_6_0__0");
			builder.put(grammarAccess.getEnumerationCSAccess().getGroup(), "rule__EnumerationCS__Group__0");
			builder.put(grammarAccess.getEnumerationCSAccess().getGroup_3(), "rule__EnumerationCS__Group_3__0");
			builder.put(grammarAccess.getEnumerationCSAccess().getGroup_4(), "rule__EnumerationCS__Group_4__0");
			builder.put(grammarAccess.getEnumerationCSAccess().getGroup_5_0(), "rule__EnumerationCS__Group_5_0__0");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getGroup(), "rule__EnumerationLiteralCS__Group__0");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getGroup_0_0(), "rule__EnumerationLiteralCS__Group_0_0__0");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getGroup_1(), "rule__EnumerationLiteralCS__Group_1__0");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getGroup_2_0(), "rule__EnumerationLiteralCS__Group_2_0__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup(), "rule__OperationCS__Group__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_0_0(), "rule__OperationCS__Group_0_0__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_0_1(), "rule__OperationCS__Group_0_1__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_5(), "rule__OperationCS__Group_5__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_5_1(), "rule__OperationCS__Group_5_1__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_7(), "rule__OperationCS__Group_7__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_8(), "rule__OperationCS__Group_8__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_8_2(), "rule__OperationCS__Group_8_2__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_9(), "rule__OperationCS__Group_9__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_9_1(), "rule__OperationCS__Group_9_1__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_10_0(), "rule__OperationCS__Group_10_0__0");
			builder.put(grammarAccess.getOperationCSAccess().getGroup_10_0_1(), "rule__OperationCS__Group_10_0_1__0");
			builder.put(grammarAccess.getParameterCSAccess().getGroup(), "rule__ParameterCS__Group__0");
			builder.put(grammarAccess.getParameterCSAccess().getGroup_1(), "rule__ParameterCS__Group_1__0");
			builder.put(grammarAccess.getParameterCSAccess().getGroup_2(), "rule__ParameterCS__Group_2__0");
			builder.put(grammarAccess.getParameterCSAccess().getGroup_2_1(), "rule__ParameterCS__Group_2_1__0");
			builder.put(grammarAccess.getParameterCSAccess().getGroup_3(), "rule__ParameterCS__Group_3__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup(), "rule__ReferenceCS__Group__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_0_0(), "rule__ReferenceCS__Group_0_0__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_0_1(), "rule__ReferenceCS__Group_0_1__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_3(), "rule__ReferenceCS__Group_3__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_4(), "rule__ReferenceCS__Group_4__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_5(), "rule__ReferenceCS__Group_5__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_6(), "rule__ReferenceCS__Group_6__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_6_1(), "rule__ReferenceCS__Group_6_1__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_7_0(), "rule__ReferenceCS__Group_7_0__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_0(), "rule__ReferenceCS__Group_7_0_1_0__0");
			builder.put(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_1(), "rule__ReferenceCS__Group_7_0_1_1__0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getGroup(), "rule__SimpleTargetElementCS__Group__0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getGroup_2(), "rule__SimpleTargetElementCS__Group_2__0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getGroup_2_1_1(), "rule__SimpleTargetElementCS__Group_2_1_1__0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getGroup_2_1_1_1(), "rule__SimpleTargetElementCS__Group_2_1_1_1__0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getGroup_2_1_1_1_1(), "rule__SimpleTargetElementCS__Group_2_1_1_1_1__0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getGroup(), "rule__StructuredClassCS__Group__0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getGroup_4(), "rule__StructuredClassCS__Group_4__0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getGroup_4_2(), "rule__StructuredClassCS__Group_4_2__0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getGroup_5(), "rule__StructuredClassCS__Group_5__0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getGroup_6(), "rule__StructuredClassCS__Group_6__0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getGroup_7_0(), "rule__StructuredClassCS__Group_7_0__0");
			builder.put(grammarAccess.getTargetCSAccess().getGroup(), "rule__TargetCS__Group__0");
			builder.put(grammarAccess.getTypedMultiplicityRefCSAccess().getGroup(), "rule__TypedMultiplicityRefCS__Group__0");
			builder.put(grammarAccess.getSIGNEDAccess().getGroup(), "rule__SIGNED__Group__0");
			builder.put(grammarAccess.getURIPathNameCSAccess().getGroup(), "rule__URIPathNameCS__Group__0");
			builder.put(grammarAccess.getURIPathNameCSAccess().getGroup_1(), "rule__URIPathNameCS__Group_1__0");
			builder.put(grammarAccess.getURIFirstPathElementCSAccess().getGroup_1(), "rule__URIFirstPathElementCS__Group_1__0");
			builder.put(grammarAccess.getCollectionTypeCSAccess().getGroup(), "rule__CollectionTypeCS__Group__0");
			builder.put(grammarAccess.getCollectionTypeCSAccess().getGroup_1(), "rule__CollectionTypeCS__Group_1__0");
			builder.put(grammarAccess.getMapTypeCSAccess().getGroup(), "rule__MapTypeCS__Group__0");
			builder.put(grammarAccess.getMapTypeCSAccess().getGroup_1(), "rule__MapTypeCS__Group_1__0");
			builder.put(grammarAccess.getTupleTypeCSAccess().getGroup(), "rule__TupleTypeCS__Group__0");
			builder.put(grammarAccess.getTupleTypeCSAccess().getGroup_1(), "rule__TupleTypeCS__Group_1__0");
			builder.put(grammarAccess.getTupleTypeCSAccess().getGroup_1_1(), "rule__TupleTypeCS__Group_1_1__0");
			builder.put(grammarAccess.getTupleTypeCSAccess().getGroup_1_1_1(), "rule__TupleTypeCS__Group_1_1_1__0");
			builder.put(grammarAccess.getTuplePartCSAccess().getGroup(), "rule__TuplePartCS__Group__0");
			builder.put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup(), "rule__CollectionLiteralExpCS__Group__0");
			builder.put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2(), "rule__CollectionLiteralExpCS__Group_2__0");
			builder.put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1(), "rule__CollectionLiteralExpCS__Group_2_1__0");
			builder.put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0(), "rule__CollectionLiteralPartCS__Group_0__0");
			builder.put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0_1(), "rule__CollectionLiteralPartCS__Group_0_1__0");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getGroup(), "rule__CollectionPatternCS__Group__0");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getGroup_2(), "rule__CollectionPatternCS__Group_2__0");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getGroup_2_1(), "rule__CollectionPatternCS__Group_2_1__0");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getGroup_2_2(), "rule__CollectionPatternCS__Group_2_2__0");
			builder.put(grammarAccess.getShadowPartCSAccess().getGroup_0(), "rule__ShadowPartCS__Group_0__0");
			builder.put(grammarAccess.getPatternExpCSAccess().getGroup(), "rule__PatternExpCS__Group__0");
			builder.put(grammarAccess.getLambdaLiteralExpCSAccess().getGroup(), "rule__LambdaLiteralExpCS__Group__0");
			builder.put(grammarAccess.getMapLiteralExpCSAccess().getGroup(), "rule__MapLiteralExpCS__Group__0");
			builder.put(grammarAccess.getMapLiteralExpCSAccess().getGroup_2(), "rule__MapLiteralExpCS__Group_2__0");
			builder.put(grammarAccess.getMapLiteralExpCSAccess().getGroup_2_1(), "rule__MapLiteralExpCS__Group_2_1__0");
			builder.put(grammarAccess.getMapLiteralPartCSAccess().getGroup(), "rule__MapLiteralPartCS__Group__0");
			builder.put(grammarAccess.getTupleLiteralExpCSAccess().getGroup(), "rule__TupleLiteralExpCS__Group__0");
			builder.put(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3(), "rule__TupleLiteralExpCS__Group_3__0");
			builder.put(grammarAccess.getTupleLiteralPartCSAccess().getGroup(), "rule__TupleLiteralPartCS__Group__0");
			builder.put(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1(), "rule__TupleLiteralPartCS__Group_1__0");
			builder.put(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup(), "rule__UnlimitedNaturalLiteralExpCS__Group__0");
			builder.put(grammarAccess.getInvalidLiteralExpCSAccess().getGroup(), "rule__InvalidLiteralExpCS__Group__0");
			builder.put(grammarAccess.getNullLiteralExpCSAccess().getGroup(), "rule__NullLiteralExpCS__Group__0");
			builder.put(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getGroup(), "rule__TypeLiteralWithMultiplicityCS__Group__0");
			builder.put(grammarAccess.getTypeNameExpCSAccess().getGroup(), "rule__TypeNameExpCS__Group__0");
			builder.put(grammarAccess.getTypeNameExpCSAccess().getGroup_1(), "rule__TypeNameExpCS__Group_1__0");
			builder.put(grammarAccess.getTypeNameExpCSAccess().getGroup_1_1(), "rule__TypeNameExpCS__Group_1_1__0");
			builder.put(grammarAccess.getTypeExpCSAccess().getGroup(), "rule__TypeExpCS__Group__0");
			builder.put(grammarAccess.getExpCSAccess().getGroup_0(), "rule__ExpCS__Group_0__0");
			builder.put(grammarAccess.getExpCSAccess().getGroup_0_1(), "rule__ExpCS__Group_0_1__0");
			builder.put(grammarAccess.getPrefixedLetExpCSAccess().getGroup_0(), "rule__PrefixedLetExpCS__Group_0__0");
			builder.put(grammarAccess.getPrefixedPrimaryExpCSAccess().getGroup_0(), "rule__PrefixedPrimaryExpCS__Group_0__0");
			builder.put(grammarAccess.getNameExpCSAccess().getGroup(), "rule__NameExpCS__Group__0");
			builder.put(grammarAccess.getNameExpCSAccess().getGroup_4(), "rule__NameExpCS__Group_4__0");
			builder.put(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup(), "rule__CurlyBracketedClauseCS__Group__0");
			builder.put(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2(), "rule__CurlyBracketedClauseCS__Group_2__0");
			builder.put(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2_1(), "rule__CurlyBracketedClauseCS__Group_2_1__0");
			builder.put(grammarAccess.getRoundBracketedClauseCSAccess().getGroup(), "rule__RoundBracketedClauseCS__Group__0");
			builder.put(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2(), "rule__RoundBracketedClauseCS__Group_2__0");
			builder.put(grammarAccess.getSquareBracketedClauseCSAccess().getGroup(), "rule__SquareBracketedClauseCS__Group__0");
			builder.put(grammarAccess.getSquareBracketedClauseCSAccess().getGroup_2(), "rule__SquareBracketedClauseCS__Group_2__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0(), "rule__NavigatingArgCS__Group_0__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0(), "rule__NavigatingArgCS__Group_0_1_0__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0_2(), "rule__NavigatingArgCS__Group_0_1_0_2__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1(), "rule__NavigatingArgCS__Group_0_1_1__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_2(), "rule__NavigatingArgCS__Group_0_1_1_2__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1_3(), "rule__NavigatingArgCS__Group_0_1_1_3__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2(), "rule__NavigatingArgCS__Group_0_1_2__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_0(), "rule__NavigatingArgCS__Group_0_1_2_0__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_2_1(), "rule__NavigatingArgCS__Group_0_1_2_1__0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getGroup_1(), "rule__NavigatingArgCS__Group_1__0");
			builder.put(grammarAccess.getNavigatingBarArgCSAccess().getGroup(), "rule__NavigatingBarArgCS__Group__0");
			builder.put(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2(), "rule__NavigatingBarArgCS__Group_2__0");
			builder.put(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2_2(), "rule__NavigatingBarArgCS__Group_2_2__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup(), "rule__NavigatingCommaArgCS__Group__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0(), "rule__NavigatingCommaArgCS__Group_2_0__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0_2(), "rule__NavigatingCommaArgCS__Group_2_0_2__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1(), "rule__NavigatingCommaArgCS__Group_2_1__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_2(), "rule__NavigatingCommaArgCS__Group_2_1_2__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1_3(), "rule__NavigatingCommaArgCS__Group_2_1_3__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2(), "rule__NavigatingCommaArgCS__Group_2_2__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_0(), "rule__NavigatingCommaArgCS__Group_2_2_0__0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2_1(), "rule__NavigatingCommaArgCS__Group_2_2_1__0");
			builder.put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup(), "rule__NavigatingSemiArgCS__Group__0");
			builder.put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2(), "rule__NavigatingSemiArgCS__Group_2__0");
			builder.put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2_2(), "rule__NavigatingSemiArgCS__Group_2_2__0");
			builder.put(grammarAccess.getCoIteratorVariableCSAccess().getGroup(), "rule__CoIteratorVariableCS__Group__0");
			builder.put(grammarAccess.getCoIteratorVariableCSAccess().getGroup_1(), "rule__CoIteratorVariableCS__Group_1__0");
			builder.put(grammarAccess.getIfExpCSAccess().getGroup(), "rule__IfExpCS__Group__0");
			builder.put(grammarAccess.getElseIfThenExpCSAccess().getGroup(), "rule__ElseIfThenExpCS__Group__0");
			builder.put(grammarAccess.getLetExpCSAccess().getGroup(), "rule__LetExpCS__Group__0");
			builder.put(grammarAccess.getLetExpCSAccess().getGroup_2(), "rule__LetExpCS__Group_2__0");
			builder.put(grammarAccess.getLetVariableCSAccess().getGroup(), "rule__LetVariableCS__Group__0");
			builder.put(grammarAccess.getLetVariableCSAccess().getGroup_2(), "rule__LetVariableCS__Group_2__0");
			builder.put(grammarAccess.getNestedExpCSAccess().getGroup(), "rule__NestedExpCS__Group__0");
			builder.put(grammarAccess.getSelfExpCSAccess().getGroup(), "rule__SelfExpCS__Group__0");
			builder.put(grammarAccess.getMultiplicityBoundsCSAccess().getGroup(), "rule__MultiplicityBoundsCS__Group__0");
			builder.put(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1(), "rule__MultiplicityBoundsCS__Group_1__0");
			builder.put(grammarAccess.getMultiplicityCSAccess().getGroup(), "rule__MultiplicityCS__Group__0");
			builder.put(grammarAccess.getPathNameCSAccess().getGroup(), "rule__PathNameCS__Group__0");
			builder.put(grammarAccess.getPathNameCSAccess().getGroup_1(), "rule__PathNameCS__Group_1__0");
			builder.put(grammarAccess.getTemplateBindingCSAccess().getGroup(), "rule__TemplateBindingCS__Group__0");
			builder.put(grammarAccess.getTemplateBindingCSAccess().getGroup_1(), "rule__TemplateBindingCS__Group_1__0");
			builder.put(grammarAccess.getTemplateSignatureCSAccess().getGroup(), "rule__TemplateSignatureCS__Group__0");
			builder.put(grammarAccess.getTemplateSignatureCSAccess().getGroup_2(), "rule__TemplateSignatureCS__Group_2__0");
			builder.put(grammarAccess.getTypeParameterCSAccess().getGroup(), "rule__TypeParameterCS__Group__0");
			builder.put(grammarAccess.getTypeParameterCSAccess().getGroup_1(), "rule__TypeParameterCS__Group_1__0");
			builder.put(grammarAccess.getTypeParameterCSAccess().getGroup_1_2(), "rule__TypeParameterCS__Group_1_2__0");
			builder.put(grammarAccess.getTypedTypeRefCSAccess().getGroup(), "rule__TypedTypeRefCS__Group__0");
			builder.put(grammarAccess.getTypedTypeRefCSAccess().getGroup_1(), "rule__TypedTypeRefCS__Group_1__0");
			builder.put(grammarAccess.getWildcardTypeRefCSAccess().getGroup(), "rule__WildcardTypeRefCS__Group__0");
			builder.put(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2(), "rule__WildcardTypeRefCS__Group_2__0");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_0(), "rule__AttributeCS__QualifiersAssignment_0_0_0");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_1(), "rule__AttributeCS__QualifiersAssignment_0_0_1");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_0(), "rule__AttributeCS__QualifiersAssignment_0_1_0");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_1(), "rule__AttributeCS__QualifiersAssignment_0_1_1");
			builder.put(grammarAccess.getAttributeCSAccess().getNameAssignment_2(), "rule__AttributeCS__NameAssignment_2");
			builder.put(grammarAccess.getAttributeCSAccess().getOwnedTypeAssignment_3_1(), "rule__AttributeCS__OwnedTypeAssignment_3_1");
			builder.put(grammarAccess.getAttributeCSAccess().getDefaultAssignment_4_1(), "rule__AttributeCS__DefaultAssignment_4_1");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_0(), "rule__AttributeCS__QualifiersAssignment_5_1_0_0");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_1(), "rule__AttributeCS__QualifiersAssignment_5_1_0_1");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_2(), "rule__AttributeCS__QualifiersAssignment_5_1_0_2");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_3(), "rule__AttributeCS__QualifiersAssignment_5_1_0_3");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_4(), "rule__AttributeCS__QualifiersAssignment_5_1_0_4");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_5(), "rule__AttributeCS__QualifiersAssignment_5_1_0_5");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_6(), "rule__AttributeCS__QualifiersAssignment_5_1_0_6");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_7(), "rule__AttributeCS__QualifiersAssignment_5_1_0_7");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_8(), "rule__AttributeCS__QualifiersAssignment_5_1_0_8");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_9(), "rule__AttributeCS__QualifiersAssignment_5_1_0_9");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_10(), "rule__AttributeCS__QualifiersAssignment_5_1_0_10");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_11(), "rule__AttributeCS__QualifiersAssignment_5_1_0_11");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_12(), "rule__AttributeCS__QualifiersAssignment_5_1_0_12");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_13(), "rule__AttributeCS__QualifiersAssignment_5_1_0_13");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_14(), "rule__AttributeCS__QualifiersAssignment_5_1_0_14");
			builder.put(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_15(), "rule__AttributeCS__QualifiersAssignment_5_1_0_15");
			builder.put(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_0_3(), "rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_0_3");
			builder.put(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_1_3(), "rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_1_3");
			builder.put(grammarAccess.getCompoundTargetElementCSAccess().getOwnedTargetElementsAssignment_1(), "rule__CompoundTargetElementCS__OwnedTargetElementsAssignment_1");
			builder.put(grammarAccess.getDataTypeCSAccess().getIsPrimitiveAssignment_0(), "rule__DataTypeCS__IsPrimitiveAssignment_0");
			builder.put(grammarAccess.getDataTypeCSAccess().getNameAssignment_2(), "rule__DataTypeCS__NameAssignment_2");
			builder.put(grammarAccess.getDataTypeCSAccess().getOwnedSignatureAssignment_3(), "rule__DataTypeCS__OwnedSignatureAssignment_3");
			builder.put(grammarAccess.getDataTypeCSAccess().getInstanceClassNameAssignment_4_1(), "rule__DataTypeCS__InstanceClassNameAssignment_4_1");
			builder.put(grammarAccess.getDataTypeCSAccess().getIsSerializableAssignment_5_1_0(), "rule__DataTypeCS__IsSerializableAssignment_5_1_0");
			builder.put(grammarAccess.getEnumerationCSAccess().getNameAssignment_1(), "rule__EnumerationCS__NameAssignment_1");
			builder.put(grammarAccess.getEnumerationCSAccess().getOwnedSignatureAssignment_2(), "rule__EnumerationCS__OwnedSignatureAssignment_2");
			builder.put(grammarAccess.getEnumerationCSAccess().getInstanceClassNameAssignment_3_1(), "rule__EnumerationCS__InstanceClassNameAssignment_3_1");
			builder.put(grammarAccess.getEnumerationCSAccess().getIsSerializableAssignment_4_1_0(), "rule__EnumerationCS__IsSerializableAssignment_4_1_0");
			builder.put(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsAssignment_5_0_1(), "rule__EnumerationCS__OwnedLiteralsAssignment_5_0_1");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_0_1(), "rule__EnumerationLiteralCS__NameAssignment_0_0_1");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_1(), "rule__EnumerationLiteralCS__NameAssignment_0_1");
			builder.put(grammarAccess.getEnumerationLiteralCSAccess().getValueAssignment_1_1(), "rule__EnumerationLiteralCS__ValueAssignment_1_1");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_0(), "rule__OperationCS__QualifiersAssignment_0_0_0");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_1(), "rule__OperationCS__QualifiersAssignment_0_0_1");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_0(), "rule__OperationCS__QualifiersAssignment_0_1_0");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_1(), "rule__OperationCS__QualifiersAssignment_0_1_1");
			builder.put(grammarAccess.getOperationCSAccess().getOwnedSignatureAssignment_2(), "rule__OperationCS__OwnedSignatureAssignment_2");
			builder.put(grammarAccess.getOperationCSAccess().getNameAssignment_3(), "rule__OperationCS__NameAssignment_3");
			builder.put(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_0(), "rule__OperationCS__OwnedParametersAssignment_5_0");
			builder.put(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_1_1(), "rule__OperationCS__OwnedParametersAssignment_5_1_1");
			builder.put(grammarAccess.getOperationCSAccess().getOwnedTypeAssignment_7_1(), "rule__OperationCS__OwnedTypeAssignment_7_1");
			builder.put(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_1(), "rule__OperationCS__OwnedExceptionsAssignment_8_1");
			builder.put(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_2_1(), "rule__OperationCS__OwnedExceptionsAssignment_8_2_1");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_0(), "rule__OperationCS__QualifiersAssignment_9_1_0_0");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_1(), "rule__OperationCS__QualifiersAssignment_9_1_0_1");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_2(), "rule__OperationCS__QualifiersAssignment_9_1_0_2");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_3(), "rule__OperationCS__QualifiersAssignment_9_1_0_3");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_4(), "rule__OperationCS__QualifiersAssignment_9_1_0_4");
			builder.put(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_5(), "rule__OperationCS__QualifiersAssignment_9_1_0_5");
			builder.put(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsAssignment_10_0_1_3(), "rule__OperationCS__OwnedBodyExpressionsAssignment_10_0_1_3");
			builder.put(grammarAccess.getParameterCSAccess().getNameAssignment_0(), "rule__ParameterCS__NameAssignment_0");
			builder.put(grammarAccess.getParameterCSAccess().getOwnedTypeAssignment_1_1(), "rule__ParameterCS__OwnedTypeAssignment_1_1");
			builder.put(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_0(), "rule__ParameterCS__QualifiersAssignment_2_1_0_0");
			builder.put(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_1(), "rule__ParameterCS__QualifiersAssignment_2_1_0_1");
			builder.put(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_2(), "rule__ParameterCS__QualifiersAssignment_2_1_0_2");
			builder.put(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_3(), "rule__ParameterCS__QualifiersAssignment_2_1_0_3");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_0(), "rule__ReferenceCS__QualifiersAssignment_0_0_0");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_1(), "rule__ReferenceCS__QualifiersAssignment_0_0_1");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_0(), "rule__ReferenceCS__QualifiersAssignment_0_1_0");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_1(), "rule__ReferenceCS__QualifiersAssignment_0_1_1");
			builder.put(grammarAccess.getReferenceCSAccess().getNameAssignment_2(), "rule__ReferenceCS__NameAssignment_2");
			builder.put(grammarAccess.getReferenceCSAccess().getReferredOppositeAssignment_3_1(), "rule__ReferenceCS__ReferredOppositeAssignment_3_1");
			builder.put(grammarAccess.getReferenceCSAccess().getOwnedTypeAssignment_4_1(), "rule__ReferenceCS__OwnedTypeAssignment_4_1");
			builder.put(grammarAccess.getReferenceCSAccess().getDefaultAssignment_5_1(), "rule__ReferenceCS__DefaultAssignment_5_1");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_0(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_0");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_1(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_1");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_2(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_2");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_3(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_3");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_4(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_4");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_5(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_5");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_6(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_6");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_7(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_7");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_8(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_8");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_9(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_9");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_10(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_10");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_11(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_11");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_12(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_12");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_13(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_13");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_14(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_14");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_15(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_15");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_16(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_16");
			builder.put(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_17(), "rule__ReferenceCS__QualifiersAssignment_6_1_0_17");
			builder.put(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_0_3(), "rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_0_3");
			builder.put(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_1_3(), "rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_1_3");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getInputAssignment_0_0(), "rule__SimpleTargetElementCS__InputAssignment_0_0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getOutputAssignment_0_1(), "rule__SimpleTargetElementCS__OutputAssignment_0_1");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getViaAssignment_0_2(), "rule__SimpleTargetElementCS__ViaAssignment_0_2");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getTypedModelAssignment_1(), "rule__SimpleTargetElementCS__TypedModelAssignment_1");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getIteratesAssignment_2_1_0(), "rule__SimpleTargetElementCS__IteratesAssignment_2_1_0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getIteratesAssignment_2_1_1_1_0(), "rule__SimpleTargetElementCS__IteratesAssignment_2_1_1_1_0");
			builder.put(grammarAccess.getSimpleTargetElementCSAccess().getIteratesAssignment_2_1_1_1_1_1(), "rule__SimpleTargetElementCS__IteratesAssignment_2_1_1_1_1_1");
			builder.put(grammarAccess.getSpecificationCSAccess().getOwnedExpressionAssignment_0(), "rule__SpecificationCS__OwnedExpressionAssignment_0");
			builder.put(grammarAccess.getSpecificationCSAccess().getExprStringAssignment_1(), "rule__SpecificationCS__ExprStringAssignment_1");
			builder.put(grammarAccess.getStructuredClassCSAccess().getIsAbstractAssignment_0(), "rule__StructuredClassCS__IsAbstractAssignment_0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getNameAssignment_2(), "rule__StructuredClassCS__NameAssignment_2");
			builder.put(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureAssignment_3(), "rule__StructuredClassCS__OwnedSignatureAssignment_3");
			builder.put(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_1(), "rule__StructuredClassCS__OwnedSuperTypesAssignment_4_1");
			builder.put(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_2_1(), "rule__StructuredClassCS__OwnedSuperTypesAssignment_4_2_1");
			builder.put(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameAssignment_5_1(), "rule__StructuredClassCS__InstanceClassNameAssignment_5_1");
			builder.put(grammarAccess.getStructuredClassCSAccess().getIsInterfaceAssignment_6_1(), "rule__StructuredClassCS__IsInterfaceAssignment_6_1");
			builder.put(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsAssignment_7_0_1_0(), "rule__StructuredClassCS__OwnedOperationsAssignment_7_0_1_0");
			builder.put(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesAssignment_7_0_1_1(), "rule__StructuredClassCS__OwnedPropertiesAssignment_7_0_1_1");
			builder.put(grammarAccess.getTargetCSAccess().getNameAssignment_1(), "rule__TargetCS__NameAssignment_1");
			builder.put(grammarAccess.getTargetCSAccess().getOwnedTargetElementsAssignment_3(), "rule__TargetCS__OwnedTargetElementsAssignment_3");
			builder.put(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityAssignment_1(), "rule__TypedMultiplicityRefCS__OwnedMultiplicityAssignment_1");
			builder.put(grammarAccess.getModelAccess().getOwnedExpressionAssignment(), "rule__Model__OwnedExpressionAssignment");
			builder.put(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_0(), "rule__URIPathNameCS__OwnedPathElementsAssignment_0");
			builder.put(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_1_1(), "rule__URIPathNameCS__OwnedPathElementsAssignment_1_1");
			builder.put(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_0(), "rule__URIFirstPathElementCS__ReferredElementAssignment_0");
			builder.put(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_1_1(), "rule__URIFirstPathElementCS__ReferredElementAssignment_1_1");
			builder.put(grammarAccess.getSimplePathNameCSAccess().getOwnedPathElementsAssignment(), "rule__SimplePathNameCS__OwnedPathElementsAssignment");
			builder.put(grammarAccess.getPrimitiveTypeCSAccess().getNameAssignment(), "rule__PrimitiveTypeCS__NameAssignment");
			builder.put(grammarAccess.getCollectionTypeCSAccess().getNameAssignment_0(), "rule__CollectionTypeCS__NameAssignment_0");
			builder.put(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeAssignment_1_1(), "rule__CollectionTypeCS__OwnedTypeAssignment_1_1");
			builder.put(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityAssignment_1_2(), "rule__CollectionTypeCS__OwnedCollectionMultiplicityAssignment_1_2");
			builder.put(grammarAccess.getMapTypeCSAccess().getNameAssignment_0(), "rule__MapTypeCS__NameAssignment_0");
			builder.put(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeAssignment_1_1(), "rule__MapTypeCS__OwnedKeyTypeAssignment_1_1");
			builder.put(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeAssignment_1_3(), "rule__MapTypeCS__OwnedValueTypeAssignment_1_3");
			builder.put(grammarAccess.getTupleTypeCSAccess().getNameAssignment_0(), "rule__TupleTypeCS__NameAssignment_0");
			builder.put(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_0(), "rule__TupleTypeCS__OwnedPartsAssignment_1_1_0");
			builder.put(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_1_1(), "rule__TupleTypeCS__OwnedPartsAssignment_1_1_1_1");
			builder.put(grammarAccess.getTuplePartCSAccess().getNameAssignment_0(), "rule__TuplePartCS__NameAssignment_0");
			builder.put(grammarAccess.getTuplePartCSAccess().getOwnedTypeAssignment_2(), "rule__TuplePartCS__OwnedTypeAssignment_2");
			builder.put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeAssignment_0(), "rule__CollectionLiteralExpCS__OwnedTypeAssignment_0");
			builder.put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_0(), "rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_0");
			builder.put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_1_1");
			builder.put(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_0_0(), "rule__CollectionLiteralPartCS__OwnedExpressionAssignment_0_0");
			builder.put(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionAssignment_0_1_1(), "rule__CollectionLiteralPartCS__OwnedLastExpressionAssignment_0_1_1");
			builder.put(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_1(), "rule__CollectionLiteralPartCS__OwnedExpressionAssignment_1");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeAssignment_0(), "rule__CollectionPatternCS__OwnedTypeAssignment_0");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_0(), "rule__CollectionPatternCS__OwnedPartsAssignment_2_0");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__CollectionPatternCS__OwnedPartsAssignment_2_1_1");
			builder.put(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameAssignment_2_2_1(), "rule__CollectionPatternCS__RestVariableNameAssignment_2_2_1");
			builder.put(grammarAccess.getShadowPartCSAccess().getReferredPropertyAssignment_0_0(), "rule__ShadowPartCS__ReferredPropertyAssignment_0_0");
			builder.put(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_0_2(), "rule__ShadowPartCS__OwnedInitExpressionAssignment_0_2");
			builder.put(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_1(), "rule__ShadowPartCS__OwnedInitExpressionAssignment_1");
			builder.put(grammarAccess.getPatternExpCSAccess().getPatternVariableNameAssignment_0(), "rule__PatternExpCS__PatternVariableNameAssignment_0");
			builder.put(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeAssignment_2(), "rule__PatternExpCS__OwnedPatternTypeAssignment_2");
			builder.put(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSAssignment_2(), "rule__LambdaLiteralExpCS__OwnedExpressionCSAssignment_2");
			builder.put(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeAssignment_0(), "rule__MapLiteralExpCS__OwnedTypeAssignment_0");
			builder.put(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_0(), "rule__MapLiteralExpCS__OwnedPartsAssignment_2_0");
			builder.put(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__MapLiteralExpCS__OwnedPartsAssignment_2_1_1");
			builder.put(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyAssignment_0(), "rule__MapLiteralPartCS__OwnedKeyAssignment_0");
			builder.put(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueAssignment_2(), "rule__MapLiteralPartCS__OwnedValueAssignment_2");
			builder.put(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_2(), "rule__TupleLiteralExpCS__OwnedPartsAssignment_2");
			builder.put(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_3_1(), "rule__TupleLiteralExpCS__OwnedPartsAssignment_3_1");
			builder.put(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0(), "rule__TupleLiteralPartCS__NameAssignment_0");
			builder.put(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeAssignment_1_1(), "rule__TupleLiteralPartCS__OwnedTypeAssignment_1_1");
			builder.put(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionAssignment_3(), "rule__TupleLiteralPartCS__OwnedInitExpressionAssignment_3");
			builder.put(grammarAccess.getNumberLiteralExpCSAccess().getSymbolAssignment(), "rule__NumberLiteralExpCS__SymbolAssignment");
			builder.put(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment(), "rule__StringLiteralExpCS__SegmentsAssignment");
			builder.put(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_0(), "rule__BooleanLiteralExpCS__SymbolAssignment_0");
			builder.put(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_1(), "rule__BooleanLiteralExpCS__SymbolAssignment_1");
			builder.put(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityAssignment_1(), "rule__TypeLiteralWithMultiplicityCS__OwnedMultiplicityAssignment_1");
			builder.put(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeAssignment(), "rule__TypeLiteralExpCS__OwnedTypeAssignment");
			builder.put(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNameAssignment_0(), "rule__TypeNameExpCS__OwnedPathNameAssignment_0");
			builder.put(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_1_0(), "rule__TypeNameExpCS__OwnedCurlyBracketedClauseAssignment_1_0");
			builder.put(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardAssignment_1_1_1(), "rule__TypeNameExpCS__OwnedPatternGuardAssignment_1_1_1");
			builder.put(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityAssignment_1(), "rule__TypeExpCS__OwnedMultiplicityAssignment_1");
			builder.put(grammarAccess.getExpCSAccess().getNameAssignment_0_1_1(), "rule__ExpCS__NameAssignment_0_1_1");
			builder.put(grammarAccess.getExpCSAccess().getOwnedRightAssignment_0_1_2(), "rule__ExpCS__OwnedRightAssignment_0_1_2");
			builder.put(grammarAccess.getPrefixedLetExpCSAccess().getNameAssignment_0_1(), "rule__PrefixedLetExpCS__NameAssignment_0_1");
			builder.put(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightAssignment_0_2(), "rule__PrefixedLetExpCS__OwnedRightAssignment_0_2");
			builder.put(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameAssignment_0_1(), "rule__PrefixedPrimaryExpCS__NameAssignment_0_1");
			builder.put(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightAssignment_0_2(), "rule__PrefixedPrimaryExpCS__OwnedRightAssignment_0_2");
			builder.put(grammarAccess.getNameExpCSAccess().getOwnedPathNameAssignment_0(), "rule__NameExpCS__OwnedPathNameAssignment_0");
			builder.put(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesAssignment_1(), "rule__NameExpCS__OwnedSquareBracketedClausesAssignment_1");
			builder.put(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseAssignment_2(), "rule__NameExpCS__OwnedRoundBracketedClauseAssignment_2");
			builder.put(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_3(), "rule__NameExpCS__OwnedCurlyBracketedClauseAssignment_3");
			builder.put(grammarAccess.getNameExpCSAccess().getIsPreAssignment_4_0(), "rule__NameExpCS__IsPreAssignment_4_0");
			builder.put(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_0(), "rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_0");
			builder.put(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_1_1");
			builder.put(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_0(), "rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_0");
			builder.put(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_1(), "rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_1");
			builder.put(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_1(), "rule__SquareBracketedClauseCS__OwnedTermsAssignment_1");
			builder.put(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_2_1(), "rule__SquareBracketedClauseCS__OwnedTermsAssignment_2_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionAssignment_0_0(), "rule__NavigatingArgCS__OwnedNameExpressionAssignment_0_0");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_0_1(), "rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_0_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_0_2_1(), "rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_0_2_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_1_1(), "rule__NavigatingArgCS__OwnedTypeAssignment_0_1_1_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_1_2_1(), "rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_1_2_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_1_3_1(), "rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_1_3_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_2_0_1(), "rule__NavigatingArgCS__OwnedTypeAssignment_0_1_2_0_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorAssignment_0_1_2_1_1(), "rule__NavigatingArgCS__OwnedCoIteratorAssignment_0_1_2_1_1");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_2_3(), "rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_2_3");
			builder.put(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_1_1(), "rule__NavigatingArgCS__OwnedTypeAssignment_1_1");
			builder.put(grammarAccess.getNavigatingBarArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingBarArgCS__PrefixAssignment_0");
			builder.put(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionAssignment_1(), "rule__NavigatingBarArgCS__OwnedNameExpressionAssignment_1");
			builder.put(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeAssignment_2_1(), "rule__NavigatingBarArgCS__OwnedTypeAssignment_2_1");
			builder.put(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionAssignment_2_2_1(), "rule__NavigatingBarArgCS__OwnedInitExpressionAssignment_2_2_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingCommaArgCS__PrefixAssignment_0");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionAssignment_1(), "rule__NavigatingCommaArgCS__OwnedNameExpressionAssignment_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_0_1(), "rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_0_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_0_2_1(), "rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_0_2_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_1_1(), "rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_1_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_1_2_1(), "rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_1_2_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_1_3_1(), "rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_1_3_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_2_0_1(), "rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_2_0_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorAssignment_2_2_1_1(), "rule__NavigatingCommaArgCS__OwnedCoIteratorAssignment_2_2_1_1");
			builder.put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_2_3(), "rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_2_3");
			builder.put(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingSemiArgCS__PrefixAssignment_0");
			builder.put(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionAssignment_1(), "rule__NavigatingSemiArgCS__OwnedNameExpressionAssignment_1");
			builder.put(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeAssignment_2_1(), "rule__NavigatingSemiArgCS__OwnedTypeAssignment_2_1");
			builder.put(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionAssignment_2_2_1(), "rule__NavigatingSemiArgCS__OwnedInitExpressionAssignment_2_2_1");
			builder.put(grammarAccess.getCoIteratorVariableCSAccess().getNameAssignment_0(), "rule__CoIteratorVariableCS__NameAssignment_0");
			builder.put(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeAssignment_1_1(), "rule__CoIteratorVariableCS__OwnedTypeAssignment_1_1");
			builder.put(grammarAccess.getIfExpCSAccess().getOwnedConditionAssignment_1(), "rule__IfExpCS__OwnedConditionAssignment_1");
			builder.put(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionAssignment_3(), "rule__IfExpCS__OwnedThenExpressionAssignment_3");
			builder.put(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsAssignment_4(), "rule__IfExpCS__OwnedIfThenExpressionsAssignment_4");
			builder.put(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionAssignment_6(), "rule__IfExpCS__OwnedElseExpressionAssignment_6");
			builder.put(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionAssignment_1(), "rule__ElseIfThenExpCS__OwnedConditionAssignment_1");
			builder.put(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionAssignment_3(), "rule__ElseIfThenExpCS__OwnedThenExpressionAssignment_3");
			builder.put(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_1(), "rule__LetExpCS__OwnedVariablesAssignment_1");
			builder.put(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_2_1(), "rule__LetExpCS__OwnedVariablesAssignment_2_1");
			builder.put(grammarAccess.getLetExpCSAccess().getOwnedInExpressionAssignment_4(), "rule__LetExpCS__OwnedInExpressionAssignment_4");
			builder.put(grammarAccess.getLetVariableCSAccess().getNameAssignment_0(), "rule__LetVariableCS__NameAssignment_0");
			builder.put(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseAssignment_1(), "rule__LetVariableCS__OwnedRoundBracketedClauseAssignment_1");
			builder.put(grammarAccess.getLetVariableCSAccess().getOwnedTypeAssignment_2_1(), "rule__LetVariableCS__OwnedTypeAssignment_2_1");
			builder.put(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionAssignment_4(), "rule__LetVariableCS__OwnedInitExpressionAssignment_4");
			builder.put(grammarAccess.getNestedExpCSAccess().getOwnedExpressionAssignment_1(), "rule__NestedExpCS__OwnedExpressionAssignment_1");
			builder.put(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0(), "rule__MultiplicityBoundsCS__LowerBoundAssignment_0");
			builder.put(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1(), "rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1");
			builder.put(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1(), "rule__MultiplicityCS__IsNullFreeAssignment_2_1");
			builder.put(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment(), "rule__MultiplicityStringCS__StringBoundsAssignment");
			builder.put(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0(), "rule__PathNameCS__OwnedPathElementsAssignment_0");
			builder.put(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1(), "rule__PathNameCS__OwnedPathElementsAssignment_1_1");
			builder.put(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment(), "rule__FirstPathElementCS__ReferredElementAssignment");
			builder.put(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment(), "rule__NextPathElementCS__ReferredElementAssignment");
			builder.put(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0(), "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0");
			builder.put(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1(), "rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1");
			builder.put(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2(), "rule__TemplateBindingCS__OwnedMultiplicityAssignment_2");
			builder.put(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment(), "rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment");
			builder.put(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1(), "rule__TemplateSignatureCS__OwnedParametersAssignment_1");
			builder.put(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_2_1(), "rule__TemplateSignatureCS__OwnedParametersAssignment_2_1");
			builder.put(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0(), "rule__TypeParameterCS__NameAssignment_0");
			builder.put(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1(), "rule__TypeParameterCS__OwnedExtendsAssignment_1_1");
			builder.put(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1(), "rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1");
			builder.put(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0(), "rule__TypedTypeRefCS__OwnedPathNameAssignment_0");
			builder.put(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1(), "rule__TypedTypeRefCS__OwnedBindingAssignment_1_1");
			builder.put(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1(), "rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1");
		}
	}

	@Inject
	private NameMappings nameMappings;

	@Inject
	private QVTbaseGrammarAccess grammarAccess;

	@Override
	protected InternalQVTbaseParser createParser() {
		InternalQVTbaseParser result = new InternalQVTbaseParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public QVTbaseGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(QVTbaseGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	public NameMappings getNameMappings() {
		return nameMappings;
	}

	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
