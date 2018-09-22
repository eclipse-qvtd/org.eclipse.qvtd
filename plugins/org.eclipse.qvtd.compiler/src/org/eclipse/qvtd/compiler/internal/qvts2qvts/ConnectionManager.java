/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.LoadingRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartition;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.StaticConnectionManager;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * ConnectionManager supervises the connections initially between rule-regions and ultimaately between partitions.
 */
public class ConnectionManager // extends QVTimperativeHelper
{
	private static @NonNull StaticConnectionManager INSTANCE = new StaticConnectionManager() {
		{
			StaticConnectionManager.INSTANCE = this;
		}

		@Override
		public boolean rawIsUsed(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode) {
			return ConnectionManager.rawIsUsed(nodeConnection, targetNode);
		}

		@Override
		public boolean rawIsNode2Node(@NonNull NodeConnection nodeConnection) {
			return ConnectionManager.rawIsNode2Node(nodeConnection);
		}

		@Override
		public boolean rawIsEdge2Edge(@NonNull EdgeConnection edgeConnection) {
			return ConnectionManager.rawIsEdge2Edge(edgeConnection);
		}

		@Override
		public @NonNull Map<@NonNull Node, @NonNull ConnectionRole> rawGetTargets(@NonNull NodeConnection nodeConnection) {
			return (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)ConnectionManager.rawGetTargets(nodeConnection);
		}

		@Override
		public @NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> rawGetTargets(@NonNull Connection connection) {
			return ConnectionManager.rawGetTargets(connection);
		}

		@Override
		public @NonNull Iterable<@NonNull Node> rawGetTargetNodes(@NonNull NodeConnection nodeConnection) {
			return ConnectionManager.rawGetTargetNodes(nodeConnection);
		}

		@Override
		public @NonNull Iterable<@NonNull NavigableEdge> rawGetTargetEdges(@NonNull EdgeConnection edgeConnection) {
			return ConnectionManager.rawGetTargetEdges(edgeConnection);
		}

		@Override
		public @NonNull List<@NonNull NodeConnection> rawGetRootConnections(@NonNull Region region) {
			return ConnectionManager.rawGetRootConnections(region);
		}

		@Override
		public void rawDestroy(@NonNull NodeConnection nodeConnection) {
			ConnectionManager.rawDestroy(nodeConnection);
		}

		@Override
		public void rawDestroy(@NonNull EdgeConnection edgeConnection) {
			ConnectionManager.rawDestroy(edgeConnection);
		}

		@Override
		public @NonNull Iterable<@NonNull ConnectionEnd> rawGetSourceEnds(@NonNull Connection connection) {
			return ConnectionManager.rawGetSourceEnds(connection);
		}

		@Override
		public @NonNull Iterable<@NonNull NavigableEdge> rawGetSourceEnds(@NonNull EdgeConnection edgeConnection) {
			return ConnectionManager.rawGetSourceEnds(edgeConnection);
		}

		@Override
		public @NonNull Iterable<@NonNull Node> rawGetSourceEnds(@NonNull NodeConnection nodeConnection) {
			return ConnectionManager.rawGetSourceEnds(nodeConnection);
		}

		@Override
		public @NonNull Iterable<@NonNull Node> rawGetSourceNodes(@NonNull Connection connection) {
			return ConnectionManager.rawGetSourceNodes(connection);
		}

		@Override
		public boolean rawIsRegion2Region(@NonNull Connection connection, @NonNull Map<@NonNull Region, @NonNull Integer> sourceRegion2count,
				@NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles) {
			return ConnectionManager.rawIsRegion2Region(connection, sourceRegion2count, targetRegion2roles);
		}

		@Override
		public @NonNull Iterable<@NonNull Region> rawGetCallableChildren(@NonNull Region region) {
			return ConnectionManager.rawGetCallableChildren(region);
		}
	};

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull LoadingRegionAnalysis loadingRegionAnalysis;

	/**
	 * The per-class node connections that unite a set of sources via a shared connection.
	 */
	public final @NonNull Map<@NonNull ClassDatum, @NonNull Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection>> classDatum2nodes2nodeConnections = new HashMap<>();

	/**
	 * The edge connections that unite a set of sources via a shared connection.
	 */
	public final @NonNull Map<@NonNull Set<@NonNull NavigableEdge>, @NonNull EdgeConnection> edges2edgeConnection = new HashMap<>();

	/**
	 * Analysis of the contents of the partitioned mappings, null prior to partitioning.
	 */
	private @Nullable PartitionedContentsAnalysis partitionedContentsAnalysis = null;

	public ConnectionManager(@NonNull ProblemHandler problemHandler, @NonNull ScheduleManager scheduleManager, @NonNull LoadingRegionAnalysis loadingRegionAnalysis) {
		//	super(qvtm2qvts.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.loadingRegionAnalysis = loadingRegionAnalysis;
	}

	/**
	 * Create the Passed and Used Connections between all introducers and their corresponding consuming nodes.
	 */
	public void createConnections(@NonNull RootPartition rootPartition) {
		ScheduledRegion rootScheduledRegion = rootPartition.getScheduledRegion();
		List<@NonNull Region> sortedCallableRegions = new ArrayList<>();
		Iterables.addAll(sortedCallableRegions, rootScheduledRegion.getCallableRegions());
		Collections.sort(sortedCallableRegions, NameUtil.NAMEABLE_COMPARATOR);
		for (Region region : sortedCallableRegions) {
			createIncomingConnections(region);
		}
		scheduleManager.writeDebugGraphs("4-bindings", true, true, false);
		//		for (Region region : sortedCallableRegions) {
		//			region.checkIncomingConnections();
		//		}
	}

