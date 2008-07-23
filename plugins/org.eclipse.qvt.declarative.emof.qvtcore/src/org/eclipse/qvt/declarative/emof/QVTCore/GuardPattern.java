/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: GuardPattern.java,v 1.1 2008/07/23 09:58:27 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTCore.GuardPattern#getArea <em>Area</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getGuardPattern()
 * @model
 * @generated
 */
public interface GuardPattern extends CorePattern {
	/**
	 * Returns the value of the '<em><b>Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTCore.Area#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' container reference.
	 * @see #setArea(Area)
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage#getGuardPattern_Area()
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Area#getGuardPattern
	 * @model opposite="guardPattern" required="true"
	 * @generated
	 */
	Area getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTCore.GuardPattern#getArea <em>Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' container reference.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(Area value);

} // GuardPattern
