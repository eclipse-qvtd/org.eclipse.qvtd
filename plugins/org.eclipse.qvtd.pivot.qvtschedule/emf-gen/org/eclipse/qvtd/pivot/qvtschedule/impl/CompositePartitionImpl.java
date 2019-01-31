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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CompositePartitionImpl#getOwnedMappingPartitions <em>Owned Mapping Partitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CompositePartitionImpl extends PartitionImpl implements CompositePartition {
	/**
	 * The number of structural features of the '<em>Composite Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_PARTITION_FEATURE_COUNT = PartitionImpl.PARTITION_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Composite Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_PARTITION_OPERATION_COUNT = PartitionImpl.PARTITION_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getOwnedMappingPartitions() <em>Owned Mapping Partitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingPartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingPartition> ownedMappingPartitions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositePartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.COMPOSITE_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MappingPartition> getOwnedMappingPartitions() {
		if (ownedMappingPartitions == null) {
			ownedMappingPartitions = new EObjectContainmentWithInverseEList<MappingPartition>(MappingPartition.class, this, PartitionImpl.PARTITION_FEATURE_COUNT + 0, PartitionImpl.PARTITION_FEATURE_COUNT + 0);
		}
		return ownedMappingPartitions;
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
			case PartitionImpl.PARTITION_FEATURE_COUNT + 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMappingPartitions()).basicAdd(otherEnd, msgs);
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
			case PartitionImpl.PARTITION_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedMappingPartitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PartitionImpl.PARTITION_FEATURE_COUNT + 0:
				return getOwnedMappingPartitions();
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
			case PartitionImpl.PARTITION_FEATURE_COUNT + 0:
				getOwnedMappingPartitions().clear();
				getOwnedMappingPartitions().addAll((Collection<? extends MappingPartition>)newValue);
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
			case PartitionImpl.PARTITION_FEATURE_COUNT + 0:
				getOwnedMappingPartitions().clear();
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
			case PartitionImpl.PARTITION_FEATURE_COUNT + 0:
				return ownedMappingPartitions != null && !ownedMappingPartitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //CompositePartitionImpl
