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
 * A representation of the model object '<em><b>field Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.fieldDecl#getIdList <em>Id List</em>}</li>
 *   <li>{@link delphi.fieldDecl#getType <em>Type</em>}</li>
 *   <li>{@link delphi.fieldDecl#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getfieldDecl()
 * @model
 * @generated
 */
public interface fieldDecl extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Id List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id List</em>' containment reference.
	 * @see #setIdList(identList)
	 * @see delphi.DelphiPackage#getfieldDecl_IdList()
	 * @model containment="true"
	 * @generated
	 */
	identList getIdList();

	/**
	 * Sets the value of the '{@link delphi.fieldDecl#getIdList <em>Id List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id List</em>' containment reference.
	 * @see #getIdList()
	 * @generated
	 */
	void setIdList(identList value);

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
	 * @see delphi.DelphiPackage#getfieldDecl_Type()
	 * @model containment="true"
	 * @generated
	 */
	type getType();

	/**
	 * Sets the value of the '{@link delphi.fieldDecl#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(type value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see delphi.DelphiPackage#getfieldDecl_Port()
	 * @model
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link delphi.fieldDecl#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

} // fieldDecl
