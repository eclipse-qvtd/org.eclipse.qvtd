/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

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
 * <!-- begin-model-doc -->
 * The Package for an Imperative QVT transformation.
 * 
 * An Imperative QVT trabsformation is expected to be created by an autogenerator that observes the following run-time restrictions:
 * 
 * A mapping that my be re-invoked must have MappingCall.isInfinite set for every possible invocation.
 * 
 * A mapping that reads object slots before they are guaranteed to have been assigned must declare the slots property in a corresponding ImperativeArea.checkedProperties entry.
 * 
 * A mapping that assigns an object slot that any mapping may access before assignment is guaranteed must declare declare the slots property in a corresponding ImperativeArea.enforcedProperties entry.
 * 
 * All reads by Functions/Queries must be guaranteed to succeed; i.e. the invoking mapping must check readiness before calling the query.
 * 
 * All writes to multi-valued properties must be guaranteed to occur before any read of the property.
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory
 * @generated
 */
public interface QVTimperativePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtimperative";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2016/QVTimperative";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvti";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtimperative";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTimperativePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement <em>Add Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement
	 * @generated
	 */
	EClass getAddStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getTargetVariable()
	 * @see #getAddStatement()
	 * @generated
	 */
	EReference getAddStatement_TargetVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#isIsEnforcedUnique <em>Is Enforced Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforced Unique</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#isIsEnforcedUnique()
	 * @see #getAddStatement()
	 * @generated
	 */
	EAttribute getAddStatement_IsEnforcedUnique();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedExpression()
	 * @see #getAddStatement()
	 * @generated
	 */
	EReference getAddStatement_OwnedExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getAddStatement__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameter <em>Append Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Append Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AppendParameter
	 * @generated
	 */
	EClass getAppendParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding <em>Append Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Append Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding
	 * @generated
	 */
	EClass getAppendParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding#getValue()
	 * @see #getAppendParameterBinding()
	 * @generated
	 */
	EReference getAppendParameterBinding_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement <em>Buffer Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.BufferStatement
	 * @generated
	 */
	EClass getBufferStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getOwnedExpression()
	 * @see #getBufferStatement()
	 * @generated
	 */
	EReference getBufferStatement_OwnedExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getFirstPass <em>First Pass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Pass</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getFirstPass()
	 * @see #getBufferStatement()
	 * @generated
	 */
	EAttribute getBufferStatement_FirstPass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getLastPass <em>Last Pass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Pass</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getLastPass()
	 * @see #getBufferStatement()
	 * @generated
	 */
	EAttribute getBufferStatement_LastPass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBufferStatement__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.CheckStatement <em>Check Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.CheckStatement
	 * @generated
	 */
	EClass getCheckStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#getOwnedExpression()
	 * @see #getCheckStatement()
	 * @generated
	 */
	EReference getCheckStatement_OwnedExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#validateTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Boolean</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#validateTypeIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCheckStatement__ValidateTypeIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable <em>Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable
	 * @generated
	 */
	EClass getConnectionVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable#isIsStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable#isIsStrict()
	 * @see #getConnectionVariable()
	 * @generated
	 */
	EAttribute getConnectionVariable_IsStrict();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement <em>Declare Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declare Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement
	 * @generated
	 */
	EClass getDeclareStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsCheck()
	 * @see #getDeclareStatement()
	 * @generated
	 */
	EAttribute getDeclareStatement_IsCheck();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedExpression()
	 * @see #getDeclareStatement()
	 * @generated
	 */
	EReference getDeclareStatement_OwnedExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#validateCompatibleTypeForUncheckedValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Unchecked Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Unchecked Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#validateCompatibleTypeForUncheckedValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDeclareStatement__ValidateCompatibleTypeForUncheckedValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter <em>Guard Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameter
	 * @generated
	 */
	EClass getGuardParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getReferredTypedModel()
	 * @see #getGuardParameter()
	 * @generated
	 */
	EReference getGuardParameter_ReferredTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getSuccessProperty <em>Success Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Success Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getSuccessProperty()
	 * @see #getGuardParameter()
	 * @generated
	 */
	EReference getGuardParameter_SuccessProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding <em>Guard Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding
	 * @generated
	 */
	EClass getGuardParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#getValue()
	 * @see #getGuardParameterBinding()
	 * @generated
	 */
	EReference getGuardParameterBinding_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#isIsCheck()
	 * @see #getGuardParameterBinding()
	 * @generated
	 */
	EAttribute getGuardParameterBinding_IsCheck();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel <em>Imperative Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel
	 * @generated
	 */
	EClass getImperativeModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation <em>Imperative Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation
	 * @generated
	 */
	EClass getImperativeTransformation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation#validateallRulesAreMappings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validateall Rules Are Mappings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validateall Rules Are Mappings</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation#validateallRulesAreMappings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getImperativeTransformation__ValidateallRulesAreMappings__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel <em>Imperative Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel
	 * @generated
	 */
	EClass getImperativeTypedModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsChecked <em>Is Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Checked</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsChecked()
	 * @see #getImperativeTypedModel()
	 * @generated
	 */
	EAttribute getImperativeTypedModel_IsChecked();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsEnforced <em>Is Enforced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforced</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsEnforced()
	 * @see #getImperativeTypedModel()
	 * @generated
	 */
	EAttribute getImperativeTypedModel_IsEnforced();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#getAllUsedPackages <em>All Used Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Used Packages</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#getAllUsedPackages()
	 * @see #getImperativeTypedModel()
	 * @generated
	 */
	EReference getImperativeTypedModel_AllUsedPackages();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Not Null</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getImperativeTypedModel__ValidateNameIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#validateNotBothCheckedAndEnforced(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Not Both Checked And Enforced</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Not Both Checked And Enforced</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#validateNotBothCheckedAndEnforced(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getImperativeTypedModel__ValidateNotBothCheckedAndEnforced__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding <em>Loop Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding
	 * @generated
	 */
	EClass getLoopParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#getValue()
	 * @see #getLoopParameterBinding()
	 * @generated
	 */
	EReference getLoopParameterBinding_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#isIsCheck()
	 * @see #getLoopParameterBinding()
	 * @generated
	 */
	EAttribute getLoopParameterBinding_IsCheck();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable <em>Loop Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopVariable
	 * @generated
	 */
	EClass getLoopVariable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop <em>Owning Mapping Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping Loop</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop()
	 * @see #getLoopVariable()
	 * @generated
	 */
	EReference getLoopVariable_OwningMappingLoop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#isIsStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#isIsStrict()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_IsStrict();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedMappingParameters <em>Owned Mapping Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Parameters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedMappingParameters()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_OwnedMappingParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Statements</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedStatements()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_OwnedStatements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getFirstPass <em>First Pass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Pass</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getFirstPass()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_FirstPass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getLastPass <em>Last Pass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Pass</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getLastPass()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_LastPass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Not Null</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#validateNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateNameIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#validateMappingParameterNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Mapping Parameter Names Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Mapping Parameter Names Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#validateMappingParameterNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateMappingParameterNamesAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#validateLocalVariableNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Local Variable Names Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Local Variable Names Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#validateLocalVariableNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateLocalVariableNamesAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall
	 * @generated
	 */
	EClass getMappingCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getOwnedMappingParameterBindings <em>Owned Mapping Parameter Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Parameter Bindings</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getOwnedMappingParameterBindings()
	 * @see #getMappingCall()
	 * @generated
	 */
	EReference getMappingCall_OwnedMappingParameterBindings();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredMapping <em>Referred Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredMapping()
	 * @see #getMappingCall()
	 * @generated
	 */
	EReference getMappingCall_ReferredMapping();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredNames <em>Referred Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Referred Names</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredNames()
	 * @see #getMappingCall()
	 * @generated
	 */
	EAttribute getMappingCall_ReferredNames();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferringNames <em>Referring Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Referring Names</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferringNames()
	 * @see #getMappingCall()
	 * @generated
	 */
	EAttribute getMappingCall_ReferringNames();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#validateMatchingCallBindings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Matching Call Bindings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Matching Call Bindings</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#validateMatchingCallBindings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMappingCall__ValidateMatchingCallBindings__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#validateNotBothInstallAndInvoke(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Not Both Install And Invoke</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Not Both Install And Invoke</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#validateNotBothInstallAndInvoke(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMappingCall__ValidateNotBothInstallAndInvoke__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#validateUniqueCallBindings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Unique Call Bindings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Unique Call Bindings</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#validateUniqueCallBindings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMappingCall__ValidateUniqueCallBindings__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInstall <em>Is Install</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Install</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInstall()
	 * @see #getMappingCall()
	 * @generated
	 */
	EAttribute getMappingCall_IsInstall();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInvoke <em>Is Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Invoke</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInvoke()
	 * @see #getMappingCall()
	 * @generated
	 */
	EAttribute getMappingCall_IsInvoke();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop <em>Mapping Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Loop</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop
	 * @generated
	 */
	EClass getMappingLoop();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators <em>Owned Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterators</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedIterators();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedMappingStatements <em>Owned Mapping Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Statements</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedMappingStatements()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedMappingStatements();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedExpression()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameter <em>Mapping Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameter
	 * @generated
	 */
	EClass getMappingParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameter#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameter#getOwningMapping()
	 * @see #getMappingParameter()
	 * @generated
	 */
	EReference getMappingParameter_OwningMapping();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding <em>Mapping Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding
	 * @generated
	 */
	EClass getMappingParameterBinding();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getOwningMappingCall <em>Owning Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping Call</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getOwningMappingCall()
	 * @see #getMappingParameterBinding()
	 * @generated
	 */
	EReference getMappingParameterBinding_OwningMappingCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getBoundVariable <em>Bound Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bound Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getBoundVariable()
	 * @see #getMappingParameterBinding()
	 * @generated
	 */
	EReference getMappingParameterBinding_BoundVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#validateParameterIsMappingParameter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parameter Is Mapping Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parameter Is Mapping Parameter</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#validateParameterIsMappingParameter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMappingParameterBinding__ValidateParameterIsMappingParameter__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingStatement <em>Mapping Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingStatement
	 * @generated
	 */
	EClass getMappingStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement <em>New Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement
	 * @generated
	 */
	EClass getNewStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#isIsContained <em>Is Contained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Contained</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#isIsContained()
	 * @see #getNewStatement()
	 * @generated
	 */
	EAttribute getNewStatement_IsContained();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getReferredTypedModel()
	 * @see #getNewStatement()
	 * @generated
	 */
	EReference getNewStatement_ReferredTypedModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedExpression()
	 * @see #getNewStatement()
	 * @generated
	 */
	EReference getNewStatement_OwnedExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getNewStatement__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#validateNonDataTypeForType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Non Data Type For Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Non Data Type For Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#validateNonDataTypeForType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getNewStatement__ValidateNonDataTypeForType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement <em>Observable Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observable Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement
	 * @generated
	 */
	EClass getObservableStatement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement#getObservedProperties <em>Observed Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Observed Properties</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement#getObservedProperties()
	 * @see #getObservableStatement()
	 * @generated
	 */
	EReference getObservableStatement_ObservedProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement <em>Set Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement
	 * @generated
	 */
	EClass getSetStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetVariable()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_TargetVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetProperty <em>Target Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetProperty()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_TargetProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsPartial <em>Is Partial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Partial</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsPartial()
	 * @see #getSetStatement()
	 * @generated
	 */
	EAttribute getSetStatement_IsPartial();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite <em>Is Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Opposite</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite()
	 * @see #getSetStatement()
	 * @generated
	 */
	EAttribute getSetStatement_IsOpposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsNotify <em>Is Notify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Notify</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsNotify()
	 * @see #getSetStatement()
	 * @generated
	 */
	EAttribute getSetStatement_IsNotify();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getOwnedExpression()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_OwnedExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getResolvedProperty <em>Resolved Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getResolvedProperty()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_ResolvedProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateCompatibleClassForProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Class For Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Class For Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateCompatibleClassForProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSetStatement__ValidateCompatibleClassForProperty__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateCompatibleTypeForPartialValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Partial Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Partial Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateCompatibleTypeForPartialValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSetStatement__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateCompatibleTypeForTotalValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Total Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Total Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateCompatibleTypeForTotalValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSetStatement__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateValueDoesNotNavigateFromRealizedVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Value Does Not Navigate From Realized Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Value Does Not Navigate From Realized Variables</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateValueDoesNotNavigateFromRealizedVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSetStatement__ValidateValueDoesNotNavigateFromRealizedVariables__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateTargetPropertyIsNotReadOnly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Property Is Not Read Only</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Property Is Not Read Only</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#validateTargetPropertyIsNotReadOnly(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSetStatement__ValidateTargetPropertyIsNotReadOnly__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter <em>Simple Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter
	 * @generated
	 */
	EClass getSimpleParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter#getReferredTypedModel()
	 * @see #getSimpleParameter()
	 * @generated
	 */
	EReference getSimpleParameter_ReferredTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding <em>Simple Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding
	 * @generated
	 */
	EClass getSimpleParameterBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#getValue()
	 * @see #getSimpleParameterBinding()
	 * @generated
	 */
	EReference getSimpleParameterBinding_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#isIsCheck()
	 * @see #getSimpleParameterBinding()
	 * @generated
	 */
	EAttribute getSimpleParameterBinding_IsCheck();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#validateCompatibleTypeForCheckedValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Checked Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Checked Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#validateCompatibleTypeForCheckedValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSimpleParameterBinding__ValidateCompatibleTypeForCheckedValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#validateCompatibleTypeForUncheckedValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Unchecked Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Unchecked Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#validateCompatibleTypeForUncheckedValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSimpleParameterBinding__ValidateCompatibleTypeForUncheckedValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtimperative.Statement#joinNames(org.eclipse.emf.common.util.EList) <em>Join Names</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Join Names</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Statement#joinNames(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getStatement__JoinNames__EList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.VariableStatement <em>Variable Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.VariableStatement
	 * @generated
	 */
	EClass getVariableStatement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTimperativeFactory getQVTimperativeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl <em>Add Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAddStatement()
		 * @generated
		 */
		EClass ADD_STATEMENT = eINSTANCE.getAddStatement();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_STATEMENT__TARGET_VARIABLE = eINSTANCE.getAddStatement_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Is Enforced Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_STATEMENT__IS_ENFORCED_UNIQUE = eINSTANCE.getAddStatement_IsEnforcedUnique();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getAddStatement_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ADD_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getAddStatement__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterImpl <em>Append Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAppendParameter()
		 * @generated
		 */
		EClass APPEND_PARAMETER = eINSTANCE.getAppendParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterBindingImpl <em>Append Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAppendParameterBinding()
		 * @generated
		 */
		EClass APPEND_PARAMETER_BINDING = eINSTANCE.getAppendParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPEND_PARAMETER_BINDING__VALUE = eINSTANCE.getAppendParameterBinding_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl <em>Buffer Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getBufferStatement()
		 * @generated
		 */
		EClass BUFFER_STATEMENT = eINSTANCE.getBufferStatement();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getBufferStatement_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>First Pass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_STATEMENT__FIRST_PASS = eINSTANCE.getBufferStatement_FirstPass();

		/**
		 * The meta object literal for the '<em><b>Last Pass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_STATEMENT__LAST_PASS = eINSTANCE.getBufferStatement_LastPass();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUFFER_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getBufferStatement__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl <em>Check Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getCheckStatement()
		 * @generated
		 */
		EClass CHECK_STATEMENT = eINSTANCE.getCheckStatement();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getCheckStatement_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CHECK_STATEMENT___VALIDATE_TYPE_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCheckStatement__ValidateTypeIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl <em>Connection Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getConnectionVariable()
		 * @generated
		 */
		EClass CONNECTION_VARIABLE = eINSTANCE.getConnectionVariable();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_VARIABLE__IS_STRICT = eINSTANCE.getConnectionVariable_IsStrict();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl <em>Declare Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getDeclareStatement()
		 * @generated
		 */
		EClass DECLARE_STATEMENT = eINSTANCE.getDeclareStatement();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARE_STATEMENT__IS_CHECK = eINSTANCE.getDeclareStatement_IsCheck();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARE_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getDeclareStatement_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Unchecked Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DECLARE_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_UNCHECKED_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getDeclareStatement__ValidateCompatibleTypeForUncheckedValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl <em>Guard Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardParameter()
		 * @generated
		 */
		EClass GUARD_PARAMETER = eINSTANCE.getGuardParameter();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PARAMETER__REFERRED_TYPED_MODEL = eINSTANCE.getGuardParameter_ReferredTypedModel();

		/**
		 * The meta object literal for the '<em><b>Success Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PARAMETER__SUCCESS_PROPERTY = eINSTANCE.getGuardParameter_SuccessProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterBindingImpl <em>Guard Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardParameterBinding()
		 * @generated
		 */
		EClass GUARD_PARAMETER_BINDING = eINSTANCE.getGuardParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PARAMETER_BINDING__VALUE = eINSTANCE.getGuardParameterBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD_PARAMETER_BINDING__IS_CHECK = eINSTANCE.getGuardParameterBinding_IsCheck();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl <em>Imperative Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeModel()
		 * @generated
		 */
		EClass IMPERATIVE_MODEL = eINSTANCE.getImperativeModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTransformationImpl <em>Imperative Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTransformationImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeTransformation()
		 * @generated
		 */
		EClass IMPERATIVE_TRANSFORMATION = eINSTANCE.getImperativeTransformation();

		/**
		 * The meta object literal for the '<em><b>Validateall Rules Are Mappings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMPERATIVE_TRANSFORMATION___VALIDATEALL_RULES_ARE_MAPPINGS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getImperativeTransformation__ValidateallRulesAreMappings__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl <em>Imperative Typed Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeTypedModel()
		 * @generated
		 */
		EClass IMPERATIVE_TYPED_MODEL = eINSTANCE.getImperativeTypedModel();

		/**
		 * The meta object literal for the '<em><b>Is Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPERATIVE_TYPED_MODEL__IS_CHECKED = eINSTANCE.getImperativeTypedModel_IsChecked();

		/**
		 * The meta object literal for the '<em><b>Is Enforced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPERATIVE_TYPED_MODEL__IS_ENFORCED = eINSTANCE.getImperativeTypedModel_IsEnforced();

		/**
		 * The meta object literal for the '<em><b>All Used Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_TYPED_MODEL__ALL_USED_PACKAGES = eINSTANCE.getImperativeTypedModel_AllUsedPackages();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMPERATIVE_TYPED_MODEL___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getImperativeTypedModel__ValidateNameIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Not Both Checked And Enforced</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMPERATIVE_TYPED_MODEL___VALIDATE_NOT_BOTH_CHECKED_AND_ENFORCED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getImperativeTypedModel__ValidateNotBothCheckedAndEnforced__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.LoopParameterBindingImpl <em>Loop Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.LoopParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getLoopParameterBinding()
		 * @generated
		 */
		EClass LOOP_PARAMETER_BINDING = eINSTANCE.getLoopParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PARAMETER_BINDING__VALUE = eINSTANCE.getLoopParameterBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_PARAMETER_BINDING__IS_CHECK = eINSTANCE.getLoopParameterBinding_IsCheck();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getLoopVariable()
		 * @generated
		 */
		EClass LOOP_VARIABLE = eINSTANCE.getLoopVariable();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping Loop</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_VARIABLE__OWNING_MAPPING_LOOP = eINSTANCE.getLoopVariable_OwningMappingLoop();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__IS_STRICT = eINSTANCE.getMapping_IsStrict();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__OWNED_MAPPING_PARAMETERS = eINSTANCE.getMapping_OwnedMappingParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__OWNED_STATEMENTS = eINSTANCE.getMapping_OwnedStatements();

		/**
		 * The meta object literal for the '<em><b>First Pass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__FIRST_PASS = eINSTANCE.getMapping_FirstPass();

		/**
		 * The meta object literal for the '<em><b>Last Pass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__LAST_PASS = eINSTANCE.getMapping_LastPass();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateNameIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Mapping Parameter Names Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_MAPPING_PARAMETER_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateMappingParameterNamesAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Local Variable Names Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_LOCAL_VARIABLE_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateLocalVariableNamesAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl <em>Mapping Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCall()
		 * @generated
		 */
		EClass MAPPING_CALL = eINSTANCE.getMappingCall();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Parameter Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL__OWNED_MAPPING_PARAMETER_BINDINGS = eINSTANCE.getMappingCall_OwnedMappingParameterBindings();

		/**
		 * The meta object literal for the '<em><b>Referred Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL__REFERRED_MAPPING = eINSTANCE.getMappingCall_ReferredMapping();

		/**
		 * The meta object literal for the '<em><b>Referred Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL__REFERRED_NAMES = eINSTANCE.getMappingCall_ReferredNames();

		/**
		 * The meta object literal for the '<em><b>Referring Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL__REFERRING_NAMES = eINSTANCE.getMappingCall_ReferringNames();

		/**
		 * The meta object literal for the '<em><b>Validate Matching Call Bindings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_CALL___VALIDATE_MATCHING_CALL_BINDINGS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMappingCall__ValidateMatchingCallBindings__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Not Both Install And Invoke</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_CALL___VALIDATE_NOT_BOTH_INSTALL_AND_INVOKE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMappingCall__ValidateNotBothInstallAndInvoke__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Unique Call Bindings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_CALL___VALIDATE_UNIQUE_CALL_BINDINGS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMappingCall__ValidateUniqueCallBindings__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Is Install</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL__IS_INSTALL = eINSTANCE.getMappingCall_IsInstall();

		/**
		 * The meta object literal for the '<em><b>Is Invoke</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL__IS_INVOKE = eINSTANCE.getMappingCall_IsInvoke();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl <em>Mapping Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingLoop()
		 * @generated
		 */
		EClass MAPPING_LOOP = eINSTANCE.getMappingLoop();

		/**
		 * The meta object literal for the '<em><b>Owned Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_ITERATORS = eINSTANCE.getMappingLoop_OwnedIterators();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_MAPPING_STATEMENTS = eINSTANCE.getMappingLoop_OwnedMappingStatements();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_EXPRESSION = eINSTANCE.getMappingLoop_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterImpl <em>Mapping Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingParameter()
		 * @generated
		 */
		EClass MAPPING_PARAMETER = eINSTANCE.getMappingParameter();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARAMETER__OWNING_MAPPING = eINSTANCE.getMappingParameter_OwningMapping();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl <em>Mapping Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingParameterBinding()
		 * @generated
		 */
		EClass MAPPING_PARAMETER_BINDING = eINSTANCE.getMappingParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL = eINSTANCE.getMappingParameterBinding_OwningMappingCall();

		/**
		 * The meta object literal for the '<em><b>Bound Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARAMETER_BINDING__BOUND_VARIABLE = eINSTANCE.getMappingParameterBinding_BoundVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Parameter Is Mapping Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING_PARAMETER_BINDING___VALIDATE_PARAMETER_IS_MAPPING_PARAMETER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMappingParameterBinding__ValidateParameterIsMappingParameter__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl <em>Mapping Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingStatement()
		 * @generated
		 */
		EClass MAPPING_STATEMENT = eINSTANCE.getMappingStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl <em>New Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getNewStatement()
		 * @generated
		 */
		EClass NEW_STATEMENT = eINSTANCE.getNewStatement();

		/**
		 * The meta object literal for the '<em><b>Is Contained</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_STATEMENT__IS_CONTAINED = eINSTANCE.getNewStatement_IsContained();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_STATEMENT__REFERRED_TYPED_MODEL = eINSTANCE.getNewStatement_ReferredTypedModel();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getNewStatement_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NEW_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getNewStatement__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Non Data Type For Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NEW_STATEMENT___VALIDATE_NON_DATA_TYPE_FOR_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getNewStatement__ValidateNonDataTypeForType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ObservableStatementImpl <em>Observable Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ObservableStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getObservableStatement()
		 * @generated
		 */
		EClass OBSERVABLE_STATEMENT = eINSTANCE.getObservableStatement();

		/**
		 * The meta object literal for the '<em><b>Observed Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES = eINSTANCE.getObservableStatement_ObservedProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl <em>Set Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSetStatement()
		 * @generated
		 */
		EClass SET_STATEMENT = eINSTANCE.getSetStatement();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__TARGET_VARIABLE = eINSTANCE.getSetStatement_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__TARGET_PROPERTY = eINSTANCE.getSetStatement_TargetProperty();

		/**
		 * The meta object literal for the '<em><b>Is Partial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT__IS_PARTIAL = eINSTANCE.getSetStatement_IsPartial();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT__IS_OPPOSITE = eINSTANCE.getSetStatement_IsOpposite();

		/**
		 * The meta object literal for the '<em><b>Is Notify</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT__IS_NOTIFY = eINSTANCE.getSetStatement_IsNotify();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getSetStatement_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Resolved Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__RESOLVED_PROPERTY = eINSTANCE.getSetStatement_ResolvedProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Class For Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SET_STATEMENT___VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSetStatement__ValidateCompatibleClassForProperty__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Partial Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SET_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSetStatement__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Total Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SET_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSetStatement__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Value Does Not Navigate From Realized Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SET_STATEMENT___VALIDATE_VALUE_DOES_NOT_NAVIGATE_FROM_REALIZED_VARIABLES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSetStatement__ValidateValueDoesNotNavigateFromRealizedVariables__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Property Is Not Read Only</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SET_STATEMENT___VALIDATE_TARGET_PROPERTY_IS_NOT_READ_ONLY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSetStatement__ValidateTargetPropertyIsNotReadOnly__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterImpl <em>Simple Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSimpleParameter()
		 * @generated
		 */
		EClass SIMPLE_PARAMETER = eINSTANCE.getSimpleParameter();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PARAMETER__REFERRED_TYPED_MODEL = eINSTANCE.getSimpleParameter_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl <em>Simple Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSimpleParameterBinding()
		 * @generated
		 */
		EClass SIMPLE_PARAMETER_BINDING = eINSTANCE.getSimpleParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PARAMETER_BINDING__VALUE = eINSTANCE.getSimpleParameterBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_PARAMETER_BINDING__IS_CHECK = eINSTANCE.getSimpleParameterBinding_IsCheck();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Checked Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_PARAMETER_BINDING___VALIDATE_COMPATIBLE_TYPE_FOR_CHECKED_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSimpleParameterBinding__ValidateCompatibleTypeForCheckedValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Unchecked Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_PARAMETER_BINDING___VALIDATE_COMPATIBLE_TYPE_FOR_UNCHECKED_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSimpleParameterBinding__ValidateCompatibleTypeForUncheckedValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.StatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '<em><b>Join Names</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STATEMENT___JOIN_NAMES__ELIST = eINSTANCE.getStatement__JoinNames__EList();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl <em>Variable Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getVariableStatement()
		 * @generated
		 */
		EClass VARIABLE_STATEMENT = eINSTANCE.getVariableStatement();

	}

} //QVTimperativePackage
