/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getVarDeclarationIds <em>Var Declaration Ids</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getVarDeclarationCS()
 * @model
 * @generated
 */
public interface VarDeclarationCS extends ModelElementCS {

	/**
	 * Returns the value of the '<em><b>Var Declaration Ids</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Declaration Ids</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Declaration Ids</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getVarDeclarationCS_VarDeclarationIds()
	 * @model containment="true"
	 * @generated
	 */
	EList<VarDeclarationIdCS> getVarDeclarationIds();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypedRefCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getVarDeclarationCS_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypedRefCS value);

} // VarDeclarationCS
