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

import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getOwnedDirections <em>Owned Directions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getOwnedMappings <em>Owned Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getOwnedContextType <em>Owned Context Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTransformationCS()
 * @model
 * @generated
 */
public interface TransformationCS extends AbstractTransformationCS {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTransformationCS_Package()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Package getPackage();

	/**
	 * Returns the value of the '<em><b>Owned Directions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Directions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Directions</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTransformationCS_OwnedDirections()
	 * @model containment="true"
	 * @generated
	 */
	EList<DirectionCS> getOwnedDirections();

	/**
	 * Returns the value of the '<em><b>Owned Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mappings</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTransformationCS_OwnedMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingCS> getOwnedMappings();

	/**
	 * Returns the value of the '<em><b>Owned Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Queries</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTransformationCS_OwnedQueries()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryCS> getOwnedQueries();

	/**
	 * Returns the value of the '<em><b>Owned Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Context Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Context Type</em>' containment reference.
	 * @see #setOwnedContextType(TypedRefCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTransformationCS_OwnedContextType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedContextType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS#getOwnedContextType <em>Owned Context Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Context Type</em>' containment reference.
	 * @see #getOwnedContextType()
	 * @generated
	 */
	void setOwnedContextType(TypedRefCS value);

} // TransformationCS
