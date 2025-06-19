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

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap In Pattern filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT3atlExpression <em>T3atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT3atlPattern <em>T3atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT3atlRule <em>T3atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT4qvtrExpression <em>T4qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT4qvtrPattern <em>T4qvtr Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT4qvtrPredicate <em>T4qvtr Predicate</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl#getT4qvtrRelation <em>T4qvtr Relation</em>}</li>
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
	public static final int TMAP_IN_PATTERN_FILTER_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Tmap In Pattern filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_IN_PATTERN_FILTER_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


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
	 * The cached value of the '{@link #getT3atlExpression() <em>T3atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t3atlExpression;

	/**
	 * The cached value of the '{@link #getT3atlPattern() <em>T3atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlPattern()
	 * @generated
	 * @ordered
	 */
	protected InPattern t3atlPattern;

	/**
	 * The cached value of the '{@link #getT3atlRule() <em>T3atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t3atlRule;

	/**
	 * The cached value of the '{@link #getT4qvtrExpression() <em>T4qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t4qvtrExpression;

	/**
	 * The cached value of the '{@link #getT4qvtrPattern() <em>T4qvtr Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern t4qvtrPattern;

	/**
	 * The cached value of the '{@link #getT4qvtrPredicate() <em>T4qvtr Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate t4qvtrPredicate;

	/**
	 * The cached value of the '{@link #getT4qvtrRelation() <em>T4qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation t4qvtrRelation;

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
	public OclExpression getT3atlExpression() {
		if (t3atlExpression != null && t3atlExpression.eIsProxy()) {
			InternalEObject oldT3atlExpression = t3atlExpression;
			t3atlExpression = (OclExpression)eResolveProxy(oldT3atlExpression);
			if (t3atlExpression != oldT3atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlExpression, t3atlExpression));
			}
		}
		return t3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT3atlExpression() {
		return t3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlExpression(OclExpression newT3atlExpression) {
		OclExpression oldT3atlExpression = t3atlExpression;
		t3atlExpression = newT3atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlExpression, t3atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InPattern getT3atlPattern() {
		if (t3atlPattern != null && t3atlPattern.eIsProxy()) {
			InternalEObject oldT3atlPattern = t3atlPattern;
			t3atlPattern = (InPattern)eResolveProxy(oldT3atlPattern);
			if (t3atlPattern != oldT3atlPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlPattern, t3atlPattern));
			}
		}
		return t3atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InPattern basicGetT3atlPattern() {
		return t3atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlPattern(InPattern newT3atlPattern) {
		InPattern oldT3atlPattern = t3atlPattern;
		t3atlPattern = newT3atlPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlPattern, t3atlPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT3atlRule() {
		if (t3atlRule != null && t3atlRule.eIsProxy()) {
			InternalEObject oldT3atlRule = t3atlRule;
			t3atlRule = (MatchedRule)eResolveProxy(oldT3atlRule);
			if (t3atlRule != oldT3atlRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlRule, t3atlRule));
			}
		}
		return t3atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT3atlRule() {
		return t3atlRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlRule(MatchedRule newT3atlRule) {
		MatchedRule oldT3atlRule = t3atlRule;
		t3atlRule = newT3atlRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlRule, t3atlRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT4qvtrExpression() {
		if (t4qvtrExpression != null && t4qvtrExpression.eIsProxy()) {
			InternalEObject oldT4qvtrExpression = (InternalEObject)t4qvtrExpression;
			t4qvtrExpression = (OCLExpression)eResolveProxy(oldT4qvtrExpression);
			if (t4qvtrExpression != oldT4qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrExpression, t4qvtrExpression));
			}
		}
		return t4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT4qvtrExpression() {
		return t4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrExpression(OCLExpression newT4qvtrExpression) {
		OCLExpression oldT4qvtrExpression = t4qvtrExpression;
		t4qvtrExpression = newT4qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrExpression, t4qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getT4qvtrPattern() {
		if (t4qvtrPattern != null && t4qvtrPattern.eIsProxy()) {
			InternalEObject oldT4qvtrPattern = (InternalEObject)t4qvtrPattern;
			t4qvtrPattern = (Pattern)eResolveProxy(oldT4qvtrPattern);
			if (t4qvtrPattern != oldT4qvtrPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrPattern, t4qvtrPattern));
			}
		}
		return t4qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern basicGetT4qvtrPattern() {
		return t4qvtrPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrPattern(Pattern newT4qvtrPattern) {
		Pattern oldT4qvtrPattern = t4qvtrPattern;
		t4qvtrPattern = newT4qvtrPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrPattern, t4qvtrPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Predicate getT4qvtrPredicate() {
		if (t4qvtrPredicate != null && t4qvtrPredicate.eIsProxy()) {
			InternalEObject oldT4qvtrPredicate = (InternalEObject)t4qvtrPredicate;
			t4qvtrPredicate = (Predicate)eResolveProxy(oldT4qvtrPredicate);
			if (t4qvtrPredicate != oldT4qvtrPredicate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrPredicate, t4qvtrPredicate));
			}
		}
		return t4qvtrPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetT4qvtrPredicate() {
		return t4qvtrPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrPredicate(Predicate newT4qvtrPredicate) {
		Predicate oldT4qvtrPredicate = t4qvtrPredicate;
		t4qvtrPredicate = newT4qvtrPredicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrPredicate, t4qvtrPredicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getT4qvtrRelation() {
		if (t4qvtrRelation != null && t4qvtrRelation.eIsProxy()) {
			InternalEObject oldT4qvtrRelation = (InternalEObject)t4qvtrRelation;
			t4qvtrRelation = (Relation)eResolveProxy(oldT4qvtrRelation);
			if (t4qvtrRelation != oldT4qvtrRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrRelation, t4qvtrRelation));
			}
		}
		return t4qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetT4qvtrRelation() {
		return t4qvtrRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrRelation(Relation newT4qvtrRelation) {
		Relation oldT4qvtrRelation = t4qvtrRelation;
		t4qvtrRelation = newT4qvtrRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrRelation, t4qvtrRelation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapMatchedRule, wmapMatchedRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapMatchedRule, wmapMatchedRule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapOclExpression, wmapOclExpression));
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
				if (resolve) return getT3atlExpression();
				return basicGetT3atlExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlPattern();
				return basicGetT3atlPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT3atlRule();
				return basicGetT3atlRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT4qvtrExpression();
				return basicGetT4qvtrExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT4qvtrPattern();
				return basicGetT4qvtrPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT4qvtrPredicate();
				return basicGetT4qvtrPredicate();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT4qvtrRelation();
				return basicGetT4qvtrRelation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getWmapMatchedRule();
				return basicGetWmapMatchedRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
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
				setS0global((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT3atlExpression((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlPattern((InPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlRule((MatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrExpression((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrPattern((Pattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrPredicate((Predicate)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrRelation((Relation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapMatchedRule((TmapMatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
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
				setS0global(S0GLOBAL_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT3atlExpression((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlPattern((InPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlRule((MatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrExpression((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrPattern((Pattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrPredicate((Predicate)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrRelation((Relation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapMatchedRule((TmapMatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
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
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return t3atlExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t4qvtrExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t4qvtrPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t4qvtrPredicate != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t4qvtrRelation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return wmapMatchedRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return wmapOclExpression != null;
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


} //TmapInPattern_filterImpl