	/**
	 * Create an EdgeConnection for the predicatedEdge and/or its target node.
	 */
	private void createEdgeConnection(@NonNull Region region, @NonNull Node castTargetNode, @NonNull Iterable<@NonNull NavigableEdge> predicatedEdges) {
		ScheduledRegion invokingRegion2 = region.getContainingScheduledRegion();
		assert invokingRegion2 != null;
		Node castTarget = castTargetNode;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
		List<@NonNull Node> attributeConnectionSourceNodes = null;
		List<@NonNull String> partialNames = new ArrayList<>();
		for (@NonNull NavigableEdge predicatedEdge : predicatedEdges) {
			assert predicatedEdge.isNavigation();
			assert predicatedEdge.getIncomingConnection() == null;
			assert !predicatedEdge.isCast();
			Property predicatedProperty = predicatedEdge.getProperty();
			assert !predicatedProperty.isIsImplicit();
			NavigableEdge castEdge = QVTscheduleUtil.getCastTarget(predicatedEdge);
			if (classDatum.getCompleteClass().getPrimaryClass() instanceof DataType) {
				Iterable<@NonNull NavigableEdge> realizedEdges = getNewEdges(predicatedEdge, classDatum);
				if (realizedEdges != null) {
					if (attributeConnectionSourceNodes == null) {
						attributeConnectionSourceNodes = new ArrayList<>();
					}
					for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
						if (scheduleManager.isElementallyConformantSource(realizedEdge, predicatedEdge) && QVTscheduleUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
							attributeConnectionSourceNodes.add(realizedEdge.getEdgeTarget());
						}
					}
					partialNames.add(QVTscheduleUtil.getName(predicatedEdge.getEdgeSource().getCompleteClass()));
					partialNames.add(QVTscheduleUtil.getName(predicatedProperty));
				}
			}
			else {
				Iterable<@NonNull Node> sourceNodes = getNewNodes(classDatum);
				//			if (sourceNodes != null) {
				Iterable<@NonNull NavigableEdge> realizedEdges = getNewEdges(predicatedEdge, classDatum);
				if (realizedEdges != null) {
					Set<@NonNull Region> edgeSourceRegions = new HashSet<>();
					Set<@NonNull Region> nodeSourceRegions = new HashSet<>();
					for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
						edgeSourceRegions.add(QVTscheduleUtil.getOwningRegion(realizedEdge));
					}
					if (sourceNodes != null) {
						for (@NonNull Node sourceNode : sourceNodes) {
							nodeSourceRegions.add(QVTscheduleUtil.getOwningRegion(sourceNode));
						}
					}
					//
					// Create an EdgeConnection for the edge realizations unless all edges are sources by node sources.
					//
					if (!nodeSourceRegions.containsAll(edgeSourceRegions)) {	// If edges are assigned independently of their targets.
						Set<@NonNull Region> conformantEdgeSourceRegions = null;
						List<@NonNull NavigableEdge> thoseEdges = null;
						for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
							if (scheduleManager.isElementallyConformantSource(realizedEdge, predicatedEdge) && QVTscheduleUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
								if (thoseEdges == null) {
									thoseEdges = new ArrayList<>();
									conformantEdgeSourceRegions = new HashSet<>();
								}
								if (!thoseEdges.contains(realizedEdge)) {
									thoseEdges.add(realizedEdge);
									assert conformantEdgeSourceRegions != null;
									conformantEdgeSourceRegions.add(QVTscheduleUtil.getOwningRegion(realizedEdge));
								}
							}
						}
						if ((thoseEdges != null) && !nodeSourceRegions.containsAll(conformantEdgeSourceRegions)) {
							EdgeConnection edgeConnection = getEdgeConnection(invokingRegion2, thoseEdges, predicatedProperty);
							if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
								QVTscheduleConstants.CONNECTION_CREATION.println("  EdgeConnection \"" + edgeConnection + "\" to " + predicatedEdge);
							}
							if (!Iterables.contains(rawGetTargetEdges(edgeConnection), castEdge)) {
								rawAddUsedTargetEdge(edgeConnection, castEdge, false);
								if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
									for (@NonNull NavigableEdge thatEdge : thoseEdges) {
										QVTscheduleConstants.CONNECTION_CREATION.println("    from " + thatEdge.getOwningRegion() + "  : " + thatEdge);
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
						&& (castTarget.getIncomingConnection() == null)
						//			 && !castTarget.isAttributeNode()
						//			 && !rootScheduledRegion.isOnlyCastOrRecursed(predicatedNode)
						//			 && !hasEdgeConnection(predicatedNode)
						) {
					NodeConnection predicatedConnection = getNodeConnection(invokingRegion2, sourceNodes, classDatum, scheduleManager.getDomainUsage(classDatum));
					rawAddUsedTargetNode(predicatedConnection, castTarget, false);
					if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
						QVTscheduleConstants.CONNECTION_CREATION.println("  NodeConnection \"" + predicatedConnection + "\" to " + castTarget);
						for (@NonNull Node sourceNode : sourceNodes) {
							QVTscheduleConstants.CONNECTION_CREATION.println("    from " + sourceNode.getOwningRegion() + " : " + sourceNode);
						}
					}
				}
				//			}
			}
		}
		if (attributeConnectionSourceNodes != null) {
			NodeConnection nodeConnection = getAttributeConnection(invokingRegion2, attributeConnectionSourceNodes, partialNames, classDatum);
			rawAddUsedTargetNode(nodeConnection, castTarget, false);
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

	private @NonNull EdgeConnection createEdgeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull  Set<@NonNull NavigableEdge> sourceSet, @NonNull Property property, @NonNull SymbolNameBuilder s) {
		assert !property.isIsImplicit();
		EdgeConnection connection = QVTscheduleFactory.eINSTANCE.createEdgeConnection();

		//		protected ConnectionImpl(@NonNull ScheduledRegion region, @NonNull Set<@NonNull CE> sourceEnds, @NonNull String name) {
		connection.setOwningScheduledRegion(scheduledRegion);
		connection.setName(scheduleManager.getScheduleModel().reserveSymbolName(s, connection));
		rawGetSourceEnds(connection).addAll(sourceSet);
		//		}

		//		public EdgeConnectionImpl(@NonNull ScheduledRegion region, @NonNull Set<@NonNull NavigableEdge> sourceEdges, @NonNull String name, @NonNull Property property) {
		//			super(region, sourceEdges, name);
		connection.setReferredProperty(property);
		for (@NonNull NavigableEdge sourceEdge : sourceSet) {
			sourceEdge.addOutgoingConnection(connection);
		}
		//		}
		//		return new EdgeConnectionImpl(this, sourceSet, s, property);
		return connection;
	}

