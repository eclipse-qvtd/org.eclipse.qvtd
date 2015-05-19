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

import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforcement Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS#isIsDeletion <em>Is Deletion</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS#getOwnedOperationCall <em>Owned Operation Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getEnforcementOperationCS()
 * @model
 * @generated
 */
public interface EnforcementOperationCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Is Deletion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Deletion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Deletion</em>' attribute.
	 * @see #setIsDeletion(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getEnforcementOperationCS_IsDeletion()
	 * @model
	 * @generated
	 */
	boolean isIsDeletion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS#isIsDeletion <em>Is Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Deletion</em>' attribute.
	 * @see #isIsDeletion()
	 * @generated
	 */
	void setIsDeletion(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Operation Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation Call</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operation Call</em>' containment reference.
	 * @see #setOwnedOperationCall(NameExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getEnforcementOperationCS_OwnedOperationCall()
	 * @model containment="true"
	 * @generated
	 */
	NameExpCS getOwnedOperationCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS#getOwnedOperationCall <em>Owned Operation Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Operation Call</em>' containment reference.
	 * @see #getOwnedOperationCall()
	 * @generated
	 */
	void setOwnedOperationCall(NameExpCS value);

} // EnforcementOperationCS
