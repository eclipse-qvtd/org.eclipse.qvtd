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

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingCallBinding specifies the binding of a single variable or value to
 * the formal parameter of a mapping as part of its inviocatuon or installation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getOwningMappingCall <em>Owning Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getBoundVariable <em>Bound Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingParameterBinding()
 * @generated
 */
public interface MappingParameterBinding extends Element {
	/**
	 * Returns the value of the '<em><b>Owning Mapping Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getOwnedMappingParameterBindings <em>Owned Mapping Parameter Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Mapping Call</em>' container reference.
	 * @see #setOwningMappingCall(MappingCall)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingParameterBinding_OwningMappingCall()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getOwnedMappingParameterBindings
	 * @generated
	 */
	MappingCall getOwningMappingCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getOwningMappingCall <em>Owning Mapping Call</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Mapping Call</em>' container reference.
	 * @see #getOwningMappingCall()
	 * @generated
	 */
	void setOwningMappingCall(MappingCall value);

	/**
	 * Returns the value of the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formal parameter bound by the call.
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateParameterIsMappingParameter(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MappingParameterBinding
