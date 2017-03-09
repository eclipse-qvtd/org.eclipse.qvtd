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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import com.google.common.collect.Iterables;

/**
 * The TransformationPartitioner supervises a MappingPartitioner for each mapping region. It provides
 * the global analysis to support the local partitioning.
 */
public class TransformationPartitioner
{
	public static final @NonNull TracingOption CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/cycles");
	public static final @NonNull TracingOption PREDECESSORS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/predecessors");
	public static final @NonNull TracingOption SUCCESSORS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/successors");

	public static @NonNull Iterable<@NonNull MappingRegion> partition(@NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		TransformationPartitioner transformationPartitioner = new TransformationPartitioner(problemHandler, activeRegions);
		return transformationPartitioner.partition();
	}

	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull Iterable<@NonNull ? extends Region> activeRegions;

	/**
	 * The partitioner for each region.
	 */
	private final @NonNull Map<@NonNull MappingRegion, @NonNull MappingPartitioner> region2mappingPartitioner = new HashMap<>();

	/**
	 * The partitioners in the original activeRegions order.
	 */
	private final @NonNull List<@NonNull MappingPartitioner> mappingPartitioners = new ArrayList<>();

	/**
	 * The partitioners in the original activeRegions order.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @NonNull TraceClassAnalysis> class2middleAnalysis = new HashMap<>();

	/**
	 * All speculated-trace to realized node properties that are automatically assignable once their speculation
	 * is validated.
	 */
	private final @NonNull Set<@NonNull Property> corrolaryProperties = new HashSet<>();

	@Nullable Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2cycles = null;

	public TransformationPartitioner(@NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		this.problemHandler = problemHandler;
		this.activeRegions = activeRegions;
	}

	public @NonNull TraceClassAnalysis addConsumer(@NonNull CompleteClass completeClass, @NonNull MappingPartitioner consumer) {
		TraceClassAnalysis middleAnalysis = class2middleAnalysis.get(completeClass);
		if (middleAnalysis == null) {
			middleAnalysis = new TraceClassAnalysis(this, completeClass);
			class2middleAnalysis.put(completeClass, middleAnalysis);
		}
		middleAnalysis.addConsumer(consumer);
		return middleAnalysis;
	}

	public void addCorrolary(@NonNull Property property) {
		corrolaryProperties.add(property);
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	public @NonNull TraceClassAnalysis addProducer(@NonNull CompleteClass completeClass, @NonNull MappingPartitioner producer) {
		TraceClassAnalysis middleAnalysis = class2middleAnalysis.get(completeClass);
		if (middleAnalysis == null) {
			middleAnalysis = new TraceClassAnalysis(this, completeClass);
			class2middleAnalysis.put(completeClass, middleAnalysis);
		}
		middleAnalysis.addProducer(producer);
		return middleAnalysis;
	}

	/**
	 * Return a map of the MappingPartitioners that form a cycle including each MappingPartitioner.
	 */
	private @NonNull Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> computeCycles() {
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2predecessors = computeTransitivePredecessors();
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2successors = computeTransitiveSuccessors();
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2cycles = new HashMap<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			Set<@NonNull MappingPartitioner> cycles = new HashSet<>(partitioner2predecessors.get(mappingPartitioner));
			cycles.retainAll(partitioner2successors.get(mappingPartitioner));
			partitioner2cycles.put(mappingPartitioner, cycles);
		}
		if (CYCLES.isActive()) {
			for (@NonNull MappingPartitioner partitioner : mappingPartitioners) {
				StringBuilder s = new StringBuilder();
				s.append(partitioner + ":");
				Set<@NonNull MappingPartitioner> cycles = partitioner2cycles.get(partitioner);
				assert cycles != null;
				for (@NonNull MappingPartitioner cycle : cycles) {
					s.append("\n\t" + cycle);
				}
				CYCLES.println(s.toString());
			}
		}
		return partitioner2cycles;
	}

