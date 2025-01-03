/**
 * <copyright>
 *
 * Copyright (c) 2013, 2020 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MergedPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getConstantEdges <em>Constant Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getConstantNodes <em>Constant Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getConstantSuccessFalseNodes <em>Constant Success False Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getConstantSuccessTrueNodes <em>Constant Success True Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getExplicitPredecessors <em>Explicit Predecessors</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getHeadNodes <em>Head Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getLoadedEdges <em>Loaded Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getLoadedNodes <em>Loaded Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getPredicatedEdges <em>Predicated Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getPredicatedNodes <em>Predicated Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getRealizedEdges <em>Realized Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getRealizedNodes <em>Realized Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getSpeculatedEdges <em>Speculated Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getSpeculatedNodes <em>Speculated Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getSpeculationNodes <em>Speculation Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicPartitionImpl#getOwningMergedPartition <em>Owning Merged Partition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicPartitionImpl extends MappingPartitionImpl implements BasicPartition
{
	/**
	 * The number of structural features of the '<em>Basic Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASIC_PARTITION_FEATURE_COUNT = MappingPartitionImpl.MAPPING_PARTITION_FEATURE_COUNT + 16;
	/**
	 * The number of operations of the '<em>Basic Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BASIC_PARTITION_OPERATION_COUNT = MappingPartitionImpl.MAPPING_PARTITION_OPERATION_COUNT + 0;

	/**
	 * EdgeList duplicates changes to the lists-of-edges to the 'redundant' edge-to-role map.
	 */
	@SuppressWarnings("serial")
	protected static class EdgeList extends EObjectResolvingEList<@NonNull Edge>
	{
		protected final @NonNull Role edgeRole;
		private final @NonNull Map<@NonNull Edge, @NonNull Role> edge2edgeRole;

		protected EdgeList(@NonNull BasicPartitionImpl owner, int featureID, @NonNull Role edgeRole) {
			super(Edge.class, owner, featureID);
			this.edgeRole = edgeRole;
			this.edge2edgeRole = owner.edge2edgeRole;
		}

		@Override
		protected void didAdd(int index, @NonNull Edge newObject) {
			edge2edgeRole.put(newObject, edgeRole);
		}

		@Override
		protected void didRemove(int index, @NonNull Edge oldObject) {
			edge2edgeRole.remove(oldObject);
		}
	}

	/**
	 * NodeList duplicates changes to the lists-of-nodes to the 'redundant' node-to-role map.
	 */
	@SuppressWarnings("serial")
	protected static class NodeList extends EObjectResolvingEList<@NonNull Node>
	{
		private final @NonNull Role nodeRole;
		private final @NonNull Map<@NonNull Node, @NonNull Role> node2nodeRole;

		protected NodeList(@NonNull BasicPartitionImpl owner, int featureID, @NonNull Role nodeRole) {
			super(Node.class, owner, featureID);
			this.nodeRole = nodeRole;
			this.node2nodeRole = owner.node2nodeRole;
		}

		@Override
		protected void didAdd(int index, @NonNull Node newObject) {
			node2nodeRole.put(newObject, nodeRole);
		}

		@Override
		protected void didRemove(int index, @NonNull Node oldObject) {
			node2nodeRole.remove(oldObject);
		}
	}

	/**
	 * The cached value of the '{@link #getConstantEdges() <em>Constant Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> constantEdges;
	/**
	 * The cached value of the '{@link #getConstantNodes() <em>Constant Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> constantNodes;
	/**
	 * The cached value of the '{@link #getConstantSuccessFalseNodes() <em>Constant Success False Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantSuccessFalseNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> constantSuccessFalseNodes;
	/**
	 * The cached value of the '{@link #getConstantSuccessTrueNodes() <em>Constant Success True Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantSuccessTrueNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> constantSuccessTrueNodes;
	/**
	 * The cached value of the '{@link #getExplicitPredecessors() <em>Explicit Predecessors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitPredecessors()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingPartition> explicitPredecessors;
	/**
	 * The cached value of the '{@link #getHeadNodes() <em>Head Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> headNodes;
	/**
	 * The cached value of the '{@link #getLoadedEdges() <em>Loaded Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> loadedEdges;
	/**
	 * The cached value of the '{@link #getLoadedNodes() <em>Loaded Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> loadedNodes;
	/**
	 * The cached value of the '{@link #getPredicatedEdges() <em>Predicated Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicatedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> predicatedEdges;
	/**
	 * The cached value of the '{@link #getPredicatedNodes() <em>Predicated Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicatedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> predicatedNodes;
	/**
	 * The cached value of the '{@link #getRealizedEdges() <em>Realized Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> realizedEdges;
	/**
	 * The cached value of the '{@link #getRealizedNodes() <em>Realized Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> realizedNodes;
	/**
	 * The cached value of the '{@link #getSpeculatedEdges() <em>Speculated Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeculatedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> speculatedEdges;
	/**
	 * The cached value of the '{@link #getSpeculatedNodes() <em>Speculated Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeculatedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> speculatedNodes;

	/**
	 * The cached value of the '{@link #getSpeculationNodes() <em>Speculation Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeculationNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> speculationNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.BASIC_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Edge> getConstantEdges() {
		if (constantEdges == null) {
			constantEdges = new EdgeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_EDGES.getFeatureID(), Role.CONSTANT);
		}
		return constantEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getConstantNodes() {
		if (constantNodes == null) {
			constantNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_NODES.getFeatureID(), Role.CONSTANT);
		}
		return constantNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getConstantSuccessFalseNodes() {
		if (constantSuccessFalseNodes == null) {
			constantSuccessFalseNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_FALSE_NODES.getFeatureID(), Role.CONSTANT_SUCCESS_FALSE);
		}
		return constantSuccessFalseNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getConstantSuccessTrueNodes() {
		if (constantSuccessTrueNodes == null) {
			constantSuccessTrueNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__CONSTANT_SUCCESS_TRUE_NODES.getFeatureID(), Role.CONSTANT_SUCCESS_TRUE);
		}
		return constantSuccessTrueNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Node> getHeadNodes() {
		if (headNodes == null) {
			headNodes = new EObjectResolvingEList<Node>(Node.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 12);
		}
		return headNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Edge> getLoadedEdges() {
		if (loadedEdges == null) {
			loadedEdges = new EdgeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_EDGES.getFeatureID(), Role.LOADED);
		}
		return loadedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getLoadedNodes() {
		if (loadedNodes == null) {
			loadedNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__LOADED_NODES.getFeatureID(), Role.LOADED);
		}
		return loadedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Edge> getPredicatedEdges() {
		if (predicatedEdges == null) {
			predicatedEdges = new EdgeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_EDGES.getFeatureID(), Role.PREDICATED);
		}
		return predicatedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getPredicatedNodes() {
		if (predicatedNodes == null) {
			predicatedNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__PREDICATED_NODES.getFeatureID(), Role.PREDICATED);
		}
		return predicatedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Edge> getRealizedEdges() {
		if (realizedEdges == null) {
			realizedEdges = new EdgeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_EDGES.getFeatureID(), Role.REALIZED);
		}
		return realizedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getRealizedNodes() {
		if (realizedNodes == null) {
			realizedNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__REALIZED_NODES.getFeatureID(), Role.REALIZED);
		}
		return realizedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Edge> getSpeculatedEdges() {
		if (speculatedEdges == null) {
			speculatedEdges = new EdgeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_EDGES.getFeatureID(), Role.SPECULATED);
		}
		return speculatedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getSpeculatedNodes() {
		if (speculatedNodes == null) {
			speculatedNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATED_NODES.getFeatureID(), Role.SPECULATED);
		}
		return speculatedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Node> getSpeculationNodes() {
		if (speculationNodes == null) {
			speculationNodes = new NodeList(this, QVTschedulePackage.Literals.BASIC_PARTITION__SPECULATION_NODES.getFeatureID(), Role.SPECULATION);
		}
		return speculationNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MergedPartition getOwningMergedPartition() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22)) return null;
		return (MergedPartition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMergedPartition(MergedPartition newOwningMergedPartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMergedPartition, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningMergedPartition(MergedPartition newOwningMergedPartition) {
		if (newOwningMergedPartition != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22) && newOwningMergedPartition != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMergedPartition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMergedPartition != null)
				msgs = ((InternalEObject)newOwningMergedPartition).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 23, MergedPartition.class, msgs);
			msgs = basicSetOwningMergedPartition(newOwningMergedPartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22, newOwningMergedPartition, newOwningMergedPartition));
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExplicitPredecessors()).basicAdd(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningMergedPartition((MergedPartition)otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11:
				return ((InternalEList<?>)getExplicitPredecessors()).basicRemove(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22:
				return basicSetOwningMergedPartition(null, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22:
				return eInternalContainer().eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 23, MergedPartition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MappingPartition> getExplicitPredecessors() {
		if (explicitPredecessors == null) {
			explicitPredecessors = new EObjectWithInverseResolvingEList.ManyInverse<MappingPartition>(MappingPartition.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6);
		}
		return explicitPredecessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return getConstantEdges();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				return getConstantNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				return getConstantSuccessFalseNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
				return getConstantSuccessTrueNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11:
				return getExplicitPredecessors();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 12:
				return getHeadNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 13:
				return getLoadedEdges();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 14:
				return getLoadedNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 15:
				return getPredicatedEdges();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 16:
				return getPredicatedNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 17:
				return getRealizedEdges();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 18:
				return getRealizedNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 19:
				return getSpeculatedEdges();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 20:
				return getSpeculatedNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 21:
				return getSpeculationNodes();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22:
				return getOwningMergedPartition();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				getConstantEdges().clear();
				getConstantEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				getConstantNodes().clear();
				getConstantNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				getConstantSuccessFalseNodes().clear();
				getConstantSuccessFalseNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
				getConstantSuccessTrueNodes().clear();
				getConstantSuccessTrueNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11:
				getExplicitPredecessors().clear();
				getExplicitPredecessors().addAll((Collection<? extends MappingPartition>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 12:
				getHeadNodes().clear();
				getHeadNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 13:
				getLoadedEdges().clear();
				getLoadedEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 14:
				getLoadedNodes().clear();
				getLoadedNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 15:
				getPredicatedEdges().clear();
				getPredicatedEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 16:
				getPredicatedNodes().clear();
				getPredicatedNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 17:
				getRealizedEdges().clear();
				getRealizedEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 18:
				getRealizedNodes().clear();
				getRealizedNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 19:
				getSpeculatedEdges().clear();
				getSpeculatedEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 20:
				getSpeculatedNodes().clear();
				getSpeculatedNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 21:
				getSpeculationNodes().clear();
				getSpeculationNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22:
				setOwningMergedPartition((MergedPartition)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				getConstantEdges().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				getConstantNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				getConstantSuccessFalseNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
				getConstantSuccessTrueNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11:
				getExplicitPredecessors().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 12:
				getHeadNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 13:
				getLoadedEdges().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 14:
				getLoadedNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 15:
				getPredicatedEdges().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 16:
				getPredicatedNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 17:
				getRealizedEdges().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 18:
				getRealizedNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 19:
				getSpeculatedEdges().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 20:
				getSpeculatedNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 21:
				getSpeculationNodes().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22:
				setOwningMergedPartition((MergedPartition)null);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return constantEdges != null && !constantEdges.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8:
				return constantNodes != null && !constantNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9:
				return constantSuccessFalseNodes != null && !constantSuccessFalseNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 10:
				return constantSuccessTrueNodes != null && !constantSuccessTrueNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 11:
				return explicitPredecessors != null && !explicitPredecessors.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 12:
				return headNodes != null && !headNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 13:
				return loadedEdges != null && !loadedEdges.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 14:
				return loadedNodes != null && !loadedNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 15:
				return predicatedEdges != null && !predicatedEdges.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 16:
				return predicatedNodes != null && !predicatedNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 17:
				return realizedEdges != null && !realizedEdges.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 18:
				return realizedNodes != null && !realizedNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 19:
				return speculatedEdges != null && !speculatedEdges.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 20:
				return speculatedNodes != null && !speculatedNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 21:
				return speculationNodes != null && !speculationNodes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 22:
				return getOwningMergedPartition() != null;
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
		if (visitor instanceof QVTscheduleVisitor) {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitBasicPartition(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	/**
	 * The nodes of region that are required by the partition and the nodeRole that each node plays in the partition.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Role> node2nodeRole = new HashMap<>();

	/**
	 * The edges of region that are required by the partition and the edgeRole that each edge plays in the partition.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull Role> edge2edgeRole = new HashMap<>();

	@Override
	public void addExplicitPredecessor(@NonNull BasicPartition speculationPartition) {
		getExplicitPredecessors().add(speculationPartition);
	}

	@Override
	public Region basicGetRegion() {
		return getReferedMappingRegion();
	}

	/**
	 * Return true of all required predecessor of targetNOde are available for use by this partition.
	 *
	protected boolean allPredecessorsAreAvailable(@NonNull Node targetNode) {
		List<@NonNull Node> requiredNodes = new ArrayList<>(nodes);
		requiredNodes.add(targetNode);
		Map<@NonNull Node, @NonNull Role> requiredNode2nodeRole = new HashMap<>();
		for (int i = 0; i < requiredNodes.size(); i++) {
			Node node = requiredNodes.get(i);
			assert node != null;
			Edge traceEdge = partitioner.getTraceEdge(node);
			if ((traceEdge == null) || !partitioner.hasRealizedEdge(traceEdge)) {
				for (@NonNull Node precedingNode : getPredecessors(node)) {
					if (!isAvailable(node)) {
						return false;
					}
					if (!requiredNode2nodeRole.containsKey(precedingNode)) {
						requiredNode2nodeRole.put(precedingNode, QVTscheduleUtil.getNodeRole(precedingNode));
						requiredNodes.add(precedingNode);
					}
				}
			}
		}
		/*		for (@NonNull Node requiredNode : requiredNodes) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(requiredNode)) {
				if (!requiredNode2nodeRole.containsKey(precedingNode)) {
					requiredNode2nodeRole.put(precedingNode, QVTscheduleUtil.getNodeRole(precedingNode));
					requiredNodes.add(precedingNode);
				}
			}
		} * /
		return true;
	} */

	/**
	 * Verify that all unconditional nodes in the new region are reachable from its heads.
	 *
	public void check(@NonNull MappingPartitioner partitioner, @NonNull MicroMappingRegion region) {
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		for (@NonNull Node node : QVTscheduleUtil.getHeadNodes(region)) {
			checkGatherReachables(reachableNodes, node);
		}
		Set<@NonNull Node> allNodes = Sets.newHashSet(QVTscheduleUtil.getOwnedNodes(region));
		if (!reachableNodes.equals(allNodes)) {
			Set<@NonNull Node> extraNodesSet = Sets.newHashSet(reachableNodes);
			CompilerUtil.removeAll(extraNodesSet, allNodes);
			for (@NonNull Node node : extraNodesSet) {
				partitioner.addProblem(CompilerUtil.createRegionWarning(region, "unexpected " + node));
			}
			Set<@NonNull Node> missingNodesSet = Sets.newHashSet(allNodes);
			missingNodesSet.removeAll(reachableNodes);
			for (@NonNull Node node : missingNodesSet) {
				if (!node.isConstant() && !node.isUnconditional()) {
					node.isUnconditional();
					partitioner.addProblem(CompilerUtil.createRegionWarning(region, "unreachable " + node));
				}
			}
		}
	}
	private void checkGatherReachables(@NonNull Set<@NonNull Node> reachableNodes, @NonNull Node node) {
		if (node instanceof OperationNode) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation() && !edge.isConstant()) {
					if (!reachableNodes.contains(edge.getEdgeSource())) {
						return;
					}
				}
			}
		}
		if (reachableNodes.add(node)) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (/*edge.isComputation() ||* / edge.isCast() || edge.isNavigation()) {		// excludes only recursion
					checkGatherReachables(reachableNodes, edge.getEdgeSource());
				}
			}
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
				if (edge.isComputation() || edge.isCast() || edge.isNavigation()) {
					checkGatherReachables(reachableNodes, edge.getEdgeTarget());
				}
			}
		}
	} */

	@Override
	public void destroy() {
		setOwningCompositePartition(null);
		setReferedMappingRegion(null);
		getExplicitPredecessors().clear();
		getExplicitSuccessors().clear();
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return edge2edgeRole.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return node2nodeRole.keySet();
	}

	/**
	 * Return the role that the original region's edge plays in the partition. Null for none.
	 */
	@Override
	public @Nullable Role getRole(@NonNull Edge edge) {
		return edge2edgeRole.get(edge);
	}

	/**
	 * Return the role that the original region's node plays in the partition. Null for none.
	 */
	@Override
	public @Nullable Role getRole(@NonNull Node node) {
		return node2nodeRole.get(node);
	}

	/**
	 * Return true if the original region edge contributes to the partition.
	 */
	@Override
	public boolean hasEdge(@NonNull Edge edge) {
		return edge2edgeRole.containsKey(edge);
	}

	/**
	 * Return true if the original region node contributes to the partition.
	 */
	@Override
	public boolean hasNode(@NonNull Node node) {
		return node2nodeRole.containsKey(node);
	}

	@Override
	public @Nullable Role putEdgeRole(@NonNull Edge edge, @NonNull Role newEdgeRole) {
		assert node2nodeRole.get(edge.getSourceNode()) != null;
		assert node2nodeRole.get(edge.getTargetNode()) != null;
		Role oldEdgeRole = edge2edgeRole.get(edge);
		switch (newEdgeRole) {
			case CONSTANT: getConstantEdges().add(edge); break;
			//	case CONSTANT_SUCCESS_FALSE: getConstantSuccessFalseEdges().add(edge); break;
			//	case CONSTANT_SUCCESS_TRUE: getConstantSuccessTrueEdges().add(edge); break;
			case LOADED: getLoadedEdges().add(edge); break;
			case PREDICATED: getPredicatedEdges().add(edge); break;
			case REALIZED: getRealizedEdges().add(edge); break;
			case SPECULATED: getSpeculatedEdges().add(edge); break;
			//	case SPECULATION: getSpeculationEdges().add(edge); break;
			default: throw new UnsupportedOperationException(newEdgeRole.toString());
		}
		return oldEdgeRole;
	}

	@Override
	public @Nullable Role putNodeRole(@NonNull Node node, @NonNull Role newNodeRole) {
		Role oldNodeRole = node2nodeRole.get(node);
		switch (newNodeRole) {
			case CONSTANT: getConstantNodes().add(node); break;
			case CONSTANT_SUCCESS_FALSE: getConstantSuccessFalseNodes().add(node); break;
			case CONSTANT_SUCCESS_TRUE: getConstantSuccessTrueNodes().add(node); break;
			case LOADED: getLoadedNodes().add(node); break;
			case PREDICATED: getPredicatedNodes().add(node); break;
			case REALIZED: getRealizedNodes().add(node); break;
			case SPECULATED: getSpeculatedNodes().add(node); break;
			case SPECULATION: getSpeculationNodes().add(node); break;
			default: throw new UnsupportedOperationException(newNodeRole.toString());
		}
		return oldNodeRole;
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}

} //BasicPartitionImpl
