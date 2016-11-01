/**
 * <copyright>
 * 
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement#getThenStatements <em>Then Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement#getElseStatements <em>Else Statements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGIfStatement()
 * @model
 * @generated
 */
public interface CGIfStatement extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGIfStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Then Statements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Statements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Statements</em>' containment reference.
	 * @see #setThenStatements(CGSequence)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGIfStatement_ThenStatements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGSequence getThenStatements();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement#getThenStatements <em>Then Statements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Statements</em>' containment reference.
	 * @see #getThenStatements()
	 * @generated
	 */
	void setThenStatements(CGSequence value);

	/**
	 * Returns the value of the '<em><b>Else Statements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Statements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Statements</em>' containment reference.
	 * @see #setElseStatements(CGSequence)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGIfStatement_ElseStatements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGSequence getElseStatements();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement#getElseStatements <em>Else Statements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Statements</em>' containment reference.
	 * @see #getElseStatements()
	 * @generated
	 */
	void setElseStatements(CGSequence value);

} // CGIfStatement
