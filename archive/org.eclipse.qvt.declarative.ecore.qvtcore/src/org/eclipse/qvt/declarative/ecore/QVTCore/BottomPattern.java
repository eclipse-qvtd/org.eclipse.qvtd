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
 * $Id: BottomPattern.java,v 1.1 2008/07/23 09:43:24 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bottom Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern#getRealizedVariable <em>Realized Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getBottomPattern()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='RealizedVariableNamesAreUnique'"
 * @generated
 */
public interface BottomPattern extends CorePattern {
	/**
	 * Returns the value of the '<em><b>Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.Area#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' container reference.
	 * @see #setArea(Area)
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getBottomPattern_Area()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.Area#getBottomPattern
	 * @model opposite="bottomPattern" required="true"
	 * @generated
	 */
	Area getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern#getArea <em>Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' container reference.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(Area value);

	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTCore.Assignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.Assignment#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getBottomPattern_Assignment()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.Assignment#getBottomPattern
	 * @model opposite="bottomPattern" containment="true" ordered="false"
	 * @generated
	 */
	EList<Assignment> getAssignment();

	/**
	 * Returns the value of the '<em><b>Enforcement Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforcement Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforcement Operation</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getBottomPattern_EnforcementOperation()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getBottomPattern
	 * @model opposite="bottomPattern" containment="true" ordered="false"
	 * @generated
	 */
	EList<EnforcementOperation> getEnforcementOperation();

	/**
	 * Returns the value of the '<em><b>Realized Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTCore.RealizedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variable</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getBottomPattern_RealizedVariable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<RealizedVariable> getRealizedVariable();

} // BottomPattern
