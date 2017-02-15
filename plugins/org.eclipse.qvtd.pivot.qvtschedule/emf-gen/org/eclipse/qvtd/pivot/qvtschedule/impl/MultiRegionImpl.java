/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MultiRegionImpl#getScheduleModel <em>Schedule Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiRegionImpl extends ElementImpl implements MultiRegion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MULTI_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduleModel getScheduleModel() {
		if (eContainerFeatureID() != QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL) return null;
		return (ScheduleModel)eInternalContainer();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitMultiRegion(this);
	}

	/**
	 * The oclAsType(Type) casting property for each cast in use.
	 */
	//	private final @NonNull Map<Type, Property> type2castProperty = new HashMap<>();

	private final @NonNull List<@NonNull Region> allRegions = new ArrayList<>();

	private @NonNull List<@NonNull Region> activeRegions = Collections.emptyList();

	@Override
	public void addRegion(@NonNull Region region) {
		allRegions.add(region);
	}

	@Override
	public @NonNull List<@NonNull Region> getActiveRegions() {
		return activeRegions;
	}

	/*	public @NonNull Property getCastProperty(@NonNull Type type) {
		Property castProperty = type2castProperty.get(type);
		if (castProperty == null) {
			castProperty = PivotFactory.eINSTANCE.createProperty();
			castProperty.setName("as\\n" + type.toString());
			castProperty.setType(type);
			type2castProperty.put(type, castProperty);
		}
		return castProperty;
	} */

	@Override
	public @NonNull Iterable<@NonNull OperationRegion> getOperationRegions() {
		return Iterables.filter(allRegions, OperationRegion.class);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScheduleModel(ScheduleModel newScheduleModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newScheduleModel, QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleModel(ScheduleModel newScheduleModel) {
		if (newScheduleModel != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL && newScheduleModel != null)) {
			if (EcoreUtil.isAncestor(this, newScheduleModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newScheduleModel != null)
				msgs = ((InternalEObject)newScheduleModel).eInverseAdd(this, QVTschedulePackage.SCHEDULE_MODEL__MULTI_REGION, ScheduleModel.class, msgs);
			msgs = basicSetScheduleModel(newScheduleModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL, newScheduleModel, newScheduleModel));
	}

	/*	private @NonNull List<Region> growSequentialRegions(@NonNull List<Region> orderedRegions) {
		List<Region> regions = new ArrayList<Region>();
		for (@SuppressWarnings("null")@NonNull Region region : orderedRegions) {
			if (region.getInvokingRegion() == null) {
				SequentialRegion sequentialRegion = region.growSequentialRegion(null);
				if (sequentialRegion != null) {
					regions.add(sequentialRegion);
				}
				else {
					regions.add(region);
				}
			}
		}
		return regions;
	} */

	//	public @NonNull List<Region> identifyRegions() {
	//		List<Region> sequentialRegions = growSequentialRegions(guardedRegions);
	//		HierarchicalRegion.growHierarchicalRegions(sequentialRegions);
	//
	//		return allRegions;
	//	}

	@Override
	public void setActiveRegions(@NonNull Iterable<@NonNull ? extends Region> activeRegions) {	// FIXME eliminate
		this.activeRegions = Lists.newArrayList(activeRegions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetScheduleModel((ScheduleModel)otherEnd, msgs);
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
			case QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL:
				return basicSetScheduleModel(null, msgs);
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
			case QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.SCHEDULE_MODEL__MULTI_REGION, ScheduleModel.class, msgs);
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
			case QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL:
				return getScheduleModel();
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
			case QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL:
				setScheduleModel((ScheduleModel)newValue);
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
			case QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL:
				setScheduleModel((ScheduleModel)null);
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
			case QVTschedulePackage.MULTI_REGION__SCHEDULE_MODEL:
				return getScheduleModel() != null;
		}
		return super.eIsSet(featureID);
	}
} //MultiRegionImpl
