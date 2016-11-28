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
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MultiRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.LateMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.Partitioner;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTs extends QVTimperativeHelper
{
	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull String rootName;

	public QVTs2QVTs(@NonNull ProblemHandler problemHandler, @NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull String rootName) {
		super(environmentFactory);
		this.problemHandler = problemHandler;
		this.rootName = rootName;
	}

	public @NonNull RootScheduledRegion createRootRegion(@NonNull Iterable<@NonNull ? extends Region> allRegions) {
		RootScheduledRegion rootRegion = null;
		for (@NonNull Region region : Lists.newArrayList(allRegions)) {
			if (region.getInvokingRegion() == null) {
				if (rootRegion == null) {
					rootRegion = new RootScheduledRegion(rootName, region);
				}
				rootRegion.addRegion(region);
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
		/*		for (@NonNull Region region : rootScheduledRegion.getCallableRegions()) {
			Splitter splitter = new Splitter(region);
			Split split = splitter.split();
			if (split != null) {
				//				split.install();
			}
		} */
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

	protected void splitRegions() {
	}

	public @NonNull RootScheduledRegion transform(@NonNull MultiRegion multiRegion) throws CompilerChainException {
		Iterable<@NonNull ? extends Region> activeRegions = multiRegion.getActiveRegions();
		//		for (@NonNull Region region : activeRegions) {
		//			System.out.println("activeRegions " + region);
		//		}
		Iterable<@NonNull MappingRegion> partitionedRegions = Partitioner.partition(problemHandler, activeRegions);
		if (!Iterables.isEmpty(partitionedRegions)) {
			//			for (@NonNull Region region : partitionedRegions) {
			//				System.out.println("partitionedRegions " + region);
			//			}
			activeRegions = partitionedRegions;
		}
		RootScheduledRegion rootRegion = createRootRegion(activeRegions);
		rootRegion.createSchedule();
		createSchedule(rootRegion);
		LateMerger.merge(rootRegion);
		return rootRegion;
	}
}
