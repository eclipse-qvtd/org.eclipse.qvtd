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

import org.eclipse.ocl.pivot.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Parameter Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OperationParameterEdge conveys an operation/iteration source/argument to an operation/iteration node. Pseudo-operations support if()/loop() arguments.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getReferredParameter <em>Referred Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getParameterIndex <em>Parameter Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getOperationParameterEdge()
 * @model
 * @generated
 */
public interface OperationParameterEdge extends ArgumentEdge {
	/**
	 * Returns the value of the '<em><b>Referred Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Parameter for which this OperationParameterEdge conveys the argument. For a multi-parameter, parameterIndex disambiguates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Parameter</em>' reference.
	 * @see #setReferredParameter(Parameter)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getOperationParameterEdge_ReferredParameter()
	 * @model required="true"
	 * @generated
	 */
	Parameter getReferredParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getReferredParameter <em>Referred Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Parameter</em>' reference.
	 * @see #getReferredParameter()
	 * @generated
	 */
	void setReferredParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Parameter Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Disambiguating index when the referredParameter is a collection. -1 when referredParameter is not a Collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter Index</em>' attribute.
	 * @see #setParameterIndex(int)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getOperationParameterEdge_ParameterIndex()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getParameterIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getParameterIndex <em>Parameter Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Index</em>' attribute.
	 * @see #getParameterIndex()
	 * @generated
	 */
	void setParameterIndex(int value);

} // OperationParameterEdge
