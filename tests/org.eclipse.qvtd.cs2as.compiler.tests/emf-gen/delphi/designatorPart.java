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
 * A representation of the model object '<em><b>designator Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.designatorPart#getId <em>Id</em>}</li>
 *   <li>{@link delphi.designatorPart#getReservedWord <em>Reserved Word</em>}</li>
 *   <li>{@link delphi.designatorPart#getId2 <em>Id2</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getdesignatorPart()
 * @model
 * @generated
 */
public interface designatorPart extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see delphi.DelphiPackage#getdesignatorPart_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link delphi.designatorPart#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see delphi.DelphiPackage#getdesignatorPart_ReservedWord()
	 * @model containment="true"
	 * @generated
	 */
	reservedWord getReservedWord();

	/**
	 * Sets the value of the '{@link delphi.designatorPart#getReservedWord <em>Reserved Word</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reserved Word</em>' containment reference.
	 * @see #getReservedWord()
	 * @generated
	 */
	void setReservedWord(reservedWord value);

	/**
	 * Returns the value of the '<em><b>Id2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id2</em>' attribute.
	 * @see #setId2(String)
	 * @see delphi.DelphiPackage#getdesignatorPart_Id2()
	 * @model
	 * @generated
	 */
	String getId2();

	/**
	 * Sets the value of the '{@link delphi.designatorPart#getId2 <em>Id2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id2</em>' attribute.
	 * @see #getId2()
	 * @generated
	 */
	void setId2(String value);

} // designatorPart
