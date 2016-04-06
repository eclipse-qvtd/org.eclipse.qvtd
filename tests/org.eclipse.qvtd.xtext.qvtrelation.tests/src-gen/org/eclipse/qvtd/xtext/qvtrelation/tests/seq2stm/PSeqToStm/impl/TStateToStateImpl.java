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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StateMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TState To State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#getSn <em>Sn</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#getSt1 <em>St1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#getSet <em>Set</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#getL <em>L</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#getI <em>I</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#get_4 <em>4</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#getSt2 <em>St2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.TStateToStateImpl#getS <em>S</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TStateToStateImpl extends MinimalEObjectImpl.Container implements TStateToState {
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
	 * The cached value of the '{@link #getSt1() <em>St1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSt1()
	 * @generated
	 * @ordered
	 */
	protected State st1;

	/**
	 * The cached value of the '{@link #getSet() <em>Set</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSet()
	 * @generated
	 * @ordered
	 */
	protected EList<LifeLine> set;

	/**
	 * The cached value of the '{@link #getL() <em>L</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL()
	 * @generated
	 * @ordered
	 */
	protected LifeLine l;

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
	 * The cached value of the '{@link #get_4() <em>4</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_4()
	 * @generated
	 * @ordered
	 */
	protected EList<LifeLine> _4;

	/**
	 * The cached value of the '{@link #getSt2() <em>St2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSt2()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State st2;

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
	protected TStateToStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PSeqToStmPackage.Literals.TSTATE_TO_STATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TSTATE_TO_STATE__SN, oldSn, sn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSt1() {
		if (st1 != null && st1.eIsProxy()) {
			InternalEObject oldSt1 = (InternalEObject)st1;
			st1 = (State)eResolveProxy(oldSt1);
			if (st1 != oldSt1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PSeqToStmPackage.TSTATE_TO_STATE__ST1, oldSt1, st1));
			}
		}
		return st1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSt1() {
		return st1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSt1(State newSt1) {
		State oldSt1 = st1;
		st1 = newSt1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TSTATE_TO_STATE__ST1, oldSt1, st1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LifeLine> getSet() {
		if (set == null) {
			set = new EObjectResolvingEList<LifeLine>(LifeLine.class, this, PSeqToStmPackage.TSTATE_TO_STATE__SET);
		}
		return set;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeLine getL() {
		if (l != null && l.eIsProxy()) {
			InternalEObject oldL = (InternalEObject)l;
			l = (LifeLine)eResolveProxy(oldL);
			if (l != oldL) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PSeqToStmPackage.TSTATE_TO_STATE__L, oldL, l));
			}
		}
		return l;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeLine basicGetL() {
		return l;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL(LifeLine newL) {
		LifeLine oldL = l;
		l = newL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TSTATE_TO_STATE__L, oldL, l));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PSeqToStmPackage.TSTATE_TO_STATE__I, oldI, i));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TSTATE_TO_STATE__I, oldI, i));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LifeLine> get_4() {
		if (_4 == null) {
			_4 = new EObjectResolvingEList<LifeLine>(LifeLine.class, this, PSeqToStmPackage.TSTATE_TO_STATE__4);
		}
		return _4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State getSt2() {
		if (st2 != null && st2.eIsProxy()) {
			InternalEObject oldSt2 = (InternalEObject)st2;
			st2 = (org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State)eResolveProxy(oldSt2);
			if (st2 != oldSt2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PSeqToStmPackage.TSTATE_TO_STATE__ST2, oldSt2, st2));
			}
		}
		return st2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State basicGetSt2() {
		return st2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSt2(org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State newSt2) {
		org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State oldSt2 = st2;
		st2 = newSt2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TSTATE_TO_STATE__ST2, oldSt2, st2));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PSeqToStmPackage.TSTATE_TO_STATE__S, oldS, s));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PSeqToStmPackage.TSTATE_TO_STATE__S, oldS, s));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PSeqToStmPackage.TSTATE_TO_STATE__SN:
				return getSn();
			case PSeqToStmPackage.TSTATE_TO_STATE__ST1:
				if (resolve) return getSt1();
				return basicGetSt1();
			case PSeqToStmPackage.TSTATE_TO_STATE__SET:
				return getSet();
			case PSeqToStmPackage.TSTATE_TO_STATE__L:
				if (resolve) return getL();
				return basicGetL();
			case PSeqToStmPackage.TSTATE_TO_STATE__I:
				if (resolve) return getI();
				return basicGetI();
			case PSeqToStmPackage.TSTATE_TO_STATE__4:
				return get_4();
			case PSeqToStmPackage.TSTATE_TO_STATE__ST2:
				if (resolve) return getSt2();
				return basicGetSt2();
			case PSeqToStmPackage.TSTATE_TO_STATE__S:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PSeqToStmPackage.TSTATE_TO_STATE__SN:
				setSn((String)newValue);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__ST1:
				setSt1((State)newValue);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__SET:
				getSet().clear();
				getSet().addAll((Collection<? extends LifeLine>)newValue);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__L:
				setL((LifeLine)newValue);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__I:
				setI((Interaction)newValue);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__4:
				get_4().clear();
				get_4().addAll((Collection<? extends LifeLine>)newValue);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__ST2:
				setSt2((org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State)newValue);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__S:
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
			case PSeqToStmPackage.TSTATE_TO_STATE__SN:
				setSn(SN_EDEFAULT);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__ST1:
				setSt1((State)null);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__SET:
				getSet().clear();
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__L:
				setL((LifeLine)null);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__I:
				setI((Interaction)null);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__4:
				get_4().clear();
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__ST2:
				setSt2((org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.State)null);
				return;
			case PSeqToStmPackage.TSTATE_TO_STATE__S:
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
			case PSeqToStmPackage.TSTATE_TO_STATE__SN:
				return SN_EDEFAULT == null ? sn != null : !SN_EDEFAULT.equals(sn);
			case PSeqToStmPackage.TSTATE_TO_STATE__ST1:
				return st1 != null;
			case PSeqToStmPackage.TSTATE_TO_STATE__SET:
				return set != null && !set.isEmpty();
			case PSeqToStmPackage.TSTATE_TO_STATE__L:
				return l != null;
			case PSeqToStmPackage.TSTATE_TO_STATE__I:
				return i != null;
			case PSeqToStmPackage.TSTATE_TO_STATE__4:
				return _4 != null && !_4.isEmpty();
			case PSeqToStmPackage.TSTATE_TO_STATE__ST2:
				return st2 != null;
			case PSeqToStmPackage.TSTATE_TO_STATE__S:
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

} //TStateToStateImpl
