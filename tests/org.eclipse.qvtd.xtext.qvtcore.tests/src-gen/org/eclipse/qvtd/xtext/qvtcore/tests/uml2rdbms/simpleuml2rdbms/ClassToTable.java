/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.Key;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class To Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getUmlClass <em>Uml Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getClassToTable()
 * @model
 * @generated
 */
public interface ClassToTable extends FromAttributeOwner, ToColumn, UmlToRdbmsModelElement {
	/**
	 * Returns the value of the '<em><b>Associations To Foreign Keys</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AssociationToForeignKey}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AssociationToForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations To Foreign Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations To Foreign Keys</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getClassToTable_AssociationsToForeignKeys()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.AssociationToForeignKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<AssociationToForeignKey> getAssociationsToForeignKeys();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(PackageToSchema)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getClassToTable_Owner()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.PackageToSchema#getClassesToTables
	 * @model opposite="classesToTables" required="true" transient="false"
	 * @generated
	 */
	PackageToSchema getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getOwner <em>Owner</em>}' container reference.
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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getClassToTable_PrimaryKey()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle' upper='1'"
	 * @generated
	 */
	Key getPrimaryKey();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getPrimaryKey <em>Primary Key</em>}' reference.
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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getClassToTable_Table()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getTable <em>Table</em>}' reference.
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
	 * @see #setUmlClass(org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getClassToTable_UmlClass()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle' upper='1'"
	 * @generated
	 */
	org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class getUmlClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.ClassToTable#getUmlClass <em>Uml Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Class</em>' reference.
	 * @see #getUmlClass()
	 * @generated
	 */
	void setUmlClass(org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class value);

} // ClassToTable
