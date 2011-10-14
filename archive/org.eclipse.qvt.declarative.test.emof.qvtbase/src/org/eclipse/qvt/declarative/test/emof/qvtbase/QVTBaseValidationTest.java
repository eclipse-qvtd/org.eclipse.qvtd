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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.QVTBaseMessages;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestExpression;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestRule;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation;

public class QVTBaseValidationTest extends AbstractQVTBaseValidationTest
{
	public void testDomain_NotBothCheckableAndEnforceable() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRelation");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		//
		validationTest(new ProblemLog());
		//
		domain.setIsCheckable(false);
		validationTest(new ProblemLog());
		//
		domain.setIsEnforceable(false);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE, 
				QVTBaseMessages._UI_Domain_IsNotCheckableOrEnforceable,
				getQualifiedNameOf(domain));
		validationTest(expectedProblems);
		//
		domain.setIsCheckable(true);
		validationTest(new ProblemLog());
	}

	public void testDomain_TypedModelExistsWarning() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRelation");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain1", null);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorWarning(QVTBaseValidator.INSTANCE, 
				QVTBaseMessages._UI_Domain_TypedModelDoesNotExistWarning,
				getQualifiedNameOf(domain));
		validationTest(expectedProblems);
		//
		domain.setTypedModel(typedModel);
		validationTest(new ProblemLog());
	}

	public void testDomain_TypedModelDefinedByTransformation() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		EPackage[] usedPackages = new EPackage[] { EcorePackage.eINSTANCE };
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		TypedModel extraTypedModel = createTypedModel(extraTransformation, "TestTypedModel", usedPackages);
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", usedPackages);
		Rule rule = createTestRule(transformation.getRule(), "TestRule");
		Domain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		domain.setTypedModel(extraTypedModel);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Domain_TypedModelIsNotDefinedByTransformation,
				getQualifiedNameOf(extraTypedModel),
				getQualifiedNameOf(domain),
				getQualifiedNameOf(transformation));
		validationTest(expectedProblems);
		//
		transformation.setExtends(extraTransformation);
		validationTest(expectedProblems);
		//
		domain.setTypedModel(typedModel);
		validationTest(new ProblemLog());
	}

	public void testFunction_EveryFunctionParameterIsAFunctionParameter() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		Function function = createFunction(transformation, "TestFunction");
		EParameter eParameter = createEParameter(function, "TestParameter", getBooleanType());
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Function_ParameterIsNotAFunctionParameter,
				getQualifiedNameOf(eParameter));
		validationTest(expectedProblems);
	}
	
	public void testFunction_IsSideEffectFree() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		Function function = createFunction(transformation, "TestFunction");
		TestExpression expression = createTestExpression();
		function.setQueryExpression(expression);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorWarning(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Function_MayHaveASideEffect,
				expression.eClass().getName(),
				getQualifiedNameOf(function));
		validationTest(expectedProblems);		
	}

	public void testPattern_NoVariableIsAFunctionParameter() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		Function function = createFunction(transformation, "TestFunction");
		FunctionParameter functionParameter = createFunctionParameter(function, "TestParameter", getBooleanType());
		Variable variable = createVariable(transformation.getContents(), "TestVariable", getBooleanType());
		Pattern pattern = createTestPattern(transformation.getContents());
		pattern.getBindsTo().add(functionParameter);
		pattern.getBindsTo().add(variable);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Pattern_VariableIsNotAFunctionParameter,
				getQualifiedNameOf(functionParameter));
		validationTest(expectedProblems);
	}

	public void testPredicate_ConditionExpressionIsBoolean() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		Pattern pattern = createTestPattern(transformation.getContents());
		Predicate predicate = createPredicate(pattern.getPredicate());
		OCLExpression conditionExpression = createStringLiteralExp("xyzzy");
		predicate.setConditionExpression(conditionExpression);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Predicate_ConditionExpressionIsNotBoolean,
				getQualifiedNameOf(predicate));
		validationTest(expectedProblems);
	}

	public void testPredicate_ExternalVariablesAreBoundByPattern() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TestPattern pattern = createTestPattern(transformation.getContents());
		Predicate predicate = createPredicate(pattern.getPredicate());
		Variable variable = createVariable(pattern.getContents(), "TestVariable", getBooleanType());
		OCLExpression variableExpression = createVariableExp(variable);
		LetExp letExpression = createLetExp("LetVariable", getBooleanType(), variableExpression);
		predicate.setConditionExpression(letExpression);
		Variable letVariable = (Variable) letExpression.getVariable();
		pattern.getBindsTo().add(letVariable);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Predicate_ExternalVariableIsNotBoundByPattern,
				getQualifiedNameOf(variable),
				getQualifiedNameOf(pattern));
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Predicate_LocalVariableIsBoundByPattern,
				getQualifiedNameOf(letVariable),
				getQualifiedNameOf(pattern));
		validationTest(expectedProblems);
	}

	public void testRule_DomainNamesAreUnique() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Rule rule = createTestRule(transformation.getRule(), "TestRule");
		String name = "TestDomain";
		Domain domain1 = createTestDomain(rule.getDomain(), name, typedModel1);
		Domain domain2 = createTestDomain(rule.getDomain(), name, typedModel2);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Rule_DomainNameIsNotUnique,
				name,
				getQualifiedNameOf(domain1),
				getQualifiedNameOf(domain2));
		validationTest(expectedProblems);
	}

