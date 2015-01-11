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

import org.eclipse.emf.ecore.EObject;
import test.simpleuml.PrimitiveDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive To Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test.umltordbms.PrimitiveToName#getOwner <em>Owner</em>}</li>
 *   <li>{@link test.umltordbms.PrimitiveToName#getName <em>Name</em>}</li>
 *   <li>{@link test.umltordbms.PrimitiveToName#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link test.umltordbms.PrimitiveToName#getTypeName <em>Type Name</em>}</li>
 * </ul>
 *
 * @see test.umltordbms.UmltordbmsPackage#getPrimitiveToName()
 * @model
 * @generated
 */
public interface PrimitiveToName extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link test.umltordbms.PackageToSchema#getPrimitivesToNames <em>Primitives To Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(PackageToSchema)
	 * @see test.umltordbms.UmltordbmsPackage#getPrimitiveToName_Owner()
	 * @see test.umltordbms.PackageToSchema#getPrimitivesToNames
	 * @model opposite="primitivesToNames" transient="false"
	 * @generated
	 */
	PackageToSchema getOwner();

	/**
	 * Sets the value of the '{@link test.umltordbms.PrimitiveToName#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(PackageToSchema value);

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
	 * @see test.umltordbms.UmltordbmsPackage#getPrimitiveToName_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test.umltordbms.PrimitiveToName#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see test.umltordbms.UmltordbmsPackage#getPrimitiveToName_Primitive()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveDataType getPrimitive();

	/**
	 * Sets the value of the '{@link test.umltordbms.PrimitiveToName#getPrimitive <em>Primitive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' reference.
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(PrimitiveDataType value);

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
	 * @see test.umltordbms.UmltordbmsPackage#getPrimitiveToName_TypeName()
	 * @model required="true"
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '{@link test.umltordbms.PrimitiveToName#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

} // PrimitiveToName
