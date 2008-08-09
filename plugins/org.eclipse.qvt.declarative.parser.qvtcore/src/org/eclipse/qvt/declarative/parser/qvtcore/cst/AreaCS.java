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
 * $Id: AreaCS.java,v 1.2 2008/08/09 17:42:08 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Area CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getBottomPattern <em>Bottom Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getAreaCS()
 * @model abstract="true"
 * @generated
 */
public interface AreaCS extends IdentifiedCS {
	/**
	 * Returns the value of the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Pattern</em>' containment reference.
	 * @see #setBottomPattern(BottomPatternCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getAreaCS_BottomPattern()
	 * @model containment="true"
	 * @generated
	 */
	BottomPatternCS getBottomPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getBottomPattern <em>Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Pattern</em>' containment reference.
	 * @see #getBottomPattern()
	 * @generated
	 */
	void setBottomPattern(BottomPatternCS value);

	/**
	 * Returns the value of the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Pattern</em>' containment reference.
	 * @see #setGuardPattern(GuardPatternCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getAreaCS_GuardPattern()
	 * @model containment="true"
	 * @generated
	 */
	GuardPatternCS getGuardPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS#getGuardPattern <em>Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Pattern</em>' containment reference.
	 * @see #getGuardPattern()
	 * @generated
	 */
	void setGuardPattern(GuardPatternCS value);

} // AreaCS
