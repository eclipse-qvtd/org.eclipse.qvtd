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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Action;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Event;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl#getToState <em>To State</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl#getFromState <em>From State</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.TransitionImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
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
	 * The default value of the '{@link #getGuard() <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected static final String GUARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected String guard = GUARD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getToState() <em>To State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToState()
	 * @generated
	 * @ordered
	 */
	protected State toState;

	/**
	 * The cached value of the '{@link #getFromState() <em>From State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromState()
	 * @generated
	 * @ordered
	 */
	protected State fromState;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected Event trigger;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StmcMMPackage.Literals.TRANSITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(String newGuard) {
		String oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__GUARD, oldGuard, guard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getOwner() {
		if (eContainerFeatureID() != StmcMMPackage.TRANSITION__OWNER) return null;
		return (StateMachine)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(StateMachine newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, StmcMMPackage.TRANSITION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(StateMachine newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != StmcMMPackage.TRANSITION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, StmcMMPackage.STATE_MACHINE__TRANSITION, StateMachine.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getToState() {
		if (toState != null && toState.eIsProxy()) {
			InternalEObject oldToState = (InternalEObject)toState;
			toState = (State)eResolveProxy(oldToState);
			if (toState != oldToState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StmcMMPackage.TRANSITION__TO_STATE, oldToState, toState));
			}
		}
		return toState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetToState() {
		return toState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToState(State newToState, NotificationChain msgs) {
		State oldToState = toState;
		toState = newToState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__TO_STATE, oldToState, newToState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToState(State newToState) {
		if (newToState != toState) {
			NotificationChain msgs = null;
			if (toState != null)
				msgs = ((InternalEObject)toState).eInverseRemove(this, StmcMMPackage.STATE__IN_TRANSITION, State.class, msgs);
			if (newToState != null)
				msgs = ((InternalEObject)newToState).eInverseAdd(this, StmcMMPackage.STATE__IN_TRANSITION, State.class, msgs);
			msgs = basicSetToState(newToState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__TO_STATE, newToState, newToState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getFromState() {
		if (fromState != null && fromState.eIsProxy()) {
			InternalEObject oldFromState = (InternalEObject)fromState;
			fromState = (State)eResolveProxy(oldFromState);
			if (fromState != oldFromState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StmcMMPackage.TRANSITION__FROM_STATE, oldFromState, fromState));
			}
		}
		return fromState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetFromState() {
		return fromState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromState(State newFromState, NotificationChain msgs) {
		State oldFromState = fromState;
		fromState = newFromState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__FROM_STATE, oldFromState, newFromState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromState(State newFromState) {
		if (newFromState != fromState) {
			NotificationChain msgs = null;
			if (fromState != null)
				msgs = ((InternalEObject)fromState).eInverseRemove(this, StmcMMPackage.STATE__OUT_TRANSITION, State.class, msgs);
			if (newFromState != null)
				msgs = ((InternalEObject)newFromState).eInverseAdd(this, StmcMMPackage.STATE__OUT_TRANSITION, State.class, msgs);
			msgs = basicSetFromState(newFromState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__FROM_STATE, newFromState, newFromState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrigger(Event newTrigger, NotificationChain msgs) {
		Event oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__TRIGGER, oldTrigger, newTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(Event newTrigger) {
		if (newTrigger != trigger) {
			NotificationChain msgs = null;
			if (trigger != null)
				msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StmcMMPackage.TRANSITION__TRIGGER, null, msgs);
			if (newTrigger != null)
				msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StmcMMPackage.TRANSITION__TRIGGER, null, msgs);
			msgs = basicSetTrigger(newTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__TRIGGER, newTrigger, newTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAction(Action newAction, NotificationChain msgs) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__ACTION, oldAction, newAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		if (newAction != action) {
			NotificationChain msgs = null;
			if (action != null)
				msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StmcMMPackage.TRANSITION__ACTION, null, msgs);
			if (newAction != null)
				msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StmcMMPackage.TRANSITION__ACTION, null, msgs);
			msgs = basicSetAction(newAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StmcMMPackage.TRANSITION__ACTION, newAction, newAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StmcMMPackage.TRANSITION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((StateMachine)otherEnd, msgs);
			case StmcMMPackage.TRANSITION__TO_STATE:
				if (toState != null)
					msgs = ((InternalEObject)toState).eInverseRemove(this, StmcMMPackage.STATE__IN_TRANSITION, State.class, msgs);
				return basicSetToState((State)otherEnd, msgs);
			case StmcMMPackage.TRANSITION__FROM_STATE:
				if (fromState != null)
					msgs = ((InternalEObject)fromState).eInverseRemove(this, StmcMMPackage.STATE__OUT_TRANSITION, State.class, msgs);
				return basicSetFromState((State)otherEnd, msgs);
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
			case StmcMMPackage.TRANSITION__OWNER:
				return basicSetOwner(null, msgs);
			case StmcMMPackage.TRANSITION__TO_STATE:
				return basicSetToState(null, msgs);
			case StmcMMPackage.TRANSITION__FROM_STATE:
				return basicSetFromState(null, msgs);
			case StmcMMPackage.TRANSITION__TRIGGER:
				return basicSetTrigger(null, msgs);
			case StmcMMPackage.TRANSITION__ACTION:
				return basicSetAction(null, msgs);
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
			case StmcMMPackage.TRANSITION__OWNER:
				return eInternalContainer().eInverseRemove(this, StmcMMPackage.STATE_MACHINE__TRANSITION, StateMachine.class, msgs);
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
			case StmcMMPackage.TRANSITION__NAME:
				return getName();
			case StmcMMPackage.TRANSITION__GUARD:
				return getGuard();
			case StmcMMPackage.TRANSITION__OWNER:
				return getOwner();
			case StmcMMPackage.TRANSITION__TO_STATE:
				if (resolve) return getToState();
				return basicGetToState();
			case StmcMMPackage.TRANSITION__FROM_STATE:
				if (resolve) return getFromState();
				return basicGetFromState();
			case StmcMMPackage.TRANSITION__TRIGGER:
				return getTrigger();
			case StmcMMPackage.TRANSITION__ACTION:
				return getAction();
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
			case StmcMMPackage.TRANSITION__NAME:
				setName((String)newValue);
				return;
			case StmcMMPackage.TRANSITION__GUARD:
				setGuard((String)newValue);
				return;
			case StmcMMPackage.TRANSITION__OWNER:
				setOwner((StateMachine)newValue);
				return;
			case StmcMMPackage.TRANSITION__TO_STATE:
				setToState((State)newValue);
				return;
			case StmcMMPackage.TRANSITION__FROM_STATE:
				setFromState((State)newValue);
				return;
			case StmcMMPackage.TRANSITION__TRIGGER:
				setTrigger((Event)newValue);
				return;
			case StmcMMPackage.TRANSITION__ACTION:
				setAction((Action)newValue);
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
			case StmcMMPackage.TRANSITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StmcMMPackage.TRANSITION__GUARD:
				setGuard(GUARD_EDEFAULT);
				return;
			case StmcMMPackage.TRANSITION__OWNER:
				setOwner((StateMachine)null);
				return;
			case StmcMMPackage.TRANSITION__TO_STATE:
				setToState((State)null);
				return;
			case StmcMMPackage.TRANSITION__FROM_STATE:
				setFromState((State)null);
				return;
			case StmcMMPackage.TRANSITION__TRIGGER:
				setTrigger((Event)null);
				return;
			case StmcMMPackage.TRANSITION__ACTION:
				setAction((Action)null);
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
			case StmcMMPackage.TRANSITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StmcMMPackage.TRANSITION__GUARD:
				return GUARD_EDEFAULT == null ? guard != null : !GUARD_EDEFAULT.equals(guard);
			case StmcMMPackage.TRANSITION__OWNER:
				return getOwner() != null;
			case StmcMMPackage.TRANSITION__TO_STATE:
				return toState != null;
			case StmcMMPackage.TRANSITION__FROM_STATE:
				return fromState != null;
			case StmcMMPackage.TRANSITION__TRIGGER:
				return trigger != null;
			case StmcMMPackage.TRANSITION__ACTION:
				return action != null;
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
		result.append(", guard: ");
		result.append(guard);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
