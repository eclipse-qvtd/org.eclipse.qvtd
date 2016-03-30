/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dummy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy#getHasInteraction <em>Has Interaction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy#getContainedState <em>Contained State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getDummy()
 * @model
 * @generated
 */
public interface Dummy extends EObject {
	/**
	 * Returns the value of the '<em><b>Has Interaction</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Interaction</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Interaction</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getDummy_HasInteraction()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Interaction> getHasInteraction();

	/**
	 * Returns the value of the '<em><b>Contained State</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained State</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getDummy_ContainedState()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<State> getContainedState();

} // Dummy
