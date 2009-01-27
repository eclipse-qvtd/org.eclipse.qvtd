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
 * $Id: QVTTemplateValidator.java,v 1.5 2009/01/27 21:17:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.operations.CollectionTemplateExpOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.operations.ObjectTemplateExpOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.operations.PropertyTemplateItemOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.operations.TemplateExpOperations;
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
		if (result || diagnostics != null) result &= validateTemplateExp_DomainExists(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_PatternExists(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_VariableIsBoundByPattern(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_VariableTypeIsDeclaredByDomain(templateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_WhereIsBoolean(templateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DomainExists constraint of '<em>Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateTemplateExp_DomainExists(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TemplateExpOperations.INSTANCE.checkDomainExists(templateExp, diagnostics, context);
	}

	/**
	 * Validates the PatternExists constraint of '<em>Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateTemplateExp_PatternExists(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TemplateExpOperations.INSTANCE.checkPatternExists(templateExp, diagnostics, context);
	}

	/**
	 * Validates the VariableIsBoundByPattern constraint of '<em>Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateTemplateExp_VariableIsBoundByPattern(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TemplateExpOperations.INSTANCE.checkVariableIsBoundByPattern(templateExp, diagnostics, context);
	}

	/**
	 * Validates the VariableTypeIsDeclaredByDomain constraint of '<em>Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateTemplateExp_VariableTypeIsDeclaredByDomain(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TemplateExpOperations.INSTANCE.checkVariableTypeIsDeclaredByDomain(templateExp, diagnostics, context);
	}

	/**
	 * Validates the WhereIsBoolean constraint of '<em>Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateTemplateExp_WhereIsBoolean(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return TemplateExpOperations.INSTANCE.checkWhereIsBoolean(templateExp, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateTemplateExp_DomainExists(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_PatternExists(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_VariableIsBoundByPattern(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_VariableTypeIsDeclaredByDomain(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_WhereIsBoolean(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateObjectTemplateExp_ReferredClassIsDeclaredByDomain(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateObjectTemplateExp_PartsAreUnique(objectTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateObjectTemplateExp_EveryEnforceablePartIsEnforced(objectTemplateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ReferredClassIsDeclaredByDomain constraint of '<em>Object Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateObjectTemplateExp_ReferredClassIsDeclaredByDomain(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ObjectTemplateExpOperations.INSTANCE.checkReferredClassIsDeclaredByDomain(objectTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the PartsAreUnique constraint of '<em>Object Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateObjectTemplateExp_PartsAreUnique(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ObjectTemplateExpOperations.INSTANCE.checkPartsAreUnique(objectTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the EveryEnforceablePartIsEnforced constraint of '<em>Object Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateObjectTemplateExp_EveryEnforceablePartIsEnforced(ObjectTemplateExp objectTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true; // TODO ObjectTemplateExpOperations.INSTANCE.checkEveryEnforceablePartIsEnforced(objectTemplateExp, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateTemplateExp_DomainExists(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_PatternExists(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_VariableIsBoundByPattern(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_VariableTypeIsDeclaredByDomain(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateExp_WhereIsBoolean(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_ReferredCollectionElementTypeIsDeclaredByDomain(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_EveryMemberTypeMatchesElementType(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_EveryMemberExpressionVariableIsBoundByPattern(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_RestTypeMatchesCollectionType(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_RestVariableIsBoundByPattern(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_MemberCountSatifiesLowerBound(collectionTemplateExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollectionTemplateExp_EveryEnforceableItemIsEnforced(collectionTemplateExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ReferredCollectionElementTypeIsDeclaredByDomain constraint of '<em>Collection Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateCollectionTemplateExp_ReferredCollectionElementTypeIsDeclaredByDomain(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return CollectionTemplateExpOperations.INSTANCE.checkReferredCollectionElementTypeIsDeclaredByDomain(collectionTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the EveryMemberTypeMatchesElementType constraint of '<em>Collection Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateCollectionTemplateExp_EveryMemberTypeMatchesElementType(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return CollectionTemplateExpOperations.INSTANCE.checkEveryMemberTypeMatchesElementType(collectionTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the EveryMemberExpressionVariableIsBoundByPattern constraint of '<em>Collection Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateCollectionTemplateExp_EveryMemberExpressionVariableIsBoundByPattern(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return CollectionTemplateExpOperations.INSTANCE.checkEveryMemberExpressionVariableIsBoundByPattern(collectionTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the RestTypeMatchesCollectionType constraint of '<em>Collection Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateCollectionTemplateExp_RestTypeMatchesCollectionType(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return CollectionTemplateExpOperations.INSTANCE.checkRestTypeMatchesCollectionType(collectionTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the MemberCountSatifiesLowerBound constraint of '<em>Collection Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateCollectionTemplateExp_MemberCountSatifiesLowerBound(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return CollectionTemplateExpOperations.INSTANCE.checkMemberCountSatifiesLowerBound(collectionTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the RestVariableIsBoundByPattern constraint of '<em>Collection Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateCollectionTemplateExp_RestVariableIsBoundByPattern(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return CollectionTemplateExpOperations.INSTANCE.checkRestVariableIsBoundByPattern(collectionTemplateExp, diagnostics, context);
	}

	/**
	 * Validates the EveryEnforceableItemIsEnforced constraint of '<em>Collection Template Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateCollectionTemplateExp_EveryEnforceableItemIsEnforced(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true; // TODO CollectionTemplateExpOperations.INSTANCE.checkEveryEnforceableItemIsEnforced(collectionTemplateExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyTemplateItem(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_ReferredPropertyIsDefinedByReferredClass(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_ValueElementTypeMatchesReferredPropertyElementType(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_EveryExpressionVariableIsBoundByPattern(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_ObjectTypeMatchesPropertyType(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_CollectionElementTypeMatchesPropertyType(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_SetMatchesSet(propertyTemplateItem, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyTemplateItem_NonBagMatchesNonBag(propertyTemplateItem, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ReferredPropertyIsDefinedByReferredClass constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_ReferredPropertyIsDefinedByReferredClass(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PropertyTemplateItemOperations.INSTANCE.checkReferredPropertyIsDefinedByReferredClass(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Validates the ValueElementTypeMatchesReferredPropertyElementType constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_ValueElementTypeMatchesReferredPropertyElementType(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PropertyTemplateItemOperations.INSTANCE.checkValueElementTypeMatchesReferredPropertyElementType(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Validates the EveryExpressionVariableIsBoundByPattern constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_EveryExpressionVariableIsBoundByPattern(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PropertyTemplateItemOperations.INSTANCE.checkEveryExpressionVariableIsBoundByPattern(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Validates the ObjectTypeMatchesPropertyType constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_ObjectTypeMatchesPropertyType(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PropertyTemplateItemOperations.INSTANCE.checkObjectTypeMatchesPropertyType(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Validates the CollectionElementTypeMatchesPropertyType constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_CollectionElementTypeMatchesPropertyType(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PropertyTemplateItemOperations.INSTANCE.checkCollectionElementTypeMatchesPropertyType(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Validates the SetMatchesSet constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_SetMatchesSet(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PropertyTemplateItemOperations.INSTANCE.checkSetMatchesSet(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Validates the NonBagMatchesNonBag constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_NonBagMatchesNonBag(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return PropertyTemplateItemOperations.INSTANCE.checkNonBagMatchesNonBag(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Validates the SimpleVariableIsBoundByPattern constraint of '<em>Property Template Item</em>'.
	 * @generated NOT
	 */
	public boolean validatePropertyTemplateItem_SimpleVariableIsBoundByPattern(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true; // TODO probably redundant PropertyTemplateItemOperations.INSTANCE.checkSimpleVariableIsBoundByPattern(propertyTemplateItem, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return QVTTemplatePlugin.INSTANCE;
	}

} //QVTTemplateValidator
