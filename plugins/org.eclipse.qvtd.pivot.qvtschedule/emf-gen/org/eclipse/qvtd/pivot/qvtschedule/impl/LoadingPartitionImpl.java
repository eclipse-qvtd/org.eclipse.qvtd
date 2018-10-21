/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loading Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingPartitionImpl#getReferredLoadingRegion <em>Referred Loading Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadingPartitionImpl extends MappingPartitionImpl implements LoadingPartition {
	/**
	 * The cached value of the '{@link #getReferredLoadingRegion() <em>Referred Loading Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredLoadingRegion()
	 * @generated
	 * @ordered
	 */
	protected LoadingRegion referredLoadingRegion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadingPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.LOADING_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LoadingRegion getReferredLoadingRegion() {
		if (referredLoadingRegion != null && referredLoadingRegion.eIsProxy()) {
			InternalEObject oldReferredLoadingRegion = (InternalEObject)referredLoadingRegion;
			referredLoadingRegion = (LoadingRegion)eResolveProxy(oldReferredLoadingRegion);
			if (referredLoadingRegion != oldReferredLoadingRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION, oldReferredLoadingRegion, referredLoadingRegion));
			}
		}
		return referredLoadingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadingRegion basicGetReferredLoadingRegion() {
		return referredLoadingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredLoadingRegion(LoadingRegion newReferredLoadingRegion, NotificationChain msgs) {
		LoadingRegion oldReferredLoadingRegion = referredLoadingRegion;
		referredLoadingRegion = newReferredLoadingRegion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION, oldReferredLoadingRegion, newReferredLoadingRegion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredLoadingRegion(LoadingRegion newReferredLoadingRegion) {
		if (newReferredLoadingRegion != referredLoadingRegion) {
			NotificationChain msgs = null;
			if (referredLoadingRegion != null)
				msgs = ((InternalEObject)referredLoadingRegion).eInverseRemove(this, QVTschedulePackage.LOADING_REGION__LOADING_PARTITION, LoadingRegion.class, msgs);
			if (newReferredLoadingRegion != null)
				msgs = ((InternalEObject)newReferredLoadingRegion).eInverseAdd(this, QVTschedulePackage.LOADING_REGION__LOADING_PARTITION, LoadingRegion.class, msgs);
			msgs = basicSetReferredLoadingRegion(newReferredLoadingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION, newReferredLoadingRegion, newReferredLoadingRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION:
				if (referredLoadingRegion != null)
					msgs = ((InternalEObject)referredLoadingRegion).eInverseRemove(this, QVTschedulePackage.LOADING_REGION__LOADING_PARTITION, LoadingRegion.class, msgs);
				return basicSetReferredLoadingRegion((LoadingRegion)otherEnd, msgs);
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
			case QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION:
				return basicSetReferredLoadingRegion(null, msgs);
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
			case QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION:
				if (resolve) return getReferredLoadingRegion();
				return basicGetReferredLoadingRegion();
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
			case QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION:
				setReferredLoadingRegion((LoadingRegion)newValue);
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
			case QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION:
				setReferredLoadingRegion((LoadingRegion)null);
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
			case QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION:
				return referredLoadingRegion != null;
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitLoadingPartition(this);
	}

	@Override
	public Region basicGetRegion() {
		return getReferredLoadingRegion();
	}

	@Override
	protected void computeSymbolName(@NonNull SymbolNameBuilder s) {
		s.appendString(QVTscheduleUtil.ROOT_MAPPING_NAME);
	}

	@Override
	public List<Node> getHeadNodes() {
		return QVTscheduleUtil.Internal.getHeadNodesList(QVTscheduleUtil.getRegion(this));
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return QVTscheduleUtil.getOwnedEdges(QVTscheduleUtil.getRegion(this));
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return QVTscheduleUtil.getOwnedNodes(QVTscheduleUtil.getRegion(this));
	}

	@Override
	protected @NonNull String getSymbolNamePrefix() {
		return "r_";
	}

} //LoadingPartitionImpl
