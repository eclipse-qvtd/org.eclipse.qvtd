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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMFactory
 * @model kind="package"
 * @generated
 */
public interface StmcMMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StmcMM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "StmcMM";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "stmc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StmcMMPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.DummyImpl <em>Dummy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.DummyImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getDummy()
	 * @generated
	 */
	int DUMMY = 0;

	/**
	 * The feature id for the '<em><b>Contains State Machine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUMMY__CONTAINS_STATE_MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Contains Message</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUMMY__CONTAINS_MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>Dummy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUMMY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Dummy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUMMY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateMachineImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__NAME = 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__STATE = 1;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__TRANSITION = 2;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getState()
	 * @generated
	 */
	int STATE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNER = 1;

	/**
	 * The feature id for the '<em><b>In Transition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IN_TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>Out Transition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUT_TRANSITION = 3;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OWNER = 2;

	/**
	 * The feature id for the '<em><b>To State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO_STATE = 3;

	/**
	 * The feature id for the '<em><b>From State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM_STATE = 4;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGER = 5;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTION = 6;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.EventImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.ActionImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.MessageImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 6;

	/**
	 * The feature id for the '<em><b>Message Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__MESSAGE_ID = 0;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.SendMsgImpl <em>Send Msg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.SendMsgImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getSendMsg()
	 * @generated
	 */
	int SEND_MSG = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MSG__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MSG__MESSAGE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Send Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MSG_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Send Msg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MSG_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy <em>Dummy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dummy</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy
	 * @generated
	 */
	EClass getDummy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy#getContainsStateMachine <em>Contains State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains State Machine</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy#getContainsStateMachine()
	 * @see #getDummy()
	 * @generated
	 */
	EReference getDummy_ContainsStateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy#getContainsMessage <em>Contains Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains Message</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy#getContainsMessage()
	 * @see #getDummy()
	 * @generated
	 */
	EReference getDummy_ContainsMessage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getName()
	 * @see #getStateMachine()
	 * @generated
	 */
	EAttribute getStateMachine_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_State();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine#getTransition()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_Transition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getOwner()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Owner();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getInTransition <em>In Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Transition</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getInTransition()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InTransition();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getOutTransition <em>Out Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Transition</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State#getOutTransition()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutTransition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getName()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guard</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Guard();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getOwner()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getToState <em>To State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getToState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_ToState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getFromState <em>From State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getFromState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_FromState();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getTrigger()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Trigger();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition#getAction()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Action();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Event#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Event#getName()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Message#getMessageId <em>Message Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Message#getMessageId()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_MessageId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.SendMsg <em>Send Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Msg</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.SendMsg
	 * @generated
	 */
	EClass getSendMsg();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.SendMsg#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.SendMsg#getMessage()
	 * @see #getSendMsg()
	 * @generated
	 */
	EReference getSendMsg_Message();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StmcMMFactory getStmcMMFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.DummyImpl <em>Dummy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.DummyImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getDummy()
		 * @generated
		 */
		EClass DUMMY = eINSTANCE.getDummy();

		/**
		 * The meta object literal for the '<em><b>Contains State Machine</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUMMY__CONTAINS_STATE_MACHINE = eINSTANCE.getDummy_ContainsStateMachine();

		/**
		 * The meta object literal for the '<em><b>Contains Message</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUMMY__CONTAINS_MESSAGE = eINSTANCE.getDummy_ContainsMessage();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateMachineImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_MACHINE__NAME = eINSTANCE.getStateMachine_Name();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__STATE = eINSTANCE.getStateMachine_State();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__TRANSITION = eINSTANCE.getStateMachine_Transition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StateImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNER = eINSTANCE.getState_Owner();

		/**
		 * The meta object literal for the '<em><b>In Transition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__IN_TRANSITION = eINSTANCE.getState_InTransition();

		/**
		 * The meta object literal for the '<em><b>Out Transition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUT_TRANSITION = eINSTANCE.getState_OutTransition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__OWNER = eINSTANCE.getTransition_Owner();

		/**
		 * The meta object literal for the '<em><b>To State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TO_STATE = eINSTANCE.getTransition_ToState();

		/**
		 * The meta object literal for the '<em><b>From State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__FROM_STATE = eINSTANCE.getTransition_FromState();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TRIGGER = eINSTANCE.getTransition_Trigger();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ACTION = eINSTANCE.getTransition_Action();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.EventImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.ActionImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.MessageImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Message Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__MESSAGE_ID = eINSTANCE.getMessage_MessageId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.SendMsgImpl <em>Send Msg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.SendMsgImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl#getSendMsg()
		 * @generated
		 */
		EClass SEND_MSG = eINSTANCE.getSendMsg();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_MSG__MESSAGE = eINSTANCE.getSendMsg_Message();

	}

} //StmcMMPackage
