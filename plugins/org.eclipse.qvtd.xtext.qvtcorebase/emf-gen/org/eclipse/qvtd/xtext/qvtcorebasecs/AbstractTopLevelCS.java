/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtcorebasecs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.xtext.basecs.RootPackageCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractTopLevelCS#getOwnedQueries <em>Owned Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractTopLevelCS#getOwnedTransformations <em>Owned Transformations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getAbstractTopLevelCS()
 * @model abstract="true"
 * @generated
 */
public interface AbstractTopLevelCS extends RootPackageCS {
	/**
	 * Returns the value of the '<em><b>Owned Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Queries</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getAbstractTopLevelCS_OwnedQueries()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryCS> getOwnedQueries();

	/**
	 * Returns the value of the '<em><b>Owned Transformations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Transformations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Transformations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getAbstractTopLevelCS_OwnedTransformations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationCS> getOwnedTransformations();

} // AbstractTopLevelCS
