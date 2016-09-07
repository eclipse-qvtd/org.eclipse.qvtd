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
package org.eclipse.qvtd.pivot.qvtcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea <em>Area</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getGuardPattern()
 * @model
 * @generated
 */
public interface GuardPattern extends CorePattern {
	/**
	 * Returns the value of the '<em><b>Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' container reference.
	 * @see #setArea(Area)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getGuardPattern_Area()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern
	 * @model opposite="guardPattern" required="true"
	 * @generated
	 */
	@Override
	Area getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea <em>Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' container reference.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(Area value);

} // GuardPattern