/*	public void testRule_DomainNumberMatches() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Rule rule = createTestRule(transformation.getRule(), "TestRule");
		Domain domain = createTestDomain(rule.getDomain(), "TestDomain1", typedModel1);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Rule_,
				"1",
				"2",
				getQualifiedNameOf(rule));
		validationTest(expectedProblems);
	} */

	public void testRule_OverridesDefinedByTransformation() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		Rule rule = createTestRule(transformation.getRule(), "TestRule");
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		Rule extraRule = createTestRule(extraTransformation.getRule(), "TestExtraRule");
		rule.setOverrides(extraRule);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Rule_OverridesIsNotDefinedByTransformation,
				getQualifiedNameOf(rule),
				getQualifiedNameOf(transformation));
		validationTest(expectedProblems);
		//
		transformation.setExtends(extraTransformation);
		validationTest(new ProblemLog());
	}
	
/*	public void testRule_OverridesIsCompatible() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", QVTBasePackage.eINSTANCE);
		Rule ruleA = createTestRule(transformation.getRule(), "TestRuleA");
		Domain domain1A = createTestDomain(ruleA.getDomain(), "TestDomain1", typedModel1);
		Domain domain2A = createTestDomain(ruleA.getDomain(), "TestDomain2", typedModel2);
		Rule ruleB = createTestRule(transformation.getRule(), "TestRuleB");
		Domain domain1B = createTestDomain(ruleB.getDomain(), "TestDomain1", typedModel1);
		ruleB.setOverrides(ruleA);
//		Domain domain2B = createTestDomain(ruleA.getDomain(), "TestDomain2", typedModel1);
		//
		ProblemLog expectedProblems1 = new ProblemLog();
//		expectedProblems1.expectValidatorError(QVTBaseValidator.INSTANCE,
//				QVTBaseMessages._UI_Rule_OverridenDomainCountIsNotCompatible,
//				"1",
//				"2",
//				getQualifiedNameOf(ruleA));
		validationTest(expectedProblems1);
		//
		Domain domain2B = createTestDomain(ruleB.getDomain(), "TestDomain3", typedModel2);
		//
		ProblemLog expectedProblems2 = new ProblemLog();
		expectedProblems2.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Rule_OverridenDomainDoesNotExist,
				getQualifiedNameOf(domain2B),
				getQualifiedNameOf(ruleA));
		validationTest(expectedProblems2);
		//
		domain1B.setTypedModel(typedModel2);
		domain2B.setTypedModel(typedModel1);
		domain2B.setName(domain2A.getName());
		//
		ProblemLog expectedProblems3 = new ProblemLog();
		expectedProblems3.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Rule_OverridenDomainPackagesAreNotCompatible,
				getQualifiedNameOf(domain2B),
				getQualifiedNameOf(domain2A));
		expectedProblems3.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Rule_OverridenDomainPackagesAreNotCompatible,
				getQualifiedNameOf(domain1B),
				getQualifiedNameOf(domain1A));
		validationTest(expectedProblems3);
	} */

	public void testTransformation_ExtendsIsAcyclic() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		transformation.setExtends(extraTransformation);
		validationTest(new ProblemLog());
		//
		transformation.setExtends(transformation);
		ProblemLog expectedProblems2 = new ProblemLog();
		expectedProblems2.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_ExtendsContainsACycle,
				getQualifiedNameOf(transformation),
				getQualifiedNameOf(transformation));
		validationTest(expectedProblems2);
		//
		extraTransformation.setExtends(transformation);
		ProblemLog expectedProblems1 = new ProblemLog();
		expectedProblems1.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_ExtendsContainsACycle,
				getQualifiedNameOf(transformation),
				getQualifiedNameOf(extraTransformation));
		validationTest(expectedProblems1);
	}

	public void testTransformation_ModelParameterNamesAreCompatibleWithExtension() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		EPackage[] usedPackages = new EPackage[] { EcorePackage.eINSTANCE };
		createTypedModel(transformation, "TestTypedModel1", usedPackages);
		createTypedModel(transformation, "TestTypedModel2", usedPackages);
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		createTypedModel(extraTransformation, "TestTypedModel1", usedPackages);
		createTypedModel(extraTransformation, "TestExtraTypedModel2", usedPackages);
		transformation.setExtends(extraTransformation);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_ModelParameterNameIsNotCompatibleWithExtension,
				getQualifiedNameOf(transformation),
				getQualifiedNameOf(extraTransformation));
		validationTest(expectedProblems);
	}

	public void testTransformation_EveryModelParameterUsedPackagesIsCompatibleWithExtension() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		EPackage[] usedPackages1 = new EPackage[] { EcorePackage.eINSTANCE };
		EPackage[] usedPackages2 = new EPackage[] { org.eclipse.ocl.ecore.EcorePackage.eINSTANCE };
		createTypedModel(transformation, "TestTypedModel1", usedPackages1);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", usedPackages1);
		Transformation extraTransformation = createTransformation(resource, "TestExtraTransformation");
		createTypedModel(extraTransformation, "TestTypedModel1", usedPackages1);
		TypedModel extraTypedModel2 = createTypedModel(extraTransformation, "TestTypedModel2", usedPackages2);
		transformation.setExtends(extraTransformation);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_ModelParameterUsedPackagesAreNotCompatibleWithExtension,
				getQualifiedNameOf(typedModel2),
				getQualifiedNameOf(extraTypedModel2));
		validationTest(expectedProblems);
	}

	public void testTransformation_ModelParameterNamesAreUnique() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		EPackage[] usedPackages = new EPackage[] { EcorePackage.eINSTANCE };
		String nonUniqueName = "TestTypedModel";
		TypedModel typedModel1 = createTypedModel(transformation, nonUniqueName, usedPackages);
		TypedModel typedModel2 = createTypedModel(transformation, nonUniqueName, usedPackages);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_ModelParameterNameIsNotUnique,
				nonUniqueName,
				getQualifiedNameOf(typedModel1),
				getQualifiedNameOf(typedModel2));
		validationTest(expectedProblems);
	}

	public void testTransformation_RuleNamesAreUnique() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		String nonUniqueName = "TestRule";
		Rule rule1 = createTestRule(transformation.getRule(), nonUniqueName);
		Rule rule2 = createTestRule(transformation.getRule(), nonUniqueName);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_RuleNameIsNotUnique,
				nonUniqueName,
				getQualifiedNameOf(rule1),
				getQualifiedNameOf(rule2));
		validationTest(expectedProblems);
	}

	public void testTransformation_SynthesizedTypesAreOwned() {
		Transformation transformation1 = createTransformation(resource, "TestTransformation1");
		Transformation transformation2 = createTransformation(resource, "TestTransformation1");
		CollectionType type = createCollectionType(transformation2.getEClassifiers(), CollectionKind.SET_LITERAL, getStringType());
		Function function = createFunction(transformation1, "TestFunction");
		createFunctionParameter(function, "TestParameter", type);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_SynthesizedTypeIsNotOwned,
				getQualifiedNameOf(type),
				getQualifiedNameOf(transformation1));
		validationTest(expectedProblems);
	}
	
