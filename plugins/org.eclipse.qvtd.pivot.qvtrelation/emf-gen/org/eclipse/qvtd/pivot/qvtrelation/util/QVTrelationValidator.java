/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtrelation.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.pivot.util.PivotValidator;

import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseValidator;
import org.eclipse.qvtd.pivot.qvtrelation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage
 * @generated
 */
public class QVTrelationValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTrelationValidator INSTANCE = new QVTrelationValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvtd.pivot.qvtrelation";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Identifies Is Not Abstract' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Identifies Is AUsed Package Class' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Super Keys' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_NO_SUPER_KEYS = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Identifies Is Unique' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_IDENTIFIES_IS_UNIQUE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Opposite Parts Have Opposites' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Opposite Parts Are Opposite Parts' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parts Are Parts' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_PARTS_ARE_PARTS = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parts Are Unique' of 'Key'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int KEY__VALIDATE_PARTS_ARE_UNIQUE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Domains Are Relation Domains' of 'Relation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATION__VALIDATE_DOMAINS_ARE_RELATION_DOMAINS = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Transformation Is Relational Transformation' of 'Relation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATION__VALIDATE_TRANSFORMATION_IS_RELATIONAL_TRANSFORMATION = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Matching Argument Count' of 'Relation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATION_CALL_EXP__VALIDATE_MATCHING_ARGUMENT_COUNT = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Relation Domain Assignments Are Unique' of 'Relation Domain'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATION_DOMAIN__VALIDATE_RELATION_DOMAIN_ASSIGNMENTS_ARE_UNIQUE = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Value' of 'Relation Domain Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATION_DOMAIN_ASSIGNMENT__VALIDATE_COMPATIBLE_TYPE_FOR_VALUE = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Rules Are Relations' of 'Relational Transformation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATIONAL_TRANSFORMATION__VALIDATE_RULES_ARE_RELATIONS = 14;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 14;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PivotValidator pivotValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTbaseValidator qvTbaseValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrelationValidator() {
		super();
		qvTbaseValidator = QVTbaseValidator.INSTANCE;
		pivotValidator = PivotValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return QVTrelationPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case QVTrelationPackage.DOMAIN_PATTERN:
				return validateDomainPattern((DomainPattern)value, diagnostics, context);
			case QVTrelationPackage.KEY:
				return validateKey((Key)value, diagnostics, context);
			case QVTrelationPackage.RELATION:
				return validateRelation((Relation)value, diagnostics, context);
			case QVTrelationPackage.RELATION_CALL_EXP:
				return validateRelationCallExp((RelationCallExp)value, diagnostics, context);
			case QVTrelationPackage.RELATION_DOMAIN:
				return validateRelationDomain((RelationDomain)value, diagnostics, context);
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT:
				return validateRelationDomainAssignment((RelationDomainAssignment)value, diagnostics, context);
			case QVTrelationPackage.RELATION_IMPLEMENTATION:
				return validateRelationImplementation((RelationImplementation)value, diagnostics, context);
			case QVTrelationPackage.RELATION_MODEL:
				return validateRelationModel((RelationModel)value, diagnostics, context);
			case QVTrelationPackage.RELATIONAL_TRANSFORMATION:
				return validateRelationalTransformation((RelationalTransformation)value, diagnostics, context);
			case QVTrelationPackage.SHARED_VARIABLE:
				return validateSharedVariable((SharedVariable)value, diagnostics, context);
			case QVTrelationPackage.TEMPLATE_VARIABLE:
				return validateTemplateVariable((TemplateVariable)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomainPattern(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(domainPattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(key, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validateIdentifiesIsNotAbstract(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validateIdentifiesIsAUsedPackageClass(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validateNoSuperKeys(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validateIdentifiesIsUnique(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validateOppositePartsHaveOpposites(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validateOppositePartsAreOppositeParts(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validatePartsAreParts(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_validatePartsAreUnique(key, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateIdentifiesIsNotAbstract constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validateIdentifiesIsNotAbstract(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validateIdentifiesIsNotAbstract(diagnostics, context);
	}

	/**
	 * Validates the validateIdentifiesIsAUsedPackageClass constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validateIdentifiesIsAUsedPackageClass(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validateIdentifiesIsAUsedPackageClass(diagnostics, context);
	}

	/**
	 * Validates the validateNoSuperKeys constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validateNoSuperKeys(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validateNoSuperKeys(diagnostics, context);
	}

	/**
	 * Validates the validateIdentifiesIsUnique constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validateIdentifiesIsUnique(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validateIdentifiesIsUnique(diagnostics, context);
	}

	/**
	 * Validates the validateOppositePartsHaveOpposites constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validateOppositePartsHaveOpposites(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validateOppositePartsHaveOpposites(diagnostics, context);
	}

	/**
	 * Validates the validateOppositePartsAreOppositeParts constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validateOppositePartsAreOppositeParts(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validateOppositePartsAreOppositeParts(diagnostics, context);
	}

	/**
	 * Validates the validatePartsAreParts constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validatePartsAreParts(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validatePartsAreParts(diagnostics, context);
	}

	/**
	 * Validates the validatePartsAreUnique constraint of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey_validatePartsAreUnique(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return key.validatePartsAreUnique(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateDomainNameIsUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateOverridesRuleIsExtendedRule(relation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateOverridesRuleOverridesAllDomains(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_validateDomainsAreRelationDomains(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_validateTransformationIsRelationalTransformation(relation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDomainsAreRelationDomains constraint of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation_validateDomainsAreRelationDomains(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relation.validateDomainsAreRelationDomains(diagnostics, context);
	}

	/**
	 * Validates the validateTransformationIsRelationalTransformation constraint of '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation_validateTransformationIsRelationalTransformation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relation.validateTransformationIsRelationalTransformation(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationCallExp(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationCallExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOCLExpression_validateTypeIsNotNull(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_validateMatchingArgumentCount(relationCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMatchingArgumentCount constraint of '<em>Relation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationCallExp_validateMatchingArgumentCount(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationCallExp.validateMatchingArgumentCount(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomain(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationDomain, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateDomain_validateNameIsTypedModelName(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateDomain_validateTypedModelIsTransformationModelParameter(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_validateRelationDomainAssignmentsAreUnique(relationDomain, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateRelationDomainAssignmentsAreUnique constraint of '<em>Relation Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomain_validateRelationDomainAssignmentsAreUnique(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationDomain.validateRelationDomainAssignmentsAreUnique(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomainAssignment(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationDomainAssignment, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomainAssignment_validateCompatibleTypeForValue(relationDomainAssignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForValue constraint of '<em>Relation Domain Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomainAssignment_validateCompatibleTypeForValue(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationDomainAssignment.validateCompatibleTypeForValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationImplementation(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relationImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationModel(RelationModel relationModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relationModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalTransformation(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(relationalTransformation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateNameIsNotNull(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateUniqueInvariantName(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateTransformation_validateContextTypeIsTransformation(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateTransformation_validateExtendedTypedModelIsExtended(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateTransformation_validateModelParameterIsUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalTransformation_validateRulesAreRelations(relationalTransformation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateRulesAreRelations constraint of '<em>Relational Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalTransformation_validateRulesAreRelations(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return relationalTransformation.validateRulesAreRelations(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSharedVariable(SharedVariable sharedVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sharedVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(sharedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariable_validateCompatibleInitialiserType(sharedVariable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateVariable(TemplateVariable templateVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(templateVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(templateVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariable_validateCompatibleInitialiserType(templateVariable, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //QVTrelationValidator
