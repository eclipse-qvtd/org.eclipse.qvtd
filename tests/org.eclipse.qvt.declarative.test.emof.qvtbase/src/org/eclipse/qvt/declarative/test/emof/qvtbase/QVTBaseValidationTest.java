/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.qvtbase;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;

public class QVTBaseValidationTest extends AbstractValidationTest
{
	protected Transformation transformation;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		transformation = createTransformation(resource, "TestTransformation");
	}

	public void testDomain_NotBothCheckableAndEnforceable() {
		Rule rule = createConcreteRule(transformation, "TestRule");
		Domain domain = createConcreteDomain(rule, "TestDomain");
		//
		validationTest(null);
		//
		domain.setIsCheckable(true);
		validationTest(null);
		//
		domain.setIsEnforceable(true);
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_NotBothCheckableAndEnforceable",
				new String[] { getQualifiedNameOf(domain) });
		validationTest(expectedProblems);
		//
		domain.setIsCheckable(false);
		validationTest(null);
	}

	public void testDomain_TypedModelDefinedByTransformation() {
		List<EPackage> usedPackages = Collections.<EPackage>singletonList(EcorePackage.eINSTANCE);
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		TypedModel extraTypedModel = createTypedModel(extraTransformation, "TestTypedModel", usedPackages);
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", usedPackages);
		Rule rule = createConcreteRule(transformation, "TestRule");
		Domain domain = createConcreteDomain(rule, "TestDomain");
		domain.setTypedModel(extraTypedModel);
		//
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_TypedModelDefinedByTransformation",
				new String[] { getQualifiedNameOf(extraTypedModel), getQualifiedNameOf(domain), getQualifiedNameOf(transformation) });
		validationTest(expectedProblems);
		//
		transformation.setExtends(extraTransformation);
		validationTest(expectedProblems);
		//
		domain.setTypedModel(typedModel);
		validationTest(null);
	}

	public void testFunction_EveryFunctionParameterIsAFunctionParameter() {
		Function function = createFunction(transformation, "TestFunction");
		EParameter eParameter = createEParameter(function, "TestParameter", getBooleanType());
		//
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_EveryFunctionParameterIsAFunctionParameter",
				new String[] { getQualifiedNameOf(eParameter) });
		validationTest(expectedProblems);
	}

	public void testPattern_NoVariableIsAFunctionParameter() {
		Function function = createFunction(transformation, "TestFunction");
		FunctionParameter functionParameter = createFunctionParameter(function, "TestParameter", getBooleanType());
		Relation relation = createRelation(transformation, "TestRelation");
		Variable variable = createVariable(relation.getVariable(), "TestVariable", getBooleanType());
		Pattern pattern = createPattern(null);
		relation.setWhen(pattern);
		pattern.getBindsTo().add(functionParameter);
		pattern.getBindsTo().add(variable);
		//
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_NoVariableIsAFunctionParameter",
				new String[] { getQualifiedNameOf(functionParameter) });
		validationTest(expectedProblems);
	}
	
	public void testRule_OverridesIsCompatible() {
		// TODO
	}

	public void testPredicate_ConditionExpressionIsBoolean() {
		Relation relation = createRelation(transformation, "TestRelation");
		Pattern pattern = createPattern(null);
		relation.setWhen(pattern);
		Predicate predicate = createPredicate(pattern.getPredicate());
		OCLExpression conditionExpression = createStringLiteralExp("xyzzy");
		predicate.setConditionExpression(conditionExpression);
		//
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_ConditionExpressionIsBoolean",
				new String[] { getQualifiedNameOf(predicate) });
		validationTest(expectedProblems);
	}

	public void testPredicate_VariablesAreBoundByPattern() {
		Relation relation = createRelation(transformation, "TestRelation");
		Variable variable = createVariable(relation.getVariable(), "TestVariable", getBooleanType());
		Pattern pattern = createPattern(null);
		relation.setWhen(pattern);
		Predicate predicate = createPredicate(pattern.getPredicate());
		OCLExpression variableExpression = createVariableExp(variable);
		predicate.setConditionExpression(variableExpression);
		//
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_VariablesAreBoundByPattern",
				new String[] { getQualifiedNameOf(variable), getQualifiedNameOf(pattern) });
		validationTest(expectedProblems);
	}

	public void testRule_OverridesDefinedByTransformation() {
		Rule rule = createConcreteRule(transformation, "TestRule");
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		Rule extraRule = createConcreteRule(extraTransformation, "TestExtraRule");
		rule.setOverrides(extraRule);
		//
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_OverridesDefinedByTransformation",
				new String[] { getQualifiedNameOf(rule), getQualifiedNameOf(transformation) });
		validationTest(expectedProblems);
		//
		transformation.setExtends(extraTransformation);
		validationTest(null);
	}

	public void testTransformation_ExtendsIsAcyclic() {
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		transformation.setExtends(extraTransformation);
		validationTest(null);
		//
		transformation.setExtends(transformation);
		ExpectedProblemLog expectedProblems2 = new ExpectedProblemLog();
		expectedProblems2.expectValidatorError("_UI_ExtendsIsAcyclic",
				new String[] { getQualifiedNameOf(transformation), getQualifiedNameOf(transformation) });
		validationTest(expectedProblems2);
		//
		extraTransformation.setExtends(transformation);
		ExpectedProblemLog expectedProblems1 = new ExpectedProblemLog();
		expectedProblems1.expectValidatorError("_UI_ExtendsIsAcyclic",
				new String[] { getQualifiedNameOf(transformation), getQualifiedNameOf(extraTransformation) });
		validationTest(expectedProblems1);
	}

	public void testTransformation_ModelParameterNamesAreCompatibleWithExtension() {
		List<EPackage> usedPackages = Collections.<EPackage>singletonList(EcorePackage.eINSTANCE);
		createTypedModel(transformation, "TestTypedModel1", usedPackages);
		createTypedModel(transformation, "TestTypedModel2", usedPackages);
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		createTypedModel(extraTransformation, "TestTypedModel1", usedPackages);
		createTypedModel(extraTransformation, "TestExtraTypedModel2", usedPackages);
		transformation.setExtends(extraTransformation);
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_ModelParameterNamesAreCompatibleWithExtension",
				new String[] { getQualifiedNameOf(transformation), getQualifiedNameOf(extraTransformation) });
		validationTest(expectedProblems);
	}

	public void testTransformation_EveryModelParameterUsedPackagesIsCompatibleWithExtension() {
		List<EPackage> usedPackages1 = Collections.<EPackage>singletonList(EcorePackage.eINSTANCE);
		List<EPackage> usedPackages2 = Collections.<EPackage>singletonList(org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
		createTypedModel(transformation, "TestTypedModel1", usedPackages1);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", usedPackages1);
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		createTypedModel(extraTransformation, "TestTypedModel1", usedPackages1);
		TypedModel extraTypedModel2 = createTypedModel(extraTransformation, "TestTypedModel2", usedPackages2);
		transformation.setExtends(extraTransformation);
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_EveryModelParameterUsedPackagesIsCompatibleWithExtension",
				new String[] { getQualifiedNameOf(typedModel2), getQualifiedNameOf(extraTypedModel2) });
		validationTest(expectedProblems);
	}

	public void testTransformation_ModelParameterNamesAreUnique() {
		List<EPackage> usedPackages = Collections.<EPackage>singletonList(EcorePackage.eINSTANCE);
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel", usedPackages);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel", usedPackages);
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_ModelParameterNamesAreUnique",
				new String[] { "TestTypedModel", getQualifiedNameOf(typedModel1), getQualifiedNameOf(typedModel2) });
		validationTest(expectedProblems);
	}

	public void testTransformation_RuleNamesAreUnique() {
		Rule rule1 = createConcreteRule(transformation, "TestRule");
		Rule rule2 = createConcreteRule(transformation, "TestRule");
		ExpectedProblemLog expectedProblems = new ExpectedProblemLog();
		expectedProblems.expectValidatorError("_UI_RuleNamesAreUnique",
				new String[] { "TestRule", getQualifiedNameOf(rule1), getQualifiedNameOf(rule2) });
		validationTest(expectedProblems);
	}

	public void testTransformation_SynthesizedTypesAreOwned() {
		// TODO
	}
}
