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
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getTransition <em>Transition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage#getStateMachine_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage#getStateMachine_State()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getOwner
	 * @model opposite="owner" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<State> getState();

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage#getStateMachine_Transition()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getOwner
	 * @model opposite="owner" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Transition> getTransition();

} // StateMachine
