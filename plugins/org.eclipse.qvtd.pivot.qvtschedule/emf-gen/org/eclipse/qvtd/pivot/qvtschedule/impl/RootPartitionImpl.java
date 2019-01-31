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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;

import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootPartitionImpl#getOwningRootRegion <em>Owning Root Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootPartitionImpl#getLoadingPartition <em>Loading Partition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootPartitionImpl extends CompositePartitionImpl implements RootPartition {
	/**
	 * The number of structural features of the '<em>Root Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROOT_PARTITION_FEATURE_COUNT = CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 2;
	/**
	 * The number of operations of the '<em>Root Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROOT_PARTITION_OPERATION_COUNT = CompositePartitionImpl.COMPOSITE_PARTITION_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getLoadingPartition() <em>Loading Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadingPartition()
	 * @generated
	 * @ordered
	 */
	protected LoadingPartition loadingPartition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.ROOT_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootRegion getOwningRootRegion() {
		if (eContainerFeatureID() != (CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0)) return null;
		return (RootRegion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRootRegion(RootRegion newOwningRootRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRootRegion, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRootRegion(RootRegion newOwningRootRegion) {
		if (newOwningRootRegion != eInternalContainer() || (eContainerFeatureID() != (CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0) && newOwningRootRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRootRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRootRegion != null)
				msgs = ((InternalEObject)newOwningRootRegion).eInverseAdd(this, RegionImpl.REGION_FEATURE_COUNT + 5, RootRegion.class, msgs);
			msgs = basicSetOwningRootRegion(newOwningRootRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0, newOwningRootRegion, newOwningRootRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LoadingPartition getLoadingPartition() {
		if (loadingPartition != null && loadingPartition.eIsProxy()) {
			InternalEObject oldLoadingPartition = (InternalEObject)loadingPartition;
			loadingPartition = (LoadingPartition)eResolveProxy(oldLoadingPartition);
			if (loadingPartition != oldLoadingPartition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1, oldLoadingPartition, loadingPartition));
			}
		}
		return loadingPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadingPartition basicGetLoadingPartition() {
		return loadingPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoadingPartition(LoadingPartition newLoadingPartition) {
		LoadingPartition oldLoadingPartition = loadingPartition;
		loadingPartition = newLoadingPartition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1, oldLoadingPartition, loadingPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRootRegion((RootRegion)otherEnd, msgs);
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				return basicSetOwningRootRegion(null, msgs);
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, RegionImpl.REGION_FEATURE_COUNT + 5, RootRegion.class, msgs);
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				return getOwningRootRegion();
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				if (resolve) return getLoadingPartition();
				return basicGetLoadingPartition();
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				setOwningRootRegion((RootRegion)newValue);
				return;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				setLoadingPartition((LoadingPartition)newValue);
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				setOwningRootRegion((RootRegion)null);
				return;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				setLoadingPartition((LoadingPartition)null);
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				return getOwningRootRegion() != null;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				return loadingPartition != null;
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitRootPartition(this);
	}

} //RootPartitionImpl
