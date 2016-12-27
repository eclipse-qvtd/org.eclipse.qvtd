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
 * A representation of the model object '<em><b>directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.directive#getDir <em>Dir</em>}</li>
 *   <li>{@link delphi.directive#getMessageExp <em>Message Exp</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getdirective()
 * @model
 * @generated
 */
public interface directive extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dir</em>' attribute.
	 * @see #setDir(String)
	 * @see delphi.DelphiPackage#getdirective_Dir()
	 * @model
	 * @generated
	 */
	String getDir();

	/**
	 * Sets the value of the '{@link delphi.directive#getDir <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' attribute.
	 * @see #getDir()
	 * @generated
	 */
	void setDir(String value);

	/**
	 * Returns the value of the '<em><b>Message Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Exp</em>' containment reference.
	 * @see #setMessageExp(constExpr)
	 * @see delphi.DelphiPackage#getdirective_MessageExp()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getMessageExp();

	/**
	 * Sets the value of the '{@link delphi.directive#getMessageExp <em>Message Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Exp</em>' containment reference.
	 * @see #getMessageExp()
	 * @generated
	 */
	void setMessageExp(constExpr value);

} // directive
