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
 * $Id: QVTRelationValidationTest.java,v 1.3 2009/01/27 21:24:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.emof.qvtrelation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.impl.DomainImpl;
import org.eclipse.qvt.declarative.ecore.QVTBase.impl.RuleImpl;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.QVTBaseMessages;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.QVTRelationMessages;
import org.eclipse.qvt.declarative.ecore.QVTRelation.util.QVTRelationValidator;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.operations.EcoreMessages;
import org.eclipse.qvt.declarative.ecore.operations.EcoreValidatorWithOperations;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation;

public class QVTRelationValidationTest extends AbstractQVTRelationValidationTest
{
	protected void checkPatternTypesAreDeclared(EReference relationFeature, String message) {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		Variable relationVariable = createVariable(relation.getVariable(), "TestRelationVariable", getBooleanType());
		Pattern pattern = createPattern(null);
		relation.eSet(relationFeature, pattern);
		Predicate predicate2 = createPredicate(pattern.getPredicate());
		OCLExpression varExpression2 = createVariableExp(relationVariable);
		EClass badType = QVTRelationPackage.Literals.RELATION;
		LetExp conditionExpression2 = createLetExp("TestLetVar", badType, varExpression2);
		pattern.getBindsTo().add(relationVariable);
		Variable letVariable = (Variable) conditionExpression2.getVariable();
		predicate2.setConditionExpression(conditionExpression2);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, message,
				getQualifiedNameOf(badType),
				getQualifiedNameOf(letVariable),
				getQualifiedNameOf(relation));
		validationTest(expectedProblems);
	}

	protected void checkPatternVariablesAreDefined(EReference relationFeature, String message) {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		RelationalTransformation anotherTransformation = createRelationalTransformation(resource, "AnotherTestTransformation");
		TypedModel anotherTypedModel1 = createTypedModel(anotherTransformation, "AnotherTestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel anotherTypedModel2 = createTypedModel(anotherTransformation, "AnotherTestTypedModel2", EcorePackage.eINSTANCE);
		Relation anotherRelation = createRelation(anotherTransformation, "AnotherTestRelation");
		RelationDomain anotherDomain1 = createRelationDomain(anotherRelation, "AnotherTestDomain1", anotherTypedModel1, "AnotherRootVariable1", getBooleanType());
		createDomainPattern(anotherDomain1);
		RelationDomain anotherDomain2 = createRelationDomain(anotherRelation, "AnotherTestDomain2", anotherTypedModel2, "AnotherRootVariable2", getBooleanType());
		createDomainPattern(anotherDomain2);
//		Variable relationVariable = createVariable(relation.getVariable(), "TestRelationVariable", getBooleanType());
		Variable anotherRelationVariable = createVariable(anotherRelation.getVariable(), "AnotherTestRelationVariable", getBooleanType());
		Pattern pattern = createPattern(null);
		relation.eSet(relationFeature, pattern);
		Predicate predicate2 = createPredicate(pattern.getPredicate());
		OCLExpression varExpression2 = createVariableExp(anotherRelationVariable);
		LetExp conditionExpression2 = createLetExp("TestLetVar", getBooleanType(), varExpression2);
		Variable letVariable = (Variable) conditionExpression2.getVariable();
		predicate2.setConditionExpression(conditionExpression2);
		pattern.getBindsTo().add(anotherRelationVariable);
		Predicate predicate1 = createPredicate(pattern.getPredicate());
		OCLExpression conditionExpression1 = createVariableExp(letVariable);
		predicate1.setConditionExpression(conditionExpression1);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, message,
				getQualifiedNameOf(anotherRelationVariable),
				getQualifiedNameOf(relation));
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, message,
				getQualifiedNameOf(letVariable),
				getQualifiedNameOf(relation));
		validationTest(expectedProblems);
	}

	public void testDomainPattern_EveryVariableIsDefinedByRelation() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		DomainPattern domainPattern2 = createDomainPattern(domain2);
		RelationalTransformation anotherTransformation = createRelationalTransformation(resource, "AnotherTestTransformation");
		TypedModel anotherTypedModel1 = createTypedModel(anotherTransformation, "AnotherTestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel anotherTypedModel2 = createTypedModel(anotherTransformation, "AnotherTestTypedModel2", EcorePackage.eINSTANCE);
		Relation anotherRelation = createRelation(anotherTransformation, "AnotherTestRelation");
		RelationDomain anotherDomain1 = createRelationDomain(anotherRelation, "AnotherTestDomain1", anotherTypedModel1, "AnotherRootVariable1", getBooleanType());
		createDomainPattern(anotherDomain1);
		RelationDomain anotherDomain2 = createRelationDomain(anotherRelation, "AnotherTestDomain2", anotherTypedModel2, "AnotherRootVariable2", getBooleanType());
		createDomainPattern(anotherDomain2);
		//
		validationTest(new ProblemLog());
		//
		Variable rootVariable = anotherDomain2.getRootVariable();
		domainPattern2.getBindsTo().add(rootVariable);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_DomainPattern_VariableIsNotDefinedByRelation,
				getQualifiedNameOf(rootVariable),
				getQualifiedNameOf(relation));
		validationTest(expectedProblems);
	}

	public void testDomainPattern_RootTemplateExpressionIsBoundToRootVariable() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		Variable variable = createVariable(relation.getVariable(), "TestVariable", getStringType());
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		DomainPattern pattern = createDomainPattern(domain2);
		ObjectTemplateExp templateExp = createObjectTemplateExp(variable, EcorePackage.Literals.EDATA_TYPE);
		pattern.setTemplateExpression(templateExp);
		Variable rootVariable = domain2.getRootVariable();
		pattern.getBindsTo().add(rootVariable);
		pattern.getBindsTo().add(variable);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_DomainPattern_RootTemplateExpressionIsNotBoundToRootVariable,
				getQualifiedNameOf(rootVariable),
				getQualifiedNameOf(variable));
		validationTest(expectedProblems);
	}

	public void testDomainPattern_RootTemplateExpressionTypeIsRootVariableType() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
	TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		createVariable(relation.getVariable(), "TestVariable", getStringType());
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		DomainPattern pattern = createDomainPattern(domain2);
		Variable rootVariable = domain2.getRootVariable();
		ObjectTemplateExp templateExp = createObjectTemplateExp(rootVariable, EcorePackage.Literals.EDATA_TYPE);
		templateExp.setEType(EcorePackage.Literals.EDATA_TYPE);
		pattern.setTemplateExpression(templateExp);
		pattern.getBindsTo().add(rootVariable);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_DomainPattern_RootTemplateExpressionTypeIsNotRootVariableType,
				getQualifiedNameOf(getStringType()),
				getQualifiedNameOf(rootVariable),
				getQualifiedNameOf(EcorePackage.Literals.EDATA_TYPE));
		validationTest(expectedProblems);
	}

	public void testKey_IdentifiesTypeIsNonNull() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		Key key = createKey(transformation, null, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(EcoreValidatorWithOperations.INSTANCE,
				EcoreMessages._UI_RequiredFeatureMustBeSet_diagnostic,
				QVTRelationPackage.Literals.KEY__IDENTIFIES.getName(),
				getQualifiedNameOf(key));
		validationTest(expectedProblems);
	}
	
	public void testKey_AtLeastOnePart() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		createTypedModel(transformation, "ecore", EcorePackage.eINSTANCE);
		Key key = createKey(transformation, EcorePackage.Literals.ENAMED_ELEMENT);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_Key_NoParts,
				getQualifiedNameOf(key));
		validationTest(expectedProblems);
	}

	public void testKey_IdentifiesTypeIsDeclaredByTransformation() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		EClass identifies = EcorePackage.Literals.EOPERATION;
		createKey(transformation, identifies, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_Key_IdentifiesTypeIsNotDeclaredByTransformation,
				getQualifiedNameOf(identifies),
				getQualifiedNameOf(transformation));
		validationTest(expectedProblems);
	}

	public void testKey_EveryPartIsDeclaredByIdentifies() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		createTypedModel(transformation, "ecore", EcorePackage.eINSTANCE);
		EReference part = EcorePackage.Literals.EFACTORY__EPACKAGE;
		EClass identifies = EcorePackage.Literals.EOPERATION;
		Key key = createKey(transformation, identifies, part);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_Key_PartIsNotDeclaredByIdentifies,
				getQualifiedNameOf(part),
				getQualifiedNameOf(key),
				getQualifiedNameOf(identifies));
		validationTest(expectedProblems);
	}

	public void testKey_EveryOppositePartReferencesIdentifies() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		createTypedModel(transformation, "ecore", EcorePackage.eINSTANCE);
		EReference oppositePart = EcorePackage.Literals.EFACTORY__EPACKAGE;
		EClass identifies = EcorePackage.Literals.EOPERATION;
		Key key = createKey(transformation, identifies);
		key.getOppositePart().add(oppositePart);
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_Key_OppositePartDoesNotReferenceIdentifies,
				getQualifiedNameOf(oppositePart),
				getQualifiedNameOf(key),
				getQualifiedNameOf(identifies));
		validationTest(expectedProblems);
	}

	public void testRelation_EveryDomainIsARelationDomain() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		Domain domain2 = new DomainImpl() {};
		domain2.setName("TestDomain2");
		domain2.setTypedModel(typedModel2);
		domain2.setIsCheckable(true);
		domain2.setIsEnforceable(true);
		relation.getDomain().add(domain2);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_Relation_DomainIsNotARelationDomain,
				getQualifiedNameOf(domain2));
		validationTest(expectedProblems);
	}

	public void testOppositePropertyCallExp_PropertyIsReference() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		EAttribute property = EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND;
		OppositePropertyCallExp oppositePropertyCallExp = createOppositePropertyCallExp(null, property);
		transformation.getContents().add(oppositePropertyCallExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_OppositePropertyCallExp_PropertyIsNotAReference,
				getQualifiedNameOf(property));
		validationTest(expectedProblems);
	}

	public void testOppositePropertyCallExp_PropertyIsUnidirectional() {
		TestTransformation transformation = createTestTransformation(resource.getContents(), "TestTransformation");
		EReference property = EcorePackage.Literals.EOPERATION__EPARAMETERS;
		OppositePropertyCallExp oppositePropertyCallExp = createOppositePropertyCallExp(null, property);
		transformation.getContents().add(oppositePropertyCallExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_OppositePropertyCallExp_PropertyIsNotUnidirectional,
				getQualifiedNameOf(property));
		validationTest(expectedProblems);
	}

	public void testRelation_AtLeastTwoDomains() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain = createRelationDomain(relation, "TestDomain", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_Relation_LessThanTwoDomains,
				getQualifiedNameOf(relation));
		validationTest(expectedProblems);
	}

	public void testRelation_NonTopLevelIsNotInvokedWarning() {
	}

	public void testRelation_RelationImplsAreUniqueWarning() {
	}

	public void testRelation_DomainTypedModelsMatchModelParameters() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		TypedModel typedModel3 = createTypedModel(transformation, "TestTypedModel3", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		//
		ProblemLog expectedProblems1 = new ProblemLog();
		expectedProblems1.expectValidatorError(QVTRelationValidator.INSTANCE,
				QVTRelationMessages._UI_Relation_DomainTypedModelsDoNotMatchModelParameters,
				"2",
				getQualifiedNameOf(relation),
				"3");
		validationTest(expectedProblems1);
		//
		RelationDomain domain3 = createRelationDomain(relation, "TestDomain3", typedModel1, "RootVariable3", getStringType());
		createDomainPattern(domain3);
		//
		ProblemLog expectedProblems2 = new ProblemLog();
		expectedProblems2.expectValidatorError(QVTRelationValidator.INSTANCE,
				QVTRelationMessages._UI_Relation_DomainTypedModelIsNotModelParameter,
				getQualifiedNameOf(domain3),
				getQualifiedNameOf(typedModel3));
		validationTest(expectedProblems2);
		//
		domain3.setTypedModel(typedModel3);
		//
		validationTest(new ProblemLog());
	}
	
	public void testRelation_VariablesAreUnique() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		EClass type = EcorePackage.Literals.ENAMED_ELEMENT;
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", type);
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", type);
		createDomainPattern(domain2);
		String name = "Variable1";
		Variable var1 = createVariable(relation.getVariable(), name, type);
		Variable var2 = createVariable(relation.getVariable(), name, type);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_Relation_VariableNameIsNotUnique,
				name,
				getQualifiedNameOf(var1),
				getQualifiedNameOf(var2));
		validationTest(expectedProblems);
	}

	public void testRelation_WhenTypesAreDeclaredByRelation() {
		EReference relationFeature = QVTRelationPackage.Literals.RELATION__WHEN;
		String message = QVTRelationMessages._UI_Relation_WhenTypeIsNotDeclaredByRelation;
		checkPatternTypesAreDeclared(relationFeature, message);
	}

	public void testRelation_WhenVariablesAreDefinedByRelation() {
		EReference relationFeature = QVTRelationPackage.Literals.RELATION__WHEN;
		String message = QVTRelationMessages._UI_Relation_WhenVariableIsNotDefinedByRelation;
		checkPatternVariablesAreDefined(relationFeature, message);
	}

	public void testRelation_WhereTypesAreDeclaredByRelation() {
		EReference relationFeature = QVTRelationPackage.Literals.RELATION__WHERE;
		String message = QVTRelationMessages._UI_Relation_WhereTypeIsNotDeclaredByRelation;
		checkPatternTypesAreDeclared(relationFeature, message);
	}

	public void testRelation_WhereVariablesAreDefinedByRelation() {
		EReference relationFeature = QVTRelationPackage.Literals.RELATION__WHERE;
		String message = QVTRelationMessages._UI_Relation_WhereVariableIsNotDefinedByRelation;
		checkPatternVariablesAreDefined(relationFeature, message);
	}

	public void testRelationCallExp_PatternExists() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
	TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		RelationCallExp relationCallExp = createRelationCallExp(relation, createStringLiteralExp("a"), createStringLiteralExp("b"));
		resource.getContents().add(relationCallExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_PatternDoesNotExist,
				getQualifiedNameOf(relationCallExp));
		validationTest(expectedProblems);
	}

	public void testRelationCallExp_RelationExists() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		RelationCallExp relationCallExp = createRelationCallExp(relation, createStringLiteralExp("a"), createStringLiteralExp("b"));
		Pattern pattern = createPattern(null);
		Predicate predicate = createPredicate(pattern.getPredicate());
		predicate.setConditionExpression(relationCallExp);
		resource.getContents().add(pattern);
			//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_RelationDoesNotExist,
				getQualifiedNameOf(relationCallExp));
		validationTest(expectedProblems);
	}

	public void testRelationCallExp_InvokedFromWhenOrWhereClause() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		DomainPattern pattern = createDomainPattern(domain2);
		ObjectTemplateExp templateExp = createObjectTemplateExp(domain2.getRootVariable(), EcorePackage.Literals.EDATA_TYPE);
		pattern.setTemplateExpression(templateExp);
		pattern.getBindsTo().add(domain2.getRootVariable());
		RelationCallExp relationCallExp = createRelationCallExp(relation, createStringLiteralExp("a"), createStringLiteralExp("b"));
		createPropertyTemplateItem(templateExp, EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE, relationCallExp);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_NotInvokedFromWhenOrWhereClause,
				getQualifiedNameOf(relationCallExp));
		validationTest(expectedProblems);
	}

	public void testRelationCallExp_ReferredRelationDeclaredByTransformation() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		RelationalTransformation anotherTransformation = createRelationalTransformation(resource, "AnotherTestTransformation");
		TypedModel anotherTypedModel1 = createTypedModel(anotherTransformation, "AnotherTestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel anotherTypedModel2 = createTypedModel(anotherTransformation, "AnotherTestTypedModel2", EcorePackage.eINSTANCE);
		Relation anotherRelation = createRelation(anotherTransformation, "AnotherTestRelation");
		RelationDomain anotherDomain1 = createRelationDomain(anotherRelation, "AnotherTestDomain1", anotherTypedModel1, "AnotherRootVariable1", getStringType());
		createDomainPattern(anotherDomain1);
		RelationDomain anotherDomain2 = createRelationDomain(anotherRelation, "AnotherTestDomain2", anotherTypedModel2, "AnotherRootVariable2", getBooleanType());
		createDomainPattern(anotherDomain2);
		Pattern pattern = createPattern(null);
		Predicate predicate = createPredicate(pattern.getPredicate());
		RelationCallExp relationCallExp = createRelationCallExp(anotherRelation, createStringLiteralExp("a"), createBooleanLiteralExp(true));
		predicate.setConditionExpression(relationCallExp);
		relation.setWhen(pattern);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_ReferredRelationIsNotDeclaredByTransformation,
				getQualifiedNameOf(anotherRelation),
				getQualifiedNameOf(transformation));
		validationTest(expectedProblems);
	}

	public void testRelationCallExp_ReferredRelationArgumentNumberMatches() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		Pattern pattern = createPattern(null);
		Predicate predicate = createPredicate(pattern.getPredicate());
		RelationCallExp relationCallExp = createRelationCallExp(relation, createStringLiteralExp("a"), createStringLiteralExp("b"), createStringLiteralExp("c"));
		predicate.setConditionExpression(relationCallExp);
		relation.setWhen(pattern);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_ReferredRelationArgumentNumberDoesNotMatch,
				String.valueOf(3),
				String.valueOf(2),
				getQualifiedNameOf(relationCallExp));
		validationTest(expectedProblems);
	}

	public void testRelationCallExp_EveryWhenReferredRelationArgumentTypeMatches() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		EClass baseType = EcorePackage.Literals.ENAMED_ELEMENT;
		EClass derivedType = EcorePackage.Literals.EDATA_TYPE;
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", derivedType);
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", baseType);
		createDomainPattern(domain2);
		Pattern pattern = createPattern(null);
		Predicate predicate = createPredicate(pattern.getPredicate());
		Variable var1 = createVariable(relation.getVariable(), "Variable1", baseType);
		Variable var2 = createVariable(relation.getVariable(), "Variable2", derivedType);
		RelationCallExp relationCallExp = createRelationCallExp(relation, createVariableExp(var1), createVariableExp(var2));
		predicate.setConditionExpression(relationCallExp);
		pattern.getBindsTo().add(var1);
		pattern.getBindsTo().add(var2);
		relation.setWhen(pattern);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_WhenReferredRelationArgumentTypeDoesNotMatch,
				getQualifiedNameOf(baseType),
				getQualifiedNameOf(derivedType),
				getQualifiedNameOf(domain1));
