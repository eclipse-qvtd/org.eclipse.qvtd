/**
 * <copyright>
 *
 * Copyright (c) 2013, 2020 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtcorecs;

import org.eclipse.ocl.xtext.basecs.NamedElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedGuardPattern <em>Owned Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedBottomPattern <em>Owned Bottom Pattern</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getAreaCS()
 * @model abstract="true"
 * @generated
 */
public interface AreaCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Guard Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Guard Pattern</em>' containment reference.
	 * @see #setOwnedGuardPattern(GuardPatternCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getAreaCS_OwnedGuardPattern()
	 * @model containment="true"
	 * @generated
	 */
	GuardPatternCS getOwnedGuardPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedGuardPattern <em>Owned Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Guard Pattern</em>' containment reference.
	 * @see #getOwnedGuardPattern()
	 * @generated
	 */
	void setOwnedGuardPattern(GuardPatternCS value);

	/**
	 * Returns the value of the '<em><b>Owned Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Bottom Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Bottom Pattern</em>' containment reference.
	 * @see #setOwnedBottomPattern(BottomPatternCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getAreaCS_OwnedBottomPattern()
	 * @model containment="true"
	 * @generated
	 */
	BottomPatternCS getOwnedBottomPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecs.AreaCS#getOwnedBottomPattern <em>Owned Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Bottom Pattern</em>' containment reference.
	 * @see #getOwnedBottomPattern()
	 * @generated
	 */
	void setOwnedBottomPattern(BottomPatternCS value);

} // AreaCS
