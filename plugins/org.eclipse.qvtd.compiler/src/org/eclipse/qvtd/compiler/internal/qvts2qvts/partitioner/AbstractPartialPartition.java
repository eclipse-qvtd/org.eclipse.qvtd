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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleHeadAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

abstract class AbstractPartialPartition extends AbstractPartition
{
	/**
	 * The QVTr synthesis includes trace synthesis with activators and local/globalSuccess to interlink.
	 * The QVTc synthesis relies on the externally provided trace.
	 */
	protected final boolean hasSynthesizedTrace;

	protected final @NonNull String name;

	/**
	 * The nodes of region that are required by the partition and the nodeRole that each node plays in the partition.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Role> node2nodeRole = new HashMap<>();

	/**
	 * The nodes of region that are required by the partition. This is identical to node2nodeRole.keySet() but in a linear
	 * list to facilitate recursions over all nodes so far.
	 */
	private final @NonNull List<@NonNull Node> nodes = new ArrayList<>();

	/**
	 * The edges of region that are required by the partition and the edgeRole that each edge plays in the partition.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull Role> edge2edgeRole = new HashMap<>();

	/**
	 * The mechanisms to reach required nodes.
	 */
	private final @NonNull ReachabilityForest reachabilityForest;

	/**
	 * Explicitly specified predecessors for use by QVTc where there is no trace localSuccess linkage.
	 */
	private final @NonNull List<@NonNull Partition> explicitPredecessors = new ArrayList<>();

	private @Nullable MicroMappingRegion microMappingRegion = null;

	//	protected AbstractPartialPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
	//		super(partitioner);
	//		this.name = QVTscheduleUtil.getName(region);
	//		this.reachabilityForest = reachabilityForest;
	//	}

