/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement <em>Refinement</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getNestedCall <em>Nested Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends Rule, Area, NestedMapping {
	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement <em>Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_Specification()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement
	 * @model opposite="refinement" ordered="false"
	 * @generated
	 */
	EList<Mapping> getSpecification();

	/**
	 * Returns the value of the '<em><b>Local</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.NestedMapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.NestedMapping#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_Local()
	 * @see org.eclipse.qvtd.pivot.qvtcore.NestedMapping#getContext
	 * @model opposite="context" containment="true"
	 * @generated
	 */
	EList<NestedMapping> getLocal();

	/**
	 * Returns the value of the '<em><b>Refinement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refinement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refinement</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_Refinement()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification
	 * @model opposite="specification" ordered="false"
	 * @generated
	 */
	EList<Mapping> getRefinement();

	/**
	 * Returns the value of the '<em><b>Nested Call</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.MappingCall}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Call</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Call</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getMapping_NestedCall()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingCall> getNestedCall();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Mapping> getAllMappings();

} // Mapping
