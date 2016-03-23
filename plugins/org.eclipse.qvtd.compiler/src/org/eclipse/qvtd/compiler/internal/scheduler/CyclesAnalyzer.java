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
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * CyclesAnalyzer provides the depth analysis of all regions using all connections to locate cycles.
 */
public class CyclesAnalyzer
{

	public static final class SymbolableComparator implements Comparator<@NonNull Symbolable>
	{	
		public static final @NonNull SymbolableComparator INSTANCE = new SymbolableComparator();
	
		@Override
		public int compare(@NonNull Symbolable o1, @NonNull Symbolable o2) {
			String n1 = o1.getSymbolName();
			String n2 = o2.getSymbolName();
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	private class RegionStatus
	{
		protected final @NonNull Region region;
		
		/**
		 * The regions that source incoming connections to this region for which no depth has yet been determined.
		 */
		private final @NonNull Set<@NonNull RegionStatus> depthlessSourceRegions = new HashSet<@NonNull RegionStatus>();
		
		/**
		 * The largest depth of the sources whose depth is known. null if none known.
		 */
		private @Nullable Integer partialSourceDepth = null;

		/**
		 * The depth of this region. Set non-null once known.
		 */
		private @Nullable Integer depth = null;
		
		private @NonNull Set<@NonNull Region> debugSourceRegions = new HashSet<@NonNull Region>();
		private @NonNull Set<@NonNull Region> debugTargetRegions = new HashSet<@NonNull Region>();

		public RegionStatus(@NonNull Region region) {
			this.region = region;
			debugSourceRegions.addAll(getPreviousRegions(region));
			debugTargetRegions.addAll(getNextRegions(region));
		}
		
		private void check(@NonNull List<@NonNull RegionStatus> unblockedRegionStatuses, int orderedThreshold) {
			if (region instanceof CyclicScheduledRegion) {
				computeDepth();
			}
			Integer checkDepth = computeDepth();
			int index = unblockedRegionStatuses.indexOf(this);
			if (index < 0) {
				assert !depthlessSourceRegions.isEmpty();
//				assert partialSourceDepth == checkDepth;
				assert depth == null;
			}
			else if (index < orderedThreshold) {
				assert depthlessSourceRegions.isEmpty();
				assert partialSourceDepth == checkDepth;
				if (index == 0) {
					assert partialSourceDepth == null;
//					assert (checkDepth != null) && (checkDepth == 0);
					assert depth == 0;
				}
				else{
					assert partialSourceDepth != null;
					assert (checkDepth != null) && (depth == (checkDepth+1));
				}
			}
			else {
				assert depthlessSourceRegions.isEmpty();
				assert partialSourceDepth == checkDepth;
				assert depth == null;
			}
			for (@NonNull Region debugSourceRegion : debugSourceRegions) {
				RegionStatus regionStatus = region2status.get(debugSourceRegion);
				assert regionStatus != null;
				assert regionStatus.debugTargetRegions.contains(region);
			}
			for (@NonNull Region debugTargetRegion : debugTargetRegions) {
				RegionStatus regionStatus = region2status.get(debugTargetRegion);
				assert regionStatus != null;
				assert regionStatus.debugSourceRegions.contains(region);
			}
			assert Sets.intersection(depthlessSourceRegions, Sets.newHashSet(unblockedRegionStatuses.subList(0, orderedThreshold))).isEmpty();
//			assert partialSourceDepth == checkDepth;
//			if (!depthlessSourceRegions.isEmpty()) {
//				assert depth == null;
//			}
//			else if (depth != null) {
//				assert depth == ((checkDepth != null) ? (checkDepth+1) : 0);
//			}
//			Set<@NonNull Region> targetRegions = new HashSet<@NonNull Region>();
			for (@NonNull RegionStatus sourceRegion : depthlessSourceRegions) {
				assert debugSourceRegions.contains(sourceRegion.region); 
			}
		}
		
		private @Nullable Integer computeDepth() {
			Set<@NonNull Region> sourceRegions = new HashSet<@NonNull Region>();
			sourceRegions.addAll(getPreviousRegions(region));
			Integer checkDepth = null;
			for (@NonNull Region sourceRegion : sourceRegions) {
				RegionStatus sourceRegionStatus = region2status.get(sourceRegion);
				assert sourceRegionStatus != null;
				Integer sourceDepth = sourceRegionStatus.getDepth();
//				assert depthlessSourceRegions.contains(sourceRegionStatus) == (sourceDepth == null);
				if (sourceDepth != null) {
					checkDepth = checkDepth != null ? Math.max(checkDepth,  sourceDepth) : sourceDepth;
				}
			}
			return checkDepth;
		}

		private @Nullable Integer getDepth() {
			return depth;
		}

		@NonNull Region getRegion() {
			return region;
		}

		public @Nullable RegionCycle getDepthlessSourceClosure() {
			if (depthlessSourceRegions.isEmpty()) {
				return null;
			}
			Set<@NonNull Region> depthlessClosure = new HashSet<@NonNull Region>();
			getDepthlessSourceClosure(depthlessClosure);
			return new RegionCycle(depthlessClosure);
		}

		private void getDepthlessSourceClosure(@NonNull Set<@NonNull Region> depthlessClosure) {
			for (@NonNull RegionStatus sourceRegionStatus : depthlessSourceRegions) {
				if (depthlessClosure.add(sourceRegionStatus.getRegion())) {
					sourceRegionStatus.getDepthlessSourceClosure(depthlessClosure);
				}
			}
		}

		/**
		 * Return true if this is a root region and set its depth to zero.
		 *
		public boolean initializeRoots() {
			if (depthlessSourceRegions.isEmpty()) {
				setDepth(0);
				return true;
			}
			else {
				depth = null;
				return false;
			}
		} */

		/**
		 * Analyze all the incoming connections to build the set of source regions whose depth is unknown.
		 * Returns true if this is a root region and consequently has a known depth.
		 */
		public boolean initializeSources() {
			for (@NonNull Region sourceRegion : getPreviousRegions(region)) {
				RegionStatus sourceRegionStatus = region2status.get(sourceRegion);
				assert sourceRegionStatus != null;
				Integer sourceDepth = sourceRegionStatus.getDepth();
				if (sourceDepth == null) {
					depthlessSourceRegions.add(sourceRegionStatus);
				}
				else {
					Integer partialSourceDepth2 = partialSourceDepth;
					if (partialSourceDepth2 == null) {
						partialSourceDepth = partialSourceDepth2 = sourceDepth;
					}
					else {
						partialSourceDepth = partialSourceDepth2 = Math.max(partialSourceDepth2, sourceDepth);
					}
				}
			}
			if (Scheduler.REGION_CYCLES.isActive()) {
				Scheduler.REGION_CYCLES.println(region.getName());
				List<@NonNull String> names = new ArrayList<@NonNull String>();
				for (@NonNull RegionStatus regionStatus : depthlessSourceRegions) {
					names.add(regionStatus.getRegion().getName());
				}
				Collections.sort(names);
				for (@NonNull String name : names) {
					Scheduler.REGION_CYCLES.println("  <= " + depthlessSourceRegions.size() + " " + name);
				}
			}
			if (!depthlessSourceRegions.isEmpty()) {
				return false;
			}
//			if (partialSourceDepth != null) {
//				setDepth(partialSourceDepth+1);
//			}
			return true;
		}

		/**
		 *	Propagate the region depth to its descendants.
		 */
		public void propagate(@NonNull List<@NonNull RegionStatus> unblockedRegionStatuses) {
			assert depthlessSourceRegions.isEmpty();
			Integer checkDepth = computeDepth();
			int newDepth = checkDepth != null ? checkDepth+1 : 0;
			if (depth != null) {
				assert depth == newDepth;
			}
			else {
				this.depth = newDepth;
			}
			Scheduler.REGION_CYCLES.println(depth + " : " + region.getName());
			Integer depth2 = depth;
			assert depth2 != null;
			for (@NonNull Region targetRegion : getNextRegions(region)) {
				RegionStatus targetRegionStatus = region2status.get(targetRegion);
				assert targetRegionStatus != null;
				if (targetRegionStatus.getDepth() == null) {
					targetRegionStatus.propagateFrom(this, depth2, unblockedRegionStatuses);
				}
			}
		}

		private void propagateFrom(@NonNull RegionStatus sourceRegion, int sourceDepth, @NonNull List<@NonNull RegionStatus> unblockedRegionStatuses) {
			if (depthlessSourceRegions.remove(sourceRegion)) {
				Scheduler.REGION_CYCLES.println("    => " + depthlessSourceRegions.size() + " " + this);
				Integer partialSourceDepth2 = partialSourceDepth;
				if (partialSourceDepth2 == null) {
					partialSourceDepth = partialSourceDepth2 = sourceDepth;
				}
				else {
					partialSourceDepth = partialSourceDepth2 = Math.max(partialSourceDepth2, sourceDepth);
				}
				if (depthlessSourceRegions.isEmpty()) {
//					int regionDepth = partialSourceDepth2 + 1;
//					setDepth(regionDepth);
					unblockedRegionStatuses.add(this);
				}
			}
		}

		public void replaceCycle(@NonNull Set<@NonNull RegionStatus> oldRegionStatuses, @NonNull RegionStatus cyclicRegionStatus) {
			boolean debugGotSource = false;
			boolean debugGotTarget = false;
			for (RegionStatus oldRegionStatus : oldRegionStatuses) {
				Region oldRegion = oldRegionStatus.getRegion();
				if (debugSourceRegions.remove(oldRegion)) {
					debugGotSource = true;
				}
				if (debugTargetRegions.remove(oldRegion)) {
					debugGotTarget = true;
				}
			}
			if (debugGotSource) {
				debugSourceRegions.add(cyclicRegionStatus.getRegion());
			}
			if (debugGotTarget) {
				debugTargetRegions.add(cyclicRegionStatus.getRegion());
			}
			boolean gotOne = !Sets.intersection(depthlessSourceRegions, oldRegionStatuses).isEmpty();
			if (gotOne) {
				Scheduler.REGION_CYCLES.println(region.getName());
				for (RegionStatus oldRegionStatus : oldRegionStatuses) {
					if (depthlessSourceRegions.remove(oldRegionStatus)) {
						gotOne = true;
						Scheduler.REGION_CYCLES.println("    <> " + depthlessSourceRegions.size() + " " + oldRegionStatus);
					}
				}
//				if (cyclicRegion.getDepth() == null) {
					depthlessSourceRegions.add(cyclicRegionStatus);
//				}
//				else if (depthlessSourceRegions.isEmpty()) {
//					Integer partialSourceDepth2 = partialSourceDepth;
//					assert partialSourceDepth2 != null;
//					setDepth(partialSourceDepth2 + 1);
//					unblockedRegionStatuses.add(this);
//				}

				Scheduler.REGION_CYCLES.println("    <= " + depthlessSourceRegions.size() + " " + cyclicRegionStatus);
			}
		}

		@Override
		public String toString() {
			return region.getName();
		}
	}
	
	protected final @NonNull ScheduledRegion scheduledRegion;

	/**
	 * Working representation: one RegionStatus per schedulable Region.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull RegionStatus> region2status = new HashMap<@NonNull Region, @NonNull RegionStatus>();

	/**
	 * The result.
	 */
	private final @NonNull List<@NonNull RegionCycle> orderedCycles = new ArrayList<@NonNull RegionCycle>();

	private final @NonNull Set<@NonNull RegionStatus> blockedRegions;

	public CyclesAnalyzer(@NonNull ScheduledRegion scheduledRegion, @NonNull Iterable<@NonNull Region> regions) {
		this.scheduledRegion = scheduledRegion;
		//
		//	Create the RegionStatuses.
		//
		for (@NonNull Region region : regions) {
			assert !region.isOperationRegion();
			region2status.put(region, new RegionStatus(region));
		}
		blockedRegions = new HashSet<@NonNull RegionStatus>(region2status.values());
		//
		//	Initialize the RegionStatuses.
		//
		List<@NonNull RegionStatus> unblockedRegionStatuses = new ArrayList<@NonNull RegionStatus>();
		for (@NonNull RegionStatus regionStatus : region2status.values()) {
			if (regionStatus.initializeSources()) {
				unblockedRegionStatuses.add(regionStatus);
			}
		}
		//
		//	Propagate the known region depths to their descendants.
		//
		for (int i = 0; blockedRegions.size() > 0; ) {
//			assert Sets.intersection(blockedRegions, Sets.newHashSet(unblockedRegionStatuses.subList(0, i))).isEmpty();
//			assert Sets.intersection(blockedRegions, Sets.newHashSet(unblockedRegionStatuses.subList(i, unblockedRegionStatuses.size()))).size() == blockedRegions.size();
//			assert i + blockedRegions.size() == Sets.newHashSet(region2status.values()).size();
			while (i < unblockedRegionStatuses.size()) {
				checkAll(unblockedRegionStatuses, i);
				RegionStatus unblockedRegionStatus = unblockedRegionStatuses.get(i++);
				boolean wasRemoved = blockedRegions.remove(unblockedRegionStatus);
				assert wasRemoved;
				unblockedRegionStatus.propagate(unblockedRegionStatuses);
			}
			checkAll(unblockedRegionStatuses, i);
			if (blockedRegions.size() > 0) {
				RegionCycle cycle = removeCycle();
				if (cycle == null) {
					break;
				}
				orderedCycles.add(cycle);

				Iterable<@NonNull Region> oldRegions = cycle.getRegions();
				showOld(oldRegions);
				
				
				Set<@NonNull Region> debugOldPreviousRegions = new HashSet<@NonNull Region>();
				Set<@NonNull Region> debugOldNextRegions = new HashSet<@NonNull Region>();
				for (@NonNull Region debugOldRegion : oldRegions) {
					debugOldPreviousRegions.addAll(getPreviousRegions(debugOldRegion));
					debugOldNextRegions.addAll(getNextRegions(debugOldRegion));
				}
				CyclicScheduledRegion cyclicRegion = scheduledRegion.createCyclicScheduledRegion(oldRegions);

				
				showNew(cyclicRegion);
				
				
				
				
				
				
				Set<@NonNull Region> debugOldRegions2 = Sets.newHashSet(oldRegions);
				
				
				RegionStatus cyclicRegionStatus = new RegionStatus(cyclicRegion);
				Set<@NonNull Region> debugNewPreviousRegions = getPreviousRegions(cyclicRegion);
				Set<@NonNull Region> debugNewNextRegions = getNextRegions(cyclicRegion);
				Set<@NonNull Region> debugNewOldPreviousRegions = Sets.newHashSet(debugOldPreviousRegions);
				debugNewOldPreviousRegions.removeAll(debugOldRegions2);
				Set<@NonNull Region> debugNewOldNextRegions = Sets.newHashSet(debugOldNextRegions);
				debugNewOldNextRegions.removeAll(debugOldRegions2);
				assert debugNewPreviousRegions.equals(debugNewOldPreviousRegions);
				Set<@NonNull Region> intersection = Sets.intersection(debugNewNextRegions, debugNewOldNextRegions);
				for (@NonNull Region region : Sets.difference(debugNewNextRegions, debugNewOldNextRegions)) {
					System.out.println("Missing New Next Region: " + region);
				}
				for (@NonNull Region region : Sets.difference(debugNewOldNextRegions, debugNewNextRegions)) {
					System.out.println("Missing New Old Next Region: " + region);
				}
				for (@NonNull Region region : debugNewNextRegions) {
					System.out.println("New Next Region: " + region + " " + intersection.contains(region));
				}
				for (@NonNull Region region : debugNewOldNextRegions) {
					System.out.println("New Old Next Region: " + region + " " + intersection.contains(region));
				}
				assert debugNewNextRegions.equals(debugNewOldNextRegions);
				
				Set<@NonNull RegionStatus> oldRegionStatuses = new HashSet<@NonNull RegionStatus>();
				for (@NonNull Region oldRegion : oldRegions) {
					RegionStatus oldRegionStatus = region2status.put(oldRegion, cyclicRegionStatus);
					assert oldRegionStatus != null;
					oldRegionStatuses.add(oldRegionStatus);
					boolean wasRemoved = blockedRegions.remove(oldRegionStatus);
					assert wasRemoved;
				}
				if (cyclicRegionStatus.initializeSources()) {
					unblockedRegionStatuses.add(cyclicRegionStatus);
				}
				for (@NonNull RegionStatus regionStatus : blockedRegions) {
					regionStatus.replaceCycle(oldRegionStatuses, cyclicRegionStatus);
				}
				for (@NonNull RegionStatus regionStatus : unblockedRegionStatuses) {
					regionStatus.replaceCycle(oldRegionStatuses, cyclicRegionStatus);
				}
				region2status.put(cyclicRegion, cyclicRegionStatus);
				blockedRegions.add(cyclicRegionStatus);
//				if (cyclicRegionStatus.getDepth() != null) {
//					cyclicRegionStatus.propagate(unblockedRegionStatuses);
//				}
			}
		}
	}

	private void checkAll(@NonNull List<@NonNull RegionStatus> unblockedRegionStatuses, int orderedThreshold) {
//		assert Sets.intersection(blockedRegions, Sets.newHashSet(unblockedRegionStatuses.subList(0, i))).isEmpty();
//		assert Sets.intersection(blockedRegions, Sets.newHashSet(unblockedRegionStatuses.subList(i, unblockedRegionStatuses.size()))).size() == blockedRegions.size();
//		assert i + blockedRegions.size() == Sets.newHashSet(region2status.values()).size();
		HashSet<@NonNull RegionStatus> allRegionStatuses1 = Sets.newHashSet(region2status.values());
		HashSet<@NonNull RegionStatus> unblockedRegionStatuses1 = Sets.newHashSet(unblockedRegionStatuses.subList(0, orderedThreshold));
		HashSet<@NonNull RegionStatus> unblockedRegionStatuses2 = Sets.newHashSet(unblockedRegionStatuses.subList(orderedThreshold, unblockedRegionStatuses.size()));
		SetView<@NonNull RegionStatus> intersection1 = Sets.intersection(unblockedRegionStatuses1, blockedRegions);
		assert intersection1.isEmpty();
		SetView<@NonNull RegionStatus> intersection2 = Sets.intersection(unblockedRegionStatuses2, blockedRegions);
		assert intersection2.equals(unblockedRegionStatuses2);
		HashSet<@NonNull RegionStatus> allRegionStatuses2 = Sets.newHashSet(unblockedRegionStatuses1);
		allRegionStatuses2.addAll(blockedRegions);
		assert allRegionStatuses1.equals(allRegionStatuses2);
		for (@NonNull RegionStatus regionStatus : allRegionStatuses1) {
			regionStatus.check(unblockedRegionStatuses, orderedThreshold);
		}
	}

	private @NonNull Set<@NonNull Region> getNextRegions(@NonNull Region region) {
		Set<@NonNull Region> nextRegions = new HashSet<@NonNull Region>();
		for (@NonNull NodeConnection outgoingConnection : region.getOutgoingPassedConnections()) {
			for (Map.Entry<@NonNull Node, @NonNull ConnectionRole> targetEntry : outgoingConnection.getTargets().entrySet()) {
				if (targetEntry.getValue().isPassed()) {
					nextRegions.add(targetEntry.getKey().getRegion());
				}
			}
		}
		return nextRegions;
	}

	/**
	 * Return the cycles ordered smallest first, or null if non cycles.
	 */
	public @Nullable List<@NonNull RegionCycle> getOrderedCycles() {
		return orderedCycles;
	}

	private @NonNull Set<@NonNull Region> getPreviousRegions(@NonNull Region region) {
		Set<@NonNull Region> previousRegions = new HashSet<@NonNull Region>();
		for (@NonNull NodeConnection incomingConnection : region.getIncomingPassedConnections()) {
			for (@NonNull Region sourceRegion : incomingConnection.getSourceRegions()) {
				for (Region parentRegion; (parentRegion = sourceRegion.getInvokingRegion()) instanceof CyclicScheduledRegion; ) {
					sourceRegion = parentRegion;		// FIXME ?? which one of multiple nested Cyclic regions
				}
				previousRegions.add(sourceRegion);
			}
		}
		return previousRegions;
	}

	private void putAll(@NonNull Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> region2connections,
			@NonNull Set<@NonNull Region> regions, @NonNull NodeConnection connection) {
		for (@NonNull Region region : regions) {
			List<@NonNull NodeConnection> connections = region2connections.get(region);
			if (connections == null) {
				connections = new ArrayList<@NonNull NodeConnection>();
				region2connections.put(region, connections);
			}
			connections.add(connection);
		}
	}

	private @Nullable RegionCycle removeCycle() {
		//
		//	Locate the cycles.
		//
		Set<@NonNull RegionCycle> cyclesSet = null;
		for (@NonNull RegionStatus regionStatus : Sets.newHashSet(region2status.values())) {
			RegionCycle depthlessSourceClosure = regionStatus.getDepthlessSourceClosure();
			if (depthlessSourceClosure != null) {
				if (cyclesSet == null) {
					cyclesSet = new HashSet<@NonNull RegionCycle>();
				}
				cyclesSet.add(depthlessSourceClosure);
			}
		}
		if (cyclesSet == null) {
			Scheduler.REGION_CYCLES.println("No cycles found");
			return null;
		}
		//
		//	Return the smallest cycle.
		//
		List<@NonNull RegionCycle> cyclesList = new ArrayList<@NonNull RegionCycle>(cyclesSet);
		Collections.sort(cyclesList, RegionCycle.COMPARATOR);
		if (Scheduler.REGION_CYCLES.isActive()) {
			Scheduler.REGION_CYCLES.println("cycles ");
			for (@NonNull RegionCycle cycle : cyclesList) {
				Scheduler.REGION_CYCLES.println("    " + cycle.toString());
			}
		}
		RegionCycle smallestCycle = cyclesList.get(0);
		assert smallestCycle != null;
		return smallestCycle;
	}

	private void showAll(@NonNull String prefix, @NonNull Set<@NonNull Region> regions) {
		List<@NonNull Region> sortedRegions = Lists.newArrayList(regions);
		Collections.sort(sortedRegions, SymbolableComparator.INSTANCE);
		StringBuilder s = new StringBuilder();
		s.append(prefix);
		boolean first = true;
		for (@NonNull Region region : sortedRegions) {
			s.append(first ? " " : ",");
			s.append(region);
			first = false;
		}
		System.out.println(s.toString());
	}

	private void showAll(@NonNull String prefix, @NonNull Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> region2connections) {
		List<@NonNull Region> sortedRegions = Lists.newArrayList(region2connections.keySet());
		Collections.sort(sortedRegions, SymbolableComparator.INSTANCE);
		for (@NonNull Region region : sortedRegions) {
			StringBuilder s = new StringBuilder();
			s.append(prefix);
			s.append(region);
			List<@NonNull NodeConnection> connections = region2connections.get(region);
			assert connections != null;
			Collections.sort(connections, NameUtil.NAMEABLE_COMPARATOR);
			boolean first = true;
			for (@NonNull NodeConnection connection : connections) {
				s.append(first ? " " : ",");
				s.append(connection);
				first = false;
			}
			System.out.println(s.toString());
		}
	}

	private void showNew(@NonNull CyclicScheduledRegion cyclicRegion) {
		Set<@NonNull NodeConnection> externalConnections = new HashSet<@NonNull NodeConnection>();
		System.out.println("New Region: " + cyclicRegion);
		@NonNull
		List<@NonNull Node> sortedHeadNodes = Lists.newArrayList(cyclicRegion.getHeadNodes());
		Collections.sort(sortedHeadNodes, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Node headNode : sortedHeadNodes) {
			StringBuilder s = new StringBuilder();
			s.append("  head: ");
			s.append(headNode);
			s.append("  ");
			s.append(headNode.getIncomingConnection());
			System.out.println(s.toString());
		}
		Iterables.addAll(externalConnections, cyclicRegion.getIncomingPassedConnections());
		Iterables.addAll(externalConnections, cyclicRegion.getOutgoingPassedConnections());
		List<@NonNull NodeConnection> sortedExternalConnections = Lists.newArrayList(externalConnections);
		Collections.sort(sortedExternalConnections, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull NodeConnection externalConnection : sortedExternalConnections) {
			System.out.println("New Connection: " + externalConnection);
		}
	}

	private void showOld(@NonNull Iterable<@NonNull Region> oldRegions) {
		Set<@NonNull Region> debugOldRegions = Sets.newHashSet(oldRegions);
		
		List<@NonNull Region> sortedOldRegions = Lists.newArrayList(oldRegions);
		Collections.sort(sortedOldRegions, SymbolableComparator.INSTANCE);
		Set<@NonNull NodeConnection> debugOldConnections = new HashSet<@NonNull NodeConnection>();
		for (@NonNull Region debugOldRegion : sortedOldRegions) {
			System.out.println("Old Region: " + debugOldRegion);
			Iterables.addAll(debugOldConnections, debugOldRegion.getIncomingPassedConnections());
			Iterables.addAll(debugOldConnections, debugOldRegion.getOutgoingPassedConnections());
		}
		List<@NonNull NodeConnection> sortedOldConnections = Lists.newArrayList(debugOldConnections);
		Collections.sort(sortedOldConnections, NameUtil.NAMEABLE_COMPARATOR);
		Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> allInternalSourceRegions = new HashMap<@NonNull Region, @NonNull List<@NonNull NodeConnection>>();
		Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> allExternalSourceRegions = new HashMap<@NonNull Region, @NonNull List<@NonNull NodeConnection>>();
		Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> allInternalTargetRegions = new HashMap<@NonNull Region, @NonNull List<@NonNull NodeConnection>>();
		Map<@NonNull Region, @NonNull List<@NonNull NodeConnection>> allExternalTargetRegions = new HashMap<@NonNull Region, @NonNull List<@NonNull NodeConnection>>();
		for (@NonNull NodeConnection debugOldConnection : sortedOldConnections) {
			System.out.println("Old Connection: " + debugOldConnection);

			Set<@NonNull Region> internalSourceRegions = Sets.newHashSet(debugOldConnection.getSourceRegions());
			internalSourceRegions.retainAll(debugOldRegions);
			putAll(allInternalSourceRegions, internalSourceRegions, debugOldConnection);
			showAll("    internal sources: ", internalSourceRegions);

			Set<@NonNull Region> externalSourceRegions = Sets.newHashSet(debugOldConnection.getSourceRegions());
			externalSourceRegions.removeAll(debugOldRegions);
			putAll(allExternalSourceRegions, externalSourceRegions, debugOldConnection);
			showAll("    external sources: ", externalSourceRegions);

			Set<@NonNull Region> internalTargetRegions = Sets.newHashSet(debugOldConnection.getTargetRegions());
			internalTargetRegions.retainAll(debugOldRegions);
			putAll(allInternalTargetRegions, internalTargetRegions, debugOldConnection);
			showAll("    internal targets: ", internalTargetRegions);

			Set<@NonNull Region> externalTargetRegions = Sets.newHashSet(debugOldConnection.getTargetRegions());
			externalTargetRegions.removeAll(debugOldRegions);
			putAll(allExternalTargetRegions, externalTargetRegions, debugOldConnection);
			showAll("    external targets: ", externalTargetRegions);
		}
		showAll("internal source: ", allInternalSourceRegions);
		showAll("external source: ", allExternalSourceRegions);
		showAll("internal target: ", allInternalTargetRegions);
		showAll("external target: ", allExternalTargetRegions);
	}
}