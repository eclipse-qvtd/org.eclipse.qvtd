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
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingCallBinding specifies the binding of a single variable as part of
 * a MappingCall. A value is bound to the variable. OPtionally isLoop may be true
 * to indicate that the value is a collection of values, each of which is to
 * be used as part of a distinct invocation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getMappingCall <em>Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getBoundVariable <em>Bound Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingParameterBinding()
 * @generated
 */
public interface MappingParameterBinding extends Element {
	/**
	 * Returns the value of the '<em><b>Mapping Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Call</em>' container reference.
	 * @see #setMappingCall(MappingCall)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingParameterBinding_MappingCall()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getBinding
	 * @generated
	 */
	MappingCall getMappingCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getMappingCall <em>Mapping Call</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Call</em>' container reference.
	 * @see #getMappingCall()
	 * @generated
	 */
	void setMappingCall(MappingCall value);

	/**
	 * Returns the value of the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable with the mappingCall.referredMapping bound to the/a value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bound Variable</em>' reference.
	 * @see #setBoundVariable(MappingParameter)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingParameterBinding_BoundVariable()
	 * @generated
	 */
	MappingParameter getBoundVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getBoundVariable <em>Bound Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Variable</em>' reference.
	 * @see #getBoundVariable()
	 * @generated
	 */
	void setBoundVariable(MappingParameter value);

} // MappingParameterBinding
