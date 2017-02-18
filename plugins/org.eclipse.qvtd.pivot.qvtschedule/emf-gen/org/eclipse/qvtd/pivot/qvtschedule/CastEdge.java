/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cast Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getPrimaryClass <em>Primary Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCastEdge()
 * @model
 * @generated
 */
public interface CastEdge extends NavigableEdge
{
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property to navigate from source to target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCastEdge_Property()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!CastEdge!property'"
	 * @generated
	 */
	@Override
	Property getProperty();

	/**
	 * Returns the value of the '<em><b>Primary Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Class</em>' reference.
	 * @see #setPrimaryClass(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCastEdge_PrimaryClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!CastEdge!primaryClass'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getPrimaryClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getPrimaryClass <em>Primary Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Class</em>' reference.
	 * @see #getPrimaryClass()
	 * @generated
	 */
	void setPrimaryClass(org.eclipse.ocl.pivot.Class value);

	void initializeProperty(@NonNull Property property);
} // CastEdge
