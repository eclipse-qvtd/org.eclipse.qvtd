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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The SpeculatingPartition validates the residual predictaes omitted from the speculation.
 * The corollary is realized and realized edges that do not involve other speculations
 * are also realized. Realization of speculation nodes must wait for the speculated partition.
 */
public class SpeculatingPartition extends AbstractPartialPartition
{
	public static class SpeculatingPartitionFactory extends AbstractPartitionFactory
	{
		public SpeculatingPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
			super(mappingPartitioner);
		}

		@Override
		public @NonNull SpeculatingPartition createPartition() {
			ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
			return new SpeculatingPartition(computeName("speculating"), mappingPartitioner, reachabilityForest);
		}
	}

	//	private final @NonNull Node traceNode;
	private final @NonNull Iterable<@NonNull Node> executionNodes;
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	protected SpeculatingPartition(@NonNull String name, @NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest/*, boolean isInfallible*/) {
		super(name, partitioner, reachabilityForest);
		//	this.traceNode = partitioner.getTraceNode();
		this.executionNodes = partitioner.getExecutionNodes();
		if (hasSynthesizedTrace) {
			//
			//	For a no-override top relation the realized middle (trace) nodes become speculated nodes.
			//	For an override top relation the predicated middle (trace) nodes become speculated nodes.
			//	For a non-top relation the predicated middle (trace) nodes become speculated nodes.
			//
			for (@NonNull Node traceNode : executionNodes) {
				addNode(traceNode, Role.PREDICATED); //, Role.SPECULATED);
			}
			//
			//	For an override relation the predicated middle dispatch nodes become speculated nodes.
			//
			Node dispatchNode = partitioner.basicGetDispatchNode();
			if (dispatchNode != null) {
				assert dispatchNode.isPredicated();
				addNode(dispatchNode);
			}
		}
		else {
			//
			//	The realized middle (trace) nodes become speculated head nodes and their already realized edge ends populate tracedInputNodes.
			//
			resolveTraceNodes();
		}
		//
		//	The cyclic predicated middle nodes become speculated guard nodes and all preceding
		//	navigations are retained as is.
		//
		if (hasSynthesizedTrace) {
			for (@NonNull Node whenNode : partitioner.getPredicatedWhenNodes()) {
				if (!partitioner.hasPredicatedNode(whenNode)) {
					addNode(whenNode); //, Role.SPECULATED);
				}
			}
		}
		else {
			resolvePredicatedMiddleNodes();
			//
			//	The predicated output nodes and all preceding navigations are retained as is.
			//
			resolvePredicatedOutputNodes();
		}
		//
		//	The localSuccess nodes are predicated, and the globalSuccess realized to sequence speculating/speculation/speculated partitions.
		//
		resolveSuccessNodes();
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		resolveConstantOutputNodes(/*isInfallible*/);
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes();
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		//		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion() {
		int partitionNumber = originalRegion.getNextPartitionNumber();
		return createMicroMappingRegion("«speculating»", "_p" + partitionNumber);
	}

	@Override
	protected @Nullable Iterable<@NonNull Node> getPreferredHeadNodes() {
		return executionNodes;
	}

	//	private boolean isAlwaysSatisfied(@NonNull Edge edge) {
	//		return edge.isUnconditional(); //true;		// FIXME perform compile-time speculation resolution
	//	}

	private boolean isDownstreamFromCorollary(@NonNull Node node) {
		if (transformationAnalysis.isCorollary(node)) {
			return true;
		}
		if (node.isOperation()) {
			boolean allReachable = true;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation()) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					if (isDownstreamFromCorollary(sourceNode)) {
						allReachable = false;
						break;
					}
				}
			}
			if (allReachable) {
				return false;
			}
		}
		for (@NonNull Node precedingNode : getPredecessors(node)) {
			if (!isDownstreamFromCorollary(precedingNode)) {
				return false;
			}
		}
		return true;
	}

	protected void resolveConstantOutputNodes(/*boolean isInfallible*/) {
		//	Set<@NonNull Node> fallibleNodes = null;
		//	if (isInfallible) {
		//		fallibleNodes = new HashSet<>();
		//		for (@NonNull Edge edge : regionAnalysis.getFallibleEdges()) {
		//			fallibleNodes.add(QVTscheduleUtil.getTargetNode(edge));
		//		}
		//	}
		for (@NonNull Node constantOutputNode : partitioner.getConstantOutputNodes()) {
			//	if ((fallibleNodes == null) || !Iterables.contains(fallibleNodes, constantOutputNode)) {
			if (!partitioner.hasPredicatedNode(constantOutputNode)) {
				addNode(constantOutputNode);
			}
			//	}
		}
	}

	/**
	 * Return true if node is a corollary of this mapping.
	 *
	private boolean isLocalCorollary(@NonNull Node node) {
		assert node.isRealized();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isRealized() && edge.isNavigation()) {
				// A cyclic node cannot be a corollary since we must establish that all speculating
				// partitions are ok before the speculated region can create the full cycle.
				if (!partitioner.isCyclic(QVTscheduleUtil.getSourceNode(edge))) {
					List<@NonNull MappingRegion> corollaryOfRegions = partitioner.getCorollaryOf(edge);
					if ((corollaryOfRegions != null) && (corollaryOfRegions.size() == 1) && corollaryOfRegions.contains(region)) {
						return true;
					}
				}
			}
		}
		return false;
	} */

	/*	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if ((edgeRole == Role.REALIZED) && !(edge instanceof SuccessEdge)) {
			edgeRole = null;
		}
		return edgeRole;
	} */

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			/* if (edge instanceof SuccessEdge) {
						edgeRole = Role.SPECULATED;			// FIXME fudge awaiting run-time support
					}
					else */ if (partitioner.hasRealizedEdge(edge)) {
						edgeRole = Role.PREDICATED;
					}
		}
		else if (edgeRole == Role.PREDICATED) {
			if (edge instanceof SuccessEdge) {
				boolean hasRealizedEdge = partitioner.hasRealizedEdge(edge);
				if (!hasRealizedEdge) {
					//	Role nodeRole = getRole(QVTscheduleUtil.getTargetNode(edge));
					//	if ((nodeRole != null) && nodeRole.isRealized()) {
					edgeRole = Role.SPECULATED;
					//	}
				}
			}
		}
		return edgeRole;
	}

	/*	protected void resolveMatchedPredicatedEdges() {
		for (@NonNull Edge edge : partitioner.getPredicatedEdges()) {
			if (edge.isMatched() && !partitioner.hasPredicatedEdge(edge) && (partitioner.getCorollaryOf(edge) == null)) {
				Node sourceNode = edge.getEdgeSource();
				if (!sourceNode.isRealized()) {
					Node targetNode = edge.getEdgeTarget();
					if (!targetNode.isRealized()) {
						if (!hasNode(sourceNode)) {
							addNode(sourceNode, QVTscheduleUtil.getNodeRole(sourceNode));
						}
						if (!hasNode(targetNode)) {
							addNode(targetNode, QVTscheduleUtil.getNodeRole(targetNode));
						}
					}
				}
			}
		}
	} */

	protected void resolvePredicatedMiddleNodes() {
		for (@NonNull Node node : partitioner.getPredicatedMiddleNodes()) {
			if (!hasNode(node) && node.isMatched()) { // && partitioner.isCyclic(node)) {
				Role nodeRole = QVTscheduleUtil.getNodeRole(node);
				//				if (node.isPattern() && node.isClass()) {
				//					nodeRole = QVTscheduleUtil.asSpeculated(nodeRole);
				//				}
				addNode(node, nodeRole); //QVTscheduleUtil.asSpeculated(nodeRole));
			}
		}
	}

	protected void resolvePredicatedOutputNodes() {
		for (@NonNull Node node : partitioner.getPredicatedOutputNodes()) {
			if (!hasNode(node) && !transformationAnalysis.isCorollary(node) && !isDownstreamFromCorollary(node)) {
				addNode(node, QVTscheduleUtil.getNodeRole(node));
			}
		}
	}

	/*	protected void resolvePredicatedOutputNodes() {
		for (@NonNull Node node : partitioner.getPredicatedOutputNodes()) {
			if (!hasNode(node) && !isCorollary(node) && !isDownstreamFromCorollary(node)) {
				addNode(node, QVTscheduleUtil.getNodeRole(node));
			}
		}
	} */

	protected void resolveSuccessNodes() {
		for (@NonNull Node traceNode : executionNodes) {
			Node localSuccessNode = partitioner.getLocalSuccessNode(traceNode);
			addNode(localSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			Node globalSuccessNode = partitioner.getGlobalSuccessNode(traceNode);
			addNode(globalSuccessNode, Role.REALIZED);
		}
		//	Iterable<@NonNull Edge> fallibleEdges = isInfallible ? regionAnalysis.getFallibleEdges() : null;
		/*	for (@NonNull Edge edge : partitioner.getSuccessEdges()) {
			//	if (/ *edge.isNew() ||* / (fallibleEdges == null) || !Iterables.contains(fallibleEdges, edge)) {
				Node sourceNode = edge.getEdgeSource();
				Node targetNode = edge.getEdgeTarget();
				//			if (edge.isPredicated() && isAlwaysSatisfied(edge)) {
				//				if (!hasNode(targetNode)) {
				//					addNode(targetNode);
				//				}
				//				partitioner.addPredicatedNode(targetNode);
				//				partitioner.addEdge(edge, Role.PREDICATED, this);	// FIXME this fudges inadequate speculation
				//			}
				//			else {
				if (!hasNode(sourceNode)) {
					addNode(sourceNode);
				}
				if (!hasNode(targetNode)) {
					addNode(targetNode);
				}
				//	}
				//	else {
				//		System.out.println("Infallible " + edge.getEdgeSource().getName() + "." + edge.getName() + " omitted in " + region);
				//	}
			} */
	}

	protected void resolveTraceNodes() {
		Iterable<@NonNull Node> traceNodes = partitioner.getTraceNodes();		// Just 1 speculated middle node
		for (@NonNull Node traceNode : traceNodes) {
			addNode(traceNode, Role.SPECULATED);
		}
		for (@NonNull Node traceNode : traceNodes) {
			for (@NonNull NavigableEdge edge : traceNode.getNavigableEdges()) {
				if (partitioner.hasRealizedEdge(edge)) {
					tracedInputNodes.add(edge.getEdgeTarget());
				}
			}
			Node globalSuccessNode = partitioner.basicGetGlobalSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
			if (globalSuccessNode != null) {
				addNode(globalSuccessNode, Role.REALIZED);
			}
		}
	}
}