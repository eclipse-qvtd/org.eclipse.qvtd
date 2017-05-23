/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Mapping Call Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall <em>Owning Mapping Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCallBinding()
 * @model
 * @generated
 */
public interface CGMappingCallBinding extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Owned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Value</em>' containment reference.
	 * @see #setOwnedValue(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCallBinding_OwnedValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getOwnedValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwnedValue <em>Owned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Value</em>' containment reference.
	 * @see #getOwnedValue()
	 * @generated
	 */
	void setOwnedValue(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Owning Mapping Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getOwnedMappingCallBindings <em>Owned Mapping Call Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Mapping Call</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Mapping Call</em>' container reference.
	 * @see #setOwningMappingCall(CGMappingCall)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCallBinding_OwningMappingCall()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getOwnedMappingCallBindings
	 * @model opposite="ownedMappingCallBindings" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGMappingCall getOwningMappingCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall <em>Owning Mapping Call</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Mapping Call</em>' container reference.
	 * @see #getOwningMappingCall()
	 * @generated
	 */
	void setOwningMappingCall(CGMappingCall value);

} // CGMappingCallBinding
