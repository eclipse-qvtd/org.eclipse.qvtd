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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Dummy;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.Message;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dummy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.DummyImpl#getContainsStateMachine <em>Contains State Machine</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.DummyImpl#getContainsMessage <em>Contains Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DummyImpl extends MinimalEObjectImpl.Container implements Dummy {
	/**
	 * The cached value of the '{@link #getContainsStateMachine() <em>Contains State Machine</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainsStateMachine()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine> containsStateMachine;

	/**
	 * The cached value of the '{@link #getContainsMessage() <em>Contains Message</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainsMessage()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> containsMessage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DummyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StmcMMPackage.Literals.DUMMY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine> getContainsStateMachine() {
		if (containsStateMachine == null) {
			containsStateMachine = new EObjectContainmentEList<StateMachine>(StateMachine.class, this, StmcMMPackage.DUMMY__CONTAINS_STATE_MACHINE);
		}
		return containsStateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getContainsMessage() {
		if (containsMessage == null) {
			containsMessage = new EObjectContainmentEList<Message>(Message.class, this, StmcMMPackage.DUMMY__CONTAINS_MESSAGE);
		}
		return containsMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StmcMMPackage.DUMMY__CONTAINS_STATE_MACHINE:
				return ((InternalEList<?>)getContainsStateMachine()).basicRemove(otherEnd, msgs);
			case StmcMMPackage.DUMMY__CONTAINS_MESSAGE:
				return ((InternalEList<?>)getContainsMessage()).basicRemove(otherEnd, msgs);
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
			case StmcMMPackage.DUMMY__CONTAINS_STATE_MACHINE:
				return getContainsStateMachine();
			case StmcMMPackage.DUMMY__CONTAINS_MESSAGE:
				return getContainsMessage();
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
			case StmcMMPackage.DUMMY__CONTAINS_STATE_MACHINE:
				getContainsStateMachine().clear();
				getContainsStateMachine().addAll((Collection<? extends StateMachine>)newValue);
				return;
			case StmcMMPackage.DUMMY__CONTAINS_MESSAGE:
				getContainsMessage().clear();
				getContainsMessage().addAll((Collection<? extends Message>)newValue);
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
			case StmcMMPackage.DUMMY__CONTAINS_STATE_MACHINE:
				getContainsStateMachine().clear();
				return;
			case StmcMMPackage.DUMMY__CONTAINS_MESSAGE:
				getContainsMessage().clear();
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
			case StmcMMPackage.DUMMY__CONTAINS_STATE_MACHINE:
				return containsStateMachine != null && !containsStateMachine.isEmpty();
			case StmcMMPackage.DUMMY__CONTAINS_MESSAGE:
				return containsMessage != null && !containsMessage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DummyImpl
