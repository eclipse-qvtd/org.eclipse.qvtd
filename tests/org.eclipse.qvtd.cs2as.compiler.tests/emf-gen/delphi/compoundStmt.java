/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>compound Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.compoundStmt#getStamtList <em>Stamt List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getcompoundStmt()
 * @model
 * @generated
 */
public interface compoundStmt extends structStmt {
	/**
	 * Returns the value of the '<em><b>Stamt List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stamt List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stamt List</em>' containment reference.
	 * @see #setStamtList(stmtList)
	 * @see delphi.DelphiPackage#getcompoundStmt_StamtList()
	 * @model containment="true"
	 * @generated
	 */
	stmtList getStamtList();

	/**
	 * Sets the value of the '{@link delphi.compoundStmt#getStamtList <em>Stamt List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stamt List</em>' containment reference.
	 * @see #getStamtList()
	 * @generated
	 */
	void setStamtList(stmtList value);

} // compoundStmt
