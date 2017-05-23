/**
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsMany <em>Is Many</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsNullFree <em>Is Null Free</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXTypedElement#getReferredEClassifier <em>Referred EClassifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXTypedElement()
 * @generated
 */
public interface UMLXTypedElement extends UMLXNamedElement {
	/**
	 * Returns the value of the '<em><b>Is Many</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Many</em>' attribute.
	 * @see #setIsMany(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXTypedElement_IsMany()
	 * @generated
	 */
	boolean isIsMany();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsMany <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Many</em>' attribute.
	 * @see #isIsMany()
	 * @generated
	 */
	void setIsMany(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Null Free</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Null Free</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Null Free</em>' attribute.
	 * @see #setIsNullFree(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXTypedElement_IsNullFree()
	 * @generated
	 */
	boolean isIsNullFree();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Null Free</em>' attribute.
	 * @see #isIsNullFree()
	 * @generated
	 */
	void setIsNullFree(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXTypedElement_IsOrdered()
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Required</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Required</em>' attribute.
	 * @see #setIsRequired(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXTypedElement_IsRequired()
	 * @generated
	 */
	boolean isIsRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsRequired <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Required</em>' attribute.
	 * @see #isIsRequired()
	 * @generated
	 */
	void setIsRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXTypedElement_IsUnique()
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Referred EClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred EClassifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred EClassifier</em>' reference.
	 * @see #setReferredEClassifier(EClassifier)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXTypedElement_ReferredEClassifier()
	 * @generated
	 */
	EClassifier getReferredEClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#getReferredEClassifier <em>Referred EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred EClassifier</em>' reference.
	 * @see #getReferredEClassifier()
	 * @generated
	 */
	void setReferredEClassifier(EClassifier value);

} // UMLXTypedElement
