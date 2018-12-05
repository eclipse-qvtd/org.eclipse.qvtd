/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.m2m.atl.common.ATL.OutPattern;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Out Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getSuccess <em>Success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getT1atlPattern <em>T1atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getT1atlRule <em>T1atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getT2qvtrDomain <em>T2qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getT2qvtrRelation <em>T2qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapOutPatternImpl extends ExecutionImpl implements TmapOutPattern {
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
	 * The cached value of the '{@link #getT1atlPattern() <em>T1atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlPattern()
	 * @generated
	 * @ordered
	 */
	protected OutPattern t1atlPattern;

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
	 * The cached value of the '{@link #getT2qvtrDomain() <em>T2qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain t2qvtrDomain;

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
	 * The cached value of the '{@link #getT2qvtrTypedModel() <em>T2qvtr Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel t2qvtrTypedModel;

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
	 * The cached value of the '{@link #getWmapOclMetamodel() <em>Wmap Ocl Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOclMetamodel()
	 * @generated
	 * @ordered
	 */
	protected TmapOclMetamodel wmapOclMetamodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapOutPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_OUT_PATTERN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__SUCCESS, oldSuccess, success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutPattern getT1atlPattern() {
		if (t1atlPattern != null && t1atlPattern.eIsProxy()) {
			InternalEObject oldT1atlPattern = (InternalEObject)t1atlPattern;
			t1atlPattern = (OutPattern)eResolveProxy(oldT1atlPattern);
			if (t1atlPattern != oldT1atlPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_PATTERN, oldT1atlPattern, t1atlPattern));
			}
		}
		return t1atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutPattern basicGetT1atlPattern() {
		return t1atlPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlPattern(OutPattern newT1atlPattern) {
		OutPattern oldT1atlPattern = t1atlPattern;
		t1atlPattern = newT1atlPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_PATTERN, oldT1atlPattern, t1atlPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getT1atlRule() {
		if (t1atlRule != null && t1atlRule.eIsProxy()) {
			InternalEObject oldT1atlRule = (InternalEObject)t1atlRule;
			t1atlRule = (MatchedRule)eResolveProxy(oldT1atlRule);
			if (t1atlRule != oldT1atlRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_RULE, oldT1atlRule, t1atlRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_RULE, oldT1atlRule, t1atlRule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_DOMAIN, oldT2qvtrDomain, t2qvtrDomain));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_DOMAIN, oldT2qvtrDomain, t2qvtrDomain));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_RELATION, oldT2qvtrRelation, t2qvtrRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_RELATION, oldT2qvtrRelation, t2qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getT2qvtrTypedModel() {
		if (t2qvtrTypedModel != null && t2qvtrTypedModel.eIsProxy()) {
			InternalEObject oldT2qvtrTypedModel = (InternalEObject)t2qvtrTypedModel;
			t2qvtrTypedModel = (TypedModel)eResolveProxy(oldT2qvtrTypedModel);
			if (t2qvtrTypedModel != oldT2qvtrTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL, oldT2qvtrTypedModel, t2qvtrTypedModel));
			}
		}
		return t2qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetT2qvtrTypedModel() {
		return t2qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrTypedModel(TypedModel newT2qvtrTypedModel) {
		TypedModel oldT2qvtrTypedModel = t2qvtrTypedModel;
		t2qvtrTypedModel = newT2qvtrTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL, oldT2qvtrTypedModel, t2qvtrTypedModel));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_MATCHED_RULE, oldWmapMatchedRule, wmapMatchedRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_MATCHED_RULE, oldWmapMatchedRule, wmapMatchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOclMetamodel getWmapOclMetamodel() {
		if (wmapOclMetamodel != null && wmapOclMetamodel.eIsProxy()) {
			InternalEObject oldWmapOclMetamodel = (InternalEObject)wmapOclMetamodel;
			wmapOclMetamodel = (TmapOclMetamodel)eResolveProxy(oldWmapOclMetamodel);
			if (wmapOclMetamodel != oldWmapOclMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL, oldWmapOclMetamodel, wmapOclMetamodel));
			}
		}
		return wmapOclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOclMetamodel basicGetWmapOclMetamodel() {
		return wmapOclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapOclMetamodel(TmapOclMetamodel newWmapOclMetamodel) {
		TmapOclMetamodel oldWmapOclMetamodel = wmapOclMetamodel;
		wmapOclMetamodel = newWmapOclMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL, oldWmapOclMetamodel, wmapOclMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__SUCCESS:
				return getSuccess();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_PATTERN:
				if (resolve) return getT1atlPattern();
				return basicGetT1atlPattern();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_RULE:
				if (resolve) return getT1atlRule();
				return basicGetT1atlRule();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_DOMAIN:
				if (resolve) return getT2qvtrDomain();
				return basicGetT2qvtrDomain();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_RELATION:
				if (resolve) return getT2qvtrRelation();
				return basicGetT2qvtrRelation();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL:
				if (resolve) return getT2qvtrTypedModel();
				return basicGetT2qvtrTypedModel();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_MATCHED_RULE:
				if (resolve) return getWmapMatchedRule();
				return basicGetWmapMatchedRule();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL:
				if (resolve) return getWmapOclMetamodel();
				return basicGetWmapOclMetamodel();
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
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__SUCCESS:
				setSuccess((Boolean)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_PATTERN:
				setT1atlPattern((OutPattern)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_RULE:
				setT1atlRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_DOMAIN:
				setT2qvtrDomain((RelationDomain)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_RELATION:
				setT2qvtrRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL:
				setT2qvtrTypedModel((TypedModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_MATCHED_RULE:
				setWmapMatchedRule((TmapMatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL:
				setWmapOclMetamodel((TmapOclMetamodel)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__SUCCESS:
				setSuccess(SUCCESS_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_PATTERN:
				setT1atlPattern((OutPattern)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_RULE:
				setT1atlRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_DOMAIN:
				setT2qvtrDomain((RelationDomain)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_RELATION:
				setT2qvtrRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL:
				setT2qvtrTypedModel((TypedModel)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_MATCHED_RULE:
				setWmapMatchedRule((TmapMatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL:
				setWmapOclMetamodel((TmapOclMetamodel)null);
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
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__SUCCESS:
				return SUCCESS_EDEFAULT == null ? success != null : !SUCCESS_EDEFAULT.equals(success);
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_PATTERN:
				return t1atlPattern != null;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T1ATL_RULE:
				return t1atlRule != null;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_DOMAIN:
				return t2qvtrDomain != null;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_RELATION:
				return t2qvtrRelation != null;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL:
				return t2qvtrTypedModel != null;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_MATCHED_RULE:
				return wmapMatchedRule != null;
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL:
				return wmapOclMetamodel != null;
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
		result.append(')');
		return result.toString();
	}

} //TmapOutPatternImpl
