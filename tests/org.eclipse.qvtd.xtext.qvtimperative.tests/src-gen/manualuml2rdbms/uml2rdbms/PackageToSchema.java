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

import manualuml2rdbms.rdbms.Schema;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package To Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames <em>Primitives To Names</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getName <em>Name</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage <em>Uml Package</em>}</li>
 *   <li>{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getSchema <em>Schema</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema()
 * @model
 * @generated
 */
public interface PackageToSchema extends EObject {
	/**
	 * Returns the value of the '<em><b>Classes To Tables</b></em>' containment reference list.
	 * The list contents are of type {@link manualuml2rdbms.uml2rdbms.ClassToTable}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml2rdbms.ClassToTable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes To Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes To Tables</em>' containment reference list.
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_ClassesToTables()
	 * @see manualuml2rdbms.uml2rdbms.ClassToTable#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<ClassToTable> getClassesToTables();

	/**
	 * Returns the value of the '<em><b>Primitives To Names</b></em>' containment reference list.
	 * The list contents are of type {@link manualuml2rdbms.uml2rdbms.PrimitiveToName}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml2rdbms.PrimitiveToName#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitives To Names</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitives To Names</em>' containment reference list.
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_PrimitivesToNames()
	 * @see manualuml2rdbms.uml2rdbms.PrimitiveToName#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<PrimitiveToName> getPrimitivesToNames();

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
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Uml Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Package</em>' reference.
	 * @see #setUmlPackage(manualuml2rdbms.uml.Package)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_UmlPackage()
	 * @model required="true"
	 * @generated
	 */
	manualuml2rdbms.uml.Package getUmlPackage();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage <em>Uml Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Package</em>' reference.
	 * @see #getUmlPackage()
	 * @generated
	 */
	void setUmlPackage(manualuml2rdbms.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' reference.
	 * @see #setSchema(Schema)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_Schema()
	 * @model required="true"
	 * @generated
	 */
	Schema getSchema();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.PackageToSchema#getSchema <em>Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(Schema value);

} // PackageToSchema
