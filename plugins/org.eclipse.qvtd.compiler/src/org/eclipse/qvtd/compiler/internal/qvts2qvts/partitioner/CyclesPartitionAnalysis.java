/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The CyclesAnalysis identifies a CyclicPartition for each group of allPartitions that contribute to a cycle.
 */
public class CyclesPartitionAnalysis extends CyclesAnalysis<@NonNull Partition>
{
	private final @NonNull List<@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>>> cycle2subregion2predecessors = new ArrayList<>();

	public CyclesPartitionAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull Iterable<@NonNull Partition> allPartitions) {
		super(transformationPartitioner, allPartitions);
	}

	/**
	 * Return a map of the RegionAnalyses that may execute immediately before each RA.
	 *
	 * This partition variat considers only head (trace) nodes and their DataType attributes to avoid regenerating
	 * the cycic dependencies.
	 */
	protected @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> computePredecessors(@NonNull Iterable<@NonNull Partition> subregions) {
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producers = new HashMap<>();
		for (@NonNull Partition regionAnalysis : subregions) {
			consumer2producers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull Partition consumer : subregions) {
			Iterable<@NonNull Node> traceNodes = consumer.getTraceNodes();
			for (@NonNull Node traceNode : traceNodes) {		// The one head
				Role nodeRole = consumer.getRole(traceNode);
				if ((nodeRole != null) && nodeRole.isOld()) {
					TraceClassAnalysis<@NonNull Partition> consumedTraceClassAnalysis = regionsAnalysis.getTraceClassAnalysis(traceNode.getClassDatum());
					for (@NonNull TraceClassAnalysis<@NonNull Partition> subConsumedTraceClass : consumedTraceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull Partition producer : subConsumedTraceClass.getProducers()) {
							Set<@NonNull Partition> producers = consumer2producers.get(consumer);
							assert producers != null;
							producers.add(producer);
						}
					}
					for (@NonNull Edge traceEdge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
						if (traceEdge.isNavigation()) {
							Node targetNode = QVTscheduleUtil.getTargetNode(traceEdge);
							if (targetNode.isDataType()) {
								Role edgeRole = consumer.getRole(traceEdge);
								if ((edgeRole != null)  && edgeRole.isOld()) {
									NavigableEdge navigableEdge = (NavigableEdge)traceEdge;
									PropertyDatum propertyDatum = regionsAnalysis.getScheduleManager().getPropertyDatum(navigableEdge);
									TracePropertyAnalysis<@NonNull Partition> consumedTracePropertyAnalysis = regionsAnalysis.getTracePropertyAnalysis(propertyDatum);
									for (@NonNull Partition producer : consumedTracePropertyAnalysis.getProducers()) {
										Set<@NonNull Partition> producers = consumer2producers.get(consumer);
										assert producers != null;
										producers.add(producer);
									}
								}
							}
						}
					}
				}
			}
			/*			Iterable<@NonNull TraceClassAnalysis<@NonNull Partition>> consumedTraceClassAnalyses = consumer.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis<@NonNull Partition> consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis<@NonNull Partition> subConsumedTraceClass : consumedTraceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull Partition producer : subConsumedTraceClass.getProducers()) {
							Set<@NonNull Partition> producers = consumer2producers.get(consumer);
							assert producers != null;
							producers.add(producer);
						}
					}
				}
			}
			Iterable<@NonNull TracePropertyAnalysis<@NonNull Partition>> consumedTracePropertyAnalyses = consumer.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis<@NonNull Partition> consumedTracePropertyAnalysis : consumedTracePropertyAnalyses) {
					Property traceProperty = consumedTracePropertyAnalysis.getTraceProperty();
					for (@NonNull Partition producer : consumedTracePropertyAnalysis.getProducers()) {
						Set<@NonNull Partition> producers = consumer2producers.get(consumer);
						assert producers != null;
						producers.add(producer);
					}
				}
			} */
		}
		return consumer2producers;
	}

	@Override
	protected @NonNull CycleAnalysis<@NonNull Partition> createCycleAnalysis(@NonNull String name,
			@NonNull Set<@NonNull Partition> nestedSubregions,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partitioner2predecessors) {
		CyclicPartition cycle = (CyclicPartition) super.createCycleAnalysis(name, nestedSubregions, partitioner2predecessors);

		//
		//	Compute the external predecessors of the cycle, and compute the internal predecessors within the cycle.
		//
		Set<@NonNull Partition> externalPredecessors = new HashSet<>();
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producers = computePredecessors(nestedSubregions);
		for (@NonNull Partition nestedSubregion : nestedSubregions) {
			Set<@NonNull Partition> internalPredecessors = consumer2producers.get(nestedSubregion);
			assert internalPredecessors != null;
			externalPredecessors.addAll(internalPredecessors);
			internalPredecessors.retainAll(nestedSubregions);
		}
		externalPredecessors.removeAll(nestedSubregions);
		//
		//	Compute the transitive closure of the internal predecessors (acyclic).
		//
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		cycle2subregion2predecessors.add(consumer2producersClosure);
		// assert acyclic

		//
		//	Determine the predecessors of the new cycle, and update the predecessors within the cycle
		//	to retain only cycle elements.
		//
		//		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> cycleSubregion2predecessors = new HashMap<>();
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> residualPartitioner2predecessors = new HashMap<>(partitioner2predecessors);
		for (@NonNull Partition cycleSubregion : nestedSubregions) {
			Set<@NonNull Partition> oldPredecessors = residualPartitioner2predecessors.remove(cycleSubregion);
			assert oldPredecessors != null;
			//			oldPredecessors.retainAll(nestedSubregions);
			//			oldPredecessors.remove(cycleSubregion);
			//			cycleSubregion2predecessors.put(cycleSubregion, oldPredecessors);
		}
		//		cyclePredecessors.removeAll(nestedSubregions);
		//		cycle2predecessors.put(cycle, cyclePredecessors);
		//		Set<@NonNull Partition> old = partitioner2predecessors.put(cycle, cyclePredecessors);
		//		assert old == null;
		//
		//	Update the residual partitioner2predecessors to replace all nestedSubregions by the cycle.
		//
		Set<@NonNull Partition> successors = new HashSet<>(residualPartitioner2predecessors.keySet());
		successors.removeAll(externalPredecessors);
		successors.remove(cycle);
		for (@NonNull Partition successor : successors) {
			Set<@NonNull Partition> predecessors = residualPartitioner2predecessors.get(successor);
			assert predecessors != null;
			if (predecessors.removeAll(nestedSubregions)) {
				predecessors.add(cycle);
			}
		}
		return cycle;
	}

	@Override
	protected @NonNull CyclicPartition createCycleAnalysis(@NonNull String name,
			@NonNull Set<@NonNull Partition> cyclicRegionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> cyclicTraceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> cyclicTracePropertyAnalyses) {
		return new CyclicPartition(name, this, cyclicRegionAnalyses, cyclicTraceClassAnalyses, cyclicTracePropertyAnalyses);
	}

	@Override
	protected @NonNull List<@NonNull Set<@NonNull Partition>> createCycleAnalyses(
			@NonNull Iterable<@NonNull Set<@NonNull Partition>> cycleElementSets,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partitioner2predecessors) {
		List<@NonNull Set<@NonNull Partition>> cycleAnalyses = super.createCycleAnalyses(cycleElementSets, partitioner2predecessors);
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producers = computePredecessors(partitioner2predecessors.keySet());
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		cycle2subregion2predecessors.add(consumer2producersClosure);
		return cycleAnalyses;
	}

	public @NonNull RegionsAnalysis<@NonNull Partition> getRegionsAnalysis() {
		return regionsAnalysis;
	}
}
