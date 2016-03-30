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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getPrev <em>Prev</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getNext <em>Next</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getState <em>State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getMessageEvent()
 * @model
 * @generated
 */
public interface MessageEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Send"</code>.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType
	 * @see #setType(MessageEventType)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getMessageEvent_Type()
	 * @model default="Send" required="true" ordered="false"
	 * @generated
	 */
	MessageEventType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType
	 * @see #getType()
	 * @generated
	 */
	void setType(MessageEventType value);

	/**
	 * Returns the value of the '<em><b>Prev</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prev</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prev</em>' reference.
	 * @see #setPrev(MessageEvent)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getMessageEvent_Prev()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MessageEvent getPrev();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getPrev <em>Prev</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prev</em>' reference.
	 * @see #getPrev()
	 * @generated
	 */
	void setPrev(MessageEvent value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' reference.
	 * @see #setNext(MessageEvent)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getMessageEvent_Next()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MessageEvent getNext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getNext <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(MessageEvent value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(Message)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getMessageEvent_Message()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message#getEvent
	 * @model opposite="event" required="true" ordered="false"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

	/**
	 * Returns the value of the '<em><b>Lifeline</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getMsgEvent <em>Msg Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifeline</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifeline</em>' container reference.
	 * @see #setLifeline(LifeLine)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getMessageEvent_Lifeline()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine#getMsgEvent
	 * @model opposite="msgEvent" required="true" transient="false" ordered="false"
	 * @generated
	 */
	LifeLine getLifeline();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getLifeline <em>Lifeline</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifeline</em>' container reference.
	 * @see #getLifeline()
	 * @generated
	 */
	void setLifeline(LifeLine value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getMessageevent <em>Messageevent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference.
	 * @see #setState(State)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#getMessageEvent_State()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State#getMessageevent
	 * @model opposite="messageevent" required="true" ordered="false"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent#getState <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

} // MessageEvent
