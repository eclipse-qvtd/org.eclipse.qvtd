/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verdict Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VerdictRegionImpl#getReferredRuleRegion <em>Referred Rule Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerdictRegionImpl extends RuleRegionImpl implements VerdictRegion {
	/**
	 * The number of structural features of the '<em>Verdict Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VERDICT_REGION_FEATURE_COUNT = RuleRegionImpl.RULE_REGION_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Verdict Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VERDICT_REGION_OPERATION_COUNT = RuleRegionImpl.RULE_REGION_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getReferredRuleRegion() <em>Referred Rule Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRuleRegion()
	 * @generated
	 * @ordered
	 */
	protected RuleRegion referredRuleRegion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VerdictRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.VERDICT_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RuleRegion getReferredRuleRegion() {
		if (referredRuleRegion != null && referredRuleRegion.eIsProxy()) {
			InternalEObject oldReferredRuleRegion = (InternalEObject)referredRuleRegion;
			referredRuleRegion = (RuleRegion)eResolveProxy(oldReferredRuleRegion);
			if (referredRuleRegion != oldReferredRuleRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuleRegionImpl.RULE_REGION_FEATURE_COUNT + 0, oldReferredRuleRegion, referredRuleRegion));
			}
		}
		return referredRuleRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleRegion basicGetReferredRuleRegion() {
		return referredRuleRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredRuleRegion(RuleRegion newReferredRuleRegion) {
		RuleRegion oldReferredRuleRegion = referredRuleRegion;
		referredRuleRegion = newReferredRuleRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleRegionImpl.RULE_REGION_FEATURE_COUNT + 0, oldReferredRuleRegion, referredRuleRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuleRegionImpl.RULE_REGION_FEATURE_COUNT + 0:
				if (resolve) return getReferredRuleRegion();
				return basicGetReferredRuleRegion();
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
			case RuleRegionImpl.RULE_REGION_FEATURE_COUNT + 0:
				setReferredRuleRegion((RuleRegion)newValue);
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
			case RuleRegionImpl.RULE_REGION_FEATURE_COUNT + 0:
				setReferredRuleRegion((RuleRegion)null);
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
			case RuleRegionImpl.RULE_REGION_FEATURE_COUNT + 0:
				return referredRuleRegion != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitVerdictRegion(this);
	}

} //VerdictRegionImpl
