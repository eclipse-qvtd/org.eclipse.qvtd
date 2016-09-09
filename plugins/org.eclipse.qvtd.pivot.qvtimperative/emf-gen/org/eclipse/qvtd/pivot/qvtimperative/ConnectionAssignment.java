/**
 * <copyright>
 *
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ConnectionAssignment assigns initial values to a ConnectionVariable.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#getTargetVariable <em>Target Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#isIsEnforceadUnqiue <em>Is Enforcead Unqiue</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getConnectionAssignment()
 * @generated
 */
public interface ConnectionAssignment extends Assignment {
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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getConnectionAssignment_TargetVariable()
	 * @generated
	 */
	ConnectionVariable getTargetVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#getTargetVariable <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Variable</em>' reference.
	 * @see #getTargetVariable()
	 * @generated
	 */
	void setTargetVariable(ConnectionVariable value);

	/**
	 * Returns the value of the '<em><b>Is Enforcead Unqiue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforcead Unqiue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforcead Unqiue</em>' attribute.
	 * @see #isSetIsEnforceadUnqiue()
	 * @see #unsetIsEnforceadUnqiue()
	 * @see #setIsEnforceadUnqiue(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getConnectionAssignment_IsEnforceadUnqiue()
	 * @generated
	 */
	boolean isIsEnforceadUnqiue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#isIsEnforceadUnqiue <em>Is Enforcead Unqiue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforcead Unqiue</em>' attribute.
	 * @see #isSetIsEnforceadUnqiue()
	 * @see #unsetIsEnforceadUnqiue()
	 * @see #isIsEnforceadUnqiue()
	 * @generated
	 */
	void setIsEnforceadUnqiue(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#isIsEnforceadUnqiue <em>Is Enforcead Unqiue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsEnforceadUnqiue()
	 * @see #isIsEnforceadUnqiue()
	 * @see #setIsEnforceadUnqiue(boolean)
	 * @generated
	 */
	void unsetIsEnforceadUnqiue();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#isIsEnforceadUnqiue <em>Is Enforcead Unqiue</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Enforcead Unqiue</em>' attribute is set.
	 * @see #unsetIsEnforceadUnqiue()
	 * @see #isIsEnforceadUnqiue()
	 * @see #setIsEnforceadUnqiue(boolean)
	 * @generated
	 */
	boolean isSetIsEnforceadUnqiue();

} // ConnectionAssignment
