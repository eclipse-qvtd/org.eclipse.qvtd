/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Pattern Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternEdge#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternEdge#isIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge()
 * @generated
 */
public interface RelPatternEdge extends UMLXEdge {
	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(EStructuralFeature)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge_ReferredProperty()
	 * @generated
	 */
	EStructuralFeature getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Is Opposite</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Opposite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Opposite</em>' attribute.
	 * @see #setIsOpposite(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge_IsOpposite()
	 * @generated
	 */
	boolean isIsOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#isIsOpposite <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Opposite</em>' attribute.
	 * @see #isIsOpposite()
	 * @generated
	 */
	void setIsOpposite(boolean value);

} // RelPatternEdge
