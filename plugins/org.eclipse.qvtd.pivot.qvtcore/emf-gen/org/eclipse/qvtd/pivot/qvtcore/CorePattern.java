/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.pivot.Variable;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.CorePattern#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getCorePattern()
 * @model
 * @generated
 */
public interface CorePattern extends Pattern {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getCorePattern_Variable()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Area getArea();

} // CorePattern
