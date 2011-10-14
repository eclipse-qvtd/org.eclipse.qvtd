/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvtcore.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

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
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

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
	protected QVTbaseValidator qvTbaseValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreValidator() {
		super();
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
			case QVTcorePackage.CORE_DOMAIN:
				return validateCoreDomain((CoreDomain)value, diagnostics, context);
			case QVTcorePackage.CORE_PATTERN:
				return validateCorePattern((CorePattern)value, diagnostics, context);
			case QVTcorePackage.ENFORCEMENT_OPERATION:
				return validateEnforcementOperation((EnforcementOperation)value, diagnostics, context);
			case QVTcorePackage.GUARD_PATTERN:
				return validateGuardPattern((GuardPattern)value, diagnostics, context);
			case QVTcorePackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
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
		if (!validate_NoCircularContainment(assignment, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignment_MappingIsEnforceable(assignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MappingIsEnforceable constraint of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment_MappingIsEnforceable(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "MappingIsEnforceable", getObjectLabel(assignment, context) },
						 new Object[] { assignment },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= qvTbaseValidator.validatePattern_NoVariableIsAFunctionParameter(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorePattern_VariableNamesAreUnique(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateBottomPattern_RealizedVariableNamesAreUnique(bottomPattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RealizedVariableNamesAreUnique constraint of '<em>Bottom Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBottomPattern_RealizedVariableNamesAreUnique(BottomPattern bottomPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "RealizedVariableNamesAreUnique", getObjectLabel(bottomPattern, context) },
						 new Object[] { bottomPattern },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= qvTbaseValidator.validateDomain_TypedModelExistsWarning(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateDomain_TypedModelDefinedByTransformation(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateDomain_CheckableOrEnforceable(coreDomain, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorePattern(CorePattern corePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(corePattern, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validatePattern_NoVariableIsAFunctionParameter(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorePattern_VariableNamesAreUnique(corePattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the VariableNamesAreUnique constraint of '<em>Core Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorePattern_VariableNamesAreUnique(CorePattern corePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "VariableNamesAreUnique", getObjectLabel(corePattern, context) },
						 new Object[] { corePattern },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= qvTbaseValidator.validatePattern_NoVariableIsAFunctionParameter(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorePattern_VariableNamesAreUnique(guardPattern, diagnostics, context);
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
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_OverridesIsCompatible(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_OverridesDefinedByTransformation(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_DomainNamesAreUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_DomainTypedModelsMatchModelParameters(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_WellFormedName(mapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_WellFormedName(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "WellFormedName", getObjectLabel(mapping, context) },
						 new Object[] { mapping },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the DomainTypedModelsMatchModelParameters constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_DomainTypedModelsMatchModelParameters(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO override the constraint, if desired
		// -> uncomment the scaffolding
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "DomainTypedModelsMatchModelParameters", getObjectLabel(mapping, context) },
						 new Object[] { mapping },
						 context));
			}
			return false;
		}
		return qvTbaseValidator.validateRule_DomainTypedModelsMatchModelParameters(mapping, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateAssignment_MappingIsEnforceable(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAssignment_TypeIsConsistent(propertyAssignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the TypeIsConsistent constraint of '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssignment_TypeIsConsistent(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "TypeIsConsistent", getObjectLabel(propertyAssignment, context) },
						 new Object[] { propertyAssignment },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= validateRealizedVariable_MappingIsEnforceable(realizedVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MappingIsEnforceable constraint of '<em>Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealizedVariable_MappingIsEnforceable(RealizedVariable realizedVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "MappingIsEnforceable", getObjectLabel(realizedVariable, context) },
						 new Object[] { realizedVariable },
						 context));
			}
			return false;
		}
		return true;
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
		if (result || diagnostics != null) result &= validateAssignment_MappingIsEnforceable(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableAssignment_TypeIsConsistent(variableAssignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the TypeIsConsistent constraint of '<em>Variable Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableAssignment_TypeIsConsistent(VariableAssignment variableAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "TypeIsConsistent", getObjectLabel(variableAssignment, context) },
						 new Object[] { variableAssignment },
						 context));
			}
			return false;
		}
		return true;
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
