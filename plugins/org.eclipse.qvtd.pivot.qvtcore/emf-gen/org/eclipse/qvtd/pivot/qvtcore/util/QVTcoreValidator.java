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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Opposite Property Is Implicit' of 'Opposite Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_ASSIGNMENT__VALIDATE_OPPOSITE_PROPERTY_IS_IMPLICIT = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Propety Is Slot Property' of 'Opposite Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPPOSITE_PROPERTY_ASSIGNMENT__VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Property Is Not Implicit' of 'Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ASSIGNMENT__VALIDATE_PROPERTY_IS_NOT_IMPLICIT = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Propety Is Slot Property' of 'Property Assignment'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_ASSIGNMENT__VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 4;

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
	public QVTcoreValidator() {
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
		return validate_EveryDefaultConstraint(bottomPattern, diagnostics, context);
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
		return validate_EveryDefaultConstraint(coreDomain, diagnostics, context);
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
		return validate_EveryDefaultConstraint(guardPattern, diagnostics, context);
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
		return validate_EveryDefaultConstraint(mapping, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateOppositePropertyAssignment_validateOppositePropertyIsImplicit(oppositePropertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyAssignment_validateTargetPropetyIsSlotProperty(oppositePropertyAssignment, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validatePropertyAssignment_validatePropertyIsNotImplicit(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAssignment_validateTargetPropetyIsSlotProperty(propertyAssignment, diagnostics, context);
		return result;
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
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableAssignment(VariableAssignment variableAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableAssignment, diagnostics, context);
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
