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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bottom Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getRealizedVariable <em>Realized Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern()
 * @model
 * @generated
 */
public interface BottomPattern extends CorePattern {
	/**
	 * Returns the value of the '<em><b>Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' container reference.
	 * @see #setArea(Area)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_Area()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern
	 * @model opposite="bottomPattern" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!BottomPattern!area'"
	 * @generated
	 */
	@Override
	Area getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea <em>Area</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' container reference.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(Area value);

	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Assignment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_Assignment()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern
	 * @model opposite="bottomPattern" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!BottomPattern!assignment'"
	 * @generated
	 */
	EList<Assignment> getAssignment();

	/**
	 * Returns the value of the '<em><b>Enforcement Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforcement Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforcement Operation</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_EnforcementOperation()
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern
	 * @model opposite="bottomPattern" containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!BottomPattern!enforcementOperation'"
	 * @generated
	 */
	EList<EnforcementOperation> getEnforcementOperation();

	/**
	 * Returns the value of the '<em><b>Realized Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.RealizedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variable</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getBottomPattern_RealizedVariable()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTcore!BottomPattern!realizedVariable'"
	 * @generated
	 */
	EList<RealizedVariable> getRealizedVariable();

} // BottomPattern
