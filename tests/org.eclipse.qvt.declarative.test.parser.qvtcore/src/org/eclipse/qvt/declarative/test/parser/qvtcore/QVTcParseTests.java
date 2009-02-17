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
 * $Id: QVTcParseTests.java,v 1.5 2009/02/17 21:53:28 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.parser.qvtcore;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.QVTBaseMessages;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.ecore.QVTCore.operations.QVTCoreMessages;
import org.eclipse.qvt.declarative.ecore.QVTCore.util.QVTCoreValidator;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;

public class QVTcParseTests extends AbstractQVTcTestCase
{
	public void testParseEqvtCore_empty() throws IOException, CoreException, MappingConfigurationException {
		parserTest("empty", null);
	}
	
	public void testParseQvtcore_empty() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		parserTest("empty", null);
	}
	
	public void testParseEqvtCore_Rule4b() throws IOException, CoreException, MappingConfigurationException {
		parserTest("Rule4b", null);
	}
	
//	public void testParseEqvtCore_TrimmedRule4b() throws IOException, CoreException, MappingConfigurationException {
//		parserTest("TrimmedRule4b", false);
//	}
	
	public void testParseEqvtCore_Rule6() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Undefined variable 'sqltype'", "AssignmentCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Inconsistent 'umlMM.emof::umlMM::PrimitiveDataType' value for 'umlMM.emof::umlMM::Package' property", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		parserTest("Rule6", expectedProblems);
	}
	
	public void testParseEqvtCore_test() throws IOException, CoreException, MappingConfigurationException {
		parserTest("test", null);
	}
	
	public void testParseQvtcore_test() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		parserTest("test", null);
	}
	
	public void testParseEqvtcore_multimaps() throws IOException, CoreException, MappingConfigurationException {
		parserTest("multimaps", null);
	}
	
	public void testParseQvtcore_multimaps() throws IOException, CoreException, MappingConfigurationException {
		asEMOF = true;
		parserTest("multimaps", null);
	}
	
	public void testParseEqvtcore_badmaps() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Undefined mapping 'NoSuchMap'", "RefinesCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Composed mapping 'BadName' must be unnamed", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Non-composed mapping must be named", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectUnrecognizedVariable(expectedProblems, "p");
		expectUnrecognizedVariable(expectedProblems, "v1");
		expectUnrecognizedVariable(expectedProblems, "v2");
		expectUnrecognizedVariable(expectedProblems, "t");

		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Rule_DomainNameIsNotUnique,
				"rdbms", "badmaps.eqvtcore::umlRdbms::Map0b::rdbms", "badmaps.eqvtcore::umlRdbms::Map0b::rdbms");
