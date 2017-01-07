/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
grammar InternalQVTcore;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;

}

@lexer::header {
package org.eclipse.qvtd.xtext.qvtcore.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.qvtd.xtext.qvtcore.ui.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.qvtd.xtext.qvtcore.services.QVTcoreGrammarAccess;

}

@parser::members {

 	private QVTcoreGrammarAccess grammarAccess;

    public void setGrammarAccess(QVTcoreGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }

    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }

    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleTopLevelCS
entryRuleTopLevelCS
:
{ before(grammarAccess.getTopLevelCSRule()); }
	 ruleTopLevelCS
{ after(grammarAccess.getTopLevelCSRule()); }
	 EOF
;

// Rule TopLevelCS
ruleTopLevelCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTopLevelCSAccess().getGroup()); }
(rule__TopLevelCS__Group__0)
{ after(grammarAccess.getTopLevelCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBottomPatternCS
entryRuleBottomPatternCS
:
{ before(grammarAccess.getBottomPatternCSRule()); }
	 ruleBottomPatternCS
{ after(grammarAccess.getBottomPatternCSRule()); }
	 EOF
;

// Rule BottomPatternCS
ruleBottomPatternCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBottomPatternCSAccess().getAlternatives()); }
(rule__BottomPatternCS__Alternatives)
{ after(grammarAccess.getBottomPatternCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDirectionCS
entryRuleDirectionCS
:
{ before(grammarAccess.getDirectionCSRule()); }
	 ruleDirectionCS
{ after(grammarAccess.getDirectionCSRule()); }
	 EOF
;

// Rule DirectionCS
ruleDirectionCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDirectionCSAccess().getGroup()); }
(rule__DirectionCS__Group__0)
{ after(grammarAccess.getDirectionCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGuardPatternCS
entryRuleGuardPatternCS
:
{ before(grammarAccess.getGuardPatternCSRule()); }
	 ruleGuardPatternCS
{ after(grammarAccess.getGuardPatternCSRule()); }
	 EOF
;

// Rule GuardPatternCS
ruleGuardPatternCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getGuardPatternCSAccess().getAlternatives()); }
(rule__GuardPatternCS__Alternatives)
{ after(grammarAccess.getGuardPatternCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGuardVariableCS
entryRuleGuardVariableCS
:
{ before(grammarAccess.getGuardVariableCSRule()); }
	 ruleGuardVariableCS
{ after(grammarAccess.getGuardVariableCSRule()); }
	 EOF
;

// Rule GuardVariableCS
ruleGuardVariableCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getGuardVariableCSAccess().getGroup()); }
(rule__GuardVariableCS__Group__0)
{ after(grammarAccess.getGuardVariableCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleImportCS
entryRuleImportCS
:
{ before(grammarAccess.getImportCSRule()); }
	 ruleImportCS
{ after(grammarAccess.getImportCSRule()); }
	 EOF
;

// Rule ImportCS
ruleImportCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getImportCSAccess().getGroup()); }
(rule__ImportCS__Group__0)
{ after(grammarAccess.getImportCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMappingCS
entryRuleMappingCS
:
{ before(grammarAccess.getMappingCSRule()); }
	 ruleMappingCS
{ after(grammarAccess.getMappingCSRule()); }
	 EOF
;

// Rule MappingCS
ruleMappingCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMappingCSAccess().getGroup()); }
(rule__MappingCS__Group__0)
{ after(grammarAccess.getMappingCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNamedDomainCS
entryRuleNamedDomainCS
:
{ before(grammarAccess.getNamedDomainCSRule()); }
	 ruleNamedDomainCS
{ after(grammarAccess.getNamedDomainCSRule()); }
	 EOF
;

// Rule NamedDomainCS
ruleNamedDomainCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNamedDomainCSAccess().getGroup()); }
(rule__NamedDomainCS__Group__0)
{ after(grammarAccess.getNamedDomainCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualifiedPackageCS
entryRuleQualifiedPackageCS
:
{ before(grammarAccess.getQualifiedPackageCSRule()); }
	 ruleQualifiedPackageCS
{ after(grammarAccess.getQualifiedPackageCSRule()); }
	 EOF
;

// Rule QualifiedPackageCS
ruleQualifiedPackageCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getGroup()); }
(rule__QualifiedPackageCS__Group__0)
{ after(grammarAccess.getQualifiedPackageCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleParamDeclarationCS
entryRuleParamDeclarationCS
:
{ before(grammarAccess.getParamDeclarationCSRule()); }
	 ruleParamDeclarationCS
{ after(grammarAccess.getParamDeclarationCSRule()); }
	 EOF
;

// Rule ParamDeclarationCS
ruleParamDeclarationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getParamDeclarationCSAccess().getGroup()); }
(rule__ParamDeclarationCS__Group__0)
{ after(grammarAccess.getParamDeclarationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePredicateCS
entryRulePredicateCS
:
{ before(grammarAccess.getPredicateCSRule()); }
	 rulePredicateCS
{ after(grammarAccess.getPredicateCSRule()); }
	 EOF
;

// Rule PredicateCS
rulePredicateCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPredicateCSAccess().getGroup()); }
(rule__PredicateCS__Group__0)
{ after(grammarAccess.getPredicateCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePredicateOrAssignmentCS
entryRulePredicateOrAssignmentCS
:
{ before(grammarAccess.getPredicateOrAssignmentCSRule()); }
	 rulePredicateOrAssignmentCS
{ after(grammarAccess.getPredicateOrAssignmentCSRule()); }
	 EOF
;

// Rule PredicateOrAssignmentCS
rulePredicateOrAssignmentCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getGroup()); }
(rule__PredicateOrAssignmentCS__Group__0)
{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQueryCS
entryRuleQueryCS
:
{ before(grammarAccess.getQueryCSRule()); }
	 ruleQueryCS
{ after(grammarAccess.getQueryCSRule()); }
	 EOF
;

// Rule QueryCS
ruleQueryCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getQueryCSAccess().getGroup()); }
(rule__QueryCS__Group__0)
{ after(grammarAccess.getQueryCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleScopeNameCS
entryRuleScopeNameCS
:
{ before(grammarAccess.getScopeNameCSRule()); }
	 ruleScopeNameCS
{ after(grammarAccess.getScopeNameCSRule()); }
	 EOF
;

// Rule ScopeNameCS
ruleScopeNameCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getScopeNameCSAccess().getGroup()); }
(rule__ScopeNameCS__Group__0)
{ after(grammarAccess.getScopeNameCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTransformationCS
entryRuleTransformationCS
:
{ before(grammarAccess.getTransformationCSRule()); }
	 ruleTransformationCS
{ after(grammarAccess.getTransformationCSRule()); }
	 EOF
;

// Rule TransformationCS
ruleTransformationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTransformationCSAccess().getGroup()); }
(rule__TransformationCS__Group__0)
{ after(grammarAccess.getTransformationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnrealizedVariableCS
entryRuleUnrealizedVariableCS
:
{ before(grammarAccess.getUnrealizedVariableCSRule()); }
	 ruleUnrealizedVariableCS
{ after(grammarAccess.getUnrealizedVariableCSRule()); }
	 EOF
;

// Rule UnrealizedVariableCS
ruleUnrealizedVariableCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getGroup()); }
(rule__UnrealizedVariableCS__Group__0)
{ after(grammarAccess.getUnrealizedVariableCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRealizedVariableCS
entryRuleRealizedVariableCS
:
{ before(grammarAccess.getRealizedVariableCSRule()); }
	 ruleRealizedVariableCS
{ after(grammarAccess.getRealizedVariableCSRule()); }
	 EOF
;

// Rule RealizedVariableCS
ruleRealizedVariableCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRealizedVariableCSAccess().getGroup()); }
(rule__RealizedVariableCS__Group__0)
{ after(grammarAccess.getRealizedVariableCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnnamedDomainCS
entryRuleUnnamedDomainCS
:
{ before(grammarAccess.getUnnamedDomainCSRule()); }
	 ruleUnnamedDomainCS
{ after(grammarAccess.getUnnamedDomainCSRule()); }
	 EOF
;

// Rule UnnamedDomainCS
ruleUnnamedDomainCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnnamedDomainCSAccess().getGroup()); }
(rule__UnnamedDomainCS__Group__0)
{ after(grammarAccess.getUnnamedDomainCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnrestrictedName
entryRuleUnrestrictedName
:
{ before(grammarAccess.getUnrestrictedNameRule()); }
	 ruleUnrestrictedName
{ after(grammarAccess.getUnrestrictedNameRule()); }
	 EOF
;

// Rule UnrestrictedName
ruleUnrestrictedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnrestrictedNameAccess().getAlternatives()); }
(rule__UnrestrictedName__Alternatives)
{ after(grammarAccess.getUnrestrictedNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAttributeCS
entryRuleAttributeCS
:
{ before(grammarAccess.getAttributeCSRule()); }
	 ruleAttributeCS
{ after(grammarAccess.getAttributeCSRule()); }
	 EOF
;

// Rule AttributeCS
ruleAttributeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup()); }
(rule__AttributeCS__Group__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleClassCS
entryRuleClassCS
:
{ before(grammarAccess.getClassCSRule()); }
	 ruleClassCS
{ after(grammarAccess.getClassCSRule()); }
	 EOF
;

// Rule ClassCS
ruleClassCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getClassCSAccess().getAlternatives()); }
(rule__ClassCS__Alternatives)
{ after(grammarAccess.getClassCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDataTypeCS
entryRuleDataTypeCS
:
{ before(grammarAccess.getDataTypeCSRule()); }
	 ruleDataTypeCS
{ after(grammarAccess.getDataTypeCSRule()); }
	 EOF
;

// Rule DataTypeCS
ruleDataTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup()); }
(rule__DataTypeCS__Group__0)
{ after(grammarAccess.getDataTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEnumerationCS
entryRuleEnumerationCS
:
{ before(grammarAccess.getEnumerationCSRule()); }
	 ruleEnumerationCS
{ after(grammarAccess.getEnumerationCSRule()); }
	 EOF
;

// Rule EnumerationCS
ruleEnumerationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup()); }
(rule__EnumerationCS__Group__0)
{ after(grammarAccess.getEnumerationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEnumerationLiteralCS
entryRuleEnumerationLiteralCS
:
{ before(grammarAccess.getEnumerationLiteralCSRule()); }
	 ruleEnumerationLiteralCS
{ after(grammarAccess.getEnumerationLiteralCSRule()); }
	 EOF
;

// Rule EnumerationLiteralCS
ruleEnumerationLiteralCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup()); }
(rule__EnumerationLiteralCS__Group__0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleOperationCS
entryRuleOperationCS
:
{ before(grammarAccess.getOperationCSRule()); }
	 ruleOperationCS
{ after(grammarAccess.getOperationCSRule()); }
	 EOF
;

// Rule OperationCS
ruleOperationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getOperationCSAccess().getGroup()); }
(rule__OperationCS__Group__0)
{ after(grammarAccess.getOperationCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleParameterCS
entryRuleParameterCS
:
{ before(grammarAccess.getParameterCSRule()); }
	 ruleParameterCS
{ after(grammarAccess.getParameterCSRule()); }
	 EOF
;

// Rule ParameterCS
ruleParameterCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getParameterCSAccess().getGroup()); }
(rule__ParameterCS__Group__0)
{ after(grammarAccess.getParameterCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleReferenceCS
entryRuleReferenceCS
:
{ before(grammarAccess.getReferenceCSRule()); }
	 ruleReferenceCS
{ after(grammarAccess.getReferenceCSRule()); }
	 EOF
;

// Rule ReferenceCS
ruleReferenceCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup()); }
(rule__ReferenceCS__Group__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSpecificationCS
entryRuleSpecificationCS
:
{ before(grammarAccess.getSpecificationCSRule()); }
	 ruleSpecificationCS
{ after(grammarAccess.getSpecificationCSRule()); }
	 EOF
;

// Rule SpecificationCS
ruleSpecificationCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSpecificationCSAccess().getAlternatives()); }
(rule__SpecificationCS__Alternatives)
{ after(grammarAccess.getSpecificationCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStructuredClassCS
entryRuleStructuredClassCS
:
{ before(grammarAccess.getStructuredClassCSRule()); }
	 ruleStructuredClassCS
{ after(grammarAccess.getStructuredClassCSRule()); }
	 EOF
;

// Rule StructuredClassCS
ruleStructuredClassCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup()); }
(rule__StructuredClassCS__Group__0)
{ after(grammarAccess.getStructuredClassCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypedMultiplicityRefCS
entryRuleTypedMultiplicityRefCS
:
{ before(grammarAccess.getTypedMultiplicityRefCSRule()); }
	 ruleTypedMultiplicityRefCS
{ after(grammarAccess.getTypedMultiplicityRefCSRule()); }
	 EOF
;

// Rule TypedMultiplicityRefCS
ruleTypedMultiplicityRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getGroup()); }
(rule__TypedMultiplicityRefCS__Group__0)
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStructuralFeatureCS
entryRuleStructuralFeatureCS
:
{ before(grammarAccess.getStructuralFeatureCSRule()); }
	 ruleStructuralFeatureCS
{ after(grammarAccess.getStructuralFeatureCSRule()); }
	 EOF
;

// Rule StructuralFeatureCS
ruleStructuralFeatureCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStructuralFeatureCSAccess().getAlternatives()); }
(rule__StructuralFeatureCS__Alternatives)
{ after(grammarAccess.getStructuralFeatureCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEnumerationLiteralName
entryRuleEnumerationLiteralName
:
{ before(grammarAccess.getEnumerationLiteralNameRule()); }
	 ruleEnumerationLiteralName
{ after(grammarAccess.getEnumerationLiteralNameRule()); }
	 EOF
;

// Rule EnumerationLiteralName
ruleEnumerationLiteralName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEnumerationLiteralNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); }
	ruleEssentialOCLUnrestrictedName
{ after(grammarAccess.getEnumerationLiteralNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSIGNED
entryRuleSIGNED
:
{ before(grammarAccess.getSIGNEDRule()); }
	 ruleSIGNED
{ after(grammarAccess.getSIGNEDRule()); }
	 EOF
;

// Rule SIGNED
ruleSIGNED
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSIGNEDAccess().getGroup()); }
(rule__SIGNED__Group__0)
{ after(grammarAccess.getSIGNEDAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}







// Entry rule entryRuleEssentialOCLUnaryOperatorName
entryRuleEssentialOCLUnaryOperatorName
:
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); }
	 ruleEssentialOCLUnaryOperatorName
{ after(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); }
	 EOF
;

// Rule EssentialOCLUnaryOperatorName
ruleEssentialOCLUnaryOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getAlternatives()); }
(rule__EssentialOCLUnaryOperatorName__Alternatives)
{ after(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLInfixOperatorName
entryRuleEssentialOCLInfixOperatorName
:
{ before(grammarAccess.getEssentialOCLInfixOperatorNameRule()); }
	 ruleEssentialOCLInfixOperatorName
{ after(grammarAccess.getEssentialOCLInfixOperatorNameRule()); }
	 EOF
;

// Rule EssentialOCLInfixOperatorName
ruleEssentialOCLInfixOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAlternatives()); }
(rule__EssentialOCLInfixOperatorName__Alternatives)
{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLNavigationOperatorName
entryRuleEssentialOCLNavigationOperatorName
:
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); }
	 ruleEssentialOCLNavigationOperatorName
{ after(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); }
	 EOF
;

// Rule EssentialOCLNavigationOperatorName
ruleEssentialOCLNavigationOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getAlternatives()); }
(rule__EssentialOCLNavigationOperatorName__Alternatives)
{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBinaryOperatorName
entryRuleBinaryOperatorName
:
{ before(grammarAccess.getBinaryOperatorNameRule()); }
	 ruleBinaryOperatorName
{ after(grammarAccess.getBinaryOperatorNameRule()); }
	 EOF
;

// Rule BinaryOperatorName
ruleBinaryOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBinaryOperatorNameAccess().getAlternatives()); }
(rule__BinaryOperatorName__Alternatives)
{ after(grammarAccess.getBinaryOperatorNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInfixOperatorName
entryRuleInfixOperatorName
:
{ before(grammarAccess.getInfixOperatorNameRule()); }
	 ruleInfixOperatorName
{ after(grammarAccess.getInfixOperatorNameRule()); }
	 EOF
;

// Rule InfixOperatorName
ruleInfixOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); }
	ruleEssentialOCLInfixOperatorName
{ after(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigationOperatorName
entryRuleNavigationOperatorName
:
{ before(grammarAccess.getNavigationOperatorNameRule()); }
	 ruleNavigationOperatorName
{ after(grammarAccess.getNavigationOperatorNameRule()); }
	 EOF
;

// Rule NavigationOperatorName
ruleNavigationOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); }
	ruleEssentialOCLNavigationOperatorName
{ after(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnaryOperatorName
entryRuleUnaryOperatorName
:
{ before(grammarAccess.getUnaryOperatorNameRule()); }
	 ruleUnaryOperatorName
{ after(grammarAccess.getUnaryOperatorNameRule()); }
	 EOF
;

// Rule UnaryOperatorName
ruleUnaryOperatorName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); }
	ruleEssentialOCLUnaryOperatorName
{ after(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLUnrestrictedName
entryRuleEssentialOCLUnrestrictedName
:
{ before(grammarAccess.getEssentialOCLUnrestrictedNameRule()); }
	 ruleEssentialOCLUnrestrictedName
{ after(grammarAccess.getEssentialOCLUnrestrictedNameRule()); }
	 EOF
;

// Rule EssentialOCLUnrestrictedName
ruleEssentialOCLUnrestrictedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); }
	ruleIdentifier
{ after(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEssentialOCLUnreservedName
entryRuleEssentialOCLUnreservedName
:
{ before(grammarAccess.getEssentialOCLUnreservedNameRule()); }
	 ruleEssentialOCLUnreservedName
{ after(grammarAccess.getEssentialOCLUnreservedNameRule()); }
	 EOF
;

// Rule EssentialOCLUnreservedName
ruleEssentialOCLUnreservedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives()); }
(rule__EssentialOCLUnreservedName__Alternatives)
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnreservedName
entryRuleUnreservedName
:
{ before(grammarAccess.getUnreservedNameRule()); }
	 ruleUnreservedName
{ after(grammarAccess.getUnreservedNameRule()); }
	 EOF
;

// Rule UnreservedName
ruleUnreservedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); }
	ruleEssentialOCLUnreservedName
{ after(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURIPathNameCS
entryRuleURIPathNameCS
:
{ before(grammarAccess.getURIPathNameCSRule()); }
	 ruleURIPathNameCS
{ after(grammarAccess.getURIPathNameCSRule()); }
	 EOF
;

// Rule URIPathNameCS
ruleURIPathNameCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIPathNameCSAccess().getGroup()); }
(rule__URIPathNameCS__Group__0)
{ after(grammarAccess.getURIPathNameCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURIFirstPathElementCS
entryRuleURIFirstPathElementCS
:
{ before(grammarAccess.getURIFirstPathElementCSRule()); }
	 ruleURIFirstPathElementCS
{ after(grammarAccess.getURIFirstPathElementCSRule()); }
	 EOF
;

// Rule URIFirstPathElementCS
ruleURIFirstPathElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getAlternatives()); }
(rule__URIFirstPathElementCS__Alternatives)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimitiveTypeIdentifier
entryRulePrimitiveTypeIdentifier
:
{ before(grammarAccess.getPrimitiveTypeIdentifierRule()); }
	 rulePrimitiveTypeIdentifier
{ after(grammarAccess.getPrimitiveTypeIdentifierRule()); }
	 EOF
;

// Rule PrimitiveTypeIdentifier
rulePrimitiveTypeIdentifier
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives()); }
(rule__PrimitiveTypeIdentifier__Alternatives)
{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimitiveTypeCS
entryRulePrimitiveTypeCS
:
{ before(grammarAccess.getPrimitiveTypeCSRule()); }
	 rulePrimitiveTypeCS
{ after(grammarAccess.getPrimitiveTypeCSRule()); }
	 EOF
;

// Rule PrimitiveTypeCS
rulePrimitiveTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimitiveTypeCSAccess().getNameAssignment()); }
(rule__PrimitiveTypeCS__NameAssignment)
{ after(grammarAccess.getPrimitiveTypeCSAccess().getNameAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionTypeIdentifier
entryRuleCollectionTypeIdentifier
:
{ before(grammarAccess.getCollectionTypeIdentifierRule()); }
	 ruleCollectionTypeIdentifier
{ after(grammarAccess.getCollectionTypeIdentifierRule()); }
	 EOF
;

// Rule CollectionTypeIdentifier
ruleCollectionTypeIdentifier
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives()); }
(rule__CollectionTypeIdentifier__Alternatives)
{ after(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionTypeCS
entryRuleCollectionTypeCS
:
{ before(grammarAccess.getCollectionTypeCSRule()); }
	 ruleCollectionTypeCS
{ after(grammarAccess.getCollectionTypeCSRule()); }
	 EOF
;

// Rule CollectionTypeCS
ruleCollectionTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getGroup()); }
(rule__CollectionTypeCS__Group__0)
{ after(grammarAccess.getCollectionTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMapTypeCS
entryRuleMapTypeCS
:
{ before(grammarAccess.getMapTypeCSRule()); }
	 ruleMapTypeCS
{ after(grammarAccess.getMapTypeCSRule()); }
	 EOF
;

// Rule MapTypeCS
ruleMapTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMapTypeCSAccess().getGroup()); }
(rule__MapTypeCS__Group__0)
{ after(grammarAccess.getMapTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTupleTypeCS
entryRuleTupleTypeCS
:
{ before(grammarAccess.getTupleTypeCSRule()); }
	 ruleTupleTypeCS
{ after(grammarAccess.getTupleTypeCSRule()); }
	 EOF
;

// Rule TupleTypeCS
ruleTupleTypeCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup()); }
(rule__TupleTypeCS__Group__0)
{ after(grammarAccess.getTupleTypeCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTuplePartCS
entryRuleTuplePartCS
:
{ before(grammarAccess.getTuplePartCSRule()); }
	 ruleTuplePartCS
{ after(grammarAccess.getTuplePartCSRule()); }
	 EOF
;

// Rule TuplePartCS
ruleTuplePartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTuplePartCSAccess().getGroup()); }
(rule__TuplePartCS__Group__0)
{ after(grammarAccess.getTuplePartCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionLiteralExpCS
entryRuleCollectionLiteralExpCS
:
{ before(grammarAccess.getCollectionLiteralExpCSRule()); }
	 ruleCollectionLiteralExpCS
{ after(grammarAccess.getCollectionLiteralExpCSRule()); }
	 EOF
;

// Rule CollectionLiteralExpCS
ruleCollectionLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup()); }
(rule__CollectionLiteralExpCS__Group__0)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionLiteralPartCS
entryRuleCollectionLiteralPartCS
:
{ before(grammarAccess.getCollectionLiteralPartCSRule()); }
	 ruleCollectionLiteralPartCS
{ after(grammarAccess.getCollectionLiteralPartCSRule()); }
	 EOF
;

// Rule CollectionLiteralPartCS
ruleCollectionLiteralPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getAlternatives()); }
(rule__CollectionLiteralPartCS__Alternatives)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCollectionPatternCS
entryRuleCollectionPatternCS
:
{ before(grammarAccess.getCollectionPatternCSRule()); }
	 ruleCollectionPatternCS
{ after(grammarAccess.getCollectionPatternCSRule()); }
	 EOF
;

// Rule CollectionPatternCS
ruleCollectionPatternCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup()); }
(rule__CollectionPatternCS__Group__0)
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleShadowPartCS
entryRuleShadowPartCS
:
{ before(grammarAccess.getShadowPartCSRule()); }
	 ruleShadowPartCS
{ after(grammarAccess.getShadowPartCSRule()); }
	 EOF
;

