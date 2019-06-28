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

import org.eclipse.ocl.pivot.Type;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Self Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OperationSelfEdge conveys an operation/iteration source type to an operation/iteration node.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getOperationSelfEdge()
 * @model
 * @generated
 */
public interface OperationSelfEdge extends ArgumentEdge {
	/**
	 * Returns the value of the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type for an OperationSelfEdge conveying a self source to an operation/iteration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Type</em>' reference.
	 * @see #setReferredType(Type)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getOperationSelfEdge_ReferredType()
	 * @model required="true"
	 * @generated
	 */
	Type getReferredType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge#getReferredType <em>Referred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Type</em>' reference.
	 * @see #getReferredType()
	 * @generated
	 */
	void setReferredType(Type value);

} // OperationSelfEdge
