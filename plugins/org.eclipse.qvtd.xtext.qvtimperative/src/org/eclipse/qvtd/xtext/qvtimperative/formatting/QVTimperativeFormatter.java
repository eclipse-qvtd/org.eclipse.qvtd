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
package org.eclipse.qvtd.xtext.qvtimperative.formatting;

import org.eclipse.qvtd.xtext.qvtbase.formatting.QVTbaseFormatter;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.AddStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.AppendParameterBindingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.AppendParameterCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.BufferStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.CheckStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.DeclareStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.DirectionCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.EntryPointCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.GuardParameterBindingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.GuardParameterCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.ImportCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.LoopParameterBindingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCallCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingLoopCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.NewStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.QualifiedPackageCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.QueryCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.ScopeNameCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SetStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SimpleParameterBindingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SimpleParameterCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SpeculateStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TransformationCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class QVTimperativeFormatter extends QVTbaseFormatter
{
	@Override
	protected void configureFormatting(FormattingConfig c) {
		c.setAutoLinewrap(120);

		QVTimperativeGrammarAccess f = getGrammarAccess();

		configureAttributeCS(c, f.getAttributeCSAccess());
		configureCollectionLiteralExpCS(c, f.getCollectionLiteralExpCSAccess());
		configureCollectionTypeCS(c, f.getCollectionTypeCSAccess());
		configureCurlyBracketedClauseCS(c, f.getCurlyBracketedClauseCSAccess());
		configureDataTypeCS(c, f.getDataTypeCSAccess());
		configureEnumerationCS(c, f.getEnumerationCSAccess());
		configureEnumerationLiteralCS(c, f.getEnumerationLiteralCSAccess());
		configureEssentialOCLNavigationOperatorCS(c, f.getEssentialOCLNavigationOperatorNameAccess());
		configureExpCS(c, f.getExpCSAccess());
		configureIfExpCS(c, f.getIfExpCSAccess());
		configureLetExpCS(c, f.getLetExpCSAccess());
		configureMapLiteralExpCS(c, f.getMapLiteralExpCSAccess());
		configureMapTypeCS(c, f.getMapTypeCSAccess());
		configureMultiplicityBoundsCS(c, f.getMultiplicityBoundsCSAccess());
		configureMultiplicityCS(c, f.getMultiplicityCSAccess());
		configureMultiplicityStringCS(c, f.getMultiplicityStringCSAccess());
		configureNavigatingCommaArgCS(c, f.getNavigatingCommaArgCSAccess());
		configureNavigatingSemiArgCS(c, f.getNavigatingSemiArgCSAccess());
		configureNestedExpCS(c, f.getNestedExpCSAccess());
		configureOperationCS(c, f.getOperationCSAccess());
		configureParameterCS(c, f.getParameterCSAccess());
		configurePathNameCS(c, f.getPathNameCSAccess());
		configurePrimaryExpCS(c, f.getPrimaryExpCSAccess());
		configureReferenceCS(c, f.getReferenceCSAccess());
		configureRoundBracketedClauseCS(c, f.getRoundBracketedClauseCSAccess());
		configureSquareBracketedClauseCS(c, f.getSquareBracketedClauseCSAccess());
		configureStructuredClassCS(c, f.getStructuredClassCSAccess());
		configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
		configureTupleTypeCS(c, f.getTupleTypeCSAccess());
		configureTypedTypeRefCS(c, f.getTypedTypeRefCSAccess());
		configureURIPathNameCS(c, f.getURIPathNameCSAccess());

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

		{
			AddStatementCSElements a = f.getAddStatementCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			c.setLinewrap(1).before(a.getAddKeyword_1());
			c.setNoSpace().before(a.getSemicolonKeyword_5());
		}
		{
			AppendParameterBindingCSElements a = f.getAppendParameterBindingCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
		}
		{
			AppendParameterCSElements a = f.getAppendParameterCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getSemicolonKeyword_4());
		}
		{
			BufferStatementCSElements a = f.getBufferStatementCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().around(a.getColonKeyword_2_0());
			c.setNoSpace().around(a.getFullStopFullStopKeyword_2_2_0());
			c.setNoSpace().before(a.getSemicolonKeyword_6());
		}
		{
			CheckStatementCSElements a = f.getCheckStatementCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getSemicolonKeyword_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
		}
		{
			DeclareStatementCSElements a = f.getDeclareStatementCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			c.setLinewrap(1).before(a.getIsCheckAssignment_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7());
		}
		{
			DirectionCSElements a = f.getDirectionCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getCommaKeyword_2_2_0());
		}
		{
			EntryPointCSElements a = f.getEntryPointCSAccess();
			c.setLinewrap(2).before(a.getGroup());
			c.setNoSpace().around(a.getColonKeyword_3_0());
			c.setNoSpace().before(a.getCommaKeyword_5_2_0());
			c.setNoSpace().before(a.getCommaKeyword_6_2_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_7(), a.getRightCurlyBracketKeyword_12());
			setBraces(c, a.getLeftCurlyBracketKeyword_7(), a.getRightCurlyBracketKeyword_12());
			//			c.setLinewrap(2).between(a.getDomainsAssignment_5(), a.getDomainsAssignment_5());
			//			c.setLinewrap(1).before(a.getOwnedDomainsAssignment_5());
		}
		{
			GuardParameterBindingCSElements a = f.getGuardParameterBindingCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
		}
		{
			GuardParameterCSElements a = f.getGuardParameterCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().around(a.getColonKeyword_1());
			c.setNoSpace().before(a.getSemicolonKeyword_7());
		}
		{
			ImportCSElements a = f.getImportCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
		}
		{
			LoopParameterBindingCSElements a = f.getLoopParameterBindingCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getSemicolonKeyword_4());
		}
		{
			MappingCSElements a = f.getMappingCSAccess();
			c.setLinewrap(2).before(a.getGroup());
			c.setNoSpace().around(a.getColonKeyword_3_0());
			c.setNoSpace().around(a.getFullStopFullStopKeyword_3_2_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5(), a.getRightCurlyBracketKeyword_10());
			setBraces(c, a.getLeftCurlyBracketKeyword_5(), a.getRightCurlyBracketKeyword_10());
			//			c.setLinewrap(2).between(a.getDomainsAssignment_5(), a.getDomainsAssignment_5());
			//			c.setLinewrap(1).before(a.getOwnedDomainsAssignment_5());
		}
		{
			MappingCallCSElements a = f.getMappingCallCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
			//		    c.setIndentation(a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
		}
		{
			MappingLoopCSElements a = f.getMappingLoopCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_5(), a.getRightCurlyBracketKeyword_7());
		}
		{
			NewStatementCSElements a = f.getNewStatementCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			c.setLinewrap(1).before(a.getIsContainedAssignment_1());
			c.setNoSpace().around(a.getColonKeyword_3());
			c.setNoSpace().before(a.getSemicolonKeyword_9());
		}
		{
			QualifiedPackageCSElements a = f.getQualifiedPackageCSAccess();
			c.setLinewrap(2).before(a.getGroup());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
		}
		{
			QueryCSElements a = f.getQueryCSAccess();
			c.setLinewrap(2).before(a.getGroup());
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3());
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3());
			c.setNoSpace().before(a.getCommaKeyword_4_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_5());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_8_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_8_1_0(), a.getRightCurlyBracketKeyword_8_1_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_8_1_0(), a.getRightCurlyBracketKeyword_8_1_2());
			c.setIndentation(a.getLeftParenthesisKeyword_3(), a.getRightParenthesisKeyword_5());
		}
		{
			ScopeNameCSElements a = f.getScopeNameCSAccess();
			c.setNoSpace().around(a.getColonColonKeyword_1());
			c.setNoSpace().around(a.getColonColonKeyword_2_1());
		}
		{
			SetStatementCSElements a = f.getSetStatementCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getCommaKeyword_0_2_0());
			c.setLinewrap(1).before(a.getIsNotifyAssignment_1());
			c.setNoSpace().around(a.getFullStopKeyword_4());
			c.setNoSpace().before(a.getSemicolonKeyword_8());
		}
		{
			SimpleParameterBindingCSElements a = f.getSimpleParameterBindingCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
		}
		{
			SimpleParameterCSElements a = f.getSimpleParameterCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().around(a.getColonKeyword_1());
			c.setNoSpace().before(a.getSemicolonKeyword_6());
		}
		{
			SpeculateStatementCSElements a = f.getSpeculateStatementCSAccess();
			c.setLinewrap(1).before(a.getGroup());
			c.setNoSpace().before(a.getCommaKeyword_2_0());
			c.setNoSpace().before(a.getSemicolonKeyword_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
		}
		//	    {
		//	    	TopLevelCSElements a = f.getTopLevelCSAccess();
		//			c.setLinewrap(2).between(a.getOwnedMappingsMappingCSParserRuleCall_1_1_0(), a.getOwnedMappingsMappingCSParserRuleCall_1_1_0());
		//			c.setLinewrap(2).before(a.getOwnedQueriesAssignment_1_2());
		//			c.setLinewrap(2).before(a.getOwnedTransformationsAssignment_1_0());
		//	    }
		{
			TransformationCSElements a = f.getTransformationCSAccess();
			c.setLinewrap(2).before(a.getGroup());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_7());
			setBraces(c, a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_7());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
		}
	}

	@Override
	public QVTimperativeGrammarAccess getGrammarAccess() {
		return (QVTimperativeGrammarAccess) super.getGrammarAccess();
	}
}
