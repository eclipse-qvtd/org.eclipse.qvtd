/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebasecs;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS#isIsCheck <em>Is Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS#isIsEnforce <em>Is Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getDomainCS()
 * @model
 * @generated
 */
public interface DomainCS extends AreaCS {
	/**
	 * Returns the value of the '<em><b>Is Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Check</em>' attribute.
	 * @see #setIsCheck(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getDomainCS_IsCheck()
	 * @model
	 * @generated
	 */
	boolean isIsCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS#isIsCheck <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Check</em>' attribute.
	 * @see #isIsCheck()
	 * @generated
	 */
	void setIsCheck(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforce</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforce</em>' attribute.
	 * @see #setIsEnforce(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getDomainCS_IsEnforce()
	 * @model
	 * @generated
	 */
	boolean isIsEnforce();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS#isIsEnforce <em>Is Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforce</em>' attribute.
	 * @see #isIsEnforce()
	 * @generated
	 */
	void setIsEnforce(boolean value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' reference.
	 * @see #setDirection(TypedModel)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getDomainCS_Direction()
	 * @model
	 * @generated
	 */
	TypedModel getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS#getDirection <em>Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' reference.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(TypedModel value);

} // DomainCS
