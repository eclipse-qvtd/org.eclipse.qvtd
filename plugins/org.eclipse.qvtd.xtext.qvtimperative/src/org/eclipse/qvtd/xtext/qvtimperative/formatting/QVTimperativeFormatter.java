/*******************************************************************************
 * Copyright (c) 2011 E.D.Willink and others.
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
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.RealizedVariableCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.DirectionCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCallBindingCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingCallCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MappingLoopCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MiddleBottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.MiddleGuardPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SourceBottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.SourceGuardPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TargetBottomPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TargetGuardPatternCSElements;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess.TopLevelCSElements;
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
	    configureEssentialOCLNavigationOperatorCS(c, f.getEssentialOCLNavigationOperatorCSAccess());
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
	    configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
	    configureTupleTypeCS(c, f.getTupleTypeCSAccess());
	    configureURIPathNameCS(c, f.getURIPathNameCSAccess());

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

	    configureAssignmentCS(c, f.getAssignmentCSAccess());
	    configureDirectionCS(c, f.getDirectionCSAccess());
	    configureImportCS(c, f.getImportCSAccess());
	    configureQueryCS(c, f.getQueryCSAccess());
	    configureScopeNameCS(c, f.getScopeNameCSAccess());
	    configureTransformationCS(c, f.getTransformationCSAccess());

	    {
	    	MappingCSElements a = f.getMappingCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_9());
			setBraces(c, a.getLeftCurlyBracketKeyword_4(), a.getRightCurlyBracketKeyword_9());
//			c.setLinewrap(2).between(a.getDomainsAssignment_5(), a.getDomainsAssignment_5());
			c.setLinewrap(1).before(a.getDomainsAssignment_5());
			c.setLinewrap(1).before(a.getDomainsAssignment_6());
			c.setLinewrap(1).before(a.getWhereKeyword_7_0());
	    }
	    {
	    	MappingCallCSElements a = f.getMappingCallCSAccess();
			c.setLinewrap(1).before(a.getMapKeyword_1());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
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
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_1());	
			c.setLinewrap().after(a.getLeftCurlyBracketKeyword_1());	
			c.setLinewrap().before(a.getRightCurlyBracketKeyword_3());	
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_3());	
			//
			c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
		}
	    {
	    	MiddleGuardPatternCSElements a = f.getMiddleGuardPatternCSAccess();
			c.setNoLinewrap().before(a.getLeftParenthesisKeyword_1());	
			c.setLinewrap().after(a.getLeftParenthesisKeyword_1());	
			c.setLinewrap().before(a.getRightParenthesisKeyword_3());	
			c.setLinewrap().after(a.getRightParenthesisKeyword_3());	
			c.setNoSpace().after(a.getLeftParenthesisKeyword_1());
			c.setNoSpace().before(a.getRightParenthesisKeyword_3());
			//
			c.setIndentation(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
			c.setNoSpace().between(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
		}
	    {
	    	RealizedVariableCSElements a = f.getRealizedVariableCSAccess();
			c.setLinewrap(1).before(a.getRealizeKeyword_0());
			c.setLinewrap(1).after(a.getOwnedTypeAssignment_3());
	    }
	    {
	    	SourceBottomPatternCSElements a = f.getSourceBottomPatternCSAccess();
			c.setNoLinewrap().before(a.getLeftCurlyBracketKeyword_1());	
			c.setLinewrap().after(a.getRightCurlyBracketKeyword_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_2());
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
	    {
	    	TopLevelCSElements a = f.getTopLevelCSAccess();
			c.setLinewrap(2).before(a.getAlternatives_1());
	    }
	}

	@Override
	public QVTimperativeGrammarAccess getGrammarAccess() {
		return (QVTimperativeGrammarAccess) super.getGrammarAccess();
	}
}
