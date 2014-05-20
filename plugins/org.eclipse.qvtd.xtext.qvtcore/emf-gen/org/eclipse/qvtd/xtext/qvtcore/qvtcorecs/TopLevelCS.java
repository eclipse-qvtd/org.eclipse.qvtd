/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcore.qvtcorecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.TopLevelCS#getTransformations <em>Transformations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.TopLevelCS#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.TopLevelCS#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage#getTopLevelCS()
 * @model
 * @generated
 */
public interface TopLevelCS extends RootPackageCS {
	/**
	 * Returns the value of the '<em><b>Transformations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage#getTopLevelCS_Transformations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationCS> getTransformations();

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage#getTopLevelCS_Queries()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryCS> getQueries();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage#getTopLevelCS_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingCS> getMappings();

} // TopLevelCS
