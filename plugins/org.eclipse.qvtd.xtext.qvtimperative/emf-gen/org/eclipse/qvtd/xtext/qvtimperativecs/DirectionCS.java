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
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direction CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#getUses <em>Uses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsChecked <em>Is Checked</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsEnforced <em>Is Enforced</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS()
 * @model
 * @generated
 */
public interface DirectionCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS_Imports()
	 * @model
	 * @generated
	 */
	EList<org.eclipse.ocl.pivot.Package> getImports();

	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS_Uses()
	 * @model
	 * @generated
	 */
	EList<ImperativeDomain> getUses();

	/**
	 * Returns the value of the '<em><b>Is Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Checked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Checked</em>' attribute.
	 * @see #setIsChecked(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS_IsChecked()
	 * @model
	 * @generated
	 */
	boolean isIsChecked();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsChecked <em>Is Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Checked</em>' attribute.
	 * @see #isIsChecked()
	 * @generated
	 */
	void setIsChecked(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Enforced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforced</em>' attribute.
	 * @see #setIsEnforced(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getDirectionCS_IsEnforced()
	 * @model
	 * @generated
	 */
	boolean isIsEnforced();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS#isIsEnforced <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforced</em>' attribute.
	 * @see #isIsEnforced()
	 * @generated
	 */
	void setIsEnforced(boolean value);

} // DirectionCS
