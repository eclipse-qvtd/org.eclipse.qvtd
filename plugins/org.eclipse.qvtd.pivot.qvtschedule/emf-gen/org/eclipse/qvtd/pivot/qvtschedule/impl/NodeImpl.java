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
import java.util.Collections;
import java.util.List;
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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Cluster;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getClassDatum <em>Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getCluster <em>Cluster</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getIncomingConnection <em>Incoming Connection</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getNodeRole <em>Node Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getOwningRegion <em>Owning Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NodeImpl extends ElementImpl implements Node {
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
	 * The cached value of the '{@link #getCluster() <em>Cluster</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCluster()
	 * @generated
	 * @ordered
	 */
	protected Cluster cluster;

	/**
	 * The cached value of the '{@link #getIncomingConnection() <em>Incoming Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingConnection()
	 * @generated
	 * @ordered
	 */
	protected NodeConnection incomingConnection;

	/**
	 * The cached value of the '{@link #getIncomingEdges() <em>Incoming Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> incomingEdges;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNodeRole() <em>Node Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeRole()
	 * @generated
	 * @ordered
	 */
	protected static final Role NODE_ROLE_EDEFAULT = Role.CONSTANT;

	/**
	 * The cached value of the '{@link #getNodeRole() <em>Node Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeRole()
	 * @generated
	 * @ordered
	 */
	protected Role nodeRole = NODE_ROLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoingConnections() <em>Outgoing Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeConnection> outgoingConnections;

	/**
	 * The cached value of the '{@link #getOutgoingEdges() <em>Outgoing Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> outgoingEdges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NODE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.NODE__CLASS_DATUM, oldClassDatum, classDatum));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE__CLASS_DATUM, oldClassDatum, classDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Cluster getCluster() {
		if (cluster != null && cluster.eIsProxy()) {
			InternalEObject oldCluster = (InternalEObject)cluster;
			cluster = (Cluster)eResolveProxy(oldCluster);
			if (cluster != oldCluster) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.NODE__CLUSTER, oldCluster, cluster));
			}
		}
		return cluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cluster basicGetCluster() {
		return cluster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCluster(Cluster newCluster, NotificationChain msgs) {
		Cluster oldCluster = cluster;
		cluster = newCluster;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE__CLUSTER, oldCluster, newCluster);
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
	public void setCluster(Cluster newCluster) {
		if (newCluster != cluster) {
			NotificationChain msgs = null;
			if (cluster != null)
				msgs = ((InternalEObject)cluster).eInverseRemove(this, QVTschedulePackage.CLUSTER__MEMBER_NODES, Cluster.class, msgs);
			if (newCluster != null)
				msgs = ((InternalEObject)newCluster).eInverseAdd(this, QVTschedulePackage.CLUSTER__MEMBER_NODES, Cluster.class, msgs);
			msgs = basicSetCluster(newCluster, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE__CLUSTER, newCluster, newCluster));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeConnection getIncomingConnection() {
		if (incomingConnection != null && incomingConnection.eIsProxy()) {
			InternalEObject oldIncomingConnection = (InternalEObject)incomingConnection;
			incomingConnection = (NodeConnection)eResolveProxy(oldIncomingConnection);
			if (incomingConnection != oldIncomingConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.NODE__INCOMING_CONNECTION, oldIncomingConnection, incomingConnection));
			}
		}
		return incomingConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeConnection basicGetIncomingConnection() {
		return incomingConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncomingConnection(NodeConnection newIncomingConnection) {
		NodeConnection oldIncomingConnection = incomingConnection;
		incomingConnection = newIncomingConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE__INCOMING_CONNECTION, oldIncomingConnection, incomingConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role getNodeRole() {
		return nodeRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNodeRole(Role newNodeRole) {
		Role oldNodeRole = nodeRole;
		nodeRole = newNodeRole == null ? NODE_ROLE_EDEFAULT : newNodeRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE__NODE_ROLE, oldNodeRole, nodeRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<NodeConnection> getOutgoingConnections() {
		if (outgoingConnections == null) {
			outgoingConnections = new EObjectResolvingEList<NodeConnection>(NodeConnection.class, this, QVTschedulePackage.NODE__OUTGOING_CONNECTIONS);
		}
		return outgoingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Edge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, QVTschedulePackage.NODE__INCOMING_EDGES, QVTschedulePackage.EDGE__TARGET_NODE);
		}
		return incomingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Edge> getOutgoingEdges() {
		if (outgoingEdges == null) {
			outgoingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, QVTschedulePackage.NODE__OUTGOING_EDGES, QVTschedulePackage.EDGE__SOURCE_NODE);
		}
		return outgoingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getOwningRegion() {
		if (eContainerFeatureID() != QVTschedulePackage.NODE__OWNING_REGION) return null;
		return (Region)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRegion(Region newOwningRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRegion, QVTschedulePackage.NODE__OWNING_REGION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRegion(Region newOwningRegion) {
		if (newOwningRegion != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.NODE__OWNING_REGION && newOwningRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRegion != null)
				msgs = ((InternalEObject)newOwningRegion).eInverseAdd(this, QVTschedulePackage.REGION__OWNED_NODES, Region.class, msgs);
			msgs = basicSetOwningRegion(newOwningRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NODE__OWNING_REGION, newOwningRegion, newOwningRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.NODE__CLASS_DATUM:
				if (resolve) return getClassDatum();
				return basicGetClassDatum();
			case QVTschedulePackage.NODE__CLUSTER:
				if (resolve) return getCluster();
				return basicGetCluster();
			case QVTschedulePackage.NODE__INCOMING_CONNECTION:
				if (resolve) return getIncomingConnection();
				return basicGetIncomingConnection();
			case QVTschedulePackage.NODE__INCOMING_EDGES:
				return getIncomingEdges();
			case QVTschedulePackage.NODE__NAME:
				return getName();
			case QVTschedulePackage.NODE__NODE_ROLE:
				return getNodeRole();
			case QVTschedulePackage.NODE__OUTGOING_CONNECTIONS:
				return getOutgoingConnections();
			case QVTschedulePackage.NODE__OUTGOING_EDGES:
				return getOutgoingEdges();
			case QVTschedulePackage.NODE__OWNING_REGION:
				return getOwningRegion();
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
			case QVTschedulePackage.NODE__CLASS_DATUM:
				setClassDatum((ClassDatum)newValue);
				return;
			case QVTschedulePackage.NODE__CLUSTER:
				setCluster((Cluster)newValue);
				return;
			case QVTschedulePackage.NODE__INCOMING_CONNECTION:
				setIncomingConnection((NodeConnection)newValue);
				return;
			case QVTschedulePackage.NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case QVTschedulePackage.NODE__NAME:
				setName((String)newValue);
				return;
			case QVTschedulePackage.NODE__NODE_ROLE:
				setNodeRole((Role)newValue);
				return;
			case QVTschedulePackage.NODE__OUTGOING_CONNECTIONS:
				getOutgoingConnections().clear();
				getOutgoingConnections().addAll((Collection<? extends NodeConnection>)newValue);
				return;
			case QVTschedulePackage.NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case QVTschedulePackage.NODE__OWNING_REGION:
				setOwningRegion((Region)newValue);
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
			case QVTschedulePackage.NODE__CLASS_DATUM:
				setClassDatum((ClassDatum)null);
				return;
			case QVTschedulePackage.NODE__CLUSTER:
				setCluster((Cluster)null);
				return;
			case QVTschedulePackage.NODE__INCOMING_CONNECTION:
				setIncomingConnection((NodeConnection)null);
				return;
			case QVTschedulePackage.NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case QVTschedulePackage.NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case QVTschedulePackage.NODE__NODE_ROLE:
				setNodeRole(NODE_ROLE_EDEFAULT);
				return;
			case QVTschedulePackage.NODE__OUTGOING_CONNECTIONS:
				getOutgoingConnections().clear();
				return;
			case QVTschedulePackage.NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case QVTschedulePackage.NODE__OWNING_REGION:
				setOwningRegion((Region)null);
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
			case QVTschedulePackage.NODE__CLASS_DATUM:
				return classDatum != null;
			case QVTschedulePackage.NODE__CLUSTER:
				return cluster != null;
			case QVTschedulePackage.NODE__INCOMING_CONNECTION:
				return incomingConnection != null;
			case QVTschedulePackage.NODE__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case QVTschedulePackage.NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case QVTschedulePackage.NODE__NODE_ROLE:
				return nodeRole != NODE_ROLE_EDEFAULT;
			case QVTschedulePackage.NODE__OUTGOING_CONNECTIONS:
				return outgoingConnections != null && !outgoingConnections.isEmpty();
			case QVTschedulePackage.NODE__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case QVTschedulePackage.NODE__OWNING_REGION:
				return getOwningRegion() != null;
		}
		return super.eIsSet(featureID);
	}

	private boolean isDataType;
	private boolean isHead = false;
	private boolean isContained = false;

	private /*@LazyNonNull*/ Utility utility = null;		// Set by post region build analysis

	@Override
	public void addOriginatingElement(@NonNull Element originatingElement) {
		throw new UnsupportedOperationException();		// Should be MappingNode
	}

	@Override
	public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		toGraphHelper.setHead(this);
		//	boolean isHead = isHead();
		//	if (isHead) {
		//		s.setHead();
		//			s.append("{rank=source;");
		//	}
		toGraphHelper.setLabel(this);
		toGraphHelper.setShapeAndStyle(this);
		toGraphHelper.setColor(this);
		if (!isUnconditional()) {
			s.setFillColor(getFillColor());
		}
		toGraphHelper.setPenwidth(this);
		s.appendAttributedNode(nodeName);
		//		if (isHead) {
		//			s.append("}");
		//		}
	}

	@Override
	public @Nullable Element basicGetOriginatingElement() {
		return null;
	}

	@Override
	public @Nullable VariableDeclaration basicGetOriginatingVariable() {
		return null;
	}

	@Override
	public @Nullable Utility basicGetUtility() {
		return utility;
	}

	@Override
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		NodeImpl node = (NodeImpl)QVTscheduleFactory.eINSTANCE.create(eClass());
		node.initialize(nodeRole, region, name, classDatum);
		return node;
	}

	@Override
	public void destroy() {
		assert getOwningRegion() != null;
		setOwningRegion(null);
		Connection incomingConnection2 = incomingConnection;
		if (incomingConnection2 != null) {
			incomingConnection2.destroy();
		}
		List<NodeConnection> outgoingConnections2 = outgoingConnections;
		if (outgoingConnections2 != null) {
			while (!outgoingConnections2.isEmpty()) {
				outgoingConnections2.get(0).destroy();
			}
		}
		List<Edge> incomingEdges2 = getIncomingEdges();
		while (!incomingEdges2.isEmpty()) {
			incomingEdges2.get(0).destroy();
		}
		List<Edge> outgoingEdges2 = getOutgoingEdges();
		while (!outgoingEdges2.isEmpty()) {
			outgoingEdges2.get(0).destroy();
		}
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getArgumentEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getIncomingEdges(this), QVTscheduleUtil.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getCastEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsCastEdgePredicate.INSTANCE);
		return filter;
	}

	/*	@Override
	public @NonNull Node getCastEquivalentNode() {
		List<Edge> outgoingEdges = getOutgoingEdges();
		if ((outgoingEdges != null) && (outgoingEdges.size() == 1)) {
			Edge edge = outgoingEdges.get(0);
			if (edge.isCast()) {
				return edge.getTarget();
			}
		}
		return this;
	} */

	@Override
	public @NonNull String getColor() {
		assert nodeRole != null;
		return QVTscheduleUtil.getColor(nodeRole);
	}

	@Override
	public @NonNull CompleteClass getCompleteClass() {
		return QVTscheduleUtil.getCompleteClass(QVTscheduleUtil.getClassDatum(this));
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getComputationEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsComputationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull String getDisplayName() {
		Region region = getOwningRegion();
		assert region != null;
		return region.getName() + "::" + getName();
	}

	protected @NonNull String getFillColor() {
		assert nodeRole != null;
		return QVTscheduleUtil.getFillColor(nodeRole);
	}

	@Override
	public final @Nullable NodeConnection getIncomingPassedConnection() {
		NodeConnection incomingConnection2 = incomingConnection;
		if ((incomingConnection2 != null) && incomingConnection2.isPassed()) {
			return incomingConnection2;
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull String getLabel() {
		StringBuilder n = new StringBuilder();
		n.append(getName());
		if (!isNullLiteral() && !isSuccess()) {
			n.append("\\n");
			n.append(PrettyPrinter.printType(getCompleteClass().getPrimaryClass()));
		}
		return n.toString();
	}

	@Override
	public @Nullable NavigableEdge getNavigableEdge(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(this)) {
			if (edge instanceof NavigableEdge) {
				NavigableEdge navigationEdge = (NavigableEdge)edge;
				if ((navigationEdge.getProperty() == source2targetProperty) && !navigationEdge.isPartial()) {
					return navigationEdge;
				}
			}
		}
		return null;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getNavigableEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsNavigableEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @Nullable Node getNavigableTarget(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(this)) {
			if (edge instanceof NavigableEdge) {
				NavigableEdge navigationEdge = (NavigableEdge)edge;
				if ((navigationEdge.getProperty() == source2targetProperty) && !navigationEdge.isPartial()) {
					return navigationEdge.getEdgeTarget();
				}
			}
		}
		return null;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getNavigableTargets() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsNavigableEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, QVTscheduleUtil.EdgeTargetFunction.INSTANCE);
		return transform;
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
			case QVTschedulePackage.NODE__CLUSTER:
				if (cluster != null)
					msgs = ((InternalEObject)cluster).eInverseRemove(this, QVTschedulePackage.CLUSTER__MEMBER_NODES, Cluster.class, msgs);
				return basicSetCluster((Cluster)otherEnd, msgs);
			case QVTschedulePackage.NODE__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.NODE__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.NODE__OWNING_REGION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRegion((Region)otherEnd, msgs);
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
			case QVTschedulePackage.NODE__CLUSTER:
				return basicSetCluster(null, msgs);
			case QVTschedulePackage.NODE__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.NODE__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.NODE__OWNING_REGION:
				return basicSetOwningRegion(null, msgs);
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
			case QVTschedulePackage.NODE__OWNING_REGION:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.REGION__OWNED_NODES, Region.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	public final @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections() {
		@NonNull Iterable<@NonNull NodeConnection> filter = Iterables.filter(QVTscheduleUtil.getOutgoingConnections(this), QVTscheduleUtil.IsPassedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedBindingEdges() {
		@NonNull Iterable<@NonNull NodeConnection> filter = Iterables.filter(QVTscheduleUtil.getOutgoingConnections(this), QVTscheduleUtil.IsUsedBindingEdgePredicate.INSTANCE);
		return filter;
	}

	/*	@Override
	public @NonNull Iterable<@NonNull Node> getPassedBindingTargets() {
		List<@NonNull Node> targets = new ArrayList<>();
		for (@NonNull NodeConnection connection : getOutgoingPassedConnections()) {
			for (@NonNull Node target : StaticConnectionManager.INSTANCE.rawGetTargetNodes(connection)) {
				if (!targets.contains(target)) {
					targets.add(target);
				}
			}
		}
		return targets;
	} */

	protected @NonNull Integer getPenwidth() {
		return isHead() ? QVTscheduleConstants.HEAD_WIDTH : !isExpression() ? 2*QVTscheduleConstants.LINE_WIDTH : QVTscheduleConstants.LINE_WIDTH;
	}

	@Override
	public final @Nullable Edge getPredicateEdge(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(this)) {
			if (edge.isPredicated() && (edge instanceof NavigableEdge)) {
				if (((NavigableEdge)edge).getProperty() == source2targetProperty) {
					return edge;
				}
			}
		}
		return null;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getPredicateEdges() {
		@SuppressWarnings("unchecked")
		Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigationEdge> getRealizedNavigationEdges() {
		@SuppressWarnings("unchecked")
		Iterable<@NonNull NavigationEdge> filter = (Iterable<@NonNull NavigationEdge>)(Object)Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsRealizedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRecursionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getRecursionSources() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getIncomingEdges(this), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, QVTscheduleUtil.EdgeSourceFunction.INSTANCE);
		return transform;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getRecursionTargets() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		@NonNull Iterable<@NonNull Node> transform = Iterables.transform(filter, QVTscheduleUtil.EdgeTargetFunction.INSTANCE);
		return transform;
	}

	@Override
	public final @NonNull Iterable<@NonNull ? extends Edge> getResultEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOutgoingEdges(this), QVTscheduleUtil.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	/*	//	@Override
	public ScheduleModel getScheduleModel() {
		Region region = getOwningRegion();
		assert region != null;
		return region.getScheduleModel();
	} */

	@Override
	public @Nullable String getShape() {
		return null;
	}

	@Override
	public @Nullable String getStyle() {
		StringBuilder s = new StringBuilder();
		if (isDataType()) {
			s.append("rounded");
		}
		if (!isMatched()) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append("dashed");
		}
		if (!isUnconditional()) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append("filled");
		}
		return "\"" + s.toString() + "\"";
	}

	@Override
	public @NonNull Element getOriginatingElement() {
		throw new UnsupportedOperationException();		// Should be MappingNode
	}

	@Override
	public @NonNull Iterable<@NonNull Element> getOriginatingElements() {
		return Collections.emptyList();
	}

	@Override
	public @NonNull Utility getUtility() {
		return ClassUtil.nonNullState(utility);
	}

	@Override
	public void initialize(@NonNull Role nodeRole, @NonNull Region region, /*@NonNull*/ String name, /*@NonNull*/ ClassDatum classDatum) {
		assert name != null;
		assert classDatum != null;
		setNodeRole(nodeRole);
		setOwningRegion(region);
		setName(name);
		setClassDatum(classDatum);
		this.isDataType = classDatum.getCompleteClass().getPrimaryClass() instanceof DataType;
	}

	@Override
	public boolean isChecked() {
		assert nodeRole != null;
		return nodeRole.isChecked();
	}

	@Override
	public final boolean isClass() {
		return !isDataType;
	}

	@Override
	public boolean isComposed() {
		return false;
	}

	@Override
	public boolean isConstant() {
		assert nodeRole != null;
		return nodeRole == Role.CONSTANT;
	}

	@Override
	public boolean isContained() {
		return isContained;
	}

	@Override
	public final boolean isDataType() {
		return isDataType;
	}

	@Override
	public boolean isDependency() {
		return false;
	}

	@Override
	public boolean isDispatch() {
		return getUtility() == Utility.DISPATCH;
	}

	@Override
	public boolean isNullLiteral() {
		return false;
	}

	@Override
	public boolean isExpression() {
		return false;
	}

	@Override
	public boolean isHead() {
		return isHead;
	}

	@Override
	public boolean isIterator() {
		return false;
	}

	@Override
	public boolean isLoaded() {
		assert nodeRole != null;
		return nodeRole == Role.LOADED;
	}

	@Override
	public boolean isMatched() {
		return false;
	}

	@Override
	public boolean isNew() {
		assert nodeRole != null;
		return nodeRole.isNew();
	}

	@Override
	public boolean isOld() {
		assert nodeRole != null;
		return nodeRole.isOld();
	}

	@Override
	public boolean isOperation() {
		return false;
	}

	@Override
	public boolean isPattern() {
		return false;
	}

	@Override
	public boolean isPredicated() {
		assert nodeRole != null;
		if (nodeRole == Role.SPECULATED) {
			assert nodeRole != null;
			return nodeRole == Role.PREDICATED;
		}
		else {
			assert nodeRole != null;
			return nodeRole == Role.PREDICATED;
		}
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public boolean isRealized() {
		assert nodeRole != null;
		return nodeRole == Role.REALIZED;
	}

	@Override
	public boolean isRequired() {
		throw new UnsupportedOperationException();		// Should be MappingNode
	}

	@Override
	public boolean isSpeculated() {
		assert nodeRole != null;
		return nodeRole == Role.SPECULATED;
	}

	@Override
	public boolean isSpeculation() {
		assert nodeRole != null;
		return nodeRole == Role.SPECULATION;
	}

	@Override
	public boolean isSuccess() {
		return false;
	}

	@Override
	public boolean isTrace() {
		return getUtility() == Utility.TRACE;
	}

	@Override
	public boolean isUnconditional() {
		return QVTscheduleUtil.isUnconditional(utility);
	}

	/*	@Override
	public boolean refineClassDatumAnalysis(@NonNull ClassDatumAnalysis newClassDatumAnalysis) {
		ClassDatumAnalysis classDatumAnalysis2 = QVTscheduleUtil.getClassDatumAnalysis(this);
		CompleteClass oldCompleteClass = QVTscheduleUtil.getCompleteClass(classDatumAnalysis2);
		CompleteClass newCompleteClass = QVTscheduleUtil.getCompleteClass(newClassDatumAnalysis);
		if (oldCompleteClass.conformsTo(newCompleteClass)) {
			DomainUsageAnalysis.Root domainAnalysis = getScheduleModel().getDomainAnalysis();
			DomainUsage.Internal oldDomainUsage = (DomainUsage.Internal) classDatumAnalysis2.getDomainUsage();
			DomainUsage.Internal newDomainUsage = (DomainUsage.Internal) newClassDatumAnalysis.getDomainUsage();
			int refinedBitMask = oldDomainUsage.getMask() & newDomainUsage.getMask();
			DomainUsage refinedDomainUsage = domainAnalysis.getConstantUsage(refinedBitMask);
			TypedModel refinedTypedModel = refinedDomainUsage.getTypedModel(oldCompleteClass);
			assert refinedTypedModel != null;
			classDatumAnalysis = getScheduleModel().getClassDatumAnalysis(oldCompleteClass, refinedTypedModel);
			return true;
		}
		else if (newCompleteClass.conformsTo(oldCompleteClass)) {
			DomainUsageAnalysis.Root domainAnalysis = getScheduleModel().getDomainAnalysis();
			DomainUsage.Internal oldDomainUsage = (DomainUsage.Internal) classDatumAnalysis2.getDomainUsage();
			DomainUsage.Internal newDomainUsage = (DomainUsage.Internal) newClassDatumAnalysis.getDomainUsage();
			int refinedBitMask = oldDomainUsage.getMask() & newDomainUsage.getMask();
			DomainUsage refinedDomainUsage = domainAnalysis.getConstantUsage(refinedBitMask);
			TypedModel refinedTypedModel = refinedDomainUsage.getTypedModel(newCompleteClass);
			assert refinedTypedModel != null;
			classDatumAnalysis = getScheduleModel().getClassDatumAnalysis(newCompleteClass, refinedTypedModel);
			return true;
		}
		else if (oldCompleteClass.getPrimaryClass().getESObject() == EcorePackage.Literals.EOBJECT) {
			classDatumAnalysis = newClassDatumAnalysis;
			return true;
		}
		else {
			return false;
		}
	} */

	@Override
	public void resetHead() {
		this.isHead = false;
	}

	@Override
	public void setContained(boolean isContained) {
		this.isContained = isContained;
	}

	@Override
	public void setHead() {
		this.isHead = true;
	}

	@Override
	public void setOriginatingVariable(@NonNull VariableDeclaration variable) {
		throw new UnsupportedOperationException();		// Should be MappingNode
	}

	@Override
	public void setRequired() {
		throw new UnsupportedOperationException();		// Should be MappingNode
	}

	@Override
	public void setUtility(@NonNull Utility utility) {
		assert (this.utility == null) || (this.utility == utility);
		this.utility = utility;
	}

	@Override
	public @NonNull String toString() {
		Role nodeRole = getNodeRole();
		StringBuilder s = new StringBuilder();
		s.append(nodeRole);
		s.append("-");
		s.append(eClass().getName());
		s.append("(");
		s.append(getName());
		s.append(" : ");
		s.append(String.valueOf(classDatum));
		s.append(")");
		return s.toString();
	}

} //NodeImpl
