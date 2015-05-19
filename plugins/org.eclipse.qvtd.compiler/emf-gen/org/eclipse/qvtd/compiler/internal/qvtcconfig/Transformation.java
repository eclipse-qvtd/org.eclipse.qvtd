/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.compiler.internal.qvtcconfig;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation#getImport <em>Import</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' containment reference list.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getTransformation_Direction()
	 * @model containment="true"
	 * @generated
	 */
	EList<Direction> getDirection();

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.compiler.internal.qvtcconfig.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' containment reference list.
	 * @see org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage#getTransformation_Import()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImport();

} // Transformation
