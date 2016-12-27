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
 * A representation of the model object '<em><b>Reserved Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.ReservedId#getReservedWord <em>Reserved Word</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getReservedId()
 * @model
 * @generated
 */
public interface ReservedId extends ident {
	/**
	 * Returns the value of the '<em><b>Reserved Word</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reserved Word</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reserved Word</em>' containment reference.
	 * @see #setReservedWord(reservedWord)
	 * @see delphi.DelphiPackage#getReservedId_ReservedWord()
	 * @model containment="true"
	 * @generated
	 */
	reservedWord getReservedWord();

	/**
	 * Sets the value of the '{@link delphi.ReservedId#getReservedWord <em>Reserved Word</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reserved Word</em>' containment reference.
	 * @see #getReservedWord()
	 * @generated
	 */
	void setReservedWord(reservedWord value);

} // ReservedId
