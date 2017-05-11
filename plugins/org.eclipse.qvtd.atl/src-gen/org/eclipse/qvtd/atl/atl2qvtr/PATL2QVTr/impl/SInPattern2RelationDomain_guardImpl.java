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

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SIn Pattern2 Relation Domain guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SInPattern2RelationDomain_guardImpl#getAPattern <em>APattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SInPattern2RelationDomain_guardImpl#getRRule <em>RRule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SInPattern2RelationDomain_guardImpl extends MinimalEObjectImpl.Container implements SInPattern2RelationDomain_guard {
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
	 * The cached value of the '{@link #getRRule() <em>RRule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRRule()
	 * @generated
	 * @ordered
	 */
	protected Relation rRule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SInPattern2RelationDomain_guardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.SIN_PATTERN2_RELATION_DOMAIN_GUARD;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN, oldAPattern, aPattern));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN, oldAPattern, aPattern));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE, oldRRule, rRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE, oldRRule, rRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				if (resolve) return getAPattern();
				return basicGetAPattern();
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				if (resolve) return getRRule();
				return basicGetRRule();
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
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				setAPattern((InPattern)newValue);
				return;
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				setRRule((Relation)newValue);
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
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				setAPattern((InPattern)null);
				return;
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				setRRule((Relation)null);
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
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				return aPattern != null;
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				return rRule != null;
		}
		return super.eIsSet(featureID);
	}

} //SInPattern2RelationDomain_guardImpl
