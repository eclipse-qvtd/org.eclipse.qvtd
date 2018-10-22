/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl#getMandatoryTargetEdges <em>Mandatory Target Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl#getPreferredTargetEdges <em>Preferred Target Edges</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgeConnectionImpl extends ConnectionImpl implements EdgeConnection
{
	/**
	 * EdgeList duplicates changes to the lists-of-edges to the 'redundant' edge-to-role map.
	 */
	@SuppressWarnings("serial")
	protected static class EdgeList extends EObjectResolvingEList<@NonNull NavigableEdge>
	{
		protected final @NonNull ConnectionRole connectionRole;
		private final @NonNull Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role;

		protected EdgeList(@NonNull EdgeConnectionImpl owner, int featureID, @NonNull ConnectionRole connectionRole) {
			super(NavigableEdge.class, owner, featureID);
			this.connectionRole = connectionRole;
			this.targetEnd2role = owner.targetEnd2role;
		}

		@Override
		protected void didAdd(int index, @NonNull NavigableEdge newObject) {
			targetEnd2role.put(newObject, connectionRole);
		}

		@Override
		protected void didRemove(int index, @NonNull NavigableEdge oldObject) {
			targetEnd2role.remove(oldObject);
		}
	}

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;
	/**
	 * The cached value of the '{@link #getMandatoryTargetEdges() <em>Mandatory Target Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMandatoryTargetEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<NavigableEdge> mandatoryTargetEdges;
	/**
	 * The cached value of the '{@link #getPreferredTargetEdges() <em>Preferred Target Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredTargetEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<NavigableEdge> preferredTargetEdges;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.EDGE_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.EDGE_CONNECTION__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE_CONNECTION__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<NavigableEdge> getMandatoryTargetEdges() {
		if (mandatoryTargetEdges == null) {
			mandatoryTargetEdges = new EdgeList(this, QVTschedulePackage.EDGE_CONNECTION__MANDATORY_TARGET_EDGES, ConnectionRole.MANDATORY_EDGE);
		}
		return mandatoryTargetEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<NavigableEdge> getPreferredTargetEdges() {
		if (preferredTargetEdges == null) {
			preferredTargetEdges = new EdgeList(this, QVTschedulePackage.EDGE_CONNECTION__PREFERRED_TARGET_EDGES, ConnectionRole.PREFERRED_EDGE);
		}
		return preferredTargetEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.EDGE_CONNECTION__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case QVTschedulePackage.EDGE_CONNECTION__MANDATORY_TARGET_EDGES:
				return getMandatoryTargetEdges();
			case QVTschedulePackage.EDGE_CONNECTION__PREFERRED_TARGET_EDGES:
				return getPreferredTargetEdges();
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
			case QVTschedulePackage.EDGE_CONNECTION__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
				return;
			case QVTschedulePackage.EDGE_CONNECTION__MANDATORY_TARGET_EDGES:
				getMandatoryTargetEdges().clear();
				getMandatoryTargetEdges().addAll((Collection<? extends NavigableEdge>)newValue);
				return;
			case QVTschedulePackage.EDGE_CONNECTION__PREFERRED_TARGET_EDGES:
				getPreferredTargetEdges().clear();
				getPreferredTargetEdges().addAll((Collection<? extends NavigableEdge>)newValue);
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
			case QVTschedulePackage.EDGE_CONNECTION__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
				return;
			case QVTschedulePackage.EDGE_CONNECTION__MANDATORY_TARGET_EDGES:
				getMandatoryTargetEdges().clear();
				return;
			case QVTschedulePackage.EDGE_CONNECTION__PREFERRED_TARGET_EDGES:
				getPreferredTargetEdges().clear();
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
			case QVTschedulePackage.EDGE_CONNECTION__REFERRED_PROPERTY:
				return referredProperty != null;
			case QVTschedulePackage.EDGE_CONNECTION__MANDATORY_TARGET_EDGES:
				return mandatoryTargetEdges != null && !mandatoryTargetEdges.isEmpty();
			case QVTschedulePackage.EDGE_CONNECTION__PREFERRED_TARGET_EDGES:
				return preferredTargetEdges != null && !preferredTargetEdges.isEmpty();
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitEdgeConnection(this);
	}

	@Override
	public boolean isMandatory() {
		return false;
	}

	@Override
	public boolean isPassed() {
		return false;
	}

	@Override
	public void setName(String newName) {
		if ("je_Telement2element_success_1".equals(newName)) {
			getClass();
		}
		super.setName(newName);
	}

	private final @NonNull Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = new HashMap<>();

	@Override
	public void addUsedTargetEdge(@NonNull NavigableEdge targetEdge, boolean mustBeLater) {
		//		if (getSourceRegions().contains(targetEdge.getRegion())) {
		//			System.out.println("Cyclic dependency arbitrarily ignored: " + this);
		//			mergeRole(Connections.PREFERRED_EDGE);
		//			return;
		//		}
		mergeRole(mustBeLater ? ConnectionRole.MANDATORY_EDGE : ConnectionRole.PREFERRED_EDGE);
		ConnectionRole targetRole = getTargetRole(targetEdge);
		assert targetRole == null;
		putTargetRole(targetEdge, mustBeLater ? ConnectionRole.MANDATORY_EDGE : ConnectionRole.PREFERRED_EDGE);
		targetEdge.setIncomingConnection(this);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	@Override
	public void destroy() {
		for (@NonNull NavigableEdge sourceEdge : QVTscheduleUtil.getSourceEnds(this)) {
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(this), sourceEdge);
			//		assert edge.getRegion() == getRegion();
			List<EdgeConnection> outgoingConnections2 = sourceEdge.getOutgoingConnections();
			assert outgoingConnections2 != null;
			@SuppressWarnings("unused")boolean wasRemoved = outgoingConnections2.remove(this);
			//			assert wasRemoved;   -- destroy subverts this
		}
		for (@NonNull NavigableEdge targetNode : targetEnd2role.keySet()) {
			targetNode.setIncomingConnection(null);
		}
		targetEnd2role.clear();
		super.destroy();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getSourceNodes() {
		List<@NonNull Node> sourceNodes = new ArrayList<>();
		for (@NonNull NavigableEdge sourceEdge : QVTscheduleUtil.getSourceEnds(this)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEdge);
			Iterable<@NonNull MappingPartition> partitions = getRegionPartitions(sourceRegion);
			if (!Iterables.isEmpty(partitions)) {
				for (@NonNull Partition sourcePartition : partitions) {
					Role sourceRole = QVTscheduleUtil.getRole(sourcePartition, sourceEdge);
					if ((sourceRole != null) &&!sourceRole.isAwaited()) { // (sourceRole.isNew() || sourceRole.isLoaded())) {
						sourceNodes.add(QVTscheduleUtil.getTargetNode(sourceEdge));
					}
				}
			}
			else {
				Role sourceRole = sourceEdge.getEdgeRole();
				if (!sourceRole.isAwaited()) { //sourceRole.isNew() || sourceRole.isLoaded()) {
					sourceNodes.add(QVTscheduleUtil.getTargetNode(sourceEdge));
				}
			}
		}
		return sourceNodes;
	}

	@Override
	public @NonNull Set<@NonNull NavigableEdge> getTargetEdges() {
		return targetEnd2role.keySet();
	}

	@Override
	public @NonNull Set<@NonNull NavigableEdge> getTargetEnds() {
		return targetEnd2role.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getTargetNodes() {
		List<@NonNull Node> targetNodes = new ArrayList<>();
		for (@NonNull NavigableEdge targetEdge : getTargetEdges()) {
			targetNodes.add(targetEdge.getEdgeTarget());
		}
		return targetNodes;
	}

	@Override
	public @Nullable ConnectionRole getTargetRole(@NonNull ConnectionEnd connectionEnd) {
		return targetEnd2role.get(connectionEnd);
	}

	@Override
	public boolean isEdge2Edge() {
		List<NavigableEdge> sourceEnds = QVTscheduleUtil.getSourceEnds(this);
		Set<@NonNull NavigableEdge> targetEdges = getTargetEdges();
		return (sourceEnds.size() == 1) && (targetEdges.size() == 1);
	}

	public boolean isPassed(@NonNull Partition targetPartition) {
		return false;
	}

	@Override
	public @Nullable ConnectionRole putTargetRole(@NonNull NavigableEdge targetEdge, @NonNull ConnectionRole newConnectionRole) {
		ConnectionRole oldConnectionRole = targetEnd2role.get(targetEdge);
		switch (newConnectionRole) {
			case MANDATORY_EDGE: getMandatoryTargetEdges().add(targetEdge); break;
			case PREFERRED_EDGE: getPreferredTargetEdges().add(targetEdge); break;
			default: throw new UnsupportedOperationException(newConnectionRole.toString());
		}
		return oldConnectionRole;
	}

	@Override
	public @Nullable ConnectionRole removeTarget(@NonNull NavigableEdge targetEdge) {
		if (getMandatoryTargetEdges().remove(targetEdge)) {
			return ConnectionRole.MANDATORY_EDGE;
		}
		else if (getPreferredTargetEdges().remove(targetEdge)) {
			return ConnectionRole.PREFERRED_EDGE;
		}
		else {
			return null;
		}
	}

	/*	@Override
	public void removeTargetRegion(@NonNull Region targetRegion) {
		for (@NonNull NavigableEdge targetEdge : Lists.newArrayList(getTargetEdges())) {
			if (targetEdge.getOwningRegion() == targetRegion) {
				targetEdge.setIncomingConnection(null);
				removeTarget(targetEdge);
			}
		}
		if (getTargetEdges().isEmpty()) {
			destroy();
		}
	} */
} //EdgeConnectionImpl
