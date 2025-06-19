/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Matched Rule super</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT3atlChildRule <em>T3atl Child Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT3atlSuperRule <em>T3atl Super Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT4qvtrOverriddenRelation <em>T4qvtr Overridden Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT4qvtrOverridesRelation <em>T4qvtr Overrides Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getWmapMatchedRule1 <em>Wmap Matched Rule1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapMatchedRule_superImpl extends ExecutionImpl implements TmapMatchedRule_super {
	/**
	 * The number of structural features of the '<em>Tmap Matched Rule super</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_MATCHED_RULE_SUPER_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Tmap Matched Rule super</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_MATCHED_RULE_SUPER_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0GLOBAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0global = S0GLOBAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT3atlChildRule() <em>T3atl Child Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlChildRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t3atlChildRule;

	/**
	 * The cached value of the '{@link #getT3atlSuperRule() <em>T3atl Super Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlSuperRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t3atlSuperRule;

	/**
	 * The cached value of the '{@link #getT4qvtrOverriddenRelation() <em>T4qvtr Overridden Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrOverriddenRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t4qvtrOverriddenRelation;

	/**
	 * The cached value of the '{@link #getT4qvtrOverridesRelation() <em>T4qvtr Overrides Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrOverridesRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t4qvtrOverridesRelation;

	/**
	 * The cached value of the '{@link #getWmapMatchedRule() <em>Wmap Matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapMatchedRule()
	 * @generated
	 * @ordered
	 */
	protected TmapMatchedRule wmapMatchedRule;

	/**
	 * The cached value of the '{@link #getWmapMatchedRule1() <em>Wmap Matched Rule1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapMatchedRule1()
	 * @generated
	 * @ordered
	 */
	protected TmapMatchedRule wmapMatchedRule1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapMatchedRule_superImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE_SUPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getS0global() {
		return s0global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0global(Boolean newS0global) {
		Boolean oldS0global = s0global;
		s0global = newS0global;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldS0global, s0global));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT3atlChildRule() {
		if (t3atlChildRule != null && t3atlChildRule.eIsProxy()) {
			InternalEObject oldT3atlChildRule = t3atlChildRule;
			t3atlChildRule = (MatchedRule)eResolveProxy(oldT3atlChildRule);
			if (t3atlChildRule != oldT3atlChildRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlChildRule, t3atlChildRule));
			}
		}
		return t3atlChildRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT3atlChildRule() {
		return t3atlChildRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlChildRule(MatchedRule newT3atlChildRule) {
		MatchedRule oldT3atlChildRule = t3atlChildRule;
		t3atlChildRule = newT3atlChildRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlChildRule, t3atlChildRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT3atlSuperRule() {
		if (t3atlSuperRule != null && t3atlSuperRule.eIsProxy()) {
			InternalEObject oldT3atlSuperRule = t3atlSuperRule;
			t3atlSuperRule = (MatchedRule)eResolveProxy(oldT3atlSuperRule);
			if (t3atlSuperRule != oldT3atlSuperRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlSuperRule, t3atlSuperRule));
			}
		}
		return t3atlSuperRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT3atlSuperRule() {
		return t3atlSuperRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlSuperRule(MatchedRule newT3atlSuperRule) {
		MatchedRule oldT3atlSuperRule = t3atlSuperRule;
		t3atlSuperRule = newT3atlSuperRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlSuperRule, t3atlSuperRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT4qvtrOverriddenRelation() {
		if (t4qvtrOverriddenRelation != null && t4qvtrOverriddenRelation.eIsProxy()) {
			InternalEObject oldT4qvtrOverriddenRelation = (InternalEObject)t4qvtrOverriddenRelation;
			t4qvtrOverriddenRelation = (Relation)eResolveProxy(oldT4qvtrOverriddenRelation);
			if (t4qvtrOverriddenRelation != oldT4qvtrOverriddenRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT4qvtrOverriddenRelation, t4qvtrOverriddenRelation));
			}
		}
		return t4qvtrOverriddenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT4qvtrOverriddenRelation() {
		return t4qvtrOverriddenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrOverriddenRelation(Relation newT4qvtrOverriddenRelation) {
		Relation oldT4qvtrOverriddenRelation = t4qvtrOverriddenRelation;
		t4qvtrOverriddenRelation = newT4qvtrOverriddenRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT4qvtrOverriddenRelation, t4qvtrOverriddenRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT4qvtrOverridesRelation() {
		if (t4qvtrOverridesRelation != null && t4qvtrOverridesRelation.eIsProxy()) {
			InternalEObject oldT4qvtrOverridesRelation = (InternalEObject)t4qvtrOverridesRelation;
			t4qvtrOverridesRelation = (Relation)eResolveProxy(oldT4qvtrOverridesRelation);
			if (t4qvtrOverridesRelation != oldT4qvtrOverridesRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrOverridesRelation, t4qvtrOverridesRelation));
			}
		}
		return t4qvtrOverridesRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT4qvtrOverridesRelation() {
		return t4qvtrOverridesRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrOverridesRelation(Relation newT4qvtrOverridesRelation) {
		Relation oldT4qvtrOverridesRelation = t4qvtrOverridesRelation;
		t4qvtrOverridesRelation = newT4qvtrOverridesRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrOverridesRelation, t4qvtrOverridesRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapMatchedRule getWmapMatchedRule() {
		if (wmapMatchedRule != null && wmapMatchedRule.eIsProxy()) {
			InternalEObject oldWmapMatchedRule = (InternalEObject)wmapMatchedRule;
			wmapMatchedRule = (TmapMatchedRule)eResolveProxy(oldWmapMatchedRule);
			if (wmapMatchedRule != oldWmapMatchedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldWmapMatchedRule, wmapMatchedRule));
			}
		}
		return wmapMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapMatchedRule basicGetWmapMatchedRule() {
		return wmapMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapMatchedRule(TmapMatchedRule newWmapMatchedRule) {
		TmapMatchedRule oldWmapMatchedRule = wmapMatchedRule;
		wmapMatchedRule = newWmapMatchedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldWmapMatchedRule, wmapMatchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapMatchedRule getWmapMatchedRule1() {
		if (wmapMatchedRule1 != null && wmapMatchedRule1.eIsProxy()) {
			InternalEObject oldWmapMatchedRule1 = (InternalEObject)wmapMatchedRule1;
			wmapMatchedRule1 = (TmapMatchedRule)eResolveProxy(oldWmapMatchedRule1);
			if (wmapMatchedRule1 != oldWmapMatchedRule1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldWmapMatchedRule1, wmapMatchedRule1));
			}
		}
		return wmapMatchedRule1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapMatchedRule basicGetWmapMatchedRule1() {
		return wmapMatchedRule1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapMatchedRule1(TmapMatchedRule newWmapMatchedRule1) {
		TmapMatchedRule oldWmapMatchedRule1 = wmapMatchedRule1;
		wmapMatchedRule1 = newWmapMatchedRule1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldWmapMatchedRule1, wmapMatchedRule1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return getS0global();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				if (resolve) return getT3atlChildRule();
				return basicGetT3atlChildRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlSuperRule();
				return basicGetT3atlSuperRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT4qvtrOverriddenRelation();
				return basicGetT4qvtrOverriddenRelation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT4qvtrOverridesRelation();
				return basicGetT4qvtrOverridesRelation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getWmapMatchedRule();
				return basicGetWmapMatchedRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getWmapMatchedRule1();
				return basicGetWmapMatchedRule1();
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setS0global((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT3atlChildRule((MatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlSuperRule((MatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT4qvtrOverriddenRelation((Relation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrOverridesRelation((Relation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setWmapMatchedRule((TmapMatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setWmapMatchedRule1((TmapMatchedRule)newValue);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setS0global(S0GLOBAL_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT3atlChildRule((MatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlSuperRule((MatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT4qvtrOverriddenRelation((Relation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrOverridesRelation((Relation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setWmapMatchedRule((TmapMatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setWmapMatchedRule1((TmapMatchedRule)null);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return t3atlChildRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlSuperRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t4qvtrOverriddenRelation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t4qvtrOverridesRelation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return wmapMatchedRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return wmapMatchedRule1 != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (s0global: ");
		result.append(s0global);
		result.append(')');
		return result.toString();
	}


} //TmapMatchedRule_superImpl
