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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion#getReferredMapping <em>Referred Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicMappingRegion()
 * @model
 * @generated
 */
public interface BasicMappingRegion extends MappingRegion {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicMappingRegion_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!BasicMappingRegion!name'"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Returns the value of the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property to navigate from source to target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Mapping</em>' reference.
	 * @see #setReferredMapping(Mapping)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getBasicMappingRegion_ReferredMapping()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!BasicMappingRegion!referredMapping'"
	 * @generated
	 */
	Mapping getReferredMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion#getReferredMapping <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Mapping</em>' reference.
	 * @see #getReferredMapping()
	 * @generated
	 */
	void setReferredMapping(Mapping value);

	@Nullable Node getNode(@NonNull TypedElement typedElement);
} // BasicMappingRegion
