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
package org.eclipse.qvtd.xtext.qvtcore.formatting;

import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.MappingCSElements;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.TopLevelCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.formatting.QVTcoreBaseFormatter;
import org.eclipse.qvtd.xtext.qvtcorebase.services.QVTcoreBaseGrammarAccess.ScopeNameCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class QVTcoreFormatter extends QVTcoreBaseFormatter
{
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
