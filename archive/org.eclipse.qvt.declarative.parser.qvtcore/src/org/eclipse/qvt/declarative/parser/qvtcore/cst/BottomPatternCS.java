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
 * $Id: BottomPatternCS.java,v 1.1 2008/07/23 10:06:42 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bottom Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS#getEnforcementOperations <em>Enforcement Operations</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS#getRealizedVariables <em>Realized Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getBottomPatternCS()
 * @model
 * @generated
 */
public interface BottomPatternCS extends PatternCS {
	/**
	 * Returns the value of the '<em><b>Enforcement Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforcement Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforcement Operations</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getBottomPatternCS_EnforcementOperations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnforcementOperationCS> getEnforcementOperations();

	/**
	 * Returns the value of the '<em><b>Realized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizedVariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variables</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getBottomPatternCS_RealizedVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<RealizedVariableCS> getRealizedVariables();

} // BottomPatternCS
