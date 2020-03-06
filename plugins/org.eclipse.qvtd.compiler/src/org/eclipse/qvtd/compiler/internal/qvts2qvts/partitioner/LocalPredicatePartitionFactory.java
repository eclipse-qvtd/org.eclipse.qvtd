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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.InvocationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * The LocalPredicate Partition identifies the nodes and edges required to determine whether
 * the local match is satisfied. This creates the speculated trace with predicates solely on
 * constant inputs, loaded inputs and acyclic predicated nodes.
 */
//
// FIXME if multiple heads are predicated, we cannot wait for all of them before speculating. Speculation
//	may need to consider just loaded nodes.
//
public class LocalPredicatePartitionFactory extends AbstractSimplePartitionFactory
{
	protected final boolean useActivators;
	private final @NonNull Iterable<@NonNull Node> executionNodes;
	private final @NonNull Iterable<@NonNull Node> realizedWhenNodes;
	private final @Nullable Node dispatchNode;

	public LocalPredicatePartitionFactory(@NonNull MappingPartitioner mappingPartitioner, boolean useActivators) {
		super(mappingPartitioner);
		this.executionNodes = mappingPartitioner.getExecutionNodes();
		this.useActivators = useActivators;
		this.realizedWhenNodes = mappingPartitioner.getRealizedWhenNodes();
		this.dispatchNode = mappingPartitioner.basicGetDispatchNode();
	}

