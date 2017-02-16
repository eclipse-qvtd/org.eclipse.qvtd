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
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgeConnectionImpl extends DatumConnectionImpl<NavigableEdge> implements EdgeConnection {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

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
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<NavigableEdge> getSourceEnds() {
		if (sourceEnds == null) {
			sourceEnds = new EObjectResolvingEList<NavigableEdge>(NavigableEdge.class, this, QVTschedulePackage.EDGE_CONNECTION__SOURCE_ENDS);
		}
		return sourceEnds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.EDGE_CONNECTION__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE_CONNECTION__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.EDGE_CONNECTION__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
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
			case QVTschedulePackage.EDGE_CONNECTION__PROPERTY:
				setProperty((Property)newValue);
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
			case QVTschedulePackage.EDGE_CONNECTION__PROPERTY:
				setProperty((Property)null);
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
			case QVTschedulePackage.EDGE_CONNECTION__PROPERTY:
				return property != null;
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
	public void addUsedTargetEdge(@NonNull NavigableEdge targetEdge, boolean mustBeLater) {
		//		if (getSourceRegions().contains(targetEdge.getRegion())) {
		//			System.out.println("Cyclic dependency arbitrarily ignored: " + this);
		//			mergeRole(Connections.PREFERRED_EDGE);
		//			return;
		//		}
		mergeRole(mustBeLater ? QVTscheduleConstants.MANDATORY_EDGE : QVTscheduleConstants.PREFERRED_EDGE);
		assert !targetEnd2role.containsKey(targetEdge);
		targetEnd2role.put(targetEdge, mustBeLater ? QVTscheduleConstants.MANDATORY_EDGE : QVTscheduleConstants.PREFERRED_EDGE);
		targetEdge.setIncomingConnection(this);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	@Override
	public void destroy() {
		for (@NonNull NavigableEdge sourceEdge : QVTscheduleUtil.getSourceEnds(this)) {
			sourceEdge.removeOutgoingConnection(this);
		}
		for (@NonNull NavigableEdge targetNode : targetEnd2role.keySet()) {
			targetNode.setIncomingConnection(null);
		}
		super.destroy();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getSourceNodes() {
		List<@NonNull Node> sourceNodes = new ArrayList<>();
		for (@NonNull NavigableEdge sourceEdge : QVTscheduleUtil.getSourceEnds(this)) {
			sourceNodes.add(sourceEdge.getEdgeSource());
		}
		return sourceNodes;
	}

	@Override
	public @NonNull Iterable<@NonNull NavigableEdge> getTargetEdges() {
		return targetEnd2role.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getTargetNodes() {
		List<@NonNull Node> targetNodes = new ArrayList<>();
		for (@NonNull NavigableEdge targetEdge : targetEnd2role.keySet()) {
			targetNodes.add(targetEdge.getEdgeTarget());
		}
		return targetNodes;
	}

	@Override
	public @NonNull Map<@NonNull NavigableEdge, @NonNull ConnectionRole> getTargets() {
		return targetEnd2role;
	}

	/*	@Override
	public @NonNull Type getType(@NonNull IdResolver idResolver) {
//		System.out.println("commonType of " + this);
		Type commonType = null;
		for (@NonNull Node node : getSources()) {
			Type nodeType = node.getCompleteClass().getPrimaryClass();
//			System.out.println("  nodeType " + nodeType);
			if (!(nodeType instanceof CollectionType)) {		// RealizedVariable accumulated on Connection
				CompleteEnvironment environment = idResolver.getEnvironment();
				nodeType = isOrdered() ? environment.getOrderedSetType(nodeType, true, null, null) : environment.getSetType(nodeType, true, null, null);
			}
			if (commonType == null) {
				commonType = nodeType;
			}
			else {
				commonType = commonType.getCommonType(idResolver, nodeType);
			}
		}
//		System.out.println("=> " + commonType);
		assert commonType != null;
		return commonType;
	} */

	@Override
	public boolean isEdge2Edge() {
		return (sourceEnds.size() == 1) && (targetEnd2role.size() == 1);
	}

	//	@Override
	//	public boolean isInput() {
	//		return false;
	//	}

	@Override
	public boolean isMandatory() {
		return false;
	}

	//	@Override
	//	public boolean isOutput() {
	//		return false;
	//	}

	@Override
	public boolean isPassed() {
		return false;
	}

	@Override
	public boolean isPassed(@NonNull Region targetRegion) {
		return false;
	}

	/*	@Override
	public void removeSource(@NonNull Node sourceNode) {
		boolean wasRemoved = sourceNodes.remove(sourceNode);
		assert wasRemoved;
	}

	@Override
	public void removeTarget(@NonNull Node targetNode) {
		ConnectionRole oldRole = targetNode2role.remove(targetNode);
		assert oldRole != null;
	} */

	private void removeTarget(@NonNull NavigableEdge targetEdge) {
		ConnectionRole oldRole = targetEnd2role.remove(targetEdge);
		assert oldRole != null;
	}

	@Override
	public void removeTargetRegion(@NonNull Region targetRegion) {
		for (@NonNull NavigableEdge targetEdge : Lists.newArrayList(getTargetEdges())) {
			if (targetEdge.getRegion() == targetRegion) {
				targetEdge.setIncomingConnection(null);
				removeTarget(targetEdge);
			}
		}
		if (targetEnd2role.isEmpty()) {
			destroy();
		}
	}
} //EdgeConnectionImpl
