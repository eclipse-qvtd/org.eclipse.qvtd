/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package manualuml2rdbms.uml2rdbms;

import manualuml2rdbms.uml.Attribute;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.FromAttribute#getName <em>Name</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.FromAttribute#getKind <em>Kind</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.FromAttribute#getOwner <em>Owner</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.FromAttribute#getLeafs <em>Leafs</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.FromAttribute#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttribute()
 * @model abstract="true"
 * @generated
 */
public interface FromAttribute extends EObject {
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
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttribute_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttribute_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml2rdbms.FromAttributeOwner#getFromAttributes <em>From Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(FromAttributeOwner)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttribute_Owner()
	 * @see manualuml2rdbms.uml2rdbms.FromAttributeOwner#getFromAttributes
	 * @model opposite="fromAttributes" transient="false"
	 * @generated
	 */
	FromAttributeOwner getOwner();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(FromAttributeOwner value);

	/**
	 * Returns the value of the '<em><b>Leafs</b></em>' reference list.
	 * The list contents are of type {@link manualuml2rdbms.uml2rdbms.AttributeToColumn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leafs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leafs</em>' reference list.
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttribute_Leafs()
	 * @model ordered="false"
	 * @generated
	 */
	EList<AttributeToColumn> getLeafs();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(Attribute)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttribute_Attribute()
	 * @model
	 * @generated
	 */
	Attribute getAttribute();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(Attribute value);

} // FromAttribute
