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

import org.eclipse.ocl.xtext.basecs.TypedElementCS;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Statement CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getOwnedInit <em>Owned Init</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getNewStatementCS()
 * @model
 * @generated
 */
public interface NewStatementCS extends TypedElementCS, StatementCS {
	/**
	 * Returns the value of the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init</em>' containment reference.
	 * @see #setOwnedInit(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getNewStatementCS_OwnedInit()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedInit();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getOwnedInit <em>Owned Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init</em>' containment reference.
	 * @see #getOwnedInit()
	 * @generated
	 */
	void setOwnedInit(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Typed Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Typed Model</em>' reference.
	 * @see #setReferredTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getNewStatementCS_ReferredTypedModel()
	 * @model required="true"
	 * @generated
	 */
	TypedModel getReferredTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS#getReferredTypedModel <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Typed Model</em>' reference.
	 * @see #getReferredTypedModel()
	 * @generated
	 */
	void setReferredTypedModel(TypedModel value);

} // NewStatementCS
