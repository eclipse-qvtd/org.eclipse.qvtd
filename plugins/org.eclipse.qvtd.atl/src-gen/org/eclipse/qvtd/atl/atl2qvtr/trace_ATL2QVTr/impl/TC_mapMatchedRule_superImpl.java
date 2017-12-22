/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule_super;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Matched Rule super</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRule_superImpl#getAtl_atlChildRule <em>Atl atl Child Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRule_superImpl#getAtl_atlSuperRule <em>Atl atl Super Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRule_superImpl#getQvtr_qvtrOverriddenRelation <em>Qvtr qvtr Overridden Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRule_superImpl#getQvtr_qvtrOverridesRelation <em>Qvtr qvtr Overrides Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapMatchedRule_superImpl extends MinimalEObjectImpl.Container implements TC_mapMatchedRule_super {
	/**
	 * The cached value of the '{@link #getAtl_atlChildRule() <em>Atl atl Child Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlChildRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule atl_atlChildRule;

	/**
	 * The cached value of the '{@link #getAtl_atlSuperRule() <em>Atl atl Super Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlSuperRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule atl_atlSuperRule;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrOverriddenRelation() <em>Qvtr qvtr Overridden Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrOverriddenRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation qvtr_qvtrOverriddenRelation;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrOverridesRelation() <em>Qvtr qvtr Overrides Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrOverridesRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation qvtr_qvtrOverridesRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapMatchedRule_superImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_MATCHED_RULE_SUPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule getAtl_atlChildRule() {
		if (atl_atlChildRule != null && atl_atlChildRule.eIsProxy()) {
			InternalEObject oldAtl_atlChildRule = (InternalEObject)atl_atlChildRule;
			atl_atlChildRule = (MatchedRule)eResolveProxy(oldAtl_atlChildRule);
			if (atl_atlChildRule != oldAtl_atlChildRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_CHILD_RULE, oldAtl_atlChildRule, atl_atlChildRule));
			}
		}
		return atl_atlChildRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetAtl_atlChildRule() {
		return atl_atlChildRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlChildRule(MatchedRule newAtl_atlChildRule) {
		MatchedRule oldAtl_atlChildRule = atl_atlChildRule;
		atl_atlChildRule = newAtl_atlChildRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_CHILD_RULE, oldAtl_atlChildRule, atl_atlChildRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule getAtl_atlSuperRule() {
		if (atl_atlSuperRule != null && atl_atlSuperRule.eIsProxy()) {
			InternalEObject oldAtl_atlSuperRule = (InternalEObject)atl_atlSuperRule;
			atl_atlSuperRule = (MatchedRule)eResolveProxy(oldAtl_atlSuperRule);
			if (atl_atlSuperRule != oldAtl_atlSuperRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_SUPER_RULE, oldAtl_atlSuperRule, atl_atlSuperRule));
			}
		}
		return atl_atlSuperRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetAtl_atlSuperRule() {
		return atl_atlSuperRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlSuperRule(MatchedRule newAtl_atlSuperRule) {
		MatchedRule oldAtl_atlSuperRule = atl_atlSuperRule;
		atl_atlSuperRule = newAtl_atlSuperRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_SUPER_RULE, oldAtl_atlSuperRule, atl_atlSuperRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getQvtr_qvtrOverriddenRelation() {
		if (qvtr_qvtrOverriddenRelation != null && qvtr_qvtrOverriddenRelation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrOverriddenRelation = (InternalEObject)qvtr_qvtrOverriddenRelation;
			qvtr_qvtrOverriddenRelation = (Relation)eResolveProxy(oldQvtr_qvtrOverriddenRelation);
			if (qvtr_qvtrOverriddenRelation != oldQvtr_qvtrOverriddenRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDDEN_RELATION, oldQvtr_qvtrOverriddenRelation, qvtr_qvtrOverriddenRelation));
			}
		}
		return qvtr_qvtrOverriddenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetQvtr_qvtrOverriddenRelation() {
		return qvtr_qvtrOverriddenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrOverriddenRelation(Relation newQvtr_qvtrOverriddenRelation) {
		Relation oldQvtr_qvtrOverriddenRelation = qvtr_qvtrOverriddenRelation;
		qvtr_qvtrOverriddenRelation = newQvtr_qvtrOverriddenRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDDEN_RELATION, oldQvtr_qvtrOverriddenRelation, qvtr_qvtrOverriddenRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getQvtr_qvtrOverridesRelation() {
		if (qvtr_qvtrOverridesRelation != null && qvtr_qvtrOverridesRelation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrOverridesRelation = (InternalEObject)qvtr_qvtrOverridesRelation;
			qvtr_qvtrOverridesRelation = (Relation)eResolveProxy(oldQvtr_qvtrOverridesRelation);
			if (qvtr_qvtrOverridesRelation != oldQvtr_qvtrOverridesRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDES_RELATION, oldQvtr_qvtrOverridesRelation, qvtr_qvtrOverridesRelation));
			}
		}
		return qvtr_qvtrOverridesRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetQvtr_qvtrOverridesRelation() {
		return qvtr_qvtrOverridesRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrOverridesRelation(Relation newQvtr_qvtrOverridesRelation) {
		Relation oldQvtr_qvtrOverridesRelation = qvtr_qvtrOverridesRelation;
		qvtr_qvtrOverridesRelation = newQvtr_qvtrOverridesRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDES_RELATION, oldQvtr_qvtrOverridesRelation, qvtr_qvtrOverridesRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_CHILD_RULE:
				if (resolve) return getAtl_atlChildRule();
				return basicGetAtl_atlChildRule();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_SUPER_RULE:
				if (resolve) return getAtl_atlSuperRule();
				return basicGetAtl_atlSuperRule();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDDEN_RELATION:
				if (resolve) return getQvtr_qvtrOverriddenRelation();
				return basicGetQvtr_qvtrOverriddenRelation();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDES_RELATION:
				if (resolve) return getQvtr_qvtrOverridesRelation();
				return basicGetQvtr_qvtrOverridesRelation();
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
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_CHILD_RULE:
				setAtl_atlChildRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_SUPER_RULE:
				setAtl_atlSuperRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDDEN_RELATION:
				setQvtr_qvtrOverriddenRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDES_RELATION:
				setQvtr_qvtrOverridesRelation((Relation)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_CHILD_RULE:
				setAtl_atlChildRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_SUPER_RULE:
				setAtl_atlSuperRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDDEN_RELATION:
				setQvtr_qvtrOverriddenRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDES_RELATION:
				setQvtr_qvtrOverridesRelation((Relation)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_CHILD_RULE:
				return atl_atlChildRule != null;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_SUPER_RULE:
				return atl_atlSuperRule != null;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDDEN_RELATION:
				return qvtr_qvtrOverriddenRelation != null;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDES_RELATION:
				return qvtr_qvtrOverridesRelation != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapMatchedRule_superImpl
