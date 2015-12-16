/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.xtext.basecs.PathNameCS;

import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Domain CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS#getCheckedProperties <em>Checked Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS#getEnforcedProperties <em>Enforced Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getImperativeDomainCS()
 * @model
 * @generated
 */
public interface ImperativeDomainCS extends DomainCS {
	/**
	 * Returns the value of the '<em><b>Checked Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.PathNameCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties whose accesses must be polled for readiness prior to use here.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Checked Properties</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getImperativeDomainCS_CheckedProperties()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PathNameCS> getCheckedProperties();

	/**
	 * Returns the value of the '<em><b>Enforced Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.PathNameCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties whose assignments may be polled for readiness prior to use elsewhere.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enforced Properties</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getImperativeDomainCS_EnforcedProperties()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PathNameCS> getEnforcedProperties();

} // ImperativeDomainCS
