/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: QVTTemplateValidationTest.java,v 1.4 2009/01/27 21:24:06 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.emof.qvttemplate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.AbstractEssentialOCLOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.operations.QVTTemplateMessages;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateValidator;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestRule;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation;

public class QVTTemplateValidationTest extends AbstractQVTTemplateValidationTest
{
	public void testCollectionTemplateExp_EveryEnforceableItemIsEnforced() {
		// TODO implement the constraint
	}

	public void testCollectionTemplateExp_EveryMemberTypeMatchesElementType() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EClass elementType = EcorePackage.Literals.EDATA_TYPE;
		CollectionType collectionType = createCollectionType(transformation.getEClassifiers(), CollectionKind.SET_LITERAL, elementType);
		Variable variable = createVariable(transformation.getContents(), "TestVariable", collectionType);
		pattern.getBindsTo().add(variable);
		CollectionTemplateExp templateExp = createCollectionTemplateExp(variable, collectionType, null, createStringLiteralExp("xyzzy"));
		pattern.getContents().add(templateExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_CollectionTemplateExp_MemberTypeDoesNotMatchElementType,
				getQualifiedNameOf(elementType),
				getQualifiedNameOf(getStringType()));
		validationTest(expectedProblems);
	}

	public void testCollectionTemplateExp_EveryMemberExpressionVariableIsBoundByPattern() {
		// TODO implement the constraint
	}

	public void testCollectionTemplateExp_MemberCountSatifiesLowerBound() {
		// FIXME Test the constraint
	}

	public void testCollectionTemplateExp_RestTypeMatchesCollectionType() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		CollectionType collectionType = createCollectionType(transformation.getEClassifiers(), CollectionKind.SET_LITERAL, EcorePackage.Literals.EDATA_TYPE);
		Variable variable = createVariable(transformation.getContents(), "TestVariable", collectionType);
		pattern.getBindsTo().add(variable);
		CollectionType badCollectionType = createCollectionType(transformation.getEClassifiers(), CollectionKind.SET_LITERAL, EcorePackage.Literals.EOBJECT);
		Variable restVariable = createVariable(transformation.getContents(), "TestRestVariable", badCollectionType);
		CollectionTemplateExp templateExp = createCollectionTemplateExp(variable, collectionType, restVariable);
		pattern.getContents().add(templateExp);
		pattern.getBindsTo().add(restVariable);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_CollectionTemplateExp_RestTypeDoesNotMatchCollectionType,
				getQualifiedNameOf(collectionType),
				getQualifiedNameOf(badCollectionType));
		validationTest(expectedProblems);
	}

	public void testCollectionTemplateExp_ReferredCollectionElementTypeIsDeclaredByDomain() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EClass badType = QVTTemplatePackage.Literals.TEMPLATE_EXP;
		Variable variable = createVariable(transformation.getContents(), "TestVariable", EcorePackage.Literals.EOBJECT);
		pattern.getBindsTo().add(variable);
		CollectionType collectionType = createCollectionType(transformation.getEClassifiers(), CollectionKind.SET_LITERAL, QVTTemplatePackage.Literals.TEMPLATE_EXP);
		CollectionTemplateExp templateExp = createCollectionTemplateExp(variable, collectionType, null);
		pattern.getContents().add(templateExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_CollectionTemplateExp_TypeIsNotDeclaredByDomain,
				getQualifiedNameOf(badType),
				getQualifiedNameOf(domain));
		validationTest(expectedProblems);
	}

	public void testCollectionTemplateExp_RestVariableIsBoundByPattern() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		CollectionType collectionType = createCollectionType(transformation.getEClassifiers(), CollectionKind.SET_LITERAL, EcorePackage.Literals.EDATA_TYPE);
		Variable variable = createVariable(transformation.getContents(), "TestVariable", collectionType);
		pattern.getBindsTo().add(variable);
		Variable restVariable = createVariable(transformation.getContents(), "TestRestVariable", collectionType);
		CollectionTemplateExp templateExp = createCollectionTemplateExp(variable, collectionType, restVariable);
		pattern.getContents().add(templateExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_CollectionTemplateExp_RestVariableIsNotBoundByPattern,
				restVariable.getName(),
				getQualifiedNameOf(pattern));
		validationTest(expectedProblems);
		//
		pattern.getBindsTo().add(restVariable);
		//
		validationTest(new ProblemLog());
	}

	public void testObjectTemplateExp_PartsAreUnique() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", TestQVTBasePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EAttribute property = TestQVTBasePackage.Literals.TEST_TRANSFORMATION__STRING;
		EClass objectType = property.getEContainingClass();
		EClassifier elementType = property.getEAttributeType();
		Variable variable = createVariable(transformation.getContents(), "TestVariable", objectType);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp objectTemplateExp = createObjectTemplateExp(variable, objectType);
		pattern.getContents().add(objectTemplateExp);
		Variable extraVariable1 = createVariable(transformation.getContents(), "TestExtraVariable1", elementType);
		Variable extraVariable2 = createVariable(transformation.getContents(), "TestExtraVariable2", elementType);
		pattern.getBindsTo().add(extraVariable1);
		pattern.getBindsTo().add(extraVariable2);
		VariableExp variableExp1 = createVariableExp(extraVariable1);
		VariableExp variableExp2 = createVariableExp(extraVariable2);
		PropertyTemplateItem propertyTemplateItem1 = createPropertyTemplateItem(objectTemplateExp, property, variableExp1);
		PropertyTemplateItem propertyTemplateItem2 = createPropertyTemplateItem(objectTemplateExp, property, variableExp2);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_ObjectTemplateExp_PartIsNotUnique,
				getQualifiedNameOf(property),
				getQualifiedNameOf(propertyTemplateItem1),
				getQualifiedNameOf(propertyTemplateItem2));
		validationTest(expectedProblems);
	}
	
	public void testObjectTemplateExp_ReferredClassIsDeclaredByDomain() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EClass badType = QVTTemplatePackage.Literals.TEMPLATE_EXP;
		Variable variable = createVariable(transformation.getContents(), "TestVariable", EcorePackage.Literals.EOBJECT);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp templateExp = createObjectTemplateExp(variable, badType);
		pattern.getContents().add(templateExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_ObjectTemplateExp_ReferredClassIsNotDeclaredByDomain,
				getQualifiedNameOf(badType),
				getQualifiedNameOf(domain));
		validationTest(expectedProblems);
	}
	
	public void testObjectTemplateExp_EveryEnforceablePartIsEnforced() {
		// TODO implement the constraint
	}
	
	public void testPropertyTemplateItem_CollectionElementTypeMatchesPropertyType() {
		// TODO implement the constraint
	}
	
	public void testPropertyTemplateItem_EveryExpressionVariableIsBoundByPattern() {
		// TODO implement the constraint
	}
	
	public void testPropertyTemplateItem_ObjectTypeMatchesPropertyType() {
		// TODO implement the constraint
	}

	public void testPropertyTemplateItem_ReferredPropertyIsDefinedByReferredClass() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EClass objectType = EcorePackage.Literals.EFACTORY;
		Variable variable = createVariable(transformation.getContents(), "TestVariable", objectType);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp objectTemplateExp = createObjectTemplateExp(variable, objectType);
		pattern.getContents().add(objectTemplateExp);
		EAttribute badProperty = EcorePackage.Literals.ENAMED_ELEMENT__NAME;
		createPropertyTemplateItem(objectTemplateExp, badProperty, createStringLiteralExp("xyzzy"));
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_PropertyTemplateItem_ReferredPropertyIsNotDefinedByReferredClass,
				getQualifiedNameOf(badProperty),
				getQualifiedNameOf(objectType));
		validationTest(expectedProblems);
	}

	public void testPropertyTemplateItem_ValueElementTypeMatchesReferredPropertyElementType() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EClass objectType = EcorePackage.Literals.ECLASS;
		Variable variable = createVariable(transformation.getContents(), "TestVariable", objectType);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp objectTemplateExp = createObjectTemplateExp(variable, objectType);
		pattern.getContents().add(objectTemplateExp);
		EAttribute badProperty = EcorePackage.Literals.ENAMED_ELEMENT__NAME;
		IntegerLiteralExp badValue = createIntegerLiteralExp(99);
		createPropertyTemplateItem(objectTemplateExp, badProperty, badValue);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_PropertyTemplateItem_ValueElementTypeDoesNotMatchReferredPropertyElementType,
				getQualifiedNameOf(badValue.getType()),
				getQualifiedNameOf(badProperty.getEAttributeType()),
				getQualifiedNameOf(badProperty));
		validationTest(expectedProblems);
	}

	public void testPropertyTemplateItem_SetMatchesSet() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", TestQVTBasePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EAttribute property = TestQVTBasePackage.Literals.TEST_TRANSFORMATION__STRING_SET;
		EClass objectType = property.getEContainingClass();
		Variable variable = createVariable(transformation.getContents(), "TestVariable", objectType);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp objectTemplateExp = createObjectTemplateExp(variable, objectType);
		pattern.getContents().add(objectTemplateExp);
		CollectionType valueType = createCollectionType(transformation.getEClassifiers(), CollectionKind.BAG_LITERAL, getStringType());
		Variable itemVariable = createVariable(transformation.getContents(), "TestItemVariable", valueType);
		pattern.getBindsTo().add(itemVariable);
		CollectionTemplateExp collectionTemplateExp = createCollectionTemplateExp(itemVariable, valueType, null);
		createPropertyTemplateItem(objectTemplateExp, property, collectionTemplateExp);
		EClassifier propertyType = AbstractEssentialOCLOperations.getPropertyType(property);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_PropertyTemplateItem_SetDoesNotMatchSet,
				getQualifiedNameOf(valueType),
				getQualifiedNameOf(propertyType),
				getQualifiedNameOf(property));
		validationTest(expectedProblems);
	}

	public void testPropertyTemplateItem_NonBagMatchesNonBag() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", TestQVTBasePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EAttribute property = TestQVTBasePackage.Literals.TEST_TRANSFORMATION__STRING_SEQUENCE;
		EClass objectType = property.getEContainingClass();
		Variable variable = createVariable(transformation.getContents(), "TestVariable", objectType);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp objectTemplateExp = createObjectTemplateExp(variable, objectType);
		pattern.getContents().add(objectTemplateExp);
		CollectionType valueType = createCollectionType(transformation.getEClassifiers(), CollectionKind.BAG_LITERAL, getStringType());
		Variable itemVariable = createVariable(transformation.getContents(), "TestItemVariable", valueType);
		pattern.getBindsTo().add(itemVariable);
		CollectionTemplateExp collectionTemplateExp = createCollectionTemplateExp(itemVariable, valueType, null);
		createPropertyTemplateItem(objectTemplateExp, property, collectionTemplateExp);
		EClassifier propertyType = AbstractEssentialOCLOperations.getPropertyType(property);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_PropertyTemplateItem_NonBagDDoesNotMatchNonBag,
				getQualifiedNameOf(valueType),
				getQualifiedNameOf(propertyType),
				getQualifiedNameOf(property));
		validationTest(expectedProblems);
	}

