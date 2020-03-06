/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.xtext.basecs.TypedElementCS;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

import org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#isIsTransient <em>Is Transient</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getQueryCS()
 * @model
 * @generated
 */
public interface QueryCS extends TypedElementCS, JavaImplementationCS {
	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getQueryCS_OwnedParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParamDeclarationCS> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getQueryCS_OwnedExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Is Transient</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Transient</em>' attribute.
	 * @see #setIsTransient(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getQueryCS_IsTransient()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS#isIsTransient <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transient</em>' attribute.
	 * @see #isIsTransient()
	 * @generated
	 */
	void setIsTransient(boolean value);

} // QueryCS
