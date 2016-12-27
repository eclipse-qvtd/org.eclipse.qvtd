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
 * A representation of the model object '<em><b>assignment Stmnt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.assignmentStmnt#getDesignator <em>Designator</em>}</li>
 *   <li>{@link delphi.assignmentStmnt#getOperator <em>Operator</em>}</li>
 *   <li>{@link delphi.assignmentStmnt#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getassignmentStmnt()
 * @model
 * @generated
 */
public interface assignmentStmnt extends simpleStatement {
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
	 * @see delphi.DelphiPackage#getassignmentStmnt_Designator()
	 * @model containment="true"
	 * @generated
	 */
	designator getDesignator();

	/**
	 * Sets the value of the '{@link delphi.assignmentStmnt#getDesignator <em>Designator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Designator</em>' containment reference.
	 * @see #getDesignator()
	 * @generated
	 */
	void setDesignator(designator value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see delphi.DelphiPackage#getassignmentStmnt_Operator()
	 * @model
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link delphi.assignmentStmnt#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

	/**
	 * Returns the value of the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' containment reference.
	 * @see #setExp(expression)
	 * @see delphi.DelphiPackage#getassignmentStmnt_Exp()
	 * @model containment="true"
	 * @generated
	 */
	expression getExp();

	/**
	 * Sets the value of the '{@link delphi.assignmentStmnt#getExp <em>Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' containment reference.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(expression value);

} // assignmentStmnt
