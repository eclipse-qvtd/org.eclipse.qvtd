/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A GuardParameter of a Mapping defines a input at which a value is consumed from a connection.
 * 
 * syntax: oclText[guard:typedModel name : type;]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getSuccessProperty <em>Success Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getGuardParameter()
 * @generated
 */
public interface GuardParameter extends MappingParameter {
	/**
	 * Returns the value of the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModel that contains the passed value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Typed Model</em>' reference.
	 * @see #setReferredTypedModel(ImperativeTypedModel)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getGuardParameter_ReferredTypedModel()
	 * @generated
	 */
	ImperativeTypedModel getReferredTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getReferredTypedModel <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Typed Model</em>' reference.
	 * @see #getReferredTypedModel()
	 * @generated
	 */
	void setReferredTypedModel(ImperativeTypedModel value);

	/**
	 * Returns the value of the '<em><b>Success Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModel that contains the passed value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Success Property</em>' reference.
	 * @see #setSuccessProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getGuardParameter_SuccessProperty()
	 * @generated
	 */
	Property getSuccessProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getSuccessProperty <em>Success Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success Property</em>' reference.
	 * @see #getSuccessProperty()
	 * @generated
	 */
	void setSuccessProperty(Property value);

} // GuardParameter
