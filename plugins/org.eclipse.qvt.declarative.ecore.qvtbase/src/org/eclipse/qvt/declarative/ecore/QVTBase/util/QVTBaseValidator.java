/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
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
 * $Id: QVTBaseValidator.java,v 1.6 2009/01/27 21:17:57 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.DomainOperations;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.FunctionOperations;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.PatternOperations;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.PredicateOperations;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.RuleOperations;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.TransformationOperations;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.TypedModelOperations;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * @extends EValidatorWithOperations
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage
 * @generated
 */
public class QVTBaseValidator extends EObjectValidator implements EValidatorWithOperations {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTBaseValidator INSTANCE = new QVTBaseValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvt.declarative.ecore.QVTBase";

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
	protected EcoreValidator ecoreValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsValidator expressionsValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTBaseValidator() {
		super();
		ecoreValidator = EcoreValidator.INSTANCE;
		expressionsValidator = ExpressionsValidator.INSTANCE;
		ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
	}

	public String getDiagnosticSource() {
		return DIAGNOSTIC_SOURCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return QVTBasePackage.eINSTANCE;
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
			case QVTBasePackage.DOMAIN:
				return validateDomain((Domain)value, diagnostics, context);
			case QVTBasePackage.FUNCTION:
				return validateFunction((Function)value, diagnostics, context);
			case QVTBasePackage.FUNCTION_PARAMETER:
				return validateFunctionParameter((FunctionParameter)value, diagnostics, context);
			case QVTBasePackage.PATTERN:
				return validatePattern((Pattern)value, diagnostics, context);
			case QVTBasePackage.PREDICATE:
				return validatePredicate((Predicate)value, diagnostics, context);
			case QVTBasePackage.RULE:
				return validateRule((Rule)value, diagnostics, context);
			case QVTBasePackage.TRANSFORMATION:
				return validateTransformation((Transformation)value, diagnostics, context);
			case QVTBasePackage.TYPED_MODEL:
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
		boolean result = validate_EveryMultiplicityConforms(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(domain, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_TypedModelExistsWarning(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_TypedModelDefinedByTransformation(domain, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomain_CheckableOrEnforceable(domain, diagnostics, context);
		return result;
	}

	/**
	 * Validates the TypedModelExistsWarning constraint of '<em>Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateDomain_TypedModelExistsWarning(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return DomainOperations.INSTANCE.checkTypedModelExistsWarning(domain, diagnostics, context);
	}

	/**
	 * Validates the TypedModelDefinedByTransformation constraint of '<em>Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateDomain_TypedModelDefinedByTransformation(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return DomainOperations.INSTANCE.checkTypedModelDefinedByTransformation(domain, diagnostics, context);
	}

	/**
	 * Validates the CheckableOrEnforceable constraint of '<em>Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateDomain_CheckableOrEnforceable(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return DomainOperations.INSTANCE.checkCheckableOrEnforceable(domain, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueParameterNames(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueTypeParameterNames(function, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_NoRepeatingVoid(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_IsSideEffectFree(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_EveryFunctionParameterIsAFunctionParameter(function, diagnostics, context);
		return result;
	}

	/**
	 * Validates the IsSideEffectFree constraint of '<em>Function</em>'.
	 * @generated NOT
	 */
	public boolean validateFunction_IsSideEffectFree(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return FunctionOperations.INSTANCE.checkIsSideEffectFree(function, diagnostics, context);
	}

	/**
	 * Validates the EveryFunctionParameterIsAFunctionParameter constraint of '<em>Function</em>'.
	 * @generated NOT
	 */
	public boolean validateFunction_EveryFunctionParameterIsAFunctionParameter(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return FunctionOperations.INSTANCE.checkEveryFunctionParameterIsAFunctionParameter(function, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionParameter(FunctionParameter functionParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(functionParameter, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateVariable_checkInitType(functionParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePattern(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pattern, diagnostics, context);
		if (result || diagnostics != null) result &= validatePattern_NoVariableIsAFunctionParameter(pattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NoVariableIsAFunctionParameter constraint of '<em>Pattern</em>'.
	 * @generated NOT
	 */
	public boolean validatePattern_NoVariableIsAFunctionParameter(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PatternOperations.INSTANCE.checkNoVariableIsAFunctionParameter(pattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredicate(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(predicate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(predicate, diagnostics, context);
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
	 * @generated NOT
	 */
	public boolean validatePredicate_ConditionExpressionIsBoolean(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PredicateOperations.INSTANCE.checkConditionExpressionIsBoolean(predicate, diagnostics, context);
	}

	/**
	 * Validates the ExternalVariablesAreBoundByPattern constraint of '<em>Predicate</em>'.
	 * @generated NOT
	 */
	public boolean validatePredicate_ExternalVariablesAreBoundByPattern(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PredicateOperations.INSTANCE.checkExternalVariablesAreBoundByPattern(predicate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_OverridesIsCompatible(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_OverridesDefinedByTransformation(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_DomainNamesAreUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_DomainTypedModelsMatchModelParameters(rule, diagnostics, context);
		return result;
	}

	/**
	 * Validates the OverridesIsCompatible constraint of '<em>Rule</em>'.
	 * @generated NOT
	 */
	public boolean validateRule_OverridesIsCompatible(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;	// Overridding domain consistency ensured by domain.typedModel = modelParameters validation
	}

	/**
	 * Validates the OverridesDefinedByTransformation constraint of '<em>Rule</em>'.
	 * @generated NOT
	 */
	public boolean validateRule_OverridesDefinedByTransformation(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RuleOperations.INSTANCE.checkOverridesDefinedByTransformation(rule, diagnostics, context);
	}

	/**
	 * Validates the DomainNamesAreUnique constraint of '<em>Rule</em>'.
	 * @generated NOT
	 */
	public boolean validateRule_DomainNamesAreUnique(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RuleOperations.INSTANCE.checkDomainNamesAreUnique(rule, diagnostics, context);
	}

	/**
	 * Validates the DomainTypedModelsMatchModelParameters constraint of '<em>Rule</em>'.
	 * @generated NOT
	 */
	public boolean validateRule_DomainTypedModelsMatchModelParameters(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;	// Implementation is derived domain specific
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransformation(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_WellFormedNsURI(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateTransformation_WellFormedNsPrefix(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueSubpackageNames(transformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueClassifierNames(transformation, diagnostics, context);
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
	 * @generated NOT
	 */
	public boolean validateTransformation_WellFormedNsURI(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// EPackage's validation is not appropriate for transformation models
		return true;
	}

	/**
	 * Validates the WellFormedNsPrefix constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTransformation_WellFormedNsPrefix(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// EPackage's validation is not appropriate for transformation models
		return true;
	}

	/**
	 * Validates the UniqueNsURIs constraint of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTransformation_UniqueNsURIs(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// EPackage's validation is not appropriate for transformation models
		return true;
	}

	/**
	 * Validates the ExtendsIsAcyclic constraint of '<em>Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateTransformation_ExtendsIsAcyclic(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TransformationOperations.INSTANCE.checkExtendsIsAcyclic(transformation, diagnostics, context);
	}

	/**
	 * Validates the ModelParameterNamesAreCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateTransformation_ModelParameterNamesAreCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TransformationOperations.INSTANCE.checkModelParameterNamesAreCompatibleWithExtension(transformation, diagnostics, context);
	}

	/**
	 * Validates the EveryModelParameterUsedPackagesIsCompatibleWithExtension constraint of '<em>Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateTransformation_EveryModelParameterUsedPackagesIsCompatibleWithExtension(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TransformationOperations.INSTANCE.checkEveryModelParameterUsedPackagesIsCompatibleWithExtension(transformation, diagnostics, context);
	}

	/**
	 * Validates the ModelParameterNamesAreUnique constraint of '<em>Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateTransformation_ModelParameterNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TransformationOperations.INSTANCE.checkModelParameterNamesAreUnique(transformation, diagnostics, context);
	}

	/**
	 * Validates the RuleNamesAreUnique constraint of '<em>Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateTransformation_RuleNamesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TransformationOperations.INSTANCE.checkRuleNamesAreUnique(transformation, diagnostics, context);
	}

	/**
	 * Validates the SynthesizedTypesAreOwned constraint of '<em>Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateTransformation_SynthesizedTypesAreOwned(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TransformationOperations.INSTANCE.checkSynthesizedTypesAreOwned(transformation, diagnostics, context);
	}

	/**
	 * Validates the SynthesizedTypesAreUnique constraint of '<em>Transformation</em>'.
	 * @generated NOT
	 *
	public boolean validateTransformation_SynthesizedTypesAreUnique(Transformation transformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TransformationOperations.INSTANCE.checkSynthesizedTypesAreUnique(transformation, diagnostics, context);
	} */

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedModel(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedModel_DependsOnIsAcyclic(typedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypedModel_DependsOnAreModelParameters(typedModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DependsOnIsAcyclic constraint of '<em>Typed Model</em>'.
	 * @generated NOT
	 */
	public boolean validateTypedModel_DependsOnIsAcyclic(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TypedModelOperations.INSTANCE.checkDependsOnIsAcyclic(typedModel, diagnostics, context);
	}

	/**
	 * Validates the DependsOnAreModelParameters constraint of '<em>Typed Model</em>'.
	 * @generated NOT
	 */
	public boolean validateTypedModel_DependsOnAreModelParameters(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TypedModelOperations.INSTANCE.checkDependsOnAreModelParameters(typedModel, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
	    return QVTBasePlugin.INSTANCE;
	}

} //QVTBaseValidator
