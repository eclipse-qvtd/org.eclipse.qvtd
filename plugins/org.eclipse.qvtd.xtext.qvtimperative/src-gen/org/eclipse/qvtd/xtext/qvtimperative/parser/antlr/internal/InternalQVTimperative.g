/*******************************************************************************
 * Copyright (c) 2011, 2023 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
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
entryRuleTopLevelCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTopLevelCSRule()); }
	iv_ruleTopLevelCS=ruleTopLevelCS
	{ $current=$iv_ruleTopLevelCS.current; }
	EOF;

// Rule TopLevelCS
ruleTopLevelCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedImportsImportCSParserRuleCall_0_0());
				}
				lv_ownedImports_0_0=ruleImportCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
					}
					add(
						$current,
						"ownedImports",
						lv_ownedImports_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ImportCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0());
					}
					lv_ownedPackages_1_0=ruleQualifiedPackageCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
						}
						add(
							$current,
							"ownedPackages",
							lv_ownedPackages_1_0,
							"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.QualifiedPackageCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsTransformationCSParserRuleCall_1_1_0());
					}
					lv_ownedTransformations_2_0=ruleTransformationCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTopLevelCSRule());
						}
						add(
							$current,
							"ownedTransformations",
							lv_ownedTransformations_2_0,
							"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.TransformationCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleAddStatementCS
entryRuleAddStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAddStatementCSRule()); }
	iv_ruleAddStatementCS=ruleAddStatementCS
	{ $current=$iv_ruleAddStatementCS.current; }
	EOF;

// Rule AddStatementCS
ruleAddStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='observe'
			{
				newLeafNode(otherlv_0, grammarAccess.getAddStatementCSAccess().getObserveKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAddStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_1_0());
					}
					lv_observedProperties_1_0=rulePathNameCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAddStatementCSRule());
						}
						add(
							$current,
							"observedProperties",
							lv_observedProperties_1_0,
							"org.eclipse.ocl.xtext.base.Base.PathNameCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=','
				{
					newLeafNode(otherlv_2, grammarAccess.getAddStatementCSAccess().getCommaKeyword_0_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAddStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0());
						}
						lv_observedProperties_3_0=rulePathNameCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAddStatementCSRule());
							}
							add(
								$current,
								"observedProperties",
								lv_observedProperties_3_0,
								"org.eclipse.ocl.xtext.base.Base.PathNameCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_4='add'
		{
			newLeafNode(otherlv_4, grammarAccess.getAddStatementCSAccess().getAddKeyword_1());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAddStatementCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAddStatementCSAccess().getTargetVariableConnectionVariableCrossReference_2_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='+='
		{
			newLeafNode(otherlv_6, grammarAccess.getAddStatementCSAccess().getPlusSignEqualsSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAddStatementCSAccess().getOwnedExpressionExpCSParserRuleCall_4_0());
				}
				lv_ownedExpression_7_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAddStatementCSRule());
					}
					set(
						$current,
						"ownedExpression",
						lv_ownedExpression_7_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8=';'
		{
			newLeafNode(otherlv_8, grammarAccess.getAddStatementCSAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleAppendParameterBindingCS
entryRuleAppendParameterBindingCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAppendParameterBindingCSRule()); }
	iv_ruleAppendParameterBindingCS=ruleAppendParameterBindingCS
	{ $current=$iv_ruleAppendParameterBindingCS.current; }
	EOF;

// Rule AppendParameterBindingCS
ruleAppendParameterBindingCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAppendParameterBindingCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAppendParameterBindingCSAccess().getReferredVariableAppendParameterCrossReference_0_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='appendsTo'
		{
			newLeafNode(otherlv_1, grammarAccess.getAppendParameterBindingCSAccess().getAppendsToKeyword_1());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAppendParameterBindingCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getAppendParameterBindingCSAccess().getValueConnectionVariableCrossReference_2_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=';'
		{
			newLeafNode(otherlv_3, grammarAccess.getAppendParameterBindingCSAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleAppendParameterCS
entryRuleAppendParameterCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAppendParameterCSRule()); }
	iv_ruleAppendParameterCS=ruleAppendParameterCS
	{ $current=$iv_ruleAppendParameterCS.current; }
	EOF;

// Rule AppendParameterCS
ruleAppendParameterCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='append'
		{
			newLeafNode(otherlv_0, grammarAccess.getAppendParameterCSAccess().getAppendKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAppendParameterCSAccess().getNameUnrestrictedNameParserRuleCall_1_0());
				}
				lv_name_1_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAppendParameterCSRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=':'
		{
			newLeafNode(otherlv_2, grammarAccess.getAppendParameterCSAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAppendParameterCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0());
				}
				lv_ownedType_3_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAppendParameterCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getAppendParameterCSAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleBufferStatementCS
entryRuleBufferStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBufferStatementCSRule()); }
	iv_ruleBufferStatementCS=ruleBufferStatementCS
	{ $current=$iv_ruleBufferStatementCS.current; }
	EOF;

// Rule BufferStatementCS
ruleBufferStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_isStrict_0_0='strict'
				{
					newLeafNode(lv_isStrict_0_0, grammarAccess.getBufferStatementCSAccess().getIsStrictStrictKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBufferStatementCSRule());
					}
					setWithLastConsumed($current, "isStrict", lv_isStrict_0_0 != null, "strict");
				}
			)
		)?
		otherlv_1='buffer'
		{
			newLeafNode(otherlv_1, grammarAccess.getBufferStatementCSAccess().getBufferKeyword_1());
		}
		(
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getBufferStatementCSAccess().getColonKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getBufferStatementCSAccess().getFirstPassLOWERParserRuleCall_2_1_0());
					}
					lv_firstPass_3_0=ruleLOWER
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBufferStatementCSRule());
						}
						set(
							$current,
							"firstPass",
							lv_firstPass_3_0,
							"org.eclipse.ocl.xtext.base.Base.LOWER");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='..'
				{
					newLeafNode(otherlv_4, grammarAccess.getBufferStatementCSAccess().getFullStopFullStopKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getBufferStatementCSAccess().getLastPassLOWERParserRuleCall_2_2_1_0());
						}
						lv_lastPass_5_0=ruleLOWER
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getBufferStatementCSRule());
							}
							set(
								$current,
								"lastPass",
								lv_lastPass_5_0,
								"org.eclipse.ocl.xtext.base.Base.LOWER");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getBufferStatementCSAccess().getNameUnrestrictedNameParserRuleCall_3_0());
				}
				lv_name_6_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBufferStatementCSRule());
					}
					set(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_7=':'
			{
				newLeafNode(otherlv_7, grammarAccess.getBufferStatementCSAccess().getColonKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getBufferStatementCSAccess().getOwnedTypeTypeExpCSParserRuleCall_4_1_0());
					}
					lv_ownedType_8_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBufferStatementCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_8_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_9=':='
			{
				newLeafNode(otherlv_9, grammarAccess.getBufferStatementCSAccess().getColonEqualsSignKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getBufferStatementCSAccess().getOwnedExpressionExpCSParserRuleCall_5_1_0());
					}
					lv_ownedExpression_10_0=ruleExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBufferStatementCSRule());
						}
						set(
							$current,
							"ownedExpression",
							lv_ownedExpression_10_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_11=';'
		{
			newLeafNode(otherlv_11, grammarAccess.getBufferStatementCSAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleCommitStatementCS
entryRuleCommitStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCommitStatementCSRule()); }
	iv_ruleCommitStatementCS=ruleCommitStatementCS
	{ $current=$iv_ruleCommitStatementCS.current; }
	EOF;

// Rule CommitStatementCS
ruleCommitStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getCommitStatementCSAccess().getNewStatementCSParserRuleCall_0());
		}
		this_NewStatementCS_0=ruleNewStatementCS
		{
			$current = $this_NewStatementCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getCommitStatementCSAccess().getSetStatementCSParserRuleCall_1());
		}
		this_SetStatementCS_1=ruleSetStatementCS
		{
			$current = $this_SetStatementCS_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleCheckStatementCS
entryRuleCheckStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCheckStatementCSRule()); }
	iv_ruleCheckStatementCS=ruleCheckStatementCS
	{ $current=$iv_ruleCheckStatementCS.current; }
	EOF;

// Rule CheckStatementCS
ruleCheckStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='observe'
			{
				newLeafNode(otherlv_0, grammarAccess.getCheckStatementCSAccess().getObserveKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getCheckStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_1_0());
					}
					lv_observedProperties_1_0=rulePathNameCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCheckStatementCSRule());
						}
						add(
							$current,
							"observedProperties",
							lv_observedProperties_1_0,
							"org.eclipse.ocl.xtext.base.Base.PathNameCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=','
				{
					newLeafNode(otherlv_2, grammarAccess.getCheckStatementCSAccess().getCommaKeyword_0_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getCheckStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0());
						}
						lv_observedProperties_3_0=rulePathNameCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCheckStatementCSRule());
							}
							add(
								$current,
								"observedProperties",
								lv_observedProperties_3_0,
								"org.eclipse.ocl.xtext.base.Base.PathNameCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_4='check'
		{
			newLeafNode(otherlv_4, grammarAccess.getCheckStatementCSAccess().getCheckKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCheckStatementCSAccess().getOwnedConditionExpCSParserRuleCall_2_0());
				}
				lv_ownedCondition_5_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCheckStatementCSRule());
					}
					set(
						$current,
						"ownedCondition",
						lv_ownedCondition_5_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=';'
		{
			newLeafNode(otherlv_6, grammarAccess.getCheckStatementCSAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleControlStatementCS
entryRuleControlStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getControlStatementCSRule()); }
	iv_ruleControlStatementCS=ruleControlStatementCS
	{ $current=$iv_ruleControlStatementCS.current; }
	EOF;

// Rule ControlStatementCS
ruleControlStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getControlStatementCSAccess().getAddStatementCSParserRuleCall_0());
		}
		this_AddStatementCS_0=ruleAddStatementCS
		{
			$current = $this_AddStatementCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getControlStatementCSAccess().getMappingCallCSParserRuleCall_1());
		}
		this_MappingCallCS_1=ruleMappingCallCS
		{
			$current = $this_MappingCallCS_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getControlStatementCSAccess().getMappingLoopCSParserRuleCall_2());
		}
		this_MappingLoopCS_2=ruleMappingLoopCS
		{
			$current = $this_MappingLoopCS_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleDeclareStatementCS
entryRuleDeclareStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeclareStatementCSRule()); }
	iv_ruleDeclareStatementCS=ruleDeclareStatementCS
	{ $current=$iv_ruleDeclareStatementCS.current; }
	EOF;

// Rule DeclareStatementCS
ruleDeclareStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='observe'
			{
				newLeafNode(otherlv_0, grammarAccess.getDeclareStatementCSAccess().getObserveKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeclareStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_1_0());
					}
					lv_observedProperties_1_0=rulePathNameCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeclareStatementCSRule());
						}
						add(
							$current,
							"observedProperties",
							lv_observedProperties_1_0,
							"org.eclipse.ocl.xtext.base.Base.PathNameCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=','
				{
					newLeafNode(otherlv_2, grammarAccess.getDeclareStatementCSAccess().getCommaKeyword_0_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getDeclareStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0());
						}
						lv_observedProperties_3_0=rulePathNameCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getDeclareStatementCSRule());
							}
							add(
								$current,
								"observedProperties",
								lv_observedProperties_3_0,
								"org.eclipse.ocl.xtext.base.Base.PathNameCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			(
				lv_isCheck_4_0='check'
				{
					newLeafNode(lv_isCheck_4_0, grammarAccess.getDeclareStatementCSAccess().getIsCheckCheckKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDeclareStatementCSRule());
					}
					setWithLastConsumed($current, "isCheck", lv_isCheck_4_0 != null, "check");
				}
			)
		)?
		otherlv_5='var'
		{
			newLeafNode(otherlv_5, grammarAccess.getDeclareStatementCSAccess().getVarKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDeclareStatementCSAccess().getNameUnrestrictedNameParserRuleCall_3_0());
				}
				lv_name_6_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeclareStatementCSRule());
					}
					set(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_7=':'
			{
				newLeafNode(otherlv_7, grammarAccess.getDeclareStatementCSAccess().getColonKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeclareStatementCSAccess().getOwnedTypeTypeExpCSParserRuleCall_4_1_0());
					}
					lv_ownedType_8_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeclareStatementCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_8_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_9=':='
		{
			newLeafNode(otherlv_9, grammarAccess.getDeclareStatementCSAccess().getColonEqualsSignKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDeclareStatementCSAccess().getOwnedExpressionExpCSParserRuleCall_6_0());
				}
				lv_ownedExpression_10_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeclareStatementCSRule());
					}
					set(
						$current,
						"ownedExpression",
						lv_ownedExpression_10_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_11=';'
		{
			newLeafNode(otherlv_11, grammarAccess.getDeclareStatementCSAccess().getSemicolonKeyword_7());
		}
	)
;

// Entry rule entryRuleDirectionCS
entryRuleDirectionCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDirectionCSRule()); }
	iv_ruleDirectionCS=ruleDirectionCS
	{ $current=$iv_ruleDirectionCS.current; }
	EOF;

// Rule DirectionCS
ruleDirectionCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getDirectionCSAccess().getDirectionCSAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getDirectionCSAccess().getNameIdentifierParserRuleCall_1_0());
				}
				lv_name_1_0=ruleIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDirectionCSRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.ocl.xtext.base.Base.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2='imports'
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
					ruleUnrestrictedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
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
						ruleUnrestrictedName
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=';'
		{
			newLeafNode(otherlv_6, grammarAccess.getDirectionCSAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleEntryPointCS
entryRuleEntryPointCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntryPointCSRule()); }
	iv_ruleEntryPointCS=ruleEntryPointCS
	{ $current=$iv_ruleEntryPointCS.current; }
	EOF;

// Rule EntryPointCS
ruleEntryPointCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getEntryPointCSAccess().getEntryPointCSAction_0(),
					$current);
			}
		)
		(
			(
				lv_isStrict_1_0='strict'
				{
					newLeafNode(lv_isStrict_1_0, grammarAccess.getEntryPointCSAccess().getIsStrictStrictKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntryPointCSRule());
					}
					setWithLastConsumed($current, "isStrict", lv_isStrict_1_0 != null, "strict");
				}
			)
		)?
		otherlv_2='entry'
		{
			newLeafNode(otherlv_2, grammarAccess.getEntryPointCSAccess().getEntryKeyword_2());
		}
		(
			otherlv_3=':'
			{
				newLeafNode(otherlv_3, grammarAccess.getEntryPointCSAccess().getColonKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEntryPointCSAccess().getTargetNameUnrestrictedNameParserRuleCall_3_1_0());
					}
					lv_targetName_4_0=ruleUnrestrictedName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEntryPointCSRule());
						}
						set(
							$current,
							"targetName",
							lv_targetName_4_0,
							"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getEntryPointCSAccess().getNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_name_5_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntryPointCSRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6='input'
			{
				newLeafNode(otherlv_6, grammarAccess.getEntryPointCSAccess().getInputKeyword_5_0());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEntryPointCSRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEntryPointCSAccess().getInputTypedModelsTypedModelCrossReference_5_1_0());
					}
					ruleUnrestrictedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_8=','
				{
					newLeafNode(otherlv_8, grammarAccess.getEntryPointCSAccess().getCommaKeyword_5_2_0());
				}
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEntryPointCSRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getEntryPointCSAccess().getInputTypedModelsTypedModelCrossReference_5_2_1_0());
						}
						ruleUnrestrictedName
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			otherlv_10='output'
			{
				newLeafNode(otherlv_10, grammarAccess.getEntryPointCSAccess().getOutputKeyword_6_0());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEntryPointCSRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEntryPointCSAccess().getOutputTypedModelsTypedModelCrossReference_6_1_0());
					}
					ruleUnrestrictedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_12=','
				{
					newLeafNode(otherlv_12, grammarAccess.getEntryPointCSAccess().getCommaKeyword_6_2_0());
				}
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEntryPointCSRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getEntryPointCSAccess().getOutputTypedModelsTypedModelCrossReference_6_2_1_0());
						}
						ruleUnrestrictedName
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_14='{'
		{
			newLeafNode(otherlv_14, grammarAccess.getEntryPointCSAccess().getLeftCurlyBracketKeyword_7());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEntryPointCSAccess().getOwnedParametersMappingParameterCSParserRuleCall_8_0());
				}
				lv_ownedParameters_15_0=ruleMappingParameterCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntryPointCSRule());
					}
					add(
						$current,
						"ownedParameters",
						lv_ownedParameters_15_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingParameterCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getEntryPointCSAccess().getOwnedStatementsGuardStatementCSParserRuleCall_9_0());
				}
				lv_ownedStatements_16_0=ruleGuardStatementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntryPointCSRule());
					}
					add(
						$current,
						"ownedStatements",
						lv_ownedStatements_16_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.GuardStatementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getEntryPointCSAccess().getOwnedStatementsCommitStatementCSParserRuleCall_10_0());
				}
				lv_ownedStatements_17_0=ruleCommitStatementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntryPointCSRule());
					}
					add(
						$current,
						"ownedStatements",
						lv_ownedStatements_17_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.CommitStatementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getEntryPointCSAccess().getOwnedStatementsControlStatementCSParserRuleCall_11_0());
				}
				lv_ownedStatements_18_0=ruleControlStatementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEntryPointCSRule());
					}
					add(
						$current,
						"ownedStatements",
						lv_ownedStatements_18_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ControlStatementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_19='}'
		{
			newLeafNode(otherlv_19, grammarAccess.getEntryPointCSAccess().getRightCurlyBracketKeyword_12());
		}
	)
;

// Entry rule entryRuleGuardParameterBindingCS
entryRuleGuardParameterBindingCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGuardParameterBindingCSRule()); }
	iv_ruleGuardParameterBindingCS=ruleGuardParameterBindingCS
	{ $current=$iv_ruleGuardParameterBindingCS.current; }
	EOF;

// Rule GuardParameterBindingCS
ruleGuardParameterBindingCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_isCheck_0_0='check'
				{
					newLeafNode(lv_isCheck_0_0, grammarAccess.getGuardParameterBindingCSAccess().getIsCheckCheckKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGuardParameterBindingCSRule());
					}
					setWithLastConsumed($current, "isCheck", lv_isCheck_0_0 != null, "check");
				}
			)
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGuardParameterBindingCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getGuardParameterBindingCSAccess().getReferredVariableGuardParameterCrossReference_1_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='consumes'
		{
			newLeafNode(otherlv_2, grammarAccess.getGuardParameterBindingCSAccess().getConsumesKeyword_2());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGuardParameterBindingCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getGuardParameterBindingCSAccess().getValueConnectionVariableCrossReference_3_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getGuardParameterBindingCSAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleGuardParameterCS
entryRuleGuardParameterCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGuardParameterCSRule()); }
	iv_ruleGuardParameterCS=ruleGuardParameterCS
	{ $current=$iv_ruleGuardParameterCS.current; }
	EOF;

// Rule GuardParameterCS
ruleGuardParameterCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='guard'
		{
			newLeafNode(otherlv_0, grammarAccess.getGuardParameterCSAccess().getGuardKeyword_0());
		}
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getGuardParameterCSAccess().getColonKeyword_1());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getGuardParameterCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getGuardParameterCSAccess().getReferredTypedModelTypedModelCrossReference_2_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getGuardParameterCSAccess().getNameUnrestrictedNameParserRuleCall_3_0());
				}
				lv_name_3_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGuardParameterCSRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=':'
		{
			newLeafNode(otherlv_4, grammarAccess.getGuardParameterCSAccess().getColonKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getGuardParameterCSAccess().getOwnedTypeTypeExpCSParserRuleCall_5_0());
				}
				lv_ownedType_5_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGuardParameterCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_5_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6='success'
			{
				newLeafNode(otherlv_6, grammarAccess.getGuardParameterCSAccess().getSuccessKeyword_6_0());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getGuardParameterCSRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getGuardParameterCSAccess().getSuccessPropertyPropertyCrossReference_6_1_0());
					}
					ruleUnrestrictedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_8=';'
		{
			newLeafNode(otherlv_8, grammarAccess.getGuardParameterCSAccess().getSemicolonKeyword_7());
		}
	)
;

// Entry rule entryRuleGuardStatementCS
entryRuleGuardStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGuardStatementCSRule()); }
	iv_ruleGuardStatementCS=ruleGuardStatementCS
	{ $current=$iv_ruleGuardStatementCS.current; }
	EOF;

// Rule GuardStatementCS
ruleGuardStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getGuardStatementCSAccess().getBufferStatementCSParserRuleCall_0());
		}
		this_BufferStatementCS_0=ruleBufferStatementCS
		{
			$current = $this_BufferStatementCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getGuardStatementCSAccess().getDeclareStatementCSParserRuleCall_1());
		}
		this_DeclareStatementCS_1=ruleDeclareStatementCS
		{
			$current = $this_DeclareStatementCS_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getGuardStatementCSAccess().getDeclareStatementCSParserRuleCall_2());
		}
		this_DeclareStatementCS_2=ruleDeclareStatementCS
		{
			$current = $this_DeclareStatementCS_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getGuardStatementCSAccess().getCheckStatementCSParserRuleCall_3());
		}
		this_CheckStatementCS_3=ruleCheckStatementCS
		{
			$current = $this_CheckStatementCS_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getGuardStatementCSAccess().getSpeculateStatementCSParserRuleCall_4());
		}
		this_SpeculateStatementCS_4=ruleSpeculateStatementCS
		{
			$current = $this_SpeculateStatementCS_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleImportCS
entryRuleImportCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getImportCSRule()); }
	iv_ruleImportCS=ruleImportCS
	{ $current=$iv_ruleImportCS.current; }
	EOF;

// Rule ImportCS
ruleImportCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='import'
		{
			newLeafNode(otherlv_0, grammarAccess.getImportCSAccess().getImportKeyword_0());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0());
					}
					lv_name_1_0=ruleIdentifier
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getImportCSRule());
						}
						set(
							$current,
							"name",
							lv_name_1_0,
							"org.eclipse.ocl.xtext.base.Base.Identifier");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getImportCSAccess().getColonKeyword_1_1());
			}
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0());
				}
				lv_ownedPathName_3_0=ruleURIPathNameCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getImportCSRule());
					}
					set(
						$current,
						"ownedPathName",
						lv_ownedPathName_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIPathNameCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					lv_isAll_4_0='::'
					{
						newLeafNode(lv_isAll_4_0, grammarAccess.getImportCSAccess().getIsAllColonColonKeyword_3_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getImportCSRule());
						}
						setWithLastConsumed($current, "isAll", lv_isAll_4_0 != null, "::");
					}
				)
			)
			otherlv_5='*'
			{
				newLeafNode(otherlv_5, grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1());
			}
		)?
		otherlv_6=';'
		{
			newLeafNode(otherlv_6, grammarAccess.getImportCSAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleLoopParameterBindingCS
entryRuleLoopParameterBindingCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLoopParameterBindingCSRule()); }
	iv_ruleLoopParameterBindingCS=ruleLoopParameterBindingCS
	{ $current=$iv_ruleLoopParameterBindingCS.current; }
	EOF;

// Rule LoopParameterBindingCS
ruleLoopParameterBindingCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_isCheck_0_0='check'
				{
					newLeafNode(lv_isCheck_0_0, grammarAccess.getLoopParameterBindingCSAccess().getIsCheckCheckKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLoopParameterBindingCSRule());
					}
					setWithLastConsumed($current, "isCheck", lv_isCheck_0_0 != null, "check");
				}
			)
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLoopParameterBindingCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getLoopParameterBindingCSAccess().getReferredVariableGuardParameterCrossReference_1_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='iterates'
		{
			newLeafNode(otherlv_2, grammarAccess.getLoopParameterBindingCSAccess().getIteratesKeyword_2());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLoopParameterBindingCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getLoopParameterBindingCSAccess().getValueLoopVariableCrossReference_3_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getLoopParameterBindingCSAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleMappingCS
entryRuleMappingCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingCSRule()); }
	iv_ruleMappingCS=ruleMappingCS
	{ $current=$iv_ruleMappingCS.current; }
	EOF;

// Rule MappingCS
ruleMappingCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMappingCSAccess().getMappingCSAction_0(),
					$current);
			}
		)
		(
			(
				lv_isStrict_1_0='strict'
				{
					newLeafNode(lv_isStrict_1_0, grammarAccess.getMappingCSAccess().getIsStrictStrictKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMappingCSRule());
					}
					setWithLastConsumed($current, "isStrict", lv_isStrict_1_0 != null, "strict");
				}
			)
		)?
		otherlv_2='map'
		{
			newLeafNode(otherlv_2, grammarAccess.getMappingCSAccess().getMapKeyword_2());
		}
		(
			otherlv_3=':'
			{
				newLeafNode(otherlv_3, grammarAccess.getMappingCSAccess().getColonKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getMappingCSAccess().getFirstPassLOWERParserRuleCall_3_1_0());
					}
					lv_firstPass_4_0=ruleLOWER
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMappingCSRule());
						}
						set(
							$current,
							"firstPass",
							lv_firstPass_4_0,
							"org.eclipse.ocl.xtext.base.Base.LOWER");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5='..'
				{
					newLeafNode(otherlv_5, grammarAccess.getMappingCSAccess().getFullStopFullStopKeyword_3_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMappingCSAccess().getLastPassLOWERParserRuleCall_3_2_1_0());
						}
						lv_lastPass_6_0=ruleLOWER
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMappingCSRule());
							}
							set(
								$current,
								"lastPass",
								lv_lastPass_6_0,
								"org.eclipse.ocl.xtext.base.Base.LOWER");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingCSAccess().getNameUnrestrictedNameParserRuleCall_4_0());
				}
				lv_name_7_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingCSRule());
					}
					set(
						$current,
						"name",
						lv_name_7_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8='{'
		{
			newLeafNode(otherlv_8, grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedParametersMappingParameterCSParserRuleCall_6_0());
				}
				lv_ownedParameters_9_0=ruleMappingParameterCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingCSRule());
					}
					add(
						$current,
						"ownedParameters",
						lv_ownedParameters_9_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingParameterCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedStatementsGuardStatementCSParserRuleCall_7_0());
				}
				lv_ownedStatements_10_0=ruleGuardStatementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingCSRule());
					}
					add(
						$current,
						"ownedStatements",
						lv_ownedStatements_10_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.GuardStatementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedStatementsCommitStatementCSParserRuleCall_8_0());
				}
				lv_ownedStatements_11_0=ruleCommitStatementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingCSRule());
					}
					add(
						$current,
						"ownedStatements",
						lv_ownedStatements_11_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.CommitStatementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingCSAccess().getOwnedStatementsControlStatementCSParserRuleCall_9_0());
				}
				lv_ownedStatements_12_0=ruleControlStatementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingCSRule());
					}
					add(
						$current,
						"ownedStatements",
						lv_ownedStatements_12_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ControlStatementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_13='}'
		{
			newLeafNode(otherlv_13, grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_10());
		}
	)
;

// Entry rule entryRuleMappingCallCS
entryRuleMappingCallCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingCallCSRule()); }
	iv_ruleMappingCallCS=ruleMappingCallCS
	{ $current=$iv_ruleMappingCallCS.current; }
	EOF;

// Rule MappingCallCS
ruleMappingCallCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getMappingCallCSAccess().getMappingCallCSAction_0(),
					$current);
			}
		)
		(
			otherlv_1='call'
			{
				newLeafNode(otherlv_1, grammarAccess.getMappingCallCSAccess().getCallKeyword_1_0());
			}
			    |
			(
				(
					lv_isInstall_2_0='install'
					{
						newLeafNode(lv_isInstall_2_0, grammarAccess.getMappingCallCSAccess().getIsInstallInstallKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMappingCallCSRule());
						}
						setWithLastConsumed($current, "isInstall", lv_isInstall_2_0 != null, "install");
					}
				)
			)
			    |
			(
				(
					lv_isInvoke_3_0='invoke'
					{
						newLeafNode(lv_isInvoke_3_0, grammarAccess.getMappingCallCSAccess().getIsInvokeInvokeKeyword_1_2_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMappingCallCSRule());
						}
						setWithLastConsumed($current, "isInvoke", lv_isInvoke_3_0 != null, "invoke");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingCallCSAccess().getOwnedPathNamePathNameCSParserRuleCall_2_0());
				}
				lv_ownedPathName_4_0=rulePathNameCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingCallCSRule());
					}
					set(
						$current,
						"ownedPathName",
						lv_ownedPathName_4_0,
						"org.eclipse.ocl.xtext.base.Base.PathNameCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getMappingCallCSAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingCallCSAccess().getOwnedBindingsMappingParameterBindingCSParserRuleCall_4_0());
				}
				lv_ownedBindings_6_0=ruleMappingParameterBindingCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingCallCSRule());
					}
					add(
						$current,
						"ownedBindings",
						lv_ownedBindings_6_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingParameterBindingCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getMappingCallCSAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleMappingLoopCS
entryRuleMappingLoopCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingLoopCSRule()); }
	iv_ruleMappingLoopCS=ruleMappingLoopCS
	{ $current=$iv_ruleMappingLoopCS.current; }
	EOF;

// Rule MappingLoopCS
ruleMappingLoopCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='observe'
			{
				newLeafNode(otherlv_0, grammarAccess.getMappingLoopCSAccess().getObserveKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getMappingLoopCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_1_0());
					}
					lv_observedProperties_1_0=rulePathNameCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
						}
						add(
							$current,
							"observedProperties",
							lv_observedProperties_1_0,
							"org.eclipse.ocl.xtext.base.Base.PathNameCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=','
				{
					newLeafNode(otherlv_2, grammarAccess.getMappingLoopCSAccess().getCommaKeyword_0_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMappingLoopCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0());
						}
						lv_observedProperties_3_0=rulePathNameCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
							}
							add(
								$current,
								"observedProperties",
								lv_observedProperties_3_0,
								"org.eclipse.ocl.xtext.base.Base.PathNameCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_4='for'
		{
			newLeafNode(otherlv_4, grammarAccess.getMappingLoopCSAccess().getForKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingLoopCSAccess().getOwnedIteratorMappingIteratorCSParserRuleCall_2_0());
				}
				lv_ownedIterator_5_0=ruleMappingIteratorCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
					}
					set(
						$current,
						"ownedIterator",
						lv_ownedIterator_5_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingIteratorCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6='in'
		{
			newLeafNode(otherlv_6, grammarAccess.getMappingLoopCSAccess().getInKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingLoopCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0());
				}
				lv_ownedInExpression_7_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
					}
					set(
						$current,
						"ownedInExpression",
						lv_ownedInExpression_7_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8='{'
		{
			newLeafNode(otherlv_8, grammarAccess.getMappingLoopCSAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingLoopCSAccess().getOwnedMappingStatementsControlStatementCSParserRuleCall_6_0());
				}
				lv_ownedMappingStatements_9_0=ruleControlStatementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingLoopCSRule());
					}
					add(
						$current,
						"ownedMappingStatements",
						lv_ownedMappingStatements_9_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ControlStatementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_10='}'
		{
			newLeafNode(otherlv_10, grammarAccess.getMappingLoopCSAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleMappingIteratorCS
entryRuleMappingIteratorCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingIteratorCSRule()); }
	iv_ruleMappingIteratorCS=ruleMappingIteratorCS
	{ $current=$iv_ruleMappingIteratorCS.current; }
	EOF;

// Rule MappingIteratorCS
ruleMappingIteratorCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getMappingIteratorCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMappingIteratorCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=':'
			{
				newLeafNode(otherlv_1, grammarAccess.getMappingIteratorCSAccess().getColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getMappingIteratorCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());
					}
					lv_ownedType_2_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMappingIteratorCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleMappingParameterBindingCS
entryRuleMappingParameterBindingCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingParameterBindingCSRule()); }
	iv_ruleMappingParameterBindingCS=ruleMappingParameterBindingCS
	{ $current=$iv_ruleMappingParameterBindingCS.current; }
	EOF;

// Rule MappingParameterBindingCS
ruleMappingParameterBindingCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMappingParameterBindingCSAccess().getAppendParameterBindingCSParserRuleCall_0());
		}
		this_AppendParameterBindingCS_0=ruleAppendParameterBindingCS
		{
			$current = $this_AppendParameterBindingCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMappingParameterBindingCSAccess().getGuardParameterBindingCSParserRuleCall_1());
		}
		this_GuardParameterBindingCS_1=ruleGuardParameterBindingCS
		{
			$current = $this_GuardParameterBindingCS_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMappingParameterBindingCSAccess().getLoopParameterBindingCSParserRuleCall_2());
		}
		this_LoopParameterBindingCS_2=ruleLoopParameterBindingCS
		{
			$current = $this_LoopParameterBindingCS_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMappingParameterBindingCSAccess().getSimpleParameterBindingCSParserRuleCall_3());
		}
		this_SimpleParameterBindingCS_3=ruleSimpleParameterBindingCS
		{
			$current = $this_SimpleParameterBindingCS_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleMappingParameterCS
entryRuleMappingParameterCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMappingParameterCSRule()); }
	iv_ruleMappingParameterCS=ruleMappingParameterCS
	{ $current=$iv_ruleMappingParameterCS.current; }
	EOF;

// Rule MappingParameterCS
ruleMappingParameterCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMappingParameterCSAccess().getAppendParameterCSParserRuleCall_0());
		}
		this_AppendParameterCS_0=ruleAppendParameterCS
		{
			$current = $this_AppendParameterCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMappingParameterCSAccess().getGuardParameterCSParserRuleCall_1());
		}
		this_GuardParameterCS_1=ruleGuardParameterCS
		{
			$current = $this_GuardParameterCS_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getMappingParameterCSAccess().getSimpleParameterCSParserRuleCall_2());
		}
		this_SimpleParameterCS_2=ruleSimpleParameterCS
		{
			$current = $this_SimpleParameterCS_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleNewStatementCS
entryRuleNewStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNewStatementCSRule()); }
	iv_ruleNewStatementCS=ruleNewStatementCS
	{ $current=$iv_ruleNewStatementCS.current; }
	EOF;

// Rule NewStatementCS
ruleNewStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='observe'
			{
				newLeafNode(otherlv_0, grammarAccess.getNewStatementCSAccess().getObserveKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNewStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_1_0());
					}
					lv_observedProperties_1_0=rulePathNameCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNewStatementCSRule());
						}
						add(
							$current,
							"observedProperties",
							lv_observedProperties_1_0,
							"org.eclipse.ocl.xtext.base.Base.PathNameCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=','
				{
					newLeafNode(otherlv_2, grammarAccess.getNewStatementCSAccess().getCommaKeyword_0_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getNewStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0());
						}
						lv_observedProperties_3_0=rulePathNameCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNewStatementCSRule());
							}
							add(
								$current,
								"observedProperties",
								lv_observedProperties_3_0,
								"org.eclipse.ocl.xtext.base.Base.PathNameCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			(
				lv_isContained_4_0='contained'
				{
					newLeafNode(lv_isContained_4_0, grammarAccess.getNewStatementCSAccess().getIsContainedContainedKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNewStatementCSRule());
					}
					setWithLastConsumed($current, "isContained", lv_isContained_4_0 != null, "contained");
				}
			)
		)?
		otherlv_5='new'
		{
			newLeafNode(otherlv_5, grammarAccess.getNewStatementCSAccess().getNewKeyword_2());
		}
		otherlv_6=':'
		{
			newLeafNode(otherlv_6, grammarAccess.getNewStatementCSAccess().getColonKeyword_3());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNewStatementCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getNewStatementCSAccess().getReferredTypedModelTypedModelCrossReference_4_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNewStatementCSAccess().getNameUnrestrictedNameParserRuleCall_5_0());
				}
				lv_name_8_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNewStatementCSRule());
					}
					set(
						$current,
						"name",
						lv_name_8_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_9=':'
		{
			newLeafNode(otherlv_9, grammarAccess.getNewStatementCSAccess().getColonKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNewStatementCSAccess().getOwnedTypeTypeExpCSParserRuleCall_7_0());
				}
				lv_ownedType_10_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNewStatementCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_10_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_11=':='
			{
				newLeafNode(otherlv_11, grammarAccess.getNewStatementCSAccess().getColonEqualsSignKeyword_8_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNewStatementCSAccess().getOwnedExpressionExpCSParserRuleCall_8_1_0());
					}
					lv_ownedExpression_12_0=ruleExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNewStatementCSRule());
						}
						set(
							$current,
							"ownedExpression",
							lv_ownedExpression_12_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_13=';'
		{
			newLeafNode(otherlv_13, grammarAccess.getNewStatementCSAccess().getSemicolonKeyword_9());
		}
	)
;

// Entry rule entryRuleParamDeclarationCS
entryRuleParamDeclarationCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParamDeclarationCSRule()); }
	iv_ruleParamDeclarationCS=ruleParamDeclarationCS
	{ $current=$iv_ruleParamDeclarationCS.current; }
	EOF;

// Rule ParamDeclarationCS
ruleParamDeclarationCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParamDeclarationCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0());
				}
				lv_ownedType_2_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParamDeclarationCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_2_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleQualifiedPackageCS
entryRuleQualifiedPackageCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedPackageCSRule()); }
	iv_ruleQualifiedPackageCS=ruleQualifiedPackageCS
	{ $current=$iv_ruleQualifiedPackageCS.current; }
	EOF;

// Rule QualifiedPackageCS
ruleQualifiedPackageCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='package'
		{
			newLeafNode(otherlv_0, grammarAccess.getQualifiedPackageCSAccess().getPackageKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getQualifiedPackageCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0());
				}
				lv_ownedPathName_1_0=ruleScopeNameCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQualifiedPackageCSRule());
					}
					set(
						$current,
						"ownedPathName",
						lv_ownedPathName_1_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ScopeNameCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getQualifiedPackageCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_name_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQualifiedPackageCSRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=':'
			{
				newLeafNode(otherlv_3, grammarAccess.getQualifiedPackageCSAccess().getColonKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getQualifiedPackageCSAccess().getNsPrefixUnrestrictedNameParserRuleCall_3_1_0());
					}
					lv_nsPrefix_4_0=ruleUnrestrictedName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQualifiedPackageCSRule());
						}
						set(
							$current,
							"nsPrefix",
							lv_nsPrefix_4_0,
							"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_5='='
			{
				newLeafNode(otherlv_5, grammarAccess.getQualifiedPackageCSAccess().getEqualsSignKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getQualifiedPackageCSAccess().getNsURIURIParserRuleCall_4_1_0());
					}
					lv_nsURI_6_0=ruleURI
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQualifiedPackageCSRule());
						}
						set(
							$current,
							"nsURI",
							lv_nsURI_6_0,
							"org.eclipse.ocl.xtext.base.Base.URI");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				otherlv_7='{'
				{
					newLeafNode(otherlv_7, grammarAccess.getQualifiedPackageCSAccess().getLeftCurlyBracketKeyword_5_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getQualifiedPackageCSAccess().getOwnedPackagesQualifiedPackageCSParserRuleCall_5_0_1_0_0());
							}
							lv_ownedPackages_8_0=ruleQualifiedPackageCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getQualifiedPackageCSRule());
								}
								add(
									$current,
									"ownedPackages",
									lv_ownedPackages_8_0,
									"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.QualifiedPackageCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesClassCSParserRuleCall_5_0_1_1_0_0());
								}
								lv_ownedClasses_9_1=ruleClassCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getQualifiedPackageCSRule());
									}
									add(
										$current,
										"ownedClasses",
										lv_ownedClasses_9_1,
										"org.eclipse.qvtd.xtext.qvtbase.QVTbase.ClassCS");
									afterParserOrEnumRuleCall();
								}
								    |
								{
									newCompositeNode(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesTransformationCSParserRuleCall_5_0_1_1_0_1());
								}
								lv_ownedClasses_9_2=ruleTransformationCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getQualifiedPackageCSRule());
									}
									add(
										$current,
										"ownedClasses",
										lv_ownedClasses_9_2,
										"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.TransformationCS");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)
				)*
				otherlv_10='}'
				{
					newLeafNode(otherlv_10, grammarAccess.getQualifiedPackageCSAccess().getRightCurlyBracketKeyword_5_0_2());
				}
			)
			    |
			otherlv_11=';'
			{
				newLeafNode(otherlv_11, grammarAccess.getQualifiedPackageCSAccess().getSemicolonKeyword_5_1());
			}
		)
	)
;

// Entry rule entryRuleQueryCS
entryRuleQueryCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQueryCSRule()); }
	iv_ruleQueryCS=ruleQueryCS
	{ $current=$iv_ruleQueryCS.current; }
	EOF;

// Rule QueryCS
ruleQueryCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_isTransient_0_0='transient'
				{
					newLeafNode(lv_isTransient_0_0, grammarAccess.getQueryCSAccess().getIsTransientTransientKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getQueryCSRule());
					}
					setWithLastConsumed($current, "isTransient", lv_isTransient_0_0 != null, "transient");
				}
			)
		)?
		otherlv_1='query'
		{
			newLeafNode(otherlv_1, grammarAccess.getQueryCSAccess().getQueryKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_name_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQueryCSRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='('
		{
			newLeafNode(otherlv_3, grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_3());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_4_0_0());
					}
					lv_ownedParameters_4_0=ruleParamDeclarationCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQueryCSRule());
						}
						add(
							$current,
							"ownedParameters",
							lv_ownedParameters_4_0,
							"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ParamDeclarationCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=','
				{
					newLeafNode(otherlv_5, grammarAccess.getQueryCSAccess().getCommaKeyword_4_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_4_1_1_0());
						}
						lv_ownedParameters_6_0=ruleParamDeclarationCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getQueryCSRule());
							}
							add(
								$current,
								"ownedParameters",
								lv_ownedParameters_6_0,
								"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ParamDeclarationCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_7=')'
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
				lv_ownedType_9_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQueryCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_9_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_10=';'
			{
				newLeafNode(otherlv_10, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_0());
			}
			    |
			(
				otherlv_11='{'
				{
					newLeafNode(otherlv_11, grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_8_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getQueryCSAccess().getOwnedExpressionExpCSParserRuleCall_8_1_1_0());
						}
						lv_ownedExpression_12_0=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getQueryCSRule());
							}
							set(
								$current,
								"ownedExpression",
								lv_ownedExpression_12_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_13='}'
				{
					newLeafNode(otherlv_13, grammarAccess.getQueryCSAccess().getRightCurlyBracketKeyword_8_1_2());
				}
			)
			    |
			(
				otherlv_14='implementedby'
				{
					newLeafNode(otherlv_14, grammarAccess.getQueryCSAccess().getImplementedbyKeyword_8_2_0());
				}
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getQueryCSRule());
							}
						}
						otherlv_15=RULE_SINGLE_QUOTED_STRING
						{
							newLeafNode(otherlv_15, grammarAccess.getQueryCSAccess().getImplementationJavaClassCSCrossReference_8_2_1_0());
						}
					)
				)
				otherlv_16=';'
				{
					newLeafNode(otherlv_16, grammarAccess.getQueryCSAccess().getSemicolonKeyword_8_2_2());
				}
			)
		)
	)
;

// Entry rule entryRuleScopeNameCS
entryRuleScopeNameCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScopeNameCSRule()); }
	iv_ruleScopeNameCS=ruleScopeNameCS
	{ $current=$iv_ruleScopeNameCS.current; }
	EOF;

// Rule ScopeNameCS
ruleScopeNameCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0());
				}
				lv_ownedPathElements_0_0=ruleFirstPathElementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
					}
					add(
						$current,
						"ownedPathElements",
						lv_ownedPathElements_0_0,
						"org.eclipse.ocl.xtext.base.Base.FirstPathElementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='::'
		{
			newLeafNode(otherlv_1, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0());
					}
					lv_ownedPathElements_2_0=ruleNextPathElementCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getScopeNameCSRule());
						}
						add(
							$current,
							"ownedPathElements",
							lv_ownedPathElements_2_0,
							"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3='::'
			{
				newLeafNode(otherlv_3, grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1());
			}
		)*
	)
;

// Entry rule entryRuleSetStatementCS
entryRuleSetStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSetStatementCSRule()); }
	iv_ruleSetStatementCS=ruleSetStatementCS
	{ $current=$iv_ruleSetStatementCS.current; }
	EOF;

// Rule SetStatementCS
ruleSetStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='observe'
			{
				newLeafNode(otherlv_0, grammarAccess.getSetStatementCSAccess().getObserveKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSetStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_1_0());
					}
					lv_observedProperties_1_0=rulePathNameCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSetStatementCSRule());
						}
						add(
							$current,
							"observedProperties",
							lv_observedProperties_1_0,
							"org.eclipse.ocl.xtext.base.Base.PathNameCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=','
				{
					newLeafNode(otherlv_2, grammarAccess.getSetStatementCSAccess().getCommaKeyword_0_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getSetStatementCSAccess().getObservedPropertiesPathNameCSParserRuleCall_0_2_1_0());
						}
						lv_observedProperties_3_0=rulePathNameCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getSetStatementCSRule());
							}
							add(
								$current,
								"observedProperties",
								lv_observedProperties_3_0,
								"org.eclipse.ocl.xtext.base.Base.PathNameCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			(
				lv_isNotify_4_0='notify'
				{
					newLeafNode(lv_isNotify_4_0, grammarAccess.getSetStatementCSAccess().getIsNotifyNotifyKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSetStatementCSRule());
					}
					setWithLastConsumed($current, "isNotify", lv_isNotify_4_0 != null, "notify");
				}
			)
		)?
		otherlv_5='set'
		{
			newLeafNode(otherlv_5, grammarAccess.getSetStatementCSAccess().getSetKeyword_2());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSetStatementCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSetStatementCSAccess().getReferredVariableVariableDeclarationCrossReference_3_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='.'
		{
			newLeafNode(otherlv_7, grammarAccess.getSetStatementCSAccess().getFullStopKeyword_4());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSetStatementCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSetStatementCSAccess().getReferredPropertyPropertyCrossReference_5_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_9=':='
			{
				newLeafNode(otherlv_9, grammarAccess.getSetStatementCSAccess().getColonEqualsSignKeyword_6_0());
			}
			    |
			(
				(
					lv_isPartial_10_0='+='
					{
						newLeafNode(lv_isPartial_10_0, grammarAccess.getSetStatementCSAccess().getIsPartialPlusSignEqualsSignKeyword_6_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSetStatementCSRule());
						}
						setWithLastConsumed($current, "isPartial", lv_isPartial_10_0 != null, "+=");
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSetStatementCSAccess().getOwnedExpressionExpCSParserRuleCall_7_0());
				}
				lv_ownedExpression_11_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSetStatementCSRule());
					}
					set(
						$current,
						"ownedExpression",
						lv_ownedExpression_11_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_12=';'
		{
			newLeafNode(otherlv_12, grammarAccess.getSetStatementCSAccess().getSemicolonKeyword_8());
		}
	)
;

// Entry rule entryRuleSimpleParameterBindingCS
entryRuleSimpleParameterBindingCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleParameterBindingCSRule()); }
	iv_ruleSimpleParameterBindingCS=ruleSimpleParameterBindingCS
	{ $current=$iv_ruleSimpleParameterBindingCS.current; }
	EOF;

// Rule SimpleParameterBindingCS
ruleSimpleParameterBindingCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_isCheck_0_0='check'
				{
					newLeafNode(lv_isCheck_0_0, grammarAccess.getSimpleParameterBindingCSAccess().getIsCheckCheckKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSimpleParameterBindingCSRule());
					}
					setWithLastConsumed($current, "isCheck", lv_isCheck_0_0 != null, "check");
				}
			)
		)?
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSimpleParameterBindingCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSimpleParameterBindingCSAccess().getReferredVariableSimpleParameterCrossReference_1_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='uses'
		{
			newLeafNode(otherlv_2, grammarAccess.getSimpleParameterBindingCSAccess().getUsesKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSimpleParameterBindingCSAccess().getOwnedValueExpCSParserRuleCall_3_0());
				}
				lv_ownedValue_3_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSimpleParameterBindingCSRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getSimpleParameterBindingCSAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleSimpleParameterCS
entryRuleSimpleParameterCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleParameterCSRule()); }
	iv_ruleSimpleParameterCS=ruleSimpleParameterCS
	{ $current=$iv_ruleSimpleParameterCS.current; }
	EOF;

// Rule SimpleParameterCS
ruleSimpleParameterCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='in'
		{
			newLeafNode(otherlv_0, grammarAccess.getSimpleParameterCSAccess().getInKeyword_0());
		}
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getSimpleParameterCSAccess().getColonKeyword_1());
		}
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSimpleParameterCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSimpleParameterCSAccess().getReferredTypedModelTypedModelCrossReference_2_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSimpleParameterCSAccess().getNameUnrestrictedNameParserRuleCall_3_0());
				}
				lv_name_3_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSimpleParameterCSRule());
					}
					set(
						$current,
						"name",
						lv_name_3_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=':'
		{
			newLeafNode(otherlv_4, grammarAccess.getSimpleParameterCSAccess().getColonKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSimpleParameterCSAccess().getOwnedTypeTypeExpCSParserRuleCall_5_0());
				}
				lv_ownedType_5_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSimpleParameterCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_5_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=';'
		{
			newLeafNode(otherlv_6, grammarAccess.getSimpleParameterCSAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleSpeculateStatementCS
entryRuleSpeculateStatementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSpeculateStatementCSRule()); }
	iv_ruleSpeculateStatementCS=ruleSpeculateStatementCS
	{ $current=$iv_ruleSpeculateStatementCS.current; }
	EOF;

// Rule SpeculateStatementCS
ruleSpeculateStatementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='speculate'
		{
			newLeafNode(otherlv_0, grammarAccess.getSpeculateStatementCSAccess().getSpeculateKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSpeculateStatementCSAccess().getOwnedConditionsExpCSParserRuleCall_1_0());
				}
				lv_ownedConditions_1_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSpeculateStatementCSRule());
					}
					add(
						$current,
						"ownedConditions",
						lv_ownedConditions_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getSpeculateStatementCSAccess().getCommaKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSpeculateStatementCSAccess().getOwnedConditionsExpCSParserRuleCall_2_1_0());
					}
					lv_ownedConditions_3_0=ruleExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSpeculateStatementCSRule());
						}
						add(
							$current,
							"ownedConditions",
							lv_ownedConditions_3_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getSpeculateStatementCSAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleTransformationCS
entryRuleTransformationCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransformationCSRule()); }
	iv_ruleTransformationCS=ruleTransformationCS
	{ $current=$iv_ruleTransformationCS.current; }
	EOF;

// Rule TransformationCS
ruleTransformationCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='transformation'
		{
			newLeafNode(otherlv_0, grammarAccess.getTransformationCSAccess().getTransformationKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0());
				}
				lv_ownedPathName_1_0=ruleScopeNameCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
					}
					set(
						$current,
						"ownedPathName",
						lv_ownedPathName_1_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.ScopeNameCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0());
				}
				lv_name_2_0=ruleUnreservedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnreservedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=':'
			{
				newLeafNode(otherlv_3, grammarAccess.getTransformationCSAccess().getColonKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedContextTypeTypeExpCSParserRuleCall_3_1_0());
					}
					lv_ownedContextType_4_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
						}
						set(
							$current,
							"ownedContextType",
							lv_ownedContextType_4_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedDirectionsDirectionCSParserRuleCall_5_0());
				}
				lv_ownedDirections_6_0=ruleDirectionCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
					}
					add(
						$current,
						"ownedDirections",
						lv_ownedDirections_6_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.DirectionCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedMappingsEntryPointCSParserRuleCall_6_0_0_0());
						}
						lv_ownedMappings_7_1=ruleEntryPointCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
							}
							add(
								$current,
								"ownedMappings",
								lv_ownedMappings_7_1,
								"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.EntryPointCS");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedMappingsMappingCSParserRuleCall_6_0_0_1());
						}
						lv_ownedMappings_7_2=ruleMappingCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
							}
							add(
								$current,
								"ownedMappings",
								lv_ownedMappings_7_2,
								"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.MappingCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedQueriesQueryCSParserRuleCall_6_1_0());
					}
					lv_ownedQueries_8_0=ruleQueryCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
						}
						add(
							$current,
							"ownedQueries",
							lv_ownedQueries_8_0,
							"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.QueryCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getTransformationCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_6_2_0());
					}
					lv_ownedProperties_9_0=ruleStructuralFeatureCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTransformationCSRule());
						}
						add(
							$current,
							"ownedProperties",
							lv_ownedProperties_9_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.StructuralFeatureCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_10='}'
		{
			newLeafNode(otherlv_10, grammarAccess.getTransformationCSAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleQVTimperativeUnrestrictedName
entryRuleQVTimperativeUnrestrictedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQVTimperativeUnrestrictedNameRule()); }
	iv_ruleQVTimperativeUnrestrictedName=ruleQVTimperativeUnrestrictedName
	{ $current=$iv_ruleQVTimperativeUnrestrictedName.current.getText(); }
	EOF;

// Rule QVTimperativeUnrestrictedName
ruleQVTimperativeUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='add'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getAddKeyword_0());
		}
		    |
		kw='append'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getAppendKeyword_1());
		}
		    |
		kw='appendsTo'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getAppendsToKeyword_2());
		}
		    |
		kw='buffer'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getBufferKeyword_3());
		}
		    |
		kw='call'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getCallKeyword_4());
		}
		    |
		kw='check'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getCheckKeyword_5());
		}
		    |
		kw='contained'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getContainedKeyword_6());
		}
		    |
		kw='entry'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getEntryKeyword_7());
		}
		    |
		kw='for'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getForKeyword_8());
		}
		    |
		kw='implementedby'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getImplementedbyKeyword_9());
		}
		    |
		kw='imports'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getImportsKeyword_10());
		}
		    |
		kw='input'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getInputKeyword_11());
		}
		    |
		kw='install'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getInstallKeyword_12());
		}
		    |
		kw='invoke'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getInvokeKeyword_13());
		}
		    |
		kw='iterates'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getIteratesKeyword_14());
		}
		    |
		kw='map'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getMapKeyword_15());
		}
		    |
		kw='new'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getNewKeyword_16());
		}
		    |
		kw='notify'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getNotifyKeyword_17());
		}
		    |
		kw='observe'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getObserveKeyword_18());
		}
		    |
		kw='output'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getOutputKeyword_19());
		}
		    |
		kw='package'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getPackageKeyword_20());
		}
		    |
		kw='query'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getQueryKeyword_21());
		}
		    |
		kw='set'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getSetKeyword_22());
		}
		    |
		kw='speculate'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getSpeculateKeyword_23());
		}
		    |
		kw='strict'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getStrictKeyword_24());
		}
		    |
		kw='success'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getSuccessKeyword_25());
		}
		    |
		kw='target'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getTargetKeyword_26());
		}
		    |
		kw='transformation'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getTransformationKeyword_27());
		}
		    |
		kw='transient'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getTransientKeyword_28());
		}
		    |
		kw='uses'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getUsesKeyword_29());
		}
		    |
		kw='var'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getVarKeyword_30());
		}
		    |
		kw='via'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTimperativeUnrestrictedNameAccess().getViaKeyword_31());
		}
	)
;

// Entry rule entryRuleUnrestrictedName
entryRuleUnrestrictedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUnrestrictedNameRule()); }
	iv_ruleUnrestrictedName=ruleUnrestrictedName
	{ $current=$iv_ruleUnrestrictedName.current.getText(); }
	EOF;

// Rule UnrestrictedName
ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0());
		}
		this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName
		{
			$current.merge(this_EssentialOCLUnrestrictedName_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getQVTbaseUnrestrictedNameParserRuleCall_1());
		}
		this_QVTbaseUnrestrictedName_1=ruleQVTbaseUnrestrictedName
		{
			$current.merge(this_QVTbaseUnrestrictedName_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getQVTimperativeUnrestrictedNameParserRuleCall_2());
		}
		this_QVTimperativeUnrestrictedName_2=ruleQVTimperativeUnrestrictedName
		{
			$current.merge(this_QVTimperativeUnrestrictedName_2);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAttributeCS
entryRuleAttributeCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAttributeCSRule()); }
	iv_ruleAttributeCS=ruleAttributeCS
	{ $current=$iv_ruleAttributeCS.current; }
	EOF;

// Rule AttributeCS
ruleAttributeCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					(
						lv_qualifiers_0_0='static'
						{
							newLeafNode(lv_qualifiers_0_0, grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getAttributeCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_0_0, "static");
						}
					)
				)
				(
					(
						lv_qualifiers_1_0='definition'
						{
							newLeafNode(lv_qualifiers_1_0, grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getAttributeCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_1_0, "definition");
						}
					)
				)?
			)
			    |
			(
				(
					(
						lv_qualifiers_2_0='definition'
						{
							newLeafNode(lv_qualifiers_2_0, grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getAttributeCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_2_0, "definition");
						}
					)
				)
				(
					(
						lv_qualifiers_3_0='static'
						{
							newLeafNode(lv_qualifiers_3_0, grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getAttributeCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_3_0, "static");
						}
					)
				)?
			)
		)?
		otherlv_4='attribute'
		{
			newLeafNode(otherlv_4, grammarAccess.getAttributeCSAccess().getAttributeKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAttributeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_name_5_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAttributeCSRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6=':'
			{
				newLeafNode(otherlv_6, grammarAccess.getAttributeCSAccess().getColonKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0());
					}
					lv_ownedType_7_0=ruleTypedMultiplicityRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAttributeCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_7_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_8='='
			{
				newLeafNode(otherlv_8, grammarAccess.getAttributeCSAccess().getEqualsSignKeyword_4_0());
			}
			(
				(
					lv_default_9_0=RULE_SINGLE_QUOTED_STRING
					{
						newLeafNode(lv_default_9_0, grammarAccess.getAttributeCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAttributeCSRule());
						}
						setWithLastConsumed(
							$current,
							"default",
							lv_default_9_0,
							"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
					}
				)
			)
		)?
		(
			otherlv_10='{'
			{
				newLeafNode(otherlv_10, grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_5_0());
			}
			(
				(
					(
						(
							lv_qualifiers_11_0='derived'
							{
								newLeafNode(lv_qualifiers_11_0, grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_11_0, "derived");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_12_0='!derived'
							{
								newLeafNode(lv_qualifiers_12_0, grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_12_0, "!derived");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_13_0='id'
							{
								newLeafNode(lv_qualifiers_13_0, grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_13_0, "id");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_14_0='!id'
							{
								newLeafNode(lv_qualifiers_14_0, grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_14_0, "!id");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_15_0='ordered'
							{
								newLeafNode(lv_qualifiers_15_0, grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_15_0, "ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_16_0='!ordered'
							{
								newLeafNode(lv_qualifiers_16_0, grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_16_0, "!ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_17_0='readonly'
							{
								newLeafNode(lv_qualifiers_17_0, grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_17_0, "readonly");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_18_0='!readonly'
							{
								newLeafNode(lv_qualifiers_18_0, grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_18_0, "!readonly");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_19_0='transient'
							{
								newLeafNode(lv_qualifiers_19_0, grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_19_0, "transient");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_20_0='!transient'
							{
								newLeafNode(lv_qualifiers_20_0, grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_20_0, "!transient");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_21_0='unique'
							{
								newLeafNode(lv_qualifiers_21_0, grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_21_0, "unique");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_22_0='!unique'
							{
								newLeafNode(lv_qualifiers_22_0, grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_22_0, "!unique");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_23_0='unsettable'
							{
								newLeafNode(lv_qualifiers_23_0, grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_23_0, "unsettable");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_24_0='!unsettable'
							{
								newLeafNode(lv_qualifiers_24_0, grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_24_0, "!unsettable");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_25_0='volatile'
							{
								newLeafNode(lv_qualifiers_25_0, grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_25_0, "volatile");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_26_0='!volatile'
							{
								newLeafNode(lv_qualifiers_26_0, grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getAttributeCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_26_0, "!volatile");
							}
						)
					)
				)
				(
					otherlv_27=','
					{
						newLeafNode(otherlv_27, grammarAccess.getAttributeCSAccess().getCommaKeyword_5_1_1());
					}
				)?
			)+
			otherlv_28='}'
			{
				newLeafNode(otherlv_28, grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_5_2());
			}
		)?
		(
			(
				otherlv_29='{'
				{
					newLeafNode(otherlv_29, grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0());
				}
				(
					(
						otherlv_30='initial'
						{
							newLeafNode(otherlv_30, grammarAccess.getAttributeCSAccess().getInitialKeyword_6_0_1_0_0());
						}
						(
							{
								/* */
							}
							{
								newCompositeNode(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_0_1());
							}
							ruleUnrestrictedName
							{
								afterParserOrEnumRuleCall();
							}
						)?
						otherlv_32=':'
						{
							newLeafNode(otherlv_32, grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_0_2());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0());
								}
								lv_ownedDefaultExpressions_33_0=ruleSpecificationCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAttributeCSRule());
									}
									add(
										$current,
										"ownedDefaultExpressions",
										lv_ownedDefaultExpressions_33_0,
										"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
									afterParserOrEnumRuleCall();
								}
							)
						)?
						otherlv_34=';'
						{
							newLeafNode(otherlv_34, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_0_4());
						}
					)
					    |
					(
						otherlv_35='derivation'
						{
							newLeafNode(otherlv_35, grammarAccess.getAttributeCSAccess().getDerivationKeyword_6_0_1_1_0());
						}
						(
							{
								/* */
							}
							{
								newCompositeNode(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_1_1());
							}
							ruleUnrestrictedName
							{
								afterParserOrEnumRuleCall();
							}
						)?
						otherlv_37=':'
						{
							newLeafNode(otherlv_37, grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_1_2());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0());
								}
								lv_ownedDefaultExpressions_38_0=ruleSpecificationCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getAttributeCSRule());
									}
									add(
										$current,
										"ownedDefaultExpressions",
										lv_ownedDefaultExpressions_38_0,
										"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
									afterParserOrEnumRuleCall();
								}
							)
						)?
						otherlv_39=';'
						{
							newLeafNode(otherlv_39, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_1_4());
						}
					)
				)*
				otherlv_40='}'
				{
					newLeafNode(otherlv_40, grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2());
				}
			)
			    |
			otherlv_41=';'
			{
				newLeafNode(otherlv_41, grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_1());
			}
		)
	)
