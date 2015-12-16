/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.formatting;

import org.eclipse.qvtd.xtext.qvtcorebase.formatting.QVTcoreBaseFormatter;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.GuardPatternCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.RealizedVariableCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.ScopeNameCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.DirectionCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.ImperativePredicateOrAssignmentCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCallBindingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCallCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingLoopCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MiddleBottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MiddleDomainCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SourceBottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SourceDomainCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SourceGuardPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TargetBottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TargetDomainCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TargetGuardPatternCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class QVTimperativeFormatter extends QVTcoreBaseFormatter
{
	protected void configureDirectionCS(FormattingConfig c, DirectionCSElements a) {
		c.setNoSpace().before(a.getCommaKeyword_2_2_0());
		c.setNoSpace().before(a.getCommaKeyword_3_2_0());
	}

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

	    configureDirectionCS(c, f.getDirectionCSAccess());
	    configureImportCS(c, f.getImportCSAccess());
	    configurePredicateCS(c, f.getPredicateCSAccess());
	    configureQueryCS(c, f.getQueryCSAccess());
	    configureScopeNameCS(c, f.getScopeNameCSAccess());
	    configureTransformationCS(c, f.getTransformationCSAccess());


		{
			ImperativePredicateOrAssignmentCSElements a = f.getImperativePredicateOrAssignmentCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
		}
	    {
	    	MappingCSElements a = f.getMappingCSAccess();
			c.setLinewrap(2).before(a.getMapKeyword_2());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6(), a.getRightCurlyBracketKeyword_10());
			setBraces(c, a.getLeftCurlyBracketKeyword_6(), a.getRightCurlyBracketKeyword_10());
//			c.setLinewrap(2).between(a.getDomainsAssignment_5(), a.getDomainsAssignment_5());
			c.setLinewrap(1).before(a.getOwnedDomainsAssignment_7());
			c.setLinewrap(1).before(a.getWhereKeyword_8_0());
	    }
	    {
	    	MappingCallCSElements a = f.getMappingCallCSAccess();
			c.setLinewrap(1).before(a.getCallKeyword_2());
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
	    	MiddleBottomPatternCSElements a = f.getMiddleBottomPatternCSAccess();
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
	    {
	    	MiddleDomainCSElements a = f.getMiddleDomainCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_0_0());	
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_0_0());	
			c.setNoSpace().before(a.getCommaKeyword_0_1_2_0());
			c.setLinewrap().after(a.getCommaKeyword_0_1_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_0_2_2_0());
			c.setLinewrap().after(a.getCommaKeyword_0_2_2_0());	
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_0_3());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_0_0(), a.getRightCurlyBracketKeyword_0_3());
			c.setIndentation(a.getLeftCurlyBracketKeyword_0_0(), a.getRightCurlyBracketKeyword_0_3());
		}
	    {
	    	GuardPatternCSElements a = f.getGuardPatternCSAccess();
			c.setNoLinewrap().before(a.getLeftParenthesisKeyword_0_0());	
			c.setLinewrap().after(a.getLeftParenthesisKeyword_0_0());	
			c.setLinewrap().before(a.getRightParenthesisKeyword_0_5());	
			c.setLinewrap().after(a.getRightParenthesisKeyword_0_5());	
			c.setNoSpace().after(a.getLeftParenthesisKeyword_0_0());
			c.setNoSpace().after(a.getCommaKeyword_0_2_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_0_5());
			//
			c.setNoLinewrap().before(a.getLeftParenthesisKeyword_1_0());	
			c.setLinewrap().after(a.getLeftParenthesisKeyword_1_0());	
			c.setLinewrap().before(a.getRightParenthesisKeyword_1_3());	
			c.setLinewrap().after(a.getRightParenthesisKeyword_1_3());	
			c.setNoSpace().after(a.getLeftParenthesisKeyword_1_0());
			c.setNoSpace().after(a.getCommaKeyword_1_2_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_1_3());
			//
			c.setNoLinewrap().before(a.getLeftParenthesisKeyword_2_0());	
			c.setLinewrap().after(a.getLeftParenthesisKeyword_2_0());	
			c.setLinewrap().before(a.getRightParenthesisKeyword_2_2());	
			c.setLinewrap().after(a.getRightParenthesisKeyword_2_2());	
			c.setNoSpace().after(a.getLeftParenthesisKeyword_2_0());
			//
			c.setNoLinewrap().before(a.getLeftParenthesisKeyword_3_1());	
			c.setLinewrap().after(a.getLeftParenthesisKeyword_3_1());	
			c.setLinewrap().before(a.getRightParenthesisKeyword_3_2());	
			c.setLinewrap().after(a.getRightParenthesisKeyword_3_2());	
			c.setNoSpace().after(a.getLeftParenthesisKeyword_3_1());
			//
			c.setIndentation(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_5());
			c.setNoSpace().between(a.getLeftParenthesisKeyword_0_0(), a.getRightParenthesisKeyword_0_5());
		}
	    {
	    	RealizedVariableCSElements a = f.getRealizedVariableCSAccess();
			c.setLinewrap(1).before(a.getRealizeKeyword_0());
			c.setLinewrap(1).after(a.getOwnedTypeAssignment_3());
	    }
	    {
	    	ScopeNameCSElements a = f.getScopeNameCSAccess();
			c.setNoSpace().around(a.getColonColonKeyword_1());
			c.setNoSpace().around(a.getColonColonKeyword_2_1());
	    }
	    {
	    	SourceBottomPatternCSElements a = f.getSourceBottomPatternCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_1());	
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_1());	
			c.setNoSpace().before(a.getCommaKeyword_2_1_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_0());	
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_3());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
		}
	    {
	    	SourceDomainCSElements a = f.getSourceDomainCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_2_0());	
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_2_1_2_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_2_2_2_0());
			c.setLinewrap().after(a.getCommaKeyword_2_2_2_0());	
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_2_3());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_3());
			c.setIndentation(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_3());
		}
	    {
	    	SourceGuardPatternCSElements a = f.getSourceGuardPatternCSAccess();
			c.setNoLinewrap().before(a.getLeftParenthesisKeyword_1());	
			c.setLinewrap().after(a.getLeftParenthesisKeyword_1());	
			c.setNoSpace().before(a.getCommaKeyword_2_1_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_0());	
			c.setLinewrap().before(a.getRightParenthesisKeyword_3());	
			c.setLinewrap().after(a.getRightParenthesisKeyword_3());	
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1());
			c.setNoSpace().before(a.getRightParenthesisKeyword_3());
			//
			c.setIndentation(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
			c.setNoSpace().between(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
		}
	    {
	    	TargetBottomPatternCSElements a = f.getTargetBottomPatternCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_1());	
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_1());	
			c.setNoSpace().before(a.getCommaKeyword_2_1_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_0());	
			c.setLinewrap().before(a.getRightCurlyBracketKeyword_3());	
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_3());	
			//
			c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
		}
	    {
	    	TargetDomainCSElements a = f.getTargetDomainCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_2_0());	
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_2_1_2_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_2_2_2_0());
			c.setLinewrap().after(a.getCommaKeyword_2_2_2_0());	
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_2_3());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_3());
			c.setIndentation(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_3());
		}
	    {
	    	TargetGuardPatternCSElements a = f.getTargetGuardPatternCSAccess();
			c.setNoLinewrap().before(a.getLeftParenthesisKeyword_1());	
			c.setLinewrap().after(a.getLeftParenthesisKeyword_1());	
			c.setNoSpace().before(a.getCommaKeyword_2_1_0());
			c.setLinewrap().after(a.getCommaKeyword_2_1_0());	
			c.setLinewrap().before(a.getRightParenthesisKeyword_3());	
			c.setLinewrap().after(a.getRightParenthesisKeyword_3());	
			c.setNoSpace().around(a.getLeftParenthesisKeyword_1());
			c.setNoSpace().before(a.getRightParenthesisKeyword_3());
			//
			c.setIndentation(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
			c.setNoSpace().between(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
		}
//	    {
//	    	TopLevelCSElements a = f.getTopLevelCSAccess();
//			c.setLinewrap(2).between(a.getOwnedMappingsMappingCSParserRuleCall_1_1_0(), a.getOwnedMappingsMappingCSParserRuleCall_1_1_0());
//			c.setLinewrap(2).before(a.getOwnedQueriesAssignment_1_2());
//			c.setLinewrap(2).before(a.getOwnedTransformationsAssignment_1_0());
//	    }
	}

	@Override
	public QVTimperativeGrammarAccess getGrammarAccess() {
		return (QVTimperativeGrammarAccess) super.getGrammarAccess();
	}
}
