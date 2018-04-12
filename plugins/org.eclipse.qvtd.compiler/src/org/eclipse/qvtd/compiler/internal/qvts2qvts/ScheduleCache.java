/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/**
 * ScheduleCache provides the immutable caches used during the schedule index allocation.
 */
public abstract class ScheduleCache
{
	/**
	 * The overall RootScheduledRegion.
	 */
	protected final @NonNull ScheduledRegion scheduledRegion;

	/**
	 * All transitively callable regions within the rootScheduledRegion (no OperationRegions).
	 */
	protected final @NonNull List<@NonNull  Region> callableRegions;

	/**
	 * Cached list of all incoming connections per-region; excludes recursions.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull DatumConnection<?>>> region2incomingConnections = new HashMap<>();

	/**
	 * Cached list of all recursive/looping connections per-region.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull DatumConnection<?>>> region2loopingConnections = new HashMap<>();

	/**
	 * Cached list of all outgoing connections per-region; excludes recursions.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull DatumConnection<?>>> region2outgoingConnections = new HashMap<>();

	/**
	 * Cached list of all source regions per-connection and whether the source has unserviced content for the connection.
	 */
	private final @NonNull Map<@NonNull DatumConnection<?>, @NonNull List<@NonNull Region>> connection2sourceRegions = new HashMap<>();

	/**
	 * Cached list of all target regions per-connection and whether the connection has unserviced content for the target.
	 */
	private final @NonNull Map<@NonNull DatumConnection<?>, @NonNull List<@NonNull Region>> connection2targetRegions = new HashMap<>();

	/**
	 * The immediate source region of each incoming connection.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull Set<@NonNull Region>> target2sources;

	/**
	 * The immediate source regions for each set of regions forming a cycle.
	 */
	private final @NonNull Map<@NonNull Set<@NonNull Region>, @NonNull Set<@NonNull Region>> cycle2sources;

	/**
	 * The cycle in which each region may participate.
	 */
	private final Map<@NonNull Region, @NonNull Set<@NonNull Region>> region2cycle;

	/**
	 * Depth in the call tree of each region. For the most part all source elements are at lower depth than target elements,
	 * however the call tree may have cycles which have the same depth throughout the cycle.
	 *
	 * FIXME this depth analysis has evolved from when scheduling made extensive use of MappingCalls. Now that
	 * Connections have been introduced, is the depth still useful and does it repeat some of the intervalIndex analysis?
	 */
	private final @NonNull Map<@NonNull Region, @NonNull Integer> region2depth;

	/**
	 * The parents (invokers) of each region.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> region2parents;

	/**
	 * The regions that have no outgoing passed connections.
	 */
	private final @NonNull Set<@NonNull Region> unpassedRegions = new HashSet<>();

	protected ScheduleCache(@NonNull ScheduledRegion scheduledRegion) {
		this.scheduledRegion = scheduledRegion;
		this.callableRegions = analyzeRegions(scheduledRegion, new ArrayList<>());
		Collections.sort(this.callableRegions, NameUtil.NAMEABLE_COMPARATOR);
		//
		// Initialize the incoming/looping/outgoing connection analyses of each region
		//
		for (@NonNull Region region : this.callableRegions) {
			analyzeConnections(region);
		}
		//
		// Initialize the source/target of each connection.
		// Compute the set of all connections that are not passed.
		//
		for (@NonNull Region region : this.callableRegions) {
			analyzeSourcesAndTargets(region);
		}
		//
		//	Identify all the source regions for each target region.
		//
		this.target2sources = analyzeSources();
		//
		//	Identify all the cycles and their immedite sources.
		//
		this.cycle2sources = analyzeCycleSources();
		//
		//	Identify all the region that participate in cycles.
		//
		this.region2cycle = analyzeCycleElements();
		//
		//	Determine the call tree depth of each connection / region.
		//
		this.region2depth = analyzeDepths();
		//
		//	Determine the call tree parents of each region.
		//
		this.region2parents = analyzeParents();
		//		System.out.println(toString());
	}

