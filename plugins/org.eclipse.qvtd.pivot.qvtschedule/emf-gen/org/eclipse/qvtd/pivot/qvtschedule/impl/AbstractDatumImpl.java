/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingAction;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl#getProducedByActions <em>Produced By Actions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl#getRequiredByActions <em>Required By Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractDatumImpl extends ElementImpl implements AbstractDatum {
	/**
	 * The cached value of the '{@link #getProducedByActions() <em>Produced By Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedByActions()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingAction> producedByActions;

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
	 * The cached value of the '{@link #getRequiredByActions() <em>Required By Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredByActions()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingAction> requiredByActions;

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
	public EList<MappingAction> getProducedByActions() {
		if (producedByActions == null) {
			producedByActions = new EObjectWithInverseResolvingEList.ManyInverse<MappingAction>(MappingAction.class, this, QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS, QVTschedulePackage.MAPPING_ACTION__PRODUCED_DATUMS);
		}
		return producedByActions;
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
	public EList<MappingAction> getRequiredByActions() {
		if (requiredByActions == null) {
			requiredByActions = new EObjectWithInverseResolvingEList.ManyInverse<MappingAction>(MappingAction.class, this, QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS, QVTschedulePackage.MAPPING_ACTION__REQUIRED_DATUMS);
		}
		return requiredByActions;
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
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProducedByActions()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredByActions()).basicAdd(otherEnd, msgs);
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
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS:
				return ((InternalEList<?>)getProducedByActions()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS:
				return ((InternalEList<?>)getRequiredByActions()).basicRemove(otherEnd, msgs);
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
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS:
				return getProducedByActions();
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				if (resolve) return getReferredTypedModel();
				return basicGetReferredTypedModel();
			case QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS:
				return getRequiredByActions();
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
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS:
				getProducedByActions().clear();
				getProducedByActions().addAll((Collection<? extends MappingAction>)newValue);
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				setReferredTypedModel((TypedModel)newValue);
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS:
				getRequiredByActions().clear();
				getRequiredByActions().addAll((Collection<? extends MappingAction>)newValue);
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
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS:
				getProducedByActions().clear();
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				setReferredTypedModel((TypedModel)null);
				return;
			case QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS:
				getRequiredByActions().clear();
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
			case QVTschedulePackage.ABSTRACT_DATUM__PRODUCED_BY_ACTIONS:
				return producedByActions != null && !producedByActions.isEmpty();
			case QVTschedulePackage.ABSTRACT_DATUM__REFERRED_TYPED_MODEL:
				return referredTypedModel != null;
			case QVTschedulePackage.ABSTRACT_DATUM__REQUIRED_BY_ACTIONS:
				return requiredByActions != null && !requiredByActions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractDatumImpl
