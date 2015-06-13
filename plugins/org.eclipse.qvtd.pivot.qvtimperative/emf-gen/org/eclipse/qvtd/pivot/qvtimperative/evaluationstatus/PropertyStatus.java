/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssignable <em>Is Assignable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssigned <em>Is Assigned</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsDirty <em>Is Dirty</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsError <em>Is Error</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsReady <em>Is Ready</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getPropertyStatus()
 * @model abstract="true"
 * @generated
 */
public interface PropertyStatus extends ElementStatus {
	/**
	 * Returns the value of the '<em><b>Is Assignable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Assignable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Assignable</em>' attribute.
	 * @see #setIsAssignable(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getPropertyStatus_IsAssignable()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsAssignable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssignable <em>Is Assignable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Assignable</em>' attribute.
	 * @see #isIsAssignable()
	 * @generated
	 */
	void setIsAssignable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Assigned</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Assigned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Assigned</em>' attribute.
	 * @see #setIsAssigned(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getPropertyStatus_IsAssigned()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsAssigned();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsAssigned <em>Is Assigned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Assigned</em>' attribute.
	 * @see #isIsAssigned()
	 * @generated
	 */
	void setIsAssigned(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Dirty</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Dirty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Dirty</em>' attribute.
	 * @see #setIsDirty(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getPropertyStatus_IsDirty()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsDirty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsDirty <em>Is Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Dirty</em>' attribute.
	 * @see #isIsDirty()
	 * @generated
	 */
	void setIsDirty(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Error</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Error</em>' attribute.
	 * @see #setIsError(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getPropertyStatus_IsError()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsError();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsError <em>Is Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Error</em>' attribute.
	 * @see #isIsError()
	 * @generated
	 */
	void setIsError(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Ready</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ready</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ready</em>' attribute.
	 * @see #setIsReady(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage#getPropertyStatus_IsReady()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsReady();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus#isIsReady <em>Is Ready</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ready</em>' attribute.
	 * @see #isIsReady()
	 * @generated
	 */
	void setIsReady(boolean value);

} // PropertyStatus
