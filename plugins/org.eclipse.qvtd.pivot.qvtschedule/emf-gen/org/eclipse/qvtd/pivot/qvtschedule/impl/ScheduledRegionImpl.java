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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduled Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ScheduledRegionImpl extends RegionImpl implements ScheduledRegion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScheduledRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.SCHEDULED_REGION;
	}

	protected ScheduledRegionImpl(@NonNull String name, @NonNull Region primaryRegion) {
		super(primaryRegion.getMultiRegion());
		this.name = name;
	}

	private String name;

	/**
	 * All regions within this scheduled region.
	 */
	private final @NonNull List<@NonNull Region> regions = new ArrayList<>();

	/**
	 * All the connections defined in this region, but not those in nested regions.
	 */
	private @NonNull List<@NonNull Connection> connections = new ArrayList<>();

	/**
	 * The per-class node connections that unite a set of sources via a shared connection.
	 */
	private final @NonNull Map<@NonNull ClassDatumAnalysis, @NonNull Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection>> classDatumAnalysis2nodes2nodeConnections = new HashMap<>();

	/**
	 * The edge connections that unite a set of sources via a shared connection.
	 */
	private final @NonNull Map<@NonNull Set<@NonNull NavigableEdge>, @NonNull EdgeConnection> edges2edgeConnection = new HashMap<>();

	@Override
	public void addEdgeConnection(@NonNull EdgeConnection edgeConnection) {
		assert !connections.contains(edgeConnection);
		//		for (Connection oldConnection : connections) {
		//			if (oldConnection.getConnectionRole() == connection.getConnectionRole()) {
		//				assert (edge.getSource() != oldConnection.getSource()) || (edge.getTarget() != oldConnection.getTarget());
		//			}
		//		}
		connections.add(edgeConnection);
	}

	@Override
	public void addNodeConnection(@NonNull NodeConnection nodeConnection) {
		assert !connections.contains(nodeConnection);
		//		for (Connection oldConnection : connections) {
		//			if (oldConnection.getConnectionRole() == connection.getConnectionRole()) {
		//				assert (edge.getSource() != oldConnection.getSource()) || (edge.getTarget() != oldConnection.getTarget());
		//			}
		//		}
		connections.add(nodeConnection);
	}

	@Override
	public void addRegion(@NonNull Region region) {
		assert !regions.contains(region);
		if (regions.add(region)) {
			region.setInvokingRegion(this);
			//			allMappingRegions.addAll(nestedRegion.getAllMappingRegions());
		}
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendName(name);
		return s;
	}

	@Override
	public @NonNull NodeConnection getAttributeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull CompleteClass owningClass, @NonNull Property property, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection> nodes2connection = classDatumAnalysis2nodes2nodeConnections.get(classDatumAnalysis);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<>();
			classDatumAnalysis2nodes2nodeConnections.put(classDatumAnalysis, nodes2connection);
		}
		Set<@NonNull Node> sourceSet = Sets.newHashSet(sourceNodes);
		NodeConnection connection = nodes2connection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString("ja_");
			s.appendName(owningClass.getName());
			s.appendString("_");
			s.appendName(property.getName());
			connection = new NodeConnectionImpl(this, sourceSet, s, classDatumAnalysis);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableRegions() {
		return Iterables.filter(getRegions(), QVTscheduleUtil.IsCallableRegionPredicate.INSTANCE);
	}

	@Override
	public @NonNull Collection<@NonNull Connection> getConnections() {
		return connections;
	}

	@Override
	public @NonNull EdgeConnection getEdgeConnection(@NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull Property property) {
		Set<@NonNull NavigableEdge> sourceSet = Sets.newHashSet(sourceEdges);
		EdgeConnection connection = edges2edgeConnection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString("je_");
			s.appendName(property.getOwningClass().getName());
			s.appendString("_");
			s.appendName(property.getName());
			connection = new EdgeConnectionImpl(this, sourceSet, s, property);
			edges2edgeConnection.put(sourceSet, connection);
		}
		return connection;
	}

	@Override
	public @NonNull Iterable<EdgeConnection> getEdgeConnections() {
		return Iterables.filter(connections, EdgeConnection.class);
	}

	@Override
	public @NonNull List<@NonNull Node> getHeadNodes() {
		return QVTscheduleConstants.EMPTY_NODE_LIST;
	}

	@Override
	public @NonNull NodeConnection getNodeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection> nodes2connection = classDatumAnalysis2nodes2nodeConnections.get(classDatumAnalysis);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<>();
			classDatumAnalysis2nodes2nodeConnections.put(classDatumAnalysis, nodes2connection);
		}
		Set<@NonNull Node> sourceSet = Sets.newHashSet(sourceNodes);
		NodeConnection connection = nodes2connection.get(sourceSet);
		if (connection == null) {
			DomainUsage domainUsage = classDatumAnalysis.getDomainUsage();
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString("j");
			s.appendString(domainUsage.isInput() ? "i" : domainUsage.isOutput() ? "o" : "m");
			s.appendString("_");
			s.appendName(classDatumAnalysis.getCompleteClass().getName());
			connection = new NodeConnectionImpl(this, sourceSet, s, classDatumAnalysis);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getNodeConnections() {
		return Iterables.filter(connections, NodeConnection.class);
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @Nullable Region getNormalizedRegion(@NonNull Region region) {
		if (region == this) {
			return null;
		}
		for (Region invokingRegion; (invokingRegion = region.getInvokingRegion()) != null; ) {
			if (invokingRegion == this) {
				return region;
			}
			region = invokingRegion;
		}
		return null;
	}

	@Override
	public @NonNull List<@NonNull Region> getRegions() {
		return regions;
	}

	@Override
	protected @NonNull String getSymbolNamePrefix() {
		return "s_";
	}

	@Override
	public void removeConnection(@NonNull Connection connection) {
		boolean wasRemoved = connections.remove(connection);
		assert wasRemoved;
		if (connection instanceof NodeConnection) {
			NodeConnection nodeConnection = (NodeConnection)connection;
			for (@NonNull Node targetNode : nodeConnection.getTargetNodes()) {
				targetNode.removeIncomingConnection(nodeConnection);
			}
			for (@NonNull Node sourceNode : nodeConnection.getSources()) {
				sourceNode.removeOutgoingConnection(nodeConnection);
			}
		}
		else if (connection instanceof EdgeConnection) {
			EdgeConnection edgeConnection = (EdgeConnection)connection;
			for (@NonNull NavigableEdge targetEdge : edgeConnection.getTargetEdges()) {
				targetEdge.removeIncomingConnection(edgeConnection);
			}
			for (@NonNull NavigableEdge sourceEdge : edgeConnection.getSources()) {
				sourceEdge.removeOutgoingConnection(edgeConnection);
			}
		}
	}

	@Override
	public void removeRegion(@NonNull Region region) {
		regions.remove(region);
	}

	@Override
	public void replaceSources(@NonNull NodeConnection connection, @NonNull Set<@NonNull Node> obsoleteSourceNodes, @NonNull Node newSourceNode) {
		ClassDatumAnalysis classDatumAnalysis = connection.getClassDatumAnalysis();
		Map<@NonNull Set<@NonNull Node>, NodeConnection> nodes2connections = classDatumAnalysis2nodes2nodeConnections.get(classDatumAnalysis);
		assert nodes2connections != null;
		Set<@NonNull Node> newSourceNodes = new HashSet<>();
		Iterables.addAll(newSourceNodes, connection.getSources());
		NodeConnection oldConnection = nodes2connections.remove(newSourceNodes);
		assert oldConnection == connection;
		newSourceNodes.removeAll(obsoleteSourceNodes);
		newSourceNodes.add(newSourceNode);
		NodeConnection newConnection = getNodeConnection(newSourceNodes, classDatumAnalysis);
		for (@NonNull Node targetNode : connection.getTargetNodes()) {
			ConnectionRole connectionRole = connection.getConnectionRole(targetNode);
			if (connectionRole.isPassed()) {
				newConnection.addPassedTargetNode(targetNode);
			}
			else {
				newConnection.addUsedTargetNode(targetNode, false);			// FIXME mandatory
			}
		}
		removeConnection(connection);
	}


	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Region region : getCallableRegions()) {
			region.toCallGraph(s);
		}
		for (@NonNull Connection connection : getConnections()) {
			connection.toRegionGraph(this, s);
		}
		s.popCluster();
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Region region : getRegions()) {
			region.toGraph(s);
		}
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
			s.appendNode(node);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getEdges(this)) {
			s.appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		}
		for (@NonNull Connection connection : getConnections()) {
			connection.toGraph(s);
		}
		s.popCluster();
	}

	/**
	 * After cycles have been removed, split looped connection variables to isolate the unlooping base case, from the/each looping case.
	 *
	protected void splitConnectionVariables() {
		for (@NonNull NodeConnection connection : getNodeConnections()) { //Lists.newArrayList(getNodeConnections())) {
			if (connection.isPassed()) {
				Set<@NonNull Region> loopRegions = null;
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					if (!sourceRegion.isChildCompositionRegion()) {
						for (@NonNull Region targetRegion : connection.getTargetRegions()) {
							if (sourceRegion == targetRegion) {
								if (loopRegions == null) {
									loopRegions = new HashSet<>();
								}
								loopRegions.add(sourceRegion);
							}
						}
					}
				}
				if (loopRegions != null) {
					ClassDatumAnalysis classDatumAnalysis = connection.getClassDatumAnalysis();
					List<@NonNull Node> allSourceNodes = new ArrayList<>();
					Iterables.addAll(allSourceNodes, connection.getSources());
					for (@NonNull Region loopRegion : loopRegions) {
						Node sourceNode = connection.getSource(loopRegion);
						Node targetNode = connection.getTarget(loopRegion);
						targetNode.removeIncomingConnection(connection);
						connection.removeTarget(targetNode);
						Set<@NonNull Node> selectedSourceNodes = new HashSet<>(allSourceNodes);
						selectedSourceNodes.remove(sourceNode);
						NodeConnection loopConection = getNodeConnection(selectedSourceNodes, classDatumAnalysis);
						loopConection.addPassedTargetNode(targetNode);
						RegionUtil.createRecursionEdge(sourceNode, targetNode, true);
					}
				}
			}
		}
	} */

	@Override
	public void toRegionGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Region region : getCallableRegions()) {
			//			region.toRegionGraph(s);
			s.appendNode(region);
			//			for (@SuppressWarnings("null")@NonNull Edge edge : region.getRecursionEdges()) {
			//				s.appendEdge(edge.getSource().getRegion(), edge, edge.getTarget().getRegion());
			//			}
		}
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
			s.appendNode(node);
		}
		for (@NonNull Connection connection : getConnections()) {
			connection.toRegionGraph(this, s);
		}
		s.popCluster();
	}

	@Override
	public void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph) {
		SchedulerConstants scheduler = getSchedulerConstants();
		if (doNodesGraph) {
			writeDebugGraphs(context);
		}
		if (doRegionGraph) {
			String suffix = "-r-" + context;
			scheduler.writeRegionDOTfile(this, suffix);
			scheduler.writeRegionGraphMLfile(this, suffix);
		}
		if (doCallGraph) {
			String suffix = "-c-" + context;
			scheduler.writeCallDOTfile(this, suffix);
			scheduler.writeCallGraphMLfile(this, suffix);
		}
	}


} //ScheduledRegionImpl
