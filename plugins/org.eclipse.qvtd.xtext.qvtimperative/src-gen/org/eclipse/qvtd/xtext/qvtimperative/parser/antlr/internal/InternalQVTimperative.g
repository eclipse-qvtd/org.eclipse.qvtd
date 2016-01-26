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
grammar InternalQVTimperative;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
	
}

@lexer::header {
package org.eclipse.qvtd.xtext.qvtimperative.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.qvtd.xtext.qvtimperative.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/
 
 	private QVTimperativeGrammarAccess grammarAccess;
 	
    public InternalQVTimperativeParser(TokenStream input, QVTimperativeGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "TopLevelCS";	
   	}
   	
   	@Override
   	protected QVTimperativeGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleTopLevelCS
entryRuleTopLevelCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTopLevelCSRule()); }
	 iv_ruleTopLevelCS=ruleTopLevelCS 
	 { $current=$iv_ruleTopLevelCS.current; } 
	 EOF 
;

// Rule TopLevelCS
ruleTopLevelCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedImportsImportCSParserRuleCall_0_0()); 
	    }
		lv_ownedImports_0_0=ruleImportCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
	        }
       		add(
       			$current, 
       			"ownedImports",
        		lv_ownedImports_0_0, 
        		"ImportCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*((
(
		{ 
	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsTransformationCSParserRuleCall_1_0_0()); 
	    }
		lv_ownedTransformations_1_0=ruleTransformationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
	        }
       		add(
       			$current, 
       			"ownedTransformations",
        		lv_ownedTransformations_1_0, 
        		"TransformationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedMappingsMappingCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedMappings_2_0=ruleMappingCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
	        }
       		add(
       			$current, 
       			"ownedMappings",
        		lv_ownedMappings_2_0, 
        		"MappingCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedQueriesQueryCSParserRuleCall_1_2_0()); 
	    }
		lv_ownedQueries_3_0=ruleQueryCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
	        }
       		add(
       			$current, 
       			"ownedQueries",
        		lv_ownedQueries_3_0, 
        		"QueryCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleDirectionCS
entryRuleDirectionCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDirectionCSRule()); }
	 iv_ruleDirectionCS=ruleDirectionCS 
	 { $current=$iv_ruleDirectionCS.current; } 
	 EOF 
;

// Rule DirectionCS
ruleDirectionCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getDirectionCSAccess().getDirectionCSAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDirectionCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='imports' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getDirectionCSAccess().getImportsKeyword_2_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDirectionCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_2_1_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getDirectionCSAccess().getCommaKeyword_2_2_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDirectionCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_2_2_1_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(	otherlv_6='uses' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getUsesKeyword_3_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDirectionCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_3_1_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getDirectionCSAccess().getCommaKeyword_3_2_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDirectionCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_3_2_1_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))*)?)
;





// Entry rule entryRuleMappingCS
entryRuleMappingCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMappingCSRule()); }
	 iv_ruleMappingCS=ruleMappingCS 
	 { $current=$iv_ruleMappingCS.current; } 
	 EOF 
;

// Rule MappingCS
ruleMappingCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getMappingCSAccess().getMappingCSAction_0(),
            $current);
    }
)(
(
		lv_isDefault_1_0=	'default' 
    {
        newLeafNode(lv_isDefault_1_0, grammarAccess.getMappingCSAccess().getIsDefaultDefaultKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMappingCSRule());
	        }
       		setWithLastConsumed($current, "isDefault", true, "default");
	    }

)
)?	otherlv_2='map' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMappingCSAccess().getMapKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); 
	    }
		lv_name_3_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_3_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='in' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMappingCSAccess().getInKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedInPathNamePathNameCSParserRuleCall_4_1_0()); 
	    }
		lv_ownedInPathName_5_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		set(
       			$current, 
       			"ownedInPathName",
        		lv_ownedInPathName_5_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='uses' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMappingCSAccess().getUsesKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedUsesPathNamesPathNameCSParserRuleCall_5_1_0()); 
	    }
		lv_ownedUsesPathNames_7_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		add(
       			$current, 
       			"ownedUsesPathNames",
        		lv_ownedUsesPathNames_7_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getMappingCSAccess().getCommaKeyword_5_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedUsesPathNamesPathNameCSParserRuleCall_5_2_1_0()); 
	    }
		lv_ownedUsesPathNames_9_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		add(
       			$current, 
       			"ownedUsesPathNames",
        		lv_ownedUsesPathNames_9_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_10='{' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_6());
    }
(
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedDomainsSourceDomainCSParserRuleCall_7_0_0()); 
	    }
		lv_ownedDomains_11_1=ruleSourceDomainCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		add(
       			$current, 
       			"ownedDomains",
        		lv_ownedDomains_11_1, 
        		"SourceDomainCS");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedDomainsTargetDomainCSParserRuleCall_7_0_1()); 
	    }
		lv_ownedDomains_11_2=ruleTargetDomainCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		add(
       			$current, 
       			"ownedDomains",
        		lv_ownedDomains_11_2, 
        		"TargetDomainCS");
	        afterParserOrEnumRuleCall();
	    }

)

)
)*(	otherlv_12='where' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getMappingCSAccess().getWhereKeyword_8_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedMiddleMiddleDomainCSParserRuleCall_8_1_0()); 
	    }
		lv_ownedMiddle_13_0=ruleMiddleDomainCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		set(
       			$current, 
       			"ownedMiddle",
        		lv_ownedMiddle_13_0, 
        		"MiddleDomainCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedMappingSequenceMappingSequenceCSParserRuleCall_9_0()); 
	    }
		lv_ownedMappingSequence_14_0=ruleMappingSequenceCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCSRule());
	        }
       		set(
       			$current, 
       			"ownedMappingSequence",
        		lv_ownedMappingSequence_14_0, 
        		"MappingSequenceCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_15='}' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_10());
    }
)
;





// Entry rule entryRuleMappingCallCS
entryRuleMappingCallCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMappingCallCSRule()); }
	 iv_ruleMappingCallCS=ruleMappingCallCS 
	 { $current=$iv_ruleMappingCallCS.current; } 
	 EOF 
;

// Rule MappingCallCS
ruleMappingCallCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getMappingCallCSAccess().getMappingCallCSAction_0(),
            $current);
    }
)(
(
		lv_isInfinite_1_0=	'infinite' 
    {
        newLeafNode(lv_isInfinite_1_0, grammarAccess.getMappingCallCSAccess().getIsInfiniteInfiniteKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMappingCallCSRule());
	        }
       		setWithLastConsumed($current, "isInfinite", true, "infinite");
	    }

)
)?	otherlv_2='call' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMappingCallCSAccess().getCallKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCallCSAccess().getOwnedPathNamePathNameCSParserRuleCall_3_0()); 
	    }
		lv_ownedPathName_3_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCallCSRule());
	        }
       		set(
       			$current, 
       			"ownedPathName",
        		lv_ownedPathName_3_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMappingCallCSAccess().getLeftCurlyBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCallCSAccess().getOwnedBindingsMappingCallBindingCSParserRuleCall_5_0()); 
	    }
		lv_ownedBindings_5_0=ruleMappingCallBindingCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCallCSRule());
	        }
       		add(
       			$current, 
       			"ownedBindings",
        		lv_ownedBindings_5_0, 
        		"MappingCallBindingCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6='}' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMappingCallCSAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleMappingCallBindingCS
entryRuleMappingCallBindingCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMappingCallBindingCSRule()); }
	 iv_ruleMappingCallBindingCS=ruleMappingCallBindingCS 
	 { $current=$iv_ruleMappingCallBindingCS.current; } 
	 EOF 
;

// Rule MappingCallBindingCS
ruleMappingCallBindingCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getMappingCallBindingCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getMappingCallBindingCSAccess().getReferredVariableVariableCrossReference_0_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=':=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMappingCallBindingCSAccess().getColonEqualsSignKeyword_1_0());
    }

    |(
(
		lv_isPolled_2_0=	'?=' 
    {
        newLeafNode(lv_isPolled_2_0, grammarAccess.getMappingCallBindingCSAccess().getIsPolledQuestionMarkEqualsSignKeyword_1_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMappingCallBindingCSRule());
	        }
       		setWithLastConsumed($current, "isPolled", true, "?=");
	    }

)
))(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingCallBindingCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
	    }
		lv_ownedValue_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingCallBindingCSRule());
	        }
       		set(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4=';' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMappingCallBindingCSAccess().getSemicolonKeyword_3());
    }
)
;





// Entry rule entryRuleMappingLoopCS
entryRuleMappingLoopCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMappingLoopCSRule()); }
	 iv_ruleMappingLoopCS=ruleMappingLoopCS 
	 { $current=$iv_ruleMappingLoopCS.current; } 
	 EOF 
;

// Rule MappingLoopCS
ruleMappingLoopCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='for' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMappingLoopCSAccess().getForKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingLoopCSAccess().getOwnedIteratorMappingIteratorCSParserRuleCall_1_0()); 
	    }
		lv_ownedIterator_1_0=ruleMappingIteratorCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
	        }
       		set(
       			$current, 
       			"ownedIterator",
        		lv_ownedIterator_1_0, 
        		"MappingIteratorCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='in' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMappingLoopCSAccess().getInKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingLoopCSAccess().getOwnedInExpressionExpCSParserRuleCall_3_0()); 
	    }
		lv_ownedInExpression_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
	        }
       		set(
       			$current, 
       			"ownedInExpression",
        		lv_ownedInExpression_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='{' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMappingLoopCSAccess().getLeftCurlyBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingLoopCSAccess().getOwnedMappingSequenceMappingSequenceCSParserRuleCall_5_0()); 
	    }
		lv_ownedMappingSequence_5_0=ruleMappingSequenceCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
	        }
       		set(
       			$current, 
       			"ownedMappingSequence",
        		lv_ownedMappingSequence_5_0, 
        		"MappingSequenceCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='}' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMappingLoopCSAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleMappingIteratorCS
entryRuleMappingIteratorCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMappingIteratorCSRule()); }
	 iv_ruleMappingIteratorCS=ruleMappingIteratorCS 
	 { $current=$iv_ruleMappingIteratorCS.current; } 
	 EOF 
;

// Rule MappingIteratorCS
ruleMappingIteratorCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getMappingIteratorCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingIteratorCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMappingIteratorCSAccess().getColonKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingIteratorCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingIteratorCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleMappingSequenceCS
entryRuleMappingSequenceCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMappingSequenceCSRule()); }
	 iv_ruleMappingSequenceCS=ruleMappingSequenceCS 
	 { $current=$iv_ruleMappingSequenceCS.current; } 
	 EOF 
;

// Rule MappingSequenceCS
ruleMappingSequenceCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getMappingSequenceCSAccess().getOwnedMappingStatementsMappingStatementCSParserRuleCall_0()); 
	    }
		lv_ownedMappingStatements_0_0=ruleMappingStatementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMappingSequenceCSRule());
	        }
       		add(
       			$current, 
       			"ownedMappingStatements",
        		lv_ownedMappingStatements_0_0, 
        		"MappingStatementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleMappingStatementCS
entryRuleMappingStatementCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMappingStatementCSRule()); }
	 iv_ruleMappingStatementCS=ruleMappingStatementCS 
	 { $current=$iv_ruleMappingStatementCS.current; } 
	 EOF 
;

