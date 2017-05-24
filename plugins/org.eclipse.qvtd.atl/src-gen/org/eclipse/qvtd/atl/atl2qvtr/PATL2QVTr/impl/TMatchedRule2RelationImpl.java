/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.Module;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TMatched Rule2 Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl#get_success <em>success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl#getAModule <em>AModule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl#getMatchedRule <em>Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl#getRRule <em>RRule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl#getRelTx <em>Rel Tx</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl#getRuleName <em>Rule Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TMatchedRule2RelationImpl extends MinimalEObjectImpl.Container implements TMatchedRule2Relation {
	/**
	 * The default value of the '{@link #get_success() <em>success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_success()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean _SUCCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #get_success() <em>success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_success()
	 * @generated
	 * @ordered
	 */
	protected Boolean _success = _SUCCESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAModule() <em>AModule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAModule()
	 * @generated
	 * @ordered
	 */
	protected Module aModule;

	/**
	 * The cached value of the '{@link #getMatchedRule() <em>Matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchedRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule matchedRule;

	/**
	 * The cached value of the '{@link #getRRule() <em>RRule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRRule()
	 * @generated
	 * @ordered
	 */
	protected Relation rRule;

	/**
	 * The cached value of the '{@link #getRelTx() <em>Rel Tx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelTx()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation relTx;

	/**
	 * The default value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected String ruleName = RULE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TMatchedRule2RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.TMATCHED_RULE2_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean get_success() {
		return _success;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_success(Boolean new_success) {
		Boolean old_success = _success;
		_success = new_success;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__SUCCESS, old_success, _success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getAModule() {
		if (aModule != null && aModule.eIsProxy()) {
			InternalEObject oldAModule = (InternalEObject)aModule;
			aModule = (Module)eResolveProxy(oldAModule);
			if (aModule != oldAModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__AMODULE, oldAModule, aModule));
			}
		}
		return aModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module basicGetAModule() {
		return aModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAModule(Module newAModule) {
		Module oldAModule = aModule;
		aModule = newAModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__AMODULE, oldAModule, aModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule getMatchedRule() {
		if (matchedRule != null && matchedRule.eIsProxy()) {
			InternalEObject oldMatchedRule = (InternalEObject)matchedRule;
			matchedRule = (MatchedRule)eResolveProxy(oldMatchedRule);
			if (matchedRule != oldMatchedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__MATCHED_RULE, oldMatchedRule, matchedRule));
			}
		}
		return matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetMatchedRule() {
		return matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatchedRule(MatchedRule newMatchedRule) {
		MatchedRule oldMatchedRule = matchedRule;
		matchedRule = newMatchedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__MATCHED_RULE, oldMatchedRule, matchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getRRule() {
		if (rRule != null && rRule.eIsProxy()) {
			InternalEObject oldRRule = (InternalEObject)rRule;
			rRule = (Relation)eResolveProxy(oldRRule);
			if (rRule != oldRRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RRULE, oldRRule, rRule));
			}
		}
		return rRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetRRule() {
		return rRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRRule(Relation newRRule) {
		Relation oldRRule = rRule;
		rRule = newRRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RRULE, oldRRule, rRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation getRelTx() {
		if (relTx != null && relTx.eIsProxy()) {
			InternalEObject oldRelTx = (InternalEObject)relTx;
			relTx = (RelationalTransformation)eResolveProxy(oldRelTx);
			if (relTx != oldRelTx) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__REL_TX, oldRelTx, relTx));
			}
		}
		return relTx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetRelTx() {
		return relTx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelTx(RelationalTransformation newRelTx) {
		RelationalTransformation oldRelTx = relTx;
		relTx = newRelTx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__REL_TX, oldRelTx, relTx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleName(String newRuleName) {
		String oldRuleName = ruleName;
		ruleName = newRuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RULE_NAME, oldRuleName, ruleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__SUCCESS:
				return get_success();
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__AMODULE:
				if (resolve) return getAModule();
				return basicGetAModule();
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__MATCHED_RULE:
				if (resolve) return getMatchedRule();
				return basicGetMatchedRule();
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RRULE:
				if (resolve) return getRRule();
				return basicGetRRule();
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__REL_TX:
				if (resolve) return getRelTx();
				return basicGetRelTx();
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RULE_NAME:
				return getRuleName();
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
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__SUCCESS:
				set_success((Boolean)newValue);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__AMODULE:
				setAModule((Module)newValue);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__MATCHED_RULE:
				setMatchedRule((MatchedRule)newValue);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RRULE:
				setRRule((Relation)newValue);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__REL_TX:
				setRelTx((RelationalTransformation)newValue);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RULE_NAME:
				setRuleName((String)newValue);
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
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__SUCCESS:
				set_success(_SUCCESS_EDEFAULT);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__AMODULE:
				setAModule((Module)null);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__MATCHED_RULE:
				setMatchedRule((MatchedRule)null);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RRULE:
				setRRule((Relation)null);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__REL_TX:
				setRelTx((RelationalTransformation)null);
				return;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RULE_NAME:
				setRuleName(RULE_NAME_EDEFAULT);
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
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__SUCCESS:
				return _SUCCESS_EDEFAULT == null ? _success != null : !_SUCCESS_EDEFAULT.equals(_success);
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__AMODULE:
				return aModule != null;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__MATCHED_RULE:
				return matchedRule != null;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RRULE:
				return rRule != null;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__REL_TX:
				return relTx != null;
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION__RULE_NAME:
				return RULE_NAME_EDEFAULT == null ? ruleName != null : !RULE_NAME_EDEFAULT.equals(ruleName);
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
		result.append(" (_success: ");
		result.append(_success);
		result.append(", ruleName: ");
		result.append(ruleName);
		result.append(')');
		return result.toString();
	}

} //TMatchedRule2RelationImpl
