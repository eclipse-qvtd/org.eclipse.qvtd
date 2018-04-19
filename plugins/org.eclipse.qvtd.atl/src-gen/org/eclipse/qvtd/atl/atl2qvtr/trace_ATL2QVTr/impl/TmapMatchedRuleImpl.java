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

import org.eclipse.m2m.atl.common.ATL.MatchedRule;

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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getSuccess <em>Success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT0ruleName <em>T0rule Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT1atlModule <em>T1atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT1matchedRule <em>T1matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT2_1 <em>T2 1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT2qvtrRelation <em>T2qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl#getWmapModule <em>Wmap Module</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapMatchedRuleImpl extends ExecutionImpl implements TmapMatchedRule {
	/**
	 * The default value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SUCCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected Boolean success = SUCCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getT0ruleName() <em>T0rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0ruleName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0RULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0ruleName() <em>T0rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0ruleName()
	 * @generated
	 * @ordered
	 */
	protected String t0ruleName = T0RULE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlModule() <em>T1atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module t1atlModule;

	/**
	 * The cached value of the '{@link #getT1matchedRule() <em>T1matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1matchedRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule t1matchedRule;

	/**
	 * The cached value of the '{@link #getT2_1() <em>T2 1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_1()
	 * @generated
	 * @ordered
	 */
	protected SharedVariable t2_1;

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
	 * The cached value of the '{@link #getT2qvtrTransformation() <em>T2qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation t2qvtrTransformation;

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
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuccess(Boolean newSuccess) {
		Boolean oldSuccess = success;
		success = newSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__SUCCESS, oldSuccess, success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT0ruleName() {
		return t0ruleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0ruleName(String newT0ruleName) {
		String oldT0ruleName = t0ruleName;
		t0ruleName = newT0ruleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T0RULE_NAME, oldT0ruleName, t0ruleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getT1atlModule() {
		if (t1atlModule != null && t1atlModule.eIsProxy()) {
			InternalEObject oldT1atlModule = t1atlModule;
			t1atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT1atlModule);
			if (t1atlModule != oldT1atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1ATL_MODULE, oldT1atlModule, t1atlModule));
			}
		}
		return t1atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetT1atlModule() {
		return t1atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlModule(org.eclipse.m2m.atl.common.ATL.Module newT1atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT1atlModule = t1atlModule;
		t1atlModule = newT1atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1ATL_MODULE, oldT1atlModule, t1atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT1matchedRule() {
		if (t1matchedRule != null && t1matchedRule.eIsProxy()) {
			InternalEObject oldT1matchedRule = t1matchedRule;
			t1matchedRule = (MatchedRule)eResolveProxy(oldT1matchedRule);
			if (t1matchedRule != oldT1matchedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1MATCHED_RULE, oldT1matchedRule, t1matchedRule));
			}
		}
		return t1matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetT1matchedRule() {
		return t1matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1matchedRule(MatchedRule newT1matchedRule) {
		MatchedRule oldT1matchedRule = t1matchedRule;
		t1matchedRule = newT1matchedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1MATCHED_RULE, oldT1matchedRule, t1matchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SharedVariable getT2_1() {
		if (t2_1 != null && t2_1.eIsProxy()) {
			InternalEObject oldT2_1 = (InternalEObject)t2_1;
			t2_1 = (SharedVariable)eResolveProxy(oldT2_1);
			if (t2_1 != oldT2_1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2_1, oldT2_1, t2_1));
			}
		}
		return t2_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SharedVariable basicGetT2_1() {
		return t2_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2_1(SharedVariable newT2_1) {
		SharedVariable oldT2_1 = t2_1;
		t2_1 = newT2_1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2_1, oldT2_1, t2_1));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_RELATION, oldT2qvtrRelation, t2qvtrRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_RELATION, oldT2qvtrRelation, t2qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getT2qvtrTransformation() {
		if (t2qvtrTransformation != null && t2qvtrTransformation.eIsProxy()) {
			InternalEObject oldT2qvtrTransformation = (InternalEObject)t2qvtrTransformation;
			t2qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT2qvtrTransformation);
			if (t2qvtrTransformation != oldT2qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
			}
		}
		return t2qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetT2qvtrTransformation() {
		return t2qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrTransformation(RelationalTransformation newT2qvtrTransformation) {
		RelationalTransformation oldT2qvtrTransformation = t2qvtrTransformation;
		t2qvtrTransformation = newT2qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__WMAP_MODULE, oldWmapModule, wmapModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__WMAP_MODULE, oldWmapModule, wmapModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__SUCCESS:
				return getSuccess();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T0RULE_NAME:
				return getT0ruleName();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1ATL_MODULE:
				if (resolve) return getT1atlModule();
				return basicGetT1atlModule();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1MATCHED_RULE:
				if (resolve) return getT1matchedRule();
				return basicGetT1matchedRule();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2_1:
				if (resolve) return getT2_1();
				return basicGetT2_1();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_RELATION:
				if (resolve) return getT2qvtrRelation();
				return basicGetT2qvtrRelation();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION:
				if (resolve) return getT2qvtrTransformation();
				return basicGetT2qvtrTransformation();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__WMAP_MODULE:
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
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__SUCCESS:
				setSuccess((Boolean)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T0RULE_NAME:
				setT0ruleName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1MATCHED_RULE:
				setT1matchedRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2_1:
				setT2_1((SharedVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_RELATION:
				setT2qvtrRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__WMAP_MODULE:
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
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__SUCCESS:
				setSuccess(SUCCESS_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T0RULE_NAME:
				setT0ruleName(T0RULE_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1MATCHED_RULE:
				setT1matchedRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2_1:
				setT2_1((SharedVariable)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_RELATION:
				setT2qvtrRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__WMAP_MODULE:
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
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__SUCCESS:
				return SUCCESS_EDEFAULT == null ? success != null : !SUCCESS_EDEFAULT.equals(success);
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T0RULE_NAME:
				return T0RULE_NAME_EDEFAULT == null ? t0ruleName != null : !T0RULE_NAME_EDEFAULT.equals(t0ruleName);
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1ATL_MODULE:
				return t1atlModule != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T1MATCHED_RULE:
				return t1matchedRule != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2_1:
				return t2_1 != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_RELATION:
				return t2qvtrRelation != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION:
				return t2qvtrTransformation != null;
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE__WMAP_MODULE:
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
		result.append(" (success: ");
		result.append(success);
		result.append(", t0ruleName: ");
		result.append(t0ruleName);
		result.append(')');
		return result.toString();
	}

} //TmapMatchedRuleImpl
