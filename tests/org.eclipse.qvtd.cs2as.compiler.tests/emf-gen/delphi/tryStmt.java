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
 * A representation of the model object '<em><b>try Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.tryStmt#getStmtList <em>Stmt List</em>}</li>
 *   <li>{@link delphi.tryStmt#getException <em>Exception</em>}</li>
 *   <li>{@link delphi.tryStmt#getFinal <em>Final</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#gettryStmt()
 * @model
 * @generated
 */
public interface tryStmt extends structStmt {
	/**
	 * Returns the value of the '<em><b>Stmt List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stmt List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stmt List</em>' containment reference.
	 * @see #setStmtList(stmtList)
	 * @see delphi.DelphiPackage#gettryStmt_StmtList()
	 * @model containment="true"
	 * @generated
	 */
	stmtList getStmtList();

	/**
	 * Sets the value of the '{@link delphi.tryStmt#getStmtList <em>Stmt List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stmt List</em>' containment reference.
	 * @see #getStmtList()
	 * @generated
	 */
	void setStmtList(stmtList value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(exceptionBlock)
	 * @see delphi.DelphiPackage#gettryStmt_Exception()
	 * @model containment="true"
	 * @generated
	 */
	exceptionBlock getException();

	/**
	 * Sets the value of the '{@link delphi.tryStmt#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(exceptionBlock value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' containment reference.
	 * @see #setFinal(stmtList)
	 * @see delphi.DelphiPackage#gettryStmt_Final()
	 * @model containment="true"
	 * @generated
	 */
	stmtList getFinal();

	/**
	 * Sets the value of the '{@link delphi.tryStmt#getFinal <em>Final</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' containment reference.
	 * @see #getFinal()
	 * @generated
	 */
	void setFinal(stmtList value);

} // tryStmt
