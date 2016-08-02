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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.BasicMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MicroMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;

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

	protected final @NonNull BasicMappingRegion region;
	private final @NonNull List<@NonNull Node> loadedNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Edge> predicatedEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedOutputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedOutputNodes = new ArrayList<>();
	private final @NonNull Set<@NonNull NavigationEdge> navigableEdges = new HashSet<>();
	private final @NonNull Set<@NonNull NavigationEdge> realizedEdges = new HashSet<>();
	private final @NonNull List<@NonNull NavigationEdge> realizedOutputEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> trueNodes = new ArrayList<>();

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

	public Partitioner(@NonNull BasicMappingRegion region) {
		//		super(getTraceNodes(region.getNodes()), getNavigableEdges(region.getNavigationEdges()));
		this.region = region;
		analyzeNodes();
		analyzeEdges();
	}

	public boolean addPredicatedEdge(@NonNull Edge edge) {
		return alreadyPredicatedEdges.add(edge);
	}

	public boolean addPredicatedNode(@NonNull Node node) {
		return alreadyPredicatedNodes.add(node);
	}

	public boolean addRealizedEdge(@NonNull Edge edge) {
		return alreadyRealizedEdges.add(edge);
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
			else if (node.isConstant()) {
			}
			else if (node.isLoaded()) {
				loadedNodes.add(node);
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

	public @NonNull Iterable<@NonNull Node> getLoadedNodes() {
		return loadedNodes;
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

	public @NonNull BasicMappingRegion getRegion() {
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

	public @NonNull Iterable<@NonNull MicroMappingRegion> partition() {
		List<@NonNull MicroMappingRegion> regions = new ArrayList<>();
		if (realizedMiddleNodes.isEmpty()) {	// FIXME separate partitioning for folded middle
			//			regions.add(createRealizedRegion());
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
		}
		return regions;
	}

	@Override
	public String toString() {
		return region.toString();
	}
}
