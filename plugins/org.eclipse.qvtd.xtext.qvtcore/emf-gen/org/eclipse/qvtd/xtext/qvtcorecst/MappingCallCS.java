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
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCallCS#getReferredMapping <em>Referred Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCallCS#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getMappingCallCS()
 * @model
 * @generated
 */
public interface MappingCallCS extends ComposedMappingCS {
	/**
	 * Returns the value of the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Mapping</em>' reference.
	 * @see #setReferredMapping(Mapping)
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getMappingCallCS_ReferredMapping()
	 * @model required="true"
	 * @generated
	 */
	Mapping getReferredMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCallCS#getReferredMapping <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Mapping</em>' reference.
	 * @see #getReferredMapping()
	 * @generated
	 */
	void setReferredMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCallBindingCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCallBindingCS#getMappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getMappingCallCS_Bindings()
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.MappingCallBindingCS#getMappingCall
	 * @model opposite="mappingCall" containment="true" ordered="false"
	 * @generated
	 */
	EList<MappingCallBindingCS> getBindings();

} // MappingCallCS
