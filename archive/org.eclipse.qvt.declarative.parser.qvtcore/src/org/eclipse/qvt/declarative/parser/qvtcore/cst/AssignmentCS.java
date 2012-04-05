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
 * $Id: AssignmentCS.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getInitialiser <em>Initialiser</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#isDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getAssignmentCS()
 * @model
 * @generated
 */
public interface AssignmentCS extends OCLExpressionCS {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(OCLExpressionCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getAssignmentCS_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OCLExpressionCS getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialiser</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialiser</em>' containment reference.
	 * @see #setInitialiser(OCLExpressionCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getAssignmentCS_Initialiser()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OCLExpressionCS getInitialiser();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#getInitialiser <em>Initialiser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialiser</em>' containment reference.
	 * @see #getInitialiser()
	 * @generated
	 */
	void setInitialiser(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getAssignmentCS_Default()
	 * @model
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

} // AssignmentCS
