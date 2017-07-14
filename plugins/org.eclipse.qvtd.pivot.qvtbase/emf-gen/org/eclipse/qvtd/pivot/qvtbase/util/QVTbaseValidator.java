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
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Typed Model Name' of 'Domain'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DOMAIN__VALIDATE_NAME_IS_TYPED_MODEL_NAME = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Typed Model Is Transformation Model Parameter' of 'Domain'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DOMAIN__VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parameters Are Function Parameter' of 'Function'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION__VALIDATE_PARAMETERS_ARE_FUNCTION_PARAMETER = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Return Type Is Query Type' of 'Function'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION__VALIDATE_RETURN_TYPE_IS_QUERY_TYPE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Condition Is Boolean' of 'Predicate'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PREDICATE__VALIDATE_CONDITION_IS_BOOLEAN = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Domain Name Is Unique' of 'Rule'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RULE__VALIDATE_DOMAIN_NAME_IS_UNIQUE = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Overrides Cycle' of 'Rule'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RULE__VALIDATE_NO_OVERRIDES_CYCLE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Overriding Rule Overrides All Domains' of 'Rule'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int RULE__VALIDATE_OVERRIDING_RULE_OVERRIDES_ALL_DOMAINS = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Context Type Is Transformation' of 'Transformation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSFORMATION__VALIDATE_CONTEXT_TYPE_IS_TRANSFORMATION = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Extended Typed Model Is Extended' of 'Transformation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSFORMATION__VALIDATE_EXTENDED_TYPED_MODEL_IS_EXTENDED = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Model Parameter Is Unique' of 'Transformation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSFORMATION__VALIDATE_MODEL_PARAMETER_IS_UNIQUE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate No Extends Cycle' of 'Transformation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TRANSFORMATION__VALIDATE_NO_EXTENDS_CYCLE = 12;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 12;

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
		if (!validate_NoCircularContainment(domain, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_validateNameIsTypedModelName(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_validateTypedModelIsTransformationModelParameter(domain, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameIsTypedModelName constraint of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain_validateNameIsTypedModelName(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return domain.validateNameIsTypedModelName(diagnostics, context);
	}

	/**
	 * Validates the validateTypedModelIsTransformationModelParameter constraint of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain_validateTypedModelIsTransformationModelParameter(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return domain.validateTypedModelIsTransformationModelParameter(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateFunction_validateParametersAreFunctionParameter(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_validateReturnTypeIsQueryType(function, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateParametersAreFunctionParameter constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_validateParametersAreFunctionParameter(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return function.validateParametersAreFunctionParameter(diagnostics, context);
	}

	/**
	 * Validates the validateReturnTypeIsQueryType constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_validateReturnTypeIsQueryType(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return function.validateReturnTypeIsQueryType(diagnostics, context);
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
		if (!validate_NoCircularContainment(predicate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validatePredicate_validateConditionIsBoolean(predicate, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateConditionIsBoolean constraint of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredicate_validateConditionIsBoolean(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return predicate.validateConditionIsBoolean(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateRule_validateDomainNameIsUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_validateNoOverridesCycle(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_validateOverridingRuleOverridesAllDomains(rule, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateDomainNameIsUnique constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_validateDomainNameIsUnique(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return rule.validateDomainNameIsUnique(diagnostics, context);
	}

	/**
	 * Validates the validateNoOverridesCycle constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_validateNoOverridesCycle(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return rule.validateNoOverridesCycle(diagnostics, context);
	}

	/**
	 * Validates the validateOverridingRuleOverridesAllDomains constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_validateOverridingRuleOverridesAllDomains(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return rule.validateOverridingRuleOverridesAllDomains(diagnostics, context);
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
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateNameIsNotNull(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateUniqueInvariantName(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_validateContextTypeIsTransformation(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_validateExtendedTypedModelIsExtended(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_validateModelParameterIsUnique(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_validateNoExtendsCycle(transformation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateContextTypeIsTransformation constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_validateContextTypeIsTransformation(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return transformation.validateContextTypeIsTransformation(diagnostics, context);
	}

	/**
	 * Validates the validateExtendedTypedModelIsExtended constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_validateExtendedTypedModelIsExtended(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return transformation.validateExtendedTypedModelIsExtended(diagnostics, context);
	}

	/**
	 * Validates the validateModelParameterIsUnique constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_validateModelParameterIsUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return transformation.validateModelParameterIsUnique(diagnostics, context);
	}

	/**
	 * Validates the validateNoExtendsCycle constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation_validateNoExtendsCycle(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return transformation.validateNoExtendsCycle(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedModel(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typedModel, diagnostics, context);
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
