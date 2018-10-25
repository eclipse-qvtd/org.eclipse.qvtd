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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.Cluster;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Symbolable;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToGraphVisitor;

import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getSymbolName <em>Symbol Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getOwnedNodes <em>Owned Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getOwnedEdges <em>Owned Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getOwnedClusters <em>Owned Clusters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getScheduledRegion <em>Scheduled Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RegionImpl extends NamedElementImpl implements Region {
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
	 * The cached value of the '{@link #getOwnedNodes() <em>Owned Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> ownedNodes;
	/**
	 * The cached value of the '{@link #getOwnedEdges() <em>Owned Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> ownedEdges;
	/**
	 * The cached value of the '{@link #getOwnedClusters() <em>Owned Clusters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedClusters()
	 * @generated
	 * @ordered
	 */
	protected EList<Cluster> ownedClusters;
	/**
	 * The cached value of the '{@link #getScheduledRegion() <em>Scheduled Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduledRegion()
	 * @generated
	 * @ordered
	 */
	protected ScheduledRegion scheduledRegion;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.REGION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.REGION__SYMBOL_NAME, oldSymbolName, symbolName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Edge> getOwnedEdges() {
		if (ownedEdges == null) {
			ownedEdges = new EObjectContainmentWithInverseEList<Edge>(Edge.class, this, QVTschedulePackage.REGION__OWNED_EDGES, QVTschedulePackage.EDGE__OWNING_REGION);
		}
		return ownedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Cluster> getOwnedClusters() {
		if (ownedClusters == null) {
			ownedClusters = new EObjectContainmentWithInverseEList<Cluster>(Cluster.class, this, QVTschedulePackage.REGION__OWNED_CLUSTERS, QVTschedulePackage.CLUSTER__OWNING_REGION);
		}
		return ownedClusters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduledRegion getScheduledRegion() {
		if (scheduledRegion != null && scheduledRegion.eIsProxy()) {
			InternalEObject oldScheduledRegion = (InternalEObject)scheduledRegion;
			scheduledRegion = (ScheduledRegion)eResolveProxy(oldScheduledRegion);
			if (scheduledRegion != oldScheduledRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.REGION__SCHEDULED_REGION, oldScheduledRegion, scheduledRegion));
			}
		}
		return scheduledRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduledRegion basicGetScheduledRegion() {
		return scheduledRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScheduledRegion(ScheduledRegion newScheduledRegion, NotificationChain msgs) {
		ScheduledRegion oldScheduledRegion = scheduledRegion;
		scheduledRegion = newScheduledRegion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.REGION__SCHEDULED_REGION, oldScheduledRegion, newScheduledRegion);
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
	public void setScheduledRegion(ScheduledRegion newScheduledRegion) {
		if (newScheduledRegion != scheduledRegion) {
			NotificationChain msgs = null;
			if (scheduledRegion != null)
				msgs = ((InternalEObject)scheduledRegion).eInverseRemove(this, QVTschedulePackage.SCHEDULED_REGION__ACTIVE_REGIONS, ScheduledRegion.class, msgs);
			if (newScheduledRegion != null)
				msgs = ((InternalEObject)newScheduledRegion).eInverseAdd(this, QVTschedulePackage.SCHEDULED_REGION__ACTIVE_REGIONS, ScheduledRegion.class, msgs);
			msgs = basicSetScheduledRegion(newScheduledRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.REGION__SCHEDULED_REGION, newScheduledRegion, newScheduledRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Node> getOwnedNodes() {
		if (ownedNodes == null) {
			ownedNodes = new EObjectContainmentWithInverseEList<Node>(Node.class, this, QVTschedulePackage.REGION__OWNED_NODES, QVTschedulePackage.NODE__OWNING_REGION);
		}
		return ownedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.REGION__SYMBOL_NAME:
				return getSymbolName();
			case QVTschedulePackage.REGION__OWNED_NODES:
				return getOwnedNodes();
			case QVTschedulePackage.REGION__OWNED_EDGES:
				return getOwnedEdges();
			case QVTschedulePackage.REGION__OWNED_CLUSTERS:
				return getOwnedClusters();
			case QVTschedulePackage.REGION__SCHEDULED_REGION:
				if (resolve) return getScheduledRegion();
				return basicGetScheduledRegion();
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
			case QVTschedulePackage.REGION__SYMBOL_NAME:
				setSymbolName((String)newValue);
				return;
			case QVTschedulePackage.REGION__OWNED_NODES:
				getOwnedNodes().clear();
				getOwnedNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.REGION__OWNED_EDGES:
				getOwnedEdges().clear();
				getOwnedEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case QVTschedulePackage.REGION__OWNED_CLUSTERS:
				getOwnedClusters().clear();
				getOwnedClusters().addAll((Collection<? extends Cluster>)newValue);
				return;
			case QVTschedulePackage.REGION__SCHEDULED_REGION:
				setScheduledRegion((ScheduledRegion)newValue);
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
			case QVTschedulePackage.REGION__SYMBOL_NAME:
				setSymbolName(SYMBOL_NAME_EDEFAULT);
				return;
			case QVTschedulePackage.REGION__OWNED_NODES:
				getOwnedNodes().clear();
				return;
			case QVTschedulePackage.REGION__OWNED_EDGES:
				getOwnedEdges().clear();
				return;
			case QVTschedulePackage.REGION__OWNED_CLUSTERS:
				getOwnedClusters().clear();
				return;
			case QVTschedulePackage.REGION__SCHEDULED_REGION:
				setScheduledRegion((ScheduledRegion)null);
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
			case QVTschedulePackage.REGION__SYMBOL_NAME:
				return SYMBOL_NAME_EDEFAULT == null ? symbolName != null : !SYMBOL_NAME_EDEFAULT.equals(symbolName);
			case QVTschedulePackage.REGION__OWNED_NODES:
				return ownedNodes != null && !ownedNodes.isEmpty();
			case QVTschedulePackage.REGION__OWNED_EDGES:
				return ownedEdges != null && !ownedEdges.isEmpty();
			case QVTschedulePackage.REGION__OWNED_CLUSTERS:
				return ownedClusters != null && !ownedClusters.isEmpty();
			case QVTschedulePackage.REGION__SCHEDULED_REGION:
				return scheduledRegion != null;
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
				case QVTschedulePackage.REGION__SYMBOL_NAME: return QVTschedulePackage.SYMBOLABLE__SYMBOL_NAME;
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
				case QVTschedulePackage.SYMBOLABLE__SYMBOL_NAME: return QVTschedulePackage.REGION__SYMBOL_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};

	@Override
	public void addVariableNode(@NonNull VariableDeclaration variable, @NonNull Node node) {}

	@Override
	public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		String name = /*getSymbolName() + "\\n " +*/ getName();
		//		String indexText = StaticConnectionManager.INSTANCE.wipGetPassesText(this);
		//		if (indexText != null) {
		//			name = name + "\\n " + indexText;
		//		}
		s.setLabel(name);
		String shape = getShape();
		if (shape != null) {
			s.setShape(shape);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		s.setColor(getColor());
		//		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
		//		if (isHead) {
		//			s.append("}");
		//		}
	}

	/**
	 * Return true if a navigable path from startNode following the edges of protoPath,
	 * re-using edges and nodes where possible could be created. REturn false if such
	 * a path would violate a null parent requirement.
	 */
	protected boolean canCreatePath(@NonNull Node startNode, @NonNull List<@NonNull NavigableEdge> protoPath) {
		//		Map<Edge, Edge> path = new HashMap<>();
		//		Region region = startNode.getRegion();
		Node sourceNode = startNode;
		for (@NonNull NavigableEdge protoEdge : protoPath) {
			NavigableEdge edge = sourceNode.getNavigableEdge(QVTscheduleUtil.getProperty(protoEdge));
			if (edge != null) {
				Node protoTarget = protoEdge.getEdgeTarget();
				Node target = edge.getEdgeTarget();
				if (target.isNullLiteral() != (protoTarget.isNullLiteral())) {
					return false;
				}
				sourceNode = target;
			}
		}
		return true;
	}

	/*	protected void computeSymbolName(@NonNull SymbolNameBuilder sIn) {
		SymbolNameBuilder s = null;
		//		List<String> names = new ArrayList<>();
		//		for (@NonNull MappingAction action : getMappingActions()) {
		//			names.add(action.getMapping().getName());
		//		}
		//		Collections.sort(names);
		Set<@NonNull Node> bestToOneSubRegion = null;
		Node bestNamingNode = null;
		int bestToOneSubRegionSize = 0;
		for (@NonNull Node node : QVTscheduleUtil.getHeadNodes(this)) {
			if (node.isOld() && !node.isConstant()) {
				bestNamingNode = node;
				break;
			}
		}
		if (bestNamingNode == null) {
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(this)) {
				if (node.isNew() || node.isPredicated() || node.isSpeculated()) {
					Set<@NonNull Node> toOneSubRegion = computeToOneSubRegion(new HashSet<>(), node);
					int toOneSubRegionSize = toOneSubRegion.size();
					Boolean isBetter = null;
					if ((bestToOneSubRegion == null) || (bestNamingNode == null)) {
						isBetter = true;
					}
					else if (toOneSubRegionSize > bestToOneSubRegionSize) {
						isBetter = true;
					}
					else if (toOneSubRegionSize < bestToOneSubRegionSize) {
						isBetter = false;
					}
					else if (node.isNew() && !bestNamingNode.isNew()) {
						isBetter = true;
					}
					else {
						int bestRealizedNavigationEdgesSize = Iterables.size(bestNamingNode.getRealizedNavigationEdges());
						int realizedNavigationEdgesSize = Iterables.size(node.getRealizedNavigationEdges());
						if (realizedNavigationEdgesSize > bestRealizedNavigationEdgesSize) {
							isBetter = true;
						}
						else if (realizedNavigationEdgesSize < bestRealizedNavigationEdgesSize) {
							isBetter = false;
						}
						else {
							int diff = ClassUtil.safeCompareTo(bestNamingNode.getCompleteClass().getName(), node.getCompleteClass().getName());
							if (diff > 0) {
								isBetter = true;
							}
							else if (diff < 0) {
								isBetter = false;
							}
						}
					}
					if (isBetter == Boolean.TRUE) {
						bestToOneSubRegion = toOneSubRegion;
						bestToOneSubRegionSize = toOneSubRegionSize;
						bestNamingNode = node;
					}
				}
			}
		}
		if (bestNamingNode != null) {
			List<@NonNull String> edgeNames = new ArrayList<>();
			for (@NonNull NavigableEdge edge : bestNamingNode.getRealizedNavigationEdges()) {
				String name = PivotUtil.getName(QVTscheduleUtil.getProperty(edge));
				edgeNames.add(name);
			}
			if (edgeNames.size() > 0) {
				s = sIn;
				s.appendName(bestNamingNode.getCompleteClass().getName());
				Collections.sort(edgeNames);
				for (@NonNull String edgeName : edgeNames) {
					s.appendString("_");
					s.appendString(edgeName);
				}
			}
			else {
				for (@NonNull NavigableEdge edge : getRealizedNavigationEdges()) {
					String name = PivotUtil.getName(QVTscheduleUtil.getProperty(edge));
					edgeNames.add(name);
				}
				if (edgeNames.size() > 0) {
					s = sIn;
					s.appendName(bestNamingNode.getCompleteClass().getName());
					s.appendString("_");
					Collections.sort(edgeNames);
					for (@NonNull String edgeName : edgeNames) {
						s.appendString("_");
						s.appendString(edgeName);
					}
				}
			}
		}
		if ((s == null) && (bestNamingNode != null)) {
			s = sIn;
			//			s.appendString(getSymbolNamePrefix());
			s.appendName(bestNamingNode.getCompleteClass().getName());
			List<@NonNull String> headNames = new ArrayList<>();
			for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(this)) {
				String name = headNode.getCompleteClass().getName();
				if (name != null) {
					headNames.add(name);
				}
			}
			for (@NonNull String headName : headNames) {
				s.appendString("_");
				s.appendString(headName);
			}
		}
		if (s == null) {
			for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(this)) {
				s = sIn;
				//				s.appendString(getSymbolNamePrefix());
				s.appendName(headNode.getCompleteClass().getName());
				List<@NonNull String> edgeNames = new ArrayList<>();
				for (@NonNull NavigableEdge edge : headNode.getNavigableEdges()) {
					String propertyName = PivotUtil.getName(QVTscheduleUtil.getProperty(edge));
					edgeNames.add(edge.getEdgeTarget().isNullLiteral() ? propertyName + "0" : propertyName);
				}
				Collections.sort(edgeNames);
				for (@NonNull String edgeName : edgeNames) {
					s.appendString("_");
					s.appendName(edgeName);
				}
				break;
			}
		}
	} */

	/*	private @NonNull Set<@NonNull Node> computeToOneSubRegion(@NonNull Set<@NonNull Node> toOneSubRegion, @NonNull Node atNode) {
		if (toOneSubRegion.add(atNode)) {
			for (@NonNull NavigableEdge edge : atNode.getNavigableEdges()) {
				assert edge.getEdgeSource() == atNode;
				Property source2target = edge.getProperty();
				if (!source2target.isIsMany() && !source2target.isIsImplicit()) {
					computeToOneSubRegion(toOneSubRegion, edge.getEdgeTarget());
				}
			}
		}
		return toOneSubRegion;
	} */

	/*	@Override
	public @NonNull Iterable<@NonNull Node> getAncestorsOf(@NonNull Node node) {
		List<@NonNull Node> ancestors = new ArrayList<>();
		HashSet<@NonNull Node> ancestorSet = new HashSet<>();
		node.getAllAncestors(ancestorSet);
		for (@NonNull Node ancestor : ancestorSet) {
			if (ancestor.getOwningRegion() == this) {
				ancestors.add(ancestor);
			}
		}
		return ancestors;
	} */

	private @NonNull NavigableEdge getBestEdge(@Nullable NavigableEdge bestEdge, @NonNull NavigableEdge candidateEdge) {
		if (bestEdge == null) {
			return candidateEdge;
		}
		if ((bestEdge.getProperty().isIsImplicit() && !candidateEdge.getProperty().isIsImplicit())) {
			return candidateEdge;
		}
		return bestEdge;		// ??? containment
	}

	protected @Nullable List<@NonNull NavigableEdge> getBestPath(@Nullable List<@NonNull NavigableEdge> bestPath, @Nullable List<@NonNull NavigableEdge> candidatePath) {
		if (bestPath == null) {
			return candidatePath;
		}
		if (candidatePath == null) {
			return bestPath;
		}
		int bestCost = getCost(bestPath);
		int candidateCost = getCost(candidatePath);
		if (candidateCost < bestCost) {
			return candidatePath;
		}
		return bestPath;
	}

	@Override
	public @NonNull String getColor() {
		return "blue";
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getComposedNodes() {
		return Iterables.filter(QVTscheduleUtil.getOwnedNodes(this), QVTscheduleUtil.IsComposedNodePredicate.INSTANCE);
	}

	private int getCost(@NonNull List<@NonNull NavigableEdge> path) {
		int cost = 0;
		for (@NonNull NavigableEdge edge : path) {
			if (edge.getProperty().isIsImplicit()) {
				cost++;
			}		// ??? containment
		}
		return cost;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getExpressionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOwnedEdges(this), QVTscheduleUtil.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getMatchedNodes() {
		return Iterables.filter(QVTscheduleUtil.getOwnedNodes(this), QVTscheduleUtil.IsMatchedNodePredicate.INSTANCE);
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getNavigationEdges() {
		@NonNull Iterable<@NonNull NavigableEdge> filter = Iterables.filter(QVTscheduleUtil.getOwnedEdges(this), NavigableEdge.class);
		return filter;
	}

	//	@Override
	//	public @Nullable Node getNavigationTarget(@NonNull ClassNode sourceNode, @NonNull Property source2targetProperty) {
	//		NavigationEdge navigationEdge = getNavigationEdge(sourceNode, source2targetProperty);
	//		return navigationEdge !=  null ? navigationEdge.getTarget() : null;
	//	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getNewNodes() {
		return Iterables.filter(QVTscheduleUtil.getOwnedNodes(this), QVTscheduleUtil.IsNewNodePredicate.INSTANCE);
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
			case QVTschedulePackage.REGION__OWNED_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedNodes()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.REGION__OWNED_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedEdges()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.REGION__OWNED_CLUSTERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedClusters()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.REGION__SCHEDULED_REGION:
				if (scheduledRegion != null)
					msgs = ((InternalEObject)scheduledRegion).eInverseRemove(this, QVTschedulePackage.SCHEDULED_REGION__ACTIVE_REGIONS, ScheduledRegion.class, msgs);
				return basicSetScheduledRegion((ScheduledRegion)otherEnd, msgs);
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
			case QVTschedulePackage.REGION__OWNED_NODES:
				return ((InternalEList<?>)getOwnedNodes()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.REGION__OWNED_EDGES:
				return ((InternalEList<?>)getOwnedEdges()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.REGION__OWNED_CLUSTERS:
				return ((InternalEList<?>)getOwnedClusters()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.REGION__SCHEDULED_REGION:
				return basicSetScheduledRegion(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public ScheduledRegion getContainingScheduledRegion() {
		return null;
	}

	@Override
	public @NonNull String getGraphName() {
		return ClassUtil.nonNullState(name);
	}

	private int nextPartitionNumber = 0;			// FIXME legacy compatibility naming support

	@Override
	public int getNextPartitionNumber() {
		return ++nextPartitionNumber;
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getOldNodes() {
		return Iterables.filter(QVTscheduleUtil.getOwnedNodes(this), QVTscheduleUtil.IsOldNodePredicate.INSTANCE);
	}

	protected @Nullable List<@NonNull NavigableEdge> getPath(@NonNull Node sourceNode, @NonNull Node targetNode, @NonNull Set<@NonNull Edge> usedEdges) {
		assert sourceNode.getOwningRegion() == targetNode.getOwningRegion();
		NavigableEdge bestEdge = null;
		List<@NonNull NavigableEdge> bestPath = null;
		for (@NonNull NavigableEdge edge : sourceNode.getNavigableEdges()) {
			if (!usedEdges.contains(edge) && !edge.getProperty().isIsMany() && !edge.isRealized()) {
				if (edge.getEdgeTarget() == targetNode) {
					bestEdge = getBestEdge(bestEdge, edge);
				}
				else {
					Set<@NonNull Edge> moreUsedEdges = new HashSet<>(usedEdges);
					moreUsedEdges.add(edge);
					List<@NonNull NavigableEdge> tailPath = getPath(edge.getEdgeTarget(), targetNode, moreUsedEdges);
					if (tailPath != null) {
						tailPath = new ArrayList<>(tailPath);
						tailPath.add(0, edge);
					}
					bestPath = getBestPath(bestPath, tailPath);
				}
			}
		}
		if (bestEdge == null) {
			return bestPath;
		}
		else if (bestPath == null) {
			return Collections.singletonList(bestEdge);
		}
		else {
			return getBestPath(Collections.singletonList(bestEdge), bestPath);
		}
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getPatternNodes() {
		return Iterables.filter(QVTscheduleUtil.getOwnedNodes(this), QVTscheduleUtil.IsPatternNodePredicate.INSTANCE);
	}

	public final @NonNull Iterable<NavigableEdge> getPredicateEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getOwnedEdges(this), QVTscheduleUtil.IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigationEdge> getPredicatedNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigationEdge> filter = (Iterable<@NonNull NavigationEdge>)(Object)Iterables.filter(QVTscheduleUtil.getOwnedEdges(this), QVTscheduleUtil.IsPredicatedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRealizedEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOwnedEdges(this), QVTscheduleUtil.IsRealizedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getRealizedNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getOwnedEdges(this), QVTscheduleUtil.IsRealizedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRecursionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getOwnedEdges(this), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @Nullable String getShape() {
		return null;
	}

	@Override
	public @Nullable String getStyle() {
		return null;
	}

	@Override
	public @Nullable String getSymbolName() {
		return null;
		/*		String symbolName2 = symbolName;
		if (symbolName2 == null) {
			SymbolNameBuilder s1 = new SymbolNameBuilder(0);			// No limit
			SymbolNameBuilder s2 = new SymbolNameBuilder(50);			// 50 character inner limit
			computeSymbolName(s2);
			s1.appendString(getSymbolNamePrefix());
			s1.appendString(s2.toString());
			s1.appendString(String.valueOf(getSymbolNameSuffix()));
			ScheduleModel scheduleModel = QVTscheduleUtil.basicGetContainingScheduleModel(this);
			if (scheduleModel != null) {
				symbolName2 = scheduleModel.reserveSymbolName(s1, this);
				//				System.out.println("Reserved '" + symbolName2 + "' for " + this);
			}
			else {
				symbolName2 = s1.toString();
				System.err.println("Failed to reserve '" + symbolName2 + "' for " + this);
			}
			symbolName = symbolName2;
			//			if ((symbolName != null) && symbolName.contains("mTmapIfExp__DmapOclExpression_d2qvtrExpression_glob")) {
			//				getClass().toString();
			//			}
		}
		return symbolName2; */
	}

	//	protected @NonNull String getSymbolNamePrefix() {
	//		return QVTscheduleConstants.REGION_SYMBOL_NAME_PREFIX;
	//	}

	//	protected String getSymbolNameSuffix() {
	//		return QVTscheduleConstants.REGION_SYMBOL_NAME_SUFFIX;
	//	}

	/*	private boolean hasEdgeConnection(@NonNull Node predicatedNode) {
		for (@NonNull Edge edge : predicatedNode.getIncomingEdges()) {
			if ((edge instanceof NavigationEdge) && (((NavigationEdge) edge).getIncomingConnection() != null)) {
				return true;
			}
		}
		for (@NonNull Edge edge : predicatedNode.getOutgoingEdges()) {
			if ((edge instanceof NavigationEdge) && (((NavigationEdge) edge).getIncomingConnection() != null)) {
				return true;
			}
		}
		return false;
	} */

	@Override
	public boolean isLoadingRegion() {
		return false;
	}

	@Override
	public boolean isOperationRegion() {
		return false;
	}

	/**
	 * Refine the call bindings of a mapping so that:
	 *
	 * Passed Bindings to the head that violate the head's predicates are removed, and in the case of a single caller
	 * the passed binding is redirected direct to the caller to facilitate re-use of the calling context.
	 *
	@Override
	public void refineBindings(@NonNull Region bindingRegion) {
		refineHeadBindings(bindingRegion);
		/*		List<Node> predicatedNodes = new ArrayList<>();
		Iterables.addAll(predicatedNodes, getPredicatedNodes());
		for (Node calledNode : predicatedNodes) {
			if (calledNode.isHead() && !calledNode.isAttributeNode()) {
//					for (@SuppressWarnings("null")@NonNull List<Node> headGroup : calledRegion.getHeadNodeGroups()) {
//						for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						List<Node> resolvedCallingSources = new ArrayList<>();
						boolean prunedOne = false;
						for (@SuppressWarnings("null")@NonNull Node callingSource : calledNode.getPassedBindingSources()) {
							if (canExpandRecursion(callingSource, calledNode, new HashMap<>())) {
								resolvedCallingSources.add(callingSource);
							}
							else {
								prunedOne = true;
							}
						}
						if (prunedOne) {
							List<Edge> deadEdges = new ArrayList<>();
							Iterables.addAll(deadEdges, calledNode.getIncomingPassedBindingEdges());
							for (@SuppressWarnings("null")@NonNull Edge deadEdge : deadEdges) {
								deadEdge.destroy();
							}
							Node targetNode = calledNode;
							if (resolvedCallingSources.size() > 1) {
								targetNode = Nodes.JOIN.createNode(this, "-join-", targetNode.getClassDatumAnalysis());
								Edges.PASSED_BINDING.createEdge(this, targetNode, null, calledNode);
							}
							for (@SuppressWarnings("null")@NonNull Node resolvedCallingSource : resolvedCallingSources) {
								Edges.PASSED_BINDING.createEdge(this, resolvedCallingSource, null, targetNode);
							}
						}
//						}
//					}
			}
			else if (!calledNode.isHead() && !calledNode.isAttributeNode()) {
				List<NavigationEdge> bestPath = null;
				for (@SuppressWarnings("null")@NonNull List<Node> headGroup : getHeadNodeGroups()) {
					for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						bestPath = getBestPath(bestPath, getPath(headNode, calledNode, new HashSet<>()));
					}
				}
				if (bestPath != null) {
					for (@SuppressWarnings("null")@NonNull List<Node> headGroup : getHeadNodeGroups()) {
						for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
							List<Node> resolvedCallingSources = new ArrayList<>();
							for (@SuppressWarnings("null")@NonNull Node callingSource : headNode.getPassedBindingSources()) {
								Region callingRegion = callingSource.getRegion();
								boolean isRecursion = false;
								if (callingRegion == this) {
									for (Edge edge : calledNode.getRecursionEdges()) {
										if (edge.getTarget() == headNode) {
											isRecursion= true;
										}
									}
								}
								if (!isRecursion) {
									if (canCreatePath(callingSource, bestPath)) {
										resolvedCallingSources.add(callingSource);
									}
								}
							}
							for (@SuppressWarnings("null")@NonNull Node callingSource : resolvedCallingSources) {
								Map<Edge, Edge> innerEdge2outerEdge = createPath(callingSource, bestPath);
								List<Edge> deadEdges = new ArrayList<>();
								for (@SuppressWarnings("null")@NonNull Map.Entry<Edge, Edge> entry : innerEdge2outerEdge.entrySet()) {
									Edge innerEdge2 = entry.getKey();
									Node innerTarget = innerEdge2.getTarget();
									for (Edge bindingEdge : innerTarget.getIncomingUsedBindingEdges()) {
										deadEdges.add(bindingEdge);
									}
									Edge outerEdge = entry.getValue();
									Edges.USED_BINDING.createEdge(this, outerEdge.getTarget(), innerEdge2.getName(), innerTarget);
								}
								for (@SuppressWarnings("null")@NonNull Edge deadEdge : deadEdges) {
									deadEdge.destroy();
								}
							}
						}
					}
				}
			}
		} * /
	} */

	/**
	 * Refine the call bindings of a mapping so that:
	 *
	 * Passed Bindings to the head that violate the head's predicates are removed, and in the case of a single caller
	 * the passed binding is redirected direct to the caller to facilitate re-use of the calling context.
	 */
	protected void refineHeadBindings(@NonNull Region bindingRegion) {
		/*		for (@SuppressWarnings("null")@NonNull List<Node> headGroup : getHeadNodeGroups()) {
			for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
				List<Node> resolvedCallingSources = new ArrayList<>();
				boolean prunedOne = false;
				for (@SuppressWarnings("null")@NonNull Node callingSource : headNode.getPassedBindingSources()) {
					if (isConflictFree(callingSource, headNode)) {
						resolvedCallingSources.add(callingSource);
					}
					else {
						prunedOne = true;
					}
				}
				if (prunedOne) {
					List<Edge> deadEdges = new ArrayList<>();
					Iterables.addAll(deadEdges, headNode.getIncomingPassedBindingEdges());
					for (@SuppressWarnings("null")@NonNull Edge deadEdge : deadEdges) {
						deadEdge.destroy();
					}
					Node targetNode = headNode;
					if (resolvedCallingSources.size() > 1) {
						targetNode = Nodes.JOIN.createNode(this, "-join-", targetNode.getClassDatumAnalysis());
						Edges.PASSED_BINDING.createEdge(bindingRegion, targetNode, null, headNode);
					}
					for (@SuppressWarnings("null")@NonNull Node resolvedCallingSource : resolvedCallingSources) {
						Edges.PASSED_BINDING.createEdge(bindingRegion, resolvedCallingSource, null, targetNode);
					}
				}
			}
		} */
	}

	@Override
	public void resetHead(@NonNull Node headNode) {
		throw new UnsupportedOperationException("resetHead not supported for " + this);
	}

	/*	public void resolveRecursion() {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2nodes = RegionUtil.getCompleteClass2Nodes(this);
		List<@NonNull Node> headNodes = getHeadNodes();
		if (headNodes.size() == 1) {			// FIXME multi-heads
			Node headNode = headNodes.get(0);
			List<@NonNull Node> nodeList = completeClass2nodes.get(headNode.getCompleteClass());
			assert nodeList != null;
			if (nodeList.size() > 1) {
				for (@NonNull Node node : nodeList) {
					if (node != headNode) {
						Map<@NonNull Node, @NonNull Node> bindings = expandRecursion(headNode, node, new HashMap<>());
						if (bindings != null) {
							//						this.recursiveBindings  = bindings;
							for (Map.@NonNull Entry<@NonNull Node, @NonNull Node> entry : bindings.entrySet()) {
								@NonNull Node prevNode = entry.getKey();
								@NonNull Node nextNode = entry.getValue();
								RegionUtil.createRecursionEdge(prevNode, nextNode, prevNode.isHead());
							}
							return;				// FIXME can we have more than one recursion ??
						}
					}
				}
			}
		}
	} */

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		ToGraphVisitor visitor = new ToGraphVisitor(s);
		visitor.visit((Graphable)this);
	}

	@Override
	public @NonNull String toString() {
		return symbolName != null ? (symbolName/* + " - " + getName()*/) : String.valueOf(getName());
	}
} //RegionImpl
