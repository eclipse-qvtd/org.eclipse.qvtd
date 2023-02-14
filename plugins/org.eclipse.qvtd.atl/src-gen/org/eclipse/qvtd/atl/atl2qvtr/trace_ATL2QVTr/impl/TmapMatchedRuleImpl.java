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

import org.eclipse.m2m.atl.common.ATL.MatchedRule;
import org.eclipse.m2m.atl.common.ATL.OutPattern;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Matched Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT1ruleName <em>T1rule Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT3atlModule <em>T3atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT3atlOutPattern <em>T3atl Out Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT3matchedRule <em>T3matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT4_6 <em>T4 6</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT4qvtrRelation <em>T4qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT4qvtrTransformation <em>T4qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getWmapModule <em>Wmap Module</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapMatchedRuleImpl extends ExecutionImpl implements TmapMatchedRule {
	/**
	 * The number of structural features of the '<em>Tmap Matched Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_MATCHED_RULE_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Tmap Matched Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_MATCHED_RULE_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


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
	 * The default value of the '{@link #getT1ruleName() <em>T1rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1ruleName()
	 * @generated
	 * @ordered
	 */
	protected static final String T1RULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT1ruleName() <em>T1rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1ruleName()
	 * @generated
	 * @ordered
	 */
	protected String t1ruleName = T1RULE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT3atlModule() <em>T3atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module t3atlModule;

	/**
	 * The cached value of the '{@link #getT3atlOutPattern() <em>T3atl Out Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlOutPattern()
	 * @generated
	 * @ordered
	 */
	protected OutPattern t3atlOutPattern;

	/**
	 * The cached value of the '{@link #getT3matchedRule() <em>T3matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3matchedRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t3matchedRule;

	/**
	 * The cached value of the '{@link #getT4_6() <em>T4 6</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4_6()
	 * @generated
	 * @ordered
	 */
	protected SharedVariable t4_6;

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
	 * The cached value of the '{@link #getT4qvtrTransformation() <em>T4qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation t4qvtrTransformation;

	/**
	 * The cached value of the '{@link #getWmapModule() <em>Wmap Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapModule()
	 * @generated
	 * @ordered
	 */
	protected TmapModule wmapModule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapMatchedRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_MATCHED_RULE;
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
	public String getT1ruleName() {
		return t1ruleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1ruleName(String newT1ruleName) {
		String oldT1ruleName = t1ruleName;
		t1ruleName = newT1ruleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1ruleName, t1ruleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getT3atlModule() {
		if (t3atlModule != null && t3atlModule.eIsProxy()) {
			InternalEObject oldT3atlModule = t3atlModule;
			t3atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT3atlModule);
			if (t3atlModule != oldT3atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlModule, t3atlModule));
			}
		}
		return t3atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetT3atlModule() {
		return t3atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlModule(org.eclipse.m2m.atl.common.ATL.Module newT3atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT3atlModule = t3atlModule;
		t3atlModule = newT3atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlModule, t3atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutPattern getT3atlOutPattern() {
		if (t3atlOutPattern != null && t3atlOutPattern.eIsProxy()) {
			InternalEObject oldT3atlOutPattern = t3atlOutPattern;
			t3atlOutPattern = (OutPattern)eResolveProxy(oldT3atlOutPattern);
			if (t3atlOutPattern != oldT3atlOutPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlOutPattern, t3atlOutPattern));
			}
		}
		return t3atlOutPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPattern basicGetT3atlOutPattern() {
		return t3atlOutPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlOutPattern(OutPattern newT3atlOutPattern) {
		OutPattern oldT3atlOutPattern = t3atlOutPattern;
		t3atlOutPattern = newT3atlOutPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlOutPattern, t3atlOutPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT3matchedRule() {
		if (t3matchedRule != null && t3matchedRule.eIsProxy()) {
			InternalEObject oldT3matchedRule = t3matchedRule;
			t3matchedRule = (MatchedRule)eResolveProxy(oldT3matchedRule);
			if (t3matchedRule != oldT3matchedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3matchedRule, t3matchedRule));
			}
		}
		return t3matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT3matchedRule() {
		return t3matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3matchedRule(MatchedRule newT3matchedRule) {
		MatchedRule oldT3matchedRule = t3matchedRule;
		t3matchedRule = newT3matchedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3matchedRule, t3matchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SharedVariable getT4_6() {
		if (t4_6 != null && t4_6.eIsProxy()) {
			InternalEObject oldT4_6 = (InternalEObject)t4_6;
			t4_6 = (SharedVariable)eResolveProxy(oldT4_6);
			if (t4_6 != oldT4_6) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4_6, t4_6));
			}
		}
		return t4_6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SharedVariable basicGetT4_6() {
		return t4_6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4_6(SharedVariable newT4_6) {
		SharedVariable oldT4_6 = t4_6;
		t4_6 = newT4_6;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4_6, t4_6));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrRelation, t4qvtrRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrRelation, t4qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getT4qvtrTransformation() {
		if (t4qvtrTransformation != null && t4qvtrTransformation.eIsProxy()) {
			InternalEObject oldT4qvtrTransformation = (InternalEObject)t4qvtrTransformation;
			t4qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT4qvtrTransformation);
			if (t4qvtrTransformation != oldT4qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrTransformation, t4qvtrTransformation));
			}
		}
		return t4qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetT4qvtrTransformation() {
		return t4qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrTransformation(RelationalTransformation newT4qvtrTransformation) {
		RelationalTransformation oldT4qvtrTransformation = t4qvtrTransformation;
		t4qvtrTransformation = newT4qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrTransformation, t4qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapModule getWmapModule() {
		if (wmapModule != null && wmapModule.eIsProxy()) {
			InternalEObject oldWmapModule = (InternalEObject)wmapModule;
			wmapModule = (TmapModule)eResolveProxy(oldWmapModule);
			if (wmapModule != oldWmapModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapModule, wmapModule));
			}
		}
		return wmapModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapModule basicGetWmapModule() {
		return wmapModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapModule(TmapModule newWmapModule) {
		TmapModule oldWmapModule = wmapModule;
		wmapModule = newWmapModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapModule, wmapModule));
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
				return getT1ruleName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlModule();
				return basicGetT3atlModule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT3atlOutPattern();
				return basicGetT3atlOutPattern();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT3matchedRule();
				return basicGetT3matchedRule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT4_6();
				return basicGetT4_6();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT4qvtrRelation();
				return basicGetT4qvtrRelation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT4qvtrTransformation();
				return basicGetT4qvtrTransformation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getWmapModule();
				return basicGetWmapModule();
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
				setT1ruleName((String)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlOutPattern((OutPattern)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3matchedRule((MatchedRule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4_6((SharedVariable)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrRelation((Relation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrTransformation((RelationalTransformation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapModule((TmapModule)newValue);
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
				setT1ruleName(T1RULE_NAME_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlOutPattern((OutPattern)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3matchedRule((MatchedRule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4_6((SharedVariable)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrRelation((Relation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrTransformation((RelationalTransformation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapModule((TmapModule)null);
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
				return T1RULE_NAME_EDEFAULT == null ? t1ruleName != null : !T1RULE_NAME_EDEFAULT.equals(t1ruleName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlModule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlOutPattern != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t3matchedRule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t4_6 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t4qvtrRelation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t4qvtrTransformation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return wmapModule != null;
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
		result.append(", t1ruleName: ");
		result.append(t1ruleName);
		result.append(')');
		return result.toString();
	}


} //TmapMatchedRuleImpl
