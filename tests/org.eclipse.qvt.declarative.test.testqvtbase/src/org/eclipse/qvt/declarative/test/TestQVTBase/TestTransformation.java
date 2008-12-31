/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TestTransformation.java,v 1.2 2008/12/31 18:14:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringBag <em>String Bag</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringOrderedSet <em>String Ordered Set</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringSequence <em>String Sequence</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringSet <em>String Set</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getString <em>String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestTransformation()
 * @model
 * @generated
 */
public interface TestTransformation extends Transformation {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestTransformation_Contents()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<EObject> getContents();

	/**
	 * Returns the value of the '<em><b>String Bag</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Bag</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Bag</em>' attribute list.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestTransformation_StringBag()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<String> getStringBag();

	/**
	 * Returns the value of the '<em><b>String Ordered Set</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Ordered Set</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Ordered Set</em>' attribute list.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestTransformation_StringOrderedSet()
	 * @model
	 * @generated
	 */
	EList<String> getStringOrderedSet();

	/**
	 * Returns the value of the '<em><b>String Sequence</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Sequence</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Sequence</em>' attribute list.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestTransformation_StringSequence()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getStringSequence();

	/**
	 * Returns the value of the '<em><b>String Set</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Set</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Set</em>' attribute list.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestTransformation_StringSet()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getStringSet();

	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestTransformation_String()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

} // TestTransformation
