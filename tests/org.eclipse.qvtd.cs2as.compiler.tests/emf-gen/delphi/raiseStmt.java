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
 * A representation of the model object '<em><b>raise Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.raiseStmt#getRaise <em>Raise</em>}</li>
 *   <li>{@link delphi.raiseStmt#getAt <em>At</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getraiseStmt()
 * @model
 * @generated
 */
public interface raiseStmt extends structStmt {
	/**
	 * Returns the value of the '<em><b>Raise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raise</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raise</em>' attribute.
	 * @see #setRaise(String)
	 * @see delphi.DelphiPackage#getraiseStmt_Raise()
	 * @model
	 * @generated
	 */
	String getRaise();

	/**
	 * Sets the value of the '{@link delphi.raiseStmt#getRaise <em>Raise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raise</em>' attribute.
	 * @see #getRaise()
	 * @generated
	 */
	void setRaise(String value);

	/**
	 * Returns the value of the '<em><b>At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At</em>' attribute.
	 * @see #setAt(String)
	 * @see delphi.DelphiPackage#getraiseStmt_At()
	 * @model
	 * @generated
	 */
	String getAt();

	/**
	 * Sets the value of the '{@link delphi.raiseStmt#getAt <em>At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At</em>' attribute.
	 * @see #getAt()
	 * @generated
	 */
	void setAt(String value);

} // raiseStmt
