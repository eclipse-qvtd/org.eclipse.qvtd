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
package org.eclipse.qvtd.pivot.qvttemplate.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.qvtd.pivot.qvttemplate.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage
 * @generated
 */
public class QVTtemplateValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTtemplateValidator INSTANCE = new QVTtemplateValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvtd.pivot.qvttemplate";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Is True' of 'Template Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_EXP__VALIDATE_IS_TRUE = 1;

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
	public QVTtemplateValidator() {
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
	  return QVTtemplatePackage.eINSTANCE;
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
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP:
				return validateCollectionTemplateExp((CollectionTemplateExp)value, diagnostics, context);
			case QVTtemplatePackage.OBJECT_TEMPLATE_EXP:
				return validateObjectTemplateExp((ObjectTemplateExp)value, diagnostics, context);
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM:
				return validatePropertyTemplateItem((PropertyTemplateItem)value, diagnostics, context);
			case QVTtemplatePackage.TEMPLATE_EXP:
				return validateTemplateExp((TemplateExp)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionTemplateExp(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionTemplateExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOCLExpression_validateTypeIsNotNull(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_validateIsTrue(collectionTemplateExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectTemplateExp(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(objectTemplateExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOCLExpression_validateTypeIsNotNull(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_validateIsTrue(objectTemplateExp, diagnostics, context);
		return result;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateExp(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(templateExp, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateOCLExpression_validateTypeIsNotNull(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_validateIsTrue(templateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateIsTrue constraint of '<em>Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateExp_validateIsTrue(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return templateExp.validateIsTrue(diagnostics, context);
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

} //QVTtemplateValidator
