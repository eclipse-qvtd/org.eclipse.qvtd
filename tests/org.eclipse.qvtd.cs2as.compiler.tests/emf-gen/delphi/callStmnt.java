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
 * A representation of the model object '<em><b>call Stmnt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.callStmnt#getDesignator <em>Designator</em>}</li>
 *   <li>{@link delphi.callStmnt#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getcallStmnt()
 * @model
 * @generated
 */
public interface callStmnt extends simpleStatement {
	/**
	 * Returns the value of the '<em><b>Designator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Designator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Designator</em>' containment reference.
	 * @see #setDesignator(designator)
	 * @see delphi.DelphiPackage#getcallStmnt_Designator()
	 * @model containment="true"
	 * @generated
	 */
	designator getDesignator();

	/**
	 * Sets the value of the '{@link delphi.callStmnt#getDesignator <em>Designator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Designator</em>' containment reference.
	 * @see #getDesignator()
	 * @generated
	 */
	void setDesignator(designator value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference.
	 * @see #setArgs(exprList)
	 * @see delphi.DelphiPackage#getcallStmnt_Args()
	 * @model containment="true"
	 * @generated
	 */
	exprList getArgs();

	/**
	 * Sets the value of the '{@link delphi.callStmnt#getArgs <em>Args</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Args</em>' containment reference.
	 * @see #getArgs()
	 * @generated
	 */
	void setArgs(exprList value);

} // callStmnt
