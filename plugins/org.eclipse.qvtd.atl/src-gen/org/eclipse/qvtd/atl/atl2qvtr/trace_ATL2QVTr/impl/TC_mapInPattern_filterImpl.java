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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern_filter;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map In Pattern filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getAtl_atlExpression <em>Atl atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getAtl_atlPattern <em>Atl atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getAtl_atlRule <em>Atl atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getQvtr_p <em>Qvtr p</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getQvtr_qvtrDomain <em>Qvtr qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPattern_filterImpl#getQvtr_w <em>Qvtr w</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapInPattern_filterImpl extends MinimalEObjectImpl.Container implements TC_mapInPattern_filter {
	/**
	 * The cached value of the '{@link #getAtl_atlExpression() <em>Atl atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlExpression;

	/**
	 * The cached value of the '{@link #getAtl_atlPattern() <em>Atl atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlPattern()
	 * @generated
	 * @ordered
	 */
	protected InPattern atl_atlPattern;

	/**
	 * The cached value of the '{@link #getAtl_atlRule() <em>Atl atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule atl_atlRule;

	/**
	 * The cached value of the '{@link #getQvtr_p() <em>Qvtr p</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_p()
	 * @generated
	 * @ordered
	 */
	protected Predicate qvtr_p;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrDomain() <em>Qvtr qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain qvtr_qvtrDomain;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrExpression() <em>Qvtr qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrExpression;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrRelation() <em>Qvtr qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation qvtr_qvtrRelation;

	/**
	 * The cached value of the '{@link #getQvtr_w() <em>Qvtr w</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_w()
	 * @generated
	 * @ordered
	 */
	protected Pattern qvtr_w;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapInPattern_filterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_IN_PATTERN_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getAtl_atlExpression() {
		if (atl_atlExpression != null && atl_atlExpression.eIsProxy()) {
			InternalEObject oldAtl_atlExpression = atl_atlExpression;
			atl_atlExpression = (OclExpression)eResolveProxy(oldAtl_atlExpression);
			if (atl_atlExpression != oldAtl_atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
			}
		}
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlExpression() {
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlExpression(OclExpression newAtl_atlExpression) {
		OclExpression oldAtl_atlExpression = atl_atlExpression;
		atl_atlExpression = newAtl_atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InPattern getAtl_atlPattern() {
		if (atl_atlPattern != null && atl_atlPattern.eIsProxy()) {
			InternalEObject oldAtl_atlPattern = atl_atlPattern;
			atl_atlPattern = (InPattern)eResolveProxy(oldAtl_atlPattern);
			if (atl_atlPattern != oldAtl_atlPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_PATTERN, oldAtl_atlPattern, atl_atlPattern));
			}
		}
		return atl_atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern basicGetAtl_atlPattern() {
		return atl_atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlPattern(InPattern newAtl_atlPattern) {
		InPattern oldAtl_atlPattern = atl_atlPattern;
		atl_atlPattern = newAtl_atlPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_PATTERN, oldAtl_atlPattern, atl_atlPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getAtl_atlRule() {
		if (atl_atlRule != null && atl_atlRule.eIsProxy()) {
			InternalEObject oldAtl_atlRule = atl_atlRule;
			atl_atlRule = (MatchedRule)eResolveProxy(oldAtl_atlRule);
			if (atl_atlRule != oldAtl_atlRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_RULE, oldAtl_atlRule, atl_atlRule));
			}
		}
		return atl_atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetAtl_atlRule() {
		return atl_atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlRule(MatchedRule newAtl_atlRule) {
		MatchedRule oldAtl_atlRule = atl_atlRule;
		atl_atlRule = newAtl_atlRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_RULE, oldAtl_atlRule, atl_atlRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Predicate getQvtr_p() {
		if (qvtr_p != null && qvtr_p.eIsProxy()) {
			InternalEObject oldQvtr_p = (InternalEObject)qvtr_p;
			qvtr_p = (Predicate)eResolveProxy(oldQvtr_p);
			if (qvtr_p != oldQvtr_p) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_P, oldQvtr_p, qvtr_p));
			}
		}
		return qvtr_p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetQvtr_p() {
		return qvtr_p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_p(Predicate newQvtr_p) {
		Predicate oldQvtr_p = qvtr_p;
		qvtr_p = newQvtr_p;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_P, oldQvtr_p, qvtr_p));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationDomain getQvtr_qvtrDomain() {
		if (qvtr_qvtrDomain != null && qvtr_qvtrDomain.eIsProxy()) {
			InternalEObject oldQvtr_qvtrDomain = (InternalEObject)qvtr_qvtrDomain;
			qvtr_qvtrDomain = (RelationDomain)eResolveProxy(oldQvtr_qvtrDomain);
			if (qvtr_qvtrDomain != oldQvtr_qvtrDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_DOMAIN, oldQvtr_qvtrDomain, qvtr_qvtrDomain));
			}
		}
		return qvtr_qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetQvtr_qvtrDomain() {
		return qvtr_qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrDomain(RelationDomain newQvtr_qvtrDomain) {
		RelationDomain oldQvtr_qvtrDomain = qvtr_qvtrDomain;
		qvtr_qvtrDomain = newQvtr_qvtrDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_DOMAIN, oldQvtr_qvtrDomain, qvtr_qvtrDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrExpression() {
		if (qvtr_qvtrExpression != null && qvtr_qvtrExpression.eIsProxy()) {
			InternalEObject oldQvtr_qvtrExpression = (InternalEObject)qvtr_qvtrExpression;
			qvtr_qvtrExpression = (OCLExpression)eResolveProxy(oldQvtr_qvtrExpression);
			if (qvtr_qvtrExpression != oldQvtr_qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
			}
		}
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrExpression() {
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrExpression(OCLExpression newQvtr_qvtrExpression) {
		OCLExpression oldQvtr_qvtrExpression = qvtr_qvtrExpression;
		qvtr_qvtrExpression = newQvtr_qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getQvtr_qvtrRelation() {
		if (qvtr_qvtrRelation != null && qvtr_qvtrRelation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrRelation = (InternalEObject)qvtr_qvtrRelation;
			qvtr_qvtrRelation = (Relation)eResolveProxy(oldQvtr_qvtrRelation);
			if (qvtr_qvtrRelation != oldQvtr_qvtrRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
			}
		}
		return qvtr_qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetQvtr_qvtrRelation() {
		return qvtr_qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrRelation(Relation newQvtr_qvtrRelation) {
		Relation oldQvtr_qvtrRelation = qvtr_qvtrRelation;
		qvtr_qvtrRelation = newQvtr_qvtrRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getQvtr_w() {
		if (qvtr_w != null && qvtr_w.eIsProxy()) {
			InternalEObject oldQvtr_w = (InternalEObject)qvtr_w;
			qvtr_w = (Pattern)eResolveProxy(oldQvtr_w);
			if (qvtr_w != oldQvtr_w) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_W, oldQvtr_w, qvtr_w));
			}
		}
		return qvtr_w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern basicGetQvtr_w() {
		return qvtr_w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_w(Pattern newQvtr_w) {
		Pattern oldQvtr_w = qvtr_w;
		qvtr_w = newQvtr_w;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_W, oldQvtr_w, qvtr_w));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_EXPRESSION:
				if (resolve) return getAtl_atlExpression();
				return basicGetAtl_atlExpression();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_PATTERN:
				if (resolve) return getAtl_atlPattern();
				return basicGetAtl_atlPattern();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_RULE:
				if (resolve) return getAtl_atlRule();
				return basicGetAtl_atlRule();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_P:
				if (resolve) return getQvtr_p();
				return basicGetQvtr_p();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_DOMAIN:
				if (resolve) return getQvtr_qvtrDomain();
				return basicGetQvtr_qvtrDomain();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_EXPRESSION:
				if (resolve) return getQvtr_qvtrExpression();
				return basicGetQvtr_qvtrExpression();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_RELATION:
				if (resolve) return getQvtr_qvtrRelation();
				return basicGetQvtr_qvtrRelation();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_W:
				if (resolve) return getQvtr_w();
				return basicGetQvtr_w();
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
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_PATTERN:
				setAtl_atlPattern((InPattern)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_RULE:
				setAtl_atlRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_P:
				setQvtr_p((Predicate)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_DOMAIN:
				setQvtr_qvtrDomain((RelationDomain)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_W:
				setQvtr_w((Pattern)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_PATTERN:
				setAtl_atlPattern((InPattern)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_RULE:
				setAtl_atlRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_P:
				setQvtr_p((Predicate)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_DOMAIN:
				setQvtr_qvtrDomain((RelationDomain)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_W:
				setQvtr_w((Pattern)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_EXPRESSION:
				return atl_atlExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_PATTERN:
				return atl_atlPattern != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__ATL_ATL_RULE:
				return atl_atlRule != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_P:
				return qvtr_p != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_DOMAIN:
				return qvtr_qvtrDomain != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_EXPRESSION:
				return qvtr_qvtrExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_RELATION:
				return qvtr_qvtrRelation != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER__QVTR_W:
				return qvtr_w != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapInPattern_filterImpl