;

// Entry rule entryRuleClassCS
entryRuleClassCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getClassCSRule()); }
	iv_ruleClassCS=ruleClassCS
	{ $current=$iv_ruleClassCS.current; }
	EOF;

// Rule ClassCS
ruleClassCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getClassCSAccess().getStructuredClassCSParserRuleCall_0());
		}
		this_StructuredClassCS_0=ruleStructuredClassCS
		{
			$current = $this_StructuredClassCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getClassCSAccess().getDataTypeCSParserRuleCall_1());
		}
		this_DataTypeCS_1=ruleDataTypeCS
		{
			$current = $this_DataTypeCS_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getClassCSAccess().getEnumerationCSParserRuleCall_2());
		}
		this_EnumerationCS_2=ruleEnumerationCS
		{
			$current = $this_EnumerationCS_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleCompoundTargetElementCS
entryRuleCompoundTargetElementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCompoundTargetElementCSRule()); }
	iv_ruleCompoundTargetElementCS=ruleCompoundTargetElementCS
	{ $current=$iv_ruleCompoundTargetElementCS.current; }
	EOF;

// Rule CompoundTargetElementCS
ruleCompoundTargetElementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='{'
		{
			newLeafNode(otherlv_0, grammarAccess.getCompoundTargetElementCSAccess().getLeftCurlyBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCompoundTargetElementCSAccess().getOwnedTargetElementsSimpleTargetElementCSParserRuleCall_1_0());
				}
				lv_ownedTargetElements_1_0=ruleSimpleTargetElementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCompoundTargetElementCSRule());
					}
					add(
						$current,
						"ownedTargetElements",
						lv_ownedTargetElements_1_0,
						"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SimpleTargetElementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_2='}'
		{
			newLeafNode(otherlv_2, grammarAccess.getCompoundTargetElementCSAccess().getRightCurlyBracketKeyword_2());
		}
		(
			otherlv_3=';'
			{
				newLeafNode(otherlv_3, grammarAccess.getCompoundTargetElementCSAccess().getSemicolonKeyword_3());
			}
		)?
	)
