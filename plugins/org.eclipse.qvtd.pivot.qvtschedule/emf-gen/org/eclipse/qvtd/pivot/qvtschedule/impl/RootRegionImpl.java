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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduled Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl#getActiveRegions <em>Active Regions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl#getOwnedConnections <em>Owned Connections</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl#getOwnedLoadingRegion <em>Owned Loading Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl#getOwningScheduleModel <em>Owning Schedule Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl#getReferredTransformation <em>Referred Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootRegionImpl#getOwnedRootPartition <em>Owned Root Partition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootRegionImpl extends RegionImpl implements RootRegion {
	/**
	 * The cached value of the '{@link #getActiveRegions() <em>Active Regions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> activeRegions;

	/**
	 * The cached value of the '{@link #getOwnedConnections() <em>Owned Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> ownedConnections;

	/**
	 * The cached value of the '{@link #getOwnedLoadingRegion() <em>Owned Loading Region</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLoadingRegion()
	 * @generated
	 * @ordered
	 */
	protected LoadingRegion ownedLoadingRegion;

	/**
	 * The cached value of the '{@link #getReferredTransformation() <em>Referred Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTransformation()
	 * @generated
	 * @ordered
	 */
	protected Transformation referredTransformation;

	/**
	 * The cached value of the '{@link #getOwnedRootPartition() <em>Owned Root Partition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRootPartition()
	 * @generated
	 * @ordered
	 */
	protected RootPartition ownedRootPartition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.ROOT_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Region> getActiveRegions() {
		if (activeRegions == null) {
			activeRegions = new EObjectWithInverseResolvingEList<Region>(Region.class, this, QVTschedulePackage.ROOT_REGION__ACTIVE_REGIONS, QVTschedulePackage.REGION__ROOT_REGION);
		}
		return activeRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Connection> getOwnedConnections() {
		if (ownedConnections == null) {
			ownedConnections = new EObjectContainmentWithInverseEList<Connection>(Connection.class, this, QVTschedulePackage.ROOT_REGION__OWNED_CONNECTIONS, QVTschedulePackage.CONNECTION__OWNING_ROOT_REGION);
		}
		return ownedConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LoadingRegion getOwnedLoadingRegion() {
		return ownedLoadingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedLoadingRegion(LoadingRegion newOwnedLoadingRegion, NotificationChain msgs) {
		LoadingRegion oldOwnedLoadingRegion = ownedLoadingRegion;
		ownedLoadingRegion = newOwnedLoadingRegion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION, oldOwnedLoadingRegion, newOwnedLoadingRegion);
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
	public void setOwnedLoadingRegion(LoadingRegion newOwnedLoadingRegion) {
		if (newOwnedLoadingRegion != ownedLoadingRegion) {
			NotificationChain msgs = null;
			if (ownedLoadingRegion != null)
				msgs = ((InternalEObject)ownedLoadingRegion).eInverseRemove(this, QVTschedulePackage.LOADING_REGION__OWNING_ROOT_REGION, LoadingRegion.class, msgs);
			if (newOwnedLoadingRegion != null)
				msgs = ((InternalEObject)newOwnedLoadingRegion).eInverseAdd(this, QVTschedulePackage.LOADING_REGION__OWNING_ROOT_REGION, LoadingRegion.class, msgs);
			msgs = basicSetOwnedLoadingRegion(newOwnedLoadingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION, newOwnedLoadingRegion, newOwnedLoadingRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduleModel getOwningScheduleModel() {
		if (eContainerFeatureID() != QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduleModel(ScheduleModel newOwningScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduleModel, QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduleModel(ScheduleModel newOwningScheduleModel) {
		if (newOwningScheduleModel != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL && newOwningScheduleModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduleModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduleModel != null)
				msgs = ((InternalEObject)newOwningScheduleModel).eInverseAdd(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_ROOT_REGIONS, ScheduleModel.class, msgs);
			msgs = basicSetOwningScheduleModel(newOwningScheduleModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL, newOwningScheduleModel, newOwningScheduleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getReferredTransformation() {
		if (referredTransformation != null && referredTransformation.eIsProxy()) {
			InternalEObject oldReferredTransformation = (InternalEObject)referredTransformation;
			referredTransformation = (Transformation)eResolveProxy(oldReferredTransformation);
			if (referredTransformation != oldReferredTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.ROOT_REGION__REFERRED_TRANSFORMATION, oldReferredTransformation, referredTransformation));
			}
		}
		return referredTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation basicGetReferredTransformation() {
		return referredTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTransformation(Transformation newReferredTransformation) {
		Transformation oldReferredTransformation = referredTransformation;
		referredTransformation = newReferredTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ROOT_REGION__REFERRED_TRANSFORMATION, oldReferredTransformation, referredTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootPartition getOwnedRootPartition() {
		return ownedRootPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedRootPartition(RootPartition newOwnedRootPartition, NotificationChain msgs) {
		RootPartition oldOwnedRootPartition = ownedRootPartition;
		ownedRootPartition = newOwnedRootPartition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION, oldOwnedRootPartition, newOwnedRootPartition);
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
	public void setOwnedRootPartition(RootPartition newOwnedRootPartition) {
		if (newOwnedRootPartition != ownedRootPartition) {
			NotificationChain msgs = null;
			if (ownedRootPartition != null)
				msgs = ((InternalEObject)ownedRootPartition).eInverseRemove(this, QVTschedulePackage.ROOT_PARTITION__OWNING_ROOT_REGION, RootPartition.class, msgs);
			if (newOwnedRootPartition != null)
				msgs = ((InternalEObject)newOwnedRootPartition).eInverseAdd(this, QVTschedulePackage.ROOT_PARTITION__OWNING_ROOT_REGION, RootPartition.class, msgs);
			msgs = basicSetOwnedRootPartition(newOwnedRootPartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION, newOwnedRootPartition, newOwnedRootPartition));
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
			case QVTschedulePackage.ROOT_REGION__ACTIVE_REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getActiveRegions()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNED_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedConnections()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION:
				if (ownedLoadingRegion != null)
					msgs = ((InternalEObject)ownedLoadingRegion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION, null, msgs);
				return basicSetOwnedLoadingRegion((LoadingRegion)otherEnd, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScheduleModel((ScheduleModel)otherEnd, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION:
				if (ownedRootPartition != null)
					msgs = ((InternalEObject)ownedRootPartition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION, null, msgs);
				return basicSetOwnedRootPartition((RootPartition)otherEnd, msgs);
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
			case QVTschedulePackage.ROOT_REGION__ACTIVE_REGIONS:
				return ((InternalEList<?>)getActiveRegions()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNED_CONNECTIONS:
				return ((InternalEList<?>)getOwnedConnections()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION:
				return basicSetOwnedLoadingRegion(null, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL:
				return basicSetOwningScheduleModel(null, msgs);
			case QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION:
				return basicSetOwnedRootPartition(null, msgs);
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
			case QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_ROOT_REGIONS, ScheduleModel.class, msgs);
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
			case QVTschedulePackage.ROOT_REGION__ACTIVE_REGIONS:
				return getActiveRegions();
			case QVTschedulePackage.ROOT_REGION__OWNED_CONNECTIONS:
				return getOwnedConnections();
			case QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION:
				return getOwnedLoadingRegion();
			case QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel();
			case QVTschedulePackage.ROOT_REGION__REFERRED_TRANSFORMATION:
				if (resolve) return getReferredTransformation();
				return basicGetReferredTransformation();
			case QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION:
				return getOwnedRootPartition();
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
			case QVTschedulePackage.ROOT_REGION__ACTIVE_REGIONS:
				getActiveRegions().clear();
				getActiveRegions().addAll((Collection<? extends Region>)newValue);
				return;
			case QVTschedulePackage.ROOT_REGION__OWNED_CONNECTIONS:
				getOwnedConnections().clear();
				getOwnedConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION:
				setOwnedLoadingRegion((LoadingRegion)newValue);
				return;
			case QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)newValue);
				return;
			case QVTschedulePackage.ROOT_REGION__REFERRED_TRANSFORMATION:
				setReferredTransformation((Transformation)newValue);
				return;
			case QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION:
				setOwnedRootPartition((RootPartition)newValue);
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
			case QVTschedulePackage.ROOT_REGION__ACTIVE_REGIONS:
				getActiveRegions().clear();
				return;
			case QVTschedulePackage.ROOT_REGION__OWNED_CONNECTIONS:
				getOwnedConnections().clear();
				return;
			case QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION:
				setOwnedLoadingRegion((LoadingRegion)null);
				return;
			case QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)null);
				return;
			case QVTschedulePackage.ROOT_REGION__REFERRED_TRANSFORMATION:
				setReferredTransformation((Transformation)null);
				return;
			case QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION:
				setOwnedRootPartition((RootPartition)null);
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
			case QVTschedulePackage.ROOT_REGION__ACTIVE_REGIONS:
				return activeRegions != null && !activeRegions.isEmpty();
			case QVTschedulePackage.ROOT_REGION__OWNED_CONNECTIONS:
				return ownedConnections != null && !ownedConnections.isEmpty();
			case QVTschedulePackage.ROOT_REGION__OWNED_LOADING_REGION:
				return ownedLoadingRegion != null;
			case QVTschedulePackage.ROOT_REGION__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel() != null;
			case QVTschedulePackage.ROOT_REGION__REFERRED_TRANSFORMATION:
				return referredTransformation != null;
			case QVTschedulePackage.ROOT_REGION__OWNED_ROOT_PARTITION:
				return ownedRootPartition != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitRootRegion(this);
	}

	//	@Override
	//	protected void computeSymbolName(@NonNull SymbolNameBuilder s) {
	//		s.appendName(name);
	//	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableRegions() {
		LoadingRegion loadingRegion = getOwnedLoadingRegion();
		Iterable<@NonNull Region> mappingRegions = QVTscheduleUtil.getActiveRegions(this);
		if (loadingRegion != null) {
			return Iterables.concat(Collections.singletonList(loadingRegion), Iterables.filter(mappingRegions, QVTscheduleUtil.IsCallableRegionPredicate.INSTANCE));
		}
		else {
			return Iterables.filter(mappingRegions, QVTscheduleUtil.IsCallableRegionPredicate.INSTANCE);
		}
	}

	@Override
	public @NonNull List<Node> getHeadNodes() {
		return QVTscheduleConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @Nullable Region getNormalizedRegion(@NonNull Region region) {
		if (region == this) {
			return null;
		}
		for (Region invokingRegion; (invokingRegion = region.getContainingRootRegion()) != null; ) {
			if (invokingRegion == this) {
				return region;
			}
			region = invokingRegion;
		}
		return region;
	}

	@Override
	public final @NonNull String getGraphName() {
		return name + "-" + QVTscheduleConstants.GLABAL_MAPPING_NAME;
	}

	//	@Override
	//	protected @NonNull String getSymbolNamePrefix() {
	//		return "s_";
	//	}
} //RootRegionImpl