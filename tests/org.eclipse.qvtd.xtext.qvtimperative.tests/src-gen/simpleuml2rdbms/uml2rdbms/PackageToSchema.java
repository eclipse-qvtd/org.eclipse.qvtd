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

import simpleuml2rdbms.rdbms.Schema;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package To Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getClassesToTables <em>Classes To Tables</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames <em>Primitives To Names</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getSchema <em>Schema</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage <em>Uml Package</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema()
 * @model
 * @generated
 */
public interface PackageToSchema extends UmlToRdbmsModelElement {
	/**
	 * Returns the value of the '<em><b>Classes To Tables</b></em>' containment reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml2rdbms.ClassToTable}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml2rdbms.ClassToTable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes To Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes To Tables</em>' containment reference list.
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_ClassesToTables()
	 * @see simpleuml2rdbms.uml2rdbms.ClassToTable#getOwner
	 * @model opposite="owner" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ClassToTable> getClassesToTables();

	/**
	 * Returns the value of the '<em><b>Primitives To Names</b></em>' containment reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml2rdbms.PrimitiveToName}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitives To Names</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitives To Names</em>' containment reference list.
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_PrimitivesToNames()
	 * @see simpleuml2rdbms.uml2rdbms.PrimitiveToName#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<PrimitiveToName> getPrimitivesToNames();

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
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_Schema()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	Schema getSchema();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getSchema <em>Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(Schema value);

	/**
	 * Returns the value of the '<em><b>Uml Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Package</em>' reference.
	 * @see #setUmlPackage(simpleuml2rdbms.uml.Package)
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPackageToSchema_UmlPackage()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	simpleuml2rdbms.uml.Package getUmlPackage();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getUmlPackage <em>Uml Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Package</em>' reference.
	 * @see #getUmlPackage()
	 * @generated
	 */
	void setUmlPackage(simpleuml2rdbms.uml.Package value);

} // PackageToSchema
