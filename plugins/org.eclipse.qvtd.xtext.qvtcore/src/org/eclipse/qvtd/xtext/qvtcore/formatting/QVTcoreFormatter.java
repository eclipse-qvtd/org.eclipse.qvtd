/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcore.formatting;

import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess.MappingCSElements;
import org.eclipse.qvtd.xtext.qvtcorebase.formatting.QVTcoreBaseFormatter;
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

	    c.setLinewrap(2).before(f.getML_COMMENTRule());
	    c.setLinewrap(1).after(f.getML_COMMENTRule());

	    c.setLinewrap(2).between(f.getImportCSRule(), f.getTransformationCSRule());
	    c.setLinewrap(2).between(f.getImportCSRule(), f.getQueryCSRule());
	    c.setLinewrap(2).between(f.getMappingCSRule(), f.getMappingCSRule());
	    c.setLinewrap(2).between(f.getQueryCSRule(), f.getQueryCSRule());
	    c.setLinewrap(2).between(f.getQueryCSRule(), f.getTransformationCSRule());
	    c.setLinewrap(2).between(f.getTransformationCSRule(), f.getTransformationCSRule());
	    c.setLinewrap(2).between(f.getTransformationCSRule(), f.getQueryCSRule());

	    configureAssignmentCS(c, f.getAssignmentCSAccess());
	    configureBottomPatternCS(c, f.getBottomPatternCSAccess());
	    configureDirectionCS(c, f.getDirectionCSAccess());
	    configureGuardPatternCS(c, f.getGuardPatternCSAccess());
	    configureImportCS(c, f.getImportCSAccess());
	    configureQueryCS(c, f.getQueryCSAccess());
	    configureTransformationCS(c, f.getTransformationCSAccess());
	    {
	    	MappingCSElements a = f.getMappingCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5(), a.getRightCurlyBracketKeyword_9());
			setBraces(c, a.getLeftCurlyBracketKeyword_5(), a.getRightCurlyBracketKeyword_9());
			c.setLinewrap().before(a.getWhereKeyword_7_0());
	    }
	    {	// comments
	    	c.setNoLinewrap().before(f.getSL_COMMENTRule());
	    }
	}

	@Override
	public QVTcoreGrammarAccess getGrammarAccess() {
		return (QVTcoreGrammarAccess) super.getGrammarAccess();
	}
}