/*	public void testPropertyTemplateItem_SimpleVariableIsBoundByPattern() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", TestQVTBasePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EAttribute property = TestQVTBasePackage.Literals.TEST_TRANSFORMATION__STRING;
		EClass objectType = property.getEContainingClass();
		EClassifier elementType = property.getEAttributeType();
		Variable variable = createVariable(transformation.getContents(), "TestVariable", objectType);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp objectTemplateExp = createObjectTemplateExp(variable, objectType);
		pattern.getContents().add(objectTemplateExp);
		Variable extraVariable = createVariable(transformation.getContents(), "TestExtraVariable", elementType);
		VariableExp variableExp = createVariableExp(extraVariable);
		createPropertyTemplateItem(objectTemplateExp, property, variableExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_PropertyTemplateItem_SimpleVariableIsNotBoundByPattern,
				getQualifiedNameOf(extraVariable),
				getQualifiedNameOf(pattern));
		validationTest(expectedProblems);
		//
		pattern.getBindsTo().add(extraVariable);
		//
		validationTest(new ProblemLog());
	} */

	public void testTemplateExp_DomainExists() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TestPattern pattern = createTestPattern(transformation.getContents());
		Variable variable = createVariable(pattern.getContents(), "TestVariable", getStringType());
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp templateExp = createObjectTemplateExp(variable, EcorePackage.Literals.EDATA_TYPE);
		pattern.getContents().add(templateExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_TemplateExp_DomainDoesNotExist,
				getQualifiedNameOf(templateExp));
		validationTest(expectedProblems);
	}

	public void testTemplateExp_PatternExists() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		Variable variable = createVariable(domain.getContents(), "TestVariable", getStringType());
		ObjectTemplateExp templateExp = createObjectTemplateExp(variable, EcorePackage.Literals.EDATA_TYPE);
		domain.getContents().add(templateExp);
			//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_TemplateExp_PatternDoesNotExist,
				getQualifiedNameOf(templateExp));
		validationTest(expectedProblems);
	}

	public void testTemplateExp_VariableIsBoundByPattern() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		Variable variable = createVariable(transformation.getContents(), "TestVariable", getStringType());
		ObjectTemplateExp templateExp = createObjectTemplateExp(variable, EcorePackage.Literals.EDATA_TYPE);
		pattern.getContents().add(templateExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_TemplateExp_VariableIsNotBoundByPattern,
				getQualifiedNameOf(variable),
				getQualifiedNameOf(pattern));
		validationTest(expectedProblems);
	}

	public void testTemplateExp_VariableTypeIsDeclaredByDomain() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		EClass badType = QVTTemplatePackage.Literals.TEMPLATE_EXP;
		Variable variable = createVariable(transformation.getContents(), "TestVariable", badType);
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp templateExp = createObjectTemplateExp(variable, EcorePackage.Literals.EOBJECT);
		pattern.getContents().add(templateExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_TemplateExp_VariableTypeIsNotDeclaredByDomain,
				getQualifiedNameOf(badType),
				getQualifiedNameOf(variable),
				getQualifiedNameOf(domain));
		validationTest(expectedProblems);
	}

	public void testTemplateExp_WhereIsBoolean() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		TypedModel typedModel = createTypedModel(transformation, "TestTypedModel", EcorePackage.eINSTANCE);
		TestRule rule = createTestRule(transformation.getRule(), "TestRule");
		TestDomain domain = createTestDomain(rule.getDomain(), "TestDomain", typedModel);
		TestPattern pattern = createTestPattern(domain.getContents());
		Variable variable = createVariable(transformation.getContents(), "TestVariable", getStringType());
		pattern.getBindsTo().add(variable);
		ObjectTemplateExp templateExp = createObjectTemplateExp(variable, EcorePackage.Literals.EDATA_TYPE);
		pattern.getContents().add(templateExp);
		OCLExpression conditionExpression = createStringLiteralExp("xyzzy");
		templateExp.setWhere(conditionExpression);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTTemplateValidator.INSTANCE,
				QVTTemplateMessages._UI_TemplateExp_WhereIsNotBoolean,
				getQualifiedNameOf(conditionExpression));
		validationTest(expectedProblems);
	}
}
