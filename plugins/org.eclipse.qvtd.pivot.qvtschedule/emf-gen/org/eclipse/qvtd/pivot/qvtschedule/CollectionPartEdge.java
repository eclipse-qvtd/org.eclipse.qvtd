/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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

import org.eclipse.ocl.pivot.CollectionLiteralPart;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Part Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CollectionPartEdge conveys collection part to a collection construction node.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge#getReferredPart <em>Referred Part</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCollectionPartEdge()
 * @model
 * @generated
 */
public interface CollectionPartEdge extends ArgumentEdge {
	/**
	 * Returns the value of the '<em><b>Referred Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Collection item lor range for a collection construction.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Part</em>' reference.
	 * @see #setReferredPart(CollectionLiteralPart)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCollectionPartEdge_ReferredPart()
	 * @model required="true"
	 * @generated
	 */
	CollectionLiteralPart getReferredPart();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge#getReferredPart <em>Referred Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Part</em>' reference.
	 * @see #getReferredPart()
	 * @generated
	 */
	void setReferredPart(CollectionLiteralPart value);

} // CollectionPartEdge