// Rule ShadowPartCS
ruleShadowPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getShadowPartCSAccess().getAlternatives()); }
(rule__ShadowPartCS__Alternatives)
{ after(grammarAccess.getShadowPartCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePatternExpCS
entryRulePatternExpCS
:
{ before(grammarAccess.getPatternExpCSRule()); }
	 rulePatternExpCS
{ after(grammarAccess.getPatternExpCSRule()); }
	 EOF
;

// Rule PatternExpCS
rulePatternExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPatternExpCSAccess().getGroup()); }
(rule__PatternExpCS__Group__0)
{ after(grammarAccess.getPatternExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLambdaLiteralExpCS
entryRuleLambdaLiteralExpCS
:
{ before(grammarAccess.getLambdaLiteralExpCSRule()); }
	 ruleLambdaLiteralExpCS
{ after(grammarAccess.getLambdaLiteralExpCSRule()); }
	 EOF
;

// Rule LambdaLiteralExpCS
ruleLambdaLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getGroup()); }
(rule__LambdaLiteralExpCS__Group__0)
{ after(grammarAccess.getLambdaLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMapLiteralExpCS
entryRuleMapLiteralExpCS
:
{ before(grammarAccess.getMapLiteralExpCSRule()); }
	 ruleMapLiteralExpCS
{ after(grammarAccess.getMapLiteralExpCSRule()); }
	 EOF
;

// Rule MapLiteralExpCS
ruleMapLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getGroup()); }
(rule__MapLiteralExpCS__Group__0)
{ after(grammarAccess.getMapLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMapLiteralPartCS
entryRuleMapLiteralPartCS
:
{ before(grammarAccess.getMapLiteralPartCSRule()); }
	 ruleMapLiteralPartCS
{ after(grammarAccess.getMapLiteralPartCSRule()); }
	 EOF
;

// Rule MapLiteralPartCS
ruleMapLiteralPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getGroup()); }
(rule__MapLiteralPartCS__Group__0)
{ after(grammarAccess.getMapLiteralPartCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimitiveLiteralExpCS
entryRulePrimitiveLiteralExpCS
:
{ before(grammarAccess.getPrimitiveLiteralExpCSRule()); }
	 rulePrimitiveLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSRule()); }
	 EOF
;

// Rule PrimitiveLiteralExpCS
rulePrimitiveLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives()); }
(rule__PrimitiveLiteralExpCS__Alternatives)
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTupleLiteralExpCS
entryRuleTupleLiteralExpCS
:
{ before(grammarAccess.getTupleLiteralExpCSRule()); }
	 ruleTupleLiteralExpCS
{ after(grammarAccess.getTupleLiteralExpCSRule()); }
	 EOF
;

// Rule TupleLiteralExpCS
ruleTupleLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getGroup()); }
(rule__TupleLiteralExpCS__Group__0)
{ after(grammarAccess.getTupleLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTupleLiteralPartCS
entryRuleTupleLiteralPartCS
:
{ before(grammarAccess.getTupleLiteralPartCSRule()); }
	 ruleTupleLiteralPartCS
{ after(grammarAccess.getTupleLiteralPartCSRule()); }
	 EOF
;

// Rule TupleLiteralPartCS
ruleTupleLiteralPartCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getGroup()); }
(rule__TupleLiteralPartCS__Group__0)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNumberLiteralExpCS
entryRuleNumberLiteralExpCS
:
{ before(grammarAccess.getNumberLiteralExpCSRule()); }
	 ruleNumberLiteralExpCS
{ after(grammarAccess.getNumberLiteralExpCSRule()); }
	 EOF
;

// Rule NumberLiteralExpCS
ruleNumberLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNumberLiteralExpCSAccess().getSymbolAssignment()); }
(rule__NumberLiteralExpCS__SymbolAssignment)
{ after(grammarAccess.getNumberLiteralExpCSAccess().getSymbolAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStringLiteralExpCS
entryRuleStringLiteralExpCS
:
{ before(grammarAccess.getStringLiteralExpCSRule()); }
	 ruleStringLiteralExpCS
{ after(grammarAccess.getStringLiteralExpCSRule()); }
	 EOF
;

// Rule StringLiteralExpCS
ruleStringLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
(
{ before(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
(rule__StringLiteralExpCS__SegmentsAssignment)
{ after(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
)
(
{ before(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
(rule__StringLiteralExpCS__SegmentsAssignment)*
{ after(grammarAccess.getStringLiteralExpCSAccess().getSegmentsAssignment()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleBooleanLiteralExpCS
entryRuleBooleanLiteralExpCS
:
{ before(grammarAccess.getBooleanLiteralExpCSRule()); }
	 ruleBooleanLiteralExpCS
{ after(grammarAccess.getBooleanLiteralExpCSRule()); }
	 EOF
;

// Rule BooleanLiteralExpCS
ruleBooleanLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives()); }
(rule__BooleanLiteralExpCS__Alternatives)
{ after(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnlimitedNaturalLiteralExpCS
entryRuleUnlimitedNaturalLiteralExpCS
:
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); }
	 ruleUnlimitedNaturalLiteralExpCS
{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); }
	 EOF
;

// Rule UnlimitedNaturalLiteralExpCS
ruleUnlimitedNaturalLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup()); }
(rule__UnlimitedNaturalLiteralExpCS__Group__0)
{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInvalidLiteralExpCS
entryRuleInvalidLiteralExpCS
:
{ before(grammarAccess.getInvalidLiteralExpCSRule()); }
	 ruleInvalidLiteralExpCS
{ after(grammarAccess.getInvalidLiteralExpCSRule()); }
	 EOF
;

// Rule InvalidLiteralExpCS
ruleInvalidLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getInvalidLiteralExpCSAccess().getGroup()); }
(rule__InvalidLiteralExpCS__Group__0)
{ after(grammarAccess.getInvalidLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNullLiteralExpCS
entryRuleNullLiteralExpCS
:
{ before(grammarAccess.getNullLiteralExpCSRule()); }
	 ruleNullLiteralExpCS
{ after(grammarAccess.getNullLiteralExpCSRule()); }
	 EOF
;

// Rule NullLiteralExpCS
ruleNullLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNullLiteralExpCSAccess().getGroup()); }
(rule__NullLiteralExpCS__Group__0)
{ after(grammarAccess.getNullLiteralExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeLiteralCS
entryRuleTypeLiteralCS
:
{ before(grammarAccess.getTypeLiteralCSRule()); }
	 ruleTypeLiteralCS
{ after(grammarAccess.getTypeLiteralCSRule()); }
	 EOF
;

// Rule TypeLiteralCS
ruleTypeLiteralCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeLiteralCSAccess().getAlternatives()); }
(rule__TypeLiteralCS__Alternatives)
{ after(grammarAccess.getTypeLiteralCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeLiteralWithMultiplicityCS
entryRuleTypeLiteralWithMultiplicityCS
:
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); }
	 ruleTypeLiteralWithMultiplicityCS
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); }
	 EOF
;

// Rule TypeLiteralWithMultiplicityCS
ruleTypeLiteralWithMultiplicityCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getGroup()); }
(rule__TypeLiteralWithMultiplicityCS__Group__0)
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeLiteralExpCS
entryRuleTypeLiteralExpCS
:
{ before(grammarAccess.getTypeLiteralExpCSRule()); }
	 ruleTypeLiteralExpCS
{ after(grammarAccess.getTypeLiteralExpCSRule()); }
	 EOF
;

// Rule TypeLiteralExpCS
ruleTypeLiteralExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeAssignment()); }
(rule__TypeLiteralExpCS__OwnedTypeAssignment)
{ after(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeNameExpCS
entryRuleTypeNameExpCS
:
{ before(grammarAccess.getTypeNameExpCSRule()); }
	 ruleTypeNameExpCS
{ after(grammarAccess.getTypeNameExpCSRule()); }
	 EOF
;

// Rule TypeNameExpCS
ruleTypeNameExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getGroup()); }
(rule__TypeNameExpCS__Group__0)
{ after(grammarAccess.getTypeNameExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeExpCS
entryRuleTypeExpCS
:
{ before(grammarAccess.getTypeExpCSRule()); }
	 ruleTypeExpCS
{ after(grammarAccess.getTypeExpCSRule()); }
	 EOF
;

// Rule TypeExpCS
ruleTypeExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeExpCSAccess().getGroup()); }
(rule__TypeExpCS__Group__0)
{ after(grammarAccess.getTypeExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleExpCS
entryRuleExpCS
:
{ before(grammarAccess.getExpCSRule()); }
	 ruleExpCS
{ after(grammarAccess.getExpCSRule()); }
	 EOF
;

// Rule ExpCS
ruleExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getExpCSAccess().getAlternatives()); }
(rule__ExpCS__Alternatives)
{ after(grammarAccess.getExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrefixedLetExpCS
entryRulePrefixedLetExpCS
:
{ before(grammarAccess.getPrefixedLetExpCSRule()); }
	 rulePrefixedLetExpCS
{ after(grammarAccess.getPrefixedLetExpCSRule()); }
	 EOF
;

// Rule PrefixedLetExpCS
rulePrefixedLetExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getAlternatives()); }
(rule__PrefixedLetExpCS__Alternatives)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrefixedPrimaryExpCS
entryRulePrefixedPrimaryExpCS
:
{ before(grammarAccess.getPrefixedPrimaryExpCSRule()); }
	 rulePrefixedPrimaryExpCS
{ after(grammarAccess.getPrefixedPrimaryExpCSRule()); }
	 EOF
;

// Rule PrefixedPrimaryExpCS
rulePrefixedPrimaryExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getAlternatives()); }
(rule__PrefixedPrimaryExpCS__Alternatives)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePrimaryExpCS
entryRulePrimaryExpCS
:
{ before(grammarAccess.getPrimaryExpCSRule()); }
	 rulePrimaryExpCS
{ after(grammarAccess.getPrimaryExpCSRule()); }
	 EOF
;

// Rule PrimaryExpCS
rulePrimaryExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); }
(rule__PrimaryExpCS__Alternatives)
{ after(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNameExpCS
entryRuleNameExpCS
:
{ before(grammarAccess.getNameExpCSRule()); }
	 ruleNameExpCS
{ after(grammarAccess.getNameExpCSRule()); }
	 EOF
;

// Rule NameExpCS
ruleNameExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNameExpCSAccess().getGroup()); }
(rule__NameExpCS__Group__0)
{ after(grammarAccess.getNameExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCurlyBracketedClauseCS
entryRuleCurlyBracketedClauseCS
:
{ before(grammarAccess.getCurlyBracketedClauseCSRule()); }
	 ruleCurlyBracketedClauseCS
{ after(grammarAccess.getCurlyBracketedClauseCSRule()); }
	 EOF
;

// Rule CurlyBracketedClauseCS
ruleCurlyBracketedClauseCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup()); }
(rule__CurlyBracketedClauseCS__Group__0)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRoundBracketedClauseCS
entryRuleRoundBracketedClauseCS
:
{ before(grammarAccess.getRoundBracketedClauseCSRule()); }
	 ruleRoundBracketedClauseCS
{ after(grammarAccess.getRoundBracketedClauseCSRule()); }
	 EOF
;

// Rule RoundBracketedClauseCS
ruleRoundBracketedClauseCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getGroup()); }
(rule__RoundBracketedClauseCS__Group__0)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSquareBracketedClauseCS
entryRuleSquareBracketedClauseCS
:
{ before(grammarAccess.getSquareBracketedClauseCSRule()); }
	 ruleSquareBracketedClauseCS
{ after(grammarAccess.getSquareBracketedClauseCSRule()); }
	 EOF
;

// Rule SquareBracketedClauseCS
ruleSquareBracketedClauseCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getGroup()); }
(rule__SquareBracketedClauseCS__Group__0)
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingArgCS
entryRuleNavigatingArgCS
:
{ before(grammarAccess.getNavigatingArgCSRule()); }
	 ruleNavigatingArgCS
{ after(grammarAccess.getNavigatingArgCSRule()); }
	 EOF
;

// Rule NavigatingArgCS
ruleNavigatingArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getAlternatives()); }
(rule__NavigatingArgCS__Alternatives)
{ after(grammarAccess.getNavigatingArgCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingBarArgCS
entryRuleNavigatingBarArgCS
:
{ before(grammarAccess.getNavigatingBarArgCSRule()); }
	 ruleNavigatingBarArgCS
{ after(grammarAccess.getNavigatingBarArgCSRule()); }
	 EOF
;

// Rule NavigatingBarArgCS
ruleNavigatingBarArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getGroup()); }
(rule__NavigatingBarArgCS__Group__0)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingCommaArgCS
entryRuleNavigatingCommaArgCS
:
{ before(grammarAccess.getNavigatingCommaArgCSRule()); }
	 ruleNavigatingCommaArgCS
{ after(grammarAccess.getNavigatingCommaArgCSRule()); }
	 EOF
;

// Rule NavigatingCommaArgCS
ruleNavigatingCommaArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup()); }
(rule__NavigatingCommaArgCS__Group__0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingSemiArgCS
entryRuleNavigatingSemiArgCS
:
{ before(grammarAccess.getNavigatingSemiArgCSRule()); }
	 ruleNavigatingSemiArgCS
{ after(grammarAccess.getNavigatingSemiArgCSRule()); }
	 EOF
;

// Rule NavigatingSemiArgCS
ruleNavigatingSemiArgCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getGroup()); }
(rule__NavigatingSemiArgCS__Group__0)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNavigatingArgExpCS
entryRuleNavigatingArgExpCS
:
{ before(grammarAccess.getNavigatingArgExpCSRule()); }
	 ruleNavigatingArgExpCS
{ after(grammarAccess.getNavigatingArgExpCSRule()); }
	 EOF
;

// Rule NavigatingArgExpCS
ruleNavigatingArgExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); }
	ruleExpCS
{ after(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIfExpCS
entryRuleIfExpCS
:
{ before(grammarAccess.getIfExpCSRule()); }
	 ruleIfExpCS
{ after(grammarAccess.getIfExpCSRule()); }
	 EOF
;

// Rule IfExpCS
ruleIfExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIfExpCSAccess().getGroup()); }
(rule__IfExpCS__Group__0)
{ after(grammarAccess.getIfExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleElseIfThenExpCS
entryRuleElseIfThenExpCS
:
{ before(grammarAccess.getElseIfThenExpCSRule()); }
	 ruleElseIfThenExpCS
{ after(grammarAccess.getElseIfThenExpCSRule()); }
	 EOF
;

// Rule ElseIfThenExpCS
ruleElseIfThenExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getGroup()); }
(rule__ElseIfThenExpCS__Group__0)
{ after(grammarAccess.getElseIfThenExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLetExpCS
entryRuleLetExpCS
:
{ before(grammarAccess.getLetExpCSRule()); }
	 ruleLetExpCS
{ after(grammarAccess.getLetExpCSRule()); }
	 EOF
;

// Rule LetExpCS
ruleLetExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLetExpCSAccess().getGroup()); }
(rule__LetExpCS__Group__0)
{ after(grammarAccess.getLetExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLetVariableCS
entryRuleLetVariableCS
:
{ before(grammarAccess.getLetVariableCSRule()); }
	 ruleLetVariableCS
{ after(grammarAccess.getLetVariableCSRule()); }
	 EOF
;

// Rule LetVariableCS
ruleLetVariableCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLetVariableCSAccess().getGroup()); }
(rule__LetVariableCS__Group__0)
{ after(grammarAccess.getLetVariableCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNestedExpCS
entryRuleNestedExpCS
:
{ before(grammarAccess.getNestedExpCSRule()); }
	 ruleNestedExpCS
{ after(grammarAccess.getNestedExpCSRule()); }
	 EOF
;

// Rule NestedExpCS
ruleNestedExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNestedExpCSAccess().getGroup()); }
(rule__NestedExpCS__Group__0)
{ after(grammarAccess.getNestedExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSelfExpCS
entryRuleSelfExpCS
:
{ before(grammarAccess.getSelfExpCSRule()); }
	 ruleSelfExpCS
{ after(grammarAccess.getSelfExpCSRule()); }
	 EOF
;

// Rule SelfExpCS
ruleSelfExpCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSelfExpCSAccess().getGroup()); }
(rule__SelfExpCS__Group__0)
{ after(grammarAccess.getSelfExpCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMultiplicityBoundsCS
entryRuleMultiplicityBoundsCS
:
{ before(grammarAccess.getMultiplicityBoundsCSRule()); }
	 ruleMultiplicityBoundsCS
{ after(grammarAccess.getMultiplicityBoundsCSRule()); }
	 EOF
;

// Rule MultiplicityBoundsCS
ruleMultiplicityBoundsCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); }
(rule__MultiplicityBoundsCS__Group__0)
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMultiplicityCS
entryRuleMultiplicityCS
:
{ before(grammarAccess.getMultiplicityCSRule()); }
	 ruleMultiplicityCS
{ after(grammarAccess.getMultiplicityCSRule()); }
	 EOF
;

// Rule MultiplicityCS
ruleMultiplicityCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMultiplicityCSAccess().getGroup()); }
(rule__MultiplicityCS__Group__0)
{ after(grammarAccess.getMultiplicityCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleMultiplicityStringCS
entryRuleMultiplicityStringCS
:
{ before(grammarAccess.getMultiplicityStringCSRule()); }
	 ruleMultiplicityStringCS
{ after(grammarAccess.getMultiplicityStringCSRule()); }
	 EOF
;

// Rule MultiplicityStringCS
ruleMultiplicityStringCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); }
(rule__MultiplicityStringCS__StringBoundsAssignment)
{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRulePathNameCS
entryRulePathNameCS
:
{ before(grammarAccess.getPathNameCSRule()); }
	 rulePathNameCS
{ after(grammarAccess.getPathNameCSRule()); }
	 EOF
;

// Rule PathNameCS
rulePathNameCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getPathNameCSAccess().getGroup()); }
(rule__PathNameCS__Group__0)
{ after(grammarAccess.getPathNameCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFirstPathElementCS
entryRuleFirstPathElementCS
:
{ before(grammarAccess.getFirstPathElementCSRule()); }
	 ruleFirstPathElementCS
{ after(grammarAccess.getFirstPathElementCSRule()); }
	 EOF
;

// Rule FirstPathElementCS
ruleFirstPathElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); }
(rule__FirstPathElementCS__ReferredElementAssignment)
{ after(grammarAccess.getFirstPathElementCSAccess().getReferredElementAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNextPathElementCS
entryRuleNextPathElementCS
:
{ before(grammarAccess.getNextPathElementCSRule()); }
	 ruleNextPathElementCS
{ after(grammarAccess.getNextPathElementCSRule()); }
	 EOF
;

// Rule NextPathElementCS
ruleNextPathElementCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); }
(rule__NextPathElementCS__ReferredElementAssignment)
{ after(grammarAccess.getNextPathElementCSAccess().getReferredElementAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTemplateBindingCS
entryRuleTemplateBindingCS
:
{ before(grammarAccess.getTemplateBindingCSRule()); }
	 ruleTemplateBindingCS
{ after(grammarAccess.getTemplateBindingCSRule()); }
	 EOF
;

// Rule TemplateBindingCS
ruleTemplateBindingCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getGroup()); }
(rule__TemplateBindingCS__Group__0)
{ after(grammarAccess.getTemplateBindingCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTemplateParameterSubstitutionCS
entryRuleTemplateParameterSubstitutionCS
:
{ before(grammarAccess.getTemplateParameterSubstitutionCSRule()); }
	 ruleTemplateParameterSubstitutionCS
{ after(grammarAccess.getTemplateParameterSubstitutionCSRule()); }
	 EOF
;

// Rule TemplateParameterSubstitutionCS
ruleTemplateParameterSubstitutionCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); }
(rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment)
{ after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTemplateSignatureCS
entryRuleTemplateSignatureCS
:
{ before(grammarAccess.getTemplateSignatureCSRule()); }
	 ruleTemplateSignatureCS
{ after(grammarAccess.getTemplateSignatureCSRule()); }
	 EOF
;

// Rule TemplateSignatureCS
ruleTemplateSignatureCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup()); }
(rule__TemplateSignatureCS__Group__0)
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeParameterCS
entryRuleTypeParameterCS
:
{ before(grammarAccess.getTypeParameterCSRule()); }
	 ruleTypeParameterCS
{ after(grammarAccess.getTypeParameterCSRule()); }
	 EOF
;

// Rule TypeParameterCS
ruleTypeParameterCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeParameterCSAccess().getGroup()); }
(rule__TypeParameterCS__Group__0)
{ after(grammarAccess.getTypeParameterCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeRefCS
entryRuleTypeRefCS
:
{ before(grammarAccess.getTypeRefCSRule()); }
	 ruleTypeRefCS
{ after(grammarAccess.getTypeRefCSRule()); }
	 EOF
;

// Rule TypeRefCS
ruleTypeRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeRefCSAccess().getAlternatives()); }
(rule__TypeRefCS__Alternatives)
{ after(grammarAccess.getTypeRefCSAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypedRefCS
entryRuleTypedRefCS
:
{ before(grammarAccess.getTypedRefCSRule()); }
	 ruleTypedRefCS
{ after(grammarAccess.getTypedRefCSRule()); }
	 EOF
;

// Rule TypedRefCS
ruleTypedRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); }
	ruleTypedTypeRefCS
{ after(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypedTypeRefCS
entryRuleTypedTypeRefCS
:
{ before(grammarAccess.getTypedTypeRefCSRule()); }
	 ruleTypedTypeRefCS
{ after(grammarAccess.getTypedTypeRefCSRule()); }
	 EOF
;

// Rule TypedTypeRefCS
ruleTypedTypeRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup()); }
(rule__TypedTypeRefCS__Group__0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleWildcardTypeRefCS
entryRuleWildcardTypeRefCS
:
{ before(grammarAccess.getWildcardTypeRefCSRule()); }
	 ruleWildcardTypeRefCS
{ after(grammarAccess.getWildcardTypeRefCSRule()); }
	 EOF
;

// Rule WildcardTypeRefCS
ruleWildcardTypeRefCS
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); }
(rule__WildcardTypeRefCS__Group__0)
{ after(grammarAccess.getWildcardTypeRefCSAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleID
entryRuleID
:
{ before(grammarAccess.getIDRule()); }
	 ruleID
{ after(grammarAccess.getIDRule()); }
	 EOF
;

// Rule ID
ruleID
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIDAccess().getAlternatives()); }
(rule__ID__Alternatives)
{ after(grammarAccess.getIDAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIdentifier
entryRuleIdentifier
:
{ before(grammarAccess.getIdentifierRule()); }
	 ruleIdentifier
{ after(grammarAccess.getIdentifierRule()); }
	 EOF
;

// Rule Identifier
ruleIdentifier
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); }
	ruleID
{ after(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLOWER
entryRuleLOWER
:
{ before(grammarAccess.getLOWERRule()); }
	 ruleLOWER
{ after(grammarAccess.getLOWERRule()); }
	 EOF
;

// Rule LOWER
ruleLOWER
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); }
	RULE_INT
{ after(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNUMBER_LITERAL
entryRuleNUMBER_LITERAL
:
{ before(grammarAccess.getNUMBER_LITERALRule()); }
	 ruleNUMBER_LITERAL
{ after(grammarAccess.getNUMBER_LITERALRule()); }
	 EOF
;

// Rule NUMBER_LITERAL
ruleNUMBER_LITERAL
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall()); }
	RULE_INT
{ after(grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStringLiteral
entryRuleStringLiteral
:
{ before(grammarAccess.getStringLiteralRule()); }
	 ruleStringLiteral
{ after(grammarAccess.getStringLiteralRule()); }
	 EOF
;

// Rule StringLiteral
ruleStringLiteral
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUPPER
entryRuleUPPER
:
{ before(grammarAccess.getUPPERRule()); }
	 ruleUPPER
{ after(grammarAccess.getUPPERRule()); }
	 EOF
;

// Rule UPPER
ruleUPPER
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUPPERAccess().getAlternatives()); }
(rule__UPPER__Alternatives)
{ after(grammarAccess.getUPPERAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleURI
entryRuleURI
:
{ before(grammarAccess.getURIRule()); }
	 ruleURI
{ after(grammarAccess.getURIRule()); }
	 EOF
;

// Rule URI
ruleURI
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
	RULE_SINGLE_QUOTED_STRING
{ after(grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__TopLevelCS__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedPackagesAssignment_1_0()); }
(rule__TopLevelCS__OwnedPackagesAssignment_1_0)
{ after(grammarAccess.getTopLevelCSAccess().getOwnedPackagesAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsAssignment_1_1()); }
(rule__TopLevelCS__OwnedTransformationsAssignment_1_1)
{ after(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsAssignment_1_1()); }
)

    |(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedMappingsAssignment_1_2()); }
