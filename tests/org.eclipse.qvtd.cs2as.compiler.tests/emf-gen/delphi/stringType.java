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
 * A representation of the model object '<em><b>string Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.stringType#getConstExp <em>Const Exp</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getstringType()
 * @model
 * @generated
 */
public interface stringType extends type {
	/**
	 * Returns the value of the '<em><b>Const Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const Exp</em>' containment reference.
	 * @see #setConstExp(constExpr)
	 * @see delphi.DelphiPackage#getstringType_ConstExp()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getConstExp();

	/**
	 * Sets the value of the '{@link delphi.stringType#getConstExp <em>Const Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const Exp</em>' containment reference.
	 * @see #getConstExp()
	 * @generated
	 */
	void setConstExp(constExpr value);

} // stringType