	/**
	 * Create and return a NodeConnection to the nodes that can provide the sources for headNode.
	 * Returns null if the pattern surrounding the headNode conflicts with the pattern
	 * surrounding all possible sources.
	 */
	private @Nullable NodeConnection createHeadConnection(@NonNull Region region, @NonNull Node headNode) {
		ScheduledRegion invokingRegion2 = QVTscheduleUtil.getContainingScheduledRegion(region);
		List<@NonNull Node> headSources = null;
		//
		//	Locate compatible introducers and non-recursive producers
		//
		boolean isSpeculation = false;
		Iterable<@NonNull Node> sourceNodes = getIntroducingOrNewNodes(headNode);
		if (!scheduleManager.useActivators() && (sourceNodes != null)) {
			for (@NonNull Node sourceNode : sourceNodes) {
				if (sourceNode.isSpeculation()) {
					isSpeculation = true;
				}
			}
		}
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(headNode);
		if (isSpeculation && !headNode.isSpeculated()) {
			sourceNodes = getPartitionedContentsAnalysis().getOldNodes(classDatum);
			assert sourceNodes != null;
		}
		if (sourceNodes != null) {
			for (@NonNull Node sourceNode : sourceNodes) {
				boolean isSource = true;
				if (isSpeculation) {
					if (headNode.isSpeculated()) {
						//						if (!sourceNode.isOld()) {
						//							isSource = false;
						//						}
					}
					else {
						if (!sourceNode.isSpeculated() || !sourceNode.isHead()) {
							isSource = false;
						}
					}
				}
				//				Region sourceRegion = sourceNode.getRegion();
				//				if (sourceRegion != this) {
				if (isSource) {
					Map<@NonNull Node, @NonNull Node> called2calling = new HashMap<>();
					if (isCompatiblePattern(region, headNode, sourceNode, called2calling)) {
						if (headSources == null) {
							headSources = new ArrayList<>();
						}
						headSources.add(sourceNode);
					}
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
		NodeConnection headConnection = getNodeConnection(invokingRegion2, headSources, classDatum, scheduleManager.getDomainUsage(classDatum));
		if (headNode.isDependency()) {
			rawAddUsedTargetNode(headConnection, headNode, false);
		}
		else {
			rawAddPassedTargetNode(headConnection, headNode);
		}
		if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
			QVTscheduleConstants.CONNECTION_CREATION.println((headNode.isDependency() ? "  Extra NodeConnection " : "  Head NodeConnection \"") + headConnection + "\" to " + headNode);
			for (@NonNull Node sourceNode : headSources) {
				QVTscheduleConstants.CONNECTION_CREATION.println("    from " + sourceNode.getOwningRegion() + " : " + sourceNode);
			}
		}
		return headConnection;
	}

	/**
	 * Return the Connections to each of the head nodes. Returns null if the pattern surrounding any headNode conflicts with the pattern
	 * surrounding all its possible sources. (Any head with no sources is a non-invocation.)
	 */
	private @Nullable Iterable<@NonNull NodeConnection> createHeadConnections(@NonNull Region region) {
		List<@NonNull NodeConnection> headConnections = null;
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
			if (headNode.isDependency()) {
				createHeadConnection(region, headNode);	/** Dependency nodes have extra not-head connections. */
			}
			else {
				NodeConnection headConnection = createHeadConnection(region, headNode);
				if (headConnection == null) {
					scheduleManager.addRegionWarning(region, "No incoming connections for " + headNode.getName());
					headConnection = createHeadConnection(region, headNode);	// FIXME debugging
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
	private void createIncomingConnections(@NonNull Region region) {
		if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
			QVTscheduleConstants.CONNECTION_CREATION.println("connecting " + region);
		}
		assert !(this instanceof LoadingRegion);
		Iterable<@NonNull NodeConnection> headConnections = createHeadConnections(region);
		if (headConnections != null) {
			//
			//	Gather multiple edges sharing the same target to avoid multiple incoming connections
			//
			Map<@NonNull Node, @NonNull List<@NonNull NavigableEdge>> castTargetNode2predicatedEdges = new HashMap<>();
			for (@NonNull NavigationEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
				assert !predicatedEdge.isCast();
				assert predicatedEdge.isNavigation();
				assert predicatedEdge.getIncomingConnection() == null;
				Property predicatedProperty = predicatedEdge.getReferredProperty();
				if (!predicatedProperty.isIsImplicit()) {		// unnavigable opposites are handled by the navigable property
					NavigableEdge castEdge = QVTscheduleUtil.getCastTarget(predicatedEdge);
					Node castTargetNode = QVTscheduleUtil.getCastTarget(castEdge.getEdgeTarget());
					List<@NonNull NavigableEdge> predicatedEdges = castTargetNode2predicatedEdges.get(castTargetNode);
					if (predicatedEdges == null) {
						predicatedEdges = new ArrayList<>();
						castTargetNode2predicatedEdges.put(castTargetNode, predicatedEdges);
					}
					predicatedEdges.add(predicatedEdge);
				}
			}
			for (@NonNull Node castTargetNode : castTargetNode2predicatedEdges.keySet()) {
				List<@NonNull NavigableEdge> predicatedEdges = castTargetNode2predicatedEdges.get(castTargetNode);
				assert predicatedEdges != null;
				createEdgeConnection(region, castTargetNode, predicatedEdges);
			}
		}
	}

	private @NonNull NodeConnection createNodeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Set<@NonNull Node> sourceSet, @NonNull ClassDatum classDatum, @NonNull SymbolNameBuilder s) {
		NodeConnection connection = QVTscheduleFactory.eINSTANCE.createNodeConnection();
		connection.setOwningScheduledRegion(scheduledRegion);
		rawGetSourceEnds(connection).addAll(sourceSet);
		connection.setName(scheduleManager.getScheduleModel().reserveSymbolName(s, connection));
		connection.setClassDatum(classDatum);
		for (@NonNull Node sourceNode : sourceSet) {
			//			assert !sourceNode.isConstant();
			sourceNode.addOutgoingConnection(connection);
		}
		return connection;
	}

	private @NonNull NodeConnection getAttributeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<@NonNull Node> sourceNodes, @NonNull List<@NonNull String> partialNames, @NonNull ClassDatum classDatum) {
		Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection> nodes2connection = classDatum2nodes2nodeConnections.get(classDatum);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<>();
			classDatum2nodes2nodeConnections.put(classDatum, nodes2connection);
		}
		Set<@NonNull Node> sourceSet = Sets.newHashSet(sourceNodes);
		NodeConnection connection = nodes2connection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString("ja");
			for (@NonNull String partialName : partialNames) {
				s.appendString("_");
				s.appendName(partialName);
			}
			connection = createNodeConnection(scheduledRegion, sourceSet, classDatum, s);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	private @NonNull EdgeConnection getEdgeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull Property property) {
		Set<@NonNull NavigableEdge> sourceSet = Sets.newHashSet(sourceEdges);
		EdgeConnection connection = edges2edgeConnection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString("je_");
			s.appendName(property.getOwningClass().getName());
			s.appendString("_");
			s.appendName(property.getName());
			connection = createEdgeConnection(scheduledRegion, sourceSet, property, s);
			edges2edgeConnection.put(sourceSet, connection);
		}
		return connection;
	}