	@Override
	public @NonNull BasicPartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		String name = computeName("local");
		Iterable<@NonNull Node> headNodes = useActivators ? executionNodes : QVTscheduleUtil.getHeadNodes(mappingPartitioner.getRegion());
		BasicPartition partition = createBasicPartition(name, headNodes);
		int partitionNumber = region.getNextPartitionNumber();
		BasicPartitionAnalysis basicPartitionAnalysis = new BasicPartitionAnalysis(partitionedTransformationAnalysis, partition, reachabilityForest, "«local»", "_p" + partitionNumber);
		initializePartition(basicPartitionAnalysis);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(partition, null);
		}
		return basicPartitionAnalysis;
	}

	/**
	 * Add all old nodes, including node, that have no cyclic dependency and are reachable by to-one navigation from node.
	 */
	protected void gatherReachableOldAcyclicNodes(@NonNull BasicPartition partition, @NonNull Set<@NonNull Node> checkableOldNodes, @NonNull Node node) {
		if (partition.hasNode(node) || checkableOldNodes.contains(node) || mappingPartitioner.isCyclic(node)) {
			return;
		}
		if ((node.isHead() || node.isOld())) {
			// The QVTc SimpleUML2RDBMS uses 'poor style' of multi-child to parent, rather than multiple child-to-parent.
			// this leads to a redundant Set node in classComplexAttributes<<local>>, which could be pruned by
			// excluding predicated collection-type nodes. But it's a not-essential fudge. The true fix is
			// 'good style' or auto-conversion to 'good style' or multi-stage local-predication.
			// if (!(node.isDataType() && node.isPredicated())) {
			checkableOldNodes.add(node);
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
				if (edge.isNavigation() && edge.isOld()) {
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					gatherReachableOldAcyclicNodes(partition, checkableOldNodes, targetNode);
				}
			}
			// }
		}
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(mappingPartitioner.getRegion());
		Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();
		List<@NonNull Node> rootNodes = new ArrayList<>();
		for (@NonNull Node headNode : useActivators ? traceNodes : headNodes) {
			if (!headNode.isDependency()) {
				rootNodes.add(headNode);
			}
		}
		for (@NonNull Node constantInputNode : mappingPartitioner.getConstantInputNodes()) {
			rootNodes.add(constantInputNode);
		}
		return rootNodes;
	}

	protected void initializePartition(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		//	this.traceNode = mappingPartitioner.getTraceNode();
		//	boolean useActivators = useActivators;
		Set<@NonNull Node> originalHeadNodes = Sets.newHashSet(QVTscheduleUtil.getHeadNodes(mappingPartitioner.getRegion()));
		Node dispatchNode = mappingPartitioner.basicGetDispatchNode();

		//
		//	The realized middle (trace) nodes become speculation nodes.
		//
		if (!hasSynthesizedTrace) {
			for (@NonNull Node traceNode : mappingPartitioner.getTraceNodes()) {
				addNode(partition, traceNode, Role.SPECULATION);
			}
		}
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
		Node dispatchNode2 = dispatchNode;
		if (dispatchNode2 != null) {
			assert dispatchNode2.isPredicated();
			addNode(partition, dispatchNode2); //, Role.SPECULATED);
		}
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		resolveConstantInputNodes(partition/*isInfallible*/);
		//
		//	Predicate top-when calls output edges.
		//
		RuleAnalysis ruleAnalysis = mappingPartitioner.getRegionAnalysis().getRuleAnalysis();
		for (@NonNull Node realizedWhenNode : realizedWhenNodes) {
			addNode(partition, realizedWhenNode, Role.PREDICATED);
			InvocationAnalysis invocationAnalysis = ruleAnalysis.getInvocationAnalysis(realizedWhenNode);
			for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(realizedWhenNode)) {
				Node argumentNode = QVTscheduleUtil.getSourceNode(incomingEdge);
				if (invocationAnalysis.isOutput(argumentNode) == Boolean.TRUE) {
					addNode(partition, argumentNode); //, Role.SPECULATED);
				}
			}
		}
		//
		//	All old nodes reachable from heads that are not part of cycles are copied to the speculation guard.
		//	NB. Unreachable loaded nodes are effectively predicates and so are deferred.
		//
		Set<@NonNull Node> checkableOldNodes = new HashSet<>();
		for (@NonNull Node node : originalHeadNodes) {
			gatherReachableOldAcyclicNodes(partition, checkableOldNodes, node);
		}
		if (dispatchNode != null) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(dispatchNode)) {
				assert !edge.isCast();
				if (edge.isNavigation() && edge.isOld()) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					gatherReachableOldAcyclicNodes(partition, checkableOldNodes, sourceNode);
				}
			}
		}
		for (@NonNull Node node : checkableOldNodes) {
			boolean isMandatory = false;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				assert !edge.isCast();
				EdgeConnection connection = ((NavigationEdge)edge).getIncomingConnection();
				if (connection != null) {
					ConnectionRole connectionRole = connection.getTargetRole((NavigationEdge)edge);
					if ((connectionRole != null) && connectionRole.isMandatory()) {
						isMandatory = true;
					}
				}
			}
			if (isMandatory) {
			}
			else if (hasSynthesizedTrace) {
				boolean isCyclicCorollary = transformationAnalysis.isCorollary(node) && mappingPartitioner.isCyclic(node);  // waiting for a cyclic corollary could deadlock
				//			boolean isPredicated = node.isPredicated();
				//			boolean isMatched = node.isMatched();
				//			boolean isUnconditional = node.isUnconditional();
				Utility utility = node.getUtility();
				boolean isWeaklyMatched = utility == Utility.NULLABLE_MATCHED; // Utility.WEAKLY_MATCHED;
				boolean isTraced = isTraced(node, executionNodes);
				if (!isCyclicCorollary && (isTraced || isWeaklyMatched)) {
					addNode(partition, node);
				}
			}
			else {
				addNode(partition, node);
			}
		}
		//
		//	The localSuccess nodes are realized to track speculating success.
		//
		if (hasSynthesizedTrace) {
			resolveSuccessNodes(partition);
		}
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		//		resolveTrueNodes();
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes(partitionAnalysis);
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		resolveDisambiguations(partition);
		//
		//	Join up the edges.
		//
		resolveEdges(partitionAnalysis);
	}

	/**
	 * Return true if edge is available for use by this partition.
	 * The override implementation returns true for all constant and loaded edges.
	 */
	//	@Override
	//	protected boolean isAvailable(@NonNull Edge edge) {
	//		return edge.isConstant() || edge.isLoaded();
	//	}

	/**
	 * Return true if node is available for use by this partition.
	 * The override implementation returns true for all constant and loaded nodes.
	 */
	@Override
	protected boolean isAvailable(@NonNull BasicPartition partition, @NonNull Node node) {
		return node.isConstant() || node.isLoaded();
	}

	protected boolean isTraced(@NonNull Node node, @NonNull Iterable<@NonNull Node> executionNodes) {
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			assert !edge.isCast();
			if (edge.isNavigation()) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				if (Iterables.contains(executionNodes, sourceNode)) {
					return true;
				}
			}
		}
		return false;
	}

	protected void resolveConstantInputNodes(@NonNull BasicPartition partition/*boolean isInfallible*/) {
		for (@NonNull Node constantInputNode : mappingPartitioner.getConstantInputNodes()) {
			//	if ((fallibleNodes == null) || !Iterables.contains(fallibleNodes, constantOutputNode)) {
			if (constantInputNode.getIncomingEdges().isEmpty() && constantInputNode.getOutgoingEdges().isEmpty() && !mappingPartitioner.hasCheckedNode(constantInputNode)) {
				addNode(partition, constantInputNode);
			}
			//	}
		}
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			if (mappingPartitioner.hasRealizedEdge(edge)) {
				edgeRole = Role.PREDICATED;
			}
			else if (dispatchNode == edge.getSourceNode()) {
				edgeRole = null;			// Suppress Diaptach.result assignment
			}
		}
		return edgeRole;
	}

	protected void resolveSuccessNodes(@NonNull BasicPartition partition) {
		for (@NonNull Node traceNode : executionNodes) {
			Node localSuccessNode = mappingPartitioner.getLocalSuccessNode(traceNode);
			addNode(partition, localSuccessNode, Role.REALIZED);
		}
	}
}