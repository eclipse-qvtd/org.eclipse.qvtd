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
 * $Id: QVTTemplateValidator.java,v 1.2 2008/10/30 06:10:44 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.*;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * @extends EValidatorWithOperations
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage
 * @generated
 */
public class QVTTemplateValidator extends EObjectValidator implements EValidatorWithOperations {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTTemplateValidator INSTANCE = new QVTTemplateValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvt.declarative.ecore.QVTTemplate";

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
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTTemplateValidator() {
		super();
		ecoreValidator = EcoreValidator.INSTANCE;
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
	  return QVTTemplatePackage.eINSTANCE;
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
			case QVTTemplatePackage.TEMPLATE_EXP:
				return validateTemplateExp((TemplateExp)value, diagnostics, context);
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP:
				return validateObjectTemplateExp((ObjectTemplateExp)value, diagnostics, context);
			case QVTTemplatePackage.COLLECTION_TEMPLATE_EXP:
				return validateCollectionTemplateExp((CollectionTemplateExp)value, diagnostics, context);
			case QVTTemplatePackage.PROPERTY_TEMPLATE_ITEM:
				return validatePropertyTemplateItem((PropertyTemplateItem)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateExp(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(templateExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectTemplateExp(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(objectTemplateExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionTemplateExp(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_MatchingKind(collectionTemplateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MatchingKind constraint of '<em>Collection Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionTemplateExp_MatchingKind(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 new Object[] { "MatchingKind", getObjectLabel(collectionTemplateExp, context) },
						 new Object[] { collectionTemplateExp },
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
	public boolean validatePropertyTemplateItem(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyTemplateItem, diagnostics, context);
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

} //QVTTemplateValidator
