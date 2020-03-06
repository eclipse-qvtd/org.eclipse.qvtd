/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Part Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A KeyPartEdge conveys a key part key and value to a keyed value construction node.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge#getReferredPart <em>Referred Part</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getKeyPartEdge()
 * @model
 * @generated
 */
public interface KeyPartEdge extends NavigationEdge {
	/**
	 * Returns the value of the '<em><b>Referred Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * PropertyDatum for a keyed value construction.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Part</em>' reference.
	 * @see #setReferredPart(PropertyDatum)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getKeyPartEdge_ReferredPart()
	 * @model required="true"
	 * @generated
	 */
	PropertyDatum getReferredPart();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge#getReferredPart <em>Referred Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Part</em>' reference.
	 * @see #getReferredPart()
	 * @generated
	 */
	void setReferredPart(PropertyDatum value);

} // KeyPartEdge
