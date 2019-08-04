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
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.EntryPointCS#getCheckedTypedModels <em>Checked Typed Models</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.EntryPointCS#getEnforcedTypedModels <em>Enforced Typed Models</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getEntryPointCS()
 * @model
 * @generated
 */
public interface EntryPointCS extends MappingCS {
	/**
	 * Returns the value of the '<em><b>Checked Typed Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checked Typed Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checked Typed Models</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getEntryPointCS_CheckedTypedModels()
	 * @model
	 * @generated
	 */
	EList<TypedModel> getCheckedTypedModels();

	/**
	 * Returns the value of the '<em><b>Enforced Typed Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforced Typed Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforced Typed Models</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getEntryPointCS_EnforcedTypedModels()
	 * @model
	 * @generated
	 */
	EList<TypedModel> getEnforcedTypedModels();

} // EntryPointCS
