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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ScheduledRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Scheduler;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTs extends QVTimperativeHelper
{
	public QVTs2QVTs(@NonNull QVTiEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	protected void createSchedule(@NonNull RootScheduledRegion rootScheduledRegion) {
		//
		//	Replace multi-region recursions by single nested region recursions.
		//
		List<@NonNull ScheduledRegion> allScheduledRegions = new ArrayList<@NonNull ScheduledRegion>();
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
		if (Scheduler.DEBUG_GRAPHS.isActive()) {
			rootScheduledRegion.writeDebugGraphs("4-cycles", true, true, false);
		}
		//
		//	Create the schedule for each directed acyclic scheduled region.
		//
		for (ScheduledRegion scheduledRegion : allScheduledRegions) {
			scheduledRegion.createLocalSchedule();
		}
		ScheduleIndexer scheduleIndexer = new ScheduleIndexer(rootScheduledRegion);
		scheduleIndexer.schedule(rootScheduledRegion);
		for (ScheduledRegion scheduledRegion : allScheduledRegions) {
			scheduledRegion.createLocalSchedule2(scheduleIndexer.getOrdering());
		}
	}

	protected void splitRegions() {
		//		Splitter splitter = new Splitter(region);
		//		Split split = splitter.split();
	}

	public void transform(@NonNull RootScheduledRegion scheduledRegion) {
		createSchedule(scheduledRegion);
	}
}
