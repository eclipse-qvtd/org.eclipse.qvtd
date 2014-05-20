/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
package test.umltordbms;

import org.eclipse.emf.common.util.EList;

import test.simplerdbms.Key;
import test.simplerdbms.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class To Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.umltordbms.ClassToTable#getOwner <em>Owner</em>}</li>
 *   <li>{@link test.umltordbms.ClassToTable#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}</li>
 *   <li>{@link test.umltordbms.ClassToTable#getName <em>Name</em>}</li>
 *   <li>{@link test.umltordbms.ClassToTable#getUmlClass <em>Uml Class</em>}</li>
 *   <li>{@link test.umltordbms.ClassToTable#getTable <em>Table</em>}</li>
 *   <li>{@link test.umltordbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.umltordbms.UmltordbmsPackage#getClassToTable()
 * @model
 * @generated
 */
public interface ClassToTable extends FromAttributeOwner, ToColumn {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link test.umltordbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(PackageToSchema)
	 * @see test.umltordbms.UmltordbmsPackage#getClassToTable_Owner()
	 * @see test.umltordbms.PackageToSchema#getClassesToTables
	 * @model opposite="classesToTables" transient="false"
	 * @generated
	 */
	PackageToSchema getOwner();

	/**
	 * Sets the value of the '{@link test.umltordbms.ClassToTable#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(PackageToSchema value);

	/**
	 * Returns the value of the '<em><b>Associations To Foreign Keys</b></em>' containment reference list.
	 * The list contents are of type {@link test.umltordbms.AssociationToForeignKey}.
	 * It is bidirectional and its opposite is '{@link test.umltordbms.AssociationToForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations To Foreign Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations To Foreign Keys</em>' containment reference list.
	 * @see test.umltordbms.UmltordbmsPackage#getClassToTable_AssociationsToForeignKeys()
	 * @see test.umltordbms.AssociationToForeignKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<AssociationToForeignKey> getAssociationsToForeignKeys();

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
	 * @see test.umltordbms.UmltordbmsPackage#getClassToTable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test.umltordbms.ClassToTable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Uml Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Class</em>' reference.
	 * @see #setUmlClass(test.simpleuml.Class)
	 * @see test.umltordbms.UmltordbmsPackage#getClassToTable_UmlClass()
	 * @model
	 * @generated
	 */
	test.simpleuml.Class getUmlClass();

	/**
	 * Sets the value of the '{@link test.umltordbms.ClassToTable#getUmlClass <em>Uml Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Class</em>' reference.
	 * @see #getUmlClass()
	 * @generated
	 */
	void setUmlClass(test.simpleuml.Class value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see test.umltordbms.UmltordbmsPackage#getClassToTable_Table()
	 * @model
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link test.umltordbms.ClassToTable#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' reference.
	 * @see #setPrimaryKey(Key)
	 * @see test.umltordbms.UmltordbmsPackage#getClassToTable_PrimaryKey()
	 * @model
	 * @generated
	 */
	Key getPrimaryKey();

	/**
	 * Sets the value of the '{@link test.umltordbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(Key value);

} // ClassToTable
