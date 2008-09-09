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
 * $Id: QVTRelationValidator.java,v 1.3 2008/09/09 20:59:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.KeyOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.RelationalTransformationOperations;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage
 * @generated NOT
 */
public class QVTRelationValidator extends EObjectValidator implements EValidatorWithOperations {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTRelationValidator INSTANCE = new QVTRelationValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvt.declarative.ecore.QVTRelation";

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
	protected QVTBaseValidator qvtBaseValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTRelationValidator() {
		super();
		ecoreValidator = EcoreValidator.INSTANCE;
		ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
		expressionsValidator = ExpressionsValidator.INSTANCE;
		qvtBaseValidator = QVTBaseValidator.INSTANCE;
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
	  return QVTRelationPackage.eINSTANCE;
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
			case QVTRelationPackage.DOMAIN_PATTERN:
				return validateDomainPattern((DomainPattern)value, diagnostics, context);
			case QVTRelationPackage.KEY:
				return validateKey((Key)value, diagnostics, context);
			case QVTRelationPackage.OPPOSITE_PROPERTY_CALL_EXP:
				return validateOppositePropertyCallExp((OppositePropertyCallExp)value, diagnostics, context);
			case QVTRelationPackage.RELATION:
				return validateRelation((Relation)value, diagnostics, context);
			case QVTRelationPackage.RELATION_DOMAIN:
				return validateRelationDomain((RelationDomain)value, diagnostics, context);
			case QVTRelationPackage.RELATION_DOMAIN_ASSIGNMENT:
				return validateRelationDomainAssignment((RelationDomainAssignment)value, diagnostics, context);
			case QVTRelationPackage.RELATION_IMPLEMENTATION:
				return validateRelationImplementation((RelationImplementation)value, diagnostics, context);
			case QVTRelationPackage.RELATION_CALL_EXP:
				return validateRelationCallExp((RelationCallExp)value, diagnostics, context);
			case QVTRelationPackage.RELATIONAL_TRANSFORMATION:
				return validateRelationalTransformation((RelationalTransformation)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomainPattern(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(domainPattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_AtLeastOnePart(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_PartSourceIsIdentifiedClass(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_OppositePartTargetIsIdentifiedClass(key, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AtLeastOnePart constraint of '<em>Key</em>'.
	 * @generated NOT
	 */
	public boolean validateKey_AtLeastOnePart(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return KeyOperations.INSTANCE.checkAtLeastOnePart(key, diagnostics, context);
	}

	/**
	 * Validates the PartSourceIsIdentifiedClass constraint of '<em>Key</em>'.
	 * @generated NOT
	 */
	public boolean validateKey_PartSourceIsIdentifiedClass(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return KeyOperations.INSTANCE.checkPartSourceIsIdentifiedClass(key, diagnostics, context);
	}

	/**
	 * Validates the OppositePartTargetIsIdentifiedClass constraint of '<em>Key</em>'.
	 * @generated NOT
	 */
	public boolean validateKey_OppositePartTargetIsIdentifiedClass(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return KeyOperations.INSTANCE.checkOppositePartTargetIsIdentifiedClass(key, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyCallExp(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validatePropertyCallExp_checkPropertyType(oppositePropertyCallExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(relation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomain(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_WellFormedName(relationDomain, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Relation Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateRelationDomain_WellFormedName(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String message = null;
		if (relationDomain.getPattern() != null)
			return ecoreValidator.validateENamedElement_WellFormedName(relationDomain, diagnostics, context);
		if (relationDomain.getName() != null)
			message = "Primitive RelationDomain '" + relationDomain.getName() + "' must be unnamed";
		if (message == null)
			return true;
		if (diagnostics != null) {
			diagnostics.add
				(createDiagnostic
					(Diagnostic.ERROR,
					 DIAGNOSTIC_SOURCE,
					 0,
					 "_UI_GenericConstraint_diagnostic",
					 new Object[] { "WellFormedName", getObjectLabel(relationDomain, context) },
					 new Object[] { relationDomain },
					 context));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomainAssignment(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relationDomainAssignment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationImplementation(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(relationImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationCallExp(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(relationCallExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalTransformation(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_WellFormedNsURI(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_WellFormedNsPrefix(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueSubpackageNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueClassifierNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_UniqueNsURIs(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalTransformation_KeyClassesAreDistinct(relationalTransformation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the KeyClassesAreDistinct constraint of '<em>Relational Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationalTransformation_KeyClassesAreDistinct(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationalTransformationOperations.INSTANCE.checkKeyClassesAreDistinct(relationalTransformation, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return QVTRelationPlugin.INSTANCE;
	}

} //QVTRelationValidator
