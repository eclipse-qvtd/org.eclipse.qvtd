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
 * A representation of the model object '<em><b>property List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.propertyList#getId <em>Id</em>}</li>
 *   <li>{@link delphi.propertyList#getInterface <em>Interface</em>}</li>
 *   <li>{@link delphi.propertyList#getSpecifiers <em>Specifiers</em>}</li>
 *   <li>{@link delphi.propertyList#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getpropertyList()
 * @model
 * @generated
 */
public interface propertyList extends CSTrace {
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
	 * @see delphi.DelphiPackage#getpropertyList_Id()
	 * @model containment="true"
	 * @generated
	 */
	ident getId();

	/**
	 * Sets the value of the '{@link delphi.propertyList#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(ident value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' containment reference.
	 * @see #setInterface(propertyInterface)
	 * @see delphi.DelphiPackage#getpropertyList_Interface()
	 * @model containment="true"
	 * @generated
	 */
	propertyInterface getInterface();

	/**
	 * Sets the value of the '{@link delphi.propertyList#getInterface <em>Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' containment reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(propertyInterface value);

	/**
	 * Returns the value of the '<em><b>Specifiers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specifiers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specifiers</em>' containment reference.
	 * @see #setSpecifiers(propertySpecifiers)
	 * @see delphi.DelphiPackage#getpropertyList_Specifiers()
	 * @model containment="true"
	 * @generated
	 */
	propertySpecifiers getSpecifiers();

	/**
	 * Sets the value of the '{@link delphi.propertyList#getSpecifiers <em>Specifiers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specifiers</em>' containment reference.
	 * @see #getSpecifiers()
	 * @generated
	 */
	void setSpecifiers(propertySpecifiers value);

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
	 * @see delphi.DelphiPackage#getpropertyList_Port()
	 * @model
	 * @generated
	 */
	String getPort();

	/**
	 * Sets the value of the '{@link delphi.propertyList#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(String value);

} // propertyList
