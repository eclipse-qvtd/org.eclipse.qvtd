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
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS#getVarDeclarationId <em>Var Declaration Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getVarDeclarationCS()
 * @model
 * @generated
 */
public interface VarDeclarationCS extends CSTNode {
	/**
	 * Returns the value of the '<em><b>Var Declaration Id</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Declaration Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Declaration Id</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getVarDeclarationCS_VarDeclarationId()
	 * @model containment="true"
	 * @generated
	 */
	EList<IdentifierCS> getVarDeclarationId();

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
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getVarDeclarationCS_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeCS getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeCS value);

} // VarDeclarationCS
