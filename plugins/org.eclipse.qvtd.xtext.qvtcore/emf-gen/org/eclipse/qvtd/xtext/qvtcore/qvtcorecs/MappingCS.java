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
package org.eclipse.qvtd.xtext.qvtcore.qvtcorecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS#getComposedMappings <em>Composed Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS#getRefines <em>Refines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage#getMappingCS()
 * @model
 * @generated
 */
public interface MappingCS extends AbstractMappingCS {
	/**
	 * Returns the value of the '<em><b>Composed Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed Mappings</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage#getMappingCS_ComposedMappings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MappingCS> getComposedMappings();

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage#getMappingCS_Refines()
	 * @model
	 * @generated
	 */
	EList<Mapping> getRefines();

} // MappingCS
