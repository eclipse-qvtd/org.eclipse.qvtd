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
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Member Typeis Collection Element Type' of 'Collection Template Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_TEMPLATE_EXP__VALIDATE_MEMBER_TYPEIS_COLLECTION_ELEMENT_TYPE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Rest Typeis Collection Type' of 'Collection Template Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_TEMPLATE_EXP__VALIDATE_REST_TYPEIS_COLLECTION_TYPE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Typeis Collection Type' of 'Collection Template Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLECTION_TEMPLATE_EXP__VALIDATE_TYPEIS_COLLECTION_TYPE = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Part Property Is Unique' of 'Object Template Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_TEMPLATE_EXP__VALIDATE_PART_PROPERTY_IS_UNIQUE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Typeis Object Type' of 'Object Template Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OBJECT_TEMPLATE_EXP__VALIDATE_TYPEIS_OBJECT_TYPE = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Class For Property' of 'Property Template Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_TEMPLATE_ITEM__VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Object Value' of 'Property Template Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_TEMPLATE_ITEM__VALIDATE_COMPATIBLE_TYPE_FOR_OBJECT_VALUE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Collection Element Value' of 'Property Template Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_TEMPLATE_ITEM__VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_ELEMENT_VALUE = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Collection Value' of 'Property Template Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY_TEMPLATE_ITEM__VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_VALUE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Where Is Boolean' of 'Template Exp'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_EXP__VALIDATE_WHERE_IS_BOOLEAN = 10;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 10;

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
		if (result || diagnostics != null) result &= validateTemplateExp_validateWhereIsBoolean(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_validateMemberTypeisCollectionElementType(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_validateRestTypeisCollectionType(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_validateTypeisCollectionType(collectionTemplateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMemberTypeisCollectionElementType constraint of '<em>Collection Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionTemplateExp_validateMemberTypeisCollectionElementType(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return collectionTemplateExp.validateMemberTypeisCollectionElementType(diagnostics, context);
	}

	/**
	 * Validates the validateRestTypeisCollectionType constraint of '<em>Collection Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionTemplateExp_validateRestTypeisCollectionType(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return collectionTemplateExp.validateRestTypeisCollectionType(diagnostics, context);
	}

	/**
	 * Validates the validateTypeisCollectionType constraint of '<em>Collection Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionTemplateExp_validateTypeisCollectionType(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return collectionTemplateExp.validateTypeisCollectionType(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateTemplateExp_validateWhereIsBoolean(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateObjectTemplateExp_validatePartPropertyIsUnique(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateObjectTemplateExp_validateTypeisObjectType(objectTemplateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validatePartPropertyIsUnique constraint of '<em>Object Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectTemplateExp_validatePartPropertyIsUnique(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return objectTemplateExp.validatePartPropertyIsUnique(diagnostics, context);
	}

	/**
	 * Validates the validateTypeisObjectType constraint of '<em>Object Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectTemplateExp_validateTypeisObjectType(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return objectTemplateExp.validateTypeisObjectType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyTemplateItem(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyTemplateItem, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_validateCompatibleClassForProperty(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_validateCompatibleTypeForObjectValue(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_validateCompatibleTypeForCollectionElementValue(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_validateCompatibleTypeForCollectionValue(propertyTemplateItem, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleClassForProperty constraint of '<em>Property Template Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyTemplateItem_validateCompatibleClassForProperty(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyTemplateItem.validateCompatibleClassForProperty(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForObjectValue constraint of '<em>Property Template Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyTemplateItem_validateCompatibleTypeForObjectValue(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyTemplateItem.validateCompatibleTypeForObjectValue(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForCollectionElementValue constraint of '<em>Property Template Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyTemplateItem_validateCompatibleTypeForCollectionElementValue(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyTemplateItem.validateCompatibleTypeForCollectionElementValue(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForCollectionValue constraint of '<em>Property Template Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyTemplateItem_validateCompatibleTypeForCollectionValue(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return propertyTemplateItem.validateCompatibleTypeForCollectionValue(diagnostics, context);
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
		if (result || diagnostics != null) result &= validateTemplateExp_validateWhereIsBoolean(templateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateWhereIsBoolean constraint of '<em>Template Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateExp_validateWhereIsBoolean(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return templateExp.validateWhereIsBoolean(diagnostics, context);
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