;

// Entry rule entryRuleDataTypeCS
entryRuleDataTypeCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDataTypeCSRule()); }
	iv_ruleDataTypeCS=ruleDataTypeCS
	{ $current=$iv_ruleDataTypeCS.current; }
	EOF;

// Rule DataTypeCS
ruleDataTypeCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_isPrimitive_0_0='primitive'
				{
					newLeafNode(lv_isPrimitive_0_0, grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDataTypeCSRule());
					}
					setWithLastConsumed($current, "isPrimitive", lv_isPrimitive_0_0 != null, "primitive");
				}
			)
		)?
		otherlv_1='datatype'
		{
			newLeafNode(otherlv_1, grammarAccess.getDataTypeCSAccess().getDatatypeKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDataTypeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_name_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDataTypeCSRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getDataTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());
				}
				lv_ownedSignature_3_0=ruleTemplateSignatureCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDataTypeCSRule());
					}
					set(
						$current,
						"ownedSignature",
						lv_ownedSignature_3_0,
						"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_4=':'
			{
				newLeafNode(otherlv_4, grammarAccess.getDataTypeCSAccess().getColonKeyword_4_0());
			}
			(
				(
					lv_instanceClassName_5_0=RULE_SINGLE_QUOTED_STRING
					{
						newLeafNode(lv_instanceClassName_5_0, grammarAccess.getDataTypeCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getDataTypeCSRule());
						}
						setWithLastConsumed(
							$current,
							"instanceClassName",
							lv_instanceClassName_5_0,
							"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
					}
				)
			)
		)?
		(
			otherlv_6='{'
			{
				newLeafNode(otherlv_6, grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_5_0());
			}
			(
				(
					(
						lv_isSerializable_7_0='serializable'
						{
							newLeafNode(lv_isSerializable_7_0, grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getDataTypeCSRule());
							}
							setWithLastConsumed($current, "isSerializable", lv_isSerializable_7_0 != null, "serializable");
						}
					)
				)
				    |
				otherlv_8='!serializable'
				{
					newLeafNode(otherlv_8, grammarAccess.getDataTypeCSAccess().getSerializableKeyword_5_1_1());
				}
			)?
			otherlv_9='}'
			{
				newLeafNode(otherlv_9, grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_5_2());
			}
		)?
		(
			(
				otherlv_10='{'
				{
					newLeafNode(otherlv_10, grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0());
				}
				otherlv_11='}'
				{
					newLeafNode(otherlv_11, grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_1());
				}
			)
			    |
			otherlv_12=';'
			{
				newLeafNode(otherlv_12, grammarAccess.getDataTypeCSAccess().getSemicolonKeyword_6_1());
			}
		)
	)
