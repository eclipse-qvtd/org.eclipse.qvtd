/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern <em>Bottom Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getArea()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Area extends EObject, Element {
	/**
	 * Returns the value of the '<em><b>Guard Pattern</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Pattern</em>' containment reference.
	 * @see #setGuardPattern(GuardPattern)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getArea_GuardPattern()
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea
	 * @model opposite="area" containment="true" required="true"
	 * @generated
	 */
	GuardPattern getGuardPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern <em>Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Pattern</em>' containment reference.
	 * @see #getGuardPattern()
	 * @generated
	 */
	void setGuardPattern(GuardPattern value);

	/**
	 * Returns the value of the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Pattern</em>' containment reference.
	 * @see #setBottomPattern(BottomPattern)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getArea_BottomPattern()
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea
	 * @model opposite="area" containment="true" required="true"
	 * @generated
	 */
	BottomPattern getBottomPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern <em>Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Pattern</em>' containment reference.
	 * @see #getBottomPattern()
	 * @generated
	 */
	void setBottomPattern(BottomPattern value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Variable> getAllVariables();

} // Area
