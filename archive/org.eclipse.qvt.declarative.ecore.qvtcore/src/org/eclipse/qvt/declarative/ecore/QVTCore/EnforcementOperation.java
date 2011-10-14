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
 * $Id: EnforcementOperation.java,v 1.1 2008/07/23 09:43:24 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore;

import org.eclipse.emf.ecore.EModelElement;

import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforcement Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getEnforcementMode <em>Enforcement Mode</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getOperationCallExp <em>Operation Call Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getEnforcementOperation()
 * @model
 * @generated
 */
public interface EnforcementOperation extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Enforcement Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforcement Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforcement Mode</em>' attribute.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementMode
	 * @see #setEnforcementMode(EnforcementMode)
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getEnforcementOperation_EnforcementMode()
	 * @model
	 * @generated
	 */
	EnforcementMode getEnforcementMode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getEnforcementMode <em>Enforcement Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforcement Mode</em>' attribute.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementMode
	 * @see #getEnforcementMode()
	 * @generated
	 */
	void setEnforcementMode(EnforcementMode value);

	/**
	 * Returns the value of the '<em><b>Bottom Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Pattern</em>' container reference.
	 * @see #setBottomPattern(BottomPattern)
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getEnforcementOperation_BottomPattern()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern#getEnforcementOperation
	 * @model opposite="enforcementOperation"
	 * @generated
	 */
	BottomPattern getBottomPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}' container reference.
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
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getEnforcementOperation_OperationCallExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OperationCallExp getOperationCallExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation#getOperationCallExp <em>Operation Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Call Exp</em>' containment reference.
	 * @see #getOperationCallExp()
	 * @generated
	 */
	void setOperationCallExp(OperationCallExp value);

} // EnforcementOperation
