/**
 * <copyright>
 *
 * Copyright (c) 2013, 2021 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OperationCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforcement Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getEnforcementMode <em>Enforcement Mode</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getOperationCallExp <em>Operation Call Exp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getEnforcementOperation()
 * @model
 * @generated
 */
public interface EnforcementOperation extends Element {
	/**
	 * Returns the value of the '<em><b>Enforcement Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.pivot.qvtcore.EnforcementMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforcement Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforcement Mode</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementMode
	 * @see #setEnforcementMode(EnforcementMode)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getEnforcementOperation_EnforcementMode()
	 * @model
	 * @generated
	 */
	EnforcementMode getEnforcementMode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getEnforcementMode <em>Enforcement Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforcement Mode</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementMode
	 * @see #getEnforcementMode()
	 * @generated
	 */
	void setEnforcementMode(EnforcementMode value);

	/**
	 * Returns the value of the '<em><b>Bottom Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Pattern</em>' container reference.
	 * @see #setBottomPattern(BottomPattern)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getEnforcementOperation_BottomPattern()
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation
	 * @model opposite="enforcementOperation"
	 * @generated
	 */
	BottomPattern getBottomPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Pattern</em>' container reference.
	 * @see #getBottomPattern()
	 * @generated
	 */
	void setBottomPattern(BottomPattern value);

	/**
	 * Returns the value of the '<em><b>Operation Call Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Call Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Call Exp</em>' containment reference.
	 * @see #setOperationCallExp(OperationCallExp)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getEnforcementOperation_OperationCallExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OperationCallExp getOperationCallExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getOperationCallExp <em>Operation Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Call Exp</em>' containment reference.
	 * @see #getOperationCallExp()
	 * @generated
	 */
	void setOperationCallExp(OperationCallExp value);

} // EnforcementOperation
