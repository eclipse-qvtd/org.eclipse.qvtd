/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl#getReferredRule <em>Referred Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl#getProducedDatums <em>Produced Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl#getConsumedDatums <em>Consumed Datums</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleRegionImpl extends MappingRegionImpl implements RuleRegion {
	/**
	 * The cached value of the '{@link #getReferredRule() <em>Referred Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRule()
	 * @generated
	 * @ordered
	 */
	protected Rule referredRule;

	/**
	 * The cached value of the '{@link #getProducedDatums() <em>Produced Datums</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> producedDatums;

	/**
	 * The cached value of the '{@link #getConsumedDatums() <em>Consumed Datums</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumedDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> consumedDatums;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.RULE_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.RULE_REGION__REFERRED_RULE:
				if (resolve) return getReferredRule();
				return basicGetReferredRule();
			case QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS:
				return getProducedDatums();
			case QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS:
				return getConsumedDatums();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTschedulePackage.RULE_REGION__REFERRED_RULE:
				setReferredRule((Rule)newValue);
				return;
			case QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS:
				getProducedDatums().clear();
				getProducedDatums().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS:
				getConsumedDatums().clear();
				getConsumedDatums().addAll((Collection<? extends AbstractDatum>)newValue);
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
			case QVTschedulePackage.RULE_REGION__REFERRED_RULE:
				setReferredRule((Rule)null);
				return;
			case QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS:
				getProducedDatums().clear();
				return;
			case QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS:
				getConsumedDatums().clear();
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
			case QVTschedulePackage.RULE_REGION__REFERRED_RULE:
				return referredRule != null;
			case QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS:
				return producedDatums != null && !producedDatums.isEmpty();
			case QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS:
				return consumedDatums != null && !consumedDatums.isEmpty();
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitRuleRegion(this);
	}

	/**
	 * The node for each navigable VariableDeclaration.
	 */
	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> variable2node = new HashMap<>();

	@Override
	public void addVariableNode(@NonNull VariableDeclaration variable, @NonNull Node node) {
		variable2node.put(variable, node);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		return referredRule != null ? referredRule.getName() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getReferredRule() {
		if (referredRule != null && referredRule.eIsProxy()) {
			InternalEObject oldReferredRule = (InternalEObject)referredRule;
			referredRule = (Rule)eResolveProxy(oldReferredRule);
			if (referredRule != oldReferredRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.RULE_REGION__REFERRED_RULE, oldReferredRule, referredRule));
			}
		}
		return referredRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetReferredRule() {
		return referredRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredRule(Rule newReferredRule) {
		Rule oldReferredRule = referredRule;
		referredRule = newReferredRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.RULE_REGION__REFERRED_RULE, oldReferredRule, referredRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractDatum> getProducedDatums() {
		if (producedDatums == null) {
			producedDatums = new EObjectWithInverseEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS, QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS);
		}
		return producedDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractDatum> getConsumedDatums() {
		if (consumedDatums == null) {
			consumedDatums = new EObjectWithInverseEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS, QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS);
		}
		return consumedDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProducedDatums()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConsumedDatums()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS:
				return ((InternalEList<?>)getProducedDatums()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS:
				return ((InternalEList<?>)getConsumedDatums()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public @Nullable Node getNode(@NonNull TypedElement typedElement) {
		return variable2node.get(typedElement);
	}
} //BasicMappingRegionImpl