// Rule MappingStatementCS
ruleMappingStatementCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getMappingStatementCSAccess().getMappingCallCSParserRuleCall_0()); 
    }
    this_MappingCallCS_0=ruleMappingCallCS
    { 
        $current = $this_MappingCallCS_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getMappingStatementCSAccess().getMappingLoopCSParserRuleCall_1()); 
    }
    this_MappingLoopCS_1=ruleMappingLoopCS
    { 
        $current = $this_MappingLoopCS_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleImperativePredicateOrAssignmentCS
entryRuleImperativePredicateOrAssignmentCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getImperativePredicateOrAssignmentCSRule()); }
	 iv_ruleImperativePredicateOrAssignmentCS=ruleImperativePredicateOrAssignmentCS 
	 { $current=$iv_ruleImperativePredicateOrAssignmentCS.current; } 
	 EOF 
;

// Rule ImperativePredicateOrAssignmentCS
ruleImperativePredicateOrAssignmentCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_isDefault_0_0=	'default' 
    {
        newLeafNode(lv_isDefault_0_0, grammarAccess.getImperativePredicateOrAssignmentCSAccess().getIsDefaultDefaultKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getImperativePredicateOrAssignmentCSRule());
	        }
       		setWithLastConsumed($current, "isDefault", true, "default");
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getImperativePredicateOrAssignmentCSAccess().getOwnedTargetExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedTarget_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImperativePredicateOrAssignmentCSRule());
	        }
       		set(
       			$current, 
       			"ownedTarget",
        		lv_ownedTarget_1_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((	otherlv_2=':=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getImperativePredicateOrAssignmentCSAccess().getColonEqualsSignKeyword_2_0_0());
    }

    |(
(
		lv_isAccumulate_3_0=	'+=' 
    {
        newLeafNode(lv_isAccumulate_3_0, grammarAccess.getImperativePredicateOrAssignmentCSAccess().getIsAccumulatePlusSignEqualsSignKeyword_2_0_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getImperativePredicateOrAssignmentCSRule());
	        }
       		setWithLastConsumed($current, "isAccumulate", true, "+=");
	    }

)
))(
(
		{ 
	        newCompositeNode(grammarAccess.getImperativePredicateOrAssignmentCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedInitExpression_4_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImperativePredicateOrAssignmentCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_4_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_5=';' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getImperativePredicateOrAssignmentCSAccess().getSemicolonKeyword_3());
    }
)
;





// Entry rule entryRuleSourceDomainCS
entryRuleSourceDomainCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSourceDomainCSRule()); }
	 iv_ruleSourceDomainCS=ruleSourceDomainCS 
	 { $current=$iv_ruleSourceDomainCS.current; } 
	 EOF 
;

// Rule SourceDomainCS
ruleSourceDomainCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_isCheck_0_0=	'check' 
    {
        newLeafNode(lv_isCheck_0_0, grammarAccess.getSourceDomainCSAccess().getIsCheckCheckKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSourceDomainCSRule());
	        }
       		setWithLastConsumed($current, "isCheck", true, "check");
	    }

)
)(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSourceDomainCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSourceDomainCSAccess().getDirectionTypedModelCrossReference_1_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSourceDomainCSAccess().getLeftCurlyBracketKeyword_2_0());
    }
(	otherlv_3='check' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getSourceDomainCSAccess().getCheckKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceDomainCSAccess().getCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0()); 
	    }
		lv_checkedProperties_4_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceDomainCSRule());
	        }
       		add(
       			$current, 
       			"checkedProperties",
        		lv_checkedProperties_4_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getSourceDomainCSAccess().getCommaKeyword_2_1_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceDomainCSAccess().getCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0()); 
	    }
		lv_checkedProperties_6_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceDomainCSRule());
	        }
       		add(
       			$current, 
       			"checkedProperties",
        		lv_checkedProperties_6_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(	otherlv_7='enforce' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getSourceDomainCSAccess().getEnforceKeyword_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceDomainCSAccess().getEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0()); 
	    }
		lv_enforcedProperties_8_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceDomainCSRule());
	        }
       		add(
       			$current, 
       			"enforcedProperties",
        		lv_enforcedProperties_8_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_9=',' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getSourceDomainCSAccess().getCommaKeyword_2_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceDomainCSAccess().getEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0()); 
	    }
		lv_enforcedProperties_10_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceDomainCSRule());
	        }
       		add(
       			$current, 
       			"enforcedProperties",
        		lv_enforcedProperties_10_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getSourceDomainCSAccess().getRightCurlyBracketKeyword_2_3());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceDomainCSAccess().getOwnedGuardPatternSourceGuardPatternCSParserRuleCall_3_0()); 
	    }
		lv_ownedGuardPattern_12_0=ruleSourceGuardPatternCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceDomainCSRule());
	        }
       		set(
       			$current, 
       			"ownedGuardPattern",
        		lv_ownedGuardPattern_12_0, 
        		"SourceGuardPatternCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceDomainCSAccess().getOwnedBottomPatternSourceBottomPatternCSParserRuleCall_4_0()); 
	    }
		lv_ownedBottomPattern_13_0=ruleSourceBottomPatternCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceDomainCSRule());
	        }
       		set(
       			$current, 
       			"ownedBottomPattern",
        		lv_ownedBottomPattern_13_0, 
        		"SourceBottomPatternCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleSourceBottomPatternCS
entryRuleSourceBottomPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSourceBottomPatternCSRule()); }
	 iv_ruleSourceBottomPatternCS=ruleSourceBottomPatternCS 
	 { $current=$iv_ruleSourceBottomPatternCS.current; } 
	 EOF 
;

// Rule SourceBottomPatternCS
ruleSourceBottomPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getSourceBottomPatternCSAccess().getBottomPatternCSAction_0(),
            $current);
    }
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getSourceBottomPatternCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getSourceBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedUnrealizedVariables_2_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_2_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getSourceBottomPatternCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedUnrealizedVariables_4_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_4_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getSourceBottomPatternCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleSourceGuardPatternCS
entryRuleSourceGuardPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSourceGuardPatternCSRule()); }
	 iv_ruleSourceGuardPatternCS=ruleSourceGuardPatternCS 
	 { $current=$iv_ruleSourceGuardPatternCS.current; } 
	 EOF 
;

// Rule SourceGuardPatternCS
ruleSourceGuardPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getSourceGuardPatternCSAccess().getGuardPatternCSAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getSourceGuardPatternCSAccess().getLeftParenthesisKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getSourceGuardPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedUnrealizedVariables_2_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_2_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getSourceGuardPatternCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSourceGuardPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedUnrealizedVariables_4_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSourceGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_4_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getSourceGuardPatternCSAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleMiddleDomainCS
entryRuleMiddleDomainCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMiddleDomainCSRule()); }
	 iv_ruleMiddleDomainCS=ruleMiddleDomainCS 
	 { $current=$iv_ruleMiddleDomainCS.current; } 
	 EOF 
;

// Rule MiddleDomainCS
ruleMiddleDomainCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMiddleDomainCSAccess().getLeftCurlyBracketKeyword_0_0());
    }
(	otherlv_1='check' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMiddleDomainCSAccess().getCheckKeyword_0_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleDomainCSAccess().getCheckedPropertiesPathNameCSParserRuleCall_0_1_1_0()); 
	    }
		lv_checkedProperties_2_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleDomainCSRule());
	        }
       		add(
       			$current, 
       			"checkedProperties",
        		lv_checkedProperties_2_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMiddleDomainCSAccess().getCommaKeyword_0_1_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleDomainCSAccess().getCheckedPropertiesPathNameCSParserRuleCall_0_1_2_1_0()); 
	    }
		lv_checkedProperties_4_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleDomainCSRule());
	        }
       		add(
       			$current, 
       			"checkedProperties",
        		lv_checkedProperties_4_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(	otherlv_5='enforce' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMiddleDomainCSAccess().getEnforceKeyword_0_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleDomainCSAccess().getEnforcedPropertiesPathNameCSParserRuleCall_0_2_1_0()); 
	    }
		lv_enforcedProperties_6_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleDomainCSRule());
	        }
       		add(
       			$current, 
       			"enforcedProperties",
        		lv_enforcedProperties_6_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_7=',' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getMiddleDomainCSAccess().getCommaKeyword_0_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleDomainCSAccess().getEnforcedPropertiesPathNameCSParserRuleCall_0_2_2_1_0()); 
	    }
		lv_enforcedProperties_8_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleDomainCSRule());
	        }
       		add(
       			$current, 
       			"enforcedProperties",
        		lv_enforcedProperties_8_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getMiddleDomainCSAccess().getRightCurlyBracketKeyword_0_3());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleDomainCSAccess().getOwnedGuardPatternMiddleGuardPatternCSParserRuleCall_1_0()); 
	    }
		lv_ownedGuardPattern_10_0=ruleMiddleGuardPatternCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleDomainCSRule());
	        }
       		set(
       			$current, 
       			"ownedGuardPattern",
        		lv_ownedGuardPattern_10_0, 
        		"MiddleGuardPatternCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleDomainCSAccess().getOwnedBottomPatternMiddleBottomPatternCSParserRuleCall_2_0()); 
	    }
		lv_ownedBottomPattern_11_0=ruleMiddleBottomPatternCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleDomainCSRule());
	        }
       		set(
       			$current, 
       			"ownedBottomPattern",
        		lv_ownedBottomPattern_11_0, 
        		"MiddleBottomPatternCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleMiddleBottomPatternCS
entryRuleMiddleBottomPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMiddleBottomPatternCSRule()); }
	 iv_ruleMiddleBottomPatternCS=ruleMiddleBottomPatternCS 
	 { $current=$iv_ruleMiddleBottomPatternCS.current; } 
	 EOF 
;

// Rule MiddleBottomPatternCS
ruleMiddleBottomPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMiddleBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0()); 
	    }
		lv_ownedUnrealizedVariables_1_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_1_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=',' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMiddleBottomPatternCSAccess().getCommaKeyword_0_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0()); 
	    }
		lv_ownedUnrealizedVariables_3_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_3_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4='|' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMiddleBottomPatternCSAccess().getVerticalLineKeyword_0_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleBottomPatternCSAccess().getOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_0_4_0()); 
	    }
		lv_ownedConstraints_5_0=ruleImperativePredicateOrAssignmentCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedConstraints",
        		lv_ownedConstraints_5_0, 
        		"ImperativePredicateOrAssignmentCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6='}' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMiddleBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5());
    }
)
    |(	otherlv_7='{' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getMiddleBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedUnrealizedVariables_8_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_8_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_9=',' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getMiddleBottomPatternCSAccess().getCommaKeyword_1_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0()); 
	    }
		lv_ownedUnrealizedVariables_10_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_10_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getMiddleBottomPatternCSAccess().getRightCurlyBracketKeyword_1_3());
    }
)
    |(	otherlv_12='{' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getMiddleBottomPatternCSAccess().getLeftCurlyBracketKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMiddleBottomPatternCSAccess().getOwnedConstraintsImperativePredicateOrAssignmentCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedConstraints_13_0=ruleImperativePredicateOrAssignmentCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMiddleBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedConstraints",
        		lv_ownedConstraints_13_0, 
        		"ImperativePredicateOrAssignmentCS");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_14='}' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getMiddleBottomPatternCSAccess().getRightCurlyBracketKeyword_2_2());
    }
)
    |((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getMiddleBottomPatternCSAccess().getBottomPatternCSAction_3_0(),
            $current);
    }
)	otherlv_16='{' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getMiddleBottomPatternCSAccess().getLeftCurlyBracketKeyword_3_1());
    }
	otherlv_17='}' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getMiddleBottomPatternCSAccess().getRightCurlyBracketKeyword_3_2());
    }
))
;





