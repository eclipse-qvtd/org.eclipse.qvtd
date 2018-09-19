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
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl#getHeadNodes <em>Head Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl#getOwningScheduleModel <em>Owning Schedule Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingRegionImpl extends RegionImpl implements MappingRegion {
	/**
	 * The cached value of the '{@link #getHeadNodes() <em>Head Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> headNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MAPPING_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Node> getHeadNodes() {
		if (headNodes == null) {
			headNodes = new EObjectResolvingEList<Node>(Node.class, this, QVTschedulePackage.MAPPING_REGION__HEAD_NODES);
		}
		return headNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduleModel getOwningScheduleModel() {
		if (eContainerFeatureID() != QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduleModel(ScheduleModel newOwningScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduleModel, QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduleModel(ScheduleModel newOwningScheduleModel) {
		if (newOwningScheduleModel != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL && newOwningScheduleModel != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduleModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduleModel != null)
				msgs = ((InternalEObject)newOwningScheduleModel).eInverseAdd(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS, ScheduleModel.class, msgs);
			msgs = basicSetOwningScheduleModel(newOwningScheduleModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL, newOwningScheduleModel, newOwningScheduleModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScheduleModel((ScheduleModel)otherEnd, msgs);
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
			case QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL:
				return basicSetOwningScheduleModel(null, msgs);
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
			case QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS, ScheduleModel.class, msgs);
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
			case QVTschedulePackage.MAPPING_REGION__HEAD_NODES:
				return getHeadNodes();
			case QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel();
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
			case QVTschedulePackage.MAPPING_REGION__HEAD_NODES:
				getHeadNodes().clear();
				getHeadNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)newValue);
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
			case QVTschedulePackage.MAPPING_REGION__HEAD_NODES:
				getHeadNodes().clear();
				return;
			case QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL:
				setOwningScheduleModel((ScheduleModel)null);
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
			case QVTschedulePackage.MAPPING_REGION__HEAD_NODES:
				return headNodes != null && !headNodes.isEmpty();
			case QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL:
				return getOwningScheduleModel() != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull String getColor() {
		return "green";
	}

	@Override
	public @Nullable ScheduledRegion getContainingScheduledRegion() {
		return getScheduledRegion();
	}

	@Override
	public void resetHead(@NonNull Node headNode) {
		boolean wasRemoved = getHeadNodes().remove(headNode);
		assert wasRemoved;
		headNode.resetHead();
	}
} //MappingRegionImpl
