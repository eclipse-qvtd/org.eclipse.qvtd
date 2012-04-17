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
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getDirections <em>Directions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getTransformationCS()
 * @model
 * @generated
 */
public interface TransformationCS extends PackageCS {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getTransformationCS_Namespace()
	 * @model
	 * @generated
	 */
	EList<Namespace> getNamespace();

	/**
	 * Returns the value of the '<em><b>Directions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directions</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getTransformationCS_Directions()
	 * @model containment="true"
	 * @generated
	 */
	EList<DirectionCS> getDirections();

} // TransformationCS
