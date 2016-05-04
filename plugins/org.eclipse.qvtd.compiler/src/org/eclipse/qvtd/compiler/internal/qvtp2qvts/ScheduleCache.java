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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * ScheduleCache provides the immutable caches used during the schedule index allocation.
 */
public abstract class ScheduleCache extends Region2Depth
{
	/**
	 * The overall RootScheduledRegion.
	 */
	protected final @NonNull RootScheduledRegion rootScheduledRegion;
	
	/**
	 * All transitively callable regions within the rootScheduledRegion (no OperationRegions).
	 */
	protected final @NonNull List<@NonNull  Region> callableRegions;

	/**
	 * Cached list of all incoming connections per-region; excludes recursions.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull DatumConnection>> region2incomingConnections = new HashMap<@NonNull Region, @NonNull List<@NonNull DatumConnection>>();

	/**
	 * Cached list of all recursive/looping connections per-region.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull DatumConnection>> region2loopingConnections = new HashMap<@NonNull Region, @NonNull List<@NonNull DatumConnection>>();

	/**
	 * Cached list of all outgoing connections per-region; excludes recursions.
	 */
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull DatumConnection>> region2outgoingConnections = new HashMap<@NonNull Region, @NonNull List<@NonNull DatumConnection>>();

	/**
	 * Cached list of all source regions per-connection and whether the source has unserviced content for the connection.
	 */
	private final @NonNull Map<@NonNull DatumConnection, @NonNull List<@NonNull Region>> connection2sourceRegions = new HashMap<@NonNull DatumConnection, @NonNull List<@NonNull Region>>();

	/**
	 * Cached list of all target regions per-connection and whether the connection has unserviced content for the target.
	 */
	private final @NonNull Map<@NonNull DatumConnection, @NonNull List<@NonNull Region>> connection2targetRegions = new HashMap<@NonNull DatumConnection, @NonNull List<@NonNull Region>>();
	
	/**
	 * The regions that have no outgoing passed connections.
	 */
	private final @NonNull Set<@NonNull Region> unpassedRegions = new HashSet<@NonNull Region>();

	protected ScheduleCache(@NonNull RootScheduledRegion rootScheduledRegion) {
		this.rootScheduledRegion = rootScheduledRegion;
		this.callableRegions = analyzeRegions(rootScheduledRegion, new ArrayList<@NonNull Region>());
		Collections.sort(this.callableRegions, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Region region : this.callableRegions) {
			getRegionDepth(region);
		}
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
	}

	/**
	 * Initialize the incoming/looping/outgoing connection analyses of each region
	 */
	private void analyzeConnections(@NonNull Region region) {
		List<@NonNull DatumConnection> incomingConnections = new ArrayList<@NonNull DatumConnection>();
		List<@NonNull DatumConnection> loopingConnections = new ArrayList<@NonNull DatumConnection>();
		List<@NonNull DatumConnection> outgoingConnections = new ArrayList<@NonNull DatumConnection>();
		for (@NonNull DatumConnection connection : region.getIncomingConnections()) {
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
		for (@NonNull DatumConnection connection : region.getNextConnections()) {
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
		for (@NonNull DatumConnection connection : getOutgoingConnections(region)) {
			if (connection.isPassed()) {
				hasPassedConnection = true;
				break;
			}
		}
		if (!hasPassedConnection) {
			unpassedRegions.add(region);
		}
		for (@NonNull DatumConnection connection : getIncomingConnections(region)) {
			List<@NonNull Region> sourceRegions = connection2sourceRegions.get(connection);
			if (sourceRegions == null) {
				sourceRegions = new ArrayList<@NonNull Region>();
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					if (!sourceRegions.contains(sourceRegion)) {
						sourceRegions.add(sourceRegion);
					}
				}
				connection2sourceRegions.put(connection, sourceRegions);
			}
			List<@NonNull Region> targetRegions = connection2targetRegions.get(connection);
			if (targetRegions == null) {
				targetRegions = new ArrayList<@NonNull Region>();
				for (@NonNull Region targetRegion : connection.getTargetRegions()) {
					if (!targetRegions.contains(targetRegion)) {
						targetRegions.add(targetRegion);
					}
				}
				connection2targetRegions.put(connection, targetRegions);
			}
		}
	}

	protected @NonNull Iterable<? extends @NonNull DatumConnection> getConnections() {
		return connection2targetRegions.keySet();
	}

	protected @NonNull Iterable<@NonNull DatumConnection> getIncomingConnections(@NonNull Region region) {
		List<@NonNull DatumConnection> incomingConnections = region2incomingConnections.get(region);
		assert incomingConnections != null;
		return incomingConnections;
	}

	protected @NonNull Iterable<@NonNull DatumConnection> getLoopingConnections(@NonNull Region region) {
		List<@NonNull DatumConnection> loopingConnections = region2loopingConnections.get(region);
		assert loopingConnections != null;
		return loopingConnections;
	}

	protected @NonNull Iterable<@NonNull DatumConnection> getOutgoingConnections(@NonNull Region region) {
		List<@NonNull DatumConnection> outgoingConnections = region2outgoingConnections.get(region);
		assert outgoingConnections != null;
		return outgoingConnections;
	}

	protected @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull DatumConnection connection) {
		List<@NonNull Region> sourceRegions = connection2sourceRegions.get(connection);
		assert sourceRegions != null;
		return sourceRegions;
	}

	protected @NonNull Iterable<@NonNull Region> getTargetRegions(@NonNull DatumConnection connection) {
		List<@NonNull Region> targetRegions = connection2targetRegions.get(connection);
		assert targetRegions != null;
		return targetRegions;
	}

	protected boolean isPassed(@NonNull Region region) {
		return !unpassedRegions.contains(region);
	}
}