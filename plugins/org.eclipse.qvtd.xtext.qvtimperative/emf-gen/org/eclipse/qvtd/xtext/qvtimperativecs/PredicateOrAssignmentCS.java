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

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Or Assignment CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS#getOwnedTarget <em>Owned Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getPredicateOrAssignmentCS()
 * @model
 * @generated
 */
public interface PredicateOrAssignmentCS extends ExpCS {
	/**
	 * Returns the value of the '<em><b>Owned Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Target</em>' containment reference.
	 * @see #setOwnedTarget(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getPredicateOrAssignmentCS_OwnedTarget()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getOwnedTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS#getOwnedTarget <em>Owned Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Target</em>' containment reference.
	 * @see #getOwnedTarget()
	 * @generated
	 */
	void setOwnedTarget(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #setOwnedInitExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getPredicateOrAssignmentCS_OwnedInitExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS#getOwnedInitExpression <em>Owned Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #getOwnedInitExpression()
	 * @generated
	 */
	void setOwnedInitExpression(ExpCS value);

} // PredicateOrAssignmentCS