// Entry rule entryRuleMiddleGuardPatternCS
entryRuleMiddleGuardPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMiddleGuardPatternCSRule()); }
	 iv_ruleMiddleGuardPatternCS=ruleMiddleGuardPatternCS 
	 { $current=$iv_ruleMiddleGuardPatternCS.current; } 
	 EOF 
;

// Rule MiddleGuardPatternCS
ruleMiddleGuardPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getMiddleGuardPatternCSAccess().getGuardPatternCSParserRuleCall()); 
    }
    this_GuardPatternCS_0=ruleGuardPatternCS
    { 
        $current = $this_GuardPatternCS_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleTargetDomainCS
entryRuleTargetDomainCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTargetDomainCSRule()); }
	 iv_ruleTargetDomainCS=ruleTargetDomainCS 
	 { $current=$iv_ruleTargetDomainCS.current; } 
	 EOF 
;

// Rule TargetDomainCS
ruleTargetDomainCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_isEnforce_0_0=	'enforce' 
    {
        newLeafNode(lv_isEnforce_0_0, grammarAccess.getTargetDomainCSAccess().getIsEnforceEnforceKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTargetDomainCSRule());
	        }
       		setWithLastConsumed($current, "isEnforce", true, "enforce");
	    }

)
)(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTargetDomainCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getTargetDomainCSAccess().getDirectionTypedModelCrossReference_1_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTargetDomainCSAccess().getLeftCurlyBracketKeyword_2_0());
    }
(	otherlv_3='check' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTargetDomainCSAccess().getCheckKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetDomainCSAccess().getCheckedPropertiesPathNameCSParserRuleCall_2_1_1_0()); 
	    }
		lv_checkedProperties_4_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetDomainCSRule());
	        }
       		add(
       			$current, 
       			"checkedProperties",
        		lv_checkedProperties_4_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTargetDomainCSAccess().getCommaKeyword_2_1_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetDomainCSAccess().getCheckedPropertiesPathNameCSParserRuleCall_2_1_2_1_0()); 
	    }
		lv_checkedProperties_6_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetDomainCSRule());
	        }
       		add(
       			$current, 
       			"checkedProperties",
        		lv_checkedProperties_6_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(	otherlv_7='enforce' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getTargetDomainCSAccess().getEnforceKeyword_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetDomainCSAccess().getEnforcedPropertiesPathNameCSParserRuleCall_2_2_1_0()); 
	    }
		lv_enforcedProperties_8_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetDomainCSRule());
	        }
       		add(
       			$current, 
       			"enforcedProperties",
        		lv_enforcedProperties_8_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_9=',' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getTargetDomainCSAccess().getCommaKeyword_2_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetDomainCSAccess().getEnforcedPropertiesPathNameCSParserRuleCall_2_2_2_1_0()); 
	    }
		lv_enforcedProperties_10_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetDomainCSRule());
	        }
       		add(
       			$current, 
       			"enforcedProperties",
        		lv_enforcedProperties_10_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getTargetDomainCSAccess().getRightCurlyBracketKeyword_2_3());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetDomainCSAccess().getOwnedGuardPatternTargetGuardPatternCSParserRuleCall_3_0()); 
	    }
		lv_ownedGuardPattern_12_0=ruleTargetGuardPatternCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetDomainCSRule());
	        }
       		set(
       			$current, 
       			"ownedGuardPattern",
        		lv_ownedGuardPattern_12_0, 
        		"TargetGuardPatternCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetDomainCSAccess().getOwnedBottomPatternTargetBottomPatternCSParserRuleCall_4_0()); 
	    }
		lv_ownedBottomPattern_13_0=ruleTargetBottomPatternCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetDomainCSRule());
	        }
       		set(
       			$current, 
       			"ownedBottomPattern",
        		lv_ownedBottomPattern_13_0, 
        		"TargetBottomPatternCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleTargetBottomPatternCS
entryRuleTargetBottomPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTargetBottomPatternCSRule()); }
	 iv_ruleTargetBottomPatternCS=ruleTargetBottomPatternCS 
	 { $current=$iv_ruleTargetBottomPatternCS.current; } 
	 EOF 
;

// Rule TargetBottomPatternCS
ruleTargetBottomPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getTargetBottomPatternCSAccess().getBottomPatternCSAction_0(),
            $current);
    }
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTargetBottomPatternCSAccess().getLeftCurlyBracketKeyword_1());
    }
(((
(
		{ 
	        newCompositeNode(grammarAccess.getTargetBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_0_0_0()); 
	    }
		lv_ownedRealizedVariables_2_0=ruleRealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedRealizedVariables",
        		lv_ownedRealizedVariables_2_0, 
        		"RealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_1_0()); 
	    }
		lv_ownedUnrealizedVariables_3_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_3_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getTargetBottomPatternCSAccess().getCommaKeyword_2_1_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getTargetBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_2_1_1_0_0()); 
	    }
		lv_ownedRealizedVariables_5_0=ruleRealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedRealizedVariables",
        		lv_ownedRealizedVariables_5_0, 
        		"RealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_1_0()); 
	    }
		lv_ownedUnrealizedVariables_6_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_6_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))*)?	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getTargetBottomPatternCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleTargetGuardPatternCS
entryRuleTargetGuardPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTargetGuardPatternCSRule()); }
	 iv_ruleTargetGuardPatternCS=ruleTargetGuardPatternCS 
	 { $current=$iv_ruleTargetGuardPatternCS.current; } 
	 EOF 
;

// Rule TargetGuardPatternCS
ruleTargetGuardPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getTargetGuardPatternCSAccess().getGuardPatternCSAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTargetGuardPatternCSAccess().getLeftParenthesisKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getTargetGuardPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedUnrealizedVariables_2_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_2_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTargetGuardPatternCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetGuardPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedUnrealizedVariables_4_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_4_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTargetGuardPatternCSAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleBottomPatternCS
entryRuleBottomPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBottomPatternCSRule()); }
	 iv_ruleBottomPatternCS=ruleBottomPatternCS 
	 { $current=$iv_ruleBottomPatternCS.current; } 
	 EOF 
;

// Rule BottomPatternCS
ruleBottomPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); 
	    }
		lv_ownedUnrealizedVariables_1_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_1_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); 
	    }
		lv_ownedRealizedVariables_2_0=ruleRealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedRealizedVariables",
        		lv_ownedRealizedVariables_2_0, 
        		"RealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_0_2_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); 
	    }
		lv_ownedUnrealizedVariables_4_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_4_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); 
	    }
		lv_ownedRealizedVariables_5_0=ruleRealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedRealizedVariables",
        		lv_ownedRealizedVariables_5_0, 
        		"RealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))*	otherlv_6='|' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0()); 
	    }
		lv_ownedConstraints_7_0=rulePredicateOrAssignmentCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedConstraints",
        		lv_ownedConstraints_7_0, 
        		"PredicateOrAssignmentCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8='}' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5());
    }
)
    |(	otherlv_9='{' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0()); 
	    }
		lv_ownedUnrealizedVariables_10_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_10_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0()); 
	    }
		lv_ownedRealizedVariables_11_0=ruleRealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedRealizedVariables",
        		lv_ownedRealizedVariables_11_0, 
        		"RealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))(	otherlv_12=',' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getBottomPatternCSAccess().getCommaKeyword_1_2_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0()); 
	    }
		lv_ownedUnrealizedVariables_13_0=ruleUnrealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_13_0, 
        		"UnrealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0()); 
	    }
		lv_ownedRealizedVariables_14_0=ruleRealizedVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedRealizedVariables",
        		lv_ownedRealizedVariables_14_0, 
        		"RealizedVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))*	otherlv_15='}' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_1_3());
    }
)
    |(	otherlv_16='{' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedConstraints_17_0=rulePredicateOrAssignmentCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBottomPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedConstraints",
        		lv_ownedConstraints_17_0, 
        		"PredicateOrAssignmentCS");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_18='}' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_2_2());
    }
)
    |((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getBottomPatternCSAccess().getBottomPatternCSAction_3_0(),
            $current);
    }
)	otherlv_20='{' 
    {
    	newLeafNode(otherlv_20, grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_3_1());
    }
	otherlv_21='}' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_3_2());
    }
))
;





// Entry rule entryRuleGuardPatternCS
entryRuleGuardPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGuardPatternCSRule()); }
	 iv_ruleGuardPatternCS=ruleGuardPatternCS 
	 { $current=$iv_ruleGuardPatternCS.current; } 
	 EOF 
;

// Rule GuardPatternCS
ruleGuardPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='(' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0()); 
	    }
		lv_ownedUnrealizedVariables_1_0=ruleGuardVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_1_0, 
        		"GuardVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=',' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_0_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0()); 
	    }
		lv_ownedUnrealizedVariables_3_0=ruleGuardVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_3_0, 
        		"GuardVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4='|' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_0_4_0()); 
	    }
		lv_ownedPredicates_5_0=rulePredicateCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedPredicates",
        		lv_ownedPredicates_5_0, 
        		"PredicateCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_5());
    }
)
    |(	otherlv_7='(' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedUnrealizedVariables_8_0=ruleGuardVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_8_0, 
        		"GuardVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_9=',' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getGuardPatternCSAccess().getCommaKeyword_1_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0()); 
	    }
		lv_ownedUnrealizedVariables_10_0=ruleGuardVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedUnrealizedVariables",
        		lv_ownedUnrealizedVariables_10_0, 
        		"GuardVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_11=')' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_1_3());
    }
)
    |(	otherlv_12='(' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedPredicates_13_0=rulePredicateCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedPredicates",
        		lv_ownedPredicates_13_0, 
        		"PredicateCS");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_14=')' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_2_2());
    }
)
    |((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getGuardPatternCSAccess().getGuardPatternCSAction_3_0(),
            $current);
    }
)	otherlv_16='(' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_3_1());
    }
	otherlv_17=')' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_3_2());
    }
))
;





// Entry rule entryRuleGuardVariableCS
entryRuleGuardVariableCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGuardVariableCSRule()); }
	 iv_ruleGuardVariableCS=ruleGuardVariableCS 
	 { $current=$iv_ruleGuardVariableCS.current; } 
	 EOF 
;

// Rule GuardVariableCS
ruleGuardVariableCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getGuardVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardVariableCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGuardVariableCSAccess().getColonKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardVariableCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleImportCS
entryRuleImportCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getImportCSRule()); }
	 iv_ruleImportCS=ruleImportCS 
	 { $current=$iv_ruleImportCS.current; } 
	 EOF 
;

// Rule ImportCS
ruleImportCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='import' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
	    }
		lv_name_1_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImportCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0()); 
	    }
		lv_ownedPathName_3_0=ruleURIPathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImportCSRule());
	        }
       		set(
       			$current, 
       			"ownedPathName",
        		lv_ownedPathName_3_0, 
        		"URIPathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((
(
		lv_isAll_4_0=	'::' 
    {
        newLeafNode(lv_isAll_4_0, grammarAccess.getImportCSAccess().getIsAllColonColonKeyword_3_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getImportCSRule());
	        }
       		setWithLastConsumed($current, "isAll", true, "::");
	    }

)
)	otherlv_5='*' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1());
    }
)?	otherlv_6=';' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getImportCSAccess().getSemicolonKeyword_4());
    }
)
;







// Entry rule entryRuleParamDeclarationCS
entryRuleParamDeclarationCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getParamDeclarationCSRule()); }
	 iv_ruleParamDeclarationCS=ruleParamDeclarationCS 
	 { $current=$iv_ruleParamDeclarationCS.current; } 
	 EOF 
;

