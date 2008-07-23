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
 * $Id: QVTBaseValidator.java,v 1.1 2008/07/23 09:39:07 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

import org.eclipse.qvt.declarative.ecore.QVTBase.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage
 * @generated
 */
public class QVTBaseValidator extends EObjectValidator {
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
		return result;
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
		return result;
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
		boolean result = validate_EveryMultiplicityConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(rule, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateTypedModel_AcyclicDependsOn(typedModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AcyclicDependsOn constraint of '<em>Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedModel_AcyclicDependsOn(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "AcyclicDependsOn", getObjectLabel(typedModel, context) },
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

} //QVTBaseValidator
