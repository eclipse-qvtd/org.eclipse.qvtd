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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Composition Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl#getOwningScheduledRegion2 <em>Owning Scheduled Region2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadingRegionImpl extends RegionImpl implements LoadingRegion {
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
	public ScheduledRegion getOwningScheduledRegion2() {
		if (eContainerFeatureID() != QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2) return null;
		return (ScheduledRegion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningScheduledRegion2(ScheduledRegion newOwningScheduledRegion2, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningScheduledRegion2, QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningScheduledRegion2(ScheduledRegion newOwningScheduledRegion2) {
		if (newOwningScheduledRegion2 != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2 && newOwningScheduledRegion2 != null)) {
			if (EcoreUtil.isAncestor(this, newOwningScheduledRegion2))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningScheduledRegion2 != null)
				msgs = ((InternalEObject)newOwningScheduledRegion2).eInverseAdd(this, QVTschedulePackage.SCHEDULED_REGION__OWNED_LOADING_REGION, ScheduledRegion.class, msgs);
			msgs = basicSetOwningScheduledRegion2(newOwningScheduledRegion2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2, newOwningScheduledRegion2, newOwningScheduledRegion2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningScheduledRegion2((ScheduledRegion)otherEnd, msgs);
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
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2:
				return basicSetOwningScheduledRegion2(null, msgs);
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
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2:
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
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2:
				return getOwningScheduledRegion2();
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
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2:
				setOwningScheduledRegion2((ScheduledRegion)newValue);
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
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2:
				setOwningScheduledRegion2((ScheduledRegion)null);
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
			case QVTschedulePackage.LOADING_REGION__OWNING_SCHEDULED_REGION2:
				return getOwningScheduledRegion2() != null;
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

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString(QVTscheduleUtil.ROOT_MAPPING_NAME);
		return s;
	}

	@Override
	public @NonNull List<Node> getHeadNodes() {
		return QVTscheduleConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @NonNull String getName() {
		return QVTscheduleConstants.ROOT_MAPPING_NAME;
	}

	@Override
	protected @NonNull String getSymbolNamePrefix() {
		return "r_";
	}

	@Override
	public boolean isLoadingRegion() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public ScheduledRegion getOwningScheduledRegion() {
		return getOwningScheduledRegion2();
	}
} //RootCompositionRegionImpl
