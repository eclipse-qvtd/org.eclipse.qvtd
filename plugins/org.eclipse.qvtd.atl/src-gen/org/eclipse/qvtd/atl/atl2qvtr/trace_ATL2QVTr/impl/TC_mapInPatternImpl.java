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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.m2m.atl.common.OCL.OclModel;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map In Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getAtl_atlModel <em>Atl atl Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getAtl_atlPattern <em>Atl atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getAtl_atlRule <em>Atl atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getQvtr_qvtrDomain <em>Qvtr qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getQvtr_qvtrTypedModel <em>Qvtr qvtr Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapInPatternImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapInPatternImpl extends MinimalEObjectImpl.Container implements TC_mapInPattern {
	/**
	 * The cached value of the '{@link #getAtl_atlModel() <em>Atl atl Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlModel()
	 * @generated
	 * @ordered
	 */
	protected OclModel atl_atlModel;

	/**
	 * The cached value of the '{@link #getAtl_atlModule() <em>Atl atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module atl_atlModule;

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
	 * The cached value of the '{@link #getQvtr_qvtrDomain() <em>Qvtr qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrDomain()
	 * @generated
	 * @ordered
	 */
	protected RelationDomain qvtr_qvtrDomain;

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
	 * The cached value of the '{@link #getQvtr_qvtrTypedModel() <em>Qvtr qvtr Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel qvtr_qvtrTypedModel;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Boolean status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapInPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_IN_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclModel getAtl_atlModel() {
		if (atl_atlModel != null && atl_atlModel.eIsProxy()) {
			InternalEObject oldAtl_atlModel = atl_atlModel;
			atl_atlModel = (OclModel)eResolveProxy(oldAtl_atlModel);
			if (atl_atlModel != oldAtl_atlModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODEL, oldAtl_atlModel, atl_atlModel));
			}
		}
		return atl_atlModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetAtl_atlModel() {
		return atl_atlModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlModel(OclModel newAtl_atlModel) {
		OclModel oldAtl_atlModel = atl_atlModel;
		atl_atlModel = newAtl_atlModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODEL, oldAtl_atlModel, atl_atlModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getAtl_atlModule() {
		if (atl_atlModule != null && atl_atlModule.eIsProxy()) {
			InternalEObject oldAtl_atlModule = atl_atlModule;
			atl_atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldAtl_atlModule);
			if (atl_atlModule != oldAtl_atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
			}
		}
		return atl_atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetAtl_atlModule() {
		return atl_atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module newAtl_atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldAtl_atlModule = atl_atlModule;
		atl_atlModule = newAtl_atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_PATTERN, oldAtl_atlPattern, atl_atlPattern));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_PATTERN, oldAtl_atlPattern, atl_atlPattern));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_RULE, oldAtl_atlRule, atl_atlRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_RULE, oldAtl_atlRule, atl_atlRule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_DOMAIN, oldQvtr_qvtrDomain, qvtr_qvtrDomain));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_DOMAIN, oldQvtr_qvtrDomain, qvtr_qvtrDomain));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getQvtr_qvtrTypedModel() {
		if (qvtr_qvtrTypedModel != null && qvtr_qvtrTypedModel.eIsProxy()) {
			InternalEObject oldQvtr_qvtrTypedModel = (InternalEObject)qvtr_qvtrTypedModel;
			qvtr_qvtrTypedModel = (TypedModel)eResolveProxy(oldQvtr_qvtrTypedModel);
			if (qvtr_qvtrTypedModel != oldQvtr_qvtrTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_TYPED_MODEL, oldQvtr_qvtrTypedModel, qvtr_qvtrTypedModel));
			}
		}
		return qvtr_qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetQvtr_qvtrTypedModel() {
		return qvtr_qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrTypedModel(TypedModel newQvtr_qvtrTypedModel) {
		TypedModel oldQvtr_qvtrTypedModel = qvtr_qvtrTypedModel;
		qvtr_qvtrTypedModel = newQvtr_qvtrTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_TYPED_MODEL, oldQvtr_qvtrTypedModel, qvtr_qvtrTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(Boolean newStatus) {
		Boolean oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODEL:
				if (resolve) return getAtl_atlModel();
				return basicGetAtl_atlModel();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_PATTERN:
				if (resolve) return getAtl_atlPattern();
				return basicGetAtl_atlPattern();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_RULE:
				if (resolve) return getAtl_atlRule();
				return basicGetAtl_atlRule();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_DOMAIN:
				if (resolve) return getQvtr_qvtrDomain();
				return basicGetQvtr_qvtrDomain();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_RELATION:
				if (resolve) return getQvtr_qvtrRelation();
				return basicGetQvtr_qvtrRelation();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_TYPED_MODEL:
				if (resolve) return getQvtr_qvtrTypedModel();
				return basicGetQvtr_qvtrTypedModel();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__STATUS:
				return getStatus();
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
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODEL:
				setAtl_atlModel((OclModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_PATTERN:
				setAtl_atlPattern((InPattern)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_RULE:
				setAtl_atlRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_DOMAIN:
				setQvtr_qvtrDomain((RelationDomain)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_TYPED_MODEL:
				setQvtr_qvtrTypedModel((TypedModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__STATUS:
				setStatus((Boolean)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODEL:
				setAtl_atlModel((OclModel)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_PATTERN:
				setAtl_atlPattern((InPattern)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_RULE:
				setAtl_atlRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_DOMAIN:
				setQvtr_qvtrDomain((RelationDomain)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_TYPED_MODEL:
				setQvtr_qvtrTypedModel((TypedModel)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODEL:
				return atl_atlModel != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_PATTERN:
				return atl_atlPattern != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__ATL_ATL_RULE:
				return atl_atlRule != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_DOMAIN:
				return qvtr_qvtrDomain != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_RELATION:
				return qvtr_qvtrRelation != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__QVTR_QVTR_TYPED_MODEL:
				return qvtr_qvtrTypedModel != null;
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
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
		result.append(" (status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //TC_mapInPatternImpl
