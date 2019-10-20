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
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An EntryPoint specifies a per-direction root Mapping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.EntryPoint#getInputTypedModels <em>Input Typed Models</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.EntryPoint#getOutputTypedModels <em>Output Typed Models</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getEntryPoint()
 * @generated
 */
public interface EntryPoint extends Mapping {
	/**
	 * Returns the value of the '<em><b>Input Typed Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModels defining the inputs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Typed Models</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getEntryPoint_InputTypedModels()
	 * @generated
	 */
	EList<TypedModel> getInputTypedModels();

	/**
	 * Returns the value of the '<em><b>Output Typed Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TypedModels defining the outputs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Typed Models</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getEntryPoint_OutputTypedModels()
	 * @generated
	 */
	EList<TypedModel> getOutputTypedModels();

} // EntryPoint
