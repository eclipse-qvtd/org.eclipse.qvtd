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

import manualuml2rdbms.rdbms.ForeignKey;

import manualuml2rdbms.uml.Association;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association To Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getReferenced <em>Referenced</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner <em>Owner</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getName <em>Name</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getAssociation <em>Association</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAssociationToForeignKey()
 * @model
 * @generated
 */
public interface AssociationToForeignKey extends ToColumn {
	/**
	 * Returns the value of the '<em><b>Referenced</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced</em>' reference.
	 * @see #setReferenced(ClassToTable)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAssociationToForeignKey_Referenced()
	 * @model
	 * @generated
	 */
	ClassToTable getReferenced();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getReferenced <em>Referenced</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced</em>' reference.
	 * @see #getReferenced()
	 * @generated
	 */
	void setReferenced(ClassToTable value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(ClassToTable)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAssociationToForeignKey_Owner()
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getAssociationsToForeignKeys
	 * @model opposite="associationsToForeignKeys" transient="false"
	 * @generated
	 */
	ClassToTable getOwner();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(ClassToTable value);

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
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAssociationToForeignKey_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' reference.
	 * @see #setAssociation(Association)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAssociationToForeignKey_Association()
	 * @model
	 * @generated
	 */
	Association getAssociation();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getAssociation <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(Association value);

	/**
	 * Returns the value of the '<em><b>Foreign Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Key</em>' reference.
	 * @see #setForeignKey(ForeignKey)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAssociationToForeignKey_ForeignKey()
	 * @model
	 * @generated
	 */
	ForeignKey getForeignKey();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.AssociationToForeignKey#getForeignKey <em>Foreign Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreign Key</em>' reference.
	 * @see #getForeignKey()
	 * @generated
	 */
	void setForeignKey(ForeignKey value);

} // AssociationToForeignKey
