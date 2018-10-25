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
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The TransformationPartitioner supervises a MappingPartitioner for each mapping region. It provides
 * the global analysis to support the local partitioning.
 */
public class TransformationPartitioner extends QVTbaseHelper implements Nameable
{
	public static final @NonNull TracingOption CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/cycles");
	public static final @NonNull TracingOption DISCRIMINATION = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/discrimination");
	public static final @NonNull TracingOption PREDECESSORS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/predecessors");
	public static final @NonNull TracingOption SUCCESSORS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/partition/successors");

	public static @NonNull PartitionedTransformationAnalysis partition(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) throws CompilerChainException {
		TransformationPartitioner transformationPartitioner = new TransformationPartitioner(transformationAnalysis, problemHandler, activeRegions);
		return transformationPartitioner.partition();
	}

	/**
	 * The supervising ScheduleManager.
	 */
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;
	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull Iterable<@NonNull ? extends Region> activeRegions;
	private final @NonNull List<@NonNull PartitionAnalysis> partitionAnalyses = new ArrayList<>();

	/**
	 * The partitioner for each region.
	 */
	private final @NonNull Map<@NonNull MappingRegion, @NonNull MappingPartitioner> region2mappingPartitioner = new HashMap<>();

	/**
	 * The partitioners in the original activeRegions order.
	 */
	private final @NonNull List<@NonNull MappingPartitioner> mappingPartitioners = new ArrayList<>();

	/**
	 * The analysis of cycle regions that can succeed despite edges that may fail.
	 *
	@SuppressWarnings("unused")
	private @Nullable FallibilityAnalysis fallibilityAnalysis = null; */

	/**
	 * Closure of the mapping to the trace class analyses that must succeed unconditionally for the key trace class analysis to succeed unconditionally..
	 */
	//	private @Nullable Map<@NonNull TraceClassAnalysis, @NonNull Set<@NonNull TraceClassAnalysis>> traceClassAnalysis2traceClassAnalysesClosure = null;

	/**
	 * The analysis of cycles.
	 */
	private @Nullable CyclicPartitionsAnalysis cyclicPartitionsAnalysis = null;

	public TransformationPartitioner(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		super(transformationAnalysis.getScheduleManager().getEnvironmentFactory());
		this.scheduleManager = transformationAnalysis.getScheduleManager();
		this.transformationAnalysis = transformationAnalysis;
		this.problemHandler = problemHandler;
		this.activeRegions = activeRegions;
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	/*	protected @NonNull FallibilityAnalysis computeFallibilityAnalysis() {
		FallibilityAnalysis fallibilityAnalysis = new FallibilityAnalysis(transformationAnalysis);
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			fallibilityAnalysis.accumulate(mappingPartitioner.getRegionAnalysis());
		}
		fallibilityAnalysis.install();
		return fallibilityAnalysis;
	} */

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


	public @NonNull MappingPartitioner getMappingPartitioner(@NonNull MappingRegion region) {
		return ClassUtil.nonNullState(region2mappingPartitioner.get(region));
	}

	@Override
	public String getName() {
		return transformationAnalysis.getName();
	}

	//	@Override
	//	protected @NonNull Iterable<@NonNull Partition> getPartialRegionAnalyses() {
	//		return partitions;
	//	}

	//	public @NonNull PartitionedTransformationAnalysis getPartitionedTransformationAnalysis() {
	//		return partitionedTransformationAnalysis;
	//	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty) {
		return scheduleManager.getSuccessPropertyDatum(successProperty);
	}

	public @NonNull Transformation getTransformation() {
		return transformationAnalysis.getTransformation();
	}

	public @NonNull AbstractTransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
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

	public @NonNull PartitionedTransformationAnalysis partition() throws CompilerChainException {
		PartitionedTransformationAnalysis partitionedTransformationAnalysis = new PartitionedTransformationAnalysis(this);
		//
		//	Create the per-mapping partitioner and accumulate the local analyses
		//
		for (@NonNull Region region : activeRegions) {
			RegionAnalysis regionAnalysis = transformationAnalysis.getRegionAnalysis(region);
			if (region instanceof MappingRegion) {
				MappingRegion mappingRegion = (MappingRegion)region;
				MappingPartitioner mappingPartitioner = new MappingPartitioner(this, regionAnalysis);
				region2mappingPartitioner.put(mappingRegion, mappingPartitioner);
				mappingPartitioners.add(mappingPartitioner);
			}
			else if (region instanceof LoadingRegion) {
				LoadingPartitionAnalysis loadingPartitionAnalysis = LoadingPartitionAnalysis.createLoadingPartitionAnalysis(partitionedTransformationAnalysis, (LoadingRegion) region);
				partitionAnalyses.add(loadingPartitionAnalysis);
				regionAnalysis.setPartitionAnalyses(Collections.singletonList(loadingPartitionAnalysis));
				ScheduledRegion scheduledRegion = transformationAnalysis.getScheduledRegion();
				scheduledRegion.setOwnedLoadingRegion((LoadingRegion) region);
			}
		}
		Collections.sort(mappingPartitioners, NameUtil.NAMEABLE_COMPARATOR);
		//
		//	Perform global analyses
		//
		transformationAnalysis.prePartition();
		//
		// FIXME check that all head nodes have trace properties
		//
		//	Perform per-mapping partitioning
		//
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			Iterable<@NonNull PartitionAnalysis> regionPartitionAnalyses;
			RegionAnalysis regionAnalysis = mappingPartitioner.getRegionAnalysis();
			if (Iterables.isEmpty(mappingPartitioner.getTraceNodes())) {
				NonPartitionAnalysis nonPartitionAnalysis = new NonPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis);
				regionPartitionAnalyses = Collections.singletonList(nonPartitionAnalysis);
			}
			else {
				regionPartitionAnalyses = Lists.newArrayList(mappingPartitioner.partition(partitionedTransformationAnalysis));
			}
			regionAnalysis.setPartitionAnalyses(regionPartitionAnalyses);
			Iterables.addAll(partitionAnalyses, regionPartitionAnalyses);
		}
		Collections.sort(partitionAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		return postPartition(partitionedTransformationAnalysis);
	}

	public @NonNull PartitionedTransformationAnalysis postPartition(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) throws CompilerChainException {
		partitionedTransformationAnalysis.analyzePartitions(partitionAnalyses);
		partitionedTransformationAnalysis.computeTraceClassInheritance();
		//		this.fallibilityAnalysis = computeFallibilityAnalysis();
		//	Iterable<@NonNull Partition> leafPartitions = getPartialRegionAnalyses();
		this.cyclicPartitionsAnalysis = new CyclicPartitionsAnalysis(this, partitionAnalyses);
		cyclicPartitionsAnalysis.analyze(partitionedTransformationAnalysis);
		return partitionedTransformationAnalysis;
	}
}