;

// Entry rule entryRuleEnumerationCS
entryRuleEnumerationCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumerationCSRule()); }
	iv_ruleEnumerationCS=ruleEnumerationCS
	{ $current=$iv_ruleEnumerationCS.current; }
	EOF;

// Rule EnumerationCS
ruleEnumerationCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='enum'
		{
			newLeafNode(otherlv_0, grammarAccess.getEnumerationCSAccess().getEnumKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationCSAccess().getNameUnrestrictedNameParserRuleCall_1_0());
				}
				lv_name_1_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEnumerationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0());
				}
				lv_ownedSignature_2_0=ruleTemplateSignatureCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
					}
					set(
						$current,
						"ownedSignature",
						lv_ownedSignature_2_0,
						"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_3=':'
			{
				newLeafNode(otherlv_3, grammarAccess.getEnumerationCSAccess().getColonKeyword_3_0());
			}
			(
				(
					lv_instanceClassName_4_0=RULE_SINGLE_QUOTED_STRING
					{
						newLeafNode(lv_instanceClassName_4_0, grammarAccess.getEnumerationCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEnumerationCSRule());
						}
						setWithLastConsumed(
							$current,
							"instanceClassName",
							lv_instanceClassName_4_0,
							"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
					}
				)
			)
		)?
		(
			otherlv_5='{'
			{
				newLeafNode(otherlv_5, grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_4_0());
			}
			(
				(
					(
						lv_isSerializable_6_0='serializable'
						{
							newLeafNode(lv_isSerializable_6_0, grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getEnumerationCSRule());
							}
							setWithLastConsumed($current, "isSerializable", lv_isSerializable_6_0 != null, "serializable");
						}
					)
				)
				    |
				otherlv_7='!serializable'
				{
					newLeafNode(otherlv_7, grammarAccess.getEnumerationCSAccess().getSerializableKeyword_4_1_1());
				}
			)?
			otherlv_8='}'
			{
				newLeafNode(otherlv_8, grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_4_2());
			}
		)?
		(
			(
				otherlv_9='{'
				{
					newLeafNode(otherlv_9, grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_5_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0());
						}
						lv_ownedLiterals_10_0=ruleEnumerationLiteralCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEnumerationCSRule());
							}
							add(
								$current,
								"ownedLiterals",
								lv_ownedLiterals_10_0,
								"org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralCS");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				otherlv_11='}'
				{
					newLeafNode(otherlv_11, grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_5_0_2());
				}
			)
			    |
			otherlv_12=';'
			{
				newLeafNode(otherlv_12, grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_5_1());
			}
		)
	)
;

// Entry rule entryRuleEnumerationLiteralCS
entryRuleEnumerationLiteralCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumerationLiteralCSRule()); }
	iv_ruleEnumerationLiteralCS=ruleEnumerationLiteralCS
	{ $current=$iv_ruleEnumerationLiteralCS.current; }
	EOF;

// Rule EnumerationLiteralCS
ruleEnumerationLiteralCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				otherlv_0='literal'
				{
					newLeafNode(otherlv_0, grammarAccess.getEnumerationLiteralCSAccess().getLiteralKeyword_0_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_1_0());
						}
						lv_name_1_0=ruleUnrestrictedName
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
							}
							set(
								$current,
								"name",
								lv_name_1_0,
								"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getNameEnumerationLiteralNameParserRuleCall_0_1_0());
					}
					lv_name_2_0=ruleEnumerationLiteralName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
						}
						set(
							$current,
							"name",
							lv_name_2_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.EnumerationLiteralName");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		(
			otherlv_3='='
			{
				newLeafNode(otherlv_3, grammarAccess.getEnumerationLiteralCSAccess().getEqualsSignKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumerationLiteralCSAccess().getValueSIGNEDParserRuleCall_1_1_0());
					}
					lv_value_4_0=ruleSIGNED
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumerationLiteralCSRule());
						}
						set(
							$current,
							"value",
							lv_value_4_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SIGNED");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				otherlv_5='{'
				{
					newLeafNode(otherlv_5, grammarAccess.getEnumerationLiteralCSAccess().getLeftCurlyBracketKeyword_2_0_0());
				}
				otherlv_6='}'
				{
					newLeafNode(otherlv_6, grammarAccess.getEnumerationLiteralCSAccess().getRightCurlyBracketKeyword_2_0_1());
				}
			)
			    |
			otherlv_7=';'
			{
				newLeafNode(otherlv_7, grammarAccess.getEnumerationLiteralCSAccess().getSemicolonKeyword_2_1());
			}
		)
	)
;

// Entry rule entryRuleOperationCS
entryRuleOperationCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOperationCSRule()); }
	iv_ruleOperationCS=ruleOperationCS
	{ $current=$iv_ruleOperationCS.current; }
	EOF;

// Rule OperationCS
ruleOperationCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					(
						lv_qualifiers_0_0='static'
						{
							newLeafNode(lv_qualifiers_0_0, grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOperationCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_0_0, "static");
						}
					)
				)
				(
					(
						lv_qualifiers_1_0='definition'
						{
							newLeafNode(lv_qualifiers_1_0, grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOperationCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_1_0, "definition");
						}
					)
				)?
			)
			    |
			(
				(
					(
						lv_qualifiers_2_0='definition'
						{
							newLeafNode(lv_qualifiers_2_0, grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOperationCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_2_0, "definition");
						}
					)
				)
				(
					(
						lv_qualifiers_3_0='static'
						{
							newLeafNode(lv_qualifiers_3_0, grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOperationCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_3_0, "static");
						}
					)
				)?
			)
		)?
		otherlv_4='operation'
		{
			newLeafNode(otherlv_4, grammarAccess.getOperationCSAccess().getOperationKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0());
				}
				lv_ownedSignature_5_0=ruleTemplateSignatureCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOperationCSRule());
					}
					set(
						$current,
						"ownedSignature",
						lv_ownedSignature_5_0,
						"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getOperationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0());
				}
				lv_name_6_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOperationCSRule());
					}
					set(
						$current,
						"name",
						lv_name_6_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='('
		{
			newLeafNode(otherlv_7, grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_4());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0());
					}
					lv_ownedParameters_8_0=ruleParameterCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOperationCSRule());
						}
						add(
							$current,
							"ownedParameters",
							lv_ownedParameters_8_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.ParameterCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_9=','
				{
					newLeafNode(otherlv_9, grammarAccess.getOperationCSAccess().getCommaKeyword_5_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0());
						}
						lv_ownedParameters_10_0=ruleParameterCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOperationCSRule());
							}
							add(
								$current,
								"ownedParameters",
								lv_ownedParameters_10_0,
								"org.eclipse.qvtd.xtext.qvtbase.QVTbase.ParameterCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_11=')'
		{
			newLeafNode(otherlv_11, grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_6());
		}
		(
			otherlv_12=':'
			{
				newLeafNode(otherlv_12, grammarAccess.getOperationCSAccess().getColonKeyword_7_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0());
					}
					lv_ownedType_13_0=ruleTypedMultiplicityRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOperationCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_13_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_14='throws'
			{
				newLeafNode(otherlv_14, grammarAccess.getOperationCSAccess().getThrowsKeyword_8_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0());
					}
					lv_ownedExceptions_15_0=ruleTypedRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOperationCSRule());
						}
						add(
							$current,
							"ownedExceptions",
							lv_ownedExceptions_15_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_16=','
				{
					newLeafNode(otherlv_16, grammarAccess.getOperationCSAccess().getCommaKeyword_8_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0());
						}
						lv_ownedExceptions_17_0=ruleTypedRefCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getOperationCSRule());
							}
							add(
								$current,
								"ownedExceptions",
								lv_ownedExceptions_17_0,
								"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			otherlv_18='{'
			{
				newLeafNode(otherlv_18, grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0());
			}
			(
				(
					(
						(
							lv_qualifiers_19_0='derived'
							{
								newLeafNode(lv_qualifiers_19_0, grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getOperationCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_19_0, "derived");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_20_0='!derived'
							{
								newLeafNode(lv_qualifiers_20_0, grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getOperationCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_20_0, "!derived");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_21_0='ordered'
							{
								newLeafNode(lv_qualifiers_21_0, grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getOperationCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_21_0, "ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_22_0='!ordered'
							{
								newLeafNode(lv_qualifiers_22_0, grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getOperationCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_22_0, "!ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_23_0='unique'
							{
								newLeafNode(lv_qualifiers_23_0, grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_4_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getOperationCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_23_0, "unique");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_24_0='!unique'
							{
								newLeafNode(lv_qualifiers_24_0, grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_5_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getOperationCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_24_0, "!unique");
							}
						)
					)
				)
				(
					otherlv_25=','
					{
						newLeafNode(otherlv_25, grammarAccess.getOperationCSAccess().getCommaKeyword_9_1_1());
					}
				)?
			)+
			otherlv_26='}'
			{
				newLeafNode(otherlv_26, grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_9_2());
			}
		)?
		(
			(
				otherlv_27='{'
				{
					newLeafNode(otherlv_27, grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_10_0_0());
				}
				(
					otherlv_28='body'
					{
						newLeafNode(otherlv_28, grammarAccess.getOperationCSAccess().getBodyKeyword_10_0_1_0());
					}
					(
						{
							/* */
						}
						{
							newCompositeNode(grammarAccess.getOperationCSAccess().getUnrestrictedNameParserRuleCall_10_0_1_1());
						}
						ruleUnrestrictedName
						{
							afterParserOrEnumRuleCall();
						}
					)?
					otherlv_30=':'
					{
						newLeafNode(otherlv_30, grammarAccess.getOperationCSAccess().getColonKeyword_10_0_1_2());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0());
							}
							lv_ownedBodyExpressions_31_0=ruleSpecificationCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getOperationCSRule());
								}
								add(
									$current,
									"ownedBodyExpressions",
									lv_ownedBodyExpressions_31_0,
									"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
								afterParserOrEnumRuleCall();
							}
						)
					)?
					otherlv_32=';'
					{
						newLeafNode(otherlv_32, grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_0_1_4());
					}
				)*
				otherlv_33='}'
				{
					newLeafNode(otherlv_33, grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_10_0_2());
				}
			)
			    |
			otherlv_34=';'
			{
				newLeafNode(otherlv_34, grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_1());
			}
		)
	)
;

// Entry rule entryRuleParameterCS
entryRuleParameterCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterCSRule()); }
	iv_ruleParameterCS=ruleParameterCS
	{ $current=$iv_ruleParameterCS.current; }
	EOF;