(rule__TopLevelCS__OwnedMappingsAssignment_1_2)
{ after(grammarAccess.getTopLevelCSAccess().getOwnedMappingsAssignment_1_2()); }
)

    |(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedQueriesAssignment_1_3()); }
(rule__TopLevelCS__OwnedQueriesAssignment_1_3)
{ after(grammarAccess.getTopLevelCSAccess().getOwnedQueriesAssignment_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getGroup_0()); }
(rule__BottomPatternCS__Group_0__0)
{ after(grammarAccess.getBottomPatternCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getBottomPatternCSAccess().getGroup_1()); }
(rule__BottomPatternCS__Group_1__0)
{ after(grammarAccess.getBottomPatternCSAccess().getGroup_1()); }
)

    |(
{ before(grammarAccess.getBottomPatternCSAccess().getGroup_2()); }
(rule__BottomPatternCS__Group_2__0)
{ after(grammarAccess.getBottomPatternCSAccess().getGroup_2()); }
)

    |(
{ before(grammarAccess.getBottomPatternCSAccess().getGroup_3()); }
(rule__BottomPatternCS__Group_3__0)
{ after(grammarAccess.getBottomPatternCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Alternatives_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_1_0()); }
(rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_0_1_0)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_1_0()); }
)

    |(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_0_1_1()); }
(rule__BottomPatternCS__OwnedRealizedVariablesAssignment_0_1_1)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Alternatives_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_2_1_0()); }
(rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_0_2_1_0)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_2_1_0()); }
)

    |(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_0_2_1_1()); }
(rule__BottomPatternCS__OwnedRealizedVariablesAssignment_0_2_1_1)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_0_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Alternatives_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_1_0()); }
(rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_1_1_0)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_1_0()); }
)

    |(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_1_1_1()); }
(rule__BottomPatternCS__OwnedRealizedVariablesAssignment_1_1_1)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Alternatives_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_2_1_0()); }
(rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_1_2_1_0)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_2_1_0()); }
)

    |(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_1_2_1_1()); }
(rule__BottomPatternCS__OwnedRealizedVariablesAssignment_1_2_1_1)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesAssignment_1_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getGroup_0()); }
(rule__GuardPatternCS__Group_0__0)
{ after(grammarAccess.getGuardPatternCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getGuardPatternCSAccess().getGroup_1()); }
(rule__GuardPatternCS__Group_1__0)
{ after(grammarAccess.getGuardPatternCSAccess().getGroup_1()); }
)

    |(
{ before(grammarAccess.getGuardPatternCSAccess().getGroup_2()); }
(rule__GuardPatternCS__Group_2__0)
{ after(grammarAccess.getGuardPatternCSAccess().getGroup_2()); }
)

    |(
{ before(grammarAccess.getGuardPatternCSAccess().getGroup_3()); }
(rule__GuardPatternCS__Group_3__0)
{ after(grammarAccess.getGuardPatternCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Alternatives_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getGroup_5_0()); }
(rule__QualifiedPackageCS__Group_5_0__0)
{ after(grammarAccess.getQualifiedPackageCSAccess().getGroup_5_0()); }
)

    |(
{ before(grammarAccess.getQualifiedPackageCSAccess().getSemicolonKeyword_5_1()); }

	';'

{ after(grammarAccess.getQualifiedPackageCSAccess().getSemicolonKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Alternatives_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedPackagesAssignment_5_0_1_0()); }
(rule__QualifiedPackageCS__OwnedPackagesAssignment_5_0_1_0)
{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedPackagesAssignment_5_0_1_0()); }
)

    |(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesAssignment_5_0_1_1()); }
(rule__QualifiedPackageCS__OwnedClassesAssignment_5_0_1_1)
{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesAssignment_5_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__OwnedClassesAlternatives_5_0_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesClassCSParserRuleCall_5_0_1_1_0_0()); }
	ruleClassCS
{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesClassCSParserRuleCall_5_0_1_1_0_0()); }
)

    |(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesTransformationCSParserRuleCall_5_0_1_1_0_1()); }
	ruleTransformationCS
{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesTransformationCSParserRuleCall_5_0_1_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__Alternatives_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getColonEqualsSignKeyword_2_0_0()); }

	':='

{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getColonEqualsSignKeyword_2_0_0()); }
)

    |(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getIsPartialAssignment_2_0_1()); }
(rule__PredicateOrAssignmentCS__IsPartialAssignment_2_0_1)
{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getIsPartialAssignment_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Alternatives_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getSemicolonKeyword_9_0()); }

	';'

{ after(grammarAccess.getQueryCSAccess().getSemicolonKeyword_9_0()); }
)

    |(
{ before(grammarAccess.getQueryCSAccess().getGroup_9_1()); }
(rule__QueryCS__Group_9_1__0)
{ after(grammarAccess.getQueryCSAccess().getGroup_9_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnrestrictedName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); }
	ruleEssentialOCLUnrestrictedName
{ after(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); }

	'check'

{ after(grammarAccess.getUnrestrictedNameAccess().getCheckKeyword_1()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); }

	'enforce'

{ after(grammarAccess.getUnrestrictedNameAccess().getEnforceKeyword_2()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); }

	'import'

{ after(grammarAccess.getUnrestrictedNameAccess().getImportKeyword_3()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); }

	'imports'

{ after(grammarAccess.getUnrestrictedNameAccess().getImportsKeyword_4()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); }

	'library'

{ after(grammarAccess.getUnrestrictedNameAccess().getLibraryKeyword_5()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); }

	'map'

{ after(grammarAccess.getUnrestrictedNameAccess().getMapKeyword_6()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); }

	'query'

{ after(grammarAccess.getUnrestrictedNameAccess().getQueryKeyword_7()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); }

	'realize'

{ after(grammarAccess.getUnrestrictedNameAccess().getRealizeKeyword_8()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); }

	'refines'

{ after(grammarAccess.getUnrestrictedNameAccess().getRefinesKeyword_9()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); }

	'transformation'

{ after(grammarAccess.getUnrestrictedNameAccess().getTransformationKeyword_10()); }
)

    |(
{ before(grammarAccess.getUnrestrictedNameAccess().getUsesKeyword_11()); }

	'uses'

{ after(grammarAccess.getUnrestrictedNameAccess().getUsesKeyword_11()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_0_0()); }
(rule__AttributeCS__Group_0_0__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getGroup_0_1()); }
(rule__AttributeCS__Group_0_1__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_5_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_0()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_0)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_1()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_1)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_1()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_2()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_2)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_2()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_3()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_3)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_3()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_4()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_4)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_4()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_5()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_5)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_5()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_6()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_6)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_6()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_7()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_7)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_7()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_8()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_8)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_8()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_9()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_9)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_9()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_10()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_10)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_10()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_11()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_11)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_11()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_12()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_12)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_12()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_13()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_13)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_13()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_14()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_14)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_14()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_15()); }
(rule__AttributeCS__QualifiersAssignment_5_1_0_15)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_5_1_0_15()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_6_0()); }
(rule__AttributeCS__Group_6_0__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_6_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_1()); }

	';'

{ after(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Alternatives_6_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_0()); }
(rule__AttributeCS__Group_6_0_1_0__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_0()); }
)

    |(
{ before(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_1()); }
(rule__AttributeCS__Group_6_0_1_1__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_6_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ClassCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getClassCSAccess().getStructuredClassCSParserRuleCall_0()); }
	ruleStructuredClassCS
{ after(grammarAccess.getClassCSAccess().getStructuredClassCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getClassCSAccess().getDataTypeCSParserRuleCall_1()); }
	ruleDataTypeCS
{ after(grammarAccess.getClassCSAccess().getDataTypeCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getClassCSAccess().getEnumerationCSParserRuleCall_2()); }
	ruleEnumerationCS
{ after(grammarAccess.getClassCSAccess().getEnumerationCSParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Alternatives_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsSerializableAssignment_5_1_0()); }
(rule__DataTypeCS__IsSerializableAssignment_5_1_0)
{ after(grammarAccess.getDataTypeCSAccess().getIsSerializableAssignment_5_1_0()); }
)

    |(
{ before(grammarAccess.getDataTypeCSAccess().getSerializableKeyword_5_1_1()); }

	'!serializable'

{ after(grammarAccess.getDataTypeCSAccess().getSerializableKeyword_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Alternatives_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup_6_0()); }
(rule__DataTypeCS__Group_6_0__0)
{ after(grammarAccess.getDataTypeCSAccess().getGroup_6_0()); }
)

    |(
{ before(grammarAccess.getDataTypeCSAccess().getSemicolonKeyword_6_1()); }

	';'

{ after(grammarAccess.getDataTypeCSAccess().getSemicolonKeyword_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Alternatives_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getIsSerializableAssignment_4_1_0()); }
(rule__EnumerationCS__IsSerializableAssignment_4_1_0)
{ after(grammarAccess.getEnumerationCSAccess().getIsSerializableAssignment_4_1_0()); }
)

    |(
{ before(grammarAccess.getEnumerationCSAccess().getSerializableKeyword_4_1_1()); }

	'!serializable'

{ after(grammarAccess.getEnumerationCSAccess().getSerializableKeyword_4_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Alternatives_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup_5_0()); }
(rule__EnumerationCS__Group_5_0__0)
{ after(grammarAccess.getEnumerationCSAccess().getGroup_5_0()); }
)

    |(
{ before(grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_5_1()); }

	';'

{ after(grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup_0_0()); }
(rule__EnumerationLiteralCS__Group_0_0__0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_1()); }
(rule__EnumerationLiteralCS__NameAssignment_0_1)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup_2_0()); }
(rule__EnumerationLiteralCS__Group_2_0__0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup_2_0()); }
)

    |(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getSemicolonKeyword_2_1()); }

	';'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getSemicolonKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_0_0()); }
(rule__OperationCS__Group_0_0__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getGroup_0_1()); }
(rule__OperationCS__Group_0_1__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives_9_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_0()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_0)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_1()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_1)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_1()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_2()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_2)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_2()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_3()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_3)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_3()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_4()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_4)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_4()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_5()); }
(rule__OperationCS__QualifiersAssignment_9_1_0_5)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_9_1_0_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Alternatives_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_10_0()); }
(rule__OperationCS__Group_10_0__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_10_0()); }
)

    |(
{ before(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_1()); }

	';'

{ after(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Alternatives_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_0()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_0)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_0()); }
)

    |(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_1()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_1)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_1()); }
)

    |(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_2()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_2)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_2()); }
)

    |(
{ before(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_3()); }
(rule__ParameterCS__QualifiersAssignment_2_1_0_3)
{ after(grammarAccess.getParameterCSAccess().getQualifiersAssignment_2_1_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_0_0()); }
(rule__ReferenceCS__Group_0_0__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_0_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getGroup_0_1()); }
(rule__ReferenceCS__Group_0_1__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_6_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_0()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_0)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_1()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_1)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_1()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_2()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_2)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_2()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_3()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_3)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_3()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_4()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_4)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_4()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_5()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_5)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_5()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_6()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_6)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_6()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_7()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_7)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_7()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_8()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_8)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_8()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_9()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_9)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_9()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_10()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_10)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_10()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_11()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_11)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_11()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_12()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_12)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_12()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_13()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_13)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_13()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_14()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_14)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_14()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_15()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_15)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_15()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_16()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_16)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_16()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_17()); }
(rule__ReferenceCS__QualifiersAssignment_6_1_0_17)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_6_1_0_17()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0()); }
(rule__ReferenceCS__Group_7_0__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_1()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Alternatives_7_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_0()); }
(rule__ReferenceCS__Group_7_0_1_0__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_0()); }
)

    |(
{ before(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_1()); }
(rule__ReferenceCS__Group_7_0_1_1__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_7_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificationCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSpecificationCSAccess().getOwnedExpressionAssignment_0()); }
(rule__SpecificationCS__OwnedExpressionAssignment_0)
{ after(grammarAccess.getSpecificationCSAccess().getOwnedExpressionAssignment_0()); }
)

    |(
{ before(grammarAccess.getSpecificationCSAccess().getExprStringAssignment_1()); }
(rule__SpecificationCS__ExprStringAssignment_1)
{ after(grammarAccess.getSpecificationCSAccess().getExprStringAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Alternatives_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_7_0()); }
(rule__StructuredClassCS__Group_7_0__0)
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_7_0()); }
)

    |(
{ before(grammarAccess.getStructuredClassCSAccess().getSemicolonKeyword_7_1()); }

	';'

{ after(grammarAccess.getStructuredClassCSAccess().getSemicolonKeyword_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Alternatives_7_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsAssignment_7_0_1_0()); }
(rule__StructuredClassCS__OwnedOperationsAssignment_7_0_1_0)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsAssignment_7_0_1_0()); }
)

    |(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesAssignment_7_0_1_1()); }
(rule__StructuredClassCS__OwnedPropertiesAssignment_7_0_1_1)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesAssignment_7_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuralFeatureCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuralFeatureCSAccess().getAttributeCSParserRuleCall_0()); }
	ruleAttributeCS
{ after(grammarAccess.getStructuralFeatureCSAccess().getAttributeCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getStructuralFeatureCSAccess().getReferenceCSParserRuleCall_1()); }
	ruleReferenceCS
{ after(grammarAccess.getStructuralFeatureCSAccess().getReferenceCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EssentialOCLUnaryOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); }

	'-'

{ after(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); }

	'not'

{ after(grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLInfixOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); }

	'*'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); }

	'/'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); }

	'+'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); }

	'-'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); }

	'>'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); }

	'<'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); }

	'>='

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); }

	'<='

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); }

	'='

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); }

	'<>'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); }

	'and'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11()); }

	'or'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12()); }

	'xor'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12()); }
)

    |(
{ before(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_13()); }

	'implies'

{ after(grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_13()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLNavigationOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); }

	'.'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); }

	'->'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); }

	'?.'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); }
)

    |(
{ before(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); }

	'?->'

{ after(grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BinaryOperatorName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); }
	ruleInfixOperatorName
{ after(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); }
	ruleNavigationOperatorName
{ after(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EssentialOCLUnreservedName__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); }
	ruleUnrestrictedName
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); }
	ruleCollectionTypeIdentifier
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); }
	rulePrimitiveTypeIdentifier
{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); }

	'Map'

{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); }
)

    |(
{ before(grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); }

	'Tuple'

{ after(grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_0()); }
(rule__URIFirstPathElementCS__ReferredElementAssignment_0)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_0()); }
)

    |(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getGroup_1()); }
(rule__URIFirstPathElementCS__Group_1__0)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimitiveTypeIdentifier__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); }

	'Boolean'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); }

	'Integer'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); }

	'Real'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); }

	'String'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); }

	'UnlimitedNatural'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); }

	'OclAny'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); }

	'OclInvalid'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); }
)

    |(
{ before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); }

	'OclVoid'

{ after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeIdentifier__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); }

	'Set'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); }

	'Bag'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); }

	'Sequence'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); }

	'Collection'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); }
)

    |(
{ before(grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); }

	'OrderedSet'

{ after(grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0()); }
(rule__CollectionLiteralPartCS__Group_0__0)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_1()); }
(rule__CollectionLiteralPartCS__OwnedExpressionAssignment_1)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getGroup_0()); }
(rule__ShadowPartCS__Group_0__0)
{ after(grammarAccess.getShadowPartCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_1()); }
(rule__ShadowPartCS__OwnedInitExpressionAssignment_1)
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__OwnedInitExpressionAlternatives_0_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0()); }
	ruleExpCS
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_2_0_0()); }
)

    |(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1()); }
	rulePatternExpCS
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_0_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimitiveLiteralExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); }
	ruleNumberLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); }
	ruleStringLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); }
	ruleBooleanLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); }
	ruleUnlimitedNaturalLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); }
	ruleInvalidLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); }
	ruleNullLiteralExpCS
{ after(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteralExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_0()); }
(rule__BooleanLiteralExpCS__SymbolAssignment_0)
{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_0()); }
)

    |(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_1()); }
(rule__BooleanLiteralExpCS__SymbolAssignment_1)
{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); }
	rulePrimitiveTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); }
	ruleCollectionTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); }
	ruleMapTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); }
	ruleTupleTypeCS
{ after(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpCS__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); }
	ruleTypeNameExpCS
{ after(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); }
)

    |(
{ before(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); }
	ruleTypeLiteralCS
{ after(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); }
)

    |(
{ before(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2()); }
	ruleCollectionPatternCS
{ after(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getGroup_0()); }
(rule__ExpCS__Group_0__0)
{ after(grammarAccess.getExpCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); }
	rulePrefixedLetExpCS
{ after(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getGroup_0()); }
(rule__PrefixedLetExpCS__Group_0__0)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); }
	ruleLetExpCS
{ after(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getGroup_0()); }
(rule__PrefixedPrimaryExpCS__Group_0__0)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); }
	rulePrimaryExpCS
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimaryExpCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); }
	ruleNestedExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); }
	ruleIfExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); }
	ruleSelfExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); }
	rulePrimitiveLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); }
	ruleTupleLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); }
	ruleMapLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); }
	ruleCollectionLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); }
	ruleLambdaLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); }
	ruleTypeLiteralExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_8()); }
)

    |(
{ before(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); }
	ruleNameExpCS
{ after(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0()); }
(rule__NavigatingArgCS__Group_0__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_1()); }
(rule__NavigatingArgCS__Group_1__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Alternatives_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0()); }
(rule__NavigatingArgCS__Group_0_1_0__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0()); }
)

    |(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1()); }
(rule__NavigatingArgCS__Group_0_1_1__0)
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0()); }
(rule__NavigatingCommaArgCS__Group_2_0__0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0()); }
)

    |(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1()); }
(rule__NavigatingCommaArgCS__Group_2_1__0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedConditionAlternatives_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); }
	ruleExpCS
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); }
)

    |(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); }
	rulePatternExpCS
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); }
	ruleMultiplicityBoundsCS
{ after(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); }
)

    |(
{ before(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); }
	ruleMultiplicityStringCS
{ after(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Alternatives_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0()); }

	'|?'

{ after(grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0()); }
)

    |(
{ before(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1()); }
(rule__MultiplicityCS__IsNullFreeAssignment_2_1)
{ after(grammarAccess.getMultiplicityCSAccess().getIsNullFreeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityStringCS__StringBoundsAlternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); }

	'*'

{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); }

	'+'

{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1()); }
)

    |(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); }

	'?'

{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRefCS__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); }
	ruleTypedRefCS
{ after(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); }
	ruleWildcardTypeRefCS
{ after(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ID__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); }
	RULE_SIMPLE_ID
{ after(grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); }
	RULE_ESCAPED_ID
{ after(grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UPPER__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
{ after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); }

	'*'

{ after(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__TopLevelCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group__0__Impl
	rule__TopLevelCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedImportsAssignment_0()); }
(rule__TopLevelCS__OwnedImportsAssignment_0)*
{ after(grammarAccess.getTopLevelCSAccess().getOwnedImportsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TopLevelCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TopLevelCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getAlternatives_1()); }
(rule__TopLevelCS__Alternatives_1)*
{ after(grammarAccess.getTopLevelCSAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BottomPatternCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0__0__Impl
	rule__BottomPatternCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0()); }

	'{'

{ after(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0__1__Impl
	rule__BottomPatternCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getAlternatives_0_1()); }
(rule__BottomPatternCS__Alternatives_0_1)
{ after(grammarAccess.getBottomPatternCSAccess().getAlternatives_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0__2__Impl
	rule__BottomPatternCS__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getGroup_0_2()); }
(rule__BottomPatternCS__Group_0_2__0)*
{ after(grammarAccess.getBottomPatternCSAccess().getGroup_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0__3__Impl
	rule__BottomPatternCS__Group_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3()); }

	'|'

{ after(grammarAccess.getBottomPatternCSAccess().getVerticalLineKeyword_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_0__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0__4__Impl
	rule__BottomPatternCS__Group_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsAssignment_0_4()); }
(rule__BottomPatternCS__OwnedConstraintsAssignment_0_4)*
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsAssignment_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_0__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5()); }

	'}'

{ after(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_0_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__BottomPatternCS__Group_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0_2__0__Impl
	rule__BottomPatternCS__Group_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getCommaKeyword_0_2_0()); }

	','

{ after(grammarAccess.getBottomPatternCSAccess().getCommaKeyword_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_0_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getAlternatives_0_2_1()); }
(rule__BottomPatternCS__Alternatives_0_2_1)
{ after(grammarAccess.getBottomPatternCSAccess().getAlternatives_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BottomPatternCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_1__0__Impl
	rule__BottomPatternCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_0()); }

	'{'

{ after(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_1__1__Impl
	rule__BottomPatternCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getAlternatives_1_1()); }
(rule__BottomPatternCS__Alternatives_1_1)
{ after(grammarAccess.getBottomPatternCSAccess().getAlternatives_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_1__2__Impl
	rule__BottomPatternCS__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getGroup_1_2()); }
(rule__BottomPatternCS__Group_1_2__0)*
{ after(grammarAccess.getBottomPatternCSAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_1_3()); }

	'}'

{ after(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__BottomPatternCS__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_1_2__0__Impl
	rule__BottomPatternCS__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getCommaKeyword_1_2_0()); }

	','

{ after(grammarAccess.getBottomPatternCSAccess().getCommaKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getAlternatives_1_2_1()); }
(rule__BottomPatternCS__Alternatives_1_2_1)
{ after(grammarAccess.getBottomPatternCSAccess().getAlternatives_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__BottomPatternCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_2__0__Impl
	rule__BottomPatternCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_2_0()); }

	'{'

{ after(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_2__1__Impl
	rule__BottomPatternCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsAssignment_2_1()); }
(rule__BottomPatternCS__OwnedConstraintsAssignment_2_1)
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsAssignment_2_1()); }
)
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsAssignment_2_1()); }
(rule__BottomPatternCS__OwnedConstraintsAssignment_2_1)*
{ after(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsAssignment_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_2_2()); }

	'}'

{ after(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__BottomPatternCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_3__0__Impl
	rule__BottomPatternCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getBottomPatternCSAction_3_0()); }
(

)
{ after(grammarAccess.getBottomPatternCSAccess().getBottomPatternCSAction_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_3__1__Impl
	rule__BottomPatternCS__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_3_1()); }

	'{'

{ after(grammarAccess.getBottomPatternCSAccess().getLeftCurlyBracketKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__BottomPatternCS__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__BottomPatternCS__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_3_2()); }

	'}'

{ after(grammarAccess.getBottomPatternCSAccess().getRightCurlyBracketKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DirectionCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group__0__Impl
	rule__DirectionCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getDirectionCSAction_0()); }
(

)
{ after(grammarAccess.getDirectionCSAccess().getDirectionCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group__1__Impl
	rule__DirectionCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getNameAssignment_1()); }
(rule__DirectionCS__NameAssignment_1)?
{ after(grammarAccess.getDirectionCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group__2__Impl
	rule__DirectionCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getImportsKeyword_2()); }

	'imports'

{ after(grammarAccess.getDirectionCSAccess().getImportsKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group__3__Impl
	rule__DirectionCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getImportsAssignment_3()); }
(rule__DirectionCS__ImportsAssignment_3)
{ after(grammarAccess.getDirectionCSAccess().getImportsAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group__4__Impl
	rule__DirectionCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getGroup_4()); }
(rule__DirectionCS__Group_4__0)*
{ after(grammarAccess.getDirectionCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getGroup_5()); }
(rule__DirectionCS__Group_5__0)?
{ after(grammarAccess.getDirectionCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__DirectionCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group_4__0__Impl
	rule__DirectionCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getCommaKeyword_4_0()); }

	','

{ after(grammarAccess.getDirectionCSAccess().getCommaKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getImportsAssignment_4_1()); }
(rule__DirectionCS__ImportsAssignment_4_1)
{ after(grammarAccess.getDirectionCSAccess().getImportsAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DirectionCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group_5__0__Impl
	rule__DirectionCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getUsesKeyword_5_0()); }

	'uses'

