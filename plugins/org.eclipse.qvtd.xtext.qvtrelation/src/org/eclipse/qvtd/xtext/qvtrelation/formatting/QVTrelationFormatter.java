/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.formatting;

import org.eclipse.ocl.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.CollectionTemplateCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.DefaultValueCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.DomainCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.KeyDeclCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.ModelDeclCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.ObjectTemplateCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.PredicateCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.PrimitiveTypeDomainCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.QueryCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.RelationCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.ScopeNameCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.TemplateCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.TopLevelCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.TransformationCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.UnitCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.VarDeclarationCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.WhenCSElements;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess.WhereCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class QVTrelationFormatter extends AbstractEssentialOCLFormatter
{
	@Override
	protected void configureFormatting(FormattingConfig c) {
	    c.setAutoLinewrap(120);

	    QVTrelationGrammarAccess f = getGrammarAccess();
	    
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
//		configureTypedTypeRefCS(c, f.getTypedTypeRefCSAccess());
	    configureURIPathNameCS(c, f.getURIPathNameCSAccess());

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

	    {
	    	CollectionTemplateCSElements a = f.getCollectionTemplateCSAccess();
		    c.setLinewrap(1).before(a.getOwnedMemberIdentifiersAssignment_4_0());
		    c.setLinewrap(1).before(a.getOwnedMemberIdentifiersAssignment_4_1_1());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
			c.setNoSpace().before(a.getCommaKeyword_4_1_0());
	    }
	    {
	    	DefaultValueCSElements a = f.getDefaultValueCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
	    }
	    {
	    	DomainCSElements a = f.getDomainCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_1(), a.getRightCurlyBracketKeyword_6_3());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_6_1(), a.getRightCurlyBracketKeyword_6_3());
			setNoSpaceLineWrap(c, a.getCommaKeyword_4_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7());
	    }
	    {
	    	KeyDeclCSElements a = f.getKeyDeclCSAccess();
			c.setNoSpace().after(a.getLeftCurlyBracketKeyword_2());
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3_1_1());
			c.setNoSpace().before(a.getRightParenthesisKeyword_3_1_3());
			c.setNoSpace().before(a.getCommaKeyword_4_0());
			c.setNoSpace().around(a.getLeftParenthesisKeyword_4_1_1_1());
			c.setNoSpace().before(a.getRightParenthesisKeyword_4_1_1_3());
			c.setNoSpace().around(a.getRightCurlyBracketKeyword_5());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6());
	    }
	    {
	    	ModelDeclCSElements a = f.getModelDeclCSAccess();
			c.setNoSpace().after(a.getLeftCurlyBracketKeyword_2_1_0());
			c.setNoSpace().before(a.getRightCurlyBracketKeyword_2_1_3());
			c.setNoSpace().before(a.getCommaKeyword_2_1_2_0());
	    }
	    {
	    	ObjectTemplateCSElements a = f.getObjectTemplateCSAccess();
		    c.setLinewrap(1).before(a.getOwnedPropertyTemplatesAssignment_4_0());
		    c.setLinewrap(1).before(a.getOwnedPropertyTemplatesAssignment_4_1_1());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_3(), a.getRightCurlyBracketKeyword_5());
			c.setNoSpace().before(a.getCommaKeyword_4_1_0());
	    }
	    {
	    	PredicateCSElements a = f.getPredicateCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_1());
	    }
	    {
	    	PrimitiveTypeDomainCSElements a = f.getPrimitiveTypeDomainCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5());
	    }
	    {
	    	QueryCSElements a = f.getQueryCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_2());	
			c.setNoSpace().before(a.getCommaKeyword_3_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_4());	
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_0());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_7_1_0(), a.getRightCurlyBracketKeyword_7_1_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_1_0(), a.getRightCurlyBracketKeyword_7_1_2());
		    c.setIndentation(a.getLeftParenthesisKeyword_2(), a.getRightParenthesisKeyword_4());
	    }
	    {
	    	RelationCSElements a = f.getRelationCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5(), a.getRightCurlyBracketKeyword_10());
			setBraces(c, a.getLeftCurlyBracketKeyword_5(), a.getRightCurlyBracketKeyword_10());
			c.setLinewrap(2).before(a.getAlternatives_7());
			c.setLinewrap(2).before(a.getOwnedWhenAssignment_8());
			c.setLinewrap(2).before(a.getOwnedWhereAssignment_9());
	    }
	    {
	    	ScopeNameCSElements a = f.getScopeNameCSAccess();
			c.setNoSpace().around(a.getColonColonKeyword_1());
			c.setNoSpace().around(a.getColonColonKeyword_2_1());
	    }
	    {
	    	TemplateCSElements a = f.getTemplateCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_1_0(), a.getRightCurlyBracketKeyword_1_2());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_1_0(), a.getRightCurlyBracketKeyword_1_2());
	    }
	    {
	    	TopLevelCSElements a = f.getTopLevelCSAccess();
			c.setLinewrap(2).before(a.getOwnedTransformationsAssignment_1());
	    }
	    {
	    	TransformationCSElements a = f.getTransformationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3());	
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3());	
			c.setNoSpace().before(a.getCommaKeyword_5_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_6());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_8(), a.getRightCurlyBracketKeyword_11());
			setBraces(c, a.getLeftCurlyBracketKeyword_8(), a.getRightCurlyBracketKeyword_11());
			c.setLinewrap(2).between(a.getOwnedKeyDeclsAssignment_9(), a.getAlternatives_10());
			c.setLinewrap(2).between(a.getAlternatives_10(), a.getAlternatives_10());
		    c.setIndentation(a.getLeftParenthesisKeyword_3(), a.getRightParenthesisKeyword_6());
	    }
	    {
	    	UnitCSElements a = f.getUnitCSAccess();
			c.setNoSpace().around(a.getColonColonKeyword_3_0());	
			c.setNoSpace().around(a.getIsAllAsteriskKeyword_3_1_0());	
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
	    	VarDeclarationCSElements a = f.getVarDeclarationCSAccess();
			c.setNoSpace().before(a.getCommaKeyword_1_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
	    	WhenCSElements a = f.getWhenCSAccess();
		    c.setLinewrap(1).before(a.getOwnedPredicatesAssignment_3());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2(), a.getRightCurlyBracketKeyword_4());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_2(), a.getRightCurlyBracketKeyword_4());
	    }
	    {
	    	WhereCSElements a = f.getWhereCSAccess();
		    c.setLinewrap(1).before(a.getOwnedPredicatesAssignment_3());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2(), a.getRightCurlyBracketKeyword_4());
			setAppendedBraces(c, a.getLeftCurlyBracketKeyword_2(), a.getRightCurlyBracketKeyword_4());
	    }
	}

	@Override
	public QVTrelationGrammarAccess getGrammarAccess() {
		return (QVTrelationGrammarAccess) super.getGrammarAccess();
	}
}
