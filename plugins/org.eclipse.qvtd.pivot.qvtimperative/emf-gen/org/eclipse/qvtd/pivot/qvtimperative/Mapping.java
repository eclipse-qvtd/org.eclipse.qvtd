/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Imperative Mapping extends the abstract declarative mapping to support
 * explicit nested invocation of mappings with bindings for the invoked mapping's
 * bound variables.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedGuardVariables <em>Owned Guard Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getInoutVariables <em>Inout Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedStatements <em>Owned Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getCheckedProperties <em>Checked Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping()
 * @generated
 */
public interface Mapping extends Rule {
	/**
	 * Returns the value of the '<em><b>Owned Guard Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.GuardVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Guard Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Guard Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_OwnedGuardVariables()
	 * @generated
	 */
	EList<GuardVariable> getOwnedGuardVariables();

	/**
	 * Returns the value of the '<em><b>Inout Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inout Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inout Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_InoutVariables()
	 * @generated
	 */
	EList<InConnectionVariable> getInoutVariables();

	/**
	 * Returns the value of the '<em><b>Owned Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Statements</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_OwnedStatements()
	 * @generated
	 */
	EList<Statement> getOwnedStatements();

	/**
	 * Returns the value of the '<em><b>Checked Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties whose accesses must be polled for readiness prior to use here.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Checked Properties</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_CheckedProperties()
	 * @generated
	 */
	EList<Property> getCheckedProperties();

} // Mapping
