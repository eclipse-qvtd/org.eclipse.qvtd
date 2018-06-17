/**
 * <copyright>
 * 
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.xml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DTD</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xml.DTD#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xml.DTD#getPublicId <em>Public Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xml.DTD#getSystemId <em>System Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getDTD()
 * @model
 * @generated
 */
public interface DTD extends Node {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getDTD_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xml.DTD#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Public Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Id</em>' attribute.
	 * @see #setPublicId(String)
	 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getDTD_PublicId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getPublicId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xml.DTD#getPublicId <em>Public Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Id</em>' attribute.
	 * @see #getPublicId()
	 * @generated
	 */
	void setPublicId(String value);

	/**
	 * Returns the value of the '<em><b>System Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Id</em>' attribute.
	 * @see #setSystemId(String)
	 * @see org.eclipse.qvtd.xml.XMLmodelPackage#getDTD_SystemId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSystemId();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xml.DTD#getSystemId <em>System Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Id</em>' attribute.
	 * @see #getSystemId()
	 * @generated
	 */
	void setSystemId(String value);

} // DTD
