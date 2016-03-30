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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.StateImpl#getMessageevent <em>Messageevent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.StateImpl#getLifeline <em>Lifeline</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State {
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
	 * The cached value of the '{@link #getMessageevent() <em>Messageevent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageevent()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageEvent> messageevent;

	/**
	 * The cached value of the '{@link #getLifeline() <em>Lifeline</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifeline()
	 * @generated
	 * @ordered
	 */
	protected EList<LifeLine> lifeline;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeqMMPackage.Literals.STATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SeqMMPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageEvent> getMessageevent() {
		if (messageevent == null) {
			messageevent = new EObjectWithInverseResolvingEList<MessageEvent>(MessageEvent.class, this, SeqMMPackage.STATE__MESSAGEEVENT, SeqMMPackage.MESSAGE_EVENT__STATE);
		}
		return messageevent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LifeLine> getLifeline() {
		if (lifeline == null) {
			lifeline = new EObjectWithInverseResolvingEList.ManyInverse<LifeLine>(LifeLine.class, this, SeqMMPackage.STATE__LIFELINE, SeqMMPackage.LIFE_LINE__STATE);
		}
		return lifeline;
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
			case SeqMMPackage.STATE__MESSAGEEVENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessageevent()).basicAdd(otherEnd, msgs);
			case SeqMMPackage.STATE__LIFELINE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLifeline()).basicAdd(otherEnd, msgs);
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
			case SeqMMPackage.STATE__MESSAGEEVENT:
				return ((InternalEList<?>)getMessageevent()).basicRemove(otherEnd, msgs);
			case SeqMMPackage.STATE__LIFELINE:
				return ((InternalEList<?>)getLifeline()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeqMMPackage.STATE__NAME:
				return getName();
			case SeqMMPackage.STATE__MESSAGEEVENT:
				return getMessageevent();
			case SeqMMPackage.STATE__LIFELINE:
				return getLifeline();
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
			case SeqMMPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case SeqMMPackage.STATE__MESSAGEEVENT:
				getMessageevent().clear();
				getMessageevent().addAll((Collection<? extends MessageEvent>)newValue);
				return;
			case SeqMMPackage.STATE__LIFELINE:
				getLifeline().clear();
				getLifeline().addAll((Collection<? extends LifeLine>)newValue);
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
			case SeqMMPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SeqMMPackage.STATE__MESSAGEEVENT:
				getMessageevent().clear();
				return;
			case SeqMMPackage.STATE__LIFELINE:
				getLifeline().clear();
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
			case SeqMMPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SeqMMPackage.STATE__MESSAGEEVENT:
				return messageevent != null && !messageevent.isEmpty();
			case SeqMMPackage.STATE__LIFELINE:
				return lifeline != null && !lifeline.isEmpty();
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

} //StateImpl
