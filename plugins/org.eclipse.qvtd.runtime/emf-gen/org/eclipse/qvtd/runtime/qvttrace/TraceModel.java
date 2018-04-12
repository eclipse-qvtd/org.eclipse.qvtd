/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.runtime.qvttrace;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.runtime.qvttrace.TraceModel#getOwnedTraces <em>Owned Traces</em>}</li>
 *   <li>{@link org.eclipse.qvtd.runtime.qvttrace.TraceModel#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage#getTraceModel()
 * @model
 * @generated
 */
public interface TraceModel extends TraceElement {
	/**
	 * Returns the value of the '<em><b>Owned Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.runtime.qvttrace.TraceInstance}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.runtime.qvttrace.TraceInstance#getOwningModel <em>Owning Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Traces</em>' containment reference list.
	 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage#getTraceModel_OwnedTraces()
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceInstance#getOwningModel
	 * @model opposite="owningModel" containment="true"
	 * @generated
	 */
	EList<TraceInstance> getOwnedTraces();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage#getTraceModel_Name()
	 * @model required="true"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.runtime.qvttrace.TraceModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TraceModel
