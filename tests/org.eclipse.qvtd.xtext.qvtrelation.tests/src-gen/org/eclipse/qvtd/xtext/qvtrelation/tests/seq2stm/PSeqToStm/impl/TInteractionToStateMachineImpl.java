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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TInteraction To State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TInteractionToStateMachineImpl#getSn <em>Sn</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TInteractionToStateMachineImpl#getI <em>I</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TInteractionToStateMachineImpl#getS <em>S</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TInteractionToStateMachineImpl extends MinimalEObjectImpl.Container implements TInteractionToStateMachine {
	/**
	 * The default value of the '{@link #getSn() <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSn()
	 * @generated
	 * @ordered
	 */
	protected static final String SN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSn() <em>Sn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSn()
	 * @generated
	 * @ordered
	 */
	protected String sn = SN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getI() <em>I</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getI()
	 * @generated
	 * @ordered
	 */
	protected Interaction i;

	/**
	 * The cached value of the '{@link #getS() <em>S</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS()
	 * @generated
	 * @ordered
	 */
	protected StateMachine s;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TInteractionToStateMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSeqToStmPackage.Literals.TINTERACTION_TO_STATE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSn(String newSn) {
		String oldSn = sn;
		sn = newSn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__SN, oldSn, sn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getI() {
		if (i != null && i.eIsProxy()) {
			InternalEObject oldI = (InternalEObject)i;
			i = (Interaction)eResolveProxy(oldI);
			if (i != oldI) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__I, oldI, i));
			}
		}
		return i;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction basicGetI() {
		return i;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setI(Interaction newI) {
		Interaction oldI = i;
		i = newI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__I, oldI, i));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getS() {
		if (s != null && s.eIsProxy()) {
			InternalEObject oldS = (InternalEObject)s;
			s = (StateMachine)eResolveProxy(oldS);
			if (s != oldS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__S, oldS, s));
			}
		}
		return s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine basicGetS() {
		return s;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setS(StateMachine newS) {
		StateMachine oldS = s;
		s = newS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__S, oldS, s));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__SN:
				return getSn();
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__I:
				if (resolve) return getI();
				return basicGetI();
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__S:
				if (resolve) return getS();
				return basicGetS();
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
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__SN:
				setSn((String)newValue);
				return;
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__I:
				setI((Interaction)newValue);
				return;
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__S:
				setS((StateMachine)newValue);
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
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__SN:
				setSn(SN_EDEFAULT);
				return;
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__I:
				setI((Interaction)null);
				return;
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__S:
				setS((StateMachine)null);
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
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__SN:
				return SN_EDEFAULT == null ? sn != null : !SN_EDEFAULT.equals(sn);
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__I:
				return i != null;
			case PSeqToStmPackage.TINTERACTION_TO_STATE_MACHINE__S:
				return s != null;
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
		result.append(" (sn: ");
		result.append(sn);
		result.append(')');
		return result.toString();
	}

} //TInteractionToStateMachineImpl
