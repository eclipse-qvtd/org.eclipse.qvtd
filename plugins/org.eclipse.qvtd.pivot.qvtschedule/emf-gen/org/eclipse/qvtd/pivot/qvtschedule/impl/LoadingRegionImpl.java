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
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl#getOwningScheduledRegion <em>Owning Scheduled Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadingRegionImpl extends RegionImpl implements LoadingRegion {
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
	public LoadingPartition getLoadingPartition() {
		if (loadingPartition != null && loadingPartition.eIsProxy()) {
			InternalEObject oldLoadingPartition = (InternalEObject)loadingPartition;
			loadingPartition = (LoadingPartition)eResolveProxy(oldLoadingPartition);
			if (loadingPartition != oldLoadingPartition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.LOADING_REGION__LOADING_PARTITION, oldLoadingPartition, loadingPartition));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.LOADING_REGION__LOADING_PARTITION, oldLoadingPartition, newLoadingPartition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadingPartition(LoadingPartition newLoadingPartition) {
		if (newLoadingPartition != loadingPartition) {
			NotificationChain msgs = null;
			if (loadingPartition != null)
				msgs = ((InternalEObject)loadingPartition).eInverseRemove(this, QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION, LoadingPartition.class, msgs);
			if (newLoadingPartition != null)
				msgs = ((InternalEObject)newLoadingPartition).eInverseAdd(this, QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION, LoadingPartition.class, msgs);
			msgs = basicSetLoadingPartition(newLoadingPartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.LOADING_REGION__LOADING_PARTITION, newLoadingPartition, newLoadingPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduledRegion getOwningScheduledRegion() {
		if (eContainerFeatureID() != QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION) return null;
		return (ScheduledRegion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.LOADING_REGION__LOADING_PARTITION:
				if (loadingPartition != null)
					msgs = ((InternalEObject)loadingPartition).eInverseRemove(this, QVTschedulePackage.LOADING_PARTITION__REFERRED_LOADING_REGION, LoadingPartition.class, msgs);
				return basicSetLoadingPartition((LoadingPartition)otherEnd, msgs);
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScheduledRegion((ScheduledRegion)otherEnd, msgs);
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
			case QVTschedulePackage.LOADING_REGION__LOADING_PARTITION:
				return basicSetLoadingPartition(null, msgs);
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION:
				return basicSetOwningScheduledRegion(null, msgs);
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
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.SCHEDULED_REGION__OWNED_LOADING_REGION, ScheduledRegion.class, msgs);
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
			case QVTschedulePackage.LOADING_REGION__LOADING_PARTITION:
				if (resolve) return getLoadingPartition();
				return basicGetLoadingPartition();
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION:
				return getOwningScheduledRegion();
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
			case QVTschedulePackage.LOADING_REGION__LOADING_PARTITION:
				setLoadingPartition((LoadingPartition)newValue);
				return;
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION:
				setOwningScheduledRegion((ScheduledRegion)newValue);
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
			case QVTschedulePackage.LOADING_REGION__LOADING_PARTITION:
				setLoadingPartition((LoadingPartition)null);
				return;
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION:
				setOwningScheduledRegion((ScheduledRegion)null);
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
			case QVTschedulePackage.LOADING_REGION__LOADING_PARTITION:
				return loadingPartition != null;
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION:
				return getOwningScheduledRegion() != null;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduledRegion(ScheduledRegion newOwningScheduledRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduledRegion, QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduledRegion(ScheduledRegion newOwningScheduledRegion) {
		if (newOwningScheduledRegion != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION && newOwningScheduledRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduledRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduledRegion != null)
				msgs = ((InternalEObject)newOwningScheduledRegion).eInverseAdd(this, QVTschedulePackage.SCHEDULED_REGION__OWNED_LOADING_REGION, ScheduledRegion.class, msgs);
			msgs = basicSetOwningScheduledRegion(newOwningScheduledRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION, newOwningScheduledRegion, newOwningScheduledRegion));
	}

	@Override
	public ScheduledRegion getContainingScheduledRegion() {
		return getOwningScheduledRegion();
	}
} //RootCompositionRegionImpl