//		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
//				QVTBaseMessages._UI_Rule_TypedModelIsNotUnique,
//				"badmaps.eqvtcore::umlRdbms::rdbms", "badmaps.eqvtcore::umlRdbms::Map0b::rdbms", "badmaps.eqvtcore::umlRdbms::Map0b::rdbms");
		expectedProblems.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.ANALYZER,
				"Domain name 'middle' should be distinct from middle domain name 'middle'", "DomainCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.ANALYZER,
				"Inappropriate 'in' ignored", "InCS", -1, -1);
		parserTest("badmaps", expectedProblems);
	}
		
	public void testParseEqvtcore_dependencies() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectUnrecognizedVariable(expectedProblems, "nM2mg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2mb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2mg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2mb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2mg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2mb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2mg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2mb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lg2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nM2lb2Mb"); 
		expectUnrecognizedVariable(expectedProblems, "nMalb2Mag"); 
		expectUnrecognizedVariable(expectedProblems, "nMamg2Mal"); 
		expectUnrecognizedVariable(expectedProblems, "nMamb2Mal"); 
		expectUnrecognizedVariable(expectedProblems, "nMamg2Mal"); 
		expectUnrecognizedVariable(expectedProblems, "nMamb2Mal"); 
		expectUnrecognizedVariable(expectedProblems, "nMalg2Mar"); 
		expectUnrecognizedVariable(expectedProblems, "nMalb2Mag"); 
		expectUnrecognizedVariable(expectedProblems, "nMalg2Mar"); 
		expectUnrecognizedVariable(expectedProblems, "nMalb2Marb"); 
		expectUnrecognizedVariable(expectedProblems, "nMalb2Mag"); 
		expectUnrecognizedVariable(expectedProblems, "nMamb2Mamg"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1mg2M1cl"); 
		expectUnrecognizedVariable(expectedProblems, "nM1mb2M1cl"); 
		expectUnrecognizedVariable(expectedProblems, "nM1mg2M1cl"); 
		expectUnrecognizedVariable(expectedProblems, "nM1mb2M1cl"); 
		expectUnrecognizedVariable(expectedProblems, "nMbmg2M2l"); 
		expectUnrecognizedVariable(expectedProblems, "nMblb2M2lg"); 
		expectUnrecognizedVariable(expectedProblems, "nMbmg2M2l"); 
		expectUnrecognizedVariable(expectedProblems, "nMblg2M2r"); 
		expectUnrecognizedVariable(expectedProblems, "nMblb2M2r"); 
		expectUnrecognizedVariable(expectedProblems, "nMblg2M2r"); 
		expectUnrecognizedVariable(expectedProblems, "nMblb2M2r"); 
		expectUnrecognizedVariable(expectedProblems, "nMbmb2M2mg"); 

		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1clb2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmg2M1"); 
		expectUnrecognizedVariable(expectedProblems, "nM1cmb2M1"); 
		parserTest("dependencies", expectedProblems);
	}

	public void testParseQVTCore_expressions() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectUnrecognizedVariable(expectedProblems, "a1"); 
		expectUnrecognizedVariable(expectedProblems, "a4"); 
		expectUnrecognizedVariable(expectedProblems, "q"); 
		parserTest("expressions", expectedProblems);
	}
	
	public void testParseEqvtcore_queries() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Redefinition of 'q0' ignored", "QueryCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Invalid transformation 'B::A': Not a transformation", "QueryCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Scope::name required as query name", "QueryCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Undefined transformation 'tx9'", "QueryCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Undefined transformation 'A::tx9'", "QueryCS", -1, -1);
		parserTest("queries", expectedProblems);
	}
	
	public void testParseQVTCore_redefinition() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorWarning(QVTCoreValidator.INSTANCE,
				QVTCoreMessages._UI_BottomPattern_RealizedVariableNameIsNotUnique,
				"redefinition.eqvtcore::umlRdbms::Map1::uml$guard::p1");
		expectedProblems.expectValidatorWarning(QVTCoreValidator.INSTANCE,
				QVTCoreMessages._UI_CorePattern_VariableNameIsNotUnique,
				"redefinition.eqvtcore::umlRdbms::Map1::<null>::uml$guard::p2");
		expectedProblems.expectValidatorWarning(QVTCoreValidator.INSTANCE,
				QVTCoreMessages._UI_BottomPattern_RealizedVariableNameIsNotUnique,
				"redefinition.eqvtcore::umlRdbms::Map1::<null>::uml$bottom::p3");
		expectedProblems.expectValidatorWarning(QVTCoreValidator.INSTANCE,
				QVTCoreMessages._UI_BottomPattern_RealizedVariableNameIsNotUnique,
				"redefinition.eqvtcore::umlRdbms::Map1::<null>::uml$bottom::p4");
		expectedProblems.expectValidatorWarning(QVTCoreValidator.INSTANCE,
				QVTCoreMessages._UI_CorePattern_VariableNameIsNotUnique,
				"redefinition.eqvtcore::umlRdbms::Map1::uml$guard::p5");
		parserTest("redefinition", expectedProblems);
	}
	
	public void testParseQVTCore_type_check() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Inconsistent 'Type(umlMM.emof::umlMM::Class)' value for 'String' variable", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Inconsistent 'Type(String)' value for 'String' property", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Inconsistent 'Integer' value for 'String' property", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Inconsistent 'umlMM.emof::umlMM::Package' value for 'String' property", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
				"Inconsistent 'umlMM.emof::umlMM::Classifier' value for 'umlMM.emof::umlMM::Class' variable", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		parserTest("type_check", expectedProblems);
	}
	
	public void testParseQVTCore_validator() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR,
				"Variable 'validator.eqvtcore::umlRdbms::ClassToTable::rdbms$bottom::xx' can only be realized within an enforceable domain", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR,
				"Variable 'validator.eqvtcore::umlRdbms::ClassToTable$bottom::v2' can only be realized when some domain is enforceable", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR,
				"Assignment can only be default within an enforceable domain", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR,
				"Assignment can only be default when some domain is enforceable", QVTCoreValidator.DIAGNOSTIC_SOURCE, -1, -1);
		parserTest("validator", expectedProblems);
	}
	
	public void testParseQVTCore_visibility() throws IOException, CoreException, MappingConfigurationException {
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (Class)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (Class)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (Class)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (Schema)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (Schema)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (TPackageToSchema)", "typeCS", -1, -1);
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unknown type (TPackageToSchema)", "typeCS", -1, -1);
		parserTest("visibility", expectedProblems);
	}
	
	public void testValidation_Rule4b() throws IOException, CoreException {
		ProblemLog expectedProblems = new ProblemLog();
//		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR,
//				"The required feature 'impl' of 'RelToCore.eqvtrelation::relToCore::RExpToMExp::RelationImplementation' must be set",
//				EObjectValidator.DIAGNOSTIC_SOURCE, -1, -1);
		validationTest("Rule4b", expectedProblems);
	}
}