	protected AbstractPartialPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest, @NonNull String suffix) {
		super(partitioner);
		this.hasSynthesizedTrace = scheduleManager.useActivators();
		this.name = QVTscheduleUtil.getName(originalRegion) + suffix;
		this.reachabilityForest = reachabilityForest;
	}

	private void addEdge(@NonNull Edge edge, @NonNull Role newEdgeRole) {
		assert edge.getOwningRegion() == originalRegion;
		Role oldEdgeRole = QVTscheduleUtil.getEdgeRole(edge);
		switch (oldEdgeRole)
		{
			case CONSTANT: {
				assert newEdgeRole == Role.CONSTANT;
				break;
			}
			case LOADED: {
				assert newEdgeRole == Role.LOADED;
				break;
			}
			case PREDICATED: {
				assert (newEdgeRole == Role.PREDICATED) || (newEdgeRole == Role.SPECULATED);
				break;
			}
			case REALIZED: {
				if (!partitioner.hasRealizedEdge(edge)) {
					assert newEdgeRole == Role.REALIZED;
				}
				else if (this instanceof SpeculatingPartition) {
					assert (newEdgeRole == Role.PREDICATED) || (newEdgeRole == Role.SPECULATED);		// FIXME rationalize
				}
				else {
					assert newEdgeRole == Role.PREDICATED;
				}
				break;
			}
			default: {
				throw new UnsupportedOperationException(getClass().getSimpleName() + ".addEdge " + edge);
			}
		}
		partitioner.addEdge(edge, newEdgeRole, this);
		Role displacedEdgeRole = edge2edgeRole.put(edge, newEdgeRole);
		assert (displacedEdgeRole == null) || (displacedEdgeRole == newEdgeRole);
	}

	public void addExplicitPredecessor(@NonNull Partition speculationPartition) {
		explicitPredecessors.add(speculationPartition);
	}

	protected void addNode(@NonNull Node node) {
		Role oldNodeRole = QVTscheduleUtil.getNodeRole(node);
		addNode(node, oldNodeRole);
	}

	protected void addNode(@NonNull Node node, @NonNull Role newNodeRole) {
		assert node.getOwningRegion() == originalRegion;
		Role oldNodeRole = QVTscheduleUtil.getNodeRole(node);
		switch (oldNodeRole)
		{
			case CONSTANT: {
				assert newNodeRole == Role.CONSTANT;
				//				if (node.isTrue()) {
				//					partitioner.addTrueNode(node);
				//				}
				break;
			}
			case LOADED: {
				assert newNodeRole == Role.LOADED;
				break;
			}
			case SPECULATED: {
				assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
				//				partitioner.addSpeculatedNode(node);
				break;
			}
			case PREDICATED: {
				assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
				partitioner.addPredicatedNode(node);
				break;
			}
			case REALIZED: {
				if (!partitioner.hasRealizedNode(node)) {
					// FIXME QVTc fudge	assert newNodeRole == Role.REALIZED || newNodeRole == Role.SPECULATION;
					partitioner.addRealizedNode(node);
				}
				else {
					if (newNodeRole == Role.REALIZED || newNodeRole == Role.SPECULATION) {
						assert false;
						return;		// FIXME redundant call
					}
					assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
				}
				break;
			}
			default: {
				throw new UnsupportedOperationException(getClass().getSimpleName() + ".addNode " + node);
			}
		}
		Role displacedNodeRole = node2nodeRole.put(node, newNodeRole);
		assert (displacedNodeRole == null) || (displacedNodeRole == newNodeRole);
		nodes.add(node);
	}

	/**
	 * Return true of all required predecessor of targetNOde are available for use by this partition.
	 */
	protected boolean allPredecessorsAreAvailable(@NonNull Node targetNode) {
		List<@NonNull Node> requiredNodes = new ArrayList<>(nodes);
		requiredNodes.add(targetNode);
		Map<@NonNull Node, @NonNull Role> requiredNode2nodeRole = new HashMap<>();
		for (int i = 0; i < requiredNodes.size(); i++) {
			Node node = requiredNodes.get(i);
			assert node != null;
			Edge traceEdge = partitioner.getTraceEdge(node);
			if ((traceEdge == null) || !partitioner.hasRealizedEdge(traceEdge)) {
				for (@NonNull Node precedingNode : getPredecessors(node)) {
					if (!isAvailable(node)) {
						return false;
					}
					if (!requiredNode2nodeRole.containsKey(precedingNode)) {
						requiredNode2nodeRole.put(precedingNode, QVTscheduleUtil.getNodeRole(precedingNode));
						requiredNodes.add(precedingNode);
					}
				}
			}
		}
		/*		for (@NonNull Node requiredNode : requiredNodes) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(requiredNode)) {
				if (!requiredNode2nodeRole.containsKey(precedingNode)) {
					requiredNode2nodeRole.put(precedingNode, QVTscheduleUtil.getNodeRole(precedingNode));
					requiredNodes.add(precedingNode);
				}
			}
		} */
		return true;
	}

	/**
	 * Verify that all unconditional nodes in the new region are reachable from its heads.
	 */
	public void check(@NonNull MicroMappingRegion region) {
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		for (@NonNull Node node : QVTscheduleUtil.getHeadNodes(region)) {
			checkGatherReachables(reachableNodes, node);
		}
		Set<@NonNull Node> allNodes = Sets.newHashSet(QVTscheduleUtil.getOwnedNodes(region));
		if (!reachableNodes.equals(allNodes)) {
			Set<@NonNull Node> extraNodesSet = Sets.newHashSet(reachableNodes);
			CompilerUtil.removeAll(extraNodesSet, allNodes);
			for (@NonNull Node node : extraNodesSet) {
				partitioner.addProblem(CompilerUtil.createRegionWarning(region, "unexpected " + node));
			}
			Set<@NonNull Node> missingNodesSet = Sets.newHashSet(allNodes);
			missingNodesSet.removeAll(reachableNodes);
			for (@NonNull Node node : missingNodesSet) {
				if (!node.isConstant() && !node.isUnconditional()) {
					node.isUnconditional();
					partitioner.addProblem(CompilerUtil.createRegionWarning(region, "unreachable " + node));
				}
			}
		}
	}
	private void checkGatherReachables(@NonNull Set<@NonNull Node> reachableNodes, @NonNull Node node) {
		if (node instanceof OperationNode) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation() && !edge.isConstant()) {
					if (!reachableNodes.contains(edge.getEdgeSource())) {
						return;
					}
				}
			}
		}
		if (reachableNodes.add(node)) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (/*edge.isComputation() ||*/ edge.isCast() || edge.isNavigation()) {		// excludes only recursion
					checkGatherReachables(reachableNodes, edge.getEdgeSource());
				}
			}
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
				if (edge.isComputation() || edge.isCast() || edge.isNavigation()) {
					checkGatherReachables(reachableNodes, edge.getEdgeTarget());
				}
			}
		}
	}

	protected @NonNull MicroMappingRegion createMicroMappingRegion(@NonNull String namePrefix, @NonNull String symbolSuffix) {
		assert microMappingRegion  == null;
		assert !(originalRegion instanceof MicroMappingRegion);
		MicroMappingRegion partialRegion = createPartialRegion(namePrefix, symbolSuffix);
		PartitioningVisitor partitioningVisitor = createPartitioningVisitor(partialRegion);
		originalRegion.accept(partitioningVisitor);
		MicroMappingRegion microMappingRegion = partialRegion;//partitioningVisitor.getRegion();
		Iterable<@NonNull Node> preferredHeadNodes = getPreferredHeadNodes();
		List<@NonNull Node> partialPreferredHeadNodes = null;
		if (preferredHeadNodes != null) {
			partialPreferredHeadNodes = new ArrayList<>();
			for (@NonNull Node preferredNode : preferredHeadNodes) {
				partialPreferredHeadNodes.add(partitioningVisitor.getNode(preferredNode));
			}
		}
		Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRuleHeadNodes(scheduleManager, microMappingRegion, partialPreferredHeadNodes);
		Iterables.addAll(QVTscheduleUtil.Internal.getHeadNodesList(microMappingRegion), headNodes);


		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		check(microMappingRegion);
		this.microMappingRegion = microMappingRegion;
		return microMappingRegion;
	}

	protected @NonNull MicroMappingRegion createPartialRegion(@NonNull String namePrefix, @NonNull String symbolSuffix) {
		MicroMappingRegion partialRegion = QVTscheduleFactory.eINSTANCE.createMicroMappingRegion();
		scheduleManager.addMappingRegion(partialRegion);
		partialRegion.setMappingRegion((MappingRegion) originalRegion);
		partialRegion.setNamePrefix(namePrefix);
		partialRegion.setSymbolNameSuffix(symbolSuffix);
		partialRegion.setName(namePrefix + " " + originalRegion.getName());
		return partialRegion;
	}

	protected @NonNull PartitioningVisitor createPartitioningVisitor(@NonNull MicroMappingRegion partialRegion) {
		return new PartitioningVisitor(new RegionHelper<>(scheduleManager, partialRegion), this);
	}

	@Override
	public @NonNull List<@NonNull Partition> getExplicitPredecessors() {
		return explicitPredecessors;
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return partitioner.getTraceNodes();
	}

	@Override
	public @NonNull MappingRegion getMicroMappingRegion() {
		return ClassUtil.nonNullState(microMappingRegion);
	}

	@Override
	public @NonNull String getName() {		// FIXME Bad RegionHelper override
		return name;
	}

	/**
	 * Return all the original region nodes that contribute to the partition.
	 */
	protected @NonNull Iterable<@NonNull Node> getNodes() {
		return node2nodeRole.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return edge2edgeRole.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return getNodes();
	}

	protected @NonNull Iterable<@NonNull Node> getPredecessors(@NonNull Node targetNode) {
		return reachabilityForest.getPredecessors(targetNode);
	}

	/**
	 * Return a prioritized hint for the choice of head nodes.
	 * The default implementation returns the trace nodes.
	 */
	protected @Nullable Iterable<@NonNull Node> getPreferredHeadNodes() {
		return partitioner.getTraceNodes();
	}

	/**
	 * Return the role that the original region's edge plays in the partition. Null for none.
	 */
	@Override
	public @Nullable Role getRole(@NonNull Edge edge) {
		return edge2edgeRole.get(edge);
	}

	/**
	 * Return the role that the original region's node plays in the partition. Null for none.
	 */
	@Override
	public @Nullable Role getRole(@NonNull Node node) {
		return node2nodeRole.get(node);
	}

	/**
	 * Return true if the original region edge contributes to the partition.
	 */
	private boolean hasEdge(@NonNull Edge edge) {
		return edge2edgeRole.containsKey(edge);
	}

	/**
	 * Return true if the original region node contributes to the partition.
	 */
	protected boolean hasNode(@NonNull Node node) {
		return node2nodeRole.containsKey(node);
	}

	/**
	 * Return true if edge is available for use by this partition.
	 * The default implementation returns true for all old edges.
	 */
	protected boolean isAvailable(@NonNull Edge edge) {
		return edge.isOld();
	}

	/**
	 * Return true if node is available for use by this partition.
	 * The default implementation returns true for all old nodes.
	 */
	protected boolean isAvailable(@NonNull Node node) {
		return node.isOld();
	}

	@Override
	protected boolean isConstant(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isConstant() : false; //edge.isConstant();
	}

	@Override
	protected boolean isConstant(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isConstant() : false; //node.isConstant();
	}

	@Override
	protected boolean isLoaded(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isLoaded() : false; //edge.isLoaded();
	}

	@Override
	protected boolean isLoaded(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isLoaded() : false; //node.isLoaded();
	}

	@Override
	protected boolean isPredicated(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isPredicated() : false; //edge.isPredicated();
	}

	@Override
	protected boolean isPredicated(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isPredicated() : false; //node.isPredicated();
	}

	@Override
	protected boolean isRealized(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isRealized() : false; //edge.isRealized();
	}

	@Override
	protected boolean isRealized(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isRealized() : false; //node.isRealized();
	}

	@Override
	protected boolean isSpeculated(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isSpeculated() : false; //edge.isSpeculated();
	}

	@Override
	protected boolean isSpeculated(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isSpeculated() : false; //node.isSpeculated();
	}

	@Override
	protected boolean isSpeculation(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isSpeculation() : false; //node.isSpeculation();
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}

	protected void resolveDisambiguations() {
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			TraceClassAnalysis<@NonNull RegionAnalysis> traceClassAnalysis = partitioner.getTraceClassAnalysis(traceNode);
			Iterable<@NonNull Property> discriminatingProperties = traceClassAnalysis.getDiscriminatingProperties();
			if (discriminatingProperties != null) {
				for (@NonNull Property property : discriminatingProperties) {
					Node targetNode = traceNode.getNavigableTarget(property);
					assert targetNode != null;
					if (!hasNode(targetNode)) {
						addNode(targetNode);
					}
				}
			}
		}
	}

	/**
	 * Determine the appropriate new edgeRole for the edge between nodes with new SourceNoeRole and targetNodeRole.
	 * May return null for an edge that is not required.
	 *
	 * The default implementation accepts all edges just changing REALIZED to PREDICATED for already realized edges.
	 */
	protected abstract @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole);

	/**
	 * Resolve all the original region edges by adding to the partition provided the nodes at each end have already been added.
	 * The addition is mediated by resolveEdgeRole that may adjust the edgeRole or suppress the addition.
	 */
	protected void resolveEdges() {
		//
		//	Add all the edges necessary to reach each node.
		//
		for (@NonNull Node node : node2nodeRole.keySet()) {
			if (node.isOperation()) {
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
					if ((edge.isExpression() || edge.isNavigation()) && !hasEdge(edge)) {
						Role sourceNodeRole = node2nodeRole.get(edge.getEdgeSource());
						if (sourceNodeRole != null) {
							Role targetNodeRole = node2nodeRole.get(edge.getEdgeTarget());
							if (targetNodeRole != null) {
								Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
								if (edgeRole != null) {
									if (edgeRole == Role.REALIZED) {
										if (partitioner.hasRealizedEdge(edge)) {
											edgeRole = null;
										}
									}
									if (edgeRole != null) {
										addEdge(edge, edgeRole);
									}
								}
							}
						}
					}
				}
			}
			else {
				Edge edge = reachabilityForest.getReachingEdge(node);
				if ((edge != null) && !hasEdge(edge)) {
					assert /*!edge.isSecondary() &&*/ !hasEdge(edge);
					Role sourceNodeRole = node2nodeRole.get(edge.getEdgeSource());
					if (sourceNodeRole != null) {
						Role targetNodeRole = node2nodeRole.get(edge.getEdgeTarget());
						if (targetNodeRole != null) {
							Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
							if (edgeRole != null) {
								if (edgeRole == Role.REALIZED) {
									if (partitioner.hasRealizedEdge(edge)) {
										edgeRole = null;
									}
								}
								if (edgeRole != null) {
									addEdge(edge, edgeRole);
								}
							}
						}
					}
				}
			}
		}
		//
		//	Add all the other edges whose redundancy must be checked, unless they have already been checked.
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(originalRegion)) {
			//	for (@NonNull Edge edge : getPartialEdges()) {
			if (!edge.isSecondary() && !hasEdge(edge)) {
				Role sourceNodeRole = node2nodeRole.get(edge.getEdgeSource());
				if (sourceNodeRole != null) {
					Role targetNodeRole = node2nodeRole.get(edge.getEdgeTarget());
					if (targetNodeRole != null) {
						Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
						if (edgeRole != null) {
							if (edgeRole == Role.REALIZED) {
								if (partitioner.hasRealizedEdge(edge)) {
									edgeRole = null;
								}
							}
							else if (edge.isCast() || edge.isNavigation()) {
								if (partitioner.hasRealizedEdge(edge)) {
									edgeRole = null;			// A realized edge does not need to be checked
								}
								else if (partitioner.hasPredicatedEdge(edge)) {
									edgeRole = null;			// An already predicated edge does not need to be checked
								}
								else if (partitioner.hasLoadedEdge(edge)) {
									edgeRole = null;			// An already loaded edge does not need to be checked
								}
								else if (partitioner.hasConstantEdge(edge)) {
									edgeRole = null;			// An already constant edge does not need to be checked
								}
								else {
									// FIXME iff the redundant edge is provably to-1 redundant omit it
								}
							}
							if (edgeRole != null) {
								addEdge(edge, edgeRole);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Ensure that the predecessors of each node are included in the partition.
	 */
	protected void resolvePrecedingNodes() {
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			assert node != null;
			Edge traceEdge = partitioner.getTraceEdge(node);
			Node sourceNode = traceEdge != null ? QVTscheduleUtil.getSourceNode(traceEdge) : null;
			boolean hasSourceNode = (sourceNode != null) && hasNode(sourceNode);
			if ((traceEdge == null) || !partitioner.hasRealizedEdge(traceEdge) || !hasSourceNode) {
				boolean gotOne = false;
				for (@NonNull Node precedingNode : getPredecessors(node)) {
					gotOne = true;
					if (!hasNode(precedingNode)) {
						addNode(precedingNode, partitioner.hasRealizedNode(precedingNode) ? Role.PREDICATED : QVTscheduleUtil.getNodeRole(precedingNode));
					}
				}
				if (!gotOne && (traceEdge != null) && traceEdge.isRealized()) {
					gotOne = true;
					if (!hasSourceNode) {
						assert sourceNode != null;
						addNode(sourceNode);
					}
				}
				//	Integer cost = reachabilityForest.getCost(node);
				//				assert cost != null;
				/*				if (!gotOne && (cost != null) && (cost > 0)) {
					getClass();
					for (@NonNull Node precedingNode : getPredecessors(node)) {		// FIXME debugging
						if (!hasNode(precedingNode)) {
							addNode(precedingNode);
						}
					}
					assert gotOne;
				} */
			}
		}
	}
}