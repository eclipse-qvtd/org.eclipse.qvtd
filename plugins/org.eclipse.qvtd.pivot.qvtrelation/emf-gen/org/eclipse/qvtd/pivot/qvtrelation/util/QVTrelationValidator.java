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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Matching Argument Count' of 'Relation Call Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RELATION_CALL_EXP__VALIDATE_MATCHING_ARGUMENT_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

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
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrelationValidator() {
		super();
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
		return validate_EveryDefaultConstraint(key, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relation, diagnostics, context);
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
		return validate_EveryDefaultConstraint(relationDomain, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomainAssignment(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relationDomainAssignment, diagnostics, context);
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
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateUniqueInvariantName(relationalTransformation, diagnostics, context);
		return result;
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
