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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.runtime.qvttrace.TraceInstance#getOwningModel <em>Owning Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage#getTraceInstance()
 * @model abstract="true"
 * @generated
 */
public interface TraceInstance extends TraceElement {
	/**
	 * Returns the value of the '<em><b>Owning Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.runtime.qvttrace.TraceModel#getOwnedTraces <em>Owned Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Rule represented by this RuleRegion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Model</em>' container reference.
	 * @see #setOwningModel(TraceModel)
	 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage#getTraceInstance_OwningModel()
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceModel#getOwnedTraces
	 * @model opposite="ownedTraces" transient="false"
	 * @generated
	 */
	TraceModel getOwningModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.runtime.qvttrace.TraceInstance#getOwningModel <em>Owning Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Model</em>' container reference.
	 * @see #getOwningModel()
	 * @generated
	 */
	void setOwningModel(TraceModel value);

} // TraceInstance
