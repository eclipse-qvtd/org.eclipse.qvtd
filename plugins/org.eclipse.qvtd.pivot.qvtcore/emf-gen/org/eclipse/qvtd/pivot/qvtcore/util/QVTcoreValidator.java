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
package org.eclipse.qvtd.pivot.qvtcore.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.pivot.util.PivotValidator;

import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseValidator;
import org.eclipse.qvtd.pivot.qvtcore.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage
 * @generated
 */
public class QVTcoreValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTcoreValidator INSTANCE = new QVTcoreValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvtd.pivot.qvtcore";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Variables Are Bottom Variables' of 'Bottom Pattern'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BOTTOM_PATTERN__VALIDATE_VARIABLES_ARE_BOTTOM_VARIABLES = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Variables Are Guard Variables' of 'Guard Pattern'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int GUARD_PATTERN__VALIDATE_VARIABLES_ARE_GUARD_VARIABLES = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Domains Are Core Domains' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_DOMAINS_ARE_CORE_DOMAINS = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Nested Name Is Null' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_NESTED_NAME_IS_NULL = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Root Name Is Not Null' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_ROOT_NAME_IS_NOT_NULL = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Partial Value' of 'Opposite Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_ASSIGNMENT__VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Total Value' of 'Opposite Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_ASSIGNMENT__VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Opposite Property Is Implicit' of 'Opposite Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_ASSIGNMENT__VALIDATE_OPPOSITE_PROPERTY_IS_IMPLICIT = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Propety Is Slot Property' of 'Opposite Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_ASSIGNMENT__VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Partial Value' of 'Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ASSIGNMENT__VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Total Value' of 'Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ASSIGNMENT__VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Property Is Not Implicit' of 'Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ASSIGNMENT__VALIDATE_PROPERTY_IS_NOT_IMPLICIT = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Propety Is Slot Property' of 'Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ASSIGNMENT__VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Non Data Type For Type' of 'Realized Variable'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REALIZED_VARIABLE__VALIDATE_NON_DATA_TYPE_FOR_TYPE = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Value' of 'Variable Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int VARIABLE_ASSIGNMENT__VALIDATE_COMPATIBLE_TYPE_FOR_VALUE = 15;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 15;

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
	public QVTcoreValidator() {
		super();
		pivotValidator = PivotValidator.INSTANCE;
		qvTbaseValidator = QVTbaseValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return QVTcorePackage.eINSTANCE;
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
			case QVTcorePackage.AREA:
				return validateArea((Area)value, diagnostics, context);
			case QVTcorePackage.ASSIGNMENT:
				return validateAssignment((Assignment)value, diagnostics, context);
			case QVTcorePackage.BOTTOM_PATTERN:
				return validateBottomPattern((BottomPattern)value, diagnostics, context);
			case QVTcorePackage.BOTTOM_VARIABLE:
				return validateBottomVariable((BottomVariable)value, diagnostics, context);
			case QVTcorePackage.CORE_DOMAIN:
				return validateCoreDomain((CoreDomain)value, diagnostics, context);
			case QVTcorePackage.CORE_MODEL:
				return validateCoreModel((CoreModel)value, diagnostics, context);
			case QVTcorePackage.CORE_PATTERN:
				return validateCorePattern((CorePattern)value, diagnostics, context);
			case QVTcorePackage.ENFORCEMENT_OPERATION:
				return validateEnforcementOperation((EnforcementOperation)value, diagnostics, context);
			case QVTcorePackage.GUARD_PATTERN:
				return validateGuardPattern((GuardPattern)value, diagnostics, context);
			case QVTcorePackage.GUARD_VARIABLE:
				return validateGuardVariable((GuardVariable)value, diagnostics, context);
			case QVTcorePackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
			case QVTcorePackage.NAVIGATION_ASSIGNMENT:
				return validateNavigationAssignment((NavigationAssignment)value, diagnostics, context);
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT:
				return validateOppositePropertyAssignment((OppositePropertyAssignment)value, diagnostics, context);
			case QVTcorePackage.PROPERTY_ASSIGNMENT:
				return validatePropertyAssignment((PropertyAssignment)value, diagnostics, context);
			case QVTcorePackage.REALIZED_VARIABLE:
				return validateRealizedVariable((RealizedVariable)value, diagnostics, context);
			case QVTcorePackage.VARIABLE_ASSIGNMENT:
				return validateVariableAssignment((VariableAssignment)value, diagnostics, context);
			case QVTcorePackage.ENFORCEMENT_MODE:
				return validateEnforcementMode((EnforcementMode)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArea(Area area, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(area, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assignment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBottomPattern(BottomPattern bottomPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(bottomPattern, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateBottomPattern_validateVariablesAreBottomVariables(bottomPattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateVariablesAreBottomVariables constraint of '<em>Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBottomPattern_validateVariablesAreBottomVariables(BottomPattern bottomPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return bottomPattern.validateVariablesAreBottomVariables(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBottomVariable(BottomVariable bottomVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(bottomVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(bottomVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariable_validateCompatibleInitialiserType(bottomVariable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoreDomain(CoreDomain coreDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(coreDomain, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateDomain_validateNameIsTypedModelName(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateDomain_validateTypedModelIsTransformationModelParameter(coreDomain, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoreModel(CoreModel coreModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(coreModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorePattern(CorePattern corePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(corePattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnforcementOperation(EnforcementOperation enforcementOperation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enforcementOperation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardPattern(GuardPattern guardPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(guardPattern, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateGuardPattern_validateVariablesAreGuardVariables(guardPattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateVariablesAreGuardVariables constraint of '<em>Guard Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardPattern_validateVariablesAreGuardVariables(GuardPattern guardPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return guardPattern.validateVariablesAreGuardVariables(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardVariable(GuardVariable guardVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(guardVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(guardVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariable_validateCompatibleInitialiserType(guardVariable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateDomainNameIsUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateNoOverridesCycle(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateOverridesRuleIsExtendedRule(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateOverridesRuleOverridesAllDomains(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateDomainsAreCoreDomains(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateNestedNameIsNull(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateRootNameIsNotNull(mapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDomainsAreCoreDomains constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateDomainsAreCoreDomains(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateDomainsAreCoreDomains(diagnostics, context);
	}

	/**
	 * Validates the validateNestedNameIsNull constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateNestedNameIsNull(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateNestedNameIsNull(diagnostics, context);
	}

	/**
	 * Validates the validateRootNameIsNotNull constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateRootNameIsNotNull(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateRootNameIsNotNull(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNavigationAssignment(NavigationAssignment navigationAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(navigationAssignment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyAssignment(OppositePropertyAssignment oppositePropertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(oppositePropertyAssignment, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyAssignment_validateCompatibleTypeForPartialValue(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyAssignment_validateCompatibleTypeForTotalValue(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyAssignment_validateOppositePropertyIsImplicit(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyAssignment_validateTargetPropetyIsSlotProperty(oppositePropertyAssignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForPartialValue constraint of '<em>Opposite Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyAssignment_validateCompatibleTypeForPartialValue(OppositePropertyAssignment oppositePropertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return oppositePropertyAssignment.validateCompatibleTypeForPartialValue(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForTotalValue constraint of '<em>Opposite Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyAssignment_validateCompatibleTypeForTotalValue(OppositePropertyAssignment oppositePropertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return oppositePropertyAssignment.validateCompatibleTypeForTotalValue(diagnostics, context);
	}

	/**
	 * Validates the validateOppositePropertyIsImplicit constraint of '<em>Opposite Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyAssignment_validateOppositePropertyIsImplicit(OppositePropertyAssignment oppositePropertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return oppositePropertyAssignment.validateOppositePropertyIsImplicit(diagnostics, context);
	}

	/**
	 * Validates the validateTargetPropetyIsSlotProperty constraint of '<em>Opposite Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyAssignment_validateTargetPropetyIsSlotProperty(OppositePropertyAssignment oppositePropertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return oppositePropertyAssignment.validateTargetPropetyIsSlotProperty(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssignment(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyAssignment, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAssignment_validateCompatibleTypeForPartialValue(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAssignment_validateCompatibleTypeForTotalValue(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAssignment_validatePropertyIsNotImplicit(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAssignment_validateTargetPropetyIsSlotProperty(propertyAssignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForPartialValue constraint of '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssignment_validateCompatibleTypeForPartialValue(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAssignment.validateCompatibleTypeForPartialValue(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForTotalValue constraint of '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssignment_validateCompatibleTypeForTotalValue(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAssignment.validateCompatibleTypeForTotalValue(diagnostics, context);
	}

	/**
	 * Validates the validatePropertyIsNotImplicit constraint of '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssignment_validatePropertyIsNotImplicit(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAssignment.validatePropertyIsNotImplicit(diagnostics, context);
	}

	/**
	 * Validates the validateTargetPropetyIsSlotProperty constraint of '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssignment_validateTargetPropetyIsSlotProperty(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyAssignment.validateTargetPropetyIsSlotProperty(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealizedVariable(RealizedVariable realizedVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(realizedVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariable_validateCompatibleInitialiserType(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateRealizedVariable_validateNonDataTypeForType(realizedVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNonDataTypeForType constraint of '<em>Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealizedVariable_validateNonDataTypeForType(RealizedVariable realizedVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return realizedVariable.validateNonDataTypeForType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableAssignment(VariableAssignment variableAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableAssignment, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableAssignment_validateCompatibleTypeForValue(variableAssignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForValue constraint of '<em>Variable Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableAssignment_validateCompatibleTypeForValue(VariableAssignment variableAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return variableAssignment.validateCompatibleTypeForValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnforcementMode(EnforcementMode enforcementMode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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

} //QVTcoreValidator