// Rule ParameterCS
ruleParameterCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getParameterCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=':'
			{
				newLeafNode(otherlv_1, grammarAccess.getParameterCSAccess().getColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0());
					}
					lv_ownedType_2_0=ruleTypedMultiplicityRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getParameterCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_2_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_3='{'
			{
				newLeafNode(otherlv_3, grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_2_0());
			}
			(
				(
					(
						(
							lv_qualifiers_4_0='ordered'
							{
								newLeafNode(lv_qualifiers_4_0, grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getParameterCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_4_0, "ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_5_0='!ordered'
							{
								newLeafNode(lv_qualifiers_5_0, grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getParameterCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_5_0, "!ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_6_0='unique'
							{
								newLeafNode(lv_qualifiers_6_0, grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getParameterCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_6_0, "unique");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_7_0='!unique'
							{
								newLeafNode(lv_qualifiers_7_0, grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getParameterCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_7_0, "!unique");
							}
						)
					)
				)
				(
					otherlv_8=','
					{
						newLeafNode(otherlv_8, grammarAccess.getParameterCSAccess().getCommaKeyword_2_1_1());
					}
				)?
			)+
			otherlv_9='}'
			{
				newLeafNode(otherlv_9, grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_2_2());
			}
		)?
		(
			otherlv_10='{'
			{
				newLeafNode(otherlv_10, grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_3_0());
			}
			otherlv_11='}'
			{
				newLeafNode(otherlv_11, grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_3_1());
			}
		)?
	)
;

// Entry rule entryRuleReferenceCS
entryRuleReferenceCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReferenceCSRule()); }
	iv_ruleReferenceCS=ruleReferenceCS
	{ $current=$iv_ruleReferenceCS.current; }
	EOF;

// Rule ReferenceCS
ruleReferenceCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					(
						lv_qualifiers_0_0='static'
						{
							newLeafNode(lv_qualifiers_0_0, grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getReferenceCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_0_0, "static");
						}
					)
				)
				(
					(
						lv_qualifiers_1_0='definition'
						{
							newLeafNode(lv_qualifiers_1_0, grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getReferenceCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_1_0, "definition");
						}
					)
				)?
			)
			    |
			(
				(
					(
						lv_qualifiers_2_0='definition'
						{
							newLeafNode(lv_qualifiers_2_0, grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getReferenceCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_2_0, "definition");
						}
					)
				)
				(
					(
						lv_qualifiers_3_0='static'
						{
							newLeafNode(lv_qualifiers_3_0, grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getReferenceCSRule());
							}
							addWithLastConsumed($current, "qualifiers", lv_qualifiers_3_0, "static");
						}
					)
				)?
			)
		)?
		otherlv_4='property'
		{
			newLeafNode(otherlv_4, grammarAccess.getReferenceCSAccess().getPropertyKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getReferenceCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_name_5_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReferenceCSRule());
					}
					set(
						$current,
						"name",
						lv_name_5_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6='#'
			{
				newLeafNode(otherlv_6, grammarAccess.getReferenceCSAccess().getNumberSignKeyword_3_0());
			}
			(
				(
					{
						/* */
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReferenceCSRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyCrossReference_3_1_0());
					}
					ruleUnrestrictedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_8=':'
			{
				newLeafNode(otherlv_8, grammarAccess.getReferenceCSAccess().getColonKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0());
					}
					lv_ownedType_9_0=ruleTypedMultiplicityRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getReferenceCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_9_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedMultiplicityRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_10='='
			{
				newLeafNode(otherlv_10, grammarAccess.getReferenceCSAccess().getEqualsSignKeyword_5_0());
			}
			(
				(
					lv_default_11_0=RULE_SINGLE_QUOTED_STRING
					{
						newLeafNode(lv_default_11_0, grammarAccess.getReferenceCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReferenceCSRule());
						}
						setWithLastConsumed(
							$current,
							"default",
							lv_default_11_0,
							"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
					}
				)
			)
		)?
		(
			otherlv_12='{'
			{
				newLeafNode(otherlv_12, grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_6_0());
			}
			(
				(
					(
						(
							lv_qualifiers_13_0='composes'
							{
								newLeafNode(lv_qualifiers_13_0, grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_13_0, "composes");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_14_0='!composes'
							{
								newLeafNode(lv_qualifiers_14_0, grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_14_0, "!composes");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_15_0='derived'
							{
								newLeafNode(lv_qualifiers_15_0, grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_15_0, "derived");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_16_0='!derived'
							{
								newLeafNode(lv_qualifiers_16_0, grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_16_0, "!derived");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_17_0='ordered'
							{
								newLeafNode(lv_qualifiers_17_0, grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_17_0, "ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_18_0='!ordered'
							{
								newLeafNode(lv_qualifiers_18_0, grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_18_0, "!ordered");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_19_0='readonly'
							{
								newLeafNode(lv_qualifiers_19_0, grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_19_0, "readonly");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_20_0='!readonly'
							{
								newLeafNode(lv_qualifiers_20_0, grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_20_0, "!readonly");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_21_0='resolve'
							{
								newLeafNode(lv_qualifiers_21_0, grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_21_0, "resolve");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_22_0='!resolve'
							{
								newLeafNode(lv_qualifiers_22_0, grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_22_0, "!resolve");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_23_0='transient'
							{
								newLeafNode(lv_qualifiers_23_0, grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_23_0, "transient");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_24_0='!transient'
							{
								newLeafNode(lv_qualifiers_24_0, grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_24_0, "!transient");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_25_0='unique'
							{
								newLeafNode(lv_qualifiers_25_0, grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_25_0, "unique");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_26_0='!unique'
							{
								newLeafNode(lv_qualifiers_26_0, grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_26_0, "!unique");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_27_0='unsettable'
							{
								newLeafNode(lv_qualifiers_27_0, grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_27_0, "unsettable");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_28_0='!unsettable'
							{
								newLeafNode(lv_qualifiers_28_0, grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_28_0, "!unsettable");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_29_0='volatile'
							{
								newLeafNode(lv_qualifiers_29_0, grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_29_0, "volatile");
							}
						)
					)
					    |
					(
						(
							lv_qualifiers_30_0='!volatile'
							{
								newLeafNode(lv_qualifiers_30_0, grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getReferenceCSRule());
								}
								addWithLastConsumed($current, "qualifiers", lv_qualifiers_30_0, "!volatile");
							}
						)
					)
				)
				(
					otherlv_31=','
					{
						newLeafNode(otherlv_31, grammarAccess.getReferenceCSAccess().getCommaKeyword_6_1_1());
					}
				)?
			)+
			otherlv_32='}'
			{
				newLeafNode(otherlv_32, grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_6_2());
			}
		)?
		(
			(
				otherlv_33='{'
				{
					newLeafNode(otherlv_33, grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0());
				}
				(
					(
						otherlv_34='initial'
						{
							newLeafNode(otherlv_34, grammarAccess.getReferenceCSAccess().getInitialKeyword_7_0_1_0_0());
						}
						(
							{
								/* */
							}
							{
								newCompositeNode(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_0_1());
							}
							ruleUnrestrictedName
							{
								afterParserOrEnumRuleCall();
							}
						)?
						otherlv_36=':'
						{
							newLeafNode(otherlv_36, grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_0_2());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0());
								}
								lv_ownedDefaultExpressions_37_0=ruleSpecificationCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getReferenceCSRule());
									}
									add(
										$current,
										"ownedDefaultExpressions",
										lv_ownedDefaultExpressions_37_0,
										"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
									afterParserOrEnumRuleCall();
								}
							)
						)?
						otherlv_38=';'
						{
							newLeafNode(otherlv_38, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_0_4());
						}
					)
					    |
					(
						otherlv_39='derivation'
						{
							newLeafNode(otherlv_39, grammarAccess.getReferenceCSAccess().getDerivationKeyword_7_0_1_1_0());
						}
						(
							{
								/* */
							}
							{
								newCompositeNode(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_1_1());
							}
							ruleUnrestrictedName
							{
								afterParserOrEnumRuleCall();
							}
						)?
						otherlv_41=':'
						{
							newLeafNode(otherlv_41, grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_1_2());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0());
								}
								lv_ownedDefaultExpressions_42_0=ruleSpecificationCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getReferenceCSRule());
									}
									add(
										$current,
										"ownedDefaultExpressions",
										lv_ownedDefaultExpressions_42_0,
										"org.eclipse.qvtd.xtext.qvtbase.QVTbase.SpecificationCS");
									afterParserOrEnumRuleCall();
								}
							)
						)?
						otherlv_43=';'
						{
							newLeafNode(otherlv_43, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_1_4());
						}
					)
				)*
				otherlv_44='}'
				{
					newLeafNode(otherlv_44, grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2());
				}
			)
			    |
			otherlv_45=';'
			{
				newLeafNode(otherlv_45, grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_1());
			}
		)
	)
;

// Entry rule entryRuleSimpleTargetElementCS
entryRuleSimpleTargetElementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSimpleTargetElementCSRule()); }
	iv_ruleSimpleTargetElementCS=ruleSimpleTargetElementCS
	{ $current=$iv_ruleSimpleTargetElementCS.current; }
	EOF;

// Rule SimpleTargetElementCS
ruleSimpleTargetElementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					lv_input_0_0='input'
					{
						newLeafNode(lv_input_0_0, grammarAccess.getSimpleTargetElementCSAccess().getInputInputKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
						}
						setWithLastConsumed($current, "input", lv_input_0_0 != null, "input");
					}
				)
			)
			    |
			(
				(
					lv_output_1_0='output'
					{
						newLeafNode(lv_output_1_0, grammarAccess.getSimpleTargetElementCSAccess().getOutputOutputKeyword_0_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
						}
						setWithLastConsumed($current, "output", lv_output_1_0 != null, "output");
					}
				)
			)
			    |
			(
				(
					lv_via_2_0='via'
					{
						newLeafNode(lv_via_2_0, grammarAccess.getSimpleTargetElementCSAccess().getViaViaKeyword_0_2_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
						}
						setWithLastConsumed($current, "via", lv_via_2_0 != null, "via");
					}
				)
			)
		)
		(
			(
				{
					/* */
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getTypedModelTypedModelCrossReference_1_0());
				}
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4='iterates'
			{
				newLeafNode(otherlv_4, grammarAccess.getSimpleTargetElementCSAccess().getIteratesKeyword_2_0());
			}
			(
				(
					(
						{
							/* */
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getIteratesTypedModelCrossReference_2_1_0_0());
						}
						ruleUnrestrictedName
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				    |
				(
					otherlv_6='{'
					{
						newLeafNode(otherlv_6, grammarAccess.getSimpleTargetElementCSAccess().getLeftCurlyBracketKeyword_2_1_1_0());
					}
					(
						(
							(
								{
									/* */
								}
								{
									if ($current==null) {
										$current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
									}
								}
								{
									newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getIteratesTypedModelCrossReference_2_1_1_1_0_0());
								}
								ruleUnrestrictedName
								{
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							otherlv_8=','
							{
								newLeafNode(otherlv_8, grammarAccess.getSimpleTargetElementCSAccess().getCommaKeyword_2_1_1_1_1_0());
							}
							(
								(
									{
										/* */
									}
									{
										if ($current==null) {
											$current = createModelElement(grammarAccess.getSimpleTargetElementCSRule());
										}
									}
									{
										newCompositeNode(grammarAccess.getSimpleTargetElementCSAccess().getIteratesTypedModelCrossReference_2_1_1_1_1_1_0());
									}
									ruleUnrestrictedName
									{
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
					)?
					otherlv_10='}'
					{
						newLeafNode(otherlv_10, grammarAccess.getSimpleTargetElementCSAccess().getRightCurlyBracketKeyword_2_1_1_2());
					}
				)
			)
		)?
		otherlv_11=';'
		{
			newLeafNode(otherlv_11, grammarAccess.getSimpleTargetElementCSAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleSpecificationCS
entryRuleSpecificationCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSpecificationCSRule()); }
	iv_ruleSpecificationCS=ruleSpecificationCS
	{ $current=$iv_ruleSpecificationCS.current; }
	EOF;

// Rule SpecificationCS
ruleSpecificationCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0());
				}
				lv_ownedExpression_0_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSpecificationCSRule());
					}
					set(
						$current,
						"ownedExpression",
						lv_ownedExpression_0_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				lv_exprString_1_0=RULE_UNQUOTED_STRING
				{
					newLeafNode(lv_exprString_1_0, grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSpecificationCSRule());
					}
					setWithLastConsumed(
						$current,
						"exprString",
						lv_exprString_1_0,
						"org.eclipse.qvtd.xtext.qvtbase.QVTbase.UNQUOTED_STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleStructuredClassCS
entryRuleStructuredClassCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructuredClassCSRule()); }
	iv_ruleStructuredClassCS=ruleStructuredClassCS
	{ $current=$iv_ruleStructuredClassCS.current; }
	EOF;

// Rule StructuredClassCS
ruleStructuredClassCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_isAbstract_0_0='abstract'
				{
					newLeafNode(lv_isAbstract_0_0, grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructuredClassCSRule());
					}
					setWithLastConsumed($current, "isAbstract", lv_isAbstract_0_0 != null, "abstract");
				}
			)
		)?
		otherlv_1='class'
		{
			newLeafNode(otherlv_1, grammarAccess.getStructuredClassCSAccess().getClassKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStructuredClassCSAccess().getNameUnrestrictedNameParserRuleCall_2_0());
				}
				lv_name_2_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
					}
					set(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0());
				}
				lv_ownedSignature_3_0=ruleTemplateSignatureCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
					}
					set(
						$current,
						"ownedSignature",
						lv_ownedSignature_3_0,
						"org.eclipse.ocl.xtext.base.Base.TemplateSignatureCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_4='extends'
			{
				newLeafNode(otherlv_4, grammarAccess.getStructuredClassCSAccess().getExtendsKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0());
					}
					lv_ownedSuperTypes_5_0=ruleTypedRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
						}
						add(
							$current,
							"ownedSuperTypes",
							lv_ownedSuperTypes_5_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_6=','
				{
					newLeafNode(otherlv_6, grammarAccess.getStructuredClassCSAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0());
						}
						lv_ownedSuperTypes_7_0=ruleTypedRefCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
							}
							add(
								$current,
								"ownedSuperTypes",
								lv_ownedSuperTypes_7_0,
								"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			otherlv_8=':'
			{
				newLeafNode(otherlv_8, grammarAccess.getStructuredClassCSAccess().getColonKeyword_5_0());
			}
			(
				(
					lv_instanceClassName_9_0=RULE_SINGLE_QUOTED_STRING
					{
						newLeafNode(lv_instanceClassName_9_0, grammarAccess.getStructuredClassCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getStructuredClassCSRule());
						}
						setWithLastConsumed(
							$current,
							"instanceClassName",
							lv_instanceClassName_9_0,
							"org.eclipse.ocl.xtext.base.Base.SINGLE_QUOTED_STRING");
					}
				)
			)
		)?
		(
			otherlv_10='{'
			{
				newLeafNode(otherlv_10, grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_6_0());
			}
			(
				(
					lv_isInterface_11_0='interface'
					{
						newLeafNode(lv_isInterface_11_0, grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getStructuredClassCSRule());
						}
						setWithLastConsumed($current, "isInterface", lv_isInterface_11_0 != null, "interface");
					}
				)
			)?
			otherlv_12='}'
			{
				newLeafNode(otherlv_12, grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_6_2());
			}
		)?
		(
			(
				otherlv_13='{'
				{
					newLeafNode(otherlv_13, grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_7_0_0());
				}
				(
					(
						(
							{
								newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0());
							}
							lv_ownedOperations_14_0=ruleOperationCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
								}
								add(
									$current,
									"ownedOperations",
									lv_ownedOperations_14_0,
									"org.eclipse.qvtd.xtext.qvtbase.QVTbase.OperationCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
					    |
					(
						(
							{
								newCompositeNode(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0());
							}
							lv_ownedProperties_15_0=ruleStructuralFeatureCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getStructuredClassCSRule());
								}
								add(
									$current,
									"ownedProperties",
									lv_ownedProperties_15_0,
									"org.eclipse.qvtd.xtext.qvtbase.QVTbase.StructuralFeatureCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
				otherlv_16='}'
				{
					newLeafNode(otherlv_16, grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_7_0_2());
				}
			)
			    |
			otherlv_17=';'
			{
				newLeafNode(otherlv_17, grammarAccess.getStructuredClassCSAccess().getSemicolonKeyword_7_1());
			}
		)
	)
;

// Entry rule entryRuleTypedMultiplicityRefCS
entryRuleTypedMultiplicityRefCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypedMultiplicityRefCSRule()); }
	iv_ruleTypedMultiplicityRefCS=ruleTypedMultiplicityRefCS
	{ $current=$iv_ruleTypedMultiplicityRefCS.current; }
	EOF;

// Rule TypedMultiplicityRefCS
ruleTypedMultiplicityRefCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedRefCSParserRuleCall_0());
		}
		this_TypedRefCS_0=ruleTypedRefCS
		{
			$current = $this_TypedRefCS_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());
				}
				lv_ownedMultiplicity_1_0=ruleMultiplicityCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypedMultiplicityRefCSRule());
					}
					set(
						$current,
						"ownedMultiplicity",
						lv_ownedMultiplicity_1_0,
						"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleTypedRefCS
entryRuleTypedRefCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypedRefCSRule()); }
	iv_ruleTypedRefCS=ruleTypedRefCS
	{ $current=$iv_ruleTypedRefCS.current; }
	EOF;

// Rule TypedRefCS
ruleTypedRefCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypeLiteralCSParserRuleCall_0());
		}
		this_TypeLiteralCS_0=ruleTypeLiteralCS
		{
			$current = $this_TypeLiteralCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall_1());
		}
		this_TypedTypeRefCS_1=ruleTypedTypeRefCS
		{
			$current = $this_TypedTypeRefCS_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleStructuralFeatureCS
entryRuleStructuralFeatureCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructuralFeatureCSRule()); }
	iv_ruleStructuralFeatureCS=ruleStructuralFeatureCS
	{ $current=$iv_ruleStructuralFeatureCS.current; }
	EOF;

// Rule StructuralFeatureCS
ruleStructuralFeatureCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStructuralFeatureCSAccess().getAttributeCSParserRuleCall_0());
		}
		this_AttributeCS_0=ruleAttributeCS
		{
			$current = $this_AttributeCS_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getStructuralFeatureCSAccess().getReferenceCSParserRuleCall_1());
		}
		this_ReferenceCS_1=ruleReferenceCS
		{
			$current = $this_ReferenceCS_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleEnumerationLiteralName
entryRuleEnumerationLiteralName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEnumerationLiteralNameRule()); }
	iv_ruleEnumerationLiteralName=ruleEnumerationLiteralName
	{ $current=$iv_ruleEnumerationLiteralName.current.getText(); }
	EOF;

// Rule EnumerationLiteralName
ruleEnumerationLiteralName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getEnumerationLiteralNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall());
	}
	this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName
	{
		$current.merge(this_EssentialOCLUnrestrictedName_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleQVTbaseUnrestrictedName
entryRuleQVTbaseUnrestrictedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQVTbaseUnrestrictedNameRule()); }
	iv_ruleQVTbaseUnrestrictedName=ruleQVTbaseUnrestrictedName
	{ $current=$iv_ruleQVTbaseUnrestrictedName.current.getText(); }
	EOF;

