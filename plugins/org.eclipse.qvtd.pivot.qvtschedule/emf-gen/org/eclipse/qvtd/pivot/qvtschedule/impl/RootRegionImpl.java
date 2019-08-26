/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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

import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
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
	 * The number of structural features of the '<em>Root Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROOT_REGION_FEATURE_COUNT = RegionImpl.REGION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Root Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROOT_REGION_OPERATION_COUNT = RegionImpl.REGION_OPERATION_COUNT + 0;

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
			activeRegions = new EObjectWithInverseResolvingEList<Region>(Region.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4);
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
			ownedConnections = new EObjectContainmentWithInverseEList<Connection>(Connection.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7, oldOwnedLoadingRegion, newOwnedLoadingRegion);
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
				msgs = ((InternalEObject)ownedLoadingRegion).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, LoadingRegion.class, msgs);
			if (newOwnedLoadingRegion != null)
				msgs = ((InternalEObject)newOwnedLoadingRegion).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, LoadingRegion.class, msgs);
			msgs = basicSetOwnedLoadingRegion(newOwnedLoadingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7, newOwnedLoadingRegion, newOwnedLoadingRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduleModel getOwningScheduleModel() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8)) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduleModel(ScheduleModel newOwningScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduleModel, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduleModel(ScheduleModel newOwningScheduleModel) {
		if (newOwningScheduleModel != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8) && newOwningScheduleModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduleModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduleModel != null)
				msgs = ((InternalEObject)newOwningScheduleModel).eInverseAdd(this, ModelImpl.MODEL_FEATURE_COUNT + 3, ScheduleModel.class, msgs);
			msgs = basicSetOwningScheduleModel(newOwningScheduleModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8, newOwningScheduleModel, newOwningScheduleModel));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9, oldReferredTransformation, referredTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9, oldReferredTransformation, referredTransformation));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10, oldOwnedRootPartition, newOwnedRootPartition);
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
				msgs = ((InternalEObject)ownedRootPartition).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, RootPartition.class, msgs);
			if (newOwnedRootPartition != null)
				msgs = ((InternalEObject)newOwnedRootPartition).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, RootPartition.class, msgs);
			msgs = basicSetOwnedRootPartition(newOwnedRootPartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10, newOwnedRootPartition, newOwnedRootPartition));
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getActiveRegions()).basicAdd(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedConnections()).basicAdd(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				if (ownedLoadingRegion != null)
					msgs = ((InternalEObject)ownedLoadingRegion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7), null, msgs);
				return basicSetOwnedLoadingRegion((LoadingRegion)otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScheduleModel((ScheduleModel)otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
				if (ownedRootPartition != null)
					msgs = ((InternalEObject)ownedRootPartition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10), null, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return ((InternalEList<?>)getActiveRegions()).basicRemove(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return ((InternalEList<?>)getOwnedConnections()).basicRemove(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return basicSetOwnedLoadingRegion(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				return basicSetOwningScheduleModel(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				return eInternalContainer().eInverseRemove(this, ModelImpl.MODEL_FEATURE_COUNT + 3, ScheduleModel.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return getActiveRegions();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return getOwnedConnections();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return getOwnedLoadingRegion();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				return getOwningScheduleModel();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				if (resolve) return getReferredTransformation();
				return basicGetReferredTransformation();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				getActiveRegions().clear();
				getActiveRegions().addAll((Collection<? extends Region>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				getOwnedConnections().clear();
				getOwnedConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				setOwnedLoadingRegion((LoadingRegion)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				setOwningScheduleModel((ScheduleModel)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				setReferredTransformation((Transformation)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				getActiveRegions().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				getOwnedConnections().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				setOwnedLoadingRegion((LoadingRegion)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				setOwningScheduleModel((ScheduleModel)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				setReferredTransformation((Transformation)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return activeRegions != null && !activeRegions.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return ownedConnections != null && !ownedConnections.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return ownedLoadingRegion != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				return getOwningScheduleModel() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				return referredTransformation != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
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
		try {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitRootRegion(this);
		}
		catch (ClassCastException e) {
			return super.accept(visitor);
		}
	}

	//	@Override
	//	protected void computeSymbolName(@NonNull SymbolNameBuilder s) {
	//		s.appendName(name);
	//	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableRegions() {
		List<@NonNull Region> callableRegions = new ArrayList<>();
		LoadingRegion loadingRegion = getOwnedLoadingRegion();
		if (loadingRegion != null) {
			callableRegions.add(loadingRegion);
		}
		for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(this)) {
			callableRegions.add(region);
		}
		return callableRegions;
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
		return name + QVTscheduleConstants.GLABAL_MAPPING_NAME;
	}

	//	@Override
	//	protected @NonNull String getSymbolNamePrefix() {
	//		return "s_";
	//	}
} //RootRegionImpl
