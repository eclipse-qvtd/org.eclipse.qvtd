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
import org.eclipse.qvtd.compiler.internal.qvts2qvti.AbstractForestBuilder;

public class Partitioner extends AbstractForestBuilder
{
	private static @NonNull Iterable<@NonNull NavigationEdge> getNavigableEdges(@NonNull Iterable<@NonNull NavigationEdge> edges) {
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
	}

	private static @NonNull Iterable<@NonNull Node> getTraceNodes(@NonNull Iterable<@NonNull Node> nodes) {
		List<@NonNull Node> traceNodes = new ArrayList<>();
		for (@NonNull Node node : nodes) {
			if (node.getClassDatumAnalysis().getDomainUsage().isMiddle()) {
				if (node.isRealized()) {
					traceNodes.add(node);
				}
			}
		}
		return traceNodes;
	}

	protected final @NonNull BasicMappingRegion region;
	private final @NonNull List<@NonNull Node> loadedNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedOutputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedOutputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigationEdge> realizedOutputEdges = new ArrayList<>();
	private final @NonNull Set<@NonNull Edge> realizedEdges = new HashSet<>();

	public Partitioner(@NonNull BasicMappingRegion region) {
		super(getTraceNodes(region.getNodes()), getNavigableEdges(region.getNavigationEdges()));
		this.region = region;
		analyzeNodes();
		analyzeEdges();
	}

	public boolean addRealizedEdge(@NonNull Edge edge) {
		return realizedEdges.add(edge);
	}

	private void analyzeEdges() {
		for (@NonNull Edge edge : region.getEdges()) {
			if (edge.isRealized() && !edge.isSecondary()) {
				Node sourceNode = edge.getSource();
				if (!realizedMiddleNodes.contains(sourceNode) && (sourceNode.isPredicated() || sourceNode.isRealized())) {
					Node targetNode = edge.getTarget();
					if (!realizedMiddleNodes.contains(targetNode) && (targetNode.isPredicated() || targetNode.isRealized())) {
						realizedOutputEdges.add((NavigationEdge) edge);
					}
				}
			}
		}
	}

	private void analyzeNodes() {
		for (@NonNull Node node : region.getNodes()) {
			if (node.getClassDatumAnalysis().getDomainUsage().isMiddle()) {
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
				if (node.isLoaded()) {
					loadedNodes.add(node);
				}
				else if (node.isPredicated()) {
					predicatedOutputNodes.add(node);
				}
				else if (node.isRealized()) {
					realizedOutputNodes.add(node);
				}
			}
		}
	}

	private @NonNull MicroMappingRegion createAssignmentRegion(@NonNull NavigationEdge outputEdge, int i) {
		AssignmentPartition realizedPartition = new AssignmentPartition(this, outputEdge);
		return realizedPartition.createMicroMappingRegion("«edge" + i + "»", ".p" + i);
	}

	private @NonNull MicroMappingRegion createSpeculatedRegion() {
		SpeculatedPartition speculatedPartition = new SpeculatedPartition(this);
		return speculatedPartition.createMicroMappingRegion("«speculated»", ".p1");
	}

	private @NonNull MicroMappingRegion createSpeculationRegion() {
		SpeculationPartition speculationPartition = new SpeculationPartition(this);
		return speculationPartition.createMicroMappingRegion("«speculation»", ".p0");
	}

	public @NonNull Iterable<@NonNull Node> getLoadedNodes() {
		return loadedNodes;
	}

	public @NonNull Iterable<@NonNull Node> getPredecessors(@NonNull Node targetNode) {
		Set<@NonNull Node> sourceNodes = new HashSet<>();
		NavigationEdge parentEdge = getParentEdge(targetNode);
		if (parentEdge != null) {
			//			Integer targetDepth = getDepth(targetNode);
			//			assert targetDepth != null;
			Node sourceNode = parentEdge.getSource();
			if (sourceNode == targetNode) {
				sourceNode = parentEdge.getTarget();
			}
			sourceNodes.add(sourceNode);
			//			Integer sourceDepth = getDepth(sourceNode);
			//			assert sourceDepth != null;
		}
		for (@NonNull Edge edge : targetNode.getComputationEdges()) {
			sourceNodes.add(edge.getSource());
		}
		//		sourceNodes.remove(targetNode);
		return sourceNodes;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedMiddleNodes() {
		return predicatedMiddleNodes;
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

	public boolean hasRealized(@NonNull Edge edge) {
		return realizedEdges.contains(edge);
	}

	public @NonNull Iterable<@NonNull MicroMappingRegion> partition() {
		List<@NonNull MicroMappingRegion> regions = new ArrayList<>();
		regions.add(createSpeculationRegion());
		regions.add(createSpeculatedRegion());
		int i = 2;
		for (@NonNull NavigationEdge outputEdge : realizedOutputEdges) {
			regions.add(createAssignmentRegion(outputEdge, i++));
		}
		return regions;
	}
}
