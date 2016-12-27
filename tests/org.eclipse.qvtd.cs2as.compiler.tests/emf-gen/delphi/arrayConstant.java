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
 * A representation of the model object '<em><b>array Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.arrayConstant#getTypedConstant <em>Typed Constant</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getarrayConstant()
 * @model
 * @generated
 */
public interface arrayConstant extends CSTrace {
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
	 * @see delphi.DelphiPackage#getarrayConstant_TypedConstant()
	 * @model containment="true"
	 * @generated
	 */
	typedConstant getTypedConstant();

	/**
	 * Sets the value of the '{@link delphi.arrayConstant#getTypedConstant <em>Typed Constant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Constant</em>' containment reference.
	 * @see #getTypedConstant()
	 * @generated
	 */
	void setTypedConstant(typedConstant value);

} // arrayConstant
