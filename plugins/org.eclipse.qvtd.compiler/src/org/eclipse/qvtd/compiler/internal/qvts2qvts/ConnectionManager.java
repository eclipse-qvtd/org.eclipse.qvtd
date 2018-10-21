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
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.LegacyContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.LoadingRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
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
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * ConnectionManager supervises the connections initially between rule-regions and ultimaately between partitions.
 */
public class ConnectionManager
{
	private static final @NonNull String JOIN_ATTRIBUTE_PREFIX = "ja";
	private static final @NonNull String JOIN_EDGE_PREFIX = "je_";
	private static final @NonNull String JOIN_INPUT_PREFIX = "ji";
	private static final @NonNull String JOIN_MIDDLE_PREFIX = "jm";
	private static final @NonNull String JOIN_OUTPUT_PREFIX = "jo";

	public static final @NonNull List<@NonNull Partition> EMPTY_PARTITION_LIST = Collections.emptyList();

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
	private final @NonNull LegacyContentsAnalysis originalContentsAnalysis;

	/**
	 * The region that manages the data structures for the Connection.
	 */
	private final @NonNull Map<@NonNull NodeConnection, @Nullable Partition> connection2commonPartition = new HashMap<>();

	/**
	 * The regions other than the common, source and target regions through which the Connection is passed.
	 */
	private @NonNull Map<@NonNull NodeConnection, @Nullable List<@NonNull Partition>> connection2intermediatePartitions = new HashMap<>();

	private final @NonNull Map<@NonNull Connection, @NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole>> connection2targetEnd2role = new HashMap<>();

	/**
	 * Ordered list of regions that call this region
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Partition>> partition2parents = new HashMap<>();

	/**
	 * Ordered list of regions that this region calls. May exclude some children whose dependencies are unsatisfied.
	 * May include non-children whose dependencies are satisfied by earlier child calls.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Partition>> partition2children = new HashMap<>();

	/**
	 * The connections propagated as middle guards from a hosted by a parent region and to one or more child regions.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull NodeConnection>> partition2intermediateConnections = new HashMap<>();

	/**
	 * The connections hosted by this region and passed to child regions.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull NodeConnection>> partition2rootConnections = new HashMap<>();

	public ConnectionManager(@NonNull ProblemHandler problemHandler, @NonNull ScheduleManager scheduleManager, @NonNull LoadingRegionAnalysis loadingRegionAnalysis) {
		//	super(qvtm2qvts.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.loadingRegionAnalysis = loadingRegionAnalysis;
		this.originalContentsAnalysis = scheduleManager.getOriginalContentsAnalysis();
	}

	public void addCallToChild(@NonNull Partition parentPartition, @NonNull Partition childPartition) {
		getCallableChildren(parentPartition).add(childPartition);
		getCallableParents(childPartition).add(parentPartition);
	}

	public void addIntermediateConnection(@NonNull Partition partition, @NonNull NodeConnection connection) {
		List<@NonNull NodeConnection> intermediateConnections = getIntermediateConnections(partition);
		assert !intermediateConnections.contains(connection);
		intermediateConnections.add(connection);
	}

	public void addPassedTargetNode(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode) {
		mergeRole(nodeConnection, ConnectionRole.PASSED);
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		assert !targetEnd2role.containsKey(targetNode);
		targetEnd2role.put(targetNode, ConnectionRole.PASSED);
		targetNode.setIncomingConnection(nodeConnection);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	public void addRootConnection(@NonNull Partition partition, @NonNull NodeConnection connection) {
		List<@NonNull NodeConnection> rootConnections = getRootConnections(partition);
		assert !rootConnections.contains(connection);
		rootConnections.add(connection);
	}

	public void addUsedTargetEdge(@NonNull EdgeConnection edgeConnection, @NonNull NavigableEdge targetEdge, boolean mustBeLater) {
		//		if (getSourceRegions().contains(targetEdge.getRegion())) {
		//			System.out.println("Cyclic dependency arbitrarily ignored: " + this);
		//			mergeRole(Connections.PREFERRED_EDGE);
		//			return;
		//		}
		mergeRole(edgeConnection, mustBeLater ? ConnectionRole.MANDATORY_EDGE : ConnectionRole.PREFERRED_EDGE);
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(edgeConnection);
		assert !targetEnd2role.containsKey(targetEdge);
		targetEnd2role.put(targetEdge, mustBeLater ? ConnectionRole.MANDATORY_EDGE : ConnectionRole.PREFERRED_EDGE);
		targetEdge.setIncomingConnection(edgeConnection);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	public void addUsedTargetNode(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode, boolean mustBeLater) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		ConnectionRole newConnectionRole = mustBeLater ? ConnectionRole.MANDATORY_NODE : ConnectionRole.PREFERRED_NODE;
		ConnectionRole oldConnectionRole = targetEnd2role.get(targetNode);
		if ((oldConnectionRole != null) && (oldConnectionRole != newConnectionRole)) {
			newConnectionRole = newConnectionRole.merge(oldConnectionRole);
		}
		mergeRole(nodeConnection, newConnectionRole);
		targetEnd2role.put(targetNode, newConnectionRole);
		assert targetNode.getIncomingConnection() == null;
		targetNode.setIncomingConnection(nodeConnection);
		//		assert Sets.intersection(getSourceRegions(), getTargetRegions()).isEmpty();
	}

	public @Nullable Node basicGetSource(@NonNull NodeConnection nodeConnection, @NonNull Partition sourcePartition) {
		Node sourceNode = null;
		for (@NonNull Node sourceEnd : QVTscheduleUtil.getSourceEnds(nodeConnection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
			if (Iterables.contains(sourceRegionAnalysis.getPartitions(), sourcePartition)) {
				Role sourceRole = getRole(sourcePartition, sourceEnd);
				if ((sourceRole != null) && !sourceRole.isAwaited()) { //(sourceRole.isNew() || sourceRole.isLoaded())) {
					assert sourceNode == null;
					sourceNode = sourceEnd;
				}
			}
		}
		return sourceNode;
	}

	/**
	 * Create the Passed and Used Connections between all introducers and their corresponding consuming nodes.
	 */
	public void createConnections(@NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<@NonNull ? extends Iterable<@NonNull PartitionAnalysis>> partitionSchedule) {
		Set<@NonNull Region> regions = new HashSet<>();
		for (@NonNull Iterable<@NonNull PartitionAnalysis> concurrency : partitionSchedule) {
			for (@NonNull PartitionAnalysis partitionAnalysis : concurrency) {
				regions.add(QVTscheduleUtil.getRegion(partitionAnalysis.getPartition()));
			}
		}
		//		for (@NonNull Region region : regions) {
		//			createIncomingConnections(scheduledRegion, region);
		//		}
		//		scheduleManager.writeDebugGraphs("4-bindings", true, true, false);
		//		for (Region region : sortedCallableRegions) {
		//			region.checkIncomingConnections();
		//		}
	}

