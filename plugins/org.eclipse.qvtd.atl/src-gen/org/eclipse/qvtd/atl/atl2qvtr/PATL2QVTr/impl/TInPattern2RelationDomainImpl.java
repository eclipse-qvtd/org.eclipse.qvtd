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

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TIn Pattern2 Relation Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl#getAPattern <em>APattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl#getARule <em>ARule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl#getRDomain <em>RDomain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl#getRRule <em>RRule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl#getTmName <em>Tm Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl#getWhere_InPattern2RelationDomain_guard <em>Where In Pattern2 Relation Domain guard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TInPattern2RelationDomainImpl extends MinimalEObjectImpl.Container implements TInPattern2RelationDomain {
	/**
	 * The cached value of the '{@link #getAPattern() <em>APattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAPattern()
	 * @generated
	 * @ordered
	 */
	protected InPattern aPattern;

	/**
	 * The cached value of the '{@link #getARule() <em>ARule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getARule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule aRule;

	/**
	 * The cached value of the '{@link #getRDomain() <em>RDomain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain rDomain;

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
	 * The default value of the '{@link #getTmName() <em>Tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTmName()
	 * @generated
	 * @ordered
	 */
	protected static final String TM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTmName() <em>Tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTmName()
	 * @generated
	 * @ordered
	 */
	protected String tmName = TM_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWhere_InPattern2RelationDomain_guard() <em>Where In Pattern2 Relation Domain guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere_InPattern2RelationDomain_guard()
	 * @generated
	 * @ordered
	 */
	protected TInPattern2RelationDomain_guard where_InPattern2RelationDomain_guard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TInPattern2RelationDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.TIN_PATTERN2_RELATION_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern getAPattern() {
		if (aPattern != null && aPattern.eIsProxy()) {
			InternalEObject oldAPattern = (InternalEObject)aPattern;
			aPattern = (InPattern)eResolveProxy(oldAPattern);
			if (aPattern != oldAPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__APATTERN, oldAPattern, aPattern));
			}
		}
		return aPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern basicGetAPattern() {
		return aPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAPattern(InPattern newAPattern) {
		InPattern oldAPattern = aPattern;
		aPattern = newAPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__APATTERN, oldAPattern, aPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule getARule() {
		if (aRule != null && aRule.eIsProxy()) {
			InternalEObject oldARule = (InternalEObject)aRule;
			aRule = (MatchedRule)eResolveProxy(oldARule);
			if (aRule != oldARule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__ARULE, oldARule, aRule));
			}
		}
		return aRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetARule() {
		return aRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setARule(MatchedRule newARule) {
		MatchedRule oldARule = aRule;
		aRule = newARule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__ARULE, oldARule, aRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain getRDomain() {
		if (rDomain != null && rDomain.eIsProxy()) {
			InternalEObject oldRDomain = (InternalEObject)rDomain;
			rDomain = (RelationDomain)eResolveProxy(oldRDomain);
			if (rDomain != oldRDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN, oldRDomain, rDomain));
			}
		}
		return rDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetRDomain() {
		return rDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRDomain(RelationDomain newRDomain) {
		RelationDomain oldRDomain = rDomain;
		rDomain = newRDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN, oldRDomain, rDomain));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RRULE, oldRRule, rRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RRULE, oldRRule, rRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTmName() {
		return tmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTmName(String newTmName) {
		String oldTmName = tmName;
		tmName = newTmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__TM_NAME, oldTmName, tmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TInPattern2RelationDomain_guard getWhere_InPattern2RelationDomain_guard() {
		if (where_InPattern2RelationDomain_guard != null && where_InPattern2RelationDomain_guard.eIsProxy()) {
			InternalEObject oldWhere_InPattern2RelationDomain_guard = (InternalEObject)where_InPattern2RelationDomain_guard;
			where_InPattern2RelationDomain_guard = (TInPattern2RelationDomain_guard)eResolveProxy(oldWhere_InPattern2RelationDomain_guard);
			if (where_InPattern2RelationDomain_guard != oldWhere_InPattern2RelationDomain_guard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD, oldWhere_InPattern2RelationDomain_guard, where_InPattern2RelationDomain_guard));
			}
		}
		return where_InPattern2RelationDomain_guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TInPattern2RelationDomain_guard basicGetWhere_InPattern2RelationDomain_guard() {
		return where_InPattern2RelationDomain_guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere_InPattern2RelationDomain_guard(TInPattern2RelationDomain_guard newWhere_InPattern2RelationDomain_guard) {
		TInPattern2RelationDomain_guard oldWhere_InPattern2RelationDomain_guard = where_InPattern2RelationDomain_guard;
		where_InPattern2RelationDomain_guard = newWhere_InPattern2RelationDomain_guard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD, oldWhere_InPattern2RelationDomain_guard, where_InPattern2RelationDomain_guard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__APATTERN:
				if (resolve) return getAPattern();
				return basicGetAPattern();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__ARULE:
				if (resolve) return getARule();
				return basicGetARule();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN:
				if (resolve) return getRDomain();
				return basicGetRDomain();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RRULE:
				if (resolve) return getRRule();
				return basicGetRRule();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__TM_NAME:
				return getTmName();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD:
				if (resolve) return getWhere_InPattern2RelationDomain_guard();
				return basicGetWhere_InPattern2RelationDomain_guard();
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
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__APATTERN:
				setAPattern((InPattern)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__ARULE:
				setARule((MatchedRule)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN:
				setRDomain((RelationDomain)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RRULE:
				setRRule((Relation)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__TM_NAME:
				setTmName((String)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD:
				setWhere_InPattern2RelationDomain_guard((TInPattern2RelationDomain_guard)newValue);
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
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__APATTERN:
				setAPattern((InPattern)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__ARULE:
				setARule((MatchedRule)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN:
				setRDomain((RelationDomain)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RRULE:
				setRRule((Relation)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__TM_NAME:
				setTmName(TM_NAME_EDEFAULT);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD:
				setWhere_InPattern2RelationDomain_guard((TInPattern2RelationDomain_guard)null);
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
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__APATTERN:
				return aPattern != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__ARULE:
				return aRule != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN:
				return rDomain != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__RRULE:
				return rRule != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__TM_NAME:
				return TM_NAME_EDEFAULT == null ? tmName != null : !TM_NAME_EDEFAULT.equals(tmName);
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD:
				return where_InPattern2RelationDomain_guard != null;
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
		result.append(" (tmName: ");
		result.append(tmName);
		result.append(')');
		return result.toString();
	}

} //TInPattern2RelationDomainImpl
