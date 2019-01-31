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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Composition Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl#getLoadingPartition <em>Loading Partition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl#getOwningRootRegion <em>Owning Root Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadingRegionImpl extends RegionImpl implements LoadingRegion {
	/**
	 * The number of structural features of the '<em>Loading Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOADING_REGION_FEATURE_COUNT = RegionImpl.REGION_FEATURE_COUNT + 2;
	/**
	 * The number of operations of the '<em>Loading Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOADING_REGION_OPERATION_COUNT = RegionImpl.REGION_OPERATION_COUNT + 0;
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
	protected LoadingRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.LOADING_REGION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RegionImpl.REGION_FEATURE_COUNT + 0, oldLoadingPartition, loadingPartition));
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
	public NotificationChain basicSetLoadingPartition(LoadingPartition newLoadingPartition, NotificationChain msgs) {
		LoadingPartition oldLoadingPartition = loadingPartition;
		loadingPartition = newLoadingPartition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegionImpl.REGION_FEATURE_COUNT + 0, oldLoadingPartition, newLoadingPartition);
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
	public void setLoadingPartition(LoadingPartition newLoadingPartition) {
		if (newLoadingPartition != loadingPartition) {
			NotificationChain msgs = null;
			if (loadingPartition != null)
				msgs = ((InternalEObject)loadingPartition).eInverseRemove(this, MappingPartitionImpl.MAPPING_PARTITION_FEATURE_COUNT + 0, LoadingPartition.class, msgs);
			if (newLoadingPartition != null)
				msgs = ((InternalEObject)newLoadingPartition).eInverseAdd(this, MappingPartitionImpl.MAPPING_PARTITION_FEATURE_COUNT + 0, LoadingPartition.class, msgs);
			msgs = basicSetLoadingPartition(newLoadingPartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionImpl.REGION_FEATURE_COUNT + 0, newLoadingPartition, newLoadingPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootRegion getOwningRootRegion() {
		if (eContainerFeatureID() != (RegionImpl.REGION_FEATURE_COUNT + 1)) return null;
		return (RootRegion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRootRegion(RootRegion newOwningRootRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRootRegion, RegionImpl.REGION_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRootRegion(RootRegion newOwningRootRegion) {
		if (newOwningRootRegion != eInternalContainer() || (eContainerFeatureID() != (RegionImpl.REGION_FEATURE_COUNT + 1) && newOwningRootRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRootRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRootRegion != null)
				msgs = ((InternalEObject)newOwningRootRegion).eInverseAdd(this, RegionImpl.REGION_FEATURE_COUNT + 2, RootRegion.class, msgs);
			msgs = basicSetOwningRootRegion(newOwningRootRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegionImpl.REGION_FEATURE_COUNT + 1, newOwningRootRegion, newOwningRootRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegionImpl.REGION_FEATURE_COUNT + 0:
				if (loadingPartition != null)
					msgs = ((InternalEObject)loadingPartition).eInverseRemove(this, MappingPartitionImpl.MAPPING_PARTITION_FEATURE_COUNT + 0, LoadingPartition.class, msgs);
				return basicSetLoadingPartition((LoadingPartition)otherEnd, msgs);
			case RegionImpl.REGION_FEATURE_COUNT + 1:
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
			case RegionImpl.REGION_FEATURE_COUNT + 0:
				return basicSetLoadingPartition(null, msgs);
			case RegionImpl.REGION_FEATURE_COUNT + 1:
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
			case RegionImpl.REGION_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, RegionImpl.REGION_FEATURE_COUNT + 2, RootRegion.class, msgs);
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
			case RegionImpl.REGION_FEATURE_COUNT + 0:
				if (resolve) return getLoadingPartition();
				return basicGetLoadingPartition();
			case RegionImpl.REGION_FEATURE_COUNT + 1:
				return getOwningRootRegion();
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
			case RegionImpl.REGION_FEATURE_COUNT + 0:
				setLoadingPartition((LoadingPartition)newValue);
				return;
			case RegionImpl.REGION_FEATURE_COUNT + 1:
				setOwningRootRegion((RootRegion)newValue);
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
			case RegionImpl.REGION_FEATURE_COUNT + 0:
				setLoadingPartition((LoadingPartition)null);
				return;
			case RegionImpl.REGION_FEATURE_COUNT + 1:
				setOwningRootRegion((RootRegion)null);
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
			case RegionImpl.REGION_FEATURE_COUNT + 0:
				return loadingPartition != null;
			case RegionImpl.REGION_FEATURE_COUNT + 1:
				return getOwningRootRegion() != null;
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitLoadingRegion(this);
	}

	//	@Override
	//	protected void computeSymbolName(@NonNull SymbolNameBuilder s) {
	//		s.appendString(QVTscheduleUtil.ROOT_MAPPING_NAME);
	//	}

	@Override
	public @NonNull List<Node> getHeadNodes() {
		return QVTscheduleConstants.EMPTY_NODE_LIST;
	}

	//	@Override
	//	protected @NonNull String getSymbolNamePrefix() {
	//		return "r_";
	//	}

	@Override
	public boolean isLoadingRegion() {
		return true;
	}

	@Override
	public RootRegion getContainingRootRegion() {
		return getOwningRootRegion();
	}
} //RootCompositionRegionImpl
