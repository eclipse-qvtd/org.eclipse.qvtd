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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl#getPrev <em>Prev</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl#getNext <em>Next</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl#getLifeline <em>Lifeline</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.MessageEventImpl#getState <em>State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageEventImpl extends EventImpl implements MessageEvent {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final MessageEventType TYPE_EDEFAULT = MessageEventType.SEND;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected MessageEventType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrev() <em>Prev</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrev()
	 * @generated
	 * @ordered
	 */
	protected MessageEvent prev;

	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected MessageEvent next;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected Message message;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected State state;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeqMMPackage.Literals.MESSAGE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageEventType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(MessageEventType newType) {
		MessageEventType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageEvent getPrev() {
		if (prev != null && prev.eIsProxy()) {
			InternalEObject oldPrev = (InternalEObject)prev;
			prev = (MessageEvent)eResolveProxy(oldPrev);
			if (prev != oldPrev) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeqMMPackage.MESSAGE_EVENT__PREV, oldPrev, prev));
			}
		}
		return prev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageEvent basicGetPrev() {
		return prev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrev(MessageEvent newPrev) {
		MessageEvent oldPrev = prev;
		prev = newPrev;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__PREV, oldPrev, prev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageEvent getNext() {
		if (next != null && next.eIsProxy()) {
			InternalEObject oldNext = (InternalEObject)next;
			next = (MessageEvent)eResolveProxy(oldNext);
			if (next != oldNext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeqMMPackage.MESSAGE_EVENT__NEXT, oldNext, next));
			}
		}
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageEvent basicGetNext() {
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNext(MessageEvent newNext) {
		MessageEvent oldNext = next;
		next = newNext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__NEXT, oldNext, next));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMessage() {
		if (message != null && message.eIsProxy()) {
			InternalEObject oldMessage = (InternalEObject)message;
			message = (Message)eResolveProxy(oldMessage);
			if (message != oldMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeqMMPackage.MESSAGE_EVENT__MESSAGE, oldMessage, message));
			}
		}
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMessage(Message newMessage, NotificationChain msgs) {
		Message oldMessage = message;
		message = newMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__MESSAGE, oldMessage, newMessage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(Message newMessage) {
		if (newMessage != message) {
			NotificationChain msgs = null;
			if (message != null)
				msgs = ((InternalEObject)message).eInverseRemove(this, SeqMMPackage.MESSAGE__EVENT, Message.class, msgs);
			if (newMessage != null)
				msgs = ((InternalEObject)newMessage).eInverseAdd(this, SeqMMPackage.MESSAGE__EVENT, Message.class, msgs);
			msgs = basicSetMessage(newMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__MESSAGE, newMessage, newMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeLine getLifeline() {
		if (eContainerFeatureID() != SeqMMPackage.MESSAGE_EVENT__LIFELINE) return null;
		return (LifeLine)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLifeline(LifeLine newLifeline, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLifeline, SeqMMPackage.MESSAGE_EVENT__LIFELINE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifeline(LifeLine newLifeline) {
		if (newLifeline != eInternalContainer() || (eContainerFeatureID() != SeqMMPackage.MESSAGE_EVENT__LIFELINE && newLifeline != null)) {
			if (EcoreUtil.isAncestor(this, newLifeline))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLifeline != null)
				msgs = ((InternalEObject)newLifeline).eInverseAdd(this, SeqMMPackage.LIFE_LINE__MSG_EVENT, LifeLine.class, msgs);
			msgs = basicSetLifeline(newLifeline, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__LIFELINE, newLifeline, newLifeline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getState() {
		if (state != null && state.eIsProxy()) {
			InternalEObject oldState = (InternalEObject)state;
			state = (State)eResolveProxy(oldState);
			if (state != oldState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeqMMPackage.MESSAGE_EVENT__STATE, oldState, state));
			}
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetState(State newState, NotificationChain msgs) {
		State oldState = state;
		state = newState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__STATE, oldState, newState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(State newState) {
		if (newState != state) {
			NotificationChain msgs = null;
			if (state != null)
				msgs = ((InternalEObject)state).eInverseRemove(this, SeqMMPackage.STATE__MESSAGEEVENT, State.class, msgs);
			if (newState != null)
				msgs = ((InternalEObject)newState).eInverseAdd(this, SeqMMPackage.STATE__MESSAGEEVENT, State.class, msgs);
			msgs = basicSetState(newState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.MESSAGE_EVENT__STATE, newState, newState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeqMMPackage.MESSAGE_EVENT__MESSAGE:
				if (message != null)
					msgs = ((InternalEObject)message).eInverseRemove(this, SeqMMPackage.MESSAGE__EVENT, Message.class, msgs);
				return basicSetMessage((Message)otherEnd, msgs);
			case SeqMMPackage.MESSAGE_EVENT__LIFELINE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLifeline((LifeLine)otherEnd, msgs);
			case SeqMMPackage.MESSAGE_EVENT__STATE:
				if (state != null)
					msgs = ((InternalEObject)state).eInverseRemove(this, SeqMMPackage.STATE__MESSAGEEVENT, State.class, msgs);
				return basicSetState((State)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeqMMPackage.MESSAGE_EVENT__MESSAGE:
				return basicSetMessage(null, msgs);
			case SeqMMPackage.MESSAGE_EVENT__LIFELINE:
				return basicSetLifeline(null, msgs);
			case SeqMMPackage.MESSAGE_EVENT__STATE:
				return basicSetState(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SeqMMPackage.MESSAGE_EVENT__LIFELINE:
				return eInternalContainer().eInverseRemove(this, SeqMMPackage.LIFE_LINE__MSG_EVENT, LifeLine.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeqMMPackage.MESSAGE_EVENT__TYPE:
				return getType();
			case SeqMMPackage.MESSAGE_EVENT__PREV:
				if (resolve) return getPrev();
				return basicGetPrev();
			case SeqMMPackage.MESSAGE_EVENT__NEXT:
				if (resolve) return getNext();
				return basicGetNext();
			case SeqMMPackage.MESSAGE_EVENT__MESSAGE:
				if (resolve) return getMessage();
				return basicGetMessage();
			case SeqMMPackage.MESSAGE_EVENT__LIFELINE:
				return getLifeline();
			case SeqMMPackage.MESSAGE_EVENT__STATE:
				if (resolve) return getState();
				return basicGetState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeqMMPackage.MESSAGE_EVENT__TYPE:
				setType((MessageEventType)newValue);
				return;
			case SeqMMPackage.MESSAGE_EVENT__PREV:
				setPrev((MessageEvent)newValue);
				return;
			case SeqMMPackage.MESSAGE_EVENT__NEXT:
				setNext((MessageEvent)newValue);
				return;
			case SeqMMPackage.MESSAGE_EVENT__MESSAGE:
				setMessage((Message)newValue);
				return;
			case SeqMMPackage.MESSAGE_EVENT__LIFELINE:
				setLifeline((LifeLine)newValue);
				return;
			case SeqMMPackage.MESSAGE_EVENT__STATE:
				setState((State)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeqMMPackage.MESSAGE_EVENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SeqMMPackage.MESSAGE_EVENT__PREV:
				setPrev((MessageEvent)null);
				return;
			case SeqMMPackage.MESSAGE_EVENT__NEXT:
				setNext((MessageEvent)null);
				return;
			case SeqMMPackage.MESSAGE_EVENT__MESSAGE:
				setMessage((Message)null);
				return;
			case SeqMMPackage.MESSAGE_EVENT__LIFELINE:
				setLifeline((LifeLine)null);
				return;
			case SeqMMPackage.MESSAGE_EVENT__STATE:
				setState((State)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeqMMPackage.MESSAGE_EVENT__TYPE:
				return type != TYPE_EDEFAULT;
			case SeqMMPackage.MESSAGE_EVENT__PREV:
				return prev != null;
			case SeqMMPackage.MESSAGE_EVENT__NEXT:
				return next != null;
			case SeqMMPackage.MESSAGE_EVENT__MESSAGE:
				return message != null;
			case SeqMMPackage.MESSAGE_EVENT__LIFELINE:
				return getLifeline() != null;
			case SeqMMPackage.MESSAGE_EVENT__STATE:
				return state != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //MessageEventImpl