/*	public void testTransformation_Transformation_SynthesizedTypesAreUnique() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		CollectionType type1 = createCollectionType(transformation.getEClassifiers(), CollectionKind.SET_LITERAL, getStringType());
		CollectionType type2 = createCollectionType(transformation.getEClassifiers(), CollectionKind.SET_LITERAL, getStringType());
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_Transformation_SynthesizedTypeIsNotUnique,
				getQualifiedNameOf(type1));
		validationTest(expectedProblems);
	} */
	
	public void testTypedModel_DependsOnIsAcyclic() {
		Transformation transformation = createTransformation(resource, "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		typedModel.getDependsOn().add(typedModel);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_TypedModel_DependsOnContainsACycle,
				getQualifiedNameOf(typedModel));
		validationTest(expectedProblems);
	}
	
	public void testTypedModel_DependsOnAreModelParameters() {
		Transformation transformation1 = createTransformation(resource, "TestTransformation1");
		Transformation transformation2 = createTransformation(resource, "TestTransformation1");
		TypedModel typedModel1 = createTypedModel(transformation1, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation2, "TestTypedModel2", EcorePackage.eINSTANCE);
		typedModel1.getDependsOn().add(typedModel2);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE,
				QVTBaseMessages._UI_TypedModel_DependsOnIsNotAModelParameter,
				getQualifiedNameOf(typedModel2),
				getQualifiedNameOf(transformation1));
		validationTest(expectedProblems);
	}
}
