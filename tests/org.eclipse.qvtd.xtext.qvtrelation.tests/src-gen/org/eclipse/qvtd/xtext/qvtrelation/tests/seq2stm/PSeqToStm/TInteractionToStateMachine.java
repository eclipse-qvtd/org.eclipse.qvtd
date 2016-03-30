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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TInteraction To State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getSn <em>Sn</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getI <em>I</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getS <em>S</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTInteractionToStateMachine()
 * @model
 * @generated
 */
public interface TInteractionToStateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sn</em>' attribute.
	 * @see #setSn(String)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTInteractionToStateMachine_Sn()
	 * @model required="true"
	 * @generated
	 */
	String getSn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getSn <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sn</em>' attribute.
	 * @see #getSn()
	 * @generated
	 */
	void setSn(String value);

	/**
	 * Returns the value of the '<em><b>I</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>I</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>I</em>' reference.
	 * @see #setI(Interaction)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTInteractionToStateMachine_I()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TInteractionToStateMachine' lower='1'"
	 * @generated
	 */
	Interaction getI();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getI <em>I</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' reference.
	 * @see #getI()
	 * @generated
	 */
	void setI(Interaction value);

	/**
	 * Returns the value of the '<em><b>S</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>S</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>S</em>' reference.
	 * @see #setS(StateMachine)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTInteractionToStateMachine_S()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TInteractionToStateMachine' lower='1'"
	 * @generated
	 */
	StateMachine getS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine#getS <em>S</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>S</em>' reference.
	 * @see #getS()
	 * @generated
	 */
	void setS(StateMachine value);

} // TInteractionToStateMachine
