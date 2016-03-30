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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Life Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl#getMsgEvent <em>Msg Event</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.LifeLineImpl#getInteraction <em>Interaction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifeLineImpl extends MinimalEObjectImpl.Container implements LifeLine {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMsgEvent() <em>Msg Event</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsgEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageEvent> msgEvent;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected EList<State> state;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifeLineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeqMMPackage.Literals.LIFE_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.LIFE_LINE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageEvent> getMsgEvent() {
		if (msgEvent == null) {
			msgEvent = new EObjectContainmentWithInverseEList<MessageEvent>(MessageEvent.class, this, SeqMMPackage.LIFE_LINE__MSG_EVENT, SeqMMPackage.MESSAGE_EVENT__LIFELINE);
		}
		return msgEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getState() {
		if (state == null) {
			state = new EObjectWithInverseResolvingEList.ManyInverse<State>(State.class, this, SeqMMPackage.LIFE_LINE__STATE, SeqMMPackage.STATE__LIFELINE);
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getInteraction() {
		if (eContainerFeatureID() != SeqMMPackage.LIFE_LINE__INTERACTION) return null;
		return (Interaction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteraction(Interaction newInteraction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInteraction, SeqMMPackage.LIFE_LINE__INTERACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteraction(Interaction newInteraction) {
		if (newInteraction != eInternalContainer() || (eContainerFeatureID() != SeqMMPackage.LIFE_LINE__INTERACTION && newInteraction != null)) {
			if (EcoreUtil.isAncestor(this, newInteraction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInteraction != null)
				msgs = ((InternalEObject)newInteraction).eInverseAdd(this, SeqMMPackage.INTERACTION__LIFELINE, Interaction.class, msgs);
			msgs = basicSetInteraction(newInteraction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.LIFE_LINE__INTERACTION, newInteraction, newInteraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeqMMPackage.LIFE_LINE__MSG_EVENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMsgEvent()).basicAdd(otherEnd, msgs);
			case SeqMMPackage.LIFE_LINE__STATE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getState()).basicAdd(otherEnd, msgs);
			case SeqMMPackage.LIFE_LINE__INTERACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInteraction((Interaction)otherEnd, msgs);
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
			case SeqMMPackage.LIFE_LINE__MSG_EVENT:
				return ((InternalEList<?>)getMsgEvent()).basicRemove(otherEnd, msgs);
			case SeqMMPackage.LIFE_LINE__STATE:
				return ((InternalEList<?>)getState()).basicRemove(otherEnd, msgs);
			case SeqMMPackage.LIFE_LINE__INTERACTION:
				return basicSetInteraction(null, msgs);
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
			case SeqMMPackage.LIFE_LINE__INTERACTION:
				return eInternalContainer().eInverseRemove(this, SeqMMPackage.INTERACTION__LIFELINE, Interaction.class, msgs);
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
			case SeqMMPackage.LIFE_LINE__NAME:
				return getName();
			case SeqMMPackage.LIFE_LINE__MSG_EVENT:
				return getMsgEvent();
			case SeqMMPackage.LIFE_LINE__STATE:
				return getState();
			case SeqMMPackage.LIFE_LINE__INTERACTION:
				return getInteraction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeqMMPackage.LIFE_LINE__NAME:
				setName((String)newValue);
				return;
			case SeqMMPackage.LIFE_LINE__MSG_EVENT:
				getMsgEvent().clear();
				getMsgEvent().addAll((Collection<? extends MessageEvent>)newValue);
				return;
			case SeqMMPackage.LIFE_LINE__STATE:
				getState().clear();
				getState().addAll((Collection<? extends State>)newValue);
				return;
			case SeqMMPackage.LIFE_LINE__INTERACTION:
				setInteraction((Interaction)newValue);
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
			case SeqMMPackage.LIFE_LINE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SeqMMPackage.LIFE_LINE__MSG_EVENT:
				getMsgEvent().clear();
				return;
			case SeqMMPackage.LIFE_LINE__STATE:
				getState().clear();
				return;
			case SeqMMPackage.LIFE_LINE__INTERACTION:
				setInteraction((Interaction)null);
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
			case SeqMMPackage.LIFE_LINE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SeqMMPackage.LIFE_LINE__MSG_EVENT:
				return msgEvent != null && !msgEvent.isEmpty();
			case SeqMMPackage.LIFE_LINE__STATE:
				return state != null && !state.isEmpty();
			case SeqMMPackage.LIFE_LINE__INTERACTION:
				return getInteraction() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LifeLineImpl
