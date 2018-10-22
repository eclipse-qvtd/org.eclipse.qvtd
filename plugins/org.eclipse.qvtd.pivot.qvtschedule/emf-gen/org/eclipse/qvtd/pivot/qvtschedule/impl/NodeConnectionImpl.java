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
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl#getClassDatum <em>Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl#getMandatoryTargetNodes <em>Mandatory Target Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl#getPassedTargetNodes <em>Passed Target Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl#getPreferredTargetNodes <em>Preferred Target Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeConnectionImpl extends ConnectionImpl implements NodeConnection
{
	/**
	 * NodeList duplicates changes to the lists-of-nodes to the 'redundant' node-to-role map.
	 */
	@SuppressWarnings("serial")
	protected static class NodeList extends EObjectResolvingEList<@NonNull Node>
	{
		protected final @NonNull ConnectionRole connectionRole;
		private final @NonNull Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role;

		protected NodeList(@NonNull NodeConnectionImpl owner, int featureID, @NonNull ConnectionRole connectionRole) {
			super(Node.class, owner, featureID);
			this.connectionRole = connectionRole;
			this.targetEnd2role = owner.targetEnd2role;
		}

		@Override
		protected void didAdd(int index, @NonNull Node newObject) {
			targetEnd2role.put(newObject, connectionRole);
		}

		@Override
		protected void didRemove(int index, @NonNull Node oldObject) {
			targetEnd2role.remove(oldObject);
		}
	}

	/**
	 * The cached value of the '{@link #getClassDatum() <em>Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDatum()
	 * @generated
	 * @ordered
	 */
	protected ClassDatum classDatum;

	/**
	 * The cached value of the '{@link #getMandatoryTargetNodes() <em>Mandatory Target Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMandatoryTargetNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> mandatoryTargetNodes;
	/**
	 * The cached value of the '{@link #getPassedTargetNodes() <em>Passed Target Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassedTargetNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> passedTargetNodes;
	/**
	 * The cached value of the '{@link #getPreferredTargetNodes() <em>Preferred Target Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredTargetNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> preferredTargetNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NODE_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassDatum getClassDatum() {
		if (classDatum != null && classDatum.eIsProxy()) {
			InternalEObject oldClassDatum = (InternalEObject)classDatum;
			classDatum = (ClassDatum)eResolveProxy(oldClassDatum);
			if (classDatum != oldClassDatum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.NODE_CONNECTION__CLASS_DATUM, oldClassDatum, classDatum));
			}
		}
		return classDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDatum basicGetClassDatum() {
		return classDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassDatum(ClassDatum newClassDatum) {
		ClassDatum oldClassDatum = classDatum;
		classDatum = newClassDatum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE_CONNECTION__CLASS_DATUM, oldClassDatum, classDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getMandatoryTargetNodes() {
		if (mandatoryTargetNodes == null) {
			mandatoryTargetNodes = new NodeList(this, QVTschedulePackage.NODE_CONNECTION__MANDATORY_TARGET_NODES, ConnectionRole.MANDATORY_NODE);
		}
		return mandatoryTargetNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getPassedTargetNodes() {
		if (passedTargetNodes == null) {
			passedTargetNodes = new NodeList(this, QVTschedulePackage.NODE_CONNECTION__PASSED_TARGET_NODES, ConnectionRole.PASSED);
		}
		return passedTargetNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getPreferredTargetNodes() {
		if (preferredTargetNodes == null) {
			preferredTargetNodes = new NodeList(this, QVTschedulePackage.NODE_CONNECTION__PREFERRED_TARGET_NODES, ConnectionRole.PREFERRED_NODE);
		}
		return preferredTargetNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.NODE_CONNECTION__CLASS_DATUM:
				if (resolve) return getClassDatum();
				return basicGetClassDatum();
			case QVTschedulePackage.NODE_CONNECTION__MANDATORY_TARGET_NODES:
				return getMandatoryTargetNodes();
			case QVTschedulePackage.NODE_CONNECTION__PASSED_TARGET_NODES:
				return getPassedTargetNodes();
			case QVTschedulePackage.NODE_CONNECTION__PREFERRED_TARGET_NODES:
				return getPreferredTargetNodes();
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
			case QVTschedulePackage.NODE_CONNECTION__CLASS_DATUM:
				setClassDatum((ClassDatum)newValue);
				return;
			case QVTschedulePackage.NODE_CONNECTION__MANDATORY_TARGET_NODES:
				getMandatoryTargetNodes().clear();
				getMandatoryTargetNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.NODE_CONNECTION__PASSED_TARGET_NODES:
				getPassedTargetNodes().clear();
				getPassedTargetNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.NODE_CONNECTION__PREFERRED_TARGET_NODES:
				getPreferredTargetNodes().clear();
				getPreferredTargetNodes().addAll((Collection<? extends Node>)newValue);
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
			case QVTschedulePackage.NODE_CONNECTION__CLASS_DATUM:
				setClassDatum((ClassDatum)null);
				return;
			case QVTschedulePackage.NODE_CONNECTION__MANDATORY_TARGET_NODES:
				getMandatoryTargetNodes().clear();
				return;
			case QVTschedulePackage.NODE_CONNECTION__PASSED_TARGET_NODES:
				getPassedTargetNodes().clear();
				return;
			case QVTschedulePackage.NODE_CONNECTION__PREFERRED_TARGET_NODES:
				getPreferredTargetNodes().clear();
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
			case QVTschedulePackage.NODE_CONNECTION__CLASS_DATUM:
				return classDatum != null;
			case QVTschedulePackage.NODE_CONNECTION__MANDATORY_TARGET_NODES:
				return mandatoryTargetNodes != null && !mandatoryTargetNodes.isEmpty();
			case QVTschedulePackage.NODE_CONNECTION__PASSED_TARGET_NODES:
				return passedTargetNodes != null && !passedTargetNodes.isEmpty();
			case QVTschedulePackage.NODE_CONNECTION__PREFERRED_TARGET_NODES:
				return preferredTargetNodes != null && !preferredTargetNodes.isEmpty();
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitNodeConnection(this);
	}

	@Override
	public boolean isMandatory() {
		return getConnectionRole().isMandatory();
	}

	@Override
	public boolean isPassed() {
		return getConnectionRole().isPassed();
	}

	@Override
	public boolean isUsed() {
		return getConnectionRole().isPreferred();
	}

	private final @NonNull Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = new HashMap<>();

	@Override
	public void destroy() {
		for (@NonNull Node sourceNode : QVTscheduleUtil.getSourceEnds(this)) {
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(this), sourceNode);
			//		assert edge.getRegion() == getRegion();
			List<NodeConnection> outgoingConnections2 = sourceNode.getOutgoingConnections();
			assert outgoingConnections2 != null;
			@SuppressWarnings("unused")
			boolean wasRemoved = outgoingConnections2.remove(this);
			//		assert wasRemoved;
		}
		for (@NonNull Node targetNode : targetEnd2role.keySet()) {
			targetNode.setIncomingConnection(null);
		}
		targetEnd2role.clear();
		super.destroy();
	}

	@Override
	public @NonNull Set<@NonNull Node> getTargetKeys() {
		return targetEnd2role.keySet();
	}

	@Override
	public @Nullable ConnectionRole getTargetRole(@NonNull ConnectionEnd connectionEnd) {
		return targetEnd2role.get(connectionEnd);
	}

	@Override
	public @Nullable ConnectionRole removeTarget(@NonNull Node targetNode) {
		if (getMandatoryTargetNodes().remove(targetNode)) {
			return ConnectionRole.MANDATORY_NODE;
		}
		else if (getPassedTargetNodes().remove(targetNode)) {
			return ConnectionRole.PASSED;
		}
		else if (getPreferredTargetNodes().remove(targetNode)) {
			return ConnectionRole.PREFERRED_NODE;
		}
		else {
			return null;
		}
	}

	@Override
	public ConnectionRole setTargetRole(@NonNull Node targetNode, @NonNull ConnectionRole newConnectionRole) {
		ConnectionRole oldConnectionRole = targetEnd2role.get(targetNode);
		switch (newConnectionRole) {
			case MANDATORY_NODE: getMandatoryTargetNodes().add(targetNode); break;
			case PASSED: getPassedTargetNodes().add(targetNode); break;
			case PREFERRED_NODE: getPreferredTargetNodes().add(targetNode); break;
			default: throw new UnsupportedOperationException(newConnectionRole.toString());
		}
		return oldConnectionRole;
	}

	//	@Override
	//	public @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargetEnd2Role() {
	//		return targetEnd2role;
	//	}
} //NodeConnectionImpl
