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
 * $Id: RealizeableVariableCS.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Realizeable Variable CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getRealizeableVariableCS()
 * @model abstract="true"
 * @generated
 */
public interface RealizeableVariableCS extends IdentifiedCS {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getRealizeableVariableCS_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeCS getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeCS value);

} // RealizeableVariableCS
