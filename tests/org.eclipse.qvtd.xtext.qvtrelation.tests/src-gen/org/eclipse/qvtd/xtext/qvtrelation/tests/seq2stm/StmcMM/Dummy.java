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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM;

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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy#getContainsStateMachine <em>Contains State Machine</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy#getContainsMessage <em>Contains Message</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage#getDummy()
 * @model
 * @generated
 */
public interface Dummy extends EObject {
	/**
	 * Returns the value of the '<em><b>Contains State Machine</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains State Machine</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains State Machine</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage#getDummy_ContainsStateMachine()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<StateMachine> getContainsStateMachine();

	/**
	 * Returns the value of the '<em><b>Contains Message</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains Message</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains Message</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage#getDummy_ContainsMessage()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Message> getContainsMessage();

} // Dummy
