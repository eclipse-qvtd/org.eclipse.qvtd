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
package org.eclipse.qvtd.pivot.qvtbase.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.pivot.util.PivotValidator;

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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is True' of 'Typed Model'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TYPED_MODEL__VALIDATE_IS_TRUE = 1;

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
			case QVTbasePackage.BASE_MODEL:
				return validateBaseModel((BaseModel)value, diagnostics, context);
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
	public boolean validateBaseModel(BaseModel baseModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(baseModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(domain, diagnostics, context);
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
		if (result || diagnostics != null) result &= pivotValidator.validateFeature_validateNameIsNotNull(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateFeature_validateTypeIsNotInvalid(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateFeature_validateTypeIsNotNull(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOperation_validateCompatibleReturn(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOperation_validateLoadableImplementation(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOperation_validateUniquePostconditionName(function, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOperation_validateUniquePreconditionName(function, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(functionParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePattern(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredicate(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(predicate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(rule, diagnostics, context);
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
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateUniqueInvariantName(transformation, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateTypedModel_validateIsTrue(typedModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateIsTrue constraint of '<em>Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedModel_validateIsTrue(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return typedModel.validateIsTrue(diagnostics, context);
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