// Rule ParamDeclarationCS
ruleParamDeclarationCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getParamDeclarationCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getParamDeclarationCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRulePredicateCS
entryRulePredicateCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPredicateCSRule()); }
	 iv_rulePredicateCS=rulePredicateCS 
	 { $current=$iv_rulePredicateCS.current; } 
	 EOF 
;

// Rule PredicateCS
rulePredicateCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getPredicateCSAccess().getOwnedConditionExpCSParserRuleCall_0_0()); 
	    }
		lv_ownedCondition_0_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPredicateCSRule());
	        }
       		set(
       			$current, 
       			"ownedCondition",
        		lv_ownedCondition_0_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=';' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getPredicateCSAccess().getSemicolonKeyword_1());
    }
)
;





// Entry rule entryRulePredicateOrAssignmentCS
entryRulePredicateOrAssignmentCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPredicateOrAssignmentCSRule()); }
	 iv_rulePredicateOrAssignmentCS=rulePredicateOrAssignmentCS 
	 { $current=$iv_rulePredicateOrAssignmentCS.current; } 
	 EOF 
;

// Rule PredicateOrAssignmentCS
rulePredicateOrAssignmentCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_isDefault_0_0=	'default' 
    {
        newLeafNode(lv_isDefault_0_0, grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultDefaultKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPredicateOrAssignmentCSRule());
	        }
       		setWithLastConsumed($current, "isDefault", true, "default");
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedTargetExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedTarget_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPredicateOrAssignmentCSRule());
	        }
       		set(
       			$current, 
       			"ownedTarget",
        		lv_ownedTarget_1_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=':=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getPredicateOrAssignmentCSAccess().getColonEqualsSignKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedInitExpression_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPredicateOrAssignmentCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_4=';' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getPredicateOrAssignmentCSAccess().getSemicolonKeyword_3());
    }
)
;





// Entry rule entryRuleQueryCS
entryRuleQueryCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getQueryCSRule()); }
	 iv_ruleQueryCS=ruleQueryCS 
	 { $current=$iv_ruleQueryCS.current; } 
	 EOF 
;

// Rule QueryCS
ruleQueryCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='query' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getQueryCSAccess().getQueryKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); 
	    }
		lv_ownedPathName_1_0=ruleScopeNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQueryCSRule());
	        }
       		set(
       			$current, 
       			"ownedPathName",
        		lv_ownedPathName_1_0, 
        		"ScopeNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQueryCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_3());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_4_0_0()); 
	    }
		lv_ownedParameters_4_0=ruleParamDeclarationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQueryCSRule());
	        }
       		add(
       			$current, 
       			"ownedParameters",
        		lv_ownedParameters_4_0, 
        		"ParamDeclarationCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getQueryCSAccess().getCommaKeyword_4_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0()); 
	    }
		lv_ownedParameters_6_0=ruleParamDeclarationCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQueryCSRule());
	        }
       		add(
       			$current, 
       			"ownedParameters",
        		lv_ownedParameters_6_0, 
        		"ParamDeclarationCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_7=')' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_5());
    }
	otherlv_8=':' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getQueryCSAccess().getColonKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_7_0()); 
	    }
		lv_ownedType_9_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQueryCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_9_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_10=';' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_0());
    }

    |(	otherlv_11='{' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_8_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedExpressionExpCSParserRuleCall_8_1_1_0()); 
	    }
		lv_ownedExpression_12_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQueryCSRule());
	        }
       		set(
       			$current, 
       			"ownedExpression",
        		lv_ownedExpression_12_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_13='}' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getQueryCSAccess().getRightCurlyBracketKeyword_8_1_2());
    }
)))
;





// Entry rule entryRuleScopeNameCS
entryRuleScopeNameCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getScopeNameCSRule()); }
	 iv_ruleScopeNameCS=ruleScopeNameCS 
	 { $current=$iv_ruleScopeNameCS.current; } 
	 EOF 
;

// Rule ScopeNameCS
ruleScopeNameCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
	    }
		lv_ownedPathElements_0_0=ruleFirstPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
	        }
       		add(
       			$current, 
       			"ownedPathElements",
        		lv_ownedPathElements_0_0, 
        		"FirstPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='::' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedPathElements_2_0=ruleNextPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
	        }
       		add(
       			$current, 
       			"ownedPathElements",
        		lv_ownedPathElements_2_0, 
        		"NextPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='::' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
    }
)*)
;





// Entry rule entryRuleTransformationCS
entryRuleTransformationCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTransformationCSRule()); }
	 iv_ruleTransformationCS=ruleTransformationCS 
	 { $current=$iv_ruleTransformationCS.current; } 
	 EOF 
;

// Rule TransformationCS
ruleTransformationCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='transformation' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); 
	    }
		lv_ownedPathName_1_0=ruleScopeNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransformationCSRule());
	        }
       		set(
       			$current, 
       			"ownedPathName",
        		lv_ownedPathName_1_0, 
        		"ScopeNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleUnreservedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransformationCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"UnreservedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedDirectionsDirectionCSParserRuleCall_4_0_0()); 
	    }
		lv_ownedDirections_4_0=ruleDirectionCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransformationCSRule());
	        }
       		add(
       			$current, 
       			"ownedDirections",
        		lv_ownedDirections_4_0, 
        		"DirectionCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5=';' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1());
    }
)*	otherlv_6='}' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getTransformationCSAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleUnrealizedVariableCS
entryRuleUnrealizedVariableCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnrealizedVariableCSRule()); }
	 iv_ruleUnrealizedVariableCS=ruleUnrealizedVariableCS 
	 { $current=$iv_ruleUnrealizedVariableCS.current; } 
	 EOF 
;

// Rule UnrealizedVariableCS
ruleUnrealizedVariableCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnrealizedVariableCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnrealizedVariableCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_3=':=' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getUnrealizedVariableCSAccess().getColonEqualsSignKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getUnrealizedVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedInitExpression_4_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnrealizedVariableCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_4_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleRealizedVariableCS
entryRuleRealizedVariableCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRealizedVariableCSRule()); }
	 iv_ruleRealizedVariableCS=ruleRealizedVariableCS 
	 { $current=$iv_ruleRealizedVariableCS.current; } 
	 EOF 
;

// Rule RealizedVariableCS
ruleRealizedVariableCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='realize' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRealizedVariableCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); 
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRealizedVariableCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_3_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;







// Entry rule entryRuleUnrestrictedName
entryRuleUnrestrictedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnrestrictedNameRule()); } 
	 iv_ruleUnrestrictedName=ruleUnrestrictedName 
	 { $current=$iv_ruleUnrestrictedName.current.getText(); }  
	 EOF 
;

// Rule UnrestrictedName
ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); 
    }
    this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName    {
		$current.merge(this_EssentialOCLUnrestrictedName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
	kw='check' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); 
    }

    |
	kw='enforce' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); 
    }

    |
	kw='import' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); 
    }

    |
	kw='imports' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); 
    }

    |
	kw='library' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); 
    }

    |
	kw='map' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); 
    }

    |
	kw='query' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); 
    }

    |
	kw='realize' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); 
    }

    |
	kw='refines' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); 
    }

    |
	kw='transformation' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); 
    }

    |
	kw='uses' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnrestrictedNameAccess().getUsesKeyword_11()); 
    }
)
    ;









// Entry rule entryRuleEssentialOCLUnaryOperatorName
entryRuleEssentialOCLUnaryOperatorName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); } 
	 iv_ruleEssentialOCLUnaryOperatorName=ruleEssentialOCLUnaryOperatorName 
	 { $current=$iv_ruleEssentialOCLUnaryOperatorName.current.getText(); }  
	 EOF 
;

// Rule EssentialOCLUnaryOperatorName
ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); 
    }

    |
	kw='not' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleEssentialOCLInfixOperatorName
entryRuleEssentialOCLInfixOperatorName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorNameRule()); } 
	 iv_ruleEssentialOCLInfixOperatorName=ruleEssentialOCLInfixOperatorName 
	 { $current=$iv_ruleEssentialOCLInfixOperatorName.current.getText(); }  
	 EOF 
;

// Rule EssentialOCLInfixOperatorName
ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); 
    }

    |
	kw='/' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); 
    }

    |
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); 
    }

    |
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); 
    }

    |
	kw='>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); 
    }

    |
	kw='<' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); 
    }

    |
	kw='>=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); 
    }

    |
	kw='<=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); 
    }

    |
	kw='=' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); 
    }

    |
	kw='<>' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); 
    }

    |
	kw='and' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); 
    }

    |
	kw='or' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11()); 
    }

    |
	kw='xor' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12()); 
    }

    |
	kw='implies' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_13()); 
    }
)
    ;





// Entry rule entryRuleEssentialOCLNavigationOperatorName
entryRuleEssentialOCLNavigationOperatorName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); } 
	 iv_ruleEssentialOCLNavigationOperatorName=ruleEssentialOCLNavigationOperatorName 
	 { $current=$iv_ruleEssentialOCLNavigationOperatorName.current.getText(); }  
	 EOF 
;

// Rule EssentialOCLNavigationOperatorName
ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); 
    }

    |
	kw='->' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
    }

    |
	kw='?.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); 
    }

    |
	kw='?->' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); 
    }
)
    ;





// Entry rule entryRuleBinaryOperatorName
entryRuleBinaryOperatorName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getBinaryOperatorNameRule()); } 
	 iv_ruleBinaryOperatorName=ruleBinaryOperatorName 
	 { $current=$iv_ruleBinaryOperatorName.current.getText(); }  
	 EOF 
;

// Rule BinaryOperatorName
ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); 
    }
    this_InfixOperatorName_0=ruleInfixOperatorName    {
		$current.merge(this_InfixOperatorName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); 
    }
    this_NavigationOperatorName_1=ruleNavigationOperatorName    {
		$current.merge(this_NavigationOperatorName_1);
    }

    { 
        afterParserOrEnumRuleCall();
    }
)
    ;





// Entry rule entryRuleInfixOperatorName
entryRuleInfixOperatorName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getInfixOperatorNameRule()); } 
	 iv_ruleInfixOperatorName=ruleInfixOperatorName 
	 { $current=$iv_ruleInfixOperatorName.current.getText(); }  
	 EOF 
;

// Rule InfixOperatorName
ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); 
    }
    this_EssentialOCLInfixOperatorName_0=ruleEssentialOCLInfixOperatorName    {
		$current.merge(this_EssentialOCLInfixOperatorName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleNavigationOperatorName
entryRuleNavigationOperatorName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getNavigationOperatorNameRule()); } 
	 iv_ruleNavigationOperatorName=ruleNavigationOperatorName 
	 { $current=$iv_ruleNavigationOperatorName.current.getText(); }  
	 EOF 
;

// Rule NavigationOperatorName
ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); 
    }
    this_EssentialOCLNavigationOperatorName_0=ruleEssentialOCLNavigationOperatorName    {
		$current.merge(this_EssentialOCLNavigationOperatorName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleUnaryOperatorName
entryRuleUnaryOperatorName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnaryOperatorNameRule()); } 
	 iv_ruleUnaryOperatorName=ruleUnaryOperatorName 
	 { $current=$iv_ruleUnaryOperatorName.current.getText(); }  
	 EOF 
;

// Rule UnaryOperatorName
ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); 
    }
    this_EssentialOCLUnaryOperatorName_0=ruleEssentialOCLUnaryOperatorName    {
		$current.merge(this_EssentialOCLUnaryOperatorName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleEssentialOCLUnrestrictedName
entryRuleEssentialOCLUnrestrictedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); } 
	 iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName 
	 { $current=$iv_ruleEssentialOCLUnrestrictedName.current.getText(); }  
	 EOF 