{ after(grammarAccess.getDirectionCSAccess().getUsesKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group_5__1__Impl
	rule__DirectionCS__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getUsesAssignment_5_1()); }
(rule__DirectionCS__UsesAssignment_5_1)
{ after(grammarAccess.getDirectionCSAccess().getUsesAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getGroup_5_2()); }
(rule__DirectionCS__Group_5_2__0)*
{ after(grammarAccess.getDirectionCSAccess().getGroup_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DirectionCS__Group_5_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group_5_2__0__Impl
	rule__DirectionCS__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group_5_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getCommaKeyword_5_2_0()); }

	','

{ after(grammarAccess.getDirectionCSAccess().getCommaKeyword_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DirectionCS__Group_5_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DirectionCS__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__Group_5_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getUsesAssignment_5_2_1()); }
(rule__DirectionCS__UsesAssignment_5_2_1)
{ after(grammarAccess.getDirectionCSAccess().getUsesAssignment_5_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GuardPatternCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0__0__Impl
	rule__GuardPatternCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_0()); }

	'('

{ after(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0__1__Impl
	rule__GuardPatternCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_1()); }
(rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_0_1)
{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0__2__Impl
	rule__GuardPatternCS__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getGroup_0_2()); }
(rule__GuardPatternCS__Group_0_2__0)*
{ after(grammarAccess.getGuardPatternCSAccess().getGroup_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0__3__Impl
	rule__GuardPatternCS__Group_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3()); }

	'|'

{ after(grammarAccess.getGuardPatternCSAccess().getVerticalLineKeyword_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_0__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0__4__Impl
	rule__GuardPatternCS__Group_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesAssignment_0_4()); }
(rule__GuardPatternCS__OwnedPredicatesAssignment_0_4)*
{ after(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesAssignment_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_0__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_5()); }

	')'

{ after(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_0_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__GuardPatternCS__Group_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0_2__0__Impl
	rule__GuardPatternCS__Group_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getCommaKeyword_0_2_0()); }

	','

{ after(grammarAccess.getGuardPatternCSAccess().getCommaKeyword_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_0_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_2_1()); }
(rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_0_2_1)
{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GuardPatternCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_1__0__Impl
	rule__GuardPatternCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_1__1__Impl
	rule__GuardPatternCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_1()); }
(rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_1_1)
{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_1__2__Impl
	rule__GuardPatternCS__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getGroup_1_2()); }
(rule__GuardPatternCS__Group_1_2__0)*
{ after(grammarAccess.getGuardPatternCSAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_1_3()); }

	')'

{ after(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__GuardPatternCS__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_1_2__0__Impl
	rule__GuardPatternCS__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getCommaKeyword_1_2_0()); }

	','

{ after(grammarAccess.getGuardPatternCSAccess().getCommaKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_2_1()); }
(rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_1_2_1)
{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__GuardPatternCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_2__0__Impl
	rule__GuardPatternCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_2_0()); }

	'('

{ after(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_2__1__Impl
	rule__GuardPatternCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesAssignment_2_1()); }
(rule__GuardPatternCS__OwnedPredicatesAssignment_2_1)
{ after(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesAssignment_2_1()); }
)
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesAssignment_2_1()); }
(rule__GuardPatternCS__OwnedPredicatesAssignment_2_1)*
{ after(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesAssignment_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_2_2()); }

	')'

{ after(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GuardPatternCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_3__0__Impl
	rule__GuardPatternCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getGuardPatternCSAction_3_0()); }
(

)
{ after(grammarAccess.getGuardPatternCSAccess().getGuardPatternCSAction_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_3__1__Impl
	rule__GuardPatternCS__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_3_1()); }

	'('

{ after(grammarAccess.getGuardPatternCSAccess().getLeftParenthesisKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardPatternCS__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardPatternCS__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_3_2()); }

	')'

{ after(grammarAccess.getGuardPatternCSAccess().getRightParenthesisKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__GuardVariableCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardVariableCS__Group__0__Impl
	rule__GuardVariableCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardVariableCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardVariableCSAccess().getNameAssignment_0()); }
(rule__GuardVariableCS__NameAssignment_0)
{ after(grammarAccess.getGuardVariableCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardVariableCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardVariableCS__Group__1__Impl
	rule__GuardVariableCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardVariableCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardVariableCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getGuardVariableCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__GuardVariableCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__GuardVariableCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GuardVariableCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardVariableCSAccess().getOwnedTypeAssignment_2()); }
(rule__GuardVariableCS__OwnedTypeAssignment_2)
{ after(grammarAccess.getGuardVariableCSAccess().getOwnedTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ImportCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__0__Impl
	rule__ImportCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getImportKeyword_0()); }

	'import'

{ after(grammarAccess.getImportCSAccess().getImportKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__1__Impl
	rule__ImportCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getGroup_1()); }
(rule__ImportCS__Group_1__0)?
{ after(grammarAccess.getImportCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__2__Impl
	rule__ImportCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getOwnedPathNameAssignment_2()); }
(rule__ImportCS__OwnedPathNameAssignment_2)
{ after(grammarAccess.getImportCSAccess().getOwnedPathNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__3__Impl
	rule__ImportCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getGroup_3()); }
(rule__ImportCS__Group_3__0)?
{ after(grammarAccess.getImportCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getSemicolonKeyword_4()); }

	';'

{ after(grammarAccess.getImportCSAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ImportCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group_1__0__Impl
	rule__ImportCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getNameAssignment_1_0()); }
(rule__ImportCS__NameAssignment_1_0)
{ after(grammarAccess.getImportCSAccess().getNameAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getColonKeyword_1_1()); }

	':'

{ after(grammarAccess.getImportCSAccess().getColonKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ImportCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group_3__0__Impl
	rule__ImportCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getIsAllAssignment_3_0()); }
(rule__ImportCS__IsAllAssignment_3_0)
{ after(grammarAccess.getImportCSAccess().getIsAllAssignment_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ImportCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ImportCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1()); }

	'*'

{ after(grammarAccess.getImportCSAccess().getAsteriskKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MappingCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__0__Impl
	rule__MappingCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getMappingCSAction_0()); }
(

)
{ after(grammarAccess.getMappingCSAccess().getMappingCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__1__Impl
	rule__MappingCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getIsDefaultAssignment_1()); }
(rule__MappingCS__IsDefaultAssignment_1)?
{ after(grammarAccess.getMappingCSAccess().getIsDefaultAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__2__Impl
	rule__MappingCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getMapKeyword_2()); }

	'map'

{ after(grammarAccess.getMappingCSAccess().getMapKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__3__Impl
	rule__MappingCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getNameAssignment_3()); }
(rule__MappingCS__NameAssignment_3)?
{ after(grammarAccess.getMappingCSAccess().getNameAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__4__Impl
	rule__MappingCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getGroup_4()); }
(rule__MappingCS__Group_4__0)?
{ after(grammarAccess.getMappingCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__5__Impl
	rule__MappingCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getGroup_5()); }
(rule__MappingCS__Group_5__0)?
{ after(grammarAccess.getMappingCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__6__Impl
	rule__MappingCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_6()); }

	'{'

{ after(grammarAccess.getMappingCSAccess().getLeftCurlyBracketKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__7__Impl
	rule__MappingCS__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedDomainsAssignment_7()); }
(rule__MappingCS__OwnedDomainsAssignment_7)*
{ after(grammarAccess.getMappingCSAccess().getOwnedDomainsAssignment_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__8__Impl
	rule__MappingCS__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getGroup_8()); }
(rule__MappingCS__Group_8__0)?
{ after(grammarAccess.getMappingCSAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__9__Impl
	rule__MappingCS__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedComposedMappingsAssignment_9()); }
(rule__MappingCS__OwnedComposedMappingsAssignment_9)*
{ after(grammarAccess.getMappingCSAccess().getOwnedComposedMappingsAssignment_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_10()); }

	'}'

{ after(grammarAccess.getMappingCSAccess().getRightCurlyBracketKeyword_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__MappingCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_4__0__Impl
	rule__MappingCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getInKeyword_4_0()); }

	'in'

{ after(grammarAccess.getMappingCSAccess().getInKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedInPathNameAssignment_4_1()); }
(rule__MappingCS__OwnedInPathNameAssignment_4_1)
{ after(grammarAccess.getMappingCSAccess().getOwnedInPathNameAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MappingCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_5__0__Impl
	rule__MappingCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getRefinesKeyword_5_0()); }

	'refines'

{ after(grammarAccess.getMappingCSAccess().getRefinesKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_5__1__Impl
	rule__MappingCS__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getRefinesAssignment_5_1()); }
(rule__MappingCS__RefinesAssignment_5_1)
{ after(grammarAccess.getMappingCSAccess().getRefinesAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getGroup_5_2()); }
(rule__MappingCS__Group_5_2__0)*
{ after(grammarAccess.getMappingCSAccess().getGroup_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__MappingCS__Group_5_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_5_2__0__Impl
	rule__MappingCS__Group_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_5_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getCommaKeyword_5_2_0()); }

	','

{ after(grammarAccess.getMappingCSAccess().getCommaKeyword_5_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group_5_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_5_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getRefinesAssignment_5_2_1()); }
(rule__MappingCS__RefinesAssignment_5_2_1)
{ after(grammarAccess.getMappingCSAccess().getRefinesAssignment_5_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MappingCS__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_8__0__Impl
	rule__MappingCS__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getWhereKeyword_8_0()); }

	'where'

{ after(grammarAccess.getMappingCSAccess().getWhereKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MappingCS__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MappingCS__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedMiddleAssignment_8_1()); }
(rule__MappingCS__OwnedMiddleAssignment_8_1)
{ after(grammarAccess.getMappingCSAccess().getOwnedMiddleAssignment_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NamedDomainCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamedDomainCS__Group__0__Impl
	rule__NamedDomainCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getIsCheckAssignment_0()); }
(rule__NamedDomainCS__IsCheckAssignment_0)?
{ after(grammarAccess.getNamedDomainCSAccess().getIsCheckAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamedDomainCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamedDomainCS__Group__1__Impl
	rule__NamedDomainCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getIsEnforceAssignment_1()); }
(rule__NamedDomainCS__IsEnforceAssignment_1)?
{ after(grammarAccess.getNamedDomainCSAccess().getIsEnforceAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamedDomainCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamedDomainCS__Group__2__Impl
	rule__NamedDomainCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getDirectionAssignment_2()); }
(rule__NamedDomainCS__DirectionAssignment_2)
{ after(grammarAccess.getNamedDomainCSAccess().getDirectionAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamedDomainCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamedDomainCS__Group__3__Impl
	rule__NamedDomainCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getOwnedGuardPatternAssignment_3()); }
(rule__NamedDomainCS__OwnedGuardPatternAssignment_3)
{ after(grammarAccess.getNamedDomainCSAccess().getOwnedGuardPatternAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NamedDomainCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NamedDomainCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getOwnedBottomPatternAssignment_4()); }
(rule__NamedDomainCS__OwnedBottomPatternAssignment_4)
{ after(grammarAccess.getNamedDomainCSAccess().getOwnedBottomPatternAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__QualifiedPackageCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group__0__Impl
	rule__QualifiedPackageCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getPackageKeyword_0()); }

	'package'

{ after(grammarAccess.getQualifiedPackageCSAccess().getPackageKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group__1__Impl
	rule__QualifiedPackageCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedPathNameAssignment_1()); }
(rule__QualifiedPackageCS__OwnedPathNameAssignment_1)?
{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedPathNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group__2__Impl
	rule__QualifiedPackageCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getNameAssignment_2()); }
(rule__QualifiedPackageCS__NameAssignment_2)
{ after(grammarAccess.getQualifiedPackageCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group__3__Impl
	rule__QualifiedPackageCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getGroup_3()); }
(rule__QualifiedPackageCS__Group_3__0)?
{ after(grammarAccess.getQualifiedPackageCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group__4__Impl
	rule__QualifiedPackageCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getGroup_4()); }
(rule__QualifiedPackageCS__Group_4__0)?
{ after(grammarAccess.getQualifiedPackageCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getAlternatives_5()); }
(rule__QualifiedPackageCS__Alternatives_5)
{ after(grammarAccess.getQualifiedPackageCSAccess().getAlternatives_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__QualifiedPackageCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group_3__0__Impl
	rule__QualifiedPackageCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getColonKeyword_3_0()); }

	':'

{ after(grammarAccess.getQualifiedPackageCSAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getNsPrefixAssignment_3_1()); }
(rule__QualifiedPackageCS__NsPrefixAssignment_3_1)
{ after(grammarAccess.getQualifiedPackageCSAccess().getNsPrefixAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedPackageCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group_4__0__Impl
	rule__QualifiedPackageCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getEqualsSignKeyword_4_0()); }

	'='

{ after(grammarAccess.getQualifiedPackageCSAccess().getEqualsSignKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getNsURIAssignment_4_1()); }
(rule__QualifiedPackageCS__NsURIAssignment_4_1)
{ after(grammarAccess.getQualifiedPackageCSAccess().getNsURIAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedPackageCS__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group_5_0__0__Impl
	rule__QualifiedPackageCS__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getLeftCurlyBracketKeyword_5_0_0()); }

	'{'

{ after(grammarAccess.getQualifiedPackageCSAccess().getLeftCurlyBracketKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group_5_0__1__Impl
	rule__QualifiedPackageCS__Group_5_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getAlternatives_5_0_1()); }
(rule__QualifiedPackageCS__Alternatives_5_0_1)*
{ after(grammarAccess.getQualifiedPackageCSAccess().getAlternatives_5_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedPackageCS__Group_5_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedPackageCS__Group_5_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__Group_5_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getRightCurlyBracketKeyword_5_0_2()); }

	'}'

{ after(grammarAccess.getQualifiedPackageCSAccess().getRightCurlyBracketKeyword_5_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ParamDeclarationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParamDeclarationCS__Group__0__Impl
	rule__ParamDeclarationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParamDeclarationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParamDeclarationCSAccess().getNameAssignment_0()); }
(rule__ParamDeclarationCS__NameAssignment_0)
{ after(grammarAccess.getParamDeclarationCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParamDeclarationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParamDeclarationCS__Group__1__Impl
	rule__ParamDeclarationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParamDeclarationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getParamDeclarationCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParamDeclarationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParamDeclarationCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParamDeclarationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeAssignment_2()); }
(rule__ParamDeclarationCS__OwnedTypeAssignment_2)
{ after(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PredicateCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateCS__Group__0__Impl
	rule__PredicateCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateCSAccess().getOwnedConditionAssignment_0()); }
(rule__PredicateCS__OwnedConditionAssignment_0)
{ after(grammarAccess.getPredicateCSAccess().getOwnedConditionAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PredicateCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateCSAccess().getSemicolonKeyword_1()); }

	';'

{ after(grammarAccess.getPredicateCSAccess().getSemicolonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PredicateOrAssignmentCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateOrAssignmentCS__Group__0__Impl
	rule__PredicateOrAssignmentCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultAssignment_0()); }
(rule__PredicateOrAssignmentCS__IsDefaultAssignment_0)?
{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PredicateOrAssignmentCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateOrAssignmentCS__Group__1__Impl
	rule__PredicateOrAssignmentCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedTargetAssignment_1()); }
(rule__PredicateOrAssignmentCS__OwnedTargetAssignment_1)
{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedTargetAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PredicateOrAssignmentCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateOrAssignmentCS__Group__2__Impl
	rule__PredicateOrAssignmentCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getGroup_2()); }
(rule__PredicateOrAssignmentCS__Group_2__0)?
{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PredicateOrAssignmentCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateOrAssignmentCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getSemicolonKeyword_3()); }

	';'

{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getSemicolonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__PredicateOrAssignmentCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateOrAssignmentCS__Group_2__0__Impl
	rule__PredicateOrAssignmentCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getAlternatives_2_0()); }
(rule__PredicateOrAssignmentCS__Alternatives_2_0)
{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getAlternatives_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PredicateOrAssignmentCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PredicateOrAssignmentCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedInitExpressionAssignment_2_1()); }
(rule__PredicateOrAssignmentCS__OwnedInitExpressionAssignment_2_1)
{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedInitExpressionAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QueryCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__0__Impl
	rule__QueryCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getIsTransientAssignment_0()); }
(rule__QueryCS__IsTransientAssignment_0)?
{ after(grammarAccess.getQueryCSAccess().getIsTransientAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__1__Impl
	rule__QueryCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getQueryKeyword_1()); }

	'query'

{ after(grammarAccess.getQueryCSAccess().getQueryKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__2__Impl
	rule__QueryCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedPathNameAssignment_2()); }
(rule__QueryCS__OwnedPathNameAssignment_2)
{ after(grammarAccess.getQueryCSAccess().getOwnedPathNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__3__Impl
	rule__QueryCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getNameAssignment_3()); }
(rule__QueryCS__NameAssignment_3)
{ after(grammarAccess.getQueryCSAccess().getNameAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__4__Impl
	rule__QueryCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_4()); }

	'('

{ after(grammarAccess.getQueryCSAccess().getLeftParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__5__Impl
	rule__QueryCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getGroup_5()); }
(rule__QueryCS__Group_5__0)?
{ after(grammarAccess.getQueryCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__6__Impl
	rule__QueryCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_6()); }

	')'

{ after(grammarAccess.getQueryCSAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__7__Impl
	rule__QueryCS__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getColonKeyword_7()); }

	':'

{ after(grammarAccess.getQueryCSAccess().getColonKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__8__Impl
	rule__QueryCS__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedTypeAssignment_8()); }
(rule__QueryCS__OwnedTypeAssignment_8)
{ after(grammarAccess.getQueryCSAccess().getOwnedTypeAssignment_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getAlternatives_9()); }
(rule__QueryCS__Alternatives_9)
{ after(grammarAccess.getQueryCSAccess().getAlternatives_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}






















rule__QueryCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group_5__0__Impl
	rule__QueryCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedParametersAssignment_5_0()); }
(rule__QueryCS__OwnedParametersAssignment_5_0)
{ after(grammarAccess.getQueryCSAccess().getOwnedParametersAssignment_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getGroup_5_1()); }
(rule__QueryCS__Group_5_1__0)*
{ after(grammarAccess.getQueryCSAccess().getGroup_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QueryCS__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group_5_1__0__Impl
	rule__QueryCS__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getCommaKeyword_5_1_0()); }

	','

{ after(grammarAccess.getQueryCSAccess().getCommaKeyword_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedParametersAssignment_5_1_1()); }
(rule__QueryCS__OwnedParametersAssignment_5_1_1)
{ after(grammarAccess.getQueryCSAccess().getOwnedParametersAssignment_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QueryCS__Group_9_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group_9_1__0__Impl
	rule__QueryCS__Group_9_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group_9_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_9_1_0()); }

	'{'

{ after(grammarAccess.getQueryCSAccess().getLeftCurlyBracketKeyword_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group_9_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group_9_1__1__Impl
	rule__QueryCS__Group_9_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group_9_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedExpressionAssignment_9_1_1()); }
(rule__QueryCS__OwnedExpressionAssignment_9_1_1)
{ after(grammarAccess.getQueryCSAccess().getOwnedExpressionAssignment_9_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QueryCS__Group_9_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QueryCS__Group_9_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__Group_9_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getRightCurlyBracketKeyword_9_1_2()); }

	'}'

{ after(grammarAccess.getQueryCSAccess().getRightCurlyBracketKeyword_9_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ScopeNameCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ScopeNameCS__Group__0__Impl
	rule__ScopeNameCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScopeNameCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsAssignment_0()); }
(rule__ScopeNameCS__OwnedPathElementsAssignment_0)
{ after(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ScopeNameCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ScopeNameCS__Group__1__Impl
	rule__ScopeNameCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ScopeNameCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1()); }

	'::'

{ after(grammarAccess.getScopeNameCSAccess().getColonColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ScopeNameCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ScopeNameCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScopeNameCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getScopeNameCSAccess().getGroup_2()); }
(rule__ScopeNameCS__Group_2__0)*
{ after(grammarAccess.getScopeNameCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ScopeNameCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ScopeNameCS__Group_2__0__Impl
	rule__ScopeNameCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ScopeNameCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsAssignment_2_0()); }
(rule__ScopeNameCS__OwnedPathElementsAssignment_2_0)
{ after(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ScopeNameCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ScopeNameCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ScopeNameCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1()); }

	'::'

{ after(grammarAccess.getScopeNameCSAccess().getColonColonKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TransformationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group__0__Impl
	rule__TransformationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getTransformationKeyword_0()); }

	'transformation'

{ after(grammarAccess.getTransformationCSAccess().getTransformationKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransformationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group__1__Impl
	rule__TransformationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getOwnedPathNameAssignment_1()); }
(rule__TransformationCS__OwnedPathNameAssignment_1)?
{ after(grammarAccess.getTransformationCSAccess().getOwnedPathNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransformationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group__2__Impl
	rule__TransformationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getNameAssignment_2()); }
(rule__TransformationCS__NameAssignment_2)
{ after(grammarAccess.getTransformationCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransformationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group__3__Impl
	rule__TransformationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3()); }

	'{'

{ after(grammarAccess.getTransformationCSAccess().getLeftCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransformationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group__4__Impl
	rule__TransformationCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getGroup_4()); }
(rule__TransformationCS__Group_4__0)*
{ after(grammarAccess.getTransformationCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransformationCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getRightCurlyBracketKeyword_5()); }

	'}'

{ after(grammarAccess.getTransformationCSAccess().getRightCurlyBracketKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__TransformationCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group_4__0__Impl
	rule__TransformationCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getOwnedDirectionsAssignment_4_0()); }
(rule__TransformationCS__OwnedDirectionsAssignment_4_0)
{ after(grammarAccess.getTransformationCSAccess().getOwnedDirectionsAssignment_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TransformationCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TransformationCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1()); }

	';'

{ after(grammarAccess.getTransformationCSAccess().getSemicolonKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UnrealizedVariableCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnrealizedVariableCS__Group__0__Impl
	rule__UnrealizedVariableCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getNameAssignment_0()); }
(rule__UnrealizedVariableCS__NameAssignment_0)
{ after(grammarAccess.getUnrealizedVariableCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnrealizedVariableCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnrealizedVariableCS__Group__1__Impl
	rule__UnrealizedVariableCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getGroup_1()); }
(rule__UnrealizedVariableCS__Group_1__0)?
{ after(grammarAccess.getUnrealizedVariableCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnrealizedVariableCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnrealizedVariableCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getGroup_2()); }
(rule__UnrealizedVariableCS__Group_2__0)?
{ after(grammarAccess.getUnrealizedVariableCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__UnrealizedVariableCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnrealizedVariableCS__Group_1__0__Impl
	rule__UnrealizedVariableCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getUnrealizedVariableCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnrealizedVariableCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnrealizedVariableCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__UnrealizedVariableCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UnrealizedVariableCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnrealizedVariableCS__Group_2__0__Impl
	rule__UnrealizedVariableCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getColonEqualsSignKeyword_2_0()); }

	':='

{ after(grammarAccess.getUnrealizedVariableCSAccess().getColonEqualsSignKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnrealizedVariableCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnrealizedVariableCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getOwnedInitExpressionAssignment_2_1()); }
(rule__UnrealizedVariableCS__OwnedInitExpressionAssignment_2_1)
{ after(grammarAccess.getUnrealizedVariableCSAccess().getOwnedInitExpressionAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RealizedVariableCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RealizedVariableCS__Group__0__Impl
	rule__RealizedVariableCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RealizedVariableCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0()); }

	'realize'

{ after(grammarAccess.getRealizedVariableCSAccess().getRealizeKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RealizedVariableCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RealizedVariableCS__Group__1__Impl
	rule__RealizedVariableCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RealizedVariableCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealizedVariableCSAccess().getNameAssignment_1()); }
(rule__RealizedVariableCS__NameAssignment_1)
{ after(grammarAccess.getRealizedVariableCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RealizedVariableCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RealizedVariableCS__Group__2__Impl
	rule__RealizedVariableCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RealizedVariableCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2()); }

	':'

