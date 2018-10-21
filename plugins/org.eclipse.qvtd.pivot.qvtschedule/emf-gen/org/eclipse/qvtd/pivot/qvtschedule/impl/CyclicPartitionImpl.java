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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cyclic Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicPartitionImpl#getOwningCompositePartition <em>Owning Composite Partition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicPartitionImpl#getReferedMappingRegion <em>Refered Mapping Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicPartitionImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicPartitionImpl#getRootPartition <em>Root Partition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CyclicPartitionImpl extends CompositePartitionImpl implements CyclicPartition {
	/**
	 * The cached value of the '{@link #getReferedMappingRegion() <em>Refered Mapping Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferedMappingRegion()
	 * @generated
	 * @ordered
	 */
	protected MappingRegion referedMappingRegion;
	/**
	 * The cached value of the '{@link #getRootPartition() <em>Root Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPartition()
	 * @generated
	 * @ordered
	 */
	protected RootPartition rootPartition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CyclicPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CYCLIC_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositePartition getOwningCompositePartition() {
		if (eContainerFeatureID() != QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION) return null;
		return (CompositePartition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompositePartition(CompositePartition newOwningCompositePartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningCompositePartition, QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompositePartition(CompositePartition newOwningCompositePartition) {
		if (newOwningCompositePartition != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION && newOwningCompositePartition != null)) {
			if (EcoreUtil.isAncestor(this, newOwningCompositePartition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompositePartition != null)
				msgs = ((InternalEObject)newOwningCompositePartition).eInverseAdd(this, QVTschedulePackage.COMPOSITE_PARTITION__OWNED_MAPPING_PARTITIONS, CompositePartition.class, msgs);
			msgs = basicSetOwningCompositePartition(newOwningCompositePartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION, newOwningCompositePartition, newOwningCompositePartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingRegion getReferedMappingRegion() {
		if (referedMappingRegion != null && referedMappingRegion.eIsProxy()) {
			InternalEObject oldReferedMappingRegion = (InternalEObject)referedMappingRegion;
			referedMappingRegion = (MappingRegion)eResolveProxy(oldReferedMappingRegion);
			if (referedMappingRegion != oldReferedMappingRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION, oldReferedMappingRegion, referedMappingRegion));
			}
		}
		return referedMappingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRegion basicGetReferedMappingRegion() {
		return referedMappingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferedMappingRegion(MappingRegion newReferedMappingRegion, NotificationChain msgs) {
		MappingRegion oldReferedMappingRegion = referedMappingRegion;
		referedMappingRegion = newReferedMappingRegion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION, oldReferedMappingRegion, newReferedMappingRegion);
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
	public void setReferedMappingRegion(MappingRegion newReferedMappingRegion) {
		if (newReferedMappingRegion != referedMappingRegion) {
			NotificationChain msgs = null;
			if (referedMappingRegion != null)
				msgs = ((InternalEObject)referedMappingRegion).eInverseRemove(this, QVTschedulePackage.MAPPING_REGION__MAPPING_PARTITIONS, MappingRegion.class, msgs);
			if (newReferedMappingRegion != null)
				msgs = ((InternalEObject)newReferedMappingRegion).eInverseAdd(this, QVTschedulePackage.MAPPING_REGION__MAPPING_PARTITIONS, MappingRegion.class, msgs);
			msgs = basicSetReferedMappingRegion(newReferedMappingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION, newReferedMappingRegion, newReferedMappingRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getRegion() {
		Region region = basicGetRegion();
		return region != null && region.eIsProxy() ? (Region)eResolveProxy((InternalEObject)region) : region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootPartition getRootPartition() {
		if (rootPartition != null && rootPartition.eIsProxy()) {
			InternalEObject oldRootPartition = (InternalEObject)rootPartition;
			rootPartition = (RootPartition)eResolveProxy(oldRootPartition);
			if (rootPartition != oldRootPartition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CYCLIC_PARTITION__ROOT_PARTITION, oldRootPartition, rootPartition));
			}
		}
		return rootPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootPartition basicGetRootPartition() {
		return rootPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompositePartition((CompositePartition)otherEnd, msgs);
			case QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION:
				if (referedMappingRegion != null)
					msgs = ((InternalEObject)referedMappingRegion).eInverseRemove(this, QVTschedulePackage.MAPPING_REGION__MAPPING_PARTITIONS, MappingRegion.class, msgs);
				return basicSetReferedMappingRegion((MappingRegion)otherEnd, msgs);
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
			case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION:
				return basicSetOwningCompositePartition(null, msgs);
			case QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION:
				return basicSetReferedMappingRegion(null, msgs);
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
			case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.COMPOSITE_PARTITION__OWNED_MAPPING_PARTITIONS, CompositePartition.class, msgs);
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
			case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION:
				return getOwningCompositePartition();
			case QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION:
				if (resolve) return getReferedMappingRegion();
				return basicGetReferedMappingRegion();
			case QVTschedulePackage.CYCLIC_PARTITION__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
			case QVTschedulePackage.CYCLIC_PARTITION__ROOT_PARTITION:
				if (resolve) return getRootPartition();
				return basicGetRootPartition();
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
			case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION:
				setOwningCompositePartition((CompositePartition)newValue);
				return;
			case QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION:
				setReferedMappingRegion((MappingRegion)newValue);
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
			case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION:
				setOwningCompositePartition((CompositePartition)null);
				return;
			case QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION:
				setReferedMappingRegion((MappingRegion)null);
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
			case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION:
				return getOwningCompositePartition() != null;
			case QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION:
				return referedMappingRegion != null;
			case QVTschedulePackage.CYCLIC_PARTITION__REGION:
				return basicGetRegion() != null;
			case QVTschedulePackage.CYCLIC_PARTITION__ROOT_PARTITION:
				return rootPartition != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MappingPartition.class) {
			switch (derivedFeatureID) {
				case QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION: return QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION;
				case QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION: return QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION;
				case QVTschedulePackage.CYCLIC_PARTITION__REGION: return QVTschedulePackage.MAPPING_PARTITION__REGION;
				case QVTschedulePackage.CYCLIC_PARTITION__ROOT_PARTITION: return QVTschedulePackage.MAPPING_PARTITION__ROOT_PARTITION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MappingPartition.class) {
			switch (baseFeatureID) {
				case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION: return QVTschedulePackage.CYCLIC_PARTITION__OWNING_COMPOSITE_PARTITION;
				case QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION: return QVTschedulePackage.CYCLIC_PARTITION__REFERED_MAPPING_REGION;
				case QVTschedulePackage.MAPPING_PARTITION__REGION: return QVTschedulePackage.CYCLIC_PARTITION__REGION;
				case QVTschedulePackage.MAPPING_PARTITION__ROOT_PARTITION: return QVTschedulePackage.CYCLIC_PARTITION__ROOT_PARTITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitCyclicPartition(this);
	}

	@Override
	public void addCheckedEdge(@NonNull TypedModel typedModel, @NonNull NavigableEdge predicatedEdge) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public Region basicGetRegion() {
		return getReferedMappingRegion();
	}

	@Override
	public @NonNull Property addEnforcedEdge(@NonNull TypedModel typedModel, @NonNull NavigableEdge realizedEdge) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void initTypedModelAnalysis() {
		throw new UnsupportedOperationException();
	}

} //CyclicPartitionImpl
