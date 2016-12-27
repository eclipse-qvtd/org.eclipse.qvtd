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
 * A representation of the model object '<em><b>type Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.typeDecl#getId <em>Id</em>}</li>
 *   <li>{@link delphi.typeDecl#getType <em>Type</em>}</li>
 *   <li>{@link delphi.typeDecl#getPort <em>Port</em>}</li>
 *   <li>{@link delphi.typeDecl#getRestrictedType <em>Restricted Type</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#gettypeDecl()
 * @model
 * @generated
 */
public interface typeDecl extends CSTrace {
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
	 * @see delphi.DelphiPackage#gettypeDecl_Id()
	 * @model containment="true"
	 * @generated
	 */
	ident getId();

	/**
	 * Sets the value of the '{@link delphi.typeDecl#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(ident value);

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
	 * @see delphi.DelphiPackage#gettypeDecl_Type()
	 * @model containment="true"
	 * @generated
	 */
	type getType();

	/**
	 * Sets the value of the '{@link delphi.typeDecl#getType <em>Type</em>}' containment reference.
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
	 * @see delphi.DelphiPackage#gettypeDecl_Port()
	 * @model
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link delphi.typeDecl#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Restricted Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Type</em>' containment reference.
	 * @see #setRestrictedType(restrictedType)
	 * @see delphi.DelphiPackage#gettypeDecl_RestrictedType()
	 * @model containment="true"
	 * @generated
	 */
	restrictedType getRestrictedType();

	/**
	 * Sets the value of the '{@link delphi.typeDecl#getRestrictedType <em>Restricted Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Type</em>' containment reference.
	 * @see #getRestrictedType()
	 * @generated
	 */
	void setRestrictedType(restrictedType value);

} // typeDecl
