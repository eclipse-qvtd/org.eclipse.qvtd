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

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An IfStatment supports alternative execution paths that must make the same exrernal variable assignments. 
 * 
 * syntax: oclText[if condition then {...} else {...} ]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedThenStatements <em>Owned Then Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedElseStatements <em>Owned Else Statements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getIfStatement()
 * @generated
 */
public interface IfStatement extends ObservableStatement {
	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression whose values provide the iterator values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getIfStatement_OwnedExpression()
	 * @generated
	 */
	OCLExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Then Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.Statement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The statements to be iterated, typically a single MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Then Statements</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getIfStatement_OwnedThenStatements()
	 * @generated
	 */
	EList<Statement> getOwnedThenStatements();

	/**
	 * Returns the value of the '<em><b>Owned Else Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.Statement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The statements to be iterated, typically a single MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Else Statements</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getIfStatement_OwnedElseStatements()
	 * @generated
	 */
	EList<Statement> getOwnedElseStatements();

} // IfStatement
