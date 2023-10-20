/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface QVTcorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtcore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTcore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvtc";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtcore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")@NonNull QVTcorePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.Area <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area
	 * @generated
	 */
	EClass getArea();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_GuardPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_BottomPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_BottomPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#isIsDefault()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_IsDefault();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#isIsPartial <em>Is Partial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Partial</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#isIsPartial()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_IsPartial();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern
	 * @generated
	 */
	EClass getBottomPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Area</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_Area();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getAssignment()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_Assignment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enforcement Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_EnforcementOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getRealizedVariable <em>Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getRealizedVariable()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_RealizedVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#validateVariablesAreBottomVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Variables Are Bottom Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Variables Are Bottom Variables</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#validateVariablesAreBottomVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.BottomVariable <em>Bottom Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomVariable
	 * @generated
	 */
	EClass getBottomVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.BottomVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Initializer</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBottomVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.CoreDomain <em>Core Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CoreDomain
	 * @generated
	 */
	EClass getCoreDomain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.CoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CoreModel
	 * @generated
	 */
	EClass getCoreModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.CorePattern <em>Core Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CorePattern
	 * @generated
	 */
	EClass getCorePattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.CorePattern#getOwnedVariables <em>Owned Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Variables</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CorePattern#getOwnedVariables()
	 * @see #getCorePattern()
	 * @generated
	 */
	EReference getCorePattern_OwnedVariables();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.CorePattern#getArea() <em>Get Area</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Area</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CorePattern#getArea()
	 * @generated
	 */
	EOperation getCorePattern__GetArea();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforcement Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation
	 * @generated
	 */
	EClass getEnforcementOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getEnforcementMode <em>Enforcement Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforcement Mode</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getEnforcementMode()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EAttribute getEnforcementOperation_EnforcementMode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EReference getEnforcementOperation_BottomPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getOperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getOperationCallExp()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EReference getEnforcementOperation_OperationCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardPattern
	 * @generated
	 */
	EClass getGuardPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Area</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea()
	 * @see #getGuardPattern()
	 * @generated
	 */
	EReference getGuardPattern_Area();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern#validateVariablesAreGuardVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Variables Are Guard Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Variables Are Guard Variables</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardPattern#validateVariablesAreGuardVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.GuardVariable <em>Guard Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardVariable
	 * @generated
	 */
	EClass getGuardVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.GuardVariable#validateNoInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Initializer</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardVariable#validateNoInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGuardVariable__ValidateNoInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Context();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specification</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Specification();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#validateDomainsAreCoreDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Domains Are Core Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Domains Are Core Domains</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#validateDomainsAreCoreDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#validateNestedNameIsNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Nested Name Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Nested Name Is Null</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#validateNestedNameIsNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#validateRootNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Root Name Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Root Name Is Not Null</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#validateRootNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment <em>Navigation Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment
	 * @generated
	 */
	EClass getNavigationAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment#getSlotExpression <em>Slot Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment#getSlotExpression()
	 * @see #getNavigationAssignment()
	 * @generated
	 */
	EReference getNavigationAssignment_SlotExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment#getTargetProperty <em>Target Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment#getTargetProperty()
	 * @see #getNavigationAssignment()
	 * @generated
	 */
	EReference getNavigationAssignment_TargetProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment <em>Opposite Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Property Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment
	 * @generated
	 */
	EClass getOppositePropertyAssignment();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getReferredTargetProperty() <em>Get Referred Target Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Referred Target Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getReferredTargetProperty()
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__GetReferredTargetProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateCompatibleTypeForPartialValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Partial Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Partial Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateCompatibleTypeForPartialValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateCompatibleTypeForTotalValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Total Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Total Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateCompatibleTypeForTotalValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateOppositePropertyIsImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Opposite Property Is Implicit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Opposite Property Is Implicit</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateOppositePropertyIsImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateTargetPropetyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Propety Is Slot Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Propety Is Slot Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateTargetPropetyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment <em>Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment
	 * @generated
	 */
	EClass getPropertyAssignment();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getReferredTargetProperty() <em>Get Referred Target Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Referred Target Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getReferredTargetProperty()
	 * @generated
	 */
	EOperation getPropertyAssignment__GetReferredTargetProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateCompatibleTypeForPartialValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Partial Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Partial Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateCompatibleTypeForPartialValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateCompatibleTypeForTotalValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Total Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Total Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateCompatibleTypeForTotalValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validatePropertyIsNotImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Property Is Not Implicit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Property Is Not Implicit</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validatePropertyIsNotImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateTargetPropertyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Property Is Slot Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Property Is Slot Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateTargetPropertyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyAssignment__ValidateTargetPropertyIsSlotProperty__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.RealizedVariable <em>Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realized Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.RealizedVariable
	 * @generated
	 */
	EClass getRealizedVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.RealizedVariable#validateNonDataTypeForType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Non Data Type For Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Non Data Type For Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.RealizedVariable#validateNonDataTypeForType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#getTargetVariable()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_TargetVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementMode <em>Enforcement Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enforcement Mode</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementMode
	 * @generated
	 */
	EEnum getEnforcementMode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Local();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement <em>Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refinement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Refinement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTcoreFactory getQVTcoreFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.Area <em>Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.Area
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getArea()
		 * @generated
		 */
		EClass AREA = eINSTANCE.getArea();

		/**
		 * The meta object literal for the '<em><b>Guard Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__GUARD_PATTERN = eINSTANCE.getArea_GuardPattern();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__BOTTOM_PATTERN = eINSTANCE.getArea_BottomPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.AssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__BOTTOM_PATTERN = eINSTANCE.getAssignment_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__IS_DEFAULT = eINSTANCE.getAssignment_IsDefault();

		/**
		 * The meta object literal for the '<em><b>Is Partial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__IS_PARTIAL = eINSTANCE.getAssignment_IsPartial();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl <em>Bottom Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getBottomPattern()
		 * @generated
		 */
		EClass BOTTOM_PATTERN = eINSTANCE.getBottomPattern();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__AREA = eINSTANCE.getBottomPattern_Area();

		/**
		 * The meta object literal for the '<em><b>Assignment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__ASSIGNMENT = eINSTANCE.getBottomPattern_Assignment();

		/**
		 * The meta object literal for the '<em><b>Enforcement Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__ENFORCEMENT_OPERATION = eINSTANCE.getBottomPattern_EnforcementOperation();

		/**
		 * The meta object literal for the '<em><b>Realized Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__REALIZED_VARIABLE = eINSTANCE.getBottomPattern_RealizedVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Variables Are Bottom Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOTTOM_PATTERN___VALIDATE_VARIABLES_ARE_BOTTOM_VARIABLES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomVariableImpl <em>Bottom Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.BottomVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getBottomVariable()
		 * @generated
		 */
		EClass BOTTOM_VARIABLE = eINSTANCE.getBottomVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOTTOM_VARIABLE___VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getBottomVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreDomainImpl <em>Core Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreDomainImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreDomain()
		 * @generated
		 */
		EClass CORE_DOMAIN = eINSTANCE.getCoreDomain();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl <em>Core Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreModel()
		 * @generated
		 */
		EClass CORE_MODEL = eINSTANCE.getCoreModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CorePatternImpl <em>Core Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CorePatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCorePattern()
		 * @generated
		 */
		EClass CORE_PATTERN = eINSTANCE.getCorePattern();

		/**
		 * The meta object literal for the '<em><b>Owned Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_PATTERN__OWNED_VARIABLES = eINSTANCE.getCorePattern_OwnedVariables();

		/**
		 * The meta object literal for the '<em><b>Get Area</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CORE_PATTERN___GET_AREA = eINSTANCE.getCorePattern__GetArea();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl <em>Enforcement Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getEnforcementOperation()
		 * @generated
		 */
		EClass ENFORCEMENT_OPERATION = eINSTANCE.getEnforcementOperation();

		/**
		 * The meta object literal for the '<em><b>Enforcement Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENFORCEMENT_OPERATION__ENFORCEMENT_MODE = eINSTANCE.getEnforcementOperation_EnforcementMode();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION__BOTTOM_PATTERN = eINSTANCE.getEnforcementOperation_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Operation Call Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION__OPERATION_CALL_EXP = eINSTANCE.getEnforcementOperation_OperationCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.GuardPatternImpl <em>Guard Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.GuardPatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getGuardPattern()
		 * @generated
		 */
		EClass GUARD_PATTERN = eINSTANCE.getGuardPattern();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PATTERN__AREA = eINSTANCE.getGuardPattern_Area();

		/**
		 * The meta object literal for the '<em><b>Validate Variables Are Guard Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GUARD_PATTERN___VALIDATE_VARIABLES_ARE_GUARD_VARIABLES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.GuardVariableImpl <em>Guard Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.GuardVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getGuardVariable()
		 * @generated
		 */
		EClass GUARD_VARIABLE = eINSTANCE.getGuardVariable();

		/**
		 * The meta object literal for the '<em><b>Validate No Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GUARD_VARIABLE___VALIDATE_NO_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getGuardVariable__ValidateNoInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CONTEXT = eINSTANCE.getMapping_Context();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SPECIFICATION = eINSTANCE.getMapping_Specification();

		/**
		 * The meta object literal for the '<em><b>Validate Domains Are Core Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_DOMAINS_ARE_CORE_DOMAINS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Nested Name Is Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_NESTED_NAME_IS_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Root Name Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_ROOT_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.NavigationAssignmentImpl <em>Navigation Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.NavigationAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getNavigationAssignment()
		 * @generated
		 */
		EClass NAVIGATION_ASSIGNMENT = eINSTANCE.getNavigationAssignment();

		/**
		 * The meta object literal for the '<em><b>Slot Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_ASSIGNMENT__SLOT_EXPRESSION = eINSTANCE.getNavigationAssignment_SlotExpression();

		/**
		 * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_ASSIGNMENT__TARGET_PROPERTY = eINSTANCE.getNavigationAssignment_TargetProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.OppositePropertyAssignmentImpl <em>Opposite Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.OppositePropertyAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getOppositePropertyAssignment()
		 * @generated
		 */
		EClass OPPOSITE_PROPERTY_ASSIGNMENT = eINSTANCE.getOppositePropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Get Referred Target Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY = eINSTANCE.getOppositePropertyAssignment__GetReferredTargetProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Partial Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Total Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Opposite Property Is Implicit</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_OPPOSITE_PROPERTY_IS_IMPLICIT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Propety Is Slot Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.PropertyAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getPropertyAssignment()
		 * @generated
		 */
		EClass PROPERTY_ASSIGNMENT = eINSTANCE.getPropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Get Referred Target Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY = eINSTANCE.getPropertyAssignment__GetReferredTargetProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Partial Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Total Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Property Is Not Implicit</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Property Is Slot Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPERTY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyAssignment__ValidateTargetPropertyIsSlotProperty__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.RealizedVariableImpl <em>Realized Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.RealizedVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getRealizedVariable()
		 * @generated
		 */
		EClass REALIZED_VARIABLE = eINSTANCE.getRealizedVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Non Data Type For Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REALIZED_VARIABLE___VALIDATE_NON_DATA_TYPE_FOR_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.VariableAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__TARGET_VARIABLE = eINSTANCE.getVariableAssignment_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementMode <em>Enforcement Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementMode
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getEnforcementMode()
		 * @generated
		 */
		EEnum ENFORCEMENT_MODE = eINSTANCE.getEnforcementMode();

		/**
		 * The meta object literal for the '<em><b>Local</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__LOCAL = eINSTANCE.getMapping_Local();

		/**
		 * The meta object literal for the '<em><b>Refinement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__REFINEMENT = eINSTANCE.getMapping_Refinement();

	}

} //QVTcorePackage
