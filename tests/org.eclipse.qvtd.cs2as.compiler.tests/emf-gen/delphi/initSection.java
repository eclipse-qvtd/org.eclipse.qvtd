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
 * A representation of the model object '<em><b>init Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.initSection#getStmtList <em>Stmt List</em>}</li>
 *   <li>{@link delphi.initSection#getEndStmtList <em>End Stmt List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getinitSection()
 * @model
 * @generated
 */
public interface initSection extends CSTrace {
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
	 * @see delphi.DelphiPackage#getinitSection_StmtList()
	 * @model containment="true"
	 * @generated
	 */
	stmtList getStmtList();

	/**
	 * Sets the value of the '{@link delphi.initSection#getStmtList <em>Stmt List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stmt List</em>' containment reference.
	 * @see #getStmtList()
	 * @generated
	 */
	void setStmtList(stmtList value);

	/**
	 * Returns the value of the '<em><b>End Stmt List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Stmt List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Stmt List</em>' containment reference.
	 * @see #setEndStmtList(stmtList)
	 * @see delphi.DelphiPackage#getinitSection_EndStmtList()
	 * @model containment="true"
	 * @generated
	 */
	stmtList getEndStmtList();

	/**
	 * Sets the value of the '{@link delphi.initSection#getEndStmtList <em>End Stmt List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Stmt List</em>' containment reference.
	 * @see #getEndStmtList()
	 * @generated
	 */
	void setEndStmtList(stmtList value);

} // initSection
