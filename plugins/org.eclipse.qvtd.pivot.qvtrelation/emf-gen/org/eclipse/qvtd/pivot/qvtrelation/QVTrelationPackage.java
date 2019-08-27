/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface QVTrelationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtrelation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTrelation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvtr";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtrelation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")@NonNull QVTrelationPackage eINSTANCE = org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern <em>Domain Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern
	 * @generated
	 */
	EClass getDomainPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain <em>Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Relation Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain()
	 * @see #getDomainPattern()
	 * @generated
	 */
	EReference getDomainPattern_RelationDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getTemplateExpression <em>Template Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getTemplateExpression()
	 * @see #getDomainPattern()
	 * @generated
	 */
	EReference getDomainPattern_TemplateExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.Key <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key
	 * @generated
	 */
	EClass getKey();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getIdentifies <em>Identifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifies</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getIdentifies()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Identifies();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getPart()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Part();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Transformation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsNotAbstract(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Identifies Is Not Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Identifies Is Not Abstract</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsNotAbstract(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsAUsedPackageClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Identifies Is AUsed Package Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Identifies Is AUsed Package Class</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsAUsedPackageClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateNoSuperKeys(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Super Keys</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Super Keys</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateNoSuperKeys(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateNoSuperKeys__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Identifies Is Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Identifies Is Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsHaveOpposites(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Opposite Parts Have Opposites</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Opposite Parts Have Opposites</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsHaveOpposites(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsAreOppositeParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Opposite Parts Are Opposite Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Opposite Parts Are Opposite Parts</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsAreOppositeParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parts Are Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parts Are Parts</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidatePartsAreParts__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parts Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parts Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidatePartsAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getOppositePart <em>Opposite Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Opposite Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getOppositePart()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_OppositePart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Top Level</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_IsTopLevel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getOperationalImpl <em>Operational Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operational Impl</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getOperationalImpl()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_OperationalImpl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getVariable()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>When</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_When();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Where();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#validateDomainsAreRelationDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Domains Are Relation Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Domains Are Relation Domains</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#validateDomainsAreRelationDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTopRelationOverriddenByTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Top Relation Overridden By Top Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Top Relation Overridden By Top Relation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTopRelationOverriddenByTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTransformationIsRelationalTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Transformation Is Relational Transformation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Transformation Is Relational Transformation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTransformationIsRelationalTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp <em>Relation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Call Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp
	 * @generated
	 */
	EClass getRelationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getArgument()
	 * @see #getRelationCallExp()
	 * @generated
	 */
	EReference getRelationCallExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Relation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation()
	 * @see #getRelationCallExp()
	 * @generated
	 */
	EReference getRelationCallExp_ReferredRelation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateMatchingArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Matching Argument Count</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Matching Argument Count</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateMatchingArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateWhereInvocationIsANonTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Where Invocation Is ANon Top Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Where Invocation Is ANon Top Relation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateWhereInvocationIsANonTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateDataTypeInvocationIsANonTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Data Type Invocation Is ANon Top Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Data Type Invocation Is ANon Top Relation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateDataTypeInvocationIsANonTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationCallExp__ValidateDataTypeInvocationIsANonTopRelation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain <em>Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain
	 * @generated
	 */
	EClass getRelationDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getDefaultAssignment <em>Default Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getDefaultAssignment()
	 * @see #getRelationDomain()
	 * @generated
	 */
	EReference getRelationDomain_DefaultAssignment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getPattern()
	 * @see #getRelationDomain()
	 * @generated
	 */
	EReference getRelationDomain_Pattern();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getRootVariable <em>Root Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getRootVariable()
	 * @see #getRelationDomain()
	 * @generated
	 */
	EReference getRelationDomain_RootVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#validateRelationDomainAssignmentsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Relation Domain Assignments Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Relation Domain Assignments Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#validateRelationDomainAssignmentsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment <em>Relation Domain Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Domain Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment
	 * @generated
	 */
	EClass getRelationDomainAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner()
	 * @see #getRelationDomainAssignment()
	 * @generated
	 */
	EReference getRelationDomainAssignment_Owner();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getValueExp <em>Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getValueExp()
	 * @see #getRelationDomainAssignment()
	 * @generated
	 */
	EReference getRelationDomainAssignment_ValueExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getVariable()
	 * @see #getRelationDomainAssignment()
	 * @generated
	 */
	EReference getRelationDomainAssignment_Variable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationModel <em>Relation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationModel
	 * @generated
	 */
	EClass getRelationModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation <em>Relation Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Implementation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation
	 * @generated
	 */
	EClass getRelationImplementation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getImpl <em>Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Impl</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getImpl()
	 * @see #getRelationImplementation()
	 * @generated
	 */
	EReference getRelationImplementation_Impl();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getInDirectionOf <em>In Direction Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Direction Of</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getInDirectionOf()
	 * @see #getRelationImplementation()
	 * @generated
	 */
	EReference getRelationImplementation_InDirectionOf();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Relation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation()
	 * @see #getRelationImplementation()
	 * @generated
	 */
	EReference getRelationImplementation_Relation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation <em>Relational Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation
	 * @generated
	 */
	EClass getRelationalTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Key</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey()
	 * @see #getRelationalTransformation()
	 * @generated
	 */
	EReference getRelationalTransformation_OwnedKey();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#validateContextTypeIsThisTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Context Type Is This Transformation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Context Type Is This Transformation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#validateContextTypeIsThisTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationalTransformation__ValidateContextTypeIsThisTransformation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#validateRulesAreRelations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Rules Are Relations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Rules Are Relations</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#validateRulesAreRelations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable <em>Shared Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable
	 * @generated
	 */
	EClass getSharedVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#getTypedModel()
	 * @see #getSharedVariable()
	 * @generated
	 */
	EReference getSharedVariable_TypedModel();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Initializer</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Nullity For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Nullity For Initializer</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable <em>Template Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable
	 * @generated
	 */
	EClass getTemplateVariable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTrelationFactory getQVTrelationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl <em>Domain Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getDomainPattern()
		 * @generated
		 */
		EClass DOMAIN_PATTERN = eINSTANCE.getDomainPattern();

		/**
		 * The meta object literal for the '<em><b>Relation Domain</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_PATTERN__RELATION_DOMAIN = eINSTANCE.getDomainPattern_RelationDomain();

		/**
		 * The meta object literal for the '<em><b>Template Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_PATTERN__TEMPLATE_EXPRESSION = eINSTANCE.getDomainPattern_TemplateExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl <em>Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getKey()
		 * @generated
		 */
		EClass KEY = eINSTANCE.getKey();

		/**
		 * The meta object literal for the '<em><b>Identifies</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__IDENTIFIES = eINSTANCE.getKey_Identifies();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__PART = eINSTANCE.getKey_Part();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__TRANSFORMATION = eINSTANCE.getKey_Transformation();

		/**
		 * The meta object literal for the '<em><b>Validate Identifies Is Not Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Identifies Is AUsed Package Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Super Keys</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_NO_SUPER_KEYS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateNoSuperKeys__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Identifies Is Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_IDENTIFIES_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Opposite Parts Have Opposites</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Opposite Parts Are Opposite Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Parts Are Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_PARTS_ARE_PARTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidatePartsAreParts__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Parts Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidatePartsAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Opposite Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__OPPOSITE_PART = eINSTANCE.getKey_OppositePart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Is Top Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__IS_TOP_LEVEL = eINSTANCE.getRelation_IsTopLevel();

		/**
		 * The meta object literal for the '<em><b>Operational Impl</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__OPERATIONAL_IMPL = eINSTANCE.getRelation_OperationalImpl();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__VARIABLE = eINSTANCE.getRelation_Variable();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__WHEN = eINSTANCE.getRelation_When();

		/**
		 * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__WHERE = eINSTANCE.getRelation_Where();

		/**
		 * The meta object literal for the '<em><b>Validate Domains Are Relation Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___VALIDATE_DOMAINS_ARE_RELATION_DOMAINS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Top Relation Overridden By Top Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___VALIDATE_TOP_RELATION_OVERRIDDEN_BY_TOP_RELATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Transformation Is Relational Transformation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___VALIDATE_TRANSFORMATION_IS_RELATIONAL_TRANSFORMATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl <em>Relation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationCallExp()
		 * @generated
		 */
		EClass RELATION_CALL_EXP = eINSTANCE.getRelationCallExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CALL_EXP__ARGUMENT = eINSTANCE.getRelationCallExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Referred Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CALL_EXP__REFERRED_RELATION = eINSTANCE.getRelationCallExp_ReferredRelation();

		/**
		 * The meta object literal for the '<em><b>Validate Matching Argument Count</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_CALL_EXP___VALIDATE_MATCHING_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Where Invocation Is ANon Top Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_CALL_EXP___VALIDATE_WHERE_INVOCATION_IS_ANON_TOP_RELATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Data Type Invocation Is ANon Top Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_CALL_EXP___VALIDATE_DATA_TYPE_INVOCATION_IS_ANON_TOP_RELATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationCallExp__ValidateDataTypeInvocationIsANonTopRelation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl <em>Relation Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationDomain()
		 * @generated
		 */
		EClass RELATION_DOMAIN = eINSTANCE.getRelationDomain();

		/**
		 * The meta object literal for the '<em><b>Default Assignment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN__DEFAULT_ASSIGNMENT = eINSTANCE.getRelationDomain_DefaultAssignment();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN__PATTERN = eINSTANCE.getRelationDomain_Pattern();

		/**
		 * The meta object literal for the '<em><b>Root Variable</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN__ROOT_VARIABLE = eINSTANCE.getRelationDomain_RootVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Relation Domain Assignments Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DOMAIN___VALIDATE_RELATION_DOMAIN_ASSIGNMENTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl <em>Relation Domain Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationDomainAssignment()
		 * @generated
		 */
		EClass RELATION_DOMAIN_ASSIGNMENT = eINSTANCE.getRelationDomainAssignment();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN_ASSIGNMENT__OWNER = eINSTANCE.getRelationDomainAssignment_Owner();

		/**
		 * The meta object literal for the '<em><b>Value Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP = eINSTANCE.getRelationDomainAssignment_ValueExp();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN_ASSIGNMENT__VARIABLE = eINSTANCE.getRelationDomainAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DOMAIN_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl <em>Relation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationModel()
		 * @generated
		 */
		EClass RELATION_MODEL = eINSTANCE.getRelationModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl <em>Relation Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationImplementation()
		 * @generated
		 */
		EClass RELATION_IMPLEMENTATION = eINSTANCE.getRelationImplementation();

		/**
		 * The meta object literal for the '<em><b>Impl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_IMPLEMENTATION__IMPL = eINSTANCE.getRelationImplementation_Impl();

		/**
		 * The meta object literal for the '<em><b>In Direction Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_IMPLEMENTATION__IN_DIRECTION_OF = eINSTANCE.getRelationImplementation_InDirectionOf();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_IMPLEMENTATION__RELATION = eINSTANCE.getRelationImplementation_Relation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationalTransformationImpl <em>Relational Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationalTransformationImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationalTransformation()
		 * @generated
		 */
		EClass RELATIONAL_TRANSFORMATION = eINSTANCE.getRelationalTransformation();

		/**
		 * The meta object literal for the '<em><b>Owned Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_TRANSFORMATION__OWNED_KEY = eINSTANCE.getRelationalTransformation_OwnedKey();

		/**
		 * The meta object literal for the '<em><b>Validate Context Type Is This Transformation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONAL_TRANSFORMATION___VALIDATE_CONTEXT_TYPE_IS_THIS_TRANSFORMATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationalTransformation__ValidateContextTypeIsThisTransformation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Rules Are Relations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONAL_TRANSFORMATION___VALIDATE_RULES_ARE_RELATIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.SharedVariableImpl <em>Shared Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.SharedVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getSharedVariable()
		 * @generated
		 */
		EClass SHARED_VARIABLE = eINSTANCE.getSharedVariable();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHARED_VARIABLE__TYPED_MODEL = eINSTANCE.getSharedVariable_TypedModel();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHARED_VARIABLE___VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Nullity For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHARED_VARIABLE___VALIDATE_COMPATIBLE_NULLITY_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.TemplateVariableImpl <em>Template Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.TemplateVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getTemplateVariable()
		 * @generated
		 */
		EClass TEMPLATE_VARIABLE = eINSTANCE.getTemplateVariable();

	}

} //QVTrelationPackage
