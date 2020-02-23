/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * ReachabilityPartitioningStrategy partitions in accordance with the reachability and dependencies avoiding
 * any special heuristics for when/where/....
 */
public class ReachabilityPartitioningStrategy extends AbstractPartitioningStrategy
{
	protected abstract static class AbstractReachabilityPartitionFactory extends AbstractSimplePartitionFactory
	{
		/**
		 * The strategy that supervises the partition and accumulates the novelties.
		 */
		protected final @NonNull ReachabilityPartitioningStrategy strategy;

		/**
		 * The name for the partition.
		 */
		protected final @NonNull String name;

		/**
		 * The depth and reachability of nodes in the partition.
		 */
		protected final @NonNull ReachabilityForest reachabilityForest;

		/**
		 * The nodes from the partitioned region that are the pattern match entry points for this partition.
		 */
		protected final @NonNull Iterable<@NonNull ? extends Node> headNodes;

		/**
		 * The nodes that must appear in the partitioned region and which do not appear in a preceding partition.
		 */
		protected final @Nullable Iterable<@NonNull ? extends Node> novelNodes;

		/**
		 * The edges that must appear in the partitioned region and which do not appear in a preceding partition.
		 */
		protected final @Nullable Iterable<@NonNull ? extends Edge> novelEdges;

		/**
		 * The partition factories for the partitions that precede this partition.
		 */
		private final @NonNull UniqueList<@NonNull AbstractReachabilityPartitionFactory> predecessors = new UniqueList<>();

		/**
		 * The nodes from the partitioned region that are to appear in this partition.
		 */
		private final @NonNull List<@NonNull Node> reachableNodes = new ArrayList<>();

		/**
		 * The edges from the partitioned region that are to appear in this partition.
		 */
		private final @NonNull List<@NonNull Edge> reachableEdges = new ArrayList<>();

		protected AbstractReachabilityPartitionFactory(@NonNull ReachabilityPartitioningStrategy strategy, @NonNull ReachabilityForest reachabilityForest,
				@NonNull Iterable<@NonNull ? extends Node> headNodes, @Nullable Iterable<@NonNull ? extends Node> novelNodes, @Nullable Iterable<@NonNull ? extends Edge> novelEdges) {
			super(strategy.mappingPartitioner);
			this.strategy = strategy;
			strategy.setCurrentPartitionFactory(this);
			this.name = computeName(ClassUtil.nonNullState(reachabilityForest.getDisambiguator()));
			this.reachabilityForest = reachabilityForest;
			this.headNodes = headNodes;
			this.novelNodes = novelNodes;
			this.novelEdges = novelEdges;
			if (novelNodes != null) {
				for (@NonNull Node node : novelNodes) {
					addReachableNode(node);
				}
			}
			if (novelEdges != null) {
				for (@NonNull Edge edge : novelEdges) {
					addReachableEdge(edge);
				}
			}
		}

		public void addPredecessor(@NonNull AbstractReachabilityPartitionFactory predecessor) {
			predecessors.add(predecessor);
		}

		/**
		 * Add edge and its source/targert nodes to the partition.
		 *
		 * Returns true if edge added, false if already present.
		 */
		private boolean addReachableEdge(@NonNull Edge edge) {
			if (reachableEdges.contains(edge)) {
				return false;
			}
			addReachableNode(QVTscheduleUtil.getSourceNode(edge));
			addReachableNode(QVTscheduleUtil.getTargetNode(edge));
			reachableEdges.add(edge);
			strategy.addEdge(this, edge);
			return true;
		}

		private void addReachableEdgeAndOpposite(@NonNull Edge reachingEdge) {
			addReachableEdge(reachingEdge);
			if (reachingEdge.isNavigable()) {
				Edge oppositeEdge = ((NavigationEdge)reachingEdge).getOppositeEdge();
				if (oppositeEdge != null) {
					addReachableEdge(oppositeEdge);
				}
			}
		}

		/**
		 * Add node and all transitively preceding nodes to the partition.
		 *
		 * Returns true if node added, false if already present.
		 */
		private boolean addReachableNode(@NonNull Node node) {
			if (reachableNodes.contains(node)) {
				return false;
			}
			reachableNodes.add(node);
			strategy.addNode(this, node);
			for (@NonNull Node predecessor : reachabilityForest.getPredecessorsClosure(node)) {
				addReachableNode(predecessor);
			}
			return true;
		}

		/**
		 * Create the partition and populate it with the edges and nodes identified by the reaachableEdges and reachableNodes.
		 */
		@Override
		public @NonNull PartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
			//	Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(region);
			BasicPartition partition = createBasicPartition(name, headNodes);
			for (@NonNull Node node : reachableNodes) {
				Role role = resolveNodeRole(node);
				addNode(partition, node, role);
			}
			for (@NonNull Edge edge : reachableEdges) {
				if (!edge.isSecondary()) {
					Role role = resolveEdgeRole(edge);
					addEdge(partition, edge, role);
				}
			}