// Rule QVTbaseUnrestrictedName
ruleQVTbaseUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='abstract'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getAbstractKeyword_0());
		}
		    |
		kw='attribute'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getAttributeKeyword_1());
		}
		    |
		kw='body'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getBodyKeyword_2());
		}
		    |
		kw='class'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getClassKeyword_3());
		}
		    |
		kw='composes'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getComposesKeyword_4());
		}
		    |
		kw='datatype'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getDatatypeKeyword_5());
		}
		    |
		kw='definition'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getDefinitionKeyword_6());
		}
		    |
		kw='derived'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getDerivedKeyword_7());
		}
		    |
		kw='derivation'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getDerivationKeyword_8());
		}
		    |
		kw='enum'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getEnumKeyword_9());
		}
		    |
		kw='extends'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getExtendsKeyword_10());
		}
		    |
		kw='id'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getIdKeyword_11());
		}
		    |
		kw='initial'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getInitialKeyword_12());
		}
		    |
		kw='interface'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getInterfaceKeyword_13());
		}
		    |
		kw='literal'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getLiteralKeyword_14());
		}
		    |
		kw='operation'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getOperationKeyword_15());
		}
		    |
		kw='ordered'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getOrderedKeyword_16());
		}
		    |
		kw='primitive'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getPrimitiveKeyword_17());
		}
		    |
		kw='property'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getPropertyKeyword_18());
		}
		    |
		kw='readonly'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getReadonlyKeyword_19());
		}
		    |
		kw='resolve'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getResolveKeyword_20());
		}
		    |
		kw='serializable'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getSerializableKeyword_21());
		}
		    |
		kw='static'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getStaticKeyword_22());
		}
		    |
		kw='throws'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getThrowsKeyword_23());
		}
		    |
		kw='transient'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getTransientKeyword_24());
		}
		    |
		kw='unique'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getUniqueKeyword_25());
		}
		    |
		kw='unsettable'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getUnsettableKeyword_26());
		}
		    |
		kw='volatile'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getQVTbaseUnrestrictedNameAccess().getVolatileKeyword_27());
		}
	)
;

// Entry rule entryRuleSIGNED
entryRuleSIGNED returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSIGNEDRule()); }
	iv_ruleSIGNED=ruleSIGNED
	{ $current=$iv_ruleSIGNED.current.getText(); }
	EOF;

// Rule SIGNED
ruleSIGNED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSIGNEDAccess().getHyphenMinusKeyword_0());
			}
		)?
		this_INT_1=RULE_INT
		{
			$current.merge(this_INT_1);
		}
		{
			newLeafNode(this_INT_1, grammarAccess.getSIGNEDAccess().getINTTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleEssentialOCLUnaryOperatorName
entryRuleEssentialOCLUnaryOperatorName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); }
	iv_ruleEssentialOCLUnaryOperatorName=ruleEssentialOCLUnaryOperatorName
	{ $current=$iv_ruleEssentialOCLUnaryOperatorName.current.getText(); }
	EOF;

// Rule EssentialOCLUnaryOperatorName
ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
		    |
		kw='not2'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNot2Keyword_2());
		}
	)
;

// Entry rule entryRuleEssentialOCLInfixOperatorName
entryRuleEssentialOCLInfixOperatorName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorNameRule()); }
	iv_ruleEssentialOCLInfixOperatorName=ruleEssentialOCLInfixOperatorName
	{ $current=$iv_ruleEssentialOCLInfixOperatorName.current.getText(); }
	EOF;

// Rule EssentialOCLInfixOperatorName
ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
		kw='and2'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAnd2Keyword_11());
		}
		    |
		kw='implies'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_12());
		}
		    |
		kw='implies2'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImplies2Keyword_13());
		}
		    |
		kw='or'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_14());
		}
		    |
		kw='or2'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOr2Keyword_15());
		}
		    |
		kw='xor'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_16());
		}
		    |
		kw='xor2'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXor2Keyword_17());
		}
	)
;

// Entry rule entryRuleEssentialOCLNavigationOperatorName
entryRuleEssentialOCLNavigationOperatorName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); }
	iv_ruleEssentialOCLNavigationOperatorName=ruleEssentialOCLNavigationOperatorName
	{ $current=$iv_ruleEssentialOCLNavigationOperatorName.current.getText(); }
	EOF;

// Rule EssentialOCLNavigationOperatorName
ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRuleBinaryOperatorName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getBinaryOperatorNameRule()); }
	iv_ruleBinaryOperatorName=ruleBinaryOperatorName
	{ $current=$iv_ruleBinaryOperatorName.current.getText(); }
	EOF;

// Rule BinaryOperatorName
ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0());
		}
		this_InfixOperatorName_0=ruleInfixOperatorName
		{
			$current.merge(this_InfixOperatorName_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1());
		}
		this_NavigationOperatorName_1=ruleNavigationOperatorName
		{
			$current.merge(this_NavigationOperatorName_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleInfixOperatorName
entryRuleInfixOperatorName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInfixOperatorNameRule()); }
	iv_ruleInfixOperatorName=ruleInfixOperatorName
	{ $current=$iv_ruleInfixOperatorName.current.getText(); }
	EOF;

// Rule InfixOperatorName
ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall());
	}
	this_EssentialOCLInfixOperatorName_0=ruleEssentialOCLInfixOperatorName
	{
		$current.merge(this_EssentialOCLInfixOperatorName_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleNavigationOperatorName
entryRuleNavigationOperatorName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getNavigationOperatorNameRule()); }
	iv_ruleNavigationOperatorName=ruleNavigationOperatorName
	{ $current=$iv_ruleNavigationOperatorName.current.getText(); }
	EOF;

// Rule NavigationOperatorName
ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall());
	}
	this_EssentialOCLNavigationOperatorName_0=ruleEssentialOCLNavigationOperatorName
	{
		$current.merge(this_EssentialOCLNavigationOperatorName_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleUnaryOperatorName
entryRuleUnaryOperatorName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUnaryOperatorNameRule()); }
	iv_ruleUnaryOperatorName=ruleUnaryOperatorName
	{ $current=$iv_ruleUnaryOperatorName.current.getText(); }
	EOF;

// Rule UnaryOperatorName
ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall());
	}
	this_EssentialOCLUnaryOperatorName_0=ruleEssentialOCLUnaryOperatorName
	{
		$current.merge(this_EssentialOCLUnaryOperatorName_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleEssentialOCLUnrestrictedName
entryRuleEssentialOCLUnrestrictedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); }
	iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName
	{ $current=$iv_ruleEssentialOCLUnrestrictedName.current.getText(); }
	EOF;

// Rule EssentialOCLUnrestrictedName
ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall());
	}
	this_Identifier_0=ruleIdentifier
	{
		$current.merge(this_Identifier_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleEssentialOCLUnreservedName
entryRuleEssentialOCLUnreservedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); }
	iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName
	{ $current=$iv_ruleEssentialOCLUnreservedName.current.getText(); }
	EOF;

// Rule EssentialOCLUnreservedName
ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0());
		}
		this_UnrestrictedName_0=ruleUnrestrictedName
		{
			$current.merge(this_UnrestrictedName_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1());
		}
		this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier
		{
			$current.merge(this_CollectionTypeIdentifier_1);
		}
		{
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2());
		}
		this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier
		{
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
entryRuleUnreservedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUnreservedNameRule()); }
	iv_ruleUnreservedName=ruleUnreservedName
	{ $current=$iv_ruleUnreservedName.current.getText(); }
	EOF;

// Rule UnreservedName
ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall());
	}
	this_EssentialOCLUnreservedName_0=ruleEssentialOCLUnreservedName
	{
		$current.merge(this_EssentialOCLUnreservedName_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleURIPathNameCS
entryRuleURIPathNameCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getURIPathNameCSRule()); }
	iv_ruleURIPathNameCS=ruleURIPathNameCS
	{ $current=$iv_ruleURIPathNameCS.current; }
	EOF;

// Rule URIPathNameCS
ruleURIPathNameCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0());
				}
				lv_ownedPathElements_0_0=ruleURIFirstPathElementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
					}
					add(
						$current,
						"ownedPathElements",
						lv_ownedPathElements_0_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.URIFirstPathElementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='::'
			{
				newLeafNode(otherlv_1, grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());
					}
					lv_ownedPathElements_2_0=ruleNextPathElementCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getURIPathNameCSRule());
						}
						add(
							$current,
							"ownedPathElements",
							lv_ownedPathElements_2_0,
							"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleURIFirstPathElementCS
entryRuleURIFirstPathElementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); }
	iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS
	{ $current=$iv_ruleURIFirstPathElementCS.current; }
	EOF;

// Rule URIFirstPathElementCS
ruleURIFirstPathElementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
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
				ruleUnrestrictedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0(),
						$current);
				}
			)
			(
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
					ruleURI
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRulePrimitiveTypeIdentifier
entryRulePrimitiveTypeIdentifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); }
	iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier
	{ $current=$iv_rulePrimitiveTypeIdentifier.current.getText(); }
	EOF;

// Rule PrimitiveTypeIdentifier
rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRulePrimitiveTypeCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); }
	iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS
	{ $current=$iv_rulePrimitiveTypeCS.current; }
	EOF;

// Rule PrimitiveTypeCS
rulePrimitiveTypeCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0());
			}
			lv_name_0_0=rulePrimitiveTypeIdentifier
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getPrimitiveTypeCSRule());
				}
				set(
					$current,
					"name",
					lv_name_0_0,
					"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrimitiveTypeIdentifier");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleCollectionTypeIdentifier
entryRuleCollectionTypeIdentifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); }
	iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier
	{ $current=$iv_ruleCollectionTypeIdentifier.current.getText(); }
	EOF;

// Rule CollectionTypeIdentifier
ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRuleCollectionTypeCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCollectionTypeCSRule()); }
	iv_ruleCollectionTypeCS=ruleCollectionTypeCS
	{ $current=$iv_ruleCollectionTypeCS.current; }
	EOF;

// Rule CollectionTypeCS
ruleCollectionTypeCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0());
				}
				lv_name_0_0=ruleCollectionTypeIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeIdentifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpWithoutMultiplicityCSParserRuleCall_1_1_0());
					}
					lv_ownedType_2_0=ruleTypeExpWithoutMultiplicityCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpWithoutMultiplicityCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedCollectionMultiplicityMultiplicityCSParserRuleCall_1_2_0());
					}
					lv_ownedCollectionMultiplicity_3_0=ruleMultiplicityCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
						}
						set(
							$current,
							"ownedCollectionMultiplicity",
							lv_ownedCollectionMultiplicity_3_0,
							"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			otherlv_4=')'
			{
				newLeafNode(otherlv_4, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_3());
			}
		)?
	)
;

// Entry rule entryRuleMapTypeCS
entryRuleMapTypeCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMapTypeCSRule()); }
	iv_ruleMapTypeCS=ruleMapTypeCS
	{ $current=$iv_ruleMapTypeCS.current; }
	EOF;

// Rule MapTypeCS
ruleMapTypeCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0='Map'
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
		)
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0());
					}
					lv_ownedKeyType_2_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
						}
						set(
							$current,
							"ownedKeyType",
							lv_ownedKeyType_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=','
			{
				newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0());
					}
					lv_ownedValueType_4_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
						}
						set(
							$current,
							"ownedValueType",
							lv_ownedValueType_4_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5=')'
			{
				newLeafNode(otherlv_5, grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4());
			}
		)?
	)
;

// Entry rule entryRuleTupleTypeCS
entryRuleTupleTypeCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleTypeCSRule()); }
	iv_ruleTupleTypeCS=ruleTupleTypeCS
	{ $current=$iv_ruleTupleTypeCS.current; }
	EOF;

// Rule TupleTypeCS
ruleTupleTypeCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0='Tuple'
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
		)
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0());
						}
						lv_ownedParts_2_0=ruleTuplePartCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
							}
							add(
								$current,
								"ownedParts",
								lv_ownedParts_2_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_3=','
					{
						newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0());
							}
							lv_ownedParts_4_0=ruleTuplePartCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
								}
								add(
									$current,
									"ownedParts",
									lv_ownedParts_4_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TuplePartCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_5=')'
			{
				newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());
			}
		)?
	)
;

// Entry rule entryRuleTuplePartCS
entryRuleTuplePartCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTuplePartCSRule()); }
	iv_ruleTuplePartCS=ruleTuplePartCS
	{ $current=$iv_ruleTuplePartCS.current; }
	EOF;

// Rule TuplePartCS
ruleTuplePartCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0());
				}
				lv_ownedType_2_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_2_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCollectionLiteralExpCS
entryRuleCollectionLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); }
	iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS
	{ $current=$iv_ruleCollectionLiteralExpCS.current; }
	EOF;

// Rule CollectionLiteralExpCS
ruleCollectionLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());
				}
				lv_ownedType_0_0=ruleCollectionTypeCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_0_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0());
					}
					lv_ownedParts_2_0=ruleCollectionLiteralPartCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
						}
						add(
							$current,
							"ownedParts",
							lv_ownedParts_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0());
						}
						lv_ownedParts_4_0=ruleCollectionLiteralPartCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
							}
							add(
								$current,
								"ownedParts",
								lv_ownedParts_4_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionLiteralPartCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleCollectionLiteralPartCS
entryRuleCollectionLiteralPartCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); }
	iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS
	{ $current=$iv_ruleCollectionLiteralPartCS.current; }
	EOF;

// Rule CollectionLiteralPartCS
ruleCollectionLiteralPartCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0());
					}
					lv_ownedExpression_0_0=ruleExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
						}
						set(
							$current,
							"ownedExpression",
							lv_ownedExpression_0_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_1='..'
				{
					newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0());
						}
						lv_ownedLastExpression_2_0=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
							}
							set(
								$current,
								"ownedLastExpression",
								lv_ownedLastExpression_2_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0());
				}
				lv_ownedExpression_3_0=rulePatternExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
					}
					set(
						$current,
						"ownedExpression",
						lv_ownedExpression_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCollectionPatternCS
entryRuleCollectionPatternCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCollectionPatternCSRule()); }
	iv_ruleCollectionPatternCS=ruleCollectionPatternCS
	{ $current=$iv_ruleCollectionPatternCS.current; }
	EOF;

// Rule CollectionPatternCS
ruleCollectionPatternCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0());
				}
				lv_ownedType_0_0=ruleCollectionTypeCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_0_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CollectionTypeCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0());
					}
					lv_ownedParts_2_0=rulePatternExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
						}
						add(
							$current,
							"ownedParts",
							lv_ownedParts_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0());
						}
						lv_ownedParts_4_0=rulePatternExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
							}
							add(
								$current,
								"ownedParts",
								lv_ownedParts_4_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			(
				otherlv_5='++'
				{
					newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0());
						}
						lv_restVariableName_6_0=ruleIdentifier
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
							}
							set(
								$current,
								"restVariableName",
								lv_restVariableName_6_0,
								"org.eclipse.ocl.xtext.base.Base.Identifier");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleShadowPartCS
entryRuleShadowPartCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getShadowPartCSRule()); }
	iv_ruleShadowPartCS=ruleShadowPartCS
	{ $current=$iv_ruleShadowPartCS.current; }
	EOF;

// Rule ShadowPartCS
ruleShadowPartCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
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
						newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0());
					}
					ruleUnrestrictedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_1='='
			{
				newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0());
						}
						lv_ownedInitExpression_2_1=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
							}
							set(
								$current,
								"ownedInitExpression",
								lv_ownedInitExpression_2_1,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1());
						}
						lv_ownedInitExpression_2_2=rulePatternExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
							}
							set(
								$current,
								"ownedInitExpression",
								lv_ownedInitExpression_2_2,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0());
				}
				lv_ownedInitExpression_3_0=ruleStringLiteralExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
					}
					set(
						$current,
						"ownedInitExpression",
						lv_ownedInitExpression_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.StringLiteralExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRulePatternExpCS
entryRulePatternExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPatternExpCSRule()); }
	iv_rulePatternExpCS=rulePatternExpCS
	{ $current=$iv_rulePatternExpCS.current; }
	EOF;

// Rule PatternExpCS
rulePatternExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_patternVariableName_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
					}
					set(
						$current,
						"patternVariableName",
						lv_patternVariableName_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0());
				}
				lv_ownedPatternType_2_0=ruleTypeExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
					}
					set(
						$current,
						"ownedPatternType",
						lv_ownedPatternType_2_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLambdaLiteralExpCS
entryRuleLambdaLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); }
	iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS
	{ $current=$iv_ruleLambdaLiteralExpCS.current; }
	EOF;

// Rule LambdaLiteralExpCS
ruleLambdaLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Lambda'
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
				lv_ownedExpressionCS_2_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
					}
					set(
						$current,
						"ownedExpressionCS",
						lv_ownedExpressionCS_2_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='}'
		{
			newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleMapLiteralExpCS
entryRuleMapLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); }
	iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS
	{ $current=$iv_ruleMapLiteralExpCS.current; }
	EOF;

// Rule MapLiteralExpCS
ruleMapLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0());
				}
				lv_ownedType_0_0=ruleMapTypeCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
					}
					set(
						$current,
						"ownedType",
						lv_ownedType_0_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapTypeCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0());
					}
					lv_ownedParts_2_0=ruleMapLiteralPartCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
						}
						add(
							$current,
							"ownedParts",
							lv_ownedParts_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0());
						}
						lv_ownedParts_4_0=ruleMapLiteralPartCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
							}
							add(
								$current,
								"ownedParts",
								lv_ownedParts_4_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.MapLiteralPartCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleMapLiteralPartCS
entryRuleMapLiteralPartCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); }
	iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS
	{ $current=$iv_ruleMapLiteralPartCS.current; }
	EOF;

// Rule MapLiteralPartCS
ruleMapLiteralPartCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0());
				}
				lv_ownedKey_0_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
					}
					set(
						$current,
						"ownedKey",
						lv_ownedKey_0_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='with'
			{
				newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getWithKeyword_1_0());
			}
			    |
			otherlv_2='<-'
			{
				newLeafNode(otherlv_2, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1_1());
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0());
				}
				lv_ownedValue_3_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRulePrimitiveLiteralExpCS
entryRulePrimitiveLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); }
	iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS
	{ $current=$iv_rulePrimitiveLiteralExpCS.current; }
	EOF;

// Rule PrimitiveLiteralExpCS
rulePrimitiveLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRuleTupleLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); }
	iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS
	{ $current=$iv_ruleTupleLiteralExpCS.current; }
	EOF;

// Rule TupleLiteralExpCS
ruleTupleLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Tuple'
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
				lv_ownedParts_2_0=ruleTupleLiteralPartCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
					}
					add(
						$current,
						"ownedParts",
						lv_ownedParts_2_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=','
			{
				newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0());
					}
					lv_ownedParts_4_0=ruleTupleLiteralPartCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
						}
						add(
							$current,
							"ownedParts",
							lv_ownedParts_4_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TupleLiteralPartCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleTupleLiteralPartCS
entryRuleTupleLiteralPartCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); }
	iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS
	{ $current=$iv_ruleTupleLiteralPartCS.current; }
	EOF;

