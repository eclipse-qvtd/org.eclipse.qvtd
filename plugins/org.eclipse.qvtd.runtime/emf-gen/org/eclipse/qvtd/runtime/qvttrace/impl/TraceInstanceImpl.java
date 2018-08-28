/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.runtime.qvttrace.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;
import org.eclipse.qvtd.runtime.qvttrace.TraceInstance;
import org.eclipse.qvtd.runtime.qvttrace.TraceModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.runtime.qvttrace.impl.TraceInstanceImpl#getOwningModel <em>Owning Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TraceInstanceImpl extends TraceElementImpl implements TraceInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTtracePackage.Literals.TRACE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TraceModel getOwningModel() {
		if (eContainerFeatureID() != QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL) return null;
		return (TraceModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningModel(TraceModel newOwningModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningModel, QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningModel(TraceModel newOwningModel) {
		if (newOwningModel != eInternalContainer() || (eContainerFeatureID() != QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL && newOwningModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningModel != null)
				msgs = ((InternalEObject)newOwningModel).eInverseAdd(this, QVTtracePackage.TRACE_MODEL__OWNED_TRACES, TraceModel.class, msgs);
			msgs = basicSetOwningModel(newOwningModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL, newOwningModel, newOwningModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningModel((TraceModel)otherEnd, msgs);
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
			case QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL:
				return basicSetOwningModel(null, msgs);
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
			case QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL:
				return eInternalContainer().eInverseRemove(this, QVTtracePackage.TRACE_MODEL__OWNED_TRACES, TraceModel.class, msgs);
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
			case QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL:
				return getOwningModel();
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
			case QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL:
				setOwningModel((TraceModel)newValue);
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
			case QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL:
				setOwningModel((TraceModel)null);
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
			case QVTtracePackage.TRACE_INSTANCE__OWNING_MODEL:
				return getOwningModel() != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String getName() {
		return "FIXME-default-name";
	}
} //TraceInstanceImpl
