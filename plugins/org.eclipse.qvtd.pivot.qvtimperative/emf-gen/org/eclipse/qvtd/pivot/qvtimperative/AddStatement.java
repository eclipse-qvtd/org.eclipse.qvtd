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
 * A representation of the model object '<em><b>Add Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ConnectionStatement assigns results to a ConnectionVariable.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getTargetVariable <em>Target Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedInit <em>Owned Init</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#isIsEnforcedUnique <em>Is Enforced Unique</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAddStatement()
 * @generated
 */
public interface AddStatement extends MappingStatement {
	/**
	 * Returns the value of the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Variable</em>' reference.
	 * @see #setTargetVariable(ConnectionVariable)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAddStatement_TargetVariable()
	 * @generated
	 */
	ConnectionVariable getTargetVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getTargetVariable <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Variable</em>' reference.
	 * @see #getTargetVariable()
	 * @generated
	 */
	void setTargetVariable(ConnectionVariable value);

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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAddStatement_OwnedInit()
	 * @generated
	 */
	OCLExpression getOwnedInit();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedInit <em>Owned Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init</em>' containment reference.
	 * @see #getOwnedInit()
	 * @generated
	 */
	void setOwnedInit(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Is Enforced Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforced Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforced Unique</em>' attribute.
	 * @see #setIsEnforcedUnique(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAddStatement_IsEnforcedUnique()
	 * @generated
	 */
	boolean isIsEnforcedUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#isIsEnforcedUnique <em>Is Enforced Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforced Unique</em>' attribute.
	 * @see #isIsEnforcedUnique()
	 * @generated
	 */
	void setIsEnforcedUnique(boolean value);

} // AddStatement
