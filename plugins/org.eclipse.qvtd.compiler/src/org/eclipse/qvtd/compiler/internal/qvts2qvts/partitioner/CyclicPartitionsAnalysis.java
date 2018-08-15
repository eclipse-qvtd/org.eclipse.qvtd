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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The CyclicPartitionsAnalysis identifies the Partitions and TraceClassAnalysis' that contribute to a cycle.
 *
 * This forms the basis of the cycle encpasulation and parallel schedule.
 */
public class CyclicPartitionsAnalysis
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	protected final @NonNull Iterable<@NonNull Partition> leafPartitions;

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each mapping partitioner.
	 */
	protected final @NonNull Map<@NonNull Partition, @NonNull CyclicPartition> partition2cyclicPartition = new HashMap<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	protected final @NonNull Map<@NonNull TraceClassAnalysis<@NonNull Partition>, @NonNull CyclicPartition> traceClassAnalysis2cyclicPartition = new HashMap<>();

	//	private final @NonNull List<@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>>> cycle2partition2predecessors = new ArrayList<>();

	public CyclicPartitionsAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull Iterable<@NonNull Partition> leafPartitions) {
		this.transformationPartitioner = transformationPartitioner;
		this.leafPartitions = leafPartitions;
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each Partition.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	public @Nullable Iterable<@NonNull InternallyAcyclicPartition> analyze() {
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> leafPartition2predecessors = CompilerUtil.computeTransitivePredecessors(leafPartitions);
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> leafPartition2successors = CompilerUtil.computeTransitiveSuccessors(leafPartitions);
		Set<@NonNull Set<@NonNull Partition>> intersections = new HashSet<>();
		for (@NonNull Partition leafPartition : leafPartitions) {
			Set<@NonNull Partition> intersection = new HashSet<>(leafPartition2predecessors.get(leafPartition));
			intersection.retainAll(leafPartition2successors.get(leafPartition));
			if (!intersection.isEmpty()) {
				intersections.add(intersection);
			}
		}
		//
		/*	List<@NonNull Set<@NonNull Partition>> prunedCycleElements = new ArrayList<>(intersections);
		for (int i = prunedCycleElements.size(); --i >= 0; ) {
			Set<@NonNull Partition> iCycleElements = prunedCycleElements.get(i);
			boolean pruneIt = false;
			for (int j = i; --j >= 0; ) {
				Set<@NonNull Partition> jCycleElements = prunedCycleElements.get(j);
				if (QVTbaseUtil.containsAny(jCycleElements, iCycleElements) && jCycleElements.addAll(iCycleElements)) {
					pruneIt = true;
				}
			}
			if (pruneIt) {
				prunedCycleElements.remove(i);
			}
		} */
		if (intersections.isEmpty()) {
			return null;
		}
		return createCycleAnalyses(intersections, leafPartition2predecessors);
	}

	/**
	 * Return a map of the Partitions that may execute immediately before each Partition.
	 *
	 * This partition variant considers only head (trace) nodes and their DataType attributes to avoid regenerating
	 * the cycic dependencies.
	 */
	protected @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> computePredecessors(@NonNull Iterable<@NonNull Partition> partitions) {
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producers = new HashMap<>();
		for (@NonNull Partition partition : partitions) {
			consumer2producers.put(partition, new HashSet<>());
		}
		ScheduleManager scheduleManager = transformationPartitioner.getScheduleManager();
		for (@NonNull Partition consumer : partitions) {
			Iterable<@NonNull Node> traceNodes = consumer.getTraceNodes();
			for (@NonNull Node traceNode : traceNodes) {		// The one head
				Role nodeRole = consumer.getRole(traceNode);
				if ((nodeRole != null) && nodeRole.isOld()) {
					ClassDatum classDatum = QVTscheduleUtil.getClassDatum(traceNode);
					TraceClassAnalysis<@NonNull Partition> consumedTraceClassAnalysis = transformationPartitioner.getTraceClassAnalysis(classDatum);
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
									PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(navigableEdge);
									TracePropertyAnalysis<@NonNull Partition> consumedTracePropertyAnalysis = transformationPartitioner.getTracePropertyAnalysis(propertyDatum);
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

	protected @NonNull Iterable<@NonNull InternallyAcyclicPartition> createCycleAnalyses(
			@NonNull Iterable<@NonNull Set<@NonNull Partition>> partitionings,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partitioner2predecessors) {
		List<@NonNull Set<@NonNull Partition>> sortedPartitionings = Lists.newArrayList(partitionings);
		Collections.sort(sortedPartitionings, QVTbaseUtil.CollectionSizeComparator.INSTANCE);	// Smallest first
		//
		//	A nested cycle is necessarily fully contained by a nesting cycle. We can therefore steadily replace
		//	each set of nested elements by a cyclic element in the nesting context. The mallest first lordering
		//	does not need to be recomputed after each nesting simplification since nested candidates continue to
		//	precede their potential nestings.
		//
		List<@NonNull InternallyAcyclicPartition> cyclicPartitions = new ArrayList<>();
		int iMax = sortedPartitionings.size();
		for (int i = 0; i < iMax; i++)  {
			Set<@NonNull Partition> nestedPartitioning = sortedPartitionings.get(i);
			CyclicPartition nestedCyclicPartition = createCyclicPartition("«cycle-" + i + "»", nestedPartitioning, partitioner2predecessors);
			cyclicPartitions.add(nestedCyclicPartition);
			//
			//	Replace the nestedPartitioning partitions by nestedCyclicPartition in the potentially nesting cycles
			//
			for (int j = i+1; j < iMax; j++)  {
				Set<@NonNull Partition> nestingPartitioning = sortedPartitionings.get(j);
				int oldSize = nestingPartitioning.size();
				if (nestingPartitioning.removeAll(nestedPartitioning)) {
					int newSize = nestingPartitioning.size();
					assert (oldSize - newSize) == nestedPartitioning.size();
					nestingPartitioning.add(nestedCyclicPartition);
				}
			}
		}
		if (TransformationPartitioner.CYCLES.isActive()) {
			showCycles(cyclicPartitions);
		}
		//	List<@NonNull Set<@NonNull Partition>> cycleAnalyses2 = sortedPartitionings;
		//	Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producers = computePredecessors(partitioner2predecessors.keySet());
		//	Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		//	cycle2partition2predecessors.add(consumer2producersClosure);
		return cyclicPartitions;
	}

	//	@Override
	protected @NonNull CyclicPartition createCyclicPartition(@NonNull String name,
			@NonNull Set<@NonNull Partition> nestedPartitions,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partitioner2predecessors) {
		Set<@NonNull TraceClassAnalysis<@NonNull Partition>> consumedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TraceClassAnalysis<@NonNull Partition>> superProducedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> consumedTracePropertyAnalyses = new HashSet<>();
		for (@NonNull Partition nestedPartition : nestedPartitions) {
			Iterable<@NonNull TraceClassAnalysis<@NonNull Partition>> consumedTraceClassAnalyses2 = nestedPartition.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses2 != null) {
				Iterables.addAll(consumedTraceClassAnalyses, consumedTraceClassAnalyses2);
			}
			Iterable<@NonNull TraceClassAnalysis<@NonNull Partition>> superProducedTraceClassAnalyses2 = nestedPartition.getSuperProducedTraceClassAnalyses();
			if (superProducedTraceClassAnalyses2 != null) {
				Iterables.addAll(superProducedTraceClassAnalyses, superProducedTraceClassAnalyses2);
			}
			Iterable<@NonNull TracePropertyAnalysis<@NonNull Partition>> consumedTracePropertyAnalyses2 = nestedPartition.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses2 != null) {
				Iterables.addAll(consumedTracePropertyAnalyses, consumedTracePropertyAnalyses2);
			}
		}
		Set<@NonNull TraceClassAnalysis<@NonNull Partition>> cyclicTraceClassAnalyses = new HashSet<>(consumedTraceClassAnalyses);
		cyclicTraceClassAnalyses.retainAll(superProducedTraceClassAnalyses);
		Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> cyclicTracePropertyAnalyses = new HashSet<>(consumedTracePropertyAnalyses);
		CyclicPartition cycleAnalysis = new CyclicPartition(transformationPartitioner, name, this, nestedPartitions, cyclicTraceClassAnalyses, cyclicTracePropertyAnalyses);
		for (@NonNull Partition nestedPartition : nestedPartitions) {
			CyclicPartition oldCycleAnalysis = partition2cyclicPartition.put(nestedPartition, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		for (@NonNull TraceClassAnalysis<@NonNull Partition> cyclicTraceClassAnalysis : cyclicTraceClassAnalyses) {
			CyclicPartition oldCycleAnalysis = traceClassAnalysis2cyclicPartition.put(cyclicTraceClassAnalysis, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		CyclicPartition cycle = cycleAnalysis;

		//
		//	Compute the external predecessors of the cycle, and compute the internal predecessors within the cycle.
		//
		Set<@NonNull Partition> externalPredecessors = new HashSet<>();
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producers = computePredecessors(nestedPartitions);
		for (@NonNull Partition nestedPartition : nestedPartitions) {
			Set<@NonNull Partition> internalPredecessors = consumer2producers.get(nestedPartition);
			assert internalPredecessors != null;
			externalPredecessors.addAll(internalPredecessors);
			internalPredecessors.retainAll(nestedPartitions);
		}
		externalPredecessors.removeAll(nestedPartitions);
		//
		//	Compute the transitive closure of the internal predecessors (acyclic).
		//
		//	Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		//	cycle2partition2predecessors.add(consumer2producersClosure);
		// assert acyclic

		//
		//	Determine the predecessors of the new cycle, and update the predecessors within the cycle
		//	to retain only cycle elements.
		//
		//		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> cycleSubregion2predecessors = new HashMap<>();
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> residualPartitioner2predecessors = new HashMap<>(partitioner2predecessors);
		for (@NonNull Partition nestedPartition : nestedPartitions) {
			Set<@NonNull Partition> oldPredecessors = residualPartitioner2predecessors.remove(nestedPartition);
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
			if (predecessors.removeAll(nestedPartitions)) {
				predecessors.add(cycle);
			}
		}
		return cycle;
	}

	//	public @Nullable CyclicPartition getCyclicPartition(@NonNull Partition partition) {
	//		return partition2cyclicPartition.get(partition);
	//	}

	//	public @Nullable CyclicPartition getCyclicPartition(@NonNull TraceClassAnalysis<@NonNull Partition> traceClassAnalysis) {
	//		return traceClassAnalysis2cyclicPartition.get(traceClassAnalysis);
	//	}

	//	public @NonNull TransformationPartitioner getTransformationPartitioner() {
	//		return transformationPartitioner;
	//	}

	protected void showCycles(@NonNull Iterable<@NonNull InternallyAcyclicPartition> cyclicPartitions) {
		if (Iterables.isEmpty(cyclicPartitions)) {
			TransformationPartitioner.CYCLES.println("No cycles");
		}
		else {
			for (@NonNull InternallyAcyclicPartition cyclicPartition : cyclicPartitions) {
				StringBuilder s = new StringBuilder();
				s.append("\n  Partitions:");
				List<@NonNull Partition> partitions2 = Lists.newArrayList(cyclicPartition.getPartitions());
				Collections.sort(partitions2, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull Partition partition : partitions2) {
					s.append("\n\t" + partition);
					Iterable<@NonNull ? extends TraceClassAnalysis<@NonNull Partition>> consumedTraceClassAnalyses = partition.getConsumedTraceClassAnalyses();
					if (consumedTraceClassAnalyses != null) {
						for (@NonNull TraceClassAnalysis<@NonNull Partition> traceClassAnalysis : consumedTraceClassAnalyses) {
							s.append("\n\t  =>" + traceClassAnalysis);
						}
					}
					Iterable<@NonNull ? extends TraceClassAnalysis<@NonNull Partition>> producedTraceClassAnalyses = partition.getProducedTraceClassAnalyses();
					if (producedTraceClassAnalyses != null) {
						for (@NonNull TraceClassAnalysis<@NonNull Partition> traceClassAnalysis : producedTraceClassAnalyses) {
							s.append("\n\t  <=" + traceClassAnalysis);
						}
					}
					Iterable<@NonNull ? extends TracePropertyAnalysis<@NonNull Partition>> consumedTracePropertyAnalyses = partition.getConsumedTracePropertyAnalyses();
					if (consumedTracePropertyAnalyses != null) {
						for (@NonNull TracePropertyAnalysis<@NonNull Partition> tracePropertyAnalysis : consumedTracePropertyAnalyses) {
							s.append("\n\t  =>" + tracePropertyAnalysis);
						}
					}
					Iterable<@NonNull ? extends TracePropertyAnalysis<@NonNull Partition>> producedTracePropertyAnalyses = partition.getProducedTracePropertyAnalyses();
					if (producedTracePropertyAnalyses != null) {
						for (@NonNull TracePropertyAnalysis<@NonNull Partition> tracePropertyAnalysis : producedTracePropertyAnalyses) {
							s.append("\n\t  <=" + tracePropertyAnalysis);
						}
					}
				}
				s.append("\n  TraceClassAnalyses:");
				List<@NonNull TraceClassAnalysis<@NonNull Partition>> traceClassAnalyses = Lists.newArrayList(cyclicPartition.getTraceClassAnalyses());
				Collections.sort(traceClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull TraceClassAnalysis<@NonNull Partition> traceClassAnalysis : traceClassAnalyses) {
					s.append("\n\t" + traceClassAnalysis);
				}
				s.append("\n  TracePropertyAnalyses:");
				List<@NonNull TracePropertyAnalysis<@NonNull Partition>> tracePropertyAnalyses = Lists.newArrayList(cyclicPartition.getTracePropertyAnalyses());
				Collections.sort(tracePropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull TracePropertyAnalysis<@NonNull Partition> tracePropertyAnalysis : tracePropertyAnalyses) {
					s.append("\n\t" + tracePropertyAnalysis);
				}
				TransformationPartitioner.CYCLES.println(s.toString());
			}
		}
	}
}