	/*	public void createConnections(@NonNull Iterable<@NonNull Iterable<@NonNull Partition>> partitionSchedule) {
		for (@NonNull Iterable<@NonNull Partition> partitions : partitionSchedule) {
			for (@NonNull Partition partition : partitions) {
				createIncomingConnections(partition);
			}
		}
		scheduleManager.writeDebugGraphs("45-bindings", true, true, false);
	} */

	/**
	 * Create an EdgeConnection for the predicatedEdge and/or its target node.
	 */
	private void createAttributeEdgeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Region region, @NonNull Node castTargetNode, @NonNull Iterable<@NonNull NavigableEdge> predicatedEdges) {
		ScheduledRegion invokingRegion2 = scheduledRegion;
		assert invokingRegion2 != null;
		Node castTarget = castTargetNode;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
		for (@NonNull NavigableEdge predicatedEdge : predicatedEdges) {
			List<@NonNull NavigableEdge> attributeConnectionSourceEdges = null;
			List<@NonNull String> partialNames = new ArrayList<>();
			assert predicatedEdge.isNavigation();
			assert predicatedEdge.getIncomingConnection() == null;
			assert !predicatedEdge.isCast();
			Property predicatedProperty = predicatedEdge.getProperty();
			assert !predicatedProperty.isIsImplicit();
			boolean isDataType = classDatum.getCompleteClass().getPrimaryClass() instanceof DataType;
			assert isDataType;
			Iterable<@NonNull NavigableEdge> realizedEdges = getNewEdges(predicatedEdge, classDatum);
			if (realizedEdges != null) {
				for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
					if (scheduleManager.isElementallyConformantSource(realizedEdge, predicatedEdge) && QVTscheduleUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
						if (attributeConnectionSourceEdges == null) {
							attributeConnectionSourceEdges = new ArrayList<>();
						}
						attributeConnectionSourceEdges.add(realizedEdge);
					}
				}
				partialNames.add(QVTscheduleUtil.getName(predicatedEdge.getEdgeSource().getCompleteClass()));
				partialNames.add(QVTscheduleUtil.getName(predicatedProperty));
			}
			if (attributeConnectionSourceEdges != null) {
				EdgeConnection edgeConnection = getAttributeConnection(invokingRegion2, attributeConnectionSourceEdges, partialNames, predicatedProperty);
				addUsedTargetEdge(edgeConnection, predicatedEdge, false);
				if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
					QVTscheduleConstants.CONNECTION_CREATION.println("  Attribute EdgeConnection \"" + edgeConnection + "\" to " + castTarget);
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
	}

	/**
	 * Create an EdgeConnection for the predicatedEdge and/or its target node.
	 */
	private void createClassEdgeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Region region, @NonNull Node castTargetNode, @NonNull Iterable<@NonNull NavigableEdge> predicatedEdges) {
		ScheduledRegion invokingRegion2 = scheduledRegion;
		assert invokingRegion2 != null;
		Node castTarget = castTargetNode;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
		for (@NonNull NavigableEdge predicatedEdge : predicatedEdges) {
			assert predicatedEdge.isNavigation();
			assert predicatedEdge.getIncomingConnection() == null;
			assert !predicatedEdge.isCast();
			Property predicatedProperty = predicatedEdge.getProperty();
			assert !predicatedProperty.isIsImplicit();
			NavigableEdge castEdge = QVTscheduleUtil.getCastTarget(predicatedEdge);
			boolean isDataType = classDatum.getCompleteClass().getPrimaryClass() instanceof DataType;
			assert !isDataType;
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
						if (!Iterables.contains(getTargetEdges(edgeConnection), castEdge)) {
							addUsedTargetEdge(edgeConnection, castEdge, false);
							if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
								for (@NonNull NavigableEdge thatEdge : thoseEdges) {
									QVTscheduleConstants.CONNECTION_CREATION.println("    from " + thatEdge.getOwningRegion() + "  : " + thatEdge);
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
					addUsedTargetNode(predicatedConnection, castTarget, false);
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
	}

	private @NonNull EdgeConnection createEdgeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull  Set<@NonNull NavigableEdge> sourceSet, @NonNull Property property, @NonNull SymbolNameBuilder s) {
		assert !property.isIsImplicit();
		EdgeConnection edgeConnection = QVTscheduleFactory.eINSTANCE.createEdgeConnection();

		//		protected ConnectionImpl(@NonNull ScheduledRegion region, @NonNull Set<@NonNull CE> sourceEnds, @NonNull String name) {
		edgeConnection.setOwningScheduledRegion(scheduledRegion);
		edgeConnection.setName(scheduleManager.getScheduleModel().reserveSymbolName(s, edgeConnection));
		QVTscheduleUtil.getSourceEnds(edgeConnection).addAll(sourceSet);
		//		}

		//		public EdgeConnectionImpl(@NonNull ScheduledRegion region, @NonNull Set<@NonNull NavigableEdge> sourceEdges, @NonNull String name, @NonNull Property property) {
		//			super(region, sourceEdges, name);
		edgeConnection.setReferredProperty(property);
		for (@NonNull NavigableEdge sourceEdge : sourceSet) {
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(edgeConnection), sourceEdge);
			//		assert edge.getRegion() == getRegion();
			List<EdgeConnection> outgoingConnections2 = sourceEdge.getOutgoingConnections();
			assert !outgoingConnections2.contains(edgeConnection);
			outgoingConnections2.add(edgeConnection);
		}
		//		}
		//		return new EdgeConnectionImpl(this, sourceSet, s, property);
		return edgeConnection;
	}

	/**
	 * Create and return a NodeConnection to the nodes that can provide the sources for headNode.
	 * Returns null if the pattern surrounding the headNode conflicts with the pattern
	 * surrounding all possible sources.
	 */
	private @Nullable NodeConnection createHeadConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Region region, @NonNull Node headNode) {
		ScheduledRegion invokingRegion2 = scheduledRegion;
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
			sourceNodes = originalContentsAnalysis.getOldNodes(classDatum);
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
			addUsedTargetNode(headConnection, headNode, false);
		}
		else {
			addPassedTargetNode(headConnection, headNode);
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
	private @Nullable Iterable<@NonNull NodeConnection> createHeadConnections(@NonNull ScheduledRegion scheduledRegion, @NonNull Region region) {
		List<@NonNull NodeConnection> headConnections = null;
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
			if (headNode.isDependency()) {
				createHeadConnection(scheduledRegion, region, headNode);	/** Dependency nodes have extra not-head connections. */
			}
			else {
				NodeConnection headConnection = createHeadConnection(scheduledRegion, region, headNode);
				if (headConnection == null) {
					scheduleManager.addRegionWarning(region, "No incoming connections for " + headNode.getName());
					headConnection = createHeadConnection(scheduledRegion, region, headNode);	// FIXME debugging
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
	 * Create the connections that establish the inter-region dependencies. A passed connection for each head node and
	 * used connections for each predicated edge. (Non-head nodes are necessarily connected by predicates to the head.)
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
	 * Connections to attribute nodes are connected to just the edge; the datatyped node can be ambiguous
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
	public void createIncomingConnections(@NonNull ScheduledRegion scheduledRegion, @NonNull Region region) {
		if (QVTscheduleConstants.CONNECTION_CREATION.isActive()) {
			QVTscheduleConstants.CONNECTION_CREATION.println("connecting " + region);
		}
		assert !(region instanceof LoadingRegion);
		Iterable<@NonNull NodeConnection> headConnections = createHeadConnections(scheduledRegion, region);
		assert (headConnections != null);// {
		//
		//	Gather multiple edges sharing the same target to avoid multiple incoming connections -- FIXME no need to gather
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
			if (castTargetNode.isClass()) {
				createClassEdgeConnection(scheduledRegion, region, castTargetNode, predicatedEdges);
			}
			else {
				createAttributeEdgeConnection(scheduledRegion, region, castTargetNode, predicatedEdges);
			}
		}
		//}
	}

	private @NonNull NodeConnection createNodeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Set<@NonNull Node> sourceSet, @NonNull ClassDatum classDatum, @NonNull SymbolNameBuilder s) {
		NodeConnection connection = QVTscheduleFactory.eINSTANCE.createNodeConnection();
		connection.setOwningScheduledRegion(scheduledRegion);
		QVTscheduleUtil.getSourceEnds(connection).addAll(sourceSet);
		connection.setName(scheduleManager.getScheduleModel().reserveSymbolName(s, connection));
		connection.setClassDatum(classDatum);
		for (@NonNull Node sourceNode : sourceSet) {
			//			assert !sourceNode.isConstant();
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(connection), sourceNode);
			//		assert edge.getRegion() == getRegion();
			List<NodeConnection> outgoingConnections2 = sourceNode.getOutgoingConnections();
			assert !outgoingConnections2.contains(connection);
			outgoingConnections2.add(connection);
		}
		return connection;
	}

	/**
	 * Create the Passed Node Connection between the trace node realized in an activator partition and predicated in other partitions.
	 * Create Used Edge Connections between each edge realized in the origial region and predicated in a aprtition.
	 */
	public void createPartitionConnections(@NonNull ScheduledRegion scheduledRegion, @NonNull Region region) {
		RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(region);
		Iterable<@NonNull Partition> partitions = regionAnalysis.getPartitions();
		if (Iterables.size(partitions) <= 1) {
			return;										// No trace connections if not actually partitioned
		}
		//
		//	Every (the) trace node that is realized in the original region and is predicated in one of the partitions requires
		//	a passed node connection.
		//
		Iterable <@NonNull Node> traceNodes = regionAnalysis.getTraceNodes();
		for (@NonNull Node traceNode : traceNodes) {
			Set<@NonNull Node> sourceNodes = new HashSet<>();
			for (@NonNull Partition partition : partitions) {
				Role nodeRole = getRole(partition, traceNode);
				if ((nodeRole != null) && nodeRole.isNew()) {
					sourceNodes.add(traceNode);
				}
			}
			//
			if (!sourceNodes.isEmpty()) {
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(traceNode);
				NodeConnection connection = getNodeConnection(scheduledRegion, sourceNodes, classDatum, scheduleManager.getDomainUsage(classDatum));
				//
				Set<@NonNull Node> targetNodes = new HashSet<>();
				for (@NonNull Partition partition : partitions) {
					Role nodeRole = getRole(partition, traceNode);
					if ((nodeRole != null) && nodeRole.isOld()) {
						if (targetNodes.add(traceNode)) {
							addPassedTargetNode(connection, traceNode);
						}
					}
				}
			}
		}
		//
		//	Every edge that is realized in the original region and is predicated in one of the partitions requires
		//	a used edge connection.
		//
		for (@NonNull NavigableEdge edge : region.getRealizedNavigationEdges()) {
			if (!edge.isSecondary()) {
				boolean isAwaited = false;
				for (@NonNull Partition partition : regionAnalysis.getPartitions()) {
					Role role = partition.getRole(edge);
					if ((role != null) && role.isAwaited()) {
						isAwaited = true;
						break;
					}
				}
				if (isAwaited) {
					Property property = QVTscheduleUtil.getProperty(edge);
					EdgeConnection connection = getEdgeConnection(scheduledRegion, Collections.singleton(edge), property);
					addUsedTargetEdge(connection, edge, true);
				}
			}
		}
	}

	/**
	 * Create the Passed and Used Connections between all introducers and their corresponding consuming nodes
	 * for the original regions.
	 *
	public void createRegionConnections() {
		for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(scheduledRegion)) {
			createIncomingConnections(region);
		}
	} */

	public void destroy(@NonNull Connection connection) {
		if (connection instanceof EdgeConnection) {
			destroyEdgeConnection((EdgeConnection)connection);
		}
		else {
			destroyNodeConnection((NodeConnection)connection);
		}
		connection2commonPartition.remove(connection);
		connection2intermediatePartitions.remove(connection);
		connection.getSourceEnds().clear();
		connection2targetEnd2role.remove(connection);
		connection.setOwningScheduledRegion(null);
	}

	private void destroyEdgeConnection(@NonNull EdgeConnection edgeConnection) {
		for (@NonNull NavigableEdge sourceEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(edgeConnection), sourceEdge);
			//		assert edge.getRegion() == getRegion();
			List<EdgeConnection> outgoingConnections2 = sourceEdge.getOutgoingConnections();
			assert outgoingConnections2 != null;
			@SuppressWarnings("unused")boolean wasRemoved = outgoingConnections2.remove(edgeConnection);
			//			assert wasRemoved;   -- destroy subverts this
		}
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(edgeConnection);
		for (@NonNull NavigableEdge targetNode : targetEnd2role.keySet()) {
			targetNode.setIncomingConnection(null);
		}
	}

	private void destroyNodeConnection(@NonNull NodeConnection nodeConnection) {
		for (@NonNull Node sourceNode : QVTscheduleUtil.getSourceEnds(nodeConnection)) {
			assert Iterables.contains(QVTscheduleUtil.getSourceEnds(nodeConnection), sourceNode);
			//		assert edge.getRegion() == getRegion();
			List<NodeConnection> outgoingConnections2 = sourceNode.getOutgoingConnections();
			assert outgoingConnections2 != null;
			@SuppressWarnings("unused")
			boolean wasRemoved = outgoingConnections2.remove(nodeConnection);
			//		assert wasRemoved;
		}
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		for (@NonNull Node targetNode : targetEnd2role.keySet()) {
			targetNode.setIncomingConnection(null);
		}
	}

	private @NonNull EdgeConnection getAttributeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull List<@NonNull String> partialNames, @NonNull Property property) {
		Set<@NonNull NavigableEdge> sourceSet = Sets.newHashSet(sourceEdges);
		EdgeConnection connection = edges2edgeConnection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString(JOIN_ATTRIBUTE_PREFIX);
			for (@NonNull String partialName : partialNames) {
				s.appendString("_");
				s.appendName(partialName);
			}
			connection = createEdgeConnection(scheduledRegion, sourceSet, property, s);
			edges2edgeConnection.put(sourceSet, connection);
		}
		return connection;
	}

	/**
	 * Return the regions that this region can actually call directly after taking account the connection dependencies.
	 */
	public @NonNull List<@NonNull Partition> getCallableChildren(@NonNull Partition partition) {
		List<@NonNull Partition> children = partition2children.get(partition);
		if (children == null) {
			children = new ArrayList<>();
			partition2children.put(partition, children);
		}
		return children;
	}

	/**
	 * Return the regions that can actually call this region directly after taking account the connection dependencies.
	 */
	public @NonNull List<@NonNull Partition> getCallableParents(@NonNull Partition partition) {
		List<@NonNull Partition> parents = partition2parents.get(partition);
		if (parents == null) {
			parents = new ArrayList<>();
			partition2parents.put(partition, parents);
		}
		return parents;
	}

	public @Nullable Partition getCommonPartition(@NonNull NodeConnection nodeConnection) {
		return connection2commonPartition.get(nodeConnection);
	}

	public @NonNull List<@NonNull NodeConnection> getIntermediateConnections(@NonNull Partition partition) {
		List<@NonNull NodeConnection> intermediateConnections = partition2intermediateConnections.get(partition);
		if (intermediateConnections == null) {
			intermediateConnections = new ArrayList<>();
			partition2intermediateConnections.put(partition, intermediateConnections);
		}
		return intermediateConnections;
	}

	public @NonNull List<@NonNull Partition> getIntermediatePartitions(@NonNull NodeConnection nodeConnection) {
		List<@NonNull Partition> intermediatePartitions = connection2intermediatePartitions.get(nodeConnection);
		return intermediatePartitions != null ? intermediatePartitions :EMPTY_PARTITION_LIST;
	}

	private @NonNull EdgeConnection getEdgeConnection(@NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull Property property) {
		Set<@NonNull NavigableEdge> sourceSet = Sets.newHashSet(sourceEdges);
		EdgeConnection connection = edges2edgeConnection.get(sourceSet);
		if (connection == null) {
			SymbolNameBuilder s = new SymbolNameBuilder();
			s.appendString(JOIN_EDGE_PREFIX);
			s.appendName(property.getOwningClass().getName());
			s.appendString("_");
			s.appendName(property.getName());
			connection = createEdgeConnection(scheduledRegion, sourceSet, property, s);
			edges2edgeConnection.put(sourceSet, connection);
		}
		return connection;
	}

	/**
	 * Return the regions that this region calls.
	 *
	public static @NonNull List<@NonNull Region> getCalledRegions(@NonNull Region region) {
		List<@NonNull Region> childRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection childConnection : getOutgoingPassedConnections(region)) {
			for (@NonNull Node childNode : getTargetNodes(childConnection)) {
				Region childRegion = QVTscheduleUtil.getOwningRegion(childNode);
				if (!childRegions.contains(childRegion)) {
					childRegions.add(childRegion);
				}
			}
		}
		return childRegions;
	} */

	/**
	 * Return the regions the call this region.
	 *
	public @NonNull List<@NonNull Region> getCallingRegions(@NonNull Region region) {
		List<@NonNull Region> callingRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection callingConnection : getIncomingPassedConnections(region)) {
			for (@NonNull Node callingNode : getSourceEnds(callingConnection)) {
				Region callingRegion = QVTscheduleUtil.getOwningRegion(callingNode);
				if (!callingRegions.contains(callingRegion)) {
					callingRegions.add(callingRegion);
				}
			}
		}
		return callingRegions;
	} */

	public @NonNull Iterable<@NonNull Connection> getIncomingConnections(@NonNull PartitionAnalysis partitionAnalysis) {		// FIXME cache
		Partition partition = partitionAnalysis.getPartition();
		/*	Region region = partition.getOriginalRegion();
			if (region != null) {
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
			else if (node.isTrue()) {		// A <<success>> node * /
				NodeConnection connection = getIncomingUsedConnection(node);
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
		else { */
		List<@NonNull Connection> connections = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(partition)) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		for (@NonNull Node node : partition.getPartialNodes()) {
			/*			if (node.isDependency() || node.isPattern()) {
					if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
						NodeConnection connection = node.getIncomingUsedConnection();
						if ((connection != null) && !connections.contains(connection)) {
							connections.add(connection);
						}
					}
				}
				else if (node.isTrue()) {		// A <<success>> node */
			if (!node.isHead()) {
				NodeConnection connection = getIncomingUsedConnection(node);
				if ((connection != null) && !connections.contains(connection)) {
					connections.add(connection);
				}
			}
			//			}
		}
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (partitionAnalysis.isAwaited(edge) && edge.isNavigation()) {
				NavigationEdge navigationEdge = (NavigationEdge) edge;
				EdgeConnection connection = navigationEdge.getIncomingConnection();
				if ((connection != null) && !connections.contains(connection)) {
					connections.add(connection);
				}
			}
		}
		return connections;
		//	}
	}

	/**
	 * Return the regions that this region calls.
	 *
	public static @NonNull List<@NonNull Region> getCalledRegions(@NonNull Region region) {
		List<@NonNull Region> childRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection childConnection : getOutgoingPassedConnections(region)) {
			for (@NonNull Node childNode : getTargetNodes(childConnection)) {
				Region childRegion = QVTscheduleUtil.getOwningRegion(childNode);
				if (!childRegions.contains(childRegion)) {
					childRegions.add(childRegion);
				}
			}
		}
		return childRegions;
	} */

	public @NonNull Iterable<@NonNull NodeConnection> getIncomingPassedConnections(@NonNull Partition partition) {		// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(partition)) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if (connection != null) {
				connections.add(connection);
			}
		}
		return connections;
	}

	public @Nullable NodeConnection getIncomingUsedConnection(@NonNull Node node) {
		NodeConnection incomingConnection2 = node.getIncomingConnection();
		if ((incomingConnection2 != null) && isUsed(incomingConnection2, node)) {
			return incomingConnection2;
		}
		else {
			return null;
		}
	}

	/*	public @NonNull Iterable<@NonNull NodeConnection> getIncomingUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : region.getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = getIncomingUsedConnection(node);
				if (connection != null) {
					connections.add(connection);
				}
			}
		}
		return connections;
	} */

	private @Nullable Iterable<@NonNull Node> getIntroducingOrNewNodes(@NonNull Node headNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(headNode);
		if (!scheduleManager.getDomainUsage(classDatum).isInput()) {
			return originalContentsAnalysis.getNewNodes(classDatum);	// FIXME also dependsOn ??
		}
		List<@NonNull Node> nodes = new ArrayList<>();
		nodes.add(loadingRegionAnalysis.getIntroducerNode(headNode));
		for (@NonNull TypedModel dependsOn : QVTbaseUtil.getDependsOns(QVTscheduleUtil.getTypedModel(classDatum))) {
			ClassDatum classDatum2 = scheduleManager.getClassDatum(dependsOn, headNode.getCompleteClass().getPrimaryClass());
			Iterable<@NonNull Node> newNodes = originalContentsAnalysis.getNewNodes(classDatum2);
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

	public @NonNull List<@NonNull Connection> getLoopingConnections(@NonNull Partition partition) {
		List<@NonNull Connection> loopingConnections = new ArrayList<>();
		for (@NonNull Connection connection : getOutgoingConnections(partition)) {
			for (@NonNull Partition sourcePartition : getSourcePartitions(connection)) {
				if (partition == sourcePartition) {
					for (@NonNull Partition targetPartition : getTargetPartitions(connection)) {
						if ((partition == targetPartition) && !loopingConnections.contains(connection)) {
							loopingConnections.add(connection);
						}
					}
				}
			}
		}
		return loopingConnections;
	}

	private @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum requiredClassDatum) {
		return originalContentsAnalysis.getNewEdges(edge, requiredClassDatum);
	}

	private @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatum classDatum) {
		return originalContentsAnalysis.getNewNodes(classDatum);
	}

	/*	public @NonNull Iterable<@NonNull NodeConnection> getIncomingUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : region.getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = getIncomingUsedConnection(node);
				if (connection != null) {
					connections.add(connection);
				}
			}
		}
		return connections;
	} */

	/**
	 * Return all the next connections from this region to another region.
	 * Where this is a hierarchical region the connections are those from the hierarchical head to its immediate internal regions.
	 */
	public @NonNull Iterable<@NonNull Connection> getNextConnections(@NonNull Partition partition) {
		return getOutgoingConnections(partition);
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
			s.appendString(domainUsage.isInput() ? JOIN_INPUT_PREFIX : domainUsage.isOutput() ? JOIN_OUTPUT_PREFIX : JOIN_MIDDLE_PREFIX);
			s.appendString("_");
			s.appendName(classDatum.getCompleteClass().getName());
			connection = createNodeConnection(scheduledRegion, sourceSet, classDatum, s);
			nodes2connection.put(sourceSet, connection);
		}
		return connection;
	}

	/*	public @NonNull Iterable<@NonNull NodeConnection> getIncomingUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : region.getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = getIncomingUsedConnection(node);
				if (connection != null) {
					connections.add(connection);
				}
			}
		}
		return connections;
	} */

	/**
	 * Return all connections from this (hierarchical) region to another (hierarchical) region.
	 */
	public @NonNull List<@NonNull Connection> getOutgoingConnections(@NonNull Partition partition) {			// FIXME cache
		List<@NonNull Connection> connections = new ArrayList<>();
		//		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
		for (@NonNull Node node : partition.getPartialNodes()) {
			Role role = partition.getRole(node);
			if ((role != null) && !role.isAwaited()) { //(role.isNew() || role.isLoaded())) {
				for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
					connections.add(connection);
				}
				for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
					connections.add(connection);
				}
			}
		}
		//		for (@NonNull NavigableEdge edge : region.getNavigationEdges()) {
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (edge.isNavigation()) {
				Role role = partition.getRole(edge);
				if ((role != null) && !role.isAwaited()) { // (role.isNew() || role.isLoaded())) {
					for (@NonNull EdgeConnection connection : QVTscheduleUtil.getOutgoingConnections((NavigableEdge) edge)) {
						connections.add(connection);
					}
				}
			}
		}
		return connections;
	}

	/*	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	} */

	/*	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		return connections;
	} */

	//	public @NonNull PartitionedContentsAnalysis getPartitionedContentsAnalysis() {
	//		PartitionedContentsAnalysis partitionedContentsAnalysis2 = partitionedContentsAnalysis;
	//		if (partitionedContentsAnalysis2 == null) {
	//			partitionedContentsAnalysis = partitionedContentsAnalysis2 = new PartitionedContentsAnalysis(scheduleManager);
	//		}
	//		return partitionedContentsAnalysis2;
	//	}

	public @Nullable Role getRole(@NonNull Partition partition, @NonNull ConnectionEnd connectionEnd) {
		return connectionEnd instanceof Node ? partition.getRole((Node)connectionEnd) : connectionEnd instanceof Edge ? partition.getRole((Edge)connectionEnd) : null;
	}

	public @NonNull List<@NonNull NodeConnection> getRootConnections(@NonNull Partition partition) {
		List<@NonNull NodeConnection> rootConnections = partition2rootConnections.get(partition);
		if (rootConnections == null) {
			rootConnections = new ArrayList<>();
			partition2rootConnections.put(partition, rootConnections);
		}
		return rootConnections;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull Iterable<@NonNull Node> getPassedBindingSources(@NonNull Node node) {
		List<@NonNull Node> sources = new ArrayList<>();
		NodeConnection connection = node.getIncomingPassedConnection();
		if (connection != null) {
			for (@NonNull Node source : QVTscheduleUtil.getSourceEnds(connection)) {
				if (!sources.contains(source)) {
					sources.add(source);
				}
			}
		}
		return sources;
	}

	public @NonNull ConnectionEnd getSource(@NonNull Connection connection, @NonNull Partition sourcePartition) {
		@Nullable ConnectionEnd theSourceEnd = null;
		for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
			if (Iterables.contains(sourceRegionAnalysis.getPartitions(), sourcePartition)) {
				Role sourceRole = getRole(sourcePartition, sourceEnd);
				if ((sourceRole != null) && !sourceRole.isAwaited()) { //(sourceRole.isNew() || sourceRole.isLoaded())) {
					assert theSourceEnd == null;
					theSourceEnd = sourceEnd;
				}
			}
		}
		assert theSourceEnd != null;
		return theSourceEnd;
	}

	public @NonNull Node getSource(@NonNull NodeConnection nodeConnection, @NonNull Partition sourcePartition) {
		return (Node) getSource((Connection)nodeConnection, sourcePartition);
	}

	public @NonNull List<@NonNull ConnectionEnd> getSourceEnds(@NonNull Connection connection) {
		List<@NonNull ConnectionEnd> sourceEnds = QVTscheduleUtil.getSourceEnds(connection);
		return sourceEnds;
	}

	//	public @NonNull List<@NonNull NavigableEdge> getSourceEnds(@NonNull EdgeConnection edgeConnection) {
	//		return (List<@NonNull NavigableEdge>)(Object)getSourceEnds((Connection)edgeConnection);
	//	}

	//	public @NonNull List<@NonNull Node> getSourceEnds(@NonNull NodeConnection nodeConnection) {
	//		return (List<@NonNull Node>)(Object)getSourceEnds((Connection)nodeConnection);
	//	}

	public @NonNull Iterable<@NonNull Node> getSourceNodes(@NonNull Connection connection) {
		if (connection instanceof EdgeConnection) {
			return getSourceNodes((EdgeConnection)connection);
		}
		else {
			return getSourceNodes((NodeConnection)connection);
		}
	}

	public @NonNull Iterable<@NonNull Node> getSourceNodes(@NonNull EdgeConnection edgeConnection) {
		List<@NonNull Node> sourceNodes = new ArrayList<>();
		for (@NonNull NavigableEdge sourceEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEdge);
			RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
			Iterable<@NonNull Partition> partitions = sourceRegionAnalysis.basicGetPartitions();
			if (partitions != null) {
				for (@NonNull Partition sourcePartition : partitions) {
					Role sourceRole = getRole(sourcePartition, sourceEdge);
					if ((sourceRole != null) &&!sourceRole.isAwaited()) { // (sourceRole.isNew() || sourceRole.isLoaded())) {
						sourceNodes.add(QVTscheduleUtil.getTargetNode(sourceEdge));
					}
				}
			}
			else {
				Role sourceRole = sourceEdge.getEdgeRole();
				if (!sourceRole.isAwaited()) { //sourceRole.isNew() || sourceRole.isLoaded()) {
					sourceNodes.add(QVTscheduleUtil.getTargetNode(sourceEdge));
				}
			}
		}
		/*			edgeConnection.get
		for (@NonNull Partition sourcePartition : getSourcePartitions(edgeConnection)) {
			Role role = sourcePartition.getRole(sourceNode);
			if ((role != null) && (role.isNew() || role.isLoaded())) {

		}

		for (@NonNull NavigableEdge sourceEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEdge);
			if (sourceRegion != null) {
			Role role = sourcePartition.getRole(sourceNode);
			if ((role != null) && (role.isNew() || role.isLoaded())) {
			sourceNodes.add(sourceEdge.getEdgeTarget());
		} */
		return sourceNodes;
	}

	public @NonNull Iterable<@NonNull Node> getSourceNodes(@NonNull NodeConnection nodeConnection) {
		return QVTscheduleUtil.getSourceEnds(nodeConnection);
	}

	public @NonNull Iterable<@NonNull Partition> getSourcePartitions(@NonNull Connection connection) {
		Set<@NonNull Partition> sourcePartitions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
			for (@NonNull Partition sourcePartition : sourceRegionAnalysis.getPartitions()) {
				Role sourceRole = getRole(sourcePartition, sourceEnd);
				if ((sourceRole != null) && !sourceRole.isAwaited()) { // (sourceRole.isNew() || sourceRole.isLoaded())) {
					sourcePartitions.add(sourcePartition);
				}
			}
		}
		return sourcePartitions;
	}

	/*	public @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull Connection connection, @NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : getSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			sourceRegion = scheduledRegion.getNormalizedRegion(sourceRegion);
			if (sourceRegion != null) {
				sourceRegions.add(sourceRegion);
			}
		}
		return sourceRegions;
	} */

	//	public @NonNull Iterable<@NonNull ? extends ConnectionEnd> getSources(@NonNull Connection connection) {
	//		return getSourceEnds(connection);
	//	}

	//	public @NonNull Iterable<@NonNull NavigableEdge> getSources(@NonNull EdgeConnection edgeConnection) {
	//		return getSourceEnds(edgeConnection);
	//	}

	//	public @NonNull Iterable<@NonNull Node> getSources(@NonNull NodeConnection nodeConnection) {
	//		return getSourceEnds(nodeConnection);
	//	}

	//	public @NonNull Iterable<@NonNull ? extends ConnectionEnd> getSources(@NonNull Connection connection) {
	//		return getSourceEnds(connection);
	//	}

	//	public @NonNull Iterable<@NonNull NavigableEdge> getSources(@NonNull EdgeConnection edgeConnection) {
	//		return getSourceEnds(edgeConnection);
	//	}

	//	public @NonNull Iterable<@NonNull Node> getSources(@NonNull NodeConnection nodeConnection) {
	//		return getSourceEnds(nodeConnection);
	//	}

	/*	public @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull Connection connection, @NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : getSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			sourceRegion = scheduledRegion.getNormalizedRegion(sourceRegion);
			if (sourceRegion != null) {
				sourceRegions.add(sourceRegion);
			}
		}
		return sourceRegions;
	} */

	public @NonNull Type getSourcesType(@NonNull NodeConnection nodeConnection, @NonNull IdResolver idResolver) {
		//		System.out.println("commonType of " + this);
		Type commonType = null;
		for (@NonNull Node node : QVTscheduleUtil.getSourceEnds(nodeConnection)) {
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

	//	public @NonNull Iterable<@NonNull ? extends ConnectionEnd> getSources(@NonNull Connection connection) {
	//		return getSourceEnds(connection);
	//	}

	//	public @NonNull Iterable<@NonNull NavigableEdge> getSources(@NonNull EdgeConnection edgeConnection) {
	//		return getSourceEnds(edgeConnection);
	//	}

	//	public @NonNull Iterable<@NonNull Node> getSources(@NonNull NodeConnection nodeConnection) {
	//		return getSourceEnds(nodeConnection);
	//	}

	/*	public @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull Connection connection, @NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : getSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			sourceRegion = scheduledRegion.getNormalizedRegion(sourceRegion);
			if (sourceRegion != null) {
				sourceRegions.add(sourceRegion);
			}
		}
		return sourceRegions;
	} */

	/*	public @NonNull ConnectionEnd getTarget(@NonNull Connection connection, @NonNull Region targetRegion) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(connection);
		@Nullable ConnectionEnd targetEnd = null;
		for (@NonNull ConnectionEnd end : targetEnd2role.keySet()) {
			if (end.getOwningRegion() == targetRegion) {
				assert targetEnd == null;
				targetEnd = end;
			}
		}
		assert targetEnd != null;
		return targetEnd;
	} */

	/*	public @NonNull ConnectionEnd getTarget(@NonNull Connection connection, @NonNull Region targetRegion) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(connection);
		@Nullable ConnectionEnd targetEnd = null;
		for (@NonNull ConnectionEnd end : targetEnd2role.keySet()) {
			if (end.getOwningRegion() == targetRegion) {
				assert targetEnd == null;
				targetEnd = end;
			}
		}
		assert targetEnd != null;
		return targetEnd;
	} */

	public @NonNull Iterable<@NonNull ConnectionEnd> getTargetConnectionEnds(@NonNull Connection connection, @NonNull Partition targetPartition) {
		List<@NonNull ConnectionEnd> targetConnectionEnds = new ArrayList<>();
		Map<@NonNull ? extends ConnectionEnd, @NonNull ConnectionRole> target2role = getTargets(connection);
		for (@NonNull ConnectionEnd targetConnectionEnd : target2role.keySet()) {
			//	Region region = QVTscheduleUtil.getOwningRegion(targetConnectionEnd);
			//	RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(region);
			//	Iterable<@NonNull Partition> partitions = regionAnalysis.getPartitions();
			//	for (@NonNull Partition partition : partitions) {
			Role role = getRole(targetPartition, targetConnectionEnd);
			if ((role != null) && role.isOld()) {
				targetConnectionEnds.add(targetConnectionEnd);
			}
			//	}
		}
		return targetConnectionEnds;
	}

	public @NonNull ConnectionRole getTargetConnectionRole(@NonNull Connection connection, @NonNull Partition targetPartition, @NonNull ConnectionEnd connectionEnd) {
		Map<@NonNull ? extends ConnectionEnd, @NonNull ConnectionRole> target2role = getTargets(connection);
		ConnectionRole connectionRole = target2role.get(connectionEnd);
		assert connectionRole != null;
		if (connectionRole.isPassed()) {
			boolean isHead = targetPartition.isHead(connectionEnd);
			if (!isHead) {
				connectionRole = ConnectionRole.PREFERRED_NODE;
			}
		}
		return connectionRole;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getTargetEdges(@NonNull EdgeConnection edgeConnection) {
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(edgeConnection);
		return targetEnd2role.keySet();
	}

	private @NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> getTargetEnd2Role(@NonNull Connection connection) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = connection2targetEnd2role.get(connection);
		if (targetEnd2role == null) {
			targetEnd2role = new HashMap<>();
			connection2targetEnd2role.put(connection, targetEnd2role);
		}
		return targetEnd2role;
	}

	private @NonNull Map<@NonNull NavigableEdge, @NonNull ConnectionRole> getTargetEnd2Role(@NonNull EdgeConnection edgeConnection) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = connection2targetEnd2role.get(edgeConnection);
		if (targetEnd2role == null) {
			targetEnd2role = new HashMap<>();
			connection2targetEnd2role.put(edgeConnection, targetEnd2role);
		}
		@SuppressWarnings("unchecked")
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> castTargetEnd2role = (Map<@NonNull NavigableEdge, @NonNull ConnectionRole>)(Object)targetEnd2role;
		return castTargetEnd2role;
	}

	private @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargetEnd2Role(@NonNull NodeConnection nodeConnection) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = connection2targetEnd2role.get(nodeConnection);
		if (targetEnd2role == null) {
			targetEnd2role = new HashMap<>();
			connection2targetEnd2role.put(nodeConnection, targetEnd2role);
		}
		@SuppressWarnings("unchecked")
		Map<@NonNull Node, @NonNull ConnectionRole> castTargetEnd2role = (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)targetEnd2role;
		return castTargetEnd2role;
	}

	public @NonNull Iterable<@NonNull Node> getTargetNodes(@NonNull Connection connection) {
		if (connection instanceof EdgeConnection) {
			return getTargetNodes((EdgeConnection)connection);
		}
		else {
			return getTargetNodes((NodeConnection)connection);
		}
	}

	public @NonNull Iterable<@NonNull Node> getTargetNodes(@NonNull EdgeConnection edgeConnection) {
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(edgeConnection);
		List<@NonNull Node> targetNodes = new ArrayList<>();
		for (@NonNull NavigableEdge targetEdge : targetEnd2role.keySet()) {
			targetNodes.add(targetEdge.getEdgeTarget());
		}
		return targetNodes;
	}

	public @NonNull Iterable<@NonNull Node> getTargetNodes(@NonNull NodeConnection nodeConnection) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		return targetEnd2role.keySet();
	}

	/*	public @NonNull Set<@NonNull Partition> getTargetPartitions(@NonNull Connection connection) {
		Set<@NonNull Partition> targetPartitions = new HashSet<>();
		for (@NonNull ConnectionEnd targetEnd : getTargets(connection).keySet()) {
			Region targetRegion = QVTscheduleUtil.getOwningRegion(targetEnd);
			targetPartitions.add(scheduleManager.wipGetPartition(targetRegion));
		}
		return targetPartitions;
	} */
	public @NonNull Iterable<@NonNull Partition> getTargetPartitions(@NonNull Connection connection) {
		List<@NonNull Partition> targetPartitions = new ArrayList<>();
		for (@NonNull ConnectionEnd target : getTargets(connection).keySet()) {
			Region region = QVTscheduleUtil.getOwningRegion(target);
			RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(region);
			Iterable<@NonNull Partition> partitions = regionAnalysis.getPartitions();
			for (@NonNull Partition partition : partitions) {
				Role role = getRole(partition, target);
				if ((role != null) && role.isOld() && !targetPartitions.contains(partition)) {
					boolean skipPartionedHead = false;
					if (target instanceof Node) {
						if (((Node)target).isHead() && !partition.isHead(target)) {
							skipPartionedHead = true;
						}
					}
					if (!skipPartionedHead) {
						targetPartitions.add(partition);
					}
				}
			}
		}
		return targetPartitions;
	}

	public @NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> getTargets(@NonNull Connection connection) {
		//		if (connection instanceof NodeConnection) {
		//			return (Map<@NonNull CE, @NonNull ConnectionRole>) getTargets((NodeConnection)connection);
		//		}
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(connection);
		return targetEnd2role;
	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull EdgeConnection edgeConnection) {
	//		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull NavigableEdge, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull NodeConnection nodeConnection) {
	//		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	public @NonNull Iterable<@NonNull Node> getUsedBindingSources(@NonNull Node node) {
		List<@NonNull Node> sources = new ArrayList<>();
		NodeConnection connection = getIncomingUsedConnection(node);
		if (connection != null) {
			for (@NonNull Node source : QVTscheduleUtil.getSourceEnds(connection)) {
				if (!sources.contains(source)) {
					sources.add(source);
				}
			}
		}
		return sources;
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

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull EdgeConnection edgeConnection) {
	//		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull NavigableEdge, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull NodeConnection nodeConnection) {
	//		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	/**
	 * Return the regions that this region uses and how many times.
	 *
	public static @NonNull List<@NonNull NodeConnection> getUsedConnections(@NonNull Region region) {			// FIXME cache
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
	} */

	public boolean isEdge2Edge(@NonNull EdgeConnection edgeConnection) {
		List<NavigableEdge> sourceEnds = QVTscheduleUtil.getSourceEnds(edgeConnection);
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(edgeConnection);
		return (sourceEnds.size() == 1) && (targetEnd2role.size() == 1);
	}

	public boolean isNode2Node(@NonNull NodeConnection nodeConnection) {
		List<Node> sourceEnds = QVTscheduleUtil.getSourceEnds(nodeConnection);
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		return (sourceEnds.size() == 1) && (targetEnd2role.size() == 1);
	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull EdgeConnection edgeConnection) {
	//		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull NavigableEdge, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull NodeConnection nodeConnection) {
	//		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	public boolean isPassed(@NonNull Connection connection, @NonNull Partition targetPartition) {
		if (connection instanceof EdgeConnection) {
			return false;
		}
		else {
			if (Iterables.contains(getIncomingPassedConnections(targetPartition), connection)) {		// FIXME unify cyclic/non-cyclic
				return true;
			}
			Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role((NodeConnection)connection);
			for (@NonNull Node targetNode : targetEnd2role.keySet()) {
				if (!targetNode.isDependency() && targetPartition.isHead(targetNode)) {
					ConnectionRole role = targetEnd2role.get(targetNode);
					assert role != null;
					assert role.isPassed();
					return true;

				}
			}
			return false;
		}
	}

	/*	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	} */

	/*	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedConnections(@NonNull Region region) {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		return connections;
	} */



	//	public @NonNull Iterable<@NonNull ? extends ConnectionEnd> getSources(@NonNull Connection connection) {
	//		return getSourceEnds(connection);
	//	}

	//	public @NonNull Iterable<@NonNull NavigableEdge> getSources(@NonNull EdgeConnection edgeConnection) {
	//		return getSourceEnds(edgeConnection);
	//	}

	//	public @NonNull Iterable<@NonNull Node> getSources(@NonNull NodeConnection nodeConnection) {
	//		return getSourceEnds(nodeConnection);
	//	}

	/*	public @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull Connection connection, @NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : getSourceEnds(connection)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			sourceRegion = scheduledRegion.getNormalizedRegion(sourceRegion);
			if (sourceRegion != null) {
				sourceRegions.add(sourceRegion);
			}
		}
		return sourceRegions;
	} */

	/*	public @NonNull ConnectionEnd getTarget(@NonNull Connection connection, @NonNull Region targetRegion) {
		Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(connection);
		@Nullable ConnectionEnd targetEnd = null;
		for (@NonNull ConnectionEnd end : targetEnd2role.keySet()) {
			if (end.getOwningRegion() == targetRegion) {
				assert targetEnd == null;
				targetEnd = end;
			}
		}
		assert targetEnd != null;
		return targetEnd;
	} */



	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull EdgeConnection edgeConnection) {
	//		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull NavigableEdge, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	//	public static @NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets(@NonNull NodeConnection nodeConnection) {
	//		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = (Map<@NonNull Node, @NonNull ConnectionRole>)(Object)connection2targetEnd2role.get(nodeConnection);
	//		assert targetEnd2role != null;
	//		return targetEnd2role;
	//	}

	public boolean isRegion2Region(@NonNull Connection connection, @NonNull Map<@NonNull Region, @NonNull Integer> sourceRegion2count, @NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles) {
		return (sourceRegion2count.size() == 1) && (targetRegion2roles.size() == 1) && (targetRegion2roles.values().iterator().next().size() == 1); //(targetEnd2role.size() == 1);
	}

	public boolean isUsed(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		ConnectionRole targetConnectionRole = targetEnd2role.get(targetNode);
		assert targetConnectionRole != null;
		return targetConnectionRole.isPreferred();
	}

	private void mergeRole(@NonNull Connection connection, @NonNull ConnectionRole connectionRoleEnum) {
		//		assert connectionRole != null;
		if (connection.getConnectionRole() == ConnectionRole.UNDEFINED) {
			connection.setConnectionRole(connectionRoleEnum);
		}
		else if (connection.getConnectionRole() != connectionRoleEnum) {
			connection.setConnectionRole(connection.getConnectionRole().merge(connectionRoleEnum));
		}
	}

	public void removeCallToChild(@NonNull Partition parentPartition, @NonNull Partition childPartition) {
		getCallableChildren(parentPartition).remove(childPartition);
		getCallableParents(childPartition).remove(parentPartition);
	}

	/* 	public void removeSource(@NonNull NodeConnection nodeConnection, @NonNull Node sourceNode) {
		boolean wasRemoved = getSourceEnds(nodeConnection).remove(sourceNode);
		assert wasRemoved;
	} */

	private void removeTarget(@NonNull EdgeConnection edgeConnection, @NonNull NavigableEdge targetEdge) {
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(edgeConnection);
		ConnectionRole oldRole = targetEnd2role.remove(targetEdge);
		assert oldRole != null;
	}

	public void removeTarget(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		ConnectionRole oldRole = targetEnd2role.remove(targetNode);
		assert oldRole != null;
	}

	public void removeTargetRegion(@NonNull Connection connection, @NonNull Region targetRegion) {
		if (connection instanceof EdgeConnection) {
			removeTargetRegion((EdgeConnection)connection, targetRegion);
		}
		else {
			removeTargetRegion((NodeConnection)connection, targetRegion);
		}
	}

	public void removeTargetRegion(@NonNull EdgeConnection edgeConnection, @NonNull Region targetRegion) {
		for (@NonNull NavigableEdge targetEdge : Lists.newArrayList(getTargetEdges(edgeConnection))) {
			if (targetEdge.getOwningRegion() == targetRegion) {
				targetEdge.setIncomingConnection(null);
				removeTarget(edgeConnection, targetEdge);
			}
		}
		Map<@NonNull NavigableEdge, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(edgeConnection);
		if (targetEnd2role.isEmpty()) {
			destroy(edgeConnection);
		}
	}

	public void removeTargetRegion(@NonNull NodeConnection nodeConnection, @NonNull Region targetRegion) {
		Map<@NonNull Node, @NonNull ConnectionRole> targetEnd2role = getTargetEnd2Role(nodeConnection);
		for (@NonNull Node targetNode : Lists.newArrayList(getTargetNodes(nodeConnection))) {
			if (targetNode.getOwningRegion() == targetRegion) {
				targetNode.setIncomingConnection(null);
				removeTarget(nodeConnection, targetNode);
			}
		}
		if (targetEnd2role.isEmpty()) {
			destroy(nodeConnection);
		}
	}

	public void replaceCallToChild(@NonNull Partition parentPartition, @NonNull Partition oldPartition, @NonNull Partition newPartition) {
		List<@NonNull Partition> parentPartitionCallableChildren = getCallableChildren(parentPartition);
		int index = parentPartitionCallableChildren.indexOf(oldPartition);
		parentPartitionCallableChildren.remove(oldPartition);
		parentPartitionCallableChildren.add(index, newPartition);
		List<@NonNull Partition> oldPartitionCallableParents = getCallableParents(oldPartition);
		oldPartitionCallableParents.remove(parentPartition);
		oldPartitionCallableParents.add(parentPartition);
	}

	public void setCommonPartition(@NonNull NodeConnection nodeConnection, @NonNull Partition commonPartition, @NonNull List<@NonNull Partition> intermediatePartitions) {
		assert !connection2commonPartition.containsKey(nodeConnection);
		assert !connection2intermediatePartitions.containsKey(nodeConnection);
		connection2commonPartition.put(nodeConnection, commonPartition);
		connection2intermediatePartitions.put(nodeConnection, new ArrayList<>(intermediatePartitions));
		addRootConnection(commonPartition, nodeConnection);
		for (@NonNull Partition intermediatePartition : intermediatePartitions) {
			addIntermediateConnection(intermediatePartition, nodeConnection);
		}
		if (QVTscheduleConstants.CONNECTION_ROUTING.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append(nodeConnection.getSymbolName() + " common: " + commonPartition + " intermediate:");
			for (@NonNull Partition intermediatePartition : intermediatePartitions) {
				s.append(" " + intermediatePartition);
			}
			QVTscheduleConstants.CONNECTION_ROUTING.println(s.toString());
		}
	}
}
