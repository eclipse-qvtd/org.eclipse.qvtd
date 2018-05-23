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

import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Matched Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRuleImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRuleImpl#getAtl_matchedRule <em>Atl matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRuleImpl#getPrimitive_ruleName <em>Primitive rule Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRuleImpl#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRuleImpl#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapMatchedRuleImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapMatchedRuleImpl extends MinimalEObjectImpl.Container implements TC_mapMatchedRule {
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
	 * The cached value of the '{@link #getAtl_matchedRule() <em>Atl matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_matchedRule()
	 * @generated
	 * @ordered
	 */
	protected MatchedRule atl_matchedRule;

	/**
	 * The default value of the '{@link #getPrimitive_ruleName() <em>Primitive rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_ruleName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_RULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_ruleName() <em>Primitive rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_ruleName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_ruleName = PRIMITIVE_RULE_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getQvtr_qvtrTransformation() <em>Qvtr qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation qvtr_qvtrTransformation;

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
	protected TC_mapMatchedRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_MATCHED_RULE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MatchedRule getAtl_matchedRule() {
		if (atl_matchedRule != null && atl_matchedRule.eIsProxy()) {
			InternalEObject oldAtl_matchedRule = atl_matchedRule;
			atl_matchedRule = (MatchedRule)eResolveProxy(oldAtl_matchedRule);
			if (atl_matchedRule != oldAtl_matchedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_MATCHED_RULE, oldAtl_matchedRule, atl_matchedRule));
			}
		}
		return atl_matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchedRule basicGetAtl_matchedRule() {
		return atl_matchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_matchedRule(MatchedRule newAtl_matchedRule) {
		MatchedRule oldAtl_matchedRule = atl_matchedRule;
		atl_matchedRule = newAtl_matchedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_MATCHED_RULE, oldAtl_matchedRule, atl_matchedRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive_ruleName() {
		return primitive_ruleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_ruleName(String newPrimitive_ruleName) {
		String oldPrimitive_ruleName = primitive_ruleName;
		primitive_ruleName = newPrimitive_ruleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__PRIMITIVE_RULE_NAME, oldPrimitive_ruleName, primitive_ruleName));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_RELATION, oldQvtr_qvtrRelation, qvtr_qvtrRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getQvtr_qvtrTransformation() {
		if (qvtr_qvtrTransformation != null && qvtr_qvtrTransformation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrTransformation = (InternalEObject)qvtr_qvtrTransformation;
			qvtr_qvtrTransformation = (RelationalTransformation)eResolveProxy(oldQvtr_qvtrTransformation);
			if (qvtr_qvtrTransformation != oldQvtr_qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
			}
		}
		return qvtr_qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetQvtr_qvtrTransformation() {
		return qvtr_qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrTransformation(RelationalTransformation newQvtr_qvtrTransformation) {
		RelationalTransformation oldQvtr_qvtrTransformation = qvtr_qvtrTransformation;
		qvtr_qvtrTransformation = newQvtr_qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_MATCHED_RULE:
				if (resolve) return getAtl_matchedRule();
				return basicGetAtl_matchedRule();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__PRIMITIVE_RULE_NAME:
				return getPrimitive_ruleName();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_RELATION:
				if (resolve) return getQvtr_qvtrRelation();
				return basicGetQvtr_qvtrRelation();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_TRANSFORMATION:
				if (resolve) return getQvtr_qvtrTransformation();
				return basicGetQvtr_qvtrTransformation();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_MATCHED_RULE:
				setAtl_matchedRule((MatchedRule)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__PRIMITIVE_RULE_NAME:
				setPrimitive_ruleName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_MATCHED_RULE:
				setAtl_matchedRule((MatchedRule)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__PRIMITIVE_RULE_NAME:
				setPrimitive_ruleName(PRIMITIVE_RULE_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_RELATION:
				setQvtr_qvtrRelation((Relation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__ATL_MATCHED_RULE:
				return atl_matchedRule != null;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__PRIMITIVE_RULE_NAME:
				return PRIMITIVE_RULE_NAME_EDEFAULT == null ? primitive_ruleName != null : !PRIMITIVE_RULE_NAME_EDEFAULT.equals(primitive_ruleName);
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_RELATION:
				return qvtr_qvtrRelation != null;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__QVTR_QVTR_TRANSFORMATION:
				return qvtr_qvtrTransformation != null;
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE__STATUS:
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
		result.append(" (primitive_ruleName: ");
		result.append(primitive_ruleName);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //TC_mapMatchedRuleImpl
