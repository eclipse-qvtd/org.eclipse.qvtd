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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicPartitionImpl#getExplicitSuccessors <em>Explicit Successors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CyclicPartitionImpl extends CompositePartitionImpl implements CyclicPartition {
	/**
	 * The number of structural features of the '<em>Cyclic Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CYCLIC_PARTITION_FEATURE_COUNT = CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 5;
	/**
	 * The number of operations of the '<em>Cyclic Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CYCLIC_PARTITION_OPERATION_COUNT = CompositePartitionImpl.COMPOSITE_PARTITION_OPERATION_COUNT + 0;
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
	 * The cached value of the '{@link #getExplicitSuccessors() <em>Explicit Successors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitSuccessors()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicPartition> explicitSuccessors;

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
		if (eContainerFeatureID() != (CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0)) return null;
		return (CompositePartition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompositePartition(CompositePartition newOwningCompositePartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningCompositePartition, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompositePartition(CompositePartition newOwningCompositePartition) {
		if (newOwningCompositePartition != eInternalContainer() || (eContainerFeatureID() != (CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0) && newOwningCompositePartition != null)) {
			if (EcoreUtil.isAncestor(this, newOwningCompositePartition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompositePartition != null)
				msgs = ((InternalEObject)newOwningCompositePartition).eInverseAdd(this, PartitionImpl.PARTITION_FEATURE_COUNT + 0, CompositePartition.class, msgs);
			msgs = basicSetOwningCompositePartition(newOwningCompositePartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0, newOwningCompositePartition, newOwningCompositePartition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1, oldReferedMappingRegion, referedMappingRegion));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1, oldReferedMappingRegion, newReferedMappingRegion);
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
				msgs = ((InternalEObject)referedMappingRegion).eInverseRemove(this, RegionImpl.REGION_FEATURE_COUNT + 1, MappingRegion.class, msgs);
			if (newReferedMappingRegion != null)
				msgs = ((InternalEObject)newReferedMappingRegion).eInverseAdd(this, RegionImpl.REGION_FEATURE_COUNT + 1, MappingRegion.class, msgs);
			msgs = basicSetReferedMappingRegion(newReferedMappingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1, newReferedMappingRegion, newReferedMappingRegion));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 3, oldRootPartition, rootPartition));
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
	public List<BasicPartition> getExplicitSuccessors() {
		if (explicitSuccessors == null) {
			explicitSuccessors = new EObjectWithInverseResolvingEList.ManyInverse<BasicPartition>(BasicPartition.class, this, CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4, MappingPartitionImpl.MAPPING_PARTITION_FEATURE_COUNT + 4);
		}
		return explicitSuccessors;
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompositePartition((CompositePartition)otherEnd, msgs);
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				if (referedMappingRegion != null)
					msgs = ((InternalEObject)referedMappingRegion).eInverseRemove(this, RegionImpl.REGION_FEATURE_COUNT + 1, MappingRegion.class, msgs);
				return basicSetReferedMappingRegion((MappingRegion)otherEnd, msgs);
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExplicitSuccessors()).basicAdd(otherEnd, msgs);
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
				return basicSetOwningCompositePartition(null, msgs);
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				return basicSetReferedMappingRegion(null, msgs);
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4:
				return ((InternalEList<?>)getExplicitSuccessors()).basicRemove(otherEnd, msgs);
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
				return eInternalContainer().eInverseRemove(this, PartitionImpl.PARTITION_FEATURE_COUNT + 0, CompositePartition.class, msgs);
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
				return getOwningCompositePartition();
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				if (resolve) return getReferedMappingRegion();
				return basicGetReferedMappingRegion();
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 2:
				if (resolve) return getRegion();
				return basicGetRegion();
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 3:
				if (resolve) return getRootPartition();
				return basicGetRootPartition();
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4:
				return getExplicitSuccessors();
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
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0:
				setOwningCompositePartition((CompositePartition)newValue);
				return;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				setReferedMappingRegion((MappingRegion)newValue);
				return;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4:
				getExplicitSuccessors().clear();
				getExplicitSuccessors().addAll((Collection<? extends BasicPartition>)newValue);
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
				setOwningCompositePartition((CompositePartition)null);
				return;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				setReferedMappingRegion((MappingRegion)null);
				return;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4:
				getExplicitSuccessors().clear();
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
				return getOwningCompositePartition() != null;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1:
				return referedMappingRegion != null;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 2:
				return basicGetRegion() != null;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 3:
				return rootPartition != null;
			case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4:
				return explicitSuccessors != null && !explicitSuccessors.isEmpty();
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
				case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0: return PartitionImpl.PARTITION_FEATURE_COUNT + 0;
				case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1: return PartitionImpl.PARTITION_FEATURE_COUNT + 1;
				case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 2: return PartitionImpl.PARTITION_FEATURE_COUNT + 2;
				case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 3: return PartitionImpl.PARTITION_FEATURE_COUNT + 3;
				case CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4: return PartitionImpl.PARTITION_FEATURE_COUNT + 4;
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
				case PartitionImpl.PARTITION_FEATURE_COUNT + 0: return CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 0;
				case PartitionImpl.PARTITION_FEATURE_COUNT + 1: return CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 1;
				case PartitionImpl.PARTITION_FEATURE_COUNT + 2: return CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 2;
				case PartitionImpl.PARTITION_FEATURE_COUNT + 3: return CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 3;
				case PartitionImpl.PARTITION_FEATURE_COUNT + 4: return CompositePartitionImpl.COMPOSITE_PARTITION_FEATURE_COUNT + 4;
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
	public void addCheckedEdge(@NonNull TypedModel typedModel, @NonNull NavigableEdge checkedEdge) {
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
