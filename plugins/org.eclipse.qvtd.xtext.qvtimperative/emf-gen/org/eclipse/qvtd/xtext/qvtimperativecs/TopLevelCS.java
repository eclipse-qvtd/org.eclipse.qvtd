/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedMappings <em>Owned Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS#getOwnedTransformations <em>Owned Transformations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTopLevelCS()
 * @model
 * @generated
 */
public interface TopLevelCS extends RootPackageCS {
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
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTopLevelCS_OwnedMappings()
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
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTopLevelCS_OwnedQueries()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryCS> getOwnedQueries();

	/**
	 * Returns the value of the '<em><b>Owned Transformations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Transformations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Transformations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getTopLevelCS_OwnedTransformations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationCS> getOwnedTransformations();

} // TopLevelCS
