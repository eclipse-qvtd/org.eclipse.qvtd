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

import simpleuml2rdbms.uml.PrimitiveDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive To Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getOwner <em>Owner</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getPrimitive <em>Primitive</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPrimitiveToName()
 * @model abstract="true"
 * @generated
 */
public interface PrimitiveToName extends UmlToRdbmsModelElement {
	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(String)
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPrimitiveToName_TypeName()
	 * @model required="true"
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames <em>Primitives To Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(PackageToSchema)
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPrimitiveToName_Owner()
	 * @see simpleuml2rdbms.uml2rdbms.PackageToSchema#getPrimitivesToNames
	 * @model opposite="primitivesToNames" required="true" transient="false"
	 * @generated
	 */
	PackageToSchema getOwner();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(PackageToSchema value);

	/**
	 * Returns the value of the '<em><b>Primitive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive</em>' reference.
	 * @see #setPrimitive(PrimitiveDataType)
	 * @see simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage#getPrimitiveToName_Primitive()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	PrimitiveDataType getPrimitive();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.uml2rdbms.PrimitiveToName#getPrimitive <em>Primitive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' reference.
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(PrimitiveDataType value);

} // PrimitiveToName