//		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
//				QVTRelationMessages._UI_RelationCallExp_WhenReferredRelationArgumentTypeDoesNotMatch,
//				getQualifiedNameOf(derivedType),
//				getQualifiedNameOf(baseType),
//				getQualifiedNameOf(domain2));
		validationTest(expectedProblems);
	}

	public void testRelationCallExp_EveryWhereReferredRelationArgumentTypeIsMatchableWarning() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		TypedModel typedModel3 = createTypedModel(transformation, "TestTypedModel3", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		EClass baseType = EcorePackage.Literals.ENAMED_ELEMENT;
		EClass derivedType = EcorePackage.Literals.EDATA_TYPE;
		EClass orthogonalType = EcorePackage.Literals.EFACTORY;
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", derivedType);
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", baseType);
		createDomainPattern(domain2);
		RelationDomain domain3 = createRelationDomain(relation, "TestDomain3", typedModel3, "RootVariable3", derivedType);
		createDomainPattern(domain3);
		Pattern pattern = createPattern(null);
		Predicate predicate = createPredicate(pattern.getPredicate());
		Variable var1 = createVariable(relation.getVariable(), "Variable1", baseType);
		Variable var2 = createVariable(relation.getVariable(), "Variable2", derivedType);
		Variable var3 = createVariable(relation.getVariable(), "Variable3", orthogonalType);
		RelationCallExp relationCallExp = createRelationCallExp(relation, createVariableExp(var1), createVariableExp(var2), createVariableExp(var3));
		predicate.setConditionExpression(relationCallExp);
		pattern.getBindsTo().add(var1);
		pattern.getBindsTo().add(var2);
		pattern.getBindsTo().add(var3);
		relation.setWhere(pattern);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorWarning(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_WhereReferredRelationArgumentTypeIsNotMatchableWarning,
				getQualifiedNameOf(orthogonalType),
				getQualifiedNameOf(derivedType),
				getQualifiedNameOf(domain3));
		validationTest(expectedProblems);
	}

	public void testRelationCallExp_TypeIsBoolean() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		RelationCallExp relationCallExp = createRelationCallExp(relation, createStringLiteralExp("a"), createStringLiteralExp("b"));
		Pattern pattern = createPattern(null);
		relation.setWhen(pattern);
		Predicate predicate = createPredicate(pattern.getPredicate());
		predicate.setConditionExpression(relationCallExp);
		relationCallExp.setType(getStringType());		
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationCallExp_TypeIsNotBoolean,
				getQualifiedNameOf(relationCallExp));
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE, 
				QVTBaseMessages._UI_Predicate_ConditionExpressionIsNotBoolean,
				getQualifiedNameOf(predicate));
		validationTest(expectedProblems);
		//
		relationCallExp.setType(getBooleanType());
		//
		validationTest(new ProblemLog());
	}
	
	public void testRelationDomain_RootVariableIsDefinedByRelation() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		RelationalTransformation anotherTransformation = createRelationalTransformation(resource, "AnotherTestTransformation");
		TypedModel anotherTypedModel1 = createTypedModel(anotherTransformation, "AnotherTestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel anotherTypedModel2 = createTypedModel(anotherTransformation, "AnotherTestTypedModel2", EcorePackage.eINSTANCE);
		Relation anotherRelation = createRelation(anotherTransformation, "AnotherTestRelation");
		RelationDomain anotherDomain1 = createRelationDomain(anotherRelation, "AnotherTestDomain1", anotherTypedModel1, "AnotherRootVariable1", getBooleanType());
		createDomainPattern(anotherDomain1);
		RelationDomain anotherDomain2 = createRelationDomain(anotherRelation, "AnotherTestDomain2", anotherTypedModel2, "AnotherRootVariable2", getBooleanType());
		createDomainPattern(anotherDomain2);
		//
		validationTest(new ProblemLog());
		//
		Variable rootVariable = anotherDomain2.getRootVariable();
		domain2.setRootVariable(rootVariable);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationDomain_RootVariableIsNotDefinedByRelation,
				getQualifiedNameOf(rootVariable),
				getQualifiedNameOf(relation));
		validationTest(expectedProblems);
	}

	/**
	 * Validates the RootVariableTypeIsDeclaredByDomainTypedModel constraint of '<em>Relation Domain</em>'.
	 */
	public void testRelationDomain_RootVariableTypeIsDeclaredByDomainTypedModel() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		//
		validationTest(new ProblemLog());
		//
		Variable rootVariable = domain2.getRootVariable();
		EClass badType = QVTRelationPackage.Literals.RELATION;
		rootVariable.setEType(badType);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTBaseValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationDomain_RootVariableTypeIsNotDeclaredByDomainTypedModel,
				getQualifiedNameOf(badType),
				getQualifiedNameOf(rootVariable),
				getQualifiedNameOf(domain2));
		validationTest(expectedProblems);
	}

	public void testRelationDomain_EveryEnforceableVariableIsMatchedOrAssigned() {
		// TODO test the constraint
	}

	public void testRelationDomainAssignment_VariableDefinedByRelation() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		RelationalTransformation anotherTransformation = createRelationalTransformation(resource, "AnotherTestTransformation");
		TypedModel anotherTypedModel1 = createTypedModel(anotherTransformation, "AnotherTestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel anotherTypedModel2 = createTypedModel(anotherTransformation, "AnotherTestTypedModel2", EcorePackage.eINSTANCE);
		Relation anotherRelation = createRelation(anotherTransformation, "AnotherTestRelation");
		RelationDomain anotherDomain1 = createRelationDomain(anotherRelation, "AnotherTestDomain1", anotherTypedModel1, "AnotherRootVariable1", getBooleanType());
		createDomainPattern(anotherDomain1);
		RelationDomain anotherDomain2 = createRelationDomain(anotherRelation, "AnotherTestDomain2", anotherTypedModel2, "AnotherRootVariable2", getBooleanType());
		createDomainPattern(anotherDomain2);
		Variable anotherRootVariable = anotherDomain2.getRootVariable();
		createRelationDomainAssignment(domain1, anotherRootVariable, createBooleanLiteralExp(false));
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationDomainAssignment_VariableIsNotDefinedByRelation,
				getQualifiedNameOf(anotherRootVariable),
				getQualifiedNameOf(relation));
		validationTest(expectedProblems);
	}

	public void testRelationDomainAssignment_VariableTypeMatchesValueType() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		TypedModel typedModel1 = createTypedModel(transformation, "TestTypedModel1", EcorePackage.eINSTANCE);
		TypedModel typedModel2 = createTypedModel(transformation, "TestTypedModel2", EcorePackage.eINSTANCE);
		Relation relation = createRelation(transformation, "TestRelation");
		RelationDomain domain1 = createRelationDomain(relation, "TestDomain1", typedModel1, "RootVariable1", getStringType());
		createDomainPattern(domain1);
		RelationDomain domain2 = createRelationDomain(relation, "TestDomain2", typedModel2, "RootVariable2", getStringType());
		createDomainPattern(domain2);
		Variable rootVariable = domain2.getRootVariable();
		createRelationDomainAssignment(domain1, rootVariable, createBooleanLiteralExp(true));
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationDomainAssignment_VariableTypeMatchesValueType,
				getQualifiedNameOf(getStringType()),
				getQualifiedNameOf(rootVariable),
				getQualifiedNameOf(getBooleanType()));
		validationTest(expectedProblems);
	}

	public void testRelationImplementation_InDirectionOfIsDefinedByTransformation() {
		// TODO test the constraint
		// _UI_RelationImplementation_DirectionIsNotDefinedByTransformation
	}

	public void testRelationImplementation_EveryParameterTypeMatchesDomainRootVariableType() {
		// TODO test the constraint
	}
	
	public void testRelationalTransformation_KeysAreDistinct() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		createTypedModel(transformation, "ecore", EcorePackage.eINSTANCE);
		Key key1 = createKey(transformation, EcorePackage.Literals.ENAMED_ELEMENT, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		createKey(transformation, EcorePackage.Literals.EOPERATION, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		//
		validationTest(new ProblemLog());
		//
		createKey(transformation, EcorePackage.Literals.ENAMED_ELEMENT, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationalTransformation_KeyIsNotUnique,
				getQualifiedNameOf(key1.getIdentifies()));
		validationTest(expectedProblems);
	}

//	public void testRelationalTransformation_UniqueClassifierNames() {
//	}

	public void testRelationalTransformation_EveryRuleIsARelation() {
		RelationalTransformation transformation = createRelationalTransformation(resource, "TestTransformation");
		Rule rule = new RuleImpl() {};
		rule.setName("TestRule");
		transformation.getRule().add(rule);
		//
		ProblemLog expectedProblems = new ProblemLog();
		expectedProblems.expectValidatorError(QVTRelationValidator.INSTANCE, 
				QVTRelationMessages._UI_RelationalTransformation_RuleIsNotARelation,
				getQualifiedNameOf(rule));
		validationTest(expectedProblems);
	}
}