	private @Nullable Iterable<@NonNull Node> getIntroducingOrNewNodes(@NonNull Node headNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(headNode);
		PartitionedContentsAnalysis partitionedContentsAnalysis = getPartitionedContentsAnalysis();
		if (!scheduleManager.getDomainUsage(classDatum).isInput()) {
			return partitionedContentsAnalysis.getNewNodes(classDatum);	// FIXME also dependsOn ??
		}
		List<@NonNull Node> nodes = new ArrayList<>();
		nodes.add(loadingRegionAnalysis.getIntroducerNode(headNode));
		for (@NonNull TypedModel dependsOn : QVTbaseUtil.getDependsOns(QVTscheduleUtil.getTypedModel(classDatum))) {
			ClassDatum classDatum2 = scheduleManager.getClassDatum(dependsOn, headNode.getCompleteClass().getPrimaryClass());
			Iterable<@NonNull Node> newNodes = partitionedContentsAnalysis.getNewNodes(classDatum2);
			if (newNodes != null) {
				for (@NonNull Node newNode : newNodes) {
					if (!nodes.contains(newNode)) {
						nodes.add(newNode);
					}
				}
			}
		}
		return nodes;
	}

	private @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum requiredClassDatum) {
		return getPartitionedContentsAnalysis().getNewEdges(edge, requiredClassDatum);
	}

	private @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatum classDatum) {
		return getPartitionedContentsAnalysis().getNewNodes(classDatum);
	}

	private @NonNull NodeConnection getNodeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<@NonNull Node> sourceNodes, @NonNull ClassDatum classDatum, @NonNull DomainUsage domainUsage) {
		Map<@NonNull Set<@NonNull Node>, @NonNull NodeConnection> nodes2connection = classDatum2nodes2nodeConnections.get(classDatum);
		if (nodes2connection == null) {
			nodes2connection = new HashMap<>();
			classDatum2nodes2nodeConnections.put(classDatum, nodes2connection);
		}
		Set<@NonNull Node> sourceSet = Sets.newHashSet(sourceNodes);
		NodeConnection connection = nodes2connection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString("j");
			s.appendString(domainUsage.isInput() ? "i" : domainUsage.isOutput() ? "o" : "m");
			s.appendString("_");
			s.appendName(classDatum.getCompleteClass().getName());
			connection = createNodeConnection(scheduledRegion, sourceSet, classDatum, s);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	public @NonNull PartitionedContentsAnalysis getPartitionedContentsAnalysis() {
		PartitionedContentsAnalysis partitionedContentsAnalysis2 = partitionedContentsAnalysis;
		if (partitionedContentsAnalysis2 == null) {
			partitionedContentsAnalysis = partitionedContentsAnalysis2 = new PartitionedContentsAnalysis(scheduleManager);
		}
		return partitionedContentsAnalysis2;
	}

	/**
	 * Return true if the predicates of calledNode are not in conflict with the navigable paths from callingNode.
	 * called2calling identifies already identified conflict free pairs that do not need re-assessment.
	 */
	private boolean isCompatiblePattern(@NonNull Region region, @NonNull Node calledNode, @NonNull Node callingNode, @NonNull Map<@NonNull Node, @NonNull Node> called2calling) {
		Node oldPrevNode = called2calling.put(calledNode, callingNode);
		if (oldPrevNode != null) {
			return oldPrevNode == callingNode;
		}
		for (@NonNull NavigableEdge calledEdge : calledNode.getNavigableEdges()) {
			Node nextCalledNode = calledEdge.getEdgeTarget();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isDataType()) {  // FIXME why exclude AttributeNodes?
				Edge nextCallingEdge = callingNode.getNavigableEdge(QVTscheduleUtil.getProperty(calledEdge));
				if (nextCallingEdge != null) {
					Node nextCallingNode = nextCallingEdge.getEdgeTarget();
					if ((nextCallingNode.isNullLiteral() != nextCalledNode.isNullLiteral())) {
						return false;
					}
					if (!isCompatiblePattern(region, nextCalledNode, nextCallingNode, called2calling)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Ordered list of regions that call this region
	 */
	private static final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> region2callableParents = new HashMap<>();

	/**
	 * Ordered list of regions that this region calls. May exclude some children whose dependencies are unsatisfied.
	 * May include non-children whose dependencies are satisfied by earlier child calls.
	 */
	private static final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> region2callableChildren = new HashMap<>();

	/**
	 * The connections hosted by this region and passed to child regions.
	 */
	private static final @NonNull Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> region2rootConnections = new HashMap<>();

	/**
	 * The connections propagated as middle guards from a hosted by a parent region and to one or more child regions.
	 */
	private static final @NonNull Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> region2intermediateConnections = new HashMap<>();

	private static final @NonNull Map<@NonNull Connection, @NonNull List<@NonNull ConnectionEnd>> connection2sourceEnds = new HashMap<>();
	private static final @NonNull Map<@NonNull Connection, @NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole>> connection2targetEnd2role = new HashMap<>();

	/**
	 * The region that manages the data structures for the Connection.
	 */
	private static final @NonNull Map<@NonNull NodeConnection, @Nullable Region> connection2commonRegion = new HashMap<>();

	/**
	 * The regions other than the common, source and target regions through which the Connection is passed.
	 */
	private static @NonNull Map<@NonNull NodeConnection, @Nullable List<@NonNull Region>> connection2intermediateRegions = new HashMap<>();

	public static void rawAddCallToChild(@NonNull Region parentRegion, @NonNull Region childRegion) {
		rawGetCallableChildren(parentRegion).add(childRegion);
		rawGetCallableParents(childRegion).add(parentRegion);
	}

	public static void rawAddIntermediateConnection(@NonNull Region region, @NonNull NodeConnection connection) {
		List<@NonNull NodeConnection> intermediateConnections = rawGetIntermediateConnections(region);
		assert !intermediateConnections.contains(connection);
		intermediateConnections.add(connection);
	}

	public static void rawAddRootConnection(@NonNull Region region, @NonNull NodeConnection connection) {
		List<@NonNull NodeConnection> rootConnections = rawGetRootConnections(region);
		assert !rootConnections.contains(connection);
		rootConnections.add(connection);
	}

	public static void rawAddPassedTargetNode(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode) {
		rawMergeRole(nodeConnection, ConnectionRole.PASSED);
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		assert !targetEnd2role.containsKey(targetNode);
		targetEnd2role.put(targetNode, ConnectionRole.PASSED);
		targetNode.setIncomingConnection(nodeConnection);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	public static void rawAddUsedTargetEdge(@NonNull EdgeConnection edgeConnection, @NonNull NavigableEdge targetEdge, boolean mustBeLater) {
		//		if (getSourceRegions().contains(targetEdge.getRegion())) {
		//			System.out.println("Cyclic dependency arbitrarily ignored: " + this);
		//			mergeRole(Connections.PREFERRED_EDGE);
		//			return;
		//		}
		rawMergeRole(edgeConnection, mustBeLater ? ConnectionRole.MANDATORY_EDGE : ConnectionRole.PREFERRED_EDGE);
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(edgeConnection);
		assert !targetEnd2role.containsKey(targetEdge);
		targetEnd2role.put(targetEdge, mustBeLater ? ConnectionRole.MANDATORY_EDGE : ConnectionRole.PREFERRED_EDGE);
		targetEdge.setIncomingConnection(edgeConnection);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	public static void rawAddUsedTargetNode(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode, boolean mustBeLater) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		ConnectionRole newConnectionRole = mustBeLater ? ConnectionRole.MANDATORY_NODE : ConnectionRole.PREFERRED_NODE;
		ConnectionRole oldConnectionRole = targetEnd2role.get(targetNode);
		if ((oldConnectionRole != null) && (oldConnectionRole != newConnectionRole)) {
			newConnectionRole = newConnectionRole.merge(oldConnectionRole);
		}
		rawMergeRole(nodeConnection, newConnectionRole);
		targetEnd2role.put(targetNode, newConnectionRole);
		assert targetNode.getIncomingConnection() == null;
		targetNode.setIncomingConnection(nodeConnection);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	public static @Nullable Node rawBasicGetSource(@NonNull NodeConnection nodeConnection, @NonNull Region sourceRegion) {
		Node sourceNode = null;
		for (@NonNull Node node : rawGetSourceEnds(nodeConnection)) {
			if (node.getOwningRegion() == sourceRegion) {
				assert sourceNode == null;
				sourceNode = node;
			}
		}
		return sourceNode;
	}

	public static void rawDestroy(@NonNull EdgeConnection edgeConnection) {
		for (@NonNull NavigableEdge sourceEdge : rawGetSourceEnds(edgeConnection)) {
			sourceEdge.removeOutgoingConnection(edgeConnection);
		}
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(edgeConnection);
		for (@NonNull NavigableEdge targetNode : targetEnd2role.keySet()) {
			targetNode.setIncomingConnection(null);
		}
	}

	public static void rawDestroy(@NonNull NodeConnection nodeConnection) {
		for (@NonNull Node sourceNode : rawGetSourceEnds(nodeConnection)) {
			sourceNode.removeOutgoingConnection(nodeConnection);
		}
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		for (@NonNull Node targetNode : targetEnd2role.keySet()) {
			targetNode.setIncomingConnection(null);
		}
	}

	/**
	 * Return the regions that this region can actually call directly after taking account the connection dependencies.
	 */
	public static @NonNull List<@NonNull Region> rawGetCallableChildren(@NonNull Region region) {
		List<@NonNull Region> callableChildren = region2callableChildren.get(region);
		if (callableChildren == null) {
			callableChildren = new ArrayList<>();
			region2callableChildren.put(region, callableChildren);
		}
		return callableChildren;
	}

	/**
	 * Return the regions that can actually call this region directly after taking account the connection dependencies.
	 */
	public static @NonNull List<@NonNull Region> rawGetCallableParents(@NonNull Region region) {
		List<@NonNull Region> callableParents = region2callableParents.get(region);
		if (callableParents == null) {
			callableParents = new ArrayList<>();
			region2callableParents.put(region, callableParents);
		}
		return callableParents;
	}

	/**
	 * Return the regions that this region calls.
	 */
	public static @NonNull List<@NonNull Region> rawGetCalledRegions(@NonNull Region region) {
		List<@NonNull Region> childRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection childConnection : rawGetOutgoingPassedConnections(region)) {
			for (@NonNull Node childNode : rawGetTargetNodes(childConnection)) {
				Region childRegion = QVTscheduleUtil.getOwningRegion(childNode);
				if (!childRegions.contains(childRegion)) {
					childRegions.add(childRegion);
				}
			}
		}
		return childRegions;
	}

	/**
	 * Return the regions the call this region.
	 */
	public static @NonNull List<@NonNull Region> rawGetCallingRegions(@NonNull Region region) {
		List<@NonNull Region> callingRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection callingConnection : rawGetIncomingPassedConnections(region)) {
			for (@NonNull Node callingNode : rawGetSourceEnds(callingConnection)) {
				Region callingRegion = QVTscheduleUtil.getOwningRegion(callingNode);
				if (!callingRegions.contains(callingRegion)) {
					callingRegions.add(callingRegion);
				}
			}
		}
		return callingRegions;
	}

	public static @Nullable Region rawGetCommonRegion(@NonNull NodeConnection nodeConnection) {
		return connection2commonRegion.get(nodeConnection);
	}

	public static @NonNull List<@NonNull NodeConnection> rawGetIntermediateConnections(@NonNull Region region) {
		List<@NonNull NodeConnection> intermediateConnections = region2intermediateConnections.get(region);
		if (intermediateConnections == null) {
			intermediateConnections = new ArrayList<>();
			region2intermediateConnections.put(region, intermediateConnections);
		}
		return intermediateConnections;
	}

	public static @NonNull Iterable<@NonNull Connection> rawGetIncomingConnections(@NonNull Region region) {		// FIXME cache
		List<@NonNull Connection> connections = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			/*			if (node.isDependency() || node.isPattern()) {
				if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
					NodeConnection connection = node.getIncomingUsedConnection();
					if ((connection != null) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
			else if (node.isTrue()) {		// A <<success>> node */
			NodeConnection connection = node.getIncomingUsedConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
			//			}
		}
		for (@NonNull NavigationEdge edge : region.getPredicatedNavigationEdges()) {
			EdgeConnection connection = edge.getIncomingConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		return connections;
	}

	public static @NonNull Iterable<@NonNull NodeConnection> rawGetIncomingPassedConnections(@NonNull Region region) {		// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if (connection != null) {
				connections.add(connection);
			}
		}
		return connections;
	}

	public static @NonNull Iterable<@NonNull NodeConnection> rawGetIncomingUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : region.getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = node.getIncomingUsedConnection();
				if (connection != null) {
					connections.add(connection);
				}
			}
		}
		return connections;
	}

	public static @NonNull List<@NonNull Region> rawGetIntermediateRegions(@NonNull NodeConnection nodeConnection) {
		List<@NonNull Region> intermediateRegions = connection2intermediateRegions.get(nodeConnection);
		return intermediateRegions != null ? intermediateRegions : QVTscheduleConstants.EMPTY_REGION_LIST;
	}

	public static @NonNull List<@NonNull Connection> rawGetLoopingConnections(@NonNull Region region) {
		List<@NonNull Connection> loopingConnections = new ArrayList<>();
		for (@NonNull Connection connection : rawGetOutgoingConnections(region)) {
			for (@NonNull Region sourceRegion : rawGetSourceRegions(connection)) {
				if (region == sourceRegion) {
					for (@NonNull Region targetRegion : rawGetTargetRegions(connection)) {
						if ((region == targetRegion) && !loopingConnections.contains(connection)) {
							loopingConnections.add(connection);
						}
					}
				}
			}
		}
		return loopingConnections;
	}

	/**
	 * Return all the next connections from this region to another region.
	 * Where this is a hierarchical region the connections are those from the hierarchical head to its immediate internal regions.
	 */
	public static @NonNull Iterable<@NonNull Connection> rawGetNextConnections(@NonNull Region region) {
		return rawGetOutgoingConnections(region);
	}

	/**
	 * Return all connections from this (hierarchical) region to another (hierarchical) region.
	 */
	public static @NonNull List<@NonNull Connection> rawGetOutgoingConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull Connection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		for (@NonNull NavigableEdge edge : region.getNavigationEdges()) {
			for (@NonNull EdgeConnection connection : QVTscheduleUtil.getOutgoingConnections(edge)) {
				connections.add(connection);
			}
		}
		return connections;
	}

	public static @NonNull Iterable<@NonNull NodeConnection> rawGetOutgoingPassedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	public static @NonNull Iterable<@NonNull NodeConnection> rawGetOutgoingUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	public static @NonNull List<@NonNull NodeConnection> rawGetRootConnections(@NonNull Region region) {
		List<@NonNull NodeConnection> rootConnections = region2rootConnections.get(region);
		if (rootConnections == null) {
			rootConnections = new ArrayList<>();
			region2rootConnections.put(region, rootConnections);
		}
		return rootConnections;
	}

	public static @NonNull ConnectionEnd rawGetSource(@NonNull Connection connection, @NonNull Region sourceRegion) {
		@Nullable ConnectionEnd sourceEnd = null;
		for (@NonNull ConnectionEnd end : rawGetSourceEnds(connection)) {
			if (end.getOwningRegion() == sourceRegion) {
				assert sourceEnd == null;
				sourceEnd = end;
			}
		}
		assert sourceEnd != null;
		return sourceEnd;
	}

	public static@NonNull Node rawGetSource(@NonNull NodeConnection nodeConnection, @NonNull Region sourceRegion) {
		return (Node) rawGetSource((Connection)nodeConnection, sourceRegion);
	}

	private static @NonNull List<@NonNull ConnectionEnd> rawGetSourceEnds(@NonNull Connection connection) {
		List<@NonNull ConnectionEnd> sourceEnds = connection2sourceEnds.get(connection);
		if (sourceEnds == null) {
			sourceEnds = new ArrayList<>();
			connection2sourceEnds.put(connection, sourceEnds);
		}
		return sourceEnds;
	}

	public static @NonNull List<@NonNull NavigableEdge> rawGetSourceEnds(@NonNull EdgeConnection edgeConnection) {
		return (List<@NonNull NavigableEdge>)(Object)rawGetSourceEnds((Connection)edgeConnection);
	}

	public static @NonNull List<@NonNull Node> rawGetSourceEnds(@NonNull NodeConnection nodeConnection) {
		return (List<@NonNull Node>)(Object)rawGetSourceEnds((Connection)nodeConnection);
	}

	public static @NonNull Iterable<@NonNull Node> rawGetSourceNodes(@NonNull Connection connection) {
		if (connection instanceof EdgeConnection) {
			return rawGetSourceNodes((EdgeConnection)connection);
		}
		else {
			return rawGetSourceNodes((NodeConnection)connection);
		}
	}

	public static @NonNull Iterable<@NonNull Node> rawGetSourceNodes(@NonNull EdgeConnection edgeConnection) {
		List<@NonNull Node> sourceNodes = new ArrayList<>();
		for (@NonNull NavigableEdge sourceEdge : rawGetSourceEnds(edgeConnection)) {
			sourceNodes.add(sourceEdge.getEdgeSource());
		}
		return sourceNodes;
	}

	public static @NonNull Iterable<@NonNull Node> rawGetSourceNodes(@NonNull NodeConnection nodeConnection) {
		return rawGetSourceEnds(nodeConnection);
	}

	public static @NonNull Iterable<@NonNull Region> rawGetSourceRegions(@NonNull Connection connection) {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : rawGetSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			sourceRegions.add(sourceRegion);
		}
		return sourceRegions;
	}

	public static @NonNull Iterable<@NonNull ? extends ConnectionEnd> rawGetSources(@NonNull Connection connection) {
		return rawGetSourceEnds(connection);
	}

	public static @NonNull Iterable<@NonNull NavigableEdge> rawGetSources(@NonNull EdgeConnection edgeConnection) {
		return rawGetSourceEnds(edgeConnection);
	}

	public static @NonNull Iterable<@NonNull Node> rawGetSources(@NonNull NodeConnection nodeConnection) {
		return rawGetSourceEnds(nodeConnection);
	}

	public static @NonNull Iterable<@NonNull Region> rawGetSourceRegions(@NonNull Connection connection, @NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : rawGetSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			sourceRegion = scheduledRegion.getNormalizedRegion(sourceRegion);
			if (sourceRegion != null) {
				sourceRegions.add(sourceRegion);
			}
		}
		return sourceRegions;
	}

	public static @NonNull Type rawGetSourcesType(@NonNull NodeConnection nodeConnection, @NonNull IdResolver idResolver) {
		//		System.out.println("commonType of " + this);
		Type commonType = null;
		for (@NonNull Node node : rawGetSourceEnds(nodeConnection)) {
			Type nodeType = node.getCompleteClass().getPrimaryClass();
			if (nodeType instanceof CollectionType) {
				nodeType = ((CollectionType)nodeType).getElementType();		// FIXME needed for composed source nodes
				assert nodeType != null;
			}
			//			System.out.println("  nodeType " + nodeType);
			//			CompleteEnvironment environment = idResolver.getEnvironment();
			//			if (!(nodeType instanceof CollectionType)) {		// RealizedVariable accumulated on Connection
			//				nodeType = isOrdered() ? environment.getOrderedSetType(nodeType, true, null, null) : environment.getSetType(nodeType, true, null, null);
			//			}
			if (commonType == null) {
				commonType = nodeType;
			}
			else if (nodeType != commonType) {
				commonType = commonType.getCommonType(idResolver, nodeType);
			}
		}
		//		System.out.println("=> " + commonType);
		assert commonType != null;
		return commonType;
	}

	public static @NonNull ConnectionEnd rawGetTarget(@NonNull Connection connection, @NonNull Region targetRegion) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(connection);
		@Nullable ConnectionEnd targetEnd = null;
		for (@NonNull ConnectionEnd end : targetEnd2role.keySet()) {
			if (end.getOwningRegion() == targetRegion) {
				assert targetEnd == null;
				targetEnd = end;
			}
		}
		assert targetEnd != null;
		return targetEnd;
	}

	public static @NonNull Iterable<@NonNull NavigableEdge> rawGetTargetEdges(@NonNull EdgeConnection edgeConnection) {
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(edgeConnection);
		return targetEnd2role.keySet();
	}

	private static @NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> rawGetTargetEnd2Role(@NonNull Connection connection) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = connection2targetEnd2role.get(connection);
		if (targetEnd2role == null) {
			targetEnd2role = new HashMap<>();
			connection2targetEnd2role.put(connection, targetEnd2role);
		}
		return targetEnd2role;
	}

	private static @NonNull Map<@NonNull NavigableEdge, @NonNull ConnectionRole> rawGetTargetEnd2Role(@NonNull EdgeConnection edgeConnection) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = connection2targetEnd2role.get(edgeConnection);
		if (targetEnd2role == null) {
			targetEnd2role = new HashMap<>();
			connection2targetEnd2role.put(edgeConnection, targetEnd2role);
		}
		return (Map<@NonNull NavigableEdge, @NonNull ConnectionRole>)(Object)targetEnd2role;
	}

	private static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> rawGetTargetEnd2Role(@NonNull NodeConnection nodeConnection) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = connection2targetEnd2role.get(nodeConnection);
		if (targetEnd2role == null) {
			targetEnd2role = new HashMap<>();
			connection2targetEnd2role.put(nodeConnection, targetEnd2role);
		}
		return (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)targetEnd2role;
	}

	public static @NonNull Iterable<@NonNull Node> rawGetTargetNodes(@NonNull Connection connection) {
		if (connection instanceof EdgeConnection) {
			return rawGetTargetNodes((EdgeConnection)connection);
		}
		else {
			return rawGetTargetNodes((NodeConnection)connection);
		}
	}

	public static @NonNull Iterable<@NonNull Node> rawGetTargetNodes(@NonNull EdgeConnection edgeConnection) {
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(edgeConnection);
		List<@NonNull Node> targetNodes = new ArrayList<>();
		for (@NonNull NavigableEdge targetEdge : targetEnd2role.keySet()) {
			targetNodes.add(targetEdge.getEdgeTarget());
		}
		return targetNodes;
	}
	public static @NonNull Iterable<@NonNull Node> rawGetTargetNodes(@NonNull NodeConnection nodeConnection) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		return targetEnd2role.keySet();
	}

	public static @NonNull Set<@NonNull Region> rawGetTargetRegions(@NonNull Connection connection) {
		Set<@NonNull Region> targetRegions = new HashSet<>();
		for (@NonNull ConnectionEnd targetEnd : rawGetTargets(connection).keySet()) {
			Region targetRegion = QVTscheduleUtil.getOwningRegion(targetEnd);
			targetRegions.add(targetRegion);
		}
		return targetRegions;
	}

	public static @NonNull Iterable<@NonNull Region> rawGetTargetRegions(@NonNull Connection connection, @NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> targetRegions = new HashSet<>();
		for (@NonNull ConnectionEnd targetEnd : rawGetTargets(connection).keySet()) {
			Region targetRegion = QVTscheduleUtil.getOwningRegion(targetEnd);
			targetRegion = scheduledRegion.getNormalizedRegion(targetRegion);
			if (targetRegion != null) {
				targetRegions.add(targetRegion);
			}
		}
		return targetRegions;
	}

	public static @NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> rawGetTargets(@NonNull Connection connection) {
		//		if (connection instanceof NodeConnection) {
		//			return (Map<@NonNull CE, @NonNull ConnectionRole>) rawGetTargets((NodeConnection)connection);
		//		}
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(connection);
		return targetEnd2role;
	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> rawGetTargets(@NonNull EdgeConnection edgeConnection) {
	//		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull NavigableEdge, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> rawGetTargets(@NonNull NodeConnection nodeConnection) {
	//		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	/**
	 * Return the regions that this region uses and how many times.
	 */
	public static @NonNull List<@NonNull NodeConnection> rawGetUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> usedConnections = new ArrayList<>();
		for (@NonNull Node node : region.getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = node.getIncomingUsedConnection();
				if (connection != null) {
					usedConnections.add(connection);
				}
			}
		}
		return usedConnections;
	}

	public static boolean rawIsEdge2Edge(@NonNull EdgeConnection edgeConnection) {
		List<NavigableEdge> sourceEnds = rawGetSourceEnds(edgeConnection);
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(edgeConnection);
		return (sourceEnds.size() == 1) && (targetEnd2role.size() == 1);
	}

	public static boolean rawIsNode2Node(@NonNull NodeConnection nodeConnection) {
		List<Node> sourceEnds = rawGetSourceEnds(nodeConnection);
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		return (sourceEnds.size() == 1) && (targetEnd2role.size() == 1);
	}

	public static boolean rawIsPassed(@NonNull Connection connection, @NonNull Region targetRegion) {
		if (connection instanceof EdgeConnection) {
			return rawIsPassed((EdgeConnection)connection, targetRegion);
		}
		else {
			return rawIsPassed((NodeConnection)connection, targetRegion);
		}
	}

	public static boolean rawIsPassed(@NonNull EdgeConnection edgeConnection, @NonNull Region targetRegion) {
		return false;
	}

	public static boolean rawIsPassed(@NonNull NodeConnection nodeConnection, @NonNull Region targetRegion) {
		if (Iterables.contains(ConnectionManager.rawGetIncomingPassedConnections(targetRegion), nodeConnection)) {		// FIXME unify cyclic/non-cyclic
			return true;
		}
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		for (@NonNull Node targetNode : targetEnd2role.keySet()) {
			if (targetNode.getOwningRegion() == targetRegion) {
				ConnectionRole role = targetEnd2role.get(targetNode);
				assert role != null;
				if (role.isPassed()) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean rawIsRegion2Region(@NonNull Connection connection, @NonNull Map<@NonNull Region, @NonNull Integer> sourceRegion2count, @NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles) {
		return (sourceRegion2count.size() == 1) && (targetRegion2roles.size() == 1) && (targetRegion2roles.values().iterator().next().size() == 1); //(targetEnd2role.size() == 1);
	}

	public static boolean rawIsUsed(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		ConnectionRole targetConnectionRole = targetEnd2role.get(targetNode);
		assert targetConnectionRole != null;
		return targetConnectionRole.isPreferred();
	}

	protected static void rawMergeRole(@NonNull Connection connection, @NonNull ConnectionRole connectionRoleEnum) {
		//		assert connectionRole != null;
		if (connection.getConnectionRole() == ConnectionRole.UNDEFINED) {
			connection.setConnectionRole(connectionRoleEnum);
		}
		else if (connection.getConnectionRole() != connectionRoleEnum) {
			connection.setConnectionRole(connection.getConnectionRole().merge(connectionRoleEnum));
		}
	}

	public static void rawRemoveCallToChild(@NonNull Region parentRegion, @NonNull Region childRegion) {
		rawGetCallableChildren(parentRegion).remove(childRegion);
		rawGetCallableParents(childRegion).remove(parentRegion);
	}

	public static void rawReplaceCallToChild(@NonNull Region parentRegion, @NonNull Region oldRegion, @NonNull Region newRegion) {
		List<@NonNull Region> parentRegionCallableChildren = rawGetCallableChildren(parentRegion);
		int index = parentRegionCallableChildren.indexOf(oldRegion);
		parentRegionCallableChildren.remove(oldRegion);
		parentRegionCallableChildren.add(index, newRegion);
		List<@NonNull Region> oldRegionCallableParents = rawGetCallableParents(oldRegion);
		oldRegionCallableParents.remove(parentRegion);
		oldRegionCallableParents.add(parentRegion);
	}

	public static void rawRemoveSource(@NonNull NodeConnection nodeConnection, @NonNull Node sourceNode) {
		boolean wasRemoved = rawGetSourceEnds(nodeConnection).remove(sourceNode);
		assert wasRemoved;
	}

	private static void rawRemoveTarget(@NonNull EdgeConnection edgeConnection, @NonNull NavigableEdge targetEdge) {
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(edgeConnection);
		ConnectionRole oldRole = targetEnd2role.remove(targetEdge);
		assert oldRole != null;
	}

	public static void rawRemoveTarget(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		ConnectionRole oldRole = targetEnd2role.remove(targetNode);
		assert oldRole != null;
	}

	public static void rawRemoveTargetRegion(@NonNull Connection connection, @NonNull Region targetRegion) {
		if (connection instanceof EdgeConnection) {
			rawRemoveTargetRegion((EdgeConnection)connection, targetRegion);
		}
		else {
			rawRemoveTargetRegion((NodeConnection)connection, targetRegion);
		}
	}

	public static void rawRemoveTargetRegion(@NonNull EdgeConnection edgeConnection, @NonNull Region targetRegion) {
		for (@NonNull NavigableEdge targetEdge : Lists.newArrayList(rawGetTargetEdges(edgeConnection))) {
			if (targetEdge.getOwningRegion() == targetRegion) {
				targetEdge.setIncomingConnection(null);
				rawRemoveTarget(edgeConnection, targetEdge);
			}
		}
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(edgeConnection);
		if (targetEnd2role.isEmpty()) {
			rawDestroy(edgeConnection);
		}
	}

	public static void rawRemoveTargetRegion(@NonNull NodeConnection nodeConnection, @NonNull Region targetRegion) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = rawGetTargetEnd2Role(nodeConnection);
		for (@NonNull Node targetNode : Lists.newArrayList(rawGetTargetNodes(nodeConnection))) {
			if (targetNode.getOwningRegion() == targetRegion) {
				targetNode.setIncomingConnection(null);
				rawRemoveTarget(nodeConnection, targetNode);
			}
		}
		if (targetEnd2role.isEmpty()) {
			rawDestroy(nodeConnection);
		}
	}

	public static void rawSetCommonRegion(@NonNull NodeConnection nodeConnection, @NonNull Region commonRegion, @NonNull List<@NonNull Region> intermediateRegions) {
		assert !connection2commonRegion.containsKey(nodeConnection);
		assert !connection2intermediateRegions.containsKey(nodeConnection);
		connection2commonRegion.put(nodeConnection, commonRegion);
		connection2intermediateRegions.put(nodeConnection, new ArrayList<>(intermediateRegions));
		rawAddRootConnection(commonRegion, nodeConnection);
		for (@NonNull Region intermediateRegion : intermediateRegions) {
			rawAddIntermediateConnection(intermediateRegion, nodeConnection);
		}
		if (QVTscheduleConstants.CONNECTION_ROUTING.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append(nodeConnection.getSymbolName() + " common: " + commonRegion + " intermediate:");
			for (@NonNull Region intermediateRegion : intermediateRegions) {
				s.append(" " + intermediateRegion);
			}
			QVTscheduleConstants.CONNECTION_ROUTING.println(s.toString());
		}
	}
}
