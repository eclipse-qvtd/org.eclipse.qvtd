/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.formatting;

import com.google.inject.Inject;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.ocl.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.AttributeCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.CompoundTargetElementCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.DataTypeCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.EnumerationCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.EnumerationLiteralCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.OperationCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.ParameterCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.ReferenceCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.SimpleTargetElementCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.StructuredClassCSElements;
import org.eclipse.qvtd.xtext.qvtbase.services.QVTbaseGrammarAccess.TargetCSElements;

/**
 * This class contains custom formatting declarations.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class QVTbaseFormatter extends AbstractEssentialOCLFormatter {

	@SuppressWarnings("unused")
	@Inject
	private QVTbaseGrammarAccess grammarAccess;

	protected void configureAttributeCS(FormattingConfig c, AttributeCSElements a) {
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_2());
		c.setNoSpace().around(a.getCommaKeyword_5_1_1());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_1());
		setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_6_0_2());
		//
		c.setNoSpace().before(a.getColonKeyword_6_0_1_1_2());
		c.setSpace(" ").after(a.getColonKeyword_6_0_1_1_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_0_1_1_4());
		c.setIndentation(a.getColonKeyword_6_0_1_1_2(), a.getSemicolonKeyword_6_0_1_1_4());
	}

	protected void configureCompoundTargetElementCS(FormattingConfig c, CompoundTargetElementCSElements a) {
		c.setNoSpace().before(a.getSemicolonKeyword_3());
	}

	protected void configureDataTypeCS(FormattingConfig c, DataTypeCSElements a) {
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_2());
		setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_5_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_1());
	}

	protected void configureEnumerationCS(FormattingConfig c, EnumerationCSElements a) {
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
		//			setBraces(c, a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
		setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
	}

	protected void configureEnumerationLiteralCS(FormattingConfig c, EnumerationLiteralCSElements a) {
		//			c.setNoSpace().around(a.getColonKeyword_1_0());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_2_1());
	}

	protected void configureOperationCS(FormattingConfig c, OperationCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_4());
		c.setNoSpace().before(a.getCommaKeyword_5_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_6());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_9_0(), a.getRightCurlyBracketKeyword_9_2());
		c.setNoSpace().around(a.getCommaKeyword_9_1_1());
		setBraces(c, a.getLeftCurlyBracketKeyword_10_0_0(), a.getRightCurlyBracketKeyword_10_0_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_10_1());
		c.setIndentation(a.getLeftParenthesisKeyword_4(), a.getRightParenthesisKeyword_6());
		//
		c.setNoSpace().before(a.getColonKeyword_10_0_1_2());
		c.setSpace(" ").after(a.getColonKeyword_10_0_1_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_10_0_1_4());
		c.setIndentation(a.getColonKeyword_10_0_1_2(), a.getSemicolonKeyword_10_0_1_4());
	}

	/*	protected void configureDataTypeCS(FormattingConfig c, DataTypeCSElements a) {
		PackageCSElements a = f.getPackageCSAccess();
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
		setBraces(c, a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
	} */

	protected void configureParameterCS(FormattingConfig c, ParameterCSElements a) {
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
		c.setNoSpace().around(a.getCommaKeyword_2_1_1());
		setBraces(c, a.getLeftCurlyBracketKeyword_3_0(), a.getRightCurlyBracketKeyword_3_1());
	}

	protected void configureReferenceCS(FormattingConfig c, ReferenceCSElements a) {
		c.setNoSpace().around(a.getNumberSignKeyword_3_0());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
		c.setNoSpace().around(a.getCommaKeyword_6_1_1());
		setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
		//		c.setNoSpace().before(a.getCommaKeyword_7_0_1_1_2_0());
		//
		//		setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_1_3());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
		//
		//		c.setNoSpace().before(a.getColonKeyword_7_0_1_2_2());
		//		c.setSpace(" ").after(a.getColonKeyword_7_0_1_2_2());
		//		setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_2_4());
		//		c.setIndentation(a.getColonKeyword_7_0_1_2_2(), a.getSemicolonKeyword_7_0_1_2_4());
		//
		//		c.setNoSpace().before(a.getColonKeyword_7_0_1_3_2());
		//		c.setSpace(" ").after(a.getColonKeyword_7_0_1_3_2());
		//		setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_3_4());
		//		c.setIndentation(a.getColonKeyword_7_0_1_3_2(), a.getSemicolonKeyword_7_0_1_3_4());
		//
		//		setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0_1_4_1());
	}

	protected void configureSimpleTargetElementCS(FormattingConfig c, SimpleTargetElementCSElements a) {
		c.setNoSpace().before(a.getCommaKeyword_2_1_1_1_1_0());
		c.setNoSpace().before(a.getSemicolonKeyword_3());
	}

	protected void configureStructuredClassCS(FormattingConfig c, StructuredClassCSElements a) {
		c.setNoSpace().around(a.getCommaKeyword_4_2_0());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
		setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
		setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
	}

	protected void configureTargetCS(FormattingConfig c, TargetCSElements a) {
		setAppendedBraces(c, a.getLeftCurlyBracketKeyword_2(), a.getRightCurlyBracketKeyword_4());
		c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2(), a.getRightCurlyBracketKeyword_4());
		c.setLinewrap(1).between(a.getOwnedTargetElementsAssignment_3(), a.getOwnedTargetElementsAssignment_3());
		//	c.setIndentation(a.getGroup(), a.getGroup());
	}

	/*	protected void configureTemplateBindingCS(FormattingConfig c, TemplateBindingCSElements a) {
		//			c.setNoSpace().around(a.getLeftParenthesisKeyword_0_0());
		c.setNoSpace().before(a.getCommaKeyword_1_0());
		//			c.setNoSpace().before(a.getRightParenthesisKeyword_0_3());
		//		    c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_3());
		//			c.setNoSpace().around(a.getLessThanSignKeyword_1_0());
		//			c.setNoSpace().before(a.getCommaKeyword_1_2_0());
		//			c.setNoSpace().before(a.getGreaterThanSignKeyword_1_3());
		//		    c.setIndentation(a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());
	} */

	/*	protected void configureTemplateSignatureCS(FormattingConfig c, TemplateSignatureCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_0_0());
		c.setNoSpace().before(a.getCommaKeyword_0_2_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_0_3());
		c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_3());
		c.setNoSpace().around(a.getLessThanSignKeyword_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_2_0());
		c.setNoSpace().before(a.getGreaterThanSignKeyword_1_3());
		c.setIndentation(a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());
	} */

	/*	protected void configureTypedTypeRefCS(FormattingConfig c, TypedTypeRefCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0_0());
		//			c.setNoSpace().before(a.getCommaKeyword_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_0_2());
		c.setIndentation(a.getLeftParenthesisKeyword_1_0_0(), a.getRightParenthesisKeyword_1_0_2());
		c.setNoSpace().around(a.getLessThanSignKeyword_1_1_0());
		//			c.setNoSpace().before(a.getCommaKeyword_1_2_0());
		c.setNoSpace().before(a.getGreaterThanSignKeyword_1_1_2());
		c.setIndentation(a.getLessThanSignKeyword_1_1_0(), a.getGreaterThanSignKeyword_1_1_2());
	} */

	@Override
	protected void configureFormatting(FormattingConfig c) {
		// It's usually a good idea to activate the following three statements.
		// They will add and preserve newlines around comments
		//		c.setLinewrap(0, 1, 2).before(grammarAccess.getSL_COMMENTRule());
		//		c.setLinewrap(0, 1, 2).before(grammarAccess.getML_COMMENTRule());
		//		c.setLinewrap(0, 1, 1).after(grammarAccess.getML_COMMENTRule());
	}
}
