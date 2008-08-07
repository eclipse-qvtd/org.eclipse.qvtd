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
 * $Id: QVTRelationValidator.java,v 1.2 2008/08/07 05:03:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;

import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;

import org.eclipse.qvt.declarative.ecore.QVTRelation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage
 * @generated
 */
public class QVTRelationValidator extends EObjectValidator {
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
		qvtBaseValidator = QVTBaseValidator.INSTANCE;
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
		return validate_EveryDefaultConstraint(key, diagnostics, context);
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
		return result;
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

} //QVTRelationValidator
