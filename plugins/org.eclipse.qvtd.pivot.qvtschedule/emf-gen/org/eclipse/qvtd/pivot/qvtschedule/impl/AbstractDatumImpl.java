/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl#getConsumingRegions <em>Consuming Regions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl#getProducingRegions <em>Producing Regions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractDatumImpl extends NamedElementImpl implements AbstractDatum {
	/**
	 * The cached value of the '{@link #getReferredTypedModel() <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel referredTypedModel;

	/**
	 * The cached value of the '{@link #getConsumingRegions() <em>Consuming Regions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumingRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleRegion> consumingRegions;

	/**
	 * The cached value of the '{@link #getProducingRegions() <em>Producing Regions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducingRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleRegion> producingRegions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractDatumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.ABSTRACT_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getReferredTypedModel() {
		if (referredTypedModel != null && referredTypedModel.eIsProxy()) {
			InternalEObject oldReferredTypedModel = (InternalEObject)referredTypedModel;
			referredTypedModel = (TypedModel)eResolveProxy(oldReferredTypedModel);
			if (referredTypedModel != oldReferredTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL, oldReferredTypedModel, referredTypedModel));
			}
		}
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetReferredTypedModel() {
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTypedModel(TypedModel newReferredTypedModel) {
		TypedModel oldReferredTypedModel = referredTypedModel;
		referredTypedModel = newReferredTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL, oldReferredTypedModel, referredTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RuleRegion> getConsumingRegions() {
		if (consumingRegions == null) {
			consumingRegions = new EObjectWithInverseEList.ManyInverse<RuleRegion>(RuleRegion.class, this, QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS, QVTschedulePackage.RULE_REGION__CONSUMED_DATUMS);
		}
		return consumingRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RuleRegion> getProducingRegions() {
		if (producingRegions == null) {
			producingRegions = new EObjectWithInverseEList.ManyInverse<RuleRegion>(RuleRegion.class, this, QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS, QVTschedulePackage.RULE_REGION__PRODUCED_DATUMS);
		}
		return producingRegions;
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
			case QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConsumingRegions()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProducingRegions()).basicAdd(otherEnd, msgs);
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
			case QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS:
				return ((InternalEList<?>)getConsumingRegions()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS:
				return ((InternalEList<?>)getProducingRegions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				if (resolve) return getReferredTypedModel();
				return basicGetReferredTypedModel();
			case QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS:
				return getConsumingRegions();
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS:
				return getProducingRegions();
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
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				setReferredTypedModel((TypedModel)newValue);
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS:
				getConsumingRegions().clear();
				getConsumingRegions().addAll((Collection<? extends RuleRegion>)newValue);
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS:
				getProducingRegions().clear();
				getProducingRegions().addAll((Collection<? extends RuleRegion>)newValue);
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
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				setReferredTypedModel((TypedModel)null);
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS:
				getConsumingRegions().clear();
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS:
				getProducingRegions().clear();
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
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				return referredTypedModel != null;
			case QVTschedulePackage.ABSTRACT_DATUM__CONSUMING_REGIONS:
				return consumingRegions != null && !consumingRegions.isEmpty();
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCING_REGIONS:
				return producingRegions != null && !producingRegions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractDatumImpl
