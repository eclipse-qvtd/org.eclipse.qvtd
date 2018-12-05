/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT1atlChildRule <em>T1atl Child Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT1atlSuperRule <em>T1atl Super Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT2qvtrOverriddenRelation <em>T2qvtr Overridden Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getT2qvtrOverridesRelation <em>T2qvtr Overrides Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl#getWmapMatchedRule1 <em>Wmap Matched Rule1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapMatchedRule_superImpl extends ExecutionImpl implements TmapMatchedRule_super {
	/**
	 * The cached value of the '{@link #getT1atlChildRule() <em>T1atl Child Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlChildRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t1atlChildRule;

	/**
	 * The cached value of the '{@link #getT1atlSuperRule() <em>T1atl Super Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlSuperRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t1atlSuperRule;

	/**
	 * The cached value of the '{@link #getT2qvtrOverriddenRelation() <em>T2qvtr Overridden Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrOverriddenRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t2qvtrOverriddenRelation;

	/**
	 * The cached value of the '{@link #getT2qvtrOverridesRelation() <em>T2qvtr Overrides Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrOverridesRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t2qvtrOverridesRelation;

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
	public MatchedRule getT1atlChildRule() {
		if (t1atlChildRule != null && t1atlChildRule.eIsProxy()) {
			InternalEObject oldT1atlChildRule = (InternalEObject)t1atlChildRule;
			t1atlChildRule = (MatchedRule)eResolveProxy(oldT1atlChildRule);
			if (t1atlChildRule != oldT1atlChildRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE, oldT1atlChildRule, t1atlChildRule));
			}
		}
		return t1atlChildRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT1atlChildRule() {
		return t1atlChildRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlChildRule(MatchedRule newT1atlChildRule) {
		MatchedRule oldT1atlChildRule = t1atlChildRule;
		t1atlChildRule = newT1atlChildRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE, oldT1atlChildRule, t1atlChildRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT1atlSuperRule() {
		if (t1atlSuperRule != null && t1atlSuperRule.eIsProxy()) {
			InternalEObject oldT1atlSuperRule = (InternalEObject)t1atlSuperRule;
			t1atlSuperRule = (MatchedRule)eResolveProxy(oldT1atlSuperRule);
			if (t1atlSuperRule != oldT1atlSuperRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE, oldT1atlSuperRule, t1atlSuperRule));
			}
		}
		return t1atlSuperRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT1atlSuperRule() {
		return t1atlSuperRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlSuperRule(MatchedRule newT1atlSuperRule) {
		MatchedRule oldT1atlSuperRule = t1atlSuperRule;
		t1atlSuperRule = newT1atlSuperRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE, oldT1atlSuperRule, t1atlSuperRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT2qvtrOverriddenRelation() {
		if (t2qvtrOverriddenRelation != null && t2qvtrOverriddenRelation.eIsProxy()) {
			InternalEObject oldT2qvtrOverriddenRelation = (InternalEObject)t2qvtrOverriddenRelation;
			t2qvtrOverriddenRelation = (Relation)eResolveProxy(oldT2qvtrOverriddenRelation);
			if (t2qvtrOverriddenRelation != oldT2qvtrOverriddenRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION, oldT2qvtrOverriddenRelation, t2qvtrOverriddenRelation));
			}
		}
		return t2qvtrOverriddenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT2qvtrOverriddenRelation() {
		return t2qvtrOverriddenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrOverriddenRelation(Relation newT2qvtrOverriddenRelation) {
		Relation oldT2qvtrOverriddenRelation = t2qvtrOverriddenRelation;
		t2qvtrOverriddenRelation = newT2qvtrOverriddenRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION, oldT2qvtrOverriddenRelation, t2qvtrOverriddenRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT2qvtrOverridesRelation() {
		if (t2qvtrOverridesRelation != null && t2qvtrOverridesRelation.eIsProxy()) {
			InternalEObject oldT2qvtrOverridesRelation = (InternalEObject)t2qvtrOverridesRelation;
			t2qvtrOverridesRelation = (Relation)eResolveProxy(oldT2qvtrOverridesRelation);
			if (t2qvtrOverridesRelation != oldT2qvtrOverridesRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION, oldT2qvtrOverridesRelation, t2qvtrOverridesRelation));
			}
		}
		return t2qvtrOverridesRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT2qvtrOverridesRelation() {
		return t2qvtrOverridesRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrOverridesRelation(Relation newT2qvtrOverridesRelation) {
		Relation oldT2qvtrOverridesRelation = t2qvtrOverridesRelation;
		t2qvtrOverridesRelation = newT2qvtrOverridesRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION, oldT2qvtrOverridesRelation, t2qvtrOverridesRelation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE, oldWmapMatchedRule, wmapMatchedRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE, oldWmapMatchedRule, wmapMatchedRule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1, oldWmapMatchedRule1, wmapMatchedRule1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1, oldWmapMatchedRule1, wmapMatchedRule1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE:
				if (resolve) return getT1atlChildRule();
				return basicGetT1atlChildRule();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE:
				if (resolve) return getT1atlSuperRule();
				return basicGetT1atlSuperRule();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION:
				if (resolve) return getT2qvtrOverriddenRelation();
				return basicGetT2qvtrOverriddenRelation();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION:
				if (resolve) return getT2qvtrOverridesRelation();
				return basicGetT2qvtrOverridesRelation();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE:
				if (resolve) return getWmapMatchedRule();
				return basicGetWmapMatchedRule();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1:
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
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE:
				setT1atlChildRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE:
				setT1atlSuperRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION:
				setT2qvtrOverriddenRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION:
				setT2qvtrOverridesRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE:
				setWmapMatchedRule((TmapMatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1:
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
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE:
				setT1atlChildRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE:
				setT1atlSuperRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION:
				setT2qvtrOverriddenRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION:
				setT2qvtrOverridesRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE:
				setWmapMatchedRule((TmapMatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1:
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
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE:
				return t1atlChildRule != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE:
				return t1atlSuperRule != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION:
				return t2qvtrOverriddenRelation != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION:
				return t2qvtrOverridesRelation != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE:
				return wmapMatchedRule != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1:
				return wmapMatchedRule1 != null;
		}
		return super.eIsSet(featureID);
	}

} //TmapMatchedRule_superImpl
