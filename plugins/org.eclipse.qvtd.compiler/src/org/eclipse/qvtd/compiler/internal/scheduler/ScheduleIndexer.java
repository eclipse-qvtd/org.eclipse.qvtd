/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The ScheduleIndexer computes an ordering of the regions such that:
 * - all sources of a passed connection precede all targets of that connection
 * - all sources of mandatory access connection precede all targets of that connection
 * Where possible the sources of preferred access connections also precede targets of that connection.
 * 
 * The passed connection scheduling requires that the regions form an acyclic tree with respect to the passed connection.
 * This should be achieved by using the CyclesAnalyzer to factor out loops as nested CyclicScheduledRegions.
 * 
 * The mandatory connection scheduling cannot be guaranteed to be satisfied; scheduling may not be possible.
 * An IllegalStateException is thrown.
 */
public class ScheduleIndexer extends ScheduleState
{
	public ScheduleIndexer(@NonNull RootScheduledRegion rootScheduledRegion) {
		super(rootScheduledRegion);
	}

	@Override
	protected void scheduleScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		int regionCount = Iterables.size(scheduledRegion.getCallableRegions());
		for (int iRegion = 0; iRegion < regionCount; iRegion++) {
			//
			//	Pick a region to schedule.
			//
			Region selectedRegion = selectNextRegion(scheduledRegion);
			scheduleRegion(selectedRegion);
		}
		if (Scheduler.DEBUG_GRAPHS.isActive()) {
			scheduledRegion.writeDebugGraphs("6-indexed", false, true, true);
		}
	}

	/**
	 * Select the next region to be scheduled, preferring those that require no work or
	 * at least minimal violation of preferred blockages.
	 */
	protected @NonNull Region selectNextRegion(@NonNull ScheduledRegion scheduledRegion) {
//		assert orderedSchedulables.size() + unblockedRegions.size() + callableRegion2blockedConnectionCount.size() + mandatoryBlockedRegions.size() == region2incomingConnections.size();
		List<@NonNull Region> unblockedRegionsList = Lists.newArrayList(getUnblockedRegions());
		Collections.sort(unblockedRegionsList, NameUtil.NAMEABLE_COMPARATOR);
		List<@NonNull Region> callableRegionsList = Lists.newArrayList(getBlockedCallableRegions());
		Collections.sort(callableRegionsList, NameUtil.NAMEABLE_COMPARATOR);
//		List<@NonNull Region> preferredBlockedRegionsList = new ArrayList<@NonNull Region>(preferredBlockedRegions2availableFraction.keySet());
//		Collections.sort(preferredBlockedRegionsList, NameUtil.NAMEABLE_COMPARATOR);
		List<@NonNull Region> mandatoryBlockedRegionsList = Lists.newArrayList(getMandatoryBlockedRegions());
		Collections.sort(mandatoryBlockedRegionsList, NameUtil.NAMEABLE_COMPARATOR);
//		List<@NonNull Connection> partiallyBlockedConnectionsList = new ArrayList<@NonNull Connection>(partiallyBlockedConnections);
//		Collections.sort(partiallyBlockedConnectionsList, NameUtil.NAMEABLE_COMPARATOR);
		List<@NonNull Connection> blockedConnectionsList = Lists.newArrayList(getBlockedConnections());
		Collections.sort(blockedConnectionsList, NameUtil.NAMEABLE_COMPARATOR);
		if (Scheduler.REGION_ORDER.isActive()) {
			Scheduler.REGION_ORDER.println("      unblocked regions:"); 
			for (@NonNull Region region : unblockedRegionsList) {
				Scheduler.REGION_ORDER.println("        " + region); 
			}
			Scheduler.REGION_ORDER.println("      callableRegion : blockedConnectionCount:"); 
			for (@NonNull Region region : callableRegionsList) {
				Scheduler.REGION_ORDER.println("        " + region + " : " + getBlockedConnectionCount(region)); 
/*				List<@NonNull DatumConnection> incomingConnections = getIncomingConnections(region);
				assert incomingConnections != null;
				for (@NonNull DatumConnection connection : incomingConnections) {
					boolean isMandatory = connection.isMandatory();
					Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = getSourceRegion2hasContent(connection);
					assert sourceRegion2hasContent != null;
					int inCount = 0;
					int loopCount = 0;
					for (Region sourceRegion : sourceRegion2hasContent.keySet()) {
						Boolean hasContent = sourceRegion2hasContent.get(sourceRegion);
						if (hasContent != Boolean.TRUE) {
							if (sourceRegion != region) {
								inCount++;
							}
							else {
								loopCount++;
							}
						}
					}
					Scheduler.REGION_ORDER.println("          "
							+ (isMandatory ? "«mandatory» " : "")
							+ ((inCount+loopCount) > 0 ? ("«blocked:" + inCount + "+" + loopCount + "/" + sourceRegion2hasContent.size() + "» ") : "")
							+ connection.getSourceDisplayNames());
				}
			}
			Scheduler.REGION_ORDER.println("      preferred blocked regions:"); 
			for (@NonNull Region region : preferredBlockedRegionsList) {
				Scheduler.REGION_ORDER.println("        " + region + " : " + preferredBlockedRegions2availableFraction.get(region));
				List<@NonNull DatumConnection> incomingConnections = getIncomingConnections(region);
				assert incomingConnections != null;
				for (@NonNull DatumConnection connection : incomingConnections) {
					boolean isMandatory = connection.isMandatory();
					boolean isPassed = connection.isPassed();
					Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = getSourceRegion2hasContent(connection);
					assert sourceRegion2hasContent != null;
					int noContentCount = 0;
					for (Boolean hasContent : sourceRegion2hasContent.values()) {
						if (hasContent != Boolean.TRUE) {
							noContentCount++;
						}
					}
					Scheduler.REGION_ORDER.println("          "
							+ (isPassed ? "«passed» " : "")
							+ (isMandatory ? "«mandatory» " : "")
							+ (noContentCount > 0 ? ("«blocked:" + noContentCount + "/" + sourceRegion2hasContent.size() + "» ") : "")
							+ connection.getSourceDisplayNames());
				} */
			}
			Scheduler.REGION_ORDER.println("      mandatory blocked regions:"); 
			for (@NonNull Region region : mandatoryBlockedRegionsList) {
				Scheduler.REGION_ORDER.println("        " + region); 
			}
//			Scheduler.REGION_ORDER.println("      partially blocked connections:"); 
//			for (Connection connection : partiallyBlockedConnectionsList) {
//				Scheduler.REGION_ORDER.println("        " + connection); 
//			}
			Scheduler.REGION_ORDER.println("      blocked connections:"); 
			for (@NonNull Connection connection : blockedConnectionsList) {
				Scheduler.REGION_ORDER.println("        " + connection); 
			}
		}
//		int debugRegionSize = region2incomingConnections.size();
//		assert debugRegionSize == orderedSchedulables.size() + unblockedRegions.size() + partiallyBlockedRegions2availableFraction.size() + mandatoryBlockedRegions.size() + preferredBlockedRegions2availableFraction.size();
		//
		//	Select any unblocked region
		//
		if (unblockedRegionsList.size() > 0) {		// FIXME deepest compatible with current context
			//
			//	Select any unblocked connection that has no outgoing passed regions to unblock all its consumers
			//  before coming back to reconsider which region that actually involves some work is best.
			//
			for (@NonNull Region region : unblockedRegionsList) {
				if (!isPassed(region)) {
					return region;
				}
			}
			//
			//	Select the 'first' region that is not blocked at all.
			//
			return unblockedRegionsList.get(0);
		}
		//
		//	Poor choice: something that might not be ready but which run-time polling can sort out.
		//
		//
		//	Select the partially blocked region with the highest proportion of its sources fully available.
		//
		int bestBlockedConnectionCount = Integer.MAX_VALUE;
		List<@NonNull Region> bestRegions = new ArrayList<@NonNull Region>();
		for (@NonNull Region region : getBlockedCallableRegions()) {
			Integer blockedConnectionCount = getBlockedConnectionCount(region);
			assert blockedConnectionCount != null;
			if (blockedConnectionCount < bestBlockedConnectionCount) {
				bestBlockedConnectionCount = blockedConnectionCount;
				bestRegions.clear();
			}
			if (blockedConnectionCount <= bestBlockedConnectionCount) {
				bestRegions.add(region);
			}
		}
		if (bestRegions.size() > 0) {
			Collections.sort(bestRegions, NameUtil.NAMEABLE_COMPARATOR);
			return bestRegions.get(0);
		}
		throw new IllegalStateException("Failed to schedule " + scheduledRegion);
	}
}