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

import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Cluster;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Symbolable;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl#getSymbolName <em>Symbol Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl#getOwningRegion <em>Owning Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl#getMemberNodes <em>Member Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl#getMemberEdges <em>Member Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl#getPrecedingClusters <em>Preceding Clusters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl#getSucceedingClusters <em>Succeeding Clusters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl#getDepth <em>Depth</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClusterImpl extends NamedElementImpl implements Cluster {
	/**
	 * The default value of the '{@link #getSymbolName() <em>Symbol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbolName() <em>Symbol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolName()
	 * @generated
	 * @ordered
	 */
	protected String symbolName = SYMBOL_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMemberNodes() <em>Member Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> memberNodes;

	/**
	 * The cached value of the '{@link #getMemberEdges() <em>Member Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> memberEdges;

	/**
	 * The cached value of the '{@link #getPrecedingClusters() <em>Preceding Clusters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecedingClusters()
	 * @generated
	 * @ordered
	 */
	protected EList<Cluster> precedingClusters;

	/**
	 * The cached value of the '{@link #getSucceedingClusters() <em>Succeeding Clusters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSucceedingClusters()
	 * @generated
	 * @ordered
	 */
	protected EList<Cluster> succeedingClusters;

	/**
	 * The default value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer DEPTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected Integer depth = DEPTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClusterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CLUSTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSymbolName() {
		return symbolName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymbolName(String newSymbolName) {
		String oldSymbolName = symbolName;
		symbolName = newSymbolName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLUSTER__SYMBOL_NAME, oldSymbolName, symbolName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getOwningRegion() {
		if (eContainerFeatureID() != QVTschedulePackage.CLUSTER__OWNING_REGION) return null;
		return (Region)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRegion(Region newOwningRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRegion, QVTschedulePackage.CLUSTER__OWNING_REGION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRegion(Region newOwningRegion) {
		if (newOwningRegion != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.CLUSTER__OWNING_REGION && newOwningRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRegion != null)
				msgs = ((InternalEObject)newOwningRegion).eInverseAdd(this, QVTschedulePackage.REGION__OWNED_CLUSTERS, Region.class, msgs);
			msgs = basicSetOwningRegion(newOwningRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLUSTER__OWNING_REGION, newOwningRegion, newOwningRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Node> getMemberNodes() {
		if (memberNodes == null) {
			memberNodes = new EObjectWithInverseResolvingEList<Node>(Node.class, this, QVTschedulePackage.CLUSTER__MEMBER_NODES, QVTschedulePackage.NODE__CLUSTER);
		}
		return memberNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Edge> getMemberEdges() {
		if (memberEdges == null) {
			memberEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, QVTschedulePackage.CLUSTER__MEMBER_EDGES, QVTschedulePackage.EDGE__CLUSTER);
		}
		return memberEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Cluster> getPrecedingClusters() {
		if (precedingClusters == null) {
			precedingClusters = new EObjectWithInverseResolvingEList.ManyInverse<Cluster>(Cluster.class, this, QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS, QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS);
		}
		return precedingClusters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Cluster> getSucceedingClusters() {
		if (succeedingClusters == null) {
			succeedingClusters = new EObjectWithInverseResolvingEList.ManyInverse<Cluster>(Cluster.class, this, QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS, QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS);
		}
		return succeedingClusters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getDepth() {
		return depth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(Integer newDepth) {
		Integer oldDepth = depth;
		depth = newDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLUSTER__DEPTH, oldDepth, depth));
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
			case QVTschedulePackage.CLUSTER__OWNING_REGION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRegion((Region)otherEnd, msgs);
			case QVTschedulePackage.CLUSTER__MEMBER_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMemberNodes()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.CLUSTER__MEMBER_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMemberEdges()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrecedingClusters()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSucceedingClusters()).basicAdd(otherEnd, msgs);
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
			case QVTschedulePackage.CLUSTER__OWNING_REGION:
				return basicSetOwningRegion(null, msgs);
			case QVTschedulePackage.CLUSTER__MEMBER_NODES:
				return ((InternalEList<?>)getMemberNodes()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.CLUSTER__MEMBER_EDGES:
				return ((InternalEList<?>)getMemberEdges()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS:
				return ((InternalEList<?>)getPrecedingClusters()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS:
				return ((InternalEList<?>)getSucceedingClusters()).basicRemove(otherEnd, msgs);
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
			case QVTschedulePackage.CLUSTER__OWNING_REGION:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.REGION__OWNED_CLUSTERS, Region.class, msgs);
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
			case QVTschedulePackage.CLUSTER__SYMBOL_NAME:
				return getSymbolName();
			case QVTschedulePackage.CLUSTER__OWNING_REGION:
				return getOwningRegion();
			case QVTschedulePackage.CLUSTER__MEMBER_NODES:
				return getMemberNodes();
			case QVTschedulePackage.CLUSTER__MEMBER_EDGES:
				return getMemberEdges();
			case QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS:
				return getPrecedingClusters();
			case QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS:
				return getSucceedingClusters();
			case QVTschedulePackage.CLUSTER__DEPTH:
				return getDepth();
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
			case QVTschedulePackage.CLUSTER__SYMBOL_NAME:
				setSymbolName((String)newValue);
				return;
			case QVTschedulePackage.CLUSTER__OWNING_REGION:
				setOwningRegion((Region)newValue);
				return;
			case QVTschedulePackage.CLUSTER__MEMBER_NODES:
				getMemberNodes().clear();
				getMemberNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.CLUSTER__MEMBER_EDGES:
				getMemberEdges().clear();
				getMemberEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS:
				getPrecedingClusters().clear();
				getPrecedingClusters().addAll((Collection<? extends Cluster>)newValue);
				return;
			case QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS:
				getSucceedingClusters().clear();
				getSucceedingClusters().addAll((Collection<? extends Cluster>)newValue);
				return;
			case QVTschedulePackage.CLUSTER__DEPTH:
				setDepth((Integer)newValue);
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
			case QVTschedulePackage.CLUSTER__SYMBOL_NAME:
				setSymbolName(SYMBOL_NAME_EDEFAULT);
				return;
			case QVTschedulePackage.CLUSTER__OWNING_REGION:
				setOwningRegion((Region)null);
				return;
			case QVTschedulePackage.CLUSTER__MEMBER_NODES:
				getMemberNodes().clear();
				return;
			case QVTschedulePackage.CLUSTER__MEMBER_EDGES:
				getMemberEdges().clear();
				return;
			case QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS:
				getPrecedingClusters().clear();
				return;
			case QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS:
				getSucceedingClusters().clear();
				return;
			case QVTschedulePackage.CLUSTER__DEPTH:
				setDepth(DEPTH_EDEFAULT);
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
			case QVTschedulePackage.CLUSTER__SYMBOL_NAME:
				return SYMBOL_NAME_EDEFAULT == null ? symbolName != null : !SYMBOL_NAME_EDEFAULT.equals(symbolName);
			case QVTschedulePackage.CLUSTER__OWNING_REGION:
				return getOwningRegion() != null;
			case QVTschedulePackage.CLUSTER__MEMBER_NODES:
				return memberNodes != null && !memberNodes.isEmpty();
			case QVTschedulePackage.CLUSTER__MEMBER_EDGES:
				return memberEdges != null && !memberEdges.isEmpty();
			case QVTschedulePackage.CLUSTER__PRECEDING_CLUSTERS:
				return precedingClusters != null && !precedingClusters.isEmpty();
			case QVTschedulePackage.CLUSTER__SUCCEEDING_CLUSTERS:
				return succeedingClusters != null && !succeedingClusters.isEmpty();
			case QVTschedulePackage.CLUSTER__DEPTH:
				return DEPTH_EDEFAULT == null ? depth != null : !DEPTH_EDEFAULT.equals(depth);
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
		if (baseClass == Symbolable.class) {
			switch (derivedFeatureID) {
				case QVTschedulePackage.CLUSTER__SYMBOL_NAME: return QVTschedulePackage.SYMBOLABLE__SYMBOL_NAME;
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
		if (baseClass == Symbolable.class) {
			switch (baseFeatureID) {
				case QVTschedulePackage.SYMBOLABLE__SYMBOL_NAME: return QVTschedulePackage.CLUSTER__SYMBOL_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (symbolName: ");
		result.append(symbolName);
		result.append(", depth: ");
		result.append(depth);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitCluster(this);
	}


} //ClusterImpl
