/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class Partitioner
{
	/*	private static @NonNull Iterable<@NonNull NavigationEdge> getNavigableEdges(@NonNull Iterable<@NonNull NavigationEdge> edges) {
		List<@NonNull NavigationEdge> navigableEdges = new ArrayList<>();
		for (@NonNull NavigationEdge edge : edges) {		// cf NavigationForestBuilder addEdge
			if (edge.isSecondary()) {}
			else if (edge.isRealized()) {
				if (edge.getTarget().isLoaded() && edge.getSource().getClassDatumAnalysis().getDomainUsage().isMiddle()) {
					navigableEdges.add(edge);
				}
			}
			else if (!edge.isNavigable()) {}
			else if (edge.isCast()) {}
			else {
				assert !edge.isExpression();
				assert !edge.isComputation();
				Node targetNode = edge.getTarget();
				if (!targetNode.isNull()) {
					navigableEdges.add(edge);
				}
			}
		}
		return navigableEdges;
	} */

	/*	private static @NonNull Iterable<@NonNull Node> getTraceNodes(@NonNull Iterable<@NonNull Node> nodes) {
		List<@NonNull Node> traceNodes = new ArrayList<>();
		for (@NonNull Node node : nodes) {
			if (node.getClassDatumAnalysis().getDomainUsage().isMiddle()) {
				if (node.isRealized()) {
					traceNodes.add(node);
				}
			}
		}
		return traceNodes;
	} */

	public static @NonNull Iterable<@NonNull MappingRegion> partition(@NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		Set<@NonNull Property> corrolaryProperties = new HashSet<>();
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				gatherCorrolaries(corrolaryProperties, (MappingRegion)region);
			}
		}
		List<@NonNull MappingRegion> partitionedRegions = new ArrayList<>();
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				Partitioner partitioner = new Partitioner(problemHandler, (MappingRegion)region, corrolaryProperties);
				Iterables.addAll(partitionedRegions, partitioner.partition());
			}
		}
		return partitionedRegions;
	}

	private static void gatherCorrolaries(@NonNull Set<@NonNull Property> corrolaryProperties, @NonNull MappingRegion region) {
		for (@NonNull Node node : region.getNodes()) {
			if (!node.isTrue() && node.isPattern() && node.isRealized() && node.getClassDatumAnalysis().getDomainUsage().isMiddle()) {
				for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
					if (edge.isRealized() && edge.getEdgeTarget().isRealized()) {
						corrolaryProperties.add(edge.getProperty());
					}
				}
			}
		}
	}

	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull MappingRegion region;

	/**
	 * properties that are directly realized from a middle object provided all predicates are satisfied.
	 */
	protected final @NonNull Set<@NonNull Property> corrolaryProperties;
	private final @NonNull List<@NonNull Edge> predicatedEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedOutputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedOutputNodes = new ArrayList<>();
	private final @NonNull Set<@NonNull NavigableEdge> navigableEdges = new HashSet<>();
	private final @NonNull Set<@NonNull Edge> realizedEdges = new HashSet<>();
	private final @NonNull List<@NonNull Edge> realizedOutputEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> trueNodes = new ArrayList<>();
	private boolean hasLoadedNodes = false;

	/**
	 * Dynamically growing list of edges that have been predicated by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyPredicatedEdges = new HashSet<>();

	/**
	 * Dynamically growing list of nodes that have been predicated by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyPredicatedNodes = new HashSet<>();

	/**
	 * Dynamically growing list of edges that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyRealizedEdges = new HashSet<>();

	/**
	 * Dynamically growing list of nodes that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyRealizedNodes = new HashSet<>();

	/**
	 * Dynamically growing list of true nodes that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyTrueNodes = new HashSet<>();

	private final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull AbstractPartition>> debugEdge2partitions = new HashMap<>();

	public Partitioner(@NonNull ProblemHandler problemHandler, @NonNull MappingRegion region, @NonNull Set<@NonNull Property> corrolaryProperties) {
		//		super(getTraceNodes(region.getNodes()), getNavigableEdges(region.getNavigationEdges()));
		this.problemHandler = problemHandler;
		this.region = region;
		this.corrolaryProperties = corrolaryProperties;
		analyzeNodes();
		analyzeEdges();
	}

	public void addEdge(@NonNull Edge edge, @NonNull EdgeRole newEdgeRole, @NonNull AbstractPartition partition) {
		if (newEdgeRole.isPredicated()) {
			alreadyPredicatedEdges.add(edge);
		}
		else if (newEdgeRole.isRealized()) {
			alreadyRealizedEdges.add(edge);
		}
		List<@NonNull AbstractPartition> partitions = debugEdge2partitions.get(edge);// TODO Auto-generated method stub
		if (partitions == null) {
			partitions = new ArrayList<>();
			debugEdge2partitions.put(edge, partitions);
		}
		assert !partitions.contains(partition);
		partitions.add(partition);
	}

	public boolean addPredicatedNode(@NonNull Node node) {
		return alreadyPredicatedNodes.add(node);
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	public boolean addRealizedNode(@NonNull Node node) {
		return alreadyRealizedNodes.add(node);
	}

	public boolean addTrueNode(@NonNull Node node) {
		return alreadyTrueNodes.add(node);
	}

	private void analyzeEdges() {
		for (@NonNull Edge edge : region.getEdges()) {
			if (!edge.isSecondary()) {
				if (edge.isPredicated()) {
					predicatedEdges.add(edge);
				}
				if (edge.isNavigation()) {
					if (edge.isRealized()) {
						realizedEdges.add(edge);
						Node sourceNode = edge.getEdgeSource();
						if (!realizedMiddleNodes.contains(sourceNode) && (sourceNode.isPredicated() || sourceNode.isRealized())) {
							Node targetNode = edge.getEdgeTarget();
							if (!realizedMiddleNodes.contains(targetNode) && (targetNode.isPredicated() || targetNode.isRealized())) {
								realizedOutputEdges.add(edge);
							}
						}
						if (edge.getEdgeTarget().isLoaded() && edge.getEdgeSource().getClassDatumAnalysis().getDomainUsage().isMiddle()) {
							//							navigableEdges.add(navigationEdge);
						}
					}
					else if (edge.isMatched() && !edge.isCast()) {
						assert !edge.isExpression();
						assert !edge.isComputation();
						Node targetNode = edge.getEdgeTarget();
						if (!targetNode.isExplicitNull()) {
							//							navigableEdges.add(navigationEdge);
						}
					}
				}
				/*				else if (RegionUtil.isRealizedIncludes(edge)) {
					realizedEdges.add(edge);
					Node sourceNode = edge.getSource();
					if (!realizedMiddleNodes.contains(sourceNode) && (sourceNode.isPredicated() || sourceNode.isRealized())) {
						Node targetNode = edge.getTarget();
						if (!realizedMiddleNodes.contains(targetNode) && (targetNode.isPredicated() || targetNode.isRealized())) {
							realizedOutputEdges.add(edge);
						}
					}
					if (edge.getTarget().isLoaded() && edge.getSource().getClassDatumAnalysis().getDomainUsage().isMiddle()) {
						//							navigableEdges.add(navigationEdge);
					}
				} */
			}
		}
		for (@NonNull NavigableEdge edge : region.getNavigationEdges()) {
			if (!edge.isSecondary() && !edge.isRealized()) {
				navigableEdges.add(edge);
			}
		}
	}

	private void analyzeNodes() {
		for (@NonNull Node node : region.getNodes()) {
			if (node.isTrue()) {
				trueNodes.add(node);
			}
			else if (node.isPattern()) {
				if (node.isConstant()) {
				}
				else if (node.isLoaded()) {
					hasLoadedNodes  = true;
				}
				else if (node.getClassDatumAnalysis().getDomainUsage().isMiddle()) {
					if (node.isPredicated()) {
						predicatedMiddleNodes.add(node);
					}
					else if (node.isRealized()) {
						realizedMiddleNodes.add(node);
						//					for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
						//						Node targetNode = edge.getTarget();
						//						NodeRole targetNodeRole = targetNode.getNodeRole();
						//						if (!targetNodeRole.isPredicated() && !targetNodeRole.isRealized()) {
						//							tracedInputNodes.add(targetNode);
						//						}
						//					}
					}
					else if (!node.isExplicitNull()) {
						throw new IllegalStateException("middle node must be predicated or realized : " + node);
					}

				}
				else {
					if (!node.isOperation()) {
						if (node.isPredicated()) {
							predicatedOutputNodes.add(node);
						}
						else if (node.isRealized()) {
							realizedOutputNodes.add(node);
						}
					}
				}
			}
		}
	}

	private void check() {
		for (@NonNull Node node : region.getNodes()) {
			if ((node.isSpeculated() || node.isRealized()) && !hasRealizedNode(node)) {
				problemHandler.addProblem(RegionUtil.createRegionError(region, "Should have realized " + node));
			}
		}
		Set<@NonNull Edge> allPrimaryEdges = new HashSet<>();
		for (@NonNull Edge edge : region.getEdges()) {
			if (!edge.isSecondary()) {
				allPrimaryEdges.add(edge);
				if (edge.isRealized() && !hasRealizedEdge(edge)) {
					problemHandler.addProblem(RegionUtil.createRegionError(region, "Should have realized " + edge));
				}
			}
		}
		//
		Set<@NonNull Node> deadNodes = computeDeadNodes(region.getNodes());
		Set<@NonNull Edge> deadEdges = computeDeadEdges(deadNodes);
		allPrimaryEdges.removeAll(deadEdges);
		Set<@NonNull Edge> partitionedEdges = new HashSet<>(debugEdge2partitions.keySet());
		if (!partitionedEdges.equals(allPrimaryEdges)) {
			Set<@NonNull Edge> extraEdgesSet = Sets.newHashSet(partitionedEdges);
			CompilerUtil.removeAll(extraEdgesSet, allPrimaryEdges);
			for (@NonNull Edge edge : extraEdgesSet) {
				problemHandler.addProblem(RegionUtil.createRegionWarning(region, "Extra " + edge));
			}
			Set<@NonNull Edge> missingEdgesSet = Sets.newHashSet(allPrimaryEdges);
			missingEdgesSet.removeAll(partitionedEdges);
			for (@NonNull Edge edge : missingEdgesSet) {
				if (!isCorrolary(edge)) {// && !isDead(edge)) {
					problemHandler.addProblem(RegionUtil.createRegionWarning(region, "Missing " + edge));
				}
			}
		}
	}

	private @NonNull Set<@NonNull Edge> computeDeadEdges(@NonNull Iterable<@NonNull Node> deadNodes) {
		Set<@NonNull Edge> deadEdges = new HashSet<>();
		for (@NonNull Node node : deadNodes) {
			deadEdges.addAll(node.getIncomingEdges());
			deadEdges.addAll(node.getOutgoingEdges());
		}
		return deadEdges;
	}

	private @NonNull Set<@NonNull Node> computeDeadNodes(@NonNull Iterable<@NonNull Node> nodes) {
		Set<@NonNull Node> deadNodes = new HashSet<>();
		Set<@NonNull Node> moreDeadNodes = null;
		for (@NonNull Node node : nodes) {
			if (!node.isHead() && isDead(node, null)) {
				if (moreDeadNodes == null) {
					moreDeadNodes = new HashSet<>();
				}
				moreDeadNodes.add(node);
			}
		}
		if (moreDeadNodes == null) {
			return deadNodes;
		}
		while (moreDeadNodes.size() > 0) {
			deadNodes.addAll(moreDeadNodes);
			List<@NonNull Node> moreDeadNodesList = new ArrayList<>(moreDeadNodes);
			moreDeadNodes = null;
			for (@NonNull Node deadNode : moreDeadNodesList) {
				for (@NonNull Edge edge : deadNode.getIncomingEdges()) {
					Node sourceNode = edge.getEdgeSource();
					if (!sourceNode.isHead() && isDead(sourceNode, deadNodes)) {
						if (moreDeadNodes == null) {
							moreDeadNodes = new HashSet<>();
						}
						moreDeadNodes.add(sourceNode);
					}
				}
			}
			if (moreDeadNodes == null) {
				break;
			}
		}
		return deadNodes;
	}

	private @NonNull MicroMappingRegion createAssignmentRegion(@NonNull Edge outputEdge, int i) {
		AssignmentPartition realizedPartition = new AssignmentPartition(this, outputEdge);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«edge" + i + "»", "_p" + i);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			microMappingRegion.writeDebugGraphs(null);
		}
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createRealizedRegion() {
		RealizedPartition realizedPartition = new RealizedPartition(this);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«realized»", "_r0");
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			microMappingRegion.writeDebugGraphs(null);
		}
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatedRegion() {
		SpeculatedPartition speculatedPartition = new SpeculatedPartition(this);
		MicroMappingRegion microMappingRegion = speculatedPartition.createMicroMappingRegion("«speculated»", "_p1");
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			microMappingRegion.writeDebugGraphs(null);
		}
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculationRegion() {
		SpeculationPartition speculationPartition = new SpeculationPartition(this);
		MicroMappingRegion microMappingRegion = speculationPartition.createMicroMappingRegion("«speculation»", "_p0");
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			microMappingRegion.writeDebugGraphs(null);
		}
		return microMappingRegion;
	}

	public @NonNull Iterable<@NonNull Edge> getAlreadyPredicatedEdges() {
		return alreadyPredicatedEdges;
	}

	public @NonNull Iterable<@NonNull Edge> getAlreadyRealizedEdges() {
		return alreadyRealizedEdges;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getNavigableEdges() {
		return navigableEdges;
	}

	public @NonNull Iterable<@NonNull Edge> getPredicatedEdges() {
		return predicatedEdges;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedMiddleNodes() {
		return predicatedMiddleNodes;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedOutputNodes() {
		return predicatedOutputNodes;
	}

	public @NonNull Iterable<@NonNull Edge> getRealizedEdges() {
		return realizedEdges;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedMiddleNodes() {
		return realizedMiddleNodes;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedOutputNodes() {
		return realizedOutputNodes;
	}

	public @NonNull MappingRegion getRegion() {
		return region;
	}

	public @NonNull Iterable<@NonNull Node> getTrueNodes() {
		return trueNodes;
	}

	public boolean hasPredicatedEdge(@NonNull Edge edge) {
		return alreadyPredicatedEdges.contains(edge);
	}

	public boolean hasPredicatedNode(@NonNull Node node) {
		return alreadyPredicatedNodes.contains(node);
	}

	public boolean hasRealizedEdge(@NonNull Edge edge) {
		return alreadyRealizedEdges.contains(edge);
	}

	public boolean hasRealizedNode(@NonNull Node node) {
		return alreadyRealizedNodes.contains(node);
	}

	public boolean hasTrueNode(@NonNull Node node) {
		return alreadyTrueNodes.contains(node);
	}

	public boolean isCorrolary(@NonNull Edge edge) {
		if (!edge.isNavigation()) {
			return false;
		}
		return corrolaryProperties.contains(((NavigableEdge)edge).getProperty());
	}
	private boolean isDead(@NonNull Node node, @Nullable Set<@NonNull Node> knownDeadNodes) {
		if (node.isHead()) {
			return false;
		}
		for (@NonNull Edge edge : node.getIncomingEdges()) {
			if (edge.isNavigation()) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeSource())) {
					return false;
				}
			}
		}
		for (@NonNull Edge edge : node.getOutgoingEdges()) {
			if (edge.isNavigation() || edge.isExpression()) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeTarget())) {
					return false;
				}
			}
		}
		return true;
	}


	/*	private boolean isDead(@NonNull Edge edge) {
		if (!edge.isExpression()) {
			return false;
		}
		Node node = edge.getTarget();
		for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
			if ((incomingEdge != edge) && incomingEdge.isMatched()) {
				return false;
			}
		}
		for (@NonNull Edge outgoingEdge : node.getOutgoingEdges()) {
			if (!isDead(outgoingEdge)) {
				return false;
			}
		}
		return true;
	} */

	public @NonNull Iterable<@NonNull MappingRegion> partition() {
		//		System.out.println("    partition " + region);
		List<@NonNull MappingRegion> regions = new ArrayList<>();
		if (realizedMiddleNodes.isEmpty() && predicatedMiddleNodes.isEmpty()) {	// FIXME separate partitioning for folded middle
			//			regions.add(createRealizedRegion());
		}
		else {
			if (!hasLoadedNodes) {
				regions.add(region);
			}
			else {
				if (predicatedMiddleNodes.isEmpty()) {
					regions.add(createRealizedRegion());
				}
				else {
					regions.add(createSpeculationRegion());
					regions.add(createSpeculatedRegion());
				}
				for (@NonNull Edge outputEdge : realizedOutputEdges) {
					if (!hasRealizedEdge(outputEdge)) {
						regions.add(createAssignmentRegion(outputEdge, regions.size()));
					}
				}
				check();
			}
		}
		return regions;
	}

	@Override
	public String toString() {
		return region.toString();
	}
}
