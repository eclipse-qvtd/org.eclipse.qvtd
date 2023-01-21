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
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingPartitionImpl#getOwningCompositePartition <em>Owning Composite Partition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingPartitionImpl#getReferedMappingRegion <em>Refered Mapping Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingPartitionImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingPartitionImpl#getExplicitSuccessors <em>Explicit Successors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingPartitionImpl extends PartitionImpl implements MappingPartition {
	/**
	 * The number of structural features of the '<em>Mapping Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_PARTITION_FEATURE_COUNT = PartitionImpl.PARTITION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Mapping Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_PARTITION_OPERATION_COUNT = PartitionImpl.PARTITION_OPERATION_COUNT + 0;

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
	protected MappingPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MAPPING_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositePartition getOwningCompositePartition() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3)) return null;
		return (CompositePartition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompositePartition(CompositePartition newOwningCompositePartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningCompositePartition, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompositePartition(CompositePartition newOwningCompositePartition) {
		if (newOwningCompositePartition != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3) && newOwningCompositePartition != null)) {
			if (EcoreUtil.isAncestor(this, newOwningCompositePartition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningCompositePartition != null)
				msgs = ((InternalEObject)newOwningCompositePartition).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, CompositePartition.class, msgs);
			msgs = basicSetOwningCompositePartition(newOwningCompositePartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, newOwningCompositePartition, newOwningCompositePartition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldReferedMappingRegion, referedMappingRegion));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldReferedMappingRegion, newReferedMappingRegion);
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
				msgs = ((InternalEObject)referedMappingRegion).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, MappingRegion.class, msgs);
			if (newReferedMappingRegion != null)
				msgs = ((InternalEObject)newReferedMappingRegion).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, MappingRegion.class, msgs);
			msgs = basicSetReferedMappingRegion(newReferedMappingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, newReferedMappingRegion, newReferedMappingRegion));
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
	public Region basicGetRegion() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!MappingPartition!region
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<BasicPartition> getExplicitSuccessors() {
		if (explicitSuccessors == null) {
			explicitSuccessors = new EObjectWithInverseResolvingEList.ManyInverse<BasicPartition>(BasicPartition.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompositePartition((CompositePartition)otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				if (referedMappingRegion != null)
					msgs = ((InternalEObject)referedMappingRegion).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, MappingRegion.class, msgs);
				return basicSetReferedMappingRegion((MappingRegion)otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return basicSetOwningCompositePartition(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return basicSetReferedMappingRegion(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return eInternalContainer().eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, CompositePartition.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOwningCompositePartition();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				if (resolve) return getReferedMappingRegion();
				return basicGetReferedMappingRegion();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				if (resolve) return getRegion();
				return basicGetRegion();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setOwningCompositePartition((CompositePartition)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setReferedMappingRegion((MappingRegion)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setOwningCompositePartition((CompositePartition)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setReferedMappingRegion((MappingRegion)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOwningCompositePartition() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return referedMappingRegion != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return basicGetRegion() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return explicitSuccessors != null && !explicitSuccessors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};
} //MappingPartitionImpl