;

// Rule EssentialOCLUnrestrictedName
ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
    }
    this_Identifier_0=ruleIdentifier    {
		$current.merge(this_Identifier_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleEssentialOCLUnreservedName
entryRuleEssentialOCLUnreservedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); } 
	 iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName 
	 { $current=$iv_ruleEssentialOCLUnreservedName.current.getText(); }  
	 EOF 
;

// Rule EssentialOCLUnreservedName
ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
    }
    this_UnrestrictedName_0=ruleUnrestrictedName    {
		$current.merge(this_UnrestrictedName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
    }
    this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier    {
		$current.merge(this_CollectionTypeIdentifier_1);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
    }
    this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier    {
		$current.merge(this_PrimitiveTypeIdentifier_2);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    |
	kw='Map' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); 
    }

    |
	kw='Tuple' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); 
    }
)
    ;





// Entry rule entryRuleUnreservedName
entryRuleUnreservedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnreservedNameRule()); } 
	 iv_ruleUnreservedName=ruleUnreservedName 
	 { $current=$iv_ruleUnreservedName.current.getText(); }  
	 EOF 
;

// Rule UnreservedName
ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
    }
    this_EssentialOCLUnreservedName_0=ruleEssentialOCLUnreservedName    {
		$current.merge(this_EssentialOCLUnreservedName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleURIPathNameCS
entryRuleURIPathNameCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getURIPathNameCSRule()); }
	 iv_ruleURIPathNameCS=ruleURIPathNameCS 
	 { $current=$iv_ruleURIPathNameCS.current; } 
	 EOF 
;

// Rule URIPathNameCS
ruleURIPathNameCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0()); 
	    }
		lv_ownedPathElements_0_0=ruleURIFirstPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
	        }
       		add(
       			$current, 
       			"ownedPathElements",
        		lv_ownedPathElements_0_0, 
        		"URIFirstPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='::' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedPathElements_2_0=ruleNextPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
	        }
       		add(
       			$current, 
       			"ownedPathElements",
        		lv_ownedPathElements_2_0, 
        		"NextPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleURIFirstPathElementCS
entryRuleURIFirstPathElementCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); }
	 iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS 
	 { $current=$iv_ruleURIFirstPathElementCS.current; } 
	 EOF 
;

// Rule URIFirstPathElementCS
ruleURIFirstPathElementCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)
    |((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0(),
            $current);
    }
)(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); 
	    }
		ruleURI		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRulePrimitiveTypeIdentifier
entryRulePrimitiveTypeIdentifier returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); } 
	 iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier 
	 { $current=$iv_rulePrimitiveTypeIdentifier.current.getText(); }  
	 EOF 
;

// Rule PrimitiveTypeIdentifier
rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='Boolean' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
    }

    |
	kw='Integer' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
    }

    |
	kw='Real' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
    }

    |
	kw='String' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
    }

    |
	kw='UnlimitedNatural' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
    }

    |
	kw='OclAny' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
    }

    |
	kw='OclInvalid' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
    }

    |
	kw='OclVoid' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
    }
)
    ;





// Entry rule entryRulePrimitiveTypeCS
entryRulePrimitiveTypeCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); }
	 iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS 
	 { $current=$iv_rulePrimitiveTypeCS.current; } 
	 EOF 
;

// Rule PrimitiveTypeCS
rulePrimitiveTypeCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
	    }
		lv_name_0_0=rulePrimitiveTypeIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrimitiveTypeCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"PrimitiveTypeIdentifier");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleCollectionTypeIdentifier
entryRuleCollectionTypeIdentifier returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); } 
	 iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier 
	 { $current=$iv_ruleCollectionTypeIdentifier.current.getText(); }  
	 EOF 
;

// Rule CollectionTypeIdentifier
ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='Set' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
    }

    |
	kw='Bag' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
    }

    |
	kw='Sequence' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
    }

    |
	kw='Collection' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
    }

    |
	kw='OrderedSet' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
    }
)
    ;





// Entry rule entryRuleCollectionTypeCS
entryRuleCollectionTypeCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCollectionTypeCSRule()); }
	 iv_ruleCollectionTypeCS=ruleCollectionTypeCS 
	 { $current=$iv_ruleCollectionTypeCS.current; } 
	 EOF 
;

// Rule CollectionTypeCS
ruleCollectionTypeCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleCollectionTypeIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"CollectionTypeIdentifier");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2());
    }
)?)
;





// Entry rule entryRuleMapTypeCS
entryRuleMapTypeCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMapTypeCSRule()); }
	 iv_ruleMapTypeCS=ruleMapTypeCS 
	 { $current=$iv_ruleMapTypeCS.current; } 
	 EOF 
;

// Rule MapTypeCS
ruleMapTypeCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=	'Map' 
    {
        newLeafNode(lv_name_0_0, grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMapTypeCSRule());
	        }
       		setWithLastConsumed($current, "name", lv_name_0_0, "Map");
	    }

)
)(	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedKeyType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
	        }
       		set(
       			$current, 
       			"ownedKeyType",
        		lv_ownedKeyType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); 
	    }
		lv_ownedValueType_4_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
	        }
       		set(
       			$current, 
       			"ownedValueType",
        		lv_ownedValueType_4_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4());
    }
)?)
;





// Entry rule entryRuleTupleTypeCS
entryRuleTupleTypeCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTupleTypeCSRule()); }
	 iv_ruleTupleTypeCS=ruleTupleTypeCS 
	 { $current=$iv_ruleTupleTypeCS.current; } 
	 EOF 
;

// Rule TupleTypeCS
ruleTupleTypeCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=	'Tuple' 
    {
        newLeafNode(lv_name_0_0, grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTupleTypeCSRule());
	        }
       		setWithLastConsumed($current, "name", lv_name_0_0, "Tuple");
	    }

)
)(	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
	    }
		lv_ownedParts_2_0=ruleTuplePartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_2_0, 
        		"TuplePartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
	    }
		lv_ownedParts_4_0=ruleTuplePartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_4_0, 
        		"TuplePartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());
    }
)?)
;





// Entry rule entryRuleTuplePartCS
entryRuleTuplePartCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTuplePartCSRule()); }
	 iv_ruleTuplePartCS=ruleTuplePartCS 
	 { $current=$iv_ruleTuplePartCS.current; } 
	 EOF 
;

// Rule TuplePartCS
ruleTuplePartCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleCollectionLiteralExpCS
entryRuleCollectionLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); }
	 iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS 
	 { $current=$iv_ruleCollectionLiteralExpCS.current; } 
	 EOF 
;

// Rule CollectionLiteralExpCS
ruleCollectionLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
	    }
		lv_ownedType_0_0=ruleCollectionTypeCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_0_0, 
        		"CollectionTypeCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedParts_2_0=ruleCollectionLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_2_0, 
        		"CollectionLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedParts_4_0=ruleCollectionLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_4_0, 
        		"CollectionLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleCollectionLiteralPartCS
entryRuleCollectionLiteralPartCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); }
	 iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS 
	 { $current=$iv_ruleCollectionLiteralPartCS.current; } 
	 EOF 
;

// Rule CollectionLiteralPartCS
ruleCollectionLiteralPartCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); 
	    }
		lv_ownedExpression_0_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedExpression",
        		lv_ownedExpression_0_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='..' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); 
	    }
		lv_ownedLastExpression_2_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedLastExpression",
        		lv_ownedLastExpression_2_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedExpression_3_0=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedExpression",
        		lv_ownedExpression_3_0, 
        		"PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleCollectionPatternCS
entryRuleCollectionPatternCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCollectionPatternCSRule()); }
	 iv_ruleCollectionPatternCS=ruleCollectionPatternCS 
	 { $current=$iv_ruleCollectionPatternCS.current; } 
	 EOF 
;

// Rule CollectionPatternCS
ruleCollectionPatternCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
	    }
		lv_ownedType_0_0=ruleCollectionTypeCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_0_0, 
        		"CollectionTypeCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedParts_2_0=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_2_0, 
        		"PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedParts_4_0=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_4_0, 
        		"PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*(	otherlv_5='++' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); 
	    }
		lv_restVariableName_6_0=ruleIdentifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
	        }
       		set(
       			$current, 
       			"restVariableName",
        		lv_restVariableName_6_0, 
        		"Identifier");
	        afterParserOrEnumRuleCall();
	    }

)
)))?	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleShadowPartCS
entryRuleShadowPartCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getShadowPartCSRule()); }
	 iv_ruleShadowPartCS=ruleShadowPartCS 
	 { $current=$iv_ruleShadowPartCS.current; } 
	 EOF 
;

// Rule ShadowPartCS
ruleShadowPartCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getShadowPartCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_1());
    }
(
(
(
		{ 
	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedInitExpression_2_1=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_2_1, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_2_0_1()); 
	    }
		lv_ownedInitExpression_2_2=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_2_2, 
        		"PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)

)
))
;





// Entry rule entryRulePatternExpCS
entryRulePatternExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPatternExpCSRule()); }
	 iv_rulePatternExpCS=rulePatternExpCS 
	 { $current=$iv_rulePatternExpCS.current; } 
	 EOF 
;

// Rule PatternExpCS
rulePatternExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_patternVariableName_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
	        }
       		set(
       			$current, 
       			"patternVariableName",
        		lv_patternVariableName_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); 
	    }
		lv_ownedPatternType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedPatternType",
        		lv_ownedPatternType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLambdaLiteralExpCS
entryRuleLambdaLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); }
	 iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS 
	 { $current=$iv_ruleLambdaLiteralExpCS.current; } 
	 EOF 
;

// Rule LambdaLiteralExpCS
ruleLambdaLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Lambda' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); 
	    }
		lv_ownedExpressionCS_2_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedExpressionCS",
        		lv_ownedExpressionCS_2_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='}' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleMapLiteralExpCS
entryRuleMapLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); }
	 iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS 
	 { $current=$iv_ruleMapLiteralExpCS.current; } 
	 EOF 
;

// Rule MapLiteralExpCS
ruleMapLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
	    }
		lv_ownedType_0_0=ruleMapTypeCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_0_0, 
        		"MapTypeCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedParts_2_0=ruleMapLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_2_0, 
        		"MapLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedParts_4_0=ruleMapLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_4_0, 
        		"MapLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleMapLiteralPartCS
entryRuleMapLiteralPartCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); }
	 iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS 
	 { $current=$iv_ruleMapLiteralPartCS.current; } 
	 EOF 
;

// Rule MapLiteralPartCS
ruleMapLiteralPartCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
	    }
		lv_ownedKey_0_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedKey",
        		lv_ownedKey_0_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_1='<-' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
	    }
		lv_ownedValue_2_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedValue",
        		lv_ownedValue_2_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRulePrimitiveLiteralExpCS
entryRulePrimitiveLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); }
	 iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS 
	 { $current=$iv_rulePrimitiveLiteralExpCS.current; } 
	 EOF 
;

// Rule PrimitiveLiteralExpCS
rulePrimitiveLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
    }
    this_NumberLiteralExpCS_0=ruleNumberLiteralExpCS
    { 
        $current = $this_NumberLiteralExpCS_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
    }
    this_StringLiteralExpCS_1=ruleStringLiteralExpCS
    { 
        $current = $this_StringLiteralExpCS_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
    }
    this_BooleanLiteralExpCS_2=ruleBooleanLiteralExpCS
    { 
        $current = $this_BooleanLiteralExpCS_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
    }
    this_UnlimitedNaturalLiteralExpCS_3=ruleUnlimitedNaturalLiteralExpCS
    { 
        $current = $this_UnlimitedNaturalLiteralExpCS_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
    }
    this_InvalidLiteralExpCS_4=ruleInvalidLiteralExpCS
    { 
        $current = $this_InvalidLiteralExpCS_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
    }
    this_NullLiteralExpCS_5=ruleNullLiteralExpCS
    { 
        $current = $this_NullLiteralExpCS_5.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTupleLiteralExpCS
entryRuleTupleLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); }
	 iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS 
	 { $current=$iv_ruleTupleLiteralExpCS.current; } 
	 EOF 
