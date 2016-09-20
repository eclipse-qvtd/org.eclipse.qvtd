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
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Model of an Imperative QVT transformation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsChecked <em>Is Checked</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsEnforced <em>Is Enforced</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTypedModel()
 * @generated
 */
public interface ImperativeTypedModel extends TypedModel {
	/**
	 * Returns the value of the '<em><b>Is Checked</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Checked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Checked</em>' attribute.
	 * @see #setIsChecked(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTypedModel_IsChecked()
	 * @generated
	 */
	boolean isIsChecked();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsChecked <em>Is Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Checked</em>' attribute.
	 * @see #isIsChecked()
	 * @generated
	 */
	void setIsChecked(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Enforced</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforced</em>' attribute.
	 * @see #setIsEnforced(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTypedModel_IsEnforced()
	 * @generated
	 */
	boolean isIsEnforced();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsEnforced <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforced</em>' attribute.
	 * @see #isIsEnforced()
	 * @generated
	 */
	void setIsEnforced(boolean value);

} // ImperativeTypedModel