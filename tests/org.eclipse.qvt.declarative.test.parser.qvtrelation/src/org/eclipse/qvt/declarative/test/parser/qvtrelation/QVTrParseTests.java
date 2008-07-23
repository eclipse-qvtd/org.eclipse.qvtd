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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;

public class QVTrParseTests extends AbstractQVTrTestCase
{
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
		ProblemLog expectedProblems = new ProblemLog();
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

		problemTest("Scoping", expectedProblems);
	}
	
	public void testValidation_RelToCore() throws IOException, CoreException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"The required feature 'impl' of 'RelToCore.reference.eqvtrelation::relToCore::RExpToMExp::RelationImplementation' must be set",
				EObjectValidator.DIAGNOSTIC_SOURCE, -1, -1);
		validationTest("RelToCore", expectedProblems);
	}
}