// Rule TupleLiteralPartCS
ruleTupleLiteralPartCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=':'
			{
				newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());
					}
					lv_ownedType_2_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_3='='
		{
			newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0());
				}
				lv_ownedInitExpression_4_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
					}
					set(
						$current,
						"ownedInitExpression",
						lv_ownedInitExpression_4_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleNumberLiteralExpCS
entryRuleNumberLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); }
	iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS
	{ $current=$iv_ruleNumberLiteralExpCS.current; }
	EOF;

// Rule NumberLiteralExpCS
ruleNumberLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0());
			}
			lv_symbol_0_0=ruleNUMBER_LITERAL
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
				}
				set(
					$current,
					"symbol",
					lv_symbol_0_0,
					"org.eclipse.ocl.xtext.base.Base.NUMBER_LITERAL");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleStringLiteralExpCS
entryRuleStringLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); }
	iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS
	{ $current=$iv_ruleStringLiteralExpCS.current; }
	EOF;

// Rule StringLiteralExpCS
ruleStringLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0());
			}
			lv_segments_0_0=ruleStringLiteral
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
				}
				add(
					$current,
					"segments",
					lv_segments_0_0,
					"org.eclipse.ocl.xtext.base.Base.StringLiteral");
				afterParserOrEnumRuleCall();
			}
		)
	)+
;

// Entry rule entryRuleBooleanLiteralExpCS
entryRuleBooleanLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); }
	iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS
	{ $current=$iv_ruleBooleanLiteralExpCS.current; }
	EOF;

// Rule BooleanLiteralExpCS
ruleBooleanLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_symbol_0_0='true'
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
		    |
		(
			(
				lv_symbol_1_0='false'
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
		)
	)
;

// Entry rule entryRuleUnlimitedNaturalLiteralExpCS
entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); }
	iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS
	{ $current=$iv_ruleUnlimitedNaturalLiteralExpCS.current; }
	EOF;

// Rule UnlimitedNaturalLiteralExpCS
ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(),
					$current);
			}
		)
		otherlv_1='*'
		{
			newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1());
		}
	)
;

// Entry rule entryRuleInvalidLiteralExpCS
entryRuleInvalidLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); }
	iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS
	{ $current=$iv_ruleInvalidLiteralExpCS.current; }
	EOF;

// Rule InvalidLiteralExpCS
ruleInvalidLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(),
					$current);
			}
		)
		otherlv_1='invalid'
		{
			newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1());
		}
	)
;

// Entry rule entryRuleNullLiteralExpCS
entryRuleNullLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); }
	iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS
	{ $current=$iv_ruleNullLiteralExpCS.current; }
	EOF;

// Rule NullLiteralExpCS
ruleNullLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(),
					$current);
			}
		)
		otherlv_1='null'
		{
			newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1());
		}
	)
;

// Entry rule entryRuleTypeLiteralCS
entryRuleTypeLiteralCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeLiteralCSRule()); }
	iv_ruleTypeLiteralCS=ruleTypeLiteralCS
	{ $current=$iv_ruleTypeLiteralCS.current; }
	EOF;

// Rule TypeLiteralCS
ruleTypeLiteralCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); }
	iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS
	{ $current=$iv_ruleTypeLiteralWithMultiplicityCS.current; }
	EOF;

// Rule TypeLiteralWithMultiplicityCS
ruleTypeLiteralWithMultiplicityCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
				lv_ownedMultiplicity_1_0=ruleMultiplicityCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
					}
					set(
						$current,
						"ownedMultiplicity",
						lv_ownedMultiplicity_1_0,
						"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleTypeLiteralExpCS
entryRuleTypeLiteralExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); }
	iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS
	{ $current=$iv_ruleTypeLiteralExpCS.current; }
	EOF;

// Rule TypeLiteralExpCS
ruleTypeLiteralExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0());
			}
			lv_ownedType_0_0=ruleTypeLiteralWithMultiplicityCS
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getTypeLiteralExpCSRule());
				}
				set(
					$current,
					"ownedType",
					lv_ownedType_0_0,
					"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeLiteralWithMultiplicityCS");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleTypeNameExpCS
entryRuleTypeNameExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeNameExpCSRule()); }
	iv_ruleTypeNameExpCS=ruleTypeNameExpCS
	{ $current=$iv_ruleTypeNameExpCS.current; }
	EOF;

// Rule TypeNameExpCS
ruleTypeNameExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
				}
				lv_ownedPathName_0_0=rulePathNameCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
					}
					set(
						$current,
						"ownedPathName",
						lv_ownedPathName_0_0,
						"org.eclipse.ocl.xtext.base.Base.PathNameCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0());
					}
					lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
						}
						set(
							$current,
							"ownedCurlyBracketedClause",
							lv_ownedCurlyBracketedClause_1_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2='{'
				{
					newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0());
						}
						lv_ownedPatternGuard_3_0=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
							}
							set(
								$current,
								"ownedPatternGuard",
								lv_ownedPatternGuard_3_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
				otherlv_4='}'
				{
					newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
				}
			)?
		)?
	)
;

// Entry rule entryRuleTypeExpWithoutMultiplicityCS
entryRuleTypeExpWithoutMultiplicityCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSRule()); }
	iv_ruleTypeExpWithoutMultiplicityCS=ruleTypeExpWithoutMultiplicityCS
	{ $current=$iv_ruleTypeExpWithoutMultiplicityCS.current; }
	EOF;

// Rule TypeExpWithoutMultiplicityCS
ruleTypeExpWithoutMultiplicityCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeNameExpCSParserRuleCall_0());
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
			newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_1());
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
			newCompositeNode(grammarAccess.getTypeExpWithoutMultiplicityCSAccess().getCollectionPatternCSParserRuleCall_2());
		}
		this_CollectionPatternCS_2=ruleCollectionPatternCS
		{
			$current = $this_CollectionPatternCS_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeExpCS
entryRuleTypeExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeExpCSRule()); }
	iv_ruleTypeExpCS=ruleTypeExpCS
	{ $current=$iv_ruleTypeExpCS.current; }
	EOF;

// Rule TypeExpCS
ruleTypeExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			/* */
		}
		{
			newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeExpWithoutMultiplicityCSParserRuleCall_0());
		}
		this_TypeExpWithoutMultiplicityCS_0=ruleTypeExpWithoutMultiplicityCS
		{
			$current = $this_TypeExpWithoutMultiplicityCS_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0());
				}
				lv_ownedMultiplicity_1_0=ruleMultiplicityCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
					}
					set(
						$current,
						"ownedMultiplicity",
						lv_ownedMultiplicity_1_0,
						"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleExpCS
entryRuleExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpCSRule()); }
	iv_ruleExpCS=ruleExpCS
	{ $current=$iv_ruleExpCS.current; }
	EOF;

// Rule ExpCS
ruleExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
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
			(
				(
					{
						/* */
					}
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0());
						}
						lv_name_2_0=ruleBinaryOperatorName
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getExpCSRule());
							}
							set(
								$current,
								"name",
								lv_name_2_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.BinaryOperatorName");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0());
						}
						lv_ownedRight_3_0=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getExpCSRule());
							}
							set(
								$current,
								"ownedRight",
								lv_ownedRight_3_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
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
entryRulePrefixedLetExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); }
	iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS
	{ $current=$iv_rulePrefixedLetExpCS.current; }
	EOF;

// Rule PrefixedLetExpCS
rulePrefixedLetExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());
					}
					lv_name_1_0=ruleUnaryOperatorName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
						}
						set(
							$current,
							"name",
							lv_name_1_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0());
					}
					lv_ownedRight_2_0=rulePrefixedLetExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
						}
						set(
							$current,
							"ownedRight",
							lv_ownedRight_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedLetExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
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
entryRulePrefixedPrimaryExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); }
	iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS
	{ $current=$iv_rulePrefixedPrimaryExpCS.current; }
	EOF;

// Rule PrefixedPrimaryExpCS
rulePrefixedPrimaryExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					/* */
				}
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0());
					}
					lv_name_1_0=ruleUnaryOperatorName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
						}
						set(
							$current,
							"name",
							lv_name_1_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.UnaryOperatorName");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0());
					}
					lv_ownedRight_2_0=rulePrefixedPrimaryExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
						}
						set(
							$current,
							"ownedRight",
							lv_ownedRight_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PrefixedPrimaryExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
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
entryRulePrimaryExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryExpCSRule()); }
	iv_rulePrimaryExpCS=rulePrimaryExpCS
	{ $current=$iv_rulePrimaryExpCS.current; }
	EOF;

// Rule PrimaryExpCS
rulePrimaryExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
entryRuleNameExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNameExpCSRule()); }
	iv_ruleNameExpCS=ruleNameExpCS
	{ $current=$iv_ruleNameExpCS.current; }
	EOF;

// Rule NameExpCS
ruleNameExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
				}
				lv_ownedPathName_0_0=rulePathNameCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNameExpCSRule());
					}
					set(
						$current,
						"ownedPathName",
						lv_ownedPathName_0_0,
						"org.eclipse.ocl.xtext.base.Base.PathNameCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0());
				}
				lv_ownedSquareBracketedClauses_1_0=ruleSquareBracketedClauseCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNameExpCSRule());
					}
					add(
						$current,
						"ownedSquareBracketedClauses",
						lv_ownedSquareBracketedClauses_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.SquareBracketedClauseCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0());
				}
				lv_ownedRoundBracketedClause_2_0=ruleRoundBracketedClauseCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNameExpCSRule());
					}
					set(
						$current,
						"ownedRoundBracketedClause",
						lv_ownedRoundBracketedClause_2_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0());
				}
				lv_ownedCurlyBracketedClause_3_0=ruleCurlyBracketedClauseCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNameExpCSRule());
					}
					set(
						$current,
						"ownedCurlyBracketedClause",
						lv_ownedCurlyBracketedClause_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CurlyBracketedClauseCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					lv_isPre_4_0='@'
					{
						newLeafNode(lv_isPre_4_0, grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getNameExpCSRule());
						}
						setWithLastConsumed($current, "isPre", lv_isPre_4_0 != null, "@");
					}
				)
			)
			otherlv_5='pre'
			{
				newLeafNode(otherlv_5, grammarAccess.getNameExpCSAccess().getPreKeyword_4_1());
			}
		)?
	)
;

// Entry rule entryRuleCurlyBracketedClauseCS
entryRuleCurlyBracketedClauseCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); }
	iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS
	{ $current=$iv_ruleCurlyBracketedClauseCS.current; }
	EOF;

// Rule CurlyBracketedClauseCS
ruleCurlyBracketedClauseCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0(),
					$current);
			}
		)
		otherlv_1='{'
		{
			newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0());
					}
					lv_ownedParts_2_0=ruleShadowPartCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
						}
						add(
							$current,
							"ownedParts",
							lv_ownedParts_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0());
						}
						lv_ownedParts_4_0=ruleShadowPartCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
							}
							add(
								$current,
								"ownedParts",
								lv_ownedParts_4_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ShadowPartCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleRoundBracketedClauseCS
entryRuleRoundBracketedClauseCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); }
	iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS
	{ $current=$iv_ruleRoundBracketedClauseCS.current; }
	EOF;

// Rule RoundBracketedClauseCS
ruleRoundBracketedClauseCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0(),
					$current);
			}
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0());
					}
					lv_ownedArguments_2_0=ruleNavigatingArgCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
						}
						add(
							$current,
							"ownedArguments",
							lv_ownedArguments_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0_0());
						}
						lv_ownedArguments_3_1=ruleNavigatingCommaArgCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
							}
							add(
								$current,
								"ownedArguments",
								lv_ownedArguments_3_1,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingCommaArgCS");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_1_0_1());
						}
						lv_ownedArguments_3_2=ruleNavigatingSemiArgCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
							}
							add(
								$current,
								"ownedArguments",
								lv_ownedArguments_3_2,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingSemiArgCS");
							afterParserOrEnumRuleCall();
						}
						    |
						{
							newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_1_0_2());
						}
						lv_ownedArguments_3_3=ruleNavigatingBarArgCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
							}
							add(
								$current,
								"ownedArguments",
								lv_ownedArguments_3_3,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingBarArgCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleSquareBracketedClauseCS
entryRuleSquareBracketedClauseCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); }
	iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS
	{ $current=$iv_ruleSquareBracketedClauseCS.current; }
	EOF;

// Rule SquareBracketedClauseCS
ruleSquareBracketedClauseCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0());
				}
				lv_ownedTerms_1_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
					}
					add(
						$current,
						"ownedTerms",
						lv_ownedTerms_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0());
					}
					lv_ownedTerms_3_0=ruleExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
						}
						add(
							$current,
							"ownedTerms",
							lv_ownedTerms_3_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_4=']'
		{
			newLeafNode(otherlv_4, grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleNavigatingArgCS
entryRuleNavigatingArgCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNavigatingArgCSRule()); }
	iv_ruleNavigatingArgCS=ruleNavigatingArgCS
	{ $current=$iv_ruleNavigatingArgCS.current; }
	EOF;

// Rule NavigatingArgCS
ruleNavigatingArgCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0());
					}
					lv_ownedNameExpression_0_0=ruleNavigatingArgExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
						}
						set(
							$current,
							"ownedNameExpression",
							lv_ownedNameExpression_0_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					(
						otherlv_1='with'
						{
							newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_0_0_0());
						}
						    |
						otherlv_2='<-'
						{
							newLeafNode(otherlv_2, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_0_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_0_1_0());
							}
							lv_ownedCoIterator_3_0=ruleCoIteratorVariableCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
								}
								set(
									$current,
									"ownedCoIterator",
									lv_ownedCoIterator_3_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						otherlv_4='='
						{
							newLeafNode(otherlv_4, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0());
								}
								lv_ownedInitExpression_5_0=ruleExpCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
									}
									set(
										$current,
										"ownedInitExpression",
										lv_ownedInitExpression_5_0,
										"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)?
				)
				    |
				(
					otherlv_6=':'
					{
						newLeafNode(otherlv_6, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_1_1_0());
							}
							lv_ownedType_7_0=ruleTypeExpCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
								}
								set(
									$current,
									"ownedType",
									lv_ownedType_7_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
					(
						(
							otherlv_8='with'
							{
								newLeafNode(otherlv_8, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_1_2_0_0());
							}
							    |
							otherlv_9='<-'
							{
								newLeafNode(otherlv_9, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_1_2_0_1());
							}
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_1_2_1_0());
								}
								lv_ownedCoIterator_10_0=ruleCoIteratorVariableCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
									}
									set(
										$current,
										"ownedCoIterator",
										lv_ownedCoIterator_10_0,
										"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)?
					(
						otherlv_11='='
						{
							newLeafNode(otherlv_11, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_1_3_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_3_1_0());
								}
								lv_ownedInitExpression_12_0=ruleExpCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
									}
									set(
										$current,
										"ownedInitExpression",
										lv_ownedInitExpression_12_0,
										"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)?
				)
				    |
				(
					(
						otherlv_13=':'
						{
							newLeafNode(otherlv_13, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_2_0_0());
						}
						(
							(
								{
									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_2_0_1_0());
								}
								lv_ownedType_14_0=ruleTypeExpCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
									}
									set(
										$current,
										"ownedType",
										lv_ownedType_14_0,
										"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)?
					(
						(
							otherlv_15='with'
							{
								newLeafNode(otherlv_15, grammarAccess.getNavigatingArgCSAccess().getWithKeyword_0_1_2_1_0_0());
							}
							    |
							otherlv_16='<-'
							{
								newLeafNode(otherlv_16, grammarAccess.getNavigatingArgCSAccess().getLessThanSignHyphenMinusKeyword_0_1_2_1_0_1());
							}
						)
						(
							(
								{
									newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_0_1_2_1_1_0());
								}
								lv_ownedCoIterator_17_0=ruleCoIteratorVariableCS
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
									}
									set(
										$current,
										"ownedCoIterator",
										lv_ownedCoIterator_17_0,
										"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
									afterParserOrEnumRuleCall();
								}
							)
						)
					)?
					otherlv_18='in'
					{
						newLeafNode(otherlv_18, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_2_2());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_2_3_0());
							}
							lv_ownedInitExpression_19_0=ruleExpCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
								}
								set(
									$current,
									"ownedInitExpression",
									lv_ownedInitExpression_19_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)?
		)
		    |
		(
			otherlv_20=':'
			{
				newLeafNode(otherlv_20, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());
					}
					lv_ownedType_21_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_21_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleNavigatingBarArgCS
entryRuleNavigatingBarArgCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); }
	iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS
	{ $current=$iv_ruleNavigatingBarArgCS.current; }
	EOF;

// Rule NavigatingBarArgCS
ruleNavigatingBarArgCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_prefix_0_0='|'
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
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());
				}
				lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
					}
					set(
						$current,
						"ownedNameExpression",
						lv_ownedNameExpression_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());
					}
					lv_ownedType_3_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_3_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='='
				{
					newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0());
						}
						lv_ownedInitExpression_5_0=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
							}
							set(
								$current,
								"ownedInitExpression",
								lv_ownedInitExpression_5_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)?
	)
;

// Entry rule entryRuleNavigatingCommaArgCS
entryRuleNavigatingCommaArgCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); }
	iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS
	{ $current=$iv_ruleNavigatingCommaArgCS.current; }
	EOF;

// Rule NavigatingCommaArgCS
ruleNavigatingCommaArgCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_prefix_0_0=','
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
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());
				}
				lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
					}
					set(
						$current,
						"ownedNameExpression",
						lv_ownedNameExpression_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					otherlv_2='with'
					{
						newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_0_0_0());
					}
					    |
					otherlv_3='<-'
					{
						newLeafNode(otherlv_3, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_0_0_1());
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_0_1_0());
						}
						lv_ownedCoIterator_4_0=ruleCoIteratorVariableCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
							}
							set(
								$current,
								"ownedCoIterator",
								lv_ownedCoIterator_4_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_5='='
					{
						newLeafNode(otherlv_5, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0());
							}
							lv_ownedInitExpression_6_0=ruleExpCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
								}
								set(
									$current,
									"ownedInitExpression",
									lv_ownedInitExpression_6_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
			)
			    |
			(
				otherlv_7=':'
				{
					newLeafNode(otherlv_7, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_1_0());
						}
						lv_ownedType_8_0=ruleTypeExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
							}
							set(
								$current,
								"ownedType",
								lv_ownedType_8_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						otherlv_9='with'
						{
							newLeafNode(otherlv_9, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_1_2_0_0());
						}
						    |
						otherlv_10='<-'
						{
							newLeafNode(otherlv_10, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_1_2_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_1_2_1_0());
							}
							lv_ownedCoIterator_11_0=ruleCoIteratorVariableCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
								}
								set(
									$current,
									"ownedCoIterator",
									lv_ownedCoIterator_11_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				(
					otherlv_12='='
					{
						newLeafNode(otherlv_12, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_1_3_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_3_1_0());
							}
							lv_ownedInitExpression_13_0=ruleExpCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
								}
								set(
									$current,
									"ownedInitExpression",
									lv_ownedInitExpression_13_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
			)
			    |
			(
				(
					otherlv_14=':'
					{
						newLeafNode(otherlv_14, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_2_0_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_2_0_1_0());
							}
							lv_ownedType_15_0=ruleTypeExpCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
								}
								set(
									$current,
									"ownedType",
									lv_ownedType_15_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				(
					(
						otherlv_16='with'
						{
							newLeafNode(otherlv_16, grammarAccess.getNavigatingCommaArgCSAccess().getWithKeyword_2_2_1_0_0());
						}
						    |
						otherlv_17='<-'
						{
							newLeafNode(otherlv_17, grammarAccess.getNavigatingCommaArgCSAccess().getLessThanSignHyphenMinusKeyword_2_2_1_0_1());
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedCoIteratorCoIteratorVariableCSParserRuleCall_2_2_1_1_0());
							}
							lv_ownedCoIterator_18_0=ruleCoIteratorVariableCS
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
								}
								set(
									$current,
									"ownedCoIterator",
									lv_ownedCoIterator_18_0,
									"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.CoIteratorVariableCS");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				otherlv_19='in'
				{
					newLeafNode(otherlv_19, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_2_2());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_3_0());
						}
						lv_ownedInitExpression_20_0=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
							}
							set(
								$current,
								"ownedInitExpression",
								lv_ownedInitExpression_20_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
	)
;

// Entry rule entryRuleNavigatingSemiArgCS
entryRuleNavigatingSemiArgCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); }
	iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS
	{ $current=$iv_ruleNavigatingSemiArgCS.current; }
	EOF;

