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
package org.eclipse.qvtd.xtext.qvtcore.formatting;

import org.eclipse.ocl.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.BottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.DirectionCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.GuardPatternCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.ImportCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.MappingCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.PredicateCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.PredicateOrAssignmentCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.QualifiedPackageCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.QueryCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.ScopeNameCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.TopLevelCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.TransformationCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class QVTcoreFormatter extends AbstractEssentialOCLFormatter
{

	protected void configureBottomPatternCS(FormattingConfig c, BottomPatternCSElements a) {
		c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_0_0());
		c.setLinewrap().after(a.getLeftCurlyBracketKeyword_0_0());
		c.setNoSpace().before(a.getCommaKeyword_0_2_0());
		c.setLinewrap().after(a.getCommaKeyword_0_2_0());
		c.setLinewrap(1).before(a.getVerticalLineKeyword_0_3());
		c.setLinewrap(1).after(a.getVerticalLineKeyword_0_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_0_0(), a.getVerticalLineKeyword_0_3());
		c.setLinewrap().before(a.getRightCurlyBracketKeyword_0_5());
		c.setLinewrap().after(a.getRightCurlyBracketKeyword_0_5());
		c.setIndentation(a.getVerticalLineKeyword_0_3(), a.getRightCurlyBracketKeyword_0_5());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_0_0(), a.getVerticalLineKeyword_0_3());
		c.setNoSpace().between(a.getVerticalLineKeyword_0_3(), a.getRightCurlyBracketKeyword_0_5());
		//
		c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_1_0());
		c.setLinewrap().after(a.getLeftCurlyBracketKeyword_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_2_0());
		c.setLinewrap().after(a.getCommaKeyword_1_2_0());
		c.setLinewrap().before(a.getRightCurlyBracketKeyword_1_3());
		c.setLinewrap().after(a.getRightCurlyBracketKeyword_1_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1_0(), a.getRightCurlyBracketKeyword_1_3());
		//
		c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_2_0());
		c.setLinewrap().after(a.getLeftCurlyBracketKeyword_2_0());
		c.setLinewrap().before(a.getRightCurlyBracketKeyword_2_2());
		c.setLinewrap().after(a.getRightCurlyBracketKeyword_2_2());
		c.setIndentation(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
		//
		c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_3_1());
		c.setLinewrap().after(a.getRightCurlyBracketKeyword_3_2());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_3_1(), a.getRightCurlyBracketKeyword_3_2());
	}

	protected void configureDirectionCS(FormattingConfig c, DirectionCSElements a) {
		c.setNoSpace().before(a.getCommaKeyword_4_0());
		c.setNoSpace().before(a.getCommaKeyword_5_2_0());
	}

	protected void configureGuardPatternCS(FormattingConfig c, GuardPatternCSElements a) {
		c.setNoLinewrap().before(a.getLeftParenthesisKeyword_0_0());
		c.setLinewrap().after(a.getLeftParenthesisKeyword_0_0());
		c.setNoSpace().before(a.getCommaKeyword_0_2_0());
		c.setLinewrap().after(a.getCommaKeyword_0_2_0());
		c.setLinewrap(1).before(a.getVerticalLineKeyword_0_3());
		c.setLinewrap(1).after(a.getVerticalLineKeyword_0_3());
		c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getVerticalLineKeyword_0_3());
		c.setLinewrap().before(a.getRightParenthesisKeyword_0_5());
		c.setLinewrap().after(a.getRightParenthesisKeyword_0_5());
		c.setIndentation(a.getVerticalLineKeyword_0_3(), a.getRightParenthesisKeyword_0_5());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_0_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_0_5());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_0_0(), a.getVerticalLineKeyword_0_3());
		c.setNoSpace().between(a.getVerticalLineKeyword_0_3(), a.getRightParenthesisKeyword_0_5());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_5());
		//
		c.setNoLinewrap().before(a.getLeftParenthesisKeyword_1_0());
		c.setLinewrap().after(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_2_0());
		c.setLinewrap().after(a.getCommaKeyword_1_2_0());
		c.setLinewrap().before(a.getRightParenthesisKeyword_1_3());
		c.setLinewrap().after(a.getRightParenthesisKeyword_1_3());
		c.setIndentation(a.getLeftParenthesisKeyword_1_0(), a.getRightParenthesisKeyword_1_3());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_3());
		//
		c.setNoLinewrap().before(a.getLeftParenthesisKeyword_2_0());
		c.setLinewrap().after(a.getLeftParenthesisKeyword_2_0());
		c.setLinewrap().before(a.getRightParenthesisKeyword_2_2());
		c.setLinewrap().after(a.getRightParenthesisKeyword_2_2());
		c.setIndentation(a.getLeftParenthesisKeyword_2_0(), a.getRightParenthesisKeyword_2_2());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_2_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_2_2());
		//
		c.setNoLinewrap().before(a.getLeftParenthesisKeyword_3_1());
		c.setLinewrap().after(a.getRightParenthesisKeyword_3_2());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_3_1());
		c.setNoSpace().before(a.getRightParenthesisKeyword_3_2());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_3_1(), a.getRightParenthesisKeyword_3_2());
	}

	protected void configureImportCS(FormattingConfig c, ImportCSElements a) {
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	}

	protected void configurePredicateCS(FormattingConfig c, PredicateCSElements a) {
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_1());
	}

	protected void configurePredicateOrAssignmentCS(FormattingConfig c, PredicateOrAssignmentCSElements a) {
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
	}

	protected void configureQualifiedPackageCS(FormattingConfig c, QualifiedPackageCSElements a) {
		c.setLinewrap(2).before(a.getPackageKeyword_0());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
		setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
	}

	protected void configureQueryCS(FormattingConfig c, QueryCSElements a) {
		c.setLinewrap(2).before(a.getIsTransientAssignment_0());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_4());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_4());
		c.setNoSpace().before(a.getCommaKeyword_5_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_6());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_9_0());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_9_1_0(), a.getRightCurlyBracketKeyword_9_1_2());
		setBraces(c, a.getLeftCurlyBracketKeyword_9_1_0(), a.getRightCurlyBracketKeyword_9_1_2());
		c.setIndentation(a.getLeftParenthesisKeyword_4(), a.getRightParenthesisKeyword_6());
	}

	protected void configureScopeNameCS(FormattingConfig c, ScopeNameCSElements a) {
		c.setNoSpace().around(a.getColonColonKeyword_1());
		c.setNoSpace().around(a.getColonColonKeyword_2_1());
	}

	protected void configureTransformationCS(FormattingConfig c, TransformationCSElements a) {
		c.setLinewrap(2).before(a.getTransformationKeyword_0());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
		setBraces(c, a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
	}
	@Override
	protected void configureFormatting(FormattingConfig c) {
		c.setAutoLinewrap(120);

		QVTcoreGrammarAccess f = getGrammarAccess();

		configureCollectionLiteralExpCS(c, f.getCollectionLiteralExpCSAccess());
		configureCollectionTypeCS(c, f.getCollectionTypeCSAccess());
		configureCurlyBracketedClauseCS(c, f.getCurlyBracketedClauseCSAccess());
		configureEssentialOCLNavigationOperatorCS(c, f.getEssentialOCLNavigationOperatorNameAccess());
		configureExpCS(c, f.getExpCSAccess());
		configureIfExpCS(c, f.getIfExpCSAccess());
		configureLetExpCS(c, f.getLetExpCSAccess());
		configureMultiplicityBoundsCS(c, f.getMultiplicityBoundsCSAccess());
		configureMultiplicityCS(c, f.getMultiplicityCSAccess());
		configureMultiplicityStringCS(c, f.getMultiplicityStringCSAccess());
		configureNavigatingCommaArgCS(c, f.getNavigatingCommaArgCSAccess());
		configureNavigatingSemiArgCS(c, f.getNavigatingSemiArgCSAccess());
		configureNestedExpCS(c, f.getNestedExpCSAccess());
		configurePathNameCS(c, f.getPathNameCSAccess());
		configurePrimaryExpCS(c, f.getPrimaryExpCSAccess());
		configureQualifiedPackageCS(c, f.getQualifiedPackageCSAccess());
		configureRoundBracketedClauseCS(c, f.getRoundBracketedClauseCSAccess());
		configureSquareBracketedClauseCS(c, f.getSquareBracketedClauseCSAccess());
		configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
		configureTupleTypeCS(c, f.getTupleTypeCSAccess());
		configureTypedTypeRefCS(c, f.getTypedTypeRefCSAccess());
		configureURIPathNameCS(c, f.getURIPathNameCSAccess());

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

		configureBottomPatternCS(c, f.getBottomPatternCSAccess());
		configureDirectionCS(c, f.getDirectionCSAccess());
		configureGuardPatternCS(c, f.getGuardPatternCSAccess());
		configureImportCS(c, f.getImportCSAccess());
		configurePredicateCS(c, f.getPredicateCSAccess());
		configurePredicateOrAssignmentCS(c, f.getPredicateOrAssignmentCSAccess());
		configureQueryCS(c, f.getQueryCSAccess());
		configureScopeNameCS(c, f.getScopeNameCSAccess());
		configureTransformationCS(c, f.getTransformationCSAccess());
		{
			MappingCSElements a = f.getMappingCSAccess();
			c.setLinewrap(2).before(a.getMapKeyword_2());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6(), a.getRightCurlyBracketKeyword_10());
			setBraces(c, a.getLeftCurlyBracketKeyword_6(), a.getRightCurlyBracketKeyword_10());
			c.setLinewrap(2).between(a.getOwnedDomainsAssignment_7(), a.getOwnedDomainsAssignment_7());
			c.setLinewrap(2).between(a.getOwnedDomainsAssignment_7(), a.getGroup_8());
			c.setLinewrap(1,2,2).before(a.getGroup_8());
			c.setLinewrap(2).between(a.getGroup_8(), a.getOwnedComposedMappingsAssignment_9());
			c.setLinewrap(1,2,2).before(a.getOwnedComposedMappingsAssignment_9());
			c.setLinewrap(2).between(a.getOwnedComposedMappingsAssignment_9(), a.getOwnedComposedMappingsAssignment_9());
		}
		{
			ScopeNameCSElements a = f.getScopeNameCSAccess();
			c.setNoSpace().around(a.getColonColonKeyword_1());
			c.setNoSpace().around(a.getColonColonKeyword_2_1());
		}
		{
			TopLevelCSElements a = f.getTopLevelCSAccess();
			c.setLinewrap(2).before(a.getAlternatives_1());
		}
	}

	@Override
	public QVTcoreGrammarAccess getGrammarAccess() {
		return (QVTcoreGrammarAccess) super.getGrammarAccess();
	}
}
