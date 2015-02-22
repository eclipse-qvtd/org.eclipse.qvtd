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
package org.eclipse.qvtd.xtext.qvtcorebase.formatting;

import org.eclipse.ocl.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.BottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.DirectionCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.GuardPatternCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.ImportCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.PredicateCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.PredicateOrAssignmentCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.QueryCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.ScopeNameCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.TransformationCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class QVTcoreBaseFormatter extends AbstractEssentialOCLFormatter {

	@Override
	protected void configureFormatting(FormattingConfig config) {
		// TODO Auto-generated method stub
		
	}

	protected void configureBottomPatternCS(FormattingConfig c, BottomPatternCSElements a) {
		c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_0_0());	
		c.setLinewrap().after(a.getLeftCurlyBracketKeyword_0_0());	
		c.setNoSpace().before(a.getCommaKeyword_0_2_0());
		c.setLinewrap().after(a.getCommaKeyword_0_2_0());	
		c.setLinewrap(1).before(a.getVerticalLineKeyword_0_3_0());	
		c.setLinewrap(1).after(a.getVerticalLineKeyword_0_3_0());	
		c.setIndentation(a.getLeftCurlyBracketKeyword_0_0(), a.getVerticalLineKeyword_0_3_0());
		c.setLinewrap().before(a.getRightCurlyBracketKeyword_0_4());	
		c.setLinewrap().after(a.getRightCurlyBracketKeyword_0_4());	
		c.setIndentation(a.getVerticalLineKeyword_0_3_0(), a.getRightCurlyBracketKeyword_0_4());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_0_0(), a.getVerticalLineKeyword_0_3_0());
		c.setNoSpace().between(a.getVerticalLineKeyword_0_3_0(), a.getRightCurlyBracketKeyword_0_4());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_0_0(), a.getRightCurlyBracketKeyword_0_4());
		//
		c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_1_1());	
		c.setLinewrap().after(a.getLeftCurlyBracketKeyword_1_1());	
		c.setLinewrap().before(a.getRightCurlyBracketKeyword_1_3());	
		c.setLinewrap().after(a.getRightCurlyBracketKeyword_1_3());	
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_1_1(), a.getRightCurlyBracketKeyword_1_3());
	}

	protected void configureDirectionCS(FormattingConfig c, DirectionCSElements a) {
		c.setNoSpace().before(a.getCommaKeyword_2_2_0());
		c.setNoSpace().before(a.getCommaKeyword_3_2_0());
	}

	protected void configureGuardPatternCS(FormattingConfig c, GuardPatternCSElements a) {
		c.setNoLinewrap().before(a.getLeftParenthesisKeyword_0_1());	
		c.setLinewrap().after(a.getLeftParenthesisKeyword_0_1());	
		c.setNoSpace().before(a.getCommaKeyword_0_2_1_0());
		c.setLinewrap().after(a.getCommaKeyword_0_2_1_0());	
		c.setLinewrap(1).before(a.getVerticalLineKeyword_0_3_0());	
		c.setLinewrap(1).after(a.getVerticalLineKeyword_0_3_0());	
		c.setIndentation(a.getLeftParenthesisKeyword_0_1(), a.getVerticalLineKeyword_0_3_0());
		c.setLinewrap().before(a.getRightParenthesisKeyword_0_4());	
		c.setLinewrap().after(a.getRightParenthesisKeyword_0_4());	
		c.setIndentation(a.getVerticalLineKeyword_0_3_0(), a.getRightParenthesisKeyword_0_4());
		c.setNoSpace().around(a.getLeftParenthesisKeyword_0_1());
		c.setNoSpace().before(a.getRightParenthesisKeyword_0_4());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_0_1(), a.getVerticalLineKeyword_0_3_0());
		c.setNoSpace().between(a.getVerticalLineKeyword_0_3_0(), a.getRightParenthesisKeyword_0_4());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_0_1(), a.getRightParenthesisKeyword_0_4());
		//
		c.setIndentation(a.getLeftParenthesisKeyword_0_1(), a.getRightParenthesisKeyword_0_4());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_0_1(), a.getRightParenthesisKeyword_0_4());
		//
		c.setNoLinewrap().before(a.getLeftParenthesisKeyword_1_1());	
		c.setLinewrap().after(a.getLeftParenthesisKeyword_1_1());	
		c.setNoSpace().before(a.getCommaKeyword_1_2_1_0());
		c.setLinewrap().after(a.getCommaKeyword_1_2_1_0());	
		c.setLinewrap().before(a.getRightParenthesisKeyword_1_3());	
		c.setLinewrap().after(a.getRightParenthesisKeyword_1_3());	
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_1());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_3());
		//
		c.setIndentation(a.getLeftParenthesisKeyword_1_1(), a.getRightParenthesisKeyword_1_3());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_1_1(), a.getRightParenthesisKeyword_1_3());
		//
		c.setNoLinewrap().before(a.getLeftParenthesisKeyword_2_1());	
		c.setLinewrap().after(a.getLeftParenthesisKeyword_2_1());	
		c.setLinewrap().before(a.getRightParenthesisKeyword_2_3());	
		c.setLinewrap().after(a.getRightParenthesisKeyword_2_3());	
		c.setNoSpace().around(a.getLeftParenthesisKeyword_2_1());
		c.setNoSpace().before(a.getRightParenthesisKeyword_2_3());
		//
		c.setIndentation(a.getLeftParenthesisKeyword_2_1(), a.getRightParenthesisKeyword_2_3());
		c.setNoSpace().between(a.getLeftParenthesisKeyword_2_1(), a.getRightParenthesisKeyword_2_3());
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

	protected void configureQueryCS(FormattingConfig c, QueryCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_3());	
		c.setNoSpace().around(a.getLeftParenthesisKeyword_3());	
		c.setNoSpace().before(a.getCommaKeyword_4_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_5());	
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_8_0());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_8_1_0(), a.getRightCurlyBracketKeyword_8_1_2());
		setBraces(c, a.getLeftCurlyBracketKeyword_8_1_0(), a.getRightCurlyBracketKeyword_8_1_2());
		c.setIndentation(a.getLeftParenthesisKeyword_3(), a.getRightParenthesisKeyword_5());
	}

	protected void configureScopeNameCS(FormattingConfig c, ScopeNameCSElements a) {
		c.setNoSpace().around(a.getColonColonKeyword_1());	
		c.setNoSpace().around(a.getColonColonKeyword_2_1());	
	}

	protected void configureTransformationCS(FormattingConfig c, TransformationCSElements a) {
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
		setBraces(c, a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
	}
}
