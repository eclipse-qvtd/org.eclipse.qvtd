/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap In Pattern filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT1atlExpression <em>T1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT1atlPattern <em>T1atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT1atlRule <em>T1atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT2p <em>T2p</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT2qvtrDomain <em>T2qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT2qvtrExpression <em>T2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT2qvtrRelation <em>T2qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT2w <em>T2w</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getWmapInPattern <em>Wmap In Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapInPattern_filterImpl extends ExecutionImpl implements TmapInPattern_filter {
	/**
	 * The number of structural features of the '<em>Tmap In Pattern filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_IN_PATTERN_FILTER_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 11;

	/**
	 * The number of operations of the '<em>Tmap In Pattern filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_IN_PATTERN_FILTER_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getT1atlExpression() <em>T1atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlExpression;

	/**
	 * The cached value of the '{@link #getT1atlPattern() <em>T1atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlPattern()
	 * @generated
	 * @ordered
	 */
	protected InPattern t1atlPattern;

	/**
	 * The cached value of the '{@link #getT1atlRule() <em>T1atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t1atlRule;

	/**
	 * The cached value of the '{@link #getT2p() <em>T2p</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2p()
	 * @generated
	 * @ordered
	 */
	protected Predicate t2p;

	/**
	 * The cached value of the '{@link #getT2qvtrDomain() <em>T2qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain t2qvtrDomain;

	/**
	 * The cached value of the '{@link #getT2qvtrExpression() <em>T2qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrExpression;

	/**
	 * The cached value of the '{@link #getT2qvtrRelation() <em>T2qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t2qvtrRelation;

	/**
	 * The cached value of the '{@link #getT2w() <em>T2w</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2w()
	 * @generated
	 * @ordered
	 */
	protected Pattern t2w;

	/**
	 * The cached value of the '{@link #getWmapInPattern() <em>Wmap In Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapInPattern()
	 * @generated
	 * @ordered
	 */
	protected TmapInPattern wmapInPattern;

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
	 * The cached value of the '{@link #getWmapOclExpression() <em>Wmap Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOclExpression()
	 * @generated
	 * @ordered
	 */
	protected DmapOclExpression wmapOclExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapInPattern_filterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_IN_PATTERN_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlExpression() {
		if (t1atlExpression != null && t1atlExpression.eIsProxy()) {
			InternalEObject oldT1atlExpression = t1atlExpression;
			t1atlExpression = (OclExpression)eResolveProxy(oldT1atlExpression);
			if (t1atlExpression != oldT1atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldT1atlExpression, t1atlExpression));
			}
		}
		return t1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlExpression() {
		return t1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlExpression(OclExpression newT1atlExpression) {
		OclExpression oldT1atlExpression = t1atlExpression;
		t1atlExpression = newT1atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldT1atlExpression, t1atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InPattern getT1atlPattern() {
		if (t1atlPattern != null && t1atlPattern.eIsProxy()) {
			InternalEObject oldT1atlPattern = t1atlPattern;
			t1atlPattern = (InPattern)eResolveProxy(oldT1atlPattern);
			if (t1atlPattern != oldT1atlPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlPattern, t1atlPattern));
			}
		}
		return t1atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern basicGetT1atlPattern() {
		return t1atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlPattern(InPattern newT1atlPattern) {
		InPattern oldT1atlPattern = t1atlPattern;
		t1atlPattern = newT1atlPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlPattern, t1atlPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT1atlRule() {
		if (t1atlRule != null && t1atlRule.eIsProxy()) {
			InternalEObject oldT1atlRule = t1atlRule;
			t1atlRule = (MatchedRule)eResolveProxy(oldT1atlRule);
			if (t1atlRule != oldT1atlRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1atlRule, t1atlRule));
			}
		}
		return t1atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT1atlRule() {
		return t1atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlRule(MatchedRule newT1atlRule) {
		MatchedRule oldT1atlRule = t1atlRule;
		t1atlRule = newT1atlRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1atlRule, t1atlRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Predicate getT2p() {
		if (t2p != null && t2p.eIsProxy()) {
			InternalEObject oldT2p = (InternalEObject)t2p;
			t2p = (Predicate)eResolveProxy(oldT2p);
			if (t2p != oldT2p) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2p, t2p));
			}
		}
		return t2p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetT2p() {
		return t2p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2p(Predicate newT2p) {
		Predicate oldT2p = t2p;
		t2p = newT2p;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2p, t2p));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationDomain getT2qvtrDomain() {
		if (t2qvtrDomain != null && t2qvtrDomain.eIsProxy()) {
			InternalEObject oldT2qvtrDomain = (InternalEObject)t2qvtrDomain;
			t2qvtrDomain = (RelationDomain)eResolveProxy(oldT2qvtrDomain);
			if (t2qvtrDomain != oldT2qvtrDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT2qvtrDomain, t2qvtrDomain));
			}
		}
		return t2qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain basicGetT2qvtrDomain() {
		return t2qvtrDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrDomain(RelationDomain newT2qvtrDomain) {
		RelationDomain oldT2qvtrDomain = t2qvtrDomain;
		t2qvtrDomain = newT2qvtrDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT2qvtrDomain, t2qvtrDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT2qvtrExpression() {
		if (t2qvtrExpression != null && t2qvtrExpression.eIsProxy()) {
			InternalEObject oldT2qvtrExpression = (InternalEObject)t2qvtrExpression;
			t2qvtrExpression = (OCLExpression)eResolveProxy(oldT2qvtrExpression);
			if (t2qvtrExpression != oldT2qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT2qvtrExpression, t2qvtrExpression));
			}
		}
		return t2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrExpression() {
		return t2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrExpression(OCLExpression newT2qvtrExpression) {
		OCLExpression oldT2qvtrExpression = t2qvtrExpression;
		t2qvtrExpression = newT2qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT2qvtrExpression, t2qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT2qvtrRelation() {
		if (t2qvtrRelation != null && t2qvtrRelation.eIsProxy()) {
			InternalEObject oldT2qvtrRelation = (InternalEObject)t2qvtrRelation;
			t2qvtrRelation = (Relation)eResolveProxy(oldT2qvtrRelation);
			if (t2qvtrRelation != oldT2qvtrRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT2qvtrRelation, t2qvtrRelation));
			}
		}
		return t2qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT2qvtrRelation() {
		return t2qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrRelation(Relation newT2qvtrRelation) {
		Relation oldT2qvtrRelation = t2qvtrRelation;
		t2qvtrRelation = newT2qvtrRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT2qvtrRelation, t2qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getT2w() {
		if (t2w != null && t2w.eIsProxy()) {
			InternalEObject oldT2w = (InternalEObject)t2w;
			t2w = (Pattern)eResolveProxy(oldT2w);
			if (t2w != oldT2w) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT2w, t2w));
			}
		}
		return t2w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern basicGetT2w() {
		return t2w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2w(Pattern newT2w) {
		Pattern oldT2w = t2w;
		t2w = newT2w;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT2w, t2w));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapInPattern getWmapInPattern() {
		if (wmapInPattern != null && wmapInPattern.eIsProxy()) {
			InternalEObject oldWmapInPattern = (InternalEObject)wmapInPattern;
			wmapInPattern = (TmapInPattern)eResolveProxy(oldWmapInPattern);
			if (wmapInPattern != oldWmapInPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapInPattern, wmapInPattern));
			}
		}
		return wmapInPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapInPattern basicGetWmapInPattern() {
		return wmapInPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapInPattern(TmapInPattern newWmapInPattern) {
		TmapInPattern oldWmapInPattern = wmapInPattern;
		wmapInPattern = newWmapInPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapInPattern, wmapInPattern));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapMatchedRule, wmapMatchedRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapMatchedRule, wmapMatchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getWmapOclExpression() {
		if (wmapOclExpression != null && wmapOclExpression.eIsProxy()) {
			InternalEObject oldWmapOclExpression = (InternalEObject)wmapOclExpression;
			wmapOclExpression = (DmapOclExpression)eResolveProxy(oldWmapOclExpression);
			if (wmapOclExpression != oldWmapOclExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapOclExpression, wmapOclExpression));
			}
		}
		return wmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression basicGetWmapOclExpression() {
		return wmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapOclExpression(DmapOclExpression newWmapOclExpression) {
		DmapOclExpression oldWmapOclExpression = wmapOclExpression;
		wmapOclExpression = newWmapOclExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapOclExpression, wmapOclExpression));
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
				if (resolve) return getT1atlExpression();
				return basicGetT1atlExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				if (resolve) return getT1atlPattern();
				return basicGetT1atlPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT1atlRule();
				return basicGetT1atlRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT2p();
				return basicGetT2p();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT2qvtrDomain();
				return basicGetT2qvtrDomain();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT2qvtrExpression();
				return basicGetT2qvtrExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT2qvtrRelation();
				return basicGetT2qvtrRelation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT2w();
				return basicGetT2w();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getWmapInPattern();
				return basicGetWmapInPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				if (resolve) return getWmapMatchedRule();
				return basicGetWmapMatchedRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
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
				setT1atlExpression((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlPattern((InPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1atlRule((MatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2p((Predicate)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT2qvtrDomain((RelationDomain)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT2qvtrExpression((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT2qvtrRelation((Relation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT2w((Pattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapInPattern((TmapInPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setWmapMatchedRule((TmapMatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapOclExpression((DmapOclExpression)newValue);
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
				setT1atlExpression((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlPattern((InPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1atlRule((MatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2p((Predicate)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT2qvtrDomain((RelationDomain)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT2qvtrExpression((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT2qvtrRelation((Relation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT2w((Pattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapInPattern((TmapInPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setWmapMatchedRule((TmapMatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapOclExpression((DmapOclExpression)null);
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
				return t1atlExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return t1atlPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t1atlRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t2p != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t2qvtrDomain != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t2qvtrExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t2qvtrRelation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t2w != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return wmapInPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return wmapMatchedRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				return wmapOclExpression != null;
		}
		return super.eIsSet(featureID);
	}


} //TmapInPattern_filterImpl
