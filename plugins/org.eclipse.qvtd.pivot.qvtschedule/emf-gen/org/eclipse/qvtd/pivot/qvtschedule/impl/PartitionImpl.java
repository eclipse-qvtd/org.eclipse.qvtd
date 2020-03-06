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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.AbstractToGraphVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToGraphPartitionVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToGraphVisitor2;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PartitionImpl#getPasses <em>Passes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PartitionImpl#getIntermediateConnections <em>Intermediate Connections</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PartitionImpl#getRootConnections <em>Root Connections</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PartitionImpl extends NamedElementImpl implements Partition {
	/**
	 * The number of structural features of the '<em>Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PARTITION_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PARTITION_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getPasses() <em>Passes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasses()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> passes;

	/**
	 * The cached value of the '{@link #getIntermediateConnections() <em>Intermediate Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeConnection> intermediateConnections;
	/**
	 * The cached value of the '{@link #getRootConnections() <em>Root Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeConnection> rootConnections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Integer> getPasses() {
		if (passes == null) {
			passes = new EDataTypeUniqueEList<Integer>(Integer.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
		}
		return passes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<NodeConnection> getIntermediateConnections() {
		if (intermediateConnections == null) {
			intermediateConnections = new EObjectResolvingEList<NodeConnection>(NodeConnection.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
		}
		return intermediateConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<NodeConnection> getRootConnections() {
		if (rootConnections == null) {
			rootConnections = new EObjectResolvingEList<NodeConnection>(NodeConnection.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
		}
		return rootConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getPasses();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getIntermediateConnections();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getRootConnections();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				getPasses().clear();
			getPasses().addAll((Collection<? extends Integer>)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getIntermediateConnections().clear();
			getIntermediateConnections().addAll((Collection<? extends NodeConnection>)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				getRootConnections().clear();
			getRootConnections().addAll((Collection<? extends NodeConnection>)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				getPasses().clear();
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getIntermediateConnections().clear();
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				getRootConnections().clear();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return passes != null && !passes.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return intermediateConnections != null && !intermediateConnections.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return rootConnections != null && !rootConnections.isEmpty();
		}
		return super.eIsSet(featureID);
	}


	private @Nullable String symbolName = null;

	@Override
	public void acceptGraphVisitor(@NonNull ToGraphVisitor2 toGraphVisitor) {
		accept((Visitor<?>)toGraphVisitor);
	}

	@Override
	public void addIntermediateConnection(@NonNull NodeConnection connection) {
		List<NodeConnection> intermediateConnections = getIntermediateConnections();
		assert !intermediateConnections.contains(connection);
		intermediateConnections.add(connection);
	}

	@Override
	public boolean addPass(int passNumber) {
		List<@NonNull Integer> passes2 = ClassUtil.nullFree(getPasses());
		if (passes2.size() > 0) {
			assert passNumber > passes2.get(0);		// Should not move earlier, or repeatedly first
		}
		for (int i = 0; i < passes2.size(); i++) {
			Integer aPassNumber = passes2.get(i);
			if (passNumber == aPassNumber) {
				return false;
			}
			if (passNumber < aPassNumber) {
				passes2.add(i, passNumber);
				return true;
			}
		}
		passes2.add(passNumber);
		return true;
	}

	@Override
	public void addRootConnection(@NonNull NodeConnection connection) {
		List<NodeConnection> rootConnections = getRootConnections();
		assert !rootConnections.contains(connection);
		rootConnections.add(connection);
	}

	@Override
	public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		String label = /*getSymbolName() + "\\n " +*/ getName();
		String passesText = getPassesText();
		if (passesText != null) {
			label = label + "\\n " + passesText;
		}
		s.setLabel(label);
		//	String shape = getShape();
		//	if (shape != null) {
		//		s.setShape(shape);
		//	}
		//	String style = getStyle();
		//	if (style != null) {
		//		s.setStyle(style);
		//	}
		s.setColor(getColor());
		//		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
		//		if (isHead) {
		//			s.append("}");
		//		}
	}

	protected void computeSymbolName(@NonNull SymbolNameBuilder sIn) {
		sIn.appendName(name.replace('«', '_').replace('-', '_').replace(',', '_').replace('»', '_'));
	}

	protected void computeSymbolName2(@NonNull SymbolNameBuilder sIn) {
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
			for (@NonNull Node node : getPartialNodes()) {
				if (node.isNew() || node.isChecked()) {
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
						int bestRealizedNavigationEdgesSize = 0;
						for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(bestNamingNode)) {
							if (edge.isRealized() && edge.isNavigation()) {
								bestRealizedNavigationEdgesSize++;
							}
						}
						int realizedNavigationEdgesSize = 0;
						for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
							if (edge.isRealized() && edge.isNavigation()) {
								realizedNavigationEdgesSize++;
							}
						}
						if (realizedNavigationEdgesSize > bestRealizedNavigationEdgesSize) {
							isBetter = true;
						}
						else if (realizedNavigationEdgesSize < bestRealizedNavigationEdgesSize) {
							isBetter = false;
						}
						else {
							int diff = ClassUtil.safeCompareTo(bestNamingNode.getClassDatum().getName(), node.getClassDatum().getName());
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
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(bestNamingNode)) {
				if (edge.isRealized() && edge.isNavigation()) {
					NavigationEdge navigationEdge = (NavigationEdge)edge;
					String name = navigationEdge.getEdgeName();
					edgeNames.add(name);
				}
			}
			if (edgeNames.size() > 0) {
				s = sIn;
				s.appendName(bestNamingNode.getClassDatum().getName());
				Collections.sort(edgeNames);
				for (@NonNull String edgeName : edgeNames) {
					s.appendString("_");
					s.appendString(edgeName);
				}
			}
			else {
				for (@NonNull Edge edge : getPartialEdges()) {
					if (edge.isNavigable()) {
						Role edgeRole = getRole(edge);
						assert edgeRole != null;
						if (edgeRole.isRealized()) {
							edgeNames.add(((NavigableEdge)edge).getEdgeName());
						}
					}
				}
				if (edgeNames.size() > 0) {
					s = sIn;
					s.appendName(bestNamingNode.getClassDatum().getName());
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
			s.appendName(bestNamingNode.getClassDatum().getName());
			List<@NonNull String> headNames = new ArrayList<>();
			for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(this)) {
				String name = headNode.getClassDatum().getName();
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
				s.appendName(headNode.getClassDatum().getName());
				List<@NonNull String> edgeNames = new ArrayList<>();
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(headNode)) {
					if (edge.isNavigation()) {
						NavigationEdge navigationEdge = (NavigationEdge)edge;
						String propertyName = navigationEdge.getEdgeName();
						edgeNames.add(navigationEdge.getEdgeTarget().isNullLiteral() ? propertyName + "0" : propertyName);
					}
				}
				Collections.sort(edgeNames);
				for (@NonNull String edgeName : edgeNames) {
					s.appendString("_");
					s.appendName(edgeName);
				}
				break;
			}
		}
	}

	private @NonNull Set<@NonNull Node> computeToOneSubRegion(@NonNull Set<@NonNull Node> toOneSubRegion, @NonNull Node atNode) {
		if (toOneSubRegion.add(atNode)) {
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(atNode)) {
				assert edge.getEdgeSource() == atNode;
				if (edge.isNavigation()) {
					NavigationEdge navigationEdge = (NavigationEdge)edge;
					Property source2target = QVTscheduleUtil.getReferredProperty(navigationEdge);
					if (!source2target.isIsMany() && !source2target.isIsImplicit()) {
						computeToOneSubRegion(toOneSubRegion, navigationEdge.getEdgeTarget());
					}
				}
				else {
					// SharedEdge
				}
			}
		}
		return toOneSubRegion;
	}

	@Override
	public @NonNull String getColor() {
		return QVTscheduleConstants.REGION_COLOR;
	}

	@Override
	public int getFirstPass() {
		List<@NonNull Integer> passes2 = ClassUtil.nullFree(getPasses());
		int size = passes2.size();
		assert size > 0;
		return passes2.get(0);
	}

	@Override
	public final @NonNull String getGraphName() {
		return getName();
	}

	@Override
	public List<Node> getHeadNodes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getIncomingPassedConnections() {		// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(this)) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if (connection != null) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public int getLastPass() {
		List<@NonNull Integer> passes2 = ClassUtil.nullFree(getPasses());
		assert passes2.size() > 0;
		return passes2.get(passes2.size()-1);
	}

	@Override
	public @NonNull String getName() {
		return ClassUtil.nonNullState(name);
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull String getPassRangeText() {
		return getFirstPass() + ".." + getLastPass();
	}

	@Override
	public @Nullable String getPassesText() {
		StringBuilder s = null;
		for (@NonNull Integer pass : ClassUtil.nullFree(getPasses())) {
			if (s == null) {
				s = new StringBuilder();
			}
			else {
				s.append(",");
			}
			s.append(pass.toString());
		}
		return s != null ? s.toString() : null;
	}

	@Override
	public @Nullable Role getRole(@NonNull Edge edge) {
		if (QVTscheduleUtil.getOwningRegion(QVTscheduleUtil.getTargetNode(edge)) != getRegion()) {
			return null;
		}
		else {
			return edge.getEdgeRole();
		}
	}

	@Override
	public @Nullable Role getRole(@NonNull Node node) {
		if (QVTscheduleUtil.getOwningRegion(node) != getRegion()) {
			return null;
		}
		else {
			return node.getNodeRole();
		}
	}

	@Override
	public final @NonNull String getSymbolName() {
		String symbolName2 = symbolName;
		if (symbolName2 == null) {
			SymbolNameBuilder s1 = new SymbolNameBuilder(0);			// No limit
			SymbolNameBuilder s2 = new SymbolNameBuilder(50);			// 50 character inner limit
			computeSymbolName(s2);
			s1.appendString(getSymbolNamePrefix());
			s1.appendString(s2.toString());
			//			s1.appendString(String.valueOf(getSymbolNameSuffix()));
			ScheduleModel scheduleModel = QVTscheduleUtil.basicGetContainingScheduleModel(QVTscheduleUtil.getRegion(this));
			if (scheduleModel != null) {
				symbolName2 = scheduleModel.reserveSymbolName(s1, this);
				//				System.out.println("Reserved '" + symbolName2 + "' for " + this);
			}
			else {
				symbolName2 = s1.toString();
				QVTruntimeUtil.errPrintln("Failed to reserve '" + symbolName2 + "' for " + this);
			}
			symbolName = symbolName2;
			//			if ((symbolName != null) && symbolName.contains("mTmapIfExp__DmapOclExpression_d2qvtrExpression_glob")) {
			//				getClass().toString();
			//			}
		}
		return symbolName2;
	}

	protected @NonNull String getSymbolNamePrefix() {
		return QVTscheduleConstants.REGION_SYMBOL_NAME_PREFIX;
	}

	protected String getSymbolNameSuffix() {
		return QVTscheduleConstants.REGION_SYMBOL_NAME_SUFFIX;
	}

	@Override
	public boolean isHead(@NonNull ConnectionEnd connectionEnd) {
		return Iterables.contains(getHeadNodes(), connectionEnd);
	}

	@Override
	public void setPass(int pass) {
		assert ClassUtil.nullFree(getPasses()).isEmpty();
		addPass(pass);
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		AbstractToGraphVisitor visitor = ToGraphPartitionVisitor.createVisitor(s, true);
		visitor.visit((Graphable)this);
	}

	@Override
	public @NonNull String toString() {
		return ClassUtil.nonNullState(name);
	}
} //PartitionImpl
