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
package org.eclipse.qvtd.xtext.qvtimperative.formatting;

import org.eclipse.ocl.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.AddStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.CheckStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.DirectionCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.GuardVariableCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.ImportCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.InoutVariableCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCallBindingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCallCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingLoopCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.NewStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.OutVariableCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.PredicateVariableCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.QualifiedPackageCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.QueryCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.ScopeNameCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SetStatementCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SourceDomainCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TargetDomainCSElements;
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
public class QVTimperativeFormatter extends AbstractEssentialOCLFormatter
{
	@Override
	protected void configureFormatting(FormattingConfig c) {
		c.setAutoLinewrap(120);

		QVTimperativeGrammarAccess f = getGrammarAccess();

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

		{
			AddStatementCSElements a = f.getAddStatementCSAccess();
			c.setLinewrap(1).before(a.getAddKeyword_0());
			c.setNoSpace().before(a.getSemicolonKeyword_4());
		}
		{
			CheckStatementCSElements a = f.getCheckStatementCSAccess();
			c.setLinewrap(1).before(a.getCheckKeyword_0());
			c.setNoSpace().before(a.getSemicolonKeyword_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2());
		}
		{
			DirectionCSElements a = f.getDirectionCSAccess();
			c.setNoSpace().before(a.getCommaKeyword_4_0());
			c.setNoSpace().before(a.getCommaKeyword_5_2_0());
		}
		{
			GuardVariableCSElements a = f.getGuardVariableCSAccess();
			c.setLinewrap(1).before(a.getInKeyword_0());
			c.setNoSpace().before(a.getSemicolonKeyword_6());
		}
		{
			ImportCSElements a = f.getImportCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
		}
		{
			InoutVariableCSElements a = f.getInoutVariableCSAccess();
			c.setLinewrap(1).before(a.getInoutKeyword_0());
			c.setNoSpace().before(a.getSemicolonKeyword_4());
		}
		{
			MappingCSElements a = f.getMappingCSAccess();
			c.setLinewrap(2).before(a.getMapKeyword_1());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_10());
			setBraces(c, a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_10());
			//			c.setLinewrap(2).between(a.getDomainsAssignment_5(), a.getDomainsAssignment_5());
			c.setLinewrap(1).before(a.getOwnedDomainsAssignment_6());
		}
		{
			MappingCallCSElements a = f.getMappingCallCSAccess();
			c.setLinewrap(1).before(a.getIsInfiniteInfiniteKeyword_1_0());
			c.setLinewrap(1).before(a.getCallKeyword_2());
			c.setNoLinewrap().after(a.getIsInfiniteInfiniteKeyword_1_0());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_6());
			//		    c.setIndentation(a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
		}
		{
			MappingCallBindingCSElements a = f.getMappingCallBindingCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
		}
		{
			MappingLoopCSElements a = f.getMappingLoopCSAccess();
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_6());
		}
		{
			NewStatementCSElements a = f.getNewStatementCSAccess();
			c.setLinewrap(1).before(a.getNewKeyword_0());
			c.setNoSpace().around(a.getColonKeyword_1());
			c.setNoSpace().before(a.getSemicolonKeyword_7());
		}
		{
			OutVariableCSElements a = f.getOutVariableCSAccess();
			c.setLinewrap(1).before(a.getOutKeyword_0());
			c.setNoSpace().before(a.getSemicolonKeyword_4());
		}
		{
			PredicateVariableCSElements a = f.getPredicateVariableCSAccess();
			c.setLinewrap(1).before(a.getAlternatives_0());
			c.setNoSpace().around(a.getColonKeyword_2_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5());
		}
		{
			QualifiedPackageCSElements a = f.getQualifiedPackageCSAccess();
			c.setLinewrap(2).before(a.getPackageKeyword_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
		}
		{
			QueryCSElements a = f.getQueryCSAccess();
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
		{
			ScopeNameCSElements a = f.getScopeNameCSAccess();
			c.setNoSpace().around(a.getColonColonKeyword_1());
			c.setNoSpace().around(a.getColonColonKeyword_2_1());
		}
		{
			SetStatementCSElements a = f.getSetStatementCSAccess();
			c.setLinewrap(1).before(a.getAlternatives_0());
			c.setNoSpace().around(a.getFullStopKeyword_2());
			c.setNoSpace().before(a.getSemicolonKeyword_6());
		}
		{
			SourceDomainCSElements a = f.getSourceDomainCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_2_0());
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_2_0());
			c.setNoSpace().before(a.getCommaKeyword_2_1_2_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_2_0());
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_2_2());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
			c.setIndentation(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
		}
		{
			TargetDomainCSElements a = f.getTargetDomainCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_2_0());
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_2_0());
			c.setNoSpace().before(a.getCommaKeyword_2_1_2_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_2_0());
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_2_2());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
			c.setIndentation(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
		}
		//	    {
		//	    	TopLevelCSElements a = f.getTopLevelCSAccess();
		//			c.setLinewrap(2).between(a.getOwnedMappingsMappingCSParserRuleCall_1_1_0(), a.getOwnedMappingsMappingCSParserRuleCall_1_1_0());
		//			c.setLinewrap(2).before(a.getOwnedQueriesAssignment_1_2());
		//			c.setLinewrap(2).before(a.getOwnedTransformationsAssignment_1_0());
		//	    }
		{
			TransformationCSElements a = f.getTransformationCSAccess();
			c.setLinewrap(2).before(a.getTransformationKeyword_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
			setBraces(c, a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
		}
	}

	@Override
	public QVTimperativeGrammarAccess getGrammarAccess() {
		return (QVTimperativeGrammarAccess) super.getGrammarAccess();
	}
}