{ after(grammarAccess.getRealizedVariableCSAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RealizedVariableCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RealizedVariableCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RealizedVariableCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeAssignment_3()); }
(rule__RealizedVariableCS__OwnedTypeAssignment_3)
{ after(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__UnnamedDomainCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnnamedDomainCS__Group__0__Impl
	rule__UnnamedDomainCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnnamedDomainCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnnamedDomainCSAccess().getDomainCSAction_0()); }
(

)
{ after(grammarAccess.getUnnamedDomainCSAccess().getDomainCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnnamedDomainCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnnamedDomainCS__Group__1__Impl
	rule__UnnamedDomainCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__UnnamedDomainCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnnamedDomainCSAccess().getOwnedGuardPatternAssignment_1()); }
(rule__UnnamedDomainCS__OwnedGuardPatternAssignment_1)
{ after(grammarAccess.getUnnamedDomainCSAccess().getOwnedGuardPatternAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnnamedDomainCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnnamedDomainCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnnamedDomainCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnnamedDomainCSAccess().getOwnedBottomPatternAssignment_2()); }
(rule__UnnamedDomainCS__OwnedBottomPatternAssignment_2)
{ after(grammarAccess.getUnnamedDomainCSAccess().getOwnedBottomPatternAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AttributeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__0__Impl
	rule__AttributeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_0()); }
(rule__AttributeCS__Alternatives_0)?
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__1__Impl
	rule__AttributeCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAttributeKeyword_1()); }

	'attribute'

{ after(grammarAccess.getAttributeCSAccess().getAttributeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__2__Impl
	rule__AttributeCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getNameAssignment_2()); }
(rule__AttributeCS__NameAssignment_2)
{ after(grammarAccess.getAttributeCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__3__Impl
	rule__AttributeCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_3()); }
(rule__AttributeCS__Group_3__0)?
{ after(grammarAccess.getAttributeCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__4__Impl
	rule__AttributeCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_4()); }
(rule__AttributeCS__Group_4__0)?
{ after(grammarAccess.getAttributeCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__5__Impl
	rule__AttributeCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_5()); }
(rule__AttributeCS__Group_5__0)?
{ after(grammarAccess.getAttributeCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_6()); }
(rule__AttributeCS__Alternatives_6)
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__AttributeCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_0__0__Impl
	rule__AttributeCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_0()); }
(rule__AttributeCS__QualifiersAssignment_0_0_0)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_1()); }
(rule__AttributeCS__QualifiersAssignment_0_0_1)?
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_1__0__Impl
	rule__AttributeCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_0()); }
(rule__AttributeCS__QualifiersAssignment_0_1_0)
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_1()); }
(rule__AttributeCS__QualifiersAssignment_0_1_1)?
{ after(grammarAccess.getAttributeCSAccess().getQualifiersAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_3__0__Impl
	rule__AttributeCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getColonKeyword_3_0()); }

	':'

{ after(grammarAccess.getAttributeCSAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedTypeAssignment_3_1()); }
(rule__AttributeCS__OwnedTypeAssignment_3_1)
{ after(grammarAccess.getAttributeCSAccess().getOwnedTypeAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_4__0__Impl
	rule__AttributeCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getEqualsSignKeyword_4_0()); }

	'='

{ after(grammarAccess.getAttributeCSAccess().getEqualsSignKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getDefaultAssignment_4_1()); }
(rule__AttributeCS__DefaultAssignment_4_1)
{ after(grammarAccess.getAttributeCSAccess().getDefaultAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5__0__Impl
	rule__AttributeCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_5_0()); }

	'{'

{ after(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5__1__Impl
	rule__AttributeCS__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
(rule__AttributeCS__Group_5_1__0)
{ after(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
)
(
{ before(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
(rule__AttributeCS__Group_5_1__0)*
{ after(grammarAccess.getAttributeCSAccess().getGroup_5_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_5_2()); }

	'}'

{ after(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AttributeCS__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5_1__0__Impl
	rule__AttributeCS__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_5_1_0()); }
(rule__AttributeCS__Alternatives_5_1_0)
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getCommaKeyword_5_1_1()); }
(
	','
)?
{ after(grammarAccess.getAttributeCSAccess().getCommaKeyword_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__AttributeCS__Group_6_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0__0__Impl
	rule__AttributeCS__Group_6_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }

	'{'

{ after(grammarAccess.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0__1__Impl
	rule__AttributeCS__Group_6_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getAlternatives_6_0_1()); }
(rule__AttributeCS__Alternatives_6_0_1)*
{ after(grammarAccess.getAttributeCSAccess().getAlternatives_6_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2()); }

	'}'

{ after(grammarAccess.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__AttributeCS__Group_6_0_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_0__0__Impl
	rule__AttributeCS__Group_6_0_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getInitialKeyword_6_0_1_0_0()); }

	'initial'

{ after(grammarAccess.getAttributeCSAccess().getInitialKeyword_6_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_0__1__Impl
	rule__AttributeCS__Group_6_0_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_0_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_0__2__Impl
	rule__AttributeCS__Group_6_0_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_0_2()); }

	':'

{ after(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_0__3__Impl
	rule__AttributeCS__Group_6_0_1_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_0_3()); }
(rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_0_3)?
{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_0__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_0__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_0__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_0_4()); }

	';'

{ after(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__AttributeCS__Group_6_0_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__0__Impl
	rule__AttributeCS__Group_6_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getDerivationKeyword_6_0_1_1_0()); }

	'derivation'

{ after(grammarAccess.getAttributeCSAccess().getDerivationKeyword_6_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__1__Impl
	rule__AttributeCS__Group_6_0_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_1_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getAttributeCSAccess().getUnrestrictedNameParserRuleCall_6_0_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__2__Impl
	rule__AttributeCS__Group_6_0_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_1_2()); }

	':'

{ after(grammarAccess.getAttributeCSAccess().getColonKeyword_6_0_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__3__Impl
	rule__AttributeCS__Group_6_0_1_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_1_3()); }
(rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_1_3)?
{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsAssignment_6_0_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__AttributeCS__Group_6_0_1_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__AttributeCS__Group_6_0_1_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__Group_6_0_1_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_1_4()); }

	';'

{ after(grammarAccess.getAttributeCSAccess().getSemicolonKeyword_6_0_1_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__DataTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__0__Impl
	rule__DataTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsPrimitiveAssignment_0()); }
(rule__DataTypeCS__IsPrimitiveAssignment_0)?
{ after(grammarAccess.getDataTypeCSAccess().getIsPrimitiveAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__1__Impl
	rule__DataTypeCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getDatatypeKeyword_1()); }

	'datatype'

{ after(grammarAccess.getDataTypeCSAccess().getDatatypeKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__2__Impl
	rule__DataTypeCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getNameAssignment_2()); }
(rule__DataTypeCS__NameAssignment_2)
{ after(grammarAccess.getDataTypeCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__3__Impl
	rule__DataTypeCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedSignatureAssignment_3()); }
(rule__DataTypeCS__OwnedSignatureAssignment_3)?
{ after(grammarAccess.getDataTypeCSAccess().getOwnedSignatureAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__4__Impl
	rule__DataTypeCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup_4()); }
(rule__DataTypeCS__Group_4__0)?
{ after(grammarAccess.getDataTypeCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__5__Impl
	rule__DataTypeCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getGroup_5()); }
(rule__DataTypeCS__Group_5__0)?
{ after(grammarAccess.getDataTypeCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getAlternatives_6()); }
(rule__DataTypeCS__Alternatives_6)
{ after(grammarAccess.getDataTypeCSAccess().getAlternatives_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__DataTypeCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_4__0__Impl
	rule__DataTypeCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getColonKeyword_4_0()); }

	':'

{ after(grammarAccess.getDataTypeCSAccess().getColonKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getInstanceClassNameAssignment_4_1()); }
(rule__DataTypeCS__InstanceClassNameAssignment_4_1)
{ after(grammarAccess.getDataTypeCSAccess().getInstanceClassNameAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DataTypeCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_5__0__Impl
	rule__DataTypeCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_5_0()); }

	'{'

{ after(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_5__1__Impl
	rule__DataTypeCS__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getAlternatives_5_1()); }
(rule__DataTypeCS__Alternatives_5_1)?
{ after(grammarAccess.getDataTypeCSAccess().getAlternatives_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_5__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_5__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_5_2()); }

	'}'

{ after(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_5_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__DataTypeCS__Group_6_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_6_0__0__Impl
	rule__DataTypeCS__Group_6_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_6_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }

	'{'

{ after(grammarAccess.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DataTypeCS__Group_6_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DataTypeCS__Group_6_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__Group_6_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_1()); }

	'}'

{ after(grammarAccess.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__0__Impl
	rule__EnumerationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getEnumKeyword_0()); }

	'enum'

{ after(grammarAccess.getEnumerationCSAccess().getEnumKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__1__Impl
	rule__EnumerationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getNameAssignment_1()); }
(rule__EnumerationCS__NameAssignment_1)
{ after(grammarAccess.getEnumerationCSAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__2__Impl
	rule__EnumerationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedSignatureAssignment_2()); }
(rule__EnumerationCS__OwnedSignatureAssignment_2)?
{ after(grammarAccess.getEnumerationCSAccess().getOwnedSignatureAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__3__Impl
	rule__EnumerationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup_3()); }
(rule__EnumerationCS__Group_3__0)?
{ after(grammarAccess.getEnumerationCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__4__Impl
	rule__EnumerationCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getGroup_4()); }
(rule__EnumerationCS__Group_4__0)?
{ after(grammarAccess.getEnumerationCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getAlternatives_5()); }
(rule__EnumerationCS__Alternatives_5)
{ after(grammarAccess.getEnumerationCSAccess().getAlternatives_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}














rule__EnumerationCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_3__0__Impl
	rule__EnumerationCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getColonKeyword_3_0()); }

	':'

{ after(grammarAccess.getEnumerationCSAccess().getColonKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getInstanceClassNameAssignment_3_1()); }
(rule__EnumerationCS__InstanceClassNameAssignment_3_1)
{ after(grammarAccess.getEnumerationCSAccess().getInstanceClassNameAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_4__0__Impl
	rule__EnumerationCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_4_0()); }

	'{'

{ after(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_4__1__Impl
	rule__EnumerationCS__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getAlternatives_4_1()); }
(rule__EnumerationCS__Alternatives_4_1)?
{ after(grammarAccess.getEnumerationCSAccess().getAlternatives_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_4_2()); }

	'}'

{ after(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EnumerationCS__Group_5_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_5_0__0__Impl
	rule__EnumerationCS__Group_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_5_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_5_0_0()); }

	'{'

{ after(grammarAccess.getEnumerationCSAccess().getLeftCurlyBracketKeyword_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_5_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_5_0__1__Impl
	rule__EnumerationCS__Group_5_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_5_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsAssignment_5_0_1()); }
(rule__EnumerationCS__OwnedLiteralsAssignment_5_0_1)*
{ after(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsAssignment_5_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationCS__Group_5_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationCS__Group_5_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__Group_5_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_5_0_2()); }

	'}'

{ after(grammarAccess.getEnumerationCSAccess().getRightCurlyBracketKeyword_5_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EnumerationLiteralCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group__0__Impl
	rule__EnumerationLiteralCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_0()); }
(rule__EnumerationLiteralCS__Alternatives_0)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group__1__Impl
	rule__EnumerationLiteralCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getGroup_1()); }
(rule__EnumerationLiteralCS__Group_1__0)?
{ after(grammarAccess.getEnumerationLiteralCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_2()); }
(rule__EnumerationLiteralCS__Alternatives_2)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__EnumerationLiteralCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_0_0__0__Impl
	rule__EnumerationLiteralCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getLiteralKeyword_0_0_0()); }

	'literal'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getLiteralKeyword_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_0_1()); }
(rule__EnumerationLiteralCS__NameAssignment_0_0_1)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationLiteralCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_1__0__Impl
	rule__EnumerationLiteralCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getEqualsSignKeyword_1_0()); }

	'='

{ after(grammarAccess.getEnumerationLiteralCSAccess().getEqualsSignKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getValueAssignment_1_1()); }
(rule__EnumerationLiteralCS__ValueAssignment_1_1)
{ after(grammarAccess.getEnumerationLiteralCSAccess().getValueAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__EnumerationLiteralCS__Group_2_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_2_0__0__Impl
	rule__EnumerationLiteralCS__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_2_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getLeftCurlyBracketKeyword_2_0_0()); }

	'{'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getLeftCurlyBracketKeyword_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__EnumerationLiteralCS__Group_2_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__EnumerationLiteralCS__Group_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__Group_2_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getRightCurlyBracketKeyword_2_0_1()); }

	'}'

{ after(grammarAccess.getEnumerationLiteralCSAccess().getRightCurlyBracketKeyword_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__0__Impl
	rule__OperationCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives_0()); }
(rule__OperationCS__Alternatives_0)?
{ after(grammarAccess.getOperationCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__1__Impl
	rule__OperationCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOperationKeyword_1()); }

	'operation'

{ after(grammarAccess.getOperationCSAccess().getOperationKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__2__Impl
	rule__OperationCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedSignatureAssignment_2()); }
(rule__OperationCS__OwnedSignatureAssignment_2)?
{ after(grammarAccess.getOperationCSAccess().getOwnedSignatureAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__3__Impl
	rule__OperationCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getNameAssignment_3()); }
(rule__OperationCS__NameAssignment_3)
{ after(grammarAccess.getOperationCSAccess().getNameAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__4__Impl
	rule__OperationCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_4()); }

	'('

{ after(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__5__Impl
	rule__OperationCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_5()); }
(rule__OperationCS__Group_5__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__6__Impl
	rule__OperationCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_6()); }

	')'

{ after(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__7__Impl
	rule__OperationCS__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_7()); }
(rule__OperationCS__Group_7__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__8
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__8__Impl
	rule__OperationCS__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__8__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_8()); }
(rule__OperationCS__Group_8__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_8()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__9
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__9__Impl
	rule__OperationCS__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__9__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_9()); }
(rule__OperationCS__Group_9__0)?
{ after(grammarAccess.getOperationCSAccess().getGroup_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group__10
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group__10__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives_10()); }
(rule__OperationCS__Alternatives_10)
{ after(grammarAccess.getOperationCSAccess().getAlternatives_10()); }
)

;
finally {
	restoreStackSize(stackSize);
}
























rule__OperationCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_0__0__Impl
	rule__OperationCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_0()); }
(rule__OperationCS__QualifiersAssignment_0_0_0)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_1()); }
(rule__OperationCS__QualifiersAssignment_0_0_1)?
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_1__0__Impl
	rule__OperationCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_0()); }
(rule__OperationCS__QualifiersAssignment_0_1_0)
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_1()); }
(rule__OperationCS__QualifiersAssignment_0_1_1)?
{ after(grammarAccess.getOperationCSAccess().getQualifiersAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5__0__Impl
	rule__OperationCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_0()); }
(rule__OperationCS__OwnedParametersAssignment_5_0)
{ after(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_5_1()); }
(rule__OperationCS__Group_5_1__0)*
{ after(grammarAccess.getOperationCSAccess().getGroup_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_5_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5_1__0__Impl
	rule__OperationCS__Group_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getCommaKeyword_5_1_0()); }

	','

{ after(grammarAccess.getOperationCSAccess().getCommaKeyword_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_5_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_5_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_1_1()); }
(rule__OperationCS__OwnedParametersAssignment_5_1_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedParametersAssignment_5_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_7__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_7__0__Impl
	rule__OperationCS__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_7__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getColonKeyword_7_0()); }

	':'

{ after(grammarAccess.getOperationCSAccess().getColonKeyword_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_7__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_7__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedTypeAssignment_7_1()); }
(rule__OperationCS__OwnedTypeAssignment_7_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedTypeAssignment_7_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_8__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8__0__Impl
	rule__OperationCS__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getThrowsKeyword_8_0()); }

	'throws'

{ after(grammarAccess.getOperationCSAccess().getThrowsKeyword_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_8__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8__1__Impl
	rule__OperationCS__Group_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_1()); }
(rule__OperationCS__OwnedExceptionsAssignment_8_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_8__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_8_2()); }
(rule__OperationCS__Group_8_2__0)*
{ after(grammarAccess.getOperationCSAccess().getGroup_8_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__OperationCS__Group_8_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8_2__0__Impl
	rule__OperationCS__Group_8_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getCommaKeyword_8_2_0()); }

	','

{ after(grammarAccess.getOperationCSAccess().getCommaKeyword_8_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_8_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_8_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_8_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_2_1()); }
(rule__OperationCS__OwnedExceptionsAssignment_8_2_1)
{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsAssignment_8_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_9__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9__0__Impl
	rule__OperationCS__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0()); }

	'{'

{ after(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_9__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9__1__Impl
	rule__OperationCS__Group_9__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
(rule__OperationCS__Group_9_1__0)
{ after(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
)
(
{ before(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
(rule__OperationCS__Group_9_1__0)*
{ after(grammarAccess.getOperationCSAccess().getGroup_9_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_9__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_9_2()); }

	'}'

{ after(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_9_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__OperationCS__Group_9_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9_1__0__Impl
	rule__OperationCS__Group_9_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getAlternatives_9_1_0()); }
(rule__OperationCS__Alternatives_9_1_0)
{ after(grammarAccess.getOperationCSAccess().getAlternatives_9_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_9_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_9_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_9_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getCommaKeyword_9_1_1()); }
(
	','
)?
{ after(grammarAccess.getOperationCSAccess().getCommaKeyword_9_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__OperationCS__Group_10_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0__0__Impl
	rule__OperationCS__Group_10_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_10_0_0()); }

	'{'

{ after(grammarAccess.getOperationCSAccess().getLeftCurlyBracketKeyword_10_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0__1__Impl
	rule__OperationCS__Group_10_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getGroup_10_0_1()); }
(rule__OperationCS__Group_10_0_1__0)*
{ after(grammarAccess.getOperationCSAccess().getGroup_10_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_10_0_2()); }

	'}'

{ after(grammarAccess.getOperationCSAccess().getRightCurlyBracketKeyword_10_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__OperationCS__Group_10_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1__0__Impl
	rule__OperationCS__Group_10_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getBodyKeyword_10_0_1_0()); }

	'body'

{ after(grammarAccess.getOperationCSAccess().getBodyKeyword_10_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1__1__Impl
	rule__OperationCS__Group_10_0_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getUnrestrictedNameParserRuleCall_10_0_1_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getOperationCSAccess().getUnrestrictedNameParserRuleCall_10_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1__2__Impl
	rule__OperationCS__Group_10_0_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getColonKeyword_10_0_1_2()); }

	':'

{ after(grammarAccess.getOperationCSAccess().getColonKeyword_10_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1__3__Impl
	rule__OperationCS__Group_10_0_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsAssignment_10_0_1_3()); }
(rule__OperationCS__OwnedBodyExpressionsAssignment_10_0_1_3)?
{ after(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsAssignment_10_0_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCS__Group_10_0_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__OperationCS__Group_10_0_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__Group_10_0_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_0_1_4()); }

	';'

{ after(grammarAccess.getOperationCSAccess().getSemicolonKeyword_10_0_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ParameterCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__0__Impl
	rule__ParameterCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getNameAssignment_0()); }
(rule__ParameterCS__NameAssignment_0)
{ after(grammarAccess.getParameterCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__1__Impl
	rule__ParameterCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getGroup_1()); }
(rule__ParameterCS__Group_1__0)?
{ after(grammarAccess.getParameterCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__2__Impl
	rule__ParameterCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getGroup_2()); }
(rule__ParameterCS__Group_2__0)?
{ after(grammarAccess.getParameterCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getGroup_3()); }
(rule__ParameterCS__Group_3__0)?
{ after(grammarAccess.getParameterCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__ParameterCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_1__0__Impl
	rule__ParameterCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getParameterCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__ParameterCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getParameterCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ParameterCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2__0__Impl
	rule__ParameterCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_2_0()); }

	'{'

{ after(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2__1__Impl
	rule__ParameterCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
(rule__ParameterCS__Group_2_1__0)
{ after(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
)
(
{ before(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
(rule__ParameterCS__Group_2_1__0)*
{ after(grammarAccess.getParameterCSAccess().getGroup_2_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_2_2()); }

	'}'

{ after(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ParameterCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2_1__0__Impl
	rule__ParameterCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getAlternatives_2_1_0()); }
(rule__ParameterCS__Alternatives_2_1_0)
{ after(grammarAccess.getParameterCSAccess().getAlternatives_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getCommaKeyword_2_1_1()); }
(
	','
)?
{ after(grammarAccess.getParameterCSAccess().getCommaKeyword_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ParameterCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_3__0__Impl
	rule__ParameterCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_3_0()); }

	'{'

{ after(grammarAccess.getParameterCSAccess().getLeftCurlyBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ParameterCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_3_1()); }

	'}'

{ after(grammarAccess.getParameterCSAccess().getRightCurlyBracketKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__0__Impl
	rule__ReferenceCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_0()); }
(rule__ReferenceCS__Alternatives_0)?
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__1__Impl
	rule__ReferenceCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getPropertyKeyword_1()); }

	'property'

{ after(grammarAccess.getReferenceCSAccess().getPropertyKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__2__Impl
	rule__ReferenceCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getNameAssignment_2()); }
(rule__ReferenceCS__NameAssignment_2)
{ after(grammarAccess.getReferenceCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__3__Impl
	rule__ReferenceCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_3()); }
(rule__ReferenceCS__Group_3__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__4__Impl
	rule__ReferenceCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_4()); }
(rule__ReferenceCS__Group_4__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__5__Impl
	rule__ReferenceCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_5()); }
(rule__ReferenceCS__Group_5__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__6__Impl
	rule__ReferenceCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_6()); }
(rule__ReferenceCS__Group_6__0)?
{ after(grammarAccess.getReferenceCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_7()); }
(rule__ReferenceCS__Alternatives_7)
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ReferenceCS__Group_0_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_0__0__Impl
	rule__ReferenceCS__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_0()); }
(rule__ReferenceCS__QualifiersAssignment_0_0_0)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_0_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_1()); }
(rule__ReferenceCS__QualifiersAssignment_0_0_1)?
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_1__0__Impl
	rule__ReferenceCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_0()); }
(rule__ReferenceCS__QualifiersAssignment_0_1_0)
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_1()); }
(rule__ReferenceCS__QualifiersAssignment_0_1_1)?
{ after(grammarAccess.getReferenceCSAccess().getQualifiersAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_3__0__Impl
	rule__ReferenceCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getNumberSignKeyword_3_0()); }

	'#'

{ after(grammarAccess.getReferenceCSAccess().getNumberSignKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredOppositeAssignment_3_1()); }
(rule__ReferenceCS__ReferredOppositeAssignment_3_1)
{ after(grammarAccess.getReferenceCSAccess().getReferredOppositeAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_4__0__Impl
	rule__ReferenceCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getColonKeyword_4_0()); }

	':'

{ after(grammarAccess.getReferenceCSAccess().getColonKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedTypeAssignment_4_1()); }
(rule__ReferenceCS__OwnedTypeAssignment_4_1)
{ after(grammarAccess.getReferenceCSAccess().getOwnedTypeAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_5__0__Impl
	rule__ReferenceCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getEqualsSignKeyword_5_0()); }

	'='

{ after(grammarAccess.getReferenceCSAccess().getEqualsSignKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getDefaultAssignment_5_1()); }
(rule__ReferenceCS__DefaultAssignment_5_1)
{ after(grammarAccess.getReferenceCSAccess().getDefaultAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6__0__Impl
	rule__ReferenceCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_6_0()); }

	'{'