;

// Rule TupleLiteralExpCS
ruleTupleLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Tuple' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
	    }
		lv_ownedParts_2_0=ruleTupleLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_2_0, 
        		"TupleLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
	    }
		lv_ownedParts_4_0=ruleTupleLiteralPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_4_0, 
        		"TupleLiteralPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleTupleLiteralPartCS
entryRuleTupleLiteralPartCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); }
	 iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS 
	 { $current=$iv_ruleTupleLiteralPartCS.current; } 
	 EOF 
;

// Rule TupleLiteralPartCS
ruleTupleLiteralPartCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_3='=' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); 
	    }
		lv_ownedInitExpression_4_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_4_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleNumberLiteralExpCS
entryRuleNumberLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); }
	 iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS 
	 { $current=$iv_ruleNumberLiteralExpCS.current; } 
	 EOF 
;

// Rule NumberLiteralExpCS
ruleNumberLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); 
	    }
		lv_symbol_0_0=ruleNUMBER_LITERAL		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
	        }
       		set(
       			$current, 
       			"symbol",
        		lv_symbol_0_0, 
        		"NUMBER_LITERAL");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleStringLiteralExpCS
entryRuleStringLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); }
	 iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS 
	 { $current=$iv_ruleStringLiteralExpCS.current; } 
	 EOF 
;

// Rule StringLiteralExpCS
ruleStringLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
	    }
		lv_segments_0_0=ruleStringLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
	        }
       		add(
       			$current, 
       			"segments",
        		lv_segments_0_0, 
        		"StringLiteral");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleBooleanLiteralExpCS
entryRuleBooleanLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); }
	 iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS 
	 { $current=$iv_ruleBooleanLiteralExpCS.current; } 
	 EOF 
;

// Rule BooleanLiteralExpCS
ruleBooleanLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_symbol_0_0=	'true' 
    {
        newLeafNode(lv_symbol_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
	        }
       		setWithLastConsumed($current, "symbol", lv_symbol_0_0, "true");
	    }

)
)
    |(
(
		lv_symbol_1_0=	'false' 
    {
        newLeafNode(lv_symbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
	        }
       		setWithLastConsumed($current, "symbol", lv_symbol_1_0, "false");
	    }

)
))
;





// Entry rule entryRuleUnlimitedNaturalLiteralExpCS
entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); }
	 iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS 
	 { $current=$iv_ruleUnlimitedNaturalLiteralExpCS.current; } 
	 EOF 
;

// Rule UnlimitedNaturalLiteralExpCS
ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(),
            $current);
    }
)	otherlv_1='*' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1());
    }
)
;





// Entry rule entryRuleInvalidLiteralExpCS
entryRuleInvalidLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); }
	 iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS 
	 { $current=$iv_ruleInvalidLiteralExpCS.current; } 
	 EOF 
;

// Rule InvalidLiteralExpCS
ruleInvalidLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(),
            $current);
    }
)	otherlv_1='invalid' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1());
    }
)
;





// Entry rule entryRuleNullLiteralExpCS
entryRuleNullLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); }
	 iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS 
	 { $current=$iv_ruleNullLiteralExpCS.current; } 
	 EOF 
;

// Rule NullLiteralExpCS
ruleNullLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(),
            $current);
    }
)	otherlv_1='null' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1());
    }
)
;





// Entry rule entryRuleTypeLiteralCS
entryRuleTypeLiteralCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeLiteralCSRule()); }
	 iv_ruleTypeLiteralCS=ruleTypeLiteralCS 
	 { $current=$iv_ruleTypeLiteralCS.current; } 
	 EOF 
;

// Rule TypeLiteralCS
ruleTypeLiteralCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
    }
    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS
    { 
        $current = $this_PrimitiveTypeCS_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
    }
    this_CollectionTypeCS_1=ruleCollectionTypeCS
    { 
        $current = $this_CollectionTypeCS_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); 
    }
    this_MapTypeCS_2=ruleMapTypeCS
    { 
        $current = $this_MapTypeCS_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); 
    }
    this_TupleTypeCS_3=ruleTupleTypeCS
    { 
        $current = $this_TupleTypeCS_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTypeLiteralWithMultiplicityCS
entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); }
	 iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS 
	 { $current=$iv_ruleTypeLiteralWithMultiplicityCS.current; } 
	 EOF 
;

// Rule TypeLiteralWithMultiplicityCS
ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
    }
    this_TypeLiteralCS_0=ruleTypeLiteralCS
    { 
        $current = $this_TypeLiteralCS_0.current; 
        afterParserOrEnumRuleCall();
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
	    }
		lv_ownedMultiplicity_1_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
	        }
       		set(
       			$current, 
       			"ownedMultiplicity",
        		lv_ownedMultiplicity_1_0, 
        		"MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleTypeLiteralExpCS
entryRuleTypeLiteralExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); }
	 iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS 
	 { $current=$iv_ruleTypeLiteralExpCS.current; } 
	 EOF 
;

// Rule TypeLiteralExpCS
ruleTypeLiteralExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
	    }
		lv_ownedType_0_0=ruleTypeLiteralWithMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeLiteralExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_0_0, 
        		"TypeLiteralWithMultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleTypeNameExpCS
entryRuleTypeNameExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeNameExpCSRule()); }
	 iv_ruleTypeNameExpCS=ruleTypeNameExpCS 
	 { $current=$iv_ruleTypeNameExpCS.current; } 
	 EOF 
;

// Rule TypeNameExpCS
ruleTypeNameExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
	    }
		lv_ownedPathName_0_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedPathName",
        		lv_ownedPathName_0_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((
(
		{ 
	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
	    }
		lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedCurlyBracketedClause",
        		lv_ownedCurlyBracketedClause_1_0, 
        		"CurlyBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
	    }
		lv_ownedPatternGuard_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedPatternGuard",
        		lv_ownedPatternGuard_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='}' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
    }
)?)?)
;





// Entry rule entryRuleTypeExpCS
entryRuleTypeExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeExpCSRule()); }
	 iv_ruleTypeExpCS=ruleTypeExpCS 
	 { $current=$iv_ruleTypeExpCS.current; } 
	 EOF 
;

// Rule TypeExpCS
ruleTypeExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
    }
    this_TypeNameExpCS_0=ruleTypeNameExpCS
    { 
        $current = $this_TypeNameExpCS_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
    }
    this_TypeLiteralCS_1=ruleTypeLiteralCS
    { 
        $current = $this_TypeLiteralCS_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2()); 
    }
    this_CollectionPatternCS_2=ruleCollectionPatternCS
    { 
        $current = $this_CollectionPatternCS_2.current; 
        afterParserOrEnumRuleCall();
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
	    }
		lv_ownedMultiplicity_3_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedMultiplicity",
        		lv_ownedMultiplicity_3_0, 
        		"MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleExpCS
entryRuleExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExpCSRule()); }
	 iv_ruleExpCS=ruleExpCS 
	 { $current=$iv_ruleExpCS.current; } 
	 EOF 
;

// Rule ExpCS
ruleExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
    }
    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS
    { 
        $current = $this_PrefixedPrimaryExpCS_0.current; 
        afterParserOrEnumRuleCall();
    }
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
	    }
		lv_name_2_0=ruleBinaryOperatorName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExpCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"BinaryOperatorName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
	    }
		lv_ownedRight_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedRight",
        		lv_ownedRight_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); 
    }
    this_PrefixedLetExpCS_4=rulePrefixedLetExpCS
    { 
        $current = $this_PrefixedLetExpCS_4.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRulePrefixedLetExpCS
entryRulePrefixedLetExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); }
	 iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS 
	 { $current=$iv_rulePrefixedLetExpCS.current; } 
	 EOF 
;

// Rule PrefixedLetExpCS
rulePrefixedLetExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
	    }
		lv_name_1_0=ruleUnaryOperatorName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"UnaryOperatorName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); 
	    }
		lv_ownedRight_2_0=rulePrefixedLetExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedRight",
        		lv_ownedRight_2_0, 
        		"PrefixedLetExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); 
    }
    this_LetExpCS_3=ruleLetExpCS
    { 
        $current = $this_LetExpCS_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRulePrefixedPrimaryExpCS
entryRulePrefixedPrimaryExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); }
	 iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS 
	 { $current=$iv_rulePrefixedPrimaryExpCS.current; } 
	 EOF 
;

// Rule PrefixedPrimaryExpCS
rulePrefixedPrimaryExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
	    }
		lv_name_1_0=ruleUnaryOperatorName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"UnaryOperatorName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); 
	    }
		lv_ownedRight_2_0=rulePrefixedPrimaryExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedRight",
        		lv_ownedRight_2_0, 
        		"PrefixedPrimaryExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
    }
    this_PrimaryExpCS_3=rulePrimaryExpCS
    { 
        $current = $this_PrimaryExpCS_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRulePrimaryExpCS
entryRulePrimaryExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrimaryExpCSRule()); }
	 iv_rulePrimaryExpCS=rulePrimaryExpCS 
	 { $current=$iv_rulePrimaryExpCS.current; } 
	 EOF 
;

// Rule PrimaryExpCS
rulePrimaryExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
    }
    this_NestedExpCS_0=ruleNestedExpCS
    { 
        $current = $this_NestedExpCS_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
    }
    this_IfExpCS_1=ruleIfExpCS
    { 
        $current = $this_IfExpCS_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
    }
    this_SelfExpCS_2=ruleSelfExpCS
    { 
        $current = $this_SelfExpCS_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
    }
    this_PrimitiveLiteralExpCS_3=rulePrimitiveLiteralExpCS
    { 
        $current = $this_PrimitiveLiteralExpCS_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
    }
    this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS
    { 
        $current = $this_TupleLiteralExpCS_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); 
    }
    this_MapLiteralExpCS_5=ruleMapLiteralExpCS
    { 
        $current = $this_MapLiteralExpCS_5.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); 
    }
    this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS
    { 
        $current = $this_CollectionLiteralExpCS_6.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); 
    }
    this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS
    { 
        $current = $this_LambdaLiteralExpCS_7.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); 
    }
    this_TypeLiteralExpCS_8=ruleTypeLiteralExpCS
    { 
        $current = $this_TypeLiteralExpCS_8.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); 
    }
    this_NameExpCS_9=ruleNameExpCS
    { 
        $current = $this_NameExpCS_9.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleNameExpCS
entryRuleNameExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNameExpCSRule()); }
	 iv_ruleNameExpCS=ruleNameExpCS 
	 { $current=$iv_ruleNameExpCS.current; } 
	 EOF 
;

// Rule NameExpCS
ruleNameExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
	    }
		lv_ownedPathName_0_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedPathName",
        		lv_ownedPathName_0_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
	    }
		lv_ownedSquareBracketedClauses_1_0=ruleSquareBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedSquareBracketedClauses",
        		lv_ownedSquareBracketedClauses_1_0, 
        		"SquareBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
	    }
		lv_ownedRoundBracketedClause_2_0=ruleRoundBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedRoundBracketedClause",
        		lv_ownedRoundBracketedClause_2_0, 
        		"RoundBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
	    }
		lv_ownedCurlyBracketedClause_3_0=ruleCurlyBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNameExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedCurlyBracketedClause",
        		lv_ownedCurlyBracketedClause_3_0, 
        		"CurlyBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?((
