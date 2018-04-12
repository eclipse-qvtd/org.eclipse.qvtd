/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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

import org.eclipse.ocl.pivot.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Value Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.OperationValueNode#getOperationValue <em>Operation Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getOperationValueNode()
 * @model
 * @generated
 */
public interface OperationValueNode extends OperationNode {
	/**
	 * Returns the value of the '<em><b>Operation Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Value</em>' reference.
	 * @see #setOperationValue(Operation)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getOperationValueNode_OperationValue()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!OperationValueNode!operationValue'"
	 * @generated
	 */
	Operation getOperationValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationValueNode#getOperationValue <em>Operation Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Value</em>' reference.
	 * @see #getOperationValue()
	 * @generated
	 */
	void setOperationValue(Operation value);

} // OperationValueNode
