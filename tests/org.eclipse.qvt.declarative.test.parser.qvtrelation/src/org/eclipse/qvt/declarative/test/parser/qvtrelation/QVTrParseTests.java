/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.parser.qvtrelation;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.QVTRelation.util.QVTRelationValidator;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;

public class QVTrParseTests extends AbstractQVTrTestCase
{
	public static class ExpectedProblemLog extends ProblemLog
	{
		public void expectValidatorError(String key, String[] substitutions) {
			EValidatorWithOperations validator = QVTRelationValidator.INSTANCE;
			ResourceLocator resourceLocator = validator.getResourceLocator();
			String problemMessage = substitutions == null ? resourceLocator.getString(key) : resourceLocator.getString(key, substitutions);
			String processingContext = validator.getDiagnosticSource();
			super.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR, problemMessage,
					processingContext, -1, -1);
		}
		public void expectValidatorWarning(String key, String[] substitutions) {
			EValidatorWithOperations validator = QVTRelationValidator.INSTANCE;
			ResourceLocator resourceLocator = validator.getResourceLocator();
			String problemMessage = substitutions == null ? resourceLocator.getString(key) : resourceLocator.getString(key, substitutions);
			String processingContext = validator.getDiagnosticSource();
			super.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR, problemMessage,
					processingContext, -1, -1);
		}
	}

	public void testParseEqvtRelation_empty() throws IOException, CoreException, MappingConfigurationException {
		parserTest("empty", null);
	}
	
	public void testParseQvtrelation_empty() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		parserTest("empty", null);
	}
	
	public void testParseEqvtRelation_SeqToStm() throws IOException, CoreException, MappingConfigurationException {
		parserTest("SeqToStm", null);
	}
	
	public void testParseQvtrelation_SeqToStm() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		parserTest("SeqToStm", null);
	}
	
	public void testParseEqvtRelation_expressions() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectUnrecognizedVariable(expectedProblems, "a1");
		expectUnrecognizedVariable(expectedProblems, "q");
		parserTest("expressions", expectedProblems);
	}
	
	public void testParseEqvtRelation_RelToCore() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unable to resolve query 'CopyOclExpession' with matching signature", "QueryCallExpCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"The required feature 'impl' of 'RelToCore.eqvtrelation::relToCore::RExpToMExp::RelationImplementation' must be set",
				EObjectValidator.DIAGNOSTIC_SOURCE, -1, -1);
		parserTest("RelToCore", expectedProblems);
	}
	
	public void testParseEqvtRelation_Scoping() throws IOException, CoreException, MappingConfigurationException {
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (ScopeA::a::abZ)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (ScopeB::b::baZ)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Ambiguous name 'a::A' { ScopeA::a::a::A, ScopeA::b::a::A }", "lookupClassifier", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Ambiguous name 'A' { ScopeA::a::A, ScopeA::b::A }", "lookupClassifier", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Ambiguous name 'a::A' { ScopeA::a::a::A, ScopeA::b::a::A, ScopeB::a::a::A, ScopeB::b::a::A, ScopeC::c::a::A }", "lookupClassifier", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Ambiguous name 'A' { ScopeA::a::A, ScopeA::b::A, ScopeB::a::A, ScopeB::b::A, ScopeC::c::A }", "lookupClassifier", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Ambiguous name 'A' { ScopeA::a::A, ScopeA::b::A }", "lookupClassifier", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Ambiguous name 'A' { ScopeB::a::A, ScopeB::b::A }", "lookupClassifier", -1, -1);
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::A"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::A"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::a::A"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::a::A"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::a::A"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::b::abZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::b::abZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::b::abZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeA::a::b::abZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeB::b::a::baZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeB::b::a::baZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeB::b::a::baZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "ScopeB::b::a::baZ"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "Scoping.qvtr::$unresolved$::$class$"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "Scoping.qvtr::$unresolved$::$class$"} );
		problemTest("Scoping", expectedProblems);
	}
	
	public void testParse_Keys() throws IOException, CoreException {
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "qvtrelation::QVTRelation::Key"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "qvtrelation::QVTRelation::Key"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "emof::EMOF::Class"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "emof::EMOF::Class"} );
		parserTest("Keys", expectedProblems);
	}
	
	public void testValidate_Keys() throws IOException, CoreException {
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_KeyMustHaveAtLeastOnePart_diagnostic",
				new String[] { "KeysValidation.reference.eqvtrelation::Keys::Key" });
		expectedProblems.expectValidatorError("_UI_KeyPartSourceMustBeKeyIdentifies_diagnostic",
				new String[] {
					"EMOF.ecore::EMOF::Tag::element",
					"KeysValidation.reference.eqvtrelation::Keys::Key",
					"EMOF.ecore::EMOF::Property"});
		expectedProblems.expectValidatorError("_UI_KeyOppositePartTargetMustBeKeyIdentifies_diagnostic",
				new String[] {
					"EMOF.ecore::EMOF::Parameter::operation",
					"KeysValidation.reference.eqvtrelation::Keys::Key",
					"EMOF.ecore::EMOF::Parameter"});
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "QVTRelation.ecore::QVTRelation::Key"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "QVTRelation.ecore::QVTRelation::Key"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "EMOF.ecore::EMOF::Class"} );
		expectedProblems.expectValidatorWarning("_UI_DuplicateKeyDefinition_diagnostic",
				new String[] { "EMOF.ecore::EMOF::Class"} );
		validationTest("KeysValidation", expectedProblems);
	}
	
	public void testValidation_RelToCore() throws IOException, CoreException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"The required feature 'impl' of 'RelToCore.reference.eqvtrelation::relToCore::RExpToMExp::RelationImplementation' must be set",
				EObjectValidator.DIAGNOSTIC_SOURCE, -1, -1);
		validationTest("RelToCore", expectedProblems);
	}
}
