/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTrParseTests.java,v 1.9 2009/03/05 22:02:15 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.parser.qvtrelation;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.QVTRelationMessages;
import org.eclipse.qvt.declarative.ecore.QVTRelation.util.QVTRelationValidator;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;

public class QVTrParseTests extends AbstractQVTrTestCase
{
	public static class ExpectedProblemLog extends ProblemLog
	{
		public void expectValidatorError(String problemMessage, String[] substitutions) {
			expectValidatorError(QVTRelationValidator.INSTANCE, problemMessage, substitutions);
		}
		
		public void expectValidatorWarning(String problemMessage, String[] substitutions) {
			expectValidatorWarning(QVTRelationValidator.INSTANCE, problemMessage, substitutions);
		}
	}

	public void testParseEqvtRelation_empty() throws IOException, CoreException, MappingConfigurationException {
		parserTest("empty", null);
	}
	
	public void testParseQvtrelation_empty() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		parserTest("empty", null);
	}
	
	public void testParseEqvtrelation_hstmtostm() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR,
				"The OCL names for 'Set(stmMM_p::Trans)' and 'Set(hstmMM_p::Trans)' are not distinct",
				QVTRelationValidator.DIAGNOSTIC_SOURCE, -1, -1);
		parserTest("hstmtostm", expectedProblems);
	}
	
	public void testParseEqvtRelation_SeqToStm() throws IOException, CoreException, MappingConfigurationException {
		parserTest("SeqToStm", null);
	}
	
	public void testParseQvtrelation_SeqToStm() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		parserTest("SeqToStm", null);
	}
	
	public void testParseEqvtRelation_UmlToRdbms() throws IOException, CoreException, MappingConfigurationException {
		parserTest("UmlToRdbms", null);
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
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeA::a::A"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeA::a::a::A"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeA::a::a::A"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeA::a::b::abZ"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeA::a::b::abZ"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeA::a::b::abZ"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeB::b::a::baZ"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeB::b::a::baZ"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "ScopeB::b::a::baZ"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "Scoping.qvtr::$unresolved$::$class$"} );
//		expectedProblems.expectValidatorWarning(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
//				new String[] { "Scoping.qvtr::$unresolved$::$class$"} );
		problemTest("Scoping", expectedProblems);
	}
	
	public void testParse_Keys() throws IOException, CoreException {
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "qvtrelation::QVTRelation::Key"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "emof::EMOF::Class"} );
		parserTest("Keys", expectedProblems);
	}
	
	public void testValidate_Keys() throws IOException, CoreException {
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_Key_NoParts,
				new String[] { "KeysValidation.reference.eqvtrelation::Keys::Key" });
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_Key_PartIsNotDeclaredByIdentifies,
				new String[] {
					"EMOF.ecore::EMOF::Tag::element",
					"KeysValidation.reference.eqvtrelation::Keys::Key",
					"EMOF.ecore::EMOF::Property"});
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_Key_OppositePartDoesNotReferenceIdentifies,
				new String[] {
					"EMOF.ecore::EMOF::Parameter::operation",
					"KeysValidation.reference.eqvtrelation::Keys::Key",
					"EMOF.ecore::EMOF::Parameter"});
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "QVTRelation.ecore::QVTRelation::Key"} );
//		expectedProblems.expectValidatorWarning(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
//				new String[] { "QVTRelation.ecore::QVTRelation::Key"} );
		expectedProblems.expectValidatorError(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				new String[] { "EMOF.ecore::EMOF::Class"} );
//		expectedProblems.expectValidatorWarning(QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
//				new String[] { "EMOF.ecore::EMOF::Class"} );
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
