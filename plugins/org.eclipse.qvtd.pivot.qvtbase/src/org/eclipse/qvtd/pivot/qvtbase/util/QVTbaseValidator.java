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
package org.eclipse.qvtd.pivot.qvtbase.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.examples.pivot.util.PivotValidator;

import org.eclipse.qvtd.pivot.qvtbase.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage
 * @generated
 */
public class QVTbaseValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTbaseValidator INSTANCE = new QVTbaseValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvtd.pivot.qvtbase";

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
	protected PivotValidator pivotValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTbaseValidator() {
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
	  return QVTbasePackage.eINSTANCE;
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
			case QVTbasePackage.DOMAIN:
				return validateDomain((Domain)value, diagnostics, context);
			case QVTbasePackage.FUNCTION:
				return validateFunction((Function)value, diagnostics, context);
			case QVTbasePackage.FUNCTION_PARAMETER:
				return validateFunctionParameter((FunctionParameter)value, diagnostics, context);
			case QVTbasePackage.PATTERN:
				return validatePattern((Pattern)value, diagnostics, context);
			case QVTbasePackage.PREDICATE:
				return validatePredicate((Predicate)value, diagnostics, context);
			case QVTbasePackage.RULE:
				return validateRule((Rule)value, diagnostics, context);
			case QVTbasePackage.TRANSFORMATION:
				return validateTransformation((Transformation)value, diagnostics, context);
			case QVTbasePackage.TYPED_MODEL:
				return validateTypedModel((TypedModel)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(domain, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_TypedModelExistsWarning(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_TypedModelDefinedByTransformation(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_CheckableOrEnforceable(domain, diagnostics, context);
		return result;
	}

	/**
	 * Validates the TypedModelExistsWarning constraint of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain_TypedModelExistsWarning(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "TypedModelExistsWarning", getObjectLabel(domain, context) },
						 new Object[] { domain },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the TypedModelDefinedByTransformation constraint of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain_TypedModelDefinedByTransformation(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "TypedModelDefinedByTransformation", getObjectLabel(domain, context) },
						 new Object[] { domain },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the CheckableOrEnforceable constraint of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain_CheckableOrEnforceable(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "CheckableOrEnforceable", getObjectLabel(domain, context) },
						 new Object[] { domain },
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
	public boolean validateFunction(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(function, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateMultiplicityElement_validateLowerGe0(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateMultiplicityElement_validateUpperGeLower(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOperation_validateTestConstraint(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_IsSideEffectFree(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_EveryFunctionParameterIsAFunctionParameter(function, diagnostics, context);
		return result;
	}

	/**
	 * Validates the IsSideEffectFree constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_IsSideEffectFree(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "IsSideEffectFree", getObjectLabel(function, context) },
						 new Object[] { function },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the EveryFunctionParameterIsAFunctionParameter constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_EveryFunctionParameterIsAFunctionParameter(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "EveryFunctionParameterIsAFunctionParameter", getObjectLabel(function, context) },
						 new Object[] { function },
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
	public boolean validateFunctionParameter(FunctionParameter functionParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateMultiplicityElement_validateLowerGe0(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateMultiplicityElement_validateUpperGeLower(functionParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePattern(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(pattern, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validatePattern_NoVariableIsAFunctionParameter(pattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NoVariableIsAFunctionParameter constraint of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePattern_NoVariableIsAFunctionParameter(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "NoVariableIsAFunctionParameter", getObjectLabel(pattern, context) },
						 new Object[] { pattern },
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
	public boolean validatePredicate(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(predicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validatePredicate_ConditionExpressionIsBoolean(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validatePredicate_ExternalVariablesAreBoundByPattern(predicate, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ConditionExpressionIsBoolean constraint of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredicate_ConditionExpressionIsBoolean(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "ConditionExpressionIsBoolean", getObjectLabel(predicate, context) },
						 new Object[] { predicate },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ExternalVariablesAreBoundByPattern constraint of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredicate_ExternalVariablesAreBoundByPattern(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "ExternalVariablesAreBoundByPattern", getObjectLabel(predicate, context) },
						 new Object[] { predicate },
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
	public boolean validateRule(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(rule, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_OverridesIsCompatible(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_OverridesDefinedByTransformation(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_DomainNamesAreUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_DomainTypedModelsMatchModelParameters(rule, diagnostics, context);
		return result;
	}

	/**
	 * Validates the OverridesIsCompatible constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_OverridesIsCompatible(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "OverridesIsCompatible", getObjectLabel(rule, context) },
						 new Object[] { rule },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the OverridesDefinedByTransformation constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_OverridesDefinedByTransformation(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "OverridesDefinedByTransformation", getObjectLabel(rule, context) },
						 new Object[] { rule },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the DomainNamesAreUnique constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_DomainNamesAreUnique(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "DomainNamesAreUnique", getObjectLabel(rule, context) },
						 new Object[] { rule },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the DomainTypedModelsMatchModelParameters constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_DomainTypedModelsMatchModelParameters(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "DomainTypedModelsMatchModelParameters", getObjectLabel(rule, context) },
						 new Object[] { rule },
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
	public boolean validateTransformation(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(transformation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_WellFormedNsURI(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_WellFormedNsPrefix(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_UniqueNsURIs(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_ExtendsIsAcyclic(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_ModelParameterNamesAreCompatibleWithExtension(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_EveryModelParameterUsedPackagesIsCompatibleWithExtension(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_ModelParameterNamesAreUnique(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_RuleNamesAreUnique(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_SynthesizedTypesAreOwned(transformation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedNsURI constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_WellFormedNsURI(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "WellFormedNsURI", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the WellFormedNsPrefix constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_WellFormedNsPrefix(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "WellFormedNsPrefix", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the UniqueNsURIs constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_UniqueNsURIs(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "UniqueNsURIs", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ExtendsIsAcyclic constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_ExtendsIsAcyclic(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "ExtendsIsAcyclic", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ModelParameterNamesAreCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_ModelParameterNamesAreCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "ModelParameterNamesAreCompatibleWithExtension", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the EveryModelParameterUsedPackagesIsCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_EveryModelParameterUsedPackagesIsCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "EveryModelParameterUsedPackagesIsCompatibleWithExtension", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the ModelParameterNamesAreUnique constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_ModelParameterNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "ModelParameterNamesAreUnique", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the RuleNamesAreUnique constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_RuleNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "RuleNamesAreUnique", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the SynthesizedTypesAreOwned constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_SynthesizedTypesAreOwned(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "SynthesizedTypesAreOwned", getObjectLabel(transformation, context) },
						 new Object[] { transformation },
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
	public boolean validateTypedModel(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typedModel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedModel_DependsOnIsAcyclic(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedModel_DependsOnAreModelParameters(typedModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DependsOnIsAcyclic constraint of '<em>Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedModel_DependsOnIsAcyclic(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "DependsOnIsAcyclic", getObjectLabel(typedModel, context) },
						 new Object[] { typedModel },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the DependsOnAreModelParameters constraint of '<em>Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedModel_DependsOnAreModelParameters(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "DependsOnAreModelParameters", getObjectLabel(typedModel, context) },
						 new Object[] { typedModel },
						 context));
			}
			return false;
		}
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

} //QVTbaseValidator
