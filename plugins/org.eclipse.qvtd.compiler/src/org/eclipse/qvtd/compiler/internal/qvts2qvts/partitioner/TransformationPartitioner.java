/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import com.google.common.collect.Iterables;

/**
 * The TransformationPartitioner supervises a MappingPartitioner for each mapping region. It provides
 * the global analysis to support the local partitioning.
 */
public class TransformationPartitioner
{
	public static final @NonNull TracingOption CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/cycles");
	public static final @NonNull TracingOption DISCRIMINATION = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/discrimination");
	public static final @NonNull TracingOption PREDECESSORS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/predecessors");
	public static final @NonNull TracingOption SUCCESSORS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/successors");

	public static @NonNull Iterable<@NonNull MappingRegion> partition(@NonNull ScheduleManager scheduleManager, @NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) throws CompilerChainException {
		TransformationPartitioner transformationPartitioner = new TransformationPartitioner(scheduleManager, problemHandler, activeRegions);
		return transformationPartitioner.partition();
	}
	protected final @NonNull ScheduleManager scheduleManager;

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
	 * The TraceClassAnalysis for each trace class.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @NonNull TraceClassAnalysis> completeClass2traceClassAnalysis = new HashMap<>();

	/**
	 * The analysis of cycles.
	 */
	private @Nullable CyclesAnalysis cyclesAnalysis = null;

	/**
	 * The analysis of cycle regions that can succeed despite edges that may fail.
	 */
	@SuppressWarnings("unused")
	private @Nullable FallibilityAnalysis fallibilityAnalysis = null;

	/**
	 * All speculated-trace to realized node properties that are automatically assignable once their speculation
	 * is validated mapped to the regions that speculate them.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull List<@NonNull MappingRegion>> corollaryProperty2regions = new HashMap<>();

	/**
	 * Closure of the mapping to the trace class analyses that must succeed unconditionally for the key trace class analysis to succeed unconditionally..
	 */
	//	private @Nullable Map<@NonNull TraceClassAnalysis, @NonNull Set<@NonNull TraceClassAnalysis>> traceClassAnalysis2traceClassAnalysesClosure = null;

	public TransformationPartitioner(@NonNull ScheduleManager scheduleManager, @NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		this.scheduleManager = scheduleManager;
		this.problemHandler = problemHandler;
		this.activeRegions = activeRegions;
	}

	public @NonNull TraceClassAnalysis addConsumer(@NonNull CompleteClass completeClass, @NonNull MappingPartitioner consumer) {
		TraceClassAnalysis middleAnalysis = completeClass2traceClassAnalysis.get(completeClass);
		if (middleAnalysis == null) {
			middleAnalysis = new TraceClassAnalysis(this, completeClass);
			completeClass2traceClassAnalysis.put(completeClass, middleAnalysis);
		}
		middleAnalysis.addConsumer(consumer);
		return middleAnalysis;
	}

	public void addCorollary(@NonNull Property property, @NonNull MappingRegion region) {
		List<@NonNull MappingRegion> regions = corollaryProperty2regions.get(property);
		if (regions == null) {
			regions = new ArrayList<>();
			corollaryProperty2regions.put(property, regions);
		}
		if (!regions.contains(region)) {
			regions.add(region);
		}
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	public @NonNull TraceClassAnalysis addProducer(@NonNull CompleteClass completeClass, @NonNull MappingPartitioner producer) {
		TraceClassAnalysis middleAnalysis = completeClass2traceClassAnalysis.get(completeClass);
		if (middleAnalysis == null) {
			middleAnalysis = new TraceClassAnalysis(this, completeClass);
			completeClass2traceClassAnalysis.put(completeClass, middleAnalysis);
		}
		middleAnalysis.addProducer(producer);
		return middleAnalysis;
	}

	protected @NonNull CyclesAnalysis computeCyclesAnalysis() {
		CyclesAnalysis cyclesAnalysis = new CyclesAnalysis(this, mappingPartitioners);
		cyclesAnalysis.analyze();
		return cyclesAnalysis;
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

		this.cyclesAnalysis = computeCyclesAnalysis();
		//
		//	Each TraceClassAnalysis produced only by acyclic partitioners identifies an acyclic trace class
		//
		Set<@NonNull TraceClassAnalysis> acylicAnalysis = new HashSet<>();
		for (@NonNull MappingPartitioner acyclicProducer : acyclicProducers) {
			for (@NonNull Node traceNode : acyclicProducer.getTraceNodes()) {
				CompleteClass traceClass = traceNode.getCompleteClass();
				TraceClassAnalysis middleAnalysis = completeClass2traceClassAnalysis.get(traceClass);
				assert middleAnalysis != null;
				if (QVTbaseUtil.containsAll(acyclicProducers, middleAnalysis.getProducers())) {
					acylicAnalysis.add(middleAnalysis);
				}
			}
		}
	}

	protected @NonNull FallibilityAnalysis computeFallibilityAnalysis() {
		FallibilityAnalysis fallibilityAnalysis = new FallibilityAnalysis(this);
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			fallibilityAnalysis.accumulate(mappingPartitioner);
		}
		fallibilityAnalysis.install();
		return fallibilityAnalysis;
	}

