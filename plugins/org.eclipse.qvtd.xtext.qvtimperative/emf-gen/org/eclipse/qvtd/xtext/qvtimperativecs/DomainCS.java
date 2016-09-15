/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsCheck <em>Is Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsEnforce <em>Is Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getCheckedProperties <em>Checked Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDomainCS()
 * @model
 * @generated
 */
public interface DomainCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Is Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Check</em>' attribute.
	 * @see #setIsCheck(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDomainCS_IsCheck()
	 * @model
	 * @generated
	 */
	boolean isIsCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsCheck <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Check</em>' attribute.
	 * @see #isIsCheck()
	 * @generated
	 */
	void setIsCheck(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforce</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforce</em>' attribute.
	 * @see #setIsEnforce(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDomainCS_IsEnforce()
	 * @model
	 * @generated
	 */
	boolean isIsEnforce();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#isIsEnforce <em>Is Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforce</em>' attribute.
	 * @see #isIsEnforce()
	 * @generated
	 */
	void setIsEnforce(boolean value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' reference.
	 * @see #setDirection(TypedModel)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDomainCS_Direction()
	 * @model
	 * @generated
	 */
	TypedModel getDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS#getDirection <em>Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' reference.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(TypedModel value);

	/**
	 * Returns the value of the '<em><b>Checked Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.PathNameCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties whose accesses must be polled for readiness prior to use here.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Checked Properties</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDomainCS_CheckedProperties()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PathNameCS> getCheckedProperties();

	/**
	 * Returns the value of the '<em><b>Owned Guard Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Guard Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Guard Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDomainCS_OwnedGuardVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<GuardVariableCS> getOwnedGuardVariables();

} // DomainCS
