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
 * A representation of the model object '<em><b>with Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.withStmt#getVars <em>Vars</em>}</li>
 *   <li>{@link delphi.withStmt#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getwithStmt()
 * @model
 * @generated
 */
public interface withStmt extends structStmt {
	/**
	 * Returns the value of the '<em><b>Vars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vars</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vars</em>' containment reference.
	 * @see #setVars(identList)
	 * @see delphi.DelphiPackage#getwithStmt_Vars()
	 * @model containment="true"
	 * @generated
	 */
	identList getVars();

	/**
	 * Sets the value of the '{@link delphi.withStmt#getVars <em>Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vars</em>' containment reference.
	 * @see #getVars()
	 * @generated
	 */
	void setVars(identList value);

	/**
	 * Returns the value of the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stmt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stmt</em>' containment reference.
	 * @see #setStmt(statement)
	 * @see delphi.DelphiPackage#getwithStmt_Stmt()
	 * @model containment="true"
	 * @generated
	 */
	statement getStmt();

	/**
	 * Sets the value of the '{@link delphi.withStmt#getStmt <em>Stmt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stmt</em>' containment reference.
	 * @see #getStmt()
	 * @generated
	 */
	void setStmt(statement value);

} // withStmt