{ after(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6__1__Impl
	rule__ReferenceCS__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
(rule__ReferenceCS__Group_6_1__0)
{ after(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
)
(
{ before(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
(rule__ReferenceCS__Group_6_1__0)*
{ after(grammarAccess.getReferenceCSAccess().getGroup_6_1()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_6_2()); }

	'}'

{ after(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ReferenceCS__Group_6_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6_1__0__Impl
	rule__ReferenceCS__Group_6_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_6_1_0()); }
(rule__ReferenceCS__Alternatives_6_1_0)
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_6_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_6_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_6_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getCommaKeyword_6_1_1()); }
(
	','
)?
{ after(grammarAccess.getReferenceCSAccess().getCommaKeyword_6_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ReferenceCS__Group_7_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0__0__Impl
	rule__ReferenceCS__Group_7_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }

	'{'

{ after(grammarAccess.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0__1__Impl
	rule__ReferenceCS__Group_7_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getAlternatives_7_0_1()); }
(rule__ReferenceCS__Alternatives_7_0_1)*
{ after(grammarAccess.getReferenceCSAccess().getAlternatives_7_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2()); }

	'}'

{ after(grammarAccess.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__ReferenceCS__Group_7_0_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_0__0__Impl
	rule__ReferenceCS__Group_7_0_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getInitialKeyword_7_0_1_0_0()); }

	'initial'

{ after(grammarAccess.getReferenceCSAccess().getInitialKeyword_7_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_0__1__Impl
	rule__ReferenceCS__Group_7_0_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_0_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_0__2__Impl
	rule__ReferenceCS__Group_7_0_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_0_2()); }

	':'

{ after(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_0__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_0__3__Impl
	rule__ReferenceCS__Group_7_0_1_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_0__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_0_3()); }
(rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_0_3)?
{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_0_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_0__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_0__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_0__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_0_4()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_0_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__ReferenceCS__Group_7_0_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__0__Impl
	rule__ReferenceCS__Group_7_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getDerivationKeyword_7_0_1_1_0()); }

	'derivation'

{ after(grammarAccess.getReferenceCSAccess().getDerivationKeyword_7_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__1__Impl
	rule__ReferenceCS__Group_7_0_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_1_1()); }
(	ruleUnrestrictedName)?
{ after(grammarAccess.getReferenceCSAccess().getUnrestrictedNameParserRuleCall_7_0_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__2__Impl
	rule__ReferenceCS__Group_7_0_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_1_2()); }

	':'

{ after(grammarAccess.getReferenceCSAccess().getColonKeyword_7_0_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__3__Impl
	rule__ReferenceCS__Group_7_0_1_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_1_3()); }
(rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_1_3)?
{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsAssignment_7_0_1_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceCS__Group_7_0_1_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ReferenceCS__Group_7_0_1_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__Group_7_0_1_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_1_4()); }

	';'

{ after(grammarAccess.getReferenceCSAccess().getSemicolonKeyword_7_0_1_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__StructuredClassCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__0__Impl
	rule__StructuredClassCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsAbstractAssignment_0()); }
(rule__StructuredClassCS__IsAbstractAssignment_0)?
{ after(grammarAccess.getStructuredClassCSAccess().getIsAbstractAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__1__Impl
	rule__StructuredClassCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getClassKeyword_1()); }

	'class'

{ after(grammarAccess.getStructuredClassCSAccess().getClassKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__2__Impl
	rule__StructuredClassCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getNameAssignment_2()); }
(rule__StructuredClassCS__NameAssignment_2)
{ after(grammarAccess.getStructuredClassCSAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__3__Impl
	rule__StructuredClassCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureAssignment_3()); }
(rule__StructuredClassCS__OwnedSignatureAssignment_3)?
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__4__Impl
	rule__StructuredClassCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_4()); }
(rule__StructuredClassCS__Group_4__0)?
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__5__Impl
	rule__StructuredClassCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_5()); }
(rule__StructuredClassCS__Group_5__0)?
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__6__Impl
	rule__StructuredClassCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_6()); }
(rule__StructuredClassCS__Group_6__0)?
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getAlternatives_7()); }
(rule__StructuredClassCS__Alternatives_7)
{ after(grammarAccess.getStructuredClassCSAccess().getAlternatives_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__StructuredClassCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4__0__Impl
	rule__StructuredClassCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getExtendsKeyword_4_0()); }

	'extends'

{ after(grammarAccess.getStructuredClassCSAccess().getExtendsKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4__1__Impl
	rule__StructuredClassCS__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_1()); }
(rule__StructuredClassCS__OwnedSuperTypesAssignment_4_1)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getGroup_4_2()); }
(rule__StructuredClassCS__Group_4_2__0)*
{ after(grammarAccess.getStructuredClassCSAccess().getGroup_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__StructuredClassCS__Group_4_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4_2__0__Impl
	rule__StructuredClassCS__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getCommaKeyword_4_2_0()); }

	','

{ after(grammarAccess.getStructuredClassCSAccess().getCommaKeyword_4_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_4_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_4_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_2_1()); }
(rule__StructuredClassCS__OwnedSuperTypesAssignment_4_2_1)
{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesAssignment_4_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StructuredClassCS__Group_5__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_5__0__Impl
	rule__StructuredClassCS__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_5__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getColonKeyword_5_0()); }

	':'

{ after(grammarAccess.getStructuredClassCSAccess().getColonKeyword_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_5__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_5__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameAssignment_5_1()); }
(rule__StructuredClassCS__InstanceClassNameAssignment_5_1)
{ after(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameAssignment_5_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__StructuredClassCS__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_6__0__Impl
	rule__StructuredClassCS__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_6_0()); }

	'{'

{ after(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_6__1__Impl
	rule__StructuredClassCS__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsInterfaceAssignment_6_1()); }
(rule__StructuredClassCS__IsInterfaceAssignment_6_1)?
{ after(grammarAccess.getStructuredClassCSAccess().getIsInterfaceAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_6__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_6__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_6_2()); }

	'}'

{ after(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_6_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__StructuredClassCS__Group_7_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_7_0__0__Impl
	rule__StructuredClassCS__Group_7_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_7_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }

	'{'

{ after(grammarAccess.getStructuredClassCSAccess().getLeftCurlyBracketKeyword_7_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_7_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_7_0__1__Impl
	rule__StructuredClassCS__Group_7_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_7_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getAlternatives_7_0_1()); }
(rule__StructuredClassCS__Alternatives_7_0_1)*
{ after(grammarAccess.getStructuredClassCSAccess().getAlternatives_7_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__StructuredClassCS__Group_7_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__StructuredClassCS__Group_7_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__Group_7_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_7_0_2()); }

	'}'

{ after(grammarAccess.getStructuredClassCSAccess().getRightCurlyBracketKeyword_7_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypedMultiplicityRefCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedMultiplicityRefCS__Group__0__Impl
	rule__TypedMultiplicityRefCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMultiplicityRefCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedRefCSParserRuleCall_0()); }
	ruleTypedRefCS
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getTypedRefCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedMultiplicityRefCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedMultiplicityRefCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMultiplicityRefCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityAssignment_1()); }
(rule__TypedMultiplicityRefCS__OwnedMultiplicityAssignment_1)?
{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SIGNED__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SIGNED__Group__0__Impl
	rule__SIGNED__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SIGNED__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSIGNEDAccess().getHyphenMinusKeyword_0()); }
(
	'-'
)?
{ after(grammarAccess.getSIGNEDAccess().getHyphenMinusKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SIGNED__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SIGNED__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SIGNED__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSIGNEDAccess().getINTTerminalRuleCall_1()); }
	RULE_INT
{ after(grammarAccess.getSIGNEDAccess().getINTTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__URIPathNameCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group__0__Impl
	rule__URIPathNameCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
(rule__URIPathNameCS__OwnedPathElementsAssignment_0)
{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIPathNameCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getGroup_1()); }
(rule__URIPathNameCS__Group_1__0)*
{ after(grammarAccess.getURIPathNameCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__URIPathNameCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group_1__0__Impl
	rule__URIPathNameCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0()); }

	'::'

{ after(grammarAccess.getURIPathNameCSAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIPathNameCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIPathNameCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
(rule__URIPathNameCS__OwnedPathElementsAssignment_1_1)
{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__URIFirstPathElementCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIFirstPathElementCS__Group_1__0__Impl
	rule__URIFirstPathElementCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0()); }
(

)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIFirstPathElementCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__URIFirstPathElementCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_1_1()); }
(rule__URIFirstPathElementCS__ReferredElementAssignment_1_1)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group__0__Impl
	rule__CollectionTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getNameAssignment_0()); }
(rule__CollectionTypeCS__NameAssignment_0)
{ after(grammarAccess.getCollectionTypeCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getGroup_1()); }
(rule__CollectionTypeCS__Group_1__0)?
{ after(grammarAccess.getCollectionTypeCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionTypeCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group_1__0__Impl
	rule__CollectionTypeCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionTypeCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group_1__1__Impl
	rule__CollectionTypeCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__CollectionTypeCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionTypeCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionTypeCS__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2()); }

	')'

{ after(grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__MapTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group__0__Impl
	rule__MapTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getNameAssignment_0()); }
(rule__MapTypeCS__NameAssignment_0)
{ after(grammarAccess.getMapTypeCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getGroup_1()); }
(rule__MapTypeCS__Group_1__0)?
{ after(grammarAccess.getMapTypeCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MapTypeCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__0__Impl
	rule__MapTypeCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__1__Impl
	rule__MapTypeCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeAssignment_1_1()); }
(rule__MapTypeCS__OwnedKeyTypeAssignment_1_1)
{ after(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__2__Impl
	rule__MapTypeCS__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2()); }

	','

{ after(grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__3__Impl
	rule__MapTypeCS__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeAssignment_1_3()); }
(rule__MapTypeCS__OwnedValueTypeAssignment_1_3)
{ after(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeAssignment_1_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapTypeCS__Group_1__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapTypeCS__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__Group_1__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4()); }

	')'

{ after(grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__TupleTypeCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group__0__Impl
	rule__TupleTypeCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getNameAssignment_0()); }
(rule__TupleTypeCS__NameAssignment_0)
{ after(grammarAccess.getTupleTypeCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup_1()); }
(rule__TupleTypeCS__Group_1__0)?
{ after(grammarAccess.getTupleTypeCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TupleTypeCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1__0__Impl
	rule__TupleTypeCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1__1__Impl
	rule__TupleTypeCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup_1_1()); }
(rule__TupleTypeCS__Group_1_1__0)?
{ after(grammarAccess.getTupleTypeCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()); }

	')'

{ after(grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TupleTypeCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1__0__Impl
	rule__TupleTypeCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_0()); }
(rule__TupleTypeCS__OwnedPartsAssignment_1_1_0)
{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getGroup_1_1_1()); }
(rule__TupleTypeCS__Group_1_1_1__0)*
{ after(grammarAccess.getTupleTypeCSAccess().getGroup_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TupleTypeCS__Group_1_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1_1__0__Impl
	rule__TupleTypeCS__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0()); }

	','

{ after(grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleTypeCS__Group_1_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleTypeCS__Group_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__Group_1_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_1_1()); }
(rule__TupleTypeCS__OwnedPartsAssignment_1_1_1_1)
{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsAssignment_1_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TuplePartCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TuplePartCS__Group__0__Impl
	rule__TuplePartCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getNameAssignment_0()); }
(rule__TuplePartCS__NameAssignment_0)
{ after(grammarAccess.getTuplePartCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TuplePartCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TuplePartCS__Group__1__Impl
	rule__TuplePartCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getTuplePartCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TuplePartCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TuplePartCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getOwnedTypeAssignment_2()); }
(rule__TuplePartCS__OwnedTypeAssignment_2)
{ after(grammarAccess.getTuplePartCSAccess().getOwnedTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__CollectionLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__0__Impl
	rule__CollectionLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
(rule__CollectionLiteralExpCS__OwnedTypeAssignment_0)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__1__Impl
	rule__CollectionLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__2__Impl
	rule__CollectionLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2()); }
(rule__CollectionLiteralExpCS__Group_2__0)?
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CollectionLiteralExpCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2__0__Impl
	rule__CollectionLiteralExpCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1()); }
(rule__CollectionLiteralExpCS__Group_2_1__0)*
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionLiteralExpCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2_1__0__Impl
	rule__CollectionLiteralExpCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralExpCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralExpCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionLiteralPartCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0__0__Impl
	rule__CollectionLiteralPartCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_0_0()); }
(rule__CollectionLiteralPartCS__OwnedExpressionAssignment_0_0)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralPartCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0_1()); }
(rule__CollectionLiteralPartCS__Group_0_1__0)?
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionLiteralPartCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0_1__0__Impl
	rule__CollectionLiteralPartCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0()); }

	'..'

{ after(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionLiteralPartCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionLiteralPartCS__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionAssignment_0_1_1()); }
(rule__CollectionLiteralPartCS__OwnedLastExpressionAssignment_0_1_1)
{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionPatternCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__0__Impl
	rule__CollectionPatternCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeAssignment_0()); }
(rule__CollectionPatternCS__OwnedTypeAssignment_0)
{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__1__Impl
	rule__CollectionPatternCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__2__Impl
	rule__CollectionPatternCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup_2()); }
(rule__CollectionPatternCS__Group_2__0)?
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CollectionPatternCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2__0__Impl
	rule__CollectionPatternCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__CollectionPatternCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2__1__Impl
	rule__CollectionPatternCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup_2_1()); }
(rule__CollectionPatternCS__Group_2_1__0)*
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getGroup_2_2()); }
(rule__CollectionPatternCS__Group_2_2__0)
{ after(grammarAccess.getCollectionPatternCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__CollectionPatternCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_1__0__Impl
	rule__CollectionPatternCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__CollectionPatternCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CollectionPatternCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_2__0__Impl
	rule__CollectionPatternCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0()); }

	'++'

{ after(grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollectionPatternCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollectionPatternCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameAssignment_2_2_1()); }
(rule__CollectionPatternCS__RestVariableNameAssignment_2_2_1)
{ after(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ShadowPartCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShadowPartCS__Group_0__0__Impl
	rule__ShadowPartCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getReferredPropertyAssignment_0_0()); }
(rule__ShadowPartCS__ReferredPropertyAssignment_0_0)
{ after(grammarAccess.getShadowPartCSAccess().getReferredPropertyAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShadowPartCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShadowPartCS__Group_0__1__Impl
	rule__ShadowPartCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1()); }

	'='

{ after(grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ShadowPartCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ShadowPartCS__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_0_2()); }
(rule__ShadowPartCS__OwnedInitExpressionAssignment_0_2)
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PatternExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PatternExpCS__Group__0__Impl
	rule__PatternExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getPatternVariableNameAssignment_0()); }
(rule__PatternExpCS__PatternVariableNameAssignment_0)?
{ after(grammarAccess.getPatternExpCSAccess().getPatternVariableNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PatternExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PatternExpCS__Group__1__Impl
	rule__PatternExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getColonKeyword_1()); }

	':'

{ after(grammarAccess.getPatternExpCSAccess().getColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PatternExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PatternExpCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeAssignment_2()); }
(rule__PatternExpCS__OwnedPatternTypeAssignment_2)
{ after(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__LambdaLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__0__Impl
	rule__LambdaLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0()); }

	'Lambda'

{ after(grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__1__Impl
	rule__LambdaLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__2__Impl
	rule__LambdaLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSAssignment_2()); }
(rule__LambdaLiteralExpCS__OwnedExpressionCSAssignment_2)
{ after(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LambdaLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LambdaLiteralExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__MapLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__0__Impl
	rule__MapLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
(rule__MapLiteralExpCS__OwnedTypeAssignment_0)
{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__1__Impl
	rule__MapLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__2__Impl
	rule__MapLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getGroup_2()); }
(rule__MapLiteralExpCS__Group_2__0)?
{ after(grammarAccess.getMapLiteralExpCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__MapLiteralExpCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2__0__Impl
	rule__MapLiteralExpCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__MapLiteralExpCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getGroup_2_1()); }
(rule__MapLiteralExpCS__Group_2_1__0)*
{ after(grammarAccess.getMapLiteralExpCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MapLiteralExpCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2_1__0__Impl
	rule__MapLiteralExpCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralExpCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralExpCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__MapLiteralExpCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MapLiteralPartCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralPartCS__Group__0__Impl
	rule__MapLiteralPartCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyAssignment_0()); }
(rule__MapLiteralPartCS__OwnedKeyAssignment_0)
{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralPartCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralPartCS__Group__1__Impl
	rule__MapLiteralPartCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1()); }

	'<-'

{ after(grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MapLiteralPartCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MapLiteralPartCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueAssignment_2()); }
(rule__MapLiteralPartCS__OwnedValueAssignment_2)
{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TupleLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__0__Impl
	rule__TupleLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0()); }

	'Tuple'

{ after(grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__1__Impl
	rule__TupleLiteralExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__2__Impl
	rule__TupleLiteralExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_2()); }
(rule__TupleLiteralExpCS__OwnedPartsAssignment_2)
{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__3__Impl
	rule__TupleLiteralExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3()); }
(rule__TupleLiteralExpCS__Group_3__0)*
{ after(grammarAccess.getTupleLiteralExpCSAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4()); }

	'}'

{ after(grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__TupleLiteralExpCS__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group_3__0__Impl
	rule__TupleLiteralExpCS__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0()); }

	','

{ after(grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralExpCS__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralExpCS__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_3_1()); }
(rule__TupleLiteralExpCS__OwnedPartsAssignment_3_1)
{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TupleLiteralPartCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__0__Impl
	rule__TupleLiteralPartCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0()); }
(rule__TupleLiteralPartCS__NameAssignment_0)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__1__Impl
	rule__TupleLiteralPartCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1()); }
(rule__TupleLiteralPartCS__Group_1__0)?
{ after(grammarAccess.getTupleLiteralPartCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__2__Impl
	rule__TupleLiteralPartCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2()); }

	'='

{ after(grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionAssignment_3()); }
(rule__TupleLiteralPartCS__OwnedInitExpressionAssignment_3)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TupleLiteralPartCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group_1__0__Impl
	rule__TupleLiteralPartCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TupleLiteralPartCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TupleLiteralPartCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__TupleLiteralPartCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__UnlimitedNaturalLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnlimitedNaturalLiteralExpCS__Group__0__Impl
	rule__UnlimitedNaturalLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnlimitedNaturalLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0()); }
(

)
{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__UnlimitedNaturalLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__UnlimitedNaturalLiteralExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnlimitedNaturalLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1()); }

	'*'

{ after(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__InvalidLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvalidLiteralExpCS__Group__0__Impl
	rule__InvalidLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InvalidLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0()); }
(

)
{ after(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__InvalidLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__InvalidLiteralExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InvalidLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1()); }

	'invalid'

{ after(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NullLiteralExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullLiteralExpCS__Group__0__Impl
	rule__NullLiteralExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NullLiteralExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0()); }
(

)
{ after(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NullLiteralExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NullLiteralExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NullLiteralExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1()); }

	'null'

{ after(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeLiteralWithMultiplicityCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeLiteralWithMultiplicityCS__Group__0__Impl
	rule__TypeLiteralWithMultiplicityCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralWithMultiplicityCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); }
	ruleTypeLiteralCS
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeLiteralWithMultiplicityCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeLiteralWithMultiplicityCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralWithMultiplicityCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityAssignment_1()); }
(rule__TypeLiteralWithMultiplicityCS__OwnedMultiplicityAssignment_1)?
{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeNameExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group__0__Impl
	rule__TypeNameExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNameAssignment_0()); }
(rule__TypeNameExpCS__OwnedPathNameAssignment_0)
{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getGroup_1()); }
(rule__TypeNameExpCS__Group_1__0)?
{ after(grammarAccess.getTypeNameExpCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeNameExpCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1__0__Impl
	rule__TypeNameExpCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_1_0()); }
(rule__TypeNameExpCS__OwnedCurlyBracketedClauseAssignment_1_0)
{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getGroup_1_1()); }
(rule__TypeNameExpCS__Group_1_1__0)?
{ after(grammarAccess.getTypeNameExpCSAccess().getGroup_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeNameExpCS__Group_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1_1__0__Impl
	rule__TypeNameExpCS__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0()); }

	'{'

{ after(grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1_1__1__Impl
	rule__TypeNameExpCS__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardAssignment_1_1_1()); }
(rule__TypeNameExpCS__OwnedPatternGuardAssignment_1_1_1)
{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardAssignment_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeNameExpCS__Group_1_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeNameExpCS__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__Group_1_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2()); }

	'}'

{ after(grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeExpCS__Group__0__Impl
	rule__TypeExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpCSAccess().getAlternatives_0()); }
(rule__TypeExpCS__Alternatives_0)
{ after(grammarAccess.getTypeExpCSAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityAssignment_1()); }
(rule__TypeExpCS__OwnedMultiplicityAssignment_1)?
{ after(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ExpCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0__0__Impl
	rule__ExpCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); }
	rulePrefixedPrimaryExpCS
{ after(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExpCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getGroup_0_1()); }
(rule__ExpCS__Group_0_1__0)?
{ after(grammarAccess.getExpCSAccess().getGroup_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__ExpCS__Group_0_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0_1__0__Impl
	rule__ExpCS__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0()); }
(

)
{ after(grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExpCS__Group_0_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0_1__1__Impl
	rule__ExpCS__Group_0_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getNameAssignment_0_1_1()); }
(rule__ExpCS__NameAssignment_0_1_1)
{ after(grammarAccess.getExpCSAccess().getNameAssignment_0_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ExpCS__Group_0_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ExpCS__Group_0_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__Group_0_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getOwnedRightAssignment_0_1_2()); }
(rule__ExpCS__OwnedRightAssignment_0_1_2)
{ after(grammarAccess.getExpCSAccess().getOwnedRightAssignment_0_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PrefixedLetExpCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedLetExpCS__Group_0__0__Impl
	rule__PrefixedLetExpCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0()); }
(

)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedLetExpCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedLetExpCS__Group_0__1__Impl
	rule__PrefixedLetExpCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getNameAssignment_0_1()); }
(rule__PrefixedLetExpCS__NameAssignment_0_1)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getNameAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedLetExpCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedLetExpCS__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightAssignment_0_2()); }
(rule__PrefixedLetExpCS__OwnedRightAssignment_0_2)
{ after(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__PrefixedPrimaryExpCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedPrimaryExpCS__Group_0__0__Impl
	rule__PrefixedPrimaryExpCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0()); }
(

)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedPrimaryExpCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedPrimaryExpCS__Group_0__1__Impl
	rule__PrefixedPrimaryExpCS__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameAssignment_0_1()); }
(rule__PrefixedPrimaryExpCS__NameAssignment_0_1)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PrefixedPrimaryExpCS__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PrefixedPrimaryExpCS__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightAssignment_0_2()); }
(rule__PrefixedPrimaryExpCS__OwnedRightAssignment_0_2)
{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightAssignment_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NameExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__0__Impl
	rule__NameExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedPathNameAssignment_0()); }
(rule__NameExpCS__OwnedPathNameAssignment_0)
{ after(grammarAccess.getNameExpCSAccess().getOwnedPathNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__1__Impl
	rule__NameExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesAssignment_1()); }
(rule__NameExpCS__OwnedSquareBracketedClausesAssignment_1)*
{ after(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__2__Impl
	rule__NameExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseAssignment_2()); }
(rule__NameExpCS__OwnedRoundBracketedClauseAssignment_2)?
{ after(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__3__Impl
	rule__NameExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_3()); }
(rule__NameExpCS__OwnedCurlyBracketedClauseAssignment_3)?
{ after(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getGroup_4()); }
(rule__NameExpCS__Group_4__0)?
{ after(grammarAccess.getNameExpCSAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__NameExpCS__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group_4__0__Impl
	rule__NameExpCS__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getIsPreAssignment_4_0()); }
(rule__NameExpCS__IsPreAssignment_4_0)
{ after(grammarAccess.getNameExpCSAccess().getIsPreAssignment_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NameExpCS__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NameExpCS__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getPreKeyword_4_1()); }

	'pre'

{ after(grammarAccess.getNameExpCSAccess().getPreKeyword_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CurlyBracketedClauseCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__0__Impl
	rule__CurlyBracketedClauseCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0()); }
(

)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__1__Impl
	rule__CurlyBracketedClauseCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1()); }

	'{'

{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__2__Impl
	rule__CurlyBracketedClauseCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2()); }
(rule__CurlyBracketedClauseCS__Group_2__0)?
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3()); }

	'}'

{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__CurlyBracketedClauseCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2__0__Impl
	rule__CurlyBracketedClauseCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_0()); }
(rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_0)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2_1()); }
(rule__CurlyBracketedClauseCS__Group_2_1__0)*
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getGroup_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__CurlyBracketedClauseCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2_1__0__Impl
	rule__CurlyBracketedClauseCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0()); }

	','

{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CurlyBracketedClauseCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CurlyBracketedClauseCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_1_1()); }
(rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_1_1)
{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RoundBracketedClauseCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__0__Impl
	rule__RoundBracketedClauseCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0()); }
(

)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__1__Impl
	rule__RoundBracketedClauseCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1()); }

	'('

{ after(grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__2__Impl
	rule__RoundBracketedClauseCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2()); }
(rule__RoundBracketedClauseCS__Group_2__0)?
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3()); }

	')'

{ after(grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__RoundBracketedClauseCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2__0__Impl
	rule__RoundBracketedClauseCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_0()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_0)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2__1__Impl
	rule__RoundBracketedClauseCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_1()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_1)*
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2__2__Impl
	rule__RoundBracketedClauseCS__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2_2()); }
(rule__RoundBracketedClauseCS__Group_2_2__0)?
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group_2__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2_3()); }
(rule__RoundBracketedClauseCS__Group_2_3__0)*
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getGroup_2_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__RoundBracketedClauseCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2_2__0__Impl
	rule__RoundBracketedClauseCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_2_0()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_2_0)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_2_1()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_2_1)*
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__RoundBracketedClauseCS__Group_2_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2_3__0__Impl
	rule__RoundBracketedClauseCS__Group_2_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_3_0()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_3_0)
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RoundBracketedClauseCS__Group_2_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RoundBracketedClauseCS__Group_2_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__Group_2_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_3_1()); }
(rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_3_1)*
{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsAssignment_2_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__SquareBracketedClauseCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__0__Impl
	rule__SquareBracketedClauseCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0()); }

	'['

{ after(grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__1__Impl
	rule__SquareBracketedClauseCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_1()); }
(rule__SquareBracketedClauseCS__OwnedTermsAssignment_1)
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__2__Impl
	rule__SquareBracketedClauseCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getGroup_2()); }
(rule__SquareBracketedClauseCS__Group_2__0)*
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3()); }

	']'

{ after(grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__SquareBracketedClauseCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group_2__0__Impl
	rule__SquareBracketedClauseCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0()); }

	','

{ after(grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SquareBracketedClauseCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SquareBracketedClauseCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_2_1()); }
(rule__SquareBracketedClauseCS__OwnedTermsAssignment_2_1)
{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0__0__Impl
	rule__NavigatingArgCS__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionAssignment_0_0()); }
(rule__NavigatingArgCS__OwnedNameExpressionAssignment_0_0)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionAssignment_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1()); }
(rule__NavigatingArgCS__Alternatives_0_1)?
{ after(grammarAccess.getNavigatingArgCSAccess().getAlternatives_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0_1_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0__0__Impl
	rule__NavigatingArgCS__Group_0_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0()); }

	':'

{ after(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0__1__Impl
	rule__NavigatingArgCS__Group_0_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_0_1()); }
(rule__NavigatingArgCS__OwnedTypeAssignment_0_1_0_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_0_1_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0_2()); }
(rule__NavigatingArgCS__Group_0_1_0_2__0)?
{ after(grammarAccess.getNavigatingArgCSAccess().getGroup_0_1_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingArgCS__Group_0_1_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0_2__0__Impl
	rule__NavigatingArgCS__Group_0_1_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0()); }

	'='

{ after(grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_0_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_0_2_1()); }
(rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_0_2_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_0_1_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1__0__Impl
	rule__NavigatingArgCS__Group_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0()); }

	'in'

{ after(grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_0_1_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_0_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_0_1_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_1_1()); }
(rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_1_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionAssignment_0_1_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingArgCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_1__0__Impl
	rule__NavigatingArgCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0()); }

	':'

{ after(grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingArgCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingArgCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_1_1()); }
(rule__NavigatingArgCS__OwnedTypeAssignment_1_1)
{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingBarArgCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group__0__Impl
	rule__NavigatingBarArgCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getPrefixAssignment_0()); }
(rule__NavigatingBarArgCS__PrefixAssignment_0)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getPrefixAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group__1__Impl
	rule__NavigatingBarArgCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionAssignment_1()); }
(rule__NavigatingBarArgCS__OwnedNameExpressionAssignment_1)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2()); }
(rule__NavigatingBarArgCS__Group_2__0)?
{ after(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingBarArgCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2__0__Impl
	rule__NavigatingBarArgCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2__1__Impl
	rule__NavigatingBarArgCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeAssignment_2_1()); }
(rule__NavigatingBarArgCS__OwnedTypeAssignment_2_1)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2_2()); }
(rule__NavigatingBarArgCS__Group_2_2__0)?
{ after(grammarAccess.getNavigatingBarArgCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingBarArgCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2_2__0__Impl
	rule__NavigatingBarArgCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0()); }

	'='

{ after(grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingBarArgCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingBarArgCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
(rule__NavigatingBarArgCS__OwnedInitExpressionAssignment_2_2_1)
{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingCommaArgCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group__0__Impl
	rule__NavigatingCommaArgCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixAssignment_0()); }
(rule__NavigatingCommaArgCS__PrefixAssignment_0)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group__1__Impl
	rule__NavigatingCommaArgCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionAssignment_1()); }
(rule__NavigatingCommaArgCS__OwnedNameExpressionAssignment_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2()); }
(rule__NavigatingCommaArgCS__Alternatives_2)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingCommaArgCS__Group_2_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0__0__Impl
	rule__NavigatingCommaArgCS__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0()); }

	':'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0__1__Impl
	rule__NavigatingCommaArgCS__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_0_1()); }
(rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_0_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeAssignment_2_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0_2()); }
(rule__NavigatingCommaArgCS__Group_2_0_2__0)?
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getGroup_2_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingCommaArgCS__Group_2_0_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0_2__0__Impl
	rule__NavigatingCommaArgCS__Group_2_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0()); }

	'='

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_0_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_0_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_0_2_1()); }
(rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_0_2_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_0_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingCommaArgCS__Group_2_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1__0__Impl
	rule__NavigatingCommaArgCS__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0()); }

	'in'

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingCommaArgCS__Group_2_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingCommaArgCS__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__Group_2_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_1_1()); }
(rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_1_1)
{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionAssignment_2_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NavigatingSemiArgCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group__0__Impl
	rule__NavigatingSemiArgCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixAssignment_0()); }
(rule__NavigatingSemiArgCS__PrefixAssignment_0)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group__1__Impl
	rule__NavigatingSemiArgCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionAssignment_1()); }
(rule__NavigatingSemiArgCS__OwnedNameExpressionAssignment_1)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2()); }
(rule__NavigatingSemiArgCS__Group_2__0)?
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingSemiArgCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2__0__Impl
	rule__NavigatingSemiArgCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2__1__Impl
	rule__NavigatingSemiArgCS__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeAssignment_2_1()); }
(rule__NavigatingSemiArgCS__OwnedTypeAssignment_2_1)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2_2()); }
(rule__NavigatingSemiArgCS__Group_2_2__0)?
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getGroup_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__NavigatingSemiArgCS__Group_2_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2_2__0__Impl
	rule__NavigatingSemiArgCS__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0()); }

	'='

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NavigatingSemiArgCS__Group_2_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NavigatingSemiArgCS__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__Group_2_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
(rule__NavigatingSemiArgCS__OwnedInitExpressionAssignment_2_2_1)
{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionAssignment_2_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__IfExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__0__Impl
	rule__IfExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getIfKeyword_0()); }

	'if'

{ after(grammarAccess.getIfExpCSAccess().getIfKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__1__Impl
	rule__IfExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionAssignment_1()); }
(rule__IfExpCS__OwnedConditionAssignment_1)
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__2__Impl
	rule__IfExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getThenKeyword_2()); }

	'then'

{ after(grammarAccess.getIfExpCSAccess().getThenKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__3__Impl
	rule__IfExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionAssignment_3()); }
(rule__IfExpCS__OwnedThenExpressionAssignment_3)
{ after(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__4__Impl
	rule__IfExpCS__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsAssignment_4()); }
(rule__IfExpCS__OwnedIfThenExpressionsAssignment_4)*
{ after(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__5__Impl
	rule__IfExpCS__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getElseKeyword_5()); }

	'else'

{ after(grammarAccess.getIfExpCSAccess().getElseKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__6__Impl
	rule__IfExpCS__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionAssignment_6()); }
(rule__IfExpCS__OwnedElseExpressionAssignment_6)
{ after(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionAssignment_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IfExpCS__Group__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IfExpCS__Group__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__Group__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getEndifKeyword_7()); }

	'endif'

{ after(grammarAccess.getIfExpCSAccess().getEndifKeyword_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__ElseIfThenExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__0__Impl
	rule__ElseIfThenExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0()); }

	'elseif'

{ after(grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ElseIfThenExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__1__Impl
	rule__ElseIfThenExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionAssignment_1()); }
(rule__ElseIfThenExpCS__OwnedConditionAssignment_1)
{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ElseIfThenExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__2__Impl
	rule__ElseIfThenExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2()); }

	'then'

{ after(grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__ElseIfThenExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__ElseIfThenExpCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionAssignment_3()); }
(rule__ElseIfThenExpCS__OwnedThenExpressionAssignment_3)
{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__LetExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__0__Impl
	rule__LetExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getLetKeyword_0()); }

	'let'

{ after(grammarAccess.getLetExpCSAccess().getLetKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__1__Impl
	rule__LetExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_1()); }
(rule__LetExpCS__OwnedVariablesAssignment_1)
{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__2__Impl
	rule__LetExpCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getGroup_2()); }
(rule__LetExpCS__Group_2__0)*
{ after(grammarAccess.getLetExpCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__3__Impl
	rule__LetExpCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getInKeyword_3()); }

	'in'

{ after(grammarAccess.getLetExpCSAccess().getInKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedInExpressionAssignment_4()); }
(rule__LetExpCS__OwnedInExpressionAssignment_4)
{ after(grammarAccess.getLetExpCSAccess().getOwnedInExpressionAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__LetExpCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group_2__0__Impl
	rule__LetExpCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0()); }

	','

{ after(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetExpCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetExpCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_2_1()); }
(rule__LetExpCS__OwnedVariablesAssignment_2_1)
{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__LetVariableCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__0__Impl
	rule__LetVariableCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getNameAssignment_0()); }
(rule__LetVariableCS__NameAssignment_0)
{ after(grammarAccess.getLetVariableCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__1__Impl
	rule__LetVariableCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseAssignment_1()); }
(rule__LetVariableCS__OwnedRoundBracketedClauseAssignment_1)?
{ after(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__2__Impl
	rule__LetVariableCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getGroup_2()); }
(rule__LetVariableCS__Group_2__0)?
{ after(grammarAccess.getLetVariableCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__3__Impl
	rule__LetVariableCS__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3()); }

	'='

{ after(grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionAssignment_4()); }
(rule__LetVariableCS__OwnedInitExpressionAssignment_4)
{ after(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionAssignment_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__LetVariableCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group_2__0__Impl
	rule__LetVariableCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0()); }

	':'

{ after(grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__LetVariableCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__LetVariableCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedTypeAssignment_2_1()); }
(rule__LetVariableCS__OwnedTypeAssignment_2_1)
{ after(grammarAccess.getLetVariableCSAccess().getOwnedTypeAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__NestedExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedExpCS__Group__0__Impl
	rule__NestedExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0()); }

	'('

{ after(grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NestedExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedExpCS__Group__1__Impl
	rule__NestedExpCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getOwnedExpressionAssignment_1()); }
(rule__NestedExpCS__OwnedExpressionAssignment_1)
{ after(grammarAccess.getNestedExpCSAccess().getOwnedExpressionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__NestedExpCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__NestedExpCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2()); }

	')'

{ after(grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__SelfExpCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelfExpCS__Group__0__Impl
	rule__SelfExpCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SelfExpCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0()); }
(

)
{ after(grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SelfExpCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SelfExpCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SelfExpCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSelfExpCSAccess().getSelfKeyword_1()); }

	'self'

{ after(grammarAccess.getSelfExpCSAccess().getSelfKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MultiplicityBoundsCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group__0__Impl
	rule__MultiplicityBoundsCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); }
(rule__MultiplicityBoundsCS__LowerBoundAssignment_0)
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityBoundsCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); }
(rule__MultiplicityBoundsCS__Group_1__0)?
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MultiplicityBoundsCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group_1__0__Impl
	rule__MultiplicityBoundsCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); }

	'..'

{ after(grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityBoundsCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityBoundsCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); }
(rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1)
{ after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__MultiplicityCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__0__Impl
	rule__MultiplicityCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0()); }

	'['

{ after(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__1__Impl
	rule__MultiplicityCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getAlternatives_1()); }
(rule__MultiplicityCS__Alternatives_1)
{ after(grammarAccess.getMultiplicityCSAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__2__Impl
	rule__MultiplicityCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getAlternatives_2()); }
(rule__MultiplicityCS__Alternatives_2)?
{ after(grammarAccess.getMultiplicityCSAccess().getAlternatives_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__MultiplicityCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__MultiplicityCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3()); }

	']'

{ after(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__PathNameCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group__0__Impl
	rule__PathNameCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
(rule__PathNameCS__OwnedPathElementsAssignment_0)
{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PathNameCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getGroup_1()); }
(rule__PathNameCS__Group_1__0)*
{ after(grammarAccess.getPathNameCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__PathNameCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group_1__0__Impl
	rule__PathNameCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); }

	'::'

{ after(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__PathNameCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__PathNameCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
(rule__PathNameCS__OwnedPathElementsAssignment_1_1)
{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TemplateBindingCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group__0__Impl
	rule__TemplateBindingCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); }
(rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0)
{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateBindingCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group__1__Impl
	rule__TemplateBindingCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); }
(rule__TemplateBindingCS__Group_1__0)*
{ after(grammarAccess.getTemplateBindingCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateBindingCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2()); }
(rule__TemplateBindingCS__OwnedMultiplicityAssignment_2)?
{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TemplateBindingCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group_1__0__Impl
	rule__TemplateBindingCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); }

	','

{ after(grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateBindingCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateBindingCS__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); }
(rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1)
{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TemplateSignatureCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__0__Impl
	rule__TemplateSignatureCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0()); }

	'('

{ after(grammarAccess.getTemplateSignatureCSAccess().getLeftParenthesisKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__1__Impl
	rule__TemplateSignatureCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__2__Impl
	rule__TemplateSignatureCS__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getGroup_2()); }
(rule__TemplateSignatureCS__Group_2__0)*
{ after(grammarAccess.getTemplateSignatureCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3()); }

	')'

{ after(grammarAccess.getTemplateSignatureCSAccess().getRightParenthesisKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TemplateSignatureCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_2__0__Impl
	rule__TemplateSignatureCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0()); }

	','

{ after(grammarAccess.getTemplateSignatureCSAccess().getCommaKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TemplateSignatureCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TemplateSignatureCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_2_1()); }
(rule__TemplateSignatureCS__OwnedParametersAssignment_2_1)
{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeParameterCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group__0__Impl
	rule__TypeParameterCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); }
(rule__TypeParameterCS__NameAssignment_0)
{ after(grammarAccess.getTypeParameterCSAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getGroup_1()); }
(rule__TypeParameterCS__Group_1__0)?
{ after(grammarAccess.getTypeParameterCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypeParameterCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1__0__Impl
	rule__TypeParameterCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); }

	'extends'

{ after(grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1__1__Impl
	rule__TypeParameterCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); }
(rule__TypeParameterCS__OwnedExtendsAssignment_1_1)
{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); }
(rule__TypeParameterCS__Group_1_2__0)*
{ after(grammarAccess.getTypeParameterCSAccess().getGroup_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__TypeParameterCS__Group_1_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1_2__0__Impl
	rule__TypeParameterCS__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); }

	'&&'

{ after(grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeParameterCS__Group_1_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeParameterCS__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__Group_1_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); }
(rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1)
{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsAssignment_1_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypedTypeRefCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group__0__Impl
	rule__TypedTypeRefCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0()); }
(rule__TypedTypeRefCS__OwnedPathNameAssignment_0)
{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getGroup_1()); }
(rule__TypedTypeRefCS__Group_1__0)?
{ after(grammarAccess.getTypedTypeRefCSAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__TypedTypeRefCS__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1__0__Impl
	rule__TypedTypeRefCS__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0()); }

	'('

{ after(grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1__1__Impl
	rule__TypedTypeRefCS__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1()); }
(rule__TypedTypeRefCS__OwnedBindingAssignment_1_1)
{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingAssignment_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypedTypeRefCS__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypedTypeRefCS__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2()); }

	')'

{ after(grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__WildcardTypeRefCS__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group__0__Impl
	rule__WildcardTypeRefCS__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); }
(

)
{ after(grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WildcardTypeRefCS__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group__1__Impl
	rule__WildcardTypeRefCS__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); }

	'?'

{ after(grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WildcardTypeRefCS__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); }
(rule__WildcardTypeRefCS__Group_2__0)?
{ after(grammarAccess.getWildcardTypeRefCSAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__WildcardTypeRefCS__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group_2__0__Impl
	rule__WildcardTypeRefCS__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); }

	'extends'

{ after(grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__WildcardTypeRefCS__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__WildcardTypeRefCS__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); }
(rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1)
{ after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__TopLevelCS__OwnedImportsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedImportsImportCSParserRuleCall_0_0()); }
	ruleImportCS{ after(grammarAccess.getTopLevelCSAccess().getOwnedImportsImportCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__OwnedPackagesAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0()); }
	ruleQualifiedPackageCS{ after(grammarAccess.getTopLevelCSAccess().getOwnedPackagesQualifiedPackageCSParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__OwnedTransformationsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsTransformationCSParserRuleCall_1_1_0()); }
	ruleTransformationCS{ after(grammarAccess.getTopLevelCSAccess().getOwnedTransformationsTransformationCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__OwnedMappingsAssignment_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedMappingsMappingCSParserRuleCall_1_2_0()); }
	ruleMappingCS{ after(grammarAccess.getTopLevelCSAccess().getOwnedMappingsMappingCSParserRuleCall_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TopLevelCS__OwnedQueriesAssignment_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTopLevelCSAccess().getOwnedQueriesQueryCSParserRuleCall_1_3_0()); }
	ruleQueryCS{ after(grammarAccess.getTopLevelCSAccess().getOwnedQueriesQueryCSParserRuleCall_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); }
	ruleUnrealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedRealizedVariablesAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); }
	ruleRealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_0_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); }
	ruleUnrealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_0_2_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedRealizedVariablesAssignment_0_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); }
	ruleRealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_0_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedConstraintsAssignment_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0()); }
	rulePredicateOrAssignmentCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0()); }
	ruleUnrealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedRealizedVariablesAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0()); }
	ruleRealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedUnrealizedVariablesAssignment_1_2_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0()); }
	ruleUnrealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedUnrealizedVariablesUnrealizedVariableCSParserRuleCall_1_2_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedRealizedVariablesAssignment_1_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0()); }
	ruleRealizedVariableCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedRealizedVariablesRealizedVariableCSParserRuleCall_1_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BottomPatternCS__OwnedConstraintsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0()); }
	rulePredicateOrAssignmentCS{ after(grammarAccess.getBottomPatternCSAccess().getOwnedConstraintsPredicateOrAssignmentCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getDirectionCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__ImportsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_3_0()); }
(
{ before(grammarAccess.getDirectionCSAccess().getImportsPackageUnrestrictedNameParserRuleCall_3_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getDirectionCSAccess().getImportsPackageUnrestrictedNameParserRuleCall_3_0_1()); }
)
{ after(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__ImportsAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_4_1_0()); }
(
{ before(grammarAccess.getDirectionCSAccess().getImportsPackageUnrestrictedNameParserRuleCall_4_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getDirectionCSAccess().getImportsPackageUnrestrictedNameParserRuleCall_4_1_0_1()); }
)
{ after(grammarAccess.getDirectionCSAccess().getImportsPackageCrossReference_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__UsesAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_5_1_0()); }
(
{ before(grammarAccess.getDirectionCSAccess().getUsesCoreDomainUnrestrictedNameParserRuleCall_5_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getDirectionCSAccess().getUsesCoreDomainUnrestrictedNameParserRuleCall_5_1_0_1()); }
)
{ after(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DirectionCS__UsesAssignment_5_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_5_2_1_0()); }
(
{ before(grammarAccess.getDirectionCSAccess().getUsesCoreDomainUnrestrictedNameParserRuleCall_5_2_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getDirectionCSAccess().getUsesCoreDomainUnrestrictedNameParserRuleCall_5_2_1_0_1()); }
)
{ after(grammarAccess.getDirectionCSAccess().getUsesCoreDomainCrossReference_5_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0()); }
	ruleGuardVariableCS{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0()); }
	ruleGuardVariableCS{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_0_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__OwnedPredicatesAssignment_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_0_4_0()); }
	rulePredicateCS{ after(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0()); }
	ruleGuardVariableCS{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__OwnedUnrealizedVariablesAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0()); }
	ruleGuardVariableCS{ after(grammarAccess.getGuardPatternCSAccess().getOwnedUnrealizedVariablesGuardVariableCSParserRuleCall_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardPatternCS__OwnedPredicatesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_2_1_0()); }
	rulePredicateCS{ after(grammarAccess.getGuardPatternCSAccess().getOwnedPredicatesPredicateCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardVariableCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getGuardVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__GuardVariableCS__OwnedTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGuardVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
	ruleTypeExpCS{ after(grammarAccess.getGuardVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__NameAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); }
	ruleIdentifier{ after(grammarAccess.getImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__OwnedPathNameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0()); }
	ruleURIPathNameCS{ after(grammarAccess.getImportCSAccess().getOwnedPathNameURIPathNameCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ImportCS__IsAllAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getImportCSAccess().getIsAllColonColonKeyword_3_0_0()); }
(
{ before(grammarAccess.getImportCSAccess().getIsAllColonColonKeyword_3_0_0()); }

	'::'

{ after(grammarAccess.getImportCSAccess().getIsAllColonColonKeyword_3_0_0()); }
)

{ after(grammarAccess.getImportCSAccess().getIsAllColonColonKeyword_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__IsDefaultAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getIsDefaultDefaultKeyword_1_0()); }
(
{ before(grammarAccess.getMappingCSAccess().getIsDefaultDefaultKeyword_1_0()); }

	'default'

{ after(grammarAccess.getMappingCSAccess().getIsDefaultDefaultKeyword_1_0()); }
)

{ after(grammarAccess.getMappingCSAccess().getIsDefaultDefaultKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__NameAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getMappingCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__OwnedInPathNameAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedInPathNamePathNameCSParserRuleCall_4_1_0()); }
	rulePathNameCS{ after(grammarAccess.getMappingCSAccess().getOwnedInPathNamePathNameCSParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__RefinesAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_5_1_0()); }
(
{ before(grammarAccess.getMappingCSAccess().getRefinesMappingUnrestrictedNameParserRuleCall_5_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getMappingCSAccess().getRefinesMappingUnrestrictedNameParserRuleCall_5_1_0_1()); }
)
{ after(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__RefinesAssignment_5_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_5_2_1_0()); }
(
{ before(grammarAccess.getMappingCSAccess().getRefinesMappingUnrestrictedNameParserRuleCall_5_2_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getMappingCSAccess().getRefinesMappingUnrestrictedNameParserRuleCall_5_2_1_0_1()); }
)
{ after(grammarAccess.getMappingCSAccess().getRefinesMappingCrossReference_5_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__OwnedDomainsAssignment_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedDomainsNamedDomainCSParserRuleCall_7_0()); }
	ruleNamedDomainCS{ after(grammarAccess.getMappingCSAccess().getOwnedDomainsNamedDomainCSParserRuleCall_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__OwnedMiddleAssignment_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0()); }
	ruleUnnamedDomainCS{ after(grammarAccess.getMappingCSAccess().getOwnedMiddleUnnamedDomainCSParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MappingCS__OwnedComposedMappingsAssignment_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMappingCSAccess().getOwnedComposedMappingsMappingCSParserRuleCall_9_0()); }
	ruleMappingCS{ after(grammarAccess.getMappingCSAccess().getOwnedComposedMappingsMappingCSParserRuleCall_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__IsCheckAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getIsCheckCheckKeyword_0_0()); }
(
{ before(grammarAccess.getNamedDomainCSAccess().getIsCheckCheckKeyword_0_0()); }

	'check'

{ after(grammarAccess.getNamedDomainCSAccess().getIsCheckCheckKeyword_0_0()); }
)

{ after(grammarAccess.getNamedDomainCSAccess().getIsCheckCheckKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__IsEnforceAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getIsEnforceEnforceKeyword_1_0()); }
(
{ before(grammarAccess.getNamedDomainCSAccess().getIsEnforceEnforceKeyword_1_0()); }

	'enforce'

{ after(grammarAccess.getNamedDomainCSAccess().getIsEnforceEnforceKeyword_1_0()); }
)

{ after(grammarAccess.getNamedDomainCSAccess().getIsEnforceEnforceKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__DirectionAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getDirectionTypedModelCrossReference_2_0()); }
(
{ before(grammarAccess.getNamedDomainCSAccess().getDirectionTypedModelUnrestrictedNameParserRuleCall_2_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getNamedDomainCSAccess().getDirectionTypedModelUnrestrictedNameParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getNamedDomainCSAccess().getDirectionTypedModelCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__OwnedGuardPatternAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getOwnedGuardPatternGuardPatternCSParserRuleCall_3_0()); }
	ruleGuardPatternCS{ after(grammarAccess.getNamedDomainCSAccess().getOwnedGuardPatternGuardPatternCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NamedDomainCS__OwnedBottomPatternAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNamedDomainCSAccess().getOwnedBottomPatternBottomPatternCSParserRuleCall_4_0()); }
	ruleBottomPatternCS{ after(grammarAccess.getNamedDomainCSAccess().getOwnedBottomPatternBottomPatternCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__OwnedPathNameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); }
	ruleScopeNameCS{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getQualifiedPackageCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__NsPrefixAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getNsPrefixUnrestrictedNameParserRuleCall_3_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getQualifiedPackageCSAccess().getNsPrefixUnrestrictedNameParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__NsURIAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getNsURIURIParserRuleCall_4_1_0()); }
	ruleURI{ after(grammarAccess.getQualifiedPackageCSAccess().getNsURIURIParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__OwnedPackagesAssignment_5_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedPackagesQualifiedPackageCSParserRuleCall_5_0_1_0_0()); }
	ruleQualifiedPackageCS{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedPackagesQualifiedPackageCSParserRuleCall_5_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedPackageCS__OwnedClassesAssignment_5_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesAlternatives_5_0_1_1_0()); }
(rule__QualifiedPackageCS__OwnedClassesAlternatives_5_0_1_1_0)
{ after(grammarAccess.getQualifiedPackageCSAccess().getOwnedClassesAlternatives_5_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParamDeclarationCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getParamDeclarationCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParamDeclarationCS__OwnedTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
	ruleTypeExpCS{ after(grammarAccess.getParamDeclarationCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateCS__OwnedConditionAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateCSAccess().getOwnedConditionExpCSParserRuleCall_0_0()); }
	ruleExpCS{ after(grammarAccess.getPredicateCSAccess().getOwnedConditionExpCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__IsDefaultAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultDefaultKeyword_0_0()); }
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultDefaultKeyword_0_0()); }

	'default'

{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultDefaultKeyword_0_0()); }
)

