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
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.pivot.Property;

import org.eclipse.qvtd.pivot.qvtcorebase.Area;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea#getCheckedProperties <em>Checked Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea#getEnforcedProperties <em>Enforced Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeArea()
 * @generated
 */
public interface ImperativeArea extends Area {
	/**
	 * Returns the value of the '<em><b>Checked Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties whose accesses must be polled for readiness prior to use here.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Checked Properties</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeArea_CheckedProperties()
	 * @generated
	 */
	EList<Property> getCheckedProperties();

	/**
	 * Returns the value of the '<em><b>Enforced Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties whose assignments may be polled for readiness prior to use elsewhere.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enforced Properties</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeArea_EnforcedProperties()
	 * @generated
	 */
	EList<Property> getEnforcedProperties();

} // ImperativeArea
