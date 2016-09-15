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

import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Connection Variable</b></em>'.
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable#getOwnedInit <em>Owned Init</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getOutConnectionVariable()
 * @generated
 */
public interface OutConnectionVariable extends ConnectionVariable, VariableStatement {
	/**
	 * Returns the value of the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init</em>' containment reference.
	 * @see #setOwnedInit(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getOutConnectionVariable_OwnedInit()
	 * @generated
	 */
	OCLExpression getOwnedInit();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable#getOwnedInit <em>Owned Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init</em>' containment reference.
	 * @see #getOwnedInit()
	 * @generated
	 */
	void setOwnedInit(OCLExpression value);

} // OutConnectionVariable