{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getIsDefaultDefaultKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__OwnedTargetAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedTargetExpCSParserRuleCall_1_0()); }
	ruleExpCS{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedTargetExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__IsPartialAssignment_2_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getIsPartialPlusSignEqualsSignKeyword_2_0_1_0()); }
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getIsPartialPlusSignEqualsSignKeyword_2_0_1_0()); }

	'+='

{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getIsPartialPlusSignEqualsSignKeyword_2_0_1_0()); }
)

{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getIsPartialPlusSignEqualsSignKeyword_2_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PredicateOrAssignmentCS__OwnedInitExpressionAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getPredicateOrAssignmentCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__IsTransientAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getIsTransientTransientKeyword_0_0()); }
(
{ before(grammarAccess.getQueryCSAccess().getIsTransientTransientKeyword_0_0()); }

	'transient'

{ after(grammarAccess.getQueryCSAccess().getIsTransientTransientKeyword_0_0()); }
)

{ after(grammarAccess.getQueryCSAccess().getIsTransientTransientKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__OwnedPathNameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_2_0()); }
	ruleScopeNameCS{ after(grammarAccess.getQueryCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__NameAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getQueryCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__OwnedParametersAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_5_0_0()); }
	ruleParamDeclarationCS{ after(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__OwnedParametersAssignment_5_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_5_1_1_0()); }
	ruleParamDeclarationCS{ after(grammarAccess.getQueryCSAccess().getOwnedParametersParamDeclarationCSParserRuleCall_5_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__OwnedTypeAssignment_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_8_0()); }
	ruleTypeExpCS{ after(grammarAccess.getQueryCSAccess().getOwnedTypeTypeExpCSParserRuleCall_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QueryCS__OwnedExpressionAssignment_9_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQueryCSAccess().getOwnedExpressionExpCSParserRuleCall_9_1_1_0()); }
	ruleExpCS{ after(grammarAccess.getQueryCSAccess().getOwnedExpressionExpCSParserRuleCall_9_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ScopeNameCS__OwnedPathElementsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); }
	ruleFirstPathElementCS{ after(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ScopeNameCS__OwnedPathElementsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0()); }
	ruleNextPathElementCS{ after(grammarAccess.getScopeNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__OwnedPathNameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); }
	ruleScopeNameCS{ after(grammarAccess.getTransformationCSAccess().getOwnedPathNameScopeNameCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); }
	ruleUnreservedName{ after(grammarAccess.getTransformationCSAccess().getNameUnreservedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TransformationCS__OwnedDirectionsAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTransformationCSAccess().getOwnedDirectionsDirectionCSParserRuleCall_4_0_0()); }
	ruleDirectionCS{ after(grammarAccess.getTransformationCSAccess().getOwnedDirectionsDirectionCSParserRuleCall_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getUnrealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getUnrealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnrealizedVariableCS__OwnedInitExpressionAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnrealizedVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getUnrealizedVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RealizedVariableCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getRealizedVariableCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RealizedVariableCS__OwnedTypeAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); }
	ruleTypeExpCS{ after(grammarAccess.getRealizedVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnnamedDomainCS__OwnedGuardPatternAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnnamedDomainCSAccess().getOwnedGuardPatternGuardPatternCSParserRuleCall_1_0()); }
	ruleGuardPatternCS{ after(grammarAccess.getUnnamedDomainCSAccess().getOwnedGuardPatternGuardPatternCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnnamedDomainCS__OwnedBottomPatternAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnnamedDomainCSAccess().getOwnedBottomPatternBottomPatternCSParserRuleCall_2_0()); }
	ruleBottomPatternCS{ after(grammarAccess.getUnnamedDomainCSAccess().getOwnedBottomPatternBottomPatternCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }

	'static'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }

	'definition'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }

	'definition'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }

	'static'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getAttributeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__OwnedTypeAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getAttributeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__DefaultAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getAttributeCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }

	'derived'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }

	'!derived'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersDerivedKeyword_5_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }

	'id'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }

	'!id'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersIdKeyword_5_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }

	'ordered'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }

	'!ordered'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersOrderedKeyword_5_1_0_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }

	'readonly'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }

	'!readonly'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersReadonlyKeyword_5_1_0_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }

	'transient'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }

	'!transient'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersTransientKeyword_5_1_0_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }

	'unique'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_11
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }

	'!unique'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUniqueKeyword_5_1_0_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_12
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }

	'unsettable'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_13
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }

	'!unsettable'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersUnsettableKeyword_5_1_0_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_14
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }

	'volatile'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_14_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__QualifiersAssignment_5_1_0_15
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }
(
{ before(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }

	'!volatile'

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }
)

{ after(grammarAccess.getAttributeCSAccess().getQualifiersVolatileKeyword_5_1_0_15_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__AttributeCS__OwnedDefaultExpressionsAssignment_6_0_1_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getAttributeCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_6_0_1_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__IsPrimitiveAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }
(
{ before(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }

	'primitive'

{ after(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }
)

{ after(grammarAccess.getDataTypeCSAccess().getIsPrimitivePrimitiveKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getDataTypeCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__OwnedSignatureAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getDataTypeCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__InstanceClassNameAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getDataTypeCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DataTypeCS__IsSerializableAssignment_5_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }
(
{ before(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }

	'serializable'

{ after(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }
)

{ after(grammarAccess.getDataTypeCSAccess().getIsSerializableSerializableKeyword_5_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getEnumerationCSAccess().getNameUnrestrictedNameParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__OwnedSignatureAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getEnumerationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__InstanceClassNameAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getEnumerationCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__IsSerializableAssignment_4_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }
(
{ before(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }

	'serializable'

{ after(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }
)

{ after(grammarAccess.getEnumerationCSAccess().getIsSerializableSerializableKeyword_4_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationCS__OwnedLiteralsAssignment_5_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0()); }
	ruleEnumerationLiteralCS{ after(grammarAccess.getEnumerationCSAccess().getOwnedLiteralsEnumerationLiteralCSParserRuleCall_5_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__NameAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_1_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__NameAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getNameEnumerationLiteralNameParserRuleCall_0_1_0()); }
	ruleEnumerationLiteralName{ after(grammarAccess.getEnumerationLiteralCSAccess().getNameEnumerationLiteralNameParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EnumerationLiteralCS__ValueAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEnumerationLiteralCSAccess().getValueSIGNEDParserRuleCall_1_1_0()); }
	ruleSIGNED{ after(grammarAccess.getEnumerationLiteralCSAccess().getValueSIGNEDParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }

	'static'

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }

	'definition'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }

	'definition'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }

	'static'

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedSignatureAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getOperationCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__NameAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getOperationCSAccess().getNameUnrestrictedNameParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedParametersAssignment_5_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0()); }
	ruleParameterCS{ after(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedParametersAssignment_5_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0()); }
	ruleParameterCS{ after(grammarAccess.getOperationCSAccess().getOwnedParametersParameterCSParserRuleCall_5_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedTypeAssignment_7_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getOperationCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_7_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedExceptionsAssignment_8_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedExceptionsAssignment_8_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getOperationCSAccess().getOwnedExceptionsTypedRefCSParserRuleCall_8_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }

	'derived'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }

	'!derived'

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersDerivedKeyword_9_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }

	'ordered'

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }

	'!ordered'

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersOrderedKeyword_9_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_4_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_4_0()); }

	'unique'

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_4_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__QualifiersAssignment_9_1_0_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_5_0()); }
(
{ before(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_5_0()); }

	'!unique'

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_5_0()); }
)

{ after(grammarAccess.getOperationCSAccess().getQualifiersUniqueKeyword_9_1_0_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCS__OwnedBodyExpressionsAssignment_10_0_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getOperationCSAccess().getOwnedBodyExpressionsSpecificationCSParserRuleCall_10_0_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }

	'ordered'

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }

	'!ordered'

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersOrderedKeyword_2_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }

	'unique'

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterCS__QualifiersAssignment_2_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }
(
{ before(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }

	'!unique'

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }
)

{ after(grammarAccess.getParameterCSAccess().getQualifiersUniqueKeyword_2_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }

	'static'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }

	'definition'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }

	'definition'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDefinitionKeyword_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }

	'static'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersStaticKeyword_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getReferenceCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__ReferredOppositeAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyCrossReference_3_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyUnrestrictedNameParserRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getReferenceCSAccess().getReferredOppositePropertyCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedTypeAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0()); }
	ruleTypedMultiplicityRefCS{ after(grammarAccess.getReferenceCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__DefaultAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getReferenceCSAccess().getDefaultSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }

	'composes'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }

	'!composes'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersComposesKeyword_6_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }

	'derived'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }

	'!derived'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersDerivedKeyword_6_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }

	'ordered'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_5
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }

	'!ordered'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersOrderedKeyword_6_1_0_5_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }

	'readonly'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_7
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }

	'!readonly'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersReadonlyKeyword_6_1_0_7_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_8
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }

	'resolve'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_8_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_9
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }

	'!resolve'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersResolveKeyword_6_1_0_9_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_10
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }

	'transient'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_10_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_11
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }

	'!transient'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersTransientKeyword_6_1_0_11_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_12
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }

	'unique'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_12_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_13
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }

	'!unique'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUniqueKeyword_6_1_0_13_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_14
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }

	'unsettable'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_14_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_15
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }

	'!unsettable'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersUnsettableKeyword_6_1_0_15_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_16
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }

	'volatile'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_16_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__QualifiersAssignment_6_1_0_17
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }
(
{ before(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }

	'!volatile'

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }
)

{ after(grammarAccess.getReferenceCSAccess().getQualifiersVolatileKeyword_6_1_0_17_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_0_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_0_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceCS__OwnedDefaultExpressionsAssignment_7_0_1_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0()); }
	ruleSpecificationCS{ after(grammarAccess.getReferenceCSAccess().getOwnedDefaultExpressionsSpecificationCSParserRuleCall_7_0_1_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificationCS__OwnedExpressionAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0()); }
	ruleExpCS{ after(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SpecificationCS__ExprStringAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0()); }
	RULE_UNQUOTED_STRING{ after(grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__IsAbstractAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }

	'abstract'

{ after(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
)

{ after(grammarAccess.getStructuredClassCSAccess().getIsAbstractAbstractKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getStructuredClassCSAccess().getNameUnrestrictedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedSignatureAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
	ruleTemplateSignatureCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSignatureTemplateSignatureCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedSuperTypesAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedSuperTypesAssignment_4_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedSuperTypesTypedRefCSParserRuleCall_4_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__InstanceClassNameAssignment_5_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
	RULE_SINGLE_QUOTED_STRING{ after(grammarAccess.getStructuredClassCSAccess().getInstanceClassNameSINGLE_QUOTED_STRINGTerminalRuleCall_5_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__IsInterfaceAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }
(
{ before(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }

	'interface'

{ after(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }
)

{ after(grammarAccess.getStructuredClassCSAccess().getIsInterfaceInterfaceKeyword_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedOperationsAssignment_7_0_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0()); }
	ruleOperationCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedOperationsOperationCSParserRuleCall_7_0_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StructuredClassCS__OwnedPropertiesAssignment_7_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0()); }
	ruleStructuralFeatureCS{ after(grammarAccess.getStructuredClassCSAccess().getOwnedPropertiesStructuralFeatureCSParserRuleCall_7_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedMultiplicityRefCS__OwnedMultiplicityAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTypedMultiplicityRefCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__URIPathNameCS__OwnedPathElementsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0()); }
	ruleURIFirstPathElementCS{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsURIFirstPathElementCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIPathNameCS__OwnedPathElementsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
	ruleNextPathElementCS{ after(grammarAccess.getURIPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__ReferredElementAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); }
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1()); }
)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__URIFirstPathElementCS__ReferredElementAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); }
(
{ before(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceURIParserRuleCall_1_1_0_1()); }
	ruleURI{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceURIParserRuleCall_1_1_0_1()); }
)
{ after(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrimitiveTypeCS__NameAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); }
	rulePrimitiveTypeIdentifier{ after(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); }
	ruleCollectionTypeIdentifier{ after(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionTypeCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }
(
{ before(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }

	'Map'

{ after(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }
)

{ after(grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__OwnedKeyTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapTypeCS__OwnedValueTypeAssignment_1_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); }
	ruleTypeExpCS{ after(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }
(
{ before(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }

	'Tuple'

{ after(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }
)

{ after(grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__OwnedPartsAssignment_1_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); }
	ruleTuplePartCS{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleTypeCS__OwnedPartsAssignment_1_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); }
	ruleTuplePartCS{ after(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TuplePartCS__OwnedTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
	ruleTypeExpCS{ after(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__OwnedTypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
	ruleCollectionTypeCS{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); }
	ruleCollectionLiteralPartCS{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralExpCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); }
	ruleCollectionLiteralPartCS{ after(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__OwnedExpressionAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); }
	ruleExpCS{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__OwnedLastExpressionAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); }
	ruleExpCS{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionLiteralPartCS__OwnedExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); }
	rulePatternExpCS{ after(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__OwnedTypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
	ruleCollectionTypeCS{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); }
	rulePatternExpCS{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); }
	rulePatternExpCS{ after(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollectionPatternCS__RestVariableNameAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); }
	ruleIdentifier{ after(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__ReferredPropertyAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0()); }
(
{ before(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyUnrestrictedNameParserRuleCall_0_0_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyUnrestrictedNameParserRuleCall_0_0_0_1()); }
)
{ after(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__OwnedInitExpressionAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAlternatives_0_2_0()); }
(rule__ShadowPartCS__OwnedInitExpressionAlternatives_0_2_0)
{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionAlternatives_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ShadowPartCS__OwnedInitExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0()); }
	ruleStringLiteralExpCS{ after(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionStringLiteralExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__PatternVariableNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PatternExpCS__OwnedPatternTypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); }
	ruleTypeExpCS{ after(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LambdaLiteralExpCS__OwnedExpressionCSAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); }
	ruleExpCS{ after(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__OwnedTypeAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); }
	ruleMapTypeCS{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); }
	ruleMapLiteralPartCS{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralExpCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); }
	ruleMapLiteralPartCS{ after(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__OwnedKeyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); }
	ruleExpCS{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MapLiteralPartCS__OwnedValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); }
	ruleExpCS{ after(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__OwnedPartsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); }
	ruleTupleLiteralPartCS{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralExpCS__OwnedPartsAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); }
	ruleTupleLiteralPartCS{ after(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TupleLiteralPartCS__OwnedInitExpressionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); }
	ruleExpCS{ after(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NumberLiteralExpCS__SymbolAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); }
	ruleNUMBER_LITERAL{ after(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__StringLiteralExpCS__SegmentsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); }
	ruleStringLiteral{ after(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteralExpCS__SymbolAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }

	'true'

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }
)

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteralExpCS__SymbolAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }
(
{ before(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }

	'false'

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }
)

{ after(grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralWithMultiplicityCS__OwnedMultiplicityAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeLiteralExpCS__OwnedTypeAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); }
	ruleTypeLiteralWithMultiplicityCS{ after(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__OwnedPathNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
	rulePathNameCS{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__OwnedCurlyBracketedClauseAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); }
	ruleCurlyBracketedClauseCS{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeNameExpCS__OwnedPatternGuardAssignment_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); }
	ruleExpCS{ after(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeExpCS__OwnedMultiplicityAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__NameAssignment_0_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); }
	ruleBinaryOperatorName{ after(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ExpCS__OwnedRightAssignment_0_1_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); }
	ruleExpCS{ after(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__NameAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
	ruleUnaryOperatorName{ after(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedLetExpCS__OwnedRightAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); }
	rulePrefixedLetExpCS{ after(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__NameAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
	ruleUnaryOperatorName{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PrefixedPrimaryExpCS__OwnedRightAssignment_0_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); }
	rulePrefixedPrimaryExpCS{ after(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedPathNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
	rulePathNameCS{ after(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedSquareBracketedClausesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); }
	ruleSquareBracketedClauseCS{ after(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedRoundBracketedClauseAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); }
	ruleRoundBracketedClauseCS{ after(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__OwnedCurlyBracketedClauseAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); }
	ruleCurlyBracketedClauseCS{ after(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NameExpCS__IsPreAssignment_4_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }
(
{ before(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }

	'@'

{ after(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }
)

{ after(grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0()); }
	ruleShadowPartCS{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CurlyBracketedClauseCS__OwnedPartsAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0()); }
	ruleShadowPartCS{ after(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); }
	ruleNavigatingArgCS{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); }
	ruleNavigatingCommaArgCS{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); }
	ruleNavigatingSemiArgCS{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); }
	ruleNavigatingCommaArgCS{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); }
	ruleNavigatingBarArgCS{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RoundBracketedClauseCS__OwnedArgumentsAssignment_2_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); }
	ruleNavigatingCommaArgCS{ after(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__OwnedTermsAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); }
	ruleExpCS{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SquareBracketedClauseCS__OwnedTermsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedNameExpressionAssignment_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedTypeAssignment_0_1_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedInitExpressionAssignment_0_1_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingArgCS__OwnedTypeAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__PrefixAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }

	'|'

{ after(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }
)

{ after(grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__OwnedNameExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__OwnedTypeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingBarArgCS__OwnedInitExpressionAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__PrefixAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }

	','

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }
)

{ after(grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedNameExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedTypeAssignment_2_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_0_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingCommaArgCS__OwnedInitExpressionAssignment_2_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__PrefixAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }

	';'

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }
)

{ after(grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__OwnedNameExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
	ruleNavigatingArgExpCS{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__OwnedTypeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NavigatingSemiArgCS__OwnedInitExpressionAssignment_2_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
	ruleExpCS{ after(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedConditionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedConditionAlternatives_1_0()); }
(rule__IfExpCS__OwnedConditionAlternatives_1_0)
{ after(grammarAccess.getIfExpCSAccess().getOwnedConditionAlternatives_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedThenExpressionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
	ruleExpCS{ after(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedIfThenExpressionsAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); }
	ruleElseIfThenExpCS{ after(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IfExpCS__OwnedElseExpressionAssignment_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); }
	ruleExpCS{ after(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__OwnedConditionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); }
	ruleExpCS{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__ElseIfThenExpCS__OwnedThenExpressionAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
	ruleExpCS{ after(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__OwnedVariablesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); }
	ruleLetVariableCS{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__OwnedVariablesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); }
	ruleLetVariableCS{ after(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetExpCS__OwnedInExpressionAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); }
	ruleExpCS{ after(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__OwnedRoundBracketedClauseAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); }
	ruleRoundBracketedClauseCS{ after(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__OwnedTypeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
	ruleTypeExpCS{ after(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__LetVariableCS__OwnedInitExpressionAssignment_4
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); }
	ruleExpCS{ after(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NestedExpCS__OwnedExpressionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); }
	ruleExpCS{ after(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__LowerBoundAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); }
	ruleLOWER{ after(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityBoundsCS__UpperBoundAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); }
	ruleUPPER{ after(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityCS__IsNullFreeAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }
(
{ before(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }

	'|1'

{ after(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }
)

{ after(grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__MultiplicityStringCS__StringBoundsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); }
(rule__MultiplicityStringCS__StringBoundsAlternatives_0)
{ after(grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__OwnedPathElementsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); }
	ruleFirstPathElementCS{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__PathNameCS__OwnedPathElementsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
	ruleNextPathElementCS{ after(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__FirstPathElementCS__ReferredElementAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
(
{ before(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); }
	ruleUnrestrictedName{ after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1()); }
)
{ after(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NextPathElementCS__ReferredElementAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
(
{ before(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); }
	ruleUnreservedName{ after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1()); }
)
{ after(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__OwnedSubstitutionsAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); }
	ruleTemplateParameterSubstitutionCS{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__OwnedSubstitutionsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); }
	ruleTemplateParameterSubstitutionCS{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateBindingCS__OwnedMultiplicityAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); }
	ruleMultiplicityCS{ after(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateParameterSubstitutionCS__OwnedActualParameterAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); }
	ruleTypeRefCS{ after(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__OwnedParametersAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TemplateSignatureCS__OwnedParametersAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0()); }
	ruleTypeParameterCS{ after(grammarAccess.getTemplateSignatureCSAccess().getOwnedParametersTypeParameterCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
	ruleUnrestrictedName{ after(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__OwnedExtendsAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeParameterCS__OwnedExtendsAssignment_1_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__OwnedPathNameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
	rulePathNameCS{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypedTypeRefCS__OwnedBindingAssignment_1_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); }
	ruleTemplateBindingCS{ after(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__WildcardTypeRefCS__OwnedExtendsAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); }
	ruleTypedRefCS{ after(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


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