	private void computeCyclicTraceClasses() {
		//
		//	Each mapping partitioner that consumes no trace class, is an acyclic producer.
		//
		Set<@NonNull MappingPartitioner> acyclicProducers = new HashSet<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			Iterable<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = mappingPartitioner.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses == null) {
				acyclicProducers.add(mappingPartitioner);
			}
		}
		/*		for (@NonNull TraceClassAnalysis middleAnalysis : class2middleAnalysis.values()) {
		CompleteClass traceClass = middleAnalysis.getTraceClass();
		for (@NonNull CompleteClass superCompleteClass : traceClass.getProperSuperCompleteClasses()) {
			for (@NonNull MappingPartitioner producer : middleAnalysis.getProducers()) {
				addProducer(superCompleteClass, producer);
			}
		}
	} */

		partitioner2cycles = computeCycles();
		//
		//	Each MiddleAnalysis produced only by acyclic partitioners identifies an acyclic trace class
		//
		Set<@NonNull TraceClassAnalysis> acylicAnalysis = new HashSet<>();
		for (@NonNull MappingPartitioner acyclicProducer : acyclicProducers) {
			for (@NonNull Node realizedMiddleNode : acyclicProducer.getRealizedMiddleNodes()) {
				CompleteClass traceClass = realizedMiddleNode.getCompleteClass();
				TraceClassAnalysis middleAnalysis = class2middleAnalysis.get(traceClass);
				assert middleAnalysis != null;
				if (QVTbaseUtil.containsAll(acyclicProducers, middleAnalysis.getProducers())) {
					acylicAnalysis.add(middleAnalysis);
				}
			}
		}



	}

	private void computeSuperProducers() {
		//
		//	Production of some traceClass, also produces all its super-classes.
		//
		for (@NonNull TraceClassAnalysis middleAnalysis : new ArrayList<>(class2middleAnalysis.values())) {	// FIXME why is this a CME hazard
			CompleteClass traceClass = middleAnalysis.getTraceClass();
			for (@NonNull CompleteClass superCompleteClass : traceClass.getProperSuperCompleteClasses()) {
				for (@NonNull MappingPartitioner producer : middleAnalysis.getProducers()) {
					addProducer(superCompleteClass, producer);
				}
			}
		}
	}

	/**
	 * Return a map of the MappingPartitioners that may execute before each MappingPartitioner.
	 */
	private @NonNull Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> computeTransitivePredecessors() {
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2predecessors = new HashMap<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			partitioner2predecessors.put(mappingPartitioner, new HashSet<>());
		}
		Deque<@NonNull MappingPartitioner> worklist = new ArrayDeque<>(mappingPartitioners);
		while (!worklist.isEmpty()) {
			MappingPartitioner producer = worklist.remove();
			Set<@NonNull MappingPartitioner> producerPredecessors = partitioner2predecessors.get(producer);
			assert producerPredecessors != null;
			Iterable<@NonNull TraceClassAnalysis> producedTraceClassAnalyses = producer.getProducedTraceClassAnalyses();
			if (producedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis producedTraceClass : producedTraceClassAnalyses) {
					for (@NonNull MappingPartitioner consumer : producedTraceClass.getConsumers()) {
						Set<@NonNull MappingPartitioner> consumerPredecessors = partitioner2predecessors.get(consumer);
						assert consumerPredecessors != null;
						boolean propagate = consumerPredecessors.add(producer);
						if (consumerPredecessors.addAll(producerPredecessors)) {
							propagate = true;
						}
						if (propagate) {
							worklist.add(consumer);
						}
					}
				}
			}
		}
		if (PREDECESSORS.isActive()) {
			for (@NonNull MappingPartitioner successor : mappingPartitioners) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				Set<@NonNull MappingPartitioner> predecessors = partitioner2predecessors.get(successor);
				assert predecessors != null;
				for (@NonNull MappingPartitioner predecessor : predecessors) {
					s.append("\n\t" + predecessor);
				}
				PREDECESSORS.println(s.toString());
			}
		}
		return partitioner2predecessors;
	}

	/**
	 * Return a map of the MappingPartitioners that may execute after each MappingPartitioner.
	 */
	private @NonNull Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> computeTransitiveSuccessors() {
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2successors = new HashMap<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			partitioner2successors.put(mappingPartitioner, new HashSet<>());
		}
		Deque<@NonNull MappingPartitioner> worklist = new ArrayDeque<>(mappingPartitioners);
		while (!worklist.isEmpty()) {
			MappingPartitioner consumer = worklist.remove();
			Set<@NonNull MappingPartitioner> consumerSuccessors = partitioner2successors.get(consumer);
			assert consumerSuccessors != null;
			Iterable<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = consumer.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					for (@NonNull MappingPartitioner producer : consumedTraceClassAnalysis.getProducers()) {
						Set<@NonNull MappingPartitioner> producerSuccessors = partitioner2successors.get(producer);
						assert producerSuccessors != null;
						boolean propagate = producerSuccessors.add(consumer);
						if (producerSuccessors.addAll(consumerSuccessors)) {
							propagate = true;
						}
						if (propagate) {
							worklist.add(producer);
						}
					}
				}
			}
		}
		if (SUCCESSORS.isActive()) {
			for (@NonNull MappingPartitioner predecessor : mappingPartitioners) {
				StringBuilder s = new StringBuilder();
				s.append(predecessor + ":");
				Set<@NonNull MappingPartitioner> successors = partitioner2successors.get(predecessor);
				assert successors != null;
				for (@NonNull MappingPartitioner successor : successors) {
					s.append("\n\t" + successor);
				}
				SUCCESSORS.println(s.toString());
			}
		}
		return partitioner2successors;
	}

	public boolean isCorrolary(@NonNull Edge edge) {
		if (!edge.isNavigation()) {
			return false;
		}
		return corrolaryProperties.contains(((NavigableEdge)edge).getProperty());
	}

	public boolean isCyclic(@NonNull MappingPartitioner mappingPartitioner) {
		assert partitioner2cycles != null;
		Set<@NonNull MappingPartitioner> cycles = partitioner2cycles.get(mappingPartitioner);
		assert cycles != null;
		return !cycles.isEmpty();
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition() {
		//
		//	Create the per-mapping partitioner and accumulate the local analyses
		//
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				MappingRegion mappingRegion = (MappingRegion)region;
				MappingPartitioner mappingPartitioner = new MappingPartitioner(this, mappingRegion);
				region2mappingPartitioner.put(mappingRegion, mappingPartitioner);
				mappingPartitioners.add(mappingPartitioner);
			}
		}
		//
		//	Perform gloabal analyses
		//
		computeSuperProducers();
		computeCyclicTraceClasses();
		//
		//	Perform per-mapping partitioning
		//
		List<@NonNull MappingRegion> partitionedRegions = new ArrayList<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			Iterables.addAll(partitionedRegions, mappingPartitioner.partition());
		}
		return partitionedRegions;
	}
}
