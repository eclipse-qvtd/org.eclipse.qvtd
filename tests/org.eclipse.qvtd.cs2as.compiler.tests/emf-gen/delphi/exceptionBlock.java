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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>exception Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.exceptionBlock#getExceptionId <em>Exception Id</em>}</li>
 *   <li>{@link delphi.exceptionBlock#getType <em>Type</em>}</li>
 *   <li>{@link delphi.exceptionBlock#getDoStmt <em>Do Stmt</em>}</li>
 *   <li>{@link delphi.exceptionBlock#getElseStmts <em>Else Stmts</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getexceptionBlock()
 * @model
 * @generated
 */
public interface exceptionBlock extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Exception Id</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.ident}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Id</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Id</em>' containment reference list.
	 * @see delphi.DelphiPackage#getexceptionBlock_ExceptionId()
	 * @model containment="true"
	 * @generated
	 */
	EList<ident> getExceptionId();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference list.
	 * @see delphi.DelphiPackage#getexceptionBlock_Type()
	 * @model containment="true"
	 * @generated
	 */
	EList<type> getType();

	/**
	 * Returns the value of the '<em><b>Do Stmt</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Do Stmt</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Do Stmt</em>' containment reference list.
	 * @see delphi.DelphiPackage#getexceptionBlock_DoStmt()
	 * @model containment="true"
	 * @generated
	 */
	EList<statement> getDoStmt();

	/**
	 * Returns the value of the '<em><b>Else Stmts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Stmts</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Stmts</em>' containment reference.
	 * @see #setElseStmts(stmtList)
	 * @see delphi.DelphiPackage#getexceptionBlock_ElseStmts()
	 * @model containment="true"
	 * @generated
	 */
	stmtList getElseStmts();

	/**
	 * Sets the value of the '{@link delphi.exceptionBlock#getElseStmts <em>Else Stmts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Stmts</em>' containment reference.
	 * @see #getElseStmts()
	 * @generated
	 */
	void setElseStmts(stmtList value);

} // exceptionBlock
