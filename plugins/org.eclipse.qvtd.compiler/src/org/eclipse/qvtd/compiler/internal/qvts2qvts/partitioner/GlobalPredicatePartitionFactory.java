/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The GlobalPredicate Partition validates the global predicates omitted by the local predicates.
 * The corollary is realized and realized edges that do not involve other speculations
 * are also realized. Realization of speculation nodes must wait for the speculated partition.
 */
public class GlobalPredicatePartitionFactory extends AbstractSimplePartitionFactory
{
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public GlobalPredicatePartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		super(mappingPartitioner);
	}

	@Override
	public @NonNull BasicPartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		String name = computeName("global");
		Iterable<@NonNull Node> executionNodes = mappingPartitioner.getExecutionNodes();
		Iterable<@NonNull Node> headNodes = mappingPartitioner.getTraceNodes();
		BasicPartition partition = createBasicPartition(name, headNodes);
		int partitionNumber = region.getNextPartitionNumber();
		BasicPartitionAnalysis basicPartitionAnalysis = new BasicPartitionAnalysis(partitionedTransformationAnalysis, partition, reachabilityForest, "«global»", "_p" + partitionNumber);
		initializePartition(basicPartitionAnalysis, executionNodes);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(partition, null);
		}
		return basicPartitionAnalysis;
	}

	protected void initializePartition(@NonNull BasicPartitionAnalysis partitionAnalysis, @NonNull Iterable<@NonNull Node> executionNodes) {
		BasicPartition partition = partitionAnalysis.getPartition();
		//	this.traceNode = mappingPartitioner.getTraceNode();
		if (hasSynthesizedTrace) {
			//
			//	For a no-override top relation the realized middle (trace) nodes become speculated nodes.
			//	For an override top relation the predicated middle (trace) nodes become speculated nodes.
			//	For a non-top relation the predicated middle (trace) nodes become speculated nodes.
			//
			for (@NonNull Node traceNode : executionNodes) {
				addNode(partition, traceNode, Role.PREDICATED); //, Role.SPECULATED);
			}
			//
			//	For an override relation the predicated middle dispatch nodes become speculated nodes.
			//
			Node dispatchNode = mappingPartitioner.basicGetDispatchNode();
			if (dispatchNode != null) {
				assert dispatchNode.isPredicated();
				addNode(partition, dispatchNode);
			}
		}
		else {
			//
			//	The realized middle (trace) nodes become speculated head nodes and their already realized edge ends populate tracedInputNodes.
			//
			resolveTraceNodes(partition);
		}
		//
		//	The cyclic predicated middle nodes become speculated guard nodes and all preceding
		//	navigations are retained as is.
		//
		if (hasSynthesizedTrace) {
			Rule rule = QVTscheduleUtil.getReferredRule(region);
			for (@NonNull Node whenNode : mappingPartitioner.getPredicatedWhenNodes()) {
				if (!mappingPartitioner.hasCheckedNode(whenNode)) {
					addNode(partition, whenNode); //, Role.SPECULATED);
				}
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(whenNode)) {
					//	if (!edge.isSuccess()) {
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					if (!mappingPartitioner.hasCheckedNode(targetNode)) {
						ClassDatum classDatum = QVTscheduleUtil.getClassDatum(targetNode);
						TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
						Domain domain = QVTrelationUtil.basicGetDomain(rule, typedModel);
						if (domain != null) {
							boolean isInput = scheduleManager.isInputInRule(rule, domain);
							if (isInput) {
								addNode(partition, targetNode);
							}
						}
						//	}
					}
				}
			}
		}
		else {
			resolvePredicatedMiddleNodes(partition);
			//
			//	The predicated output nodes and all preceding navigations are retained as is.
			//
			resolvePredicatedOutputNodes(partitionAnalysis);
		}
		//
		//	The localSuccess nodes are predicated, and the globalSuccess realized to sequence speculating/speculation/speculated partitions.
		//
		resolveSuccessNodes(partition, executionNodes);
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		resolveConstantOutputNodes(partition/*isInfallible*/);
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes(partitionAnalysis);
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		//		resolveDisambiguations();
		//
		//	Join up the edges to satisfy reachability.
		//
		resolveEdges(partitionAnalysis);
	}

	private boolean isDownstreamFromCorollary(@NonNull BasicPartitionAnalysis partitionAnalysis, @NonNull Node node) {
		if (transformationAnalysis.isCorollary(node)) {
			return true;
		}
		if (node.isOperation()) {
			boolean allReachable = true;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation()) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					if (isDownstreamFromCorollary(partitionAnalysis, sourceNode)) {
						allReachable = false;
						break;
					}
				}
			}
			if (allReachable) {
				return false;
			}
		}
		for (@NonNull Node precedingNode : partitionAnalysis.getPredecessorsClosure(node)) {
			if (!isDownstreamFromCorollary(partitionAnalysis, precedingNode)) {
				return false;
			}
		}
		return true;
	}

	//	private boolean isAlwaysSatisfied(@NonNull Edge edge) {
	//		return edge.isUnconditional(); //true;		// FIXME perform compile-time speculation resolution
	//	}

	/**
	 * Return true if node is a corollary of this mapping.
	 *
		private boolean isLocalCorollary(@NonNull Node node) {
			assert node.isRealized();
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isRealized() && edge.isNavigation()) {
					// A cyclic node cannot be a corollary since we must establish that all speculating
					// partitions are ok before the speculated region can create the full cycle.
					if (!mappingPartitioner.isCyclic(QVTscheduleUtil.getSourceNode(edge))) {
						List<@NonNull MappingRegion> corollaryOfRegions = mappingPartitioner.getCorollaryOf(edge);
						if ((corollaryOfRegions != null) && (corollaryOfRegions.size() == 1) && corollaryOfRegions.contains(region)) {
							return true;
						}
					}
				}
			}
			return false;
		} */

	protected void resolveConstantOutputNodes(@NonNull BasicPartition partition/*boolean isInfallible*/) {
		//	Set<@NonNull Node> fallibleNodes = null;
		//	if (isInfallible) {
		//		fallibleNodes = new HashSet<>();
		//		for (@NonNull Edge edge : regionAnalysis.getFallibleEdges()) {
		//			fallibleNodes.add(QVTscheduleUtil.getTargetNode(edge));
		//		}
		//	}
		for (@NonNull Node constantOutputNode : mappingPartitioner.getConstantOutputNodes()) {
			//	if ((fallibleNodes == null) || !Iterables.contains(fallibleNodes, constantOutputNode)) {
			if (!mappingPartitioner.hasCheckedNode(constantOutputNode)) {
				addNode(partition, constantOutputNode);
			}
			//	}
		}
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			/* if (edge instanceof SuccessEdge) {
							edgeRole = Role.SPECULATED;			// FIXME fudge awaiting run-time support
						}
						else */ if (mappingPartitioner.hasRealizedEdge(edge)) {
							edgeRole = Role.PREDICATED;
						}
		}
		else if (edgeRole == Role.PREDICATED) {
			if (edge instanceof SuccessEdge) {
				boolean hasRealizedEdge = mappingPartitioner.hasRealizedEdge(edge);
				if (!hasRealizedEdge && !edge.isConditional()) {
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
			for (@NonNull Edge edge : mappingPartitioner.getPredicatedEdges()) {
				if (edge.isMatched() && !mappingPartitioner.hasPredicatedEdge(edge) && (mappingPartitioner.getCorollaryOf(edge) == null)) {
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

	protected void resolvePredicatedMiddleNodes(@NonNull BasicPartition partition) {
		for (@NonNull Node node : mappingPartitioner.getPredicatedMiddleNodes()) {
			if (!partition.hasNode(node) && !node.isConditional()) { // && mappingPartitioner.isCyclic(node)) {
				Role nodeRole = QVTscheduleUtil.getNodeRole(node);
				//				if (node.isPattern() && node.isClass()) {
				//					nodeRole = QVTscheduleUtil.asSpeculated(nodeRole);
				//				}
				addNode(partition, node, nodeRole); //QVTscheduleUtil.asSpeculated(nodeRole));
			}
		}
	}

	protected void resolvePredicatedOutputNodes(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		for (@NonNull Node node : mappingPartitioner.getPredicatedOutputNodes()) {
			if (!partition.hasNode(node) && !transformationAnalysis.isCorollary(node) && !isDownstreamFromCorollary(partitionAnalysis, node)) {
				addNode(partition, node, QVTscheduleUtil.getNodeRole(node));
			}
		}
	}

	/*	protected void resolvePredicatedOutputNodes() {
			for (@NonNull Node node : mappingPartitioner.getPredicatedOutputNodes()) {
				if (!hasNode(node) && !isCorollary(node) && !isDownstreamFromCorollary(node)) {
					addNode(node, QVTscheduleUtil.getNodeRole(node));
				}
			}
		} */

	protected void resolveSuccessNodes(@NonNull BasicPartition partition, @NonNull Iterable<@NonNull Node> executionNodes) {
		for (@NonNull Node traceNode : executionNodes) {
			Node localSuccessNode = mappingPartitioner.basicGetLocalSuccessNode(traceNode);
			if (localSuccessNode != null) {
				addNode(partition, localSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			}
			else {
				CompilerUtil.addPartitionError(getProblemHandler(), partition, "Missing localSuccess");
			}
			Node globalSuccessNode = mappingPartitioner.basicGetGlobalSuccessNode(traceNode);
			if (globalSuccessNode != null) {
				addNode(partition, globalSuccessNode, Role.REALIZED);
			}
			else {
				CompilerUtil.addPartitionError(getProblemHandler(), partition, "Missing globalSuccess");
			}
		}
		//	Iterable<@NonNull Edge> fallibleEdges = isInfallible ? regionAnalysis.getFallibleEdges() : null;
		/*	for (@NonNull Edge edge : mappingPartitioner.getSuccessEdges()) {
				//	if (/ *edge.isNew() ||* / (fallibleEdges == null) || !Iterables.contains(fallibleEdges, edge)) {
					Node sourceNode = edge.getEdgeSource();
					Node targetNode = edge.getEdgeTarget();
					//			if (edge.isPredicated() && isAlwaysSatisfied(edge)) {
					//				if (!hasNode(targetNode)) {
					//					addNode(targetNode);
					//				}
					//				mappingPartitioner.addCheckedEdge(targetNode);
					//				mappingPartitioner.addEdge(edge, Role.PREDICATED, this);	// FIXME this fudges inadequate speculation
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

	protected void resolveTraceNodes(@NonNull BasicPartition partition) {
		Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();		// Just 1 speculated middle node
		for (@NonNull Node traceNode : traceNodes) {
			addNode(partition, traceNode, Role.SPECULATED);
		}
		for (@NonNull Node traceNode : traceNodes) {
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
				if (edge.isNavigation() && mappingPartitioner.hasRealizedEdge(edge)) {
					tracedInputNodes.add(edge.getEdgeTarget());
				}
			}
			Node globalSuccessNode = mappingPartitioner.basicGetGlobalSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
			if (globalSuccessNode != null) {
				addNode(partition, globalSuccessNode, Role.REALIZED);
			}
		}
	}
}
