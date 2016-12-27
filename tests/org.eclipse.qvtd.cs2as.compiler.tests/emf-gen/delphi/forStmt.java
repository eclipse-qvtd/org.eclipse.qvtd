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
 * A representation of the model object '<em><b>for Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.forStmt#getVarId <em>Var Id</em>}</li>
 *   <li>{@link delphi.forStmt#getVarInit <em>Var Init</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getforStmt()
 * @model
 * @generated
 */
public interface forStmt extends loopStmt {
	/**
	 * Returns the value of the '<em><b>Var Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Id</em>' containment reference.
	 * @see #setVarId(qualId)
	 * @see delphi.DelphiPackage#getforStmt_VarId()
	 * @model containment="true"
	 * @generated
	 */
	qualId getVarId();

	/**
	 * Sets the value of the '{@link delphi.forStmt#getVarId <em>Var Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Id</em>' containment reference.
	 * @see #getVarId()
	 * @generated
	 */
	void setVarId(qualId value);

	/**
	 * Returns the value of the '<em><b>Var Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Init</em>' containment reference.
	 * @see #setVarInit(expression)
	 * @see delphi.DelphiPackage#getforStmt_VarInit()
	 * @model containment="true"
	 * @generated
	 */
	expression getVarInit();

	/**
	 * Sets the value of the '{@link delphi.forStmt#getVarInit <em>Var Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Init</em>' containment reference.
	 * @see #getVarInit()
	 * @generated
	 */
	void setVarInit(expression value);

} // forStmt
