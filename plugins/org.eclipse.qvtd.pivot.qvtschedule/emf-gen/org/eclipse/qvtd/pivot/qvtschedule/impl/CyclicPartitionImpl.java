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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
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
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4)) return null;
		return (CompositePartition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompositePartition(CompositePartition newOwningCompositePartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningCompositePartition, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningCompositePartition(CompositePartition newOwningCompositePartition) {
		if (newOwningCompositePartition != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4) && newOwningCompositePartition != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, newOwningCompositePartition, newOwningCompositePartition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, oldReferedMappingRegion, referedMappingRegion));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, oldReferedMappingRegion, newReferedMappingRegion);
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, newReferedMappingRegion, newReferedMappingRegion));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7, oldRootPartition, rootPartition));
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
			explicitSuccessors = new EObjectWithInverseResolvingEList.ManyInverse<BasicPartition>(BasicPartition.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 12);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompositePartition((CompositePartition)otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				if (referedMappingRegion != null)
					msgs = ((InternalEObject)referedMappingRegion).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, MappingRegion.class, msgs);
				return basicSetReferedMappingRegion((MappingRegion)otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return basicSetOwningCompositePartition(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return basicSetReferedMappingRegion(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return getOwningCompositePartition();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				if (resolve) return getReferedMappingRegion();
				return basicGetReferedMappingRegion();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				if (resolve) return getRegion();
				return basicGetRegion();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				if (resolve) return getRootPartition();
				return basicGetRootPartition();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setOwningCompositePartition((CompositePartition)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setReferedMappingRegion((MappingRegion)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setOwningCompositePartition((CompositePartition)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setReferedMappingRegion((MappingRegion)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return getOwningCompositePartition() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return referedMappingRegion != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return basicGetRegion() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return rootPartition != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
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
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7;
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
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7;
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8;
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
