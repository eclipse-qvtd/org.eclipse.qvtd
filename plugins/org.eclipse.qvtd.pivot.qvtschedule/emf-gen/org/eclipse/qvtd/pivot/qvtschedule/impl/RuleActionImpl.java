/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleAction;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleActionImpl#getOwningScheduleModel <em>Owning Schedule Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleActionImpl#getProducedDatums <em>Produced Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleActionImpl#getReferredRule <em>Referred Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleActionImpl#getRequiredDatums <em>Required Datums</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleActionImpl extends ElementImpl implements RuleAction {
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
	 * The cached value of the '{@link #getReferredRule() <em>Referred Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRule()
	 * @generated
	 * @ordered
	 */
	protected Rule referredRule;

	/**
	 * The cached value of the '{@link #getRequiredDatums() <em>Required Datums</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDatum> requiredDatums;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.RULE_ACTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.RULE_ACTION__REFERRED_RULE, oldReferredRule, referredRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.RULE_ACTION__REFERRED_RULE, oldReferredRule, referredRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractDatum> getRequiredDatums() {
		if (requiredDatums == null) {
			requiredDatums = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, QVTschedulePackage.RULE_ACTION__REQUIRED_DATUMS, QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS);
		}
		return requiredDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduleModel getOwningScheduleModel() {
		if (eContainerFeatureID() != QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduleModel(ScheduleModel newOwningScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduleModel, QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduleModel(ScheduleModel newOwningScheduleModel) {
		if (newOwningScheduleModel != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL && newOwningScheduleModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduleModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduleModel != null)
				msgs = ((InternalEObject)newOwningScheduleModel).eInverseAdd(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_RULE_ACTIONS, ScheduleModel.class, msgs);
			msgs = basicSetOwningScheduleModel(newOwningScheduleModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL, newOwningScheduleModel, newOwningScheduleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractDatum> getProducedDatums() {
		if (producedDatums == null) {
			producedDatums = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDatum>(AbstractDatum.class, this, QVTschedulePackage.RULE_ACTION__PRODUCED_DATUMS, QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS);
		}
		return producedDatums;
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
			case QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScheduleModel((ScheduleModel)otherEnd, msgs);
			case QVTschedulePackage.RULE_ACTION__PRODUCED_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProducedDatums()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.RULE_ACTION__REQUIRED_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredDatums()).basicAdd(otherEnd, msgs);
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
			case QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL:
				return basicSetOwningScheduleModel(null, msgs);
			case QVTschedulePackage.RULE_ACTION__PRODUCED_DATUMS:
				return ((InternalEList<?>)getProducedDatums()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.RULE_ACTION__REQUIRED_DATUMS:
				return ((InternalEList<?>)getRequiredDatums()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_RULE_ACTIONS, ScheduleModel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel();
			case QVTschedulePackage.RULE_ACTION__PRODUCED_DATUMS:
				return getProducedDatums();
			case QVTschedulePackage.RULE_ACTION__REFERRED_RULE:
				if (resolve) return getReferredRule();
				return basicGetReferredRule();
			case QVTschedulePackage.RULE_ACTION__REQUIRED_DATUMS:
				return getRequiredDatums();
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
			case QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)newValue);
				return;
			case QVTschedulePackage.RULE_ACTION__PRODUCED_DATUMS:
				getProducedDatums().clear();
				getProducedDatums().addAll((Collection<? extends AbstractDatum>)newValue);
				return;
			case QVTschedulePackage.RULE_ACTION__REFERRED_RULE:
				setReferredRule((Rule)newValue);
				return;
			case QVTschedulePackage.RULE_ACTION__REQUIRED_DATUMS:
				getRequiredDatums().clear();
				getRequiredDatums().addAll((Collection<? extends AbstractDatum>)newValue);
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
			case QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)null);
				return;
			case QVTschedulePackage.RULE_ACTION__PRODUCED_DATUMS:
				getProducedDatums().clear();
				return;
			case QVTschedulePackage.RULE_ACTION__REFERRED_RULE:
				setReferredRule((Rule)null);
				return;
			case QVTschedulePackage.RULE_ACTION__REQUIRED_DATUMS:
				getRequiredDatums().clear();
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
			case QVTschedulePackage.RULE_ACTION__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel() != null;
			case QVTschedulePackage.RULE_ACTION__PRODUCED_DATUMS:
				return producedDatums != null && !producedDatums.isEmpty();
			case QVTschedulePackage.RULE_ACTION__REFERRED_RULE:
				return referredRule != null;
			case QVTschedulePackage.RULE_ACTION__REQUIRED_DATUMS:
				return requiredDatums != null && !requiredDatums.isEmpty();
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitRuleAction(this);
	}

	@Override
	public String toString() {
		return referredRule.toString();
	}
} //MappingActionImpl
