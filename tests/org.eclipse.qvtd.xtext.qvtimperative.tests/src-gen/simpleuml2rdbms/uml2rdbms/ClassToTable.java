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
package simpleuml2rdbms.uml2rdbms;

import org.eclipse.emf.common.util.EList;

import simpleuml2rdbms.rdbms.Key;
import simpleuml2rdbms.rdbms.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class To Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getOwner <em>Owner</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getTable <em>Table</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getUmlClass <em>Uml Class</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getClassToTable()
 * @model
 * @generated
 */
public interface ClassToTable extends FromAttributeOwner, ToColumn, UmlToRdbmsModelElement {
	/**
	 * Returns the value of the '<em><b>Associations To Foreign Keys</b></em>' containment reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml2rdbms.AssociationToForeignKey}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations To Foreign Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations To Foreign Keys</em>' containment reference list.
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getClassToTable_AssociationsToForeignKeys()
	 * @see simpleuml2rdbms.uml2rdbms.AssociationToForeignKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<AssociationToForeignKey> getAssociationsToForeignKeys();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(PackageToSchema)
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getClassToTable_Owner()
	 * @see simpleuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables
	 * @model opposite="classesToTables" required="true" transient="false"
	 * @generated
	 */
	PackageToSchema getOwner();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(PackageToSchema value);

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
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getClassToTable_PrimaryKey()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	Key getPrimaryKey();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(Key value);

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
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getClassToTable_Table()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Uml Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Class</em>' reference.
	 * @see #setUmlClass(simpleuml2rdbms.uml.Class)
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getClassToTable_UmlClass()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	simpleuml2rdbms.uml.Class getUmlClass();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getUmlClass <em>Uml Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Class</em>' reference.
	 * @see #getUmlClass()
	 * @generated
	 */
	void setUmlClass(simpleuml2rdbms.uml.Class value);

} // ClassToTable
