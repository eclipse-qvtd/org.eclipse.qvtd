/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
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
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public abstract class AbstractSimplePartitionFactory extends AbstractPartitionFactory<@NonNull RuleRegion>
{
	protected final @NonNull MappingPartitioner mappingPartitioner;
	//	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;
	//	protected final @NonNull RuleRegion region;

	/**
	 * The QVTr synthesis includes trace synthesis with activators and local/globalSuccess to interlink.
	 * The QVTc synthesis relies on the externally provided trace.
	 */
	protected final boolean hasSynthesizedTrace;

	/**
	 * The nodes of region that are required by the partition. This is identical to node2nodeRole.keySet() but in a linear
	 * list to facilitate recursions over all nodes so far.
	 */
	private final @NonNull List<@NonNull Node> nodes = new ArrayList<>();

	protected AbstractSimplePartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		super(mappingPartitioner.getScheduleManager(), (RuleRegion)mappingPartitioner.getRegion());
		this.mappingPartitioner = mappingPartitioner;
		//	this.scheduleManager = mappingPartitioner.getScheduleManager();
		this.transformationAnalysis = mappingPartitioner.getRegionAnalysis().getTransformationAnalysis();
		//	this.region = (RuleRegion) mappingPartitioner.getRegion();
		this.hasSynthesizedTrace = scheduleManager.useActivators();
	}

	@Override
	protected void addEdge(@NonNull BasicPartition partition, @NonNull Edge edge, @NonNull Role newEdgeRole) {
		assert edge.getOwningRegion() == region;
		Role oldEdgeRole = QVTscheduleUtil.getEdgeRole(edge);
		switch (oldEdgeRole)
		{
			case CONSTANT_SUCCESS_FALSE: /* fall through */
			case CONSTANT_SUCCESS_TRUE: /* fall through */
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
				if (!mappingPartitioner.hasRealizedEdge(edge)) {
					assert newEdgeRole == Role.REALIZED;
				}
				//				else if (this instanceof SpeculatingPartitionFactory) {
				//					assert (newEdgeRole == Role.PREDICATED) || (newEdgeRole == Role.SPECULATED);		// FIXME rationalize
				//				}
				else {
					assert newEdgeRole == Role.PREDICATED;
				}
				break;
			}
			default: {
				throw new UnsupportedOperationException(getClass().getSimpleName() + ".addEdge " + edge);
			}
		}
		super.addEdge(partition, edge, newEdgeRole);
	}

	@Override
	protected void addEdge2(@NonNull BasicPartition partition, @NonNull Edge edge, @NonNull Role newEdgeRole) {
		super.addEdge2(partition, edge, newEdgeRole);
		mappingPartitioner.addEdge(edge, newEdgeRole, partition);
	}

	protected void addNode(@NonNull BasicPartition partition, @NonNull Node node) {
		Role oldNodeRole = QVTscheduleUtil.getNodeRole(node);
		addNode(partition, node, oldNodeRole);
	}

	protected void addNode(@NonNull BasicPartition partition, @NonNull Node node, @NonNull Role newNodeRole) {
		assert node.getOwningRegion() == region;
		Role oldNodeRole = QVTscheduleUtil.getNodeRole(node);
		switch (oldNodeRole)
		{
			case CONSTANT_SUCCESS_FALSE: /* fall through */
			case CONSTANT_SUCCESS_TRUE: /* fall through */
			case CONSTANT: {
				assert newNodeRole == Role.CONSTANT;
				//				if (node.isTrue()) {
				//					mappingPartitioner.addTrueNode(node);
				//				}
				break;
			}
			case LOADED: {
				assert newNodeRole == Role.LOADED;
				break;
			}
			case SPECULATED: //  {
				//		assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
				//		//				mappingPartitioner.addSpeculatedNode(node);
				//		break;
				//	}
			case PREDICATED: {
				assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
				mappingPartitioner.addCheckedNode(node);
				break;
			}
			case REALIZED: {
				if (!mappingPartitioner.hasRealizedNode(node)) {
					// FIXME QVTc fudge	assert newNodeRole == Role.REALIZED || newNodeRole == Role.SPECULATION;
					mappingPartitioner.addRealizedNode(node);
				}
				else {
					if (node instanceof SuccessNode) {
						assert newNodeRole == Role.CONSTANT_SUCCESS_TRUE;
					}
					else if (newNodeRole == Role.REALIZED || newNodeRole == Role.SPECULATION) {
						assert false;
						return;		// FIXME redundant call
					}
					else {
						assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
					}
				}
				break;
			}
			default: {
				throw new UnsupportedOperationException(getClass().getSimpleName() + ".addNode " + node);
			}
		}
		Role displacedNodeRole = partition.putNodeRole(node, newNodeRole);
		assert (displacedNodeRole == null) || (displacedNodeRole == newNodeRole);
		nodes.add(node);
	}

	protected @NonNull String computeName(@NonNull String suffix){
		return QVTscheduleUtil.getName(region) + "«" + suffix + "»";
	}

	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	@Override
	protected @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		List<@NonNull NavigableEdge> navigableEdges = Lists.newArrayList(mappingPartitioner.getOldPrimaryNavigableEdges());
		for (@NonNull Edge edge : mappingPartitioner.getAlreadyRealizedEdges()) {
			if (edge instanceof NavigableEdge) {
				navigableEdges.add((NavigableEdge) edge);
			}
		}
		return navigableEdges;
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();
		Iterable<@NonNull Node> constantInputNodes = mappingPartitioner.getConstantInputNodes();
		Node thisNode = mappingPartitioner.getThisNode();
		if (thisNode != null) {
			return Iterables.concat(traceNodes, Collections.singletonList(thisNode), constantInputNodes);
		}
		else {
			return Iterables.concat(traceNodes, constantInputNodes);
		}
	}


	/**
	 * Return true if edge is available for use by this partition.
	 * The default implementation returns true for all old edges.
	 */
	//	protected boolean isAvailable(@NonNull Edge edge) {
	//		return isOld(edge);
	//	}

	/**
	 * Return true if node is available for use by this partition.
	 * The default implementation returns true for all old nodes.
	 */
	protected boolean isAvailable(@NonNull BasicPartition partition, @NonNull Node node) {
		Role role = partition.getRole(node);
		return role != null ? role.isOld() : false;
	}

	@Override
	protected @Nullable Role resolveCheckedEdgeRole(@NonNull Edge edge, @NonNull Role edgeRole) {
		assert edgeRole != Role.REALIZED;
		if (edge.isCast() || edge.isNavigation()) {
			if (mappingPartitioner.hasRealizedEdge(edge)) {
				return null;			// A realized edge does not need to be checked
			}
			else if (mappingPartitioner.hasCheckedEdge(edge)) {
				return null;			// An already checked edge does not need to be checked
			}
			else if (mappingPartitioner.hasLoadedEdge(edge)) {
				return null;			// An already loaded edge does not need to be checked
			}
			else if (mappingPartitioner.hasConstantEdge(edge)) {
				return null;			// An already constant edge does not need to be checked
			}
			else {
				// FIXME iff the redundant edge is provably to-1 redundant omit it
			}
		}
		return edgeRole;
	}

	protected void resolveDisambiguations(@NonNull BasicPartition partition) {
		for (@NonNull Node traceNode : mappingPartitioner.getTraceNodes()) {
			PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis = mappingPartitioner.getClassAnalysis(traceNode);
			Iterable<@NonNull Property> discriminatingProperties = classAnalysis.getDiscriminatingProperties();
			if (discriminatingProperties != null) {
				for (@NonNull Property property : discriminatingProperties) {
					Node targetNode = traceNode.getNavigableTarget(property);
					assert targetNode != null;
					if (!partition.hasNode(targetNode)) {
						addNode(partition, targetNode);
					}
				}
			}
		}
	}

	/**
	 * Ensure that the predecessors of each node are included in the partition.
	 */
	protected void resolvePrecedingNodes(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			assert node != null;
			Edge traceEdge = mappingPartitioner.getTraceEdge(node);
			Node sourceNode = traceEdge != null ? QVTscheduleUtil.getSourceNode(traceEdge) : null;
			boolean hasSourceNode = (sourceNode != null) && partition.hasNode(sourceNode);
			if ((traceEdge == null) || !mappingPartitioner.hasRealizedEdge(traceEdge) || !hasSourceNode) {
				boolean gotOne = false;
				for (@NonNull Node precedingNode : partitionAnalysis.getPredecessorsClosure(node)) {
					gotOne = true;
					if (!partition.hasNode(precedingNode)) {
						addNode(partition, precedingNode, mappingPartitioner.hasRealizedNode(precedingNode) ? Role.PREDICATED : QVTscheduleUtil.getNodeRole(precedingNode));
					}
				}
				if (!gotOne && (traceEdge != null)) {
					Role edgeRole = partition.getRole(traceEdge);
					if ((edgeRole != null) && edgeRole.isRealized()) {
						gotOne = true;
						if (!hasSourceNode) {
							assert sourceNode != null;
							addNode(partition, sourceNode);
						}
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

	@Override
	protected @Nullable Role resolveReachingEdgeRole(@NonNull BasicPartition partition, @NonNull Set<@NonNull Edge> reachingEdges, @NonNull Edge edge, @NonNull Role edgeRole) {
		assert edgeRole == Role.REALIZED;
		if (!mappingPartitioner.hasRealizedEdge(edge)) {
			return edgeRole;
		}
		else if (reachingEdges.contains(edge)) {
			return Role.PREDICATED;
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull String toString() {
		return getClass().getSimpleName() + " for " + mappingPartitioner;
	}
}