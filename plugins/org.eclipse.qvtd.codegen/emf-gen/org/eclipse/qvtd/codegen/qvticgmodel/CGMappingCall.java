/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel;

import java.util.List;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getOwnedMappingCallBindings <em>Owned Mapping Call Bindings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getReferredMapping <em>Referred Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCall()
 * @model
 * @generated
 */
public interface CGMappingCall extends CGValuedElement {

	/**
	 * Returns the value of the '<em><b>Owned Mapping Call Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall <em>Owning Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mapping Call Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mapping Call Bindings</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCall_OwnedMappingCallBindings()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall
	 * @model opposite="owningMappingCall" containment="true"
	 * @generated
	 */
	List<CGMappingCallBinding> getOwnedMappingCallBindings();

	/**
	 * Returns the value of the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The this expression for the call when invoking a native or ecore implementation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Mapping</em>' reference.
	 * @see #setReferredMapping(CGMapping)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCall_ReferredMapping()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGMapping getReferredMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getReferredMapping <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Mapping</em>' reference.
	 * @see #getReferredMapping()
	 * @generated
	 */
	void setReferredMapping(CGMapping value);
} // CGMappingCall
