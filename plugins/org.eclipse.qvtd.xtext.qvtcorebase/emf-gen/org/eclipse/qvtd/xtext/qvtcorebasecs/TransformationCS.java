/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebasecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS#getDirections <em>Directions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getTransformationCS()
 * @model
 * @generated
 */
public interface TransformationCS extends ClassCS {
	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' containment reference.
	 * @see #setPathName(PathNameCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getTransformationCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS#getPathName <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' containment reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getTransformationCS_Package()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Package getPackage();

	/**
	 * Returns the value of the '<em><b>Directions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directions</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage#getTransformationCS_Directions()
	 * @model containment="true"
	 * @generated
	 */
	EList<DirectionCS> getDirections();

} // TransformationCS
