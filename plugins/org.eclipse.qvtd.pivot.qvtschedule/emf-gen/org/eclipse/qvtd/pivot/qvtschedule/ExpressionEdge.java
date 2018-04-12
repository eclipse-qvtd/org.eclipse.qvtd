/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge#getReferredObject <em>Referred Object</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getExpressionEdge()
 * @model
 * @generated
 */
public interface ExpressionEdge extends Edge {

	/**
	 * Returns the value of the '<em><b>Referred Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * String/Number/Boolean/EnumerationLiteral/OperationId to characterize the operation node
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Object</em>' attribute.
	 * @see #setReferredObject(Object)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getExpressionEdge_ReferredObject()
	 * @model dataType="org.eclipse.ocl.pivot.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ExpressionEdge!referredObject'"
	 * @generated
	 */
	Object getReferredObject();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge#getReferredObject <em>Referred Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Object</em>' attribute.
	 * @see #getReferredObject()
	 * @generated
	 */
	void setReferredObject(Object value);
} // ExpressionEdge
