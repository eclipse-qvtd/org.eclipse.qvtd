/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/*
* generated by Xtext
*/
package org.eclipse.qvtd.xtext.qvtcorebase.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess;

public class QVTcoreBaseParser extends AbstractContentAssistParser {
	
	@Inject
	private QVTcoreBaseGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.qvtd.xtext.qvtcorebase.ui.contentassist.antlr.internal.InternalQVTcoreBaseParser createParser() {
		org.eclipse.qvtd.xtext.qvtcorebase.ui.contentassist.antlr.internal.InternalQVTcoreBaseParser result = new org.eclipse.qvtd.xtext.qvtcorebase.ui.contentassist.antlr.internal.InternalQVTcoreBaseParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getBottomPatternCSAccess().getAlternatives(), "rule__BottomPatternCS__Alternatives");
					put(grammarAccess.getBottomPatternCSAccess().getAlternatives_0_1(), "rule__BottomPatternCS__Alternatives_0_1");
					put(grammarAccess.getBottomPatternCSAccess().getAlternatives_0_2_1(), "rule__BottomPatternCS__Alternatives_0_2_1");
					put(grammarAccess.getQueryCSAccess().getAlternatives_8(), "rule__QueryCS__Alternatives_8");
					put(grammarAccess.getUnrestrictedNameAccess().getAlternatives(), "rule__UnrestrictedName__Alternatives");
					put(grammarAccess.getIDAccess().getAlternatives(), "rule__ID__Alternatives");
					put(grammarAccess.getUPPERAccess().getAlternatives(), "rule__UPPER__Alternatives");
					put(grammarAccess.getEssentialOCLReservedKeywordAccess().getAlternatives(), "rule__EssentialOCLReservedKeyword__Alternatives");
					put(grammarAccess.getEssentialOCLUnaryOperatorCSAccess().getNameAlternatives_0(), "rule__EssentialOCLUnaryOperatorCS__NameAlternatives_0");
					put(grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameAlternatives_0(), "rule__EssentialOCLInfixOperatorCS__NameAlternatives_0");
					put(grammarAccess.getEssentialOCLNavigationOperatorCSAccess().getNameAlternatives_0(), "rule__EssentialOCLNavigationOperatorCS__NameAlternatives_0");
					put(grammarAccess.getBinaryOperatorCSAccess().getAlternatives(), "rule__BinaryOperatorCS__Alternatives");
					put(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives(), "rule__EssentialOCLUnreservedName__Alternatives");
					put(grammarAccess.getURIFirstPathElementCSAccess().getAlternatives(), "rule__URIFirstPathElementCS__Alternatives");
					put(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives(), "rule__PrimitiveTypeIdentifier__Alternatives");
					put(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives(), "rule__CollectionTypeIdentifier__Alternatives");
					put(grammarAccess.getMultiplicityCSAccess().getAlternatives_1(), "rule__MultiplicityCS__Alternatives_1");
					put(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0(), "rule__MultiplicityStringCS__StringBoundsAlternatives_0");
					put(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives(), "rule__PrimitiveLiteralExpCS__Alternatives");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives(), "rule__BooleanLiteralExpCS__Alternatives");
					put(grammarAccess.getTypeLiteralCSAccess().getAlternatives(), "rule__TypeLiteralCS__Alternatives");
					put(grammarAccess.getTypeExpCSAccess().getAlternatives_0(), "rule__TypeExpCS__Alternatives_0");
					put(grammarAccess.getExpCSAccess().getAlternatives(), "rule__ExpCS__Alternatives");
					put(grammarAccess.getExpCSAccess().getAlternatives_0_1_2(), "rule__ExpCS__Alternatives_0_1_2");
					put(grammarAccess.getPrefixedExpCSAccess().getAlternatives(), "rule__PrefixedExpCS__Alternatives");
					put(grammarAccess.getPrimaryExpCSAccess().getAlternatives(), "rule__PrimaryExpCS__Alternatives");
					put(grammarAccess.getPrimaryExpCSAccess().getAlternatives_7_2(), "rule__PrimaryExpCS__Alternatives_7_2");
					put(grammarAccess.getPrimaryExpCSAccess().getAlternatives_7_2_1_2(), "rule__PrimaryExpCS__Alternatives_7_2_1_2");
					put(grammarAccess.getBottomPatternCSAccess().getGroup_0(), "rule__BottomPatternCS__Group_0__0");
					put(grammarAccess.getBottomPatternCSAccess().getGroup_0_2(), "rule__BottomPatternCS__Group_0_2__0");
					put(grammarAccess.getBottomPatternCSAccess().getGroup_1(), "rule__BottomPatternCS__Group_1__0");
					put(grammarAccess.getAssignmentCSAccess().getGroup(), "rule__AssignmentCS__Group__0");
					put(grammarAccess.getAssignmentCSAccess().getGroup_2(), "rule__AssignmentCS__Group_2__0");
					put(grammarAccess.getDirectionCSAccess().getGroup(), "rule__DirectionCS__Group__0");
					put(grammarAccess.getDirectionCSAccess().getGroup_2(), "rule__DirectionCS__Group_2__0");
					put(grammarAccess.getDirectionCSAccess().getGroup_2_2(), "rule__DirectionCS__Group_2_2__0");
					put(grammarAccess.getDirectionCSAccess().getGroup_3(), "rule__DirectionCS__Group_3__0");
					put(grammarAccess.getDirectionCSAccess().getGroup_3_2(), "rule__DirectionCS__Group_3_2__0");
					put(grammarAccess.getGuardPatternCSAccess().getGroup(), "rule__GuardPatternCS__Group__0");
					put(grammarAccess.getGuardPatternCSAccess().getGroup_2(), "rule__GuardPatternCS__Group_2__0");
					put(grammarAccess.getGuardPatternCSAccess().getGroup_2_1(), "rule__GuardPatternCS__Group_2_1__0");
					put(grammarAccess.getImportCSAccess().getGroup(), "rule__ImportCS__Group__0");
					put(grammarAccess.getImportCSAccess().getGroup_1(), "rule__ImportCS__Group_1__0");
					put(grammarAccess.getImportCSAccess().getGroup_3(), "rule__ImportCS__Group_3__0");
					put(grammarAccess.getLibraryCSAccess().getGroup(), "rule__LibraryCS__Group__0");
					put(grammarAccess.getNamedDomainCSAccess().getGroup(), "rule__NamedDomainCS__Group__0");
					put(grammarAccess.getParamDeclarationCSAccess().getGroup(), "rule__ParamDeclarationCS__Group__0");
					put(grammarAccess.getQueryCSAccess().getGroup(), "rule__QueryCS__Group__0");
					put(grammarAccess.getQueryCSAccess().getGroup_4(), "rule__QueryCS__Group_4__0");
					put(grammarAccess.getQueryCSAccess().getGroup_4_1(), "rule__QueryCS__Group_4_1__0");
					put(grammarAccess.getQueryCSAccess().getGroup_8_1(), "rule__QueryCS__Group_8_1__0");
					put(grammarAccess.getScopeNameCSAccess().getGroup(), "rule__ScopeNameCS__Group__0");
					put(grammarAccess.getScopeNameCSAccess().getGroup_2(), "rule__ScopeNameCS__Group_2__0");
					put(grammarAccess.getTransformationCSAccess().getGroup(), "rule__TransformationCS__Group__0");
					put(grammarAccess.getTransformationCSAccess().getGroup_4(), "rule__TransformationCS__Group_4__0");
					put(grammarAccess.getUnrealizedVariableCSAccess().getGroup(), "rule__UnrealizedVariableCS__Group__0");
					put(grammarAccess.getRealizedVariableCSAccess().getGroup(), "rule__RealizedVariableCS__Group__0");
					put(grammarAccess.getUnnamedDomainCSAccess().getGroup(), "rule__UnnamedDomainCS__Group__0");
					put(grammarAccess.getPathNameCSAccess().getGroup(), "rule__PathNameCS__Group__0");
					put(grammarAccess.getPathNameCSAccess().getGroup_1(), "rule__PathNameCS__Group_1__0");
					put(grammarAccess.getURIPathNameCSAccess().getGroup(), "rule__URIPathNameCS__Group__0");
					put(grammarAccess.getURIPathNameCSAccess().getGroup_1(), "rule__URIPathNameCS__Group_1__0");
					put(grammarAccess.getURIFirstPathElementCSAccess().getGroup_1(), "rule__URIFirstPathElementCS__Group_1__0");
					put(grammarAccess.getCollectionTypeCSAccess().getGroup(), "rule__CollectionTypeCS__Group__0");
					put(grammarAccess.getCollectionTypeCSAccess().getGroup_1(), "rule__CollectionTypeCS__Group_1__0");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getGroup(), "rule__MultiplicityBoundsCS__Group__0");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1(), "rule__MultiplicityBoundsCS__Group_1__0");
					put(grammarAccess.getMultiplicityCSAccess().getGroup(), "rule__MultiplicityCS__Group__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup(), "rule__TupleTypeCS__Group__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_1(), "rule__TupleTypeCS__Group_1__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_1_1(), "rule__TupleTypeCS__Group_1_1__0");
					put(grammarAccess.getTupleTypeCSAccess().getGroup_1_1_1(), "rule__TupleTypeCS__Group_1_1_1__0");
					put(grammarAccess.getTuplePartCSAccess().getGroup(), "rule__TuplePartCS__Group__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup(), "rule__CollectionLiteralExpCS__Group__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2(), "rule__CollectionLiteralExpCS__Group_2__0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1(), "rule__CollectionLiteralExpCS__Group_2_1__0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup(), "rule__CollectionLiteralPartCS__Group__0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_1(), "rule__CollectionLiteralPartCS__Group_1__0");
					put(grammarAccess.getConstructorPartCSAccess().getGroup(), "rule__ConstructorPartCS__Group__0");
					put(grammarAccess.getTupleLiteralExpCSAccess().getGroup(), "rule__TupleLiteralExpCS__Group__0");
					put(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3(), "rule__TupleLiteralExpCS__Group_3__0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getGroup(), "rule__TupleLiteralPartCS__Group__0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1(), "rule__TupleLiteralPartCS__Group_1__0");
					put(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup(), "rule__UnlimitedNaturalLiteralExpCS__Group__0");
					put(grammarAccess.getInvalidLiteralExpCSAccess().getGroup(), "rule__InvalidLiteralExpCS__Group__0");
					put(grammarAccess.getNullLiteralExpCSAccess().getGroup(), "rule__NullLiteralExpCS__Group__0");
					put(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getGroup(), "rule__TypeLiteralWithMultiplicityCS__Group__0");
					put(grammarAccess.getTypeExpCSAccess().getGroup(), "rule__TypeExpCS__Group__0");
					put(grammarAccess.getExpCSAccess().getGroup_0(), "rule__ExpCS__Group_0__0");
					put(grammarAccess.getExpCSAccess().getGroup_0_1(), "rule__ExpCS__Group_0_1__0");
					put(grammarAccess.getExpCSAccess().getGroup_0_1_2_0(), "rule__ExpCS__Group_0_1_2_0__0");
					put(grammarAccess.getExpCSAccess().getGroup_0_1_2_0_1(), "rule__ExpCS__Group_0_1_2_0_1__0");
					put(grammarAccess.getExpCSAccess().getGroup_0_1_2_0_2(), "rule__ExpCS__Group_0_1_2_0_2__0");
					put(grammarAccess.getExpCSAccess().getGroup_1(), "rule__ExpCS__Group_1__0");
					put(grammarAccess.getPrefixedExpCSAccess().getGroup_0(), "rule__PrefixedExpCS__Group_0__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7(), "rule__PrimaryExpCS__Group_7__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_0(), "rule__PrimaryExpCS__Group_7_2_0__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_0_3(), "rule__PrimaryExpCS__Group_7_2_0_3__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_0_5(), "rule__PrimaryExpCS__Group_7_2_0_5__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_0_5_2(), "rule__PrimaryExpCS__Group_7_2_0_5_2__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_0_6(), "rule__PrimaryExpCS__Group_7_2_0_6__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_1(), "rule__PrimaryExpCS__Group_7_2_1__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_1_2_0(), "rule__PrimaryExpCS__Group_7_2_1_2_0__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_1_2_0_1(), "rule__PrimaryExpCS__Group_7_2_1_2_0_1__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_2(), "rule__PrimaryExpCS__Group_7_2_2__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_2_0(), "rule__PrimaryExpCS__Group_7_2_2_0__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_2_1(), "rule__PrimaryExpCS__Group_7_2_2_1__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_2_1_2(), "rule__PrimaryExpCS__Group_7_2_2_1_2__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_2_1_2_2(), "rule__PrimaryExpCS__Group_7_2_2_1_2_2__0");
					put(grammarAccess.getPrimaryExpCSAccess().getGroup_7_2_2_1_2_3(), "rule__PrimaryExpCS__Group_7_2_2_1_2_3__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup(), "rule__NavigatingArgCS__Group__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_1(), "rule__NavigatingArgCS__Group_1__0");
					put(grammarAccess.getNavigatingArgCSAccess().getGroup_1_2(), "rule__NavigatingArgCS__Group_1_2__0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getGroup(), "rule__NavigatingBarArgCS__Group__0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2(), "rule__NavigatingBarArgCS__Group_2__0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2_2(), "rule__NavigatingBarArgCS__Group_2_2__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup(), "rule__NavigatingCommaArgCS__Group__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2(), "rule__NavigatingCommaArgCS__Group_2__0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_2(), "rule__NavigatingCommaArgCS__Group_2_2__0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup(), "rule__NavigatingSemiArgCS__Group__0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2(), "rule__NavigatingSemiArgCS__Group_2__0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2_2(), "rule__NavigatingSemiArgCS__Group_2_2__0");
					put(grammarAccess.getIfExpCSAccess().getGroup(), "rule__IfExpCS__Group__0");
					put(grammarAccess.getLetExpCSAccess().getGroup(), "rule__LetExpCS__Group__0");
					put(grammarAccess.getLetExpCSAccess().getGroup_2(), "rule__LetExpCS__Group_2__0");
					put(grammarAccess.getLetVariableCSAccess().getGroup(), "rule__LetVariableCS__Group__0");
					put(grammarAccess.getLetVariableCSAccess().getGroup_1(), "rule__LetVariableCS__Group_1__0");
					put(grammarAccess.getNestedExpCSAccess().getGroup(), "rule__NestedExpCS__Group__0");
					put(grammarAccess.getSelfExpCSAccess().getGroup(), "rule__SelfExpCS__Group__0");
					put(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesAssignment_0_1_0(), "rule__BottomPatternCS__UnrealizedVariablesAssignment_0_1_0");
					put(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesAssignment_0_1_1(), "rule__BottomPatternCS__RealizedVariablesAssignment_0_1_1");
					put(grammarAccess.getBottomPatternCSAccess().getUnrealizedVariablesAssignment_0_2_1_0(), "rule__BottomPatternCS__UnrealizedVariablesAssignment_0_2_1_0");
					put(grammarAccess.getBottomPatternCSAccess().getRealizedVariablesAssignment_0_2_1_1(), "rule__BottomPatternCS__RealizedVariablesAssignment_0_2_1_1");
					put(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignment_0_4(), "rule__BottomPatternCS__ConstraintsAssignment_0_4");
					put(grammarAccess.getBottomPatternCSAccess().getConstraintsAssignment_1_2(), "rule__BottomPatternCS__ConstraintsAssignment_1_2");
					put(grammarAccess.getAssignmentCSAccess().getDefaultAssignment_0(), "rule__AssignmentCS__DefaultAssignment_0");
					put(grammarAccess.getAssignmentCSAccess().getTargetAssignment_1(), "rule__AssignmentCS__TargetAssignment_1");
					put(grammarAccess.getAssignmentCSAccess().getInitialiserAssignment_2_1(), "rule__AssignmentCS__InitialiserAssignment_2_1");
					put(grammarAccess.getDirectionCSAccess().getNameAssignment_1(), "rule__DirectionCS__NameAssignment_1");
					put(grammarAccess.getDirectionCSAccess().getImportsAssignment_2_1(), "rule__DirectionCS__ImportsAssignment_2_1");
					put(grammarAccess.getDirectionCSAccess().getImportsAssignment_2_2_1(), "rule__DirectionCS__ImportsAssignment_2_2_1");
					put(grammarAccess.getDirectionCSAccess().getUsesAssignment_3_1(), "rule__DirectionCS__UsesAssignment_3_1");
					put(grammarAccess.getDirectionCSAccess().getUsesAssignment_3_2_1(), "rule__DirectionCS__UsesAssignment_3_2_1");
					put(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesAssignment_2_0(), "rule__GuardPatternCS__UnrealizedVariablesAssignment_2_0");
					put(grammarAccess.getGuardPatternCSAccess().getUnrealizedVariablesAssignment_2_1_1(), "rule__GuardPatternCS__UnrealizedVariablesAssignment_2_1_1");
					put(grammarAccess.getGuardPatternCSAccess().getConstraintsAssignment_3(), "rule__GuardPatternCS__ConstraintsAssignment_3");
					put(grammarAccess.getImportCSAccess().getNameAssignment_1_0(), "rule__ImportCS__NameAssignment_1_0");
					put(grammarAccess.getImportCSAccess().getPathNameAssignment_2(), "rule__ImportCS__PathNameAssignment_2");
					put(grammarAccess.getImportCSAccess().getAllAssignment_3_0(), "rule__ImportCS__AllAssignment_3_0");
					put(grammarAccess.getLibraryCSAccess().getPackageAssignment_1(), "rule__LibraryCS__PackageAssignment_1");
					put(grammarAccess.getNamedDomainCSAccess().getCheckAssignment_0(), "rule__NamedDomainCS__CheckAssignment_0");
					put(grammarAccess.getNamedDomainCSAccess().getEnforceAssignment_1(), "rule__NamedDomainCS__EnforceAssignment_1");
					put(grammarAccess.getNamedDomainCSAccess().getDirectionAssignment_2(), "rule__NamedDomainCS__DirectionAssignment_2");
					put(grammarAccess.getNamedDomainCSAccess().getGuardPatternAssignment_3(), "rule__NamedDomainCS__GuardPatternAssignment_3");
					put(grammarAccess.getNamedDomainCSAccess().getBottomPatternAssignment_4(), "rule__NamedDomainCS__BottomPatternAssignment_4");
					put(grammarAccess.getParamDeclarationCSAccess().getNameAssignment_0(), "rule__ParamDeclarationCS__NameAssignment_0");
					put(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeAssignment_2(), "rule__ParamDeclarationCS__OwnedTypeAssignment_2");
					put(grammarAccess.getQueryCSAccess().getPathNameAssignment_1(), "rule__QueryCS__PathNameAssignment_1");
					put(grammarAccess.getQueryCSAccess().getNameAssignment_2(), "rule__QueryCS__NameAssignment_2");
					put(grammarAccess.getQueryCSAccess().getInputParamDeclarationAssignment_4_0(), "rule__QueryCS__InputParamDeclarationAssignment_4_0");
					put(grammarAccess.getQueryCSAccess().getInputParamDeclarationAssignment_4_1_1(), "rule__QueryCS__InputParamDeclarationAssignment_4_1_1");
					put(grammarAccess.getQueryCSAccess().getOwnedTypeAssignment_7(), "rule__QueryCS__OwnedTypeAssignment_7");
					put(grammarAccess.getQueryCSAccess().getExpressionAssignment_8_1_1(), "rule__QueryCS__ExpressionAssignment_8_1_1");
					put(grammarAccess.getScopeNameCSAccess().getPathAssignment_0(), "rule__ScopeNameCS__PathAssignment_0");
					put(grammarAccess.getScopeNameCSAccess().getPathAssignment_2_0(), "rule__ScopeNameCS__PathAssignment_2_0");
					put(grammarAccess.getTransformationCSAccess().getPathNameAssignment_1(), "rule__TransformationCS__PathNameAssignment_1");
					put(grammarAccess.getTransformationCSAccess().getNameAssignment_2(), "rule__TransformationCS__NameAssignment_2");
					put(grammarAccess.getTransformationCSAccess().getDirectionsAssignment_4_0(), "rule__TransformationCS__DirectionsAssignment_4_0");
					put(grammarAccess.getUnrealizedVariableCSAccess().getNameAssignment_0(), "rule__UnrealizedVariableCS__NameAssignment_0");
					put(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeAssignment_2(), "rule__UnrealizedVariableCS__OwnedTypeAssignment_2");
					put(grammarAccess.getRealizedVariableCSAccess().getNameAssignment_1(), "rule__RealizedVariableCS__NameAssignment_1");
					put(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeAssignment_3(), "rule__RealizedVariableCS__OwnedTypeAssignment_3");
					put(grammarAccess.getUnnamedDomainCSAccess().getGuardPatternAssignment_1(), "rule__UnnamedDomainCS__GuardPatternAssignment_1");
					put(grammarAccess.getUnnamedDomainCSAccess().getBottomPatternAssignment_2(), "rule__UnnamedDomainCS__BottomPatternAssignment_2");
					put(grammarAccess.getModelAccess().getOwnedExpressionAssignment(), "rule__Model__OwnedExpressionAssignment");
					put(grammarAccess.getEssentialOCLUnaryOperatorCSAccess().getNameAssignment(), "rule__EssentialOCLUnaryOperatorCS__NameAssignment");
					put(grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameAssignment(), "rule__EssentialOCLInfixOperatorCS__NameAssignment");
					put(grammarAccess.getEssentialOCLNavigationOperatorCSAccess().getNameAssignment(), "rule__EssentialOCLNavigationOperatorCS__NameAssignment");
					put(grammarAccess.getPathNameCSAccess().getPathAssignment_0(), "rule__PathNameCS__PathAssignment_0");
					put(grammarAccess.getPathNameCSAccess().getPathAssignment_1_1(), "rule__PathNameCS__PathAssignment_1_1");
					put(grammarAccess.getFirstPathElementCSAccess().getElementAssignment(), "rule__FirstPathElementCS__ElementAssignment");
					put(grammarAccess.getNextPathElementCSAccess().getElementAssignment(), "rule__NextPathElementCS__ElementAssignment");
					put(grammarAccess.getURIPathNameCSAccess().getPathAssignment_0(), "rule__URIPathNameCS__PathAssignment_0");
					put(grammarAccess.getURIPathNameCSAccess().getPathAssignment_1_1(), "rule__URIPathNameCS__PathAssignment_1_1");
					put(grammarAccess.getURIFirstPathElementCSAccess().getElementAssignment_0(), "rule__URIFirstPathElementCS__ElementAssignment_0");
					put(grammarAccess.getURIFirstPathElementCSAccess().getElementAssignment_1_1(), "rule__URIFirstPathElementCS__ElementAssignment_1_1");
					put(grammarAccess.getPrimitiveTypeCSAccess().getNameAssignment(), "rule__PrimitiveTypeCS__NameAssignment");
					put(grammarAccess.getCollectionTypeCSAccess().getNameAssignment_0(), "rule__CollectionTypeCS__NameAssignment_0");
					put(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeAssignment_1_1(), "rule__CollectionTypeCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0(), "rule__MultiplicityBoundsCS__LowerBoundAssignment_0");
					put(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1(), "rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1");
					put(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment(), "rule__MultiplicityStringCS__StringBoundsAssignment");
					put(grammarAccess.getTupleTypeCSAccess().getNameAssignment_0(), "rule__TupleTypeCS__NameAssignment_0");
					put(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_0(), "rule__TupleTypeCS__OwnedPartsAssignment_1_1_0");
					put(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_1_1(), "rule__TupleTypeCS__OwnedPartsAssignment_1_1_1_1");
					put(grammarAccess.getTuplePartCSAccess().getNameAssignment_0(), "rule__TuplePartCS__NameAssignment_0");
					put(grammarAccess.getTuplePartCSAccess().getOwnedTypeAssignment_2(), "rule__TuplePartCS__OwnedTypeAssignment_2");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeAssignment_0(), "rule__CollectionLiteralExpCS__OwnedTypeAssignment_0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_0(), "rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_0");
					put(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1(), "rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_1_1");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSAssignment_0(), "rule__CollectionLiteralPartCS__ExpressionCSAssignment_0");
					put(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSAssignment_1_1(), "rule__CollectionLiteralPartCS__LastExpressionCSAssignment_1_1");
					put(grammarAccess.getConstructorPartCSAccess().getPropertyAssignment_0(), "rule__ConstructorPartCS__PropertyAssignment_0");
					put(grammarAccess.getConstructorPartCSAccess().getInitExpressionAssignment_2(), "rule__ConstructorPartCS__InitExpressionAssignment_2");
					put(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_2(), "rule__TupleLiteralExpCS__OwnedPartsAssignment_2");
					put(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_3_1(), "rule__TupleLiteralExpCS__OwnedPartsAssignment_3_1");
					put(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0(), "rule__TupleLiteralPartCS__NameAssignment_0");
					put(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeAssignment_1_1(), "rule__TupleLiteralPartCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionAssignment_3(), "rule__TupleLiteralPartCS__InitExpressionAssignment_3");
					put(grammarAccess.getNumberLiteralExpCSAccess().getNameAssignment(), "rule__NumberLiteralExpCS__NameAssignment");
					put(grammarAccess.getStringLiteralExpCSAccess().getNameAssignment(), "rule__StringLiteralExpCS__NameAssignment");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getNameAssignment_0(), "rule__BooleanLiteralExpCS__NameAssignment_0");
					put(grammarAccess.getBooleanLiteralExpCSAccess().getNameAssignment_1(), "rule__BooleanLiteralExpCS__NameAssignment_1");
					put(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityAssignment_1(), "rule__TypeLiteralWithMultiplicityCS__MultiplicityAssignment_1");
					put(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeAssignment(), "rule__TypeLiteralExpCS__OwnedTypeAssignment");
					put(grammarAccess.getTypeNameExpCSAccess().getPathNameAssignment(), "rule__TypeNameExpCS__PathNameAssignment");
					put(grammarAccess.getTypeExpCSAccess().getMultiplicityAssignment_1(), "rule__TypeExpCS__MultiplicityAssignment_1");
					put(grammarAccess.getExpCSAccess().getOwnedOperatorAssignment_0_1_1(), "rule__ExpCS__OwnedOperatorAssignment_0_1_1");
					put(grammarAccess.getExpCSAccess().getOwnedExpressionAssignment_0_1_2_0_0(), "rule__ExpCS__OwnedExpressionAssignment_0_1_2_0_0");
					put(grammarAccess.getExpCSAccess().getOwnedOperatorAssignment_0_1_2_0_1_0(), "rule__ExpCS__OwnedOperatorAssignment_0_1_2_0_1_0");
					put(grammarAccess.getExpCSAccess().getOwnedExpressionAssignment_0_1_2_0_1_1(), "rule__ExpCS__OwnedExpressionAssignment_0_1_2_0_1_1");
					put(grammarAccess.getExpCSAccess().getOwnedOperatorAssignment_0_1_2_0_2_0(), "rule__ExpCS__OwnedOperatorAssignment_0_1_2_0_2_0");
					put(grammarAccess.getExpCSAccess().getOwnedExpressionAssignment_0_1_2_0_2_1(), "rule__ExpCS__OwnedExpressionAssignment_0_1_2_0_2_1");
					put(grammarAccess.getExpCSAccess().getOwnedExpressionAssignment_0_1_2_1(), "rule__ExpCS__OwnedExpressionAssignment_0_1_2_1");
					put(grammarAccess.getExpCSAccess().getOwnedOperatorAssignment_1_1(), "rule__ExpCS__OwnedOperatorAssignment_1_1");
					put(grammarAccess.getExpCSAccess().getOwnedExpressionAssignment_1_2(), "rule__ExpCS__OwnedExpressionAssignment_1_2");
					put(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorAssignment_0_1(), "rule__PrefixedExpCS__OwnedOperatorAssignment_0_1");
					put(grammarAccess.getPrefixedExpCSAccess().getOwnedExpressionAssignment_0_2(), "rule__PrefixedExpCS__OwnedExpressionAssignment_0_2");
					put(grammarAccess.getPrimaryExpCSAccess().getPathNameAssignment_7_1(), "rule__PrimaryExpCS__PathNameAssignment_7_1");
					put(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesAssignment_7_2_0_2(), "rule__PrimaryExpCS__FirstIndexesAssignment_7_2_0_2");
					put(grammarAccess.getPrimaryExpCSAccess().getFirstIndexesAssignment_7_2_0_3_1(), "rule__PrimaryExpCS__FirstIndexesAssignment_7_2_0_3_1");
					put(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesAssignment_7_2_0_5_1(), "rule__PrimaryExpCS__SecondIndexesAssignment_7_2_0_5_1");
					put(grammarAccess.getPrimaryExpCSAccess().getSecondIndexesAssignment_7_2_0_5_2_1(), "rule__PrimaryExpCS__SecondIndexesAssignment_7_2_0_5_2_1");
					put(grammarAccess.getPrimaryExpCSAccess().getAtPreAssignment_7_2_0_6_0(), "rule__PrimaryExpCS__AtPreAssignment_7_2_0_6_0");
					put(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsAssignment_7_2_1_2_0_0(), "rule__PrimaryExpCS__OwnedPartsAssignment_7_2_1_2_0_0");
					put(grammarAccess.getPrimaryExpCSAccess().getOwnedPartsAssignment_7_2_1_2_0_1_1(), "rule__PrimaryExpCS__OwnedPartsAssignment_7_2_1_2_0_1_1");
					put(grammarAccess.getPrimaryExpCSAccess().getValueAssignment_7_2_1_2_1(), "rule__PrimaryExpCS__ValueAssignment_7_2_1_2_1");
					put(grammarAccess.getPrimaryExpCSAccess().getAtPreAssignment_7_2_2_0_0(), "rule__PrimaryExpCS__AtPreAssignment_7_2_2_0_0");
					put(grammarAccess.getPrimaryExpCSAccess().getArgumentAssignment_7_2_2_1_2_0(), "rule__PrimaryExpCS__ArgumentAssignment_7_2_2_1_2_0");
					put(grammarAccess.getPrimaryExpCSAccess().getArgumentAssignment_7_2_2_1_2_1(), "rule__PrimaryExpCS__ArgumentAssignment_7_2_2_1_2_1");
					put(grammarAccess.getPrimaryExpCSAccess().getArgumentAssignment_7_2_2_1_2_2_0(), "rule__PrimaryExpCS__ArgumentAssignment_7_2_2_1_2_2_0");
					put(grammarAccess.getPrimaryExpCSAccess().getArgumentAssignment_7_2_2_1_2_2_1(), "rule__PrimaryExpCS__ArgumentAssignment_7_2_2_1_2_2_1");
					put(grammarAccess.getPrimaryExpCSAccess().getArgumentAssignment_7_2_2_1_2_3_0(), "rule__PrimaryExpCS__ArgumentAssignment_7_2_2_1_2_3_0");
					put(grammarAccess.getPrimaryExpCSAccess().getArgumentAssignment_7_2_2_1_2_3_1(), "rule__PrimaryExpCS__ArgumentAssignment_7_2_2_1_2_3_1");
					put(grammarAccess.getNavigatingArgCSAccess().getNameAssignment_0(), "rule__NavigatingArgCS__NameAssignment_0");
					put(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_1_1(), "rule__NavigatingArgCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getNavigatingArgCSAccess().getInitAssignment_1_2_1(), "rule__NavigatingArgCS__InitAssignment_1_2_1");
					put(grammarAccess.getNavigatingBarArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingBarArgCS__PrefixAssignment_0");
					put(grammarAccess.getNavigatingBarArgCSAccess().getNameAssignment_1(), "rule__NavigatingBarArgCS__NameAssignment_1");
					put(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeAssignment_2_1(), "rule__NavigatingBarArgCS__OwnedTypeAssignment_2_1");
					put(grammarAccess.getNavigatingBarArgCSAccess().getInitAssignment_2_2_1(), "rule__NavigatingBarArgCS__InitAssignment_2_2_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingCommaArgCS__PrefixAssignment_0");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getNameAssignment_1(), "rule__NavigatingCommaArgCS__NameAssignment_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_1(), "rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_1");
					put(grammarAccess.getNavigatingCommaArgCSAccess().getInitAssignment_2_2_1(), "rule__NavigatingCommaArgCS__InitAssignment_2_2_1");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixAssignment_0(), "rule__NavigatingSemiArgCS__PrefixAssignment_0");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getNameAssignment_1(), "rule__NavigatingSemiArgCS__NameAssignment_1");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeAssignment_2_1(), "rule__NavigatingSemiArgCS__OwnedTypeAssignment_2_1");
					put(grammarAccess.getNavigatingSemiArgCSAccess().getInitAssignment_2_2_1(), "rule__NavigatingSemiArgCS__InitAssignment_2_2_1");
					put(grammarAccess.getIfExpCSAccess().getConditionAssignment_1(), "rule__IfExpCS__ConditionAssignment_1");
					put(grammarAccess.getIfExpCSAccess().getThenExpressionAssignment_3(), "rule__IfExpCS__ThenExpressionAssignment_3");
					put(grammarAccess.getIfExpCSAccess().getElseExpressionAssignment_5(), "rule__IfExpCS__ElseExpressionAssignment_5");
					put(grammarAccess.getLetExpCSAccess().getVariableAssignment_1(), "rule__LetExpCS__VariableAssignment_1");
					put(grammarAccess.getLetExpCSAccess().getVariableAssignment_2_1(), "rule__LetExpCS__VariableAssignment_2_1");
					put(grammarAccess.getLetExpCSAccess().getInAssignment_4(), "rule__LetExpCS__InAssignment_4");
					put(grammarAccess.getLetVariableCSAccess().getNameAssignment_0(), "rule__LetVariableCS__NameAssignment_0");
					put(grammarAccess.getLetVariableCSAccess().getOwnedTypeAssignment_1_1(), "rule__LetVariableCS__OwnedTypeAssignment_1_1");
					put(grammarAccess.getLetVariableCSAccess().getInitExpressionAssignment_3(), "rule__LetVariableCS__InitExpressionAssignment_3");
					put(grammarAccess.getNestedExpCSAccess().getSourceAssignment_1(), "rule__NestedExpCS__SourceAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.qvtd.xtext.qvtcorebase.ui.contentassist.antlr.internal.InternalQVTcoreBaseParser typedParser = (org.eclipse.qvtd.xtext.qvtcorebase.ui.contentassist.antlr.internal.InternalQVTcoreBaseParser) parser;
			typedParser.entryRuleBottomPatternCS();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public QVTcoreBaseGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(QVTcoreBaseGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
