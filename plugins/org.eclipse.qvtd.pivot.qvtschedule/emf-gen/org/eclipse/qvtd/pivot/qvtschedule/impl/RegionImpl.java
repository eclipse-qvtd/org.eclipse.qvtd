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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtschedule.Symbolable;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getInvokingRegion <em>Invoking Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl#getRegion <em>Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RegionImpl extends ElementImpl implements Region {
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
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edges;
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected Region region;

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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.REGION__SYMBOL_NAME:
				return getSymbolName();
			case QVTschedulePackage.REGION__EDGES:
				return getEdges();
			case QVTschedulePackage.REGION__INVOKING_REGION:
				return getInvokingRegion();
			case QVTschedulePackage.REGION__NODES:
				return getNodes();
			case QVTschedulePackage.REGION__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
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
			case QVTschedulePackage.REGION__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case QVTschedulePackage.REGION__INVOKING_REGION:
				setInvokingRegion((ScheduledRegion)newValue);
				return;
			case QVTschedulePackage.REGION__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.REGION__REGION:
				setRegion((Region)newValue);
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
			case QVTschedulePackage.REGION__EDGES:
				getEdges().clear();
				return;
			case QVTschedulePackage.REGION__INVOKING_REGION:
				setInvokingRegion((ScheduledRegion)null);
				return;
			case QVTschedulePackage.REGION__NODES:
				getNodes().clear();
				return;
			case QVTschedulePackage.REGION__REGION:
				setRegion((Region)null);
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
			case QVTschedulePackage.REGION__EDGES:
				return edges != null && !edges.isEmpty();
			case QVTschedulePackage.REGION__INVOKING_REGION:
				return getInvokingRegion() != null;
			case QVTschedulePackage.REGION__NODES:
				return nodes != null && !nodes.isEmpty();
			case QVTschedulePackage.REGION__REGION:
				return region != null;
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
		if (baseClass == GraphNode.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Symbolable.class) {
			switch (derivedFeatureID) {
				case QVTschedulePackage.REGION__SYMBOL_NAME: return QVTschedulePackage.SYMBOLABLE__SYMBOL_NAME;
				default: return -1;
			}
		}
		if (baseClass == ToDOTable.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == GraphNode.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Symbolable.class) {
			switch (baseFeatureID) {
				case QVTschedulePackage.SYMBOLABLE__SYMBOL_NAME: return QVTschedulePackage.REGION__SYMBOL_NAME;
				default: return -1;
			}
		}
		if (baseClass == ToDOTable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	private MultiRegion multiRegion;

	/**
	 * Ordered list of regions that call this region
	 */
	private final @NonNull List<@NonNull Region> callableParents = new ArrayList<>();

	/**
	 * Ordered list of regions that this region calls. May exclude some children whose dependencies are unsatisfied.
	 * May include non-children whose dependencies are satisfied by earlier child calls.
	 */
	private final @NonNull List<@NonNull Region> callableChildren = new ArrayList<>();

	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges = null;

	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2enforcedEdges = null;

	/**
	 * The indexes in the overall schedule at which this region can be executed. The first index is the index at which ALL
	 * invocations occur. Subsequent indexes are when a referenced value may become available enabling a deferred execution.
	 */
	private final @NonNull List<@NonNull Integer> indexes = new ArrayList<>();

	/**
	 * The connections hosted by this region and passed to child regions.
	 */
	private @NonNull List<@NonNull NodeConnection> rootConnections = new ArrayList<>();

	/**
	 * The connections propagated as middle guards from a hosted by a parent region and to one or more child regions.
	 */
	private @NonNull List<@NonNull NodeConnection> intermediateConnections = new ArrayList<>();

	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};

	protected RegionImpl(@NonNull MultiRegion multiRegion) {
		setMultiRegion(multiRegion);
	}

	/*	protected void addBindingEdges(@NonNull Map<Node, Node> invokingBindings) {
		for (Map.Entry<Node, Node> entry : invokingBindings.entrySet()) {
			@SuppressWarnings("null")@NonNull Node invokingNode = entry.getValue();
			@SuppressWarnings("null")@NonNull Node invokedNode = entry.getKey();
			EdgeRole.BINDING.createEdge(this, invokingNode, invokedNode);
		}
	} */

	@Override
	public void addCallToChild(@NonNull Region region) {
		callableChildren.add(region);
		((RegionImpl)region).callableParents.add(this);
	}

	private void addCheckedEdge(@NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isPredicated();
		assert predicatedEdge.getRegion() == this;
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges2 = typedModel2checkedEdges;
		assert typedModel2checkedEdges2 != null;
		ClassDatumAnalysis classDatumAnalysis = QVTscheduleUtil.getClassDatumAnalysis(predicatedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getTypedModel(classDatumAnalysis);
		Set<@NonNull NavigableEdge> checkedEdges = typedModel2checkedEdges2.get(typedModel);
		if (checkedEdges == null) {
			checkedEdges = new HashSet<>();
			typedModel2checkedEdges2.put(typedModel, checkedEdges);
		}
		checkedEdges.add(predicatedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    checked " + predicatedEdge.getProperty() +
			" at " + getIndexRangeText() + " in " + typedModel + " for " + this);
	}

	@Override
	public void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {
		assert realizedEdge.isRealized();
		assert realizedEdge.getRegion() == this;
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2enforcedEdges2 = typedModel2enforcedEdges;
		assert typedModel2enforcedEdges2 != null;
		ClassDatumAnalysis classDatumAnalysis = QVTscheduleUtil.getClassDatumAnalysis(realizedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getTypedModel(classDatumAnalysis);
		Set<@NonNull NavigableEdge> enforcedEdges = typedModel2enforcedEdges2.get(typedModel);
		if (enforcedEdges == null) {
			enforcedEdges = new HashSet<>();
			typedModel2enforcedEdges2.put(typedModel, enforcedEdges);
		}
		enforcedEdges.add(realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    enforced " + realizedEdge.getProperty() +
			" at " + getIndexRangeText() +
			" in " + classDatumAnalysis.getTypedModel() + " for " + this);
	}

	@Override
	public boolean addIndex(int index) {
		for (int i = 0; i < indexes.size(); i++) {
			Integer anIndex = indexes.get(i);
			if (index == anIndex) {
				return false;
			}
			if (index < anIndex) {
				indexes.add(i, index);
				return true;
			}
		}
		indexes.add(index);
		return true;
	}

	@Override
	public void addIntermediateConnection(@NonNull NodeConnection connection) {
		assert !intermediateConnections.contains(connection);
		intermediateConnections.add(connection);
	}

	@Override
	public void addRootConnection(@NonNull NodeConnection connection) {
		assert !rootConnections.contains(connection);
		rootConnections.add(connection);
	}

	@Override
	public void addVariableNode(@NonNull VariableDeclaration typedElement, @NonNull Node simpleNode) {}

	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		String name = getSymbolName() + "\\n " + getName();
		String indexText = getIndexText();
		if (indexText != null) {
			name = name + "\\n " + indexText;
		}
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

	protected @Nullable String basicGetSymbolName() {
		return symbolName;
	}

	@Override
	public void buildPredicatedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges) {
		for (@NonNull NavigableEdge predicatedEdge : getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = QVTscheduleUtil.getProperty(predicatedEdge);
				Node predicatedNode = predicatedEdge.getEdgeSource();
				ClassDatumAnalysis classDatumAnalysis = QVTscheduleUtil.getClassDatumAnalysis(predicatedNode);
				TypedModel typedModel = QVTscheduleUtil.getTypedModel(classDatumAnalysis);
				Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2predicatedEdges = typedModel2property2predicatedEdges.get(typedModel);
				if (property2predicatedEdges == null) {
					property2predicatedEdges = new HashMap<>();
					typedModel2property2predicatedEdges.put(typedModel, property2predicatedEdges);
				}
				List<@NonNull NavigableEdge> predicatedEdges = property2predicatedEdges.get(property);
				if (predicatedEdges == null) {
					predicatedEdges = new ArrayList<>();
					property2predicatedEdges.put(property, predicatedEdges);
				}
				predicatedEdges.add(predicatedEdge);
				QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " predicated for " + property);
			}
		}
		typedModel2checkedEdges = new HashMap<>();
	}

	@Override
	public void buildRealizedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		for (@NonNull NavigableEdge realizedEdge : getRealizedNavigationEdges()) {
			Property property = QVTscheduleUtil.getProperty(realizedEdge);
			Node realizedNode = realizedEdge.getEdgeSource();
			ClassDatumAnalysis classDatumAnalysis = QVTscheduleUtil.getClassDatumAnalysis(realizedNode);
			TypedModel typedModel = QVTscheduleUtil.getTypedModel(classDatumAnalysis);
			Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
			if (property2realizedEdges == null) {
				property2realizedEdges = new HashMap<>();
				typedModel2property2realizedEdges.put(typedModel, property2realizedEdges);
			}
			List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
			if (realizedEdges == null) {
				realizedEdges = new ArrayList<>();
				property2realizedEdges.put(property, realizedEdges);
			}
			realizedEdges.add(realizedEdge);
			QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " realized for " + property);
		}
		typedModel2enforcedEdges = new HashMap<>();
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
			NavigableEdge edge = sourceNode.getNavigationEdge(QVTscheduleUtil.getProperty(protoEdge));
			if (edge != null) {
				Node protoTarget = protoEdge.getEdgeTarget();
				Node target = edge.getEdgeTarget();
				if (target.isExplicitNull() != (protoTarget.isExplicitNull())) {
					return false;
				}
				sourceNode = target;
			}
		}
		return true;
	}

	@Override
	public void checkIncomingConnections() {
		/*		for (@NonNull Node node : getNodes()) {
			NodeConnection incomingConnection = node.getIncomingConnection();
			int incomingConnectionsSize = incomingConnection != null ? 1 : 0;
			if ((node.getNodeRole() == Nodes.COMPOSING) && node.getRegion().isRootCompositionRegion()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isTrue()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isHead()) {
//				assert incomingConnectionsSize == 1;
				if (incomingConnectionsSize != 1) {
					System.out.println("Inconsistent other incoming connections for " + node + " in " + this);
				}
			}
			else if (node.isAttributeNode()) {
//				assert incomingConnectionsSize == 0;		// ?? should we connect these
			}
			else if (node.isComposed()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isNull()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isOperation()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isRealized()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isGuard()) {
				;//assert incomingConnectionsSize == 0;
			}
			else if (node.isLoaded()) {
				;//assert incomingConnectionsSize == 0;
			}
			else {
				if (incomingConnectionsSize != 1) {
					System.out.println("Inconsistent other incoming connections for " + node + " in " + this);
				}
			}
		} */
	}

	@Override
	public void computeCheckedOrEnforcedEdges(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		//		CompleteModel completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		boolean doDebug = QVTscheduleConstants.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("analyzing " + this + " (" + getIndexRangeText() + ")");
		}
		for (@NonNull NavigableEdge predicatedEdge : getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = predicatedEdge.getProperty();
				if (doDebug) {
					QVTscheduleConstants.POLLED_PROPERTIES.println("  analyzing " + predicatedEdge.getEdgeSource().getName() + "::" + property.getName() + " : " + predicatedEdge.getEdgeSource().getCompleteClass());
				}
				EdgeConnection edgeConnection = predicatedEdge.getIncomingConnection();
				if (edgeConnection != null) {
					boolean isChecked = false;
					for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
						Region usedRegion = usedEdge.getRegion();
						usedRegion.addEnforcedEdge(usedEdge);
						if (usedRegion.getFinalExecutionIndex() >= getInvocationIndex()) {
							addCheckedEdge(predicatedEdge);
							isChecked = true;
						}
					}
					if (isChecked) {
						for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
							Region usedRegion = usedEdge.getRegion();
							usedRegion.addEnforcedEdge(usedEdge);
						}
					}
				}

				Node laterNode = predicatedEdge.getEdgeSource();
				Node predicatedSourceNode = predicatedEdge.getEdgeSource();
				Node predicatedTargetNode = predicatedEdge.getEdgeTarget();
				NodeConnection usedConnection = predicatedTargetNode.getIncomingUsedConnection();
				if (usedConnection != null) {
					for (@NonNull Node usedSourceNode : QVTscheduleUtil.getSourceEnds(usedConnection)) {
						Region usedRegion = QVTscheduleUtil.getRegion(usedSourceNode);
						if (usedRegion.getFinalExecutionIndex() >= getInvocationIndex()) {			// FIXME =
							CompleteClass predicatedSourceType = predicatedSourceNode.getCompleteClass();
							CompleteClass predicatedTargetType = predicatedTargetNode.getCompleteClass();
							ClassDatumAnalysis classDatumAnalysis = laterNode.getClassDatumAnalysis();
							TypedModel typedModel = classDatumAnalysis.getTypedModel();
							Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
							assert property2realizedEdges != null;
							Property oclContainerProperty = getStandardLibraryHelper().getOclContainerProperty();
							if (property == oclContainerProperty) {
								//								Node containerNode = predicatedEdge.getTarget();
								//								Node containedNode = predicatedEdge.getSource();
								//								CompleteClass containerType = containerNode.getCompleteClass();
								//								CompleteClass containedType = containedNode.getCompleteClass();
								for (@NonNull Property candidateProperty : property2realizedEdges.keySet()) {
									if (candidateProperty.isIsComposite()) {
										//										CompleteClass candidateContainerType = completeModel.getCompleteClass(candidateProperty.getOwningClass());
										//										CompleteClass candidateContainedType = completeModel.getCompleteClass(candidateProperty.getType());
										//									if (candidateContainerType.conformsTo(containerType) && containedType.conformsTo(candidateContainedType)) {
										List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(candidateProperty);
										assert realizedEdges != null;
										for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
											// FIXME recheck for narrower types ??
											Region earlierRegion = realizedEdge.getRegion();
											//												String isNotHazardous;
											//											if (this == earlierRegion) {
											//												isNotHazardous = "same region";	// FIXME must handle recursion
											//											}
											//											else if (earlierRegion.getLatestIndex() < getEarliestIndex()) {
											//												isNotHazardous = "later";// FIXME must handle any possible reads of any possible write
											//											}
											//											else {
											Node realizedSourceNode = realizedEdge.getEdgeSource();
											Node realizedTargetNode = realizedEdge.getEdgeTarget();
											CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
											CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
											if (realizedSourceType.conformsTo(predicatedSourceType) && realizedTargetType.conformsTo(predicatedTargetType)) {
												assert getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
												//														isNotHazardous = null;
											}
											else {
												//														isNotHazardous = "incompatible";
											}
											assert getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
											//													isNotHazardous = null;
											//											}
											//												if (isNotHazardous == null) {
											addCheckedEdge(predicatedEdge);
											earlierRegion.addEnforcedEdge(realizedEdge);
											//												}
											//												else if (doDebug) {
											//													QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored " + this + "::" + laterNode.getName() + "(" + getEarliestIndex() + ".." + getLatestIndex() + ")" +
											//															" " + isNotHazardous + " (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
											//												}
											//										}
										}
									}
								}
							}
							else {
								assert property2realizedEdges != null : "No realized typed model for " + typedModel;
								List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
								if (realizedEdges == null) {
									System.err.println("No realized edges for " + property + " in " + typedModel);
								}
								else {
									for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
										Region earlierRegion = realizedEdge.getRegion();
										String checkIsHazardFreeBecause;
										String enforceIsHazardFreeBecause;
										Node realizedSourceNode = realizedEdge.getEdgeSource();
										Node realizedTargetNode = realizedEdge.getEdgeTarget();
										CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
										CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
										if (!realizedSourceType.conformsTo(predicatedSourceType) || !realizedTargetType.conformsTo(predicatedTargetType)) {
											checkIsHazardFreeBecause = "incompatible";
											enforceIsHazardFreeBecause = "incompatible";
										}
										else if (this == earlierRegion) {
											checkIsHazardFreeBecause = null; 		// Same region requires inter-recursion check
											enforceIsHazardFreeBecause = null; 		// Same region requires inter-recursion enforce to be available for check
										}
										else if (earlierRegion.getFinalExecutionIndex() < getInvocationIndex()) {
											checkIsHazardFreeBecause = "later";
											enforceIsHazardFreeBecause = null; 		// Enforce required for later check
										}
										else {
											// The QVTi AS has insufficient precision to identify which of multiple references is hazardous
											checkIsHazardFreeBecause = null;
											enforceIsHazardFreeBecause = null;
										}
										if (checkIsHazardFreeBecause == null) {
											addCheckedEdge(predicatedEdge);
										}
										else if (doDebug) {
											QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored check for " + this + "::" + laterNode.getName() + "(" + getIndexRangeText() + ")" +
													" " + checkIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getEdgeSource().getName());
										}
										if (enforceIsHazardFreeBecause == null) {
											earlierRegion.addEnforcedEdge(realizedEdge);
										}
										else if (doDebug) {
											QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored enforce " + this + "::" + laterNode.getName() + "(" + getIndexRangeText() + ")" +
													" " + enforceIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getEdgeSource().getName());
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Recurse over the pattern of navigation edges from calledNode in a called mapping and callingNode in a calling mapping
	 *  to populate called2binding with the pair-wise equivalent nodes. The callingNode may be null for a null navigation.
	 *
	private void computeCompatiblePattern(@NonNull Node calledNode, @Nullable Node callingNode,
			@NonNull Map<@NonNull Node, @Nullable Node> calledNode2callingNode, @NonNull Map<@NonNull NavigationEdge, @Nullable NavigationEdge> calledEdge2callingEdge) {
		Node oldCallingNode = calledNode2callingNode.get(calledNode);
		if (oldCallingNode != null) {					// been here before
			assert (oldCallingNode == callingNode) || (callingNode == null);
			return;
		}
		if ((callingNode == null) && calledNode2callingNode.containsKey(calledNode)) {		// here before and consistently null
			return;
		}
		calledNode2callingNode.put(calledNode, callingNode);
		for (@NonNull NavigationEdge calledEdge : calledNode.getNavigationEdges()) {
			Node nextCalledNode = calledEdge.getTarget();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isAttributeNode()) {
				Property property = calledEdge.getProperty();
				NavigationEdge callingEdge = callingNode != null ? callingNode.getNavigationEdge(property) : null;
				if (!property.isIsImplicit()) {
					calledEdge2callingEdge.put(calledEdge, callingEdge);
				}
				if (callingEdge != null) {
					Node nextCallingNode = callingEdge.getTarget();
					assert nextCallingNode.isNull() == nextCalledNode.isNull();
					if (!nextCalledNode.isNull()) {
						computeCompatiblePattern(nextCalledNode, nextCallingNode, calledNode2callingNode, calledEdge2callingEdge);
					}
				}
				else {
					computeCompatiblePattern(nextCalledNode, null, calledNode2callingNode, calledEdge2callingEdge);
				}
			}
		}
	} */

	protected @NonNull SymbolNameBuilder computeSymbolName() {
		//		List<String> names = new ArrayList<>();
		//		for (@NonNull MappingAction action : getMappingActions()) {
		//			names.add(action.getMapping().getName());
		//		}
		//		Collections.sort(names);
		SymbolNameBuilder s = null;
		Set<@NonNull Node> bestToOneSubRegion = null;
		Node bestNamingNode = null;
		int bestToOneSubRegionSize = 0;
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
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
		if (bestNamingNode != null) {
			List<@NonNull String> edgeNames = new ArrayList<>();
			for (@NonNull NavigableEdge edge : bestNamingNode.getRealizedNavigationEdges()) {
				String name = PivotUtil.getName(QVTscheduleUtil.getProperty(edge));
				edgeNames.add(name);
			}
			if (edgeNames.size() > 0) {
				s = new SymbolNameBuilder();
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
					s = new SymbolNameBuilder();
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
			s = new SymbolNameBuilder();
			s.appendString(getSymbolNamePrefix());
			s.appendName(bestNamingNode.getCompleteClass().getName());
			List<@NonNull String> headNames = new ArrayList<>();
			for (@NonNull Node headNode : getHeadNodes()) {
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
			for (@NonNull Node headNode : getHeadNodes()) {
				s = new SymbolNameBuilder();
				s.appendString(getSymbolNamePrefix());
				s.appendName(headNode.getCompleteClass().getName());
				List<@NonNull String> edgeNames = new ArrayList<>();
				for (@NonNull NavigableEdge edge : headNode.getNavigationEdges()) {
					String propertyName = PivotUtil.getName(QVTscheduleUtil.getProperty(edge));
					edgeNames.add(edge.getEdgeTarget().isExplicitNull() ? propertyName + "0" : propertyName);
				}
				Collections.sort(edgeNames);
				for (@NonNull String edgeName : edgeNames) {
					s.appendString("_");
					s.appendName(edgeName);
				}
				break;
			}
		}
		return s != null ? s : new SymbolNameBuilder();
	}

	private @NonNull Set<@NonNull Node> computeToOneSubRegion(@NonNull Set<@NonNull Node> toOneSubRegion, @NonNull Node atNode) {
		if (toOneSubRegion.add(atNode)) {
			for (@NonNull NavigableEdge edge : atNode.getNavigationEdges()) {
				assert edge.getEdgeSource() == atNode;
				Property source2target = edge.getProperty();
				if (!source2target.isIsMany() && !source2target.isIsImplicit()) {
					computeToOneSubRegion(toOneSubRegion, edge.getEdgeTarget());
				}
			}
		}
		return toOneSubRegion;
	}

	/**
	 * Create a NodeConnection to the realized node for each attribute.
	 *
	private void createAttributeConnections() {
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		for (@NonNull NavigationEdge predicatedEdge : getPredicatedNavigationEdges()) {
			Node predicatedTarget = predicatedEdge.getTarget();
			if (predicatedEdge.isNavigation()
			 && !predicatedEdge.isCast()
			 && (predicatedTarget.getIncomingConnection() == null)
			 && predicatedTarget.isAttributeNode()) {			// FIXME isCast does not need to be isNavigation now that it can be isNavigable
				Iterable<@NonNull NavigationEdge> realizedEdges = rootScheduledRegion.getRealizedEdges(predicatedEdge);
				if (realizedEdges != null) {
					Property predicatedProperty = predicatedEdge.getProperty();
					assert !predicatedProperty.isIsImplicit();
					ClassDatumAnalysis classDatumAnalysis = predicatedTarget.getClassDatumAnalysis();
					List<@NonNull Node> sourceNodes = new ArrayList<>();
					for (@NonNull NavigationEdge realizedEdge : realizedEdges) {
						sourceNodes.add(realizedEdge.getTarget());
					}
					NodeConnection nodeConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
					nodeConnection.addUsedTargetNode(predicatedTarget, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  Attribute NodeConnection to " + predicatedTarget);
					}
				}
			}
		}
	} */

	/**
	 * Create an EdgeConnection for the predicatedEdge and/or its target node.
	 */
	private void createEdgeConnection(@NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isNavigation();
		assert predicatedEdge.getIncomingConnection() == null;
		if (predicatedEdge.isCast()) {
			return;			// casts are handled as an extension of a true navigation
		}
		Property predicatedProperty = predicatedEdge.getProperty();
		if (predicatedProperty.isIsImplicit()) {
			return;			// unnavigable opposites are handled by the navigable property
		}
		ScheduledRegion invokingRegion2 = getInvokingRegion();
		assert invokingRegion2 != null;
		ScheduledRegion rootScheduledRegion = invokingRegion2;//.getRootScheduledRegion();
		NavigableEdge castEdge = QVTscheduleUtil.getCastTarget(predicatedEdge);
		Node castTarget = QVTscheduleUtil.getCastTarget(castEdge.getEdgeTarget());
		ClassDatumAnalysis classDatumAnalysis = castTarget.getClassDatumAnalysis();
		if (classDatumAnalysis.getCompleteClass().getPrimaryClass() instanceof DataType) {
			Iterable<@NonNull NavigableEdge> realizedEdges = rootScheduledRegion.getNewEdges(predicatedEdge, classDatumAnalysis);
			if (realizedEdges != null) {
				List<@NonNull Node> sourceNodes = new ArrayList<>();
				for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
					if (QVTscheduleUtil.isElementallyConformantSource(realizedEdge, predicatedEdge) && QVTscheduleUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
						sourceNodes.add(realizedEdge.getEdgeTarget());
					}
				}
				NodeConnection nodeConnection = invokingRegion2.getAttributeConnection(sourceNodes, predicatedEdge.getEdgeSource().getCompleteClass(), predicatedProperty, classDatumAnalysis);
				nodeConnection.addUsedTargetNode(castTarget, false);
				if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
					QVTscheduleConstants.CONNECTION_CREATION.println("  Attribute NodeConnection \"" + nodeConnection + "\" to " + castTarget);
					//					Scheduler.CONNECTIONS.println("    classDatumAnalysis " + classDatumAnalysis);
					//					for (@NonNull Node sourceNode : sourceNodes) {
					//						Scheduler.CONNECTIONS.println("    from " + sourceNode.getRegion());
					//						Scheduler.CONNECTIONS.println("       " + sourceNode);
					//					}
					//					for (@NonNull NavigationEdge realizedEdge : realizedEdges) {
					//						Scheduler.CONNECTIONS.println("    edge " + realizedEdge);
					//					}
				}
			}
		}
		else {
			Iterable<@NonNull Node> sourceNodes = rootScheduledRegion.getNewNodes(classDatumAnalysis);
			//			if (sourceNodes != null) {
			Iterable<@NonNull NavigableEdge> realizedEdges = rootScheduledRegion.getNewEdges(predicatedEdge, classDatumAnalysis);
			if (realizedEdges != null) {
				Set<@NonNull Region> edgeSourceRegions = new HashSet<>();
				Set<@NonNull Region> nodeSourceRegions = new HashSet<>();
				for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
					edgeSourceRegions.add(QVTscheduleUtil.getRegion(realizedEdge));
				}
				if (sourceNodes != null) {
					for (@NonNull Node sourceNode : sourceNodes) {
						nodeSourceRegions.add(QVTscheduleUtil.getRegion(sourceNode));
					}
				}
				//
				// Create an EdgeConnection for the edge realizations unless all edges are sources by node sources.
				//
				if (!nodeSourceRegions.containsAll(edgeSourceRegions)) {	// If edges are assigned independently of their targets.
					Set<@NonNull Region> conformantEdgeSourceRegions = null;
					List<@NonNull NavigableEdge> thoseEdges = null;
					for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
						if (QVTscheduleUtil.isElementallyConformantSource(realizedEdge, predicatedEdge) && QVTscheduleUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
							if (thoseEdges == null) {
								thoseEdges = new ArrayList<>();
								conformantEdgeSourceRegions = new HashSet<>();
							}
							if (!thoseEdges.contains(realizedEdge)) {
								thoseEdges.add(realizedEdge);
								assert conformantEdgeSourceRegions != null;
								conformantEdgeSourceRegions.add(QVTscheduleUtil.getRegion(realizedEdge));
							}
						}
					}
					if ((thoseEdges != null) && !nodeSourceRegions.containsAll(conformantEdgeSourceRegions)) {
						EdgeConnection edgeConnection = invokingRegion2.getEdgeConnection(thoseEdges, predicatedProperty);
						if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
							QVTscheduleConstants.CONNECTION_CREATION.println("  EdgeConnection \"" + edgeConnection + "\" to " + predicatedEdge);
						}
						if (!Iterables.contains(edgeConnection.getTargetEdges(), castEdge)) {
							edgeConnection.addUsedTargetEdge(castEdge, false);
							if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
								for (@NonNull NavigableEdge thatEdge : thoseEdges) {
									QVTscheduleConstants.CONNECTION_CREATION.println("    from " + thatEdge.getRegion() + "  : " + thatEdge);
								}
							}
						}
					}
				}
			}
			//
			// Create a NodeConnection for the node realizations.
			//
			if ((sourceNodes != null)
					&& !castTarget.isLoaded()			// WIP and !isOnlyCast
					&& !castTarget.isConstant()
					&& !castTarget.isHead()
					&& !castTarget.isOperation()
					&& !castTarget.isTrue()
					&& (castTarget.getIncomingConnection() == null)
					//			 && !castTarget.isAttributeNode()
					//			 && !rootScheduledRegion.isOnlyCastOrRecursed(predicatedNode)
					//			 && !hasEdgeConnection(predicatedNode)
					) {
				NodeConnection predicatedConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
				predicatedConnection.addUsedTargetNode(castTarget, false);
				if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
					QVTscheduleConstants.CONNECTION_CREATION.println("  NodeConnection \"" + predicatedConnection + "\" to " + castTarget);
					for (@NonNull Node sourceNode : sourceNodes) {
						QVTscheduleConstants.CONNECTION_CREATION.println("    from " + sourceNode.getRegion() + " : " + sourceNode);
					}
				}
			}
			//			}
		}
	}

	/**
	 * Create and return a NodeConnection to the nodes that can provide the sources for headNode.
	 * Returns null if the pattern surrounding the headNode conflicts with the pattern
	 * surrounding all possible sources.
	 */
	private @Nullable NodeConnection createHeadConnection(@NonNull Node headNode) {
		ScheduledRegion invokingRegion2 = getInvokingRegion();
		assert invokingRegion2 != null;
		ScheduledRegion rootScheduledRegion = invokingRegion2;//.getRootScheduledRegion();
		ClassDatumAnalysis classDatumAnalysis = QVTscheduleUtil.getClassDatumAnalysis(headNode);
		List<@NonNull Node> headSources = null;
		//
		//	Locate compatible introducers and non-recursive producers
		//
		Iterable<@NonNull Node> sourceNodes = rootScheduledRegion.getIntroducingOrNewNodes(headNode);
		if (sourceNodes != null) {
			for (@NonNull Node sourceNode : sourceNodes) {
				//				Region sourceRegion = sourceNode.getRegion();
				//				if (sourceRegion != this) {
				Map<@NonNull Node, @NonNull Node> called2calling = new HashMap<>();
				if (isCompatiblePattern(headNode, sourceNode, called2calling)) {
					if (headSources == null) {
						headSources = new ArrayList<>();
					}
					headSources.add(sourceNode);
				}
				//				}
			}
		}
		if (headSources == null) {
			return null;
		}
		//
		//	Connect up the head
		//
		NodeConnection headConnection = invokingRegion2.getNodeConnection(headSources, classDatumAnalysis);
		if (headNode.isDependency()) {
			headConnection.addUsedTargetNode(headNode, false);
		}
		else {
			headConnection.addPassedTargetNode(headNode);
		}
		if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
			QVTscheduleConstants.CONNECTION_CREATION.println((headNode.isDependency() ? "  Extra NodeConnection " : "  Head NodeConnection \"") + headConnection + "\" to " + headNode);
			for (@NonNull Node sourceNode : headSources) {
				QVTscheduleConstants.CONNECTION_CREATION.println("    from " + sourceNode.getRegion() + " : " + sourceNode);
			}
		}
		return headConnection;
	}

	/**
	 * Return the Connections to each of the head nodes. Returns null if the pattern surrounding any headNode conflicts with the pattern
	 * surrounding all its possible sources. (Any head with no sources is a non-invocation.)
	 */
	private @Nullable Iterable<@NonNull NodeConnection> createHeadConnections() {
		List<@NonNull NodeConnection> headConnections = null;
		for (@NonNull Node headNode : getHeadNodes()) {
			if (headNode.isTrue()) { /* true nodes do not need connections. */ }
			else if (headNode.isDependency()) {
				createHeadConnection(headNode);	/** Dependency nodes have extra not-head connections. */
			}
			else {
				NodeConnection headConnection = createHeadConnection(headNode);
				if (headConnection == null) {
					getSchedulerConstants().addRegionError(this, "createHeadConnections abandoned for " + headNode);
					getSchedulerConstants().addRegionError(this, "createHeadConnections abandoned for " + headNode);
					headConnection = createHeadConnection(headNode);	// FIXME debugging
					return null;										//  so matching only fails for unmatchable real heads
				}
				else {
					if (headConnections == null) {
						headConnections = new ArrayList<>();
					}
					headConnections.add(headConnection);
				}
				// FIXME. If there are multiple heads and an internal node is reachable from more than one head, then the possible
				// sources for the internal node are the intersection of the alternatives which may eliminate some call paths.
			}
		}
		return headConnections;
	}

	/**
	 * Create the connections that establish the inter-region dependencies.
	 *
	 * Every node/edge must have a connection to all its possible sources to ensure that the compile-time / run-time
	 * scheduler delays the execution of this region until the sources are available.
	 *
	 * Connections may be omitted when we can prove that the connection is available as a consequence of some restriction.
	 * - a connection to a CONSTANT source is unnecessary (always available)
	 * - a connection to a LOADED source is unnecessary (always available)
	 * - a connection to a source whose navigation path is incompatible with the head-to-target path is unnecessary
	 * - a connection to a node that is only used in cast form is unnecessary (the cast node provides more precision)
	 * - a connection to a cast edge is unnecessary (the cast edge extends a navigation edge that has a connection)
	 *
	 * Connections to attribute nodes are connected to just the node; a 'duplicate' edge connection is unnecessary
	 *
	 * Connections to realized nodes can be omitted if they are at one end of a realized edge
	 *
	 * Connections to edges account for type conformance of the nodes ends. The edge ends extend to account for casts.
	 *
	 * Each head node has a passed connection from its sources.
	 * Consistently related nodes navigable from the head have a bindable connection to the correspondingly related sources.
	 * Inconsistently related nodes navigable from the head have a computable connection to all compatibly typed sources.
	 * Unrelated nodes such as the internals of computations are not connected; their dependencies should be in dependency heads.
	 * Edges dependent on realization elsewhere are represented by connection from all head nodes of the dependent region
	 * to all heads of the realizing region.
	 */
	@Override
	public void createIncomingConnections() {
		if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
			QVTscheduleConstants.CONNECTION_CREATION.println("connecting " + this);
		}
		//		assert !(this instanceof RootCompositionRegion);
		assert !"RootCompositionRegion".equals(eClass().getName());
		Iterable<@NonNull NodeConnection> headConnections = createHeadConnections();
		if (headConnections != null) {
			for (@NonNull NavigableEdge predicatedEdge : getPredicatedNavigationEdges()) {
				if (!predicatedEdge.isCast()) {
					createEdgeConnection(predicatedEdge);
				}
			}
		}
	}

	/**
	 * Create a NodeConnection to the realized node for each node, unless there is already an EdgeConnection for any edge to/from the node.
	 *
	private void createNodeConnections() {
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		for (@NonNull Node predicatedNode : getPredicatedNodes()) {
			if (!predicatedNode.isLoaded()			// WIP and !isOnlyCast
			 && !predicatedNode.isConstant()
			 && !predicatedNode.isHead()
			 && !predicatedNode.isOperation()
			 && !predicatedNode.isTrue()
			 && (predicatedNode.getIncomingConnection() == null)
			 && !predicatedNode.isAttributeNode()
			 && !rootScheduledRegion.isOnlyCastOrRecursed(predicatedNode)
			 && !hasEdgeConnection(predicatedNode)) {
				ClassDatumAnalysis classDatumAnalysis = predicatedNode.getClassDatumAnalysis();
				Iterable<@NonNull Node> sourceNodes = rootScheduledRegion.getIntroducingOrProducingNodes(classDatumAnalysis);
				if (sourceNodes != null) {
					NodeConnection predicatedConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
					predicatedConnection.addUsedTargetNode(predicatedNode, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  NodeConnection from " + predicatedNode);
					}
				}
			}
		}
	} */

	/**
	 * Create a NodeConnection to the realized node for each node in the pattern related to a head node.
	 *
	private void createRelatedConnections(@NonNull NodeConnection headConnection) {
		@NonNull Iterable<@NonNull Node> headSources = headConnection.getSources();
		/**
	 * Each bindable node is navigable within the guard/predicate from the head and has an equivalent node in every possible caller.
	 * A bindable node may therefore by passed by value from each of a known set of calling nodes to each called node.
	 * /
		Map<@NonNull NavigationEdge, @NonNull List<@NonNull NavigationEdge>> related2bindableSources = new HashMap<>();
		/**
	 * Each computable node is navigable within the guard/predicate from the head but does not have an equivalent node in every possible caller.
	 * A computable node cannot always be passed by value. It is therefore recomputed within a known set of calling regions at each called node.
	 * /
		Map<@NonNull Node, @NonNull List<@NonNull Region>> related2computableSources = new HashMap<>();
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		//
		//	Categorize the corresponding sources for each related node as uniformly bindable else re-computable.
		//
		for (@NonNull Node headSource : headSources) {
			Region sourceRegion = headSource.getRegion();
			assert this != sourceRegion;
			for (@NonNull Node headNode : headConnection.getTargets()) {
				if ((headNode.getRegion() == this) && headNode.isHead()) {
					Map<@NonNull Node, @Nullable Node> calledNode2callingNode = new HashMap<>();
					Map<@NonNull NavigationEdge, @Nullable NavigationEdge> calledEdge2callingEdge = new HashMap<>();
					computeCompatiblePattern(headNode, headSource, calledNode2callingNode, calledEdge2callingEdge);
					for (Map./*@NonNull* /Entry<@NonNull NavigationEdge, @Nullable NavigationEdge> entry : calledEdge2callingEdge.entrySet()) {
						@NonNull NavigationEdge calledEdge = entry.getKey();
						@NonNull Node calledNode = calledEdge.getTarget();
						assert calledNode.isHead() == (calledNode == headNode);		// FIXME validating more efficient test
						if (!calledNode.isHead()
						 && !calledNode.isLoaded()
						 && !calledNode.isConstant()
						 && !rootScheduledRegion.isOnlyCastOrRecursed(calledNode)) {
							@Nullable NavigationEdge callingEdge = entry.getValue();
							if ((callingEdge != null) && !related2computableSources.containsKey(calledNode)) {
								List<@NonNull NavigationEdge> bindableSources = related2bindableSources.get(calledEdge);
								if (bindableSources == null) {
									bindableSources = new ArrayList<>();
									related2bindableSources.put(calledEdge, bindableSources);
								}
								assert !bindableSources.contains(callingEdge);
								bindableSources.add(callingEdge);
							}
							else {
								List<@NonNull Region> computableSources = related2computableSources.get(calledNode);
								if (computableSources == null) {
									computableSources = new ArrayList<>();
									related2computableSources.put(calledNode, computableSources);
								}
								assert !computableSources.contains(sourceRegion);
								computableSources.add(sourceRegion);
								if (related2bindableSources.containsKey(calledEdge)) {
									List<@NonNull NavigationEdge> bindableSources = related2bindableSources.remove(calledEdge);
									assert bindableSources != null;
									for (@NonNull NavigationEdge bindableSource : bindableSources) {
										Region bindableRegion = bindableSource.getRegion();
										assert !computableSources.contains(sourceRegion);
										computableSources.add(bindableRegion);
									}
								}
							}
						}
					}
				}
			}
		}
		assert Sets.intersection(related2bindableSources.keySet(), related2computableSources.keySet()).isEmpty();
		//
		//	Connect the uniformly bindable calling sources to their called nodes.
		//
		for (Map./*@NonNull* /Entry<@NonNull NavigationEdge, @NonNull List<@NonNull NavigationEdge>> entry : related2bindableSources.entrySet()) {
			@NonNull NavigationEdge calledEdge = entry.getKey();
			@NonNull Node calledNode = calledEdge.getTarget();
			assert !calledNode.isLoaded() && !calledNode.isConstant();
			@NonNull List<@NonNull NavigationEdge> bindableEdges = entry.getValue();
			EdgeConnection bindableConnection = invokingRegion2.getEdgeConnection(bindableEdges, calledEdge.getProperty());
			bindableConnection.addUsedTargetEdge(calledEdge, false);
			if (Scheduler.CONNECTIONS.isActive()) {
				Scheduler.CONNECTIONS.println("  Bindable EdgeConnection to " + calledEdge);
			}
		}
		//
		//	Connect the introducing/producing nodes of the not uniformly bindable calling sources to their called nodes.
		//
		for (Map./*@NonNull* /Entry<@NonNull Node, @NonNull List<@NonNull Region>> entry : related2computableSources.entrySet()) {
			@NonNull Node calledNode = entry.getKey();
			assert !calledNode.isLoaded() && !calledNode.isConstant() && !rootScheduledRegion.isOnlyCastOrRecursed(calledNode);
			ClassDatumAnalysis classDatumAnalysis = calledNode.getClassDatumAnalysis();
			Iterable<@NonNull Node> introducingOrProducingNodes = rootScheduledRegion.getIntroducingOrProducingNodes(classDatumAnalysis);
			if (introducingOrProducingNodes != null) {
				@NonNull List<@NonNull Region> computableRegions = entry.getValue();
				List<@NonNull Node> computableSourceNodes = null;
				assert calledNode.getRegion() == this;		// FIXME just checking simpler test
				for (@NonNull Node computableSourceNode : introducingOrProducingNodes) {
					Region sourceRegion = computableSourceNode.getRegion();
					if ((computableSourceNode.getRegion() != this) && !computableRegions.contains(sourceRegion)) {		// FIXME only if a Recursion Edge
						if (computableSourceNodes == null) {
							computableSourceNodes = new ArrayList<>();
						}
						computableSourceNodes.add(computableSourceNode);
					}
				}
				if (computableSourceNodes != null) {
					NodeConnection computableConnection = invokingRegion2.getNodeConnection(computableSourceNodes, classDatumAnalysis);
					computableConnection.addUsedTargetNode(calledNode, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  Computable NodeConnection to " + calledNode);
					}
				}
			}
		}
	} */

	/*	protected @Nullable Map<@NonNull Node, @NonNull Node> expandRecursion(@NonNull Node nextNode, @NonNull Node prevNode, @NonNull Map<@NonNull Node, @NonNull Node> bindings) {
		Node oldPrevNode = bindings.put(nextNode, prevNode);
		if (oldPrevNode != null) {
			assert oldPrevNode == prevNode;
			return bindings;
		}
		for (@NonNull NavigableEdge navigationEdge : prevNode.getNavigationEdges()) {
			Node nextTarget = nextNode.getNavigationTarget(navigationEdge.getProperty());
			if (nextTarget == null) {
				return null;
			}
			Node prevTarget = navigationEdge.getEdgeTarget();
			if (expandRecursion(nextTarget, prevTarget, bindings) == null) {
				return null;
			}
		}
		return bindings;
	} */

	@Override
	public @NonNull Iterable<@NonNull Node> getAncestorsOf(@NonNull Node node) {
		List<@NonNull Node> ancestors = new ArrayList<>();
		HashSet<@NonNull Node> ancestorSet = new HashSet<>();
		node.getAllAncestors(ancestorSet);
		for (@NonNull Node ancestor : ancestorSet) {
			if (ancestor.getRegion() == this) {
				ancestors.add(ancestor);
			}
		}
		return ancestors;
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

	private @NonNull NavigableEdge getBestEdge(@Nullable NavigableEdge bestEdge, @NonNull NavigableEdge candidateEdge) {
		if (bestEdge == null) {
			return candidateEdge;
		}
		if ((bestEdge.getProperty().isIsImplicit() && !candidateEdge.getProperty().isIsImplicit())) {
			return candidateEdge;
		}
		return bestEdge;		// ??? containment
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableChildren() {
		return callableChildren;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableParents() {
		return callableParents;
	}

	@Override
	public @NonNull List<@NonNull Region> getCalledRegions() {
		List<@NonNull Region> childRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection childConnection : getOutgoingPassedConnections()) {
			for (@NonNull Node childNode : childConnection.getTargetNodes()) {
				Region childRegion = QVTscheduleUtil.getRegion(childNode);
				if (!childRegions.contains(childRegion)) {
					childRegions.add(childRegion);
				}
			}
		}
		return childRegions;
	}

	@Override
	public @NonNull List<@NonNull Region> getCallingRegions() {
		List<@NonNull Region> callingRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection callingConnection : getIncomingPassedConnections()) {
			for (@NonNull Node callingNode : QVTscheduleUtil.getSourceEnds(callingConnection)) {
				Region callingRegion = QVTscheduleUtil.getRegion(callingNode);
				if (!callingRegions.contains(callingRegion)) {
					callingRegions.add(callingRegion);
				}
			}
		}
		return callingRegions;
	}

	/*	@Override
	public final @NonNull Iterable<Edge> getCastEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsCastEdgePredicate.INSTANCE);
		return filter;
	} */

	@Override
	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
	}

	@Override
	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement) {
		return getSchedulerConstants().getClassDatumAnalysis(typedElement);
	}

	//	@Override
	//	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull Type type) {
	//		return getSchedulerConstants().getClassDatumAnalysis(type);
	//	}

	@Override
	public @NonNull String getColor() {
		return "blue";
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getComposedNodes() {
		return Iterables.filter(QVTscheduleUtil.getNodes(this), QVTscheduleUtil.IsComposedNodePredicate.INSTANCE);
	}

	/*	public final @NonNull Iterable<@NonNull Node> getComputedNodes() {
		return Iterables.filter(nodes, IsComputedPredicate.INSTANCE);
	} */

	/*	public final @NonNull Iterable<? extends Edge> getConsumedOrderingEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsConsumedOrderingEdgePredicate.INSTANCE);
		return filter;
	} */

	private int getCost(@NonNull List<@NonNull NavigableEdge> path) {
		int cost = 0;
		for (@NonNull NavigableEdge edge : path) {
			if (edge.getProperty().isIsImplicit()) {
				cost++;
			}		// ??? containment
		}
		return cost;
	}

	/*	public int getEarliestPassedConnectionSourceIndex() {
		int earliestPassedConnectionSourceIndex = 0;
		for (@NonNull NodeConnection passedConnection : getIncomingPassedConnections()) {
			for (@NonNull Region sourceRegion : passedConnection.getSourceRegions()) {
				int firstPassedConnectionSourceIndex = sourceRegion.getIndexes().get(0);
				if (firstPassedConnectionSourceIndex > earliestPassedConnectionSourceIndex) { // Latest of multiple passed connections
					earliestPassedConnectionSourceIndex = firstPassedConnectionSourceIndex;
				}
			}
		}
		return earliestPassedConnectionSourceIndex;
	} */

	@Override
	public @Nullable Set<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2enforcedEdges != null;
		return typedModel2enforcedEdges.get(typedModel);
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getExpressionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getEdges(this), QVTscheduleUtil.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public int getFinalExecutionIndex() {
		assert indexes.size() > 0;
		return indexes.get(indexes.size()-1);
	}

	@Override
	public int getFirstIndex() {
		int size = indexes.size();
		assert size > 0;
		return indexes.get(0);
	}

	@Override
	public @NonNull Iterable<@NonNull DatumConnection<?>> getIncomingConnections() {		// FIXME cache
		List<@NonNull DatumConnection<?>> connections = new ArrayList<>();
		for (@NonNull Node headNode : getHeadNodes()) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
			if (node.isDependency() || node.isPattern()) {
				if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
					NodeConnection connection = node.getIncomingUsedConnection();
					if ((connection != null) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		for (@NonNull NavigableEdge edge : getPredicatedNavigationEdges()) {
			EdgeConnection connection = edge.getIncomingConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getIncomingPassedConnections() {		// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node headNode : getHeadNodes()) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if (connection != null) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getIncomingUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = node.getIncomingUsedConnection();
				if (connection != null) {
					connections.add(connection);
				}
			}
		}
		return connections;
	}

	@Override
	public @NonNull String getIndexRangeText() {
		return getInvocationIndex() + ".." + getFinalExecutionIndex();
	}

	public @Nullable String getIndexText() {
		StringBuilder s = null;
		for (@NonNull Integer index : indexes) {
			if (s == null) {
				s = new StringBuilder();
			}
			else {
				s.append(",");
			}
			s.append(index.toString());
		}
		return s != null ? s.toString() : null;
	}

	@Override
	public @NonNull List<@NonNull Integer> getIndexes() {
		return indexes;
	}

	@Override
	public @NonNull List<@NonNull NodeConnection> getIntermediateConnections() {
		return intermediateConnections;
	}

	@Override
	public int getInvocationIndex() {
		assert indexes.size() > 0;
		return indexes.get(0);
	}

	@Override
	public int getLastIndex() {
		int size = indexes.size();
		assert size > 0;
		return indexes.get(size-1);
	}

	@Override
	public @NonNull List<@NonNull DatumConnection<?>> getLoopingConnections() {
		List<@NonNull DatumConnection<?>> loopingConnections = new ArrayList<>();
		for (@NonNull DatumConnection<?> connection : getOutgoingConnections()) {
			for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
				if (this == sourceRegion) {
					for (@NonNull Region targetRegion : connection.getTargetRegions()) {
						if ((this == targetRegion) && !loopingConnections.contains(connection)) {
							loopingConnections.add(connection);
						}
					}
				}
			}
		}
		return loopingConnections;
	}

	@Override
	public @NonNull MultiRegion getMultiRegion() {
		return ClassUtil.nonNullState(multiRegion);
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getNavigableNodes() {
		return Iterables.filter(QVTscheduleUtil.getNodes(this), QVTscheduleUtil.IsNavigableNodePredicate.INSTANCE);
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getNavigationEdges() {
		@NonNull Iterable<@NonNull NavigableEdge> filter = Iterables.filter(QVTscheduleUtil.getEdges(this), NavigableEdge.class);
		return filter;
	}

	//	@Override
	//	public @Nullable Node getNavigationTarget(@NonNull ClassNode sourceNode, @NonNull Property source2targetProperty) {
	//		NavigationEdge navigationEdge = getNavigationEdge(sourceNode, source2targetProperty);
	//		return navigationEdge !=  null ? navigationEdge.getTarget() : null;
	//	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getNewNodes() {
		return Iterables.filter(QVTscheduleUtil.getNodes(this), QVTscheduleUtil.IsNewNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull Iterable<@NonNull DatumConnection<?>> getNextConnections() {
		return getOutgoingConnections();
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
			case QVTschedulePackage.REGION__EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdges()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.REGION__INVOKING_REGION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInvokingRegion((ScheduledRegion)otherEnd, msgs);
			case QVTschedulePackage.REGION__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
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
			case QVTschedulePackage.REGION__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.REGION__INVOKING_REGION:
				return basicSetInvokingRegion(null, msgs);
			case QVTschedulePackage.REGION__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
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
			case QVTschedulePackage.REGION__INVOKING_REGION:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.SCHEDULED_REGION__REGIONS, ScheduledRegion.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getOldNodes() {
		return Iterables.filter(QVTscheduleUtil.getNodes(this), QVTscheduleUtil.IsOldNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull List<@NonNull DatumConnection<?>> getOutgoingConnections() {			// FIXME cache
		List<@NonNull DatumConnection<?>> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		for (@NonNull NavigableEdge edge : getNavigationEdges()) {
			for (@NonNull EdgeConnection connection : QVTscheduleUtil.getOutgoingConnections(edge)) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	protected @Nullable List<@NonNull NavigableEdge> getPath(@NonNull Node sourceNode, @NonNull Node targetNode, @NonNull Set<@NonNull Edge> usedEdges) {
		assert sourceNode.getRegion() == targetNode.getRegion();
		NavigableEdge bestEdge = null;
		List<@NonNull NavigableEdge> bestPath = null;
		for (@NonNull NavigableEdge edge : sourceNode.getNavigationEdges()) {
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
		return Iterables.filter(QVTscheduleUtil.getNodes(this), QVTscheduleUtil.IsPatternNodePredicate.INSTANCE);
	}

	public final @NonNull Iterable<NavigableEdge> getPredicateEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getEdges(this), QVTscheduleUtil.IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getPredicatedNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getEdges(this), QVTscheduleUtil.IsPredicatedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRealizedEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getEdges(this), QVTscheduleUtil.IsRealizedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getRealizedNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(QVTscheduleUtil.getEdges(this), QVTscheduleUtil.IsRealizedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRecursionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(QVTscheduleUtil.getEdges(this), QVTscheduleUtil.IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull List<@NonNull NodeConnection> getRootConnections() {
		return rootConnections;
	}

	@Override
	public @NonNull SchedulerConstants getSchedulerConstants() {
		return multiRegion.getSchedulerConstants();
	}

	@Override
	public @Nullable String getShape() {
		return null;
	}

	public @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		return getSchedulerConstants().getStandardLibraryHelper();
	}

	@Override
	public @Nullable String getStyle() {
		return null;
	}

	@Override
	public final @NonNull String getSymbolName() {
		String symbolName2 = symbolName;
		if (symbolName2 == null) {
			SymbolNameBuilder s = new SymbolNameBuilder(0);
			s.appendString(getSymbolNamePrefix());
			s.appendString(computeSymbolName().toString());
			s.appendString(getSymbolNameSuffix());
			symbolName = symbolName2 = getSchedulerConstants().reserveSymbolName(s, this);
		}
		return symbolName2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Edge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentWithInverseEList<Edge>(Edge.class, this, QVTschedulePackage.REGION__EDGES, QVTschedulePackage.EDGE__REGION);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduledRegion getInvokingRegion() {
		if (eContainerFeatureID() != QVTschedulePackage.REGION__INVOKING_REGION) return null;
		return (ScheduledRegion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvokingRegion(ScheduledRegion newInvokingRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInvokingRegion, QVTschedulePackage.REGION__INVOKING_REGION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInvokingRegion(ScheduledRegion newInvokingRegion) {
		if (newInvokingRegion != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.REGION__INVOKING_REGION && newInvokingRegion != null)) {
			if (EcoreUtil.isAncestor(this, newInvokingRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInvokingRegion != null)
				msgs = ((InternalEObject)newInvokingRegion).eInverseAdd(this, QVTschedulePackage.SCHEDULED_REGION__REGIONS, ScheduledRegion.class, msgs);
			msgs = basicSetInvokingRegion(newInvokingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.REGION__INVOKING_REGION, newInvokingRegion, newInvokingRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<Node>(Node.class, this, QVTschedulePackage.REGION__NODES, QVTschedulePackage.NODE__REGION);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Region getRegion() {
		if (region != null && region.eIsProxy()) {
			InternalEObject oldRegion = (InternalEObject)region;
			region = (Region)eResolveProxy(oldRegion);
			if (region != oldRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.REGION__REGION, oldRegion, region));
			}
		}
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region basicGetRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegion(Region newRegion) {
		Region oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.REGION__REGION, oldRegion, region));
	}

	protected @NonNull String getSymbolNamePrefix() {
		return "m_";
	}

	protected @NonNull String getSymbolNameSuffix() {
		return "";
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getTrueNodes() {
		return Iterables.filter(QVTscheduleUtil.getNodes(this), QVTscheduleUtil.IsTrueNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull List<@NonNull NodeConnection> getUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> usedConnections = new ArrayList<>();
		for (@NonNull Node node : getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = node.getIncomingUsedConnection();
				if (connection != null) {
					usedConnections.add(connection);
				}
			}
		}
		return usedConnections;
	}

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
	public boolean isChildCompositionRegion() {
		return false;
	}

	/**
	 * Return true if the predicates of calledNode are not in conflict with the navigable paths from callingNode.
	 * called2calling identifies already identified conflict free pairs that do not need re-assessment.
	 */
	private boolean isCompatiblePattern(@NonNull Node calledNode, @NonNull Node callingNode, @NonNull Map<@NonNull Node, @NonNull Node> called2calling) {
		Node oldPrevNode = called2calling.put(calledNode, callingNode);
		if (oldPrevNode != null) {
			return oldPrevNode == callingNode;
		}
		for (@NonNull NavigableEdge calledEdge : calledNode.getNavigationEdges()) {
			Node nextCalledNode = calledEdge.getEdgeTarget();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isDataType()) {  // FIXME why exclude AttributeNodes?
				Edge nextCallingEdge = callingNode.getNavigationEdge(QVTscheduleUtil.getProperty(calledEdge));
				if (nextCallingEdge != null) {
					Node nextCallingNode = nextCallingEdge.getEdgeTarget();
					if ((nextCallingNode.isExplicitNull() != nextCalledNode.isExplicitNull())) {
						return false;
					}
					if (!isCompatiblePattern(nextCalledNode, nextCallingNode, called2calling)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean isOperationRegion() {
		return false;
	}

	@Override
	public boolean isRootCompositionRegion() {
		return false;
	}

	/**
	 * Refine the call bindings of a mapping so that:
	 *
	 * Passed Bindings to the head that violate the head's predicates are removed, and in the case of a single caller
	 * the passed binding is redirected direct to the caller to facilitate re-use of the calling context.
	 */
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
		} */
	}

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
	public void removeCallToChild(@NonNull Region region) {
		callableChildren.remove(region);
		((RegionImpl)region).callableParents.remove(this);
	}

	@Override
	public void replaceCallToChild(@NonNull Region oldRegion, @NonNull Region newRegion) {
		int index = callableChildren.indexOf(oldRegion);
		callableChildren.remove(oldRegion);
		callableChildren.add(index, newRegion);
		((RegionImpl)oldRegion).callableParents.remove(this);
		((RegionImpl)oldRegion).callableParents.add(this);
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

	public void setMultiRegion(@NonNull MultiRegion multiRegion) {
		this.multiRegion = multiRegion;
		multiRegion.addRegion(this);
	}

	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		s.appendNode(this);
		for (final @NonNull Region region : getCallableChildren()) {
			GraphEdge graphEdge = new GraphEdge()
			{
				@Override
				public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
					s.appendAttributedEdge(source, this, target);
				}

				@Override
				public @NonNull GraphNode getEdgeSource() {
					return RegionImpl.this;
				}

				@Override
				public @NonNull GraphNode getEdgeTarget() {
					return region;
				}
			};
			s.appendEdge(graphEdge.getEdgeSource(), graphEdge, graphEdge.getEdgeTarget());
		}
		for (final @NonNull NodeConnection connection : getRootConnections())
		{
			GraphEdge graphEdge1 = new GraphEdge() {
				@Override
				public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
					s.appendAttributedEdge(source, this, target);
				}

				@Override
				public @NonNull GraphNode getEdgeSource() {
					return RegionImpl.this;
				}

				@Override
				public @NonNull GraphNode getEdgeTarget() {
					return connection;
				}
			};
			s.appendEdge(graphEdge1.getEdgeSource(), graphEdge1, graphEdge1.getEdgeTarget());
			for (final @NonNull Node targetNode : connection.getTargetNodes())
			{
				GraphEdge graphEdge = new GraphEdge() {
					@Override
					public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
						s.appendAttributedEdge(source, this, target);
					}

					@Override
					public @NonNull GraphNode getEdgeSource() {
						return connection;
					}

					@Override
					public @NonNull GraphNode getEdgeTarget() {
						return QVTscheduleUtil.getRegion(targetNode);
					}
				};
				s.appendEdge(graphEdge.getEdgeSource(), graphEdge, graphEdge.getEdgeTarget());
			}
		}
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
			node.toGraph(s);
			//			s.appendNode(node);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getEdges(this)) {
			edge.toGraph(s);
			//			s.appendEdge(edge.getSource(), edge, edge.getTarget());
		}
		s.popCluster();
	}

	@Override
	public void toRegionGraph(@NonNull GraphStringBuilder s) {
		s.appendNode(this);
		for (@NonNull Edge edge : getRecursionEdges()) {
			s.appendEdge(QVTscheduleUtil.getRegion(edge.getEdgeSource()), edge, QVTscheduleUtil.getRegion(edge.getEdgeTarget()));
		}
	}

	@Override
	public @NonNull String toString() {
		return symbolName != null ? (symbolName/* + " - " + getName()*/) : String.valueOf(getName());
	}

	@Override
	public void writeDebugGraphs(@Nullable String context) {
		SchedulerConstants scheduler = getSchedulerConstants();
		String suffix = context != null ? "-" + context : null;
		scheduler.writeDOTfile(this, suffix);
		scheduler.writeGraphMLfile(this, suffix);
	}

} //RegionImpl
