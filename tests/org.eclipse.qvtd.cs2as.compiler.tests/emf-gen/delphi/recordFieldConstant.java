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
 * A representation of the model object '<em><b>record Field Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.recordFieldConstant#getId <em>Id</em>}</li>
 *   <li>{@link delphi.recordFieldConstant#getTypedConstant <em>Typed Constant</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getrecordFieldConstant()
 * @model
 * @generated
 */
public interface recordFieldConstant extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference.
	 * @see #setId(ident)
	 * @see delphi.DelphiPackage#getrecordFieldConstant_Id()
	 * @model containment="true"
	 * @generated
	 */
	ident getId();

	/**
	 * Sets the value of the '{@link delphi.recordFieldConstant#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(ident value);

	/**
	 * Returns the value of the '<em><b>Typed Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Constant</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Constant</em>' containment reference.
	 * @see #setTypedConstant(typedConstant)
	 * @see delphi.DelphiPackage#getrecordFieldConstant_TypedConstant()
	 * @model containment="true"
	 * @generated
	 */
	typedConstant getTypedConstant();

	/**
	 * Sets the value of the '{@link delphi.recordFieldConstant#getTypedConstant <em>Typed Constant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Constant</em>' containment reference.
	 * @see #getTypedConstant()
	 * @generated
	 */
	void setTypedConstant(typedConstant value);

} // recordFieldConstant
