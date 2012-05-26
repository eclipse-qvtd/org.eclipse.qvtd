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
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getInputParamDeclarations <em>Input Param Declarations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getQueryCS()
 * @model
 * @generated
 */
public interface QueryCS extends TypedElementCS {
	/**
	 * Returns the value of the '<em><b>Input Param Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Param Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Param Declarations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getQueryCS_InputParamDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParamDeclarationCS> getInputParamDeclarations();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#getQueryCS_Expression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(ExpCS value);

} // QueryCS