(
		lv_isPre_4_0=	'@' 
    {
        newLeafNode(lv_isPre_4_0, grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNameExpCSRule());
	        }
       		setWithLastConsumed($current, "isPre", true, "@");
	    }

)
)	otherlv_5='pre' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getNameExpCSAccess().getPreKeyword_4_1());
    }
)?)
;





// Entry rule entryRuleCurlyBracketedClauseCS
entryRuleCurlyBracketedClauseCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); }
	 iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS 
	 { $current=$iv_ruleCurlyBracketedClauseCS.current; } 
	 EOF 
;

// Rule CurlyBracketedClauseCS
ruleCurlyBracketedClauseCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0(),
            $current);
    }
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
    }
(((
(
		{ 
	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0_0()); 
	    }
		lv_ownedParts_2_0=ruleShadowPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_2_0, 
        		"ShadowPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_0_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_1_1_0()); 
	    }
		lv_ownedParts_4_0=ruleShadowPartCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedParts",
        		lv_ownedParts_4_0, 
        		"ShadowPartCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_1_0()); 
	    }
		lv_value_5_0=ruleStringLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_5_0, 
        		"StringLiteral");
	        afterParserOrEnumRuleCall();
	    }

)
))	otherlv_6='}' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleRoundBracketedClauseCS
entryRuleRoundBracketedClauseCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); }
	 iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS 
	 { $current=$iv_ruleRoundBracketedClauseCS.current; } 
	 EOF 
;

// Rule RoundBracketedClauseCS
ruleRoundBracketedClauseCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0(),
            $current);
    }
)	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
	    }
		lv_ownedArguments_2_0=ruleNavigatingArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedArguments",
        		lv_ownedArguments_2_0, 
        		"NavigatingArgCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedArguments_3_0=ruleNavigatingCommaArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedArguments",
        		lv_ownedArguments_3_0, 
        		"NavigatingCommaArgCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*((
(
		{ 
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
	    }
		lv_ownedArguments_4_0=ruleNavigatingSemiArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedArguments",
        		lv_ownedArguments_4_0, 
        		"NavigatingSemiArgCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
	    }
		lv_ownedArguments_5_0=ruleNavigatingCommaArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedArguments",
        		lv_ownedArguments_5_0, 
        		"NavigatingCommaArgCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?((
(
		{ 
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
	    }
		lv_ownedArguments_6_0=ruleNavigatingBarArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedArguments",
        		lv_ownedArguments_6_0, 
        		"NavigatingBarArgCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
	    }
		lv_ownedArguments_7_0=ruleNavigatingCommaArgCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedArguments",
        		lv_ownedArguments_7_0, 
        		"NavigatingCommaArgCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*)*)?	otherlv_8=')' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3());
    }
)
;





// Entry rule entryRuleSquareBracketedClauseCS
entryRuleSquareBracketedClauseCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); }
	 iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS 
	 { $current=$iv_ruleSquareBracketedClauseCS.current; } 
	 EOF 
;

// Rule SquareBracketedClauseCS
ruleSquareBracketedClauseCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedTerms_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedTerms",
        		lv_ownedTerms_1_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=',' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedTerms_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
	        }
       		add(
       			$current, 
       			"ownedTerms",
        		lv_ownedTerms_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4=']' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleNavigatingArgCS
entryRuleNavigatingArgCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNavigatingArgCSRule()); }
	 iv_ruleNavigatingArgCS=ruleNavigatingArgCS 
	 { $current=$iv_ruleNavigatingArgCS.current; } 
	 EOF 
;

// Rule NavigatingArgCS
ruleNavigatingArgCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
	    }
		lv_ownedNameExpression_0_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedNameExpression",
        		lv_ownedNameExpression_0_0, 
        		"NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); 
	    }
		lv_ownedType_2_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_2_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='=' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); 
	    }
		lv_ownedInitExpression_4_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_4_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |(	otherlv_5='in' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); 
	    }
		lv_ownedInitExpression_6_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_6_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))?)
    |(	otherlv_7=':' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedType_8_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_8_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRuleNavigatingBarArgCS
entryRuleNavigatingBarArgCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); }
	 iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS 
	 { $current=$iv_ruleNavigatingBarArgCS.current; } 
	 EOF 
;

// Rule NavigatingBarArgCS
ruleNavigatingBarArgCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_prefix_0_0=	'|' 
    {
        newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		setWithLastConsumed($current, "prefix", lv_prefix_0_0, "|");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedNameExpression",
        		lv_ownedNameExpression_1_0, 
        		"NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_3_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='=' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)?)
;





// Entry rule entryRuleNavigatingCommaArgCS
entryRuleNavigatingCommaArgCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); }
	 iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS 
	 { $current=$iv_ruleNavigatingCommaArgCS.current; } 
	 EOF 
;

// Rule NavigatingCommaArgCS
ruleNavigatingCommaArgCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_prefix_0_0=	',' 
    {
        newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		setWithLastConsumed($current, "prefix", lv_prefix_0_0, ",");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedNameExpression",
        		lv_ownedNameExpression_1_0, 
        		"NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)((	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); 
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_3_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='=' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); 
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
    |(	otherlv_6='in' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); 
	    }
		lv_ownedInitExpression_7_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_7_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)))?)
;





// Entry rule entryRuleNavigatingSemiArgCS
entryRuleNavigatingSemiArgCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); }
	 iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS 
	 { $current=$iv_ruleNavigatingSemiArgCS.current; } 
	 EOF 
;

// Rule NavigatingSemiArgCS
ruleNavigatingSemiArgCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_prefix_0_0=	';' 
    {
        newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		setWithLastConsumed($current, "prefix", lv_prefix_0_0, ";");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedNameExpression",
        		lv_ownedNameExpression_1_0, 
        		"NavigatingArgExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_3_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='=' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)?)
;





// Entry rule entryRuleNavigatingArgExpCS
entryRuleNavigatingArgExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); }
	 iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS 
	 { $current=$iv_ruleNavigatingArgExpCS.current; } 
	 EOF 
;

// Rule NavigatingArgExpCS
ruleNavigatingArgExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
    }
    this_ExpCS_0=ruleExpCS
    { 
        $current = $this_ExpCS_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleIfExpCS
entryRuleIfExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIfExpCSRule()); }
	 iv_ruleIfExpCS=ruleIfExpCS 
	 { $current=$iv_ruleIfExpCS.current; } 
	 EOF 
;

// Rule IfExpCS
ruleIfExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='if' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
    }
(
(
(
		{ 
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
	    }
		lv_ownedCondition_1_1=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedCondition",
        		lv_ownedCondition_1_1, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

    |		{ 
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
	    }
		lv_ownedCondition_1_2=rulePatternExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedCondition",
        		lv_ownedCondition_1_2, 
        		"PatternExpCS");
	        afterParserOrEnumRuleCall();
	    }

)

)
)	otherlv_2='then' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
	    }
		lv_ownedThenExpression_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedThenExpression",
        		lv_ownedThenExpression_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
	    }
		lv_ownedIfThenExpressions_4_0=ruleElseIfThenExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedIfThenExpressions",
        		lv_ownedIfThenExpressions_4_0, 
        		"ElseIfThenExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5='else' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
	    }
		lv_ownedElseExpression_6_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedElseExpression",
        		lv_ownedElseExpression_6_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='endif' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getIfExpCSAccess().getEndifKeyword_7());
    }
)
;





// Entry rule entryRuleElseIfThenExpCS
entryRuleElseIfThenExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); }
	 iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS 
	 { $current=$iv_ruleElseIfThenExpCS.current; } 
	 EOF 
;

// Rule ElseIfThenExpCS
ruleElseIfThenExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='elseif' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedCondition_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedCondition",
        		lv_ownedCondition_1_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='then' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
	    }
		lv_ownedThenExpression_3_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedThenExpression",
        		lv_ownedThenExpression_3_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLetExpCS
entryRuleLetExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLetExpCSRule()); }
	 iv_ruleLetExpCS=ruleLetExpCS 
	 { $current=$iv_ruleLetExpCS.current; } 
	 EOF 
;

// Rule LetExpCS
ruleLetExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='let' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
	    }
		lv_ownedVariables_1_0=ruleLetVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedVariables",
        		lv_ownedVariables_1_0, 
        		"LetVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2=',' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedVariables_3_0=ruleLetVariableCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetExpCSRule());
	        }
       		add(
       			$current, 
       			"ownedVariables",
        		lv_ownedVariables_3_0, 
        		"LetVariableCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4='in' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); 
	    }
		lv_ownedInExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedInExpression",
        		lv_ownedInExpression_5_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLetVariableCS
entryRuleLetVariableCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLetVariableCSRule()); }
	 iv_ruleLetVariableCS=ruleLetVariableCS 
	 { $current=$iv_ruleLetVariableCS.current; } 
	 EOF 
;

// Rule LetVariableCS
ruleLetVariableCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
	    }
		lv_ownedRoundBracketedClause_1_0=ruleRoundBracketedClauseCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current, 
       			"ownedRoundBracketedClause",
        		lv_ownedRoundBracketedClause_1_0, 
        		"RoundBracketedClauseCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?(	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedType_3_0=ruleTypeExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current, 
       			"ownedType",
        		lv_ownedType_3_0, 
        		"TypeExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_4='=' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); 
	    }
		lv_ownedInitExpression_5_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
	        }
       		set(
       			$current, 
       			"ownedInitExpression",
        		lv_ownedInitExpression_5_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleNestedExpCS
entryRuleNestedExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNestedExpCSRule()); }
	 iv_ruleNestedExpCS=ruleNestedExpCS 
	 { $current=$iv_ruleNestedExpCS.current; } 
	 EOF 
;

// Rule NestedExpCS
ruleNestedExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='(' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
	    }
		lv_ownedExpression_1_0=ruleExpCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
	        }
       		set(
       			$current, 
       			"ownedExpression",
        		lv_ownedExpression_1_0, 
        		"ExpCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=')' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2());
    }
)
;





// Entry rule entryRuleSelfExpCS
entryRuleSelfExpCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSelfExpCSRule()); }
	 iv_ruleSelfExpCS=ruleSelfExpCS 
	 { $current=$iv_ruleSelfExpCS.current; } 
	 EOF 
;

// Rule SelfExpCS
ruleSelfExpCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0(),
            $current);
    }
)	otherlv_1='self' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getSelfExpCSAccess().getSelfKeyword_1());
    }
)
;





// Entry rule entryRuleMultiplicityBoundsCS
entryRuleMultiplicityBoundsCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); }
	 iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS 
	 { $current=$iv_ruleMultiplicityBoundsCS.current; } 
	 EOF 
;

// Rule MultiplicityBoundsCS
ruleMultiplicityBoundsCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
	    }
		lv_lowerBound_0_0=ruleLOWER		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
	        }
       		set(
       			$current, 
       			"lowerBound",
        		lv_lowerBound_0_0, 
        		"LOWER");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='..' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
	    }
		lv_upperBound_2_0=ruleUPPER		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
	        }
       		set(
       			$current, 
       			"upperBound",
        		lv_upperBound_2_0, 
        		"UPPER");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleMultiplicityCS
entryRuleMultiplicityCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMultiplicityCSRule()); }
	 iv_ruleMultiplicityCS=ruleMultiplicityCS 
	 { $current=$iv_ruleMultiplicityCS.current; } 
	 EOF 