	private void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull TraceClassAnalysis traceClassAnalysis : completeClass2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
	}

	private void computeTraceClassInheritance() {
		for (@NonNull TraceClassAnalysis subTraceClassAnalysis : completeClass2traceClassAnalysis.values()) {
			CompleteClass traceClass = subTraceClassAnalysis.getTraceClass();
			for (@NonNull CompleteClass superCompleteClass : traceClass.getProperSuperCompleteClasses()) {
				TraceClassAnalysis superTraceClassAnalysis = completeClass2traceClassAnalysis.get(superCompleteClass);
				if (superTraceClassAnalysis != null) {
					superTraceClassAnalysis.addSubTraceClassAnalysis(subTraceClassAnalysis);
					subTraceClassAnalysis.addSuperTraceClassAnalysis(superTraceClassAnalysis);
				}
			}
		}
	}

	/*	private @NonNull CycleAnalysis createCycleAnalysis(@NonNull Set<@NonNull MappingPartitioner> cyclicMappingPartitioners) {
		Map<@NonNull MappingPartitioner, @NonNull CycleAnalysis> mappingPartitioner2cycleAnalysis2 = mappingPartitioner2cycleAnalysis;
		if (mappingPartitioner2cycleAnalysis2 == null) {
			mappingPartitioner2cycleAnalysis = mappingPartitioner2cycleAnalysis2 = new HashMap<>();
		}
		Map<@NonNull TraceClassAnalysis, @NonNull CycleAnalysis> traceClassAnalysis2cycleAnalysis2 = traceClassAnalysis2cycleAnalysis;
		if (traceClassAnalysis2cycleAnalysis2 == null) {
			traceClassAnalysis2cycleAnalysis = traceClassAnalysis2cycleAnalysis2 = new HashMap<>();
		}
		return CycleAnalysis.createCycleAnalysis(this, cyclicMappingPartitioners, mappingPartitioner2cycleAnalysis2, traceClassAnalysis2cycleAnalysis2);
	} */

	public @Nullable List<@NonNull MappingRegion> getCorollaryOf(@NonNull Edge edge) {
		if (!edge.isNavigation()) {
			return null;
		}
		return corollaryProperty2regions.get(((NavigableEdge)edge).getProperty());
	}

	public @Nullable CycleAnalysis getCycleAnalysis(@NonNull CompleteClass completeClass) {
		TraceClassAnalysis traceClassAnalysis = completeClass2traceClassAnalysis.get(completeClass);
		if (traceClassAnalysis == null) {
			return null;
		}
		return getCycleAnalysis(traceClassAnalysis);
	}

	public @Nullable CycleAnalysis getCycleAnalysis(@NonNull MappingPartitioner mappingPartitioner) {
		return cyclesAnalysis != null ? cyclesAnalysis.getCycleAnalysis(mappingPartitioner) : null;
	}

	public @Nullable CycleAnalysis getCycleAnalysis(@NonNull TraceClassAnalysis traceClassAnalysis) {
		return cyclesAnalysis != null ? cyclesAnalysis.getCycleAnalysis(traceClassAnalysis) : null;
	}

	public @NonNull MappingPartitioner getMappingPartitioner(@NonNull MappingRegion region) {
		return ClassUtil.nonNullState(region2mappingPartitioner.get(region));
	}

	protected @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty) {
		return scheduleManager.getSuccessPropertyDatum(successProperty);
	}

	public @NonNull TraceClassAnalysis getTraceClassAnalysis(@NonNull CompleteClass completeClass) {
		return ClassUtil.nonNullState(completeClass2traceClassAnalysis.get(completeClass));
	}

	public boolean isCyclic(@NonNull CompleteClass traceClass) {
		TraceClassAnalysis traceClassAnalysis = completeClass2traceClassAnalysis.get(traceClass);
		if (traceClassAnalysis == null) {
			return false;
		}
		return traceClassAnalysis.isCyclic();
	}

	/**
	 * Return true if this cycle succeeds regardless of data values.
	 *
	public boolean isDataIndependent() {
		MayFailAnalysis visitor = new MayFailAnalysis();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			MappingRegion region = mappingPartitioner.getRegion();
			Iterable<@NonNull Node> rootNodes = getOldReachabilityRootNodes(mappingPartitioner);
			Iterable<@NonNull NavigableEdge> navigableEdges = mappingPartitioner.getOldPrimaryNavigableEdges();
			ReachabilityForest checkedReachabilityForest = new ReachabilityForest(rootNodes, navigableEdges);
			CheckedConditionAnalysis analysis = new CheckedConditionAnalysis(scheduleManager, checkedReachabilityForest, region)
			{
				@Override
				protected @Nullable Set<@NonNull Property> computeCheckedProperties() {
					return null;
				}
			};
			Set<@NonNull CheckedCondition> checkedConditions = analysis.computeCheckedConditions();
			System.out.println(region + ": " + checkedConditions);
			for (@NonNull CheckedCondition checkedCondition : checkedConditions) {
				checkedCondition.accept(visitor);
			}
		}
		if (!visitor.getDataDependentConditions().isEmpty()) {
			return false;
		}
		Set<@NonNull ClassDatum> classDatums = new HashSet<>(visitor.getTypeDependentConditions().values());
		for (@NonNull ClassDatum classDatum : classDatums) {
			assert classDatum.getReferredTypedModel() == scheduleManager.getTraceTypedModel();
			TraceClassAnalysis traceClassAnalysis = transformationPartitioner.getTraceClassAnalysis(classDatum.getCompleteClass());
			for (@NonNull MappingPartitioner mappingPartitioner : traceClassAnalysis.getProducers()) {
				if (!mappingPartitioners.contains(mappingPartitioner)) {		// FIXME Externally ok ??
					return false;
				}
			}
		}
		return true;
	} */

	public @NonNull Iterable<@NonNull MappingRegion> partition() throws CompilerChainException {
		//
		//	Create the per-mapping partitioner and accumulate the local analyses
		//
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				MappingRegion mappingRegion = (MappingRegion)region;
				RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(mappingRegion);
				MappingPartitioner mappingPartitioner = new MappingPartitioner(this, regionAnalysis);
				region2mappingPartitioner.put(mappingRegion, mappingPartitioner);
				mappingPartitioners.add(mappingPartitioner);
			}
		}
		Collections.sort(mappingPartitioners, NameUtil.NAMEABLE_COMPARATOR);
		//
		//	Perform global analyses
		//
		if (scheduleManager.needsDiscrimination()) {
			computeTraceClassDiscrimination();
		}
		computeTraceClassInheritance();
		this.fallibilityAnalysis = computeFallibilityAnalysis();
		computeCyclicTraceClasses();
		// FIXME check that all head nodes have trace properties
		//
		//	Perform per-mapping partitioning
		//
		List<@NonNull MappingRegion> partitionedRegions = new ArrayList<>();
		Set<@NonNull CycleAnalysis> partitionedCycles = new HashSet<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			CycleAnalysis cycleAnalysis = getCycleAnalysis(mappingPartitioner);
			if (Iterables.isEmpty(mappingPartitioner.getTraceNodes())) {
				partitionedRegions.add(mappingPartitioner.getRegion());
			}
			else if (cycleAnalysis == null) {
				Iterables.addAll(partitionedRegions, mappingPartitioner.partition());
			}
			else if (partitionedCycles.add(cycleAnalysis)) {
				Iterables.addAll(partitionedRegions, cycleAnalysis.partition(mappingPartitioners));
			}
		}
		return partitionedRegions;
	}
}
