/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
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

public abstract class AbstractPartitionFactory extends RegionHelper<@NonNull RuleRegion> implements PartitionFactory
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

	protected AbstractPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		super(mappingPartitioner.getScheduleManager(), (RuleRegion)mappingPartitioner.getRegion());
		this.mappingPartitioner = mappingPartitioner;
		//	this.scheduleManager = mappingPartitioner.getScheduleManager();
		this.transformationAnalysis = mappingPartitioner.getRegionAnalysis().getTransformationAnalysis();
		//	this.region = (RuleRegion) mappingPartitioner.getRegion();
		this.hasSynthesizedTrace = scheduleManager.useActivators();
	}

	private void addEdge(@NonNull BasicPartition partition, @NonNull Edge edge, @NonNull Role newEdgeRole) {
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
		mappingPartitioner.addEdge(edge, newEdgeRole, partition);
		Role displacedEdgeRole = partition.putEdgeRole(edge, newEdgeRole);
		assert (displacedEdgeRole == null) || (displacedEdgeRole == newEdgeRole);
		if (edge instanceof NavigableEdge) {
			NavigableEdge oppositeEdge = ((NavigableEdge)edge).getOppositeEdge();
			if (oppositeEdge != null) {
				mappingPartitioner.addEdge(oppositeEdge, newEdgeRole, partition);
				Role displacedOppositeEdgeRole = partition.putEdgeRole(oppositeEdge, newEdgeRole);
				assert (displacedOppositeEdgeRole == null) || (displacedOppositeEdgeRole == newEdgeRole);
			}
		}
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
			case SPECULATED: {
				assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
				//				mappingPartitioner.addSpeculatedNode(node);
				break;
			}
			case PREDICATED: {
				assert newNodeRole == Role.PREDICATED || newNodeRole == Role.SPECULATED;
				mappingPartitioner.addPredicatedNode(node);
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

	protected @NonNull ReachabilityForest createReachabilityForest() {
		return new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
	}

	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	protected @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		List<@NonNull NavigableEdge> navigableEdges = Lists.newArrayList(mappingPartitioner.getOldPrimaryNavigableEdges());
		for (@NonNull Edge edge : mappingPartitioner.getAlreadyRealizedEdges()) {
			if (edge instanceof NavigableEdge) {
				navigableEdges.add((NavigableEdge) edge);
			}
		}
		return navigableEdges;
	}

	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();
		Iterable<@NonNull Node> constantInputNodes = mappingPartitioner.getConstantInputNodes();
		return Iterables.concat(traceNodes, constantInputNodes);
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

	protected void resolveDisambiguations(@NonNull BasicPartition partition) {
		for (@NonNull Node traceNode : mappingPartitioner.getTraceNodes()) {
			TraceClassRegionAnalysis traceClassAnalysis = mappingPartitioner.getTraceClassAnalysis(traceNode);
			Iterable<@NonNull Property> discriminatingProperties = traceClassAnalysis.getDiscriminatingProperties();
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
	protected void resolveEdges(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		ReachabilityForest reachabilityForest = partitionAnalysis.getReachabilityForest();
		Set<@NonNull Edge> reachingEdges = new HashSet<>();
		//
		//	Add all the edges necessary to reach each node.
		//
		for (@NonNull Node node : partition.getPartialNodes()) {
			Edge reachingEdge = reachabilityForest.getReachingEdge(node);
			if (reachingEdge != null) {
				reachingEdges.add(reachingEdge);
				if (!partition.hasEdge(reachingEdge)) {
					Role sourceNodeRole = partition.getRole(reachingEdge.getEdgeSource());
					if (sourceNodeRole != null) {
						Role targetNodeRole = partition.getRole(reachingEdge.getEdgeTarget());
						if (targetNodeRole != null) {
							Role edgeRole = resolveEdgeRole(sourceNodeRole, reachingEdge, targetNodeRole);
							if (edgeRole != null) {
								if (mappingPartitioner.hasRealizedEdge(reachingEdge)) {
									edgeRole = Role.PREDICATED;
								}
								addEdge(partition, reachingEdge, edgeRole);
							}
						}
					}

					//					Role role = reachingEdge.getEdgeRole();
					//					if (mappingPartitioner.hasRealizedEdge(reachingEdge)) {
					//						role = Role.PREDICATED;
					//					}
					//					partition.addEdge(reachingEdge, role);
				}
			}
		}
		//
		//	Add all the edges necessary to reach each node.
		//
		for (@NonNull Node node : partition.getPartialNodes()) {
			if (node.isOperation()) {
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
					if ((edge.isExpression() || edge.isNavigation()) && !partition.hasEdge(edge)) {
						Role sourceNodeRole = partition.getRole(edge.getEdgeSource());
						if (sourceNodeRole != null) {
							Role targetNodeRole = partition.getRole(edge.getEdgeTarget());
							if (targetNodeRole != null) {
								Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
								if (edgeRole != null) {
									if (edgeRole == Role.REALIZED) {
										if (mappingPartitioner.hasRealizedEdge(edge)) {
											edgeRole = reachingEdges.contains(edge) ? Role.PREDICATED : null;
										}
									}
									if (edgeRole != null) {
										addEdge(partition, edge, edgeRole);
									}
								}
							}
						}
					}
				}
			}
			else {
				Edge edge = reachabilityForest.getReachingEdge(node);
				if ((edge != null) && !partition.hasEdge(edge)) {
					assert /*!edge.isSecondary() &&*/ !partition.hasEdge(edge);
					Role sourceNodeRole = partition.getRole(edge.getEdgeSource());
					if (sourceNodeRole != null) {
						Role targetNodeRole = partition.getRole(edge.getEdgeTarget());
						if (targetNodeRole != null) {
							Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
							if (edgeRole != null) {
								if (edgeRole == Role.REALIZED) {
									if (mappingPartitioner.hasRealizedEdge(edge) || reachingEdges.contains(edge)) {
										edgeRole = Role.PREDICATED;
									}
									else {
										edgeRole = null;
									}
								}
								if (edgeRole != null) {
									addEdge(partition, edge, edgeRole);
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
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(mappingPartitioner.getRegion())) {
			//	for (@NonNull Edge edge : getPartialEdges()) {
			if (!edge.isSecondary() && !partition.hasEdge(edge)) {
				Role sourceNodeRole = partition.getRole(edge.getEdgeSource());
				if (sourceNodeRole != null) {
					Role targetNodeRole = partition.getRole(edge.getEdgeTarget());
					if (targetNodeRole != null) {
						Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
						if (edgeRole != null) {
							if (edgeRole == Role.REALIZED) {
								if (mappingPartitioner.hasRealizedEdge(edge)) {
									edgeRole = reachingEdges.contains(edge) ? Role.PREDICATED : null;
								}
							}
							else if (edge.isCast() || edge.isNavigation()) {
								if (mappingPartitioner.hasRealizedEdge(edge)) {
									edgeRole = null;			// A realized edge does not need to be checked
								}
								else if (mappingPartitioner.hasPredicatedEdge(edge)) {
									edgeRole = null;			// An already predicated edge does not need to be checked
								}
								else if (mappingPartitioner.hasLoadedEdge(edge)) {
									edgeRole = null;			// An already loaded edge does not need to be checked
								}
								else if (mappingPartitioner.hasConstantEdge(edge)) {
									edgeRole = null;			// An already constant edge does not need to be checked
								}
								else {
									// FIXME iff the redundant edge is provably to-1 redundant omit it
								}
							}
							if (edgeRole != null) {
								addEdge(partition, edge, edgeRole);
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
				for (@NonNull Node precedingNode : partitionAnalysis.getPredecessors(node)) {
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
	public @NonNull String toString() {
		return getClass().getSimpleName() + " for " + mappingPartitioner;
	}
}