			//	Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(region);
			//	BasicPartition partition = createBasicPartition(name, headNodes);
			BasicPartitionAnalysis basicPartitionAnalysis = new BasicPartitionAnalysis(partitionedTransformationAnalysis, partition, reachabilityForest, "xyzzy", "xyzzy");
			//	initializePartition(basicPartitionAnalysis);
			if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
				scheduleManager.writeDebugGraphs(partition, null);
			}
			return basicPartitionAnalysis;
		}

		protected void initPartitionFactory() {
			//
			//	Grow the nodes to include all not-yet reached reachable nodes.
			//
			for (int i = 0; i < reachableNodes.size(); i++) {
				@NonNull Node sourceNode = reachableNodes.get(i);
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					AbstractReachabilityPartitionFactory targetPartitionFactory = strategy.basicGetPartitionFactory(targetNode);
					if (targetPartitionFactory == null) {
						if (edge.isLoaded()) {
							addReachableNode(targetNode);
						}
					}
				}
			}
			//
			//	Add the edges to nodes to include all not-yet reached reachable nodes.
			//
			for (@NonNull Node targetNode : reachableNodes) {
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					AbstractReachabilityPartitionFactory sourcePartitionFactory = strategy.basicGetPartitionFactory(sourceNode);
					if ((sourcePartitionFactory != null) && reachableNodes.contains(sourceNode)) {
						addReachableEdge(edge);
						if (sourcePartitionFactory != this) {
							addPredecessor(sourcePartitionFactory);
						}
					}
				}
			}
		}

		protected void initPartitionFactoryAsJustReachables() {
			//
			//	Grow the edges to include all necessary reaching edges.
			//
			for (int i = 0; i < reachableNodes.size(); i++) {
				Node node = reachableNodes.get(i);
				for (@NonNull Edge reachingEdge : reachabilityForest.getReachingEdges(node)) {
					addReachableEdgeAndOpposite(reachingEdge);
				}
			}
			for (int i = 0; i < reachableEdges.size(); i++) {
				Edge edge = reachableEdges.get(i);
				for (@NonNull Edge reachingEdge : reachabilityForest.getReachingEdges(QVTscheduleUtil.getSourceNode(edge))) {
					addReachableEdgeAndOpposite(reachingEdge);
				}
				for (@NonNull Edge reachingEdge : reachabilityForest.getReachingEdges(QVTscheduleUtil.getTargetNode(edge))) {
					addReachableEdgeAndOpposite(reachingEdge);
				}
			}
		}

		protected @NonNull Role resolveEdgeRole(@NonNull Edge edge) {
			Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
			if ((edgeRole == Role.REALIZED) && (strategy.getPartitionFactory(edge) != this)) {
				return Role.PREDICATED;
			}
			return edgeRole;
		}

		@Override
		protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
			if (mappingPartitioner.hasRealizedEdge(edge)) {
				return Role.PREDICATED;
			}
			Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
			//	if (edgeRole == Role.REALIZED) {
			//		assert !mappingPartitioner.hasRealizedEdge(edge);
			//	}
			return edgeRole;
		}

		protected @NonNull Role resolveNodeRole(@NonNull Node node) {
			Role nodeRole = QVTscheduleUtil.getNodeRole(node);
			if ((nodeRole == Role.REALIZED) && (strategy.getPartitionFactory(node) != this)) {
				return Role.PREDICATED;
			}
			return nodeRole;
		}

		@Override
		public @NonNull String toString() {
			return toString(new StringBuilder(), "\n");
		}

		public @NonNull String toString(@NonNull StringBuilder s, @NonNull String prefix) {
			s.append(name);
			s.append(prefix + "\tpredecessors: ");
			for (@NonNull AbstractReachabilityPartitionFactory predecessor : predecessors) {
				s.append(" " + predecessor.name);
			}
			Iterable<@NonNull ? extends Node> novelNodes2 = novelNodes;
			if (novelNodes2 != null) {
				s.append(prefix + "\tnovel nodes");
				for (@NonNull Node node : novelNodes2) {
					s.append(prefix + "\t\t" + node);
				}
			}
			Iterable<@NonNull ? extends Edge> novelEdges2 = novelEdges;
			if (novelEdges2 != null) {
				s.append(prefix + "\tnovel edges");
				for (@NonNull Edge edge : novelEdges2) {
					s.append(prefix + "\t\t" + edge);
				}
			}
			s.append(prefix + "\treachable nodes");
			for (@NonNull Node node : reachableNodes) {
				s.append(prefix + "\t\t" + node);
			}
			s.append(prefix + "\treachable edges");
			for (@NonNull Edge edge : reachableEdges) {
				s.append(prefix + "\t\t" + edge);
			}
			return s.toString();
		}
	}

	/**
	 * The CtorPartitionFactory creates the trace node and links to the head node(s). If there are multiple
	 * headnodes, inter-head edges are also added so that once the ctor partition is hoisted into the caller,
	 * the caller may improve performance by considering only appropriately inter-related heads.
	 */
	protected static class CtorPartitionFactory extends AbstractReachabilityPartitionFactory
	{
		protected CtorPartitionFactory(@NonNull ReachabilityPartitioningStrategy strategy, @NonNull ReachabilityForest reachabilityForest,
				@NonNull Iterable<@NonNull ? extends Node> headNodes, @NonNull Iterable<@NonNull ? extends Node> novelNodes, @NonNull Iterable<@NonNull ? extends Edge> novelEdges) {
			super(strategy, reachabilityForest, headNodes, novelNodes, novelEdges);
			//	initPartitionFactory();						// no magic growth
		}

		@Override
		protected void initPartitionFactory() {
			throw new UnsupportedOperationException();		// All done in constructor, no magic growth.
		}

		@Override
		protected @NonNull Role resolveNodeRole(@NonNull Node node) {
			Role nodeRole = node.getNodeRole();
			if (nodeRole == Role.REALIZED) {
				return Role.SPECULATION;
			}
			return super.resolveNodeRole(node);
		}
	}

	/**
	 * The InitPartitionFactory checks all predicates that can be established independent of the success of concurrent partitions.
	 * The local success is assigned on completion.
	 */
	protected static class InitPartitionFactory extends AbstractReachabilityPartitionFactory
	{
		protected InitPartitionFactory(@NonNull ReachabilityPartitioningStrategy strategy, @NonNull ReachabilityForest reachabilityForest,
				@NonNull Iterable<@NonNull ? extends Node> headNodes, @NonNull Iterable<@NonNull ? extends Node> novelNodes) {
			super(strategy, reachabilityForest, headNodes, novelNodes, null);
			initPartitionFactory();
		}

		@Override
		protected @NonNull Role resolveNodeRole(@NonNull Node node) {
			if (node.isTrace()) {
				return Role.SPECULATED;
			}
			return super.resolveNodeRole(node);
		}
	}

	/**
	 * The LoopPartitionFactory defines the decision stage in the execution.
	 *
	 * The preceding CtorPartitionFactory creates the trace. Then the preceding InitPartitionFactory checks all
	 * predicates that are dependent solely on earlier executing partitions.
	 *
	 * The LoopPartitionFactory checks the remaining non-corrolary predicates that have cyclic dependencies on
	 * concurrently executing partitions. Once cycle execution has been validated, success is assigned true, and
	 * all remaining realized nodes are created.
	 *
	 * Thereafter the RestPartitionFactory instances realize edges that are predicated solely on corrolary
	 * predicates.
	 */
	protected static class LoopPartitionFactory extends AbstractReachabilityPartitionFactory
	{
		protected LoopPartitionFactory(@NonNull ReachabilityPartitioningStrategy strategy, @NonNull ReachabilityForest reachabilityForest,
				@NonNull Iterable<@NonNull ? extends Node> headNodes, @NonNull Iterable<@NonNull ? extends Node> novelNodes, @NonNull Iterable<@NonNull ? extends Edge> novelEdges) {
			super(strategy, reachabilityForest, headNodes, novelNodes, novelEdges);
			initPartitionFactory();
		}

		@Override
		protected @NonNull Role resolveEdgeRole(@NonNull Edge edge) {
			CyclicRegionAnalysis cyclicRegionAnalysis = strategy.basicGetCyclicRegionAnalysis();
			if (cyclicRegionAnalysis != null) {
				if ((edge.getEdgeRole() == Role.PREDICATED) && (edge instanceof SuccessEdge)) {
					assert !edge.isSecondary();
					SuccessEdge navigationEdge = (SuccessEdge) edge;
					PropertyDatum propertyDatum = strategy.scheduleManager.getPropertyDatum(navigationEdge);
					if (cyclicRegionAnalysis.isCyclic(propertyDatum)) {
						Node targetNode = QVTscheduleUtil.getTargetNode(navigationEdge);
						if ((targetNode instanceof BooleanLiteralNode) && ((BooleanLiteralNode)targetNode).isBooleanValue()) {
							return Role.SPECULATED;
						}
					}
				}
			}
			return super.resolveEdgeRole(edge);
		}

		@Override
		protected @NonNull Role resolveNodeRole(@NonNull Node node) {
			if (node.isTrace()) {
				return Role.SPECULATED;
			}
			if (node == strategy.localSuccessNode) {
				return Role.CONSTANT_SUCCESS_TRUE;
			}
			return super.resolveNodeRole(node);
		}
	}

	protected static class RestPartitionFactory extends AbstractReachabilityPartitionFactory
	{
		protected RestPartitionFactory(@NonNull ReachabilityPartitioningStrategy strategy, @NonNull ReachabilityForest reachabilityForest,
				@NonNull Iterable<@NonNull ? extends Node> headNodes, @NonNull Iterable<@NonNull ? extends Node> novelNodes, @NonNull Iterable<@NonNull ? extends Edge> novelEdges) {
			super(strategy, reachabilityForest, headNodes, novelNodes, novelEdges);
			initPartitionFactory();
		}

		@Override
		protected void initPartitionFactory() {
			initPartitionFactoryAsJustReachables();
		}

		@Override
		protected @NonNull Role resolveNodeRole(@NonNull Node node) {
			if (node instanceof SuccessNode) {
				return Role.CONSTANT_SUCCESS_TRUE;
			}
			return super.resolveNodeRole(node);
		}
	}

	protected static class XtraPartitionFactory extends AbstractReachabilityPartitionFactory
	{
		protected XtraPartitionFactory(@NonNull ReachabilityPartitioningStrategy strategy, @NonNull ReachabilityForest reachabilityForest,
				@NonNull Iterable<@NonNull ? extends Node> headNodes, @NonNull Iterable<@NonNull ? extends Node> novelNodes, @NonNull Iterable<@NonNull ? extends Edge> novelEdges) {
			super(strategy, reachabilityForest, headNodes, novelNodes, novelEdges);
			initPartitionFactory();
		}

		@Override
		protected void initPartitionFactory() {
			initPartitionFactoryAsJustReachables();
		}

		@Override
		protected @NonNull Role resolveNodeRole(@NonNull Node node) {
			if (node instanceof SuccessNode) {
				return Role.CONSTANT_SUCCESS_TRUE;
			}
			return super.resolveNodeRole(node);
		}
	}

	/**
	 * The region to be partitioned,
	 */
	protected final @NonNull Region region;

	/**
	 * The nodes in the synthesized region. Excludes the additional localSuccess node.
	 */
	private final @NonNull Iterable<@NonNull Node> originalNodes;

	/**
	 * The edges in the synthesized region. Excludes the additional localSuccess edge.
	 */
	private final @NonNull Iterable<@NonNull Edge> originalEdges;

	// FIXME Merge state into mappingPartitioner once other factories obsolete.
	/**
	 * The ordered list of all ProtoPartition to support the Region.
	 */
	private final @NonNull List<@NonNull AbstractReachabilityPartitionFactory> partitionFactories = new ArrayList<>();

	/**
	 * Mapping from each Region node to the first ProtoPartition in which the node is used.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull AbstractReachabilityPartitionFactory> node2partitionFactory = new HashMap<>();

	/**
	 * Mapping from each Region edge to the first ProtoPartition in which the edge is used.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull AbstractReachabilityPartitionFactory> edge2partitionFactory = new HashMap<>();

	/**
	 * The node that represemts the transformation instance.
	 */
	//	private final @Nullable Node thisNode;

	/**
	 * The node that traces the region execution.
	 *
	 * Currently always a node. If multiple nodes are ever needed for a merge we will probably need
	 * to actually merge the trace and so again have just one trace node.
	 */
	//	private final @NonNull Node traceNode;

	private final @NonNull Iterable<@NonNull Node> thisAndTraceNodes;

	/**
	 * The loop/global success node that is realized in the region.
	 */
	private final @NonNull SuccessNode globalSuccessNode;

	/**
	 * The init/local success edge that is realized in the region.
	 */
	private @Nullable SuccessEdge localSuccessEdge = null;
	private @Nullable SuccessNode localSuccessNode = null;

	/**
	 * The realized success of the dispatch node, if any.
	 */
	private @Nullable Edge dispatchSuccessEdge = null;

	//	private @Nullable List<@NonNull Node> constantSourceNodes;

	private @NonNull List<@NonNull Node> thisAndTraceAndConstantSourceNodes = new ArrayList<>();

	private @Nullable AbstractReachabilityPartitionFactory currentPartitionFactory = null;

	public ReachabilityPartitioningStrategy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull MappingPartitioner mappingPartitioner) {
		super(partitionedTransformationAnalysis, mappingPartitioner);
		assert scheduleManager.useActivators();
		this.region = regionAnalysis.getRegion();
		this.originalNodes = Lists.newArrayList(QVTscheduleUtil.getOwnedNodes(region));
		this.originalEdges = Lists.newArrayList(QVTscheduleUtil.getOwnedEdges(region));
		SuccessNode globalSuccessNode = null;
		Node thisNode = null;
		Node traceNode = null;
		Node dispatchNode = null;
		for (@NonNull Node node : originalNodes) {
			if (node.isThis()) {
				assert thisNode == null : "Only one this node permitted in " + region.getName();
				thisNode = node;
				thisAndTraceAndConstantSourceNodes.add(node);
			}
			else if (node.isTrace()) {
				assert traceNode == null : "Only one trace node permitted in " + region.getName();
				traceNode = node;
				thisAndTraceAndConstantSourceNodes.add(node);
			}
			else if (node.isDispatch()) {
				assert dispatchNode == null : "Only one dispatch node permitted in " + region.getName();
				dispatchNode = node;
			}
			else if (node.isSuccess()) {
				assert globalSuccessNode == null : "Only one success node permitted in " + region.getName();
				globalSuccessNode = (SuccessNode)node;
			}
			else if (node.isConstant() && Iterables.isEmpty(node.getIncomingEdges())) {
				thisAndTraceAndConstantSourceNodes.add(node);
			}
		}
		assert globalSuccessNode != null : "No global success node in " + region.getName();
		this.globalSuccessNode = globalSuccessNode;
		//	this.thisNode = thisNode;
		assert traceNode != null : "No trace node in " + region.getName();
		//	this.traceNode = traceNode;
		this.thisAndTraceNodes = thisNode != null ? Lists.newArrayList(thisNode, traceNode) : Collections.singletonList(traceNode);
		if (dispatchNode != null) {
			for (@NonNull Edge edge : dispatchNode.getOutgoingEdges()) {
				if (edge.isSuccess() && edge.isRealized()) {
					this.dispatchSuccessEdge = edge;
				}
			}
		}
	}

	private void addEdge(@NonNull AbstractReachabilityPartitionFactory partitionFactory, @NonNull Edge edge) {
		if (!edge2partitionFactory.containsKey(edge)) {
			edge2partitionFactory.put(edge, partitionFactory);
		}
	}

	private void addNode(@NonNull AbstractReachabilityPartitionFactory partitionFactory, @NonNull Node node) {
		if (!node2partitionFactory.containsKey(node)) {
			node2partitionFactory.put(node, partitionFactory);
		}
	}

	private @Nullable CyclicRegionAnalysis basicGetCyclicRegionAnalysis() {
		return transformationAnalysis.basicGetCyclicRegionAnalysis(regionAnalysis);
	}

	protected @Nullable AbstractReachabilityPartitionFactory basicGetPartitionFactory(@NonNull Edge edge) {
		return edge2partitionFactory.get(edge);
	}

	protected @Nullable AbstractReachabilityPartitionFactory basicGetPartitionFactory(@NonNull Node node) {
		return node2partitionFactory.get(node);
	}

	@Override
	protected void check() {
		super.check();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.isPredicated()) {
				if (node2partitionFactory.get(node) == null) {
					CompilerUtil.addRegionError(mappingPartitioner.getProblemHandler(), region, "Should have predicated " + node);
				}
			}
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (edge.isPredicated()) {
				if (edge2partitionFactory.get(edge) == null) {
					CompilerUtil.addRegionError(mappingPartitioner.getProblemHandler(), region, "Should have predicated " + edge);
				}
			}
		}
	}

	private void createCtorPartitionFactory() {
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(region);
		List<@NonNull Node> novelCtorNodes = new ArrayList<>();
		List<@NonNull NavigableEdge> novelCtorEdges = new ArrayList<>();
		//
		//	Gather all head-to-head edges
		//
		for (@NonNull Node headNode : headNodes) {
			novelCtorNodes.add(headNode);
			for (@NonNull Edge novelEdge : QVTscheduleUtil.getOutgoingEdges(headNode)) {
				if ((novelEdge instanceof NavigableEdge) && novelEdge.isLoaded() && Iterables.contains(headNodes, QVTscheduleUtil.getTargetNode(novelEdge))) {
					novelCtorEdges.add((NavigableEdge)novelEdge);
				}
			}
		}
		//
		//	Gather all head-to-trace edges
		//
		for (@NonNull Node traceNode : thisAndTraceNodes) {
			if (!novelCtorNodes.contains(traceNode)) {				// dispatched head is a trace node
				novelCtorNodes.add(traceNode);
				for (@NonNull Edge novelEdge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
					if ((novelEdge instanceof NavigableEdge) && Iterables.contains(headNodes, QVTscheduleUtil.getTargetNode(novelEdge))) {
						novelCtorEdges.add((NavigableEdge)novelEdge);
					}
				}
			}
		}
		if (!novelCtorEdges.isEmpty() || (novelCtorNodes.size() > 1)) {		// Skip trivial trace only partition
			ReachabilityForest ctorReachabilityForest = new ReachabilityForest("ctor", headNodes, novelCtorEdges);
			new CtorPartitionFactory(this, ctorReachabilityForest, headNodes, novelCtorNodes, novelCtorEdges);
		}
	}

	private @Nullable Set<@NonNull Node> createInitPartitionFactory() {
		//
		//	Create the InitPartitionFactory for acyclic elements that precede the cycle.
		//
		// FIXME an ordering of the acyclic unpartitioned regions could allow many predicate steps to
		//  be merged from the outset.
		//

		CyclicRegionAnalysis cyclicRegionAnalysis = basicGetCyclicRegionAnalysis();
		//
		//	Gather the acyclic edges and remember if there is a cyclic edge.
		//
		List<@NonNull Edge> reachingInitEdges = new ArrayList<>();
		UniqueList<@NonNull Edge> cyclicInitEdges = null;
		List<@NonNull Edge> coCyclicInitEdges = null;
		UniqueList<@NonNull Node> coCyclicInitNodes = null;
		for (@NonNull Edge edge : originalEdges) {
			if (basicGetPartitionFactory(edge) != null) {
				reachingInitEdges.add(edge);
			}
			else if (edge.isOld()) { // && !edge.isSecondary()) {
				boolean isCyclic = false;
				if (edge.isNavigable() && cyclicRegionAnalysis != null) {
					PropertyDatum propertyDatum = scheduleManager.getPropertyDatum((NavigationEdge) edge);
					if (cyclicRegionAnalysis.isCyclic(propertyDatum)) {
						isCyclic = true;
						if (cyclicInitEdges == null) {
							cyclicInitEdges = new UniqueList<>();
						}
						cyclicInitEdges.add(edge);
						if (edge.isSuccess()) {		// FIXME and TRUE
							Node invokedNode = QVTscheduleUtil.getSourceNode(edge);
							for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(invokedNode)) {
								if ((outgoingEdge != edge) && outgoingEdge.isPredicated() && outgoingEdge.isNavigable()) {
									List<@NonNull Region> corollaryOf = transformationAnalysis.getCorollaryOf((NavigationEdge) outgoingEdge);
									if (corollaryOf != null) {
										if (coCyclicInitEdges == null) {
											coCyclicInitEdges = new ArrayList<>();
										}
										assert !coCyclicInitEdges.contains(outgoingEdge);
										coCyclicInitEdges.add(outgoingEdge);
										//	NavigationEdge oppositeEdge = ((NavigationEdge)outgoingEdge).getOppositeEdge();
										//	assert (oppositeEdge != null) && !coCyclicInitEdges.contains(oppositeEdge);
										//	coCyclicInitEdges.add(oppositeEdge);
										Node corollaryNode = QVTscheduleUtil.getTargetNode(outgoingEdge);
										if (coCyclicInitNodes == null) {
											coCyclicInitNodes = new UniqueList<>();
										}
										assert !coCyclicInitNodes.contains(corollaryNode);
										coCyclicInitNodes.add(corollaryNode);
									}
								}
							}
						}
					}
				}
				if (!isCyclic) {
					reachingInitEdges.add(edge);
				}
			}
		}
		if (coCyclicInitEdges != null) {
			reachingInitEdges.removeAll(coCyclicInitEdges);
		}
		UniqueList<@NonNull Node> cyclicInitNodes = null;
		UniqueList<@NonNull Node> reachingInitNodes = null;
		if (cyclicInitEdges != null) {
			reachingInitNodes = new UniqueList<>(thisAndTraceAndConstantSourceNodes);
			cyclicInitNodes = new UniqueList<>();
			int iMax = cyclicInitEdges.size();
			for (int i = 0; i < iMax; i++) {			// Domain grows but extra entries are processed recursively within loop.
				Edge cyclicEdge = cyclicInitEdges.get(i);
				pruneInitCyclicEdge(cyclicInitNodes, cyclicInitEdges, cyclicEdge);
			}
			reachingInitEdges.removeAll(cyclicInitEdges);
			reachingInitNodes.removeAll(cyclicInitNodes);
		}
		/*		Set<@NonNull Node> oldNodes1 = new HashSet<>();
		for (@NonNull Node node : allNodes) {
			if (node.isOld()) {
				//	ClassDatum classDatum = QVTscheduleUtil.getClassDatum(node);
				//	if (!classDatum.isCollectionType()) {		// Collection DataTypes are non 1:1 edge ends
				oldNodes1.add(node);
				//	}
			}
		} */
		//		assert hasCyclicEdge1 == hasCyclicEdge2;
		//		Collections.sort(navigableInitEdges1, NameUtil.NAMEABLE_COMPARATOR);
		//		Collections.sort(navigableInitEdges2, NameUtil.NAMEABLE_COMPARATOR);
		//		assert navigableInitEdges1.equals(navigableInitEdges2);

		//	strategy.regionAnalysis.createLocalSuccess();
		ReachabilityForest initReachabilityForest1 = new ReachabilityForest("init", reachingInitNodes != null ? reachingInitNodes : thisAndTraceAndConstantSourceNodes, reachingInitEdges);
		List<@NonNull Node> novelInitNodes1 = null;
		//
		//	All reachable nodes not roots or in a previous partition are novel, unless they are
		//	corrolaries of a cycle.
		//
		for (@NonNull Node node : initReachabilityForest1.getMostReachableFirstNodes()) {
			if ((basicGetPartitionFactory(node) == null) && !Iterables.contains(thisAndTraceNodes, node)) {
				if ((coCyclicInitNodes == null) || !coCyclicInitNodes.contains(node)) {
					if (novelInitNodes1 == null) {
						novelInitNodes1 = new ArrayList<>();
					}
					novelInitNodes1.add(node);
				}
			}
		}
		//
		//	Add all non-top when invocations; realized middle nodes with a predicated global status and one or more
		//	predicates when invocation results.
		//
		for (@NonNull Node node : originalNodes) {
			if ((basicGetPartitionFactory(node) == null) && !Iterables.contains(thisAndTraceNodes, node)) {
				if (node.isRealized() && node.getClassDatum().getReferredTypedModel().isIsTrace()) {
					boolean hasSuccess = false;
					boolean hasPredicatedEdge = false;
					for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(node)) {
						if (outgoingEdge.isPredicated()) {
							hasPredicatedEdge = true;
						}
						if (outgoingEdge.isSuccess()) {		// ?? stronger test for global success
							hasSuccess = true;
						}
					}
					if (hasSuccess && hasPredicatedEdge) {
						if (novelInitNodes1 == null) {
							novelInitNodes1 = new ArrayList<>();
						}
						novelInitNodes1.add(node);
					}
				}
			}
		}
		if (novelInitNodes1 != null) {
			//	assert novelInitNodes1.equals(novelInitNodes2);  -- not even close
			if (cyclicInitEdges == null) {			// Acyclic - can do realizes now
				for (@NonNull Node node : originalNodes) {
					if (node.isRealized() && !novelInitNodes1.contains(node) && (basicGetPartitionFactory(node) == null)) {
						ClassDatum classDatum = QVTscheduleUtil.getClassDatum(node);
						if (!classDatum.isCollectionType()) {		// Collection DataTypes are non 1:1 edge ends
							novelInitNodes1.add(node);
						}
					}
				}
			}
			if (!novelInitNodes1.contains(globalSuccessNode)) {
				novelInitNodes1.add(getLocalSuccessNode());
			}
			new InitPartitionFactory(this, initReachabilityForest1, thisAndTraceNodes, novelInitNodes1);
		}
		return coCyclicInitNodes;
	}

	/**
	 * Grow the cyclicNodes/cyclicEdges area to include all nodes/edges that should be omitted from the init partition as a consequence
	 * of omitting the cyclicEdge.
	 */
	private void pruneInitCyclicEdge(@NonNull Set<@NonNull Node> cyclicNodes, @NonNull Set<@NonNull Edge> cyclicEdges, @NonNull Edge cyclicEdge) {
		Node targetNode = QVTscheduleUtil.getTargetNode(cyclicEdge);
		pruneInitCyclicTargetNode(cyclicNodes, cyclicEdges, targetNode);
		/*		if (cyclicNodes.add(targetNode)) {
			if (cyclicEdge.isComputation()) {
				cyclicEdges.add(cyclicEdge);
				Node sourceNode = QVTscheduleUtil.getSourceNode(cyclicEdge);
				if (cyclicEdges.containsAll(sourceNode.getOutgoingEdges())) {
					//	if (cyclicNodes.add(sourceNode)) {
					for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
						pruneInitCyclicEdge(cyclicNodes, cyclicEdges, incomingEdge);
					}
					//	}
				}
			}
			else if (cyclicEdges.containsAll(targetNode.getIncomingEdges())) {
				for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(targetNode)) {
					pruneInitCyclicEdge(cyclicNodes, cyclicEdges, outgoingEdge);
				}
			}
		} */
	}
	/*	private void pruneInitCyclicSourceNode(@NonNull Set<@NonNull Node> cyclicNodes, @NonNull Set<@NonNull Edge> cyclicEdges, @NonNull Node cyclicNode) {
		if (cyclicNodes.add(cyclicNode)) {
			if (cyclicEdges.containsAll(cyclicNode.getIncomingEdges())) {		// Follow irrevocably cyclic nodes towards their targets
				for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(cyclicNode)) {
					cyclicEdges.add(outgoingEdge);
					pruneInitCyclicNode(cyclicNodes, cyclicEdges, QVTscheduleUtil.getTargetNode(outgoingEdge));
				}
			}
			if (cyclicNode.isExpression()) {		// Follow orphan expressions towards their sources
				boolean hasNavigation = false;
				for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(cyclicNode)) {
					if (incomingEdge.isNavigation()) {
						hasNavigation = true;
						break;
					}
				}
				if (!hasNavigation) {
					for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(cyclicNode)) {
						cyclicEdges.add(incomingEdge);
						pruneInitCyclicNode(cyclicNodes, cyclicEdges, QVTscheduleUtil.getSourceNode(incomingEdge));
					}
				}
			}
		}
	} */
	private void pruneInitCyclicTargetNode(@NonNull Set<@NonNull Node> cyclicNodes, @NonNull Set<@NonNull Edge> cyclicEdges, @NonNull Node cyclicNode) {
		assert !cyclicNodes.contains(cyclicNode);
		if (cyclicEdges.containsAll(cyclicNode.getIncomingEdges())) {		// Follow irrevocably cyclic nodes towards their targets
			cyclicNodes.add(cyclicNode);
			for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(cyclicNode)) {
				cyclicEdges.add(outgoingEdge);
				Node targetNode = QVTscheduleUtil.getTargetNode(outgoingEdge);
				if (!cyclicNodes.contains(targetNode)) {
					pruneInitCyclicTargetNode(cyclicNodes, cyclicEdges, targetNode);
				}
			}
		}
		if (cyclicNode.isExpression()) {		// Follow orphan expressions towards their sources
			boolean hasNavigation = false;
			Iterable<@NonNull Edge> incomingEdges = QVTscheduleUtil.getIncomingEdges(cyclicNode);
			for (@NonNull Edge incomingEdge : incomingEdges) {
				if (incomingEdge.isNavigation()) {
					hasNavigation = true;
					break;
				}
			}
			if (!hasNavigation) {
				cyclicNodes.add(cyclicNode);
				for (@NonNull Edge incomingEdge : incomingEdges) {
					cyclicEdges.add(incomingEdge);
					Node sourceNode = QVTscheduleUtil.getSourceNode(incomingEdge);
					if (!cyclicNodes.contains(sourceNode)) {
						pruneInitCyclicTargetNode(cyclicNodes, cyclicEdges, sourceNode);
					}
				}
			}
		}
	}

	private void createLoopPartitionFactory() {
		//
		//	Determine the reaching edges for the LoopPartitionFactory.
		//
		List<@NonNull Edge> reachingLoopEdges = new ArrayList<>();
		for (@NonNull Edge edge : originalEdges) {
			if (basicGetPartitionFactory(edge) != null) {
				reachingLoopEdges.add(edge);
			}
			else if (edge.isOld() && (!edge.isNavigable() || !transformationAnalysis.isCorollary((NavigationEdge) edge))) {
				reachingLoopEdges.add(edge);		// Gather all predicated edges that cannot be deferred to the rest partition as corrolaries.
			}
		}
		if (localSuccessEdge != null) {
			reachingLoopEdges.add(localSuccessEdge);
			if (dispatchSuccessEdge != null) {
				reachingLoopEdges.add(dispatchSuccessEdge);
			}
		}
		//
		//	Determine the novel nodes for the LoopPartitionFactory.
		//
		ReachabilityForest loopReachabilityForest = new ReachabilityForest("loop", thisAndTraceAndConstantSourceNodes, reachingLoopEdges);
		List<@NonNull Node> novelLoopNodes = null;
		for (@NonNull Node node : loopReachabilityForest.getMostReachableFirstNodes()) {
			if (basicGetPartitionFactory(node) == null) {
				if (novelLoopNodes == null) {
					novelLoopNodes = new ArrayList<>();
				}
				novelLoopNodes.add(node);
			}
		}
		if (novelLoopNodes != null) {
			if (localSuccessNode != null) {
				novelLoopNodes.add(localSuccessNode);
			}
			for (@NonNull Node node : originalNodes) {
				if (!node.isPredicated() && !novelLoopNodes.contains(node) && (basicGetPartitionFactory(node) == null)) {
					ClassDatum classDatum = QVTscheduleUtil.getClassDatum(node);
					if (!classDatum.isCollectionType()) {		// Collection DataTypes are non 1:1 edge ends
						novelLoopNodes.add(node);
					}
				}
			}
			//			if (!novelLoopNodes.equals(novelLoopNodes2)) {
			//				getClass();
			//			}
			List<@NonNull Edge> novelLoopEdges = new ArrayList<>();
			for (@NonNull Edge edge : originalEdges) {
				if (edge.isRealized() && (basicGetPartitionFactory(edge) == null)) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					if (((loopReachabilityForest.basicGetCost(sourceNode) != null) || Iterables.contains(novelLoopNodes, sourceNode))
							&& ((loopReachabilityForest.basicGetCost(targetNode) != null) || Iterables.contains(novelLoopNodes, targetNode))) {
						novelLoopEdges.add(edge);
					}
				}
			}
			new LoopPartitionFactory(this, loopReachabilityForest, thisAndTraceNodes, novelLoopNodes, novelLoopEdges);
		}
	}

	protected void createNonPartition() {
		newPartitionAnalyses.add(new NonPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
	}

	private @Nullable Iterable<@NonNull Node> createRestPartitionFactory(@Nullable Set<@NonNull Node> coCyclicInitNodes) {
		if ("mapIfExp_qvtr".equals(region.getName())) {
			getClass();
		}
		//
		//	Create RestPartitionFactory to progress the remaining realized edges.
		//
		List<@NonNull Edge> novelRestEdges = null;
		List<@NonNull Node> extraRestNodes = null;
		for (@NonNull Edge edge : originalEdges) {
			if (edge.isNavigable()) {
				NavigationEdge navigationEdge = (NavigationEdge) edge;
				if (edge.isRealized() && (basicGetPartitionFactory(edge) == null)) {
					boolean assignIt = false;
					Node realizedTarget = QVTscheduleUtil.getTargetNode(navigationEdge);
					if (!realizedTarget.isPredicated() || (basicGetPartitionFactory(realizedTarget) != null)) {
						assignIt = true;
					}
					else if ((coCyclicInitNodes != null) && coCyclicInitNodes.contains(realizedTarget)) {
						assignIt = true;
					}
					else {
						if (extraRestNodes == null) {
							extraRestNodes = new ArrayList<>();
						}
						extraRestNodes.add(realizedTarget);
					}
					if (assignIt) {
						if (novelRestEdges == null) {
							novelRestEdges = new ArrayList<>();
						}
						novelRestEdges.add(navigationEdge);
					}
				}
			}
		}
		if (novelRestEdges != null) {
			List<@NonNull NavigableEdge> reachingRestEdges = new ArrayList<>();
			for (@NonNull Edge edge : originalEdges) {
				if (edge.isNavigable() && !novelRestEdges.contains(edge)) {
					reachingRestEdges.add((NavigableEdge)edge);
				}
			}
			Iterable<@NonNull Node> novelRestNodes;
			SuccessEdge localSuccessEdge2 = localSuccessEdge;
			if ((localSuccessEdge2 != null) && (basicGetPartitionFactory(globalSuccessNode) == null)) {
				reachingRestEdges.add(localSuccessEdge2);
				novelRestNodes = Lists.newArrayList(QVTscheduleUtil.getTargetNode(localSuccessEdge2), globalSuccessNode);
			}
			else {
				novelRestNodes = Collections.singletonList(globalSuccessNode);
			}
			ReachabilityForest restReachabilityForest = new ReachabilityForest("rest", thisAndTraceAndConstantSourceNodes, reachingRestEdges);
			new RestPartitionFactory(this, restReachabilityForest, thisAndTraceNodes, novelRestNodes, novelRestEdges);
		}
		return extraRestNodes;
	}

	private void createXtraPartitionFactory(@NonNull Iterable<@NonNull Node> xtraRestNodes) {
		if ("mapVariableExp_referredVariable_Helper_qvtr".equals(region.getName())) {
			getClass();
		}
		//
		//	Create XtraPartitionFactory to progress the remaining realized edges.
		//
		List<@NonNull Edge> novelXtraEdges = new ArrayList<>();
		List<@NonNull Edge> reachingXtraEdges = new ArrayList<>();
		for (@NonNull Edge edge : originalEdges) {
			if (basicGetPartitionFactory(edge) == null) {
				novelXtraEdges.add(edge);
				if (edge.isOld()) {
					reachingXtraEdges.add(edge);
				}
			}
			else {
				reachingXtraEdges.add(edge);
			}
		}
		List<@NonNull Node> novelXtraNodes = new ArrayList<>();
		novelXtraNodes.add(globalSuccessNode);
		for (@NonNull Node node : originalNodes) {
			if (basicGetPartitionFactory(node) == null) {
				novelXtraNodes.add(node);
			}
		}
		ReachabilityForest xtraReachabilityForest = new ReachabilityForest("xtra", thisAndTraceAndConstantSourceNodes, reachingXtraEdges);
		new XtraPartitionFactory(this, xtraReachabilityForest, thisAndTraceNodes, novelXtraNodes, novelXtraEdges);
	}

	private @NonNull SuccessNode getLocalSuccessNode() {
		SuccessNode localSuccessNode2 = localSuccessNode;
		if (localSuccessNode2 == null) {
			this.localSuccessEdge = regionAnalysis.createLocalSuccess();
			this.localSuccessNode = localSuccessNode2 = (SuccessNode) QVTscheduleUtil.getTargetNode(localSuccessEdge);
		}
		return localSuccessNode2;
	}

	private @NonNull AbstractReachabilityPartitionFactory getPartitionFactory(@NonNull Edge edge) {
		AbstractReachabilityPartitionFactory partitionFactory = edge2partitionFactory.get(edge);
		return ClassUtil.nonNullState(partitionFactory);
	}

	private @NonNull AbstractReachabilityPartitionFactory getPartitionFactory(@NonNull Node node) {
		AbstractReachabilityPartitionFactory partitionFactory = node2partitionFactory.get(node);
		return ClassUtil.nonNullState(partitionFactory);
	}

	public @NonNull Region getRegion() {
		return region;
	}

	public @NonNull AbstractTransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	@Override
	public @NonNull Iterable<@NonNull PartitionAnalysis> partition() {
		String name = regionAnalysis.getName();
		if ("mapHelper_Context_qvtr".equals(name)) {
			getClass();
		}
		//
		//	Create the PartitionFactories.
		//
		createCtorPartitionFactory();
		@Nullable Set<@NonNull Node> coCyclicInitNodes = createInitPartitionFactory();
		createLoopPartitionFactory();
		@Nullable Iterable<@NonNull Node> extraRestNodes = createRestPartitionFactory(coCyclicInitNodes);
		if (extraRestNodes != null) {
			createXtraPartitionFactory(extraRestNodes);
		}
		//
		//	Create the partitions.
		//
		for (@NonNull AbstractReachabilityPartitionFactory partitionFactory : partitionFactories) {
			newPartitionAnalyses.add(partitionFactory.createPartitionAnalysis(partitionedTransformationAnalysis));
		}
		check();
		return newPartitionAnalyses;
	}

	private void setCurrentPartitionFactory(@NonNull AbstractReachabilityPartitionFactory currentPartitionFactory) {
		if (this.currentPartitionFactory != null) {
			currentPartitionFactory.addPredecessor(this.currentPartitionFactory);
		}
		this.currentPartitionFactory = currentPartitionFactory;
		partitionFactories.add(currentPartitionFactory);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(mappingPartitioner.getName());
		for (@NonNull AbstractReachabilityPartitionFactory partitionFactory : partitionFactories) {
			s.append("\n\t");
			partitionFactory.toString(s, "\n\t");
		}
		return s.toString();
	}

	@Override
	protected boolean useActivators() {
		return true;
	}
}