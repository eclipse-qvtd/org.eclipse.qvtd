/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS#getSuccessProperty <em>Success Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getGuardParameterCS()
 * @model
 * @generated
 */
public interface GuardParameterCS extends MappingParameterCS {
	/**
	 * Returns the value of the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Typed Model</em>' reference.
	 * @see #setReferredTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getGuardParameterCS_ReferredTypedModel()
	 * @model required="true"
	 * @generated
	 */
	TypedModel getReferredTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS#getReferredTypedModel <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Typed Model</em>' reference.
	 * @see #getReferredTypedModel()
	 * @generated
	 */
	void setReferredTypedModel(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Success Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Success Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success Property</em>' reference.
	 * @see #setSuccessProperty(Property)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getGuardParameterCS_SuccessProperty()
	 * @model
	 * @generated
	 */
	Property getSuccessProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS#getSuccessProperty <em>Success Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success Property</em>' reference.
	 * @see #getSuccessProperty()
	 * @generated
	 */
	void setSuccessProperty(Property value);

} // GuardParameterCS
