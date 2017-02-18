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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getEdgeRole <em>Edge Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getOwningRegion <em>Owning Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EdgeImpl extends ElementImpl implements Edge {
	/**
	 * The default value of the '{@link #getEdgeRole() <em>Edge Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeRole()
	 * @generated
	 * @ordered
	 */
	protected static final Role EDGE_ROLE_EDEFAULT = Role.CONSTANT;

	/**
	 * The cached value of the '{@link #getEdgeRole() <em>Edge Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeRole()
	 * @generated
	 * @ordered
	 */
	protected Role edgeRole = EDGE_ROLE_EDEFAULT;

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
	public Role getEdgeRole() {
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE__EDGE_ROLE, oldEdgeRole, edgeRole));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getOwningRegion() {
		if (eContainerFeatureID() != QVTschedulePackage.EDGE__OWNING_REGION) return null;
		return (Region)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRegion(Region newOwningRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRegion, QVTschedulePackage.EDGE__OWNING_REGION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRegion(Region newOwningRegion) {
		if (newOwningRegion != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.EDGE__OWNING_REGION && newOwningRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRegion != null)
				msgs = ((InternalEObject)newOwningRegion).eInverseAdd(this, QVTschedulePackage.REGION__OWNED_EDGES, Region.class, msgs);
			msgs = basicSetOwningRegion(newOwningRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE__OWNING_REGION, newOwningRegion, newOwningRegion));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.EDGE__SOURCE_NODE, oldSourceNode, sourceNode));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE__SOURCE_NODE, oldSourceNode, newSourceNode);
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
				msgs = ((InternalEObject)sourceNode).eInverseRemove(this, QVTschedulePackage.NODE__OUTGOING_EDGES, Node.class, msgs);
			if (newSourceNode != null)
				msgs = ((InternalEObject)newSourceNode).eInverseAdd(this, QVTschedulePackage.NODE__OUTGOING_EDGES, Node.class, msgs);
			msgs = basicSetSourceNode(newSourceNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE__SOURCE_NODE, newSourceNode, newSourceNode));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.EDGE__TARGET_NODE, oldTargetNode, targetNode));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE__TARGET_NODE, oldTargetNode, newTargetNode);
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
				msgs = ((InternalEObject)targetNode).eInverseRemove(this, QVTschedulePackage.NODE__INCOMING_EDGES, Node.class, msgs);
			if (newTargetNode != null)
				msgs = ((InternalEObject)newTargetNode).eInverseAdd(this, QVTschedulePackage.NODE__INCOMING_EDGES, Node.class, msgs);
			msgs = basicSetTargetNode(newTargetNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.EDGE__TARGET_NODE, newTargetNode, newTargetNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.EDGE__OWNING_REGION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRegion((Region)otherEnd, msgs);
			case QVTschedulePackage.EDGE__SOURCE_NODE:
				if (sourceNode != null)
					msgs = ((InternalEObject)sourceNode).eInverseRemove(this, QVTschedulePackage.NODE__OUTGOING_EDGES, Node.class, msgs);
				return basicSetSourceNode((Node)otherEnd, msgs);
			case QVTschedulePackage.EDGE__TARGET_NODE:
				if (targetNode != null)
					msgs = ((InternalEObject)targetNode).eInverseRemove(this, QVTschedulePackage.NODE__INCOMING_EDGES, Node.class, msgs);
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
			case QVTschedulePackage.EDGE__OWNING_REGION:
				return basicSetOwningRegion(null, msgs);
			case QVTschedulePackage.EDGE__SOURCE_NODE:
				return basicSetSourceNode(null, msgs);
			case QVTschedulePackage.EDGE__TARGET_NODE:
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
			case QVTschedulePackage.EDGE__OWNING_REGION:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.REGION__OWNED_EDGES, Region.class, msgs);
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
			case QVTschedulePackage.EDGE__EDGE_ROLE:
				return getEdgeRole();
			case QVTschedulePackage.EDGE__NAME:
				return getName();
			case QVTschedulePackage.EDGE__OWNING_REGION:
				return getOwningRegion();
			case QVTschedulePackage.EDGE__SOURCE_NODE:
				if (resolve) return getSourceNode();
				return basicGetSourceNode();
			case QVTschedulePackage.EDGE__TARGET_NODE:
				if (resolve) return getTargetNode();
				return basicGetTargetNode();
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
			case QVTschedulePackage.EDGE__EDGE_ROLE:
				setEdgeRole((Role)newValue);
				return;
			case QVTschedulePackage.EDGE__NAME:
				setName((String)newValue);
				return;
			case QVTschedulePackage.EDGE__OWNING_REGION:
				setOwningRegion((Region)newValue);
				return;
			case QVTschedulePackage.EDGE__SOURCE_NODE:
				setSourceNode((Node)newValue);
				return;
			case QVTschedulePackage.EDGE__TARGET_NODE:
				setTargetNode((Node)newValue);
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
			case QVTschedulePackage.EDGE__EDGE_ROLE:
				setEdgeRole(EDGE_ROLE_EDEFAULT);
				return;
			case QVTschedulePackage.EDGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case QVTschedulePackage.EDGE__OWNING_REGION:
				setOwningRegion((Region)null);
				return;
			case QVTschedulePackage.EDGE__SOURCE_NODE:
				setSourceNode((Node)null);
				return;
			case QVTschedulePackage.EDGE__TARGET_NODE:
				setTargetNode((Node)null);
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
			case QVTschedulePackage.EDGE__EDGE_ROLE:
				return edgeRole != EDGE_ROLE_EDEFAULT;
			case QVTschedulePackage.EDGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case QVTschedulePackage.EDGE__OWNING_REGION:
				return getOwningRegion() != null;
			case QVTschedulePackage.EDGE__SOURCE_NODE:
				return sourceNode != null;
			case QVTschedulePackage.EDGE__TARGET_NODE:
				return targetNode != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getColor());
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
			s.setArrowtail(arrowtail);
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(source, this, target);
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
		assert sourceNode2 != targetNode2;
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
	public @NonNull Edge createEdge(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode) {
		EdgeImpl edge = (EdgeImpl)QVTscheduleFactory.eINSTANCE.create(eClass());
		edge.initialize(edgeRole, sourceNode, name, targetNode);
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
		return isNavigation() ? "vee" : null;
	}

	@Override
	public @NonNull String getColor() {
		assert edgeRole != null;
		return QVTscheduleUtil.getColor(edgeRole);
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
		return isNavigation() ? 2*QVTscheduleConstants.LINE_WIDTH : QVTscheduleConstants.LINE_WIDTH;
	}

	public @Nullable String getStyle() {
		return isMatched() ? null : "dashed";
	}

	@Override
	public void initialize(@NonNull Role edgeRole, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		setOwningRegion(QVTscheduleUtil.getOwningRegion(sourceNode));
		setEdgeRole(edgeRole);
		setName(name);
		setSource(sourceNode);
		setTarget(targetNode);
	}

	@Override
	public boolean isCast() {
		return false;
	}

	@Override
	public boolean isComputation() {
		return false;
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
	public final boolean isMatched() {
		return QVTscheduleUtil.getSourceNode(this).isMatched() && QVTscheduleUtil.getTargetNode(this).isMatched();
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
	public boolean isUnconditional() {
		return QVTscheduleUtil.getSourceNode(this).isUnconditional() && QVTscheduleUtil.getTargetNode(this).isUnconditional();
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
		s.append(getClass().getSimpleName().replace("Impl",  ""));
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
