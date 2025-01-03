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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.Cluster;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getCluster <em>Cluster</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getEdgeRole <em>Edge Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getOwningRegion <em>Owning Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getUtility <em>Utility</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EdgeImpl extends ElementImpl implements Edge {
	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EDGE_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EDGE_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;

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
	 * The default value of the '{@link #getEdgeRole() <em>Edge Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeRole()
	 * @generated NOT
	 * @ordered
	 */
	protected static final @NonNull Role EDGE_ROLE_EDEFAULT = Role.CONSTANT;

	/**
	 * The cached value of the '{@link #getEdgeRole() <em>Edge Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeRole()
	 * @generated NOT
	 * @ordered
	 */
	protected @NonNull Role edgeRole = EDGE_ROLE_EDEFAULT;

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
	 * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceNode()
	 * @generated
	 * @ordered
	 */
	protected Node sourceNode;

	/**
	 * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNode()
	 * @generated
	 * @ordered
	 */
	protected Node targetNode;

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
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.EDGE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldCluster, cluster));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldCluster, newCluster);
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
				msgs = ((InternalEObject)cluster).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, Cluster.class, msgs);
			if (newCluster != null)
				msgs = ((InternalEObject)newCluster).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, Cluster.class, msgs);
			msgs = basicSetCluster(newCluster, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, newCluster, newCluster));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull Role getEdgeRole() {
		return edgeRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEdgeRole(Role newEdgeRole) {
		Role oldEdgeRole = edgeRole;
		edgeRole = newEdgeRole == null ? EDGE_ROLE_EDEFAULT : newEdgeRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldEdgeRole, edgeRole));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 2, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getOwningRegion() {
		if (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 3)) return null;
		return (Region)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRegion(Region newOwningRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRegion, ElementImpl.ELEMENT_FEATURE_COUNT + 3, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRegion(Region newOwningRegion) {
		if (newOwningRegion != eInternalContainer() || (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 3) && newOwningRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRegion != null)
				msgs = ((InternalEObject)newOwningRegion).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, Region.class, msgs);
			msgs = basicSetOwningRegion(newOwningRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 3, newOwningRegion, newOwningRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getSourceNode() {
		if (sourceNode != null && sourceNode.eIsProxy()) {
			InternalEObject oldSourceNode = (InternalEObject)sourceNode;
			sourceNode = (Node)eResolveProxy(oldSourceNode);
			if (sourceNode != oldSourceNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 4, oldSourceNode, sourceNode));
			}
		}
		return sourceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSourceNode() {
		return sourceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceNode(Node newSourceNode, NotificationChain msgs) {
		Node oldSourceNode = sourceNode;
		sourceNode = newSourceNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 4, oldSourceNode, newSourceNode);
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
	public void setSourceNode(Node newSourceNode) {
		if (newSourceNode != sourceNode) {
			NotificationChain msgs = null;
			if (sourceNode != null)
				msgs = ((InternalEObject)sourceNode).eInverseRemove(this, ElementImpl.ELEMENT_FEATURE_COUNT + 7, Node.class, msgs);
			if (newSourceNode != null)
				msgs = ((InternalEObject)newSourceNode).eInverseAdd(this, ElementImpl.ELEMENT_FEATURE_COUNT + 7, Node.class, msgs);
			msgs = basicSetSourceNode(newSourceNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 4, newSourceNode, newSourceNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getTargetNode() {
		if (targetNode != null && targetNode.eIsProxy()) {
			InternalEObject oldTargetNode = (InternalEObject)targetNode;
			targetNode = (Node)eResolveProxy(oldTargetNode);
			if (targetNode != oldTargetNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 5, oldTargetNode, targetNode));
			}
		}
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTargetNode() {
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetNode(Node newTargetNode, NotificationChain msgs) {
		Node oldTargetNode = targetNode;
		targetNode = newTargetNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 5, oldTargetNode, newTargetNode);
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
	public void setTargetNode(Node newTargetNode) {
		if (newTargetNode != targetNode) {
			NotificationChain msgs = null;
			if (targetNode != null)
				msgs = ((InternalEObject)targetNode).eInverseRemove(this, ElementImpl.ELEMENT_FEATURE_COUNT + 3, Node.class, msgs);
			if (newTargetNode != null)
				msgs = ((InternalEObject)newTargetNode).eInverseAdd(this, ElementImpl.ELEMENT_FEATURE_COUNT + 3, Node.class, msgs);
			msgs = basicSetTargetNode(newTargetNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 5, newTargetNode, newTargetNode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 6, oldUtility, utility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				if (cluster != null)
					msgs = ((InternalEObject)cluster).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, Cluster.class, msgs);
				return basicSetCluster((Cluster)otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRegion((Region)otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				if (sourceNode != null)
					msgs = ((InternalEObject)sourceNode).eInverseRemove(this, ElementImpl.ELEMENT_FEATURE_COUNT + 7, Node.class, msgs);
				return basicSetSourceNode((Node)otherEnd, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				if (targetNode != null)
					msgs = ((InternalEObject)targetNode).eInverseRemove(this, ElementImpl.ELEMENT_FEATURE_COUNT + 3, Node.class, msgs);
				return basicSetTargetNode((Node)otherEnd, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return basicSetCluster(null, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return basicSetOwningRegion(null, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return basicSetSourceNode(null, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return basicSetTargetNode(null, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return eInternalContainer().eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, Region.class, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				if (resolve) return getCluster();
				return basicGetCluster();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return getEdgeRole();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return getName();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return getOwningRegion();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				if (resolve) return getSourceNode();
				return basicGetSourceNode();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				if (resolve) return getTargetNode();
				return basicGetTargetNode();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				return getUtility();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setCluster((Cluster)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setEdgeRole((Role)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setName((String)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setOwningRegion((Region)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setSourceNode((Node)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				setTargetNode((Node)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
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
				setCluster((Cluster)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setEdgeRole(EDGE_ROLE_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setName(NAME_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setOwningRegion((Region)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setSourceNode((Node)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				setTargetNode((Node)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
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
				return cluster != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return edgeRole != EDGE_ROLE_EDEFAULT;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return getOwningRegion() != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return sourceNode != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return targetNode != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				return utility != UTILITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		toGraphHelper.setColor(this);
		String label = getLabel();
		if (label != null) {
			s.setLabel(label);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		String arrowhead = getArrowhead();
		if (arrowhead != null) {
			s.setArrowhead(arrowhead);
		}
		String arrowtail = getArrowtail();
		if (arrowtail != null) {
			s.setDir("both");
			s.setArrowtail(arrowtail);
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(sourceName, this, targetName);
	}

	/*	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		String name = getName();
/ *		String indexText = getIndexText();
		if (indexText != null) {
			name = name + "\\n " + indexText;
		} * /
		s.setLabel(name);
		s.setShape("ellipse");
//		String style = getStyle();
//		if (style != null) {
//			s.setStyle(style);
//		}
		s.setColor(getColor());
		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
	} */

	private void connect() {
		Node sourceNode2 = this.sourceNode;
		Node targetNode2 = this.targetNode;
		assert sourceNode2 != null;
		assert targetNode2 != null;
		//		assert sourceNode2 != targetNode2;		-- cyclic edges may be unusual, but they're not wrong
		Region region = QVTscheduleUtil.getOwningRegion(sourceNode2);
		assert region == targetNode2.getOwningRegion();
		//		region.addEdge(this);
		//		sourceNode2.addOutgoingEdge(this);
		//		targetNode2.addIncomingEdge(this);
		assert sourceNode2.getOutgoingEdges().contains(this);
		assert targetNode2.getIncomingEdges().contains(this);
		assert !sourceNode2.isDependency() || targetNode2.isDependency() || targetNode2.isOperation();	// sourceNode2.isDependency() implies (targetNode2.isDependency() or targetNode2.isOperation())
		assert !targetNode2.isDependency() || sourceNode2.isDependency();								// targetNode2.isDependency() implies sourceNode2.isDependency()
	}

	@Override
	public @NonNull Edge createEdge(@NonNull Role edgeRole, @NonNull Utility utility, @NonNull Node sourceNode, @NonNull Node targetNode) {
		EdgeImpl edge = (EdgeImpl)QVTscheduleFactory.eINSTANCE.create(eClass());
		edge.initialize(edgeRole, utility, sourceNode, name, targetNode);
		return edge;
	}

	@Override
	public void destroy() {
		Node sourceNode2 = this.sourceNode;
		Node targetNode2 = this.targetNode;
		if ((sourceNode2 != null) && (targetNode2 != null)) {
			setTarget(null);
			setSource(null);
			setOwningRegion(null);
		}
	}

	private void disconnect() {
		if (this.sourceNode != null) {
			//			this.sourceNode.removeOutgoingEdge(this);
		}
		if (this.targetNode != null) {
			//			this.targetNode.removeIncomingEdge(this);
		}
		//		this.sourceNode = null;
		//		this.targetNode = null;
		setOwningRegion(null);
		setSourceNode(null);
		setTargetNode(null);
	}

	@Override
	public String getArrowhead() {
		return null;
	}

	@Override
	public String getArrowtail() {
		return (isCast() || isNavigation()) ? "vee" : null;
	}

	@Override
	public @NonNull String getColor() {
		assert edgeRole != null;
		switch (utility) {
			case NON_NULL_CONDITIONAL:
			case NON_NULL_MATCHED:
			case NULLABLE_CONDITIONAL:
			case NULLABLE_MATCHED:
				return QVTscheduleUtil.getColor(edgeRole);
			default:
				return QVTscheduleUtil.ERROR_COLOR;
		}
	}

	@Override
	public @NonNull Node getEdgeSource() {
		return QVTscheduleUtil.getSourceNode(this);
	}

	@Override
	public @NonNull Node getEdgeTarget() {
		return QVTscheduleUtil.getTargetNode(this);
	}

	@Override
	public @NonNull Edge getForwardEdge() {
		return this;
	}

	@Override
	public @Nullable String getLabel() {
		return name;
	}

	public @NonNull Integer getPenwidth() {
		switch (utility) {
			case NULLABLE_MATCHED:
			case NON_NULL_MATCHED:
				return 2*QVTscheduleConstants.LINE_WIDTH;
			case NON_NULL_CONDITIONAL:
			case NULLABLE_CONDITIONAL:
				return 1*QVTscheduleConstants.LINE_WIDTH;
			default:
				return 4*QVTscheduleConstants.LINE_WIDTH;
		}
		//		return (isCast() || isNavigation()) ? 2*QVTscheduleConstants.LINE_WIDTH : QVTscheduleConstants.LINE_WIDTH;
	}

	public @Nullable String getStyle() {
		switch (utility) {
			case NON_NULL_CONDITIONAL:
			case NON_NULL_MATCHED:
				return null;
			case NULLABLE_CONDITIONAL:
			case NULLABLE_MATCHED:
				return "dashed";
			default:
				return "dotted";
		}
	}

	@Override
	public void initialize(@NonNull Role edgeRole, @NonNull Utility utility, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		setOwningRegion(QVTscheduleUtil.getOwningRegion(sourceNode));
		setEdgeRole(edgeRole);
		setName(name);
		setSource(sourceNode);
		setTarget(targetNode);
		setUtility(utility);
	}

	@Override
	public boolean isCast() {
		return false;
	}

	@Override
	public boolean isChecked() {
		assert edgeRole != null;
		return edgeRole.isChecked();
	}

	@Override
	public boolean isComputation() {
		return false;
	}

	@Override
	public boolean isConditional() {
		return utility.isConditional();
	}

	@Override
	public boolean isConstant() {
		assert edgeRole != null;
		return edgeRole == Role.CONSTANT;
	}

	@Override
	public final boolean isDependency() {
		return QVTscheduleUtil.getSourceNode(this).isDependency();
	}

	@Override
	public boolean isExpression() {
		return false;
	}

	@Override
	public boolean isLoaded() {
		assert edgeRole != null;
		return edgeRole == Role.LOADED;
	}

	@Override
	public boolean isNavigable() {
		return false;
	}

	@Override
	public boolean isNavigation() {
		return false;
	}

	@Override
	public boolean isNew() {
		assert edgeRole != null;
		return edgeRole.isNew();
	}

	@Override
	public boolean isNullable() {
		return utility.isNullable();
	}

	@Override
	public boolean isOld() {
		assert edgeRole != null;
		return edgeRole.isOld();
	}

	@Override
	public boolean isPartial() {
		return false;
	}

	@Override
	public boolean isPredicate() {
		return false;
	}

	@Override
	public boolean isPredicated() {
		assert edgeRole != null;
		return edgeRole == Role.PREDICATED;
	}

	@Override
	public boolean isRealized() {
		assert edgeRole != null;
		return edgeRole == Role.REALIZED;
	}

	@Override
	public boolean isRecursion() {
		return false;
	}

	@Override
	public boolean isSecondary() {
		return false;
	}

	@Override
	public boolean isSpeculated() {
		assert edgeRole != null;
		return edgeRole == Role.SPECULATED;
	}

	@Override
	public boolean isSuccess() {
		return false;
	}

	@Override
	public final boolean isUnconditional() {
		return utility.isUnconditional();
	}

	protected void mergeRole(@NonNull Role edgeRole) {
		if (this.edgeRole != edgeRole) {
			assert this.edgeRole != null;
			this.edgeRole = QVTscheduleUtil.mergeToMoreKnownPhase(this.edgeRole, edgeRole);
		}
	}

	@Override
	public void setSource(@Nullable Node sourceNode) {
		if (this.sourceNode != sourceNode) {
			if (sourceNode == null) {
				disconnect();
			}
			else {
				if (this.sourceNode != null) {
					//					this.sourceNode.removeOutgoingEdge(this);
					disconnect();
				}
				setSourceNode(sourceNode);
				if (this.targetNode != null) {
					connect();
				}
			}
		}
	}

	@Override
	public void setTarget(@Nullable Node targetNode) {
		if (this.targetNode != targetNode) {
			if (targetNode == null) {
				disconnect();
			}
			else {
				if (this.targetNode != null) {
					//					this.targetNode.removeIncomingEdge(this);
					disconnect();
				}
				setTargetNode(targetNode);
				if (this.sourceNode != null) {
					connect();
				}
			}
		}
	}

	@Override
	public @NonNull String toString() {
		Role edgeRole = getEdgeRole();
		StringBuilder s = new StringBuilder();
		s.append(edgeRole);
		s.append("-");
		s.append(eClass().getName());
		s.append("(");
		s.append(String.valueOf(sourceNode));
		s.append("=>");
		s.append(String.valueOf(name));
		s.append("=>");
		s.append(String.valueOf(targetNode));
		s.append(")");
		return s.toString();
	}

} //EdgeImpl
