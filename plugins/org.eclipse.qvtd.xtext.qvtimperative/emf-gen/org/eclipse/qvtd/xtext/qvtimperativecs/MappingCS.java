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
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedMappingSequence <em>Owned Mapping Sequence</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS()
 * @model
 * @generated
 */
public interface MappingCS extends AbstractMappingCS {
	/**
	 * Returns the value of the '<em><b>Owned Mapping Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mapping Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mapping Sequence</em>' containment reference.
	 * @see #setOwnedMappingSequence(MappingSequenceCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCS_OwnedMappingSequence()
	 * @model containment="true"
	 * @generated
	 */
	MappingSequenceCS getOwnedMappingSequence();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS#getOwnedMappingSequence <em>Owned Mapping Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Mapping Sequence</em>' containment reference.
	 * @see #getOwnedMappingSequence()
	 * @generated
	 */
	void setOwnedMappingSequence(MappingSequenceCS value);

} // MappingCS
