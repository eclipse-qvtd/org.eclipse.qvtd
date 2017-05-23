/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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

import org.eclipse.m2m.atl.common.OCL.OperationCallExp;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TIn Pattern2 Relation Domain guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl#getAExpression <em>AExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl#getAPattern <em>APattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl#getRExpression <em>RExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl#getRRule <em>RRule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl#getW <em>W</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl#getWhen_OclExpression2OCLExpression <em>When Ocl Expression2 OCL Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TInPattern2RelationDomain_guardImpl extends MinimalEObjectImpl.Container implements TInPattern2RelationDomain_guard {
	/**
	 * The cached value of the '{@link #getAExpression() <em>AExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAExpression()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExp aExpression;

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
	 * The cached value of the '{@link #getP() <em>P</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getP()
	 * @generated
	 * @ordered
	 */
	protected Predicate p;

	/**
	 * The cached value of the '{@link #getRExpression() <em>RExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRExpression()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.OperationCallExp rExpression;

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
	 * The cached value of the '{@link #getW() <em>W</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW()
	 * @generated
	 * @ordered
	 */
	protected Pattern w;

	/**
	 * The cached value of the '{@link #getWhen_OclExpression2OCLExpression() <em>When Ocl Expression2 OCL Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen_OclExpression2OCLExpression()
	 * @generated
	 * @ordered
	 */
	protected SOclExpression2OCLExpression when_OclExpression2OCLExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TInPattern2RelationDomain_guardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.TIN_PATTERN2_RELATION_DOMAIN_GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp getAExpression() {
		if (aExpression != null && aExpression.eIsProxy()) {
			InternalEObject oldAExpression = (InternalEObject)aExpression;
			aExpression = (OperationCallExp)eResolveProxy(oldAExpression);
			if (aExpression != oldAExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION, oldAExpression, aExpression));
			}
		}
		return aExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp basicGetAExpression() {
		return aExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAExpression(OperationCallExp newAExpression) {
		OperationCallExp oldAExpression = aExpression;
		aExpression = newAExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION, oldAExpression, aExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN, oldAPattern, aPattern));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN, oldAPattern, aPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate getP() {
		if (p != null && p.eIsProxy()) {
			InternalEObject oldP = (InternalEObject)p;
			p = (Predicate)eResolveProxy(oldP);
			if (p != oldP) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__P, oldP, p));
			}
		}
		return p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetP() {
		return p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setP(Predicate newP) {
		Predicate oldP = p;
		p = newP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__P, oldP, p));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.OperationCallExp getRExpression() {
		if (rExpression != null && rExpression.eIsProxy()) {
			InternalEObject oldRExpression = (InternalEObject)rExpression;
			rExpression = (org.eclipse.ocl.pivot.OperationCallExp)eResolveProxy(oldRExpression);
			if (rExpression != oldRExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION, oldRExpression, rExpression));
			}
		}
		return rExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.OperationCallExp basicGetRExpression() {
		return rExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRExpression(org.eclipse.ocl.pivot.OperationCallExp newRExpression) {
		org.eclipse.ocl.pivot.OperationCallExp oldRExpression = rExpression;
		rExpression = newRExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION, oldRExpression, rExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE, oldRRule, rRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE, oldRRule, rRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getW() {
		if (w != null && w.eIsProxy()) {
			InternalEObject oldW = (InternalEObject)w;
			w = (Pattern)eResolveProxy(oldW);
			if (w != oldW) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__W, oldW, w));
			}
		}
		return w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern basicGetW() {
		return w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setW(Pattern newW) {
		Pattern oldW = w;
		w = newW;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__W, oldW, w));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SOclExpression2OCLExpression getWhen_OclExpression2OCLExpression() {
		if (when_OclExpression2OCLExpression != null && when_OclExpression2OCLExpression.eIsProxy()) {
			InternalEObject oldWhen_OclExpression2OCLExpression = (InternalEObject)when_OclExpression2OCLExpression;
			when_OclExpression2OCLExpression = (SOclExpression2OCLExpression)eResolveProxy(oldWhen_OclExpression2OCLExpression);
			if (when_OclExpression2OCLExpression != oldWhen_OclExpression2OCLExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION, oldWhen_OclExpression2OCLExpression, when_OclExpression2OCLExpression));
			}
		}
		return when_OclExpression2OCLExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SOclExpression2OCLExpression basicGetWhen_OclExpression2OCLExpression() {
		return when_OclExpression2OCLExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen_OclExpression2OCLExpression(SOclExpression2OCLExpression newWhen_OclExpression2OCLExpression) {
		SOclExpression2OCLExpression oldWhen_OclExpression2OCLExpression = when_OclExpression2OCLExpression;
		when_OclExpression2OCLExpression = newWhen_OclExpression2OCLExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION, oldWhen_OclExpression2OCLExpression, when_OclExpression2OCLExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION:
				if (resolve) return getAExpression();
				return basicGetAExpression();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				if (resolve) return getAPattern();
				return basicGetAPattern();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__P:
				if (resolve) return getP();
				return basicGetP();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION:
				if (resolve) return getRExpression();
				return basicGetRExpression();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				if (resolve) return getRRule();
				return basicGetRRule();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__W:
				if (resolve) return getW();
				return basicGetW();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION:
				if (resolve) return getWhen_OclExpression2OCLExpression();
				return basicGetWhen_OclExpression2OCLExpression();
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
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION:
				setAExpression((OperationCallExp)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				setAPattern((InPattern)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__P:
				setP((Predicate)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION:
				setRExpression((org.eclipse.ocl.pivot.OperationCallExp)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				setRRule((Relation)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__W:
				setW((Pattern)newValue);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION:
				setWhen_OclExpression2OCLExpression((SOclExpression2OCLExpression)newValue);
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
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION:
				setAExpression((OperationCallExp)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				setAPattern((InPattern)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__P:
				setP((Predicate)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION:
				setRExpression((org.eclipse.ocl.pivot.OperationCallExp)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				setRRule((Relation)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__W:
				setW((Pattern)null);
				return;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION:
				setWhen_OclExpression2OCLExpression((SOclExpression2OCLExpression)null);
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
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION:
				return aExpression != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN:
				return aPattern != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__P:
				return p != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION:
				return rExpression != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE:
				return rRule != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__W:
				return w != null;
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION:
				return when_OclExpression2OCLExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //TInPattern2RelationDomain_guardImpl
