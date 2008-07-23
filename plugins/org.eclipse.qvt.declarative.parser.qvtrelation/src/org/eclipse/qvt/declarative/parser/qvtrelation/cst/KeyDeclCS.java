/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS#getClassId <em>Class Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS#getPropertyId <em>Property Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getKeyDeclCS()
 * @model
 * @generated
 */
public interface KeyDeclCS extends CSTNode {
	/**
	 * Returns the value of the '<em><b>Class Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Id</em>' containment reference.
	 * @see #setClassId(PathNameCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getKeyDeclCS_ClassId()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getClassId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS#getClassId <em>Class Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Id</em>' containment reference.
	 * @see #getClassId()
	 * @generated
	 */
	void setClassId(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Property Id</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Id</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Id</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getKeyDeclCS_PropertyId()
	 * @model containment="true"
	 * @generated
	 */
	EList<IdentifiedCS> getPropertyId();

} // KeyDeclCS