// Rule NavigatingSemiArgCS
ruleNavigatingSemiArgCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_prefix_0_0=';'
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
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0());
				}
				lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
					}
					set(
						$current,
						"ownedNameExpression",
						lv_ownedNameExpression_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.NavigatingArgExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());
					}
					lv_ownedType_3_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_3_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='='
				{
					newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0());
						}
						lv_ownedInitExpression_5_0=ruleExpCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
							}
							set(
								$current,
								"ownedInitExpression",
								lv_ownedInitExpression_5_0,
								"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)?
	)
;

// Entry rule entryRuleNavigatingArgExpCS
entryRuleNavigatingArgExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); }
	iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS
	{ $current=$iv_ruleNavigatingArgExpCS.current; }
	EOF;

// Rule NavigatingArgExpCS
ruleNavigatingArgExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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

// Entry rule entryRuleCoIteratorVariableCS
entryRuleCoIteratorVariableCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCoIteratorVariableCSRule()); }
	iv_ruleCoIteratorVariableCS=ruleCoIteratorVariableCS
	{ $current=$iv_ruleCoIteratorVariableCS.current; }
	EOF;

// Rule CoIteratorVariableCS
ruleCoIteratorVariableCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getCoIteratorVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCoIteratorVariableCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=':'
			{
				newLeafNode(otherlv_1, grammarAccess.getCoIteratorVariableCSAccess().getColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getCoIteratorVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0());
					}
					lv_ownedType_2_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCoIteratorVariableCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_2_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleIfExpCS
entryRuleIfExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIfExpCSRule()); }
	iv_ruleIfExpCS=ruleIfExpCS
	{ $current=$iv_ruleIfExpCS.current; }
	EOF;

// Rule IfExpCS
ruleIfExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='if'
		{
			newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0());
					}
					lv_ownedCondition_1_1=ruleExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIfExpCSRule());
						}
						set(
							$current,
							"ownedCondition",
							lv_ownedCondition_1_1,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
						afterParserOrEnumRuleCall();
					}
					    |
					{
						newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1());
					}
					lv_ownedCondition_1_2=rulePatternExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIfExpCSRule());
						}
						set(
							$current,
							"ownedCondition",
							lv_ownedCondition_1_2,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.PatternExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		otherlv_2='then'
		{
			newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0());
				}
				lv_ownedThenExpression_3_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfExpCSRule());
					}
					set(
						$current,
						"ownedThenExpression",
						lv_ownedThenExpression_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0());
				}
				lv_ownedIfThenExpressions_4_0=ruleElseIfThenExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfExpCSRule());
					}
					add(
						$current,
						"ownedIfThenExpressions",
						lv_ownedIfThenExpressions_4_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ElseIfThenExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_5='else'
		{
			newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0());
				}
				lv_ownedElseExpression_6_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfExpCSRule());
					}
					set(
						$current,
						"ownedElseExpression",
						lv_ownedElseExpression_6_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_7='endif'
		{
			newLeafNode(otherlv_7, grammarAccess.getIfExpCSAccess().getEndifKeyword_7());
		}
	)
;

// Entry rule entryRuleElseIfThenExpCS
entryRuleElseIfThenExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); }
	iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS
	{ $current=$iv_ruleElseIfThenExpCS.current; }
	EOF;

// Rule ElseIfThenExpCS
ruleElseIfThenExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='elseif'
		{
			newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0());
				}
				lv_ownedCondition_1_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
					}
					set(
						$current,
						"ownedCondition",
						lv_ownedCondition_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='then'
		{
			newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0());
				}
				lv_ownedThenExpression_3_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
					}
					set(
						$current,
						"ownedThenExpression",
						lv_ownedThenExpression_3_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLetExpCS
entryRuleLetExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLetExpCSRule()); }
	iv_ruleLetExpCS=ruleLetExpCS
	{ $current=$iv_ruleLetExpCS.current; }
	EOF;

// Rule LetExpCS
ruleLetExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='let'
		{
			newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0());
				}
				lv_ownedVariables_1_0=ruleLetVariableCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLetExpCSRule());
					}
					add(
						$current,
						"ownedVariables",
						lv_ownedVariables_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0());
					}
					lv_ownedVariables_3_0=ruleLetVariableCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLetExpCSRule());
						}
						add(
							$current,
							"ownedVariables",
							lv_ownedVariables_3_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.LetVariableCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_4='in'
		{
			newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0());
				}
				lv_ownedInExpression_5_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLetExpCSRule());
					}
					set(
						$current,
						"ownedInExpression",
						lv_ownedInExpression_5_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLetVariableCS
entryRuleLetVariableCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLetVariableCSRule()); }
	iv_ruleLetVariableCS=ruleLetVariableCS
	{ $current=$iv_ruleLetVariableCS.current; }
	EOF;

// Rule LetVariableCS
ruleLetVariableCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0());
				}
				lv_ownedRoundBracketedClause_1_0=ruleRoundBracketedClauseCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
					}
					set(
						$current,
						"ownedRoundBracketedClause",
						lv_ownedRoundBracketedClause_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.RoundBracketedClauseCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0());
					}
					lv_ownedType_3_0=ruleTypeExpCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
						}
						set(
							$current,
							"ownedType",
							lv_ownedType_3_0,
							"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.TypeExpCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_4='='
		{
			newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0());
				}
				lv_ownedInitExpression_5_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
					}
					set(
						$current,
						"ownedInitExpression",
						lv_ownedInitExpression_5_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleNestedExpCS
entryRuleNestedExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNestedExpCSRule()); }
	iv_ruleNestedExpCS=ruleNestedExpCS
	{ $current=$iv_ruleNestedExpCS.current; }
	EOF;

// Rule NestedExpCS
ruleNestedExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0());
				}
				lv_ownedExpression_1_0=ruleExpCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
					}
					set(
						$current,
						"ownedExpression",
						lv_ownedExpression_1_0,
						"org.eclipse.ocl.xtext.essentialocl.EssentialOCL.ExpCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleSelfExpCS
entryRuleSelfExpCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSelfExpCSRule()); }
	iv_ruleSelfExpCS=ruleSelfExpCS
	{ $current=$iv_ruleSelfExpCS.current; }
	EOF;

// Rule SelfExpCS
ruleSelfExpCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0(),
					$current);
			}
		)
		otherlv_1='self'
		{
			newLeafNode(otherlv_1, grammarAccess.getSelfExpCSAccess().getSelfKeyword_1());
		}
	)
;

// Entry rule entryRuleMultiplicityBoundsCS
entryRuleMultiplicityBoundsCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); }
	iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS
	{ $current=$iv_ruleMultiplicityBoundsCS.current; }
	EOF;

// Rule MultiplicityBoundsCS
ruleMultiplicityBoundsCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0());
				}
				lv_lowerBound_0_0=ruleLOWER
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
					}
					set(
						$current,
						"lowerBound",
						lv_lowerBound_0_0,
						"org.eclipse.ocl.xtext.base.Base.LOWER");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='..'
			{
				newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0());
					}
					lv_upperBound_2_0=ruleUPPER
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
						}
						set(
							$current,
							"upperBound",
							lv_upperBound_2_0,
							"org.eclipse.ocl.xtext.base.Base.UPPER");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleMultiplicityCS
entryRuleMultiplicityCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiplicityCSRule()); }
	iv_ruleMultiplicityCS=ruleMultiplicityCS
	{ $current=$iv_ruleMultiplicityCS.current; }
	EOF;

// Rule MultiplicityCS
ruleMultiplicityCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
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
		)
		(
			otherlv_3='|?'
			{
				newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
			}
			    |
			(
				(
					lv_isNullFree_4_0='|1'
					{
						newLeafNode(lv_isNullFree_4_0, grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getMultiplicityCSRule());
						}
						setWithLastConsumed($current, "isNullFree", lv_isNullFree_4_0 != null, "|1");
					}
				)
			)
		)?
		otherlv_5=']'
		{
			newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleMultiplicityStringCS
entryRuleMultiplicityStringCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); }
	iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS
	{ $current=$iv_ruleMultiplicityStringCS.current; }
	EOF;

// Rule MultiplicityStringCS
ruleMultiplicityStringCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_stringBounds_0_1='*'
				{
					newLeafNode(lv_stringBounds_0_1, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
					}
					setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_1, null);
				}
				    |
				lv_stringBounds_0_2='+'
				{
					newLeafNode(lv_stringBounds_0_2, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
					}
					setWithLastConsumed($current, "stringBounds", lv_stringBounds_0_2, null);
				}
				    |
				lv_stringBounds_0_3='?'
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
entryRulePathNameCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPathNameCSRule()); }
	iv_rulePathNameCS=rulePathNameCS
	{ $current=$iv_rulePathNameCS.current; }
	EOF;

// Rule PathNameCS
rulePathNameCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0());
				}
				lv_ownedPathElements_0_0=ruleFirstPathElementCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPathNameCSRule());
					}
					add(
						$current,
						"ownedPathElements",
						lv_ownedPathElements_0_0,
						"org.eclipse.ocl.xtext.base.Base.FirstPathElementCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='::'
			{
				newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0());
					}
					lv_ownedPathElements_2_0=ruleNextPathElementCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPathNameCSRule());
						}
						add(
							$current,
							"ownedPathElements",
							lv_ownedPathElements_2_0,
							"org.eclipse.ocl.xtext.base.Base.NextPathElementCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleFirstPathElementCS
entryRuleFirstPathElementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFirstPathElementCSRule()); }
	iv_ruleFirstPathElementCS=ruleFirstPathElementCS
	{ $current=$iv_ruleFirstPathElementCS.current; }
	EOF;

// Rule FirstPathElementCS
ruleFirstPathElementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
			ruleUnrestrictedName
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleNextPathElementCS
entryRuleNextPathElementCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNextPathElementCSRule()); }
	iv_ruleNextPathElementCS=ruleNextPathElementCS
	{ $current=$iv_ruleNextPathElementCS.current; }
	EOF;

// Rule NextPathElementCS
ruleNextPathElementCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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
			ruleUnreservedName
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleTemplateBindingCS
entryRuleTemplateBindingCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTemplateBindingCSRule()); }
	iv_ruleTemplateBindingCS=ruleTemplateBindingCS
	{ $current=$iv_ruleTemplateBindingCS.current; }
	EOF;

// Rule TemplateBindingCS
ruleTemplateBindingCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0());
				}
				lv_ownedSubstitutions_0_0=ruleTemplateParameterSubstitutionCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
					}
					add(
						$current,
						"ownedSubstitutions",
						lv_ownedSubstitutions_0_0,
						"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=','
			{
				newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0());
					}
					lv_ownedSubstitutions_2_0=ruleTemplateParameterSubstitutionCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
						}
						add(
							$current,
							"ownedSubstitutions",
							lv_ownedSubstitutions_2_0,
							"org.eclipse.ocl.xtext.base.Base.TemplateParameterSubstitutionCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0());
				}
				lv_ownedMultiplicity_3_0=ruleMultiplicityCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
					}
					set(
						$current,
						"ownedMultiplicity",
						lv_ownedMultiplicity_3_0,
						"org.eclipse.ocl.xtext.base.Base.MultiplicityCS");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleTemplateParameterSubstitutionCS
entryRuleTemplateParameterSubstitutionCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); }
	iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS
	{ $current=$iv_ruleTemplateParameterSubstitutionCS.current; }
	EOF;

// Rule TemplateParameterSubstitutionCS
ruleTemplateParameterSubstitutionCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0());
			}
			lv_ownedActualParameter_0_0=ruleTypeRefCS
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getTemplateParameterSubstitutionCSRule());
				}
				set(
					$current,
					"ownedActualParameter",
					lv_ownedActualParameter_0_0,
					"org.eclipse.ocl.xtext.base.Base.TypeRefCS");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleTemplateSignatureCS
entryRuleTemplateSignatureCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTemplateSignatureCSRule()); }
	iv_ruleTemplateSignatureCS=ruleTemplateSignatureCS
	{ $current=$iv_ruleTemplateSignatureCS.current; }
	EOF;

// Rule TemplateSignatureCS
ruleTemplateSignatureCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0());
				}
				lv_ownedParameters_1_0=ruleTypeParameterCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
					}
					add(
						$current,
						"ownedParameters",
						lv_ownedParameters_1_0,
						"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=','
			{
				newLeafNode(otherlv_2, grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0());
					}
					lv_ownedParameters_3_0=ruleTypeParameterCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTemplateSignatureCSRule());
						}
						add(
							$current,
							"ownedParameters",
							lv_ownedParameters_3_0,
							"org.eclipse.ocl.xtext.base.Base.TypeParameterCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleTypeParameterCS
entryRuleTypeParameterCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeParameterCSRule()); }
	iv_ruleTypeParameterCS=ruleTypeParameterCS
	{ $current=$iv_ruleTypeParameterCS.current; }
	EOF;

// Rule TypeParameterCS
ruleTypeParameterCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleUnrestrictedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.qvtd.xtext.qvtimperative.QVTimperative.UnrestrictedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='extends'
			{
				newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0());
					}
					lv_ownedExtends_2_0=ruleTypedRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
						}
						add(
							$current,
							"ownedExtends",
							lv_ownedExtends_2_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3='&&'
				{
					newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0());
						}
						lv_ownedExtends_4_0=ruleTypedRefCS
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
							}
							add(
								$current,
								"ownedExtends",
								lv_ownedExtends_4_0,
								"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
	)
;

// Entry rule entryRuleTypeRefCS
entryRuleTypeRefCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRefCSRule()); }
	iv_ruleTypeRefCS=ruleTypeRefCS
	{ $current=$iv_ruleTypeRefCS.current; }
	EOF;

// Rule TypeRefCS
ruleTypeRefCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
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

// Entry rule entryRuleTypedTypeRefCS
entryRuleTypedTypeRefCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); }
	iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS
	{ $current=$iv_ruleTypedTypeRefCS.current; }
	EOF;

// Rule TypedTypeRefCS
ruleTypedTypeRefCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0());
				}
				lv_ownedPathName_0_0=rulePathNameCS
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
					}
					set(
						$current,
						"ownedPathName",
						lv_ownedPathName_0_0,
						"org.eclipse.ocl.xtext.base.Base.PathNameCS");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0());
					}
					lv_ownedBinding_2_0=ruleTemplateBindingCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
						}
						set(
							$current,
							"ownedBinding",
							lv_ownedBinding_2_0,
							"org.eclipse.ocl.xtext.base.Base.TemplateBindingCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=')'
			{
				newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());
			}
		)?
	)
;

// Entry rule entryRuleWildcardTypeRefCS
entryRuleWildcardTypeRefCS returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); }
	iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS
	{ $current=$iv_ruleWildcardTypeRefCS.current; }
	EOF;

// Rule WildcardTypeRefCS
ruleWildcardTypeRefCS returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				/* */
			}
			{
				$current = forceCreateModelElement(
					grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(),
					$current);
			}
		)
		otherlv_1='?'
		{
			newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
		}
		(
			otherlv_2='extends'
			{
				newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0());
					}
					lv_ownedExtends_3_0=ruleTypedRefCS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
						}
						set(
							$current,
							"ownedExtends",
							lv_ownedExtends_3_0,
							"org.eclipse.qvtd.xtext.qvtbase.QVTbase.TypedRefCS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleID
entryRuleID returns [String current=null]:
	{ newCompositeNode(grammarAccess.getIDRule()); }
	iv_ruleID=ruleID
	{ $current=$iv_ruleID.current.getText(); }
	EOF;

// Rule ID
ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_SIMPLE_ID_0=RULE_SIMPLE_ID
		{
			$current.merge(this_SIMPLE_ID_0);
		}
		{
			newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0());
		}
		    |
		this_ESCAPED_ID_1=RULE_ESCAPED_ID
		{
			$current.merge(this_ESCAPED_ID_1);
		}
		{
			newLeafNode(this_ESCAPED_ID_1, grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleIdentifier
entryRuleIdentifier returns [String current=null]:
	{ newCompositeNode(grammarAccess.getIdentifierRule()); }
	iv_ruleIdentifier=ruleIdentifier
	{ $current=$iv_ruleIdentifier.current.getText(); }
	EOF;

// Rule Identifier
ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall());
	}
	this_ID_0=ruleID
	{
		$current.merge(this_ID_0);
	}
	{
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleLOWER
entryRuleLOWER returns [String current=null]:
	{ newCompositeNode(grammarAccess.getLOWERRule()); }
	iv_ruleLOWER=ruleLOWER
	{ $current=$iv_ruleLOWER.current.getText(); }
	EOF;

// Rule LOWER
ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_INT_0=RULE_INT
	{
		$current.merge(this_INT_0);
	}
	{
		newLeafNode(this_INT_0, grammarAccess.getLOWERAccess().getINTTerminalRuleCall());
	}
;

// Entry rule entryRuleNUMBER_LITERAL
entryRuleNUMBER_LITERAL returns [String current=null]:
	{ newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); }
	iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL
	{ $current=$iv_ruleNUMBER_LITERAL.current.getText(); }
	EOF;

// Rule NUMBER_LITERAL
ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_INT_0=RULE_INT
	{
		$current.merge(this_INT_0);
	}
	{
		newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall());
	}
;

// Entry rule entryRuleStringLiteral
entryRuleStringLiteral returns [String current=null]:
	{ newCompositeNode(grammarAccess.getStringLiteralRule()); }
	iv_ruleStringLiteral=ruleStringLiteral
	{ $current=$iv_ruleStringLiteral.current.getText(); }
	EOF;

// Rule StringLiteral
ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_SINGLE_QUOTED_STRING_0=RULE_SINGLE_QUOTED_STRING
	{
		$current.merge(this_SINGLE_QUOTED_STRING_0);
	}
	{
		newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall());
	}
;

// Entry rule entryRuleUPPER
entryRuleUPPER returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUPPERRule()); }
	iv_ruleUPPER=ruleUPPER
	{ $current=$iv_ruleUPPER.current.getText(); }
	EOF;

// Rule UPPER
ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_INT_0=RULE_INT
		{
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
entryRuleURI returns [String current=null]:
	{ newCompositeNode(grammarAccess.getURIRule()); }
	iv_ruleURI=ruleURI
	{ $current=$iv_ruleURI.current.getText(); }
	EOF;

// Rule URI
ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_SINGLE_QUOTED_STRING_0=RULE_SINGLE_QUOTED_STRING
	{
		$current.merge(this_SINGLE_QUOTED_STRING_0);
	}
	{
		newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall());
	}
;

RULE_UNQUOTED_STRING : '\u00A3$%^\u00A3$%^';

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
