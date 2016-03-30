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
 * A representation of the model object '<em><b>Life Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getMsgEvent <em>Msg Event</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getInteraction <em>Interaction</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getLifeLine()
 * @model
 * @generated
 */
public interface LifeLine extends EObject {
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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getLifeLine_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Msg Event</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Msg Event</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg Event</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getLifeLine_MsgEvent()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getLifeline
	 * @model opposite="lifeline" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<MessageEvent> getMsgEvent();

	/**
	 * Returns the value of the '<em><b>State</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getLifeLine_State()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getLifeline
	 * @model opposite="lifeline" required="true" ordered="false"
	 * @generated
	 */
	EList<State> getState();

	/**
	 * Returns the value of the '<em><b>Interaction</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction</em>' container reference.
	 * @see #setInteraction(Interaction)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getLifeLine_Interaction()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getLifeline
	 * @model opposite="lifeline" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Interaction getInteraction();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getInteraction <em>Interaction</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction</em>' container reference.
	 * @see #getInteraction()
	 * @generated
	 */
	void setInteraction(Interaction value);

} // LifeLine
