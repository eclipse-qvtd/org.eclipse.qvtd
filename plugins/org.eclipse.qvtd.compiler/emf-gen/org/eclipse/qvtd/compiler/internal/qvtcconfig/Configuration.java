/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.compiler.internal.qvtcconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getInputDirection <em>Input Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getOutputDirection <em>Output Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMiddle <em>Middle</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Direction</em>' reference.
	 * @see #setInputDirection(Direction)
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getConfiguration_InputDirection()
	 * @model required="true"
	 * @generated
	 */
	Direction getInputDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getInputDirection <em>Input Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Direction</em>' reference.
	 * @see #getInputDirection()
	 * @generated
	 */
	void setInputDirection(Direction value);

	/**
	 * Returns the value of the '<em><b>Output Direction</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Direction</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Direction</em>' reference list.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getConfiguration_OutputDirection()
	 * @model
	 * @generated
	 */
	EList<Direction> getOutputDirection();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode
	 * @see #setMode(Mode)
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getConfiguration_Mode()
	 * @model required="true"
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' containment reference.
	 * @see #setTransformation(Transformation)
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getConfiguration_Transformation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getTransformation <em>Transformation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' containment reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Middle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Middle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Middle</em>' reference.
	 * @see #setMiddle(Direction)
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getConfiguration_Middle()
	 * @model required="true"
	 * @generated
	 */
	Direction getMiddle();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration#getMiddle <em>Middle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Middle</em>' reference.
	 * @see #getMiddle()
	 * @generated
	 */
	void setMiddle(Direction value);

} // Configuration
