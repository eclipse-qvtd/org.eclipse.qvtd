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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.arrayType#getOrdinalType <em>Ordinal Type</em>}</li>
 *   <li>{@link delphi.arrayType#getOrdinalTyp <em>Ordinal Typ</em>}</li>
 *   <li>{@link delphi.arrayType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getarrayType()
 * @model
 * @generated
 */
public interface arrayType extends strucType {
	/**
	 * Returns the value of the '<em><b>Ordinal Type</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.ordinalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordinal Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordinal Type</em>' containment reference list.
	 * @see delphi.DelphiPackage#getarrayType_OrdinalType()
	 * @model containment="true"
	 * @generated
	 */
	EList<ordinalType> getOrdinalType();

	/**
	 * Returns the value of the '<em><b>Ordinal Typ</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.ordinalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordinal Typ</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordinal Typ</em>' containment reference list.
	 * @see delphi.DelphiPackage#getarrayType_OrdinalTyp()
	 * @model containment="true"
	 * @generated
	 */
	EList<ordinalType> getOrdinalTyp();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(type)
	 * @see delphi.DelphiPackage#getarrayType_Type()
	 * @model containment="true"
	 * @generated
	 */
	type getType();

	/**
	 * Sets the value of the '{@link delphi.arrayType#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(type value);

} // arrayType
