/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The QVTiCGModel exends the Code Generation friendly form of the OCL Pivot model with QVTi-specific constructs.
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface QVTiCGModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvticgmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvti/0.12.0/CG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvticg";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.codegen.qvticgmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@NonNull QVTiCGModelPackage eINSTANCE = org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment <em>CG Ecore Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Property Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment
	 * @generated
	 */
	EClass getCGEcorePropertyAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EStructural Feature</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment#getEStructuralFeature()
	 * @see #getCGEcorePropertyAssignment()
	 * @generated
	 */
	EReference getCGEcorePropertyAssignment_EStructuralFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable <em>CG Ecore Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Realized Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable
	 * @generated
	 */
	EClass getCGEcoreRealizedVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable#getEClassifier <em>EClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClassifier</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable#getEClassifier()
	 * @see #getCGEcoreRealizedVariable()
	 * @generated
	 */
	EReference getCGEcoreRealizedVariable_EClassifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunction <em>CG Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Function</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunction
	 * @generated
	 */
	EClass getCGFunction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp <em>CG Function Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Function Call Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp
	 * @generated
	 */
	EClass getCGFunctionCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp#getFunction()
	 * @see #getCGFunctionCallExp()
	 * @generated
	 */
	EReference getCGFunctionCallExp_Function();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter <em>CG Function Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Function Parameter</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter
	 * @generated
	 */
	EClass getCGFunctionParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter#getFunction()
	 * @see #getCGFunctionParameter()
	 * @generated
	 */
	EReference getCGFunctionParameter_Function();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable <em>CG Guard Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Guard Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable
	 * @generated
	 */
	EClass getCGGuardVariable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getOwningMapping()
	 * @see #getCGGuardVariable()
	 * @generated
	 */
	EReference getCGGuardVariable_OwningMapping();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getTypedModel()
	 * @see #getCGGuardVariable()
	 * @generated
	 */
	EReference getCGGuardVariable_TypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment <em>CG Connection Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Connection Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment
	 * @generated
	 */
	EClass getCGConnectionAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_OwningMapping();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getConnectionVariable <em>Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getConnectionVariable()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_ConnectionVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwnedInitValue <em>Owned Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwnedInitValue()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_OwnedInitValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable <em>CG Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Connection Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable
	 * @generated
	 */
	EClass getCGConnectionVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment <em>CG Ecore Container Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Container Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment
	 * @generated
	 */
	EClass getCGEcoreContainerAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EStructural Feature</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment#getEStructuralFeature()
	 * @see #getCGEcoreContainerAssignment()
	 * @generated
	 */
	EReference getCGEcoreContainerAssignment_EStructuralFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment <em>CG Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Property Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment
	 * @generated
	 */
	EClass getCGPropertyAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwningMapping()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_OwningMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getReferredProperty()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EAttribute getCGPropertyAssignment_ReferredProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getExecutorProperty <em>Executor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor Property</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getExecutorProperty()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_ExecutorProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedInitValue <em>Owned Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedInitValue()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_OwnedInitValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedSlotValue <em>Owned Slot Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Slot Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedSlotValue()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_OwnedSlotValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping <em>CG Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping
	 * @generated
	 */
	EClass getCGMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedAssignments <em>Owned Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedAssignments()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedAssignments();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedBody()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedBody();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedConnectionAssignments <em>Owned Connection Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Connection Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedConnectionAssignments()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedConnectionAssignments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedGuardVariables <em>Owned Guard Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Guard Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedGuardVariables()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedGuardVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedRealizedVariables <em>Owned Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Realized Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedRealizedVariables()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedRealizedVariables();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation <em>Owning Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwningTransformation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#isUseClass <em>Use Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Class</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#isUseClass()
	 * @see #getCGMapping()
	 * @generated
	 */
	EAttribute getCGMapping_UseClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation <em>CG Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation
	 * @generated
	 */
	EClass getCGTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedMappings <em>Owned Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mappings</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedMappings()
	 * @see #getCGTransformation()
	 * @generated
	 */
	EReference getCGTransformation_OwnedMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedTypedModels <em>Owned Typed Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Typed Models</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedTypedModels()
	 * @see #getCGTransformation()
	 * @generated
	 */
	EReference getCGTransformation_OwnedTypedModels();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel <em>CG Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Typed Model</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel
	 * @generated
	 */
	EClass getCGTypedModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getModelIndex <em>Model Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Index</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getModelIndex()
	 * @see #getCGTypedModel()
	 * @generated
	 */
	EAttribute getCGTypedModel_ModelIndex();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getOwningTransformation <em>Owning Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getOwningTransformation()
	 * @see #getCGTypedModel()
	 * @generated
	 */
	EReference getCGTypedModel_OwningTransformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall <em>CG Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Call</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall
	 * @generated
	 */
	EClass getCGMappingCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getOwnedMappingCallBindings <em>Owned Mapping Call Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Call Bindings</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getOwnedMappingCallBindings()
	 * @see #getCGMappingCall()
	 * @generated
	 */
	EReference getCGMappingCall_OwnedMappingCallBindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding <em>CG Mapping Call Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Call Binding</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding
	 * @generated
	 */
	EClass getCGMappingCallBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwnedValue <em>Owned Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwnedValue()
	 * @see #getCGMappingCallBinding()
	 * @generated
	 */
	EReference getCGMappingCallBinding_OwnedValue();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall <em>Owning Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping Call</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall()
	 * @see #getCGMappingCallBinding()
	 * @generated
	 */
	EReference getCGMappingCallBinding_OwningMappingCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp <em>CG Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp
	 * @generated
	 */
	EClass getCGMappingExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedAccumulators <em>Owned Accumulators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulators</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedAccumulators()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_OwnedAccumulators();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedBody()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_OwnedBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop <em>CG Mapping Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Loop</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop
	 * @generated
	 */
	EClass getCGMappingLoop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment <em>CG Middle Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Middle Property Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment
	 * @generated
	 */
	EClass getCGMiddlePropertyAssignment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp <em>CG Middle Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Middle Property Call Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp
	 * @generated
	 */
	EClass getCGMiddlePropertyCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable <em>CG Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Realized Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable
	 * @generated
	 */
	EClass getCGRealizedVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getTypedModel()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_TypedModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwnedParts()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart <em>CG Realized Variable Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Realized Variable Part</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart
	 * @generated
	 */
	EClass getCGRealizedVariablePart();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getOwningRealizedVariable <em>Owning Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Realized Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getOwningRealizedVariable()
	 * @see #getCGRealizedVariablePart()
	 * @generated
	 */
	EReference getCGRealizedVariablePart_OwningRealizedVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getInit()
	 * @see #getCGRealizedVariablePart()
	 * @generated
	 */
	EReference getCGRealizedVariablePart_Init();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getExecutorProperty <em>Executor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor Property</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getExecutorProperty()
	 * @see #getCGRealizedVariablePart()
	 * @generated
	 */
	EReference getCGRealizedVariablePart_ExecutorProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSequence <em>CG Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Sequence</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSequence
	 * @generated
	 */
	EClass getCGSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSequence#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Statements</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSequence#getOwnedStatements()
	 * @see #getCGSequence()
	 * @generated
	 */
	EReference getCGSequence_OwnedStatements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp <em>CG Speculate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Speculate Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp
	 * @generated
	 */
	EClass getCGSpeculateExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp#getParts()
	 * @see #getCGSpeculateExp()
	 * @generated
	 */
	EReference getCGSpeculateExp_Parts();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp#getSpeculated <em>Speculated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Speculated</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp#getSpeculated()
	 * @see #getCGSpeculateExp()
	 * @generated
	 */
	EReference getCGSpeculateExp_Speculated();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart <em>CG Speculate Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Speculate Part</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart
	 * @generated
	 */
	EClass getCGSpeculatePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart#getObjectExp <em>Object Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart#getObjectExp()
	 * @see #getCGSpeculatePart()
	 * @generated
	 */
	EReference getCGSpeculatePart_ObjectExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EStructural Feature</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart#getEStructuralFeature()
	 * @see #getCGSpeculatePart()
	 * @generated
	 */
	EReference getCGSpeculatePart_EStructuralFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getExecutorType <em>Executor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor Type</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getExecutorType()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_ExecutorType();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwningMapping()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_OwningMapping();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTiCGModelFactory getQVTiCGModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl <em>CG Connection Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGConnectionAssignment()
		 * @generated
		 */
		EClass CG_CONNECTION_ASSIGNMENT = eINSTANCE.getCGConnectionAssignment();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING = eINSTANCE.getCGConnectionAssignment_OwningMapping();

		/**
		 * The meta object literal for the '<em><b>Connection Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE = eINSTANCE.getCGConnectionAssignment_ConnectionVariable();

		/**
		 * The meta object literal for the '<em><b>Owned Init Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE = eINSTANCE.getCGConnectionAssignment_OwnedInitValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionVariableImpl <em>CG Connection Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGConnectionVariable()
		 * @generated
		 */
		EClass CG_CONNECTION_VARIABLE = eINSTANCE.getCGConnectionVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreContainerAssignmentImpl <em>CG Ecore Container Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreContainerAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcoreContainerAssignment()
		 * @generated
		 */
		EClass CG_ECORE_CONTAINER_ASSIGNMENT = eINSTANCE.getCGEcoreContainerAssignment();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_CONTAINER_ASSIGNMENT__ESTRUCTURAL_FEATURE = eINSTANCE.getCGEcoreContainerAssignment_EStructuralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl <em>CG Ecore Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcorePropertyAssignment()
		 * @generated
		 */
		EClass CG_ECORE_PROPERTY_ASSIGNMENT = eINSTANCE.getCGEcorePropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_PROPERTY_ASSIGNMENT__ESTRUCTURAL_FEATURE = eINSTANCE.getCGEcorePropertyAssignment_EStructuralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl <em>CG Ecore Realized Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcoreRealizedVariable()
		 * @generated
		 */
		EClass CG_ECORE_REALIZED_VARIABLE = eINSTANCE.getCGEcoreRealizedVariable();

		/**
		 * The meta object literal for the '<em><b>EClassifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_REALIZED_VARIABLE__ECLASSIFIER = eINSTANCE.getCGEcoreRealizedVariable_EClassifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl <em>CG Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunction()
		 * @generated
		 */
		EClass CG_FUNCTION = eINSTANCE.getCGFunction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl <em>CG Function Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionCallExp()
		 * @generated
		 */
		EClass CG_FUNCTION_CALL_EXP = eINSTANCE.getCGFunctionCallExp();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_FUNCTION_CALL_EXP__FUNCTION = eINSTANCE.getCGFunctionCallExp_Function();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl <em>CG Function Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionParameter()
		 * @generated
		 */
		EClass CG_FUNCTION_PARAMETER = eINSTANCE.getCGFunctionParameter();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_FUNCTION_PARAMETER__FUNCTION = eINSTANCE.getCGFunctionParameter_Function();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl <em>CG Guard Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGGuardVariable()
		 * @generated
		 */
		EClass CG_GUARD_VARIABLE = eINSTANCE.getCGGuardVariable();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_GUARD_VARIABLE__OWNING_MAPPING = eINSTANCE.getCGGuardVariable_OwningMapping();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_GUARD_VARIABLE__TYPED_MODEL = eINSTANCE.getCGGuardVariable_TypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl <em>CG Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGPropertyAssignment()
		 * @generated
		 */
		EClass CG_PROPERTY_ASSIGNMENT = eINSTANCE.getCGPropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING = eINSTANCE.getCGPropertyAssignment_OwningMapping();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = eINSTANCE.getCGPropertyAssignment_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Executor Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = eINSTANCE.getCGPropertyAssignment_ExecutorProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Init Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE = eINSTANCE.getCGPropertyAssignment_OwnedInitValue();

		/**
		 * The meta object literal for the '<em><b>Owned Slot Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE = eINSTANCE.getCGPropertyAssignment_OwnedSlotValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl <em>CG Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMapping()
		 * @generated
		 */
		EClass CG_MAPPING = eINSTANCE.getCGMapping();

		/**
		 * The meta object literal for the '<em><b>Owned Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_ASSIGNMENTS = eINSTANCE.getCGMapping_OwnedAssignments();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_BODY = eINSTANCE.getCGMapping_OwnedBody();

		/**
		 * The meta object literal for the '<em><b>Owned Connection Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS = eINSTANCE.getCGMapping_OwnedConnectionAssignments();

		/**
		 * The meta object literal for the '<em><b>Owned Guard Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_GUARD_VARIABLES = eINSTANCE.getCGMapping_OwnedGuardVariables();

		/**
		 * The meta object literal for the '<em><b>Owned Realized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_REALIZED_VARIABLES = eINSTANCE.getCGMapping_OwnedRealizedVariables();

		/**
		 * The meta object literal for the '<em><b>Owning Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNING_TRANSFORMATION = eINSTANCE.getCGMapping_OwningTransformation();

		/**
		 * The meta object literal for the '<em><b>Use Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_MAPPING__USE_CLASS = eINSTANCE.getCGMapping_UseClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl <em>CG Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTransformation()
		 * @generated
		 */
		EClass CG_TRANSFORMATION = eINSTANCE.getCGTransformation();

		/**
		 * The meta object literal for the '<em><b>Owned Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TRANSFORMATION__OWNED_MAPPINGS = eINSTANCE.getCGTransformation_OwnedMappings();

		/**
		 * The meta object literal for the '<em><b>Owned Typed Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TRANSFORMATION__OWNED_TYPED_MODELS = eINSTANCE.getCGTransformation_OwnedTypedModels();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl <em>CG Typed Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTypedModel()
		 * @generated
		 */
		EClass CG_TYPED_MODEL = eINSTANCE.getCGTypedModel();

		/**
		 * The meta object literal for the '<em><b>Model Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TYPED_MODEL__MODEL_INDEX = eINSTANCE.getCGTypedModel_ModelIndex();

		/**
		 * The meta object literal for the '<em><b>Owning Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TYPED_MODEL__OWNING_TRANSFORMATION = eINSTANCE.getCGTypedModel_OwningTransformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl <em>CG Mapping Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCall()
		 * @generated
		 */
		EClass CG_MAPPING_CALL = eINSTANCE.getCGMappingCall();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Call Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL__OWNED_MAPPING_CALL_BINDINGS = eINSTANCE.getCGMappingCall_OwnedMappingCallBindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl <em>CG Mapping Call Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCallBinding()
		 * @generated
		 */
		EClass CG_MAPPING_CALL_BINDING = eINSTANCE.getCGMappingCallBinding();

		/**
		 * The meta object literal for the '<em><b>Owned Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL_BINDING__OWNED_VALUE = eINSTANCE.getCGMappingCallBinding_OwnedValue();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL_BINDING__OWNING_MAPPING_CALL = eINSTANCE.getCGMappingCallBinding_OwningMappingCall();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl <em>CG Mapping Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingExp()
		 * @generated
		 */
		EClass CG_MAPPING_EXP = eINSTANCE.getCGMappingExp();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__OWNED_ACCUMULATORS = eINSTANCE.getCGMappingExp_OwnedAccumulators();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__OWNED_BODY = eINSTANCE.getCGMappingExp_OwnedBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl <em>CG Mapping Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingLoop()
		 * @generated
		 */
		EClass CG_MAPPING_LOOP = eINSTANCE.getCGMappingLoop();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyAssignmentImpl <em>CG Middle Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMiddlePropertyAssignment()
		 * @generated
		 */
		EClass CG_MIDDLE_PROPERTY_ASSIGNMENT = eINSTANCE.getCGMiddlePropertyAssignment();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyCallExpImpl <em>CG Middle Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyCallExpImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMiddlePropertyCallExp()
		 * @generated
		 */
		EClass CG_MIDDLE_PROPERTY_CALL_EXP = eINSTANCE.getCGMiddlePropertyCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl <em>CG Realized Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGRealizedVariable()
		 * @generated
		 */
		EClass CG_REALIZED_VARIABLE = eINSTANCE.getCGRealizedVariable();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__TYPED_MODEL = eINSTANCE.getCGRealizedVariable_TypedModel();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__OWNED_PARTS = eINSTANCE.getCGRealizedVariable_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariablePartImpl <em>CG Realized Variable Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariablePartImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGRealizedVariablePart()
		 * @generated
		 */
		EClass CG_REALIZED_VARIABLE_PART = eINSTANCE.getCGRealizedVariablePart();

		/**
		 * The meta object literal for the '<em><b>Owning Realized Variable</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE_PART__OWNING_REALIZED_VARIABLE = eINSTANCE.getCGRealizedVariablePart_OwningRealizedVariable();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE_PART__INIT = eINSTANCE.getCGRealizedVariablePart_Init();

		/**
		 * The meta object literal for the '<em><b>Executor Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE_PART__EXECUTOR_PROPERTY = eINSTANCE.getCGRealizedVariablePart_ExecutorProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSequenceImpl <em>CG Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSequenceImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGSequence()
		 * @generated
		 */
		EClass CG_SEQUENCE = eINSTANCE.getCGSequence();

		/**
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_SEQUENCE__OWNED_STATEMENTS = eINSTANCE.getCGSequence_OwnedStatements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSpeculateExpImpl <em>CG Speculate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSpeculateExpImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGSpeculateExp()
		 * @generated
		 */
		EClass CG_SPECULATE_EXP = eINSTANCE.getCGSpeculateExp();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_SPECULATE_EXP__PARTS = eINSTANCE.getCGSpeculateExp_Parts();

		/**
		 * The meta object literal for the '<em><b>Speculated</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_SPECULATE_EXP__SPECULATED = eINSTANCE.getCGSpeculateExp_Speculated();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSpeculatePartImpl <em>CG Speculate Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSpeculatePartImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGSpeculatePart()
		 * @generated
		 */
		EClass CG_SPECULATE_PART = eINSTANCE.getCGSpeculatePart();

		/**
		 * The meta object literal for the '<em><b>Object Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_SPECULATE_PART__OBJECT_EXP = eINSTANCE.getCGSpeculatePart_ObjectExp();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_SPECULATE_PART__ESTRUCTURAL_FEATURE = eINSTANCE.getCGSpeculatePart_EStructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Executor Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__EXECUTOR_TYPE = eINSTANCE.getCGRealizedVariable_ExecutorType();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__OWNING_MAPPING = eINSTANCE.getCGRealizedVariable_OwningMapping();

	}

} //QVTiCGmodelPackage