;

// Rule MultiplicityCS
ruleMultiplicityCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
    }
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
    }
    this_MultiplicityBoundsCS_1=ruleMultiplicityBoundsCS
    { 
        $current = $this_MultiplicityBoundsCS_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
    }
    this_MultiplicityStringCS_2=ruleMultiplicityStringCS
    { 
        $current = $this_MultiplicityStringCS_2.current; 
        afterParserOrEnumRuleCall();
    }
)(	otherlv_3='|?' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
    }

    |(
(
		lv_isNullFree_4_0=	'|1' 
    {
        newLeafNode(lv_isNullFree_4_0, grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityCSRule());
	        }
       		setWithLastConsumed($current, "isNullFree", true, "|1");
	    }

)
))?	otherlv_5=']' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
    }
)
;





// Entry rule entryRuleMultiplicityStringCS
entryRuleMultiplicityStringCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); }
	 iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS 
	 { $current=$iv_ruleMultiplicityStringCS.current; } 
	 EOF 
;

// Rule MultiplicityStringCS
ruleMultiplicityStringCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
(
		lv_stringBounds_0_1=	'*' 
    {
        newLeafNode(lv_stringBounds_0_1, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
	        }
       		setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_1, null);
	    }

    |		lv_stringBounds_0_2=	'+' 
    {
        newLeafNode(lv_stringBounds_0_2, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
	        }
       		setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_2, null);
	    }

    |		lv_stringBounds_0_3=	'?' 
    {
        newLeafNode(lv_stringBounds_0_3, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
	        }
       		setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_3, null);
	    }

)

)
)
;





// Entry rule entryRulePathNameCS
entryRulePathNameCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPathNameCSRule()); }
	 iv_rulePathNameCS=rulePathNameCS 
	 { $current=$iv_rulePathNameCS.current; } 
	 EOF 
;

// Rule PathNameCS
rulePathNameCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
	    }
		lv_ownedPathElements_0_0=ruleFirstPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPathNameCSRule());
	        }
       		add(
       			$current, 
       			"ownedPathElements",
        		lv_ownedPathElements_0_0, 
        		"FirstPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='::' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedPathElements_2_0=ruleNextPathElementCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPathNameCSRule());
	        }
       		add(
       			$current, 
       			"ownedPathElements",
        		lv_ownedPathElements_2_0, 
        		"NextPathElementCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleFirstPathElementCS
entryRuleFirstPathElementCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFirstPathElementCSRule()); }
	 iv_ruleFirstPathElementCS=ruleFirstPathElementCS 
	 { $current=$iv_ruleFirstPathElementCS.current; } 
	 EOF 
;

// Rule FirstPathElementCS
ruleFirstPathElementCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFirstPathElementCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
	    }
		ruleUnrestrictedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleNextPathElementCS
entryRuleNextPathElementCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNextPathElementCSRule()); }
	 iv_ruleNextPathElementCS=ruleNextPathElementCS 
	 { $current=$iv_ruleNextPathElementCS.current; } 
	 EOF 
;

// Rule NextPathElementCS
ruleNextPathElementCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getNextPathElementCSRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
	    }
		ruleUnreservedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleTemplateBindingCS
entryRuleTemplateBindingCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTemplateBindingCSRule()); }
	 iv_ruleTemplateBindingCS=ruleTemplateBindingCS 
	 { $current=$iv_ruleTemplateBindingCS.current; } 
	 EOF 
;

// Rule TemplateBindingCS
ruleTemplateBindingCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
	    }
		lv_ownedSubstitutions_0_0=ruleTemplateParameterSubstitutionCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
	        }
       		add(
       			$current, 
       			"ownedSubstitutions",
        		lv_ownedSubstitutions_0_0, 
        		"TemplateParameterSubstitutionCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=',' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedSubstitutions_2_0=ruleTemplateParameterSubstitutionCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
	        }
       		add(
       			$current, 
       			"ownedSubstitutions",
        		lv_ownedSubstitutions_2_0, 
        		"TemplateParameterSubstitutionCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*(
(
		{ 
	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); 
	    }
		lv_ownedMultiplicity_3_0=ruleMultiplicityCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
	        }
       		set(
       			$current, 
       			"ownedMultiplicity",
        		lv_ownedMultiplicity_3_0, 
        		"MultiplicityCS");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleTemplateParameterSubstitutionCS
entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); }
	 iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS 
	 { $current=$iv_ruleTemplateParameterSubstitutionCS.current; } 
	 EOF 
;

// Rule TemplateParameterSubstitutionCS
ruleTemplateParameterSubstitutionCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
	    }
		lv_ownedActualParameter_0_0=ruleTypeRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTemplateParameterSubstitutionCSRule());
	        }
       		set(
       			$current, 
       			"ownedActualParameter",
        		lv_ownedActualParameter_0_0, 
        		"TypeRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)
;







// Entry rule entryRuleTypeParameterCS
entryRuleTypeParameterCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeParameterCSRule()); }
	 iv_ruleTypeParameterCS=ruleTypeParameterCS 
	 { $current=$iv_ruleTypeParameterCS.current; } 
	 EOF 
;

// Rule TypeParameterCS
ruleTypeParameterCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
	    }
		lv_name_0_0=ruleUnrestrictedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"UnrestrictedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='extends' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedExtends_2_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
	        }
       		add(
       			$current, 
       			"ownedExtends",
        		lv_ownedExtends_2_0, 
        		"TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='&&' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
	    }
		lv_ownedExtends_4_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
	        }
       		add(
       			$current, 
       			"ownedExtends",
        		lv_ownedExtends_4_0, 
        		"TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?)
;





// Entry rule entryRuleTypeRefCS
entryRuleTypeRefCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypeRefCSRule()); }
	 iv_ruleTypeRefCS=ruleTypeRefCS 
	 { $current=$iv_ruleTypeRefCS.current; } 
	 EOF 
;

// Rule TypeRefCS
ruleTypeRefCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
    }
    this_TypedRefCS_0=ruleTypedRefCS
    { 
        $current = $this_TypedRefCS_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
    }
    this_WildcardTypeRefCS_1=ruleWildcardTypeRefCS
    { 
        $current = $this_WildcardTypeRefCS_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTypedRefCS
entryRuleTypedRefCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypedRefCSRule()); }
	 iv_ruleTypedRefCS=ruleTypedRefCS 
	 { $current=$iv_ruleTypedRefCS.current; } 
	 EOF 
;

// Rule TypedRefCS
ruleTypedRefCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
    }
    this_TypedTypeRefCS_0=ruleTypedTypeRefCS
    { 
        $current = $this_TypedTypeRefCS_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleTypedTypeRefCS
entryRuleTypedTypeRefCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); }
	 iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS 
	 { $current=$iv_ruleTypedTypeRefCS.current; } 
	 EOF 
;

// Rule TypedTypeRefCS
ruleTypedTypeRefCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
	    }
		lv_ownedPathName_0_0=rulePathNameCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
	        }
       		set(
       			$current, 
       			"ownedPathName",
        		lv_ownedPathName_0_0, 
        		"PathNameCS");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
	    }
		lv_ownedBinding_2_0=ruleTemplateBindingCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
	        }
       		set(
       			$current, 
       			"ownedBinding",
        		lv_ownedBinding_2_0, 
        		"TemplateBindingCS");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());
    }
)?)
;





// Entry rule entryRuleWildcardTypeRefCS
entryRuleWildcardTypeRefCS returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); }
	 iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS 
	 { $current=$iv_ruleWildcardTypeRefCS.current; } 
	 EOF 
;

// Rule WildcardTypeRefCS
ruleWildcardTypeRefCS returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(),
            $current);
    }
)	otherlv_1='?' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
    }
(	otherlv_2='extends' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); 
	    }
		lv_ownedExtends_3_0=ruleTypedRefCS		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
	        }
       		set(
       			$current, 
       			"ownedExtends",
        		lv_ownedExtends_3_0, 
        		"TypedRefCS");
	        afterParserOrEnumRuleCall();
	    }

)
))?)
;





// Entry rule entryRuleID
entryRuleID returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getIDRule()); } 
	 iv_ruleID=ruleID 
	 { $current=$iv_ruleID.current.getText(); }  
	 EOF 
;

// Rule ID
ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_SIMPLE_ID_0=RULE_SIMPLE_ID    {
		$current.merge(this_SIMPLE_ID_0);
    }

    { 
    newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
    }

    |    this_ESCAPED_ID_1=RULE_ESCAPED_ID    {
		$current.merge(this_ESCAPED_ID_1);
    }

    { 
    newLeafNode(this_ESCAPED_ID_1, grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleIdentifier
entryRuleIdentifier returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getIdentifierRule()); } 
	 iv_ruleIdentifier=ruleIdentifier 
	 { $current=$iv_ruleIdentifier.current.getText(); }  
	 EOF 
;

// Rule Identifier
ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
    }
    this_ID_0=ruleID    {
		$current.merge(this_ID_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }

    ;





// Entry rule entryRuleLOWER
entryRuleLOWER returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getLOWERRule()); } 
	 iv_ruleLOWER=ruleLOWER 
	 { $current=$iv_ruleLOWER.current.getText(); }  
	 EOF 
;

// Rule LOWER
ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleNUMBER_LITERAL
entryRuleNUMBER_LITERAL returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); } 
	 iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL 
	 { $current=$iv_ruleNUMBER_LITERAL.current.getText(); }  
	 EOF 
;

// Rule NUMBER_LITERAL
ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleStringLiteral
entryRuleStringLiteral returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getStringLiteralRule()); } 
	 iv_ruleStringLiteral=ruleStringLiteral 
	 { $current=$iv_ruleStringLiteral.current.getText(); }  
	 EOF 
;

// Rule StringLiteral
ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_SINGLE_QUOTED_STRING_0=RULE_SINGLE_QUOTED_STRING    {
		$current.merge(this_SINGLE_QUOTED_STRING_0);
    }

    { 
    newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleUPPER
entryRuleUPPER returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getUPPERRule()); } 
	 iv_ruleUPPER=ruleUPPER 
	 { $current=$iv_ruleUPPER.current.getText(); }  
	 EOF 
;

// Rule UPPER
ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
    }

    |
	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleURI
entryRuleURI returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getURIRule()); } 
	 iv_ruleURI=ruleURI 
	 { $current=$iv_ruleURI.current.getText(); }  
	 EOF 
;

// Rule URI
ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_SINGLE_QUOTED_STRING_0=RULE_SINGLE_QUOTED_STRING    {
		$current.merge(this_SINGLE_QUOTED_STRING_0);
    }

    { 
    newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); 
    }

    ;





fragment RULE_ESCAPED_CHARACTER : '\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\');

fragment RULE_LETTER_CHARACTER : ('a'..'z'|'A'..'Z'|'_');

RULE_DOUBLE_QUOTED_STRING : '"' (RULE_ESCAPED_CHARACTER|~(('\\'|'"')))* '"';

RULE_SINGLE_QUOTED_STRING : '\'' (RULE_ESCAPED_CHARACTER|~(('\\'|'\'')))* '\'';

RULE_ML_SINGLE_QUOTED_STRING : '/\'' ( options {greedy=false;} : . )*'\'/';

RULE_SIMPLE_ID : RULE_LETTER_CHARACTER (RULE_LETTER_CHARACTER|'0'..'9')*;

RULE_ESCAPED_ID : '_' RULE_SINGLE_QUOTED_STRING;

RULE_INT : ('0'..'9')+;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


