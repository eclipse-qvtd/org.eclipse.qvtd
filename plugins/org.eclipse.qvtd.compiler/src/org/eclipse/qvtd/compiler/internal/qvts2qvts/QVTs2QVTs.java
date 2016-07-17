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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleMappingRegion;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MultiRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.OperationRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyRegionMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter.Split;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter.Splitter;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;

import com.google.common.collect.Lists;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTs extends QVTimperativeHelper
{
	public static final @NonNull TracingOption EDGE_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/edgeOrder");
	public static final @NonNull TracingOption REGION_CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/regionCycles");
	public static final @NonNull TracingOption REGION_DEPTH = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/regionDepth");
	//	public static final @NonNull TracingOption REGION_LOCALITY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/regionLocality");
	public static final @NonNull TracingOption REGION_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/regionOrder");
	public static final @NonNull TracingOption REGION_STACK = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/regionStack");
	public static final @NonNull TracingOption REGION_TRAVERSAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/regionTraversal");

	protected final @NonNull String rootName;

	public QVTs2QVTs(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull String rootName) {
		super(environmentFactory);
		this.rootName = rootName;
	}

	public @NonNull RootScheduledRegion createRootRegion(@NonNull Iterable<@NonNull Region> allRegions) {
		RootScheduledRegion rootRegion = null;
		for (@NonNull Region region : Lists.newArrayList(allRegions)) {
			if (region.getInvokingRegion() == null) {
				if (rootRegion == null) {
					rootRegion = new RootScheduledRegion(region.getMultiRegion(), rootName);
				}
				//				rootRegion.addRegion(region);
			}
		}
		assert rootRegion != null;
		return rootRegion;
	}

	protected void createSchedule(@NonNull RootScheduledRegion rootScheduledRegion) {
		//
		//	Replace multi-region recursions by single nested region recursions.
		//
		List<@NonNull ScheduledRegion> allScheduledRegions = new ArrayList<>();
		allScheduledRegions.add(rootScheduledRegion);
		CyclesAnalyzer cyclesAnalyzer = new CyclesAnalyzer(rootScheduledRegion, rootScheduledRegion.getCallableRegions());
		List<@NonNull RegionCycle> regionCycles = cyclesAnalyzer.getOrderedCycles();
		if (regionCycles != null) {
			/*			for (@NonNull RegionCycle regionCycle : regionCycles) {
				Iterable<@NonNull Region> regions = regionCycle.getRegions();
				if (Iterables.size(regions) == 1) {
					regions.iterator().next().setIsCyclic();
				}
				else {
					CyclicScheduledRegion cyclicRegion = createCyclicRegion(regions);
					allScheduledRegions.add(cyclicRegion);
				}
			} */
		}
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			rootScheduledRegion.writeDebugGraphs("4-cycles", true, true, false);
		}
		//
		//	Create the schedule for each directed acyclic scheduled region.
		//
		for (@NonNull ScheduledRegion scheduledRegion : allScheduledRegions) {
			scheduledRegion.createLocalSchedule();
		}
		ScheduleIndexer scheduleIndexer = new ScheduleIndexer(rootScheduledRegion);
		scheduleIndexer.schedule(rootScheduledRegion);
		for (@NonNull ScheduledRegion scheduledRegion : allScheduledRegions) {
			scheduledRegion.createLocalSchedule2(scheduleIndexer.getOrdering());
		}
	}

	/**
	 * Merge any mappings that are locally compatible. // FIXME do/done in QVTm2QVTp
	 * Returns a pruned list of mappings.
	 */
	protected @NonNull Iterable<@NonNull Region> earlyRegionMerge(@NonNull MultiRegion multiRegion, @NonNull List<@NonNull SimpleMappingRegion> orderedRegions) {
		EarlyRegionMerger earlyRegionMerger = new EarlyRegionMerger(this);
		List<@NonNull Region> earlyMergedRegions = new ArrayList<@NonNull Region>(earlyRegionMerger.earlyRegionMerge(orderedRegions));
		for (@NonNull OperationRegion operationRegion : multiRegion.getOperationRegions()) {
			earlyMergedRegions.add(operationRegion);
		}
		return earlyMergedRegions;
	}

	protected @NonNull Iterable<@NonNull Region> splitMultiHeadedRegions(@NonNull RootScheduledRegion rootRegion, @NonNull Iterable<@NonNull Region> inputRegions) {
		List<@NonNull Region> outputRegions = new ArrayList<>();
		for (@NonNull Region region : inputRegions) {
			if (region instanceof SimpleMappingRegion) {
				Splitter splitter = new Splitter((SimpleMappingRegion) region);
				Split split = splitter.split();
				if (split != null) {
					CompilerUtil.addAll(outputRegions, split.install(rootRegion));
				}
				else {
					outputRegions.add(region);
				}
			}
			else {
				outputRegions.add(region);
			}
		}
		return outputRegions;
	}

	public @NonNull RootScheduledRegion transform(@NonNull MultiRegion multiRegion) {
		List<@NonNull SimpleMappingRegion> orderedRegions = multiRegion.getOrderedRegions();
		//
		//	Merge mappings that are trivially compatible.
		//
		Iterable<@NonNull Region> earlyMergedRegions = earlyRegionMerge(multiRegion, orderedRegions);
		RootScheduledRegion rootRegion = createRootRegion(earlyMergedRegions);
		//
		//	Merge mappings that are trivially compatible.
		//
		Iterable<@NonNull Region> splitHeadRegions = splitMultiHeadedRegions(rootRegion, earlyMergedRegions);
		//
		rootRegion.createSchedule(splitHeadRegions);
		createSchedule(rootRegion);
		return rootRegion;
	}
}
