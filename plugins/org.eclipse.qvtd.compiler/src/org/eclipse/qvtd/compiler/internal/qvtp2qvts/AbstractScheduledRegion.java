/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public abstract class AbstractScheduledRegion extends AbstractRegion implements ScheduledRegion
{
	/**
	 * All regions within this scheduled region.
	 */
	private final @NonNull List<@NonNull Region> regions = new ArrayList<@NonNull Region>();

	/**
	 * All the connections defined in this region, but not those in nested regions.
	 */
	private @NonNull List<@NonNull Connection> connections = new ArrayList<@NonNull Connection>();

	/**
	 * The per-class node connections that unite a set of sources via a shared connection.
	 */
	private final @NonNull Map<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection>> classDatumAnalysis2nodes2nodeConnections = new HashMap<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis, @NonNull Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection>>();

	/**
	 * The edge connections that unite a set of sources via a shared connection.
	 */
	private final @NonNull Map<@NonNull Set<@NonNull NavigableEdge>, @NonNull EdgeConnection> edges2edgeConnection = new HashMap<@NonNull Set<@NonNull NavigableEdge>, @NonNull EdgeConnection>();

	public AbstractScheduledRegion(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

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

	public void addRegion(@NonNull Region region) {
		assert !regions.contains(region);
		if (regions.add(region)) {
			region.setInvokingRegion(this);
			//			allMappingRegions.addAll(nestedRegion.getAllMappingRegions());
		}
	}

	@Override
	public  @NonNull CyclicScheduledRegion createCyclicScheduledRegion(@NonNull Iterable<@NonNull Region> cycle) {
		for (@NonNull Region region : cycle) {
			removeRegion(region);
		}
		CyclicScheduledRegion cyclicRegion = new CyclicScheduledRegion(this, cycle);
		addRegion(cyclicRegion);
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			cyclicRegion.writeDebugGraphs("3-cycle");
		}
		return cyclicRegion;
	}

	@Override
	public void createLocalSchedule() {
		//
		//	Partition single region recursive connections into base cases recursive case connections with associated region recursions.
		//
		splitConnectionVariables();
		//
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			writeDebugGraphs("5-cycled", true, true, false);
		}
	}

	@Override
	public void createLocalSchedule2(@NonNull List<@NonNull Region> orderedRegions) {
		//		region2order.computeRegionIndexes(getCallableRegions());
		//		Iterable<Region> sortedCallableRegions = regionOrdering;//AbstractRegion.EarliestRegionComparator.sort(getCallableRegions());
		//
		//	Index all predicated and realized edges by typed model and property.
		//
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges = new HashMap<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>>();
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges = new HashMap<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>>();
		for (@NonNull Region region : orderedRegions) {
			QVTs2QVTiVisitor.POLLED_PROPERTIES.println("building indexes for " + region + " " + region.getIndexRangeText());
			region.buildPredicatedNavigationEdgesIndex(typedModel2property2predicatedEdges);
			region.buildRealizedNavigationEdgesIndex(typedModel2property2realizedEdges);
		}
		//
		//	Eliminate dependencies that are satisfied by the linear invocation indexes.
		//
		for (@NonNull Region region : orderedRegions) {
			//			int earliestPassedConnectionSourceIndex = region.getEarliestPassedConnectionSourceIndex();
			int earliestIndex = region.getIndexes().get(0);
			List<@NonNull DatumConnection> redundantConnections = null;
			for (@NonNull DatumConnection usedConnection : region.getIncomingConnections()) {
				if (!usedConnection.isPassed(region)) {
					boolean isRedundant = true;
					for (@NonNull Region sourceRegion : usedConnection.getSourceRegions()) {
						List<@NonNull Integer> indexes = sourceRegion.getIndexes();
						int lastIndex = indexes.get(indexes.size()-1);
						if (lastIndex >= earliestIndex) {
							isRedundant = false;
							break;
						}
					}
					if (isRedundant) {
						if (redundantConnections == null) {
							redundantConnections = new ArrayList<>();
						}
						redundantConnections.add(usedConnection);
					}
				}
			}
			if (redundantConnections != null) {
				for (@NonNull DatumConnection redundantConnection : redundantConnections) {
					redundantConnection.removeTargetRegion(region);
				}
			}
		}
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			writeDebugGraphs("7-pruned", true, true, false);
		}

		for (@NonNull Region region : orderedRegions) {
			region.computeCheckedOrEnforcedEdges(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}
		/*	suspended - just an optimization - needs more hierarchical consideration
		//
		//	Redirect ordered consumers to depend on each other's heads thereby respecting the ordering and
		//	making earlier results available to later mappings.
		//
		if (region2orderingEdge2usedEdges != null) {
			for (@SuppressWarnings("null")@NonNull Region commonRegion : region2orderingEdge2usedEdges.keySet()) {
				@SuppressWarnings("null")@NonNull Map<Edge, Set<Edge>> orderingEdge2usedEdges = region2orderingEdge2usedEdges.get(commonRegion);
				convertConsumedOrdering(commonRegion, orderingEdge2usedEdges);
			}
		}
		writeDOTfile("-5-reconsume");
		writeGraphMLfile("-5-reconsume"); */
		/*	suspended - just an optimization - needs more hierarchical consideration
		//
		//	Merge again now that dependencies may be available.
		//
		Region2Depth region2depths = new Region2Depth();
		List<Region> sortedRegions = region2depths.getSortedRegions(getRegions());
		for (Region calledRegion : sortedRegions) {
			List<List<Node>> headNodeGroups = calledRegion.getHeadNodeGroups();
			if ((headNodeGroups.size() == 1) && !(calledRegion instanceof CompositionRegion)) {
				Region callingRegion = null;
				boolean isMergeable = true;
				for (Node headNode : headNodeGroups.get(0)) {
					for (Node callingNode : headNode.getPassedBindingSources()) {
						if (callingRegion == null) {
							callingRegion = callingNode.getRegion();
						}
						else if (callingRegion != callingNode.getRegion()) {
							isMergeable = false;
							break;
						}
					}
				}
				if ((callingRegion != null) && isMergeable && callingRegion.isLateMergeable(calledRegion, region2depths)) {
					Map<Node, Node> node2mergedNode = callingRegion.canMerge(calledRegion, region2depths, true);
					if (node2mergedNode != null) {
						MergedRegion mergedRegion;
						if (callingRegion instanceof MergedRegion) {
							mergedRegion = (MergedRegion)callingRegion;
						}
						else {
							getRegions().remove(calledRegion);
							mergedRegion = new MergedRegion((MergeableRegion)callingRegion);
							Region invokingRegion = callingRegion.getInvokingRegion();
							assert invokingRegion != null;
							List<Region> regions = invokingRegion.getRegions();
							int index = regions.indexOf(callingRegion);
							assert index >= 0;
							regions.set(index, mergedRegion);
//							mergedRegion.writeDOTfile("-6-merged");
//							mergedRegion.writeGraphMLfile("-6-merged");
						}
						mergedRegion.mergeRegion(calledRegion, node2mergedNode);
						getRegions().remove(calledRegion);
						mergedRegion.writeDOTfile("-6-merged");
						mergedRegion.writeGraphMLfile("-6-merged");
						mergedRegion.resolveRecursion();
						mergedRegion.writeDOTfile("-7-merged");
						mergedRegion.writeGraphMLfile("-7-merged");
						region2depths.addRegion(mergedRegion);
					}
				}
			}
		} */
		//
		//	Propagate early results down to later mappings that need them.
		//
		/*		for (Region calledRegion : sortedRegions) {
			calledRegion.refineBindings(this);
		} */
		/*		HashMap<Node, List<Node>> outerNode2outerNodes = new HashMap<Node, List<Node>>();
		Map<Region, Map<NavigationEdge, NavigationEdge>> region2innerEdge2outerEdge = new HashMap<Region, Map<NavigationEdge, NavigationEdge>>();
		propagateCommonNavigations(rootContainmentRegion, outerNode2outerNodes, region2innerEdge2outerEdge);
		for (@SuppressWarnings("null")@NonNull Map.Entry<Region, Map<NavigationEdge, NavigationEdge>> entry1 : region2innerEdge2outerEdge.entrySet()) {
			Region innerRegion = entry1.getKey();
			for (@SuppressWarnings("null")@NonNull NavigationEdge innerEdge : entry1.getValue().keySet()) {
				Node innerNode = innerEdge.getTarget();
				List<NavigationEdge> bestPath = null;
				for (@SuppressWarnings("null")@NonNull List<Node> headGroup : innerRegion.getHeadNodeGroups()) {
					for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						bestPath = getBestPath(bestPath, getPath(headNode, innerNode, new HashSet<Edge>()));
					}
				}
				assert bestPath != null;
				for (@SuppressWarnings("null")@NonNull Node node : innerRegion.getNodes()) {
					for (@SuppressWarnings("null")@NonNull Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
						assert edge.getTarget() == node;
						Region outerRegion = edge.getSource().getRegion();
						Map<Edge, Edge> innerEdge2outerEdge = createPath(edge.getSource(), bestPath);
						for (@SuppressWarnings("null")@NonNull Map.Entry<Edge, Edge> entry : innerEdge2outerEdge.entrySet()) {
							Edge outerEdge = entry.getValue();
							Edge innerEdge2 = entry.getKey();
							Edges.USED_BINDING.createEdge(outerRegion, outerEdge.getTarget(), innerEdge2.getName(), innerEdge2.getTarget());
						}
//						innerNode2outerNode.put(node, edge.getSource());
//						propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);




//						propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
					}
				}
			} */
		/*			Map<Node, Edge> innerNode2edge = new HashMap<Node, Edge>();
			Map<Node, Node> innerNode2outerNode = new HashMap<Node, Node>();
//			for (NavigationEdge innerEdge : entry1.getValue().keySet()) {
//				innerNode2edge.put(innerEdge.getSource(), innerEdge);
//			}
			for (Node node : innerRegion.getNodes()) {
				for (Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
					assert edge.getTarget() == node;

					Node outerNode = createPath(edge.getRegion(), bestEdge);

					innerNode2outerNode.put(node, edge.getSource());
					propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);




					propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
				}
			}
			for (Map.Entry<NavigationEdge, NavigationEdge> entry2 : entry1.getValue().entrySet()) {
				NavigationEdge innerEdge = entry2.getKey();
				NavigationEdge outerEdge = entry2.getValue();
				propagateEdge(outerEdge.getSource(), innerEdge.getSource());
				propagateEdge(outerEdge.getTarget(), innerEdge.getTarget());
			} */
		//		}
		//		firstPassRegion.writeDOTfile();
		//		firstPassRegion.writeGraphMLfile();
		//
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			writeDebugGraphs("9-final", true, true, true);
		}
	}

	@Override
	public @NonNull NodeConnection getAttributeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull CompleteClass owningClass, @NonNull Property property, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection> nodes2connection = classDatumAnalysis2nodes2nodeConnections.get(classDatumAnalysis);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<@NonNull Set<@NonNull Node>, @NonNull NodeConnection>();
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
			connection = new BasicNodeConnection(this, sourceSet, s, classDatumAnalysis);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableRegions() {
		return Iterables.filter(getRegions(), IsCallableRegionPredicate.INSTANCE);
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
			connection = new BasicEdgeConnection(this, sourceSet, s, property);
			edges2edgeConnection.put(sourceSet, connection);
		}
		return connection;
	}

	@Override
	public @NonNull Iterable<@NonNull EdgeConnection> getEdgeConnections() {
		return Iterables.filter(connections, EdgeConnection.class);
	}

	@Override
	public @NonNull NodeConnection getNodeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection> nodes2connection = classDatumAnalysis2nodes2nodeConnections.get(classDatumAnalysis);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<@NonNull Set<@NonNull Node>, @NonNull NodeConnection>();
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
			connection = new BasicNodeConnection(this, sourceSet, s, classDatumAnalysis);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getNodeConnections() {
		return Iterables.filter(connections, NodeConnection.class);
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

	protected void removeRegion(@NonNull Region region) {
		regions.remove(region);
	}

	@Override
	public void replaceSources(@NonNull NodeConnection connection, @NonNull Set<@NonNull Node> obsoleteSourceNodes, @NonNull Node newSourceNode) {
		ClassDatumAnalysis classDatumAnalysis = connection.getClassDatumAnalysis();
		Map<@NonNull Set<@NonNull Node>, NodeConnection> nodes2connections = classDatumAnalysis2nodes2nodeConnections.get(classDatumAnalysis);
		assert nodes2connections != null;
		Set<@NonNull Node> newSourceNodes = new HashSet<@NonNull Node>();
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


	/**
	 * After cycles have been removed, split looped connection variables to isolate the unlooping base case, from the/each looping case.
	 */
	protected void splitConnectionVariables() {
		for (@NonNull NodeConnection connection : getNodeConnections()) { //new ArrayList<NodeConnection>(getNodeConnections())) {
			if (connection.isPassed()) {
				Set<@NonNull Region> loopRegions = null;
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					if (!sourceRegion.isChildCompositionRegion()) {
						for (@NonNull Region targetRegion : connection.getTargetRegions()) {
							if (sourceRegion == targetRegion) {
								if (loopRegions == null) {
									loopRegions = new HashSet<@NonNull Region>();
								}
								loopRegions.add(sourceRegion);
							}
						}
					}
				}
				if (loopRegions != null) {
					ClassDatumAnalysis classDatumAnalysis = connection.getClassDatumAnalysis();
					List<Node> allSourceNodes = new ArrayList<Node>();
					Iterables.addAll(allSourceNodes, connection.getSources());
					for (@NonNull Region loopRegion : loopRegions) {
						Node sourceNode = connection.getSource(loopRegion);
						Node targetNode = connection.getTarget(loopRegion);
						targetNode.removeIncomingConnection(connection);
						connection.removeTarget(targetNode);
						Set<Node> selectedSourceNodes = new HashSet<Node>(allSourceNodes);
						selectedSourceNodes.remove(sourceNode);
						NodeConnection loopConection = getNodeConnection(selectedSourceNodes, classDatumAnalysis);
						loopConection.addPassedTargetNode(targetNode);
						RegionUtil.createRecursionEdge(sourceNode, targetNode, true);
					}
				}
			}
		}
	}

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
		for (@NonNull Node node : getNodes()) {
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
			scheduler.writeRegionDOTfile(this, "-r-" + context);
			scheduler.writeRegionGraphMLfile(this, "-r-" + context);
		}
		if (doCallGraph) {
			scheduler.writeCallDOTfile(this, "-c-" + context);
			scheduler.writeCallGraphMLfile(this, "-c-" + context);
		}
	}
}