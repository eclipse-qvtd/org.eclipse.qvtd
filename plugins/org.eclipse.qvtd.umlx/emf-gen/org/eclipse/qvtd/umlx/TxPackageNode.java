/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Package Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredPackage <em>Referred Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public interface TxPackageNode extends TxNode {
	/**
	 * Returns the value of the '<em><b>Referred Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Package</em>' reference.
	 * @see #setReferredPackage(EPackage)
	 * @generated
	 */
	EPackage getReferredPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredPackage <em>Referred Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Package</em>' reference.
	 * @see #getReferredPackage()
	 * @generated
	 */
	void setReferredPackage(EPackage value);

} // TxPackageNode
