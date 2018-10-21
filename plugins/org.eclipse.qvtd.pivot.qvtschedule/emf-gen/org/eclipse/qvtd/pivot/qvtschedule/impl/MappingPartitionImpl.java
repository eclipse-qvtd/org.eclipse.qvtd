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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingPartitionImpl#getRootPartition <em>Root Partition</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingPartitionImpl extends PartitionImpl implements MappingPartition {
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
	public CompositePartition getOwningCompositePartition() {
		if (eContainerFeatureID() != QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION) return null;
		return (CompositePartition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningCompositePartition(CompositePartition newOwningCompositePartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningCompositePartition, QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningCompositePartition(CompositePartition newOwningCompositePartition) {
		if (newOwningCompositePartition != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION && newOwningCompositePartition != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION, newOwningCompositePartition, newOwningCompositePartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRegion getReferedMappingRegion() {
		if (referedMappingRegion != null && referedMappingRegion.eIsProxy()) {
			InternalEObject oldReferedMappingRegion = (InternalEObject)referedMappingRegion;
			referedMappingRegion = (MappingRegion)eResolveProxy(oldReferedMappingRegion);
			if (referedMappingRegion != oldReferedMappingRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION, oldReferedMappingRegion, referedMappingRegion));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION, oldReferedMappingRegion, newReferedMappingRegion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION, newReferedMappingRegion, newReferedMappingRegion));
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
	public RootPartition getRootPartition() {
		if (rootPartition != null && rootPartition.eIsProxy()) {
			InternalEObject oldRootPartition = (InternalEObject)rootPartition;
			rootPartition = (RootPartition)eResolveProxy(oldRootPartition);
			if (rootPartition != oldRootPartition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.MAPPING_PARTITION__ROOT_PARTITION, oldRootPartition, rootPartition));
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
			case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningCompositePartition((CompositePartition)otherEnd, msgs);
			case QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION:
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
			case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION:
				return basicSetOwningCompositePartition(null, msgs);
			case QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION:
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
			case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION:
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
			case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION:
				return getOwningCompositePartition();
			case QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION:
				if (resolve) return getReferedMappingRegion();
				return basicGetReferedMappingRegion();
			case QVTschedulePackage.MAPPING_PARTITION__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
			case QVTschedulePackage.MAPPING_PARTITION__ROOT_PARTITION:
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
			case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION:
				setOwningCompositePartition((CompositePartition)newValue);
				return;
			case QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION:
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
			case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION:
				setOwningCompositePartition((CompositePartition)null);
				return;
			case QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION:
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
			case QVTschedulePackage.MAPPING_PARTITION__OWNING_COMPOSITE_PARTITION:
				return getOwningCompositePartition() != null;
			case QVTschedulePackage.MAPPING_PARTITION__REFERED_MAPPING_REGION:
				return referedMappingRegion != null;
			case QVTschedulePackage.MAPPING_PARTITION__REGION:
				return basicGetRegion() != null;
			case QVTschedulePackage.MAPPING_PARTITION__ROOT_PARTITION:
				return rootPartition != null;
		}
		return super.eIsSet(featureID);
	}


	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges = null;

	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 * Sub-index is both by property and its opposite.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>>> typedModel2property2enforcedEdges = null;

	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};

	@Override
	public void addCheckedEdge(@NonNull TypedModel typedModel, @NonNull NavigableEdge predicatedEdge) {
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges2 = typedModel2checkedEdges;
		assert typedModel2checkedEdges2 != null;
		Set<@NonNull NavigableEdge> checkedEdges = typedModel2checkedEdges2.get(typedModel);
		if (checkedEdges == null) {
			checkedEdges = new HashSet<>();
			typedModel2checkedEdges2.put(typedModel, checkedEdges);
		}
		checkedEdges.add(predicatedEdge);
	}

	@Override
	public @NonNull Property addEnforcedEdge(@NonNull TypedModel typedModel,@NonNull NavigableEdge realizedEdge) {
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>>> typedModel2property2enforcedEdges2 = typedModel2property2enforcedEdges;
		assert typedModel2property2enforcedEdges2 != null;
		Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>> property2enforcedEdges2 = typedModel2property2enforcedEdges2.get(typedModel);
		if (property2enforcedEdges2 == null) {
			property2enforcedEdges2 = new HashMap<>();
			typedModel2property2enforcedEdges2.put(typedModel, property2enforcedEdges2);
		}
		Property asProperty = QVTscheduleUtil.getProperty(realizedEdge);
		Set<@NonNull NavigableEdge> enforcedEdges = property2enforcedEdges2.get(asProperty);
		if (enforcedEdges == null) {
			enforcedEdges = new HashSet<>();
			property2enforcedEdges2.put(asProperty, enforcedEdges);
			Property asOpposite = asProperty.getOpposite();
			if (asOpposite != null) {
				property2enforcedEdges2.put(asOpposite, enforcedEdges);
			}
		}
		enforcedEdges.add(realizedEdge);
		return asProperty;
	}

	@Override
	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
	}

	@Override
	public @Nullable Iterable<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel, @NonNull Property asProperty) {
		assert typedModel2property2enforcedEdges != null;
		Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>> property2enforcedEdge = typedModel2property2enforcedEdges.get(typedModel);
		if (property2enforcedEdge != null) {
			Set<@NonNull NavigableEdge> enforcedEdges = property2enforcedEdge.get(asProperty);
			return enforcedEdges;
		}
		return null;
	}


	@Override
	public void initTypedModelAnalysis() {
		typedModel2checkedEdges = new HashMap<>();
		typedModel2property2enforcedEdges = new HashMap<>();
	}

	//	@Override
	//	public void toGraph(@NonNull GraphStringBuilder s) {
	//		AbstractToGraphVisitor visitor = ToGraphPartitionVisitor.createVisitor(s, getScheduleManager(), true);
	//		visitor.visit(this);
	//	}

} //MappingPartitionImpl
