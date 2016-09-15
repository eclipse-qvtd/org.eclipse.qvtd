/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ConnectionVariable accumulates one or more assignments.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.GuardVariable#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getGuardVariable()
 * @generated
 */
public interface GuardVariable extends VariableDeclaration {
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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getGuardVariable_ReferredTypedModel()
	 * @generated
	 */
	TypedModel getReferredTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardVariable#getReferredTypedModel <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Typed Model</em>' reference.
	 * @see #getReferredTypedModel()
	 * @generated
	 */
	void setReferredTypedModel(TypedModel value);

} // GuardVariable