	/**
	 * Initialize the incoming/looping/outgoing connection analyses of each region
	 */
	private void analyzeConnections(@NonNull Region region) {
		List<@NonNull DatumConnection<?>> incomingConnections = new ArrayList<>();
		List<@NonNull DatumConnection<?>> loopingConnections = new ArrayList<>();
		List<@NonNull DatumConnection<?>> outgoingConnections = new ArrayList<>();
		for (@NonNull DatumConnection<?> connection : region.getIncomingConnections()) {
			for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
				if (region == sourceRegion) {
					if (!loopingConnections.contains(connection)) {
						loopingConnections.add(connection);
					}
				}
				else {
					if (!incomingConnections.contains(connection)) {
						incomingConnections.add(connection);
					}
				}
			}
		}
		for (@NonNull DatumConnection<?> connection : region.getNextConnections()) {
			for (@NonNull Region targetRegion : connection.getTargetRegions()) {
				if (region == targetRegion) {
					assert loopingConnections.contains(connection);
					loopingConnections.add(connection);
				}
				else if (!outgoingConnections.contains(connection)) {
					outgoingConnections.add(connection);
				}
			}
		}
		if (outgoingConnections.size() > 1) {			// Ensure that connection ordering is deterministic
			Collections.sort(outgoingConnections, NameUtil.NAMEABLE_COMPARATOR);
		}
		region2incomingConnections.put(region, incomingConnections);
		region2loopingConnections.put(region, loopingConnections);
		region2outgoingConnections.put(region, outgoingConnections);
	}

	//
	//	Determine the cycles and their sources.
	//
	private @NonNull Map<@NonNull Region, @NonNull Set<@NonNull Region>> analyzeCycleElements() {
		Map<@NonNull Region, @NonNull Set<@NonNull Region>> region2cycle = new HashMap<>();
		for (@NonNull Set<@NonNull Region> cycle : cycle2sources.keySet()) {
			for (@NonNull Region region : cycle) {
				region2cycle.put(region, cycle);
			}
		}
		return region2cycle;
	}

	//
	//	Determine the cycles and their sources.
	//
	private @NonNull Map<@NonNull Set<@NonNull Region>, @NonNull Set<@NonNull Region>> analyzeCycleSources() {
		Map<@NonNull Set<@NonNull Region>, @NonNull Set<@NonNull Region>> cycle2sources = new HashMap<>();
		Map<@NonNull Region, @NonNull Set<@NonNull Region>> target2sourcesClosure = CompilerUtil.computeClosure(target2sources);
		Map<@NonNull Region, @NonNull Set<@NonNull Region>> source2targetsClosure = CompilerUtil.computeInverseClosure(target2sourcesClosure);
		for (@NonNull Region region : callableRegions) {
			Set<@NonNull Region> sourceRegions = target2sourcesClosure.get(region);
			Set<@NonNull Region> targetRegions = source2targetsClosure.get(region);
			assert (sourceRegions != null) && (targetRegions != null);
			Set<@NonNull Region> cyclicRegions = new HashSet<>(sourceRegions);
			cyclicRegions.retainAll(targetRegions);
			if (!cyclicRegions.isEmpty() && !cycle2sources.containsKey(cyclicRegions)) {
				Set<@NonNull Region> cycleSources = new HashSet<>();
				for (@NonNull Region cyclicRegion : cyclicRegions) {
					Set<@NonNull Region> sources = target2sources.get(cyclicRegion);
					assert sources != null;
					cycleSources.addAll(sources);
				}
				cycleSources.removeAll(cyclicRegions);
				cycle2sources.put(cyclicRegions, cycleSources);
			}
		}
		return cycle2sources;
	}

	private @NonNull Map<@NonNull Region, @NonNull Integer> analyzeDepths() {
		//
		//	Loop to allocate connection/node element to each depth so that each element has as few sources at greater depth.
		//
		Map<@NonNull Region, @NonNull Integer> region2depth = new HashMap<>();
		Set<@NonNull Region> allRegions = new HashSet<>(target2sources.keySet());
		Set<@NonNull Region> pendingRegions = new HashSet<>(allRegions);
		Set<@NonNull Set<@NonNull Region>> pendingCycles = new HashSet<>(cycle2sources.keySet());
		region2depth.put(scheduledRegion, 0);
		for (int depth = 1; !pendingRegions.isEmpty(); depth++) {
			Set<@NonNull Region> readyRegions = new HashSet<>(region2depth.keySet());
			Set<@NonNull Region> nowReadyRegions = new HashSet<>();
			Set<@NonNull Set<@NonNull Region>> nowReadyCycles = new HashSet<>();
			for (@NonNull Region targetRegion : pendingRegions) {
				Set<@NonNull Region> targetSourceRegions = new HashSet<>(target2sources.get(targetRegion));
				assert targetSourceRegions != null;
				targetSourceRegions.removeAll(readyRegions);
				if (targetSourceRegions.isEmpty()) {
					nowReadyRegions.add(targetRegion);
				}
			}
			for (@NonNull Set<@NonNull Region> targetCycle : pendingCycles) {
				Set<@NonNull Region> targetSourceRegions = new HashSet<>(cycle2sources.get(targetCycle));
				assert targetSourceRegions != null;
				targetSourceRegions.removeAll(readyRegions);
				if (targetSourceRegions.isEmpty()) {
					nowReadyRegions.addAll(targetCycle);
					nowReadyCycles.add(targetCycle);
				}
			}
			if (nowReadyRegions.size() > 0) {			// one or more elements has all sources at lower depths.
				for (@NonNull Region nowReadyElement : nowReadyRegions) {
					region2depth.put(nowReadyElement, depth);
					pendingRegions.remove(nowReadyElement);
				}
				pendingCycles.removeAll(nowReadyCycles);
			}
			else {										// else choose an elements with fewest greater depth sources.
				Region fewestBadSourceElement = null;
				int badSources = Integer.MAX_VALUE;
				for (@NonNull Region targetElement : pendingRegions) {
					Set<@NonNull Element> targetSourceElements = new HashSet<>(target2sources.get(targetElement));
					assert targetSourceElements != null;
					targetSourceElements.removeAll(readyRegions);
					int targetSourceElementsSize = targetSourceElements.size();
					if ((fewestBadSourceElement == null) || (targetSourceElementsSize < badSources)) {
						badSources = targetSourceElementsSize;
						fewestBadSourceElement = targetElement;
					}
				}
				assert fewestBadSourceElement != null;
				region2depth.put(fewestBadSourceElement, depth);
				pendingRegions.remove(fewestBadSourceElement);
			}
		}
		return region2depth;
	}

	private @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> analyzeParents() {
		Map<@NonNull Region, @NonNull List<@NonNull Region>> region2parents = new HashMap<>();
		region2parents.put(scheduledRegion, Collections.emptyList());
		for (@NonNull Region targetRegion : callableRegions) {
			Set<@NonNull Region> parentSet = new HashSet<>();
			Set<@NonNull Region> sourceRegions = target2sources.get(targetRegion);
			assert sourceRegions != null;
			for (@NonNull Region sourceRegion : sourceRegions) {
				Set<@NonNull Region> sourceCycle = region2cycle.get(sourceRegion);
				if (sourceCycle != null) {
					Set<@NonNull Region> cycleSources = cycle2sources.get(sourceCycle);
					assert cycleSources != null;
					parentSet.addAll(cycleSources);
				}
				else {
					parentSet.add(sourceRegion);
				}
			}
			if (parentSet.isEmpty()) {
				parentSet.add(scheduledRegion);
			}
			List<@NonNull Region> parentList = new ArrayList<>(parentSet);
			Collections.sort(parentList, NameUtil.NAMEABLE_COMPARATOR);
			region2parents.put(targetRegion, parentList);
		}
		return region2parents;
	}

	private  @NonNull List<@NonNull Region> analyzeRegions(@NonNull ScheduledRegion outerScheduledRegion, @NonNull List<@NonNull Region> allCallableRegions) {
		for (@NonNull Region region : outerScheduledRegion.getCallableRegions()) {
			assert !region.isOperationRegion();
			assert !allCallableRegions.contains(region);
			allCallableRegions.add(region);
			if (region instanceof ScheduledRegion) {
				ScheduledRegion innerScheduledRegion = (ScheduledRegion)region;
				analyzeRegions(innerScheduledRegion, allCallableRegions);
			}
		}
		return allCallableRegions;
	}

	/**
	 * Initialize the source/target content of each connection of each region to empty.
	 * Compute the set of all connections that are not passed.
	 * Compute the set of all regions that are blocked by a mandatory dependence.
	 */
	private void analyzeSourcesAndTargets(@NonNull Region region) {
		boolean hasPassedConnection = false;
		for (@NonNull DatumConnection<?> connection : getOutgoingConnections(region)) {
			if (connection.isPassed()) {
				hasPassedConnection = true;
				break;
			}
		}
		if (!hasPassedConnection) {
			unpassedRegions.add(region);
		}
		for (@NonNull DatumConnection<?> connection : getIncomingConnections(region)) {
			List<@NonNull Region> sourceRegions = connection2sourceRegions.get(connection);
			if (sourceRegions == null) {
				sourceRegions = new ArrayList<>();
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					if (!sourceRegions.contains(sourceRegion)) {
						sourceRegions.add(sourceRegion);
					}
				}
				connection2sourceRegions.put(connection, sourceRegions);
			}
			List<@NonNull Region> targetRegions = connection2targetRegions.get(connection);
			if (targetRegions == null) {
				targetRegions = new ArrayList<>();
				for (@NonNull Region targetRegion : connection.getTargetRegions()) {
					if (!targetRegions.contains(targetRegion)) {
						targetRegions.add(targetRegion);
					}
				}
				connection2targetRegions.put(connection, targetRegions);
			}
		}
	}

	//
	//	Identify all the source regions for each target region.
	//
	private @NonNull Map<@NonNull Region, @NonNull Set<@NonNull Region>> analyzeSources() {
		Map<@NonNull Region, @NonNull Set<@NonNull Region>> target2sources = new HashMap<>();
		for (@NonNull Region region : callableRegions) {
			target2sources.put(region, new HashSet<>());
		}
		for (@NonNull Region region : callableRegions) {
			Set<@NonNull Region> sources = new HashSet<>();
			target2sources.put(region, sources);
			List<@NonNull DatumConnection<?>> incomingConnections = region2incomingConnections.get(region);
			//			List<@NonNull DatumConnection<?>> loopingConnections = region2loopingConnections.get(region);
			//			List<@NonNull DatumConnection<?>> outgoingConnections = region2outgoingConnections.get(region);
			assert incomingConnections != null;
			for (@NonNull DatumConnection<?> incomingConnection : incomingConnections) {
				List<@NonNull Region> sourceRegions = connection2sourceRegions.get(incomingConnection);
				assert sourceRegions != null;
				sources.addAll(sourceRegions);
			}
		}
		return target2sources;
	}

	public Region getCommonRegion(@NonNull Region firstRegion, @NonNull Region secondRegion) {
		Region thisRegion = firstRegion;
		Region thatRegion = secondRegion;
		while (thisRegion != thatRegion) {
			int thisDepth = getRegionDepth(thisRegion);
			int thatDepth = getRegionDepth(thatRegion);
			if (thisDepth > thatDepth) {
				thisRegion = getMinimumDepthParentRegion(thisRegion);
				if (thisRegion == null) {
					return null;
				}
			}
			else if (thatDepth > thisDepth) {
				thatRegion = getMinimumDepthParentRegion(thatRegion);
				if (thatRegion == null) {
					return null;
				}
			}
			else {
				thisRegion = getMinimumDepthParentRegion(thisRegion);
				thatRegion = getMinimumDepthParentRegion(thatRegion);
				if ((thisRegion == null) || (thatRegion == null)) {
					return null;
				}
			}
		}
		return thisRegion;
	}

	protected @NonNull Iterable<? extends @NonNull DatumConnection<?>> getConnections() {
		return connection2targetRegions.keySet();
	}

	protected @NonNull Iterable<@NonNull DatumConnection<?>> getIncomingConnections(@NonNull Region region) {
		List<@NonNull DatumConnection<?>> incomingConnections = region2incomingConnections.get(region);
		assert incomingConnections != null;
		return incomingConnections;
	}

	protected @NonNull Iterable<@NonNull DatumConnection<?>> getLoopingConnections(@NonNull Region region) {
		List<@NonNull DatumConnection<?>> loopingConnections = region2loopingConnections.get(region);
		assert loopingConnections != null;
		return loopingConnections;
	}

	public Region getMinimumDepthParentRegion(@NonNull Region childRegion) {
		Region minimumDepthParentRegion = null;
		int minimumDepth = Integer.MAX_VALUE;
		List<@NonNull Region> parentRegions = region2parents.get(childRegion);
		assert parentRegions != null;
		for (@NonNull Region parentRegion : parentRegions) {
			int parentDepth = getRegionDepth(parentRegion);
			if ((minimumDepthParentRegion == null) || (parentDepth < minimumDepth)) {
				minimumDepthParentRegion = parentRegion;
				minimumDepth = parentDepth;
			}
		}
		return minimumDepthParentRegion;
	}

	protected @NonNull Iterable<@NonNull DatumConnection<?>> getOutgoingConnections(@NonNull Region region) {
		List<@NonNull DatumConnection<?>> outgoingConnections = region2outgoingConnections.get(region);
		assert outgoingConnections != null;
		return outgoingConnections;
	}

	private int getRegionDepth(@NonNull Region region) {
		Integer depth = region2depth.get(region);
		assert depth != null;
		return depth;
	}

	protected @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull DatumConnection<?> connection) {
		List<@NonNull Region> sourceRegions = connection2sourceRegions.get(connection);
		assert sourceRegions != null;
		return sourceRegions;
	}

	protected @NonNull Iterable<@NonNull Region> getTargetRegions(@NonNull DatumConnection<?> connection) {
		List<@NonNull Region> targetRegions = connection2targetRegions.get(connection);
		assert targetRegions != null;
		return targetRegions;
	}

	protected boolean isPassed(@NonNull Region region) {
		return !unpassedRegions.contains(region);
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull Region> list = new ArrayList<>(region2depth.keySet());
		Collections.sort(list, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Region entry : list) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(region2depth.get(entry) + " : " + entry.getName());
		}
		return s.toString();
	}
}