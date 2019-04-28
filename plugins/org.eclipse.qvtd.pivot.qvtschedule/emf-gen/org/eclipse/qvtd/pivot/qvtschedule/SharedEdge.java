/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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

import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shared Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A SharedEdge supports the directed shared aggregation from a DataType node to its aggregator node within a Region.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.SharedEdge#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getSharedEdge()
 * @model
 * @generated
 */
public interface SharedEdge extends NavigableEdge {
	/**
	 * Returns the value of the '<em><b>Referred Opposite Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property to navigate from source to target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #setReferredOppositeProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getSharedEdge_ReferredOppositeProperty()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!SharedEdge!referredOppositeProperty'"
	 * @generated
	 */
	Property getReferredOppositeProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.SharedEdge#getReferredOppositeProperty <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #getReferredOppositeProperty()
	 * @generated
	 */
	void setReferredOppositeProperty(Property value);

} // SharedEdge
