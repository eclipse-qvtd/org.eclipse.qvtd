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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMFactory
 * @model kind="package"
 * @generated
 */
public interface SeqMMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SeqMM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "SeqMM";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "seq";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SeqMMPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.DummyImpl <em>Dummy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.DummyImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getDummy()
	 * @generated
	 */
	int DUMMY = 0;

	/**
	 * The feature id for the '<em><b>Has Interaction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUMMY__HAS_INTERACTION = 0;

	/**
	 * The feature id for the '<em><b>Contained State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DUMMY__CONTAINED_STATE = 1;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.InteractionImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__LIFELINE = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__MESSAGE = 2;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl <em>Life Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getLifeLine()
	 * @generated
	 */
	int LIFE_LINE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_LINE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Msg Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_LINE__MSG_EVENT = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_LINE__STATE = 2;

	/**
	 * The feature id for the '<em><b>Interaction</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_LINE__INTERACTION = 3;

	/**
	 * The number of structural features of the '<em>Life Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_LINE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Life Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFE_LINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Message Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__MESSAGE_ID = 0;

	/**
	 * The feature id for the '<em><b>Interaction</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__INTERACTION = 1;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__EVENT = 2;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.StateImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getState()
	 * @generated
	 */
	int STATE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Messageevent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__MESSAGEEVENT = 1;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LIFELINE = 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.EventImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 5;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl <em>Message Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getMessageEvent()
	 * @generated
	 */
	int MESSAGE_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT__TYPE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Prev</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT__PREV = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT__NEXT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT__MESSAGE = EVENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT__LIFELINE = EVENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT__STATE = EVENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Message Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Message Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_OPERATION_COUNT = EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType <em>Message Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getMessageEventType()
	 * @generated
	 */
	int MESSAGE_EVENT_TYPE = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy <em>Dummy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dummy</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy
	 * @generated
	 */
	EClass getDummy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy#getHasInteraction <em>Has Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Has Interaction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy#getHasInteraction()
	 * @see #getDummy()
	 * @generated
	 */
	EReference getDummy_HasInteraction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy#getContainedState <em>Contained State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy#getContainedState()
	 * @see #getDummy()
	 * @generated
	 */
	EReference getDummy_ContainedState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getName()
	 * @see #getInteraction()
	 * @generated
	 */
	EAttribute getInteraction_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lifeline</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getLifeline()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Lifeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Message</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction#getMessage()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine <em>Life Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Life Line</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine
	 * @generated
	 */
	EClass getLifeLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getName()
	 * @see #getLifeLine()
	 * @generated
	 */
	EAttribute getLifeLine_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getMsgEvent <em>Msg Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Msg Event</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getMsgEvent()
	 * @see #getLifeLine()
	 * @generated
	 */
	EReference getLifeLine_MsgEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getState()
	 * @see #getLifeLine()
	 * @generated
	 */
	EReference getLifeLine_State();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interaction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getInteraction()
	 * @see #getLifeLine()
	 * @generated
	 */
	EReference getLifeLine_Interaction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getMessageId <em>Message Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getMessageId()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_MessageId();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getInteraction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Interaction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getInteraction()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Interaction();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getEvent()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Event();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getMessageevent <em>Messageevent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Messageevent</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getMessageevent()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Messageevent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lifeline</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getLifeline()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Lifeline();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent <em>Message Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Event</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent
	 * @generated
	 */
	EClass getMessageEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getType()
	 * @see #getMessageEvent()
	 * @generated
	 */
	EAttribute getMessageEvent_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getPrev <em>Prev</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prev</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getPrev()
	 * @see #getMessageEvent()
	 * @generated
	 */
	EReference getMessageEvent_Prev();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getNext()
	 * @see #getMessageEvent()
	 * @generated
	 */
	EReference getMessageEvent_Next();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getMessage()
	 * @see #getMessageEvent()
	 * @generated
	 */
	EReference getMessageEvent_Message();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Lifeline</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getLifeline()
	 * @see #getMessageEvent()
	 * @generated
	 */
	EReference getMessageEvent_Lifeline();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getState()
	 * @see #getMessageEvent()
	 * @generated
	 */
	EReference getMessageEvent_State();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType <em>Message Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Message Event Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType
	 * @generated
	 */
	EEnum getMessageEventType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SeqMMFactory getSeqMMFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.DummyImpl <em>Dummy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.DummyImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getDummy()
		 * @generated
		 */
		EClass DUMMY = eINSTANCE.getDummy();

		/**
		 * The meta object literal for the '<em><b>Has Interaction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUMMY__HAS_INTERACTION = eINSTANCE.getDummy_HasInteraction();

		/**
		 * The meta object literal for the '<em><b>Contained State</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DUMMY__CONTAINED_STATE = eINSTANCE.getDummy_ContainedState();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.InteractionImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION__NAME = eINSTANCE.getInteraction_Name();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__LIFELINE = eINSTANCE.getInteraction_Lifeline();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__MESSAGE = eINSTANCE.getInteraction_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl <em>Life Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getLifeLine()
		 * @generated
		 */
		EClass LIFE_LINE = eINSTANCE.getLifeLine();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFE_LINE__NAME = eINSTANCE.getLifeLine_Name();

		/**
		 * The meta object literal for the '<em><b>Msg Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFE_LINE__MSG_EVENT = eINSTANCE.getLifeLine_MsgEvent();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFE_LINE__STATE = eINSTANCE.getLifeLine_State();

		/**
		 * The meta object literal for the '<em><b>Interaction</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFE_LINE__INTERACTION = eINSTANCE.getLifeLine_Interaction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getMessage()
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
		 * The meta object literal for the '<em><b>Interaction</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__INTERACTION = eINSTANCE.getMessage_Interaction();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__EVENT = eINSTANCE.getMessage_Event();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.StateImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getState()
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
		 * The meta object literal for the '<em><b>Messageevent</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__MESSAGEEVENT = eINSTANCE.getState_Messageevent();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__LIFELINE = eINSTANCE.getState_Lifeline();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.EventImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl <em>Message Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getMessageEvent()
		 * @generated
		 */
		EClass MESSAGE_EVENT = eINSTANCE.getMessageEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_EVENT__TYPE = eINSTANCE.getMessageEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Prev</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EVENT__PREV = eINSTANCE.getMessageEvent_Prev();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EVENT__NEXT = eINSTANCE.getMessageEvent_Next();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EVENT__MESSAGE = eINSTANCE.getMessageEvent_Message();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EVENT__LIFELINE = eINSTANCE.getMessageEvent_Lifeline();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_EVENT__STATE = eINSTANCE.getMessageEvent_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType <em>Message Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType
		 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl#getMessageEventType()
		 * @generated
		 */
		EEnum MESSAGE_EVENT_TYPE = eINSTANCE.getMessageEventType();

	}

} //SeqMMPackage
