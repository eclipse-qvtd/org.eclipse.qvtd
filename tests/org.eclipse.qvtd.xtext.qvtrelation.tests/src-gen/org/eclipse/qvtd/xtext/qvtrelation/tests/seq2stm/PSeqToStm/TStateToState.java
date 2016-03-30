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
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TState To State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSn <em>Sn</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt1 <em>St1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getL <em>L</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getI <em>I</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt2 <em>St2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getS <em>S</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTStateToState()
 * @model
 * @generated
 */
public interface TStateToState extends EObject {
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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTStateToState_Sn()
	 * @model required="true"
	 * @generated
	 */
	String getSn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSn <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sn</em>' attribute.
	 * @see #getSn()
	 * @generated
	 */
	void setSn(String value);

	/**
	 * Returns the value of the '<em><b>St1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>St1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>St1</em>' reference.
	 * @see #setSt1(State)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTStateToState_St1()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TStateToState' lower='1'"
	 * @generated
	 */
	State getSt1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt1 <em>St1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>St1</em>' reference.
	 * @see #getSt1()
	 * @generated
	 */
	void setSt1(State value);

	/**
	 * Returns the value of the '<em><b>L</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>L</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>L</em>' reference.
	 * @see #setL(LifeLine)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTStateToState_L()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TStateToState' lower='1'"
	 * @generated
	 */
	LifeLine getL();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getL <em>L</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L</em>' reference.
	 * @see #getL()
	 * @generated
	 */
	void setL(LifeLine value);

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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTStateToState_I()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TStateToState' lower='1'"
	 * @generated
	 */
	Interaction getI();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getI <em>I</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' reference.
	 * @see #getI()
	 * @generated
	 */
	void setI(Interaction value);

	/**
	 * Returns the value of the '<em><b>St2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>St2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>St2</em>' reference.
	 * @see #setSt2(org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTStateToState_St2()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TStateToState' lower='1'"
	 * @generated
	 */
	org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State getSt2();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getSt2 <em>St2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>St2</em>' reference.
	 * @see #getSt2()
	 * @generated
	 */
	void setSt2(org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State value);

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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#getTStateToState_S()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TStateToState' lower='1'"
	 * @generated
	 */
	StateMachine getS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState#getS <em>S</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>S</em>' reference.
	 * @see #getS()
	 * @generated
	 */
	void setS(StateMachine value);

} // TStateToState
