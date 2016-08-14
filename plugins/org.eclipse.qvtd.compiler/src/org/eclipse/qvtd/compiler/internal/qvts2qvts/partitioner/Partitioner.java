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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MicroMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

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

	public static @NonNull Iterable<@NonNull MappingRegion> partition(@NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		Set<@NonNull Property> corrolaryProperties = new HashSet<>();
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				gatherCorrolaries(corrolaryProperties, (MappingRegion)region);
			}
		}
		List<@NonNull MappingRegion> partitionedRegions = new ArrayList<>();
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				Partitioner partitioner = new Partitioner((MappingRegion)region, corrolaryProperties);
				Iterables.addAll(partitionedRegions, partitioner.partition());
			}
		}
		return partitionedRegions;
	}

	private static void gatherCorrolaries(@NonNull Set<@NonNull Property> corrolaryProperties, @NonNull MappingRegion region) {
		for (@NonNull Node node : region.getNodes()) {
			if (!node.isTrue() && node.isPattern() && node.isRealized() && node.getClassDatumAnalysis().getDomainUsage().isMiddle()) {
				for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
					if (edge.isRealized() && edge.getTarget().isRealized()) {
						corrolaryProperties.add(edge.getProperty());
					}
				}
			}
		}
	}

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
	private final @NonNull Set<@NonNull NavigationEdge> navigableEdges = new HashSet<>();
	private final @NonNull Set<@NonNull NavigationEdge> realizedEdges = new HashSet<>();
	private final @NonNull List<@NonNull NavigationEdge> realizedOutputEdges = new ArrayList<>();
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

	public Partitioner(@NonNull MappingRegion region, @NonNull Set<@NonNull Property> corrolaryProperties) {
		//		super(getTraceNodes(region.getNodes()), getNavigableEdges(region.getNavigationEdges()));
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
					NavigationEdge navigationEdge = (NavigationEdge) edge;
					if (edge.isRealized()) {
						realizedEdges.add(navigationEdge);
						Node sourceNode = edge.getSource();
						if (!realizedMiddleNodes.contains(sourceNode) && (sourceNode.isPredicated() || sourceNode.isRealized())) {
							Node targetNode = edge.getTarget();
							if (!realizedMiddleNodes.contains(targetNode) && (targetNode.isPredicated() || targetNode.isRealized())) {
								realizedOutputEdges.add(navigationEdge);
							}
						}
						if (edge.getTarget().isLoaded() && edge.getSource().getClassDatumAnalysis().getDomainUsage().isMiddle()) {
							navigableEdges.add(navigationEdge);
						}
					}
					else if (edge.isNavigable() && !edge.isCast()) {
						assert !edge.isExpression();
						assert !edge.isComputation();
						Node targetNode = edge.getTarget();
						if (!targetNode.isNull()) {
							navigableEdges.add(navigationEdge);
						}
					}
				}
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
					else if (!node.isNull()) {
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
			if (node.isSpeculated() || node.isRealized()) {
				assert hasRealizedNode(node) : "Should have realized " + node + " in " + region;
			}
		}
		Set<@NonNull Edge> allPrimaryEdges = new HashSet<>();
		for (@NonNull Edge edge : region.getEdges()) {
			if (!edge.isSecondary()) {
				allPrimaryEdges.add(edge);
				if (edge.isRealized()) {
					assert hasRealizedEdge(edge) : "Should have realized " + edge + " in " + region;
				}
			}
		}
		//
		Set<@NonNull Edge> partitionedEdges = debugEdge2partitions.keySet();
		if (!partitionedEdges.equals(allPrimaryEdges)) {
			StringBuilder s = null;
			Set<@NonNull Edge> extraEdgesSet = Sets.newHashSet(partitionedEdges);
			CompilerUtil.removeAll(extraEdgesSet, allPrimaryEdges);
			for (@NonNull Edge edge : extraEdgesSet) {
				if (s == null) {
					s = new StringBuilder();
				}
				s.append("\nextra: ");
				s.append(edge);
			}
			Set<@NonNull Edge> missingEdgesSet = Sets.newHashSet(allPrimaryEdges);
			missingEdgesSet.removeAll(partitionedEdges);
			for (@NonNull Edge edge : missingEdgesSet) {
				if (!isCorrolary(edge) && !isDead(edge)) {
					if (s == null) {
						s = new StringBuilder();
					}
					s.append("\nmissing: ");
					s.append(edge);
				}
			}
			assert s == null : "Bad edges for " + region + s.toString();
		}
	}

	private boolean isDead(@NonNull Edge edge) {
		if (!edge.isExpression()) {
			return false;
		}
		Node node = edge.getTarget();
		for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
			if (incomingEdge.isNavigable()) {
				return false;
			}
		}
		for (@NonNull Edge outgoingEdge : node.getOutgoingEdges()) {
			if (!isDead(outgoingEdge)) {
				return false;
			}
		}
		return true;
	}

	private @NonNull MicroMappingRegion createAssignmentRegion(@NonNull NavigationEdge outputEdge, int i) {
		AssignmentPartition realizedPartition = new AssignmentPartition(this, outputEdge);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«edge" + i + "»", ".p" + i);
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			microMappingRegion.writeDebugGraphs(null);
		}
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createRealizedRegion() {
		RealizedPartition realizedPartition = new RealizedPartition(this);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«realized»", ".r0");
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			microMappingRegion.writeDebugGraphs(null);
		}
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatedRegion() {
		SpeculatedPartition speculatedPartition = new SpeculatedPartition(this);
		MicroMappingRegion microMappingRegion = speculatedPartition.createMicroMappingRegion("«speculated»", ".p1");
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			microMappingRegion.writeDebugGraphs(null);
		}
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculationRegion() {
		SpeculationPartition speculationPartition = new SpeculationPartition(this);
		MicroMappingRegion microMappingRegion = speculationPartition.createMicroMappingRegion("«speculation»", ".p0");
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
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

	public @NonNull Iterable<@NonNull NavigationEdge> getNavigableEdges() {
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

	public @NonNull Iterable<@NonNull NavigationEdge> getRealizedEdges() {
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
		return corrolaryProperties.contains(((NavigationEdge)edge).getProperty());
	}

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
				for (@NonNull NavigationEdge outputEdge : realizedOutputEdges) {
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
