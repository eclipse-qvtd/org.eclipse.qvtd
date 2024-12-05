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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
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
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl#getUtility <em>Utility</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NodeImpl extends ElementImpl implements Node {
	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;

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
	 * @generated NOT
	 * @ordered
	 */
	protected static final @NonNull Role NODE_ROLE_EDEFAULT = Role.CONSTANT;

	/**
	 * The cached value of the '{@link #getNodeRole() <em>Node Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeRole()
	 * @generated NOT
	 * @ordered
	 */
	protected @NonNull Role nodeRole = NODE_ROLE_EDEFAULT;

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
	 * The default value of the '{@link #getUtility() <em>Utility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtility()
	 * @generated NOT
	 * @ordered
	 */
	protected static final @NonNull Utility UTILITY_EDEFAULT = Utility.NOT_KNOWN;

	/**
	 * The cached value of the '{@link #getUtility() <em>Utility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtility()
	 * @generated NOT
	 * @ordered
	 */
	protected @NonNull Utility utility = UTILITY_EDEFAULT;

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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldClassDatum, classDatum));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldClassDatum, classDatum));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldCluster, cluster));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldCluster, newCluster);
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
				msgs = ((InternalEObject)cluster).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, Cluster.class, msgs);
			if (newCluster != null)
				msgs = ((InternalEObject)newCluster).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, Cluster.class, msgs);
			msgs = basicSetCluster(newCluster, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 1, newCluster, newCluster));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 2, oldIncomingConnection, incomingConnection));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 2, oldIncomingConnection, incomingConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull Role getNodeRole() {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 5, oldNodeRole, nodeRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<NodeConnection> getOutgoingConnections() {
		if (outgoingConnections == null) {
			outgoingConnections = new EObjectResolvingEList<NodeConnection>(NodeConnection.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 6);
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
			incomingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 3, ElementImpl.ELEMENT_FEATURE_COUNT + 5);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 4, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Edge> getOutgoingEdges() {
		if (outgoingEdges == null) {
			outgoingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 7, ElementImpl.ELEMENT_FEATURE_COUNT + 4);
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
		if (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 8)) return null;
		return (Region)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRegion(Region newOwningRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRegion, ElementImpl.ELEMENT_FEATURE_COUNT + 8, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRegion(Region newOwningRegion) {
		if (newOwningRegion != eInternalContainer() || (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 8) && newOwningRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRegion != null)
				msgs = ((InternalEObject)newOwningRegion).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, Region.class, msgs);
			msgs = basicSetOwningRegion(newOwningRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 8, newOwningRegion, newOwningRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull Utility getUtility() {
		return utility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUtility(Utility newUtility) {
		Utility oldUtility = utility;
		utility = newUtility == null ? UTILITY_EDEFAULT : newUtility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 9, oldUtility, utility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				if (resolve) return getClassDatum();
			return basicGetClassDatum();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				if (resolve) return getCluster();
			return basicGetCluster();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				if (resolve) return getIncomingConnection();
			return basicGetIncomingConnection();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return getIncomingEdges();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return getName();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return getNodeRole();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				return getOutgoingConnections();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				return getOutgoingEdges();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return getOwningRegion();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				return getUtility();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setClassDatum((ClassDatum)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setCluster((Cluster)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setIncomingConnection((NodeConnection)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				getIncomingEdges().clear();
			getIncomingEdges().addAll((Collection<? extends Edge>)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setName((String)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				setNodeRole((Role)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				getOutgoingConnections().clear();
			getOutgoingConnections().addAll((Collection<? extends NodeConnection>)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				getOutgoingEdges().clear();
			getOutgoingEdges().addAll((Collection<? extends Edge>)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				setOwningRegion((Region)newValue);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				setUtility((Utility)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setClassDatum((ClassDatum)null);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setCluster((Cluster)null);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setIncomingConnection((NodeConnection)null);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				getIncomingEdges().clear();
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setName(NAME_EDEFAULT);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				setNodeRole(NODE_ROLE_EDEFAULT);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				getOutgoingConnections().clear();
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				getOutgoingEdges().clear();
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				setOwningRegion((Region)null);
			return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				setUtility(UTILITY_EDEFAULT);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return classDatum != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return cluster != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return incomingConnection != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return nodeRole != NODE_ROLE_EDEFAULT;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				return outgoingConnections != null && !outgoingConnections.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return getOwningRegion() != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				return utility != UTILITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return eInternalContainer().eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, Region.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				if (cluster != null)
					msgs = ((InternalEObject)cluster).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, Cluster.class, msgs);
			return basicSetCluster((Cluster)otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return basicSetCluster(null, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return basicSetOwningRegion(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	private boolean isDataType;
	private boolean isHead = false;
	private boolean isContained = false;
	private boolean isThis = false;

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
		//	if ((utility != null) && !isUnconditional()) {
		//		s.setFillColor(getFillColor());
		//	}
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
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		NodeImpl node = (NodeImpl)QVTscheduleFactory.eINSTANCE.create(eClass());
		node.initialize(nodeRole, region, utility, name, classDatum);
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
	public @NonNull String getColor() {
		assert nodeRole != null;
		switch (utility) {
			case NON_NULL_CONDITIONAL:
			case NON_NULL_MATCHED:
			case NULLABLE_CONDITIONAL:
			case NULLABLE_MATCHED:
				return QVTscheduleUtil.getColor(nodeRole);
			default:
				return QVTscheduleUtil.ERROR_COLOR;
		}
	}

	@Override
	public @NonNull Iterable<@NonNull CompleteClass> getCompleteClasses() {
		return QVTscheduleUtil.getCompleteClasses(QVTscheduleUtil.getClassDatum(this));
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
			for (@NonNull CompleteClass completeClass : getCompleteClasses()) {
				n.append("\\n");
				n.append(PrettyPrinter.printType(completeClass.getPrimaryClass()));
			}
		}
		return n.toString();
	}

	@Override
	public @Nullable Node getNavigableTarget(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(this)) {
			if (edge instanceof NavigationEdge) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				if ((QVTscheduleUtil.getReferredProperty(navigationEdge) == source2targetProperty) && !navigationEdge.isPartial()) {
					return navigationEdge.getEdgeTarget();
				}
			}
			else {
				// SharedEdge
			}
		}
		return null;
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
	public @Nullable NavigableEdge getOutgoingNavigableEdge(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(this)) {
			if (edge instanceof NavigationEdge) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				if ((QVTscheduleUtil.getReferredProperty(navigationEdge) == source2targetProperty) && !navigationEdge.isPartial()) {
					return navigationEdge;
				}
			}
			else {
				// SharedEdge
			}
		}
		return null;
	}

	@Override
	public final @Nullable Edge getOutgoingPredicateEdge(@NonNull Property source2targetProperty) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(this)) {
			if (edge.isPredicated()) {
				if (edge instanceof NavigationEdge) {
					if (QVTscheduleUtil.getReferredProperty((NavigationEdge)edge) == source2targetProperty) {
						return edge;
					}
				}
				else {
					// SharedEdge
				}
			}
		}
		return null;
	}

	/*	@Override
	public @Nullable Object getReloadableEObjectOrURI() {
		return null;
	} */

	@Override
	public @Nullable String getShape() {
		return null;
	}

	@Override
	public final @Nullable String getStyle() {
		StringBuilder s = new StringBuilder();
		if (isDataType()) {
			s.append("rounded");
		}
		switch (utility) {
			case NULLABLE_CONDITIONAL:
			case NULLABLE_MATCHED: {
				if (s.length() > 0) {
					s.append(",");
				}
				s.append("dashed");
				break;
			}
			case NON_NULL_CONDITIONAL:
			case NON_NULL_MATCHED:
				break;
			default:
				break;
		}
		/*	if ((utility != null) && !isUnconditional()) {
			assert / *isComposed() ||* / !isMatched();
			if (s.length() > 0) {
				s.append(",");
			}
			s.append("filled");
		} */
		return "\"" + s.toString() + "\"";
	}

	@Override
	public void initialize(@NonNull Role nodeRole, @NonNull Region region, @NonNull Utility utility, /*@NonNull*/ String name, /*@NonNull*/ ClassDatum classDatum) {
		assert name != null;
		assert classDatum != null;
		setNodeRole(nodeRole);
		setOwningRegion(region);
		setName(name);
		setClassDatum(classDatum);
		setUtility(utility);
		this.isDataType = classDatum.isDataType();
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
	public final boolean isConditional() {
		return utility.isConditional();
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
		return utility == Utility.DISPATCH;
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
	public /* final */ boolean isRequired() {
		return !utility.isNullable();
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
	public boolean isThis() {
		return isThis;
	}

	@Override
	public boolean isTrace() {
		return utility == Utility.TRACE;
	}

	@Override
	public final boolean isUnconditional() {
		return utility.isUnconditional();
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

	private boolean isStrict = false;		// true if region has a DataType head mandating unique invocation enforcement

	@Override
	public boolean isStrict() {
		return isStrict;
	}

	@Override
	public void setStrict(boolean isStrict) {
		assert isRealized();
		this.isStrict = isStrict;
	}

	@Override
	public void setOriginatingVariable(@NonNull VariableDeclaration variable) {
		throw new UnsupportedOperationException();		// Should be MappingNode
	}

	@Override
	public void setThis() {
		this.isThis = true;
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
