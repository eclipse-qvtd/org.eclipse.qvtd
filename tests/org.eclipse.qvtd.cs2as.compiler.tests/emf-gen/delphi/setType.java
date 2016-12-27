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
 * A representation of the model object '<em><b>set Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.setType#getOrdinal <em>Ordinal</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getsetType()
 * @model
 * @generated
 */
public interface setType extends strucType {
	/**
	 * Returns the value of the '<em><b>Ordinal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordinal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordinal</em>' containment reference.
	 * @see #setOrdinal(ordinalType)
	 * @see delphi.DelphiPackage#getsetType_Ordinal()
	 * @model containment="true"
	 * @generated
	 */
	ordinalType getOrdinal();

	/**
	 * Sets the value of the '{@link delphi.setType#getOrdinal <em>Ordinal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordinal</em>' containment reference.
	 * @see #getOrdinal()
	 * @generated
	 */
	void setOrdinal(ordinalType value);

} // setType
